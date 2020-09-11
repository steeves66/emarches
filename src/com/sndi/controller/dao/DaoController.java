package com.sndi.controller.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;


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
import com.sndi.model.TAgpm;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TCandidats;
import com.sndi.model.TCommissionSpecifique;
import com.sndi.model.TCorrectionDac;
import com.sndi.model.TCritereAnalyse;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDaoAffectation;
import com.sndi.model.TDetCommissionSeance;
import com.sndi.model.TDetCritAnalyse;
import com.sndi.model.TDetCritAnalyseDac;
import com.sndi.model.TDetOffres;
import com.sndi.model.TDetailAdresseAvis;
import com.sndi.model.TDetailCorrection;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TDetailVente;
import com.sndi.model.TDossierDacs;
import com.sndi.model.TFonction;
import com.sndi.model.TGestion;
import com.sndi.model.THistoDac;
import com.sndi.model.TLBudgets;
import com.sndi.model.TLibelleAdresse;
import com.sndi.model.TLotAao;
import com.sndi.model.TModePassation;
import com.sndi.model.TModeReglement;
import com.sndi.model.TModeleDacType;
import com.sndi.model.TNatureDocuments;
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
import com.sndi.model.VAvisAdresse;
import com.sndi.model.VCommissionSpeciale;
import com.sndi.model.VCommissionSpecifique;
import com.sndi.model.VCommissionTypeExp;
import com.sndi.model.VCritAnalDacEntete;
import com.sndi.model.VCritAnalDacSousentete;
import com.sndi.model.VCritereAnalyse;
import com.sndi.model.VCritereAnalyseDac;
import com.sndi.model.VCritereAnalyseDacLot;
import com.sndi.model.VCritereAnalyseModel;
import com.sndi.model.VDacMembre;
import com.sndi.model.VDacVendu;
import com.sndi.model.VDacliste;
import com.sndi.model.VDaoBailleur;
import com.sndi.model.VDaoStatut;
import com.sndi.model.VDetTabBordDac;
import com.sndi.model.VDetTabBordPgpm;
import com.sndi.model.VDetTabBordPpm;
import com.sndi.model.VDetailAdresse;
import com.sndi.model.VDetailCorrection;
import com.sndi.model.VDetailCorrectionCharge;
import com.sndi.model.VFonctionImputation;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VLigneImputation;
import com.sndi.model.VLigneLot;
import com.sndi.model.VLotCritere;
import com.sndi.model.VMargeDePreference;
import com.sndi.model.VPieceDac;
import com.sndi.model.VPieces;
import com.sndi.model.VPiecesOffre;
import com.sndi.model.VPiecesOffreDao;
import com.sndi.model.VPpmDao;
import com.sndi.model.VTempCitere;
import com.sndi.model.VTypePieceOffreSg;
import com.sndi.model.VUpdateAgpm;
import com.sndi.model.VUpdateDac;
import com.sndi.model.VVenteLot;
import com.sndi.model.VbCommissionSpecifique;
import com.sndi.model.VbCommissionType;
import com.sndi.model.VbCritereAnalyse;
import com.sndi.model.VbDetCritAnalyse;
import com.sndi.model.VbDetCritAnalyseDac;
import com.sndi.model.VbPaysReference;
import com.sndi.model.VbTempCritere;
import com.sndi.model.VbTempParamDetCri;
import com.sndi.model.VbTempParamEnteteCri;
import com.sndi.model.VbTempParamTabBord;
import com.sndi.model.VbTempParamVente;
import com.sndi.model.VbTempParametreCorrection;
import com.sndi.model.VbTempParametreFact;
import com.sndi.model.VbTempParametreLot;
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
	/*private List<VCritereAnalyseDacLot> listeCritereByLot = new ArrayList<VCritereAnalyseDacLot>();*/
	private List<VbDetCritAnalyseDac> listDetCritereDac = new ArrayList<VbDetCritAnalyseDac>();
	private List<TDetCritAnalyseDac> listDetcritere = new ArrayList<TDetCritAnalyseDac>();
	private TCommissionSpecifique detailCom = new TCommissionSpecifique(); 
	//MAREGE DE PREFENCE
	private List<VMargeDePreference> listeMarge = new ArrayList<VMargeDePreference>();
    //TABLEAU DE BORD
	private VbTempParamTabBord tempBord = new VbTempParamTabBord(); 
	 
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
	//MARGE DE PREFERENCE
	private VMargeDePreference marge = new VMargeDePreference();
	
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
	 
	 private boolean panelCaution = false;
	 
	//Boolï¿½ens
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
	//Boolï¿½en
	  //private boolean value1 =true;
	  private boolean etatQualif =false;
	  private boolean etatPV =false;
	  private boolean etatValiderCsv =true;
	  private boolean etatSanction = false;
	  private boolean etatLoveObs = false;
	  private boolean etatBtnValid = false;
	  private boolean etatBtnValidCharge = true;
	  private boolean etatTaux = false;
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
	 
	 @PostConstruct
	 public void postContr() {
		 controleController.fonctionaliteDynamic();
		 chargeGestions();
		 chargePays();
		 //chargeCritereCombobox();
	 }
	 
	 public String onFlowProcess(FlowEvent event) {
		 System.out.println("etape old= "+event.getOldStep()+" New= "+event.getNewStep());
			//Controle Pavï¿½ crï¿½ation
			 if(event.getOldStep().equals("creation") && event.getNewStep().equals("avis")) {
				 if("".equals(daoDetail.getTymCode()) || "".equalsIgnoreCase(daoDetail.getMopCode()) 
						 ||"".equals(daoDetail.getDppObjet()) ) 
				 {
					 FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez terminer votre Saisie, avant de cliquer sur suivant!", ""));
			          return "creation";
					} 
	              userController.initMessage(); 
			     }
			 
			//Controle Pavé création
			 if(event.getOldStep().equals("critere") && event.getNewStep().equals("criterebyLot")) {
				 factoriserLot();
				 listeCritereByLot.clear();
			     }
			 
			//Controle totalité des lots factorisés
			 if(event.getOldStep().equals("criterebyLot") && event.getNewStep().equals("cojo")) {
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
		 _logger.info("liste affichï¿½e: "+listeCritereAnalyse.size());
	 }
	 
	 
	 //Liste des critï¿½res saisie
	 public void chargeCritereSaisie() { 
	/*	 listeCritereSaisie= (List<VbDetCritAnalyseDac>) iservice.getObjectsByColumn("VbDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_DAN_CODE")),
					new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));*/
		 
		 listeCritereSaisie.clear(); 
		 listeCritereSaisie = ((List<VCritereAnalyseDac>)iservice.getObjectsByColumn("VCritereAnalyseDac",
				 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,"0"),
				 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode())));
		 _logger.info("liste critere saisie: "+listeCritereSaisie.size());
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
	 
	 
	 public void chargeCritereByLot() { 			 
		 listeCritereByLot.clear();
		 listeCritereByLot = ((List<VCritereAnalyseDac>)iservice.getObjectsByColumn("VCritereAnalyseDac",
						 new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()),
						 new WhereClause("DCAD_LAA_ID",WhereClause.Comparateur.EQ,""+laaId)));
				 _logger.info("liste critere du lot : "  +""+laaId+" " +listeCritereByLot.size());
			 }
	 
	 
	 //Afficahe de la liste des critï¿½res en fonction des types passï¿½ en parametre
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
		 _logger.info("procï¿½dure: "+controleController.getTypePlan());
		 _logger.info("type dac: "+controleController.getType());
	 }*/
	 
		//Combo box critï¿½res
	 
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
	 
	//Combo box critï¿½res Pou l'ecran de factorisation
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
	 
	 
	//Combo box critï¿½res
	 
	 public void chargeSousEnteteCombobox() {
			 listeEnteteCritere= (List<VCritAnalDacEntete>) iservice.getObjectsByColumn("VCritAnalDacEntete", new ArrayList<String>(Arrays.asList("CRA_LIBELLE")),
					 new WhereClause("R_ID",WhereClause.Comparateur.EQ,""+rId));
			 if(!listeEnteteCritere.isEmpty()) { 
				 newEnteteCrit=listeEnteteCritere.get(0);
				 //vider le champs detail
				  newCritereDac = new VbDetCritAnalyseDac(); 
				  listeSousEnteteCritere .clear(); 
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
	 
	 
	 
	 public void saveCritere() {
		 
		 if (selectionlisteCritereAnalyse.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun critï¿½re selectionnï¿½", ""));
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
		 		pavet_commission = true;
		 		userController.setTexteMsg("Critï¿½re(s) d'analyse enregistrï¿½(s) avec succï¿½s!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");
				
	 		 }
	 }
	 
	
	 public void factoriserLot() { 
		 newTempFactorise.setTempCritDac(dao.getDacCode());
		 newTempFactorise.setTempNbrLot(newAvis.getAaoNbrLot());
		 newTempFactorise.setTempType("DISP");
		 iservice.addObject(newTempFactorise); 
		 chargeLotCritere();
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
		    userController.setTexteMsg("Modification effectuÃ©e avec succÃ¨s!");
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
		    userController.setTexteMsg("Modification effectuÃ©e avec succÃ¨s!");
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
     
     //Methode de chargement des dï¿½tails diffï¿½rï¿½s pour le compte des chefs de service
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
	 
	 //Dï¿½tails des DAC transmis des compteurs
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
	//Fin des dï¿½tails des DAC Transmis des compteurs
	 
	 
	 //Dï¿½tails des DAC affectes des compteurs
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
	 
	//Dï¿½tails des DAC validï¿½s par le Chef de Service
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
	 
		//Dï¿½tails des DAC diffï¿½rï¿½s par la Cellule / le Chef de Service et l'Autoritï¿½ Contractante
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
	 
	 //Suppression du critï¿½re du dï¿½tail
	 public void deleteCritere() {
		 listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
					new WhereClause("DCAD_NUM",WhereClause.Comparateur.EQ,""+sltCritereDac.getDcadNum()));
	       if (!listeDetCritere.isEmpty()) {
	    	   detCritere = listeDetCritere.get(0);
	  		 iservice.deleteObject(detCritere); 
	  		 chargeCritereSaisie();
	  		 chargeCritere();
	  		userController.setTexteMsg("Suppression effectuï¿½e avec succï¿½s!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
	       }
		
	 }
	 //Fin de la mï¿½thode de suppression du dï¿½tail de critï¿½re
	 
	 
	 //FIN GESTION DES CRITERES
	 //Affichage des AC en lui passant en parametre les statuts concernï¿½ (2 statuts)
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
	 
	 //Affichage des AC en lui passant en parametre les statuts concernï¿½ (1 statut)
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
	//Affichage des DMP en lui passant en parametre le statut concernï¿½ (1 statuts)
	 public void chargeDataDMP1(String typeDac,String typePlan,String stat1){
		 listeDAO =(List<VDacliste>) iservice.getObjectsByColumnInDesc("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
				 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
				 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,""+typeDac),
				 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
		         multiFiltre ="";
			_logger.info("listeDAO size: "+listeDAO.size());	
			typeActionTb(); 
	 }
	 
	//Affichage des DMP en lui passant en parametre les statuts concernï¿½ (2 statuts)
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
	 
			//Methode d'affichage la liste des DAC en fonction du type plan et du type DAC passï¿½ en parametre
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
		 
		//Filtre multicritï¿½re pour les DAO en Procï¿½dure Normale
		 
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
		 //liste des piï¿½ces de l'offre
		 
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
		 
		  //Charger la liste des piï¿½ces a examiner par le charge d'etude
			 public void chargePiecesByDao() {
				 listePices= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
							new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));			
			 }
			 
			//Charger la liste des offres du DAO p
			 public void chargeOffresByDao() {
				 offresDao= (List<VPiecesOffreDao>) iservice.getObjectsByColumn("VPiecesOffreDao", new ArrayList<String>(Arrays.asList("OPD_NUM")),
							new WhereClause("OPD_DAC_CODE",WhereClause.Comparateur.EQ,""+updateDac.getDacCode()));			
			 }
			 
			 
			//Charger la liste des piï¿½ces a examiner par les chargï¿½s d'etude
			 public void chargePiecesByCharges() {
				 listePices= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
							new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
			 }
			 
			  //Combobox liste des Pays
			   public void chargePays(){
				   listePays=new ArrayList<>(constantService.getListePays());
				 }
			 
	 
		 //Liste des Dao affectï¿½es aux chargï¿½s d'etude
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
		 
		 //Liste des Dao affectÃ©s aux chargÃ©s d'etude
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
		 
		 //Filtre parametrï¿½ en foction du type plan et dac
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
		 
		 //Recherche Dao affectï¿½es aux chargï¿½s d'etude 
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
										 //Detail DAC affectï¿½s par CSV
										 chargeDetailDPM1("PN", "DAO", "D3A"); 
									 }else {
										 if(fonct.equalsIgnoreCase("listeValidationCsv")) {
											//Detail DAC validï¿½ par CSV
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
		 
		
		 //Methode de Chargement des Dossiers chez l'Autoritï¿½ Contractante
		  public void chargeDossier() {
		 		 dossListe.clear();
		 			 dossListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
		 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getDacCode())));			
		 	 } 
		  
		//Methode de Chargement des Dossiers chez le Chargï¿½ d'Etudes
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
		     
		  //Methode pour Retourner la liste des natures de documents en fonction du type DAC passï¿½ en parametre
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
					 //condition de chargement d'un document : Nature sï¿½lectionnï¿½e 
						 if((docNature == null || "".equals(docNature))){
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sï¿½lectionnï¿½e pour le chargement! ","");
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
							//check le dossier s'il existe Ã  faire
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
							FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectuÃ© avec succÃ¨s!", "");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						     chargeDossier();
							}else {
								FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistrÃ©, charger Ã  nouveau un document ! ","");
								FacesContext.getCurrentInstance().addMessage(null, msg);	
								
							}
						  }
				     }	
		        }
			  @Transactional
				public void upload(FileUploadEvent event) throws java.io.FileNotFoundException { 
				 //condition de chargement d'un document : Nature sï¿½lectionnï¿½e 
				 if((docNature == null || "".equals(docNature))){
					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sÃ©lectionnÃ©e pour le chargement! ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
					 
					 }else {
				
				if(fileUploadController.handleFileUpload(event, ""+slctdTd.getDacCode(), docNature)) {
					
					listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		 				if (!listDao.isEmpty()) {
		 					newDao= listDao.get(0);
		 	   	                 }
					
					int nat = Integer.valueOf(docNature);
					//check le dossier s'il existe Ã  faire
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
					
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectuÃ© avec succï¿½s!", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				   chargeDossier();
					}else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger Ã  nouveau un document ! ","");
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
				 
			    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDdaReference()+" supprimï¿½!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
			}
		    
		    
		    //Supprimer un dao joint
		    public void removeAutorisation(){
			downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaReference(), selectedDossier.getDdaReference());
				 iservice.deleteObject(selectedDossier);
				 chargeDossierAutorisation();	
				 
			    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDdaReference()+" supprimï¿½!", "");
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
		 		   /*//Mis Ã  jour dans T_Affichage_DAO et dans T_Dac_specs
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
						 
												 
						// Liste des membres de la commssions de la comission spï¿½ciale
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
			    			if (!listeComSpecific.isEmpty()) {
			    				comSpecUpdate=listeComSpecific.get(0); 
			    				comSpecUpdate.setComTctLibelle(sltCompsec.getComTctLibelle());
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
		 		 
	//Statistiques pour le chargï¿½ d'Etudes
			 
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
			//Affichage des DAO validï¿½ par le C.E
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
			 
			/*//Affichage des DAO validï¿½s par le C.E
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
		 
	//Fin de Staistiques pour le chargï¿½ d'Etudes 
		 
		 
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
		
				//Affichage des DAO diffï¿½rï¿½s par la CPMP : Nouvelle Methode
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
			    
			    
			    //chargement du message de la marge de prï¿½ference
			    public void chargeMsgMarge() {
			    	listeMarge.clear();
			    	listeMarge =(List<VMargeDePreference>) iservice.getObjectsByColumn("VMargeDePreference", new ArrayList<String>(Arrays.asList("ID")));
					if (!listeMarge.isEmpty()) {
						marge=listeMarge.get(0);
					}	
			    }
		    
		//Initiation du DAO en procÃ©dure normale 
	     @Transactional
	     public void saveDac(String typeDac) {
	    	 if(daoDetail.getTymCode().equalsIgnoreCase("") || "".equals(daoDetail.getTymCode()) || daoDetail.getMopCode().equalsIgnoreCase("") || "".equalsIgnoreCase(daoDetail.getMopCode()) 
	    			 || daoDetail.getDppObjet().equalsIgnoreCase("") || "".equals(daoDetail.getDppObjet()) ) {
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
			    					//Insertion des piï¿½ces
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
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le dÃ©lai de validitÃ© doit etre compris entre 30 et 180 jours ","");
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
	        		
	        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez remplir tous les champs obligatoires! ","");
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
				            	          		            userController.setTexteMsg("Avis d'Appel d'Offre crÃ©e avec succÃ¨s!");
				            	          		            userController.setRenderMsg(true);
				            	          		            userController.setSevrityMsg("success");
				            	          		            
				            	          		        //Dï¿½sactivation du bouton enregistrerAvis
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
	     
	 	//ContÃ´le sur le nombre d'ouverture
	 	public void verifOuverture() {
	 		if(newAvis.aaoNbrOuv == 2) {
	 			ouvTechnique = true;
	 			
	 		  }else {
	 			  ouvTechnique = false;
	 			  
	 		}
	 	}
	
	 	//Affichage des DAO validï¿½s par le C.E
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
					 chargeOperation("PN");
				 }else {
					 if(controleController.typePlan == "PS") {
						 chargeOperation("PS");
					 }else {
						 
				     } 
				   } 
			 }
			 
			 //Parametrage des PPM ramenï¿½ a la saisie
			 public void chargeOperation(String typePlan) {
				 ppmDao.clear();
				 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
						    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,""+typePlan),
						    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
							new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));	
				  multiFiltre=""; 
				 _logger.info("type plan : "+typePlan);	
				 _logger.info("Operateur connectï¿½ : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			 
			 public void chargeRecherchePPM() {
				 if(controleController.typePlan == "PN") {	
					 chargeOperationRecherche("PN");
				 }else {
					 if(controleController.typePlan == "PS") {
						 chargeOperationRecherche("PS");
					 }else {
						 
				     } 
				   } 	 		 
			 }
			 
			 //Parametrage des PPM ramenï¿½ a la saisie
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
				 _logger.info("Operateur connectï¿½ : "+userController.getSlctd().getTFonction().getFonCod());	
			 }
			  //Rappel des informations du PPM
		     public void renseignerDao() throws IOException{
		                 	if (listSelectionPpmDao.size()==0) {
		            				FacesContext.getCurrentInstance().addMessage(null,
		            						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun PPM selectionnÃ©", ""));
		            			}
		            	 		else{
		            	 			//Parcourir la liste de sï¿½lection listSelectionPpmDao
		            		 		for(VPpmDao ligne : listSelectionPpmDao) {
		            		 			 
		            		 			//Parcourir la liste et rï¿½cupï¿½re
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
				//Liste des libellï¿½
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
					userController.setTexteMsg("Enregistrement effectuÃ© avec succÃ¨s!");
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
							  FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR, "SÃ©lectionnez le type d'adresse!", ""));
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
               	    	      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le cumul montant Estimatif ne doit pas etre supÃ©rieur au montant de l'operation", ""));	
                            
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
				   
				   
				   
				  
				   //Methode de Gï¿½nï¿½ration des Lots   
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
					    		  userController.setTexteMsg("Lot(s) gÃ©nÃ©rÃ©(s) avec succÃ¨s!");
					    		  userController.setRenderMsg(true);
					    		  userController.setSevrityMsg("success");
								  
								  //Activation du pavet de saisie des piï¿½ces des offres 
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
				    	   /*userController.setTexteMsg("Veuillez respecter le nombre de lots renseignï¿½ !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");*/
							 
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseignÃ© ! ","");
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
							 
							 //Activation du pavet de saisie des piï¿½ces des offres 
			                 pavet_offre = true;
			                 pavet_critere= true;
				        	 userController.setTexteMsg("Lot enregistrÃ© avec succÃ¨s !");
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
				    		
				    		/* userController.setTexteMsg("Veuillez respecter le nombre de lots renseignï¿½ !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");*/
							 
							 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez respecter le nombre de lots renseignÃ© ! ","");
							 FacesContext.getCurrentInstance().addMessage(null, msg);
				    	 }
					}
					 
					 //Mis Ã  jour du libellï¿½ de lot
				        public void updateLibLot() {
				        	     lot.setLaaObjet(lot.getLaaObjet());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				        //Mis Ã  jour du montant de la caution du lot
				        public void updateMtCautLot() {
				        	     lot.setLaaMtCaut(lot.getLaaMtCaut());
				        	     iservice.updateObject(getLot());
				        	     chargeLots();  
				              }
				        
				      //Mis Ã  jour du montant estimatif de la caution du lot
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
				   				userController.setTexteMsg("Suppression effectuÃ©e avec succÃ¨s !");
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
				  
				  
				   	 
				   	 //enregister la liste des piï¿½ces du dao
				     public void savePieceOffres() {
				    		if (listeSelectionPiecesOffres.size()==0) {
								FacesContext.getCurrentInstance().addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune piÃ¨ce selectionnÃ©e", ""));
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
						 		userController.setTexteMsg("PiÃ¨ces enregistrÃ©e(s) avec succÃ¨s!");
								userController.setRenderMsg(true);
								userController.setSevrityMsg("success");
								//Dï¿½sactivation du Bouton d'Enregistrement
								btn_save_offre = false;
								pavet_critere=true;
								//Activation du bouton du tï¿½lï¿½chargement du DAO
				                btn_dao = true;
					 		 }

				      }
				 //Methode de rï¿½cupï¿½ration de l'adresse
				  public void observationAdresse() {
					  avisAdresse = (List<VAvisAdresse>) iservice.getObjectsByColumn("VAvisAdresse", new ArrayList<String>(Arrays.asList("V_ID")),
								new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
				  }
				  
				  //Rï¿½cupï¿½ration de l'avis et son Adresse
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
					 userController.setTexteMsg("Avis d'Appel d'offres mis Ã  jour avec succÃ¨s!");
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
						userController.setTexteMsg("DAO mis Ã  jour avec succÃ¨s!");
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
					 
					 public void checkMargeMsg() {
						 chargeMsgMarge();
						 if(choixTaux.equalsIgnoreCase("marge")) { 
							 etatTaux = true; 
							 libelleTaux = true;
						 }else 
						 {
							 etatTaux = false; 
							 libelleTaux = false; 
						 }
					 }
					 
					 
					 //Edition de la fiche de synthÃ¨se du DAO
					 public void imprimeSynthese() {
							   projetReport.stringparam1(dao.getDacCode(), "synthese_dac", "synthese_dac"); 
						}
					 
				 
					//TÃ©lÃ©chargement des DAO type aprÃ¨s la saisie du DAO					
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
						
						//Tï¿½lï¿½chargement des DAO type aprï¿½s la saisie du DAO  
							//Tï¿½lï¿½chargement des DAO type aprï¿½s la saisie du DAO  
						//Tï¿½lï¿½chargement des DAO type aprï¿½s la saisie du DAO 
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
			
						
			
				
							
			
							//Chargement des imputations ou lignes budgï¿½taires pour le AC
							/*  public void chargeImputation() { 
								 listeImputations.clear();
								 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
										 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())); 
									} */
							  
							//Chargement des imputations ou lignes budgï¿½taires pour le AC
							  public void chargeImputation() { 
								 listeImputations.clear();
								 listeImputations =(List<VLigneLot>) iservice.getObjectsByColumn("VLigneLot", new ArrayList<String>(Arrays.asList("LBG_CODE")),
										 new WhereClause("DAC_CODE",Comparateur.EQ,""+dao.getDacCode())); 
								 recupererCaution();
								
									} 
							  
							  
							//Chargement des imputations ou lignes budgï¿½taires pour le AC
							  public void chargeFonctionImput() { 
								  listeFonctionsImput.clear();
								  listeFonctionsImput =(List<VFonctionImputation>) iservice.getObjectsByColumn("VFonctionImputation", new ArrayList<String>(Arrays.asList("FON_COD")),
										 new WhereClause("STR_CODE",Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())); 
									_logger.info("listeFonctionsImput size: "+listeFonctionsImput.size());	
									typeActionTb();
									}
							  
							  
							   
							  //Filtre sur la liste des chargï¿½s d'Etudes
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
							  
							  //Examen des piï¿½ces du DAO par le Responsable du binÃ´me
							  @Transactional
							  public void examinerPieces() {
								  //Mis Ã  Jour du Statut du DAO dans T_Dao_Affectation, puis dans t_dac_specs
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
	 						       historiser("DC2",newDao.getDacCode(),"DAO Corrigé par le responsable du binôme");
										//Actualisation du Tableau de Bord
										typeActionTb();
										//Activation et dï¿½sactivation des boutons valider
										etatBtnValid = false;
										validCorrection = true;
										etatDaoCorrige = true;
										 //Message de confirmation
										 userController.setTexteMsg("Correction(s) éffectuée(s) avec succÃ¨s!");
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
								     
								                                       //Mis Ã  Jour du Statut du DAO dans T_Affichage_Dao, puis dans t_dac_specs
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
												 						       historiser("D1T",newDao.getDacCode(),"DAO CorrigÃ© par le responsable du binÃ´me");	
							 				                              //Actualisation du Tableau de Bord
											                              typeActionTb();
											                              //Activation et dï¿½sactivation des boutons valider
											              				  etatBtnValid = false;
											              				  validCorrection = true;
											              				  etatDaoCorrige = true;
							 				                              //Message de confirmation
							 				                              userController.setTexteMsg("Correction(s) Ã©ffectuÃ©e(s) avec succÃ¨s!");
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
								  
								//Insertion des chargï¿½s d'ï¿½tudes choisis 
									if (listSelectionFonctImput.size()==0) {
												FacesContext.getCurrentInstance().addMessage(null,
												new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun chargÃ© d'Ã©tudes selectionnÃ©", ""));
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
							    					userController.setTexteMsg("Affectation(s) effectuÃ©e(s) avec succÃ¨s!");
													userController.setRenderMsg(true);
													userController.setSevrityMsg("success");

									 			    }else {
									 			    	     FacesContext.getCurrentInstance().addMessage(null,
									 							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez Choisir un binÃ´me !", ""));
									 			    	     //RÃ©initialiser la liste de selection
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
							  
							
							 
								//Charger la liste des piï¿½ces et observations Ã  examiner par le chef de service suivie de l'observation donnï¿½e par le responsable
								 public void chargePiecesByCsv() {
									 listeDetailCorrection= (List<VDetailCorrection>) iservice.getObjectsByColumn("VDetailCorrection", new ArrayList<String>(Arrays.asList("PID_CODE")),
											    new WhereClause("DCO_RESPO",WhereClause.Comparateur.EQ,"O"),
												new WhereClause("DCO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));	
												if (!listeDetailCorrection.isEmpty()) {
													detailCor = listeDetailCorrection.get(0);
											    }
								             }
								 
								//Chargement la liste des piï¿½ces et observations Ã  examiner par le responsable
								 public void chargePiecesByBinome() {
									 listeCorrectionCharge= (List<VDetailCorrectionCharge>) iservice.getObjectsByColumn("VDetailCorrectionCharge", new ArrayList<String>(Arrays.asList("PID_CODE")),
												new WhereClause("DCO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
									 if (!listeCorrectionCharge.isEmpty()) {
										 detailCharge = listeCorrectionCharge.get(0);
									    }
								      }
								 
								 
								 //Chargement des piï¿½ces du Dao
								 public void chargePiecesDao() {
									 listePiecesDao.clear();
									 listePiecesDao= ((List<VPieceDac>)iservice.getObjectsByColumn("VPieceDac",new ArrayList<String>(Arrays.asList("PID_LIBELLE")),
											    new WhereClause("PID_DAC_CODE",Comparateur.EQ,""+updateDac.getDacCode())));

								 }	
								 
								//Affichage de zone de mention si le chargï¿½ d'Etude est un responsable de binÃ´me
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
								  
								  
								//Affichage de zone de mention si le chargÃ© d'Etude est un responsable de binÃ´me
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
								  
								    //Examen des piÃ¨ces du DAO par le ChargÃ© d'Etudes du binÃ´me
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
										                             //Mis Ã  jour du statut de DAO rï¿½cu   
										                             slctdTda.setDafStaCode("DC1");
										                             iservice.updateObject(slctdTda);
										                             //Actualisation de la liste des DAO
										                             //chargeDaoChargeEtude();
												                     //Actualisation du Tableau de Bord
												                     typeActionTb();
												                     //Message de confirmation
												                     userController.setTexteMsg("Correction(s) Ã©ffectuÃ©e(s) avec succÃ¨s!");
												                     userController.setRenderMsg(true);
												                     userController.setSevrityMsg("success");
												                     
									                          }else { 
									        	 
										                                  listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
										                                		     new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
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
									 				
										                                             //Mis Ã  jour du statut de DAO en cours de traitement chez le Chargï¿½ d'Etudes  
										       		                                slctdTda.setDafStaCode("DC1");
										       		                                iservice.updateObject(slctdTda); 
										       		                                //Actualisation de la liste des DAO
										       		                                //chargeDaoChargeEtude();
									 				                                //Actualisation du Tableau de Bord
													                                 typeActionTb();
									 				                                //Message de confirmation
									 				                                userController.setTexteMsg("Correction(s) Ã©ffectuÃ©e(s) avec succÃ¨s!");
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
											 userController.setTexteMsg("Correction(s)  Ã©ffectuÃ©e(s) avec succÃ¨s!");
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
									  
									  
									  //Transmission du DAO par le Responsable du binÃ´me
									  @Transactional
									  public void transmettreRespo() {
										  
										  if(dos.getDdaNom().equalsIgnoreCase("") || "".equals(dos.getDdaNom()) || dos.getDdaReference().equalsIgnoreCase("") || "".equals(dos.getDdaReference())) {
											  //Message d'erreur
											  FacesContext.getCurrentInstance().addMessage(null,
											  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez charger le DAO", ""));
											  
										        }else {
											     //Mis Ã  Jour du Statut du DAO dans T_Dao_Affectation, puis dans t_dac_specs
											      slctdTda.setDafStaCode("D4V");
											      slctdTda.setDafStatutRetour("0");
											      iservice.updateObject(slctdTda);
											  
											   //Mis Ã  jour du statut et de l'option retour dans TDacSpecs
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
								 				  historiser("D4V",newDao.getDacCode(),"DAO Transmis par le responsable du binôme");
												  
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
										 //condition de chargement d'un document : Nature sï¿½lectionnï¿½e 
										 if((docNature == null || "".equals(docNature))){
											 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sÃ©lectionnÃ©e pour le chargement! ","");
											FacesContext.getCurrentInstance().addMessage(null, msg);	
											 
											 }else {
										
										if(fileUploadController.handleFileUpload(event, ""+slctdTda.getDafDacCode(), docNature)) {
											
											listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
								 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
								 				if (!listDao.isEmpty()) {
								 					newDao= listDao.get(0);
								 	   	                 }
											
											int nat = Integer.valueOf(docNature);
											//check le dossier s'il existe Ã  faire
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
											
											FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectué avec succès!", "");
											FacesContext.getCurrentInstance().addMessage(null, msg);
											chargeDossierCharge();
											}else {
												FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger Ã  nouveau un document ! ","");
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
										 //condition de chargement d'un document : Nature sï¿½lectionnï¿½e 
									/*	 if((codeAutorisation == null || "".equals(codeAutorisation))){
											 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir le code d'autorisation SVP! ","");
											FacesContext.getCurrentInstance().addMessage(null, msg);	
											 
											 }else {*/
												 
												 
													 
										if(fileUploadController.handleFileUpload(event, ""+dao.getDacCode(), "AUS")) {
											int nat = Integer.valueOf(7);
											//check le dossier s'il existe Ã  faire
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
												FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger Ã  nouveau un document ! ","");
												FacesContext.getCurrentInstance().addMessage(null, msg);	
												
											}
										  //}
										}
									
									 public void openDossier() throws IOException{
							       		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaNom(), selectedDossier.getDdaNom());
							       		   }
									
									//Methode de Chargement des Dossiers chez le Chargï¿½ d'Etudes
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
													  
													  if(slctdTd.getDacMention().equalsIgnoreCase("Validé pour publication")) {
														  statutSanction ="DPU";
														  statutSanRetour ="0";
														    if(slctdTd.getMopCode().equalsIgnoreCase("AOR") || slctdTd.getMopCode().equalsIgnoreCase("PSL"))
														      {
														    	  /*listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
																			new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
																			if (!listAvis.isEmpty()) {
																				                 //Mis Ã  jour du statut
																				                 majAvis= listAvis.get(0);
																				                 majAvis.setTStatut(new TStatut(statutSanction));
																				                 majAvis.setAaoDtePub(Calendar.getInstance().getTime());
																				                 iservice.updateObject(majAvis);
																			                       }*/
														    	
														         }else {
														        	 
														        	  /*listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
																				new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
																				if (!listAvis.isEmpty()) {
																					                 //Mis Ã  jour du statut
																					                 majAvis= listAvis.get(0);
																					                 majAvis.setTStatut(new TStatut("APU"));
																					                 majAvis.setAaoDtePub(Calendar.getInstance().getTime());
																					                 iservice.updateObject(majAvis);
																				                       }*/
														                  }
														    	
														
													                  }else 
													                     if(slctdTd.getDacMention().equalsIgnoreCase("Validé et retour à  l'AC")){
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
												                    								//Mis Ã   jour de tous les DAO dans T_DAO_AFFECTATION
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
													     //Activation du bouton d'ï¿½dition du PV
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
															//Mis Ã  jour du statut
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
														userController.setTexteMsg("DAO PubliÃ©!");
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
													               
												
													                //Recupï¿½ration du DAO dans T_DAC_SPECS
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
												 						       historiser("RET",newDao.getDacCode(),"DAO retirÃ©");
														  				
											    			  				 //Activation du bouton ï¿½dition du rï¿½cu
												     			  				   confirmPaie = true;
												     			  				  confirmInter = false;
												     			  				   etatRecu = false;
											    			  				  //Actualisation du Tableau de Bord
											    			 		          typeActionTb();
													                    	  
											     			  				   //Message de Confirmation
											     					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectuï¿½ avec succï¿½s", ""));
											     					           userController.setTexteMsg("Retrait effectuÃ© avec succÃ¨s");
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
											 		                    
											 		                //Recupï¿½ration du DAO dans T_DAC_SPECS
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
												 						       historiser("DVE",newDao.getDacCode(),"DAO payÃ©");
											     			  				    
											     			  				   //Activation du bouton Ã©dition du rÃ©cu
											     			  				   confirmPaie = true;
											     			  				   confirmInter = false;
											     			  				   etatRecu = true;
											     			  				   
											     			  				   
											     			  				   //Actualisation du Tableau de Bord
											     			 		           typeActionTb();
											     			 		          
											     			 		           chargeData();
											      			  				   //Message de Confirmation
											      					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectuï¿½ avec succï¿½s", ""));
											      					           userController.setTexteMsg("Paiement effectuÃ© avec succÃ¨s");
											      							   userController.setRenderMsg(true);
											      							   userController.setSevrityMsg("success");
													                 }
												                   }    
											                }
											  //Fin Methode de Paiement
											  
											  //Methode de rï¿½cupï¿½ration du nombre de vente 
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
													               
												
													                //Recupï¿½ration du DAO dans T_DAC_SPECS
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
												 						       historiser("RET",newDao.getDacCode(),"DAO retirÃ©");
														  				
											    			  				 //Activation du bouton ï¿½dition du rï¿½cu
												 						      confirmPaie = false;
											     			  				  confirmInter = true;
											     			  				  etatRecu = false;
											    			  				  //Actualisation du Tableau de Bord
											    			 		          typeActionTb();
													                    	  
											     			  				   //Message de Confirmation
											     					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectuï¿½ avec succï¿½s", ""));
											     					           userController.setTexteMsg("Retrait effectuÃ© avec succÃ¨s");
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
											 		                    
											 		                //Recupï¿½ration du DAO dans T_DAC_SPECS
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
												 						       historiser("DVE",newDao.getDacCode(),"DAO payÃ©");
											     			  				 
												 						       //Activation du bouton ï¿½dition du rï¿½cu
													 						   confirmPaie = false;
												     			  			   confirmInter = true;
												     			  			   etatRecu = true;
											     			  				
											     			  				   
											     			  				   //Actualisation du Tableau de Bord
											     			 		           typeActionTb();
											     			 		          
											     			 		           chargeData();
											      			  				   //Message de Confirmation
											      					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectuï¿½ avec succï¿½s", ""));
											      					           userController.setTexteMsg("Paiement effectuÃ© avec succÃ¨s");
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
											  
												 //Dï¿½but de la vente du DAO
													public void finVente() {
														String statUpdate = "";
														String message = "";
														if(slctdTd.getDacStaCode().equalsIgnoreCase("DAP")) {
															statUpdate = "DVE";
															message="Fin de la vente du Dossier d'Appel à  Concurrence N°"+slctdTd.getDacCode();
														 }
														//Recupï¿½ration du DAO dans T_DAC_SPECS
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
													
													
													//Dï¿½but de retrait du DAO
													 public void finRetrait() {
														String statRetrait = "";
														String message = "";
														if(slctdTd.getDacStaCode().equalsIgnoreCase("DAP")) {
															statRetrait = "RET";
															message="Fin de retrait du Dossier d'Appel à Concurrence N°"+slctdTd.getDacCode();
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
																      
																     //ContrÃ´le sur la vente ou le retrait
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
																 //DEBUT DAO Publiï¿½ 
																 if(controleController.type == "DAC" && controleController.typePlan == "PN") { 
																	 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
																		 //Affichage des differentes listes du Chef de Service Procï¿½dure en fonction de l'action
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
																		                //Affichage des differentes listes du Chef de Service Procï¿½dure en fonction de l'action
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
																                //Affichage des differentes listes du Chef de Service Procï¿½dure en fonction de l'action
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
																	                //Affichage des differentes listes du Chef de Service Procï¿½dure en fonction de l'action
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
																		                //Affichage des differentes listes du Chef de Service Procï¿½dure en fonction de l'action
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
		     
		     
		     
		     //Methode pour vider la liste des critÃ¨res du lot 0
		     public void viderCritereLot0() {
		    	 
		    	 listeDetCritere = (List<TDetCritAnalyseDac>) iservice.getObjectsByColumn("TDetCritAnalyseDac", new ArrayList<String>(Arrays.asList("DCAD_NUM")),
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
		     }
		     
		     
		     //Methode pour vider la liste des critÃ¨res (lot par lot)
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
		     }
		     
		     
		     
		     
		     
		     
		     //Publication Des DAO
			  public void publierDao() throws IOException{ 
			 		if (publicationSelection.size()==0) {
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun DAC selectionnÃ©", ""));
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
				 			 
				 			//Parcourir la liste et rï¿½cupï¿½rer les demande au statut E1T
				 			listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
      	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+ligneDac.getDacCode()));
      	     				   if (!listDao.isEmpty()) {
      	     					    newDao= listDao.get(0);
      	     					    newDao.setTStatut(new TStatut(statutPub));
      	     			            iservice.updateObject(newDao); 
      	     	   	                 }	
									}
				 		
				 		//Historisation de l'opï¿½ration
					     historiser(""+statutPub, newDao.getDacCode(),"OpÃ©ration publiÃ©e par la DMP");
					     
                        //Actualisation du Tableau de Bord
					     typeActionTb();
					    //Rafraichissement de la liste
						 chargeDaoPUB();
						//Message de confirmation		  
						 userController.setTexteMsg(" Publication effectuÃ©e avec succÃ¨s !");
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
					chargeDataPriseCompte();*/
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
					 //chargeCritereCombobox();
					 //chargeCritere();
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
                	 //chargeLotExiste();
                	//chargeSoumissions();
                	 recupMontantDao();
                	 newCandidat = new TCandidats();
                	 etatRecu = false;
                	 sitDac = "";
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
}