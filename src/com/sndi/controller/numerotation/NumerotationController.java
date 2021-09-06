package com.sndi.controller.numerotation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.commission.AnoController;
import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAttributions;
import com.sndi.model.TDemande;
import com.sndi.model.TLotAao;
import com.sndi.model.TStatut;
import com.sndi.model.VAaoNumerotation;
import com.sndi.model.VAvisAppelOffreAno;
import com.sndi.model.VLotNumerotation;
import com.sndi.model.VbAttribMarche;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class NumerotationController {
Logger _logger = Logger.getLogger(AnoController.class);
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	KeyGen keyGen;
	 @Autowired
	ProjetReport projetReport;
	 @Autowired
	ControleController controleController;
	 @Autowired
	FileUploadController fileUploadController;
	 
	 @Autowired
	 DownloadFileServlet downloadFileServlet;
	 
	 @Autowired
	 TableauBordController tableauBordController;
	 
	 //liste
	 private List<VAaoNumerotation> listeAvisAppelOffre = new ArrayList<VAaoNumerotation>();
	 private List<VLotNumerotation> listeLotNumerotation = new ArrayList<VLotNumerotation>();
	 private List<VLotNumerotation> selectionLotNumerotation= new ArrayList<VLotNumerotation>();
	 
	 private String critere="";
	 
	 
	//Objet
		 private VAaoNumerotation slctdTd = new VAaoNumerotation();
	 
		 
		 //Liste des lots à numeroter
		 public void chargeLotAnumeroter() {
			 listeLotNumerotation.clear();
			 listeLotNumerotation=(List<VLotNumerotation>) iservice.getObjectsByColumnDesc("VLotNumerotation", new ArrayList<String>(Arrays.asList("ATT_DTE_SAISI")),
					 new WhereClause("ATT_FON_CODE_SAISI",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					 new WhereClause("ATT_STA_CODE",Comparateur.EQ,"ATS"),
					 new WhereClause("MAR_DEJA_NUMEROTE",Comparateur.EQ,"1"));
			_logger.info("listeLotNumerotation size: "+listeLotNumerotation.size());
		 }
		 
		 
		 //Liste des lots à numeroter
		 public void chargeLotAnumeroterFilter() {
			 listeLotNumerotation.clear();
			 if(controleController.getFonctionalite().equalsIgnoreCase("listNumerotationAc")) {
				 listeLotNumerotation=(List<VLotNumerotation>) iservice.getObjectsByColumnDesc("VLotNumerotation", new ArrayList<String>(Arrays.asList("ATT_DTE_SAISI")),
						 new WhereClause("ATT_FON_CODE_SAISI",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						 new WhereClause("ATT_STA_CODE",Comparateur.EQ,"ATS"),
						 new WhereClause("MAR_DEJA_NUMEROTE",Comparateur.EQ,"1"),
						 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+critere+"%"));
			 }else
				 if(controleController.getFonctionalite().equalsIgnoreCase("listDejaNumeroteAc")) {
					 listeLotNumerotation=(List<VLotNumerotation>) iservice.getObjectsByColumnDesc("VLotNumerotation", new ArrayList<String>(Arrays.asList("ATT_DTE_SAISI")),
							 new WhereClause("ATT_FON_CODE_SAISI",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
							 new WhereClause("ATT_STA_CODE",Comparateur.EQ,"ATD"),
							 new WhereClause("MAR_DEJA_NUMEROTE",Comparateur.EQ,"2"),
							 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+critere+"%")); 
				 }
			
			_logger.info("listeLotNumerotation size: "+listeLotNumerotation.size());
		 }
		 
		 
		 //Liste des lots deja numeroté
		 public void chargeLotDejaNumerote() {
			 listeLotNumerotation.clear();
			 listeLotNumerotation=(List<VLotNumerotation>) iservice.getObjectsByColumnDesc("VLotNumerotation", new ArrayList<String>(Arrays.asList("ATT_DTE_SAISI")),
					 new WhereClause("ATT_FON_CODE_SAISI",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					 new WhereClause("ATT_STA_CODE",Comparateur.EQ,"ATD"),
					 new WhereClause("MAR_DEJA_NUMEROTE",Comparateur.EQ,"2"));
			_logger.info("listeLotNumerotation size: "+listeLotNumerotation.size());
		 }
		 
		 public void chargeLotDejaNumeroteFilter() {
			 listeLotNumerotation.clear();
			 listeLotNumerotation=(List<VLotNumerotation>) iservice.getObjectsByColumnDesc("VLotNumerotation", new ArrayList<String>(Arrays.asList("ATT_DTE_SAISI")),
					 new WhereClause("ATT_FON_CODE_SAISI",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					 new WhereClause("ATT_STA_CODE",Comparateur.EQ,"ATD"),
					 new WhereClause("MAR_DEJA_NUMEROTE",Comparateur.EQ,"2"),
					 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+critere+"%"));
			_logger.info("listeLotNumerotation size: "+listeLotNumerotation.size());
		 }
		 
		 public void reinitialiserLotNumerotation() {
			 if(controleController.getFonctionalite().equalsIgnoreCase("listNumerotationAc")) {
				 chargeLotAnumeroter();
			 }else
				 if(controleController.getFonctionalite().equalsIgnoreCase("listDejaNumeroteAc")) {
					 chargeLotDejaNumerote();
				 }
		 }
		 
		
		 
		 public void transmettrePourNumerotation() {
			 if (selectionLotNumerotation.size()<=0) {
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selectionnez au moin un lot", ""));
				}
		 		else{
			 		/*
			 		 * Mise a jour directement dans la table t_attribution
			 		 for(VLotNumerotation ligne : selectionLotNumerotation) {
			 			List<TAttributions> LS  = iservice.getObjectsByColumn("TAttributions", 
			 					new WhereClause("ATT_NUM",Comparateur.EQ,""+ligne.getAttNum()));
			 			TAttributions updateAttrib = new TAttributions();
						if(!LS.isEmpty()) {
							updateAttrib = LS.get(0);	
							updateAttrib.setTStatut(new TStatut("ATD"));
			 			iservice.updateObject(updateAttrib);*/
		 			
			 			//Enregistrement dans le temps VbAttribMarche
			 			for(VLotNumerotation ligne : selectionLotNumerotation) {
			 				VbAttribMarche attribMarche = new VbAttribMarche();
			 				attribMarche.setAtmAttNum(ligne.getAttNum());
			 				attribMarche.setAtmDteSaisie(Calendar.getInstance().getTime());
			 				attribMarche.setAtmFonCode(userController.getSlctd().getTFonction().getFonCod());
			 				attribMarche.setAtmOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
			 				attribMarche.setAtmStaCode("ATD");
			 			iservice.addObject(attribMarche);
				     }	
						
		 			
						
						//Mettre l'attribution ATD
						chargeLotAnumeroter();
						userController.setTexteMsg("Transmission éffectuée avec succès !");
				        userController.setRenderMsg(true);
				        userController.setSevrityMsg("success");
			 		}
		         
		 }
		 
		 
	//Chargement de la liste des avis d'appel d'offres en attente d'ano
		 public void chargeData(String colonne) {
			 listeAvisAppelOffre.clear();
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 listeAvisAppelOffre = (List<VAaoNumerotation>) iservice.getObjectsByColumnDesc("VAaoNumerotation", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
							 new WhereClause(""+colonne,WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					_logger.info("listeAppelOffre size: "+listeAvisAppelOffre.size());	
						 }
		      }
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "num1":
					//Ramener le statut en fonction de l'utilisateur connecté et de l'action a mener
						userController.initMessage();
						String fonct = controleController.getFonctionalite();	
						String statutAffiche = "";
						//String statutDiffere = "";
						String colonneFonction ="";
						String colonneFonctionAno ="";
						
						
						if(fonct.equalsIgnoreCase("listNumerotationAc")) {
							_logger.info("fonctionalité: "+fonct);	
							_logger.info("value: "+value+" action: "+action);
							//chargeData("AAO_FON_COD_AC");
							chargeLotAnumeroter();
						 }else {
							 if(fonct.equalsIgnoreCase("listDejaNumeroteAc")) {
								 //Lots deja numerote.
								 chargeLotDejaNumerote();
								
							 }else {
								 if(fonct.equalsIgnoreCase("listDemAnoDmp")) {
									 //chargeDemandeDmp();
								 }else {
									
								 }	 
							 }
						 }
						
					break;
				case "num2":
				
					break;
					
			    }
   
		    return userController.renderPage(value);   
		    
		}
	public VAaoNumerotation getSlctdTd() {
		return slctdTd;
	}
	public void setSlctdTd(VAaoNumerotation slctdTd) {
		this.slctdTd = slctdTd;
	}
	public List<VAaoNumerotation> getListeAvisAppelOffre() {
		return listeAvisAppelOffre;
	}
	public void setListeAvisAppelOffre(List<VAaoNumerotation> listeAvisAppelOffre) {
		this.listeAvisAppelOffre = listeAvisAppelOffre;
	}


	public List<VLotNumerotation> getListeLotNumerotation() {
		return listeLotNumerotation;
	}


	public void setListeLotNumerotation(List<VLotNumerotation> listeLotNumerotation) {
		this.listeLotNumerotation = listeLotNumerotation;
	}


	public List<VLotNumerotation> getSelectionLotNumerotation() {
		return selectionLotNumerotation;
	}


	public void setSelectionLotNumerotation(List<VLotNumerotation> selectionLotNumerotation) {
		this.selectionLotNumerotation = selectionLotNumerotation;
	}


	public String getCritere() {
		return critere;
	}


	public void setCritere(String critere) {
		this.critere = critere;
	}


}
