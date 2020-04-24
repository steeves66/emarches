package com.sndi.controller.demande;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.dao.WhereClause;
import com.sndi.model.TAffichageAgpm;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TDemande;
import com.sndi.model.TStatut;
import com.sndi.model.VFonctionMinistere;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class DemandeController {
	Logger _logger = Logger.getLogger(DemandeController.class);
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	KeyGen keyGen;
	 @Autowired
	ProjetReport projetReport;
	 @Autowired
	FileUploadController fileUploadController;
	 
	 @Autowired
	 DownloadFileServlet downloadFileServlet;
	@Autowired
	ControleController controleController;
	
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
	 }
	 
	 //Déclaration des listes
	 private List<TDemande> listeDemandes = new ArrayList<TDemande>();
	 
	 //Déclaration des Objets
	 private TDemande slctdTd = new TDemande();
	
	public String renderPage(String value ,String action) throws IOException{ 
		controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "dem1":
					String fonct = controleController.getFonctionalite();	
					String statutAffiche = "";
					String statutDiffere = "";
					//Ramener le statut en fonction de l'utilisateur connecté et de l'action a mener
					if(fonct.equalsIgnoreCase("listSaisieAc")) {
						statutAffiche = "E1S";
						statutDiffere = "E2D";
						_logger.info("staut: "+statutAffiche);	
						_logger.info("staut: "+statutDiffere);
						_logger.info("fonctionalité: "+fonct);	
						_logger.info("value: "+value+" action: "+action);
					 }else {
						 if(fonct.equalsIgnoreCase("listValidationCpmp")) {
							 statutAffiche = "E1T";	
							 statutDiffere = "E3D";
								_logger.info("staut: "+statutAffiche);
								_logger.info("staut: "+statutDiffere);
								_logger.info("fonctionalité: "+fonct);	
								_logger.info("value: "+value+" action: "+action);
						 }else {
							 if(fonct.equalsIgnoreCase("listValidationSPD")) {
								 statutAffiche = "E2V";	
								 statutDiffere = "D2T";
									_logger.info("staut: "+statutAffiche);	
									_logger.info("staut: "+statutDiffere);
									_logger.info("fonctionalité: "+fonct);	
									_logger.info("value: "+value+" action: "+action);
							 }else {
								 if(fonct.equalsIgnoreCase("listValidationDmp")) {
									 statutAffiche = "D2T";	 
								 }else {
									 if(fonct.equalsIgnoreCase("listValidationDmp")) {
										// statutAffiche = "D2T";	
									 }
								 }
							 }	 
						 }
					 }
					//Chargement de la liste des demandes
					chargeData(statutAffiche,statutDiffere);
					break;
				case "dem2":
					
				break;
				case "dem3":
				break;
				
				case "dem4":
					break;

			    }
		     
		    return userController.renderPage(value);
		}
	//methode Chargement de la liste des demandes
	public void chargeData(String statutAffiche, String statutDiffere) {
		listeDemandes.clear();	
		listeDemandes = (List<TDemande>) iservice.getObjectsByColumnInDesc("TDemande", new ArrayList<String>(Arrays.asList("DEM_DTE_SAISI")),
				"DEM_STA_CODE", new ArrayList<String>(Arrays.asList(""+statutAffiche,""+statutDiffere)),
				//new WhereClause("DEM_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
               new WhereClause("DEM_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	}
	
	
	public void valider() {
		String statUpdate = "";
		String message = "";
		if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E1S")) {
			statUpdate = "E1T";
			message="Transmission de la démande N°"+slctdTd.getDemNum()+"éffectuée avec succès";
			chargeData("E1T","E2D");
			
		 }else {
			 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E1T")) {
					statUpdate = "E2V";
					chargeData("E2V","E3D");
					message="Prévalidation de la démande N°"+slctdTd.getDemNum()+"éffectuée avec succès";
			 }else {
				 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E2V")) {
					 statUpdate = "E3V";
					 chargeData("E3V","E3V");
					 message="Validation de la démande N°"+slctdTd.getDemNum()+"éffectuée avec succès";
				 }else {
					 
				 }	 
			 }

		 }
		
		slctdTd.setTStatut(new TStatut(statUpdate));	
		iservice.updateObject(slctdTd);
		userController.setTexteMsg(message);
		userController.setRenderMsg(true);
		userController.setSevrityMsg("success");
		
	}

	public List<TDemande> getListeDemandes() {
		return listeDemandes;
	}

	public void setListeDemandes(List<TDemande> listeDemandes) {
		this.listeDemandes = listeDemandes;
	}
	public TDemande getSlctdTd() {
		return slctdTd;
	}
	public void setSlctdTd(TDemande slctdTd) {
		this.slctdTd = slctdTd;
	}
	 
}
