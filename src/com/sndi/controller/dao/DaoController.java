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
import java.time.Month;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
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
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
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
	 private List<VDacliste> reaffectlisteDAO = new ArrayList<VDacliste>();
	 private List<VDacliste> detailTB = new ArrayList<VDacliste>();
	 private List<VDacliste> detailTrans = new ArrayList<VDacliste>();
	 private List<VDacliste> detailDac = new ArrayList<VDacliste>();
	 private List<VDacliste> dacVente = new ArrayList<VDacliste>();
	 private List<VDacliste> detailDacDiff = new ArrayList<VDacliste>();
	 private List<TDacSpecs> listDao = new ArrayList<TDacSpecs>(); 
	 private List<TPiecesDacs> listePieceDac = new ArrayList<TPiecesDacs>();
	 private List<TGestion> listeGestion = new ArrayList<TGestion>();
	 private List<TAvisAppelOffre> avisTab = new ArrayList<TAvisAppelOffre>(); 
	 private List<TDaoAffectation> daoExamen = new ArrayList<TDaoAffectation>();
	 private List<TDaoAffectation> daoBinome = new ArrayList<TDaoAffectation>();
	 private List<VDetailCorrection> listeDetailCorrection = new ArrayList<VDetailCorrection>();
	 private List<VFonctionImputation> listeFonctionsImput = new ArrayList<VFonctionImputation>();
	 private List<TTypePiecesDac>listSelectionTypePieces =new ArrayList<TTypePiecesDac>();
	 private List<TPiecesDacs>listePiecesDac =new ArrayList<TPiecesDacs>();
	 private List<VChargeEtudeDac>listeChargeEtudeByDac =new ArrayList<VChargeEtudeDac>();
	 private List<TDetailPlanPassation> listeDetail = new ArrayList<TDetailPlanPassation>();
	 private List<TSeances> listSeances  = new ArrayList<TSeances>();  
	 
	 private List<TDetCommissionSeance> listeDetCom  = new ArrayList<TDetCommissionSeance>();
	 private List<TDaoAffectation> listeDaoAff  = new ArrayList<TDaoAffectation>();
	 //private List<VLigneImputation> listeImputations = new ArrayList<VLigneImputation>();
	//private List<VDelaiValiditeOffre> delaiValidite = new ArrayList<VDelaiValiditeOffre>();
	 private List<VLigneLot> listeImputations = new ArrayList<VLigneLot>();
	 private List<VInfoNcc> listOffreCandidat = new ArrayList<VInfoNcc>(); 
	 private List<VLigneLot> listeImputationsModif = new ArrayList<VLigneLot>();
	 private List<TCorrectionDac> listCorrection = new ArrayList<TCorrectionDac>();
	 private List<TCorrectionDac> listPieceCorrection = new ArrayList<TCorrectionDac>();
	 //private List<TDossierDacs> dossListe = new ArrayList<TDossierDacs>();
	 private List<VDossierDac> dossListe = new ArrayList<VDossierDac>();
	 //private List<TDossierDacs> dossDacListe = new ArrayList<TDossierDacs>();
	 private List<VDossierDac> dossDacListe = new ArrayList<VDossierDac>();
	 private List<VPpmDao> ppmDao = new ArrayList<VPpmDao>();
	 private List<VPpmDao> listePpmDao = new ArrayList<VPpmDao>();
	 private List<VPpmDao> listePpmDaoModif = new ArrayList<VPpmDao>();
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
	 private List<VCheckTransDac> listCheckTrans = new ArrayList<VCheckTransDac>();
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
	//VLignePPM
	private List<VLignePpm> listeLignePpm = new ArrayList<VLignePpm>();
	//VLignePPM
	private VFonctionImputation sltImput = new VFonctionImputation();
	private VbTempParametreCorDac newTempCor = new VbTempParametreCorDac();
	private VCheckTransDac newCheckTrans = new VCheckTransDac();
	 private VInfoNcc offreCandidat = new VInfoNcc(); 
	//Pieces a examiner
	private List<TDetailCorrection> listeCorrection = new ArrayList<TDetailCorrection>();
	private List<VPieces> listePices = new ArrayList<VPieces>();
	private List<VPieces> listePicesCsv = new ArrayList<VPieces>();
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
	private TCommissionSpecifique comUpdate = new TCommissionSpecifique();
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
	private VPieceDac sltPiecesDac =new VPieceDac();
	private TPiecesDacs pieceDac =new TPiecesDacs();
	//DELETE VENTE
	private List<THistoDac> listeHisto  = new ArrayList<THistoDac>();
	private List<TDetailVente> listeDetVet  = new ArrayList<TDetailVente>();
	private List<TVenteDac> listeVetDac  = new ArrayList<TVenteDac>();
	private List<TCandidats> listeCanDac  = new ArrayList<TCandidats>();
	//DFIN DELETE VENTE
	//variables
	private long gesCode;
	private long modifAdr;
	private BigDecimal dacNbrCopieOff;
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
	 //private TDossierDacs selectedDossier = new TDossierDacs();
	 private VDossierDac selectedDossier = new VDossierDac();
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
	 private List<VAvisPublie> publieListe = new ArrayList<VAvisPublie>();
	 private VbTempCritere newTempEnteteCrit = new VbTempCritere();
	private TDetCritAnalyseDac detCritere = new TDetCritAnalyseDac();
	private VDacliste caution = new VDacliste();
	private VLotCritere lotCrit = new VLotCritere();
	private TLotAao lots = new TLotAao();
	private VPpmDao ppmDac = new VPpmDao();
	//MARGE DE PREFERENCE
	private VMargeDePreference marge = new VMargeDePreference();
	private VMargeDePreferenceSou margeSou = new VMargeDePreferenceSou();
	private VMargeDePreferenceCom margeCom = new VMargeDePreferenceCom();
	private VMargeDePreferenceArt margeArt = new VMargeDePreferenceArt();
	//VARIABLES
	 private long adaNum;
	 private long rId;
	 /*private long crit;
	 private long rIdSous;*/
	 private String crit;
	 private String rIdSous;
	 private long delai;
	 private long dcadNum;
	 private long totalMontantEstimatif;
	 private long totalNbreVente;
	 private long totalMontantCaution;
	 private double montantCaution =0; 
	 private long cautionMinRound =0;
	 private long cautionMaxRound =0;
	 private long mtCaut = 0;
	 private long mtEstimR = 0;
	 private long dcsNum;
	 private long nbreDelai;
	 private long lotNbre;
	 private String pidCod;
	 private String observation="";
	 //Avis d'Appel d'Offres
	 private String aaoLieuExe;
	 private String aaoHeureRecep;
	 private String aaoLibelle;
	 private String aaoDteHeurOuv;
	 private String aaoLieuRecep;
	 private String aaoPrecisModEval;
	 private String aaoNatPrix;
	 private String aaoRegQual;
	 private String aaoAvisBai;
	 private String aaoRespBai;
	 private String aaoOffAnormal;
	 private long aaoNbrOuv;
	 private long aaoCoutDac;
	 private Date aaoDateRecep;
	 //Fin d'Appel d'Offres
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
	 private String str = "";
     private String strMtCaut = "";
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
	 private List<VMargeDePreference> listMargeModif = new ArrayList<VMargeDePreference>();
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
	 TPiecesDacs piece = new TPiecesDacs(); 
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
	 private boolean champMtCaut = false;
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
	 private boolean btnChangerOperation = false;
	 private boolean btnAffecte = false;
	 private boolean btnAffecte1 = false;
	 private boolean btnAffecteNormal = true;
	 //Controle sur les imputations
	 private boolean imputationLot = true;
	 private boolean imputationPpm = false;
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
	  private String avisRespo = "";
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
	  private String type ="";
	  private String plan ="";
	  private String statutTrans ="";
	  private String dacMargePref = "";
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
	  private boolean panelExixstent1 = false;
	  private boolean panelNouveau = false;
	  private boolean panelNouveau1 = false;
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
	  private boolean ouvertureAmi = false;
	  private boolean pavet_lot = false;
	  private boolean pavet_infoG = false;
	  private boolean pavet_offre = false;
	  private boolean pavet_critere = false;
	  private boolean pavet_commission = false;
	  private boolean btn_dao = false;
	  private boolean btn_dao_modif = false;
	  private boolean btn_titre_paie = false;
	  private boolean btn_titre_retrait = false;
	  private boolean infoNcc = false;
	  private boolean panelNcc1 = false;
	  private boolean panelNcc2 = false;
	  private boolean confirmInter = false;
	  private boolean clean = false;
	  private boolean panelMessage = true;
	  private boolean panelCritereLot = false;
	  private String mois = "";
	  private String statut = "";
	  private boolean champPub = false;
	  private boolean dacMention =false;
	 
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
					 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez terminer votre Saisie, avant de cliquer sur suivant!", ""));
			          return "creation";
					} 
	              userController.initMessage(); 
	              //listeMarge();
			     }
			 
			//Controle Pav cration
			 if(event.getOldStep().equals("tabLot") && event.getNewStep().equals("critere")) {
				 chargeCritere();
			     }
			//Controle Pav cration
			 if(event.getOldStep().equals("critere") && event.getNewStep().equals("criterebyLot")) {
				 //factoriserLot();
				 factoriserNext();
				 listeCritereByLot.clear();
			     }
			 
			//Controle totalit des lots factoriss
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
					 }else 
					 {
						 if(lotCrit.getChildOk() != 0)
						 {
							 FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Il n' y a pas de critères d'évaluation pour : "+lotCrit.getLibChild(), ""));
							 return "criterebyLot";
						 }
					 }
			     }
			 }
			 
			 if(event.getOldStep().equals("criterebyLot") && event.getNewStep().equals("critere")) {
				 //newTempFactorise = new VbTempParametreFact(); 
				 chargeLotConsultation();
			     }
			 
			 //Pavet Lot
			 if(event.getOldStep().equals("creation") && event.getNewStep().equals("Poffre")) {
				 controlLotDao();
				 userController.initMessage();
			     }
			 
			 
			 ////////////////////ECRAN DE MODIFICATION///////////////////////////////
			//Controle Pave cration modification
			 if(event.getOldStep().equals("creationModif") && event.getNewStep().equals("avisModif")) {
				 if(slctdTd.getDacTymCode() == null || slctdTd.getDacMopCode() == null 
						 || slctdTd.getDacObjet() == null )  
				 {
					 FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez terminer votre Saisie, avant de cliquer sur suivant!", ""));
			          return "creationModif";
					} 
	               userController.initMessage(); 
	               actionsPavetCreation();
			     }
			      
			     //Controle Pav avis modification
			      if(event.getOldStep().equals("avisModif") && event.getNewStep().equals("tabLotModif")) {
			    	actionsPavetLot();
			    	actualisationDac();
				  }
			      
			    //Controle Pav lot modification
			      if(event.getOldStep().equals("tabLotModif") && event.getNewStep().equals("critereModif")) {
				  actionsPavetCritere();
				  
				  }
			      
			    //Controle Pav criterebylot modification
			      if(event.getOldStep().equals("critereModif") && event.getNewStep().equals("criterebyLotModif")) {
			    	  actionsPavetCritereByLot();  
				  }
			      
			    //Controle Pav criterebylot modification contraire
			      if(event.getOldStep().equals("criterebyLotModif") && event.getNewStep().equals("critereModif")) {
			    	  chargeLotConsultation();
				  }
			      
			    //Controle Pav cojo modification
			      if(event.getOldStep().equals("criterebyLotModif") && event.getNewStep().equals("cojoModif")) {
			    	  chargeArticle();
						 //listeLotCritere.clear();
						 listeLotCritere=(List<VLotCritere>) iservice.getObjectsByColumn("VLotCritere", new ArrayList<String>(Arrays.asList("LAA_NUM")),
								new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
						 if(!listeLotCritere.isEmpty()) { 
							 lotCrit=listeLotCritere.get(0);
							 if(lotCrit.getCritOk() != 0) {
								 FacesContext.getCurrentInstance().addMessage(null,
										 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Il y a encore "+lotCrit.getCritOk()+" lot(s) sans critères", ""));
								 return "criterebyLotModif";
							 }else 
							 {
								 if(lotCrit.getChildOk() != 0)
								 {
									 FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_ERROR, "Il n' y a pas de critères d'évaluation pour : "+lotCrit.getLibChild(), ""));
									 return "criterebyLotModif";
								 }  
							 }
					     }
			    	  actionPavetCojo();
				  }
			
			    //Controle Pav Dossier modification
			      if(event.getOldStep().equals("cojoModif") && event.getNewStep().equals("DossiersModif")) {
				  //Ici
				  }
			  
           ////////////////////FIN ECRAN DE MODIFICATION///////////////////////////////
			
		      return event.getNewStep();
		      
	    }
	 
	 //Methode pour retourner
	 public void retour() {
		 
	 }
	 
	 

		//Methode de suppression de l'operation
public void deleteDac() {
_logger.info("code: "+slctdTd.getDacCode());
List<TDacSpecs> DAC  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
TDacSpecs dao = new TDacSpecs();
	if(!DAC.isEmpty()) dao = DAC.get(0);
	dao.setTStatut(new TStatut("SDS"));
 iservice.updateObject(dao);
  historiser("SDS",""+slctdTd.getDacCode(), "Dossier supprimé par l'autorité contractante");
  //Update dans TdetailPlan passation
  List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
				new WhereClause("DPP_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
	     TDetailPlanPassation detail = new TDetailPlanPassation();
				if(!PLG.isEmpty()) detail =PLG.get(0); 
				detail.setDppStatutDao("N");
				detail.setTDacSpecs(new TDacSpecs(""));
				iservice.updateObject(detail);
				
 chargeData();
	userController.setTexteMsg("Supression éffectuée avec succès !");
	userController.setRenderMsg(true);
	userController.setSevrityMsg("success"); 
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
						 //chargeDataAc1();
					 }else {
						 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
							 chargeDataByAction("PRQ","PN");
						    }else{
						    	if(controleController.modeType == "RAT" && controleController.typePlan == "PN") {
									 chargeDataByAction("PRQ","PN");
								    }
						    }/*else { {
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
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listeCritereAnalyse= (List<VCritereAnalyseModel>) iservice.getObjectsByColumn("VCritereAnalyseModel", new ArrayList<String>(Arrays.asList("CRA_CODE")),
						new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode()),
			            new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
			 _logger.info("liste affiche: "+listeCritereAnalyse.size());
			 _logger.info("DacCode: "+dao.getDacCode());
			 _logger.info("mdtCode: "+dao.getTModeleDacType().getMdtCode());
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   listeCritereAnalyse= (List<VCritereAnalyseModel>) iservice.getObjectsByColumn("VCritereAnalyseModel", new ArrayList<String>(Arrays.asList("CRA_CODE")),
						new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacModType()),
			            new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
			 _logger.info("liste affiche: "+listeCritereAnalyse.size());  
			 _logger.info("DacCode: "+slctdTd.getDacCode());
			 _logger.info("mdtCode: "+slctdTd.getDacModType());
		   }
		
	 }
	 
   //Insertion du critre aprs le choix 
	public void savePiece() {
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
					     if (!listDao.isEmpty()) {
						       newDao= listDao.get(0);
						       newDao.setDacCraCodeExclus(critere);
				               iservice.updateObject(newDao); 
				               //Chargement des pices
				               chargeCritere();   
		   	           }
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
					     if (!listDao.isEmpty()) {
						       newDao= listDao.get(0);
						       newDao.setDacCraCodeExclus(critere);
				               iservice.updateObject(newDao); 
				               //Chargement des pices
				               chargeCritere();   
		   	           } 
		   }
		
	}
	 
	 
	 //Liste des critres saisies
	 public void chargeCritereSaisie() { 
		 listeCritereSaisie.clear(); 
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listeCritereSaisie = ((List<VCritereAnalyseDac>)iservice.getObjectsByColumn("VCritereAnalyseDac",
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,"0"),
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode())));
				 _logger.info("liste critere saisie: "+listeCritereSaisie.size());
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   listeCritereSaisie = ((List<VCritereAnalyseDac>)iservice.getObjectsByColumn("VCritereAnalyseDac",
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,"0"),
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode())));
				 _logger.info("liste critere saisie: "+listeCritereSaisie.size());   
		   }
		 
		

		 afficheOption();
	 }
	 
	 
	 public void chargeLotCritere() {
		 listeLotCritere.clear();
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listeLotCritere=(List<VLotCritere>) iservice.getObjectsByColumn("VLotCritere", new ArrayList<String>(Arrays.asList("LAA_NUM")),
						new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
				_logger.info("listeLotCritere size: "+listeLotCritere.size());
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   listeLotCritere=(List<VLotCritere>) iservice.getObjectsByColumn("VLotCritere", new ArrayList<String>(Arrays.asList("LAA_NUM")),
						new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
				_logger.info("listeLotCritere size: "+listeLotCritere.size());   
		   }
		
	 } 
	 
	 public void chargeLotConsultation() {
		 listeLotConsultation.clear();
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listeLotConsultation=(List<VLotCritere>) iservice.getObjectsByColumn("VLotCritere", new ArrayList<String>(Arrays.asList("LAA_NUM")),
						new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
				_logger.info("listeLotConsultation size: "+listeLotConsultation.size());
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   listeLotConsultation=(List<VLotCritere>) iservice.getObjectsByColumn("VLotCritere", new ArrayList<String>(Arrays.asList("LAA_NUM")),
						new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
				_logger.info("listeLotConsultation size: "+listeLotConsultation.size());  
		   }
	 }
	 
	 
	 //Affichage des marges de prfrence de l'avis en cours
	 public void listeMargePref() {
		 if(controleController.ecran=="saisie") {
			 listMarge.clear();
			 listMarge = (List<VMargeDePreference>) iservice.getObjectsByColumn("VMargeDePreference",
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		 }else { //En mode modification
			 listMarge.clear();
			 listMarge = (List<VMargeDePreference>) iservice.getObjectsByColumn("VMargeDePreference",
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		 }
	 }
	 
	 
	 
	 //Affichage des marges de prfrence de l'avis en cours
	 public void listeMargePrefModif() {
		 listMargeModif.clear();
		 listMargeModif = (List<VMargeDePreference>) iservice.getObjectsByColumn("VMargeDePreference",
					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		 _logger.info("listMarge : "  +""+slctdTd.getDacCode()+" " +listMargeModif.size());
	 }
	 
	 //Gestion des marges de prfrence
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
	 
	 
	 public void saveMargeModif (String marge) {
		 List<TDacSpecs> LS  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+sltMarge.getDacCode()));
		 TDacSpecs dac = new TDacSpecs(); 
		 if(!LS.isEmpty()) dac = LS.get(0);
		    if(sltMarge.getOrdre().equalsIgnoreCase("1")) {
		    	  dac.setDacMargePrefSou(""+marge);
		    	  dac.setDacMargePrefCom("N");
		    	  dac.setDacMargePrefArt("N");
		    	  dac.setDacMargePrefSouVal(sltMarge.getTauxMargePref());
				  iservice.updateObject(dac);
				  listeMargePrefModif();
		    }else {
		    	if(sltMarge.getOrdre().equalsIgnoreCase("2")) {
		    		dac.setDacMargePrefCom(""+marge);
		  		    dac.setDacMargePrefComVal(sltMarge.getTauxMargePref());
		  		    dac.setDacMargePrefSou("N");
		  		    iservice.updateObject(dac);
		  		  listeMargePrefModif();
			    }else {
			    	   if(sltMarge.getOrdre().equalsIgnoreCase("3")) {
			    		   dac.setDacMargePrefArt(""+marge);
					       dac.setDacMargePrefArtVal(sltMarge.getTauxMargePref());
					       dac.setDacMargePrefSou("N");
						   iservice.updateObject(dac);
						   listeMargePrefModif();
				      }
			    }
		    }
	 }
	 
	 
	 
	 //Matrialisation du DAO en statut d'Affectation
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
	 
	 public void recupDac() {
			listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
						if (!listDao.isEmpty()) {
							 newDao= listDao.get(0);
		}
	 }
	 
	//Affectation Normale d'une fonction
	 public void saveAffectationRespo(String respo) {   
		 List<TDetCommissionSeance> DET  = iservice.getObjectsByColumn("TDetCommissionSeance", new WhereClause("DCS_NUM",Comparateur.EQ,""+sltImput.getDcsNum()));
		 TDetCommissionSeance detSeance = new TDetCommissionSeance();
			if(!DET.isEmpty()) detSeance = DET.get(0);
			detSeance.setDcsMbmRespo(""+respo);
			iservice.updateObject(detSeance);
		   		   //Chargement des fonctions Ã  imputer
		   		   chargeFonctionImput();
		   		  //Message de Confirmation
		   		  userController.setTexteMsg("Responsabilité Attribuée avec succès!");
				  userController.setRenderMsg(true);
				  userController.setSevrityMsg("success");
		       
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
			    	   recupDac();
					    	    
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
					    		              supDaoAff.setDafStaCode(newDao.getTStatut().getStaCode());
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
			    	   
			    	   recupDac();
			    	   
			    	   String chaine="SEANCE DE COMMISSION INTERNE D'ANALYSE DU DOSSIER N";
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
		    		              supDaoAff.setDafStaCode(newDao.getTStatut().getStaCode());
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
	 
	 //Mis  jour du responsable (O/N)
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
								new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
			    	              if(!listeDaoAff.isEmpty()) { 
			    		              supDaoAff=listeDaoAff.get(0);
			    		              supDaoAff.setDafDcsMbmRespo(""+respo);
			    		              iservice.updateObject(supDaoAff);
		    	 }
		    	//Chargement des fonctions imputées 
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
			    	 
			    	 
			    	 List<TCommissionSpecifique> DET  = iservice.getObjectsByColumn("TCommissionSpecifique", 
			    			 new WhereClause("COM_OPE_MATRICULE",WhereClause.Comparateur.EQ,""+sltImput.getOpeMatricule()),
			    			 new WhereClause("COM_DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
			    	        TCommissionSpecifique detSeance = new TCommissionSpecifique();
						if(!DET.isEmpty()) detSeance = DET.get(0);
						iservice.deleteObject(detSeance);
				    	 
				    //Suppression dans T_DAO_AFFECTATION
			    	 iservice.deleteObject(supDaoAff);
			    	 //Suppression dans T_DET_COMMISSION_SEANCE
			    	 iservice.deleteObject(supDetCom);
			    	//Chargement des fonctions imputer 
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
		     
	 //affichage des critres par lot
	 public void chargeCritereByLot() {
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listeCritereByLot.clear();
			   listeCritereByLot = ((List<VCritereAnalyseDac>)iservice.getObjectsByColumn("VCritereAnalyseDac",
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId)));
				 _logger.info("liste critere du lot : "  +""+laaId+" " +listeCritereByLot.size());
		   }else {
			   listeCritereByLot = ((List<VCritereAnalyseDac>)iservice.getObjectsByColumn("VCritereAnalyseDac",
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()),
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId)));
				 _logger.info("liste critere du lot : "  +""+laaId+" " +listeCritereByLot.size());
		         }
			 }
	 
	 
	 
	 
	 public void saveObservation(){	
		 listePieceDac = (List<TPiecesDacs>) iservice.getObjectsByColumn("TPiecesDacs", new ArrayList<String>(Arrays.asList("PID_CODE")),
				 new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+sltPiece.getPidDacCode()),
				 new WhereClause("PID_CODE",WhereClause.Comparateur.EQ,""+sltPiece.getPidCode()));
		 if(!listePieceDac.isEmpty()) { 
			 piece=listePieceDac.get(0);
			 piece.setPidObservation(sltPiece.getPidObservation());
			 iservice.updateObject(piece);
			 examinerCsv();
			 
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
				 listePices= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
							new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+sltPiece.getPidDacCode()));	
			 }else {
				 listePicesCsv= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
							new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+sltPiece.getPidDacCode()));	 
			 }
		   }
		 
	/*	 List<TPiecesDacs> LS  = iservice.getObjectsByColumn("TPiecesDacs", new WhereClause("PID_CODE",Comparateur.EQ,""+sltPiece.getPidCode()));
	 if(!LS.isEmpty()) piece = LS.get(0);
	 piece.setPidObservation(sltPiece.getPidObservation());
	 iservice.updateObject(piece);
	 examinerCsv();
	 //Rechargement de la liste des pices Ã  corriger
	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
		 listePices= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
					new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+sltPiece.getPidDacCode()));	
	 }else {
		 listePicesCsv= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
					new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+sltPiece.getPidDacCode()));	 
	 }*/
	 
}

	 
	 //Afficahe de la liste des critÃ¯Â¿Â½res en fonction des types pass en parametre
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
		 _logger.info("procdure: "+controleController.getTypePlan());
		 _logger.info("type dac: "+controleController.getType());
	 }*/
	 
		//Combo box critÃ¯Â¿Â½res
	 
	 public void chargeCritereCombobox() {
			 //laaId = 0;
		 //vider le champ detail
		  newCritereDac = new VbDetCritAnalyseDac(); 
		 listeEnteteCritere.clear(); 
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listeEnteteCritere = ((List<VCritAnalDacEntete>)iservice.getObjectsByColumn("VCritAnalDacEntete",
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,"0"),
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
						 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode())));
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   listeEnteteCritere = ((List<VCritAnalDacEntete>)iservice.getObjectsByColumn("VCritAnalDacEntete",
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,"0"),
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()),
						 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacModType())));   
		   }
		
	 }
	 
	//Combo box critres Pou l'ecran de factorisation
	 public void chargeCritereFactCombobox() {
		 //vider le champ detail
		  newCritereDac = new VbDetCritAnalyseDac(); 
		 listeEnteteCritere.clear(); 
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listeEnteteCritere = ((List<VCritAnalDacEntete>)iservice.getObjectsByColumn("VCritAnalDacEntete",
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
						 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode())));
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   listeEnteteCritere = ((List<VCritAnalDacEntete>)iservice.getObjectsByColumn("VCritAnalDacEntete",
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()),
						 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacModType()))); 
		   }
		
		  choixCritere = "";
		  rIdSous = "";
		  panelExixstent = false;
		  panelNouveau = false;
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
	 
	 
	//Combo box critres
	 public void chargeSousEnteteCombobox() {
		
		 if(panelExixstent == true && panelExixstent1 == true) {
			 listeEnteteCritere.clear();
			 listeEnteteCritere= (List<VCritAnalDacEntete>) iservice.getObjectsByColumn("VCritAnalDacEntete", new ArrayList<String>(Arrays.asList("CRA_LIBELLE")),
					 new WhereClause("R_ID",WhereClause.Comparateur.EQ,""+crit));
			 if(!listeEnteteCritere.isEmpty()) { 
				 newEnteteCrit=listeEnteteCritere.get(0);
				 //vider le champs detail
				  newCritereDac = new VbDetCritAnalyseDac();
				  //listeSousEnteteCritere.clear(); 
				  //ECRAN DE SAISIE
				   if(controleController.ecran=="saisie") {
					   listeSousEnteteCritere  = ((List<VCritAnalDacSousentete>)iservice.getObjectsByColumn("VCritAnalDacSousentete",
								 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
								 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
								 new WhereClause("CRA_PARENT",WhereClause.Comparateur.EQ,""+newEnteteCrit.getCraCode()),
								 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode())));
					   
							    _logger.info("lot: "+laaId);
								  _logger.info("valeur R_ID: "+crit);
								  _logger.info("Dao: "+dao.getDacCode());
								  _logger.info("cracode: "+newEnteteCrit.getCraCode());
								  _logger.info("mdt: "+dao.getTModeleDacType().getMdtCode());
				   }else
					 //ECRAN DE MODIFICATION
				   {
					   listeSousEnteteCritere  = ((List<VCritAnalDacSousentete>)iservice.getObjectsByColumn("VCritAnalDacSousentete",
								 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
								 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()),
								 new WhereClause("CRA_PARENT",WhereClause.Comparateur.EQ,""+newEnteteCrit.getCraCode()),
								 new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacModType()))); 
					   
							      _logger.info("lot: "+laaId);
								  _logger.info("valeur R_ID: "+crit);
								  _logger.info("Dao: "+slctdTd.getDacCode());
								  _logger.info("cracode: "+newEnteteCrit.getCraCode());
								  _logger.info("mdt: "+slctdTd.getDacModType());
				   }
				 
				  
				  panelExixstent = true;
				  panelExixstent1 = true;
				  panelNouveau = false;
				  panelNouveau1 = false;
				  
				  _logger.info("lot: "+laaId);
				  _logger.info("valeur R_ID: "+crit);
				  _logger.info("Dao: "+dao.getDacCode());
				  _logger.info("cracode: "+newEnteteCrit.getCraCode());
				  _logger.info("mdt: "+dao.getTModeleDacType().getMdtCode());
			 }
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
			 
			
			 //ECRAN DE SAISIE
			   if(controleController.ecran=="saisie") {
				   newCritereDac.setDcadDacCode(dao.getDacCode());
			   }else
				 //ECRAN DE MODIFICATION
			   {
				   newCritereDac.setDcadDacCode(slctdTd.getDacCode());  
			   }
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
			//ECRAN DE SAISIE
			   if(controleController.ecran=="saisie") {
				   newTempCritereDac.setCraDacCode(dao.getDacCode());
			   }else
				 //ECRAN DE MODIFICATION
			   {
				   newTempCritereDac.setCraDacCode(slctdTd.getDacCode());
			   }
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
				 //ECRAN DE SAISIE
				   if(controleController.ecran=="saisie") {
					   newCritereDac.setDcadDacCode(dao.getDacCode());
				   }else
					 //ECRAN DE MODIFICATION
				   {
					   newCritereDac.setDcadDacCode(slctdTd.getDacCode());   
				   }
				 
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
	/*  public void checkCritere() {
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
		 }*/
	  
	 //verification de la combox critere existant ou pas
	  public void checkCritere() {
			 //chargeMsgMarge();
			 if(choixCritere.equalsIgnoreCase("existant")) { 
				 panelExixstent = true; 
				 panelExixstent1 = true; 
				 panelNouveau = false;
				 panelNouveau1 = false;
			 }else 
			 {
				 panelExixstent = false;
				 panelExixstent1 = false; 
				 panelNouveau = true; 
				 panelNouveau1 = true;
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
			 //ECRAN DE SAISIE
			   if(controleController.ecran=="saisie") {
				   newCritereDac.setDcadDacCode(dao.getDacCode());
			   }else
				 //ECRAN DE MODIFICATION
			   {
				   newCritereDac.setDcadDacCode(slctdTd.getDacCode());   
			   }
			
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
			//ECRAN DE SAISIE
			   if(controleController.ecran=="saisie") {
				   newTempCritereDac.setCraDacCode(dao.getDacCode());
			   }else
				 //ECRAN DE MODIFICATION
			   {
				   newTempCritereDac.setCraDacCode(slctdTd.getDacCode());   
			   }
			 
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
	
	 
	//Contrle sur les options "Garantie de Soumission et Dclaration de Garantie de Soumission"
	public void afficheOption() {
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listeCritereAnalyse= (List<VCritereAnalyseModel>) iservice.getObjectsByColumn("VCritereAnalyseModel", new ArrayList<String>(Arrays.asList("CRA_CODE")),
						new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+dao.getTModeleDacType().getMdtCode()),
			            new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   listeCritereAnalyse= (List<VCritereAnalyseModel>) iservice.getObjectsByColumn("VCritereAnalyseModel", new ArrayList<String>(Arrays.asList("CRA_CODE")),
						new WhereClause("MDT_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacModType()),
			            new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));  
		   }
		 
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
	 
	 //Enregistrement des critres
	 public void saveCritere() {
		 
		 if (selectionlisteCritereAnalyse.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun critre selectionn", ""));
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
		 			 //ECRAN DE SAISIE
					if(controleController.ecran=="saisie") {
					  newTempCritere.setCriDacCode(dao.getDacCode());
					}else
						 //ECRAN DE MODIFICATION
					{
				     newTempCritere.setCriDacCode(slctdTd.getDacCode());   
					}
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
		 		userController.setTexteMsg("Critre(s) d'analyse enregistr(s) avec succs!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");
	 		 }
	 }
	 
	 
	//Factorisation des Lots
	 public void factoriserLot() { 
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   newTempFactorise.setTempCritDac(dao.getDacCode());
				 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   newTempFactorise.setTempCritDac(slctdTd.getDacCode());
				 newTempFactorise.setTempNbrLot(slctdTd.getAaoNbrLot());  
		   }
		 newTempFactorise.setTempType("DISP");
		 iservice.addObject(newTempFactorise); 
		 chargeLotCritere();
		 panelMessage = false;
		 panelCritereLot = true;
	 }
	 
	 //Rcupration du message
	 public void factoriserNext() { 
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   newTempFactorise.setTempCritDac(dao.getDacCode());
				 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   newTempFactorise.setTempCritDac(slctdTd.getDacCode());
				 newTempFactorise.setTempNbrLot(slctdTd.getAaoNbrLot());   
		   }
		 newTempFactorise.setTempType("TEST");
		 iservice.addObject(newTempFactorise); 
		 chargeLotCritere();
		 recupMessage();
		 panelMessage = true;
		 panelCritereLot = false;
	 }
	 
	 //Rcupration du message
	 public void factoriserNextUp() { 
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="modification") {
			   newTempFactorise.setTempCritDac(dao.getDacCode());
				 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   newTempFactorise.setTempCritDac(slctdTd.getDacCode());
			   newTempFactorise.setTempNbrLot(slctdTd.getAaoNbrLot());   
		   }
		 newTempFactorise.setTempType("TEST");
		 iservice.updateObject(newTempFactorise); 
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
	 
	 //Suppression du critre du dtail
	 public void deleteCritere() {
		 /*listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
					new WhereClause("DCAD_NUM",WhereClause.Comparateur.EQ,""+sltCritereDac.getDcadNum()));
	       if (!listeDetCritere.isEmpty()) {
	    	   detCritere = listeDetCritere.get(0);
	  		 iservice.deleteObject(detCritere); 
	  		 chargeCritereSaisie();
	  		 chargeCritere();
	  		userController.setTexteMsg("Suppression effectue avec succs!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
	       }*/
	       
	        /* newTempFactorise.setTempCritDac(dao.getDacCode());
			 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
			 newTempFactorise.setTempDcadNum(sltCritereDac.getDcadNum().toString());
			 newTempFactorise.setTempType("SUP");
			 iservice.addObject(newTempFactorise);*/
			 
			 //ECRAN DE SAISIE
			   if(controleController.ecran=="saisie") {
				   newTempFactSup.setTempCritDac(dao.getDacCode());
			   }else
				 //ECRAN DE MODIFICATION
			   {
				   newTempFactSup.setTempCritDac(slctdTd.getDacCode());   
			   }
			 newTempFactSup.setTempDcadNum(sltCritereDac.getDcadNum().toString());
		  	 newTempFactSup.setTempNbrLot(newAvis.getAaoNbrLot());
		  	 newTempFactSup.setTempLotPlage("");
		     newTempFactSup.setTempType("SUP");
			 iservice.addObject(newTempFactSup);
			 chargeCritereSaisie();
	  		 chargeCritere();
			 userController.setTexteMsg("Suppression effectue avec succs!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
			 
			 _logger.info("DAC: "+dao.getDacCode());
			 _logger.info("DCAD NUM: "+sltCritereDac.getDcadNum().toString());
			 _logger.info("Nbre Lot: "+newAvis.getAaoNbrLot());
			 _logger.info("TYPE : "+newTempFactSup.getTempType());
	 }
	 
	 //Fin de la mthode de suppression du dtail de critre
	 
	 //Suppression du critre du dtail
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
	  		userController.setTexteMsg("Suppression effectue avec succs!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
	       }*/
	       
		 //ECRAN DE SAISIE
		   if(controleController.ecran=="saisie") {
			   listeLot = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")),
					     new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()), 
						 new WhereClause("LAA_ID",WhereClause.Comparateur.EQ,""+laaId));
		   }else
			 //ECRAN DE MODIFICATION
		   {
			   listeLot = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")),
					     new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()), 
						 new WhereClause("LAA_ID",WhereClause.Comparateur.EQ,""+laaId));   
		   }
		 
       if (! listeLot.isEmpty()) {
    	   lots = listeLot.get(0);
       }
	         /*newTempFactorise.setTempCritDac(dao.getDacCode());
			 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
			 newTempFactorise.setTempLotPlage(""+laaId);
			 newTempFactorise.setTempDcadNum(sltCritereDac.getDcadNum().toString());
			 newTempFactorise.setTempType("SUP");
			 iservice.addObject(newTempFactorise);*/
		       //ECRAN DE SAISIE
			   if(controleController.ecran=="saisie") {
				   newTempFactSup.setTempCritDac(dao.getDacCode());
			   }else
				 //ECRAN DE MODIFICATION
			   {
				   newTempFactSup.setTempCritDac(slctdTd.getDacCode());  
			   }
		     
		     //newTempFactSup.setTempLotPlage(lots.getLaaNum().toString());
		     newTempFactSup.setTempLotPlage("");
		     newTempFactSup.setTempDcadNum(sltCritereDac.getDcadNum().toString());
	  	     newTempFactSup.setTempNbrLot(newAvis.getAaoNbrLot());
	         newTempFactSup.setTempType("SUP");
		     iservice.addObject(newTempFactSup);
			 chargeCritereSaisie();
	  		 chargeCritere();
	  		 chargeCritereByLot();
			 userController.setTexteMsg("Suppression effectue avec succs!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
			 
			 _logger.info("DAC: "+dao.getDacCode());
			 _logger.info("Numero Lot: "+lots.getLaaNum().toString());
			 _logger.info("DCAD NUM: "+sltCritereDac.getDcadNum().toString());
			 _logger.info("Nbre Lot: "+newAvis.getAaoNbrLot());
			 _logger.info("TYPE : "+newTempFactSup.getTempType());
	 }
	 
	 //Fin de la mthode de suppression du dtail de critre
	 
	 
	 //FIN GESTION DES CRITERES
	 //Affichage des AC en lui passant en parametre les statuts concern (2 statuts)
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
	 
	 public void chargeDataRat(){
		 listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
				 new WhereClause("CHECK_TRANS",WhereClause.Comparateur.EQ,"0"),
		         new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
		         multiFiltre ="";
			_logger.info("listeDAO size: "+listeDAO.size());	
			//typeActionTb(); 
	 }
	 
	 //Affichage des AC en lui passant en parametre les statuts concernés(1 statut)
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
	 
	 //Affichage des AC en lui passant en parametre les statuts concernÃ¯Â¿Â½ (1 statut)
	 public void chargeDataAc1(){
		 listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"DAP"),
					new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
		         multiFiltre ="";
			_logger.info("listeDAO size: "+listeDAO.size());	
			typeActionTb(); 
	 }
	 
	 
	 //Affichage des AC en lui passant en parametre les statuts concernÃ¯Â¿Â½ (1 statut)
	 public void chargeDataAc1Filtre(){
		 listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"DAP"),
					new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+statut));
			_logger.info("listeDAO size: "+listeDAO.size());	
	 }
	 //DEBUT AFFICHAGE LISTE DAC DMP
	//Affichage des DMP en lui passant en parametre le statut concerné (1 statut)
	 public void chargeDataDMP1(String typeDac,String typePlan,String stat1,String condition,String valeur){
		 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
				 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
				 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
				 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
				 //new WhereClause(""+condition,WhereClause.Comparateur.EQ,valeur));
				 new WhereClause(""+condition,WhereClause.Comparateur.LIKE,valeur+"%"));
		         multiFiltre ="";
		         _logger.info("colonne: "+condition+" valeur :"+userController.getSlctd().getTFonction().getFonCod());
			_logger.info("listeDAO size: "+listeDAO.size());	
			typeActionTb(); 
	 }
	 
	 
	 public void chargeDataDMP4(){
		 //if(controleController.type == "DAC") {
			 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInInstrValDao("VDacliste", ""+userController.getSlctd().getTFonction().getFonCod());
		/* }else {
			 if(controleController.type == "AMI") {
				 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInInstrValAmi("VDacliste", ""+userController.getSlctd().getTFonction().getFonCod());
			 } 
			 else {
				 if(controleController.type == "PRQ") {
					 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInInstrValPrq("VDacliste", ""+userController.getSlctd().getTFonction().getFonCod()); 
				 } 
			 }
		}*/
		         multiFiltre ="";
		         //_logger.info("colonne: "+condition+" valeur :"+userController.getSlctd().getTFonction().getFonCod());
			_logger.info("listeDAO size: "+listeDAO.size());	
			typeActionTb(); 
	 }
	 
	 

	//Affichage des DMP en lui passant en parametre les statuts concerné (2 statuts)
		 public void chargeDataDMP2(String typeDac,String typePlan,String stat1,String stat2,String condition,String valeur){
			 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
					 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
					 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
					 //new WhereClause(""+condition,WhereClause.Comparateur.EQ,valeur)); 
					 new WhereClause(""+condition,WhereClause.Comparateur.LIKE,valeur+"%"));
			         multiFiltre ="";
			         _logger.info("colonne: "+condition+" valeur :"+valeur);
				_logger.info("listeDAO size: "+listeDAO.size());	
				typeActionTb(); 
		 }
		 
		 public void chargeDataDMP3(String stat1, String stat2, String typeDac, String typePlan){ 	
			 if(controleController.type == "DAC") {
				 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInInstr("VDacliste", ""+userController.getSlctd().getTFonction().getFonCod());
			 }else {
				 if(controleController.type == "AMI") {
					 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInInstrAmi("VDacliste",""+userController.getSlctd().getTFonction().getFonCod());
				 } 
				 else {
					 if(controleController.type == "PRQ") {
						 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInInstrPrq("VDacliste",""+userController.getSlctd().getTFonction().getFonCod()); 
					 } 
				 }
			}
			 
			         multiFiltre ="";
			         //_logger.info("colonne: "+condition+" valeur :"+valeur);
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
									 //chargeDataAc2(typeDac,typePlan,"DAP","DAP");
									 chargeDataAc1();
								 }else {
									 if(fonct.equalsIgnoreCase("listeDaoCorrectionPn")) {
										 chargeDataAc2(typeDac,typePlan,"SBO","SRO");
									 }else { 
										 if(fonct.equalsIgnoreCase("listSaisieRat")) {
											 chargeDataRat();
										 }
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
						 //chargeDataDMP2(typeDac,typePlan,"D2T","D5R","FON_CODE_CSV",userController.getSlctd().getTFonction().getFonCodeCsv());
						 chargeDataDMP2(typeDac,typePlan,"D2T","D5R","FON_CODE_DMP",userController.getSlctd().getTFonction().getFonCod()); 
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							 //chargeDataDMP2(typeDac,typePlan,"D1S","D1R","FON_CODE_SPP",userController.getSlctd().getTFonction().getFonCodeSpp());
							 chargeDataDMP2(typeDac,typePlan,"D1S","D1R","FON_CODE_SPP",userController.getSlctd().getTFonction().getFonCod());
							
						 }else {
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
								 
								//Affichage des differentes listes de l'AC en fonction de l'action								  
								 if(fonct.equalsIgnoreCase("listeAffectationCsv")) {
									 chargeDataDMP3("D2T","D5R","DAO","PN");
								 }else {
									 if(fonct.equalsIgnoreCase("listeValidationCsv")) {
										 chargeDataDMP4();
									 }else 
										 if(fonct.equalsIgnoreCase("listeConsultAffectationCsv")) {
											 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInInstrDejaAff("VDacliste", ""+userController.getSlctd().getTFonction().getFonCod());
									         multiFiltre ="";
											_logger.info("listeDAO size: "+listeDAO.size());	
											typeActionTb(); 
										 }else {
											 if(fonct.equalsIgnoreCase("listeDpubCsv")) {
												 /*String stat1="PUB";
				 									publieListe =(List<VAvisPublie>) iservice.getObjectByColumnInPublicationCsvInstr("VAvisPublie",""+stat1,""+userController.getSlctd().getTFonction().getFonCod());*/
											 }
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
						 //tableauBordController.ChargeTableauBordDac("PN","AMI");
						//Enlever lorsque j'aurai le TB cpmp et DMP
						 tableauBordController.chargeDataDao("PN","AMI");
						 
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
			 String fonct = controleController.getFonctionalite();
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")){
				 if(fonct.equalsIgnoreCase("listeDpubCsv")) {
					 publieListe = (List<VAvisPublie>) iservice.getObjectByColumnInPublicationRechercheCsvInstr("VAvisPublie",""+multiFiltre,""+userController.getSlctd().getTFonction().getFonCod());   
				 } 
			 }
			
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
		 
		 //Rcupration du message
		 public void recupMessage() {
			 //ECRAN DE SAISIE
			   if(controleController.ecran=="saisie") {
				   listeAvis = listeAvis = ((List<TAvisAppelOffre>)iservice.getObjectsByColumn("TAvisAppelOffre",new ArrayList<String>(Arrays.asList("AAO_CODE")),
			 				 new WhereClause("AAO_CODE",Comparateur.EQ,""+newAvis.getAaoCode())));
			   }else
				 //ECRAN DE MODIFICATION
			   {
				   listeAvis = listeAvis = ((List<TAvisAppelOffre>)iservice.getObjectsByColumn("TAvisAppelOffre",new ArrayList<String>(Arrays.asList("AAO_CODE")),
			 				 new WhereClause("AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode())));   
			   }
			 
             if (!listeAvis.isEmpty()) {
            	 sltAvis = listeAvis.get(0);
             }
		 }
		 
		 public void chercher(String typeDac,String typePlan){
			 listeDAO.clear();
			 String fonct = controleController.getFonctionalite();
			 publieListe = (List<VAvisPublie>) iservice.getObjectByColumnInPublicationRechercheCsvInstr("VAvisPublie",""+multiFiltre,""+userController.getSlctd().getTFonction().getFonCod());
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 
				//Affichage des differentes listes de l'AC en faction de l'action
				         //Liste saisie
						 if(fonct.equalsIgnoreCase("listSaisieAc")) {
							 listeDAO.clear(); 
							 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
									 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
									 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
									 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
									 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
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
										 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
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
											 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
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
												 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
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
							 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
					         new WhereClause("LBG_FON_CODE_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("listeDAO size: "+listeDAO.size());
						
					 
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
								 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
								 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
								 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
								 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
							_logger.info("listeDAO size: "+listeDAO.size());
						
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
									 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
									 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
									 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
									 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
								_logger.info("listeDAO size: "+listeDAO.size());
							
						 }else {
							 //Debut Filtre chef de service
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
								 //Filtre affectation
								 if(fonct.equalsIgnoreCase("listeAffectationCsv")) {
									 
							       listeDAO = (List<VDacliste>) iservice.getObjectByColumnInPubRechercheCsvInstr("VDacliste","D2T", "D5R",""+typePlan, 
							    		   ""+multiFiltre,""+userController.getSlctd().getTFonction().getFonCod()); 	 
									/* listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
											 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D2T","D5R")),
											 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
											 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
											 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));*/
										_logger.info("listeDAO size: "+listeDAO.size()); 
								 }else {
									//Filtre validation
									 if(fonct.equalsIgnoreCase("listeValidationCsv")) {
										 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInPubRechercheCsvInstr("VDacliste","D5V", "D5V",
												 ""+typePlan, ""+multiFiltre,""+userController.getSlctd().getTFonction().getFonCod()); 
										/* listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
												 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D5V")),
												 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
												 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
												 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));*/
											_logger.info("listeDAO size: "+listeDAO.size());
									 }else {
										     if(fonct.equalsIgnoreCase("listeAmiCsv") || fonct.equalsIgnoreCase("listePubCsv") || fonct.equalsIgnoreCase("listePubDpsCsv")) {  
										    	 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInPubRechercheCsvInstr("VDacliste","D6V", "DPU",""+typePlan, 
										    			 ""+multiFiltre,""+userController.getSlctd().getTFonction().getFonCod());  
										    	 /*listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
													 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D6V","DPU")),
													 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
													 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
													 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));*/
												_logger.info("listeDAO size: "+listeDAO.size());
										 }else {
											 if(fonct.equalsIgnoreCase("listeDpubCsv")) {
											/*	 publieListe = (List<VAvisPublie>) iservice.getObjectByColumnInPublicationRechercheCsvInstr("VAvisPublie","PUB",
										    			 ""+multiFiltre,""+userController.getSlctd().getTFonction().getFonCod());   
											 }else {*/
												//Autres 
											 }
											 
											   
										 }
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
		 
		 
		 public void chargeDataReaffectation() {
			 listeDAO = (List<VDacliste>) iservice.getObjectByColumnInInstrDejaAff("VDacliste", ""+userController.getSlctd().getTFonction().getFonCod());
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
		 
		  //Charger la liste des pices a examiner par le charge d'etude
			 public void chargePiecesByDao() {
				 listePices= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
							new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));			
			 }
			 
			//Charger la liste des offres du DAO p
			 public void chargeOffresByDao() {
				 offresDao= (List<VPiecesOffreDao>) iservice.getObjectsByColumn("VPiecesOffreDao", new ArrayList<String>(Arrays.asList("OPD_NUM")),
							new WhereClause("OPD_DAC_CODE",WhereClause.Comparateur.EQ,""+updateDac.getDacCode()));			
			 }
			 
			 
			//Charger la liste des pices a examiner par les chargÃ¯Â¿Â½s d'etude
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
							 chargeDaoChargeEtudeByType("PN","D3A","DC2");
						 }else {
							 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
								 chargeDaoChargeEtudeByType("PS","D3A","DC2");
							 }else {
								 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
									 chargeDaoChargeEtudeByType("PN","D3A","DC2");
								 }else {
									 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
										 chargeDaoChargeEtudeByType("PN","D3A","DC2");
									 }
								 }
						     } 
						   }
					}
				 
				 //Liste des Dao affects aux chargs d'etude
				 public void chargeDaoChargeEtudeByType(String typePlan, String stat1,String stat2){
					 daoExamen.clear();
					  daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
							           "DAF_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
							           //new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,""+typeDac),
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
					 chargeDaoChargeEtudeByTypeFilter("PN","D3A","DC2");
				 }else {
					 if(controleController.type == "DAC" && controleController.typePlan == "PS") {
						 chargeDaoChargeEtudeByTypeFilter("PS","D3A","DC2");
					 }else {
						 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
							 chargeDaoChargeEtudeByTypeFilter("PN","D3A","DC2");
						 }else {
							 if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
								 chargeDaoChargeEtudeByTypeFilter("PN","D3A","DC2");
							 }
						 }
				     } 
				   }
			}
		 
				 //Recherche Dao affectÃ¯Â¿Â½es aux chargÃ¯Â¿Â½s d'etude 
				 public void chargeDaoChargeEtudeByTypeFilter(String typePlan, String stat1,String stat2){
					  daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
							           "DAF_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
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
					          new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
						_logger.info("daoPriseCompte size: "+listeDAO.size());	
						typeActionTb();
					  }
					} 
		 
		
		 //Methode de Chargement des Dossiers chez l'AutoritÃ¯Â¿Â½ Contractante
		/*public void chargeDossier() {
		 		 dossListe.clear();
		 			 dossListe = ((List<TDossierDacs>)iservice.getObjectsByColumnDesc("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getDacCode())));			
		 	 } */
		  
		  //Methode de Chargement des Dossiers chez l'AutoritÃ¯Â¿Â½ Contractante
		  public void chargeDossier() {
		 		 dossListe.clear();
		 			 dossListe = ((List<VDossierDac>)iservice.getObjectsByColumnDesc("VDossierDac",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getDacCode())));			
		 	 } 
		  
		//Methode de Chargement des Dossiers chez le Charg d'Etudes
	  /*public void chargeDossierCharge() {
		    	 dossDacListe.clear();
		    	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
		    		 dossDacListe = ((List<TDossierDacs>)iservice.getObjectsByColumnDesc("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTda.getDafDacCode())));	
		    	 }else {
		    		 dossDacListe = ((List<TDossierDacs>)iservice.getObjectsByColumnDesc("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getDacCode())));	 
		    	 } 		
		 	 } */
		  
		//Methode de Chargement des Dossiers chez le Charg d'Etudes
	  public void chargeDossierCharge() {
		    	 dossDacListe.clear();
		    	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
		    		 dossDacListe = ((List<VDossierDac>)iservice.getObjectsByColumnDesc("VDossierDac",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTda.getDafDacCode())));	
		    	 }else {
		    		 dossDacListe = ((List<VDossierDac>)iservice.getObjectsByColumnDesc("VDossierDac",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getDacCode())));	 
		    	 } 		
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
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non slectionne pour le chargement! ","");
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
							dos.setTOperateur(userController.getSlctd().getTOperateur());
							dos.setTFonction(userController.getSlctd().getTFonction());
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
							FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers bien effectu!", "");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						     chargeDossier();
							}else {
								FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistr, charger  nouveau un document ! ","");
								FacesContext.getCurrentInstance().addMessage(null, msg);	
								
							}
						  }
				     }	
		        }
			 
			 
			 
			 public void verifCheckrans() {
				 listCheckTrans = (List<VCheckTransDac>) iservice.getObjectsByColumn("VCheckTransDac", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		 				if (!listCheckTrans.isEmpty()) {
		 					newCheckTrans= listCheckTrans.get(0); 
		 	   	          }
			 }
			 
			 		 
			  @Transactional
				public void upload(FileUploadEvent event) throws java.io.FileNotFoundException { 
				 //condition de chargement d'un document : Nature sélectionnée 
				 if((docNature == null || "".equals(docNature))){
					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sélectionnée pour le chargement! ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
					 
					 }else {
						 
						 verifCheckrans();
						 
						 if(newCheckTrans.getCheckTrans().equalsIgnoreCase("1")) {

								if(fileUploadController.handleFileUpload(event, ""+slctdTd.getDacCode(), docNature)) {
									
									listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
						 				if (!listDao.isEmpty()) {
						 					newDao= listDao.get(0);
						 	   	                 }
									
									int nat = Integer.valueOf(docNature);
									//dos.setDdaNom(keyGen.getCodeDossier(fileUploadController.getFileCode()+"-")); 
									dos.setTDacSpecs(newDao);
									dos.setTOperateur(userController.getSlctd().getTOperateur());
									List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
									TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
									if(!LS.isEmpty()) natureDoc = LS.get(0);
									dos.setTNatureDocuments(natureDoc);
									dos.setDdaNom(fileUploadController.getFileName());
									dos.setDdaDteSaisi(Calendar.getInstance().getTime());
									dos.setTOperateur(userController.getSlctd().getTOperateur());
									dos.setTFonction(userController.getSlctd().getTFonction());
									dos.setDdaReference(fileUploadController.getDocNom());
									iservice.addObject(dos);
									
									//chargeNatureDocTrans();
									chargeDossier();
									
									FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers bien effectué!", "");
									FacesContext.getCurrentInstance().addMessage(null, msg);
								   chargeDossier();
									}else {
										FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger  nouveau un document ! ","");
										FacesContext.getCurrentInstance().addMessage(null, msg);	
										
									}
						 }else {
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,""+newCheckTrans.getCheckTransMsg(),"");
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
				      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez joindre votre fichier ou choisir la mention avant la transmission du DAO", ""));
			        	      }else { 
			        	    	     verifCheckrans();
									 if(newCheckTrans.getCheckTrans().equalsIgnoreCase("1")) {
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
								 						    historiser("D1T",slctdTd.getDacCode(),"");
								 						    //Tableau de Bord
					       			                        tableauBordController.saveTempTabord("D1T", slctdTd.getDacTdCode(), ""+userController.getSlctd().getTFonction().getFonCod(), slctdTd.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), slctdTd.getDacCode());
					       			                         
					       	   	                           } 
					       				
					       					chargeData();
					       					//chargeDaoTabTrans();
					       					//Actualisation du tableau de bord
					       					typeActionTb();
					       					docNature ="";
					       					//Message de confirmation
					       					userController.setTexteMsg("Transmission effectue avec succs!");
					   						userController.setRenderMsg(true);
					   						userController.setSevrityMsg("success");
									 }else {
										 
										 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,""+newCheckTrans.getCheckTransMsg(),"");
											FacesContext.getCurrentInstance().addMessage(null, msg);
									 }
			        	         }
			                  }

		 
		     
		     //Supprimer un dao joint
			  public void removeDossier(){
					downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaReference(), selectedDossier.getDdaReference());
						 iservice.deleteObject(selectedDossier);
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
							 chargeDossierCharge();	 
						 }else {
							 chargeDossier();	 
						 }
					    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDdaReference()+" supprimé!", "");
						FacesContext.getCurrentInstance().addMessage(null, msg);	
					}
		    
		    
		    //Supprimer un dao joint
		    public void removeAutorisation(){
			downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaReference(), selectedDossier.getDdaReference());
				 iservice.deleteObject(selectedDossier);
				 chargeDossierAutorisation();	
				 
			    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDdaReference()+" supprimé!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
			}
		    
		    
		    
		    public void transmettreCpmp() {
		    	
		   		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
		   		    statutTrans  ="D2T";
				 	}
	        	
		   		    
				listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
					       if (!listDao.isEmpty()) {
								newDao= listDao.get(0);
								newDao.setTStatut(new TStatut(statutTrans));
								newDao.setDacStatutRetour("0");
						        iservice.updateObject(newDao); 
				   	                 }
							
				         constantService.getStatut(statutTrans);
	 				    //Historisation du DAC
	 				    historiser(""+statutTrans,slctdTd.getDacCode(),"");
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
		 		String fonct = controleController.getFonctionalite();
		 		if(observation.equalsIgnoreCase("")) {
		 			FacesContext.getCurrentInstance().addMessage(null,
							 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez renseigner le motif, avant de différer!", ""));
		 		}else {
		 			 
			 		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 			 statutUpdate ="";
			 		 }else {
			 			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
			 				 statutUpdate ="D1R";
			 			 }else {
			 				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
			 					
			 					 //statutUpdate ="D2R";
			 					 
			 					 if(fonct.equalsIgnoreCase("listePubCsv")) {
			 						statutUpdate ="D4V";
			 					 }else {
			 						if(fonct.equalsIgnoreCase("listeDpubCsv")) {
				 						statutUpdate ="DPU";
				 					 }else {
				 						      if(fonct.equalsIgnoreCase("listeAffectationCsv")) {
				 						    	 statutUpdate ="D2R";
				 						      }else {
				 						    	        if(fonct.equalsIgnoreCase("listeValidationCsv")) {
				 						    	        	statutUpdate ="D4V";
				 						    	        }
				 						      }
				 					 }
			 					 }
			 				 }
			 		      } 
			 		   }
			 			
			 			listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
			  					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
			  				if (!listDao.isEmpty()) {
			  					newDao= listDao.get(0);
			  					newDao.setTStatut(new TStatut(statutUpdate));
			  					newDao.setDacMotif(observation);
			  					newDao.setDacStatutRetour("1");
			  			        iservice.updateObject(newDao); 
			  	   	                 }
			  				       constantService.getStatut(statutUpdate);
								  	//Historisation du / des retraits
							       historiser(""+statutUpdate,slctdTd.getDacCode(),""+getObservation());
							       
							     tableauBordController.saveTempTabord(""+statutUpdate, slctdTd.getDacTdCode(), ""+userController.getSlctd().getTFonction().getFonCod(), slctdTd.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), slctdTd.getDacCode());
			 					//Message de confirmation
			 					 userController.setTexteMsg("DAC retourné!");
			 					 userController.setRenderMsg(true);
			 					 userController.setSevrityMsg("success");
			 					 //return	null;
			 				  chargeData();
			 		          //Actualisation du Tableau de Bord
			 		          typeActionTb();

			 			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Désolé, votre DAC a été retourné!", "");
			 			 FacesContext.getCurrentInstance().addMessage(null, msg);
		 		}
		 
		 	 }
		 	 
		 	 
		 	 
		 	//DIFFERER PAR LE CHEF DE SERVICE DAO (ACTEUR DGMP - CSV)
			    //Differer
			 	 public void reaffecterCsv() {
			 		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 			 statutUpdate ="";
			 		 }else {
			 			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
			 				 statutUpdate ="D1R";
			 			 }else {
			 				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
			 					 statutUpdate ="D2T";
			 				 }
			 		      } 
			 		   }
			 		 
			 		 
			 		 if (reaffectlisteDAO.size()==0) {
						 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Selectionnez un DAO ", "");
							FacesContext.getCurrentInstance().addMessage(null, msg);
							
						}else {
			 		            //Parcourir la liste de slection reaffectlisteDAO
     		 		           for(VDacliste ligne : reaffectlisteDAO) {
     		 			 
     		 			        //Parcourir la liste de slection et fais les MAJ
     		 		          listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
    			  					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+ligne.getDacCode()));
    			  				        if (!listDao.isEmpty()) {
    			  					          newDao= listDao.get(0);
    			  					          newDao.setTStatut(new TStatut(statutUpdate));
    			  					          newDao.setDacStatutRetour("1");
    			  			                  iservice.updateObject(newDao); 
    			  			            
    			  			                 constantService.getStatut(statutUpdate);
							  	             //Historisation du / des retraits
						                     historiser(""+statutUpdate,slctdTd.getDacCode(),"DAO retrourné");
						                     //Construction  du Tableau Bord
						                     tableauBordController.saveTempTabord(""+statutUpdate, slctdTd.getDacTdCode(), ""+userController.getSlctd().getTFonction().getFonCod(), slctdTd.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), slctdTd.getDacCode());
    			  	   	                 }  
     			 		          }
						  }
			 		 
			 		          //Chargement des DAO  raffecter
			 		          chargeDaoAffectesR();
			 				  //Message
			 				  userController.setTexteMsg("DAC retrourné pour affectation !");
			 				  userController.setRenderMsg(true);
			 				  userController.setSevrityMsg("success");
			 				  chargeData();
			 		          //Actualisation du Tableau de Bord
			 		          typeActionTb();
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
					 
					 
					 //Liste des chargés d'études affectés a un DAC
					 public void chargeChargeEtudeByDac() {
						 listeChargeEtudeByDac = ((List<VChargeEtudeDac>)iservice.getObjectsByColumn("VChargeEtudeDac",
								    new WhereClause("DAF_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())));
								_logger.info("nbre charge d'étude: "+listeChargeEtudeByDac.size());			
					 }
					 
					 public void chargeChargeEtudeByDac1() {
						 listeChargeEtudeByDac = ((List<VChargeEtudeDac>)iservice.getObjectsByColumn("VChargeEtudeDac",
								    new WhereClause("DAF_DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode())));
								_logger.info("nbre charge d'étude: "+listeChargeEtudeByDac.size());			
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
							 //ECRAN DE SAISIE
							   if(controleController.ecran=="saisie") {
								   listeMembre = ((List<VCommissionSpecifique>)iservice.getObjectsByColumn("VCommissionSpecifique",
										    new WhereClause("COM_DAC_CODE",Comparateur.EQ,""+dao.getDacCode())));
										_logger.info("listeMembre size: "+listeMembre.size());	
										
										btn_dao_modif = false;
							   }else
								 //ECRAN DE MODIFICATION
							   {
								   listeMembre = ((List<VCommissionSpecifique>)iservice.getObjectsByColumn("VCommissionSpecifique",
										   //new WhereClause("COM_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()),
										   new WhereClause("COM_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())));
										_logger.info("listeMembre size: "+listeMembre.size());	   
										
										btn_dao_modif = true;
							   } 			
						 }
						 
												 
						// Liste des membres de la commssions de la comission spÃ¯Â¿Â½ciale
						 public void chargeMembresComSpec() {
							 //ECRAN DE SAISIE
							   if(controleController.ecran=="saisie") {
								   listeMembreComSpec = ((List<VCommissionSpecifique>)iservice.getObjectsByColumn("VCommissionSpecifique",
										    new WhereClause("COM_DAC_CODE",Comparateur.EQ,""+dao.getDacCode())));
										_logger.info("listeMembre size: "+listeMembreComSpec.size());	
							   }else
								 //ECRAN DE MODIFICATION
							   {
								   listeMembreComSpec = ((List<VCommissionSpecifique>)iservice.getObjectsByColumn("VCommissionSpecifique",
										    new WhereClause("COM_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())));
										_logger.info("listeMembre size: "+listeMembreComSpec.size());	   
							   }
							 			
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
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Sélectionnez un membre ", "");
								FacesContext.getCurrentInstance().addMessage(null, msg);
							}else {
								
								for(VbCommissionType mbr : selectionMembres) {
									//newDetailSeance.setDcsDteSaisi(Calendar.getInstance().getTime());
									newcomSpec.setComDteSaisi(Calendar.getInstance().getTime());
									newcomSpec.setComTctCode(mbr.getTctCode());
									newcomSpec.setComTctLibelle(mbr.getTctLibelle());
									newcomSpec.setComTctTitre(mbr.getTctTitre());
									newcomSpec.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
									 //ECRAN DE SAISIE
									   if(controleController.ecran=="saisie") {
										   newcomSpec.setComDacCode(dao.getDacCode());
										   newcomSpec.setComAaoCode(newAvis.getAaoCode());
									   }else
										 //ECRAN DE MODIFICATION
									   {
										   newcomSpec.setComDacCode(slctdTd.getDacCode());  
										   newcomSpec.setComAaoCode(slctdTd.getAaoCode());
									   }
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
				 	 
				 	 
				 	  public void recupMembreSpec() {
					 		listeComSpecific = ((List<TCommissionSpecifique>)iservice.getObjectsByColumn("TCommissionSpecifique",
								    new WhereClause("COM_NUM",Comparateur.EQ,""+sltCompsec.getComNum())));
				    			if (!listeComSpecific.isEmpty()) {
				    				comSpecUpdate=listeComSpecific.get(0); 
				    			}
				           }
				 	
				 /*	public void updatePresence() { 
				 		listeComSpecific = ((List<TCommissionSpecifique>)iservice.getObjectsByColumn("TCommissionSpecifique",
							    new WhereClause("COM_NUM",Comparateur.EQ,""+sltCompsec.getComNum()))); 
				 		_logger.info("comNum: "+sltCompsec.getComNum());
			    			if (!listeComSpecific.isEmpty()) {
			    				comSpecUpdate=listeComSpecific.get(0); 
			    				//comSpecUpdate.setComTctLibelle(comSpecUpdate.getComTctLibelle());
			    				_logger.info("comNum: "+comSpecUpdate.getComTctLibelle());
			    				iservice.updateObject(comSpecUpdate);
			    				
					 			chargeMembres();
					 			userController.setTexteMsg("Modification ffectue avec succs!");
			  		            userController.setRenderMsg(true);
			  		            userController.setSevrityMsg("success");
			    			}
				 	}*/
				 	 
				 	public void updatePresence() { 
				 		listeComSpecific = ((List<TCommissionSpecifique>)iservice.getObjectsByColumn("TCommissionSpecifique",
							    new WhereClause("COM_NUM",Comparateur.EQ,""+comSpecUpdate.getComNum()))); 
				 		_logger.info("comNum: "+sltCompsec.getComNum());
			    			if (!listeComSpecific.isEmpty()) {
			    				comUpdate=listeComSpecific.get(0); 
			    				comUpdate.setComTctLibelle(comSpecUpdate.getComTctLibelle());
			    				iservice.updateObject(comUpdate);
			    				
					 			chargeMembres();
					 			userController.setTexteMsg("Modification éffectuée avec succès!");
			  		            userController.setRenderMsg(true);
			  		            userController.setSevrityMsg("success");
			  		            
			  		      	_logger.info("comNum: "+comSpecUpdate.getComTctLibelle());
			    			} 
				 	}
				 	
				 	/*public void updatePresenceComspec() {          
				 		iservice.updateObject(sltCompsec);
				 		chargeMembresComSpec();	
								 userController.setTexteMsg("Modification ffectue avec succs!");
				  		            userController.setRenderMsg(true);
				  		            userController.setSevrityMsg("success");
							}*/
				 	
				 	public void updatePresenceComspec() { 
				 		listeComSpecific = ((List<TCommissionSpecifique>)iservice.getObjectsByColumn("TCommissionSpecifique",
							    new WhereClause("COM_NUM",Comparateur.EQ,""+comSpecUpdate.getComNum()))); 
				 		_logger.info("comNum: "+sltCompsec.getComNum());
			    			if (!listeComSpecific.isEmpty()) {
			    				comUpdate=listeComSpecific.get(0); 
			    				comUpdate.setComTctLibelle(comSpecUpdate.getComTctLibelle());
			    				iservice.updateObject(comUpdate);
					 			//chargeMembres();
			    				chargeMembresComSpec();
					 			userController.setTexteMsg("Modification éffectuée avec succès!");
			  		            userController.setRenderMsg(true);
			  		            userController.setSevrityMsg("success");
			  		            
			  		      	_logger.info("comNum: "+comSpecUpdate.getComTctLibelle());
			    			} 
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
									 //ECRAN DE SAISIE
									   if(controleController.ecran=="saisie") {
										   newcomSpec.setComDacCode(dao.getDacCode());
									   }else
										 //ECRAN DE MODIFICATION
									   {
										   newcomSpec.setComDacCode(slctdTd.getDacCode());   
									   }
									
									newcomSpec.setComStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
									newcomSpec.setComTcoCode("COJ");
									iservice.addObject(newcomSpec);
								}
								//chargeExpert();
								chargeMembres();
								
								userController.setTexteMsg("Expert(s) enregistr(s) avec succs!");
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
									 //ECRAN DE SAISIE
									   if(controleController.ecran=="saisie") {
										   newcomSpec.setComDacCode(dao.getDacCode());
									   }else
										 //ECRAN DE MODIFICATION
									   {
										   newcomSpec.setComDacCode(slctdTd.getDacCode());  
									   }
									
									newcomSpec.setComStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
									newcomSpec.setComTcoCode("COJ");
									iservice.addObject(newcomSpec);
									norm = false; 
									spec = true; 
									comboboxCom = false;
									btn_dao = true;
								}
								//chargeExpert();
								chargeMembresComSpec();
								userController.setTexteMsg("Ressource ajoute avec succs!");
			  		            userController.setRenderMsg(true);
			  		            userController.setSevrityMsg("success");
								
								//btn_save_presence = false;
								//btn_save_expert = false;
								panelMbr = false;
								panelExpert = true;
								btn_dao = true;
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
				 	
				 	
				 	public void removePieceModif() {
				 		listePiecesDac = (List<TPiecesDacs>) iservice.getObjectsByColumn("TPiecesDacs", new ArrayList<String>(Arrays.asList("PID_CODE")),
		    					new WhereClause("PID_CODE",WhereClause.Comparateur.EQ,""+sltPiecesDac.getPidCode()));
		        	       if (!listePiecesDac.isEmpty()) {
		        	    	   pieceDac = listePiecesDac.get(0);
		        	       }
		        	       iservice.deleteObject(getPieceDac());
		        	       chargePiecesDao();
						   //new FacesMessage(FacesMessage.SEVERITY_WARN,"Suppression éffectuée avec succès", "");
						   FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Suppression éffectuée avec succès!", "");
							FacesContext.getCurrentInstance().addMessage(null, msg);
				 	}
		 		 
	//Statistiques pour le chargÃ¯Â¿Â½ d'Etudes
			
			 
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
		    		 ouvertureAmi=false;
				 }else {
					 ouverture = false;
					 ouvertureAmi=true;
				   }

		     }
		 
			 
			 
			  //Premier enregistrement DAC en fonction du type et du plan
			    public void saveDao(){	
			    	 if(controleController.type == "DAC") {
			    		 saveDac("DAO");	
					 }else { 
							 if(controleController.type == "AMI") {
								 saveDac("AMI");
							 }else {
								 if(controleController.type == "PRQ") {
									 saveDac("PRQ");
								 }
							 }
					   }
			     }
			    
			    
			    //chargement du message de la marge de prfrence sous-traitance
			   /* public void chargeMsgMarge() {
			    	listeMarge.clear();
			    	listeMarge =(List<VMargeDePreference>) iservice.getObjectsByColumn("VMargeDePreference", new ArrayList<String>(Arrays.asList("ID")));
					if (!listeMarge.isEmpty()) {
						marge=listeMarge.get(0);
					}	
			    }*/
			    
			  //chargement du message de la marge de prfrence sous-traitance
			    public void chargeMsgMarge() {
			    	//listeMargeSou.clear();
			    	listeMargeSou =(List<VMargeDePreferenceSou>) iservice.getObjectsByColumn("VMargeDePreferenceSou", new ArrayList<String>(Arrays.asList("ID")));
					if (!listeMargeSou.isEmpty()) {
						margeSou=listeMargeSou.get(0);
					}	
			    }
			    
			  //chargement du message de la marge de prfrence communautaire
			    public void chargeMsgMargeCom() {
			    	//listeMargeCom.clear();
			    	listeMargeCom =(List<VMargeDePreferenceCom>) iservice.getObjectsByColumn("VMargeDePreferenceCom", new ArrayList<String>(Arrays.asList("ID")));
					if (!listeMargeCom.isEmpty()) {
						margeCom=listeMargeCom.get(0);
					}	
			    }
			    
			  //chargement du message de la marge de prfrence artisan
			    public void chargeMsgMargeArt() {
			    	listeMargeArt.clear();
			    	listeMargeArt =(List<VMargeDePreferenceArt>) iservice.getObjectsByColumn("VMargeDePreferenceArt", new ArrayList<String>(Arrays.asList("ID")));
					if (!listeMargeArt.isEmpty()) {
						margeArt=listeMargeArt.get(0);
					}	
			    }
		   
			    
			    //Rcupration de la mention Ano Bailleur depuis le PPM slectionn
			    public void recupDetail() {
				     if(daoDetail.getDppStatutAno().equalsIgnoreCase("O") && daoDetail.getDppBailleur().equalsIgnoreCase("O")) {
				    	 newAvis.aaoAvisBai = "O";
				     }
				     else 
				     {
				    	 newAvis.aaoAvisBai = "N";   
				     }	
				     
				     _logger.info("Ano Bailleur ou National : "+newAvis.aaoAvisBai);
			    }
			   //Fin de Rcupration de la mention Ano Bailleur depuis le PPM slectionn 
			    
			    
		//Initiation du DAO en procdure normale 
	     @Transactional
	     public void saveDac(String typeDac) {
	    	 if(daoDetail.getTymCode().equalsIgnoreCase("") || "".equals(daoDetail.getTymCode()) || daoDetail.getMopCode().equalsIgnoreCase("") || "".equalsIgnoreCase(daoDetail.getMopCode()) 
	    			 || daoDetail.getDppObjet().equalsIgnoreCase("") || "".equals(daoDetail.getDppObjet()) || dao.getDacFinancement().equalsIgnoreCase("") ) {
	    		 //Message d'Erreur
	    		 FacesContext.getCurrentInstance().addMessage(null,
		         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez sélectionnez votre PPM, puis faites OK!", ""));
	    	 }else 
		 			    //Insertion des pices constitutives du DAO 
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
		 				        /* 
		 				    	 listeDetail =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
		 									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+daoDetail.getDppId()));
		 								if (!listeDetail.isEmpty()) {
		 									demDetail= listeDetail.get(0);
		 									demDetail.setDppStatutDao("O");
		 									demDetail.setTDacSpecs(new TDacSpecs(dao.getDacCode()));
		 									iservice.updateObject(demDetail);
		 							      }*/
		 								
		 						 for(VPpmDao vdao  : listSelectionPpmDao) {
		 							 listeDetail =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
			 									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+vdao.getDppId()));
		 							      if (!listeDetail.isEmpty()) {
		 								     demDetail= listeDetail.get(0);
	 									     demDetail.setDppStatutDao("O");
	 									     demDetail.setTDacSpecs(new TDacSpecs(dao.getDacCode()));
	 									     iservice.updateObject(demDetail);
		 							   }
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
		 						     
		 						     userController.setTexteMsg(typeDac+" N° "+dao.getDacCode()+" Initié avec succès!");
		 							 userController.setRenderMsg(true);
		 							 userController.setSevrityMsg("success");
		 							 
		 							 newAvis.aaoLibelle = dao.getDacObjet();
		 							 aaoNbrOuv = daoDetail.getDppNbOuv();
		 							 //Dsactivation du bouton d'enregistrement du DAO
		 							 controleController.btn_dao_pn = false;
		 							 pavet_infoG = true;
		 							 //Activation du Bouton d'enregistrement d'un Avis d'Appel d'Offres
		 							  btn_save_avis = true;
		 							  
		 							  verifOuverture();
		 							  chargeImputation();
		 							  recupDetail();
		 							  choixTaux = "N";
		 							  newAvis.aaoOffAnormal = "N";
		 							  //listeMarge();
		 							  
		 							  //Création de l'avis de l'Appel d'Offresva
		 							   newAvis.setAaoCode(keyGen.getCodeAvis());
				            	       newAvis.setTDacSpecs(dao);
				            	       newAvis.setTStatut(new TStatut("D1S")); 
				            	       newAvis.setAvisRetour("0");
				            	       newAvis.setAaoDteSaisi(Calendar.getInstance().getTime()); 
				            	       newAvis.setFonCodAc(userController.getSlctd().getTFonction().getFonCod());
				            	       iservice.addObject(newAvis); 
				                       //Contrôle sur le mode de qualification et chargement des libellés de référence 
				            	       controleMode();
				            	       chargeLibelleAdresse();
		 			      }
			          }
	     
	     //Contrôle sur le mode de qualification
	     public void controleMode() {
	    	 if(dao.getTTypeMarche().getTymCode().equalsIgnoreCase("00") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("20") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("F") || 
	    			 dao.getTTypeMarche().getTymCode().equalsIgnoreCase("32") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("T") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("21")||
	    			 dao.getTTypeMarche().getTymCode().equalsIgnoreCase("22") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("09")) {
	    		 aaoRegQual = "CONFORMITE";
	    		 
	    	 }else {
	    		    if(dao.getTTypeMarche().getTymCode().equalsIgnoreCase("11") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("10") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("1") || 
		    			 dao.getTTypeMarche().getTymCode().equalsIgnoreCase("I") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("31") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("41") ||
		    			 dao.getTTypeMarche().getTymCode().equalsIgnoreCase("17") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("16") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("12") ||
		    			 dao.getTTypeMarche().getTymCode().equalsIgnoreCase("19") || dao.getTTypeMarche().getTymCode().equalsIgnoreCase("13")) {
	    		    	aaoRegQual = "SCORE";
		    	 }else {
		    		 aaoRegQual = "AUTRE";
		    	 } 
	    	 }
	     }
	     
	     
	   //Contrôle sur le mode de qualification
	     public void controleModeModif() {
	    	 if(slctdTd.getDacTymCode().equalsIgnoreCase("00") || slctdTd.getDacTymCode().equalsIgnoreCase("20") || slctdTd.getDacTymCode().equalsIgnoreCase("F") || 
	    			 slctdTd.getDacTymCode().equalsIgnoreCase("32") || slctdTd.getDacTymCode().equalsIgnoreCase("T") || slctdTd.getDacTymCode().equalsIgnoreCase("21")||
	    			 slctdTd.getDacTymCode().equalsIgnoreCase("22") || slctdTd.getDacTymCode().equalsIgnoreCase("09")) {
	    		 aaoRegQual = "CONFORMITE";
	    		 
	    	 }else {
	    		    if(slctdTd.getDacTymCode().equalsIgnoreCase("11") || slctdTd.getDacTymCode().equalsIgnoreCase("10") || slctdTd.getDacTymCode().equalsIgnoreCase("1") || 
	    		    		slctdTd.getDacTymCode().equalsIgnoreCase("I") || slctdTd.getDacTymCode().equalsIgnoreCase("31") || slctdTd.getDacTymCode().equalsIgnoreCase("41") ||
	    		    		slctdTd.getDacTymCode().equalsIgnoreCase("17") || slctdTd.getDacTymCode().equalsIgnoreCase("16") || slctdTd.getDacTymCode().equalsIgnoreCase("12") ||
		    			 dao.getTTypeMarche().getTymCode().equalsIgnoreCase("19") || slctdTd.getDacTymCode().equalsIgnoreCase("13")) {
	    		    	aaoRegQual = "SCORE";
		    	 }else {
		    		 aaoRegQual = "AUTRE";
		    	 } 
	    	 }
	     }
	     
	 	//Initiation du DAO en procdure normale 
	     @Transactional
	     public void updateDac() { 
	    	 
	    	   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
			       if (!listDao.isEmpty()) {
			    	      dao = listDao.get(0);
			    	      dao.setDacDteSaisi(Calendar.getInstance().getTime());
			 			  dao.setDacObjet(slctdTd.getDacObjet());
			 			  dao.setTModePassation(new TModePassation(slctdTd.getMopCode()));
			 			  dao.setTTypeMarche(new TTypeMarche(slctdTd.getDacTymCode()));
			 			  dao.setTModeleDacType(new TModeleDacType(""+slctdTd.getDppPieceDao()));
			 			  dao.setDacFinancement(slctdTd.getDacFinancement());
			    	      iservice.updateObject(dao);
			    	      
			    	      //Recherche
			             String search = slctdTd.getDacObjet();
			 	         String rechercheAll = search.replace("null","");
			 		 	 dao.setDacRecherche(rechercheAll);
			 		 	 iservice.updateObject(dao);
			 		 	 
			 		 	 //Message de confirmation
			 		 	  userController.setTexteMsg("Dossier d'Appel à la Concurrence modifié avec succès!");
			 	          userController.setRenderMsg(true);
			 	          userController.setSevrityMsg("success");
			            }	
	    	 /*
	    	 List<TDacSpecs> LS  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
	    	 TDacSpecs dao = new TDacSpecs(); 
			 if(!LS.isEmpty()) dao = LS.get(0);
			 dao.setDacDteSaisi(Calendar.getInstance().getTime());
			 dao.setDacObjet(slctdTd.getDacObjet());
			 dao.setTModePassation(new TModePassation(slctdTd.getMopCode()));
			 dao.setTTypeMarche(new TTypeMarche(slctdTd.getDacTymCode()));
			 dao.setTModeleDacType(new TModeleDacType(""+slctdTd.getDppPieceDao()));
			 dao.setDacFinancement(slctdTd.getDacFinancement());
			 iservice.updateObject(dao);

             //Recherche
             String search = slctdTd.getDacObjet();
	         String rechercheAll = search.replace("null","");
		 	 dao.setDacRecherche(rechercheAll);
		 	 iservice.updateObject(dao);
		 	 
		 	 //Message de confirmation
		 	  userController.setTexteMsg("Dossier d'Appel à la Concurrence modifié avec succès!");
	          userController.setRenderMsg(true);
	          userController.setSevrityMsg("success");*/
			 }
	    	        
	    	//Dans le  cas ou le DAC n'a pas été modifié
	      public void infoDao() {
	     listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		       if (!listDao.isEmpty()) {
		    	      dao = listDao.get(0);
		        }
		     }
	      
	      public void actualisationDac() {
	    	  listeDAO= (List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
	 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
	 		       if (!listeDAO.isEmpty()) {
	 		    	  slctdTd = listeDAO.get(0);
	 		        }
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
		 
		 
	
		 //Cration du Tableau de Bord AC
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
		 
		 //Cration du Tableau de Bord 
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
	   	 //Cration de l'Avis
		 
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
			 if(nbreDelai < 30 || nbreDelai > 180) {
				 _logger.info(""+nbreDelai);
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le délai de validité doit etre compris entre 30 et 180 jours ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);
			 }else
			 {
				 _logger.info(""+nbreDelai);
			 }
		 }
		 
		/* 
		 public void controlDealaiModif() {
			 if(nbreDelai < 30 || slctdTd.getAaoDelaiVal() > 180) {
				 _logger.info(""+slctdTd.getAaoDelaiVal());
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le délai de validité doit etre compris entre 30 et 180 jours ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);
			 }else
			 {
				 _logger.info(""+slctdTd.getAaoDelaiVal());
			 }
		 }*/
		 
		 public void recupInfo() {
			  aaoLibelle = slctdTd.getAaoLibelle();
			  aaoHeureRecep=slctdTd.getAaoHeureRecep(); 
 		      aaoCoutDac = slctdTd.getAaoCoutDac() ;
 		      aaoNatPrix = slctdTd.getAaoNatPrix() ;
 		      aaoRegQual = slctdTd.getAaoRegQual();
 		      aaoDateRecep = slctdTd.getAaoDateRecep(); 
 		      aaoDteHeurOuv = slctdTd.getAaoDteHeurOuv() ; 
 		      aaoLieuRecep= slctdTd.getAaoLieuRecep();
 		      aaoNbrOuv = slctdTd.getAaoNbrOuv(); 
 		      aaoPrecisModEval = slctdTd.getAaoPrecisModEval();  
 		      aaoAvisBai= slctdTd.getAaoAvisBai();
 		      aaoRespBai= slctdTd.getAaoRespBai();
 		      aaoOffAnormal= slctdTd.getAaoOffAnormal();
 		      lotNbre = slctdTd.getAaoNbrLot();
 		      nbreDelai = slctdTd.getAaoDelaiVal();
 		      ouvFin = slctdTd.getAaoDteOuvFin();
 		      ouvTech = slctdTd.getAaoDteOuvTec();
 		      aaoLieuExe = slctdTd.getAaoLieuExe();
 		      adaNum   = slctdTd.getAdaNum();
 		      value1 = slctdTd.getAaoNatInt();
 		      choixTaux = slctdTd.getDacMargePref();
 		      dacNbrCopieOff = dao.getDacNbrCopieOff();
 		      
 		     _logger.info("aaoLibelle: "+aaoLibelle);	
 		     _logger.info("aaoHeureRecep: "+aaoHeureRecep);	
 		     _logger.info("Coût du DAC: "+aaoCoutDac);	
 		     _logger.info("Nature des Prix: "+aaoNatPrix);	
 		     _logger.info("Mode de qualification: "+aaoRegQual);	
 		     _logger.info("Date de recetion: "+aaoDateRecep);	
 		     _logger.info("Heure de recption: "+aaoDteHeurOuv);
 		     _logger.info("Lieu de reception: "+aaoLieuRecep);	
 		     _logger.info("Nbre Ouverture: "+aaoNbrOuv);	
 		     _logger.info("Avis du Bailleur: "+aaoAvisBai);	
 		     _logger.info("Responsable des bailleurs: "+aaoRespBai);
 		     _logger.info("aaoOffAnormal: "+aaoOffAnormal);	
 		     _logger.info("lotNbre: "+lotNbre);	
 		    _logger.info("nbreDelai: "+nbreDelai);	
 		    _logger.info("ouvFin: "+ouvFin);	
 		    _logger.info("ouvTech: "+ouvTech);	
 		    _logger.info("aaoLieuExe: "+aaoLieuExe);
 		    _logger.info("adaNum: "+adaNum);
 		    _logger.info("value1: "+value1);
 		   _logger.info("choixTaux : "+choixTaux );
 		  _logger.info("Nbre de copies : "+dacNbrCopieOff);
		 }
		 
	        @Transactional
	        public void saveAao(String typePlan ,String typeDac) {
	        	
	        	if(newAvis.getAaoLibelle().equalsIgnoreCase("") || newAvis.getAaoCoutDac() < 0 || lotNbre == 0 || 
	        		 nbreDelai == 0 ) { 
	        		
	        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir tous les champs obligatoires! ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);
	        		
	        	    }else {
	        	    	    if(nbreDelai < 30 || nbreDelai > 180) {
         	 				    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le délai de validité doit etre compris entre 30 et 180 jours ","");
         	 					FacesContext.getCurrentInstance().addMessage(null, msg);
         	 			      }else {
         	 			    	avisTab = (List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DAC_CODE")),
        	        					new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
        	            	       if (!avisTab.isEmpty()) {
        	            	    	       newAvis = avisTab.get(0);
        	            	 				      if(lotNbre == 0) {
        	            	 					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le nombre de lot doit être superieur à 0 ","");
        		            	 					FacesContext.getCurrentInstance().addMessage(null, msg); 
        	            	 				       }else
        	            	 				       {
        	            	 				    	   
        	            	          		      newAvis.setTAdresseAvis(new TAdresseAvis(numDetailAdr)); 
        	            	          		      if(newAvis.aaoNbrOuv == 1) {
        	            	            		  newAvis.setAaoDteOuvFin(ouvTech);
        	              	          		      newAvis.setAaoDteOuvTec(ouvTech);
        	            	            		  }else {
        	            	            		  newAvis.setAaoDteOuvFin(ouvFin);
        	                	          		  newAvis.setAaoDteOuvTec(ouvTech);
        	            	            		  }
        	            	          		      newAvis.setAaoHeureRecep(aaoHeureRecep);
        	            	          		      newAvis.setAaoCoutDac(aaoCoutDac);
        	            	          		      newAvis.setAaoNatPrix(aaoNatPrix);
        	            	          		      newAvis.setAaoRegQual(aaoRegQual);
        	            	          		      newAvis.setAaoDateRecep(aaoDateRecep);
        	            	          		      newAvis.setAaoDteHeurOuv(aaoDteHeurOuv);
        	            	          		      newAvis.setAaoLieuRecep(aaoLieuRecep);
        	            	          		      newAvis.setAaoNbrOuv(aaoNbrOuv);
        	            	          		      newAvis.setAaoPrecisModEval(aaoPrecisModEval); 
        	            	          		      newAvis.setAaoAvisBail(aaoAvisBai);
        	            	          		      newAvis.setAaoRespBai(aaoRespBai);
        	            	          		      newAvis.setAaoOffAnormal(aaoOffAnormal);
        	            	          		      //newAvis.setAaoLieuExe(aaoLieuExe);
        										  newAvis.setAaoNatInt(value1);
        										  newAvis.setAaoDelaiVal(nbreDelai);
        										  newAvis.setAaoNbrLot(lotNbre);
        	            	          		      iservice.updateObject(newAvis); 
        	            	          		      
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
        	            	          		            userController.setTexteMsg("Avis d'Appel d'Offres crée avec succès!");
        	            	          		            userController.setRenderMsg(true);
        	            	          		            userController.setSevrityMsg("success");
        	            	          		            
        	            	          		        //Dsactivation du bouton enregistrerAvis
        	                	     				    btn_save_avis =false;
        	                	     				//Activation du bouton d'enregistrement des offres
        	                	     				    btn_save_offre = true;
                       	     				    //Activation du pavet pour la saisie des lots
        	                	     		            pavet_lot = true;	 
        	                	     		            
        	                	     		           newLot.laaMtCaut = mtCaut; 
        	                					       newLot.laaMtEst = mtEstimR;

        	            	 				 } 
        	            	 			 
        	            	    	      
        	            	           }else {
        	            	        	      /* userController.setTexteMsg("Veuillez saisir les informations sur le DAC avant la saisie des informations générales!");
           	          		                    userController.setRenderMsg(true);
           	          		                    userController.setSevrityMsg("success");*/
           	          		               FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir les informations sur le DAC avant la saisie des informations générales! ","");
                   	 					   FacesContext.getCurrentInstance().addMessage(null, msg); 
        	            	           }
         	 			      }
	        	            } 
	                     }
	        
		/* @Transactional
	        public void saveAao(String typePlan ,String typeDac) {
	        	
	        	if(newAvis.getAaoLibelle().equalsIgnoreCase("") || newAvis.getAaoCoutDac() < 0 || newAvis.getAaoNbrLot() == 0 || 
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
				            	 				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le délai de validité doit être compris entre 30 et 180 jours ","");
				            	 					FacesContext.getCurrentInstance().addMessage(null, msg);
				            	 			 }else {
				            	 				 if(newAvis.getAaoNbrLot()==0) {
				            	 					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le nombre de lot doit être superieur à 0 ","");
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
				            	          		      newAvis.setAaoDelaiVal(nbreDelai);
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
				            	          		            userController.setTexteMsg("Avis d'Appel d'Offres crée avec succès!");
				            	          		            userController.setRenderMsg(true);
				            	          		            userController.setSevrityMsg("success");
				            	          		            
				            	          		        //Dsactivation du bouton enregistrerAvis
				                	     				    btn_save_avis =false;
				                	     				//Activation du bouton d'enregistrement des offres
				                	     				    btn_save_offre = true;
			                	     				    //Activation du pavet pour la saisie des lots
				                	     		         pavet_lot = true;	 
				            	 				 }
				            	 				 
				            	 			 }
	            	                  }
	        	                   } 
	                     }*/
	        
	        @Transactional
	        public void updateAao() {
	        	List<TAvisAppelOffre> AVIS  = iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
	        	TAvisAppelOffre newAvis = new TAvisAppelOffre(); 
			    if(!AVIS.isEmpty()) newAvis = AVIS.get(0);
				            	 					
				newAvis.setAaoLibelle(slctdTd.getAaoLibelle());
				newAvis.setAaoNatPrix(slctdTd.getAaoNatPrix());
			    newAvis.setAaoRegQual(slctdTd.getAaoRegQual());
			    newAvis.setAaoAvisBai(slctdTd.getAaoAvisBai());
				newAvis.setAaoRespBai(slctdTd.getAaoRespBai());
				newAvis.setAaoOffAnormal(slctdTd.getAaoOffAnormal());
				newAvis.setAaoDelaiVal(nbreDelai);
				newAvis.setAaoPrecisModEval(slctdTd.getAaoPrecisModEval());
				newAvis.setAaoNbrLot(slctdTd.getAaoNbrLot());
				newAvis.setAaoLieuRecep(slctdTd.getAaoLieuRecep());
				newAvis.setAaoHeureRecep(slctdTd.getAaoHeureRecep());
				newAvis.setAaoNbrOuv(slctdTd.getAaoNbrOuv());
				newAvis.setAaoLieuExe(slctdTd.getAaoLieuExe());
				newAvis.setAaoDteOuvTec(slctdTd.getAaoDteOuvTec());
				newAvis.setAaoDteHeurOuv(slctdTd.getAaoDteHeurOuv());
				newAvis.setAaoDteFinOuv(slctdTd.getAaoDteOuvFin());
			    newAvis.setTAdresseAvis(new TAdresseAvis(slctdTd.getAdaNum())); 
				newAvis.setAaoNatInt(slctdTd.getAaoNatInt());
				iservice.updateObject(newAvis); 
				            	          		      
			    List<TDacSpecs> LS  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
				TDacSpecs dao = new TDacSpecs(); 
				if(!LS.isEmpty()) dao = LS.get(0);
			    dao.setDacNbrCopieOff(slctdTd.getDacNbrCopieOff());
				dao.setDacMargePref(slctdTd.getDacMargePref());
				iservice.updateObject(dao);
				            	         
				userController.setTexteMsg("Avis d'Appel d'Offres crée avec succès!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");          	
	                     }
	        
	        
	        
	        //Mis à jour de l'avis d'appel d'Offres
	        public void aaoModif() {
	        	avisTab = (List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DAC_CODE")),
    					new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
        	       if (!avisTab.isEmpty()) {
        	    	       newAvis = avisTab.get(0);
        	    	       
        	    	      newAvis.setTAdresseAvis(new TAdresseAvis(adaNum)); 
 	          		      if(newAvis.aaoNbrOuv == 1) {
 	            		  newAvis.setAaoDteOuvFin(ouvTech);
   	          		      newAvis.setAaoDteOuvTec(ouvTech);
 	            		  }else {
 	            		  newAvis.setAaoDteOuvFin(ouvFin);
     	          		  newAvis.setAaoDteOuvTec(ouvTech);
 	            		  }
 	          		      newAvis.setAaoLibelle(aaoLibelle);
 	          		      newAvis.setAaoHeureRecep(aaoHeureRecep);
 	          		      newAvis.setAaoCoutDac(aaoCoutDac);
 	          		      newAvis.setAaoNatPrix(aaoNatPrix);
 	          		      newAvis.setAaoRegQual(aaoRegQual);
 	          		      newAvis.setAaoDateRecep(aaoDateRecep);
 	          		      newAvis.setAaoDteHeurOuv(aaoDteHeurOuv);
 	          		      newAvis.setAaoLieuRecep(aaoLieuRecep);
 	          		      newAvis.setAaoNbrOuv(aaoNbrOuv);
 	          		      newAvis.setAaoPrecisModEval(aaoPrecisModEval); 
 	          		      newAvis.setAaoAvisBail(aaoAvisBai);
 	          		      newAvis.setAaoRespBai(aaoRespBai);
 	          		      newAvis.setAaoOffAnormal(aaoOffAnormal);
 	          		      newAvis.setAaoLieuExe(aaoLieuExe);
						  newAvis.setAaoNatInt(value1);
						  newAvis.setAaoDelaiVal(nbreDelai);
						  newAvis.setAaoNbrLot(lotNbre);
 	          		      iservice.updateObject(newAvis);
 	          		      //Mis à jour dans T_DAC_SPECS
 	          		     listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
 	   	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
 	   	     				       if (!listDao.isEmpty()) {
 	   	     					    newDao= listDao.get(0);
 	   	     					    newDao.setDacCout(newAvis.getAaoCoutDac());
 	   	     					    newDao.setDacNbrCopieOff(dacNbrCopieOff);
 	   	     			            iservice.updateObject(newDao); 
 	   	     	   	                 }
             	         //Message de confirmation
 	     				userController.setTexteMsg("Avis d'Appel d'Offres modifié avec succès!");
 	     				userController.setRenderMsg(true);
 	     				userController.setSevrityMsg("success");   
        	       }else {
        	    	   
        	    	      newAvis.setAaoCode(keyGen.getCodeAvis());
	            	      newAvis.setTDacSpecs(dao);
	            	      newAvis.setAaoLibelle(aaoLibelle);
        	    	      newAvis.setTAdresseAvis(new TAdresseAvis(adaNum)); 
	          		      if(slctdTd.getAaoNbrOuv() == 1) {
	            		  newAvis.setAaoDteOuvFin(ouvTech);
	          		      newAvis.setAaoDteOuvTec(ouvTech);
	            		  }else {
	            		  newAvis.setAaoDteOuvFin(ouvFin);
  	          		      newAvis.setAaoDteOuvTec(ouvTech);
	            		  }
	          		      newAvis.setAaoHeureRecep(aaoHeureRecep);
	          		      newAvis.setAaoCoutDac(aaoCoutDac);
	          		      newAvis.setAaoNatPrix(aaoNatPrix);
	          		      newAvis.setAaoRegQual(aaoRegQual);
	          		      newAvis.setAaoDateRecep(aaoDateRecep);
	          		      newAvis.setAaoDteHeurOuv(aaoDteHeurOuv);
	          		      newAvis.setAaoLieuRecep(aaoLieuRecep);
	          		      newAvis.setAaoNbrOuv(aaoNbrOuv);
	          		      newAvis.setAaoPrecisModEval(aaoPrecisModEval); 
	          		      newAvis.setAaoAvisBail(aaoAvisBai);
	          		      newAvis.setAaoRespBai(aaoRespBai);
	          		      newAvis.setAaoOffAnormal(aaoOffAnormal);
	          		      newAvis.setAaoLieuExe(aaoLieuExe);
						  newAvis.setAaoNatInt(value1);
						  newAvis.setAaoDelaiVal(nbreDelai);
						  newAvis.setAaoNbrLot(lotNbre);
						  newAvis.setTStatut(new TStatut("D1S")); 
	            	      newAvis.setAvisRetour("0");
	            	      newAvis.setAaoDteSaisi(Calendar.getInstance().getTime()); 
	            	      newAvis.setFonCodAc(userController.getSlctd().getTFonction().getFonCod()); 
	          		      iservice.addObject(newAvis);
	          		      //Mis à jour dans T_Dac_Specs
	          		    listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
   	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
   	     				   if (!listDao.isEmpty()) {
   	     					    newDao= listDao.get(0);
   	     					    newDao.setDacCout(newAvis.getAaoCoutDac());
   	     					    newDao.setDacNbrCopieOff(dacNbrCopieOff);
   	     			            iservice.updateObject(newDao); 
   	     	   	                 }
	          		      //Rafraichissement de VDacliste
	          		      actualiseVue();
	          		     //Message de confirmation
	          		     userController.setTexteMsg("Avis d'Appel d'Offres modifié avec succès!");
 	     				 userController.setRenderMsg(true);
 	     				 userController.setSevrityMsg("success");  
        	       }
	        }
	        
	        
	        //Mis à jour de l'avis d'appel d'Offres
	        public void aaoModifRat() {
	        	avisTab = (List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DAC_CODE")),
    					new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
        	       if (!avisTab.isEmpty()) {
        	    	       newAvis = avisTab.get(0);
        	    	       
        	    	      newAvis.setTAdresseAvis(new TAdresseAvis(adaNum)); 
 	          		      if(newAvis.aaoNbrOuv == 1) {
 	            		  newAvis.setAaoDteOuvFin(ouvTech);
   	          		      newAvis.setAaoDteOuvTec(ouvTech);
 	            		  }else {
 	            		  newAvis.setAaoDteOuvFin(ouvFin);
     	          		  newAvis.setAaoDteOuvTec(ouvTech);
 	            		  }
 	          		      newAvis.setAaoLibelle(aaoLibelle);
 	          		      newAvis.setAaoHeureRecep(aaoHeureRecep);
 	          		      newAvis.setAaoCoutDac(aaoCoutDac);
 	          		      newAvis.setAaoNatPrix(aaoNatPrix);
 	          		      newAvis.setAaoRegQual(aaoRegQual);
 	          		      newAvis.setAaoDateRecep(aaoDateRecep);
 	          		      newAvis.setAaoDteHeurOuv(aaoDteHeurOuv);
 	          		      newAvis.setAaoLieuRecep(aaoLieuRecep);
 	          		      newAvis.setAaoNbrOuv(aaoNbrOuv);
 	          		      newAvis.setAaoPrecisModEval(aaoPrecisModEval); 
 	          		      newAvis.setAaoAvisBail(aaoAvisBai);
 	          		      newAvis.setAaoRespBai(aaoRespBai);
 	          		      newAvis.setAaoOffAnormal(aaoOffAnormal);
 	          		     if(newAvis.getTStatut().getStaCode().equalsIgnoreCase("DPU") || newAvis.getTStatut().getStaCode().equalsIgnoreCase("DAP") || 
 	          				newAvis.getTStatut().getStaCode().equalsIgnoreCase("DVE")) {
 								  newAvis.setTStatut(new TStatut("APU")); 
 							  }else {
 								  newAvis.setTStatut(new TStatut("D1S")); 
 							  }
 	          		      newAvis.setAaoLieuExe(aaoLieuExe);
						  newAvis.setAaoNatInt(value1);
						  newAvis.setAaoDelaiVal(nbreDelai);
						  newAvis.setAaoNbrLot(lotNbre);
 	          		      iservice.updateObject(newAvis);
 	          		      //Mis à jour dans T_DAC_SPECS
 	          		     listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
 	   	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
 	   	     				       if (!listDao.isEmpty()) {
 	   	     					    newDao= listDao.get(0);
 	   	     					    newDao.setDacCout(newAvis.getAaoCoutDac());
 	   	     					    newDao.setDacNbrCopieOff(dacNbrCopieOff);
 	   	     			            iservice.updateObject(newDao); 
 	   	     	   	                 }
             	         //Message de confirmation
 	     				userController.setTexteMsg("Avis d'Appel d'Offres modifié avec succès!");
 	     				userController.setRenderMsg(true);
 	     				userController.setSevrityMsg("success");   
        	       }else {
        	    	   
        	    	      newAvis.setAaoCode(keyGen.getCodeAvis());
	            	      newAvis.setTDacSpecs(dao);
	            	      newAvis.setAaoLibelle(aaoLibelle);
        	    	      newAvis.setTAdresseAvis(new TAdresseAvis(adaNum)); 
	          		      if(slctdTd.getAaoNbrOuv() == 1) {
	            		  newAvis.setAaoDteOuvFin(ouvTech);
	          		      newAvis.setAaoDteOuvTec(ouvTech);
	            		  }else {
	            		  newAvis.setAaoDteOuvFin(ouvFin);
  	          		      newAvis.setAaoDteOuvTec(ouvTech);
	            		  }
	          		      newAvis.setAaoHeureRecep(aaoHeureRecep);
	          		      newAvis.setAaoCoutDac(aaoCoutDac);
	          		      newAvis.setAaoNatPrix(aaoNatPrix);
	          		      newAvis.setAaoRegQual(aaoRegQual);
	          		      newAvis.setAaoDateRecep(aaoDateRecep);
	          		      newAvis.setAaoDteHeurOuv(aaoDteHeurOuv);
	          		      newAvis.setAaoLieuRecep(aaoLieuRecep);
	          		      newAvis.setAaoNbrOuv(aaoNbrOuv);
	          		      newAvis.setAaoPrecisModEval(aaoPrecisModEval); 
	          		      newAvis.setAaoAvisBail(aaoAvisBai);
	          		      newAvis.setAaoRespBai(aaoRespBai);
	          		      newAvis.setAaoOffAnormal(aaoOffAnormal);
	          		      newAvis.setAaoLieuExe(aaoLieuExe);
						  newAvis.setAaoNatInt(value1);
						  newAvis.setAaoDelaiVal(nbreDelai);
						  newAvis.setAaoNbrLot(lotNbre);
						  if(dao.getTStatut().getStaCode().equalsIgnoreCase("DPU") || dao.getTStatut().getStaCode().equalsIgnoreCase("DAP") || 
							dao.getTStatut().getStaCode().equalsIgnoreCase("DVE")) {
							  newAvis.setTStatut(new TStatut("APU")); 
						  }else {
							  newAvis.setTStatut(new TStatut("D1S")); 
						  }
	            	      newAvis.setAvisRetour("0");
	            	      newAvis.setAaoDteSaisi(Calendar.getInstance().getTime()); 
	            	      newAvis.setFonCodAc(userController.getSlctd().getTFonction().getFonCod()); 
	          		      iservice.addObject(newAvis);
	          		      //Mis à jour dans T_Dac_Specs
	          		    listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
   	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
   	     				   if (!listDao.isEmpty()) {
   	     					    newDao= listDao.get(0);
   	     					    newDao.setDacCout(newAvis.getAaoCoutDac());
   	     					    newDao.setDacNbrCopieOff(dacNbrCopieOff);
   	     			            iservice.updateObject(newDao); 
   	     	   	                 }
	          		      //Rafraichissement de VDacliste
	          		      actualiseVue();
	          		     //Message de confirmation
	          		     userController.setTexteMsg("Avis d'Appel d'Offres crée avec succès!");
 	     				 userController.setRenderMsg(true);
 	     				 userController.setSevrityMsg("success");  
        	       }
	        }
	    
	        
	        public void actualiseVue() {
	        	 listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						   new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
					if (!listeDAO.isEmpty()) {
						slctdTd=listeDAO.get(0);
					}
	        }
	        
	        //Verification (un DAO doit avoir au moin un lot)
	        public void controlLotDao() {
	        	if(listeLots.size() == 0) {
	        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir ou générer au moins un lot! ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
	        	}
	        }
	     
	 	//Controle sur le nombre d'ouverture
	 	public void verifOuverture() {
	 		if(newAvis.aaoNbrOuv == 2) {
	 			ouvTechnique = true;
	 		  }else {
	 			  ouvTechnique = false;
	 		}
	 	}
	 	
	 	//Controle sur le nombre d'ouverture en Modification
	 	public void verifOuvertureModif() {
	 		if(slctdTd.getAaoNbrOuv() == 2) {
	 			ouvTechnique = true;
	 		  }else {
	 			  ouvTechnique = false;
	 		}
	 	}
	 	
	
	 	//Affichage des DAO valids par le C.E
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
							     if(controleController.type == "DP") {
								     chargeOperationDP("PN");
							        }else {
							        	 chargeOperation("PN");
							        }
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
								 if(controleController.type == "DP") {
									 chargeOperationDS("PS"); 
								     }else {
								    	 chargeOperation("PS");
								    } 
							 }
						 }
					 }
				   } 
			 }
			 


			 
			 //Parametrage des PPM ramen a la saisie
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
				 _logger.info("Operateur connect : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			 //Parametrage des PPM ramen a la saisie
			 public void chargeOperations() {
				 listePpmDao.clear();
				 listePpmDao = ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
							new WhereClause("DPP_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode())));	
				 _logger.info("dao : "+dao.getDacCode());
				 _logger.info("liste ppm : "+listePpmDao.size());
			 }
			 
			 
			 public void chargeOperationsExiste() {
			 listePpmDaoModif.clear();
			 listePpmDaoModif = ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"O"),
							new WhereClause("DPP_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())));	
				 _logger.info("dao : "+slctdTd.getDacCode());
				 _logger.info("liste ppm : "+ listePpmDaoModif.size());
			 }
			 
			 
			 public void onSelectPpm() throws IOException {
				 renseignerDaoModif();
				 updateDacCodeToPpm(); 
			 }
			 
			 
			 
			 public void updateDacCodeToPpm() { 
				 List<TDetailPlanPassation> PP  = iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",Comparateur.EQ,""+ppmDac.getDppId()));
				 TDetailPlanPassation ppm1 = new TDetailPlanPassation(); 
				 if(!PP.isEmpty()) ppm1 = PP.get(0);
				 ppm1.setTDacSpecs(new TDacSpecs(""));
				 _logger.info("dppId : "+ppmDac.getDppId());	
				 _logger.info("dacCode : "+slctdTd.getDacCode());	
				 iservice.updateObject(ppm1);
				 
				 List<TDetailPlanPassation> LS  = iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",Comparateur.EQ,""+ppmDac.getDppId()));
				 TDetailPlanPassation ppm = new TDetailPlanPassation(); 
				 if(!LS.isEmpty()) ppm = LS.get(0);
				 ppm.setTDacSpecs(new TDacSpecs(slctdTd.getDacCode()));
				 _logger.info("dppId : "+ppmDac.getDppId());	
				 _logger.info("dacCode : "+slctdTd.getDacCode());	
				 iservice.updateObject(ppm);
				 
				 chargeOperations();
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
				 _logger.info("Operateur connecte : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			//Parametrage des DP en procédure normale
			 public void chargeOperationDP(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_MOP_CODE",Comparateur.EQ,"DPA"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				  multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connecte : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			//Parametrage des DP en procédure simplifiée
			 public void chargeOperationDS(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_MOP_CODE",Comparateur.EQ,"DPS"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				  multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connecte : "+userController.getSlctd().getTFonction().getFonCod());	
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
				 _logger.info("Operateur connecte : "+userController.getSlctd().getTFonction().getFonCod());	
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
			 
			 //Parametrage des PPM ramen a la saisie
			 public void chargeOperationRecherche(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
						    new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				 multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connect : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			//Recherche des PPM pour les AMI
			 public void chargeOperationRechercheAmi(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_MOP_CODE",Comparateur.EQ,"AMI"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
						    new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				 multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connect : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			//Recherche des PPM pour les AMI
			 public void chargeOperationRecherchePrq(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_MOP_CODE",Comparateur.EQ,"PRQ"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
						    new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				 multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connect : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			  //Rappel des informations du PPM
		     public void renseignerDao() throws IOException{
		                 	if (listSelectionPpmDao.size()==0) {
		            				FacesContext.getCurrentInstance().addMessage(null,
		            						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun PPM selectionné", ""));
		            			}
		            	 		else{
		            	 			//Parcourir la liste de slection listSelectionPpmDao
		            		 		for(VPpmDao ligne : listSelectionPpmDao) {
		            		 			 
		            		 			//Parcourir la liste et récupérer
		            		 			 ppmDao =(List<VPpmDao>) iservice.getObjectsByColumn("VPpmDao", new ArrayList<String>(Arrays.asList("DPP_ID")),
		            								new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+ligne.getDppId()));
		            							if (!ppmDao.isEmpty()) {
		            								daoDetail= ppmDao.get(0);

		            							detailsPieces =(List<TTypePiecesDac>) iservice.getObjectsByColumn("TTypePiecesDac", new ArrayList<String>(Arrays.asList("TPI_CODE")),
			            	    				new WhereClause("TPI_MDT_CODE",WhereClause.Comparateur.EQ,""+daoDetail.getMdtCode()));	
		            						          }	
		            			 		       }
		            		 		chargePPM();
		            				 }       
		                          }
		     
		     //Rappel des informations du PPM en modification
		     public void renseignerDaoModif() throws IOException{
		            		 			//Parcourir la liste et récupérer
		            		 			 ppmDao =(List<VPpmDao>) iservice.getObjectsByColumn("VPpmDao", new ArrayList<String>(Arrays.asList("DPP_ID")),
		            								new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+ppmDac.getDppId()));
		            							if (!ppmDao.isEmpty()) {
		            								daoDetail= ppmDao.get(0);

		            									   detailsPieces =(List<TTypePiecesDac>) iservice.getObjectsByColumn("TTypePiecesDac", new ArrayList<String>(Arrays.asList("TPI_CODE")),
			            	    								     new WhereClause("TPI_MDT_CODE",WhereClause.Comparateur.EQ,""+daoDetail.getMdtCode()));		
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
				//Liste des libells
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
					userController.setTexteMsg("Enregistrement effectué avec succs!");
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
				  
				  //Enregistrement d'adresse dans l'ecran de modification
				  public void saveDetailAdresseModif() {
						 if(slctdTd.getAdaNum()>0) {
							 newDtailAdresse.setTAdresseAvis(new TAdresseAvis(adaNum));
							 newDtailAdresse.setTLibelleAdresse(new TLibelleAdresse(numLibAdr)); 
							 iservice.addObject(newDtailAdresse); 
							 chargeDetailAdresseModif();
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
								  new WhereClause("ADA_NUM",Comparateur.EQ,""+adaNum)); 
					  }
					  
					  public void chargeLotsUpdate(){
							 //getListeDAO().clear();
							 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
									 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
								_logger.info("lots size: "+listeLots.size());	
								//montantTotalLot();
								chargeImputationModif();
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
					  
					  
					  //Cumul des montants estimatif
					  public void montantTotalLotModif() {
						  totalMontantEstimatif = 0;
						  totalMontantCaution = 0;
						  listeLots = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_ID")),
									new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
						 
							 for(TLotAao n : listeLots) {
								 totalMontantEstimatif = (totalMontantEstimatif + n.getLaaMtEst()); 
								 totalMontantCaution = (totalMontantCaution + n.getLaaMtCaut()); 
							 }
						 }
					  
					  //controle entre le total montant estimatif et le montant de l'operation
					  public void updateMTEstim() {
						if(daoDetail.getDppMontant() > totalMontantEstimatif) {
                            	 FacesContext.getCurrentInstance().addMessage(null,
               	    	      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le cumul montant Estimatif ne doit pas etre suprieur au montant de l'operation", ""));	
                            
						}else
						{
							
						}
					  }
						 
					  
				//FIN GESTION DES MODIFICATIONS
				  
					  public void chargeLots(){
							 //getListeDAO().clear();
						  //ECRAN DE SAISIE
						   if(controleController.ecran=="saisie") {
							   listeLots = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 
										 new WhereClause("LAA_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
										 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
									_logger.info("listeLots size: "+listeLots.size());	
									//montantTotalLot();
									lotTotal = getNbreLotTotal(); 
						   }else
							 //ECRAN DE MODIFICATION
						   {
							   listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 	
									     new WhereClause("LAA_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
										 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
									_logger.info("lots size: "+listeLots.size());	
									//montantTotalLot(); 
									lotTotal = getNbreLotTotalModif();
						   }
							
						}
					  
					  
					  public void chargeLotsModif(){
							 //getListeDAO().clear();
							 listeLots = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 
									 new WhereClause("LAA_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
									 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
								_logger.info("listeLots size: "+listeLots.size());	
								//montantTotalLot();
								//lotTotal = getNbreLotTotal();
								lotTotal = getNbreLotTotalModif();
						}
				   
				  
				   //le nombre de lots pour cet avis en cours
				   public int getNbreLotTotal(){ 
						int i = iservice.countTableByColumn("T_LOT_AAO", "LAA_ID",
								new WhereClause("LAA_AAO_CODE", WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
						return	i;	
					}
				   
				   //le nombre de lots pour cet avis en cours (Modification)
				   public int getNbreLotTotalModif(){ 
						int i = iservice.countTableByColumn("T_LOT_AAO", "LAA_ID",
								new WhereClause("LAA_AAO_CODE", WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
						return	i;	
					}
				   
				   public void chargeLotsDac(){
						 //getListeDAO().clear();
						 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
								 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+updateDac.getAaoCode()));
							_logger.info("objetListe size: "+listeLots.size());		
					}
				   
				 //Mis Ã  jour de prsence (O/N)
				   public void majPresence (String presence) {
						 List<TPiecesDacs> LS  = iservice.getObjectsByColumn("TPiecesDacs", new WhereClause("PID_CODE",Comparateur.EQ,""+sltPiece.getPidCode()));
						 TPiecesDacs piece = new TPiecesDacs(); 
						 if(!LS.isEmpty()) piece = LS.get(0);
						 piece.setPidPresente(""+presence);
						 iservice.updateObject(piece);
						 //Rechargement de la liste des pices Ã  corriger
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
							 chargePiecesByCharges(); 
						 }else {
							 chargePiecesCsv(); 
						 }
						 
					 }
				   //Mis Ã  jour de conformit (Conforme/Non Conforme)
				   public void majConforme (String conformite) {
						 List<TPiecesDacs> LS  = iservice.getObjectsByColumn("TPiecesDacs", new WhereClause("PID_CODE",Comparateur.EQ,""+sltPiece.getPidCode()));
						 TPiecesDacs piece = new TPiecesDacs(); 
						 if(!LS.isEmpty()) piece = LS.get(0);
						 piece.setPidConforme(""+conformite);
						 iservice.updateObject(piece);
						 //Rechargement de la liste des pices Ã  corriger
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
							 chargePiecesByCharges(); 
						 }else {
							 chargePiecesCsv(); 
						 }
					 }
				   
				   public void chargePiecesCsv() {
						 listePicesCsv= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
									new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));			
					 }
				   
				   public void chargeLotsRappel(){
						 getListeLots().clear();
						 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
								 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
							_logger.info("objetListe size: "+listeLots.size());	
					}
				   
				   public void recupererCaution(String dacCode) {
					   listeDAO.clear();
					   listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
							   new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dacCode));
						if (!listeDAO.isEmpty()) {
							caution=listeDAO.get(0);
						}
				   }
				   
				   
				  
				   public void calculCaution() {
					        recupererCaution(dao.getDacCode());
                           // convertir string en long
					        //cautionMax = caution.getCautValMax();//* montantCaution.valueOf(newVbTemp.getTempLaaCautLot());
					        // convertir string en double
					        str = ""+newVbTemp.getLaaMtEst();
					        Double  mtEstim = Double.parseDouble(str);
					        
					        strMtCaut = ""+newVbTemp.getTempLaaCautLot();
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
				   
				   
				   
				  
				   //Methode de Gnration des Lots   
				     public void genererLot() {  
				    	 
				    	 if(imputation.equalsIgnoreCase("")) {
				    	
				    		 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir votre imputation ! ","");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
				    		 
				    	    }else {
				    		 					    	 
							       if(newAvis.getAaoNbrLot() > lotTotal) {
							    	    str = ""+newVbTemp.getLaaMtEst();
								        Double  mtEstim = Double.parseDouble(str); 
								        
								        strMtCaut = ""+newVbTemp.getTempLaaCautLot();
								        Double  montantCaut = Double.parseDouble(strMtCaut);
								        
										cautionMin = caution.getCautValMin() * mtEstim;
										cautionMax = caution.getCautValMax() * mtEstim;
										
										if(dao.getDacTypePlan().equalsIgnoreCase("PS"))	{
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
											  
											  //Activatio de saisie des pices des offres 
						                      pavet_offre = true; 
						                      pavet_critere= true;
										}else {

											
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
													  
													  //Activation du pavet de saisie des pices des offres 
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
							       }else
							       { 
										 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseignés ! ","");
										 FacesContext.getCurrentInstance().addMessage(null, msg);
							       }
				    	      }
					 }
				     
				     
				     //Génération des Lots (Modification)
                        public void genererLotModif() {  
				    	 if(imputation.equalsIgnoreCase("")) {
				    	
				    		 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir votre imputation ! ","");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
				    		 
				    	    }else {
				    		 					    	 
							       if(lotNbre > lotTotal) {
							    	    str = ""+newVbTemp.getLaaMtEst();
								        Double  mtEstim = Double.parseDouble(str);
								        
								         strMtCaut = ""+newVbTemp.getTempLaaCautLot();
								        Double  montantCaut = Double.parseDouble(strMtCaut);
								        
										cautionMin = caution.getCautValMin() * mtEstim;
										cautionMax = caution.getCautValMax() * mtEstim;
										
										
										if(slctdTd.getDacTypePlan().equalsIgnoreCase("PS"))	{
											 panelCaution = false;
											  newVbTemp.setTempLaaAaoCode(slctdTd.getAaoCode());
								        	  newVbTemp.setTempLaaDacCode(slctdTd.getDacCode());
								    		  newVbTemp.setTempLaaDteSaisi(Calendar.getInstance().getTime());
								    		  //newVbTemp.setTempLaaMtLot("0");
								    		  //newVbTemp.setTempLaaCautLot("0");
								    		  newVbTemp.setTempLaaImputation(imputation);
								    		  //newVbTemp.setTempLaaNbrTotLot(String.valueOf(slctdTd.getAaoNbrLot()));//Convertir un long en String 
								    		  newVbTemp.setTempLaaNbrTotLot(String.valueOf(lotNbre));
								    		  newVbTemp.setTempOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
								    		  newVbTemp.setTempType("LOT");
								    		  iservice.addObject(newVbTemp);
								    		  chargeLotsModif();
								    		  montantTotalLotModif();
								    		  userController.setTexteMsg("Lot(s) généré(s) avec succès!");
								    		  userController.setRenderMsg(true);
								    		  userController.setSevrityMsg("success");
										}else {
											
									    	   if(montantCaut >= cautionMin &&  montantCaut <= cautionMax) {
									    		   panelCaution = false;
													  newVbTemp.setTempLaaAaoCode(slctdTd.getAaoCode());
										        	  newVbTemp.setTempLaaDacCode(slctdTd.getDacCode());
										    		  newVbTemp.setTempLaaDteSaisi(Calendar.getInstance().getTime());
										    		  //newVbTemp.setTempLaaMtLot("0");
										    		  //newVbTemp.setTempLaaCautLot("0");
										    		  newVbTemp.setTempLaaImputation(imputation);
										    		  //newVbTemp.setTempLaaNbrTotLot(String.valueOf(slctdTd.getAaoNbrLot()));//Convertir un long en String
										    		  newVbTemp.setTempLaaNbrTotLot(String.valueOf(lotNbre));
										    		  newVbTemp.setTempOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
										    		  newVbTemp.setTempType("LOT");
										    		  iservice.addObject(newVbTemp);
										    		  chargeLotsModif();
										    		  montantTotalLotModif();
										    		  userController.setTexteMsg("Lot(s) généré(s) avec succès!");
										    		  userController.setRenderMsg(true);
										    		  userController.setSevrityMsg("success");
													  
													  //Activation du pavet de saisie des pices des offres 
								                     // pavet_offre = true; 
								                      //pavet_critere= true;
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
							       }else
							       {
										 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseignés ! ","");
										 FacesContext.getCurrentInstance().addMessage(null, msg);
							       }
				    	      }
					 }
				     
				     
				     
				     public void calculCautionSaisie() {
				    	 recupererCaution(slctdTd.getDacCode());
                            // convertir string en long
					        //cautionMax = caution.getCautValMax();//* montantCaution.valueOf(newVbTemp.getTempLaaCautLot());
					        // convertir string en double
				    	 
					        str = ""+newLot.getLaaMtEst();
					        strMtCaut = ""+newLot.getLaaMtCaut(); 
					        
					        Double  mtEstim = Double.parseDouble(str); 
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
				     
				     
				     //Recupération des données de saisie des lots
				     public void recupMtcaut() { 
				    	 //long val = 0;
				    	 newLot.laaMtCaut = mtCaut; 
					     newLot.laaMtEst = mtEstimR;
				    	 if(dao.getDacTypePlan().equalsIgnoreCase("PS")) {
				    		 champMtCaut = false;
				    	 }else {
				    		 champMtCaut = true;
				    	 }
				    	 _logger.info("valeur montant Caution: "+newLot.laaMtCaut);	
					     _logger.info("valeur montant Estimatif: "+newLot.laaMtEst);
				     }
				     
				     //Recupération des données de saisie des lots en modification
				     public void recupMtcautModif() { 
				    	 //long val = 0;
				    	 newLot.laaMtCaut = mtCaut; 
					     newLot.laaMtEst = mtEstimR;
				    	 if(slctdTd.getDacTypePlan().equalsIgnoreCase("PS")) {
				    		 champMtCaut = false;
				    	 }else {
				    		 champMtCaut = true;
				    	 }
				    	 _logger.info("valeur montant Caution: "+newLot.laaMtCaut);	
					     _logger.info("valeur montant Estimatif: "+newLot.laaMtEst);
				     }
				     
				     //Récupération des données de la génartion des lots
				     public void recupMtcautGen() { 
				    	 //long val = 0;
				    	 newVbTemp.tempLaaCautLot = ""+mtCaut; 
				    	 newVbTemp.laaMtEst = ""+mtEstimR;
				    	 if(dao.getDacTypePlan().equalsIgnoreCase("PS")) {
				    		 champMtCaut = false;
				    	 }else {
				    		 champMtCaut = true;
				    	 }
				    	 _logger.info("valeur montant Caution: "+newVbTemp.tempLaaCautLot);	
					     _logger.info("valeur montant Estimatif: "+newVbTemp.laaMtEst);
				     }
				     
				     //Récupération des données de la génartion des lots
				     public void recupMtcautGenModif() { 
				    	 //long val = 0;
				    	 newVbTemp.tempLaaCautLot = ""+mtCaut; 
				    	 newVbTemp.laaMtEst = ""+mtEstimR;
				    	 if(slctdTd.getDacTypePlan().equalsIgnoreCase("PS")) {
				    		 champMtCaut = false;
				    	 }else {
				    		 champMtCaut = true;
				    	 }
				    	 _logger.info("valeur montant Caution: "+newVbTemp.tempLaaCautLot);	
					     _logger.info("valeur montant Estimatif: "+newVbTemp.laaMtEst);
				     }
				     //Ajouter manuellement un lot
					@Transactional
				    public void saveLot(){
							  //getNbreLotTotal();
					    	 if(newAvis.getAaoNbrLot() > lotTotal) {
					    		
					    		    str = ""+newLot.getLaaMtEst();
							        strMtCaut = ""+newLot.getLaaMtCaut(); 
							        Double  mtEstim = Double.parseDouble(str); 
							        Double  montantCaut = Double.parseDouble(strMtCaut);
							        
									Double cautionMin = caution.getCautValMin() * mtEstim;
									Double cautionMax = caution.getCautValMax() * mtEstim;
									
								if(dao.getDacTypePlan().equalsIgnoreCase("PS"))	{
									 panelCaution = false;
						    		 newLot.setTDacSpecs(dao);
						    		 newLot.setLaaLbgImputation(imputation);
						    		 newLot.setLaaOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
						    		 newLot.setLaaDteSaisi(Calendar.getInstance().getTime());
						    		 newLot.setLaaCoutLot(coutLot);
						    		 newLot.setLaaAno(daoDetail.getDppStatutAno());
						    		 newLot.setTAvisAppelOffre(newAvis);
						        	 iservice.addObject(newLot);
						        	 chargeLots();
						        	 montantTotalLot();
						        	 newLot = new TLotAao();
									 
									 //Activation du pavet de saisie des pices des offres 
					                 pavet_offre = true;
					                 pavet_critere= true;
						        	 userController.setTexteMsg("Lot enregistré avec succès !");
									 userController.setRenderMsg(true);
									 userController.setSevrityMsg("success");
								}else {
									
									  if(montantCaut >= cautionMin &&  montantCaut <= cautionMax) {
							    		   panelCaution = false;
					    		           newLot.setTDacSpecs(dao);
					    		           newLot.setLaaLbgImputation(imputation);
					    		           newLot.setLaaOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
					    		           newLot.setLaaDteSaisi(Calendar.getInstance().getTime());
					    		           newLot.setLaaCoutLot(coutLot);
					    		           newLot.setLaaAno(daoDetail.getDppStatutAno());
					    		           newLot.setTAvisAppelOffre(newAvis);
					        	           iservice.addObject(newLot);
					        	           chargeLots();
					        	           montantTotalLot();
					        	           newLot = new TLotAao();
								 
								           //Activation du pavet de saisie des pièces des offres 
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
								  }
								
					    	 }else {
					    		
								 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseignés ! ","");
								 FacesContext.getCurrentInstance().addMessage(null, msg);
					    	 }
					}
					 
				     /*@Transactional
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
					    		 newLot.setLaaLbgImputation(imputation);
					    		 newLot.setLaaOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
					    		 newLot.setLaaDteSaisi(Calendar.getInstance().getTime());
					    		 newLot.setLaaCoutLot(coutLot);
					    		 newLot.setTAvisAppelOffre(newAvis);
					        	 iservice.addObject(newLot);
					        	 chargeLots();
					        	 montantTotalLot();
					        	 newLot = new TLotAao();
								 
								 //Activation du pavet de saisie des pices des offres 
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
	
								 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseignés ! ","");
								 FacesContext.getCurrentInstance().addMessage(null, msg);
					    	 }
						}*/
					 
					 //Ajouter manuellement un lot
					 @Transactional
				    public void saveLotModif(){
				    	  //getNbreLotTotal();
				    	 if(lotNbre > lotTotal) {
				    		 String str = ""+newLot.getLaaMtEst();
						        Double  mtEstim = Double.parseDouble(str);
						        
						        String strMtCaut = ""+newLot.getLaaMtCaut();  
						        Double  montantCaut = Double.parseDouble(strMtCaut);
						        
								cautionMin = caution.getCautValMin() * mtEstim;
								cautionMax = caution.getCautValMax() * mtEstim;
								
								if(slctdTd.getDacTypePlan().equalsIgnoreCase("PS"))	{
									 panelCaution = false;
						    		   
						    	List<TDacSpecs> DAC  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
						    	TDacSpecs dao = new TDacSpecs();
								if(!DAC.isEmpty()) dao = DAC.get(0);
										
								List<TAvisAppelOffre> AVI  = iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
								TAvisAppelOffre avis = new TAvisAppelOffre();
								if(!AVI.isEmpty()) avis = AVI.get(0);
										
				    		 newLot.setTDacSpecs(dao);
				    		 newLot.setLaaLbgImputation(imputation);
				    		 newLot.setLaaOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
				    		 newLot.setLaaDteSaisi(Calendar.getInstance().getTime());
				    		 newLot.setLaaCoutLot(coutLot);
				    		 newLot.setLaaAno(slctdTd.getDppStatutAno());
				    		 //newLot.setLaaAno(slctdTd.getDp));
				    		 newLot.setTAvisAppelOffre(avis);
				        	 iservice.addObject(newLot);
				        	 chargeLotsModif();
				        	 montantTotalLotModif();
				        	 newLot = new TLotAao();
							 
							 //Activation du pavet de saisie des pièces des offres 
				        	 userController.setTexteMsg("Lot enregistré avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");	
								}else {
									if(montantCaut >= cautionMin &&  montantCaut <= cautionMax) {
							    		   panelCaution = false;
							    		   
							    		   List<TDacSpecs> DAC  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
							    		   TDacSpecs dao = new TDacSpecs();
											if(!DAC.isEmpty()) dao = DAC.get(0);
											
											List<TAvisAppelOffre> AVI  = iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
											TAvisAppelOffre avis = new TAvisAppelOffre();
											if(!AVI.isEmpty()) avis = AVI.get(0);
											
					    		                 newLot.setTDacSpecs(dao);
					    		                 newLot.setLaaLbgImputation(imputation);
					    		                 newLot.setLaaOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
					    		                 newLot.setLaaDteSaisi(Calendar.getInstance().getTime());
					    		                 newLot.setLaaCoutLot(coutLot);
					    		                 newLot.setLaaAno(slctdTd.getDppStatutAno());
					    		                 newLot.setTAvisAppelOffre(avis);
					        	                 iservice.addObject(newLot);
					        	                 chargeLotsModif();
					        	                 montantTotalLotModif();
					        	                 newLot = new TLotAao();
								 
								               //Activation du pavet de saisie des pièces des offres 
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
								   }
								
				    	 }else {
				    		 /*userController.setTexteMsg("Veuillez respecter le nombre de lot(s) renseigné(s) !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");*/
							 
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseigné ! ","");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
				    	 }
					}
				     
				     /*@Transactional
					    public void saveLotModif(){
					    	  //getNbreLotTotal();
					    	 if(slctdTd.getAaoNbrLot() > lotTotal) {
					    		 String str = ""+newLot.getLaaMtEst();
							        Double  mtEstim = Double.parseDouble(str);
							        
							        String strMtCaut = ""+newLot.getLaaMtCaut();  
							        Double  montantCaut = Double.parseDouble(strMtCaut);
							        
									cautionMin = caution.getCautValMin() * mtEstim;
									cautionMax = caution.getCautValMax() * mtEstim;
									if(montantCaut >= cautionMin &&  montantCaut <= cautionMax) {
							    		   panelCaution = false;
							    		   
							    		   List<TDacSpecs> DAC  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
							    		   TDacSpecs dao = new TDacSpecs();
											if(!DAC.isEmpty()) dao = DAC.get(0);
											
											List<TAvisAppelOffre> AVI  = iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
											TAvisAppelOffre avis = new TAvisAppelOffre();
											if(!AVI.isEmpty()) avis = AVI.get(0);
											
					    		 newLot.setTDacSpecs(dao);
					    		 newLot.setLaaOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
					    		 newLot.setLaaDteSaisi(Calendar.getInstance().getTime());
					    		 newLot.setLaaCoutLot(coutLot);
					    		 newLot.setTAvisAppelOffre(avis);
					        	 iservice.addObject(newLot);
					        	 chargeLotsModif();
					        	 montantTotalLotModif();
					        	 newLot = new TLotAao();
								 
								 //Activation du pavet de saisie des pices des offres 
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
					    		
					    		 userController.setTexteMsg("Veuillez respecter le nombre de lots renseignÃ¯Â¿Â½ !");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("success");
								 
								 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseignés ! ","");
								 FacesContext.getCurrentInstance().addMessage(null, msg);
					    	 }
						}
				     */
					 
					 public void fermer() throws IOException { 
						 userController.initMessage();
						 if(controleController.getTypePlan().equalsIgnoreCase("PN")) {
							 renderPage("dao1","SAIDAO");
						 }else
						 {	
							 renderPage("dao1","SAIDPS");
						 }
						 //chargeData("PN");
					     //chargeDataPgspm();
						 //vider();
						 //return userController.renderPage(value);
					 }
					 
					 //Mis  jour du libell de lot
				        public void updateLibLot() {
				        	     lot.setLaaObjet(lot.getLaaObjet());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				        //Mis  jour du montant de la caution du lot
				        public void updateMtCautLot() {
				        	     lot.setLaaMtCaut(lot.getLaaMtCaut());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				      //Mis  jour du montant estimatif de la caution du lot
				        public void updateMtEstLot() {
				        	     lot.setLaaMtEst(lot.getLaaMtEst());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				        //suppression de lot
				   	 public void removeLot() {
				   		 System.out.print("+-------------+ "+getSelectLot().getLaaNum());
				   		 try {
				   			 iservice.deleteObject(getSelectLot());
				   				chargeLots();
				   				userController.setTexteMsg("Suppression effectue avec succs !");
				   				userController.setRenderMsg(true);
				   				userController.setSevrityMsg("success");

				   		 } catch (org.hibernate.exception.ConstraintViolationException e) {
				   			 userController.setTexteMsg("Impossible de supprimer le lot !");
				   			 userController.setRenderMsg(true);
				   			 userController.setSevrityMsg("danger");	 
				   		 }
				   	 }
				   	 
				   	 
					 public void removeLotModif() {
				   		 System.out.print("+-------------+ "+getSelectLot().getLaaNum());
				   		 try {
				   			 iservice.deleteObject(getSelectLot());
				   				chargeLotsModif();
				   				userController.setTexteMsg("Suppression effectue avec succs !");
				   				userController.setRenderMsg(true);
				   				userController.setSevrityMsg("success");

				   		 } catch (org.hibernate.exception.ConstraintViolationException e) {
				   			 userController.setTexteMsg("Impossible de supprimer le lot !");
				   			 userController.setRenderMsg(true);
				   			 userController.setSevrityMsg("danger");	 
				   		 }
				   	 }
					 
					 
					 //suppression du ppm en mode modification
				   	 public void removePpm() {
				   		 System.out.print("+-------------+ "+getPpmDac().getDppId());
				   		 try {
				   			 List<TDetailPlanPassation> PP  = iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",Comparateur.EQ,""+ppmDac.getDppId()));
							 TDetailPlanPassation ppm1 = new TDetailPlanPassation(); 
							 if(!PP.isEmpty()) ppm1 = PP.get(0);
							 ppm1.setTDacSpecs(new TDacSpecs(""));
							 _logger.info("dppId : "+ppmDac.getDppId());	
							 _logger.info("dacCode : "+slctdTd.getDacCode());	
							 iservice.updateObject(ppm1);
							chargeOperations();
							btnChangerOperation = true;
				   			userController.setTexteMsg("Suppression éffectuée avec succès !");
				   			userController.setRenderMsg(true);
				   			userController.setSevrityMsg("success");

				   		 } catch (org.hibernate.exception.ConstraintViolationException e) {
				   			 userController.setTexteMsg("Impossible de supprimer le ppm !");
				   			 userController.setRenderMsg(true);
				   			 userController.setSevrityMsg("danger");	 
				   		 }
				   	 }
				   	 
				   	 public void onSelectLigneBudgetaire() {
				   		/* List<VBl> ASS  = iservice.getObjectsByColumn("TAssignation", new WhereClause("ASS_NUM",Comparateur.EQ,""+assigneOp.getAssNum()));
						 TAssignation assignation = new TAssignation();
							if(!ASS.isEmpty()) assignation = ASS.get(0);*/
				         newLot.setLaaLbgImputation(ligne.getLbgCode());
				         //newLot
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
						 selectLot.setLaaLbgImputation(ligne.getLbgCode());

						 iservice.updateObject(getSelectLot());
						 chargeLots();
						 montantTotalLot();
						 
							}
				   	 //Ecran de modification
				   	 public void onSelectLigneBudgetaireModif() {
				         newLot.setLaaLbgImputation(ligne.getLbgCode());
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
						 selectLot.setLaaLbgImputation(ligne.getLbgCode());

						 iservice.updateObject(getSelectLot());
						 chargeLotsModif();
						 montantTotalLotModif();
						 
							}
				   	 
				   	 //Mise a jour des elements saisies dans la liste des lots
				   	 public void updateListeLotLibelle() {
				   		iservice.updateObject(getSelectLot()); 
				   	 }
				   	 
				   //Mise a jour des elements saisies dans la liste des lots
				   	/* public void updateListeLotLibelle1() {
				   		iservice.updateObject(getL); 
				   	 }*/
				   	 
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
				   		montantTotalLot();
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
										new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pice selectionne", ""));
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
						 		userController.setTexteMsg("Pices enregistre(s) avec succs!");
								userController.setRenderMsg(true);
								userController.setSevrityMsg("success");
								//Dsactivation du Bouton d'Enregistrement
								btn_save_offre = false;
								pavet_critere=true;
								//Activation du bouton du tlchargement du DAO
				                btn_dao = true;
					 		 }
				      }
				     
				     
				 //Methode de rcupration de l'adresse
				  public void observationAdresse() {
					  avisAdresse = (List<VAvisAdresse>) iservice.getObjectsByColumn("VAvisAdresse", new ArrayList<String>(Arrays.asList("V_ID")),
								new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
				  }
				  
				  //Rcupration de l'avis et son Adresse
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
				  
				  //
				  public void avisBailleur() {
					  if(aaoAvisBai.equalsIgnoreCase("O")) {
						  libBailleur = true;
						  inputBailleur = true;
					  }else {
						  libBailleur = false;
						  inputBailleur = false;
					  }
				  }
				  
				  //
				  public void avisBailleurModif() {
					  if(slctdTd.getAaoAvisBai().equalsIgnoreCase("O")) {
						  libBailleur = true;
						  inputBailleur = true;
					  }else {
						  libBailleur = false;
						  inputBailleur = false;
					  }
				  }
				  
				  //
				  public void checkSituation() {
						 if(aaoRegQual.equalsIgnoreCase("SCORE")) { 
							 etatQualif = true;
							 qualifLabel1 = true;
							 qualifLabel2 = false;
						 }else 
						      if(aaoRegQual.equalsIgnoreCase("CONFORMITE")){
						    	  etatQualif = false;
						    	  qualifLabel1 = false;
								  qualifLabel2 = false;
						 }else
							 if(aaoRegQual.equalsIgnoreCase("AUTRE")){
							 etatQualif = true;
							 qualifLabel1 = false;
							 qualifLabel2 = true;
						 }
					 }
				  
				  public void checkSituationModif() {
						 if(slctdTd.getAaoRegQual().equalsIgnoreCase("SCORE")) { 
							 etatQualif = true;
							 qualifLabel1 = true;
							 qualifLabel2 = false;
						 }else 
						      if(slctdTd.getAaoRegQual().equalsIgnoreCase("CONFORMITE")){
						    	  etatQualif = false;
						    	  qualifLabel1 = false;
								  qualifLabel2 = false;
						 }else
							 if(slctdTd.getAaoRegQual().equalsIgnoreCase("AUTRE")){
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
					 
					 //Affichage des messages de marge de prfrence
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
					 
					 private void reiniPreference() {
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
			         
				

							//Mis Ã  Jour dans le T_DAC_SPECS (EN MODIFICATION)
							 public void majPreferenceModif() {
								 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		    	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		    	     				       if (!listDao.isEmpty()) {
		    	     					    newDao= listDao.get(0);
		    	     				        newDao.setDacMargePref(choixTaux);
		    	     				        newDao.setDacMargePrefSou(choixTaux);
		    	     				        iservice.updateObject(newDao);
		        	     				       }
							         }
							 
							 public void reiniPreferenceModif() {
								 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		    	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		    	     				       if (!listDao.isEmpty()) {
		    	     					    newDao= listDao.get(0);
		    	     				        newDao.setDacMargePref(choixTaux);
		    	     				        newDao.setDacMargePrefSou(choixTaux);
		    	     				        newDao.setDacMargePrefArt(choixTaux);
		    	     				        newDao.setDacMargePrefCom(choixTaux);
		    	     				        iservice.updateObject(newDao);
		        	     				       }
							         }
							 //FIN MODIFICATION
					 
					 
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
					 
					 
					 //En mode modification
					 public void checkMargePrefModif() {
						 if(choixTaux.equalsIgnoreCase("O")) { 
							 majPreferenceModif();
							 etatMargePreference = true;
							 listeMargePref();
						 }else 
						 {
							 reiniPreferenceModif();
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
						 //Actualisation des critres
						 chargeLots();
					 }
					 
					//Variante (OUI/NON) en modification
					 public void majVarianteModif(String variante) {
						 List<TLotAao> LOT  = iservice.getObjectsByColumn("TLotAao", new WhereClause("LAA_ID",Comparateur.EQ,""+sltLot.getLaaId()));
						 TLotAao lo = new TLotAao(); 
						 if(!LOT.isEmpty()) lo = LOT.get(0);
						 lo.setLaaVariante(""+variante);
						 iservice.updateObject(lo);	
						 //Actualisation des critres
						 chargeLotsModif();
					 }
					 
					 
					 //Edition de la fiche de synthse du DAO
					 public void imprimeSynthese() {
						 //ECRAN DE SAISIE
						   if(controleController.ecran=="saisie") {
							   projetReport.stringparam1(dao.getDacCode(), "synthese_dac", "synthese_dac"); 
						   }else
							 //ECRAN DE MODIFICATION
						   {
							   projetReport.stringparam1(slctdTd.getDacCode(), "synthese_dac", "synthese_dac");    
						   }
							   
						}
					 
				 
					//Tlchargement des DAO type aprs la saisie du DAO					
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
						
						//Téléchargement des DAO type aprÃ¯Â¿Â½s la saisie du DAO  
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
						  public void conditImputation() { 
							  listeImputationsModif.clear();
							  listeImputationsModif =(List<VLigneLot>) iservice.getObjectsByColumn("VLigneLot", new ArrayList<String>(Arrays.asList("LBG_CODE")),
										 new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())); 
									} 
						  
						  public void chargeImputationModif() { 
							  listeImputationsModif.clear();
							  listeImputationsModif =(List<VLigneLot>) iservice.getObjectsByColumn("VLigneLot", new ArrayList<String>(Arrays.asList("LBG_CODE")),
										 new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())); 
								 recupererCaution(slctdTd.getDacCode());
								 imputationLot = true;
								 imputationPpm = false;
									} 
						  
						  public void chargeImputationSansLot() { 
							  listeLignePpm.clear();
							  listeLignePpm =(List<VLignePpm>) iservice.getObjectsByColumn("VLignePpm", new ArrayList<String>(Arrays.asList("DPP_ID")),
										 new WhereClause("DPP_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())); 
								 recupererCaution(slctdTd.getDacCode());
								 imputationPpm = true;
								 imputationLot = false;
									} 
							  
							//Chargement des imputations ou lignes budgÃ¯Â¿Â½taires pour le AC
							  public void chargeImputation() { 
								 listeImputations.clear();
								 listeImputations =(List<VLigneLot>) iservice.getObjectsByColumn("VLigneLot", new ArrayList<String>(Arrays.asList("LBG_CODE")),
										 new WhereClause("DAC_CODE",Comparateur.EQ,""+dao.getDacCode())); 
								 recupererCaution(dao.getDacCode());
									} 
							  
							  
							  public void chargeDonneLot() {
								  chargeImputation();
								  recupMtcautGen();
							  }
							  
							  
							  //Contrôle sur les imputations pour les DAO sans lots et les DAO avec lots en mode modification
							  public void controleImput() {
								  conditImputation();
								  if(listeImputationsModif.size() > 0 ) {
									  chargeImputationModif();
								  }else {
									  chargeImputationSansLot();
								  }
							  }
							  
							  //Contrôle sur la génération des lots
							  public void chargeDonnesModif() {
								  //chargeImputationModif();
								  controleImput();
								  recupMtcautGenModif();
							  }
							  
							//Chargement des fonctions à  imputer par le Chef de Service
							  public void chargeFonctionImput() { 
								  listeFonctionsImput.clear();
								  listeFonctionsImput =(List<VFonctionImputation>) iservice.getObjectsByColumn("VFonctionImputation",
										  new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()),
										  new WhereClause("STR_CODE",Comparateur.EQ,slctdTd.getLbgStrCode())); 
								  _logger.info("dacCode: "+slctdTd.getDacCode());
								  _logger.info("StrCode: "+slctdTd.getLbgStrCode());
									_logger.info("listeFonctionsImput size: "+listeFonctionsImput.size());	
									typeActionTb();
									}
							  
							  
							   
							  //Filtre sur la liste des chargs d'Etudes
							  public void filtrefonction() { 
								  listeFonctionsImput.clear();
								  listeFonctionsImput =(List<VFonctionImputation>) iservice.getObjectsByColumn("VFonctionImputation", new ArrayList<String>(Arrays.asList("FON_COD")),
										 new WhereClause("STR_CODE",Comparateur.EQ,slctdTd.getLbgStrCode()),
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
							  
							  //Examen des pices du DAO par le Responsable du binÃƒÂ´me
							  @Transactional
							  public void examinerPieces() {
								  //Mis à  Jour du Statut du DAO dans T_Dao_Affectation, puis dans t_dac_specs
								  // slctdTda.setDafStaCode("D4V"); //Ancien Statut
								   slctdTda.setDafStaCode("DC2");
								   slctdTda.setDafStatutRetour("0");
								   iservice.updateObject(slctdTda);
								   
								listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										   new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
											new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
										if (!listDao.isEmpty()) {
											 newDao= listDao.get(0);
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
	 						       historiser("DC2",newDao.getDacCode(),"DAO Corrigé par le responsable du binome");
										//Actualisation du Tableau de Bord
										typeActionTb();
										//Activation et dsactivation des boutons valider
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
								                             String chaine="CORRECTION DU DOSSIER D''APPEL D''OFFRES N";
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
							 				                              userController.setTexteMsg("Correction(s) effectue(s) avec succes!");
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
								  
								//Insertion des chargs d'tudes choisis 
									if (listSelectionFonctImput.size()==0) {
												FacesContext.getCurrentInstance().addMessage(null,
												new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun Chargé d'Etudes selectionné", ""));
											}
									 		else{
									 			    
									 			  if (listSelectionFonctImput.size()==2) {
									 					
									 					listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
									 							new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
									 						if (!listDao.isEmpty()) {
									 							newDao= listDao.get(0);
									 							
									 					        iservice.updateObject(newDao); 
									 			   	                 }
									 				  			 				  
									 				  //String exo="";
									 				  String chaine="SEANCE DE COMMISSION INTERNE D'ANALYSE DU DAO N";
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
										 	    		 
										 	    daoBinome = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
										 	    		      new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,""+sltImput.getOpeMatricule()), 
														      new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+sltImput.getDacCode()));
										 						if (!daoBinome.isEmpty()) {
										 							//Mis  jour de tous les DAO dans T_DAO_AFFECTATION
										 							for(TDaoAffectation dao : daoBinome) {
										 								 dao.setDafStaCode(newDao.getTStatut().getStaCode());
										 								 iservice.updateObject(dao);
										 								       }
										                            }else {
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
									 							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez Choisir un binome !", ""));
									 			    	     //Rinitialiser la liste de selection
									 			    	      listSelectionFonctImput.clear();
									 			          }	
									 		 }
										}
							     
								//Chargement de la liste des DAO dj affects
								 public void chargeDaoAffectesR(){ 
									// String type;
									 //String plan;
									 if(controleController.type == "DAC" && controleController.typePlan == "PN") {
										 type ="DAO";
										 plan = "PN";
									 }else {
										      if(controleController.type == "DAC" && controleController.typePlan =="PS") {
										    	  type ="DAO";
										    	  plan = "PS";
										      }else {
										    	        if(controleController.type == "AMI" && controleController.typePlan == "PN") {
														    type ="AMI";
														     plan = "PN";
													     }else {
													    	      if(controleController.type == "AMI" && controleController.typePlan == "PS") {
																    type ="AMI";
																     plan = "PS";
															     }else {
															    	     if(controleController.type == "PRQ" && controleController.typePlan == "PN") {
																		    type ="PRQ";
																		     plan = "PN";
																	     }else {
																	    	 if(controleController.type == "PRQ" && controleController.typePlan == "PS") {
																				    type ="PRQ";
																				     plan = "PS";
																			     }
																	     }
															     }
													    }
										      }
									 }
									 
										 listeDAO.clear();
										 listeDAO =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
									              new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D3A"),
									              new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+type),
									              new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+plan));
								}  	  
							  //Fin du Chargement de la liste des DAO dj affects
							
							 
								//Charger la liste des pices et observations  examiner par le chef de service suivie de l'observation donnee par le responsable
								 public void chargePiecesByCsv() {
									 listeDetailCorrection= (List<VDetailCorrection>) iservice.getObjectsByColumn("VDetailCorrection", new ArrayList<String>(Arrays.asList("PID_CODE")),
											    new WhereClause("DCO_RESPO",WhereClause.Comparateur.EQ,"O"),
												new WhereClause("DCO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));	
												if (!listeDetailCorrection.isEmpty()) {
													detailCor = listeDetailCorrection.get(0);
											    }
								             }
								 
								//Chargement la liste des pices et observations  examiner par le responsable
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
									 listePiecesDao= ((List<VPieceDac>)iservice.getObjectsByColumn("VPieceDac",new ArrayList<String>(Arrays.asList("PID_CODE")),
											    new WhereClause("PID_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode())));

								 }	
								 
								//Affichage de zone de mention si le charg d'Etudes est un responsable de binome
								  public void chargeRespoExiste(){
									  daoExamen = ((List<TDaoAffectation>)iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
					           					      "DAF_STA_CODE", new ArrayList<String>(Arrays.asList("D3A","DC2")),
										              new WhereClause("DAF_DCS_MBM_RESPO",WhereClause.Comparateur.EQ,"O"),
										              new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()),
										              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
									        if (!daoExamen.isEmpty()) {
											      etatSanction = true;
											      etatLoveObs = true;
											      etatBtnValid = true;
											      etatBtnValidCharge = false;
											      validCorrection = true;
									         }else {
									        	 etatSanction = false;	
									        	 etatLoveObs = false;
									        	 etatBtnValid = false;
									        	 etatBtnValidCharge = true;
									        	 validCorrection = false;
									         }		
									    }
								  
								  public void activePavetRespo() {
									  daoExamen = ((List<TDaoAffectation>)iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
			           					      "DAF_STA_CODE", new ArrayList<String>(Arrays.asList("D3A","DC2")),
								              new WhereClause("DAF_DCS_MBM_RESPO",WhereClause.Comparateur.EQ,"O"),
								              new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()),
								              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
									  if(daoExamen.size()==0) {
										  etatSanction = false;	
								        	 etatLoveObs = false;
								        	 etatBtnValid = false;
								        	 etatBtnValidCharge = true;
								        	 validCorrection = false;
									  }else {
										  etatSanction = true;
									      etatLoveObs = true;
									      etatBtnValid = true;
									      etatBtnValidCharge = false;
									      validCorrection = true;
									  }
									  _logger.info("affectattion : "+daoExamen.size());
								  }
								  
								  
								//Affichage de zone de mention si le charg d'Etude est un responsable de binÃƒÂ´me
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
								  
								    //Examen des pièces du DAO par le charg d'Etudes du binome
									//@Transactional
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
										                       //Mis à  jour du statut de DAO recu
										              daoExamen = ((List<TDaoAffectation>)iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
							           					        "DAF_STA_CODE", new ArrayList<String>(Arrays.asList("D3A","DC2")),
							           					        new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()),
										           				new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
										                        if (!daoExamen.isEmpty()) { 
										                        	 daoAffec= daoExamen.get(0);
										            	             daoAffec.setDafStaCode("DC1");
										            	             iservice.updateObject( daoAffec);
										                             }
										                        
										                             historiser("DC1",daoAffec.getDafDacCode(),"DAC corrigé par le binome");
										                             //Actualisation de la liste des DAO
										                             //chargeDaoChargeEtude();
												                     //Actualisation du Tableau de Bord
												                     typeActionTb();
												                     //Message de confirmation
												                     userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
												                     userController.setRenderMsg(true);
												                     userController.setSevrityMsg("success");
												                     
									                          }else { 
									        	 
										                                  listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										                                		     new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
													                                 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
												                                  if (!listDao.isEmpty()) { newDao= listDao.get(0);}
										                                          String chaine="CORRECTION DU DOSSIER D''APPEL D''OFFRES N";
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
									 				
										                                             //Mis à  jour du statut de DAO en cours de traitement chez le ChargÃ¯Â¿Â½ d'Etudes  
										                                            //Mis à  jour du statut de DAO recu
																		            daoExamen = ((List<TDaoAffectation>)iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
															           					        "DAF_STA_CODE", new ArrayList<String>(Arrays.asList("D3A","DC2")),
															           					        new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()),
																		           				new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
																		                        if (!daoExamen.isEmpty()) { 
																		                        	 daoAffec= daoExamen.get(0);
																		            	             daoAffec.setDafStaCode("DC1");
																		            	             iservice.updateObject( daoAffec); 
																		                             }
										       		                                //Actualisation de la liste des DAO
										       		                                chargeDaoChargeEtude();
										       		                                //Historisation de la dernière action
										       		                                historiser("DC1",daoAffec.getDafDacCode(),"DAC corrigé par le binome");
									 				                                //Actualisation du Tableau de Bord
													                                 typeActionTb();
									 				                                //Message de confirmation
									 				                                userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
									 				                                userController.setRenderMsg(true);
									 				                                userController.setSevrityMsg("success");
									                                         }
									                                       }
									  
									//Enregistrement des corrections
									/*  @Transactional
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
											 userController.setTexteMsg("Correction(s)  effectuée(s) avec succès!");
											 userController.setRenderMsg(true);
											 userController.setSevrityMsg("success");	
									  }*/
									  
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
											 userController.setTexteMsg("Correction(s)  effectuée(s) avec succès!");
											 userController.setRenderMsg(true);
											 userController.setSevrityMsg("success");	
									  }

									  
								     ////Validation charg d'Etudes
									  //@Transactional
									  public void valider() throws IOException {
								       	List<TDacSpecs> DA  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
								       	TDacSpecs dao = new TDacSpecs();
											if(!DA.isEmpty()) dao = DA.get(0);
											dao.setTStatut(new TStatut("D4V"));
											dao.setDacStatutRetour(slctdTd.getDacStatutRetour());
											iservice.updateObject(dao);
											
											
								       
										   constantService.getStatut("D4V");
			 							   //Historisation du / des retraits
			 						       historiser("D4V",slctdTd.getDacCode(),"");
											
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
									  
									  
									  ////Validation charg d'Etudes
									  //@Transactional
									  public void validerRepoCE() throws IOException {
								       	List<TDacSpecs> DA  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+getSlctdTda().getDafDacCode()));
								       	TDacSpecs dao = new TDacSpecs();
											if(!DA.isEmpty()) dao = DA.get(0);
											dao.setTStatut(new TStatut("D4V"));
											//dao.setDacStatutRetour(slctdTd.getDacStatutRetour());
											iservice.updateObject(dao);
											
											 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
													    //new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
														new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
													         if (!listDao.isEmpty()) {
														         newDao= listDao.get(0);
														         newDao.setTStatut(new TStatut("D4V"));
												                 iservice.updateObject(newDao); 
										   	                        }
													         
													         listCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
																	  new WhereClause("COR_DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode()));
															           if (!listCorrection.isEmpty()) {
															        	 daoCorr= listCorrection.get(0);
															        	 daoCorr.setCorObservationRespo(getObservationCor());
															        	 daoCorr.setCorResultatRespo(avisRespo); 
																	     iservice.updateObject(daoCorr);
															           }
								       
										   constantService.getStatut("D4V");
			 							   //Historisation du / des retraits
			 						       //historiser("D4V",getSlctdTda().getDafDacCode(),"");
											
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
									  //@Transactional 
									 public void resultatCorrectionRespo() {
										 listCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
												  new WhereClause("COR_DAC_CODE",Comparateur.EQ,""+slctdTda.getDafDacCode()));
										           if (!listCorrection.isEmpty()) {
										        	 daoCorr= listCorrection.get(0);
										        	 daoCorr.setCorObservationRespo(getObservationCor());
										        	 daoCorr.setCorResultatRespo(avisRespo); 
												     iservice.updateObject(daoCorr);
												 
												     //Message de confirmation
													 userController.setTexteMsg("Validation effectuée avec succès!");
													 userController.setRenderMsg(true);
													 userController.setSevrityMsg("success");
										          }	                     
									   } 
									  
									  
									  //Transmission du DAO par le Responsable du binome
									  //@Transactional
									  public void transmettreRespo() {
										  
										  if(dos.getDdaNom().equalsIgnoreCase("") || "".equals(dos.getDdaNom()) || dos.getDdaReference().equalsIgnoreCase("") || "".equals(dos.getDdaReference())) {
											  //Message d'erreur
											  FacesContext.getCurrentInstance().addMessage(null,
											  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez charger le DAO", ""));
											  
										        }else {
											     //Mis ÃƒÂ  Jour du Statut du DAO dans T_Dao_Affectation, puis dans t_dac_specs
										        	   daoExamen = ((List<TDaoAffectation>)iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
							           					        "DAF_STA_CODE", new ArrayList<String>(Arrays.asList("D3A","DC2")),
							           					        new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()),
										           				new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
										                        if (!daoExamen.isEmpty()) { 
										                        	 daoAffec= daoExamen.get(0);
										            	             daoAffec.setDafStaCode("D4V");
										            	             daoAffec.setDafStatutRetour("0");
										            	             iservice.updateObject(daoAffec);
										                             }
											     /* slctdTda.setDafStaCode("D4V");ss
											      slctdTda.setDafStatutRetour("0");
											      iservice.updateObject(slctdTda);*/
											  
											   //Mis ÃƒÂ  jour du statut et de l'option retour dans TDacSpecs
											   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
													    //new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
														new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
													         if (!listDao.isEmpty()) {
														         newDao= listDao.get(0);
														         newDao.setTStatut(new TStatut("D4V"));
														         newDao.setDacStatutRetour("0");
												                 iservice.updateObject(newDao); 
										   	                        }

												  constantService.getStatut("D4V");
								 				  //Historisation du / des retraits
								 				  historiser("D4V",newDao.getDacCode(),"");
												  
								 				  tableauBordController.saveTempTabord("D4V", slctdTd.getDacTdCode(), ""+userController.getSlctd().getTFonction().getFonCod(), slctdTd.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), slctdTd.getDacCode());
												  chargeData();
												  chargeDaoChargeEtude();
												  
												   //Actualisation du tableau de bord
								 					typeActionTb();
								 					//Message de confirmation
								 					userController.setTexteMsg("Transmission effectuée avec succès!");
													userController.setRenderMsg(true);
													userController.setSevrityMsg("success");
										        }
									       } 
									  
									 
						/*			  public void examinerCsv() {		
									    	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
									    		 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
													        new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
													        new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
												                if (!listDao.isEmpty()) {newDao= listDao.get(0); }
											 }else {
												 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
													        new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
													        new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
												                if (!listDao.isEmpty()) {newDao= listDao.get(0); } 
											 }
									    	 
									    	 
									    	 
									    	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
									    		 listPieceCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
														   new WhereClause("COR_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
											                        if (!listPieceCorrection.isEmpty()) {
												                           correction = listPieceCorrection.get(0);
												                           
												                           newTempCor.setTempDacCode(newDao.getDacCode());
																	    	newTempCor.setDcoFonCode(userController.getSlctd().getTFonction().getFonCod());
																	    	newTempCor.setTempOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
																	    	 String pidCode =String.valueOf(sltPiece.getPidCode());
																	    	newTempCor.setDcoPidCode(pidCode);
																	    	newTempCor.setTempType("COR");
																	    	iservice.addObject(newTempCor);
												                           
												                           
												                                  for(VPieces n : listePicesCsv) {
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

														                     //Message de confirmation
														                     userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
														                     userController.setRenderMsg(true);
														                     userController.setSevrityMsg("success");
														                     
											                          }else { 
											        	 
												                                  listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
												                                		     new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
															                                 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
														                                  if (!listDao.isEmpty()) { newDao= listDao.get(0);}
												                                          String chaine="CORRECTION DU DOSSIER D''APPEL D''OFFRES N";
												                                          String exo=chaine+newDao.getDacCode();
												                                          correction.setCorLieblle(exo); 
												                                          correction.setCorOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
												                                          correction.setTDacSpecs(newDao);
												                                          correction.setCorDteSaisi(Calendar.getInstance().getTime());
												                                          iservice.addObject(correction);
												                                          
												                                          newTempCor.setTempDacCode(newDao.getDacCode());
																					    	newTempCor.setDcoFonCode(userController.getSlctd().getTFonction().getFonCod());
																					    	newTempCor.setTempOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
																					    	 String pidCode =String.valueOf(sltPiece.getPidCode());
																					    	newTempCor.setDcoPidCode(pidCode);
																					    	newTempCor.setTempType("COR");
																					    	iservice.addObject(newTempCor);
												     
												                                            for(VPieces n : listePicesCsv) {
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
											 				                                //Message de confirmation
											 				                                userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
											 				                                userController.setRenderMsg(true);
											 				                                userController.setSevrityMsg("success");
											                                         }
											 }else {
												 listPieceCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
														   new WhereClause("COR_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
											                        if (!listPieceCorrection.isEmpty()) {
												                           correction = listPieceCorrection.get(0);
												                           
												                           newTempCor.setTempDacCode(newDao.getDacCode());
																	    	newTempCor.setDcoFonCode(userController.getSlctd().getTFonction().getFonCod());
																	    	newTempCor.setTempOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
																	    	 String pidCode =String.valueOf(sltPiece.getPidCode());
																	    	newTempCor.setDcoPidCode(pidCode);
																	    	newTempCor.setTempType("COR");
																	    	iservice.addObject(newTempCor);
												                           
												                           
												                                  for(VPieces n : listePicesCsv) {
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

														                     //Message de confirmation
														                     userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
														                     userController.setRenderMsg(true);
														                     userController.setSevrityMsg("success");
														                     
											                          }else { 
											        	 
												                                  listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
												                                		     new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
															                                 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
														                                  if (!listDao.isEmpty()) { newDao= listDao.get(0);}
												                                          String chaine="CORRECTION DU DOSSIER D''APPEL D''OFFRES N";
												                                          String exo=chaine+newDao.getDacCode();
												                                          correction.setCorLieblle(exo); 
												                                          correction.setCorOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
												                                          correction.setTDacSpecs(newDao);
												                                          correction.setCorDteSaisi(Calendar.getInstance().getTime());
												                                          iservice.addObject(correction);
												                                          
												                                          newTempCor.setTempDacCode(newDao.getDacCode());
																					    	newTempCor.setDcoFonCode(userController.getSlctd().getTFonction().getFonCod());
																					    	newTempCor.setTempOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
																					    	 String pidCode =String.valueOf(sltPiece.getPidCode());
																					    	newTempCor.setDcoPidCode(pidCode);
																					    	newTempCor.setTempType("COR");
																					    	iservice.addObject(newTempCor);
												     
												                                            for(VPieces n : listePicesCsv) {
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
											 				                                //Message de confirmation
											 				                                userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
											 				                                userController.setRenderMsg(true);
											 				                                userController.setSevrityMsg("success");
											                                         }
											 }
									    	 
									   }
*/
										//Fin de la fonctionnalité	 
									  
									  
									  
									//Début de la methode examinerCsv()
									  public void examinerCsv() {		
									    	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
									    		 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
													        new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
												                if (!listDao.isEmpty()) {newDao= listDao.get(0); }
											 }else {
												 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
													        new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
												                if (!listDao.isEmpty()) {newDao= listDao.get(0); } 
											 }
									    	 
									    	 
									    	 
									    	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
									    		 listPieceCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
														   new WhereClause("COR_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
											                        if (!listPieceCorrection.isEmpty()) {
												                           correction = listPieceCorrection.get(0);
												                     
												                             newCorrection.setDcoPidCode(String.valueOf(sltPiece.getPidCode()));
																			  newCorrection.setDcoDacCode(newDao.getDacCode());
																			  newCorrection.setDcoDteSaisi(Calendar.getInstance().getTime());
																			  newCorrection.setDcoFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
																			  newCorrection.setDcoOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
																			  newCorrection.setTempType("DAC_CORRECTION");
																			  iservice.addObject(newCorrection);
												                       

														                     //Message de confirmation
														                     userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
														                     userController.setRenderMsg(true);
														                     userController.setSevrityMsg("success");
														                     
											                          }else { 
											        	 
												                                  listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
															                                 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
														                                  if (!listDao.isEmpty()) { newDao= listDao.get(0);}
												                                        
																					    	
																					    	  newCorrection.setDcoPidCode(String.valueOf(sltPiece.getPidCode()));
																							  newCorrection.setDcoDacCode(newDao.getDacCode());
																							  newCorrection.setDcoDteSaisi(Calendar.getInstance().getTime());
																							  newCorrection.setDcoFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
																							  newCorrection.setDcoOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
																							  newCorrection.setTempType("DAC_CORRECTION");
																							  iservice.addObject(newCorrection);
												     
											 				                                //Message de confirmation
											 				                                userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
											 				                                userController.setRenderMsg(true);
											 				                                userController.setSevrityMsg("success");
											                                         }
											 }else {
												 listPieceCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
														   new WhereClause("COR_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
											                        if (!listPieceCorrection.isEmpty()) {
												                           correction = listPieceCorrection.get(0);
								
												                           
												                             newCorrection.setDcoPidCode(String.valueOf(sltPiece.getPidCode()));
																			  newCorrection.setDcoDacCode(newDao.getDacCode());
																			  newCorrection.setDcoDteSaisi(Calendar.getInstance().getTime());
																			  newCorrection.setDcoFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
																			  newCorrection.setDcoOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
																			  newCorrection.setTempType("DAC_CORRECTION");
																			  iservice.addObject(newCorrection);
												                       

														                     //Message de confirmation
														                     userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
														                     userController.setRenderMsg(true);
														                     userController.setSevrityMsg("success");
														                     
											                          }else { 
											        	 
												                                  listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
															                                 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
														                                  if (!listDao.isEmpty()) { newDao= listDao.get(0);}
												                                      
												                                          newCorrection.setDcoPidCode(String.valueOf(sltPiece.getPidCode()));
																						  newCorrection.setDcoDacCode(newDao.getDacCode());
																						  newCorrection.setDcoDteSaisi(Calendar.getInstance().getTime());
																						  newCorrection.setDcoFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
																						  newCorrection.setDcoOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
																						  newCorrection.setTempType("DAC_CORRECTION");
																						  iservice.addObject(newCorrection);
												     
											 				                                //Message de confirmation
											 				                                userController.setTexteMsg("Correction(s) effectuée(s) avec succès!");
											 				                                userController.setRenderMsg(true);
											 				                                userController.setSevrityMsg("success");
											                                         }
											                     }
										  
									               }
									    	//Fin de la methode examinerCsv 
								
									  
									  @Transactional
										public void uploadCharge(FileUploadEvent event) throws java.io.FileNotFoundException { 
										 //condition de chargement d'un document : Nature sélectionnée
										 if((docNature == null || "".equals(docNature))){
											 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sélectionnée pour le chargement! ","");
											FacesContext.getCurrentInstance().addMessage(null, msg);	
											 
											 }else {
												 
										
												 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
													 if(fileUploadController.handleFileUpload(event, ""+slctdTda.getDafDacCode(), docNature)) {
															
															listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
												 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
												 				if (!listDao.isEmpty()) {
												 					newDao= listDao.get(0);
												 	   	                 }
															
															int nat = Integer.valueOf(docNature);
															//check le dossier s'il existe ÃƒÂ  faire
															//TDossierDacs dos =new TDossierDacs(); //TNatureDocuments
															//dos.setDdaNom(keyGen.getCodeDossier(fileUploadController.getFileCode()+"-"));
															dos.setDdaNom(fileUploadController.getFileName());
															dos.setTDacSpecs(newDao);
															dos.setTOperateur(userController.getSlctd().getTOperateur());
															dos.setTFonction(userController.getSlctd().getTFonction());
															List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
															TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
															if(!LS.isEmpty()) natureDoc = LS.get(0);
															dos.setTNatureDocuments(natureDoc);
															dos.setDdaDteSaisi(Calendar.getInstance().getTime());
															dos.setDdaReference(fileUploadController.getDocNom());
															dos.setTOperateur(userController.getSlctd().getTOperateur());
															dos.setTFonction(userController.getSlctd().getTFonction());
															iservice.addObject(dos); 
															
															//chargeNatureDocTrans();
															chargeDossierCharge();
															
															FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers bien effectué!", "");
															FacesContext.getCurrentInstance().addMessage(null, msg);
															chargeDossierCharge();
															}else {
																FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger  nouveau un document ! ","");
																FacesContext.getCurrentInstance().addMessage(null, msg);	
																
															}
													 
												 }else {
													 if(fileUploadController.handleFileUpload(event, ""+slctdTd.getDacCode(), docNature)) {
															
															listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
												 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
												 				if (!listDao.isEmpty()) {
												 					newDao= listDao.get(0);
												 	   	                 }
															
															int nat = Integer.valueOf(docNature);
															//check le dossier s'il existe ÃƒÂ  faire
															//TDossierDacs dos =new TDossierDacs(); //TNatureDocuments
															//dos.setDdaNom(keyGen.getCodeDossier(fileUploadController.getFileCode()+"-"));
															dos.setDdaNom(fileUploadController.getFileName());
															dos.setTDacSpecs(newDao);
															dos.setTOperateur(userController.getSlctd().getTOperateur());
															dos.setTFonction(userController.getSlctd().getTFonction());
															List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
															TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
															if(!LS.isEmpty()) natureDoc = LS.get(0);
															dos.setTNatureDocuments(natureDoc);
															dos.setDdaDteSaisi(Calendar.getInstance().getTime());
															dos.setDdaReference(fileUploadController.getDocNom());
															iservice.addObject(dos); 
															
															//chargeNatureDocTrans();
															chargeDossierCharge();
															
															FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers bien effectué!", "");
															FacesContext.getCurrentInstance().addMessage(null, msg);
															chargeDossierCharge();
															}else {
																FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger  nouveau un document ! ","");
																FacesContext.getCurrentInstance().addMessage(null, msg);	
																
															} 	 
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
											 //ECRAN DE SAISIE
											   if(controleController.ecran=="saisie") {
												   dos.setTDacSpecs(dao);
											   }else
												 //ECRAN DE MODIFICATION
											   {
												   List<TDacSpecs> DAC  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
												   TDacSpecs dao = new TDacSpecs();
													if(!DAC.isEmpty()) dao = DAC.get(0);
												   dos.setTDacSpecs(dao);   
											   }
											List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
											TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
											if(!LS.isEmpty()) natureDoc = LS.get(0);
											dos.setTNatureDocuments(natureDoc);
											dos.setTOperateur(userController.getSlctd().getTOperateur());
											dos.setTFonction(userController.getSlctd().getTFonction());
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
												FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger  nouveau un document ! ","");
												FacesContext.getCurrentInstance().addMessage(null, msg);	
												
											}
										  //}
										}
									
									 public void openDossier() throws IOException{
										 //downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaNom(), selectedDossier.getDdaNom());
							       		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION_LINUX+selectedDossier.getDdaNom(), selectedDossier.getDdaNom());
							       		   }
									//Methode de Chargement des Artcles
									  public void chargeArticle() {
										  listeArticle.clear();
										  listeArticle = ((List<VArticlesCom>)iservice.getObjectsByColumn("VArticlesCom"));		
									 	 } 
									//Methode de Chargement des Dossiers chez le Chargés d'Etudes
								/*public void chargeDossierAutorisation() {
									    	 dossDacListe.clear();
									    	 //ECRAN DE SAISIE
											   if(controleController.ecran=="saisie") {
												   dossDacListe = ((List<TDossierDacs>)iservice.getObjectsByColumnDesc("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
										 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,dao.getDacCode())));	
											   }else
												 //ECRAN DE MODIFICATION
											   {
												   dossDacListe = ((List<TDossierDacs>)iservice.getObjectsByColumnDesc("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
										 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getDacCode())));	 
											   }		
									 	 } */
									  
									//Methode de Chargement des Dossiers chez le Chargé d'Etudes
									  public void chargeDossierAutorisation() {
									    	 dossDacListe.clear();
									    	 //ECRAN DE SAISIE
											   if(controleController.ecran=="saisie") {
												   dossDacListe = ((List<VDossierDac>)iservice.getObjectsByColumnDesc("VDossierDac",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
										 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,dao.getDacCode())));	
											   }else
												 //ECRAN DE MODIFICATION
											   {
												   dossDacListe = ((List<VDossierDac>)iservice.getObjectsByColumnDesc("VDossierDac",new ArrayList<String>(Arrays.asList("DDA_DTE_SAISI")),
										 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getDacCode())));	 
											   }		
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
									
									
							/*		public void activieComboxAutoSpec() {
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
									}*/
									
									public void activieComboxAutoSpec() {
										if(listeMembreComSpec.size()==0) {
											dossDacListe = ((List<VDossierDac>)iservice.getObjectsByColumn("VDossierDac",new ArrayList<String>(Arrays.asList("DDA_ID")),
											new WhereClause("DDA_DAC_CODE",Comparateur.EQ,dao.getDacCode())));
											
											for(VDossierDac doss : dossDacListe) {	
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
				
									
									//Methode de validation après correction
									public void correction() {
										   listCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
													  new WhereClause("COR_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
										   
										   if(listCorrection.size()>0) {
											     daoCorr= listCorrection.get(0);
									        	 daoCorr.setCorObservation(getObservationCor());
									        	 daoCorr.setCorFoncodValid(userController.getSlctd().getTOperateur().getOpeNom());
									        	 daoCorr.setCorResultat(resultat);
											     iservice.updateObject(daoCorr);
											     
											     //MAJ dans T_DAC_SPECS
											     listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
										 				if (!listDao.isEmpty()) {
										 					newDao= listDao.get(0);
										 					newDao.setTStatut(new TStatut(statutSanction));
										 					newDao.setDacStatutRetour(statutSanRetour);
										 			        iservice.updateObject(newDao); 
										 	   	                 } 
										 		  //FIN dans T_DAO_AFFECTATION	
										 				
										 		daoBinome =(List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
					                    				new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
					                    					if (!daoBinome.isEmpty()) {
					                    					 //Mis  jour de tous les DAO dans T_DAO_AFFECTATION
					                    								for(TDaoAffectation dao : daoBinome) {
					                    									 dao.setDafStaCode(statutSanction);
					                    									 dao.setDafStatutRetour(statutSanRetour);
					                    									 iservice.updateObject(dao);
					                    								  }
				                                               }
										 				
											     //Activation du bouton d'dition du PV
										 		 etatPV = true;
								     			 etatValiderCsv = false;
								     			//Methode d'historisation 
								     			historiser(""+statutSanction,newDao.getDacCode(),"DAC validé par le chef de service");
								     			//Mesage de confirmation
												 userController.setTexteMsg("Dac validé avec succès!");
												 userController.setRenderMsg(true);
												 userController.setSevrityMsg("success");
										   }else {
											     //MAJ dans T_DAC_SPECS
											     listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
										 				if (!listDao.isEmpty()) {
										 					newDao= listDao.get(0);
										 					newDao.setTStatut(new TStatut(statutSanction));
										 					newDao.setDacStatutRetour(statutSanRetour);
										 			        iservice.updateObject(newDao); 
										 	   	                 } 
										 		  //FIN dans T_DAO_AFFECTATION	
										 				
										 		daoBinome =(List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
					                    				new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
					                    					if (!daoBinome.isEmpty()) {
					                    					 //Mis  jour de tous les DAO dans T_DAO_AFFECTATION
					                    								for(TDaoAffectation dao : daoBinome) {
					                    									 dao.setDafStaCode(statutSanction);
					                    									 dao.setDafStatutRetour(statutSanRetour);
					                    									 iservice.updateObject(dao);
					                    								  }
				                                               }
										 				
											     //Activation du bouton d'dition du PV
										 		 etatPV = true;
								     			 etatValiderCsv = false;
								     			
								     			historiser(""+statutSanction,newDao.getDacCode(),"DAC rejeté par le chef de service");
								     			
												 userController.setTexteMsg("Dac validé avec succès!");
												 userController.setRenderMsg(true);
												 userController.setSevrityMsg("success");
										   }  
									}
									
									
									//Methode de validation après correction
									public void correctionVal() {
										   listCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
													  new WhereClause("COR_DAC_CODE",Comparateur.EQ,""+slctdTd.getDacCode()));
										   
										   if(listCorrection.size()>0) {
											     daoCorr= listCorrection.get(0);
									        	 daoCorr.setCorObservation(getObservationCor());
									        	 daoCorr.setCorFoncodValid(userController.getSlctd().getTOperateur().getOpeNom());
									        	 daoCorr.setCorResultat(resultat);
											     iservice.updateObject(daoCorr);
											     
											     //MAJ dans T_DAC_SPECS
											     listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
										 				if (!listDao.isEmpty()) {
										 					newDao= listDao.get(0);
										 					newDao.setTStatut(new TStatut(statutSanction));
										 					newDao.setDacStatutRetour(statutSanRetour);
										 			        iservice.updateObject(newDao); 
										 	   	                 } 
										 		  //FIN dans T_DAO_AFFECTATION	
										 				
										 		daoBinome =(List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
					                    				new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
					                    					if (!daoBinome.isEmpty()) {
					                    					 //Mis  jour de tous les DAO dans T_DAO_AFFECTATION
					                    								for(TDaoAffectation dao : daoBinome) {
					                    									 dao.setDafStaCode(statutSanction);
					                    									 dao.setDafStatutRetour(statutSanRetour);
					                    									 iservice.updateObject(dao);
					                    								  }
				                                               }
										 				
											     //Activation du bouton d'dition du PV
										 		 etatPV = true;
								     			 etatValiderCsv = false;
								     			//Methode d'historisation 
								     			historiser(""+statutSanction,newDao.getDacCode(),"DAC validé par le chef de service");
								     			//Mesage de confirmation
												 userController.setTexteMsg("Dac validé avec succès!");
												 userController.setRenderMsg(true);
												 userController.setSevrityMsg("success");
										   }else {
											     //MAJ dans T_DAC_SPECS
											 //Message d'erreur
												FacesContext.getCurrentInstance().addMessage(null,
														new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ce dossier d'appel à la concurrence n'a pas fait l'objet de correction", ""));
											  
										   }  
									}
				
									
									
									//Validation des corrections
									@Transactional 
									 public void resultatCorrection() {
										
                                                   if(resultat.equalsIgnoreCase("Valide")){
										        	  
                                                        	if(slctdTd.getDacMopCode().equalsIgnoreCase("AOR") || slctdTd.getDacMopCode().equalsIgnoreCase("DPA") ||
                                                        			slctdTd.getDacMopCode().equalsIgnoreCase("DPS")) {
														                 statutSanction ="DAP";
														                 statutSanRetour ="0";
													                  }else {

																	        if(slctdTd.getDacMention().equalsIgnoreCase("A Valider pour publication")) {
																		        statutSanction ="DPU";
																		          statutSanRetour ="0";
																		    	
																	                  }else{
																	                         if(slctdTd.getDacMention().equalsIgnoreCase("A Valider et retour  l'AC")){
																	    	                   statutSanction ="D5V";
																			                   statutSanRetour ="0";
																	                         }
														                                }
													                  }
                                                        	
													        correctionVal();
													        
										                         }else{

										                         	     if(resultat.equalsIgnoreCase("Rejete")) {
												                                  statutSanction ="D1R";
												                                  statutSanRetour ="1";
												                                  
												                                //Appel de la methode de correction         
							                                                        correction();
											                                }else{

											                                	   if(resultat.equalsIgnoreCase("Retour au binome")) {
												                                        statutSanction ="D3A";
												                                        statutSanRetour ="1";
												                                      //Appel de la methode de correction         
								                                                        correction();
										                                        }
										                                 }
                                                                  }
                                                   //Appel de la methode de correction         
                                                       // correction();
									}
								//Fin de la validation des corrections
			
									
									  
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
									 				
									 				daoBinome =(List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
						                    				new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
						                    					if (!daoBinome.isEmpty()) {
						                    					 //Mis  jour de tous les DAO dans T_DAO_AFFECTATION
						                    						for(TDaoAffectation dao : daoBinome) {
						                    								dao.setDafStaCode(statutUpdate);
						                    								iservice.updateObject(dao);
						                    							}
					                                               }
									 				
									 			  constantService.getStatut(statutUpdate);
					 							  	//Historisation du / des retraits
					 						       historiser(""+statutUpdate,newDao.getDacCode(),"DAO Publié avec succès");
					 						       
					 						      tableauBordController.saveTempTabord(""+statutUpdate, newDao.getTTypeDacSpecs().getTdcCode(), ""+userController.getSlctd().getTFonction().getFonCod(), newDao.getDacTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), newDao.getDacCode());

					 						      chargetataPub();
														
												  //chargeData();
												  //Actualisation du tableau de bord
												  typeActionTb();
												  //Message de confirmation
												  userController.setTexteMsg("DAC Publié!");
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
										  
										  
										  
										  
										  
										   //Methode de vrification
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
													               
													                //Recupration du DAO dans T_DAC_SPECS
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
											     					           userController.setTexteMsg("Retrait éffectué avec succès");
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
												 						       //historiser("DVE",newDao.getDacCode(),"DAO payé");
												 				     
												 						     THistoDac dacStatut = new THistoDac();
												 						     dacStatut.setHacDate(Calendar.getInstance().getTime());
												 						     dacStatut.setHacCommentaire("DAO payé");
												 						     dacStatut.setTStatut(new TStatut("DVE"));
												 						     dacStatut.setTDacSpecs(newDao);
												 						     dacStatut.setHacDveNum(venteDetail.getDveNum());
												 						     dacStatut.setTFonction(userController.getSlctd().getTFonction());
												 						     dacStatut.setTOperateur(userController.getSlctd().getTOperateur());
												 						     iservice.addObject(dacStatut);	
												 						     
											     			  				   //Activation du bouton dition du rcu
											     			  				   confirmPaie = true;
											     			  				   confirmInter = false;
											     			  				   etatRecu = true;
											     			  				   clean = true;
											     			  				   
											     			  				   //Actualisation du Tableau de Bord
											     			 		           typeActionTb();
											     			 		          
											     			 		           chargeData();
											      			  				   //Message de Confirmation
											      					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectuÃ¯Â¿Â½ avec succÃ¯Â¿Â½s", ""));
											      					           userController.setTexteMsg("Paiement effectué avec succs");
											      							   userController.setRenderMsg(true);
											      							   userController.setSevrityMsg("success");
													                 }
												                   }    
											                }
											  //Fin Methode de Paiement
											  
											  //vider les champs aprs un paiement
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
												listeDetailVente.clear();
												listeDetailVente = (List<VDacVendu>) iservice.getObjectsByColumn("VDacVendu", new ArrayList<String>(Arrays.asList("DVE_DAC_CODE")),
								      			  		 new WhereClause("DVE_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()),
								      			  		 new WhereClause("DVE_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					      			  		             if (!listeDetailVente.isEmpty()) {
					      			  			            detailVente= listeDetailVente.get(0);
					      			  				    }
					      			  		         recupNcc() ;  
											  }
											  
											  //Methode de récupération des NCC
											  public void recupNcc() {
												  listOffreCandidat = (List<VInfoNcc>) iservice.getObjectsByColumn("VInfoNcc", new ArrayList<String>(Arrays.asList("V_ID")),
									      			  		 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
											  }
											  
											  //Suppression de la vente
											  public void removeNcc() {
												  
												  listeHisto = ((List<THistoDac>)iservice.getObjectsByColumn("THistoDac",
														    new WhereClause("HAC_DVE_NUM",Comparateur.EQ,""+offreCandidat.getDveNum())));
										    				for(THistoDac histo : listeHisto) {	
										    				    iservice.deleteObject(histo);
										    			}
										    			
										    				listeDetVet = ((List<TDetailVente>)iservice.getObjectsByColumn("TDetailVente",
										    					    new WhereClause("DVE_NUM",Comparateur.EQ,""+offreCandidat.getDveNum())));
										    	    				for(TDetailVente detailVente : listeDetVet) {	
										    	    				iservice.deleteObject(detailVente);
										    	    			}
										    				
										    	    				listeVetDac = ((List<TVenteDac>)iservice.getObjectsByColumn("TVenteDac",
														               new WhereClause("VEN_NUM",Comparateur.EQ,""+offreCandidat.getVenNum())));
										    	    				       for(TVenteDac vente : listeVetDac) {	
											    	    				     iservice.deleteObject(vente);
											    	    			          }	
										    			
										    			
										    	    				         listeCanDac = ((List<TCandidats>)iservice.getObjectsByColumn("TCandidats",
																	               new WhereClause("CAN_CODE",Comparateur.EQ,""+offreCandidat.getVenNum())));
													    	    				       for(TCandidats candidat : listeCanDac) {	
														    	    				     iservice.deleteObject(candidat);
														    	    			          }	
													    	    				       
													    	    				       
													    	    				 recupNcc();
													    	    				 //Message de Suppression
													    	           		  	FacesContext.getCurrentInstance().addMessage(null,
																				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Suppression éffectuée avec succès!", ""));
											  }
											  
											  
											//Methode de paiement pour entreprise internationale
											  @Transactional
											  public void payerInt() {
												  if(newCandidat.getCanNom().equalsIgnoreCase("") ||newCandidat.getCanPrenoms().equalsIgnoreCase("") || sitDac == null) {
													//Message d'erreur
														FacesContext.getCurrentInstance().addMessage(null,
																new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir le candidat ou choisir votre option", ""));
													  
												      }else { 
												    	  
												    	  //Contrle sur la vente ou le retrait
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
												 						       historiser("RET",newDao.getDacCode(),"DAO retir");
														  				
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
														FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le NCC n'est pas inscrit dans la base des Marchs Publics! ", "")); 	 
													}
												 }
											  
												 //Dbut de la vente du DAO
													public void finVente() {
														String statUpdate = "";
														String message = "";
														if(slctdTd.getDacStaCode().equalsIgnoreCase("DAP")) {
															statUpdate = "DVE";
															message="Fin de la vente du Dossier d'Appel d'Offres N° "+slctdTd.getDacCode();
														 }
														
														if(slctdTd.getDacMopCode().equalsIgnoreCase("PSL")) {
															listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
																	new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
																	if (!listAvis.isEmpty()) {
																		//Mis à jour du statut
																		majAvis= listAvis.get(0);
																		majAvis.setTStatut(new TStatut("APU"));
																		majAvis.setAaoDtePub(Calendar.getInstance().getTime());
																		iservice.updateObject(majAvis);
																}
														 }
														//Recupration du DAO dans T_DAC_SPECS
											            listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
								     			  		 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
								     			  		    if (!listDao.isEmpty()) {
								     			  			  newDao= listDao.get(0);
								     			  			  newDao.setTStatut(new TStatut(statUpdate));
										                      iservice.updateObject(newDao);
								     			  			}
								     			  		 
								     			  		//Historisation du / des retraits
								 						 historiser(""+statUpdate,newDao.getDacCode(),"DAO vendu");
													
														//Chargement de la liste des ventes et celle du tableau de Bord
														chargeData();
														typeActionTb();
														userController.setTexteMsg(message);
														userController.setRenderMsg(true);
														userController.setSevrityMsg("success");  
													}
											        //Fin de la vente du DAO
													
													
													 //Dbut de l'affectation du DAO
													public void finAffectation() {
														String statUpdate = "";
														String message = "";
														if(slctdTd.getDacStaCode().equalsIgnoreCase("D2T")) {
															statUpdate = "D3A";
															message="Fin de l'affectation du Dossier d'Appel d'Offres N° "+slctdTd.getDacCode();
														 }
														//Recupration du DAO dans T_DAC_SPECS
											            listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
								     			  		 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
								     			  		    if (!listDao.isEmpty()) {
								     			  			  newDao= listDao.get(0);
								     			  			  newDao.setTStatut(new TStatut(statUpdate));
										                      iservice.updateObject(newDao);
								     			  			}
								     			  		    
								     			  	    //Changement de Statut dans T_Dao_Affectation
								     			  		 daoExamen = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")),
							          	     					 new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
							          	     				   if (!daoExamen.isEmpty()) {
							          	     					      for(TDaoAffectation ligneDac : daoExamen) {
							          	     					    	     ligneDac.setDafStaCode("D3A");
							          	     					    	     iservice.updateObject(ligneDac); 
							          	     					           }
							          	     				      }
							          	     				historiser(""+statUpdate,slctdTd.getDacCode(),"");
														//Chargement de la liste des ventes et celle du tableau de Bord
														chargeData();
														typeActionTb();
														userController.setTexteMsg(message);
														userController.setRenderMsg(true);
														userController.setSevrityMsg("success");  
													}
											        //Fin de l'affectation du DAO
													
													
													//Dbut de retrait du DAO
													 public void finRetrait() {
														String statRetrait = "";
														String message = "";
														if(slctdTd.getDacStaCode().equalsIgnoreCase("DAP")) {
															statRetrait = "RET";
															message="Fin de retrait du Dossier d'Appel d'Offres N"+slctdTd.getDacCode();
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
													
													
													//Rcupration du montant du DAO
													  public void recupMontantDao() { 
														  dacVente = (List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_CODE")),
																      //new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
																      //new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
																	  new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
																      if (!dacVente.isEmpty()) {
																    	  recupCout= dacVente.get(0); 
													   	              }	
																      
																     //Controle sur la vente ou le retrait
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
																					 chargeDataAPublier("DAO","PN","DAP","DAP");	
																					//chargeDataAPublier("AMI","PS","PUB","PUB");
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
																				    	   chargeDataAPublier("DAO", "PS","DAP","DAP");	
																				    	 //chargeDataAPublier("AMI","PS","PUB","PUB");
																				     }else {
																				 }	 
																			 }
																       //Fin affichage  CSV 
																	 }
																	//}
																}else
																	 if(controleController.type == "AMI" && controleController.typePlan == "PN") {
																		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																                //Affichage des differentes listes du Chef de Service Procdure en fonction de l'action
																	       if(fonct.equalsIgnoreCase("listeAmiCsv")) {
																		      chargeDataAPublier("AMI", "PN","D6V","DPU");	
																	        }else {
																		       if(fonct.equalsIgnoreCase("listeDamiCsv")) {
																		    	   chargeDataAPublier("AMI","PN","DAP","DAP");
																		    	 //chargeDataAPublier("AMI","PS","PUB","PUB");
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
																			    	   chargeDataAPublier("AMI","PS","DAP","DAP");
																			    	 //chargeDataAPublier("AMI","PS","PUB","PUB");
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
														 								 String fonct = controleController.getFonctionalite();
														 								if(fonct.equalsIgnoreCase("listeDpubCsv")) {
														 								/*	stat1="PUB";
														 									publieListe =(List<VAvisPublie>) iservice.getObjectByColumnInPublicationCsvInstr("VAvisPublie",""+stat1,""+userController.getSlctd().getTFonction().getFonCod());
														 									_logger.info("action: "+fonct);
														 									_logger.info("publieListe size: "+publieListe.size());*/
														 								}else {
														 									 publicationListe =(List<VDacliste>) iservice.getObjectByColumnInPubCsvInstr("VDacliste",""+stat1,""+stat2,""+typePlan,""+userController.getSlctd().getTFonction().getFonCod()); 
															 								 /* publicationListe =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
															 										 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
															 										 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
															 										 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
															 								        // multiFiltre ="";
	*/														 									_logger.info("publicationListe size: "+publicationListe.size());	
															 									typeActionTb(); 	
														 								}
														 								
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
		    	 listeMembre.clear();
		    	 ouvTech = null;
		    	 docNature = "";
		    	 dossListe.clear();
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
		    	 btn_dao_modif = false;
		     }
		     
		     
		     
		     //Methode pour vider la liste des critres du lot 0
		     public void viderCritereLot0() {
		    	 /*listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
						    new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,"0"),
						    new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		    	 
		     //Parcourir la liste VPpmListe et faire une mise a jour des different statut
			  for(TDetCritAnalyseDac crit : listeDetCritere) { 
				  iservice.deleteObject(crit); 
		  		  chargeCritereSaisie();
		  		  chargeCritere();
			  	  userController.setTexteMsg("Liste des critres vide avec succs!");
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
		  		 
		  		
		  		 //ECRAN DE SAISIE
				   if(controleController.ecran=="saisie") {
					   newTempFactSup.setTempCritDac(dao.getDacCode());
				   }else
					 //ECRAN DE MODIFICATION
				   {
					   newTempFactSup.setTempCritDac(slctdTd.getDacCode());  
				   }
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
		     
		     
		     //Methode pour vider la liste des critres (lot par lot)
		     public void viderCritereByLot() {
		    	 //ECRAN DE SAISIE
				   if(controleController.ecran=="saisie") {
					   listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
							    new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
							    new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
				   }else
					 //ECRAN DE MODIFICATION
				   {
					   listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
							    new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId),
							    new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
					   
				   }
		    	
		    	 
		     //Parcourir la liste VPpmListe et faire une mise a jour des different statut
			  for(TDetCritAnalyseDac crit : listeDetCritere) {  
				  iservice.deleteObject(crit); 
			      chargeCritereByLot();
			      chargeCritereFactCombobox();
			      chargeLotCritere();
			  	  userController.setTexteMsg("Liste des critres vide avec succs!");
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
			  	 userController.setTexteMsg("Liste des critres vide avec succs!");
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
					     historiser(""+statutPub, newDao.getDacCode(),"Opration publie par la DGMP");
					     
                        //Actualisation du Tableau de Bord
					     typeActionTb();
					    //Rafraichissement de la liste
						 chargeDaoPUB();
						//Message de confirmation		  
						 userController.setTexteMsg(" Publication effectue avec succs !");
						 userController.setRenderMsg(true);
						 userController.setSevrityMsg("success");
						//return null;
				 		
				 		        }	   
					 		   }	
						     }
	     //Fin de la methode de Publication
			  
			  
			  
	 //Ensembles methode Ecran de modification
			  public void actionsPavetCreation() {
				 //chargeOperationsExiste();
				 infoDao();
				 recupInfo();
				 panelOuverture();
				 verifOuvertureModif();
				 controleModeModif();
				 chargeDetailAdresseModif();
		         chargeAdresse();
		         checkMargePrefModif();
		         listeMargePrefModif();
		         chargeLibelleAdresse();
		         actualisationDac();
			  }
			  
		public void actionsPavetLot() {
			//updateAao();
			chargeLotsUpdate();
			montantTotalLotModif();
		}
		
		public void actionsPavetCritere() {
			chargeCritere();
			chargeCritereSaisie();
		}
		
		
		public void actionsPavetCritereByLot() {
			listeCritereByLot.clear();
			//factoriserLot();
			factoriserNext();
			chargeCritereByLot();
			recupMessage();
		}
		
		public void actionPavetCojo() {
			chargeMembres();	
			chargeMembreCommission();
		}
			
         
       //Fin Ensembles methode Ecran de modification
		     
		
		public void visibleAffecte() {
			if(controleController.getFonctionalite().equalsIgnoreCase("listeConsultAffectationCsv")) {
				btnAffecte=true;
				btnAffecteNormal = false;
			}else {
				btnAffecte=false;	
				btnAffecteNormal = true;
			}
		}
		
		public void visibleAffecteCet() {
			if(controleController.getFonctionalite().equalsIgnoreCase("listeConsultAffectationCet")) {
				btnAffecte1=true;
			}else {
				btnAffecte1=false;	
			}
		}
		     
	
		public void filterByMois() {
			publieListe =(List<VAvisPublie>) iservice.getObjectByColumnInPublicationRechercheMoisCsvInstr("VAvisPublie",""+mois,""+userController.getSlctd().getTFonction().getFonCod());
			_logger.info("liste pulier"+publieListe);	
			_logger.info("mois"+mois);//mois
		}
		
		public void filterByStatut() {
			publieListe =(List<VAvisPublie>) iservice.getObjectByColumnInPublicationRechercheStatutCsvInstr("VAvisPublie",""+statut,""+userController.getSlctd().getTFonction().getFonCod());
			_logger.info("liste pulier"+publieListe.size());	
			_logger.info("Statut"+statut);
		}
		
		public void filterByProcedure() {
			listeDAO =(List<VDacliste>) iservice.getObjectByColumnInInstrFiltre("VDacliste",""+statut,""+userController.getSlctd().getTFonction().getFonCod());
			_logger.info("liste dao à l'affectation : "+listeDAO.size());	
			_logger.info("Statut : "+statut);
		}
		
		public void filterByProcedureVal() {
			listeDAO =(List<VDacliste>) iservice.getObjectByColumnInInstrValDaoFiltre("VDacliste",""+statut,""+userController.getSlctd().getTFonction().getFonCod());
			_logger.info("liste dao à l'affectation : "+listeDAO);	
			_logger.info("Statut : "+statut);
		}
		
		public void filtrePulication() {
			if(statut.equalsIgnoreCase("")) {
				filterByMois();	
			}else {
				if(mois.equalsIgnoreCase("")) {
					filterByStatut();	
				}
				
			}
		}
		     
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);	 
		     switch(value) {
				case "dao1":
					chargeData();
					chargeDetailTB();
					chargeNatureDocTrans();
					visibleAffecte();
					visibleAffecteCet();
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
                     pavet_infoG = false;
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
                	chargePiecesCsv();
                	chargePiecesByCharges();
                	chargeDossierCharge();
            		natureDoc("COR");
                    //chargeRespoExiste();
                	activePavetRespo();
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
                	chargeOperationsExiste();
                	chargePiecesDao();
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

/*	public TDossierDacs getSelectedDossier() {
		return selectedDossier;
	}

	public void setSelectedDossier(TDossierDacs selectedDossier) {
		this.selectedDossier = selectedDossier;
	}*/
	

	public VDossierDac getSelectedDossier() {
		return selectedDossier;
	}

	public void setSelectedDossier(VDossierDac selectedDossier) {
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

/*	public List<TDossierDacs> getDossListe() {
		return dossListe;
	}

	public void setDossListe(List<TDossierDacs> dossListe) {
		this.dossListe = dossListe;
	}*/

	public List<TDaoAffectation> getListeDaoChargeValid() {
		return listeDaoChargeValid;
	}

	public void setListeDaoChargeValid(List<TDaoAffectation> listeDaoChargeValid) {
		this.listeDaoChargeValid = listeDaoChargeValid;
	}
/*
	public List<TDossierDacs> getDossDacListe() {
		return dossDacListe;
	}

	public void setDossDacListe(List<TDossierDacs> dossDacListe) {
		this.dossDacListe = dossDacListe;
	}
*/
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

/*	public long getrIdSous() {
		return rIdSous;
	}

	public void setrIdSous(long rIdSous) {
		this.rIdSous = rIdSous;
	}*/
	
	public String getrIdSous() {
		return rIdSous;
	}

	public void setrIdSous(String rIdSous) {
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
 
	//POUR WINDOWS - LAURENT
		 public void chargeDaoFileIndex() throws IOException {	
			 
			  //* Chargement des PSL  FOURNITURES - TRAVAUX - PRESTATIONS
			  

			 if((daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("0"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("0A")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("00")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("01")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("02")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("03")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("04")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("05")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("06")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("07")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("08")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("09")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("0"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("0A")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("00")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("01")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("02")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("03")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("04")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("05")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("06")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("07")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("08")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("09"))
				) {
				 setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSL))));
				 _logger.info("Dossier de rfrence PSL charg");
			 }
			 
			if(	(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("2"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("20")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("21")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("22")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("23")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("25")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("26")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("2"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("20")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("21")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("22")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("23")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("25")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSL))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			if(	(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("10")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1A")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1B")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1C")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1D")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("12")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("13")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("14")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("15")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("16")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("17")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("18")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("19")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("10")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1A")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1B")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1C")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1D")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("11")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("12")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("13")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("14")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("15")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("16")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("17")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("18")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSL))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			
			 //* Chargement des PSO  FOURNITURES - TRAVAUX - PRESTATIONS
			 
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("0"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("0A")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("00")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("01")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("02")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("03")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("04")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("05")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("06")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("07")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("08")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("09")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("0"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("0A")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("00")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("01")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("02")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("03")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("04")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("05")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("06")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("07")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("08")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("09"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("2"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("20")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("21")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("22")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("23")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("25")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("26")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("2"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("20")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("21")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("22")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("23")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("25")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("10")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1A")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1B")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1C")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1D")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("12")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("13")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("14")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("15")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("16")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("17")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("18")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("19")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("10")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1A")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1B")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1C")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1D")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("11")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("12")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("13")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("14")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("15")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("16")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("17")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("18")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("11"))	
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS))));
				_logger.info("Dossier de rfrence charg");
			}
			
			
			  //* Chargement des AAO FOURNITURES - TRAVAUX - PRESTATIONS
			  
			 
			if(	(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOO")) ||
					(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOR"))
				
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES))));
				_logger.info("DAO FOURNITURE charg");
				}
			 
			if(	(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOO")) ||
					(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX))));
				_logger.info("DAO TRAVAUX ROUTES ELECTRICITE charg");
				}
			
			// CARBURANT
			if(	daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("AOO") ||
					daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("AOR")) {
					setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_CARBURANT_LEGER))));
					_logger.info("DAO CARBURANT charg");
					}
			
			//Prestation courante 10
			if( (daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOO")) || // PRESTATION
				(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOO")) || // ORDURES MENAGERES
				(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO")) || // ASSURANCES 17
				(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOO")) || // BLANCHISSERIE 12
					(daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATION))));
				_logger.info("DAO Prestations courantes charg");
				}
			
			// Restauration
			if( daoAao.getTymCode().equals("16") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("16") && daoAao.getDacMopCode().equals("AOR")
					) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_RESTAURATIONS))));
				_logger.info("DAO Restauration charg");
				}
			
			// LOCATION DE MAIN D'OEUVRES 
			if(	daoAao.getTymCode().equals("15") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("15") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES))));
				_logger.info("DAO LOCATION DE MAIN D'OEUVRES charg");
				}
			
			// GESTION DE MAIN D'OEUVRES
			if(	daoAao.getTymCode().equals("19") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("19") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES))));
				_logger.info("DAO GESTION DE MAIN D'OEUVRES charg");
				}
			
			// SECURITE PRIVEE 
			if(	daoAao.getTymCode().equals("14") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("14") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_SECURITE_PRIVEE))));
				_logger.info("DAO SECURITE PRIVEE charg");
				}
			
			// ENTRETIENS ESPACES VERTS ET LOCAUX 13
			if(	daoAao.getTymCode().equals("13") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("13") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX))));
				_logger.info("DAO ENTRETIEN DES LOCAUX charg");
			}
			
			// ASSURANCE 
			if(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO") || daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ASSURANCE))));
				_logger.info("DAO SECURITE PRIVEE charg");
			}
		 }
		 //FIN WINDOWS
		 
		 
		//POUR WINDOWS - LAURENT
		/* public void chargeDaoFileIndex() throws IOException {	
			 
			  * Chargement des PSL  FOURNITURES - TRAVAUX - PRESTATIONS
			  

			 if((slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("0"))  ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("0A")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("00")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("01")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("02")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("03")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("04")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("05")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("06")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("07")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("08")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("09")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("0"))  ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("0A")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("00")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("01")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("02")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("03")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("04")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("05")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("06")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("07")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("08")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("09"))
				) {
				 setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSL))));
				 _logger.info("Dossier de rfrence PSL charg");
			 }
			 
			if(	(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("2"))  ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("20")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("21")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("22")) ||	
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("23")) ||	
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("25")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("26")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("2"))  ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("20")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("21")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("22")) ||	
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("23")) ||	
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("25")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSL))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			if(	(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1"))  ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("10")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1A")) ||	
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1B")) ||	
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1C")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1D")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("11")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("12")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("13")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("14")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("15")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("16")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("17")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("18")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("19")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1"))  ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("10")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1A")) ||	
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1B")) ||	
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1C")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1D")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("11")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("12")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("13")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("14")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("15")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("16")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("17")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("18")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSL))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			
			 * Chargement des PSO  FOURNITURES - TRAVAUX - PRESTATIONS
			 
			
			if(	(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("0"))  ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("0A")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("00")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("01")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("02")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("03")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("04")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("05")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("06")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("07")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("08")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("09")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("0"))  ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("0A")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("00")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("01")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("02")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("03")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("04")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("05")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("06")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("07")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("08")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("09"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("2"))  ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("20")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("21")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("22")) ||	
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("23")) ||	
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("25")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("26")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("2"))  ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("20")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("21")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("22")) ||	
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("23")) ||	
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("25")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1"))  ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("10")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1A")) ||	
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1B")) ||	
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1C")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1D")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("11")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("12")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("13")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("14")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("15")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("16")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("17")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("18")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("19")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1"))  ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("10")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1A")) ||	
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1B")) ||	
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1C")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1D")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("11")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("12")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("13")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("14")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("15")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("16")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("17")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("18")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("11")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("11"))	
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS))));
				_logger.info("Dossier de rfrence charg");
			}
			
			
			  * Chargement des AAO FOURNITURES - TRAVAUX - PRESTATIONS
			  
			 
			if(	(slctdTd.getTymCode().equals("0")  && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("00") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("0A") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("01") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("02") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("03") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("04") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("06") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("07") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("08") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("09") && slctdTd.getDacMopCode().equals("AOO")) ||
					(slctdTd.getTymCode().equals("0")  && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("00") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("0A") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("01") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("02") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("03") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("04") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("06") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("07") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("08") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("09") && slctdTd.getDacMopCode().equals("AOR"))
				
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES))));
				_logger.info("DAO FOURNITURE charg");
				}
			 
			if(	(slctdTd.getTymCode().equals("2")  && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("20") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("21") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("22") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("23") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("25") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("26") && slctdTd.getDacMopCode().equals("AOO")) ||
					(slctdTd.getTymCode().equals("2")  && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("20") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("21") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("22") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("23") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("25") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("26") && slctdTd.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX))));
				_logger.info("DAO TRAVAUX ROUTES ELECTRICITE charg");
				}
			
			// CARBURANT
			if(	slctdTd.getTymCode().equals("05") && slctdTd.getDacMopCode().equals("AOO") ||
					slctdTd.getTymCode().equals("05") && slctdTd.getDacMopCode().equals("AOR")) {
					setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_CARBURANT_LEGER))));
					_logger.info("DAO CARBURANT charg");
					}
			
			//Prestation courante 10
			if( (slctdTd.getTymCode().equals("10") && slctdTd.getDacMopCode().equals("AOO")) || // PRESTATION
				(slctdTd.getTymCode().equals("18") && slctdTd.getDacMopCode().equals("AOO")) || // ORDURES MENAGERES
				(slctdTd.getTymCode().equals("17") && slctdTd.getDacMopCode().equals("AOO")) || // ASSURANCES 17
				(slctdTd.getTymCode().equals("12") && slctdTd.getDacMopCode().equals("AOO")) || // BLANCHISSERIE 12
					(slctdTd.getTymCode().equals("10") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("18") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("17") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("12") && slctdTd.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATION))));
				_logger.info("DAO Prestations courantes charg");
				}
			
			// Restauration
			if( slctdTd.getTymCode().equals("16") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("16") && slctdTd.getDacMopCode().equals("AOR")
					) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_RESTAURATIONS))));
				_logger.info("DAO Restauration charg");
				}
			
			// LOCATION DE MAIN D'OEUVRES 
			if(	slctdTd.getTymCode().equals("15") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("15") && slctdTd.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES))));
				_logger.info("DAO LOCATION DE MAIN D'OEUVRES charg");
				}
			
			// GESTION DE MAIN D'OEUVRES
			if(	slctdTd.getTymCode().equals("19") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("19") && slctdTd.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES))));
				_logger.info("DAO GESTION DE MAIN D'OEUVRES charg");
				}
			
			// SECURITE PRIVEE 
			if(	slctdTd.getTymCode().equals("14") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("14") && slctdTd.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_SECURITE_PRIVEE))));
				_logger.info("DAO SECURITE PRIVEE charg");
				}
			
			// ENTRETIENS ESPACES VERTS ET LOCAUX 13
			if(	slctdTd.getTymCode().equals("13") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("13") && slctdTd.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX))));
				_logger.info("DAO ENTRETIEN DES LOCAUX charg");
			}			
		 }
		 */
		 //FIN WINDOWS
		 
		 //POUR LINUX - LAURENT
	public void chargeDaoFile() throws IOException {		 
			 
			  //Chargement des PSL  FOURNITURES - TRAVAUX - PRESTATIONS
			  
			 if((daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("0"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("0A")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("00")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("01")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("02")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("03")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("04")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("06")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("07")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("08")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("09")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("0"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("0A")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("00")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("01")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("02")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("03")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("04")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("06")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("07")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("08")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("09"))
				) {
				 setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSL_LINUX))));
				 _logger.info("Dossier de rfrence PSL charg");
			 }
			 
			if(	(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("2"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("20")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("21")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("22")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("23")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("25")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("26")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("2"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("20")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("21")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("22")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("23")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("25")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSL_LINUX))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			if(	(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("10")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1A")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1B")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1C")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1D")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("12")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("13")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("14")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("15")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("16")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("17")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("18")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("19")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("10")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1A")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1B")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1C")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1D")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("11")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("12")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("13")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("14")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("15")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("16")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("17")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("18")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSL_LINUX))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			  //Chargement des PSO  FOURNITURES - TRAVAUX - PRESTATIONS
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("0"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("0A")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("00")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("01")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("02")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("03")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("04")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("06")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("07")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("08")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("09")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("0"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("0A")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("00")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("01")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("02")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("03")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("04")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("06")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("07")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("08")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("09"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSO_LINUX))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("2"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("20")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("21")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("22")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("23")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("25")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("26")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("2"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("20")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("21")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("22")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("23")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("25")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSO_LINUX))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("10")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1A")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1B")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1C")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1D")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("12")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("13")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("14")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("15")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("16")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("17")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("18")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("19")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("10")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1A")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1B")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1C")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1D")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("11")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("12")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("13")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("14")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("15")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("16")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("17")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("18")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSO_LINUX))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("11"))	
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS_LINUX))));
				_logger.info("Dossier de rfrence charg");
			}
			
			
			  // Chargement des AAO FOURNITURES - TRAVAUX - PRESTATIONS
			  
			 
			if(	(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOO")) ||
					(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOR"))
				
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES_LINUX))));
				_logger.info("DAO FOURNITURE charg");
				}
			 
			if(	(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOO")) ||
					(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX_LINUX))));
				_logger.info("DAO TRAVAUX ROUTES ELECTRICITE charg");
				}
			
			// CARBURANT
			if(	daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("AOO") ||
					daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("AOR") ||
					daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("PSL") ||
					daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("PLR") ||
					daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("PSO") ||
					daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("POR")) {
					setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_CARBURANT_LEGER_LINUX))));
					_logger.info("DAO CARBURANT charg");
					}
			
			//Prestation courante 10
			if( (daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOO")) || // PRESTATION
				(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOO")) || // ORDURES MENAGERES
				(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO")) || // ASSURANCES 17
				(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOO")) || 	  // BLANCHISSERIE 12
					(daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATIONS_LINUX))));
				_logger.info("DAO Prestations courantes charg");
				}
			
			// Restauration
			if( daoAao.getTymCode().equals("16") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("16") && daoAao.getDacMopCode().equals("AOR")
					) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_RESTAURATIONS_LINUX))));
				_logger.info("DAO Restauration charg");
				}
			
			// LOCATION DE MAIN D'OEUVRES 
			if(	daoAao.getTymCode().equals("15") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("15") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES_LINUX))));
				_logger.info("DAO LOCATION DE MAIN D'OEUVRES charg");
				}
			
			// GESTION DE MAIN D'OEUVRES
			if(	daoAao.getTymCode().equals("19") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("19") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES_LINUX))));
				_logger.info("DAO GESTION DE MAIN D'OEUVRES charg");
				}
			
			// SECURITE PRIVEE 
			if(	daoAao.getTymCode().equals("14") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("14") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_SECURITE_PRIVEE_LINUX))));
				_logger.info("DAO SECURITE PRIVEE charg");
				}
			
			// ENTRETIENS ESPACES VERTS ET LOCAUX 13
			if(	daoAao.getTymCode().equals("13") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("13") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX))));
				_logger.info("DAO ENTRETIEN DES LOCAUX charg");
			}
			
			// ASSURANCE 
			if(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO") || daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ASSURANCE_LINUX))));
				_logger.info("DAO SECURITE PRIVEE charg");
			}
				
		 }
	    
	/* private List<XWPFParagraph> collectParagraphs() {
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
	 }*/
		 
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
	
	/* public List<String> getBookmarkNames(){
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
	}*/
	 
	public List<String> getBookmarkNames() {
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
	 
	public void printBmk() {
			 List<String> bmkNameL = getBookmarkNames();
				//List<String> ignore = new ArrayList<String>()
						
				for (String i:bmkNameL) {
					if (i.contains("_Toc")) {
						continue;
					}
					if (i.contains("Block")) {
						continue;
					}
					if (i.contains("_Hlt")) {
						continue;
					}
					if (i.contains("OLE")) {
						continue;
					}
					if (i.contains("_GoBack")) {
						continue;
					}
					_logger.info(i);
				}
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

/*	private void procParaList(List<XWPFParagraph> paraList, String bookmarkName,
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
	}*/
	
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
			_logger.info("Infos DAO charges");
			_logger.info(daoIter.getDacObjet());
			_logger.info(daoIter.getTymCode());
		}
	}
	
	public void getInfoAao() {
		infoAao = (ArrayList<VdAao>) iservice.getObjectsByColumn("VdAao", new WhereClause("DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoDao.isEmpty()) {
			aaoIter = infoAao.get(0);
			_logger.info("Infos AAO charges");
			_logger.info(aaoIter.getDacCode());
			_logger.info(aaoIter.getLaaObjet());
		}
	}

	public void getInfoAdresse() {
		infoAdresse = (ArrayList<VxAdresse>) iservice.getObjectsByColumn("VxAdresse", new WhereClause("DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoAdresse.isEmpty()) {
			adresseIter = infoAdresse.get(0);
			_logger.info("Infos sur l'adresse charges");
			_logger.info(adresseIter.getDacCode());
			_logger.info(adresseIter.getLibdetail());
		}
	}
	
	public void getInfoLots() {
		infoLots = (ArrayList<VbLotAao>) iservice.getObjectsByColumn("VbLotAao", new WhereClause("LAA_DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoLots.isEmpty()) {
			lotsIter = infoLots.get(0);
			_logger.info("Infos sur les lots charges");
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
			_logger.info("Infos sur les lots chargs");
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
							_logger.info("DPAO_IC_7_1_adresse_clarification_20 remplace");
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
							
							_logger.info("DPAO_IC_17_2_delai_execution_20 remplace");
							if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_20")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_20", daoIter.getAaoDelaiVal().toString());
							if(bookmarkNames.contains("DPAO_IC_20_2_cautionnemant_provisoire_20")) replaceBookmarkByValue("DPAO_IC_20_2_cautionnemant_provisoire_20", aaoIter.getLaaMtCaut().toString());
							if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_20")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_20", daoIter.getDacNbrCopieOff().toString());
							
							if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_20", adresseIter.getLibdetail());
							_logger.info("DPAO_IC_23_1_adresse_remise_20 remplace");
							
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
							_logger.info("DPAO_IC_23_1_heure_20 remplace");
							
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
			_logger.info("DPAO_IC_7_1_adresse_clarification_20 remplac");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_20", ""); // clarification dbut
			//if(bookmarkNames.contains("DPAO_IC_7_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_7_1_boite_postale_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_numero_telephone_20")) replaceBookmarkByValue("DPAO_IC_7_1_numero_telephone_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_electronique_20", ""); // clarification fin 
			
			/*if(bookmarkNames.contains("DPAO_IC_7_4_lieu_20")) replaceBookmarkByValue("DPAO_IC_7_4_lieu_20", ""); // pour les visites sur site debut
			if(bookmarkNames.contains("DPAO_IC_7_4_date_20")) replaceBookmarkByValue("DPAO_IC_7_4_date_20", ""); 
			if(bookmarkNames.contains("DPAO_IC_7_4_heure_20")) replaceBookmarkByValue("DPAO_IC_7_4_heure_20", ""); // pour les visites sur site fin
*/			
			//if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", String.valueOf(daoIter.getLaaDelaiExe()));
			
			if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", daoIter.getLaaDelaiExe().toString());
			
			_logger.info("DPAO_IC_17_2_delai_execution_20 remplac");
			if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_20")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_20", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_IC_20_2_cautionnemant_provisoire_20")) replaceBookmarkByValue("DPAO_IC_20_2_cautionnemant_provisoire_20", aaoIter.getLaaMtCaut().toString());
			if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_20")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_20", daoIter.getDacNbrCopieOff().toString());
			
			if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_23_1_adresse_remise_20 remplac");
			
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
			_logger.info("DPAO_IC_23_1_heure_20 remplac");
			
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
			_logger.info("DPAO_IC_7_1_adresse_clarification_20 remplac");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_20", ""); // clarification dbut
			//if(bookmarkNames.contains("DPAO_IC_7_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_7_1_boite_postale_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_numero_telephone_20")) replaceBookmarkByValue("DPAO_IC_7_1_numero_telephone_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_electronique_20", ""); // clarification fin 
			
			/*if(bookmarkNames.contains("DPAO_IC_7_4_lieu_20")) replaceBookmarkByValue("DPAO_IC_7_4_lieu_20", ""); // pour les visites sur site debut
			if(bookmarkNames.contains("DPAO_IC_7_4_date_20")) replaceBookmarkByValue("DPAO_IC_7_4_date_20", ""); 
			if(bookmarkNames.contains("DPAO_IC_7_4_heure_20")) replaceBookmarkByValue("DPAO_IC_7_4_heure_20", ""); // pour les visites sur site fin
*/			
			//if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", String.valueOf(daoIter.getLaaDelaiExe()));
			
			if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", daoIter.getLaaDelaiExe().toString());
			
			_logger.info("DPAO_IC_17_2_delai_execution_20 remplac");
			if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_20")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_20", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_IC_20_2_cautionnemant_provisoire_20")) replaceBookmarkByValue("DPAO_IC_20_2_cautionnemant_provisoire_20", aaoIter.getLaaMtCaut().toString());
			if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_20")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_20", daoIter.getDacNbrCopieOff().toString());
			
			if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_23_1_adresse_remise_20 remplac");
			
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
			_logger.info("DPAO_IC_23_1_heure_20 remplac");
			
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
				
			// Donnes particulier de l'appel d'offre
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
				
			// Donnes particulier de l'appel d'offre
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
				
			// Donnes particulier de l'appel d'offre
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
				
			// Donnes particulier de l'appel d'offre
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
				
			// Donnes particulier de l'appel d'offre
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
				
			// Donnes particulier de l'appel d'offre
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
		_logger.info("Bookmarks remplacs");
	}
	
	/// methode pour telecharger le dao
	public void telechargerDao() throws IOException {
			downloadFileServlet.downloadFile(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME, DOWNLOAD_FILENAME); 
		}
	//Fin de la Methode
	
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
		
	/*public void insertPermStart(String start, String id) {
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
	}*/

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
	
	/*public void insertPermEnd(String end, String id) {
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
	}*/

	/*public void setProtect() {		
		getDocument().enforceReadonlyProtection("emap31032020", none);
		System.out.println("protg");
	}*/
	
	//SetProtect - LAURENT
	public void setProtect() {
		if(	(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOO")) || // PRESTATION
				(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOO")) || // ORDURES MENAGERES
				(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO")) || // ASSURANCES 17
				(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOO"))
					) {
		getDocument().enforceReadonlyProtection("emap31032020", none);
		System.out.println("protg");
		}
	}
	
	//WINDOWS - LAURENT
		/* public void saveDaoFile() throws IOException {
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("00") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSL;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("10") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSL;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("20") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSL;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("00") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSO;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("10") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSO;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("20") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSO;
			 }
			 
			 if((daoAao.getDacMopCode().equals("PSO") || daoAao.getDacMopCode().equals("PSL")) && daoAao.getTymCode().equals("11")) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_PRESTATIONS_INTELLECTUELLES;
				}
			 
			 //TRAVAUX
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("26") ||
					 										daoAao.getTymCode().equals("21") ||
					 										daoAao.getTymCode().equals("22") ||
					 										daoAao.getTymCode().equals("23") ||
					 										daoAao.getTymCode().equals("25") ||
					 										daoAao.getTymCode().equals("20")
					 										))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
			 }
			 
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("26") ||
															daoAao.getTymCode().equals("21") ||
															daoAao.getTymCode().equals("22") ||
															daoAao.getTymCode().equals("23") ||
															daoAao.getTymCode().equals("25") ||
															daoAao.getTymCode().equals("20")
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
				}
			 
			 //FOURNITURES
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("01") ||
															daoAao.getTymCode().equals("02") ||
															daoAao.getTymCode().equals("03") ||
															daoAao.getTymCode().equals("04") ||
															daoAao.getTymCode().equals("06") ||
															daoAao.getTymCode().equals("07") ||
															daoAao.getTymCode().equals("08") ||
															daoAao.getTymCode().equals("09") ||
															daoAao.getTymCode().equals("0A") 
															))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("01") ||
															daoAao.getTymCode().equals("02") ||
															daoAao.getTymCode().equals("03") ||
															daoAao.getTymCode().equals("04") ||
															daoAao.getTymCode().equals("06") ||
															daoAao.getTymCode().equals("07") ||
															daoAao.getTymCode().equals("08") ||
															daoAao.getTymCode().equals("09") ||
															daoAao.getTymCode().equals("0A") 
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
				}
			 
			// PRESTATIONS
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;
				}
			 
			 // DAO RESTAURATION
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATIONS;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATIONS;
				}
			 
			 // LOCATION DE MAIN D'OEUVRE - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES;
				}
			 
			 // GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRES;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRES;
				}
			 
			 // SECURITE PRIVEE ou GARDIENNAGE
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE;
				}
			 
			// ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX;
				}
			 
			// FOURNITURE DE CARBURANT
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER;
				}
			 
			 _logger.info("path: "+DOWNLOAD_PATHNAME);
			 DOWNLOAD_FILENAME = dao.getDacObjet() +"_" + dao.getDacCode()+ ".docx";
			 getDocument().write(new FileOutputStream(new File(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME )));
		 }*/
		 //WINDOWS
		  
		//WINDOWS - LAURENT
	public void saveDaoFileIndex() throws IOException {
			 if(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("00") ||
				(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSL;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("10") ||
				(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSL;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("20") ||
				(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSL;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("00") ||
				(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSO;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("10") ||
				(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSO;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("20") ||
				(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSO;
			 }
			 
			 if((slctdTd.getDacMopCode().equals("PSO") || slctdTd.getDacMopCode().equals("PSL")) && slctdTd.getTymCode().equals("11")) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_PRESTATIONS_INTELLECTUELLES;
				}
			 
			 //TRAVAUX
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("26") ||
					 										slctdTd.getTymCode().equals("21") ||
					 										slctdTd.getTymCode().equals("22") ||
					 										slctdTd.getTymCode().equals("23") ||
					 										slctdTd.getTymCode().equals("25") ||
					 										slctdTd.getTymCode().equals("20")
					 										))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
			 }
			 
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("26") ||
															slctdTd.getTymCode().equals("21") ||
															slctdTd.getTymCode().equals("22") ||
															slctdTd.getTymCode().equals("23") ||
															slctdTd.getTymCode().equals("25") ||
															slctdTd.getTymCode().equals("20")
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
				}
			 
			 //FOURNITURES
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("01") ||
															slctdTd.getTymCode().equals("02") ||
															slctdTd.getTymCode().equals("03") ||
															slctdTd.getTymCode().equals("04") ||
															slctdTd.getTymCode().equals("06") ||
															slctdTd.getTymCode().equals("07") ||
															slctdTd.getTymCode().equals("08") ||
															slctdTd.getTymCode().equals("09") ||
															slctdTd.getTymCode().equals("0A") 
															))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("01") ||
															slctdTd.getTymCode().equals("02") ||
															slctdTd.getTymCode().equals("03") ||
															slctdTd.getTymCode().equals("04") ||
															slctdTd.getTymCode().equals("06") ||
															slctdTd.getTymCode().equals("07") ||
															slctdTd.getTymCode().equals("08") ||
															slctdTd.getTymCode().equals("09") ||
															slctdTd.getTymCode().equals("0A") 
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
				}
			 
			// PRESTATIONS
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;
				}
			 
			 // DAO RESTAURATION
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATIONS;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATIONS;
				}
			 
			 // LOCATION DE MAIN D'OEUVRE - (Services courants)
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES;
				}
			 
			 // GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRES;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRES;
				}
			 
			 // SECURITE PRIVEE ou GARDIENNAGE
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE;
				}
			 
			// ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX;
				}
			 
			// FOURNITURE DE CARBURANT
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER;
				}
			 
			// ASSURANCE
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("17") ))) {
			 	DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ASSURANCE;
			 }
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("17") ))) {
			 	DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ASSURANCE;
			 }
			 
			 _logger.info("path: "+DOWNLOAD_PATHNAME);
			 DOWNLOAD_FILENAME = dao.getDacObjet() +"_" + dao.getDacCode()+ ".docx";
			 getDocument().write(new FileOutputStream(new File(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME )));
		 }
		 //
		 
		//LINUX
	public void saveDaoFile() throws IOException {
				 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("00") ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSL_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("10") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSL_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("20") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSL_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("00") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSO_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("10") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSO_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("20") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSO_LINUX;
			 }
			 
			 if((daoAao.getDacMopCode().equals("PSO") || daoAao.getDacMopCode().equals("PSL")) && daoAao.getTymCode().equals("11")) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_PRESTATIONS_INTELLECTUELLES_LINUX;
				}
			 
			 //TRAVAUX
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("26") ||
					 										daoAao.getTymCode().equals("21") ||
					 										daoAao.getTymCode().equals("22") ||
					 										daoAao.getTymCode().equals("23") ||
					 										daoAao.getTymCode().equals("25") ||
					 										daoAao.getTymCode().equals("20")
					 										))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX;
			 }
			 
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("26") ||
															daoAao.getTymCode().equals("21") ||
															daoAao.getTymCode().equals("22") ||
															daoAao.getTymCode().equals("23") ||
															daoAao.getTymCode().equals("25") ||
															daoAao.getTymCode().equals("20")
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX;
				}
			 
			 //FOURNITURES
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("01") ||
															daoAao.getTymCode().equals("02") ||
															daoAao.getTymCode().equals("03") ||
															daoAao.getTymCode().equals("04") ||
															daoAao.getTymCode().equals("06") ||
															daoAao.getTymCode().equals("07") ||
															daoAao.getTymCode().equals("08") ||
															daoAao.getTymCode().equals("09") ||
															daoAao.getTymCode().equals("0A") 
															))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("01") ||
															daoAao.getTymCode().equals("02") ||
															daoAao.getTymCode().equals("03") ||
															daoAao.getTymCode().equals("04") ||
															daoAao.getTymCode().equals("06") ||
															daoAao.getTymCode().equals("07") ||
															daoAao.getTymCode().equals("08") ||
															daoAao.getTymCode().equals("09") ||
															daoAao.getTymCode().equals("0A") 
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX;
				}
			 
			// PRESTATIONS
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX;
				}
			 
			 // DAO RESTAURATION
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATION_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATION_LINUX;
				}
			 
			 // LOCATION DE MAIN D'OEUVRE - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_LINUX;
				}
			 
			 // GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRE_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRE_LINUX;
				}
			 
			 // SECURITE PRIVEE ou GARDIENNAGE
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE_LINUX;
				}
			 
			// ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX;
				}
			 
			// FOURNITURE DE CARBURANT
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("PSL") && (daoAao.getTymCode().equals("05") ))) {
					DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("PLR") && (daoAao.getTymCode().equals("05") ))) {
					DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("PSO") && (daoAao.getTymCode().equals("05") ))) {
					DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("POR") && (daoAao.getTymCode().equals("05") ))) {
					DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX;
				}
			 
			// ASSURANCE
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("17") ))) {
			 	DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ASSURANCE_LINUX ;
			 }
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("17") ))) {
			 	DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ASSURANCE_LINUX ;
			 }
			 
			 _logger.info("path: "+DOWNLOAD_PATHNAME);
			 DOWNLOAD_FILENAME = "DAO_" + dao.getDacCode()+ ".docx";
			 getDocument().write(new FileOutputStream(new File(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME )));
				}

	public void verrouillage() {
		switch(String.valueOf(daoAao.getTymCode().charAt(0))) {		 
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
	
	/* new variables */
	private List<VbxDocDaoAao> lDA = new ArrayList<VbxDocDaoAao>();
	private VbxDocDaoAao daoAao = new VbxDocDaoAao();
	private List<VbxDocLot> lLts = new ArrayList<VbxDocLot>(); // Liste des lots
	private VbxDocLot lots02 = new VbxDocLot();
	private List<VbxDocCommission> lCom = new ArrayList<VbxDocCommission>();
	private VbxDocCommission commission = new VbxDocCommission();
	private List<VbxDocAdrRetrait> lAdr = new ArrayList<VbxDocAdrRetrait>();
	private VbxDocAdrRetrait adresse = new VbxDocAdrRetrait();
	
	List<String> lBmkNm = new ArrayList<String>();
	
	public void getDaoAao() {
		lDA.clear();
		lDA = (List<VbxDocDaoAao>) iservice.getObjectsByColumn("VbxDocDaoAao", new ArrayList<String>(Arrays.asList("LAA_NUM")),new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		if(!lDA.isEmpty()) daoAao = lDA.get(0);
		_logger.info(daoAao.getAaoLibelle());
	}

	public void getListLots() {
		lLts.clear();
		lLts = (List<VbxDocLot>) iservice.getObjectsByColumn("VbxDocLot", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		_logger.info("infos sur les lots chargs");
	}

	public void getListCommission() {
		lCom.clear();
		lCom = (List<VbxDocCommission>) iservice.getObjectsByColumn("VbxDocCommission",
				new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		_logger.info("infos sur la commission chargs");
	}

	public void getListAdresse02() {
		lAdr.clear();
		lAdr = (List<VbxDocAdrRetrait>) iservice.getObjectsByColumn("VbxDocAdrRetrait",new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		_logger.info("infos sur les adresses charges");
	}
	
	/* Fin new variables */
	
	public String printDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		String jour = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
		String mois = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE);
		mois = mois.substring(0, 1).toUpperCase() + mois.substring(1);
		String annee = Integer.toString(calendar.get(Calendar.YEAR));
		String dateF= jour + " " + mois + " " + annee;
		return dateF;
		//System.out.println(dateF);
	}
	
	public static String getDayNowF() {
		LocalDate localDate = LocalDate.now() ;
		String dayString = localDate.getDayOfWeek().toString();
		int dayInt = localDate.getDayOfMonth();
		Month month = localDate.getMonth();
		int year = localDate.getYear();
		String dateNow = dayString + " " + dayInt + " "+ month + " " + year;
		return dateNow;
	}
	
	public static String getDayNow() {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
		String date09 = simpleDateFormat.format(new Date());
		return date09;
	}
	
	public void rplBmkByVal(List<String> lBmkNm, List<VbxDocLot> lLts, List<VbxDocAdrRetrait> adr, VbxDocDaoAao daoAao, List<VbxDocCommission> commission ) {
		
		//PAGE DE GARDE ET DE TITRE
		if(lBmkNm.contains("PG_min")) {
			XWPFParagraph para = getDocument().createParagraph();
			para.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun run01 = para.createRun();
			run01.setText(daoAao.getMinLibelle().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(20);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173"); //0a5700
			getBookmarkParentNode("PG_min").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_min"));
		}
		if(lBmkNm.contains("PG_min_02")) {
			XWPFParagraph para = getDocument().createParagraph();
			para.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun run01 = para.createRun();
			run01.setText(daoAao.getMinLibelle().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173"); //0a5700
			getBookmarkParentNode("PG_min_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_min_02"));
		}		
		if(lBmkNm.contains("PG_ac")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(18);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_ac").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_ac"));
		}
		if(lBmkNm.contains("PG_ac_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(20);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_ac_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_ac_02"));
		}		
		if(lBmkNm.contains("PG_gestion")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getGesCode()));
			run01.setBold(true);
			run01.setFontSize(14);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_gestion").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_gestion"));
		}
		if(lBmkNm.contains("PG_gestion_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getGesCode()));
			run01.setBold(true);
			run01.setFontSize(18);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_gestion_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_gestion_02"));
		}		
		if(lBmkNm.contains("PG_objet")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(22);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_objet").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_objet"));
		}		
		if(lBmkNm.contains("PG_objet_03")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_objet_03").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_objet_03"));
		}		
		if(lBmkNm.contains("PG_moisAnGestion")) {
			Calendar c = Calendar.getInstance();
			String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
			String mg = mois + "/" + daoAao.getGesCode();
			
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(mg);
			run01.setBold(true);
			run01.setFontSize(16);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_moisAnGestion").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_moisAnGestion"));
		}		
		if(lBmkNm.contains("PG_objet_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(28);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_objet_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_objet_02"));
		}
		if(lBmkNm.contains("PG_imputation_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getLaaLbgImputation());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("PG_imputation_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_imputation_02"));
		}

		// AVIS D'APPEL D'OFFRE
		if(lBmkNm.contains("AAO_ac")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_ac").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_ac"));
		}
		if(lBmkNm.contains("AAO_ac")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_ac").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_ac"));
		}
		if(lBmkNm.contains("AAO_min")) {
			XWPFParagraph para = getDocument().createParagraph();
			XWPFRun run01 = para.createRun();
			run01.setText(daoAao.getMinLibelle().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173"); //0a5700
			getBookmarkParentNode("AAO_min").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_min"));
		}
		if(lBmkNm.contains("AAO_objet")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_objet").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_objet"));
		}
		if(lBmkNm.contains("AAO_nombre_lots")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoNbrLot().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_nombre_lots").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_nombre_lots"));
		}
		if(lBmkNm.contains("AAO_nombre_lots_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoNbrLot().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_nombre_lots_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_nombre_lots_02"));
		}
		if(lBmkNm.contains("AAO_table_lots")) {
			XWPFParagraph para = getDocument().createParagraph();
			para.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun run01 = para.createRun();
			for(VbxDocLot i:lLts) {
				run01.setText("- Lot " + i.getLaaNum()+ ": " + i.getLaaObjet());
				run01.addBreak();
				run01.addBreak();
			}
		getBookmarkParentNode("AAO_table_lots").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_table_lots"));
		}
		if(lBmkNm.contains("AAO_source_financement")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacFinancement());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_source_financement").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_source_financement"));
		}
		if(lBmkNm.contains("AAO_imputation")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getLaaLbgImputation());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_imputation").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_imputation"));
		}
		if(lBmkNm.contains("AAO_gestion")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getGesCode()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_gestion").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_gestion"));
		}
		if(lBmkNm.contains("AAO_cout_dao")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getAaoCoutDac()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_cout_dao").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_cout_dao"));
		}
		if(lBmkNm.contains("AAO_adresse_retrait")) {
		}
		if(lBmkNm.contains("AAO_date_remise")) {
			Date date = daoAao.getAaoDateRecep();
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(printDate(daoAao.getAaoDateRecep()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_date_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_date_remise"));
		}
		if(lBmkNm.contains("AAO_heure_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoHeureRecep().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_heure_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_heure_remise"));
		}
		if(lBmkNm.contains("AAO_lieu_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoLieuRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_lieu_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_lieu_remise"));
		}
		if(lBmkNm.contains("AAO_date_ouverture")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(printDate(daoAao.getAaoDteOuvFin()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_date_ouverture").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_date_ouverture"));
		}
		if(lBmkNm.contains("AAO_table_caution")) {	
		}
		if(lBmkNm.contains("AAO_adresse_retrait")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			int i=0;
			while(i<lLts.size())  {
				run01.setText(lAdr.get(i).getDtaLibelle());
				run01.setShadow(true);
				run01.addBreak();
				i++;
				}
			getBookmarkParentNode("AAO_adresse_retrait").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_adresse_retrait")); 
		}
		if(lBmkNm.contains("AAO_delai_validite")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(daoAao.getAaoDelaiVal().toString());	
			getBookmarkParentNode("AAO_delai_validite").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_delai_validite"));
		}
		if(lBmkNm.contains("AAO_date")) {
			//String date = getDayNow();
		}
		
		// LETTRE D'INVITATION AU CANDIDAT
		if(lBmkNm.contains("LC_date_invitation")) {	
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");	
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(getDayNow());	
			getBookmarkParentNode("LC_date_invitation").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_date_invitation"));
		}
		if(lBmkNm.contains("LC_adresse_entreprise")) {
		}
		if(lBmkNm.contains("LC_ac_02")) {	
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("LC_ac_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_ac_02"));
		}
		if(lBmkNm.contains("LC_objet")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("LC_objet").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_objet"));
		}
		if(lBmkNm.contains("LC_reference_courrier")) {	
		}
		if(lBmkNm.contains("LC_table_entreprise")) {	
		}
		if(lBmkNm.contains("LC_adresse_retrait")) {		
		}
		if(lBmkNm.contains("LC_cout_dao")) {	
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getAaoCoutDac()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("LC_cout_dao").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_cout_dao"));
		}
		if(lBmkNm.contains("LC_date_remise")) {	
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(printDate(daoAao.getAaoDateRecep()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("LC_date_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_date_remise"));
		}
		if(lBmkNm.contains("LC_heure_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoHeureRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("LC_heure_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_heure_remise"));
		}
		if(lBmkNm.contains("LC_lieu_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoLieuRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("LC_lieu_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_lieu_remise"));
		}
		if(lBmkNm.contains("LC_date_ouverture")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(printDate(daoAao.getAaoDteOuvFin()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("LC_date_ouverture").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_date_ouverture"));
		}
		if(lBmkNm.contains("LC_delai_validite")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(daoAao.getAaoDelaiVal().toString());	
			getBookmarkParentNode("LC_delai_validite").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_delai_validite"));
		}
		
		// DPAO - RPAO
		if(lBmkNm.contains("DPAO_ac")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_ac").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_ac"));
		}
		if(lBmkNm.contains("DPAO_ac01")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_ac01").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_ac01"));
		}
		if(lBmkNm.contains("DPAO_nombre_lots")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoNbrLot().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			if(bookmarkNames.contains("DPAO_nombre_lots"))
			getBookmarkParentNode("DPAO_nombre_lots").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_lots"));
		}
		if(lBmkNm.contains("DPAO_nombre_lots_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoNbrLot().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_nombre_lots_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_lots_02"));
		}
		if(lBmkNm.contains("DPAO_objet")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_objet").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_ac"));
		}
		if(lBmkNm.contains("DPAO_table_lots")) {
			XWPFRun run07 = document.createParagraph().createRun();
			int i = 0;					
			while(i<lLts.size()) {
				String k = "- Lot n" + lLts.get(i).getLaaNum() + ": " + lLts.get(i).getLaaObjet();
				run07.setText(k);
				run07.setBold(true);
				run07.setFontSize(12);
				run07.setFontFamily("Times New Roman");
				run07.setCapitalized(false);
				run07.setColor("000000");
				run07.addBreak();
				run07.addBreak();
				i++;
			}
			getBookmarkParentNode("DPAO_table_lots").insertBefore(run07.getCTR().getDomNode(), getBookmarkNode("DPAO_table_lots"));
		}
		if(lBmkNm.contains("DPAO_source_financement")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacFinancement());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_source_financement").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_source_financement"));
		}
		if(lBmkNm.contains("DPAO_imputation")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getLaaLbgImputation());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_imputation").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_imputation"));
		}
		if(lBmkNm.contains("DPAO_table_du_personnel")) {
		}
		
		if(lBmkNm.contains("DPAO_table_des_materiels")) {
		}
				// Section pour les DAO de fournitures
		if(lBmkNm.contains("DPAO_lieu_destination")) {
		}
		
		if(lBmkNm.contains("DPAO_adresse_clarification")) {
		}
		
		if(lBmkNm.contains("DPAO_adresse_reunion_preparatoire")) {	
		}
		
		if(lBmkNm.contains("AAO_table_cautionnement")) {
		}
		
		if(lBmkNm.contains("DPAO_adresse_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_delai_execution")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			if(daoAao.getAaoNbrLot().intValueExact()== 1) {
				run01.setText(daoAao.getLaaDelaiExe().toString());	
				} 
				else {
					run01.setText("");	
				}
			getBookmarkParentNode("DPAO_delai_execution").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_delai_execution"));
		}
		if(lBmkNm.contains("DPAO_lieu_livraison")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(daoAao.getAaoLieuExe());	
			getBookmarkParentNode("DPAO_lieu_livraison").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_lieu_livraison"));
		}
		if(lBmkNm.contains("DPAO_delai_validite")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(daoAao.getAaoDelaiVal().toString());
			getBookmarkParentNode("DPAO_delai_validite").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_delai_validite"));
		}
		if(lBmkNm.contains("DPAO_cautionnement_provisoire")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			//if(daoAao.getAaoNbrLot().intValueExact()== 1)
			if(lLts.size() == 1)
				run01.setText(aaoIter.getLaaMtCaut().toString()); 
				else run01.setText("");	
				
			getBookmarkParentNode("DPAO_cautionnement_provisoire").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_cautionnement_provisoire"));
		}
		if(lBmkNm.contains("DPAO_nombre_copie")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacNbrCopieOff().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_nombre_copie").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_copie"));
		}
		if(lBmkNm.contains("DPAO_nombre_copie_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacNbrCopieOff().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_nombre_copie_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_copie_02"));
		}
		if(lBmkNm.contains("DPAO_adresse_remise")) {
		}
		if(lBmkNm.contains("DPAO_date_remise")) {
			Date date = daoAao.getAaoDateRecep();
			
			String pattern = "EEEEE dd MMMMM yyyy";
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
			String date09 = simpleDateFormat.format(date);
			System.out.println(date09);
			
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(date09);
			//run01.setText(daoAao.getAaoDateRecep().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_date_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_date_remise"));
		}
		if(lBmkNm.contains("DPAO_lieu_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoLieuRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_lieu_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_lieu_remise"));
		}
		if(lBmkNm.contains("DPAO_heure_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoHeureRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_heure_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_heure_remise"));
		}
		if(lBmkNm.contains("DPAO_adresse_ouverture")) {
		}
		if(lBmkNm.contains("DPAO_adresse_conference_prealable")) {
		}
		if(lBmkNm.contains("DPAO_adresse_demande_eclaircissement")) {
		}
		if(lBmkNm.contains("DPAO_date_ouverture")) {
			Date date = daoAao.getAaoDteOuvFin();
			
			String pattern = "EEEEE dd MMMMM yyyy";
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
			String date09 = simpleDateFormat.format(date);
			
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(date09);
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_date_ouverture").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_date_ouverture"));
		}
		if(lBmkNm.contains("DPAO_heure_ouverture")) {
		}
		if(lBmkNm.contains("DPAO_table_cojo")) {
			XWPFParagraph para = getDocument().createParagraph();
			para.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun run07 = para.createRun();
			int i = 0;					
			while(i<lCom.size()) {
				//String k = lCom.get(i).getComTctTitre() + ": " + "\t" + lCom.get(i).getComTctLibelle();
				run07.setText(lCom.get(i).getComTctTitre() + ": " + "\t" + lCom.get(i).getComTctLibelle());
				run07.setBold(true);
				run07.setFontSize(12);
				run07.setFontFamily("Times New Roman");
				run07.setCapitalized(false);
				run07.setColor("001173");
				run07.addBreak();
				i++;
			}
			getBookmarkParentNode("DPAO_table_cojo").insertBefore(run07.getCTR().getDomNode(), getBookmarkNode("DPAO_table_cojo"));
		}
		if(lBmkNm.contains("AAO_table_cautionnement")) {
		}
		if(lBmkNm.contains("DPAO_heure_conference_prealable")) {
		}
		if(lBmkNm.contains("DPAO_reunion_preparatoire")) {
		}
		if(lBmkNm.contains("DPAO_heure_reunion_preparatoire")) {
		}
		if(lBmkNm.contains("DPAO_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_heure_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_mode_renumeration")) {
		}
		if(lBmkNm.contains("DPAO_texte_marche_renouvelable")) {
		}
		if(lBmkNm.contains("DPAO_marche_renouvelable")) {
		}
	}
	//Fin rplBmk
	
	public void style(XWPFParagraph paragraph, XWPFRun run, String policeFamilly, String policeColor, int policeTaille, Boolean bold, Boolean capitalized) {
		run.setFontFamily(policeFamilly);
		run.setColor(policeColor); //0a5700  - 001173
		run.setFontSize(policeTaille);
		run.setBold(bold);
		run.setCapitalized(capitalized);
	}
	
	public void replaceBookmarkByValue(List<String> lBmkNm, List<VbxDocLot> lLts, List<VbxDocAdrRetrait> adr, VbxDocDaoAao daoAao, List<VbxDocCommission> commission) {
		XWPFParagraph paragraph;
		XWPFRun run = null;
		
		/* PAGE DE GARDE */
		if(lBmkNm.contains("PG_min")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getMinLibelle().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 20, true, true);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_min").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_min"));
		}
		
		if(lBmkNm.contains("PG_min_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getMinLibelle().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 14, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_min_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_min_02"));
		}
		
		if(lBmkNm.contains("PG_ac")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 18, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_ac").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_ac"));
		}
		
		if(lBmkNm.contains("PG_ac_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 20, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_ac_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_ac_02"));
		}
		
		if(lBmkNm.contains("PG_gestion")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getGesCode()));
				style(paragraph, run, "Times New Roman", "001173", 20, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_gestion").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_gestion"));
		}
		
		if(lBmkNm.contains("PG_gestion_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getGesCode()));
				style(paragraph, run, "Times New Roman", "001173", 20, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_gestion_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_gestion_02"));
		}
		
		if(lBmkNm.contains("PG_objet")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 22, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_objet").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_objet"));
		}
		
		if(lBmkNm.contains("PG_objet_03")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_objet_03").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_objet_03"));
		}
		
		if(lBmkNm.contains("PG_moisAnGestion")) {	
			try {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoAao.getGesCode();
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(mg);
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_moisAnGestion").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_moisAnGestion"));
		}
		
		if(lBmkNm.contains("PG_objet_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_objet_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_objet_02"));
		}
		
		if(lBmkNm.contains("PG_imputation_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getLaaLbgImputation());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_imputation_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_imputation_02"));
		}
		
		/* AVIS D'APPEL D'OFFRE */
		if(lBmkNm.contains("AAO_ac")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_ac").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_ac"));
		}
		
		if(lBmkNm.contains("AAO_min")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getMinLibelle().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_min").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_min"));
		}
		
		if(lBmkNm.contains("AAO_objet")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_objet").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_objet"));
		}
		
		if(lBmkNm.contains("AAO_nombre_lots")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoNbrLot().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_nombre_lots").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_nombre_lots"));
		}
		
		if(lBmkNm.contains("AAO_nombre_lots_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoNbrLot().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_nombre_lots_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_nombre_lots_02"));
		}
		
		if(lBmkNm.contains("AAO_table_lots")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.LEFT);
				run = paragraph.createRun();
				for(VbxDocLot i:lLts) {
					run.setText("- Lot " + i.getLaaNum()+ ": " + i.getLaaObjet());
					run.addBreak();
					run.addBreak();
				}
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_table_lots").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_table_lots"));
		}
		
		if(lBmkNm.contains("AAO_source_financement")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacFinancement());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_source_financement").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_source_financement"));
		}
		
		if(lBmkNm.contains("AAO_imputation")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getLaaLbgImputation());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_imputation").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_imputation"));
		}
		

		if(lBmkNm.contains("AAO_gestion")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getGesCode()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_gestion").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_gestion"));
		}
		
		if(lBmkNm.contains("AAO_cout_dao")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getAaoCoutDac()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_cout_dao").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_cout_dao"));
		}
		
		if(lBmkNm.contains("AAO_adresse_retrait")) {
		}
		
		if(lBmkNm.contains("AAO_date_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(printDate(daoAao.getAaoDateRecep()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_date_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_date_remise"));
		}
		
		if(lBmkNm.contains("AAO_heure_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoHeureRecep().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_heure_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_heure_remise"));
		}
		
		if(lBmkNm.contains("AAO_lieu_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_lieu_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_lieu_remise"));
		}
		
		if(lBmkNm.contains("AAO_date_ouverture")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(printDate(daoAao.getAaoDteOuvFin()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_date_ouverture").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_date_ouverture"));
		}
		
		if(lBmkNm.contains("AAO_table_caution")) {	
		}
		
		if(lBmkNm.contains("AAO_adresse_retrait")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
				int i=0;
				while(i<lLts.size())  {
					run.setText(lAdr.get(i).getDtaLibelle());
					run.setShadow(true);
					run.addBreak();
					i++;
				}
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_adresse_retrait").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_adresse_retrait"));
		}
		
		if(lBmkNm.contains("AAO_delai_validite")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoDelaiVal().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_delai_validite").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_delai_validite"));
		}
		
		if(lBmkNm.contains("AAO_date")) {
			//String date = getDayNow();
		}
		
		/* LETTRE D'INVITATION AU CANDIDAT */
		if(lBmkNm.contains("LC_date_invitation")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(getDayNow());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_date_invitation").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_date_invitation"));
		}
		
		if(lBmkNm.contains("LC_ac_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_ac_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_ac_02"));
		}
		
		if(lBmkNm.contains("LC_objet")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_objet").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_objet"));
		}
		
		if(lBmkNm.contains("LC_reference_courrier")) {	
		}
		if(lBmkNm.contains("LC_table_entreprise")) {	
		}
		if(lBmkNm.contains("LC_adresse_retrait")) {		
		}
		
		if(lBmkNm.contains("LC_cout_dao")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getAaoCoutDac()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_cout_dao").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_cout_dao"));
		}
		
		if(lBmkNm.contains("LC_date_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(printDate(daoAao.getAaoDateRecep()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_date_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_date_remise"));
		}
		
		if(lBmkNm.contains("LC_heure_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoHeureRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_heure_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_heure_remise"));
		}
		
		if(lBmkNm.contains("LC_lieu_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_lieu_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_lieu_remise"));
		}
		
		if(lBmkNm.contains("LC_date_ouverture")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_date_ouverture").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_date_ouverture"));
		}
		
		if(lBmkNm.contains("LC_delai_validite")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoDelaiVal().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_delai_validite").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_delai_validite"));
		}
		
		/* DPAO - RPAO */
		if(lBmkNm.contains("DPAO_ac")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_ac").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_ac"));
		}
		
		if(lBmkNm.contains("DPAO_ac01")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_ac01").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_ac01"));
		}
		
		if(lBmkNm.contains("DPAO_nombre_lots")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoNbrLot().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_nombre_lots").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_lots"));
		}
		
		if(lBmkNm.contains("DPAO_nombre_lots_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoNbrLot().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_nombre_lots_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_lots_02"));
		}
		
		if(lBmkNm.contains("DPAO_objet")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_objet").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_objet"));
		}
		
		if(lBmkNm.contains("DPAO_table_lots")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				int i = 0;					
				while(i<lLts.size()) {
					String k = "- Lot nÂ°" + lLts.get(i).getLaaNum() + ": " + lLts.get(i).getLaaObjet();
					run.setText(k);
					run.setBold(true);
					run.setFontSize(12);
					run.setFontFamily("Times New Roman");
					run.setCapitalized(false);
					run.setColor("000000");
					run.addBreak();
					run.addBreak();
					i++;
				}
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_table_lots").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_table_lots"));
		}
		
		if(lBmkNm.contains("DPAO_source_financement")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacFinancement());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_source_financement").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_source_financement"));
		}
		
		if(lBmkNm.contains("DPAO_imputation")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getLaaLbgImputation());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_imputation").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_imputation"));
		}
		
		if(lBmkNm.contains("DPAO_table_du_personnel")) {
		}
		if(lBmkNm.contains("DPAO_table_des_materiels")) {
		}	// Section pour les DAO de fournitures
		if(lBmkNm.contains("DPAO_lieu_destination")) {
		}
		if(lBmkNm.contains("DPAO_adresse_clarification")) {
		}
		if(lBmkNm.contains("DPAO_adresse_reunion_preparatoire")) {	
		}
		if(lBmkNm.contains("AAO_table_cautionnement")) {
		}
		if(lBmkNm.contains("DPAO_adresse_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_delai_execution")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				if(daoAao.getAaoNbrLot().intValueExact()== 1) {
					run.setText(daoAao.getLaaDelaiExe().toString());	
				} 
				else {
					run.setText("");	
				}
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_delai_execution").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_delai_execution"));
		}
		
		if(lBmkNm.contains("DPAO_lieu_livraison")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuExe());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_lieu_livraison").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_lieu_livraison"));
		}
		
		if(lBmkNm.contains("DPAO_delai_validite")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoDelaiVal().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_delai_validite").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_delai_validite"));
		}
		
		if(lBmkNm.contains("DPAO_cautionnement_provisoire")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(aaoIter.getLaaMtCaut().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_cautionnement_provisoire").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_cautionnement_provisoire"));
		}
		
		if(lBmkNm.contains("DPAO_nombre_copie")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacNbrCopieOff().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_nombre_copie").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_copie"));
		}
		
		if(lBmkNm.contains("DPAO_nombre_copie_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacNbrCopieOff().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_nombre_copie_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_copie_02"));
		}
		
		if(lBmkNm.contains("DPAO_adresse_remise")) {
		}
		
		if(lBmkNm.contains("DPAO_date_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				Date date = daoAao.getAaoDateRecep();
				String pattern = "EEEEE dd MMMMM yyyy";
				SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
				String date09 = simpleDateFormat.format(date);
				System.out.println(date09);
				run.setText(date09);
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_date_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_date_remise"));
		}
		
		if(lBmkNm.contains("DPAO_lieu_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_lieu_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_lieu_remise"));
		}
		
		if(lBmkNm.contains("DPAO_heure_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoHeureRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_heure_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_heure_remise"));
		}
		
		if(lBmkNm.contains("DPAO_adresse_ouverture")) {
		}
		if(lBmkNm.contains("DPAO_adresse_conference_prealable")) {
		}
		if(lBmkNm.contains("DPAO_adresse_demande_eclaircissement")) {
		}
		
		if(lBmkNm.contains("DPAO_date_ouverture")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				Date date = daoAao.getAaoDteOuvFin();
				String pattern = "EEEEE dd MMMMM yyyy";
				SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
				String date09 = simpleDateFormat.format(date);
				run.setText(date09);
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_date_ouverture").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_date_ouverture"));
		}
		
		if(lBmkNm.contains("DPAO_heure_ouverture")) {
		}
		
		if(lBmkNm.contains("DPAO_table_cojo")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				int i = 0;					
				while(i<lCom.size()) {
					//String k = lCom.get(i).getComTctTitre() + ": " + "\t" + lCom.get(i).getComTctLibelle();
					run.setText(lCom.get(i).getComTctTitre() + ": " + "\t" + lCom.get(i).getComTctLibelle());
					run.setBold(true);
					run.setFontSize(12);
					run.setFontFamily("Times New Roman");
					run.setCapitalized(false);
					run.setColor("001173");
					run.addBreak();
					i++;
				}
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_table_cojo").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_table_cojo"));
		}
		
		if(lBmkNm.contains("AAO_table_cautionnement")) {
		}
		if(lBmkNm.contains("DPAO_heure_conference_prealable")) {
		}
		if(lBmkNm.contains("DPAO_reunion_preparatoire")) {
		}
		if(lBmkNm.contains("DPAO_heure_reunion_preparatoire")) {
		}
		if(lBmkNm.contains("DPAO_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_heure_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_mode_renumeration")) {
		}
		if(lBmkNm.contains("DPAO_texte_marche_renouvelable")) {
		}
		if(lBmkNm.contains("DPAO_marche_renouvelable")) {
		}
		
		_logger.info("bookmark remplacÃ© Ã§a marche");
	}
	
	public void getDocumentProperties() {
		List<CTProperty> customProperties = getDocument().getProperties().getCustomProperties().getUnderlyingProperties().getPropertyList();
		for(int i=0; i<customProperties.size(); i++) {
			CTProperty property = customProperties.get(i);
			String propertyName = customProperties.get(i).getName();
			String propertyValue = customProperties.get(i).getLpwstr();
			System.out.println(propertyName + " : " + propertyValue);
		}
	}
	
	public void setDocumentProperty(String name, String value) {
		POIXMLProperties.CustomProperties  customProperties = getDocument().getProperties().getCustomProperties();
		if(!customProperties.contains(name)) {
			customProperties.addProperty(name, value);
		}
	}
	
	public String getDocumentPropertyValue (String documentPropertyName) {
        String propertyName = null;
        String propertyValue = null;
        POIXMLProperties.CustomProperties  customProperties = getDocument().getProperties().getCustomProperties(); 
        try {
        	propertyName = customProperties.getProperty(documentPropertyName).getName();
    		propertyValue = customProperties.getProperty(documentPropertyName).getLpwstr();
        } 
        catch(NullPointerException e) {
            propertyValue = "Valeur en cas de null pointer";
        }
		return propertyValue;
	}
	
	String daoCreator = "";
	
	String daoReference = "";

	public String getDocumentPropertyCreator() {
		String creator = getDocument().getProperties().getCoreProperties().getCreator();
		return creator;
	}

	public void setDocumentCreatorProperty(String propertyValue) {
		getDocument().getProperties().getCoreProperties().setCreator(propertyValue);
	}
	
	//Methode de gnration du DAO
	public void createDaoFile() throws IOException {
	String numeroDao ="";
	lDA.clear();
	lDA = (List<VbxDocDaoAao>) iservice.getObjectsByColumn("VbxDocDaoAao", 
			new ArrayList<String>(Arrays.asList("LAA_NUM")),new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
	if(!lDA.isEmpty()) daoAao = lDA.get(0);		
	
	lAdr.clear();
	lAdr = (List<VbxDocAdrRetrait>) iservice.getObjectsByColumn("VbxDocAdrRetrait",
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));

	lCom.clear();
	lCom = (List<VbxDocCommission>) iservice.getObjectsByColumn("VbxDocCommission",
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));

	lLts.clear();
	lLts=(List<VbxDocLot>) iservice.getObjectsByColumn("VbxDocLot", new ArrayList<String>(Arrays.asList("LAA_NUM")),
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
	
	//chargeDaoFileIndex(); //Windows
	chargeDaoFile(); // Linux
	printBmk();
	_logger.info("Document chargé");
	lBmkNm = getBookmarkNames();
	replaceBookmarkByValue(lBmkNm, lLts, lAdr, daoAao, lCom);
	setDocumentCreatorProperty("sigomap");
	setDocumentProperty("numeroDao", daoAao.getAaoDacCode().toString());
	/*rplBmkByVal(lBmkNm, lLts, lAdr, daoAao, lCom);*/
	_logger.info("Bookmark remplac");
	verrouillage();
	_logger.info("Verrou paramtr");
	setProtect();
	_logger.info("Document protg");
	//saveDaoFileIndex(); //Windows
	saveDaoFile(); // linux
	_logger.info("Document enrgistr");
	telechargerDao();
	_logger.info("Document tlcharg");
}
//Fin Methode de gnration du DAO	


//Methode de gnration du DAO
/*public void createDaoFileIndex() throws IOException {

	lDA.clear();
	lDA = (List<VbxDocDaoAao>) iservice.getObjectsByColumn("VbxDocDaoAao", 
			new ArrayList<String>(Arrays.asList("LAA_NUM")),new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
	if(!lDA.isEmpty()) daoAao = lDA.get(0);		
	
	lAdr.clear();
	lAdr = (List<VbxDocAdrRetrait>) iservice.getObjectsByColumn("VbxDocAdrRetrait",
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));

	lCom.clear();
	lCom = (List<VbxDocCommission>) iservice.getObjectsByColumn("VbxDocCommission",
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));

	lLts.clear();
	lLts=(List<VbxDocLot>) iservice.getObjectsByColumn("VbxDocLot", new ArrayList<String>(Arrays.asList("LAA_NUM")),
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
	
	chargeDaoFileIndex();
	printBmk();
	_logger.info("Document charg");
	lBmkNm = getBookmarkNames();
	rplBmkByVal(lBmkNm, lLts, lAdr, daoAao, lCom);
	_logger.info("Bookmark remplac");
	verrouillage();
	_logger.info("Verrou paramtr");
	setProtect();
	_logger.info("Document protg");
	saveDaoFileIndex();
	_logger.info("Document enrgistr");
	telechargerDao();
	_logger.info("Document tlcharg");
}*/
//Fin Methode de gnration du DAO

	//ANCIEN
/*	public void createDaoFile() throws IOException {
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
	}*/

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

	public VbxDocCommission getCommission() {
		return commission;
	}

	public void setCommission(VbxDocCommission commission) {
		this.commission = commission;
	}

	public VbxDocAdrRetrait getAdresse() {
		return adresse;
	}

	public void setAdresse(VbxDocAdrRetrait adresse) {
		this.adresse = adresse;
	}

	public List<VbxDocDaoAao> getlDA() {
		return lDA;
	}

	public void setlDA(List<VbxDocDaoAao> lDA) {
		this.lDA = lDA;
	}

	public List<VbxDocLot> getlLts() {
		return lLts;
	}

	public void setlLts(List<VbxDocLot> lLts) {
		this.lLts = lLts;
	}

	public VbxDocLot getLots02() {
		return lots02;
	}

	public void setLots02(VbxDocLot lots02) {
		this.lots02 = lots02;
	}

	public List<VbxDocCommission> getlCom() {
		return lCom;
	}

	public void setlCom(List<VbxDocCommission> lCom) {
		this.lCom = lCom;
	}

	public List<VbxDocAdrRetrait> getlAdr() {
		return lAdr;
	}

	public void setlAdr(List<VbxDocAdrRetrait> lAdr) {
		this.lAdr = lAdr;
	}

	public void setDaoAao(VbxDocDaoAao daoAao) {
		this.daoAao = daoAao;
	}
	

    public TCommissionSpecifique getComUpdate() {
		return comUpdate;
	}

	public void setComUpdate(TCommissionSpecifique comUpdate) {
		this.comUpdate = comUpdate;
	}

	public boolean isPanelExixstent1() {
		return panelExixstent1;
	}

	public void setPanelExixstent1(boolean panelExixstent1) {
		this.panelExixstent1 = panelExixstent1;
	}

	public boolean isPanelNouveau1() {
		return panelNouveau1;
	}

	public void setPanelNouveau1(boolean panelNouveau1) {
		this.panelNouveau1 = panelNouveau1;
	}

/*	public long getCrit() {
		return crit;
	}

	public void setCrit(long crit) {
		this.crit = crit;
	}*/
	
	public String getCrit() {
		return crit;
	}

	public void setCrit(String crit) {
		this.crit = crit;
	}

	public List<VDacliste> getReaffectlisteDAO() {
		return reaffectlisteDAO;
	}

	public void setReaffectlisteDAO(List<VDacliste> reaffectlisteDAO) {
		this.reaffectlisteDAO = reaffectlisteDAO;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public List<VMargeDePreference> getListMargeModif() {
		return listMargeModif;
	}

	public void setListMargeModif(List<VMargeDePreference> listMargeModif) {
		this.listMargeModif = listMargeModif;
	}

	public List<VLigneLot> getListeImputationsModif() {
		return listeImputationsModif;
	}

	public void setListeImputationsModif(List<VLigneLot> listeImputationsModif) {
		this.listeImputationsModif = listeImputationsModif;
	}

	public String getAvisRespo() {
		return avisRespo;
	}

	public void setAvisRespo(String avisRespo) {
		this.avisRespo = avisRespo;
	}

	public List<VPpmDao> getListePpmDao() {
		return listePpmDao;
	}

	public void setListePpmDao(List<VPpmDao> listePpmDao) {
		this.listePpmDao = listePpmDao;
	}

	public VPpmDao getPpmDac() {
		return ppmDac;
	}

	public void setPpmDac(VPpmDao ppmDac) {
		this.ppmDac = ppmDac;
	}

	public boolean isBtnChangerOperation() {
		return btnChangerOperation;
	}

	public void setBtnChangerOperation(boolean btnChangerOperation) {
		this.btnChangerOperation = btnChangerOperation;
	}

	public boolean isOuvertureAmi() {
		return ouvertureAmi;
	}

	public void setOuvertureAmi(boolean ouvertureAmi) {
		this.ouvertureAmi = ouvertureAmi;
	}

	public boolean isBtnAffecte() {
		return btnAffecte;
	}

	public void setBtnAffecte(boolean btnAffecte) {
		this.btnAffecte = btnAffecte;
	}

	public boolean isBtnAffecteNormal() {
		return btnAffecteNormal;
	}

	public void setBtnAffecteNormal(boolean btnAffecteNormal) {
		this.btnAffecteNormal = btnAffecteNormal;
	}

	public List<VChargeEtudeDac> getListeChargeEtudeByDac() {
		return listeChargeEtudeByDac;
	}

	public void setListeChargeEtudeByDac(List<VChargeEtudeDac> listeChargeEtudeByDac) {
		this.listeChargeEtudeByDac = listeChargeEtudeByDac;
	}

	public String getStatutTrans() {
		return statutTrans;
	}

	public void setStatutTrans(String statutTrans) {
		this.statutTrans = statutTrans;
	}

	public boolean isBtnAffecte1() {
		return btnAffecte1;
	}

	public void setBtnAffecte1(boolean btnAffecte1) {
		this.btnAffecte1 = btnAffecte1;
	}

	public TPiecesDacs getPiece() {
		return piece;
	}

	public void setPiece(TPiecesDacs piece) {
		this.piece = piece;
	}

	public List<VPieces> getListePicesCsv() {
		return listePicesCsv;
	}

	public void setListePicesCsv(List<VPieces> listePicesCsv) {
		this.listePicesCsv = listePicesCsv;
	}

	public long getNbreDelai() {
		return nbreDelai;
	}

	public void setNbreDelai(long nbreDelai) {
		this.nbreDelai = nbreDelai;
	}

	public long getLotNbre() {
		return lotNbre;
	}

	public void setLotNbre(long lotNbre) {
		this.lotNbre = lotNbre;
	}

	public String getAaoLieuExe() {
		return aaoLieuExe;
	}

	public void setAaoLieuExe(String aaoLieuExe) {
		this.aaoLieuExe = aaoLieuExe;
	}

	public String getAaoHeureRecep() {
		return aaoHeureRecep;
	}

	public void setAaoHeureRecep(String aaoHeureRecep) {
		this.aaoHeureRecep = aaoHeureRecep;
	}

	public String getAaoDteHeurOuv() {
		return aaoDteHeurOuv;
	}

	public void setAaoDteHeurOuv(String aaoDteHeurOuv) {
		this.aaoDteHeurOuv = aaoDteHeurOuv;
	}

	public String getAaoLieuRecep() {
		return aaoLieuRecep;
	}

	public void setAaoLieuRecep(String aaoLieuRecep) {
		this.aaoLieuRecep = aaoLieuRecep;
	}

	public long getAaoNbrOuv() {
		return aaoNbrOuv;
	}

	public void setAaoNbrOuv(long aaoNbrOuv) {
		this.aaoNbrOuv = aaoNbrOuv;
	}

	public Date getAaoDateRecep() {
		return aaoDateRecep;
	}

	public void setAaoDateRecep(Date aaoDateRecep) {
		this.aaoDateRecep = aaoDateRecep;
	}

	public long getAaoCoutDac() {
		return aaoCoutDac;
	}

	public void setAaoCoutDac(long aaoCoutDac) {
		this.aaoCoutDac = aaoCoutDac;
	}

	public String getAaoPrecisModEval() {
		return aaoPrecisModEval;
	}

	public void setAaoPrecisModEval(String aaoPrecisModEval) {
		this.aaoPrecisModEval = aaoPrecisModEval;
	}

	public String getAaoNatPrix() {
		return aaoNatPrix;
	}

	public void setAaoNatPrix(String aaoNatPrix) {
		this.aaoNatPrix = aaoNatPrix;
	}

	public String getAaoRegQual() {
		return aaoRegQual;
	}

	public void setAaoRegQual(String aaoRegQual) {
		this.aaoRegQual = aaoRegQual;
	}

	public String getAaoAvisBai() {
		return aaoAvisBai;
	}

	public void setAaoAvisBai(String aaoAvisBai) {
		this.aaoAvisBai = aaoAvisBai;
	}

	public String getAaoRespBai() {
		return aaoRespBai;
	}

	public void setAaoRespBai(String aaoRespBai) {
		this.aaoRespBai = aaoRespBai;
	}

	public String getAaoOffAnormal() {
		return aaoOffAnormal;
	}

	public void setAaoOffAnormal(String aaoOffAnormal) {
		this.aaoOffAnormal = aaoOffAnormal;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getStrMtCaut() {
		return strMtCaut;
	}

	public void setStrMtCaut(String strMtCaut) {
		this.strMtCaut = strMtCaut;
	}

	public boolean isChampMtCaut() {
		return champMtCaut;
	}

	public void setChampMtCaut(boolean champMtCaut) {
		this.champMtCaut = champMtCaut;
	}

	public long getMtCaut() {
		return mtCaut;
	}

	public void setMtCaut(long mtCaut) {
		this.mtCaut = mtCaut;
	}

	public long getMtEstimR() {
		return mtEstimR;
	}

	public void setMtEstimR(long mtEstimR) {
		this.mtEstimR = mtEstimR;
	}

	public boolean isChampPub() {
		return champPub;
	}

	public void setChampPub(boolean champPub) {
		this.champPub = champPub;
	}

	public List<VAvisPublie> getPublieListe() {
		return publieListe;
	}

	public void setPublieListe(List<VAvisPublie> publieListe) {
		this.publieListe = publieListe;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public boolean isDacMention() {
		return dacMention;
	}

	public void setDacMention(boolean dacMention) {
		this.dacMention = dacMention;
	}

	public List<VCheckTransDac> getListCheckTrans() {
		return listCheckTrans;
	}

	public void setListCheckTrans(List<VCheckTransDac> listCheckTrans) {
		this.listCheckTrans = listCheckTrans;
	}

	public VCheckTransDac getNewCheckTrans() {
		return newCheckTrans;
	}

	public void setNewCheckTrans(VCheckTransDac newCheckTrans) {
		this.newCheckTrans = newCheckTrans;
	}

	public long getModifAdr() {
		return modifAdr;
	}

	public void setModifAdr(long modifAdr) {
		this.modifAdr = modifAdr;
	}

	public List<VPpmDao> getListePpmDaoModif() {
		return listePpmDaoModif;
	}

	public void setListePpmDaoModif(List<VPpmDao> listePpmDaoModif) {
		this.listePpmDaoModif = listePpmDaoModif;
	}

	public List<TPiecesDacs> getListePiecesDac() {
		return listePiecesDac;
	}

	public void setListePiecesDac(List<TPiecesDacs> listePiecesDac) {
		this.listePiecesDac = listePiecesDac;
	}

	public VPieceDac getSltPiecesDac() {
		return sltPiecesDac;
	}

	public void setSltPiecesDac(VPieceDac sltPiecesDac) {
		this.sltPiecesDac = sltPiecesDac;
	}

	public TPiecesDacs getPieceDac() {
		return pieceDac;
	}

	public void setPieceDac(TPiecesDacs pieceDac) {
		this.pieceDac = pieceDac;
	}

	public boolean isBtn_dao_modif() {
		return btn_dao_modif;
	}

	public void setBtn_dao_modif(boolean btn_dao_modif) {
		this.btn_dao_modif = btn_dao_modif;
	}

	public List<VLignePpm> getListeLignePpm() {
		return listeLignePpm;
	}

	public void setListeLignePpm(List<VLignePpm> listeLignePpm) {
		this.listeLignePpm = listeLignePpm;
	}

	public boolean isImputationLot() {
		return imputationLot;
	}

	public void setImputationLot(boolean imputationLot) {
		this.imputationLot = imputationLot;
	}

	public boolean isImputationPpm() {
		return imputationPpm;
	}

	public void setImputationPpm(boolean imputationPpm) {
		this.imputationPpm = imputationPpm;
	}

	public String getDacMargePref() {
		return dacMargePref;
	}

	public void setDacMargePref(String dacMargePref) {
		this.dacMargePref = dacMargePref;
	}

	public String getAaoLibelle() {
		return aaoLibelle;
	}

	public void setAaoLibelle(String aaoLibelle) {
		this.aaoLibelle = aaoLibelle;
	}

	public BigDecimal getDacNbrCopieOff() {
		return dacNbrCopieOff;
	}

	public void setDacNbrCopieOff(BigDecimal dacNbrCopieOff) {
		this.dacNbrCopieOff = dacNbrCopieOff;
	}

/*	public List<TDossierDacs> getDossListe() {
		return dossListe;
	}

	public void setDossListe(List<TDossierDacs> dossListe) {
		this.dossListe = dossListe;
	}

	public List<TDossierDacs> getDossDacListe() {
		return dossDacListe;
	}

	public void setDossDacListe(List<TDossierDacs> dossDacListe) {
		this.dossDacListe = dossDacListe;
	}*/

	public List<VDossierDac> getDossListe() {
		return dossListe;
	}

	public void setDossListe(List<VDossierDac> dossListe) {
		this.dossListe = dossListe;
	}

	public List<VDossierDac> getDossDacListe() {
		return dossDacListe;
	}

	public void setDossDacListe(List<VDossierDac> dossDacListe) {
		this.dossDacListe = dossDacListe;
	}

	public boolean isPavet_infoG() {
		return pavet_infoG;
	}

	public void setPavet_infoG(boolean pavet_infoG) {
		this.pavet_infoG = pavet_infoG;
	}

	public List<TPiecesDacs> getListePieceDac() {
		return listePieceDac;
	}

	public void setListePieceDac(List<TPiecesDacs> listePieceDac) {
		this.listePieceDac = listePieceDac;
	}

	public List<VInfoNcc> getListOffreCandidat() {
		return listOffreCandidat;
	}

	public void setListOffreCandidat(List<VInfoNcc> listOffreCandidat) {
		this.listOffreCandidat = listOffreCandidat;
	}

	public VInfoNcc getOffreCandidat() {
		return offreCandidat;
	}

	public void setOffreCandidat(VInfoNcc offreCandidat) {
		this.offreCandidat = offreCandidat;
	}

	public List<THistoDac> getListeHisto() {
		return listeHisto;
	}

	public void setListeHisto(List<THistoDac> listeHisto) {
		this.listeHisto = listeHisto;
	}

	public List<TDetailVente> getListeDetVet() {
		return listeDetVet;
	}

	public void setListeDetVet(List<TDetailVente> listeDetVet) {
		this.listeDetVet = listeDetVet;
	}

	public List<TVenteDac> getListeVetDac() {
		return listeVetDac;
	}

	public void setListeVetDac(List<TVenteDac> listeVetDac) {
		this.listeVetDac = listeVetDac;
	}

	public List<TCandidats> getListeCanDac() {
		return listeCanDac;
	}

	public void setListeCanDac(List<TCandidats> listeCanDac) {
		this.listeCanDac = listeCanDac;
	}
	
	
	/*******  Fin document  *************/
}
