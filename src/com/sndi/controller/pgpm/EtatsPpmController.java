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
import com.sndi.model.TAffichagePpm;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TFinancementPpm;
import com.sndi.model.VPpmDetails;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;

@Component
@Scope(value="session")
public class EtatsPpmController {
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	ProjetReport projetReport;
	 @Autowired
	ControleController controleController;
	@Autowired
	 FileUploadController fileUploadController;
	 
	@Autowired
	DownloadFileServlet downloadFileServlet;
	
	@PostConstruct
	 public void postConstru()   {
		chargeDetailPpm();
		chargeDetailFinancement();
		fermerDyn();
	   }
	
	
	
	private List<VPpmDetails> objetListe = new ArrayList<VPpmDetails>(); 
	private TAffichagePpm slctdTd = new TAffichagePpm();
	private VPpmDetails detail = new VPpmDetails(); 
	private List<TFinancementPpm> financementListe = new ArrayList<TFinancementPpm>();
	private List<TDossierAgpm> dossListe = new ArrayList<TDossierAgpm>();
	private TDossierAgpm selectedDossier = new TDossierAgpm();

	private String page;
	static  String workingDir = "";
	public boolean fermerAC=false;
	public boolean fermerCPMP=false;
	public boolean fermerDMP=false;
	
	
	
	//Afficher les d�tails du ppm
		 public void chargeDetailPpm(){
				objetListe =(List<VPpmDetails>) iservice.getObjectsByColumn("VPpmDetails", new ArrayList<String>(Arrays.asList("DPP_ID")),
						new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffDppId()));
				if (!objetListe.isEmpty()) {
					detail=objetListe.get(0);
				}
			}
		 
		//Afficher les d�tails de du pspm
		 public void chargeDetailPspm(){
				objetListe =(List<VPpmDetails>) iservice.getObjectsByColumn("VPpmDetails", new ArrayList<String>(Arrays.asList("DPP_ID")),
						new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffDppId()));
				if (!objetListe.isEmpty()) {
					detail=objetListe.get(0);
				}
			}
		 
		 
		 
		//Afficher les d�tails du financement
		 public void chargeDetailFinancement(){
			 financementListe =(List<TFinancementPpm>) iservice.getObjectsByColumn("TFinancementPpm", new ArrayList<String>(Arrays.asList("FPP_ID")),
						new WhereClause("FPP_DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffDppId()));
				
			}
		 
		 
		 
		 //Ouverture d'un dossier charg�
	     public void openDossier() throws IOException{
			// downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDpgLibelle(), selectedDossierPc.getDpgLibelle());
			   }
	          
	   //Suppression d'un dossier
	     public void removeDossierPc(){
				//downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDpgLibelle(), selectedDossierPc.getDpgLibelle());
				//check si le dossier est OM
				 iservice.deleteObject(selectedDossier);
				 //chargeDossierPc();	 
				// FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDpgLibelle()+" supprim�!", "");
					//FacesContext.getCurrentInstance().addMessage(null, msg);
				}
	
	
	
	
	
	
	
	 public String fermer(String value) throws IOException {
		 return userController.renderPage(value);
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
     
     
    /* public void imprimerPpmDet() {
    	 projetReport.longparam1(detail.getDppPlpId(), "Ppm", "Ppm");
     }*/ 
     
     public void imprimerPpmDet() {
    	 String operateur = userController.getSlctd().getTFonction().getFonCod();
    	 projetReport.longStringparam2(slctdTd.getTPlanPassation().getPlpId(), operateur, "Ppm", "Ppm");
     }
     
     
     public void imprimerPspmDet() {
    	 
    	 if(detail.getMopCode().equalsIgnoreCase("PSO")) {
    		 String operateur = userController.getSlctd().getTFonction().getFonCod();
    		 projetReport.longStringparam2(detail.getDppPlpId(), operateur, "Pspm_pso", "Pspm_pso");
    	 }else 
    		 if(detail.getMopCode().equalsIgnoreCase("PSL")) {
    			 String operateur = userController.getSlctd().getTFonction().getFonCod();
    		 projetReport.longStringparam2(detail.getDppPlpId(), operateur, "Pspm_psl", "Pspm_psl");
    	 }else 
    		 if(detail.getMopCode().equalsIgnoreCase("PSC")) {
    			 String operateur = userController.getSlctd().getTFonction().getFonCod();
    			 projetReport.longStringparam2(detail.getDppPlpId(), operateur, "Pspm_psc", "Pspm_psc");
    		 }
      }
     
     
     
     
     
	  public String renderPage(String value,String action) throws IOException{
		  controleController.redirectionDynamicProcedures(action);
	 		switch(value) {
	 		case "ppm3":
	 			chargeDetailPpm();
	 			chargeDetailFinancement();
	  		break;
	  		
	 		case "pspm3":
	 			chargeDetailPpm();
	 			chargeDetailFinancement();
	  		break;
	 		}
	 		
	 		return userController.renderPage(value);
	 	}



	  
	  

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
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
	
	public List<TDossierAgpm> getDossListe() {
		return dossListe;
	}
	public void setDossListe(List<TDossierAgpm> dossListe) {
		this.dossListe = dossListe;
	}
	public TDossierAgpm getSelectedDossier() {
		return selectedDossier;
	}
	public void setSelectedDossier(TDossierAgpm selectedDossier) {
		this.selectedDossier = selectedDossier;
	}

	public List<VPpmDetails> getObjetListe() {
		return objetListe;
	}
	public void setObjetListe(List<VPpmDetails> objetListe) {
		this.objetListe = objetListe;
	}
	public TAffichagePpm getSlctdTd() {
		return slctdTd;
	}
	public void setSlctdTd(TAffichagePpm slctdTd) {
		this.slctdTd = slctdTd;
	}
	public VPpmDetails getDetail() {
		return detail;
	}
	public void setDetail(VPpmDetails detail) {
		this.detail = detail;
	}
	public List<TFinancementPpm> getFinancementListe() {
		return financementListe;
	}
	public void setFinancementListe(List<TFinancementPpm> financementListe) {
		this.financementListe = financementListe;
	}
	

}
