package com.sndi.controller.pgpm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAffichageAgpm;
import com.sndi.model.TAffichagePpm;
import com.sndi.model.TBailleur;
import com.sndi.model.TDetailPlanGeneral;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TDevise;
import com.sndi.model.TFinancement;
import com.sndi.model.TFinancementPgpm;
import com.sndi.model.TFinancementPpm;
import com.sndi.model.TFonction;
import com.sndi.model.TGestion;
import com.sndi.model.TLBudgets;
import com.sndi.model.TMinistere;
import com.sndi.model.TModePassation;
import com.sndi.model.TModeleDacType;
import com.sndi.model.TPlanPassation;
import com.sndi.model.TSourceFinancement;
import com.sndi.model.TTypeMarche;
import com.sndi.model.VDetPlaning;
import com.sndi.model.VLigneImputation;
import com.sndi.model.VModePassation;
import com.sndi.model.VModeleAmi;
import com.sndi.model.VModeleDao;
import com.sndi.model.VPgpmFonction;
import com.sndi.model.VPpmStatut;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.model.VUpdateAgpm;
import com.sndi.model.VUpdatePpm;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;


@Component
@Scope(value="session")
public class PpmModificationController {
	Logger _logger = Logger.getLogger(PpmModificationController.class);
	
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

	 
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
		
	 }
	 
	 //Décalartion des listes
	 private List<TAffichagePpm> listePpm = new ArrayList<TAffichagePpm>();
	 private List<VUpdatePpm> listUpdate = new ArrayList<VUpdatePpm>();
	 private List<TFinancementPpm> listeFinancement = new ArrayList<TFinancementPpm>();
	 private List<TFinancementPgpm> listeFinancementPgpm = new ArrayList<TFinancementPgpm>();
	 private List<VModePassation> listeMode = new ArrayList<VModePassation>();
     private List<VModeleDao> listeDao = new ArrayList<VModeleDao>();
     private List<VModeleAmi> listeAmi = new ArrayList<VModeleAmi>();
     private List <VPpmStatut> ppmstatutList = new ArrayList<VPpmStatut>();
	 private List<TAffichagePpm> ppmTrans = new ArrayList<TAffichagePpm>();
     private List<TAffichagePpm> pspmTrans = new ArrayList<TAffichagePpm>();
     private List<TAffichagePpm> ppmValCp = new ArrayList<TAffichagePpm>();
     private List<TAffichagePpm> ppmValDmp = new ArrayList<TAffichagePpm>();
     private List<TAffichagePpm> pspmValCp = new ArrayList<TAffichagePpm>();
     private List<TAffichagePpm> pspmValDmp = new ArrayList<TAffichagePpm>();
     private List<TAffichagePpm> ppmDifCp = new ArrayList<TAffichagePpm>();
     private List<TAffichagePpm> ppmDifDmp = new ArrayList<TAffichagePpm>();
     private List<TAffichagePpm> pspmDifCp = new ArrayList<TAffichagePpm>();
     private List<TAffichagePpm> pspmDifDmp = new ArrayList<TAffichagePpm>();
     private List<VPgpmFonction> listePgpm = new ArrayList<VPgpmFonction>();
     private List<VPgpmFonction> listePgspm = new ArrayList<VPgpmFonction>();
     private List<TTypeMarche> listeTypeMarches = new ArrayList<TTypeMarche>();
	 private List<TModePassation> listeModePassation = new ArrayList<TModePassation>();
	 private List<TGestion> listeGestion = new ArrayList<TGestion>();
	 private List<TAffichagePpm> validationListe = new ArrayList<TAffichagePpm>();
	 private List<TAffichagePpm>listSelectionTransmission =new ArrayList<TAffichagePpm>();
	 private TModePassation recupModePassation = new TModePassation();
	 
	 //Les Variables
	 private VUpdatePpm updatePpm = new VUpdatePpm();
	 private TAffichagePpm slctdTd = new TAffichagePpm();
	 private VLigneImputation recupLigne = new VLigneImputation();
	 private String nbrePpm ="";
	 private String nbrePspm ="";
	 private TDetailPlanPassation detailPass = new TDetailPlanPassation();
	 private String statutTrans ="";
	 private String baiCode;
	 private String souCode;
	 private String devCode="CFA";
	 private String filtreFonction="";
	 private String filtreMinistere="";
	 private String statutAffiche="";
	 private String statutUpdate="";
	 private String filtrePgpm ="";
	 private String filtrePpm ="";
	 private String multiFiltre ="";
	 private long gesCode;	
	 private long  totalLigne;
	 private long  totalMontant;
	 private VPgpmFonction pgpm = new VPgpmFonction();
	 private VPgpmFonction pgspm = new VPgpmFonction();
	 private TDetailPlanPassation ppm = new TDetailPlanPassation();
	 private TDetailPlanPassation recuPpm = new TDetailPlanPassation();
	 //private TDetailPlanPassation datePpm = new TDetailPlanPassation();
	 private VDetPlaning datePpm = new VDetPlaning();
	 private VPgpmFonction recupPgpm = new VPgpmFonction();
	 private VPgpmFonction recupPgspm = new VPgpmFonction();
	 private TDetailPlanPassation passDetail = new TDetailPlanPassation();
	 private TAffichagePpm slctdTdPpm = new TAffichagePpm();
	 private TMinistere ministere= new TMinistere();
	 private TMinistere recupMinistere= new TMinistere();
	 private TFonction recupFonction= new TFonction();
	 private VTypeMarcheFils marche = new VTypeMarcheFils();
	 private VTypeMarcheFils reucpMarche = new VTypeMarcheFils();
	 private VLigneImputation ligne = new VLigneImputation();
	 private TFinancementPpm newFinancement = new TFinancementPpm();
	 private TFinancementPpm selectFinance = new TFinancementPpm();
	 
	 
	 
	 //Methode Principale de Chargement des PPM
	 public void chargeData(){
		 getListePpm().clear();
		 listePpm = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")), 
				"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SPR")),
				new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
				new WhereClause("AFF_DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("listePpm size: "+listePpm.size());
			//Actualisation du Tableau de Bord
			tableauBordController.chargeDataPpm();
			//Affichage du nombre de ppm saisis
			nbrePpm =""+getNbrePpmTotal();
	  }
	 
	 
	 
	//Methode Principale de Chargement des PSPM
	 public void chargeDataPspm(){ 
		 getListePpm().clear();
		 listePpm = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")), 
				"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SPD")),
				new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
				new WhereClause("AFF_DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("listePpm size: "+listePpm.size());
			//Actualisation du Tableau de Bord
			tableauBordController.chargeDataPspm();
			//Affichage du nombre des pspm saisis
			nbrePspm =""+getNbrePspmTotal();
	  }
	 
	//Methode de validation des PPM
	 public void chargeDataAvaliderPpm() {
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			
		 }else {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				 getValidationListe().clear();
				 validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
							"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
							new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
							new WhereClause("AFF_DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
						_logger.info("affichageListe size: "+validationListe.size());	
						//Actualisation du Tableau de Bord
						tableauBordController.chargeDataPpm();
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					 getValidationListe().clear();
							validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
							"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPT")),
							new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
							//new WhereClause("AFF_DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
							_logger.info("affichageListe size: "+validationListe.size());
							//Actualisation du Tableau de Bord
							tableauBordController.chargeDataPpm();
				 }else
					  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						  getValidationListe().clear();
							validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
							"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPT")),
							new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
							//new WhereClause("AFF_DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
							_logger.info("affichageListe size: "+validationListe.size());
							//Actualisation du Tableau de Bord
							tableauBordController.chargeDataPpm(); 
			     }
		     } 
		   }
		 }
	 
	 
	 //Methode de validation des PSPM
	 public void chargeDataAvaliderPspm() {
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			
		 }else {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				 getValidationListe().clear();
				 validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
							"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
							new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
							new WhereClause("AFF_DPP_MOP_CODE",WhereClause.Comparateur.EQ,"PSC"),
							new WhereClause("AFF_DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
						_logger.info("affichageListe size: "+validationListe.size());	
						//Actualisation du Tableau de Bord
						tableauBordController.chargeDataPspm();
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					 getValidationListe().clear();
							validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
									"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPS")), 
							     new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
							//new WhereClause("AFF_DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
							_logger.info("affichageListe size: "+validationListe.size());
							//Actualisation du Tableau de Bord
							tableauBordController.chargeDataPspm();
				 }
		     } 
		   }
		 }
	 
	 
	//Filtre multicritère pour les PPM
		public void chargerPpmRecherche() { 
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				getListePpm().clear();
				 listePpm = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")), 
						"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
						new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
						new WhereClause("AFF_DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						new WhereClause("AFF_DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
					_logger.info("listePpm size: "+listePpm.size());
					//Actualisation du Tableau de Bord
					tableauBordController.chargeDataPpm();
					//Affichage du nombre de ppm saisis
					nbrePpm =""+getNbrePpmTotal();
					
				 }else 
				      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
				    	  getValidationListe().clear();
							 validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
										"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
										new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
										new WhereClause("AFF_DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
									    new WhereClause("AFF_DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
									_logger.info("affichageListe size: "+validationListe.size());	
									//Actualisation du Tableau de Bord
									tableauBordController.chargeDataPpm();
				        }else 
				    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
				    		  getValidationListe().clear();
								validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
								new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
								new WhereClause("AFF_DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
								 new WhereClause("AFF_DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
								_logger.info("affichageListe size: "+validationListe.size());
								//Actualisation du Tableau de Bord
								tableauBordController.chargeDataPpm();
	         	  }
		     }
		
		
		//Filtre multicritère pour les PSPM
		public void chargerPspmRecherche() { 
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				getListePpm().clear();
				 listePpm = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")), 
						"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
						new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						new WhereClause("AFF_DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						new WhereClause("AFF_DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
					tableauBordController.chargeDataPspm();
				 }else 
				      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
				    	  getValidationListe().clear();
							 validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
										"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
										new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
										new WhereClause("AFF_DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
										 new WhereClause("AFF_DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));	
									//Actualisation du Tableau de Bord
									tableauBordController.chargeDataPspm();
				        }else 
				    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
				    		  getValidationListe().clear();
								validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
								new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
								new WhereClause("AFF_DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
								 new WhereClause("AFF_DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
								//Actualisation du Tableau de Bord
								tableauBordController.chargeDataPspm();
				    	  }
		           }
		
		
		//Réinitialiser les PPM
		public void reinitialiserPpm() { 
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				getListePpm().clear();
				 listePpm = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")), 
						"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
						new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
						new WhereClause("AFF_DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					_logger.info("listePpm size: "+listePpm.size());
					//Actualisation du Tableau de Bord
					tableauBordController.chargeDataPpm();
					//Affichage du nombre de ppm saisis
					nbrePpm =""+getNbrePpmTotal();
					multiFiltre="";
				 }else 
				      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
				    	  getValidationListe().clear();
							 validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
										"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
										new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
										new WhereClause("AFF_DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
									_logger.info("affichageListe size: "+validationListe.size());	
									//Actualisation du Tableau de Bord
									tableauBordController.chargeDataPpm();
									multiFiltre="";
				        }else 
				    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
				    		  getValidationListe().clear();
								validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
								new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
								new WhereClause("AFF_DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
								_logger.info("affichageListe size: "+validationListe.size());
								//Actualisation du Tableau de Bord
								tableauBordController.chargeDataPpm();
								multiFiltre="";
	         	  }
		     }
		
		
		
		public void reinitialiserPspm() { 
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				getListePpm().clear();
				 listePpm = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")), 
						"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
						new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						new WhereClause("AFF_DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					_logger.info("listePpm size: "+listePpm.size());
					//Actualisation du Tableau de Bord
					tableauBordController.chargeDataPspm();
					//Affichage du nombre de ppm saisis
					nbrePpm =""+getNbrePpmTotal();
					multiFiltre="";
					
				 }else 
				      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
				    	  getValidationListe().clear();
							 validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnInDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
										"AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
										new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
										new WhereClause("AFF_DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
									_logger.info("affichageListe size: "+validationListe.size());	
									//Actualisation du Tableau de Bord
									tableauBordController.chargeDataPspm();
									multiFiltre="";
				        }else 
				    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
				    		  getValidationListe().clear();
								validationListe = (List<TAffichagePpm>) iservice.getObjectsByColumnDesc("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
								new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
								new WhereClause("AFF_DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
								_logger.info("affichageListe size: "+validationListe.size());
								//Actualisation du Tableau de Bord
								tableauBordController.chargeDataPspm();
								multiFiltre="";
	         	  }
		     }
	 
		
	 //Methode de modification du PPM/PSPM
	 @Transactional
	 public void modifierDetailPlan() throws IOException{
		 slctdTd.setAffDppStrConduc(updatePpm.getAffDppStrConduc());
		 slctdTd.setAffDppStrBenefi(updatePpm.getAffDppStrBenefi());
		 slctdTd.setAffDppObjet(updatePpm.getAffDppObjet());
		 slctdTd.setTTypeMarche(new TTypeMarche(updatePpm.getAffDppTymCode()));
		 slctdTd.setTModePassation(new TModePassation(updatePpm.getAffDppMopCode()));
		 slctdTd.setTLBudgets(new TLBudgets(updatePpm.getLbgCode()));
		 slctdTd.setAffDppPartiePmePmi(updatePpm.getAffDppPartiePmePmi());
		 slctdTd.setAffDppBailleur(updatePpm.getAffDppBailleur());
		 slctdTd.setAffDppPieceDao(updatePpm.getAffDppPieceDao());
		 slctdTd.setAffDppDateAttApproBail(updatePpm.getAffDppDateAttApproBail());
		 slctdTd.setAffDppApprobAno(updatePpm.getAffDppApprobAno());
		 slctdTd.setAffDppDateAvisAoPublicat(updatePpm.getAffDppDateAvisAoPublicat());
		 slctdTd.setAffDppDateJugementOffre(updatePpm.getAffDppDateJugementOffre());
		 slctdTd.setAffDppDateDaoTrans(updatePpm.getAffDppDateDaoTrans());
		 slctdTd.setAffDppDateExecFin(updatePpm.getAffDppDateExecFin());
		 slctdTd.setAffDppDateExecDebut(updatePpm.getAffDppDateExecDebut());
		 slctdTd.setAffDppDateMarcheApprob(updatePpm.getAffDppDateMarcheApprob());
		 slctdTd.setAffDppDateOuvertOf(updatePpm.getAffDppDateOuvertOf());
		 slctdTd.setAffDppDateElabRapport(updatePpm.getAffDppDateElabRapport());
		 slctdTd.setAffDppDateNegociation(updatePpm.getAffDppDateNegociation());
		 slctdTd.setAffDppDateAttApprobDmp(updatePpm.getAffDppDateDaoApprobDmp());
		 slctdTd.setAffDppDateSignatAttrib(updatePpm.getAffDppDateSignatAttrib());
		 slctdTd.setAffDppDateSignatAc(updatePpm.getAffDppDateSignatAc());
		 slctdTd.setAffDppInvEntre(updatePpm.getAffDppInvEntre());
		 iservice.updateObject(slctdTd);
		 
		 
		 //Modification dans TDetailPlanPassation
    	 List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
   				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffDppId()));
    	        TDetailPlanPassation detail = new TDetailPlanPassation();
				if(!PLG.isEmpty()) detail =PLG.get(0);
				detail.setDppPartiePmePmi(slctdTd.getAffDppPartiePmePmi());
				detail.setDppSourceFin(slctdTd.getAffDppSourceFin());
				detail.setDppObjet(slctdTd.getAffDppObjet());
				detail.setDppBailleur(slctdTd.getAffDppBailleur());
				detail.setTModePassation(new TModePassation(slctdTd.getTModePassation().getMopCode()));
				detail.setTTypeMarche(new TTypeMarche(slctdTd.getTTypeMarche().getTymCode()));
				detail.setTLBudgets(new TLBudgets(slctdTd.getTLBudgets().getLbgCode()));
				detail.setTModeleDacType(new TModeleDacType(slctdTd.getAffDppPieceDao()));
				detail.setDppStructureBenefi(slctdTd.getAffDppStrBenefi());
				detail.setDppStructureConduc(slctdTd.getAffDppStrConduc());
				detail.setDppTypeFinance(slctdTd.getAffDppTypeFinance());
				detail.setDppDateAvisAoPublication(slctdTd.getAffDppDateAvisAoPublicat());
				detail.setDppDateDaoApprobBail(slctdTd.getAffDppDateDaoApprobBail());
				detail.setDppDateAttApproBail(slctdTd.getAffDppDateAttApproBail());
				detail.setDppDateDaoTrans(slctdTd.getAffDppDateDaoTrans());
				detail.setDppDateElabRapport(slctdTd.getAffDppDateElabRapport());
				detail.setDppDateExecDebut(slctdTd.getAffDppDateExecDebut());
				detail.setDppDateExecFin(slctdTd.getAffDppDateExecFin());
				detail.setDppDateOuvertOf(slctdTd.getAffDppDateOuvertOf());
				detail.setDppDateOuvertOt(slctdTd.getAffDppDateOuvertOt());
				detail.setDppDateSignatAc(slctdTd.getAffDppDateSignatAc());
				detail.setDppDateSignatAttrib(slctdTd.getAffDppDateSignatAttrib());
				detail.setDppDateJugementOffre(slctdTd.getAffDppDateJugementOffre());
				detail.setDppApprobAno(slctdTd.getAffDppApprobAno());
				detail.setDppDateNegociation(slctdTd.getAffDppDateNegociation());
				detail.setDppInvEntre(slctdTd.getAffDppInvEntre());
				//detail.setDppDateJugementOffreTec(slctdTd.get);
				
				iservice.updateObject(detail);
   				userController.renderPage("ppm1");
		    	 userController.setTexteMsg("Modification éffectuée avec succès!");
			     userController.setRenderMsg(true);
			     userController.setSevrityMsg("success");
			     chargeData();
				
		 
		 //Liste des financements
	   	 		 List<TFinancementPpm> FIN =iservice.getObjectsByColumn("TFinancementPpm", new ArrayList<String>(Arrays.asList("FIN_ID")),
	   		      	new WhereClause("FPP_DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffDppId()));
	   	              TFinancementPpm financement = new TFinancementPpm();
	   	   				if(!FIN.isEmpty()) {
	   	   					financement =FIN.get(0);
	   	   					financement.setTBailleur(new TBailleur(updatePpm.getFppBaiCode()));
	   	   					financement.setFppTypeFinance(updatePpm.getFppTypeFinance());
	   	   					financement.setTDevise(new TDevise(updatePpm.getFppDevCode()));
	   	   					financement.setFppMontantCfa(updatePpm.getFppMontantCfa());
	   	   					financement.setTSourceFinancement(new TSourceFinancement(updatePpm.getFppSouCode()));
	   	   					financement.setFppMontantDevise(updatePpm.getFppMontantDevise());
	   	   					iservice.updateObject(financement);
	   	   				}
		 
	 }
	 
	 //Les Compteurs
	 public int getNbrePpmTotal(){
			int i = iservice.countTableByColumn("T_AFFICHAGE_PPM", "AFF_ID",
					new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					new WhereClause("AFF_DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			return	i;	
		}
	 
	 public int getNbrePspmTotal(){
			int i = iservice.countTableByColumn("T_AFFICHAGE_PPM", "AFF_ID",
					new WhereClause("AFF_DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					new WhereClause("AFF_DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			return	i;	
		}
	 
	 
	 //Fin des compteurs
	 
	 
	 
	//Methode de récupération de t_detail_plan_passation dans t_affichage_ppm
		 public void editForm() {
		    			listUpdate= (List<VUpdatePpm>) iservice.getObjectsByColumn("VUpdatePpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
		    					 new WhereClause("AFF_DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffDppId()));
		    			if (!listUpdate.isEmpty()) {
		    				updatePpm=listUpdate.get(0); 
		    			}
		      }
		 
		 
		//Chargement des Types de Marchés
		 public void chargeMarches() {
			 listeTypeMarches.clear();
			 listeTypeMarches =(List<TTypeMarche>) iservice.getObjectsByColumn("TTypeMarche", new ArrayList<String>(Arrays.asList("tymCode")));
			}
		//Chargement des modes de Passtion
		 public void chargeModePassation() {
			 listeModePassation.clear();
			 listeModePassation =(List<TModePassation>) iservice.getObjectsByColumn("TModePassation", new ArrayList<String>(Arrays.asList("mopCode")));
			}
		 
		//Afficher les financements du projet ou agpm selectionné
		 public void chargeFinancement() {
			 listeFinancement.clear();
			 listeFinancement = ((List<TFinancementPpm>)iservice.getObjectsByColumn("TFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
						 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+detailPass.getDppId())));		 		 
		 }
		 
		 //Afficher les Pgpm 
		 public void chargeRecherchePgpm() { 
			 listePgpm.clear();
			 listePgpm = (List<VPgpmFonction>)iservice.getObjectsByColumn("VPgpmFonction",new ArrayList<String>(Arrays.asList("GPG_ID")),
					 new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					 new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
					 new WhereClause("PLG_FON_COD",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					 new WhereClause("GPG_OBJET",WhereClause.Comparateur.LIKE,"%"+filtrePgpm+"%"));		 		 
		 }
		 
			//Methodes vider
    	 public void vider() {
    		 detailPass = new TDetailPlanPassation();
    		 recupFonction = new TFonction();
    		 reucpMarche = new VTypeMarcheFils();
    		 recupModePassation = new TModePassation();
    		 newFinancement = new TFinancementPpm();
    		 listeFinancement = new ArrayList<TFinancementPpm>();
    		
    		 devCode ="";
    		 baiCode ="";
    		 souCode=""; 
    	 }
    	 
    	 public void coutOperation() {
			 totalMontant = 0;
			 for(TFinancementPgpm n : listeFinancementPgpm) {
				 totalMontant = totalMontant+ (n.getFipMontantCfa()+n.getFipTresor());
			 }
		 }
    	 
    	 
    	 public void onSelectLigneBudgetaire() { 
			 detailPass.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
	         
			 recupLigne = new VLigneImputation();
			 recupLigne.setLbgAdmCentral(ligne.getLbgAdmCentral());
			 recupLigne.setLbgActif(ligne.getLbgActif());
			 recupLigne.setLbgActNumModif(ligne.getLbgActNumModif());
			 recupLigne.setLbgAeDon(ligne.getLbgAeDon());
			 recupLigne.setLbgAeEmp(ligne.getLbgAeEmp());
			 recupLigne.setLbgAeTr(ligne.getLbgAeTr());
			 recupLigne.setLbgAnoCode(ligne.getLbgAnoCode());
			 recupLigne.setLbgCode(ligne.getLbgCode());
			 recupLigne.setLbgCor(ligne.getLbgCor());
			 recupLigne.setLbgDesCode(ligne.getLbgDesCode());
			 recupLigne.setLbgDisDon(ligne.getLbgDisDon());
			 recupLigne.setLbgDisEmp(ligne.getLbgDisEmp());
			 recupLigne.setLbgDisTot(ligne.getLbgDisTot());
			 recupLigne.setLbgDisTre(ligne.getLbgDisTre());
			 recupLigne.setLbgDotAnPlus0(ligne.getLbgDotAnPlus0());
			 recupLigne.setLbgDotAnPlus1(ligne.getLbgDotAnPlus1());
			 recupLigne.setLbgDotAnPlus2(ligne.getLbgDotAnPlus2());
			 recupLigne.setLbgDteCor(ligne.getLbgDteCor());
			 recupLigne.setLbgDteModif(ligne.getLbgDteModif());
			 recupLigne.setLbgDteMp(ligne.getLbgDteMp());
			 recupLigne.setLbgDteSaisi(ligne.getLbgDteSaisi());
			 recupLigne.setLbgDteStaCour(ligne.getLbgDteStaCour());
			 recupLigne.setLbgDteVal(ligne.getLbgDteVal());
			 recupLigne.setLbgFonCode(ligne.getLbgFonCode());
			 recupLigne.setLbgFonCodeAc(ligne.getLbgFonCodeAc());
			 recupLigne.setLbgFonCodeCf(ligne.getLbgFonCodeCf());
			 recupLigne.setLbgFonCodeCor(ligne.getLbgFonCodeCor());
			 recupLigne.setLbgFonCodePf(ligne.getLbgFonCodePf());
			 recupLigne.setLbgFonCodePr(ligne.getLbgFonCodePr());
			 recupLigne.setLbgFonCodeVal(ligne.getLbgFonCodeVal());
			 recupLigne.setLbgNatCode(ligne.getLbgNatCode());
			 recupLigne.setLbgImputation(ligne.getLbgImputation());
			 recupLigne.setLbgGesCode(ligne.getLbgGesCode());
			 recupLigne.setLbgFonCodeValAct(ligne.getLbgFonCodeValAct());
			 recupLigne.setLbgFonCodeVerou(ligne.getLbgFonCodeVerou());
			 recupLigne.setLbgReglMp(ligne.getLbgReglMp());
			 recupLigne.setLbgMotifCor(ligne.getLbgMotifCor());
			 recupLigne.setLbgResDon(ligne.getLbgResDon());
			 recupLigne.setLbgResEmp(ligne.getLbgResEmp());
			 recupLigne.setNatLibelle(ligne.getNatLibelle());
			 recupLigne.setLbgSigfip(ligne.getLbgSigfip());
			 recupLigne.setLbgTraitmt(ligne.getLbgTraitmt());
			 
			 //montantOperation();
			 coutOperation(); 
				}
	 
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamic(action);
		     switch(value) {
				case "ppm1":
					
					break;
				case "ppm2":
				
				break;
				case "pgpm3":
				break;
				case "agpm2":
					
					break;
				case "agpm3":
					
					break;
				case "pgpm4":
					
					break;
			    }
		     
		    return userController.renderPage(value);
		}



	public List<TAffichagePpm> getListePpm() {
		return listePpm;
	}

	public void setListePpm(List<TAffichagePpm> listePpm) {
		this.listePpm = listePpm;
	}



	public String getNbrePpm() {
		return nbrePpm;
	}

	public void setNbrePpm(String nbrePpm) {
		this.nbrePpm = nbrePpm;
	}


	public String getNbrePspm() {
		return nbrePspm;
	}
	public void setNbrePspm(String nbrePspm) {
		this.nbrePspm = nbrePspm;
	}



	public List<VUpdatePpm> getListUpdate() {
		return listUpdate;
	}



	public void setListUpdate(List<VUpdatePpm> listUpdate) {
		this.listUpdate = listUpdate;
	}



	public VUpdatePpm getUpdatePpm() {
		return updatePpm;
	}



	public void setUpdatePpm(VUpdatePpm updatePpm) {
		this.updatePpm = updatePpm;
	}



	public TDetailPlanPassation getDetailPass() {
		return detailPass;
	}
	public void setDetailPass(TDetailPlanPassation detailPass) {
		this.detailPass = detailPass;
	}



	public TDetailPlanPassation getPassDetail() {
		return passDetail;
	}

	public void setPassDetail(TDetailPlanPassation passDetail) {
		this.passDetail = passDetail;
	}



	public VPgpmFonction getPgpm() {
		return pgpm;
	}

	public void setPgpm(VPgpmFonction pgpm) {
		this.pgpm = pgpm;
	}



	public TFinancementPpm getNewFinancement() {
		return newFinancement;
	}

	public void setNewFinancement(TFinancementPpm newFinancement) {
		this.newFinancement = newFinancement;
	}



	public List<TFinancementPgpm> getListeFinancementPgpm() {
		return listeFinancementPgpm;
	}



	public void setListeFinancementPgpm(List<TFinancementPgpm> listeFinancementPgpm) {
		this.listeFinancementPgpm = listeFinancementPgpm;
	}



	public List<VModePassation> getListeMode() {
		return listeMode;
	}



	public void setListeMode(List<VModePassation> listeMode) {
		this.listeMode = listeMode;
	}



	public List<VModeleDao> getListeDao() {
		return listeDao;
	}



	public void setListeDao(List<VModeleDao> listeDao) {
		this.listeDao = listeDao;
	}



	public List<VModeleAmi> getListeAmi() {
		return listeAmi;
	}



	public void setListeAmi(List<VModeleAmi> listeAmi) {
		this.listeAmi = listeAmi;
	}



	public List <VPpmStatut> getPpmstatutList() {
		return ppmstatutList;
	}



	public void setPpmstatutList(List <VPpmStatut> ppmstatutList) {
		this.ppmstatutList = ppmstatutList;
	}



	public List<TAffichagePpm> getPpmTrans() {
		return ppmTrans;
	}



	public void setPpmTrans(List<TAffichagePpm> ppmTrans) {
		this.ppmTrans = ppmTrans;
	}



	public List<TAffichagePpm> getPspmTrans() {
		return pspmTrans;
	}



	public void setPspmTrans(List<TAffichagePpm> pspmTrans) {
		this.pspmTrans = pspmTrans;
	}



	public List<TAffichagePpm> getPpmValCp() {
		return ppmValCp;
	}



	public void setPpmValCp(List<TAffichagePpm> ppmValCp) {
		this.ppmValCp = ppmValCp;
	}



	public List<TAffichagePpm> getPpmValDmp() {
		return ppmValDmp;
	}



	public void setPpmValDmp(List<TAffichagePpm> ppmValDmp) {
		this.ppmValDmp = ppmValDmp;
	}



	public List<TAffichagePpm> getPspmValDmp() {
		return pspmValDmp;
	}



	public void setPspmValDmp(List<TAffichagePpm> pspmValDmp) {
		this.pspmValDmp = pspmValDmp;
	}



	public List<TAffichagePpm> getPspmDifDmp() {
		return pspmDifDmp;
	}



	public void setPspmDifDmp(List<TAffichagePpm> pspmDifDmp) {
		this.pspmDifDmp = pspmDifDmp;
	}



	public List<TAffichagePpm> getPpmDifDmp() {
		return ppmDifDmp;
	}



	public void setPpmDifDmp(List<TAffichagePpm> ppmDifDmp) {
		this.ppmDifDmp = ppmDifDmp;
	}



	public List<TAffichagePpm> getPpmDifCp() {
		return ppmDifCp;
	}



	public void setPpmDifCp(List<TAffichagePpm> ppmDifCp) {
		this.ppmDifCp = ppmDifCp;
	}



	public List<TAffichagePpm> getPspmValCp() {
		return pspmValCp;
	}



	public void setPspmValCp(List<TAffichagePpm> pspmValCp) {
		this.pspmValCp = pspmValCp;
	}



	public List<TAffichagePpm> getPspmDifCp() {
		return pspmDifCp;
	}

	public void setPspmDifCp(List<TAffichagePpm> pspmDifCp) {
		this.pspmDifCp = pspmDifCp;
	}



	public String getStatutTrans() {
		return statutTrans;
	}

	public void setStatutTrans(String statutTrans) {
		this.statutTrans = statutTrans;
	}



	public List<TFinancementPpm> getListeFinancement() {
		return listeFinancement;
	}



	public void setListeFinancement(List<TFinancementPpm> listeFinancement) {
		this.listeFinancement = listeFinancement;
	}



	public TAffichagePpm getSlctdTd() {
		return slctdTd;
	}



	public void setSlctdTd(TAffichagePpm slctdTd) {
		this.slctdTd = slctdTd;
	}



	public String getBaiCode() {
		return baiCode;
	}



	public void setBaiCode(String baiCode) {
		this.baiCode = baiCode;
	}



	public String getSouCode() {
		return souCode;
	}



	public void setSouCode(String souCode) {
		this.souCode = souCode;
	}



	public String getDevCode() {
		return devCode;
	}



	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}



	public String getStatutAffiche() {
		return statutAffiche;
	}



	public void setStatutAffiche(String statutAffiche) {
		this.statutAffiche = statutAffiche;
	}



	public String getStatutUpdate() {
		return statutUpdate;
	}



	public void setStatutUpdate(String statutUpdate) {
		this.statutUpdate = statutUpdate;
	}



	public VTypeMarcheFils getReucpMarche() {
		return reucpMarche;
	}



	public void setReucpMarche(VTypeMarcheFils reucpMarche) {
		this.reucpMarche = reucpMarche;
	}



	public TFinancementPpm getSelectFinance() {
		return selectFinance;
	}

	public void setSelectFinance(TFinancementPpm selectFinance) {
		this.selectFinance = selectFinance;
	}



	public List<VPgpmFonction> getListePgspm() {
		return listePgspm;
	}



	public void setListePgspm(List<VPgpmFonction> listePgspm) {
		this.listePgspm = listePgspm;
	}



	public String getFiltreFonction() {
		return filtreFonction;
	}



	public void setFiltreFonction(String filtreFonction) {
		this.filtreFonction = filtreFonction;
	}



	public String getFiltreMinistere() {
		return filtreMinistere;
	}



	public void setFiltreMinistere(String filtreMinistere) {
		this.filtreMinistere = filtreMinistere;
	}



	public VPgpmFonction getPgspm() {
		return pgspm;
	}



	public void setPgspm(VPgpmFonction pgspm) {
		this.pgspm = pgspm;
	}



	public List<TGestion> getListeGestion() {
		return listeGestion;
	}



	public void setListeGestion(List<TGestion> listeGestion) {
		this.listeGestion = listeGestion;
	}



	public List<TAffichagePpm> getValidationListe() {
		return validationListe;
	}



	public void setValidationListe(List<TAffichagePpm> validationListe) {
		this.validationListe = validationListe;
	}



	public List<TAffichagePpm> getListSelectionTransmission() {
		return listSelectionTransmission;
	}



	public void setListSelectionTransmission(List<TAffichagePpm> listSelectionTransmission) {
		this.listSelectionTransmission = listSelectionTransmission;
	}



	public List<VPgpmFonction> getListePgpm() {
		return listePgpm;
	}



	public void setListePgpm(List<VPgpmFonction> listePgpm) {
		this.listePgpm = listePgpm;
	}



	public List<TTypeMarche> getListeTypeMarches() {
		return listeTypeMarches;
	}



	public void setListeTypeMarches(List<TTypeMarche> listeTypeMarches) {
		this.listeTypeMarches = listeTypeMarches;
	}



	public TModePassation getRecupModePassation() {
		return recupModePassation;
	}



	public void setRecupModePassation(TModePassation recupModePassation) {
		this.recupModePassation = recupModePassation;
	}



	public TDetailPlanPassation getPpm() {
		return ppm;
	}



	public void setPpm(TDetailPlanPassation ppm) {
		this.ppm = ppm;
	}



	public TMinistere getRecupMinistere() {
		return recupMinistere;
	}



	public void setRecupMinistere(TMinistere recupMinistere) {
		this.recupMinistere = recupMinistere;
	}



	public TFonction getRecupFonction() {
		return recupFonction;
	}



	public void setRecupFonction(TFonction recupFonction) {
		this.recupFonction = recupFonction;
	}



	public VTypeMarcheFils getMarche() {
		return marche;
	}



	public void setMarche(VTypeMarcheFils marche) {
		this.marche = marche;
	}



	public String getFiltrePpm() {
		return filtrePpm;
	}



	public void setFiltrePpm(String filtrePpm) {
		this.filtrePpm = filtrePpm;
	}



	public TMinistere getMinistere() {
		return ministere;
	}



	public void setMinistere(TMinistere ministere) {
		this.ministere = ministere;
	}



	public VLigneImputation getLigne() {
		return ligne;
	}



	public void setLigne(VLigneImputation ligne) {
		this.ligne = ligne;
	}



	public List<TModePassation> getListeModePassation() {
		return listeModePassation;
	}



	public void setListeModePassation(List<TModePassation> listeModePassation) {
		this.listeModePassation = listeModePassation;
	}



	public String getFiltrePgpm() {
		return filtrePgpm;
	}



	public void setFiltrePgpm(String filtrePgpm) {
		this.filtrePgpm = filtrePgpm;
	}



	public String getMultiFiltre() {
		return multiFiltre;
	}



	public void setMultiFiltre(String multiFiltre) {
		this.multiFiltre = multiFiltre;
	}



	public VPgpmFonction getRecupPgpm() {
		return recupPgpm;
	}



	public void setRecupPgpm(VPgpmFonction recupPgpm) {
		this.recupPgpm = recupPgpm;
	}



	public TAffichagePpm getSlctdTdPpm() {
		return slctdTdPpm;
	}

	public void setSlctdTdPpm(TAffichagePpm slctdTdPpm) {
		this.slctdTdPpm = slctdTdPpm;
	}



	public VLigneImputation getRecupLigne() {
		return recupLigne;
	}



	public void setRecupLigne(VLigneImputation recupLigne) {
		this.recupLigne = recupLigne;
	}



	public TDetailPlanPassation getRecuPpm() {
		return recuPpm;
	}

	public void setRecuPpm(TDetailPlanPassation recuPpm) {
		this.recuPpm = recuPpm;
	}



	public long getTotalLigne() {
		return totalLigne;
	}



	public void setTotalLigne(long totalLigne) {
		this.totalLigne = totalLigne;
	}



	public long getGesCode() {
		return gesCode;
	}



	public void setGesCode(long gesCode) {
		this.gesCode = gesCode;
	}



	public long getTotalMontant() {
		return totalMontant;
	}



	public void setTotalMontant(long totalMontant) {
		this.totalMontant = totalMontant;
	}
	
	
	 
	 
	 
	 

}
