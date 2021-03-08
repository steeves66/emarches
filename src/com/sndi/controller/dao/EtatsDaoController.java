package com.sndi.controller.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.controller.pgpm.PpmController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAffichageDao;
import com.sndi.model.TAffichagePpm;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDaoAffectation;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TDossierDacs;
import com.sndi.model.TLotAao;
import com.sndi.model.VAdresseAvis;
import com.sndi.model.VDacliste;
import com.sndi.model.VDaoPieces;
import com.sndi.model.VDetailDao;
import com.sndi.model.VLotDao;
import com.sndi.model.VPiecesDao;
import com.sndi.model.VPpmDetails;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;

@Component
@Scope(value="session")
public class EtatsDaoController {
	Logger _logger = Logger.getLogger(EtatsDaoController.class);
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	
	 @Autowired
	ControleController controleController;
	 
	@Autowired
	ProjetReport projetReport;
	@Autowired
	 FileUploadController fileUploadController;
	 
	@Autowired
	DownloadFileServlet downloadFileServlet;
	
	
	
	private List<VDetailDao> objetListe = new ArrayList<VDetailDao>(); 
	private List<VDetailDao> objetAffectes = new ArrayList<VDetailDao>();
	private List<TDossierDacs> dossListe = new ArrayList<TDossierDacs>();
	private List<TDetailPlanPassation> ppmListe = new ArrayList<TDetailPlanPassation>();
	private List<VPiecesDao> piecesListe = new ArrayList<VPiecesDao>();
	private List<TAvisAppelOffre> avisListe = new ArrayList<TAvisAppelOffre>();
	private List<VAdresseAvis> listDetailAdresse = new ArrayList<VAdresseAvis>();
	private List<VLotDao> lotListe = new ArrayList<VLotDao>();
	private TDossierDacs selectedDossier = new TDossierDacs(); 
	
	private VDacliste slctdTd = new VDacliste();
	private TDaoAffectation slctdTda = new TDaoAffectation();
	private VDetailDao detail = new VDetailDao(); 
	private VDetailDao affectes = new VDetailDao();
	private TAvisAppelOffre avis = new TAvisAppelOffre();
	private String page;
	static  String workingDir = "";
	private String libelleFournitures ="DAO_Fournitures_et_services_connexes.doc";
	private String libelleTravaux ="dtao_travaux.doc";
	private String libellePrestations ="dtao_prestation.doc";
	//private String libellePrestations ="dtao_prestation.doc";
	
	
	
	@PostConstruct
	 public void postConstru()   {
		
	   }
	
	
	
	

	//Afficher les détails du DAO
		/* public void chargeDetailDao(){
				objetListe =(List<VDetailDao>) iservice.getObjectsByColumn("VDetailDao", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
				if (!objetListe.isEmpty()) {
					detail=objetListe.get(0);
					chargePieces();
					chargeAdresse();
					chargeLot();
					chargeDaoPpm();
					chargeDossier();
				}
			}*/
		 
		//Afficher les détails du DAO chez les chargés d'Etude
		 public void chargeDetailDaoCharge(){
			 objetAffectes =(List<VDetailDao>) iservice.getObjectsByColumn("VDetailDao", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
				if (!objetListe.isEmpty()) {
					affectes=objetAffectes.get(0);
					chargePiecesAff(); 
					chargeAdresseAff();
					chargeLotAff();
					chargeDaoPpmAff();
					chargeDossierAff();
				}
			}
	
	
	
	//Afficher les dossiers du DAO selectionné
    public void chargeDossier() {
 	dossListe.clear();
 	dossListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
 	         new WhereClause("DDA_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()))); 		 
 		 }
    
    
  //Afficher le(s) PPM du DAO selectionné
    public void chargeDaoPpm() {
 	ppmListe.clear();
 	ppmListe = ((List<TDetailPlanPassation>)iservice.getObjectsByColumn("TDetailPlanPassation",new ArrayList<String>(Arrays.asList("DPP_ID")),
 	new WhereClause("DPP_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()))); 		 
 		 }
	
	
  //Afficher les avis du DAO selectionné
    public void chargeAvis() {
 	avisListe.clear();
 	avisListe = ((List<TAvisAppelOffre>)iservice.getObjectsByColumn("TAvisAppelOffre",new ArrayList<String>(Arrays.asList("AAO_CODE")),
 	new WhereClause("AAO_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())));
 	if (!avisListe.isEmpty()) {
 		avis=avisListe.get(0);
	       }
 		 }
    
  //Afficher les lot de l'avis selectionné
    public void chargeLot() {
 	lotListe.clear();
 	lotListe = ((List<VLotDao>)iservice.getObjectsByColumn("VLotDao",new ArrayList<String>(Arrays.asList("LAA_ID")),
 	new WhereClause("LAA_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()))); 		 
 		 }
    
    
  //Afficher les adresses du DAO selectionné
    public void chargeAdresse() {
    listDetailAdresse.clear();
    listDetailAdresse = ((List<VAdresseAvis>)iservice.getObjectsByColumn("VAdresseAvis",new ArrayList<String>(Arrays.asList("V_AD")),
 	new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()))); 		 
 		 }
  
  //Détails sur le DAO Affecté  
    
  //Afficher les adresses du DAO  affecté
    public void chargeAdresseAff() {
    listDetailAdresse.clear();
    listDetailAdresse = ((List<VAdresseAvis>)iservice.getObjectsByColumn("VAdresseAvis",new ArrayList<String>(Arrays.asList("V_AD")),
 	new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode()))); 		 
 		 }
    
  //Afficher les pièces du DAO selectionné
	public void chargePieces() {
	//piecesListe.clear();
	piecesListe = ((List<VPiecesDao>)iservice.getObjectsByColumn("VPiecesDao",new ArrayList<String>(Arrays.asList("PID_CODE")),
	new WhereClause("PID_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()))); 		 
		 }





	//Afficher les pièces du DAO affecté
    public void chargePiecesAff() {
 	piecesListe.clear();
 	piecesListe = ((List<VPiecesDao>)iservice.getObjectsByColumn("VPiecesDao",new ArrayList<String>(Arrays.asList("PID_CODE")),
 	new WhereClause("PID_DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode()))); 		 
 		 }
    
  //Afficher les lot de l'avis affecté
    public void chargeLotAff() {
 	lotListe.clear();
 	lotListe = ((List<VLotDao>)iservice.getObjectsByColumn("VLotDao",new ArrayList<String>(Arrays.asList("LAA_ID")),
 	new WhereClause("LAA_DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode()))); 		 
 		 }
    
    
  //Afficher les avis du DAO affecté
    public void chargeAvisAff() {
 	avisListe.clear();
 	avisListe = ((List<TAvisAppelOffre>)iservice.getObjectsByColumn("TAvisAppelOffre",new ArrayList<String>(Arrays.asList("AAO_CODE")),
 	new WhereClause("AAO_DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode()))); 
 	if (!avisListe.isEmpty()) {
 		avis=avisListe.get(0);
	       }
 		 }
    
  //Afficher les dossiers du DAO selectionné
    public void chargeDossierAff() {
 	dossListe.clear();
 	dossListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
 	         new WhereClause("DDA_DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode()))); 		 
 		 }
    
  //Afficher le(s) PPM du DAO selectionné
    public void chargeDaoPpmAff() {
 	ppmListe.clear();
 	ppmListe = ((List<TDetailPlanPassation>)iservice.getObjectsByColumn("TDetailPlanPassation",new ArrayList<String>(Arrays.asList("DPP_ID")),
 	new WhereClause("DPP_DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode()))); 		 
 		 }
    
	//Fin Détails DAO Affecté 
	
	
	 //Ouverture d'un dossier chargé
    public void openDossier() throws IOException{
		//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION_LINUX+selectedDossier.getDdaNom(), selectedDossier.getDdaNom());
		downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION_LINUX+selectedDossier.getDdaNom(), selectedDossier.getDdaNom());
		   }
         
  //Suppression d'un dossier
    public void removeDossierPc(){
    downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION_LINUX+selectedDossier.getDdaNom(), selectedDossier.getDdaNom());	
	//downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaNom(), selectedDossier.getDdaNom());
			//check si le dossier est OM
			 iservice.deleteObject(selectedDossier);
			chargeDossier();	 
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDdaNom()+" supprimé!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
    
    
  	
  //Téléchargement des DAO type depuis la liste d'affichage
  	public void opendaoType() throws IOException{
  		  if(slctdTd.getTymTymCode().equalsIgnoreCase("0")) {
  			  //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+libelleFournitures, libelleFournitures); 
  			 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);  
  		  }else
  			  if(slctdTd.getTymTymCode().equalsIgnoreCase("2")) {
  			//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+libelleTravaux, libelleTravaux); 
  		    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+libelleTravaux, libelleTravaux);
  		  }else
  			 if(slctdTd.getTymTymCode().equalsIgnoreCase("1")) {
  			 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+libellePrestations, libellePrestations); 
  			downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+libellePrestations, libellePrestations);
  		    }
  	  }
  	
  	
  	 //Téléchargement des DAO type par les chargés d'Etude
  	public void opendaoTypeCharge() throws IOException{
  		  if(slctdTda.getTTypeMarche().getTymTymCode().equalsIgnoreCase("0")) {
  			 // downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+libelleFournitures, libelleFournitures);  
  			 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);  
  		  }else
  			  if(slctdTda.getTTypeMarche().getTymTymCode().equalsIgnoreCase("2")) {
  			//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+libelleTravaux, libelleTravaux);  
  			downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+libelleTravaux, libelleTravaux);
  		  }else
  			 if(slctdTda.getTTypeMarche().getTymTymCode().equalsIgnoreCase("1")) {
  			 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+libellePrestations, libellePrestations); 
  			downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+libellePrestations, libellePrestations);
  		    }
  	  }
	
	
	
	
	 public String renderPage(String value ,String action) throws IOException{
		 controleController.redirectionDynamicProcedures(action);
	   		switch(value) {
	   		case "dao3":
	   			chargeAvis();
	   			chargePieces();
				chargeAdresse();
				chargeLot();
				chargeDaoPpm();
				chargeDossier();
	   		_logger.info("value: "+value+" action "+action);
	   		break;
	   		case "dao4":
	   			_logger.info("value: "+value+" action "+action);	
	    	break; 
	   		case "dao8":
	   			chargeAvisAff();
	   			chargePiecesAff();
				chargeAdresseAff();
				chargeLotAff();
				chargeDaoPpmAff();
				chargeDossierAff();
	   			_logger.info("value: "+value+" action "+action);	
	    	break;
	    	
	   		case "dps4":
	   			chargeAvis(); 
	   			chargePieces();
				chargeAdresse();
				chargeLot();
				chargeDaoPpm();
				chargeDossier();
	   			_logger.info("value: "+value+" action "+action);	
	    	break;
	    	
	   		case "dps8":
	   			chargeAvisAff(); 
	   			chargePiecesAff();
				chargeAdresseAff();
				chargeLotAff();
				chargeDaoPpmAff();
				chargeDossierAff();
	   			_logger.info("value: "+value+" action "+action);	
	    	break;
	    	
	   		case "ami3":
	   			chargeAvis();
	   			chargePieces();
				chargeAdresse();
				chargeLot();
				chargeDaoPpm();
				chargeDossier();
	   		_logger.info("value: "+value+" action "+action);
	   		break;
	   		case "ami4":
	   			_logger.info("value: "+value+" action "+action);	
	    	break; 
	   		case "ami8":
	   			chargeAvisAff();
	   			chargePiecesAff();
				chargeAdresseAff();
				chargeLotAff();
				chargeDaoPpmAff();
				chargeDossierAff();
	   			_logger.info("value: "+value+" action "+action);	
	    	break;
	    	
	    	
	    	//PRQ
	   		case "prq3":
	   			chargeAvis();
	   			chargePieces();
				chargeAdresse();
				chargeLot();
				chargeDaoPpm();
				chargeDossier();
	   		_logger.info("value: "+value+" action "+action);
	   		break;
	   		case "prq4":
	   			_logger.info("value: "+value+" action "+action);	
	    	break; 
	   		case "prq8":
	   			chargeAvisAff();
	   			chargePiecesAff();
				chargeAdresseAff();
				chargeLotAff();
				chargeDaoPpmAff();
				chargeDossierAff();
	   			_logger.info("value: "+value+" action "+action);	
	    	break;
	   		}
	   		
	   		
	   		
	   		
	   		return userController.renderPage(value);
	   	}





	public TDossierDacs getSelectedDossier() {
		return selectedDossier;
	}

	public void setSelectedDossier(TDossierDacs selectedDossier) {
		this.selectedDossier = selectedDossier;
	}

	public List<TDossierDacs> getDossListe() {
		return dossListe;
	}

	public void setDossListe(List<TDossierDacs> dossListe) {
		this.dossListe = dossListe;
	}


	public List<VDetailDao> getObjetListe() {
		return objetListe;
	}


	public void setObjetListe(List<VDetailDao> objetListe) {
		this.objetListe = objetListe;
	}



	public VDetailDao getDetail() {
		return detail;
	}
	public void setDetail(VDetailDao detail) {
		this.detail = detail;
	}



	public List<TAvisAppelOffre> getAvisListe() {
		return avisListe;
	}

	public void setAvisListe(List<TAvisAppelOffre> avisListe) {
		this.avisListe = avisListe;
	}
	

	public VDacliste getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(VDacliste slctdTd) {
		this.slctdTd = slctdTd;
	}





	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public List<VPiecesDao> getPiecesListe() {
		return piecesListe;
	}

	public void setPiecesListe(List<VPiecesDao> piecesListe) {
		this.piecesListe = piecesListe;
	}


	public List<VAdresseAvis> getListDetailAdresse() {
		return listDetailAdresse;
	}

	public void setListDetailAdresse(List<VAdresseAvis> listDetailAdresse) {
		this.listDetailAdresse = listDetailAdresse;
	}

	public String getLibelleFournitures() {
		return libelleFournitures;
	}
	public void setLibelleFournitures(String libelleFournitures) {
		this.libelleFournitures = libelleFournitures;
	}


	public String getLibelleTravaux() {
		return libelleTravaux;
	}

	public void setLibelleTravaux(String libelleTravaux) {
		this.libelleTravaux = libelleTravaux;
	}


	public String getLibellePrestations() {
		return libellePrestations;
	}
	
	public void setLibellePrestations(String libellePrestations) {
		this.libellePrestations = libellePrestations;
	}



	public List<TDetailPlanPassation> getPpmListe() {
		return ppmListe;
	}
	public void setPpmListe(List<TDetailPlanPassation> ppmListe) {
		this.ppmListe = ppmListe;
	}



	public List<VLotDao> getLotListe() {
		return lotListe;
	}

	public void setLotListe(List<VLotDao> lotListe) {
		this.lotListe = lotListe;
	}



	public TDaoAffectation getSlctdTda() {
		return slctdTda;
	}

	public void setSlctdTda(TDaoAffectation slctdTda) {
		this.slctdTda = slctdTda;
	}





	public List<VDetailDao> getObjetAffectes() {
		return objetAffectes;
	}
	public void setObjetAffectes(List<VDetailDao> objetAffectes) {
		this.objetAffectes = objetAffectes;
	}

	
	
	public VDetailDao getAffectes() {
		return affectes;
	}

	public void setAffectes(VDetailDao affectes) {
		this.affectes = affectes;
	}



	public TAvisAppelOffre getAvis() {
		return avis;
	}

	public void setAvis(TAvisAppelOffre avis) {
		this.avis = avis;
	}
	
}
