package com.sndi.controller.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAdresseAvis;
import com.sndi.model.TAffichageDao;
import com.sndi.model.TAffichagePgpm;
import com.sndi.model.TAffichagePpm;
import com.sndi.model.TAgpm;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TCandidats;
import com.sndi.model.TCommissionSpecifique;
import com.sndi.model.TCorrectionDac;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDaoAffectation;
import com.sndi.model.TDetCommissionSeance;
import com.sndi.model.TDetailAdresseAvis;
import com.sndi.model.TDetailAgpm;
import com.sndi.model.TDetailCorrection;
import com.sndi.model.TDetailPlanGeneral;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TDetailVente;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TDossierDacs;
import com.sndi.model.TFonction;
import com.sndi.model.TGestion;
import com.sndi.model.THistoDac;
import com.sndi.model.THistoPlanGeneral;
import com.sndi.model.THistoPlanPassation;
import com.sndi.model.TLBudgets;
import com.sndi.model.TLibelleAdresse;
import com.sndi.model.TLotAao;
import com.sndi.model.TModePassation;
import com.sndi.model.TModeReglement;
import com.sndi.model.TNatureDocuments;
import com.sndi.model.TNaturePiece;
import com.sndi.model.TOffrePieceDac;
import com.sndi.model.TPiecesDacs;
import com.sndi.model.TRetrait;
import com.sndi.model.TSeances;
import com.sndi.model.TSoumissions;
import com.sndi.model.TStatut;
import com.sndi.model.TStructure;
import com.sndi.model.TTempParametre;
import com.sndi.model.TTiers;
import com.sndi.model.TTypeCommission;
import com.sndi.model.TTypeDacSpecs;
import com.sndi.model.TTypeMarche;
import com.sndi.model.TTypePieceOffre;
import com.sndi.model.TTypePiecesDac;
import com.sndi.model.TTypeSeance;
import com.sndi.model.TVenteDac;
import com.sndi.model.VAgpmliste;
import com.sndi.model.VAvisAdresse;
import com.sndi.model.VDacliste;
import com.sndi.model.VDaoBailleur;
import com.sndi.model.VDaoChargeEtude;
import com.sndi.model.VDaoStatut;
import com.sndi.model.VDetailAdresse;
import com.sndi.model.VDetailCorrection;
import com.sndi.model.VDetailCorrectionCharge;
import com.sndi.model.VFonctionImputation;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VLigneImputation;
import com.sndi.model.VLigneLot;
import com.sndi.model.VPieceDac;
import com.sndi.model.VPieces;
import com.sndi.model.VPiecesOffreDao;
import com.sndi.model.VPpmDao;
import com.sndi.model.VUpdateDac;
import com.sndi.model.VVenteLot;
import com.sndi.model.VbTempParamVente;
import com.sndi.model.VbTempParametreCorrection;
import com.sndi.model.VbTempParametreLot;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;
import com.sndi.utilitaires.KeyGen;



@Component
@Scope(value="session")
public class DaoController {
	Logger _logger = Logger.getLogger(DaoController.class);
	
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
	 
	 @Autowired
	 ConstantService constantService;
	 
	
	 //listes
	 private List<VDacliste> listeDAO = new ArrayList<VDacliste>();
	 private List<VDacliste> listeDAOTB = new ArrayList<VDacliste>();
	 private List<TDacSpecs> listDao = new ArrayList<TDacSpecs>(); 
	 private List<TGestion> listeGestion = new ArrayList<TGestion>();
	 private List<TAvisAppelOffre> avisTab = new ArrayList<TAvisAppelOffre>(); 
	 private List<TDaoAffectation> daoExamen = new ArrayList<TDaoAffectation>();
	 private List<VDetailCorrection> listeDetailCorrection = new ArrayList<VDetailCorrection>();
	 private List<TTypePiecesDac>listSelectionTypePieces =new ArrayList<TTypePiecesDac>();
	 private List<TDetailPlanPassation> listeDetail = new ArrayList<TDetailPlanPassation>();
	 private List<VLigneLot> listeImputations = new ArrayList<VLigneLot>();
	 private List<TDossierDacs> dossListe = new ArrayList<TDossierDacs>();
	 private List<TDossierDacs> dossDacListe = new ArrayList<TDossierDacs>();
	 private List<VPpmDao> ppmDao = new ArrayList<VPpmDao>();
	 private List<VPpmDao> listSelectionPpmDao = new ArrayList<VPpmDao>();
	 private List<TTypePiecesDac> detailsPieces = new ArrayList<TTypePiecesDac>();
	 private List<TDaoAffectation> listeDaoChargeValid = new ArrayList<TDaoAffectation>();
	 private List<TLotAao> listeLots = new ArrayList<TLotAao>();
	 private List<TLotAao> affichLots = new ArrayList<TLotAao>();
	 private List<VFonctionMinistere> listeFonctions = new ArrayList<VFonctionMinistere>();
	 private List<VPieceDac> listePiecesDao = new ArrayList<VPieceDac>();
	 private List<VFonctionImputation>listSelectionFonctImput =new ArrayList<VFonctionImputation>();
	 private List<TAffichageDao> affectationListe = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> validationListe = new ArrayList<TAffichageDao>();
	 private List <VDaoStatut> daostatutList = new ArrayList<VDaoStatut>();
	//Pieces a examiner
	private List<TDetailCorrection> listeCorrection = new ArrayList<TDetailCorrection>();
	private List<VPieces> listePices = new ArrayList<VPieces>();
	private List<VPiecesOffreDao> offresDao = new ArrayList<VPiecesOffreDao>();
	private VbTempParametreCorrection newCorrection = new VbTempParametreCorrection();
	//Avis 
	private List<TAvisAppelOffre> listAvis = new ArrayList<TAvisAppelOffre>();
	private List<TAffichageDao> examenListe = new ArrayList<TAffichageDao>(); 
	private List<TAffichageDao> listeDao = new ArrayList<TAffichageDao>();
	//GESTION DES ADRESSES
	private List<TLibelleAdresse> listLibelleAdresse = new ArrayList<TLibelleAdresse>();
	private List<TAdresseAvis> listAdresse = new ArrayList<TAdresseAvis>();
	private List<VDetailAdresse> listDetailAdresse = new ArrayList<VDetailAdresse>();
	private List<VAvisAdresse> avisAdresse = new ArrayList<VAvisAdresse>();
	private List<TNatureDocuments> natureDocListe = new ArrayList<TNatureDocuments>();
	//GESTION PIECES OFFRES
	private List<TTypePieceOffre> listePiecesOffres= new ArrayList<TTypePieceOffre>();
	private List<TTypePieceOffre> listeSelectionPiecesOffres= new ArrayList<TTypePieceOffre>();
	 
	//variables
	private long gesCode;
	 private TFonction recupFonction= new TFonction();
	 private TDetailPlanPassation demDetail = new TDetailPlanPassation();
	 private List<TDacSpecs> listeDaoCsvValid = new ArrayList<TDacSpecs>();
	 private VPpmDao daoDetail = new VPpmDao();
	 private TDacSpecs dao= new TDacSpecs();
	 private VDacliste slctdTd = new VDacliste();
	 private TDaoAffectation slctdTda = new TDaoAffectation();
	 private TAvisAppelOffre newAvis = new TAvisAppelOffre();
	 private TLotAao newLot = new TLotAao();
	 private TLotAao lot = new TLotAao();
	 private TDossierDacs selectedDossier = new TDossierDacs();
	 private TDossierDacs doss =new TDossierDacs();
	 private List<TDacSpecs> daoTab = new ArrayList<TDacSpecs>();
	 private TDossierDacs dos =new TDossierDacs(); 
	 private TLotAao selectLot = new TLotAao();
	 private TTempParametre newTemp = new TTempParametre();
	 private VbTempParametreLot newVbTemp = new VbTempParametreLot();
	 private TAvisAppelOffre majAvis = new TAvisAppelOffre();
	 private TCorrectionDac daoCorr = new TCorrectionDac();
	 private VDetailCorrection detailCor = new VDetailCorrection();
	 private VDetailCorrectionCharge detailCharge = new VDetailCorrectionCharge();
	 private VDaoBailleur daoBailleur = new VDaoBailleur();
	 private TDacSpecs newDao = new TDacSpecs();
	 private TDaoAffectation daoAffec = new TDaoAffectation();
	 private TTiers newEntre = new TTiers();
	 private TCandidats newCandidat = new TCandidats();
	 private VbTempParamVente newVbTempVente = new VbTempParamVente();
	 private TVenteDac newVente = new TVenteDac();
	 //private VDonneeCandidat donneeCandidat= new VDonneeCandidat();
	 private TDetailVente venteDetail = new TDetailVente();
	 //GESTION DES PIECES DE L'OFFRE
	 private TTypePieceOffre newPieceOffre = new TTypePieceOffre();
	 private TOffrePieceDac newPieceOffreDac = new TOffrePieceDac();
	//VARIABLES
	 private long adaNum;
	 private String pidCod;
	 private String observation="";
	 private String filtreNcc ="";
	 private String statutRetrait="";
	 private String statutVente="";
	 private short numLibAdr;
	 private short numDetailAdr;
	 private String dtaLibelle;
	 private String affichLog;
	 private String detCom="";
	 private String dacCode ="";
	 private String sitDac ="";
	 private String natPiece ="";
	 private Date ouvTech;
	 private Date ouvFin;
	 private String libelleFournitures ="DAO_Fournitures_et_services_connexes.doc";
	 private String libelleTravaux ="dtao_travaux.doc";
	 private String libellePrestations ="dtao_prestation.doc";
	 private String libelleEntretienLocaux ="dao_ entretien_ des_locaux.doc";
	 private String libelleMainDouevreOcca ="dao_ gestion_de_main_doeuvre_occasionnelle_2016.doc";
	 private String libelleLocationMainDoeuvre ="dao_location_main_doeuvre_ 2016.doc";
	 private String libelleRestauration ="Dao_Restauration.doc";
	 private String libelleSecurite ="dao_securite_privee_ 2016.doc";
	 
	 private VLigneLot ligne = new VLigneLot();
	 private VLigneLot recupLigne = new VLigneLot();
	 
	 private VFonctionMinistere fonction =new VFonctionMinistere();
	 private TAdresseAvis newAdresse = new TAdresseAvis(); 
	 private TDetailAdresseAvis newDtailAdresse = new TDetailAdresseAvis(); 
	 private TLibelleAdresse newLibelleAdresse = new TLibelleAdresse(); 
	 private TRetrait retrait = new TRetrait(); 
	 private TSeances newSeance = new TSeances();
	 private VDaoStatut daostatut= new VDaoStatut();
	 private VFonctionImputation newImput = new VFonctionImputation();
	 private TAffichageDao newAff = new TAffichageDao();
	 private TAffichageDao sltDaoAff = new TAffichageDao();
	 private VDetailAdresse detailAdresse = new VDetailAdresse(); 
	 private TCorrectionDac correction = new TCorrectionDac();
	 private TTiers tiers = new TTiers();
	 private TSoumissions soumission = new TSoumissions();
	 private TSoumissions recupSoumission = new TSoumissions();
	 private TTiers recupTiers = new TTiers();
	 private VVenteLot nbreLot = new VVenteLot();
	 private VUpdateDac updateDac= new VUpdateDac();
	 
	//Booléens
	  private boolean skip;
	  private long natdoc= 7;
	  private long totalMontantLot;
	  private long montantRetrait = 0;
	  private String filtreLigne ="";
	  private String filtreFonction="";
	  private String filterCode="";
	  private String docNature ="";
	  private String nbreDaoTrans ="";
	  private String sit = "";
	  private String resultat = "";
	  private String statutSanction = "";
	  private String statutSanRetour="";
	  private String observationCor ="";
	  private String statutUpdate="";
	  private String choixTaux = "";
	  private String multiFiltre="";
	  private long lotTotal = 0;
	  private long coutLot = 0;
	  private boolean ouvTechnique = true;
	  private boolean btn_save_avis = false;
	  private boolean btn_save_offre = false;
	//Booléen
	  private boolean value1 =true;
	  private boolean etatQualif =false;
	  private boolean etatPV =false;
	  private boolean etatValiderCsv =true;
	  private boolean etatSanction = false;
	  private boolean etatLoveObs = false;
	  private boolean etatBtnValid = false;
	  private boolean etatBtnValidCharge = true;
	  private boolean etatTaux = false;
	  private boolean qualifLabel1 = false;
	  private boolean qualifLabel2 = false;
	  private boolean libelleTaux = false;
	  private boolean etatMtExig = false;
	  private boolean etatVenteLot = false;
	  private boolean etatVenteDao = false;
	  private boolean etatVentePanierLot = false;
	  private boolean etatVentePanierDao = false;
	  private boolean panelAvisBailleur = false;
	  private boolean panelBailleurFichier = false;
	  private boolean etatRecu = false; 
	  private boolean confirmPaie = true;
	  private boolean confirmVente = false;
	  private boolean pavet1 = false;
	  private boolean pavet2 = false;
	  private boolean pavet3 = false;
	  private boolean pavet4 = false;
	  private boolean pavet5 = false;
	  private boolean pavet6 = false;
	  private boolean validCorrection = false;
	  private boolean etatDaoCorrige = false;
	  private boolean btn_affecter = false;
	  private boolean btn_corrige = true;
	 
	 @PostConstruct
	 public void postContr() {
		 controleController.fonctionaliteDynamic();
		 chargeGestions();
		 chargeDaoTabTrans();
		
	 }
	 
	 public String onFlowProcess(FlowEvent event) {
		 System.out.println("etape old= "+event.getOldStep()+" New= "+event.getNewStep());
			//Controle Pavé création
			 if(event.getOldStep().equals("creation") && event.getNewStep().equals("avis")) {
				 if("".equals(daoDetail.getTymCode()) || "".equalsIgnoreCase(daoDetail.getMopCode()) 
						 ||"".equals(daoDetail.getDppObjet()) ) 
				 {
					 FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez terminer votre Saisie, avant de cliquer sur suivant!", ""));
			          return "creation";
					} 
	 
			     }
		            return event.getNewStep();
	    }
	 
	 
	 //Appel de la methode d'affichage de la liste dac en lui passant en parametre letype plan et le type DAC
	 public void chargeData() {
		 if(controleController.type == "DAC" && controleController.typePlan == "PN") {	
			 chargeDataByAction("DAO","PN");
			 }else {
				 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
					 chargeDataByAction("DAO","PS");
				 }else {
					 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
						 chargeDataByAction("AMI","PN");
					 }else {
						 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
							 chargeDataByAction("PRQ","PN");
						 }/*else {
							 if(controleController.type == "DAC" && controleController.typePlan == "PN") {
							 
							 }else {
								 if(controleController.type == "DAC" && controleController.typePlan == "PN") {	
								 }
							 }
						 }*/
					 }
			     } 
			 }
	 }
	 
	//Methode d'affichage la liste des DAC en fonction du type plan et du type DAC passé en parametre
		 public void chargeDataByAction(String typeDac,String typePlan){
			 listeDAO.clear();		 
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
						 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
						 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
						 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				         new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				         multiFiltre ="";
					_logger.info("listeDAO size: "+listeDAO.size());	
					//tableauBordController.chargeDataDao();
					typeActionTb();
					
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
							 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1T","D2R")),
							 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
							 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
					         new WhereClause("LBG_FON_CODE_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					         multiFiltre ="";
						_logger.info("listeDAO size: "+listeDAO.size());	
						typeActionTb();
					 
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
								 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
								 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
								 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
						         multiFiltre ="";
							_logger.info("listeDAO size: "+listeDAO.size());
							typeActionTb();
						
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
									 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
									 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
									 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
							         multiFiltre ="";
								_logger.info("listeDAO size: "+listeDAO.size());
								typeActionTb();
							
						 }else {
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
								 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
										 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D2T","D5R")),
										 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
										 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
								         multiFiltre ="";
									_logger.info("listeDAO size: "+listeDAO.size());
									typeActionTb();
								
							 }else {
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
									 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
											 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
											 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
											 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
									         multiFiltre ="";
										_logger.info("listeDAO size: "+listeDAO.size());
										typeActionTb();
									
								 }
							 }
						 }
					 }
			     } 
			   }
					
		} 
		 
		 
		 public void typeActionTb() {
			 if(controleController.type == "DAC" && controleController.typePlan == "PN") {
	    		 tableauBordController.chargeDataDao("PN","DAO");
			 }else {
				 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
					 tableauBordController.chargeDataDao("PS","DAO");
				 }else {
					 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
						 tableauBordController.chargeDataDao("PN","AMI");
					 }else {
						 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
							 tableauBordController.chargeDataDao("PN","PRQ");
						 }
					 }
			     } 
			   }
		 }
		 
		//Filtre multicritère pour les DAO en Procédure Normale
		 
		 
		 public void chercherDac(String typeDac,String typePlan){
			 listeDAO.clear();		 
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
						 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
						 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
						 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
						 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
				         new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));			 
					_logger.info("listeDAO size: "+listeDAO.size());	
					//tableauBordController.chargeDataDao();
					typeActionTb();
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
							 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1T","D2R")),
							 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
							 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
							 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
					         new WhereClause("LBG_FON_CODE_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("listeDAO size: "+listeDAO.size());	
					 
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
								 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
								 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
								 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
								 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
							_logger.info("listeDAO size: "+listeDAO.size());
						
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
									 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
									 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
									 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
									 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
								_logger.info("listeDAO size: "+listeDAO.size());
							
						 }else {
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
								 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
										 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D2T","D5R")),
										 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
										 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
										 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
									_logger.info("listeDAO size: "+listeDAO.size());
								
							 }else {
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
									 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
											 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
											 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
											 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
										_logger.info("listeDAO size: "+listeDAO.size());
									
								 }
							 }
						 }
					 }
			     } 
			   }
					
		} 
		 
			//ACombobox Gestions
		 public void chargeGestions(){
			 listeGestion=(List<TGestion>) iservice.getObjectsByColumnDesc("TGestion", new ArrayList<String>(Arrays.asList("GES_CODE")));	
		 }
		 //liste des pièces de l'offre
		 
		 public void chargePiecesOffres() {
			 listePiecesOffres= (List<TTypePieceOffre>) iservice.getObjectsByColumn("TTypePieceOffre", new ArrayList<String>(Arrays.asList("TPO_LIBELLE")));			
		 }
		 
		  //Charger la liste des pièces a examiner par le charge d'etude
			 public void chargePiecesByDao() {
				 listePices= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
							new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));			
			 }
			 
			//Charger la liste des offres du DAO p
			 public void chargeOffresByDao() {
				 offresDao= (List<VPiecesOffreDao>) iservice.getObjectsByColumn("VPiecesOffreDao", new ArrayList<String>(Arrays.asList("OPD_NUM")),
							new WhereClause("OPD_DAC_CODE",WhereClause.Comparateur.EQ,""+updateDac.getDacCode()));			
			 }
			 
			 
			//Charger la liste des pièces a examiner par les chargés d'etude
			 public void chargePiecesByCharges() {
				 listePices= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
							new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
			 }
			 
	 
		 //Liste des Dao affectées aux chargés d'etude
		 public void chargeDaoChargeEtude(){
			  daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
					           "DAF_STA_CODE", new ArrayList<String>(Arrays.asList("D3A","DC2")),
					           new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,"DAO"),
					           new WhereClause("DAF_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
				              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
					_logger.info("daoExamen size: "+daoExamen.size());	
					//tableauBordController.chargeDataDao();
					typeActionTb();
			}
		 
		 public void chargeDaoTrans(){
			 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1T","D2R")),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
			              new WhereClause("LBG_FON_CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("listeDaoTrans size: "+listeDAO.size());	
				typeActionTb();	
		}
		 
		 public void chargeDaoTabTrans(){
			 listeDAOTB =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ,"D1T"),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
			              new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())
			              );
				_logger.info("listeTabDaoTrans size: "+listeDAOTB.size());	
				//typeActionTb();		
		}
		 
		 //Liste des DAO différés chez le AC
		 public void chargeDaoTabDiff(){
			 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				          "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1R","D2R")),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
			              new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("listeTabDaoDiff size: "+listeDAO.size());	
				typeActionTb();		
		}
		 
		 //Liste des DAO retirés (Tableau de Bord)
		 public void chargeDaoRetires(){ 
			 listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					   new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ,"RET"),
					   new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					   new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
			           new WhereClause("LBG_FON_CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("listeDaoRetire size: "+listeDAO.size());	
				typeActionTb();		
		}
		 
		 public void priseRecherche() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					listeDAO.clear();
					listeDAO =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
							 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("SBO","SRO")),
							 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
							 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					          new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					          new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
						_logger.info("daoPriseCompte size: "+listeDAO.size());	
						typeActionTb();
					  }
					} 
		 
			//Affichage des DAO validés par la CPMP : Nouvelle Methode
		 public void chargeDaoValide(){
			 listeDAO.clear();
			 listeDAO = (List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D2T"),
					new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("listeDaoValide  size: "+listeDAO.size());	
				typeActionTb();		
		}
		 
		 
		 //Affichage des DAO en attente d'affectation
		 public void chargeDataAffecter(){
			 listeDAO.clear();
			 listeDAO = (List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
					 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D2T","D5R")),
					 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
			         //new WhereClause("AFF_FON_CODE_DMP", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("affectationListe  size: "+listeDAO.size());	
				typeActionTb();			
		}
		 
			//Affichage des DAO validé par le Chef de Service
		 public void chargeDataValCsv(){ 
			// listeTabdaoValCsv
			 listeDAO = (List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
					 new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D5V"),
					 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
				_logger.info("listeTabdaoValCsv  size: "+listeDAO.size());		
				typeActionTb();	
		}
		 
		//Affichage des DAO différé par le Chef de Service : Nouvelle Methode
		 public void chargeDataDiffCsv(){
			 //listeTabdaoDiffCsv
			 listeDAO = (List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
					 new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D5R"),
					 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN")
					//new WhereClause("DAC_FON_CODE_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())
					);
				_logger.info("listeTabdaoDiffCsv  size: "+listeDAO.size());	
				typeActionTb();	
		}
		 
		 public void chargeDaoCsvValid(){ 
			 //listeDaoCsvValid.clear();
			 listeDAO.clear();
			 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D5V","D6V")),
					  new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					  new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
			          new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("listeDaoCsvValid size: "+listeDAO.size());	
				typeActionTb();	
		}
		 
		  public void chargeDossier() {
		 		 dossListe.clear();
		 			 dossListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getDacCode())));			
		 	 } 
		  
		  public void chargeDossierCharge() {
		    	 dossDacListe.clear();
		    	 dossDacListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTda.getDafDacCode())));			
		 	 } 
		  
		  //Appel de la methode de retour de nature document en lui passant en parametre le type dac
		  public void chargeNatureDocTrans() {
			  if(controleController.type == "DAC") {
				  natureDoc("DAO");
				 }else {
					 if(controleController.type == "AMI") {
						 natureDoc("AMI");
					 }else {
						 if(controleController.type == "PRQ") {
							 natureDoc("PRQ");
						 }
				     } 
				  }	
			}
		     
		  //Methode pour Retourner la liste des natures de documents en fonction du type DAC passé en parametre
		  public void natureDoc(String typeNat) {
			  natureDocListe.clear();
				natureDocListe = ((List<TNatureDocuments>)iservice.getObjectsByColumn("TNatureDocuments",new ArrayList<String>(Arrays.asList("nadCode")),
					    new WhereClause("NAD_TYPE",Comparateur.EQ,""+typeNat)));
			 }
		     
		//Methode de chargement
			 @Transactional
			 public void uploadBailleur(FileUploadEvent event) throws IOException{
				 if(slctdTd.getDacAvisBailleur().equalsIgnoreCase("") || "".equals(slctdTd.getDacAvisBailleur()) || slctdTd.getDacDateAvisBailleur() == null ) 
				   {
					//Message d'erreur
					   FacesContext.getCurrentInstance().addMessage(null,
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir les informations du Bailleur avant de joindre un fichier", "")); 
				   }else {
					 //condition de chargement d'un document : Nature sélectionnée 
						 if((docNature == null || "".equals(docNature))){
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sélectionnée pour le chargement! ","");
							FacesContext.getCurrentInstance().addMessage(null, msg);	
							 
							 }else {
						
						      if(fileUploadController.handleFileUpload(event, ""+slctdTd.getDacCode(), docNature)) {
							
							listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
									new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
				 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
				 				if (!listDao.isEmpty()) {
				 					newDao= listDao.get(0);
				 	   	                 }
							
							int nat = Integer.valueOf(docNature);
							//check le dossier s'il existe à faire
							//TDossierDacs dos =new TDossierDacs(); //TDossiersDacs
							dos.setDdaCommentaire(keyGen.getCodeDossier(fileUploadController.getFileCode()+"-")); 
							dos.setTDacSpecs(newDao);
							List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
							TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
							if(!LS.isEmpty()) natureDoc = LS.get(0);
							dos.setTNatureDocuments(natureDoc);
							dos.setDdaNom(fileUploadController.getFileName());
							dos.setDdaDteSaisi(Calendar.getInstance().getTime());
							dos.setDdaReference(fileUploadController.getDocNom());
							iservice.addObject(dos);
			               //Chargement des dossiers du DAO
							chargeDossier(); 
							//Message de confirmation
							FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectué avec succés!", "");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						     chargeDossier();
							}else {
								FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger à nouveau un document ! ","");
								FacesContext.getCurrentInstance().addMessage(null, msg);	
								
							}
						  }
				     }	
		        }
			  @Transactional
				public void upload(FileUploadEvent event) throws java.io.FileNotFoundException { 
				 //condition de chargement d'un document : Nature sélectionnée 
				 if((docNature == null || "".equals(docNature))){
					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sélectionnée pour le chargement! ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
					 
					 }else {
				
				if(fileUploadController.handleFileUpload(event, ""+slctdTd.getDacCode(), docNature)) {
					
					listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		 				if (!listDao.isEmpty()) {
		 					newDao= listDao.get(0);
		 	   	                 }
					
					int nat = Integer.valueOf(docNature);
					//check le dossier s'il existe à faire
					//TDossierDacs dos =new TDossierDacs(); //TDossiersDacs
					dos.setDdaCommentaire(keyGen.getCodeDossier(fileUploadController.getFileCode()+"-")); 
					dos.setTDacSpecs(newDao);
					List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
					TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
					if(!LS.isEmpty()) natureDoc = LS.get(0);
					dos.setTNatureDocuments(natureDoc);
					dos.setDdaNom(fileUploadController.getFileName());
					dos.setDdaDteSaisi(Calendar.getInstance().getTime());
					dos.setDdaReference(fileUploadController.getDocNom());
					iservice.addObject(dos);
					
					//chargeNatureDocTrans();
					chargeDossier();
					
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectué avec succés!", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				   chargeDossier();
					}else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger à nouveau un document ! ","");
						FacesContext.getCurrentInstance().addMessage(null, msg);	
						
					}
				  }
				}
		       //Fin Upload
			 
			//Methode Transmettre
			 public void transmettre() {	        	
			        	if(dos.getDdaNom()==null || dos.getDdaReference() == null ) {
			        		//Message d'erreur
					          FacesContext.getCurrentInstance().addMessage(null,
				      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez joindre votre fichier ou choisir la mention avant Transmission du DAO", ""));
			        	      }else { 
			        		         
			       			          listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
			       					      new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
			       				             if (!listDao.isEmpty()) {
			       					                 newDao= listDao.get(0);
			                                         newDao.setDacDateValAc(Calendar.getInstance().getTime());
			       					                 newDao.setTStatut(new TStatut("D1T"));
			       					                 newDao.setDacStatutRetour("0");
			       					                 newDao.setDacMention(slctdTd.getDacMention());
			       			                         iservice.updateObject(newDao); 
			       			                         
			       			                      //Récupération du Statut
						 						        TStatut statuts = constantService.getStatut("D1T");
						 							  	//Historisation du / des retraits
						 							    //historiser("D1T",newDao,"DAO transmit par l'Autorité Contractante");
						 							  
						 				       			  //Histo Dac
						 				       					THistoDac dac=new THistoDac();
						 				       					dac.setHacDate(Calendar.getInstance().getTime());
						 				       					dac.setHacCommentaire("DAO transmit par l'Autorité Contractante");
						 				       					dac.setTDacSpecs(newDao);
						 				       					dac.setTFonction(userController.getSlctd().getTFonction());
						 				       					dac.setTOperateur(userController.getSlctd().getTOperateur());
						 				       					dac.setTStatut(statuts);
						 				       					iservice.addObject(dac);
			       	   	                           } 
			       				
			       					chargeData();
			       					
			       					//chargeDaoTrans();
			       					
			       					//chargeDaoTabTrans();
			       					//Actualisation du tableau de bord
			       					typeActionTb();
			       					//Message de confirmation
			       					userController.setTexteMsg("Transmission effectuée avec succès!");
			   						userController.setRenderMsg(true);
			   						userController.setSevrityMsg("success");
			        	         }
			                  }

		 
		     
		     //Supprimer un dao joint
		    public void removeDossier(){
			downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaReference(), selectedDossier.getDdaReference());
				 iservice.deleteObject(selectedDossier);
				 
				 chargeDossier();	
				 
			    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDdaReference()+" supprimé!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
			}
		     
		     
		 
		 		 
	//Statistiques pour le chargé d'Etudes
			 
			/*//Affichage des DAO en attente chez le C.E
			 public void chargeDataChargeAtt(){ 
			 listDaoValCharge = (List<VDaoChargeEtude>) iservice.getObjectsByColumn("VDaoChargeEtude", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
						 new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D3A"),
						 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
						 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
						 new WhereClause("DCS_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
						new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
					_logger.info("listDaoValCharge  size: "+listDaoValCharge.size());	
					tableauBordController.chargeDataDao();		
			}*/
			 
			/* 
			//Affichage des DAO validé par le C.E
			 public void chargeDataChargeVal(){
			 listDaoValCharge = (List<VDaoChargeEtude>) iservice.getObjectsByColumn("VDaoChargeEtude", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
						 new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D4V"),
						 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
						 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
						 new WhereClause("DCS_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
						new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
					_logger.info("listDaoValCharge  size: "+listDaoValCharge.size());	
					tableauBordController.chargeDataDao();		
			}*/
			 
			/*//Affichage des DAO validés par le C.E
			 public void chargeDataChargeValid(){
				 //listeDaoChargeValid.clear();
				 listeDaoChargeValid = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")), 
						 new WhereClause("DAF_STA_CODE",WhereClause.Comparateur.EQ,"D4V"),
						 new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,"DAO"),
						 new WhereClause("DAF_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
						 new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
						new WhereClause("DAF_DAC_STR",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
					_logger.info("listeDaoChargeValid  size: "+listeDaoChargeValid.size());	
					tableauBordController.chargeDataDao();		
			    }*/
		 
	//Fin de Staistiques pour le chargé d'Etudes 
		 
		 
		//Statistiques pour le chef de Service
			 //Affichage des DAO en Attente d'Affectation
			 public void chargeDaoAttCsv(){ 
				 listeDAO.clear();
				 listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					              new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D2T"),
					              new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					              new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					              new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				 //listeTabDaoAffecCsv
				}
		
				//Affichage des DAO différés par la CPMP : Nouvelle Methode
			 public void chargeDaoDiff(){
				 //listeDaoDiff.clear();
				listeDAO.clear();
				 listeDAO = (List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
						new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D1R"),
						new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
						new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
						new WhereClause("LBG_FON_CODE_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					_logger.info("listeDaoDiff  size: "+listeDAO.size());	
					typeActionTb();		
			}
		 
		    //Premier enregistrement DAC en fonction du type et du plan
		    public void saveDao(){	
		    	 if(controleController.type == "DAC" && controleController.typePlan == "PN") {
		    		 saveDac("PN","DAO");	
				 }else {
					 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
						 saveDac("PS","DAO"); 
					 }else {
						 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
							 saveDac("PN","AMI");
						 }else {
							 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
								 saveDac("PN","PRQ");
							 }/*else {
								 if(controleController.type == "DAC" && controleController.typePlan == "PN") {
								 
								 }else {
									 if(controleController.type == "DAC" && controleController.typePlan == "PN") {	
									 }
								 }
							 }*/
						 }
				     } 
				   }
		 		 /*  if(controleController.type == "DAC" && controleController.typePlan == "PN") {
		 			  saveDac("PN","DAO");
	              }else 
	                   if(controleController.type == "AMI"){
	                 	  saveDac("PN","AMI"); 
	                   }*/
		     }
		    
		//Initiation du DAO en procédure normale 
	     @Transactional
	     public void saveDac(String typePlan,String typeDac) {
	    	 if(daoDetail.getTymCode().equalsIgnoreCase("") || "".equals(daoDetail.getTymCode()) || daoDetail.getMopCode().equalsIgnoreCase("") || "".equalsIgnoreCase(daoDetail.getMopCode()) 
	    			 || daoDetail.getDppObjet().equalsIgnoreCase("") || "".equals(daoDetail.getDppObjet()) ) {
	    		 //Message d'Erreur
	    		 FacesContext.getCurrentInstance().addMessage(null,
		         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez sélectionnez votre PPM, puis faites OK!", ""));
	    	 }else {
	    		 daoTab = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
	    			     new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
	    	 if (!daoTab.isEmpty()) {
					dao = daoTab.get(0);
					iservice.updateObject(dao);
					
					userController.setTexteMsg(typeDac+"N ° "+dao.getDacCode()+" mis à jour avec succès!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");
					
			    }else {
			    	
		 			    //Insertion des pièces constitutives du DAO 
		 			     if(listSelectionTypePieces.size()==0) {
		 						FacesContext.getCurrentInstance().addMessage(null,
		 						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
		 					}
		 			 		else{
		 			 			String gestion =String.valueOf(gesCode).substring(2,4);
		 			 			//geste=gest.substring(-2);
		 			 			String exo=gestion+daoDetail.getStrTstCode()+daoDetail.getDppTymCode()+daoDetail.getMopCode();
		 				    	 dao.setDacCode(keyGen.getCodeDao(exo));
		 				    	 dao.setDacStatutRetour("0");
		 				    	 dao.setDacObjet(daoDetail.getDppObjet());
		 				    	 dao.setTStatut(new TStatut("D1S"));
		 				    	 dao.setTModePassation(new TModePassation(daoDetail.getMopCode()));
		 				    	 dao.setTTypeMarche(new TTypeMarche(daoDetail.getDppTymCode()));
		 				    	 dao.setTStructure(userController.getSlctd().getTFonction().getTStructure());
		 				    	 dao.setDacDteSaisi(Calendar.getInstance().getTime());
		 				    	 dao.setTFonctionByDacFonCodAc(userController.getSlctd().getTFonction());
		 				    	 dao.setTGestion(new TGestion(gesCode));
		 				    	 dao.setTTypeDacSpecs(new TTypeDacSpecs(""+typeDac));
		 				    	 dao.setDacTypePlan(""+typePlan);
		 				    	 dao.setDacBailleur(daoDetail.getDppBailleur());
		 				    	 iservice.addObject(dao);
                                //Recherche
		 				         String search = dao.getTGestion().getGesCode()+""+dao.getDacCode()+""+dao.getDacObjet()+""+dao.getDacTypePlan()+""+dao.getTModePassation().getMopCode()+""+dao.getTTypeMarche().getTymCode();
		 						 String rechercheAll = search.replace("null","");
		 						 dao.setDacRecherche(rechercheAll);
		 						 iservice.updateObject(dao);
		 				         
		 				         
		 				    	 listeDetail =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
		 									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+daoDetail.getDppId()));
		 								if (!listeDetail.isEmpty()) {
		 									demDetail= listeDetail.get(0);
		 									demDetail.setDppStatutDao("O");
		 									demDetail.setTDacSpecs(new TDacSpecs(dao.getDacCode()));
		 									iservice.updateObject(demDetail);
		 							      }
		 								
		 			 			
		 			 			   for(TTypePiecesDac n : listSelectionTypePieces) {
		 			 	    		 TPiecesDacs det = new TPiecesDacs();
		 			 	    		   det.setPidDteSaisi(Calendar.getInstance().getTime());
		 			 	    		   det.setPidStaCode("D1S");
		 			 	    		   det.setPidLibelle(n.getTpiLibelle());
		 			 	    		   det.setTDacSpecs(dao);
		 			 	    		   det.setTTypePiecesDac(new TTypePiecesDac(n.getTpiCode()));
		 			 	    		   iservice.addObject(det);
		 			 	    	       }
		 			 			   
		 			 			    //Historisation   
		 			 			   historiser("D1S",dao,"Initiation du "+typeDac+" par une Autorité Contractante");
		 			 			 
		 			 			   //Affichage de la liste DAC en fonction type plan et du type DAC
		 			 		
		 						     
		 						     //chargePPM();
		 						     //Actualisation du tableau de Bord
		 						     //tableauBordController.chargeDataDao();
		 			 			typeActionTb();
		 						     
		 						     userController.setTexteMsg(typeDac+" N° "+dao.getDacCode()+" Initié avec succès!");
		 							 userController.setRenderMsg(true);
		 							 userController.setSevrityMsg("success");
		 							 
		 							 newAvis.aaoLibelle = dao.getDacObjet();
		 							 //Désactivation du bouton d'enregistrement du DAO
		 							 controleController.btn_dao_pn = false;
		 							 //Activation du Bouton d'enregistrement d'un Avis d'Appel d'Offres
		 							  btn_save_avis = true;
		 							  verifOuverture();
		 							  chargeImputation();
		 			   }
			    	
			    					//Insertion des pièces
			          }
	    	        }
	          }
	     
	 	//Methode d'historisation
		 public void historiser(String statut,TDacSpecs TDacSpecs, String motif) {
			     TStatut statuts = constantService.getStatut(statut);
			     THistoDac dacStatut = new THistoDac();
			     dacStatut.setHacDate(Calendar.getInstance().getTime());
			     dacStatut.setHacCommentaire(motif);
			     dacStatut.setTStatut(statuts);
			     dacStatut.setTDacSpecs(dao);
			     dacStatut.setTFonction(userController.getSlctd().getTFonction());
			     dacStatut.setTOperateur(userController.getSlctd().getTOperateur());
			     iservice.addObject(dacStatut);
		 }
		 
		 
		//Avis
	   	 //Création de l'Avis
		 
		 public void saveAvis() { 
	    	 if(controleController.type == "DAC" && controleController.typePlan == "PN") {	
	    		 saveAao("PN","DAO");
			 }else {
				 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
					 saveAao("PS","DAO"); 
				 }else {
					 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
						 saveAao("PN","AMI");
					 }else {
						 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
							 saveAao("PN","PRQ");
						 }
					 }
			     } 
			   } 
		 }
	        @Transactional
	        public void saveAao(String typePlan ,String typeDac) {
	        	
	        	if(newAvis.getAaoLibelle().equalsIgnoreCase("") || "".equals(newAvis.getAaoCoutDac()) || "".equals(newAvis.getAaoNbrLot())
	        			|| "".equals(newAvis.getAaoDelaiVal()) ) { 
	        		
	        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez remplir tous les champs obligatoires! ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);
	        		
	        	    }else {
	        	    	avisTab = (List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DAC_CODE")),
	        					new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
	            	       if (!avisTab.isEmpty()) {
	            	    	      newAvis = avisTab.get(0);
	        				      iservice.updateObject(newAvis);
	            	            }else { 
	            	            	      newAvis.setAaoCode(keyGen.getCodeAvis());
	            	          		      newAvis.setTDacSpecs(dao);
	            	          		      newAvis.setTAdresseAvis(new TAdresseAvis(numDetailAdr)); 
	            	          		      if(newAvis.aaoNbrOuv == 1) {
	            	            		  newAvis.setAaoDteOuvFin(ouvTech);
	              	          		      newAvis.setAaoDteOuvTec(ouvTech);
	            	            		  }else {
	            	            		  newAvis.setAaoDteOuvFin(ouvFin);
	                	          		  newAvis.setAaoDteOuvTec(ouvTech);
	            	            		  }
	            	          		      newAvis.setTStatut(new TStatut("D1S"));
	            	          		      newAvis.setFonCodAc(userController.getSlctd().getTFonction().getFonCod());
	            	          		      iservice.addObject(newAvis); 
	            	          		   
	            	          		   
	            	          		   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
	            	          				 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
	            	          				 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
	            	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
	            	     				   if (!listDao.isEmpty()) {
	            	     					    newDao= listDao.get(0);
	            	     					    newDao.setDacCout(newAvis.getAaoCoutDac());
	            	     			            iservice.updateObject(newDao); 
	            	     	   	                 }

	            	          		            
	                	     				    //Message de confirmation
	            	          		            userController.setTexteMsg("Avis d'Appel d'Offre crée avec succès!");
	            	          		            userController.setRenderMsg(true);
	            	          		            userController.setSevrityMsg("success");
	            	          		            
	            	          		        //Désactivation du bouton enregistrerAvis
	                	     				    btn_save_avis =false;
	                	     				//Activation du bouton d'enregistrement des offres
	                	     				    btn_save_offre = true;
	            	                  }
	        	                   } 
	                     }
	     
	 	//Contôle sur le nombre d'ouverture
	 	public void verifOuverture() {
	 		if(newAvis.aaoNbrOuv == 2) {
	 			ouvTechnique = true;
	 			
	 		  }else {
	 			  ouvTechnique = false;
	 			  
	 		}
	 	}
	
	 	//Affichage des DAO validés par le C.E
		 public void chargeDataChargeValid(){
			 //listeDaoChargeValid.clear();
			 listeDaoChargeValid = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")), 
					 new WhereClause("DAF_STA_CODE",WhereClause.Comparateur.EQ,"D4V"),
					 new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("DAF_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					 new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
					new WhereClause("DAF_DAC_STR",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
				_logger.info("listeDaoChargeValid  size: "+listeDaoChargeValid.size());	
				typeActionTb();		
		    }
	 	//Chargement des imputations ou lignes budgétaires pour le AC
		  public void chargeImputation() { 
			 listeImputations.clear();
			 listeImputations =(List<VLigneLot>) iservice.getObjectsByColumn("VLigneLot", new ArrayList<String>(Arrays.asList("LBG_CODE")),
					 new WhereClause("DPP_DAC_CODE",Comparateur.EQ,""+dao.getDacCode())); 
				} 
		  
		//Chargement des PPM n'ayant pas fait l'objet d'un DAO
			 public void chargePPM(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
							new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));	
				 multiFiltre="";
			 }
			 
			 public void chargeRecherchePPM(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
							new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
						    new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%")));		 		 
			 }
			 
			  //Rappel des informations du PPM
		     public void renseignerDao() throws IOException{
		                 	if (listSelectionPpmDao.size()==0) {
		            				FacesContext.getCurrentInstance().addMessage(null,
		            						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun PPM selectionné", ""));
		            			}
		            	 		else{
		            	 			//Parcourir la liste de sélection listSelectionPpmDao
		            		 		for(VPpmDao ligne : listSelectionPpmDao) {
		            		 			 
		            		 			//Parcourir la liste et récupére
		            		 			 ppmDao =(List<VPpmDao>) iservice.getObjectsByColumn("VPpmDao", new ArrayList<String>(Arrays.asList("DPP_ID")),
		            								new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+ligne.getDppId()));
		            							if (!ppmDao.isEmpty()) {
		            								daoDetail= ppmDao.get(0);
		            	            		 		detailsPieces =(List<TTypePiecesDac>) iservice.getObjectsByColumn("TTypePiecesDac", new ArrayList<String>(Arrays.asList("TPI_CODE")),
		            	    								     new WhereClause("TPI_MDT_CODE",WhereClause.Comparateur.EQ,""+daoDetail.getMdtCode()));	
		            						 }
		            			 		   }
		            				   }       
		                            }
		     
		     public void filtreFonctionMin() {
		    	 listeFonctions.clear();
					 listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
								"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM")),
								new WhereClause("FON_COD",WhereClause.Comparateur.LIKE,"%"+filtreFonction+"%"),
								new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				}
		     
		   //GESTION DES ADRESSES
				//Liste des libellé
				  public void chargeLibelleAdresse() { 
					  listLibelleAdresse.clear();
					  listLibelleAdresse =(List<TLibelleAdresse>) iservice.getObjectsByColumn("TLibelleAdresse", new ArrayList<String>(Arrays.asList("LIA_NUM")));
				   }
				  
				  //Liste des Adresses
				  public void chargeLibeAdresse() { 
					  listLibelleAdresse.clear();
					  listLibelleAdresse =(List<TLibelleAdresse>) iservice.getObjectsByColumn("TLibelleAdresse", new ArrayList<String>(Arrays.asList("LIA_NUM")));
				  }
				  
				  
				  public void chargeAdresse() { 
					  listAdresse.clear();
					  listAdresse =(List<TAdresseAvis>) iservice.getObjectsByColumn("TAdresseAvis", new ArrayList<String>(Arrays.asList("ADA_NUM")));
				  }
				  
				  //Detail Adresse modification
				  public void chargeDetailAdresseDac() { 
					  listDetailAdresse.clear();
					  listDetailAdresse =(List<VDetailAdresse>) iservice.getObjectsByColumn("VDetailAdresse", new ArrayList<String>(Arrays.asList("V_ID")),
							  new WhereClause("ADA_FON_COD",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
							  new WhereClause("ADA_NUM",Comparateur.EQ,""+updateDac.getAdaNum())); 
				  }
				  
				  //Detail Adresse
				  public void chargeDetailAdresse() { 
					  listDetailAdresse.clear();
					  listDetailAdresse =(List<VDetailAdresse>) iservice.getObjectsByColumn("VDetailAdresse", new ArrayList<String>(Arrays.asList("V_ID")),
							  new WhereClause("ADA_FON_COD",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
							  new WhereClause("ADA_NUM",Comparateur.EQ,""+numDetailAdr)); 
				  }
				  
				//Enregistrement d'une adresse
				  public void saveAdresse() {
					newAdresse.setTFonction(userController.getSlctd().getTFonction());
					iservice.addObject(newAdresse); 
					chargeAdresse();
					userController.setTexteMsg("Enregistrement effectué avec succès!");
				    userController.setRenderMsg(true);
					userController.setSevrityMsg("success");
				  }
				  
				  
				  
				  public void saveDetailAdresse() {
						 if(newAdresse.getAdaNum()>0) {
							 newDtailAdresse.setTAdresseAvis(new TAdresseAvis(numDetailAdr));
							 newDtailAdresse.setTLibelleAdresse(new TLibelleAdresse(numLibAdr)); 
							 iservice.addObject(newDtailAdresse); 
							 chargeDetailAdresse();
						  }else {
							  FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sélectionnez le type d'adresse!", ""));
						  }
						
					  }
				
				  // DEBUT GESTION DES LOTS
				  
				//GESTION DES MODIFICATIONS
				  public void chargePiecesDao() {
						 listePiecesDao.clear();
						 listePiecesDao= ((List<VPieceDac>)iservice.getObjectsByColumn("VPieceDac",new ArrayList<String>(Arrays.asList("PID_LIBELLE")),
								    new WhereClause("PID_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())));
					 }
				  
				  //Chargement des PPM n'ayant pas fait l'objet d'un DAO
					 public void chargePPM() {
						 ppmDao.clear();
						 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
								    new WhereClause("DPP_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())));
					 }
					 
					  public void chargeDetailAdresseModif() { 
						  listDetailAdresse.clear();
						  listDetailAdresse =(List<VDetailAdresse>) iservice.getObjectsByColumn("VDetailAdresse", new ArrayList<String>(Arrays.asList("V_ID")),
								  new WhereClause("ADA_FON_COD",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
								  new WhereClause("ADA_NUM",Comparateur.EQ,""+slctdTd.getAaoAdaNum())); 
					  }
					  
					  public void chargeLotsUpdate(){
							 //getListeDAO().clear();
							 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
									 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
								_logger.info("objetListe size: "+listeLots.size());		
						}
					  
				//FIN GESTION DES MODIFICATIONS
				  
				  public void chargeLots(){
						 //getListeDAO().clear();
						 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_ID")), 
								 new WhereClause("LAA_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
								 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
							_logger.info("listeLots size: "+listeLots.size());	
							
							lotTotal = getNbreLotTotal();
					}
				   
				  
				   //le nombre de lots pour cet avis en cours
				   public int getNbreLotTotal(){ 
						int i = iservice.countTableByColumn("T_LOT_AAO", "LAA_ID",
								new WhereClause("LAA_AAO_CODE", WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
						return	i;	
					}
				   
				   public void chargeLotsDac(){
						 //getListeDAO().clear();
						 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
								 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+updateDac.getAaoCode()));
							_logger.info("objetListe size: "+listeLots.size());		
					}
				   
				   
				   public void chargeLotsRappel(){
						 getListeLots().clear();
						 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
								 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
							_logger.info("objetListe size: "+listeLots.size());	
					}
				  
				  //Methode de Génération des Lots   
				     public void genererLot() {  
				    	 if(newAvis.getAaoNbrLot() > lotTotal) {
				    		 newVbTemp.setTempLaaAaoCode(newAvis.getAaoCode());
				        	 newVbTemp.setTempLaaDacCode(dao.getDacCode());
				    		  newVbTemp.setTempLaaDteSaisi(Calendar.getInstance().getTime());
				    		  newVbTemp.setTempLaaMtLot("0");
				    		  newVbTemp.setTempLaaNbrTotLot(String.valueOf(newAvis.getAaoNbrLot()));//Convertir un long en String
				    		  newVbTemp.setTempOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
				    		  newVbTemp.setTempType("LOT");
				    		  iservice.addObject(newVbTemp);
				    		  chargeLots();
				    		  userController.setTexteMsg("Lot(s) généré(s) avec succès!");
				    		  userController.setRenderMsg(true);
				    		  userController.setSevrityMsg("success");
				    		
				    	 }else {
				    		 /*userController.setTexteMsg("Veuillez respecter le nombre de lots renseigné !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");*/
							 
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseigné ! ","");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
				    	 }
				    	 
					  }
				     
				     //Ajouter manuellement un lot
					 @Transactional
				    public void saveLot(){
				    	  //getNbreLotTotal();
				    	 if(newAvis.getAaoNbrLot() > lotTotal) {
				    		 newLot.setTDacSpecs(dao);
				    		 newLot.setLaaOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
				    		 newLot.setLaaDteSaisi(Calendar.getInstance().getTime());
				    		 newLot.setLaaCoutLot(coutLot);
				    		 newLot.setTAvisAppelOffre(newAvis);
				        	 iservice.addObject(newLot);
				        	 chargeLots();
				        	 newLot = new TLotAao();
				        	 userController.setTexteMsg("Lot enregistré avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
				    		 
				    	 }else {
				    		
				    		/* userController.setTexteMsg("Veuillez respecter le nombre de lots renseigné !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");*/
							 
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseigné ! ","");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
				    	 }
					}
					 
					 //Mis à jour du libellé de lot
				        public void updateLibLot() {
				        	     lot.setLaaObjet(lot.getLaaObjet());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				        //Mis à jour du montant de la caution du lot
				        public void updateMtCautLot() {
				        	     lot.setLaaMtCaut(lot.getLaaMtCaut());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				      //Mis à jour du montant estimatif de la caution du lot
				        public void updateMtEstLot() {
				        	     lot.setLaaMtEst(lot.getLaaMtEst());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				        //sppression de lot
				   	 public void removeLot() {
				   		 System.out.print("+-------------+ "+getSelectLot().getLaaNum());
				   		 try {
				   			 iservice.deleteObject(getSelectLot());
				   				chargeLots();
				   				userController.setTexteMsg("Suppression effectuée avec succès !");
				   				userController.setRenderMsg(true);
				   				userController.setSevrityMsg("success");

				   		 } catch (org.hibernate.exception.ConstraintViolationException e) {
				   			 userController.setTexteMsg("Impossible de supprimer le lot !");
				   			 userController.setRenderMsg(true);
				   			 userController.setSevrityMsg("danger");	 
				   		 }
				   	 }
				   	 
				   	 public void onSelectLigneBudgetaire() {
				         newLot.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
				         
						 //recupLigne = new VLigneImputation();
						 recupLigne = new VLigneLot();
						 recupLigne.setLbgAeDon(ligne.getLbgAeDon());
						 recupLigne.setLbgAeEmp(ligne.getLbgAeEmp());
						 recupLigne.setLbgAeTr(ligne.getLbgAeTr());
						 recupLigne.setLbgAnoCode(ligne.getLbgAnoCode());
						 recupLigne.setLbgCode(ligne.getLbgCode());
						 recupLigne.setLbgDesCode(ligne.getLbgDesCode());
						 recupLigne.setLbgDisDon(ligne.getLbgDisDon());
						 recupLigne.setLbgDisEmp(ligne.getLbgDisEmp());
						 recupLigne.setLbgDisTot(ligne.getLbgDisTot());
						 recupLigne.setLbgDisTre(ligne.getLbgDisTre());
						 recupLigne.setLbgDteVal(ligne.getLbgDteVal());
						
						 recupLigne.setLbgNatCode(ligne.getLbgNatCode());
						 recupLigne.setLbgImputation(ligne.getLbgImputation());
						 recupLigne.setLbgGesCode(ligne.getLbgGesCode());
						 recupLigne.setLbgResDon(ligne.getLbgResDon());
						 recupLigne.setLbgResEmp(ligne.getLbgResEmp());
						 recupLigne.setNatLibelle(ligne.getNatLibelle());
						 selectLot.setTLBudgets(new TLBudgets(ligne.getLbgCode()));

						 iservice.updateObject(getSelectLot());
						 chargeLots();
						 
							}
				     
				        
				      //FIN GESTION DES LOTS
				  
				  
				   	 
				   	 //enregister la liste des pièces du dao
				     public void savePieceOffres() {
				    		if (listeSelectionPiecesOffres.size()==0) {
								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
							}
					 		else{
						 		 for(TTypePieceOffre ligne : listeSelectionPiecesOffres) {
						 			newPieceOffreDac.setOdpDteSaisi(Calendar.getInstance().getTime());
						 			newPieceOffreDac.setOdpOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
						 			newPieceOffreDac.setOdpTpoEtapPiece("Ouverture");
						 			newPieceOffreDac.setTDacSpecs(dao);
						 			newPieceOffreDac.setTTypePieceOffre(ligne.getTpoCode());
						 			iservice.addObject(newPieceOffreDac);
							     }
						 		userController.setTexteMsg("Pièces enrégistrée(s) avec succès!");
								userController.setRenderMsg(true);
								userController.setSevrityMsg("success");
								//Désactivation du Bouton d'Enregistrement
								btn_save_offre = false;
					 		 }

				      }
				 //Methode de récupération de l'adresse
				  public void observationAdresse() {
					  avisAdresse = (List<VAvisAdresse>) iservice.getObjectsByColumn("VAvisAdresse", new ArrayList<String>(Arrays.asList("V_ID")),
								new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
				  }
				  
				  //Récupération de l'avis et son Adresse
				  public void observationAvis() { 
					  avisTab = (List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DAC_CODE")),
								new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
					       if (!avisTab.isEmpty()) {
					    	      newAvis = avisTab.get(0);
					    	      observationAdresse();
					            }	    
				          }
				
				  //modification de l'avis du DAO en prise en compte des observations 
				  @Transactional
				  public void modifAvis() {
					 iservice.updateObject(newAvis); 
					 
					 //Message de confirmation
					 userController.setTexteMsg("Avis d'Appel d'offres mis à jour avec succès!");
				     userController.setRenderMsg(true);
					 userController.setSevrityMsg("success");
				  }
				 
				  //modification du DAO en prise en compte des observations
				  @Transactional
				  public void modifDao() {
					    iservice.updateObject(slctdTd);
					    
					    listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
								new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
					       if (!listDao.isEmpty()) {
					    	      newDao = listDao.get(0);
					    	      iservice.updateObject(newDao);
					            }	
					  
					    //Chargement des compteurs du tableau de bord	
						//Message de confirmation
						userController.setTexteMsg("DAO mis à jour avec succès!");
						userController.setRenderMsg(true);
						userController.setSevrityMsg("success");
				    }
				  
				  
				  public void saveLibelleAdresse() {
					  iservice.addObject(newLibelleAdresse);
					  chargeLibelleAdresse();
				  }
				  
				  public void checkSituation() {
						 if(newAvis.getAaoRegQual().equalsIgnoreCase("Unitaire")) { 
							 etatQualif = true;
							 qualifLabel1 = true;
							 qualifLabel2 = false;
						 }else 
						      if(newAvis.getAaoRegQual().equalsIgnoreCase("Conforme")){
						    	  etatQualif = false;
						    	  qualifLabel1 = false;
								  qualifLabel2 = false;
						 }else
							 if(newAvis.getAaoRegQual().equalsIgnoreCase("Autre")){
							 etatQualif = true;
							 qualifLabel1 = false;
							 qualifLabel2 = true;
						 }
					 }
					 
					 public void checkTaux() {
						 if(choixTaux.equalsIgnoreCase("marge")) { 
							 etatTaux = true; 
							 libelleTaux = true;
						 }
					 }
				 
					//Téléchargement des DAO type depuis la liste d'affichage
						public void opendaoType() throws IOException{
							  if(slctdTd.getTymTymCode().equalsIgnoreCase("0")) {
								 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+libelleFournitures, libelleFournitures); 
								 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);
								  //System.out.println(""+downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures)); 
								  System.out.println("");
							  }else
								  if(slctdTd.getTymTymCode().equalsIgnoreCase("2")) {
									  downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+libelleTravaux, libelleTravaux); 
									  //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+libelleTravaux, libelleTravaux);
							  }else
								 if(slctdTd.getTymTymCode().equalsIgnoreCase("1")) {
									 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+libellePrestations, libellePrestations); 
									 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+libellePrestations, libellePrestations);
							    }
						  }
						
						
						//Téléchargement des DAO type après la saisie du DAO  
							public void opendaoNew() throws IOException{
										 if(slctdTd.getTymTymCode().equalsIgnoreCase("0")) {
											  downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+libelleFournitures, libelleFournitures); 
											  // downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);  
										  }else
											  if(slctdTd.getTymTymCode().equalsIgnoreCase("2")) {
												  downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+libelleTravaux, libelleTravaux); 
												  //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+libelleTravaux, libelleTravaux);
										  }else
											 if(slctdTd.getTymTymCode().equalsIgnoreCase("1")) {
												 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+libellePrestations, libellePrestations); 
												 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+libellePrestations, libellePrestations);
										    }	
							  }
						
			
				
		     
		     //Methode vider
		     public void vider() { 
		    	 daoDetail = new VPpmDao();
		    	 dao = new TDacSpecs();
		    	 detailsPieces.clear();
		    	 listSelectionTypePieces.clear();
		    	 newAvis = new TAvisAppelOffre();
		    	 newVbTemp = new VbTempParametreLot();
		    	 setListeLots(new ArrayList<TLotAao>());
		     }
		     
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);	 
		     switch(value) {
				case "dao1":
					chargeData();
					//chargeDataPs();
					/*chargeGestions();
					chargeDataAffecter();
					chargeDataAValider();
					chargeTableauExiste();
					chargeDaoCharegEtude();
					chargeDaoChargeEtude();
					chargeDaoAffectesR();
					chargeDataAPublier();
					chargeDataARetirer();
					chargeDataVente();
					chargeDataPriseCompte();
					btn_corrige = true;*/
					vider();
					_logger.info("value: "+value+" action "+action);	
					break;
				case "dao2":
					chargePPM("PN");
					chargeAdresse();
					chargeLots();
					chargeImputation();
					chargePiecesOffres();
					chargeDaoTabTrans();
				break;
				case "dao3":
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao4":
		 			_logger.info("value: "+value+" action: "+action);
				break;
                case "dao5":
                	//chargeFonctionImput();
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao6":
                	//chargePiecesByDao();
                	/*chargePiecesByCsv();
                	chargePiecesByCharges();
                	chargeRespoExiste();
                	chargePiecesByBinome();*/
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao7":
		 			_logger.info("value: "+value+" action: "+action);
				break;  
				
                case "dao9":
                	 //chargeLotExiste();
                	/* chargeSoumissions();
                	 recupMontantDao();
                	 newCandidat = new TCandidats();
                	 etatRecu = false;
                	 sitDac = "";*/
		 			_logger.info("value: "+value+" action: "+action);
				break; 
				
                case "dao10":
                	 //chargeBailleurDao();
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao11":
                	chargePiecesDao();
                	chargePPM();
                	chargeDetailAdresseModif();
                	chargeAdresse();
                	chargeLotsUpdate();
		 			_logger.info("value: "+value+" action: "+action);
				break;	
			    }
		     
		     return userController.renderPage(value);  
	 }


	public List<VDacliste> getListeDAO() {
		return listeDAO;
	}


	public void setListeDAO(List<VDacliste> listeDAO) {
		this.listeDAO = listeDAO;
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

	public TFonction getRecupFonction() {
		return recupFonction;
	}

	public void setRecupFonction(TFonction recupFonction) {
		this.recupFonction = recupFonction;
	}

	public TDetailPlanPassation getDemDetail() {
		return demDetail;
	}

	public void setDemDetail(TDetailPlanPassation demDetail) {
		this.demDetail = demDetail;
	}

	public VPpmDao getDaoDetail() {
		return daoDetail;
	}

	public void setDaoDetail(VPpmDao daoDetail) {
		this.daoDetail = daoDetail;
	}

	public TDacSpecs getDao() {
		return dao;
	}

	public void setDao(TDacSpecs dao) {
		this.dao = dao;
	}

	public VDacliste getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(VDacliste slctdTd) {
		this.slctdTd = slctdTd;
	}

	public TDaoAffectation getSlctdTda() {
		return slctdTda;
	}

	public void setSlctdTda(TDaoAffectation slctdTda) {
		this.slctdTda = slctdTda;
	}

	public TAvisAppelOffre getNewAvis() {
		return newAvis;
	}

	public void setNewAvis(TAvisAppelOffre newAvis) {
		this.newAvis = newAvis;
	}

	public TLotAao getNewLot() {
		return newLot;
	}

	public void setNewLot(TLotAao newLot) {
		this.newLot = newLot;
	}

	public TLotAao getLot() {
		return lot;
	}

	public void setLot(TLotAao lot) {
		this.lot = lot;
	}

	public TDossierDacs getSelectedDossier() {
		return selectedDossier;
	}

	public void setSelectedDossier(TDossierDacs selectedDossier) {
		this.selectedDossier = selectedDossier;
	}

	public TDossierDacs getDoss() {
		return doss;
	}

	public void setDoss(TDossierDacs doss) {
		this.doss = doss;
	}

	public TDossierDacs getDos() {
		return dos;
	}

	public void setDos(TDossierDacs dos) {
		this.dos = dos;
	}

	public TLotAao getSelectLot() {
		return selectLot;
	}

	public void setSelectLot(TLotAao selectLot) {
		this.selectLot = selectLot;
	}

	public TTempParametre getNewTemp() {
		return newTemp;
	}

	public void setNewTemp(TTempParametre newTemp) {
		this.newTemp = newTemp;
	}

	public VbTempParametreLot getNewVbTemp() {
		return newVbTemp;
	}

	public void setNewVbTemp(VbTempParametreLot newVbTemp) {
		this.newVbTemp = newVbTemp;
	}

	public TAvisAppelOffre getMajAvis() {
		return majAvis;
	}

	public void setMajAvis(TAvisAppelOffre majAvis) {
		this.majAvis = majAvis;
	}

	public TCorrectionDac getDaoCorr() {
		return daoCorr;
	}

	public void setDaoCorr(TCorrectionDac daoCorr) {
		this.daoCorr = daoCorr;
	}

	public VDetailCorrection getDetailCor() {
		return detailCor;
	}

	public void setDetailCor(VDetailCorrection detailCor) {
		this.detailCor = detailCor;
	}

	public VDetailCorrectionCharge getDetailCharge() {
		return detailCharge;
	}

	public void setDetailCharge(VDetailCorrectionCharge detailCharge) {
		this.detailCharge = detailCharge;
	}

	public VDaoBailleur getDaoBailleur() {
		return daoBailleur;
	}

	public void setDaoBailleur(VDaoBailleur daoBailleur) {
		this.daoBailleur = daoBailleur;
	}

	public TDacSpecs getNewDao() {
		return newDao;
	}

	public void setNewDao(TDacSpecs newDao) {
		this.newDao = newDao;
	}

	public TDaoAffectation getDaoAffec() {
		return daoAffec;
	}

	public void setDaoAffec(TDaoAffectation daoAffec) {
		this.daoAffec = daoAffec;
	}

	public TTiers getNewEntre() {
		return newEntre;
	}

	public void setNewEntre(TTiers newEntre) {
		this.newEntre = newEntre;
	}

	public TCandidats getNewCandidat() {
		return newCandidat;
	}

	public void setNewCandidat(TCandidats newCandidat) {
		this.newCandidat = newCandidat;
	}

	public VbTempParamVente getNewVbTempVente() {
		return newVbTempVente;
	}

	public void setNewVbTempVente(VbTempParamVente newVbTempVente) {
		this.newVbTempVente = newVbTempVente;
	}

	public TVenteDac getNewVente() {
		return newVente;
	}

	public void setNewVente(TVenteDac newVente) {
		this.newVente = newVente;
	}

	public TTypePieceOffre getNewPieceOffre() {
		return newPieceOffre;
	}

	public void setNewPieceOffre(TTypePieceOffre newPieceOffre) {
		this.newPieceOffre = newPieceOffre;
	}

	public TOffrePieceDac getNewPieceOffreDac() {
		return newPieceOffreDac;
	}

	public void setNewPieceOffreDac(TOffrePieceDac newPieceOffreDac) {
		this.newPieceOffreDac = newPieceOffreDac;
	}

	public long getAdaNum() {
		return adaNum;
	}

	public void setAdaNum(long adaNum) {
		this.adaNum = adaNum;
	}

	public String getPidCod() {
		return pidCod;
	}

	public void setPidCod(String pidCod) {
		this.pidCod = pidCod;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getFiltreNcc() {
		return filtreNcc;
	}

	public void setFiltreNcc(String filtreNcc) {
		this.filtreNcc = filtreNcc;
	}

	public String getStatutRetrait() {
		return statutRetrait;
	}

	public void setStatutRetrait(String statutRetrait) {
		this.statutRetrait = statutRetrait;
	}

	public String getStatutVente() {
		return statutVente;
	}

	public void setStatutVente(String statutVente) {
		this.statutVente = statutVente;
	}

	public short getNumLibAdr() {
		return numLibAdr;
	}

	public void setNumLibAdr(short numLibAdr) {
		this.numLibAdr = numLibAdr;
	}

	public short getNumDetailAdr() {
		return numDetailAdr;
	}

	public void setNumDetailAdr(short numDetailAdr) {
		this.numDetailAdr = numDetailAdr;
	}

	public String getDtaLibelle() {
		return dtaLibelle;
	}

	public void setDtaLibelle(String dtaLibelle) {
		this.dtaLibelle = dtaLibelle;
	}

	public String getAffichLog() {
		return affichLog;
	}

	public void setAffichLog(String affichLog) {
		this.affichLog = affichLog;
	}

	public String getDetCom() {
		return detCom;
	}

	public void setDetCom(String detCom) {
		this.detCom = detCom;
	}

	public String getDacCode() {
		return dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	public String getSitDac() {
		return sitDac;
	}

	public void setSitDac(String sitDac) {
		this.sitDac = sitDac;
	}

	public String getNatPiece() {
		return natPiece;
	}

	public void setNatPiece(String natPiece) {
		this.natPiece = natPiece;
	}

	public Date getOuvTech() {
		return ouvTech;
	}

	public void setOuvTech(Date ouvTech) {
		this.ouvTech = ouvTech;
	}

	public Date getOuvFin() {
		return ouvFin;
	}

	public void setOuvFin(Date ouvFin) {
		this.ouvFin = ouvFin;
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

	public String getLibelleEntretienLocaux() {
		return libelleEntretienLocaux;
	}

	public void setLibelleEntretienLocaux(String libelleEntretienLocaux) {
		this.libelleEntretienLocaux = libelleEntretienLocaux;
	}

	public String getLibelleMainDouevreOcca() {
		return libelleMainDouevreOcca;
	}

	public void setLibelleMainDouevreOcca(String libelleMainDouevreOcca) {
		this.libelleMainDouevreOcca = libelleMainDouevreOcca;
	}

	public String getLibelleLocationMainDoeuvre() {
		return libelleLocationMainDoeuvre;
	}

	public void setLibelleLocationMainDoeuvre(String libelleLocationMainDoeuvre) {
		this.libelleLocationMainDoeuvre = libelleLocationMainDoeuvre;
	}

	public String getLibelleRestauration() {
		return libelleRestauration;
	}

	public void setLibelleRestauration(String libelleRestauration) {
		this.libelleRestauration = libelleRestauration;
	}

	public String getLibelleSecurite() {
		return libelleSecurite;
	}

	public void setLibelleSecurite(String libelleSecurite) {
		this.libelleSecurite = libelleSecurite;
	}

	public VLigneLot getLigne() {
		return ligne;
	}

	public void setLigne(VLigneLot ligne) {
		this.ligne = ligne;
	}

	public VLigneLot getRecupLigne() {
		return recupLigne;
	}

	public void setRecupLigne(VLigneLot recupLigne) {
		this.recupLigne = recupLigne;
	}

	public VFonctionMinistere getFonction() {
		return fonction;
	}

	public void setFonction(VFonctionMinistere fonction) {
		this.fonction = fonction;
	}

	public TAdresseAvis getNewAdresse() {
		return newAdresse;
	}

	public void setNewAdresse(TAdresseAvis newAdresse) {
		this.newAdresse = newAdresse;
	}

	public TDetailAdresseAvis getNewDtailAdresse() {
		return newDtailAdresse;
	}

	public void setNewDtailAdresse(TDetailAdresseAvis newDtailAdresse) {
		this.newDtailAdresse = newDtailAdresse;
	}

	public TLibelleAdresse getNewLibelleAdresse() {
		return newLibelleAdresse;
	}

	public void setNewLibelleAdresse(TLibelleAdresse newLibelleAdresse) {
		this.newLibelleAdresse = newLibelleAdresse;
	}

	public TRetrait getRetrait() {
		return retrait;
	}

	public void setRetrait(TRetrait retrait) {
		this.retrait = retrait;
	}

	public TSeances getNewSeance() {
		return newSeance;
	}

	public void setNewSeance(TSeances newSeance) {
		this.newSeance = newSeance;
	}

	public VDaoStatut getDaostatut() {
		return daostatut;
	}

	public void setDaostatut(VDaoStatut daostatut) {
		this.daostatut = daostatut;
	}

	public VFonctionImputation getNewImput() {
		return newImput;
	}

	public void setNewImput(VFonctionImputation newImput) {
		this.newImput = newImput;
	}

	public TAffichageDao getNewAff() {
		return newAff;
	}

	public void setNewAff(TAffichageDao newAff) {
		this.newAff = newAff;
	}

	public TAffichageDao getSltDaoAff() {
		return sltDaoAff;
	}

	public void setSltDaoAff(TAffichageDao sltDaoAff) {
		this.sltDaoAff = sltDaoAff;
	}

	public VDetailAdresse getDetailAdresse() {
		return detailAdresse;
	}

	public void setDetailAdresse(VDetailAdresse detailAdresse) {
		this.detailAdresse = detailAdresse;
	}

	public TCorrectionDac getCorrection() {
		return correction;
	}

	public void setCorrection(TCorrectionDac correction) {
		this.correction = correction;
	}

	public TTiers getTiers() {
		return tiers;
	}

	public void setTiers(TTiers tiers) {
		this.tiers = tiers;
	}

	public TSoumissions getSoumission() {
		return soumission;
	}

	public void setSoumission(TSoumissions soumission) {
		this.soumission = soumission;
	}

	public TSoumissions getRecupSoumission() {
		return recupSoumission;
	}

	public void setRecupSoumission(TSoumissions recupSoumission) {
		this.recupSoumission = recupSoumission;
	}

	public TTiers getRecupTiers() {
		return recupTiers;
	}

	public void setRecupTiers(TTiers recupTiers) {
		this.recupTiers = recupTiers;
	}

	public VVenteLot getNbreLot() {
		return nbreLot;
	}

	public void setNbreLot(VVenteLot nbreLot) {
		this.nbreLot = nbreLot;
	}

	public VUpdateDac getUpdateDac() {
		return updateDac;
	}

	public void setUpdateDac(VUpdateDac updateDac) {
		this.updateDac = updateDac;
	}

	public TDetailVente getVenteDetail() {
		return venteDetail;
	}

	public void setVenteDetail(TDetailVente venteDetail) {
		this.venteDetail = venteDetail;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public long getNatdoc() {
		return natdoc;
	}

	public void setNatdoc(long natdoc) {
		this.natdoc = natdoc;
	}

	public long getTotalMontantLot() {
		return totalMontantLot;
	}

	public void setTotalMontantLot(long totalMontantLot) {
		this.totalMontantLot = totalMontantLot;
	}

	public long getMontantRetrait() {
		return montantRetrait;
	}

	public void setMontantRetrait(long montantRetrait) {
		this.montantRetrait = montantRetrait;
	}

	public String getFiltreLigne() {
		return filtreLigne;
	}

	public void setFiltreLigne(String filtreLigne) {
		this.filtreLigne = filtreLigne;
	}

	public String getFiltreFonction() {
		return filtreFonction;
	}

	public void setFiltreFonction(String filtreFonction) {
		this.filtreFonction = filtreFonction;
	}

	public String getFilterCode() {
		return filterCode;
	}

	public void setFilterCode(String filterCode) {
		this.filterCode = filterCode;
	}

	public String getDocNature() {
		return docNature;
	}

	public void setDocNature(String docNature) {
		this.docNature = docNature;
	}

	public String getNbreDaoTrans() {
		return nbreDaoTrans;
	}

	public void setNbreDaoTrans(String nbreDaoTrans) {
		this.nbreDaoTrans = nbreDaoTrans;
	}

	public String getSit() {
		return sit;
	}

	public void setSit(String sit) {
		this.sit = sit;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public String getStatutSanction() {
		return statutSanction;
	}

	public void setStatutSanction(String statutSanction) {
		this.statutSanction = statutSanction;
	}

	public String getStatutSanRetour() {
		return statutSanRetour;
	}

	public void setStatutSanRetour(String statutSanRetour) {
		this.statutSanRetour = statutSanRetour;
	}

	public String getObservationCor() {
		return observationCor;
	}

	public void setObservationCor(String observationCor) {
		this.observationCor = observationCor;
	}

	public String getStatutUpdate() {
		return statutUpdate;
	}

	public void setStatutUpdate(String statutUpdate) {
		this.statutUpdate = statutUpdate;
	}

	public String getChoixTaux() {
		return choixTaux;
	}

	public void setChoixTaux(String choixTaux) {
		this.choixTaux = choixTaux;
	}

	public String getMultiFiltre() {
		return multiFiltre;
	}

	public void setMultiFiltre(String multiFiltre) {
		this.multiFiltre = multiFiltre;
	}

	public long getLotTotal() {
		return lotTotal;
	}

	public void setLotTotal(long lotTotal) {
		this.lotTotal = lotTotal;
	}

	public long getCoutLot() {
		return coutLot;
	}

	public void setCoutLot(long coutLot) {
		this.coutLot = coutLot;
	}

	public List<TDaoAffectation> getDaoExamen() {
		return daoExamen;
	}

	public void setDaoExamen(List<TDaoAffectation> daoExamen) {
		this.daoExamen = daoExamen;
	}

	public List<VDetailCorrection> getListeDetailCorrection() {
		return listeDetailCorrection;
	}

	public void setListeDetailCorrection(List<VDetailCorrection> listeDetailCorrection) {
		this.listeDetailCorrection = listeDetailCorrection;
	}

	public List<TTypePiecesDac> getListSelectionTypePieces() {
		return listSelectionTypePieces;
	}

	public void setListSelectionTypePieces(List<TTypePiecesDac> listSelectionTypePieces) {
		this.listSelectionTypePieces = listSelectionTypePieces;
	}

	public List<TDetailPlanPassation> getListeDetail() {
		return listeDetail;
	}

	public void setListeDetail(List<TDetailPlanPassation> listeDetail) {
		this.listeDetail = listeDetail;
	}

	public List<VLigneLot> getListeImputations() {
		return listeImputations;
	}

	public void setListeImputations(List<VLigneLot> listeImputations) {
		this.listeImputations = listeImputations;
	}

	public List<TDacSpecs> getDaoTab() {
		return daoTab;
	}

	public void setDaoTab(List<TDacSpecs> daoTab) {
		this.daoTab = daoTab;
	}

	public boolean isOuvTechnique() {
		return ouvTechnique;
	}

	public void setOuvTechnique(boolean ouvTechnique) {
		this.ouvTechnique = ouvTechnique;
	}

	public boolean isBtn_save_avis() {
		return btn_save_avis;
	}

	public void setBtn_save_avis(boolean btn_save_avis) {
		this.btn_save_avis = btn_save_avis;
	}

	public boolean isBtn_save_offre() {
		return btn_save_offre;
	}

	public void setBtn_save_offre(boolean btn_save_offre) {
		this.btn_save_offre = btn_save_offre;
	}

	public List<VPpmDao> getPpmDao() {
		return ppmDao;
	}

	public void setPpmDao(List<VPpmDao> ppmDao) {
		this.ppmDao = ppmDao;
	}

	public List<TLotAao> getListeLots() {
		return listeLots;
	}

	public void setListeLots(List<TLotAao> listeLots) {
		this.listeLots = listeLots;
	}

	public List<TLotAao> getAffichLots() {
		return affichLots;
	}

	public void setAffichLots(List<TLotAao> affichLots) {
		this.affichLots = affichLots;
	}

	public List<TTypePiecesDac> getDetailsPieces() {
		return detailsPieces;
	}

	public void setDetailsPieces(List<TTypePiecesDac> detailsPieces) {
		this.detailsPieces = detailsPieces;
	}

	public List<VPpmDao> getListSelectionPpmDao() {
		return listSelectionPpmDao;
	}

	public void setListSelectionPpmDao(List<VPpmDao> listSelectionPpmDao) {
		this.listSelectionPpmDao = listSelectionPpmDao;
	}

	public List<VFonctionMinistere> getListeFonctions() {
		return listeFonctions;
	}

	public void setListeFonctions(List<VFonctionMinistere> listeFonctions) {
		this.listeFonctions = listeFonctions;
	}

	public List<TDetailCorrection> getListeCorrection() {
		return listeCorrection;
	}

	public void setListeCorrection(List<TDetailCorrection> listeCorrection) {
		this.listeCorrection = listeCorrection;
	}

	public List<VPieces> getListePices() {
		return listePices;
	}

	public void setListePices(List<VPieces> listePices) {
		this.listePices = listePices;
	}

	public List<VPiecesOffreDao> getOffresDao() {
		return offresDao;
	}

	public void setOffresDao(List<VPiecesOffreDao> offresDao) {
		this.offresDao = offresDao;
	}

	public List<VFonctionImputation> getListSelectionFonctImput() {
		return listSelectionFonctImput;
	}

	public void setListSelectionFonctImput(List<VFonctionImputation> listSelectionFonctImput) {
		this.listSelectionFonctImput = listSelectionFonctImput;
	}

	public List<TAffichageDao> getAffectationListe() {
		return affectationListe;
	}

	public void setAffectationListe(List<TAffichageDao> affectationListe) {
		this.affectationListe = affectationListe;
	}

	public List<TAffichageDao> getValidationListe() {
		return validationListe;
	}

	public void setValidationListe(List<TAffichageDao> validationListe) {
		this.validationListe = validationListe;
	}

	public List<VDaoStatut> getDaostatutList() {
		return daostatutList;
	}

	public void setDaostatutList(List<VDaoStatut> daostatutList) {
		this.daostatutList = daostatutList;
	}

	public VbTempParametreCorrection getNewCorrection() {
		return newCorrection;
	}

	public void setNewCorrection(VbTempParametreCorrection newCorrection) {
		this.newCorrection = newCorrection;
	}

	public List<TAvisAppelOffre> getListAvis() {
		return listAvis;
	}

	public void setListAvis(List<TAvisAppelOffre> listAvis) {
		this.listAvis = listAvis;
	}

	public List<TAffichageDao> getExamenListe() {
		return examenListe;
	}

	public void setExamenListe(List<TAffichageDao> examenListe) {
		this.examenListe = examenListe;
	}

	public List<TAffichageDao> getListeDao() {
		return listeDao;
	}

	public void setListeDao(List<TAffichageDao> listeDao) {
		this.listeDao = listeDao;
	}

	public List<TLibelleAdresse> getListLibelleAdresse() {
		return listLibelleAdresse;
	}

	public void setListLibelleAdresse(List<TLibelleAdresse> listLibelleAdresse) {
		this.listLibelleAdresse = listLibelleAdresse;
	}

	public List<TAdresseAvis> getListAdresse() {
		return listAdresse;
	}

	public void setListAdresse(List<TAdresseAvis> listAdresse) {
		this.listAdresse = listAdresse;
	}

	public List<VDetailAdresse> getListDetailAdresse() {
		return listDetailAdresse;
	}

	public void setListDetailAdresse(List<VDetailAdresse> listDetailAdresse) {
		this.listDetailAdresse = listDetailAdresse;
	}

	public List<VAvisAdresse> getAvisAdresse() {
		return avisAdresse;
	}

	public void setAvisAdresse(List<VAvisAdresse> avisAdresse) {
		this.avisAdresse = avisAdresse;
	}

	public List<TNatureDocuments> getNatureDocListe() {
		return natureDocListe;
	}

	public void setNatureDocListe(List<TNatureDocuments> natureDocListe) {
		this.natureDocListe = natureDocListe;
	}

	public List<TTypePieceOffre> getListePiecesOffres() {
		return listePiecesOffres;
	}

	public void setListePiecesOffres(List<TTypePieceOffre> listePiecesOffres) {
		this.listePiecesOffres = listePiecesOffres;
	}

	public List<TTypePieceOffre> getListeSelectionPiecesOffres() {
		return listeSelectionPiecesOffres;
	}

	public void setListeSelectionPiecesOffres(List<TTypePieceOffre> listeSelectionPiecesOffres) {
		this.listeSelectionPiecesOffres = listeSelectionPiecesOffres;
	}

	public boolean isValue1() {
		return value1;
	}

	public void setValue1(boolean value1) {
		this.value1 = value1;
	}

	public boolean isEtatQualif() {
		return etatQualif;
	}

	public void setEtatQualif(boolean etatQualif) {
		this.etatQualif = etatQualif;
	}

	public boolean isEtatPV() {
		return etatPV;
	}

	public void setEtatPV(boolean etatPV) {
		this.etatPV = etatPV;
	}

	public boolean isEtatValiderCsv() {
		return etatValiderCsv;
	}

	public void setEtatValiderCsv(boolean etatValiderCsv) {
		this.etatValiderCsv = etatValiderCsv;
	}

	public boolean isEtatSanction() {
		return etatSanction;
	}

	public void setEtatSanction(boolean etatSanction) {
		this.etatSanction = etatSanction;
	}

	public boolean isEtatLoveObs() {
		return etatLoveObs;
	}

	public void setEtatLoveObs(boolean etatLoveObs) {
		this.etatLoveObs = etatLoveObs;
	}

	public boolean isEtatBtnValid() {
		return etatBtnValid;
	}

	public void setEtatBtnValid(boolean etatBtnValid) {
		this.etatBtnValid = etatBtnValid;
	}

	public boolean isEtatBtnValidCharge() {
		return etatBtnValidCharge;
	}

	public void setEtatBtnValidCharge(boolean etatBtnValidCharge) {
		this.etatBtnValidCharge = etatBtnValidCharge;
	}

	public boolean isEtatTaux() {
		return etatTaux;
	}

	public void setEtatTaux(boolean etatTaux) {
		this.etatTaux = etatTaux;
	}

	public boolean isQualifLabel1() {
		return qualifLabel1;
	}

	public void setQualifLabel1(boolean qualifLabel1) {
		this.qualifLabel1 = qualifLabel1;
	}

	public boolean isQualifLabel2() {
		return qualifLabel2;
	}

	public void setQualifLabel2(boolean qualifLabel2) {
		this.qualifLabel2 = qualifLabel2;
	}

	public boolean isLibelleTaux() {
		return libelleTaux;
	}

	public void setLibelleTaux(boolean libelleTaux) {
		this.libelleTaux = libelleTaux;
	}

	public boolean isEtatMtExig() {
		return etatMtExig;
	}

	public void setEtatMtExig(boolean etatMtExig) {
		this.etatMtExig = etatMtExig;
	}

	public boolean isEtatVenteLot() {
		return etatVenteLot;
	}

	public void setEtatVenteLot(boolean etatVenteLot) {
		this.etatVenteLot = etatVenteLot;
	}

	public boolean isEtatVenteDao() {
		return etatVenteDao;
	}

	public void setEtatVenteDao(boolean etatVenteDao) {
		this.etatVenteDao = etatVenteDao;
	}

	public boolean isEtatVentePanierLot() {
		return etatVentePanierLot;
	}

	public void setEtatVentePanierLot(boolean etatVentePanierLot) {
		this.etatVentePanierLot = etatVentePanierLot;
	}

	public boolean isEtatVentePanierDao() {
		return etatVentePanierDao;
	}

	public void setEtatVentePanierDao(boolean etatVentePanierDao) {
		this.etatVentePanierDao = etatVentePanierDao;
	}

	public boolean isPanelAvisBailleur() {
		return panelAvisBailleur;
	}

	public void setPanelAvisBailleur(boolean panelAvisBailleur) {
		this.panelAvisBailleur = panelAvisBailleur;
	}

	public boolean isPanelBailleurFichier() {
		return panelBailleurFichier;
	}

	public void setPanelBailleurFichier(boolean panelBailleurFichier) {
		this.panelBailleurFichier = panelBailleurFichier;
	}

	public boolean isEtatRecu() {
		return etatRecu;
	}

	public void setEtatRecu(boolean etatRecu) {
		this.etatRecu = etatRecu;
	}

	public boolean isConfirmPaie() {
		return confirmPaie;
	}

	public void setConfirmPaie(boolean confirmPaie) {
		this.confirmPaie = confirmPaie;
	}

	public boolean isConfirmVente() {
		return confirmVente;
	}

	public void setConfirmVente(boolean confirmVente) {
		this.confirmVente = confirmVente;
	}

	public boolean isPavet1() {
		return pavet1;
	}

	public void setPavet1(boolean pavet1) {
		this.pavet1 = pavet1;
	}

	public boolean isPavet2() {
		return pavet2;
	}

	public void setPavet2(boolean pavet2) {
		this.pavet2 = pavet2;
	}

	public boolean isPavet3() {
		return pavet3;
	}

	public void setPavet3(boolean pavet3) {
		this.pavet3 = pavet3;
	}

	public boolean isPavet4() {
		return pavet4;
	}

	public void setPavet4(boolean pavet4) {
		this.pavet4 = pavet4;
	}

	public boolean isPavet5() {
		return pavet5;
	}

	public void setPavet5(boolean pavet5) {
		this.pavet5 = pavet5;
	}

	public boolean isPavet6() {
		return pavet6;
	}

	public void setPavet6(boolean pavet6) {
		this.pavet6 = pavet6;
	}

	public boolean isValidCorrection() {
		return validCorrection;
	}

	public void setValidCorrection(boolean validCorrection) {
		this.validCorrection = validCorrection;
	}

	public boolean isEtatDaoCorrige() {
		return etatDaoCorrige;
	}

	public void setEtatDaoCorrige(boolean etatDaoCorrige) {
		this.etatDaoCorrige = etatDaoCorrige;
	}

	public boolean isBtn_affecter() {
		return btn_affecter;
	}

	public void setBtn_affecter(boolean btn_affecter) {
		this.btn_affecter = btn_affecter;
	}

	public boolean isBtn_corrige() {
		return btn_corrige;
	}

	public void setBtn_corrige(boolean btn_corrige) {
		this.btn_corrige = btn_corrige;
	}

	public List<TDacSpecs> getListDao() {
		return listDao;
	}

	public void setListDao(List<TDacSpecs> listDao) {
		this.listDao = listDao;
	}

	public List<TAvisAppelOffre> getAvisTab() {
		return avisTab;
	}

	public void setAvisTab(List<TAvisAppelOffre> avisTab) {
		this.avisTab = avisTab;
	}

	public List<VPieceDac> getListePiecesDao() {
		return listePiecesDao;
	}

	public void setListePiecesDao(List<VPieceDac> listePiecesDao) {
		this.listePiecesDao = listePiecesDao;
	}

	public List<TDossierDacs> getDossListe() {
		return dossListe;
	}

	public void setDossListe(List<TDossierDacs> dossListe) {
		this.dossListe = dossListe;
	}

	public List<TDaoAffectation> getListeDaoChargeValid() {
		return listeDaoChargeValid;
	}

	public void setListeDaoChargeValid(List<TDaoAffectation> listeDaoChargeValid) {
		this.listeDaoChargeValid = listeDaoChargeValid;
	}

	public List<TDossierDacs> getDossDacListe() {
		return dossDacListe;
	}

	public void setDossDacListe(List<TDossierDacs> dossDacListe) {
		this.dossDacListe = dossDacListe;
	}

	public List<VDacliste> getListeDAOTB() {
		return listeDAOTB;
	}

	public void setListeDAOTB(List<VDacliste> listeDAOTB) {
		this.listeDAOTB = listeDAOTB;
	}
	
			
}