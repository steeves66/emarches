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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAffichageAgpm;
import com.sndi.model.TAgpm;
import com.sndi.model.TAssignation;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TCandidats;
import com.sndi.model.TCommissionSpecifique;
import com.sndi.model.TCommissionType;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDemande;
import com.sndi.model.TDetCommissionSeance;
import com.sndi.model.TDetOffres;
import com.sndi.model.TDetailVente;
import com.sndi.model.TFinancementPgpm;
import com.sndi.model.TFonction;
import com.sndi.model.TLotAao;
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
import com.sndi.model.VCandidatDac;
import com.sndi.model.VCommissionTypeExp;
import com.sndi.model.VCompoCommission;
import com.sndi.model.VCritereAnalyseDac;
import com.sndi.model.VDacMembre;
import com.sndi.model.VDetCommissionSeance;
import com.sndi.model.VDetailOffres;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VListePieceOffre;
import com.sndi.model.VListeSouOffBasse;
import com.sndi.model.VListeSouOffEleve;
import com.sndi.model.VLot;
import com.sndi.model.VPiecesOffre;
import com.sndi.model.VPiecesOffreAnalyse;
import com.sndi.model.VRecapSeuilAnormal;
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
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
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

	 
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
		//chargeCandidats();
		//chargeLotByAvis();	
		//chargeOffres();
		//chargeOffre();
		
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
	 private List<TAvisAppelOffre> listeAppelOffre = new ArrayList<TAvisAppelOffre>();
	 private List<TLotAao> listeLots = new ArrayList<TLotAao>();
	 private List<TLotAao> listeLotsByAvis = new ArrayList<TLotAao>();
	 //private List<VLot> listeLotsByAvis = new ArrayList<VLot>();
	 private List<VCandidatDac> listCandidats = new ArrayList<VCandidatDac>();
	 private List<TDetOffres> listeOffres = new ArrayList<TDetOffres>(); 
	 private List<VPiecesOffre> listePiecesOffres = new ArrayList<VPiecesOffre>(); 
	 private List<VPiecesOffreAnalyse> listePiecesOffresAnalyse = new ArrayList<VPiecesOffreAnalyse>();
	 private List<VPiecesOffreAnalyse> listeSelectionPiecesOffresAnalyse= new ArrayList<VPiecesOffreAnalyse>();
	 private List<VDetailOffres> listeOffre = new ArrayList<VDetailOffres>();
	 private List<TDetailVente> listeVentes = new ArrayList<TDetailVente>();
	 private List<VPiecesOffre> listeSelectionPiecesOffres= new ArrayList<VPiecesOffre>();
	 private List<VbTempParamDetOffres> listeOffreByLot = new ArrayList<VbTempParamDetOffres>();
	 private List<TDetOffres> listeAttibutaire = new ArrayList<TDetOffres>(); 
	 private List<TDetOffres> listeAffichageAttibutaire = new ArrayList<TDetOffres>(); 
	 private List<TSeances> listeSeance = new ArrayList<TSeances>(); 
	 private List<VCritereAnalyseDac> listeCritereAnalyse = new ArrayList<VCritereAnalyseDac>(); 
	 private List<VCritereAnalyseDac> selectionCritereAnalyse = new ArrayList<VCritereAnalyseDac>();
	private VCandidatDac candidat =new VCandidatDac();
	private VCritereAnalyseDac sltCritere =new VCritereAnalyseDac();
	
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
	
	 
	 
	 
	 //Declaration des objets
	 private TCommissionSpecifique newcomSpec = new TCommissionSpecifique();
	 private TDetCommissionSeance mbrSup = new TDetCommissionSeance();
	 private VbCommissionSpecifique newcomSpecif = new VbCommissionSpecifique();
	 private TCommissionType newCom = new TCommissionType();
	 private TAvisAppelOffre slctdTd = new TAvisAppelOffre();
	 private VbTempParametreCom membre = new VbTempParametreCom();
	 //private TCandidats candidat = new TCandidats(); 
	 private VbTempParamDetOffres newOffre = new VbTempParamDetOffres();
	 private TDetOffres detailOffre = new TDetOffres();
	 private TDetOffres sltOffre = new TDetOffres();
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
	 private String filtreNcc="";
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
			  verifCorNum = recupLot.getLaaId();
		  }
		 
		 listeSouOffBass = ((List<VListeSouOffBasse>)iservice.getObjectsByColumn("VListeSouOffBasse",new ArrayList<String>(Arrays.asList("RId")),
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+lotId)));
	 }
	//
		 public void offreResulatatAttrib() {
			 resultatAttributaire = ((List<VResultEvalClassLot>)iservice.getObjectsByColumn("VResultEvalClassLot",new ArrayList<String>(Arrays.asList("RANG")),
					 new WhereClause("LAA_NUM",Comparateur.EQ,""+recupLot.getLaaNum()),
					 new WhereClause("LAA_DAC_CODE",Comparateur.EQ,""+recupLot.getTDacSpecs().getDacCode())));
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
		 
		 public void saveRepechage() {
			 listeOffres = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					 new WhereClause("DOF_NUM",Comparateur.EQ,""+sltRecharge.getDofNum())));
					  if (!listeOffres.isEmpty()) {
						  detailOffre=listeOffres.get(0); 
						  
						  detailOffre.setDofRepeche(sltRecharge.getDofRepeche());
						  detailOffre.setDofObsAnormal(sltRecharge.getCommentaireAnormal());
						  iservice.updateObject(detailOffre);
						  
						  offreBasse();
						  
						  userController.setTexteMsg("Modification effectuée avec succès!");
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
	 
	 public void deleteMembre() {		 
		 listMbrSup = ((List<TDetCommissionSeance>)iservice.getObjectsByColumn("TDetCommissionSeance",new ArrayList<String>(Arrays.asList("DCS_NUM")),
				 new WhereClause("DCS_NUM",Comparateur.EQ,""+sltMbr.getDcsNum())));
		       if (!listMbrSup.isEmpty()) {
		    	   mbrSup=listMbrSup.get(0); 
    			}
		       iservice.deleteObject(getMbrSup());
		  chargeMembre();
		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Membre supprimé avec succès! ", ""));	
		}
	 
	 //liste des pièces de l'offres
	 
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
				 new WhereClause("DOF_LAA_ID",Comparateur.EQ,""+sltOffre.getTLotAao().getLaaId())));
	 }
	 
	 public void chargeCritereAnalyse() {
		 listeCritereAnalyse.clear();
		 listeCritereAnalyse = ((List<VCritereAnalyseDac>)iservice.getObjectsByColumn("VCritereAnalyseDac"));
	 }
	 
	 
	 
	//Liste des piecs de l'offre a l'analyse
		 public void chargePiecesAnalyse() {
			 listePiecesOffresAnalyse = ((List<VPiecesOffreAnalyse>)iservice.getObjectsByColumn("VPiecesOffreAnalyse",new ArrayList<String>(Arrays.asList("TPO_LIBELLE")),
					// new WhereClause("POF_LAA_ID",Comparateur.EQ,""+sltOffre.getDofLaaId())));
					 //new WhereClause("ODP_TPO_ETAP_PIECE",Comparateur.EQ,"Ouverture"),
					 new WhereClause("POF_DOF_NUM",Comparateur.EQ,""+sltOffre.getDofNum())));
			 nbrLot =nonbreLot();
			 chargeCritereAnalyse();
			 chargeMention();
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
			 listeOffre = ((List<VDetailOffres>)iservice.getObjectsByColumn("VDetailOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					 new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode())
					 ));
				_logger.info("listeOffres size: "+listeOffre.size());	
			 
		 }
		 
		//Liste des offres TdetaiOffre
		 public void chargeOffre() {
			 listeOffres.clear();
			 listeOffres = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM"))//,
					// new WhereClause("DOF_LAA_ID",WhereClause.Comparateur.EQ,""+lot.getLaaId())
					 ));
				_logger.info("listeOffres size: "+listeOffres.size());	
			 
		 }
		 
		//Filte 
		 public void chargeOffreFilterOffre() {
			 listeOffres.clear();
			 listeOffres = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					// new WhereClause("DOF_LAA_ID",WhereClause.Comparateur.EQ,""+lot.getLaaId())
				     new WhereClause("DOF_NUM",WhereClause.Comparateur.LIKE,"%"+dofNum+"%")  
					 ));
				_logger.info("listeOffres size: "+listeOffres.size());	
			 
		 }
		 
		 
		
		 
		 
		//Liste des lot d'un avis d'avis d'appel d'offre
		 public void chargeLots() {
			 //listeLots.clear();
			 listeLots = ((List<TLotAao>)iservice.getObjectsByColumn("TLotAao",new ArrayList<String>(Arrays.asList("LAA_ID")),
					    new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode())
					    ));
					_logger.info("listeLots size: "+listeLots.size());	
		 }
		 
		//Liste des lot d'un avis d'avis d'appel d'offre
		 public void chargeLotByAvis() {
			 listeLots.clear();
			listeLotsByAvis=(List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_ID")),
					new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
			_logger.info("listeLotsByAvis size: "+listeLotsByAvis.size());
		 }
		 
		//filtre lot
		 public void chargeLotFilterLot() {
			 listeLots.clear();
			listeLotsByAvis=(List<TLotAao>) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("LAA_ID")),
					new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()),
					new WhereClause("LAA_NUM",WhereClause.Comparateur.LIKE,"%"+laaNum+"%")); 
			_logger.info("listeLotsByAvis size: "+listeLotsByAvis.size());
		 }
		//Liste des offres d'un lot
		 public void onSelectLot() {
			 listeAttibutaire.clear();
			 listeOffres.clear();
			 listeOffres = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
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
			 listeOffres = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
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
			 listeCritereAnalyse = (List<VCritereAnalyseDac>) iservice.getObjectsByColumn("VCritereAnalyseDac", new ArrayList<String>(Arrays.asList("CRA_CODE")),
                     // new WhereClause("DAC_TD_CODE",WhereClause.Comparateur.EQ,"DAO"),
                      new WhereClause("DCAD_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode()));
                      if (!listeCritereAnalyse.isEmpty()) {
                             sltCritere= listeCritereAnalyse.get(0);
                             _logger.info("valeur: "+sltCritere.getAaoRegQual());
                             
                         	if(sltCritere.getAaoRegQual().equalsIgnoreCase("CONFORMITE")) {
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
		
		
	
		
		 //Edition de fiche membres
		 public void imprimerFicheMbr() {
			   projetReport.longparam1(newSeance.getSeaNum(), "membres_cojo", "membres_cojo");    
			}
		 
		 //Love condidat
		 
		 
		 //private TFonction recupFonction= new TFonction();
		/* public void onSelectCandidat() {
				
			 
			 recupFonction = new TFonction();
			 recupFonction.setFonCod(fonction.getFonCod());
			 recupFonction.setFonLibelle(fonction.getFonLibelle());
			 chargePgpmCpmpDmp();
			 chargeImputationCpmpDmp();
				}*/
		 //Afficher la liste des candidats dans v_candidat_da(love)
		 public void chargeCandidats() {
			 listCandidats.clear();
			 listCandidats = ((List<VCandidatDac>)iservice.getObjectsByColumn("VCandidatDac",new ArrayList<String>(Arrays.asList("CAN_SOU_SIGLE_STE")),
					 new WhereClause("DVE_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode())));
			 _logger.info("Nbr candidat: "+listCandidats.size());
		 }
		 

		 public void chargeFilterCandidats(){
			 listCandidats.clear();
			 listCandidats = ((List<VCandidatDac>)iservice.getObjectsByColumn("VCandidatDac",new ArrayList<String>(Arrays.asList("CAN_SOU_SIGLE_STE")),
					 new WhereClause("CAN_SOU_NCC",WhereClause.Comparateur.LIKE,"%"+filtreCandidat+"%"),
					 new WhereClause("DVE_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode())));
			}
			
		 
			//Filtre les marchés en fonction du code Marché
			/* public void filtrenNccCandidat() {
				 listCandidats.clear();
				 listCandidats = ((List<TCandidats>)iservice.getObjectsByColumn("TCandidats",new ArrayList<String>(Arrays.asList("CAN_NOM")),
						 new WhereClause("CAN_TIE_NCC",WhereClause.Comparateur.LIKE,"%"+filtreNcc+"%")));
					_logger.info("listCandidats size: "+listCandidats.size());	
				 
			 }
		 */
		//Love pour recuperer les candidats
		 public void onSelectCandidat() {
			 newOffre= new VbTempParamDetOffres();
			 newOffre.setDofSigle(candidat.getCanSouSigleSte());
			 newOffre.setDofSouNcc(candidat.getCanSouNcc());
				}
		
		
		//Ouverture des offres
		public void saveOuverture() {
			
				
				//enregister dans T_analyse_offre
				/*if (selectionCritereAnalyse.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
				}
		 		else{*/
		 			   newOffre.setDofLaaAaoCode(slctdTd.getAaoCode());
					   newOffre.setDofLaaId(laaId);
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
		 			
		 			
			 		for(VCritereAnalyseDac ligne : selectionCritereAnalyse) {
			 			newAnalyseOffre.setAnfDacCode(ligne.getDcadDacCode());
			 			//newAnalyseOffre.setAnfDanCode(ligne.getDcadDanCode());
			 			//newAnalyseOffre.setAnfDteModif(ligne.get);
			 			newAnalyseOffre.setAnfDteSaisi(Calendar.getInstance().getTime());
			 			//newAnalyseOffre.setAnfDcadNum(ligne.getDcadNum());
			 			//newAnalyseOffre.setAnfLaaId("1");
			 			newAnalyseOffre.setAnfObser(sltOffre.getDofObsCom());
			 			newAnalyseOffre.setAnfOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
			 			//newAnalyseOffre.setAnfValeur("0");
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
						 			//newPieceOffre.setTDetOffres(newOffre.getDofNum());
						 			newPieceOffre.setTLotAao(laaId);
						 			iservice.addObject(newPieceOffre);
							     }	
					 }
				     
				    	vider();
				    	chargeOffres();		    	
				    	userController.setTexteMsg("Ouverture effectuée avec succès !");
						userController.setRenderMsg(true);
						userController.setSevrityMsg("success");
		    }	
		//}
		
		
		
		
		public int nonbreLot(){
			int i = iservice.countTableByColumn("T_DET_OFFRES", "DOF_NUM",
					new WhereClause("DOF_LAA_ID", WhereClause.Comparateur.EQ,""+sltOffre.getTLotAao().getLaaId()));
			return	i;	
		}
		
		
		
		
		public void chargeListe(String statut) {
			 listeAppelOffre.clear();
			 listeAppelOffre = (List<TAvisAppelOffre>) iservice.getObjectsByColumnDesc("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
			 new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,""+statut),
			 new WhereClause("AAO_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("listeAppelOffre size: "+listeAppelOffre.size());
		}
		
		//Fin Ouverture
		public void finOuverture() {
			String statUpdate = "";
			String message = "";
			if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("APU")) {
				statUpdate = "OUV";
				message="Fin de l'ouverture des Offres de l'avis d'Appel d'offre N°"+slctdTd.getAaoCode();
				chargeListe("OUV");
				
			 }else {
				 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("OUV")) {
						statUpdate = "ANA";
						chargeListe("ANA");
						message="Fin de l'analyse des Offres de l'avis d'Appel d'offre N°"+slctdTd.getAaoCode();
				 }else {
					 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("ANA")) {
						 statUpdate = "JUG";
						 chargeListe("JUG");
						 message="Fin du jugement des Offres de l'avis d'Appel d'offre N°"+slctdTd.getAaoCode();
					 }else {
						 
					 }	 
				 }
 
			 }
			
			slctdTd.setTStatut(new TStatut(statUpdate));	
			iservice.updateObject(slctdTd);
			userController.setTexteMsg(message);
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
			  
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
				sltOffre.setDofStaut("1");
				iservice.updateObject(sltOffre);
				
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
			 			iservice.updateObject(updatePieceOffre);
				     }	
			 		}
		         }
				
				//EVALUTATION
				if (selectionCritereAnalyse.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun critère selectionné", ""));
				}
		 		else{
			 		for(VCritereAnalyseDac ligne : selectionCritereAnalyse) {
			 			newAnalyseOffre.setAnfDacCode(ligne.getDcadDacCode());
			 			newAnalyseOffre.setAnfDcadNum(ligne.getDcadNum());
			 			newAnalyseOffre.setAnfDanCode(ligne.getCraCode());
			 			//newAnalyseOffre.set
			 			newAnalyseOffre.setAnfDofNum(sltOffre.getDofNum());
			 			newAnalyseOffre.setAnfDteModif(Calendar.getInstance().getTime());
			 			newAnalyseOffre.setAnfDteSaisi(Calendar.getInstance().getTime());
			 			newAnalyseOffre.setAnfLaaId(sltOffre.getTLotAao().getLaaId());
			 			newAnalyseOffre.setAnfValeurConf(ligne.getAaoRegQual());
			 			newAnalyseOffre.setAnfValeurScore(ligne.getValRegQual());
			 			newAnalyseOffre.setAnfCommentaire(ligne.getDcadCommentaire());
			 			newAnalyseOffre.setAnfOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
			 			//newAnalyseOffre.set
			 			iservice.addObject(newAnalyseOffre);
			 		}
		         }
				
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
			sltOffre.setDofRet("O");
			sltOffre.setDofStaut("2");
			iservice.updateObject(sltOffre);
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
		 
		 public void vider() {
			 newOffre = new VbTempParamDetOffres();
			 infoLot =new VVerifcorOffin();
			 listeSelectionPiecesOffresAnalyse= new ArrayList<VPiecesOffreAnalyse>();
			 listeSelectionPiecesOffresAnalyse.clear();
			 listeSelectionPiecesOffres= new ArrayList<VPiecesOffre>();
			 listeSelectionPiecesOffres.clear();
			 listeSouOffBass.clear();
			 listeSouOffEleve.clear();
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
					 new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,""+statutAffiche));
					_logger.info("listeAppelOffre size: "+listeAppelOffre.size());		
					
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
					chargeLots();
					chargeOffres();
					chargePieces();
					chargeCandidats();
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

	public List<VCandidatDac> getListCandidats() {
		return listCandidats;
	}

	public void setListCandidats(List<VCandidatDac> listCandidats) {
		this.listCandidats = listCandidats;
	}

	public String getFiltreNcc() {
		return filtreNcc;
	}

	public void setFiltreNcc(String filtreNcc) {
		this.filtreNcc = filtreNcc;
	}


	public VCandidatDac getCandidat() {
		return candidat;
	}

	public void setCandidat(VCandidatDac candidat) {
		this.candidat = candidat;
	}

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


	public List<TDetOffres> getListeOffres() {
		return listeOffres;
	}

	public void setListeOffres(List<TDetOffres> listeOffres) {
		this.listeOffres = listeOffres;
	}


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
	}

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

	public List<VCritereAnalyseDac> getListeCritereAnalyse() {
		return listeCritereAnalyse;
	}

	public void setListeCritereAnalyse(List<VCritereAnalyseDac> listeCritereAnalyse) {
		this.listeCritereAnalyse = listeCritereAnalyse;
	}

	public List<VCritereAnalyseDac> getSelectionCritereAnalyse() {
		return selectionCritereAnalyse;
	}

	public void setSelectionCritereAnalyse(List<VCritereAnalyseDac> selectionCritereAnalyse) {
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

	public VCritereAnalyseDac getSltCritere() {
		return sltCritere;
	}

	public void setSltCritere(VCritereAnalyseDac sltCritere) {
		this.sltCritere = sltCritere;
	}


/*	public List<VVerifOffin> getListeVerifCor() {
		return listeVerifCor;
	}

	public void setListeVerifCor(List<VVerifOffin> listeVerifCor) {
		this.listeVerifCor = listeVerifCor;
	}*/
	
	
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

	
	
}
