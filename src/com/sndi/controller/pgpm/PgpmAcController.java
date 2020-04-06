package com.sndi.controller.pgpm;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.agpm.AgpmController;
import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAffichageAgpm;
import com.sndi.model.TAffichagePgpm;
import com.sndi.model.TAffichagePpm;
import com.sndi.model.TAgpm;
import com.sndi.model.TBailleur;
import com.sndi.model.TComposante;
import com.sndi.model.TDetailPlanGeneral;
import com.sndi.model.TDevise;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TDossierPlanGeneral;
import com.sndi.model.TFinancement;
import com.sndi.model.TFinancementPgpm;
import com.sndi.model.TFinancementPpm;
import com.sndi.model.TFonction;
import com.sndi.model.TGestion;
import com.sndi.model.THistoAgpm;
import com.sndi.model.THistoPlanGeneral;
import com.sndi.model.TMinistere;
import com.sndi.model.TModePassation;
import com.sndi.model.TNaturePiece;
import com.sndi.model.TPlanGeneral;
import com.sndi.model.TSourceFinancement;
import com.sndi.model.TStatut;
import com.sndi.model.TStructure;
import com.sndi.model.TTypeMarche;
import com.sndi.model.VAgpm;
import com.sndi.model.VAgpmFonction;
import com.sndi.model.VAgpmMinistere;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VModePassation;
import com.sndi.model.VModePassationPn;
import com.sndi.model.VPgpm;
import com.sndi.model.VPgpmStatut;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.model.VUpdateAgpm;
import com.sndi.model.VUpdatePgpm;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class PgpmAcController {
Logger _logger = Logger.getLogger(PgpmAcController.class);
	
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
		chargeData();	
		chargeBailleur();
		chargeDevise();
		chargeGestions();
		chargeMinisteres();
		chargeFonctionCpm();
		chargeMarches();
		chargeModePassation();
		chargeMode();
		chargeSourceFinance();
		//chargeAgpm();
		chargeDataAvaliderPgpm();
		chargeDataAvaliderPgspm();
		chargeDataPgspm();
		chargePgpmTrans();
		chargePgpmDifAc();
		chargePgspmTrans();
		chargePgpmValDmp();
		chargePgspmValDmp();
		chargePgspmValCp();
		chargePgspmDifCp();
		chargePgspmDifDmp();
		chargePgpmValCp();
		chargePgpmDifCp();
		chargePgpmDifDmp();
		chargePgpmDifDmp();
		chargeData();
		DataToday();
	 }
	 
	 
	 
	    //Declaration des listes
		//private List<TDetailPlanGeneral> objetListe = new ArrayList<TDetailPlanGeneral>();
	     private List <VPgpmStatut> pgpmstatutList = new ArrayList<VPgpmStatut>(); 
	     private List<THistoPlanGeneral> listeHisto = new ArrayList<THistoPlanGeneral>();
	     private List<VPgpm> objetListe = new ArrayList<VPgpm>(); 
	     private List<VUpdatePgpm> listUpdate = new ArrayList<VUpdatePgpm>();
	     private List<TAffichagePgpm> objetList = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> listPgpm = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> listPgspm = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> pgpmTrans = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> pgspmTrans = new ArrayList<TAffichagePgpm>();
	     private List<TMinistere> listeMinistere = new ArrayList<TMinistere>();
	     private List<VFonctionMinistere> listeFonctions = new ArrayList<VFonctionMinistere>();
		 private List<VFonctionMinistere> listeFonctionsDmp = new ArrayList<VFonctionMinistere>();
		 private List<TDetailPlanGeneral> listeDetail = new ArrayList<TDetailPlanGeneral>();
		 private List<TBailleur> listeBailleurs = new ArrayList<TBailleur>();
		 private List<TSourceFinancement> listeSourceFinance = new ArrayList<TSourceFinancement>();
		 private List<VAgpmMinistere> listeAgpm = new ArrayList<VAgpmMinistere>();
         // private List<TAgpm> agpmList = new ArrayList<TAgpm>();
		 private List<VAgpmFonction> agpmList = new ArrayList<VAgpmFonction>();
		 private List<TDevise> listeDevise = new ArrayList<TDevise>();
		// private List<TTypeMarche> listeTypeMarches = new ArrayList<TTypeMarche>();
		 private List<VTypeMarcheFils> listeTypeMarches = new ArrayList<VTypeMarcheFils>();
		 private List<VModePassationPn> listeModePassation = new ArrayList<VModePassationPn>();
		 private List<TFinancement> listeFinancementAgpm = new ArrayList<TFinancement>();
		 
		 
		 private List<TGestion> listeGestion = new ArrayList<TGestion>();
		 private List<TFinancementPgpm> listeFinancement = new ArrayList<TFinancementPgpm>();
		 private List<TFinancementPgpm> financementListe = new ArrayList<TFinancementPgpm>();
		 private List<TAffichagePgpm>listSelectionTransmission =new ArrayList<TAffichagePgpm>();
		 private List<TDossierPlanGeneral> dossListe = new ArrayList<TDossierPlanGeneral>();
		 private TDossierPlanGeneral selectedDossier = new TDossierPlanGeneral();
		 private List<TAffichagePgpm> validationListe = new ArrayList<TAffichagePgpm>(); 
		 private List<TAffichagePgpm> validationListePgspm = new ArrayList<TAffichagePgpm>();
		 private List<TAffichagePgpm> pgpmValCp = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> pgpmValDmp = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> pgspmValCp = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> pgspmValDmp = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> pgpmDifCp = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> pgpmDifDmp = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> pgspmDifCp = new ArrayList<TAffichagePgpm>();
	     private List<TAffichagePgpm> pgspmDifDmp = new ArrayList<TAffichagePgpm>();
	     private List<TPlanGeneral> listPlan = new ArrayList<TPlanGeneral>();
		 private List<TStructure> listeStructure = new ArrayList<TStructure>();
		 private List<VModePassation> listeMode = new ArrayList<VModePassation>();

	 
	//Declaration des objets
		 private TPlanGeneral plan = new TPlanGeneral();
		 private VPgpmStatut pgpmstatut= new VPgpmStatut();
		 private TDetailPlanGeneral detailPlan = new TDetailPlanGeneral();
		 private VUpdatePgpm updateOperation = new VUpdatePgpm();
		 private VTypeMarcheFils marche = new VTypeMarcheFils();
		 private TTypeMarche reucpMarche = new TTypeMarche();
		 private VModePassationPn modePassation = new VModePassationPn();
		 private VModePassation passationListe = new VModePassation();
		 private VModePassationPn recupModePassation = new VModePassationPn();
		 private VModePassation recupModeListe = new VModePassation();
		 private VFonctionMinistere fonction =new VFonctionMinistere();
		 private TFinancementPgpm newFinancement = new TFinancementPgpm();
		 private TFinancementPgpm selectFinance = new TFinancementPgpm();
		 //private TAgpm agpm = new TAgpm();
		 private VAgpmFonction agpm = new VAgpmFonction();
		 private THistoPlanGeneral histoPgpm = new THistoPlanGeneral();
		 private TAgpm recupAgpm = new TAgpm();
		 private TDetailPlanGeneral demDetail = new TDetailPlanGeneral();
		 private TAffichagePgpm slctdTd = new TAffichagePgpm();
		 private TMinistere ministere= new TMinistere();
		 private TMinistere recupMinistere= new TMinistere();
		 private TFonction recupFonction= new TFonction();
		 private TStructure structure= new TStructure();
		 private TStructure recupStructure= new TStructure(); 
		 private TFinancement finAgpm = new TFinancement();
		//Declaration des variables
		 private long gesCode;	
		 private String filtreTypeMarche="";
		 private String filtreModePassation="";
		 private String nbrePgpm ="";
		 private String nbrePgspm ="";
		 private String observation="";
		 private String natPiece ="";
		 private String baiCode="";
		 private String souCode;
		 private String devCode="CFA";
		 private String sit = "";
		 private String filtreFonction="";
		 private String filtreMinistere="";
		 private String filtreStructure="";
		 private String statutAffiche="";
		 private String statutUpdate="";
		 private String statutTrans ="";
		 private String finBaiCaode ="ETAT";
		 private String multiFiltre="";
		 public boolean selectBailleur=false;
		 private String sourfin;
		 private String dateToday;
		 //Boolean
		 private boolean etatAgpm =false;
		 private boolean etatDossier = false;
		 private boolean etatEdit =false;
		 private boolean etatFinancement1 =true;
		 private boolean etatFinancement2 =false;
		 private boolean btnNewAgpm =false;
		 private boolean btnAgpmRappel =false;
		 private boolean loveAgpmRappel =false;
		 public boolean selectTresor =false;
		 private boolean btnPgspmRappel =false;
		 private boolean selectPartBai = false;
		 
		 
		 
		 //Methodes de modification
		//Methode de récupération de t_pgpm dans t_affichage
		 public void editForm() {
		    			listUpdate= (List<VUpdatePgpm>) iservice.getObjectsByColumn("VUpdatePgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
		    					 new WhereClause("AFF_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffId()));
		    			if (!listUpdate.isEmpty()) {
		    				updateOperation=listUpdate.get(0); 
		    			}
		 }
		 
		 //Afficher les financements du projet ou agpm selectionné
		 public void chargeFinancementUpdate() {
			 listeFinancement.clear();
			 listeFinancement = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+slctdTd.getAffGpgId())));		 		 
		 }
		 
		 //OnselectModifications
		 public void onSelectMarcheModif() {
			 updateOperation.setGpgTymCode(marche.getTymCode());
			 updateOperation.setTymLibelleCourt(marche.getTymLibelleCourt());
		 }
		 
		 public void onSelectModePassationModif() {
			 updateOperation.setGpgMopCode(modePassation.getMopCode());
			 updateOperation.setMopLibelleLong(modePassation.getMopLibelleLong());		
		}
		
		 public void onSelectAgpmModif() {
			 updateOperation.setGpgAgpId(slctdTd.getAffGpgAgpId());
			 updateOperation.setAffGpgCommentaire(updateOperation.getAffGpgCommentaire());
	
			 listeFinancementAgpm =(List<TFinancement>) iservice.getObjectsByColumn("TFinancement", new ArrayList<String>(Arrays.asList("FIN_ID")),
				     new WhereClause("FIN_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgAgpId()));
			 if (!listeFinancementAgpm.isEmpty()) {
				  finAgpm=listeFinancementAgpm.get(0);
				    }  		 
				}
		 
		//Methode
		  public void DataToday() {
			  Date date = Calendar.getInstance().getTime();
			  DateFormat  formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			  dateToday = formatter1.format(date); 
		  }
		
		 
		 public void chargeData(){
			 getObjetList().clear();
			 objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
					"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SDR")),
					new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("objetListe size: "+objetList.size());	
				tableauBordController.chargeDataPgpm();
				nbrePgpm =""+getNbrePgpmTotal();
		}
		 
		 public int getNbrePgpmTotal(){
				int i = iservice.countTableByColumn("T_AFFICHAGE_PGPM", "AFF_ID",
						new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
						new WhereClause("AFF_GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
		 
		 public int getNbrePgspmTotal(){
				int i = iservice.countTableByColumn("T_AFFICHAGE_PGPM", "AFF_ID",
						new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						new WhereClause("AFF_GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
		 
		 public void chargeDataPgspm(){
			 getObjetList().clear();
			 listPgspm = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
					"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","PGD")),
					new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("objetListe size: "+objetList.size());	
				tableauBordController.chargeDataPgspm();
				nbrePgspm =""+getNbrePgspmTotal();
		}
		 
		 
		 
		 //PGPM
		 public void chargeDataAvaliderPgpm() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else 
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 getValidationListe().clear();
					 validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
								"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
								new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
							_logger.info("affichageListe size: "+validationListe.size());
							tableauBordController.chargeDataPgpm();
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
								validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
										"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
										new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
								//new WhereClause("AFF_GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
								tableauBordController.chargeDataPgpm();
								_logger.info("affichageListe size: "+validationListe.size());	
					 }
			     
			   
			 }
		 
		 //PGSPM
		 public void chargeDataAvaliderPgspm() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 getValidationListe().clear();
					 validationListePgspm = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
								"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
								new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
					 tableauBordController.chargeDataPgspm();;
							_logger.info("affichageListe size: "+validationListePgspm.size());		 
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
						 validationListePgspm = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
								 "AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","PGS")),
								new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
								//new WhereClause("AFF_GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
								tableauBordController.chargeDataPgspm();
								_logger.info("affichageListe size: "+validationListePgspm.size());	
					 }
			     } 
			   }
			 }
		 
		 
		//Filtre multicritère pour les PGPM
			public void chargerPgpmRecherche() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 getObjetList().clear();
						 objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
								"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
								new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
								new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						        new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
							_logger.info("objetListe size: "+objetList.size());	 
							tableauBordController.chargeDataPgpm();
							nbrePgpm =""+getNbrePgpmTotal();
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  getValidationListe().clear();
									 validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
												"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
												new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
												new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
											_logger.info("affichageListe size: "+validationListe.size());
											tableauBordController.chargeDataPgpm();
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getValidationListe().clear();
										validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
												new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
										        new WhereClause("AFF_GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
												new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
										tableauBordController.chargeDataPgpm();
										_logger.info("affichageListe size: "+validationListe.size());
						    	  }
			               }
			
			
			//Réinitialisation pour les PGPM
			public void reinitialiserPgpm() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getObjetList().clear();
					 objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
							"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
							new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
							new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("objetListe size: "+objetList.size());	
						tableauBordController.chargeDataPgpm();
						nbrePgpm =""+getNbrePgpmTotal();
						multiFiltre ="";
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  getValidationListe().clear();
									 validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
												"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
												new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
											_logger.info("affichageListe size: "+validationListe.size());
											tableauBordController.chargeDataPgpm();
											multiFiltre ="";
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getValidationListe().clear();
										validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
												"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPG")),
												new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
										//new WhereClause("AFF_GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
										tableauBordController.chargeDataPgpm();
										_logger.info("affichageListe size: "+validationListe.size());
										multiFiltre ="";
						    	  }
			               }
			
			
			//Réinitialisation pour les PGPM
			public void reinitialiserPgspm() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getObjetList().clear();
					 objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
							"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
							new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
							new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("objetListe size: "+objetList.size());	
						tableauBordController.chargeDataPgspm();
						nbrePgpm =""+getNbrePgpmTotal();
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  getValidationListe().clear();
									 validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
												"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
												new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
											_logger.info("affichageListe size: "+validationListe.size());
											tableauBordController.chargeDataPgspm();
											multiFiltre="";
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getValidationListe().clear();
										validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
												"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPG")),
												new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
										_logger.info("affichageListe size: "+validationListe.size());
										       tableauBordController.chargeDataPgspm();
										       multiFiltre="";	
						    	  }
			               }
		 
		
			
			
			//Tri sur les types de financement  
			public void chargeSourceCheck() { 
		    listeSourceFinance.clear();
			listeSourceFinance=(List<TSourceFinancement>) iservice.getObjectsIn("TSourceFinancement", new ArrayList<String>(Arrays.asList("SOU_CODE")),
			      "SOU_CODE", new ArrayList<String>(Arrays.asList("EMP","DON")));
				}
			 
			 public void checkBailleur() {
				 //sourfin="";
				 if(sourfin.equalsIgnoreCase("Bailleur")) { 
					 selectBailleur = true;
					 selectTresor = false;
					 selectPartBai = true;
					 chargeSourceCheck();
					 //sourfin="";
				 }else
				      if(sourfin.equalsIgnoreCase("Cofinance")){
					 selectBailleur = true; 
					 selectTresor = true;
					 selectPartBai = true;
					// sourfin="";
				 }else 
					 if(sourfin.equalsIgnoreCase("Etat")){
					 selectBailleur = false;
					 selectTresor = true;
					 selectPartBai= false;
					 souCode="TRE";
				    }else 
				         if(sourfin.equalsIgnoreCase("")){
				    	  selectPartBai = false;
				    	  selectBailleur = false;
						  selectTresor = false;
						  souCode="";
				    }
			 }
			
			
			//Filtre multicritère pour les PGSPM
			public void chargerPgspmRecherche() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 getObjetList().clear();
						 objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
								"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
								new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
								new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						        new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
							_logger.info("objetListe size: "+objetList.size());	 
							tableauBordController.chargeDataPgspm();
							nbrePgpm =""+getNbrePgpmTotal();
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  getValidationListe().clear();
									 validationListePgspm = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
												"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
												new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
												new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
									 tableauBordController.chargeDataPgspm();;
											_logger.info("validationListePgspm size: "+validationListePgspm.size());	
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getValidationListe().clear();
						    		  validationListePgspm = (List<TAffichagePgpm>) iservice.getObjectsByColumnDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
												new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
										        new WhereClause("AFF_GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
												new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
										tableauBordController.chargeDataPgspm();
										_logger.info("validationListePgspm size: "+validationListePgspm.size());
						    	  }
			               }
		 
		 
		 
		 public void chargeDataTransmission(){
			 getObjetList().clear();
				objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
					new WhereClause("AFF_GPG_STA_CODE",WhereClause.Comparateur.EQ,"S1T"),
					new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				tableauBordController.chargeDataPgpmPgspm();
				_logger.info("objetListe size: "+objetList.size());	
		}
		 
		 
		//Affichage des motifs de retour
			public void chargerObservation() {
				pgpmstatutList=(List<VPgpmStatut>) iservice.getObjectsByColumn("VPgpmStatut", new ArrayList<String>(Arrays.asList("HPG_GPG_ID")),
						new WhereClause("HPG_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()),
						new WhereClause("HPG_STA_CODE",WhereClause.Comparateur.EQ,slctdTd.getTStatut().getStaCode()));
				if(!pgpmstatutList.isEmpty()) {
					int i=pgpmstatutList.size();
					int baoule=i-1;
					pgpmstatut=pgpmstatutList.get(baoule);
				}	
			}
			
			
		
			 //Liste des Pgpm transmis par l'acteur connecté
			 public void chargePgpmTrans() {
				 pgpmTrans.clear();
				 pgpmTrans = ((List<TAffichagePgpm>)iservice.getObjectsByColumnIn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    "AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","SPG")),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
							 new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
			 }
			 
			 //Liste des Pgspm transmis par l'acteur connecté
			 public void chargePgspmTrans() {
				 pgspmTrans.clear();
				 pgspmTrans = ((List<TAffichagePgpm>)iservice.getObjectsByColumnIn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    "AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","PGS")),
						     new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS"),
							 new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
			 }
			 
			 
			 
			 //Liste des Pgpm validés par le cpmp
			 public void chargePgpmValCp() {
				 pgpmValCp.clear(); 
				 pgpmValCp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S2V"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
							 new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }
			 
			 
			 //Liste des Modes de Passation restreint
			 public void chargeMode() {
				 listeMode.clear();
				 listeMode = ((List<VModePassation>)iservice.getObjectsByColumn("VModePassation",new ArrayList<String>(Arrays.asList("MOP_CODE"))));	 		 
			 }
			 
			//Liste des Modes de Passation restreint
			 public void razchargeMode() {
				 listeMode.clear();
				 listeMode = ((List<VModePassation>)iservice.getObjectsByColumn("VModePassation",new ArrayList<String>(Arrays.asList("MOP_CODE"))));
				 filtreModePassation="";
			 } 
			 
			 //Filtre de la Liste des Modes de Passation restreint
			 public void filtreChargeMode() {
				 listeMode.clear();
				 listeMode = ((List<VModePassation>)iservice.getObjectsByColumn("VModePassation",new ArrayList<String>(Arrays.asList("MOP_CODE")),
						 new WhereClause("MOP_LIBELLE_LONG",WhereClause.Comparateur.LIKE,"%"+filtreModePassation+"%")));	 		 
			 }
			 
			
			 
			//Liste des Pgpm validés par le dmp
			 public void chargePgpmValDmp() {
				 pgpmValDmp.clear();
				 pgpmValDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN")));		 		 
			 }
			 
			 
			 //Liste des Pgspm différés par le cpmp
			 public void chargePgpmDifCp() {
				// pgpmDifCp.clear();
				 pgpmDifCp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S2D"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
							 new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }
			 
			//Liste des Pgpm différés par le cpmp
			 public void chargePgpmDifDmp() {
				// pgpmDifDmp.clear();
				 pgpmDifDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumnIn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						 "AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SDR")),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN")));
							// new WhereClause("AFF_DPP_MIN_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode())));		 		 
			      }
			 
			//Liste des Pgpm différés par le cpmp
			 public void chargePgpmDifAc() { 
				// pgpmDifDmp.clear();
				 pgpmDifDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumnIn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						 "AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2D","SDR")),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
						 new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));
							// new WhereClause("AFF_DPP_MIN_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode())));		 		 
			      }
			 
			 //Liste des Pgspm validés par le cpmp
			 public void chargePgspmValCp() {
				 pgspmValCp.clear();
				 pgspmValCp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S2V"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS"),
							 new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }
			 
			 
			//Liste des Pgpm validés par le cpmp
			 public void chargePgspmValDmp() {
				 pgspmValDmp.clear();
				 pgspmValDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS")));
							// new WhereClause("AFF_DPP_MIN_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode())));		 		 
			 }
			 
			 //Liste des Pgspm différés par le cpmp
			 public void chargePgspmDifCp() {
				 pgspmDifCp.clear();
				 pgspmDifCp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S2D"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS"),
							 new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }
			 
			 
			//Liste des Pgpm différés par le cpmp
			 public void chargePgspmDifDmp() {
				 pgspmDifDmp.clear();
				 pgspmDifDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S3D"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS")));
							// new WhereClause("AFF_DPP_MIN_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode())));		 		 
			 }
			 
			 
	 
	 
		//ACombobox Gestions
		 public void chargeGestions(){
			 listeGestion=(List<TGestion>) iservice.getObjectsByColumnDesc("TGestion", new ArrayList<String>(Arrays.asList("GES_CODE")));	
		 }
		 
	  
		//Combobox Bailleur
	  public void chargeBailleur() {
		 listeBailleurs.clear();
		 listeBailleurs =(List<TBailleur>) iservice.getObjectsByColumn("TBailleur", new ArrayList<String>(Arrays.asList("baiCode")));
		}
	  
	//Combobox Source de finacement
		 public void chargeSourceFinance() {
			 listeSourceFinance.clear();
			 listeSourceFinance =(List<TSourceFinancement>) iservice.getObjectsByColumn("TSourceFinancement", new ArrayList<String>(Arrays.asList("souCode")));
			}
		//Combobox Devises
		 public void chargeDevise() {
			 listeDevise.clear();
			 listeDevise =(List<TDevise>) iservice.getObjectsByColumn("TDevise", new ArrayList<String>(Arrays.asList("devCode")));
			}
		 
		//Chargement des Types de Marchés
		 public void chargeMarches() {
			 listeTypeMarches.clear();
			 listeTypeMarches =(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")));
			 filtreTypeMarche ="";
			}
		 
		//Réinitialiser les Types de Marchés
		 public void razchargeMarches() {
			 listeTypeMarches.clear();
			 listeTypeMarches =(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")));
			 filtreTypeMarche ="";
			}
		 
		 
		//Réinitialiser les modes de Passation
		 public void razchargeModePassation() {
			 listeModePassation.clear();
			 listeModePassation =(List<VModePassationPn>) iservice.getObjectsByColumn("VModePassationPn", new ArrayList<String>(Arrays.asList("mopCode")));
			 filtreModePassation="";
			}
		 
		 
		//Chargement des modes de Passtion
		 public void chargeModePassation() {
			 listeModePassation.clear();
			 listeModePassation =(List<VModePassationPn>) iservice.getObjectsByColumn("VModePassationPn", new ArrayList<String>(Arrays.asList("mopCode")));
			 filtreModePassation="";
			}
		 
		 //Afficher les financements du projet ou agpm selectionné
		 public void chargeFinancement() {
			 listeFinancement.clear();
			 listeFinancement = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+detailPlan.getGpgId())));		 		 
		 }
		 
		 //Afficher les financements du projet ou agpm selectionné
		 public void chargeFinancementDetail() {
			 financementListe.clear();
			 financementListe = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+slctdTd.getAffGpgId())));		 		 
		 }
		 
		 //Afficher les Agpm 
		 public void chargeAgpm() {
			 agpmList.clear();
			 agpmList = (List<VAgpmFonction>)iservice.getObjectsByColumnDesc("VAgpmFonction",new ArrayList<String>(Arrays.asList("AGP_ID")),
					     new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
					     new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						 new WhereClause("AGP_ACTIF",Comparateur.EQ,"1"));
			 if (!agpmList.isEmpty()) {
				  agpm=agpmList.get(0);
				    } 
		 }
		 
		 public void filtreAgpm() {
			 agpmList.clear();
			 agpmList = (List<VAgpmFonction>)iservice.getObjectsByColumnDesc("VAgpmFonction",new ArrayList<String>(Arrays.asList("AGP_ID")),
				     new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
				     new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					 new WhereClause("AGP_ACTIF",Comparateur.EQ,"1"),
					 new WhereClause("PRO_TITRE",WhereClause.Comparateur.LIKE,"%"+filtreTypeMarche+"%"));
		 }
		 
		 //Filtre les marchés en fonction du code Marché
		 public void filtreMarche() {
			 listeTypeMarches.clear();
			 listeTypeMarches = (List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("TYM_CODE")),
						new WhereClause("TYM_LIBELLE_COURT",WhereClause.Comparateur.LIKE,"%"+filtreTypeMarche+"%"));
		 }
		 
		 
		//Filtre les modes de Passtion en fonction du code Passation
		 public void filtreModePassation() {
			 listeModePassation.clear();
			 listeModePassation =(List<VModePassationPn>) iservice.getObjectsByColumn("VModePassationPn", new ArrayList<String>(Arrays.asList("MOP_CODE")),
					 new WhereClause("MOP_LIBELLE_LONG",WhereClause.Comparateur.LIKE,"%"+filtreModePassation+"%"));
			}
		 
		 
		 public void onSelectMarche() {
			 //detailPlan = new TDetailPlanGeneral();
			 detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
			 detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymTymCode()));

			 reucpMarche = new TTypeMarche();
			 reucpMarche.setTymCode(marche.getTymCode());
			 reucpMarche.setTymLibelleCourt(marche.getTymLibelleCourt());
				}
		 
		 
		 public void onSelectAgpm() {
			 detailPlan.setGpgAgpId(agpm.getAgpId());

			 recupAgpm = new TAgpm();
			 recupAgpm.setAgpCommentaire(agpm.getAgpCommentaire());
			 //chargeAgpm();
	
			 listeFinancementAgpm =(List<TFinancement>) iservice.getObjectsByColumn("TFinancement", new ArrayList<String>(Arrays.asList("FIN_ID")),
				     new WhereClause("FIN_AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
			 if (!listeFinancementAgpm.isEmpty()) {
				  finAgpm=listeFinancementAgpm.get(0);
				    } 
			 
			 
				}
		 
		 
		 
		  //Chargement des ministères
		 public void chargeMinisteres() {
			 listeMinistere.clear();
		 listeMinistere =(List<TMinistere>) iservice.getObjectsByColumn("TMinistere", new ArrayList<String>(Arrays.asList("minCode")));
			}
		 
		 
		  //Supprimer un dossier
        public void removeDossier(){
	downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDpgLibelle(), selectedDossier.getDpgLibelle());
	//check si le dossier est OM
		 iservice.deleteObject(selectedDossier);
		 chargeDossier();	 
	 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDpgLibelle()+" supprimé!", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);	
	}
        
        
        
        //Transmission par l'AC,CPMP,DMP
        public void transmettre()throws IOException{
        	if (listSelectionTransmission.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune opération selectionnée", ""));
			}
	 		else{
	 			
	 			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
	 				if(userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("02")) {
	 						statutTrans ="S1T"; 
	 					}else
	 						 if(userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("03")) {
	 							statutTrans ="SPG";  
	 								}else {
	 									  statutTrans ="SPG"; 
	 								  }
	 						   }
	 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
		 		for(TAffichagePgpm ligne : listSelectionTransmission) {
		 			 
		 			//Parcourir la liste et récupérer les demande au statut E1T
		 			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
								new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getAffGpgId()));
							if (!listeDetail.isEmpty()) {
								demDetail= listeDetail.get(0);
								if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
									 demDetail.setGpgDateValAc(Calendar.getInstance().getTime());
								 }else
									 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
										 demDetail.setGpgDateValCpmp(Calendar.getInstance().getTime());
									 }else
										 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {	
											 demDetail.setGpgDateValDmp(Calendar.getInstance().getTime());
										 }
								demDetail.setTStatut(new TStatut(statutTrans));
								demDetail.setGpgStatutRetour("0");
						       iservice.updateObject(demDetail);
						       
					List<TAffichagePgpm> AG =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
			      						new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getAffGpgId()));
					   TAffichagePgpm pgpm = new TAffichagePgpm();
					   if(!AG.isEmpty()) pgpm =AG.get(0); 
					   if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
							 pgpm.setAffGpgDateValAc(Calendar.getInstance().getTime());
						 }else
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) { 
								pgpm.setAffGpgDateValCpmp(Calendar.getInstance().getTime());
							 }else
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
								   pgpm.setAffGpgDateValDmp(Calendar.getInstance().getTime());
								 }
					   
					    pgpm.setTStatut(new TStatut(statutTrans));
					    pgpm.setAffGpgStatutRetour("0");
					    iservice.updateObject(pgpm);
							}
			 			
			 			//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
							List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutTrans));
						    TStatut statuts = new TStatut();
						      if(!LS.isEmpty()) statuts = LS.get(0);
						  //Historisation des Plans Généraux
						     THistoPlanGeneral histoPlan = new THistoPlanGeneral();
						     histoPlan.setHpgDate(Calendar.getInstance().getTime());
						     histoPlan.setHpgMotif("Opération transmise à la CPMP");
						     histoPlan.setTStatut(statuts);
						     histoPlan.setTDetailPlanGeneral(demDetail);
						     histoPlan.setTFonction(userController.getSlctd().getTFonction());
						     histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
						     iservice.addObject(histoPlan);
									  
							 userController.setTexteMsg(" Transmission effectuée avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
							 //return	null 
			 		   }	
				     }
	 		        chargeData(); 	
	 		        chargePgpmTrans();
	 		       //chargeDataPgspm();
        }
        
        
        //Transmission par l'AC,CPMP,DMP
        public void transmettrePgspm()throws IOException{
        	if (listSelectionTransmission.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune demande selectionnée", ""));
			}
	 		else{
	 			
	 			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
	 				if(userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("02")) {
	 						statutTrans ="S1T"; 
	 					}else
	 						 if(userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("03")) {
	 							statutTrans ="PGS";  
	 								}else {
	 									  statutTrans ="PGS";
	 								  }
	 						   }
	 			  
	 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
		 		for(TAffichagePgpm ligne : listSelectionTransmission) {
		 			 
		 			//Parcourir la liste et récupérer les demande au statut E1T
		 			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
								new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getAffGpgId()));
							if (!listeDetail.isEmpty()) {
								demDetail= listeDetail.get(0);
								if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
									 demDetail.setGpgDateValAc(Calendar.getInstance().getTime());
								 }else
									 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
										 demDetail.setGpgDateValCpmp(Calendar.getInstance().getTime());
									 }else
										 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {	
											 demDetail.setGpgDateValDmp(Calendar.getInstance().getTime());
										 }
								demDetail.setTStatut(new TStatut(statutTrans));
								demDetail.setGpgStatutRetour("0");
						       iservice.updateObject(demDetail);
						       
					List<TAffichagePgpm> AG =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
			      						new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getAffGpgId()));
					   TAffichagePgpm pgpm = new TAffichagePgpm();
					   if(!AG.isEmpty()) pgpm =AG.get(0);
					   if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
							 pgpm.setAffGpgDateValAc(Calendar.getInstance().getTime());
						 }else
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) { 
								pgpm.setAffGpgDateValCpmp(Calendar.getInstance().getTime());
							 }else
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
								   pgpm.setAffGpgDateValDmp(Calendar.getInstance().getTime());
								 }
					    pgpm.setTStatut(new TStatut(statutTrans));
					    pgpm.setAffGpgStatutRetour("0");
					    iservice.updateObject(pgpm);
							}
			 			
			 			//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
							List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutTrans));
						    TStatut statuts = new TStatut();
						      if(!LS.isEmpty()) statuts = LS.get(0);
						  //Historisation des Plans Généraux
						     THistoPlanGeneral histoPlan = new THistoPlanGeneral();
						     histoPlan.setHpgDate(Calendar.getInstance().getTime());
						     histoPlan.setHpgMotif("Opération PGSPM transmise");
						     histoPlan.setTStatut(statuts);
						     histoPlan.setTDetailPlanGeneral(demDetail);
						     histoPlan.setTFonction(userController.getSlctd().getTFonction());
						     histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
						     iservice.addObject(histoPlan);
									  
							 userController.setTexteMsg(" Transmission effectuée avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
							 //return	null; 
			 		   }	
				     }
	 		        //chargeData(); 	
	 		       chargeDataPgspm();
	 		      chargePgspmTrans();
        }
        
        //Validation par le CPMP DMP
      @Transactional
		public void validerCPMPDMP()throws IOException{ 
	 		if (listSelectionTransmission.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune demande selectionnée", ""));
			}
	 		else{
	 			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
	 					 statutUpdate ="";
	 				 }else {
	 					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
	 						 statutUpdate ="S2V";
	 					 }else {
	 						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
	 							 statutUpdate ="S3V";
	 						 }
	 				     } 
	 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
		 		for(TAffichagePgpm ligne : listSelectionTransmission) {
		 			 
		 			//Parcourir la liste et récupérer les demande au statut E1T
		 			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
								new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getAffGpgId()));
							if (!listeDetail.isEmpty()) {
								demDetail= listeDetail.get(0);
								if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
									 demDetail.setGpgDateValAc(Calendar.getInstance().getTime());
								 }else
									 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
										 demDetail.setGpgDateValCpmp(Calendar.getInstance().getTime());
									 }else
										 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {	
											 demDetail.setGpgDateValDmp(Calendar.getInstance().getTime());
										 }
								demDetail.setTStatut(new TStatut(statutUpdate));
								demDetail.setGpgStatutRetour("0");
						       iservice.updateObject(demDetail);
						       
					List<TAffichagePgpm> AG =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
			      						new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getAffGpgId()));
					   TAffichagePgpm pgpm = new TAffichagePgpm();
					   if(!AG.isEmpty()) pgpm =AG.get(0);
					   if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
							 pgpm.setAffGpgDateValAc(Calendar.getInstance().getTime());
						 }else
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
								 pgpm.setAffGpgDateValCpmp(Calendar.getInstance().getTime());
							 }else
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {	
									 pgpm.setAffGpgDateValDmp(Calendar.getInstance().getTime());
								 }
					    pgpm.setTStatut(new TStatut(statutUpdate));
					    pgpm.setAffGpgStatutRetour("0");
					    iservice.updateObject(pgpm);
							}
			 			
			 			//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
							List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1T"));
						    TStatut statuts = new TStatut();
						      if(!LS.isEmpty()) statuts = LS.get(0);
						  //Historisation des Plans Généraux
						     THistoPlanGeneral histoPlan = new THistoPlanGeneral();
						     histoPlan.setHpgDate(Calendar.getInstance().getTime());
						     histoPlan.setHpgMotif("Opération transmise");
						     histoPlan.setTStatut(statuts);
						     histoPlan.setTDetailPlanGeneral(demDetail);
						     histoPlan.setTFonction(userController.getSlctd().getTFonction());
						     histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
						     iservice.addObject(histoPlan);
									  
							 userController.setTexteMsg("Transmission effectuée avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
							 //return	null;
		 		           }	   
			 		      }	
				         }
	 		       tableauBordController.chargeDataPgpm();
	 		        chargeDataAvaliderPgpm();
	 		        chargePgpmValCp();
	 		        chargePgpmValDmp();
	 			    //chargeDataAvaliderPgspm();
			 		  //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Transmission effectuée avec succés! ", "")); 	 	
					}
      
      
      //Modification des operations
     public void modifierDetailPlan() throws IOException{
    	 
    	 //Modification dans TAffichagePgpm
    	 slctdTd.setAffGpgAgpId(updateOperation.getAffGpgAgpId());
    	 slctdTd.setAffGpgObjet(updateOperation.getGpgObjet());
    	 slctdTd.setTTypeMarche(new TTypeMarche(updateOperation.getTymCode()));
    	 slctdTd.setTModePassation(new TModePassation(updateOperation.getMopCode()));
    	 slctdTd.setAffGpgDateDao(updateOperation.getAffGpgDateDao());
    	 slctdTd.setAffGpgPartiePmePmi(updateOperation.getGpgPartiePmePmi());
    	 slctdTd.setAffGpgCommentaire(updateOperation.getGpgCommentaire()); 
    	 slctdTd.setAffGpgLibFin(updateOperation.getGpgLibFin());
    	 iservice.updateObject(slctdTd);
    	 
    	//Modification dans TDetailPlanGeneral
    	 List<TDetailPlanGeneral> PLG =iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
   				new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
    	 TDetailPlanGeneral detail = new TDetailPlanGeneral();
				if(!PLG.isEmpty()) detail =PLG.get(0); 
				detail.setGpgAgpId(slctdTd.getAffGpgAgpId());
				detail.setGpgCommentaire(slctdTd.getAffGpgCommentaire());
				detail.setGpgDateDao(slctdTd.getAffGpgDateDao());
				detail.setGpgLibFin(slctdTd.getAffGpgLibFin());
				detail.setGpgObjet(slctdTd.getAffGpgObjet());
				detail.setGpgPartiePmePmi(slctdTd.getAffGpgPartiePmePmi());
				detail.setTModePassation(slctdTd.getTModePassation());
				detail.setTTypeMarche(slctdTd.getTTypeMarche());
				detail.setGpgLibFin(updateOperation.getGpgLibFin());
   				iservice.updateObject(detail);
   				userController.renderPage("pgpm1");
		    	 userController.setTexteMsg("Modification éffectuée avec succès!");
			     userController.setRenderMsg(true);
			     userController.setSevrityMsg("success");
			     chargeData();
      }
     
     
      
      //Enregistrement d'une opération PGPM sans AGPM
      @Transactional
      public void creerDetailPlan() throws IOException{
    	  
    	  if(detailPlan.getGpgObjet().equalsIgnoreCase("") || detailPlan.getGpgPartiePmePmi().equalsIgnoreCase("") || detailPlan.getGpgCommentaire().equalsIgnoreCase("")
    			 ||"".equals(reucpMarche.getTymCode()) ||  "".equals(recupModePassation.getMopCode())) {
    		  //Message d'erreur
    		  FacesContext.getCurrentInstance().addMessage(null,
	          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir tous les champs", ""));
    	  }else {
    		       listPlan = (List<TPlanGeneral>) iservice.getObjectsByColumn("TPlanGeneral", new ArrayList<String>(Arrays.asList("PLG_ID")),
      			    new WhereClause("PLG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
      			    new WhereClause("PLG_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
  					new WhereClause("PLG_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
      	          if (!listPlan.isEmpty()) {
      		        plan= listPlan.get(0);
  			
      		         detailPlan.setTStatut(new TStatut("S1S"));
             	     detailPlan.setGpgStatutRetour("0");
             	     detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
             	     detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));
             	     detailPlan.setGpgAgpId(agpm.getAgpId());
             	     detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
             	     detailPlan.setGpgTypePlan("PN");
             	     detailPlan.setTPlanGeneral(plan);
             	     detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
             	     detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
             	     iservice.addObject(detailPlan);
             	 
             	 
             	     TAffichagePgpm affichagePgpm = new TAffichagePgpm();
             	     affichagePgpm.setAffGpgId(detailPlan.getGpgId());
             	     affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
             	     affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
             	     affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
             	     affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
             	     affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
             	     affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
             	     affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
             	     affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
             	     affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
             	     affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
             	     affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
             	     affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
             	     affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
             	     affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
             	     affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
             	     affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
             	     affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
             	     affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
             	     affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
             	     affichagePgpm.setAffGpgLibFin(detailPlan.getGpgLibFin());
             	     iservice.addObject(affichagePgpm);
             	     
             	    //Création du financement
         		   /* newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
 			        newFinancement.setTDevise(new TDevise(devCode));
 			        newFinancement.setTBailleur(new TBailleur(baiCode));
 			        newFinancement.setTDetailPlanGeneral(detailPlan);
 			        newFinancement.setFipTypeFinance(sourfin);
 			        iservice.addObject(newFinancement);*/
             	      	

          		    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
       			   TStatut statuts = new TStatut();
       			   if(!LS.isEmpty()) statuts = LS.get(0);
       			    //Historisation des Plan Généraux
       			   THistoPlanGeneral histoPlan = new THistoPlanGeneral();
       			   histoPlan.setHpgDate(Calendar.getInstance().getTime());
       			   histoPlan.setHpgMotif("PGPM crée par l'Autorité Contractante");
       			   histoPlan.setTStatut(statuts);
       			   histoPlan.setTDetailPlanGeneral(detailPlan);
       			   histoPlan.setTFonction(userController.getSlctd().getTFonction());
       			   histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
       			   iservice.addObject(histoPlan);
       			   
       			String search = detailPlan.getGpgLibFin()+""+detailPlan.getGpgObjet()+""+detailPlan.getGpgCommentaire()+""+userController.getSlctd().getTFonction().getFonCod()+""+detailPlan.getGpgActeurSaisie()+""+detailPlan.getGpgTypePlan()+""+detailPlan.getGpgStrCode()+""+detailPlan.getTModePassation().getMopCode()+""+detailPlan.getTTypeMarche().getTymCode()+""+plan.getTGestion().getGesCode()+""+detailPlan.getGpgDateDao()+""+detailPlan.getTModePassation().getMopLibelleLong()+""+detailPlan.getTTypeMarche().getTymLibelleCourt();
				String rechercheAll = search.replace("null","");
				
				List<TAffichagePgpm> AFG =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
		      				new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+affichagePgpm.getAffGpgId()));
	      				TAffichagePgpm affgp = new TAffichagePgpm();
	      				if(!AFG.isEmpty()) affgp =AFG.get(0); 
	      				    affgp.setAffGpgRecherche(rechercheAll);
		      				    iservice.updateObject(affgp);
       			
       			  chargeData();
       			
       			  userController.setTexteMsg("Opération créée avec succès! veuillez cliquer sur + pour ajouter un financement!");
       			  userController.setRenderMsg(true);
       			  userController.setSevrityMsg("success");
       			
       			  //etatDossier = true;
       			  controleController.btn_edit_pgpm = true; 
       			  controleController.btn_edit_pgspm = false; 
       			  btnAgpmRappel = false;
       			  loveAgpmRappel = true;
       			  
      		    
                }else {
          	          plan.setTGestion(new TGestion(gesCode));
         		      plan.setTFonction(userController.getSlctd().getTFonction());
         		      plan.setTStructure(userController.getSlctd().getTFonction().getTStructure());
         		      iservice.addObject(plan);
          	 
         		      detailPlan.setTStatut(new TStatut("S1S"));
           	          detailPlan.setGpgStatutRetour("0");
           	          detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
           	          detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));
           	          detailPlan.setGpgAgpId(agpm.getAgpId());
           	          detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
           	          detailPlan.setGpgTypePlan("PN");
           	          detailPlan.setTPlanGeneral(plan);
           	          detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
           	          detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
           	          iservice.addObject(detailPlan);
           	 
           	 
           	          TAffichagePgpm affichagePgpm = new TAffichagePgpm();
           	          affichagePgpm.setAffGpgId(detailPlan.getGpgId());
           	          affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
           	          affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
           	          affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
           	          affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
           	          affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
           	          affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
           	          affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
           	          affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
           	          affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
           	          affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
           	          affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
           	          affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
           	          affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
           	          affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
           	          affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
           	          affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
           	          affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
           	          affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
           	          affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
           	          affichagePgpm.setAffGpgLibFin(detailPlan.getGpgLibFin());
           	          iservice.addObject(affichagePgpm);
           	          
           	          //Création du financement
           		     /* newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
   			          newFinancement.setTDevise(new TDevise(devCode));
   			          newFinancement.setTBailleur(new TBailleur(baiCode));
   			          newFinancement.setTDetailPlanGeneral(detailPlan);
   			          newFinancement.setFipTypeFinance(sourfin);
   			          iservice.addObject(newFinancement);*/
       	 

        		      List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
     			      TStatut statuts = new TStatut();
     			       if(!LS.isEmpty()) statuts = LS.get(0);
     			       //Historisation des Plan Généraux
     			      THistoPlanGeneral histoPlan = new THistoPlanGeneral();
     			      histoPlan.setHpgDate(Calendar.getInstance().getTime());
     			      histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
     			      histoPlan.setTStatut(statuts);
     			      histoPlan.setTDetailPlanGeneral(detailPlan);
     			      histoPlan.setTFonction(userController.getSlctd().getTFonction());
     			      histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
     			      iservice.addObject(histoPlan);
     			      
     			     String search = detailPlan.getGpgLibFin()+""+detailPlan.getGpgObjet()+""+detailPlan.getGpgCommentaire()+""+userController.getSlctd().getTFonction().getFonCod()+""+detailPlan.getGpgActeurSaisie()+""+detailPlan.getGpgTypePlan()+""+detailPlan.getGpgStrCode()+""+detailPlan.getTModePassation().getMopCode()+""+detailPlan.getTTypeMarche().getTymCode()+""+plan.getTGestion().getGesCode()+""+detailPlan.getGpgDateDao()+""+detailPlan.getTModePassation().getMopLibelleLong()+""+detailPlan.getTTypeMarche().getTymLibelleCourt();
 					 String rechercheAll = search.replace("null","");
 					
 					 List<TAffichagePgpm> AFG =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
 			      				new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+affichagePgpm.getAffGpgId()));
 		      				TAffichagePgpm affgp = new TAffichagePgpm();
 		      				if(!AFG.isEmpty()) affgp =AFG.get(0); 
 		      				    affgp.setAffGpgRecherche(rechercheAll);
  		      				    iservice.updateObject(affgp);
     			
     			      chargeData();
     			
     			      userController.setTexteMsg("Opération créée avec succès! veuillez cliquer sur + pour ajouter un financement!");
     			      userController.setRenderMsg(true);
     			      userController.setSevrityMsg("success");
     			
     			      //etatDossier = true;
     			      controleController.btn_edit_pgpm = true;
     			      controleController.btn_edit_pgspm = false;
     			      btnAgpmRappel = false;
     			      loveAgpmRappel = true;
     			     controleController.btn_save_pgpm = true;
         		     
                   }
    	       }  
        }
      
      
    //Enregistrement d'une opération PGPM pour un AGPM
      @Transactional
      public void creerDetailPlanRappel() throws IOException{
    	  
    	  if(finAgpm.getFinId() > 0 ) {
    		  
    		  
        	  if(detailPlan.getGpgObjet().equalsIgnoreCase("") ||"".equals(detailPlan.getGpgObjet()) || detailPlan.getGpgPartiePmePmi().equalsIgnoreCase("") ||"".equals(detailPlan.getGpgPartiePmePmi()) || detailPlan.getGpgCommentaire().equalsIgnoreCase("")|| "".equals(detailPlan.getGpgCommentaire()) || marche.getTymCode().equalsIgnoreCase("")|| "".equals(marche.getTymCode()) || modePassation.getMopCode().equalsIgnoreCase("") || "".equals(modePassation.getMopCode()) ) {
        		  //Message d'erreur
        		  FacesContext.getCurrentInstance().addMessage(null,
    	          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir tous les champs", ""));
        	     }else {
        		         listPlan = (List<TPlanGeneral>) iservice.getObjectsByColumn("TPlanGeneral", new ArrayList<String>(Arrays.asList("PLG_ID")),
          			    new WhereClause("PLG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
          			    new WhereClause("PLG_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
      					new WhereClause("PLG_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
          	              if (!listPlan.isEmpty()) {
          		               plan= listPlan.get(0);
      			
          		               detailPlan.setTStatut(new TStatut("S1S"));
                 	           detailPlan.setGpgStatutRetour("0");
                 	           detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
                 	           detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));
                 	           detailPlan.setGpgAgpId(agpm.getAgpId());
                 	           detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
                 	           detailPlan.setGpgTypePlan("PN");
                 	           detailPlan.setTPlanGeneral(plan);
                 	           detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
                 	           detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
                 	           iservice.addObject(detailPlan);
                 	 
                 	 
                 	          TAffichagePgpm affichagePgpm = new TAffichagePgpm();
                 	          affichagePgpm.setAffGpgId(detailPlan.getGpgId());
                 	          affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
                 	          affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
                 	          affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
                 	          affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
                 	          affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
                 	          affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
                 	          affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
                 	          affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
                 	          affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
                 	          affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
                 	          affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
                 	          affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
                 	          affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
                 	          affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
                 	          affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
                 	          affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
                 	          affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
                 	          affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
                 	          affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
                 	         affichagePgpm.setAffGpgLibFin(detailPlan.getGpgLibFin());
                 	          iservice.addObject(affichagePgpm);
                 	          
                 	          //Insertion dans T_Financement_PGPM
                 	          
                 	          
                 	          if(finAgpm.getFinTypeFinance().equalsIgnoreCase("ETAT")) {
                 	        	newFinancement.setTBailleur(new TBailleur("ETAT")); 
                 	          }else
                 	        	  {
                 	        	  newFinancement.setTBailleur(new TBailleur(finAgpm.getTBailleur().getBaiCode()));  
                 	        	  }
   	        	 	  		  newFinancement.setFipTypeFinance(finAgpm.getFinTypeFinance());
   	        	 	  		  newFinancement.setTDetailPlanGeneral(detailPlan);
   	        	 	  		  newFinancement.setTSourceFinancement(new TSourceFinancement(finAgpm.getTSourceFinancement().getSouCode()));
   	        	 	  		  newFinancement.setTDevise(new TDevise(finAgpm.getTDevise().getDevCode()));
   	        	 	  		  newFinancement.setFipMontantDevise(finAgpm.getFinMontantDevise());
   	        	 	  		  newFinancement.setFipMontantCfa(finAgpm.getFinMontantCfa());
   	        	 	  		  iservice.addObject(newFinancement);
   	        	 			

              		          List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
           			          TStatut statuts = new TStatut();
           			          if(!LS.isEmpty()) statuts = LS.get(0);
           			          //Historisation des Plan Généraux
           			          THistoPlanGeneral histoPlan = new THistoPlanGeneral();
           			          histoPlan.setHpgDate(Calendar.getInstance().getTime());
           			          histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
           			          histoPlan.setTStatut(statuts);
           			          histoPlan.setTDetailPlanGeneral(detailPlan);
           			          histoPlan.setTFonction(userController.getSlctd().getTFonction());
           			          histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
           			          iservice.addObject(histoPlan);
           			   
           			          String search = detailPlan.getGpgObjet()+""+detailPlan.getGpgCommentaire()+""+detailPlan.getGpgSourceFin()+""+detailPlan.getGpgActeurSaisie()+""+detailPlan.getGpgTypePlan()+""+detailPlan.getGpgStrCode()+""+detailPlan.getTModePassation().getMopCode()+""+detailPlan.getTTypeMarche().getTymCode()+""+plan.getTGestion().getGesCode()+""+detailPlan.getGpgDateDao()+""+detailPlan.getTModePassation().getMopLibelleLong()+""+detailPlan.getTTypeMarche().getTymLibelleCourt();
    				          String rechercheAll = search.replace("null","");
    				
    				          List<TAffichagePgpm> AFG =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
    		      				new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+affichagePgpm.getAffGpgId()));
    	      				       TAffichagePgpm affgp = new TAffichagePgpm();
    	      				        if(!AFG.isEmpty()) affgp =AFG.get(0); 
    	      				       affgp.setAffGpgRecherche(rechercheAll);
    	      				       affgp.setAffGpgTypeFinance(newFinancement.getFipTypeFinance());
    	      				       affgp.setTSourceFinancement(newFinancement.getTSourceFinancement());
    		      				    iservice.updateObject(affgp);
           			
           			                chargeData();
           			
           			                userController.setTexteMsg("Détail enregistré avec succès!");
           			                userController.setRenderMsg(true);
           			                userController.setSevrityMsg("success");
           			
           			                //etatDossier = true;
           			                controleController.btn_edit_pgpm = true; 
           			                controleController.btn_save_pgpm = false;
        			                controleController.btn_save_pgspm = false;
           			                
           			                vider();
          		    
                                   }else {
              	                           plan.setTGestion(new TGestion(gesCode));
             		                       plan.setTFonction(userController.getSlctd().getTFonction());
             		                       plan.setTStructure(userController.getSlctd().getTFonction().getTStructure());
             		                       iservice.addObject(plan);
              	 
             		                       detailPlan.setTStatut(new TStatut("S1S"));
               	                           detailPlan.setGpgStatutRetour("0");
               	                           detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
               	                           detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));
               	                           detailPlan.setGpgAgpId(agpm.getAgpId());
               	                           detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
               	                           detailPlan.setGpgTypePlan("PN");
               	                           detailPlan.setTPlanGeneral(plan);
               	                           detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
               	                           detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
               	                           iservice.addObject(detailPlan);
               	 
               	 
               	                           TAffichagePgpm affichagePgpm = new TAffichagePgpm();
               	                           affichagePgpm.setAffGpgId(detailPlan.getGpgId());
               	                           affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
               	                           affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
               	                           affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
               	                           affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
               	                           affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
               	                           affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
               	                           affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
               	                           affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
               	                           affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
               	                           affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
               	                           affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
               	                           affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
               	                           affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
               	                           affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
               	                           affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
               	                           affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
               	                           affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
               	                           affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
               	                           affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
               	                           affichagePgpm.setAffGpgLibFin(detailPlan.getGpgLibFin());
               	                           iservice.addObject(affichagePgpm);
               	                           
               	                           
               	                           //Insertion dans T_Financement_PGPM
               	        	 	  		  newFinancement.setTBailleur(new TBailleur(finAgpm.getTBailleur().getBaiCode()));
               	        	 	  		  newFinancement.setFipTypeFinance(finAgpm.getFinTypeFinance());
               	        	 	  		  newFinancement.setTDetailPlanGeneral(detailPlan);
               	        	 	  		  newFinancement.setTSourceFinancement(new TSourceFinancement(finAgpm.getTSourceFinancement().getSouCode()));
               	        	 	  		  newFinancement.setTDevise(new TDevise(finAgpm.getTDevise().getDevCode()));
               	        	 	  		  newFinancement.setFipMontantDevise(finAgpm.getFinMontantDevise());
               	        	 	  		  newFinancement.setFipMontantCfa(finAgpm.getFinMontantCfa());
               	        	 	  		  iservice.addObject(newFinancement);
           	 

            		                       List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
         			                       TStatut statuts = new TStatut();
         			                       if(!LS.isEmpty()) statuts = LS.get(0);
         			                       //Historisation des Plan Généraux
         			                       THistoPlanGeneral histoPlan = new THistoPlanGeneral();
         			                       histoPlan.setHpgDate(Calendar.getInstance().getTime());
         			                       histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
         			                       histoPlan.setTStatut(statuts);
         			                       histoPlan.setTDetailPlanGeneral(detailPlan);
         			                       histoPlan.setTFonction(userController.getSlctd().getTFonction());
         			                       histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
         			                       iservice.addObject(histoPlan);
         			      
         			                       String search = detailPlan.getGpgObjet()+""+detailPlan.getGpgCommentaire()+""+detailPlan.getGpgSourceFin()+""+detailPlan.getGpgActeurSaisie()+""+detailPlan.getGpgTypePlan()+""+detailPlan.getGpgStrCode()+""+detailPlan.getTModePassation().getMopCode()+""+detailPlan.getTTypeMarche().getTymCode()+""+plan.getTGestion().getGesCode()+""+detailPlan.getGpgDateDao()+""+detailPlan.getTModePassation().getMopLibelleLong()+""+detailPlan.getTTypeMarche().getTymLibelleCourt();
     					                   String rechercheAll = search.replace("null","");
     					
     					                   List<TAffichagePgpm> AFG =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
     			      				        new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+affichagePgpm.getAffGpgId()));
     		      				            TAffichagePgpm affgp = new TAffichagePgpm();
     		      				            if(!AFG.isEmpty()) affgp =AFG.get(0); 
     		      				           affgp.setAffGpgRecherche(rechercheAll);
     		      				           affgp.setAffGpgTypeFinance(newFinancement.getFipTypeFinance());
     		      				           affgp.setTSourceFinancement(newFinancement.getTSourceFinancement());
      		      				           iservice.updateObject(affgp);
         			
         			                       chargeData();
         			
         			                        userController.setTexteMsg("Détail enregistré avec succès!");
         			                        userController.setRenderMsg(true);
         			                        userController.setSevrityMsg("success");
         			
         			                        //etatDossier = true;
         			                        controleController.btn_edit_pgpm = true;
         			                        controleController.btn_save_pgpm = false;
         			                        controleController.btn_edit_pgspm = false; 
                 			                controleController.btn_save_pgpm = false;
              			                    controleController.btn_save_pgspm = false;
         			                       vider();
                                  }
        	                  }  
    		  
    	   }else {
    		  //Message d'erreur
    		  FacesContext.getCurrentInstance().addMessage(null,
	          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Votre AGPM n'a pas de financement", "")); 
    	      }
        }
      
      
      
      //Insertion des pgpm par les cpmpn et Dmp
      @Transactional
      public void creerDetailPlanCpmpDmp() throws IOException{
    
    	  listPlan = (List<TPlanGeneral>) iservice.getObjectsByColumn("TPlanGeneral", new ArrayList<String>(Arrays.asList("PLG_ID")),
    			    new WhereClause("PLG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
    			    new WhereClause("PLG_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
					new WhereClause("PLG_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
    	  if (!listPlan.isEmpty()) {
    		   plan= listPlan.get(0);
			
    		   detailPlan.setTStatut(new TStatut("S1S"));
           	   detailPlan.setGpgStatutRetour("0");
           	   detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
           	   detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));
           	   detailPlan.setGpgAgpId(agpm.getAgpId());
           	   detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
           	   detailPlan.setGpgTypePlan("PN");
           	   detailPlan.setTPlanGeneral(plan);
           	   detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
           	   detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
           	   iservice.addObject(detailPlan);
           	 
           	 
           	   TAffichagePgpm affichagePgpm = new TAffichagePgpm();
           	   affichagePgpm.setAffGpgId(detailPlan.getGpgId());
           	   affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
           	   affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
           	   affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
           	   affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
           	   affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
           	   affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
           	   affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
           	   affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
           	   affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
           	   affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
           	   affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
           	   affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
           	   affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
           	   affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
           	   affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
           	   affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
           	   affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
           	   affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
           	   affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
           	   String recherche = detailPlan.getGpgObjet()+""+detailPlan.getGpgCode()+""+detailPlan.getGpgCommentaire()+""+detailPlan.getGpgPartiePmePmi()+""+detailPlan.getGpgSourceFin()+""+detailPlan.getGpgActeurSaisie()+""+detailPlan.getGpgTypePlan()+""+detailPlan.getGpgStrCode()+""+detailPlan.getTModePassation().getMopCode()+""+detailPlan.getGpgStatutRetour()+""+detailPlan.getTTypeMarche().getTymCode()+""+detailPlan.getTPlanGeneral().getPlgId()+""+detailPlan.getGpgAgpId()+""+plan.getTGestion().getGesCode()+""+detailPlan.getGpgDateDao()+""+detailPlan.getTModePassation().getMopLibelleLong()+""+detailPlan.getTTypeMarche().getTymLibelleCourt();
       	       affichagePgpm.setAffGpgRecherche(recherche);
           	   iservice.addObject(affichagePgpm);
       	 

        		 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
     			 TStatut statuts = new TStatut();
     			 if(!LS.isEmpty()) statuts = LS.get(0);
     			  //Historisation des Plan Généraux
     			 THistoPlanGeneral histoPlan = new THistoPlanGeneral();
     			 histoPlan.setHpgDate(Calendar.getInstance().getTime());
     			 histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
     			 histoPlan.setTStatut(statuts);
     			 histoPlan.setTDetailPlanGeneral(detailPlan);
     			 histoPlan.setTFonction(userController.getSlctd().getTFonction());
     			 histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
     			 iservice.addObject(histoPlan);
     			
     			 chargeData();
     			
     			userController.setTexteMsg("Détail enregistré avec succès!");
     			userController.setRenderMsg(true);
     			userController.setSevrityMsg("success");
     			
     			etatDossier = true;
     			controleController.btn_edit_pgpm = true;   
    		    
            }else {
        	   plan.setTGestion(new TGestion(gesCode));
       		   plan.setTFonction(userController.getSlctd().getTFonction());;
       		   plan.setTStructure(userController.getSlctd().getTFonction().getTStructure());
       		   iservice.addObject(plan);
        	 
       		   detailPlan.setTStatut(new TStatut("S1S"));
         	   detailPlan.setGpgStatutRetour("0");
         	   detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
         	   detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));
         	   detailPlan.setGpgAgpId(agpm.getAgpId());
         	   detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
         	   detailPlan.setGpgTypePlan("PN");
         	   detailPlan.setTPlanGeneral(plan);
         	   detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
               detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
         	   iservice.addObject(detailPlan);
         	 
         	 
         	   TAffichagePgpm affichagePgpm = new TAffichagePgpm();
         	   affichagePgpm.setAffGpgId(detailPlan.getGpgId());
         	   affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
         	   affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
         	   affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
         	   affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
         	   affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
         	   affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
         	   affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
         	   affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
         	   affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
         	   affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
         	   affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
         	   affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
         	   affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
         	   affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
         	   affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
         	   affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
         	   affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
         	   affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
         	   affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
         	   String recherche = detailPlan.getGpgObjet()+""+detailPlan.getGpgCode()+""+detailPlan.getGpgCommentaire()+""+detailPlan.getGpgPartiePmePmi()+""+detailPlan.getGpgSourceFin()+""+detailPlan.getGpgActeurSaisie()+""+detailPlan.getGpgTypePlan()+""+detailPlan.getGpgStrCode()+""+detailPlan.getTModePassation().getMopCode()+""+detailPlan.getGpgStatutRetour()+""+detailPlan.getTTypeMarche().getTymCode()+""+detailPlan.getTPlanGeneral().getPlgId()+""+detailPlan.getGpgAgpId()+""+plan.getTGestion().getGesCode()+""+detailPlan.getGpgDateDao()+""+detailPlan.getTModePassation().getMopLibelleLong()+""+detailPlan.getTTypeMarche().getTymLibelleCourt();
      	       affichagePgpm.setAffGpgRecherche(recherche);
         	   iservice.addObject(affichagePgpm);
     	 

      		 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
   			 TStatut statuts = new TStatut();
   			 if(!LS.isEmpty()) statuts = LS.get(0);
   			  //Historisation des Plan Généraux
   			 THistoPlanGeneral histoPlan = new THistoPlanGeneral();
   			 histoPlan.setHpgDate(Calendar.getInstance().getTime());
   			 histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
   			 histoPlan.setTStatut(statuts);
   			 histoPlan.setTDetailPlanGeneral(detailPlan);
   			 histoPlan.setTFonction(userController.getSlctd().getTFonction());
   			 histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
   			 iservice.addObject(histoPlan);
   			
   			 chargeData();
   			
   			userController.setTexteMsg("Détail enregistré avec succès!");
   			userController.setRenderMsg(true);
   			userController.setSevrityMsg("success");
   			
   			etatDossier = true;
   			controleController.btn_edit_pgpm = true;
       		   
         }
      }
      
      
      //Validation par le CPMP DMP
      @Transactional
		public void validerPgspmCPMPDMP()throws IOException{ 
	 		if (listSelectionTransmission.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune demande selectionnée", ""));
			}
	 		else{
	 				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
	 					 statutUpdate ="";
	 				 }else {
	 					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
	 						 statutUpdate ="S2V";
	 					 }else {
	 						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
	 							 statutUpdate ="S3V";
	 						 }
	 				     } 
	 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
		 		for(TAffichagePgpm ligne : listSelectionTransmission) {
		 			 
		 			//Parcourir la liste et récupérer les demande au statut E1T
		 			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
								new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getAffGpgId()));
							if (!listeDetail.isEmpty()) {
								demDetail= listeDetail.get(0);
								demDetail.setTStatut(new TStatut(statutUpdate));
								demDetail.setGpgStatutRetour("0");
						       iservice.updateObject(demDetail);
						       
					List<TAffichagePgpm> AG =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
			      						new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getAffGpgId()));
					   TAffichagePgpm pgpm = new TAffichagePgpm();
					   if(!AG.isEmpty()) pgpm =AG.get(0); 
					    pgpm.setTStatut(new TStatut(statutUpdate));
					    pgpm.setAffGpgStatutRetour("0");
					    iservice.updateObject(pgpm);
							}
			 			
			 			//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
							List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1T"));
						    TStatut statuts = new TStatut();
						      if(!LS.isEmpty()) statuts = LS.get(0);
						  //Historisation des Plans Généraux
						     THistoPlanGeneral histoPlan = new THistoPlanGeneral();
						     histoPlan.setHpgDate(Calendar.getInstance().getTime());
						     histoPlan.setHpgMotif("Opération transmise à la CPMP");
						     histoPlan.setTStatut(statuts);
						     histoPlan.setTDetailPlanGeneral(demDetail);
						     histoPlan.setTFonction(userController.getSlctd().getTFonction());
						     histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
						     iservice.addObject(histoPlan);
									  
							 userController.setTexteMsg("Transmission effectuée avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
							 //return	null;
		 		        }	   
			 		   }	
				     }
	 		        //chargeDataAvaliderPgpm();
	 			    chargeDataAvaliderPgspm();
	 			   chargePgspmValCp();
	 		       chargePgspmValDmp();
					}

		
      //DIFFERER CPMP ET DMP
      //Differer
		 public void differer() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 statutUpdate ="";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 statutUpdate ="S2D";
					 observation ="PGPM retourné par la CPMP";
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 if(slctdTd.getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("02")) {
							 statutUpdate ="S3D"; 
						 }else
							  if(slctdTd.getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("03")) {
								  statutUpdate ="SDR";  
							  }else {
								  statutUpdate ="SDR"; 
							  }
					 }
			     } 
			 }
			 
			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
						new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
					if (!listeDetail.isEmpty()) {
						demDetail= listeDetail.get(0);
						demDetail.setTStatut(new TStatut(statutUpdate));
						demDetail.setGpgStatutRetour("1");
				        iservice.updateObject(demDetail);
				       
			
			    
			      chargeData();
			    
			    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
			    TStatut statuts = new TStatut();
			      if(!LS.isEmpty()) statuts = LS.get(0);
			  //Historisation des Plans Généraux
			     THistoPlanGeneral histoPlan = new THistoPlanGeneral();
			     histoPlan.setHpgDate(Calendar.getInstance().getTime());
			     histoPlan.setHpgMotif(getObservation());
			     histoPlan.setTStatut(statuts);
			     histoPlan.setTDetailPlanGeneral(demDetail);
			     histoPlan.setTFonction(userController.getSlctd().getTFonction());
			     histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
			     iservice.addObject(histoPlan); 
			     
			     
			 	//Enregistrement de TAffichage
				  validationListe =(List<TAffichagePgpm>) iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
							new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
					TAffichagePgpm affiche = new TAffichagePgpm();
					if (!validationListe.isEmpty()) {
						affiche= validationListe.get(0);
						affiche.setTStatut(new TStatut(statutUpdate));
						affiche.setAffGpgStatutRetour("1");
					    iservice.updateObject(affiche);
				        
					     chargeDataAvaliderPgpm();
					     chargePgpmDifCp();
					     chargePgpmDifDmp();
			 			 
					     tableauBordController.chargeDataPgpmPgspm(); 	  
						
					      userController.setTexteMsg(" Désolé, votre PGPM a été rejeté!");
						  userController.setRenderMsg(true);
						  userController.setSevrityMsg("success");
				  		
                        }
					}
		 }
		 
		 
		 
		//RéDifferer
		 @Transactional
		 public void reDifferer() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 statutUpdate ="";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 statutUpdate ="S2D";
				 } 
			   }
		
			 
			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
						new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
					if (!listeDetail.isEmpty()) {
						demDetail= listeDetail.get(0);
						demDetail.setTStatut(new TStatut(statutUpdate));
						demDetail.setGpgStatutRetour("1");
				        iservice.updateObject(demDetail);
				  
				        listeHisto =(List<THistoPlanGeneral>) iservice.getObjectsByColumn("THistoPlanGeneral", new ArrayList<String>(Arrays.asList("HPG_ID")),
								new WhereClause("HPG_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()),
								new WhereClause("HPG_STA_CODE",WhereClause.Comparateur.EQ,"S3D"));
					   if (!listeHisto.isEmpty()) {
						   histoPgpm= listeHisto.get(0); 
					   }
			
			    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
			    TStatut statuts = new TStatut();
			      if(!LS.isEmpty()) statuts = LS.get(0);
			  //Historisation des Plans Généraux
			     THistoPlanGeneral histoPlan = new THistoPlanGeneral();
			     histoPlan.setHpgDate(Calendar.getInstance().getTime());
			     histoPlan.setHpgMotif(histoPgpm.getHpgMotif());
			     histoPlan.setTStatut(statuts);
			     histoPlan.setTDetailPlanGeneral(demDetail);
			     histoPlan.setTFonction(userController.getSlctd().getTFonction());
			     histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
			     iservice.addObject(histoPlan); 
			     
			     
			 	//Enregistrement de TAffichage
				  validationListe =(List<TAffichagePgpm>) iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
							new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
					TAffichagePgpm affiche = new TAffichagePgpm();
					if (!validationListe.isEmpty()) {
						affiche= validationListe.get(0);
						affiche.setTStatut(new TStatut(statutUpdate));
						affiche.setAffGpgStatutRetour("1");
					    iservice.updateObject(affiche);
                        }
					     chargeDataAvaliderPgpm();
					     chargePgpmDifCp();
					     chargePgpmDifDmp();
					     tableauBordController.chargeDataPgpm(); 	  
					      userController.setTexteMsg(" Désolé, votre PGPM a été rejeté!");
						  userController.setRenderMsg(true);
						  userController.setSevrityMsg("success");
					}	     
		 }
		 
		 
		
		 
		 //DIFFERER PGSPM CPMP ET DMP
	      //Differer
			 public void differerPgspm() {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 statutUpdate ="";
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
						 statutUpdate ="S2D";
						 observation="";
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
							 statutUpdate ="S3D";
							 
							 if(slctdTd.getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("02")) {
								 statutUpdate ="S3D"; 
							 }else
								  if(slctdTd.getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("03")) {
									  statutUpdate ="PGD";  
								  }else {
									  statutUpdate ="PGD"; 
								  }
						 }
				     } 
				 }
				 
				 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
							new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
						if (!listeDetail.isEmpty()) {
							demDetail= listeDetail.get(0);
							demDetail.setTStatut(new TStatut(statutUpdate));
							demDetail.setGpgStatutRetour("1");
					        iservice.updateObject(demDetail);
					       
				List<TAffichagePgpm> AG =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
		      						new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
				   TAffichagePgpm pgpm = new TAffichagePgpm();
				   if(!AG.isEmpty()) pgpm =AG.get(0); 
				    pgpm.setTStatut(new TStatut(statutUpdate));
				    pgpm.setAffGpgStatutRetour("1");
				    iservice.updateObject(pgpm);
				    
				    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
				    TStatut statuts = new TStatut();
				      if(!LS.isEmpty()) statuts = LS.get(0);
				  //Historisation des Plans Généraux
				     THistoPlanGeneral histoPlan = new THistoPlanGeneral();
				     histoPlan.setHpgDate(Calendar.getInstance().getTime());
				     histoPlan.setHpgMotif(getObservation());
				     histoPlan.setTStatut(statuts);
				     histoPlan.setTDetailPlanGeneral(demDetail);
				     histoPlan.setTFonction(userController.getSlctd().getTFonction());
				     histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
				     iservice.addObject(histoPlan);
				     
				     //chargeDataAvaliderPgpm();
		 			    chargeDataAvaliderPgspm();
		 			   tableauBordController.chargeDataPgspm();
					
					 
					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Désolé, votre Agpm a été retourné!", "");
				     FacesContext.getCurrentInstance().addMessage(null, msg);
						}
			 }
			 
			 
			 
			//Redifférer par la CPMP 
			 @Transactional
			 public void reDiffererPgspm() {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 statutUpdate ="";
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
						 statutUpdate ="S2D";
					 } 
				 
				 
				 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
							new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
						if (!listeDetail.isEmpty()) {
							demDetail= listeDetail.get(0);
							demDetail.setTStatut(new TStatut(statutUpdate));
							demDetail.setGpgStatutRetour("1");
					        iservice.updateObject(demDetail);
					       

							 listeHisto =(List<THistoPlanGeneral>) iservice.getObjectsByColumn("THistoPlanGeneral", new ArrayList<String>(Arrays.asList("HPG_ID")),
										new WhereClause("HPG_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()),
										new WhereClause("HPG_STA_CODE",WhereClause.Comparateur.EQ,"S3D"));
							   if (!listeHisto.isEmpty()) {
								   histoPgpm= listeHisto.get(0); 
							   }
				    
				      chargeDataPgspm();
				    
				    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
				    TStatut statuts = new TStatut();
				      if(!LS.isEmpty()) statuts = LS.get(0);
				  //Historisation des Plans Généraux
				     THistoPlanGeneral histoPlan = new THistoPlanGeneral();
				     histoPlan.setHpgDate(Calendar.getInstance().getTime());
				     histoPlan.setHpgMotif(histoPgpm.getHpgMotif());
				     histoPlan.setTStatut(statuts);
				     histoPlan.setTDetailPlanGeneral(demDetail);
				     histoPlan.setTFonction(userController.getSlctd().getTFonction());
				     histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
				     iservice.addObject(histoPlan); 
				     
				     
				 	//Enregistrement de TAffichage
					  validationListe =(List<TAffichagePgpm>) iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
								new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
						TAffichagePgpm affiche = new TAffichagePgpm();
						if (!validationListe.isEmpty()) {
							affiche= validationListe.get(0);
							affiche.setTStatut(new TStatut(statutUpdate));
							affiche.setAffGpgStatutRetour("1");
						    iservice.updateObject(affiche);
					        
						    
						     chargePgpmDifCp();
						     chargePgpmDifDmp();
				 			 
						     chargeDataAvaliderPgspm();
				 			 tableauBordController.chargeDataPgspm(); 	  
							
						      userController.setTexteMsg(" Désolé, votre PGPM a été retourné!");
							  userController.setRenderMsg(true);
							  userController.setSevrityMsg("success");
					  		
	                        }
						}
			 }
		 
			 
			 
			 
		 
		 public void checkSituation() {
			 if(sit.equalsIgnoreCase("O")) {
				 etatAgpm = true;
				 etatFinancement1 = false;
				 etatFinancement2 = true;
				 loveAgpmRappel = false;
				 btnAgpmRappel = true;
				 
				 //controleController.btn_save_pgpm = false;
			 }else {
				 etatAgpm= false;
				 etatFinancement1 =true;
				 etatFinancement2 =false;
				 loveAgpmRappel = false;
				 btnAgpmRappel =false;
				 //controleController.btn_save_pgpm = true;
			 }
		 }
		 
		 public void checkSituationPs() {
			 if(sit.equalsIgnoreCase("O")) {
				 etatAgpm = true;
				 etatFinancement1 = false;
				 etatFinancement2 = true;
				 loveAgpmRappel = false;
				 btnAgpmRappel = false;
				 controleController.btn_save_pgspm = false;
				 btnPgspmRappel = true;
				 controleController.btn_save_pgpm = false;
			 }else {
				 etatAgpm= false;
				 etatFinancement1 =true;
				 etatFinancement2 =false;
				 loveAgpmRappel = true;
				 btnAgpmRappel =false;
				 btnPgspmRappel = false;
				 controleController.btn_save_pgspm = true;
				 controleController.btn_save_pgpm = false;
			 }
		 }
		 
		 
		 public void onSelectModePassation() {
			 detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));

			 recupModePassation = new VModePassationPn();
			 recupModePassation.setMopLibelleLong(modePassation.getMopLibelleLong());
			 recupModePassation.setMopCode(modePassation.getMopCode());
			 chargeModePassation();
				}
		 
		 
		 public void onSelectModePassationPgspm() {
			 detailPlan.setTModePassation(new TModePassation(passationListe.getMopCode()));

		    recupModeListe = new VModePassation();
		    recupModeListe.setMopLibelleLong(passationListe.getMopLibelleLong());
		    recupModeListe.setMopCode(passationListe.getMopCode());
		    chargeMode();
				}
	 
	 
	 
		//Méthode de création d'un plan général
      	 @Transactional
		 public void creerPlan() throws IOException{
      		plan.setTGestion(new TGestion(gesCode));
      		plan.setTFonction(userController.getSlctd().getTFonction());;
      		plan.setTStructure(userController.getSlctd().getTFonction().getTStructure());
      		iservice.addObject(plan);
				
	      	userController.setTexteMsg("Plan Général crée avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
		 }
      	 
      	 
      	//Méthode de création d'un plan général
      	 @Transactional
		 public void creerPlanCpmpDmp() throws IOException{
      		plan.setTGestion(new TGestion(gesCode));
      		plan.setTFonction(recupFonction);
      		plan.setTStructure(userController.getSlctd().getTFonction().getTStructure());
      		iservice.addObject(plan);
				
	      	userController.setTexteMsg("Plan Général crée avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
		 }
      	 
    
      	 
      	 //Impression unique du pgpm ou pgspm
      	 public void pgpmUnique() { 
      		 projetReport.longparam1(slctdTd.getAffGpgId(), "Fiche_pgpm", "Fiche_pgpm" );
      	 }
      	 
      	 
      	 
      	 
      	//Impression unique du pgpm ou pgspm
      	 public void pgpmUniqueSaisie() { 
      		 projetReport.longparam1(detailPlan.getGpgId(), "Fiche_pgpm", "Fiche_pgpm" );
      	 }
      	 
      	 
      	 
  
      	 
      	 
      	//Méthode de création d'un plan général
      	 /*@Transactional
		 public void creerDetailPlan() throws IOException{
      	
      	 detailPlan.setTStatut(new TStatut("S1S"));
      	 detailPlan.setGpgStatutRetour("0");
      	 detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
      	 detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));
      	 detailPlan.setGpgAgpId(agpm.getAgpId());
      	 detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
      	 detailPlan.setGpgTypePlan("PN");
      	 detailPlan.setTPlanGeneral(plan);
      	 detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
      	 detailPlan.setGpgMinCode(userController.getSlctd().getTFonction().getTMinistere().getMinCode());
      	 iservice.addObject(detailPlan);
      	 
      	 
      	 TAffichagePgpm affichagePgpm = new TAffichagePgpm();
      	 affichagePgpm.setAffGpgId(detailPlan.getGpgId());
      	 affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
      	 affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
      	 affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
      	 affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
      	 affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
      	 affichagePgpm.setTMinistere(new TMinistere(userController.getSlctd().getTFonction().getTMinistere().getMinCode()));
      	 affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
      	 affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
      	 affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
      	 affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
      	 affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
      	 affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
      	 affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
      	 affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
      	 affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
      	 affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
      	 affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
      	 affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
      	 affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
      	 iservice.addObject(affichagePgpm);
  	 

   		 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Historisation des Plan Généraux
			THistoPlanGeneral histoPlan = new THistoPlanGeneral();
			histoPlan.setHpgDate(Calendar.getInstance().getTime());
			histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
			histoPlan.setTStatut(statuts);
			histoPlan.setTDetailPlanGeneral(detailPlan);
			histoPlan.setTFonction(userController.getSlctd().getTFonction());
			iservice.addObject(histoPlan);
			
			chargeData();
			
			userController.setTexteMsg("Détail enregistré avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
			
			etatDossier = true;
			controleController.btn_edit_pgpm = true;
      	 }
      	 
      	//Méthode de création d'un plan Simplifiés
      	 @Transactional
		 public void creerDetailPlanPgspm() throws IOException{
      	
      	 detailPlan.setTStatut(new TStatut("S1S"));
      	 detailPlan.setGpgStatutRetour("0");
      	 detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
      	 detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));
      	 detailPlan.setGpgAgpId(agpm.getAgpId());
      	 detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
      	 detailPlan.setGpgTypePlan("PS");
      	 detailPlan.setTPlanGeneral(plan);
      	 detailPlan.setGpgMinCode(userController.getSlctd().getTFonction().getTMinistere().getMinCode());
      	 iservice.addObject(detailPlan);
      	 
      	 
      	 TAffichagePgpm affichagePgpm = new TAffichagePgpm();
      	 affichagePgpm.setAffGpgId(detailPlan.getGpgId());
      	 affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
      	 affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
      	 affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
      	 affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
      	 affichagePgpm.setTMinistere(new TMinistere(userController.getSlctd().getTFonction().getTMinistere().getMinCode()));
      	 affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
      	 affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
      	 affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
      	 affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
      	 affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
      	 affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
      	 affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
      	 affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
      	 affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
      	 affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
      	 affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
      	 affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
      	 iservice.addObject(affichagePgpm);
  	 
      	 
  		 
   		List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Historisation des Plan Généraux
			THistoPlanGeneral histoPlan = new THistoPlanGeneral();
			histoPlan.setHpgDate(Calendar.getInstance().getTime());
			histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
			histoPlan.setTStatut(statuts);
			histoPlan.setTDetailPlanGeneral(detailPlan);
			histoPlan.setTFonction(userController.getSlctd().getTFonction());
			iservice.addObject(histoPlan);
			
			chargeDataPgspm();
			
			userController.setTexteMsg("Détail enregistré avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
			
			etatDossier = true;
			controleController.btn_edit_pgspm = true;
      	 }*/
      	 
      	 //Enregistrement d'une opération en mode PS
         @Transactional
         public void creerDetailPlanPgspm() throws IOException{
        	 
        	 if(detailPlan.getGpgObjet().equalsIgnoreCase("") || detailPlan.getGpgPartiePmePmi().equalsIgnoreCase("") || detailPlan.getGpgCommentaire().equalsIgnoreCase("") 
        			 || marche.getTymCode().equalsIgnoreCase("") || passationListe.getMopCode().equalsIgnoreCase("") || sourfin.equalsIgnoreCase("")) {
       		     //Message d'erreur
       		      FacesContext.getCurrentInstance().addMessage(null,
   	              new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir tous les champs", ""));
       	      }else {
       	    	listPlan = (List<TPlanGeneral>) iservice.getObjectsByColumn("TPlanGeneral", new ArrayList<String>(Arrays.asList("PLG_ID")),
           			    new WhereClause("PLG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
           			     new WhereClause("PLG_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
       					new WhereClause("PLG_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
           	    if (!listPlan.isEmpty()) {
           		   plan= listPlan.get(0);
       			
           		   detailPlan.setTStatut(new TStatut("S1S"));
                   detailPlan.setGpgStatutRetour("0");
                   detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
                   detailPlan.setTModePassation(new TModePassation(passationListe.getMopCode()));
                   detailPlan.setGpgAgpId(agpm.getAgpId());
                   detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
                   detailPlan.setGpgTypePlan("PS");
                   detailPlan.setTPlanGeneral(plan);
                   detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
                   detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
                   iservice.addObject(detailPlan);
                  	 
                  	 
                   TAffichagePgpm affichagePgpm = new TAffichagePgpm();
                   affichagePgpm.setAffGpgId(detailPlan.getGpgId());
                   affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
                   affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
                   affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
                   affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
                   affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
                   affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
                   affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
                   affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
                   affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
                   affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
                   affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
                   affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
                   affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
                   affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
                   affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
                   affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
                   affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
                   affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
                   affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
                   affichagePgpm.setAffGpgLibFin(detailPlan.getGpgLibFin());
                   iservice.addObject(affichagePgpm);
                   
                    //Création du financement
        		    newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
			        newFinancement.setTDevise(new TDevise(devCode));
			        newFinancement.setTBailleur(new TBailleur(baiCode));
			        newFinancement.setTDetailPlanGeneral(detailPlan);
			        newFinancement.setFipTypeFinance(sourfin);
			        iservice.addObject(newFinancement);
              	 

               		 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
            			 TStatut statuts = new TStatut();
            			 if(!LS.isEmpty()) statuts = LS.get(0);
            			  //Historisation des Plan Généraux
            			 THistoPlanGeneral histoPlan = new THistoPlanGeneral();
            			 histoPlan.setHpgDate(Calendar.getInstance().getTime());
            			 histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
            			 histoPlan.setTStatut(statuts);
            			 histoPlan.setTDetailPlanGeneral(detailPlan);
            			 histoPlan.setTFonction(userController.getSlctd().getTFonction());
            			 histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
            			 iservice.addObject(histoPlan);
            			
            			 chargeDataPgspm();
            			
            			userController.setTexteMsg("Détail enregistré avec succès!");
            			userController.setRenderMsg(true);
            			userController.setSevrityMsg("success");
            			
            			//etatDossier = true;
            			controleController.btn_edit_pgspm = true;
            			controleController.btn_edit_pgpm = false;
            			controleController.btn_save_pgpm = false;
            			btnPgspmRappel = false;
           		    
                   }else {
               	       plan.setTGestion(new TGestion(gesCode));
              		   plan.setTFonction(userController.getSlctd().getTFonction());
              		   plan.setTStructure(userController.getSlctd().getTFonction().getTStructure());
              		   iservice.addObject(plan);
               	 
              		   detailPlan.setTStatut(new TStatut("S1S"));
                	   detailPlan.setGpgStatutRetour("0");
                	   detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
                	   detailPlan.setTModePassation(new TModePassation(passationListe.getMopCode()));
                	   detailPlan.setGpgAgpId(agpm.getAgpId());
                	   detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
                	   detailPlan.setGpgTypePlan("PS");
                	   detailPlan.setTPlanGeneral(plan);
                	   detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
                	   detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
                	   iservice.addObject(detailPlan);
                	 
                	 
                	   TAffichagePgpm affichagePgpm = new TAffichagePgpm();
                	   affichagePgpm.setAffGpgId(detailPlan.getGpgId());
                	   affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
                	   affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
                	   affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
                	   affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
                	   affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
                	   affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
                	   affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
                	   affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
                	   affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
                	   affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
                	   affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
                	   affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
                	   affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
                	   affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
                	   affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
                	   affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
                	   affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
                	   affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
                	   affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
                	   affichagePgpm.setAffGpgLibFin(detailPlan.getGpgLibFin());
                	   iservice.addObject(affichagePgpm);
            	 

             		 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
          			 TStatut statuts = new TStatut();
          			 if(!LS.isEmpty()) statuts = LS.get(0);
          			  //Historisation des Plan Généraux
          			 THistoPlanGeneral histoPlan = new THistoPlanGeneral();
          			 histoPlan.setHpgDate(Calendar.getInstance().getTime());
          			 histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
          			 histoPlan.setTStatut(statuts);
          			 histoPlan.setTDetailPlanGeneral(detailPlan);
          			 histoPlan.setTFonction(userController.getSlctd().getTFonction());
          			 histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
          			 iservice.addObject(histoPlan);
          			
          			chargeDataPgspm();
          			
          			userController.setTexteMsg("Détail enregistré avec succès!");
          			userController.setRenderMsg(true);
          			userController.setSevrityMsg("success");
          			
          			
        			controleController.btn_edit_pgspm = true;
        			controleController.btn_edit_pgpm = false; 
        			controleController.btn_save_pgpm = false;
        			btnPgspmRappel = false;
        			
                     }
       	        }
         }
         
         
         @Transactional
         public void creerDetailPgspmRappel() throws IOException{
        	 
        	 if(finAgpm.getFinId() > 0 ) {
        		 
        		 if(detailPlan.getGpgObjet().equalsIgnoreCase("") || detailPlan.getGpgPartiePmePmi().equalsIgnoreCase("") || detailPlan.getGpgCommentaire().equalsIgnoreCase("")) {
           		     //Message d'erreur
           		      FacesContext.getCurrentInstance().addMessage(null,
       	              new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir tous les champs", ""));
           	      }else {
           	    	listPlan = (List<TPlanGeneral>) iservice.getObjectsByColumn("TPlanGeneral", new ArrayList<String>(Arrays.asList("PLG_ID")),
               			    new WhereClause("PLG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
               			     new WhereClause("PLG_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
           					new WhereClause("PLG_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
               	    if (!listPlan.isEmpty()) {
               		   plan= listPlan.get(0);
           			
               		   detailPlan.setTStatut(new TStatut("S1S"));
                       detailPlan.setGpgStatutRetour("0");
                       detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
                       detailPlan.setTModePassation(new TModePassation(passationListe.getMopCode()));
                       detailPlan.setGpgAgpId(agpm.getAgpId());
                       detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
                       detailPlan.setGpgTypePlan("PS");
                       detailPlan.setTPlanGeneral(plan);
                       detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
                       detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
                       iservice.addObject(detailPlan);
                      	 
                      	 
                       TAffichagePgpm affichagePgpm = new TAffichagePgpm();
                       affichagePgpm.setAffGpgId(detailPlan.getGpgId());
                       affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
                       affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
                       affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
                       affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
                       affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
                       affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
                       affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
                       affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
                       affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
                       affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
                       affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
                       affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
                       affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
                       affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
                       affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
                       affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
                       affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
                       affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
                       affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
                       affichagePgpm.setAffGpgLibFin(detailPlan.getGpgLibFin());
                       iservice.addObject(affichagePgpm);
                       
                       //Insertion dans T_Financement_PGPM
                       if(finAgpm.getFinTypeFinance().equalsIgnoreCase("ETAT")) {
            	        	newFinancement.setTBailleur(new TBailleur("ETAT")); 
            	          }else
            	        	  {
            	        	  newFinancement.setTBailleur(new TBailleur(finAgpm.getTBailleur().getBaiCode()));  
            	        }
        	 	  	   newFinancement.setFipTypeFinance(finAgpm.getFinTypeFinance());
        	 	  	   newFinancement.setTDetailPlanGeneral(detailPlan);
        	 	  	   newFinancement.setTSourceFinancement(new TSourceFinancement(finAgpm.getTSourceFinancement().getSouCode()));
        	 	  	   newFinancement.setTDevise(new TDevise(finAgpm.getTDevise().getDevCode()));
        	 	  	   newFinancement.setFipMontantDevise(finAgpm.getFinMontantDevise());
        	 	  	   newFinancement.setFipMontantCfa(finAgpm.getFinMontantCfa());
        	 	  	   iservice.addObject(newFinancement);
                  	 

                   		 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
                			 TStatut statuts = new TStatut();
                			 if(!LS.isEmpty()) statuts = LS.get(0);
                			  //Historisation des Plan Généraux
                			 THistoPlanGeneral histoPlan = new THistoPlanGeneral();
                			 histoPlan.setHpgDate(Calendar.getInstance().getTime());
                			 histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
                			 histoPlan.setTStatut(statuts);
                			 histoPlan.setTDetailPlanGeneral(detailPlan);
                			 histoPlan.setTFonction(userController.getSlctd().getTFonction());
                			 histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
                			 iservice.addObject(histoPlan);
                			
                			 chargeDataPgspm();
                			
                			userController.setTexteMsg("Détail enregistré avec succès!");
                			userController.setRenderMsg(true);
                			userController.setSevrityMsg("success");
                			
                			
                			controleController.btn_edit_pgspm = true;
                			controleController.btn_edit_pgpm = false;
                			controleController.btn_save_pgspm = false;
                			
               		    
                       }else {
                   	       plan.setTGestion(new TGestion(gesCode));
                  		   plan.setTFonction(userController.getSlctd().getTFonction());
                  		   plan.setTStructure(userController.getSlctd().getTFonction().getTStructure());
                  		   iservice.addObject(plan);
                   	 
                  		   detailPlan.setTStatut(new TStatut("S1S"));
                    	   detailPlan.setGpgStatutRetour("0");
                    	   detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
                    	   detailPlan.setTModePassation(new TModePassation(passationListe.getMopCode()));
                    	   detailPlan.setGpgAgpId(agpm.getAgpId());
                    	   detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
                    	   detailPlan.setGpgTypePlan("PS");
                    	   detailPlan.setTPlanGeneral(plan);
                    	   detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
                    	   detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
                    	   iservice.addObject(detailPlan);
                    	 
                    	 
                    	   TAffichagePgpm affichagePgpm = new TAffichagePgpm();
                    	   affichagePgpm.setAffGpgId(detailPlan.getGpgId());
                    	   affichagePgpm.setTPlanGeneral(new TPlanGeneral(detailPlan.getTPlanGeneral().getPlgId()));
                    	   affichagePgpm.setAffGpgAgpId(detailPlan.getGpgAgpId());
                    	   affichagePgpm.setAffGpgTypePlan(detailPlan.getGpgTypePlan());
                    	   affichagePgpm.setTFonction(userController.getSlctd().getTFonction());
                    	   affichagePgpm.setTStatut(new TStatut(detailPlan.getTStatut().getStaCode()));
                    	   affichagePgpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
                    	   affichagePgpm.setTTypeMarche(new TTypeMarche(detailPlan.getTTypeMarche().getTymCode()));
                    	   affichagePgpm.setTModePassation(new TModePassation(detailPlan.getTModePassation().getMopCode()));
                    	   affichagePgpm.setAffGpgCode(detailPlan.getGpgCode());
                    	   affichagePgpm.setAffGpgObjet(detailPlan.getGpgObjet());
                    	   affichagePgpm.setAffGpgNumeroOrdre(detailPlan.getGpgNumeroOrdre());
                    	   affichagePgpm.setAffGpgPartiePmePmi(detailPlan.getGpgPartiePmePmi());
                    	   affichagePgpm.setAffGpgCommentaire(detailPlan.getGpgCommentaire());
                    	   affichagePgpm.setAffGpgDateDao(detailPlan.getGpgDateDao());
                    	   affichagePgpm.setAffGpgActeurSaisie(detailPlan.getGpgActeurSaisie());
                    	   affichagePgpm.setAffGpgStatutRetour(detailPlan.getGpgStatutRetour());
                    	   affichagePgpm.setAffGpgDateSaisie(detailPlan.getGpgDateSaisie());
                    	   affichagePgpm.setAffGpgDateSaisie(Calendar.getInstance().getTime());
                    	   affichagePgpm.setTGestion(new TGestion(plan.getTGestion().getGesCode()));
                    	   affichagePgpm.setAffGpgLibFin(detailPlan.getGpgLibFin());
                    	   iservice.addObject(affichagePgpm);
                	       
                    	   //Insertion dans T_Financement_PGPM
            	 	  	   newFinancement.setTBailleur(new TBailleur(finAgpm.getTBailleur().getBaiCode()));
            	 	  	   newFinancement.setFipTypeFinance(finAgpm.getFinTypeFinance());
            	 	  	   newFinancement.setTDetailPlanGeneral(detailPlan);
            	 	  	   newFinancement.setTSourceFinancement(new TSourceFinancement(finAgpm.getTSourceFinancement().getSouCode()));
            	 	  	   newFinancement.setTDevise(new TDevise(finAgpm.getTDevise().getDevCode()));
            	 	  	   newFinancement.setFipMontantDevise(finAgpm.getFinMontantDevise());
            	 	  	   newFinancement.setFipMontantCfa(finAgpm.getFinMontantCfa());
            	 	  	   iservice.addObject(newFinancement);

                 		 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
              			 TStatut statuts = new TStatut();
              			 if(!LS.isEmpty()) statuts = LS.get(0);
              			  //Historisation des Plan Généraux
              			 THistoPlanGeneral histoPlan = new THistoPlanGeneral();
              			 histoPlan.setHpgDate(Calendar.getInstance().getTime());
              			 histoPlan.setHpgMotif("Détail crée par l'Autorité Contractante");
              			 histoPlan.setTStatut(statuts);
              			 histoPlan.setTDetailPlanGeneral(detailPlan);
              			 histoPlan.setTFonction(userController.getSlctd().getTFonction());
              			 histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
              			 iservice.addObject(histoPlan);
              			
              			chargeDataPgspm();
              			
              			userController.setTexteMsg("Détail enregistré avec succès!");
              			userController.setRenderMsg(true);
              			userController.setSevrityMsg("success");
              			
              			
            			controleController.btn_edit_pgspm = true;
            			controleController.btn_edit_pgpm = false;
            			controleController.btn_save_pgspm = false;
                         }
           	        }
        		 
        	          }else {
        	        	     //Message d'erreur
               		         FacesContext.getCurrentInstance().addMessage(null,
           	                  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Votre AGPM n'a pas de financement", ""));
        	                }
                     }
      	 

		 
		//Methode Upload
		 @Transactional
		 public void upload(FileUploadEvent event) throws IOException{
			  
			 listeDetail = (List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
						new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffGpgId()));
				     if(!listeDetail.isEmpty()) {
				    	 detailPlan=listeDetail.get(0);
				     } 	
		 	    
				if(fileUploadController.handleFileUpload(event, detailPlan.getGpgId()+"", natPiece)) {
					
						//check le dossier s'il existe à faire
						TDossierPlanGeneral dos = new TDossierPlanGeneral(); //TNatureDocument 
						dos = new TDossierPlanGeneral() ;
						
						//dos.setDpgCode(keyGen.getCodeDossierPgpm(fileUploadController.getFileCode()+"-"));
						dos.setTNaturePiece(new TNaturePiece("PJU"));
						dos.setTDetailPlanGeneral(detailPlan);
			            dos.setDpgLibelle(fileUploadController.getFileName());
			            dos.setDpgCommentaire(fileUploadController.getDocNom());
			            dos.setDpgReference("");
			            
						iservice.addObject(dos);
						chargeDossier();
						
						//Message de Confirmation
						 userController.setTexteMsg("Document enregistré!");
						 userController.setRenderMsg(true);
						 userController.setSevrityMsg("success");
					
				     }else {
				    	//Message d'erreur
						 userController.setTexteMsg("Document non enregistré, charger à nouveau un document!");
						 userController.setRenderMsg(true);
						 userController.setSevrityMsg("danger");
							}
				  }
		 
		 
		 public void chargeDossier() {
			 dossListe.clear();
				 dossListe = ((List<TDossierPlanGeneral>)iservice.getObjectsByColumnDesc("TDossierPlanGeneral",new ArrayList<String>(Arrays.asList("DPG_ID")),
						 new WhereClause("DPG_GPG_ID",Comparateur.EQ,""+detailPlan.getGpgId())));
		    }
            public void openDossier() throws IOException{
       		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDpgLibelle(), selectedDossier.getDpgLibelle());
       		   }
	    
      	 
      	 
	        //Ajout de Financement
            @Transactional
            public void saveFinancement(){
            	
            	if(detailPlan.getGpgObjet().equalsIgnoreCase("") ||"".equals(detailPlan.getGpgObjet()) || detailPlan.getGpgPartiePmePmi().equalsIgnoreCase("") ||"".equals(detailPlan.getGpgPartiePmePmi()) 
            			||souCode.equalsIgnoreCase("") ||"".equals(souCode) ||sourfin.equalsIgnoreCase("") || "".equals(sourfin) || detailPlan.getGpgLibFin().equalsIgnoreCase("") || "".equals(detailPlan.getGpgLibFin())) {
			        //Message d'erreur
		    		  FacesContext.getCurrentInstance().addMessage(null,
			          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez, saisir votre opération!", ""));
            	    }else {
            		    //Création du financement
            		    newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
    			        newFinancement.setTDevise(new TDevise(devCode));
    			        newFinancement.setTBailleur(new TBailleur(baiCode));
    			        newFinancement.setTDetailPlanGeneral(detailPlan);
    			        newFinancement.setFipTypeFinance(sourfin);
    			        iservice.addObject(newFinancement);
    				    
    				
    				   /* //Récuperons la dernière opération crée et faisons une mis à jour sur sa source de financement
    				    List<TDetailPlanGeneral> PL =iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
       						new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
    				    TDetailPlanGeneral detail = new TDetailPlanGeneral();
       				     if(!PL.isEmpty())  
       					 detail =PL.get(0); 
       				     detail.setGpgSourceFin(newFinancement.getTSourceFinancement().getSouCode());
       				      iservice.updateObject(detail);
       				    
       				    
       				     List<TAffichagePgpm> AF =iservice.getObjectsByColumn("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
       						new WhereClause("AFF_GPG_ID",WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
       				     TAffichagePgpm aff = new TAffichagePgpm();
    					if(!AF.isEmpty()) aff =AF.get(0); 
    					aff.setTSourceFinancement(newFinancement.getTSourceFinancement());
    					aff.setAffGpgTypeFinance(newFinancement.getFipTypeFinance());
    					iservice.updateObject(aff);*/
    					
    				    //methode qui charge les financements du projet crée
    				    chargeFinancement();
    				    //methode qui charge la liste des pgpm
    				    chargeData();
    				    //Message de Confirmation
    				    userController.setTexteMsg("Financement enregistré avec succès !");
    				    userController.setRenderMsg(true);
    				    userController.setSevrityMsg("success");
    				    //viderFinancement();
    				    //vider();
            	} 
			}
                       //SaveFinancement de modification
                       public void saveFinancementUpdate(){
            		    //Création du financement
            		    newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
    			        newFinancement.setTDevise(new TDevise(devCode));
    			        newFinancement.setTBailleur(new TBailleur(baiCode));
    			        newFinancement.setTDetailPlanGeneral(new TDetailPlanGeneral(slctdTd.getAffGpgId()));
    			        newFinancement.setFipTypeFinance(sourfin);
    			        iservice.addObject(newFinancement);

    				    //methode qui charge les financements du projet crée
    				    chargeFinancementUpdate();
    				    //methode qui charge la liste des pgpm
    				   // chargeData();
    				    //Message de Confirmation
    				    userController.setTexteMsg("Financement enregistré avec succès !");
    				    userController.setRenderMsg(true);
    				    userController.setSevrityMsg("success");
    				    //viderFinancement();
    				    //vider();
            	
			}
            
            public void recupererFinancement() {
            	selectFinance.setTBailleur(new TBailleur(baiCode));
            	selectFinance.setTSourceFinancement(new TSourceFinancement(souCode));
            	selectFinance.setTDevise(new TDevise(devCode));  
            	selectFinance.setTDetailPlanGeneral(new TDetailPlanGeneral(slctdTd.getAffGpgAgpId()));
            	selectFinance.setFipTypeFinance(sourfin);
            }
            
            public void updateFinance() {
            	selectFinance.setTBailleur(new TBailleur(baiCode));
            	selectFinance.setTSourceFinancement(new TSourceFinancement(souCode));
            	selectFinance.setTDevise(new TDevise(devCode));  
            	selectFinance.setTDetailPlanGeneral(new TDetailPlanGeneral(slctdTd.getAffGpgAgpId()));
            	selectFinance.setFipTypeFinance(sourfin);
			    iservice.updateObject(selectFinance);
			    userController.setTexteMsg("Modification éffectuée avec succès !");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");

            }
            
      	 
      	 //Methodes vider Fiancement
    	 public void viderFinancement() {
    		 newFinancement = new TFinancementPgpm();
    		 devCode ="";
    		 baiCode ="";
    		 souCode=""; 
    	 }
    	 
    	//Methode vider
    	 public void vider() {
    		 detailPlan = new TDetailPlanGeneral();
    		 recupFonction = new TFonction();
    		 reucpMarche = new TTypeMarche();
    		 recupModePassation = new VModePassationPn();
    		 newFinancement = new TFinancementPgpm();
    		 listeFinancement = new ArrayList<TFinancementPgpm>();
    		 listeFinancementAgpm = new ArrayList<TFinancement>();
    		 etatDossier = false;
    		 //plan = new TPlanGeneral(); 
    		 controleController.btn_edit_pgpm = false;
    		 devCode ="";
    		 baiCode ="";
    		 souCode=""; 
    	 } 
    	 
    	 
    	 
    	 //sppression de financement update
		 public void removeFinancementUpdate() {
			 System.out.print("+-------------+ "+getSelectFinance().getFipId());
			 try {
				 iservice.deleteObject(getSelectFinance());
					chargeFinancementUpdate();
					userController.setTexteMsg("Suppression effectuée avec succès !");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");

			 } catch (org.hibernate.exception.ConstraintViolationException e) {
				 userController.setTexteMsg("Impossible de supprimer l'Opérateur !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("danger");	 
			 }
		 }
		 
		 //sppression de financement
		 public void removeFinancement() {
			 System.out.print("+-------------+ "+getSelectFinance().getFipId());
			 try {
				 iservice.deleteObject(getSelectFinance());
					chargeFinancement();
					userController.setTexteMsg("Suppression effectuée avec succès !");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");

			 } catch (org.hibernate.exception.ConstraintViolationException e) {
				 userController.setTexteMsg("Impossible de supprimer l'Opérateur !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("danger");	 
			 }
		 }
		 
      //Debut cpmp
		 
		//Afficher les Agpm en fonction du Ministère sélectionné
		 public void chargeAgpmCpmpDmp() {
			 listeAgpm.clear();
			 listeAgpm = (List<VAgpmMinistere>)iservice.getObjectsByColumn("VAgpmMinistere",new ArrayList<String>(Arrays.asList("AGP_ID")),
						 new WhereClause("AGP_STR_CODE",WhereClause.Comparateur.EQ,structure.getStrCode()));		 		 
		 }
		
		
		 
		 public void chargeFonctionCpm() {
			 listeFonctions.clear();
			 listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
						"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM")),
						new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
		 }
		 
		
		 
		 public void filtreFonctionMin() {
				getListeFonctions().clear();
				 listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
							"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM")),
							new WhereClause("FON_COD",WhereClause.Comparateur.LIKE,"%"+filtreFonction+"%"),
							new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			}
			
			public void filtreMinistere() {
				listeMinistere.clear();
				listeMinistere = (List<TMinistere>) iservice.getObjectsByColumn("TMinistere", new ArrayList<String>(Arrays.asList("minCode")),
						new WhereClause("MIN_CODE",WhereClause.Comparateur.LIKE,"%"+filtreMinistere+"%"));
			}
			
			public void onSelectMinisterePgpmCpmp() {
			      plan.setTStructure(new TStructure(structure.getStrCode()));
			      
		
			      recupStructure = new TStructure();
				  recupStructure.setStrCode(structure.getStrCode());
				  recupStructure.setStrLibelleCourt(structure.getStrLibelleCourt());
				  recupStructure.setStrLibelleLong(structure.getStrLibelleLong());
				  recupStructure.setStrEmail(structure.getStrEmail());
				 
				  chargeFonctionCpm();
				  chargeAgpmCpmpDmp();
					}
			
			public void onSelectFonctionPgpmCpmp() {
				 plan.setTFonction(new TFonction(fonction.getFonCod()));
				 
				 recupFonction = new TFonction();
				 recupFonction.setFonCod(fonction.getFonCod());
				 recupFonction.setFonLibelle(fonction.getFonLibelle());
					}
			 //Fin cpmp
			
		 

			
			
			//Debut dmp
			
			
			
			public void chargeFonctionDmp() {
				listeFonctions.clear();
				listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
							"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM","DMP")),
							new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			 }
			
			
				public void filtreFonctionMinDmp() {
					getListeFonctions().clear();
					 listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
								"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM","DMP")),
								new WhereClause("FON_COD",WhereClause.Comparateur.LIKE,"%"+filtreFonction+"%"),
								new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				}
				
				public void filtreMinistereDmp() {
					listeMinistere.clear();
					listeMinistere = (List<TMinistere>) iservice.getObjectsByColumn("TMinistere", new ArrayList<String>(Arrays.asList("minCode")),
							new WhereClause("MIN_CODE",WhereClause.Comparateur.LIKE,"%"+filtreMinistere+"%"));
				}
				
				public void filtreStructureDmp() {
					listeStructure.clear();
					listeStructure = (List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("strCode")),
							new WhereClause("STR_CODE",WhereClause.Comparateur.LIKE,"%"+filtreStructure+"%"));
				}
				
				public void onSelectFonctionPgpmDmp() {
					 plan = new TPlanGeneral();
					 plan.setTFonction(new TFonction(fonction.getFonCod()));
					 
					 recupFonction = new TFonction();
					 recupFonction.setFonCod(fonction.getFonCod());
					 recupFonction.setFonLibelle(fonction.getFonLibelle());
						}
				
				public void onSelectMinisterePgpmDmp() {
					  plan = new TPlanGeneral();
				     // plan.setTMinistere(new TMinistere(ministere.getMinCode()));
				      plan.setTStructure(new TStructure(structure.getStrCode()));
					  
					  recupMinistere = new TMinistere();
					  recupMinistere.setMinCode(ministere.getMinCode());
					  recupMinistere.setMinLibelle(ministere.getMinLibelle());
					  chargeFonctionDmp();
					  chargeAgpmCpmpDmp();
						}
			//Fin dmp
	 
				 public String fermerForm(String value ,String action) throws IOException {
					 userController.initMessage();
				     //chargeData();
				     chargeDataPgspm(); 
					 vider();
					 return userController.renderPage(value);
				 }
				 
				 public String fermerPgpm(String value ,String action) throws IOException {
					 userController.initMessage();
					 vider();
					 return userController.renderPage(value);
				 }
				  
				 //Edition de l'état PGPM
				 public void imprimerPgpm() {
					 String operateur = userController.getSlctd().getTFonction().getFonCod();
						projetReport.longStringparam2(gesCode, operateur, "Pgpm", "Pgpm");
					}
				 
				 
				
				 //Edition de l'PGSPM
				 public void imprimerPgspm() {
					    String operateur = userController.getSlctd().getTFonction().getFonCod();
						projetReport.longStringparam2(plan.getPlgId(), operateur, "Pgspm", "Pgspm");
					}
				 
				 //Edition de l'PGPM Detail
				 public void imprimerPgpmDet() {
						projetReport.longparam1(slctdTd.getTPlanGeneral().getPlgId(), "Pgpm", "Pgpm");
					}
				 //Edition de l'PGSPM
				 public void imprimerPgspmDet() {
						projetReport.longparam1(slctdTd.getTPlanGeneral().getPlgId(), "Pgspm", "Pgspm");
					}
				 
				 
				
				 
				 public TPlanGeneral checkPlan(String minCode) {
					 TPlanGeneral val ;
	   				List<TPlanGeneral> listPlan = ((List<TPlanGeneral>)iservice.getObjectsByColumn("TPlanGeneral",new ArrayList<String>(Arrays.asList("PLG_ID")),
	   						new WhereClause("PLG_MIN_CODE",Comparateur.EQ,""+minCode)));
	   				return (listPlan.isEmpty() || listPlan==null)?null:listPlan.get(0);
	   			}
				 
				

	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "pgpm1":
					chargeData();
					chargeDataAvaliderPgpm();
					listeFinancement.clear();
					listeFinancementAgpm.clear();
					break;
				case "pgpm2":
					chargeBailleur();
					chargeDevise();
					chargeGestions();
					chargeMarches();
					chargeModePassation();
					chargeMode();
					chargeSourceFinance();
					chargeAgpm();
					controleController.btn_save_pgpm =true ;
					listeFinancement.clear();
					listeFinancementAgpm.clear();
				break;
				case "pgpm3":
					editForm();
					chargeBailleur();
					chargeDevise();
					chargeGestions();
					chargeMarches();
					chargeModePassation();
					chargeMode();
					chargeSourceFinance();
					chargeAgpm();
					controleController.btn_save_pgpm =true ;
				break;
				case "pgspm1":
					chargeDataPgspm();
		 			chargeDataAvaliderPgspm();
				break;
				case "pgpm4":
					chargeFinancementDetail();
					break;
				case "pgpm5":
					break;
				case "pgpm6":
					editForm();
					chargeFinancementUpdate();
					chargeBailleur();
					chargeDevise();
					chargeGestions();
					chargeMarches();
					chargeModePassation();
					chargeMode();
					chargeSourceFinance();
					chargeAgpm();
					break;
			    }
		     return userController.renderPage(value);
	 }





	public TPlanGeneral getPlan() {
		return plan;
	}

	public void setPlan(TPlanGeneral plan) {
		this.plan = plan;
	}

	

	public List<VPgpm> getObjetListe() {
		return objetListe;
	}


	public void setObjetListe(List<VPgpm> objetListe) {
		this.objetListe = objetListe;
	}
	


	public List<TBailleur> getListeBailleurs() {
		return listeBailleurs;
	}



	public void setListeBailleurs(List<TBailleur> listeBailleurs) {
		this.listeBailleurs = listeBailleurs;
	}



	public List<TSourceFinancement> getListeSourceFinance() {
		return listeSourceFinance;
	}


	public void setListeSourceFinance(List<TSourceFinancement> listeSourceFinance) {
		this.listeSourceFinance = listeSourceFinance;
	}


	public List<TDevise> getListeDevise() {
		return listeDevise;
	}


	public void setListeDevise(List<TDevise> listeDevise) {
		this.listeDevise = listeDevise;
	}



	public List<TFinancementPgpm> getListeFinancement() {
		return listeFinancement;
	}


	public void setListeFinancement(List<TFinancementPgpm> listeFinancement) {
		this.listeFinancement = listeFinancement;
	}



	public List<VTypeMarcheFils> getListeTypeMarches() {
		return listeTypeMarches;
	}


	public void setListeTypeMarches(List<VTypeMarcheFils> listeTypeMarches) {
		this.listeTypeMarches = listeTypeMarches;
	}
	


/*	public List<TModePassation> getListeModePassation() {
		return listeModePassation;
	}

	public void setListeModePassation(List<TModePassation> listeModePassation) {
		this.listeModePassation = listeModePassation;
	}*/
	
	


	public List<VModePassationPn> getListeModePassation() {
		return listeModePassation;
	}


	public void setListeModePassation(List<VModePassationPn> listeModePassation) {
		this.listeModePassation = listeModePassation;
	}



	public TDetailPlanGeneral getDetailPlan() {
		return detailPlan;
	}


	public void setDetailPlan(TDetailPlanGeneral detailPlan) {
		this.detailPlan = detailPlan;
	}



	public List<TGestion> getListeGestion() {
		return listeGestion;
	}



	public void setListeGestion(List<TGestion> listeGestion) {
		this.listeGestion = listeGestion;
	}


	public long getGesCode() {
		return gesCode;
	}


	public void setGesCode(long gesCode) {
		this.gesCode = gesCode;
	}


/*	public TTypeMarche getMarche() {
		return marche;
	}

	public void setMarche(TTypeMarche marche) {
		this.marche = marche;
	}*/

	public VTypeMarcheFils getMarche() {
		return marche;
	}


	public void setMarche(VTypeMarcheFils marche) {
		this.marche = marche;
	}



/*	public TModePassation getModePassation() {
		return modePassation;
	}


	public void setModePassation(TModePassation modePassation) {
		this.modePassation = modePassation;
	}*/


	public String getFiltreModePassation() {
		return filtreModePassation;
	}


	public void setFiltreModePassation(String filtreModePassation) {
		this.filtreModePassation = filtreModePassation;
	}


	public String getFiltreTypeMarche() {
		return filtreTypeMarche;
	}


	public void setFiltreTypeMarche(String filtreTypeMarche) {
		this.filtreTypeMarche = filtreTypeMarche;
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


	public TFinancementPgpm getNewFinancement() {
		return newFinancement;
	}


	public void setNewFinancement(TFinancementPgpm newFinancement) {
		this.newFinancement = newFinancement;
	}


	public TFinancementPgpm getSelectFinance() {
		return selectFinance;
	}


	public void setSelectFinance(TFinancementPgpm selectFinance) {
		this.selectFinance = selectFinance;
	}


	public List<VAgpmMinistere> getListeAgpm() {
		return listeAgpm;
	}
	public void setListeAgpm(List<VAgpmMinistere> listeAgpm) {
		this.listeAgpm = listeAgpm;
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
	/*public TAgpm getAgpm() {
		return agpm;
	}


	public void setAgpm(TAgpm agpm) {
		this.agpm = agpm;
	}*/


	
	
	

	public VAgpmFonction getAgpm() {
		return agpm;
	}


	public void setAgpm(VAgpmFonction agpm) {
		this.agpm = agpm;
	}

	

	public TAffichagePgpm getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(TAffichagePgpm slctdTd) {
		this.slctdTd = slctdTd;
	}


	public List<TDossierPlanGeneral> getDossListe() {
		return dossListe;
	}


	public void setDossListe(List<TDossierPlanGeneral> dossListe) {
		this.dossListe = dossListe;
	}


	public TDossierPlanGeneral getSelectedDossier() {
		return selectedDossier;
	}


	public void setSelectedDossier(TDossierPlanGeneral selectedDossier) {
		this.selectedDossier = selectedDossier;
	}


	public String getNatPiece() {
		return natPiece;
	}


	public void setNatPiece(String natPiece) {
		this.natPiece = natPiece;
	}


	/*public TModePassation getRecupModePassation() {
		return recupModePassation;
	}


	public void setRecupModePassation(TModePassation recupModePassation) {
		this.recupModePassation = recupModePassation;
	}*/
	

	public VModePassationPn getModePassation() {
		return modePassation;
	}
	public void setModePassation(VModePassationPn modePassation) {
		this.modePassation = modePassation;
	}


	public VModePassationPn getRecupModePassation() {
		return recupModePassation;
	}
	public void setRecupModePassation(VModePassationPn recupModePassation) {
		this.recupModePassation = recupModePassation;
	}


	public TTypeMarche getReucpMarche() {
		return reucpMarche;
	}
	public void setReucpMarche(TTypeMarche reucpMarche) {
		this.reucpMarche = reucpMarche;
	}


	public TAgpm getRecupAgpm() {
		return recupAgpm;
	}
	public void setRecupAgpm(TAgpm recupAgpm) {
		this.recupAgpm = recupAgpm;
	}


	public String getSit() {
		return sit;
	}


	public void setSit(String sit) {
		this.sit = sit;
	}


	public boolean isEtatAgpm() {
		return etatAgpm;
	}


	public void setEtatAgpm(boolean etatAgpm) {
		this.etatAgpm = etatAgpm;
	}


	public boolean isEtatDossier() {
		return etatDossier;
	}


	public void setEtatDossier(boolean etatDossier) {
		this.etatDossier = etatDossier;
	}


	public List<TDetailPlanGeneral> getListeDetail() {
		return listeDetail;
	}


	public void setListeDetail(List<TDetailPlanGeneral> listeDetail) {
		this.listeDetail = listeDetail;
	}


	public TDetailPlanGeneral getDemDetail() {
		return demDetail;
	}


	public void setDemDetail(TDetailPlanGeneral demDetail) {
		this.demDetail = demDetail;
	}


	public TMinistere getMinistere() {
		return ministere;
	}


	public void setMinistere(TMinistere ministere) {
		this.ministere = ministere;
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


	public VFonctionMinistere getFonction() {
		return fonction;
	}


	public void setFonction(VFonctionMinistere fonction) {
		this.fonction = fonction;
	}


	public List<TMinistere> getListeMinistere() {
		return listeMinistere;
	}


	public void setListeMinistere(List<TMinistere> listeMinistere) {
		this.listeMinistere = listeMinistere;
	}


	public List<VFonctionMinistere> getListeFonctions() {
		return listeFonctions;
	}


	public void setListeFonctions(List<VFonctionMinistere> listeFonctions) {
		this.listeFonctions = listeFonctions;
	}


	public List<VFonctionMinistere> getListeFonctionsDmp() {
		return listeFonctionsDmp;
	}


	public void setListeFonctionsDmp(List<VFonctionMinistere> listeFonctionsDmp) {
		this.listeFonctionsDmp = listeFonctionsDmp;
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


	public List<TAffichagePgpm> getObjetList() {
		return objetList;
	}


	public void setObjetList(List<TAffichagePgpm> objetList) {
		this.objetList = objetList;
	}


	public List<VPgpmStatut> getPgpmstatutList() {
		return pgpmstatutList;
	}


	public void setPgpmstatutList(List<VPgpmStatut> pgpmstatutList) {
		this.pgpmstatutList = pgpmstatutList;
	}


	public VPgpmStatut getPgpmstatut() {
		return pgpmstatut;
	}


	public void setPgpmstatut(VPgpmStatut pgpmstatut) {
		this.pgpmstatut = pgpmstatut;
	}


	public List<TAffichagePgpm> getListSelectionTransmission() {
		return listSelectionTransmission;
	}


	public void setListSelectionTransmission(List<TAffichagePgpm> listSelectionTransmission) {
		this.listSelectionTransmission = listSelectionTransmission;
	}


	public List<TAffichagePgpm> getValidationListe() {
		return validationListe;
	}


	public void setValidationListe(List<TAffichagePgpm> validationListe) {
		this.validationListe = validationListe;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}
	public List<TAffichagePgpm> getListPgspm() {
		return listPgspm;
	}
	public void setListPgspm(List<TAffichagePgpm> listPgspm) {
		this.listPgspm = listPgspm;
	}

	
	public List<VAgpmFonction> getAgpmList() {
		return agpmList;
	}
	
	public void setAgpmList(List<VAgpmFonction> agpmList) {
		this.agpmList = agpmList;
	}

	
	public List<TAffichagePgpm> getValidationListePgspm() {
		return validationListePgspm;
	}
	public void setValidationListePgspm(List<TAffichagePgpm> validationListePgspm) {
		this.validationListePgspm = validationListePgspm;
	}
	public String getDateToday() {
		return dateToday;
	}
	public void setDateToday(String dateToday) {
		this.dateToday = dateToday;
	}


	public List<TAffichagePgpm> getListPgpm() {
		return listPgpm;
	}


	public void setListPgpm(List<TAffichagePgpm> listPgpm) {
		this.listPgpm = listPgpm;
	}


	public boolean isEtatEdit() {
		return etatEdit;
	}


	public void setEtatEdit(boolean etatEdit) {
		this.etatEdit = etatEdit;
	}


	public List<TAffichagePgpm> getPgpmTrans() {
		return pgpmTrans;
	}


	public void setPgpmTrans(List<TAffichagePgpm> pgpmTrans) {
		this.pgpmTrans = pgpmTrans;
	}


	public List<TAffichagePgpm> getPgspmTrans() {
		return pgspmTrans;
	}

	public void setPgspmTrans(List<TAffichagePgpm> pgspmTrans) {
		this.pgspmTrans = pgspmTrans;
	}


	public List<TAffichagePgpm> getPgpmValCp() {
		return pgpmValCp;
	}


	public void setPgpmValCp(List<TAffichagePgpm> pgpmValCp) {
		this.pgpmValCp = pgpmValCp;
	}


	public List<TAffichagePgpm> getPgpmValDmp() {
		return pgpmValDmp;
	}
	public void setPgpmValDmp(List<TAffichagePgpm> pgpmValDmp) {
		this.pgpmValDmp = pgpmValDmp;
	}


	public List<TAffichagePgpm> getPgspmValCp() {
		return pgspmValCp;
	}


	public void setPgspmValCp(List<TAffichagePgpm> pgspmValCp) {
		this.pgspmValCp = pgspmValCp;
	}


	public List<TAffichagePgpm> getPgspmValDmp() {
		return pgspmValDmp;
	}
	public void setPgspmValDmp(List<TAffichagePgpm> pgspmValDmp) {
		this.pgspmValDmp = pgspmValDmp;
	}


	public List<TAffichagePgpm> getPgpmDifCp() {
		return pgpmDifCp;
	}


	public void setPgpmDifCp(List<TAffichagePgpm> pgpmDifCp) {
		this.pgpmDifCp = pgpmDifCp;
	}


	public List<TAffichagePgpm> getPgpmDifDmp() {
		return pgpmDifDmp;
	}


	public void setPgpmDifDmp(List<TAffichagePgpm> pgpmDifDmp) {
		this.pgpmDifDmp = pgpmDifDmp;
	}


	public List<TFinancementPgpm> getFinancementListe() {
		return financementListe;
	}
	public void setFinancementListe(List<TFinancementPgpm> financementListe) {
		this.financementListe = financementListe;
	}


	public List<TAffichagePgpm> getPgspmDifCp() {
		return pgspmDifCp;
	}
	public void setPgspmDifCp(List<TAffichagePgpm> pgspmDifCp) {
		this.pgspmDifCp = pgspmDifCp;
	}


	public List<TAffichagePgpm> getPgspmDifDmp() {
		return pgspmDifDmp;
	}
	public void setPgspmDifDmp(List<TAffichagePgpm> pgspmDifDmp) {
		this.pgspmDifDmp = pgspmDifDmp;
	}


	public List<TPlanGeneral> getListPlan() {
		return listPlan;
	}


	public void setListPlan(List<TPlanGeneral> listPlan) {
		this.listPlan = listPlan;
	}


	public String getNbrePgpm() {
		return nbrePgpm;
	}


	public void setNbrePgpm(String nbrePgpm) {
		this.nbrePgpm = nbrePgpm;
	}


	public String getNbrePgspm() {
		return nbrePgspm;
	}

	public void setNbrePgspm(String nbrePgspm) {
		this.nbrePgspm = nbrePgspm;
	}


	public TStructure getStructure() {
		return structure;
	}


	public void setStructure(TStructure structure) {
		this.structure = structure;
	}


	public TStructure getRecupStructure() {
		return recupStructure;
	}


	public void setRecupStructure(TStructure recupStructure) {
		this.recupStructure = recupStructure;
	}


	public List<TStructure> getListeStructure() {
		return listeStructure;
	}


	public void setListeStructure(List<TStructure> listeStructure) {
		this.listeStructure = listeStructure;
	}


	public String getFiltreStructure() {
		return filtreStructure;
	}
	public void setFiltreStructure(String filtreStructure) {
		this.filtreStructure = filtreStructure;
	}


	public List<VModePassation> getListeMode() {
		return listeMode;
	}
	public void setListeMode(List<VModePassation> listeMode) {
		this.listeMode = listeMode;
	}


	public VModePassation getRecupModeListe() {
		return recupModeListe;
	}


	public void setRecupModeListe(VModePassation recupModeListe) {
		this.recupModeListe = recupModeListe;
	}


	public VModePassation getPassationListe() {
		return passationListe;
	}


	public void setPassationListe(VModePassation passationListe) {
		this.passationListe = passationListe;
	}


	public String getMultiFiltre() {
		return multiFiltre;
	}
	public void setMultiFiltre(String multiFiltre) {
		this.multiFiltre = multiFiltre;
	}


	public boolean isSelectBailleur() {
		return selectBailleur;
	}
	public void setSelectBailleur(boolean selectBailleur) {
		this.selectBailleur = selectBailleur;
	}


	public String getSourfin() {
		return sourfin;
	}

	public void setSourfin(String sourfin) {
		this.sourfin = sourfin;
	}


	public String getStatutTrans() {
		return statutTrans;
	}

	public void setStatutTrans(String statutTrans) {
		this.statutTrans = statutTrans;
	}


	public boolean isBtnNewAgpm() {
		return btnNewAgpm;
	}


	public void setBtnNewAgpm(boolean btnNewAgpm) {
		this.btnNewAgpm = btnNewAgpm;
	}


	public List<TFinancement> getListeFinancementAgpm() {
		return listeFinancementAgpm;
	}


	public void setListeFinancementAgpm(List<TFinancement> listeFinancementAgpm) {
		this.listeFinancementAgpm = listeFinancementAgpm;
	}


	public TFinancement getFinAgpm() {
		return finAgpm;
	}


	public void setFinAgpm(TFinancement finAgpm) {
		this.finAgpm = finAgpm;
	}


	public boolean isEtatFinancement1() {
		return etatFinancement1;
	}


	public void setEtatFinancement1(boolean etatFinancement1) {
		this.etatFinancement1 = etatFinancement1;
	}


	public boolean isEtatFinancement2() {
		return etatFinancement2;
	}


	public void setEtatFinancement2(boolean etatFinancement2) {
		this.etatFinancement2 = etatFinancement2;
	}


	public boolean isLoveAgpmRappel() {
		return loveAgpmRappel;
	}


	public void setLoveAgpmRappel(boolean loveAgpmRappel) {
		this.loveAgpmRappel = loveAgpmRappel;
	}


	public boolean isBtnAgpmRappel() {
		return btnAgpmRappel;
	}


	public void setBtnAgpmRappel(boolean btnAgpmRappel) {
		this.btnAgpmRappel = btnAgpmRappel;
	}


	public boolean isSelectTresor() {
		return selectTresor;
	}


	public void setSelectTresor(boolean selectTresor) {
		this.selectTresor = selectTresor;
	}


	public boolean isBtnPgspmRappel() {
		return btnPgspmRappel;
	}


	public void setBtnPgspmRappel(boolean btnPgspmRappel) {
		this.btnPgspmRappel = btnPgspmRappel;
	}


	public boolean isSelectPartBai() {
		return selectPartBai;
	}


	public void setSelectPartBai(boolean selectPartBai) {
		this.selectPartBai = selectPartBai;
	}


	public List<THistoPlanGeneral> getListeHisto() {
		return listeHisto;
	}


	public void setListeHisto(List<THistoPlanGeneral> listeHisto) {
		this.listeHisto = listeHisto;
	}


	public THistoPlanGeneral getHistoPgpm() {
		return histoPgpm;
	}


	public void setHistoPgpm(THistoPlanGeneral histoPgpm) {
		this.histoPgpm = histoPgpm;
	}


	public String getFinBaiCaode() {
		return finBaiCaode;
	}


	public void setFinBaiCaode(String finBaiCaode) {
		this.finBaiCaode = finBaiCaode;
	}


	public VUpdatePgpm getUpdateOperation() {
		return updateOperation;
	}


	public void setUpdateOperation(VUpdatePgpm updateOperation) {
		this.updateOperation = updateOperation;
	}


	public List<VUpdatePgpm> getListUpdate() {
		return listUpdate;
	}


	public void setListUpdate(List<VUpdatePgpm> listUpdate) {
		this.listUpdate = listUpdate;
	}
	
	
}
