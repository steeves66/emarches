package com.sndi.controller.agpm;

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

import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAffichageAgpm;
import com.sndi.model.TAgpm;
import com.sndi.model.TDetailAgpm;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TFinancement;
import com.sndi.model.VAgpmDetails;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;

@Component
@Scope(value="session")
public class EtatsAgpmController {
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	ProjetReport projetReport;
	@Autowired
	 FileUploadController fileUploadController;
	 
	@Autowired
	DownloadFileServlet downloadFileServlet;
	
	
	
	@PostConstruct
	 public void postConstru()   {
		chargeDetailAgpm();
		chargeDossier();
		chargeFinancement();
		fermerDyn();
	   }
	
	
	


	private List<VAgpmDetails> objetListe = new ArrayList<VAgpmDetails>();
	private List<TFinancement> financementListe = new ArrayList<TFinancement>();
	private List<TDetailAgpm> detailAgpm = new ArrayList<TDetailAgpm>();
	
	//private TAgpm slctdTb = new TAgpm(); 
	private TAffichageAgpm slctdTd = new TAffichageAgpm();
	private VAgpmDetails detail = new VAgpmDetails(); 
	private List<TDossierAgpm> dossListe = new ArrayList<TDossierAgpm>();
	private TDossierAgpm selectedDossier = new TDossierAgpm();
	private String page;
	static  String workingDir = "";
	public boolean fermerAC=false;
	public boolean fermerCPMP=false;
	public boolean fermerDMP=false;
	
	
	

	//Afficher les détails de du projet
	 public void chargeDetailAgpm(){
			objetListe =(List<VAgpmDetails>) iservice.getObjectsByColumn("VAgpmDetails", new ArrayList<String>(Arrays.asList("affAgpId")),
					new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
			if (!objetListe.isEmpty()) {
				detail=objetListe.get(0);
			}
		}
	 
	 
	//Afficher les financements du projet ou agpm selectionné
	 public void chargeFinancement() {
		 financementListe.clear();
			 financementListe = ((List<TFinancement>)iservice.getObjectsByColumn("TFinancement",new ArrayList<String>(Arrays.asList("FIN_ID")),
					 new WhereClause("FIN_AGP_ID",Comparateur.EQ,""+detail.getAffAgpId())));		 		 
	 }
	 
	 
	//Afficher les dossiers du projet ou agpm selectionné
     public void chargeDossier() {
  	dossListe.clear();
  	dossListe = ((List<TDossierAgpm>)iservice.getObjectsByColumn("TDossierAgpm",new ArrayList<String>(Arrays.asList("DAG_NAP_CODE")),
  	new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+detail.getAffAgpId()))); 		 
  		 }
     
    //Afficher detail AGPM
     public void chargeContenuAgpm() {
    	 detailAgpm.clear();
    	 detailAgpm = ((List<TDetailAgpm>)iservice.getObjectsByColumn("TDetailAgpm",new ArrayList<String>(Arrays.asList("TDA_NUM_ORDRE")),
    	  	new WhereClause("TDA_AGP_ID",Comparateur.EQ,""+detail.getAffAgpId()))); 
     }
     
     
     
     public void openDossier() throws IOException{
		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDagLibelle(), selectedDossier.getDagLibelle());
		 
		   }
     public void removeDossier(){
			downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDagLibelle(), selectedDossier.getDagLibelle());
			//check si le dossier est OM
				 iservice.deleteObject(selectedDossier);
				 chargeDossier();	 
			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDagLibelle()+" supprimé!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
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
      
      
      //Edition de l'AGPM
 	 public void imprimerAgpm() {
 			projetReport.longparam1(detail.getAffAgpId(), "Agpm", "Agpm");
 		}
      
      
      
      public String renderPage(String value) throws IOException{
   		switch(value) {
   		case "agpm5":
   			chargeDetailAgpm();
   			chargeDossier();
   			chargeFinancement();
   			chargeContenuAgpm();
   		break;
   		case "pgpm3":
   			
    		break;
   		}
   		
   		return userController.renderPage(value);
   	}
	
	
	
	
	public List<VAgpmDetails> getObjetListe() {
		return objetListe;
	}
	public void setObjetListe(List<VAgpmDetails> objetListe) {
		this.objetListe = objetListe;
	}
	public List<TFinancement> getFinancementListe() {
		return financementListe;
	}
	public void setFinancementListe(List<TFinancement> financementListe) {
		this.financementListe = financementListe;
	}

	public TAffichageAgpm getSlctdTd() {
		return slctdTd;
	}
	public void setSlctdTd(TAffichageAgpm slctdTd) {
		this.slctdTd = slctdTd;
	}
	public VAgpmDetails getDetail() {
		return detail;
	}
	public void setDetail(VAgpmDetails detail) {
		this.detail = detail;
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


	public List<TDetailAgpm> getDetailAgpm() {
		return detailAgpm;
	}


	public void setDetailAgpm(List<TDetailAgpm> detailAgpm) {
		this.detailAgpm = detailAgpm;
	}
	
}
