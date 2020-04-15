package com.sndi.controller.pgpm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAffichagePgpm;
import com.sndi.model.TAgpm;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TDossierPlanGeneral;
import com.sndi.model.TFinancementPgpm;
import com.sndi.model.VAgpmDetails;
import com.sndi.model.VFinancement;
import com.sndi.model.VPgpm;
import com.sndi.model.VPgpmDetails;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;

@Component
@Scope(value="session")
public class EtatsPgpmController {
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	ProjetReport projetReport;
	@Autowired
	 FileUploadController fileUploadController;
	@Autowired
	ControleController controleController;
	 
	@Autowired
	DownloadFileServlet downloadFileServlet;
	
	@PostConstruct
	 public void postConstru()   {
		chargeDetailPgpm();
		chargeFinancement();
		chargeDossier();
		fermerDyn();
	   }
	



	//private List<VPgpm> objetListe = new ArrayList<VPgpm>();
	private List<VPgpmDetails> objetListe = new ArrayList<VPgpmDetails>();
	private TAgpm slctdTb = new TAgpm(); 
	//private VPgpm slctdTd = new VPgpm();
	
	private TAffichagePgpm slctdTd = new TAffichagePgpm();
	
	private VPgpmDetails detail = new VPgpmDetails(); 
	private List<TDossierPlanGeneral> dossListe = new ArrayList<TDossierPlanGeneral>();
	private TDossierPlanGeneral selectedDossier = new TDossierPlanGeneral();
	private List<TFinancementPgpm> financementListe = new ArrayList<TFinancementPgpm>();
	private String page;
	static  String workingDir = "";
	public boolean fermerAC=false;
	public boolean fermerCPMP=false;
	public boolean fermerDMP=false;
	
	
	
	
	
	//Afficher les détails de du projet
		 public void chargeDetailPgpm(){
				objetListe =(List<VPgpmDetails>) iservice.getObjectsByColumn("VPgpmDetails", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
				if (!objetListe.isEmpty()) {
					detail=objetListe.get(0);
				}
			}
	

		   //Afficher les financements du projet ou agpm selectionné
			 public void chargeFinancement() {
				 financementListe.clear();
					 financementListe = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
							 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+detail.getAffGpgId())));		 		 
			 }
	
	
			//Afficher les dossiers du pgpm selectionné
		    public void chargeDossier() {
		  	dossListe.clear();
		  	dossListe = ((List<TDossierPlanGeneral>)iservice.getObjectsByColumn("TDossierPlanGeneral",new ArrayList<String>(Arrays.asList("DPG_NAP_CODE")),
		  	new WhereClause("DPG_GPG_ID",Comparateur.EQ,""+detail.getAffGpgId()))); 		 
		  		 }
		    
		    //Afficher les financements du projet ou agpm selectionné
			 public void chargeFinancementDetail() {
				 financementListe.clear();
				 financementListe = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
							 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+slctdTd.getAffGpgId())));		 		 
			 }
	
	        //Ouverture d'un dossier chargé
		     public void openDossier() throws IOException{
				 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDpgLibelle(), selectedDossier.getDpgLibelle());
				   }
		     
		     //Suppression d'un dossier
		     public void removeDossier(){
					downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDpgLibelle(), selectedDossier.getDpgLibelle());
					//check si le dossier est OM
					 iservice.deleteObject(selectedDossier);
					 chargeDossier();	 
					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDpgLibelle()+" supprimé!", "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
		     
		     
		    
		     public String fermer(String value) throws IOException {
				 return userController.renderPage(value);
			 }
		     
		     
		     
		     
		     public String renderPage(String value,String action) throws IOException{
		    	 controleController.redirectionDynamicProcedures(action);
		  		switch(value) {
		  		case "pgpm3":
		  			chargeDetailPgpm();
		  			chargeFinancement();
		  			chargeFinancementDetail();
		  			chargeDossier();
		  		break;
		  		
		  		}
		  		
		  		return userController.renderPage(value);
		  	}
		     
		     
		     
		   //Edition du PGPM Detail
			 public void imprimerPgpmDet() {
				 //String operateur = userController.getSlctd().getTFonction().getFonCod();
				 //projetReport.longStringparam2(detail.getPlgId(), operateur, "Pgpm", "Pgpm");
					projetReport.longparam1(detail.getAffGpgId(), "Fiche_pgpm", "Fiche_pgpm");
				}
			 
			 //Edition du PGSPM Detail
			 public void imprimerPgspmDet() {
				 projetReport.longparam1(detail.getAffGpgId(), "Fiche_pgspm", "Fiche_pgspm");
				  //projetReport.longparam1(detail.getPlgId(), "Pgspm", "Pgspm");
				}
	
	
	
			 public void fermerDyn() {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						fermerAC=true;
						fermerCPMP=false;
						fermerDMP=false;
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
						 fermerAC=false;
							fermerCPMP= true;
							fermerDMP=false;
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
							 fermerAC=false;
								fermerCPMP=false;
								fermerDMP=true;
						 }	 
					 } 
				 } 
			 }
	
	
	
	
	



	


	public List<VPgpmDetails> getObjetListe() {
				return objetListe;
			}


			public void setObjetListe(List<VPgpmDetails> objetListe) {
				this.objetListe = objetListe;
			}


			public VPgpmDetails getDetail() {
				return detail;
			}


			public void setDetail(VPgpmDetails detail) {
				this.detail = detail;
			}


	public TDossierPlanGeneral getSelectedDossier() {
		return selectedDossier;
	}


	public void setSelectedDossier(TDossierPlanGeneral selectedDossier) {
		this.selectedDossier = selectedDossier;
	}


	public List<TDossierPlanGeneral> getDossListe() {
		return dossListe;
	}


	public void setDossListe(List<TDossierPlanGeneral> dossListe) {
		this.dossListe = dossListe;
	}


	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}


	public TAgpm getSlctdTb() {
		return slctdTb;
	}


	public void setSlctdTb(TAgpm slctdTb) {
		this.slctdTb = slctdTb;
	}

/*
	public VPgpm getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(VPgpm slctdTd) {
		this.slctdTd = slctdTd;
	}*/
	

	public TAffichagePgpm getSlctdTd() {
		return slctdTd;
	}


	public void setSlctdTd(TAffichagePgpm slctdTd) {
		this.slctdTd = slctdTd;
	}
	


	public List<TFinancementPgpm> getFinancementListe() {
		return financementListe;
	}


	public void setFinancementListe(List<TFinancementPgpm> financementListe) {
		this.financementListe = financementListe;
	}
	
	

	public boolean isFermerAC() {
		return fermerAC;
	}

	public void setFermerAC(boolean fermerAC) {
		this.fermerAC = fermerAC;
	}




	public boolean isFermerCPMP() {
		return fermerCPMP;
	}

	public void setFermerCPMP(boolean fermerCPMP) {
		this.fermerCPMP = fermerCPMP;
	}




	public boolean isFermerDMP() {
		return fermerDMP;
	}


	public void setFermerDMP(boolean fermerDMP) {
		this.fermerDMP = fermerDMP;
	}
	
	

}
