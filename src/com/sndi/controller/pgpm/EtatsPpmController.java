package com.sndi.controller.pgpm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.model.TAffichagePpm;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TFinancementPpm;
import com.sndi.model.THistoPlanPassation;
import com.sndi.model.TStatut;
import com.sndi.model.VFinancementPpm;
import com.sndi.model.VPpmDetails;
import com.sndi.model.VPpmliste;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
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

	@Autowired
	 ConstantService constantService;
	 
	 @Autowired
	 TableauBordController tableauBordController;
	
	@PostConstruct
	 public void postConstru()   {
		chargeDetailPpm();
		chargeDetailFinancement();
		fermerDyn();
	   }
	
	
	
	private List<VPpmDetails> objetListe = new ArrayList<VPpmDetails>(); 
	private List<TDetailPlanPassation> listeTsPpm = new ArrayList<TDetailPlanPassation>();
	private TDetailPlanPassation detPass = new TDetailPlanPassation();
	private VPpmliste slctdTd = new VPpmliste();
	private VPpmDetails detail = new VPpmDetails(); 
	private List<VFinancementPpm> financementListe = new ArrayList<VFinancementPpm>();
	private List<TDossierAgpm> dossListe = new ArrayList<TDossierAgpm>();
	private TDossierAgpm selectedDossier = new TDossierAgpm();

	private String page;
	static  String workingDir = "";
	public boolean fermerAC=false;
	public boolean fermerCPMP=false;
	public boolean fermerDMP=false;
	public boolean visibility = true;
	private String observation="";
	
	 public boolean ppmNormal = true;
     public boolean ppmAmi = false;
     public boolean ppmAmiPso = false;
     public boolean ppmPso = false;
     public boolean ppmPsl = false;
     public boolean ppmPrq = false;
     public boolean ppmPsc = false;
     public boolean ppmAor = false;
     public boolean ppmPsi = false;
     /*public boolean partPspm = false;
     public boolean partPgspm = false;*/
	
	
	
	//Afficher les détails du ppm
		 public void chargeDetailPpm(){
				objetListe =(List<VPpmDetails>) iservice.getObjectsByColumn("VPpmDetails", new ArrayList<String>(Arrays.asList("DPP_ID")),
						new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
				if (!objetListe.isEmpty()) {
					detail=objetListe.get(0);
				}
			}
		 
		//Afficher les détails de du pspm
		 public void chargeDetailPspm(){
				objetListe =(List<VPpmDetails>) iservice.getObjectsByColumn("VPpmDetails", new ArrayList<String>(Arrays.asList("DPP_ID")),
						new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
				if (!objetListe.isEmpty()) {
					detail=objetListe.get(0);
				}
			}
		 
		 
		//Afficher les détails de du pspm
		 public void recuPpm(){
			 List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation",
		 				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
		 	            TDetailPlanPassation detail = new TDetailPlanPassation();
		 				if(!PLG.isEmpty()) detail =PLG.get(0); 
			}
		  
			
		 
		 public void recupModePassation() {
			 if(slctdTd.getDppMopCode().equalsIgnoreCase("AMI")){
				 ppmNormal = false;
			     ppmAmi = true;
			     ppmPso = false;
			     ppmPsl = false;
			     ppmPrq = false;
			     ppmPsc = false;
			     ppmAmiPso = false;
			     ppmAor = false;
			     ppmPsi = false;
			 }else {
				 
				 if(slctdTd.getDppMopCode().equalsIgnoreCase("AMS")){
				 ppmNormal = false;
			     ppmAmi = false;
			     ppmAmiPso = true;
			     ppmPso = false;
			     ppmPsl = false;
			     ppmPrq = false;
			     ppmPsc = false;
			     ppmAor = false;
			     ppmPsi = false;
			 }else {
				 /*if(slctdTd.getDppMopCode().equalsIgnoreCase("PRQ")){
					 ppmNormal = false;
				     ppmAmi = false;
				     ppmPso = false;
				     ppmPsl = false;
				     ppmPrq = true;
				     ppmPsc = false;
				 }else {*/
					 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSL")){
						 ppmNormal = false;
					     ppmAmi = false;
					     ppmPso = false;
					     ppmPsl = true;
					     ppmPrq = false;
					     ppmPsc = false;
					     ppmAmiPso = false;
					     ppmAor = false;
					     ppmPsi = false;
					 }else {
						 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSC")){
							 ppmNormal = false;
						     ppmAmi = false;
						     ppmPso = false;
						     ppmPsl = false;
						     ppmPrq = false;
						     ppmPsc = true;
						     ppmAmiPso = false;
						     ppmAor = false;
						     ppmPsi = false;
						 }else {
						 
						 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSO")){
							 ppmNormal = false;
						     ppmAmi = false;
						     ppmAor = false;
						     ppmPso = true;
						     ppmPsl = false;
						     ppmPrq = false;
						     ppmPsc = false;
						     ppmAmiPso = false;
						     ppmPsi = false;
						 }else {
							 
							 if(slctdTd.getDppMopCode().equalsIgnoreCase("AOR")){
								 ppmNormal = false;
								 ppmAor = true;
							     ppmAmi = false;
							     ppmPso = false;
							     ppmPsl = false;
							     ppmPrq = false; 
							     ppmPsc = false;
							     ppmAmiPso = false;
							     ppmPsi = false;
							 }else {   
								 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSI")){
									 ppmNormal = false;
								     ppmAmi = false;
								     ppmPso = false;
								     ppmPsl = true;
								     ppmPrq = false;
								     ppmPsc = false;
								     ppmAmiPso = false;
								     ppmAor = false;
								     ppmPsi = true;
								 }else {
							 ppmNormal = true;
							 ppmAor = false;
						     ppmAmi = false;
						     ppmPso = false;
						     ppmPsl = false;
						     ppmPrq = false; 
						     ppmPsc = false;
						     ppmAmiPso = false;
						     ppmPsi = false;
						 }
					    }
					   }
					 }
				 }
			  }
			 }
			}
		 	 
			 
		 
		//Afficher les détails du financement
		 public void chargeDetailFinancement(){
			 financementListe =(List<VFinancementPpm>) iservice.getObjectsByColumn("VFinancementPpm", new ArrayList<String>(Arrays.asList("FPP_ID")),
						new WhereClause("FPP_DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
			}
		 

		 
		 //Ouverture d'un dossier chargé
	     public void openDossier() throws IOException{
			// downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDpgLibelle(), selectedDossierPc.getDpgLibelle());
			   }
	          
	   //Suppression d'un dossier
	     public void removeDossierPc(){
				//downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDpgLibelle(), selectedDossierPc.getDpgLibelle());
				//check si le dossier est OM
				 iservice.deleteObject(selectedDossier);
				 //chargeDossierPc();	 
				// FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDpgLibelle()+" supprimé!", "");
				//FacesContext.getCurrentInstance().addMessage(null, msg);
				}
	
	
		 public void actionPsPn() {
			 if(slctdTd.getDppTypePlan().equalsIgnoreCase("PN")) {
				 visibility = true;
			 }else {
				 visibility = false;
			 }
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
     
     //Methode logout a tester
    /* public String logout(HttpServletRequest request) throws ServletException {
    	 request.logout();
    	return "redirect:/"; 
     }*/
     
     
    /* public void imprimerPpmDet() {
    	 projetReport.longparam1(detail.getDppPlpId(), "Ppm", "Ppm");
     }*/ 
     
     public void imprimerPpmDet() {
    	 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_ppm", "Fiche_operation_ppm");
     }
     
     
     public void imprimerPspmDet() {
    	 
    	 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSO")) {
    		 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_pso", "Fiche_operation_pso");
    	 }else 
    		 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSL")) {
    		 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_psl", "Fiche_operation_psl");
    	 }else 
    		 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSC")) {
    			 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_psc", "Fiche_operation_psc");
    		 }
      }
     
     //Validation par la DGMP
     public void validerDgmp() throws IOException {
    	 List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation",
 				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
 	            TDetailPlanPassation detail = new TDetailPlanPassation();
 				if(!PLG.isEmpty()) detail =PLG.get(0); 
 				detail.setTStatut(new TStatut("S3V"));
 				detail.setDppStatutRetour("0");
 				detail.setDppDateValDmp(Calendar.getInstance().getTime());  
 				iservice.updateObject(detail);
 				//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
			     historiser("S3V",detail);
			    //Préparation du Tableau de Bord
			     renderPage("VALPPM","ppm1");
	      		tableauBordController.saveTempTabord("S3V", ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), detail.getDppTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+detail.getDppId());
	      		 userController.setTexteMsg("Validation effectuée avec succès !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
     }
     
     
     //Differé parlal la DGMP
     public void differerDgmp() throws IOException {
    	 
    	 listeTsPpm  =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
					new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
			if (!listeTsPpm.isEmpty()) {
				detPass=listeTsPpm.get(0);
				detPass.setTStatut(new TStatut("S3D"));
				detPass.setDppMotif(observation);
				detPass.setDppStatutRetour("2"); 
  				iservice.updateObject(detPass);
  				historiser("S3D",detPass);
  				
  		       tableauBordController.saveTempTabord("S3D", ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), slctdTd.getDppTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+slctdTd.getDppId()); 
  				/*userController.setTexteMsg("Opération différée avec succès!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");*/
  				FacesContext.getCurrentInstance().addMessage(null,
				          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Opération différée avec succès", ""));
			}
    
     }
     
   	//Methode d'historisation
 		 public void historiser(String statut,TDetailPlanPassation TDetailPlanPassation) {
 			 
 			     TStatut statuts = constantService.getStatut(statut);
 			  //Historisation des Plans Généraux
 			     THistoPlanPassation histoPass = new THistoPlanPassation();
 			     histoPass.setHppDate(Calendar.getInstance().getTime());
 			     histoPass.setHppMotif(TDetailPlanPassation.getDppMotif());
 			     histoPass.setTStatut(statuts);
 			     histoPass.setTDetailPlanPassation(TDetailPlanPassation);
 			     histoPass.setTFonction(userController.getSlctd().getTFonction());
 			     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
 			     iservice.addObject(histoPass);
 			     
 		 }
     
     
     
     
	  public String renderPage(String value,String action) throws IOException{
		  controleController.redirectionDynamicProcedures(action);
	 		switch(value) {
	 		case "ppm1":
				//chargeData("PN");
				 userController.initMessage();
				
				break;
	 		case "ppm3":
	 			chargeDetailPpm();
	 			chargeDetailFinancement();
	 			actionPsPn();
	 			recupModePassation();
	 			recuPpm();
	  		break;
	  		
	 		case "pspm3":
	 			chargeDetailPpm();
	 			chargeDetailFinancement();
	 			actionPsPn();
	  		break;
	 		case "ppm5":
	 			chargeDetailPpm();
	 			chargeDetailFinancement();
	 			actionPsPn();
	 			recupModePassation();
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

	public VPpmliste getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(VPpmliste slctdTd) {
		this.slctdTd = slctdTd;
	}

	public VPpmDetails getDetail() {
		return detail;
	}
	public void setDetail(VPpmDetails detail) {
		this.detail = detail;
	}

	public List<VFinancementPpm> getFinancementListe() {
		return financementListe;
	}

	public void setFinancementListe(List<VFinancementPpm> financementListe) {
		this.financementListe = financementListe;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public boolean isPpmNormal() {
		return ppmNormal;
	}

	public void setPpmNormal(boolean ppmNormal) {
		this.ppmNormal = ppmNormal;
	}

	public boolean isPpmAmi() {
		return ppmAmi;
	}

	public void setPpmAmi(boolean ppmAmi) {
		this.ppmAmi = ppmAmi;
	}

	public boolean isPpmPso() {
		return ppmPso;
	}

	public void setPpmPso(boolean ppmPso) {
		this.ppmPso = ppmPso;
	}

	public boolean isPpmPsl() {
		return ppmPsl;
	}

	public void setPpmPsl(boolean ppmPsl) {
		this.ppmPsl = ppmPsl;
	}

	public boolean isPpmPrq() {
		return ppmPrq;
	}

	public void setPpmPrq(boolean ppmPrq) {
		this.ppmPrq = ppmPrq;
	}

	public boolean isPpmPsc() {
		return ppmPsc;
	}

	public void setPpmPsc(boolean ppmPsc) {
		this.ppmPsc = ppmPsc;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public List<TDetailPlanPassation> getListeTsPpm() {
		return listeTsPpm;
	}

	public void setListeTsPpm(List<TDetailPlanPassation> listeTsPpm) {
		this.listeTsPpm = listeTsPpm;
	}

	public TDetailPlanPassation getDetPass() {
		return detPass;
	}

	public void setDetPass(TDetailPlanPassation detPass) {
		this.detPass = detPass;
	}

	public boolean isPpmAmiPso() {
		return ppmAmiPso;
	}

	public void setPpmAmiPso(boolean ppmAmiPso) {
		this.ppmAmiPso = ppmAmiPso;
	}

	public boolean isPpmAor() {
		return ppmAor;
	}

	public void setPpmAor(boolean ppmAor) {
		this.ppmAor = ppmAor;
	}

	public boolean isPpmPsi() {
		return ppmPsi;
	}

	public void setPpmPsi(boolean ppmPsi) {
		this.ppmPsi = ppmPsi;
	}

	

}
