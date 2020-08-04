package com.sndi.controller.commission;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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

import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TBanques;
import com.sndi.model.TCandidats;
import com.sndi.model.TCommissionSpecifique;
import com.sndi.model.TCommissionType;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDemande;
import com.sndi.model.TDetCommissionSeance;
import com.sndi.model.TDetOffres;
import com.sndi.model.TDetailPlanGeneral;
import com.sndi.model.TDetailVente;
import com.sndi.model.TDossierMbr;
import com.sndi.model.TDossierPlanGeneral;
import com.sndi.model.TFinancementPgpm;
import com.sndi.model.TFonction;
import com.sndi.model.TLotAao;
import com.sndi.model.TNatureDocuments;
import com.sndi.model.TNaturePiece;
import com.sndi.model.TOperateur;
import com.sndi.model.TPiecesOffres;
import com.sndi.model.TPlanPassation;
import com.sndi.model.TSeances;
import com.sndi.model.TSoumissions;
import com.sndi.model.TStatut;
import com.sndi.model.TTypeCommission;
import com.sndi.model.TTypeMarche;
import com.sndi.model.TTypePieceOffre;
import com.sndi.model.TTypeSeance;
import com.sndi.model.TVenteDac;
import com.sndi.model.VAvisAppelOffre;
import com.sndi.model.VCandidatDac;
import com.sndi.model.VCommissionTypeExp;
import com.sndi.model.VCompoCommission;
import com.sndi.model.VCritereAnalyseDac;
import com.sndi.model.VCritereAnalyseDacOff;
import com.sndi.model.VDacMembre;
import com.sndi.model.VDetCommissionSeance;
import com.sndi.model.VDetOffreRecevable;
import com.sndi.model.VDetailOffres;
import com.sndi.model.VDofTyp;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VListePieceOffre;
import com.sndi.model.VListeSouOffBasse;
import com.sndi.model.VListeSouOffEleve;
import com.sndi.model.VLot;
import com.sndi.model.VLotCandidat;
import com.sndi.model.VOffreCandidat;
import com.sndi.model.VPiecesOffre;
import com.sndi.model.VPiecesOffreAnalyse;
import com.sndi.model.VRecapSeuilAnormal;
import com.sndi.model.VRepSoumissionnaire;
import com.sndi.model.VResultEvalClassLot;
import com.sndi.model.VResultPropAttribLot;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.model.VVerifOffin;
import com.sndi.model.VbAnalyseOffre;
import com.sndi.model.VbCommissionSpecifique;
import com.sndi.model.VbDetCritAnalyseDac;
import com.sndi.model.VbDetOffresSaisi;
import com.sndi.model.VbTempParamDetOffres;
import com.sndi.model.VbTempParametreCom;
import com.sndi.model.VVerifcorOffin;
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
public class CommissionController {
	Logger _logger = Logger.getLogger(CommissionController.class);
	
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
		//chargeCandidats();
		//chargeLotByAvis();	
		//chargeOffres();
		//chargeOffre();
		chargeBanque();
	 }
	 
	 //Declaration des listes 
	 private List<VCompoCommission> membresCommission = new ArrayList<VCompoCommission>();
	 private List<VDacMembre> listeMembre = new ArrayList<VDacMembre>(); 
	 private List<VDacMembre> selectionMembres = new ArrayList<VDacMembre>(); 
	 private List<VCommissionTypeExp> listeExpert = new ArrayList<VCommissionTypeExp>(); 
	 private List<VCommissionTypeExp> selectionlisteExpert = new ArrayList<VCommissionTypeExp>(); 
	 /*private List<TDetCommissionSeance> membresCommite = new ArrayList<TDetCommissionSeance>(); */
	 private List<VDetCommissionSeance> membresCommite = new ArrayList<VDetCommissionSeance>(); 
	 private List<TDetCommissionSeance> listMbrSup = new ArrayList<TDetCommissionSeance>();
	 private List<VDetCommissionSeance> listeCommite = new ArrayList<VDetCommissionSeance>(); 
	 private List<VDetCommissionSeance> selectionMembresCommite = new ArrayList<VDetCommissionSeance>(); 
	 private List<TTypeCommission> listeTypeCommission = new ArrayList<TTypeCommission>();
	 private List<TDetCommissionSeance> listeDetCom = new ArrayList<TDetCommissionSeance>();
	 private List<TAvisAppelOffre> listeAppelOffre = new ArrayList<TAvisAppelOffre>();
	 //private List<VAvisAppelOffre> listeAppelOffre = new ArrayList<VAvisAppelOffre>();
	 private List<TLotAao> listeLots = new ArrayList<TLotAao>();
	 private List<VLotCandidat> lotByCandidat = new ArrayList<VLotCandidat>();
	 private List<TLotAao> listeLotsByAvis = new ArrayList<TLotAao>();
	 private List<TAvisAppelOffre> listeAvis = new ArrayList<TAvisAppelOffre>();
	 private List<TDossierMbr> dossListe = new ArrayList<TDossierMbr>();
	 private List<VDofTyp> listdoftyp = new ArrayList<VDofTyp>();
	 //private List<VLot> listeLotsByAvis = new ArrayList<VLot>();
	 //private List<VCandidatDac> listCandidats = new ArrayList<VCandidatDac>();
	 private List<VOffreCandidat> listCandidats = new ArrayList<VOffreCandidat>();
	 private List<VRepSoumissionnaire> recupSoumissionnaire = new ArrayList<VRepSoumissionnaire>();
	 //private List<TDetOffres> listeOffres = new ArrayList<TDetOffres>(); 
	 private List<VDetOffreRecevable> listeOffres = new ArrayList<VDetOffreRecevable>(); 
	 private List<VPiecesOffre> listePiecesOffres = new ArrayList<VPiecesOffre>(); 
	 private List<VPiecesOffreAnalyse> listePiecesOffresAnalyse = new ArrayList<VPiecesOffreAnalyse>();
	 private List<VPiecesOffreAnalyse> listeSelectionPiecesOffresAnalyse= new ArrayList<VPiecesOffreAnalyse>();
	 private List<VDetailOffres> listeOffre = new ArrayList<VDetailOffres>();
	 private List<TDetailVente> listeVentes = new ArrayList<TDetailVente>();
	 private List<VPiecesOffre> listeSelectionPiecesOffres= new ArrayList<VPiecesOffre>();
	 private List<VbTempParamDetOffres> listeOffreByLot = new ArrayList<VbTempParamDetOffres>();
	 private List<TDetOffres> listeAttibutaire = new ArrayList<TDetOffres>(); 
	 private List<TDetOffres> offreListe = new ArrayList<TDetOffres>();
	 private List<TDetOffres> listeAffichageAttibutaire = new ArrayList<TDetOffres>(); 
	 private List<TSeances> listeSeance = new ArrayList<TSeances>(); 
	 private List<VCritereAnalyseDacOff> listeCritereAnalyse = new ArrayList<VCritereAnalyseDacOff>(); 
	 private List<VCritereAnalyseDacOff> selectionCritereAnalyse = new ArrayList<VCritereAnalyseDacOff>();
	 private List<TBanques> listBanque = new ArrayList<TBanques>();
	//private VCandidatDac candidat =new VCandidatDac();
	private VOffreCandidat candidat =new VOffreCandidat();
	private VLotCandidat tlot =new VLotCandidat();
	private VLotCandidat selectLot =new VLotCandidat();
	private VCritereAnalyseDacOff sltCritere =new VCritereAnalyseDacOff();
	private TAvisAppelOffre sltAvis =new TAvisAppelOffre();
	private TDetCommissionSeance detCom = new TDetCommissionSeance();
	 private TDossierMbr selectedDossier = new TDossierMbr();
	
	//Resutat analyse
	 private List<VVerifcorOffin> listeVerifCor = new ArrayList<VVerifcorOffin>();
	 private List<VListeSouOffBasse> listeSouOffBass = new ArrayList<VListeSouOffBasse>();
	 private List<VListeSouOffEleve> listeSouOffEleve  = new ArrayList<VListeSouOffEleve>();
	 private List<VResultEvalClassLot> resultatAttributaire = new ArrayList<VResultEvalClassLot>();
	 private List<VResultPropAttribLot> resultatPropAttributaire = new ArrayList<VResultPropAttribLot>();
	 private List<VRecapSeuilAnormal> listeRecapSeuil = new ArrayList<VRecapSeuilAnormal>();
	 private VRecapSeuilAnormal infoSeuil =new VRecapSeuilAnormal();
	 private VVerifcorOffin infoLot =new VVerifcorOffin();
	 private TLotAao recupLot =new TLotAao();
	 private VRepSoumissionnaire recupNcc =new VRepSoumissionnaire();
	
 
	 
	 //Declaration des objets
	 private TCommissionSpecifique newcomSpec = new TCommissionSpecifique();
	 private VDetCommissionSeance newMembre = new VDetCommissionSeance(); 
	 private TDetCommissionSeance mbrSup = new TDetCommissionSeance();
	 private VbCommissionSpecifique newcomSpecif = new VbCommissionSpecifique();
	 private TCommissionType newCom = new TCommissionType();
	 private TAvisAppelOffre slctdTd = new TAvisAppelOffre();
	 private VbTempParametreCom membre = new VbTempParametreCom();
	 //private TCandidats candidat = new TCandidats(); 
	 private VbTempParamDetOffres newOffre = new VbTempParamDetOffres();
	 
	
	 //private TDetOffres detailOffre = new TDetOffres();
	 private VDetOffreRecevable detailOffre = new VDetOffreRecevable();
	 private TDetOffres offre = new TDetOffres();
	 //private TDetOffres sltOffre = new TDetOffres();
	 private VDetOffreRecevable sltOffre = new VDetOffreRecevable();
	 private TSoumissions soumission = new TSoumissions();
	 private TLotAao lot = new TLotAao();
	 private VLot sltLot = new VLot();
	 private TDetailVente vente = new TDetailVente();
	 private TPiecesOffres newPieceOffre = new TPiecesOffres();
	 private TSeances newSeance = new TSeances();
	 private TDetCommissionSeance newDetailSeance = new TDetCommissionSeance();
	 private VDetCommissionSeance sltMbr = new VDetCommissionSeance();
	 private VbAnalyseOffre newAnalyseOffre =new VbAnalyseOffre();
	 private VListeSouOffBasse sltRecharge =new VListeSouOffBasse();

	 
	 //Declaration des variables
	 private String tcoCode;
	 private String laaId;
	 private String banCode;
	 private String filtreNcc="";
	 private String nbreOffre ="";
	 private long valRegQual=0;
	 private long verifCorNum = 0;
	 private String aaoRegQual="";
	 private boolean infoOffre=false;
	 private Boolean boutonEdit=false;
	 
	 private boolean conformite=false;
	 private Boolean montant=false;
	 
	 private boolean saisie=false;
	 private boolean affichage=false;
	 
	 private boolean etatMontVar=false;
	 
	 private long montLu=0;
	 private long montN=0;
	 private long pourcentRab=0;
	 private long montRab=0;
	 private long numSeance=0;
	 private String numVente = "";
	 private String dofTyp;
	 private String ncc;
	 private BigDecimal dofNum;
	 private long laaNum;
	 private long lotId;
	 private int nbrLot;
	 private String filtreCandidat="";
	 private String filtreLot="";
	 private String natdoc ="6";
	 //private long rabais
	 
	 
	 
	 //Resultat analyse*
	 
	 public void chargeResultaFilter() {
		 listeVerifCor = ((List<VVerifcorOffin>)iservice.getObjectsByColumn("VVerifcorOffin",new ArrayList<String>(Arrays.asList("RId")),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+laaId))); 
		  if (!listeVerifCor.isEmpty()) {
			  infoLot=listeVerifCor.get(0); 
	       }
		 
		 listeSouOffEleve = ((List<VListeSouOffEleve>)iservice.getObjectsByColumn("VListeSouOffEleve",new ArrayList<String>(Arrays.asList("RId")),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+laaId)));
		 
		 listeSouOffBass = ((List<VListeSouOffBasse>)iservice.getObjectsByColumn("VListeSouOffBasse",new ArrayList<String>(Arrays.asList("RId")),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+laaId)));
		 
		 listeRecapSeuil =  ((List<VRecapSeuilAnormal>)iservice.getObjectsByColumn("VRecapSeuilAnormal",new ArrayList<String>(Arrays.asList("DOF_LAA_ID")),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+laaId)));
	       if (!listeRecapSeuil.isEmpty()) {
	    	   infoSeuil=listeRecapSeuil.get(0); 
	       }
		 
	       resultatAttributaire = ((List<VResultEvalClassLot>)iservice.getObjectsByColumn("VResultEvalClassLot",new ArrayList<String>(Arrays.asList("RANG")),
					 new WhereClause("LAA_NUM",Comparateur.EQ,""+infoLot.getLaaNum()),
					 new WhereClause("LAA_DAC_CODE",Comparateur.EQ,""+infoLot.getLaaDacCode())));
	       

				 resultatPropAttributaire = ((List<VResultPropAttribLot>)iservice.getObjectsByColumn("VResultPropAttribLot",new ArrayList<String>(Arrays.asList("LOT")),
						 new WhereClause("LAA_DAC_CODE",Comparateur.EQ,""+infoLot.getLaaDacCode())));
			 
		
	 }
	 
	 
	//Vérification et correction des offres financières
	 public void verifCor() {
		  if(recupLot.getLaaId() == null) {
			  verifCorNum = 0;
		  }else {
			  verifCorNum = recupLot.getLaaId();
		  }
		 
		 listeVerifCor = ((List<VVerifcorOffin>)iservice.getObjectsByColumn("VVerifcorOffin",new ArrayList<String>(Arrays.asList("RId")),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+verifCorNum)));
	 }
	 
	//Liste des soumissions anormalement élévées 
	 public void offreEleve() {
		 if(recupLot.getLaaId() == null) {
			 lotId = 0;
		  }else {
			  verifCorNum = recupLot.getLaaId();
		  }
		 listeSouOffEleve = ((List<VListeSouOffEleve>)iservice.getObjectsByColumn("VListeSouOffEleve",new ArrayList<String>(Arrays.asList("RId")),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+lotId)));
	 }
	 
	 //Liste des soumissions anorlement basses
	 public void offreBasse() {
		 if(recupLot.getLaaId() == null) {
			 lotId = 0;
		  }else {
			  lotId = recupLot.getLaaId();
		  }
		 
		 listeSouOffBass = ((List<VListeSouOffBasse>)iservice.getObjectsByColumn("VListeSouOffBasse",new ArrayList<String>(Arrays.asList("RId")),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+laaId)));
		 
		 
	 }
	
	 //
		 public void offreResulatatAttrib() {
			 resultatAttributaire = ((List<VResultEvalClassLot>)iservice.getObjectsByColumn("VResultEvalClassLot",new ArrayList<String>(Arrays.asList("RANG")),
					 new WhereClause("LAA_NUM",Comparateur.EQ,""+recupLot.getLaaNum()),
					 new WhereClause("LAA_DAC_CODE",Comparateur.EQ,""+recupLot.getTDacSpecs().getDacCode())));
		 }
		 
	
	//Afficher la variante ou l'offre de Base du lot
	public void doftyp() {
		listdoftyp.clear();
		listdoftyp = ((List<VDofTyp>)iservice.getObjectsByColumn("VDofTyp",new ArrayList<String>(Arrays.asList("R_ID")),
				 new WhereClause("LAA_ID",Comparateur.EQ,""+tlot.getLaaId()),
				 new WhereClause("CAN_SOU_NCC",Comparateur.EQ,""+tlot.getCanSouNcc()),
				 new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+tlot.getLaaAaoCode()))); 
	  }
		
        
		 public void offreResultPropAttrib() {
			 resultatPropAttributaire = ((List<VResultPropAttribLot>)iservice.getObjectsByColumn("VResultPropAttribLot",new ArrayList<String>(Arrays.asList("LOT")),
					 new WhereClause("LAA_DAC_CODE",Comparateur.EQ,""+recupLot.getTDacSpecs().getDacCode())));
		 }
		 
		 
		 public void detailSeuil() {
			 if(recupLot.getLaaId() == null) {
				 lotId = 0;
			  }else {
				  verifCorNum = recupLot.getLaaId();
			  }
			 listeRecapSeuil =  ((List<VRecapSeuilAnormal>)iservice.getObjectsByColumn("VRecapSeuilAnormal",new ArrayList<String>(Arrays.asList("DOF_LAA_ID")),
					 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+lotId)));
		       if (!listeRecapSeuil.isEmpty()) {
		    	   infoSeuil=listeRecapSeuil.get(0); 
  			} 
		 }
		 
		 //Methode de Repechage
		 public void saveRepechage() {
			 
			 offreListe = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					 new WhereClause("DOF_NUM",Comparateur.EQ,""+sltRecharge.getDofNum())));
					  if (!listeOffres.isEmpty()) {
						  offre=offreListe.get(0); 
						  offre.setDofRepeche(sltRecharge.getDofRepeche());
						  offre.setDofObsAnormal(sltRecharge.getCommentaireAnormal());
						  iservice.updateObject(offre);
						  
						  //offreBasse();
						  chargeResultaFilter();
						  
						  userController.setTexteMsg("Repechage effectué avec succès!");
						  userController.setRenderMsg(true);
						  userController.setSevrityMsg("success");
		 			} 
				
			
					  
		 }
		
	 //fin resultat analyse
		//Liste des membres du commite d'evaluation
	 public void chargeMembreCommite() {
		 membresCommite.clear();
		 membresCommite = ((List<VDetCommissionSeance>)iservice.getObjectsByColumn("VDetCommissionSeance",new ArrayList<String>(Arrays.asList("DCS_NOM_MBM")),
				 new WhereClause("DCS_COM_TCO_CODE",Comparateur.EQ,"COJ"),
				    new WhereClause("DCS_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode())));
				// );
				_logger.info("membreCommite size: "+membresCommite.size());	
	 }
	 
	//Liste des membres du commite d'evaluation
		 public void chargeMembre() {
			 selectionMembresCommite.clear();
			 listeCommite.clear();
			 listeCommite = ((List<VDetCommissionSeance>)iservice.getObjectsByColumn("VDetCommissionSeance",new ArrayList<String>(Arrays.asList("DCS_NOM_MBM")),
					 new WhereClause("DCS_COM_TCO_CODE",Comparateur.EQ,"CEV"),
					    new WhereClause("DCS_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode())));
					// );
					_logger.info("membreCommite size: "+listeCommite.size());	
		 }
	 
	 public void checkMontantVar() {
		 if(dofTyp.equalsIgnoreCase("B")) {
			 etatMontVar = false; 
		 }else {
			 etatMontVar = true;  
		 } 
	 }
	 
	
	 
	 public void calculMontNet() {
		 montRab= montLu * pourcentRab/100;
		 montN = montLu - montRab;
		 System.out.print("montant est : "+getMontN());
	 }
	 
	 
	 public void calculPourcent() {
		 pourcentRab = montRab * 100/montLu;
		 System.out.print("le pourcentage est : "+getPourcentRab());
	 }
	 
	 //Suppression du membre de comité d'évaluation
	 public void deleteMembre() {	
		  System.out.print("+-------------+MEMBRE: "+getSltMbr().getDcsNomMbm());
		 try {
		       listMbrSup = ((List<TDetCommissionSeance>)iservice.getObjectsByColumn("TDetCommissionSeance",new ArrayList<String>(Arrays.asList("DCS_NUM")),
				    new WhereClause("DCS_NUM",Comparateur.EQ,""+sltMbr.getDcsNum())));
		           if (!listMbrSup.isEmpty()) {
		    	        mbrSup=listMbrSup.get(0); 
    			        }
		     iservice.deleteObject(getMbrSup());
		     chargeMembre();
		     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Membre supprimé avec succès! ", ""));
		 }catch (org.hibernate.exception.ConstraintViolationException e) {
   			 userController.setTexteMsg("Impossible de supprimer le membre !");
   			 userController.setRenderMsg(true);
   			 userController.setSevrityMsg("danger");	 
   		 } 
	}
	 

	 
	//Liste des piecs de l'offre
	 public void chargePieces() {
		 listePiecesOffres = ((List<VPiecesOffre>)iservice.getObjectsByColumn("VPiecesOffre",new ArrayList<String>(Arrays.asList("TPO_LIBELLE")),
				 new WhereClause("OPD_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode())));	
	 }
	 
	 //liste des attributaire en affichage
	 public void chargeAffAttributaire() {
		 listeAttibutaire = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
				 new WhereClause("DOF_RET",Comparateur.EQ,"O"),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+lot.getLaaId())));
	 }
	 
	 public void chargeAttributaire() {
		 listeAffichageAttibutaire.clear();
		 listeAffichageAttibutaire = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
				 new WhereClause("DOF_RET",Comparateur.EQ,"O"),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+sltOffre.getDofLaaId())));
	 }
	 
	 public void chargeCritereAnalyse() {
		 listeCritereAnalyse.clear();
		 listeCritereAnalyse = ((List<VCritereAnalyseDacOff>)iservice.getObjectsByColumn("VCritereAnalyseDacOff",new ArrayList<String>(Arrays.asList("R_ID")),
				 new WhereClause("DOF_NUM",Comparateur.EQ,""+sltOffre.getDofNum())));
		 _logger.info(" dof_number: "+sltOffre.getDofNum());
		// _logger.info("dacCode dof_number: "+sltOffre.getTLotAao().getTDacSpecs().getDacCode());
		// _logger.info("laaId : "+sltOffre.getTLotAao().getLaaId());
		 
		 if (!listeCritereAnalyse.isEmpty()) {
             sltCritere= listeCritereAnalyse.get(0);
             _logger.info("valeur: "+sltCritere.getAaoRegQual());
             
/*
         	if(sltCritere.getAaoRegQual().equalsIgnoreCase("CONFORME") || sltCritere.getAaoRegQual().equalsIgnoreCase("null")) {
				conformite=true;
				montant =false;
			}else
				if(sltCritere.getAaoRegQual().equalsIgnoreCase("SCORE")) {
					montant =true;
					conformite=false;
				}else
						if(sltCritere.getAaoRegQual().equalsIgnoreCase("AUTRE")) {
							
						}*/
               }
	 }
	 
	 
	 public void verifConformite() {
	
		  listeAvis = ((List<TAvisAppelOffre>)iservice.getObjectsByColumn("TAvisAppelOffre",new ArrayList<String>(Arrays.asList("AAO_CODE")),
 				 new WhereClause("AAO_CODE",Comparateur.EQ,""+sltOffre.getDofLaaAaoCode())));
                  if (!listeAvis.isEmpty()) {
                 	 sltAvis = listeAvis.get(0);
                 	 
                 		if(sltAvis.getAaoRegQual().equalsIgnoreCase("CONFORMITE") || sltCritere.getAaoRegQual().equalsIgnoreCase("null")) {
             				conformite=true;
             				montant =false;
             			}else
             				if(sltAvis.getAaoRegQual().equalsIgnoreCase("SCORE")) {
             					montant =true;
             					conformite=false;
             				}else
             						if(sltAvis.getAaoRegQual().equalsIgnoreCase("AUTRE")) {
             							
             						}
                            }
	 }
	 
	//Liste des piecs de l'offre a l'analyse
	 public void chargePiecesAnalyse() {
		 listePiecesOffresAnalyse = ((List<VPiecesOffreAnalyse>)iservice.getObjectsByColumn("VPiecesOffreAnalyse",new ArrayList<String>(Arrays.asList("TPO_LIBELLE")),
				// new WhereClause("POF_LAA_ID",Comparateur.EQ,""+sltOffre.getDofLaaId())));
				 //new WhereClause("ODP_TPO_ETAP_PIECE",Comparateur.EQ,"Ouverture"),
				 new WhereClause("POF_DOF_NUM",Comparateur.EQ,""+sltOffre.getDofNum())));
		 nbrLot =nonbreLot();
		 
		 chargeCritereAnalyse();
		 verifConformite();
		 //chargeMention();
	 }
		 
		 public void controleNbrLot() {
			if(sltOffre.getDofRangOfr()> nbrLot) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le rang ne doit pas etre superieur au nombre total de lot! ", "")); 	 	
			}
		 }
	 
	//Liste des membres de la commssions
		 
		//Liste des membres de la commssions
		 public void chargeMembres() {
			 listeMembre = ((List<VDacMembre>)iservice.getObjectsByColumn("VDacMembre",new ArrayList<String>(Arrays.asList("TCT_CODE")),
					 new WhereClause("TCT_TCO_CODE",Comparateur.EQ,"COJ"),
					 new WhereClause("COM_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode())));
					_logger.info("listeMembre size: "+listeMembre.size());	
					
					
		 }
		 
		 
		/* public void chargeMembreCommission() {
			 membresCommission = ((List<VCompoCommission>)iservice.getObjectsByColumn("VCompoCommission",new ArrayList<String>(Arrays.asList("TCT_CODE")),
					    new WhereClause("STR_CODE",Comparateur.EQ,""+userController.getSlctd().getTFonction().getTStructure().getStrCode()),
					    new WhereClause("TCT_TCO_CODE",Comparateur.EQ,"COJ")));
					_logger.info("membre size: "+membresCommission.size());	
					
					
		 }*/
		 

		 
		//Liste des offres VBdetaiOffre
		 public void chargeOffres() {
			 listeOffre.clear();
			 listeOffre = ((List<VDetailOffres>)iservice.getObjectsByColumn("VDetailOffres",
					 new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode())));
				_logger.info("listeOffres size: "+listeOffre.size());	
				nbreOffre = ""+getNbreOffreTotal();
		 }
		 
		//Liste des offres TdetaiOffre
		 public void chargeOffre() {
			 listeOffres.clear();
			 listeOffres = ((List<VDetOffreRecevable>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM"))//,
					// new WhereClause("DOF_LAA_ID",WhereClause.Comparateur.EQ,""+lot.getLaaId())
					 ));
				_logger.info("listeOffres size: "+listeOffres.size());	
			 
		 }
		 
		//Filte 
		 public void chargeOffreFilterOffre() {
			 listeOffres.clear();
			 listeOffres = ((List<VDetOffreRecevable>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					// new WhereClause("DOF_LAA_ID",WhereClause.Comparateur.EQ,""+lot.getLaaId())
				     new WhereClause("DOF_NUM",WhereClause.Comparateur.LIKE,"%"+dofNum+"%")  
					 ));
				_logger.info("listeOffres size: "+listeOffres.size());	
		 }
		 
		 //Liste des Banques
		 public void chargeBanque() { 
		     listBanque=new ArrayList<>(constantService.getListBanque());
		 }
		 
		//Liste des lot d'un avis d'avis d'appel d'offre
		 public void chargeLots() {
			 //listeLots.clear();
			 listeLots = ((List<TLotAao>)iservice.getObjectsByColumn("TLotAao",new ArrayList<String>(Arrays.asList("LAA_ID")),
					    new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode())
					    ));
					_logger.info("listeLots size: "+listeLots.size());	
		 }
		 
		//Liste des lots d'un avis d'avis d'appel d'offre en fonction du candidat
		 public void chargeLotsByCandidat() {
			 //lotByCandidat.clear();
			 lotByCandidat = ((List<VLotCandidat>)iservice.getObjectsByColumn("VLotCandidat",new ArrayList<String>(Arrays.asList("LAA_ID")),
					    new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()),
					    new WhereClause("CAN_SOU_NCC",Comparateur.EQ,""+candidat.getSouNcc())));
					_logger.info("lotByCandidat size: "+lotByCandidat.size());	
		 }
		 
		//Liste des lots d'un avis de l'avis d'appel d'Offres
		 public void chargeLotsCandidat() {
			 lotByCandidat.clear();
			 lotByCandidat = ((List<VLotCandidat>)iservice.getObjectsByColumn("VLotCandidat",new ArrayList<String>(Arrays.asList("LAA_ID")),
					    new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode())));
					_logger.info("lotByCandidat size: "+lotByCandidat.size());	
		 }
		 
		//Liste des lot d'un avis d'avis d'appel d'offre
		 public void chargeLotByAvis() {
			 listeLots.clear();
			listeLotsByAvis=(List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")),
					new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
			_logger.info("listeLotsByAvis size: "+listeLotsByAvis.size());
		 }
		 
		//filtre lot
		 public void chargeLotFilterLot() {
			 listeLots.clear();
			listeLotsByAvis=(List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_NUM")),
					new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()),
					new WhereClause("LAA_NUM",WhereClause.Comparateur.LIKE,"%"+laaNum+"%")); 
			_logger.info("listeLotsByAvis size: "+listeLotsByAvis.size());
		 }
		 
		//Liste des offres d'un lot
		 public void onSelectLot() {
			 listeAttibutaire.clear();
			 listeOffres.clear();
			 listeOffres = ((List<VDetOffreRecevable>)iservice.getObjectsByColumn("VDetOffreRecevable",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					  new WhereClause("DOF_LAA_ID",WhereClause.Comparateur.EQ,""+lot.getLaaId())));
				_logger.info("listeOffres size: "+listeOffre.size());	
				
				//pour jugelment
				 saisie=false;
				 affichage=true;
				 chargeAffAttributaire();
		 }
		 
		 public void chargeFilterOffres() {
			 listeAttibutaire.clear();
			 listeOffre.clear();
			 listeOffres = ((List<VDetOffreRecevable>)iservice.getObjectsByColumn("VDetOffreRecevable",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					  new WhereClause("DOF_LAA_ID",WhereClause.Comparateur.EQ,""+lot.getLaaId()),
					  new WhereClause("DOF_NUM",WhereClause.Comparateur.LIKE,"%"+dofNum+"%")));
				_logger.info("listeOffres size: "+listeOffres.size());	
				
				//pour jugelment
				 saisie=false;
				 affichage=true;
				 chargeAffAttributaire();
		 }
		 
		 
		 
		 //Verification du numero de vente
		 public void verifierNumVente() {
			 infoOffre=false;
			 listeVentes =(List<TDetailVente>) iservice.getObjectsByColumn("TDetailVente", new ArrayList<String>(Arrays.asList("DVE_VEN_NUM")),
			new WhereClause("DVE_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode()),
			new WhereClause("DVE_VEN_NUM",WhereClause.Comparateur.EQ,""+numVente));
			if (!listeVentes.isEmpty()) {
				vente=listeVentes.get(0);
				infoOffre=true;
				//System.out.println("idu "+entAp.getEseCodeInvest());
				//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"IDU : ",""+entAp.getEseCodeInvest())); 	 
			}else {
				infoOffre=false;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce numero de vente n'existe pas! ", "")); 	 
			}
				
		 }
		 
		 
	 
	 //Liste des types de commission
		 public void chargeTypeCommission() {
			 listeTypeCommission.clear();
			 listeTypeCommission = ((List<TTypeCommission>)iservice.getObjectsByColumn("TTypeCommission",new ArrayList<String>(Arrays.asList("TCO_CODE")),
					  new WhereClause("TCO_CODE",Comparateur.NEQ,"CEV")
					    ));		 
					 
		 }
		 
		//Enregistrement des membres de la commission (avec trigger djan)
		/*public void savePresence() {
			//membre.setDcsComStrCode(userController.getSlctd().getTOperateur().getTMinistere().getTStructures().);
			//membre.setDcsComTcoCode(tcoCode);
			 if (selectionMembres.size()==0) {
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Selectionnez un membre ", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}else {
					
					for(TCommissionType mbr : selectionMembres) {
						//VbTempParametreCom membre =new VbTempParametreCom();
						membre.setDcsDteSaisi(Calendar.getInstance().getTime().toString());
						membre.setTempDteSaisi(Calendar.getInstance().getTime());
						membre.setDcsComTcoCode("COJ");
						membre.setDcsComTctCode(mbr.getTctCode());
						membre.setDcsNomMbm(mbr.getTctNomMbm());
						membre.setDcsPreMbm(mbr.getTctPreMbm());
						membre.setDcsTelMbm(mbr.getTctTelMbm());
						membre.setDcsRepMandate(mbr.getTctRepMandate());
						membre.setDcsObservation(mbr.getTctTitre());
						membre.setTempType("COM");
						membre.setDcsFonCod(mbr.getTctLibelle());
						membre.setDcsOpeMatSaisi(userController.getSlctd().getTOperateur().getOpeMatricule());
						membre.setDcsDacCode(slctdTd.getTDacSpecs().getDacCode());
						membre.setDcsComStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
						membre.setDcsSeaTseNum("OUV");
						membre.setDcsFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
						iservice.addObject(membre);
					}
					boutonEdit = true;
					  userController.setTexteMsg("Enregistrement effectué avec succès !");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");
			}
		}*/
			//Liste des membres de la commssions
		 public void chargeExpert() {
			 selectionlisteExpert.clear();
			 listeExpert.clear();
			 listeExpert = ((List<VCommissionTypeExp>)iservice.getObjectsByColumn("VCommissionTypeExp",new ArrayList<String>(Arrays.asList("TCT_CODE")),
					 new WhereClause("TCT_TST_CODE",Comparateur.EQ,""+userController.getSlctd().getTFonction().getTStructure().getTTypeStructure().getTstCode()),
					 new WhereClause("TCT_GRP_CODE",Comparateur.EQ,"AUT"),
					 new WhereClause("TCT_TCO_CODE",Comparateur.EQ,"COJ")));
					_logger.info("expert size: "+listeExpert.size());	
					
					
		 }
		 
		 
		 public void saveExpert() {
		 		//COMPOSITION DE LA SEANCE
				 if (selectionlisteExpert.size()==0) {
					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Selectionnez un expert ", "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}else {
						
						for(VCommissionTypeExp mbr : selectionlisteExpert) {							
							newcomSpecif.setComDteSaisi(Calendar.getInstance().getTime());
							newcomSpecif.setComTctCode(mbr.getTctCode());
							newcomSpecif.setComOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
							newcomSpecif.setComDacCode(slctdTd.getTDacSpecs().getDacCode());
							newcomSpecif.setComStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
							newcomSpecif.setComTcoCode("COJ");
							iservice.addObject(newcomSpecif);
						}
						//chargeExpert();
						chargeMembres();
						userController.setTexteMsg("Expert(s) enregistré(s) avec succès!");
	  		            userController.setRenderMsg(true);
	  		            userController.setSevrityMsg("success");

					}
		 	}
		 
			public void savePresence() {
				//Mise a jour dans T_AvisAppelOffrfe
				if(slctdTd.getAaoNbrOff()> newSeance.getSeaNbrPli()) {
					 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Le nombre d'offres recu ne doit pas etre supérieur au nombre de pli", "");
						FacesContext.getCurrentInstance().addMessage(null, msg);	
				}else {
					iservice.updateObject(slctdTd);
					
					//Creation de la séance
					newSeance.setSeaLibelle("SEANCE D'OUVERTURE DES OFFRES DU DAO N° "+slctdTd.getTDacSpecs().getDacCode());
					newSeance.setTTypeSeance(new TTypeSeance("OUV"));
					newSeance.setSeaSteSaisi(Calendar.getInstance().getTime());
					newSeance.setTFonction(userController.getSlctd().getTFonction());
					newSeance.setTOperateur(userController.getSlctd().getTOperateur());
					iservice.addObject(newSeance);
					
					//CREATION DE LA COMMISSION SPECIFIQUE
					newcomSpec.setComDteSaisi(newSeance.getSeaSteSaisi());
					newcomSpec.setComOpeMatricule(newSeance.getTOperateur().getOpeMatricule());
					newcomSpec.setTStructure(userController.getSlctd().getTFonction().getTStructure());
					newcomSpec.setComMarCode(slctdTd.getTDacSpecs().getTTypeMarche().getTymCode());
					newcomSpec.setTAvisAppelOffre(slctdTd);
					newcomSpec.setTDacSpecs(slctdTd.getTDacSpecs());
	/*				newcomSpec.setTCommissionType(new TCommissionType(""));*/
					newcomSpec.setTTypeCommission(new TTypeCommission("COJ"));
					iservice.addObject(newcomSpec);
					
					//COMPOSITION DE LA SEANCE
					 if (selectionMembres.size()==0) {
						 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Selectionnez un membre ", "");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						}else {
							
							for(VDacMembre mbr : selectionMembres) {
								newDetailSeance.setDcsDteSaisi(Calendar.getInstance().getTime());
								newDetailSeance.setDcsNomMbm(mbr.getTctNomMbm());
								newDetailSeance.setDcsPreMbm(mbr.getTctPreMbm());
								newDetailSeance.setDcsTelMbm(mbr.getTctTelMbm());
								newDetailSeance.setDcsRepMandate(mbr.getTctRepMandate());
								newDetailSeance.setDcsRepMandate(mbr.getTctRepMandate());
								newDetailSeance.setDcsFonCod(mbr.getTctLibelle());
								newDetailSeance.setDcsObservation(mbr.getTctTitre());
								newDetailSeance.setDcsStrCom(mbr.getComStrCom());
								newDetailSeance.setDcsFonAdmin(mbr.getComFonAdmin());
								newDetailSeance.setTSeances(newSeance);
								newDetailSeance.setTStructure(userController.getSlctd().getTFonction().getTStructure());
								newDetailSeance.setTTypeCommission(new TTypeCommission("COJ"));
								newDetailSeance.setTDacSpecs(slctdTd.getTDacSpecs());
								newDetailSeance.setTCommissionSpecifique(newcomSpec);
								newDetailSeance.setTOperateur(userController.getSlctd().getTOperateur());
								iservice.addObject(newDetailSeance);
							}
						}
					
					 chargeMembreCommite();
					   boutonEdit = true;
					  userController.setTexteMsg("Enregistrement effectué avec succès !");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");
				}
				
			}
		
		//Enregistrement des membres du commité technique 
		public void saveCommiteEvaluation() {
			 if (selectionMembresCommite.size()==0) {
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Selectionnez un membre ", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}else {
					for(VDetCommissionSeance mbr : selectionMembresCommite) {
						membre.setDcsDteSaisi(Calendar.getInstance().getTime().toString());
						membre.setTempDteSaisi(Calendar.getInstance().getTime());
						membre.setDcsComTcoCode("CEV");
						//newmbrCommite.setDcsComTctCode(mbr.getTctCode());
						membre.setDcsNomMbm(mbr.getDcsNomMbm());
						membre.setDcsPreMbm(mbr.getDcsPreMbm());
						membre.setDcsTelMbm(mbr.getDcsTelMbm());
						membre.setDcsRepMandate(mbr.getDcsRepMandate());
						membre.setDcsObservation(mbr.getDcsObservation());
						membre.setDcsFonAdmin(mbr.getDcsFonAdmin());
						membre.setDcsStrCom(mbr.getDcsStrCom());
						membre.setTempType("COM");
						membre.setDcsFonCod(mbr.getDcsFonCod());
						membre.setDcsOpeMatSaisi(userController.getSlctd().getTOperateur().getOpeMatricule());
						membre.setDcsDacCode(slctdTd.getTDacSpecs().getDacCode());
						membre.setDcsComStrCode(userController.getSlctd().getTFonction().getTStructure().getStrCode());
						membre.setDcsSeaTseNum("EVA");
						membre.setDcsFonCodSaisi(userController.getSlctd().getTFonction().getFonCod());
					   iservice.addObject(membre);	
					}
					chargeMembre();
					  userController.setTexteMsg("Enregistrement effectué avec succès !");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");	
					
				}
			 chargeMembre();
		}
		
		public void chargeMention() {
			 listeCritereAnalyse = (List<VCritereAnalyseDacOff>) iservice.getObjectsByColumn("VCritereAnalyseDacOff", new ArrayList<String>(Arrays.asList("CRA_CODE")),
                     // new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
                      new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode()));
                      if (!listeCritereAnalyse.isEmpty()) {
                             sltCritere= listeCritereAnalyse.get(0);
                             _logger.info("valeur: "+sltCritere.getAaoRegQual());
                             
                         	if(sltCritere.getAaoRegQual().equalsIgnoreCase("CONFORME") || sltCritere.getAaoRegQual().equalsIgnoreCase("null")) {
                				conformite=true;
                				montant =false;
                			}else
                				if(sltCritere.getAaoRegQual().equalsIgnoreCase("SCORE")) {
                					montant =true;
                					conformite=false;
                				}else
                						if(sltCritere.getAaoRegQual().equalsIgnoreCase("AUTRE")) {
                							
                						}
                             
                               }
		}
		
		//Methode de suppression d'un membre
		 public void removeMembre() {
			 System.out.print("+-------------+ "+getNewMembre().getDcsNomMbm());
			 try {
				 listeDetCom = (List<TDetCommissionSeance>) iservice.getObjectsByColumn("TDetCommissionSeance", new ArrayList<String>(Arrays.asList("DCS_NUM")),
							new WhereClause("DCS_NUM",WhereClause.Comparateur.EQ,""+newMembre.getDcsNum()));
			     if(!listeDetCom.isEmpty()) {
			    	 detCom=listeDetCom.get(0);
			     }
				 
				    iservice.deleteObject(getDetCom());
				    chargeMembreCommite();
					userController.setTexteMsg("Suppression effectuée avec succès !");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");

			 } catch (org.hibernate.exception.ConstraintViolationException e) {
				 userController.setTexteMsg("Impossible de supprimer le membre !");
				 userController.setRenderMsg(true);
				 userController.setSevrityMsg("danger");	 
			 }
		 }
		 
		
		
		//Methode Upload
		 @Transactional
		 public void upload(FileUploadEvent event) throws IOException{
			  
			 listeDetCom = (List<TDetCommissionSeance>) iservice.getObjectsByColumn("TDetCommissionSeance", new ArrayList<String>(Arrays.asList("DCS_NUM")),
						new WhereClause("DCS_NUM",WhereClause.Comparateur.EQ,""+newMembre.getDcsNum()));
		     if(!listeDetCom.isEmpty()) {
		    	 detCom=listeDetCom.get(0);
		     } 	
		 	    
				if(fileUploadController.handleFileUpload(event, ""+detCom.getDcsNum(), natdoc)) {
					
					//check le dossier s'il existe à faire
					TDossierMbr dos = new TDossierMbr(); //TNatureDocument 
					dos = new TDossierMbr() ;
					
					int nat = Integer.valueOf(natdoc);

					dos.setTNatureDocuments(new TNatureDocuments((short)nat));
					//dos.setDpgCode(keyGen.getCodeDossierPgpm(fileUploadController.getFileCode()+"-"));
					dos.setTDetCommissionSeance(detCom);
					dos.setDmbNom(fileUploadController.getFileName());
					dos.setDmbCommentaire(fileUploadController.getDocNom());
					dos.setDmbReference("");
					dos.setDmbDteSaisi(Calendar.getInstance().getTime());
					iservice.addObject(dos);
					chargeDossier();
					//Message de Confirmation
					userController.setTexteMsg("Mandat enregistré!");
					userController.setRenderMsg(true);
					userController.setSevrityMsg("success");
				     }else {
				    	//Message d'erreur
						 userController.setTexteMsg("Document non enregistré, charger à nouveau un document!");
						 userController.setRenderMsg(true);
						 userController.setSevrityMsg("danger");
							}
				  }
		 
	
		
		 //Edition de fiche membres
		 public void imprimerFicheMbr() {
			   projetReport.longparam1(newSeance.getSeaNum(), "membres_cojo", "membres_cojo");    
			}
		 
		 //Love condidat
		 
		 public void chargeDossier() {
			 dossListe.clear();
				 dossListe = ((List<TDossierMbr>)iservice.getObjectsByColumnDesc("TDossierMbr",new ArrayList<String>(Arrays.asList("DMB_ID")),
						 new WhereClause("DMB_DCS_NUM",Comparateur.EQ,""+detCom.getDcsNum())));
		    }
		 
		 public void openDossier() throws IOException{
       		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDmbNom(), selectedDossier.getDmbNom());
       		   }
		 //private TFonction recupFonction= new TFonction();
		/* public void onSelectCandidat() {
				
			 
			 recupFonction = new TFonction();
			 recupFonction.setFonCod(fonction.getFonCod());
			 recupFonction.setFonLibelle(fonction.getFonLibelle());
			 chargePgpmCpmpDmp();
			 chargeImputationCpmpDmp();
				}*/
		 
		  //Supprimer un dossier
	    public void removeDossier(){
		downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDmbNom(), selectedDossier.getDmbNom());
		//check si le dossier est OM
			 iservice.deleteObject(selectedDossier);
			 chargeDossier();	 
		 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDmbNom()+" supprimé!", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
		}
	        
		/* //Afficher la liste des candidats dans v_candidat_da(love)
		 public void chargeCandidats() {
			 listCandidats.clear();
			 listCandidats = ((List<VCandidatDac>)iservice.getObjectsByColumn("VCandidatDac",new ArrayList<String>(Arrays.asList("CAN_SOU_SIGLE_STE")),
					 new WhereClause("DVE_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode())));
			 _logger.info("Nbr candidat: "+listCandidats.size());
		 }*/
		 
		 
		 //Afficher la liste des candidats dans v_candidat_da(love)
		 public void chargeCandidats() {
			 listCandidats.clear();
			 listCandidats = ((List<VOffreCandidat>)iservice.getObjectsByColumn("VOffreCandidat",new ArrayList<String>(Arrays.asList("SOU_SIGLE_STE")),
					 new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode())));
			 _logger.info("Nbre candidat: "+listCandidats.size());
		 }
		 

		/* public void chargeFilterCandidats(){
			 listCandidats.clear();
			 listCandidats = ((List<VCandidatDac>)iservice.getObjectsByColumn("VCandidatDac",new ArrayList<String>(Arrays.asList("CAN_SOU_SIGLE_STE")),
					 new WhereClause("CAN_SOU_NCC",WhereClause.Comparateur.LIKE,"%"+filtreCandidat+"%"),
					 new WhereClause("DVE_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode())));
			}*/
		 
		 
		 
		 public void chargeFilterCandidats(){
			 listCandidats.clear();
			 listCandidats = ((List<VOffreCandidat>)iservice.getObjectsByColumn("VOffreCandidat",new ArrayList<String>(Arrays.asList("SOU_SIGLE_STE")),
					 new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+filtreCandidat+"%"),
					 new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode())));
			}
		 
		 
		//Nombre total d'offres pour l'acteur connecté
		 public int getNbreOffreTotal(){
		 	int i = iservice.countTableByColumn("V_DETAIL_OFFRES", "R_ID",
		 	new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()),
			new WhereClause("DOF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()));
		 return	i;	
		 	}
		
		 
		 public void chargeFilterLotsByCandidat() {
			 lotByCandidat.clear();
			 lotByCandidat = ((List<VLotCandidat>)iservice.getObjectsByColumn("VLotCandidat",new ArrayList<String>(Arrays.asList("LAA_ID")),
					     new WhereClause("LAA_OBJET",WhereClause.Comparateur.LIKE,"%"+filtreLot+"%"),
					    new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()),
					    new WhereClause("CAN_SOU_NCC",Comparateur.EQ,""+candidat.getSouNcc())));
					_logger.info("lotByCandidat size: "+lotByCandidat.size());	
		 }
			//Filtre les marchés en fonction du code Marché
			/* public void filtrenNccCandidat() {
				 listCandidats.clear();
				 listCandidats = ((List<TCandidats>)iservice.getObjectsByColumn("TCandidats",new ArrayList<String>(Arrays.asList("CAN_NOM")),
						 new WhereClause("CAN_TIE_NCC",WhereClause.Comparateur.LIKE,"%"+filtreNcc+"%")));
					_logger.info("listCandidats size: "+listCandidats.size());	
				 
			 }
		 */
		 
		//Love pour recupérer les candidats
		 public void onSelectCandidat() { 
			 newOffre= new VbTempParamDetOffres();
			 newOffre.setDofSigle(candidat.getSouSigleSte());
			 newOffre.setDofSouNcc(candidat.getSouNcc());
			 
		  recupSoumissionnaire = ((List<VRepSoumissionnaire>)iservice.getObjectsByColumn("VRepSoumissionnaire",new ArrayList<String>(Arrays.asList("DCS_SOU_NCC")),
				  new WhereClause("DCS_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode()),
		         new WhereClause("DCS_SOU_NCC",Comparateur.EQ,""+candidat.getSouNcc())));
			    if (!recupSoumissionnaire.isEmpty()) {
				    recupNcc=recupSoumissionnaire.get(0); 
				       
				    newOffre.setDofNomRep(recupNcc.getDcsNom());
				    newOffre.setDofPreRep(recupNcc.getDcsPrenoms());
				    newOffre.setDofTelRep(recupNcc.getTel());
				    newOffre.setDofMailRep(recupNcc.getDcsMail());
		            }
			    
			    chargeLotsByCandidat();
				_logger.info("Numéro DAO: "+slctdTd.getTDacSpecs().getDacCode());
		   }
		//Fin de la Methode OnSelectCandidat
		 
		//Love pour recupérer les candidats
		 public void onSelectLotCandidat() { 
			 selectLot.setLaaObjet(tlot.getLaaObjet());
			 newOffre.setDofLaaId(tlot.getLaaId().toString());
			 
			 doftyp();
			    //chargeLotsByCandidat();
		   }
		//Fin de la Methode OnSelectCandidat
		
		//Ouverture des offres
		public void saveOuverture() {
				//enregister dans T_analyse_offre
				/*if (selectionCritereAnalyse.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
				}
		 		e*//*if(dofTyp.equalsIgnoreCase("")){
		 			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Choisir le type de l'Offre", ""));
		 		         }else {
		 		        	  iservice.updateObject(slctdTd);
		 		 		  
				 			   newOffre.setDofLaaAaoCode(slctdTd.getAaoCode());
							   //newOffre.setDofLaaId(laaId);
				 			   newOffre.setDofLaaId(tlot.getLaaId().toString());
							   newOffre.setTempType("OFF");
							   newOffre.setDofOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
							   newOffre.setDofDteSaisi(Calendar.getInstance().getTime());
							   newOffre.setDofTyp(dofTyp);
							   //convertir le montant net en qui est en long en string
							   String montantOffre =String.valueOf(montN);
							   String rabais =String.valueOf(pourcentRab);
							   newOffre.setDofMtOfr(montantOffre);
							   newOffre.setDofRab(rabais);
							   iservice.addObject(newOffre);
		 		         }*/
			           iservice.updateObject(slctdTd);
		  
		 			   newOffre.setDofLaaAaoCode(slctdTd.getAaoCode());
		 			   newOffre.setDofLaaId(tlot.getLaaId().toString());
					   newOffre.setTempType("OFF");
					   newOffre.setDofOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
					   newOffre.setDofDteSaisi(Calendar.getInstance().getTime());
					   newOffre.setDofTyp(dofTyp);
					   //convertir le montant net en qui est en long en string
					   String montantOffre =String.valueOf(montN);
					   String rabais =String.valueOf(pourcentRab);
					   newOffre.setDofMtOfr(montantOffre);
					   newOffre.setDofRab(rabais);
					   newOffre.setDofBanCode(banCode);
					   iservice.addObject(newOffre);
		 			
		 			
			 		for(VCritereAnalyseDacOff ligne : selectionCritereAnalyse) {
			 			newAnalyseOffre.setAnfDacCode(ligne.getDcadDacCode());
			 			newAnalyseOffre.setAnfDteSaisi(Calendar.getInstance().getTime());
			 			newAnalyseOffre.setAnfObser(sltOffre.getDofObsCom());
			 			newAnalyseOffre.setAnfOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
			 			iservice.addObject(newAnalyseOffre);
				     }
			 		
			 		
					  //enregister la liste des pièces du dao
				    	if (listeSelectionPiecesOffres.size()==0) {
								FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
							}
					 		else{
						 		for(VPiecesOffre ligne : listeSelectionPiecesOffres) {
						 			newPieceOffre.setPofDteSaisi(Calendar.getInstance().getTime());
						 			newPieceOffre.setPofPresent("O");
						 			newPieceOffre.setPofTypeAct("COJO");  
						 			newPieceOffre.setTDacSpecs(ligne.getOpdDacCode());
						 			newPieceOffre.setTOperateur(userController.getSlctd().getTOperateur());
						 			newPieceOffre.setTTypePieceOffre(ligne.getTpoCode());
						 			newPieceOffre.setTOffrePieceDac(ligne.getOpdNum());
						 			//A revoir
						 			newPieceOffre.setTLotAao(tlot.getLaaId().toString());
						 			iservice.addObject(newPieceOffre);
							     }	
					 }
				     
				    	viderPartiel();
				    	chargeOffres();
				    	chargeCandidats();
				    	userController.setTexteMsg("Ouverture effectuée avec succès !");
						userController.setRenderMsg(true);
						userController.setSevrityMsg("success");
		    }	
		
		//Fin de la methode SaveOuverture()
		
		
		//Le Nombre d'Offre pour un lot
		public int nonbreLot(){
			int i = iservice.countTableByColumn("T_DET_OFFRES", "DOF_NUM",
					new WhereClause("DOF_LAA_ID", WhereClause.Comparateur.EQ,""+sltOffre.getDofLaaId()));
			return	i;	
		}
		
		
		
		
		public void chargeListe(String statut) {
			 listeAppelOffre.clear();
			 listeAppelOffre = (List<TAvisAppelOffre>) iservice.getObjectsByColumnDesc("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
			 new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,""+statut),
			 new WhereClause("AAO_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("listeAppelOffre size: "+listeAppelOffre.size());
		}
		
		/*
		public void chargeListe(String statut) {
			 listeAppelOffre.clear();
			 listeAppelOffre = (List<VAvisAppelOffre>) iservice.getObjectsByColumnDesc("VAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
			 new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,""+statut),
			 new WhereClause("AAO_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("listeAppelOffre size: "+listeAppelOffre.size());
		}*/
		
		//Fin Ouverture/Analyse/Jugement
		public void finOuverture() {
			String statUpdate = "";
			String message = "";
			if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("APU")) {
				statUpdate = "OUV";
				message="Fin de l'ouverture des Offres de l'avis d'Appel d'offre N°"+slctdTd.getAaoCode();
				//chargeListe("OUV");
				
			 }else {
				 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("OUV")) {
						statUpdate = "ANA";
						//chargeListe("ANA");
						message="Fin de l'analyse des Offres de l'avis d'Appel d'offre N°"+slctdTd.getAaoCode();
				 }else {
					 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("ANA")) {
						 statUpdate = "JUG";
						 //chargeListe("JUG");
						 message="Fin du jugement des Offres de l'avis d'Appel d'offre N°"+slctdTd.getAaoCode();
					 }else {	 
					}	 
				 }
			 }
			slctdTd.setTStatut(new TStatut(statUpdate));	
			iservice.updateObject(slctdTd);
			chargementListe();
			userController.setTexteMsg(message);
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");  
		}
		
		//Methode de chargement après avoir mis fin à l'ouverture/analyse/jugement
		public void chargementListe() {
			if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("APU")) {
				chargeListe("APU"); //OUV
			 }else {
				 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("OUV")) {
						chargeListe("OUV"); //ANA
				 }else {
					 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("ANA")) {
						 chargeListe("ANA"); //JUG
					 }	
				 }
		    }	
	     }
		
		
		
		public void validerAnalyse(){
			slctdTd.setTStatut(new TStatut("ANA"));	
			iservice.updateObject(slctdTd);
			userController.setTexteMsg("Analyse validée avec succès");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
			 /*listeOffres = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					  new WhereClause("DOF_LAA_ID",WhereClause.Comparateur.EQ,""+lot.getLaaId())));
			 
			 if(listeOffres.size()==0){
				 
			 }
			 TDetOffres offre = new TDetOffres();
			 if(!listeOffres.isEmpty()) {
				 offre = listeOffres.get(0);
			 }*/
		}
		
		public void validerJugement(){
			slctdTd.setTStatut(new TStatut("JUG"));	
			iservice.updateObject(slctdTd);
			userController.setTexteMsg("Jugement validé avec succès");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
		}
		
		//Analyser une offre
		public void analyser() {
			
			//Modification des pieces selectionnées a conforme
			/*if(sltOffre.getDofRangOfr()> nbrLot) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Le rang ne doit pas etre superieur au nombre total de lot! ", "")); 	 	
			}else
			{*/
			offreListe = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					 new WhereClause("DOF_NUM",Comparateur.EQ,""+sltOffre.getDofNum())));
			        if (!listeOffres.isEmpty()) {
			        	offre=offreListe.get(0);
			        	offre.setDofStaut("1");
			        	offre.setDofMtCor(sltOffre.getDofMtCor());
			        	offre.setDofMtOfr(sltOffre.getDofMtOfr());
			        	offre.setDofErrFin(sltOffre.getDofErrFin());
			        	offre.setDofObsFin(sltOffre.getDofObsFin());
			        	iservice.updateObject(offre);
			          }
				//sltOffre.setDofStatut("1");
				//iservice.updateObject(sltOffre);
				
				if (listeSelectionPiecesOffresAnalyse.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
				}
		 		else{
			 		for(VPiecesOffreAnalyse ligne : listeSelectionPiecesOffresAnalyse) {
			 			List<TPiecesOffres> LS  = iservice.getObjectsByColumn("TPiecesOffres",  new WhereClause("POF_NUM",Comparateur.EQ,""+ligne.getPofNum()));
			 			TPiecesOffres updatePieceOffre = new TPiecesOffres();
						if(!LS.isEmpty()) {
						updatePieceOffre = LS.get(0);	
			 			updatePieceOffre.setPofConforme("O");
			 			updatePieceOffre.setPofObs(ligne.getPofObs());
			 			iservice.updateObject(updatePieceOffre);
				     }	
			 		}
		         }
				
				//EVALUTATION
				if (selectionCritereAnalyse.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun critère selectionné", ""));
				}
		 		else{
			 		for(VCritereAnalyseDacOff ligne : selectionCritereAnalyse) {
			 			newAnalyseOffre.setAnfDacCode(ligne.getDcadDacCode());
			 			newAnalyseOffre.setAnfDcadNum(ligne.getDcadNum());
			 			newAnalyseOffre.setAnfDcadCraCle(ligne.getCraCode());
			 			//newAnalyseOffre.set
			 			newAnalyseOffre.setAnfDofNum(sltOffre.getDofNum());
			 			newAnalyseOffre.setAnfDteModif(Calendar.getInstance().getTime());
			 			newAnalyseOffre.setAnfDteSaisi(Calendar.getInstance().getTime());
			 			newAnalyseOffre.setAnfLaaId(sltOffre.getDofLaaId().longValue());
			 			newAnalyseOffre.setAnfValeurConf(ligne.getAaoRegQual());
			 			newAnalyseOffre.setAnfValeurScore(ligne.getValRegQual());
			 			newAnalyseOffre.setAnfCommentaire(ligne.getDcadCommentaire());
			 			newAnalyseOffre.setAnfOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
			 			iservice.addObject(newAnalyseOffre);
			 		}
		         }
				
				listeSelectionPiecesOffresAnalyse.clear();
				selectionCritereAnalyse.clear();
				userController.setTexteMsg("Analyse effectuée avec succès !");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");
	    	
			//}
			onSelectLot();
		}
		
		//Ajouter attributaire
		public void ajouterAttributaire() {
			
			/*listeSeance = (List<TSeances>) iservice.getObjectsByColumn("TSeances", new ArrayList<String>(Arrays.asList("SEA_NUM")),
	 			       new WhereClause("SEA_TSE_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()),
	 			       new WhereClause("PLP_GES_CODE",WhereClause.Comparateur.EQ,""+gesCode),
					   new WhereClause("PLP_FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	 	  if (!listPlan.isEmpty()) {
	 		  planPass= listPlan.get(0);*/
			//Création de la séance
			//newSeance.setSeaLibelle("Séance de jugement des offres du DAO N° "+slctdTd.getTDacSpecs());
			newSeance.setSeaLibelle("Séance de jugement des offres du DAO N°");
			newSeance.setTFonction(userController.getSlctd().getTFonction());
			newSeance.setTOperateur(userController.getSlctd().getTOperateur());
			newSeance.setTTypeSeance(new TTypeSeance("JUG"));
			newSeance.setSeaSteSaisi(Calendar.getInstance().getTime());
			iservice.addObject(newSeance);
			
			//update dans t_detail offre
			offreListe = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					 new WhereClause("DOF_NUM",Comparateur.EQ,""+sltOffre.getDofNum())));
			        if (!listeOffres.isEmpty()) {
			        	offre=offreListe.get(0);
			        	offre.setDofRet("O");
			        	offre.setDofStaut("2");
			        	iservice.updateObject(offre);
			          }
			        
			//update dans t_detail offre
			//sltOffre.setDofRet("O");
			//sltOffre.setDofStatut("2");
			//iservice.updateObject(sltOffre);
			saisie=true;
			affichage=false;
			
			
			/*//Création de details seance
			newDetailSeance.setDcsDteSaisi(Calendar.getInstance().getTime());
			newDetailSeance.setTDacSpecs(slctdTd.getTDacSpecs());
			newDetailSeance.setTSeances(newSeance);
			newDetailSeance.setTTypeCommission(new TTypeCommission("COJ"));
			newDetailSeance.setTCommissionSpecifique(new TCommissionSpecifique(8));
			//newDetailSeance.set
			iservice.addObject(newDetailSeance);*/
			
			chargeAttributaire();
			chargeAffAttributaire();
			userController.setTexteMsg("Seance crééé avec succès !");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
		}
		
		//Fin Analyse
		 public void finJugement() {
							
		}
		 
		//Edition de la fiche commission
		 public void editerFicheCommission() {
							
		}
		 
		 //Edition de la fiche de l'Offre
		 public void editerFicheOffre() {
			 projetReport.longparam1(sltOffre.getDofNum().longValue(), "Rapport_ana", "Rapport_ana");
		 }
		 
		 //Edition du PV d'analyse
		 public void editerPvAnalyse() {
			 projetReport.stringparam1(""+slctdTd.getAaoCode(), "page_garde_ouv", "page_garde_ouv");
			 _logger.info("code avis : "  +""+slctdTd.getAaoCode());
		 }
		 
		 
		 
		 public void vider() {
			 newOffre = new VbTempParamDetOffres();
			 infoLot =new VVerifcorOffin();
			 selectLot =new VLotCandidat();
			 newSeance = new TSeances();
			 //slctdTd = new TAvisAppelOffre();
			 newOffre = new VbTempParamDetOffres();
			 listeSelectionPiecesOffresAnalyse= new ArrayList<VPiecesOffreAnalyse>();
			 listeSelectionPiecesOffresAnalyse.clear();
			 listeSelectionPiecesOffres= new ArrayList<VPiecesOffre>();
			 listeSelectionPiecesOffres.clear();
			 listeSouOffBass.clear();
			 listeSouOffEleve.clear();
			 listdoftyp.clear();
			 candidat =new VOffreCandidat();
			 tlot =new VLotCandidat();
			 resultatAttributaire.clear();
			 resultatPropAttributaire.clear();
			 listeRecapSeuil.clear();
			 //listeOffres = new ArrayList<TDetOffres>(); 
			 //listeOffre = new ArrayList<VDetailOffres>();
			 listeOffres.clear();
			 montLu=0;
			 pourcentRab=0;
			 montN=0;
			 dofTyp="";
			 laaId=""; 
		 }
		 
		 public void viderPartiel() {
			 newOffre = new VbTempParamDetOffres();
			 //infoLot =new VVerifcorOffin();
			 selectLot =new VLotCandidat();
			 newSeance = new TSeances();
			 listdoftyp.clear();
			 //candidat =new VOffreCandidat();
			 tlot =new VLotCandidat();
			 listeSelectionPiecesOffresAnalyse= new ArrayList<VPiecesOffreAnalyse>();
			 listeSelectionPiecesOffresAnalyse.clear();
			 listeSelectionPiecesOffres= new ArrayList<VPiecesOffre>();
			 listeSelectionPiecesOffres.clear();
			
			 listeOffres.clear();
			 montLu=0;
			 pourcentRab=0;
			 montN=0;
			 dofTyp="";
			 laaId=""; 
		 }
		 
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "com1":
					vider();
					userController.initMessage();
					String fonct = controleController.getFonctionalite();	
					String statutAffiche = "";
					//Ramener le statut en fonction de l'utilisateur connecté et de l'action a mener
					if(fonct.equalsIgnoreCase("listOuvertureAc")) {
						statutAffiche = "APU";
						_logger.info("staut: "+statutAffiche);	
						_logger.info("fonctionalité: "+fonct);	
						_logger.info("value: "+value+" action: "+action);
					 }else {
						 if(fonct.equalsIgnoreCase("listAnalyseAc")) {
							 statutAffiche = "OUV";	
								_logger.info("staut: "+statutAffiche);	
								_logger.info("fonctionalité: "+fonct);	
								_logger.info("value: "+value+" action: "+action);
						 }else {
							 if(fonct.equalsIgnoreCase("listJugementAc")) {
								 statutAffiche = "ANA";	
									_logger.info("staut: "+statutAffiche);	
									_logger.info("fonctionalité: "+fonct);	
									_logger.info("value: "+value+" action: "+action);
							 }else {
								 if(fonct.equalsIgnoreCase("listValidationDmp")) {
									 statutAffiche = "D2T";	 
								 }else {
									 if(fonct.equalsIgnoreCase("listValidationDmp")) {
										// statutAffiche = "D2T";	
									 }
								 }
							 }	 
						 }
					 }
					
					//Chargement de la liste des demandes
					 listeAppelOffre.clear();
					 listeAppelOffre = (List<TAvisAppelOffre>) iservice.getObjectsByColumnDesc("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
							 new WhereClause("AAO_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					         new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,""+statutAffiche));
					_logger.info("listeAppelOffre size: "+listeAppelOffre.size());	
					
					/* listeAppelOffre.clear();
					 listeAppelOffre = (List<VAvisAppelOffre>) iservice.getObjectsByColumnDesc("VAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
					 				 new WhereClause("AAO_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
					                 new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,""+statutAffiche));
					_logger.info("listeAppelOffre size: "+listeAppelOffre.size());*/
					
					break;
				case "com2":	
				break;
				case "com3":
					chargeLotByAvis();
					chargeOffres();
				break;
				case "com4":
					chargeLots();
					chargeLotByAvis();
					//chargeOffres();
					//chargeOffre();
					break;
				case "com5":
					//chargeTypeCommission();
					chargeMembres();
					boutonEdit = false;
					 selectionMembres.clear();
					 selectionlisteExpert.clear();
					break;
				case "com6":
					//chargeLots();
					chargeOffres();
					chargePieces();
					chargeCandidats();
					chargeLotsCandidat();
					break;
				case "com7":
					chargeLots();
					break;
				case "com8":
					chargeMembreCommite();
					chargeMembre();
					break;
				
				case "com9":
					chargeLotByAvis();
					/*verifCor();
					offreBasse();
					offreEleve();
					offreResulatatAttrib();
					offreResultPropAttrib();
					detailSeuil();*/
					
			    }
		     
		     
		     
		    return userController.renderPage(value);   
		    
		}
	 
	public void test(String value ,String action) {
		if(value.equalsIgnoreCase("")) {
			
		}
	}



	public List<VCompoCommission> getMembresCommission() {
		return membresCommission;
	}

	public void setMembresCommission(List<VCompoCommission> membresCommission) {
		this.membresCommission = membresCommission;
	}

	public List<TTypeCommission> getListeTypeCommission() {
		return listeTypeCommission;
	}

	public void setListeTypeCommission(List<TTypeCommission> listeTypeCommission) {
		this.listeTypeCommission = listeTypeCommission;
	}

	public TCommissionType getNewCom() {
		return newCom;
	}

	public void setNewCom(TCommissionType newCom) {
		this.newCom = newCom;
	}

	public String getTcoCode() {
		return tcoCode;
	}

	public void setTcoCode(String tcoCode) {
		this.tcoCode = tcoCode;
	}

	public List<TAvisAppelOffre> getListeAppelOffre() {
		return listeAppelOffre;
	}

	public void setListeAppelOffre(List<TAvisAppelOffre> listeAppelOffre) {
		this.listeAppelOffre = listeAppelOffre;
	}

	public TAvisAppelOffre getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(TAvisAppelOffre slctdTd) {
		this.slctdTd = slctdTd;
	}


	public VbTempParametreCom getMembre() {
		return membre;
	}

	public void setMembre(VbTempParametreCom membre) {
		this.membre = membre;
	}

	public void setNewOffre(VbTempParamDetOffres newOffre) {
		this.newOffre = newOffre;
	}


	public List<VDacMembre> getSelectionMembres() {
		return selectionMembres;
	}

	public void setSelectionMembres(List<VDacMembre> selectionMembres) {
		this.selectionMembres = selectionMembres;
	}

	public List<VDetCommissionSeance> getMembresCommite() {
		return membresCommite;
	}

	public void setMembresCommite(List<VDetCommissionSeance> membresCommite) {
		this.membresCommite = membresCommite;
	}


	public List<VDetCommissionSeance> getSelectionMembresCommite() {
		return selectionMembresCommite;
	}

	public void setSelectionMembresCommite(List<VDetCommissionSeance> selectionMembresCommite) {
		this.selectionMembresCommite = selectionMembresCommite;
	}

	public List<TLotAao> getListeLots() {
		return listeLots;
	}

	public void setListeLots(List<TLotAao> listeLots) {
		this.listeLots = listeLots;
	}

	public TLotAao getLot() {
		return lot;
	}

	public void setLot(TLotAao lot) {
		this.lot = lot;
	}


	public String getLaaId() {
		return laaId;
	}

	public void setLaaId(String laaId) {
		this.laaId = laaId;
	}
/*
	public List<VCandidatDac> getListCandidats() {
		return listCandidats;
	}

	public void setListCandidats(List<VCandidatDac> listCandidats) {
		this.listCandidats = listCandidats;
	}*/

	public String getFiltreNcc() {
		return filtreNcc;
	}

	public void setFiltreNcc(String filtreNcc) {
		this.filtreNcc = filtreNcc;
	}


	/*public VCandidatDac getCandidat() {
		return candidat;
	}

	public void setCandidat(VCandidatDac candidat) {
		this.candidat = candidat;
	}*/

	public VbCommissionSpecifique getNewcomSpecif() {
		return newcomSpecif;
	}

	public void setNewcomSpecif(VbCommissionSpecifique newcomSpecif) {
		this.newcomSpecif = newcomSpecif;
	}

	public TSoumissions getSoumission() {
		return soumission;
	}

	public void setSoumission(TSoumissions soumission) {
		this.soumission = soumission;
	}


	/*public List<TDetOffres> getListeOffres() {
		return listeOffres;
	}

	public void setListeOffres(List<TDetOffres> listeOffres) {
		this.listeOffres = listeOffres;
	}*/


	public List<VPiecesOffre> getListePiecesOffres() {
		return listePiecesOffres;
	}

	public void setListePiecesOffres(List<VPiecesOffre> listePiecesOffres) {
		this.listePiecesOffres = listePiecesOffres;
	}


	public long getMontLu() {
		return montLu;
	}

	public void setMontLu(long montLu) {
		this.montLu = montLu;
	}

	public long getMontN() {
		return montN;
	}

	public void setMontN(long montN) {
		this.montN = montN;
	}

	public long getMontRab() {
		return montRab;
	}

	public void setMontRab(long montRab) {
		this.montRab = montRab;
	}

	public long getPourcentRab() {
		return pourcentRab;
	}

	public void setPourcentRab(long pourcentRab) {
		this.pourcentRab = pourcentRab;
	}

/*	public List<TLotAao> getListeLotsByAvis() {
		return listeLotsByAvis;
	}

	public void setListeLotsByAvis(List<TLotAao> listeLotsByAvis) {
		this.listeLotsByAvis = listeLotsByAvis;
	}*/
	
	

	public boolean isInfoOffre() {
		return infoOffre;
	}


	public List<TLotAao> getListeLotsByAvis() {
		return listeLotsByAvis;
	}

	public void setListeLotsByAvis(List<TLotAao> listeLotsByAvis) {
		this.listeLotsByAvis = listeLotsByAvis;
	}

	public void setInfoOffre(boolean infoOffre) {
		this.infoOffre = infoOffre;
	}

	public List<TDetailVente> getListeVentes() {
		return listeVentes;
	}

	public void setListeVentes(List<TDetailVente> listeVentes) {
		this.listeVentes = listeVentes;
	}

	public TDetailVente getVente() {
		return vente;
	}

	public void setVente(TDetailVente vente) {
		this.vente = vente;
	}

	public String getNumVente() {
		return numVente;
	}

	public void setNumVente(String numVente) {
		this.numVente = numVente;
	}

	public Boolean getBoutonEdit() {
		return boutonEdit;
	}

	public void setBoutonEdit(Boolean boutonEdit) {
		this.boutonEdit = boutonEdit;
	}

	public long getNumSeance() {
		return numSeance;
	}

	public void setNumSeance(long numSeance) {
		this.numSeance = numSeance;
	}

	public List<VPiecesOffre> getListeSelectionPiecesOffres() {
		return listeSelectionPiecesOffres;
	}

	public void setListeSelectionPiecesOffres(List<VPiecesOffre> listeSelectionPiecesOffres) {
		this.listeSelectionPiecesOffres = listeSelectionPiecesOffres;
	}

	public TPiecesOffres getNewPieceOffre() {
		return newPieceOffre;
	}

	public void setNewPieceOffre(TPiecesOffres newPieceOffre) {
		this.newPieceOffre = newPieceOffre;
	}


	public List<VDetailOffres> getListeOffre() {
		return listeOffre;
	}

	public void setListeOffre(List<VDetailOffres> listeOffre) {
		this.listeOffre = listeOffre;
	}

	public VbTempParamDetOffres getNewOffre() {
		return newOffre;
	}

	public String getDofTyp() {
		return dofTyp;
	}

	public void setDofTyp(String dofTyp) {
		this.dofTyp = dofTyp;
	}

	public String getNcc() {
		return ncc;
	}

	public void setNcc(String ncc) {
		this.ncc = ncc;
	}

	public List<VbTempParamDetOffres> getListeOffreByLot() {
		return listeOffreByLot;
	}

	public void setListeOffreByLot(List<VbTempParamDetOffres> listeOffreByLot) {
		this.listeOffreByLot = listeOffreByLot;
	}

	/*
	public TDetOffres getSltOffre() {
		return sltOffre;
	}

	public void setSltOffre(TDetOffres sltOffre) {
		this.sltOffre = sltOffre;
	}

	public TDetOffres getDetailOffre() {
		return detailOffre;
	}

	public void setDetailOffre(TDetOffres detailOffre) {
		this.detailOffre = detailOffre;
	}*/

	public VLot getSltLot() {
		return sltLot;
	}

	public void setSltLot(VLot sltLot) {
		this.sltLot = sltLot;
	}

	public List<VPiecesOffreAnalyse> getListePiecesOffresAnalyse() {
		return listePiecesOffresAnalyse;
	}

	public void setListePiecesOffresAnalyse(List<VPiecesOffreAnalyse> listePiecesOffresAnalyse) {
		this.listePiecesOffresAnalyse = listePiecesOffresAnalyse;
	}

	public List<VPiecesOffreAnalyse> getListeSelectionPiecesOffresAnalyse() {
		return listeSelectionPiecesOffresAnalyse;
	}

	public void setListeSelectionPiecesOffresAnalyse(List<VPiecesOffreAnalyse> listeSelectionPiecesOffresAnalyse) {
		this.listeSelectionPiecesOffresAnalyse = listeSelectionPiecesOffresAnalyse;
	}

	public BigDecimal getDofNum() {
		return dofNum;
	}

	public void setDofNum(BigDecimal dofNum) {
		this.dofNum = dofNum;
	}

	public long getLaaNum() {
		return laaNum;
	}

	public void setLaaNum(long laaNum) {
		this.laaNum = laaNum;
	}

	public TSeances getNewSeance() {
		return newSeance;
	}

	public void setNewSeance(TSeances newSeance) {
		this.newSeance = newSeance;
	}

	public TDetCommissionSeance getNewDetailSeance() {
		return newDetailSeance;
	}

	public void setNewDetailSeance(TDetCommissionSeance newDetailSeance) {
		this.newDetailSeance = newDetailSeance;
	}

	public List<TDetOffres> getListeAttibutaire() {
		return listeAttibutaire;
	}

	public void setListeAttibutaire(List<TDetOffres> listeAttibutaire) {
		this.listeAttibutaire = listeAttibutaire;
	}

	public boolean isSaisie() {
		return saisie;
	}

	public void setSaisie(boolean saisie) {
		this.saisie = saisie;
	}

	public boolean isAffichage() {
		return affichage;
	}

	public void setAffichage(boolean affichage) {
		this.affichage = affichage;
	}

	public List<TDetOffres> getListeAffichageAttibutaire() {
		return listeAffichageAttibutaire;
	}

	public void setListeAffichageAttibutaire(List<TDetOffres> listeAffichageAttibutaire) {
		this.listeAffichageAttibutaire = listeAffichageAttibutaire;
	}

	public TCommissionSpecifique getNewcomSpec() {
		return newcomSpec;
	}

	public void setNewcomSpec(TCommissionSpecifique newcomSpec) {
		this.newcomSpec = newcomSpec;
	}

	public List<TSeances> getListeSeance() {
		return listeSeance;
	}

	public void setListeSeance(List<TSeances> listeSeance) {
		this.listeSeance = listeSeance;
	}

	public boolean isEtatMontVar() {
		return etatMontVar;
	}

	public void setEtatMontVar(boolean etatMontVar) {
		this.etatMontVar = etatMontVar;
	}

	public int getNbrLot() {
		return nbrLot;
	}

	public void setNbrLot(int nbrLot) {
		this.nbrLot = nbrLot;
	}

	public List<VDacMembre> getListeMembre() {
		return listeMembre;
	}

	public void setListeMembre(List<VDacMembre> listeMembre) {
		this.listeMembre = listeMembre;
	}

	public List<VCommissionTypeExp> getSelectionlisteExpert() {
		return selectionlisteExpert;
	}

	public void setSelectionlisteExpert(List<VCommissionTypeExp> selectionlisteExpert) {
		this.selectionlisteExpert = selectionlisteExpert;
	}

	public List<VCommissionTypeExp> getListeExpert() {
		return listeExpert;
	}

	public void setListeExpert(List<VCommissionTypeExp> listeExpert) {
		this.listeExpert = listeExpert;
	}

	public List<VDetCommissionSeance> getListeCommite() {
		return listeCommite;
	}

	public void setListeCommite(List<VDetCommissionSeance> listeCommite) {
		this.listeCommite = listeCommite;
	}

	public VDetCommissionSeance getSltMbr() {
		return sltMbr;
	}

	public void setSltMbr(VDetCommissionSeance sltMbr) {
		this.sltMbr = sltMbr;
	}

	public List<TDetCommissionSeance> getListMbrSup() {
		return listMbrSup;
	}

	public void setListMbrSup(List<TDetCommissionSeance> listMbrSup) {
		this.listMbrSup = listMbrSup;
	}

	public TDetCommissionSeance getMbrSup() {
		return mbrSup;
	}

	public void setMbrSup(TDetCommissionSeance mbrSup) {
		this.mbrSup = mbrSup;
	}

	public String getFiltreCandidat() {
		return filtreCandidat;
	}

	public void setFiltreCandidat(String filtreCandidat) {
		this.filtreCandidat = filtreCandidat;
	}

	public VbAnalyseOffre getNewAnalyseOffre() {
		return newAnalyseOffre;
	}

	public void setNewAnalyseOffre(VbAnalyseOffre newAnalyseOffre) {
		this.newAnalyseOffre = newAnalyseOffre;
	}

	public List<VCritereAnalyseDacOff> getListeCritereAnalyse() {
		return listeCritereAnalyse;
	}


	public void setListeCritereAnalyse(List<VCritereAnalyseDacOff> listeCritereAnalyse) {
		this.listeCritereAnalyse = listeCritereAnalyse;
	}


	public List<VCritereAnalyseDacOff> getSelectionCritereAnalyse() {
		return selectionCritereAnalyse;
	}


	public void setSelectionCritereAnalyse(List<VCritereAnalyseDacOff> selectionCritereAnalyse) {
		this.selectionCritereAnalyse = selectionCritereAnalyse;
	}


	public long getValRegQual() {
		return valRegQual;
	}

	public void setValRegQual(long valRegQual) {
		this.valRegQual = valRegQual;
	}

	public String getAaoRegQual() {
		return aaoRegQual;
	}

	public void setAaoRegQual(String aaoRegQual) {
		this.aaoRegQual = aaoRegQual;
	}

	public boolean isConformite() {
		return conformite;
	}

	public void setConformite(boolean conformite) {
		this.conformite = conformite;
	}

	public Boolean getMontant() {
		return montant;
	}

	public void setMontant(Boolean montant) {
		this.montant = montant;
	}

/*	public List<VVerifOffin> getListeVerifCor() {
		return listeVerifCor;
	}

	public void setListeVerifCor(List<VVerifOffin> listeVerifCor) {
		this.listeVerifCor = listeVerifCor;
	}*/
	
	
	public VCritereAnalyseDacOff getSltCritere() {
		return sltCritere;
	}


	public void setSltCritere(VCritereAnalyseDacOff sltCritere) {
		this.sltCritere = sltCritere;
	}


	public List<VVerifcorOffin> getListeVerifCor() {
		return listeVerifCor;
	}

	public void setListeVerifCor(List<VVerifcorOffin> listeVerifCor) {
		this.listeVerifCor = listeVerifCor;
	}
	

	public List<VListeSouOffBasse> getListeSouOffBass() {
		return listeSouOffBass;
	}

	public void setListeSouOffBass(List<VListeSouOffBasse> listeSouOffBass) {
		this.listeSouOffBass = listeSouOffBass;
	}

	public List<VListeSouOffEleve> getListeSouOffEleve() {
		return listeSouOffEleve;
	}

	public void setListeSouOffEleve(List<VListeSouOffEleve> listeSouOffEleve) {
		this.listeSouOffEleve = listeSouOffEleve;
	}

	public TLotAao getRecupLot() {
		return recupLot;
	}

	public void setRecupLot(TLotAao recupLot) {
		this.recupLot = recupLot;
	}

	public List<VResultEvalClassLot> getResultatAttributaire() {
		return resultatAttributaire;
	}

	public void setResultatAttributaire(List<VResultEvalClassLot> resultatAttributaire) {
		this.resultatAttributaire = resultatAttributaire;
	}

	public List<VResultPropAttribLot> getResultatPropAttributaire() {
		return resultatPropAttributaire;
	}

	public void setResultatPropAttributaire(List<VResultPropAttribLot> resultatPropAttributaire) {
		this.resultatPropAttributaire = resultatPropAttributaire;
	}

	public List<VRecapSeuilAnormal> getListeRecapSeuil() {
		return listeRecapSeuil;
	}

	public void setListeRecapSeuil(List<VRecapSeuilAnormal> listeRecapSeuil) {
		this.listeRecapSeuil = listeRecapSeuil;
	}

	public VRecapSeuilAnormal getInfoSeuil() {
		return infoSeuil;
	}

	public void setInfoSeuil(VRecapSeuilAnormal infoSeuil) {
		this.infoSeuil = infoSeuil;
	}


	public VListeSouOffBasse getSltRecharge() {
		return sltRecharge;
	}


	public void setSltRecharge(VListeSouOffBasse sltRecharge) {
		this.sltRecharge = sltRecharge;
	}


	public long getVerifCorNum() {
		return verifCorNum;
	}


	public void setVerifCorNum(long verifCorNum) {
		this.verifCorNum = verifCorNum;
	}


	public long getLotId() {
		return lotId;
	}


	public void setLotId(long lotId) {
		this.lotId = lotId;
	}


	public VVerifcorOffin getInfoLot() {
		return infoLot;
	}


	public void setInfoLot(VVerifcorOffin infoLot) {
		this.infoLot = infoLot;
	}


	public List<VRepSoumissionnaire> getRecupSoumissionnaire() {
		return recupSoumissionnaire;
	}


	public void setRecupSoumissionnaire(List<VRepSoumissionnaire> recupSoumissionnaire) {
		this.recupSoumissionnaire = recupSoumissionnaire;
	}


	public VRepSoumissionnaire getRecupNcc() {
		return recupNcc;
	}


	public void setRecupNcc(VRepSoumissionnaire recupNcc) {
		this.recupNcc = recupNcc;
	}


	public TDetCommissionSeance getDetCom() {
		return detCom;
	}


	public void setDetCom(TDetCommissionSeance detCom) {
		this.detCom = detCom;
	}


	public VDetCommissionSeance getNewMembre() {
		return newMembre;
	}

	public void setNewMembre(VDetCommissionSeance newMembre) {
		this.newMembre = newMembre;
	}


	public List<TDetCommissionSeance> getListeDetCom() {
		return listeDetCom;
	}

	public void setListeDetCom(List<TDetCommissionSeance> listeDetCom) {
		this.listeDetCom = listeDetCom;
	}


	public List<TDossierMbr> getDossListe() {
		return dossListe;
	}


	public void setDossListe(List<TDossierMbr> dossListe) {
		this.dossListe = dossListe;
	}


	public TDossierMbr getSelectedDossier() {
		return selectedDossier;
	}


	public void setSelectedDossier(TDossierMbr selectedDossier) {
		this.selectedDossier = selectedDossier;
	}


	public String getNatdoc() {
		return natdoc;
	}


	public void setNatdoc(String natdoc) {
		this.natdoc = natdoc;
	}


	public List<VDetOffreRecevable> getListeOffres() {
		return listeOffres;
	}


	public void setListeOffres(List<VDetOffreRecevable> listeOffres) {
		this.listeOffres = listeOffres;
	}


	public VDetOffreRecevable getDetailOffre() {
		return detailOffre;
	}


	public void setDetailOffre(VDetOffreRecevable detailOffre) {
		this.detailOffre = detailOffre;
	}


	public VDetOffreRecevable getSltOffre() {
		return sltOffre;
	}

	public void setSltOffre(VDetOffreRecevable sltOffre) {
		this.sltOffre = sltOffre;
	}


	public TDetOffres getOffre() {
		return offre;
	}


	public void setOffre(TDetOffres offre) {
		this.offre = offre;
	}


	public List<VLotCandidat> getLotByCandidat() {
		return lotByCandidat;
	}


	public void setLotByCandidat(List<VLotCandidat> lotByCandidat) {
		this.lotByCandidat = lotByCandidat;
	}


	public List<TDetOffres> getOffreListe() {
		return offreListe;
	}


	public void setOffreListe(List<TDetOffres> offreListe) {
		this.offreListe = offreListe;
	}


	public VLotCandidat getTlot() {
		return tlot;
	}


	public void setTlot(VLotCandidat tlot) {
		this.tlot = tlot;
	}


	public VLotCandidat getSelectLot() {
		return selectLot;
	}


	public void setSelectLot(VLotCandidat selectLot) {
		this.selectLot = selectLot;
	}


	public String getFiltreLot() {
		return filtreLot;
	}


	public void setFiltreLot(String filtreLot) {
		this.filtreLot = filtreLot;
	}


	public List<VOffreCandidat> getListCandidats() {
		return listCandidats;
	}


	public void setListCandidats(List<VOffreCandidat> listCandidats) {
		this.listCandidats = listCandidats;
	}


	public VOffreCandidat getCandidat() {
		return candidat;
	}

	public void setCandidat(VOffreCandidat candidat) {
		this.candidat = candidat;
	}


	public List<VDofTyp> getListdoftyp() {
		return listdoftyp;
	}


	public void setListdoftyp(List<VDofTyp> listdoftyp) {
		this.listdoftyp = listdoftyp;
	}


	public List<TAvisAppelOffre> getListeAvis() {
		return listeAvis;
	}


	public void setListeAvis(List<TAvisAppelOffre> listeAvis) {
		this.listeAvis = listeAvis;
	}


	public TAvisAppelOffre getSltAvis() {
		return sltAvis;
	}


	public void setSltAvis(TAvisAppelOffre sltAvis) {
		this.sltAvis = sltAvis;
	}


	public String getNbreOffre() {
		return nbreOffre;
	}


	public void setNbreOffre(String nbreOffre) {
		this.nbreOffre = nbreOffre;
	}


	public List<TBanques> getListBanque() {
		return listBanque;
	}


	public void setListBanque(List<TBanques> listBanque) {
		this.listBanque = listBanque;
	}


	public String getBanCode() {
		return banCode;
	}


	public void setBanCode(String banCode) {
		this.banCode = banCode;
	}


/*	public List<VAvisAppelOffre> getListeAppelOffre() {
		return listeAppelOffre;
	}

	public void setListeAppelOffre(List<VAvisAppelOffre> listeAppelOffre) {
		this.listeAppelOffre = listeAppelOffre;
	}*/
	
}
