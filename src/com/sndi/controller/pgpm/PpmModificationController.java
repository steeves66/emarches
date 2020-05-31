package com.sndi.controller.pgpm;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;


import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAffichagePgpm;
import com.sndi.model.TAffichagePpm;
import com.sndi.model.TBailleur;
import com.sndi.model.TCharge;
import com.sndi.model.TDetailPlanGeneral;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TDevise;
import com.sndi.model.TFinancementPgpm;
import com.sndi.model.TFinancementPpm;
import com.sndi.model.TFonction;
import com.sndi.model.TGestion;
import com.sndi.model.THistoPlanGeneral;
import com.sndi.model.THistoPlanPassation;
import com.sndi.model.TLBudgets;
import com.sndi.model.TMinistere;
import com.sndi.model.TModePassation;
import com.sndi.model.TModeleDacType;
import com.sndi.model.TPlanGeneral;
import com.sndi.model.TPlanPassation;
import com.sndi.model.TSourceFinancement;
import com.sndi.model.TStatut;
import com.sndi.model.TStructure;
import com.sndi.model.TTypeCharge;
import com.sndi.model.TTypeMarche;
import com.sndi.model.TTypePiecesDac;
import com.sndi.model.TTypeProcedure;
import com.sndi.model.VDetPlaning;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VGenerationDate;
import com.sndi.model.VLigneImputation;
import com.sndi.model.VModePassation;
import com.sndi.model.VModeleAmi;
import com.sndi.model.VModeleDao;
import com.sndi.model.VPgpmFonction;
import com.sndi.model.VPpmStatut;
import com.sndi.model.VPpmliste;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.model.VUpdatePpm;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
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
	 TableauBordController tableauBordController;

	 
	 @Autowired
	 DownloadFileServlet downloadFileServlet;


	 
	
	 @PostConstruct
	 public void postContr() {
		 controleController.fonctionaliteDynamic();
		 //chargeData();
		 //chargeDataPspm();
		// chargeDataAvaliderPpm();
		 //chargeDataAvaliderPspm();
		 chargeGestions();
		 chargeBailleur();
		 chargeDevise();
		 chargeFinancement();
		 chargeMarches();
		 chargeModePassation();
		 //chargePpmTrans();
		 //chargePspmTrans();
		 //chargePpmValDmp();
		 //chargePpmValCp();
		 //chargePpmDifCp();
		 //chargePpmDifDmp();
		 //chargePspmDifCp();
		 //chargePspmDifDmp();
		 chargeSourceFinance();
		 //chargeImputation();
		 chargeFonction();
		 chargeTypeCharges();
		 chargeTypeProcedures(); 
		 chargeFonctionDmp();
		 chargeMode();
	 }
	
	 
	      //Déclaration des Listes
		 private List<TDetailPlanPassation> listeTsPpm = new ArrayList<TDetailPlanPassation>();
		 private List<VDetPlaning> affichPpm = new ArrayList<VDetPlaning>();
	     //private List<TAffichagePpm> listePpm = new ArrayList<TAffichagePpm>();
	     private List<VPpmliste> listePpm = new ArrayList<VPpmliste>();
	     private List<THistoPlanPassation> listeHisto = new ArrayList<THistoPlanPassation>();
	     private List<VPgpmFonction> listePgpm = new ArrayList<VPgpmFonction>();
	     private List<VPgpmFonction> listePgspm = new ArrayList<VPgpmFonction>();
	     private List<TFinancementPpm> listeFinancement = new ArrayList<TFinancementPpm>();
	     private List<TFinancementPgpm> listeFinancementPgpm = new ArrayList<TFinancementPgpm>();
	     private List<TMinistere> listeMinistere = new ArrayList<TMinistere>();
		 private List<TStructure> listeStructure = new ArrayList<TStructure>();
		 private List<VModePassation> listeMode = new ArrayList<VModePassation>();
	     private List<VModeleDao> listeDao = new ArrayList<VModeleDao>();
	     private List<VModeleAmi> listeAmi = new ArrayList<VModeleAmi>();
	     
	     
	     private List<TStructure> listeStructures = new ArrayList<TStructure>();
	     private List<TCharge> listeCharges = new ArrayList<TCharge>();
	     private List<TTypeCharge> listeTypeCharges = new ArrayList<TTypeCharge>();
	     private List<VFonctionMinistere> listeFonctions = new ArrayList<VFonctionMinistere>();
		 private List<VFonctionMinistere> listeFonctionsDmp = new ArrayList<VFonctionMinistere>();
	     private List<VLigneImputation> listeImputations = new ArrayList<VLigneImputation>(); 
		 private List<TBailleur> listeBailleurs = new ArrayList<TBailleur>();
		 private List<TTypeProcedure> listeProcedures = new ArrayList<TTypeProcedure>();
		 private List<VGenerationDate> listeDateGenere = new ArrayList<VGenerationDate>();
		 private List<TSourceFinancement> listeSourceFinance = new ArrayList<TSourceFinancement>();
		 private List<TDevise> listeDevise = new ArrayList<TDevise>();
		 private List<TTypeMarche> listeTypeMarches = new ArrayList<TTypeMarche>();
		 private List<TModePassation> listeModePassation = new ArrayList<TModePassation>();
		 private List<TGestion> listeGestion = new ArrayList<TGestion>(); 
		 //private List<TAffichagePpm> validationListe = new ArrayList<TAffichagePpm>();
		 private List<VPpmliste> validationListe = new ArrayList<VPpmliste>();
		 private List<TAffichagePpm>listSelectionTransmission =new ArrayList<TAffichagePpm>();
		 private TModePassation recupModePassation = new TModePassation();
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
	     private List<TPlanPassation> listPlan = new ArrayList<TPlanPassation>();
	     private List<VUpdatePpm> listUpdate = new ArrayList<VUpdatePpm>();
	 
		//Declaration des objets
		 private TPlanPassation planPass = new TPlanPassation();
		 private TDetailPlanPassation detailPass = new TDetailPlanPassation();
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
		 private VGenerationDate geneDate = new VGenerationDate();
		 //private TTypeMarche reucpMarche = new TTypeMarche();
		 private VTypeMarcheFils reucpMarche = new VTypeMarcheFils();
		 private VLigneImputation ligne = new VLigneImputation();
		 private VLigneImputation recupLigne = new VLigneImputation();
		 private TFinancementPpm newFinancement = new TFinancementPpm();
		 private TFinancementPpm selectFinance = new TFinancementPpm();
		 private TFinancementPgpm fipPgpm = new TFinancementPgpm();
		 private VPpmliste slctdTd = new VPpmliste();
		 private TModePassation modePassation = new TModePassation();
		 private VPpmStatut ppmstatut= new VPpmStatut();
		 private VFonctionMinistere fonction =new VFonctionMinistere();
		 private TStructure structure =new TStructure();
		 private TStructure newStr =new TStructure();
		 private TStructure recupstructure =new TStructure();
		 private TCharge charge =new TCharge();
		 private TDetailPlanPassation recupPass = new TDetailPlanPassation();
		 private TDetailPlanPassation passation = new TDetailPlanPassation();
		 private TStructure recupStructure= new TStructure();
		 private THistoPlanPassation histoPpm = new THistoPlanPassation();
		 private VUpdatePpm updatePpm = new VUpdatePpm();
		
	 
		//Declaration des variables
		 private long gesCode;	
		 private long  totalLigne;
		 private long  totalMontant;
		 private String filtreTypeMarche="";
		 private String filtreModePassation="";
		 private String observation="";
		 private String natPiece ="";
		 private String typProce ="";
		 private String tydCode ="";
		 private String pslInf ="30000000";
		 private String pslSup ="50000000";
		 private String psoInf ="50000000";
		 private String psoSup ="100000000";
		 private String statutTrans ="";
		 private String baiCode;
		 private String souCode;
		 private String devCode="CFA";
		 private String filtreFonction="";
		 private String filtreMinistere="";
		 private String statutAffiche="";
		 private String statutUpdate="";
		 private String typCharge ="";
		 private String filtreLigne ="";
		 private String filtreStructure ="";
		 private String filtrePgpm ="";
		 private String filtrePpm ="";
		 private String nbrePpm ="";
		 private String nbrePspm ="";
		 private String filtrePgspm ="";
		 private String multiFiltre ="";
		 private Date dateApp;
		 private Date datePub;
		 private Date dateJugement;
		 private boolean skip;
		 private boolean boutonEdit =false;
		 private boolean boutonEditPspm =false;
		 private boolean etatPsl =false;
		 private boolean etatPso =false;
		 private boolean modeleAmi =false;
		 private boolean modeleDao =true;
		 private boolean boutonEditUpdate = false;
	 
	 
	 
		 public String onFlowProcess(FlowEvent event) {
		        if(skip) {
		            skip = false;   //reset in case user goes back
		            return "confirm";
		        }
		        else {
		            return event.getNewStep();
		        }
		    }
		 
		 
		
		 //Liste des Modes de Passation restreint
		 public void chargeMode() {
			 listeMode.clear();
			 listeMode = ((List<VModePassation>)iservice.getObjectsByColumn("VModePassation",new ArrayList<String>(Arrays.asList("MOP_CODE"))));	 		 
		 }
		 
		 
		 //Liste des Pspm transmis par l'acteur connecté
		 public void chargePspmTrans() {
			 pspmTrans.clear();
			 pspmTrans = ((List<TAffichagePpm>)iservice.getObjectsByColumn("TAffichagePpm",new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
					     new WhereClause("AFF_DPP_STA_CODE",Comparateur.EQ,"S1T"),
					    new WhereClause("AFF_DPP_TYPE_PLAN",Comparateur.EQ,"PS"),
						 new WhereClause("AFF_DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
		 }
		 
		 
		 //Liste totale des Pspm transmis par l'acteur connecté
		 public void chargePspmTot() {
			 pspmTrans.clear();
			 pspmTrans = ((List<TAffichagePpm>)iservice.getObjectsByColumn("TAffichagePpm",new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
					     new WhereClause("AFF_DPP_STA_CODE",Comparateur.EQ,"S1T"),
					    new WhereClause("AFF_DPP_TYPE_PLAN",Comparateur.EQ,"PS")));
		 }
		 
		 
		 //Liste des Ppm validés par le cpmp
		 public void chargePspmValCp() {
			 pspmValCp.clear();
			 pspmValCp = ((List<TAffichagePpm>)iservice.getObjectsByColumn("TAffichagePpm",new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
					    new WhereClause("AFF_DPP_STA_CODE",Comparateur.EQ,"S2V"),
					    new WhereClause("AFF_DPP_TYPE_PLAN",Comparateur.EQ,"PS"),
						 new WhereClause("AFF_DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
		 }
		 
		//Liste des Ppm validés par le cpmp
		 public void chargePspmValDmp() {
			 pspmValDmp.clear();
			 pspmValDmp = ((List<TAffichagePpm>)iservice.getObjectsByColumn("TAffichagePpm",new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
					    new WhereClause("AFF_DPP_STA_CODE",Comparateur.EQ,"S3V"),
					    new WhereClause("AFF_DPP_TYPE_PLAN",Comparateur.EQ,"PS")));
		 }
		 
		 //Liste des Ppm différés par le cpmp
		 public void chargePpmDifCp() {
			 ppmDifCp.clear();
			 ppmDifCp = ((List<TAffichagePpm>)iservice.getObjectsByColumn("TAffichagePpm",new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
					    new WhereClause("AFF_DPP_STA_CODE",Comparateur.EQ,"S2D"),
					    new WhereClause("AFF_DPP_TYPE_PLAN",Comparateur.EQ,"PN"),
						 new WhereClause("AFF_DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
		 }
		 
		//Liste des Ppm différés par le cpmp
		 public void chargePpmDifDmp() {
			 ppmDifDmp.clear();
			 ppmDifDmp = ((List<TAffichagePpm>)iservice.getObjectsByColumnIn("TAffichagePpm",new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
					   "AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SPR")),
					    new WhereClause("AFF_DPP_TYPE_PLAN",Comparateur.EQ,"PN")));
		      }
		 
	 
		 public void filtreStructure() {
				listeStructure.clear();
				listeStructure = (List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("strCode")),
						new WhereClause("STR_CODE",WhereClause.Comparateur.LIKE,"%"+filtreStructure+"%"));
			}
		 
		 public void filtreStructureDmp() {
				listeStructure.clear();
				listeStructure = (List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("strCode")),
						new WhereClause("STR_CODE",WhereClause.Comparateur.LIKE,"%"+filtreStructure+"%"));
			}
			
		 
		 

		 //Liste des Pspm différés par le cpmp
		 public void chargePspmDifCp() {
			 pspmDifCp.clear();
			 pspmDifCp = ((List<TAffichagePpm>)iservice.getObjectsByColumn("TAffichagePpm",new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
					    new WhereClause("AFF_DPP_STA_CODE",Comparateur.EQ,"S2D"),
					    new WhereClause("AFF_DPP_TYPE_PLAN",Comparateur.EQ,"PS"),
						 new WhereClause("AFF_DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
		 }
		 
		//Liste des Pspm différés par le cpmp
		 public void chargePspmDifDmp() {
			 pspmDifDmp.clear();
			 pspmDifDmp = ((List<TAffichagePpm>)iservice.getObjectsByColumnIn("TAffichagePpm",new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
					    "AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SPD")),
					    new WhereClause("AFF_DPP_TYPE_PLAN",Comparateur.EQ,"PS")));
						// new WhereClause("AFF_DPP_MIN_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode())));		 		 
		      }
		 
	 
		 //Methode Principale de Chargement des PPM
		 public void chargeData(){
			 getListePpm().clear();
			 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")), 
					"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SPR")),
					new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("listePpm size: "+listePpm.size());
				//Actualisation du Tableau de Bord
				tableauBordController.chargeDataPpm();
				//Affichage du nombre de ppm saisis
				nbrePpm =""+getNbrePpmTotal();
		  }
		 
		 
		 
		//Methode Principale de Chargement des PSPM
		 public void chargeDataPspm(){ 
			 getListePpm().clear();
			 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")), 
					"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SPD")),
					new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("listePpm size: "+listePpm.size());
				//Actualisation du Tableau de Bord
				tableauBordController.chargeDataPspm();
				//Affichage du nombre des pspm saisis
				nbrePspm =""+getNbrePspmTotal();
		  }
		 
		 
		 public int getNbrePpmTotal(){
				int i = iservice.countTableByColumn("V_PPMLISTE", "DPP_ID",
						new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
						new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
		 
		 public int getNbrePspmTotal(){
				int i = iservice.countTableByColumn("V_PPMLISTE", "DPP_ID",
						new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
		
		 
		//Liste des PPM Transmis (Box des ppm transmis)
		 public void chargeDataTransmission(){
			 getListePpm().clear();
			 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
					 new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.EQ,"S1T"),
					new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("listePpm size: "+listePpm.size());
				//Actualisation du Tableau de Bord
				tableauBordController.chargeDataPpmPspm();
		}
	 
	 
	     //Methode de validation des PPM
		 public void chargeDataAvaliderPpm() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 getValidationListe().clear();
					 validationListe = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
								"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
								new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
							_logger.info("validationListe size: "+validationListe.size());	
							//Actualisation du Tableau de Bord
							tableauBordController.chargeDataPpm();
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
								validationListe = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
								"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPT")),
								new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
								//new WhereClause("AFF_DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
								_logger.info("affichageListe size: "+validationListe.size());
								//Actualisation du Tableau de Bord
								tableauBordController.chargeDataPpm();
					 }else
						  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							  getValidationListe().clear();
								validationListe = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
								"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPT")),
								new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
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
					 validationListe = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
								"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
								new WhereClause("DPP_MOP_CODE",WhereClause.Comparateur.EQ,"PSC"),
								new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
							_logger.info("affichageListe size: "+validationListe.size());	
							//Actualisation du Tableau de Bord
							tableauBordController.chargeDataPspm();
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
								validationListe = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
										"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPS")), 
								     new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
								//new WhereClause("AFF_DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
								_logger.info("validationListe size: "+validationListe.size());
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
					 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")), 
							"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
							new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
							new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
						_logger.info("listePpm size: "+listePpm.size());
						//Actualisation du Tableau de Bord
						tableauBordController.chargeDataPpm();
						//Affichage du nombre de ppm saisis
						nbrePpm =""+getNbrePpmTotal();
						
					 }else 
					      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
					    	  getValidationListe().clear();
								 validationListe = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
											"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
											new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
											new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
										    new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
										_logger.info("validationListe size: "+validationListe.size());	
										//Actualisation du Tableau de Bord
										tableauBordController.chargeDataPpm();
					        }else 
					    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					    		  getValidationListe().clear();
									validationListe = (List<VPpmliste>) iservice.getObjectsByColumnDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
									new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
									new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
									 new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
									_logger.info("affichageListe size: "+validationListe.size());
									//Actualisation du Tableau de Bord
									tableauBordController.chargeDataPpm();
		         	  }
			     }
			
			//Filtre multicritère pour les PSPM
			public void chargerPspmRecherche() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getListePpm().clear();
					 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")), 
							"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
							new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
							new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
						tableauBordController.chargeDataPspm();
					 }else 
					      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
					    	  getValidationListe().clear();
								 validationListe = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
											"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
											new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
											new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
											 new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));	
										//Actualisation du Tableau de Bord
										tableauBordController.chargeDataPspm();
					        }else 
					    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					    		  getValidationListe().clear();
									validationListe = (List<VPpmliste>) iservice.getObjectsByColumnDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
									new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
									new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
									 new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
									//Actualisation du Tableau de Bord
									tableauBordController.chargeDataPspm();
					    	  }
			           }
			
			
			//Réinitialiser les PPM
			public void reinitialiserPpm() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getListePpm().clear();
					 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")), 
							"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
							new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("listePpm size: "+listePpm.size());
						//Actualisation du Tableau de Bord
						tableauBordController.chargeDataPpm();
						//Affichage du nombre de ppm saisis
						nbrePpm =""+getNbrePpmTotal();
						multiFiltre="";
					 }else 
					      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
					    	  getValidationListe().clear();
								 validationListe = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
											"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
											new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
											new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
										_logger.info("affichageListe size: "+validationListe.size());	
										//Actualisation du Tableau de Bord
										tableauBordController.chargeDataPpm();
										multiFiltre="";
					        }else 
					    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					    		  getValidationListe().clear();
									validationListe = (List<VPpmliste>) iservice.getObjectsByColumnDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
									new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
									new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
									_logger.info("affichageListe size: "+validationListe.size());
									//Actualisation du Tableau de Bord
									tableauBordController.chargeDataPpm();
									multiFiltre="";
		         	  }
			     }
			
			
			
			public void reinitialiserPspm() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getListePpm().clear();
					 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_ID")), 
							"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
							new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("listePpm size: "+listePpm.size());
						//Actualisation du Tableau de Bord
						tableauBordController.chargeDataPspm();
						//Affichage du nombre de ppm saisis
						nbrePpm =""+getNbrePpmTotal();
						multiFiltre="";
						
					 }else 
					      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
					    	  getValidationListe().clear();
								 validationListe = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
											"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
											new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
											new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
										_logger.info("validationListe size: "+validationListe.size());	
										//Actualisation du Tableau de Bord
										tableauBordController.chargeDataPspm();
										multiFiltre="";
					        }else 
					    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					    		  getValidationListe().clear();
									validationListe = (List<VPpmliste>) iservice.getObjectsByColumnDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
									new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
									new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
									_logger.info("validationListe size: "+validationListe.size());
									//Actualisation du Tableau de Bord
									tableauBordController.chargeDataPspm();
									multiFiltre="";
		         	  }
			     }
		 
		 
		 
		
		 
		 //Affichage dynamique des dates prévisionnelles
		 public void checkDatePrevisionnelle() {
			 if(typProce.equalsIgnoreCase("PSO")) {
				controleController.etatPso = true;
				controleController.etatPsl = false;
	
			 }else if(typProce.equalsIgnoreCase("PSL")){
				controleController.etatPso = false;
				controleController.etatPsl = true;
			 }
		 }
		 
		 
		 //Impression unique du pspm
      	 public void pspmUnique() { 
      		 if(slctdTd.getDppMopCode() == "PSO") {
      			 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_pso", "Fiche_operation_pso" ); 
      		 }else if(slctdTd.getDppMopCode() == "PSL") {
      			 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_psl", "Fiche_operation_psl" ); 
      		 }else if(slctdTd.getDppMopCode() == "PSC") {
      			 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_psc", "Fiche_operation_psc" );  
      		 }
      	 }
      	 
      	 //Impression unique du ppm
      	 public void ppmUnique() { 
      			 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_ppm", "Fiche_operation_ppm" ); 
      	 }
		 
		 
		 
		//Début des méthodes pour les affichages 
			//Combobox Gestions
		 public void chargeGestions(){
			 listeGestion=(List<TGestion>) iservice.getObjectsByColumnDesc("TGestion", new ArrayList<String>(Arrays.asList("GES_CODE")));	
		 } 
	   //Combobox Bailleur
	   public void chargeBailleur() {
		 listeBailleurs.clear();
		 listeBailleurs =(List<TBailleur>) iservice.getObjectsByColumn("TBailleur", new ArrayList<String>(Arrays.asList("baiCode")));
		} 
	   
	 //Combobox type Charge
	   public void chargeTypeCharges() {
		   listeTypeCharges.clear(); 
		   listeTypeCharges =(List<TTypeCharge>) iservice.getObjectsByColumn("TTypeCharge", new ArrayList<String>(Arrays.asList("tycCode")));
		} 
	   
	 //Combobox type de procédures
	   public void chargeTypeProcedures() {
		   listeProcedures.clear(); 
		   listeProcedures =(List<TTypeProcedure>) iservice.getObjectsByColumn("TTypeProcedure", new ArrayList<String>(Arrays.asList("typId")));
		} 
	   
	   //Liste des Charges
	   public void chargeCharges() {
		 listeCharges.clear();
		 listeCharges =(List<TCharge>) iservice.getObjectsByColumn("TCharge", new ArrayList<String>(Arrays.asList("chrId")));
		}
	   
		  //Love pour Structure
		 public void chargeStructures() {
			 listeStructures.clear();
			 listeStructures =(List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("STR_CODE")));
		 }
		 
		  //Love pour Structure
		 public void filtreStructures() {
			 listeStructures.clear();
			 listeStructures =(List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("STR_CODE")),
					 new WhereClause("STR_CODE",WhereClause.Comparateur.LIKE,"%"+filtreStructure+"%"));		 
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
		 
		 
		//Chargement des imputations ou lignes budgétaires pour le AC
	  public void chargeImputation() {
		 listeImputations.clear();
		 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())); 
			}
	  
	//Chargement des imputations ou lignes budgétaires en mode PSL pour le AC
	  public void chargeImputationPsl() {
		 listeImputations.clear();
		 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				 new WhereClause("LBG_TOT_DOT",Comparateur.BET,pslInf+" AND "+pslSup),
				 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())); 
			}
	  
	  
	//Chargement des imputations ou lignes budgétaires en mode PSO pour le AC
	  public void chargeImputationPso() {
		 listeImputations.clear();
		 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				 new WhereClause("LBG_TOT_DOT",Comparateur.BET,psoInf+" AND "+psoSup),
				 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())); 
			}
	
	//Chargement des imputations ou lignes budgétaires pour CPMP et DMP
	public void chargeImputationCpmpDmp() {
		 listeImputations.clear();
		 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,fonction.getFonCod()));
			}
	
	public void filtreImputation() {
		listeImputations.clear();
		listeImputations = (List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()), 
				new WhereClause("LBG_NAT_CODE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));
	}
	
	//Affichege du modèle de DAO en modification
	public void affichageModele() {
		 //Affichage des modèles type de DAO
		 listeDao = ((List<VModeleDao>)iservice.getObjectsByColumn("VModeleDao",new ArrayList<String>(Arrays.asList("MDT_CODE")),
				 new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+updatePpm.getGpgId()))); 
		//Affichage du coût total de l'opération
		    coutOperation();
	}
	
	
	
	public void filtreImputationCpmp() {
		listeImputations.clear();
		listeImputations = (List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				new WhereClause("LIAE_FON_COD",Comparateur.EQ,fonction.getFonCod()), 
				new WhereClause("LBG_NAT_CODE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));
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
		 
		 //Afficher les Pgpm 
		 public void chargePgpm() {
			 listePgpm.clear();
			 listePgpm = (List<VPgpmFonction>)iservice.getObjectsByColumn("VPgpmFonction",new ArrayList<String>(Arrays.asList("GPG_ID")),
					 new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					 new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
					 new WhereClause("PLG_FON_COD",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));		 		 
		 }
		 
		 //Afficher les Pgspm 
		 public void chargePgspm() {
			 listePgspm.clear();
			 listePgspm = (List<VPgpmFonction>)iservice.getObjectsByColumn("VPgpmFonction",new ArrayList<String>(Arrays.asList("GPG_ID")),
					 new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					 new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
					 new WhereClause("PLG_FON_COD",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));		 		 
		 }
		 
		
		 
		 
		 //Afficher les Ppm dans la love
		 public void chargePpm(){
			 listePpm.clear();
			 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_ID")), 
					new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.EQ,"S1S"),
					new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
		}
		 
		 //Filtre les marchés en fonction du code Marché
		 public void filtreMarche() {
			 listeTypeMarches.clear();
			 listeTypeMarches = (List<TTypeMarche>) iservice.getObjectsByColumn("TTypeMarche", new ArrayList<String>(Arrays.asList("tymCode")),
						new WhereClause("TYM_CODE",WhereClause.Comparateur.LIKE,"%"+filtreTypeMarche+"%"));
		 }
		 
		 
		//Filtre les modes de Passtion en fonction du code Passation
		 public void filtreModePassation() {
			 listeModePassation.clear();
			 listeModePassation =(List<TModePassation>) iservice.getObjectsByColumn("TModePassation", new ArrayList<String>(Arrays.asList("mopCode")),
					 new WhereClause("MOP_CODE",WhereClause.Comparateur.LIKE,"%"+filtreModePassation+"%"));
			}
		 
		 
			//Debut cpmp
		 
		 //Afficher les Pgpm 
		 public void chargePgpmCpmpDmp() {
			 listePgpm.clear();
			 listePgpm = (List<VPgpmFonction>)iservice.getObjectsByColumnDesc("VPgpmFonction",new ArrayList<String>(Arrays.asList("GPG_ID")),
					 new WhereClause("PLG_FON_COD",Comparateur.EQ,fonction.getFonCod()));		 		 
		 }
		 
		 public void filtrePgpmCpmpDmp() {
			 listePgpm.clear();
			 listePgpm = (List<VPgpmFonction>)iservice.getObjectsByColumn("VPgpmFonction",new ArrayList<String>(Arrays.asList("GPG_ID")),
					 new WhereClause("PLG_FON_COD",Comparateur.EQ,fonction.getFonCod()),
					 new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.LIKE,"%"+filtreStructure+"%"));	 		 
		 }
		 
		 
		 public void chargeFonction() {
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
			
			
			
			
			
			public void onSelectMinisterePpm() {
				//planPass = new TPlanPassation();
				planPass.setTStructure(new TStructure(structure.getStrCode()));
				
				  recupStructure = new TStructure();
				  recupStructure.setStrCode(structure.getStrCode());
				  recupStructure.setStrLibelleCourt(structure.getStrLibelleCourt());
				  recupStructure.setStrLibelleLong(structure.getStrLibelleLong());
				  recupStructure.setStrEmail(structure.getStrEmail());
				
				//chargeFonction();
					}
			
			public void onSelectFonctionPpm() {
				
				 planPass.setTFonction(new TFonction(fonction.getFonCod()));
				 
				 recupFonction = new TFonction();
				 recupFonction.setFonCod(fonction.getFonCod());
				 recupFonction.setFonLibelle(fonction.getFonLibelle());
				 chargePgpmCpmpDmp();
				 chargeImputationCpmpDmp();
					}
			
			
			public void onSelectStructure() { 
				charge.setTStructure(new TStructure(structure.getStrCode()));
				
				recupstructure = new TStructure();
				recupstructure.setStrLibelleLong(structure.getStrLibelleLong());
				recupstructure.setStrCode(structure.getStrCode());
					}
			
			public void onSelectDetailPassation() { 
				charge.setTDetailPlanPassation(new TDetailPlanPassation(passation.getDppId()));
				
				recupPass = new TDetailPlanPassation();
				recupPass.setDppId(passation.getDppId());
				recupPass.setDppObjet(passation.getDppObjet());
					}
			
			//Méthode de création d'une charge 
		  	 @Transactional
			 public void creerCharge() throws IOException{
		  		//charge.setTStructure(new TStructure(structure.getStrCode()));
		        charge.setTTypeCharge(new TTypeCharge(typCharge));
		        charge.setTDetailPlanPassation(new TDetailPlanPassation(passation.getDppId()));
		        charge.setChrStatut("1");
		        iservice.addObject(charge);
		        //Chargement de la liste des charges
		  		chargeCharges();
		  		
		      
				 
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Charge créée avec succès!", "");
				 FacesContext.getCurrentInstance().addMessage(null, msg);
			 }
		  	 
		  	 
		  	//Méthode de création d'une charge 
		  	 @Transactional
			 public void creerStructure() throws IOException{ 
		  		newStr.setStrLibelleCourt(newStr.getStrLibelleLong());
		        iservice.addObject(newStr);
		        //Chargement des structures
		  		 chargeStructures();
				 
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Structure créée avec succès!", "");
				 FacesContext.getCurrentInstance().addMessage(null, msg);
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
				
				public void onSelectFonctionPpmDmp() {
					//planPass = new TPlanPassation();
					planPass.setTFonction(new TFonction(fonction.getFonCod()));
					 
					 recupFonction = new TFonction();
					 recupFonction.setFonCod(fonction.getFonCod());
					 recupFonction.setFonLibelle(fonction.getFonLibelle());
					 chargePgpmCpmpDmp();
					 chargeImputationCpmpDmp();
						}
				
				public void onSelectMinisterePpmDmp() {
					//planPass = new TPlanPassation();
					planPass.setTStructure(new TStructure(structure.getStrCode()));
					
					  recupStructure = new TStructure();
					  recupStructure.setStrCode(structure.getStrCode());
					  recupStructure.setStrLibelleCourt(structure.getStrLibelleCourt());
					  recupStructure.setStrLibelleLong(structure.getStrLibelleLong());
					  recupStructure.setStrEmail(structure.getStrEmail());
					  
					  //chargeFonctionDmp();
						}
			//Fin dmp
	  	 
		 
		
		 //Méthode Love
		 public void onSelectMarche() {
			 detailPass.setTTypeMarche(new TTypeMarche(marche.getTymCode()));

			
			 reucpMarche = new VTypeMarcheFils();
			 reucpMarche.setTymCode(marche.getTymCode());
			 reucpMarche.setTymLibelleCourt(marche.getTymLibelleCourt());
				}
		 
		 
		 public void onSelectPgpm() {
			 detailPass.setTDetailPlanGeneral(new TDetailPlanGeneral(pgpm.getGpgId()));
			 detailPass.setDppSourceFin(pgpm.getGpgLibFin());

			 recupPgpm = new VPgpmFonction();
			 recupPgpm.setGpgObjet(pgpm.getGpgObjet());
			 recupPgpm.setGpgId(pgpm.getGpgId());
			 recupPgpm.setGpgTypePlan(pgpm.getGpgTypePlan());
			 recupPgpm.setGpgCommentaire(pgpm.getGpgCommentaire());
			 recupPgpm.setGpgNumeroOrdre(pgpm.getGpgNumeroOrdre());
			 recupPgpm.setGpgDateSaisie(pgpm.getGpgDateSaisie());
			 recupPgpm.setGpgPartiePmePmi(pgpm.getGpgPartiePmePmi());
			 recupPgpm.setMopLibelleLong(pgpm.getMopLibelleLong());
			 recupPgpm.setTymLibelleCourt(pgpm.getTymLibelleCourt());
			 recupPgpm.setGpgTymCode(pgpm.getGpgTymCode());
			 recupPgpm.setTymTymCode(pgpm.getTymTymCode());
			 recupPgpm.setGpgMopCode(pgpm.getGpgMopCode());
			 recupPgpm.setGpgPartiePmePmi(pgpm.getGpgPartiePmePmi());
			 recupPgpm.setGpgLibFin(pgpm.getGpgLibFin());
			 
			 listeFinancementPgpm =(List<TFinancementPgpm>) iservice.getObjectsByColumn("TFinancementPgpm", new ArrayList<String>(Arrays.asList("FIP_ID")),
				     new WhereClause("FIP_GPG_ID",WhereClause.Comparateur.EQ,""+pgpm.getGpgId()));
			 if (!listeFinancementPgpm.isEmpty()) {
				  fipPgpm=listeFinancementPgpm.get(0);
				    }
			 
			 if(pgpm.getGpgMopCode().equalsIgnoreCase("AMI")) {
                //Activation de la liste des Ami et désactivation de l'autre
				 modeleAmi = true;
				 modeleDao = false;
	             //Affichage des modèles type AMI
				   listeAmi = ((List<VModeleAmi>)iservice.getObjectsByColumn("VModeleAmi",new ArrayList<String>(Arrays.asList("MDT_CODE")),
						 new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+pgpm.getGpgId())));
				   //Affichage du coût total de l'opération
				    coutOperation();
					//Récupération des lignes biudgétaires en fonction du mode de passation, par défaut charge les lignes du AC 
				  if(pgpm.getGpgTypePlan().equalsIgnoreCase("PS")) {
					  
					   if(pgpm.getGpgMopCode().equalsIgnoreCase("PSL")) {
							 chargeImputationPsl();
						   }else
						      if(pgpm.getGpgMopCode().equalsIgnoreCase("PSO")) {
								  chargeImputationPso();
							   }
				                 }else
					                 if(pgpm.getGpgTypePlan().equalsIgnoreCase("PN")) {
						                    chargeImputation();
					                  }
			             }else {
			        	//Activation de la liste des DAO type et désactivation de la liste des DAO 
						 modeleAmi = false;
						 modeleDao = true;
			    	      //Affichage des modèles type de DAO
						 listeDao = ((List<VModeleDao>)iservice.getObjectsByColumn("VModeleDao",new ArrayList<String>(Arrays.asList("MDT_CODE")),
								 new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+pgpm.getGpgId()))); 
						//Affichage du coût total de l'opération
						    coutOperation();
							//Récupération des lignes biudgétaires en fonction du mode de passation, par défaut charge les lignes du AC 
						  if(pgpm.getGpgTypePlan().equalsIgnoreCase("PS")) {
							  
							   if(pgpm.getGpgMopCode().equalsIgnoreCase("PSL")) {
									 chargeImputationPsl();
								   }else
								      if(pgpm.getGpgMopCode().equalsIgnoreCase("PSO")) {
										  chargeImputationPso();
									   }
						                 }else
							                 if(pgpm.getGpgTypePlan().equalsIgnoreCase("PN")) {
								                    chargeImputation();
							                  }
			                              } 
		                            }
		 
		 
		 
		 
		 //Methode OnSelect pour PGSPM
		 public void onSelectPgspm() {
			 detailPass.setTDetailPlanGeneral(new TDetailPlanGeneral(pgspm.getGpgId())); 

			 recupPgspm = new VPgpmFonction();
			 recupPgspm.setGpgObjet(pgspm.getGpgObjet());
			 recupPgspm.setGpgId(pgspm.getGpgId());
			 recupPgspm.setGpgTypePlan(pgspm.getGpgTypePlan());
			 recupPgspm.setGpgCommentaire(pgspm.getGpgCommentaire());
			 recupPgspm.setGpgNumeroOrdre(pgspm.getGpgNumeroOrdre());
			 recupPgspm.setGpgDateSaisie(pgspm.getGpgDateSaisie());
			 recupPgspm.setGpgPartiePmePmi(pgspm.getGpgPartiePmePmi());
			 recupPgspm.setMopLibelleLong(pgspm.getMopLibelleLong());
			 recupPgspm.setTymLibelleCourt(pgspm.getTymLibelleCourt());
			 recupPgspm.setGpgTymCode(pgspm.getGpgTymCode());
			 recupPgspm.setTymTymCode(pgspm.getTymTymCode());
			 recupPgspm.setGpgMopCode(pgspm.getGpgMopCode());
			 recupPgspm.setGpgPartiePmePmi(pgspm.getGpgPartiePmePmi());
			 
			 
			 
			 listeFinancementPgpm =(List<TFinancementPgpm>) iservice.getObjectsByColumn("TFinancementPgpm", new ArrayList<String>(Arrays.asList("FIP_ID")),
				     new WhereClause("FIP_GPG_ID",WhereClause.Comparateur.EQ,""+pgspm.getGpgId()));
			 if (!listeFinancementPgpm.isEmpty()) {
				  fipPgpm=listeFinancementPgpm.get(0);
				    }
			 
			             
			             if(pgspm.getGpgMopCode().equalsIgnoreCase("AMI")) {
			            	    modeleDao = false;
			            	    modeleAmi = false;
			                       }else {
			            	    //Désactivation des listes 
			            	    modeleDao = true;
			            	    modeleAmi = false;
			            	    //Affichage du modèle DAO type
			   				   listeDao = ((List<VModeleDao>)iservice.getObjectsByColumn("VModeleDao",new ArrayList<String>(Arrays.asList("MDT_CODE")),
			   				   new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+pgspm.getGpgId()))); 
			   			       //Affichage du montant total
			   			       coutOperation();       
			                 }
				     } 
		 
		 
		  
		 
		 public void onSelectPpm() {
			 charge.setTDetailPlanPassation(new TDetailPlanPassation(ppm.getDppId()));
			 
              recuPpm = new TDetailPlanPassation();
			  recuPpm.setDppObjet(ppm.getDppObjet());
			  recuPpm.setDppId(ppm.getDppId());
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
		 
		 public void onSelectModePassation() {
			 detailPass.setTModePassation(new TModePassation(modePassation.getMopCode()));
			
			 recupModePassation = new TModePassation();
			 recupModePassation.setMopLibelleLong(modePassation.getMopLibelleLong());
			 recupModePassation.setMopCode(modePassation.getMopCode());
				}
		 
		//Fin Méthode Love 
		 
	 
		//Méthode de création d'un plan de Passtion par l'Autorité Contractante
	  	 @Transactional
		 public void creerPlanPassation() throws IOException{
	  		 planPass.setTGestion(new TGestion(gesCode));
	  		 planPass.setTFonction(userController.getSlctd().getTFonction());
	  		 planPass.setTStructure(userController.getSlctd().getTFonction().getTStructure());
	  		 iservice.addObject(planPass);

	      	 userController.setTexteMsg("Plan de Passation crée avec succès!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
		 }
	  	 
	  	 
	 	//Méthode de création d'un plan de Passtion par la CPMP ou le DMP
	  	 @Transactional
		 public void creerPlanPassationCpmpDmp() throws IOException{
	  		 planPass.setTGestion(new TGestion(gesCode));
	  		 planPass.setTFonction(recupFonction);
	  		 planPass.setTStructure(userController.getSlctd().getTFonction().getTStructure());
	  		 iservice.addObject(planPass);

	      	 userController.setTexteMsg("Plan de Passation crée avec succès!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
		 }
	  	 
	  	 
	  	//Recupertation de la date generée
		 public void recupDateGenere() {
		    			listeDateGenere= (List<VGenerationDate>) iservice.getObjectsByColumn("VGenerationDate", new ArrayList<String>(Arrays.asList("DPP_ID")),
		    					 new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+detailPass.getDppId()));
		    			if (!listeDateGenere.isEmpty()) {
		    				geneDate=listeDateGenere.get(0); 
		    			}
		 }
	  	 
	  	 
	  	//Méthode de création d'un ppm par le AC
	  	 @Transactional
	  	 public void creerDetailPassation()throws IOException{
	  		 
	  		if(fipPgpm.getFipId() > 0 ) {
	  			
	  			 if(detailPass.getDppStructureConduc().equalsIgnoreCase("")|| "".equals(detailPass.getDppStructureConduc()) || detailPass.getDppStructureBenefi().equalsIgnoreCase("") || "".equals(detailPass.getDppStructureBenefi()) || tydCode.equalsIgnoreCase("") 
	  					 || detailPass.getDppDateAvisAoPublication().equals(null) || pgpm.getGpgMopCode().equalsIgnoreCase("") ||"".equals(pgpm.getGpgMopCode()) || pgpm.getGpgTymCode().equalsIgnoreCase("") || "".equals(pgpm.getGpgTymCode()) || ligne.getLbgCode().equalsIgnoreCase("") || "".equals(ligne.getLbgCode())) {
		  			   //Message d'erreur
		  			   FacesContext.getCurrentInstance().addMessage(null,
		  	   	       new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir tous les champs ainsi que l'imputation budgétaire", "")); 
		  		    }else {
		  		    	listPlan = (List<TPlanPassation>) iservice.getObjectsByColumn("TPlanPassation", new ArrayList<String>(Arrays.asList("PLP_ID")),
		 	 			       new WhereClause("PLP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
		 	 			       new WhereClause("PLP_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
		 					   new WhereClause("PLP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
		 	 	  if (!listPlan.isEmpty()) {
		 	 		  planPass= listPlan.get(0);
		 	 		  
		 	 		  if(detailPass.getDppId()>0) {
		 	 			  
		 	 			 detailPass.setTTypeMarche(new TTypeMarche(pgpm.getGpgTymCode()));
			 	 		 detailPass.setTStructure(new TStructure(planPass.getTStructure().getStrCode()));
			 	  		 detailPass.setTModePassation(new TModePassation(pgpm.getGpgMopCode()));
			 	  		 detailPass.setDppPartiePmePmi(pgpm.getGpgPartiePmePmi());
			 	  		 detailPass.setTDetailPlanGeneral(new TDetailPlanGeneral(pgpm.getGpgId()));
			 	  		 detailPass.setTModeleDacType(new TModeleDacType(tydCode));
			 	  		 detailPass.setDppSourceFin(pgpm.getGpgLibFin());
			 	  		 detailPass.setTPlanPassation(planPass);
			 	  		 detailPass.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
			 	  		 detailPass.setDppTypePlan("PN");
			 	  		 detailPass.setTStructure(userController.getSlctd().getTFonction().getTStructure());
			 	  		 detailPass.setDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
			 	  		 detailPass.setDppDateSaisie(Calendar.getInstance().getTime());
			 	  		 detailPass.setTStatut(new TStatut("S1S"));
			 	  		 detailPass.setDppStatutRetour("0");
			 	  		 detailPass.setDppStatutDao("N");
			 	  		 iservice.updateObject(detailPass);
			 	  		
			 	  		TAffichagePpm affichagePpm = new TAffichagePpm();
			 	  		affichagePpm.setAffDppId(detailPass.getDppId());
			 	  		affichagePpm.setTStructure(new TStructure(detailPass.getTStructure().getStrCode()));
			 	  		affichagePpm.setTTypeMarche(new TTypeMarche(detailPass.getTTypeMarche().getTymCode()));
			 	  		affichagePpm.setTModePassation(new TModePassation(detailPass.getTModePassation().getMopCode()));
			 	  		affichagePpm.setTLBudgets(new TLBudgets(detailPass.getTLBudgets().getLbgCode()));
			 	  		affichagePpm.setTDetailPlanGeneral(new TDetailPlanGeneral(detailPass.getTDetailPlanGeneral().getGpgId()));
			 	  		affichagePpm.setAffDppPartiePmePmi(detailPass.getDppPartiePmePmi());
			 	  		affichagePpm.setTPlanPassation(planPass);
			 	  		affichagePpm.setTStatut(new TStatut(detailPass.getTStatut().getStaCode()));
			 	  		affichagePpm.setTFonction(userController.getSlctd().getTFonction());
			 	  		affichagePpm.setAffDppTypePlan("PN");
			 	  		affichagePpm.setAffDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
			 	  		affichagePpm.setTStructure(userController.getSlctd().getTFonction().getTStructure());
			 	  		affichagePpm.setAffDppStatutRetour(detailPass.getDppStatutRetour());
			 	  		affichagePpm.setAffDppObjet(detailPass.getDppObjet());
			 	  		affichagePpm.setAffDppDate(detailPass.getDppDate());
			 	  		affichagePpm.setAffDppNumeroOrdre(detailPass.getDppNumeroOrdre());
			 	  		affichagePpm.setAffDppSourceFin(detailPass.getDppSourceFin());
			 	  		affichagePpm.setAffDppCode(detailPass.getDppCode());
			 	  		affichagePpm.setAffDppDateAttApproBail(detailPass.getDppDateAttApproBail());
			 	  		affichagePpm.setAffDppDateAttApprobDmp(detailPass.getDppDateAttApprobDmp());
			 	  		affichagePpm.setAffDppDateAvisAoPublicat(detailPass.getDppDateAvisAoPublication());
			 	  		affichagePpm.setAffDppDateDaoApprobBail(detailPass.getDppDateDaoApprobBail());
			 	  		affichagePpm.setAffDppDateDaoApprobDmp(detailPass.getDppDateDaoApprobDmp());
			 	  		affichagePpm.setAffDppDateDaoTrans(detailPass.getDppDateDaoTrans());
			 	  		affichagePpm.setAffDppDateElabRapport(detailPass.getDppDateElabRapport());
			 	  		affichagePpm.setAffDppDateExecDebut(detailPass.getDppDateExecDebut());
			 	  		affichagePpm.setAffDppDateExecFin(detailPass.getDppDateExecFin());
			 	  		affichagePpm.setAffDppDateJugementOffre(detailPass.getDppDateJugementOffre());
			 	  		affichagePpm.setAffDppDateMarcheApprob(detailPass.getDppDateMarcheApprob());
			 	  		affichagePpm.setAffDppDateNegociation(detailPass.getDppDateNegociation());
			 	  		affichagePpm.setAffDppDateOuvertOf(detailPass.getDppDateOuvertOf());
			 	  		affichagePpm.setAffDppDateOuvertOt(detailPass.getDppDateOuvertOt());
			 	  		affichagePpm.setAffDppDateSignatAc(detailPass.getDppDateSignatAc());
			 	  		affichagePpm.setAffDppApprobAno(detailPass.getDppApprobAno());
			 	  		affichagePpm.setAffDppDateSignatAttrib(detailPass.getDppDateSignatAttrib());
			 	  		affichagePpm.setAffDppDateSaisie(detailPass.getDppDateSaisie());
			 	  		affichagePpm.setAffDppStrConduc(detailPass.getDppStructureConduc());
			 	  		affichagePpm.setAffDppStrBenefi(detailPass.getDppStructureBenefi());
			 	  		affichagePpm.setAffDppStatutDao(detailPass.getDppStatutDao());
			 	  		affichagePpm.setAffDppPieceDao(detailPass.getTModeleDacType().getMdtCode());
			 	  		affichagePpm.setAffDppApprobAno(detailPass.getDppApprobAno());
			 	  		affichagePpm.setAffDppSourceFin(detailPass.getDppSourceFin());
			 	  		iservice.updateObject(affichagePpm);
			 	  		
			 	  		String search = detailPass.getDppObjet()+""+detailPass.getDppSourceFin()+""+detailPass.getDppTypePlan()+""+detailPass.getTModePassation().getMopCode()+""+detailPass.getDppStructureBenefi()+""+detailPass.getDppStructureConduc()+""+detailPass.getDppSourceFin();
						String rechercheAll = search.replace("null","");
						
						
				      			  
				      
				      			//Insertion dans T_Financement_PPM
			    				  for(TFinancementPgpm fin: listeFinancementPgpm) {
					      		        TFinancementPpm newFinancement = new TFinancementPpm();
					      		        newFinancement.setTDetailPlanPassation(detailPass);
					      		        newFinancement.setFppCommentaire(fin.getFipCommentaire());
					      		        newFinancement.setFppMontantCfa(fin.getFipMontantCfa());
					      		        newFinancement.setFppMontantDevise(fin.getFipMontantDevise());
					      		        newFinancement.setFppPartTresor(fin.getFipTresor());
					      		        newFinancement.setTBailleur(new TBailleur(fin.getTBailleur().getBaiCode()));	
					      		        newFinancement.setTSourceFinancement(new TSourceFinancement(fin.getTSourceFinancement().getSouCode()));
					      		        newFinancement.setTDevise(new TDevise(fin.getTDevise().getDevCode()));
					      				iservice.updateObject(newFinancement);
			    				    }	
			 		     recupDateGenere();
			 			chargeData();
			 			boutonEdit =true; 
			 			boutonEditPspm =false;
			 			//Actualisation du Tableau de Bord
			 			tableauBordController.chargeDataPpm();
			 			
			 			userController.setTexteMsg("Opération(s) enregistrée(s) avec succès!");
			 			userController.setRenderMsg(true);
			 			userController.setSevrityMsg("success");
			 	 		  
		 	 			  
		 	 		  }else
		 	 		  {
		 	 			 detailPass.setTTypeMarche(new TTypeMarche(pgpm.getGpgTymCode()));
			 	 		 detailPass.setTStructure(new TStructure(planPass.getTStructure().getStrCode()));
			 	  		 detailPass.setTModePassation(new TModePassation(pgpm.getGpgMopCode()));
			 	  		 detailPass.setDppPartiePmePmi(pgpm.getGpgPartiePmePmi());
			 	  		 detailPass.setTDetailPlanGeneral(new TDetailPlanGeneral(pgpm.getGpgId()));
			 	  		 detailPass.setTModeleDacType(new TModeleDacType(tydCode));
			 	  		 detailPass.setDppSourceFin(pgpm.getGpgLibFin());
			 	  		 detailPass.setTPlanPassation(planPass);
			 	  		 detailPass.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
			 	  		 detailPass.setDppTypePlan("PN");
			 	  		 detailPass.setTStructure(userController.getSlctd().getTFonction().getTStructure());
			 	  		 detailPass.setDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
			 	  		 detailPass.setDppDateSaisie(Calendar.getInstance().getTime());
			 	  		 detailPass.setTStatut(new TStatut("S1S"));
			 	  		 detailPass.setDppStatutRetour("0");
			 	  		 detailPass.setDppStatutDao("N");
			 	  		 iservice.addObject(detailPass);
			 	  		
			 	  		TAffichagePpm affichagePpm = new TAffichagePpm();
			 	  		affichagePpm.setAffDppId(detailPass.getDppId());
			 	  		affichagePpm.setTStructure(new TStructure(detailPass.getTStructure().getStrCode()));
			 	  		affichagePpm.setTTypeMarche(new TTypeMarche(detailPass.getTTypeMarche().getTymCode()));
			 	  		affichagePpm.setTModePassation(new TModePassation(detailPass.getTModePassation().getMopCode()));
			 	  		affichagePpm.setTLBudgets(new TLBudgets(detailPass.getTLBudgets().getLbgCode()));
			 	  		affichagePpm.setTDetailPlanGeneral(new TDetailPlanGeneral(detailPass.getTDetailPlanGeneral().getGpgId()));
			 	  		affichagePpm.setAffDppPartiePmePmi(detailPass.getDppPartiePmePmi());
			 	  		affichagePpm.setTPlanPassation(planPass);
			 	  		affichagePpm.setTStatut(new TStatut(detailPass.getTStatut().getStaCode()));
			 	  		affichagePpm.setTFonction(userController.getSlctd().getTFonction());
			 	  		affichagePpm.setAffDppTypePlan("PN");
			 	  		affichagePpm.setAffDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
			 	  		affichagePpm.setTStructure(userController.getSlctd().getTFonction().getTStructure());
			 	  		affichagePpm.setAffDppStatutRetour(detailPass.getDppStatutRetour());
			 	  		affichagePpm.setAffDppObjet(detailPass.getDppObjet());
			 	  		affichagePpm.setAffDppDate(detailPass.getDppDate());
			 	  		affichagePpm.setAffDppNumeroOrdre(detailPass.getDppNumeroOrdre());
			 	  		affichagePpm.setAffDppSourceFin(detailPass.getDppSourceFin());
			 	  		affichagePpm.setAffDppCode(detailPass.getDppCode());
			 	  		affichagePpm.setAffDppDateAttApproBail(detailPass.getDppDateAttApproBail());
			 	  		affichagePpm.setAffDppDateAttApprobDmp(detailPass.getDppDateAttApprobDmp());
			 	  		affichagePpm.setAffDppDateAvisAoPublicat(detailPass.getDppDateAvisAoPublication());
			 	  		affichagePpm.setAffDppDateDaoApprobBail(detailPass.getDppDateDaoApprobBail());
			 	  		affichagePpm.setAffDppDateDaoApprobDmp(detailPass.getDppDateDaoApprobDmp());
			 	  		affichagePpm.setAffDppDateDaoTrans(detailPass.getDppDateDaoTrans());
			 	  		affichagePpm.setAffDppDateElabRapport(detailPass.getDppDateElabRapport());
			 	  		affichagePpm.setAffDppDateExecDebut(detailPass.getDppDateExecDebut());
			 	  		affichagePpm.setAffDppDateExecFin(detailPass.getDppDateExecFin());
			 	  		affichagePpm.setAffDppDateJugementOffre(detailPass.getDppDateJugementOffre());
			 	  		affichagePpm.setAffDppDateMarcheApprob(detailPass.getDppDateMarcheApprob());
			 	  		affichagePpm.setAffDppDateNegociation(detailPass.getDppDateNegociation());
			 	  		affichagePpm.setAffDppDateOuvertOf(detailPass.getDppDateOuvertOf());
			 	  		affichagePpm.setAffDppDateOuvertOt(detailPass.getDppDateOuvertOt());
			 	  		affichagePpm.setAffDppDateSignatAc(detailPass.getDppDateSignatAc());
			 	  		affichagePpm.setAffDppApprobAno(detailPass.getDppApprobAno());
			 	  		affichagePpm.setAffDppDateSignatAttrib(detailPass.getDppDateSignatAttrib());
			 	  		affichagePpm.setAffDppDateSaisie(detailPass.getDppDateSaisie());
			 	  		affichagePpm.setAffDppStrConduc(detailPass.getDppStructureConduc());
			 	  		affichagePpm.setAffDppStrBenefi(detailPass.getDppStructureBenefi());
			 	  		affichagePpm.setAffDppStatutDao(detailPass.getDppStatutDao());
			 	  		affichagePpm.setAffDppPieceDao(detailPass.getTModeleDacType().getMdtCode());
			 	  		affichagePpm.setAffDppApprobAno(detailPass.getDppApprobAno());
			 	  		affichagePpm.setAffDppSourceFin(detailPass.getDppSourceFin());
			 	  		iservice.addObject(affichagePpm);
			 	  		
			 	  		String search = detailPass.getDppObjet()+""+detailPass.getDppSourceFin()+""+detailPass.getDppTypePlan()+""+detailPass.getTModePassation().getMopCode()+""+detailPass.getDppStructureBenefi()+""+detailPass.getDppStructureConduc()+""+detailPass.getDppSourceFin();
						String rechercheAll = search.replace("null","");
						
						
				      			  
				      
				      			//Insertion dans T_Financement_PPM
			    				  for(TFinancementPgpm fin: listeFinancementPgpm) {
					      		        TFinancementPpm newFinancement = new TFinancementPpm();
					      		        newFinancement.setTDetailPlanPassation(detailPass);
					      		        newFinancement.setFppCommentaire(fin.getFipCommentaire());
					      		        newFinancement.setFppMontantCfa(fin.getFipMontantCfa());
					      		        newFinancement.setFppMontantDevise(fin.getFipMontantDevise());
					      		        newFinancement.setFppPartTresor(fin.getFipTresor());
					      		        newFinancement.setTBailleur(new TBailleur(fin.getTBailleur().getBaiCode()));	
					      		        newFinancement.setTSourceFinancement(new TSourceFinancement(fin.getTSourceFinancement().getSouCode()));
					      		        newFinancement.setTDevise(new TDevise(fin.getTDevise().getDevCode()));
					      				iservice.addObject(newFinancement);
			    				    }	

			 	  		
			 	  	   //Insertion de chaque ligne dans T_HistoPlanPassation avec le statut correspondant
			 			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
			 		    TStatut statuts = new TStatut();
			 		      if(!LS.isEmpty()) statuts = LS.get(0);
			 		  //Historisation des Plans Généraux
			 		     THistoPlanPassation histoPass = new THistoPlanPassation();
			 		     histoPass.setHppDate(Calendar.getInstance().getTime());
			 		     histoPass.setHppMotif("PPM enregistré par le AC");
			 		     histoPass.setTStatut(statuts);
			 		     histoPass.setTDetailPlanPassation(detailPass);
			 		     histoPass.setTFonction(userController.getSlctd().getTFonction());
			 		     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
			 		     iservice.addObject(histoPass);
			 		     recupDateGenere();
			 			chargeData();
			 			boutonEdit =true; 
			 			boutonEditPspm =false;
			 			
			 			//Actualisation du Tableau de Bord
			 			tableauBordController.chargeDataPpm();
			 			
			 			userController.setTexteMsg("Opération(s) enregistrée(s) avec succès!");
			 			userController.setRenderMsg(true);
			 			userController.setSevrityMsg("success");
			 	 		   
		 	 		  }
		 	 		
		 	 	  }else {
		 	 		     planPass.setTGestion(new TGestion(gesCode));
		 	  		     planPass.setTFonction(userController.getSlctd().getTFonction());
		 	  		     planPass.setTStructure(userController.getSlctd().getTFonction().getTStructure());
		 	  		     iservice.addObject(planPass);
		 	  		     
		 	  		     detailPass.setTTypeMarche(new TTypeMarche(pgpm.getGpgTymCode()));
		 	  		     detailPass.setTStructure(new TStructure(planPass.getTStructure().getStrCode()));
		 		  		 detailPass.setTModePassation(new TModePassation(pgpm.getGpgMopCode()));
		 		  		 detailPass.setDppPartiePmePmi(pgpm.getGpgPartiePmePmi());
		 		  		 detailPass.setTDetailPlanGeneral(new TDetailPlanGeneral(pgpm.getGpgId()));
		 		  		 detailPass.setTModeleDacType(new TModeleDacType(tydCode));
		 		  		 detailPass.setTPlanPassation(planPass);
		 		  		 detailPass.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
		 		  		 detailPass.setDppTypePlan("PN");
		 		  		 detailPass.setTStructure(userController.getSlctd().getTFonction().getTStructure());
		 		  		 detailPass.setDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
		 		  		 detailPass.setDppDateSaisie(Calendar.getInstance().getTime());
		 		  		 detailPass.setTStatut(new TStatut("S1S"));
		 		  		 detailPass.setDppStatutRetour("0");
		 		  		 detailPass.setDppStatutDao("N");
		 		  		 iservice.addObject(detailPass);
		 		  		 
		 		  		 
		 		  		TAffichagePpm affichagePpm = new TAffichagePpm();
		 		  		affichagePpm.setAffDppId(detailPass.getDppId());
		 		  		affichagePpm.setTTypeMarche(new TTypeMarche(detailPass.getTTypeMarche().getTymCode()));
		 		  		affichagePpm.setTModePassation(new TModePassation(detailPass.getTModePassation().getMopCode()));
		 		  		affichagePpm.setTLBudgets(new TLBudgets(detailPass.getTLBudgets().getLbgCode()));
		 		  		affichagePpm.setTDetailPlanGeneral(new TDetailPlanGeneral(detailPass.getTDetailPlanGeneral().getGpgId()));
		 		  		affichagePpm.setTStructure(new TStructure(detailPass.getTStructure().getStrCode()));
		 		  		affichagePpm.setAffDppPartiePmePmi(detailPass.getDppPartiePmePmi());
		 		  		affichagePpm.setTPlanPassation(planPass);
		 		  		affichagePpm.setTStatut(new TStatut(detailPass.getTStatut().getStaCode()));
		 		  		affichagePpm.setTFonction(userController.getSlctd().getTFonction());
		 		  		affichagePpm.setAffDppTypePlan("PN");
		 		  		affichagePpm.setAffDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
		 		  		affichagePpm.setTStructure(userController.getSlctd().getTFonction().getTStructure());
		 		  		affichagePpm.setAffDppStatutRetour(detailPass.getDppStatutRetour());
		 		  		affichagePpm.setAffDppObjet(detailPass.getDppObjet());
		 		  		affichagePpm.setAffDppDate(detailPass.getDppDate());
		 		  		affichagePpm.setAffDppNumeroOrdre(detailPass.getDppNumeroOrdre());
		 		  		affichagePpm.setAffDppSourceFin(detailPass.getDppSourceFin());
		 		  		affichagePpm.setAffDppCode(detailPass.getDppCode());
		 		  		affichagePpm.setAffDppDateAttApproBail(detailPass.getDppDateAttApproBail());
		 		  		affichagePpm.setAffDppDateAttApprobDmp(detailPass.getDppDateAttApprobDmp());
		 		  		affichagePpm.setAffDppDateAvisAoPublicat(detailPass.getDppDateAvisAoPublication());
		 		  		affichagePpm.setAffDppDateDaoApprobBail(detailPass.getDppDateDaoApprobBail());
		 		  		affichagePpm.setAffDppDateDaoApprobDmp(detailPass.getDppDateDaoApprobDmp());
		 		  		affichagePpm.setAffDppDateDaoTrans(detailPass.getDppDateDaoTrans());
		 		  		affichagePpm.setAffDppDateElabRapport(detailPass.getDppDateElabRapport());
		 		  		affichagePpm.setAffDppDateExecDebut(detailPass.getDppDateExecDebut());
		 		  		affichagePpm.setAffDppDateExecFin(detailPass.getDppDateExecFin());
		 		  		affichagePpm.setAffDppDateJugementOffre(detailPass.getDppDateJugementOffre());
		 		  		affichagePpm.setAffDppDateMarcheApprob(detailPass.getDppDateMarcheApprob());
		 		  		affichagePpm.setAffDppDateNegociation(detailPass.getDppDateNegociation());
		 		  		affichagePpm.setAffDppDateOuvertOf(detailPass.getDppDateOuvertOf());
		 		  		affichagePpm.setAffDppDateOuvertOt(detailPass.getDppDateOuvertOt());
		 		  		affichagePpm.setAffDppDateSignatAc(detailPass.getDppDateSignatAc());
		 		  		affichagePpm.setAffDppDateSignatAttrib(detailPass.getDppDateSignatAttrib());
		 		  		affichagePpm.setAffDppDateSaisie(detailPass.getDppDateSaisie());
		 		  		affichagePpm.setAffDppStrConduc(detailPass.getDppStructureConduc());
		 		  		affichagePpm.setAffDppStrBenefi(detailPass.getDppStructureBenefi());
		 		  		affichagePpm.setAffDppStatutDao(detailPass.getDppStatutDao());
		 		  		affichagePpm.setAffDppPieceDao(detailPass.getTModeleDacType().getMdtCode());
		 		  		affichagePpm.setAffDppApprobAno(detailPass.getDppApprobAno());
		 		  		iservice.addObject(affichagePpm);
		 		  		
		 		  		String search = detailPass.getDppObjet()+""+detailPass.getDppSourceFin()+""+detailPass.getDppTypePlan()+""+detailPass.getTModePassation().getMopCode()+""+detailPass.getDppStructureBenefi()+""+detailPass.getDppStructureConduc();
						String rechercheAll = search.replace("null","");
					
		 		  		
		 		  		
		 		  		
		 		  		//Insertion dans T_Financement_PPM
				    				  for(TFinancementPgpm fin: listeFinancementPgpm) {
						      		        TFinancementPpm newFinancement = new TFinancementPpm();
						      		        newFinancement.setTDetailPlanPassation(detailPass);
						      		        newFinancement.setFppCommentaire(fin.getFipCommentaire());
						      		        newFinancement.setFppMontantCfa(fin.getFipMontantCfa());
						      		        newFinancement.setFppMontantDevise(fin.getFipMontantDevise());
						      		        newFinancement.setFppPartTresor(fin.getFipTresor());
						      		        newFinancement.setTBailleur(new TBailleur(fin.getTBailleur().getBaiCode()));	
						      		        newFinancement.setTSourceFinancement(new TSourceFinancement(fin.getTSourceFinancement().getSouCode()));
						      		        newFinancement.setTDevise(new TDevise(fin.getTDevise().getDevCode()));
						      				iservice.addObject(newFinancement);
				    				    }	
				      	
				   
		 		  		
		 		  	   //Insertion de chaque ligne dans T_HistoPlanPassation avec le statut correspondant
		 				List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
		 			    TStatut statuts = new TStatut();
		 			      if(!LS.isEmpty()) statuts = LS.get(0);
		 			  //Historisation des Plans Généraux
		 			     THistoPlanPassation histoPass = new THistoPlanPassation();
		 			     histoPass.setHppDate(Calendar.getInstance().getTime());
		 			     histoPass.setHppMotif("PPM enregistré par le AC");
		 			     histoPass.setTStatut(statuts);
		 			     histoPass.setTDetailPlanPassation(detailPass);
		 			     histoPass.setTFonction(userController.getSlctd().getTFonction());
		 			     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
		 			     iservice.addObject(histoPass);
		 			   recupDateGenere();
		 				chargeData();
		 				boutonEdit =true;
		 				boutonEditPspm =false;
		 				controleController.btn_creerDetailPpm =true;
		 				//controleController.btn_maj_datePpm = true;
			 			//controleController.btn_creerDetailPspmDmp=false;
		 				
		 				//Actualisation du Tableau de Bord
		 				tableauBordController.chargeDataPpm();
		 				
		 				userController.setTexteMsg("Opération(s) enregistrée(s) avec succès!");
		 				userController.setRenderMsg(true);
		 				userController.setSevrityMsg("success");
		 	 	         }
		  		    }
	  			
	  		  }else {
	  			 //Message d'erreur
	  			   FacesContext.getCurrentInstance().addMessage(null,
	  	   	       new FacesMessage(FacesMessage.SEVERITY_ERROR, "Votre PGPM n'a pas de financement", "")); 
	  		}

	  }
	  	 
	  	 
	  	 public void majDate() {
				     iservice.updateObject(datePpm);
				     boutonEdit =true;
				     
				     controleController.btn_creerDetailPpm =true;
					 controleController.btn_maj_datePpm = true;
				     
				     userController.setTexteMsg("Opération(s) enregistrée(s) avec succès!");
					 userController.setRenderMsg(true);
					 userController.setSevrityMsg("success");
	  	   }
	  	
	  	 
	  	 
	  	//Methode de récupération de t_detail_plan_passation dans t_affichage_ppm
		 public void editForm() {
		    			listUpdate= (List<VUpdatePpm>) iservice.getObjectsByColumn("VUpdatePpm", new ArrayList<String>(Arrays.asList("DPP_ID")),
		    					 new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
		    			if (!listUpdate.isEmpty()) {
		    				updatePpm=listUpdate.get(0); 
		    				affichageModele();
		    			}
		      }
		 
		 //Afficher les financements du projet ou pgpm selectionné
		 public void chargeFinancementUpdate() {
			 listeFinancement.clear();
			 listeFinancement = ((List<TFinancementPpm>)iservice.getObjectsByColumn("TFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
						 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+slctdTd.getDppId())));
			 coutOperation();
		 }
		 
		 
		 
    	 //suppression de financement update
		 public void removeFinancementUpdate() {
			 System.out.print("+-------------+ "+getSelectFinance().getFppId());
			 try {
				 iservice.deleteObject(getSelectFinance());
					chargeFinancementUpdate();
					coutOperation();
					userController.setTexteMsg("Suppression effectuée avec succès !");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");

			 } catch (org.hibernate.exception.ConstraintViolationException e) {
				 userController.setTexteMsg("Impossible de supprimer l'Opérateur !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("danger");	 
			 }
		 }
		 
		 
		 
	  	 
	  	 
	  	
	  	 
	  	//Méthode de création d'un ppm par le CPMP et le DMP
	  	 @Transactional
	  	 public void creerDetailPassationCpmpDmp()throws IOException{
	  		 detailPass.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
	  		 detailPass.setTModePassation(new TModePassation(modePassation.getMopCode()));
	  		 detailPass.setTDetailPlanGeneral(new TDetailPlanGeneral(pgpm.getGpgId()));
	  		 detailPass.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
	  		 detailPass.setDppTypePlan("PN");
	  		 detailPass.setTStructure(recupStructure);
	  		 detailPass.setDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
	  		 detailPass.setDppDateSaisie(Calendar.getInstance().getTime());
	  		 detailPass.setTStatut(new TStatut("S1S"));
	  		 detailPass.setDppStatutRetour("0");
	  		 detailPass.setDppStatutDao("N");
	  		 iservice.addObject(detailPass);
	  		
	  		TAffichagePpm affichagePpm = new TAffichagePpm();
	  		affichagePpm.setAffDppId(detailPass.getDppId());
	  		affichagePpm.setTTypeMarche(new TTypeMarche(detailPass.getTTypeMarche().getTymCode()));
	  		affichagePpm.setTModePassation(new TModePassation(detailPass.getTModePassation().getMopCode()));
	  		affichagePpm.setTLBudgets(new TLBudgets(detailPass.getTLBudgets().getLbgCode()));
	  		affichagePpm.setTDetailPlanGeneral(new TDetailPlanGeneral(detailPass.getTDetailPlanGeneral().getGpgId()));
	  		affichagePpm.setTStatut(new TStatut(detailPass.getTStatut().getStaCode()));
	  		affichagePpm.setTStructure(new TStructure(detailPass.getTStructure().getStrCode()));
	  		affichagePpm.setTFonction(recupFonction);
	  		affichagePpm.setAffDppTypePlan("PN");
	  		affichagePpm.setAffDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
	  		affichagePpm.setTStructure(recupStructure);
	  		affichagePpm.setAffDppStatutRetour(detailPass.getDppStatutRetour());
	  		affichagePpm.setAffDppObjet(detailPass.getDppObjet());
	  		affichagePpm.setAffDppDate(detailPass.getDppDate());
	  		affichagePpm.setAffDppNumeroOrdre(detailPass.getDppNumeroOrdre());
	  		affichagePpm.setAffDppSourceFin(detailPass.getDppSourceFin());
	  		affichagePpm.setAffDppCode(detailPass.getDppCode());
	  		affichagePpm.setAffDppDateAttApproBail(detailPass.getDppDateAttApproBail());
	  		affichagePpm.setAffDppDateAttApprobDmp(detailPass.getDppDateAttApprobDmp());
	  		affichagePpm.setAffDppDateAvisAoPublicat(detailPass.getDppDateAvisAoPublication());
	  		affichagePpm.setAffDppDateDaoApprobBail(detailPass.getDppDateDaoApprobBail());
	  		affichagePpm.setAffDppDateDaoApprobDmp(detailPass.getDppDateDaoApprobDmp());
	  		affichagePpm.setAffDppDateDaoTrans(detailPass.getDppDateDaoTrans());
	  		affichagePpm.setAffDppDateElabRapport(detailPass.getDppDateElabRapport());
	  		affichagePpm.setAffDppDateExecDebut(detailPass.getDppDateExecDebut());
	  		affichagePpm.setAffDppDateExecFin(detailPass.getDppDateExecFin());
	  		affichagePpm.setAffDppDateJugementOffre(detailPass.getDppDateJugementOffre());
	  		affichagePpm.setAffDppDateMarcheApprob(detailPass.getDppDateMarcheApprob());
	  		affichagePpm.setAffDppDateNegociation(detailPass.getDppDateNegociation());
	  		affichagePpm.setAffDppDateOuvertOf(detailPass.getDppDateOuvertOf());
	  		affichagePpm.setAffDppDateOuvertOt(detailPass.getDppDateOuvertOt());
	  		affichagePpm.setAffDppDateSignatAc(detailPass.getDppDateSignatAc());
	  		affichagePpm.setAffDppDateSignatAttrib(detailPass.getDppDateSignatAttrib());
	  		affichagePpm.setAffDppDateSaisie(detailPass.getDppDateSaisie());
	  		affichagePpm.setAffDppStatutDao(detailPass.getDppStatutDao());
	  		iservice.addObject(affichagePpm);
	  		
	  		if(fipPgpm.getFipId() > 0 ) {
	  		TFinancementPpm newFinancement = new TFinancementPpm();
	  		newFinancement.setTBailleur(new TBailleur(fipPgpm.getTBailleur().getBaiCode()));
	  		newFinancement.setTDetailPlanPassation(detailPass);
	  		newFinancement.setTSourceFinancement(new TSourceFinancement(fipPgpm.getTSourceFinancement().getSouCode()));
	  		newFinancement.setTDevise(new TDevise(fipPgpm.getTDevise().getDevCode()));
	  		newFinancement.setFppMontantDevise(fipPgpm.getFipMontantDevise());
	  		newFinancement.setFppMontantCfa(fipPgpm.getFipMontantCfa());
	  		iservice.addObject(newFinancement);
	  		         }
	  	      //Insertion de chaque ligne dans T_adep_log avec le statut correspondant
	  			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
	  		    TStatut statuts = new TStatut();
	  		      if(!LS.isEmpty()) statuts = LS.get(0);
	  		  //Historisation des Plans Généraux
	  		     THistoPlanPassation histoPass = new THistoPlanPassation();
	  		     histoPass.setHppDate(Calendar.getInstance().getTime());
	  		     histoPass.setHppMotif("PPM enregistré par"+userController.getSlctd().getTFonction().getFonCod());
	  		     histoPass.setTStatut(statuts);
	  		     histoPass.setTDetailPlanPassation(detailPass);
	  		     histoPass.setTFonction(userController.getSlctd().getTFonction());
	  		     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
	  		     iservice.addObject(histoPass);
	  			
	  			chargeData();
	  			
	  			//Activation du bouton d'édition du ppm et désactivation de celui du pspm
	  			boutonEdit =true;
	  			boutonEditPspm = false;
	  			
	  			//Actualisation du Tableau de Bord
	  			tableauBordController.chargeDataPpmPspm();
	  			//Message de confirmation
	  			userController.setTexteMsg("Opération enregistrée avec succès!");
	  			userController.setRenderMsg(true);
	  			userController.setSevrityMsg("success");
	  	 }
	  	 
	   	//Méthode de création d'un ppm par le CPMP et le DMP
	  	 @Transactional
	  	 public void creerDetailPspmCpmpDmp()throws IOException{
	  		 detailPass.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
	  		 detailPass.setTModePassation(new TModePassation(modePassation.getMopCode()));
	  		 detailPass.setTDetailPlanGeneral(new TDetailPlanGeneral(pgpm.getGpgId()));
	  		 detailPass.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
	  		 detailPass.setTTypeProcedure(new TTypeProcedure(typProce));
	  		 detailPass.setDppTypePlan("PS");
	  		 detailPass.setTStructure(recupStructure);
	  		 detailPass.setDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
	  		 detailPass.setDppDateSaisie(Calendar.getInstance().getTime());
	  		 detailPass.setTStatut(new TStatut("S1S"));
	  		 detailPass.setDppStatutRetour("0");
	  		 detailPass.setDppStatutDao("N");
	  		 iservice.addObject(detailPass);
	  		
	  		TAffichagePpm affichagePpm = new TAffichagePpm();
	  		affichagePpm.setAffDppId(detailPass.getDppId());
	  		affichagePpm.setTTypeMarche(new TTypeMarche(detailPass.getTTypeMarche().getTymCode()));
	  		affichagePpm.setTTypeProcedure(new TTypeProcedure(detailPass.getTTypeProcedure().getTypId()));
	  		affichagePpm.setTModePassation(new TModePassation(detailPass.getTModePassation().getMopCode()));
	  		affichagePpm.setTLBudgets(new TLBudgets(detailPass.getTLBudgets().getLbgCode()));
	  		affichagePpm.setTDetailPlanGeneral(new TDetailPlanGeneral(detailPass.getTDetailPlanGeneral().getGpgId()));
	  		affichagePpm.setTStatut(new TStatut(detailPass.getTStatut().getStaCode()));
	  		affichagePpm.setTStructure(new TStructure(detailPass.getTStructure().getStrCode()));
	  		affichagePpm.setTFonction(recupFonction);
	  		affichagePpm.setAffDppTypePlan(detailPass.getDppTypePlan());
	  		affichagePpm.setAffDppActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
	  		affichagePpm.setTStructure(recupStructure);
	  		affichagePpm.setAffDppStatutRetour(detailPass.getDppStatutRetour());
	  		affichagePpm.setAffDppObjet(detailPass.getDppObjet());
	  		affichagePpm.setAffDppDate(detailPass.getDppDate());
	  		affichagePpm.setAffDppNumeroOrdre(detailPass.getDppNumeroOrdre());
	  		affichagePpm.setAffDppSourceFin(detailPass.getDppSourceFin());
	  		affichagePpm.setAffDppCode(detailPass.getDppCode());
	  		affichagePpm.setAffDppDateAttApproBail(detailPass.getDppDateAttApproBail());
	  		affichagePpm.setAffDppDateAttApprobDmp(detailPass.getDppDateAttApprobDmp());
	  		affichagePpm.setAffDppDateAvisAoPublicat(detailPass.getDppDateAvisAoPublication());
	  		affichagePpm.setAffDppDateDaoApprobBail(detailPass.getDppDateDaoApprobBail());
	  		affichagePpm.setAffDppDateDaoApprobDmp(detailPass.getDppDateDaoApprobDmp());
	  		affichagePpm.setAffDppDateDaoTrans(detailPass.getDppDateDaoTrans());
	  		affichagePpm.setAffDppDateElabRapport(detailPass.getDppDateElabRapport());
	  		affichagePpm.setAffDppDateExecDebut(detailPass.getDppDateExecDebut());
	  		affichagePpm.setAffDppDateExecFin(detailPass.getDppDateExecFin());
	  		affichagePpm.setAffDppDateJugementOffre(detailPass.getDppDateJugementOffre());
	  		affichagePpm.setAffDppDateMarcheApprob(detailPass.getDppDateMarcheApprob());
	  		affichagePpm.setAffDppDateNegociation(detailPass.getDppDateNegociation());
	  		affichagePpm.setAffDppDateOuvertOf(detailPass.getDppDateOuvertOf());
	  		affichagePpm.setAffDppDateOuvertOt(detailPass.getDppDateOuvertOt());
	  		affichagePpm.setAffDppDateSignatAc(detailPass.getDppDateSignatAc());
	  		affichagePpm.setAffDppDateSignatAttrib(detailPass.getDppDateSignatAttrib());
	  		affichagePpm.setAffDppDateSaisie(detailPass.getDppDateSaisie());
	  		iservice.addObject(affichagePpm);
	  		
	  		if(fipPgpm.getFipId() > 0 ) {
	  		TFinancementPpm newFinancement = new TFinancementPpm();
	  		newFinancement.setTBailleur(new TBailleur(fipPgpm.getTBailleur().getBaiCode()));
	  		newFinancement.setTDetailPlanPassation(detailPass);
	  		newFinancement.setTSourceFinancement(new TSourceFinancement(fipPgpm.getTSourceFinancement().getSouCode()));
	  		newFinancement.setTDevise(new TDevise(fipPgpm.getTDevise().getDevCode()));
	  		newFinancement.setFppMontantDevise(fipPgpm.getFipMontantDevise());
	  		newFinancement.setFppMontantCfa(fipPgpm.getFipMontantCfa());
	  		iservice.addObject(newFinancement);
	  		}
	  	//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
	  			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
	  		    TStatut statuts = new TStatut();
	  		      if(!LS.isEmpty()) statuts = LS.get(0);
	  		  //Historisation des Plans Généraux
	  		     THistoPlanPassation histoPass = new THistoPlanPassation();
	  		     histoPass.setHppDate(Calendar.getInstance().getTime());
	  		     histoPass.setHppMotif("PPM enregistré par"+userController.getSlctd().getTFonction().getFonCod());
	  		     histoPass.setTStatut(statuts);
	  		     histoPass.setTDetailPlanPassation(detailPass);
	  		     histoPass.setTFonction(userController.getSlctd().getTFonction());
	  		     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
	  		     iservice.addObject(histoPass);
	  			
	  			//chargeData();
	  			chargeDataPspm();
	  			
	  			//Activation du bouton d'édition du pspm et désactivation du bouton d'édition du ppm
	  			boutonEditPspm = true;
	  			boutonEdit = false;
	  			//Actualisation du Tableau de Bord
	  			tableauBordController.chargeDataPpmPspm();
	  			//Message de confirmation
	  			userController.setTexteMsg("Opération enregistrée avec succès!");
	  			userController.setRenderMsg(true);
	  			userController.setSevrityMsg("success");
	  	 }
	  	 
	  	 
	  	 
	  	public String fermerPspm(String value ,String action) throws IOException { 
			 userController.initMessage();
		     chargeDataPspm();
		     //chargeDataPgspm();
			 //vider();
			 return userController.renderPage(value);
		 }
	  	 
	  	 
	  	 public String fermer(String value ,String action) throws IOException { 
			 userController.initMessage();
		     //chargeData();
		     //chargeDataPgspm();
			 //vider();
			 return userController.renderPage(value);
		 }
		 
	  
	  	 
	  	 //Méthode de création d'un financement
	  	 public void saveFinancement(){
			    newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
			    newFinancement.setTDevise(new TDevise(devCode));
			    newFinancement.setTBailleur(new TBailleur(baiCode));
			    newFinancement.setTDetailPlanPassation(detailPass);;
			    
				iservice.addObject(newFinancement);
				//newFinancement = new TFinancementPpm();
				
				//Récuperons la dernière opération crée et faisons une mis à jour sur sa source de financement
				 List<TDetailPlanPassation> PL =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
							new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+detailPass.getDppId()));
				 TDetailPlanPassation pass = new TDetailPlanPassation();
					 if(!PL.isEmpty())  
						 pass =PL.get(0); 
					     pass.setDppSourceFin(newFinancement.getTSourceFinancement().getSouCode());
					     iservice.updateObject(pass);
		
			
				//methode qui charge les financements du projet crée
				chargeFinancement();
				//methode qui charge la liste des pgpm
				chargeData();
				
				//Message de Confirmation
				 userController.setTexteMsg("Financement enregistré avec succès !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
				 viderFinancement();
			}
		 
	  	 
		 //Methodes vider
		 public void viderFinancement() {
			 newFinancement = new TFinancementPpm();
			 devCode ="";
			 baiCode ="";
			 souCode=""; 
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
			 							statutTrans ="SPT";  
			 								}else {
			 									  statutTrans ="SPT"; 
			 								  }
			 						   }
		 			
		 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
			 		for(TAffichagePpm lignePpm : listSelectionTransmission) {
			 			 
			 			//Parcourir la liste et récupérer les demande au statut E1T
			 			listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+lignePpm.getAffDppId()));
								if (!listeTsPpm.isEmpty()) {
									passDetail= listeTsPpm.get(0);
									if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
										 passDetail.setDppDateValAc(Calendar.getInstance().getTime());
			 						 }else
			 							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
			 								passDetail.setDppDateValCpmp(Calendar.getInstance().getTime()); 
			 							 }else
			 								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
			 									passDetail.setDppDateValDmp(Calendar.getInstance().getTime()); 
			 								 }
									passDetail.setTStatut(new TStatut(statutTrans));
									passDetail.setDppStatutRetour("0");
							       iservice.updateObject(passDetail);
						
								}
				 			
				 			//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
								List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutTrans));
							    TStatut statuts = new TStatut();
							      if(!LS.isEmpty()) statuts = LS.get(0);
							  //Historisation des Plans Généraux
							     THistoPlanPassation histoPass = new THistoPlanPassation();
							     histoPass.setHppDate(Calendar.getInstance().getTime());
							     histoPass.setHppMotif("Opération transmise à la Cellule de Passation");
							     histoPass.setTStatut(statuts);
							     histoPass.setTDetailPlanPassation(passDetail);
							     histoPass.setTFonction(userController.getSlctd().getTFonction());
							     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
							     iservice.addObject(histoPass);
										  
								 userController.setTexteMsg("Transmission effectuée avec succès !");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("success");
								 //return	null;  
				 		   }	
					     }
		 		        chargeData(); 
		 		       //chargePpmTrans();
		 		       //chargeDataPspm();
		 		     //Actualisation du Tableau de Bord
		 			  tableauBordController.chargeDataPpmPspm();
	           }
	     
	     
	     //Transmission par l'AC,CPMP,DMP
	     public void transmettrePspm()throws IOException{
	     	if (listSelectionTransmission.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune opération selectionnée", ""));
				}
		 		else{
		 			
		 			if(userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("02")) {
 						statutTrans ="S1T"; 
 				
 					}else
 						 if(userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("03")) {
 							  if(slctdTd.getDppMopCode().equalsIgnoreCase("PSO") || slctdTd.getDppMopCode().equalsIgnoreCase("PSL") ) {
 								 statutTrans ="SPS";
 							         }
 							          
 								   }else {
 									  statutTrans ="SPT"; 
 								  }
		 			
		 			     
		 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
			 		for(TAffichagePpm lignePpm : listSelectionTransmission) {
			 			 
			 			//Parcourir la liste et récupérer les demande au statut E1T
			 			listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+lignePpm.getAffDppId()));
								if (!listeTsPpm.isEmpty()) {
									passDetail= listeTsPpm.get(0);
									 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
										 passDetail.setDppDateValAc(Calendar.getInstance().getTime());
			 						 }else
			 							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
			 								passDetail.setDppDateValCpmp(Calendar.getInstance().getTime()); 
			 							 }else
			 								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
			 									passDetail.setDppDateValDmp(Calendar.getInstance().getTime()); 
			 								 }
									passDetail.setTStatut(new TStatut(statutTrans));
									passDetail.setDppStatutRetour("0");
							       iservice.updateObject(passDetail);
							       
						
								}
				 			
				 			//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
								List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutTrans));
							    TStatut statuts = new TStatut();
							      if(!LS.isEmpty()) statuts = LS.get(0);
							  //Historisation des Plans Généraux
							     THistoPlanPassation histoPass = new THistoPlanPassation();
							     histoPass.setHppDate(Calendar.getInstance().getTime());
							     histoPass.setHppMotif("Opération transmise à la Cellule de Passation");
							     histoPass.setTStatut(statuts);
							     histoPass.setTDetailPlanPassation(passDetail);
							     histoPass.setTFonction(userController.getSlctd().getTFonction());
							     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
							     iservice.addObject(histoPass);
										  
								 userController.setTexteMsg("Transmission effectuée avec succès !");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("success");
								 //return	null;  
				 		   }	
					     }
		 		        //chargeData(); 
		 		       chargeDataPspm();
		 		      chargePspmTrans();
		 		     //Actualisation du Tableau de Bord
		 			  tableauBordController.chargeDataPspm();
	         }
	     
	     
	     
	     
	     //Validation par le CPMP DMP
	     @Transactional
			public void validerCPMPDMP()throws IOException{ 
		 		if (listSelectionTransmission.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune opération selectionnée", ""));
				}
		 		else{
		 				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
		 					 statutUpdate ="";
		 					 passDetail.setDppDateValAc(Calendar.getInstance().getTime());
		 				 }else {
		 					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
		 						 statutUpdate ="S2V";
		 						 passDetail.setDppDateValCpmp(Calendar.getInstance().getTime());
		 					 }else {
		 						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
		 							 statutUpdate ="S3V";
		 							 passDetail.setDppDateValDmp(Calendar.getInstance().getTime());
		 						 }else
		 							  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
		 								 statutUpdate ="S3V";
			 							 passDetail.setDppDateValDmp(Calendar.getInstance().getTime());  
		 					      }
		 				     } 
		 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
			 		for(TAffichagePpm lignePpm : listSelectionTransmission) {
			 			 
			 			//Parcourir la liste et récupérer les demande au statut E1T
			 			listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+lignePpm.getAffDppId()));
								if (!listeTsPpm.isEmpty()) {
									passDetail= listeTsPpm.get(0);
									
									 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
										 passDetail.setDppDateValAc(Calendar.getInstance().getTime());
			 						 }else
			 							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
			 								passDetail.setDppDateValCpmp(Calendar.getInstance().getTime()); 
			 							 }else
			 								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
			 									passDetail.setDppDateValDmp(Calendar.getInstance().getTime()); 
			 								 }else
			 									  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
			 										 passDetail.setDppDateValDmp(Calendar.getInstance().getTime());   
			 									  }
			 									 
									passDetail.setTStatut(new TStatut(statutUpdate));
									passDetail.setDppStatutRetour("0");
							        iservice.updateObject(passDetail);
							       
							
								}
				 				 
			 		        }	   
				 		   }	
					     }
		 		

				//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
				List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
			    TStatut statuts = new TStatut();
			      if(!LS.isEmpty()) statuts = LS.get(0);
			  //Historisation des Plans Généraux
			     THistoPlanPassation histoPass = new THistoPlanPassation();
			     histoPass.setHppDate(Calendar.getInstance().getTime());
			     histoPass.setHppMotif("Opération validée par"+userController.getSlctd().getTFonction());
			     histoPass.setTStatut(statuts);
			     histoPass.setTDetailPlanPassation(passDetail);
			     histoPass.setTFonction(userController.getSlctd().getTFonction());
			     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
			     iservice.addObject(histoPass);
						  
				 userController.setTexteMsg(" Validation effectuée avec succès !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
				//return null;
				 
		 		 
		 		  chargeDataAvaliderPpm();
		 		  //chargePpmValCp();
		 		  //chargePpmValDmp();
		 		  //chargeDataAvaliderPspm();
		 		  //Actualisation du Tableau de Bord
		 		  tableauBordController.chargeDataPpmPspm();
						}
	     
	     
	     
	   //Validation par le CPMP DMP
	     @Transactional
			public void validerPspmCPMPDMP()throws IOException{ 
		 		if (listSelectionTransmission.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune opération selectionnée", ""));
				}
		 		else{
		 				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
		 					 statutUpdate ="";
		 					 passDetail.setDppDateValAc(Calendar.getInstance().getTime());
		 				 }else {
		 					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
		 						 statutUpdate ="S2V";
		 						 passDetail.setDppDateValCpmp(Calendar.getInstance().getTime());
		 					 }else {
		 						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
		 							 statutUpdate ="S3V";
		 						     passDetail.setDppDateValDmp(Calendar.getInstance().getTime());
		 						 }
		 				     } 
		 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
			 		for(TAffichagePpm lignePpm : listSelectionTransmission) {
			 			 
			 			//Parcourir la liste et récupérer les demande au statut E1T
			 			listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+lignePpm.getAffDppId()));
								if (!listeTsPpm.isEmpty()) {
									passDetail= listeTsPpm.get(0);
									passDetail.setTStatut(new TStatut(statutUpdate));
									passDetail.setDppStatutRetour("0");
							       iservice.updateObject(passDetail);
							       
							
								}
	 
			 		          }	   
				 		   }	
					     }
		 	
				//Insertion de chaque ligne dans T_adep_log avec le statut correspondant
				List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
			    TStatut statuts = new TStatut();
			      if(!LS.isEmpty()) statuts = LS.get(0);
			  //Historisation des Plans Généraux
			     THistoPlanPassation histoPass = new THistoPlanPassation();
			     histoPass.setHppDate(Calendar.getInstance().getTime());
			     histoPass.setHppMotif("Opération validée par"+userController.getSlctd().getTFonction());
			     histoPass.setTStatut(statuts);
			     histoPass.setTDetailPlanPassation(passDetail);
			     histoPass.setTFonction(userController.getSlctd().getTFonction());
			     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
			     iservice.addObject(histoPass);
						  
				 userController.setTexteMsg(" Validation effectuée avec succès !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
				//return null;
				 
		 		  //chargeData();
		 		  //chargeDataAvaliderPpm();
		 		  chargeDataAvaliderPspm();
		 		 chargePspmValCp();
		 		  chargePspmValDmp();
		 		  //Actualisation du Tableau de Bord
		 		  tableauBordController.chargeDataPpmPspm();
						}
	     
	     
	     
	   //DIFFERER CPMP ET DMP
	     //Differer
			 public void differer() {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 statutUpdate ="";
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
						 statutUpdate ="S2D";
						 //observation = "PPM retourné par la CPMP";
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
							// statutUpdate ="S3D";
							 
							 if(slctdTd.getDppStrCode().equalsIgnoreCase("02")) {
								 statutUpdate ="S3D"; 
							 }else
								  if(slctdTd.getDppStrCode().equalsIgnoreCase("03")) {
									  statutUpdate ="SPR";  
								  }else {
									  statutUpdate ="S3D"; 
								  }
							 
						 }
				     } 
				 }
				 
				//Parcourir la liste et récupérer les demande au statut E1T
		 			listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
								new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
							if (!listeTsPpm.isEmpty()) {
								passDetail= listeTsPpm.get(0);
								passDetail.setTStatut(new TStatut(statutUpdate));
								passDetail.setDppStatutRetour("1");
						       iservice.updateObject(passDetail);
				
		                      
		                      //Insertion de chaque ligne dans T_histo_detail_plan_passation avec le statut correspondant
								List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
							    TStatut statuts = new TStatut();
							      if(!LS.isEmpty()) statuts = LS.get(0);
							  //Historisation des Plans Généraux
							     THistoPlanPassation histoPass = new THistoPlanPassation();
							     histoPass.setHppDate(Calendar.getInstance().getTime());
							     histoPass.setHppMotif(getObservation());
							     histoPass.setTStatut(statuts);
							     histoPass.setTDetailPlanPassation(passDetail);
							     histoPass.setTFonction(userController.getSlctd().getTFonction());
							     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
							     iservice.addObject(histoPass);
							     
							     userController.setTexteMsg("Opération retournée avec succès !");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("success");
								 //return	null
								 //chargeData();
			                   //Chargement des listes 
					           chargeDataAvaliderPpm();
					           chargeDataAvaliderPspm();
					     
					           chargePpmDifCp();
					           chargePpmDifDmp();
					          //Actualisation du Tableau de Bord
					          tableauBordController.chargeDataPpmPspm();
							
						 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Désolé, votre PPM a été retourné!", "");
						 FacesContext.getCurrentInstance().addMessage(null, msg);
						    }

			 }
			 
			 
			 //DIFFERER CPMP ET DMP
		     //Differer
				 public void reDifferer() {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 statutUpdate ="";
					 }else 
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
							 statutUpdate ="S2D";
						 } 
					 
					//Parcourir la liste et récupérer les demande au statut E1T
			 			listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
								if (!listeTsPpm.isEmpty()) {
									passDetail= listeTsPpm.get(0);
									passDetail.setTStatut(new TStatut(statutUpdate));
									passDetail.setDppStatutRetour("1");
							       iservice.updateObject(passDetail);
					
					    
					  
			                      
			                      
			                      listeHisto =(List<THistoPlanPassation>) iservice.getObjectsByColumn("THistoPlanPassation", new ArrayList<String>(Arrays.asList("HPP_ID")),
											new WhereClause("HPP_DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()),
											new WhereClause("HPP_STA_CODE",WhereClause.Comparateur.EQ,"S3D"));
								   if (!listeHisto.isEmpty()) {
									   histoPpm= listeHisto.get(0); 
								   }
			                    
			                      
			                      //Insertion de chaque ligne dans T_histo_detail_plan_passation avec le statut correspondant
									List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
								    TStatut statuts = new TStatut();
								      if(!LS.isEmpty()) statuts = LS.get(0);
								  //Historisation des Plans Généraux
								     THistoPlanPassation histoPass = new THistoPlanPassation();
								     histoPass.setHppDate(Calendar.getInstance().getTime());
								     histoPass.setHppMotif(histoPpm.getHppMotif());
								     histoPass.setTStatut(statuts);
								     histoPass.setTDetailPlanPassation(passDetail);
								     histoPass.setTFonction(userController.getSlctd().getTFonction());
								     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
								     iservice.addObject(histoPass);
								     
								     userController.setTexteMsg("Opération retournée avec succès !");
									 userController.setRenderMsg(true);
									 userController.setSevrityMsg("success");
									 //return	null
									 //chargeData();
				                   //Chargement des listes 
						           chargeDataAvaliderPpm();
						           chargeDataAvaliderPspm();
						     
						           chargePpmDifCp();
						           chargePpmDifDmp();
						          //Actualisation du Tableau de Bord
						          tableauBordController.chargeDataPpmPspm();
								
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Désolé, votre PPM a été retourné!", "");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
							    }
				 }
			 
			 		 
			 
			  //DIFFERER CPMP ET DMP
		     //Differer Pspm
				 public void differerPspm() {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 statutUpdate ="";
					 }else 
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
							 statutUpdate ="S2D";
							 observation="Opération retournée avec succès";
						 }else 
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
								 //statutUpdate ="S3D";
								 
								 if(slctdTd.getDppStrCode().equalsIgnoreCase("02")) {
									 statutUpdate ="S3D"; 
								 }else
									  if(slctdTd.getDppStrCode().equalsIgnoreCase("03")) {
										  statutUpdate ="SPD";  
									  }else {
										  statutUpdate ="S3D"; 
									  }
							 }
					      
					 
					//Parcourir la liste et récupérer les demande au statut E1T
			 			listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
								if (!listeTsPpm.isEmpty()) {
									passDetail= listeTsPpm.get(0);
									passDetail.setTStatut(new TStatut(statutUpdate));
									passDetail.setDppStatutRetour("1");
							       iservice.updateObject(passDetail);
					
					    
					    List<TAffichagePpm> AG =iservice.getObjectsByColumn("TAffichagePpm", new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
		  						new WhereClause("AFF_DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
			               TAffichagePpm ppm = new TAffichagePpm();
			                    if(!AG.isEmpty()) ppm =AG.get(0); 
			                      ppm.setTStatut(new TStatut(statutUpdate));
			                     ppm.setAffDppStatutRetour("1");
			                      iservice.updateObject(ppm);
			                      

									 //Insertion de chaque ligne dans T_histo_detail_plan_passation avec le statut correspondant
										List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
									    TStatut statuts = new TStatut();
									      if(!LS.isEmpty()) statuts = LS.get(0);
									  //Historisation des Plans Généraux
									     THistoPlanPassation histoPass = new THistoPlanPassation();
									     histoPass.setHppDate(Calendar.getInstance().getTime());
									     histoPass.setHppMotif(getObservation());
									     histoPass.setTStatut(statuts);
									     histoPass.setTDetailPlanPassation(passDetail);
									     histoPass.setTFonction(userController.getSlctd().getTFonction());
									     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
									     iservice.addObject(histoPass);
			                      
			                      
									 //chargeData();
				                   //Chargement des listes 
						           //chargeDataAvaliderPpm();
						           chargeDataAvaliderPspm();
						           chargePspmDifCp();
						           chargePspmDifDmp();
						          //Actualisation du Tableau de Bord
						          tableauBordController.chargeDataPspm();
						          

			                 userController.setTexteMsg("Opération retournée avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
									 
									  
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Désolé, votre PSPM a été retourné!", "");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
							    }					  	
				     }
				 
				 
				 
				//Differer Pspm
				 public void reDiffererPspm() {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 statutUpdate ="";
					 }else 
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
							 statutUpdate ="S2D";
						 }
					 
					//Parcourir la liste et récupérer les demande au statut E1T
			 			listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
								if (!listeTsPpm.isEmpty()) {
									passDetail= listeTsPpm.get(0);
									passDetail.setTStatut(new TStatut(statutUpdate));
									passDetail.setDppStatutRetour("1");
							       iservice.updateObject(passDetail);
					
			                      
			                      
			                      listeHisto =(List<THistoPlanPassation>) iservice.getObjectsByColumn("THistoPlanPassation", new ArrayList<String>(Arrays.asList("HPP_ID")),
											new WhereClause("HPP_DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()),
											new WhereClause("HPP_STA_CODE",WhereClause.Comparateur.EQ,"S3D"));
								   if (!listeHisto.isEmpty()) {
									   histoPpm= listeHisto.get(0); 
								   }
			                    
			                      

									 //Insertion de chaque ligne dans T_histo_detail_plan_passation avec le statut correspondant
										List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
									    TStatut statuts = new TStatut();
									      if(!LS.isEmpty()) statuts = LS.get(0);
									  //Historisation des Plans Généraux
									     THistoPlanPassation histoPass = new THistoPlanPassation();
									     histoPass.setHppDate(Calendar.getInstance().getTime());
									     histoPass.setHppMotif(histoPpm.getHppMotif());
									     histoPass.setTStatut(statuts);
									     histoPass.setTDetailPlanPassation(passDetail);
									     histoPass.setTFonction(userController.getSlctd().getTFonction());
									     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
									     iservice.addObject(histoPass);
			                      
			                      
									 //chargeData();
				                   //Chargement des listes 
						           //chargeDataAvaliderPpm();
						           chargeDataAvaliderPspm();
						           chargePspmDifCp();
						           chargePspmDifDmp();
						          //Actualisation du Tableau de Bord
						          tableauBordController.chargeDataPspm();
						          

			                 userController.setTexteMsg("Opération retournée avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
									 
									  
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Désolé, votre PSPM a été retourné!", "");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
							    }					  	
				     }
			 
			 
	  
			//Affichage des motifs de retour
				public void chargerObservation() {
					ppmstatutList=(List<VPpmStatut>) iservice.getObjectsByColumn("VPpmStatut", new ArrayList<String>(Arrays.asList("HPP_ID")),
							new WhereClause("HPP_DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()),
							new WhereClause("HPP_STA_CODE",WhereClause.Comparateur.EQ,slctdTd.getDppStaCode()));
					if(!ppmstatutList.isEmpty()) {
						int i=ppmstatutList.size();
						int baoule=i-1;
						ppmstatut=ppmstatutList.get(baoule);
					}	
				}
				
				
				 //Methode de modification des PPM/PSPM
				 //@Transactional
				 public void modifierDetailPlan() throws IOException{
					 
					 List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
				   				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
					     TDetailPlanPassation detail = new TDetailPlanPassation();
								if(!PLG.isEmpty()) detail =PLG.get(0); 
					             detail.setTDetailPlanGeneral(new TDetailPlanGeneral(updatePpm.getDppGpgId()));
					             detail.setTTypeMarche(new TTypeMarche(updatePpm.getDppTymCode()));
					             detail.setTModePassation(new TModePassation(updatePpm.getDppMopCode()));
					             detail.setTLBudgets(new TLBudgets(updatePpm.getLbgCode()));
					             detail.setDppStructureConduc(updatePpm.getDppStructureConduc());
					             detail.setDppStructureBenefi(updatePpm.getDppStructureBenefi());
					             detail.setDppObjet(updatePpm.getDppObjet());
					             detail.setDppPartiePmePmi(updatePpm.getDppPartiePmePmi());
					             detail.setDppBailleur(updatePpm.getDppBailleur());
					             detail.setTModeleDacType(new TModeleDacType(updatePpm.getMdtCode()));
					             detail.setDppDateAttApproBail(updatePpm.getDppDateAttApproBail());
					             detail.setDppApprobAno(updatePpm.getDppApprobAno());
					             detail.setDppDateAvisAoPublication(updatePpm.getDppDateAvisAoPublication());
					             detail.setDppDateJugementOffre(updatePpm.getDppDateJugementOffre());
					             detail.setDppDateDaoTrans(updatePpm.getDppDateDaoTrans());
					             detail.setDppDateExecFin(updatePpm.getDppDateExecFin());
					             detail.setDppDateExecDebut(updatePpm.getDppDateExecDebut());
					             detail.setDppDateMarcheApprob(updatePpm.getDppDateMarcheApprob());
					             detail.setDppDateOuvertOf(updatePpm.getDppDateOuvertOf());
					             detail.setDppDateOuvertOt(updatePpm.getDppDateOuvertOt());
					             detail.setDppDateElabRapport(updatePpm.getDppDateElabRapport());
					             detail.setDppDateNegociation(updatePpm.getDppDateNegociation());
					             detail.setDppDateAttApprobDmp(updatePpm.getDppDateDaoApprobDmp());
					             detail.setDppDateAttApprobCpmp(updatePpm.getDppDateAttApprobCpmp());
					             detail.setDppDateSignatAttrib(updatePpm.getDppDateSignatAttrib());
					             detail.setDppDateSignatAc(updatePpm.getDppDateSignatAc());
					             detail.setDppInvEntre(updatePpm.getDppInvEntre());
					             iservice.updateObject(detail);
		
					/* slctdTd.setTDetailPlanGeneral(new TDetailPlanGeneral(updatePpm.getDppGpgId()));
					 slctdTd.setTTypeMarche(new TTypeMarche(updatePpm.getDppTymCode()));
					 slctdTd.setTModePassation(new TModePassation(updatePpm.getDppMopCode()));
					 slctdTd.setTLBudgets(new TLBudgets(updatePpm.getLbgCode()));
					 slctdTd.setAffDppStrConduc(updatePpm.getDppStructureConduc());
					 slctdTd.setAffDppStrBenefi(updatePpm.getDppStructureBenefi());
					 slctdTd.setAffDppObjet(updatePpm.getDppObjet());
					 slctdTd.setAffDppPartiePmePmi(updatePpm.getDppPartiePmePmi());
					 slctdTd.setAffDppBailleur(updatePpm.getDppBailleur());
					 slctdTd.setAffDppPieceDao(updatePpm.getMdtCode());
					 slctdTd.setAffDppDateAttApproBail(updatePpm.getDppDateAttApproBail());
					 slctdTd.setDppApprobAno(updatePpm.getDppApprobAno());
					 slctdTd.setAffDppDateAvisAoPublicat(updatePpm.getDppDateAvisAoPublication());
					 slctdTd.setAffDppDateJugementOffre(updatePpm.getDppDateJugementOffre());
					 slctdTd.setAffDppDateDaoTrans(updatePpm.getDppDateDaoTrans());
					 slctdTd.setAffDppDateExecFin(updatePpm.getDppDateExecFin());
					 slctdTd.setAffDppDateExecDebut(updatePpm.getDppDateExecDebut());
					 slctdTd.setAffDppDateMarcheApprob(updatePpm.getDppDateMarcheApprob());
					 slctdTd.setAffDppDateOuvertOf(updatePpm.getDppDateOuvertOf());
					 slctdTd.setDppDateOuvertOt(updatePpm.getDppDateOuvertOt());
					 slctdTd.setDppDateElabRapport(updatePpm.getDppDateElabRapport());
					 slctdTd.setAffDppDateNegociation(updatePpm.getDppDateNegociation());
					 slctdTd.setAffDppDateAttApprobDmp(updatePpm.getDppDateDaoApprobDmp());
					 slctdTd.setAffDppDateAttApprobCmp(updatePpm.getDppDateAttApprobCpmp());
					 slctdTd.setAffDppDateSignatAttrib(updatePpm.getDppDateSignatAttrib());
					 slctdTd.setAffDppDateSignatAc(updatePpm.getDppDateSignatAc());
					 slctdTd.setAffDppInvEntre(updatePpm.getDppInvEntre());
					 iservice.updateObject(slctdTd);*/
					 
					 
					 /*//Modification dans TDetailPlanPassation
			    	 List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
			   				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffDppId()));
			    	        TDetailPlanPassation detail = new TDetailPlanPassation();
							if(!PLG.isEmpty()) detail =PLG.get(0);
							detail.setTDetailPlanGeneral(new TDetailPlanGeneral(slctdTd.getTDetailPlanGeneral().getGpgId()));
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
							detail.setDppDateAttApprobCpmp(slctdTd.getAffDppDateAttApprobCmp());
							detail.setDppDateAttApprobDmp(slctdTd.getAffDppDateAttApprobDmp());
							detail.setDppApprobAno(slctdTd.getAffDppApprobAno());
							detail.setDppDateNegociation(slctdTd.getAffDppDateNegociation());
							//detail.setDppInvEntre(slctdTd.getAffDppInvEntre());
							iservice.updateObject(detail);*/
							
							 
							    	//Mis à Jour dans T_Financement_PPM
				    				  for(TFinancementPpm fin: listeFinancement) {
				    					      listeFinancement = ((List<TFinancementPpm>)iservice.getObjectsByColumn("TFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
													 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+fin.getTDetailPlanPassation().getDppId())));
											      if(!listeFinancement.isEmpty()) {
											    	  TFinancementPpm newFinancement = new TFinancementPpm();
											    	  newFinancement = listeFinancement.get(0);
											    	
											    	   newFinancement.setFppCommentaire(fin.getFppCommentaire());
									      		       newFinancement.setFppMontantCfa(fin.getFppMontantCfa());
									      		       newFinancement.setFppMontantDevise(fin.getFppMontantDevise());
									      		       newFinancement.setFppPartTresor(fin.getFppPartTresor());
									      		       newFinancement.setTBailleur(new TBailleur(fin.getTBailleur().getBaiCode()));	
									      		       newFinancement.setTSourceFinancement(new TSourceFinancement(fin.getTSourceFinancement().getSouCode()));
									      		       newFinancement.setTDevise(new TDevise(fin.getTDevise().getDevCode()));
									      			   iservice.updateObject(newFinancement);
											      }
				    				       }
							     
						
							
							//Rédirection sur l'index
			   				userController.renderPage("ppm1");
			   				//Message de Confirmation
					    	 userController.setTexteMsg("Modification éffectuée avec succès!");
						     userController.setRenderMsg(true);
						     userController.setSevrityMsg("success");
						     chargeData();
						     //boutonEditUpdate = true;
				 }
				 
				 //Methode d'impression après modification du PPM
				 public void imprimModifPpm() {
			    	 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_ppm", "Fiche_operation_ppm");
			     }
				 
				 
				 //Methode d'impression après modification du PSPM
				 public void imprimModifPspm() {
					 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSO")) {
						 projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_pso", "Fiche_operation_pso");
					 }else
					     if(slctdTd.getDppMopCode().equalsIgnoreCase("PSL")){
					    projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_psl", "Fiche_operation_psl");
					 }else
						  if(slctdTd.getDppMopCode().equalsIgnoreCase("PSC")) {
							projetReport.longparam1(slctdTd.getDppId(), "Fiche_operation_psc", "Fiche_operation_psc");
						  }
			         }
				 
				
				
				 public void coutOperation() {
					 totalMontant = 0;
					 for(TFinancementPpm n : listeFinancement) {
						 totalMontant = totalMontant+ (n.getFppMontantCfa()+n.getFppPartTresor());
					 }
				 }
				 
				 public String fermerForm(String value ,String action) throws IOException {
					 userController.initMessage();
				     
					 chargeDataPspm(); 
					 vider();
					 return userController.renderPage(value);
				 }
				 
				//Methodes vider
		    	 public void vider() {
		    		 detailPass = new TDetailPlanPassation();
		    		 recupFonction = new TFonction();
		    		 reucpMarche = new VTypeMarcheFils();
		    		 recupModePassation = new TModePassation();
		    		 newFinancement = new TFinancementPpm();
		    		 listeFinancement = new ArrayList<TFinancementPpm>();
		    		
		    		 planPass = new TPlanPassation(); 
		    		 devCode ="";
		    		 baiCode ="";
		    		 souCode=""; 
		    	 }
				 
				 
		
	 
 
	 
	 
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);	 
		     switch(value) {
				case "ppm1":
					 chargeData();
					 chargeDataAvaliderPpm();
					_logger.info("value: "+value+" action "+action);	
					break;
				case "ppm2":
					chargeGestions();
					chargeBailleur();
					chargeDevise();
					chargeMarches();
					chargeModePassation();
					chargePgpm();
					chargeSourceFinance();
				break;
				case "ppm4":
					editForm();
					chargeFinancementUpdate();
					chargeGestions();
					chargeMarches();
					chargeModePassation();
					chargePgpm();
				break;
				case "pspm1": 
					chargeDataPspm();
		 			chargeDataAvaliderPspm();
		 			_logger.info("value: "+value+" action: "+action);
				break;
			    }
		     return userController.renderPage(value);
	 }



	 
		//Cumul Coût des opérations
		 public void montantOperation() {
			  totalLigne = 0;
			 for(VLigneImputation n : listeImputations) {
				// totalLigne = totalLigne+ (n.getLiaeDotAeTre()); 
			 }
		 }
		 
		 //Methode d'impression ppm
		 public void imprimerPpm() {
			 String operateur = userController.getSlctd().getTFonction().getFonCod();
	    	 projetReport.longStringparam2(planPass.getPlpId(), operateur, "Ppm", "Ppm");
	     }
		 
		 //Edition de l'état PPM en fonction de la gestion
		 public void imprimerPpmIndex() {
			 String operateur = userController.getSlctd().getTFonction().getFonCod();
				projetReport.longStringparam2(gesCode, operateur, "Ppm", "Ppm");
			}
		 
		 //Edition de l'état PSPM en fonction de la gestion
		 public void imprimerPspmIndex() {
			 String operateur = userController.getSlctd().getTFonction().getFonCod();
				projetReport.longStringparam2(gesCode, operateur, "Pspm", "Pspm");
			}

		 
		 //Methode d'impression pspm
		 public void imprimerPspm() {
			 if(detailPass.getTModePassation().getMopCode().equalsIgnoreCase("PSO")) {
				 String operateur = userController.getSlctd().getTFonction().getFonCod();
				 projetReport.longStringparam2(planPass.getPlpId(), operateur, "Pspm_pso", "Pspm_pso");
			 }else
			     if(detailPass.getTModePassation().getMopCode().equalsIgnoreCase("PSL")){
			    	 String operateur = userController.getSlctd().getTFonction().getFonCod();
			    	 projetReport.longStringparam2(planPass.getPlpId(), operateur, "Pspm_psl", "Pspm_psl");
			 }else
				  if(detailPass.getTModePassation().getMopCode().equalsIgnoreCase("PSC")) {
					  String operateur = userController.getSlctd().getTFonction().getFonCod();
					  projetReport.longStringparam2(planPass.getPlpId(), operateur, "Pspm_psc", "Pspm_psc");
				  }
	         }



	public List<TDetailPlanPassation> getListeTsPpm() {
		return listeTsPpm;
	}
	public void setListeTsPpm(List<TDetailPlanPassation> listeTsPpm) {
		this.listeTsPpm = listeTsPpm;
	}

/*
	public List<TAffichagePpm> getListePpm() {
		return listePpm;
	}


	public void setListePpm(List<TAffichagePpm> listePpm) {
		this.listePpm = listePpm;
	}*/

	public List<VPgpmFonction> getListePgpm() {
		return listePgpm;
	}

	public void setListePgpm(List<VPgpmFonction> listePgpm) {
		this.listePgpm = listePgpm;
	}



	public List<TFinancementPpm> getListeFinancement() {
		return listeFinancement;
	}

	public void setListeFinancement(List<TFinancementPpm> listeFinancement) {
		this.listeFinancement = listeFinancement;
	}



	public List<TMinistere> getListeMinistere() {
		return listeMinistere;
	}

	public void setListeMinistere(List<TMinistere> listeMinistere) {
		this.listeMinistere = listeMinistere;
	}


	public List<TStructure> getListeStructures() {
		return listeStructures;
	}


	public void setListeStructures(List<TStructure> listeStructures) {
		this.listeStructures = listeStructures;
	}




	public List<TCharge> getListeCharges() {
		return listeCharges;
	}


	public void setListeCharges(List<TCharge> listeCharges) {
		this.listeCharges = listeCharges;
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

	/*public List<TLigneBudgetaire> getListeImputations() {
		return listeImputations;
	}
	public void setListeImputations(List<TLigneBudgetaire> listeImputations) {
		this.listeImputations = listeImputations;
	}*/
	
	

	public List<VLigneImputation> getListeImputations() {
		return listeImputations;
	}
	public void setListeImputations(List<VLigneImputation> listeImputations) {
		this.listeImputations = listeImputations;
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


	public List<TTypeMarche> getListeTypeMarches() {
		return listeTypeMarches;
	}



	public void setListeTypeMarches(List<TTypeMarche> listeTypeMarches) {
		this.listeTypeMarches = listeTypeMarches;
	}


	public List<TModePassation> getListeModePassation() {
		return listeModePassation;
	}



	public void setListeModePassation(List<TModePassation> listeModePassation) {
		this.listeModePassation = listeModePassation;
	}


	public List<TGestion> getListeGestion() {
		return listeGestion;
	}


	public void setListeGestion(List<TGestion> listeGestion) {
		this.listeGestion = listeGestion;
	}

/*
	public List<TAffichagePpm> getValidationListe() {
		return validationListe;
	}

	public void setValidationListe(List<TAffichagePpm> validationListe) {
		this.validationListe = validationListe;
	}
*/


	public List<TAffichagePpm> getListSelectionTransmission() {
		return listSelectionTransmission;
	}


	public void setListSelectionTransmission(List<TAffichagePpm> listSelectionTransmission) {
		this.listSelectionTransmission = listSelectionTransmission;
	}


	public TModePassation getRecupModePassation() {
		return recupModePassation;
	}

	public void setRecupModePassation(TModePassation recupModePassation) {
		this.recupModePassation = recupModePassation;
	}

	public List <VPpmStatut> getPpmstatutList() {
		return ppmstatutList;
	}


	public void setPpmstatutList(List <VPpmStatut> ppmstatutList) {
		this.ppmstatutList = ppmstatutList;
	}



	public TPlanPassation getPlanPass() {
		return planPass;
	}



	public void setPlanPass(TPlanPassation planPass) {
		this.planPass = planPass;
	}



	public TDetailPlanPassation getDetailPass() {
		return detailPass;
	}



	public void setDetailPass(TDetailPlanPassation detailPass) {
		this.detailPass = detailPass;
	}
	
	
	public VPgpmFonction getRecupPgpm() {
		return recupPgpm;
	}

	public void setRecupPgpm(VPgpmFonction recupPgpm) {
		this.recupPgpm = recupPgpm;
	}

	public VPgpmFonction getPgpm() {
		return pgpm;
	}

	public void setPgpm(VPgpmFonction pgpm) {
		this.pgpm = pgpm;
	}
	

	public TDetailPlanPassation getPassDetail() {
		return passDetail;
	}

	

	public void setPassDetail(TDetailPlanPassation passDetail) {
		this.passDetail = passDetail;
	}


	public TAffichagePpm getSlctdTdPpm() {
		return slctdTdPpm;
	}


	public void setSlctdTdPpm(TAffichagePpm slctdTdPpm) {
		this.slctdTdPpm = slctdTdPpm;
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
	
	
	
	

/*
	public TTypeMarche getReucpMarche() {
		return reucpMarche;
	}


	public void setReucpMarche(TTypeMarche reucpMarche) {
		this.reucpMarche = reucpMarche;
	}
	
	
	public TLigneBudgetaire getLigne() {
		return ligne;
	}


	public void setLigne(TLigneBudgetaire ligne) {
		this.ligne = ligne;
	}


	public TLigneBudgetaire getRecupLigne() {
		return recupLigne;
	}
	public void setRecupLigne(TLigneBudgetaire recupLigne) {
		this.recupLigne = recupLigne;
	}*/

	public VTypeMarcheFils getReucpMarche() {
		return reucpMarche;
	}


	public void setReucpMarche(VTypeMarcheFils reucpMarche) {
		this.reucpMarche = reucpMarche;
	}


	public VLigneImputation getLigne() {
		return ligne;
	}


	public void setLigne(VLigneImputation ligne) {
		this.ligne = ligne;
	}


	public VLigneImputation getRecupLigne() {
		return recupLigne;
	}


	public void setRecupLigne(VLigneImputation recupLigne) {
		this.recupLigne = recupLigne;
	}


	public TFinancementPpm getNewFinancement() {
		return newFinancement;
	}
	
	public void setNewFinancement(TFinancementPpm newFinancement) {
		this.newFinancement = newFinancement;
	}

	public TFinancementPpm getSelectFinance() {
		return selectFinance;
	}

	public void setSelectFinance(TFinancementPpm selectFinance) {
		this.selectFinance = selectFinance;
	}


	public VPpmliste getSlctdTd() {
		return slctdTd;
	}


	public void setSlctdTd(VPpmliste slctdTd) {
		this.slctdTd = slctdTd;
	}


	public TModePassation getModePassation() {
		return modePassation;
	}

	public void setModePassation(TModePassation modePassation) {
		this.modePassation = modePassation;
	}


	public VPpmStatut getPpmstatut() {
		return ppmstatut;
	}



	public void setPpmstatut(VPpmStatut ppmstatut) {
		this.ppmstatut = ppmstatut;
	}


	public VFonctionMinistere getFonction() {
		return fonction;
	}


	public void setFonction(VFonctionMinistere fonction) {
		this.fonction = fonction;
	}



	public TStructure getStructure() {
		return structure;
	}


	public void setStructure(TStructure structure) {
		this.structure = structure;
	}



	public TStructure getNewStr() {
		return newStr;
	}



	public void setNewStr(TStructure newStr) {
		this.newStr = newStr;
	}


	public TStructure getRecupstructure() {
		return recupstructure;
	}



	public void setRecupstructure(TStructure recupstructure) {
		this.recupstructure = recupstructure;
	}



	public TCharge getCharge() {
		return charge;
	}



	public void setCharge(TCharge charge) {
		this.charge = charge;
	}


	public TDetailPlanPassation getRecupPass() {
		return recupPass;
	}


	public void setRecupPass(TDetailPlanPassation recupPass) {
		this.recupPass = recupPass;
	}


	public TDetailPlanPassation getPassation() {
		return passation;
	}



	public void setPassation(TDetailPlanPassation passation) {
		this.passation = passation;
	}

	public long getGesCode() {
		return gesCode;
	}


	public void setGesCode(long gesCode) {
		this.gesCode = gesCode;
	}


	public long getTotalLigne() {
		return totalLigne;
	}

	public void setTotalLigne(long totalLigne) {
		this.totalLigne = totalLigne;
	}


	public String getFiltreTypeMarche() {
		return filtreTypeMarche;
	}


	public void setFiltreTypeMarche(String filtreTypeMarche) {
		this.filtreTypeMarche = filtreTypeMarche;
	}


	public String getFiltreModePassation() {
		return filtreModePassation;
	}

	public void setFiltreModePassation(String filtreModePassation) {
		this.filtreModePassation = filtreModePassation;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getNatPiece() {
		return natPiece;
	}


	public void setNatPiece(String natPiece) {
		this.natPiece = natPiece;
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


	public String getTypCharge() {
		return typCharge;
	}


	public void setTypCharge(String typCharge) {
		this.typCharge = typCharge;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String getFiltreLigne() {
		return filtreLigne;
	}

	public void setFiltreLigne(String filtreLigne) {
		this.filtreLigne = filtreLigne;
	}

	public List<TTypeCharge> getListeTypeCharges() {
		return listeTypeCharges;
	}

	public void setListeTypeCharges(List<TTypeCharge> listeTypeCharges) {
		this.listeTypeCharges = listeTypeCharges;
	}

	public TDetailPlanPassation getPpm() {
		return ppm;
	}

	public void setPpm(TDetailPlanPassation ppm) {
		this.ppm = ppm;
	}

	public TDetailPlanPassation getRecuPpm() {
		return recuPpm;
	}

	public void setRecuPpm(TDetailPlanPassation recuPpm) {
		this.recuPpm = recuPpm;
	}

	public String getFiltrePgpm() {
		return filtrePgpm;
	}

	public void setFiltrePgpm(String filtrePgpm) {
		this.filtrePgpm = filtrePgpm;
	}

	public String getFiltrePpm() {
		return filtrePpm;
	}

	public void setFiltrePpm(String filtrePpm) {
		this.filtrePpm = filtrePpm;
	}

	public String getFiltreStructure() {
		return filtreStructure;
	}

	public void setFiltreStructure(String filtreStructure) {
		this.filtreStructure = filtreStructure;
	}

	public long getTotalMontant() {
		return totalMontant;
	}

	public void setTotalMontant(long totalMontant) {
		this.totalMontant = totalMontant;
	}

	public List<TFinancementPgpm> getListeFinancementPgpm() {
		return listeFinancementPgpm;
	}

	public void setListeFinancementPgpm(List<TFinancementPgpm> listeFinancementPgpm) {
		this.listeFinancementPgpm = listeFinancementPgpm;
	}

	public TFinancementPgpm getFipPgpm() {
		return fipPgpm;
	}

	public void setFipPgpm(TFinancementPgpm fipPgpm) {
		this.fipPgpm = fipPgpm;
	}

	public List<TTypeProcedure> getListeProcedures() {
		return listeProcedures;
	}

	public void setListeProcedures(List<TTypeProcedure> listeProcedures) {
		this.listeProcedures = listeProcedures;
	}

	public String getTypProce() {
		return typProce;
	}

	public void setTypProce(String typProce) {
		this.typProce = typProce;
	}

	public boolean isBoutonEdit() {
		return boutonEdit;
	}

	public void setBoutonEdit(boolean boutonEdit) {
		this.boutonEdit = boutonEdit;
	}

	public boolean isBoutonEditPspm() {
		return boutonEditPspm;
	}

	public void setBoutonEditPspm(boolean boutonEditPspm) {
		this.boutonEditPspm = boutonEditPspm;
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


	public List<TAffichagePpm> getPspmValCp() {
		return pspmValCp;
	}


	public void setPspmValCp(List<TAffichagePpm> pspmValCp) {
		this.pspmValCp = pspmValCp;
	}


	public List<TAffichagePpm> getPspmValDmp() {
		return pspmValDmp;
	}


	public void setPspmValDmp(List<TAffichagePpm> pspmValDmp) {
		this.pspmValDmp = pspmValDmp;
	}


	public List<TAffichagePpm> getPpmDifCp() {
		return ppmDifCp;
	}


	public void setPpmDifCp(List<TAffichagePpm> ppmDifCp) {
		this.ppmDifCp = ppmDifCp;
	}


	public List<TAffichagePpm> getPpmDifDmp() {
		return ppmDifDmp;
	}


	public void setPpmDifDmp(List<TAffichagePpm> ppmDifDmp) {
		this.ppmDifDmp = ppmDifDmp;
	}


	public List<TAffichagePpm> getPspmDifCp() {
		return pspmDifCp;
	}


	public void setPspmDifCp(List<TAffichagePpm> pspmDifCp) {
		this.pspmDifCp = pspmDifCp;
	}


	public List<TAffichagePpm> getPspmDifDmp() {
		return pspmDifDmp;
	}


	public void setPspmDifDmp(List<TAffichagePpm> pspmDifDmp) {
		this.pspmDifDmp = pspmDifDmp;
	}
	
		

	public List<VModeleDao> getListeDao() {
		return listeDao;
	}


	public void setListeDao(List<VModeleDao> listeDao) {
		this.listeDao = listeDao;
	}


	public String getTydCode() {
		return tydCode;
	}


	public void setTydCode(String tydCode) {
		this.tydCode = tydCode;
	}


	public List<TPlanPassation> getListPlan() {
		return listPlan;
	}


	public void setListPlan(List<TPlanPassation> listPlan) {
		this.listPlan = listPlan;
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


	public boolean isEtatPsl() {
		return etatPsl;
	}


	public void setEtatPsl(boolean etatPsl) {
		this.etatPsl = etatPsl;
	}


	public boolean isEtatPso() {
		return etatPso;
	}


	public void setEtatPso(boolean etatPso) {
		this.etatPso = etatPso;
	}

	/*
	public TDetailPlanPassation getDatePpm() {
		return datePpm;
	}


	public void setDatePpm(TDetailPlanPassation datePpm) {
		this.datePpm = datePpm;
	}


	public List<TDetailPlanPassation> getAffichPpm() {
		return affichPpm;
	}


	public void setAffichPpm(List<TDetailPlanPassation> affichPpm) {
		this.affichPpm = affichPpm;
	}
*/

	public Date getDateJugement() {
		return dateJugement;
	}


	public void setDateJugement(Date dateJugement) {
		this.dateJugement = dateJugement;
	}


	public Date getDateApp() {
		return dateApp;
	}


	public void setDateApp(Date dateApp) {
		this.dateApp = dateApp;
	}


	public Date getDatePub() {
		return datePub;
	}


	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}


	public List<VDetPlaning> getAffichPpm() {
		return affichPpm;
	}

	public void setAffichPpm(List<VDetPlaning> affichPpm) {
		this.affichPpm = affichPpm;
	}


	public VDetPlaning getDatePpm() {
		return datePpm;
	}

	public void setDatePpm(VDetPlaning datePpm) {
		this.datePpm = datePpm;
	}


	public List<VModePassation> getListeMode() {
		return listeMode;
	}


	public void setListeMode(List<VModePassation> listeMode) {
		this.listeMode = listeMode;
	}


	public String getFiltrePgspm() {
		return filtrePgspm;
	}


	public void setFiltrePgspm(String filtrePgspm) {
		this.filtrePgspm = filtrePgspm;
	}


	public List<VPgpmFonction> getListePgspm() {
		return listePgspm;
	}


	public void setListePgspm(List<VPgpmFonction> listePgspm) {
		this.listePgspm = listePgspm;
	}


	public VPgpmFonction getPgspm() {
		return pgspm;
	}


	public void setPgspm(VPgpmFonction pgspm) {
		this.pgspm = pgspm;
	}


	public VPgpmFonction getRecupPgspm() {
		return recupPgspm;
	}


	public void setRecupPgspm(VPgpmFonction recupPgspm) {
		this.recupPgspm = recupPgspm;
	}


	public String getMultiFiltre() {
		return multiFiltre;
	}


	public void setMultiFiltre(String multiFiltre) {
		this.multiFiltre = multiFiltre;
	}


	public String getPslInf() {
		return pslInf;
	}


	public void setPslInf(String pslInf) {
		this.pslInf = pslInf;
	}


	public String getPslSup() {
		return pslSup;
	}


	public void setPslSup(String pslSup) {
		this.pslSup = pslSup;
	}


	public String getPsoInf() {
		return psoInf;
	}


	public void setPsoInf(String psoInf) {
		this.psoInf = psoInf;
	}


	public String getPsoSup() {
		return psoSup;
	}


	public void setPsoSup(String psoSup) {
		this.psoSup = psoSup;
	}


	public String getStatutTrans() {
		return statutTrans;
	}


	public void setStatutTrans(String statutTrans) {
		this.statutTrans = statutTrans;
	}


	public List<VModeleAmi> getListeAmi() {
		return listeAmi;
	}


	public void setListeAmi(List<VModeleAmi> listeAmi) {
		this.listeAmi = listeAmi;
	}


	public boolean isModeleAmi() {
		return modeleAmi;
	}


	public void setModeleAmi(boolean modeleAmi) {
		this.modeleAmi = modeleAmi;
	}


	public boolean isModeleDao() {
		return modeleDao;
	}


	public void setModeleDao(boolean modeleDao) {
		this.modeleDao = modeleDao;
	}


	public List<THistoPlanPassation> getListeHisto() {
		return listeHisto;
	}


	public void setListeHisto(List<THistoPlanPassation> listeHisto) {
		this.listeHisto = listeHisto;
	}


	public THistoPlanPassation getHistoPpm() {
		return histoPpm;
	}


	public void setHistoPpm(THistoPlanPassation histoPpm) {
		this.histoPpm = histoPpm;
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


	public List<VGenerationDate> getListeDateGenere() {
		return listeDateGenere;
	}


	public void setListeDateGenere(List<VGenerationDate> listeDateGenere) {
		this.listeDateGenere = listeDateGenere;
	}


	public VGenerationDate getGeneDate() {
		return geneDate;
	}


	public void setGeneDate(VGenerationDate geneDate) {
		this.geneDate = geneDate;
	}


	public boolean isBoutonEditUpdate() {
		return boutonEditUpdate;
	}


	public void setBoutonEditUpdate(boolean boutonEditUpdate) {
		this.boutonEditUpdate = boutonEditUpdate;
	}


	public List<VPpmliste> getListePpm() {
		return listePpm;
	}


	public void setListePpm(List<VPpmliste> listePpm) {
		this.listePpm = listePpm;
	}


	public List<VPpmliste> getValidationListe() {
		return validationListe;
	}


	public void setValidationListe(List<VPpmliste> validationListe) {
		this.validationListe = validationListe;
	}

}
