package com.sndi.controller.agpm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.sndi.controller.custom.ControleController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAgpm;
import com.sndi.model.THistoAgpm;
import com.sndi.model.TOperateur;
import com.sndi.model.TStatut;
import com.sndi.report.ProjetReportOld;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class DmpController {
	Logger _logger = Logger.getLogger(DmpController.class);
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	KeyGen keyGen;
	 @Autowired
	ProjetReportOld projetReport;
	 @Autowired
	ControleController controleController;
	 @Autowired
	FileUploadController fileUploadController;
	 
	 @Autowired
	 DownloadFileServlet downloadFileServlet;
	 
	 @Autowired
	 AgpmController agpmController;
	 
	 
	 @PostConstruct
	 public void postContr() {
		 chargeDataSaisie();
		 chargeDataAvalider();
	 }
	 
	 

	//Declaration des listes
	 private List<TAgpm> saisieListe = new ArrayList<TAgpm>();
	 private List<TAgpm> validationListe = new ArrayList<TAgpm>();
	 //Declaration des objets
	 private TAgpm slctdTd = new TAgpm();
	 private String observation="";
	 
	 
	 
	 
	 
	//Afficher la liste des AGPM a transmettre dont le statut est S1S(statut par defaut)
	 public void chargeDataSaisie(){
			 getSaisieListe().clear();
				saisieListe = (List<TAgpm>) iservice.getObjectsByColumnIn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S3D")),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					_logger.info("objetListe size: "+saisieListe.size());
		}
	 public void chargeDataAvalider(){
		 getValidationListe().clear();
			validationListe = (List<TAgpm>) iservice.getObjectsByColumnIn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
					"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V")),
					new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
				_logger.info("objetListe size: "+validationListe.size());
			
	}
	 
	 
	 @Transactional 
		public String transmissionDMP()throws IOException{
		    slctdTd.setTStatut(new TStatut("S2V"));
			slctdTd.setAgpStatutRetour("0");
			iservice.updateObject(slctdTd);
		 
			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S2V"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Historisation des Agpm
			     THistoAgpm agpmStatut = new THistoAgpm();
			      agpmStatut.setHagDate(Calendar.getInstance().getTime());
			      agpmStatut.setHagMotif("AGPM transmise par le DMP");
			      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
			      agpmStatut.setTStatut(statuts);
			      agpmStatut.setTAgpm(slctdTd);
				  iservice.addObject(agpmStatut);
				  
				  chargeDataSaisie();
				  userController.setTexteMsg(" Transmission effectuée avec succès !");
				  userController.setRenderMsg(true);
				  userController.setSevrityMsg("success");
				 return	null;	
		}
	 
	 
	 
	 public String fermer(String value) throws IOException {
		 userController.initMessage();
	     chargeDataSaisie();
		 agpmController.vider();
		 return userController.renderPage(value);
	 }
 
	//METHODE RETOURNER PAR LE DMP
	 @Transactional 
		public void differerDMP()throws IOException{
		   slctdTd.setTStatut(new TStatut("S3D"));
			slctdTd.setAgpStatutRetour("1");
			iservice.updateObject(slctdTd);
					
					List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S3D"));
					TStatut statuts = new TStatut();
					if(!LS.isEmpty()) statuts = LS.get(0);
					  //Historisation des Agpm
					     THistoAgpm agpmStatut = new THistoAgpm();
					      agpmStatut.setHagDate(Calendar.getInstance().getTime());
					      agpmStatut.setHagMotif(getObservation());
					      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
					      agpmStatut.setTStatut(statuts);
					      agpmStatut.setTAgpm(slctdTd);
						  iservice.addObject(agpmStatut);
						  //Methode de chargement de la liste à remplacer
						   chargeDataSaisie();
							//Message de Confirmation
							 userController.setTexteMsg("Désolé, votre Agpm a été rejeté!");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("warning");
	 }
	 
	 
	 
	//METHODE REJETER PAR LE DMP
	 @Transactional 
		public void rejetDMP()throws IOException{
		    slctdTd.setTStatut(new TStatut("S3R"));
			slctdTd.setAgpStatutRetour("0");
			iservice.updateObject(slctdTd);
					
					List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S3R"));
					TStatut statuts = new TStatut();
					if(!LS.isEmpty()) statuts = LS.get(0);
					  //Historisation des Agpm
					     THistoAgpm agpmStatut = new THistoAgpm();
					      agpmStatut.setHagDate(Calendar.getInstance().getTime());
					      agpmStatut.setHagMotif(getObservation());
					      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
					      agpmStatut.setTStatut(statuts);
					      agpmStatut.setTAgpm(slctdTd);
						  iservice.addObject(agpmStatut);
					
						  //Methode de chargement de la liste à remplacer
						  chargeDataSaisie();
							//Message de Confirmation
							 userController.setTexteMsg("Désolé, votre Agpm a été rejeté!");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("warning");
	 }
	 
	 
	 
	 //Methodes Directeur
	 @Transactional 
		public String validerDMP()throws IOException{
		    slctdTd.setTStatut(new TStatut("S3V"));
			slctdTd.setAgpStatutRetour("0");
			iservice.updateObject(slctdTd);
		 
			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S3V"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Historisation des Agpm
			     THistoAgpm agpmStatut = new THistoAgpm();
			      agpmStatut.setHagDate(Calendar.getInstance().getTime());
			      agpmStatut.setHagMotif("Demande Validéé par le DMP");
			      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
			      agpmStatut.setTStatut(statuts);
			      agpmStatut.setTAgpm(slctdTd);
				  iservice.addObject(agpmStatut);
				  
				  chargeDataAvalider();
				  userController.setTexteMsg(" Validation effectuée avec succès !");
				  userController.setRenderMsg(true);
				  userController.setSevrityMsg("success");
				 return	null;	
		}
	 

	 
	 public String renderPage(String value) throws IOException{
		    switch(value) {
		    case "dmp1":
		    	chargeDataAvalider();
			break;
			case "dmp2":
			break;
			case "dmp3":
				break;
			case "dmp4":
				chargeDataSaisie();
				break;
		    }
		    return userController.renderPage(value);
		}
	 
	 
	 
	 
	 
	 
	 


		public TAgpm getSlctdTd() {
			return slctdTd;
		}


		public void setSlctdTd(TAgpm slctdTd) {
			this.slctdTd = slctdTd;
		}



		public String getObservation() {
			return observation;
		}



		public void setObservation(String observation) {
			this.observation = observation;
		}
		public List<TAgpm> getSaisieListe() {
			return saisieListe;
		}
		public void setSaisieListe(List<TAgpm> saisieListe) {
			this.saisieListe = saisieListe;
		}
		public List<TAgpm> getValidationListe() {
			return validationListe;
		}
		public void setValidationListe(List<TAgpm> validationListe) {
			this.validationListe = validationListe;
		}
		
		 
}
