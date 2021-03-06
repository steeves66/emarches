package com.sndi.controller.agpm;

import java.io.File;
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
import com.sndi.model.TAgpm;
import com.sndi.model.TBailleur;
import com.sndi.model.TBesoin;
import com.sndi.model.TComposante;
import com.sndi.model.TContenuAgpm;
import com.sndi.model.TDacSpecs;
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
import com.sndi.model.VAgpmliste;
import com.sndi.model.VDacliste;
import com.sndi.model.VDetTabBordAgpm;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VProjetAgpm;
import com.sndi.model.VUpdateAgpm;
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
	 
	 @Autowired
	 ConstantService constantService;

	 
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
		//verifProjet();
		chargeData();
		//chargeDataAvalider();
		//chargeBailleur();
		//chargeDevise();
		//chargeSourceFinance();
		chargeMinisteres();
		chargeGestions();
		chargeDetail();
		DataToday();
		chargeAgpmTrans();
		chargeAgpmValCp();
		chargeAgpmValDmp();
		chargeAgpmDifCp();
		chargeAgpmDifDmp();
		//tableauBordController.ChargeTbAgpm();
		
	 }
	 
	 //Declaration des listes
	 /*private List<TAgpm> objetListe = new ArrayList<TAgpm>();*/
	 private List<VAgpmliste> agpmListe = new ArrayList<VAgpmliste>();
	 private List<TAffichageAgpm> affichageListe = new ArrayList<TAffichageAgpm>();
	 private List<VUpdateAgpm> listUpdate = new ArrayList<VUpdateAgpm>();
	 private List<VAgpm> objetListe = new ArrayList<VAgpm>();
	 private List<VDetTabBordAgpm> detailTB = new ArrayList<VDetTabBordAgpm>();
	 
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
	 //private List<TAffichageAgpm> validationListe = new ArrayList<TAffichageAgpm>();
	 private List<VAgpmliste> validationListe = new ArrayList<VAgpmliste>();
	 private List<TDetailAgpm> listeDetail = new ArrayList<TDetailAgpm>();
	 private List<VAgpmDetails> detailsList = new ArrayList<VAgpmDetails>();
	 private List<VAgpmliste> agpmTrans = new ArrayList<VAgpmliste>();
	 private List<VAgpmliste> agpmValCp = new ArrayList<VAgpmliste>();
     private List<VAgpmliste> agpmValDmp = new ArrayList<VAgpmliste>();
     private List<VAgpmliste> agpmDifCp = new ArrayList<VAgpmliste>();
     private List<VAgpmliste> agpmDifDmp = new ArrayList<VAgpmliste>();
     
     private String documentlog;
	  
	
	 //Declaration des objets
	 private TAgpm agpm = new TAgpm();
	 //private TAffichageAgpm affichageAgpm = new TAffichageAgpm();
	 private VAgpmliste vAgpm = new VAgpmliste();
	 private VAgpmliste varAgpm = new VAgpmliste();
	 private TAgpm demAgpm = new TAgpm();
	 private THistoAgpm histoAgpm = new THistoAgpm();
	 private TDetailAgpm detail = new TDetailAgpm();
	 private TDetailAgpm sltdetail = new TDetailAgpm();
	 private VAgpm addAgpm = new VAgpm(); 
	 private VUpdateAgpm updateAgpm = new VUpdateAgpm(); 
	 private VAgpmDeclarant rappelDec = new VAgpmDeclarant();
	 private VProjetAgpm acte = new VProjetAgpm(); 
	 //private VAgpmliste slctdTdv= new VAgpmliste();
	 private VAgpmliste slctdTd = new VAgpmliste();
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
	  
/*	  //afficher le bloc reference projet en fonction
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
	  
	 */
	  
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
		 /*public void chargeData(){
			 agpmListe.clear();
			 agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_ID")),
					"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SDR")),
					new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				 
				     tableauBordController.chargeDataAgpm(); 
					_logger.info("agpmListe size: "+agpmListe.size());	
			}*/
	  
	  
	  public void chargeDetailCpt() {
		  String fonct = controleController.getFonctionalite();
		  
		  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			  chargeDetailAC2("AGPM","S1T","SDT");
			  chargeDetailAC1("AGPM","S2D");
		  }else {
			   if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				     chargeDetailCP1("AGPM","S2V");
					 chargeDetailCP1("AGPM","S2D");
					 chargeDetailDMP1("AGPM","S3D");
			   }else
				    if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
				    	chargeDetailDMP1("AGPM","S3V");
				    	chargeDetailDMP2("AGPM","S3D","SDR");
				    }
	      }
	  }
	  
	  
		//Methode de suppression de l'operation
	     public void deleteAgpm() {
	    	 List<TAgpm> AGP  = iservice.getObjectsByColumn("TAgpm", new WhereClause("AGP_ID",Comparateur.EQ,""+slctdTd.getAgpId()));
	    	 TAgpm agpm = new TAgpm();
				if(!AGP.isEmpty()) agpm = AGP.get(0);
				agpm.setTStatut(new TStatut("SDS"));
		        iservice.updateObject(agpm);
		         historiser("SDS",agpm, "Dossier supprim? par l'autaurite contractante");
		        chargeData();
		    	userController.setTexteMsg("Supression effectu?e avec succ?s !");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success"); 
	     }
	
		//D?but Nouvelle Methode d'Affichage des AGPM 
		 public void chargeData() {
			 agpmListe.clear();
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_DTE_MODIF")),
							"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SDR")),
							//new WhereClause("AGP_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
							new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
							new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						     tableauBordController.ChargeTbAgpm(); 
						    chargeDetailCpt();
						     multiFiltre="";
							_logger.info("agpmListe size: "+agpmListe.size());
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 getValidationListe().clear();
					 agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_DTE_MODIF")),
								"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
								new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
								new WhereClause("AGP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
					         // new WhereClause("AGP_FON_COD_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					 tableauBordController.ChargeTbAgpm();
					 chargeDetailCpt();
					 multiFiltre="";
						_logger.info("agpmListe size: "+agpmListe.size()); 
					 
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 getValidationListe().clear();
						 agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_DTE_MODIF")),
									"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
									new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
							     //new WhereClause("AGP_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						 tableauBordController.ChargeTbAgpm();
						 chargeDetailCpt();
							multiFiltre="";
								_logger.info("agpmListe size: "+agpmListe.size());
					 }else {
						 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							 getValidationListe().clear();
							 agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_DTE_MODIF")),
										"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
										new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
								//new WhereClause("FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
							 tableauBordController.ChargeTbAgpm();
							 chargeDetailCpt();
								multiFiltre="";
									_logger.info("objetListe size: "+agpmListe.size());
						 }
					 }
			     } 
			   }
			 }
		 // Fin Nouvelle methode d'Affichage des AGPM 
		 
		 
		 
		 
		//Liste des Agpm transmis par l'acteur connect?
		 public void chargeAgpmTrans() {
			 agpmTrans.clear();
			 agpmTrans = ((List<VAgpmliste>)iservice.getObjectsByColumnIn("VAgpmliste",new ArrayList<String>(Arrays.asList("AGP_ID")),
					    "AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","SDT")),
					    new WhereClause("AGP_ACTIF",Comparateur.EQ,"1"),
						 new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
		 }
		 
		//Liste des Agpm valid?s par la CPMP : Nouvelle Methode
		 public void chargeAgpmValCp() {
			 agpmValCp.clear();
			 agpmValCp = ((List<VAgpmliste>)iservice.getObjectsByColumn("VAgpmliste",new ArrayList<String>(Arrays.asList("AGP_ID")),
					    new WhereClause("AGP_STA_CODE",Comparateur.EQ,"S2V"),
					    new WhereClause("AGP_ACTIF",Comparateur.EQ,"1"),
					    new WhereClause("AGP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));
					    //new WhereClause("AGP_FON_COD_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
		 }

		//Liste des Pgpm valid?s par la DMP : Nouvelle Methode
		 public void chargeAgpmValDmp() {
			 agpmValDmp.clear();
			 agpmValDmp = ((List<VAgpmliste>)iservice.getObjectsByColumn("VAgpmliste",new ArrayList<String>(Arrays.asList("AGP_ID")),
					    new WhereClause("AGP_STA_CODE",Comparateur.EQ,"S3V"),
					    //new WhereClause("AGP_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),	 		 
					    new WhereClause("AGP_ACTIF",Comparateur.EQ,"1")));
		 }
		 
		 //Liste des Agpm diff?r?s par la CPMP : Nouvelle Methode
		 public void chargeAgpmDifCp() {
			 agpmDifCp.clear();
			 agpmDifCp = ((List<VAgpmliste>)iservice.getObjectsByColumn("VAgpmliste",new ArrayList<String>(Arrays.asList("AGP_ID")),
					    new WhereClause("AGP_STA_CODE",Comparateur.EQ,"S2D"),
					    new WhereClause("AGP_ACTIF",Comparateur.EQ,"1"),
					    new WhereClause("AGP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode())));
					   // new WhereClause("AGP_FON_COD_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())));		 		 
		 }
		 
		//Liste des Agpm diff?r?s par la DMP : Nouvelle Methode
		 public void chargeAgpmDifDmp() {
			 agpmDifDmp.clear();
			 agpmDifDmp = ((List<VAgpmliste>)iservice.getObjectsByColumnIn("VAgpmliste",new ArrayList<String>(Arrays.asList("AGP_ID")),
					   "AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S3D","SDR")),
					   //new WhereClause("AGP_FON_COD_DMP",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),		 		 
					    new WhereClause("AGP_ACTIF",Comparateur.EQ,"1")));		 		 
		      }
		 
		 
		 
		//Liste des Agpm retourn?s chez l'AC
		 public void chargeAgpmDifAc() {
			 agpmDifDmp.clear();
			 agpmDifDmp = ((List<VAgpmliste>)iservice.getObjectsByColumnIn("VAgpmliste",new ArrayList<String>(Arrays.asList("AGP_ID")),
					   "AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2D","SDR")),
					    new WhereClause("AGP_ACTIF",Comparateur.EQ,"1")));		 		 
		      }
		 
		 
		 
		 
		 //liste des details
		 public void chargeDetail() {
			 getListeDetail().clear();
			 listeDetail= (List<TDetailAgpm>) iservice.getObjectsByColumn("TDetailAgpm", new ArrayList<String>(Arrays.asList("TDA_ID")),
					 new WhereClause("TDA_AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
		 }
		 
		 //liste des details du projet rappel?
		 public void chargeDetailRappel() {
			 getListeDetail().clear();
			 listeDetail= (List<TDetailAgpm>) iservice.getObjectsByColumnDesc("TDetailAgpm", new ArrayList<String>(Arrays.asList("TDA_ID")),
					 new WhereClause("TDA_AGP_ID",WhereClause.Comparateur.EQ,""+acte.getAgpId()));
		 }

	 public void chargeContenu(){
		 listeContenu=new ArrayList<>(constantService.getListeContenu());
	 }
	
		//Combobox regl?mentations 
		 public void chargeMinisteres(){
			 listeMinistere=new ArrayList<>(constantService.getListeMinistere());	
		 }
		//ACombobox Gestions
		 public void chargeGestions(){
			 listeGestion=new ArrayList<>(constantService.getListeGestion());
		 }
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

			//Combobox du rappel du d?clarant
	           public void rappelDeclarant() { 
	        	   listeDeclarantsRappel = ((List<VAgpmDeclarant>) iservice.getObjectsByColumn("VAgpmDeclarant", new ArrayList<String>(Arrays.asList("AGP_ID")),
	        			   new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+acte.getAgpId()))); 
	             }
			
	         //Configuration de la page en fonction du d?clarant choisi
	           //Methode de rappel du D?clarant
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
	           
	         
	           
	     
	           
	           
	           //Methode de rappel du D?clarant
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
		       			userController.setTexteMsg("Suppression ?ffectue? avec succ?s !");
		       			userController.setSevrityMsg("success");
	       			  }else {
	       				iservice.deleteObject(getDetail());
		       			chargeDetail();
		       			userController.setRenderMsg(true);
		       			userController.setTexteMsg("Suppression ?ffectue? avec succ?s !");
		       			userController.setSevrityMsg("success");
	       			        }
	       			
	       		} catch (org.hibernate.exception.ConstraintViolationException e) {
	       			userController.setTexteMsg("Impossible de supprimer la Fonction !");
	       			userController.setRenderMsg(true);
	       			userController.setSevrityMsg("danger");
	       		}  
	        	   
	           }
	           //Mis ? jour du num?ro d'ordre
	           public void updateDetail() {
	        	    detail.setTdaNumOrdre(detail.getTdaNumOrdre());
	       			iservice.updateObject(getDetail());
	       			chargeDetail();
	           }
	         
	  /*       //Combobox des projets ? r?cup?rer
	      	 public void rappelProjet() { 
	      	     acteListe = (List<VProjetAgpm>) iservice.getObjectsByColumnIn("VProjetAgpm", new ArrayList<String>(Arrays.asList("PRO_ID")),
					"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D")),
					new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					new WhereClause("AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	      	         }*/


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

	      	  
	      	  
	      	//Filtre multicrit?re
		public void chargerFiltreRecherche() { 
			agpmListe.clear();
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_DTE_MODIF")),
						"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SDR")),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"),
						new WhereClause("AGP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
						_logger.info("agpmListe size: "+agpmListe.size());
					 }else 
					      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
					    	  agpmListe.clear();
					    	  agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_DTE_MODIF")),
									"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
									new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
									new WhereClause("AGP_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
					    			new WhereClause("AGP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
							        //tableauBordController.chargeDataAgpm();
								   _logger.info("agpmListe size: "+agpmListe.size());
								   
					      }else 
					    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					    		  agpmListe.clear();
					    		  agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_DTE_MODIF")),
										"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V")),
										new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
								new WhereClause("AGP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
								//tableauBordController.chargeDataAgpm(); 
									_logger.info("agpmListe size: "+agpmListe.size());
									
					      }else 
					    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
					    		  agpmListe.clear();
					    		  agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_DTE_MODIF")),
											"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V")),
											new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
									new WhereClause("AGP_RECHERCHE",WhereClause.Comparateur.LIKE,"%"+multiFiltre+"%"));
										_logger.info("agpmListe size: "+agpmListe.size());
										
						      }
			          }

	   
		
		 //Debut Charge detail Compteur de l'AC
		 public void chargeDetailAC1(String typeDac, String stat1){
			 detailTB =(List<VDetTabBordAgpm>) iservice.getObjectsByColumnIn("VDetTabBordAgpm", new ArrayList<String>(Arrays.asList("AGPM_DETID")),
					      "AGP_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre AGPM: "+detailTB.size());	
		}
		 
		 //Debut Charge detail Compteur de l'AC
		 public void chargeDetailAC2(String typeDac, String stat1, String stat2){
			 detailTB =(List<VDetTabBordAgpm>) iservice.getObjectsByColumnIn("VDetTabBordAgpm", new ArrayList<String>(Arrays.asList("AGPM_DETID")),
					      "AGP_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("CODE_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("Nbre AGPM: "+detailTB.size());	
		}
		 
		 
		 //Debut Charge detail Compteur de la CPMP
		 public void chargeDetailCP1(String typeDac, String stat1){
			 getDetailTB().clear();
			 detailTB =(List<VDetTabBordAgpm>) iservice.getObjectsByColumnIn("VDetTabBordAgpm", new ArrayList<String>(Arrays.asList("AGPM_DETID")),
					      "AGP_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("AGP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("Nbre AGPM: "+detailTB.size());	
		}
		 
		 //Debut Charge detail Compteur de la CPMP
		 public void chargeDetailCP2(String typeDac, String stat1, String stat2){
			 getDetailTB().clear();
			 detailTB =(List<VDetTabBordAgpm>) iservice.getObjectsByColumnIn("VDetTabBordAgpm", new ArrayList<String>(Arrays.asList("AGPM_DETID")),
					      "AGP_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac),
			              new WhereClause("AGP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("Nbre AGPM: "+detailTB.size());	
		}
		 
		 
		 
		 //Debut Charge detail Compteur de la DMP1
		 public void chargeDetailDMP1(String typeDac, String stat1){
			 detailTB =(List<VDetTabBordAgpm>) iservice.getObjectsByColumnIn("VDetTabBordAgpm", new ArrayList<String>(Arrays.asList("AGPM_DETID")),
					      "AGP_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1)),
					      new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac));
			             // new WhereClause("AGP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("Nbre AGPM: "+detailTB.size());	
		}
		 
		 //Debut Charge detail Compteur de la DMP
		 public void chargeDetailDMP2(String typeDac, String stat1, String stat2){
			 detailTB =(List<VDetTabBordAgpm>) iservice.getObjectsByColumnIn("VDetTabBordAgpm", new ArrayList<String>(Arrays.asList("AGPM_DETID")),
					      "AGP_STA_CODE", new ArrayList<String>(Arrays.asList(""+stat1,""+stat2)),
					      new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
					      new WhereClause("TYP",WhereClause.Comparateur.EQ,""+typeDac));
			             // new WhereClause("AGP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				_logger.info("Nbre AGPM: "+detailTB.size());	
		}
		
	  	//Filtre multicrit?re
			/*public void reinitialiserAgpm() {  	
				if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {						
						 }else 
						      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
						    	  agpmListe.clear();
						    	  agpmListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_ID")),
												"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S1T","S3D")),
												new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
									 multiFiltre="";
										_logger.info("agpmListe size: "+agpmListe.size()); 
						    	  
						      }else 
						    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						    		  validationListe.clear();
										validationListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_ID")),
												"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
												new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
										      multiFiltre="";
											_logger.info("objetListe size: "+validationListe.size());
						          }else 
							    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
							    		  validationListe.clear();
											validationListe = (List<VAgpmliste>) iservice.getObjectsByColumnInDesc("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_ID")),
													"AGP_STA_CODE", new ArrayList<String>(Arrays.asList("S2V","SDT")),
													new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1")); 
											      multiFiltre="";
												_logger.info("objetListe size: "+validationListe.size());
							          }
			
				
				             }*/
	      	 
	      	 
	  //M?thode de cr?ation du projet
	  public void creerProjet() throws IOException{
	      		          
	    	  if(projet.getProTitre().equalsIgnoreCase("") || "".equals(projet.getProTitre()) || agpm.getAgpCommentaire().equalsIgnoreCase("") || "".equals(agpm.getAgpCommentaire()) || projet.getProTypeProjet().equalsIgnoreCase("") || projet.getProTypeProjet() == null || devCode == null  || sourfin == null
	    			 || souCode == null ) {
	                      //Message d'erreur
	    		          FacesContext.getCurrentInstance().addMessage(null,
	    	      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir tous les champs", ""));	 
	                           
	    	                }else {
	    	                	
	    	                	listeAgpm=(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),	 
  						                              new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
                                              if(!listeAgpm.isEmpty()) { 
	    	 				            	 agpm=listeAgpm.get(0);
	    	 				            	 iservice.updateObject(projet);
                                             iservice.updateObject(agpm);
	  	   	    	 				                   
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
		   	    	 				                                    userController.setTexteMsg("Agpm mis ? jour avec succ?s!");
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
	    	 				     	      				    agpm.setAgpFonCodPf(userController.getSlctd().getTFonction().getFonCodePf());
	    	 				     	      				    agpm.setAgpFonCodDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
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
	    	 				     		      				
	    	 				     		      				
	    	 				     		      			   TStatut statuts = constantService.getStatut("S1S");
	    	 				     		  					//Historisation des Agpm
	    	 				     		      			    historiser("S1S",agpm,"Cr?ation de l'agpm par l'Autorit? Contractante");
	    	 				     		      			  //Pr?paration du Tableau de Bord
	    	 				     		  	      		   tableauBordController.saveTempTabord("S1S", ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), "PN", ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+agpm.getAgpId());	
	    	 				     		  				   
	    	 				     		      			    
	    	 				     		      			    agpmListe =(List<VAgpmliste>) iservice.getObjectsByColumn("VAgpmliste", new ArrayList<String>(Arrays.asList("AGP_ID")),
	    	 				     		  						new WhereClause("AGP_ID", WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
	    	 				     		  					if (!agpmListe.isEmpty())  
	    	 				     		  						varAgpm =agpmListe.get(0); 
	    	 				     		  					   String search = varAgpm.getAgpCode()+""+varAgpm.getBaiLibelle()+""+varAgpm.getFinNumeroAccord()+""+varAgpm.getProTitre();
	    	 				     		  					   String rechercheAll = search.replace("null","");
	    	 				     		  					   
	    	 				     		  					  agpm.setAgpRecherche(rechercheAll);
	    	 				     		  					  iservice.updateObject(agpm); 
	    	 				     		  				
	    	 				     		  					userController.setTexteMsg("Enregistrement effectu? avec succ?s!");
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
	      		          }
	  
	  
	  public void historiser(String statut,TAgpm TAgpm,String motif) {
		        THistoAgpm agpmStatut = new THistoAgpm();
				agpmStatut.setHagDate(Calendar.getInstance().getTime());
				agpmStatut.setHagMotif(motif);
				agpmStatut.setTFonction(userController.getSlctd().getTFonction());
				agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
				agpmStatut.setTStatut(new TStatut(statut));
				agpmStatut.setTAgpm(TAgpm);
				iservice.addObject(agpmStatut); 
	  }
	  
	  
	  public void Checklog() {
			setDocumentlog("Fichier direct log ");
			double kilobytes =0;
			/*File file = new File("/opt/wildfly/standalone/log/server.log");*/
			File file = new File("standalone/log/server.log");
			
			if(file.exists()){
				
				double bytes = file.length();
				kilobytes = (bytes / 1024);
				setDocumentlog(getDocumentlog() + ""+ kilobytes+"kb");
				
			}else{
				System.out.println("File does not exists!");
				setDocumentlog(getDocumentlog() + "File does not exists!");
			}
			
		}
	  
	  public void openLog() throws IOException{
			//downloadFileServlet.downloadFile("/opt/wildfly/standalone/log/server.log", "server.log");
			downloadFileServlet.downloadFile("standalone/log/server.log", "server.log");

		   }
	  
	  //Les methodes de l'ecran de methodeModification 
 	 public void modifier() {
 		 //slctdTd.setTBailleur(new TBailleur(baiCode));
 		 //slctdTd.setTDevise(new TDevise(devCode));
 		 
 		 //Projet
 		 List<TProjet> PRO =iservice.getObjectsByColumn("TProjet", new ArrayList<String>(Arrays.asList("PRO_ID")),
	      				new WhereClause("PRO_ID",WhereClause.Comparateur.EQ,""+slctdTd.getProId()));
 		TProjet projet = new TProjet();
   				if(!PRO.isEmpty()) projet =PRO.get(0); 	
   				projet.setProTypeProjet(updateAgpm.getProTypeProjet());
   				projet.setProTitre(updateAgpm.getProTitre());
   				iservice.updateObject(projet);
   			
   			 //Agpm
        /*List<TAgpm> AGP =iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
   		      				new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
   	 		TAgpm agpm = new TAgpm();
   	   				if(!AGP.isEmpty()) agpm =AGP.get(0); 	
   	   			  agpm.setAgpCommentaire(updateAgpm.getAffAgpCommentaire());
   	   				iservice.updateObject(agpm);*/
   	   				
   	   			 //Declarant
   	   	 		 List<TDeclarant> DEC =iservice.getObjectsByColumn("TDeclarant", new ArrayList<String>(Arrays.asList("DEC_ID")),
   	   		      				new WhereClause("DEC_ID",WhereClause.Comparateur.EQ,""+slctdTd.getDecId()));
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
   	   	   		      				new WhereClause("FIN_ID",WhereClause.Comparateur.EQ,""+slctdTd.getFinId()));
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
   	   			/* slctdTd.setAffAgpCommentaire(updateAgpm.getAffAgpCommentaire());
   	   		     slctdTd.setTProjet(projet);
   	   		     slctdTd.setTFinancement(financement);
   	   		     slctdTd.setTBailleur(new TBailleur(updateAgpm.getBaiCode()));
   	   		     slctdTd.setTDeclarant(declarant);
   	   		     slctdTd.setTDevise(new TDevise(updateAgpm.getFinDevCode()));
   	   		     slctdTd.setTSourceFinancement( new TSourceFinancement(updateAgpm.getAffSouCode()));
   	   	   		 iservice.updateObject(slctdTd);*/
   	   				
 		 chargeData();
			 userController.setTexteMsg("Modification ?ffectu?e avec succ?s!");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
 	 }
 	 
 	 
 	 
 	 public void updatedetail() {  
 		 sltdetail.setTContenuAgpm(new TContenuAgpm(tcaCode));
			    	iservice.updateObject(sltdetail);
			    	chargeDetailModif();
				    userController.setTexteMsg("Mise a jour ?ffectu?e avec succ?s!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");
	      	 }
 	 
 	 public void updatedetailSaisie() {  
 		 sltdetail.setTContenuAgpm(new TContenuAgpm(tcaCode));
			    	iservice.updateObject(sltdetail);
			    	chargeDetail();
				    userController.setTexteMsg("Mise a jour ?ffectu?e avec succ?s!");
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
				     userController.setTexteMsg("Enregistrement effectu? avec succ?s!");
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
					    userController.setTexteMsg("D?tail ajout? avec succ?s!");
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
					    userController.setTexteMsg("D?tail ajout? avec succ?s!");
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
  	                     //rappelProjet();
  	                     rappelDeclarant();	
      						  userController.setTexteMsg("Projet ou Programme mis ? jour avec succ?s !");
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
	      				 //rappelProjet();

      			      }
	      		 
      			List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,"S1S"));
					TStatut statuts = new TStatut();
					if(!LS.isEmpty()) statuts = LS.get(0);
					  //Historisation des Agpm
					     THistoAgpm agpmStatut = new THistoAgpm();
					      agpmStatut.setHagDate(Calendar.getInstance().getTime());
					      agpmStatut.setHagMotif("Demande mis ? jour par l'Autorit? Contractante");
					      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
					      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
					      agpmStatut.setTStatut(statuts);
					      agpmStatut.setTAgpm(agpm);
						  iservice.addObject(agpmStatut);
						  
						  //Insertion dans TAffichageAgpm
			/*			affichageAgpm.setAffAgpActeurSaisie(agpm.getAgpActeurSaisie());
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
						iservice.addObject(affichageAgpm);*/
						 userController.setTexteMsg("Enregistrement effectu? avec succ?s!");
						 userController.setRenderMsg(true);
						 userController.setSevrityMsg("success");
						 etatPavetDeclarant= true;
						 etatAutreInfo= false;
						 etatPavetDossier= true; 
						 etatPavetInfoProjet= true; 
						 etatPavetOrgne= true;
     		 }
	 
	      	
	      	
	      	
	      //Cr?er le d?clarant en ajoutant sa cl? dans t_Agpm
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
						
							boutonEdit=true;
							boutonAdd = false;
							etatPavetDossier = true;
				         } 
				 boutonEdit=true;
				 boutonAdd = false;
				 userController.setTexteMsg("Adresse ajout?e avec succ?s !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("success");
				 etatPavetDeclarant= true;
				 etatAutreInfo= false;
				 etatPavetDossier= true; 
				 etatPavetInfoProjet= false; 
				 etatPavetOrgne= true;
				 
					 
				 }else {
					     if(declarant.getDecPersFonction().equalsIgnoreCase("") || declarant.getDecPersNomPrenom().equalsIgnoreCase("")
					    	 || declarant.getDecBp().equalsIgnoreCase("") ) {
					    	 
					    	 FacesContext.getCurrentInstance().addMessage(null,
				    	      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir les champs obligatoires de l'organe d'ex?cution", ""));
					     }else {
					    	     iservice.addObject(declarant);
							    
						       listeAgpm=(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),	 
								 new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
						      if(!listeAgpm.isEmpty()) {
							    TAgpm rect = new TAgpm();
									rect=listeAgpm.get(0);
									rect.setTDeclarant(new TDeclarant(declarant.getDecId()));
									iservice.updateObject(rect);
						/*			affichageAgpm.setTDeclarant(rect.getTDeclarant());
									iservice.updateObject(affichageAgpm);*/
									boutonEdit=true;
									boutonAdd = false;
						         } 
						   
						   
						/*   List<TAffichageAgpm> AFG =iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_AGP_ID")),
		     						new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+agpm.getAgpId()));
		 					TAffichageAgpm affgp = new TAffichageAgpm();
		 					if(!AFG.isEmpty()) affgp =AFG.get(0); 
		 					affgp.setTDeclarant(affichageAgpm.getTDeclarant());
							//affgp.setAffAgpRecherche(rechercheAll);
		 					iservice.updateObject(affgp);*/
						   
						  boutonEdit=true;
						  boutonAdd = false;
						  userController.setTexteMsg("Adresse ajout?e avec succ?s !");
						  userController.setRenderMsg(true);
						  userController.setSevrityMsg("success");
						 etatPavetDeclarant= true;
						 etatAutreInfo= false;
						 etatPavetDossier= true; 
						 etatPavetInfoProjet= false; 
						 etatPavetOrgne= true; 
					    	 
					           }
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
				      agpmStatut.setHagMotif("Demande Transmise ? la CPMP");
				      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
				      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
				      agpmStatut.setTStatut(statuts);
				      agpmStatut.setTAgpm(agpm);
					  iservice.addObject(agpmStatut);
					  chargeData();
					  
					  userController.setTexteMsg("Enregistrement effectu? avec succ?s !");
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
				      agpmStatut.setHagMotif("Demande Transmise ? la CPMP");
				      agpmStatut.setTFonction(userController.getSlctd().getTFonction());
				      agpmStatut.setTOperateur(userController.getSlctd().getTOperateur());
				      agpmStatut.setTStatut(statuts);
				      agpmStatut.setTAgpm(agpm);
					  iservice.addObject(agpmStatut);
					  chargeData();
					  userController.setTexteMsg("Enregistrement effectu? avec succ?s !");
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
		      "SOU_CODE", new ArrayList<String>(Arrays.asList("EMP","DON","DEP")));
		    
		    newFinancement = new TFinancement();
			}
		
		//Tri sur les types de financement 
		public void chargeSourceEtat() { 
		    listeSourceFinance.clear();
			listeSourceFinance=(List<TSourceFinancement>) iservice.getObjectsIn("TSourceFinancement", new ArrayList<String>(Arrays.asList("SOU_CODE")),
			      "SOU_CODE", new ArrayList<String>(Arrays.asList("TRE")));
			
			newFinancement = new TFinancement();
				}
		
		 //Methode checkBailleur
		 public void checkBailleur() {
			 //sourfin="";
			 if(sourfin.equalsIgnoreCase("Bailleur")) { 
				 selectBailleur = true;
				 selectTresor = false;
				 selectPartBai = true;
				 chargeSourceCheck();
				 //newFinancement = new TFinancement();
				 //sourfin="";
			 }else {
				  if(sourfin.equalsIgnoreCase("Cofinance")){
						 selectBailleur = true; 
						 selectTresor = true;
						 selectPartBai = true;
						 chargeSourceFinance();
						 newFinancement = new TFinancement();
					 }else 
						 if(sourfin.equalsIgnoreCase("Etat")){
						 selectBailleur = false;
						 selectTresor = true;
						 selectPartBai= false;
						 souCode="TRE";
						 chargeSourceEtat();
						 //newFinancement = new TFinancement();
					    }
			     }   
		 }
		 
		 
		//M?thode de checkDocument
		 public TDossierAgpm checkDocument(String agpCode, String natPiece) {
		                  TDossierAgpm val ;
		           List<TDossierAgpm> listDoc = ((List<TDossierAgpm>)iservice.getObjectsByColumn("TDossierAgpm",new ArrayList<String>(Arrays.asList("DAG_NAP_CODE")),
		                new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+agpCode),
		               new WhereClause("DAG_NAP_CODE",Comparateur.EQ,""+natPiece)));
		           
		                return (listDoc.isEmpty() || listDoc==null)?null:listDoc.get(0);
		            }
		 
		 
		//M?thode de v?rification de l'AGPM Bailleur
		 public VAgpmBailleur checkAgpm(String agpId, String baiCode) {
			           VAgpmBailleur val ;
		           List<VAgpmBailleur> listAgpm = ((List<VAgpmBailleur>)iservice.getObjectsByColumn("VAgpmBailleur",new ArrayList<String>(Arrays.asList("AGP_ID")),
		                new WhereClause("AGP_ID",Comparateur.EQ,""+agpId),
		                new WhereClause("BAI_CODE",Comparateur.EQ,""+baiCode)));
		           
		                return (listAgpm.isEmpty() || listAgpm==null)?null:listAgpm.get(0);
		            }
		 
		 
		 //@Transactional
		 public void valider() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 statutUpdate ="";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 statutUpdate ="S2V";
					 commentaire="AGPM valid? par le CPMP";
				 }else 
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						 statutUpdate ="S3V";
						 commentaire="AGPM valid? par la DMP";
				   }else {
					   if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 statutUpdate ="S3V";
						 commentaire="AGPM valid? par la DMP";
					 }
			     } 
			 }
					
			 listeAgpm =(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAgpId()));
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
								 }else
									 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {	
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
					  
					/*//Enregistrement de TAffichage
					  validationListe =(List<TAffichageAgpm>) iservice.getObjectsByColumn("TAffichageAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
	 							new WhereClause("AFF_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAffAgpId()));
	 					TAffichageAgpm affiche = new TAffichageAgpm();
	 					if (!validationListe.isEmpty()) {
	 						affiche= validationListe.get(0);
	 						if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
	 							affiche.setAffAgpDateValAc(Calendar.getInstance().getTime());
							 }else
								 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
									 affiche.setAffAgpDateValCpmp(Calendar.getInstance().getTime());
								 }else
									 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {	
										 affiche.setAffAgpDateValDmp(Calendar.getInstance().getTime());
									 }else
										 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {	
											 affiche.setAffAgpDateValDmp(Calendar.getInstance().getTime());
										 }
	 						affiche.setTStatut(new TStatut(statutUpdate));
	 						affiche.setAffAgpStatutRetour("0");
						iservice.updateObject(affiche);
					 	
				}*/
	 					
	 					 chargeData();
						  //chargeDataAvalider();
						  chargeAgpmValCp();
						  chargeAgpmValDmp();
						  userController.setTexteMsg(" Validation effectu?e avec succ?s !");
						  userController.setRenderMsg(true);
						  userController.setSevrityMsg("success");
				}
		 }
		 
		 //Differer
		 //@Transactional
		 public void differer() {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 statutUpdate ="";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					 statutUpdate ="S2D";
				 }else {
					 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
						 if(slctdTd.getStrTstCode().equalsIgnoreCase("02")){
							 statutUpdate ="S3D"; 
						 }else
							  if(slctdTd.getStrTstCode().equalsIgnoreCase("03")) {
								  statutUpdate ="SDR";  
							  }else {
								  statutUpdate ="S3D"; 
							  }
					   }else
						    if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						    	if(slctdTd.getStrTstCode().equalsIgnoreCase("02")) {
									 statutUpdate ="S3D"; 
								 }else
									  if(slctdTd.getStrTstCode().equalsIgnoreCase("03")) {
										  statutUpdate ="SDR";  
									  }else {
										  statutUpdate ="S3D"; 
									  }
				               }
			             } 
			        }
			   listeAgpm =(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
						new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAgpId()));
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
							  
			 					
			 					  chargeData();
								  //chargeDataAvalider();
								  chargeAgpmDifCp(); 
								  chargeAgpmDifDmp();
								  tableauBordController.ChargeTbAgpm();
								  userController.setTexteMsg(" D?sol?, votre Agpm a ?t? rejet?!");
								  userController.setRenderMsg(true);
								  userController.setSevrityMsg("success");
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
						new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAgpId()));
			   if (!listeAgpm.isEmpty()) {
				   TAgpm agp = new TAgpm();
				     agp= listeAgpm.get(0);
				     agp.setTStatut(new TStatut(statutUpdate));
					 agp.setAgpStatutRetour("1");
					 iservice.updateObject(agp);
			   
		
					 listeHisto =(List<THistoAgpm>) iservice.getObjectsByColumn("THistoAgpm", new ArrayList<String>(Arrays.asList("HAG_ID")),
								new WhereClause("HAG_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAgpId()),
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
				
			 					  chargeData();
								  //chargeDataAvalider();
								  chargeAgpmDifCp(); 
								  chargeAgpmDifDmp();
								  tableauBordController.ChargeTbAgpm();
								  userController.setTexteMsg("D?sol?, votre Agpm a ?t? retourner!");
								  userController.setRenderMsg(true);
								  userController.setSevrityMsg("success");	
	        }
		 }
		 
		
		 
			//Methode Transmettre
	//@Transactional 
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
						   
						   List<TAgpm> agp  = iservice.getObjectsByColumn("TAgpm", 
									 new WhereClause("AGP_ID",Comparateur.EQ,""+slctdTd.getAgpId()));
						      TAgpm agpp = new TAgpm();
						      if(!agp.isEmpty()) agpp = agp.get(0);
						      agpp.setTStatut(new TStatut(statutTrans));
		 					  agpp.setAgpDateValAc(Calendar.getInstance().getTime());
		 					  agpp.setAgpStatutRetour("0");
							  iservice.updateObject(agpp);

							  TStatut statuts = constantService.getStatut(statutTrans);
								  //Historisation des Agpm
							  historiser(""+statutTrans,agpp,"Demande Transmise ? la CPMP");
							//Pr?paration du Tableau de Bord
     		  	      		   tableauBordController.saveTempTabord(""+statutTrans, ""+controleController.type, ""+userController.getSlctd().getTFonction().getFonCod(), "PN", ""+userController.getSlctd().getTOperateur().getOpeMatricule(), ""+agpp.getAgpId());	
     		  				   
									  chargeData();  
									 // rappelProjet();
									  chargeAgpmTrans();
									 tableauBordController.ChargeTbAgpm();
									  userController.setTexteMsg(" Transmission effectu?e avec succ?s !");
									  userController.setRenderMsg(true);
									  userController.setSevrityMsg("success");
					 						  
	 				  	}
	 						
				 
				 					 
		 
				//Methode Upload
			 @Transactional
			 public void upload(FileUploadEvent event) throws IOException{
				 
				  if(acte.getProId()>0) {
					  
					  if(fileUploadController.handleFileUpload(event, acte.getAgpId()+"", natPiece)) {
							
							TDossierAgpm dos = checkDocument(""+acte.getAgpId(), natPiece);
							if(dos == null) {
								//check le dossier s'il existe ? faire
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
								 userController.setTexteMsg("Document enregistr?!");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("success");
							}else {
								   //Mis ? jour du document
								   dos.setDagReference("");
								   dos.setDagLibelle(fileUploadController.getFileName());
								   dos.setDagCommentaire(fileUploadController.getDocNom());
								   iservice.updateObject(dos); 
								   //Chargement de la liste des documents
								   chargeDossierRappel();
								   rechercheProjet();
								   //Message de mis ? jour
								   userController.setTexteMsg("Document mis ? jour!");
								   userController.setRenderMsg(true);
								   userController.setSevrityMsg("success");
							      }
						     }else {
						    	//Message d'erreur
								 userController.setTexteMsg("Document non enregistr?, charger ? nouveau un document!");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("danger");
									}
					  
				    }else {
					  
					        if(fileUploadController.handleFileUpload(event, agpm.getAgpId()+"", natPiece)) {
							
							   TDossierAgpm dos = checkDocument(""+agpm.getAgpId(), natPiece);
							    if(dos == null) {
								//check le dossier s'il existe ? faire
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
								userController.setTexteMsg("Document enregistr?!");
								userController.setRenderMsg(true);
								userController.setSevrityMsg("success");
							     }else {
								   //Mis ? jour du document
								   dos.setDagReference("");
								   dos.setDagLibelle(fileUploadController.getFileName());
								   dos.setDagCommentaire(fileUploadController.getDocNom());
								   iservice.updateObject(dos); 
								   //Chargement de la liste des documents
								   chargeDossier();
								   rechercheProjet();
								   //Message de mis ? jour
								   userController.setTexteMsg("Document mis ? jour!");
								   userController.setRenderMsg(true);
								   userController.setSevrityMsg("success");
							    }
						     }else {
						    	//Message d'erreur
								 userController.setTexteMsg("Document non enregistr?, charger ? nouveau un document!");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("danger");
									}
				  }
			 	    	
	     }
	    
	     
		 
		 
		 //Detail Debut
		 public void chargeDetails() {
			 detailsList.clear();
			 detailsList = ((List<VAgpmDetails>)iservice.getObjectsByColumnDesc("VAgpmDetails",new ArrayList<String>(Arrays.asList("DAG_ID")),
						 new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+agpm.getAgpId())));
		    }
		 
		 
		  //Fin Detail Debut
            public void chargeDossier() {
			 dossListe.clear();
				 dossListe = ((List<TDossierAgpm>)iservice.getObjectsByColumnDesc("TDossierAgpm",new ArrayList<String>(Arrays.asList("DAG_ID")),
						 new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+agpm.getAgpId())));
		    }
            
            
          //Fin Detail Debut
            public void chargeDossierDetail() {
			 dossListe.clear();
				 dossListe = ((List<TDossierAgpm>)iservice.getObjectsByColumnDesc("TDossierAgpm",new ArrayList<String>(Arrays.asList("DAG_ID")),
						 new WhereClause("DAG_AGP_ID",Comparateur.EQ,""+slctdTd.getAgpId())));
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
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDagCommentaire()+" supprim?!", "");
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
		 
		 //Suppression dynamique des pi?ces justificatives
		 public void removePieces(TDetailAgpm detail) {
			 detailAgpm.remove(detail);
			 iservice.deleteObject(detail);
	        }
		 
		
		// Fin Implementatio
		 
		
	 private boolean skip;
	 
	 public String onFlowProcess(FlowEvent event) {
		 System.out.println("etape old= "+event.getOldStep()+" New= "+event.getNewStep());
		//Controle Pav? cr?ation
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
		 /*affichageAgpm.setAffAgpActeurSaisie(agpm.getAgpActeurSaisie());
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
		 iservice.updateObject(affichageAgpm);*/ 
	 }
	 		 
	 
	 public String fermer(String value ,String action) throws IOException {
		 userController.initMessage();
	     chargeData();
	     //chargeDataAvalider();
		 vider();
		 boutonEdit= false;
		 //rappelProjet();
		 decId = 0;
		 return userController.renderPage(value); 
	 }
	  
    
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamic(action);
		     switch(value) {
				case "pgpm1":
					//chargeDataAvalider();
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
					//verifProjet();
					decId = 0;
				break;
				case "pgpm3":
				break;
				case "agpm2":
					paveInformations = false;
					paveConfirmation = false;
					btn_saveProjet =true;
					//chargeDataAvalider();
					chargeData();
					chargeBailleur();
					chargeContenu();
					chargeSourceFinance();
					chargeDevise();
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
	 
	 //renderPage avec un seul parametre
	 public String renderPage(String value) throws IOException{ 
		     switch(value) {
		     case "index":
					tableauBordController.ChargeTbAgpm();
					break;
		     }
		     return userController.renderPage(value);
		     }
	 
	//Methode de r?cup?ration de t_agpm dans t_affichage
	 public void editForm() {
	    			listUpdate= (List<VUpdateAgpm>) iservice.getObjectsByColumn("VUpdateAgpm", new ArrayList<String>(Arrays.asList("AFF_ID")),
	    					 new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAgpId()));
	    			if (!listUpdate.isEmpty()) {
	    				updateAgpm=listUpdate.get(0); 
	    			}
	 }
	 
	 
	 //liste des details
	 public void chargeDetailModif() {
		 getListeDetail().clear();
		 listeDetail= (List<TDetailAgpm>) iservice.getObjectsByColumn("TDetailAgpm", new ArrayList<String>(Arrays.asList("TDA_ID")),
				 new WhereClause("TDA_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAgpId()));
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
					new WhereClause("HAG_AGP_ID",WhereClause.Comparateur.EQ,""+slctdTd.getAgpId()),
					new WhereClause("HAG_STA_CODE",WhereClause.Comparateur.EQ,slctdTd.getAgpStaCode()));
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
			   projetReport.longparam1(agpm.getAgpId(), "Agpm", "Agpm"); 
		}
	 
	 //Edition de l'AGPM
	 public void imprimerAgpmDetail() {
			   projetReport.longparam1(slctdTd.getAgpId(), "Agpm", "Agpm"); 
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


/*	public List<TAffichageAgpm> getValidationListe() {
		return validationListe;
	}

	public void setValidationListe(List<TAffichageAgpm> validationListe) {
		this.validationListe = validationListe;
	}*/
	
	

	public List<TDetailAgpm> getListeDetail() {
		return listeDetail;
	}

	public List<VAgpmliste> getValidationListe() {
		return validationListe;
	}

	public void setValidationListe(List<VAgpmliste> validationListe) {
		this.validationListe = validationListe;
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
	
	

/*	public TAffichageAgpm getAffichageAgpm() {
		return affichageAgpm;
	}



	public void setAffichageAgpm(TAffichageAgpm affichageAgpm) {
		this.affichageAgpm = affichageAgpm;
	}*/

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

	

	public List<VAgpmliste> getAgpmTrans() {
		return agpmTrans;
	}

	public void setAgpmTrans(List<VAgpmliste> agpmTrans) {
		this.agpmTrans = agpmTrans;
	}

	public List<VAgpmliste> getAgpmValCp() {
		return agpmValCp;
	}

	public void setAgpmValCp(List<VAgpmliste> agpmValCp) {
		this.agpmValCp = agpmValCp;
	}

	public List<VAgpmliste> getAgpmValDmp() {
		return agpmValDmp;
	}

	public void setAgpmValDmp(List<VAgpmliste> agpmValDmp) {
		this.agpmValDmp = agpmValDmp;
	}

	public List<VAgpmliste> getAgpmDifCp() {
		return agpmDifCp;
	}

	public void setAgpmDifCp(List<VAgpmliste> agpmDifCp) {
		this.agpmDifCp = agpmDifCp;
	}

	public List<VAgpmliste> getAgpmDifDmp() {
		return agpmDifDmp;
	}

	public void setAgpmDifDmp(List<VAgpmliste> agpmDifDmp) {
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

	public List<VAgpmliste> getAgpmListe() {
		return agpmListe;
	}

	public void setAgpmListe(List<VAgpmliste> agpmListe) {
		this.agpmListe = agpmListe;
	}

	public VAgpmliste getvAgpm() {
		return vAgpm;
	}

	public void setvAgpm(VAgpmliste vAgpm) {
		this.vAgpm = vAgpm;
	}

	public VAgpmliste getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(VAgpmliste slctdTd) {
		this.slctdTd = slctdTd;
	}

	public VAgpmliste getVarAgpm() {
		return varAgpm;
	}

	public void setVarAgpm(VAgpmliste varAgpm) {
		this.varAgpm = varAgpm;
	}

	public String getDocumentlog() {
		return documentlog;
	}

	public void setDocumentlog(String documentlog) {
		this.documentlog = documentlog;
	}

	public List<VDetTabBordAgpm> getDetailTB() {
		return detailTB;
	}

	public void setDetailTB(List<VDetTabBordAgpm> detailTB) {
		this.detailTB = detailTB;
	}
    
}
