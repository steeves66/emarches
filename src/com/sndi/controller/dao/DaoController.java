package com.sndi.controller.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Node;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STEdGrp;

import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.*;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;
import com.sndi.utilitaires.KeyGen;

import java.awt.Dimension;
//import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


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
	 private List<VDacliste> detailTB = new ArrayList<VDacliste>();
	 private List<VDacliste> detailTrans = new ArrayList<VDacliste>();
	 private List<VDacliste> detailDac = new ArrayList<VDacliste>();
	 private List<VDacliste> dacVente = new ArrayList<VDacliste>();
	 private List<VDacliste> detailDacDiff = new ArrayList<VDacliste>();
	 private List<TDacSpecs> listDao = new ArrayList<TDacSpecs>(); 
	 private List<TGestion> listeGestion = new ArrayList<TGestion>();
	 private List<TAvisAppelOffre> avisTab = new ArrayList<TAvisAppelOffre>(); 
	 private List<TDaoAffectation> daoExamen = new ArrayList<TDaoAffectation>();
	 private List<TDaoAffectation> daoBinome = new ArrayList<TDaoAffectation>();
	 private List<VDetailCorrection> listeDetailCorrection = new ArrayList<VDetailCorrection>();
	 private List<VFonctionImputation> listeFonctionsImput = new ArrayList<VFonctionImputation>();
	 private List<TTypePiecesDac>listSelectionTypePieces =new ArrayList<TTypePiecesDac>();
	 private List<TDetailPlanPassation> listeDetail = new ArrayList<TDetailPlanPassation>();
	 private List<TSeances> listSeances  = new ArrayList<TSeances>();  
	 
	 private List<TDetCommissionSeance> listeDetCom  = new ArrayList<TDetCommissionSeance>();
	 private List<TDaoAffectation> listeDaoAff  = new ArrayList<TDaoAffectation>();
	 //private List<VLigneImputation> listeImputations = new ArrayList<VLigneImputation>();
	//private List<VDelaiValiditeOffre> delaiValidite = new ArrayList<VDelaiValiditeOffre>();
	 private List<VLigneLot> listeImputations = new ArrayList<VLigneLot>();
	 private List<TCorrectionDac> listCorrection = new ArrayList<TCorrectionDac>();
	 private List<TCorrectionDac> listPieceCorrection = new ArrayList<TCorrectionDac>();
	 private List<TDossierDacs> dossListe = new ArrayList<TDossierDacs>();
	 private List<TDossierDacs> dossDacListe = new ArrayList<TDossierDacs>();
	 private List<VPpmDao> ppmDao = new ArrayList<VPpmDao>();
	 private List<VPpmDao> listSelectionPpmDao = new ArrayList<VPpmDao>();
	 private List<TTypePiecesDac> detailsPieces = new ArrayList<TTypePiecesDac>();
	 private List<TDaoAffectation> listeDaoChargeValid = new ArrayList<TDaoAffectation>();
	 private List<TLotAao> listeLots = new ArrayList<TLotAao>();
	 private List<VLotCritere> listeLotCritere = new ArrayList<VLotCritere>();
	 private List<VLotCritere> listeLotConsultation = new ArrayList<VLotCritere>();
	 private List<TLotAao> affichLots = new ArrayList<TLotAao>();
	 private List<VFonctionMinistere> listeFonctions = new ArrayList<VFonctionMinistere>();
	 private List<VPieceDac> listePiecesDao = new ArrayList<VPieceDac>();
	 private List<VFonctionImputation>listSelectionFonctImput =new ArrayList<VFonctionImputation>();
	 private List<TAffichageDao> affectationListe = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> validationListe = new ArrayList<TAffichageDao>();
	 private List <VDaoStatut> daostatutList = new ArrayList<VDaoStatut>();
	 private List<VDetTabBordDac> detailTBCpt = new ArrayList<VDetTabBordDac>();
	 private List<VDacVendu> listeDetailVente= new ArrayList<VDacVendu>();
	//GESTION DES MEMBRES DE LA COMMISSION
	private List<VbCommissionType> membresCommission = new ArrayList<VbCommissionType>();
	private List<VbCommissionType> selectionMembres = new ArrayList<VbCommissionType>(); 
	private List<VCommissionTypeExp> listeExpert = new ArrayList<VCommissionTypeExp>(); 
	private List<VCommissionTypeExp> selectionlisteExpert = new ArrayList<VCommissionTypeExp>(); 
	private List<VCommissionSpeciale> listeMbrCommissionSpeciale = new ArrayList<VCommissionSpeciale>(); 
	private List<VCommissionSpeciale> selectionMbrCommissionSpeciale = new ArrayList<VCommissionSpeciale>(); 
	private List<VbCommissionSpecifique> listeMbr = new ArrayList<VbCommissionSpecifique>(); 
	private List<TCommissionSpecifique> listeCom = new ArrayList<TCommissionSpecifique>(); 
	private List<VCommissionSpecifique> listeMembre = new ArrayList<VCommissionSpecifique>();
	private List<VCommissionSpecifique> listeMembreComSpec = new ArrayList<VCommissionSpecifique>(); 
	private List<VbCommissionSpecifique> listeComSpecifique = new ArrayList<VbCommissionSpecifique>(); 
	private List<TCommissionSpecifique> listeComSpecific = new ArrayList<TCommissionSpecifique>();
	private List<TDetCritAnalyseDac> listeDetCritere = new ArrayList<TDetCritAnalyseDac>();
	private VFonctionImputation sltImput = new VFonctionImputation();
	//Pieces a examiner
	private List<TDetailCorrection> listeCorrection = new ArrayList<TDetailCorrection>();
	private List<VPieces> listePices = new ArrayList<VPieces>();
	private List<VPiecesOffreDao> offresDao = new ArrayList<VPiecesOffreDao>();
	private VbTempParametreCorrection newCorrection = new VbTempParametreCorrection();
	 private List<VDetailCorrectionCharge> listeCorrectionCharge = new ArrayList<VDetailCorrectionCharge>();
	 private List<VDacliste> publicationListe = new ArrayList<VDacliste>();
	 private List<VDacliste> publicationSelection = new ArrayList<VDacliste>();
	//Avis 
	private List<TAvisAppelOffre> listAvis = new ArrayList<TAvisAppelOffre>();
	private List<TAffichageDao> examenListe = new ArrayList<TAffichageDao>(); 
	private List<TAffichageDao> listeDao = new ArrayList<TAffichageDao>();
	private TAvisAppelOffre sltAvis =new TAvisAppelOffre();
	//GESTION DES ADRESSES
	private List<TLibelleAdresse> listLibelleAdresse = new ArrayList<TLibelleAdresse>();
	private List<TAdresseAvis> listAdresse = new ArrayList<TAdresseAvis>();
	private List<VDetailAdresse> listDetailAdresse = new ArrayList<VDetailAdresse>();
	private List<VAvisAdresse> avisAdresse = new ArrayList<VAvisAdresse>();
	private List<TNatureDocuments> natureDocListe = new ArrayList<TNatureDocuments>();
	//GESTION PIECES OFFRES
	//private List<TTypePieceOffre> listePiecesOffres= new ArrayList<TTypePieceOffre>();
	//private List<TTypePieceOffre> listeSelectionPiecesOffres= new ArrayList<TTypePieceOffre>();
	private List<VTypePieceOffreSg> listePiecesOffres= new ArrayList<VTypePieceOffreSg>();
	private List<VTypePieceOffreSg> listeSelectionPiecesOffres= new ArrayList<VTypePieceOffreSg>();
	
	private List<VbPaysReference> listePays = new ArrayList<VbPaysReference>();
	//GESTION DES CRITERES D'ANALYSE
	private List<VCritereAnalyseModel> listeCritereAnalyse = new ArrayList<VCritereAnalyseModel>();
	private List<VCritereAnalyseModel> selectionlisteCritereAnalyse = new ArrayList<VCritereAnalyseModel>();
	private List<VbCritereAnalyse> listeCritere = new ArrayList<VbCritereAnalyse>();
	private List<VCritAnalDacEntete> listeEnteteCritere = new ArrayList<VCritAnalDacEntete >();
	private List<VCritAnalDacSousentete> listeSousEnteteCritere = new ArrayList<VCritAnalDacSousentete >();
	private List<VCritereAnalyseDac> listeCritereSaisie = new ArrayList<VCritereAnalyseDac>(); 
	private List<VCritereAnalyseDac> listeCritereByLot = new ArrayList<VCritereAnalyseDac>();
	private List<TLotAao> listeLot = new ArrayList<TLotAao>();
	private List<TAvisAppelOffre> listeAvis = new ArrayList<TAvisAppelOffre>();
	/*private List<VCritereAnalyseDacLot> listeCritereByLot = new ArrayList<VCritereAnalyseDacLot>();*/
	private List<VArticlesCom> listeArticle = new ArrayList<VArticlesCom>();
	private List<VbDetCritAnalyseDac> listDetCritereDac = new ArrayList<VbDetCritAnalyseDac>();
	private List<TDetCritAnalyseDac> listDetcritere = new ArrayList<TDetCritAnalyseDac>();
	private TCommissionSpecifique detailCom = new TCommissionSpecifique(); 
	//MAREGE DE PREFENCE
	private List<VMargeDePreference> listeMarge = new ArrayList<VMargeDePreference>();
	private List<VMargeDePreferenceSou> listeMargeSou = new ArrayList<VMargeDePreferenceSou>();
	private List<VMargeDePreferenceCom> listeMargeCom = new ArrayList<VMargeDePreferenceCom>();
	private List<VMargeDePreferenceArt> listeMargeArt = new ArrayList<VMargeDePreferenceArt>();
    //TABLEAU DE BORD
	private VbTempParamTabBord tempBord = new VbTempParamTabBord();
	private VPieces sltPiece = new VPieces();
	private TSeances sltSeances  = new TSeances();
	private TLotAao sltLot = new TLotAao();
	 
	//variables
	private long gesCode;
	 private TFonction recupFonction= new TFonction();
	 private TDetailPlanPassation demDetail = new TDetailPlanPassation();
	 private List<TDacSpecs> listeDaoCsvValid = new ArrayList<TDacSpecs>();
	 private VPpmDao daoDetail = new VPpmDao();
	 private VDacMembre selecMembre = new VDacMembre();
	 private TDacSpecs dao= new TDacSpecs();
	 private VDacliste slctdTd = new VDacliste();
	 private VDacliste recupCout = new VDacliste();
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
	 private List<TSoumissions> listSoumission = new ArrayList<TSoumissions>();
	 private TAvisAppelOffre majAvis = new TAvisAppelOffre();
	 private TCorrectionDac daoCorr = new TCorrectionDac();
	 private VDetailCorrection detailCor = new VDetailCorrection();
	 private VDetailCorrectionCharge detailCharge = new VDetailCorrectionCharge();
	 private VDaoBailleur daoBailleur = new VDaoBailleur();
	 private TDacSpecs newDao = new TDacSpecs();
	 private VDacVendu detailVente = new VDacVendu();
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
	//GESTION DES CRITERES D'ANALYSE
	 private VbCritereAnalyse sltCritere = new VbCritereAnalyse();
	 private VbDetCritAnalyse newDetCritere = new VbDetCritAnalyse();
	 private VbCritereAnalyse newEnteteCritere = new VbCritereAnalyse();
	 private VCritAnalDacEntete newEnteteCrit = new VCritAnalDacEntete();
	 private VCritAnalDacSousentete newSousEnteteCrit = new VCritAnalDacSousentete();
	 private VbTempCritere newTempEnteteCrit = new VbTempCritere();
	private TDetCritAnalyseDac detCritere = new TDetCritAnalyseDac();
	private VDacliste caution = new VDacliste();
	private VLotCritere lotCrit = new VLotCritere();
	private TLotAao lots = new TLotAao();
	//MARGE DE PREFERENCE
	private VMargeDePreference marge = new VMargeDePreference();
	private VMargeDePreferenceSou margeSou = new VMargeDePreferenceSou();
	private VMargeDePreferenceCom margeCom = new VMargeDePreferenceCom();
	private VMargeDePreferenceArt margeArt = new VMargeDePreferenceArt();
	//VARIABLES
	 private long adaNum;
	 private long rId;
	 private long rIdSous;
	 private long delai;
	 private long dcadNum;
	 private long totalMontantEstimatif;
	 private long totalNbreVente;
	 private long totalMontantCaution;
	 private double montantCaution =0; 
	 private long cautionMinRound =0;
	 private long cautionMaxRound =0;
	 private long dcsNum;
	 private String pidCod;
	 private String observation="";
	 private String imputation="";
	 private String filtreNcc ="";
	 private String statutRetrait="";
	 private String statutVente="";
	 private String codeAutorisation ="";
	 private short numLibAdr;
	 private short numDetailAdr;
	 private String dtaLibelle;
	 private String affichLog;
	 private String craCode;
	 private String critere;
	 private String detCom="";
	 private String pieceCode="";
	 private String dacCode ="";
	 private String newSouncc ="";
	 private String sitDac ="";
	 private String natPiece ="";
	 private String commentaire="";
	 private String pays="";
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
	 private String fourniture_PSL = "dossier_de_consultation_de_fourniture_en_PSL.docx";
	 private String fourniture_PSO= "dossier_de_consultation_de_fourniture_en_PSO_final.docx";
	 private String fourniture_PSC="";
	 private String travaux_PSL= "dossier_de_consultation_travaux_en_PSL_final.docx";
	 private String travaux_PSO= "dossier_de_consultation_travaux_en_PSO_final.docx";
	 private String travaux_PSC = "";
	 private String prestations_PSL = "dossier_de_consultation_de_services_courants_en_PSL_FINAL.docx";
	 private String prestations_PSO = "dossier_de_consultation_de_services_courants_en_PSO.docx";
	 private String prestations_PSC = "";
	 
	 private VLigneLot ligne = new VLigneLot();
	 private VLigneLot recupLigne = new VLigneLot();
	 private List<VMargeDePreference> listMarge = new ArrayList<VMargeDePreference>();
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
	 private TSoumissions newSoumission = new TSoumissions();
	 private TSoumissions recupSoumission = new TSoumissions();
	 private TTiers recupTiers = new TTiers();
	 private VVenteLot nbreLot = new VVenteLot();
	 private VUpdateDac updateDac= new VUpdateDac();
	 private VCritereAnalyseModel critereObject= new VCritereAnalyseModel();
	//GESTION DES COMMISSIONS
	 private VbCommissionSpecifique newcomSpec = new VbCommissionSpecifique();
	 private VbCommissionSpecifique comSpec = new VbCommissionSpecifique();
	 private TCommissionSpecifique comSpecUpdate = new TCommissionSpecifique();
	 private VCommissionSpecifique sltCompsec = new VCommissionSpecifique();
	//GESTION DES CRTIERE
	 private VbDetCritAnalyseDac newCritereDac = new VbDetCritAnalyseDac();
	 private VbTempCritere newTempCritereDac = new VbTempCritere();
	 private VbTempParamDetCri newTempCritere = new VbTempParamDetCri();
	 private VCritereAnalyseDac sltCritereDac = new VCritereAnalyseDac();
	 private VbTempParametreFact newTempFactorise = new VbTempParametreFact(); 
	 private VbTempParametreFactSup newTempFactSup = new VbTempParametreFactSup();
	 private VMargeDePreference sltMarge = new VMargeDePreference();
	 private TDetCommissionSeance supDetCom  = new TDetCommissionSeance();
	 private TDaoAffectation supDaoAff  = new TDaoAffectation();
	 private boolean btn_save_presence = true;
	 private boolean btn_save_expert = false;
	 private boolean btn_ad_expert = false;
	 private boolean panelMbr = true;
	 private boolean panelExpert = false;
	 private long laaId;
	 private boolean comboboxCom = true;
	 private boolean norm = false;
	 private boolean spec = false;
	 private boolean comNormale = true;
	 private boolean comSpeciale = false;
	 private boolean comAutorise = false;
	 private String typeCommission ="N"; 
	 private boolean etatPays = true;
	 private boolean daoCritere = true;
	 private boolean panelCaution = false;
	 
	//BoolÃ¯Â¿Â½ens
	  private boolean skip;
	  private long natdoc= 7;
	  private long totalMontantLot;
	  private long montantRetrait = 0;
	  private double cautionMin = 0;
	  private double cautionMax = 0;
	  private String filtreLigne ="";
	  private String filtreFonction="";
	  private String filterCode="";
	  private String docNature ="";
	  private String nbreDaoTrans ="";
	  private String sit = "";
	  private String resultat = "";
	  private String value1 ="N";
	  private String margePref ;
	  private String statutSanction = "";
	  private String statutSanRetour="";
	  private String observationCor ="";
	  private String statutUpdate="";
	  private String choixTaux = "";
	  private String choixCritere = "";
	  private String multiFiltre="";
	  private String paieCode ="";
	  private String statutPub ="";
	  private long lotTotal = 0;
	  private long coutLot = 0;
	  private boolean ouvTechnique = true;
	  private boolean btn_save_avis = false;
	  private boolean btn_save_offre = false;
	//BoolÃ¯Â¿Â½en
	  //private boolean value1 =true;
	  private boolean etatQualif =false;
	  private boolean libBailleur =false;
	  private boolean inputBailleur =false;
	  private boolean etatPV =false;
	  private boolean etatValiderCsv =true;
	  private boolean etatSanction = false;
	  private boolean etatLoveObs = false;
	  private boolean etatBtnValid = false;
	  private boolean etatBtnValidCharge = true;
	  private boolean etatTaux = false;
	  private boolean etatMargeA = false;
	  private boolean etatMargeC = false;
	  private boolean etatMargeS = false;
	  private boolean etatMargePreference = false;
	  private boolean panelExixstent = false;
	  private boolean panelNouveau = false;
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
	  private boolean titreVente = false;
	  private boolean confirmRetrait = false;
	  private boolean titreRetrait = false;
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
	  private boolean ouverture = false;
	  private boolean pavet_lot = false;
	  private boolean pavet_offre = false;
	  private boolean pavet_critere = false;
	  private boolean pavet_commission = false;
	  private boolean btn_dao = false;
	  private boolean btn_titre_paie = false;
	  private boolean btn_titre_retrait = false;
	  private boolean infoNcc = false;
	  private boolean panelNcc1 = false;
	  private boolean panelNcc2 = false;
	  private boolean confirmInter = false;
	  private boolean clean = false;
	  private boolean panelMessage = true;
	  private boolean panelCritereLot = false;
	 
	 @PostConstruct
	 public void postContr() {
		 controleController.fonctionaliteDynamic();
		 chargeGestions();
		 chargePays();
		 //chargeCritereCombobox();
	 }
	 
	 public String onFlowProcess(FlowEvent event) {
		 System.out.println("etape old= "+event.getOldStep()+" New= "+event.getNewStep());
			//Controle PavÃ¯Â¿Â½ crÃ¯Â¿Â½ation
			 if(event.getOldStep().equals("creation") && event.getNewStep().equals("avis")) {
				 if("".equals(daoDetail.getTymCode()) || "".equalsIgnoreCase(daoDetail.getMopCode()) 
						 ||"".equals(daoDetail.getDppObjet()) ) 
				 {
					 FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez terminer votre Saisie, avant de cliquer sur suivant!", ""));
			          return "creation";
					} 
	              userController.initMessage(); 
	              //listeMarge();
			     }
			 
			//Controle Pavé création
			 if(event.getOldStep().equals("critere") && event.getNewStep().equals("criterebyLot")) {
				 //factoriserLot();
				 factoriserNext();
				 listeCritereByLot.clear();
			     }
			 
			//Controle totalité des lots factorisés
			 if(event.getOldStep().equals("criterebyLot") && event.getNewStep().equals("cojo")) {
				 chargeArticle();
				 listeLotCritere.clear();
				 listeLotCritere=(List<VLotCritere>) iservice.getObjectsByColumn("VLotCritere", new ArrayList<String>(Arrays.asList("LAA_NUM")),
						new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
				 if(!listeLotCritere.isEmpty()) { 
					 lotCrit=listeLotCritere.get(0);
					 if(lotCrit.getCritOk() != 0) {
						 FacesContext.getCurrentInstance().addMessage(null,
								 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Il y a encore "+lotCrit.getCritOk()+" lot(s) sans critères", ""));
						 return "criterebyLot";
					 }
			     }
			 }
			 
			 if(event.getOldStep().equals("criterebyLot") && event.getNewStep().equals("critere")) {
				 //newTempFactorise = new VbTempParametreFact(); 
				 chargeLotConsultation();
			     }
			 
			 //Pavet Lot
			 if(event.getOldStep().equals("tabLot") && event.getNewStep().equals("Poffre")) {
				 controlLotDao();
				 userController.initMessage();
			     }
			
		      return event.getNewStep();
		      
	    }
	 
	 //Methode pour retourner
	 public void retour() {
		 
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
	 
	 //GESTION DES CRITERES
	//Parametrage des criteres en fonction du type plan et du type dac
	 public void chargeCritere() { 
		 listeCritereAnalyse= (List<VCritereAnalyseModel>) iservice.getObjectsByColumn("VCritereAnalyseModel", new ArrayList<String>(Arrays.asList("CRA_CODE")),
					new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode()),
		            new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		 _logger.info("liste affichée: "+listeCritereAnalyse.size());
	 }
	 
   //Insertion du critère après le choix 
	public void savePiece() {
		listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
			     if (!listDao.isEmpty()) {
				       newDao= listDao.get(0);
				       newDao.setDacCraCodeExclus(critere);
		               iservice.updateObject(newDao); 
		               //Chargement des pièces
		               chargeCritere();   
   	           }
	}
	 
	 
	 //Liste des critères saisies
	 public void chargeCritereSaisie() { 
	/*	 listeCritereSaisie= (List<VbDetCritAnalyseDac>) iservice.getObjectsByColumn("VbDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_DAN_CODE")),
					new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));*/ 
		 listeCritereSaisie.clear(); 
		 listeCritereSaisie = ((List<VCritereAnalyseDac>)iservice.getObjectsByColumn("VCritereAnalyseDac",
				 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,"0"),
				 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode())));
		 _logger.info("liste critere saisie: "+listeCritereSaisie.size());

		 afficheOption();
	 }
	 
	 
	 public void chargeLotCritere() {
		 listeLotCritere.clear();
		 listeLotCritere=(List<VLotCritere>) iservice.getObjectsByColumn("VLotCritere", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		_logger.info("listeLotCritere size: "+listeLotCritere.size());
	 } 
	 
	 public void chargeLotConsultation() {
		 listeLotConsultation.clear();
	     listeLotConsultation=(List<VLotCritere>) iservice.getObjectsByColumn("VLotCritere", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		_logger.info("listeLotConsultation size: "+listeLotConsultation.size());
	 }
	 //Affichage des marges de préférence de l'avis en cours
	 public void listeMargePref() {
		 listMarge.clear();
		 listMarge = (List<VMargeDePreference>) iservice.getObjectsByColumn("VMargeDePreference",
					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
	 }
	 
	 //Gestion des marges de préférence
	 public void saveMarge (String marge) {
		 List<TDacSpecs> LS  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+sltMarge.getDacCode()));
		 TDacSpecs dac = new TDacSpecs(); 
		 if(!LS.isEmpty()) dac = LS.get(0);
		    if(sltMarge.getOrdre().equalsIgnoreCase("1")) {
		    	  dac.setDacMargePrefSou(""+marge);
		    	  dac.setDacMargePrefCom("N");
		    	  dac.setDacMargePrefArt("N");
		    	  dac.setDacMargePrefSouVal(sltMarge.getTauxMargePref());
				  iservice.updateObject(dac);
				  listeMargePref();
		    }else {
		    	if(sltMarge.getOrdre().equalsIgnoreCase("2")) {
		    		dac.setDacMargePrefCom(""+marge);
		  		    dac.setDacMargePrefComVal(sltMarge.getTauxMargePref());
		  		    dac.setDacMargePrefSou("N");
		  		    iservice.updateObject(dac);
		  		    listeMargePref();
			    }else {
			    	   if(sltMarge.getOrdre().equalsIgnoreCase("3")) {
			    		   dac.setDacMargePrefArt(""+marge);
					       dac.setDacMargePrefArtVal(sltMarge.getTauxMargePref());
					       dac.setDacMargePrefSou("N");
						   iservice.updateObject(dac);
						   listeMargePref();
				      }
			    }
		    }
	 }
	 
	 //Matérialisation du DAO en statut d'Affectation
	 public void updateDao() {
			listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
						if (!listDao.isEmpty()) {
							 newDao= listDao.get(0);
							 newDao.setTStatut(new TStatut("D3A"));
							 newDao.setDacStatutRetour("0");
						     iservice.updateObject(newDao); 
				   	               }
	 }
	 
	//Affectation Normale d'une fonction
	 public void saveAffectationRespo(String respo) {            
		 listSeances =  (List<TSeances>) iservice.getObjectsByColumn("TSeances", new ArrayList<String>(Arrays.asList("SEA_NUM")),
					new WhereClause("SEA_TSE_CODE",WhereClause.Comparateur.EQ,"CIA"), 
					new WhereClause("SEA_OBSERVATION",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()),
					new WhereClause("SEA_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
		            new WhereClause("SEA_FON_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
		       if(!listSeances.isEmpty()) { 
		    	   sltSeances=listSeances.get(0);
		    	
				    	   updateDao();
				    	    
				    	     TCommissionSpecifique com = new TCommissionSpecifique();
					  	     com.setTStructure(new TStructure(sltImput.getStrCode()));
					  	     com.setTDacSpecs(newDao);
					  	     com.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
					  	     com.setTTypeCommission(new TTypeCommission("CIA"));
					  	     com.setComDteSaisi(Calendar.getInstance().getTime());
					  	     com.setComMarCode(slctdTd.getTymCode());
					  	     iservice.addObject(com);
					  	 	 
				    	     TDetCommissionSeance det = new TDetCommissionSeance();
					   		 det.setDcsDteSaisi(Calendar.getInstance().getTime());
					   		 det.setDcsFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
					   		 det.setTDacSpecs(newDao);
					   		 det.setTSeances(sltSeances);
					   		 det.setDcsFonCod(sltImput.getFonCod());
					   		 det.setDcsOpeMatricule(sltImput.getOpeMatricule());
					   		 det.setTStructure(new TStructure(sltImput.getStrCode()));
					   		 det.setTCommissionSpecifique(com);
					   		 det.setTOperateur(userController.getSlctd().getTOperateur());
					   		 det.setTTypeCommission(new TTypeCommission(com.getTTypeCommission().getTcoCode()));
					   		 det.setDcsPresent("O");
					   		 det.setDcsNomMbm(sltImput.getOpeNom());
					   		 det.setDcsTelMbm(sltImput.getOpeContact());
					   		 det.setDcsMbmRespo(""+respo);
					   		 iservice.addObject(det);  
					   		 
					      	//Enregistrement dans TDaoAffectation
					   		listeDaoAff = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
									new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,""+sltImput.getOpeMatricule()), 
									new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
				    	              if(!listeDaoAff.isEmpty()) { 
				    		              supDaoAff=listeDaoAff.get(0);
				    		              supDaoAff.setDafDcsMbmRespo(""+respo);
				    		              iservice.updateObject(supDaoAff);
				    		              }else {
				    		            	//Enregistrement dans TDaoAffectation
				    				 	       TDaoAffectation newAff = new TDaoAffectation(); 
				    				 		   newAff.setDafDacCode(newDao.getDacCode());
				    				 		   newAff.setDafOpeMatricule(sltImput.getOpeMatricule());
				    				 		   newAff.setDafStaCode(newDao.getTStatut().getStaCode());
				    				 		   newAff.setDafStatutRetour(newDao.getDacStatutRetour());
				    				 		   newAff.setDafDacObjet(newDao.getDacObjet());
				    				 		   newAff.setDafTypeDac(newDao.getTTypeDacSpecs().getTdcCode());
				    				 		   newAff.setDafDacGestion(newDao.getTGestion().getGesCode());
				    				 		   newAff.setDafTypePlan(newDao.getDacTypePlan());
				    				 		   newAff.setDafDacStr(newDao.getTStructure().getStrCode());
				    				 		   newAff.setDafDacRecherche(newDao.getDacRecherche());
				    				 		   newAff.setDafDcsMbmRespo(det.getDcsMbmRespo());
				    				 		   newAff.setTDetCommissionSeance(det);
				    				 		   newAff.setTModePassation(new TModePassation(newDao.getTModePassation().getMopCode()));
				    				 		   newAff.setTTypeMarche(new TTypeMarche(newDao.getTTypeMarche().getTymCode()));
				    				 		   newAff.setDafMention(newDao.getDacMention());
				    				 		   iservice.addObject(newAff);
				    		              }
					   		//Chargement des fonctions à  imputer 
					   		 chargeFonctionImput();
					   		//Message de Confirmation 
					   		userController.setTexteMsg("Responsabilité Attribuée avec succès!");
							userController.setRenderMsg(true);
							userController.setSevrityMsg("success");
		       }else {
		    	   
		    	   updateDao();
		    	   
		    	   String chaine="SEANCE DE COMMISSION INTERNE D'ANALYSE DU DAO N°";
		  		   String exo=chaine+newDao.getDacCode();
		  		   newSeance.setTFonction(userController.getSlctd().getTFonction());
		  		   newSeance.setTOperateur(userController.getSlctd().getTOperateur());
		  		   newSeance.setTTypeSeance(new TTypeSeance("CIA"));
		  		   newSeance.setSeaSteSaisi(Calendar.getInstance().getTime());
		  		   newSeance.setSeaObservation(newDao.getDacCode());
		  		   newSeance.setSeaLibelle(exo);
		  		   iservice.addObject(newSeance);		
		  	    		 
		  	       TCommissionSpecifique com = new TCommissionSpecifique();
		  	       com.setTStructure(new TStructure(sltImput.getStrCode()));
		  	       com.setTDacSpecs(newDao);
		  	       com.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
		  	       com.setTTypeCommission(new TTypeCommission("CIA"));
		  	       com.setComDteSaisi(Calendar.getInstance().getTime());
		  	       com.setComMarCode(slctdTd.getTymCode());
		  	       iservice.addObject(com);
		  	 	
		  		   TDetCommissionSeance det = new TDetCommissionSeance();
		   		   det.setDcsDteSaisi(Calendar.getInstance().getTime());
		   		   det.setDcsFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
		   		   det.setTDacSpecs(newDao);
		   		   det.setTSeances(newSeance);
		   		   det.setDcsFonCod(sltImput.getFonCod());
		   		   det.setDcsOpeMatricule(sltImput.getOpeMatricule());
		   		   det.setTStructure(new TStructure(sltImput.getStrCode()));
		   		   det.setTCommissionSpecifique(com);
		   		   det.setTOperateur(userController.getSlctd().getTOperateur());
		   		   det.setTTypeCommission(new TTypeCommission(com.getTTypeCommission().getTcoCode()));
		   		   det.setDcsPresent("O");
		   		   det.setDcsNomMbm(sltImput.getOpeNom());
		   		   det.setDcsTelMbm(sltImput.getOpeContact());
		   		   det.setDcsMbmRespo(""+respo);
		   		   iservice.addObject(det); 
		   		   
		   		   //Enregistrement dans TDaoAffectation
		   		listeDaoAff = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
						new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,""+sltImput.getOpeMatricule()), 
						new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
	    	              if(!listeDaoAff.isEmpty()) { 
	    		              supDaoAff=listeDaoAff.get(0);
	    		              supDaoAff.setDafDcsMbmRespo(""+respo);
	    		              iservice.updateObject(supDaoAff);
	    		              }else {
	    		            	//Enregistrement dans TDaoAffectation
	    				 	       TDaoAffectation newAff = new TDaoAffectation(); 
	    				 		   newAff.setDafDacCode(newDao.getDacCode());
	    				 		   newAff.setDafOpeMatricule(sltImput.getOpeMatricule());
	    				 		   newAff.setDafStaCode(newDao.getTStatut().getStaCode());
	    				 		   newAff.setDafStatutRetour(newDao.getDacStatutRetour());
	    				 		   newAff.setDafDacObjet(newDao.getDacObjet());
	    				 		   newAff.setDafTypeDac(newDao.getTTypeDacSpecs().getTdcCode());
	    				 		   newAff.setDafDacGestion(newDao.getTGestion().getGesCode());
	    				 		   newAff.setDafTypePlan(newDao.getDacTypePlan());
	    				 		   newAff.setDafDacStr(newDao.getTStructure().getStrCode());
	    				 		   newAff.setDafDacRecherche(newDao.getDacRecherche());
	    				 		   newAff.setDafDcsMbmRespo(det.getDcsMbmRespo());
	    				 		   newAff.setTDetCommissionSeance(det);
	    				 		   newAff.setTModePassation(new TModePassation(newDao.getTModePassation().getMopCode()));
	    				 		   newAff.setTTypeMarche(new TTypeMarche(newDao.getTTypeMarche().getTymCode()));
	    				 		   newAff.setDafMention(newDao.getDacMention());
	    				 		   iservice.addObject(newAff);
	    		              }
		   		   //Chargement des fonctions Ã  imputer
		   		   chargeFonctionImput();
		   		  //Message de Confirmation
		   		  userController.setTexteMsg("Responsabilité Attribuée avec succès!");
				  userController.setRenderMsg(true);
				  userController.setSevrityMsg("success");
		       }
	        }
	 
	 
	     //Affectation Normale d'une fonction (Binome)
		 public void saveAffectation() {            
			 listSeances =  (List<TSeances>) iservice.getObjectsByColumn("TSeances", new ArrayList<String>(Arrays.asList("SEA_NUM")),
						new WhereClause("SEA_TSE_CODE",WhereClause.Comparateur.EQ,"CIA"), 
						new WhereClause("SEA_OBSERVATION",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()),
						new WhereClause("SEA_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			            new WhereClause("SEA_FON_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			       if(!listSeances.isEmpty()) { 
			    	   sltSeances=listSeances.get(0);
					    	   updateDao();
					    	    
					    	     TCommissionSpecifique com = new TCommissionSpecifique();
						  	     com.setTStructure(new TStructure(sltImput.getStrCode()));
						  	     com.setTDacSpecs(newDao);
						  	     com.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
						  	     com.setTTypeCommission(new TTypeCommission("CIA"));
						  	     com.setComDteSaisi(Calendar.getInstance().getTime());
						  	     com.setComMarCode(slctdTd.getTymCode());
						  	     iservice.addObject(com);
						  	 	 
					    	     TDetCommissionSeance det = new TDetCommissionSeance();
						   		 det.setDcsDteSaisi(Calendar.getInstance().getTime());
						   		 det.setDcsFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
						   		 det.setTDacSpecs(newDao);
						   		 det.setTSeances(sltSeances);
						   		 det.setDcsFonCod(sltImput.getFonCod());
						   		 det.setDcsOpeMatricule(sltImput.getOpeMatricule());
						   		 det.setTStructure(new TStructure(sltImput.getStrCode()));
						   		 det.setTCommissionSpecifique(com);
						   		 det.setTOperateur(userController.getSlctd().getTOperateur());
						   		 det.setTTypeCommission(new TTypeCommission(com.getTTypeCommission().getTcoCode()));
						   		 det.setDcsPresent("O");
						   		 det.setDcsNomMbm(sltImput.getOpeNom());
						   		 det.setDcsTelMbm(sltImput.getOpeContact());
						   		 det.setDcsMbmRespo("N");
						   		 iservice.addObject(det);  
						   		 
						      	//Enregistrement dans TDaoAffectation
						   		listeDaoAff = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
										new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,""+sltImput.getOpeMatricule()), 
										new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
					    	              if(!listeDaoAff.isEmpty()) { 
					    		              supDaoAff=listeDaoAff.get(0);
					    		              supDaoAff.setDafDcsMbmRespo("N");
					    		              iservice.updateObject(supDaoAff);
					    		              }else {
					    		            	//Enregistrement dans TDaoAffectation
					    				 	       TDaoAffectation newAff = new TDaoAffectation(); 
					    				 		   newAff.setDafDacCode(newDao.getDacCode());
					    				 		   newAff.setDafOpeMatricule(sltImput.getOpeMatricule());
					    				 		   newAff.setDafStaCode(newDao.getTStatut().getStaCode());
					    				 		   newAff.setDafStatutRetour(newDao.getDacStatutRetour());
					    				 		   newAff.setDafDacObjet(newDao.getDacObjet());
					    				 		   newAff.setDafTypeDac(newDao.getTTypeDacSpecs().getTdcCode());
					    				 		   newAff.setDafDacGestion(newDao.getTGestion().getGesCode());
					    				 		   newAff.setDafTypePlan(newDao.getDacTypePlan());
					    				 		   newAff.setDafDacStr(newDao.getTStructure().getStrCode());
					    				 		   newAff.setDafDacRecherche(newDao.getDacRecherche());
					    				 		   newAff.setDafDcsMbmRespo(det.getDcsMbmRespo());
					    				 		   newAff.setTDetCommissionSeance(det);
					    				 		   newAff.setTModePassation(new TModePassation(newDao.getTModePassation().getMopCode()));
					    				 		   newAff.setTTypeMarche(new TTypeMarche(newDao.getTTypeMarche().getTymCode()));
					    				 		   newAff.setDafMention(newDao.getDacMention());
					    				 		   iservice.addObject(newAff);
					    		              }
						   		//Chargement des fonctions Ã  imputer 
						   		 chargeFonctionImput();
						   		//Message de Confirmation 
						   		userController.setTexteMsg("Responsabilité Attribuée avec succès!");
								userController.setRenderMsg(true);
								userController.setSevrityMsg("success");
			       }else {
			    	   
			    	   updateDao();
			    	   
			    	   String chaine="SEANCE DE COMMISSION INTERNE D'ANALYSE DU DAO N°";
			  		   String exo=chaine+newDao.getDacCode();
			  		   newSeance.setTFonction(userController.getSlctd().getTFonction());
			  		   newSeance.setTOperateur(userController.getSlctd().getTOperateur());
			  		   newSeance.setTTypeSeance(new TTypeSeance("CIA"));
			  		   newSeance.setSeaSteSaisi(Calendar.getInstance().getTime());
			  		   newSeance.setSeaLibelle(exo);
			  		   newSeance.setSeaObservation(newDao.getDacCode());
			  		   iservice.addObject(newSeance);		
			  	    		 
			  	       TCommissionSpecifique com = new TCommissionSpecifique();
			  	       com.setTStructure(new TStructure(sltImput.getStrCode()));
			  	       com.setTDacSpecs(newDao);
			  	       com.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
			  	       com.setTTypeCommission(new TTypeCommission("CIA"));
			  	       com.setComDteSaisi(Calendar.getInstance().getTime());
			  	       com.setComMarCode(slctdTd.getTymCode());
			  	       iservice.addObject(com);
			  	 	
			  		   TDetCommissionSeance det = new TDetCommissionSeance();
			   		   det.setDcsDteSaisi(Calendar.getInstance().getTime());
			   		   det.setDcsFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
			   		   det.setTDacSpecs(newDao);
			   		   det.setTSeances(newSeance);
			   		   det.setDcsFonCod(sltImput.getFonCod());
			   		   det.setDcsOpeMatricule(sltImput.getOpeMatricule());
			   		   det.setTStructure(new TStructure(sltImput.getStrCode()));
			   		   det.setTCommissionSpecifique(com);
			   		   det.setTOperateur(userController.getSlctd().getTOperateur());
			   		   det.setTTypeCommission(new TTypeCommission(com.getTTypeCommission().getTcoCode()));
			   		   det.setDcsPresent("O");
			   		   det.setDcsNomMbm(sltImput.getOpeNom());
			   		   det.setDcsTelMbm(sltImput.getOpeContact());
			   		   det.setDcsMbmRespo("N");
			   		   iservice.addObject(det); 
			   		   
			   		   listeDaoAff = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
							new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,""+sltImput.getOpeMatricule()), 
							new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
		    	              if(!listeDaoAff.isEmpty()) { 
		    		              supDaoAff=listeDaoAff.get(0);
		    		              supDaoAff.setDafDcsMbmRespo("N");
		    		              iservice.updateObject(supDaoAff);
		    		              }else {
		    		            	//Enregistrement dans TDaoAffectation
		    				 	       TDaoAffectation newAff = new TDaoAffectation(); 
		    				 		   newAff.setDafDacCode(newDao.getDacCode());
		    				 		   newAff.setDafOpeMatricule(sltImput.getOpeMatricule());
		    				 		   newAff.setDafStaCode(newDao.getTStatut().getStaCode());
		    				 		   newAff.setDafStatutRetour(newDao.getDacStatutRetour());
		    				 		   newAff.setDafDacObjet(newDao.getDacObjet());
		    				 		   newAff.setDafTypeDac(newDao.getTTypeDacSpecs().getTdcCode());
		    				 		   newAff.setDafDacGestion(newDao.getTGestion().getGesCode());
		    				 		   newAff.setDafTypePlan(newDao.getDacTypePlan());
		    				 		   newAff.setDafDacStr(newDao.getTStructure().getStrCode());
		    				 		   newAff.setDafDacRecherche(newDao.getDacRecherche());
		    				 		   newAff.setDafDcsMbmRespo(det.getDcsMbmRespo());
		    				 		   newAff.setTDetCommissionSeance(det);
		    				 		   newAff.setTModePassation(new TModePassation(newDao.getTModePassation().getMopCode()));
		    				 		   newAff.setTTypeMarche(new TTypeMarche(newDao.getTTypeMarche().getTymCode()));
		    				 		   newAff.setDafMention(newDao.getDacMention());
		    				 		   iservice.addObject(newAff);
		    		              }
			   		   //Chargement des fonctions Ã  imputer
			   		   chargeFonctionImput();
			   		  //Message de Confirmation
			   		  userController.setTexteMsg("Responsabilité Attribuée avec succès!");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");
			       }
		        }
	 
	 //Mis à jour du responsable (O/N)
	 public void updateAffectation (String respo) {   
		 if(sltImput.getDcsNum() == null) {
			 dcsNum = 0;
		 }else {
			 dcsNum = sltImput.getDcsNum().longValue();
		 }
		 
		 listeDetCom = (List<TDetCommissionSeance>) iservice.getObjectsByColumn("TDetCommissionSeance", new ArrayList<String>(Arrays.asList("DCS_NUM")),
					new WhereClause("DCS_NUM",WhereClause.Comparateur.EQ,""+dcsNum));
		     if(!listeDetCom.isEmpty()) { 
		    	 supDetCom=listeDetCom.get(0);
		    	 supDetCom.setDcsMbmRespo(""+respo);
		    	 iservice.updateObject(supDetCom);
		    	 
		    	 listeDaoAff = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
							new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,""+sltImput.getOpeMatricule()), 
							new WhereClause("DAF_DCS_NUM",WhereClause.Comparateur.EQ,""+supDetCom.getDcsNum()));
		    	 if(!listeDaoAff.isEmpty()) { 
		    		 supDaoAff=listeDaoAff.get(0);
		    		 supDaoAff.setDafDcsMbmRespo(supDetCom.getDcsMbmRespo());
			    	 iservice.updateObject(supDaoAff);
		    	 }
		    	//Chargement des fonctions à imputer 
		   		 chargeFonctionImput();
		   		//Message de Confirmation 
		   		userController.setTexteMsg("Responsabilité Attribuée avec succès!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");
		     }else {
		    	 FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cette fonction n'a pas encore fait objet d'une affectation", ""));
		     }	
		 }
	 
	 
	//Suppresson d'une affectation
		 public void deleteAffectation() {  
			 if(sltImput.getDcsNum() == null) {
				 dcsNum = 0;
			 }else {
				 dcsNum = sltImput.getDcsNum().longValue();
			 }
			 
			 listeDetCom = (List<TDetCommissionSeance>) iservice.getObjectsByColumn("TDetCommissionSeance", new ArrayList<String>(Arrays.asList("DCS_NUM")),
						new WhereClause("DCS_NUM",WhereClause.Comparateur.EQ,""+dcsNum));
			     if(!listeDetCom.isEmpty()) { 
			    	 supDetCom=listeDetCom.get(0);
			    	 
			    	 listeDaoAff = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
								new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,""+sltImput.getOpeMatricule()), 
								new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
			    	 if(!listeDaoAff.isEmpty()) { 
			    		 supDaoAff=listeDaoAff.get(0);
			    		 }
				    	 
				    //Suppression dans T_DAO_AFFECTATION
			    	 iservice.deleteObject(supDaoAff);
			    	 //Suppression dans T_DET_COMMISSION_SEANCE
			    	 iservice.deleteObject(supDetCom);
			    	//Chargement des fonctions à imputer 
			   		 chargeFonctionImput();
			   		//Message de Confirmation 
			   		userController.setTexteMsg("Responsabilité Attribuée avec succès!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");
			     }else {
			    	 FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cette fonction n'a encore fait objet d'une affectation", ""));
			     }
			 }
		     
	 //affichage des critères par lot
	 public void chargeCritereByLot() { 			 
		 listeCritereByLot.clear();
		 listeCritereByLot = ((List<VCritereAnalyseDac>)iservice.getObjectsByColumn("VCritereAnalyseDac",
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId)));
				 _logger.info("liste critere du lot : "  +""+laaId+" " +listeCritereByLot.size());
			 }
	 
	 
	 //Afficahe de la liste des critÃ¯Â¿Â½res en fonction des types passé en parametre
	/* public void chargeCritere() {
		 if(controleController.type == "DAC" && controleController.typePlan == "PN") {	
			 chargeCritereByType("PN","DAO");
			 }else {
				 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
					 chargeCritereByType("PS","DAO");
				 }else {
					 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
						 chargeCritereByType("PN","AMI");
					 }else {
						 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
							 chargeCritereByType("PN","PRQ");
						 }
					 }
			     } 
			 }
		 _logger.info("procédure: "+controleController.getTypePlan());
		 _logger.info("type dac: "+controleController.getType());
	 }*/
	 
		//Combo box critÃ¯Â¿Â½res
	 
	 public void chargeCritereCombobox() {
			 //laaId = 0;
		 //vider le champ detail
		  newCritereDac = new VbDetCritAnalyseDac(); 
		 listeEnteteCritere.clear(); 
		 listeEnteteCritere = ((List<VCritAnalDacEntete>)iservice.getObjectsByColumn("VCritAnalDacEntete",
				 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,"0"),
				 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
				 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode())));
	 }
	 
	//Combo box critères Pou l'ecran de factorisation
	 public void chargeCritereFactCombobox() {
		 //vider le champ detail
		  newCritereDac = new VbDetCritAnalyseDac(); 
		 listeEnteteCritere.clear(); 
		 listeEnteteCritere = ((List<VCritAnalDacEntete>)iservice.getObjectsByColumn("VCritAnalDacEntete",
				 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
				 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
				 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode())));
	 }
	 
	 public void chargeCritereCombobox1() {
		/* if(lot.getLaaId()==null) {
			 laaId = 0;
		 }else
		 {
			 laaId = lot.getLaaId();
		 }*/
		 //vider le champ detail
		  newCritereDac = new VbDetCritAnalyseDac(); 
		 listeEnteteCritere.clear(); 
		 listeEnteteCritere = ((List<VCritAnalDacEntete>)iservice.getObjectsByColumn("VCritAnalDacEntete",
				 //new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
				 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
				 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode())));
	 }
	 
	 
	//Combo box critères
	 public void chargeSousEnteteCombobox() {
			 listeEnteteCritere= (List<VCritAnalDacEntete>) iservice.getObjectsByColumn("VCritAnalDacEntete", new ArrayList<String>(Arrays.asList("CRA_LIBELLE")),
					 new WhereClause("R_ID",WhereClause.Comparateur.EQ,""+rId));
			 if(!listeEnteteCritere.isEmpty()) { 
				 newEnteteCrit=listeEnteteCritere.get(0);
				 //vider le champs detail
				  newCritereDac = new VbDetCritAnalyseDac();
				  listeSousEnteteCritere.clear(); 
				  listeSousEnteteCritere  = ((List<VCritAnalDacSousentete>)iservice.getObjectsByColumn("VCritAnalDacSousentete",
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
						 new WhereClause("CRA_PARENT",WhereClause.Comparateur.EQ,""+newEnteteCrit.getCraCode()),
						 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode())));
				  
				  _logger.info("lot: "+laaId);
				  _logger.info("Dao: "+dao.getDacCode());
				  _logger.info("cracode: "+newEnteteCrit.getCraCode());
				  _logger.info("mdt: "+dao.getTModeleDacType().getMdtCode());
			 }
			 
	 }
	 
	 public void chargeCritereComboboxByLot() {
		 dao.setDacFactoriseCrit(2);
		 iservice.updateObject(dao);
		 
		 if(lot.getLaaId()==null) {
		 }else
		 {
			 laaId=lot.getLaaId();
		 }
		 //vider le champs detail
		  newCritereDac = new VbDetCritAnalyseDac(); 
		 listeEnteteCritere.clear(); 
		 listeEnteteCritere = ((List<VCritAnalDacEntete>)iservice.getObjectsByColumn("VCritAnalDacEntete",
				 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
				 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
				 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode())));
		 
	 }
	 
	//Entete critere 
	 public void saveCritereEntete() {
		 newEnteteCritere.setCraCode(craCode);
		 iservice.addObject(newEnteteCritere);
		 chargeCritereCombobox();
	 }
	 
	 public void saveDetailCritere() {
		 //long dcadNum =0;
		//VbDetCritAnalyseDac newCritereDac = new VbDetCritAnalyseDac();
		//VCritAnalDacEntete newEnteteCrit = new VCritAnalDacEntete();
		
		 listeEnteteCritere= (List<VCritAnalDacEntete>) iservice.getObjectsByColumn("VCritAnalDacEntete", new ArrayList<String>(Arrays.asList("CRA_LIBELLE")),
				 new WhereClause("R_ID",WhereClause.Comparateur.EQ,""+rId));
		 
		 if(!listeEnteteCritere.isEmpty()) { 
			 newEnteteCrit=listeEnteteCritere.get(0);
			 
			 newCritereDac.setDcadDacCode(dao.getDacCode());
			 newCritereDac.setDcadDanCraCode(newEnteteCrit.getCraCode());
			 //newCritereDac.setDcadFact("C");
			 newCritereDac.setDcadCraAuCode(newEnteteCrit.getDcadCraAuCode());
			 newCritereDac.setDcadDanCode("99999999999");
			 if(newEnteteCrit.getDcadNum()==null) {
				dcadNum=0;
			 }else
			 {
			  dcadNum = newEnteteCrit.getDcadNum();
			 }
			 newCritereDac.setDcadNumDcad(dcadNum);
			 newCritereDac.setDcadDteSaisie(Calendar.getInstance().getTime());
			 newCritereDac.setDcadOpeCode(userController.getSlctd().getTOperateur().getOpeMatricule());
			 newCritereDac.setDcadStatut("1");
			 iservice.addObject(newCritereDac);
			 
			 //Insertion dans temp param
			 newTempCritereDac.setCraDacCode(dao.getDacCode());
	 		 newTempCritereDac.setCraDteSaisi(Calendar.getInstance().getTime());
	 		 newTempCritereDac.setCraOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
	 		 newTempCritereDac.setCraType("CRA");
	 		 iservice.addObject(newTempCritereDac);
	 		 
			 newCritereDac = new VbDetCritAnalyseDac();
			 newTempCritereDac = new VbTempCritere();
			 craCode ="";
			 chargeCritereSaisie(); 
			 chargeCritereCombobox();
			 //chargeCritereCombobox();
		 } 
	 }
	 
	 public void saveSousCritere() {
		 //long dcadNum =0;
		//VbDetCritAnalyseDac newCritereDac = new VbDetCritAnalyseDac();
		//VCritAnalDacEntete newEnteteCrit = new VCritAnalDacEntete();
		
		 listeEnteteCritere= (List<VCritAnalDacEntete>) iservice.getObjectsByColumn("VCritAnalDacEntete", new ArrayList<String>(Arrays.asList("CRA_LIBELLE")),
				 new WhereClause("R_ID",WhereClause.Comparateur.EQ,""+rId));
		 
		 if(!listeEnteteCritere.isEmpty()) { 
			 newEnteteCrit=listeEnteteCritere.get(0);
			 
			 listeSousEnteteCritere= (List<VCritAnalDacSousentete>) iservice.getObjectsByColumn("VCritAnalDacSousentete", new ArrayList<String>(Arrays.asList("CRA_LIBELLE")),
					 new WhereClause("R_ID",WhereClause.Comparateur.EQ,""+rIdSous));
			 if(!listeSousEnteteCritere.isEmpty()) { 
				 newSousEnteteCrit =listeSousEnteteCritere.get(0);
				 newCritereDac.setDcadDacCode(dao.getDacCode());
				 newCritereDac.setDcadDanCraCode("null");
				 newCritereDac.setDcadLibAjust(newSousEnteteCrit.getCraLibelle());
				 newCritereDac.setDcadCraAuCode(newEnteteCrit.getDcadCraAuCode());
				 newCritereDac.setDcadDanCode(newSousEnteteCrit.getCraCode());
				 if(newEnteteCrit.getDcadNum()==null) {
					dcadNum=0;
				 }else
				 {
				  dcadNum = newEnteteCrit.getDcadNum();
				 }
				 newCritereDac.setDcadNumDcad(dcadNum);
				 newCritereDac.setDcadDteSaisie(Calendar.getInstance().getTime());
				 newCritereDac.setDcadOpeCode(userController.getSlctd().getTOperateur().getOpeMatricule());
				 newCritereDac.setDcadStatut("1");
				 iservice.addObject(newCritereDac);
				 newCritereDac = new VbDetCritAnalyseDac();
				 craCode ="";
				 chargeCritereByLot();
				 //chargeCritereSaisie(); 
				 chargeCritereCombobox();
	          }
		 } 
	 }
	 
	 //verification de la combox critere existent ou pas
	  public void checkCritere() {
			 //chargeMsgMarge();
			 if(choixCritere.equalsIgnoreCase("existant")) { 
				 panelExixstent = true; 
				 panelNouveau = false;
			 }else 
			 {
				 panelExixstent = false; 
				 panelNouveau = true; 
			 }
			 _logger.info("panelExixstent: "+panelExixstent);	
			 _logger.info("panelNouveau: "+panelNouveau);
		 }
	 
	 //Enregistrement detail critere par lot
	 public void saveDetailCritereByLot() {	

		 listeEnteteCritere= (List<VCritAnalDacEntete>) iservice.getObjectsByColumn("VCritAnalDacEntete", new ArrayList<String>(Arrays.asList("CRA_LIBELLE")),
				 new WhereClause("R_ID",WhereClause.Comparateur.EQ,""+rId));
		 
		 if(!listeEnteteCritere.isEmpty()) { 
			 newEnteteCrit=listeEnteteCritere.get(0);
			 newCritereDac.setDcadDacCode(dao.getDacCode());
			 newCritereDac.setDcadDanCraCode(newEnteteCrit.getCraCode());
			 newCritereDac.setDcadCraAuCode(newEnteteCrit.getDcadCraAuCode());
			 newCritereDac.setDcadDanCode("99999999999");
			 newCritereDac.setDcadLaaId(laaId);
			 if(newEnteteCrit.getDcadNum()==null) {
				dcadNum=0;
			 }else
			 {
			  dcadNum = newEnteteCrit.getDcadNum();
			 }
			 newCritereDac.setDcadNumDcad(dcadNum);
			 newCritereDac.setDcadDteSaisie(Calendar.getInstance().getTime());
			 newCritereDac.setDcadOpeCode(userController.getSlctd().getTOperateur().getOpeMatricule());
			 newCritereDac.setDcadStatut("1");
			 iservice.addObject(newCritereDac);
			 //Insertion dans temp param
			 newTempCritereDac.setCraDacCode(dao.getDacCode());
	 		 newTempCritereDac.setCraDteSaisi(Calendar.getInstance().getTime());
	 		 newTempCritereDac.setCraOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
	 		 newTempCritereDac.setCraType("CRA");
	 		 iservice.addObject(newTempCritereDac);
			 newCritereDac = new VbDetCritAnalyseDac();
			 craCode ="";
			 chargeCritereByLot();
			 //chargeCritereSaisie(); 
			 chargeCritereCombobox();
		 } 
	 }
	
	 
	//ContÃ´le sur les options "Garantie de Soumission et Déclaration de Garantie de Soumission"
	public void afficheOption() {
		 listeCritereAnalyse= (List<VCritereAnalyseModel>) iservice.getObjectsByColumn("VCritereAnalyseModel", new ArrayList<String>(Arrays.asList("CRA_CODE")),
					new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode()),
		            new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		if(!listeCritereAnalyse.isEmpty()) { 
			critereObject=listeCritereAnalyse.get(0);
			
			if(critereObject.getFlag().equalsIgnoreCase("1")) {
				daoCritere = false;
				 _logger.info("valeur Flag : "+critereObject.getFlag());
			}else {
				daoCritere = true;
				 _logger.info("valeur Flag : "+critereObject.getFlag());
			}
	    }
	}
	 
	 //Enregistrement des critères
	 public void saveCritere() {
		 
		 if (selectionlisteCritereAnalyse.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun critère selectionné", ""));
			}
	 		else{
	 			/*selectionlisteCritereAnalyse = (List<VCritereAnalyseModel>) iservice.getObjectsByColumn("VCritereAnalyseModel", new ArrayList<String>(Arrays.asList("DAC_CODE")),
	 					new WhereClause("CODPARENT",WhereClause.Comparateur.NEQ,"null"));*/
		 		 for(VCritereAnalyseModel ligne : selectionlisteCritereAnalyse) {
		 			 //Insertion directemenet dans la trable sans passer par temp
		 			/*newCritereDac.setDcadDacCode(dao.getDacCode());
		 			newCritereDac.setDcadDanCode(ligne.getCodedetail());
		 			//newCritereDac.setDcadDanCraCode(ligne.getCraCode());
		 			newCritereDac.setDcadLaaId(0);
		 			newCritereDac.setDcadDteSaisie(Calendar.getInstance().getTime());
		 			newCritereDac.setDcadLibAjust(ligne.getCraLibelle());
		 			newCritereDac.setDcadOpeCode(userController.getSlctd().getTOperateur().getOpeMatricule());
		 			newCritereDac.setDcadStatut("1");
		 			iservice.addObject(newCritereDac);*/
		 			
		 			//Insertion en passant par le temp param(trigger)
		 			 
		 			newTempCritere.setCriDacCode(dao.getDacCode());
		 			newTempCritere.setCriDcadDanCode(ligne.getCodedetail());
		 			newTempCritere.setCriDcadLaaId("0");
		 			newTempCritere.setCriDteSaisi(Calendar.getInstance().getTime());
		 			newTempCritere.setCriLibelle(ligne.getCraLibelle());
		 			newTempCritere.setCriOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
		 			newTempCritere.setCriDcadStatut("1");
		 			newTempCritere.setTempType("CRI");
		 			iservice.addObject(newTempCritere);
			     }
	 			
		 		selectionlisteCritereAnalyse.clear();
		 		chargeCritereSaisie();
		 		chargeCritere();
		 		chargeLotCritere();
		 		///afficheOption();
		 		pavet_commission = true;
		 		userController.setTexteMsg("Critère(s) d'analyse enregistré(s) avec succès!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");
	 		 }
	 }
	 
	 
	//Factorisation des Lots
	 public void factoriserLot() { 
		 newTempFactorise.setTempCritDac(dao.getDacCode());
		 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
		 newTempFactorise.setTempType("DISP");
		 iservice.addObject(newTempFactorise); 
		 chargeLotCritere();
		 panelMessage = false;
		 panelCritereLot = true;
	 }
	 
	 //Récupération du message
	 public void factoriserNext() { 
		 newTempFactorise.setTempCritDac(dao.getDacCode());
		 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
		 newTempFactorise.setTempType("TEST");
		 iservice.addObject(newTempFactorise); 
		 chargeLotCritere();
		 recupMessage();
		 panelMessage = true;
		 panelCritereLot = false;
	 }
	 
	 public void checkTypeCommission() { 
		 if(typeCommission.equalsIgnoreCase("N")) {
			  comNormale = true;
			  comSpeciale = false;
			  comAutorise = false;
			 
		 }else
		 {
			 comNormale = false;
			 comAutorise = false;
			 comSpeciale = true; 
			 
		 }	
		 _logger.info("typeCommission: "+typeCommission);	
	 }
	 
	 @Transactional
	 public void factoriserAutoriz() {
		 dao.setDacFactoriseCrit(2);
		 iservice.updateObject(dao);
	 }
	 
	 public void updateCritere() {
		 TDetCritAnalyseDac updateCritere = new TDetCritAnalyseDac();
		 listDetcritere = ((List<TDetCritAnalyseDac>)iservice.getObjectsByColumn("TDetCritAnalyseDac",
				 new WhereClause("DCAD_NUM",WhereClause.Comparateur.EQ,""+sltCritereDac.getDcadNum())));
		  if(!listDetcritere.isEmpty()) { 
			  updateCritere=listDetcritere.get(0);
			  updateCritere.setDcadLibAjust(sltCritereDac.getCraLibelle());
			  updateCritere.setDcadCommentaire(sltCritereDac.getDcadCommentaire());
			  iservice.updateObject(updateCritere);
			  chargeCritereSaisie();
		    userController.setTexteMsg("Modification effectuée avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
		  }
	 }
	 
	 
	 public void updateCritereByLot() {
		 TDetCritAnalyseDac updateCritere = new TDetCritAnalyseDac();
		 listDetcritere = ((List<TDetCritAnalyseDac>)iservice.getObjectsByColumn("TDetCritAnalyseDac",
				 new WhereClause("DCAD_NUM",WhereClause.Comparateur.EQ,""+sltCritereDac.getDcadNum())));
		  if(!listDetcritere.isEmpty()) { 
			  updateCritere=listDetcritere.get(0);
			  updateCritere.setDcadLibAjust(sltCritereDac.getCraLibelle());
			  updateCritere.setDcadCommentaire(sltCritereDac.getDcadCommentaire());
			  iservice.updateObject(updateCritere);
			  chargeCritereByLot();
		    userController.setTexteMsg("Modification effectuée avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
		  }
	 }
	 
	 
	 public void chargeDetailTransAC1(String typePlan,String typeDac, String stat1){
		 detailTrans.clear();
		 detailTrans =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
				      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
		              new WhereClause("LBG_FON_CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("Nbre DAC: "+detailTrans.size());	
			///typeActionTb();	
	    }


     public void chargeDacTransCP1(String typePlan,String typeDac, String stat1){ 
	     detailTB.clear();
		 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
				      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
		              new WhereClause("LBG_FON_CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("Nbre DAC: "+detailTB.size());	
			//typeActionTb();	
	}
     
     public void chargeDacAffecteCsv1(String typePlan,String typeDac, String stat1){ 
	     detailTB.clear();
		 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
				      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac));
		              //new WhereClause("LBG_FON_CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("Nbre DAC: "+detailTB.size());	
			//typeActionTb();	
	}
     
     public void chargeDacDiffereCPMP(String typePlan,String typeDac, String stat1){ 
    	 detailDacDiff.clear();
    	 detailDacDiff =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
				      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
		              new WhereClause("LBG_FON_CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("Nbre DAC: "+detailTB.size());	
			//typeActionTb();	
	}   
     
     public void chargeDacDiffereCPAC(String typePlan,String typeDac, String stat1){ 
    	 detailDac.clear(); 
    	 detailDac =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
				      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
		              new WhereClause("LBG_FON_CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("Nbre DAC: "+detailTB.size());	
			//typeActionTb();	
	}
     
     //Methode de chargement des dÃ¯Â¿Â½tails diffÃ¯Â¿Â½rÃ¯Â¿Â½s pour le compte des chefs de service
     public void chargeDacDiffereCSV(String typePlan,String typeDac, String stat1){ 
	     detailTB.clear();
		 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
				      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac));
		              //new WhereClause("LBG_FON_CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("Nbre DAC: "+detailTB.size());	
			//typeActionTb();	
	} 
	 
	 //DÃ¯Â¿Â½tails des DAC transmis des compteurs
	 public void chargeDetailTrans() {
		// String fonct = controleController.getFonctionalite();
		 //DEBUT DAO PN
		 if(controleController.type == "DAC" && controleController.typePlan == "PN") { 
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 //Affichage des differentes listes de l'AC en faction de l'action
						 chargeDetailTransAC1("PN", "DAO", "D1T");	
		       //Finaffichage ac
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 chargeDacTransCP1("PN", "DAO", "D2T"); 
			   }
		   }
		}
		//FIN DAO PN
		 
		//DEBUT DAO PS
		 else {
			 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
                 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 chargeDetailTransAC1("PS", "DAO", "D1T");	
		       //Finaffichage ac
			     }else {
				    if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				    	chargeDacTransCP1("PS", "DAO", "D2T"); 
			       }
			    }
			 }
			//FIN DAO PS
			 
			//DEBUT DAO AMI 
			 else {
				 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
					 chargeDetailPF1("PN", "AMI", "D1T");
				 }
				//FIN AMI
				 
				//DEBUT PRQ
				 else {
					 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
						 chargeDetailTransAC1("PN", "PRQ", "D1T");
					 }
					 
					//FIN PRQ
				 }
		     } 
		   }
	 } 
	//Fin des dÃ¯Â¿Â½tails des DAC Transmis des compteurs
	 
	 
	 //DÃ¯Â¿Â½tails des DAC affectes des compteurs
	 public void chargeDetailAffecte() {
		// String fonct = controleController.getFonctionalite();
		 //DEBUT DAO PN
		 if(controleController.type == "DAC" && controleController.typePlan == "PN") { 
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
				 //Affichage des differentes listes de l'AC en faction de l'action
						 chargeDacAffecteCsv1("PN", "DAO", "D3A");	
			 }
		}
		//FIN DAO PN
		//DEBUT DAO PS
		 else {
			 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
                 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
						 chargeDacAffecteCsv1("PS", "DAO", "D3A");	
		       //Finaffichage ac
			     }
			 }
			//FIN DAO PS
			//DEBUT DAO AMI 
			 else {
				 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
                                      chargeDacAffecteCsv1("PN", "AMI", "D3A");
				    }
				//FIN AMI
				//DEBUT PRQ
				 else {
					 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {                                                chargeDacAffecteCsv1("PN", "PRQ", "D3A");
					                chargeDacAffecteCsv1("PN", "PRQ", "D3A");
					 }
					 
					//FIN PRQ
				 }
		     } 
		   }
	 }  
	//Fin de la Methode 
	 
	//DÃ¯Â¿Â½tails des DAC validÃ¯Â¿Â½s par le Chef de Service
		 public void chargeDetailValide() {
			// String fonct = controleController.getFonctionalite();
			 //DEBUT DAO PN
			 if(controleController.type == "DAC" && controleController.typePlan == "PN") { 
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
					 //Affichage des differentes listes de l'AC en faction de l'action
							 chargeDacAffecteCsv1("PN", "DAO", "D5V");	
				 }
			}
			//FIN DAO PN
			//DEBUT DAO PS
			 else {
				 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
	                 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
							 chargeDacAffecteCsv1("PS", "DAO", "D5V");	
				     }
				 }
				//FIN DAO PS
				//DEBUT DAO AMI 
				 else {
					 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
	                                      chargeDacAffecteCsv1("PN", "AMI", "D5V");
					    }
					//FIN AMI
					//DEBUT PRQ
					 else {
						 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {                                                
							            chargeDacAffecteCsv1("PN", "PRQ", "D3A");
						                chargeDacAffecteCsv1("PN", "PRQ", "D5V");
						 }
						//FIN PRQ
					 }
			     } 
			   }
		 }  
		//Fin de la Methode
	 
		//DÃ¯Â¿Â½tails des DAC diffÃ¯Â¿Â½rÃ¯Â¿Â½s par la Cellule / le Chef de Service et l'AutoritÃ¯Â¿Â½ Contractante
		 public void chargeDetailDiffere() {
			String fonct = controleController.getFonctionalite();
			 //DEBUT DAO PN
			 if(controleController.type == "DAC" && controleController.typePlan == "PN") { 
					   if(fonct == "listeDacValCellule") {
						   if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
						   chargeDacDiffereCPMP("PN", "DAO", "D1R");
						   }
					   }else {
						      if(fonct == "listeValidationCsv") {
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
						    	  chargeDacDiffereCSV("PN", "DAO", "D5R");
						    	 }
						      }else {
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						    	      if(fonct == "listSaisieAc") {
						    		       chargeDacDiffereCPAC("PN", "DAO", "D1R");
						    	         }
						    	  }
						      }
					   }
			}
			//FIN DAO PN
			//DEBUT DAO PS
			 else {
				 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
	                	       if(fonct == "listeDacValCellule") {
	                	    	   if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
	                	    	   chargeDacDiffereCPMP("PS", "DAO", "D1R");
	                	    	   }
	    					   }else {
	    						      if(fonct == "listeValidationCsv") {
	    						    	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
	    						    	  chargeDacDiffereCSV("PS", "DAO", "D5R");
	    						    	  }
	    						      }else {
	    						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
	    						    	      if(fonct == "listSaisieAc") {
	    						    		     chargeDacDiffereCPAC("PS", "DAO", "D1R");
	    						    	       }
	    						    	    }
	    						      }
	    					   }
				 }
				//FIN DAO PS
				//DEBUT DAO AMI 
				 else {
					 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
						    if(fonct == "listeDacValCellule") {
						    	if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) { 
	    						   //Affichage des differentes listes de l'AC en faction de l'action
						    	 chargeDacDiffereCPMP("PN", "AMI", "D1R");
						          }
	    					   }else {
	    						      if(fonct == "listeValidationCsv") {
	    						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
	    						    	  chargeDacDiffereCSV("PN", "AMI", "D5R");
	    						    	  }
	    						      }else {
	    						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
	    						    	     if(fonct == "listSaisieAc") {
	    						    		  chargeDacDiffereCPAC("PN", "AMI", "D1R");
	    						    	      }
	    						    	  }
	    						      }
	    					   }
					    }
					//FIN AMI
					//DEBUT PRQ
					 else {
						 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {  
						             if(fonct == "listeDacValCellule") {
						            	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
			    						   //Affichage des differentes listes de l'AC en faction de l'action
								    	 chargeDacDiffereCPMP("PN", "PRQ", "D1R");
						            	 }
			    					   }else {
			    						      if(fonct == "listeValidationCsv") {
			    						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
			    						    	  chargeDacDiffereCSV("PN", "PRQ", "D5R");
			    						    	  }
			    						      }else {
			    						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			    						    	     if(fonct == "listSaisieAc") {
			    						    		    chargeDacDiffereCPAC("PN", "PRQ", "D1R");
			    						    	      }
			    						    	  }
			    						      }
						 }
						//FIN PRQ
					 }
			     } 
			   }
			 }
		 }  
		//Fin de la Methode 
	 
	 //Suppression du critère du détail
	 public void deleteCritere() {
		 /*listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
					new WhereClause("DCAD_NUM",WhereClause.Comparateur.EQ,""+sltCritereDac.getDcadNum()));
	       if (!listeDetCritere.isEmpty()) {
	    	   detCritere = listeDetCritere.get(0);
	  		 iservice.deleteObject(detCritere); 
	  		 chargeCritereSaisie();
	  		 chargeCritere();
	  		userController.setTexteMsg("Suppression effectuée avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
	       }*/
	       
	        /* newTempFactorise.setTempCritDac(dao.getDacCode());
			 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
			 newTempFactorise.setTempDcadNum(sltCritereDac.getDcadNum().toString());
			 newTempFactorise.setTempType("SUP");
			 iservice.addObject(newTempFactorise);*/
			 newTempFactSup.setTempCritDac(dao.getDacCode());
			 newTempFactSup.setTempDcadNum(sltCritereDac.getDcadNum().toString());
		  	 newTempFactSup.setTempNbrLot(newAvis.getAaoNbrLot());
		  	 newTempFactSup.setTempLotPlage("");
		     newTempFactSup.setTempType("SUP");
			 iservice.addObject(newTempFactSup);
			 chargeCritereSaisie();
	  		 chargeCritere();
			 userController.setTexteMsg("Suppression effectuée avec succès!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
			 
			 _logger.info("DAC: "+dao.getDacCode());
			 _logger.info("DCAD NUM: "+sltCritereDac.getDcadNum().toString());
			 _logger.info("Nbre Lot: "+newAvis.getAaoNbrLot());
			 _logger.info("TYPE : "+newTempFactSup.getTempType());
	 }
	 
	 //Fin de la méthode de suppression du détail de critère
	 
	 //Suppression du critère du détail
	 public void deleteCritereLot() {
		/* listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
				     new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
					 new WhereClause("DCAD_NUM",WhereClause.Comparateur.EQ,""+sltCritereDac.getDcadNum()));
	       if (!listeDetCritere.isEmpty()) {
	    	   detCritere = listeDetCritere.get(0);
	  		   iservice.deleteObject(detCritere); 
	  		   chargeCritereSaisie();
	  		    chargeCritere();
	  		   chargeCritereByLot();
	  		userController.setTexteMsg("Suppression effectuée avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
	       }*/
	       
		 listeLot = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")),
			     new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()), 
				 new WhereClause("LAA_ID",WhereClause.Comparateur.EQ,""+laaId));
       if (! listeLot.isEmpty()) {
    	   lots = listeLot.get(0);
       }
	         /*newTempFactorise.setTempCritDac(dao.getDacCode());
			 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
			 newTempFactorise.setTempLotPlage(""+laaId);
			 newTempFactorise.setTempDcadNum(sltCritereDac.getDcadNum().toString());
			 newTempFactorise.setTempType("SUP");
			 iservice.addObject(newTempFactorise);*/
		     newTempFactSup.setTempCritDac(dao.getDacCode());
		     //newTempFactSup.setTempLotPlage(lots.getLaaNum().toString());
		     newTempFactSup.setTempLotPlage("");
		     newTempFactSup.setTempDcadNum(sltCritereDac.getDcadNum().toString());
	  	     newTempFactSup.setTempNbrLot(newAvis.getAaoNbrLot());
	         newTempFactSup.setTempType("SUP");
		     iservice.addObject(newTempFactSup);
			 chargeCritereSaisie();
	  		 chargeCritere();
	  		 chargeCritereByLot();
			 userController.setTexteMsg("Suppression effectuée avec succès!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
			 
			 _logger.info("DAC: "+dao.getDacCode());
			 _logger.info("Numero Lot: "+lots.getLaaNum().toString());
			 _logger.info("DCAD NUM: "+sltCritereDac.getDcadNum().toString());
			 _logger.info("Nbre Lot: "+newAvis.getAaoNbrLot());
			 _logger.info("TYPE : "+newTempFactSup.getTempType());
	 }
	 
	 //Fin de la méthode de suppression du détail de critère
	 
	 
	 //FIN GESTION DES CRITERES
	 //Affichage des AC en lui passant en parametre les statuts concerné (2 statuts)
	 public void chargeDataAc2(String typeDac,String typePlan,String stat1,String stat2){
		 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
				 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
				 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
				 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
		         new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
		         multiFiltre ="";
			_logger.info("listeDAO size: "+listeDAO.size());	
			typeActionTb(); 
	 }
	 
	 //Affichage des AC en lui passant en parametre les statuts concernÃ¯Â¿Â½ (1 statut)
	 public void chargeDataAc3(String typeDac,String typePlan,String stat1){
		 listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,""+stat1),
					new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
					new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
		         multiFiltre ="";
			_logger.info("listeDAO size: "+listeDAO.size());	
			typeActionTb(); 
	 }
	 
	 //DEBUT AFFICHAGE LISTE DAC DMP
	//Affichage des DMP en lui passant en parametre le statut concernÃ¯Â¿Â½ (1 statuts)
	 public void chargeDataDMP1(String typeDac,String typePlan,String stat1){
		 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
				 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
				 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
				 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
		         multiFiltre ="";
			_logger.info("listeDAO size: "+listeDAO.size());	
			typeActionTb(); 
	 }
	 
	//Affichage des DMP en lui passant en parametre les statuts concernÃ¯Â¿Â½ (2 statuts)
		 public void chargeDataDMP2(String typeDac,String typePlan,String stat1,String stat2){
			 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
					 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
			         multiFiltre ="";
				_logger.info("listeDAO size: "+listeDAO.size());	
				typeActionTb(); 
		 }
		//FIN AFFICHAGE LISTE DAC DMP
		 
		 //DEBUT DETAILS DES COMPTEURS
		//Debut Charge detail Compteur de l'AC
		 public void chargeDacAC1(String typePlan,String typeDac, String stat1){
			 detailTBCpt =(List<VDetTabBordDac>) iservice.getObjectsByColumnIn("VDetTabBordDac", new ArrayList<String>(Arrays.asList("DAC_DETID")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP_DAC",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTBCpt.size());	
		}
		 
		 //Debut Charge detail Compteur de l'AC
		 public void chargeDacAC2(String typePlan,String typeDac, String stat1, String stat2){
			 detailTBCpt =(List<VDetTabBordDac>) iservice.getObjectsByColumnIn("VDetTabBordDac", new ArrayList<String>(Arrays.asList("DAC_DETID")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP_DAC",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTBCpt.size());	
		}
		 
		//Debut Charge detail Compteur de la CPMP
		 public void chargeDacCP1(String typePlan,String typeDac, String stat1){
			 detailTBCpt =(List<VDetTabBordDac>) iservice.getObjectsByColumnIn("VDetTabBordDac", new ArrayList<String>(Arrays.asList("DAC_DETID")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP_DAC",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTBCpt.size());	
		}
		 
		 //Debut Charge detail Compteur de la CPMP
		 public void chargeDacCP2(String typePlan,String typeDac, String stat1, String stat2){
			 detailTBCpt =(List<VDetTabBordDac>) iservice.getObjectsByColumnIn("VDetTabBordDac", new ArrayList<String>(Arrays.asList("DAC_DETID")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP_DAC",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTBCpt.size());	
		}
		 
		//Debut Charge detail Compteur de la CPMP
		 public void chargeDacDM1(String typePlan,String typeDac, String stat1){
			 detailTBCpt =(List<VDetTabBordDac>) iservice.getObjectsByColumnIn("VDetTabBordDac", new ArrayList<String>(Arrays.asList("DAC_DETID")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP_DAC",WhereClause.Comparateur.EQ,""+typeDac));
			             // new WhereClause("CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTBCpt.size());	
		}
		 
		 //Debut Charge detail Compteur de la CPMP
		 public void chargeDacDM2(String typePlan,String typeDac, String stat1, String stat2){
			 detailTBCpt =(List<VDetTabBordDac>) iservice.getObjectsByColumnIn("VDetTabBordDac", new ArrayList<String>(Arrays.asList("DAC_DETID")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP_DAC",WhereClause.Comparateur.EQ,""+typeDac));
			              //new WhereClause("CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTBCpt.size());	
		}
		 //FIN DETAILS DES COMPTEURS
	 
			//Methode d'affichage la liste des DAC en fonction du type plan et du type DAC passÃ¯Â¿Â½ en parametre
		 public void chargeDataByAction(String typeDac,String typePlan){
			 listeDAO.clear();	
			 String fonct = controleController.getFonctionalite();
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				      //Affichage des differentes listes de l'AC en faction de l'action 
						 if(fonct.equalsIgnoreCase("listSaisieAc")) {
							 chargeDataAc2(typeDac,typePlan,"D1S","D1R");
						 }else {
							 //Liste Publication
							 if(fonct.equalsIgnoreCase("ListePubDacPn")) {
								 chargeDataAc2(typeDac,typePlan,"D5V","DOP");
							 }else {
								 if(fonct.equalsIgnoreCase("listeDaoVentePn")) {
									 //chargeDataAc2(typeDac,typePlan,"D6V","DPU");
									 chargeDataAc3(typeDac,typePlan,"DAP");
								 }else {
									 if(fonct.equalsIgnoreCase("listeDaoCorrectionPn")) {
										 chargeDataAc2(typeDac,typePlan,"SBO","SRO");
									 }
								 }	 
							 }	 
						 }
			 
				//Finaffichage ac
					
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
						 chargeDataDMP2(typeDac,typePlan,"D1S","D1R");
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							 chargeDataDMP2(typeDac,typePlan,"D1S","D1R");
							
						 }else {
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
								 
								//Affichage des differentes listes de l'AC en fonction de l'action								  
								 if(fonct.equalsIgnoreCase("listeAffectationCsv")) {
									 chargeDataDMP2(typeDac,typePlan,"D2T","D5R");
								 }else {
									 if(fonct.equalsIgnoreCase("listeValidationCsv")) {
										 chargeDataDMP1(typeDac,typePlan,"D4V");
									 }else {
										
									 }	 
								 }
								
								
							 }else {
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
									 chargeDaoChargeEtude();	
								 }
							 }
						 }
					 }
			     } 
			   }
					
		} 
		 
		 public void typeActionTb() {
			 if(controleController.type == "DAC" && controleController.typePlan == "PN") {
				 tableauBordController.ChargeTableauBordDac("PN","DAO");
				//Enlever lorsque j'aurai le TB cpmp et DMP
				 tableauBordController.chargeDataDao("PN","DAO");
	    		 
			 }else {
				 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
					 tableauBordController.ChargeTableauBordDac("PS","DAO");
					//Enlever lorsque j'aurai le TB cpmp et DMP
					 tableauBordController.chargeDataDao("PS","DAO");
				 }else {
					 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
						 tableauBordController.ChargeTableauBordDac("PN","AMI");
						//Enlever lorsque j'aurai le TB cpmp et DMP
						 tableauBordController.chargeDataDao("PN","AMI");
						 ;
					 }else {
						 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
							//Enlever lorsque j'aurai le TB cpmp et DMP
							 tableauBordController.ChargeTableauBordDac("PN","PRQ");
							 tableauBordController.chargeDataDao("PN","PRQ");
							 
						 }
					 }
			     } 
			   }
		 }
		 
		//Filtre multicritÃ¯Â¿Â½re pour les DAO en ProcÃ¯Â¿Â½dure Normale
		 
		 public void chercherDac() {
			 if(controleController.type == "DAC" && controleController.typePlan == "PN") {	
				 chercher("DAO","PN");
				 }else {
					 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
						 chercher("DAO","PS");
					 }else {
						 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
							 chercher("AMI","PN");
						 }else {
							 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
								 chercher("PRQ","PN");
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
		 
		 //Récupération du message
		 public void recupMessage () {
			 listeAvis = listeAvis = ((List<TAvisAppelOffre>)iservice.getObjectsByColumn("TAvisAppelOffre",new ArrayList<String>(Arrays.asList("AAO_CODE")),
	 				 new WhereClause("AAO_CODE",Comparateur.EQ,""+newAvis.getAaoCode())));
             if (!listeAvis.isEmpty()) {
            	 sltAvis = listeAvis.get(0);
             }
		 }
		 
		 public void chercher(String typeDac,String typePlan){
			 listeDAO.clear();
			 String fonct = controleController.getFonctionalite();
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 
				//Affichage des differentes listes de l'AC en faction de l'action
				         //Liste saisie
						 if(fonct.equalsIgnoreCase("listSaisieAc")) {
							 listeDAO.clear(); 
							 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
									 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
									 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
									 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
									 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
							         new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));			 
								_logger.info("listeDAO size: "+listeDAO.size());
						 }else {
							 //Liste Publication
							 if(fonct.equalsIgnoreCase("ListePubDacPn")) {
								 listeDAO.clear(); 
								 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
										 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D5V","DOP")),
										 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
										 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
										 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
								         new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
								         multiFiltre ="";
									_logger.info("listeDAO size: "+listeDAO.size());	
							 }else {
								 //liste vente
								 if(fonct.equalsIgnoreCase("listeDaoVentePn")) {
									 listeDAO.clear();
									 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
											 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D6V","DPU")),
											 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
											 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
											 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
									         new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
									         multiFiltre ="";
										_logger.info("listeDAO size: "+listeDAO.size());	
								 }else {
									 //Liste correction
									 if(fonct.equalsIgnoreCase("listeDaoCorrectionPn")) {
										 listeDAO.clear();
										 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
												 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("SBO","SRO")),
												 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
												 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
												 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
										         new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
										         multiFiltre ="";
											_logger.info("listeDAO size: "+listeDAO.size());	
									 }
								 }
									 
							 }	 
						 }
				//Finaffichage ac

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
							 //Debut Filtre chef de service
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
								 //Filtre affectation
								 if(fonct.equalsIgnoreCase("listeAffectationCsv")) {
									 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
											 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D2T","D5R")),
											 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
											 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
											 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
										_logger.info("listeDAO size: "+listeDAO.size()); 
								 }else {
									//Filtre validation
									 if(fonct.equalsIgnoreCase("listeValidationCsv")) {
										 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
												 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D5V")),
												 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
												 new WhereClause("DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
												 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
											_logger.info("listeDAO size: "+listeDAO.size());
									 }else {
										
									 }	 
								 }
					       //Fin details CSV
								 
								
								
							 }else 
							//FIN Filtre chef de service 
							 
							 {
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
									 chargeDaoChargeEtudeFilter();
									
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
		 //liste des piÃ¯Â¿Â½ces de l'offre
		 
		 public void chargePiecesOffres() {
			 listePiecesOffres.clear();
			 if(dao.getDacBailleur().equalsIgnoreCase("N")) {
				 listePiecesOffres= (List<VTypePieceOffreSg>) iservice.getObjectsByColumn("VTypePieceOffreSg", new ArrayList<String>(Arrays.asList("TPO_LIBELLE")),
						 new WhereClause("TPO_BAI_ETAT",WhereClause.Comparateur.EQ,"E")); 
				
			 }else
			 {
				 listePiecesOffres= (List<VTypePieceOffreSg>) iservice.getObjectsByColumn("VTypePieceOffreSg", new ArrayList<String>(Arrays.asList("TPO_LIBELLE")),
						 new WhereClause("TPO_BAI_ETAT",WhereClause.Comparateur.EQ,"B"));  
			 }
			
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
			 
			 
			//Charger la liste des pièces a examiner par les chargÃ¯Â¿Â½s d'etude
			 public void chargePiecesByCharges() {
				 listePices= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
							new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
			 }
			 
			  //Combobox liste des Pays
			   public void chargePays(){
				   listePays=new ArrayList<>(constantService.getListePays());
				 }
			 
	 
		 //Liste des Dao affectÃ¯Â¿Â½es aux chargÃ¯Â¿Â½s d'etude
		 public void chargeDaoChargeEtude(){
				 if(controleController.type == "DAC" && controleController.typePlan == "PN") {
					 chargeDaoChargeEtudeByType("PN","DAO","D3A","DC2");
				 }else {
					 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
						 chargeDaoChargeEtudeByType("PS","DAO","D3A","DC2");
					 }else {
						 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
							 chargeDaoChargeEtudeByType("PN","AMI","D3A","DC2");
						 }else {
							 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
								 chargeDaoChargeEtudeByType("PN","PRQ","D3A","DC2");
							 }
						 }
				     } 
				   }
			}
		 
		 //Liste des Dao affectés aux chargés d'etude
		 public void chargeDaoChargeEtudeByType(String typePlan, String typeDac, String stat1,String stat2){
			 daoExamen.clear();
			  daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
					           "DAF_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					           new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,""+typeDac),
					           new WhereClause("DAF_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
			  multiFiltre="";
					_logger.info("daoExamen size: "+daoExamen.size());	
					//tableauBordController.chargeDataDao();
					//typeActionTb();
			}
		 
		 //Filtre parametrÃ¯Â¿Â½ en foction du type plan et dac
		 public void chargeDaoChargeEtudeFilter(){
		 if(controleController.type == "DAC" && controleController.typePlan == "PN") {
			 chargeDaoChargeEtudeByTypeFilter("PN","DAO","D3A","DC2");
		 }else {
			 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
				 chargeDaoChargeEtudeByTypeFilter("PS","DAO","D3A","DC2");
			 }else {
				 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
					 chargeDaoChargeEtudeByType("PN","AMI","D3A","DC2");
				 }else {
					 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
						 chargeDaoChargeEtudeByTypeFilter("PN","PRQ","D3A","DC2");
					 }
				 }
		     } 
		   }
	}
		 
		 //Recherche Dao affectÃ¯Â¿Â½es aux chargÃ¯Â¿Â½s d'etude 
		 public void chargeDaoChargeEtudeByTypeFilter(String typePlan, String typeDac, String stat1,String stat2){
			  daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
					           "DAF_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					           new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,""+typeDac),
					           new WhereClause("DAF_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
					           new WhereClause("DAF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
				              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
					_logger.info("daoExamen size: "+daoExamen.size());	
					//tableauBordController.chargeDataDao();
					//typeActionTb();
			}
		 
		 public void chargeDaoTrans(String typePlan, String typeDac, String stat1,String stat2){
			 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
			              new WhereClause("LBG_FON_CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTB.size());	
		}
		 
		 
		 //Debut Charge detail LBG_FON_CODE_AC
		 public void chargeDetailAC1(String typePlan, String typeDac, String stat1){
			 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
			              new WhereClause("LBG_FON_CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTB.size());	
		}
		 public void chargeDetailAC2(String typePlan, String typeDac, String stat1, String stat2){
			 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
			              new WhereClause("LBG_FON_CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTB.size());	
		}
		 
		 //DEBUT GESTION DES TABLAUX DE BORD
		 public void chargeDetailTB() {
			 String fonct = controleController.getFonctionalite();
			 //DEBUT DAO PN
			 if(controleController.type == "DAC" && controleController.typePlan == "PN") { 
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 
					 //Affichage des differentes listes de l'AC en faction de l'action
						 if(fonct.equalsIgnoreCase("listSaisieAc")) {
							 chargeDetailAC1("PN", "DAO", "D1T");	
						 }else {
							 if(fonct.equalsIgnoreCase("listeDaoVentePn")) {
								 chargeDetailAC1("PN", "DAO", "DAP");
							 }else {
								
							 }	 
						 }
			       //Finaffichage ac
					 
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
						 chargeDetailPF1("PN", "DAO", "D2T"); 
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
							
						 }else {
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
								
							 }else {
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
									 
									 //Affichage des details de du CSV en faction de l'action
									 if(fonct.equalsIgnoreCase("listeAffectationCsv")) {
										 //Detail DAC affectÃ¯Â¿Â½s par CSV
										 chargeDetailDPM1("PN", "DAO", "D3A"); 
									 }else {
										 if(fonct.equalsIgnoreCase("listeValidationCsv")) {
											//Detail DAC validÃ¯Â¿Â½ par CSV
											 chargeDetailDMP3("PN", "DAO", "D5V","DOP","SBO"); 
										 }else {
											
										 }	 
									 }
						       //Fin details CSV
									 
									
								 }else {
									 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
										
										
									 }
								 }
							 }
						 }
				     } 
				   }
			 }
			//FIN DAO PN
			 
			 
			//DEBUT DAO PS
			 else {
				 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
					 chargeDetailAC1("PS", "DAO", "D1T");
				 }
				//FIN DAO PS
				 
				//DEBUT DAO AMI 
				 else {
					 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
						 chargeDetailPF1("PN", "AMI", "D1T");
					 }
					//FIN AMI
					 
					//DEBUT PRQ
					 else {
						 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
							 chargeDetailAC1("PN", "PRQ", "D1T");
						 }
						 
						//FIN PRQ
					 }
			     } 
			   }
		 }
		 
		//Fin Charge Charge detail LBG_FON_CODE_AC
		 
		 //Debut Charge detail PF 
		 public void chargeDetailPF1(String typePlan, String typeDac, String stat1){
			 detailTB.clear();
			 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
			              new WhereClause("LBG_FON_CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTB.size());	
		}
		 public void chargeDetailPF2(String typePlan, String typeDac, String stat1, String stat2){
			 detailTB.clear();
			 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
			              new WhereClause("LBG_FON_CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre DAC: "+detailTB.size());	
		}
		 
		//Fin Charge detail PF 
		 
		 
		 //Debut Charge detail PF 
		 public void chargeDetailDPM1(String typePlan, String typeDac, String stat1){
			 detailTB.clear();
			 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
				_logger.info("Nbre DAC: "+detailTB.size());	
		}
		 public void chargeDetailDMP2(String typePlan, String typeDac, String stat1, String stat2){
			 detailTB.clear();
			 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
				_logger.info("Nbre DAC: "+detailTB.size());	
		}
		 public void chargeDetailDMP3(String typePlan, String typeDac, String stat1, String stat2, String stat3){
			 detailTB.clear();
			 detailTB =(List<VDacliste>) iservice.getObjectsByColumnIn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					      "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2,""+stat3)),
					      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
				_logger.info("Nbre DAC: "+detailTB.size());	
		}
		 
		//Fin Charge detail PF 
		 
		//DEBUT GESTION DES TABLAUX DE BORD
		 
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
		 
		
		 //Methode de Chargement des Dossiers chez l'AutoritÃ¯Â¿Â½ Contractante
		  public void chargeDossier() {
		 		 dossListe.clear();
		 			 dossListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getDacCode())));			
		 	 } 
		  
		//Methode de Chargement des Dossiers chez le ChargÃ¯Â¿Â½ d'Etudes
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
		     
		  //Methode pour Retourner la liste des natures de documents en fonction du type DAC passÃ¯Â¿Â½ en parametre
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
					 //condition de chargement d'un document : Nature sÃ¯Â¿Â½lectionnÃ¯Â¿Â½e 
						 if((docNature == null || "".equals(docNature))){
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sÃ¯Â¿Â½lectionnÃ¯Â¿Â½e pour le chargement! ","");
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
							//check le dossier s'il existe ÃƒÂ  faire
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
							FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers bien effectué!", "");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						     chargeDossier();
							}else {
								FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger Ã Â  nouveau un document ! ","");
								FacesContext.getCurrentInstance().addMessage(null, msg);	
								
							}
						  }
				     }	
		        }
			  @Transactional
				public void upload(FileUploadEvent event) throws java.io.FileNotFoundException { 
				 //condition de chargement d'un document : Nature sÃ¯Â¿Â½lectionnÃ¯Â¿Â½e 
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
					//check le dossier s'il existe ÃƒÂ  faire
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
					
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers bien effectué!", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				   chargeDossier();
					}else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger Ã Â  nouveau un document ! ","");
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
			       			                         
			       			                        constantService.getStatut("D1T");
						 							//Historisation du / des retraits
						 						    historiser("D1T",slctdTd.getDacCode(),"DAO transmis par l'Autorité Contractante");
						 						    //Tableau de Bord
			       			                        tableauBordController.saveTempTabord("D1T", slctdTd.getDacTdCode(), ""+userController.getSlctd().getTFonction().getFonCod(), slctdTd.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), slctdTd.getDacCode());
			       			                         
			       	   	                           } 
			       				
			       					chargeData();
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
				 
			    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDdaReference()+" supprimÃ¯Â¿Â½!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
			}
		    
		    
		    //Supprimer un dao joint
		    public void removeAutorisation(){
			downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaReference(), selectedDossier.getDdaReference());
				 iservice.deleteObject(selectedDossier);
				 chargeDossierAutorisation();	
				 
			    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDdaReference()+" supprimÃ¯Â¿Â½!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
			}
		    
		    
		    
		    public void transmettreCpmp() {
	        	
				listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
					if (!listDao.isEmpty()) {
						newDao= listDao.get(0);
						newDao.setTStatut(new TStatut("D2T"));
						newDao.setDacStatutRetour("0");
				        iservice.updateObject(newDao); 
		   	                 }
			
				    constantService.getStatut("D2T");
	 				//Historisation du DAC
	 				historiser("D2T",slctdTd.getDacCode(),"DAO transmis par la Cellule de Passation");
						
						//chargeDataAExaminer();
						
						chargeData();
						//Actualisation du tableau de bord
						typeActionTb();
						//Message de confirmation
						userController.setTexteMsg("Transmission effectuée avec succès!");
						userController.setRenderMsg(true);
						userController.setSevrityMsg("success");		
	     }
		 
		     
		  
		    //DIFFERER PAR CPMP ET DMP
		    //Differer
		 	 public void differer() {
		 		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
		 			 statutUpdate ="";
		 		 }else {
		 			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
		 				 statutUpdate ="D1R";
		 			 }else {
		 				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
		 					 statutUpdate ="D2R";
		 				 }
		 		      } 
		 		   }
		 		   /*//Mis ÃƒÂ  jour dans T_Affichage_DAO et dans T_Dac_specs
		 		    slctdTd.setDacStaCode(statutUpdate);
		 			slctdTd.setDacStatutRetour("1");
		 			iservice.updateObject(slctdTd);*/
		 			
		 			listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		  					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		  				if (!listDao.isEmpty()) {
		  					newDao= listDao.get(0);
		  					newDao.setTStatut(new TStatut(statutUpdate));
		  					newDao.setDacStatutRetour("1");
		  			        iservice.updateObject(newDao); 
		  	   	                 }
		  				       constantService.getStatut("D1T");
							  	//Historisation du / des retraits
						       historiser(""+statutUpdate,slctdTd.getDacCode(),""+getObservation());
						       
						     tableauBordController.saveTempTabord(""+statutUpdate, slctdTd.getDacTdCode(), ""+userController.getSlctd().getTFonction().getFonCod(), slctdTd.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), slctdTd.getDacCode());
		 					//Message de confirmation
		 					 userController.setTexteMsg("DAO retourné !");
		 					 userController.setRenderMsg(true);
		 					 userController.setSevrityMsg("success");
		 					 //return	null;
		 					 
		 				  chargeData();
		 		          //Actualisation du Tableau de Bord
		 		          typeActionTb();
		 			
		 			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Désolé, votre DAO a été retourné!", "");
		 			 FacesContext.getCurrentInstance().addMessage(null, msg);
		 	 }
		 	 
		 	//Affichage des motifs de retour
				public void chargerObservation() {
					daostatutList=(List<VDaoStatut>) iservice.getObjectsByColumn("VDaoStatut", new ArrayList<String>(Arrays.asList("HAC_DAC_CODE")),
							new WhereClause("HAC_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()),
							new WhereClause("HAC_STA_CODE",WhereClause.Comparateur.EQ,slctdTd.getDacStaCode()));
					if(!daostatutList.isEmpty()) {
						int i=daostatutList.size();
						int baoule=i-1;
						daostatut=daostatutList.get(baoule);
					}	
				}	

				// ENSEMBLE DES METHODES DE LA COMMISSION
				 //Liste des membres de la commssions
					 public void chargeMembreCommission() {
						 membresCommission = ((List<VbCommissionType>)iservice.getObjectsByColumn("VbCommissionType",new ArrayList<String>(Arrays.asList("TCT_CODE")),
								    new WhereClause("TCT_TST_CODE",Comparateur.EQ,""+userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode()),
								    new WhereClause("TCT_TCO_CODE",Comparateur.EQ,"COJ"),
								    new WhereClause("TCT_GRP_CODE",Comparateur.EQ,"MBR")));
								_logger.info("membre size: "+membresCommission.size());			
					 }
					 

						//Liste des membres de la commssions
						 public void chargeExpert() {
							 listeExpert.clear();
							 selectionlisteExpert.clear();
							 listeExpert = ((List<VCommissionTypeExp>)iservice.getObjectsByColumn("VCommissionTypeExp",new ArrayList<String>(Arrays.asList("TCT_CODE"))));
									_logger.info("expert size: "+listeExpert.size());			
						 }
						 
						//Liste des membres de la commssions de la commssion speciale dans la love
						 public void chargeMbrSpeciale() {
								listeMbrCommissionSpeciale.clear();
								selectionMbrCommissionSpeciale.clear();
								listeMbrCommissionSpeciale = ((List<VCommissionSpeciale>)iservice.getObjectsByColumn("VCommissionSpeciale",new ArrayList<String>(Arrays.asList("TCT_CODE"))));
									_logger.info("com special size: "+listeMbrCommissionSpeciale.size());	
									
										
						 }
						 

						 //Liste des membres de la commssions
						 public void chargeMembres() {
							 listeMembre = ((List<VCommissionSpecifique>)iservice.getObjectsByColumn("VCommissionSpecifique",
									    new WhereClause("COM_DAC_CODE",Comparateur.EQ,""+dao.getDacCode())));
									_logger.info("listeMembre size: "+listeMembre.size());				
						 }
						 
												 
						// Liste des membres de la commssions de la comission spÃ¯Â¿Â½ciale
						 public void chargeMembresComSpec() {
							 listeMembreComSpec = ((List<VCommissionSpecifique>)iservice.getObjectsByColumn("VCommissionSpecifique",
									    new WhereClause("COM_DAC_CODE",Comparateur.EQ,""+dao.getDacCode())));
									_logger.info("listeMembre size: "+listeMembreComSpec.size());				
						 }
												 
						 public void afficheExpert() {
							 btn_save_presence = false;
							 btn_save_expert = true;
							 panelMbr = false;
							 panelExpert = true;
							 chargeExpert();
							 userController.initMessage();
							 
						 }
					 
				 	
				 	public void savePresence() {
				 		//COMPOSITION DE LA SEANCE
						 if (selectionMembres.size()==0) {
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Selectionnez un membre ", "");
								FacesContext.getCurrentInstance().addMessage(null, msg);
							}else {
								
								for(VbCommissionType mbr : selectionMembres) {
									//newDetailSeance.setDcsDteSaisi(Calendar.getInstance().getTime());
									newcomSpec.setComDteSaisi(Calendar.getInstance().getTime());
									newcomSpec.setComTctCode(mbr.getTctCode());
									newcomSpec.setComTctLibelle(mbr.getTctLibelle());
									newcomSpec.setComTctTitre(mbr.getTctTitre());
									newcomSpec.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
									newcomSpec.setComDacCode(dao.getDacCode());
									newcomSpec.setComStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
									newcomSpec.setComTcoCode("COJ");
									iservice.addObject(newcomSpec);
									norm = true; 
									spec = false; 
									comboboxCom = false;
								}
								//chargeExpert();
								chargeMembres();
								
								//checkCommission();
								btn_ad_expert = true;
								btn_dao = true;
								 //Message de confirmation
			  		            userController.setTexteMsg("Membre(s) enregistré(s) avec succès!");
			  		            userController.setRenderMsg(true);
			  		            userController.setSevrityMsg("success");
								
							}
				 	}
				 	
				 	 public void recupMembre() {
				 		listeComSpecific = ((List<TCommissionSpecifique>)iservice.getObjectsByColumn("TCommissionSpecifique",
							    new WhereClause("COM_NUM",Comparateur.EQ,""+sltCompsec.getComNum())));
			    			if (!listeComSpecific.isEmpty()) {
			    				comSpecUpdate=listeComSpecific.get(0); 
			    			}
			           }
				 	
				 	public void updatePresence() { 
				 		listeComSpecific = ((List<TCommissionSpecifique>)iservice.getObjectsByColumn("TCommissionSpecifique",
							    new WhereClause("COM_NUM",Comparateur.EQ,""+sltCompsec.getComNum()))); 
				 		_logger.info("comNum: "+sltCompsec.getComNum());
			    			if (!listeComSpecific.isEmpty()) {
			    				comSpecUpdate=listeComSpecific.get(0); 
			    				//comSpecUpdate.setComTctLibelle(comSpecUpdate.getComTctLibelle());
			    				_logger.info("comNum: "+comSpecUpdate.getComTctLibelle());
			    				iservice.updateObject(comSpecUpdate);
			    				
					 			chargeMembres();
					 			userController.setTexteMsg("Modification éffectuée avec succès!");
			  		            userController.setRenderMsg(true);
			  		            userController.setSevrityMsg("success");
			    			}
				 			
				 		 
				 	}
				 	
				 	public void updatePresenceComspec() {          
				 		iservice.updateObject(sltCompsec);
				 		chargeMembresComSpec();	
								 userController.setTexteMsg("Modification éffectuée avec succès!");
				  		            userController.setRenderMsg(true);
				  		            userController.setSevrityMsg("success");
								
							}
				 	
				 	public void deletePresence() {  
                       listeComSpecifique = ((List<VbCommissionSpecifique>)iservice.getObjectsByColumn("VbCommissionSpecifique",
							    new WhereClause("COM_NUM",Comparateur.EQ,""+sltCompsec.getComNum())));
			    			if (!listeComSpecifique.isEmpty()) {
			    				comSpec=listeComSpecifique.get(0); 
			    				iservice.deleteObject(comSpec);
						 		chargeMembres();
						 		activieComboxAutoNorm();
								userController.setTexteMsg("Suppression éffectuée avec succès!");
						  		userController.setRenderMsg(true);
						  		userController.setSevrityMsg("success");
			    			}
				 				
						}
				 	
				 	public void deletePresenceComspec() {   
				 		iservice.deleteObject(sltCompsec);
				 		chargeMembresComSpec();	
				 		activieComboxAutoSpec();
						userController.setTexteMsg("Suppression éffectuée avec succès!");
				  		userController.setRenderMsg(true);
				  		userController.setSevrityMsg("success");
								
							}
				 	
				 	public void saveExpert() {
				 		//COMPOSITION DE LA SEANCE
						 if (selectionlisteExpert.size()==0) {
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Selectionnez un expert ", "");
								FacesContext.getCurrentInstance().addMessage(null, msg);
							}else {
								
								for(VCommissionTypeExp mbr : selectionlisteExpert) {
									//newDetailSeance.setDcsDteSaisi(Calendar.getInstance().getTime());
									newcomSpec.setComDteSaisi(Calendar.getInstance().getTime());
									newcomSpec.setComTctCode(mbr.getTctCode());
									newcomSpec.setComTctLibelle(mbr.getTctLibelle());
									newcomSpec.setComTctTitre(mbr.getTctTitre());
									newcomSpec.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
									newcomSpec.setComDacCode(dao.getDacCode());
									newcomSpec.setComStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
									newcomSpec.setComTcoCode("COJ");
									iservice.addObject(newcomSpec);
								}
								//chargeExpert();
								chargeMembres();
								
								userController.setTexteMsg("Expert(s) enregistré(s) avec succès!");
			  		            userController.setRenderMsg(true);
			  		            userController.setSevrityMsg("success");
								
								btn_save_presence = false;
								btn_save_expert = false;
								panelMbr = false;
								panelExpert = true;
							}
				 	}
				 	
				 	
					public void saveMbrSpecial() {
				 		//COMPOSITION DE LA SEANCE
						 if (selectionMbrCommissionSpeciale.size()==0) {
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Selectionnez un expert ", "");
								FacesContext.getCurrentInstance().addMessage(null, msg);
							}else {
								
								for(VCommissionSpeciale mbr : selectionMbrCommissionSpeciale) {
									//newDetailSeance.setDcsDteSaisi(Calendar.getInstance().getTime());
									newcomSpec.setComDteSaisi(Calendar.getInstance().getTime());
									newcomSpec.setComTctCode(mbr.getTctCode());
									newcomSpec.setComTctTitre(mbr.getTctTitre());
									newcomSpec.setComTctLibelle(mbr.getTctLibelle());
									newcomSpec.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
									newcomSpec.setComDacCode(dao.getDacCode());
									newcomSpec.setComStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
									newcomSpec.setComTcoCode("COJ");
									iservice.addObject(newcomSpec);
									norm = false; 
									spec = true; 
									comboboxCom = false;
								}
								//chargeExpert();
								chargeMembresComSpec();
								userController.setTexteMsg("Ressource ajoutée avec succès!");
			  		            userController.setRenderMsg(true);
			  		            userController.setSevrityMsg("success");
								
								//btn_save_presence = false;
								//btn_save_expert = false;
								panelMbr = false;
								panelExpert = true;
							}
				 	}
					
				 	public void removeMembre() { 
				 		listeCom = (List<TCommissionSpecifique>) iservice.getObjectsByColumn("TCommissionSpecifique", new ArrayList<String>(Arrays.asList("TCT_CODE")),
			    					new WhereClause("COM_NUM",WhereClause.Comparateur.EQ,""+selecMembre.getComNum()));
			        	       if (!listeCom.isEmpty()) {
			        	    	   detailCom = listeCom.get(0);
			        	       }
			        	       
			        	       iservice.deleteObject(getDetailCom());
							   new FacesMessage(FacesMessage.SEVERITY_WARN,"Suppression éffectuée avec succès", "");
				 	}	 
		 		 
	//Statistiques pour le chargÃ¯Â¿Â½ d'Etudes
			 
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
			//Affichage des DAO validÃ¯Â¿Â½ par le C.E
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
			 
			/*//Affichage des DAO validÃ¯Â¿Â½s par le C.E
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
		 
	//Fin de Staistiques pour le chargÃ¯Â¿Â½ d'Etudes 
		 
		 
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
		
				//Affichage des DAO diffÃ¯Â¿Â½rÃ¯Â¿Â½s par la CPMP : Nouvelle Methode
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
			 
			 
			 public void panelOuverture(){	
		    	 if(controleController.type == "DAC" ||controleController.type == "PRQ") {
		    		 ouverture = true;	
				 }else {
					 ouverture = false;
				   }

		     }
		 
			 
			 
			  //Premier enregistrement DAC en fonction du type et du plan
			    public void saveDao(){	
			    	 if(controleController.type == "DAC") {
			    		 saveDac("DAO");	
					 }else {
						 if(controleController.type == "DAC") {
							 saveDac("DAO"); 
						 }else {
							 if(controleController.type == "AMI") {
								 saveDac("AMI");
							 }else {
								 if(controleController.type == "PRQ") {
									 saveDac("PRQ");
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
			    
			    
			    //chargement du message de la marge de préférence sous-traitance
			   /* public void chargeMsgMarge() {
			    	listeMarge.clear();
			    	listeMarge =(List<VMargeDePreference>) iservice.getObjectsByColumn("VMargeDePreference", new ArrayList<String>(Arrays.asList("ID")));
					if (!listeMarge.isEmpty()) {
						marge=listeMarge.get(0);
					}	
			    }*/
			    
			  //chargement du message de la marge de préférence sous-traitance
			    public void chargeMsgMarge() {
			    	//listeMargeSou.clear();
			    	listeMargeSou =(List<VMargeDePreferenceSou>) iservice.getObjectsByColumn("VMargeDePreferenceSou", new ArrayList<String>(Arrays.asList("ID")));
					if (!listeMargeSou.isEmpty()) {
						margeSou=listeMargeSou.get(0);
					}	
			    }
			    
			  //chargement du message de la marge de préférence communautaire
			    public void chargeMsgMargeCom() {
			    	//listeMargeCom.clear();
			    	listeMargeCom =(List<VMargeDePreferenceCom>) iservice.getObjectsByColumn("VMargeDePreferenceCom", new ArrayList<String>(Arrays.asList("ID")));
					if (!listeMargeCom.isEmpty()) {
						margeCom=listeMargeCom.get(0);
					}	
			    }
			    
			  //chargement du message de la marge de préférence artisan
			    public void chargeMsgMargeArt() {
			    	listeMargeArt.clear();
			    	listeMargeArt =(List<VMargeDePreferenceArt>) iservice.getObjectsByColumn("VMargeDePreferenceArt", new ArrayList<String>(Arrays.asList("ID")));
					if (!listeMargeArt.isEmpty()) {
						margeArt=listeMargeArt.get(0);
					}	
			    }
		    
		//Initiation du DAO en procédure normale 
	     @Transactional
	     public void saveDac(String typeDac) {
	    	 if(daoDetail.getTymCode().equalsIgnoreCase("") || "".equals(daoDetail.getTymCode()) || daoDetail.getMopCode().equalsIgnoreCase("") || "".equalsIgnoreCase(daoDetail.getMopCode()) 
	    			 || daoDetail.getDppObjet().equalsIgnoreCase("") || "".equals(daoDetail.getDppObjet()) || dao.getDacFinancement().equalsIgnoreCase("") ) {
	    		 //Message d'Erreur
	    		 FacesContext.getCurrentInstance().addMessage(null,
		         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez sélectionnez votre PPM, puis faites OK!", ""));
	    	 }else 
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
		 				    	 dao.setTModeleDacType(new TModeleDacType(""+daoDetail.getDppPieceDao()));
		 				    	 dao.setDacTypePlan(""+daoDetail.getDppTypePlan());
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
		 			 			   historiser("D1S",dao.getDacCode(),"Initiation du "+typeDac+" par une Autorité Contractante");
		 			 			   
		 			 			   tableauBordController.saveTempTabord("D1S", dao.getTTypeDacSpecs().getTdcCode(), ""+userController.getSlctd().getTFonction().getFonCod(), dao.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), dao.getDacCode());
		 			 			
		 			 			   //Chargement des criteres
		 			 			   chargeCritere();
		 						     
		 						     //chargePPM();
		 						     //Actualisation du tableau de Bord
		 						     //tableauBordController.chargeDataDao();
		 			 			    //typeActionTb();
		 						     
		 						     userController.setTexteMsg(typeDac+" NÂ° "+dao.getDacCode()+" Initié avec succès!");
		 							 userController.setRenderMsg(true);
		 							 userController.setSevrityMsg("success");
		 							 
		 							 newAvis.aaoLibelle = dao.getDacObjet();
		 							 //Désactivation du bouton d'enregistrement du DAO
		 							 controleController.btn_dao_pn = false;
		 							 //Activation du Bouton d'enregistrement d'un Avis d'Appel d'Offres
		 							  btn_save_avis = true;
		 							  verifOuverture();
		 							  chargeImputation();
		 							  choixTaux = "N";
		 							  //listeMarge();
		 			      }
			    					//Insertion des piÃ¯Â¿Â½ces
			          }
	    	        
	          
	     
	 	//Methode d'historisation
		 
		 public void historiser(String statut,String dacCode, String motif) {
		     TStatut statuts = constantService.getStatut(statut);
		     THistoDac dacStatut = new THistoDac();
		     dacStatut.setHacDate(Calendar.getInstance().getTime());
		     dacStatut.setHacCommentaire(motif);
		     dacStatut.setTStatut(statuts);
		     dacStatut.setTDacSpecs(new TDacSpecs(dacCode));
		     dacStatut.setTFonction(userController.getSlctd().getTFonction());
		     dacStatut.setTOperateur(userController.getSlctd().getTOperateur());
		     iservice.addObject(dacStatut);
	 }
	 
		 //Création du Tableau de Bord AC
		 public void tableauAc(String statut, String dac, String ac, String plan, String matricule, String dacCode) {
			   VbTempParamTabBord tempTabBord = new VbTempParamTabBord();
			   tempTabBord.setTabOpeStaCode(statut);
			   tempTabBord.setTabTypOpe(dac);
			   tempTabBord.setTabFonCodeAc(ac);
			   tempTabBord.setTabTypeProc(plan);
			   tempTabBord.setTabOpeMatricule(matricule);
			   tempTabBord.setTabDateSaisi(Calendar.getInstance().getTime());
			   tempTabBord.setTabCodeOperation(dacCode);
               iservice.addObject(tempTabBord);
		 }
		 
		 //Création du Tableau de Bord 
		 public void tableauCp(String statut, String dac, String acteur, String plan, String matricule, String dacCode) {
			 
			    if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			    	tempBord.setTabFonCodeAc(acteur);
			    }else 
			        {
			    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
			    		  tempBord.setTabFonCodePf(acteur);
			    	  }else {
			    		      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP") || userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")
			    		    		|| userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")  ) {
			    		    	  tempBord.setTabCh1(acteur);
			    		      }
			    	      }
			    }
			    tempBord.setTabOpeStaCode(statut);
                tempBord.setTabTypOpe(dac);
                tempBord.setTabTypeProc(plan);
                tempBord.setTabOpeMatricule(matricule);
                tempBord.setTabDateSaisi(Calendar.getInstance().getTime());
                tempBord.setTabCodeOperation(dacCode);
                iservice.addObject(tempBord);
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
		 
		 public void controlDealai() {
			 if(newAvis.getAaoDelaiVal() < 30 || newAvis.getAaoDelaiVal() > 180) {
				 _logger.info(""+newAvis.getAaoDelaiVal());
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le délai de validité doit etre compris entre 30 et 180 jours ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);
			 }else
			 {
				 _logger.info(""+newAvis.getAaoDelaiVal());
			 }
		 }
	        @Transactional
	        public void saveAao(String typePlan ,String typeDac) {
	        	
	        	if(newAvis.getAaoLibelle().equalsIgnoreCase("") || newAvis.getAaoCoutDac() == 0 || newAvis.getAaoNbrLot() == 0 || 
	        		 newAvis.getAaoDelaiVal() == 0 ) { 
	        		
	        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir tous les champs obligatoires! ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);
	        		
	        	    }else {
	        	    	avisTab = (List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DAC_CODE")),
	        					new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
	            	       if (!avisTab.isEmpty()) {
	            	    	      newAvis = avisTab.get(0);
	            	    	      if(newAvis.getAaoDelaiVal() < 30 || newAvis.getAaoDelaiVal() > 180) {
	            	 				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le délai de validité doit etre compris entre 30 et 180 jours ","");
	            	 					FacesContext.getCurrentInstance().addMessage(null, msg);
	            	 			 }else {
	            	 				iservice.updateObject(newAvis); 
	            	 			 }
	        				      
	            	            }else { 
	            	            	      //S'assurer que la delai saisie est compris entre 30 et 180 jours
			            	            	if(newAvis.getAaoDelaiVal() < 30 || newAvis.getAaoDelaiVal() > 180) {
				            	 				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le délai de validité doit etre compris entre 30 et 180 jours ","");
				            	 					FacesContext.getCurrentInstance().addMessage(null, msg);
				            	 			 }else {
				            	 				 if(newAvis.getAaoNbrLot()==0) {
				            	 					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le nombre de lot doit etre superieur 0 ","");
					            	 					FacesContext.getCurrentInstance().addMessage(null, msg); 
				            	 				 }else
				            	 				 {
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
				            	          		      newAvis.setAvisRetour("0");
													  newAvis.setAaoNatInt(value1);
				            	          		      newAvis.setFonCodAc(userController.getSlctd().getTFonction().getFonCod());
				            	          		      iservice.addObject(newAvis); 
				            	          		      
	   
				            	          		   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				            	          				 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
				            	          				 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				            	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
				            	     				   if (!listDao.isEmpty()) {
				            	     					    newDao= listDao.get(0);
				            	     					    newDao.setDacCout(newAvis.getAaoCoutDac());
				            	     					    newDao.setDacNbrCopieOff(dao.getDacNbrCopieOff());
				            	     			            iservice.updateObject(newDao); 
				            	     	   	                 }
			                                             //Charger la liste des pieces de l'offre
				            	     				     chargePiecesOffres();
				                	     				    //Message de confirmation
				            	          		            userController.setTexteMsg("Avis d'Appel d'Offre crée avec succès!");
				            	          		            userController.setRenderMsg(true);
				            	          		            userController.setSevrityMsg("success");
				            	          		            
				            	          		        //Désactivation du bouton enregistrerAvis
				                	     				    btn_save_avis =false;
				                	     				//Activation du bouton d'enregistrement des offres
				                	     				    btn_save_offre = true;
			                	     				    //Activation du pavet pour la saisie des lots
				                	     		         pavet_lot = true;	 
				            	 				 }
				            	 				 
				            	 			 }
	            	                  }
	        	                   } 
	                     }
	        
	        //Verification (un DAO doit avoir au moin un lot)
	        public void controlLotDao() {
	        	if(listeLots.size() == 0) {
	        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir ou generer au moins un lot! ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
	        	}
	        }
	     
	 	//ContÃƒÂ´le sur le nombre d'ouverture
	 	public void verifOuverture() {
	 		if(newAvis.aaoNbrOuv == 2) {
	 			ouvTechnique = true;
	 		  }else {
	 			  ouvTechnique = false;
	 		}
	 	}
	
	 	//Affichage des DAO validÃ¯Â¿Â½s par le C.E
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

		//Chargement des PPM n'ayant pas fait l'objet d'un DAO
			 public void chargePPM() {
				 if(controleController.typePlan == "PN") {	
					 
					 if(controleController.type == "AMI") {
						 chargeOperationAmi("PN");
					 }else {
						 if(controleController.type == "PRQ") {
							 chargeOperationPrq("PN"); 
						 }else {
							 chargeOperation("PN");
						 }
					 }
					 
				 }else {
					 if(controleController.typePlan == "PS") {
						 if(controleController.type == "AMI") {
							 chargeOperationAmi("PS");
						 }else {
							 if(controleController.type == "PRQ") {
								 chargeOperationPrq("PS"); 
							 }else {
								 chargeOperation("PS");
							 }
						 }
					 }
				   } 
			 }
			 
			 //Parametrage des PPM ramené a la saisie
			 public void chargeOperation(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				  multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("mode de passation : "+typePlan);	
				 _logger.info("Operateur connecté : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			 
			 //Parametrage des AMI
			 public void chargeOperationAmi(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_MOP_CODE",Comparateur.EQ,"AMI"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				  multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connecté : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			 //Parametrage des PRQ
			 public void chargeOperationPrq(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_MOP_CODE",Comparateur.EQ,"PRQ"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				  multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connecté : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			 public void chargeRecherchePPM() {
				 if(controleController.typePlan == "PN") {	
					 if(controleController.type == "AMI") {
						 chargeOperationRechercheAmi("PN");
					 }else {
						 if(controleController.type == "PRQ") {
							 chargeOperationRecherchePrq("PN");
						 }else {
							 chargeOperationRecherche("PN");
						 }
					 }
					 
				 }else {
					 if(controleController.typePlan == "PS") {
						 if(controleController.type == "AMI") {
							 chargeOperationRechercheAmi("PS");
						 }else {
							 if(controleController.type == "PRQ") {
								 chargeOperationRecherchePrq("PS");
							 }else {
								 chargeOperationRecherche("PS");
							 }
						 }
					 }
				   } 	 		 
			 }
			 
			 //Parametrage des PPM ramené a la saisie
			 public void chargeOperationRecherche(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
						    new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				 multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connecté : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			//Recherche des PPM pour les AMI
			 public void chargeOperationRechercheAmi(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_MOP_CODE",Comparateur.EQ,"AMI"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
						    new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				 multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connecté : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			//Recherche des PPM pour les AMI
			 public void chargeOperationRecherchePrq(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_MOP_CODE",Comparateur.EQ,"PRQ"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
						    new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				 multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connecté : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			  //Rappel des informations du PPM
		     public void renseignerDao() throws IOException{
		                 	if (listSelectionPpmDao.size()==0) {
		            				FacesContext.getCurrentInstance().addMessage(null,
		            						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun PPM selectionné", ""));
		            			}
		            	 		else{
		            	 			//Parcourir la liste de sÃ¯Â¿Â½lection listSelectionPpmDao
		            		 		for(VPpmDao ligne : listSelectionPpmDao) {
		            		 			 
		            		 			//Parcourir la liste et rÃ¯Â¿Â½cupÃ¯Â¿Â½re
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
				//Liste des libellÃ¯Â¿Â½
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
					  listAdresse =(List<TAdresseAvis>) iservice.getObjectsByColumn("TAdresseAvis", new ArrayList<String>(Arrays.asList("ADA_NUM")),
							  new WhereClause("ADA_FON_COD",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
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
				 
				  
				  //Chargement des PPM n'ayant pas fait l'objet d'un DAO
					 public void chargePPMUpdate() {
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
								//montantTotalLot();
						}
					  //Cumul des montants estimatif
					  public void montantTotalLot() {
						  totalMontantEstimatif = 0;
						  totalMontantCaution = 0;
						  listeLots = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_ID")),
									new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
						 
							 for(TLotAao n : listeLots) {
								 totalMontantEstimatif = (totalMontantEstimatif + n.getLaaMtEst()); 
								 totalMontantCaution = (totalMontantCaution + n.getLaaMtCaut()); 
							 }
							 
						 }
					  
					  //controle entre le total montant estimatif et le montant de l'operation
					  public void updateMTEstim() {
						if(daoDetail.getDppMontant() > totalMontantEstimatif) {
                            	 FacesContext.getCurrentInstance().addMessage(null,
               	    	      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le cumul montant Estimatif ne doit pas etre supérieur au montant de l'operation", ""));	
                            
						}else
						{
							
						}
					  }
						 
					  
				//FIN GESTION DES MODIFICATIONS
				  
					  public void chargeLots(){
							 //getListeDAO().clear();
							 listeLots = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 
									 new WhereClause("LAA_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
									 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
								_logger.info("listeLots size: "+listeLots.size());	
								//montantTotalLot();
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
				   
				 //Mis Ã  jour de présence (O/N)
				   public void majPresence (String presence) {
						 List<TPiecesDacs> LS  = iservice.getObjectsByColumn("TPiecesDacs", new WhereClause("PID_CODE",Comparateur.EQ,""+sltPiece.getPidCode()));
						 TPiecesDacs piece = new TPiecesDacs(); 
						 if(!LS.isEmpty()) piece = LS.get(0);
						 piece.setPidPresente(""+presence);
						 iservice.updateObject(piece);
						 //Rechargement de la liste des pièces Ã  corriger
						 chargePiecesByCharges();
					 }
				   
				   //Mis Ã  jour de conformité (Conforme/Non Conforme)
				   public void majConforme (String conformite) {
						 List<TPiecesDacs> LS  = iservice.getObjectsByColumn("TPiecesDacs", new WhereClause("PID_CODE",Comparateur.EQ,""+sltPiece.getPidCode()));
						 TPiecesDacs piece = new TPiecesDacs(); 
						 if(!LS.isEmpty()) piece = LS.get(0);
						 piece.setPidConforme(""+conformite);
						 iservice.updateObject(piece);
						 //Rechargement de la liste des pièces Ã  corriger
						 chargePiecesByCharges();
					 }
				   
				   
				   public void chargeLotsRappel(){
						 getListeLots().clear();
						 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
								 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
							_logger.info("objetListe size: "+listeLots.size());	
					}
				   
				   public void recupererCaution() {
					   listeDAO.clear();
					   listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
							   new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
						if (!listeDAO.isEmpty()) {
							caution=listeDAO.get(0);
						}
				   }
				   public void calculCaution() {
					        recupererCaution();
                           // convertir string en long
					        //cautionMax = caution.getCautValMax();//* montantCaution.valueOf(newVbTemp.getTempLaaCautLot());
					        // convertir string en double
					        String str = ""+newVbTemp.getLaaMtEst();
					        Double  mtEstim = Double.parseDouble(str);
					        
					        String strMtCaut = ""+newVbTemp.getTempLaaCautLot();
					        Double  montantCaut = Double.parseDouble(strMtCaut);
					        
							cautionMin = caution.getCautValMin() * mtEstim;
							cautionMax = caution.getCautValMax() * mtEstim;
							
							if(montantCaut < cautionMin ||  montantCaut > cautionMax) { 
								panelCaution = true;
								cautionMinRound = Math.round(cautionMin);
								cautionMaxRound = Math.round(cautionMax);
								
								DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
								symbols.setGroupingSeparator(' ');

								DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
								System.out.println(formatter.format(cautionMin));
								System.out.println(formatter.format(cautionMaxRound));
								
								 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le montant du cautionnement doit etre compris entre "+formatter.format(cautionMin)+" et "+formatter.format(cautionMax),"");
								 FacesContext.getCurrentInstance().addMessage(null, msg);
							}
							if(montantCaut > cautionMin ||  montantCaut < cautionMax) { 
								panelCaution = false;
							}
							
							_logger.info("Paramcaution min: "+caution.getCautValMin());	
							_logger.info("Paramcaution max: "+caution.getCautValMax());	
							_logger.info("montant caution  saisie: "+montantCaut);	
							_logger.info("caution min: "+cautionMin);	
							_logger.info("caution max: "+cautionMax);
							
							/*if(cautionMin > montantCaution.valueOf(newVbTemp.getTempLaaCautLot())){
								
							}*/
							
						}	
				   
				   
				   
				  
				   //Methode de GÃ¯Â¿Â½nÃ¯Â¿Â½ration des Lots   
				     public void genererLot() {  
				       if(newAvis.getAaoNbrLot() > lotTotal) {
				    	   String str = ""+newVbTemp.getLaaMtEst();
					        Double  mtEstim = Double.parseDouble(str);
					        
					        String strMtCaut = ""+newVbTemp.getTempLaaCautLot();
					        Double  montantCaut = Double.parseDouble(strMtCaut);
					        
							cautionMin = caution.getCautValMin() * mtEstim;
							cautionMax = caution.getCautValMax() * mtEstim;
				    	   if(montantCaut >= cautionMin &&  montantCaut <= cautionMax) {
				    		   panelCaution = false;
								 newVbTemp.setTempLaaAaoCode(newAvis.getAaoCode());
					        	 newVbTemp.setTempLaaDacCode(dao.getDacCode());
					    		  newVbTemp.setTempLaaDteSaisi(Calendar.getInstance().getTime());
					    		  //newVbTemp.setTempLaaMtLot("0");
					    		  //newVbTemp.setTempLaaCautLot("0");
					    		  newVbTemp.setTempLaaImputation(imputation);
					    		  newVbTemp.setTempLaaNbrTotLot(String.valueOf(newAvis.getAaoNbrLot()));//Convertir un long en String
					    		  newVbTemp.setTempOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
					    		  newVbTemp.setTempType("LOT");
					    		  iservice.addObject(newVbTemp);
					    		  chargeLots();
					    		  montantTotalLot();
					    		  userController.setTexteMsg("Lot(s) généré(s) avec succès!");
					    		  userController.setRenderMsg(true);
					    		  userController.setSevrityMsg("success");
								  
								  //Activation du pavet de saisie des piÃ¯Â¿Â½ces des offres 
			                      pavet_offre = true; 
			                      pavet_critere= true;
				    	   }else {
				    			cautionMinRound = Math.round(cautionMin);
								cautionMaxRound = Math.round(cautionMax);
								
								DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
								symbols.setGroupingSeparator(' ');

								DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
								System.out.println(formatter.format(cautionMin));
								System.out.println(formatter.format(cautionMaxRound));
								
								
								 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le montant du cautionnement doit etre compris entre "+formatter.format(cautionMin)+" et "+formatter.format(cautionMax),"");
								 FacesContext.getCurrentInstance().addMessage(null, msg);
								 panelCaution = true;
				    	   }
				       }
				       else
				       {
							 
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseigné ! ","");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
				       }
				    	 
					 }
				     
				     
				     
				     public void calculCautionSaisie() {
					        recupererCaution();
                        // convertir string en long
					        //cautionMax = caution.getCautValMax();//* montantCaution.valueOf(newVbTemp.getTempLaaCautLot());
					        // convertir string en double
					        String str = ""+newLot.getLaaMtEst();
					        Double  mtEstim = Double.parseDouble(str);
					        
					        String strMtCaut = ""+newLot.getLaaMtCaut();  
					        Double  montantCaut = Double.parseDouble(strMtCaut);
					        
							cautionMin = caution.getCautValMin() * mtEstim;
							cautionMax = caution.getCautValMax() * mtEstim;
							
							if(montantCaut < cautionMin ||  montantCaut > cautionMax) { 
								panelCaution = true;
								cautionMinRound = Math.round(cautionMin);
								cautionMaxRound = Math.round(cautionMax);
								 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le montant du cautionnement doit etre compris entre "+cautionMinRound+" et "+cautionMaxRound,"");
								 FacesContext.getCurrentInstance().addMessage(null, msg);
							}
							if(montantCaut > cautionMin ||  montantCaut < cautionMax) { 
								panelCaution = false;
							}
							
							_logger.info("Paramcaution min: "+caution.getCautValMin());	
							_logger.info("Paramcaution max: "+caution.getCautValMax());	
							_logger.info("montant caution  saisie: "+montantCaut);	
							_logger.info("caution min: "+cautionMin);	
							_logger.info("caution max: "+cautionMax);
							
							/*if(cautionMin > montantCaution.valueOf(newVbTemp.getTempLaaCautLot())){
								
							}*/
							
						}	
				     
				     //Ajouter manuellement un lot
					 @Transactional
				    public void saveLot(){
				    	  //getNbreLotTotal();
				    	 if(newAvis.getAaoNbrLot() > lotTotal) {
				    		 String str = ""+newLot.getLaaMtEst();
						        Double  mtEstim = Double.parseDouble(str);
						        
						        String strMtCaut = ""+newLot.getLaaMtCaut();  
						        Double  montantCaut = Double.parseDouble(strMtCaut);
						        
								cautionMin = caution.getCautValMin() * mtEstim;
								cautionMax = caution.getCautValMax() * mtEstim;
								if(montantCaut >= cautionMin &&  montantCaut <= cautionMax) {
						    		   panelCaution = false;
				    		 newLot.setTDacSpecs(dao);
				    		 newLot.setLaaOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
				    		 newLot.setLaaDteSaisi(Calendar.getInstance().getTime());
				    		 newLot.setLaaCoutLot(coutLot);
				    		 newLot.setTAvisAppelOffre(newAvis);
				        	 iservice.addObject(newLot);
				        	 chargeLots();
				        	 montantTotalLot();
				        	 newLot = new TLotAao();
							 
							 //Activation du pavet de saisie des piÃ¯Â¿Â½ces des offres 
			                 pavet_offre = true;
			                 pavet_critere= true;
				        	 userController.setTexteMsg("Lot enregistré avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
								}
								else
								{
									cautionMinRound = Math.round(cautionMin);
									cautionMaxRound = Math.round(cautionMax);
									 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le montant du cautionnement doit etre compris entre "+cautionMinRound+" et "+cautionMaxRound,"");
									 FacesContext.getCurrentInstance().addMessage(null, msg);
									 panelCaution = true;
								}
				    	 }else {
				    		
				    		/* userController.setTexteMsg("Veuillez respecter le nombre de lots renseignÃ¯Â¿Â½ !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");*/
							 
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseigné ! ","");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
				    	 }
					}
					 
					 //Mis ÃƒÂ  jour du libellÃ¯Â¿Â½ de lot
				        public void updateLibLot() {
				        	     lot.setLaaObjet(lot.getLaaObjet());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				        //Mis ÃƒÂ  jour du montant de la caution du lot
				        public void updateMtCautLot() {
				        	     lot.setLaaMtCaut(lot.getLaaMtCaut());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				      //Mis ÃƒÂ  jour du montant estimatif de la caution du lot
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
						 montantTotalLot();
						 
							}
				   	 
				   	 //Mise a jour des elements saisies dans la liste des lots
				   	 public void updateListeLotLibelle() {
				   		iservice.updateObject(getSelectLot()); 
				   	 }
				   	 
				   	 //Mise a jour des elements saisies dans la liste des lots
				   	 public void updateListeLotLieu() {
				   		iservice.updateObject(getSelectLot()); 
				   	 }
				   	 
				   //Mise a jour des elements saisies dans la liste des lots
				   	 public void updateListeLotDelai() {
				   		iservice.updateObject(getSelectLot()); 
				   	 }
				   	 
				   	 //Mise a jour des elements saisies dans la liste des lots
				   	 public void updateMontantEst() {
				   		iservice.updateObject(getSelectLot()); 
				   	   montantTotalLot();
				   	 }
				   	 
				   //Mise a jour des elements saisies dans la liste des lots
				   	 public void updateMontantCaut() {
				   		iservice.updateObject(getSelectLot()); 
				   	 }
				   	 public void updateListeLotMontant() {
				   		listeLots = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_ID")),
								new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
				   		if(!listeLots.isEmpty()) {
				   			lot = listeLots.get(0);
				   			for(TLotAao lot : listeLots) {
				   				lot.setLaaMtCaut(selectLot.getLaaMtCaut());
				   				lot.setLaaMtEst(selectLot.getLaaMtEst());
					 		iservice.updateObject(selectLot); 
					   		
				   		}
				   		}
					   		//montantTotalLot();
					   	 }
				     
				        
				      //FIN GESTION DES LOTS
				  
				  
				   	 
				   	 //enregister la liste des piÃ¯Â¿Â½ces du dao
				     public void savePieceOffres() {
				    		if (listeSelectionPiecesOffres.size()==0) {
								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
							}
					 		else{
					 			
					 			newPieceOffreDac.setOdpDteSaisi(Calendar.getInstance().getTime());
					 			newPieceOffreDac.setOdpOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
					 			newPieceOffreDac.setOdpTpoEtapPiece("Ouverture");
					 			newPieceOffreDac.setTDacSpecs(dao);
					 			newPieceOffreDac.setTTypePieceOffre((pieceCode));
					 			iservice.addObject(newPieceOffreDac);
					 			
						 		 for(VTypePieceOffreSg ligne : listeSelectionPiecesOffres) {
						 			newPieceOffreDac.setOdpDteSaisi(Calendar.getInstance().getTime());
						 			newPieceOffreDac.setOdpOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
						 			newPieceOffreDac.setOdpTpoEtapPiece("Ouverture");
						 			newPieceOffreDac.setTDacSpecs(dao);
						 			newPieceOffreDac.setTTypePieceOffre(ligne.getTpoCode());
						 			iservice.addObject(newPieceOffreDac);
							     }
						 		userController.setTexteMsg("Pièces enregistrée(s) avec succès!");
								userController.setRenderMsg(true);
								userController.setSevrityMsg("success");
								//DÃ¯Â¿Â½sactivation du Bouton d'Enregistrement
								btn_save_offre = false;
								pavet_critere=true;
								//Activation du bouton du tÃ¯Â¿Â½lÃ¯Â¿Â½chargement du DAO
				                btn_dao = true;
					 		 }

				      }
				 //Methode de rÃ¯Â¿Â½cupÃ¯Â¿Â½ration de l'adresse
				  public void observationAdresse() {
					  avisAdresse = (List<VAvisAdresse>) iservice.getObjectsByColumn("VAvisAdresse", new ArrayList<String>(Arrays.asList("V_ID")),
								new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
				  }
				  
				  //RÃ¯Â¿Â½cupÃ¯Â¿Â½ration de l'avis et son Adresse
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
					 userController.setTexteMsg("Avis d'Appel d'offres mis ÃƒÂ  jour avec succès!");
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
						userController.setTexteMsg("DAO mis ÃƒÂ  jour avec succès!");
						userController.setRenderMsg(true);
						userController.setSevrityMsg("success");
				    }
				  
				  
				  public void saveLibelleAdresse() {
					  iservice.addObject(newLibelleAdresse);
					  chargeLibelleAdresse();
				  }
				  
				  //
				  public void avisBailleur() {
					  if(newAvis.getAaoAvisBai().equalsIgnoreCase("O")) {
						  libBailleur = true;
						  inputBailleur = true;
					  }else {
						  libBailleur = false;
						  inputBailleur = false;
					  }
				  }
				  
				  //
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
					 
					 public void checkMargeMsg() {
						 chargeMsgMarge();
						 if(choixTaux.equalsIgnoreCase("O")) { 
							 etatTaux = true; 
							 libelleTaux = true;
						 }else 
						 {
							 etatTaux = false; 
							 libelleTaux = false; 
						 }
					 }
					 
					 //Affichage des messages de marge de préférence
					 public void checkMargeMsgPref() {
							 if(margePref.equalsIgnoreCase("com")) { 
								 chargeMsgMargeCom();
								 etatMargeC = true; 
								 etatMargeA = false;
							 }else {
								 if(margePref.equalsIgnoreCase("art")) { 
									 chargeMsgMargeArt();
									 etatMargeA = true;
									 etatMargeC = false; 
									 //etatTaux = false;
								 }
							 }
						 
					 }
					 
					 public void checkMargeMsgSou() {
						 if(margePref.equalsIgnoreCase("sous")) { 
							 chargeMsgMarge();
							 etatTaux = true;
							 etatMargeC = false;
							 etatMargeA = false;
						 }
					 }
					 
					 //Mis Ã  Jour dans le T_DAC_SPECS
					 public void majPreference() {
						 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
    	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
    	     				       if (!listDao.isEmpty()) {
    	     					    newDao= listDao.get(0);
    	     				        newDao.setDacMargePref(choixTaux);
    	     				        newDao.setDacMargePrefSou(choixTaux);
    	     				        iservice.updateObject(newDao);
        	     				       }
					         }
					 
					 
					 public void reiniPreference() {
						 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
    	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
    	     				       if (!listDao.isEmpty()) {
    	     					    newDao= listDao.get(0);
    	     				        newDao.setDacMargePref(choixTaux);
    	     				        newDao.setDacMargePrefSou(choixTaux);
    	     				        newDao.setDacMargePrefArt(choixTaux);
    	     				        newDao.setDacMargePrefCom(choixTaux);
    	     				        iservice.updateObject(newDao);
        	     				       }
					         }
					 
					 
					 public void checkMargePref() {
						 if(choixTaux.equalsIgnoreCase("O")) { 
							 majPreference();
							 etatMargePreference = true;
							 listeMargePref();
						 }else 
						 {
							 reiniPreference();
							 etatMargePreference = false; 
						 }
					 }
					 
					//Variante (OUI/NON)
					 public void majVariante (String variante) {
						 List<TLotAao> LOT  = iservice.getObjectsByColumn("TLotAao", new WhereClause("LAA_ID",Comparateur.EQ,""+sltLot.getLaaId()));
						 TLotAao lo = new TLotAao(); 
						 if(!LOT.isEmpty()) lo = LOT.get(0);
						 lo.setLaaVariante(""+variante);
						 iservice.updateObject(lo);	
						 //Actualisation des critères
						 chargeLots();
					 }
					 
					 
					 //Edition de la fiche de synthèse du DAO
					 public void imprimeSynthese() {
							   projetReport.stringparam1(dao.getDacCode(), "synthese_dac", "synthese_dac"); 
						}
					 
				 
					//Téléchargement des DAO type après la saisie du DAO					
						public void opendaoType() throws IOException{
							
						  if(controleController.type == "DAC" && controleController.typePlan == "PN"){
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
									}else
										 if(controleController.type == "DAC" && controleController.typePlan == "PS"){

										       if(slctdTd.getDacMopCode().equalsIgnoreCase("PSL") && slctdTd.getTymTymCode().equalsIgnoreCase("0")){
										    	   //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+fourniture_PSL, fourniture_PSL); 
												    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);
										           }else
										               if(slctdTd.getDacMopCode().equalsIgnoreCase("PSL") && slctdTd.getTymTymCode().equalsIgnoreCase("1")){
										            	   //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+prestations_PSL, prestations_PSL); 
														    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+libelleFournitures, libelleFournitures);    
										              }else
										                   if(slctdTd.getDacMopCode().equalsIgnoreCase("PSL") && slctdTd.getTymTymCode().equalsIgnoreCase("2")){
										                	   //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+travaux_PSL, travaux_PSL); 
															    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+travaux_PSL, travaux_PSL);
										                }else
										                    if(slctdTd.getDacMopCode().equalsIgnoreCase("PSO") && slctdTd.getTymTymCode().equalsIgnoreCase("0")){
										                    	//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+fourniture_PSO, fourniture_PSO); 
															    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);
										                    }else 
										                    	if(slctdTd.getDacMopCode().equalsIgnoreCase("PSO") && slctdTd.getTymTymCode().equalsIgnoreCase("1")){
										                    		//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+prestations_PSO, prestations_PSO); 
																    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+prestations_PSO, prestations_PSO);
										                    	}else 
										                    		if(slctdTd.getDacMopCode().equalsIgnoreCase("PSO") && slctdTd.getTymTymCode().equalsIgnoreCase("2")){
										                    			//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+travaux_PSO, travaux_PSO); 
																	    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+travaux_PSO, travaux_PSO);
										                    	    }else 
										                    		    if(slctdTd.getDacMopCode().equalsIgnoreCase("PSC") && slctdTd.getTymTymCode().equalsIgnoreCase("0")){
										                    		    	//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+fourniture_PSC, fourniture_PSC); 
										    							    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);
										                    		       }else
										                    		    	    if(slctdTd.getDacMopCode().equalsIgnoreCase("PSC") && slctdTd.getTymTymCode().equalsIgnoreCase("1")) {
										                    		    	    	//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+prestations_PSC, prestations_PSC); 
										            							    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+prestations_PSC, prestations_PSC);
										                    		    	     }else
										                    		    	    	 if(slctdTd.getDacMopCode().equalsIgnoreCase("PSC") && slctdTd.getTymTymCode().equalsIgnoreCase("2")) {
										                    		    	    		 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+travaux_PSC, travaux_PSC); 
										                 							    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+travaux_PSC, travaux_PSC);
										                    		    	    	    }else
										                    		    	    		    if(slctdTd.getDacMopCode().equalsIgnoreCase("PSI")) {
										                    		    	    		    	//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+libelleFournitures, libelleFournitures); 
										                    								    downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures); 
										                    		    	    		  }

										                                                }
								                                                }
						
						//TÃ¯Â¿Â½lÃ¯Â¿Â½chargement des DAO type aprÃ¯Â¿Â½s la saisie du DAO  
							//TÃ¯Â¿Â½lÃ¯Â¿Â½chargement des DAO type aprÃ¯Â¿Â½s la saisie du DAO  
						//TÃ¯Â¿Â½lÃ¯Â¿Â½chargement des DAO type aprÃ¯Â¿Â½s la saisie du DAO 
						 public void opendaoNew() throws IOException{
								listeDAO = (List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
					    	              if (!listeDAO.isEmpty()) {
									         slctdTd = listeDAO.get(0);
					    	                }
					    	              
					    	              if(controleController.type == "DAC" && controleController.typePlan == "PN"){
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
					    	      				}else
					    	      					 if(controleController.type == "DAC" && controleController.typePlan == "PS"){

					    	      					       if(slctdTd.getDacMopCode().equalsIgnoreCase("PSL") && slctdTd.getTymTymCode().equalsIgnoreCase("0")){
					    	      					    	   downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+fourniture_PSL, fourniture_PSL); 
					    	      					    	 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);
					    	      					           }else
					    	      					               if(slctdTd.getDacMopCode().equalsIgnoreCase("PSL") && slctdTd.getTymTymCode().equalsIgnoreCase("1")){
					    	      					            	   downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+prestations_PSL, prestations_PSL); 
					    	      					            	 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+libelleFournitures, libelleFournitures);    
					    	      					              }else
					    	      					                   if(slctdTd.getDacMopCode().equalsIgnoreCase("PSL") && slctdTd.getTymTymCode().equalsIgnoreCase("2")){
					    	      					                	   downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+travaux_PSL, travaux_PSL); 
					    	      					                	 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+travaux_PSL, travaux_PSL);
					    	      					                }else
					    	      					                    if(slctdTd.getDacMopCode().equalsIgnoreCase("PSO") && slctdTd.getTymTymCode().equalsIgnoreCase("0")){
					    	      					                    	downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+fourniture_PSO, fourniture_PSO); 
					    	      					                    	//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);
					    	      					                    }else 
					    	      					                    	if(slctdTd.getDacMopCode().equalsIgnoreCase("PSO") && slctdTd.getTymTymCode().equalsIgnoreCase("1")){
					    	      					                    		downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+prestations_PSO, prestations_PSO); 
					    	      					                    		//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+prestations_PSO, prestations_PSO);
					    	      					                    	}else 
					    	      					                    		if(slctdTd.getDacMopCode().equalsIgnoreCase("PSO") && slctdTd.getTymTymCode().equalsIgnoreCase("2")){
					    	      					                    			downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+travaux_PSO, travaux_PSO); 
					    	      					                    			//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+travaux_PSO, travaux_PSO);
					    	      					                    	    }else 
					    	      					                    		    if(slctdTd.getDacMopCode().equalsIgnoreCase("PSC") && slctdTd.getTymTymCode().equalsIgnoreCase("0")){
					    	      					                    		    	downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+fourniture_PSC, fourniture_PSC); 
					    	      					                    		    	//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);
					    	      					                    		       }else
					    	      					                    		    	    if(slctdTd.getDacMopCode().equalsIgnoreCase("PSC") && slctdTd.getTymTymCode().equalsIgnoreCase("1")) {
					    	      					                    		    	    	downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+prestations_PSC, prestations_PSC); 
					    	      					                    		    	    	//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+prestations_PSC, prestations_PSC);
					    	      					                    		    	     }else
					    	      					                    		    	    	 if(slctdTd.getDacMopCode().equalsIgnoreCase("PSC") && slctdTd.getTymTymCode().equalsIgnoreCase("2")) {
					    	      					                    		    	    		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+travaux_PSC, travaux_PSC); 
					    	      					                    		    	    		//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+travaux_PSC, travaux_PSC);
					    	      					                    		    	    	    }else
					    	      					                    		    	    		    if(slctdTd.getDacMopCode().equalsIgnoreCase("PSI")) {
					    	      					                    		    	    		    	downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+libelleFournitures, libelleFournitures); 
					    	      					                    		    	    		    	//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures); 
					    	      					                    		    	    		  }

					    	      					                                                }	
							           }			 
			
						
			
				
							
			
							//Chargement des imputations ou lignes budgÃ¯Â¿Â½taires pour le AC
							/*  public void chargeImputation() { 
								 listeImputations.clear();
								 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
										 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())); 
									} */
							  
							//Chargement des imputations ou lignes budgÃ¯Â¿Â½taires pour le AC
							  public void chargeImputation() { 
								 listeImputations.clear();
								 listeImputations =(List<VLigneLot>) iservice.getObjectsByColumn("VLigneLot", new ArrayList<String>(Arrays.asList("LBG_CODE")),
										 new WhereClause("DAC_CODE",Comparateur.EQ,""+dao.getDacCode())); 
								 recupererCaution();
								
									} 
							  
							  
							//Chargement des fonctions Ã  imputer pour le Chef de Service
							  public void chargeFonctionImput() { 
								  listeFonctionsImput.clear();
								  listeFonctionsImput =(List<VFonctionImputation>) iservice.getObjectsByColumn("VFonctionImputation", new ArrayList<String>(Arrays.asList("FON_COD")),
										  new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()),
										 new WhereClause("STR_CODE",Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())); 
									_logger.info("listeFonctionsImput size: "+listeFonctionsImput.size());	
									typeActionTb();
									}
							  
							  
							   
							  //Filtre sur la liste des chargés d'Etudes
							  public void filtrefonction() { 
								  listeFonctionsImput.clear();
								  listeFonctionsImput =(List<VFonctionImputation>) iservice.getObjectsByColumn("VFonctionImputation", new ArrayList<String>(Arrays.asList("FON_COD")),
										 new WhereClause("STR_CODE",Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
										 new WhereClause("FON_LIBELLE",WhereClause.Comparateur.LIKE,"%"+filterCode+"%")); 
									}
							  
							  
							  //Filtre Imputation
							/*  public void filtreImputation() {
									listeImputations.clear();
									listeImputations = (List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
											new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()), 
											new WhereClause("LBG_NAT_CODE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));
								}
							  */
							  
							//Filtre Imputation
							  public void filtreImputation() {
									listeImputations.clear();
									listeImputations = (List<VLigneLot>) iservice.getObjectsByColumn("VLigneLot", new ArrayList<String>(Arrays.asList("LBG_CODE")),
											new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()), 
											new WhereClause("DPP_DAC_CODE",Comparateur.EQ,""+dao.getDacCode()),
											new WhereClause("LBG_NAT_CODE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));
								}
							  
							  //Examen des piÃ¯Â¿Â½ces du DAO par le Responsable du binÃƒÂ´me
							  @Transactional
							  public void examinerPieces() {
								  //Mis ÃƒÂ  Jour du Statut du DAO dans T_Dao_Affectation, puis dans t_dac_specs
								  // slctdTda.setDafStaCode("D4V"); //Ancien Statut
								   slctdTda.setDafStaCode("DC2");
								   slctdTda.setDafStatutRetour("0");
								   iservice.updateObject(slctdTda);
								   
								   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										   new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
											new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
										if (!listDao.isEmpty()) {
											 newDao= listDao.get(0);
											 newDao.setTStatut(new TStatut(slctdTda.getDafStaCode()));
											 newDao.setDacStatutRetour(slctdTda.getDafStatutRetour());
									         iservice.updateObject(newDao); 
							   	                 }
											  
								  
								  listPieceCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
										   new WhereClause("COR_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
							  if (!listPieceCorrection.isEmpty()) {
								  correction = listPieceCorrection.get(0);
								  
								  for(VPieces n : listePices) {
										 TDetailCorrection detCor = new TDetailCorrection();
										 detCor.setDcoDteSaisi(Calendar.getInstance().getTime());
										 detCor.setDcoObservation(n.getPidObservation());
										 detCor.setDcoPresente(n.getPidPresente());
										 detCor.setTCorrectionDac(correction);
										 detCor.setTFonction(userController.getSlctd().getTFonction());
										 detCor.setTOperateur(userController.getSlctd().getTOperateur());
										 detCor.setTDacSpecs(newDao);
										 detCor.setDcoConforme(n.getPidConforme());
										 detCor.setDcoTitre(correction.getCorLieblle());
										 detCor.setTPiecesDacs(new TPiecesDacs(n.getPidCode()));
										 detCor.setDcoRespo(slctdTda.getDafDcsMbmRespo());
										 iservice.addObject(detCor);
									       }
								  
								  constantService.getStatut("DC2");
	 							  	//Historisation du / des retraits
	 						       historiser("DC2",newDao.getDacCode(),"DAO Corrigé par le responsable du binÃ´me");
										//Actualisation du Tableau de Bord
										typeActionTb();
										//Activation et dÃ¯Â¿Â½sactivation des boutons valider
										etatBtnValid = false;
										validCorrection = true;
										etatDaoCorrige = true;
										 //Message de confirmation
										 userController.setTexteMsg("Correction(s) éffectuée(s) avec succès!");
										 userController.setRenderMsg(true);
										 userController.setSevrityMsg("success");
								
							         }else { 
							        	 
								           listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
								        		   //new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
											       new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
										               if (!listDao.isEmpty()) { newDao= listDao.get(0);}
								                             String chaine="CORRECTION DU DOSSIER D''APPEL D''OFFRES NÂ°";
								                             String exo=chaine+newDao.getDacCode();
								                             correction.setCorLieblle(exo); 
								                             correction.setCorOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
								                             correction.setTDacSpecs(newDao);
								                             correction.setCorDteSaisi(Calendar.getInstance().getTime());
								                             iservice.addObject(correction);
								     
								                               for(VPieces n : listePices) {
										                            TDetailCorrection detCor = new TDetailCorrection();
										                            detCor.setDcoDteSaisi(Calendar.getInstance().getTime());
										                            detCor.setDcoObservation(n.getPidObservation());
										                            detCor.setDcoPresente(n.getPidPresente());
										                            detCor.setTFonction(userController.getSlctd().getTFonction());
										                            detCor.setTOperateur(userController.getSlctd().getTOperateur());
										                            detCor.setTCorrectionDac(correction);
										                            detCor.setTDacSpecs(newDao);
										                            detCor.setDcoConforme(n.getPidConforme());
										                            detCor.setDcoTitre(correction.getCorLieblle());
										                            detCor.setTPiecesDacs(new TPiecesDacs(n.getPidCode()));
										                            detCor.setDcoRespo(slctdTda.getDafDcsMbmRespo());
										                            iservice.addObject(detCor);
									                                      }
								     
								                                       //Mis ÃƒÂ  Jour du Statut du DAO dans T_Affichage_Dao, puis dans t_dac_specs
									                                       //slctdTda.setDafStaCode("D4V"); //Ancien Statut
								                                           slctdTda.setDafStaCode("DC2");
										                                   slctdTda.setDafStatutRetour("0");
										                                   iservice.updateObject(slctdTda);
									   
												                      listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
												                              // new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
														                       new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
													                           if (!listDao.isEmpty()) {
														                                      newDao= listDao.get(0);
														                                      newDao.setTStatut(new TStatut(slctdTda.getDafStaCode()));
														                                      newDao.setDacStatutRetour(slctdTda.getDafStatutRetour());
												                                              iservice.updateObject(newDao); 
										   	                                                 }
													                           
													                           constantService.getStatut("DC2");
												 							  	//Historisation du / des retraits
												 						       historiser("DC2",newDao.getDacCode(),"DAO Corrigé par le responsable du binome");	
							 				                              //Actualisation du Tableau de Bord
											                              typeActionTb();
											                              //Activation et dÃ¯Â¿Â½sactivation des boutons valider
											              				  etatBtnValid = false;
											              				  validCorrection = true;
											              				  etatDaoCorrige = true;
							 				                              //Message de confirmation
							 				                              userController.setTexteMsg("Correction(s) éffectuée(s) avec succès!");
							 				                              userController.setRenderMsg(true);
							 				                              userController.setSevrityMsg("success");
							                                   }
							                              }
							  
							  
							  //Choisir au moins un responsable avant de faire une affectation
							  public void openAffectation() {
								  btn_affecter = true;
							  }
							//Methode d'Affectation
							  @Transactional
							  public void affecterDao() {
								  
								//Insertion des chargÃ¯Â¿Â½s d'Ã¯Â¿Â½tudes choisis 
									if (listSelectionFonctImput.size()==0) {
												FacesContext.getCurrentInstance().addMessage(null,
												new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun chargé d'études selectionné", ""));
											}
									 		else{
									 			    
									 			  if (listSelectionFonctImput.size()==2) {
									 					
									 					listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
									 							new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
									 						if (!listDao.isEmpty()) {
									 							newDao= listDao.get(0);
									 							newDao.setTStatut(new TStatut("D3A"));
									 							newDao.setDacStatutRetour("0");
									 					        iservice.updateObject(newDao); 
									 			   	                 }
									 				  			 				  
									 				  //String exo="";
									 				  String chaine="SEANCE DE COMMISSION INTERNE D'ANALYSE DU DAO NÂ°";
									 				  String exo=chaine+newDao.getDacCode();
									 				  newSeance.setTFonction(userController.getSlctd().getTFonction());
									 				  newSeance.setTOperateur(userController.getSlctd().getTOperateur());
									 				  newSeance.setTTypeSeance(new TTypeSeance("CIA"));
									 				  newSeance.setSeaSteSaisi(Calendar.getInstance().getTime());
									 				  newSeance.setSeaLibelle(exo);
									 				  iservice.addObject(newSeance);
									 				  
									 				  
									 				 for(VFonctionImputation n : listSelectionFonctImput) {
										 	    		 
										 	    		 TCommissionSpecifique com = new TCommissionSpecifique();
										 	    		 com.setTStructure(new TStructure(n.getStrCode()));
										 	    		 com.setTDacSpecs(newDao);
										 	    		 com.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
										 	    		 com.setTTypeCommission(new TTypeCommission("CIA"));
										 	    		 com.setComDteSaisi(Calendar.getInstance().getTime());
										 	    		 com.setComMarCode(slctdTd.getTymCode());
										 	    		 iservice.addObject(com);
										 	    		 
										 	    		 TDetCommissionSeance det = new TDetCommissionSeance();
										 	    		 det.setDcsDteSaisi(Calendar.getInstance().getTime());
										 	    		 det.setDcsFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
										 	    		 det.setTDacSpecs(newDao);
										 	    		 det.setTSeances(newSeance);
										 	    		 det.setDcsFonCod(n.getFonCod());
										 	    		 det.setDcsOpeMatricule(n.getOpeMatricule());
										 	    		 det.setTStructure(new TStructure(n.getStrCode()));
										 	    		 det.setTCommissionSpecifique(com);
										 	    		 det.setTOperateur(userController.getSlctd().getTOperateur());
										 	    		 det.setTTypeCommission(new TTypeCommission(com.getTTypeCommission().getTcoCode()));
										 	    		 det.setDcsPresent("O");
										 	    		 det.setDcsNomMbm(n.getOpeNom());
										 	    		 det.setDcsTelMbm(n.getOpeContact());
										 	    		 det.setDcsMbmRespo(n.getStrOpeRespo());
										 	    		 iservice.addObject(det);
										 	    		 
										 	    		//Enregistrement dans TDaoAffectation
											 	    	 TDaoAffectation newAff = new TDaoAffectation(); 
											 			 newAff.setDafDacCode(newDao.getDacCode());
											 			 newAff.setDafOpeMatricule(n.getOpeMatricule());
											 			 newAff.setDafStaCode(newDao.getTStatut().getStaCode());
											 			 newAff.setDafStatutRetour(newDao.getDacStatutRetour());
											 			 newAff.setDafDacObjet(newDao.getDacObjet());
											 			 newAff.setDafTypeDac(newDao.getTTypeDacSpecs().getTdcCode());
											 			 newAff.setDafDacGestion(newDao.getTGestion().getGesCode());
											 			 newAff.setDafTypePlan(newDao.getDacTypePlan());
											 			 newAff.setDafDacStr(newDao.getTStructure().getStrCode());
											 			 newAff.setDafDacRecherche(newDao.getDacRecherche());
											 			 newAff.setDafDcsMbmRespo(n.getStrOpeRespo());
											 			 newAff.setTDetCommissionSeance(det);
											 			 newAff.setTModePassation(new TModePassation(newDao.getTModePassation().getMopCode()));
											 			 newAff.setTTypeMarche(new TTypeMarche(newDao.getTTypeMarche().getTymCode()));
											 			 newAff.setDafMention(newDao.getDacMention());
											 			 iservice.addObject(newAff);
										 	   	   }
									 				 
									 				chargeData();
										 			//Chargement des compteurs du tableau de bord
										 			typeActionTb();	
										 			//Message de confirmation
							    					userController.setTexteMsg("Affectation(s) effectuée(s) avec succès!");
													userController.setRenderMsg(true);
													userController.setSevrityMsg("success");

									 			    }else {
									 			    	     FacesContext.getCurrentInstance().addMessage(null,
									 							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez Choisir un binÃƒÂ´me !", ""));
									 			    	     //Réinitialiser la liste de selection
									 			    	      listSelectionFonctImput.clear();
									 			          }	
									 		 }
										}
							     
								
								 public void chargeDaoAffectesR(){
									 listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										              new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D3A"),
										              new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
										              new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));		
									}  	  
							  
							
							 
								//Charger la liste des piÃ¯Â¿Â½ces et observations ÃƒÂ  examiner par le chef de service suivie de l'observation donnÃ¯Â¿Â½e par le responsable
								 public void chargePiecesByCsv() {
									 listeDetailCorrection= (List<VDetailCorrection>) iservice.getObjectsByColumn("VDetailCorrection", new ArrayList<String>(Arrays.asList("PID_CODE")),
											    new WhereClause("DCO_RESPO",WhereClause.Comparateur.EQ,"O"),
												new WhereClause("DCO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));	
												if (!listeDetailCorrection.isEmpty()) {
													detailCor = listeDetailCorrection.get(0);
											    }
								             }
								 
								//Chargement la liste des piÃ¯Â¿Â½ces et observations ÃƒÂ  examiner par le responsable
								 public void chargePiecesByBinome() {
									 listeCorrectionCharge= (List<VDetailCorrectionCharge>) iservice.getObjectsByColumn("VDetailCorrectionCharge", new ArrayList<String>(Arrays.asList("PID_CODE")),
												new WhereClause("DCO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
									 if (!listeCorrectionCharge.isEmpty()) {
										 detailCharge = listeCorrectionCharge.get(0);
									    }
								      }
								 
								 
								 //Chargement des piÃ¯Â¿Â½ces du Dao
								 public void chargePiecesDao() {
									 listePiecesDao.clear();
									 listePiecesDao= ((List<VPieceDac>)iservice.getObjectsByColumn("VPieceDac",new ArrayList<String>(Arrays.asList("PID_LIBELLE")),
											    new WhereClause("PID_DAC_CODE",Comparateur.EQ,""+updateDac.getDacCode())));

								 }	
								 
								//Affichage de zone de mention si le chargÃ¯Â¿Â½ d'Etude est un responsable de binÃƒÂ´me
								  public void chargeRespoExiste(){
									  daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
										              new WhereClause("DAF_STA_CODE",WhereClause.Comparateur.EQ,"D3A"),
										              new WhereClause("DAF_DCS_MBM_RESPO",WhereClause.Comparateur.EQ,"O"),
										              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
									        if (!daoExamen.isEmpty()) {
											      etatSanction = true;
											      etatLoveObs = true;
											      etatBtnValid = true;
											      etatBtnValidCharge = false;
											      
									         }else {
									        	 etatSanction = false;	
									        	 etatLoveObs = false;
									        	 etatBtnValid = false;
									        	 etatBtnValidCharge = true;
									        	 validCorrection = false;
									         }		
									    }
								  
								  
								//Affichage de zone de mention si le chargé d'Etude est un responsable de binÃƒÂ´me
								  public void chargeTableauExiste(){
									  daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
										              new WhereClause("DAF_STA_CODE",WhereClause.Comparateur.EQ,"D3A"),
										              new WhereClause("DAF_DCS_MBM_RESPO",WhereClause.Comparateur.EQ,"O"),
										              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
									        if (!daoExamen.isEmpty()) {
									        	etatDaoCorrige = true;   
									         }else {
									        	 etatDaoCorrige = false;	
									         }		
									    }
								  
								    //Examen des pièces du DAO par le chargé d'Etudes du binÃƒÂ´me
									@Transactional
								    public void examinerChar() {
										  
									listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
											        new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
											        new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
										                if (!listDao.isEmpty()) {newDao= listDao.get(0); }
													  
										  
										  listPieceCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
												   new WhereClause("COR_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
									                        if (!listPieceCorrection.isEmpty()) {
										                           correction = listPieceCorrection.get(0);
										  
										                                  for(VPieces n : listePices) {
												                                TDetailCorrection detCor = new TDetailCorrection();
												                                detCor.setDcoDteSaisi(Calendar.getInstance().getTime());
												                                detCor.setDcoObservation(n.getPidObservation());
												                                detCor.setDcoPresente(n.getPidPresente());
												                                detCor.setTFonction(userController.getSlctd().getTFonction());
												                                detCor.setTOperateur(userController.getSlctd().getTOperateur());
												                                detCor.setTCorrectionDac(correction);
												                                detCor.setTDacSpecs(newDao);
												                                detCor.setDcoConforme(n.getPidConforme());
												                                detCor.setDcoTitre(correction.getCorLieblle());
												                                detCor.setTPiecesDacs(new TPiecesDacs(n.getPidCode()));
												                                detCor.setDcoRespo("N");
												                                iservice.addObject(detCor);
											                                      }
										                             //Mis ÃƒÂ  jour du statut de DAO rÃ¯Â¿Â½cu   
										                             slctdTda.setDafStaCode("DC1");
										                             iservice.updateObject(slctdTda);
										                             //Actualisation de la liste des DAO
										                             //chargeDaoChargeEtude();
												                     //Actualisation du Tableau de Bord
												                     typeActionTb();
												                     //Message de confirmation
												                     userController.setTexteMsg("Correction(s) éffectuée(s) avec succès!");
												                     userController.setRenderMsg(true);
												                     userController.setSevrityMsg("success");
												                     
									                          }else { 
									        	 
										                                  listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										                                		     new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
													                                 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
												                                  if (!listDao.isEmpty()) { newDao= listDao.get(0);}
										                                          String chaine="CORRECTION DU DOSSIER D''APPEL D''OFFRES NÃ‚Â°";
										                                          String exo=chaine+newDao.getDacCode();
										                                          correction.setCorLieblle(exo); 
										                                          correction.setCorOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
										                                          correction.setTDacSpecs(newDao);
										                                          correction.setCorDteSaisi(Calendar.getInstance().getTime());
										                                          iservice.addObject(correction);
										     
										                                            for(VPieces n : listePices) {
												                                         TDetailCorrection detCor = new TDetailCorrection();
												                                         detCor.setDcoDteSaisi(Calendar.getInstance().getTime());
												                                         detCor.setDcoObservation(n.getPidObservation());
												                                         detCor.setDcoPresente(n.getPidPresente());
												                                         detCor.setTCorrectionDac(correction);
												                                         detCor.setTDacSpecs(newDao);
												                                         detCor.setDcoConforme(n.getPidConforme());
												                                         detCor.setTFonction(userController.getSlctd().getTFonction());
												                                         detCor.setTOperateur(userController.getSlctd().getTOperateur());
												                                         detCor.setDcoTitre(correction.getCorLieblle());
												                                         detCor.setTPiecesDacs(new TPiecesDacs(n.getPidCode()));
												                                         detCor.setDcoRespo("N");
												                                        iservice.addObject(detCor);
											                                              }
									 				
										                                             //Mis ÃƒÂ  jour du statut de DAO en cours de traitement chez le ChargÃ¯Â¿Â½ d'Etudes  
										       		                                slctdTda.setDafStaCode("DC1");
										       		                                iservice.updateObject(slctdTda); 
										       		                                //Actualisation de la liste des DAO
										       		                                //chargeDaoChargeEtude();
									 				                                //Actualisation du Tableau de Bord
													                                 typeActionTb();
									 				                                //Message de confirmation
									 				                                userController.setTexteMsg("Correction(s) éffectuée(s) avec succès!");
									 				                                userController.setRenderMsg(true);
									 				                                userController.setSevrityMsg("success");
									                                         }
									                                       }
									  
									//Enregistrement des corrections
									  @Transactional
									  public void examiner() {
										  for(VPieces n : listePices) {
											  newCorrection.setDcoPidCode(String.valueOf(n.getPidCode()));
											  newCorrection.setDcoDacCode(n.getPidDacCode());
											  newCorrection.setDcoDteSaisi(Calendar.getInstance().getTime());
											  newCorrection.setDcoFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
											  newCorrection.setDcoOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
											  newCorrection.setTempType("DAC_CORRECTION");
											  iservice.addObject(newCorrection);
										       } 
										   //chargePiecesByDao();
										
											 //Message de confirmation
											 userController.setTexteMsg("Correction(s)  éffectuée(s) avec succès!");
											 userController.setRenderMsg(true);
											 userController.setSevrityMsg("success");	
									  }

									  
								     ////Validation chargé d'Etudes
									  @Transactional
									  public void valider() throws IOException {
								       	List<TDacSpecs> DA  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
								       	TDacSpecs dao = new TDacSpecs();
											if(!DA.isEmpty()) dao = DA.get(0);
											dao.setTStatut(new TStatut("D4V"));
											dao.setDacStatutRetour(slctdTd.getDacStatutRetour());
											iservice.updateObject(dao);
								       
											  constantService.getStatut("D4V");
			 							  	//Historisation du / des retraits
			 						       historiser("D4V",slctdTd.getDacCode()," ");
											
			 						      tableauBordController.saveTempTabord("D4V", slctdTd.getDacTdCode(), ""+userController.getSlctd().getTFonction().getFonCod(), slctdTd.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), slctdTd.getDacCode());
										  chargeData();
										  renderPage("dao1","CHADAO");
										  //Actualisation du tableau de bord
										  typeActionTb();
										  //Message de confirmation
										  userController.setTexteMsg("Validation effectuée avec succès!");
										  userController.setRenderMsg(true);
										  userController.setSevrityMsg("success");		
								    }
									  
									  
									  
									//Validation des corrections
									  @Transactional 
									 public void resultatCorrectionRespo() {
										 listCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
												  new WhereClause("COR_DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode()));
										           if (!listCorrection.isEmpty()) {
										        	 daoCorr= listCorrection.get(0);
										        	 daoCorr.setCorObservationRespo(getObservationCor());
										        	 daoCorr.setCorResultatRespo(resultat);
												     iservice.updateObject(daoCorr);
												 
												     //Message de confirmation
													 userController.setTexteMsg("Validation éffectuée avec succès!");
													 userController.setRenderMsg(true);
													 userController.setSevrityMsg("success");
										          }	                     
									   } 
									  
									  
									  //Transmission du DAO par le Responsable du binÃƒÂ´me
									  @Transactional
									  public void transmettreRespo() {
										  
										  if(dos.getDdaNom().equalsIgnoreCase("") || "".equals(dos.getDdaNom()) || dos.getDdaReference().equalsIgnoreCase("") || "".equals(dos.getDdaReference())) {
											  //Message d'erreur
											  FacesContext.getCurrentInstance().addMessage(null,
											  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez charger le DAO", ""));
											  
										        }else {
											     //Mis ÃƒÂ  Jour du Statut du DAO dans T_Dao_Affectation, puis dans t_dac_specs
											      slctdTda.setDafStaCode("D4V");
											      slctdTda.setDafStatutRetour("0");
											      iservice.updateObject(slctdTda);
											  
											   //Mis ÃƒÂ  jour du statut et de l'option retour dans TDacSpecs
											   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
													    //new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
														new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
													         if (!listDao.isEmpty()) {
														         newDao= listDao.get(0);
														         newDao.setTStatut(new TStatut(slctdTda.getDafStaCode()));
														         newDao.setDacStatutRetour(slctdTda.getDafStatutRetour());
												                 iservice.updateObject(newDao); 
										   	                        }

												  constantService.getStatut("D4V");
								 				  //Historisation du / des retraits
								 				  historiser("D4V",newDao.getDacCode(),"DAO Transmis par le responsable du binÃ´me");
												  
								 				  tableauBordController.saveTempTabord("D1T", slctdTd.getDacTdCode(), ""+userController.getSlctd().getTFonction().getFonCod(), slctdTd.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), slctdTd.getDacCode());
												  chargeData();
												  
												   //Actualisation du tableau de bord
								 					typeActionTb();
								 					//Message de confirmation
								 					userController.setTexteMsg("Transmission effectuée avec succès!");
													userController.setRenderMsg(true);
													userController.setSevrityMsg("success");
										        }
									       } 
								
									  
									  @Transactional
										public void uploadCharge(FileUploadEvent event) throws java.io.FileNotFoundException { 
										 //condition de chargement d'un document : Nature sÃ¯Â¿Â½lectionnÃ¯Â¿Â½e 
										 if((docNature == null || "".equals(docNature))){
											 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sélectionnée pour le chargement! ","");
											FacesContext.getCurrentInstance().addMessage(null, msg);	
											 
											 }else {
										
										if(fileUploadController.handleFileUpload(event, ""+slctdTda.getDafDacCode(), docNature)) {
											
											listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
								 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
								 				if (!listDao.isEmpty()) {
								 					newDao= listDao.get(0);
								 	   	                 }
											
											int nat = Integer.valueOf(docNature);
											//check le dossier s'il existe ÃƒÂ  faire
											//TDossierDacs dos =new TDossierDacs(); //TNatureDocuments
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
											chargeDossierCharge();
											
											FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers bien effectué!", "");
											FacesContext.getCurrentInstance().addMessage(null, msg);
											chargeDossierCharge();
											}else {
												FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger Ã Â  nouveau un document ! ","");
												FacesContext.getCurrentInstance().addMessage(null, msg);	
												
											}
										  }
										}
									  
									  /**
									 * @param event
									 * @throws java.io.FileNotFoundException
									 */
									@Transactional
										public void uploadAtorisation(FileUploadEvent event) throws java.io.FileNotFoundException { 
										 //condition de chargement d'un document : Nature sÃ¯Â¿Â½lectionnÃ¯Â¿Â½e 
									/*	 if((codeAutorisation == null || "".equals(codeAutorisation))){
											 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir le code d'autorisation SVP! ","");
											FacesContext.getCurrentInstance().addMessage(null, msg);	
											 
											 }else {*/
												 
												 
													 
										if(fileUploadController.handleFileUpload(event, ""+dao.getDacCode(), "AUS")) {
											int nat = Integer.valueOf(7);
											//check le dossier s'il existe ÃƒÂ  faire
											//TDossierDacs dos =new TDossierDacs(); //TNatureDocuments
											dos.setDdaCommentaire(keyGen.getCodeDossier("AUS"+"-"+fileUploadController.getFileCode()+"-"));
											dos.setTDacSpecs(dao);
											List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
											TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
											if(!LS.isEmpty()) natureDoc = LS.get(0);
											dos.setTNatureDocuments(natureDoc);
											dos.setDdaNom(fileUploadController.getFileName());
											dos.setDdaDteSaisi(Calendar.getInstance().getTime());
											dos.setDdaReference(fileUploadController.getDocNom());
											iservice.addObject(dos); 
											
											//chargeNatureDocTrans();
											chargeDossierAutorisation();
											
											FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Document enregistré!", "");
											FacesContext.getCurrentInstance().addMessage(null, msg);
											//chargeDossierCharge();
											}else {
												FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger ÃƒÂ  nouveau un document ! ","");
												FacesContext.getCurrentInstance().addMessage(null, msg);	
												
											}
										  //}
										}
									
									 public void openDossier() throws IOException{
							       		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaNom(), selectedDossier.getDdaNom());
							       		   }
									//Methode de Chargement des Artcles
									  public void chargeArticle() {
										  listeArticle.clear();
										  listeArticle = ((List<VArticlesCom>)iservice.getObjectsByColumn("VArticlesCom"));		
									 	 } 
									//Methode de Chargement des Dossiers chez le ChargÃ¯Â¿Â½ d'Etudes
									  public void chargeDossierAutorisation() {
									    	 dossDacListe.clear();
									    	 dossDacListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
									 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,dao.getDacCode())));			
									 	 } 
									
									public void addCodeAutorisation() {
										if((dao.getDacAutComSpec() == null || "".equals(dao.getDacAutComSpec()))){
											 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir le code d'autorisation SVP! ","");
											FacesContext.getCurrentInstance().addMessage(null, msg);	
											 
											 }else {
												 iservice.updateObject(dao); 
												 iservice.updateObject(newAvis);
												 comNormale = false;
												 comSpeciale = false;
												 comAutorise = true;
													
											 }
										
									}
									
									public void activieComboxAutoSpec() {
										if(listeMembreComSpec.size()==0) {
											dossDacListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
											new WhereClause("DDA_DAC_CODE",Comparateur.EQ,dao.getDacCode())));
											
											for(TDossierDacs doss : dossDacListe) {	
												iservice.deleteObject(doss);	
											}
											chargeDossierAutorisation();
											dao.setDacAutComSpec("");
											iservice.updateObject(dao);
											comboboxCom =true;
											spec = false;
											norm=false;
										}
									}
									
									public void activieComboxAutoNorm() {
										if(listeMembre.size()==0) {
											comboboxCom =true;
											spec = false;
											norm=false;
										}
									}
				
				
									//Validation des corrections
									  @Transactional 
									 public void resultatCorrection() {
										  
										  if(slctdTd.getDacBailleur().equalsIgnoreCase("B")) {
											   statutSanction ="SBO";
											   statutSanRetour ="0";
											  
										        }else 
										            if(resultat.equalsIgnoreCase("Valide")){
										        	  //statutSanction ="";
													  //statutSanRetour ="";
													  
													  if(slctdTd.getDacMention().equalsIgnoreCase("A Valider pour publication")) {
														  statutSanction ="DPU";
														  statutSanRetour ="0";
														    if(slctdTd.getMopCode().equalsIgnoreCase("AOR") || slctdTd.getMopCode().equalsIgnoreCase("PSL"))
														      {
														    	  /*listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
																			new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
																			if (!listAvis.isEmpty()) {
																				                 //Mis ÃƒÂ  jour du statut
																				                 majAvis= listAvis.get(0);
																				                 majAvis.setTStatut(new TStatut(statutSanction));
																				                 majAvis.setAaoDtePub(Calendar.getInstance().getTime());
																				                 iservice.updateObject(majAvis);
																			                       }*/
														    	
														         }else {
														        	 
														        	  /*listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
																				new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
																				if (!listAvis.isEmpty()) {
																					                 //Mis ÃƒÂ  jour du statut
																					                 majAvis= listAvis.get(0);
																					                 majAvis.setTStatut(new TStatut("APU"));
																					                 majAvis.setAaoDtePub(Calendar.getInstance().getTime());
																					                 iservice.updateObject(majAvis);
																				                       }*/
														                  }
														    	
														
													                  }else 
													                     if(slctdTd.getDacMention().equalsIgnoreCase("Validé et retour Ã Â  l'AC")){
													    	                statutSanction ="D5V";
															                statutSanRetour ="0";
													                         }
											  
										                                }else 
										                	                if(resultat.equalsIgnoreCase("Rejeté")) {
												                                  statutSanction ="SRO";
												                                  statutSanRetour ="1";
											                                    }else 
											                    	                if(resultat.equalsIgnoreCase("Retour au binome")) {
												                                        statutSanction ="D3A";
												                                        statutSanRetour ="1";
												                                          
												                                        daoBinome =(List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
												                    							new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
												                    							if (!daoBinome.isEmpty()) {
												                    								//Mis ÃƒÂ   jour de tous les DAO dans T_DAO_AFFECTATION
												                    								for(TDaoAffectation dao : daoBinome) {
												                    									 dao.setDafStaCode(statutSanction);
												                    									 dao.setDafStatutRetour(statutSanRetour);
												                    									 iservice.updateObject(dao);
												                    								       }
												                    							}
												                                             
											                                                }
							
										  
											  listCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
													  new WhereClause("COR_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
											           if (!listCorrection.isEmpty()) {
											        	 daoCorr= listCorrection.get(0);
											        	 daoCorr.setCorObservation(getObservationCor());
											        	 daoCorr.setCorFoncodValid(userController.getSlctd().getTOperateur().getOpeNom());
											        	 daoCorr.setCorResultat(resultat);
													     iservice.updateObject(daoCorr);
													     
													     //MAJ dans T_DAC_SPECS
													     listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
													    		    //new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
													    		    //new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
												 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
												 				if (!listDao.isEmpty()) {
												 					newDao= listDao.get(0);
												 					newDao.setTStatut(new TStatut(statutSanction));
												 					newDao.setDacStatutRetour(slctdTd.getDacStatutRetour());
												 			        iservice.updateObject(newDao); 
												 	   	                 }
													     //Activation du bouton d'Ã¯Â¿Â½dition du PV
												 		 etatPV = true;
										     			 etatValiderCsv = false;
										     				     
														 userController.setTexteMsg("Votre sanction a été apportée avec succès!");
														 userController.setRenderMsg(true);
														 userController.setSevrityMsg("success");
									     }   
									}					  
			
									  
									//Edition du PV de Correction
										 public void imprimerPv() {
												projetReport.stringparam1(slctdTd.getDacCode(), "PV_examen", "PV_examen");
											}
										 
										 
										 
										//Publication du DAO
											//@Transactional
										  public void publier() throws IOException {
												 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
													 statutUpdate ="D6V";
												 }else {
													 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
														 statutUpdate ="DAP";
														
													 }
  
												 }
												  
												listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
														new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
														if (!listAvis.isEmpty()) {
															//Mis ÃƒÂ  jour du statut
															majAvis= listAvis.get(0);
															majAvis.setTStatut(new TStatut("APU"));
															majAvis.setAaoDtePub(Calendar.getInstance().getTime());
															iservice.updateObject(majAvis);
														}
												 
												
												listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
														//new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
									 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
									 				if (!listDao.isEmpty()) {
									 					newDao= listDao.get(0);
									 					newDao.setTStatut(new TStatut(statutUpdate));
									 					newDao.setDacStatutRetour("0");
									 			        iservice.updateObject(newDao); 
									 	   	                 }
									 				
									 				  constantService.getStatut(statutUpdate);
					 							  	//Historisation du / des retraits
					 						       historiser(""+statutUpdate,newDao.getDacCode()," ");
					 						       
					 						      tableauBordController.saveTempTabord(""+statutUpdate, newDao.getTTypeDacSpecs().getTdcCode(), ""+userController.getSlctd().getTFonction().getFonCod(), newDao.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), newDao.getDacCode());

					 						      chargetataPub();
														
														//chargeData();
														//Actualisation du tableau de bord
														typeActionTb();
														//Message de confirmation
														userController.setTexteMsg("DAO Publié!");
														userController.setRenderMsg(true);
														userController.setSevrityMsg("success");		
									   }
	
										  
										  public void chargetataPub() throws IOException {
											  if(controleController.type == "DAC" && controleController.typePlan == "PN" 
													  && userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
												  
										    		 chargeDataAPublier("DAO", "PN", "D5V", "D5V");
										    		 
												 }else {
													 if(controleController.type == "DAC" && controleController.typePlan == "PS"
															 && userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) 
													 {
														 chargeDataAPublier("DAO", "PS", "D5V", "D5V");
													 }else {
														 if(controleController.type == "AMI" && controleController.typePlan == "PN"
																 && userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
															 chargeDataAPublier("AMI", "PN", "D5V", "D5V");
															 ;
														 }else {
															 if(controleController.type == "PRQ" && controleController.typePlan == "PN"
																	 && userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
																 chargeDataAPublier("PRQ", "PN", "D5V", "D5V");
																 
															 }else {
																 
																 //CSV
																 if(controleController.type == "DAC" && controleController.typePlan == "PN" 
																		  && userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																	  
															    		 chargeDataAPublier("DAO", "PN", "D5V", "D5V");
															    		 
																	 }else {
																		 if(controleController.type == "DAC" && controleController.typePlan == "PS"
																				 && userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) 
																		 {
																			 chargeDataAPublier("DAO", "PS", "D5V", "D5V");
																		 }else {
																			 if(controleController.type == "AMI" && controleController.typePlan == "PN"
																					 && userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																				 chargeDataAPublier("AMI", "PN", "D5V", "D5V");
																				 ;
																			 }else {
																				 if(controleController.type == "PRQ" && controleController.typePlan == "PN"
																						 && userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																					 chargeDataAPublier("PRQ", "PN", "D5V", "D5V");
																					 
																				 }
																			 }
																	     } 
																	   }
															 }
														 }
												     } 
												   }
										  }
										  
										  
										  
										  
										  
										   //Methode de vérification
										   public void checkVente() {
												 if(sitDac.equalsIgnoreCase("Nat")) { 
													 panelNcc1 = true;
													 panelNcc2 = false;
													 etatPays = false;
													 confirmInter = false;
													 confirmPaie = true;
													 clean = false;
													 //newSoumission = new TSoumissions();
													 newCandidat = new TCandidats();
												 }else 
												      if(sitDac.equalsIgnoreCase("Int")){
												    	  panelNcc1 = false;
														  panelNcc2 = true;
														  etatPays = true;
														  pays = "";
														  newSouncc = "";
														  confirmInter = true;
														  confirmPaie = false;
														  clean = false;
														  //newSoumission = new TSoumissions();
														  newCandidat = new TCandidats();
												 }
											 }
										   
										   
										 //Methode de paiement
											  @Transactional
											  public void payer() {
												  if(newCandidat.getCanNom().equalsIgnoreCase("") ||newCandidat.getCanPrenoms().equalsIgnoreCase("") || sitDac == null) {
													//Message d'erreur
														FacesContext.getCurrentInstance().addMessage(null,
																new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir le candidat ou choisir votre option", ""));
													  
												      }else { 
												    	  
												    	  //ContrÃ´le sur la vente ou le retrait
													         if(recupCout.getAaoCoutDac() == 0) {
													        	 String mois="";
															        Calendar c = Calendar.getInstance();
															        int year = c.get(Calendar.YEAR);
															        int month= c.get(Calendar.MONTH)+1;
															        String chaine="P";
															        if(month<10) {
															        mois="0"+String.valueOf(month);
															        }else {
																	mois=String.valueOf(month);
																    }
															        
															        String exo=chaine+String.valueOf(year)+mois;
															        
															        listSoumission =(List<TSoumissions>) iservice.getObjectsByColumn("TSoumissions", new ArrayList<String>(Arrays.asList("SOU_NCC")),
																			new WhereClause("SOU_NCC",WhereClause.Comparateur.EQ,""+newSouncc));
																			if (!listSoumission.isEmpty()) {
																				soumission=listSoumission.get(0);
																				soumission.setSouSigleDmp(newSoumission.getSouSigleDmp());
																				iservice.updateObject(soumission);
																			}
																			
													               if(pays.equalsIgnoreCase("")) {
												 		               newCandidat.setCanRepCode(paieCode);   
												 		               }else {
												 		                newCandidat.setCanRepCode(pays);  
												 		                }
													               if(newSouncc.equalsIgnoreCase("")) {
												 		            	 newCandidat.setCanSouNcc(newCandidat.getCanSouNcc());
													 		             newCandidat.setCanSouSigleSte(newCandidat.getCanSouSigleSte());  
												 		               }else {
												 		            	  newCandidat.setCanSouNcc(newSouncc);
													 		              newCandidat.setCanSouSigleSte(soumission.getSouSigleSte());  
												 		               }
													  
													               newCandidat.setCanDteSaisi(Calendar.getInstance().getTime());
													               newCandidat.setCanOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
													               iservice.addObject(newCandidat);
													               
													               newVente.setVenPaieCode(keyGen.getNumVente(exo));
													               newVente.setVenDteSaisi(Calendar.getInstance().getTime());
													               newVente.setTModeReglement(new TModeReglement("ESP"));
													               newVente.setTOperateur(userController.getSlctd().getTOperateur());
													               newVente.setTCandidats(newCandidat);
													               iservice.addObject(newVente);
													               
													                //Recupération du DAO dans T_DAC_SPECS
														            listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
											     			  		 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
											     			  		    if (!listDao.isEmpty()) {
											     			  			  newDao= listDao.get(0);
											     			  			  venteDetail.setTVenteDac(newVente);
											     			  			  venteDetail.setDveCout(montantRetrait);
													        	          venteDetail.setTDacSpecs(newDao);
													        	          venteDetail.setDveFonCod(userController.getSlctd().getTFonction().getFonCod());
													                      iservice.addObject(venteDetail);
											     			  				    }
											     			  		    
														  				      constantService.getStatut("RET");
												 							  //Historisation du / des retraits
												 						      historiser("RET",newDao.getDacCode(),"DAO retiré");
														  				
											    			  				  //Activation du bouton Ã¯Â¿Â½dition du rÃ¯Â¿Â½cu
												     			  			  confirmPaie = true;
												     			  			  confirmInter = false;
												     			  			  etatRecu = false;
												     			  			  clean = true;
											    			  				  //Actualisation du Tableau de Bord
											    			 		          typeActionTb();
													                    	  
											     			  				   //Message de Confirmation
											     					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectuÃ¯Â¿Â½ avec succÃ¯Â¿Â½s", ""));
											     					           userController.setTexteMsg("Retrait effectué avec succès");
											     							   userController.setRenderMsg(true);
											     							   userController.setSevrityMsg("success");	
													         }else {
													        	 
													        	    String mois="";
											 				        Calendar c = Calendar.getInstance();
											 				        int year = c.get(Calendar.YEAR);
											 				        int month= c.get(Calendar.MONTH)+1;
											 				        String chaine="P";
											 				        if(month<10) {
											 				        mois="0"+String.valueOf(month);
											 				        }else {
											 						mois=String.valueOf(month);
											 					    }
											 				        
											 				       listSoumission =(List<TSoumissions>) iservice.getObjectsByColumn("TSoumissions", new ArrayList<String>(Arrays.asList("SOU_NCC")),
																			new WhereClause("SOU_NCC",WhereClause.Comparateur.EQ,""+newSouncc));
																			if (!listSoumission.isEmpty()) {
																				soumission=listSoumission.get(0);
																				soumission.setSouSigleDmp(newSoumission.getSouSigleDmp());
																				iservice.updateObject(soumission);
																			}
											 				        
											 				       String exo=chaine+String.valueOf(year)+mois;
											 		               newCandidat.setCanDteSaisi(Calendar.getInstance().getTime());
											 		               if(pays == null) {
											 		            	  newCandidat.setCanRepCode(paieCode);   
											 		               }else {
											 		            	  newCandidat.setCanRepCode(pays);  
											 		               }
											 		               
											 		               if(newSouncc == null) {
											 		            	  newCandidat.setCanSouNcc(newCandidat.getCanSouNcc());
												 		              newCandidat.setCanSouSigleSte(newCandidat.getCanSouSigleSte());  
											 		               }else {
											 		            	  newCandidat.setCanSouNcc(newSouncc);
												 		              newCandidat.setCanSouSigleSte(soumission.getSouSigleSte());  
											 		               }
											 		               
											 		               newCandidat.setCanOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
											 		               iservice.addObject(newCandidat);
											 		               
											 		               newVente.setVenPaieCode(keyGen.getNumVente(exo));
											 		               newVente.setVenDteSaisi(Calendar.getInstance().getTime());
											 		               newVente.setTModeReglement(new TModeReglement("ESP"));
											 		               newVente.setTOperateur(userController.getSlctd().getTOperateur());
											 		               newVente.setTCandidats(newCandidat);
											 		               iservice.addObject(newVente);
											 		                    
											 		                //RecupÃ¯Â¿Â½ration du DAO dans T_DAC_SPECS
											 			            listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
											      			  		 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
											      			  		    if (!listDao.isEmpty()) {
											      			  			  newDao= listDao.get(0);
											      			  			  venteDetail.setTVenteDac(newVente);
											      			  			  venteDetail.setDveCout(recupCout.getAaoCoutDac());
											 		        	          venteDetail.setTDacSpecs(newDao);
											 		        	          venteDetail.setDveFonCod(userController.getSlctd().getTFonction().getFonCod());
											 		                      iservice.addObject(venteDetail);
											      			  				    }
											      			  		    
											 			  				        constantService.getStatut("DVE");
												 							  	//Historisation du / des retraits
												 						       historiser("DVE",newDao.getDacCode(),"DAO payé");
											     			  				    
											     			  				   //Activation du bouton édition du récu
											     			  				   confirmPaie = true;
											     			  				   confirmInter = false;
											     			  				   etatRecu = true;
											     			  				   clean = true;
											     			  				   
											     			  				   //Actualisation du Tableau de Bord
											     			 		           typeActionTb();
											     			 		          
											     			 		           chargeData();
											      			  				   //Message de Confirmation
											      					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectuÃ¯Â¿Â½ avec succÃ¯Â¿Â½s", ""));
											      					           userController.setTexteMsg("Paiement effectué avec succès");
											      							   userController.setRenderMsg(true);
											      							   userController.setSevrityMsg("success");
													                 }
												                   }    
											                }
											  //Fin Methode de Paiement
											  
											  //vider les champs après un paiement
											  public void cleanPaiement() {
												  newCandidat = new TCandidats();
												  soumission = new TSoumissions();
												  newSoumission = new TSoumissions();
												  paieCode ="";
												  pays="";
												  sitDac="";
												  newSouncc ="";
												  etatRecu = false;
												  clean = false;
												  //confirmInter = false;
												  //confirmPaie = false;
											  }
											  
											  //Methode de rÃ¯Â¿Â½cupÃ¯Â¿Â½ration du nombre de vente 
											  public void detailVente() {
												listeDetailVente = (List<VDacVendu>) iservice.getObjectsByColumn("VDacVendu", new ArrayList<String>(Arrays.asList("DVE_DAC_CODE")),
								      			  		 new WhereClause("DVE_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()),
								      			  		 new WhereClause("DVE_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					      			  		             if (!listeDetailVente.isEmpty()) {
					      			  			            detailVente= listeDetailVente.get(0);
					      			  				    }
											  }
											  
											  
											//Methode de paiement pour entreprise internationale
											  @Transactional
											  public void payerInt() {
												  if(newCandidat.getCanNom().equalsIgnoreCase("") ||newCandidat.getCanPrenoms().equalsIgnoreCase("") || sitDac == null) {
													//Message d'erreur
														FacesContext.getCurrentInstance().addMessage(null,
																new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir le candidat ou choisir votre option", ""));
													  
												      }else { 
												    	  
												    	  //ContrÃƒÂ´le sur la vente ou le retrait
													         if(recupCout.getAaoCoutDac() == 0) {
													        	 String mois="";
															        Calendar c = Calendar.getInstance();
															        int year = c.get(Calendar.YEAR);
															        int month= c.get(Calendar.MONTH)+1;
															        String chaine="P";
															        if(month<10) {
															        mois="0"+String.valueOf(month);
															        }else {
																	mois=String.valueOf(month);
																    }
															        
															       String exo=chaine+String.valueOf(year)+mois;
												 		           newCandidat.setCanRepCode(paieCode);   
												 		           newCandidat.setCanSouNcc(newCandidat.getCanSouNcc());
													 		       newCandidat.setCanSouSigleSte(newCandidat.getCanSouSigleSte());  
													               newCandidat.setCanDteSaisi(Calendar.getInstance().getTime());
													               newCandidat.setCanOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
													               iservice.addObject(newCandidat);
													               
													               newVente.setVenPaieCode(keyGen.getNumVente(exo));
													               newVente.setVenDteSaisi(Calendar.getInstance().getTime());
													               newVente.setTModeReglement(new TModeReglement("ESP"));
													               newVente.setTOperateur(userController.getSlctd().getTOperateur());
													               newVente.setTCandidats(newCandidat);
													               iservice.addObject(newVente);
													               
												
													                //RecupÃ¯Â¿Â½ration du DAO dans T_DAC_SPECS
														            listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
											     			  		 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
											     			  		    if (!listDao.isEmpty()) {
											     			  			  newDao= listDao.get(0);
											     			  			  venteDetail.setTVenteDac(newVente);
											     			  			  venteDetail.setDveCout(montantRetrait);
													        	          venteDetail.setTDacSpecs(newDao);
													        	          venteDetail.setDveFonCod(userController.getSlctd().getTFonction().getFonCod());
													                      iservice.addObject(venteDetail);
											     			  				    }
											     			  		    
														  				      
														  				     constantService.getStatut("RET");
												 							  	//Historisation du / des retraits
												 						       historiser("RET",newDao.getDacCode(),"DAO retiré");
														  				
											    			  				 //Activation du bouton Ã¯Â¿Â½dition du rÃ¯Â¿Â½cu
												 						      confirmPaie = false;
											     			  				  confirmInter = true;
											     			  				  etatRecu = false;
											     			  				  clean = true;
											    			  				  //Actualisation du Tableau de Bord
											    			 		          typeActionTb();
													                    	  
											    			 		          
											     			  				   //Message de Confirmation
											     					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectuÃ¯Â¿Â½ avec succÃ¯Â¿Â½s", ""));
											     					           userController.setTexteMsg("Retrait effectué avec succès");
											     							   userController.setRenderMsg(true);
											     							   userController.setSevrityMsg("success");	
													         }else {
													        	 
													        	    String mois="";
											 				        Calendar c = Calendar.getInstance();
											 				        int year = c.get(Calendar.YEAR);
											 				        int month= c.get(Calendar.MONTH)+1;
											 				        String chaine="P";
											 				        if(month<10) {
											 				        mois="0"+String.valueOf(month);
											 				        }else {
											 						mois=String.valueOf(month);
											 					    }
											 				        
											 				     
											 				       String exo=chaine+String.valueOf(year)+mois;
											 		               newCandidat.setCanDteSaisi(Calendar.getInstance().getTime());
											 		               newCandidat.setCanRepCode(paieCode);  
											 		               newCandidat.setCanSouNcc(newCandidat.getCanSouNcc());
												 		           newCandidat.setCanSouSigleSte(newCandidat.getCanSouSigleSte());  
											 		               newCandidat.setCanOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
											 		               iservice.addObject(newCandidat);
											 		               
											 		               newVente.setVenPaieCode(keyGen.getNumVente(exo));
											 		               newVente.setVenDteSaisi(Calendar.getInstance().getTime());
											 		               newVente.setTModeReglement(new TModeReglement("ESP"));
											 		               newVente.setTOperateur(userController.getSlctd().getTOperateur());
											 		               newVente.setTCandidats(newCandidat);
											 		               iservice.addObject(newVente);
											 		                    
											 		                //RecupÃ¯Â¿Â½ration du DAO dans T_DAC_SPECS
											 			            listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
											      			  		 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
											      			  		    if (!listDao.isEmpty()) {
											      			  			  newDao= listDao.get(0);
											      			  			  venteDetail.setTVenteDac(newVente);
											      			  			  venteDetail.setDveCout(recupCout.getAaoCoutDac());
											 		        	          venteDetail.setTDacSpecs(newDao);
											 		        	          venteDetail.setDveFonCod(userController.getSlctd().getTFonction().getFonCod());
											 		                      iservice.addObject(venteDetail);
											      			  				    }
											      			  		    
											 			  				        constantService.getStatut("DVE");
												 							  	//Historisation du / des retraits
												 						       historiser("DVE",newDao.getDacCode(),"DAO payé");
											     			  				 
												 						       //Activation du bouton Ã¯Â¿Â½dition du rÃ¯Â¿Â½cu
													 						   confirmPaie = false;
												     			  			   confirmInter = true;
												     			  			   etatRecu = true;
												     			  			   clean = true;
											     			  				   //Actualisation du Tableau de Bord
											     			 		           typeActionTb();
											     			 		          
											     			 		           chargeData();
											      			  				   //Message de Confirmation
											      					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectuÃ¯Â¿Â½ avec succÃ¯Â¿Â½s", ""));
											      					           userController.setTexteMsg("Paiement effectué avec succès");
											      							   userController.setRenderMsg(true);
											      							   userController.setSevrityMsg("success");
													                 }
												                   }    
											                }
											  //Fin Methode de Paiement
											  				  
								
											  
											//Nombre de vente pour un DAO x
											  public int getDaoVenteTotal(){
											  	int i = iservice.countTableByColumn("T_HISTO_DAC", "HAC_ID",
											  			new WhereClause("HAC_STA_CODE", WhereClause.Comparateur.EQ,"DVE"),
											  			new WhereClause("HAC_DAC_CODE", WhereClause.Comparateur.EQ,""+newDao.getDacCode()),
											  			new WhereClause("HAC_FON_COD", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
											  	return	i;	
											  }
											  
											  
											  //Verification du numero de vente
												 public void verifierNumNcc() {
													 listSoumission =(List<TSoumissions>) iservice.getObjectsByColumn("TSoumissions", new ArrayList<String>(Arrays.asList("SOU_NCC")),
													new WhereClause("SOU_NCC",WhereClause.Comparateur.EQ,""+newSouncc));
													if (!listSoumission.isEmpty()) {
														soumission=listSoumission.get(0);
														
														 if(soumission.getSouNatInt().equalsIgnoreCase("N")) {
															etatPays = false; 
															pays = soumission.getSouPayCode();
														 }else {
															 etatPays = true; 
															 pays="";
														 }
														  
													}else {
														//infoNcc=false;
														soumission = new TSoumissions();
														FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le NCC n'est pas inscrit dans la base des Marchés Publics! ", "")); 	 
													}
												 }
											  
												 //DÃ¯Â¿Â½but de la vente du DAO
													public void finVente() {
														String statUpdate = "";
														String message = "";
														if(slctdTd.getDacStaCode().equalsIgnoreCase("DAP")) {
															statUpdate = "DVE";
															message="Fin de la vente du Dossier d'Appel Ã Â  Concurrence NÂ°"+slctdTd.getDacCode();
														 }
														//RecupÃ¯Â¿Â½ration du DAO dans T_DAC_SPECS
											            listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
								     			  		 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
								     			  		    if (!listDao.isEmpty()) {
								     			  			  newDao= listDao.get(0);
								     			  			  newDao.setTStatut(new TStatut(statUpdate));
										                      iservice.updateObject(newDao);
								     			  			}
													
														//Chargement de la liste des ventes et celle du tableau de Bord
														chargeData();
														typeActionTb();
														userController.setTexteMsg(message);
														userController.setRenderMsg(true);
														userController.setSevrityMsg("success");  
													}
											        //Fin de la vente du DAO
													
													
													//DÃ¯Â¿Â½but de retrait du DAO
													 public void finRetrait() {
														String statRetrait = "";
														String message = "";
														if(slctdTd.getDacStaCode().equalsIgnoreCase("DAP")) {
															statRetrait = "RET";
															message="Fin de retrait du Dossier d'Appel Ã  Concurrence NÂ°"+slctdTd.getDacCode();
														 }
														
														 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										 					     new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
										 				           if (!listDao.isEmpty()) {
										 					            newDao= listDao.get(0);
										 					            newDao.setTStatut(new TStatut(statRetrait));
										 			                    iservice.updateObject(newDao); 
														
										 			    //Chargement de la liste des retraits et celle du tableau de Bord
														chargeData();
														typeActionTb();
														userController.setTexteMsg(message);
														userController.setRenderMsg(true);
														userController.setSevrityMsg("success");  
													}
												}
											//Fin de retrait du DAO
													
													
													//Récupération du montant du DAO
													  public void recupMontantDao() { 
														  dacVente = (List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
																      //new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
																      //new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
																	  new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
																      if (!dacVente.isEmpty()) {
																    	  recupCout= dacVente.get(0); 
													   	              }	
																      
																     //ContrÃƒÂ´le sur la vente ou le retrait
																         if(recupCout.getAaoCoutDac() == 0) {
																        	 confirmRetrait = true;
																        	 confirmVente = false;
																        	 titreRetrait = true;
																        	 titreVente = false;
																        	 btn_titre_paie = false;
																        	 btn_titre_retrait = true;
																         }else {
																        	 confirmRetrait = false;
																        	 confirmVente = true;
																        	 titreRetrait = false;
																        	 titreVente = true;
																        	 btn_titre_paie = true;
																        	 btn_titre_retrait = false;
																         }
													             }
													  
													  
													//Liste des entreprises de la love
														 public void chargeSoumissions(){
															 listSoumission=(List<TSoumissions>) iservice.getObjectsByColumnDesc("TSoumissions", new ArrayList<String>(Arrays.asList("SOU_NCC")));	
														 } 
														 
														//Edition du recu de paiement
														 public void imprimerRecu() {
																projetReport.stringparam3(slctdTd.getDacCode(), newCandidat.getCanNom(), newCandidat.getCanPrenoms(), "Recu_dao", "Recu_dao");
															}
								
														//chargement des listes pour la publication
														  public void chargeDaoPUB() throws IOException{ 
																 String fonct = controleController.getFonctionalite();
																 //DEBUT DAO PubliÃ¯Â¿Â½ 
																 if(controleController.type == "DAC" && controleController.typePlan == "PN") { 
																	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																		 //Affichage des differentes listes du Chef de Service ProcÃ¯Â¿Â½dure en fonction de l'action
																			 if(fonct.equalsIgnoreCase("listePubCsv")) {
																				chargeDataAPublier("DAO","PN","D6V","DPU");	
																			 }else {
																				 if(fonct.equalsIgnoreCase("listeDpubCsv")) {
																					 //chargeDetailAC1("PN", "DAO", "DEV");
																				 }else {
																					
																				 }	 
																			 }
																       //Fin affichage CSV
																	     }

																	 }else
																	      if(controleController.type == "DAC" && controleController.typePlan == "PS"){
													                           //if(controleController.type == "DAC" && controleController.typePlan == "PS") { 
																	              if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																		                //Affichage des differentes listes du Chef de Service ProcÃ¯Â¿Â½dure en fonction de l'action
																			       if(fonct.equalsIgnoreCase("listePubDpsCsv")) {
																				      chargeDataAPublier("DAO", "PS","D6V","DPU");	
																			        }else {
																				       if(fonct.equalsIgnoreCase("listePubDdpsCsv")) {
																					        //chargeDetailAC1("PS", "DAO", "");
																				     }else {
																				 }	 
																			 }
																       //Fin affichage  CSV 
																	 }
																	//}
																}else
																	 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
																		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																                //Affichage des differentes listes du Chef de Service ProcÃ¯Â¿Â½dure en fonction de l'action
																	       if(fonct.equalsIgnoreCase("listeAmiCsv")) {
																		      chargeDataAPublier("AMI", "PN","D6V","DPU");	
																	        }else {
																		       if(fonct.equalsIgnoreCase("listeDamiCsv")) {
																			        //chargeDetailAC1("PS", "DAO", "");
																		     }else {
																			
																		               }	 
																	                }
														       //Fin affichage  CSV 
															                 }	    
																	 }else  
																		  if(controleController.type == "AMI" && controleController.typePlan == "PS") {
																			  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																	                //Affichage des differentes listes du Chef de Service ProcÃ¯Â¿Â½dure en fonction de l'action
																		       if(fonct.equalsIgnoreCase("listePubDamiCsv")) {
																			      chargeDataAPublier("AMI", "PS","D6V","DPU");	
																		        }else {
																			       if(fonct.equalsIgnoreCase("listePubAdpsCsv")) {
																				        //chargeDetailAC1("PS", "DAO", "");
																			     }else {
																				
																			               }	 
																		                }
															       //Fin affichage  CSV 
																                 }	
																		  }else
																			   if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
																				   if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																		                //Affichage des differentes listes du Chef de Service ProcÃ¯Â¿Â½dure en fonction de l'action
																			       if(fonct.equalsIgnoreCase("listePrqCsv")) {
																				      chargeDataAPublier("PRQ","PN","D6V","DPU");	
																			        }else {
																				       if(fonct.equalsIgnoreCase("listeDprqCsv")) {
																					        //chargeDetailAC1("PS", "DAO", "");
																				     }else {
																					
																				               }	 
																			                }
																       //Fin affichage  CSV 
																	                 }	
																			   }
															     }
														  //Fin de la Methode	
														  
														  public void chargeDataAPublier(String typeDac,String typePlan,String stat1,String stat2) throws IOException{ 
														 		
														 		if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
														 					
														 				 }else {
														 					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
														 						 
														 					 }else {
														 						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
														 							 publicationListe =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
													 										 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
													 										 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
													 										 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
													 								         //multiFiltre ="";
													 									_logger.info("publicationListe size: "+publicationListe.size());	
													 									typeActionTb(); 
														 						 }else
														 							  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
														 								 publicationListe =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
														 										 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
														 										 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
														 										 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
														 								        // multiFiltre ="";
														 									_logger.info("publicationListe size: "+publicationListe.size());	
														 									typeActionTb(); 
														 					      }
														 				     } 
															 	
															 		        }	   
																 		  
																	     }
												     //Fin de la methode de Publication
														  									 
		     //Methode vider
		     public void vider() { 
		    	 listeCritereSaisie.clear();
		    	 daoDetail = new VPpmDao();
		    	 dao = new TDacSpecs();
		    	 detailsPieces.clear();
		    	 listSelectionTypePieces.clear();
		    	 newAvis = new TAvisAppelOffre();
		    	 newVbTemp = new VbTempParametreLot();
		    	 listeLots = new ArrayList<TLotAao>();
		    	 listeLotCritere = new ArrayList<VLotCritere>();
		    	 listAdresse = new ArrayList<TAdresseAvis>();
		    	 listDetailAdresse = new ArrayList<VDetailAdresse>(); 
		    	 listeSelectionPiecesOffres.clear();
		    	 listeMembreComSpec.clear();
		    	 dossDacListe.clear();
		    	 pieceCode = "";
		    	 //listLibelleAdresse = new ArrayList<TLibelleAdresse>();
		    	 newDtailAdresse = new TDetailAdresseAvis();
		    	 newLot = new TLotAao();
		    	 totalMontantEstimatif = 0;
		    	 totalMontantCaution = 0;
		     }
		     
		     
		     
		     //Methode pour vider la liste des critères du lot 0
		     public void viderCritereLot0() {
		    	 /*listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
						    new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,"0"),
						    new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		    	 
		     //Parcourir la liste VPpmListe et faire une mise a jour des different statut
			  for(TDetCritAnalyseDac crit : listeDetCritere) { 
				  iservice.deleteObject(crit); 
		  		  chargeCritereSaisie();
		  		  chargeCritere();
			  	  userController.setTexteMsg("Liste des critères vidée avec succès!");
				  userController.setRenderMsg(true);
				  userController.setSevrityMsg("success");
			    } 	         
			  critere="";*/

			   /*  newTempFactorise.setTempCritDac(dao.getDacCode());
				 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
				 newTempFactorise.setTempLotPlage("0");
				 newTempFactorise.setTempType("SUP");
				 iservice.addObject(newTempFactorise); 
				 chargeCritereSaisie();
		  		 chargeCritere();*/
		  		 
		  		newTempFactSup.setTempCritDac(dao.getDacCode());
		  		newTempFactSup.setTempDcadNum("");
		  		newTempFactSup.setTempNbrLot(newAvis.getAaoNbrLot());
		  		newTempFactSup.setTempLotPlage("0");
		  		newTempFactSup.setTempType("SUP");
				 iservice.addObject(newTempFactSup);
				 chargeCritereSaisie();
		  		 chargeCritere();
		  		 //critere="";
		  		 //newTempFactorise.getTempLotPlage().equalsIgnoreCase("");
		  		 userController.setTexteMsg("Liste des critères vidée avec succès!");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
		     }
		     
		     
		     //Methode pour vider la liste des critères (lot par lot)
		     public void viderCritereByLot() {
		    	 
		    	 listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
						    new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
						    new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		    	 
		     //Parcourir la liste VPpmListe et faire une mise a jour des different statut
			  for(TDetCritAnalyseDac crit : listeDetCritere) {  
				  iservice.deleteObject(crit); 
			      chargeCritereByLot();
			      chargeCritereFactCombobox();
			      chargeLotCritere();
			  	  userController.setTexteMsg("Liste des critères vidée avec succès!");
				  userController.setRenderMsg(true);
				  userController.setSevrityMsg("success");
			    }
			  
			 /* listeLot = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")),
					     new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()), 
						 new WhereClause("LAA_ID",WhereClause.Comparateur.EQ,""+laaId));
		       if (! listeLot.isEmpty()) {
		    	   lots = listeLot.get(0);
		       }
			  
			     newTempFactSup.setTempCritDac(dao.getDacCode());
		  		 newTempFactSup.setTempNbrLot(newAvis.getAaoNbrLot());
		  		 newTempFactSup.setTempDcadNum("");
		  		 newTempFactSup.setTempLotPlage(lots.getLaaNum().toString());
		  		 newTempFactSup.setTempType("SUP");
				 iservice.addObject(newTempFactSup);
			     chargeCritereFactCombobox();
			     chargeLotCritere();
			     chargeCritereByLot();
			  	 userController.setTexteMsg("Liste des critères vidée avec succès!");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
				 
				 _logger.info("DAC: "+dao.getDacCode());
				 _logger.info("ID Lot: "+laaId);
				 _logger.info("Number Lot: "+lots.getLaaNum().toString());
				 _logger.info("Nbre Lot: "+newAvis.getAaoNbrLot());
				 _logger.info("TYPE : "+newTempFactSup.getTempType());
		     }*/
		     
		     
		     }
		     
		     
		     
		     //Publication Des DAO
			  public void publierDao() throws IOException{ 
			 		if (publicationSelection.size()==0) {
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun DAC selectionné", ""));
					}
			 		else{
			 				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 					 statutPub ="";
			 				 }else {
			 					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
			 						 statutPub ="";
			 					 }else {
			 						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
			 							 statutUpdate ="DAP";
			 						 }else
			 							  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
			 								 statutPub ="DAP";
			 					      }
			 				     } 
			 			//Parcourir la liste VPpmListe et faire une mise a jour des different statut
				 		for(VDacliste ligneDac : publicationSelection) {
				 			 
				 			//Parcourir la liste et rÃ¯Â¿Â½cupÃ¯Â¿Â½rer les demande au statut E1T
				 			listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
      	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+ligneDac.getDacCode()));
      	     				   if (!listDao.isEmpty()) {
      	     					    newDao= listDao.get(0);
      	     					    newDao.setTStatut(new TStatut(statutPub));
      	     			            iservice.updateObject(newDao); 
      	     	   	                 }	
									}
				 		
				 		//Historisation de l'opÃ¯Â¿Â½ration
					     historiser(""+statutPub, newDao.getDacCode(),"Opération publiée par la DMP");
					     
                        //Actualisation du Tableau de Bord
					     typeActionTb();
					    //Rafraichissement de la liste
						 chargeDaoPUB();
						//Message de confirmation		  
						 userController.setTexteMsg(" Publication effectuée avec succès !");
						 userController.setRenderMsg(true);
						 userController.setSevrityMsg("success");
						//return null;
				 		
				 		        }	   
					 		   }	
						     }
	     //Fin de la methode de Publication
		     
		     
		     
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);	 
		     switch(value) {
				case "dao1":
					chargeData();
					chargeDetailTB();
					chargeNatureDocTrans();
					//chargeDataPs();
					chargeDaoPUB();
					btn_corrige = true;
					etatPV = false;
					vider();
					_logger.info("value: "+value+" action "+action);	
					break;
				case "dao2":
					chargePPM();
					chargeAdresse();
					chargeLots();
					chargeImputation();
					//chargePiecesOffres();
					 panelOuverture();
					 chargeMembreCommission();
					 btn_save_presence = true;
					 btn_save_expert = false;
					 panelMbr = true;
					 panelExpert = false;
					 btn_ad_expert = false;
					 selectionMembres.clear();
					 selectionlisteExpert.clear();
					 pavet_critere = false;
					 pavet_lot = false;
					 pavet_offre = false;
					 pavet_commission = false;
					 comboboxCom = true;
					 norm = false;
					 spec = false;
					 typeCommission ="N";
					 comNormale = true;
					 comSpeciale = false;
					 comAutorise = false;
					 newTempFactorise = new VbTempParametreFact(); 
				break;
				case "dao3":
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao4":
		 			_logger.info("value: "+value+" action: "+action);
				break;
                case "dao5":
                	 chargeFonctionImput();
                	 chargeDaoAffectesR();
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao6":
                	//chargePiecesByDao();
                	chargePiecesByCsv();
                	chargePiecesByCharges();
                	chargeRespoExiste();
                	chargePiecesByBinome();
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao7":
		 			_logger.info("value: "+value+" action: "+action);
				break;  
				
                case "dao9":
                	 recupMontantDao();
                	 newCandidat = new TCandidats();
                	 etatRecu = false;
                	 sitDac = "";
		 			_logger.info("value: "+value+" action: "+action);
				break; 
				
                case "dao10":
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

/*	public List<VLigneImputation> getListeImputations() {
		return listeImputations;
	}

	public void setListeImputations(List<VLigneImputation> listeImputations) {
		this.listeImputations = listeImputations;
	}*/

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

	public List<VDacliste> getDetailTB() {
		return detailTB;
	}

	public void setDetailTB(List<VDacliste> detailTB) {
		this.detailTB = detailTB;
	}

	public List<VFonctionImputation> getListeFonctionsImput() {
		return listeFonctionsImput;
	}

	public void setListeFonctionsImput(List<VFonctionImputation> listeFonctionsImput) {
		this.listeFonctionsImput = listeFonctionsImput;
	}

	public List<TCorrectionDac> getListCorrection() {
		return listCorrection;
	}

	public void setListCorrection(List<TCorrectionDac> listCorrection) {
		this.listCorrection = listCorrection;
	}

	public List<TCorrectionDac> getListPieceCorrection() {
		return listPieceCorrection;
	}

	public void setListPieceCorrection(List<TCorrectionDac> listPieceCorrection) {
		this.listPieceCorrection = listPieceCorrection;
	}

	public boolean isOuverture() {
		return ouverture;
	}

	public void setOuverture(boolean ouverture) {
		this.ouverture = ouverture;
	}

	public List<VDetailCorrectionCharge> getListeCorrectionCharge() {
		return listeCorrectionCharge;
	}

	public void setListeCorrectionCharge(List<VDetailCorrectionCharge> listeCorrectionCharge) {
		this.listeCorrectionCharge = listeCorrectionCharge;
	}

	public List<TDaoAffectation> getDaoBinome() {
		return daoBinome;
	}

	public void setDaoBinome(List<TDaoAffectation> daoBinome) {
		this.daoBinome = daoBinome;
	}

	public List<TDacSpecs> getListeDaoCsvValid() {
		return listeDaoCsvValid;
	}

	public void setListeDaoCsvValid(List<TDacSpecs> listeDaoCsvValid) {
		this.listeDaoCsvValid = listeDaoCsvValid;
	}

	public List<TSoumissions> getListSoumission() {
		return listSoumission;
	}

	public void setListSoumission(List<TSoumissions> listSoumission) {
		this.listSoumission = listSoumission;
	}
		public boolean isPavet_lot() {
		return pavet_lot;
	}

	public void setPavet_lot(boolean pavet_lot) {
		this.pavet_lot = pavet_lot;
	}

	public boolean isPavet_offre() {
		return pavet_offre;
	}

	public void setPavet_offre(boolean pavet_offre) {
		this.pavet_offre = pavet_offre;
	}

	public boolean isBtn_dao() {
		return btn_dao;
	}

	public void setBtn_dao(boolean btn_dao) {
		this.btn_dao = btn_dao;
	}


	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public boolean isConfirmRetrait() {
		return confirmRetrait;
	}

	public void setConfirmRetrait(boolean confirmRetrait) {
		this.confirmRetrait = confirmRetrait;
	}

	public boolean isTitreVente() {
		return titreVente;
	}

	public void setTitreVente(boolean titreVente) {
		this.titreVente = titreVente;
	}

	public boolean isTitreRetrait() {
		return titreRetrait;
	}

	public void setTitreRetrait(boolean titreRetrait) {
		this.titreRetrait = titreRetrait;
	}

	public boolean isBtn_titre_paie() {
		return btn_titre_paie;
	}

	public void setBtn_titre_paie(boolean btn_titre_paie) {
		this.btn_titre_paie = btn_titre_paie;
	}

	public boolean isBtn_titre_retrait() {
		return btn_titre_retrait;
	}

	public void setBtn_titre_retrait(boolean btn_titre_retrait) {
		this.btn_titre_retrait = btn_titre_retrait;
	}

	public List<VbPaysReference> getListePays() {
		return listePays;
	}

	public void setListePays(List<VbPaysReference> listePays) {
		this.listePays = listePays;
	}

	public List<VbCommissionType> getMembresCommission() {
		return membresCommission;
	}

	public void setMembresCommission(List<VbCommissionType> membresCommission) {
		this.membresCommission = membresCommission;
	}

	public List<VbCommissionType> getSelectionMembres() {
		return selectionMembres;
	}

	public void setSelectionMembres(List<VbCommissionType> selectionMembres) {
		this.selectionMembres = selectionMembres;
	}

	public List<VCommissionTypeExp> getListeExpert() {
		return listeExpert;
	}

	public void setListeExpert(List<VCommissionTypeExp> listeExpert) {
		this.listeExpert = listeExpert;
	}

	public List<VCommissionTypeExp> getSelectionlisteExpert() {
		return selectionlisteExpert;
	}

	public void setSelectionlisteExpert(List<VCommissionTypeExp> selectionlisteExpert) {
		this.selectionlisteExpert = selectionlisteExpert;
	}

	public VbCommissionSpecifique getNewcomSpec() {
		return newcomSpec;
	}

	public void setNewcomSpec(VbCommissionSpecifique newcomSpec) {
		this.newcomSpec = newcomSpec;
	}

	public boolean isBtn_save_presence() {
		return btn_save_presence;
	}

	public void setBtn_save_presence(boolean btn_save_presence) {
		this.btn_save_presence = btn_save_presence;
	}

	public boolean isBtn_save_expert() {
		return btn_save_expert;
	}

	public void setBtn_save_expert(boolean btn_save_expert) {
		this.btn_save_expert = btn_save_expert;
	}

	public boolean isBtn_ad_expert() {
		return btn_ad_expert;
	}

	public void setBtn_ad_expert(boolean btn_ad_expert) {
		this.btn_ad_expert = btn_ad_expert;
	}

	public boolean isPanelMbr() {
		return panelMbr;
	}

	public void setPanelMbr(boolean panelMbr) {
		this.panelMbr = panelMbr;
	}

	public boolean isPanelExpert() {
		return panelExpert;
	}

	public void setPanelExpert(boolean panelExpert) {
		this.panelExpert = panelExpert;
	}

	public String getPaieCode() {
		return paieCode;
	}

	public void setPaieCode(String paieCode) {
		this.paieCode = paieCode;
	}

	public String getNewSouncc() {
		return newSouncc;
	}

	public void setNewSouncc(String newSouncc) {
		this.newSouncc = newSouncc;
	}

	public boolean isInfoNcc() {
		return infoNcc;
	}

	public void setInfoNcc(boolean infoNcc) {
		this.infoNcc = infoNcc;
	}

	public List<VbCommissionSpecifique> getListeMbr() {
		return listeMbr;
	}

	public void setListeMbr(List<VbCommissionSpecifique> listeMbr) {
		this.listeMbr = listeMbr;
	}




	public List<TDetCritAnalyseDac> getListeDetCritere() {
		return listeDetCritere;
	}

	public void setListeDetCritere(List<TDetCritAnalyseDac> listeDetCritere) {
		this.listeDetCritere = listeDetCritere;
	}


	public VCommissionSpecifique getSltCompsec() {
		return sltCompsec;
	}

	public void setSltCompsec(VCommissionSpecifique sltCompsec) {
		this.sltCompsec = sltCompsec;
	}

	public VbCritereAnalyse getSltCritere() {
		return sltCritere;
	}

	public void setSltCritere(VbCritereAnalyse sltCritere) {
		this.sltCritere = sltCritere;
	}

	public VbDetCritAnalyseDac getNewCritereDac() {
		return newCritereDac;
	}

	public void setNewCritereDac(VbDetCritAnalyseDac newCritereDac) {
		this.newCritereDac = newCritereDac;
	}

	public List<VbCritereAnalyse> getListeCritere() {
		return listeCritere;
	}

	public void setListeCritere(List<VbCritereAnalyse> listeCritere) {
		this.listeCritere = listeCritere;
	}

	public String getCraCode() {
		return craCode;
	}

	public void setCraCode(String craCode) {
		this.craCode = craCode;
	}

	public VbDetCritAnalyse getNewDetCritere() {
		return newDetCritere;
	}

	public void setNewDetCritere(VbDetCritAnalyse newDetCritere) {
		this.newDetCritere = newDetCritere;
	}

	public boolean isPavet_critere() {
		return pavet_critere;
	}

	public void setPavet_critere(boolean pavet_critere) {
		this.pavet_critere = pavet_critere;
	}

	public boolean isPavet_commission() {
		return pavet_commission;
	}

	public void setPavet_commission(boolean pavet_commission) {
		this.pavet_commission = pavet_commission;
	}

	public List<VDacliste> getPublicationListe() {
		return publicationListe;
	}

	public void setPublicationListe(List<VDacliste> publicationListe) {
		this.publicationListe = publicationListe;
	}

	public List<VDacliste> getPublicationSelection() {
		return publicationSelection;
	}

	public void setPublicationSelection(List<VDacliste> publicationSelection) {
		this.publicationSelection = publicationSelection;
	}

	public String getFourniture_PSL() {
		return fourniture_PSL;
	}

	public void setFourniture_PSL(String fourniture_PSL) {
		this.fourniture_PSL = fourniture_PSL;
	}

	public String getFourniture_PSO() {
		return fourniture_PSO;
	}

	public void setFourniture_PSO(String fourniture_PSO) {
		this.fourniture_PSO = fourniture_PSO;
	}

	public String getFourniture_PSC() {
		return fourniture_PSC;
	}

	public void setFourniture_PSC(String fourniture_PSC) {
		this.fourniture_PSC = fourniture_PSC;
	}

	public String getTravaux_PSL() {
		return travaux_PSL;
	}

	public void setTravaux_PSL(String travaux_PSL) {
		this.travaux_PSL = travaux_PSL;
	}

	public String getTravaux_PSO() {
		return travaux_PSO;
	}

	public void setTravaux_PSO(String travaux_PSO) {
		this.travaux_PSO = travaux_PSO;
	}

	public String getTravaux_PSC() {
		return travaux_PSC;
	}

	public void setTravaux_PSC(String travaux_PSC) {
		this.travaux_PSC = travaux_PSC;
	}

	public String getPrestations_PSL() {
		return prestations_PSL;
	}

	public void setPrestations_PSL(String prestations_PSL) {
		this.prestations_PSL = prestations_PSL;
	}

	public String getPrestations_PSO() {
		return prestations_PSO;
	}

	public void setPrestations_PSO(String prestations_PSO) {
		this.prestations_PSO = prestations_PSO;
	}

	public String getPrestations_PSC() {
		return prestations_PSC;
	}

	public void setPrestations_PSC(String prestations_PSC) {
		this.prestations_PSC = prestations_PSC;
	}

	public String getStatutPub() {
		return statutPub;
	}

	public void setStatutPub(String statutPub) {
		this.statutPub = statutPub;
	}

	public List<VCritereAnalyseModel> getListeCritereAnalyse() {
		return listeCritereAnalyse;
	}

	public void setListeCritereAnalyse(List<VCritereAnalyseModel> listeCritereAnalyse) {
		this.listeCritereAnalyse = listeCritereAnalyse;
	}

	public List<VCritereAnalyseModel> getSelectionlisteCritereAnalyse() {
		return selectionlisteCritereAnalyse;
	}

	public void setSelectionlisteCritereAnalyse(List<VCritereAnalyseModel> selectionlisteCritereAnalyse) {
		this.selectionlisteCritereAnalyse = selectionlisteCritereAnalyse;
	}


	public List<VCritereAnalyseDac> getListeCritereSaisie() {
		return listeCritereSaisie;
	}

	public void setListeCritereSaisie(List<VCritereAnalyseDac> listeCritereSaisie) {
		this.listeCritereSaisie = listeCritereSaisie;
	}

	public VDacMembre getSelecMembre() {
		return selecMembre;
	}

	public void setSelecMembre(VDacMembre selecMembre) {
		this.selecMembre = selecMembre;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public TSoumissions getNewSoumission() {
		return newSoumission;
	}

	public void setNewSoumission(TSoumissions newSoumission) {
		this.newSoumission = newSoumission;
	}

	public List<VDetTabBordDac> getDetailTBCpt() {
		return detailTBCpt;
	}

	public void setDetailTBCpt(List<VDetTabBordDac> detailTBCpt) {
		this.detailTBCpt = detailTBCpt;
	}

	public VbCritereAnalyse getNewEnteteCritere() {
		return newEnteteCritere;
	}

	public void setNewEnteteCritere(VbCritereAnalyse newEnteteCritere) {
		this.newEnteteCritere = newEnteteCritere;
	}

	public List<VCritAnalDacEntete> getListeEnteteCritere() {
		return listeEnteteCritere;
	}

	public void setListeEnteteCritere(List<VCritAnalDacEntete> listeEnteteCritere) {
		this.listeEnteteCritere = listeEnteteCritere;
	}

	public long getTotalMontantEstimatif() {
		return totalMontantEstimatif;
	}

	public void setTotalMontantEstimatif(long totalMontantEstimatif) {
		this.totalMontantEstimatif = totalMontantEstimatif;
	}

	public List<VTypePieceOffreSg> getListePiecesOffres() {
		return listePiecesOffres;
	}

	public void setListePiecesOffres(List<VTypePieceOffreSg> listePiecesOffres) {
		this.listePiecesOffres = listePiecesOffres;
	}

	public List<VTypePieceOffreSg> getListeSelectionPiecesOffres() {
		return listeSelectionPiecesOffres;
	}

	public void setListeSelectionPiecesOffres(List<VTypePieceOffreSg> listeSelectionPiecesOffres) {
		this.listeSelectionPiecesOffres = listeSelectionPiecesOffres;
	}

	public long getLaaId() {
		return laaId;
	}

	public void setLaaId(long laaId) {
		this.laaId = laaId;
	}

	public VCritereAnalyseDac getSltCritereDac() {
		return sltCritereDac;
	}

	public void setSltCritereDac(VCritereAnalyseDac sltCritereDac) {
		this.sltCritereDac = sltCritereDac;
	}

	public List<VbDetCritAnalyseDac> getListDetCritereDac() {
		return listDetCritereDac;
	}

	public void setListDetCritereDac(List<VbDetCritAnalyseDac> listDetCritereDac) {
		this.listDetCritereDac = listDetCritereDac;
	}

	public long getTotalMontantCaution() {
		return totalMontantCaution;
	}

	public void setTotalMontantCaution(long totalMontantCaution) {
		this.totalMontantCaution = totalMontantCaution;
	}

	public String getPieceCode() {
		return pieceCode;
	}

	public void setPieceCode(String pieceCode) {
		this.pieceCode = pieceCode;
	}

	public long getDelai() {
		return delai;
	}

	public void setDelai(long delai) {
		this.delai = delai;
	}

	public VCritAnalDacEntete getNewEnteteCrit() {
		return newEnteteCrit;
	}

	public void setNewEnteteCrit(VCritAnalDacEntete newEnteteCrit) {
		this.newEnteteCrit = newEnteteCrit;
	}

	public long getDcadNum() {
		return dcadNum;
	}

	public void setDcadNum(long dcadNum) {
		this.dcadNum = dcadNum;
	}

	public long getrId() {
		return rId;
	}

	public void setrId(long rId) {
		this.rId = rId;
	}

	/*public List<VCritereAnalyseDac> getListeCritereByLot() {
		return listeCritereByLot;
	}

	public void setListeCritereByLot(List<VCritereAnalyseDac> listeCritereByLot) {
		this.listeCritereByLot = listeCritereByLot;
	}*/

	public List<VDacliste> getDetailDac() {
		return detailDac;
	}

	public void setDetailDac(List<VDacliste> detailDac) {
		this.detailDac = detailDac;
	}

	public List<VDacliste> getDetailTrans() {
		return detailTrans;
	}

	public void setDetailTrans(List<VDacliste> detailTrans) {
		this.detailTrans = detailTrans;
	}

	public List<VDacliste> getDetailDacDiff() {
		return detailDacDiff;
	}

	public void setDetailDacDiff(List<VDacliste> detailDacDiff) {
		this.detailDacDiff = detailDacDiff;
	}

	public List<VCritereAnalyseDac> getListeCritereByLot() {
		return listeCritereByLot;
	}

	public void setListeCritereByLot(List<VCritereAnalyseDac> listeCritereByLot) {
		this.listeCritereByLot = listeCritereByLot;
	}

	/*public List<VCritereAnalyseDacLot> getListeCritereByLot() {
		return listeCritereByLot;
	}

	public void setListeCritereByLot(List<VCritereAnalyseDacLot> listeCritereByLot) {
		this.listeCritereByLot = listeCritereByLot;
	}*/
		
	public long getTotalNbreVente() {
		return totalNbreVente;
	}

	public void setTotalNbreVente(long totalNbreVente) {
		this.totalNbreVente = totalNbreVente;
	}

	public TDetCritAnalyseDac getDetCritere() {
		return detCritere;
	}

	public void setDetCritere(TDetCritAnalyseDac detCritere) {
		this.detCritere = detCritere;
	}

	public List<TCommissionSpecifique> getListeCom() {
		return listeCom;
	}

	public void setListeCom(List<TCommissionSpecifique> listeCom) {
		this.listeCom = listeCom;
	}

	public TCommissionSpecifique getDetailCom() {
		return detailCom;
	}

	public void setDetailCom(TCommissionSpecifique detailCom) {
		this.detailCom = detailCom;
	}

	public String getTypeCommission() {
		return typeCommission;
	}

	public void setTypeCommission(String typeCommission) {
		this.typeCommission = typeCommission;
	}

	public boolean isComNormale() {
		return comNormale;
	}

	public void setComNormale(boolean comNormale) {
		this.comNormale = comNormale;
	}

	public boolean isComSpeciale() {
		return comSpeciale;
	}

	public void setComSpeciale(boolean comSpeciale) {
		this.comSpeciale = comSpeciale;
	}

	public List<VCommissionSpeciale> getListeMbrCommissionSpeciale() {
		return listeMbrCommissionSpeciale;
	}

	public void setListeMbrCommissionSpeciale(List<VCommissionSpeciale> listeMbrCommissionSpeciale) {
		this.listeMbrCommissionSpeciale = listeMbrCommissionSpeciale;
	}

	public List<VCommissionSpeciale> getSelectionMbrCommissionSpeciale() {
		return selectionMbrCommissionSpeciale;
	}

	public void setSelectionMbrCommissionSpeciale(List<VCommissionSpeciale> selectionMbrCommissionSpeciale) {
		this.selectionMbrCommissionSpeciale = selectionMbrCommissionSpeciale;
	}


	public List<VCommissionSpecifique> getListeMembre() {
		return listeMembre;
	}

	public void setListeMembre(List<VCommissionSpecifique> listeMembre) {
		this.listeMembre = listeMembre;
	}

	public List<VCommissionSpecifique> getListeMembreComSpec() {
		return listeMembreComSpec;
	}

	public void setListeMembreComSpec(List<VCommissionSpecifique> listeMembreComSpec) {
		this.listeMembreComSpec = listeMembreComSpec;
	}

	public boolean isEtatPays() {
		return etatPays;
	}

	public void setEtatPays(boolean etatPays) {
		this.etatPays = etatPays;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public boolean isComAutorise() {
		return comAutorise;
	}

	public void setComAutorise(boolean comAutorise) {
		this.comAutorise = comAutorise;
	}

	public String getCodeAutorisation() {
		return codeAutorisation;
	}

	public void setCodeAutorisation(String codeAutorisation) {
		this.codeAutorisation = codeAutorisation;
	}

	public boolean isComboboxCom() {
		return comboboxCom;
	}

	public void setComboboxCom(boolean comboboxCom) {
		this.comboboxCom = comboboxCom;
	}

	public boolean isNorm() {
		return norm;
	}

	public void setNorm(boolean norm) {
		this.norm = norm;
	}

	public boolean isSpec() {
		return spec;
	}

	public void setSpec(boolean spec) {
		this.spec = spec;
	}

	public List<VMargeDePreference> getListeMarge() {
		return listeMarge;
	}

	public void setListeMarge(List<VMargeDePreference> listeMarge) {
		this.listeMarge = listeMarge;
	}

	public VMargeDePreference getMarge() {
		return marge;
	}

	public void setMarge(VMargeDePreference marge) {
		this.marge = marge;
	}

	public boolean isPanelNcc1() {
		return panelNcc1;
	}

	public void setPanelNcc1(boolean panelNcc1) {
		this.panelNcc1 = panelNcc1;
	}

	public boolean isPanelNcc2() {
		return panelNcc2;
	}

	public void setPanelNcc2(boolean panelNcc2) {
		this.panelNcc2 = panelNcc2;
	}

	public boolean isConfirmInter() {
		return confirmInter;
	}

	public void setConfirmInter(boolean confirmInter) {
		this.confirmInter = confirmInter;
	}

	public String getImputation() {
		return imputation;
	}

	public void setImputation(String imputation) {
		this.imputation = imputation;
	}

	public VDacliste getCaution() {
		return caution;
	}

	public void setCaution(VDacliste caution) {
		this.caution = caution;
	}

	public double getCautionMin() {
		return cautionMin;
	}

	public void setCautionMin(double cautionMin) {
		this.cautionMin = cautionMin;
	}

	public double getCautionMax() {
		return cautionMax;
	}

	public void setCautionMax(double cautionMax) {
		this.cautionMax = cautionMax;
	}

	public double getMontantCaution() {
		return montantCaution;
	}

	public void setMontantCaution(double montantCaution) {
		this.montantCaution = montantCaution;
	}

	public long getCautionMinRound() {
		return cautionMinRound;
	}

	public void setCautionMinRound(long cautionMinRound) {
		this.cautionMinRound = cautionMinRound;
	}

	public long getCautionMaxRound() {
		return cautionMaxRound;
	}

	public void setCautionMaxRound(long cautionMaxRound) {
		this.cautionMaxRound = cautionMaxRound;
	}

	public boolean isPanelCaution() {
		return panelCaution;
	}

	public void setPanelCaution(boolean panelCaution) {
		this.panelCaution = panelCaution;
	}

	public List<VDacliste> getDacVente() {
		return dacVente;
	}

	public void setDacVente(List<VDacliste> dacVente) {
		this.dacVente = dacVente;
	}

	public VDacliste getRecupCout() {
		return recupCout;
	}

	public void setRecupCout(VDacliste recupCout) {
		this.recupCout = recupCout;
	}

	public List<VbCommissionSpecifique> getListeComSpecifique() {
		return listeComSpecifique;
	}

	public void setListeComSpecifique(List<VbCommissionSpecifique> listeComSpecifique) {
		this.listeComSpecifique = listeComSpecifique;
	}

	public VbCommissionSpecifique getComSpec() {
		return comSpec;
	}

	public void setComSpec(VbCommissionSpecifique comSpec) {
		this.comSpec = comSpec;
	}

	public List<TCommissionSpecifique> getListeComSpecific() {
		return listeComSpecific;
	}

	public void setListeComSpecific(List<TCommissionSpecifique> listeComSpecific) {
		this.listeComSpecific = listeComSpecific;
	}

	public TCommissionSpecifique getComSpecUpdate() {
		return comSpecUpdate;
	}

	public void setComSpecUpdate(TCommissionSpecifique comSpecUpdate) {
		this.comSpecUpdate = comSpecUpdate;
	}

	public List<VDacVendu> getListeDetailVente() {
		return listeDetailVente;
	}

	public void setListeDetailVente(List<VDacVendu> listeDetailVente) {
		this.listeDetailVente = listeDetailVente;
	}

	public VDacVendu getDetailVente() {
		return detailVente;
	}

	public void setDetailVente(VDacVendu detailVente) {
		this.detailVente = detailVente;
	}

	public List<TDetCritAnalyseDac> getListDetcritere() {
		return listDetcritere;
	}

	public void setListDetcritere(List<TDetCritAnalyseDac> listDetcritere) {
		this.listDetcritere = listDetcritere;
	}


	public VbTempCritere getNewTempCritereDac() {
		return newTempCritereDac;
	}

	public void setNewTempCritereDac(VbTempCritere newTempCritereDac) {
		this.newTempCritereDac = newTempCritereDac;
	}

	public VbTempParamDetCri getNewTempCritere() {
		return newTempCritere;
	}

	public void setNewTempCritere(VbTempParamDetCri newTempCritere) {
		this.newTempCritere = newTempCritere;
	}

	public VbTempCritere getNewTempEnteteCrit() {
		return newTempEnteteCrit;
	}

	public void setNewTempEnteteCrit(VbTempCritere newTempEnteteCrit) {
		this.newTempEnteteCrit = newTempEnteteCrit;
	}

	public String getChoixCritere() {
		return choixCritere;
	}

	public void setChoixCritere(String choixCritere) {
		this.choixCritere = choixCritere;
	}

	public boolean isPanelNouveau() {
		return panelNouveau;
	}

	public void setPanelNouveau(boolean panelNouveau) {
		this.panelNouveau = panelNouveau;
	}

	public boolean isPanelExixstent() {
		return panelExixstent;
	}

	public void setPanelExixstent(boolean panelExixstent) {
		this.panelExixstent = panelExixstent;
	}

	public List<VCritAnalDacSousentete> getListeSousEnteteCritere() {
		return listeSousEnteteCritere;
	}

	public void setListeSousEnteteCritere(List<VCritAnalDacSousentete> listeSousEnteteCritere) {
		this.listeSousEnteteCritere = listeSousEnteteCritere;
	}

	public long getrIdSous() {
		return rIdSous;
	}

	public void setrIdSous(long rIdSous) {
		this.rIdSous = rIdSous;
	}

	public VCritAnalDacSousentete getNewSousEnteteCrit() {
		return newSousEnteteCrit;
	}

	public void setNewSousEnteteCrit(VCritAnalDacSousentete newSousEnteteCrit) {
		this.newSousEnteteCrit = newSousEnteteCrit;
	}

	public VbTempParametreFact getNewTempFactorise() {
		return newTempFactorise;
	}

	public void setNewTempFactorise(VbTempParametreFact newTempFactorise) {
		this.newTempFactorise = newTempFactorise;
	}

	public List<VLotCritere> getListeLotCritere() {
		return listeLotCritere;
	}

	public void setListeLotCritere(List<VLotCritere> listeLotCritere) {
		this.listeLotCritere = listeLotCritere;
	}

	public List<VLotCritere> getListeLotConsultation() {
		return listeLotConsultation;
	}

	public void setListeLotConsultation(List<VLotCritere> listeLotConsultation) {
		this.listeLotConsultation = listeLotConsultation;
	}

	public VbTempParamTabBord getTempBord() {
		return tempBord;
	}

	public void setTempBord(VbTempParamTabBord tempBord) {
		this.tempBord = tempBord;
	}

	public VLotCritere getLotCrit() {
		return lotCrit;
	}

	public void setLotCrit(VLotCritere lotCrit) {
		this.lotCrit = lotCrit;
	}

	public List<VArticlesCom> getListeArticle() {
		return listeArticle;
	}

	public void setListeArticle(List<VArticlesCom> listeArticle) {
		this.listeArticle = listeArticle;
	}

	public TAvisAppelOffre getSltAvis() {
		return sltAvis;
	}

	public void setSltAvis(TAvisAppelOffre sltAvis) {
		this.sltAvis = sltAvis;
	}

	public List<TAvisAppelOffre> getListeAvis() {
		return listeAvis;
	}

	public void setListeAvis(List<TAvisAppelOffre> listeAvis) {
		this.listeAvis = listeAvis;
	}

	public boolean isPanelCritereLot() {
		return panelCritereLot;
	}

	public void setPanelCritereLot(boolean panelCritereLot) {
		this.panelCritereLot = panelCritereLot;
	}

	public boolean isPanelMessage() {
		return panelMessage;
	}

	public void setPanelMessage(boolean panelMessage) {
		this.panelMessage = panelMessage;
	}

	public String getCritere() {
		return critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}

	public boolean isDaoCritere() {
		return daoCritere;
	}

	public void setDaoCritere(boolean daoCritere) {
		this.daoCritere = daoCritere;
	}

	public VCritereAnalyseModel getCritereObject() {
		return critereObject;
	}

	public void setCritereObject(VCritereAnalyseModel critereObject) {
		this.critereObject = critereObject;
	}

	public List<TLotAao> getListeLot() {
		return listeLot;
	}

	public void setListeLot(List<TLotAao> listeLot) {
		this.listeLot = listeLot;
	}

	public TLotAao getLots() {
		return lots;
	}

	public void setLots(TLotAao lots) {
		this.lots = lots;
	}

	public VbTempParametreFactSup getNewTempFactSup() {
		return newTempFactSup;
	}

	public void setNewTempFactSup(VbTempParametreFactSup newTempFactSup) {
		this.newTempFactSup = newTempFactSup;
	}

	public List<VMargeDePreferenceSou> getListeMargeSou() {
		return listeMargeSou;
	}

	public void setListeMargeSou(List<VMargeDePreferenceSou> listeMargeSou) {
		this.listeMargeSou = listeMargeSou;
	}

	public List<VMargeDePreferenceCom> getListeMargeCom() {
		return listeMargeCom;
	}

	public void setListeMargeCom(List<VMargeDePreferenceCom> listeMargeCom) {
		this.listeMargeCom = listeMargeCom;
	}

	public List<VMargeDePreferenceArt> getListeMargeArt() {
		return listeMargeArt;
	}

	public void setListeMargeArt(List<VMargeDePreferenceArt> listeMargeArt) {
		this.listeMargeArt = listeMargeArt;
	}

	public VMargeDePreferenceSou getMargeSou() {
		return margeSou;
	}

	public void setMargeSou(VMargeDePreferenceSou margeSou) {
		this.margeSou = margeSou;
	}

	public VMargeDePreferenceCom getMargeCom() {
		return margeCom;
	}

	public void setMargeCom(VMargeDePreferenceCom margeCom) {
		this.margeCom = margeCom;
	}

	public VMargeDePreferenceArt getMargeArt() {
		return margeArt;
	}

	public void setMargeArt(VMargeDePreferenceArt margeArt) {
		this.margeArt = margeArt;
	}

	public boolean isEtatMargeA() {
		return etatMargeA;
	}

	public void setEtatMargeA(boolean etatMargeA) {
		this.etatMargeA = etatMargeA;
	}

	public boolean isEtatMargeC() {
		return etatMargeC;
	}

	public void setEtatMargeC(boolean etatMargeC) {
		this.etatMargeC = etatMargeC;
	}

	public boolean isEtatMargeS() {
		return etatMargeS;
	}

	public void setEtatMargeS(boolean etatMargeS) {
		this.etatMargeS = etatMargeS;
	}

	public boolean isEtatMargePreference() {
		return etatMargePreference;
	}

	public void setEtatMargePreference(boolean etatMargePreference) {
		this.etatMargePreference = etatMargePreference;
	}

	public String getMargePref() {
		return margePref;
	}

	public void setMargePref(String margePref) {
		this.margePref = margePref;
	}

	public List<VMargeDePreference> getListMarge() {
		return listMarge;
	}

	public void setListMarge(List<VMargeDePreference> listMarge) {
		this.listMarge = listMarge;
	}

	public VMargeDePreference getSltMarge() {
		return sltMarge;
	}

	public void setSltMarge(VMargeDePreference sltMarge) {
		this.sltMarge = sltMarge;
	}

	public VPieces getSltPiece() {
		return sltPiece;
	}

	public void setSltPiece(VPieces sltPiece) {
		this.sltPiece = sltPiece;
	}

	public VFonctionImputation getSltImput() {
		return sltImput;
	}

	public void setSltImput(VFonctionImputation sltImput) {
		this.sltImput = sltImput;
	}

	public List<TSeances> getListSeances() {
		return listSeances;
	}

	public void setListSeances(List<TSeances> listSeances) {
		this.listSeances = listSeances;
	}

	public TSeances getSltSeances() {
		return sltSeances;
	}

	public void setSltSeances(TSeances sltSeances) {
		this.sltSeances = sltSeances;
	}

	public TLotAao getSltLot() {
		return sltLot;
	}

	public void setSltLot(TLotAao sltLot) {
		this.sltLot = sltLot;
	}

	public boolean isClean() {
		return clean;
	}

	public void setClean(boolean clean) {
		this.clean = clean;
	}
	
	
	
	
	
	
	
	
	 /*******  document  *************/
	 private XWPFDocument document = null;
	 private String DAO_CARBURANT_LEGER = "DAO Carburant allege.docx";
	 private String DAO_RESTAURATION = "DAO RESTAURATION.docx";
	 private String DAO_ENTRETIEN_LOCAUX_ESPACE_VERT = "dao_ entretien_ des_locaux.docx";
	 private String DAO_GESTION_MAIN_OEUVRE_OCCASIONNELLE = "dao_ gestion_de_main_doeuvre_occasionnelle.docx";
	 private String DAO_LOCATION_MAIN_OEUVRE = "dao_location_main_doeuvre.docx";
	 private String DAO_SECURITE_PRIVEE = "dao_securite_privee.docx";
	 private String DAO_FOURNITURES_SERVICES_CONNEXES = "DAO_Fournitures_et_services_connexes.docx";
	 private String DAO_TRAVAUX = "dtao_travaux.docx";
	 private String DAO_PRESTATIONS = "dtao_prestation.docx";
	 private String PATHNAME = "C:/wildfly-8.2.1.Final/standalone/Dossiers/Fichiers/";
	 
	 private String DOWNLOAD_PATHNAME = "";
	 private String DOWNLOAD_FILENAME ="";
	 
	 
	 // methode pour charger le document du disque dur
	 public XWPFDocument getDocument() {
		return document;
	}

	 public void setDocument(XWPFDocument document) {
		this.document = document;
	 }

	 public void chargeDaoFichier() throws FileNotFoundException, IOException {
		 switch(daoIter.getTymCode()) {
			 case "0": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_FOURNITURES_SERVICES_CONNEXES))));
			 break;
			 
			 case "00": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_FOURNITURES_SERVICES_CONNEXES))));
			 break;
			 
			 case "1": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_PRESTATIONS))));
			 break;
			 
			 case "10": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_PRESTATIONS))));
			 break;
			 
			 case "2": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_TRAVAUX))));
			 break;
			 
			 case "20": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_TRAVAUX))));
			 break;
			 
			 case "05": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_CARBURANT_LEGER ))));
			 break;
			 
			 case "16": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_RESTAURATION))));
			 break;
			 
			 case "15": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_LOCATION_MAIN_OEUVRE))));
			 break;
			 
			 case "19": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_GESTION_MAIN_OEUVRE_OCCASIONNELLE))));
			 break;
			 
			 case "14": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_SECURITE_PRIVEE))));
			 break;
			 
			 case "13": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_ENTRETIEN_LOCAUX_ESPACE_VERT))));
			 break;
		}
	 }

	 
	 //POUR WINDOWS
	 /*public void chargeDaoFile() throws IOException {		 
		 
		 if(daoIter.getTymCode().equals("23") ||  daoIter.getTymCode().equals("21") || daoIter.getTymCode().equals("22") ||
					daoIter.getTymCode().equals("26") || daoIter.getTymCode().equals("25") ) {
					 setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX))));
					 _logger.info("DAO TRAVAUX ROUTES ELECTRICITE chargé");
					}
		 
		 if(daoIter.getTymCode().equals("01") || daoIter.getTymCode().equals("02") || daoIter.getTymCode().equals("03") ||
					daoIter.getTymCode().equals("04") || daoIter.getTymCode().equals("06") || daoIter.getTymCode().equals("07") ||
					daoIter.getTymCode().equals("08") || daoIter.getTymCode().equals("09") || daoIter.getTymCode().equals("0A")) {
						setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES))));
						_logger.info("DAO FOURNITURE chargé");
					}
		 
		 switch(daoIter.getTymCode()) {
			 // FOURNITURE	;
		 case "0": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES))));
			 _logger.info("DAO FOURNITURE chargé");
			 _logger.info(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES);
			 break;
			 
			 // FOURNITURE	
			 case "00": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES))));
			 _logger.info("DAO FOURNITURE chargé");
			 break;
			 
			// PRESTATIONS	
			 case "1": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATION))));
			 _logger.info("DAO PRESTATIONS chargé");
			 break;
			 
			// PRESTATIONS	
			 case "10": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATION))));
			 _logger.info("DAO PRESTATIONS chargé");
			 break;
			 
			// TRAVAUX	
			 case "2": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX))));
			 _logger.info("DAO TRAVAUX chargé");
			 break;
			 
			// TRAVAUX	
			 case "20": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX))));
			 _logger.info("DAO TRAVAUX chargé");
			 break;
			 
			 // FOURNITURE DE CARBURANT LEGER
			 case "05": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_CARBURANT_LEGER))));
			 _logger.info("DAO FOURNITURE DE CARBURANT chargé");
			 break;
			 
			 // DAO RESTAURATION
			 case "16" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_RESTAURATIONS))));
			 _logger.info("DAO RESTAURATION chargé");
			 break;
			 
			 // DAO LOCATION DE MAIN D'OEUVRE - (Services courants)
			 case "15" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES))));
			 _logger.info("DAO LOCATION DE MAIN D'OEUVRE chargé");
			 break;
			 
			// DAO GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
			 case "19" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES))));
			 _logger.info("DAO GESTION DE MAIN D'OEUVRE OCCASIONNELLE chargé");
			 break;
			 
			// DAO SECURITE PRIVEE ou GARDIENNAGE - (Services courants)
			 case "14" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_SECURITE_PRIVEE))));
			 _logger.info("DAO SECURITE PRIVEE ou GARDIENNAGE chargé");
			 break;
			 
			// DAO ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
			 case "13" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX))));
			 _logger.info("DAO ENTRETIENS ESPACES VERTS ET LOCAUX chargé");
			 break;
		 }
	 }
	 */
	 
	 
	 //POUR LINUX
	 public void chargeDaoFile() throws IOException {		 
		 switch(daoIter.getTymCode()) {
			 // FOURNITURE	;
		 case "0": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES_LINUX))));
			 _logger.info("DAO FOURNITURE chargé");
			 _logger.info(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES);
			 break;
			 
			 // FOURNITURE	
			 case "00": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES_LINUX))));
			 _logger.info("DAO FOURNITURE chargé");
			 break;
			 
			// PRESTATIONS	
			 case "1": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATIONS_LINUX))));
			 _logger.info("DAO PRESTATIONS chargé");
			 break;
			 
			// PRESTATIONS	
			 case "10": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATIONS_LINUX))));
			 _logger.info("DAO PRESTATIONS chargé");
			 break;
			 
			// TRAVAUX	
			 case "2": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX_LINUX))));
			 _logger.info("DAO TRAVAUX chargé");
			 break;
			 
			// TRAVAUX	
			 case "20": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX_LINUX))));
			 _logger.info("DAO TRAVAUX chargé");
			 break;
			 
			 // FOURNITURE DE CARBURANT LEGER
			 case "05": setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_CARBURANT_LEGER_LINUX))));
			 _logger.info("DAO FOURNITURE DE CARBURANT chargé");
			 break;
			 
			 // DAO RESTAURATION
			 case "16" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_RESTAURATIONS_LINUX))));
			 _logger.info("DAO RESTAURATION chargé");
			 break;
			 
			 // DAO LOCATION DE MAIN D'OEUVRE - (Services courants)
			 case "15" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES))));
			 _logger.info("DAO LOCATION DE MAIN D'OEUVRE chargé");
			 break;
			 
			// DAO GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
			 case "19" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES_LINUX))));
			 _logger.info("DAO GESTION DE MAIN D'OEUVRE OCCASIONNELLE chargé");
			 break;
			 
			// DAO SECURITE PRIVEE ou GARDIENNAGE - (Services courants)
			 case "14" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_SECURITE_PRIVEE_LINUX))));
			 _logger.info("DAO SECURITE PRIVEE ou GARDIENNAGE chargé");
			 break;
			 
			// DAO ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
			 case "13" : setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX))));
			 _logger.info("DAO ENTRETIENS ESPACES VERTS ET LOCAUX chargé");
			 break;
		 }
	 }
	
	 // methode pour enregistrer le document apres avoir insérer les bookmarks
	 
	 //WINDOWS
	 /* public void saveDaoFile() throws IOException {
		 
		 if (daoIter.getTymCode().equals("26") || daoIter.getTymCode().equals("21") ||
			daoIter.getTymCode().equals("22") || daoIter.getTymCode().equals("23")|| daoIter.getTymCode().equals("25")) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;;
		 	}
				 
		if(daoIter.getTymCode().equals("01") || daoIter.getTymCode().equals("02") || daoIter.getTymCode().equals("03") ||
			daoIter.getTymCode().equals("04") || daoIter.getTymCode().equals("06") || daoIter.getTymCode().equals("07") ||
			daoIter.getTymCode().equals("08") || daoIter.getTymCode().equals("09") || daoIter.getTymCode().equals("0A")) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
			}
		 
		 switch(daoIter.getTymCode()) {		 
			// TRAVAUX				
			 case "2": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
			 break;			 
			 case "20": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
			 break;
			 
			// PRESTATIONS
			 case "1": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;  
			 break;
			 case "10": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;
			 break;
			 
			// FOURNITURE
			 case "0": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
			 break;
			 case "00": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
			 break;
			
			// FOURNITURE DE CARBURANT LEGER
			 case "05": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER;   
			 break;
			 
			// DAO RESTAURATION
			 case "16": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATIONS;   
			 break;
			 
			// LOCATION DE MAIN D'OEUVRE - (Services courants)
			 case "15": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES;
			 break;
			 
			// GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
			 case "19": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SERVICES_COURANT;
			 break;
			 
			// SECURITE PRIVEE ou GARDIENNAGE
			 case "14": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE;
			 break;
			 
			// // ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
			 case "13": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX;
			 break;
		 }
		 _logger.info("path: "+DOWNLOAD_PATHNAME);
		 DOWNLOAD_FILENAME = dao.getDacObjet() +"_" + dao.getDacCode()+ ".docx";
		 getDocument().write(new FileOutputStream(new File(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME )));
	 }*/
	 
	//LINUX
		 public void saveDaoFile() throws IOException {
			 switch(daoIter.getTymCode()) {		 
				// TRAVAUX				
				 case "2": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX;
				 break;			 
				 case "20": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX;
				 break;
				 
				// PRESTATIONS
				 case "1": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX;  
				 break;
				 case "10": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX;
				 break;
				 
				 
				// FOURNITURE
				 case "0": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX;
				 break;
				 case "00": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX;
				 break;
				
				// FOURNITURE DE CARBURANT LEGER
				 case "05": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX;   
				 break;
				 
				// DAO RESTAURATION
				 case "16": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATION_LINUX;   
				 break;
				 
				// LOCATION DE MAIN D'OEUVRE - (Services courants)
				 case "15": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_LINUX;
				 break;
				 
				// GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
				 case "19": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRE_LINUX;
				 break;
				 
				// SECURITE PRIVEE ou GARDIENNAGE
				 case "14": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE_LINUX;
				 break;
				 
				// // ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
				 case "13": DOWNLOAD_PATHNAME =  ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX;
				 break;
			 }
			 _logger.info("path: "+DOWNLOAD_PATHNAME);
			 DOWNLOAD_FILENAME = dao.getDacObjet() +"_" + dao.getDacCode()+ ".docx";
			 getDocument().write(new FileOutputStream(new File(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME )));
		 }
	
	 private List<XWPFParagraph> collectParagraphs() {
		 List<XWPFParagraph> paragraphs = new ArrayList<>();
		 paragraphs.addAll(getDocument().getParagraphs());
		
		 for(XWPFTable table:getDocument().getTables()) {
			 for(XWPFTableRow row:table.getRows()) {
				for(XWPFTableCell cell:row.getTableCells()) {
					paragraphs.addAll(cell.getParagraphs());
				}
			 }
		 }
		 return paragraphs;		
	 }
	
	 public List<String> getBookmarkNames(){
		List<String> bookmarkNames = new ArrayList<>();
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		
		paraIter = collectParagraphs().iterator();
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				bookmarkNames.add(bookmark.getName());
			}
		}
		return bookmarkNames;
	}
	
	public Node getBookmarkNode(String bookmarkName) {
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		Node node = null;
		
		paraIter = collectParagraphs().iterator();
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(bookmarkName)) {
					node = bookmark.getDomNode();
				}
			}
		}
		return node;
	}
	
	public Node getBookmarkParentNode(String bookmarkName) {
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		Node node = null;
		
		paraIter = collectParagraphs().iterator();
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(bookmarkName)) {
					node = para.getCTP().getDomNode();
				}
			}
		}
		return node;
	}

	private void procParaList(List<XWPFParagraph> paraList, String bookmarkName,
			String bookmarkValue) {
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		XWPFRun run = null;
		Node nextNode = null;
		
		paraIter = paraList.iterator();
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(bookmarkName)) {
					run = para.createRun();
					run.setBold(true);
					run.setColor("0000FF");
					run.setText(bookmarkValue);
					nextNode = bookmark.getDomNode().getNextSibling();
					while(!(nextNode.getNodeName().contains("bookmarkEnd"))) {
						para.getCTP().getDomNode().removeChild(nextNode);
						nextNode = bookmark.getDomNode().getNextSibling();
					}
					para.getCTP().getDomNode().insertBefore(
							run.getCTR().getDomNode(), nextNode);
				}
			}
		}
	}
	
	private void replaceBookmarkByValue(String bookmarkName, String bookmarkValue) {
		List<XWPFTable> tableList = null;
		Iterator<XWPFTable> tableIter = null;
		List<XWPFTableRow> rowList = null;
		Iterator<XWPFTableRow> rowIter = null;
		List<XWPFTableCell> cellList = null;
		Iterator<XWPFTableCell> cellIter = null;
		XWPFTable table = null;
		XWPFTableRow row = null;
		XWPFTableCell cell = null;
		
		this.procParaList(getDocument().getParagraphs(), bookmarkName, bookmarkValue);

		tableList = this.document.getTables();
		tableIter = tableList.iterator();
		while(tableIter.hasNext()) {
			table = tableIter.next();
			rowList = table.getRows();
			rowIter = rowList.iterator();
			while(rowIter.hasNext()) {
				row = rowIter.next();
				cellList = row.getTableCells();
				cellIter = cellList.iterator();
				while(cellIter.hasNext()) {
					cell = cellIter.next();
					this.procParaList(cell.getParagraphs(), 
							bookmarkName, bookmarkValue);
				}
			}
		}
	}
	
	public XWPFTable enteteTableLots(String bookmarkName) {
		XWPFTable table = getDocument().createTable(1, 4);
		table.getRow(0).getCell(0).setText("NÂ°");
		table.getRow(0).getCell(1).setText("LIBELLE");
		table.getRow(0).getCell(2).setText("DELAI D'EXECUTION");
		table.getRow(0).getCell(3).setText("CAUTIONNEMENT PROVISOIRE");
		return table;
	}
	
	public void getInfoDao() {
		infoDao = (ArrayList<VdDao>) iservice.getObjectsByColumn("VdDao", new WhereClause("DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoDao.isEmpty()) {
			daoIter = infoDao.get(0);
			_logger.info("Infos DAO chargées");
			_logger.info(daoIter.getDacObjet());
			_logger.info(daoIter.getTymCode());
		}
	}
	
	public void getInfoAao() {
		infoAao = (ArrayList<VdAao>) iservice.getObjectsByColumn("VdAao", new WhereClause("DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoDao.isEmpty()) {
			aaoIter = infoAao.get(0);
			_logger.info("Infos AAO chargées");
			_logger.info(aaoIter.getDacCode());
			_logger.info(aaoIter.getLaaObjet());
		}
	}

	public void getInfoAdresse() {
		infoAdresse = (ArrayList<VxAdresse>) iservice.getObjectsByColumn("VxAdresse", new WhereClause("DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoAdresse.isEmpty()) {
			adresseIter = infoAdresse.get(0);
			_logger.info("Infos sur l'adresse chargées");
			_logger.info(adresseIter.getDacCode());
			_logger.info(adresseIter.getLibdetail());
		}
	}
	
	public void getInfoLots() {
		infoLots = (ArrayList<VbLotAao>) iservice.getObjectsByColumn("VbLotAao", new WhereClause("LAA_DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoLots.isEmpty()) {
			lotsIter = infoLots.get(0);
			_logger.info("Infos sur les lots chargées");
			_logger.info(lotsIter.getLaaDacCode() );
			_logger.info(lotsIter.getLaaObjet());
			
			for(int x = 0; x < infoLots.size(); x++) {				
				_logger.info(infoLots.get(x).getLaaObjet());
				//_logger.info(x.getLots());
			}
		}
	}
	
	public void getInfoCojo() {
		infoCojo = (ArrayList<VbCommissionSpecifique>) iservice.getObjectsByColumn("VbCommissionSpecifique", new WhereClause("com_dac_code", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoCojo.isEmpty()) {
			cojoIter = infoCojo.get(0);
			_logger.info("Infos sur les lots chargés");
			_logger.info(cojoIter.getComTctLibelle());
			_logger.info(cojoIter);
			
			for(int y = 0; y < infoCojo.size(); y++) {
				_logger.info(infoCojo.get(y).getComTctLibelle());
			}
		}
		
		
	}
	
	public void replaceBookmarks(List<String> bookmarkNames, VdDao daoIter, VxAdresse adresseIter, VdAao aaoIter, VbLotAao lotsIter, VbCommissionSpecifique cojoIter) {				
		//switch(String.valueOf(daoIter.getTymCode().charAt(0))) {
		if(daoIter.getTymCode().equals("01") || daoIter.getTymCode().equals("02") || daoIter.getTymCode().equals("03") ||
				daoIter.getTymCode().equals("04") || daoIter.getTymCode().equals("06") || daoIter.getTymCode().equals("07") ||
				daoIter.getTymCode().equals("08") || daoIter.getTymCode().equals("09") || daoIter.getTymCode().equals("0A")) 
				{
				_logger.info("DAO de fourniture");
				
				// PAGE DE GARDE
				if(bookmarkNames.contains("PG_min_00")) replaceBookmarkByValue("PG_min_00", daoIter.getMinLibelle().toUpperCase());
				if(bookmarkNames.contains("PG_ac_00")) replaceBookmarkByValue("PG_ac_00", daoIter.getStrLibelleLong().toUpperCase());
				if(bookmarkNames.contains("PG_anGestion01_00")) replaceBookmarkByValue("PG_anGestion01_00", String.valueOf(daoIter.getGesCode()));
				if(bookmarkNames.contains("PG_objet_00")) replaceBookmarkByValue("PG_objet_00", daoIter.getDacObjet());
				if(bookmarkNames.contains("PG_moisAnGestion_00")) {
					Calendar c = Calendar.getInstance();
					String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
					String mg = mois + "/" + daoIter.getGesCode();
					replaceBookmarkByValue("PG_moisAnGestion_00", mg);
					}
				
				// PAGE DE TITRE
				if(bookmarkNames.contains("PT_objet_00")) {
					_logger.info("le probleme est se trouve ici & le probleme est se trouve ici le probleme est se trouve ici");
				} // replaceBookmarkByValue("PT_objet_00", daoIter.getDacObjet());
				if(bookmarkNames.contains("PT_ac_00")) replaceBookmarkByValue("PT_ac_00", daoIter.getStrLibelleLong());
				
				// DPAO
				if(bookmarkNames.contains("DPAO_IC_1_1_ac_00")) replaceBookmarkByValue("DPAO_IC_1_1_ac_00", daoIter.getStrLibelleLong().toUpperCase());
				if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_00")) {
						String m = "";
						for(VbLotAao i:infoLots) {
							m = m + i.getLaaObjet()+ "\n";
						}
						replaceBookmarkByValue("DPAO_IC_1_1_table_lots_00", m);
						_logger.info(m);
					}
				//if(bookmarkNames.contains("DPAO_IC_1_2_source_financement_00")) replaceBookmarkByValue("DPAO_IC_1_2_source_financement_00", "");
				if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_00")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_00", adresseIter.getLibdetail());
				/*if(bookmarkNames.contains("DPAO_IC_7_1_clarification_responsable_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_responsable_00", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_adresse_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_adresse_00", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_boite_postale")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_boite_postale", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telephone")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telephone", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telecopie")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telecopie", "");
	*/
				if(bookmarkNames.contains("DPAO_IC_14_6_lieu_destination_00")) replaceBookmarkByValue("DPAO_IC_14_6_lieu_destination_00", "");
				
				if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_00")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_00", daoIter.getAaoDelaiVal().toString());
				if(bookmarkNames.contains("DPAO_IC_20_1_garantie_soumission_00")) replaceBookmarkByValue("DPAO_IC_20_1_garantie_soumission_00", "");
				if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_00")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_00", daoIter.getDacNbrCopieOff().toString());
				
				if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_00")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_00", adresseIter.getLibdetail());
				/*if(bookmarkNames.contains("DPAO_IC_23_1_remise_personne_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_personne_00", "");
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_adresse_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_adresse_00", "");
				
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_email_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_email_00", "");
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_boite_postale_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_boite_postale_00", "");*/
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_date_00")) { 	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_23_1_remise_date_00", date.format(daoIter.getAaoDateRecep()));
				}
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_heure_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_heure_00", daoIter.getAaoHeureRecep());
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_adresse_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_adresse_00", daoIter.getAaoLieuRecep());
				
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_date_00")) {	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_26_1_ouverture_date_00", date.format(daoIter.getAaoDteOuvTec()));
				}
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_heure_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_heure_00", daoIter.getAaoDteHeurOuv());
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_commission_00")) {
					String cojo = "";
					for(VbCommissionSpecifique i:infoCojo) {
						cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
					}
					replaceBookmarkByValue("DPAO_IC_26_1_ouverture_commission_00", cojo);
					_logger.info(cojo);
				}
				if(bookmarkNames.contains("DPAO_IC_39_1_quantite_augmente_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_augmente_00", "");
				if(bookmarkNames.contains("DPAO_IC_39_1_quantite_reduite_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_reduite_00", "");
			}
		
		if(daoIter.getTymCode().equals("01") || daoIter.getTymCode().equals("02") || daoIter.getTymCode().equals("03") ||
				daoIter.getTymCode().equals("04") || daoIter.getTymCode().equals("06") || daoIter.getTymCode().equals("07") ||
				daoIter.getTymCode().equals("08") || daoIter.getTymCode().equals("09") || daoIter.getTymCode().equals("0A")) 
				{
				_logger.info("DAO de fourniture");
				
				// PAGE DE GARDE
				if(bookmarkNames.contains("PG_min_00")) replaceBookmarkByValue("PG_min_00", daoIter.getMinLibelle().toUpperCase());
				if(bookmarkNames.contains("PG_ac_00")) replaceBookmarkByValue("PG_ac_00", daoIter.getStrLibelleLong().toUpperCase());
				if(bookmarkNames.contains("PG_anGestion01_00")) replaceBookmarkByValue("PG_anGestion01_00", String.valueOf(daoIter.getGesCode()));
				if(bookmarkNames.contains("PG_objet_00")) replaceBookmarkByValue("PG_objet_00", daoIter.getDacObjet());
				if(bookmarkNames.contains("PG_moisAnGestion_00")) {
					Calendar c = Calendar.getInstance();
					String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
					String mg = mois + "/" + daoIter.getGesCode();
					replaceBookmarkByValue("PG_moisAnGestion_00", mg);
					}
				
				// PAGE DE TITRE
				if(bookmarkNames.contains("PT_objet_00")) {
					_logger.info("le probleme est se trouve ici & le probleme est se trouve ici le probleme est se trouve ici");
				} // replaceBookmarkByValue("PT_objet_00", daoIter.getDacObjet());
				if(bookmarkNames.contains("PT_ac_00")) replaceBookmarkByValue("PT_ac_00", daoIter.getStrLibelleLong());
				
				// DPAO
				if(bookmarkNames.contains("DPAO_IC_1_1_ac_00")) replaceBookmarkByValue("DPAO_IC_1_1_ac_00", daoIter.getStrLibelleLong().toUpperCase());
				if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_00")) {
						String m = "";
						for(VbLotAao i:infoLots) {
							m = m + i.getLaaObjet()+ "\n";
						}
						replaceBookmarkByValue("DPAO_IC_1_1_table_lots_00", m);
						_logger.info(m);
					}
				//if(bookmarkNames.contains("DPAO_IC_1_2_source_financement_00")) replaceBookmarkByValue("DPAO_IC_1_2_source_financement_00", "");
				if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_00")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_00", adresseIter.getLibdetail());
				/*if(bookmarkNames.contains("DPAO_IC_7_1_clarification_responsable_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_responsable_00", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_adresse_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_adresse_00", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_boite_postale")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_boite_postale", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telephone")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telephone", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telecopie")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telecopie", "");
	*/
				if(bookmarkNames.contains("DPAO_IC_14_6_lieu_destination_00")) replaceBookmarkByValue("DPAO_IC_14_6_lieu_destination_00", "");
				
				if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_00")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_00", daoIter.getAaoDelaiVal().toString());
				if(bookmarkNames.contains("DPAO_IC_20_1_garantie_soumission_00")) replaceBookmarkByValue("DPAO_IC_20_1_garantie_soumission_00", "");
				if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_00")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_00", daoIter.getDacNbrCopieOff().toString());
				
				if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_00")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_00", adresseIter.getLibdetail());
				/*if(bookmarkNames.contains("DPAO_IC_23_1_remise_personne_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_personne_00", "");
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_adresse_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_adresse_00", "");
				
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_email_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_email_00", "");
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_boite_postale_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_boite_postale_00", "");*/
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_date_00")) { 	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_23_1_remise_date_00", date.format(daoIter.getAaoDateRecep()));
				}
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_heure_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_heure_00", daoIter.getAaoHeureRecep());
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_adresse_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_adresse_00", daoIter.getAaoLieuRecep());
				
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_date_00")) {	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_26_1_ouverture_date_00", date.format(daoIter.getAaoDteOuvTec()));
				}
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_heure_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_heure_00", daoIter.getAaoDteHeurOuv());
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_commission_00")) {
					String cojo = "";
					for(VbCommissionSpecifique i:infoCojo) {
						cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
					}
					replaceBookmarkByValue("DPAO_IC_26_1_ouverture_commission_00", cojo);
					_logger.info(cojo);
				}
				if(bookmarkNames.contains("DPAO_IC_39_1_quantite_augmente_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_augmente_00", "");
				if(bookmarkNames.contains("DPAO_IC_39_1_quantite_reduite_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_reduite_00", "");
			}
			
			if(daoIter.getTymCode().equals("23") ||  daoIter.getTymCode().equals("21") || daoIter.getTymCode().equals("22") ||
					daoIter.getTymCode().equals("26") || daoIter.getTymCode().equals("25") ) {
				// PAGE DE GARDE
							if(bookmarkNames.contains("PG_min_20")) replaceBookmarkByValue("PG_min_20", daoIter.getMinLibelle().toUpperCase());
							if(bookmarkNames.contains("PG_ac_20")) replaceBookmarkByValue("PG_ac_20", daoIter.getStrLibelleLong().toUpperCase());
							if(bookmarkNames.contains("PG_anGestion01_20")) replaceBookmarkByValue("PG_anGestion01_20", String.valueOf(daoIter.getGesCode()));
							if(bookmarkNames.contains("PG_objet_20")) replaceBookmarkByValue("PG_objet_20", daoIter.getDacObjet());
							if(bookmarkNames.contains("PG_moisAnGestion_20")) {
								Calendar c = Calendar.getInstance();
								String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
								String mg = mois + "/" + daoIter.getGesCode();
								replaceBookmarkByValue("PG_moisAnGestion_20", mg);
								}

							// PAGE DE TITRE
							if(bookmarkNames.contains("PT_objet_20")) replaceBookmarkByValue("PT_objet_20", daoIter.getDacObjet());
							if(bookmarkNames.contains("PT_ac_20")) replaceBookmarkByValue("PT_ac_20", daoIter.getStrLibelleLong());
							
							// DONNEES PARTICULIERES DE L'APPEL D'OFFRE (DPAO)
							if(bookmarkNames.contains("DPAO_IC_1_1_ac_20")) replaceBookmarkByValue("DPAO_IC_1_1_ac_20", daoIter.getStrLibelleLong().toUpperCase());
							if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_20"))
								{
									String m = "";
									for(VbLotAao i:infoLots) {
										m = m + i.getLaaObjet()+ "\n";
									}
									replaceBookmarkByValue("DPAO_IC_1_1_table_lots_20", m);
									_logger.info(m);
								}
							
				/*			if(bookmarkNames.contains("DPAO_IC_2_source_financement_20")) 
								{
									String financement = daoIter.getStrLibelleLong() + ": ligne budgetaire " + daoIter.getLaaLbgImputation();
									//financement = financement.toString();
									_logger.info(financement);
									replaceBookmarkByValue("DPAO_IC_2_source_financement_20", financement);
								}*/
							
							if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_20", adresseIter.getLibdetail());
							_logger.info("DPAO_IC_7_1_adresse_clarification_20 remplacée");
							//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_20", ""); // clarification dé¢µt
							//if(bookmarkNames.contains("DPAO_IC_7_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_7_1_boite_postale_20", "");
							//if(bookmarkNames.contains("DPAO_IC_7_1_numero_telephone_20")) replaceBookmarkByValue("DPAO_IC_7_1_numero_telephone_20", "");
							//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_electronique_20", ""); // clarification fin 
							
							/*if(bookmarkNames.contains("DPAO_IC_7_4_lieu_20")) replaceBookmarkByValue("DPAO_IC_7_4_lieu_20", ""); // pour les visites sur site debut
							if(bookmarkNames.contains("DPAO_IC_7_4_date_20")) replaceBookmarkByValue("DPAO_IC_7_4_date_20", ""); 
							if(bookmarkNames.contains("DPAO_IC_7_4_heure_20")) replaceBookmarkByValue("DPAO_IC_7_4_heure_20", ""); // pour les visites sur site fin
				*/			
							//if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", String.valueOf(daoIter.getLaaDelaiExe()));
							
							if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", daoIter.getLaaDelaiExe().toString());
							
							_logger.info("DPAO_IC_17_2_delai_execution_20 remplacée");
							if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_20")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_20", daoIter.getAaoDelaiVal().toString());
							if(bookmarkNames.contains("DPAO_IC_20_2_cautionnemant_provisoire_20")) replaceBookmarkByValue("DPAO_IC_20_2_cautionnemant_provisoire_20", aaoIter.getLaaMtCaut().toString());
							if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_20")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_20", daoIter.getDacNbrCopieOff().toString());
							
							if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_20", adresseIter.getLibdetail());
							_logger.info("DPAO_IC_23_1_adresse_remise_20 remplacée");
							
							//if(bookmarkNames.contains("DPAO_IC_23_1_personne_20")) replaceBookmarkByValue("DPAO_IC_23_1_personne_20", ""); /* remise des offres debut */
							
							/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_remise")) replaceBookmarkByValue("adresse", adresseIter.getLibdetail());*/
							
							/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_20", "");
							/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_electronique_20", "");
							/*if(bookmarkNames.contains("DPAO_IC_23_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_23_1_boite_postale_20", "");*/
							if(bookmarkNames.contains("DPAO_IC_23_1_date_20")) 
								{ 	
									SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
									replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
								}
							if(bookmarkNames.contains("DPAO_IC_23_1_heure_20")) replaceBookmarkByValue("DPAO_IC_23_1_heure_20", daoIter.getAaoHeureRecep()); // remise des offres fin
							_logger.info("DPAO_IC_23_1_heure_20 remplacée");
							
							if(bookmarkNames.contains("DPAO_IC_26_1_lieu_ouverture_20")) replaceBookmarkByValue("DPAO_IC_26_1_lieu_ouverture_20", daoIter.getAaoLieuRecep()); // ouverture des offres debut 
							if(bookmarkNames.contains("DPAO_IC_26_1_date_20")) 
								{	
									SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
									replaceBookmarkByValue("DPAO_IC_26_1_date_20", date.format(daoIter.getAaoDteOuvTec()));
								}
							if(bookmarkNames.contains("DPAO_IC_26_1_heure_20")) replaceBookmarkByValue("DPAO_IC_26_1_heure_20", daoIter.getAaoDteHeurOuv());
							if(bookmarkNames.contains("DPAO_IC_26_1_cojo_20")) {
									String cojo = "";
									for(VbCommissionSpecifique i:infoCojo) {
										cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
									}
									replaceBookmarkByValue("DPAO_IC_26_1_cojo_20", cojo);
									_logger.info(cojo);
								} // ouverture des offres fin 
						
							// FORMULAIRES DE SOUMISSION - AVIS D'APPEL D'OFFRES
							if(bookmarkNames.contains("FS_AAO_1_ac_20")) replaceBookmarkByValue("FS_AAO_1_ac_20", "");
							if(bookmarkNames.contains("FS_AAO_1_source_financement_20")) replaceBookmarkByValue("FS_AAO_1_source_financement_20", "");
							if(bookmarkNames.contains("FS_AAO_1_objet_20")) replaceBookmarkByValue("FS_AAO_1_objet_20", "");
							
							if(bookmarkNames.contains("FS_AAO_2_ac_20")) replaceBookmarkByValue("FS_AAO_2_ac_20", "");
							if(bookmarkNames.contains("FS_AAO_2_objet_20")) replaceBookmarkByValue("FS_AAO_2_objet_20", "");
							if(bookmarkNames.contains("FS_AAO_4_personne_contact_20")) replaceBookmarkByValue("FS_AAO_4_personne_contact_20", "");
							
							if(bookmarkNames.contains("FS_AAO_4_adresse_20")) replaceBookmarkByValue("FS_AAO_4_adresse_20", "");
							if(bookmarkNames.contains("FS_AAO_6_adresse_20")) replaceBookmarkByValue("FS_AAO_6_adresse_20", "");
							if(bookmarkNames.contains("FS_AAO_6_prix_DAO_20")) replaceBookmarkByValue("FS_AAO_6_prix_DAO_20", "");
							
							if(bookmarkNames.contains("FS_AAO_6_mode_paiement_20")) replaceBookmarkByValue("FS_AAO_6_mode_paiement_20", "");
							if(bookmarkNames.contains("FS_AAO_6_mode_acheminement_20")) replaceBookmarkByValue("FS_AAO_6_mode_acheminement_20", "");
							if(bookmarkNames.contains("FS_AAO_7_adresse_depot_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_depot_offre_20", "");
							
							if(bookmarkNames.contains("FS_AAO_7_date_limite_20")) replaceBookmarkByValue("FS_AAO_7_date_limite_20", "");
							if(bookmarkNames.contains("FS_AAO_7_heure_limite_20")) replaceBookmarkByValue("FS_AAO_7_heure_limite_20", "");
							if(bookmarkNames.contains("FS_AAO_7_adresse_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_ouverture_offre_20", "");
							
							if(bookmarkNames.contains("FS_AAO_7_date_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_date_ouverture_offre_20", "");
							if(bookmarkNames.contains("FS_AAO_7_heure_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_heure_ouverture_offre_20", "");
							if(bookmarkNames.contains("FS_AAO_8_cautionnemant_provisoire_20")) replaceBookmarkByValue("FS_AAO_8_cautionnemant_provisoire_20", "");
							
							if(bookmarkNames.contains("FS_AAO_8_delai_validite_20")) replaceBookmarkByValue("FS_AAO_8_delai_validite_20", "");
							if(bookmarkNames.contains("FS_AAO_9_adresse_resultat_20")) replaceBookmarkByValue("FS_AAO_9_adresse_resultat_20", "");
			}
		
		switch(daoIter.getTymCode()) {
		// TRAVAUX		
		case "2": {
			_logger.info("DAO de travaux");
			
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_20")) replaceBookmarkByValue("PG_min_20", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_20")) replaceBookmarkByValue("PG_ac_20", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_20")) replaceBookmarkByValue("PG_anGestion01_20", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_20")) replaceBookmarkByValue("PG_objet_20", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_20")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_20", mg);
				}

			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_objet_20")) replaceBookmarkByValue("PT_objet_20", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_20")) replaceBookmarkByValue("PT_ac_20", daoIter.getStrLibelleLong());
			
			// DONNEES PARTICULIERES DE L'APPEL D'OFFRE (DPAO)
			if(bookmarkNames.contains("DPAO_IC_1_1_ac_20")) replaceBookmarkByValue("DPAO_IC_1_1_ac_20", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_20"))
				{
					String m = "";
					for(VbLotAao i:infoLots) {
						m = m + i.getLaaObjet()+ "\n";
					}
					replaceBookmarkByValue("DPAO_IC_1_1_table_lots_20", m);
					_logger.info(m);
				}
			
/*			if(bookmarkNames.contains("DPAO_IC_2_source_financement_20")) 
				{
					String financement = daoIter.getStrLibelleLong() + ": ligne budgetaire " + daoIter.getLaaLbgImputation();
					//financement = financement.toString();
					_logger.info(financement);
					replaceBookmarkByValue("DPAO_IC_2_source_financement_20", financement);
				}*/
			
			if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_7_1_adresse_clarification_20 remplacé");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_20", ""); // clarification début
			//if(bookmarkNames.contains("DPAO_IC_7_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_7_1_boite_postale_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_numero_telephone_20")) replaceBookmarkByValue("DPAO_IC_7_1_numero_telephone_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_electronique_20", ""); // clarification fin 
			
			/*if(bookmarkNames.contains("DPAO_IC_7_4_lieu_20")) replaceBookmarkByValue("DPAO_IC_7_4_lieu_20", ""); // pour les visites sur site debut
			if(bookmarkNames.contains("DPAO_IC_7_4_date_20")) replaceBookmarkByValue("DPAO_IC_7_4_date_20", ""); 
			if(bookmarkNames.contains("DPAO_IC_7_4_heure_20")) replaceBookmarkByValue("DPAO_IC_7_4_heure_20", ""); // pour les visites sur site fin
*/			
			//if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", String.valueOf(daoIter.getLaaDelaiExe()));
			
			if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", daoIter.getLaaDelaiExe().toString());
			
			_logger.info("DPAO_IC_17_2_delai_execution_20 remplacé");
			if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_20")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_20", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_IC_20_2_cautionnemant_provisoire_20")) replaceBookmarkByValue("DPAO_IC_20_2_cautionnemant_provisoire_20", aaoIter.getLaaMtCaut().toString());
			if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_20")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_20", daoIter.getDacNbrCopieOff().toString());
			
			if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_23_1_adresse_remise_20 remplacé");
			
			//if(bookmarkNames.contains("DPAO_IC_23_1_personne_20")) replaceBookmarkByValue("DPAO_IC_23_1_personne_20", ""); /* remise des offres debut */
			
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_remise")) replaceBookmarkByValue("adresse", adresseIter.getLibdetail());*/
			
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_20", "");
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_electronique_20", "");
			/*if(bookmarkNames.contains("DPAO_IC_23_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_23_1_boite_postale_20", "");*/
			if(bookmarkNames.contains("DPAO_IC_23_1_date_20")) 
				{ 	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
				}
			if(bookmarkNames.contains("DPAO_IC_23_1_heure_20")) replaceBookmarkByValue("DPAO_IC_23_1_heure_20", daoIter.getAaoHeureRecep()); // remise des offres fin
			_logger.info("DPAO_IC_23_1_heure_20 remplacé");
			
			if(bookmarkNames.contains("DPAO_IC_26_1_lieu_ouverture_20")) replaceBookmarkByValue("DPAO_IC_26_1_lieu_ouverture_20", daoIter.getAaoLieuRecep()); // ouverture des offres debut 
			if(bookmarkNames.contains("DPAO_IC_26_1_date_20")) 
				{	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_26_1_date_20", date.format(daoIter.getAaoDteOuvTec()));
				}
			if(bookmarkNames.contains("DPAO_IC_26_1_heure_20")) replaceBookmarkByValue("DPAO_IC_26_1_heure_20", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DPAO_IC_26_1_cojo_20")) {
					String cojo = "";
					for(VbCommissionSpecifique i:infoCojo) {
						cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
					}
					replaceBookmarkByValue("DPAO_IC_26_1_cojo_20", cojo);
					_logger.info(cojo);
				} // ouverture des offres fin 
		
			// FORMULAIRES DE SOUMISSION - AVIS D'APPEL D'OFFRES
			if(bookmarkNames.contains("FS_AAO_1_ac_20")) replaceBookmarkByValue("FS_AAO_1_ac_20", "");
			if(bookmarkNames.contains("FS_AAO_1_source_financement_20")) replaceBookmarkByValue("FS_AAO_1_source_financement_20", "");
			if(bookmarkNames.contains("FS_AAO_1_objet_20")) replaceBookmarkByValue("FS_AAO_1_objet_20", "");
			
			if(bookmarkNames.contains("FS_AAO_2_ac_20")) replaceBookmarkByValue("FS_AAO_2_ac_20", "");
			if(bookmarkNames.contains("FS_AAO_2_objet_20")) replaceBookmarkByValue("FS_AAO_2_objet_20", "");
			if(bookmarkNames.contains("FS_AAO_4_personne_contact_20")) replaceBookmarkByValue("FS_AAO_4_personne_contact_20", "");
			
			if(bookmarkNames.contains("FS_AAO_4_adresse_20")) replaceBookmarkByValue("FS_AAO_4_adresse_20", "");
			if(bookmarkNames.contains("FS_AAO_6_adresse_20")) replaceBookmarkByValue("FS_AAO_6_adresse_20", "");
			if(bookmarkNames.contains("FS_AAO_6_prix_DAO_20")) replaceBookmarkByValue("FS_AAO_6_prix_DAO_20", "");
			
			if(bookmarkNames.contains("FS_AAO_6_mode_paiement_20")) replaceBookmarkByValue("FS_AAO_6_mode_paiement_20", "");
			if(bookmarkNames.contains("FS_AAO_6_mode_acheminement_20")) replaceBookmarkByValue("FS_AAO_6_mode_acheminement_20", "");
			if(bookmarkNames.contains("FS_AAO_7_adresse_depot_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_depot_offre_20", "");
			
			if(bookmarkNames.contains("FS_AAO_7_date_limite_20")) replaceBookmarkByValue("FS_AAO_7_date_limite_20", "");
			if(bookmarkNames.contains("FS_AAO_7_heure_limite_20")) replaceBookmarkByValue("FS_AAO_7_heure_limite_20", "");
			if(bookmarkNames.contains("FS_AAO_7_adresse_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_ouverture_offre_20", "");
			
			if(bookmarkNames.contains("FS_AAO_7_date_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_date_ouverture_offre_20", "");
			if(bookmarkNames.contains("FS_AAO_7_heure_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_heure_ouverture_offre_20", "");
			if(bookmarkNames.contains("FS_AAO_8_cautionnemant_provisoire_20")) replaceBookmarkByValue("FS_AAO_8_cautionnemant_provisoire_20", "");
			
			if(bookmarkNames.contains("FS_AAO_8_delai_validite_20")) replaceBookmarkByValue("FS_AAO_8_delai_validite_20", "");
			if(bookmarkNames.contains("FS_AAO_9_adresse_resultat_20")) replaceBookmarkByValue("FS_AAO_9_adresse_resultat_20", "");
		}
		break;
		
		case "20": {
			_logger.info("DAO de travaux");
			
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_20")) replaceBookmarkByValue("PG_min_20", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_20")) replaceBookmarkByValue("PG_ac_20", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_20")) replaceBookmarkByValue("PG_anGestion01_20", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_20")) replaceBookmarkByValue("PG_objet_20", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_20")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_20", mg);
				}

			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_objet_20")) replaceBookmarkByValue("PT_objet_20", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_20")) replaceBookmarkByValue("PT_ac_20", daoIter.getStrLibelleLong());
			
			// DONNEES PARTICULIERES DE L'APPEL D'OFFRE (DPAO)
			if(bookmarkNames.contains("DPAO_IC_1_1_ac_20")) replaceBookmarkByValue("DPAO_IC_1_1_ac_20", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_20"))
				{
					String m = "";
					for(VbLotAao i:infoLots) {
						m = m + i.getLaaObjet()+ "\n";
					}
					replaceBookmarkByValue("DPAO_IC_1_1_table_lots_20", m);
					_logger.info(m);
				}
			
/*			if(bookmarkNames.contains("DPAO_IC_2_source_financement_20")) 
				{
					String financement = daoIter.getStrLibelleLong() + ": ligne budgetaire " + daoIter.getLaaLbgImputation();
					//financement = financement.toString();
					_logger.info(financement);
					replaceBookmarkByValue("DPAO_IC_2_source_financement_20", financement);
				}*/
			
			if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_7_1_adresse_clarification_20 remplacé");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_20", ""); // clarification début
			//if(bookmarkNames.contains("DPAO_IC_7_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_7_1_boite_postale_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_numero_telephone_20")) replaceBookmarkByValue("DPAO_IC_7_1_numero_telephone_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_electronique_20", ""); // clarification fin 
			
			/*if(bookmarkNames.contains("DPAO_IC_7_4_lieu_20")) replaceBookmarkByValue("DPAO_IC_7_4_lieu_20", ""); // pour les visites sur site debut
			if(bookmarkNames.contains("DPAO_IC_7_4_date_20")) replaceBookmarkByValue("DPAO_IC_7_4_date_20", ""); 
			if(bookmarkNames.contains("DPAO_IC_7_4_heure_20")) replaceBookmarkByValue("DPAO_IC_7_4_heure_20", ""); // pour les visites sur site fin
*/			
			//if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", String.valueOf(daoIter.getLaaDelaiExe()));
			
			if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", daoIter.getLaaDelaiExe().toString());
			
			_logger.info("DPAO_IC_17_2_delai_execution_20 remplacé");
			if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_20")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_20", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_IC_20_2_cautionnemant_provisoire_20")) replaceBookmarkByValue("DPAO_IC_20_2_cautionnemant_provisoire_20", aaoIter.getLaaMtCaut().toString());
			if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_20")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_20", daoIter.getDacNbrCopieOff().toString());
			
			if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_23_1_adresse_remise_20 remplacé");
			
			//if(bookmarkNames.contains("DPAO_IC_23_1_personne_20")) replaceBookmarkByValue("DPAO_IC_23_1_personne_20", ""); /* remise des offres debut */
			
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_remise")) replaceBookmarkByValue("adresse", adresseIter.getLibdetail());*/
			
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_20", "");
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_electronique_20", "");
			/*if(bookmarkNames.contains("DPAO_IC_23_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_23_1_boite_postale_20", "");*/
			if(bookmarkNames.contains("DPAO_IC_23_1_date_20")) 
				{ 	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
				}
			if(bookmarkNames.contains("DPAO_IC_23_1_heure_20")) replaceBookmarkByValue("DPAO_IC_23_1_heure_20", daoIter.getAaoHeureRecep()); // remise des offres fin
			_logger.info("DPAO_IC_23_1_heure_20 remplacé");
			
			if(bookmarkNames.contains("DPAO_IC_26_1_lieu_ouverture_20")) replaceBookmarkByValue("DPAO_IC_26_1_lieu_ouverture_20", daoIter.getAaoLieuRecep()); // ouverture des offres debut 
			if(bookmarkNames.contains("DPAO_IC_26_1_date_20")) 
				{	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_26_1_date_20", date.format(daoIter.getAaoDteOuvTec()));
				}
			if(bookmarkNames.contains("DPAO_IC_26_1_heure_20")) replaceBookmarkByValue("DPAO_IC_26_1_heure_20", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DPAO_IC_26_1_cojo_20")) {
					String cojo = "";
					for(VbCommissionSpecifique i:infoCojo) {
						cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
					}
					replaceBookmarkByValue("DPAO_IC_26_1_cojo_20", cojo);
					_logger.info(cojo);
				} // ouverture des offres fin 
		
			// FORMULAIRES DE SOUMISSION - AVIS D'APPEL D'OFFRES
			if(bookmarkNames.contains("FS_AAO_1_ac_20")) replaceBookmarkByValue("FS_AAO_1_ac_20", "");
			if(bookmarkNames.contains("FS_AAO_1_source_financement_20")) replaceBookmarkByValue("FS_AAO_1_source_financement_20", "");
			if(bookmarkNames.contains("FS_AAO_1_objet_20")) replaceBookmarkByValue("FS_AAO_1_objet_20", "");
			
			if(bookmarkNames.contains("FS_AAO_2_ac_20")) replaceBookmarkByValue("FS_AAO_2_ac_20", "");
			if(bookmarkNames.contains("FS_AAO_2_objet_20")) replaceBookmarkByValue("FS_AAO_2_objet_20", "");
			if(bookmarkNames.contains("FS_AAO_4_personne_contact_20")) replaceBookmarkByValue("FS_AAO_4_personne_contact_20", "");
			
			if(bookmarkNames.contains("FS_AAO_4_adresse_20")) replaceBookmarkByValue("FS_AAO_4_adresse_20", "");
			if(bookmarkNames.contains("FS_AAO_6_adresse_20")) replaceBookmarkByValue("FS_AAO_6_adresse_20", "");
			if(bookmarkNames.contains("FS_AAO_6_prix_DAO_20")) replaceBookmarkByValue("FS_AAO_6_prix_DAO_20", "");
			
			if(bookmarkNames.contains("FS_AAO_6_mode_paiement_20")) replaceBookmarkByValue("FS_AAO_6_mode_paiement_20", "");
			if(bookmarkNames.contains("FS_AAO_6_mode_acheminement_20")) replaceBookmarkByValue("FS_AAO_6_mode_acheminement_20", "");
			if(bookmarkNames.contains("FS_AAO_7_adresse_depot_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_depot_offre_20", "");
			
			if(bookmarkNames.contains("FS_AAO_7_date_limite_20")) replaceBookmarkByValue("FS_AAO_7_date_limite_20", "");
			if(bookmarkNames.contains("FS_AAO_7_heure_limite_20")) replaceBookmarkByValue("FS_AAO_7_heure_limite_20", "");
			if(bookmarkNames.contains("FS_AAO_7_adresse_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_ouverture_offre_20", "");
			
			if(bookmarkNames.contains("FS_AAO_7_date_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_date_ouverture_offre_20", "");
			if(bookmarkNames.contains("FS_AAO_7_heure_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_heure_ouverture_offre_20", "");
			if(bookmarkNames.contains("FS_AAO_8_cautionnemant_provisoire_20")) replaceBookmarkByValue("FS_AAO_8_cautionnemant_provisoire_20", "");
			
			if(bookmarkNames.contains("FS_AAO_8_delai_validite_20")) replaceBookmarkByValue("FS_AAO_8_delai_validite_20", "");
			if(bookmarkNames.contains("FS_AAO_9_adresse_resultat_20")) replaceBookmarkByValue("FS_AAO_9_adresse_resultat_20", "");
		}
		break;
		
		// FOURNITURE
		case "0" : {
			_logger.info("DAO de fourniture");
			
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_00")) replaceBookmarkByValue("PG_min_00", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_00")) replaceBookmarkByValue("PG_ac_00", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_00")) replaceBookmarkByValue("PG_anGestion01_00", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_00")) replaceBookmarkByValue("PG_objet_00", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_00")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_00", mg);
				}
			
			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_objet_00")) {
				_logger.info("le probleme est se trouve ici & le probleme est se trouve ici le probleme est se trouve ici");
			} // replaceBookmarkByValue("PT_objet_00", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_00")) replaceBookmarkByValue("PT_ac_00", daoIter.getStrLibelleLong());
			
			// DPAO
			if(bookmarkNames.contains("DPAO_IC_1_1_ac_00")) replaceBookmarkByValue("DPAO_IC_1_1_ac_00", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_00")) {
					String m = "";
					for(VbLotAao i:infoLots) {
						m = m + i.getLaaObjet()+ "\n";
					}
					replaceBookmarkByValue("DPAO_IC_1_1_table_lots_00", m);
					_logger.info(m);
				}
			//if(bookmarkNames.contains("DPAO_IC_1_2_source_financement_00")) replaceBookmarkByValue("DPAO_IC_1_2_source_financement_00", "");
			if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_00")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_00", adresseIter.getLibdetail());
			/*if(bookmarkNames.contains("DPAO_IC_7_1_clarification_responsable_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_responsable_00", "");
			if(bookmarkNames.contains("DPAO_IC_7_1_clarification_adresse_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_adresse_00", "");
			if(bookmarkNames.contains("DPAO_IC_7_1_clarification_boite_postale")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_boite_postale", "");
			if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telephone")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telephone", "");
			if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telecopie")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telecopie", "");
*/
			if(bookmarkNames.contains("DPAO_IC_14_6_lieu_destination_00")) replaceBookmarkByValue("DPAO_IC_14_6_lieu_destination_00", "");
			
			if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_00")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_00", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_IC_20_1_garantie_soumission_00")) replaceBookmarkByValue("DPAO_IC_20_1_garantie_soumission_00", "");
			if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_00")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_00", daoIter.getDacNbrCopieOff().toString());
			
			if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_00")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_00", adresseIter.getLibdetail());
			/*if(bookmarkNames.contains("DPAO_IC_23_1_remise_personne_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_personne_00", "");
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_adresse_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_adresse_00", "");
			
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_email_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_email_00", "");
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_boite_postale_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_boite_postale_00", "");*/
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_date_00")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_IC_23_1_remise_date_00", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_heure_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_heure_00", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_adresse_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_adresse_00", daoIter.getAaoLieuRecep());
			
			if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_date_00")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_IC_26_1_ouverture_date_00", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_heure_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_heure_00", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_commission_00")) {
				String cojo = "";
				for(VbCommissionSpecifique i:infoCojo) {
					cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
				}
				replaceBookmarkByValue("DPAO_IC_26_1_ouverture_commission_00", cojo);
				_logger.info(cojo);
			}
			if(bookmarkNames.contains("DPAO_IC_39_1_quantite_augmente_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_augmente_00", "");
			if(bookmarkNames.contains("DPAO_IC_39_1_quantite_reduite_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_reduite_00", "");
			
		}break;
		
		// FOURNITURE
				case "00" : {
					_logger.info("DAO de fourniture");
					
					// PAGE DE GARDE
					if(bookmarkNames.contains("PG_min_00")) replaceBookmarkByValue("PG_min_00", daoIter.getMinLibelle().toUpperCase());
					if(bookmarkNames.contains("PG_ac_00")) replaceBookmarkByValue("PG_ac_00", daoIter.getStrLibelleLong().toUpperCase());
					if(bookmarkNames.contains("PG_anGestion01_00")) replaceBookmarkByValue("PG_anGestion01_00", String.valueOf(daoIter.getGesCode()));
					if(bookmarkNames.contains("PG_objet_00")) replaceBookmarkByValue("PG_objet_00", daoIter.getDacObjet());
					if(bookmarkNames.contains("PG_moisAnGestion_00")) {
						Calendar c = Calendar.getInstance();
						String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
						String mg = mois + "/" + daoIter.getGesCode();
						replaceBookmarkByValue("PG_moisAnGestion_00", mg);
						}
					
					// PAGE DE TITRE
					if(bookmarkNames.contains("PT_objet_00")) {
						_logger.info("le probleme est se trouve ici & le probleme est se trouve ici le probleme est se trouve ici");
					} // replaceBookmarkByValue("PT_objet_00", daoIter.getDacObjet());
					if(bookmarkNames.contains("PT_ac_00")) replaceBookmarkByValue("PT_ac_00", daoIter.getStrLibelleLong());
					
					// DPAO
					if(bookmarkNames.contains("DPAO_IC_1_1_ac_00")) replaceBookmarkByValue("DPAO_IC_1_1_ac_00", daoIter.getStrLibelleLong().toUpperCase());
					if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_00")) {
							String m = "";
							for(VbLotAao i:infoLots) {
								m = m + i.getLaaObjet()+ "\n";
							}
							replaceBookmarkByValue("DPAO_IC_1_1_table_lots_00", m);
							_logger.info(m);
						}
					//if(bookmarkNames.contains("DPAO_IC_1_2_source_financement_00")) replaceBookmarkByValue("DPAO_IC_1_2_source_financement_00", "");
					if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_00")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_00", adresseIter.getLibdetail());
					/*if(bookmarkNames.contains("DPAO_IC_7_1_clarification_responsable_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_responsable_00", "");
					if(bookmarkNames.contains("DPAO_IC_7_1_clarification_adresse_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_adresse_00", "");
					if(bookmarkNames.contains("DPAO_IC_7_1_clarification_boite_postale")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_boite_postale", "");
					if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telephone")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telephone", "");
					if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telecopie")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telecopie", "");
		*/
					if(bookmarkNames.contains("DPAO_IC_14_6_lieu_destination_00")) replaceBookmarkByValue("DPAO_IC_14_6_lieu_destination_00", "");
					
					if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_00")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_00", daoIter.getAaoDelaiVal().toString());
					if(bookmarkNames.contains("DPAO_IC_20_1_garantie_soumission_00")) replaceBookmarkByValue("DPAO_IC_20_1_garantie_soumission_00", "");
					if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_00")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_00", daoIter.getDacNbrCopieOff().toString());
					
					if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_00")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_00", adresseIter.getLibdetail());
					/*if(bookmarkNames.contains("DPAO_IC_23_1_remise_personne_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_personne_00", "");
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_adresse_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_adresse_00", "");
					
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_email_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_email_00", "");
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_boite_postale_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_boite_postale_00", "");*/
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_date_00")) { 	
						SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
						replaceBookmarkByValue("DPAO_IC_23_1_remise_date_00", date.format(daoIter.getAaoDateRecep()));
					}
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_heure_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_heure_00", daoIter.getAaoHeureRecep());
					if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_adresse_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_adresse_00", daoIter.getAaoLieuRecep());
					
					if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_date_00")) {	
						SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
						replaceBookmarkByValue("DPAO_IC_26_1_ouverture_date_00", date.format(daoIter.getAaoDteOuvTec()));
					}
					if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_heure_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_heure_00", daoIter.getAaoDteHeurOuv());
					if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_commission_00")) {
						String cojo = "";
						for(VbCommissionSpecifique i:infoCojo) {
							cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
						}
						replaceBookmarkByValue("DPAO_IC_26_1_ouverture_commission_00", cojo);
						_logger.info(cojo);
					}
					if(bookmarkNames.contains("DPAO_IC_39_1_quantite_augmente_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_augmente_00", "");
					if(bookmarkNames.contains("DPAO_IC_39_1_quantite_reduite_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_reduite_00", "");
					
				}break;
		
		
		// PRESTATIONS
		case "1" : {
			_logger.info("DAO de prestations");
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_01")) replaceBookmarkByValue("PG_min_01", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_01")) replaceBookmarkByValue("PG_ac_01",  daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_01")) replaceBookmarkByValue("PG_anGestion01_01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_01")) replaceBookmarkByValue("PG_objet_01", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_01")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_00", mg);
				}
			
			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_nom_projet_01")) replaceBookmarkByValue("PT_nom_projet_01", "");
			if(bookmarkNames.contains("PT_objet_01")) replaceBookmarkByValue("PT_objet_01", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_01")) replaceBookmarkByValue("PT_ac_01", daoIter.getStrLibelleLong());
			
			// LETTRE D'INVITATION
			if(bookmarkNames.contains("LI_1_ac_01")) replaceBookmarkByValue("LI_1_ac_01", daoIter.getStrLibelleLong()); 
			if(bookmarkNames.contains("LI_1_ac02_01")) replaceBookmarkByValue("LI_1_ac02_01", daoIter.getStrLibelleLong());
			if(bookmarkNames.contains("LI_1_source_financement_01")) replaceBookmarkByValue("LI_1_source_financement_01", ""); /* il est reste Ã  trouver la solution */ 
			if(bookmarkNames.contains("LI_1_objet_01")) replaceBookmarkByValue("LI_1_objet_01", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("LI_1_depot_adresse_01")) replaceBookmarkByValue("LI_1_depot_adresse_01", adresseIter.getLibdetail());
			
			// DEMANDE DE PROPOSITION
			if(bookmarkNames.contains("DP_IC_1_1_ac_01")) replaceBookmarkByValue("DP_IC_1_1_ac_01", daoIter.getStrLibelleLong());
			if(bookmarkNames.contains("DP_IC_1_3_rep_AC_01")) replaceBookmarkByValue("DP_IC_1_3_rep_AC_01", adresseIter.getLibdetail());			
			/*if(bookmarkNames.contains("DP_IC_1_3_rep_adresse_01")) replaceBookmarkByValue("DP_IC_1_3_rep_adresse_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_telephone_01")) replaceBookmarkByValue("DP_IC_1_3_rep_telephone_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_telecopie_01")) replaceBookmarkByValue("DP_IC_1_3_rep_telecopie_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_email_01")) replaceBookmarkByValue("DP_IC_1_3_rep_email_01", "");*/			
			if(bookmarkNames.contains("DP_IC_6_delai_validite_01")) replaceBookmarkByValue("DP_IC_6_delai_validite_01", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DP_IC_8_1_eclair_adresse_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_adresse_01", "");
			
			if(bookmarkNames.contains("DP_IC_8_1_eclair_telecopie_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_telecopie_01", "");
			if(bookmarkNames.contains("DP_IC_8_1_eclair_couriel_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_couriel_01", "");			
			if(bookmarkNames.contains("DP_IC_13_3_nombre_copie01_01")) replaceBookmarkByValue("DP_IC_13_3_nombre_copie01_01", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DP_IC_13_3_nombre_copie02_01")) replaceBookmarkByValue("DP_IC_13_3_nombre_copie02_01", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_adresse_01")) replaceBookmarkByValue("DP_IC_13_5_proposition_depot_adresse_01", adresseIter.getLibdetail());
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_date_01")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
			}			
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_heure_01")) replaceBookmarkByValue("DP_IC_13_5_proposition_depot_heure_01", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DP_IC_13_5_lieu_negociation_01")) replaceBookmarkByValue("DP_IC_13_5_lieu_negociation_01", "");
			if(bookmarkNames.contains("DP_IC_13_5_commission_01")) {
				String cojo = "";
				for(VbCommissionSpecifique i:infoCojo) {
					cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
				}
				replaceBookmarkByValue("DP_IC_13_5_commission_01", cojo);
				_logger.info(cojo);
			} // cojo
		}
		break;
		
		case "10" : {
			_logger.info("DAO de prestations");
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_01")) replaceBookmarkByValue("PG_min_01", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_01")) replaceBookmarkByValue("PG_ac_01",  daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_01")) replaceBookmarkByValue("PG_anGestion01_01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_01")) replaceBookmarkByValue("PG_objet_01", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_01")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_00", mg);
				}
			
			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_nom_projet_01")) replaceBookmarkByValue("PT_nom_projet_01", "");
			if(bookmarkNames.contains("PT_objet_01")) replaceBookmarkByValue("PT_objet_01", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_01")) replaceBookmarkByValue("PT_ac_01", daoIter.getStrLibelleLong());
			
			// LETTRE D'INVITATION
			if(bookmarkNames.contains("LI_1_ac_01")) replaceBookmarkByValue("LI_1_ac_01", daoIter.getStrLibelleLong()); 
			if(bookmarkNames.contains("LI_1_ac02_01")) replaceBookmarkByValue("LI_1_ac02_01", daoIter.getStrLibelleLong());
			if(bookmarkNames.contains("LI_1_source_financement_01")) replaceBookmarkByValue("LI_1_source_financement_01", ""); /* il est reste Ã  trouver la solution */ 
			if(bookmarkNames.contains("LI_1_objet_01")) replaceBookmarkByValue("LI_1_objet_01", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("LI_1_depot_adresse_01")) replaceBookmarkByValue("LI_1_depot_adresse_01", adresseIter.getLibdetail());
			
			// DEMANDE DE PROPOSITION
			if(bookmarkNames.contains("DP_IC_1_1_ac_01")) replaceBookmarkByValue("DP_IC_1_1_ac_01", daoIter.getStrLibelleLong());
			if(bookmarkNames.contains("DP_IC_1_3_rep_AC_01")) replaceBookmarkByValue("DP_IC_1_3_rep_AC_01", adresseIter.getLibdetail());			
			/*if(bookmarkNames.contains("DP_IC_1_3_rep_adresse_01")) replaceBookmarkByValue("DP_IC_1_3_rep_adresse_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_telephone_01")) replaceBookmarkByValue("DP_IC_1_3_rep_telephone_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_telecopie_01")) replaceBookmarkByValue("DP_IC_1_3_rep_telecopie_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_email_01")) replaceBookmarkByValue("DP_IC_1_3_rep_email_01", "");*/			
			if(bookmarkNames.contains("DP_IC_6_delai_validite_01")) replaceBookmarkByValue("DP_IC_6_delai_validite_01", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DP_IC_8_1_eclair_adresse_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_adresse_01", "");
			
			if(bookmarkNames.contains("DP_IC_8_1_eclair_telecopie_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_telecopie_01", "");
			if(bookmarkNames.contains("DP_IC_8_1_eclair_couriel_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_couriel_01", "");			
			if(bookmarkNames.contains("DP_IC_13_3_nombre_copie01_01")) replaceBookmarkByValue("DP_IC_13_3_nombre_copie01_01", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DP_IC_13_3_nombre_copie02_01")) replaceBookmarkByValue("DP_IC_13_3_nombre_copie02_01", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_adresse_01")) replaceBookmarkByValue("DP_IC_13_5_proposition_depot_adresse_01", adresseIter.getLibdetail());
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_date_01")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
			}			
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_heure_01")) replaceBookmarkByValue("DP_IC_13_5_proposition_depot_heure_01", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DP_IC_13_5_lieu_negociation_01")) replaceBookmarkByValue("DP_IC_13_5_lieu_negociation_01", "");
			if(bookmarkNames.contains("DP_IC_13_5_commission_01")) {
				String cojo = "";
				for(VbCommissionSpecifique i:infoCojo) {
					cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
				}
				replaceBookmarkByValue("DP_IC_13_5_commission_01", cojo);
				_logger.info(cojo);
			} // cojo
		}
		break;
		
		case "05" : // FOURNITURE DE CARBURANT LEGER
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Données particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // Ã  faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // Ã  faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "16" : // DAO RESTAURATION
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Données particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // Ã  faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // Ã  faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "15" : // LOCATION DE MAIN D'OEUVRE - (Services courants)
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Données particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // Ã  faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // Ã  faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "19" :	// GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Données particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // Ã  faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // Ã  faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "14" : // SECURITE PRIVEE ou GARDIENNAGE
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Données particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // Ã  faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // Ã  faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "13" : // ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Données particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // Ã  faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // Ã  faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;	
		// FOURNITURE DE CARBURANT LEGER
		/*case "05" : {
			
		}
		break;*/
		
		// DAO RESTAURATION
		/*case "16" : {
					
		}
		break;*/
		
		// LOCATION DE MAIN D'OEUVRE - (Services courants)
		/*case "15" : {
			
		}
		break;*/
		
		// GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
/*		case "19" : {
					
		}
		break;*/
		
		// SECURITE PRIVEE ou GARDIENNAGE
/*		case "14" : {
			
		}
		break;
		*/
		// ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
/*		case "13" : {
					
		}
		break;*/
		}
		_logger.info("Bookmarks remplacés");
	}
	
	
	// methode pour telecharger le dao
	public void telechargerDao() throws IOException {
		downloadFileServlet.downloadFile(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME, DOWNLOAD_FILENAME); 
	}
		
		
	public void insertPermStart(String start, String id) {
		List<XWPFParagraph> paralist = null;
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		
		paralist = getDocument().getParagraphs();
		paraIter = paralist.iterator();
		
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(start)) {
					CTPermStart ctpermstart = document.getDocument().getBody().addNewPermStart();
					ctpermstart.setEdGrp(STEdGrp.EVERYONE);
					ctpermstart.setId(id);
					Node node = ctpermstart.getDomNode();
					System.out.println(node.getNodeName());
					System.out.println(ctpermstart.getEdGrp());
					System.out.println("");
					
					para.getCTP().getDomNode().insertBefore(ctpermstart.getDomNode(), bookmark.getDomNode());
				}
			}
		}
	}

	
	public void insertPermEnd(String end, String id) {
		List<XWPFParagraph> paralist = null;
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		
		paralist = getDocument().getParagraphs();
		paraIter = paralist.iterator();
		
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(end)) {
					CTPerm ctpermend = document.getDocument().getBody().addNewPermEnd();
					ctpermend.setId(id);
					Node node = ctpermend.getDomNode();
					String str = ctpermend.getId();
					System.out.println(node.getNodeName());
					System.out.println(str);
					System.out.println("______________________");
					
					para.getCTP().getDomNode().insertBefore(ctpermend.getDomNode(), bookmark.getDomNode());
				}
			}
		}
	}

	
	public void setProtect() {		
		getDocument().enforceReadonlyProtection("emap31032020", none);
		System.out.println("protégé");
	}
	
	public void verrouillage() {
		switch(String.valueOf(daoIter.getTymCode().charAt(0))) {		 
		// TRAVAUX	
		case "2": 
			insertPermStart("deverouillage_debut_01", "12");
			insertPermEnd("deverouillage_fin_01", "12");
			
			insertPermStart("deverouillage_debut_02", "34");
			insertPermEnd("deverouillage_fin_02", "34");
			
			insertPermStart("deverouillage_debut_03", "56");
			insertPermEnd("deverouillage_fin_03", "56");
			break;
		
		// PRESTATION
		case "1":
			insertPermStart("deverouillage_debut_01", "12");
			insertPermEnd("deverouillage_fin_01", "12");
			
			insertPermStart("deverouillage_debut_02", "34");
			insertPermEnd("deverouillage_fin_02", "34");
			break;
		
		// FOURNITURE	
		case "0":
			insertPermStart("deverouillage_debut_01", "12");
			insertPermEnd("deverouillage_fin_01", "12");
			
			insertPermStart("deverouillage_debut_02", "34");
			insertPermEnd("deverouillage_fin_02", "34");
			
			insertPermStart("deverouillage_debut_03", "56");
			insertPermEnd("deverouillage_fin_03", "56");
			break;
		}
	}
	
	public static HashAlgorithm none ;
	
	ArrayList<VdDao> infoDao = new ArrayList<VdDao>();
	ArrayList<VdAao> infoAao = new ArrayList<VdAao>();
	ArrayList<VxAdresse> infoAdresse = new ArrayList<VxAdresse>();
	ArrayList<VbLotAao> infoLots = new ArrayList<VbLotAao>();
	ArrayList<VbCommissionSpecifique> infoCojo = new ArrayList<VbCommissionSpecifique>();

	List<String> bookmarkNames = new ArrayList<String>();
	VdDao daoIter = new VdDao();
	VdAao aaoIter = new VdAao();
	VxAdresse adresseIter = new VxAdresse();
	VbLotAao lotsIter = new VbLotAao();
	VbCommissionSpecifique cojoIter = new VbCommissionSpecifique();
	
	public void createDaoFile() throws IOException {
		infoDao.clear();
		infoAao.clear();
		infoAdresse.clear();
		infoLots.clear();
		infoCojo.clear();
		getInfoDao();
		getInfoAao();
		getInfoAdresse();
		getInfoLots();
		getInfoCojo();
		
		chargeDaoFile();
		bookmarkNames = getBookmarkNames();
		System.out.println(bookmarkNames);
		replaceBookmarks(bookmarkNames, daoIter, adresseIter, aaoIter, lotsIter, cojoIter);
		
		verrouillage();
		setProtect();
		
		saveDaoFile();
		//downloadDao();
		telechargerDao();
	}

	public boolean isLibBailleur() {
		return libBailleur;
	}

	public void setLibBailleur(boolean libBailleur) {
		this.libBailleur = libBailleur;
	}

	public boolean isInputBailleur() {
		return inputBailleur;
	}

	public void setInputBailleur(boolean inputBailleur) {
		this.inputBailleur = inputBailleur;
	}

	public List<TDetCommissionSeance> getListeDetCom() {
		return listeDetCom;
	}

	public void setListeDetCom(List<TDetCommissionSeance> listeDetCom) {
		this.listeDetCom = listeDetCom;
	}

	public List<TDaoAffectation> getListeDaoAff() {
		return listeDaoAff;
	}

	public void setListeDaoAff(List<TDaoAffectation> listeDaoAff) {
		this.listeDaoAff = listeDaoAff;
	}

	public TDetCommissionSeance getSupDetCom() {
		return supDetCom;
	}

	public void setSupDetCom(TDetCommissionSeance supDetCom) {
		this.supDetCom = supDetCom;
	}

	public TDaoAffectation getSupDaoAff() {
		return supDaoAff;
	}

	public void setSupDaoAff(TDaoAffectation supDaoAff) {
		this.supDaoAff = supDaoAff;
	}

	public long getDcsNum() {
		return dcsNum;
	}

	public void setDcsNum(long dcsNum) {
		this.dcsNum = dcsNum;
	}
	/*******  Fin document  *************/
}