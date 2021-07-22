package com.sndi.controller.numerotation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.sndi.model.TDemande;
import com.sndi.model.TLotAao;
import com.sndi.model.VAaoNumerotation;
import com.sndi.model.VAvisAppelOffreAno;
import com.sndi.model.VLotNumerotation;
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
	 
	//Objet
		 private VAaoNumerotation slctdTd = new VAaoNumerotation();
	 
		 
		 //Liste des lots à numeroter
		 public void chargeLotAnumeroter() {
			 listeLotNumerotation.clear();
			 listeLotNumerotation=(List<VLotNumerotation>) iservice.getObjectsByColumn("VLotNumerotation", new ArrayList<String>(Arrays.asList("LAA_NUM")),
					 new WhereClause("LAA_STA_CODE",WhereClause.Comparateur.EQ,"L3A"),
					new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
			_logger.info("listeLotNumerotation size: "+listeLotNumerotation.size());
		 }
		 
		 
		 public void transmettrePourNumerotation() {
			 if (selectionLotNumerotation.size()<=0) {
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selectionnez au moin un lot", ""));
				}
		 		else{
			 		for(VLotNumerotation ligne : listeLotNumerotation) {
			 			List<TLotAao> LS  = iservice.getObjectsByColumn("TLotAao", 
			 					new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()),
			 					new WhereClause("LAA_NUM",Comparateur.EQ,""+ligne.getLaaNum()));
			 			TLotAao updateLot = new TLotAao();
						if(!LS.isEmpty()) {
							updateLot = LS.get(0);	
							updateLot.setLaaStaCode("LAD");
			 			iservice.updateObject(updateLot);
				     }	
						
						//Mettre l'attribution ATD
						chargeLotAnumeroter();
						userController.setTexteMsg("Transmission éffectuée avec succès !");
				        userController.setRenderMsg(true);
				        userController.setSevrityMsg("success");
			 		}
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
							chargeData("AAO_FON_COD_AC");
						 }else {
							 if(fonct.equalsIgnoreCase("listAutoSaiDmp")) {
					    		  //chargeAvisDmp();
								
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


}
