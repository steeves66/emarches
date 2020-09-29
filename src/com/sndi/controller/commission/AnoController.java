package com.sndi.controller.commission;

import java.io.IOException;
import java.math.BigDecimal;
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
import com.sndi.model.TAgpm;
import com.sndi.model.TAnalyseOffre;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TBanques;
import com.sndi.model.TCandidats;
import com.sndi.model.TCommissionSpecifique;
import com.sndi.model.TCommissionType;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDemande;
import com.sndi.model.TDetCommissionSeance;
import com.sndi.model.TDetCritAnalyseDac;
import com.sndi.model.TDetOffres;
import com.sndi.model.TDetailDemandes;
import com.sndi.model.TDetailPlanGeneral;
import com.sndi.model.TDetailVente;
import com.sndi.model.TDossierAao;
import com.sndi.model.TDossierDacs;
import com.sndi.model.TDossierDemande;
import com.sndi.model.TDossierMbr;
import com.sndi.model.TDossierPlanGeneral;
import com.sndi.model.TFinancementPgpm;
import com.sndi.model.TFonction;
import com.sndi.model.THistoAgpm;
import com.sndi.model.THistoPlanGeneral;
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
import com.sndi.model.TTypeDemande;
import com.sndi.model.TTypeMarche;
import com.sndi.model.TTypePieceOffre;
import com.sndi.model.TTypeSeance;
import com.sndi.model.TVenteDac;
import com.sndi.model.VAgpmliste;
import com.sndi.model.VAvisAppelOffre;
import com.sndi.model.VAvisAppelOffreAno;
import com.sndi.model.VAvisAppelOffreAnodmp;
import com.sndi.model.VCandidatDac;
import com.sndi.model.VCommissionTypeExp;
import com.sndi.model.VCompoCommission;
import com.sndi.model.VCritereAnalyseDac;
import com.sndi.model.VCritereAnalyseDacOff;
import com.sndi.model.VCritereAnalyseDacOfftec;
import com.sndi.model.VDacMembre;
import com.sndi.model.VDetCommissionSeance;
import com.sndi.model.VDetOffreAnalyse;
import com.sndi.model.VDetOffreNonRecevable;
import com.sndi.model.VDetOffreRecevable;
import com.sndi.model.VDetailOffres;
import com.sndi.model.VDofTyp;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VHistoDemandeAno;
import com.sndi.model.VListePieceOffre;
import com.sndi.model.VListeSouOffBasse;
import com.sndi.model.VListeSouOffEleve;
import com.sndi.model.VLot;
import com.sndi.model.VLotAnalyse;
import com.sndi.model.VLotAnalyseFin;
import com.sndi.model.VLotAvisdmp;
import com.sndi.model.VLotAnalyse;
import com.sndi.model.VLotCandidat;
import com.sndi.model.VLotJugement;
import com.sndi.model.VNatureDocAno;
import com.sndi.model.VOffreCandidat;
import com.sndi.model.VOffreNonRecevableLot;
import com.sndi.model.VOffreRecevableLot;
import com.sndi.model.VPiecesOffre;
import com.sndi.model.VPiecesOffreAnalyse;
import com.sndi.model.VRecapSeuilAnormal;
import com.sndi.model.VReeditCojo;
import com.sndi.model.VRepSoumissionnaire;
import com.sndi.model.VResultEvalClassLot;
import com.sndi.model.VResultPropAttribLot;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.model.VUpdatePgpm;
import com.sndi.model.VVerifOffin;
import com.sndi.model.VbAnalyseOffre;
import com.sndi.model.VbCommissionSpecifique;
import com.sndi.model.VbCommissionType;
import com.sndi.model.VbDetCritAnalyseDac;
import com.sndi.model.VbDetOffresSaisi;
import com.sndi.model.VbTempParamAnalyseOff;
import com.sndi.model.VbTempParamAtrib;
import com.sndi.model.VbTempParamAvis;
import com.sndi.model.VbTempParamDetOffres;
import com.sndi.model.VbTempParametreCom;
import com.sndi.model.VbTempParametreFactAn;
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
public class AnoController {
	Logger _logger = Logger.getLogger(AnoController.class);
	
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
	 private long laaNum;
	 private String docNature ="";
	 private long demNum;
	 private String docNatureDem ="";
	 private String docNatureDemDmp ="";
	 
	 
	 //liste
	 private List<VAvisAppelOffreAno> listeAvisAppelOffre = new ArrayList<VAvisAppelOffreAno>();
	 private List<VAvisAppelOffreAnodmp> listeDemande = new ArrayList<VAvisAppelOffreAnodmp>();
	 //private List<VNatureDocAno> natureDocListe = new ArrayList<VNatureDocAno>();
	 private List<TNatureDocuments> natureDocListe = new ArrayList<TNatureDocuments>();
	 private List<VLotAvisdmp> listeLots = new ArrayList<VLotAvisdmp>();
	 private List<VHistoDemandeAno> listeHistoDemandeAno = new ArrayList<VHistoDemandeAno>();
	 private List<TAvisAppelOffre> listeAvis = new ArrayList<TAvisAppelOffre>();
	 private List<TDossierAao> dossListe = new ArrayList<TDossierAao>();
	 private List<TDossierDemande> dossListeDemande = new ArrayList<TDossierDemande>();
	 private List<TDossierDemande> dossListeDemandeDmp = new ArrayList<TDossierDemande>();
	 private List<TDossierDemande> dossListeDemandeAc = new ArrayList<TDossierDemande>();
	 //private List<TDemande> listeDemande = new ArrayList<TDemande>();
	 
	 //Objet
	 private VAvisAppelOffreAno slctdTd = new VAvisAppelOffreAno();
	 private VAvisAppelOffreAnodmp slctdTdDem = new VAvisAppelOffreAnodmp();
	 private VbTempParamAvis newTempAvis = new VbTempParamAvis();
	 private TDemande newDem = new TDemande();
	 private VLotAvisdmp infolot = new VLotAvisdmp();

	 private TDemande demande = new TDemande();
	 private TAvisAppelOffre newAvis = new TAvisAppelOffre();
	 private VLotAvisdmp sltLot = new VLotAvisdmp();
	 private TDossierAao selectedDossier = new TDossierAao();
	 private TDossierDemande selectedDossierDem = new TDossierDemande();
	 private VHistoDemandeAno sltHistoDem = new VHistoDemandeAno();
	 private boolean btn_Oui;
	 private boolean btn_non;
	 private boolean resultat;
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
		//chargeData();
	 }		
	
	 
	 public void saveDemande() {
		 newDem.setDemAaoCode(slctdTd.getAaoCode());
		 iservice.addObject(newDem);
		 
	 }
	 
	 public void chargeDemandeDmp() {
		 listeDemande = (List<VAvisAppelOffreAnodmp>) iservice.getObjectsByColumn("VAvisAppelOffreAnodmp");
		_logger.info("listeDemande size: "+listeDemande.size()
		);	
	 }
	 public void envoiDemande() throws IOException {
		 newTempAvis.setAaoDacCode(slctdTd.getAaoDacCode());
		 newTempAvis.setAaoStatut(slctdTd.getAaoStatut());
		 newTempAvis.setTempDteSaisi(Calendar.getInstance().getTime());
		 newTempAvis.setTempOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
		 newTempAvis.setTempType("AVS");
		 iservice.addObject(newTempAvis);
		 
		 newDem.setDemDteSaisi(Calendar.getInstance().getTime());
		 newDem.setDemGesCode(slctdTd.getDacGesCode());
		 newDem.setDemDacCode(slctdTd.getAaoDacCode());
		 newDem.setDemAaoCode(slctdTd.getAaoCode());
		 newDem.setDemStatutRetour("0");
		 newDem.setTFonction(userController.getSlctd().getTFonction());
		 newDem.setTOperateur(userController.getSlctd().getTOperateur());
		 newDem.setTStatut(new TStatut("E1S"));
		 newDem.setTStructure(userController.getSlctd().getTFonction().getTStructure());
		 newDem.setDemFonCodePf(userController.getSlctd().getTFonction().getFonCodePf());
		 newDem.setDemFonCodeDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
		 newDem.setTTypeDemande(new TTypeDemande("ANO"));
		 iservice.updateObject(newDem);
		 
		 TDetailDemandes demDet = new TDetailDemandes();
			demDet.setTDemande(newDem);
			demDet.setDdeAaoCode(slctdTd.getAaoCode());
			demDet.setTDacSpecs(slctdTd.getAaoDacCode());
			demDet.setDdeActNum(userController.getSlctd().getTFonction().getFonCod());
			demDet.setTStructure(userController.getSlctd().getTFonction().getTStructure());
			iservice.addObject(demDet);
		  
			List<TAvisAppelOffre> LS  = iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
			TAvisAppelOffre avis = new TAvisAppelOffre();
			if(!LS.isEmpty()) avis = LS.get(0);
			avis.setTStatut(new TStatut("ANO"));
		    iservice.updateObject(avis);
		    //chargeData();
		   // renderPage("LISANO" ,"ano1");
		 userController.setTexteMsg("Demande envoyée avec succès !");
         userController.setRenderMsg(true);
         userController.setSevrityMsg("success");
		 
		 
	 }
	 
	 public void validationAnoDMP() throws IOException {
			List<TAvisAppelOffre> LS  = iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_CODE",Comparateur.EQ,""+slctdTdDem.getAaoCode()));
			TAvisAppelOffre avis = new TAvisAppelOffre();
			if(!LS.isEmpty()) avis = LS.get(0);
			avis.setTStatut(new TStatut("JUG"));
			avis.setAaoStatut(4);
		    iservice.updateObject(avis);
		    //chargeData();
		   // renderPage("LISANO" ,"ano1");
		 userController.setTexteMsg("Validé avec succès !");
         userController.setRenderMsg(true);
         userController.setSevrityMsg("success");
		 
		 
	 }
	 
	 public void chargeDemande() {
		 listeHistoDemandeAno.clear();
		 listeHistoDemandeAno=(List<VHistoDemandeAno>) iservice.getObjectsByColumn("VHistoDemandeAno",
				new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
		_logger.info("listeHistoDemandeAno size: "+listeHistoDemandeAno.size());
	 }
	 
	//Chargement de la liste des avis d'appel d'offres en attente d'ano
	 public void chargeData(String statut, String colonne,String colonneAno) {
		 listeAvisAppelOffre.clear();
			if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
				 listeAvisAppelOffre = (List<VAvisAppelOffreAno>) iservice.getObjectsByColumnDesc("VAvisAppelOffreAno", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
						 new WhereClause(""+colonne,WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
				         new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,""+statut),
				         new WhereClause(""+colonneAno,WhereClause.Comparateur.EQ,"O"));
				_logger.info("listeAppelOffre size: "+listeAvisAppelOffre.size());	
					 }else 
					      if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")){
					    	
					      }else 
					    	  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP") || 
					    			  userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
					    		  chargeDemandeDmp();
					      }
	      }
	 
		//Liste des lot d'un avis d'avis d'appel d'offre
	 public void chargeLot() {
		 listeLots.clear();
		 listeLots=(List<VLotAvisdmp>) iservice.getObjectsByColumn("VLotAvisdmp", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
		_logger.info("listeLots size: "+listeLots.size());
	 }
	 
	 public void chargeLotDmp() {
		 listeLots.clear();
		 listeLots=(List<VLotAvisdmp>) iservice.getObjectsByColumn("VLotAvisdmp", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTdDem.getAaoCode()));
		_logger.info("listeLots size: "+listeLots.size());
	 }
	 
	/* public void chargeNatureDocData() {
		 natureDocListe.clear();
			natureDocListe=(List<VNatureDocAno>) iservice.getObjectsByColumn("VNatureDocAno");
		}
	 */
	 
	 //Pour Traiement ANO DPM
	 public void chargeNatureDocData() {
		  natureDocListe.clear();
			natureDocListe = (List<TNatureDocuments>) iservice.getObjectsByColumnIn("TNatureDocuments", new ArrayList<String>(Arrays.asList("nadLibelle")),
					"NAD_CODE", new ArrayList<String>(Arrays.asList("18","16")),
					new WhereClause("NAD_TYPE",Comparateur.EQ,"ANO"));
		 }
	 
	 //Pour demade d'ANO AC
	 public void chargeNatureDocDem() {
		 natureDocListe.clear();
			natureDocListe = ((List<TNatureDocuments>)iservice.getObjectsByColumn("TNatureDocuments",new ArrayList<String>(Arrays.asList("nadCode")),
					new WhereClause("NAD_CODE",Comparateur.NEQ,"18"),
					new WhereClause("NAD_TYPE",Comparateur.EQ,"ANO")));
		 }
	 
	 //Avec boite de dialogue
	/* public void saveAno() {
		List<TLotAao> LS  = iservice.getObjectsByColumn("TLotAao", new WhereClause("LAA_ID",Comparateur.EQ,""+sltLot.getLaaId()));
		TLotAao lot = new TLotAao();
		if(!LS.isEmpty()) lot = LS.get(0);
		lot.setLaaAno(sltLot.getLaaAno());
		lot.setLaaObservationDmp(sltLot.getLaaObservationDmp());
	    iservice.updateObject(lot);
	    chargeLot();
	    userController.setTexteMsg("ANO du lot "+sltLot.getLaaObjet()+" validé avec succès !");
        userController.setRenderMsg(true);
        userController.setSevrityMsg("success");
	   // btnAction();
	 }
	 */

	 
	 public void saveAno(String avis) {
			List<TLotAao> LS  = iservice.getObjectsByColumn("TLotAao", new WhereClause("LAA_ID",Comparateur.EQ,""+sltLot.getLaaId()));
				TLotAao lot = new TLotAao();
				if(!LS.isEmpty()) lot = LS.get(0);
				lot.setLaaAno(""+avis);
				lot.setLaaObservationDmp(sltLot.getLaaObservationDmp());
			    iservice.updateObject(lot);
			    chargeLotDmp();
			    recupResultatLot();
			    /*userController.setTexteMsg("ANO du lot "+sltLot.getLaaObjet()+" validé avec succès !");
		        userController.setRenderMsg(true);
		        userController.setSevrityMsg("success");*/
			   // btnAction();
			 }
	 
	 public void saveAno() {
			List<TLotAao> LS  = iservice.getObjectsByColumn("TLotAao", new WhereClause("LAA_ID",Comparateur.EQ,""+sltLot.getLaaId()));
				TLotAao lot = new TLotAao();
				if(!LS.isEmpty()) lot = LS.get(0);
				lot.setLaaAno(" ");
				lot.setLaaObservationDmp(sltLot.getLaaObservationDmp());
			    iservice.updateObject(lot);
			    chargeLot();
			    userController.setTexteMsg("ANO du lot "+sltLot.getLaaObjet()+" validé avec succès !");
		        userController.setRenderMsg(true);
		        userController.setSevrityMsg("success");
			   // btnAction();
			 }
	 public void btnAction() {
		 
		 List<VLotAvisdmp> LS  = iservice.getObjectsByColumn("VLotAvisdmp", new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
		 VLotAvisdmp lot = new VLotAvisdmp();
			if(!LS.isEmpty()) lot = LS.get(0);
			for(VLotAvisdmp lots : LS) {
				_logger.info("ano: "+lots.getLaaAno());	
				if(lots.getLaaAno().equalsIgnoreCase("O")) {
					 btn_Oui=false;
					 btn_non=false;
					 resultat=true;
					 _logger.info("btnoui: "+btn_Oui);	
					 _logger.info("btnNon: "+btn_non);	
					 _logger.info("resultat: "+resultat);	
				}else
					 if(lots.getLaaAno().equalsIgnoreCase("N")) {
						 btn_Oui=false;
						 btn_non=false;
						 resultat=true; 
						 _logger.info("btnoui: "+btn_Oui);	
						 _logger.info("btnNon: "+btn_non);	
						 _logger.info("resultat: "+resultat);	
					 }else
						 if(lots.getLaaAno().equalsIgnoreCase("A")) {
							 btn_Oui=true;
							 btn_non=true;
							 resultat=false;
							 _logger.info("btnoui: "+btn_Oui);	
							 _logger.info("btnNon: "+btn_non);	
							 _logger.info("resultat: "+resultat);	
						 }
			}

	 }
	 
	 @Transactional
		public void upload(FileUploadEvent event) throws java.io.FileNotFoundException { 
		 //condition de chargement d'un document : Nature sï¿½lectionnï¿½e 
		 if((docNature == null || "".equals(docNature))){
			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non séléctionnéé pour le chargement! ","");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
			 
			 }else {
		
		if(fileUploadController.handleFileUpload(event, ""+slctdTd.getAaoCode(), docNature)) {
			TDossierAao dos =new TDossierAao();
			listeAvis = (List<TAvisAppelOffre>) iservice.getObjectsByColumn("TAvisAppelOffre",
					new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
				if (!listeAvis.isEmpty()) {
					newAvis= listeAvis.get(0);
	   	                 }
			
			int nat = Integer.valueOf(docNature);
			//check le dossier s'il existe Ã  faire

			dos.setDaaAaoCode(newAvis.getAaoCode());
			dos.setDaaNom(fileUploadController.getFileName());
			dos.setDaaDteSaisi(Calendar.getInstance().getTime());
			dos.setDaaReference(fileUploadController.getDocNom());
			List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
			TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
			if(!LS.isEmpty()) natureDoc = LS.get(0);
			dos.setTNatureDocuments(natureDoc);
			dos.setDaaCode(keyGen.getCodeDossierAAO(fileUploadController.getFileCode()+"-"+natureDoc.getNadAbrege()+"-"));
			iservice.addObject(dos);
			chargeDossier();
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectuée avec succès!", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		   chargeDossier();
			}else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger Ã  nouveau un document ! ","");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
				
			}
		  }
		}
    //Fin Upload
	  public void chargeDossier() {
	 		 dossListe.clear();
	 			 dossListe = ((List<TDossierAao>)iservice.getObjectsByColumn("TDossierAao",new ArrayList<String>(Arrays.asList("DAA_ID")),
	 					 new WhereClause("DAA_AAO_CODE",Comparateur.EQ,slctdTd.getAaoCode())));			
	 	 } 
	 
	  
	  public void openDossier() throws IOException{
    		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDaaNom(), selectedDossier.getDaaNom());
    		   }
	  
	    //Supprimer un dao joint
	    public void removeDossier(){
		downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossier.getDaaNom(), selectedDossier.getDaaNom());
			 iservice.deleteObject(selectedDossier);
			 chargeDossier();	
			 
		    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDaaNom()+" supprimé avec succès", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
		}
	    
	    //Pour la demande
	    @Transactional
		public void uploadDossDem(FileUploadEvent event) throws java.io.FileNotFoundException { 
	    	_logger.info("dem num: "+newDem.getDemNum());
		 //condition de chargement d'un document : Nature sï¿½lectionnï¿½e 
		 if((docNatureDem == null || "".equals(docNatureDem))){
			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non séléctionnéé pour le chargement! ","");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
			 
			 }else {
		
		if(fileUploadController.handleFileUpload(event, ""+newDem.getDemNum(), docNatureDem)) {
			TDossierDemande dos =new TDossierDemande();
		/*	listeDemande = (List<TDemande>) iservice.getObjectsByColumn("TDemande",
					new WhereClause("DEM_NUM",WhereClause.Comparateur.EQ,""+newDem.getDemNum()));
				if (!listeDemande.isEmpty()) {
					demande= listeDemande.get(0);
	   	                 }*/
			
			int nat = Integer.valueOf(docNatureDem);
			//check le dossier s'il existe Ã  faire

			dos.setTDemande(new TDemande(newDem.getDemNum()));
			dos.setDodLibelle(fileUploadController.getDocNom());
			dos.setDodReference(fileUploadController.getFileName());
			dos.setDodDteSaisi(Calendar.getInstance().getTime());
			dos.setDodType("DEM");
			List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
			TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
			if(!LS.isEmpty()) natureDoc = LS.get(0);
			dos.setTNatureDocuments(natureDoc);
			dos.setDodCode(keyGen.getCodeDossierDem(fileUploadController.getFileCode()+"-"+natureDoc.getNadAbrege()+"-"));
			iservice.addObject(dos);
			chargeDossierDemande();

			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectuée avec succès!", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			chargeDossierDemande();
			}else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger Ã  nouveau un document ! ","");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
				
			}
		  }
		}
    //Fin Upload
	    
	  //Pour la demande DMP
	    @Transactional
		public void uploadDossDemDmp(FileUploadEvent event) throws java.io.FileNotFoundException { 
		 //condition de chargement d'un document : Nature sï¿½lectionnï¿½e 
		 if((docNatureDemDmp == null || "".equals(docNatureDemDmp))){
			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non séléctionnéé pour le chargement! ","");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
			 
			 }else {
		
		if(fileUploadController.handleFileUpload(event, ""+slctdTdDem.getDemNum(), docNatureDemDmp)) {
			TDossierDemande dos =new TDossierDemande();
		/*	listeDemande = (List<TDemande>) iservice.getObjectsByColumn("TDemande",
					new WhereClause("DEM_NUM",WhereClause.Comparateur.EQ,""+newDem.getDemNum()));
				if (!listeDemande.isEmpty()) {
					demande= listeDemande.get(0);
	   	                 }*/
			
			int nat = Integer.valueOf(docNatureDemDmp);
			//check le dossier s'il existe Ã  faire

			dos.setTDemande(new TDemande(slctdTdDem.getDemNum()));
			dos.setDodLibelle(fileUploadController.getDocNom());
			dos.setDodReference(fileUploadController.getFileName());
			dos.setDodDteSaisi(Calendar.getInstance().getTime());
			dos.setDodType("REP");
			List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
			TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
			if(!LS.isEmpty()) natureDoc = LS.get(0);
			dos.setTNatureDocuments(natureDoc);
			dos.setDodCode(keyGen.getCodeDossierDem(fileUploadController.getFileCode()+"-"+natureDoc.getNadAbrege()+"-"));
			iservice.addObject(dos);
			chargeDossierDemandeDmp();
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectuée avec succès!", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			chargeDossierDemandeDmp();
			}else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger Ã  nouveau un document ! ","");
				FacesContext.getCurrentInstance().addMessage(null, msg);	
				
			}
		  }
		}
    //Fin Upload
	
	    
	    public void chargeDossierDemande() {
	    	/*if(newDem.getDemNum()==null) {
	    		demNum = 0;
	    	}else {
	    		demNum=newDem.getDemNum().longValue();
	    	}
	    	*/
	    	dossListeDemande.clear();
	    	dossListeDemande = ((List<TDossierDemande>)iservice.getObjectsByColumn("TDossierDemande",new ArrayList<String>(Arrays.asList("DOD_ID")),
	 					 new WhereClause("DOD_DEM_NUM",Comparateur.EQ,""+newDem.getDemNum())));			
	 	 } 
	    
	    public void chargeDossierDemandeDmp() {
	    	dossListeDemandeDmp.clear();
	    	dossListeDemandeDmp = ((List<TDossierDemande>)iservice.getObjectsByColumn("TDossierDemande",new ArrayList<String>(Arrays.asList("DOD_ID")),
	    			     new WhereClause("DOD_TYPE",Comparateur.EQ,"REP"),
	 					 new WhereClause("DOD_DEM_NUM",Comparateur.EQ,""+slctdTdDem.getDemNum())));			
	 	 } 
	    public void chargeDossierDemandeDmpAc() {
	    	dossListeDemandeAc.clear();
	    	dossListeDemandeAc = ((List<TDossierDemande>)iservice.getObjectsByColumn("TDossierDemande",new ArrayList<String>(Arrays.asList("DOD_ID")),
	    			     new WhereClause("DOD_TYPE",Comparateur.EQ,"DEM"),
	 					 new WhereClause("DOD_DEM_NUM",Comparateur.EQ,""+slctdTdDem.getDemNum())));			
	 	 } 
	    
	    
	    public void chargeDossierHistoDem() {
	    	dossListeDemande.clear();
	    	dossListeDemande = ((List<TDossierDemande>)iservice.getObjectsByColumn("TDossierDemande",new ArrayList<String>(Arrays.asList("DOD_ID")),
	 					 new WhereClause("DOD_DEM_NUM",Comparateur.EQ,""+sltHistoDem.getDemNum())));			
	 	 } 
	 
	    public void openDossierDem() throws IOException{
   		 downloadFileServlet.downloadFile(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossierDem.getDodReference(), selectedDossierDem.getDodReference());
   		   }
	  
	    //Supprimer un dao joint
	    public void removeDossierDem(){
		downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossierDem.getDodReference(), selectedDossierDem.getDodReference());
			 iservice.deleteObject(selectedDossierDem);
			 chargeDossierHistoDem();	
			 
		    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDaaNom()+" supprimé avec succès", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
		}
	    
	    //Supprimer un dao joint
	    public void removeDossierDemDmp(){
		downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossierDem.getDodReference(), selectedDossierDem.getDodReference());
			 iservice.deleteObject(selectedDossierDem);
			 chargeDossierDemandeDmp();	
			 
		    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Document "+selectedDossier.getDaaNom()+" supprimé avec succès", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
		}
	 
	//Methode de récupération de t_pgpm dans t_affichage
	 public void recupInfosDemande() {
	    			List<TDemande> LS  = iservice.getObjectsByColumn("TDemande", new WhereClause("DEM_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
	    			if(!LS.isEmpty()) newDem = LS.get(0);
	    			
	 }
	 
		//Methode de récupération de t_pgpm dans t_affichage
	 public void recupResultatLot() {
		 _logger.info("AAO: "+slctdTdDem.getAaoCode());
	    			List<VLotAvisdmp> LS  = iservice.getObjectsByColumn("VLotAvisdmp", new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTdDem.getAaoCode()));
	    			if(!LS.isEmpty()) infolot = LS.get(0);
	    			
	 }
	 
		 
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "ano1":
					 newDem = new TDemande();
					//Ramener le statut en fonction de l'utilisateur connecté et de l'action a mener
						userController.initMessage();
						String fonct = controleController.getFonctionalite();	
						String statutAffiche = "";
						//String statutDiffere = "";
						String colonneFonction ="";
						String colonneFonctionAno ="";
						
						
						if(fonct.equalsIgnoreCase("listDemAnoAc")) {
							statutAffiche = "JUG";
							colonneFonction ="AAO_FON_COD_AC";
							colonneFonctionAno ="AAO_ANO";
							_logger.info("staut: "+statutAffiche);	
							_logger.info("fonctionalité: "+fonct);	
							_logger.info("value: "+value+" action: "+action);
						 }else {
							 if(fonct.equalsIgnoreCase("listDemAnoDmp")) {
								 statutAffiche = "ANO";
								 //colonneFonction ="AAO_FON_COD_AC";
								 colonneFonctionAno ="AAO_ANO";
								 _logger.info("staut: "+statutAffiche);	
								 _logger.info("fonctionalité: "+fonct);	
								 _logger.info("value: "+value+" action: "+action);
							 }else {
								 if(fonct.equalsIgnoreCase("listValidationSPD")) {

									//ICI
								 }else {
									//ICI
								 }	 
							 }
						 }
						chargeData(statutAffiche, colonneFonction,colonneFonctionAno);
					break;
				case "ano2":
					chargeLot();
					chargeNatureDocDem();
					chargeDemande();
					saveDemande();
					docNatureDem ="12";
					
				break;
				case "ano3":
					docNatureDemDmp ="18";
					chargeLotDmp();
					//recupInfosDemande();
					//btnAction();
					chargeDemande();
					chargeNatureDocData();
					chargeDossierDemandeDmp();
					chargeDossierDemandeDmpAc();
					recupResultatLot();
				break;
				case "ano4":
	
					break;
				case "ano5":
		
					break;
				case "ano6":

					break;
				case "ano7":
				
					break;
					
			    }
		     
		     
		     
		    return userController.renderPage(value);   
		    
		}


	public List<VAvisAppelOffreAno> getListeAvisAppelOffre() {
		return listeAvisAppelOffre;
	}


	public void setListeAvisAppelOffre(List<VAvisAppelOffreAno> listeAvisAppelOffre) {
		this.listeAvisAppelOffre = listeAvisAppelOffre;
	}


	public VAvisAppelOffreAno getSlctdTd() {
		return slctdTd;
	}


	public void setSlctdTd(VAvisAppelOffreAno slctdTd) {
		this.slctdTd = slctdTd;
	}





	public long getLaaNum() {
		return laaNum;
	}


	public void setLaaNum(long laaNum) {
		this.laaNum = laaNum;
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


	public VbTempParamAvis getNewTempAvis() {
		return newTempAvis;
	}


	public void setNewTempAvis(VbTempParamAvis newTempAvis) {
		this.newTempAvis = newTempAvis;
	}


	public TDemande getNewDem() {
		return newDem;
	}


	public void setNewDem(TDemande newDem) {
		this.newDem = newDem;
	}


	public boolean isBtn_Oui() {
		return btn_Oui;
	}


	public void setBtn_Oui(boolean btn_Oui) {
		this.btn_Oui = btn_Oui;
	}


	public Boolean getBtn_non() {
		return btn_non;
	}


	public void setBtn_non(Boolean btn_non) {
		this.btn_non = btn_non;
	}


	public Boolean getResultat() {
		return resultat;
	}


	public void setResultat(Boolean resultat) {
		this.resultat = resultat;
	}


	public List<VLotAvisdmp> getListeLots() {
		return listeLots;
	}


	public void setListeLots(List<VLotAvisdmp> listeLots) {
		this.listeLots = listeLots;
	}


	public VLotAvisdmp getSltLot() {
		return sltLot;
	}


	public void setSltLot(VLotAvisdmp sltLot) {
		this.sltLot = sltLot;
	}


	public void setBtn_non(boolean btn_non) {
		this.btn_non = btn_non;
	}


	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}


	public List<VHistoDemandeAno> getListeHistoDemandeAno() {
		return listeHistoDemandeAno;
	}


	public void setListeHistoDemandeAno(List<VHistoDemandeAno> listeHistoDemandeAno) {
		this.listeHistoDemandeAno = listeHistoDemandeAno;
	}


	public VHistoDemandeAno getSltHistoDem() {
		return sltHistoDem;
	}


	public void setSltHistoDem(VHistoDemandeAno sltHistoDem) {
		this.sltHistoDem = sltHistoDem;
	}


	public List<TAvisAppelOffre> getListeAvis() {
		return listeAvis;
	}


	public void setListeAvis(List<TAvisAppelOffre> listeAvis) {
		this.listeAvis = listeAvis;
	}


	public TAvisAppelOffre getNewAvis() {
		return newAvis;
	}


	public void setNewAvis(TAvisAppelOffre newAvis) {
		this.newAvis = newAvis;
	}


	public List<TDossierAao> getDossListe() {
		return dossListe;
	}


	public void setDossListe(List<TDossierAao> dossListe) {
		this.dossListe = dossListe;
	}


	public TDossierAao getSelectedDossier() {
		return selectedDossier;
	}


	public void setSelectedDossier(TDossierAao selectedDossier) {
		this.selectedDossier = selectedDossier;
	}


	public String getDocNatureDem() {
		return docNatureDem;
	}


	public void setDocNatureDem(String docNatureDem) {
		this.docNatureDem = docNatureDem;
	}


	public List<VAvisAppelOffreAnodmp> getListeDemande() {
		return listeDemande;
	}


	public void setListeDemande(List<VAvisAppelOffreAnodmp> listeDemande) {
		this.listeDemande = listeDemande;
	}


	public TDemande getDemande() {
		return demande;
	}


	public void setDemande(TDemande demande) {
		this.demande = demande;
	}


	public List<TDossierDemande> getDossListeDemande() {
		return dossListeDemande;
	}


	public void setDossListeDemande(List<TDossierDemande> dossListeDemande) {
		this.dossListeDemande = dossListeDemande;
	}


	public TDossierDemande getSelectedDossierDem() {
		return selectedDossierDem;
	}


	public void setSelectedDossierDem(TDossierDemande selectedDossierDem) {
		this.selectedDossierDem = selectedDossierDem;
	}


	public long getDemNum() {
		return demNum;
	}


	public void setDemNum(long demNum) {
		this.demNum = demNum;
	}


	public VAvisAppelOffreAnodmp getSlctdTdDem() {
		return slctdTdDem;
	}


	public void setSlctdTdDem(VAvisAppelOffreAnodmp slctdTdDem) {
		this.slctdTdDem = slctdTdDem;
	}


	public String getDocNatureDemDmp() {
		return docNatureDemDmp;
	}


	public void setDocNatureDemDmp(String docNatureDemDmp) {
		this.docNatureDemDmp = docNatureDemDmp;
	}


	public List<TDossierDemande> getDossListeDemandeDmp() {
		return dossListeDemandeDmp;
	}


	public void setDossListeDemandeDmp(List<TDossierDemande> dossListeDemandeDmp) {
		this.dossListeDemandeDmp = dossListeDemandeDmp;
	}


	public List<TDossierDemande> getDossListeDemandeAc() {
		return dossListeDemandeAc;
	}


	public void setDossListeDemandeAc(List<TDossierDemande> dossListeDemandeAc) {
		this.dossListeDemandeAc = dossListeDemandeAc;
	}


	public VLotAvisdmp getInfolot() {
		return infolot;
	}


	public void setInfolot(VLotAvisdmp infolot) {
		this.infolot = infolot;
	}

	
}
