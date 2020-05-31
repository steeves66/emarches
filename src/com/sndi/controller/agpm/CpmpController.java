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
import com.sndi.model.TStatut;
import com.sndi.model.VAgpmStatut;
import com.sndi.report.ProjetReportOld;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class CpmpController {
	Logger _logger = Logger.getLogger(CpmpController.class);
	
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
	 private List<TAgpm> objetListe = new ArrayList<TAgpm>();
	 private List<TAgpm> validationListe = new ArrayList<TAgpm>();
	 private List <VAgpmStatut> agpmstatutList = new ArrayList<VAgpmStatut>();
	//Declaration des objets
	private TAgpm slctdTd = new TAgpm();
	 private VAgpmStatut agpmstatut= new VAgpmStatut();
	private String observation="";
	private boolean btnUpdate=false;
	private boolean panelValidation=false;
	private boolean panelSaisie=false;
	 
	//Libellés
		private String libelle="";
		private String libelle1="";
	 
	
	//Redirection en fonction du traitement a éffectuer
		 public String redirectionDynamic(String action) {
			 if(action.equalsIgnoreCase("SAI")) {
				 libelle=("SAISIE D'UN AGPM PAR LE L'AUTORITE CONTRACTANTE");
				 libelle1=("Liste des AGPM Saisie par l'autorité Contractante");
			     panelSaisie=true;
			     panelValidation=false;
			    }else 
			    	if(action.equalsIgnoreCase("VAL")) {
			    		 libelle=("SAISIE D'UN AGPM PAR LE L'AUTORITE CONTRACTANTE");
						 libelle1=("Liste des AGPM Saisie par l'autorité Contractante");
					     panelSaisie=true;
					     panelValidation=false;	
			    	}  			
			return action;
		 }
	 
	//Afficher la liste des AGPM a transmettre dont le statut est S1S(statut par defaut)
	 public void chargeDataSaisie(){
		 getObjetListe().clear();
			objetListe = (List<TAgpm>) iservice.getObjectsByColumnIn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
					"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
					new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					new WhereClause("AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("objetListe size: "+objetListe.size());
	}
	 
	 public void chargeDataAvalider(){
		 getValidationListe().clear();
		 validationListe = (List<TAgpm>) iservice.getObjectsByColumnIn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
					"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
					new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
		 
			_logger.info("validationListe size: "+validationListe.size());
	}
	 
	 
	 
	 
	//Methodes CPMP
	 @Transactional 
		public String transmissionCPMP()throws IOException{
		    slctdTd.setTStatut(new TStatut("S1T"));
			slctdTd.setAgpStatutRetour("0");
			iservice.updateObject(slctdTd);
		 
			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S2V"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Historisation des Agpm
			     THistoAgpm agpmStatut = new THistoAgpm();
			      agpmStatut.setHagDate(Calendar.getInstance().getTime());
			      agpmStatut.setHagMotif("AGPM transmise par le CPMP");
			      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
			      agpmStatut.setTStatut(statuts);
			      agpmStatut.setTAgpm(slctdTd);
				  iservice.addObject(agpmStatut);
				  
				  chargeDataSaisie();
				  userController.setTexteMsg(" Validation effectuée avec succès !");
				  userController.setRenderMsg(true);
				  userController.setSevrityMsg("success");
				 return	null;	
		}
	 
	 
	//METHODE REJETER PAR LE CPMP
		 @Transactional 
			public void rejetCPMP()throws IOException{
			    slctdTd.setTStatut(new TStatut("S2R"));
				slctdTd.setAgpStatutRetour("0");
				iservice.updateObject(slctdTd);
						
						List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S2R"));
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
							  chargeDataAvalider();
								//Message de Confirmation
								 userController.setTexteMsg("Désolé, votre Agpm a été rejeté!");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("warning");
		 }
	 
	 
	//METHODE RETOURNER PAR LA CPMP
		 @Transactional 
			public void differerCPMP()throws IOException{
			    slctdTd.setTStatut(new TStatut("S2D"));
			    slctdTd.setAgpStatutRetour("1");
				iservice.updateObject(slctdTd);
						
						List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S2D"));
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
							  chargeDataAvalider();
								//Message de Confirmation
								 userController.setTexteMsg("Désolé, votre Agpm a été rejeté!");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("warning");
		 }
		 
		 
		 //Methodes CPMP
		 @Transactional 
			public String validerCPMP()throws IOException{
			    slctdTd.setTStatut(new TStatut("S2V"));
				slctdTd.setAgpStatutRetour("0");
				iservice.updateObject(slctdTd);
			 
				List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S2V"));
				TStatut statuts = new TStatut();
				if(!LS.isEmpty()) statuts = LS.get(0);
				  //Historisation des Agpm
				     THistoAgpm agpmStatut = new THistoAgpm();
				      agpmStatut.setHagDate(Calendar.getInstance().getTime());
				      agpmStatut.setHagMotif("Demande Validée par le CPMP");
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
		 
		 
			//Affichage des motifs de retour
			public void chargerObservation() {
				agpmstatutList=(List<VAgpmStatut>) iservice.getObjectsByColumn("VAgpmStatut", new ArrayList<String>(Arrays.asList("HAG_AGP_ID")),
						new WhereClause("HAG_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAgpId()),
						new WhereClause("HAG_STA_CODE",WhereClause.Comparateur.EQ,slctdTd.getTStatut().getStaCode()));
				if(!agpmstatutList.isEmpty()) {
					int i=agpmstatutList.size();
					int baoule=i-1;
					agpmstatut=agpmstatutList.get(baoule);
				}	
			}	
			
			 public String fermer(String value) throws IOException {
				 userController.initMessage();
			     chargeDataSaisie();
				 agpmController.vider();
				 return userController.renderPage(value);
			 }
		 
			
		 
		 
		 public String renderPage(String value) throws IOException{
			    switch(value) {
			    case "cpmp1":
			    	chargeDataAvalider();
				break;
				case "cpmp2":
				break;
				case "cpmp3":
					break;
				case "cpmp4":
					chargeDataSaisie();
					break;
			    }
			    return userController.renderPage(value);
			}



	public List<TAgpm> getObjetListe() {
		return objetListe;
	}



	public void setObjetListe(List<TAgpm> objetListe) {
		this.objetListe = objetListe;
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


	public List<VAgpmStatut> getAgpmstatutList() {
		return agpmstatutList;
	}


	public void setAgpmstatutList(List<VAgpmStatut> agpmstatutList) {
		this.agpmstatutList = agpmstatutList;
	}


	public VAgpmStatut getAgpmstatut() {
		return agpmstatut;
	}


	public void setAgpmstatut(VAgpmStatut agpmstatut) {
		this.agpmstatut = agpmstatut;
	}


	public boolean isBtnUpdate() {
		return btnUpdate;
	}


	public void setBtnUpdate(boolean btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public List<TAgpm> getValidationListe() {
		return validationListe;
	}

	public void setValidationListe(List<TAgpm> validationListe) {
		this.validationListe = validationListe;
	}

	public boolean isPanelValidation() {
		return panelValidation;
	}

	public void setPanelValidation(boolean panelValidation) {
		this.panelValidation = panelValidation;
	}

	public boolean isPanelSaisie() {
		return panelSaisie;
	}

	public void setPanelSaisie(boolean panelSaisie) {
		this.panelSaisie = panelSaisie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle1() {
		return libelle1;
	}

	public void setLibelle1(String libelle1) {
		this.libelle1 = libelle1;
	}	
	 
	 	 

}
