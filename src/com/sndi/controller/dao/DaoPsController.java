package com.sndi.controller.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.sndi.model.TAffichagePpm;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TCandidats;
import com.sndi.model.TCommissionSpecifique;
import com.sndi.model.TCorrectionDac;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDaoAffectation;
import com.sndi.model.TDetCommissionSeance;
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
import com.sndi.model.VDaoBailleur;
import com.sndi.model.VDaoChargeEtude;
import com.sndi.model.VDaoStatut;
import com.sndi.model.VDetailAdresse;
import com.sndi.model.VDetailCorrection;
import com.sndi.model.VDetailCorrectionCharge;
import com.sndi.model.VFonctionImputation;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VLigneImputation;
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
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class DaoPsController {
	Logger _logger = Logger.getLogger(DaoPsController.class);


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

	 
	 //listes
	 private List<TDetailPlanPassation> listePPM = new ArrayList<TDetailPlanPassation>();
	 private List<TAffichagePpm> detailPPM = new ArrayList<TAffichagePpm>();
	 //T_Dac_Specs
	 private List<TDacSpecs> listDao = new ArrayList<TDacSpecs>(); 
	 private List<TDacSpecs> listeDaoRetire = new ArrayList<TDacSpecs>();
	 private List<TAvisAppelOffre> avisTab = new ArrayList<TAvisAppelOffre>(); 
	 //Fin T_Dac_specs
	 //T_Affichage_DAO
	 private List<TAffichageDao> listeDAO = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> daoPs = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> listeDaoTrans = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> daoValCsv = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> daoDiffCsv = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> daoAffectes = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> publicationListe = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> daoRecup = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> listeDaoAffectes = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> listeDaoARetirer = new ArrayList<TAffichageDao>();
	 private List<TDacSpecs> listeDaoVendu = new ArrayList<TDacSpecs>();
	 private List<TDacSpecs> listeDaoValide = new ArrayList<TDacSpecs>();
	 private List<TDacSpecs> listeDaoDiff = new ArrayList<TDacSpecs>();
	 private List<TDacSpecs> listeDaoCsvValid = new ArrayList<TDacSpecs>();
	 private List<TDaoAffectation> listeDaoChargeValid = new ArrayList<TDaoAffectation>();
	 
	 private List<TAffichageDao> listeDaoVente = new ArrayList<TAffichageDao>();
	 private List<TAffichageDao> daoPriseCompte = new ArrayList<TAffichageDao>();
	 private List<TDacSpecs> listeTabDaoTrans = new ArrayList<TDacSpecs>(); 
	 private List<TDacSpecs> listeTabDaoDiff = new ArrayList<TDacSpecs>(); 
	 private List<TDacSpecs> daoTab = new ArrayList<TDacSpecs>();
	 private List<TDacSpecs> listeTabDaoAffecCsv = new ArrayList<TDacSpecs>(); 
	 private List<TDacSpecs> listeTabDaoCsvAff = new ArrayList<TDacSpecs>();
	 private List<TDaoAffectation> daoBinome = new ArrayList<TDaoAffectation>();
	 private List<TDacSpecs> listeTabdaoValCsv = new ArrayList<TDacSpecs>(); 
	 private List<TDacSpecs> listeTabdaoDiffCsv = new ArrayList<TDacSpecs>();
	 private List<VDetailCorrection> listeDetailCorrection = new ArrayList<VDetailCorrection>();
	 private List<VDetailCorrectionCharge> listeCorrectionCharge = new ArrayList<VDetailCorrectionCharge>();
	 
	 //Fin T_Affichage
	 private List<TLotAao> listeLots = new ArrayList<TLotAao>();
	 private List<TLotAao> affichLots = new ArrayList<TLotAao>();
	 private List<VLigneImputation> listeImputations = new ArrayList<VLigneImputation>();
	 private List<VDaoBailleur> listeDaoBailleur = new ArrayList<VDaoBailleur>();
	 private List<VUpdateDac> listeDac = new ArrayList<VUpdateDac>();
	 private List<VPieceDac> listePiecesDao = new ArrayList<VPieceDac>();
	 private List<VFonctionMinistere> listeFonctions = new ArrayList<VFonctionMinistere>();
	 private List<TDetailPlanPassation> listSelectionTransmission = new ArrayList<TDetailPlanPassation>();
	 private List<VFonctionImputation> listeFonctionsImput = new ArrayList<VFonctionImputation>();
	 private List<TGestion> listeGestion = new ArrayList<TGestion>();
	 private List<TDetailPlanPassation> listeDetail = new ArrayList<TDetailPlanPassation>();
	 private List<TDossierDacs> dossListe = new ArrayList<TDossierDacs>();
	 private List<TDossierDacs> dossDacListe = new ArrayList<TDossierDacs>();
	 private List<TTypePiecesDac> detailsPieces = new ArrayList<TTypePiecesDac>();
	 private List<VPpmDao> ppmDao = new ArrayList<VPpmDao>();
	 private List<VPpmDao> listSelectionPpmDao = new ArrayList<VPpmDao>();
	 private List<VDaoChargeEtude> listDaoValCharge = new ArrayList<VDaoChargeEtude>();
	 private List<TCorrectionDac> listCorrection = new ArrayList<TCorrectionDac>();
	 private List<TCorrectionDac> listPieceCorrection = new ArrayList<TCorrectionDac>();
	 private List<TTiers> listTiers = new ArrayList<TTiers>();
	 private List<TSoumissions> listSoumission = new ArrayList<TSoumissions>();
	 private List<VVenteLot> listSelectionVerifLot = new ArrayList<VVenteLot>();
	 private List<VVenteLot> listVerifLot = new ArrayList<VVenteLot>();
	 private List<TLotAao> listLots = new ArrayList<TLotAao>();
	 
	 private List<TTypePiecesDac>listSelectionTypePieces =new ArrayList<TTypePiecesDac>();
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
	private List<TDaoAffectation> daoExamen = new ArrayList<TDaoAffectation>();
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
	 private VPpmDao daoDetail = new VPpmDao();
	 private TDacSpecs dao= new TDacSpecs();
	 private TAffichageDao slctdTd = new TAffichageDao();
	 private TDaoAffectation slctdTda = new TDaoAffectation();
	 private TAvisAppelOffre newAvis = new TAvisAppelOffre();
	 private TLotAao newLot = new TLotAao();
	 private TLotAao lot = new TLotAao();
	 private TDossierDacs selectedDossier = new TDossierDacs();
	 private TDossierDacs doss =new TDossierDacs();
	 private TDossierDacs dos =new TDossierDacs(); 
	 private TLotAao selectLot = new TLotAao();
	 private TTempParametre newTemp = new TTempParametre();
	 private VbTempParametreLot newVbTemp = new VbTempParametreLot();
	 private TAffichageDao daoAff = new TAffichageDao();
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
	 private TDetailVente venteDetail = new TDetailVente();
	 //GESTION DES PIECES DE L'OFFRE
	 private TTypePieceOffre newPieceOffre = new TTypePieceOffre();
	 private TOffrePieceDac newPieceOffreDac = new TOffrePieceDac();
	//VARIABLES
	 private long adaNum;
	 private String pidCod;
	 private String observation="";
	 private String filtreNcc ="";
	 private short numLibAdr;
	 private short numDetailAdr;
	 private String dtaLibelle;
	 private String detCom="";
	 private String dacCode ="";
	 private String sitDac ="";
	 private String natPiece ="";
	 private Date ouvTech;
	 private Date ouvFin;
	 private String libelleFournitures ="DAO_Fournitures_et_services_connexes.doc";
	 private String libelleTravaux ="dtao_travaux.doc";
	 private String libellePrestations ="dtao_prestation.doc";
	 
	 private VLigneImputation ligne = new VLigneImputation();
	 private VLigneImputation recupLigne = new VLigneImputation();
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
	 //private TLotAao slctdTb = new TLotAao();
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
	  private boolean ouvTechnique = true;
	  private boolean btn_affecter = false;
	 
	 @PostConstruct
	 public void postContr() {
		 controleController.fonctionaliteDynamic();
		 chargeData();
		 chargeGestions();
		 chargeImputation();
		 chargeFonctionImput();
		 chargePPM();
		 chargeLibelleAdresse();
		 chargeAdresse();
		 chargeLots();
		 chargeNatureDocTrans();
		 chargeDaoTrans();
		 chargeDaoCpTrans();
		 chargeDataAffecter();
		 chargeDataAValider();
		 chargeDaoCharegEtude();
		 chargeDaoAffectesR();
		 chargePiecesByDao();
		 chargePiecesByCsv();
		 chargePiecesOffres();
	 }
	 
	 //liste des pièces de l'offre
	 
	 public void chargePiecesOffres() {
		 listePiecesOffres= (List<TTypePieceOffre>) iservice.getObjectsByColumn("TTypePieceOffre", new ArrayList<String>(Arrays.asList("TPO_LIBELLE")));			
	 }
	 
	  //Charger la liste des pièces a examiner par le charge d'etude
		 public void chargePiecesByDao() {
			 listePices= (List<VPieces>) iservice.getObjectsByColumn("VPieces", new ArrayList<String>(Arrays.asList("V_PI")),
						new WhereClause("PID_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));			
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
		 
	 
		//Charger la liste des pièces et observations à examiner par le chef de service suivie de l'observation donnée par le responsable
		 public void chargePiecesByCsv() {
			 listeDetailCorrection= (List<VDetailCorrection>) iservice.getObjectsByColumn("VDetailCorrection", new ArrayList<String>(Arrays.asList("PID_CODE")),
					    new WhereClause("DCO_RESPO",WhereClause.Comparateur.EQ,"O"),
						new WhereClause("DCO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));	
						if (!listeDetailCorrection.isEmpty()) {
							detailCor = listeDetailCorrection.get(0);
					    }
		             }
		 
		//Chargement la liste des pièces et observations à examiner par le responsable
		 public void chargePiecesByBinome() {
			 listeCorrectionCharge= (List<VDetailCorrectionCharge>) iservice.getObjectsByColumn("VDetailCorrectionCharge", new ArrayList<String>(Arrays.asList("PID_CODE")),
						new WhereClause("DCO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
			 if (!listeCorrectionCharge.isEmpty()) {
				 detailCharge = listeCorrectionCharge.get(0);
			    }
		      }
		 
		 
		 //Chargement des pièces du Dao
		 public void chargePiecesDao() {
			 listePiecesDao.clear();
			 listePiecesDao= ((List<VPieceDac>)iservice.getObjectsByColumn("VPieceDac",new ArrayList<String>(Arrays.asList("PID_LIBELLE")),
					    new WhereClause("PID_DAC_CODE",Comparateur.EQ,""+updateDac.getDacCode())));

		 }
		 
		 
	//Chargement des DAO en procédure normale qui font l'objet de bailleur
	 public void chargeDaoBailleur() {
		 listeDaoBailleur =  (List<VDaoBailleur>) iservice.getObjectsByColumn("VDaoBailleur", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
		 if (!listeDaoBailleur.isEmpty()) {
			   daoBailleur = listeDaoBailleur.get(0);
			   panelAvisBailleur = true;
			   panelBailleurFichier = true;
			   pavet2 =false;
			   pavet3=false;
			   pavet4=false;
			   pavet5=false;
			   pavet6=false;
		    }else {
		    	    panelAvisBailleur = false;
		    	    panelBailleurFichier = false;
		    	    pavet2 =true;
				    pavet3=true;
				    pavet4=true;
				    pavet5=true;
				    pavet6=true;
		         }
		 }
	 
	 
	//Chargement des DAO en procédure normale qui font l'objet de bailleur
		 public void chargeBailleurDao() { 
			 listeDac =  (List<VUpdateDac>) iservice.getObjectsByColumn("VUpdateDac", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					     new WhereClause("DAC_BAILLEUR",WhereClause.Comparateur.EQ,"B"),
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
			 if (!listeDac.isEmpty()) {
				   panelAvisBailleur = true;
				   panelBailleurFichier = true;
				   pavet2 =false;
				   pavet3=false;
				   pavet4=false;
				   pavet5=false;
				   pavet6=false;
			    }else {
			    	    listeDac =  (List<VUpdateDac>) iservice.getObjectsByColumn("VUpdateDac", new ArrayList<String>(Arrays.asList("DAC_CODE")),
							new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
			    	    if (!listeDac.isEmpty()) {
			    	    updateDac = listeDac.get(0);
			    	     panelAvisBailleur = false;
			    	     panelBailleurFichier = false;
			    	     pavet2 =true;
					     pavet3=true;
					     pavet4=true;
					     pavet5=true;
					     pavet6=true;
					     
					     chargePPMObs();
					     chargeDetailAdresseDac();
	                	 chargePiecesDao();
	                	 chargeOffresByDao();
	                	 chargeLotsDac();
			         }
			    }
			 }
	 
	 
	//Methode de chargement
	 @Transactional
	 public void uploadBailleur(FileUploadEvent event) throws IOException{
		 if(slctdTd.getAffDacAvisBailleur().equalsIgnoreCase("") || "".equals(slctdTd.getAffDacAvisBailleur()) || slctdTd.getAffDacDateBailleur().equals(null) 
				 || "".equals(slctdTd.getAffDacDateBailleur())) 
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
				
				      if(fileUploadController.handleFileUpload(event, ""+slctdTd.getAffDacCode(), docNature)) {
					
					listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
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
 }

 
	

//Enregistrement de l'avis du bailleur	
@Transactional
public void saveAvisBailleur() {
		   
if(slctdTd.getAffDacAvisBailleur().equalsIgnoreCase("") || "".equals(slctdTd.getAffDacAvisBailleur()) || slctdTd.getAffDacDateBailleur().equals(null) ) {
	   //Message d'erreur
	   FacesContext.getCurrentInstance().addMessage(null,
	   new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir les informations du Bailleur", ""));
     }else { 
        	 daoPriseCompte =  (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
     	            new WhereClause("AFF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
     		            if (!daoPriseCompte.isEmpty()) {
     			               newAff = daoPriseCompte.get(0);
     			               newAff.setAffDacAvisBailleur(slctdTd.getAffDacAvisBailleur());
     			               newAff.setAffDacDateBailleur(slctdTd.getAffDacDateBailleur());
     			               newAff.setAffStaCode("DOP");
     			               iservice.updateObject(newAff);   
     		                     }
     		
          listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
     			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
     	             if (!listDao.isEmpty()) {
     	                    newDao = listDao.get(0);
     	                    newDao.setDacAvisBailleur(slctdTd.getAffDacAvisBailleur());
     	                    newDao.setDacDateAvisBailleur(slctdTd.getAffDacDateBailleur());
     	                    newDao.setTStatut(new TStatut("DOP"));
     	                    iservice.updateObject(newDao);
     	                       }
     	          
     	            chargeDataPriseCompte();
     	            //Chargement du tableau de bord 
     	            tableauBordController.chargeDataDaoPs();
     	            
     	            //Désactivation des booléens
     	           // panelAvisBailleur = true;
     	            panelBailleurFichier = true;
		    	    pavet2 =false;
				    pavet3=false;
				    pavet4=false;
				    pavet5=false;
				    pavet6=false;
     	    		//Message de Confirmation 
     	            userController.setTexteMsg("Avis du Bailleur ajouté avec succès");
     	    		userController.setRenderMsg(true);
     	    		userController.setSevrityMsg("success");
     	    		
     	    		 FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Avis du Bailleur ajouté avec succès", ""));
               }	
        }


	 
	//ACombobox Gestions
	 public void chargeGestions(){
		 listeGestion=(List<TGestion>) iservice.getObjectsByColumnDesc("TGestion", new ArrayList<String>(Arrays.asList("GES_CODE")));	
	 }
	 
	//Liste des entreprises de la love
		 public void chargeTiers(){
			 listTiers=(List<TTiers>) iservice.getObjectsByColumnDesc("TTiers", new ArrayList<String>(Arrays.asList("TIE_NUM")));	
		 }
		 
		//Liste des entreprises de la love
		 public void chargeSoumissions(){
			 listSoumission=(List<TSoumissions>) iservice.getObjectsByColumnDesc("TSoumissions", new ArrayList<String>(Arrays.asList("SOU_NCC")));	
		 } 
		 
		//Liste des entreprises de la love
		 public void filtrenNccCandidat(){
			 getListSoumission().clear();
			 listSoumission=(List<TSoumissions>) iservice.getObjectsByColumnDesc("TSoumissions", new ArrayList<String>(Arrays.asList("SOU_NCC")),
					 new WhereClause("SOU_NCC",WhereClause.Comparateur.LIKE,"%"+filtreNcc+"%"));	
		 }
	 
	 //Affichage des DAO Saisies par l'Autorité Contractante
	 public void chargeData(){
		 getListeDAO().clear();
		 listeDAO.clear();
		 listeDAO =(List<TAffichageDao>) iservice.getObjectsByColumnInDesc("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
				 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
				 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
		          new WhereClause("AFF_DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			_logger.info("listeDAO size: "+listeDAO.size());	
			tableauBordController.chargeDataDaoPs();		
	} 
	 
	//Affichage des DAO vendus
	 public void chargeDaoVendu(){
		 listeDaoVendu = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
				 new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"DVE"),
				 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
				new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
			_logger.info("listeDaoVendu  size: "+listeDaoVendu.size());	
			tableauBordController.chargeDataDaoPs();		
	} 
	 
	//Affichage des DAO validés par la CPMP
		 public void chargeDaoValide(){
			 listeDaoValide.clear();
			 listeDaoValide = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D2T"),
					new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
				_logger.info("listeDaoValide  size: "+listeDaoValide.size());	
				tableauBordController.chargeDataDaoPs();		
		}
		 
		//Affichage des DAO validés par la CPMP
		 public void chargeDaoCpTrans(){
			 //listeDaoValide.clear();
			 listeDaoValide = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D2T"),
					new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
				_logger.info("listeDaoValide  size: "+listeDaoValide.size());	
				tableauBordController.chargeDataDaoPs();		
		}
		 
		//Affichage des DAO validés par la CPMP
		 public void chargeDaoDiff(){
			 listeDaoDiff.clear();
			 listeDaoDiff = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D1R"),
					new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
				_logger.info("listeDaoDiff  size: "+listeDaoDiff.size());	
				tableauBordController.chargeDataDaoPs();		
		}
		 
		 
		 public void chargeDaoCsvValid(){ 
			 listeDaoCsvValid.clear();
			 listeDaoCsvValid =(List<TDacSpecs>) iservice.getObjectsByColumnIn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					 "DAC_STA_CODE", new ArrayList<String>(Arrays.asList("D5V","D6V")),
					  new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					  new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
			          new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("listeDaoCsvValid size: "+listeDaoCsvValid.size());	
				tableauBordController.chargeDataDaoPs();		
		}
		 
		 
		 public void chargeDaoCorrige(){ 
			 listeDaoCsvValid.clear();
			 listeDaoCsvValid =(List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					  new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ,"DC2"),
					  new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					  new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
			          new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("listeDaoCsvValid size: "+listeDaoCsvValid.size());	
				tableauBordController.chargeDataDaoPs();		
		}
	 
	 
	 //Affichage des DAO retournés pour prise en compte des observation
	 public void chargeDataPriseCompte(){ 
		 daoPriseCompte.clear();
		 daoPriseCompte =(List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
				 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("SBO","SRO")),
				 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
		          new WhereClause("AFF_DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			_logger.info("daoPriseCompte size: "+daoPriseCompte.size());	
			tableauBordController.chargeDataDaoPs();
			multiFiltre = "";
	}
	 
	 //Affichage des DAO retournés pour prise en compte des observation
	 public void chargeDataPriseCompteTrait(){ 
		 daoPriseCompte.clear();
		 daoPriseCompte =(List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
				 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("SB1","DOP")),
				 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
		          new WhereClause("AFF_DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			_logger.info("daoPriseCompte size: "+daoPriseCompte.size());	
			tableauBordController.chargeDataDaoPs();		
	}
	 
	
	 
	
	 
	 
	 public void chargeDaoTrans(){
		 listeDaoTrans =(List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
				      "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D1T","D2R")),
				      new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				      new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
		              new WhereClause("AFF_DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			_logger.info("objetListe size: "+listeDaoTrans.size());	
			tableauBordController.chargeDataDaoPs();		
	}
	 
	 public void chargeDaoTabTrans(){
		 listeTabDaoTrans =(List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				      new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ,"D1T"),
				      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
		              new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			_logger.info("listeTabDaoTrans size: "+listeTabDaoTrans.size());	
			tableauBordController.chargeDataDaoPs();		
	}
	 
	 //Liste des DAO différés chez le AC
	 public void chargeDaoTabDiff(){
		 listeTabDaoDiff =(List<TDacSpecs>) iservice.getObjectsByColumnIn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
			          "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D1R","D2R")),
				      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
		              new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			_logger.info("listeTabDaoDiff size: "+listeTabDaoDiff.size());	
			tableauBordController.chargeDataDaoPs();		
	}
	 
	 //Liste des DAO retirés (Tableau de Bord)
	 public void chargeDaoRetires(){ 
		 listeDaoRetire =(List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				   new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ,"RET"),
				   new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
		              new WhereClause("DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("listeDaoRetire size: "+listeDaoRetire.size());	
			tableauBordController.chargeDataDaoPs();		
	}
	 
	
	 
	 
	  public void chargeDaoCharegEtude(){
			examenListe =(List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
			              new WhereClause("AFF_STA_CODE",WhereClause.Comparateur.EQ,"D3A"),
			              new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
			              new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
			              new WhereClause("AFF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()));
				_logger.info("examenListe size: "+examenListe.size());	
				tableauBordController.chargeDataDaoPs();		
		}
	  
	  
	  public void chargeDaoChargeEtude(){
		  daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
				           "DAF_STA_CODE", new ArrayList<String>(Arrays.asList("D3A","DC2")),
				           new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,"DAO"),
				           new WhereClause("DAF_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
			              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
				_logger.info("daoExamen size: "+daoExamen.size());	
				tableauBordController.chargeDataDaoPs();		
		}
	  
	  //Affichage de zone de mention si le chargé d'Etude est un responsable de binôme
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
	  
	  
	//Affichage de zone de mention si le chargé d'Etude est un responsable de binôme
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
	  
	  
	  //listVerifLot
	  //Affichage de zone de mention si le chargé d'Etude est un responsable de binôme
	  public void chargeLotExiste(){
		  listVerifLot = ((List<VVenteLot>) iservice.getObjectsByColumn("VVenteLot", new ArrayList<String>(Arrays.asList("LAA_NUM")),
			              new WhereClause("AAO_VENTE_PAR_LOT",WhereClause.Comparateur.EQ,"O"),
			              new WhereClause("LAA_DAC_CODE", WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode())));
		        if (!listVerifLot.isEmpty()) {
		        	nbreLot = listVerifLot.get(0);
		         }	
		    }
	  
	  
	  
	  //Récupération du montant du DAO
	  public void recupMontantDao() {
		  listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				      new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
				      new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					  new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
				      if (!listDao.isEmpty()) {
					         newDao= listDao.get(0); 
	   	              }	
	             }
	  
	  
	  
	//Methode de paiement
	  @Transactional
	  public void payer() {
		  if(newCandidat.getCanSouNcc().equalsIgnoreCase("") ||newCandidat.getCanNom().equalsIgnoreCase("") || sitDac.equalsIgnoreCase("") ||"".equals(sitDac) ) {
			//Message d'erreur
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir le candidat ou choisir votre option", ""));
			  
		      }else { 
		    	  
		    	        if(sitDac.equalsIgnoreCase("Retrait")) {
		    	        	
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
				               newCandidat.setCanTieNcc(recupSoumission.getSouNcc());
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
		     			  		 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
		     			  		    if (!listDao.isEmpty()) {
		     			  			  newDao= listDao.get(0);
		     			  			  venteDetail.setTVenteDac(newVente);
		     			  			  venteDetail.setDveCout(montantRetrait);
				        	          venteDetail.setTDacSpecs(newDao);
				                      iservice.addObject(venteDetail);
		     			  				    }
		     			  		    
		     			  		           //Mis à Jour du DAO au statut de Retrait dans T_AFFICHAGE_DAO
				                           slctdTd.setAffStaCode("RET");
				                           iservice.updateObject(slctdTd);
		     			  				   
			                              //Mis à Jour du DAO au statut de Retrait dans T_DAC_SPECS
			                              listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					  					  new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
					  				      if (!listDao.isEmpty()) {
					  					     newDao= listDao.get(0);
					  					     newDao.setTStatut(new TStatut(slctdTd.getAffStaCode()));
					  			             iservice.updateObject(newDao); 
					  	   	                 }
					  				
					  				    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"RET"));
		    			  				TStatut statuts = new TStatut();
		    			  				if(!LS.isEmpty()) statuts = LS.get(0);
		    			  				  //Historisation des Agpm
		    			  				     THistoDac dacStatut = new THistoDac();
		    			  				     dacStatut.setHacDate(Calendar.getInstance().getTime());
		    			  				     dacStatut.setHacCommentaire("DAO retiré");
		    			  				     dacStatut.setTFonction(userController.getSlctd().getTFonction());
		    			  				     dacStatut.setTDacSpecs(newDao);
		    			  				     dacStatut.setTOperateur(userController.getSlctd().getTOperateur());
		    			  				     dacStatut.setTStatut(statuts);
		    			  				     iservice.addObject(dacStatut);	
		    			  				    
		    			  				 //Activation du bouton édition du récu
			     			  				   confirmPaie = true; 
			     			  				   etatRecu = false;
		    			  				  //Actualisation du Tableau de Bord
		    			 		          tableauBordController.chargeDataDaoPs();
				                    	  
		     			  				   //Message de Confirmation
		     					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectué avec succès", ""));
		     					           userController.setTexteMsg("Retrait effectué avec succès");
		     							   userController.setRenderMsg(true);
		     							   userController.setSevrityMsg("success");	
		    	        }else
		    	        	 if(sitDac.equalsIgnoreCase("Vente")) 
		    	        	 {
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
		 		               //newCandidat.setCanTieNcc(recupSoumission.getSouNcc());
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
		      			  		 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
		      			  		    if (!listDao.isEmpty()) {
		      			  			  newDao= listDao.get(0);
		      			  			  venteDetail.setTVenteDac(newVente);
		      			  			  venteDetail.setDveCout(newDao.getDacCout());
		 		        	          venteDetail.setTDacSpecs(newDao);
		 		                      iservice.addObject(venteDetail);
		      			  				    }
		      			  		      
		 	                              //Mis à Jour du DAO au statut de Retrait dans T_DAC_SPECS
		 	                              listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		 			  					  new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
		 			  				      if (!listDao.isEmpty()) {
		 			  					     newDao= listDao.get(0); 
		 			  					     newDao.setTStatut(new TStatut("DVE"));
		 			  					     iservice.updateObject(newDao);
		 			  	   	                 }
		 			  				      
		 			  				    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"DVE"));
		     			  				TStatut statuts = new TStatut();
		     			  				if(!LS.isEmpty()) statuts = LS.get(0);
		     			  				  //Historisation des DAO
		     			  				     THistoDac dacStatut = new THistoDac();
		     			  				     dacStatut.setHacDate(Calendar.getInstance().getTime());
		     			  				     dacStatut.setHacCommentaire("DAO payé");
		     			  				     dacStatut.setTFonction(userController.getSlctd().getTFonction());
		     			  				     dacStatut.setTDacSpecs(newDao);
		     			  				     dacStatut.setTOperateur(userController.getSlctd().getTOperateur());
		     			  				     dacStatut.setTStatut(statuts);
		     			  				     iservice.addObject(dacStatut);	
		     			  				    
		     			  				   //Activation du bouton édition du récu
		     			  				   confirmPaie = true;
		     			  				   etatRecu = true;
		     			  				   
		     			  				  //Actualisation du Tableau de Bord
		     			 		          tableauBordController.chargeDataDaoPs();
		 		                    	  
		      			  				   //Message de Confirmation
		      					           //FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Paiement effectué avec succès", ""));
		      					           userController.setTexteMsg("Paiement effectué avec succès");
		      							   userController.setRenderMsg(true);
		      							   userController.setSevrityMsg("success");	
		    	        	   }
		                   }    
	                }
	  //Fin Methode de Paiement
	  
	  
	  //Début de la vente du DAO
		public void finVente() {
			String statUpdate = "";
			String message = "";
			if(slctdTd.getAffStaCode().equalsIgnoreCase("D6V")) {
				statUpdate = "DVE";
				message="Fin de la vente du Dossier d'Appel à Concurrence N°"+slctdTd.getAffDacCode();
			 }else 
				 if(slctdTd.getAffStaCode().equalsIgnoreCase("DPU")) {
						statUpdate = "DVE";
						message="Fin de la vente du Dossier d'Appel à Concurrence N°"+slctdTd.getAffDacCode();
				 }
			slctdTd.setAffStaCode(statUpdate);
			iservice.updateObject(slctdTd);
			//Chargement de la liste principale et du tableau de  bord
			chargeDataVente();
			tableauBordController.chargeDataDaoPs();
			userController.setTexteMsg(message);
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");  
		}
//Fin de la vente du DAO
	  
	//Filtre multicritère pour les DAO en Procédure Normale
		
		public void reinitialiseDao() { 
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 getListeDAO().clear();
				 listeDAO =(List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
						 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
						 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				          new WhereClause("AFF_DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				      tableauBordController.chargeDataDaoPs();
					 }else 
					      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
					    	  
					        }else 
					    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					    		  
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
	  

	//Affichage des DAO en attente de publication	 
		 public void chargeDataAPublier(){
			 publicationListe.clear();			 
				publicationListe =(List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
						 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D5V","DOP")),
						 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
						 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						 new WhereClause("AFF_DAC_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("publicationListe  size: "+publicationListe.size());		
				tableauBordController.chargeDataDaoPs();	
				multiFiltre ="";
		}
		 
		 
		//Affichage des DAO transmis par l'autorité contractante
		 public void chargeDataAValider(){
			 getValidationListe().clear();
			 validationListe = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAO_ID")),
					 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					  new WhereClause("AFF_STA_CODE",WhereClause.Comparateur.EQ,"D4V"));
				_logger.info("validationListe  size: "+validationListe.size());					
				tableauBordController.chargeDataDaoPs();		
		}
		 
		
	  
		 //Afficher les détails de la correction
	  public void chargeDetailCorrection() {
		  listeCorrection = ((List<TDetailCorrection>)iservice.getObjectsByColumn("TDetailCorrection",new ArrayList<String>(Arrays.asList("dcoNum")),
				    new WhereClause("DCO_DAC_CODE",Comparateur.EQ,""+slctdTd.getAffDacCode())));	
	  }
	  
	
	 public void chargeDaoAffectesR(){
		 daoAffectes =(List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
			              new WhereClause("AFF_STA_CODE",WhereClause.Comparateur.EQ,"D3A"),
			              new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
			              new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
			              new WhereClause("AFF_DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));		
		}
	 
	
	 
	 
	 //Affichage des DAO à retirer
	 public void chargeDataVente(){ 
		 //getListeDaoVente().clear();
		listeDaoVente = (List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
				 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D6V","DPU")),
				 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
				new WhereClause("AFF_DAC_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("listeDaoVente size: "+listeDaoVente.size());
			tableauBordController.chargeDataDaoPs();
			multiFiltre="";
	}
	 
	 
	 //Affichage des DAO à retirer
	 public void chargeDataARetirer(){ 
		 listeDaoARetirer = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
				 new WhereClause("AFF_STA_CODE",WhereClause.Comparateur.EQ,"DVE"),
				 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
				new WhereClause("AFF_DAC_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("listeDaoARetirer size: "+listeDaoARetirer.size());
			tableauBordController.chargeDataDaoPs();
	}
	 
	 
	 //Affichage des DAO en attente d'affectation
	 public void chargeDataAffecter(){
		 getAffectationListe().clear();
		 affectationListe = (List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")), 
				 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D2T","D5R")),
				 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
				//new WhereClause("AFF_DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
			_logger.info("affectationListe  size: "+affectationListe.size());	
			tableauBordController.chargeDataDaoPs();		
	}
	 
	 		 
//Statistiques pour le chargé d'Etudes
		 
		//Affichage des DAO en attente chez le C.E
		 public void chargeDataChargeAtt(){ 
		 listDaoValCharge = (List<VDaoChargeEtude>) iservice.getObjectsByColumn("VDaoChargeEtude", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
					 new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D3A"),
					 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					 new WhereClause("DCS_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
					new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
				_logger.info("validationListe  size: "+validationListe.size());	
				tableauBordController.chargeDataDaoPs();		
		}
		 
		 
		//Affichage des DAO validé par le C.E
		 public void chargeDataChargeVal(){
		 listDaoValCharge = (List<VDaoChargeEtude>) iservice.getObjectsByColumn("VDaoChargeEtude", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
					 new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D4V"),
					 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					 new WhereClause("DCS_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
					new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
				_logger.info("validationListe  size: "+validationListe.size());	
				tableauBordController.chargeDataDaoPs();		
		}
		 
		//Affichage des DAO validés par le C.E
		 public void chargeDataChargeValid(){
			 //listeDaoChargeValid.clear();
			 listeDaoChargeValid = (List<TDaoAffectation>) iservice.getObjectsByColumn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_DAC_CODE")), 
					 new WhereClause("DAF_STA_CODE",WhereClause.Comparateur.EQ,"D4V"),
					 new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("DAF_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					 new WhereClause("DAF_OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
					new WhereClause("DAF_DAC_STR",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
				_logger.info("listeDaoChargeValid  size: "+listeDaoChargeValid.size());	
				tableauBordController.chargeDataDaoPs();		
		    }
	 
//Fin de Staistiques pour le chargé d'Etudes 
	 
	 
	//Statistiques pour le chef de Service
		 //Affichage des DAO en Attente d'Affectation
		 public void chargeDaoAttCsv(){ 
			 listeTabDaoAffecCsv.clear();
			 listeTabDaoAffecCsv =(List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
				              new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D2T"),
				              new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				              new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
				              new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));		
			}
		 
		 //Affichage des DAO affectés par le chef de Service
		 public void chargeDaoAffectes(){ 
			 //listeTabDaoCsvAff.clear();
			 listeTabDaoCsvAff =(List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
			              new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D3A"),
			              new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
			              new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
			              new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			 _logger.info("listeTabDaoCsvAff  size: "+listeTabDaoCsvAff.size());	
				tableauBordController.chargeDataDaoPs();
		}
		 
			//Affichage des DAO validé par le Chef de Service
			 public void chargeDataValCsv(){ 
				 listeTabdaoValCsv = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
						 new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D5V"),
						 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
						 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
					_logger.info("listeTabdaoValCsv  size: "+listeTabdaoValCsv.size());	
					tableauBordController.chargeDataDaoPs();		
			}
			 
			 
			//Affichage des DAO différé par le Chef de Service
			 public void chargeDataDiffCsv(){
				 listeTabdaoDiffCsv = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")), 
						 new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.EQ,"D5R"),
						 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
						 new WhereClause("DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
					_logger.info("listeTabdaoDiffCsv  size: "+listeTabdaoDiffCsv.size());	
					tableauBordController.chargeDataDaoPs();		
			}
			 
	
	//Fin de Staistiques pour le chargé d'Etudes
	 
   public void chargeLots(){
		 //getListeDAO().clear();
		 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
				 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
			_logger.info("objetListe size: "+listeLots.size());	
			tableauBordController.chargeDataDaoPs();		
	}
   
   public void chargeLotsDac(){
		 //getListeDAO().clear();
		 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
				 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+updateDac.getAaoCode()));
			_logger.info("objetListe size: "+listeLots.size());	
			tableauBordController.chargeDataDaoPs();		
	}
   
   
   public void chargeLotsRappel(){
		 getListeLots().clear();
		 listeLots = (List<TLotAao>) iservice.getObjectsByColumnDesc("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")), 			
				 new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
			_logger.info("objetListe size: "+listeLots.size());	
			tableauBordController.chargeDataDaoPs();		
	}
	 
	 
	//Chargement des imputations ou lignes budgétaires pour le AC
	  public void chargeImputation() { 
		 listeImputations.clear();
		 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())); 
			} 
	  
	  
	//Chargement des imputations ou lignes budgétaires pour le AC
	  public void chargeFonctionImput() { 
		  listeFonctionsImput.clear();
		  listeFonctionsImput =(List<VFonctionImputation>) iservice.getObjectsByColumn("VFonctionImputation", new ArrayList<String>(Arrays.asList("FON_COD")),
				 new WhereClause("STR_CODE",Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())); 
			_logger.info("listeFonctionsImput size: "+listeFonctionsImput.size());	
			tableauBordController.chargeDataDaoPs();	
			}
	  
	  
	   
	  //Filtre sur la liste des chargés d'Etudes
	  public void filtrefonction() { 
		  listeFonctionsImput.clear();
		  listeFonctionsImput =(List<VFonctionImputation>) iservice.getObjectsByColumn("VFonctionImputation", new ArrayList<String>(Arrays.asList("FON_COD")),
				 new WhereClause("STR_CODE",Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
				 new WhereClause("FON_LIBELLE",WhereClause.Comparateur.LIKE,"%"+filterCode+"%")); 
			}
	  
	  
	  //Filtre Imputation
	  public void filtreImputation() {
			listeImputations.clear();
			listeImputations = (List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
					new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()), 
					new WhereClause("LBG_NAT_CODE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));
		}
	  
	  public void filtreFonctionMin() {
			getListeFonctions().clear();
			 listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
						"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM")),
						new WhereClause("FON_COD",WhereClause.Comparateur.LIKE,"%"+filtreFonction+"%"),
						new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
		}
	  
	 
   //Chargement des PPM n'ayant pas fait l'objet d'un DAO
	 public void chargePPM() {
		 ppmDao.clear();
		 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
				    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
				    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,"PS"),
				    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
					new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));	
		 multiFiltre="";
	 }
	 
	 public void chargeRecherchePPM() {
		 ppmDao.clear();
		 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
				    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
				    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,"PS"),
				    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
					new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
				    new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%")));		 		 
	 }
	 
	//Chargement du/des PPM du DAO en observation
		 public void chargePPMObs() {
			 ppmDao.clear();
			 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
					    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
					    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,"PS"),
					    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"O"),
					    new WhereClause("DPP_DAC_CODE",Comparateur.EQ,""+slctdTd.getAffDacCode()),
						new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));
			 
			 
		 }
		 
		 //Methode de recherche sur les PSPM
		 public void chargeRecherchePSPM() {
			 ppmDao.clear();
			 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
					    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
					    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,"PS"),
					    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
						new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
					    new WhereClause("DPP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%")));		 		 
		 }
	 
	//Chargement des PSPM n'ayant pas fait l'objet d'un DAO
	 public void chargePSPM() {
		 ppmDao.clear();
		 ppmDao= ((List<VPpmDao>)iservice.getObjectsByColumn("VPpmDao",new ArrayList<String>(Arrays.asList("DPP_ID")),
				    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
				    new WhereClause("DPP_TYPE_PLAN",Comparateur.EQ,"PS"),
				    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"N"),
					new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));
		 multiFiltre="";
	 }
	 
	 
	 public void chargePPMCpmDmp() {
		 listePPM.clear();
		 listePPM= ((List<TDetailPlanPassation>)iservice.getObjectsByColumn("TDetailPlanPassation",new ArrayList<String>(Arrays.asList("DPP_ID")),
				    new WhereClause("DPP_STA_CODE",Comparateur.EQ,"S3V"),
				    new WhereClause("DPP_STATUT_DAO",Comparateur.EQ,"O"),
					new WhereClause("DPP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,fonction.getFonCod())));		 		 
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
	
		
		  
	   
			
			
	    //DAO PROCEDURE NORMALE
			//Filtre multicritère pour les DAO en Procédure Normale
			public void chargerDaoRecherche() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 getListeDAO().clear();
					 listeDAO =(List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
							 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D1S","D1R")),
							  new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
							  new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					          new WhereClause("AFF_DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
					          new WhereClause("AFF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
						tableauBordController.chargeDataDaoPs();
						
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("")) {
						    		  
						    	  }
			               }
			
		public void validationRecherche() { 
		getValidationListe().clear();
		validationListe = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAO_ID")),
			  new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
			  new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
			  new WhereClause("AFF_DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
			  new WhereClause("AFF_STA_CODE",WhereClause.Comparateur.EQ,"D4V"),
			  new WhereClause("AFF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
			  _logger.info("validationListe  size: "+validationListe.size());					
			tableauBordController.chargeDataDaoPs();		
			        }
		
		
		public void affectationRecherche() { 
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CSV")) {
					 getAffectationListe().clear();
					 affectationListe = (List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")), 
							 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D2T","D5R","DOP")),
							 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
							 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
							new WhereClause("AFF_DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()),
							new WhereClause("AFF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
						_logger.info("affectationListe  size: "+affectationListe.size());	
						tableauBordController.chargeDataDaoPs();
					
					 }
		        }
		
		 public void chargeDaoRecherche(){
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CET")) {
			  daoExamen.clear();
			  daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
					           "DAF_STA_CODE", new ArrayList<String>(Arrays.asList("D3A","DC2")),
					           new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,"DAO"),
					           new WhereClause("DAF_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
				              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
					          new WhereClause("DAF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%")));
					_logger.info("daoExamen size: "+daoExamen.size());	
					tableauBordController.chargeDataDaoPs();		
			}
		 }
		
		public void retraitRecherche() { 
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getListeDaoARetirer().clear();
						listeDaoARetirer = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
								 new WhereClause("AFF_STA_CODE",WhereClause.Comparateur.EQ,"DVE"),
								 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
								 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
								new WhereClause("AFF_DAC_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
								new WhereClause("AFF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
							_logger.info("listeDaoARetirer size: "+listeDaoARetirer.size());
							tableauBordController.chargeDataDaoPs();
					 }
		        }
		
		public void examenRecherche() {
					 daoExamen = ((List<TDaoAffectation>) iservice.getObjectsByColumnIn("TDaoAffectation", new ArrayList<String>(Arrays.asList("DAF_ID")),
					           "DAF_STA_CODE", new ArrayList<String>(Arrays.asList("D3A","DC2")),
					           new WhereClause("DAF_TYPE_DAC",WhereClause.Comparateur.EQ,"DAO"),
								new WhereClause("DAF_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
				              new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule())));
					_logger.info("daoExamen size: "+daoExamen.size());	
					tableauBordController.chargeDataDaoPs();	
		        }  
		
					
					public void publicationRecherche() { 
						if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
								getListeDaoARetirer().clear();
										publicationListe = (List<TAffichageDao>)  iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
												 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D5V","DOP")),
												 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
												 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
												new WhereClause("AFF_DAC_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
												new WhereClause("AFF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
											_logger.info("publicationListe  size: "+publicationListe.size());		
											tableauBordController.chargeDataDaoPs();
								 }
					        }
			
	public void venteRecherche() { 
		if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			//getListeDaoVente().clear();
			listeDaoVente = (List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
					 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D6V","DPU")),
					 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					new WhereClause("AFF_DAC_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					new WhereClause("AFF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
				_logger.info("listeDaoVente size: "+listeDaoVente.size());
				tableauBordController.chargeDataDaoPs();
									 }
						        }
	
	
	
	public void priseRecherche() { 
		if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 daoPriseCompte.clear();
			 daoPriseCompte =(List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
					 "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("SBO","SRO")),
					 new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					 new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
			          new WhereClause("AFF_DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
			          new WhereClause("AFF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
				_logger.info("daoPriseCompte size: "+daoPriseCompte.size());	
				tableauBordController.chargeDataDaoPs();
			  }
			} 
	
	public void celluleRecherche() { 
			listeDaoTrans.clear();
			 listeDaoTrans =(List<TAffichageDao>) iservice.getObjectsByColumnIn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
				      "AFF_STA_CODE", new ArrayList<String>(Arrays.asList("D1T","D2R")),
				      new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				      new WhereClause("AFF_DAC_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
		              new WhereClause("AFF_DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
		              new WhereClause("AFF_DAC_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
			_logger.info("objetListe size: "+listeDaoTrans.size());	
			tableauBordController.chargeDataDaoPs();
			  
			}
	
	
	
				  
			//Filtre multicritère pour les DAO en Procédure Normale
	
	//FIN DAO PROCEDURE NORMALE
		  
		  
     //Rappel des informations du PPM
     public void renseignerDao() throws IOException{
                 	if (listSelectionPpmDao.size()==0) {
            				FacesContext.getCurrentInstance().addMessage(null,
            						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun PPM selectionné", ""));
            			}
            	 		else{
            	 			//Parcourir la liste TDetailPlanPassation et faire une mise a jour des different statut
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
		   //Mis à jour dans T_Affichage_DAO et dans T_Dac_specs
		    slctdTd.setAffStaCode(statutUpdate);
			slctdTd.setAffDacStatutRetour("1");
			iservice.updateObject(slctdTd);
			
			listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
 				if (!listDao.isEmpty()) {
 					newDao= listDao.get(0);
 					newDao.setTStatut(new TStatut(statutUpdate));
 					newDao.setDacStatutRetour("1");
 			        iservice.updateObject(newDao); 
 	   	                 }
 				//Historisation du DAO
		    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Histo Dac
					THistoDac dac=new THistoDac();
					dac.setHacDate(Calendar.getInstance().getTime());
					dac.setHacCommentaire(getObservation());
					dac.setTDacSpecs(newDao);
					dac.setTFonction(userController.getSlctd().getTFonction());
					dac.setTOperateur(userController.getSlctd().getTOperateur());
					dac.setTStatut(statuts);
					iservice.addObject(dac);
		  
					//Message de confirmation
					 userController.setTexteMsg("DAO retourné !");
					 userController.setRenderMsg(true);
					 userController.setSevrityMsg("success");
					 //return	null;
					 
					 chargeDaoTrans();
					 chargeDataAffecter();
		          //Actualisation du Tableau de Bord
		          tableauBordController.chargeDataDaoPs();
			
			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Désolé, votre DAO a été retourné!", "");
			 FacesContext.getCurrentInstance().addMessage(null, msg);
	 }
	 
	 
	//Enregistrement des entreprises candidates
	  @Transactional
	 public void saveTiers() {
		  if(newEntre == null) {
			  FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Veuillez, remplir tous les champs!", "");
			  FacesContext.getCurrentInstance().addMessage(null, msg);
		  }else {
			  newEntre.setTieDteSaisi(Calendar.getInstance().getTime());
			  newEntre.setTOperateur(userController.getSlctd().getTOperateur());
			  iservice.addObject(newEntre);
			  chargeTiers();
			  FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Entreprise créée avec succès", ""));
		  }
	 }
	  
	  
	  
	  
	  //Love pour recuperer les entreprises
		 public void onSelectTiers() {
			 recupTiers = new TTiers();
			 recupTiers.setTieNomCom(tiers.getTieNomCom());
			 recupTiers.setTieAdresse(tiers.getTieAdresse());
			 recupTiers.setTieSigleSte(tiers.getTieSigleSte());
			 recupTiers.setTieTel(tiers.getTieTel());
			 recupTiers.setTieStaCode(tiers.getTieStaCode());
			 recupTiers.setTOperateur(tiers.getTOperateur());
				}
		 
		 //Love pour recuperer les entreprises
		 public void onSelectSoumission() {
			 recupSoumission = new TSoumissions();
			 recupSoumission.setSouNomCom(soumission.getSouNomCom());
			 recupSoumission.setSouSigleSte(soumission.getSouSigleSte());
			 recupSoumission.setSouTel(soumission.getSouTel());
			 recupSoumission.setSouNcc(soumission.getSouNcc());
			 recupSoumission.setSouAdresse(soumission.getSouAdresse());
				}
		 
		 
		 
		 
	 
	 
	//Enregistrement des lots
	  @Transactional
	 public void saveDetailLot() {
			for(TLotAao lot : listeLots) {
	 			//Parcourir la liste et faire une mis à jour de chaque ligne
				TLotAao addLot = new TLotAao();
				addLot.setLaaObjet(lot.getLaaObjet());
				addLot.setTLBudgets(lot.getTLBudgets());
				addLot.setLaaMtCaut(lot.getLaaMtCaut());
				addLot.setLaaCoutLot(lot.getLaaCoutLot());
				iservice.updateObject(addLot);
				}
			
			 userController.setTexteMsg("Lot(s) ajouté(s) avec succès!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
	         }
	 
	 
     
	  //Enregistrement des corrections
	  @Transactional
	  public void saveCorrecction() {
		  newCorrection.setDcoPidCode(pidCod);
		  newCorrection.setDcoDacCode(slctdTd.getAffDacCode());
		  newCorrection.setDcoDteSaisi(Calendar.getInstance().getTime());
		  newCorrection.setDcoFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
		  newCorrection.setDcoOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
		  newCorrection.setTempType("DAC_CORRECTION");
		  iservice.addObject(newCorrection);
		  chargeDetailCorrection();
		 FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "Correction(s) éffectuée(s) avec succès", ""));
		 
		 userController.setTexteMsg("Correction(s) éffectuée(s) avec succès!");
		 userController.setRenderMsg(true);
		 userController.setSevrityMsg("success");
	  }
	  
	  
	  
	//Validation des corrections
	  @Transactional 
	 public void resultatCorrection() {
		  
		  if(slctdTd.getAffDacBailleur().equalsIgnoreCase("B")) {
			   statutSanction ="SBO";
			   statutSanRetour ="0";
			  
		        }else 
		            if(resultat.equalsIgnoreCase("Valide")){
		        	  statutSanction ="";
					  statutSanRetour ="";
					  
					  if(slctdTd.getAffDacMention().equalsIgnoreCase("Validé pour publication")) {
						  statutSanction ="DPU";
						  statutSanRetour ="0";
						    if(slctdTd.getTModePassation().getMopCode().equalsIgnoreCase("AOR") || slctdTd.getTModePassation().getMopCode().equalsIgnoreCase("PSL"))
						      {
						    	  listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
											new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
											if (!listAvis.isEmpty()) {
												                 //Mis à jour du statut
												                 majAvis= listAvis.get(0);
												                 majAvis.setTStatut(new TStatut(statutSanction));
												                 majAvis.setAaoDtePub(Calendar.getInstance().getTime());
												                 iservice.updateObject(majAvis);
											                       }
						    	
						         }else {
						        	 
						        	  listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
												new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
												if (!listAvis.isEmpty()) {
													                 //Mis à jour du statut
													                 majAvis= listAvis.get(0);
													                 majAvis.setTStatut(new TStatut("APU"));
													                 majAvis.setAaoDtePub(Calendar.getInstance().getTime());
													                 iservice.updateObject(majAvis);
												                       }
						                  }
						    	
						
					                  }else 
					                     if(slctdTd.getAffDacMention().equalsIgnoreCase("Validé et retour à l'AC")){
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
				                    							new WhereClause("DAF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
				                    							if (!daoBinome.isEmpty()) {
				                    								//Mis à  jour de tous les DAO dans T_DAO_AFFECTATION
				                    								for(TDaoAffectation dao : daoBinome) {
				                    									 dao.setDafStaCode(statutSanction);
				                    									 dao.setDafStatutRetour(statutSanRetour);
				                    									 iservice.updateObject(dao);
				                    								       }
				                    							}
				                                             
			                                                }
		  
		/*  if(resultat.equalsIgnoreCase("Valide")) { 
			  statutSanction ="";
			  statutSanRetour ="";
			  if(slctdTd.getAffDacMention().equalsIgnoreCase("Validé pour publication")) {
				  statutSanction ="DPU";
				  statutSanRetour ="0";
				  
				  listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
							new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
							if (!listAvis.isEmpty()) {
								//Mis à jour du statut
								majAvis= listAvis.get(0);
								majAvis.setTStatut(new TStatut(statutSanction));
								majAvis.setAaoDtePub(Calendar.getInstance().getTime());
								iservice.updateObject(majAvis);
							}
				  
			      }else 
			          if(slctdTd.getAffDacMention().equalsIgnoreCase("Validé et retour à l'AC")){
			    	   statutSanction ="D5V";
					   statutSanRetour ="0";
			          }else
			        	   if(slctdTd.getAffDacBailleur().equalsIgnoreCase("O")) {
			        		   statutSanction ="SBO";
							   statutSanRetour ="0";
			        	   }
			  
		               }else if(resultat.equalsIgnoreCase("Rejeté")) {
			             statutSanction ="SRO";
			              statutSanRetour ="1";
		                 }else if(resultat.equalsIgnoreCase("Retour au binome")) {
			            statutSanction ="D3A";
			            statutSanRetour ="1";
		                }*/
		  
			  listCorrection = (List<TCorrectionDac>) iservice.getObjectsByColumn("TCorrectionDac", new ArrayList<String>(Arrays.asList("COR_NUM")),
					  new WhereClause("COR_DAC_CODE",Comparateur.EQ,""+slctdTd.getAffDacCode()));
			           if (!listCorrection.isEmpty()) {
			        	 daoCorr= listCorrection.get(0);
			        	 daoCorr.setCorObservation(getObservationCor());
			        	 daoCorr.setCorFoncodValid(userController.getSlctd().getTOperateur().getOpeNom());
			        	 daoCorr.setCorResultat(resultat);
					     iservice.updateObject(daoCorr);
					     
					     //Mis à jour dans t_Affichage_DAO puis T_DAC_SPECS
					       slctdTd.setAffStaCode(statutSanction);
				           slctdTd.setAffDacStatutRetour(statutSanRetour);
				           iservice.updateObject(slctdTd);
				           
					     //MAJ dans T_DAC_SPECS
					     listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					    		    new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
				 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
				 				if (!listDao.isEmpty()) {
				 					newDao= listDao.get(0);
				 					newDao.setTStatut(new TStatut(slctdTd.getAffStaCode()));
				 					newDao.setDacStatutRetour(slctdTd.getAffDacStatutRetour());
				 			        iservice.updateObject(newDao); 
				 	   	                 }
					     //Activation du bouton d'édition du PV
				 		 etatPV = true;
		     			 etatValiderCsv = false;
		     				     
						 userController.setTexteMsg("Votre sanction a été apportée avec succès!");
						 userController.setRenderMsg(true);
						 userController.setSevrityMsg("success");
	     }   
	}
	
	  
	  
	 public void ouverture () {
		 
		 if(newAvis.getAaoNbrOuv() == 1) {
			    
			// newAvis.get
		 }else
		      if(newAvis.getAaoNbrOuv() == 2){
			 
		 }
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
	  
	  //Examen des pièces du DAO par le Responsable du binôme
	  @Transactional
	  public void examinerPieces() {
		  //Mis à Jour du Statut du DAO dans T_Dao_Affectation, puis dans t_dac_specs
		  // slctdTda.setDafStaCode("D4V"); //Ancien Statut
		   slctdTda.setDafStaCode("DC2");
		   slctdTda.setDafStatutRetour("0");
		   iservice.updateObject(slctdTda);
		   
		   daoAffectes = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
				    new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					new WhereClause("AFF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
				if (!daoAffectes.isEmpty()) {
					daoAff= daoAffectes.get(0);
					daoAff.setAffStaCode(slctdTda.getDafStaCode());
					daoAff.setAffDacStatutRetour(slctdTda.getDafStatutRetour());
			        iservice.updateObject(daoAff); 
  	                 }
		   
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
		  
		    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"DC2"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Histo Dac
					THistoDac dac=new THistoDac();
					dac.setHacDate(Calendar.getInstance().getTime());
					dac.setHacCommentaire("DAO Corrigé par le responsable du binôme");
					dac.setTDacSpecs(newDao);
					dac.setTFonction(userController.getSlctd().getTFonction());
					dac.setTOperateur(userController.getSlctd().getTOperateur());
					dac.setTStatut(statuts);
					iservice.addObject(dac);
				 //chargePiecesByDao();
				//Actualisation du Tableau de Bord
				tableauBordController.chargeDataDaoPs();
				//Activation et désactivation des boutons valider
				etatBtnValid = false;
				validCorrection = true;
				etatDaoCorrige = true;
				 //Message de confirmation
				 userController.setTexteMsg("Correction(s) éffectuée(s) avec succès!");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
		
	         }else { 
	        	 
		           listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		        		   new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					       new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
				               if (!listDao.isEmpty()) { newDao= listDao.get(0);}
		                             String chaine="CORRECTION DU DOSSIER D''APPEL D''OFFRES N°";
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
		     
		                                       //Mis à Jour du Statut du DAO dans T_Affichage_Dao, puis dans t_dac_specs
			                                       //slctdTda.setDafStaCode("D4V"); //Ancien Statut
		                                           slctdTda.setDafStaCode("DC2");
				                                   slctdTda.setDafStatutRetour("0");
				                                   iservice.updateObject(slctdTda);
				   
				   
				                              daoAffectes = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
						                             new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
							                         new WhereClause("AFF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
						                            if (!daoAffectes.isEmpty()) {
							                               daoAff= daoAffectes.get(0);
							                               daoAff.setAffStaCode(slctdTda.getDafStaCode());
							                               daoAff.setAffDacStatutRetour(slctdTda.getDafStatutRetour());
					                                       iservice.updateObject(daoAff); 
		   	                                                  }
			   
						                      listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
						                               new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
								                       new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
							                           if (!listDao.isEmpty()) {
								                                      newDao= listDao.get(0);
								                                      newDao.setTStatut(new TStatut(slctdTda.getDafStaCode()));
								                                      newDao.setDacStatutRetour(slctdTda.getDafStatutRetour());
						                                              iservice.updateObject(newDao); 
				   	                                                 }
							
						                           List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"DC2"));
						                           TStatut statuts = new TStatut();
						                           if(!LS.isEmpty()) statuts = LS.get(0);
							                      //Histo Dac
									              THistoDac dac=new THistoDac();
									              dac.setHacDate(Calendar.getInstance().getTime());
									              dac.setHacCommentaire("DAO Corrigé par le responsable du binôme");
									              dac.setTDacSpecs(newDao);
									              dac.setTFonction(userController.getSlctd().getTFonction());
									              dac.setTOperateur(userController.getSlctd().getTOperateur());
									              dac.setTStatut(statuts);
									              iservice.addObject(dac);
	 				                               // chargePiecesByDao();				
	 				                              //Actualisation du Tableau de Bord
					                              tableauBordController.chargeDataDaoPs();
					                              //Activation et désactivation des boutons valider
					              				  etatBtnValid = false;
					              				  validCorrection = true;
					              				  etatDaoCorrige = true;
	 				                              //Message de confirmation
	 				                              userController.setTexteMsg("Correction(s) éffectuée(s) avec succès!");
	 				                              userController.setRenderMsg(true);
	 				                              userController.setSevrityMsg("success");
	                                   }
	                              }
	  
	  
	  
	  
	  //Transmission du DAO par le Responsable du binôme
	  @Transactional
	  public void transmettreRespo() {
		  
		  if(dos.getDdaNom().equalsIgnoreCase("") || "".equals(dos.getDdaNom()) || dos.getDdaReference().equalsIgnoreCase("") || "".equals(dos.getDdaReference())) {
			  //Message d'erreur
			  FacesContext.getCurrentInstance().addMessage(null,
			  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez charger le DAO", ""));
			  
		        }else {
			     //Mis à Jour du Statut du DAO dans T_Dao_Affectation, puis dans t_dac_specs
			      slctdTda.setDafStaCode("D4V");
			      slctdTda.setDafStatutRetour("0");
			      iservice.updateObject(slctdTda);
			   
	            //Mis à jour du statut et de l'option retour dans TDacSpecs
			    daoAffectes = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
			    		new WhereClause("AFF_DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
						new WhereClause("AFF_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
					            if (!daoAffectes.isEmpty()) {
						              daoAff= daoAffectes.get(0);
						              daoAff.setAffStaCode(slctdTda.getDafStaCode());
						              daoAff.setAffDacStatutRetour(slctdTda.getDafStatutRetour());
				                      iservice.updateObject(daoAff); 
	  	                                                }
			   //Mis à jour du statut et de l'option retour dans TDacSpecs
			   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					    new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
						new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
					         if (!listDao.isEmpty()) {
						         newDao= listDao.get(0);
						         newDao.setTStatut(new TStatut(slctdTda.getDafStaCode()));
						         newDao.setDacStatutRetour(slctdTda.getDafStatutRetour());
				                 iservice.updateObject(newDao); 
		   	                        }

	            //Historisation du DAO
	            List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"D4V"));
				TStatut statuts = new TStatut();
				if(!LS.isEmpty()) statuts = LS.get(0);
				  //Histo Dac
				  THistoDac dac=new THistoDac();
				  dac.setHacDate(Calendar.getInstance().getTime());
				  dac.setHacCommentaire("DAO Transmis par le responsable du binôme");
				  dac.setTDacSpecs(newDao);
				  dac.setTFonction(userController.getSlctd().getTFonction());
				  dac.setTOperateur(userController.getSlctd().getTOperateur());
				  dac.setTStatut(statuts);
				  iservice.addObject(dac);
				  
				  chargeDaoChargeEtude();
				  chargeDataChargeValid();
				//Actualisation du tableau de bord
 					tableauBordController.chargeDataDaoPs();
 					//Message de confirmation
 					userController.setTexteMsg("Transmission effectuée avec succès!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");
		        }
	       }
	  
	//Contôle sur le nombre d'ouverture
	public void verifOuverture() {
		if(newAvis.aaoNbrOuv == 2) {
			ouvTechnique = true;
			
		  }else {
			  ouvTechnique = false;
			  //ouvFin = ouvTech;
		}
	}
	
	
	public void equalDate() {
		ouvFin = ouvTech;
	}
	  
	  
	//Examen des pièces du DAO par le Chargé d'Etudes du binôme
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
		                             //Mis à jour du statut de DAO récu   
		                             slctdTda.setDafStaCode("DC1");
		                             iservice.updateObject(slctdTda);
		                             //Actualisation de la liste des DAO
		                             chargeDaoChargeEtude();
				                     //Actualisation du Tableau de Bord
				                     tableauBordController.chargeDataDaoPs();
				                     //Message de confirmation
				                     userController.setTexteMsg("Correction(s) éffectuée(s) avec succès!");
				                     userController.setRenderMsg(true);
				                     userController.setSevrityMsg("success");
				                     
	                          }else { 
	        	 
		                                  listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
		                                		     new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					                                 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTda.getDafDacCode()));
				                                  if (!listDao.isEmpty()) { newDao= listDao.get(0);}
		                                          String chaine="CORRECTION DU DOSSIER D''APPEL D''OFFRES N°";
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
	 				
		                                             //Mis à jour du statut de DAO en cours de traitement chez le Chargé d'Etudes  
		       		                                slctdTda.setDafStaCode("DC1");
		       		                                iservice.updateObject(slctdTda); 
		       		                                //Actualisation de la liste des DAO
		       		                                chargeDaoChargeEtude();
	 				                                //Actualisation du Tableau de Bord
					                                 tableauBordController.chargeDataDaoPs();
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
			 userController.setTexteMsg("Correction(s) éffectuée(s) avec succès!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");	
	  }

	  
     ////Validation chargé d'Etudes
	  @Transactional
	  public void valider() throws IOException {
		 slctdTd.setAffStaCode("D4V"); 
		 slctdTd.setAffDacStatutRetour("0");
       	iservice.updateObject(slctdTd);
       	
       	List<TDacSpecs> DA  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getAffDacCode()));
       	TDacSpecs dao = new TDacSpecs();
			if(!DA.isEmpty()) dao = DA.get(0);
			dao.setTStatut(new TStatut("D4V"));
			dao.setDacStatutRetour(slctdTd.getAffStatutRetour());
			iservice.updateObject(dao);
       	
			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"D4V"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Histo Dac
					THistoDac dac=new THistoDac();
					dac.setHacDate(Calendar.getInstance().getTime());
					dac.setHacCommentaire("");
					dac.setTDacSpecs(dao);
					dac.setTFonction(userController.getSlctd().getTFonction());
					dac.setTOperateur(userController.getSlctd().getTOperateur());
					dac.setTStatut(statuts);
					iservice.addObject(dac);
					
					chargeDaoCharegEtude();
					renderPage("dps1","CHADAO");
					//Actualisation du tableau de bord
					tableauBordController.chargeDataDaoPs();
					//Message de confirmation
					userController.setTexteMsg("Validation effectuée avec succès!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");		
    }
	  
	  
	  
	//Publication du DAO
		@Transactional
	  public void publier() {
			  
			listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
					new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
					if (!listAvis.isEmpty()) {
						//Mis à jour du statut
						majAvis= listAvis.get(0);
						majAvis.setTStatut(new TStatut("APU"));
						majAvis.setAaoDtePub(Calendar.getInstance().getTime());
						iservice.updateObject(majAvis);
					}
			 
			slctdTd.setAffStaCode("D6V");
			slctdTd.setAffDacStatutRetour("0");
			iservice.updateObject(slctdTd);
			
			listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
 				if (!listDao.isEmpty()) {
 					newDao= listDao.get(0);
 					newDao.setTStatut(new TStatut("D6V"));
 					newDao.setDacStatutRetour("0");
 			        iservice.updateObject(newDao); 
 	   	                 }
			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"DPU"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Histo Dac
					THistoDac dac=new THistoDac();
					dac.setHacDate(Calendar.getInstance().getTime());
					dac.setHacCommentaire("");
					dac.setTDacSpecs(newDao);
					dac.setTFonction(userController.getSlctd().getTFonction());
					dac.setTOperateur(userController.getSlctd().getTOperateur());
					dac.setTStatut(statuts);
					iservice.addObject(dac);
					chargeData();
					
					chargeDataAPublier();
					//Actualisation du tableau de bord
					tableauBordController.chargeDataDaoPs();
					//Message de confirmation
					userController.setTexteMsg("DAO Publié!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");		
   }
	 
	  
     
         
     //Initiation du DAO en procédure simplifiée 
     @Transactional
     public void saveDao() {
    	 if(daoDetail.getTymCode().equalsIgnoreCase("") || "".equals(daoDetail.getTymCode()) || daoDetail.getMopCode().equalsIgnoreCase("") || "".equalsIgnoreCase(daoDetail.getMopCode()) 
    			 || daoDetail.getDppObjet().equalsIgnoreCase("") || "".equals(daoDetail.getDppObjet()) ) {
    		 //Message d'Erreur
    		 FacesContext.getCurrentInstance().addMessage(null,
	         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez sélectionnez votre PPM, puis faites OK!", ""));
    	 }else {
    		 daoTab = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
    			     new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
    	 if (!daoTab.isEmpty()) {
				dao = daoTab.get(0);
				iservice.updateObject(dao);
				
				userController.setTexteMsg("DAO N° "+dao.getDacCode()+" mis à jour avec succès!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");
				
		    }else {
		    	
	 			    //Insertion des pièces constitutives du DAO 
	 			     if(listSelectionTypePieces.size()==0) {
	 						FacesContext.getCurrentInstance().addMessage(null,
	 						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
	 					}
	 			 		else{      
	 			 			 String exo=gesCode+gesCode+daoDetail.getDppStrCode()+daoDetail.getDppTymCode()+daoDetail.getMopCode();
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
	 				    	 dao.setTTypeDacSpecs(new TTypeDacSpecs("DAO"));
	 				    	 dao.setDacTypePlan("PS");
	 				    	 dao.setDacBailleur(daoDetail.getDppBailleur());
	 				    	 iservice.addObject(dao);
	 				    	 
	 				    	 TAffichageDao affDao = new TAffichageDao();
	 				    	 affDao.setAffDacObjet(dao.getDacObjet());
	 				    	 affDao.setAffDacMention(dao.getDacMention());
	 				    	 affDao.setAffDacDteSaisi(dao.getDacDteSaisi());
	 				    	 affDao.setAffNbrOuv(dao.getDacNbrOuv());
	 				    	 affDao.setTStructure(new TStructure(dao.getTStructure().getStrCode()));
	 				    	 affDao.setTTypeMarche(new TTypeMarche(dao.getTTypeMarche().getTymCode()));
	 				    	 affDao.setAffDacCode(dao.getDacCode());
	 				    	 affDao.setAffDacStatutRetour(dao.getDacStatutRetour());
	 				    	 affDao.setAffDacFonCodAc(dao.getTFonctionByDacFonCodAc().getFonCod());
	 				    	 affDao.setAffDacMention(dao.getDacMention());
	 				    	 affDao.setAffDacDateReception(dao.getDacDateReception());
	 				    	 affDao.setAffDacDacDteValDmp(dao.getDacDteValDmp());
	 				    	 affDao.setAffDacDacDteValCpmp(dao.getDacDteValCpmp());
	 				    	 affDao.setTTypeDacSpecs(new TTypeDacSpecs(dao.getTTypeDacSpecs().getTdcCode()));
	 				    	 affDao.setTGestion(new TGestion(dao.getTGestion().getGesCode()));
	 				    	 affDao.setAffStaCode(dao.getTStatut().getStaCode());
	 				    	 affDao.setAffDacBailleur(dao.getDacBailleur());
	 				    	 affDao.setAffDacTypePlan(dao.getDacTypePlan());
	 				    	 affDao.setTModePassation(new TModePassation(dao.getTModePassation().getMopCode()));
	 				         iservice.addObject(affDao);
	 				    	 
	 				         String search = dao.getTGestion().getGesCode()+""+dao.getDacCode()+""+dao.getDacObjet()+""+dao.getDacTypePlan()+""+dao.getTModePassation().getMopCode()+""+dao.getTTypeMarche().getTymCode();
	 						 String rechercheAll = search.replace("null","");
	 							
	 							List<TAffichageDao> AFG =iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
	 					      				new WhereClause("AFF_DAC_CODE",WhereClause.Comparateur.EQ,""+affDao.getAffDacCode()));
	 				      				TAffichageDao affgp = new TAffichageDao();
	 				      				if(!AFG.isEmpty()) affgp =AFG.get(0); 
	 				      				   affgp.setAffDacRecherche(rechercheAll);
	 					      			   iservice.updateObject(affgp);
	 				         
	 				         
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
	 			 			   
	 			 			   
	 			 			 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"D1S"));
	 						TStatut statuts = new TStatut();
	 						if(!LS.isEmpty()) statuts = LS.get(0);
	 						  //Historisation des Agpm
	 						     THistoDac dacStatut = new THistoDac();
	 						     dacStatut.setHacDate(Calendar.getInstance().getTime());
	 						     dacStatut.setHacCommentaire("Initiation du DAO par une Autorité Contractante");
	 						     dacStatut.setTFonction(userController.getSlctd().getTFonction());
	 						     dacStatut.setTDacSpecs(dao);
	 						     dacStatut.setTOperateur(userController.getSlctd().getTOperateur());
	 						     dacStatut.setTStatut(statuts);
	 						     iservice.addObject(dacStatut);	 
	 						     
	 						     chargeData(); 
	 						     //chargePPM();
	 						     //Actualisation du tableau de Bord
	 						     tableauBordController.chargeDataDao();
	 						     
	 						     userController.setTexteMsg("DAO N° "+dao.getDacCode()+" Initié avec succès!");
	 							 userController.setRenderMsg(true);
	 							 userController.setSevrityMsg("success");
	 							 
	 							 newAvis.aaoLibelle = dao.getDacObjet();
	 			   }
		    	
		    					//Insertion des pièces
		          }
    	        }
          }
     
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
		 		userController.setTexteMsg("Pièces enrégisteé avec succès!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");
				
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Pièces enrégisteé avec succès!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
	 		 }
    		userController.setTexteMsg("Pièces enrégisteé avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Pièces enrégisteé avec succès!", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
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
 
     
      
     //Avis
   	 //Création de l'Avis
        @Transactional
        public void saveAvis() {
        	
        	if(newAvis.getAaoLibelle().equalsIgnoreCase("") || "".equals(newAvis.getAaoCoutDac()) || "".equals(newAvis.getAaoNbrLot()) || "".equals(newAvis.getAaoDelaiVal())) { 
        		
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
            	          		      newAvis.setAaoDteOuvFin(ouvFin);
            	          		      newAvis.setAaoDteOuvTec(ouvTech);
            	          		      newAvis.setTStatut(new TStatut("D1S"));
            	          		      newAvis.setFonCodAc(userController.getSlctd().getTFonction().getFonCod());
            	          		      iservice.addObject(newAvis); 
            	          		   
            	          		   
            	          		   listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
            	          				 new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
            	     					 new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
            	     				   if (!listDao.isEmpty()) {
            	     					    newDao= listDao.get(0);
            	     					    newDao.setDacCout(newAvis.getAaoCoutDac());
            	     			            iservice.updateObject(newDao); 
            	     	   	                 }
            	          		 
            	          		            userController.setTexteMsg("Avis d'Appel d'Offre crée avec succès!");
            	          		            userController.setRenderMsg(true);
            	          		            userController.setSevrityMsg("success"); 
            	                  }
        	                   } 
                     }
     
        
     public void genererLot() {  
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
	  
	  
	  
	 //Methode de récupération de l'adresse
	  public void observationAdresse() {
		  avisAdresse = (List<VAvisAdresse>) iservice.getObjectsByColumn("VAvisAdresse", new ArrayList<String>(Arrays.asList("V_ID")),
					new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+newAvis.getAaoCode()));
	  }
	  
	  //Récupération de l'avis et son Adresse
	  public void observationAvis() { 
		  avisTab = (List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DAC_CODE")),
					new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
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
					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
		       if (!listDao.isEmpty()) {
		    	      newDao = listDao.get(0);
		    	      iservice.updateObject(newDao);
		            }	
		  
		    //Chargement des compteurs du tableau de bord
			tableauBordController.chargeDataDaoPs();	
			//Message de confirmation
			userController.setTexteMsg("DAO mis à jour avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
	    }
	  
	  
	  public void saveLibelleAdresse() {
		  iservice.addObject(newLibelleAdresse);
		  chargeLibelleAdresse();
	  }
	  

	  public void chargeNatureDocTrans() {
			 natureDocListe.clear();
				natureDocListe = ((List<TNatureDocuments>)iservice.getObjectsByColumn("TNatureDocuments",new ArrayList<String>(Arrays.asList("nadCode")),
					    new WhereClause("NAD_TYPE",Comparateur.EQ,"DAO")));		 		 
			}
	  
	  
	 //Choisir au moins un responsable avant de faire une affectation
	  public void openAffectation() {
		  btn_affecter = true;
	  }
	  
	  
	  //Methode d'Affectation
	  @Transactional
	  public void affecterDao() {
		//Insertion des chargés d'études choisis 
			if (listSelectionFonctImput.size()==0) {
						FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
					}
			 		else{
			 			
			 			  if (listSelectionFonctImput.size()==2) {
			 				  
			 				  slctdTd.setAffStaCode("D3A");
			 				  iservice.updateObject(slctdTd);
			 					
			 					listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
			 							new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
			 						if (!listDao.isEmpty()) {
			 							newDao= listDao.get(0);
			 							newDao.setTStatut(new TStatut("D3A"));
			 							newDao.setDacStatutRetour("0");
			 					        iservice.updateObject(newDao); 
			 			   	                 }
			 				  			 				  
			 				  //String exo="";
			 				  String chaine="SEANCE DE COMMISSION INTERNE D'ANALYSE DU DAO N°";
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
				 	    		 com.setComMarCode(slctdTd.getTTypeMarche().getTymCode());
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
			 				 
			 				chargeDaoAffectes();
				 			//Chargement des compteurs du tableau de bord
				 			tableauBordController.chargeDataDao();	
				 			//Message de confirmation
	    					userController.setTexteMsg("Affectation(s) effectuée(s) avec succès!");
							userController.setRenderMsg(true);
							userController.setSevrityMsg("success");

			 			    }else {
			 			    	     FacesContext.getCurrentInstance().addMessage(null,
			 							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez Choisir un binôme !", ""));
			 			          }	
			 		 }
				}
	      
	//Validation chef de service 
	  @Transactional
      public void validerCsv() throws IOException { 
		  
		  if(slctdTd.getAffDacMention().equalsIgnoreCase("Validé pour publication"))
		      {
			    slctdTd.setAffStaCode("DPU");
			    slctdTd.setAffDacStatutRetour("0");
			    iservice.updateObject(slctdTd);
			    
			    listAvis =(List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_CODE")),
						new WhereClause("AAO_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
						if (!listAvis.isEmpty()) {
							//Mis à jour du statut
							majAvis= listAvis.get(0);
							majAvis.setTStatut(new TStatut("APU"));
							majAvis.setAaoDtePub(Calendar.getInstance().getTime());
							iservice.updateObject(majAvis);
						}
						
		      }else {
		    	  slctdTd.setAffStaCode("D5V");
				  slctdTd.setAffDacStatutRetour("0");
				  iservice.updateObject(slctdTd);
		      }
      	
      	List<TDacSpecs> DA  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",Comparateur.EQ,""+slctdTd.getAffDacCode()));
      	TDacSpecs dao = new TDacSpecs();
			if(!DA.isEmpty()) dao = DA.get(0);
			dao.setTStatut(new TStatut(slctdTd.getAffStaCode()));
			dao.setDacStatutRetour(slctdTd.getAffStatutRetour());
			iservice.updateObject(dao);
      	
			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"D5V"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Histo Dac
					THistoDac dac=new THistoDac();
					dac.setHacDate(Calendar.getInstance().getTime());
					dac.setHacCommentaire("DAO Validé par le chef de service");
					dac.setTDacSpecs(dao);
					dac.setTFonction(userController.getSlctd().getTFonction());
					dac.setTOperateur(userController.getSlctd().getTOperateur());
					dac.setTStatut(statuts);
					iservice.addObject(dac);
					
					chargeDataAValider();
					chargeDataValCsv();
					renderPage("dps1","VALDPS");
					//Actualisation du tableau de bord
					tableauBordController.chargeDataDaoPs();
					//Message de confirmation
					userController.setTexteMsg("Validation effectuée avec succès!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");		
   }
	  
	  //Methode d'affichage des lots dans le panier
	 public void affichPanier () {
		 affichLots = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_ID")),
				    new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()),
					new WhereClause("LAA_AJOUT_PANIER",WhereClause.Comparateur.EQ,"O")); 
		 //Inclusion de la fonction qui fait le cummul des montants
		 montantTotalLot();
	 } 
	  
	  
	//Ajout de lot(s) au panier
	  @Transactional
	  public void ajoutPanier() {
	    if(listSelectionVerifLot.size()==0) {
	    	FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez selectionnez un lot", ""));
	     }else {
	    	     for(VVenteLot addLot : listSelectionVerifLot) {
	              
	    		    listLots = (List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_ID")),
	    				    new WhereClause("LAA_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()),
							new WhereClause("LAA_ID",WhereClause.Comparateur.EQ,""+addLot.getLaaId()));
						if (!listLots.isEmpty()) {
							lot= listLots.get(0);
							lot.setLaaAjoutPanier("O");
					        iservice.updateObject(lot); 
	 	   	                 }
						affichPanier();
	               }
			 //Message de confirmation
	        userController.setTexteMsg("Lot(s) ajouté(s) au panier!");
	        userController.setRenderMsg(true);
	        userController.setSevrityMsg("success");
              }
	    }
	  
	  //Cummul des montants lot(s)
	  public void montantTotalLot () {
			 totalMontantLot = 0;
			 for(TLotAao n : affichLots) {
				 totalMontantLot = totalMontantLot+ (n.getLaaCoutLot()); 
			 }
		 }
	  
	  
	  //Dao retourné par le chef de Service
	  @Transactional
	  public void reaffecterCsv () { 
		  if (listeDaoAffectes.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun DAO selectionnée", ""));
			}
	 		else{
	 			
	 			for(TAffichageDao affDao : listeDaoAffectes) {
	 	    		 
	 				daoAffectes = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
							new WhereClause("AFF_DAC_CODE",WhereClause.Comparateur.EQ,""+affDao.getAffDacCode()));
						if (!daoAffectes.isEmpty()) {
							daoAff= daoAffectes.get(0);
							daoAff.setAffStaCode("D5R");
							daoAff.setAffDacStatutRetour("1");
					        iservice.updateObject(daoAff); 
	 	   	                 }
						
						listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
								new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+affDao.getAffDacCode()));
							if (!listDao.isEmpty()) {
								newDao= listDao.get(0);
								newDao.setTStatut(new TStatut("D5R"));
								newDao.setDacStatutRetour("1");
						        iservice.updateObject(newDao); 
		 	   	                 }
						//Insertion de chaque ligne dans T_Histo_Dac avec le statut correspondant
						List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"D5R"));
					    TStatut statuts = new TStatut();
					      if(!LS.isEmpty()) statuts = LS.get(0);
					  //Historisation des DAO
					     THistoDac histoDac = new THistoDac();
					     histoDac.setHacDate(Calendar.getInstance().getTime());
					     histoDac.setHacCommentaire("DAO réaffecté par le Chef de Service");
					     histoDac.setTStatut(statuts);
					     histoDac.setTDacSpecs(newDao);
					     histoDac.setTFonction(userController.getSlctd().getTFonction());
					     histoDac.setTOperateur(userController.getSlctd().getTOperateur());
					     iservice.addObject(histoDac);
					     
	 			        chargeDaoAffectesR();
	 			        
	 			        chargeDataDiffCsv();
	 			        //Chargement des compteurs DAO du tableau de bord
	 			        tableauBordController.chargeDataDaoPs();	
	 			        //Message de confirmation
				        userController.setTexteMsg("RéAffectation(s) effectuée(s) avec succès!");
				        userController.setRenderMsg(true);
				        userController.setSevrityMsg("success");
		    }
         }
	  }
	  
	  
	//Edition du PV de Correction
		 public void imprimerPv() {
				projetReport.stringparam1(slctdTd.getAffDacCode(), "PV_examen", "PV_examen");
			}
	  
		//Edition du recu de paiement
		 public void imprimerRecu() {
				projetReport.stringparam3(slctdTd.getAffDacCode(), newCandidat.getCanNom(), newCandidat.getCanPrenoms(), "Recu_dao", "Recu_dao");
			}
  
	//Téléchargement des DAO type depuis la liste d'affichage
	public void opendaoType() throws IOException{
		  if(slctdTd.getTTypeMarche().getTymTymCode().equalsIgnoreCase("0")) {
			  downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+libelleFournitures, libelleFournitures); 
			 // downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX+libelleFournitures, libelleFournitures);  
		  }else
			  if(slctdTd.getTTypeMarche().getTymTymCode().equalsIgnoreCase("2")) {
			downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+libelleTravaux, libelleTravaux); 
			//downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX+libelleTravaux, libelleTravaux);
		  }else
			 if(slctdTd.getTTypeMarche().getTymTymCode().equalsIgnoreCase("1")) {
			 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+libellePrestations, libellePrestations); 
			// downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX+libellePrestations, libellePrestations);
		    }
	  }
	
	
	//Téléchargement des DAO type après la saisie du DAO  
		public void opendaoNew() throws IOException{
			
			  daoRecup = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
						new WhereClause("AFF_DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
					if (!daoRecup.isEmpty()) {
						slctdTd = daoRecup.get(0);
		   	                 }
					
			  if(slctdTd.getTTypeMarche().getTymTymCode().equalsIgnoreCase("0")) {
				  downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES+libelleFournitures, libelleFournitures);  
			  }else
				  if(slctdTd.getTTypeMarche().getTymTymCode().equalsIgnoreCase("2")) {
				downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX+libelleTravaux, libelleTravaux);  
			  }else
				 if(slctdTd.getTTypeMarche().getTymTymCode().equalsIgnoreCase("1")) {
				 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATION+libellePrestations, libellePrestations);  
			    }
		  }
	
	
	  
	       @Transactional
			public void upload(FileUploadEvent event) throws java.io.FileNotFoundException { 
			 //condition de chargement d'un document : Nature sélectionnée 
			 if((docNature == null || "".equals(docNature))){
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sélectionnée pour le chargement! ","");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
				 
				 }else {
			
			if(fileUploadController.handleFileUpload(event, ""+slctdTd.getAffDacCode(), docNature)) {
				
				listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
	 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
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
	       
	       
	       
	       
	       @Transactional
			public void uploadCharge(FileUploadEvent event) throws java.io.FileNotFoundException { 
			 //condition de chargement d'un document : Nature sélectionnée 
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
				//check le dossier s'il existe à faire
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
				
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectué avec succés!", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				chargeDossierCharge();
				}else {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger à nouveau un document ! ","");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
					
				}
			  }
			}
	  
	  
	
	  
	  
	   public void checkVente() {
			 if(sitDac.equalsIgnoreCase("Retrait")) { 
				 confirmVente = false;
			 }else 
			      if(sitDac.equalsIgnoreCase("Vente")){
				 confirmVente = true; 
			 }
		 }
	  
     
     
     public void onSelectFonctionPgpmDmp() {
		// plan.setTFonction(new TFonction(fonction.getFonCod()));
		 recupFonction = new TFonction();
		 recupFonction.setFonCod(fonction.getFonCod());
		 recupFonction.setFonLibelle(fonction.getFonLibelle());
		 
		 chargePPMCpmDmp();
			}
     
     public void onSelectFonctionPgpmCpmp() {
		 //plan.setTFonction(new TFonction(fonction.getFonCod()));
		 
		 recupFonction = new TFonction();
		 recupFonction.setFonCod(fonction.getFonCod());
		 recupFonction.setFonLibelle(fonction.getFonLibelle());
		 
		 chargePPMCpmDmp();
			}
     
  
     
     public void chargeDossier() {
 		 dossListe.clear();
 			 dossListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTd.getAffDacCode())));			
 	 } 
     
     
     public void chargeDossierCharge() {
    	 dossDacListe.clear();
    	 dossDacListe = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
 					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,slctdTda.getDafDacCode())));			
 	 } 
     
     
     
     //Supprimer un dao joint
    public void removeDossier(){
	downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDdaReference(), selectedDossier.getDdaReference());
		 iservice.deleteObject(selectedDossier);
		 
		 chargeDossier();	
		 
	    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDdaReference()+" supprimé!", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);	
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
	 
	  //Ajouter manuellement un lot
    public void saveLot(){
    	 if(newAvis.getAaoNbrLot() > newLot.getLaaNum()) {
    		 
    		 //newLot.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
    		 newLot.setTAvisAppelOffre(newAvis);
        	 iservice.addObject(newLot);
        	 chargeLots();
        	 userController.setTexteMsg("Lot enregistré avec succès !");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
    		 
    	 }else {
    		 FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez respecter le nombre de lots renseigné", ""));
    	 }
	}
    
    
	  
	//Affichage des motifs de retour
			public void chargerObservation() {
				daostatutList=(List<VDaoStatut>) iservice.getObjectsByColumn("VDaoStatut", new ArrayList<String>(Arrays.asList("HAC_DAC_CODE")),
						new WhereClause("HAC_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()),
						new WhereClause("HAC_STA_CODE",WhereClause.Comparateur.EQ,slctdTd.getAffStaCode()));
				if(!daostatutList.isEmpty()) {
					int i=daostatutList.size();
					int baoule=i-1;
					daostatut=daostatutList.get(baoule);
				}	
			}	

     
     
     
     public void onSelectLigneBudgetaire() {
         newLot.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
         
		 recupLigne = new VLigneImputation();
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
     
     
     public void chargeFonctionCpm() {
		 listeFonctions.clear();
		 listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
					"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM")),
					new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	 }
     
     public void chargeFonctionDmp() {
			listeFonctions.clear();
			listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
						"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM","DMP")),
						new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
		 }
     
     
     
     
     
     public void checkMtexig() {
		 if(sit.equalsIgnoreCase("O")) {
			 etatMtExig = true; 
		 }else {
			 etatMtExig= false;  
		 }
	 }
     
       
        
        
        @Transactional
        public void transmettre() {
        	
        	if(dos.getDdaNom().equalsIgnoreCase("") || "".equals(dos.getDdaNom()) || dos.getDdaReference().equalsIgnoreCase("") || "".equals(dos.getDdaReference())) {
        		//Message d'erreur
		          FacesContext.getCurrentInstance().addMessage(null,
	      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez joindre votre fichier avant Transmission", ""));
        	      }else {
        		          slctdTd.setAffStaCode("D1T");
           	              slctdTd.setAffDacStatutRetour("0");
       			          iservice.updateObject(slctdTd);
       			
       			          listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
       					      new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
       				             if (!listDao.isEmpty()) {
       					                 newDao= listDao.get(0);
                                         newDao.setDacDateValAc(Calendar.getInstance().getTime());
       					                 newDao.setTStatut(new TStatut("D1T"));
       					                 newDao.setDacStatutRetour("0");
       					                 newDao.setDacMention(slctdTd.getAffDacMention());
       			                         iservice.updateObject(newDao); 
       	   	                           } 
       				
       				
       				       daoAffectes = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
       						   new WhereClause("AFF_DAC_CODE",WhereClause.Comparateur.EQ,""+newDao.getDacCode()));
       					           if (!daoAffectes.isEmpty()) {
       						            daoAff= daoAffectes.get(0);
       						            daoAff.setAffDacValAc(Calendar.getInstance().getTime());
       						            daoAff.setAffStaCode(newDao.getTStatut().getStaCode());
       						            daoAff.setAffDacStatutRetour(newDao.getDacStatutRetour());
       				                    iservice.updateObject(daoAff); 
       	   	                                 }
       				
       			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"D1T"));
       			TStatut statuts = new TStatut();
       			if(!LS.isEmpty()) statuts = LS.get(0);
       			  //Histo Dac
       					THistoDac dac=new THistoDac();
       					dac.setHacDate(Calendar.getInstance().getTime());
       					dac.setHacCommentaire("DAO transmit par l'Autorité Contractante");
       					dac.setTDacSpecs(newDao);
       					dac.setTFonction(userController.getSlctd().getTFonction());
       					dac.setTOperateur(userController.getSlctd().getTOperateur());
       					dac.setTStatut(statuts);
       					iservice.addObject(dac);
       					chargeData();
       					
       					chargeDaoTrans();
       					
       					chargeDaoTabTrans();
       					//Actualisation du tableau de bord
       					tableauBordController.chargeDataDaoPs();
       					//Message de confirmation
       					userController.setTexteMsg("Transmission effectuée avec succès!");
   						userController.setRenderMsg(true);
   						userController.setSevrityMsg("success");
        	         }
                  }
        
        
        
        @Transactional
        public void transmettreCpmp() {
        	slctdTd.setAffStaCode("D2T");
        	slctdTd.setAffDacStatutRetour("0");
			iservice.updateObject(slctdTd);
			
			listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
				if (!listDao.isEmpty()) {
					newDao= listDao.get(0);
					newDao.setTStatut(new TStatut("D2T"));
					newDao.setDacStatutRetour("0");
			        iservice.updateObject(newDao); 
	   	                 }
				
				daoAffectes = (List<TAffichageDao>) iservice.getObjectsByColumn("TAffichageDao", new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
						new WhereClause("AFF_DAC_CODE",WhereClause.Comparateur.EQ,""+newDao.getDacCode()));
					if (!daoAffectes.isEmpty()) {
						daoAff= daoAffectes.get(0);
						daoAff.setAffDacValAc(Calendar.getInstance().getTime());
						daoAff.setAffStaCode(newDao.getTStatut().getStaCode());
						daoAff.setAffDacStatutRetour(newDao.getDacStatutRetour());
				        iservice.updateObject(daoAff); 
	   	                 }
				
			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"D2T"));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			  //Histo Dac
					THistoDac dac=new THistoDac();
					dac.setHacDate(Calendar.getInstance().getTime());
					dac.setHacCommentaire("");
					dac.setTDacSpecs(newDao);
					dac.setTFonction(userController.getSlctd().getTFonction());
					dac.setTOperateur(userController.getSlctd().getTOperateur());
					dac.setTStatut(statuts);
					iservice.addObject(dac);
					//chargeData();
					
					//chargeDataAExaminer();
					
					chargeDaoTrans();
					//Actualisation du tableau de bord
					tableauBordController.chargeDataDaoPs();
					//Message de confirmation
					userController.setTexteMsg("Transmission effectuée avec succès!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");		
     }
       
	 
	 
	 
        public TDossierDacs checkDocument(String dacCode, long natCode) {
        	TDossierDacs val ;
			List<TDossierDacs> listDoc = ((List<TDossierDacs>)iservice.getObjectsByColumn("TDossierDacs",new ArrayList<String>(Arrays.asList("DDA_ID")),
					 new WhereClause("DDA_DAC_CODE",Comparateur.EQ,""+dacCode),
					new WhereClause("DDA_PID_CODE",Comparateur.EQ,""+natCode)));
			return (listDoc.isEmpty() || listDoc==null)?null:listDoc.get(0);
		}
        
        
        public TAvisAppelOffre checkAvis(String dacCode) {
        	TAvisAppelOffre val ;
			List<TAvisAppelOffre> listDoc = ((List<TAvisAppelOffre>)iservice.getObjectsByColumn("TAvisAppelOffre",new ArrayList<String>(Arrays.asList("AAO_CODE")),
					 new WhereClause("AAO_DAC_CODE",Comparateur.EQ,""+dacCode)));
			return (listDoc.isEmpty() || listDoc==null)?null:listDoc.get(0);
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
	
	 
	 
	 //Retrait du DAO
	 @Transactional
		public void retirer()throws IOException{
		       slctdTd.setAffStaCode("RET");
		       slctdTd.setAffDacStatutRetour("0"); 
			   iservice.updateObject(slctdTd);
			 
			 listDao = (List<TDacSpecs>) iservice.getObjectsByColumn("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
 					new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAffDacCode()));
 				if (!listDao.isEmpty()) {
 					newDao= listDao.get(0);
 					newDao.setTStatut(new TStatut("RET"));
 					newDao.setDacStatutRetour("0");
 			        iservice.updateObject(newDao); 
 	   	                 }
					
			  List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"RET"));
			  TStatut statuts = new TStatut();
					  
			  if(!LS.isEmpty()) {statuts = LS.get(0);
			   //historisation d
				THistoDac histo =new THistoDac();
				histo.setHacCommentaire("DAO retiré");
				histo.setHacDate(Calendar.getInstance().getTime());
				histo.setTDacSpecs(newDao);
				histo.setTStatut(statuts);
				histo.setTOperateur(userController.getSlctd().getTOperateur());
				histo.setTFonction(userController.getSlctd().getTFonction());
				iservice.addObject(histo);
				//Afficher la liste des DAO en attente de retrait
				chargeDataARetirer();
				//Message de confirmation du retrait
				userController.setTexteMsg("Retrait effectué avec succès!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");
				 
			 //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Retrait effectué avec succès! ", ""));
			  }
			  
			  //Insertion dans T_RETRAIT
			  retrait.setRetTypePiece("Document d'identification");
			  retrait.setTDacSpecs(newDao);
			  retrait.setRetTypePiece("PDI");
			  retrait.setTFonction(userController.getSlctd().getTFonction());
			  retrait.setTOperateur(userController.getSlctd().getTOperateur());
			  retrait.setRetDate(Calendar.getInstance().getTime());
			  iservice.addObject(retrait);
		}
	 
 
	 
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);	 
		     switch(value) {
				case "dps1":
					chargeData();
					chargeGestions();
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
					_logger.info("value: "+value+" action "+action);	
					break;
				case "dps2":
					chargePPM();
				break;
				case "dps3":
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dps4":
		 			_logger.info("value: "+value+" action: "+action);
				break;
                case "dps5":
                	chargeFonctionImput();
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dps6":
                	chargePiecesByDao();
                	chargePiecesByCsv();
                	chargePiecesByCharges();
                	chargeRespoExiste();
                	chargePiecesByBinome();
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dps7":
		 			_logger.info("value: "+value+" action: "+action);
				break;  
				
                case "dps9":
                	 //chargeLotExiste();
                	 chargeSoumissions();
                	 recupMontantDao();
                	 newCandidat = new TCandidats();
                	 etatRecu = false;
                	 sitDac = "";
		 			_logger.info("value: "+value+" action: "+action);
				break; 
				
                case "dps10":
                	 chargeBailleurDao();
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
			    }
		     return userController.renderPage(value);  
	 }

	 




	public List<TDetailPlanPassation> getListePPM() {
		return listePPM;
	}


	public void setListePPM(List<TDetailPlanPassation> listePPM) {
		this.listePPM = listePPM;
	}


	public List<TAffichagePpm> getDetailPPM() {
		return detailPPM;
	}

	public void setDetailPPM(List<TAffichagePpm> detailPPM) {
		this.detailPPM = detailPPM;
	}


	public List<TDetailPlanPassation> getListSelectionTransmission() {
		return listSelectionTransmission;
	}

	public void setListSelectionTransmission(List<TDetailPlanPassation> listSelectionTransmission) {
		this.listSelectionTransmission = listSelectionTransmission;
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


	public List<TDetailPlanPassation> getListeDetail() {
		return listeDetail;
	}

	public void setListeDetail(List<TDetailPlanPassation> listeDetail) {
		this.listeDetail = listeDetail;
	}


	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}


	public TDetailPlanPassation getDemDetail() {
		return demDetail;
	}

	public void setDemDetail(TDetailPlanPassation demDetail) {
		this.demDetail = demDetail;
	}

	public TDacSpecs getDao() {
		return dao;
	}

	public void setDao(TDacSpecs dao) {
		this.dao = dao;
	}
	

	public List<TDossierDacs> getDossListe() {
		return dossListe;
	}

	public void setDossListe(List<TDossierDacs> dossListe) {
		this.dossListe = dossListe;
	}


	public long getNatdoc() {
		return natdoc;
	}
	public void setNatdoc(long natdoc) {
		this.natdoc = natdoc;
	}


	public TDossierDacs getSelectedDossier() {
		return selectedDossier;
	}

	public void setSelectedDossier(TDossierDacs selectedDossier) {
		this.selectedDossier = selectedDossier;
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


	public List<TLotAao> getListeLots() {
		return listeLots;
	}

	public void setListeLots(List<TLotAao> listeLots) {
		this.listeLots = listeLots;
	}


	public TLotAao getSelectLot() {
		return selectLot;
	}
	public void setSelectLot(TLotAao selectLot) {
		this.selectLot = selectLot;
	}

	public String getFiltreLigne() {
		return filtreLigne;
	}

	public void setFiltreLigne(String filtreLigne) {
		this.filtreLigne = filtreLigne;
	}


	public List<VFonctionMinistere> getListeFonctions() {
		return listeFonctions;
	}

	public void setListeFonctions(List<VFonctionMinistere> listeFonctions) {
		this.listeFonctions = listeFonctions;
	}


	public String getFiltreFonction() {
		return filtreFonction;
	}

	public void setFiltreFonction(String filtreFonction) {
		this.filtreFonction = filtreFonction;
	}


	public VFonctionMinistere getFonction() {
		return fonction;
	}

	public void setFonction(VFonctionMinistere fonction) {
		this.fonction = fonction;
	}
	
	public List<TTypePiecesDac> getDetailsPieces() {
		return detailsPieces;
	}

	public void setDetailsPieces(List<TTypePiecesDac> detailsPieces) {
		this.detailsPieces = detailsPieces;
	}


	public List<VPpmDao> getPpmDao() {
		return ppmDao;
	}


	public void setPpmDao(List<VPpmDao> ppmDao) {
		this.ppmDao = ppmDao;
	}


	public List<VPpmDao> getListSelectionPpmDao() {
		return listSelectionPpmDao;
	}

	public void setListSelectionPpmDao(List<VPpmDao> listSelectionPpmDao) {
		this.listSelectionPpmDao = listSelectionPpmDao;
	}


	public VPpmDao getDaoDetail() {
		return daoDetail;
	}

	public void setDaoDetail(VPpmDao daoDetail) {
		this.daoDetail = daoDetail;
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


	public List<VLigneImputation> getListeImputations() {
		return listeImputations;
	}

	public void setListeImputations(List<VLigneImputation> listeImputations) {
		this.listeImputations = listeImputations;
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


	public VDetailAdresse getDetailAdresse() {
		return detailAdresse;
	}
	public void setDetailAdresse(VDetailAdresse detailAdresse) {
		this.detailAdresse = detailAdresse;
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
	
	public List<TTypePiecesDac> getListSelectionTypePieces() {
		return listSelectionTypePieces;
	}

	public void setListSelectionTypePieces(List<TTypePiecesDac> listSelectionTypePieces) {
		this.listSelectionTypePieces = listSelectionTypePieces;
	}

	
	public boolean isValue1() {
		return value1;
	}
	
	public void setValue1(boolean value1) {
		this.value1 = value1;
	}


	public List<VFonctionImputation> getListeFonctionsImput() {
		return listeFonctionsImput;
	}

	public void setListeFonctionsImput(List<VFonctionImputation> listeFonctionsImput) {
		this.listeFonctionsImput = listeFonctionsImput;
	}


	public String getFilterCode() {
		return filterCode;
	}

	public void setFilterCode(String filterCode) {
		this.filterCode = filterCode;
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


	public VFonctionImputation getNewImput() {
		return newImput;
	}

	public void setNewImput(VFonctionImputation newImput) {
		this.newImput = newImput;
	}



	public List<VFonctionImputation> getListSelectionFonctImput() {
		return listSelectionFonctImput;
	}

	public void setListSelectionFonctImput(List<VFonctionImputation> listSelectionFonctImput) {
		this.listSelectionFonctImput = listSelectionFonctImput;
	}

	public String getDocNature() {
		return docNature;
	}

	public void setDocNature(String docNature) {
		this.docNature = docNature;
	}


	public List<TNatureDocuments> getNatureDocListe() {
		return natureDocListe;
	}

	public void setNatureDocListe(List<TNatureDocuments> natureDocListe) {
		this.natureDocListe = natureDocListe;
	}


	public String getNbreDaoTrans() {
		return nbreDaoTrans;
	}


	public void setNbreDaoTrans(String nbreDaoTrans) {
		this.nbreDaoTrans = nbreDaoTrans;
	}


	public String getDetCom() {
		return detCom;
	}

	public void setDetCom(String detCom) {
		this.detCom = detCom;
	}

	
	public List<TAffichageDao> getValidationListe() {
		return validationListe;
	}


	public void setValidationListe(List<TAffichageDao> validationListe) {
		this.validationListe = validationListe;
	}


	public String getDacCode() {
		return dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	public String getLibelleTravaux() {
		return libelleTravaux;
	}

	public void setLibelleTravaux(String libelleTravaux) {
		this.libelleTravaux = libelleTravaux;
	}


	public String getLibelleFournitures() {
		return libelleFournitures;
	}

	public void setLibelleFournitures(String libelleFournitures) {
		this.libelleFournitures = libelleFournitures;
	}



	public String getLibellePrestations() {
		return libellePrestations;
	}

	public void setLibellePrestations(String libellePrestations) {
		this.libellePrestations = libellePrestations;
	}



	public List <VDaoStatut> getDaostatutList() {
		return daostatutList;
	}

	public void setDaostatutList(List <VDaoStatut> daostatutList) {
		this.daostatutList = daostatutList;
	}

	public VDaoStatut getDaostatut() {
		return daostatut;
	}

	public void setDaostatut(VDaoStatut daostatut) {
		this.daostatut = daostatut;
	}


	public List<VDaoChargeEtude> getListDaoValCharge() {
		return listDaoValCharge;
	}

	public void setListDaoValCharge(List<VDaoChargeEtude> listDaoValCharge) {
		this.listDaoValCharge = listDaoValCharge;
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


	public VbTempParametreCorrection getNewCorrection() {
		return newCorrection;
	}

	public void setNewCorrection(VbTempParametreCorrection newCorrection) {
		this.newCorrection = newCorrection;
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
	
	public String getSit() {
		return sit;
	}

	public void setSit(String sit) {
		this.sit = sit;
	}


	public boolean isEtatQualif() {
		return etatQualif;
	}


	public void setEtatQualif(boolean etatQualif) {
		this.etatQualif = etatQualif;
	}


	public List<TAvisAppelOffre> getListAvis() {
		return listAvis;
	}
	public void setListAvis(List<TAvisAppelOffre> listAvis) {
		this.listAvis = listAvis;
	}


	public TAvisAppelOffre getMajAvis() {
		return majAvis;
	}
	public void setMajAvis(TAvisAppelOffre majAvis) {
		this.majAvis = majAvis;
	}


	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getStatutUpdate() {
		return statutUpdate;
	}
	public void setStatutUpdate(String statutUpdate) {
		this.statutUpdate = statutUpdate;
	}


	public String getResultat() {
		return resultat;
	}


	public void setResultat(String resultat) {
		this.resultat = resultat;
	}


	public String getObservationCor() {
		return observationCor;
	}

	public void setObservationCor(String observationCor) {
		this.observationCor = observationCor;
	}


	public List<TCorrectionDac> getListCorrection() {
		return listCorrection;
	}

	public void setListCorrection(List<TCorrectionDac> listCorrection) {
		this.listCorrection = listCorrection;
	}


	public TCorrectionDac getDaoCorr() {
		return daoCorr;
	}


	public void setDaoCorr(TCorrectionDac daoCorr) {
		this.daoCorr = daoCorr;
	}


	public boolean isEtatPV() {
		return etatPV;
	}


	public void setEtatPV(boolean etatPV) {
		this.etatPV = etatPV;
	}


	public TDacSpecs getNewDao() {
		return newDao;
	}


	public void setNewDao(TDacSpecs newDao) {
		this.newDao = newDao;
	}


	public List<TDacSpecs> getListDao() {
		return listDao;
	}


	public void setListDao(List<TDacSpecs> listDao) {
		this.listDao = listDao;
	}


	public List<TAffichageDao> getListeDAO() {
		return listeDAO;
	}


	public void setListeDAO(List<TAffichageDao> listeDAO) {
		this.listeDAO = listeDAO;
	}


	public List<TAffichageDao> getListeDaoTrans() {
		return listeDaoTrans;
	}


	public void setListeDaoTrans(List<TAffichageDao> listeDaoTrans) {
		this.listeDaoTrans = listeDaoTrans;
	}


	public List<TAffichageDao> getDaoValCsv() {
		return daoValCsv;
	}


	public void setDaoValCsv(List<TAffichageDao> daoValCsv) {
		this.daoValCsv = daoValCsv;
	}


	public List<TAffichageDao> getDaoDiffCsv() {
		return daoDiffCsv;
	}


	public void setDaoDiffCsv(List<TAffichageDao> daoDiffCsv) {
		this.daoDiffCsv = daoDiffCsv;
	}


	public List<TAffichageDao> getDaoAffectes() {
		return daoAffectes;
	}


	public void setDaoAffectes(List<TAffichageDao> daoAffectes) {
		this.daoAffectes = daoAffectes;
	}


	public List<TAffichageDao> getPublicationListe() {
		return publicationListe;
	}


	public void setPublicationListe(List<TAffichageDao> publicationListe) {
		this.publicationListe = publicationListe;
	}


	public List<TAffichageDao> getDaoRecup() {
		return daoRecup;
	}


	public void setDaoRecup(List<TAffichageDao> daoRecup) {
		this.daoRecup = daoRecup;
	}


	public List<TAffichageDao> getListeDaoAffectes() {
		return listeDaoAffectes;
	}


	public void setListeDaoAffectes(List<TAffichageDao> listeDaoAffectes) {
		this.listeDaoAffectes = listeDaoAffectes;
	}


	public TAffichageDao getDaoAff() {
		return daoAff;
	}


	public void setDaoAff(TAffichageDao daoAff) {
		this.daoAff = daoAff;
	}


	public void setSlctdTd(TAffichageDao slctdTd) {
		this.slctdTd = slctdTd;
	}

	public TAffichageDao getSlctdTd() {
		return slctdTd;
	}
	

	public List<TDacSpecs> getListeTabDaoTrans() {
		return listeTabDaoTrans;
	}

	public void setListeTabDaoTrans(List<TDacSpecs> listeTabDaoTrans) {
		this.listeTabDaoTrans = listeTabDaoTrans;
	}


	public List<TDacSpecs> getListeTabDaoAffecCsv() {
		return listeTabDaoAffecCsv;
	}


	public void setListeTabDaoAffecCsv(List<TDacSpecs> listeTabDaoAffecCsv) {
		this.listeTabDaoAffecCsv = listeTabDaoAffecCsv;
	}


	public List<TDacSpecs> getListeTabDaoCsvAff() {
		return listeTabDaoCsvAff;
	}


	public void setListeTabDaoCsvAff(List<TDacSpecs> listeTabDaoCsvAff) {
		this.listeTabDaoCsvAff = listeTabDaoCsvAff;
	}


	public List<TDacSpecs> getListeTabdaoValCsv() {
		return listeTabdaoValCsv;
	}


	public void setListeTabdaoValCsv(List<TDacSpecs> listeTabdaoValCsv) {
		this.listeTabdaoValCsv = listeTabdaoValCsv;
	}


	public List<TDacSpecs> getListeTabdaoDiffCsv() {
		return listeTabdaoDiffCsv;
	}


	public void setListeTabdaoDiffCsv(List<TDacSpecs> listeTabdaoDiffCsv) {
		this.listeTabdaoDiffCsv = listeTabdaoDiffCsv;
	}


	public boolean isEtatValiderCsv() {
		return etatValiderCsv;
	}
	public void setEtatValiderCsv(boolean etatValiderCsv) {
		this.etatValiderCsv = etatValiderCsv;
	}


	public List<TAffichageDao> getAffectationListe() {
		return affectationListe;
	}
	public void setAffectationListe(List<TAffichageDao> affectationListe) {
		this.affectationListe = affectationListe;
	}


	public List<TCorrectionDac> getListPieceCorrection() {
		return listPieceCorrection;
	}
	public void setListPieceCorrection(List<TCorrectionDac> listPieceCorrection) {
		this.listPieceCorrection = listPieceCorrection;
	}


	public TCorrectionDac getCorrection() {
		return correction;
	}


	public void setCorrection(TCorrectionDac correction) {
		this.correction = correction;
	}


	public List<VDetailCorrection> getListeDetailCorrection() {
		return listeDetailCorrection;
	}


	public void setListeDetailCorrection(List<VDetailCorrection> listeDetailCorrection) {
		this.listeDetailCorrection = listeDetailCorrection;
	}


	public List<TDaoAffectation> getDaoExamen() {
		return daoExamen;
	}


	public void setDaoExamen(List<TDaoAffectation> daoExamen) {
		this.daoExamen = daoExamen;
	}


	public TDaoAffectation getSlctdTda() {
		return slctdTda;
	}


	public void setSlctdTda(TDaoAffectation slctdTda) {
		this.slctdTda = slctdTda;
	}


	public VDetailCorrection getDetailCor() {
		return detailCor;
	}


	public void setDetailCor(VDetailCorrection detailCor) {
		this.detailCor = detailCor;
	}


	public boolean isEtatSanction() {
		return etatSanction;
	}


	public void setEtatSanction(boolean etatSanction) {
		this.etatSanction = etatSanction;
	}


	public List<VDetailCorrectionCharge> getListeCorrectionCharge() {
		return listeCorrectionCharge;
	}


	public void setListeCorrectionCharge(List<VDetailCorrectionCharge> listeCorrectionCharge) {
		this.listeCorrectionCharge = listeCorrectionCharge;
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


	public List<TAffichageDao> getListeDaoARetirer() {
		return listeDaoARetirer;
	}
	public void setListeDaoARetirer(List<TAffichageDao> listeDaoARetirer) {
		this.listeDaoARetirer = listeDaoARetirer;
	}


	public List<TDacSpecs> getListeDaoRetire() {
		return listeDaoRetire;
	}


	public void setListeDaoRetire(List<TDacSpecs> listeDaoRetire) {
		this.listeDaoRetire = listeDaoRetire;
	}


	public boolean isEtatTaux() {
		return etatTaux;
	}


	public void setEtatTaux(boolean etatTaux) {
		this.etatTaux = etatTaux;
	}


	public String getChoixTaux() {
		return choixTaux;
	}


	public void setChoixTaux(String choixTaux) {
		this.choixTaux = choixTaux;
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


	public String getMultiFiltre() {
		return multiFiltre;
	}


	public void setMultiFiltre(String multiFiltre) {
		this.multiFiltre = multiFiltre;
	}


	public TLotAao getLot() {
		return lot;
	}


	public void setLot(TLotAao lot) {
		this.lot = lot;
	}


	public boolean isEtatMtExig() {
		return etatMtExig;
	}


	public void setEtatMtExig(boolean etatMtExig) {
		this.etatMtExig = etatMtExig;
	}


/*	public TLotAao getSlctdTb() {
		return slctdTb;
	}

	public void setSlctdTb(TLotAao slctdTb) {
		this.slctdTb = slctdTb;
	}*/


	public List<TAffichageDao> getListeDaoVente() {
		return listeDaoVente;
	}
	public void setListeDaoVente(List<TAffichageDao> listeDaoVente) {
		this.listeDaoVente = listeDaoVente;
	}


	public List<TLotAao> getAffichLots() {
		return affichLots;
	}


	public void setAffichLots(List<TLotAao> affichLots) {
		this.affichLots = affichLots;
	}


	public List<TTiers> getListTiers() {
		return listTiers;
	}


	public void setListTiers(List<TTiers> listTiers) {
		this.listTiers = listTiers;
	}


	public List<TLotAao> getListLots() {
		return listLots;
	}


	public void setListLots(List<TLotAao> listLots) {
		this.listLots = listLots;
	}


	public TTiers getNewEntre() {
		return newEntre;
	}


	public void setNewEntre(TTiers newEntre) {
		this.newEntre = newEntre;
	}


	public String getFiltreNcc() {
		return filtreNcc;
	}
	public void setFiltreNcc(String filtreNcc) {
		this.filtreNcc = filtreNcc;
	}


	public List<VVenteLot> getListVerifLot() {
		return listVerifLot;
	}
	public void setListVerifLot(List<VVenteLot> listVerifLot) {
		this.listVerifLot = listVerifLot;
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


	public VbTempParamVente getNewVbTempVente() {
		return newVbTempVente;
	}


	public void setNewVbTempVente(VbTempParamVente newVbTempVente) {
		this.newVbTempVente = newVbTempVente;
	}


	public List<VVenteLot> getListSelectionVerifLot() {
		return listSelectionVerifLot;
	}


	public void setListSelectionVerifLot(List<VVenteLot> listSelectionVerifLot) {
		this.listSelectionVerifLot = listSelectionVerifLot;
	}


	public long getTotalMontantLot() {
		return totalMontantLot;
	}


	public void setTotalMontantLot(long totalMontantLot) {
		this.totalMontantLot = totalMontantLot;
	}


	public TTiers getRecupTiers() {
		return recupTiers;
	}


	public void setRecupTiers(TTiers recupTiers) {
		this.recupTiers = recupTiers;
	}


	public TTiers getTiers() {
		return tiers;
	}

	public void setTiers(TTiers tiers) {
		this.tiers = tiers;
	}


	public List<TSoumissions> getListSoumission() {
		return listSoumission;
	}
	public void setListSoumission(List<TSoumissions> listSoumission) {
		this.listSoumission = listSoumission;
	}


	public TCandidats getNewCandidat() {
		return newCandidat;
	}
	public void setNewCandidat(TCandidats newCandidat) {
		this.newCandidat = newCandidat;
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


	public TVenteDac getNewVente() {
		return newVente;
	}


	public void setNewVente(TVenteDac newVente) {
		this.newVente = newVente;
	}


	public TDetailVente getVenteDetail() {
		return venteDetail;
	}


	public void setVenteDetail(TDetailVente venteDetail) {
		this.venteDetail = venteDetail;
	}


	public VVenteLot getNbreLot() {
		return nbreLot;
	}

	public void setNbreLot(VVenteLot nbreLot) {
		this.nbreLot = nbreLot;
	}


	public List<TAffichageDao> getDaoPs() {
		return daoPs;
	}


	public void setDaoPs(List<TAffichageDao> daoPs) {
		this.daoPs = daoPs;
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

	public VDetailCorrectionCharge getDetailCharge() {
		return detailCharge;
	}

	public void setDetailCharge(VDetailCorrectionCharge detailCharge) {
		this.detailCharge = detailCharge;
	}

	public List<TDacSpecs> getDaoTab() {
		return daoTab;
	}

	public void setDaoTab(List<TDacSpecs> daoTab) {
		this.daoTab = daoTab;
	}

	public List<TAvisAppelOffre> getAvisTab() {
		return avisTab;
	}

	public void setAvisTab(List<TAvisAppelOffre> avisTab) {
		this.avisTab = avisTab;
	}

	public List<TDaoAffectation> getDaoBinome() {
		return daoBinome;
	}

	public void setDaoBinome(List<TDaoAffectation> daoBinome) {
		this.daoBinome = daoBinome;
	}

	public TDaoAffectation getDaoAffec() {
		return daoAffec;
	}

	public void setDaoAffec(TDaoAffectation daoAffec) {
		this.daoAffec = daoAffec;
	}

	public List<TAffichageDao> getDaoPriseCompte() {
		return daoPriseCompte;
	}

	public void setDaoPriseCompte(List<TAffichageDao> daoPriseCompte) {
		this.daoPriseCompte = daoPriseCompte;
	}

	public List<VDaoBailleur> getListeDaoBailleur() {
		return listeDaoBailleur;
	}

	public void setListeDaoBailleur(List<VDaoBailleur> listeDaoBailleur) {
		this.listeDaoBailleur = listeDaoBailleur;
	}

	public VDaoBailleur getDaoBailleur() {
		return daoBailleur;
	}

	public void setDaoBailleur(VDaoBailleur daoBailleur) {
		this.daoBailleur = daoBailleur;
	}

	public boolean isPanelAvisBailleur() {
		return panelAvisBailleur;
	}

	public void setPanelAvisBailleur(boolean panelAvisBailleur) {
		this.panelAvisBailleur = panelAvisBailleur;
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

	public List<TDacSpecs> getListeDaoVendu() {
		return listeDaoVendu;
	}

	public void setListeDaoVendu(List<TDacSpecs> listeDaoVendu) {
		this.listeDaoVendu = listeDaoVendu;
	}

	public List<TDacSpecs> getListeDaoValide() {
		return listeDaoValide;
	}

	public void setListeDaoValide(List<TDacSpecs> listeDaoValide) {
		this.listeDaoValide = listeDaoValide;
	}

	public List<TDacSpecs> getListeDaoCsvValid() {
		return listeDaoCsvValid;
	}

	public void setListeDaoCsvValid(List<TDacSpecs> listeDaoCsvValid) {
		this.listeDaoCsvValid = listeDaoCsvValid;
	}

	public String getSitDac() {
		return sitDac;
	}

	public void setSitDac(String sitDac) {
		this.sitDac = sitDac;
	}

	public boolean isConfirmVente() {
		return confirmVente;
	}

	public void setConfirmVente(boolean confirmVente) {
		this.confirmVente = confirmVente;
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

	public boolean isPavet4() {
		return pavet4;
	}

	public void setPavet4(boolean pavet4) {
		this.pavet4 = pavet4;
	}

	public List<TDossierDacs> getDossDacListe() {
		return dossDacListe;
	}

	public void setDossDacListe(List<TDossierDacs> dossDacListe) {
		this.dossDacListe = dossDacListe;
	}

	public List<VPiecesOffreDao> getOffresDao() {
		return offresDao;
	}

	public void setOffresDao(List<VPiecesOffreDao> offresDao) {
		this.offresDao = offresDao;
	}

	public List<VAvisAdresse> getAvisAdresse() {
		return avisAdresse;
	}

	public void setAvisAdresse(List<VAvisAdresse> avisAdresse) {
		this.avisAdresse = avisAdresse;
	}

	public List<TDaoAffectation> getListeDaoChargeValid() {
		return listeDaoChargeValid;
	}

	public void setListeDaoChargeValid(List<TDaoAffectation> listeDaoChargeValid) {
		this.listeDaoChargeValid = listeDaoChargeValid;
	}

	public List<TDacSpecs> getListeTabDaoDiff() {
		return listeTabDaoDiff;
	}

	public void setListeTabDaoDiff(List<TDacSpecs> listeTabDaoDiff) {
		this.listeTabDaoDiff = listeTabDaoDiff;
	}

	public List<TDacSpecs> getListeDaoDiff() {
		return listeDaoDiff;
	}

	public void setListeDaoDiff(List<TDacSpecs> listeDaoDiff) {
		this.listeDaoDiff = listeDaoDiff;
	}

	public boolean isPanelBailleurFichier() {
		return panelBailleurFichier;
	}

	public void setPanelBailleurFichier(boolean panelBailleurFichier) {
		this.panelBailleurFichier = panelBailleurFichier;
	}

	public String getNatPiece() {
		return natPiece;
	}

	public void setNatPiece(String natPiece) {
		this.natPiece = natPiece;
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

	public boolean isOuvTechnique() {
		return ouvTechnique;
	}

	public void setOuvTechnique(boolean ouvTechnique) {
		this.ouvTechnique = ouvTechnique;
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

	public boolean isBtn_affecter() {
		return btn_affecter;
	}

	public void setBtn_affecter(boolean btn_affecter) {
		this.btn_affecter = btn_affecter;
	}

	public long getMontantRetrait() {
		return montantRetrait;
	}

	public void setMontantRetrait(long montantRetrait) {
		this.montantRetrait = montantRetrait;
	}

	public List<VUpdateDac> getListeDac() {
		return listeDac;
	}

	public void setListeDac(List<VUpdateDac> listeDac) {
		this.listeDac = listeDac;
	}

	public VUpdateDac getUpdateDac() {
		return updateDac;
	}

	public void setUpdateDac(VUpdateDac updateDac) {
		this.updateDac = updateDac;
	}

	public List<VPieceDac> getListePiecesDao() {
		return listePiecesDao;
	}

	public void setListePiecesDao(List<VPieceDac> listePiecesDao) {
		this.listePiecesDao = listePiecesDao;
	}
	

}
