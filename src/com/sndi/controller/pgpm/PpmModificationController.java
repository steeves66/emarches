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
import com.sndi.model.VAmiDp;
import com.sndi.model.VDatePub;
import com.sndi.model.VDetPlaning;
import com.sndi.model.VFinancementPpm;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VGenerationDate;
import com.sndi.model.VLigneImputation;
import com.sndi.model.VModePassation;
import com.sndi.model.VModePassationPn;
import com.sndi.model.VModeleAmi;
import com.sndi.model.VModeleDac;
import com.sndi.model.VModeleDao;
import com.sndi.model.VPgpmFonction;
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
import com.sndi.report.ProjetReportOld1;
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
	ProjetReportOld1 projetReport;
	 
	 @Autowired
	ControleController controleController;
	
	 @Autowired
	FileUploadController fileUploadController;
	 
	 @Autowired
	 TableauBordController tableauBordController;

	 
	 @Autowired
	 DownloadFileServlet downloadFileServlet;
	 
	 @Autowired
	 PpmController ppmController;

	 @Autowired
	 ConstantService constantService;
	 
	
	 @PostConstruct
	 public void postContr() {
		 controleController.fonctionaliteDynamic();
		 //chargeData();
		 //chargeDataPspm();
		// chargeDataAvaliderPpm();
		 //chargeDataAvaliderPspm();
		 chargeGestions();
		 chargeTypeStrucConduc();
		 chargeBailleur();
		 chargeDevise();
		 chargeFinancement();
		 chargeMarches();
		 chargeModePassation();
		 chargeDatepub();
		 //chargePpmTrans();
		 //chargePspmTrans();
		 //chargePpmValDmp();
		 chargeSourceFinance();
		 //chargeImputation();
		 chargeFonction();
		 chargeTypeCharges();
		 chargeTypeProcedures(); 
		 chargeFonctionDmp();
		 chargeMode();
	 }
	
	 
	     //Déclaration des Listes
	     private List<VAmiDp> listeAmiDp = new ArrayList<VAmiDp>();
	     private List<VPrqAo> listePrqDp = new ArrayList<VPrqAo>();
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
	     private List<VTypeMarcheFils> listeTypeMarchesFils = new ArrayList<VTypeMarcheFils>();
		 private List<TStructure> listeStructure = new ArrayList<TStructure>();
		 private List<VModePassation> listeMode = new ArrayList<VModePassation>();
	     private List<VModeleDao> listeDao = new ArrayList<VModeleDao>();
	     private List<VModeleAmi> listeAmi = new ArrayList<VModeleAmi>();
	     private List<VTypeStructConduc> listeTypStruConduc = new ArrayList<VTypeStructConduc>();
	     private List<VUpdateFinancementPpm> listeupdatefinance = new ArrayList<VUpdateFinancementPpm>();
	     
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
		 private List<VModePassationPn> listeModePassationPn = new ArrayList<VModePassationPn>();
		 private List<VFinancementPpm> listeFinancementAmi = new ArrayList<VFinancementPpm>();
		 private List<VFinancementPpm> listeFinancementPrq = new ArrayList<VFinancementPpm>();
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
	     private List<VDatePub> listeDatePub = new ArrayList<VDatePub>();
	 
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
		 private TDetailPlanPassation passDetail = new TDetailPlanPassation();
		 private TAffichagePpm slctdTdPpm = new TAffichagePpm();
		 private TMinistere ministere= new TMinistere();
		 private TMinistere recupMinistere= new TMinistere();
		 private TFonction recupFonction= new TFonction();
		 private VTypeMarcheFils marche = new VTypeMarcheFils();
		 private VGenerationDate geneDate = new VGenerationDate();
		 //private TTypeMarche reucpMarche = new TTypeMarche();
		 private VTypeMarcheFils reucpMarche = new VTypeMarcheFils();
		 private List<VModeleDac> listeModele = new ArrayList<VModeleDac>();
		 private VLigneImputation ligne = new VLigneImputation();
		 private VLigneImputation recupLigne = new VLigneImputation();
		 private TFinancementPpm newFinancement = new TFinancementPpm();
		 private TFinancementPpm selectFinance = new TFinancementPpm();
		 private TFinancementPgpm fipPgpm = new TFinancementPgpm();
		 private VPpmliste slctdTd = new VPpmliste();
		 //private TModePassation modePassation = new TModePassation();
		 private VModePassationPn modePassation = new VModePassationPn();
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
		 private VDatePub pubDate = new VDatePub();
		 private VModePassation recupModeListe = new VModePassation();
		 private VModePassation passationListe = new VModePassation();
		 private VUpdateFinancementPpm updatefinance =new VUpdateFinancementPpm();
		 private VModeleDac modelDac = new VModeleDac();
		 private VAmiDp recupAmiDp = new VAmiDp();
		 private VPrqAo recupPrqDp = new VPrqAo();
		 private VAmiDp amiDp = new VAmiDp();
		 private VPrqAo prqDp = new VPrqAo();
		
	 
		//Declaration des variables
		 private long gesCode;	
		 private long  totalLigne;
		 private long  totalMontant;
		 private long  totalMontantPpm;
		 private String  nbreOuv;
		 private String  finLib ="DU PGPM";
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
		 private String sourfin ="";
		 private String mode = "";
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
		 public boolean selectBailleur=false;
		 public boolean selectTresor =false;
		 public boolean selectPartBai =false;
		 //Nouveaux
		 private boolean modelePrq =false;
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
	     public boolean libelleDPAMI= false;
	     public boolean libelleDPPRQ= false;
	     public boolean libelleAmi= false;
	     public boolean libellePrq= false;
	     public boolean libellePpm= false;
	     public boolean finPgpm = true;
	     public boolean finAmi = false;
	     public boolean finPrq = false;
	     public boolean panelBailleur = false;
	     public boolean panelAno = false;
	     public boolean panelPgpmNormal = true;
	     public boolean panelPgpmDp = false;
	     public boolean panelTymNormal = true;
	     public boolean panelTymDp = false;
	 
	 
	 
		 public String onFlowProcess(FlowEvent event) {
			//Controle Pavé création pour les ppm / pspm normaux
			 if(event.getOldStep().equals("ope111") && event.getNewStep().equals("ope222")) {
				 bailleurExiste();
				 anoExiste();
				 afficheDate();
				 recupModeleDao();
			     }
			 
			 
			 //Controle Pavé création pour les DPAMI
			 if(event.getOldStep().equals("ope111") && event.getNewStep().equals("dpami")) {
	                    	  if(controleController.type == "PPM") {
	                    		  //controlPanel();
	                    		  afficheDate();
	                    		  bailleurExiste();
	             				  anoExiste();
	                    		  recupModeleDao();
	                    	  }else 
	                    	  {
	                    		 if(controleController.type == "PSPM") {
	                    		     // controlPanelPs(); 
	                    		      afficheDate();
	                    		      bailleurExiste();
	                 				  anoExiste();
	                    		      recupModeleDao();
	                    		     }
	                    	  }
			     }
			 //Fin de Contrôle pour les DPAMI
			 
			 
			//Controle Pavé création pour les DPPRQ
			 if(event.getOldStep().equals("ope111") && event.getNewStep().equals("dpPrq")) {
				 if(controleController.type == "PPM") {
           		  //controlPanel();
           		  afficheDate();
           		  recupModeleDao();
           	  }else 
           	  {
           		 if(controleController.type == "PSPM") {
           		      //controlPanelPs(); 
           		      afficheDate();
           		      recupModeleDao();
           		     }
           	  }
			     }
			//Fin de Contrôle pour les PRQ
			 
		            return event.getNewStep();
		    }
		
		 
		//Gestion des Panels PSPM
		 public void controlPanelPs() {
			 if(updatePpm.getDppMopCode().equalsIgnoreCase("PSC") ) {
				 controleController.etatPsc = true;
				 controleController.etatPsl = false;
				 controleController.etatPso = false;
				 controleController.etatPsl_Pso = false;
			 }else {
				   if(updatePpm.getDppMopCode().equalsIgnoreCase("PSO")) {
					    controleController.etatPsc = false;
						 controleController.etatPsl = false;
						 controleController.etatPso = true;
						 controleController.etatPsl_Pso = true;
				   }else {
					   
					   if(updatePpm.getDppMopCode().equalsIgnoreCase("PSL")) {
						     controleController.etatPsc = false;
							 controleController.etatPsl = true;
							 controleController.etatPso = false;
							 controleController.etatPsl_Pso = true;
					   }
				   }
			 }
		 }
		 
		
		  //Combobox type de structures conductrices
		   public void chargeTypeStrucConduc(){
			   listeTypStruConduc=new ArrayList<>(constantService.getListeTypStruConduc());
			 }
		
		 
		//Liste des Modes de Passation restreint
		 public void chargeMode() { 
			 //listeMode.clear();
		     listeMode=new ArrayList<>(constantService.getListeMode());
		 }
		 
		 
		 //liste des dates de publication
		 public void chargeDatepub() {
			 listeDatePub=new ArrayList<>(constantService.getListeDatePub()); 
		 }
		 
		//Methode de récupération de l'AMI de la DP
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
		 
		//Méthode Love pour les DP
		 public void onSelectAmiDp() {
			 finLib = "DE l'AMI";
			 finPgpm = false;
		     finAmi = true;
		     panelPgpmNormal = false;
		     panelPgpmDp = true;
			 updatePpm.setDppStructureConduc(amiDp.getDppStructureConduc());
			 updatePpm.setDppGpgId(amiDp.getDppGpgId());
			 updatePpm.setDppId(amiDp.getDppId());
			 updatePpm.setGpgObjet(amiDp.getGpgObjet());
			 updatePpm.setDppObjet(amiDp.getDppObjet());
			 updatePpm.setDppTypeStrConduc(amiDp.getDppTypeStrConduc());
			 updatePpm.setDppNbOuv(Long.valueOf(amiDp.getDppNbOuv()));
			 updatePpm.setDppLbgCode(amiDp.getDppLbgCode());
			 updatePpm.setLbgImputation(amiDp.getLbgImputation());
			 updatePpm.setLbgAeTr(amiDp.getLbgAeTr());
			 updatePpm.setLbgAeEmp(amiDp.getLbgAeEmp());
			 updatePpm.setLbgDisTot(amiDp.getLbgDisTot());
			 updatePpm.setNatLibelle(amiDp.getNatLibelle());
			 updatePpm.setLbgTotDot(amiDp.getLbgTotDot());
			 updatePpm.setLbgAeDon(amiDp.getLbgAeDon());
			 
			 List<TDetailPlanPassation> PPM  = iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",Comparateur.EQ,""+amiDp.getDppId()));
				if(!PPM.isEmpty()) detailPass = PPM.get(0);
				
			 listeFinancementAmi.clear();
			 listeFinancementAmi = ((List<VFinancementPpm>)iservice.getObjectsByColumn("VFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
							 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+amiDp.getDppId())));
			 _logger.info("Code de la ligne : "+updatePpm.getLbgCode() +" Imuptation :  "+updatePpm.getLbgImputation());
				}
		 
			//Méthode Love pour les DP
		 public void onSelectPrqDp() {
	
			 finLib = "DE LA PREQUALIFICATION";
			 finPgpm = false;
		     finAmi = false;
		     finPrq = true;
		     panelPgpmNormal = false;
		     panelPgpmDp = true;
			 /*recupPgpm.setGpgObjet(prqDp.getGpgObjet());
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
			 recupLigne.setLbgDisTot(prqDp.getLbgDisTot());*/
			 
			 updatePpm.setDppStructureConduc(prqDp.getDppStructureConduc());
			 updatePpm.setDppGpgId(prqDp.getDppGpgId());
			 updatePpm.setDppId(prqDp.getDppId());
			 updatePpm.setGpgObjet(prqDp.getGpgObjet());
			 updatePpm.setDppObjet(prqDp.getDppObjet());
			 updatePpm.setDppTypeStrConduc(prqDp.getDppTypeStrConduc());
			 updatePpm.setDppNbOuv(Long.valueOf(prqDp.getDppNbOuv()));
			 updatePpm.setDppLbgCode(prqDp.getDppLbgCode());
			 updatePpm.setLbgImputation(prqDp.getLbgImputation());
			 updatePpm.setLbgAeTr(prqDp.getLbgAeTr());
			 updatePpm.setLbgAeEmp(prqDp.getLbgAeEmp());
			 updatePpm.setLbgDisTot(prqDp.getLbgDisTot());
			 updatePpm.setNatLibelle(prqDp.getNatLibelle());
			 updatePpm.setLbgTotDot(prqDp.getLbgTotDot());
			 updatePpm.setLbgAeDon(prqDp.getLbgAeDon());
			 
			 List<TDetailPlanPassation> PPM  = iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",Comparateur.EQ,""+prqDp.getDppId()));
				if(!PPM.isEmpty()) detailPass = PPM.get(0);
				
				 listeFinancementPrq.clear();
				 listeFinancementPrq = ((List<VFinancementPpm>)iservice.getObjectsByColumn("VFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
							 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+prqDp.getDppId()))); 
				 
				 _logger.info("Code de la ligne : "+updatePpm.getLbgCode() +" Imuptation :  "+updatePpm.getLbgImputation());
				}
		 
		//Liste des Modes de Passation restreint
		  public void razchargeMode() {
			listeMode.clear();
			listeMode = ((List<VModePassation>)iservice.getObjectsByColumn("VModePassation",new ArrayList<String>(Arrays.asList("MOP_CODE"))));
			filtreModePassation="";
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
		 public void chargePspmDifDmp() {
			 pspmDifDmp.clear();
			 pspmDifDmp = ((List<TAffichagePpm>)iservice.getObjectsByColumnIn("TAffichagePpm",new ArrayList<String>(Arrays.asList("AFF_DPP_ID")),
					    "AFF_DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SPD")),
					    new WhereClause("AFF_DPP_TYPE_PLAN",Comparateur.EQ,"PS")));
						// new WhereClause("AFF_DPP_MIN_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode())));		 		 
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
		
		//Gestion des Panels
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
					     controleController.etatPsc = false;
						 controleController.etatPsl = true;
						 controleController.etatPso = false;
						 controleController.etatPsl_Pso = true;
				   }
			 }
		 }
		 
		 
		/* public void onSelectModePassationPgspm() {
			 //detailPass.setTModePassation(new TModePassation(passationListe.getMopCode()));
		    updatePpm.setDppMopCode(passationListe.getMopCode());
		    updatePpm.setMopLibelleLong(passationListe.getMopLibelleLong());
		    
		    recupPgspm.setGpgMopCode(passationListe.getMopCode());
		    recupPgspm.setMopLibelleLong(passationListe.getMopLibelleLong());
		    //chargeMode();
				}*/
		 
		 //Methode de sélection du mode de Passation
		 public void onSelectModePassationPgspm() {
			updatePpm.setDppMopCode(passationListe.getMopCode());
			updatePpm.setMopLibelleLong(passationListe.getMopLibelleLong());
		
		    //chargeMode();
		    
		    affichNbreOuvModePs();
		    afficheDateModePs();
		    
		    controleController.lignedefaut= false;
		     ligneftpgpm= false;
		     lignepn= false;
		     ligneps= true;
				}
		//Fin Méthode Love 
		 
	
		//Afficher les dates prévisionnelles en fonction du mode de Passation choisi (Mode PS)
		 public void afficheDateModePs() { 
			 if(passationListe.getMopCode().equalsIgnoreCase("AMI")) {
				 pavetPPM = false;
				 pavetAMI = true;
				 pavetPRQ = false;
				 libelleDPAMI = false;
				 libelleDPPRQ = false;
				 mode ="AMI";
				 _logger.info("Panel AMI Activé: "+pavetAMI);
			 }else {
				      if(passationListe.getMopCode().equalsIgnoreCase("PRQ")) {
				    	     pavetPPM = false;
							 pavetAMI = false;
							 pavetPRQ = true;
							 libelleDPAMI = false;
							 libelleDPPRQ = false;
							 mode ="PRQ";
							 _logger.info("Panel PRQ Activé: "+pavetPRQ);
				    }else 
				    	  if(passationListe.getMopCode().equalsIgnoreCase("DPS")) {
					    	     pavetPPM = false;
								 pavetAMI = true;
								 pavetPRQ = false;
								 libelleDPAMI = true;
								 libelleDPPRQ = false;
								 mode ="DP";
					    }else 
					    	if(passationListe.getMopCode().equalsIgnoreCase("DQS")) {
					    	     pavetPPM = false;
								 pavetAMI = false;
								 pavetPRQ = true;
								 libelleDPAMI = false;
								 libelleDPPRQ = true;
								 mode ="DP";
					    }else
				      {
				    	     pavetPPM = true;
						     pavetAMI = false;
						     pavetPRQ = false;
						     libelleDPAMI = false;
						     libelleDPPRQ = false;
						     mode =" ";
						     _logger.info("Panel PPM Activé: "+pavetPPM);
				    }
			 }
		 }
		 
		 
		/* public void onSelectModePassation() {
			 
		    updatePpm.setDppMopCode(modePassation.getMopCode());
		    updatePpm.setMopLibelleLong(modePassation.getMopLibelleLong());
				}*/
		 
		 //Afficher le nombre d'ouvertures en choisissant le mode de passation (Mode PN)
		 public void affichNbreOuvMode() {
			 if(updatePpm.getDppMopCode().equalsIgnoreCase("AAP")) {
				 nbreOuv = "2"; 
			 }else {
				 nbreOuv = "1"; 
			 }
		 }
		 
		 
		//Afficher le nombre d'ouvertures en choisissant le mode de passation (Mode PS)
		 public void affichNbreOuvModePs() {
			 if(updatePpm.getDppMopCode().equalsIgnoreCase("AAP")) {
				 nbreOuv = "2";
			 }else {
				 nbreOuv = "1"; 
			 }
		 }
		 
		
		 
		 
		//Sélection du mode de Passation
		 public void onSelectModePassation() {
			 updatePpm.setDppMopCode(modePassation.getMopCode());
			 updatePpm.setMopLibelleLong(modePassation.getMopLibelleLong());
			 
			 affichNbreOuvMode();
			 afficheDate() ;
			 controleController.lignedefaut= false;
		     ligneftpgpm= false;
		     lignepn= true;
		     ligneps= false;
		             //Ramener le type marché en fonction du mode de passation
					 listeTypeMarches.clear();
					 if(updatePpm.getDppMopCode().equalsIgnoreCase("AMI")) {
						 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
								 new WhereClause("TYM_CODE",WhereClause.Comparateur.EQ,"11")); 
								 if (!listeTypeMarchesFils.isEmpty()) {
									 marche=listeTypeMarchesFils.get(0); 
									}
								 updatePpm.setDppTymCode(marche.getTymCode());
								 updatePpm.setTymLibelleCourt(marche.getTymLibelleCourt());
								 panelTymNormal =false;
								 panelTymDp=true; 
								 panelPgpmNormal = true;
							     panelPgpmDp = false;
					 }else
						 if(updatePpm.getDppMopCode().equalsIgnoreCase("DPA")) {
							 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
									 new WhereClause("TYM_CODE",WhereClause.Comparateur.EQ,"11")); 
									 if (!listeTypeMarchesFils.isEmpty()) {
										 marche=listeTypeMarchesFils.get(0); 
										}
									 updatePpm.setDppTymCode(marche.getTymCode());
									 updatePpm.setTymLibelleCourt(marche.getTymLibelleCourt());
									 panelTymNormal =false;
									 panelTymDp=true;  
									 panelPgpmNormal = false;
								     panelPgpmDp = true;
						 }else
						 if(updatePpm.getDppMopCode().equalsIgnoreCase("PRQ")) {
							 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
									 new WhereClause("TYM_CODE",WhereClause.Comparateur.NEQ,"11")); 
							 if (!listeTypeMarchesFils.isEmpty()) {
								 marche=listeTypeMarchesFils.get(0); 
								}
							 updatePpm.setDppTymCode(marche.getTymCode());
							 updatePpm.setTymLibelleCourt(marche.getTymLibelleCourt());
							 panelTymNormal =false;
							 panelTymDp=true; 
							 panelPgpmNormal = true;
						     panelPgpmDp = false;
						 }else
							 if(updatePpm.getDppMopCode().equalsIgnoreCase("DPQ")) {
								 listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", 
										 new WhereClause("TYM_CODE",WhereClause.Comparateur.NEQ,"11")); 
								 if (!listeTypeMarchesFils.isEmpty()) {
									 marche=listeTypeMarchesFils.get(0); 
									}
								 updatePpm.setDppTymCode(marche.getTymCode());
								 updatePpm.setTymLibelleCourt(marche.getTymLibelleCourt());
								 panelTymNormal =false;
								 panelTymDp=true; 
								 panelPgpmNormal = false;
							     panelPgpmDp = true;
							 }else
						     {
							 updatePpm.setDppTymCode("");
							 updatePpm.setTymLibelleCourt("");
							 panelTymNormal =true;
							 panelTymDp=false; 
							 panelPgpmNormal = true;
						     panelPgpmDp = false;
						 }
				}
		 
		 
		//Afficher les dates prévisionnelles en fonction du mode de Passation choisi (Mode PN)
		 public void afficheDate() {  
			 if(updatePpm.getDppMopCode().equalsIgnoreCase("AMI")) {
				 pavetPPM = false;
				 pavetAMI = true;
				 pavetPRQ = false;
				 pavetDPAMI= false;
				 pavetDPPRQ= false;
				 
				 libelleDPAMI = false;
				 libelleDPPRQ = false;
			     libelleAmi= true;
			     libellePrq= false;
			     libellePpm= false;
				 
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
							 libelleAmi= false;
						     libellePrq= true;
						     libellePpm= false;
							 libelleAmi= false;
						     libellePrq= true;
							 mode ="PRQ";
				    }else 
				    	  if(updatePpm.getDppMopCode().equalsIgnoreCase("DPA")) {
					    	     pavetPPM = false;
								 pavetAMI = false;
								 pavetPRQ = false;
								 pavetDPAMI= true;
								 pavetDPPRQ= false;
								 libelleDPAMI = true;
								 libelleDPPRQ = false;
								 libelleAmi= false;
							     libellePrq= false;
							     libellePpm= false;
								 mode ="DP";
					    }else 
					    	if(updatePpm.getDppMopCode().equalsIgnoreCase("DPQ")) {
					    	     pavetPPM = false;
								 pavetAMI = false;
								 pavetPRQ = false;
								 pavetDPAMI= false;
								 pavetDPPRQ= true;
								 libelleDPAMI = false;
								 libelleDPPRQ = true;
								 libelleAmi= false;
							     libellePrq= false;
							     libellePpm= false;
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
						     libelleAmi= false;
						     libellePrq= false;
						     libellePpm= true;
						     mode="";
				    }
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
		 
		//Début des méthodes pour les affichages 
			//Combobox Gestions
		/* public void chargeGestions(){
			 listeGestion=(List<TGestion>) iservice.getObjectsByColumnDesc("TGestion", new ArrayList<String>(Arrays.asList("GES_CODE")));	
		 }*/ 
      	 
     	//Combobox Gestions
		 public void chargeGestions(){
			 listeGestion=new ArrayList<>(constantService.getListeGestion());
		 } 
		 
	   //Combobox Bailleur
	  /* public void chargeBailleur() {
		 listeBailleurs.clear();
		 listeBailleurs =(List<TBailleur>) iservice.getObjectsByColumn("TBailleur", new ArrayList<String>(Arrays.asList("baiCode")));
		} */
		 
		 //Combobox Bailleur
		   public void chargeBailleur() {
			   listeBailleurs=new ArrayList<>(constantService.getListeBailleurs());
			} 
		   
		 //Combobox Source de finacement
			 public void chargeSourceFinance() {
				 listeSourceFinance=new ArrayList<>(constantService.getListeSourceFinance());
				}
			//Combobox Devises
			 public void chargeDevise() {
				 listeDevise=new ArrayList<>(constantService.getListeDevise());	
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
		/* public void chargeSourceFinance() {
			 listeSourceFinance.clear();
			 listeSourceFinance =(List<TSourceFinancement>) iservice.getObjectsByColumn("TSourceFinancement", new ArrayList<String>(Arrays.asList("souCode")));
			}
		//Combobox Devises
		 public void chargeDevise() {
			 listeDevise.clear();
			 listeDevise =(List<TDevise>) iservice.getObjectsByColumn("TDevise", new ArrayList<String>(Arrays.asList("devCode")));
			} */
		 
		 
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
				 new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppGpgId()))); 
		//Affichage du coût total de l'opération
		    coutOperation();
	}
	
	
	
	public void filtreImputationCpmp() {
		listeImputations.clear();
		listeImputations = (List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				new WhereClause("LIAE_FON_COD",Comparateur.EQ,fonction.getFonCod()), 
				new WhereClause("LBG_NAT_CODE",WhereClause.Comparateur.LIKE,"%"+filtreLigne+"%"));
	}
		 
	
	//Récupération du modèle DAO type
	 public void recupModeleDao() {
	    			listeModele= (List<VModeleDac>) iservice.getObjectsByColumn("VModeleDac", new ArrayList<String>(Arrays.asList("DPP_ID")),
	    					 new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
	    			/*if (!listeModele.isEmpty()) {
	    				geneDate=listeModele.get(0); 
	    			}*/
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
		_logger.info("ANO: "+detailPass.getDppStatutAno());
		_logger.info("panelAno: "+panelAno);
	 }
	//Fin controle ANO
	 
	 public void controleLibelle() {
		 if(mode=="AMI") {
			 libelleDPPRQ= false;
			 libelleDPAMI= false;
		     libelleAmi= true;
		     libellePrq= false;
		     libellePpm= false;
		 }else
			 if(mode=="PRQ") {
				 libelleDPPRQ= false;
				 libelleDPAMI= false;
			     libelleAmi= false;
			     libellePrq= true;
			     libellePpm= false;
			 }else
				 if(mode=="DPPRQ") {
					 libelleDPPRQ= false;
					 libelleDPAMI= false;
				     libelleAmi= false;
				     libellePrq= true;
				     libellePpm= false; 
				 }else
					 if(mode=="DPAMI") {
						 libelleDPPRQ= false;
						 libelleDPAMI= true;
					     libelleAmi= false;
					     libellePrq= false;
					     libellePpm= false; 
					 }else
					       {
							 libelleDPPRQ= false;
							 libelleDPAMI= false;
						     libelleAmi= false;
						     libellePrq= false;
						     libellePpm= true; 
						 }
		 
	 }
	 
//Fin Nouveau	 
	 
		//Chargement des Types de Marchés
		 /*public void chargeMarches() {
			 listeTypeMarches.clear();
			 listeTypeMarches =(List<TTypeMarche>) iservice.getObjectsByColumn("TTypeMarche", new ArrayList<String>(Arrays.asList("tymCode")));
			}*/
		 
		 public void chargeMarches() {
			 listeTypeMarchesFils=new ArrayList<>(constantService.getListeTypeMarchesFils());
			 //filtreTypeMarche ="";
		 }
		 
		//Chargement des modes de Passtion
		 /*public void chargeModePassation() {
			 listeModePassation.clear();
			 listeModePassation =(List<TModePassation>) iservice.getObjectsByColumn("TModePassation", new ArrayList<String>(Arrays.asList("mopCode")));
			}*/
		 
			//Chargement des modes de Passtion
		 public void chargeModePassation() {
			 listeModePassationPn = new ArrayList<>(constantService.getListeModePassationPn()); 
			 filtreModePassation="";
			}
		 
		//Afficher les financements du projet ou agpm selectionné
		/* public void chargeFinancement() {
			 listeFinancement.clear();
			 listeFinancement = ((List<TFinancementPpm>)iservice.getObjectsByColumn("TFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
						 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+detailPass.getDppId())));		 		 
		 }*/
		 
		 
		//Afficher les financements du projet ou agpm selectionné
		 public void chargeFinancement() {
			 listeFinancement.clear();
			 listeFinancement = ((List<TFinancementPpm>)iservice.getObjectsByColumn("TFinancementPpm",new ArrayList<String>(Arrays.asList("FPP_ID")),
						 new WhereClause("FPP_DPP_ID",Comparateur.EQ,""+updatePpm.getDppId())));		 		 
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
						new WhereClause("TYM_LIBELLE_COURT",WhereClause.Comparateur.LIKE,"%"+filtreTypeMarche+"%"));
		 }
		 
		 
		/*//Filtre les modes de Passtion en fonction du code Passation
		 public void filtreModePassation() {
			 listeModePassation.clear();
			 listeModePassation =(List<TModePassation>) iservice.getObjectsByColumn("TModePassation", new ArrayList<String>(Arrays.asList("mopCode")),
					 new WhereClause("MOP_CODE",WhereClause.Comparateur.LIKE,"%"+filtreModePassation+"%"));
			}*/
		 
		 
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
				
				//Réinitialiser les Types de Marchés
				 public void razchargeMarches() {
					 listeTypeMarchesFils.clear();
					 listeTypeMarchesFils =(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")));
					 filtreTypeMarche ="";
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
           
			 updatePpm.setDppTymCode(marche.getTymCode());
			 updatePpm.setTymLibelleCourt(marche.getTymLibelleCourt());
				}
		 
		 
		 public void onSelectPgpm() {
			 //detailPass.setTDetailPlanGeneral(new TDetailPlanGeneral(pgpm.getGpgId()));
			 detailPass.setDppGpgId(pgpm.getGpgId());
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
			 //detailPass.setTDetailPlanGeneral(new TDetailPlanGeneral(pgspm.getGpgId())); 
			 detailPass.setDppGpgId(pgspm.getGpgId());

			 recupPgspm = new VPgpmFonction();
			 recupPgspm.setGpgObjet(pgspm.getGpgObjet());
			 recupPgspm.setGpgId(pgspm.getGpgId());
			 recupPgspm.setGpgTypePlan(pgspm.getGpgTypePlan());
			 recupPgspm.setGpgCommentaire(pgspm.getGpgCommentaire());
			 //recupPgspm.setGpgNumeroOrdre(pgspm.getGpgNumeroOrdre());
			 //recupPgspm.setGpgDateSaisie(pgspm.getGpgDateSaisie());
			 recupPgspm.setGpgPartiePmePmi(pgspm.getGpgPartiePmePmi());
			 //recupPgspm.setMopLibelleLong(pgspm.getMopLibelleLong());
			 //recupPgspm.setTymLibelleCourt(pgspm.getTymLibelleCourt());
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
			   
			                       }else {
			   			       //Affichage du montant total
			   			       coutOperation();       
			                 }
				     }
		 
		 
		 
		//Methode de suppression de finanacemnt
		 public void deleteFinanacement() {
			iservice.deleteObject(selectFinance); 
			chargeFinancement();
			userController.setTexteMsg("Suppression éffectuée avec succès!");
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
		  
		 
		 public void onSelectPpm() {
			 charge.setTDetailPlanPassation(new TDetailPlanPassation(ppm.getDppId()));
			 
              recuPpm = new TDetailPlanPassation();
			  recuPpm.setDppObjet(ppm.getDppObjet());
			  recuPpm.setDppId(ppm.getDppId());
				}
		 
		 
		 
		 public void onSelectDatePub() {	
				updatePpm.setDppDateAvisAoPublication(pubDate.getDatepub());
			}
		 
		 
		 public void onSelectLigneBudgetaire() { 
			// detailPass.setTLBudgets(new TLBudgets(ligne.getLbgCode()));
	         
			/* recupLigne = new VLigneImputation();
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
			 recupLigne.setLbgTraitmt(ligne.getLbgTraitmt());*/
			 
			 updatePpm.setLbgImputation(ligne.getLbgImputation());
			 updatePpm.setLbgTotDot(ligne.getLbgTotDot());
			 updatePpm.setLbgAeTr(ligne.getLbgAeTr());
			 updatePpm.setLbgAeDon(ligne.getLbgAeDon());
			 updatePpm.setNatLibelle(ligne.getNatLibelle());
			 updatePpm.setLbgDisTot(ligne.getLbgDisTot());
			 
			 //montantOperation();
			 coutOperation(); 
				}
		 
		 /*public void onSelectModePassation() {
			 detailPass.setTModePassation(new TModePassation(modePassation.getMopCode()));
			
			 recupModePassation = new TModePassation();
			 recupModePassation.setMopLibelleLong(modePassation.getMopLibelleLong());
			 recupModePassation.setMopCode(modePassation.getMopCode());
				}*/
		 
		//Réinitialiser les modes de Passation
		 public void razchargeModePassation() {
			 listeModePassationPn.clear();
			 listeModePassationPn =(List<VModePassationPn>) iservice.getObjectsByColumn("VModePassationPn", new ArrayList<String>(Arrays.asList("mopCode")));
			 filtreModePassation="";
			}
		 
		//Filtre les modes de Passtion en fonction du code Passation
		 public void filtreModePassation() {
			 listeModePassationPn.clear();
			 listeModePassationPn =(List<VModePassationPn>) iservice.getObjectsByColumn("VModePassationPn", new ArrayList<String>(Arrays.asList("MOP_CODE")),
					 new WhereClause("MOP_LIBELLE_LONG",WhereClause.Comparateur.LIKE,"%"+filtreModePassation+"%"));
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
	  	 
	  	 
		//Si la source de financement est Etat alors montant en devise = part Trésor
         public void recupTresor() {
         	if(sourfin.equalsIgnoreCase("ETAT")) {
         		newFinancement.fppPartTresor = newFinancement.getFppMontantDevise().longValue();
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
		 
		//Methode d'enregistrement des financements du ppm
		 public void saveFinancementppm() {
			//Récuperons la dernière opération crée et faisons une mis à jour sur sa source de financement
			 List<TDetailPlanPassation> PL =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
						new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
			     TDetailPlanPassation pass = new TDetailPlanPassation();
				 if(!PL.isEmpty()) {pass =PL.get(0);} 
				     
			 
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
		    newFinancement.setTDetailPlanPassation(pass);
			iservice.addObject(newFinancement);
			//Actualisation du coût prévisionnel de l'opération
			coutTotal();
			
			listeTsPpm =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
					new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+detailPass.getDppId()));
			if (!listeTsPpm.isEmpty()) {
				detPass= listeTsPpm.get(0);
				detPass.setDppSourceFin(newFinancement.getFppTypeFinance());
				detPass.setDppMontant(totalMontantPpm);
				iservice.updateObject(detPass);
			}
			
			viderFinancement();
			
			//chargeFinancement();
			chargeFinancementUpdate();
			userController.setTexteMsg("Enregistrement éffectué avec succès!");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
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
			 userController.setTexteMsg("Suppression éffectuée avec succès!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");  
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
			
			//Methodes vider
			 public void viderFinancement() {
				 newFinancement = new TFinancementPpm();
				 devCode ="";
				 baiCode ="";
				 souCode="";
				 sourfin = "";
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
			    }
		 }
		 	 
	  	 
	  	public String fermerPspm(String value ,String action) throws IOException { 
			 userController.initMessage();
		     //chargeDataPspm();
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
							new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+updatePpm.getDppId()));
				 TDetailPlanPassation pass = new TDetailPlanPassation();
					 if(!PL.isEmpty())  
						 pass =PL.get(0); 
					     pass.setDppSourceFin(newFinancement.getTSourceFinancement().getSouCode());
					     iservice.updateObject(pass);
		
			
				//methode qui charge les financements du projet crée
				chargeFinancement();
				//methode qui charge la liste des pgpm
				//chargeData();
				
				//Message de Confirmation
				 userController.setTexteMsg("Financement enregistré avec succès !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
				 viderFinancement();
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
				 
		 		 
		 		 // chargeDataAvaliderPpm();
		 		  //chargePpmValCp();
		 		  //chargePpmValDmp();
		 		  //chargeDataAvaliderPspm();
		 		  //Actualisation du Tableau de Bord
		 		 // tableauBordController.chargeDataPpmPspm();
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
				
				
				//le coût total de l'opération PPM
				  public void coutTotal() {
					 totalMontantPpm = 0;
					 for(TFinancementPpm l : listeFinancement ) {
						 totalMontantPpm = totalMontantPpm+ (l.getFppMontantCfa()+l.getFppPartTresor());
					 }
				 }
				
				
				 //Methode de modification des PPM/PSPM
				 //@Transactional
				 public void modifierDetailPlan() throws IOException{
					 
					 
					 if(controleController.type == "PPM") {
						 List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
					   				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
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
						             detail.setTModeleDacType(new TModeleDacType(updatePpm.getMdtCode()));
						             detail.setDppStructureConduc(updatePpm.getDppStructureConduc());
						             detail.setDppNatInt(updatePpm.getDppNatInt());
						             detail.setDppTypeStrConduc(updatePpm.getDppTypeStrConduc());
						             detail.setDppStatutAno(updatePpm.getDppStatutAno());
						             detail.setDppStructureBenefi(updatePpm.getDppStructureBenefi());
						             detail.setDppObjet(updatePpm.getDppObjet());
						             detail.setDppPartiePmePmi(updatePpm.getDppPartiePmePmi());
						             detail.setDppBailleur(updatePpm.getDppBailleur());
						             //detail.setTModeleDacType(new TModeleDacType(updatePpm.getMdtCode()));
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
						             detail.setDppNbOuv(updatePpm.getDppNbOuv());
						             iservice.updateObject(detail);
						             
						             userController.setTexteMsg(" Modification effectuée avec succès !");
									 userController.setRenderMsg(true);
									 userController.setSevrityMsg("success");
					          
					           }else {
					        	        List<TDetailPlanPassation> PLG =iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
						   				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDppId()));
							            TDetailPlanPassation detail = new TDetailPlanPassation();
										if(!PLG.isEmpty()) detail =PLG.get(0); 
							             //detail.setTDetailPlanGeneral(new TDetailPlanGeneral(updatePpm.getDppGpgId()));
							             detail.setDppGpgId(updatePpm.getDppGpgId());
							             if(marche.getTymCode() == null) {
							             detail.setTTypeMarche(new TTypeMarche(updatePpm.getDppTymCode()));	 
							             }else {
							             detail.setTTypeMarche(new TTypeMarche(marche.getTymCode()));	 
							             }
							             if(passationListe.getMopCode() == null) {
								         detail.setTModePassation(new TModePassation(updatePpm.getDppMopCode()));	 
								         }else {
								         detail.setTModePassation(new TModePassation(modePassation.getMopCode()));	 	 
								         }
							             detail.setTLBudgets(new TLBudgets(updatePpm.getLbgCode()));
							             detail.setTModeleDacType(new TModeleDacType(updatePpm.getMdtCode()));
							             detail.setDppStructureConduc(updatePpm.getDppStructureConduc());
							             detail.setDppNatInt(updatePpm.getDppNatInt());
							             detail.setDppTypeStrConduc(updatePpm.getDppTypeStrConduc());
							             detail.setDppStatutAno(updatePpm.getDppStatutAno());
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
							             detail.setDppNbOuv(updatePpm.getDppNbOuv());
							             iservice.updateObject(detail);
							             
							             userController.setTexteMsg(" Modification effectuée avec succès !");
										 userController.setRenderMsg(true);
										 userController.setSevrityMsg("success");
					            }
					 
					
							 
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
						     
						     if(controleController.type == "PPM") {
							      //creerDetailPassation();
						    	 ppmController.chargeData("PN");
			                 }else 
			                      if(controleController.type == "PSPM"){
			                    	  ppmController.chargeData("PS");
			                 }
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
				     
					 if(controleController.type == "PPM") {
					      //creerDetailPassation();
				    	 ppmController.chargeData("PN");
	                 }else 
	                      if(controleController.type == "PSPM"){
	                    	  ppmController.chargeData("PS");
	                 }
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
				    	 ppmController.chargeData("PN");
					_logger.info("value: "+value+" action "+action);	
					break;
				case "ppm2":
					chargeGestions();
					chargeBailleur();
					chargeDevise();
					//chargeMarches();
					chargeModePassation();
					chargePgpm();
					chargeSourceFinance();
				break;
				case "ppm4":
					controlPanel();
					editForm();
					chargeFinancementUpdate();
					chargeGestions();
					chargeMarches();
					chargeModePassation();
					chargePgpm();
				break;
				case "pspm1": 
				
	                 ppmController.chargeData("PS");
	                 
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

/*
	public TModePassation getModePassation() {
		return modePassation;
	}

	public void setModePassation(TModePassation modePassation) {
		this.modePassation = modePassation;
	}*/
	



	public VModePassationPn getModePassation() {
		return modePassation;
	}

	public void setModePassation(VModePassationPn modePassation) {
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
	
	
	public List<VTypeStructConduc> getListeTypStruConduc() {
		return listeTypStruConduc;
	}

	public void setListeTypStruConduc(List<VTypeStructConduc> listeTypStruConduc) {
		this.listeTypStruConduc = listeTypStruConduc;
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



	public List<VModePassationPn> getListeModePassationPn() {
		return listeModePassationPn;
	}

	public void setListeModePassationPn(List<VModePassationPn> listeModePassationPn) {
		this.listeModePassationPn = listeModePassationPn;
	}



	public List<VTypeMarcheFils> getListeTypeMarchesFils() {
		return listeTypeMarchesFils;
	}

	public void setListeTypeMarchesFils(List<VTypeMarcheFils> listeTypeMarchesFils) {
		this.listeTypeMarchesFils = listeTypeMarchesFils;
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


	public VDatePub getPubDate() {
		return pubDate;
	}
	public void setPubDate(VDatePub pubDate) {
		this.pubDate = pubDate;
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



	public String getSourfin() {
		return sourfin;
	}

	public void setSourfin(String sourfin) {
		this.sourfin = sourfin;
	}



	public long getTotalMontantPpm() {
		return totalMontantPpm;
	}

	public void setTotalMontantPpm(long totalMontantPpm) {
		this.totalMontantPpm = totalMontantPpm;
	}



	public TDetailPlanPassation getDetPass() {
		return detPass;
	}

	public void setDetPass(TDetailPlanPassation detPass) {
		this.detPass = detPass;
	}



	public boolean isModelePrq() {
		return modelePrq;
	}



	public void setModelePrq(boolean modelePrq) {
		this.modelePrq = modelePrq;
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



	public boolean isFinPrq() {
		return finPrq;
	}



	public void setFinPrq(boolean finPrq) {
		this.finPrq = finPrq;
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



	public List<VAmiDp> getListeAmiDp() {
		return listeAmiDp;
	}

	public void setListeAmiDp(List<VAmiDp> listeAmiDp) {
		this.listeAmiDp = listeAmiDp;
	}



	public List<VPrqAo> getListePrqDp() {
		return listePrqDp;
	}


	public void setListePrqDp(List<VPrqAo> listePrqDp) {
		this.listePrqDp = listePrqDp;
	}


	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}



	public VAmiDp getRecupAmiDp() {
		return recupAmiDp;
	}

	public void setRecupAmiDp(VAmiDp recupAmiDp) {
		this.recupAmiDp = recupAmiDp;
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



	public String getNbreOuv() {
		return nbreOuv;
	}

	public void setNbreOuv(String nbreOuv) {
		this.nbreOuv = nbreOuv;
	}


	public List<VFinancementPpm> getListeFinancementAmi() {
		return listeFinancementAmi;
	}


	public void setListeFinancementAmi(List<VFinancementPpm> listeFinancementAmi) {
		this.listeFinancementAmi = listeFinancementAmi;
	}


	public List<VFinancementPpm> getListeFinancementPrq() {
		return listeFinancementPrq;
	}


	public void setListeFinancementPrq(List<VFinancementPpm> listeFinancementPrq) {
		this.listeFinancementPrq = listeFinancementPrq;
	}


	public String getFinLib() {
		return finLib;
	}


	public void setFinLib(String finLib) {
		this.finLib = finLib;
	}

}
