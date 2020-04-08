package com.sndi.controller.agpm;

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
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAffichageAgpm;
import com.sndi.model.TAffichagePgpm;
import com.sndi.model.TAgpm;
import com.sndi.model.TBailleur;
import com.sndi.model.TBesoin;
import com.sndi.model.TComposante;
import com.sndi.model.TContenuAgpm;
import com.sndi.model.TDeclarant;
import com.sndi.model.TDetailAgpm;
import com.sndi.model.TDevise;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TFinancement;
import com.sndi.model.TFonction;
import com.sndi.model.TGestion;
import com.sndi.model.THistoAgpm;
import com.sndi.model.TMinistere;
import com.sndi.model.TNaturePiece;
import com.sndi.model.TObjectifGen;
import com.sndi.model.TProjet;
import com.sndi.model.TReglementation;
import com.sndi.model.TSourceFinancement;
import com.sndi.model.TStatut;
import com.sndi.model.TStructure;
import com.sndi.model.VAgpm;
import com.sndi.model.VAgpmBailleur;
import com.sndi.model.VAgpmDeclarant;
import com.sndi.model.VAgpmDetails;
import com.sndi.model.VAgpmStatut;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VProjetAgpm;
import com.sndi.model.VUpdateAgpm;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.GRFProperties;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class AgpmController {
	Logger _logger = Logger.getLogger(AgpmController.class);
	
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
		verifProjet();
		chargeData();
		chargeDataAvalider();
		chargeBailleur();
		chargeDevise();
		chargeSourceFinance();
		chargeMinisteres();
		chargeGestions();
		chargeContenu();
		chargeDetail();
		DataToday();
		chargeAgpmTrans();
		chargeAgpmValCp();
		chargeAgpmValDmp();
		chargeAgpmDifCp();
		chargeAgpmDifDmp();
	 }
	 
	 //Declaration des listes
	 /*private List<TAgpm> objetListe = new ArrayList<TAgpm>();*/
	 private List<TAffichageAgpm> affichageListe = new ArrayList<TAffichageAgpm>();
	 private List<VUpdateAgpm> listUpdate = new ArrayList<VUpdateAgpm>();
	 private List<VAgpm> objetListe = new ArrayList<VAgpm>();
	 private List<TAgpm> listeAgpm = new ArrayList<TAgpm>();
	 private List<TProjet> projetUpdate = new ArrayList<TProjet>();
	 private List<THistoAgpm> listeHisto = new ArrayList<THistoAgpm>();
	 private List<String> ajoutParagraphe = new ArrayList<String>();
	 private List<TBailleur> listeBailleurs = new ArrayList<TBailleur>();
	 private List<TSourceFinancement> listeSourceFinance = new ArrayList<TSourceFinancement>();
	 private List<TContenuAgpm> listeContenu = new ArrayList<TContenuAgpm>();
	 private List<TDevise> listeDevise = new ArrayList<TDevise>();
	 private List<TFinancement> listeFinancement = new ArrayList<TFinancement>();
	 private List<TReglementation> listeReglementation = new ArrayList<TReglementation>();
	 private List<TReglementation> listeRegleCombox = new ArrayList<TReglementation>();
	 private List<TGestion> listeGestion = new ArrayList<TGestion>();
	 private List<TMinistere> listeMinistere = new ArrayList<TMinistere>();
	 private List<TStructure> listeStructure = new ArrayList<TStructure>();
	 private List<VFonctionMinistere> listeFonctions = new ArrayList<VFonctionMinistere>();
	 private List<VFonctionMinistere> listeFonctionsDmp = new ArrayList<VFonctionMinistere>();
	 private List<TComposante> composanteListe = new ArrayList<TComposante>();
	 private List<TObjectifGen> objectifListe = new ArrayList<TObjectifGen>();
	 private List<TBesoin> besoinListe = new ArrayList<TBesoin>();
	 private List<TDossierAgpm> dossListe = new ArrayList<TDossierAgpm>();
	 private VFonctionMinistere fonction =new VFonctionMinistere();
	 private TDossierAgpm selectedDossier = new TDossierAgpm();
	 private TDetailAgpm tmpDetailAgpm = new TDetailAgpm();
	 private List <TDetailAgpm> detailAgpm = new ArrayList<TDetailAgpm>(); 
	 private List <VAgpmStatut> agpmstatutList = new ArrayList<VAgpmStatut>();
	 private List<TDeclarant> listeDeclarants = new ArrayList<TDeclarant>();
	 private List<VAgpmDeclarant> listeDeclarantsRappel = new ArrayList<VAgpmDeclarant>();
	 private List<VProjetAgpm> acteListe = new ArrayList<VProjetAgpm>();
	 private List<TProjet> listeProjet = new ArrayList<TProjet>();
	 private List<TAffichageAgpm> validationListe = new ArrayList<TAffichageAgpm>();
	 private List<TDetailAgpm> listeDetail = new ArrayList<TDetailAgpm>();
	 private List<VAgpmDetails> detailsList = new ArrayList<VAgpmDetails>();
	 private List<TAffichageAgpm> agpmTrans = new ArrayList<TAffichageAgpm>();
	 private List<TAffichageAgpm> agpmValCp = new ArrayList<TAffichageAgpm>();
     private List<TAffichageAgpm> agpmValDmp = new ArrayList<TAffichageAgpm>();
     private List<TAffichageAgpm> agpmDifCp = new ArrayList<TAffichageAgpm>();
     private List<TAffichageAgpm> agpmDifDmp = new ArrayList<TAffichageAgpm>();
	  
	
	 //Declaration des objets
	 private TAgpm agpm = new TAgpm();
	 private TAffichageAgpm affichageAgpm = new TAffichageAgpm();
	 private TAgpm demAgpm = new TAgpm();
	 private THistoAgpm histoAgpm = new THistoAgpm();
	 private TDetailAgpm detail = new TDetailAgpm();
	 private TDetailAgpm sltdetail = new TDetailAgpm();
	 private VAgpm addAgpm = new VAgpm(); 
	 private VUpdateAgpm updateAgpm = new VUpdateAgpm(); 
	 private VAgpmDeclarant rappelDec = new VAgpmDeclarant();
	 private VProjetAgpm acte = new VProjetAgpm(); 
	 private TAffichageAgpm slctdTd = new TAffichageAgpm();
	 private TDeclarant dec = new TDeclarant();
	 private TFinancement selectFinance = new TFinancement();
	 private TBesoin selectBesoin = new TBesoin();
	 private TComposante selectComposante = new TComposante();
	 private TObjectifGen selectBojectif= new TObjectifGen();
	 
	 private TProjet projet = new TProjet();
	 private TDeclarant declarant = new TDeclarant();
	 private TFinancement newFinancement = new TFinancement();
	 private TComposante newComposante = new TComposante();
	 private TBesoin newBesoin = new TBesoin();  
	 private TObjectifGen newObjectif = new TObjectifGen(); 
	 private VAgpmStatut agpmstatut= new VAgpmStatut();
	 private TMinistere ministere= new TMinistere();
	 private TMinistere recupMinistere= new TMinistere();
	 private TFonction recupFonction= new TFonction();
	 private TStructure structure= new TStructure();
	 private TStructure recupStructure= new TStructure();
	
	 //Declaration des variables
	 private long regle;
	 private long gesCode;
	 private long minCode;
	 private String fonc="";
	 private String fonCod="";
	 private long proId;
	 private String baiCode=""; 
	 private String sourfin; 
	 private String souCode="";
	 private String tcaCode="FIN";
	 private String devCode="CFA";
	 private String natPiece ="";
	 private String observation="";
	 private String filtreFonction="";
	 private String filtreMinistere="";
	 private String filtreStructure="";
	 private String filtreAutorite="";
	 private String filtreOrgane="";
	 private String filtreProjet="";
	 private String filtreExercice="";
	 private String multiFiltre="";
	 private String proTypeProjet;
	 static  String workingDir = "";
	 private Boolean boutonAdd=true;
	 private Boolean boutonSupp=false;
	 private Boolean boutonEdit=false;
	 private boolean etatPavetDeclarant= false;
	 private boolean etatAutreInfo= false;
	 private boolean etatPavetDossier= false; 
	 private boolean etatPavetInfoProjet= false; 
	 private boolean etatPavetOrgne= false;
	 private long decId = 0;
	 public boolean  etatPanelOrganeRappel=false;  
	 public boolean  etatPanelOrgane=true;  
	 public boolean  etatBoutonModifDeclarant=false;
	 public boolean  etatBoutonEnregDeclarant=true;
	 private boolean etatPanelConfirmation=true; 
	 private boolean etatPanelConfirmationRappel=false;
	 public boolean etatPanelProjetRappel= false;
	 public boolean etatPanelInfoProjetRappel=false;
	 public boolean etatPanelProjet= true;
	 public boolean etatPanelInfoProjet=true; 
	 public boolean paveConfirmation=false; 
	 public boolean paveInformations=false;
	 public boolean  etatPanelDossiers=true;
	 public boolean  etatPanelDossiersRappel=false;
	 public boolean  etatBoutonModifProjet=false;
	 public boolean  etatBoutonEnregProjet=true;
	 public boolean  etatPanelConfirmationProjet=true;
	 public boolean  etatPanelConfirmationProjetRappel=false;
	 public boolean etatBoutonEnregRappelProjet=false;
	 public boolean comboRappelDec=false;
	 public boolean etatReferenceProjet=false;
	 public boolean etatReferenceDeclarant=false;
	 public boolean boutonEditRappel=false;
	 public boolean selectBailleur=false;
	 public boolean selectTresor =false;
	 public boolean selectPartBai =false;
	 private String statutAffiche="";
	 private String statutUpdate="";
	 private String statutTrans ="";
	 private String commentaire="";
	 private String colonne="";
	 private String recherche="";
	 private String dateToday;
	 public boolean btn_saveProjet =true;
	 
		//Methode
	  public void DataToday() {
		  Date date = Calendar.getInstance().getTime();
		  DateFormat  formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		  setDateToday(formatter1.format(date)); 
	  }
	  
	  //afficher le bloc reference projet en fonction
	  public void verifProjet(){
			 listeAgpm =(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("agpId")),
					 new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ,"S1S"),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					if (!listeAgpm.isEmpty()) {
						  rappelProjet(); 
						  etatReferenceProjet=true;
					}else {
						etatReferenceProjet=false;
					}
		      }
	  
	 
	  
	  public void verifDeclarant() { 
		  listeDeclarantsRappel = ((List<VAgpmDeclarant>) iservice.getObjectsByColumn("VAgpmDeclarant", new ArrayList<String>(Arrays.asList("AGP_ID")),
   			   new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+acte.getAgpId()),
			   new WhereClause("AGP_DEC_ID",WhereClause.Comparateur.EQ,""+acte.getAgpDecId()))); 
			if (!listeDeclarantsRappel.isEmpty()) {
				rappelDec=listeDeclarantsRappel.get(0);
				etatPavetOrgne = true;
				  etatPanelOrgane = false;
				  etatPanelOrganeRappel=true;
				  etatPanelConfirmation = false;
				  etatPanelConfirmationRappel=true;
				  
			}else {
				 etatPanelOrgane = true;
				 //etatReferenceDeclarant=false;
				 etatPanelOrganeRappel=false;
				 etatPanelConfirmation = true;
				 etatPanelConfirmationRappel = false;
				 etatPavetOrgne = false;
			}
	  }
	  
		//Afficher la liste des AGPM a transmettre dont le statut est S1S(statut par defaut)
		 public void chargeData(){
				 getAffichageListe().clear();
				 affichageListe = (List<TAffichageAgpm>) iservice.getObjectsByColumnInDesc("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
						"AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SDR")),
						new WhereClause("AFF_AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AFF_AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				 
				     tableauBordController.chargeDataAgpm(); 
					_logger.info("affichageListe size: "+affichageListe.size());	
			}
		 
		 public void chargeDataAvalider() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 getValidationListe().clear();
					 validationListe = (List<TAffichageAgpm>) iservice.getObjectsByColumnInDesc("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
								"AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("AFF_AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
					 tableauBordController.chargeDataAgpm();
						_logger.info("validationListe size: "+validationListe.size()); 
					 
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
							validationListe = (List<TAffichageAgpm>) iservice.getObjectsByColumnInDesc("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
									"AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
									new WhereClause("AFF_AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
							tableauBordController.chargeDataAgpm(); 
								_logger.info("objetListe size: "+validationListe.size());
					 }
			     } 
			   }
			 }
		 
		 
		 
		 
		 
		//Liste des Agpm transmis par l'acteur connecté
		 public void chargeAgpmTrans() {
			 agpmTrans.clear();
			 agpmTrans = ((List<TAffichageAgpm>)iservice.getObjectsByColumnIn("TAffichageAgpm",new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
					    "AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","SDT")),
					    new WhereClause("AFF_AGP_ACTIF",Comparateur.EQ,"1"),
						 new WhereClause("AFF_AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
		 }
		 
		//Liste des Agpm validés par le cpmp
		 public void chargeAgpmValCp() {
			 agpmValCp.clear();
			 agpmValCp = ((List<TAffichageAgpm>)iservice.getObjectsByColumn("TAffichageAgpm",new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
					    new WhereClause("AFF_AGP_STA_CODE",Comparateur.EQ,"S2V"),
					    new WhereClause("AFF_AGP_ACTIF",Comparateur.EQ,"1"),
						 new WhereClause("AFF_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
		 }
		 
		//Liste des Pgpm validés par le cpmp
		 public void chargeAgpmValDmp() {
			 agpmValDmp.clear();
			 agpmValDmp = ((List<TAffichageAgpm>)iservice.getObjectsByColumn("TAffichageAgpm",new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
					    new WhereClause("AFF_AGP_STA_CODE",Comparateur.EQ,"S3V"),
					    new WhereClause("AFF_AGP_ACTIF",Comparateur.EQ,"1")));
						// new WhereClause("AFF_DPP_MIN_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode())));		 		 
		 }
		 
		 //Liste des Agpm différés par le cpmp
		 public void chargeAgpmDifCp() {
			 agpmDifCp.clear();
			 agpmDifCp = ((List<TAffichageAgpm>)iservice.getObjectsByColumn("TAffichageAgpm",new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
					    new WhereClause("AFF_AGP_STA_CODE",Comparateur.EQ,"S2D"),
					    new WhereClause("AFF_AGP_ACTIF",Comparateur.EQ,"1"),
						 new WhereClause("AFF_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));		 		 
		 }
		 
		//Liste des Agpm différés par le cpmp
		 public void chargeAgpmDifDmp() {
			 agpmDifDmp.clear();
			 agpmDifDmp = ((List<TAffichageAgpm>)iservice.getObjectsByColumnIn("TAffichageAgpm",new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
					   "AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SDR")),
					    new WhereClause("AFF_AGP_ACTIF",Comparateur.EQ,"1")));		 		 
		      }
		 
		 
		//Liste des Agpm retournés chez l'AC
		 public void chargeAgpmDifAc() {
			 agpmDifDmp.clear();
			 agpmDifDmp = ((List<TAffichageAgpm>)iservice.getObjectsByColumnIn("TAffichageAgpm",new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
					   "AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2D","SDR")),
					    new WhereClause("AFF_AGP_ACTIF",Comparateur.EQ,"1")));		 		 
		      }
		 
		 
		 
		 
		 //liste des details
		 public void chargeDetail() {
			 getListeDetail().clear();
			 listeDetail= (List<TDetailAgpm>) iservice.getObjectsByColumn("TDetailAgpm", new ArrayList<String>(Arrays.asList("TDA_ID")),
					 new WhereClause("TDA_AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
		 }
		 
		 //liste des details du projet rappelé
		 public void chargeDetailRappel() {
			 getListeDetail().clear();
			 listeDetail= (List<TDetailAgpm>) iservice.getObjectsByColumnDesc("TDetailAgpm", new ArrayList<String>(Arrays.asList("TDA_ID")),
					 new WhereClause("TDA_AGP_ID",WhereClause.Comparateur.EQ,""+acte.getAgpId()));
		 }

	 public void chargeContenu(){
		 listeContenu=(List<TContenuAgpm>) iservice.getObjectsByColumn("TContenuAgpm", new ArrayList<String>(Arrays.asList("TCA_CODE")));	
	 }
	
		//Combobox reglémentations 
		 public void chargeMinisteres(){
			 listeMinistere=(List<TMinistere>) iservice.getObjectsByColumn("TMinistere", new ArrayList<String>(Arrays.asList("MIN_CODE")));	
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
		 
		 //Début des filtres
		 
		 //Filtre en fonction de l'exercice
			public void ChargerFiltreExercice() {
				getListeAgpm().clear();
				 objetListe= (List<VAgpm>) iservice.getObjectsByColumn("VAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						 new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,""+controleController.getStatutAffiche()),
						 new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						 new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						 new WhereClause("AGP_GES_CODE",WhereClause.Comparateur.LIKE,"%"+filtreExercice+"%"));
		    }
			
			 //Filtre en fonction du ministère
			public void ChargerFiltreMinistere() {
				getListeAgpm().clear();
				objetListe= (List<VAgpm>) iservice.getObjectsByColumn("VAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						 new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,""+controleController.getStatutAffiche()),
						 new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						 new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						 new WhereClause("MIN_LIBELLE_COURT",WhereClause.Comparateur.LIKE,"%"+filtreMinistere+"%"));
		    }
			
			
			 //Filtre en fonction de l'autorité Contractante
			public void ChargerFiltreAutorite() {
				getListeAgpm().clear();
				objetListe= (List<VAgpm>) iservice.getObjectsByColumn("VAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						 new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,""+controleController.getStatutAffiche()),
						 new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						 new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						 new WhereClause("AC",WhereClause.Comparateur.LIKE,"%"+filtreAutorite+"%"));
		       }
			
			
			//Filtre en fonction du projet
			public void ChargerFiltreProjet() {
				getListeAgpm().clear();
				objetListe= (List<VAgpm>) iservice.getObjectsByColumn("VAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						 new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,""+controleController.getStatutAffiche()),
						 new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						 new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						 new WhereClause("PRO_LIBELLE",WhereClause.Comparateur.LIKE,"%"+filtreProjet+"%"));
		       }
			
			 //Filtre en fonction de l'organe d'exécution
			public void ChargerFiltreOrgane() {
				getListeAgpm().clear();
				objetListe= (List<VAgpm>) iservice.getObjectsByColumn("VAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						 new WhereClause("AGP_STA_CODE",WhereClause.Comparateur.EQ,""+controleController.getStatutAffiche()),
						 new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						 new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						 new WhereClause("DEC_ORGAN_EXEC_LIBELLE",WhereClause.Comparateur.LIKE,"%"+filtreOrgane+"%"));
		       }

		 //Fin des Filtres

			
			//Combobox du rappel du déclarant
	           public void rappelDeclarant() { 
	        	   listeDeclarantsRappel = ((List<VAgpmDeclarant>) iservice.getObjectsByColumn("VAgpmDeclarant", new ArrayList<String>(Arrays.asList("AGP_ID")),
	        			   new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+acte.getAgpId()))); 
	             }
			
	         //Configuration de la page en fonction du déclarant choisi
	           //Methode de rappel du Déclarant
	           public void rechercheDeclarant2(){
	        	   listeDeclarantsRappel =(List<VAgpmDeclarant>) iservice.getObjectsByColumn("VAgpmDeclarant", new ArrayList<String>(Arrays.asList("AGP_ID")),
	        			   new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()),
						   new WhereClause("AGP_DEC_ID",WhereClause.Comparateur.EQ,""+agpm.getTDeclarant().getDecId()));
						if (!listeDeclarantsRappel.isEmpty()) {
							rappelDec=listeDeclarantsRappel.get(0);
		                     etatPanelOrgane=false;
		                     etatPanelOrganeRappel=true;
		                     etatBoutonEnregDeclarant=false;
		                     etatPanelConfirmation=false;
		                     etatPanelConfirmationRappel=true; 
		                     //etatPanelConfirmationProjet=false;
			          }else {
		                     etatPanelOrgane=true;
		                     etatPanelOrganeRappel=false;
		                     etatBoutonEnregDeclarant = true;
		                     etatPanelConfirmation=true;
		                     etatPanelConfirmationRappel= false;
		                     rappelDeclarant();
		                     //etatPanelConfirmationProjet=true;
						}
					}
	           
	         
	           
	     
	           
	           
	           //Methode de rappel du Déclarant
	           public void rechercheDeclarant(){
	        	   listeDeclarantsRappel =(List<VAgpmDeclarant>) iservice.getObjectsByColumn("VAgpmDeclarant", new ArrayList<String>(Arrays.asList("AGP_ID")),
	        			   new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+acte.getAgpId()),
	        			   new WhereClause("AGP_DEC_ID",WhereClause.Comparateur.EQ,""+decId));
						if (!listeDeclarantsRappel.isEmpty()) {
							rappelDec=listeDeclarantsRappel.get(0);
		                     etatPanelOrgane=false;
		                     etatPanelOrganeRappel=true;
		                     etatBoutonEnregDeclarant=false;
		                     etatPanelConfirmation=false;
		                     etatPanelConfirmationRappel=true; 
		                     
		                     //agpm.getTDeclarant().getDecId();
		                     //etatComboRappel = true;
		                     boutonEdit = false; 
		                     boutonEditRappel = true;
		                     etatPavetDossier = true;
		                     //etatPanelConfirmationProjet=false;
			          }else {
		                     etatPanelOrgane=true;
		                     etatPanelOrganeRappel=false;
		                     etatBoutonEnregDeclarant = true;
		                     etatPanelConfirmation=true;
		                     etatPanelConfirmationRappel= false;
		                     decId =0;
		                     boutonEdit = true;
		                     boutonEditRappel = false;
		               
		                     etatPavetDossier = false;
		                     //rappelDeclarant();
		                     //etatPanelConfirmationProjet=true;
						}
					}
	           
	           public void comboDec() {
	        	  if(agpm.getTDeclarant().getDecId()>0)  {
	        		  comboRappelDec = true;
	        	  }else {
	        		  comboRappelDec = false;
	        	  }
	           }
	           
	           //Suppression des details
	           public void deleteDetail() {
	       		try {
	       			  if(acte.getAgpId() > 0) {
	       				iservice.deleteObject(getDetail());
		       			chargeDetail();
		       			chargeDetailRappel();
		       			userController.setRenderMsg(true);
		       			userController.setTexteMsg("Suppression éffectueé avec succès !");
		       			userController.setSevrityMsg("success");
	       			  }else {
	       				iservice.deleteObject(getDetail());
		       			chargeDetail();
		       			userController.setRenderMsg(true);
		       			userController.setTexteMsg("Suppression éffectueé avec succès !");
		       			userController.setSevrityMsg("success");
	       			        }
	       			
	       		} catch (org.hibernate.exception.ConstraintViolationException e) {
	       			userController.setTexteMsg("Impossible de supprimer la Fonction !");
	       			userController.setRenderMsg(true);
	       			userController.setSevrityMsg("danger");
	       		}  
	        	   
	           }
	           //Mis à jour du numéro d'ordre
	           public void updateDetail() {
	        	    detail.setTdaNumOrdre(detail.getTdaNumOrdre());
	       			iservice.updateObject(getDetail());
	       			chargeDetail();
	           }
	         
	         //Combobox des projets à récupérer
	      	 public void rappelProjet() { 
	      	     acteListe = (List<VProjetAgpm>) iservice.getObjectsByColumnIn("VProjetAgpm", new ArrayList<String>(Arrays.asList("PRO_ID")),
					"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
					new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					new WhereClause("AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	      	         }


	                        //Rappel du projet
	      	  public void rechercheProjet(){
	      			acteListe =(List<VProjetAgpm>) iservice.getObjectsByColumn("VProjetAgpm", new ArrayList<String>(Arrays.asList("PRO_ID")),
	      							new WhereClause("AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
	      							new WhereClause("PRO_ID",WhereClause.Comparateur.EQ,""+proId));
	      					if (!acteListe.isEmpty()) {
	      						 acte=acteListe.get(0);
	      						 
	      				         etatPanelProjet=false;
	      				         etatPanelProjetRappel=true;
	      		                 etatBoutonEnregProjet=false;
	      		                 etatBoutonEnregRappelProjet=true;
	      		                 etatPanelConfirmationProjet=false;
	      	                     etatPanelConfirmationProjetRappel=true;
	      	                     etatPavetOrgne= true;
	      	                     etatReferenceDeclarant = true;
	      	                     rappelDeclarant();
	      	                     chargeDetailRappel(); 
	      	                     //verifDeclarant();
	      					}else {
	      	                     etatPanelProjet=true;
	      	                     etatPanelProjetRappel=false;
	      	                   
	      		                 etatBoutonEnregProjet=true;
	      		                 etatBoutonEnregRappelProjet=false;
	      		                 etatPanelConfirmationProjet=true;
	      	                     etatPanelConfirmationProjetRappel=false;
	      	                     etatPavetOrgne= false;
	      	                    etatReferenceDeclarant = false;
	      					}
	      				}

	      	  
	      	  
	      	//Filtre multicritère
		public void chargerFiltreRecherche() {  	
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				getAffichageListe().clear();
				affichageListe = (List<TAffichageAgpm>) iservice.getObjectsByColumnInDesc("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
					"AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","S3D")),
					new WhereClause("AFF_AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					new WhereClause("AFF_AGP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
					tableauBordController.chargeDataAgpm(); 
					_logger.info("affichageListe size: "+affichageListe.size());
					
					 }else 
					      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
					    	  getValidationListe().clear();
					    	  validationListe = (List<TAffichageAgpm>) iservice.getObjectsByColumnInDesc("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
									"AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
									new WhereClause("AFF_AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					    			new WhereClause("AFF_AGP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
							        tableauBordController.chargeDataAgpm();
								   _logger.info("validationListe size: "+validationListe.size());
								   
					      }else 
					    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					    	    getValidationListe().clear();
								validationListe = (List<TAffichageAgpm>) iservice.getObjectsByColumnInDesc("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
										"AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V")),
										new WhereClause("AFF_AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
								new WhereClause("AFF_AGP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
								tableauBordController.chargeDataAgpm(); 
									_logger.info("objetListe size: "+validationListe.size());
									
					      }
			          }

	   
		
	  	//Filtre multicritère
			public void reinitialiserAgpm() {  	
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 getAffichageListe().clear();
					 affichageListe = (List<TAffichageAgpm>) iservice.getObjectsByColumnInDesc("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
							"AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SDR")),
							new WhereClause("AFF_AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
							new WhereClause("AFF_AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					 
					       tableauBordController.chargeDataAgpm();
					       multiFiltre="";
						  _logger.info("affichageListe size: "+affichageListe.size());
						
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  getValidationListe().clear();
									 validationListe = (List<TAffichageAgpm>) iservice.getObjectsByColumnInDesc("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
												"AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("AFF_AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
									 tableauBordController.chargeDataAgpm();
									 multiFiltre="";
										_logger.info("validationListe size: "+validationListe.size()); 
						    	  
						      }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  getValidationListe().clear();
										validationListe = (List<TAffichageAgpm>) iservice.getObjectsByColumnInDesc("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
												"AFF_AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
												new WhereClause("AFF_AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
										      tableauBordController.chargeDataAgpm(); 
										      multiFiltre="";
											_logger.info("objetListe size: "+validationListe.size());
						          }
				             }
	      	 
	      	 
	  //Méthode de création du projet
	  @Transactional
	  public void creerProjet() throws IOException{
	      		 
	   /* VAgpmBailleur bai = checkAgpm(""+agpm.getAgpId(), baiCode);   
	      if(bai == null) {*/
	                           
	    	  if(projet.getProTitre().equalsIgnoreCase("") || "".equals(projet.getProTitre()) || agpm.getAgpCommentaire().equalsIgnoreCase("") || "".equals(agpm.getAgpCommentaire()) || projet.getProTypeProjet().equalsIgnoreCase("") || "".equals(projet.getProTypeProjet()) || devCode.equalsIgnoreCase("") ||"".equals(devCode) || sourfin.equalsIgnoreCase("") ||
	    			  souCode.equalsIgnoreCase("") || "".equals(souCode) ) {
	                      //Message d'erreur
	    		          FacesContext.getCurrentInstance().addMessage(null,
	    	      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir tous les champs", ""));	 
	                           
	    	                }else {
	    	                	
	    	                	/*projetUpdate =(List<TProjet>) iservice.getObjectsByColumn("TProjet", new ArrayList<String>(Arrays.asList("PRO_ID")),	 
		    	   						 new WhereClause("PRO_ID",WhereClause.Comparateur.EQ,""+agpm.getTProjet().getProId()));
	    	 				            if(!projetUpdate.isEmpty())*/
	    	                	
	    	                	listeAgpm=(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),	 
  						                              new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
                                              if(!listeAgpm.isEmpty()) { 
	    	 				            	 agpm=listeAgpm.get(0);
	    	 				            	 iservice.updateObject(projet);
                                             iservice.updateObject(agpm);
	    	 				    	           
	  	    	 					                          
	  		    	 					                                    
	  		    	 					    affichageListe = (List<TAffichageAgpm>) iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),	 
	  		 	  	   	    	   					new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
	  	   	    	 				                        if(!affichageListe.isEmpty()) {
	  	   	    	 				                            affichageAgpm=affichageListe.get(0);
	  	   	    	 				                            affichageAgpm.setAffAgpCommentaire(agpm.getAgpCommentaire());
	  	   	    	 				                            affichageAgpm.setAffAgpCode(agpm.getAgpCode());
	  		    	 					                        iservice.updateObject(affichageAgpm);
	  	   	    	 				                                                                  }
	  	   	    	 				                   
	  	   	    	 				                                       listeFinancement =(List<TFinancement>) iservice.getObjectsByColumn("TFinancement", new ArrayList<String>(Arrays.asList("FIN_ID")),	 
		  	  	  	   	    	   						                           new WhereClause("FIN_AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
		   	    	 				                                                         if(!listeFinancement.isEmpty()) {
		   	    	 				                                                             newFinancement=listeFinancement.get(0);
		   	    	 				                                                             newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
		   	    	 				     		     			                                 newFinancement.setTDevise(new TDevise(devCode));
		   	    	 				     		     			                                 newFinancement.setTBailleur(new TBailleur(baiCode));
		   	    	 				     		     			                                 newFinancement.setFinTypeFinance(sourfin);
		   	    	 				     		     			                                 newFinancement.setFinStatut("1");
		   	    	 				     		     			                                 newFinancement.setTAgpm(agpm);
		   	    	 				     		     			                                 newFinancement.setTProjet(projet);
			    	 					                                                         iservice.updateObject(newFinancement);
		   	    	 				                                                            }
	  	   	    	 				                                                      
	  	   	    	 				                                    //Message de confirmation
		   	    	 				                                    userController.setTexteMsg("Agpm mis à jour avec succès!");
		   	    	 				     		  				        userController.setRenderMsg(true);
		   	    	 				     		  				        userController.setSevrityMsg("success");
	    	 				                               }else {
	    	 				                        	  
	    	 				                        	 	//Insertion dans T_Projet
	    	 				                                iservice.addObject(projet);
	    	 				        		      			//Insertion dans T_AGPM	 
	    	 				     	      				    agpm.setTGestion(new TGestion(gesCode));
	    	 				     	      				    agpm.setTStatut(new TStatut("S1S"));
	    	 				     	      				    agpm.setAgpActif("1");
	    	 				     	      				    agpm.setAgpStatutRetour("0");
	    	 				     	      			        agpm.setTProjet(projet);
	    	 				     	      			        agpm.setAgpActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
	    	 				     	      				    agpm.setTFonction(userController.getSlctd().getTFonction());
	    	 				     	      				    agpm.setTStructure(userController.getSlctd().getTFonction().getTStructure());
	    	 				     	      				    iservice.addObject(agpm);
	    	 				     	      				    //Enregistre un financement
	    	 				     	      				    if(sourfin.equalsIgnoreCase("ETAT")) {
	    	 				     	      				      baiCode ="ETAT";
	    	 				                 	        	  newFinancement.setTBailleur(new TBailleur(baiCode)); 
	    	 				                 	             }else
	    	 				                 	        	  {
	    	 				                 	            	newFinancement.setTBailleur(new TBailleur(baiCode));  
	    	 				                 	        	  }
	    	 				     		      				newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
	    	 				     		     			    newFinancement.setTDevise(new TDevise(devCode));
	    	 				     		     			    newFinancement.setFinTypeFinance(sourfin);
	    	 				     		     			    newFinancement.setFinStatut("1");
	    	 				     		     			    newFinancement.setTAgpm(agpm);
	    	 				     		     			    newFinancement.setTProjet(projet);
	    	 				     		     				iservice.addObject(newFinancement);
	    	 				     		      				rappelProjet();
	    	 				     		      				List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
	    	 				     		  					TStatut statuts = new TStatut();
	    	 				     		  					if(!LS.isEmpty()) statuts = LS.get(0);
	    	 				     		  					//Historisation des Agpm
	    	 				     		  					THistoAgpm agpmStatut = new THistoAgpm();
	    	 				     		  					agpmStatut.setHagDate(Calendar.getInstance().getTime());
	    	 				     		  					agpmStatut.setHagMotif("Création de l'agpm par l'Autorité Contractante");
	    	 				     		  					agpmStatut.setTFonction(userController.getSlctd().getTFonction());
	    	 				     		  					agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
	    	 				     		  					agpmStatut.setTStatut(statuts);
	    	 				     		  					agpmStatut.setTAgpm(agpm);
	    	 				     		  					iservice.addObject(agpmStatut);
	    	 				     		  						  
	    	 				     		  					//Insertion dans TAffichageAgpm
	    	 				     		  					affichageAgpm.setAffAgpActeurSaisie(agpm.getAgpActeurSaisie());
	    	 				     		  					affichageAgpm.setAffAgpActif(agpm.getAgpActif());
	    	 				     		  				    affichageAgpm.setAffAgpCode(agpm.getAgpCode());
	    	 				     		  					affichageAgpm.setAffAgpStatutRetour(agpm.getAgpStatutRetour());
	    	 				     		  					affichageAgpm.setAffAgpId(agpm.getAgpId());
	    	 				     		  					affichageAgpm.setTBailleur(new TBailleur(baiCode));
	    	 				     		  					affichageAgpm.setTDevise(new TDevise(devCode));
	    	 				     		  					affichageAgpm.setTFinancement(newFinancement);
	    	 				     		  					affichageAgpm.setAffAgpCommentaire(agpm.getAgpCommentaire());
	    	 				     		  					affichageAgpm.setTFonction(userController.getSlctd().getTFonction());
	    	 				     		  					affichageAgpm.setAffAgpActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
	    	 				     		  					affichageAgpm.setTStructure(userController.getSlctd().getTFonction().getTStructure());
	    	 				     		  					affichageAgpm.setTGestion( new TGestion(gesCode));
	    	 				     		  					affichageAgpm.setTProjet(projet);
	    	 				     		  					affichageAgpm.setTSourceFinancement(new TSourceFinancement(souCode));
	    	 				     		  					affichageAgpm.setTStatut(statuts);
	    	 				     		  					iservice.addObject(affichageAgpm); 
	    	 				     		  						
	    	 				     		  					
	    	 				     		  					String search = affichageAgpm.getAffAgpId()+""+affichageAgpm.getTBailleur().getBaiCode()+""+affichageAgpm.getTFinancement().getFinNumeroAccord()+""+affichageAgpm.getTGestion().getGesCode()+""+affichageAgpm.getTProjet().getProTitre();
	    	 				    							String rechercheAll = search.replace("null","");
	    	 				    							
	    	 				     		  						
	    	 				     		  					List<TAffichageAgpm> AFG =iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
	    	 				     			      				new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+affichageAgpm.getAffAgpId()));
	    	 				     		      				TAffichageAgpm affgp = new TAffichageAgpm();
	    	 				     		      				if(!AFG.isEmpty()) affgp =AFG.get(0); 
	    	 				     		      					
	    	 				     		  					affgp.setAffAgpRecherche(rechercheAll);
	    	 				     		      				iservice.updateObject(affgp);
	    	 				     		  						
	    	 				     		  					userController.setTexteMsg("Enregistrement effectué avec succès!");
	    	 				     		  					userController.setRenderMsg(true);
	    	 				     		  					userController.setSevrityMsg("success");
	    	 				     		  					etatPavetDeclarant= true;
	    	 				     		  					etatAutreInfo= false;
	    	 				     		  					etatPavetDossier= false; 
	    	 				     		  					etatPavetInfoProjet= true; 
	    	 				     		  					etatPavetOrgne= true;
	    	 				     		  					btn_saveProjet =false;
	    	 				     		  				    paveInformations = true;
	    	 				     		  				    paveConfirmation = true;
	    	 				     		  				    btn_saveProjet =false;
	    	 				                                }
	                                                }
	      		              /*}else {
	      		                     FacesContext.getCurrentInstance().addMessage(null,
	      		           	         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ce bailleur a déjà saisi son AGPM", ""));
	      		                   }*/
	      		          }
	  
	  //Methode suppression Agpm
	  public void deleteAgpm() {
		  //AffichageAgpm
		  iservice.deleteObject(slctdTd);
		  
		  //Financement
	   	  List<TFinancement> FIN =iservice.getObjectsByColumn("TFinancement", new ArrayList<String>(Arrays.asList("FIN_ID")),
	   		     new WhereClause("FIN_ID",WhereClause.Comparateur.EQ,""+slctdTd.getTFinancement().getFinId()));
	   	         TFinancement financement = new TFinancement();
	   	   		 if(!FIN.isEmpty()) financement =FIN.get(0); 	
	   	   		 iservice.deleteObject(financement);
	   	   		 
	   	   	 //Historique
	   	   	  List<THistoAgpm> HIS =iservice.getObjectsByColumn("THistoAgpm", new ArrayList<String>(Arrays.asList("HAG_ID")),
	   	   		     new WhereClause("HAG_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
	   	             THistoAgpm histo = new THistoAgpm();
	   	   	   		 if(!HIS.isEmpty()) histo =HIS.get(0); 	
	   	   	   		 iservice.deleteObject(histo);
	   	   	   	   		 
	   	   	   	 //Dossiers
	   	   	   	   	  List<TDossierAgpm> DOS =iservice.getObjectsByColumn("TDossierAgpm", new ArrayList<String>(Arrays.asList("DAG_ID")),
	   	   	   	   		     new WhereClause("DAG_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
	   	   	              	TDossierAgpm dossier = new TDossierAgpm();
	   	   	   	   	   		 if(!DOS.isEmpty()) dossier =DOS.get(0); 	
	   	   	   	   	   		 iservice.deleteObject(dossier);
	   	   	   	   	   		 
	   	   		   		 
	   	   		   	   	 //Details
	   	   		   	   	   	  List<TDetailAgpm> DET =iservice.getObjectsByColumn("TDetailAgpm", new ArrayList<String>(Arrays.asList("TDA_ID")),
	   	   		   	   	   		     new WhereClause("TDA_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
	   	   		   	                 TDetailAgpm detail = new TDetailAgpm();
	   	   		   	   	   	   		 if(!DET.isEmpty()) detail =DET.get(0); 	
	   	   		   	   	   	   		 iservice.deleteObject(detail);
	   	   		   	   	   	   		 
	   	   		   	   	       //Agpm
	   	   	   		   	   	   	  List<TAgpm> AGP =iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
	   	   	   		   	   	   		     new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
	   	   	   		   	                 TAgpm agpm = new TAgpm();
	   	   	   		   	   	   	   		 if(!AGP.isEmpty()) agpm =AGP.get(0); 	
	   	   	   		   	   	   	   		 iservice.deleteObject(agpm);
	   	   	   		   	   	   	   		 
	   	   	   		   	   	//Projet
 	   	   		   	   	   	  List<TProjet> PRO =iservice.getObjectsByColumn("TProjet", new ArrayList<String>(Arrays.asList("PRO_ID")),
 	   	   		   	   	   		     new WhereClause("PRO_ID",WhereClause.Comparateur.EQ,""+slctdTd.getTProjet().getProId()));
 	   	   		                  	TProjet  projet = new TProjet();
 	   	   		   	   	   	   		 if(!PRO.isEmpty()) projet =PRO.get(0); 	
 	   	   		   	   	   	   		 iservice.deleteObject(projet);
	   	   			
					  chargeData();
					  userController.setTexteMsg("Sppression éffectuée avec succès!");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");
	  }
	  
	  //Les methodes de l'ecran de methodeModification 
 	 public void modifier() {
 		 slctdTd.setTBailleur(new TBailleur(baiCode));
 		 slctdTd.setTDevise(new TDevise(devCode));
 		 
 		 //Projet
 		 List<TProjet> PRO =iservice.getObjectsByColumn("TProjet", new ArrayList<String>(Arrays.asList("PRO_ID")),
	      				new WhereClause("PRO_ID",WhereClause.Comparateur.EQ,""+slctdTd.getTProjet().getProId()));
 		TProjet projet = new TProjet();
   				if(!PRO.isEmpty()) projet =PRO.get(0); 	
   				projet.setProTypeProjet(updateAgpm.getProTypeProjet());
   				projet.setProTitre(updateAgpm.getProTitre());
   				iservice.updateObject(projet);
   			
   			 //Agpm
   	 		 List<TAgpm> AGP =iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
   		      				new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
   	 		TAgpm agpm = new TAgpm();
   	   				if(!AGP.isEmpty()) agpm =AGP.get(0); 	
   	   			  agpm.setAgpCommentaire(updateAgpm.getAffAgpCommentaire());
   	   				iservice.updateObject(agpm);
   	   				
   	   			 //Declarant
   	   	 		 List<TDeclarant> DEC =iservice.getObjectsByColumn("TDeclarant", new ArrayList<String>(Arrays.asList("DEC_ID")),
   	   		      				new WhereClause("DEC_ID",WhereClause.Comparateur.EQ,""+slctdTd.getTDeclarant().getDecId()));
   	   	 		TDeclarant declarant = new TDeclarant();
   	   	   				if(!DEC.isEmpty()) declarant =DEC.get(0); 	
   	   	   		if(declarant.getDecId() > 0 ) {
   	   	   	         declarant.setDecOrganExecLibelle(updateAgpm.getDecOrganExecLibelle());
	   		         declarant.setDecOrganExecAdresse(updateAgpm.getDecOrganExecAdresse());
	   		         declarant.setDecPersNomPrenom(updateAgpm.getDecPersNomPrenom());
	   		         declarant.setDecPersFonction(updateAgpm.getDecPersFonction());  
	   		         declarant.setDecLocalisation(updateAgpm.getDecLocalisation());
	   		         declarant.setDecNumeroPorte(updateAgpm.getDecNumeroPorte()); 
	   		         declarant.setDecBp(updateAgpm.getDecBp());
	   		         declarant.setDecCel(updateAgpm.getDecCel());  
	   		         declarant.setDecTelephone(updateAgpm.getDecTelephone()); 
	   		         declarant.setDecEmail(updateAgpm.getDecEmail());
	   				iservice.updateObject(declarant);	
   	   	   		}else
   	   	   		{
   	   	   	     declarant.setDecOrganExecLibelle(updateAgpm.getDecOrganExecLibelle());
		         declarant.setDecOrganExecAdresse(updateAgpm.getDecOrganExecAdresse());
		         declarant.setDecPersNomPrenom(updateAgpm.getDecPersNomPrenom());
		         declarant.setDecPersFonction(updateAgpm.getDecPersFonction());  
		         declarant.setDecLocalisation(updateAgpm.getDecLocalisation());
		         declarant.setDecNumeroPorte(updateAgpm.getDecNumeroPorte()); 
		         declarant.setDecBp(updateAgpm.getDecBp());
		         declarant.setDecCel(updateAgpm.getDecCel());  
		         declarant.setDecTelephone(updateAgpm.getDecTelephone()); 
		         declarant.setDecEmail(updateAgpm.getDecEmail());	
		         iservice.addObject(declarant);
   	   	   		}
   	   	   		        
   	   				
   	   	   		 //Declarant
   	   	   	 		 List<TFinancement> FIN =iservice.getObjectsByColumn("TFinancement", new ArrayList<String>(Arrays.asList("FIN_ID")),
   	   	   		      				new WhereClause("FIN_ID",WhereClause.Comparateur.EQ,""+slctdTd.getTFinancement().getFinId()));
   	   	   	TFinancement financement = new TFinancement();
   	   	   	   				if(!FIN.isEmpty()) financement =FIN.get(0); 	
   	   	   	           	financement.setFinTypeFinance(updateAgpm.getFinTypeFinance());
   	   	   	            //financement.setTSourceFinancement(new TSourceFinancement(updateAgpm.getFinSouCode()));
   	   	   	            financement.setTDevise(new TDevise(updateAgpm.getFinDevCode()));
   	   	   	            financement.setTBailleur(new TBailleur(updateAgpm.getBaiCode()));
   	   	   	            financement.setFinMontantDevise(updateAgpm.getFinMontantDevise());
   	   	   	            //financement.setFinMontantCfa(updateAgpm.getFinMontantCfa());
   	   	   	            financement.setFinPartTresor(updateAgpm.getFinPartTresor()); 
   	   	   	            financement.setFinMontantDevise(updateAgpm.getFinMontantDevise());
   	   	   	            financement.setFinNumeroAccord(updateAgpm.getFinNumeroAccord());
   	   	   	   			iservice.updateObject(financement);

   	   			 //AffichageAgpm
   	   			 slctdTd.setAffAgpCommentaire(updateAgpm.getAffAgpCommentaire());
   	   		     slctdTd.setTProjet(projet);
   	   		     slctdTd.setTFinancement(financement);
   	   		     slctdTd.setTBailleur(new TBailleur(updateAgpm.getBaiCode()));
   	   		     slctdTd.setTDeclarant(declarant);
   	   		     slctdTd.setTDevise(new TDevise(updateAgpm.getFinDevCode()));
   	   		     slctdTd.setTSourceFinancement( new TSourceFinancement(updateAgpm.getAffSouCode()));
   	   	   		 iservice.updateObject(slctdTd);
   	   				
 		 chargeData();
			 userController.setTexteMsg("Modification éffectuée avec succès!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
 	 }
 	 
 	 
 	 
 	 public void updatedetail() {  
 		 sltdetail.setTContenuAgpm(new TContenuAgpm(tcaCode));
			    	iservice.updateObject(sltdetail);
			    	chargeDetailModif();
				    userController.setTexteMsg("Mise a jour éffectuée avec succès!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");
	      	 }
 	 
 	 public void updatedetailSaisie() {  
 		 sltdetail.setTContenuAgpm(new TContenuAgpm(tcaCode));
			    	iservice.updateObject(sltdetail);
			    	chargeDetail();
				    userController.setTexteMsg("Mise a jour éffectuée avec succès!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");
	      	 }
 	 
 	/* public void savedetailupdate() { 
 		 List<TAffichageAgpm> AFG =iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
	      				new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
   				TAffichageAgpm affgp = new TAffichageAgpm();
   				if(!AFG.isEmpty()) affgp =AFG.get(0); 
   					
					affgp.setAffAgpRecherche(rechercheAll);
   				iservice.updateObject(affgp);
 	 
 	 slctdTd.setTAgpm(agpm); 
	    	detail.setTContenuAgpm(new TContenuAgpm(tcaCode));
	    	detail.setTdaNumOrdre(keyGen.getNumeroOrdre());
	    	iservice.addObject(detail); 
	    	chargeDetail();
 	 }*/
	  
	      	 
	      	 //Enregistrement des detail
	      	 public void saveDetail() {
			     for(TDetailAgpm d : detailAgpm){
			    	d.setTAgpm(agpm);
			    	d.setTContenuAgpm(new TContenuAgpm(tcaCode));
			    	d.setTdaNumOrdre(keyGen.getNumeroOrdre());
			    	iservice.addObject(d); 
			     }
				     userController.setTexteMsg("Enregistrement effectué avec succès!");
					 userController.setRenderMsg(true);
					 userController.setSevrityMsg("success");
					 etatPavetDossier= true; 
	      	 }
	      	 
	  
	      	 
	    	 public void saveDetail1() { 
		      		if(acte.getProId() > 0) {
				    	detail.setTAgpm(new TAgpm(acte.getAgpId())); 
				    	detail.setTContenuAgpm(new TContenuAgpm(tcaCode));
				    	detail.setTdaNumOrdre(keyGen.getNumeroOrdre());
				    	iservice.addObject(detail); 
				    	
				    	chargeDetailRappel();
				    	detail = new TDetailAgpm();
					    userController.setTexteMsg("Détail ajouté avec succès!");
						userController.setRenderMsg(true);
						userController.setSevrityMsg("success");
						etatPavetDossier= true; 
		      		}else {
		      			
		      			detail.setTAgpm(agpm); 
				    	detail.setTContenuAgpm(new TContenuAgpm(tcaCode));
				    	detail.setTdaNumOrdre(keyGen.getNumeroOrdre());
				    	iservice.addObject(detail); 
				    	chargeDetail();
				    	detail = new TDetailAgpm();
					    userController.setTexteMsg("Détail ajouté avec succès!");
						userController.setRenderMsg(true);
						userController.setSevrityMsg("success");
						etatPavetDossier= true;
		      		}
		      	 }
		 
		 
	      	 //ENREGISTREMENT CPMP ET DMP
	      	@Transactional
     		 public void creerProjetCpmpDmp() throws IOException{
	      		 if(acte.getProId() > 0) {
      				 List<TProjet> PR =iservice.getObjectsByColumn("TProjet", new ArrayList<String>(Arrays.asList("PRO_ID")),
      						new WhereClause("PRO_ID",WhereClause.Comparateur.EQ,""+acte.getProId()));
      				TProjet proj = new TProjet();
      				 if(!PR.isEmpty()) proj =PR.get(0); 
      				    projet = proj;
      				
      					proj.setProTitre(acte.getProTitre());
      					proj.setProDescription(acte.getProDescription());
      					proj.setProTypeProjet(projet.getProTypeProjet());
      					iservice.updateObject(proj);
      					newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
      				    newFinancement.setTDevise(new TDevise(devCode));
      				    newFinancement.setTBailleur(new TBailleur(baiCode));
      				    newFinancement.setTAgpm(agpm);
      				    newFinancement.setTProjet(projet);
      					iservice.updateObject(newFinancement);
      					
      					
      					List<TAgpm> AG =iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
	      						new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+acte.getAgpId()));
      					TAgpm agp = new TAgpm();
      					if(!AG.isEmpty()) agp =AG.get(0); 
      					agpm = agp;
      					
      					
      					agp.setTGestion(new TGestion(gesCode));
      					agp.setTStatut(new TStatut("S1S"));
      					agp.setAgpStatutRetour("0");
      					agp.setAgpActif("1");
      					agp.setTFonction(recupFonction);
      					agp.setTStructure(userController.getSlctd().getTFonction().getTStructure());
      					agp.setAgpActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
      					agp.setAgpTypeDao(acte.getAgpTypeDao());
      					agp.setAgpModePassation(acte.getAgpModePassation());
      					iservice.updateObject(agp);
      					
      					rechercheDeclarant();
  	                     chargeDossier();
  	                     rappelProjet();
  	                     rappelDeclarant();	
      						  userController.setTexteMsg("Projet ou Programme mis à jour avec succès !");
      						  userController.setRenderMsg(true);
      						  userController.setSevrityMsg("success");
      						  
      						  etatPavetDeclarant= true;
      						  etatAutreInfo= false;
      						  etatPavetDossier= true; 
      						  etatPavetInfoProjet= true; 
      						  etatPavetOrgne= true;  
      				      
      			      }else {
      			    	
      				   iservice.addObject(projet);
      				 
      				   agpm.setTGestion(new TGestion(gesCode));
      				   agpm.setTStatut(new TStatut("S1S"));
      				   agpm.setAgpActif("1");
      				   agpm.setAgpStatutRetour("0");
      			       agpm.setTProjet(projet);
      			       agpm.setAgpActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
      			       agpm.setTFonction(recupFonction);
 					   agpm.setTStructure(userController.getSlctd().getTFonction().getTStructure());
      				   iservice.addObject(agpm);
      				   //Enregistre un financement
	      				newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
	     			    newFinancement.setTDevise(new TDevise(devCode));
	     			    newFinancement.setTBailleur(new TBailleur(baiCode));
	     			    newFinancement.setFinStatut("1");
	     			    newFinancement.setTAgpm(agpm);
	     			    newFinancement.setTProjet(projet);
	     				iservice.addObject(newFinancement);
	      				 rappelProjet();

      			      }
	      		 
      			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
					TStatut statuts = new TStatut();
					if(!LS.isEmpty()) statuts = LS.get(0);
					  //Historisation des Agpm
					     THistoAgpm agpmStatut = new THistoAgpm();
					      agpmStatut.setHagDate(Calendar.getInstance().getTime());
					      agpmStatut.setHagMotif("Demande mis à jour par l'Autorité Contractante");
					      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
					      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
					      agpmStatut.setTStatut(statuts);
					      agpmStatut.setTAgpm(agpm);
						  iservice.addObject(agpmStatut);
						  
						  //Insertion dans TAffichageAgpm
						affichageAgpm.setAffAgpActeurSaisie(agpm.getAgpActeurSaisie());
						affichageAgpm.setAffAgpActif(agpm.getAgpActif());
						affichageAgpm.setAffAgpStatutRetour(agpm.getAgpStatutRetour());
						affichageAgpm.setAffAgpId(agpm.getAgpId());
						affichageAgpm.setTBailleur(new TBailleur(baiCode));
						affichageAgpm.setAffAgpCommentaire(agpm.getAgpCommentaire());
						affichageAgpm.setTDevise(new TDevise(devCode));
						affichageAgpm.setTFinancement(newFinancement);
						affichageAgpm.setTFonction(recupFonction);
						affichageAgpm.setTStructure(userController.getSlctd().getTFonction().getTStructure());
						affichageAgpm.setAffAgpActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
						affichageAgpm.setTGestion( new TGestion(gesCode));
						affichageAgpm.setTProjet(projet);
						affichageAgpm.setTSourceFinancement(new TSourceFinancement(souCode));
						affichageAgpm.setTStatut(statuts);
						iservice.addObject(affichageAgpm);
						 userController.setTexteMsg("Enregistrement effectué avec succès!");
						 userController.setRenderMsg(true);
						 userController.setSevrityMsg("success");
						 etatPavetDeclarant= true;
						 etatAutreInfo= false;
						 etatPavetDossier= true; 
						 etatPavetInfoProjet= true; 
						 etatPavetOrgne= true;
     		 }
	 
	      	
	      	
	      	
	      //Créer le déclarant en ajoutant sa clé dans t_Agpm
			 public void creerDeclarant() throws IOException{
				 
				 if(acte.getProId()>0 ) {
					 
					 iservice.addObject(declarant);
					    
				     listeAgpm=(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),	 
						 new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+acte.getAgpId()));
				   if(!listeAgpm.isEmpty()) {
					  TAgpm rect = new TAgpm();
							rect=listeAgpm.get(0);
							rect.setTDeclarant(new TDeclarant(declarant.getDecId()));
							iservice.updateObject(rect);
							
							 
							String search = affichageAgpm.getTBailleur().getBaiCode()+""+affichageAgpm.getTFinancement().getFinNumeroAccord()+""+affichageAgpm.getTGestion().getGesCode()+""+affichageAgpm.getTProjet().getProTitre()+""+affichageAgpm.getTDeclarant().getDecOrganExecLibelle();
							String rechercheAll = search.replace("null","");
							
							List<TAffichageAgpm> AFG =iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
		      						new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+acte.getAgpId()));
	      					TAffichageAgpm affgp = new TAffichageAgpm();
	      					if(!AFG.isEmpty()) affgp =AFG.get(0); 
	      					affgp.setTDeclarant(rect.getTDeclarant());
	  						affgp.setAffAgpRecherche(rechercheAll);
	      					iservice.updateObject(affgp);
							
							boutonEdit=true;
							boutonAdd = false;
							etatPavetDossier = true;
				         } 
				 boutonEdit=true;
				 boutonAdd = false;
				 userController.setTexteMsg("Adresse ajoutée avec succès !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
				 etatPavetDeclarant= true;
				 etatAutreInfo= false;
				 etatPavetDossier= true; 
				 etatPavetInfoProjet= false; 
				 etatPavetOrgne= true;
				 
					 
				 }else {
					 
					 iservice.addObject(declarant);
					    
				     listeAgpm=(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),	 
						 new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
				   if(!listeAgpm.isEmpty()) {
					  TAgpm rect = new TAgpm();
							rect=listeAgpm.get(0);
							rect.setTDeclarant(new TDeclarant(declarant.getDecId()));
							iservice.updateObject(rect);
							affichageAgpm.setTDeclarant(rect.getTDeclarant());
							iservice.updateObject(affichageAgpm);
							boutonEdit=true;
							boutonAdd = false;
				         } 
				   
				   
				   List<TAffichageAgpm> AFG =iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
     						new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
 					TAffichageAgpm affgp = new TAffichageAgpm();
 					if(!AFG.isEmpty()) affgp =AFG.get(0); 
 					affgp.setTDeclarant(affichageAgpm.getTDeclarant());
					//affgp.setAffAgpRecherche(rechercheAll);
 					iservice.updateObject(affgp);
				   
				  boutonEdit=true;
				  boutonAdd = false;
				  userController.setTexteMsg("Adresse ajoutée avec succès !");
				  userController.setRenderMsg(true);
				  userController.setSevrityMsg("success");
				 etatPavetDeclarant= true;
				 etatAutreInfo= false;
				 etatPavetDossier= true; 
				 etatPavetInfoProjet= false; 
				 etatPavetOrgne= true; 
				 }	    
			}
		 
		 
		 @Transactional
		 public String saveAgpm() throws IOException{
			 iservice.addObject(declarant);

			 agpm.setTGestion(new TGestion(gesCode));
			 agpm.setTStatut(new TStatut("S1S"));
			 agpm.setAgpActif("1");
			 agpm.setAgpStatutRetour("0");
		     agpm.setTProjet(projet);
			 agpm.setTFonction(new TFonction(fonction.getFonCod()));
			 agpm.setTStructure(new TStructure(structure.getStrCode()));
			 agpm.setTDeclarant(declarant);

			 iservice.addObject(agpm);
			 
			 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
				TStatut statuts = new TStatut();
				if(!LS.isEmpty()) statuts = LS.get(0);
				  //Historisation des Agpm
				     THistoAgpm agpmStatut = new THistoAgpm();
				      agpmStatut.setHagDate(Calendar.getInstance().getTime());
				      agpmStatut.setHagMotif("Demande Transmise à la CPMP");
				      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
				      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
				      agpmStatut.setTStatut(statuts);
				      agpmStatut.setTAgpm(agpm);
					  iservice.addObject(agpmStatut);
					  chargeData();
					  
					  userController.setTexteMsg("Enregistrement effectué avec succès !");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");
					  
					     etatPavetDeclarant= true;
						 etatAutreInfo= true;
						 etatPavetDossier= true;
						 //vider();
						 return null;
			          //return renderPage("agpm1","LIS");
		 }
		 
		 @Transactional
		 public String creerAgpm() throws IOException{
			 agpm.setTGestion(new TGestion(gesCode));
			 agpm.setTStatut(new TStatut("S1S"));
			 agpm.setAgpActif("1");
		     agpm.setTProjet(projet);
			 agpm.setTFonction(userController.getSlctd().getTFonction());
			 agpm.setTStructure(new TStructure(userController.getSlctd().getTFonction().getTStructure().getStrCode()));
			 agpm.setTDeclarant(declarant);

			 iservice.addObject(agpm);
			 
			 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
				TStatut statuts = new TStatut();
				if(!LS.isEmpty()) statuts = LS.get(0);
				  //Historisation des Agpm
				     THistoAgpm agpmStatut = new THistoAgpm();
				      agpmStatut.setHagDate(Calendar.getInstance().getTime());
				      agpmStatut.setHagMotif("Demande Transmise à la CPMP");
				      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
				      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
				      agpmStatut.setTStatut(statuts);
				      agpmStatut.setTAgpm(agpm);
					  iservice.addObject(agpmStatut);
					  chargeData();
					  userController.setTexteMsg("Enregistrement effectué avec succès !");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");
					  
					  etatPavetDeclarant= true;
					  etatAutreInfo= true;
					  etatPavetDossier= true;
						 //vider();
						 return null;
			          //return renderPage("agpm1","LIS");
		   }
		 
	
		 
		 
		//Tri sur les types de financement  
		public void chargeSourceCheck() { 
			listeSourceFinance.clear();
		listeSourceFinance=(List<TSourceFinancement>) iservice.getObjectsIn("TSourceFinancement", new ArrayList<String>(Arrays.asList("SOU_CODE")),
		      "SOU_CODE", new ArrayList<String>(Arrays.asList("EMP","DON")));
			}
		
		//Tri sur les types de financement 
		public void chargeSourceEtat() { 
		    listeSourceFinance.clear();
			listeSourceFinance=(List<TSourceFinancement>) iservice.getObjectsIn("TSourceFinancement", new ArrayList<String>(Arrays.asList("SOU_CODE")),
			      "SOU_CODE", new ArrayList<String>(Arrays.asList("TRE")));
				}
		
		 //Methode checkBailleur
		 public void checkBailleur() {
			 //sourfin="";
			 if(sourfin.equalsIgnoreCase("Bailleur")) { 
				 selectBailleur = true;
				 selectTresor = false;
				 selectPartBai = true;
				 chargeSourceCheck();
				 //sourfin="";
			 }else {
				  if(sourfin.equalsIgnoreCase("Cofinance")){
						 selectBailleur = true; 
						 selectTresor = true;
						 selectPartBai = true;
						 chargeSourceFinance();
					 }else 
						 if(sourfin.equalsIgnoreCase("Etat")){
						 selectBailleur = false;
						 selectTresor = true;
						 selectPartBai= false;
						 souCode="TRE";
						 chargeSourceEtat();
					    }
			     }   
		 }
		 
		 
		//Méthode de checkDocument
		 public TDossierAgpm checkDocument(String agpCode, String natPiece) {
		                  TDossierAgpm val ;
		           List<TDossierAgpm> listDoc = ((List<TDossierAgpm>)iservice.getObjectsByColumn("TDossierAgpm",new ArrayList<String>(Arrays.asList("DAG_NAP_CODE")),
		                new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+agpCode),
		               new WhereClause("DAG_NAP_CODE",Comparateur.EQ,""+natPiece)));
		           
		                return (listDoc.isEmpty() || listDoc==null)?null:listDoc.get(0);
		            }
		 
		 
		//Méthode de vérification de l'AGPM Bailleur
		 public VAgpmBailleur checkAgpm(String agpId, String baiCode) {
			           VAgpmBailleur val ;
		           List<VAgpmBailleur> listAgpm = ((List<VAgpmBailleur>)iservice.getObjectsByColumn("VAgpmBailleur",new ArrayList<String>(Arrays.asList("AGP_ID")),
		                new WhereClause("AGP_ID",Comparateur.EQ,""+agpId),
		                new WhereClause("BAI_CODE",Comparateur.EQ,""+baiCode)));
		           
		                return (listAgpm.isEmpty() || listAgpm==null)?null:listAgpm.get(0);
		            }
		 
		 
		 @Transactional
		 public void valider() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 statutUpdate ="";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 statutUpdate ="S2V";
					 commentaire="AGPM validé par le CPMP";
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 statutUpdate ="S3V";
						 commentaire="AGPM validé par le DMP";
					 }
			     } 
			 }
					
			 listeAgpm =(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
				TAgpm agp = new TAgpm();
				if (!listeAgpm.isEmpty()) {
					agp= listeAgpm.get(0);
						if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
							 agp.setAgpDateValAc(Calendar.getInstance().getTime());
						 }else
							 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
								agp.setAgpDateValCpmp(Calendar.getInstance().getTime());
							 }else
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {	
									 agp.setAgpDateValDmp(Calendar.getInstance().getTime());
								 }
					agp.setTStatut(new TStatut(statutUpdate));
					agp.setAgpStatutRetour("0");
				iservice.updateObject(agp);
				chargeData();
			 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
			 TStatut statuts = new TStatut();
				if(!LS.isEmpty()) statuts = LS.get(0);
				  //Historisation des Agpm
				     THistoAgpm agpmStatut = new THistoAgpm();
				      agpmStatut.setHagDate(Calendar.getInstance().getTime());
				      agpmStatut.setHagMotif(commentaire);
				      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
				      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
				      agpmStatut.setTStatut(statuts);
				      agpmStatut.setTAgpm(agp);
					  iservice.addObject(agpmStatut);
					  
					//Enregistrement de TAffichage
					  validationListe =(List<TAffichageAgpm>) iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
	 							new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
	 					TAffichageAgpm affiche = new TAffichageAgpm();
	 					if (!validationListe.isEmpty()) {
	 						affiche= validationListe.get(0);
	 						affiche.setTStatut(new TStatut(statutUpdate));
	 						affiche.setAffAgpStatutRetour("0");
						iservice.updateObject(affiche);
					  chargeData();
					  chargeDataAvalider();
					  chargeAgpmValCp();
					  chargeAgpmValDmp();
					  userController.setTexteMsg(" Validation effectuée avec succès !");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");	
				}
				}
		 }
		 
		 //Differer
		 @Transactional
		 public void differer() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 statutUpdate ="";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 statutUpdate ="S2D";
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 if(slctdTd.getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("02")) {
							 statutUpdate ="S3D"; 
						 }else
							  if(slctdTd.getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("03")) {
								  statutUpdate ="SDR";  
							  }else {
								  statutUpdate ="S3D"; 
							  }
					   }else
						    if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						    	if(slctdTd.getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("02")) {
									 statutUpdate ="S3D"; 
								 }else
									  if(slctdTd.getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("03")) {
										  statutUpdate ="SDR";  
									  }else {
										  statutUpdate ="S3D"; 
									  }
				               }
			             } 
			        }
			   listeAgpm =(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
			   if (!listeAgpm.isEmpty()) {
				   TAgpm agp = new TAgpm();
				     agp= listeAgpm.get(0);
				     agp.setTStatut(new TStatut(statutUpdate));
					 agp.setAgpStatutRetour("1");
					 iservice.updateObject(agp);
			   
				    chargeData();
				    
				    
				    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
					 TStatut statuts = new TStatut();
						if(!LS.isEmpty()) statuts = LS.get(0);
						  //Historisation des Agpm
						     THistoAgpm agpmStatut = new THistoAgpm();
						      agpmStatut.setHagDate(Calendar.getInstance().getTime());
						      agpmStatut.setHagMotif(getObservation());
						      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
						      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
						      agpmStatut.setTStatut(statuts);
						      agpmStatut.setTAgpm(agp);
							  iservice.addObject(agpmStatut);
							  
							  
								//Enregistrement de TAffichage
							  validationListe =(List<TAffichageAgpm>) iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
			 							new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
			 					TAffichageAgpm affiche = new TAffichageAgpm();
			 					if (!validationListe.isEmpty()) {
			 						affiche= validationListe.get(0);
			 						affiche.setTStatut(new TStatut(statutUpdate));
			 						affiche.setAffAgpStatutRetour("1");
								    iservice.updateObject(affiche);
								    
								    chargeData();
							  chargeDataAvalider();
							  chargeAgpmDifCp(); 
							  chargeAgpmDifDmp();
							  tableauBordController.chargeDataAgpm();
							  userController.setTexteMsg(" Désolé, votre Agpm a été rejeté!");
							  userController.setRenderMsg(true);
							  userController.setSevrityMsg("success");		
		       }
	        }
		 }
		 
		 
		 //Re-Differer par la CPMP
		 @Transactional
		 public void reDifferer() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 statutUpdate ="";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 statutUpdate ="S2D";
				 } 
			   }
			 
			   listeAgpm =(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
			   if (!listeAgpm.isEmpty()) {
				   TAgpm agp = new TAgpm();
				     agp= listeAgpm.get(0);
				     agp.setTStatut(new TStatut(statutUpdate));
					 agp.setAgpStatutRetour("1");
					 iservice.updateObject(agp);
			   
		
					 listeHisto =(List<THistoAgpm>) iservice.getObjectsByColumn("THistoAgpm", new ArrayList<String>(Arrays.asList("HAG_ID")),
								new WhereClause("HAG_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()),
								new WhereClause("HAG_STA_CODE",WhereClause.Comparateur.EQ,"S3D"));
					   if (!listeHisto.isEmpty()) {
						   histoAgpm= listeHisto.get(0); 
					   }
				    
				    List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutUpdate));
					 TStatut statuts = new TStatut();
						if(!LS.isEmpty()) statuts = LS.get(0);
						  //Historisation des Agpm
						     THistoAgpm agpmStatut = new THistoAgpm();
						      agpmStatut.setHagDate(Calendar.getInstance().getTime());
						      agpmStatut.setHagMotif(histoAgpm.getHagMotif());
						      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
						      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
						      agpmStatut.setTStatut(statuts);
						      agpmStatut.setTAgpm(agp);
							  iservice.addObject(agpmStatut);
							  
							  
								//Enregistrement de TAffichage
							  validationListe =(List<TAffichageAgpm>) iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
			 							new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
			 					TAffichageAgpm affiche = new TAffichageAgpm();
			 					if (!validationListe.isEmpty()) {
			 						affiche= validationListe.get(0);
			 						affiche.setTStatut(new TStatut(statutUpdate));
			 						affiche.setAffAgpStatutRetour("1");
								    iservice.updateObject(affiche);
								    
							  chargeData();
							  chargeDataAvalider();
							  chargeAgpmDifCp(); 
							  chargeAgpmDifDmp();
							  tableauBordController.chargeDataAgpm();
							  userController.setTexteMsg("Désolé, votre Agpm a été retourner!");
							  userController.setRenderMsg(true);
							  userController.setSevrityMsg("success");		
		       }
	        }
		 }
		 
		
		 @Transactional 
			public String transmettreNew()throws IOException{
			 listeAgpm =(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("agpId")),
						new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+addAgpm.getAgpId()));
					if (!listeAgpm.isEmpty()) {
						demAgpm= listeAgpm.get(0);
						demAgpm.setTStatut(new TStatut("S1T"));
						demAgpm.setAgpStatutRetour("0");
				       iservice.updateObject(demAgpm);
					}
			 
					List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1T"));
					TStatut statuts = new TStatut();
					if(!LS.isEmpty()) statuts = LS.get(0);
					  //Historisation des Agpm
					     THistoAgpm agpmStatut = new THistoAgpm();
					      agpmStatut.setHagDate(Calendar.getInstance().getTime());
					      agpmStatut.setHagMotif("Demande Transmise à la CPMP");
					      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
					      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
					      agpmStatut.setTStatut(statuts);
					      agpmStatut.setTAgpm(demAgpm);
						  iservice.addObject(agpmStatut);
						  chargeData();
						  chargeAgpmTrans();
						  userController.setTexteMsg(" Transmission effectuée avec succès !");
						  userController.setRenderMsg(true);
						  userController.setSevrityMsg("success");
						 return	null;	
				}
		 

		 
		 
		 
		 
			//Methode Transmettre
	@Transactional 
	public void transmettre()throws IOException{
		
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				if(userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("02")) {
						statutTrans ="S1T"; 
					}else
						 if(userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode().equalsIgnoreCase("03")) {
							statutTrans ="SDT";  
								}else {
									  statutTrans ="SDT"; 
								  }
						   }
					
					 listeAgpm =(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
	 							new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
	 					TAgpm agpp = new TAgpm();
	 					if (!listeAgpm.isEmpty()) {
	 						agpp= listeAgpm.get(0);
	 						agpp.setTStatut(new TStatut(statutTrans));
	 						agpp.setAgpDateValAc(Calendar.getInstance().getTime());
	 						agpp.setAgpStatutRetour("0");
						   iservice.updateObject(agpp);
						   
						   List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,statutTrans));
							TStatut statuts = new TStatut();
							if(!LS.isEmpty()) statuts = LS.get(0);
								  //Historisation des Agpm
								     THistoAgpm agpmStatut = new THistoAgpm();
								      agpmStatut.setHagDate(Calendar.getInstance().getTime());
								      agpmStatut.setHagMotif("Demande Transmise à la CPMP");
								      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
								      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
								      agpmStatut.setTStatut(statuts);
								      agpmStatut.setTAgpm(agpp);
									  iservice.addObject(agpmStatut);
									  
									  
									//Enregistrement de TAffichage
									  affichageListe =(List<TAffichageAgpm>) iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
					 							new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
					 					TAffichageAgpm affiche = new TAffichageAgpm();
					 					if (!affichageListe.isEmpty()) {
					 						affiche= affichageListe.get(0);
					 						affiche.setTStatut(new TStatut(statutTrans));
					 						affiche.setAffAgpDateValAc(Calendar.getInstance().getTime());
					 						affiche.setAffAgpStatutRetour("0");
										iservice.updateObject(affiche);
										chargeData();  
									  rappelProjet();
									  chargeAgpmTrans();
									  userController.setTexteMsg(" Transmission effectuée avec succès !");
									  userController.setRenderMsg(true);
									  userController.setSevrityMsg("success");
					 					}	  
	 				  	}
	 						
				 }
				 
 					 
		 
				//Methode Upload
			 @Transactional
			 public void upload(FileUploadEvent event) throws IOException{
				 
				  if(acte.getProId()>0) {
					  
					  if(fileUploadController.handleFileUpload(event, acte.getAgpId()+"", natPiece)) {
							
							TDossierAgpm dos = checkDocument(""+acte.getAgpId(), natPiece);
							if(dos == null) {
								//check le dossier s'il existe à faire
								//TDossierAgpm dos = new TDossierAgpm(); //TNatureDocument 
								dos = new TDossierAgpm() ;
								//dos.setDagCode(keyGen.getCodeDossier(filePUploadController.getFileCode()+"-"));
								dos.setTNaturePiece(new TNaturePiece("AGPM"));
								dos.setTAgpm(new TAgpm(acte.getAgpId()));
								dos.setDagLibelle(fileUploadController.getFileName());
								dos.setDagCommentaire(fileUploadController.getDocNom());
								dos.setDagReference("");
								iservice.addObject(dos);
								chargeDossierRappel();
								rechercheProjet();
								//Message de Confirmation
								 userController.setTexteMsg("Document enregistré!");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("success");
							}else {
								   //Mis à jour du document
								   dos.setDagReference("");
								   dos.setDagLibelle(fileUploadController.getFileName());
								   dos.setDagCommentaire(fileUploadController.getDocNom());
								   iservice.updateObject(dos); 
								   //Chargement de la liste des documents
								   chargeDossierRappel();
								   rechercheProjet();
								   //Message de mis à jour
								   userController.setTexteMsg("Document mis à jour!");
								   userController.setRenderMsg(true);
								   userController.setSevrityMsg("success");
							      }
						     }else {
						    	//Message d'erreur
								 userController.setTexteMsg("Document non enregistré, charger à nouveau un document!");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("danger");
									}
					  
				    }else {
					  
					        if(fileUploadController.handleFileUpload(event, agpm.getAgpId()+"", natPiece)) {
							
							   TDossierAgpm dos = checkDocument(""+agpm.getAgpId(), natPiece);
							    if(dos == null) {
								//check le dossier s'il existe à faire
								//TDossierAgpm dos = new TDossierAgpm(); //TNatureDocument 
								  dos = new TDossierAgpm() ;
								//dos.setDagCode(keyGen.getCodeDossier(filePUploadController.getFileCode()+"-"));
								dos.setTNaturePiece(new TNaturePiece("AGPM"));
								//dos.setTAgpm(new TAgpm(acte.getAgpId()));
								dos.setTAgpm(agpm);
								dos.setDagLibelle(fileUploadController.getFileName());
								dos.setDagCommentaire(fileUploadController.getDocNom());
								dos.setDagReference("");
								iservice.addObject(dos);
								chargeDossier();
								rechercheProjet();
								//Message de Confirmation
								userController.setTexteMsg("Document enregistré!");
								userController.setRenderMsg(true);
								userController.setSevrityMsg("success");
							     }else {
								   //Mis à jour du document
								   dos.setDagReference("");
								   dos.setDagLibelle(fileUploadController.getFileName());
								   dos.setDagCommentaire(fileUploadController.getDocNom());
								   iservice.updateObject(dos); 
								   //Chargement de la liste des documents
								   chargeDossier();
								   rechercheProjet();
								   //Message de mis à jour
								   userController.setTexteMsg("Document mis à jour!");
								   userController.setRenderMsg(true);
								   userController.setSevrityMsg("success");
							    }
						     }else {
						    	//Message d'erreur
								 userController.setTexteMsg("Document non enregistré, charger à nouveau un document!");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("danger");
									}
				  }
			 	    	
	     }
	    
	     
		 
		 
		 //Detail Debut
		 public void chargeDetails() {
			 detailsList.clear();
			 detailsList = ((List<VAgpmDetails>)iservice.getObjectsByColumnDesc("VAgpmDetails",new ArrayList<String>(Arrays.asList("DAG_ID")),
						 new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+affichageAgpm.getAffAgpId())));
		    }
		 
		 
		  //Fin Detail Debut
            public void chargeDossier() {
			 dossListe.clear();
				 dossListe = ((List<TDossierAgpm>)iservice.getObjectsByColumnDesc("TDossierAgpm",new ArrayList<String>(Arrays.asList("DAG_ID")),
						 new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+affichageAgpm.getAffAgpId())));
		    }
            
            
          //Fin Detail Debut
            public void chargeDossierDetail() {
			 dossListe.clear();
				 dossListe = ((List<TDossierAgpm>)iservice.getObjectsByColumnDesc("TDossierAgpm",new ArrayList<String>(Arrays.asList("DAG_ID")),
						 new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+slctdTd.getAffAgpId())));
		    }
            
           //Chargement de dossiers lors du rappel
            public void chargeDossierRappel() {
      			 dossListe.clear();
      				 dossListe = ((List<TDossierAgpm>)iservice.getObjectsByColumnDesc("TDossierAgpm",new ArrayList<String>(Arrays.asList("DAG_ID")),
      						 new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+acte.getAgpId())));
      		    }
            
            
            public void openDossier() throws IOException{
       		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDagLibelle(), selectedDossier.getDagLibelle());
       		   }
            
            public void removeDossier(){
				downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDagLibelle(), selectedDossier.getDagLibelle());
				//check si le dossier est OM
					 iservice.deleteObject(selectedDossier);
					 chargeDossier();	 
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDagCommentaire()+" supprimé!", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);	
				}
            
		 public void vider() {
			 projet = new TProjet();
			 declarant = new TDeclarant();
			 agpm = new TAgpm(); ;
			 TGestion gesCode = new TGestion();
			 TReglementation regle = new TReglementation();
			 listeFinancement.clear();
			 composanteListe.clear();
			 besoinListe.clear();
			 dossListe.clear();
			 objectifListe.clear();
			 viderFinancement();
			 fonc="";
			 acte =new VProjetAgpm();
			 detail = new TDetailAgpm(); 
		 }
		 
		 //Ajout dynamique des Paragraphes des AGPM
		 public void addDetail() {
			 saveDetail1();
			 //detail.setTdaNumOrdre(keyGen.getNumeroOrdre());
			 tmpDetailAgpm = new TDetailAgpm();
			 tmpDetailAgpm.setTAgpm(agpm);
			 detailAgpm.add(this.tmpDetailAgpm);
	       	 setTmpDetailAgpm(new TDetailAgpm());
	       	 setBoutonSupp(true);
	        }
		 
		 //Suppression dynamique des pièces justificatives
		 public void removePieces(TDetailAgpm detail) {
			 detailAgpm.remove(detail);
			 iservice.deleteObject(detail);
	        }
		 
		
		// Fin Implementatio
		 
		
	 private boolean skip;
	 
	 public String onFlowProcess(FlowEvent event) {
		 System.out.println("etape old= "+event.getOldStep()+" New= "+event.getNewStep());
		//Controle Pavé création
		 if(event.getOldStep().equals("creation") && event.getNewStep().equals("Informations")) {
			 if( "".equals(gesCode) ||"".equals(userController.getFonction().getFonLibelle())||"".equals(userController.getFonction().getTStructure().getTMinistere().getMinLibelle()) 
					 ||"".equals(agpm.getAgpCommentaire())
					 ||"".equals(projet.getProTypeProjet()) ||"".equals(projet.getProTitre()))
			 {
            	  FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR, ""
							+ "Veuillez saisir les champs obligatoire SVP!", ""));
		          return "creation";
				} 
			 updateCreation();
			 chargeDetail();
			 userController.initMessage();
		     }
		 
		 
	            return event.getNewStep();
	    }
	 
	 public void updateCreation() {
		 //Projet
		 projet.setProTypeProjet(projet.getProTypeProjet()); 
		 projet.setProTitre(projet.getProTitre());
		 iservice.updateObject(projet);
		 
		 //Agpm
		 agpm.setAgpCommentaire(agpm.getAgpCommentaire());
		 iservice.updateObject(agpm);
		 
		 //Financement
		 newFinancement.setTSourceFinancement(new TSourceFinancement(souCode));
		 newFinancement.setTDevise(new TDevise(devCode));
		 newFinancement.setTBailleur(new TBailleur(baiCode));
		 newFinancement.setFinTypeFinance(sourfin);
		 newFinancement.setTAgpm(agpm);
		 newFinancement.setTProjet(projet);
		 iservice.updateObject(newFinancement);
		 
		 //AffichageAgpm
		 affichageAgpm.setAffAgpActeurSaisie(agpm.getAgpActeurSaisie());
		 affichageAgpm.setAffAgpActif(agpm.getAgpActif());
		 affichageAgpm.setAffAgpStatutRetour(agpm.getAgpStatutRetour());
		 affichageAgpm.setAffAgpId(agpm.getAgpId());
		 affichageAgpm.setTBailleur(new TBailleur(baiCode));
		 affichageAgpm.setTDevise(new TDevise(devCode));
		 affichageAgpm.setTFinancement(newFinancement);
		 affichageAgpm.setAffAgpCommentaire(agpm.getAgpCommentaire());
		 affichageAgpm.setTFonction(userController.getSlctd().getTFonction());
		 affichageAgpm.setAffAgpActeurSaisie(userController.getSlctd().getTFonction().getFonCod());
		 affichageAgpm.setTStructure(userController.getSlctd().getTFonction().getTStructure());
		 affichageAgpm.setTGestion( new TGestion(gesCode));
		 affichageAgpm.setTProjet(projet);
		 affichageAgpm.setTSourceFinancement(new TSourceFinancement(souCode));
		 iservice.updateObject(affichageAgpm);
		 
		 
	 }
	 		 
	 
	 public String fermer(String value ,String action) throws IOException {
		 userController.initMessage();
	     chargeData();
	     chargeDataAvalider();
		 vider();
		 boutonEdit= false;
		 rappelProjet();
		 decId = 0;
		 return userController.renderPage(value); 
	 }
	  
    
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamic(action);
		     switch(value) {
				case "pgpm1":
					chargeDataAvalider();
					chargeData();
					vider();
					btn_saveProjet =true;
					 paveInformations = false;
	  				 paveConfirmation = false;
					break;
				case "pgpm2":
					paveInformations = false;
					paveConfirmation = false;
					btn_saveProjet =true;
					projet.setProTypeProjet("PRO");
					boutonEdit=false;
					 etatPavetDossier= false; 
					 etatPavetInfoProjet= false; 
					 etatPavetOrgne= false;
					 etatBoutonModifDeclarant=false;
					 etatBoutonEnregDeclarant=true;
					 btn_saveProjet =true;
					controleController.fonctionaliteDynamic();
					userController.initMessage();
					rappelDeclarant();
					//rappelProjet();
					verifProjet();
					decId = 0;
				break;
				case "pgpm3":
				break;
				case "agpm2":
					paveInformations = false;
					paveConfirmation = false;
					btn_saveProjet =true;
					chargeDataAvalider();
					chargeData();
					vider();
					break;
				case "agpm3":
					editForm();
					/*sourfin = slctdTd.getTFinancement().getFinTypeFinance();
					baiCode= slctdTd.getTBailleur().getBaiCode();
					souCode = slctdTd.getTSourceFinancement().getSouCode();
					devCode = slctdTd.getTDevise().getDevCode();*/
					chargeDetailModif();
					break;
				case "pgpm4":
					chargeDetails();
					chargeDossierDetail();
					break;
			    }
		     
		    return userController.renderPage(value);
		}
	 
	//Methode de récupération de t_agpm dans t_affichage
	 public void editForm() {
	    			listUpdate= (List<VUpdateAgpm>) iservice.getObjectsByColumn("VUpdateAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
	    					 new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
	    			if (!listUpdate.isEmpty()) {
	    				updateAgpm=listUpdate.get(0); 
	    			}
	 }
	 
	 
	 //liste des details
	 public void chargeDetailModif() {
		 getListeDetail().clear();
		 listeDetail= (List<TDetailAgpm>) iservice.getObjectsByColumn("TDetailAgpm", new ArrayList<String>(Arrays.asList("TDA_ID")),
				 new WhereClause("TDA_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
	 }
	 //Debut love
	 
	 //Debut cpmp
	 
	 public void chargeFonction() {
		 listeFonctions.clear();
		 listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
					"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM")),
					new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,structure.getStrCode()));
	 }
		public void filtreFonctionMin() {
			getListeFonctions().clear();
			 listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
						"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM")),
						new WhereClause("FON_COD",WhereClause.Comparateur.LIKE,"%"+filtreFonction+"%"),
						new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,structure.getStrCode()));
		}
		
		public void filtreMinistere() {
			listeMinistere.clear();
			listeMinistere = (List<TMinistere>) iservice.getObjectsByColumn("TMinistere", new ArrayList<String>(Arrays.asList("minCode")),
					new WhereClause("MIN_CODE",WhereClause.Comparateur.LIKE,"%"+filtreMinistere+"%"));
		}
		
		public void filtreStructure() {
			listeStructure.clear();
			listeStructure = (List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("strCode")),
					new WhereClause("STR_CODE",WhereClause.Comparateur.LIKE,"%"+filtreStructure+"%"));
		}
		
		public void onSelectMinistereAgpm() {
			 // agpm = new TAgpm();
			  agpm.setTStructure(new TStructure(structure.getStrCode()));
			  
			  recupStructure = new TStructure();
			  recupStructure.setStrCode(structure.getStrCode());
			  recupStructure.setStrLibelleCourt(structure.getStrLibelleCourt());
			  recupStructure.setStrLibelleLong(structure.getStrLibelleLong());
			  recupStructure.setStrEmail(structure.getStrEmail());
			  
		
			  chargeFonction();
				}
		public void onSelectFonctionAgpm() {
			 agpm = new TAgpm();
			 agpm.setTFonction(new TFonction(fonction.getFonCod()));
			 
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
						new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,structure.getStrCode()));
		 }
			public void filtreFonctionMinDmp() {
				getListeFonctions().clear();
				 listeFonctions = (List<VFonctionMinistere>) iservice.getObjectsByColumnIn("VFonctionMinistere", new ArrayList<String>(Arrays.asList("fonCod")),
							"FON_TYF_COD", new ArrayList<String>(Arrays.asList("ACR","CPM","DMP")),
							new WhereClause("FON_COD",WhereClause.Comparateur.LIKE,"%"+filtreFonction+"%"),
							new WhereClause("FON_STR_CODE",WhereClause.Comparateur.EQ,structure.getStrCode()));
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
			
			
			
			
			public void onSelectFonctionAgpmDmp() {
				 agpm = new TAgpm();
				 agpm.setTFonction(new TFonction(fonction.getFonCod()));
				 
				 recupFonction = new TFonction();
				 recupFonction.setFonCod(fonction.getFonCod());
				 recupFonction.setFonLibelle(fonction.getFonLibelle());
					}
			
			public void onSelectMinistereAgpmDmp() {
				  agpm = new TAgpm();
				  //agpm.setTMinistere(new TMinistere(ministere.getMinCode()));
				  agpm.setTStructure(new TStructure(structure.getStrCode()));
				  
				  recupStructure = new TStructure();
				  recupStructure.setStrCode(structure.getStrCode());
				  recupStructure.setStrLibelleCourt(structure.getStrLibelleCourt());
				  recupStructure.setStrLibelleLong(structure.getStrLibelleLong());
				  recupStructure.setStrEmail(structure.getStrEmail());
				  
				 /*recupMinistere = new TMinistere();
				  recupMinistere.setMinCode(ministere.getMinCode());
				  recupMinistere.setMinLibelle(ministere.getMinLibelle());*/
				  chargeFonctionDmp();
					}
		//Fin dmp
		
		
	 //Fin love
		

		//Affichage des motifs de retour
		public void chargerObservation() {
			agpmstatutList=(List<VAgpmStatut>) iservice.getObjectsByColumn("VAgpmStatut", new ArrayList<String>(Arrays.asList("HAG_AGP_ID")),
					new WhereClause("HAG_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()),
					new WhereClause("HAG_STA_CODE",WhereClause.Comparateur.EQ,slctdTd.getTStatut().getStaCode()));
			if(!agpmstatutList.isEmpty()) {
				int i=agpmstatutList.size();
				int baoule=i-1;
				agpmstatut=agpmstatutList.get(baoule);
			}	
		}	
		
	
	 
	 
	 //Methodes vider
	 public void viderFinancement() {
		 newFinancement = new TFinancement();
		 baiCode ="";
		 souCode = "";
		 devCode = "";
	 }
	
		
	 
	 //Edition de l'AGPM
	 //Edition de l'AGPM
	 public void imprimerAgpm() {
		  
			   projetReport.longparam1(affichageAgpm.getAffAgpId(), "Agpm", "Agpm"); 
		}
	 
	 //Edition de l'AGPM
	 public void imprimerAgpmDetail() {
			   projetReport.longparam1(slctdTd.getAffAgpId(), "Agpm", "Agpm"); 
		}
	 
	 
	 
	public boolean isSkip() {
		return skip;
	}
	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public List<VAgpm> getObjetListe() {
		return objetListe;
	}

	public void setObjetListe(List<VAgpm> objetListe) {
		this.objetListe = objetListe;
	}

	public TAgpm getAgpm() {
		return agpm;
	}
	public void setAgpm(TAgpm agpm) {
		this.agpm = agpm;
	}

	public List<String> getAjoutParagraphe() {
		return ajoutParagraphe;
	}

	public void setAjoutParagraphe(List<String> ajoutParagraphe) {
		this.ajoutParagraphe = ajoutParagraphe;
	}
	public Boolean getBoutonAdd() {
		return boutonAdd;
	}
	public void setBoutonAdd(Boolean boutonAdd) {
		this.boutonAdd = boutonAdd;
	}
	public Boolean getBoutonSupp() {
		return boutonSupp;
	}
	public void setBoutonSupp(Boolean boutonSupp) {
		this.boutonSupp = boutonSupp;
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

	public TFinancement getNewFinancement() {
		return newFinancement;
	}

	public void setNewFinancement(TFinancement newFinancement) {
		this.newFinancement = newFinancement;
	}

	public List<TFinancement> getListeFinancement() {
		return listeFinancement;
	}
	public void setListeFinancement(List<TFinancement> listeFinancement) {
		this.listeFinancement = listeFinancement;
	}

	public TProjet getProjet() {
		return projet;
	}

	public void setProjet(TProjet projet) {
		this.projet = projet;
	}

	public List<TReglementation> getListeReglementation() {
		return listeReglementation;
	}

	public void setListeReglementation(List<TReglementation> listeReglementation) {
		this.listeReglementation = listeReglementation;
	}

	public List<TGestion> getListeGestion() {
		return listeGestion;
	}

	public void setListeGestion(List<TGestion> listeGestion) {
		this.listeGestion = listeGestion;
	}

	public List<TMinistere> getListeMinistere() {
		return listeMinistere;
	}

	public void setListeMinistere(List<TMinistere> listeMinistere) {
		this.listeMinistere = listeMinistere;
	}

	public TDeclarant getDeclarant() {
		return declarant;
	}

	public void setDeclarant(TDeclarant declarant) {
		this.declarant = declarant;
	}

	public long getRegle() {
		return regle;
	}

	public void setRegle(long regle) {
		this.regle = regle;
	}

	public long getGesCode() {
		return gesCode;
	}

	public void setGesCode(long gesCode) {
		this.gesCode = gesCode;
	}

	public long getMinCode() {
		return minCode;
	}

	public void setMinCode(long minCode) {
		this.minCode = minCode;
	}

	public String getFonc() {
		return fonc;
	}

	public void setFonc(String fonc) {
		this.fonc = fonc;
	}

	public boolean isEtatPavetDeclarant() {
		return etatPavetDeclarant;
	}

	public void setEtatPavetDeclarant(boolean etatPavetDeclarant) {
		this.etatPavetDeclarant = etatPavetDeclarant;
	}

	public boolean isEtatAutreInfo() {
		return etatAutreInfo;
	}

	public void setEtatAutreInfo(boolean etatAutreInfo) {
		this.etatAutreInfo = etatAutreInfo;
	}

	public boolean isEtatPavetDossier() {
		return etatPavetDossier;
	}

	public void setEtatPavetDossier(boolean etatPavetDossier) {
		this.etatPavetDossier = etatPavetDossier;
	}

	public List<TComposante> getComposanteListe() {
		return composanteListe;
	}

	public void setComposanteListe(List<TComposante> composanteListe) {
		this.composanteListe = composanteListe;
	}

	public List<TObjectifGen> getObjectifListe() {
		return objectifListe;
	}

	public void setObjectifListe(List<TObjectifGen> objectifListe) {
		this.objectifListe = objectifListe;
	}

	public List<TBesoin> getBesoinListe() {
		return besoinListe;
	}

	public void setBesoinListe(List<TBesoin> besoinListe) {
		this.besoinListe = besoinListe;
	}

	public TComposante getNewComposante() {
		return newComposante;
	}

	public void setNewComposante(TComposante newComposante) {
		this.newComposante = newComposante;
	}

	public TBesoin getNewBesoin() {
		return newBesoin;
	}

	public void setNewBesoin(TBesoin newBesoin) {
		this.newBesoin = newBesoin;
	}

	public TObjectifGen getNewObjectif() {
		return newObjectif;
	}

	public void setNewObjectif(TObjectifGen newObjectif) {
		this.newObjectif = newObjectif;
	}

	public String getNatPiece() {
		return natPiece;
	}

	public void setNatPiece(String natPiece) {
		this.natPiece = natPiece;
	}

	public List<TDossierAgpm> getDossListe() {
		return dossListe;
	}

	public void setDossListe(List<TDossierAgpm> dossListe) {
		this.dossListe = dossListe;
	}

	public TDossierAgpm getSelectedDossier() {
		return selectedDossier;
	}

	public void setSelectedDossier(TDossierAgpm selectedDossier) {
		this.selectedDossier = selectedDossier;
	}

	public TDetailAgpm getTmpDetailAgpm() {
		return tmpDetailAgpm;
	}

	public void setTmpDetailAgpm(TDetailAgpm tmpDetailAgpm) {
		this.tmpDetailAgpm = tmpDetailAgpm;
	}

	public List <TDetailAgpm> getDetailAgpm() {
		return detailAgpm;
	}

	public void setDetailAgpm(List <TDetailAgpm> detailAgpm) {
		this.detailAgpm = detailAgpm;
	}

	public List<TReglementation> getListeRegleCombox() {
		return listeRegleCombox;
	}

	public void setListeRegleCombox(List<TReglementation> listeRegleCombox) {
		this.listeRegleCombox = listeRegleCombox;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public List<VAgpmStatut> getAgpmstatutList() {
		return agpmstatutList;
	}

	public void setAgpmstatutList(List<VAgpmStatut> agpmstatutList) {
		this.agpmstatutList = agpmstatutList;
	}

	public VAgpmStatut getAgpmstatut() {
		return agpmstatut;
	}

	public void setAgpmstatut(VAgpmStatut agpmstatut) {
		this.agpmstatut = agpmstatut;
	}

	public VFonctionMinistere getFonction() {
		return fonction;
	}

	public void setFonction(VFonctionMinistere fonction) {
		this.fonction = fonction;
	}

	public TMinistere getMinistere() {
		return ministere;
	}

	public void setMinistere(TMinistere ministere) {
		this.ministere = ministere;
	}

	public String getFiltreFonction() {
		return filtreFonction;
	}

	public void setFiltreFonction(String filtreFonction) {
		this.filtreFonction = filtreFonction;
	}

	public List<VFonctionMinistere> getListeFonctions() {
		return listeFonctions;
	}

	public void setListeFonctions(List<VFonctionMinistere> listeFonctions) {
		this.listeFonctions = listeFonctions;
	}

	public String getFonCod() {
		return fonCod;
	}

	public void setFonCod(String fonCod) {
		this.fonCod = fonCod;
	}

	public String getFiltreMinistere() {
		return filtreMinistere;
	}

	public void setFiltreMinistere(String filtreMinistere) {
		this.filtreMinistere = filtreMinistere;
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



	public VAgpm getAddAgpm() {
		return addAgpm;
	}

	public void setAddAgpm(VAgpm addAgpm) {
		this.addAgpm = addAgpm;
	}

	public TAgpm getDemAgpm() {
		return demAgpm;
	}

	public void setDemAgpm(TAgpm demAgpm) {
		this.demAgpm = demAgpm;
	}

	public TAffichageAgpm getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(TAffichageAgpm slctdTd) {
		this.slctdTd = slctdTd;
	}

	public String getFiltreOrgane() {
		return filtreOrgane;
	}



	public void setFiltreOrgane(String filtreOrgane) {
		this.filtreOrgane = filtreOrgane;
	}



	public String getFiltreAutorite() {
		return filtreAutorite;
	}



	public void setFiltreAutorite(String filtreAutorite) {
		this.filtreAutorite = filtreAutorite;
	}



	public String getFiltreProjet() {
		return filtreProjet;
	}



	public void setFiltreProjet(String filtreProjet) {
		this.filtreProjet = filtreProjet;
	}



	public String getFiltreExercice() {
		return filtreExercice;
	}



	public void setFiltreExercice(String filtreExercice) {
		this.filtreExercice = filtreExercice;
	}




	public String getProTypeProjet() {
		return proTypeProjet;
	}




	public void setProTypeProjet(String proTypeProjet) {
		this.proTypeProjet = proTypeProjet;
	}




	public TFinancement getSelectFinance() {
		return selectFinance;
	}




	public void setSelectFinance(TFinancement selectFinance) {
		this.selectFinance = selectFinance;
	}




	public List<TDeclarant> getListeDeclarants() {
		return listeDeclarants;
	}




	public void setListeDeclarants(List<TDeclarant> listeDeclarants) {
		this.listeDeclarants = listeDeclarants;
	}




	public TDeclarant getDec() {
		return dec;
	}




	public void setDec(TDeclarant dec) {
		this.dec = dec;
	}




	public long getDecId() {
		return decId;
	}




	public void setDecId(long decId) {
		this.decId = decId;
	}




	public VProjetAgpm getActe() {
		return acte;
	}




	public void setActe(VProjetAgpm acte) {
		this.acte = acte;
	}




	public boolean isEtatPanelOrganeRappel() {
		return etatPanelOrganeRappel;
	}


	public void setEtatPanelOrganeRappel(boolean etatPanelOrganeRappel) {
		this.etatPanelOrganeRappel = etatPanelOrganeRappel;
	}


	public boolean isEtatPanelOrgane() {
		return etatPanelOrgane;
	}

	public void setEtatPanelOrgane(boolean etatPanelOrgane) {
		this.etatPanelOrgane = etatPanelOrgane;
	}




	public boolean isEtatPavetInfoProjet() {
		return etatPavetInfoProjet;
	}




	public void setEtatPavetInfoProjet(boolean etatPavetInfoProjet) {
		this.etatPavetInfoProjet = etatPavetInfoProjet;
	}




	public boolean isEtatPavetOrgne() {
		return etatPavetOrgne;
	}




	public void setEtatPavetOrgne(boolean etatPavetOrgne) {
		this.etatPavetOrgne = etatPavetOrgne;
	}




	public boolean isEtatBoutonModifDeclarant() {
		return etatBoutonModifDeclarant;
	}




	public void setEtatBoutonModifDeclarant(boolean etatBoutonModifDeclarant) {
		this.etatBoutonModifDeclarant = etatBoutonModifDeclarant;
	}




	public boolean isEtatBoutonEnregDeclarant() {
		return etatBoutonEnregDeclarant;
	}




	public void setEtatBoutonEnregDeclarant(boolean etatBoutonEnregDeclarant) {
		this.etatBoutonEnregDeclarant = etatBoutonEnregDeclarant;
	}




	public TBesoin getSelectBesoin() {
		return selectBesoin;
	}




	public void setSelectBesoin(TBesoin selectBesoin) {
		this.selectBesoin = selectBesoin;
	}




	public TComposante getSelectComposante() {
		return selectComposante;
	}




	public void setSelectComposante(TComposante selectComposante) {
		this.selectComposante = selectComposante;
	}




	public TObjectifGen getSelectBojectif() {
		return selectBojectif;
	}




	public void setSelectBojectif(TObjectifGen selectBojectif) {
		this.selectBojectif = selectBojectif;
	}




	public boolean isEtatPanelConfirmation() {
		return etatPanelConfirmation;
	}




	public void setEtatPanelConfirmation(boolean etatPanelConfirmation) {
		this.etatPanelConfirmation = etatPanelConfirmation;
	}

	public List<VAgpmDeclarant> getListeDeclarantsRappel() {
		return listeDeclarantsRappel;
	}

	public void setListeDeclarantsRappel(List<VAgpmDeclarant> listeDeclarantsRappel) {
		this.listeDeclarantsRappel = listeDeclarantsRappel;
	}

	public boolean isEtatPanelConfirmationRappel() {
		return etatPanelConfirmationRappel;
	}

	public void setEtatPanelConfirmationRappel(boolean etatPanelConfirmationRappel) {
		this.etatPanelConfirmationRappel = etatPanelConfirmationRappel;
	}

	public VAgpmDeclarant getRappelDec() {
		return rappelDec;
	}

	public void setRappelDec(VAgpmDeclarant rappelDec) {
		this.rappelDec = rappelDec;
	}

	public long getProId() {
		return proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	public List<TProjet> getListeProjet() {
		return listeProjet;
	}

	public void setListeProjet(List<TProjet> listeProjet) {
		this.listeProjet = listeProjet;
	}

	public List<VProjetAgpm> getActeListe() {
		return acteListe;
	}

	public void setActeListe(List<VProjetAgpm> acteListe) {
		this.acteListe = acteListe;
	}

	public boolean isEtatPanelProjetRappel() {
		return etatPanelProjetRappel;
	}

	public void setEtatPanelProjetRappel(boolean etatPanelProjetRappel) {
		this.etatPanelProjetRappel = etatPanelProjetRappel;
	}

	public boolean isEtatPanelInfoProjetRappel() {
		return etatPanelInfoProjetRappel;
	}

	public void setEtatPanelInfoProjetRappel(boolean etatPanelInfoProjetRappel) {
		this.etatPanelInfoProjetRappel = etatPanelInfoProjetRappel;
	}

	public boolean isEtatPanelProjet() {
		return etatPanelProjet;
	}

	public void setEtatPanelProjet(boolean etatPanelProjet) {
		this.etatPanelProjet = etatPanelProjet;
	}

	public boolean isEtatPanelInfoProjet() {
		return etatPanelInfoProjet;
	}

	public void setEtatPanelInfoProjet(boolean etatPanelInfoProjet) {
		this.etatPanelInfoProjet = etatPanelInfoProjet;
	}

	public boolean isEtatPanelDossiers() {
		return etatPanelDossiers;
	}

	public void setEtatPanelDossiers(boolean etatPanelDossiers) {
		this.etatPanelDossiers = etatPanelDossiers;
	}

	public boolean isEtatPanelDossiersRappel() {
		return etatPanelDossiersRappel;
	}

	public void setEtatPanelDossiersRappel(boolean etatPanelDossiersRappel) {
		this.etatPanelDossiersRappel = etatPanelDossiersRappel;
	}

	public boolean isEtatBoutonModifProjet() {
		return etatBoutonModifProjet;
	}

	public void setEtatBoutonModifProjet(boolean etatBoutonModifProjet) {
		this.etatBoutonModifProjet = etatBoutonModifProjet;
	}

	public boolean isEtatBoutonEnregProjet() {
		return etatBoutonEnregProjet;
	}

	public void setEtatBoutonEnregProjet(boolean etatBoutonEnregProjet) {
		this.etatBoutonEnregProjet = etatBoutonEnregProjet;
	}

	public boolean isEtatPanelConfirmationProjet() {
		return etatPanelConfirmationProjet;
	}

	public void setEtatPanelConfirmationProjet(boolean etatPanelConfirmationProjet) {
		this.etatPanelConfirmationProjet = etatPanelConfirmationProjet;
	}

	public boolean isEtatPanelConfirmationProjetRappel() {
		return etatPanelConfirmationProjetRappel;
	}

	public void setEtatPanelConfirmationProjetRappel(boolean etatPanelConfirmationProjetRappel) {
		this.etatPanelConfirmationProjetRappel = etatPanelConfirmationProjetRappel;
	}

	public boolean isEtatBoutonEnregRappelProjet() {
		return etatBoutonEnregRappelProjet;
	}

	public void setEtatBoutonEnregRappelProjet(boolean etatBoutonEnregRappelProjet) {
		this.etatBoutonEnregRappelProjet = etatBoutonEnregRappelProjet;
	}

	public Boolean getBoutonEdit() {
		return boutonEdit;
	}

	public void setBoutonEdit(Boolean boutonEdit) {
		this.boutonEdit = boutonEdit;
	}

	public List<VFonctionMinistere> getListeFonctionsDmp() {
		return listeFonctionsDmp;
	}

	public void setListeFonctionsDmp(List<VFonctionMinistere> listeFonctionsDmp) {
		this.listeFonctionsDmp = listeFonctionsDmp;
	}

	public boolean isComboRappelDec() {
		return comboRappelDec;
	}

	public void setComboRappelDec(boolean comboRappelDec) {
		this.comboRappelDec = comboRappelDec;
	}

	public List<TContenuAgpm> getListeContenu() {
		return listeContenu;
	}

	public void setListeContenu(List<TContenuAgpm> listeContenu) {
		this.listeContenu = listeContenu;
	}

	public String getTcaCode() {
		return tcaCode;
	}

	public void setTcaCode(String tcaCode) {
		this.tcaCode = tcaCode;
	}

	public TDetailAgpm getDetail() {
		return detail;
	}

	public void setDetail(TDetailAgpm detail) {
		this.detail = detail;
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

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public List<TAffichageAgpm> getValidationListe() {
		return validationListe;
	}

	public void setValidationListe(List<TAffichageAgpm> validationListe) {
		this.validationListe = validationListe;
	}

	public List<TDetailAgpm> getListeDetail() {
		return listeDetail;
	}

	public void setListeDetail(List<TDetailAgpm> listeDetail) {
		this.listeDetail = listeDetail;
	}

	public List<TAgpm> getListeAgpm() {
		return listeAgpm;
	}

	public void setListeAgpm(List<TAgpm> listeAgpm) {
		this.listeAgpm = listeAgpm;
	}

	public List<TAffichageAgpm> getAffichageListe() {
		return affichageListe;
	}

	public void setAffichageListe(List<TAffichageAgpm> affichageListe) {
		this.affichageListe = affichageListe;
	}

	public TAffichageAgpm getAffichageAgpm() {
		return affichageAgpm;
	}

	public void setAffichageAgpm(TAffichageAgpm affichageAgpm) {
		this.affichageAgpm = affichageAgpm;
	}

	public String getColonne() {
		return colonne;
	}

	public void setColonne(String colonne) {
		this.colonne = colonne;
	}

	public String getDateToday() {
		return dateToday;
	}

	public void setDateToday(String dateToday) {
		this.dateToday = dateToday;
	}

	public List<VAgpmDetails> getDetailsList() {
		return detailsList;
	}

	public void setDetailsList(List<VAgpmDetails> detailsList) {
		this.detailsList = detailsList;
	}


	public boolean isEtatReferenceProjet() {
		return etatReferenceProjet;
	}


	public void setEtatReferenceProjet(boolean etatReferenceProjet) {
		this.etatReferenceProjet = etatReferenceProjet;
	}


	public boolean isEtatReferenceDeclarant() {
		return etatReferenceDeclarant;
	}


	public void setEtatReferenceDeclarant(boolean etatReferenceDeclarant) {
		this.etatReferenceDeclarant = etatReferenceDeclarant;
	}

	public boolean isBoutonEditRappel() {
		return boutonEditRappel;
	}

	public void setBoutonEditRappel(boolean boutonEditRappel) {
		this.boutonEditRappel = boutonEditRappel;
	}

	public List<TAffichageAgpm> getAgpmTrans() {
		return agpmTrans;
	}

	public void setAgpmTrans(List<TAffichageAgpm> agpmTrans) {
		this.agpmTrans = agpmTrans;
	}

	public List<TAffichageAgpm> getAgpmValCp() {
		return agpmValCp;
	}

	public void setAgpmValCp(List<TAffichageAgpm> agpmValCp) {
		this.agpmValCp = agpmValCp;
	}

	public List<TAffichageAgpm> getAgpmValDmp() {
		return agpmValDmp;
	}

	public void setAgpmValDmp(List<TAffichageAgpm> agpmValDmp) {
		this.agpmValDmp = agpmValDmp;
	}

	public List<TAffichageAgpm> getAgpmDifCp() {
		return agpmDifCp;
	}

	public void setAgpmDifCp(List<TAffichageAgpm> agpmDifCp) {
		this.agpmDifCp = agpmDifCp;
	}

	public List<TAffichageAgpm> getAgpmDifDmp() {
		return agpmDifDmp;
	}

	public void setAgpmDifDmp(List<TAffichageAgpm> agpmDifDmp) {
		this.agpmDifDmp = agpmDifDmp;
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

	public String getMultiFiltre() {
		return multiFiltre;
	}

	public void setMultiFiltre(String multiFiltre) {
		this.multiFiltre = multiFiltre;
	}

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	public String getStatutTrans() {
		return statutTrans;
	}

	public void setStatutTrans(String statutTrans) {
		this.statutTrans = statutTrans;
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

	public List<TProjet> getProjetUpdate() {
		return projetUpdate;
	}

	public void setProjetUpdate(List<TProjet> projetUpdate) {
		this.projetUpdate = projetUpdate;
	}

	public List<THistoAgpm> getListeHisto() {
		return listeHisto;
	}

	public void setListeHisto(List<THistoAgpm> listeHisto) {
		this.listeHisto = listeHisto;
	}

	public THistoAgpm getHistoAgpm() {
		return histoAgpm;
	}

	public void setHistoAgpm(THistoAgpm histoAgpm) {
		this.histoAgpm = histoAgpm;
	}

	public TDetailAgpm getSltdetail() {
		return sltdetail;
	}

	public void setSltdetail(TDetailAgpm sltdetail) {
		this.sltdetail = sltdetail;
	}

	public List<VUpdateAgpm> getListUpdate() {
		return listUpdate;
	}

	public void setListUpdate(List<VUpdateAgpm> listUpdate) {
		this.listUpdate = listUpdate;
	}

	public VUpdateAgpm getUpdateAgpm() {
		return updateAgpm;
	}

	public void setUpdateAgpm(VUpdateAgpm updateAgpm) {
		this.updateAgpm = updateAgpm;
	}

	public boolean isPaveInformations() {
		return paveInformations;
	}

	public void setPaveInformations(boolean paveInformations) {
		this.paveInformations = paveInformations;
	}

	public boolean isBtn_saveProjet() {
		return btn_saveProjet;
	}

	public void setBtn_saveProjet(boolean btn_saveProjet) {
		this.btn_saveProjet = btn_saveProjet;
	}

	public boolean isPaveConfirmation() {
		return paveConfirmation;
	}

	public void setPaveConfirmation(boolean paveConfirmation) {
		this.paveConfirmation = paveConfirmation;
	}
	
    
}
