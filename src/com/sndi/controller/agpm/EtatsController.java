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
import com.sndi.model.TAffichagePgpm;
import com.sndi.model.TAgpm;
import com.sndi.model.TBesoin;
import com.sndi.model.TComposante;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TDossierPlanGeneral;
import com.sndi.model.TFinancement;
import com.sndi.model.TFinancementPgpm;
import com.sndi.model.TFonction;
import com.sndi.model.TMinistere;
import com.sndi.model.TObjectifGen;
import com.sndi.model.TProjet;
import com.sndi.model.TTypeFonction;
import com.sndi.model.VAgpm;
import com.sndi.model.VAgpmDetails;
import com.sndi.model.VBesoin;
import com.sndi.model.VFinancement;
import com.sndi.model.VPgpm;
import com.sndi.report.ProjetReportOld;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;

@Component
@Scope(value="session")
public class EtatsController {
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	ProjetReportOld projetReport;
	@Autowired
	 FileUploadController fileUploadController;
	 
	@Autowired
	DownloadFileServlet downloadFileServlet;
	
	
	
	@PostConstruct
	 public void postConstru()   {
		chargeDetailAgpm();
		chargeDossier();
		fermerDyn();
		chargeDetailPgpm();
	   }
	

	private List<VAgpmDetails> objetListe = new ArrayList<VAgpmDetails>();
	private List<VPgpm> objetListePc = new ArrayList<VPgpm>();
	private TAgpm slctdTb = new TAgpm(); 
	private TAffichageAgpm slctdTd = new TAffichageAgpm();
	private VAgpmDetails detail = new VAgpmDetails(); 
	private List<TComposante> composanteListe = new ArrayList<TComposante>();
	private List<TObjectifGen> objectifListe = new ArrayList<TObjectifGen>();
	private List<VBesoin> besoinListe = new ArrayList<VBesoin>();
	private List<TFinancementPgpm> financementListePc = new ArrayList<TFinancementPgpm>();

	
	//private VPgpm slctdTd = new VPgpm();
	
	private TAffichagePgpm slctdTdPc = new TAffichagePgpm();
	
	private VPgpm detailPc = new VPgpm(); 
	private List<TDossierPlanGeneral> dossListePc = new ArrayList<TDossierPlanGeneral>();
	private TDossierPlanGeneral selectedDossierPc = new TDossierPlanGeneral();

	
	private List<TDossierAgpm> dossListe = new ArrayList<TDossierAgpm>();
	private TDossierAgpm selectedDossier = new TDossierAgpm();
	private String page;
	static  String workingDir = "";
	public boolean fermerAC=false;
	public boolean fermerCPMP=false;
	public boolean fermerDMP=false;
	
	
	
	
	//Afficher les détails de du projet
	 public void chargeDetailAgpm(){
			objetListe =(List<VAgpmDetails>) iservice.getObjectsByColumn("VAgpmDetails", new ArrayList<String>(Arrays.asList("proId")),
					new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
			if (!objetListe.isEmpty()) {
				detail=objetListe.get(0);
			}
		}
	
	
	
     
     //Afficher les dossiers du projet ou agpm selectionné
     public void chargeDossier() {
  	dossListe.clear();
  	dossListe = ((List<TDossierAgpm>)iservice.getObjectsByColumn("TDossierAgpm",new ArrayList<String>(Arrays.asList("DAG_NAP_CODE")),
  	new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+slctdTd.getAffAgpId()))); 		 
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
     
     //Edition de l'AGPM
	 
		
     
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
     
     public String renderPage(String value) throws IOException{
 		switch(value) {
 		case "agpm5":
 			chargeDetailAgpm();
 			chargeDossier();
 		break;
 		case "pgpm3":
 			chargeDetailPgpm();
 			chargeFinancementPc();
  			chargeDossierPc();
  		break;
 		}
 		
 		return userController.renderPage(value);
 	}
     
     
     
     //Edition de l'AGPM
	 public void imprimerAgpm() {
			projetReport.longparam1(slctdTd.getAffAgpId(), "Agpm", "Agpm");
		}
     
     //PGPM
	 public void chargeDetailPgpm(){
			objetListePc =(List<VPgpm>) iservice.getObjectsByColumn("VPgpm", new ArrayList<String>(Arrays.asList("GPG_ID")),
					new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTdPc.getAffGpgId()));
			if (!objetListePc.isEmpty()) {
				detailPc=objetListePc.get(0);
			}
		}
	 
	//Afficher les financements du projet ou agpm selectionné
	 public void chargeFinancementPc() {
		 financementListePc.clear();
			 financementListePc = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
					 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+detailPc.getGpgId())));		 		 
	 }
	 
	//Afficher les dossiers du pgpm selectionné
	    public void chargeDossierPc() {
	  	dossListePc.clear();
	  	dossListePc = ((List<TDossierPlanGeneral>)iservice.getObjectsByColumn("TDossierPlanGeneral",new ArrayList<String>(Arrays.asList("DPG_NAP_CODE")),
	  	new WhereClause("DPG_GPG_ID",Comparateur.EQ,""+detailPc.getGpgId()))); 		 
	  		 }
	          
	  //Ouverture d'un dossier chargé
	     public void openDossierPc() throws IOException{
			 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossierPc.getDpgLibelle(), selectedDossierPc.getDpgLibelle());
			   }
	          
	   //Suppression d'un dossier
	     public void removeDossierPc(){
				downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossierPc.getDpgLibelle(), selectedDossierPc.getDpgLibelle());
				//check si le dossier est OM
				 iservice.deleteObject(selectedDossierPc);
				 chargeDossierPc();	 
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossierPc.getDpgLibelle()+" supprimé!", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
     
	public List<VAgpmDetails> getObjetListe() {
		return objetListe;
	}

	public void setObjetListe(List<VAgpmDetails> objetListe) {
		this.objetListe = objetListe;
	}


	public TAgpm getSlctdTb() {
		return slctdTb;
	}


	public void setSlctdTb(TAgpm slctdTb) {
		this.slctdTb = slctdTb;
	}


	public VAgpmDetails getDetail() {
		return detail;
	}

	public void setDetail(VAgpmDetails detail) {
		this.detail = detail;
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

	public List<TComposante> getComposanteListe() {
		return composanteListe;
	}

	public void setComposanteListe(List<TComposante> composanteListe) {
		this.composanteListe = composanteListe;
	}

	

	public List<TObjectifGen> getObjectifListe() {
		return objectifListe;
	}

	public void setObjectifListe(List<TObjectifGen> objectifListe) {
		this.objectifListe = objectifListe;
	}


	public List<TDossierAgpm> getDossListe() {
		return dossListe;
	}

	public void setDossListe(List<TDossierAgpm> dossListe) {
		this.dossListe = dossListe;
	}


	public List<VBesoin> getBesoinListe() {
		return besoinListe;
	}


	public void setBesoinListe(List<VBesoin> besoinListe) {
		this.besoinListe = besoinListe;
	}
	
	public List<TFinancementPgpm> getFinancementListePc() {
		return financementListePc;
	}

	public void setFinancementListePc(List<TFinancementPgpm> financementListePc) {
		this.financementListePc = financementListePc;
	}




	public TAffichageAgpm getSlctdTd() {
		return slctdTd;
	}


	public void setSlctdTd(TAffichageAgpm slctdTd) {
		this.slctdTd = slctdTd;
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




	public List<VPgpm> getObjetListePc() {
		return objetListePc;
	}




	public void setObjetListePc(List<VPgpm> objetListePc) {
		this.objetListePc = objetListePc;
	}




	public TAffichagePgpm getSlctdTdPc() {
		return slctdTdPc;
	}




	public void setSlctdTdPc(TAffichagePgpm slctdTdPc) {
		this.slctdTdPc = slctdTdPc;
	}

	public VPgpm getDetailPc() {
		return detailPc;
	}

	public void setDetailPc(VPgpm detailPc) {
		this.detailPc = detailPc;
	}
	public List<TDossierPlanGeneral> getDossListePc() {
		return dossListePc;
	}

	public void setDossListePc(List<TDossierPlanGeneral> dossListePc) {
		this.dossListePc = dossListePc;
	}

	public TDossierPlanGeneral getSelectedDossierPc() {
		return selectedDossierPc;
	}
	public void setSelectedDossierPc(TDossierPlanGeneral selectedDossierPc) {
		this.selectedDossierPc = selectedDossierPc;
	}


	

}
