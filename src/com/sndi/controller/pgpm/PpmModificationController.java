package com.sndi.controller.pgpm;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
//import java.sql.Date;
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
import com.sndi.model.TAvisAppelOffre;
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
import com.sndi.model.VAmiDp;
import com.sndi.model.VDatePub;
import com.sndi.model.VDetPlaning;
import com.sndi.model.VDetTabBordPgpm;
import com.sndi.model.VDetTabBordPpm;
import com.sndi.model.VExistbailleurPpm;
import com.sndi.model.VFinancementPgpm;
import com.sndi.model.VFinancementPpm;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VGenerationDate;
import com.sndi.model.VLigneImputation;
import com.sndi.model.VModePassation;
import com.sndi.model.VModePassationPn;
import com.sndi.model.VModeleAmi;
import com.sndi.model.VModeleDac;
import com.sndi.model.VModeleDao;
import com.sndi.model.VModelePrq;
import com.sndi.model.VPgpmFonction;
import com.sndi.model.VPgpmliste;
import com.sndi.model.VPpmPub;
import com.sndi.model.VPpmStatut;
import com.sndi.model.VPpmliste;
import com.sndi.model.VPrqAo;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.model.VTypeStructConduc;
import com.sndi.model.VUpdateFinancementPpm;
import com.sndi.model.VUpdatePpm;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
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
	 
	 @Autowired
	 ConstantService constantService;


	 
	
	 @PostConstruct
	 public void postContr() {
		 controleController.fonctionaliteDynamic();
		 chargeGestions();
		 chargeTypeStrucConduc();
		 chargeFinancement();
		 chargeBailleur();
		 chargeDevise();
		 chargeModePassation();
		 chargeTypeProcedures(); 
		 chargeFonctionDmp();
		 chargeDatepub();
	 }
	
	 
	     //D�claration des Listes
	     private List<VAmiDp> listeAmiDp = new ArrayList<VAmiDp>();
	     private List<VPrqAo> listePrqDp = new ArrayList<VPrqAo>();
		 private List<TDetailPlanPassation> listeTsPpm = new ArrayList<TDetailPlanPassation>();
		 private List<VDetPlaning> affichPpm = new ArrayList<VDetPlaning>();
	     private List<VPpmliste> listePpm = new ArrayList<VPpmliste>();
	     private List<VPpmliste> listePpmTrans = new ArrayList<VPpmliste>(); 
	     private List<VPpmliste> listePpmDiff = new ArrayList<VPpmliste>(); 
	     private List<VPpmliste> listePspmDiff = new ArrayList<VPpmliste>();
	     private List<VPpmliste> listeCpDiff = new ArrayList<VPpmliste>(); 
	     private List<VPpmliste> listeCpDiffPs = new ArrayList<VPpmliste>(); 
	     private List<VPpmliste> listeDiffDmpCp = new ArrayList<VPpmliste>();
	     private List<VPpmliste> listePsDiffDmpCp = new ArrayList<VPpmliste>();
	     private List<VPpmliste> listePspm = new ArrayList<VPpmliste>();
	     private List<VPpmliste> publicationListe = new ArrayList<VPpmliste>();
	     private List<THistoPlanPassation> listeHisto = new ArrayList<THistoPlanPassation>();
	     private List<VPgpmFonction> listePgpm = new ArrayList<VPgpmFonction>();
	     private List<VPgpmFonction> listePgspm = new ArrayList<VPgpmFonction>();
	     private List<TFinancementPpm> listeFinancement = new ArrayList<TFinancementPpm>();
	     private List<VFinancementPpm> listeFinancementAmi = new ArrayList<VFinancementPpm>();
	     private List<VFinancementPpm> listeFinancementPrq = new ArrayList<VFinancementPpm>();
	     //private List<TFinancementPgpm> listeFinancementPgpm = new ArrayList<TFinancementPgpm>();
	     private List<VFinancementPgpm> listeFinancementPgpm = new ArrayList<VFinancementPgpm>();
	     private List<TMinistere> listeMinistere = new ArrayList<TMinistere>();
		 private List<TStructure> listeStructure = new ArrayList<TStructure>();
		 private List<VModePassation> listeMode = new ArrayList<VModePassation>();
	     private List<VModeleDao> listeDao = new ArrayList<VModeleDao>();
	     private List<VModeleAmi> listeAmi = new ArrayList<VModeleAmi>();
	     private List<VModelePrq> listePrq = new ArrayList<VModelePrq>(); 
	     private List<VDatePub> listeDatePub = new ArrayList<VDatePub>();
	     private List<VUpdateFinancementPpm> listeupdatefinance = new ArrayList<VUpdateFinancementPpm>();
	     private List<VExistbailleurPpm> listeExisteBailleur = new ArrayList<VExistbailleurPpm>();
	    
	     
	     private List<VTypeStructConduc> listeTypStruConduc = new ArrayList<VTypeStructConduc>();
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
		 private List<VPpmliste>listSelectionTransmission =new ArrayList<VPpmliste>();
		 private List<VModePassationPn> listeModePassationPn = new ArrayList<VModePassationPn>();
		 private TModePassation recupModePassation = new TModePassation();
		 private List <VPpmStatut> ppmstatutList = new ArrayList<VPpmStatut>();
	     private List<TPlanPassation> listPlan = new ArrayList<TPlanPassation>();
	     private List<VUpdatePpm> listUpdate = new ArrayList<VUpdatePpm>();
	     private List<VTypeMarcheFils> listeTypeMarchesFils = new ArrayList<VTypeMarcheFils>();
	     private List<VTypeMarcheFils> listeTypeMarchesFilsPs = new ArrayList<VTypeMarcheFils>();
	     private List<VModeleDac> listeModele = new ArrayList<VModeleDac>();
	     private List<VPpmPub> ppmPub = new ArrayList<VPpmPub>();
	     private List<VDetTabBordPpm> detailTB = new ArrayList<VDetTabBordPpm>();
	     
		//Declaration des objets
		 private TPlanPassation planPass = new TPlanPassation();
		 private TDetailPlanPassation detailPass = new TDetailPlanPassation();
		 private TDetailPlanPassation detPass = new TDetailPlanPassation();
		 private VPgpmFonction pgpm = new VPgpmFonction();
		 private VPgpmFonction pgspm = new VPgpmFonction();
		 private TDetailPlanPassation ppm = new TDetailPlanPassation();
		 private TDetailPlanPassation recuPpm = new TDetailPlanPassation();
		 //private TDetailPlanPassation datePpm = new TDetailPlanPassation();
		 private VDetPlaning datePpm = new VDetPlaning();
		 private VPgpmFonction recupPgpm = new VPgpmFonction();
		 private VPgpmFonction recupPgspm = new VPgpmFonction();
		 private VAmiDp recupAmiDp = new VAmiDp();
		 private VPrqAo recupPrqDp = new VPrqAo();
		 private VAmiDp amiDp = new VAmiDp();
		 private VPrqAo prqDp = new VPrqAo();
		 private TDetailPlanPassation passDetail = new TDetailPlanPassation();
		 private VPpmliste slctdTdPpm = new VPpmliste();
		 private TMinistere ministere= new TMinistere();
		 private TMinistere recupMinistere= new TMinistere();
		 private TFonction recupFonction= new TFonction();
		 private VTypeMarcheFils marche = new VTypeMarcheFils();
		 private VModePassation recupModeListe = new VModePassation();
		 private VModePassation passationListe = new VModePassation();
		 private VGenerationDate geneDate = new VGenerationDate();
		 //private TTypeMarche reucpMarche = new TTypeMarche();
		 private VTypeMarcheFils reucpMarche = new VTypeMarcheFils();
		 private VLigneImputation ligne = new VLigneImputation();
		 private VLigneImputation recupLigne = new VLigneImputation();
		 private TFinancementPpm newFinancement = new TFinancementPpm();
		 private TFinancementPpm selectFinance = new TFinancementPpm();
		 //private TFinancementPgpm fipPgpm = new TFinancementPgpm();
		 private VFinancementPgpm fipPgpm = new VFinancementPgpm();
		 private VPpmliste slctdTd = new VPpmliste();
		 //private TModePassation modePassation = new TModePassation();
		 private VModePassationPn modePassation = new VModePassationPn();
		 private VPpmStatut ppmstatut= new VPpmStatut();
		 private VDatePub pubDate = new VDatePub();
		 private VFonctionMinistere fonction =new VFonctionMinistere();
		 private TStructure structure =new TStructure();
		 private TStructure newStr =new TStructure();
		 private TStructure recupstructure =new TStructure();
		 private VUpdateFinancementPpm updatefinance =new VUpdateFinancementPpm();
		 private TCharge charge =new TCharge();
		 private TDetailPlanPassation recupPass = new TDetailPlanPassation();
		 private TDetailPlanPassation passation = new TDetailPlanPassation();
		 private TStructure recupStructure= new TStructure();
		 private THistoPlanPassation histoPpm = new THistoPlanPassation();
		 private VUpdatePpm updatePpm = new VUpdatePpm();
		 private VModeleDac modelDac = new VModeleDac();
		
	 
		//Declaration des variables
		 private long gesCode;	
		 private long  totalLigne;
		 private long  totalMontant;
		 private long  totalMontantPpm;
		 //private long  nbreOuv;
		 private String  nbreOuv;
		 private String  finLib ="DU PGPM";
		 private String filtreTypeMarche="";
		 private String filtreModePassation="";
		 private String observation="";
		 private String natPiece ="";
		 private String typProce ="";
		 //private String tydCode ="";
		 private String tydCode;
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
		 private String statutRetour="";
		 private String statutPub="";
		 private String typCharge ="";
		 private String filtreLigne ="";
		 private String filtreStructure ="";
		 private String filtrePgpm ="";
		 private String filtrePpm ="";
		 private String nbrePpm ="";
		 private String nbrePspm ="";
		 private String filtrePgspm ="";
		 private String multiFiltre ="";
		 private String strucCond = "";
		 private String mode = "";
		 private String sourfin;
		 private long pgmp = 0;
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
		 private boolean modelePrq =false;
		 public boolean selectBailleur=false;
		 public boolean selectTresor =false;
		 public boolean selectPartBai =false;
	     public boolean panelFinPgpm = false;
	     public boolean panelFinPpm = true;
	     public boolean partPpm = false;
	     public boolean partPgpm = false;
	     public boolean partPspm = false;
	     public boolean partPgspm = false;
	     //public boolean lignedefaut= true;
	     public boolean ligneftpgpm= false;
	     public boolean lignepn= false;
	     public boolean ligneps= false;
	     public boolean pavetPPM= true;
	     public boolean pavetAMI= false;
	     public boolean pavetPRQ= false;
	     public boolean pavetDPAMI= false;
	     public boolean pavetDPPRQ= false;
	     public boolean pavetPSC= false;
	     public boolean libelleDPAMI= false;
	     public boolean libelleDPPRQ= false;
	     public boolean libelleAmi= false;
	     public boolean libellePrq= false;
	     public boolean libellePpm= false;
	     public boolean libellePsc= false;
	     public boolean libellePsl= false;
	     public boolean libellePsl1= false;
	     public boolean finPgpm = true;
	     public boolean finAmi = false;
	     public boolean finPrq = false;
	     public boolean panelBailleur = false;
	     public boolean panelAno = false;
	     public boolean panelAnoTech = false;
	     public boolean panelPgpmNormal = true;
	     public boolean panelPgpmDp = false;
	     public boolean panelTymNormal = true;
	     public boolean panelTymDp = false;
	     public boolean pavetFinancement= false;
	     public boolean pscOui = true;
	     public boolean pscNon = true;
	     public boolean daotype = false;
	     public boolean daotypeMAJ = false;
	     
		 public String onFlowProcess(FlowEvent event) throws IOException {
			 System.out.println("etape old= "+event.getOldStep()+" New= "+event.getNewStep());
				//Controle Pav� cr�ation pour les ppm / pspm normaux
				 if(event.getOldStep().equals("ope111") && event.getNewStep().equals("ope222")) {
		  			 if(updatePpm.getDppStructureConduc() == null || updatePpm.getDppStructureBenefi() == null || updatePpm.getDppObjet() == null || updatePpm.getDppNatInt() == null
		  					|| updatePpm.getDppStatutAno() == null || updatePpm.getLbgCode() == null || updatePpm.getDppNbOuv() == 0)
		  			   {
						 FacesContext.getCurrentInstance().addMessage(null,
						 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez remplir tous les champs obligatoires, avant de cliquer sur suivant!", ""));
				          return "ope111";
						} 
		  			            anoExiste();
		 	  	                anoTechExiste();
		  			            modifierDetailPlan();
		                        controlPanel();
		                        
				     }
				 
				 
				//Controle Pav� cr�ation pour les AMI
				 if(event.getOldStep().equals("ope111") && event.getNewStep().equals("ope223")) {
					 
		  			 if(updatePpm.getDppStructureConduc() == null || updatePpm.getDppStructureBenefi() == null || updatePpm.getDppObjet() == null || updatePpm.getDppNatInt() == null
		  					|| updatePpm.getDppStatutAno() == null || updatePpm.getLbgCode() == null || updatePpm.getDppNbOuv() == 0)
			  		  {
							 FacesContext.getCurrentInstance().addMessage(null,
							 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez remplir tous les champs obligatoires, avant de cliquer sur suivant!", ""));
					          return "ope111";
					   } else
					   {
						   anoExiste();
				 	  	   anoTechExiste();
						   modifierDetailPlan();
	                       controlPanelPs();
	                       recupModeleDao();
						   //Methode update
						  /* if(controleController.type == "PPM") {
								
			                	
			                 }else 
			                      if(controleController.type == "PSPM"){
			                  
			                 }   */
					   }
		  			 
		                
				     }
				 //Fin de Contr�le pour les AMI
				 
				//Controle Pav� Dates Pr�visionnelles pour les PPM
				 if(event.getOldStep().equals("ope222") && event.getNewStep().equals("Financements")) { 
					 
		  			 if(updatePpm.getMdtCode() == null)
			  		  {
							 FacesContext.getCurrentInstance().addMessage(null,
							 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez choisir le Type de Dossier!", ""));
					          return "ope222";
					   } else
					   {
						   updatePieces(); 
					   }
				     }
				 //Fin de Contr�le pour les PPM
				 
				 
				//Controle Pav� Dates Pr�visionnelles pour les AMI
				 if(event.getOldStep().equals("ope223") && event.getNewStep().equals("Financements")) { 
					 
		  			 if(updatePpm.getMdtCode() == null)
			  		  {
							 FacesContext.getCurrentInstance().addMessage(null,
							 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez choisir le type de Dossier!", ""));
					          return "ope223";
					   } else
					   {
						   updatePieces();
					   }
				     }
				 //Fin de Contr�le pour les AMI
				 
				//Controle Pav� Dates Pr�visionnelles pour les PRQ
				 if(event.getOldStep().equals("ope224") && event.getNewStep().equals("Financements")) { 
					 
		  			 if(updatePpm.getMdtCode() == null)
			  		  {
							 FacesContext.getCurrentInstance().addMessage(null,
							 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez choisir le Type de Dossier!", ""));
					          return "ope224";
					   } else
					   {
						   updatePieces(); 
					   }
				     }
				 //Fin de Contr�le pour les PRQ
				 
				 
				//Controle Pav� Dates Pr�visionnelles pour les DPAMI
				 if(event.getOldStep().equals("dpami") && event.getNewStep().equals("Financements")) { 
					 
		  			 if(updatePpm.getMdtCode() == null)
			  		  {
							 FacesContext.getCurrentInstance().addMessage(null,
							 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez choisir le type de Dossier!", ""));
					          return "dpami";
					   } else
					   {
						   updatePieces();
					   }
				     }
				 //Fin de Contr�le pour les DPAMI
				 
				//Controle Pav� Dates Pr�visionnelles pour les DPPRQ
				 if(event.getOldStep().equals("dpPrq") && event.getNewStep().equals("Financements")) { 
					 
		  			 if(updatePpm.getMdtCode() == null)
			  		  {
							 FacesContext.getCurrentInstance().addMessage(null,
							 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez choisir le type de Dossier!", ""));
					          return "dpPrq";
					   } else
					   {
						   updatePieces();
					   }
				     }
				 //Fin de Contr�le pour les DPPRQ
				 
				 			 
					//Controle Pav� cr�ation pour les PSC
				 if(event.getOldStep().equals("ope111") && event.getNewStep().equals("psc")) {
					 
		  			 if(updatePpm.getDppStructureConduc() == null || updatePpm.getDppStructureBenefi() == null || updatePpm.getDppObjet() == null || updatePpm.getLbgCode() == null || updatePpm.getDppNbOuv() == 0)
		  			   {
						 FacesContext.getCurrentInstance().addMessage(null,
						 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez remplir tous les champs obligatoires, avant de cliquer sur suivant!", ""));
				          return "ope111";
						} 
		  			 
		  			         anoExiste();
		 	  	             anoTechExiste();
		  			          modifierDetailPlan();
		                    	  
		                     //recupModeleDao();
		                      controlPanelPs();
				     }
				 //Fin de Contr�le pour les PSC
				 
				 
				 
				//Controle Pav� cr�ation pour les DPAMI
				 if(event.getOldStep().equals("ope111") && event.getNewStep().equals("dpami")) {
					 
		  			 if(updatePpm.getDppStructureConduc() == null || updatePpm.getDppStructureBenefi() == null || updatePpm.getDppObjet() == null || updatePpm.getDppNatInt() == null
		  					|| updatePpm.getDppStatutAno() == null
		  				   || updatePpm.getLbgCode() == null || updatePpm.getDppNbOuv() == 0)
		  			   {
		  				
						 FacesContext.getCurrentInstance().addMessage(null,
						 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez remplir tous les champs obligatoires, avant de cliquer sur suivant!", ""));
				          return "ope111";
						} 
		  			      anoExiste();
			 	  	      anoTechExiste();
		  			     modifierDetailPlan();
		  			     controlPanel();
		                    	
				     }
				 //Fin de Contr�le pour les DPAMI
				 
				 
				//Controle Pav� cr�ation pour les PRQ
				 if(event.getOldStep().equals("ope111") && event.getNewStep().equals("ope224")) {
		  			 if(updatePpm.getDppStructureConduc() == null || updatePpm.getDppStructureBenefi() == null || updatePpm.getDppObjet() == null || updatePpm.getDppNatInt() == null
		  					|| updatePpm.getDppStatutAno() == null || updatePpm.getLbgCode() == null || updatePpm.getDppNbOuv() == 0)
		  			   {
						 FacesContext.getCurrentInstance().addMessage(null,
						 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez remplir tous les champs obligatoires, avant de cliquer sur suivant!", ""));
				          return "ope111";
						} 
		  			 
		  			     anoExiste();
		 	  	         anoTechExiste();
		  			     modifierDetailPlan();
		                 controlPanel();
		                 
				     }
				//Fin Controle Pav� cr�ation pour les PRQ
				 
				//Controle Pav� cr�ation pour les DPPRQ
				 if(event.getOldStep().equals("ope111") && event.getNewStep().equals("dpPrq")) {
		  			 if(updatePpm.getDppStructureConduc() == null || updatePpm.getDppStructureBenefi() == null || updatePpm.getDppObjet() == null || updatePpm.getDppNatInt() == null
		  					|| updatePpm.getDppStatutAno() == null 
		  				   || updatePpm.getLbgCode() == null || updatePpm.getDppNbOuv() == 0)
		  			   {
						 FacesContext.getCurrentInstance().addMessage(null,
						 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veullez remplir tous les champs obligatoires, avant de cliquer sur suivant!", ""));
				          return "ope111";
						} 
		  			 
		  			    anoExiste();
		 	  	        anoTechExiste();
		                controlPanel();
		               
				     }
				 recupModeleDao();
			            return event.getNewStep();
		    }
		 
		 //Fin de la Methode OnFlow
		 
		 //Afficher les Pgspm 
		 public void chargePgspm() {
			 listePgspm.clear();
			 listePgspm = (List<VPgpmFonction>)iservice.getObjectsByColumn("VPgpmFonction",new ArrayList<String>(Arrays.asList("GPG_ID")),
					 new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					 new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
					 new WhereClause("PLG_FON_COD",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));		 		 
		 }
		 
		 
		 //liste des dates de publication
		 public void chargeDatepub() {
			 //listeDatePub=new ArrayList<>(constantService.getListeDatePub()); 
			 listeDatePub.clear();
			 listeDatePub= ((List<VDatePub>)iservice.getObjectsByColumn("VDatePub",new ArrayList<String>(Arrays.asList("DATEPUB"))));
		 }
		  
		
		 public void modifierDetailPlan() throws IOException{
				 List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
			   				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
				     TDetailPlanPassation detail = new TDetailPlanPassation();
							if(!PLG.isEmpty()) detail =PLG.get(0); 
				             //detail.setTDetailPlanGeneral(new TDetailPlanGeneral(updatePpm.getDppGpgId()));
							 detail.setDppGpgId(updatePpm.getDppGpgId());
				             if(marche.getTymCode() == null) {
				             detail.setTTypeMarche(new TTypeMarche(updatePpm.getDppTymCode()));	 
				             }else {
				             detail.setTTypeMarche(new TTypeMarche(marche.getTymCode()));	 
				             }
				             if(modePassation.getMopCode() == null) {
				             detail.setTModePassation(new TModePassation(updatePpm.getDppMopCode()));	 
				             }else {
				             detail.setTModePassation(new TModePassation(modePassation.getMopCode()));	 	 
				             }
				             detail.setTLBudgets(new TLBudgets(updatePpm.getLbgCode()));
				             //detail.setTModeleDacType(new TModeleDacType(updatePpm.getMdtCode()));
				             detail.setDppStructureConduc(updatePpm.getDppStructureConduc());
				             detail.setDppNatInt(updatePpm.getDppNatInt());
				             detail.setDppTypeStrConduc(updatePpm.getDppTypeStrConduc());
				             detail.setDppStatutAno(updatePpm.getDppStatutAno());
				             detail.setDppStructureBenefi(updatePpm.getDppStructureBenefi());
				             detail.setDppObjet(updatePpm.getDppObjet());
				             detail.setDppPartiePmePmi(updatePpm.getDppPartiePmePmi());
				             detail.setDppBailleur(updatePpm.getDppBailleur());
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
				             detail.setDppDateNotAtt(updatePpm.getDppDateNotAtt());
				             detail.setDppNbOuv(updatePpm.getDppNbOuv());
				             recupDateGenere();
				             iservice.updateObject(detail);
				             chargeExisteBailleur();
				             userController.setTexteMsg(" Modification effectu�e avec succ�s !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
							 
			 }
		//Methode de r�cup�ration de l'AMI de la DP
		 public void recupPpm(long dppId) {
			 List<TDetailPlanPassation> PPM  = iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",Comparateur.EQ,""+dppId));
				if(!PPM.isEmpty()) detailPass = PPM.get(0);
				
				finLib = "DE l'AMI";
				 finPgpm = false;
			     finAmi = true;
			     panelPgpmNormal = false;
			     panelPgpmDp = true;
				
				listeFinancementAmi.clear();
				 listeFinancementAmi = ((List<VFinancementPpm>)iservice.getObjectsByColumn("VFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
							 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+dppId)));
		      }
		 
		 //Debut controle bailleur
		 public void bailleurExiste() {
			if(updatePpm.getDppBailleur().equalsIgnoreCase("B")) {
				panelBailleur = true;
				
			}else
			{
				panelBailleur = false;	
			}
			_logger.info("bailleur: "+detailPass.getDppBailleur());
			_logger.info("panelBailleur: "+panelBailleur);
		 }
		//Fin controle bailleur
		 
		//Debut controle ANO
		 public void anoExiste() {
			if(updatePpm.getDppStatutAno().equalsIgnoreCase("O")) {
				panelAno = true;
				
			}else
			{
				panelAno = false;	
			}
			_logger.info("ANO: "+updatePpm.getDppStatutAno());
			_logger.info("panelAno: "+panelAno);
		 }
		//Fin controle ANO
		 
		//Debut controle ANO Technique
		 public void anoTechExiste() {
			if(updatePpm.getDppStatutAno().equalsIgnoreCase("O") && updatePpm.getDppNbOuv() == 2 ) {
				panelAnoTech = true;     
				
			}else
			{
				panelAnoTech = false;	
			}
			_logger.info("ANO: "+detailPass.getDppStatutAno());
			_logger.info("ouverture: "+detailPass.getDppNbOuv());
		 }
		//Fin controle ANO
		 
		 public void updateBailleurExiste() {
			 List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation",
		   				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
			     TDetailPlanPassation detail = new TDetailPlanPassation();
						if(!PLG.isEmpty()) detail =PLG.get(0);
						detail.setDppBailleur(updatePpm.getDppBailleur());
		  iservice.updateObject(detail);	 
		  recupModeleDao();
		  bailleurExiste();
		 }
		 
		 public void controleLibelle() {
			 if(mode=="AMI") {
				 libelleDPPRQ= false;
				 libelleDPAMI= false;
			     libelleAmi= true;
			     libellePrq= false;
			     libellePpm= false;
			     libellePsc= false;
			 }else
				 if(mode=="PRQ") {
					 libelleDPPRQ= false;
					 libelleDPAMI= false;
				     libelleAmi= false;
				     libellePrq= true;
				     libellePpm= false;
				     libellePsc= false;
				 }else
					 if(mode=="DPPRQ") {
						 libelleDPPRQ= false;
						 libelleDPAMI= false;
					     libelleAmi= false;
					     libellePrq= true;
					     libellePpm= false; 
					     libellePsc= false;
					 }else
						 if(mode=="DPAMI") {
							 libelleDPPRQ= false;
							 libelleDPAMI= true;
						     libelleAmi= false;
						     libellePrq= false;
						     libellePpm= false; 
						     libellePsc= false;
						 }else
							 if(mode=="PSC") {
								 libelleDPPRQ= false;
								 libelleDPAMI= false;
							     libelleAmi= false;
							     libellePrq= false;
							     libellePpm= false; 
							     libellePsc= true;
							 }else
						       {
								 libelleDPPRQ= false;
								 libelleDPAMI= false;
							     libelleAmi= false;
							     libellePrq= false;
							     libellePpm= true; 
							     libellePsc= false;
							 }
			               
			 
		 }

	 
	 public void chargeExisteBailleur() { 
		 listeExisteBailleur.clear(); 
		 listeExisteBailleur =(List<VExistbailleurPpm>) iservice.getObjectsByColumn("VExistbailleurPpm",
				 new WhereClause("TYPEM",Comparateur.EQ,""+updatePpm.getDppTymCode()),
				 new WhereClause("MODEP",WhereClause.Comparateur.EQ,""+updatePpm.getDppMopCode()));
				     _logger.info("liste existeBailleur: "+listeExisteBailleur.size());	 
	 }
	 
	 
	
	 //MAJ du DAO-TYpe
	 public void updatePieces() { 
		      if(tydCode.equalsIgnoreCase("")) {
		    	  listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
							new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
					    if (!listeTsPpm.isEmpty()) {
						       detPass= listeTsPpm.get(0);
						       detPass.setTModeleDacType(new TModeleDacType(updatePpm.getMdtCode()));
						       iservice.updateObject(detPass);
						       recupModeleDao();
					      }

		      }else {

		    	  listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
							new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
					    if (!listeTsPpm.isEmpty()) {
						       detPass= listeTsPpm.get(0);
						       detPass.setTModeleDacType(new TModeleDacType(tydCode));
						       iservice.updateObject(detPass);
						       recupModeleDao();
					      }
		        }
	
			}

 
		//Methode de validation des PPM
		 public void chargeData(String typePlan) {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 listePpm.clear();
				 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_ID")), 
						"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SPR")),
						new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
						new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					_logger.info("listePpm size: "+listePpm.size());
					_logger.info("type plan: "+typePlan);
					//Actualisation du Tableau de Bord
					 if(controleController.type == "PPM") {
							tableauBordController.chargeDataPpm("PN");
	                }else 
	                     if(controleController.type == "PSPM"){
	                    	 tableauBordController.chargeDataPpm("PS");
	                }
					//Affichage du nombre de ppm saisis
					//nbrePpm =""+getNbrePpmTotal();
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 listePpm.clear();
					 listePpm= (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
								"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
								new WhereClause("LBG_FON_CODE_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
							_logger.info("listePpm size: "+listePpm.size());	
							//Actualisation du Tableau de Bord
							//tableauBordController.chargeDataPpm();
							 if(controleController.type == "PPM") {
									tableauBordController.chargeDataPpm("PN");
			                }else 
			                     if(controleController.type == "PSPM"){
			                    	 tableauBordController.chargeDataPpm("PS");
			                }
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 listePpm.clear();
						 listePpm = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
								"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPT")),
								new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
								//new WhereClause("LBG_FON_CODE_VAL",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
								_logger.info("listePpm size: "+listePpm.size());
								//Actualisation du Tableau de Bord
								//tableauBordController.chargeDataPpm();
								 if(controleController.type == "PPM") {
										tableauBordController.chargeDataPpm("PN");
				                }else 
				                     if(controleController.type == "PSPM"){
				                    	 tableauBordController.chargeDataPpm("PS");
				                }
					 }else
						  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							  listePpm.clear();
							  listePpm = (List<VPpmliste>) iservice.getObjectsByColumnInDesc("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
								"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPT")),
								new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
								//new WhereClause("LBG_FON_CODE_VAL",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
								_logger.info("listePpm size: "+listePpm.size());
								//Actualisation du Tableau de Bord
								//tableauBordController.chargeDataPpm(); 
								 if(controleController.type == "PPM") {
										tableauBordController.chargeDataPpm("PN");
				                }else 
				                     if(controleController.type == "PSPM"){
				                    	 tableauBordController.chargeDataPpm("PS");
				                }
				     }
			     } 
			   }
			 }
		 //Fin Nouvelle Methode d'affichage des PPM
		 

	 

	 //Fin de la Methode de Publication des PPM d�j� publi�s
	 

	  	 
		//Filtre multicrit�re pour les PPM : Nouvelle Methode
		
			
			
	
			 //Methode d'enregistrement des financements du ppm
			 public void saveFinancementppm() {
				 
				 if(souCode == null  || sourfin == null || devCode == null ) {
				        //Message d'erreur
			    		  FacesContext.getCurrentInstance().addMessage(null,
				          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez, renseigner tous les champs obligatoires", ""));
	            	    }else {
	            	    	  if(sourfin.equalsIgnoreCase("ETAT")) {
	            					 baiCode ="ETAT";
	            		     	     newFinancement.setTBailleur(new TBailleur(baiCode)); 
	            		          }else
	            		     	  {
	            		         	newFinancement.setTBailleur(new TBailleur(baiCode));  
	            		     	  }
	            					newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
	            				    newFinancement.setTDevise(new TDevise(devCode));
	            				    newFinancement.setFppTypeFinance(sourfin);
	            				    newFinancement.setTDetailPlanPassation(new TDetailPlanPassation(updatePpm.getDppId()));
	            					iservice.addObject(newFinancement);
	            					//Actualisation du co�t pr�visionnel de l'op�ration
	            					coutTotal();
	            					
	            					listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
	    									new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
	            					if (!listeTsPpm.isEmpty()) {
	            						detPass= listeTsPpm.get(0);
	            						detPass.setDppSourceFin(newFinancement.getFppTypeFinance());
	            						detPass.setDppMontant(totalMontantPpm);
	            						iservice.updateObject(detPass);
	            					}
	            					
	            					viderFinancement();
	            					
	            					chargeFinancement();
	            					userController.setTexteMsg("Enregistrement �ffectu� avec succ�s!");
	            					userController.setRenderMsg(true);
	            					userController.setSevrityMsg("success");
	            	    }
			 }
			 //Fin de la saisie d'un financement ppm
			 
			 //Methode de suppression de finanacemnt
			 public void deleteFinanacement() {
				iservice.deleteObject(selectFinance); 
				chargeFinancement();
				userController.setTexteMsg("Suppression �ffectu�e avec succ�s!");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");
			 }
			 
			 //Editer
			 public void editFinancement() {
				 listeupdatefinance= (List<VUpdateFinancementPpm>) iservice.getObjectsByColumn("VUpdateFinancementPpm", new ArrayList<String>(Arrays.asList("FPP_ID")),
						 new WhereClause("FPP_ID",WhereClause.Comparateur.EQ,""+selectFinance.getFppId()));
				if (!listeupdatefinance.isEmpty()) {
					updatefinance=listeupdatefinance.get(0); 
				}	 
			 }
			 
			 
			 //Update le financement
			 public void updateFinancement() {
				 selectFinance.setFppTypeFinance(updatefinance.getFppTypeFinance());
				 selectFinance.setTBailleur(new TBailleur(updatefinance.getFppBaiCode()));
				 selectFinance.setTSourceFinancement(new TSourceFinancement(updatefinance.getFppSouCode())); 
				 selectFinance.setTDevise(new TDevise(updatefinance.getFppDevCode()));
				 selectFinance.setFppMontantCfa(updatefinance.getFppMontantCfa());   
				 selectFinance.setFppMontantDevise(updatefinance.getFppMontantDevise());  
				 selectFinance.setFppPartTresor(updatefinance.getFppPartTresor());
				 iservice.updateObject(selectFinance);
				 //Chargement du montant du total
				 coutTotal();
				 //Actualisation du montant pr�visionnel
				 /*listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
							new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatefinance.getDppId()));
					if (!listeTsPpm.isEmpty()) {
						detPass= listeTsPpm.get(0);
						detPass.setDppSourceFin(newFinancement.getFppTypeFinance());
						detPass.setDppMontant(totalMontantPpm);
						iservice.updateObject(detPass);
					}*/
				 //Confirmation
				 userController.setTexteMsg("Modification �ffectu�e avec succ�s!");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
			 }
			
		
			 
			 //@Transactional
			 public void addFinancement() throws IOException {
				 
					//if(fipPgpm.getFipId() > 0 ) {
				  		    	listPlan = (List<TPlanPassation>) iservice.getObjectsByColumn("TPlanPassation", new ArrayList<String>(Arrays.asList("PLP_ID")),
				 	 			       new WhereClause("PLP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
				 	 			       new WhereClause("PLP_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
				 					   new WhereClause("PLP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				 	 	  if (!listPlan.isEmpty()) {
				 	 		  planPass= listPlan.get(0);
				 	 		  
				 	 		  if(detailPass.getDppId()>0) {
				 	 			  
				 	 			//updateDetailPlan(planPass, ""+controleController.typePlan);
					 	  	   
				 	 			String search = detailPass.getDppObjet()+""+detailPass.getDppSourceFin()+""+detailPass.getDppTypePlan()+""+detailPass.getTModePassation().getMopCode()+""+detailPass.getDppStructureBenefi()+""+detailPass.getDppStructureConduc()+""+detailPass.getDppSourceFin();
								String rechercheAll = search.replace("null","");
								detailPass.setDppRecherche(rechercheAll);
								iservice.updateObject(detailPass); 	  
						      
						      	//Insertion dans T_Financement_PPM
							     saveFinancementppm();
					 		    chargeFinancement();
					 			
					 			userController.setTexteMsg("Financement enr�gistr� avec succ�s!");
					 			userController.setRenderMsg(true);
					 			userController.setSevrityMsg("success");
					 	 		    
				 	 		  }else
				 	 		  {
				 	 			//saveDetailPlan(""+controleController.typePlan);
					 	  		
				 	 			String search = detailPass.getDppObjet()+""+detailPass.getDppSourceFin()+""+detailPass.getDppTypePlan()+""+detailPass.getTModePassation().getMopCode()+""+detailPass.getDppStructureBenefi()+""+detailPass.getDppStructureConduc()+""+detailPass.getDppSourceFin();
								String rechercheAll = search.replace("null","");
								detailPass.setDppRecherche(rechercheAll);
								iservice.updateObject(detailPass);     			  
						      			  
						      			  
						      	//Insertion dans T_Financement_PPM
								saveFinancementppm();

					 	  	   //Insertion de chaque ligne dans T_HistoPlanPassation avec le statut correspondant
								historiser("S1S",detailPass,"PPM enregistr� par le AC");
					 		    chargeFinancement();
					 			
					 			userController.setTexteMsg("Op�ration(s) enregistr�e(s) avec succ�s!");
					 			userController.setRenderMsg(true);
					 			userController.setSevrityMsg("success");
					 	 		   
				 	 		  }
				 	 		
				 	 	  }else {
				 	 		     planPass.setTGestion(new TGestion(gesCode));
				 	  		     planPass.setTFonction(userController.getSlctd().getTFonction());
				 	  		     planPass.setTStructure(userController.getSlctd().getTFonction().getTStructure());
				 	  		     iservice.addObject(planPass);
				 	  		     
				 	  		      //saveDetailPlan(""+controleController.typePlan);
				 		  		 
				 		  		 
				 	  		    String search = detailPass.getDppObjet()+""+detailPass.getDppSourceFin()+""+detailPass.getDppTypePlan()+""+detailPass.getTModePassation().getMopCode()+""+detailPass.getDppStructureBenefi()+""+detailPass.getDppStructureConduc()+""+detailPass.getDppSourceFin();
								String rechercheAll = search.replace("null","");
								detailPass.setDppRecherche(rechercheAll);
								iservice.updateObject(detailPass);
								
										  
				 			    chargeFinancement();
				 				boutonEdit =true;
				 				boutonEditPspm =false;
				 				controleController.btn_creerDetailPpm =true;
				 				userController.setTexteMsg("Financement enr�gistr� avec succ�s!");
				 				userController.setRenderMsg(true);
				 				userController.setSevrityMsg("success");
				 	 	         }
				  		   // }
					coutOperation();
		  		}
		
		 
		 //Affichage dynamique des dates pr�visionnelles en proc�dure simplifi�e
		 public void checkDatePrevisionnelle() {
			 if(typProce.equalsIgnoreCase("PSO")) {
				controleController.etatPso = true;
				controleController.etatPsl = false;
	
			 }else if(typProce.equalsIgnoreCase("PSL")){
				controleController.etatPso = false;
				controleController.etatPsl = true;
			 }
		 }
		 
		 

      	
		 
		//D�but des m�thodes pour les affichages 
			//Combobox Gestions
		 public void chargeGestions(){
			 listeGestion=new ArrayList<>(constantService.getListeGestion());
		 } 
	   //Combobox Bailleur
	   public void chargeBailleur() {
		   listeBailleurs=new ArrayList<>(constantService.getListeBailleurs());
		} 
	   //Combobox type de structures conductrices
	   public void chargeTypeStrucConduc(){
		   listeTypStruConduc=new ArrayList<>(constantService.getListeTypStruConduc());
		 }
	   
	 //Combobox type Charge
	   public void chargeTypeCharges() {
		   listeTypeCharges.clear(); 
		   listeTypeCharges =(List<TTypeCharge>) iservice.getObjectsByColumn("TTypeCharge", new ArrayList<String>(Arrays.asList("tycCode")));
		} 
	   
	 //Combobox type de proc�dures
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
			 listeStructures=new ArrayList<>(constantService.getListeStructures());
		 }
		 
		  //Love pour Structure
		 public void filtreStructures() {
			 listeStructures.clear();
			 listeStructures =(List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("STR_CODE")),
					 new WhereClause("STR_CODE",WhereClause.Comparateur.LIKE,"%"+filtreStructure+"%"));		 
		 }
		 
	    //Combobox Source de finacement
		 public void chargeSourceFinance() {
			 listeSourceFinance=new ArrayList<>(constantService.getListeSourceFinance());
			}
		//Combobox Devises
		 public void chargeDevise() {
			 listeDevise=new ArrayList<>(constantService.getListeDevise());	
			} 
		 
		 
		//Chargement des imputations ou lignes budg�taires pour le AC
	    public void chargeImputation() {
		 listeImputations.clear();
		 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
				// new WhereClause("LBG_FON_CODE_PF",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCodePf()),
				// new WhereClause("LBG_GES_CODE",Comparateur.EQ,""+gesCode));
		 filtreLigne="";
		 ligneftpgpm = false;
		 lignepn = false;
		 ligneps = false;
			} 
	  
	    
	    
	    
	    public void chargeImputationPg() {
	    	if(controleController.typePlan == "PN") {
	    		 listeImputations.clear();
				 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				         new WhereClause("LBG_MOP_CODE",Comparateur.EQ,""+pgpm.getGpgTypePlan()),
						 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
				 filtreLigne="";
				 _logger.info("Taille de liste listeImputations: "+listeImputations.size());
				 _logger.info("Type de plan: "+pgpm.getGpgTypePlan());
	    	}else {
	    		if(controleController.typePlan == "PS") {
		    		 listeImputations.clear();
					 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
					         new WhereClause("LBG_MOP_CODE",Comparateur.EQ,""+pgpm.getGpgMopCode()),
							 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
					 filtreLigne="";
					 _logger.info("Taille de liste listeImputations: "+listeImputations.size());
					 _logger.info("Type de plan: "+controleController.typePlan);
					 _logger.info("LBG_MOP_CODE 1: "+pgpm.getGpgTypePlan());
					 _logger.info("LBG_MOP_CODE 2: "+pgpm.getGpgMopCode());
		    	}
	    	}
	    }
	    
	    
	    public void chargeImputationPn() {
	    		 listeImputations.clear();
				 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				         new WhereClause("LBG_MOP_CODE",Comparateur.EQ,""+modePassation.getMopTypPlan()),
						 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
				 filtreLigne="";
				 _logger.info("Taille de liste listeImputations: "+listeImputations.size());
				 _logger.info("Type de plan: "+modePassation.getMopTypPlan());
	    }
	    
	    public void chargeImputationPros() {
   		 listeImputations.clear();
			 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
			         new WhereClause("LBG_MOP_CODE",Comparateur.EQ,""+passationListe.getMopCode()),
					 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
			 filtreLigne="";
			 _logger.info("Taille de liste listeImputations: "+listeImputations.size());
			 _logger.info("Type de plan: "+modePassation.getMopTypPlan());
   }
	    

	  
	//R�initialisation sur ligne budg�taire en proc�dure simplifi�e
		public void chargeImputationPs() {
			if(pgspm.getGpgTypePlan().equalsIgnoreCase("")) {
				listeImputations.clear();
				 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				         new WhereClause("LBG_MOP_CODE",Comparateur.EQ,""+passationListe.getMopCode()),
						 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
				 filtreLigne="";
				 _logger.info("Taille de liste listeImputations: "+listeImputations.size());
				 _logger.info("Type de plan: "+passationListe.getMopTypPlan()); 
				 _logger.info("Mop_code: "+passationListe.getMopCode()); 
			}else {
				 listeImputations.clear();
				 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				         new WhereClause("LBG_MOP_CODE",Comparateur.EQ,""+pgspm.getGpgMopCode()),
						 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
				 filtreLigne="";
				 _logger.info("Taille de liste listeImputations: "+listeImputations.size());
				 _logger.info("Type de plan: "+passationListe.getMopTypPlan()); 
				 _logger.info("Mop_code: "+passationListe.getMopCode()); 
			}
			
			listeImputations.clear();
			 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
			         new WhereClause("LBG_MOP_CODE",Comparateur.EQ,""+passationListe.getMopCode()),
					 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
			 filtreLigne="";
			 _logger.info("Taille de liste listeImputations: "+listeImputations.size());
			 _logger.info("Type de plan: "+passationListe.getMopTypPlan()); 
			 _logger.info("Mop_code: "+passationListe.getMopCode()); 
		}
	  
	//Chargement des imputations ou lignes budg�taires en mode PSL pour le AC
	  public void chargeImputationPsl() {
			listeImputations.clear();
			 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
			         new WhereClause("LBG_MOP_CODE",Comparateur.EQ,""+passationListe.getMopCode()),
					 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
			 filtreLigne="";
			 _logger.info("Taille de liste listeImputations: "+listeImputations.size());
			 _logger.info("Type de plan: "+passationListe.getMopTypPlan()); 
			 _logger.info("Mop_code: "+passationListe.getMopCode()); 
			}
	  
	  
	//Chargement des imputations ou lignes budg�taires en mode PSO pour le AC
	  public void chargeImputationPso() {
			listeImputations.clear();
			 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
			         new WhereClause("LBG_MOP_CODE",Comparateur.EQ,""+passationListe.getMopCode()),
					 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));//,
			 filtreLigne="";
			 _logger.info("Taille de liste listeImputations: "+listeImputations.size());
			 _logger.info("Type de plan: "+passationListe.getMopTypPlan()); 
			 _logger.info("Mop_code: "+passationListe.getMopCode()); 
			}
	
	//Chargement des imputations ou lignes budg�taires pour CPMP et DMP
	public void chargeImputationCpmpDmp() {
		 listeImputations.clear();
		 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				 new WhereClause("LBG_GES_CODE",Comparateur.EQ,""+gesCode),
				 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,fonction.getFonCod()));
			}
	
	//Chargement des imputations pour tous les modes PN ou PS
	  public void chargementLigne(String mopCode) {
		 listeImputations.clear();
		 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumnNotQuote("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				 new WhereClause("LBG_MOP_CODE",Comparateur.BET,""+mopCode),
				 new WhereClause("LBG_GES_CODE",Comparateur.EQ,""+gesCode),
				 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,"'"+userController.getSlctd().getTFonction().getFonCod()+"'")); 
			}
	
	public void filtreImputation() {
		listeImputations.clear();
		listeImputations = (List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
				new WhereClause("LBG_GES_CODE",Comparateur.EQ,""+gesCode),
				 new WhereClause("LBG_FON_CODE_PF",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCodePf()),
				new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));
	}
	
	
	//Filtre sur ligne budg�taire en proc�dure simplifi�e
	public void filtreImputationPs() {
		
		if(pgspm.getGpgTypePlan().equalsIgnoreCase("PSO")) {
			
			 listeImputations.clear();
			 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumnNotQuote("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
					 new WhereClause("LBG_TOT_DOT",Comparateur.BET,psoInf+" AND "+psoSup),
					 new WhereClause("LBG_GES_CODE",Comparateur.EQ,""+gesCode),
					// new WhereClause("LBG_FON_CODE_PF",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCodePf()),
					 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,"'"+userController.getSlctd().getTFonction().getFonCod()+"'"),
					 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));
		  }else 
			  if(pgspm.getGpgTypePlan().equalsIgnoreCase("PSL")) {
				  
				     listeImputations.clear();
					 listeImputations =(List<VLigneImputation>) iservice.getObjectsByColumnNotQuote("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
							 new WhereClause("LBG_TOT_DOT",Comparateur.BET,pslInf+" AND "+pslSup),
							 new WhereClause("LBG_GES_CODE",Comparateur.EQ,""+gesCode),
						  // new WhereClause("LBG_FON_CODE_PF",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCodePf()),
							 new WhereClause("LBG_FON_CODE_AC",Comparateur.EQ,"'"+userController.getSlctd().getTFonction().getFonCod()+"'"),
							 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));	
			}		
	}
	
	
	
	public void filtreImputationCpmp() {
		listeImputations.clear();
		listeImputations = (List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				new WhereClause("LIAE_FON_COD",Comparateur.EQ,fonction.getFonCod()), 
				new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));
	}
		 
		//Chargement des Types de March�s
		 /*public void chargeMarches() {
			 listeTypeMarches=new ArrayList<>(constantService.getListeTypeMarches());
			}*/
		 
		 public void chargeMarches() {
			 listeTypeMarchesFils=new ArrayList<>(constantService.getListeTypeMarchesFils());
			 //filtreTypeMarche ="";
		 }	
		 
		
		 
		 public void chargetypeMarcheByModPass() {
			/* //listeTypeMarchesFils=new ArrayList<>(constantService.getListeTypeMarchesFils());
			 listeTypeMarches.clear();
			 if(recupPgpm.getGpgMopCode().equalsIgnoreCase("AMI") || recupPgpm.getGpgMopCode().equalsIgnoreCase("DPA")) {
				 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
						 new WhereClause("TYM_CODE",WhereClause.Comparateur.EQ,"11")); 
			 }else
				 if(recupPgpm.getGpgMopCode().equalsIgnoreCase("PRQ") || recupPgpm.getGpgMopCode().equalsIgnoreCase("DPQ")) {
					 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
							 new WhereClause("TYM_CODE",WhereClause.Comparateur.NEQ,"11")); 
				 }else 
				 {*/
				 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils"); 
			 //}
		 }
		 
		 public void chargetypeMarcheByModPassPs() {
			 //listeTypeMarchesFils=new ArrayList<>(constantService.getListeTypeMarchesFils());
			 listeTypeMarchesFilsPs.clear();
			 if(recupPgspm.getGpgMopCode().equalsIgnoreCase("AMS") || recupPgspm.getGpgMopCode().equalsIgnoreCase("DPS")) {
				 listeTypeMarchesFilsPs=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
						 new WhereClause("TYM_CODE",WhereClause.Comparateur.EQ,"11")); 
			 }else
				 if(recupPgspm.getGpgMopCode().equalsIgnoreCase("PQS") || recupPgspm.getGpgMopCode().equalsIgnoreCase("DQS")) {
					 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
							 new WhereClause("TYM_CODE",WhereClause.Comparateur.NEQ,"11")); 
				 }
			 else {
				 listeTypeMarchesFilsPs=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils"); 
			 }
		 }
		 
		 
		//Chargement des modes de Passtion
		 public void chargeModePassation() {
			 //listeModePassation=new ArrayList<>(constantService.getListeModePassation());
			 listeModePassationPn = new ArrayList<>(constantService.getListeModePassationPn()); 
			 filtreModePassation="";
			}
		 
		//Afficher les financements du projet ou agpm selectionn�
		 public void chargeFinancement() {
			 listeFinancement.clear();
			 listeFinancement = ((List<TFinancementPpm>)iservice.getObjectsByColumn("TFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
						 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+updatePpm.getDppId())));	
			 coutTotal();
		 }
		 
	
		 
		 //Afficher les Pgpm : Nouvelle Methode
		public void chargeRecherchePgpm() { 
			 listePgpm.clear();
			 listePgpm = (List<VPgpmFonction>)iservice.getObjectsByColumn("VPgpmFonction",new ArrayList<String>(Arrays.asList("GPG_ID")),
					 new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					 new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
					 new WhereClause("GPG_ACTEUR_SAISIE",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					 //new WhereClause("GPG_FON_COD_DMP",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCodeDmp()),
					 new WhereClause("GPG_OBJET",WhereClause.Comparateur.LIKE,"%"+filtrePgpm+"%"));		 		 
		 }
		 

		//Afficher les Pgpm : Nouvelle Methode
		public void chargePgpm() {
			 listePgpm.clear();
			 listePgpm = (List<VPgpmFonction>)iservice.getObjectsByColumn("VPgpmFonction",new ArrayList<String>(Arrays.asList("GPG_ID")),
					 new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					 new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
					 new WhereClause("GPG_ACTEUR_SAISIE",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					 //new WhereClause("GPG_FON_COD_DMP",Comparateur.EQ,userController.getSlctd().getTFonction().getFonCodeDmp()));
			 filtrePgpm="";
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
			
			
			
			
			
			public void onSelectDatePub() {
				/*listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
						new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
					if (!listeTsPpm.isEmpty()) {
						detPass = listeTsPpm.get(0);
						detPass.setDppDateAvisAoPublication(pubDate.getDatepub());
						iservice.updateObject(detPass);
				}*/
					updateDaoTrans();
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
	  	 
		 
		
		 //M�thode Love pour type des March�s
		 public void onSelectMarche() {
			 detailPass.setTTypeMarche(new TTypeMarche(marche.getTymCode()));

			 recupPgspm.setGpgTymCode(marche.getTymCode());
			 recupPgspm.setTymLibelleCourt(marche.getTymLibelleCourt());
			 recupPgpm.setGpgTymCode(marche.getTymCode());
			 recupPgpm.setTymLibelleCourt(marche.getTymLibelleCourt());
			 
			 affichNbreOuvMarche();
				}
		 
		 
		//M�thode Love pour les DP
		 public void onSelectAmiDp() {
			 finLib = "DE l'AMI";
			 finPgpm = false;
		     finAmi = true;
		     panelPgpmNormal = false;
		     panelPgpmDp = true;
		     recupPgpm.setGpgId(amiDp.getDppGpgId());
			 recupPgpm.setGpgObjet(amiDp.getGpgObjet());
			 recupPgspm.setGpgObjet(amiDp.getGpgObjet());
			 recupAmiDp.setDppId(amiDp.getDppId());
			 recupAmiDp.setDppObjet(amiDp.getDppObjet());
			 detailPass.dppStructureConduc = amiDp.getDppStructureConduc();
			 strucCond = amiDp.getDppTypeStrConduc();
			 nbreOuv = amiDp.getDppNbOuv();
			 recupLigne.setLbgCode(amiDp.getDppLbgCode());
			 recupLigne.setLbgImputation(amiDp.getLbgImputation());
			 recupLigne.setNatLibelle(amiDp.getNatLibelle());
			 recupLigne.setLbgTotDot(amiDp.getLbgTotDot());
			 recupLigne.setLbgAeTr(amiDp.getLbgAeTr());
			 recupLigne.setLbgAeEmp(amiDp.getLbgAeEmp());
			 recupLigne.setLbgAeDon(amiDp.getLbgAeDon());
			 recupLigne.setLbgDisTot(amiDp.getLbgDisTot());
			 
			 List<TDetailPlanPassation> PPM  = iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",Comparateur.EQ,""+amiDp.getDppId()));
				if(!PPM.isEmpty()) detailPass = PPM.get(0);
				
			 listeFinancementAmi.clear();
			 listeFinancementAmi = ((List<VFinancementPpm>)iservice.getObjectsByColumn("VFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
							 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+amiDp.getDppId())));
			 _logger.info("Code de la ligne : "+recupLigne.getLbgCode() +" Imuptation :  "+recupLigne.getLbgImputation());
				}
		 
		 
		 //Informations de l'AMI S�lectionn�
		 public void infosAmi() {
			 finLib = "DE l'AMI";
			 finPgpm = false;
		     finAmi = true;
			 detailPass.dppStructureBenefi = amiDp.getDppStructureBenefi();
			 detailPass.dppPartiePmePmi = amiDp.getDppPartiePmePmi();
			 detailPass.dppStructureConduc = amiDp.getDppStructureConduc();
			 strucCond = amiDp.getDppTypeStrConduc();
			 detailPass.dppStatutAno = amiDp.getDppStatutAno();
			 detailPass.dppNatInt = amiDp.getDppNatInt();
			 detailPass.dppBailleur = amiDp.getDppBailleur();
			 detailPass.dppObjet = amiDp.getDppObjet();
			 nbreOuv = amiDp.getDppNbOuv();
			 
			 listeFinancementAmi.clear();
			 listeFinancementAmi = ((List<VFinancementPpm>)iservice.getObjectsByColumn("VFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
						 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+amiDp.getDppId()))); 
		 }
		 
		 
		//M�thode Love pour les DP
		 public void onSelectPrqDp() {
	
			 finLib = "DE LA PREQUALIFICATION";
			 finPgpm = false;
		     finAmi = false;
		     finPrq = true;
		     panelPgpmNormal = false;
		     panelPgpmDp = true;
			 recupPgpm.setGpgObjet(prqDp.getGpgObjet());
			 recupPgspm.setGpgObjet(prqDp.getGpgObjet());
			 recupPrqDp.setDppId(prqDp.getDppId());
			 recupPrqDp.setDppObjet(prqDp.getDppObjet());
			 detailPass.dppStructureConduc = prqDp.getDppStructureConduc(); 
			 nbreOuv = prqDp.getDppNbOuv();
			 strucCond = prqDp.getDppTypeStrConduc();
			 recupLigne.setLbgImputation(prqDp.getLbgImputation());
			 recupLigne.setLbgCode(prqDp.getDppLbgCode());
			 recupLigne.setNatLibelle(prqDp.getNatLibelle());
			 recupLigne.setLbgTotDot(prqDp.getLbgTotDot());
			 recupLigne.setLbgAeTr(prqDp.getLbgAeTr());
			 recupLigne.setLbgAeEmp(prqDp.getLbgAeEmp());
			 recupLigne.setLbgAeDon(prqDp.getLbgAeDon());
			 recupLigne.setLbgDisTot(prqDp.getLbgDisTot());
			 
			 List<TDetailPlanPassation> PPM  = iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",Comparateur.EQ,""+prqDp.getDppId()));
				if(!PPM.isEmpty()) detailPass = PPM.get(0);
				
				 listeFinancementPrq.clear();
				 listeFinancementPrq = ((List<VFinancementPpm>)iservice.getObjectsByColumn("VFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
							 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+prqDp.getDppId()))); 
				 
				 _logger.info("Code de la ligne : "+recupLigne.getLbgCode() +" Imuptation :  "+recupLigne.getLbgImputation());
				}
		 
		 
		 //Informations de la PRQ S�lectionn�
		 public void infosPrq() {
			 finLib = "DE LA PREQUALIFICATION";
			 finPgpm = false;
		     finAmi = false;
		     finPrq = true;
			 detailPass.dppStructureBenefi = prqDp.getDppStructureBenefi();
			 detailPass.dppPartiePmePmi = prqDp.getDppPartiePmePmi();
			 detailPass.dppStructureConduc = prqDp.getDppStructureConduc();
			 strucCond = amiDp.getDppTypeStrConduc();
			 detailPass.dppStatutAno = prqDp.getDppStatutAno();
			 detailPass.dppNatInt = prqDp.getDppNatInt();
			 detailPass.dppBailleur = prqDp.getDppBailleur();
			 detailPass.dppObjet = prqDp.getDppObjet();
			 nbreOuv = prqDp.getDppNbOuv();
			 
			 listeFinancementPrq.clear();
			 listeFinancementPrq = ((List<VFinancementPpm>)iservice.getObjectsByColumn("VFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
						 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+prqDp.getDppId()))); 
		 }
		 //Afficher le nombre d'Ouvertures en choisissant le type de march�
		 public void affichNbreOuvMarche() {
			 if(marche.getTymCode().equalsIgnoreCase("11")) {
				 nbreOuv = "2";
			 }else {
				 nbreOuv = "1";
			 }
		 }
		 
		 
		 //Affichage du DAO type
		 public void controleDaoType() {
			if(updatePpm.getMdtCode() == null) {
				daotype = true;
			    daotypeMAJ = false;
				}else {
				daotype = false;
				daotypeMAJ = true;	
				}
			}
		
		 //MAJ du Dossier type si le PPM n'est pas renseign�
		 public void majPieces() {
			 listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
						new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
				    if (!listeTsPpm.isEmpty()) {
					       detPass= listeTsPpm.get(0);
					       detPass.setTModeleDacType(new TModeleDacType(tydCode));
					       iservice.updateObject(detPass);
					       recupModeleDao();
				      }
				}
		 
		//R�initialiser les Types de March�s
		 public void razchargeMarches() {
			 listeTypeMarchesFils.clear();
			 listeTypeMarchesFils =(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")));
			 filtreTypeMarche ="";
			}
		 
		//S�lection des pgpm 
		 public void onSelectPgpm() {
			 detailPass.setDppGpgId(pgpm.getGpgId());
			 detailPass.setDppSourceFin(pgpm.getGpgLibFin());

			 recupPgpm = new VPgpmFonction();
			 recupPgpm.setGpgObjet(pgpm.getGpgObjet());
			 recupPgpm.setGpgId(pgpm.getGpgId());
			 recupPgpm.setGpgTypePlan(pgpm.getGpgTypePlan());
			 recupPgpm.setGpgCommentaire(pgpm.getGpgCommentaire());
			 recupPgpm.setGpgPartiePmePmi(pgpm.getGpgPartiePmePmi());
			 recupPgpm.setMopLibelleLong(pgpm.getMopLibelleLong());
			 recupPgpm.setTymLibelleCourt(pgpm.getTymLibelleCourt());
			 recupPgpm.setGpgTymCode(pgpm.getGpgTymCode());
			 recupPgpm.setTymTymCode(pgpm.getTymTymCode());
			 recupPgpm.setGpgMopCode(pgpm.getGpgMopCode());
			 recupPgpm.setGpgPartiePmePmi(pgpm.getGpgPartiePmePmi());
			 recupPgpm.setGpgLibFin(pgpm.getGpgLibFin());
			 
			 partPpm = false;
			 partPgpm = true;
			 partPspm = false;
			 partPgspm = false;
			 panelFinPgpm = true;
			 panelFinPpm = false;
			 finPgpm = true;
			 finAmi = false;
		     finPrq = false;
			 
			 afficheDateFctPg();
			 
			 controleController.lignedefaut= false;
		     ligneftpgpm= true;
		     lignepn= false;
		     ligneps= false;
		     
		     detailPass.dppPartiePmePmi = pgpm.getGpgPartiePmePmi();
			 
			 listeFinancementPgpm =(List<VFinancementPgpm>) iservice.getObjectsByColumn("VFinancementPgpm", new ArrayList<String>(Arrays.asList("FIP_ID")),
				     new WhereClause("FIP_GPG_ID",WhereClause.Comparateur.EQ,""+pgpm.getGpgId()));
			 if (!listeFinancementPgpm.isEmpty()) {
				  fipPgpm=listeFinancementPgpm.get(0);
				    }
			 
			 //Control de la part reserv�e aux PME
			 controlePart();
		     }
		 
		 //Controler la part reserv�e aux PME � partir du PGPM
		 public void controlePart() {
			 if(pgpm.getGpgTymCode().equalsIgnoreCase("11") || pgpm.getGpgMopCode().equalsIgnoreCase("AAP")) {
				 nbreOuv = "2";
			 }else {
				 nbreOuv = "1";
			 }
		 }
		 
		 
		 //Gestion des Panels PPM
		 public void controlPanel() {
			 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSC")) {
				 controleController.etatPsc = true;
				 controleController.etatPsl = false;
				 controleController.etatPso = false;
				 controleController.etatPsl_Pso = false;
			 }else {
				   if(slctdTd.getDppMopCode().equalsIgnoreCase("PSO")) {
					   controleController.etatPsc = false;
						 controleController.etatPsl = false;
						 controleController.etatPso = true;
						 controleController.etatPsl_Pso = true;
				   }else {
					   
					   if(slctdTd.getDppMopCode().equalsIgnoreCase("PSL")) {
						   controleController.etatPsc = false;
							 controleController.etatPsl = true;
							 controleController.etatPso = false;
							 controleController.etatPsl_Pso = true;
					   }
				   }
			 }
		 }
		 
		//Gestion des Panels PSPM
		 public void controlPanelPs() {
			 if(slctdTd.getDppMopCode().equalsIgnoreCase("PSC") ) {
				 controleController.etatPsc = true;
				 controleController.etatPsl = false;
				 controleController.etatPso = false;
				 controleController.etatPsl_Pso = false;
			 }else {
				   if(slctdTd.getDppMopCode().equalsIgnoreCase("PSO")) {
					    controleController.etatPsc = false;
						 controleController.etatPsl = false;
						 controleController.etatPso = true;
						 controleController.etatPsl_Pso = true;
				   }else {
					   
					   if(slctdTd.getDppMopCode().equalsIgnoreCase("PSL")) {
						     controleController.etatPsc = false;
							 controleController.etatPsl = true;
							 controleController.etatPso = false;
							 controleController.etatPsl_Pso = true;
					   }
				   }
			 }
		 }
		 
		 
		 //Methode OnSelect pour PGSPM
		 public void onSelectPgspm() { 
			 detailPass.setDppGpgId(pgpm.getGpgId());
			 
			 recupPgspm = new VPgpmFonction();
			 recupPgspm.setGpgObjet(pgpm.getGpgObjet());
			 recupPgspm.setGpgId(pgpm.getGpgId());
			 recupPgspm.setGpgTypePlan(pgpm.getGpgTypePlan());
			 recupPgspm.setGpgCommentaire(pgpm.getGpgCommentaire());
			 recupPgspm.setGpgNumeroOrdre(pgpm.getGpgNumeroOrdre());
			 recupPgspm.setGpgDateSaisie(pgpm.getGpgDateSaisie());
			 recupPgspm.setGpgPartiePmePmi(pgpm.getGpgPartiePmePmi());
			 recupPgspm.setMopLibelleLong(pgpm.getMopLibelleLong());
			 recupPgspm.setTymLibelleCourt(pgpm.getTymLibelleCourt());
			 recupPgspm.setGpgTymCode(pgpm.getGpgTymCode());
			 recupPgspm.setTymTymCode(pgpm.getTymTymCode());
			 recupPgspm.setGpgMopCode(pgpm.getGpgMopCode());
			 recupPgspm.setGpgPartiePmePmi(pgpm.getGpgPartiePmePmi());
			 
			 partPpm = false;
			 partPgpm = false;
			 partPspm = false;
			 partPgspm = true;
			 panelFinPgpm = true;
			 panelFinPpm = false;
			 finPgpm = true;
			 finAmi = false;
			 finPrq = false;
			 
			 afficheDateFctPg();
			 
			 controleController.lignedefaut= false;
		     ligneftpgpm= true;
		     lignepn= false;
		     ligneps= false;
		     
		     
		     detailPass.dppPartiePmePmi = pgpm.getGpgPartiePmePmi();
			 
			 listeFinancementPgpm =(List<VFinancementPgpm>) iservice.getObjectsByColumn("VFinancementPgpm", new ArrayList<String>(Arrays.asList("FIP_ID")),
				     new WhereClause("FIP_GPG_ID",WhereClause.Comparateur.EQ,""+pgpm.getGpgId()));
			 if (!listeFinancementPgpm.isEmpty()) {
				  fipPgpm=listeFinancementPgpm.get(0);
				    }
			  //Controle sur les lignes budg�taires
			/*	if(pgpm == null) {
					 chargementLigne(passationListe.getMopCode());
				   }else {
					 chargementLigne(pgpm.getGpgMopCode());
				 }*/
	
			     //Control de la part reserv�e aux PME
				 controlePart();
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
			 updatePpm.setDppMopCode(updatePpm.getDppMopCode());
			 updatePpm.setDppTypePlan(updatePpm.getDppTypePlan());


			 updatePpm.setMopLibelleLong(updatePpm.getMopLibelleLong());
			 
			 updatePpm.setDppMopCode(updatePpm.getDppMopCode());
			 updatePpm.setDppTypePlan(updatePpm.getDppTypePlan());
			 updatePpm.setMopLibelleLong(updatePpm.getMopLibelleLong());

			 updatePpm.setMopLibelleLong(modePassation.getMopLibelleLong());
			 recupModePassation.setMopCode(modePassation.getMopCode());
			 recupPgpm.setGpgMopCode(modePassation.getMopCode());
			 recupPgpm.setMopLibelleLong(modePassation.getMopLibelleLong());
			 
			 affichNbreOuvMode();
			 afficheDate() ;
			 controleController.lignedefaut= false;
		     ligneftpgpm= false;
		     lignepn= true;
		     ligneps= false;
		             //Ramener le type march� en fonction du mode de passation
					 listeTypeMarches.clear();
					 if(recupPgpm.getGpgMopCode().equalsIgnoreCase("AMI")) {
						 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
								 new WhereClause("TYM_CODE",WhereClause.Comparateur.EQ,"11")); 
								 if (!listeTypeMarchesFils.isEmpty()) {
									 marche=listeTypeMarchesFils.get(0); 
									}
								 recupPgpm.setGpgTymCode(marche.getTymCode());
								 recupPgpm.setTymLibelleCourt(marche.getTymLibelleCourt());
								 panelTymNormal =false;
								 panelTymDp=true; 
								 panelPgpmNormal = true;
							     panelPgpmDp = false;
					 }else
						 if(recupPgpm.getGpgMopCode().equalsIgnoreCase("DPA")) {
							 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
									 new WhereClause("TYM_CODE",WhereClause.Comparateur.EQ,"11")); 
									 if (!listeTypeMarchesFils.isEmpty()) {
										 marche=listeTypeMarchesFils.get(0); 
										}
									 recupPgpm.setGpgTymCode(marche.getTymCode());
									 recupPgpm.setTymLibelleCourt(marche.getTymLibelleCourt());
									 panelTymNormal =false;
									 panelTymDp=true;  
									 panelPgpmNormal = false;
								     panelPgpmDp = true;
						 }else
						 if(recupPgpm.getGpgMopCode().equalsIgnoreCase("PRQ")) {
							 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
									 new WhereClause("TYM_CODE",WhereClause.Comparateur.NEQ,"11")); 
							 if (!listeTypeMarchesFils.isEmpty()) {
								 marche=listeTypeMarchesFils.get(0); 
								}
							 recupPgpm.setGpgTymCode(marche.getTymCode());
							 recupPgpm.setTymLibelleCourt(marche.getTymLibelleCourt());
							 panelTymNormal =false;
							 panelTymDp=true; 
							 panelPgpmNormal = true;
						     panelPgpmDp = false;
						 }else
							 if(recupPgpm.getGpgMopCode().equalsIgnoreCase("DPQ")) {
								 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
										 new WhereClause("TYM_CODE",WhereClause.Comparateur.NEQ,"11")); 
								 if (!listeTypeMarchesFils.isEmpty()) {
									 marche=listeTypeMarchesFils.get(0); 
									}
								 recupPgpm.setGpgTymCode(marche.getTymCode());
								 recupPgpm.setTymLibelleCourt(marche.getTymLibelleCourt());
								 panelTymNormal =false;
								 panelTymDp=true; 
								 panelPgpmNormal = false;
							     panelPgpmDp = true;
							 }else
								 
						     {
							 recupPgpm.setGpgTymCode("");
							 recupPgpm.setTymLibelleCourt("");
							 panelTymNormal =true;
							 panelTymDp=false; 
							 panelPgpmNormal = true;
						     panelPgpmDp = false;
						 }
				}
		 
		 
		 //Afficher le nombre d'ouvertures en choisissant le mode de passation (Mode PN)
		 public void affichNbreOuvMode() {
			 if(modePassation.getMopCode().equalsIgnoreCase("AAP")) {
				 nbreOuv = "2";
			 }else {
				 nbreOuv = "1"; 
			 }
		 }
		 
		 
		//Afficher le nombre d'ouvertures en choisissant le mode de passation (Mode PS)
		 public void affichNbreOuvModePs() {
			 if(passationListe.getMopCode().equalsIgnoreCase("AAP")) {
				 nbreOuv = "2";
			 }else {
				 nbreOuv = "1"; 
			 }
		 }
		 
		 
		  
		 //Afficher les dates pr�visionnelles en fonction du mode de Passation choisi (Mode PN)
		 public void afficheDate() {
			 if(updatePpm.getDppMopCode().equalsIgnoreCase("AMI")) {  
				 pavetPPM = false;
				 pavetAMI = true;
				 pavetPRQ = false;
				 pavetDPAMI= false;
				 pavetDPPRQ= false;
				 pavetPSC= false;
				 
				 libelleDPAMI = false;
				 libelleDPPRQ = false;
			     libelleAmi= true;
			     libellePrq= false;
			     libellePpm= false;
			     libellePsc= false;
				 
				 mode ="AMI";
			 }else {
				      if(updatePpm.getDppMopCode().equalsIgnoreCase("PRQ")) {
				    	     pavetPPM = false;
							 pavetAMI = false;
							 pavetPRQ = true;
							 pavetDPAMI= false;
							 pavetDPPRQ= false;
							 libelleDPAMI = false;
							 libelleDPPRQ = false;
							 pavetPSC= false;
							 libelleAmi= false;
						     libellePrq= true;
						     libellePpm= false;
							 libelleAmi= false;
						     libellePrq= true;
						     libellePsc= false;
							 mode ="PRQ";
				    }else 
				    	  if(updatePpm.getDppMopCode().equalsIgnoreCase("DPA")) {
					    	     pavetPPM = false;
								 pavetAMI = false;
								 pavetPRQ = false;
								 pavetDPAMI= true;
								 pavetDPPRQ= false;
								 pavetPSC= false;
								 libelleDPAMI = true;
								 libelleDPPRQ = false;
								 libelleAmi= false;
							     libellePrq= false;
							     libellePpm= false;
							     libellePsc= false;
							     libellePsl= false;
								 mode ="DP";
					    }else 
					    	 if(updatePpm.getDppMopCode().equalsIgnoreCase("PSC")) {
					    	     pavetPPM = false;
								 pavetAMI = false;
								 pavetPRQ = false;
								 pavetDPAMI= false;
								 pavetDPPRQ= false;
								 pavetPSC= true;
								 libelleDPAMI = false;
								 libelleDPPRQ = false;
								 libelleAmi= false;
							     libellePrq= false;
							     libellePpm= false;
							     libellePsc= true;
							     libellePsl= false;
								 mode ="PSC";
					    }else 
					    	 if(updatePpm.getDppMopCode().equalsIgnoreCase("PSL")) {
					    		     pavetPPM = true;
								     pavetAMI = false;
								     pavetPRQ = false;
								     pavetDPAMI= false;
									 pavetDPPRQ= false;
								     libelleDPAMI = false;
								     libelleDPPRQ = false;
								     pavetPSC= false;
								     libelleAmi= false;
								     libellePrq= false;
								     libellePpm= false;
								     libellePsc= false;
								     libellePsl= true;
								     mode="PSL";
					    }else
					    	if(updatePpm.getDppMopCode().equalsIgnoreCase("DPQ")) {
					    	     pavetPPM = false;
								 pavetAMI = false;
								 pavetPRQ = false;
								 pavetDPAMI= false;
								 pavetDPPRQ= true;
								 libelleDPAMI = false;
								 libelleDPPRQ = true;
								 pavetPSC= false;
								 libelleAmi= false;
							     libellePrq= false;
							     libellePpm= false;
							     libellePsc= false;
							     libellePsl= false;
								 mode ="DP";
					    }else 
				            {
				    	     pavetPPM = true;
						     pavetAMI = false;
						     pavetPRQ = false;
						     pavetDPAMI= false;
							 pavetDPPRQ= false;
						     libelleDPAMI = false;
						     libelleDPPRQ = false;
						     pavetPSC= false;
						     libelleAmi= false;
						     libellePrq= false;
						     libellePpm= true;
						     libellePsc= false;
						     libellePsl= false;
						     mode="";
				    }
			 }
		 }
		
		//Afficher les dates pr�visionnelles en fonction du mode de Passation choisi (Mode PS)
		 public void afficheDateModePs() { 
			 if(updatePpm.getDppMopCode().equalsIgnoreCase("AMI")) {
				 pavetPPM = false;
				 pavetAMI = true;
				 pavetPRQ = false;
				 libelleDPAMI = false;
				 libelleDPPRQ = false;
				 pscOui = false; 
				 pscNon = true;
				 mode ="AMI";
				 _logger.info("Panel AMI Activ�: "+pavetAMI);
			 }else {
				      if(updatePpm.getDppMopCode().equalsIgnoreCase("PRQ")) {
				    	     pavetPPM = false;
							 pavetAMI = false;
							 pavetPRQ = true;
							 libelleDPAMI = false;
							 libelleDPPRQ = false;
							 pscOui = false; 
							 pscNon = true;
							 mode ="PRQ";
							 _logger.info("Panel PRQ Activ�: "+pavetPRQ);
				    }else 
				    	  if(updatePpm.getDppMopCode().equalsIgnoreCase("DPS")) {
					    	     pavetPPM = false;
								 pavetAMI = true;
								 pavetPRQ = false;
								 pscOui = false; 
								 pscNon = true;
								 libelleDPAMI = true;
								 libelleDPPRQ = false;
								 mode ="DP";
					    }else 
					    	if(updatePpm.getDppMopCode().equalsIgnoreCase("DQS")) {
					    	     pavetPPM = false;
								 pavetAMI = false;
								 pavetPRQ = true;
								 pscOui = false; 
								 pscNon = true;
								 libelleDPAMI = false;
								 libelleDPPRQ = true;
								 libellePsl1= false;
								 libellePsl= false;
								 mode ="DP";
					    }else 
					    	 if(updatePpm.getDppMopCode().equalsIgnoreCase("PSC")) {
					    	     pavetPPM = false;
								 pavetAMI = false;
								 pavetPRQ = false;
								 pavetDPAMI= false;
								 pavetDPPRQ= false;
								 pavetPSC= true;
								 pscOui = true; 
								 pscNon = false;
								 libelleDPAMI = false;
								 libelleDPPRQ = false;
								 libelleAmi= false;
							     libellePrq= false;
							     libellePpm= false;
							     libellePsc= true;
							     libellePsl1= false;
							     libellePsl= false;
								 mode ="PSC";
					    }else 
					    	 if(updatePpm.getDppMopCode().equalsIgnoreCase("PSL")) {
					    		 pavetPPM = true;
							     pavetAMI = false;
							     pavetPRQ = false;
							     pavetDPAMI= false;
							     pavetDPPRQ= false;
							     pavetPSC= false;
							     pscOui = false; 
							     pscNon = true;
							     libelleDPAMI = false;
							     libelleDPPRQ = false;
							     libelleAmi= false;
						         libellePrq= false;
						         libellePpm= false;
						         libellePsc= false;
						         libellePsl = true;
						         libellePsl1= true;
						          mode ="PSL";
							    _logger.info("Panel PSL Activ�: "+pavetPPM);
				          }else
					      {
					    	     pavetPPM = true;
							     pavetAMI = false;
							     pavetPRQ = false;
							     libelleDPAMI = false;
							     libelleDPPRQ = false;
							     libellePsl1= false;
							     libellePsl= false;
							     libellePpm= true;
							     pscOui = false; 
								 pscNon = true;
							     mode =" ";
							     _logger.info("Panel PPM Activ�: "+pavetPPM);
					    }
			 }
		 }
		 
		 
	     //Afficher les dates pr�visionnelles en fonction du mode de PGPM choisi
		 public void afficheDateFctPg() { 
			 if(updatePpm.getDppMopCode().equalsIgnoreCase("AMI")) {
				 pavetPPM = false;
				 pavetAMI = true;
				 pavetPRQ = false;
				 libelleDPAMI = false;
				 libelleDPPRQ = false;
				 mode ="AMI";
				 _logger.info("Panel AMI Activ�: "+pavetAMI);
			 }else {
				      if(updatePpm.getDppMopCode().equalsIgnoreCase("PRQ")) {
				    	     pavetPPM = false;
							 pavetAMI = false;
							 pavetPRQ = true;
							 mode ="PRQ";
							 _logger.info("Panel PRQ Activ�: "+pavetPRQ);
				    }else {
				    	     pavetPPM = true;
						     pavetAMI = false;
						     pavetPRQ = false;
						     mode ="PPM";
						     _logger.info("Panel PPM Activ�: "+pavetPPM);
				    }
			 }
		 }
		 
		 
		//R�initialiser les modes de Passation
		 public void razchargeModePassation() {
			 listeModePassationPn.clear();
			 listeModePassationPn =(List<VModePassationPn>) iservice.getObjectsByColumn("VModePassationPn", new ArrayList<String>(Arrays.asList("mopCode")));
			 filtreModePassation="";
			}
		 
		 //Methode de s�lection du mode de Passation
		 public void onSelectModePassationPgspm() {
			 detailPass.setTModePassation(new TModePassation(passationListe.getMopCode()));
			 detailPass.setDppTypePlan(passationListe.getMopTypPlan());
			 
		    recupModeListe = new VModePassation();
		    recupModeListe.setMopLibelleLong(passationListe.getMopLibelleLong());
		    recupModeListe.setMopCode(passationListe.getMopCode());
		    
		    recupPgspm.setGpgMopCode(passationListe.getMopCode());
		    recupPgspm.setMopLibelleLong(passationListe.getMopLibelleLong());
		    //chargeMode();
		    
		    affichNbreOuvModePs();
		    afficheDateModePs();
		    
		    controleController.lignedefaut= false;
		     ligneftpgpm= false;
		     lignepn= false;
		     ligneps= true;
				}
		//Fin M�thode Love 
		 
	 
		//M�thode de cr�ation d'un plan de Passtion par l'Autorit� Contractante
	  	 @Transactional
		 public void creerPlanPassation() throws IOException{
	  		 planPass.setTGestion(new TGestion(gesCode));
	  		 planPass.setTFonction(userController.getSlctd().getTFonction());
	  		 planPass.setTStructure(userController.getSlctd().getTFonction().getTStructure());
	  		 iservice.addObject(planPass);

	      	 userController.setTexteMsg("Plan de Passation cr�e avec succ�s!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
		 }
	  	 
	  	 
	 	//M�thode de cr�ation d'un plan de Passtion par la CPMP ou le DMP
	  	 @Transactional
		 public void creerPlanPassationCpmpDmp() throws IOException{
	  		 planPass.setTGestion(new TGestion(gesCode));
	  		 planPass.setTFonction(recupFonction);
	  		 planPass.setTStructure(userController.getSlctd().getTFonction().getTStructure());
	  		 iservice.addObject(planPass);

	      	 userController.setTexteMsg("Plan de Passation cr�e avec succ�s!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
		 }
	  	 
	  	 
	  	//Recupertation de la date gen�r�e
		 public void recupDateGenere() {
		    			listeDateGenere= (List<VGenerationDate>) iservice.getObjectsByColumn("VGenerationDate", new ArrayList<String>(Arrays.asList("DPP_ID")),
		    					 new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
		    			if (!listeDateGenere.isEmpty()) {
		    				geneDate=listeDateGenere.get(0); 
		    			}
		 }
		 
		 
		 public void updateDaoTrans() {
			 listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
						new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
					if (!listeTsPpm.isEmpty()) {
						detPass = listeTsPpm.get(0);
						detPass.setDppDateDaoTrans(geneDate.getDppDateDaoTrans());
						detPass.setDppDateAvisAoPublication(pubDate.getDatepub());
						//detPass.setDppDateAvisAoPublication(updatePpm.getDppDateAvisAoPublication());
						iservice.updateObject(detPass);
						recupDateGenere();
					}
		 }
		 
		 //Rafraichissement automatique des dates
		 public void genereDate(String date) {
			 
			 listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
						new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
					if (!listeTsPpm.isEmpty()) {
						detPass = listeTsPpm.get(0);
						
		   if(date.equalsIgnoreCase("dppDateDaoTrans")) {
			   detPass.setDppDateDaoTrans(updatePpm.getDppDateDaoTrans());
				iservice.updateObject(detPass);
				recupDateGenere();
				_logger.info("Date de Transmission : "+geneDate.getDppDateDaoTrans());
				  }else
					  if(date.equalsIgnoreCase("dppDateAvisAoPublication")) {
						detPass.setDppDateAvisAoPublication(geneDate.getDppDateAvisAoPublication());
						iservice.updateObject(detPass);
						recupDateGenere();
						_logger.info("Date de Publication : "+geneDate.getDppDateAvisAoPublication());
							}
						    if(date.equalsIgnoreCase("dppInvEntre")) {
							detPass.setDppInvEntre(geneDate.getDppInvEntre());
							iservice.updateObject(detPass);
							recupDateGenere();
							_logger.info("Date d'Invitation des Entreprises : "+geneDate.getDppInvEntre());
						}else
							 if(date.equalsIgnoreCase("dppApprobAnoTec")) {
								 detPass.setDppDateRecepFact(geneDate.getDppApprobAnoTec());
							     iservice.updateObject(detPass); 
							     recupDateGenere();
							     _logger.info("Date ANO Approb : "+geneDate.getDppApprobAnoTec());
							 }else
							 if(date.equalsIgnoreCase("dppDateRecepFact")) {
								 detPass.setDppDateRecepFact(geneDate.getDppDateRecepFact());
							     iservice.updateObject(detPass); 
							     recupDateGenere();
							     _logger.info("Date de reception des Factures : "+geneDate.getDppDateRecepFact());
							 }else
								 if(date.equalsIgnoreCase("dppDateRecepLettr")) {
									 detPass.setDppDateRecepLettr(geneDate.getDppDateRecepLettr());
								     iservice.updateObject(detPass); 
								     recupDateGenere();
								     _logger.info("Date de reception des Lettres : "+geneDate.getDppDateRecepLettr());
								 }else
									 if(date.equalsIgnoreCase("dppDateSolFact")) {
										 detPass.setDppDateSolFact(geneDate.getDppDateSolFact());
									     iservice.updateObject(detPass); 
									     recupDateGenere();
									     _logger.info("Date de sollicitation des Factures : "+geneDate.getDppDateRecepLettr());
									 }else
								         if(date.equalsIgnoreCase("dppDateDaoApprobDmp")) {
									        detPass.setDppDateDaoApprobDmp(geneDate.getDppDateDaoApprobDmp());
								            iservice.updateObject(detPass); 
								            recupDateGenere();
								          }else
									          if(date.equalsIgnoreCase("dppDateAttApprobCpmp")) {
										         detPass.setDppDateAttApprobCpmp(geneDate.getDppDateAttApprobCpmp());
									            iservice.updateObject(detPass); 
									            recupDateGenere();
									 }else
										 if(date.equalsIgnoreCase("dppDateDaoApprobBail")) {
											 detPass.setDppDateDaoApprobBail(geneDate.getDppDateDaoApprobBail());
										     iservice.updateObject(detPass); 
										     recupDateGenere();
										 }else
											 if(date.equalsIgnoreCase("dppDateOuvertOt")) {
												 detPass.setDppDateOuvertOt(geneDate.getDppDateOuvertOf());
											     iservice.updateObject(detPass); 
											     recupDateGenere();
											 }else
												 if(date.equalsIgnoreCase("dppDateOuvertOf")) {
													 detPass.setDppDateOuvertOf(geneDate.getDppDateOuvertOf());
												     iservice.updateObject(detPass); 
												     recupDateGenere();
												 }else
													 if(date.equalsIgnoreCase("dppDateElabRapport")) {
														 detPass.setDppDateElabRapport(geneDate.getDppDateElabRapport());
													     iservice.updateObject(detPass); 
													     recupDateGenere();
													 }else
														 if(date.equalsIgnoreCase("dppDateJugementOffreTec")) {
															 detPass.setDppDateJugementOffreTec(geneDate.getDppDateJugementOffreTec());
														     iservice.updateObject(detPass); 
														     recupDateGenere();
														 }else
															 if(date.equalsIgnoreCase("dppDateNotAtt")) {
																 detPass.setDppDateNotAtt(geneDate.getDppDateNotAtt());
															     iservice.updateObject(detPass); 
															     recupDateGenere();
															 }else
																 if(date.equalsIgnoreCase("dppApprobAno")) {
																	 detPass.setDppApprobAno(geneDate.getDppApprobAno());
																     iservice.updateObject(detPass); 
																     recupDateGenere();
																 }else
																	 if(date.equalsIgnoreCase("dppDateAttApproBail")) {
																		 detPass.setDppDateAttApproBail(geneDate.getDppDateAttApproBail());
																	     iservice.updateObject(detPass); 
																	     recupDateGenere();
																	 }else
																		 if(date.equalsIgnoreCase("dppDateNegociation")){
																			 detPass.setDppDateNegociation(geneDate.getDppDateNegociation());
																		     iservice.updateObject(detPass); 
																		     recupDateGenere();
																		 }else
																			 if(date.equalsIgnoreCase("dppDateJugementOffre")) {
																				 detPass.setDppDateJugementOffre(geneDate.getDppDateJugementOffre());
																			     iservice.updateObject(detPass); 
																			     recupDateGenere();
																			 }else
																				 if(date.equalsIgnoreCase("dppDateSignatAttrib")) {
																					 detPass.setDppDateSignatAttrib(geneDate.getDppDateSignatAttrib());
																				     iservice.updateObject(detPass); 
																				     recupDateGenere();
																				 }else
																					 if(date.equalsIgnoreCase("dppDateSignatAc")) {
																						 detPass.setDppDateSignatAc(geneDate.getDppDateSignatAc());
																					     iservice.updateObject(detPass); 
																					     recupDateGenere();
																					 }else
																						 if(date.equalsIgnoreCase("dppDateMarcheApprob")) {
																							 detPass.setDppDateMarcheApprob(geneDate.getDppDateMarcheApprob());
																						     iservice.updateObject(detPass); 
																						     recupDateGenere();
																						 }else
																							 if(date.equalsIgnoreCase("dppDateAttApprobDmp")) {
																								 detPass.setDppDateAttApprobDmp(geneDate.getDppDateAttApprobDmp());
																							     iservice.updateObject(detPass); 
																							     recupDateGenere();
																							 }else
																								 if(date.equalsIgnoreCase("dppDateExecDebut")) {
																									 detPass.setDppDateExecDebut(geneDate.getDppDateExecDebut());
																								     iservice.updateObject(detPass); 
																								     recupDateGenere();
																								 }else
																									 if(date.equalsIgnoreCase("dppDateExecFin")) {
																										 detPass.setDppDateExecFin(geneDate.getDppDateExecFin());
																									     iservice.updateObject(detPass); 
																									     recupDateGenere();
																									 }else
																										 if(date.equalsIgnoreCase("dppDateDaoTransPub")) {
																											 detPass.setDppDateDaoTransPub(geneDate.getDppDateDaoTransPub());
																										     iservice.updateObject(detPass); 
																										     recupDateGenere();
																										 }
					}
		 }
		 
		//Si la source de financement est Etat alors montant en devise = part Tr�sor
         public void recupTresor() {
         	if(sourfin.equalsIgnoreCase("ETAT")) {
         		newFinancement.fppPartTresor = newFinancement.getFppMontantDevise().longValue();
         	}
         }
         
         //Si la source de financement est ETAT alors montant en tresor = montant en devise
         public void recupUpdate() {
        	 if(sourfin.equalsIgnoreCase("ETAT")) {
        		 updatefinance.fppPartTresor = updatefinance.getFppMontantDevise().longValue();
        	 }
         }
		 
		 
		  	//Recupertation de la date gen�r�e
			 public void recupModeleDao() {
			    			listeModele= (List<VModeleDac>) iservice.getObjectsByColumn("VModeleDac", new ArrayList<String>(Arrays.asList("DPP_ID")),
			    					 new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
			    			_logger.info("id ppm : "+detailPass.getDppId());
			 }
			 
			//Recupertation du mode de qualification PRQ
			 public void recupModeleDaoAmiPrq() {
			    			listeModele= (List<VModeleDac>) iservice.getObjectsByColumn("VModeleDac", new ArrayList<String>(Arrays.asList("DPP_ID")),
			    					 new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
			    			if (!listeModele.isEmpty()) {
			    				modelDac=listeModele.get(0); 
			    			}
			    			_logger.info("id ppm : "+detailPass.getDppId());
			 }
			 
			//Afficher la liste des Ami DP
			 public void chargeAmiDp() {
				 if(controleController.typePlan == "PN") {
					 chargeDpAmi("PN");
				 }else
					 if(controleController.typePlan == "PS") {
						 chargeDpAmi("PS");
					 }
			 }
			 
			//Afficher la liste des Prq DP
			 public void chargePrqDp() {
				 if(controleController.typePlan == "PN") {
					 chargeDpPrq("PN");
				 }else
					 if(controleController.typePlan == "PS") {
						 chargeDpPrq("PS");
					 }
			 }
			 
			 //AMI
			 public void chargeDpAmi(String typlan) {
				 listeAmiDp = (List<VAmiDp>) iservice.getObjectsByColumn("VAmiDp",
						 new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typlan)); 
			 }
			 
			 //PRQ
			 public void chargeDpPrq(String typlan) {
				 listePrqDp  = (List<VPrqAo>) iservice.getObjectsByColumn("VPrqAo",
						 new WhereClause("DPP_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typlan)); 
			 }
	  	 
	  	 
	 //M�thode de cr�ation d'un ppm par le AC
		 
		 
		 
		 
		 
		//M�thode de cr�ation d'un ppm par le AC
		 

	//Fin de la Methode de cr�ation d'une op�ration 
		 
		 //Enregistrement des finanacements PPM
		 public void saveFinancementOperation(TDetailPlanPassation TDetailPlanPassation) {
			  for(VFinancementPgpm fin: listeFinancementPgpm) {
    		        TFinancementPpm newFinancement = new TFinancementPpm();
    		        newFinancement.setTDetailPlanPassation(TDetailPlanPassation);
    		        newFinancement.setFppCommentaire(fin.getFipCommentaire());
    		        newFinancement.setFppMontantCfa(fin.getFipMontantCfa());
    		        newFinancement.setFppMontantDevise(fin.getFipMontantDevise());
    		        newFinancement.setFppPartTresor(fin.getFipTresor());
    		        newFinancement.setTBailleur(new TBailleur(fin.getFipBaiCode()));	
    		        newFinancement.setTSourceFinancement(new TSourceFinancement(fin.getFipSouCode()));
    		        newFinancement.setTDevise(new TDevise(fin.getFipDevCode()));
    				iservice.addObject(newFinancement);
			    }	 
		 }
	  	
		 
	  	 //Methode detail plan
	  	
	  	 
	  	
	  	 
	  	//Methode d'historisation
		 public void historiser(String statut,TDetailPlanPassation TDetailPlanPassation, String motif) {
			 
			     TStatut statuts = constantService.getStatut(statut);
			  //Historisation des Plans G�n�raux
			     THistoPlanPassation histoPass = new THistoPlanPassation();
			     histoPass.setHppDate(Calendar.getInstance().getTime());
			     histoPass.setHppMotif(motif);
			     histoPass.setTStatut(statuts);
			     histoPass.setTDetailPlanPassation(TDetailPlanPassation);
			     histoPass.setTFonction(userController.getSlctd().getTFonction());
			     histoPass.setTOperateur(userController.getSlctd().getTOperateur());
			     iservice.addObject(histoPass);
		 }
		 

	  	 
	  	 //Mis � jour des dates pr�visionnelles
	  	 //@Transactional
	  	 public void majDate() {
	  		List<TDetailPlanPassation> PPM  = iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",Comparateur.EQ,""+updatePpm.getDppId()));
			if(!PPM.isEmpty()) detailPass = PPM.get(0);
	  		 if(detailPass.getTModePassation().getMopCode().equalsIgnoreCase("PSC")) {
	  			 //detailPass.setDppDateDaoTrans(geneDate.getDppDateDaoTrans());
    	    	      //detailPass.setDppDateAvisAoPublication(geneDate.getDppDateAvisAoPublication());
    	    	      detailPass.setDppApprobAno(geneDate.getDppApprobAno());
		              detailPass.setDppDateAttApproBail(geneDate.getDppDateAttApproBail());
		              detailPass.setDppDateAttApprobCpmp(geneDate.getDppDateAttApprobCpmp());
		              detailPass.setDppDateAttApprobDmp(geneDate.getDppDateAttApprobDmp());
		              detailPass.setDppDateDaoApprobDmp(geneDate.getDppDateDaoApprobDmp());
		              detailPass.setDppDateElabRapport(geneDate.getDppDateElabRapport());
		              detailPass.setDppDateExecDebut(geneDate.getDppDateExecDebut());
		              detailPass.setDppDateExecFin(geneDate.getDppDateExecFin());
		              detailPass.setDppDateJugementOffre(geneDate.getDppDateJugementOffre());
		              detailPass.setDppDateJugementOffreTec(geneDate.getDppDateJugementOffreTec());
		              detailPass.setDppDateMarcheApprob(geneDate.getDppDateMarcheApprob());
		              detailPass.setDppDateNegociation(geneDate.getDppDateNegociation());
		              detailPass.setDppDateOuvertOf(geneDate.getDppDateOuvertOt());
		              detailPass.setDppDateOuvertOt(geneDate.getDppDateOuvertOt());
		              detailPass.setDppDateSignatAc(geneDate.getDppDateSignatAc());
		              detailPass.setDppDateSignatAttrib(geneDate.getDppDateSignatAttrib());
		              detailPass.setDppDateSolFact(geneDate.getDppDateSolFact());
		              detailPass.setDppDateRecepFact(geneDate.getDppDateRecepFact());
	     	          detailPass.setTModeleDacType(new TModeleDacType(updatePpm.getMdtCode()));
			          iservice.updateObject(detailPass);
			         
			          boutonEdit =true;
			          controleController.btn_creerDetailPpm = false;
			          controleController.btn_creerDetailPspm = false;
			          pavetFinancement = true;
			     
			          userController.setTexteMsg("Op�ration enregistr�e avec succ�s!");
				      userController.setRenderMsg(true);
				      userController.setSevrityMsg("success"); 
	  		 }
	  		
	  	   }
	  	
	  	 
	  	 
	  	//Methode de r�cup�ration de t_detail_plan_passation dans t_affichage_ppm
		 public void editForm() {
		    			listUpdate= (List<VUpdatePpm>) iservice.getObjectsByColumn("VUpdatePpm",
		    					 new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
		    			if (!listUpdate.isEmpty()) {
		    				updatePpm=listUpdate.get(0); 
		    			}
		      }
		 
		 
		 
		 //Afficher les financements du projet ou pgpm selectionn�
		 public void chargeFinancementUpdate() {
			 listeFinancement.clear();
			 listeFinancement = ((List<TFinancementPpm>)iservice.getObjectsByColumn("TFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
						 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+slctdTd.getDppId())));
			 coutOperation();
			 coutTotal();
		 }
		 
		 
		 
		 
		 
    	 //suppression de financement update
		 public void removeFinancementUpdate() {
			 System.out.print("+-------------+ "+getSelectFinance().getFppId());
			 try {
				 iservice.deleteObject(getSelectFinance());
					chargeFinancementUpdate();
					coutOperation();
					userController.setTexteMsg("Suppression effectu�e avec succ�s !");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");

			 } catch (org.hibernate.exception.ConstraintViolationException e) {
				 userController.setTexteMsg("Impossible de supprimer l'Op�rateur !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("danger");	 
			 }
		 }
		 
		//Tri sur les types de financement  
			public void chargeSourceCheck() { 
		    listeSourceFinance.clear();
			listeSourceFinance=(List<TSourceFinancement>) iservice.getObjectsIn("TSourceFinancement", new ArrayList<String>(Arrays.asList("SOU_CODE")),
			      "SOU_CODE", new ArrayList<String>(Arrays.asList("EMP","DON")));
			newFinancement = new TFinancementPpm();
				}
		 
		//Tri sur les types de financement  
			public void chargeSourceEtat() { 
		    listeSourceFinance.clear();
			listeSourceFinance=(List<TSourceFinancement>) iservice.getObjectsIn("TSourceFinancement", new ArrayList<String>(Arrays.asList("SOU_CODE")),
			      "SOU_CODE", new ArrayList<String>(Arrays.asList("TRE")));
			newFinancement = new TFinancementPpm();
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
				 chargeSourceFinance();
				 newFinancement = new TFinancementPpm();
				// sourfin="";
			 }else 
				 if(sourfin.equalsIgnoreCase("ETAT")){
				 selectBailleur = false;
				 selectTresor = true;
				 selectPartBai= false;
				 souCode="TRE";
				 devCode="CFA";
				 chargeSourceEtat();
			    }else 
			         if(sourfin.equalsIgnoreCase("")){
			    	  selectPartBai = false;
			    	  selectBailleur = false;
					  selectTresor = false;
					  souCode="";
					  devCode="";
			    }
		 }

	  	public String fermerPspm(String value ,String action) throws IOException { 
			 userController.initMessage();
		     chargeData("PS");
		     //chargeDataPgspm();
			 //vider();
			 return userController.renderPage(value);
		 }
	  	 
	  	 
	  	 public String fermer(String value ,String action) throws IOException { 
			 userController.initMessage();
			 chargeData("PN");
		     //chargeDataPgspm();
			 //vider();
			 return userController.renderPage(value);
		 }
		 
	  
	  	 
	  	 //M�thode de cr�ation d'un financement
	  	 public void saveFinancement(){
			    newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
			    newFinancement.setTDevise(new TDevise(devCode));
			    newFinancement.setTBailleur(new TBailleur(baiCode));
			    newFinancement.setTDetailPlanPassation(detailPass);;
				iservice.addObject(newFinancement);
				//methode qui charge les financements du projet cr�e
				chargeFinancement();
				
				//R�cuperons la derni�re op�ration cr�e et faisons une mis � jour sur sa source de financement
				 List<TDetailPlanPassation> PL =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
							new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+detailPass.getDppId()));
				 TDetailPlanPassation pass = new TDetailPlanPassation();
					 if(!PL.isEmpty())  
						 pass =PL.get(0); 
					     pass.setDppSourceFin(newFinancement.getTSourceFinancement().getSouCode());
					     pass.setDppMontant(totalMontantPpm);
					     iservice.updateObject(pass);
				
				//Initialiser la variable newFinancement
			    newFinancement = new TFinancementPpm();	     
				//methode qui charge les financements du projet cr�e
				//chargeFinancement();
				//methode qui charge la liste des pgpm
				//chargeData(typePlan);
				
				//Message de Confirmation
				 userController.setTexteMsg("Financement enregistr� avec succ�s !");
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
			 sourfin = "";
		 }
		 
		 
	     
	    
	     //Fin de la methode de validation
			
	
	     
			 public void controlePartpme() {
				 if(controleController.type == "PSPM"){
                	 partPspm = true;
                	 partPgspm = false;
                	 partPpm = false;
                	 partPgpm = false;
                }else {
                	 partPspm = false;
               	     partPgspm = false;
               	     partPpm = true;
               	     partPgpm = false;
                }
			 }
	  						
				//Le co�t pr�visionnel de l'op�ration
				 public void coutOperation() {
					 totalMontant = 0;
					 for(VFinancementPgpm n : listeFinancementPgpm) {
						 totalMontant = totalMontant+ (n.getFipMontantCfa()+n.getFipTresor());
					 }
				 }
				 
				 
				 //le co�t total de l'op�ration PPM
				  public void coutTotal() {
					 totalMontantPpm = 0; 
					 for(TFinancementPpm l :listeFinancement ) {
						 totalMontantPpm = totalMontantPpm+ (l.getFppMontantCfa()+l.getFppPartTresor());
					 }
				 }
				 
				 //Action de fermer
				 public String fermerForm(String value ,String action) throws IOException {
					 userController.initMessage();
					 chargeData("PS"); 
					 //vider();
					 return userController.renderPage(value);
				 }
				 
				
				 
				 
				 public TPlanPassation checkPlan(String minCode) {
					 TPlanGeneral val ;
	   				List<TPlanPassation > listPlan = ((List<TPlanPassation>)iservice.getObjectsByColumn("TPlanPassation",new ArrayList<String>(Arrays.asList("PLP_ID")),
	   						new WhereClause("PLP_MIN_CODE",Comparateur.EQ,""+minCode)));
	   				
	   				return (listPlan.isEmpty() || listPlan==null)?null:listPlan.get(0);
	   			}
	 
	 
 
	 
	 
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);	 
		     switch(value) {
				case "ppm1":
					chargeData("PN");
					 userController.initMessage();
					_logger.info("value: "+value+" action "+action);
					
					break;
				case "ppm4":
					controlPanel();
					controleDaoType();
					editForm();
					afficheDate();
					afficheDateModePs();
					chargeFinancementUpdate();
					chargeGestions();
					chargeAmiDp();
					chargePrqDp();
					chargeMarches();
					chargeModePassation();
					chargePgpm();
					chargeSourceFinance();
					chargeImputation();
					controlePartpme();
					 //pscOui = false; 
					 //pscNon = true; 
					//vider();
				break;
				case "pspm1": 
	                    chargeData("PS");
	                    //chargePpmTrans("PS");
	                    tableauBordController.ChargeTbProcedure("PS","PPM");
		 			//chargeDataAvaliderPspm();
	                    userController.initMessage();
		 			_logger.info("value: "+value+" action: "+action);		    				
			    }
		     return userController.renderPage(value);
	 }



	 
		//Cumul Co�t des op�rations
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
		 
		 //Edition de l'�tat PPM en fonction de la gestion
		 public void imprimerPpmIndex() {
			 String operateur = userController.getSlctd().getTFonction().getFonCod();
				projetReport.longStringparam2(gesCode, operateur, "Ppm", "Ppm");
			}
		 
		 //Edition de l'�tat PSPM en fonction de la gestion
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


	public List<VPpmliste> getListePpm() {
		return listePpm;
	}


	public void setListePpm(List<VPpmliste> listePpm) {
		this.listePpm = listePpm;
	}


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


	public List<VPpmliste> getListSelectionTransmission() {
		return listSelectionTransmission;
	}


	public void setListSelectionTransmission(List<VPpmliste> listSelectionTransmission) {
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



	public VPpmliste getSlctdTdPpm() {
		return slctdTdPpm;
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


	public void setSlctdTdPpm(VPpmliste slctdTdPpm) {
		this.slctdTdPpm = slctdTdPpm;
	}

   /*
	public TModePassation getModePassation() {
		return modePassation;
	}

	public void setModePassation(TModePassation modePassation) {
		this.modePassation = modePassation;
	}*/


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


	public List<VModelePrq> getListePrq() {
		return listePrq;
	}


	public void setListePrq(List<VModelePrq> listePrq) {
		this.listePrq = listePrq;
	}


	public boolean isModelePrq() {
		return modelePrq;
	}


	public void setModelePrq(boolean modelePrq) {
		this.modelePrq = modelePrq;
	}


	public List<VFinancementPgpm> getListeFinancementPgpm() {
		return listeFinancementPgpm;
	}
	public void setListeFinancementPgpm(List<VFinancementPgpm> listeFinancementPgpm) {
		this.listeFinancementPgpm = listeFinancementPgpm;
	}


	public VFinancementPgpm getFipPgpm() {
		return fipPgpm;
	}

	public void setFipPgpm(VFinancementPgpm fipPgpm) {
		this.fipPgpm = fipPgpm;
	}


	public List<VTypeStructConduc> getListeTypStruConduc() {
		return listeTypStruConduc;
	}

	public void setListeTypStruConduc(List<VTypeStructConduc> listeTypStruConduc) {
		this.listeTypStruConduc = listeTypStruConduc;
	}


	public String getStrucCond() {
		return strucCond;
	}
	public void setStrucCond(String strucCond) {
		this.strucCond = strucCond;
	}


	public String getStatutPub() {
		return statutPub;
	}
	public void setStatutPub(String statutPub) {
		this.statutPub = statutPub;
	}


	public List<VPpmliste> getPublicationListe() {
		return publicationListe;
	}
	public void setPublicationListe(List<VPpmliste> publicationListe) {
		this.publicationListe = publicationListe;
	}

	public List<VPpmliste> getListePspm() {
		return listePspm;
	}

	public void setListePspm(List<VPpmliste> listePspm) {
		this.listePspm = listePspm;
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



	public List<VTypeMarcheFils> getListeTypeMarchesFils() {
		return listeTypeMarchesFils;
	}

	public void setListeTypeMarchesFils(List<VTypeMarcheFils> listeTypeMarchesFils) {
		this.listeTypeMarchesFils = listeTypeMarchesFils;
	}


	public List<VModePassationPn> getListeModePassationPn() {
		return listeModePassationPn;
	}

	public void setListeModePassationPn(List<VModePassationPn> listeModePassationPn) {
		this.listeModePassationPn = listeModePassationPn;
	}



	public List<VModeleDac> getListeModele() {
		return listeModele;
	}

	public void setListeModele(List<VModeleDac> listeModele) {
		this.listeModele = listeModele;
	}


	public List<VDatePub> getListeDatePub() {
		return listeDatePub;
	}

	public void setListeDatePub(List<VDatePub> listeDatePub) {
		this.listeDatePub = listeDatePub;
	}



	public VModePassationPn getModePassation() {
		return modePassation;
	}

	public void setModePassation(VModePassationPn modePassation) {
		this.modePassation = modePassation;
	}


	public VDatePub getPubDate() {
		return pubDate;
	}

	public void setPubDate(VDatePub pubDate) {
		this.pubDate = pubDate;
	}


	public List<VPpmPub> getPpmPub() {
		return ppmPub;
	}
	public void setPpmPub(List<VPpmPub> ppmPub) {
		this.ppmPub = ppmPub;
	}

	public String getSourfin() {
		return sourfin;
	}
	public void setSourfin(String sourfin) {
		this.sourfin = sourfin;
	}

	public boolean isSelectBailleur() {
		return selectBailleur;
	}

	public void setSelectBailleur(boolean selectBailleur) {
		this.selectBailleur = selectBailleur;
	}


	public boolean isSelectTresor() {
		return selectTresor;
	}
	public void setSelectTresor(boolean selectTresor) {
		this.selectTresor = selectTresor;
	}

	public boolean isSelectPartBai() {
		return selectPartBai;
	}
	public void setSelectPartBai(boolean selectPartBai) {
		this.selectPartBai = selectPartBai;
	}


	public List<VUpdateFinancementPpm> getListeupdatefinance() {
		return listeupdatefinance;
	}

	public void setListeupdatefinance(List<VUpdateFinancementPpm> listeupdatefinance) {
		this.listeupdatefinance = listeupdatefinance;
	}

	public VUpdateFinancementPpm getUpdatefinance() {
		return updatefinance;
	}

	public void setUpdatefinance(VUpdateFinancementPpm updatefinance) {
		this.updatefinance = updatefinance;
	}

	public boolean isPanelFinPgpm() {
		return panelFinPgpm;
	}

	public void setPanelFinPgpm(boolean panelFinPgpm) {
		this.panelFinPgpm = panelFinPgpm;
	}

	public boolean isPanelFinPpm() {
		return panelFinPpm;
	}
	public void setPanelFinPpm(boolean panelFinPpm) {
		this.panelFinPpm = panelFinPpm;
	}

	public long getPgmp() {
		return pgmp;
	}

	public void setPgmp(long pgmp) {
		this.pgmp = pgmp;
	}


	public List<VDetTabBordPpm> getDetailTB() {
		return detailTB;
	}

	public void setDetailTB(List<VDetTabBordPpm> detailTB) {
		this.detailTB = detailTB;
	}


	public long getTotalMontantPpm() {
		return totalMontantPpm;
	}

	public void setTotalMontantPpm(long totalMontantPpm) {
		this.totalMontantPpm = totalMontantPpm;
	}



	public List<VPpmliste> getListePpmTrans() {
		return listePpmTrans;
	}

	public void setListePpmTrans(List<VPpmliste> listePpmTrans) {
		this.listePpmTrans = listePpmTrans;
	}

	public List<VPpmliste> getListePpmDiff() {
		return listePpmDiff;
	}

	public void setListePpmDiff(List<VPpmliste> listePpmDiff) {
		this.listePpmDiff = listePpmDiff;
	}


	public List<VPpmliste> getListePspmDiff() {
		return listePspmDiff;
	}

	public void setListePspmDiff(List<VPpmliste> listePspmDiff) {
		this.listePspmDiff = listePspmDiff;
	}

	public List<VPpmliste> getListeDiffDmpCp() {
		return listeDiffDmpCp;
	}

	public void setListeDiffDmpCp(List<VPpmliste> listeDiffDmpCp) {
		this.listeDiffDmpCp = listeDiffDmpCp;
	}


	public List<VPpmliste> getListePsDiffDmpCp() {
		return listePsDiffDmpCp;
	}

	public void setListePsDiffDmpCp(List<VPpmliste> listePsDiffDmpCp) {
		this.listePsDiffDmpCp = listePsDiffDmpCp;
	}



	public List<VPpmliste> getListeCpDiff() {
		return listeCpDiff;
	}


	public void setListeCpDiff(List<VPpmliste> listeCpDiff) {
		this.listeCpDiff = listeCpDiff;
	}


	public List<VPpmliste> getListeCpDiffPs() {
		return listeCpDiffPs;
	}

	public void setListeCpDiffPs(List<VPpmliste> listeCpDiffPs) {
		this.listeCpDiffPs = listeCpDiffPs;
	}



	public TDetailPlanPassation getDetPass() {
		return detPass;
	}


	public void setDetPass(TDetailPlanPassation detPass) {
		this.detPass = detPass;
	}


	/*public long getNbreOuv() {
		return nbreOuv;
	}

	public void setNbreOuv(long nbreOuv) {
		this.nbreOuv = nbreOuv;
	}*/
	
	public String getNbreOuv() {
		return nbreOuv;
	}

	public void setNbreOuv(String nbreOuv) {
		this.nbreOuv = nbreOuv;
	}


	public boolean isPartPpm() {
		return partPpm;
	}

	public void setPartPpm(boolean partPpm) {
		this.partPpm = partPpm;
	}



	public boolean isPartPgpm() {
		return partPgpm;
	}

	public void setPartPgpm(boolean partPgpm) {
		this.partPgpm = partPgpm;
	}



	public boolean isPartPspm() {
		return partPspm;
	}


	public void setPartPspm(boolean partPspm) {
		this.partPspm = partPspm;
	}



	public boolean isPartPgspm() {
		return partPgspm;
	}

	public void setPartPgspm(boolean partPgspm) {
		this.partPgspm = partPgspm;
	}


/*	public boolean isLignedefaut() {
		return lignedefaut;
	}


	public void setLignedefaut(boolean lignedefaut) {
		this.lignedefaut = lignedefaut;
	}
*/


	public boolean isLigneftpgpm() {
		return ligneftpgpm;
	}


	public void setLigneftpgpm(boolean ligneftpgpm) {
		this.ligneftpgpm = ligneftpgpm;
	}




	public boolean isLignepn() {
		return lignepn;
	}

	public void setLignepn(boolean lignepn) {
		this.lignepn = lignepn;
	}



	public boolean isLigneps() {
		return ligneps;
	}


	public void setLigneps(boolean ligneps) {
		this.ligneps = ligneps;
	}

	public boolean isPavetPPM() {
		return pavetPPM;
	}

	public void setPavetPPM(boolean pavetPPM) {
		this.pavetPPM = pavetPPM;
	}

	public boolean isPavetAMI() {
		return pavetAMI;
	}

	public void setPavetAMI(boolean pavetAMI) {
		this.pavetAMI = pavetAMI;
	}

	public boolean isPavetPRQ() {
		return pavetPRQ;
	}

	public void setPavetPRQ(boolean pavetPRQ) {
		this.pavetPRQ = pavetPRQ;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public List<VAmiDp> getListeAmiDp() {
		return listeAmiDp;
	}

	public void setListeAmiDp(List<VAmiDp> listeAmiDp) {
		this.listeAmiDp = listeAmiDp;
	}

	public VAmiDp getRecupAmiDp() {
		return recupAmiDp;
	}

	public void setRecupAmiDp(VAmiDp recupAmiDp) {
		this.recupAmiDp = recupAmiDp;
	}

	public VAmiDp getAmiDp() {
		return amiDp;
	}

	public void setAmiDp(VAmiDp amiDp) {
		this.amiDp = amiDp;
	}

    
	public boolean isLibelleDPAMI() {
		return libelleDPAMI;
	}

	public void setLibelleDPAMI(boolean libelleDPAMI) {
		this.libelleDPAMI = libelleDPAMI;
	}

	public boolean isLibelleDPPRQ() {
		return libelleDPPRQ;
	}

	public void setLibelleDPPRQ(boolean libelleDPPRQ) {
		this.libelleDPPRQ = libelleDPPRQ;
	}

	public List<VPrqAo> getListePrqDp() {
		return listePrqDp;
	}

	public void setListePrqDp(List<VPrqAo> listePrqDp) {
		this.listePrqDp = listePrqDp;
	}

	public VPrqAo getRecupPrqDp() {
		return recupPrqDp;
	}

	public void setRecupPrqDp(VPrqAo recupPrqDp) {
		this.recupPrqDp = recupPrqDp;
	}

	public VPrqAo getPrqDp() {
		return prqDp;
	}

	public void setPrqDp(VPrqAo prqDp) {
		this.prqDp = prqDp;
	}

	public List<VTypeMarcheFils> getListeTypeMarchesFilsPs() {
		return listeTypeMarchesFilsPs;
	}

	public void setListeTypeMarchesFilsPs(List<VTypeMarcheFils> listeTypeMarchesFilsPs) {
		this.listeTypeMarchesFilsPs = listeTypeMarchesFilsPs;
	}

	public boolean isLibelleAmi() {
		return libelleAmi;
	}

	public void setLibelleAmi(boolean libelleAmi) {
		this.libelleAmi = libelleAmi;
	}

	public boolean isLibellePrq() {
		return libellePrq;
	}

	public void setLibellePrq(boolean libellePrq) {
		this.libellePrq = libellePrq;
	}

	public boolean isLibellePpm() {
		return libellePpm;
	}

	public void setLibellePpm(boolean libellePpm) {
		this.libellePpm = libellePpm;
	}

	public boolean isPavetDPAMI() {
		return pavetDPAMI;
	}

	public void setPavetDPAMI(boolean pavetDPAMI) {
		this.pavetDPAMI = pavetDPAMI;
	}

	public boolean isPavetDPPRQ() {
		return pavetDPPRQ;
	}

	public void setPavetDPPRQ(boolean pavetDPPRQ) {
		this.pavetDPPRQ = pavetDPPRQ;
	}

	public boolean isFinPgpm() {
		return finPgpm;
	}

	public void setFinPgpm(boolean finPgpm) {
		this.finPgpm = finPgpm;
	}

	public boolean isFinAmi() {
		return finAmi;
	}

	public void setFinAmi(boolean finAmi) {
		this.finAmi = finAmi;
	}

	public String getFinLib() {
		return finLib;
	}

	public void setFinLib(String finLib) {
		this.finLib = finLib;
	}

	public List<VFinancementPpm> getListeFinancementAmi() {
		return listeFinancementAmi;
	}

	public void setListeFinancementAmi(List<VFinancementPpm> listeFinancementAmi) {
		this.listeFinancementAmi = listeFinancementAmi;
	}

	public boolean isFinPrq() {
		return finPrq;
	}

	public void setFinPrq(boolean finPrq) {
		this.finPrq = finPrq;
	}

	public List<VFinancementPpm> getListeFinancementPrq() {
		return listeFinancementPrq;
	}

	public void setListeFinancementPrq(List<VFinancementPpm> listeFinancementPrq) {
		this.listeFinancementPrq = listeFinancementPrq;
	}

	public boolean isPanelBailleur() {
		return panelBailleur;
	}

	public void setPanelBailleur(boolean panelBailleur) {
		this.panelBailleur = panelBailleur;
	}

	public boolean isPanelAno() {
		return panelAno;
	}

	public void setPanelAno(boolean panelAno) {
		this.panelAno = panelAno;
	}

	public boolean isPanelPgpmNormal() {
		return panelPgpmNormal;
	}

	public void setPanelPgpmNormal(boolean panelPgpmNormal) {
		this.panelPgpmNormal = panelPgpmNormal;
	}

	public boolean isPanelPgpmDp() {
		return panelPgpmDp;
	}

	public void setPanelPgpmDp(boolean panelPgpmDp) {
		this.panelPgpmDp = panelPgpmDp;
	}

	public boolean isPanelTymNormal() {
		return panelTymNormal;
	}

	public void setPanelTymNormal(boolean panelTymNormal) {
		this.panelTymNormal = panelTymNormal;
	}

	public boolean isPanelTymDp() {
		return panelTymDp;
	}

	public void setPanelTymDp(boolean panelTymDp) {
		this.panelTymDp = panelTymDp;
	}

	public VModeleDac getModelDac() {
		return modelDac;
	}

	public void setModelDac(VModeleDac modelDac) {
		this.modelDac = modelDac;
	}

	public boolean isPavetFinancement() {
		return pavetFinancement;
	}

	public void setPavetFinancement(boolean pavetFinancement) {
		this.pavetFinancement = pavetFinancement;
	}

	public String getStatutRetour() {
		return statutRetour;
	}

	public void setStatutRetour(String statutRetour) {
		this.statutRetour = statutRetour;
	}

	public boolean isPanelAnoTech() {
		return panelAnoTech;
	}

	public void setPanelAnoTech(boolean panelAnoTech) {
		this.panelAnoTech = panelAnoTech;
	}

	public List<VExistbailleurPpm> getListeExisteBailleur() {
		return listeExisteBailleur;
	}

	public void setListeExisteBailleur(List<VExistbailleurPpm> listeExisteBailleur) {
		this.listeExisteBailleur = listeExisteBailleur;
	}

	public boolean isPavetPSC() {
		return pavetPSC;
	}

	public void setPavetPSC(boolean pavetPSC) {
		this.pavetPSC = pavetPSC;
	}

	public boolean isLibellePsc() {
		return libellePsc;
	}

	public void setLibellePsc(boolean libellePsc) {
		this.libellePsc = libellePsc;
	}

	public boolean isPscOui() {
		return pscOui;
	}

	public void setPscOui(boolean pscOui) {
		this.pscOui = pscOui;
	}

	public boolean isPscNon() {
		return pscNon;
	}

	public void setPscNon(boolean pscNon) {
		this.pscNon = pscNon;
	}

	public boolean isDaotype() {
		return daotype;
	}

	public void setDaotype(boolean daotype) {
		this.daotype = daotype;
	}

	public boolean isDaotypeMAJ() {
		return daotypeMAJ;
	}

	public void setDaotypeMAJ(boolean daotypeMAJ) {
		this.daotypeMAJ = daotypeMAJ;
	}

	public boolean isLibellePsl() {
		return libellePsl;
	}

	public void setLibellePsl(boolean libellePsl) {
		this.libellePsl = libellePsl;
	}

	public boolean isLibellePsl1() {
		return libellePsl1;
	}

	public void setLibellePsl1(boolean libellePsl1) {
		this.libellePsl1 = libellePsl1;
	}
}
