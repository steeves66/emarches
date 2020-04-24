package com.sndi.controller.demande;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.dao.WhereClause;
import com.sndi.model.TAffichageAgpm;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TDemande;
import com.sndi.model.TStatut;
import com.sndi.model.TTypeDemande;
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
	 
	 //D�claration des listes
	 private List<TDemande> listeDemandes = new ArrayList<TDemande>();
	 private List<TTypeDemande> listeTypeDemandes = new ArrayList<TTypeDemande>();
	 
	 //D�claration des Objets
	 private TDemande slctdTd = new TDemande();
	
	//D�claration des Variables
	 private String tdmCode ="";
	 private boolean panelRestreint =false;
	 private boolean panelGreAgre =false;
	 private boolean panelAvenant =false;
	 
	 public String onFlowProcess(FlowEvent event) throws IOException {
		 System.out.println("etape old= "+event.getOldStep()+" New= "+event.getNewStep());
		 return event.getNewStep();
	    }
	 
	 
	 
	 //Methode de chargement des types de demande
	 public void chargeTypeDemande() {
		 listeTypeDemandes.clear();
		/* listeTypeDemandes = (List<TTypeDemande>) iservice.getObjectsByColumn("TTypeDemande", new ArrayList<String>(Arrays.asList("TDM_LIBELLE")));
		_logger.info("listeTypeDemandes size: "+listeTypeDemandes.size());*/
		
		listeTypeDemandes = (List<TTypeDemande>) iservice.getObjectsByColumnIn("TTypeDemande", new ArrayList<String>(Arrays.asList("TDM_LIBELLE")),
				"TDM_CODE", new ArrayList<String>(Arrays.asList("AOR","GAG","AVE")),
               new WhereClause("TDM_CODE",WhereClause.Comparateur.NEQ,"PSL"));
		_logger.info("listeTypeDemandes size: "+listeTypeDemandes.size());
		
	 }
	 //Methode de chargement 
	 public void chargeListBytype() {
		 if(tdmCode.equalsIgnoreCase("AOR")) {
			 panelRestreint =true;
			 panelGreAgre =false;
			 panelAvenant =false; 
		 }else
			 if(tdmCode.equalsIgnoreCase("GAG")) {
				 panelRestreint =false;
				 panelGreAgre =true;
				 panelAvenant =false;  
			 }else
				 if(tdmCode.equalsIgnoreCase("AVE")) {
					 panelRestreint =false;
					 panelGreAgre =false;
					 panelAvenant =true; 
				 }
	 }
	public String renderPage(String value ,String action) throws IOException{ 
		controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "dem1":
					tdmCode="";
					String fonct = controleController.getFonctionalite();	
					String statutAffiche = "";
					String statutDiffere = "";
					//Ramener le statut en fonction de l'utilisateur connect� et de l'action a mener
					if(fonct.equalsIgnoreCase("listSaisieAc")) {
						statutAffiche = "E1S";
						statutDiffere = "E2D";
						_logger.info("staut: "+statutAffiche);	
						_logger.info("staut: "+statutDiffere);
						_logger.info("fonctionalit�: "+fonct);	
						_logger.info("value: "+value+" action: "+action);
					 }else {
						 if(fonct.equalsIgnoreCase("listValidationCpmp")) {
							 statutAffiche = "E1T";	
							 statutDiffere = "E3D";
								_logger.info("staut: "+statutAffiche);
								_logger.info("staut: "+statutDiffere);
								_logger.info("fonctionalit�: "+fonct);	
								_logger.info("value: "+value+" action: "+action);
						 }else {
							 if(fonct.equalsIgnoreCase("listValidationSPD")) {
								 statutAffiche = "E2V";	
								 statutDiffere = "D2T";
									_logger.info("staut: "+statutAffiche);	
									_logger.info("staut: "+statutDiffere);
									_logger.info("fonctionalit�: "+fonct);	
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
					chargeTypeDemande();
					chargeListBytype();
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
			message="Transmission de la d�mande N�"+slctdTd.getDemNum()+"�ffectu�e avec succ�s";
			chargeData("E1T","E2D");
			
		 }else {
			 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E1T")) {
					statUpdate = "E2V";
					chargeData("E2V","E3D");
					message="Pr�validation de la d�mande N�"+slctdTd.getDemNum()+"�ffectu�e avec succ�s";
			 }else {
				 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E2V")) {
					 statUpdate = "E3V";
					 chargeData("E3V","E3V");
					 message="Validation de la d�mande N�"+slctdTd.getDemNum()+"�ffectu�e avec succ�s";
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

	public List<TTypeDemande> getListeTypeDemandes() {
		return listeTypeDemandes;
	}

	public void setListeTypeDemandes(List<TTypeDemande> listeTypeDemandes) {
		this.listeTypeDemandes = listeTypeDemandes;
	}

	public String getTdmCode() {
		return tdmCode;
	}

	public void setTdmCode(String tdmCode) {
		this.tdmCode = tdmCode;
	}



	public boolean isPanelRestreint() {
		return panelRestreint;
	}



	public void setPanelRestreint(boolean panelRestreint) {
		this.panelRestreint = panelRestreint;
	}



	public boolean isPanelGreAgre() {
		return panelGreAgre;
	}



	public void setPanelGreAgre(boolean panelGreAgre) {
		this.panelGreAgre = panelGreAgre;
	}



	public boolean isPanelAvenant() {
		return panelAvenant;
	}



	public void setPanelAvenant(boolean panelAvenant) {
		this.panelAvenant = panelAvenant;
	}
	 
}
