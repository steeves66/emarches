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
import com.sndi.model.TGestionPgpm;
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
import com.sndi.model.VAcAc;
import com.sndi.model.VAcDmp;
import com.sndi.model.VAcMin;
import com.sndi.model.VAcPf;
import com.sndi.model.VAcPlanGeneral;
import com.sndi.model.VAgpm;
import com.sndi.model.VAgpmFonction;
import com.sndi.model.VAgpmMinistere;
import com.sndi.model.VAgpmliste;
import com.sndi.model.VDetTabBordAgpm;
import com.sndi.model.VDetTabBordPgpm;
import com.sndi.model.VFinancementPgpm;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VModePassation;
import com.sndi.model.VModePassationPn;
import com.sndi.model.VPgpm;
import com.sndi.model.VPgpmGestion;
import com.sndi.model.VPgpmPub;
import com.sndi.model.VPgpmStatut;
import com.sndi.model.VPgpmliste;
import com.sndi.model.VPpmPub;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.model.VUpdateAgpm;
import com.sndi.model.VUpdatePgpm;
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

	 @Autowired
	 ConstantService constantService;
	 
	
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
		chargeData();	
		//chargeBailleur();
		//chargeDevise();
		//chargeGestions();
		chargePgpmGestions();
		chargeMinisteres();
		chargeFonctionCpm();
		chargeMarches();
		chargeModePassation();
		chargeMode();
		chargeSourceFinance();
		//chargeAgpm();
		//chargeDataAvaliderPgpm();
		//chargeDataAvaliderPgspm();
		chargeDataPgspm();
		chargePgpmTrans();
		chargePgpmDifAc();
		chargePgspmTrans();
		chargePgpmDifDmpAc();
		chargePgspmDifDmpAc();
		chargePgpmValDmp();
		 chargePgspmPubDmp();
		 chargePgpmPubDmp();
		chargePgpmValDmpAc();
		chargePgspmValDmp();
		chargePgspmValDmpAc();
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
	    private List<TDetailPlanGeneral> recupPgpm = new ArrayList<TDetailPlanGeneral>();
	      private List<VPgpmliste> pgpmListe = new ArrayList<VPgpmliste>();
	     private List <VPgpmStatut> pgpmstatutList = new ArrayList<VPgpmStatut>(); 
	     private List<THistoPlanGeneral> listeHisto = new ArrayList<THistoPlanGeneral>();
	     private List<VPgpm> objetListe = new ArrayList<VPgpm>(); 
	     private List<VUpdatePgpm> listUpdate = new ArrayList<VUpdatePgpm>();
	     //private List<TAffichagePgpm> objetList = new ArrayList<TAffichagePgpm>();
	     private List<VPgpmliste> objetList = new ArrayList<VPgpmliste>();
	     private List<TAffichagePgpm> listPgpm = new ArrayList<TAffichagePgpm>();
	     //private List<TAffichagePgpm> listPgspm = new ArrayList<TAffichagePgpm>();
	     private List<VPgpmliste> listPgspm = new ArrayList<VPgpmliste>();
	     //private List<TAffichagePgpm> pgpmTrans = new ArrayList<TAffichagePgpm>();
	     //private List<VPgpmliste> pgpmTrans = new ArrayList<VPgpmliste>();
	     //private List<TAffichagePgpm> pgspmTrans = new ArrayList<TAffichagePgpm>();
	     private List<VPgpmliste> pgspmTrans = new ArrayList<VPgpmliste>();
	     private List<VPgpmliste> pgpmDifAc = new ArrayList<VPgpmliste>();
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
		 private List<VTypeMarcheFils> listeTypeMarchesFils = new ArrayList<VTypeMarcheFils>();
		 private List<VModePassationPn> listeModePassationPn = new ArrayList<VModePassationPn>();
		 private List<TFinancement> listeFinancementAgpm = new ArrayList<TFinancement>();
		 
		 
		 private List<TGestionPgpm> listePgmGest = new ArrayList<TGestionPgpm>();
		 private List<TGestion> listeGestion = new ArrayList<TGestion>();
		 private List<TFinancementPgpm> listeFinancement = new ArrayList<TFinancementPgpm>();
		 private List<VFinancementPgpm> listeFinancementPgpm = new ArrayList<VFinancementPgpm>();
		 private List<TFinancementPgpm> financementListe = new ArrayList<TFinancementPgpm>();
		 //private List<TAffichagePgpm>listSelectionTransmission =new ArrayList<TAffichagePgpm>();
		 private List<VPgpmliste>listSelectionTransmission =new ArrayList<VPgpmliste>();
		 private List<TDossierPlanGeneral> dossListe = new ArrayList<TDossierPlanGeneral>();
		 private TDossierPlanGeneral selectedDossier = new TDossierPlanGeneral();
		 //private List<TAffichagePgpm> validationListe = new ArrayList<TAffichagePgpm>(); 
		 private List<VPgpmliste> validationListe = new ArrayList<VPgpmliste>();
		 private List<VPgpmliste> publicationListe = new ArrayList<VPgpmliste>();
		 //private List<TAffichagePgpm> validationListePgspm = new ArrayList<TAffichagePgpm>();
		 private List<VPgpmliste> validationListePgspm = new ArrayList<VPgpmliste>();
		 //private List<TAffichagePgpm> pgpmValCp = new ArrayList<TAffichagePgpm>();
		 private List<VPgpmliste> pgpmValCp = new ArrayList<VPgpmliste>(); 
	     //private List<TAffichagePgpm> pgpmValDmp = new ArrayList<TAffichagePgpm>();
		 private List<VPgpmliste> pgpmValDmp = new ArrayList<VPgpmliste>();
		 private List<VPgpmliste> pgpmPubDmp = new ArrayList<VPgpmliste>();
		 private List<VPgpmliste> pgspmPubDmp = new ArrayList<VPgpmliste>();
	     //private List<TAffichagePgpm> pgspmValCp = new ArrayList<TAffichagePgpm>();
	     private List<VPgpmliste> pgspmValCp = new ArrayList<VPgpmliste>();
	     //private List<TAffichagePgpm> pgspmValDmp = new ArrayList<TAffichagePgpm>();
	     private List<VPgpmliste> pgspmValDmp = new ArrayList<VPgpmliste>();
	    // private List<TAffichagePgpm> pgpmDifCp = new ArrayList<TAffichagePgpm>();
	     private List<VPgpmliste> pgpmDifCp = new ArrayList<VPgpmliste>();
	     //private List<TAffichagePgpm> pgpmDifDmp = new ArrayList<TAffichagePgpm>();
	     private List<VPgpmliste> pgpmDifDmp = new ArrayList<VPgpmliste>();
	     //private List<TAffichagePgpm> pgspmDifCp = new ArrayList<TAffichagePgpm>();
	     private List<VPgpmliste> pgspmDifCp = new ArrayList<VPgpmliste>();
	     //private List<TAffichagePgpm> pgspmDifDmp = new ArrayList<TAffichagePgpm>();
	     private List<VPgpmliste> pgspmDifDmp = new ArrayList<VPgpmliste>();
	     private List<TPlanGeneral> listPlan = new ArrayList<TPlanGeneral>();
		 private List<TStructure> listeStructure = new ArrayList<TStructure>();
		 private List<VModePassation> listeMode = new ArrayList<VModePassation>();
		 private List<VAcAc> listeAc = new ArrayList<VAcAc>();
		 private List<VAcDmp> listeAcDmp = new ArrayList<VAcDmp>();
		 private List<VAcMin> listeMinDmp = new ArrayList<VAcMin>();
		 private List<VAcPf> listeCellDmp = new ArrayList<VAcPf>();

	 
	//Declaration des objets
		 private VAcAc recupAc = new VAcAc();
		 private VAcMin recupMin = new VAcMin();
		 private VAcPf recupCell = new VAcPf();
		 private TPlanGeneral plan = new TPlanGeneral();
		 //private VPgpmGestion objetGestion = new VPgpmGestion();
		 private TGestion objetGestion = new TGestion();
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
		 //private TFinancementPgpm selectFinance = new TFinancementPgpm();
		 private VFinancementPgpm selectFinance = new VFinancementPgpm();
		 private List<VDetTabBordPgpm> detailTB = new ArrayList<VDetTabBordPgpm>();
		 
		 private VFinancementPgpm selectFinancePg = new VFinancementPgpm();
		 //private TAgpm agpm = new TAgpm();
		 private VAgpmFonction agpm = new VAgpmFonction();
		 private THistoPlanGeneral histoPgpm = new THistoPlanGeneral();
		 //private TAgpm recupAgpm = new TAgpm();
		 private VAgpmliste recupAgpm = new VAgpmliste();
		 private TDetailPlanGeneral demDetail = new TDetailPlanGeneral();
		 //private TAffichagePgpm slctdTd = new TAffichagePgpm();
		 private VPgpmliste slctdTd = new VPgpmliste();
		 private TMinistere ministere= new TMinistere();
		 private TMinistere recupMinistere= new TMinistere();
		 private TFonction recupFonction= new TFonction();
		 private TStructure structure= new TStructure();
		 private TStructure recupStructure= new TStructure(); 
		 private TFinancement finAgpm = new TFinancement();
		 private VPgpmliste varPgpm = new VPgpmliste();
		 private List<VPgpmPub> pgpmPub = new ArrayList<VPgpmPub>();
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
		 private String statutPub="";
		 private String statutTrans ="";
		 private String finBaiCaode ="ETAT";
		 private String multiFiltre="";
		 public boolean selectBailleur=false;
		 private String sourfin;
		 private String dateToday;
		 private String plgFonCod="";
		 private String minCode="";
		 private String fonCodePf="";
		 private String plgFonCodAc="";
		 
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
		    			listUpdate= (List<VUpdatePgpm>) iservice.getObjectsByColumn("VUpdatePgpm", new ArrayList<String>(Arrays.asList("GPG_ID")),
		    					 new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()));
		    			if (!listUpdate.isEmpty()) {
		    				updateOperation=listUpdate.get(0); 
		    			}
		 }
		 
		//Methode de récupération de t_pgpm dans v_pgpmliste
		/* public void recupForm() {
			 recupPgpm= (List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
		    					 new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()));
		    			if (!recupPgpm.isEmpty()) {
		    				detailPlan=recupPgpm.get(0); 
		    			}
		 }*/
		 
		 //Afficher les financements du projet ou agpm selectionné
		 public void chargeFinancementUpdate() {
			 listeFinancementPgpm.clear();
			 listeFinancementPgpm = ((List<VFinancementPgpm>)iservice.getObjectsByColumn("VFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+slctdTd.getGpgId())));		 		 
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
			 updateOperation.setGpgAgpId(slctdTd.getGpgAgpId());
			 updateOperation.setGpgCommentaire(updateOperation.getGpgCommentaire());
	
			 listeFinancementAgpm =(List<TFinancement>) iservice.getObjectsByColumn("TFinancement", new ArrayList<String>(Arrays.asList("FIN_ID")),
				     new WhereClause("FIN_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgAgpId()));
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
		
		//Methode de suppression de l'operation
		     public void deleteOperation() {
		    	 List<TDetailPlanGeneral> PGPM  = iservice.getObjectsByColumn("TDetailPlanGeneral", new WhereClause("GPG_ID",Comparateur.EQ,""+slctdTd.getGpgId()));
		    	 TDetailPlanGeneral detplanG = new TDetailPlanGeneral();
					if(!PGPM.isEmpty()) detplanG = PGPM.get(0);
					detplanG.setTStatut(new TStatut("SDS"));
			        iservice.updateObject(detplanG);
			        historiser("SDS",detplanG,"Opération supprimée par l'autaurite contractante");
			        //tableauBordbAc();
			        chargeData();
			    	userController.setTexteMsg("Supression effectuée avec succès !");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success"); 
		     }
		     
		   //Methode de suppression de l'operation
		     public void deleteOperationPg() {
		    	 List<TDetailPlanGeneral> PGPM  = iservice.getObjectsByColumn("TDetailPlanGeneral", new WhereClause("GPG_ID",Comparateur.EQ,""+slctdTd.getGpgId()));
		    	 TDetailPlanGeneral detplanG = new TDetailPlanGeneral();
					if(!PGPM.isEmpty()) detplanG = PGPM.get(0);
					detplanG.setTStatut(new TStatut("SDS"));
			        iservice.updateObject(detplanG);
			        historiser("SDS",detplanG,"Opération supprimée par l'autaurite contractante");
			        //tableauBordbAc();
			        chargeDataPgspm();
			    	userController.setTexteMsg("Supression effectuée avec succès !");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success"); 
		     }
		     
		     
		 
		 public void chargeData(){
			 getObjetList().clear();
			 objetList = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")), 
					"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SDR")),
					new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
					//new WhereClause("PLG_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
					new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("objetListe size: "+objetList.size());	
				//tableauBordController.ChargeTbProcedure("PN","PGPM");
				tableauBordController.chargeDataPgpm();
				//typeActionTb();
				nbrePgpm =""+getNbrePgpmTotal("S1S");
		}
		 
		 public int getNbrePgpmTotal(String src1){
				int i = iservice.countTableByColumnIn("V_PGPMLISTE", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
						"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1)),
						new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
						new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
		 
		 public int getNbrePgspmTotal(){
				int i = iservice.countTableByColumn("V_PGPMLISTE", "GPG_ID",
						new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
						new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
		 
		 public void chargeDataPgspm(){
			 getListPgspm().clear();
			 listPgspm = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")), 
					"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","PGD")),
					new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
					//new WhereClause("PLG_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
					new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("listPgspm size: "+listPgspm.size());	
				//tableauBordController.ChargeTbProcedure("PS","PGPM");
				tableauBordController.chargeDataPgspm();
				//typeActionTb();
				nbrePgspm =""+getNbrePgspmTotal();
		}
		 
	
		 
		 //PGPM
		/* public void chargeDataAvaliderPgpm() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else 
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 getValidationListe().clear();
					 validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_DTE_MODIF")),
								"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
								new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
							_logger.info("affichageListe size: "+validationListe.size());
							tableauBordController.chargeDataPgpm();
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
								validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_DTE_MODIF")),
										"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
										new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
								
								tableauBordController.chargeDataPgpm();
								_logger.info("affichageListe size: "+validationListe.size());	
					 }else
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						 getValidationListe().clear();
							validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_DTE_MODIF")),
									"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
									new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
							tableauBordController.chargeDataPgpm();
							_logger.info("affichageListe size: "+validationListe.size());	
				 }   
			   
			 }*/
		 
		 public void onSelectAc() {
			 recupAc.setPlgFonCod(plgFonCod);
			 recupAc.setLibac(recupAc.getLibac());
			 chargeFilterAcDmp("PN");
			}
		 
		 public void onSelectMin() {
			 recupMin.setMinCode(minCode);
			 recupMin.setLibmin(recupMin.getLibmin());
			 chargeFilterMinistereDmp("PN",""+recupMin.getMinCode());
			 _logger.info("code Min: "+minCode);  
			}
		 
		 public void onSelectCell() {
			 recupCell.setFonCodePf(fonCodePf);
			 recupCell.setLibpf(recupCell.getLibpf());
			 chargeFilterCelluleDmp("PN");
			}
		 
		 public void chargeAcCombobox() {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 chargecomboboxAcAc();	
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
						 chargecomboboxAcPf();
					 }else 
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")
								 ||userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							 //minCode="tout";
							 //fonCodePf ="tout";
							 chargecomboboxAcDmp();
							 chargecomboboxMinDmp();
							 chargecomboboxCellDmp();
							 chargeAllCellDmp();
						 }
						 
				
		 }
		 
		 
		 public void chargecomboboxAcAc() {
			 listeAc.clear();
			 listeAc=(List<VAcAc>) iservice.getObjectsByColumn("VAcAc",
					 new WhereClause("FON_TYF_CODAC",WhereClause.Comparateur.EQ,"ACR"),
					 new WhereClause("FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			 _logger.info("listeAc size: "+listeAc.size());  
			 _logger.info("fonCodeAc: "+userController.getSlctd().getTFonction().getFonCod()); 	 
		 }
		 
		
		 public void chargecomboboxAcPf() {
			 //plgFonCod=" ";
			 chargeAllAcBypf();	
			 if(plgFonCod.equalsIgnoreCase(" ")) {
				 chargeAllplgbyCell("PN"); 
				 chargeAllAcBypf();	
			 }else
			 {
				 chargePlgByAcCpmp("PN",""+plgFonCod);
			 }
			 
		 }
		 
		 //Afficher les PGPM et PGSPM en fonction de de l'AC selectionné
		public void chargePlgByAcCpmp(String typePlan,String plgFonCod) {
				 validationListe.clear();
				 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
							"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
							new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.LIKE,"%"+plgFonCod+"%"),
							new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
					_logger.info("validationListe size: "+validationListe.size()); 	
					_logger.info("fonCodeAc: "+plgFonCod); 
					
		}
		 
		 
		 
		 
		 //Afficher les PGPM ET PGSPM en fonction du point focal connecté
		 public void chargeAllplgbyCell(String typePlan) {
			 plgFonCod=" ";
			 minCode=" ";
				 validationListe.clear();
				 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
							"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
							new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
					_logger.info("validationListe size: "+validationListe.size()); 		 
		 }
		 
		 //Afficher les PGPM ET PGSPM en fonction de l'AC passé en selectionné
		 public void chargePlgbyAc(String typePlan, String plgFonCod) {
			 plgFonCod=" ";
				 validationListe.clear();
				 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
							"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
							new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
					_logger.info("validationListe size: "+validationListe.size()); 		 
		 }
		 
		 
		//Afficher les AC du point focal connecté
		 public void chargeAllAcBypf() {
			 listeAc.clear();
			 listeAc=(List<VAcAc>) iservice.getObjectsByColumn("VAcAc",
					 new WhereClause("FON_TYF_CODPF",WhereClause.Comparateur.EQ,"CPM"),
					 new WhereClause("FON_CODE_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			 _logger.info("listeAc size: "+listeAc.size());  
			 _logger.info("fonCodePf: "+userController.getSlctd().getTFonction().getFonCod()); 
		 }
		 
		 public void chargecomboboxAcDmp() {
			 chargeAllAcDmp();	
			 if(plgFonCodAc.equalsIgnoreCase(" ")) {
				 chargeAllAcDmp();	
				 chargeAllCellDmp();
				 chargeAllMinDmp();
				 chargeAllPlg("PN");
			 }else
		      {
				 chargePgByAc("PN",""+plgFonCodAc);
				 } 	 
		 }
		 
		 
		 //Filtrer les PGPM et PGSPM en fonction de l'AC selectiooné
		 public void chargePgByAc(String typePlan,String plgFonCodAc) {
			 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
						new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.LIKE,"%"+plgFonCodAc+"%"),
						new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
				_logger.info("validationListe size: "+validationListe.size());  
		 }
		 
		 //Charger tout les Ac de la DMP
		 public void chargeAllAcDmp() {
			 listeAc.clear();
			 listeAc=(List<VAcAc>) iservice.getObjectsByColumn("VAcAc",
					 new WhereClause("FON_TYF_CODDMP",WhereClause.Comparateur.EQ,"DMP"));
			 _logger.info("listeAcDmp size: "+listeAcDmp.size()); 	 
		 }
		 
		 //Filtre combobox ministere
		 public void chargecomboboxMinDmp() {
			 if(minCode.equalsIgnoreCase("tout")) {
				 chargeAllMinDmp();
			 }else
			 {
			   chargecomboboxMinByCellDmp(""+plgFonCod);
			 }  	 
		 }
		 
		 //Filtre combobox cellule de passation
		 public void chargecomboboxCellDmp() {
			 chargeAllCellDmp();
			 if(plgFonCod.equalsIgnoreCase(" ")) {
				 chargeAllPlg("PN");
				 chargecomboboxAcDmp();
				 chargeAllMinDmp();
				 chargeAllCellDmp();
			 }else
			 {
				 chargecomboboxMinByCellDmp(""+plgFonCod); 
				 chargePgpmByMinistere("PN",""+minCode);
				 chargecomboboxPgByCellDmp("PN",""+plgFonCod);
				 chargecomboboxAcByCell(""+plgFonCod);
			 }  	 
		 }
		 
		 
		 
		 //Filtre la combobox Ac par cellule passé en parametre
		 public void chargecomboboxAcByCell(String plgFonCod) { 
			 listeAc=(List<VAcAc>) iservice.getObjectsByColumn("VAcAc",
					 new WhereClause("FON_CODE_PF",WhereClause.Comparateur.LIKE,"%"+plgFonCod+"%"),
					 new WhereClause("FON_TYF_CODDMP",WhereClause.Comparateur.EQ,"DMP"));
			 _logger.info("listeAcDmp size: "+listeAcDmp.size()); 
		 }
		 public void chargecomboboxAcByMin() {  
			 listeAc.clear();
				 listeAc=(List<VAcAc>) iservice.getObjectsByColumn("VAcAc",
						 new WhereClause("FON_TYF_CODDMP",WhereClause.Comparateur.EQ,"DMP"),
				 new WhereClause("MIN_CODE",WhereClause.Comparateur.LIKE,"%"+minCode+"%"));
				 _logger.info("listeAc size: "+listeAc.size()); 
				 _logger.info("ministere: "+minCode);
				 if(minCode.equalsIgnoreCase(" ")) {
					 chargeAllPlg("PN");
					 chargecomboboxAcDmp();
					 chargeAllCellDmp();
				 }else
				 {
					chargePgpmByMinistere("PN",""+minCode);
					chargecomboboxCellByMinDmp(""+minCode);
				 }  
		 }
		 
		 
		 
		 
		 //Filtrer les pgpm par ministere
		 public void chargePgpmByMinistere(String typePlan, String minCode) {
			 validationListe.clear();
			 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
						new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.LIKE,"%"+minCode+"%"),
						new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
				_logger.info("validationListe size: "+validationListe.size()); 
		 }
		 
		 
		 //Afficher tout les ministeres
		 public void chargeAllMinDmp() {
			 //listeMinDmp.clear();
			 listeMinDmp=(List<VAcMin>) iservice.getObjectsByColumn("VAcMin",
					 new WhereClause("FON_TYF_CODDMP",WhereClause.Comparateur.EQ,"DMP"));
			 _logger.info("listeMinDmp size: "+listeMinDmp.size());  
		 }
		 
		 //Filtrer les points focaux par ministere dans la combobox cellule de passation
		 public void chargecomboboxMinByCellDmp(String plgFonCod) {
			 listeMinDmp.clear();
			 listeMinDmp=(List<VAcMin>) iservice.getObjectsByColumn("VAcMin",
					 new WhereClause("FON_TYF_CODDMP",WhereClause.Comparateur.EQ,"DMP"),
					 new WhereClause("FON_CODE_PF",WhereClause.Comparateur.LIKE,"%"+plgFonCod+"%"));
			 _logger.info("listeMinDmp size: "+listeMinDmp.size());	
			 _logger.info("codePf: "+plgFonCod);	
		 }
		 
		 
		 //Filtrer les points focaux par ministere dans la combobox cellule de passation
		 public void chargecomboboxCellByMinDmp(String minCode) {
			 listeCellDmp.clear();
				 listeCellDmp.clear();
				 listeCellDmp=(List<VAcPf>) iservice.getObjectsByColumn("VAcPf",
						 new WhereClause("FON_TYF_CODDMP",WhereClause.Comparateur.EQ,"DMP"),
						 new WhereClause("MIN_CODE",WhereClause.Comparateur.LIKE,"%"+minCode+"%"));
				 _logger.info("listeCellDmp size: "+listeCellDmp.size());	  
		 }
		 
		//Filtrer les plan generau en fonction du point focal passé en parametre
		 public void chargecomboboxPgByCellDmp(String typePlan,String plgFonCod) {
			 validationListe.clear();
			 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
						new WhereClause("GPG_FON_COD_PF",WhereClause.Comparateur.LIKE,"%"+plgFonCod+"%"),
						new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
				_logger.info("validationListe size: "+validationListe.size()); 
				  
		 }
		 
		 
		 //Afficher tout les points focaux dans la combobox cellule de passation
		 public void chargeAllCellDmp() {
			 listeCellDmp.clear();
			 listeCellDmp=(List<VAcPf>) iservice.getObjectsByColumn("VAcPf",
					 new WhereClause("FON_TYF_CODDMP",WhereClause.Comparateur.EQ,"DMP"));
			 _logger.info("listeCellDmp size: "+listeCellDmp.size());
		 }
		 
		 
		 
		 //Filtre love Ministere
		 public void chargeFilterMinistereDmp(String typePlan, String minCode) {
					 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
								"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
								new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.LIKE,"%"+minCode+"%"),
								new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
						_logger.info("validationListe size: "+validationListe.size()); 
		 }
		 
		 //Filtre love Céllulle de passation
		 public void chargeFilterCelluleDmp(String typePlan) {
					 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
								"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
								new WhereClause("GPG_FON_COD_PF",WhereClause.Comparateur.LIKE,"%"+fonCodePf+"%"),
								new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
						_logger.info("validationListe size: "+validationListe.size());  
		 }
		 
		 //Filtre love Céllulle de passation
		 public void chargeFilterAcDmp(String typePlan) {
					 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
								"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
								new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.LIKE,"%"+plgFonCod+"%"),
								new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
						_logger.info("validationListe size: "+validationListe.size());  
		 }
		 
		//Filtrer la liste des PGPM et pgspm en fonction de l'AC selectionné
		public void chargeDataFilter(String typePlan) {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					
			 }else 
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 
					 if(plgFonCod.equalsIgnoreCase("tout")) {
						 validationListe.clear();
						 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
									"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
									new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
									new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
								_logger.info("validationListe size: "+validationListe.size());
								//tableauBordController.ChargeTbProcedure("PN","PGPM");
								//tableauBordController.chargeDataPgpm(); 
					 }else {
						 validationListe.clear();
						 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
									"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
									new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
									new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.LIKE,"%"+plgFonCod+"%"),
									new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
								_logger.info("validationListe size: "+validationListe.size());
								//tableauBordController.ChargeTbProcedure("PN","PGPM");
								//tableauBordController.chargeDataPgpm(); 
					 }
					 
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP") 
							 || userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						 validationListe.clear();
						 
						 if(minCode.equalsIgnoreCase("tout")) {
							 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
										"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
										//new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.LIKE,"%"+minCode+"%"),
										new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
								_logger.info("validationListe size: "+validationListe.size());
							 
						 }else
						 {
							 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
										"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
										new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.LIKE,"%"+minCode+"%"),
										new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
								_logger.info("validationListe size: "+validationListe.size()); 
						 }
						 
						 
						 
						 if(plgFonCod.equalsIgnoreCase("tout")) {
							 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
										"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
										//new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.LIKE,"%"+minCode+"%"),
										new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
								_logger.info("validationListe size: "+validationListe.size());
								chargeAllMinDmp();
							 
						 }else
						 {
							 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
										"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
										new WhereClause("GPG_FON_COD_PF",WhereClause.Comparateur.LIKE,"%"+plgFonCod+"%"),
										new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
								_logger.info("validationListe size: "+validationListe.size()); 
						 }
								
						 chargecomboboxAcByMin();	
						 chargecomboboxCellDmp();
						 chargecomboboxMinDmp();
		
					 }/*else
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							 validationListe.clear();
							validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
									"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
									new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
									//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
							//tableauBordController.ChargeTbProcedure("PN","PGPM");
							//tableauBordController.chargeDataPgpm();
							_logger.info("validationListe size: "+validationListe.size());	
				 }   */
		}
		
		
		public void chargeAllPlg(String typePlan) {
			plgFonCod=" ";
			plgFonCodAc=" ";
			minCode=" ";
			 validationListe.clear();
			 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
						new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan));
				_logger.info("validationListe size: "+validationListe.size()); 	
		}
		 
		//PGPM : Filtre Autorité contractante CPMP ET DMP
		 public void chargeOperateurByAcPgpm() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else 
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 getValidationListe().clear();
					 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
								"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
								new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
							_logger.info("validationListe size: "+validationListe.size());
							//tableauBordController.ChargeTbProcedure("PN","PGPM");
							tableauBordController.chargeDataPgpm();
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
								validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
										"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
										new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
										//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
								//tableauBordController.ChargeTbProcedure("PN","PGPM");
								tableauBordController.chargeDataPgpm();
								_logger.info("validationListe size: "+validationListe.size());	
					 }else
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						 getValidationListe().clear();
							validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
									"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
									new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
									//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
							//tableauBordController.ChargeTbProcedure("PN","PGPM");
							tableauBordController.chargeDataPgpm();
							_logger.info("validationListe size: "+validationListe.size());	
				 }   
			   
			 }
		 
		 
		 
		 
		 
		//PGPM : Nouvelle Methode
		 public void chargeDataAvaliderPgpm() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else 
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 getValidationListe().clear();
					 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
								"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
								new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
							_logger.info("validationListe size: "+validationListe.size());
							//tableauBordController.ChargeTbProcedure("PN","PGPM");
							tableauBordController.chargeDataPgpm();
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
								validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
										"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
										new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
										//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
								//tableauBordController.ChargeTbProcedure("PN","PGPM");
								tableauBordController.chargeDataPgpm();
								_logger.info("validationListe size: "+validationListe.size());	
					 }else
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						 getValidationListe().clear();
							validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
									"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
									new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
									//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
							//tableauBordController.ChargeTbProcedure("PN","PGPM");
							tableauBordController.chargeDataPgpm();
							_logger.info("validationListe size: "+validationListe.size());	
				 }   
			   
			 }
		 
		 
		//PGPM / PGSPM en Attenten de Publication
		 public void chargeDataAPublierPgpm(String typePlan) {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else 
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getPublicationListe().clear(); 
						 publicationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
									new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
							        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"));
						 //tableauBordController.ChargeTbProcedure("PN","PGPM");
						 tableauBordController.chargeDataPgpm();
						 //typeActionTb();
								_logger.info("publicationListe size: "+publicationListe.size());	
					 }else
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						 getPublicationListe().clear(); 
						 publicationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
									new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
							        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"));
						 //tableauBordController.ChargeTbProcedure("PN","PGPM");
						 tableauBordController.chargeDataPgpm();
						 //typeActionTb();
							_logger.info("publicationListe size: "+publicationListe.size());	
				 }   
			   
			 }
		 //Fin Methode Publication
		 
		 //Affichage des PGPM déjà publiés
		 public void chargePgpmPublier() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getPgpmPub().clear(); 
						 pgpmPub = (List<VPgpmPub>) iservice.getObjectsByColumnDesc("VPgpmPub", new ArrayList<String>(Arrays.asList("NUMERO")));
						 //tableauBordController.ChargeTbProcedure("PN","PGPM");
						 tableauBordController.chargeDataPgpm();
						 //typeActionTb();
						 _logger.info("pgpmPub size: "+pgpmPub.size());
					 }else
						  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							  getPgpmPub().clear(); 
								 pgpmPub = (List<VPgpmPub>) iservice.getObjectsByColumnDesc("VPgpmPub", new ArrayList<String>(Arrays.asList("NUMERO")));
								 //tableauBordController.ChargeTbProcedure("PN","PGPM");
								 tableauBordController.chargeDataPgpm();
								 //typeActionTb();
								_logger.info("pgpmPub size: "+pgpmPub.size());
				     }
			     } 
			   }
			 }
		 //Fin de la Methode de Publication des PPM déjà publiés
		 
		 
		//Methode de Gestion des listes de Publication des PPM
		 public void chargePpgmPUB() {
			 String fonct = controleController.getFonctionalite();
			 //DEBUT PPM Publié 
			 if(controleController.type == "PGPM" && controleController.typePlan == "PN") { 
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
					 //Affichage des differentes listes du Chef de Service Procédure en fonction de l'action
						 if(fonct.equalsIgnoreCase("listePgpmAttPub")) {
							chargeDataAPublierPgpm("PN");	
						 }else {
							 if(fonct.equalsIgnoreCase("listePgpmPub")) {
								 //chargeDataAPublier("PN", "S3V");
								 chargePgpmPublier();
							 }else {
								
							 }	 
						 }
			       //Fin affichage SPP
				     }

				 }else{
	                       if(controleController.type == "PGSPM" && controleController.typePlan == "PS") { 
				              if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
					                //Affichage des differentes listes du Chef de Service Procédure en fonction de l'action
						       if(fonct.equalsIgnoreCase("listePgspmAttPub")) {
							        chargeDataAPublierPgpm("PS");	
						        }else {
							       if(fonct.equalsIgnoreCase("listePgspmPub")) {
								       //  chargeDataAPublier("PS", "S3V");
							    	   chargePgpmPublier();
							     }else {
								
							 }	 
						 }
			       //Fin affichage  SPP 
				 }
				}
			}
		}
	//Fin de la Methode de Gestion des listes des publications
		 
		 //Debut Charge detail Compteur de l'AC
		 public void chargeDetailAC1(String typePlan,String typeDac, String stat1){
			 detailTB =(List<VDetTabBordPgpm>) iservice.getObjectsByColumnIn("VDetTabBordPgpm", new ArrayList<String>(Arrays.asList("PGPM_DETID")),
					      "GPG_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre PGPM: "+detailTB.size());	
		}
		 
		 //Debut Charge detail Compteur de l'AC
		 public void chargeDetailAC2(String typePlan,String typeDac, String stat1, String stat2){
			 detailTB =(List<VDetTabBordPgpm>) iservice.getObjectsByColumnIn("VDetTabBordPgpm", new ArrayList<String>(Arrays.asList("PGPM_DETID")),
					      "GPG_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre PGPM: "+detailTB.size());	
		}
		 
		 
		 //Debut Charge detail Compteur de la CPMP
		 public void chargeDetailCP1(String typePlan,String typeDac, String stat1){
			 detailTB =(List<VDetTabBordPgpm>) iservice.getObjectsByColumnIn("VDetTabBordPgpm", new ArrayList<String>(Arrays.asList("PGPM_DETID")),
					      "GPG_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("Nbre PGPM: "+detailTB.size());	
		}
		 
		 //Debut Charge detail Compteur de la CPMP
		 public void chargeDetailCP2(String typePlan,String typeDac, String stat1, String stat2){
			 detailTB =(List<VDetTabBordPgpm>) iservice.getObjectsByColumnIn("VDetTabBordPgpm", new ArrayList<String>(Arrays.asList("PGPM_DETID")),
					      "GPG_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac), 
			              new WhereClause("CODE_PF", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("Nbre PGPM: "+detailTB.size());	
		}
		 
		 
		 //Debut Charge detail Compteur de la DMP
		 public void chargeDetailDMP1(String typePlan,String typeDac, String stat1){
			 detailTB =(List<VDetTabBordPgpm>) iservice.getObjectsByColumnIn("VDetTabBordPgpm", new ArrayList<String>(Arrays.asList("PGPM_DETID")),
					      "GPG_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac));
			             // new WhereClause("CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre PGPM: "+detailTB.size());	
		}
		 
		 //Debut Charge detail Compteur de la DMP
		 public void chargeDetailDMP2(String typePlan,String typeDac, String stat1, String stat2){
			 detailTB =(List<VDetTabBordPgpm>) iservice.getObjectsByColumnIn("VDetTabBordPgpm", new ArrayList<String>(Arrays.asList("AGPM_DETID")),
					      "GPG_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("TYP_PROC",WhereClause.Comparateur.EQ,""+typePlan),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac));
			             // new WhereClause("CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre PGPM: "+detailTB.size());	
		}
		 
		//PGSPM : Nouvelle Methode
		 public void chargeDataAvaliderPgspm() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 getValidationListe().clear();
					 validationListePgspm = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
								"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
								new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
					 //tableauBordController.ChargeTbProcedure("PS","PGPM");
					 tableauBordController.chargeDataPgspm();
					 //typeActionTb();
					_logger.info("validationListePgspm size: "+validationListePgspm.size());		 
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
						 validationListePgspm = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
								 "GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","PGS")),
								new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
								//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						     //tableauBordController.ChargeTbProcedure("PS","PGPM");
						   tableauBordController.chargeDataPgspm();
						   //typeActionTb();
								_logger.info("validationListePgspm size: "+validationListePgspm.size());	
					 }else
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							 getValidationListe().clear();
							 validationListePgspm = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
									 "GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","PGS")),
									new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
									//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
							 //tableauBordController.ChargeTbProcedure("PS","PGPM");
							 tableauBordController.chargeDataPgspm();
							 //typeActionTb();
									_logger.info("validationListePgspm size: "+validationListePgspm.size());	
				 }
					 
			     } 
			   }
			 }
		 
		 
		 //Filtre multicritère pour les PGPM : Nouvelle Methode
			public void chargerPgpmRecherche(String typePlan) { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 getObjetList().clear();
						 objetList = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")), 
								"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
								new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
								new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						        new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
							_logger.info("objetListe size: "+objetList.size());	 
							//tableauBordController.chargeDataPgpm();
							nbrePgpm =""+getNbrePgpmTotal("S1S");
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  getValidationListe().clear();
									 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
												"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
												new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
												new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
											_logger.info("affichageListe size: "+validationListe.size());
											//tableauBordController.chargeDataPgpm();
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getValidationListe().clear();
										validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
												new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
										        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
										        //new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
												new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
										tableauBordController.chargeDataPgpm();
										//typeActionTb();
										_logger.info("affichageListe size: "+validationListe.size());
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  getValidationListe().clear();
											validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
													new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
											        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
											        //new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
													new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
											//tableauBordController.chargeDataPgpm();
											_logger.info("affichageListe size: "+validationListe.size());
							    	  }
			               }
		 //Fin de la methode de Recherche
			
			//Filtre multicritère pour les PGPM : Nouvelle Methode
			public void chargerRecherchePub(String typePlan) { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	 
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getPublicationListe().clear(); 
										 publicationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
													new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
											        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
												    new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
												//tableauBordController.chargeDataPgpm();
										_logger.info("publicationListe size: "+publicationListe.size());
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  getPublicationListe().clear(); 
											 publicationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
														new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
												        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
													    new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
											//tableauBordController.chargeDataPgpm();
											_logger.info("publicationListe size: "+publicationListe.size());
							    	  }
			               }
		 //Fin de la methode de Recherche des PGPM en attente de publication
			
			//Réinitialisation pour les PGPM en attente de Publication : Nouvelle Methode
			public void reinitialiserPgpmPub(String typePlan) { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						multiFiltre =""; 
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
									multiFiltre ="";
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getPublicationListe().clear(); 
										 publicationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
													new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
											        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
												//tableauBordController.chargeDataPgpm();
												_logger.info("publicationListe size: "+publicationListe.size());
										multiFiltre ="";
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  getPublicationListe().clear(); 
											 publicationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
														new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,""+typePlan),
												        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"));
													//tableauBordController.chargeDataPgpm();
													_logger.info("publicationListe size: "+publicationListe.size());
											multiFiltre ="";
							    	  }
			               }
			   //Fin de la réinitialisation de liste des PGPM en attente de publication           
		 
		//Réinitialisation pour les PGPM : Nouvelle Methode
			public void reinitialiserPgpm() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getObjetList().clear();
					 objetList = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")), 
							"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
							new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
							new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("objetListe size: "+objetList.size());	
						//tableauBordController.chargeDataPgpm();
						nbrePgpm =""+getNbrePgpmTotal("S1S");
						multiFiltre ="";
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  getValidationListe().clear();
									 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
												"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
												new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
											_logger.info("validationListe size: "+validationListe.size());
											tableauBordController.chargeDataPgpm();
											multiFiltre ="";
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getValidationListe().clear();
										validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
												"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPG")),
												new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
										      //new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
										//tableauBordController.chargeDataPgpm();
										_logger.info("validationListe size: "+validationListe.size());
										multiFiltre ="";
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  getValidationListe().clear();
											validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
													"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPG")),
													new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"));
													//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
											//tableauBordController.chargeDataPgpm();
											_logger.info("validationListe size: "+validationListe.size());
											multiFiltre ="";
							    	  }
			               }
			              
			//Réinitialisation pour les PGPM : Nouvelle Methode
			public void reinitialiserPgspm() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getObjetList().clear();
					 objetList = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")), 
							"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
							new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
							new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("objetListe size: "+objetList.size());	
						//tableauBordController.chargeDataPgspm();
						nbrePgpm =""+getNbrePgpmTotal("S1S");
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  getValidationListe().clear();
									 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
												"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
												new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
											_logger.info("affichageListe size: "+validationListe.size());
											//tableauBordController.chargeDataPgspm();
											multiFiltre="";
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getValidationListe().clear();
										validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
												"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPG")),
												new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
												//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
										     _logger.info("affichageListe size: "+validationListe.size());
										       //tableauBordController.chargeDataPgspm();
										       multiFiltre="";	
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  getValidationListe().clear();
											validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
													"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPG")),
													new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
													//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
											       _logger.info("affichageListe size: "+validationListe.size());
											       //tableauBordController.chargeDataPgspm();
											       multiFiltre="";	
							    	  }
			               }
			
		     //Historiser
			 public void historiser(String statut,TDetailPlanGeneral TDetailPlanGeneral,String motif) {
					   THistoPlanGeneral histoPlan = new THistoPlanGeneral();
	       			   histoPlan.setHpgDate(Calendar.getInstance().getTime());
	       			   histoPlan.setHpgMotif(motif);
	       			   histoPlan.setTStatut(new TStatut(statut));
	       			   histoPlan.setTDetailPlanGeneral(TDetailPlanGeneral);
	       			   histoPlan.setTFonction(userController.getSlctd().getTFonction());
	       			   histoPlan.setTOperateur(userController.getSlctd().getTOperateur());
	       			   iservice.addObject(histoPlan);
		        }	
			
			//Chargement du Tableau de Bord
			 public void typeActionTb() {
				 if(controleController.type == "PGPM" && controleController.typePlan == "PN") {
					 tableauBordController.ChargeTableauBordPgp("PN","PGP"); 
				 }else {
					 if(controleController.type == "PGSPM" && controleController.typePlan == "PS") {
						 tableauBordController.ChargeTableauBordPgp("PS","PGP");
					 }
				   }
			 }
			
		 //PGSPM
		/* public void chargeDataAvaliderPgspm() {
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
					 }else
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
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
			 }*/
		 
		 
		//Filtre multicritère pour les PGPM
			/*public void chargerPgpmRecherche() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 getObjetList().clear();
						 objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
								"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
								new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
								new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						        new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
							_logger.info("objetListe size: "+objetList.size());	 
							tableauBordController.chargeDataPgpm();
							nbrePgpm =""+getNbrePgpmTotal("S1S");
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
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  getValidationListe().clear();
											validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
													new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
											        new WhereClause("AFF_GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
													new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
											tableauBordController.chargeDataPgpm();
											_logger.info("affichageListe size: "+validationListe.size());
							    	  }
			               }
			*/
			
			//Réinitialisation pour les PGPM
			/*public void reinitialiserPgpm() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getObjetList().clear();
					 objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
							"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
							new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PN"),
							new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("objetListe size: "+objetList.size());	
						tableauBordController.chargeDataPgpm();
						nbrePgpm =""+getNbrePgpmTotal("S1S");
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
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
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
			*/
			
			//Réinitialisation pour les PGPM
			/*public void reinitialiserPgspm() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					getObjetList().clear();
					 objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
							"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
							new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
							new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("objetListe size: "+objetList.size());	
						tableauBordController.chargeDataPgspm();
						nbrePgpm =""+getNbrePgpmTotal("S1S");
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
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  getValidationListe().clear();
											validationListe = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
													"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SPG")),
													new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"));
											_logger.info("affichageListe size: "+validationListe.size());
											       tableauBordController.chargeDataPgspm();
											       multiFiltre="";	
							    	  }
			               }
		 */
		
			
			
			//Tri sur les types de financement  
			public void chargeSourceCheck() { 
		    listeSourceFinance.clear();
			listeSourceFinance=(List<TSourceFinancement>) iservice.getObjectsIn("TSourceFinancement", new ArrayList<String>(Arrays.asList("SOU_CODE")),
			      "SOU_CODE", new ArrayList<String>(Arrays.asList("EMP","DON")));
			newFinancement = new TFinancementPgpm();
				}
			
			//Tri sur les types de financement  
			public void chargeSourceEtat() { 
		    listeSourceFinance.clear();
			listeSourceFinance=(List<TSourceFinancement>) iservice.getObjectsIn("TSourceFinancement", new ArrayList<String>(Arrays.asList("SOU_CODE")),
			      "SOU_CODE", new ArrayList<String>(Arrays.asList("TRE")));
			newFinancement = new TFinancementPgpm();
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
					 newFinancement = new TFinancementPgpm();
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
			
			
			//Filtre multicritère pour les PGSPM : Ancienne Methode
			/*public void chargerPgspmRecherche() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 getObjetList().clear();
						 objetList = (List<TAffichagePgpm>) iservice.getObjectsByColumnInDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")), 
								"AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
								new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
								new WhereClause("AFF_GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						        new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
							_logger.info("objetListe size: "+objetList.size());	 
							tableauBordController.chargeDataPgspm();
							nbrePgpm =""+getNbrePgpmTotal("S1S");
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
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  getValidationListe().clear();
							    		  validationListePgspm = (List<TAffichagePgpm>) iservice.getObjectsByColumnDesc("TAffichagePgpm", new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
													new WhereClause("AFF_GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
											        new WhereClause("AFF_GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
													new WhereClause("AFF_GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
											tableauBordController.chargeDataPgspm();
											_logger.info("validationListePgspm size: "+validationListePgspm.size());
							    	  }
			               }*/
			//Fin Filtre multicritère pour les PGSPM : Ancienne Methode
			
			//Filtre multicritère pour les PGSPM : Nouvelle Methode
			public void chargerPgspmRecherche() { 
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
						 getObjetList().clear();
						 objetList = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")), 
								"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
								new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
								new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						        new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
							_logger.info("objetListe size: "+objetList.size());	 
							tableauBordController.chargeDataPgspm();
							nbrePgpm =""+getNbrePgpmTotal("S1S");
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  getValidationListe().clear();
									 validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnInDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
												"GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
												new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
												new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
											_logger.info("affichageListe size: "+validationListe.size());
											tableauBordController.chargeDataPgspm();
						        }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getValidationListe().clear();
										validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
												new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
										        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
										       // new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCodeDmp()),
												new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
										tableauBordController.chargeDataPgspm();
										_logger.info("affichageListe size: "+validationListe.size());
						    	  }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  getValidationListe().clear();
											validationListe = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
													new WhereClause("GPG_TYPE_PLAN",WhereClause.Comparateur.EQ,"PS"),
											        new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S2V"),
											       // new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCodeDmp()),
													new WhereClause("GPG_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
											tableauBordController.chargeDataPgspm();
											_logger.info("affichageListe size: "+validationListe.size());
							    	  }
			               }
		 //Fin Filtre multicritère pour les PGSPM : Nouvelle Methode
		 
		 
		 public void chargeDataTransmission(){
			 getObjetList().clear();
				objetList = (List<VPgpmliste>) iservice.getObjectsByColumnDesc("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_ID")), 
					new WhereClause("GPG_STA_CODE",WhereClause.Comparateur.EQ,"S1T"),
					new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				tableauBordController.ChargeTbProcedure("PS","PGPM");
				_logger.info("objetListe size: "+objetList.size());	
		}
		 
		 
		//Affichage des motifs de retour
			public void chargerObservation() {
				pgpmstatutList=(List<VPgpmStatut>) iservice.getObjectsByColumn("VPgpmStatut", new ArrayList<String>(Arrays.asList("HPG_GPG_ID")),
						new WhereClause("HPG_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()),
						new WhereClause("HPG_STA_CODE",WhereClause.Comparateur.EQ,slctdTd.getGpgStaCode()));
				if(!pgpmstatutList.isEmpty()) {
					int i=pgpmstatutList.size();
					int baoule=i-1;
					pgpmstatut=pgpmstatutList.get(baoule);
				}	
			}
			
			
		
			 //Liste des Pgpm transmis par l'acteur connecté
			 public void chargePgpmTrans() {
				 pgpmListe.clear();
				 pgpmListe = ((List<VPgpmliste>)iservice.getObjectsByColumnIn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_ID")),
						    "GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","SPG")),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
							 new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
			 }
			 
			 //Liste des Pgpm retournés par l'acteur connecté
			 public void chargePgpmDifDmpAc() {
				 pgpmDifAc.clear();
			     pgpmDifAc = ((List<VPgpmliste>)iservice.getObjectsByColumnIn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_ID")),
						    "GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SDR")),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
							 new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
			 }
			 
			 
			//Liste des Psgpm retournés par l'acteur connecté
			 public void chargePgspmDifDmpAc() {
				 pgpmDifAc.clear();
			     pgpmDifAc = ((List<VPgpmliste>)iservice.getObjectsByColumnIn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_ID")),
						    "GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SDR")),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PS"),
							 new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
			 }
			 
			 //Liste des Pgspm transmis par l'acteur connecté
			 public void chargePgspmTrans() {
				 pgspmTrans.clear();
				 pgspmTrans = ((List<VPgpmliste>)iservice.getObjectsByColumnIn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_ID")),
						    "GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","PGS")),
						     new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PS"),
							 new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
			 }
			 
			 
			 
			 //Liste des Pgpm validés par la CPMP : Ancienne Methode
			/* public void chargePgpmValCp() {
				 pgpmValCp.clear(); 
				 pgpmValCp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S2V"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
							 new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }*/		 		 
			 
			//Liste des Pgpm validés par la CPMP : Nouvelle Methode
			 public void chargePgpmValCp() {
				 pgpmValCp.clear(); 
				 pgpmValCp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_ID")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"S2V"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
						    new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));	 		 
			 }
			 
			 //Liste des Modes de Passation restreint
			 public void chargeMode() { 
				 //listeMode.clear();
			     listeMode=new ArrayList<>(constantService.getListeMode());
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
			 
		 
			//Liste des Pgpm validés par la DMP : Ancienne Methode
			/* public void chargePgpmValDmp() {
				 pgpmValDmp.clear();
				 pgpmValDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN")));		 		 
			 }*/ 
			 

			//Liste des Pgpm validés par la DMP : Nouvelle Methode
			 public void chargePgpmValDmp() {
				 pgpmValDmp.clear();
				 pgpmValDmp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PN")));
						   // new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));
			 }
			 
			//Liste des Pgpm publiés par la DMP : Nouvelle Methode 
			 public void chargePgpmPubDmp() { 
				 pgpmPubDmp.clear();
				 pgpmPubDmp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"PGU"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PN")));
						   // new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));
			 }
			 
			 
			 
			//Liste des Pgpm publiés par la DMP : Nouvelle Methode 
			 public void chargePgspmPubDmp() {
				 pgspmPubDmp.clear();
				 pgspmPubDmp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"PGU"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PS")));
						   // new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));
			 }
			 
			//Liste des Pgpm validés par la DMP Côté AC
			/* public void chargePgpmValDmpAc() { 
				 pgpmValDmp.clear();
				 pgpmValDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("AFF_GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN")));		 		 
			 }*/
			 
			//Liste des Pgpm validés par la DMP Côté AC : Nouvelle Méthode
			public void chargePgpmValDmpAc() {
				 pgpmValDmp.clear();
				 pgpmValDmp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_ID")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PN")));
						    //new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));
			 }
			 
			//Liste des Pgspm validés par la DMP Côté AC : Ancienne Méthode
			 /*public void chargePgspmValDmpAc() {
				 pgspmValDmp.clear();
				 pgspmValDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("AFF_GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS")));		 		 
			 }*/
			 
			//Liste des Pgpm validés par la DMP Côté AC : Nouvelle Méthode
			public void chargePgspmValDmpAc() {
				 pgspmValDmp.clear();
				 pgspmValDmp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PS")));
						   // new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));
			 }
			 
			 
			 //Liste des Pgspm différés par le cpmp : Ancienne Méthode
			 /*public void chargePgpmDifCp() {
				// pgpmDifCp.clear();
				 pgpmDifCp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S2D"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
							 new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }*/
			 
			//Liste des Pgspm différés par la CPMP : Nouvelle Methode
			 public void chargePgpmDifCp() {
				// pgpmDifCp.clear();
				 pgpmDifCp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"S2D"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
						    new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
			 }
			 	
			 
			//Liste des Pgpm différés par la DMP : Ancienne Méthode
			 /*public void chargePgpmDifDmp() {
				// pgpmDifDmp.clear();
				 pgpmDifDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumnIn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						 "AFF_GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SDR")),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PN")));		 		 
			      } */	
			      
			      
			    //Liste des Pgpm différés par la DMP : Nouvelle Methode
					 public void chargePgpmDifDmp() {
						// pgpmDifDmp.clear();
						 pgpmDifDmp = ((List<VPgpmliste>)iservice.getObjectsByColumnIn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
								 "GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SDR")),
								    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PN")));
								    //new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));
					      }
			 
			//Liste des Pgpm différés par la CPMP
			 public void chargePgpmDifAc() { 
				// pgpmDifDmp.clear();
				 pgpmDifDmp = ((List<VPgpmliste>)iservice.getObjectsByColumnIn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						 "GPG_STA_CODE", new ArrayList<String>(Arrays.asList("S2D","SDR")),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PN"),
						    new WhereClause("GPG_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));
						 //new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));
			      }
			 
			 //Liste des Pgspm validés par la CPMP : Ancienne Méthode
			 /*public void chargePgspmValCp() {
				 pgspmValCp.clear();
				 pgspmValCp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S2V"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS"),
							 new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }*/
			 
			 //Liste des Pgspm validés par la CPMP : Nouvelle Methode
			 public void chargePgspmValCp() {
				 pgspmValCp.clear();
				 pgspmValCp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"S2V"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PS"),
							new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }
			 
			 
			//Liste des Pgpm validés par la DMP : Ancienne Méthode
			 /*public void chargePgspmValDmp() {
				 pgspmValDmp.clear();
				 pgspmValDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS")));
							// new WhereClause("AFF_DPP_MIN_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode())));		 		 
			 }*/
			 
			//Liste des Pgpm validés par la DMP : Nouvelle Methode
			 public void chargePgspmValDmp() {
				 pgspmValDmp.clear();
				 pgspmValDmp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"S3V"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PS")));
							//new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
			 }
			 
			 //Liste des Pgspm différés par la CPMP : Ancienne Methode
			 /*public void chargePgspmDifCp() {
				 //pgspmDifCp.clear();
				 pgspmDifCp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S2D"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS"),
							 new WhereClause("AFF_GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }*/
			 
			//Liste des Pgspm différés par la CPMP : Nouvelle Methode
			 public void chargePgspmDifCp() {
				 //pgspmDifCp.clear();
				 pgspmDifCp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"S2D"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PS"),
							new WhereClause("GPG_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
			 }
			 
			 
			//Liste des Pgpm différés par la DMP : Ancienne Methode
			 /*public void chargePgspmDifDmp() {
				 //pgspmDifDmp.clear();
				 pgspmDifDmp = ((List<TAffichagePgpm>)iservice.getObjectsByColumn("TAffichagePgpm",new ArrayList<String>(Arrays.asList("AFF_GPG_ID")),
						    new WhereClause("AFF_GPG_STA_CODE",Comparateur.EQ,"S3D"),
						    new WhereClause("AFF_GPG_TYPE_PLAN",Comparateur.EQ,"PS")));
			 }*/
			 
			 
			//Liste des Pgpm différés par la DMP : Nouvelle methode
			 public void chargePgspmDifDmp() {
				 //pgspmDifDmp.clear();
				 pgspmDifDmp = ((List<VPgpmliste>)iservice.getObjectsByColumn("VPgpmliste",new ArrayList<String>(Arrays.asList("GPG_DTE_MODIF")),
						    new WhereClause("GPG_STA_CODE",Comparateur.EQ,"S3D"),
						    new WhereClause("GPG_TYPE_PLAN",Comparateur.EQ,"PS")));
				           // new WhereClause("GPG_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 		 		 
			 }
			 
	 
	 
		//ACombobox Gestions
		/* public void chargeGestions(){
			 listeGestion=(List<TGestion>) iservice.getObjectsByColumnDesc("TGestion", new ArrayList<String>(Arrays.asList("GES_CODE")));	
		 }*/
			//ACombobox Gestions
			 public void chargeGestions(){
				 listeGestion=new ArrayList<>(constantService.getListeGestion());
			 } 
		 
			 
			//ACombobox Gestions
			 public void chargePgpmGestions(){
				 listePgmGest=new ArrayList<>(constantService.getListePgmGest());
			 }
		/*//ACombobox Gestions
		 public void chargeGestions(){
			 listeGestion=(List<TGestions>) iservice.getObjectsByColumn("TGestion",
					 new WhereClause("GES_COURANT",WhereClause.Comparateur.EQ,"N"));
			 //listeGestion=new ArrayList<>(constantService.getListeGestion());
		 } */
		 
		/* public void recupGestions(){
			 listeGestion=(List<TGestion>) iservice.getObjectsByColumn("TGestion",
					 new WhereClause("GES_COURANT",WhereClause.Comparateur.EQ,"N"));
		                 if (!listeGestion.isEmpty()) {
			                  objetGestion=listeGestion.get(0);
			                  gesCode = Long.valueOf(objetGestion.getGesCode());
			                    } 
		                 _logger.info("Gestion : "+gesCode);
		 } */
		 
		/*//Combobox Bailleur
	  public void chargeBailleur() {
		 listeBailleurs.clear();
		 listeBailleurs =(List<TBailleur>) iservice.getObjectsByColumn("TBailleur", new ArrayList<String>(Arrays.asList("baiCode")));
		}*/
		 
		//Combobox Bailleur
		 public void chargeBailleur() {
			 listeBailleurs=new ArrayList<>(constantService.getListeBailleurs());
			}
	  
	     //Combobox Source de finacement
	    /*public void chargeSourceFinance() {
			 listeSourceFinance.clear();
			 listeSourceFinance =(List<TSourceFinancement>) iservice.getObjectsByColumn("TSourceFinancement", new ArrayList<String>(Arrays.asList("souCode")));
			}
		//Combobox Devises
		 public void chargeDevise() {
			 listeDevise.clear();
			 listeDevise =(List<TDevise>) iservice.getObjectsByColumn("TDevise", new ArrayList<String>(Arrays.asList("devCode")));
			}*/
		 
		 //Combobox Source de finacement
		 public void chargeSourceFinance() {
			 listeSourceFinance=new ArrayList<>(constantService.getListeSourceFinance());
			}
		//Combobox Devises
		 public void chargeDevise() {
			 listeDevise=new ArrayList<>(constantService.getListeDevise());			
			}
		 
		//Chargement des Types de Marchés
		 /*public void chargeMarches() {
			 //listeTypeMarchesFils.clear();
			 listeTypeMarchesFils =(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")));
			 filtreTypeMarche ="";
			}*/
		 
		 public void chargeMarches() {
			 listeTypeMarchesFils=new ArrayList<>(constantService.getListeTypeMarchesFils());
			 //filtreTypeMarche ="";
		 }
		 
		//Réinitialiser les Types de Marchés
		 public void razchargeMarches() {
			 listeTypeMarchesFils.clear();
			 listeTypeMarchesFils =(List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")));
			 filtreTypeMarche ="";
			}
		 
		 
		//Réinitialiser les modes de Passation
		 public void razchargeModePassation() {
			 listeModePassationPn.clear();
			 listeModePassationPn =(List<VModePassationPn>) iservice.getObjectsByColumn("VModePassationPn", new ArrayList<String>(Arrays.asList("mopCode")));
			 filtreModePassation="";
			}
		 
		 
		//Chargement des modes de Passtion
		 public void chargeModePassation() {
			 //listeModePassationPn.clear();
			 listeModePassationPn = new ArrayList<>(constantService.getListeModePassationPn());
			 filtreModePassation="";
			}
		 
		 //Afficher les financements du projet ou agpm selectionné
		 public void chargeFinancement() {
			 listeFinancement.clear();
			 listeFinancement = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+detailPlan.getGpgId())));		 		 
		 }
		 
		//Afficher les financements du projet ou agpm selectionné
		 public void chargeFinancementPgpm() {
			 listeFinancementPgpm.clear();
			 listeFinancementPgpm = ((List<VFinancementPgpm>)iservice.getObjectsByColumn("VFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+detailPlan.getGpgId())));		 		 
		 }
		 
		 //Afficher les financements du projet ou agpm selectionné
		 public void chargeFinancementDetail() {
			 financementListe.clear();
			 financementListe = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_GPG_ID",Comparateur.EQ,""+slctdTd.getGpgId())));		 		 
		 }
		 
		//Afficher les Agpm : Nouvelle Methode : Ancienne Methode
		 /*public void chargeAgpm() {
			 agpmList.clear();
			 agpmList = (List<VAgpmFonction>)iservice.getObjectsByColumnDesc("VAgpmFonction",new ArrayList<String>(Arrays.asList("AGP_ID")),
					     new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
					     new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						 new WhereClause("AGP_ACTIF",Comparateur.EQ,"1"));
			 if (!agpmList.isEmpty()) {
				  agpm=agpmList.get(0);
				    } 
		 }*/
		 
		 //Afficher les Agpm : Nouvelle Methode
		public void chargeAgpm() {
			 agpmList.clear();
			 agpmList = (List<VAgpmFonction>)iservice.getObjectsByColumnDesc("VAgpmFonction",new ArrayList<String>(Arrays.asList("AGP_ID")),
					     new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
					     new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					    // new WhereClause("AGP_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCodeDmp()),
						 new WhereClause("AGP_ACTIF",Comparateur.EQ,"1"));
			 if (!agpmList.isEmpty()) {
				  agpm=agpmList.get(0);
				    } 
		 }
		 
		//Filtre des AGPM validés par la DMP de l'AC Connectée : Ancienne Methode
		/* public void filtreAgpm() {
			 agpmList.clear();
			 agpmList = (List<VAgpmFonction>)iservice.getObjectsByColumnDesc("VAgpmFonction",new ArrayList<String>(Arrays.asList("AGP_ID")),
				     new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
				     new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					 new WhereClause("AGP_ACTIF",Comparateur.EQ,"1"),
					 new WhereClause("PRO_TITRE",WhereClause.Comparateur.LIKE,"%"+filtreTypeMarche+"%"));
		 }*/
		 
		 //Filtre des AGPM validés par la DMP de l'AC Connectée : Nouvelle Methode
		 public void filtreAgpm() {
			 agpmList.clear();
			 agpmList = (List<VAgpmFonction>)iservice.getObjectsByColumnDesc("VAgpmFonction",new ArrayList<String>(Arrays.asList("AGP_ID")),
				     new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,"S3V"),
				     new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					 new WhereClause("AGP_ACTIF",Comparateur.EQ,"1"),
					 //new WhereClause("AGP_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					 new WhereClause("PRO_TITRE",WhereClause.Comparateur.LIKE,"%"+filtreTypeMarche+"%"));
		 }
		 
		 //Filtre les marchés en fonction du code Marché
		 public void filtreMarche() {
			 listeTypeMarchesFils.clear();
			 listeTypeMarchesFils = (List<VTypeMarcheFils>) iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("TYM_CODE")),
						new WhereClause("TYM_LIBELLE_COURT",WhereClause.Comparateur.LIKE,"%"+filtreTypeMarche+"%"));
		 }
		 
		 
		//Filtre les modes de Passtion en fonction du code Passation
		 public void filtreModePassation() {
			 listeModePassationPn.clear();
			 listeModePassationPn =(List<VModePassationPn>) iservice.getObjectsByColumn("VModePassationPn", new ArrayList<String>(Arrays.asList("MOP_CODE")),
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
		 
		 public void onSelectMarcheUpdate() {
			 
			 updateOperation.setGpgTymCode(marche.getTymCode());
			 updateOperation.setTymLibelleCourt(marche.getTymLibelleCourt());
				}
		 
		 
		 public void onSelectAgpm() {
			 detailPlan.setGpgAgpId(agpm.getAgpId());

			 recupAgpm = new VAgpmliste();
			 //recupAgpm.setAgpCommentaire(agpm.getAgpCommentaire());
			 recupAgpm.setProTitre(agpm.getProTitre());
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
		 		for(VPgpmliste ligne : listSelectionTransmission) {
		 			 
		 			//Parcourir la liste et récupérer les demande au statut E1T
		 			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
								new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getGpgId()));
							if (!listeDetail.isEmpty()) 
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
					
							 //Récupération du Statut
		             	    TStatut statuts = constantService.getStatut(statutTrans);
			  				//Historisation des Pgpm
			      			historiser(""+statutTrans,demDetail,"Opération Transmise à la CPMP");
			      		    //Préparation du Tableau de Bord
			      			tableauBordController.saveTempTabord(""+statutTrans, ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), demDetail.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+demDetail.getGpgId());	
			 		   }
		 		      tableauBordController.ChargeTbProcedure("PN", "PGPM");
		 		     //typeActionTb();
				     }
        	
	 		        chargeData(); 	
	 		        chargePgpmTrans();
	 				 //Message de confirmation
					 userController.setTexteMsg("Transmission effectuée avec succès !");
					 userController.setRenderMsg(true);
					 userController.setSevrityMsg("success");
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
		 		for(VPgpmliste ligne : listSelectionTransmission) {
		 			 
		 			//Parcourir la liste et récupérer les demande au statut E1T
		 			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
								new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getGpgId()));
							if (!listeDetail.isEmpty()) 
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
							 //Récupération du Statut
		             	    TStatut statuts = constantService.getStatut(statutTrans);
			  				//Historisation des Pgpm
			      			historiser(""+statutTrans,demDetail,"Opération Transmise à la CPMP");	
			      		    //Préparation du Tableau de Bord
			      		   tableauBordController.saveTempTabord(""+statutTrans, ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), demDetail.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+demDetail.getGpgId());	
			 		   }	
				     }	
	 		       chargeDataPgspm();
	 		      chargePgspmTrans();
	 		      //Message de confirmation
	 		     userController.setTexteMsg(" Transmission effectuée avec succès !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
        }
        
        //Validation par le CPMP DMP
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
	 						 }else {
		 							if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
			 							 statutUpdate ="S3V";
		 						 }
	 						 }
	 				     } 
	 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
		 		for(VPgpmliste ligne : listSelectionTransmission) {
		 			 
		 			//Parcourir la liste et récupérer les demande au statut E1T
		 			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
								new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getGpgId()));
							if (!listeDetail.isEmpty()) 
								demDetail= listeDetail.get(0);
								if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
									 demDetail.setGpgDateValAc(Calendar.getInstance().getTime());
								 }else
									 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
										 demDetail.setGpgDateValCpmp(Calendar.getInstance().getTime());
									 }else
										 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {	
											 demDetail.setGpgDateValDmp(Calendar.getInstance().getTime());
										 }else
											 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {	
												 demDetail.setGpgDateValDmp(Calendar.getInstance().getTime());
											 }
								demDetail.setTStatut(new TStatut(statutUpdate));
								demDetail.setGpgStatutRetour("0");
						       iservice.updateObject(demDetail);
					
							
						       //Récupération du Statut
			             	    TStatut statuts = constantService.getStatut(statutUpdate);
				  				//Historisation des Pgpm
				      			historiser(""+statutUpdate,demDetail,"Opération Validée");
				      		//Préparation du Tableau de Bord
				      			tableauBordController.saveTempTabord(""+statutUpdate, ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), demDetail.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+demDetail.getGpgId());	
		 		           }	   
			 		      }	
				         }
	 		         tableauBordController.chargeDataPgpm();
	 		        chargeDataAvaliderPgpm();
	 		        chargePgpmValCp();
	 		        chargePgpmValDmp();
	 		        //Message de confirmation
	 		        userController.setTexteMsg("Validation effectuée avec succès !");
					 userController.setRenderMsg(true);
					 userController.setSevrityMsg("success");
					}
      //Fin de la Methode de validation
		
	
		//publication par le SPP
		public void publierSPP()throws IOException{ 
	 		if (listSelectionTransmission.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune opération selectionnée", ""));
			}
	 		else{
	 			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
	 				statutPub ="";
	 				 }else {
	 					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
	 						statutPub ="";
	 					 }else {
	 						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
	 							statutPub ="PGU";
	 						 }else {
		 							if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
		 								statutPub ="PGU";
		 						 }
	 						 }
	 				     } 
	 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
		 		for(VPgpmliste ligne : listSelectionTransmission) {
		 			 
		 			//Parcourir la liste et faire la mise à jour 
		 			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
								new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getGpgId()));
							if (!listeDetail.isEmpty()) 
								demDetail= listeDetail.get(0);
								demDetail.setTStatut(new TStatut(statutPub));
								demDetail.setGpgStatutRetour("0");
						       iservice.updateObject(demDetail);
					
						       //Récupération du Statut
			             	    TStatut statuts = constantService.getStatut(statutPub);
				  				//Historisation des Pgpm
				      			historiser(""+statutPub,demDetail,"Opération Publiée");
				      		   //Préparation du Tableau de Bord
				      		  tableauBordController.saveTempTabord(""+statutPub, ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), demDetail.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+demDetail.getGpgId());	
		 		           }	   
			 		      }	
				         }
	 		         
	 		         if(controleController.typePlan == "PGPM") {
	 		        	tableauBordController.chargeDataPgpm();
	 		        	chargeDataAPublierPgpm("PN");
		 		        chargePgpmPubDmp();
	 		         }else {
	 		        	tableauBordController.chargeDataPgspm();
	 		        	chargeDataAPublierPgpm("PS");
		 		        chargePgspmPubDmp();
	 		         }
	 		        
	 		        //Message de confirmation
	 		        userController.setTexteMsg("Publication effectuée avec succès !");
					 userController.setRenderMsg(true);
					 userController.setSevrityMsg("success");
					}
      //Fin de la Methode de publication
		
		
      //Modification des operations PGPM/PGSPM0
     public void modifierDetailPlan() throws IOException{

        if(controleController.type == "PGPM") {
        	//Modification dans TDetailPlanGeneral
       	 List<TDetailPlanGeneral> PLG =iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
      				new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()));
       	 TDetailPlanGeneral detail = new TDetailPlanGeneral();
   				if(!PLG.isEmpty()) detail =PLG.get(0); 
   				detail.setGpgAgpId(updateOperation.getGpgAgpId());
   				if(marche.getTymCode() == null) {
   				detail.setTTypeMarche(new TTypeMarche(updateOperation.getGpgTymCode()));	
   				}else {
   				detail.setTTypeMarche(new TTypeMarche(marche.getTymCode()));	
   				}
   				if(modePassation.getMopCode() == null) {
   				detail.setTModePassation(new TModePassation(updateOperation.getGpgMopCode()));	
   				}else {
   				detail.setTModePassation(new TModePassation(modePassation.getMopCode()));	
   				}
   				detail.setGpgCommentaire(updateOperation.getGpgCommentaire());
   				detail.setGpgDateDao(updateOperation.getGpgDateDao());
   				detail.setGpgLibFin(updateOperation.getGpgLibFin());
   				detail.setGpgObjet(updateOperation.getGpgObjet());
   				detail.setGpgPartiePmePmi(updateOperation.getGpgPartiePmePmi());
   				detail.setTModePassation(new TModePassation(updateOperation.getMopCode()));
   				detail.setTTypeMarche(new TTypeMarche(updateOperation.getGpgTymCode()));
      			 iservice.updateObject(detail);
      			 userController.renderPage("pgpm1");
   		    	 userController.setTexteMsg("Modification éffectuée avec succès!");
   			     userController.setRenderMsg(true);
   			     userController.setSevrityMsg("success");
   			     chargeData();
        }else {
        	//Modification dans TDetailPlanGeneral
       	 List<TDetailPlanGeneral> PLG =iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
      				new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()));
       	 TDetailPlanGeneral detail = new TDetailPlanGeneral();
   				if(!PLG.isEmpty()) detail =PLG.get(0); 
   				detail.setGpgAgpId(updateOperation.getGpgAgpId());
   				if(marche.getTymCode() == null) {
   	   			detail.setTTypeMarche(new TTypeMarche(updateOperation.getGpgTymCode()));	
   	   			}else {
   	   			detail.setTTypeMarche(new TTypeMarche(marche.getTymCode()));	
   	   			}
   				if(passationListe.getMopCode() == null) {
   	   			detail.setTModePassation(new TModePassation(updateOperation.getGpgMopCode()));	
   	   			}else {
   	   			detail.setTModePassation(new TModePassation(passationListe.getMopCode()));	
   	   			}
   				detail.setGpgCommentaire(updateOperation.getGpgCommentaire());
   				detail.setGpgDateDao(updateOperation.getGpgDateDao());
   				detail.setGpgLibFin(updateOperation.getGpgLibFin());
   				detail.setGpgObjet(updateOperation.getGpgObjet());
   				detail.setGpgPartiePmePmi(updateOperation.getGpgPartiePmePmi());
   				detail.setTModePassation(new TModePassation(updateOperation.getMopCode()));
   				detail.setTTypeMarche(new TTypeMarche(updateOperation.getGpgTymCode()));
      			iservice.updateObject(detail);
      			userController.renderPage("pgpm1");
   		    	userController.setTexteMsg("Modification éffectuée avec succès!");
   			    userController.setRenderMsg(true);
   			    userController.setSevrityMsg("success");
   			    chargeData();
        }
      }
          
   
     
      //Enregistrement d'une opération PGPM sans AGPM
      public void creerDetailPlan() throws IOException{
    	  
    	  if(detailPlan.getGpgObjet().equalsIgnoreCase("") || detailPlan.getGpgPartiePmePmi().equalsIgnoreCase("") || detailPlan.getGpgCommentaire().equalsIgnoreCase("") || detailPlan.getGpgLibFin().equalsIgnoreCase("")
    			 ||marche.getTymCode() == null || modePassation.getMopCode() == null ) {
    		  //Message d'erreur
    		  FacesContext.getCurrentInstance().addMessage(null,
	          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir tous les champs obligatoires", ""));
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
             	     detailPlan.setGpgFonCodPf(userController.getSlctd().getTFonction().getFonCodePf());
             	     detailPlan.setGpgFonCodDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
             	     detailPlan.setGpgTypePlan(modePassation.getMopTypPlan());
             	     detailPlan.setTPlanGeneral(plan);
             	     detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
             	     detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
             	     iservice.addObject(detailPlan);
          
             	    //Récupération du Statut
             	    TStatut statuts = constantService.getStatut("S1S");
	  				//Historisation des Pgpm
	      			historiser("S1S",detailPlan,"PGPM crée par l'Autorité Contractante");
	      			//Préparation du Tableau de Bord
	      			tableauBordController.saveTempTabord("S1S", ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), detailPlan.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+detailPlan.getGpgId());

	      			pgpmListe =(List<VPgpmliste>) iservice.getObjectsByColumn("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_ID")),
		  						new WhereClause("GPG_ID", WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
		  					if (!pgpmListe.isEmpty())  
		  						varPgpm =pgpmListe.get(0); 
		  		   String search = varPgpm.getGpgLibFin()+""+varPgpm.getGpgObjet()+""+userController.getSlctd().getTFonction().getFonCod()+""+varPgpm.getGpgActeurSaisie()+""+varPgpm.getGpgTypePlan()+""+varPgpm.getMopCode()+""+varPgpm.getMopLibelleCourt()+""+varPgpm.getTymCode()+""+varPgpm.getTymLibelleCourt()+""+varPgpm.getGpgDateDao();
				   String rechercheAll = search.replace("null","");
				
				   detailPlan.setGpgRecherche(rechercheAll);
				   iservice.updateObject(detailPlan);
				
       			  chargeData();
       			chargeAcCombobox();
       			
       			  userController.setTexteMsg("Opération créée avec succès! veuillez cliquer sur + pour ajouter un financement!");
       			  userController.setRenderMsg(true);
       			  userController.setSevrityMsg("success");
       			
       			  controleController.btn_edit_pgspm = false; 
       			  btnAgpmRappel = false;
       			  loveAgpmRappel = true;
       			  controleController.btn_save_pgpm = false;
       			  controleController.btn_save_pgspm = false;
                 }else {
          	          plan.setTGestion(new TGestion(gesCode)); ///ici
         		      plan.setTFonction(userController.getSlctd().getTFonction());
         		      plan.setTStructure(userController.getSlctd().getTFonction().getTStructure());
         		      iservice.addObject(plan);
          	 
         		      detailPlan.setTStatut(new TStatut("S1S"));
           	          detailPlan.setGpgStatutRetour("0");
           	          detailPlan.setTTypeMarche(new TTypeMarche(marche.getTymCode()));
           	          detailPlan.setTModePassation(new TModePassation(modePassation.getMopCode()));
           	          detailPlan.setGpgAgpId(agpm.getAgpId());
           	          detailPlan.setGpgActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
           	          detailPlan.setGpgFonCodPf(userController.getSlctd().getTFonction().getFonCodePf());
           	          detailPlan.setGpgFonCodDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
           	          detailPlan.setGpgTypePlan(modePassation.getMopTypPlan());
           	          detailPlan.setTPlanGeneral(plan);
           	          detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
           	          detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
           	          iservice.addObject(detailPlan);
           	 
      
           	           TStatut statuts = constantService.getStatut("S1S");
	  				   //Historisation des Pgpm
	      			   historiser("S1S",detailPlan,"PGPM crée par l'Autorité Contractante");
	      			   //Préparation du Tableau de Bord
		      		   tableauBordController.saveTempTabord("S1S", ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), detailPlan.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+detailPlan.getGpgId());

	      			   pgpmListe =(List<VPgpmliste>) iservice.getObjectsByColumn("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_ID")),
		  						new WhereClause("GPG_ID", WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
		  					if (!pgpmListe.isEmpty())  
		  						varPgpm =pgpmListe.get(0); 
		  		      String search = varPgpm.getGpgLibFin()+""+varPgpm.getGpgObjet()+""+varPgpm.getGpgActeurSaisie()+""+varPgpm.getGpgTypePlan()+""+varPgpm.getMopCode()+""+varPgpm.getMopLibelleCourt()+""+varPgpm.getTymCode()+""+varPgpm.getTymLibelleCourt()+""+varPgpm.getGpgDateDao();
				      String rechercheAll = search.replace("null","");
				
				      detailPlan.setGpgRecherche(rechercheAll);
				      iservice.updateObject(detailPlan);
     			
     			      chargeData();
     			     chargeAcCombobox();
     			      userController.setTexteMsg("Opération créée avec succès! veuillez cliquer sur + pour ajouter un financement!");
     			      userController.setRenderMsg(true);
     			      userController.setSevrityMsg("success");
     			
     			      //controleController.btn_edit_pgpm = true;
     			      controleController.btn_edit_pgspm = false;
     			      btnAgpmRappel = false;
     			      loveAgpmRappel = true;
     			      controleController.btn_save_pgpm = false;
           			  controleController.btn_save_pgspm = false;
                   }
    	     }  
        }
      
      
    //Enregistrement d'une opération PGPM pour un AGPM
      @Transactional
      public void creerDetailPlanRappel() throws IOException{
    	  
    	 /* if(finAgpm.getFinId() > 0 ) {*/
    		  
        	  if(detailPlan.getGpgObjet().equalsIgnoreCase("") ||"".equals(detailPlan.getGpgObjet()) || detailPlan.getGpgPartiePmePmi().equalsIgnoreCase("") ||"".equals(detailPlan.getGpgPartiePmePmi()) 
        			  || detailPlan.getGpgCommentaire().equalsIgnoreCase("")|| "".equals(detailPlan.getGpgCommentaire()) || marche.getTymCode() == null || modePassation.getMopCode() == null ) {
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
                 	           detailPlan.setGpgFonCodPf(userController.getSlctd().getTFonction().getFonCodePf());
                               detailPlan.setGpgFonCodDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
                 	           detailPlan.setGpgTypePlan("PN");
                 	           detailPlan.setTPlanGeneral(plan);
                 	           detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
                 	           detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
                 	           iservice.addObject(detailPlan);
                 	 

                 	         TStatut statuts = constantService.getStatut("S1S");
         	  				//Historisation des Pgpm
         	      			historiser("S1S",detailPlan,"PGPM crée par l'Autorité Contractante");

         	      			pgpmListe =(List<VPgpmliste>) iservice.getObjectsByColumn("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_ID")),
         		  						new WhereClause("GPG_ID", WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
         		  					if (!pgpmListe.isEmpty())  
         		  						varPgpm =pgpmListe.get(0); 
         		  		   String search = varPgpm.getGpgLibFin()+""+varPgpm.getGpgObjet()+""+userController.getSlctd().getTFonction().getFonCod()+""+varPgpm.getGpgActeurSaisie()+""+varPgpm.getGpgTypePlan()+""+varPgpm.getMopCode()+""+varPgpm.getMopLibelleCourt()+""+varPgpm.getTymCode()+""+varPgpm.getTymLibelleCourt()+""+varPgpm.getGpgDateDao();
         				   String rechercheAll = search.replace("null","");
         				   //Mis à jour dans le champ recherche
         				   detailPlan.setGpgRecherche(rechercheAll);
         				   iservice.updateObject(detailPlan);
           			       //Chargement de la liste
           			                chargeData();
           			             chargeAcCombobox();
           			       //Message de confirmation
           			                userController.setTexteMsg("Détail enregistré avec succès!");
           			                userController.setRenderMsg(true);
           			                userController.setSevrityMsg("success");
           			
           			                //etatDossier = true;
           			                controleController.btn_edit_pgpm = true; 
           			                controleController.btn_save_pgpm = false;
        			                controleController.btn_save_pgspm = false;
        			                btnAgpmRappel = false;
        			                loveAgpmRappel = true;
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
               	                           detailPlan.setGpgFonCodPf(userController.getSlctd().getTFonction().getFonCodePf());
               	                           detailPlan.setGpgFonCodDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
               	                           detailPlan.setGpgTypePlan("PN");
               	                           detailPlan.setTPlanGeneral(plan);
               	                           detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
               	                           detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
               	                           iservice.addObject(detailPlan);
               	 
               	                          TStatut statuts = constantService.getStatut("S1S");
               	 	  				       //Historisation des Pgpm
               	 	      			      historiser("S1S",detailPlan,"PGPM crée par l'Autorité Contractante");
               	 	      			      //Préparation du Tableau de Bord
               	 		      			  tableauBordController.saveTempTabord("S1S", ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), detailPlan.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+detailPlan.getGpgId());


               	 	      			      pgpmListe =(List<VPgpmliste>) iservice.getObjectsByColumn("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_ID")),
               	 		  						new WhereClause("GPG_ID", WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
               	 		  					if (!pgpmListe.isEmpty())  
               	 		  						varPgpm =pgpmListe.get(0); 
               	 		  		           String search = varPgpm.getGpgLibFin()+""+varPgpm.getGpgObjet()+""+userController.getSlctd().getTFonction().getFonCod()+""+varPgpm.getGpgActeurSaisie()+""+varPgpm.getGpgTypePlan()+""+varPgpm.getMopCode()+""+varPgpm.getMopLibelleCourt()+""+varPgpm.getTymCode()+""+varPgpm.getTymLibelleCourt()+""+varPgpm.getGpgDateDao();
               	 				           String rechercheAll = search.replace("null","");
               	 				
               	 				           detailPlan.setGpgRecherche(rechercheAll);
               	 				           iservice.updateObject(detailPlan);
         			      
         			
         			                       chargeData();
         			                      chargeAcCombobox();
         			                        userController.setTexteMsg("Détail enregistré avec succès!");
         			                        userController.setRenderMsg(true);
         			                        userController.setSevrityMsg("success");
         			
         			                        //etatDossier = true;
         			                        controleController.btn_edit_pgpm = true;
         			                        controleController.btn_save_pgpm = false;
         			                        controleController.btn_edit_pgspm = false; 
                 			                controleController.btn_save_pgpm = false;
              			                    controleController.btn_save_pgspm = false;
              			                    btnAgpmRappel = false;

         			                        vider();
                                  }
        	                  }  
    	  /* }else {
    		  //Message d'erreur
    		  FacesContext.getCurrentInstance().addMessage(null,
	          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Votre AGPM n'a pas de financement", "")); 
    	      }*/
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
      //@Transactional
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
	 						 }else
	 							  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
	 								 statutUpdate ="S3V";
	 							  }
	 				     } 
	 			//Parcourir la liste TAffichagePGPM et faire une mise a jour des different statut
		 		for(VPgpmliste ligne : listSelectionTransmission) {
		 			 
		 			//Parcourir la liste et récupérer les demande au statut E1T
		 			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
								new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+ligne.getGpgId()));
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
										 }else
											 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {	
												 demDetail.setGpgDateValDmp(Calendar.getInstance().getTime());
											 }
								demDetail.setTStatut(new TStatut(statutUpdate));
								demDetail.setGpgStatutRetour("0");
						        iservice.updateObject(demDetail);
							}
			 			
			 			     ////Récupération du Statut
		             	    TStatut statuts = constantService.getStatut(statutUpdate);
			  				//Historisation des Pgpm
			      			historiser(""+statutUpdate,demDetail,"Opération Validée");
			      			
			      			 tableauBordController.chargeDataPgspm();
				 			 chargeDataAvaliderPgspm();
				 			 chargePgspmValCp();
				 		     chargePgspmValDmp();
				 		    chargeAcCombobox();		  
							 userController.setTexteMsg("Validation effectuée avec succès !");
							 userController.setRenderMsg(true);
							 userController.setSevrityMsg("success");
							 //return	null;
		 		        }	   
			 		   }	
				     }
					}
//Fin ValiderPgspmCPMPDMP
		
      //DIFFERER CPMP ET DMP
      //Differer
		 public void differer() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 statutUpdate ="";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 statutUpdate ="S2D";
					 
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						 if(slctdTd.getTstCode().equalsIgnoreCase("02")) {
							 statutUpdate ="S3D"; 
						 }else
							  if(slctdTd.getTstCode().equalsIgnoreCase("03")) {
								  statutUpdate ="SDR";  
							  }else {
								  statutUpdate ="SDR"; 
							  }
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 if(slctdTd.getTstCode().equalsIgnoreCase("02")) {
							 statutUpdate ="S3D"; 
						 }else
							  if(slctdTd.getTstCode().equalsIgnoreCase("03")) {
								  statutUpdate ="SDR";  
							  }else {
								  statutUpdate ="SDR"; 
							  }
					 }
			     } 
			 }
			 
			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
						new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()));
					if (!listeDetail.isEmpty()) {
						demDetail= listeDetail.get(0);
						demDetail.setTStatut(new TStatut(statutUpdate));
						demDetail.setGpgStatutRetour("1");
				        iservice.updateObject(demDetail);
				       
			
			    
			      //chargeData();
			    
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
			     
			   //Préparation du Tableau de Bord
	      		tableauBordController.saveTempTabord(""+statutUpdate, ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), demDetail.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+demDetail.getGpgId());	
				        
					     chargeDataAvaliderPgpm();
					     chargePgpmDifCp();
					     chargePgpmDifDmp();
					     chargeAcCombobox();
			 			 //Chargement du Tableau de Bord
					     tableauBordController.chargeDataPgpm(); 	
					     //typeActionTb();
						
					      userController.setTexteMsg(" Désolé, votre PGPM a été rejeté!");
						  userController.setRenderMsg(true);
						  userController.setSevrityMsg("success");
				  		
                        //}
					}
		 }
		 
		 
		 
		//RéDifferer un PGPM
		 //@Transactional
		 public void reDifferer() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 statutUpdate ="";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 statutUpdate ="S2D";
				 } 
			   }
		
			 
			 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
						new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()));
					if (!listeDetail.isEmpty()) {
						demDetail= listeDetail.get(0);
						demDetail.setTStatut(new TStatut(statutUpdate));
						demDetail.setGpgStatutRetour("1");
				        iservice.updateObject(demDetail);
				  
				        listeHisto =(List<THistoPlanGeneral>) iservice.getObjectsByColumn("THistoPlanGeneral", new ArrayList<String>(Arrays.asList("HPG_ID")),
								new WhereClause("HPG_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()),
								new WhereClause("HPG_STA_CODE",WhereClause.Comparateur.EQ,"S3D"));
					   if (!listeHisto.isEmpty()) 
						   histoPgpm= listeHisto.get(0); 
					   
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
			   //Préparation du Tableau de Bord
		      	tableauBordController.saveTempTabord(""+statutUpdate, ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), demDetail.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+demDetail.getGpgId());	
					   
					}	
				     chargeDataAvaliderPgpm();
				     chargePgpmDifCp();
				     chargePgpmDifDmp();
				     chargeAcCombobox();
				     //Chargement du Tableau de Bord
				     tableauBordController.chargeDataPgpm(); 
				     //typeActionTb();
				     //Message de confirmation
				      userController.setTexteMsg("Désolé, votre PGPM a été rejeté!");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");
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
					 }else
						  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							  statutUpdate ="S3D";
							  
							  if(slctdTd.getTstCode().equalsIgnoreCase("02")) {
						            statutUpdate ="S3D"; 
					            }else
						           if(slctdTd.getTstCode().equalsIgnoreCase("03")) {
							           statutUpdate ="PGD";  
						               }else {
							          statutUpdate ="PGD"; 
						            }
							  
						      }else {
						          if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
							       statutUpdate ="S3D";
							 
							           if(slctdTd.getTstCode().equalsIgnoreCase("02")) {
								            statutUpdate ="S3D"; 
							            }else
								           if(slctdTd.getTstCode().equalsIgnoreCase("03")) {
									           statutUpdate ="PGD";  
								               }else {
									          statutUpdate ="PGD"; 
								            }
						          }
				              } 
				          }
				 
				 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
							new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()));
						if (!listeDetail.isEmpty()) {
							demDetail= listeDetail.get(0);
							demDetail.setTStatut(new TStatut(statutUpdate));
							demDetail.setGpgStatutRetour("1");
					        iservice.updateObject(demDetail);
					       
				
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
				     //Préparation du Tableau de Bord
			      	tableauBordController.saveTempTabord(""+statutUpdate, ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), demDetail.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+demDetail.getGpgId());	
						   
				     //chargeDataAvaliderPgpm();
		 			 chargeDataAvaliderPgspm();
		 			chargeAcCombobox();
		 			 //Chargement du Tableau de Bord
		 			 tableauBordController.chargeDataPgspm();
		 			 //typeActionTb();
					 //Message de Confirmation
					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération retournée avec succès!", "");
				     FacesContext.getCurrentInstance().addMessage(null, msg);
						}
			 }
			 
			 
	
			 
			 
			//RéDifferer un PGSPM par la Cellule
			 @Transactional
			 public void reDiffererPgspm() {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 statutUpdate ="";
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
						 statutUpdate ="S2D";
					 } 
				   }
			
				 
				 listeDetail =(List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
							new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()));
						if (!listeDetail.isEmpty()) {
							demDetail= listeDetail.get(0);
							demDetail.setTStatut(new TStatut(statutUpdate));
							demDetail.setGpgStatutRetour("1");
					        iservice.updateObject(demDetail);
					  
					        listeHisto =(List<THistoPlanGeneral>) iservice.getObjectsByColumn("THistoPlanGeneral", new ArrayList<String>(Arrays.asList("HPG_ID")),
									new WhereClause("HPG_GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()),
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
				     //Préparation du Tableau de Bord
			      	tableauBordController.saveTempTabord(""+statutUpdate, ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), demDetail.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+demDetail.getGpgId());	
						    
				    
					 chargeDataAvaliderPgspm();
					 chargePgspmDifCp();
					 chargePgspmDifDmp();
					 chargeAcCombobox();
				     //Chargement du Tableau de Bord
					 tableauBordController.chargeDataPgspm();
					 //typeActionTb();
					 //Message de Confirmation
					 userController.setTexteMsg("Désolé, votre PGSPM a été rejeté!");
					 userController.setRenderMsg(true);
					 userController.setSevrityMsg("success");
						}	     
			 }
		 
			 
			 
			 
		 
		 public void checkSituation() {
			 if(sit.equalsIgnoreCase("O")) {
				 etatAgpm = true;
				 //etatFinancement1 = false;
				 etatFinancement1 = true;
				 //etatFinancement2 = true;
				 etatFinancement2 = false;
				 loveAgpmRappel = false;
				 btnAgpmRappel = true;
				 //btnAgpmRappel = false;
				 controleController.btn_save_pgpm = false;
				 controleController.btn_save_pgspm = false;
			 }else {
				 etatAgpm= false;
				 etatFinancement1 =true;
				 etatFinancement2 =false;
				 loveAgpmRappel = false;
				 btnAgpmRappel =false;
				 controleController.btn_save_pgpm = true;
			 }
		 }
		 
		 public void checkSituationPs() {
			 if(sit.equalsIgnoreCase("O")) {
				 etatAgpm = true;
				 etatFinancement1 = true;
				 etatFinancement2 = false;
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
			 recupModePassation.setMopTypPlan(modePassation.getMopTypPlan());
			// chargeModePassation();
				}
		 
             public void onSelectModePassationUpdate() {
			 updateOperation.setMopCode(modePassation.getMopCode());
			 updateOperation.setMopLibelleLong(modePassation.getMopLibelleLong());
				}
		 
		 
		 public void onSelectModePassationPgspm() {
			 detailPlan.setTModePassation(new TModePassation(passationListe.getMopCode()));

		    recupModeListe = new VModePassation();
		    recupModeListe.setMopLibelleLong(passationListe.getMopLibelleLong());
		    recupModeListe.setMopCode(passationListe.getMopCode());
		    recupModeListe.setMopTypPlan(passationListe.getMopTypPlan());
		    //chargeMode();
				}
	 
		  public void onSelectModePassationPgspmUpdate() {
			 updateOperation.setMopCode(passationListe.getMopCode());
			 updateOperation.setMopLibelleLong(passationListe.getMopLibelleLong());
		    //chargeMode();
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
      	 
    
      	 
      	 //Impression unique du pgpm 
      	 public void pgpmUnique() { 
      		 projetReport.longparam1(slctdTd.getGpgId(), "Fiche_pgpm", "Fiche_pgpm" );
      	 }
      	 
      	 
      	//Impression unique du psgpm 
      	 public void pgspmUnique() { 
      		 projetReport.longparam1(slctdTd.getGpgId(), "Fiche_pgspm", "Fiche_pgspm" );
      	 }
      	 
     	 
      	 
      	 
      	//Impression unique du pgpm ou pgspm
      	 public void pgpmUniqueSaisie() { 
      		 projetReport.longparam1(detailPlan.getGpgId(), "Fiche_pgpm", "Fiche_pgpm" );
      	 }
      	 
      	 
      	//Impression unique du pgpm ou pgspm
      	 public void pgspmUniqueSaisie() { 
      		 projetReport.longparam1(detailPlan.getGpgId(), "Fiche_pgspm", "Fiche_pgspm" );
      	 }
      	 
      	 //Enregistrement d'une opération en mode PS
         //@Transactional
         public void creerDetailPlanPgspm() throws IOException{
        	 
        	 if(detailPlan.getGpgObjet().equalsIgnoreCase("") || detailPlan.getGpgPartiePmePmi().equalsIgnoreCase("") || detailPlan.getGpgCommentaire().equalsIgnoreCase("") || detailPlan.getGpgLibFin().equalsIgnoreCase("")
        			 ||marche.getTymCode() == null ||  passationListe.getMopCode() == null ) {
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
                   detailPlan.setGpgTypePlan(passationListe.getMopTypPlan());
                   detailPlan.setTPlanGeneral(plan);
                   detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
                   detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
                   detailPlan.setGpgFonCodPf(userController.getSlctd().getTFonction().getFonCodePf());
                   detailPlan.setGpgFonCodDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
                   iservice.addObject(detailPlan);
                  	 
                    //Récupération du Statut
            	    TStatut statuts = constantService.getStatut("S1S");
	  				//Historisation des Pgpm
	      			historiser("S1S",detailPlan,"PGSPM crée par l'Autorité Contractante");
	      		    //Préparation du Tableau de Bord
	      			tableauBordController.saveTempTabord("S1S", ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), detailPlan.getGpgTypePlan(), ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+detailPlan.getGpgId());	
            		chargeDataPgspm();
            			 
            	  pgpmListe =(List<VPgpmliste>) iservice.getObjectsByColumn("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_ID")),
 		  				new WhereClause("GPG_ID", WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
 		  				if (!pgpmListe.isEmpty())  
 		  				varPgpm =pgpmListe.get(0); 
 		  		   String search = varPgpm.getGpgLibFin()+""+varPgpm.getGpgObjet()+""+userController.getSlctd().getTFonction().getFonCod()+""+varPgpm.getGpgActeurSaisie()+""+varPgpm.getGpgTypePlan()+""+varPgpm.getMopCode()+""+varPgpm.getMopLibelleCourt()+""+varPgpm.getTymCode()+""+varPgpm.getTymLibelleCourt()+""+varPgpm.getGpgDateDao();
 				   String rechercheAll = search.replace("null","");
 				
 				   detailPlan.setGpgRecherche(rechercheAll);
 				   iservice.updateObject(detailPlan);
            			
            			userController.setTexteMsg("Opération créée avec succès! veuillez cliquer sur + pour ajouter un financement!");
            			userController.setRenderMsg(true);
            			userController.setSevrityMsg("success");
            			
            			
            			//controleController.btn_edit_pgspm = true;
            			controleController.btn_edit_pgpm = false;
            			btnPgspmRappel = false;
            			btnAgpmRappel = false;
            			loveAgpmRappel = true;
            			controleController.btn_save_pgpm = false;
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
                	   detailPlan.setGpgTypePlan(passationListe.getMopTypPlan());
                	   detailPlan.setTPlanGeneral(plan);
                	   detailPlan.setGpgDateSaisie(Calendar.getInstance().getTime());
                	   detailPlan.setGpgStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
                	   detailPlan.setGpgFonCodPf(userController.getSlctd().getTFonction().getFonCodePf());
                       detailPlan.setGpgFonCodDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
                	   iservice.addObject(detailPlan);

                	 //Récupération du Statut
                	 TStatut statuts = constantService.getStatut("S1S");
   	  				//Historisation des Pgpm
   	      			historiser("S1S",detailPlan,"PGPM crée par l'Autorité Contractante");
          			
          			chargeDataPgspm();
          			
          			pgpmListe =(List<VPgpmliste>) iservice.getObjectsByColumn("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_ID")),
	  				new WhereClause("GPG_ID", WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
	  					if (!pgpmListe.isEmpty())  
	  						varPgpm =pgpmListe.get(0); 
	  		        String search = varPgpm.getGpgLibFin()+""+varPgpm.getGpgObjet()+""+userController.getSlctd().getTFonction().getFonCod()+""+varPgpm.getGpgActeurSaisie()+""+varPgpm.getGpgTypePlan()+""+varPgpm.getMopCode()+""+varPgpm.getMopLibelleCourt()+""+varPgpm.getTymCode()+""+varPgpm.getTymLibelleCourt()+""+varPgpm.getGpgDateDao();
			        String rechercheAll = search.replace("null","");
			
			        detailPlan.setGpgRecherche(rechercheAll);
			        iservice.updateObject(detailPlan);
          			userController.setTexteMsg("Opération créée avec succès! veuillez cliquer sur + pour ajouter un financement!");
          			userController.setRenderMsg(true);
          			userController.setSevrityMsg("success");
          			
          			
        			//controleController.btn_edit_pgspm = true;
        			controleController.btn_edit_pgpm = false; 
        			btnPgspmRappel = false;
        			btnAgpmRappel = false;
        			loveAgpmRappel = true;
        			controleController.btn_save_pgpm = false;
          			controleController.btn_save_pgspm = false;
        			
                     }
       	        }
         }
         
         
        
         public void creerDetailPgspmRappel() throws IOException{
        		 
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
                       detailPlan.setGpgFonCodPf(userController.getSlctd().getTFonction().getFonCodePf());
                       detailPlan.setGpgFonCodDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
                       iservice.addObject(detailPlan);
                   
                  	 
                        //Récupération du Statut
                	    TStatut statuts = constantService.getStatut("S1S");
   	  				    //Historisation des Pgpm
   	      			    historiser("S1S",detailPlan,"PGPM crée par l'Autorité Contractante");
                			
                		chargeDataPgspm();
                			 
                		 pgpmListe =(List<VPgpmliste>) iservice.getObjectsByColumn("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_ID")),
     		  			 new WhereClause("GPG_ID", WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
     		  			  if (!pgpmListe.isEmpty())  
     		  			    varPgpm =pgpmListe.get(0); 
     		  		      String search = varPgpm.getGpgLibFin()+""+varPgpm.getGpgObjet()+""+varPgpm.getGpgActeurSaisie()+""+varPgpm.getGpgTypePlan()+""+varPgpm.getMopCode()+""+varPgpm.getMopLibelleCourt()+""+varPgpm.getTymCode()+""+varPgpm.getTymLibelleCourt()+""+varPgpm.getGpgDateDao();
     				      String rechercheAll = search.replace("null","");
     				      //Insertion de recherche
     				      detailPlan.setGpgRecherche(rechercheAll);
     				      iservice.updateObject(detailPlan);
                		  //Message de confirmation	
                		  userController.setTexteMsg("Détail enregistré avec succès!");
                		  userController.setRenderMsg(true);
                		  userController.setSevrityMsg("success");
                		  //Contrôle sur les boutons
                		  controleController.btn_edit_pgspm = true;
                		  controleController.btn_edit_pgpm = false;
                		  controleController.btn_save_pgspm = false;
                		  btnPgspmRappel = false;
                		  loveAgpmRappel = true;
               		    
                       }else {
                    	   //Insertion du plan général
                   	       plan.setTGestion(new TGestion(gesCode));
                  		   plan.setTFonction(userController.getSlctd().getTFonction());
                  		   plan.setTStructure(userController.getSlctd().getTFonction().getTStructure());
                  		   iservice.addObject(plan);
                  		   //Insertion du détail plan général
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
                    	   detailPlan.setGpgFonCodPf(userController.getSlctd().getTFonction().getFonCodePf());
                           detailPlan.setGpgFonCodDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
                    	   iservice.addObject(detailPlan);

                    	//Récupération du Statut
                    	TStatut statuts = constantService.getStatut("S1S");
       	  				//Historisation des Pgpm
       	      			historiser("S1S",detailPlan,"PGPM crée par l'Autorité Contractante");
              			
              			chargeDataPgspm();
              			pgpmListe =(List<VPgpmliste>) iservice.getObjectsByColumn("VPgpmliste", new ArrayList<String>(Arrays.asList("GPG_ID")),
		  				new WhereClause("GPG_ID", WhereClause.Comparateur.EQ,""+detailPlan.getGpgId()));
		  				 if (!pgpmListe.isEmpty())  
		  				varPgpm =pgpmListe.get(0); 
		  		        String search = varPgpm.getGpgLibFin()+""+varPgpm.getGpgObjet()+""+varPgpm.getGpgActeurSaisie()+""+varPgpm.getGpgTypePlan()+""+varPgpm.getMopCode()+""+varPgpm.getMopLibelleCourt()+""+varPgpm.getTymCode()+""+varPgpm.getTymLibelleCourt()+""+varPgpm.getGpgDateDao();
				        String rechercheAll = search.replace("null","");
				        
				        detailPlan.setGpgRecherche(rechercheAll);
				        iservice.updateObject(detailPlan);
              			//Message du 
              			userController.setTexteMsg("Détail enregistré avec succès!");
              			userController.setRenderMsg(true);
              			userController.setSevrityMsg("success");
              			//Message 
            			controleController.btn_edit_pgspm = true;
            			controleController.btn_edit_pgpm = false;
            			controleController.btn_save_pgspm = false;
            			btnPgspmRappel = false;
            			loveAgpmRappel = true;
                         }
           	        }
                  }

		 
		//Methode Upload
		 @Transactional
		 public void upload(FileUploadEvent event) throws IOException{
			  
			 listeDetail = (List<TDetailPlanGeneral>) iservice.getObjectsByColumn("TDetailPlanGeneral", new ArrayList<String>(Arrays.asList("GPG_ID")),
						new WhereClause("GPG_ID",WhereClause.Comparateur.EQ,""+slctdTd.getGpgId()));
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
            //@Transactional
            public void saveFinancement(){
            	
            	if(detailPlan.getGpgObjet().equalsIgnoreCase("") ||"".equals(detailPlan.getGpgObjet()) || detailPlan.getGpgPartiePmePmi().equalsIgnoreCase("") ||"".equals(detailPlan.getGpgPartiePmePmi()) 
            			||souCode == null  || sourfin == null || devCode == null || detailPlan.getGpgLibFin().equalsIgnoreCase("") || "".equals(detailPlan.getGpgLibFin())) {
			        //Message d'erreur
		    		  FacesContext.getCurrentInstance().addMessage(null,
			          new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez, saisir votre opération!", ""));
            	    }else {
            		        //Création du financement
            	    	    if(sourfin.equalsIgnoreCase("ETAT")) {
	      				         baiCode ="ETAT";
            	        	    newFinancement.setTBailleur(new TBailleur(baiCode)); 
            	             }else
            	        	  {
            	            	newFinancement.setTBailleur(new TBailleur(baiCode));  
            	        	  }
            		    newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
    			        newFinancement.setTDevise(new TDevise(devCode));
    			        newFinancement.setTDetailPlanGeneral(detailPlan);
    			        newFinancement.setFipTypeFinance(sourfin);
    			        iservice.addObject(newFinancement);
    				    //Initialisation du financement(
    			        viderFinancement();
       				    //methode qui charge les financements du projet crée
    				    //chargeFinancement();
    			        chargeFinancementPgpm();
    				    //methode qui charge la liste des pgpm
    				    chargeData();
    				    //Affichage du bouton édition en fonction de l'action demandée
    				    if(controleController.type == "PGPM") {
    				    	//Activation du bouton d'édition
        				    controleController.btn_edit_pgpm = true;
        				    controleController.btn_edit_pgspm = false;
    				    }else {
    				    	//Activation du bouton d'édition
        				    controleController.btn_edit_pgspm = true;
        				    controleController.btn_edit_pgpm = false;
    				    }
    				    
    				    //viderFinancement();
    				    //Message de Confirmation
    				    userController.setTexteMsg("Financement enregistré avec succès !");
    				    userController.setRenderMsg(true);
    				    userController.setSevrityMsg("success");
    				    //viderFinancement();
    				    //vider();
            	} 
			}
            
            //Si la source de financement est Etat alors montant en devise = part Trésor
            public void recupTresor() {
            	if(sourfin.equalsIgnoreCase("ETAT")) {
            		newFinancement.fipTresor = newFinancement.getFipMontantDevise().longValue();
            	}
            }
            
            
                       //SaveFinancement de modification
                       public void saveFinancementUpdate(){
            		    //Création du financement
                    	   if(sourfin.equalsIgnoreCase("ETAT")) {
	      				         baiCode ="ETAT";
          	        	    newFinancement.setTBailleur(new TBailleur(baiCode)); 
          	             }else
          	        	  {
          	            	newFinancement.setTBailleur(new TBailleur(baiCode));  
          	        	  }
            		    newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
    			        newFinancement.setTDevise(new TDevise(devCode));
    			        //newFinancement.setTBailleur(new TBailleur(baiCode));
    			        newFinancement.setTDetailPlanGeneral(new TDetailPlanGeneral(slctdTd.getGpgId()));
    			        newFinancement.setFipTypeFinance(sourfin);
    			        iservice.addObject(newFinancement);
    				    //methode qui charge les financements du projet crée
    				    chargeFinancementUpdate();
    				    //methode qui charge la liste des pgpm
    				   // chargeData();
    				    //Réinitialisation 
    				    newFinancement = new TFinancementPgpm();
    				    //Message de Confirmation
    				    userController.setTexteMsg("Financement enregistré avec succès !");
    				    userController.setRenderMsg(true);
    				    userController.setSevrityMsg("success");
    				    //viderFinancement();
    				    //vider();	
			}
            
            /*public void recupererFinancement() {
            	selectFinance.setTBailleur(new TBailleur(baiCode));
            	selectFinance.setTSourceFinancement(new TSourceFinancement(souCode));
            	selectFinance.setTDevise(new TDevise(devCode));  
            	selectFinance.setTDetailPlanGeneral(new TDetailPlanGeneral(slctdTd.getGpgId()));
            	selectFinance.setFipTypeFinance(sourfin);
            }*/
            
            public void updateFinance() {
            	listeFinancement = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_ID",Comparateur.EQ,""+selectFinance.getFipId())));
				       if (!listeFinancement.isEmpty()) {
		    				newFinancement=listeFinancement.get(0); 
		    			}
            	/*selectFinance.setTBailleur(new TBailleur(baiCode));
            	selectFinance.setTSourceFinancement(new TSourceFinancement(souCode));
            	selectFinance.setTDevise(new TDevise(devCode));  
            	selectFinance.setTDetailPlanGeneral(new TDetailPlanGeneral(slctdTd.getGpgId()));
            	selectFinance.setFipTypeFinance(sourfin);
			    iservice.updateObject(selectFinance);
			    */
			    newFinancement.setTBailleur(new TBailleur(baiCode));
			    newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
			    newFinancement.setTDevise(new TDevise(devCode));  
			    newFinancement.setTDetailPlanGeneral(new TDetailPlanGeneral(slctdTd.getGpgId()));
			    newFinancement.setFipTypeFinance(sourfin);
			    iservice.updateObject(newFinancement);
			    
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
    		 sourfin = "";
    		 
    	 }
    	 
    	//Methode vider
    	 public void vider() {
    		 detailPlan = new TDetailPlanGeneral();
    		 recupFonction = new TFonction();
    		 reucpMarche = new TTypeMarche();
    		 recupAgpm = new VAgpmliste();
    		 recupModePassation = new VModePassationPn();
    		 newFinancement = new TFinancementPgpm();
    		 listeFinancement = new ArrayList<TFinancementPgpm>();
    		 listeFinancementPgpm = new ArrayList<VFinancementPgpm>();
    		 listeFinancementAgpm = new ArrayList<TFinancement>();
    		 etatDossier = false;
    		 //plan = new TPlanGeneral(); 
    		 controleController.btn_edit_pgpm = false;
    		 devCode ="";
    		 baiCode ="";
    		 souCode=""; 
    		 sourfin="";
    		 sit = "";
    	 } 
    	 
    
    	 
    	 //suppression de financement update
		 public void removeFinancementUpdate() {
			 System.out.print("+-------------+ "+getSelectFinancePg().getFipId());
			 try {
				 listeFinancement = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_ID",Comparateur.EQ,""+selectFinancePg.getFipId())));
				       if (!listeFinancement.isEmpty()) {
		    				newFinancement=listeFinancement.get(0); 
		    			}
				 
				    iservice.deleteObject(getNewFinancement());
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
				 
				 listeFinancement = ((List<TFinancementPgpm>)iservice.getObjectsByColumn("TFinancementPgpm",new ArrayList<String>(Arrays.asList("FIP_ID")),
						 new WhereClause("FIP_ID",Comparateur.EQ,""+selectFinance.getFipId())));
				       if (!listeFinancement.isEmpty()) {
		    				newFinancement=listeFinancement.get(0); 
		    			}
				 
				    iservice.deleteObject(getNewFinancement());
					chargeFinancementPgpm();
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
				 public void imprimerPg(String typelan) {
					 /*String operateur = userController.getSlctd().getTFonction().getFonCod();
						projetReport.longStringparam2(gesCode, operateur, "Pgpm", "Pgpm");*/
					 editPlan(typelan);
					}
				 
				 
                  public void editPlan(String typlan) {
                	  String statut="";
                	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
                		  statut="S1S S1D";
							 String operateur = userController.getSlctd().getTFonction().getFonCod();
							 String ministere = userController.getSlctd().getTFonction().getTStructure().getTMinistere().getMinCode();
							 projetReport.longStringparam6(gesCode, operateur,statut, typlan,ministere,plgFonCodAc,"pgpm", "pgpm");
							 _logger.info("statut: "+statut);
							 _logger.info("operateur: "+operateur);
							 _logger.info("gesCode: "+gesCode);
							 _logger.info("typlan: "+typlan);
							 _logger.info("ministere: "+ministere);
							 _logger.info("plgFonCodAc: "+plgFonCodAc);
						 }else
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
								 statut="S1T S2D";
								 String ministere = userController.getSlctd().getTFonction().getTStructure().getTMinistere().getMinCode();
								 projetReport.longStringparam6(gesCode, plgFonCodAc,statut, typlan,ministere,plgFonCod,"pgpm", "pgpm");
								 _logger.info("statut: "+statut);
								 _logger.info("plgFonCod: "+plgFonCod);
								 _logger.info("gesCode: "+gesCode);
								 _logger.info("typlan: "+typlan);
								 _logger.info("ministere: "+ministere);
								 _logger.info("plgFonCodAc: "+plgFonCodAc);
							 }else
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")
								    || userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
									 statut="S2V S3D";
									 //String ministere = userController.getSlctd().getTFonction().getTStructure().getTMinistere().getMinCode();
									 projetReport.longStringparam6(gesCode, plgFonCodAc,statut, typlan,minCode,plgFonCod,"pgpm", "pgpm");
									 _logger.info("statut: "+statut);
									 _logger.info("plgFonCodAc: "+plgFonCodAc);
									 _logger.info("gesCode: "+gesCode);
									 _logger.info("typlan: "+typlan);
									 _logger.info("ministere: "+ministere);
								 }
				   }
				 
				
				 //Edition de l'état PGSPM
				 public void imprimerPgspm() {
					    String operateur = userController.getSlctd().getTFonction().getFonCod();
						projetReport.longStringparam2(gesCode, operateur, "Pgspm", "Pgspm");
					}
				 
				 //Edition de l'PGPM Detail
				 public void imprimerPgpmDet() {
						projetReport.longparam1(slctdTd.getPlgId(), "Pgpm", "Pgpm");
					}
				 //Edition de l'PGSPM
				 public void imprimerPgspmDet() {
						projetReport.longparam1(slctdTd.getPlgId(), "Pgspm", "Pgspm");
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
					/*chargeDataAPublierPgpm("PN");*/
					chargePpgmPUB();
					tableauBordController.ChargeTbProcedure("PN","PGPM");
					listeFinancement.clear();
					listeFinancementAgpm.clear();
					listeFinancementPgpm.clear();
					newFinancement = new TFinancementPgpm();
					plgFonCod="";
					chargeAcCombobox();
					chargeAllCellDmp();
					vider();
					userController.initMessage();
					_logger.info("value: "+value+" action: "+action);
					break;
				case "pgpm2":
					
					chargeBailleur();
					chargeDevise();
					//chargeGestions();
					chargePgpmGestions();
					//recupGestions();
					//chargeMarches();
					//chargeModePassation();
					//chargeMode();
					chargeSourceFinance();
					chargeAgpm();
					//controleController.btn_save_pgpm =true ;
					listeFinancement.clear();
					listeFinancementAgpm.clear();
					listeFinancementPgpm.clear();
					newFinancement = new TFinancementPgpm();
					vider();
					//controleController.etatLoveAgpm = false;
					userController.initMessage();
					_logger.info("value: "+value+" action: "+action);
				break;
				case "pgpm3":
					editForm();
					//recupForm();
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
		 			//chargeDataAPublierPgpm("PS");
		 			chargePpgmPUB();
		 			tableauBordController.ChargeTbProcedure("PS","PGPM");
		 			userController.initMessage();
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
					newFinancement = new TFinancementPgpm();
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


/*
	public List<VTypeMarcheFils> getListeTypeMarches() {
		return listeTypeMarches;
	}


	public void setListeTypeMarches(List<VTypeMarcheFils> listeTypeMarches) {
		this.listeTypeMarches = listeTypeMarches;
	}
	


	public List<TModePassation> getListeModePassation() {
		return listeModePassation;
	}

	public void setListeModePassation(List<TModePassation> listeModePassation) {
		this.listeModePassation = listeModePassation;
	}*/
	
	

/*
	public List<VModePassationPn> getListeModePassation() {
		return listeModePassation;
	}


	public void setListeModePassation(List<VModePassationPn> listeModePassation) {
		this.listeModePassation = listeModePassation;
	}*/



	public TDetailPlanGeneral getDetailPlan() {
		return detailPlan;
	}


	public void setDetailPlan(TDetailPlanGeneral detailPlan) {
		this.detailPlan = detailPlan;
	}


	/*public List<VPgpmGestion> getListeGestion() {
		return listeGestion;
	}

	public void setListeGestion(List<VPgpmGestion> listeGestion) {
		this.listeGestion = listeGestion;
	}*/

	public long getGesCode() {
		return gesCode;
	}


	public void setGesCode(long gesCode) {
		this.gesCode = gesCode;
	}



	public VTypeMarcheFils getMarche() {
		return marche;
	}


	public void setMarche(VTypeMarcheFils marche) {
		this.marche = marche;
	}



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


	/*public TFinancementPgpm getSelectFinance() {
		return selectFinance;
	}

	public void setSelectFinance(TFinancementPgpm selectFinance) {
		this.selectFinance = selectFinance;
	}*/


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

	

	/*public TAffichagePgpm getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(TAffichagePgpm slctdTd) {
		this.slctdTd = slctdTd;
	}*/


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


	/*public TAgpm getRecupAgpm() {
		return recupAgpm;
	}
	public void setRecupAgpm(TAgpm recupAgpm) {
		this.recupAgpm = recupAgpm;
	}*/


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


/*	public List<TAffichagePgpm> getObjetList() {
		return objetList;
	}


	public void setObjetList(List<TAffichagePgpm> objetList) {
		this.objetList = objetList;
	}*/


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

/*
	public List<TAffichagePgpm> getListSelectionTransmission() {
		return listSelectionTransmission;
	}


	public void setListSelectionTransmission(List<TAffichagePgpm> listSelectionTransmission) {
		this.listSelectionTransmission = listSelectionTransmission;
	}*/


	/*public List<TAffichagePgpm> getValidationListe() {
		return validationListe;
	}


	public void setValidationListe(List<TAffichagePgpm> validationListe) {
		this.validationListe = validationListe;
	}*/


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}
	/*public List<TAffichagePgpm> getListPgspm() {
		return listPgspm;
	}
	public void setListPgspm(List<TAffichagePgpm> listPgspm) {
		this.listPgspm = listPgspm;
	}*/

	
	public List<VAgpmFonction> getAgpmList() {
		return agpmList;
	}
	
	public void setAgpmList(List<VAgpmFonction> agpmList) {
		this.agpmList = agpmList;
	}

	
	/*public List<TAffichagePgpm> getValidationListePgspm() {
		return validationListePgspm;
	}
	public void setValidationListePgspm(List<TAffichagePgpm> validationListePgspm) {
		this.validationListePgspm = validationListePgspm;
	}*/
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


/*	public List<TAffichagePgpm> getPgpmTrans() {
		return pgpmTrans;
	}


	public void setPgpmTrans(List<TAffichagePgpm> pgpmTrans) {
		this.pgpmTrans = pgpmTrans;
	}
*/

/*	public List<TAffichagePgpm> getPgspmTrans() {
		return pgspmTrans;
	}

	public void setPgspmTrans(List<TAffichagePgpm> pgspmTrans) {
		this.pgspmTrans = pgspmTrans;
	}*/


/*	public List<TAffichagePgpm> getPgpmValCp() {
		return pgpmValCp;
	}


	public void setPgpmValCp(List<TAffichagePgpm> pgpmValCp) {
		this.pgpmValCp = pgpmValCp;
	}
*/
/*
	public List<TAffichagePgpm> getPgpmValDmp() {
		return pgpmValDmp;
	}
	public void setPgpmValDmp(List<TAffichagePgpm> pgpmValDmp) {
		this.pgpmValDmp = pgpmValDmp;
	}
*/

	/*public List<TAffichagePgpm> getPgspmValCp() {
		return pgspmValCp;
	}


	public void setPgspmValCp(List<TAffichagePgpm> pgspmValCp) {
		this.pgspmValCp = pgspmValCp;
	}*/


	/*public List<TAffichagePgpm> getPgspmValDmp() {
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

*/
	public List<TFinancementPgpm> getFinancementListe() {
		return financementListe;
	}
	public void setFinancementListe(List<TFinancementPgpm> financementListe) {
		this.financementListe = financementListe;
	}


/*	public List<TAffichagePgpm> getPgspmDifCp() {
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
	}*/


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

	public List<VPgpmliste> getPgpmListe() {
		return pgpmListe;
	}

	public void setPgpmListe(List<VPgpmliste> pgpmListe) {
		this.pgpmListe = pgpmListe;
	}

	public VPgpmliste getVarPgpm() {
		return varPgpm;
	}

	public void setVarPgpm(VPgpmliste varPgpm) {
		this.varPgpm = varPgpm;
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

	public List<VPgpmliste> getObjetList() {
		return objetList;
	}

	public void setObjetList(List<VPgpmliste> objetList) {
		this.objetList = objetList;
	}

	public List<VPgpmliste> getValidationListe() {
		return validationListe;
	}

	public void setValidationListe(List<VPgpmliste> validationListe) {
		this.validationListe = validationListe;
	}

	public List<VPgpmliste> getListSelectionTransmission() {
		return listSelectionTransmission;
	}

	public void setListSelectionTransmission(List<VPgpmliste> listSelectionTransmission) {
		this.listSelectionTransmission = listSelectionTransmission;
	}

	public List<VPgpmliste> getPgspmTrans() {
		return pgspmTrans;
	}

	public void setPgspmTrans(List<VPgpmliste> pgspmTrans) {
		this.pgspmTrans = pgspmTrans;
	}

/*	public List<VPgpmliste> getPgpmTrans() {
		return pgpmTrans;
	}

	public void setPgpmTrans(List<VPgpmliste> pgpmTrans) {
		this.pgpmTrans = pgpmTrans;
	}*/

	public List<VPgpmliste> getPgpmValCp() {
		return pgpmValCp;
	}

	public void setPgpmValCp(List<VPgpmliste> pgpmValCp) {
		this.pgpmValCp = pgpmValCp;
	}

	public List<VPgpmliste> getPgpmValDmp() {
		return pgpmValDmp;
	}

	public void setPgpmValDmp(List<VPgpmliste> pgpmValDmp) {
		this.pgpmValDmp = pgpmValDmp;
	}

	public List<VPgpmliste> getPgspmValCp() {
		return pgspmValCp;
	}

	public void setPgspmValCp(List<VPgpmliste> pgspmValCp) {
		this.pgspmValCp = pgspmValCp;
	}

	public List<VPgpmliste> getPgspmValDmp() {
		return pgspmValDmp;
	}

	public void setPgspmValDmp(List<VPgpmliste> pgspmValDmp) {
		this.pgspmValDmp = pgspmValDmp;
	}

	public List<VPgpmliste> getPgpmDifCp() {
		return pgpmDifCp;
	}

	public void setPgpmDifCp(List<VPgpmliste> pgpmDifCp) {
		this.pgpmDifCp = pgpmDifCp;
	}

	public List<VPgpmliste> getPgpmDifDmp() {
		return pgpmDifDmp;
	}

	public void setPgpmDifDmp(List<VPgpmliste> pgpmDifDmp) {
		this.pgpmDifDmp = pgpmDifDmp;
	}

	public List<VPgpmliste> getPgspmDifCp() {
		return pgspmDifCp;
	}

	public void setPgspmDifCp(List<VPgpmliste> pgspmDifCp) {
		this.pgspmDifCp = pgspmDifCp;
	}

	public List<VPgpmliste> getPgspmDifDmp() {
		return pgspmDifDmp;
	}

	public void setPgspmDifDmp(List<VPgpmliste> pgspmDifDmp) {
		this.pgspmDifDmp = pgspmDifDmp;
	}

	public VPgpmliste getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(VPgpmliste slctdTd) {
		this.slctdTd = slctdTd;
	}

	public List<VPgpmliste> getListPgspm() {
		return listPgspm;
	}

	public void setListPgspm(List<VPgpmliste> listPgspm) {
		this.listPgspm = listPgspm;
	}

	public List<VPgpmliste> getValidationListePgspm() {
		return validationListePgspm;
	}

	public void setValidationListePgspm(List<VPgpmliste> validationListePgspm) {
		this.validationListePgspm = validationListePgspm;
	}

	public List<TDetailPlanGeneral> getRecupPgpm() {
		return recupPgpm;
	}

	public void setRecupPgpm(List<TDetailPlanGeneral> recupPgpm) {
		this.recupPgpm = recupPgpm;
	}

	public List<VFinancementPgpm> getListeFinancementPgpm() {
		return listeFinancementPgpm;
	}

	public void setListeFinancementPgpm(List<VFinancementPgpm> listeFinancementPgpm) {
		this.listeFinancementPgpm = listeFinancementPgpm;
	}

	public VFinancementPgpm getSelectFinancePg() {
		return selectFinancePg;
	}

	public void setSelectFinancePg(VFinancementPgpm selectFinancePg) {
		this.selectFinancePg = selectFinancePg;
	}

	public List<VPgpmliste> getPublicationListe() {
		return publicationListe;
	}

	public void setPublicationListe(List<VPgpmliste> publicationListe) {
		this.publicationListe = publicationListe;
	}

	public String getStatutPub() {
		return statutPub;
	}

	public void setStatutPub(String statutPub) {
		this.statutPub = statutPub;
	}

	public List<VPgpmliste> getPgpmPubDmp() {
		return pgpmPubDmp;
	}

	public void setPgpmPubDmp(List<VPgpmliste> pgpmPubDmp) {
		this.pgpmPubDmp = pgpmPubDmp;
	}

	public List<VPgpmliste> getPgspmPubDmp() {
		return pgspmPubDmp;
	}

	public void setPgspmPubDmp(List<VPgpmliste> pgspmPubDmp) {
		this.pgspmPubDmp = pgspmPubDmp;
	}

	public List<VPgpmPub> getPgpmPub() {
		return pgpmPub;
	}

	public void setPgpmPub(List<VPgpmPub> pgpmPub) {
		this.pgpmPub = pgpmPub;
	}

	public List<VDetTabBordPgpm> getDetailTB() {
		return detailTB;
	}

	public void setDetailTB(List<VDetTabBordPgpm> detailTB) {
		this.detailTB = detailTB;
	}

	public List<VPgpmliste> getPgpmDifAc() {
		return pgpmDifAc;
	}

	public void setPgpmDifAc(List<VPgpmliste> pgpmDifAc) {
		this.pgpmDifAc = pgpmDifAc;
	}

	
	public List<VAcAc> getListeAc() {
		return listeAc;
	}

	public void setListeAc(List<VAcAc> listeAc) {
		this.listeAc = listeAc;
	}

	public String getPlgFonCod() {
		return plgFonCod;
	}

	public void setPlgFonCod(String plgFonCod) {
		this.plgFonCod = plgFonCod;
	}

	public List<VAcDmp> getListeAcDmp() {
		return listeAcDmp;
	}

	public void setListeAcDmp(List<VAcDmp> listeAcDmp) {
		this.listeAcDmp = listeAcDmp;
	}

	public List<VAcMin> getListeMinDmp() {
		return listeMinDmp;
	}

	public void setListeMinDmp(List<VAcMin> listeMinDmp) {
		this.listeMinDmp = listeMinDmp;
	}

	public String getMinCode() {
		return minCode;
	}

	public void setMinCode(String minCode) {
		this.minCode = minCode;
	}

	public VAcAc getRecupAc() {
		return recupAc;
	}

	public void setRecupAc(VAcAc recupAc) {
		this.recupAc = recupAc;
	}

	public VAcMin getRecupMin() {
		return recupMin;
	}

	public void setRecupMin(VAcMin recupMin) {
		this.recupMin = recupMin;
	}

	public List<VAcPf> getListeCellDmp() {
		return listeCellDmp;
	}

	public void setListeCellDmp(List<VAcPf> listeCellDmp) {
		this.listeCellDmp = listeCellDmp;
	}

	public String getFonCodePf() {
		return fonCodePf;
	}

	public void setFonCodePf(String fonCodePf) {
		this.fonCodePf = fonCodePf;
	}

	public VAcPf getRecupCell() {
		return recupCell;
	}

	public void setRecupCell(VAcPf recupCell) {
		this.recupCell = recupCell;
	}

	public VAgpmliste getRecupAgpm() {
		return recupAgpm;
	}

	public void setRecupAgpm(VAgpmliste recupAgpm) {
		this.recupAgpm = recupAgpm;
	}

	public VFinancementPgpm getSelectFinance() {
		return selectFinance;
	}

	public void setSelectFinance(VFinancementPgpm selectFinance) {
		this.selectFinance = selectFinance;
	}

	public String getPlgFonCodAc() {
		return plgFonCodAc;
	}

	public void setPlgFonCodAc(String plgFonCodAc) {
		this.plgFonCodAc = plgFonCodAc;
	}

	/*public VPgpmGestion getObjetGestion() {
		return objetGestion;
	}

	public void setObjetGestion(VPgpmGestion objetGestion) 
		this.objetGestion = objetGestion;
	}*/

	public List<TGestion> getListeGestion() {
		return listeGestion;
	}

	public void setListeGestion(List<TGestion> listeGestion) {
		this.listeGestion = listeGestion;
	}

	public TGestion getObjetGestion() {
		return objetGestion;
	}

	public void setObjetGestion(TGestion objetGestion) {
		this.objetGestion = objetGestion;
	}

	public List<TGestionPgpm> getListePgmGest() {
		return listePgmGest;
	}

	public void setListePgmGest(List<TGestionPgpm> listePgmGest) {
		this.listePgmGest = listePgmGest;
	}
	
	

}
