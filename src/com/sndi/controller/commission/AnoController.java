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
import com.sndi.model.*;
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
	 private String souNcc="";
	 
	 
	 //liste
	 private List<VAvisAppelOffreAno> listeAvisAppelOffre = new ArrayList<VAvisAppelOffreAno>();
	 private List<VAvisAppelOffreAno> listeAvisAppelOffreDmp = new ArrayList<VAvisAppelOffreAno>();
	 private List<VMotifAno> listeMotifs = new ArrayList<VMotifAno>();
	 private List<VLotCandidatAnoPrequalif> listeEntreprise = new ArrayList<VLotCandidatAnoPrequalif>();
	 //private List<VLotCandidatAno> listeEntreprise = new ArrayList<VLotCandidatAno>();
	 private List<VAvisAppelOffreAnodmp> listeDemande = new ArrayList<VAvisAppelOffreAnodmp>();
	 private List<VAnodmpTraite> listeDemandeAnoTratite = new ArrayList<VAnodmpTraite>();
	 private List<VAvisAppelOffreAnodmp> listeDemandeTraiteDmp = new ArrayList<VAvisAppelOffreAnodmp>();
	 private List<TDemande> demandeListe = new ArrayList<TDemande>();
	 //private List<VNatureDocAno> natureDocListe = new ArrayList<VNatureDocAno>();
	 private List<TNatureDocuments> natureDocListe = new ArrayList<TNatureDocuments>();
	 private List<VLotAvisdmp> listeLots = new ArrayList<VLotAvisdmp>();
	 private List<VLotNumerotation> listeLotNumerotation = new ArrayList<VLotNumerotation>();
	 private List<VLotNumerotation> selectionLotNumerotation= new ArrayList<VLotNumerotation>();
	 private List<VHistoDemandeAno> listeHistoDemandeAno = new ArrayList<VHistoDemandeAno>();
	 private List<TAvisAppelOffre> listeAvis = new ArrayList<TAvisAppelOffre>();
	 private List<TDossierAao> dossListe = new ArrayList<TDossierAao>();
	 private List<TDossierDemande> dossListeDemande = new ArrayList<TDossierDemande>();
	 private List<TDossierDemande> dossListeDemandeDmp = new ArrayList<TDossierDemande>();
	 private List<TDossierDemande> dossListeDemandeAc = new ArrayList<TDossierDemande>();
	// private List<VObservationAno> listeObservation = new ArrayList<VObservationAno>(); 
	 private List<TObservations> listeObservation = new ArrayList<TObservations>(); 
	 private List<VObservationAno> observations = new ArrayList<VObservationAno>(); 
	 //private List<TDemande> listeDemande = new ArrayList<TDemande>();
	 
	 //Objet
	 private VAvisAppelOffreAno slctdTd = new VAvisAppelOffreAno();
	 private VAnodmpTraite detailDem = new VAnodmpTraite();
	 private VAvisAppelOffreAnodmp slctdTdDem = new VAvisAppelOffreAnodmp();
	 private VbTempParamAvis newTempAvis = new VbTempParamAvis();
	 private TDemande newDem = new TDemande();
	 private VbObservations newObs = new VbObservations();
	 private VLotAvisdmp infolot = new VLotAvisdmp();
	 private VObservationAno sltObservation = new VObservationAno();
	 private TObservations supObs = new TObservations();

	 private TDemande demande = new TDemande();
	 private TAvisAppelOffre newAvis = new TAvisAppelOffre();
	 private VLotAvisdmp sltLot = new VLotAvisdmp();
	 private TDossierAao selectedDossier = new TDossierAao();
	 private TDossierDemande selectedDossierDem = new TDossierDemande();
	 private VHistoDemandeAno sltHistoDem = new VHistoDemandeAno();
	 private boolean btn_Oui;
	 private boolean btn_non;
	 private boolean resultat;
	 
	 private boolean panelNewDem =false;
	 private boolean panelAncienDem =false;
	 private boolean panelChoixDem =true;
	 private boolean panelCodeAvis =false;
	 private long mtfNum;
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
		//chargeData();
	 }		
	
	 //Ensemeble des methode pour afficher la love de detail de traitement
	 public void loveDetailDemande() {
		 //Dossiers JOINTS PAR DGMP
		 dossListeDemandeDmp.clear();
	    	dossListeDemandeDmp = ((List<TDossierDemande>)iservice.getObjectsByColumn("TDossierDemande",new ArrayList<String>(Arrays.asList("DOD_ID")),
	    			     new WhereClause("DOD_TYPE",Comparateur.EQ,"REP"),
	 					 new WhereClause("DOD_DEM_NUM",Comparateur.EQ,""+detailDem.getDemNum())));
	    	//Dossiers JOINTS PAR AC
	    	dossListeDemandeAc.clear();
	    	dossListeDemandeAc = ((List<TDossierDemande>)iservice.getObjectsByColumn("TDossierDemande",new ArrayList<String>(Arrays.asList("DOD_ID")),
	    			     new WhereClause("DOD_TYPE",Comparateur.EQ,"DEM"),
	 					 new WhereClause("DOD_DEM_NUM",Comparateur.EQ,""+detailDem.getDemNum())));	
	    	
	    	List<VLotAvisdmp> LS  = iservice.getObjectsByColumn("VLotAvisdmp", new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+detailDem.getAaoCode()));
			if(!LS.isEmpty()) infolot = LS.get(0);
			
			listeLots.clear();
			 listeLots=(List<VLotAvisdmp>) iservice.getObjectsByColumn("VLotAvisdmp", new ArrayList<String>(Arrays.asList("LAA_NUM")),
					 //new WhereClause("LAA_STA_CODE",WhereClause.Comparateur.EQ,"L2D"),
					new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+detailDem.getAaoCode()));
	 }
	 
	 public void transmettrePourNumerotation() {
		 if (selectionLotNumerotation.size()<=0) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Selectionnez au moin un lot", ""));
			}
	 		else{
		 		for(VLotNumerotation ligne : listeLotNumerotation) {
		 			List<TLotAao> LS  = iservice.getObjectsByColumn("TLotAao", 
		 					new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()),
		 					new WhereClause("LAA_NUM",Comparateur.EQ,""+ligne.getLaaNum()));
		 			TLotAao updateLot = new TLotAao();
					if(!LS.isEmpty()) {
						updateLot = LS.get(0);	
						updateLot.setLaaStaCode("L3T");
		 			iservice.updateObject(updateLot);
			     }	
					chargeLotAnumeroter();
					userController.setTexteMsg("Transmission éffectuée avec succès !");
			        userController.setRenderMsg(true);
			        userController.setSevrityMsg("success");
		 		}
	         }
	 }
	 
	 public void saveDemande() {
		 newDem.setDemAaoCode(slctdTd.getAaoCode());
		 iservice.addObject(newDem);
		 
	 }
	 
	 //Liste des demandes d'ANO en attente de tratement par la DGMP
	 public void chargeDemandeDmp() { 
		 listeDemande = (List<VAvisAppelOffreAnodmp>) iservice.getObjectByColumnInInstrValAno("VAvisAppelOffreAnodmp", ""+userController.getSlctd().getTFonction().getFonCod());
			_logger.info("listeDemande size: "+listeDemande.size());	
	 }
	 
	//Liste des demandes d'ANO deja traté par la DGMP
	 public void chargeDemandeTraiteDmpDmp() { 
		 listeDemandeAnoTratite .clear();
		 listeDemandeAnoTratite  = (List<VAnodmpTraite>) iservice.getObjectByColumnInstrTraiAno("VAnodmpTraite", ""+userController.getSlctd().getTFonction().getFonCod());
			_logger.info("listeDemandeAnoTratite  size: "+listeDemandeAnoTratite .size());	
	 }
	 
	//Liste des demandes d'ANO de l'AC deja traté par la DGMP
		 public void chargeDemandeTraiteDmpAc() { 
			 listeDemandeAnoTratite.clear();
			 listeDemandeAnoTratite = (List<VAnodmpTraite>) iservice.getObjectsByColumn("VAnodmpTraite",
					  new WhereClause("DEM_FON_CODE_AC",Comparateur.EQ,""+userController.getSlctd().getTFonction().getFonCod()));
				_logger.info("listeDemandeAnoTratite size: "+listeDemandeAnoTratite.size());	

		 }
	 
	
	 public void chargeAvisDmp() {
		 listeAvisAppelOffreDmp.clear();
		 listeAvisAppelOffreDmp = (List<VAvisAppelOffreAno>) iservice.getObjectsByColumn("VAvisAppelOffreAno",
		         new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,"JUG"),
		         new WhereClause("AAO_ANO",WhereClause.Comparateur.EQ,"O"));
		_logger.info("listeAvisAppelOffreDmp size: "+listeAvisAppelOffreDmp.size());
		
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
		 newDem.setTStatut(new TStatut("AND"));
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
		    
		    historiser("ANO", "");
		    //chargeData();
		   // renderPage("LISANO" ,"ano1");
		 userController.setTexteMsg("Demande envoyée avec succès !");
         userController.setRenderMsg(true);
         userController.setSevrityMsg("success");
		 
	 }
	 
	//Fin de validation de l'ANO par la DMP
			public void finAno() {
				String statUpdate = "";
				String message = "";
				if(slctdTdDem.getDemStaCode().equalsIgnoreCase("AND")) {
					statUpdate = "ARC";
					message="Fin de la validation de la demande N°"+slctdTdDem.getDemNum();
				 }
	    
				demandeListe = (List<TDemande>) iservice.getObjectsByColumn("TDemande", new ArrayList<String>(Arrays.asList("DEM_NUM")),
						  new WhereClause("DEM_NUM",Comparateur.EQ,""+slctdTdDem.getDemNum()));
		  		if (!demandeListe.isEmpty()) {
		  			newDem = demandeListe.get(0);
		  			newDem.setTStatut(new TStatut(statUpdate));
	                iservice.updateObject(newDem);
	  			}
				//Chargement de la liste des avis 
		  		chargeDemandeDmp();
		        //Message de Confirmation
				userController.setTexteMsg(message);
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");  
			}
	     //Fin de la validation de l'ANO par la DMP
	 
	 public void validationAnoDMP() throws IOException {
		/* List<VLotAvisdmp> Lot  = iservice.getObjectsByColumn("VLotAvisdmp", new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTdDem.getAaoCode()));
			if(!Lot.isEmpty()) infolot = Lot.get(0);
		 if(infolot.getChecktrt()==0) {*/
			List<TAvisAppelOffre> LS  = iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_CODE",Comparateur.EQ,""+slctdTdDem.getAaoCode()));
			TAvisAppelOffre avis = new TAvisAppelOffre();
			if(!LS.isEmpty()) avis = LS.get(0);
			//avis.setTStatut(new TStatut("JUG"));
			avis.setAaoStatut("4");
		    iservice.updateObject(avis);
		    
		
		 userController.setTexteMsg("Validé avec succès !");
         userController.setRenderMsg(true);
         userController.setSevrityMsg("success");
	 }
	 
		//Methode d'historisation
	 public void historiser(String statut, String motif) {
	     TStatut statuts = constantService.getStatut(statut);
	     THistoDac dacStatut = new THistoDac();
	     dacStatut.setHacDate(Calendar.getInstance().getTime());
	     dacStatut.setHacCommentaire(motif);
	     dacStatut.setTStatut(statuts);
	     dacStatut.setHacAaoCode(slctdTd.getAaoCode());
	     dacStatut.setTDacSpecs(new TDacSpecs(slctdTd.getAaoDacCode()));
	     dacStatut.setTFonction(userController.getSlctd().getTFonction());
	     dacStatut.setTOperateur(userController.getSlctd().getTOperateur());
	     iservice.addObject(dacStatut);
 }
	 
	 //Chargement des observations
	 public void chargeObservations() {
		 observations.clear();
		 observations =  ((List<VObservationAno>)iservice.getObjectsByColumn("VObservationAno",new ArrayList<String>(Arrays.asList("OBS_NUM")),
				    new WhereClause("OBS_LAA_NUM",Comparateur.EQ,""+sltLot.getLaaNum()),
				    new WhereClause("OBS_SOU_NCC",Comparateur.EQ,""+souNcc)));
	 }
	
	 //Suppression d'une observation
	 public void deleteObservation() {  
		 listeObservation = ((List<TObservations>)iservice.getObjectsByColumn("TObservations",
				    new WhereClause("OBS_NUM",Comparateur.EQ,""+sltObservation.getObsNum())));
  			if (!listeObservation.isEmpty()) {
  				supObs=listeObservation.get(0); 
  				iservice.deleteObject(getSupObs());
			 		chargeObservations();
					userController.setTexteMsg("Suppression éffectuée avec succès!");
			  		userController.setRenderMsg(true);
			  		userController.setSevrityMsg("success");
  			   }	
			}
	 
	 public void validationAnoDMPAut() throws IOException {
		 List<VLotAvisdmp> Lot  = iservice.getObjectsByColumn("VLotAvisdmp", new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
			if(!Lot.isEmpty()) infolot = Lot.get(0);
		 if(infolot.getChecktrt()==0) {
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
			 newDem.setTStatut(new TStatut("ARC"));
			 newDem.setTStructure(userController.getSlctd().getTFonction().getTStructure());
			 newDem.setDemFonCodePf(userController.getSlctd().getTFonction().getFonCodePf());
			 newDem.setDemFonCodeDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
			 newDem.setTTypeDemande(new TTypeDemande("ANS"));
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
				avis.setTStatut(new TStatut("JUG"));
				avis.setAaoStatut("4");
			    iservice.updateObject(avis);
			    //chargeData();
			   // renderPage("LISANO" ,"ano1");
			 userController.setTexteMsg("Validé avec succès !");
	      userController.setRenderMsg(true);
	      userController.setSevrityMsg("success")
	      ;
		 }
		 else
		 {
			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vous devez absolument traiter tout les lots! ","");
				FacesContext.getCurrentInstance().addMessage(null, msg);	 
		 } 
	 }
	 
	 //Charger la combobox des motifs
	 public void chargeComboboxMotif() {
		 mtfNum=0;
		 listeMotifs.clear();
		 listeMotifs=(List<VMotifAno>) iservice.getObjectsByColumn("VMotifAno");
			_logger.info("listeMotifs size: "+listeMotifs.size());	 
	 }
	 
	 //Charger la combobox des entreprises
	 public void chargeComboboxEntreprise() {
		 souNcc="";
		 listeEntreprise.clear();
		 listeEntreprise=(List<VLotCandidatAnoPrequalif>) iservice.getObjectsByColumn("VLotCandidatAnoPrequalif",
				   new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+sltLot.getLaaAaoCode()),
			       new WhereClause("LAA_NUM",WhereClause.Comparateur.EQ,""+sltLot.getLaaNum()));
			_logger.info("listeEntreprise size: "+listeEntreprise.size());	 
			_logger.info("LAA_AAO_CODE: "+sltLot.getLaaAaoCode());
			_logger.info("LAA_NUM: "+sltLot.getLaaNum());
	 }
	 
	 
	 //Enregister les motifs
	 public void saveMotif() {
		 newObs.setObsDate(Calendar.getInstance().getTime());
		 newObs.setObsOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
		 newObs.setObsLaaNum(sltLot.getLaaNum());
		 newObs.setObsAaoCode(slctdTdDem.getAaoCode());
		 newObs.setObsDacCode(slctdTdDem.getAaoDacCode());
		 newObs.setObsMtfNum(mtfNum);
		 newObs.setObsSouNcc(souNcc);
		 newObs.setObsType("ANO");
		 iservice.addObject(newObs);
		 chargeObservations();
		 vider();
		 //chargeLotDmp();	
		 userController.setTexteMsg("Motif enrégisté avec succès!");
		 userController.setRenderMsg(true);
		 userController.setSevrityMsg("success");
	 }
	 
	 public void vider() {
		 newObs = new VbObservations();
		 souNcc ="";
		 mtfNum = 0;
	 }
	 public void chargeDialogueMotif() {
		 newObs = new VbObservations();
		 chargeComboboxMotif();
		 chargeComboboxEntreprise();
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
					 }
	      }
	 
		//Liste des lot d'un avis d'avis d'appel d'offre
	 public void chargeLot() {
		 listeLots.clear();
		 listeLots=(List<VLotAvisdmp>) iservice.getObjectsByColumn("VLotAvisdmp", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				 //new WhereClause("LAA_STA_CODE",WhereClause.Comparateur.EQ,"L2D"),
				new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
		_logger.info("listeLots size: "+listeLots.size());
	 }
	 
	 //Liste des lots à numeroter
	 public void chargeLotAnumeroter() {
		 listeLotNumerotation.clear();
		 listeLotNumerotation=(List<VLotNumerotation>) iservice.getObjectsByColumn("VLotNumerotation", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				 new WhereClause("LAA_STA_CODE",WhereClause.Comparateur.EQ,"L3A"),
				new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
		_logger.info("listeLotNumerotation size: "+listeLotNumerotation.size());
	 }
	 
	/* public void saveLotNumerotation() {
		 listeLotNumerotation.clear();
		 listeLotNumerotation=(List<VLotNumerotation>) iservice.getObjectsByColumn("VLotNumerotation", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
		 VLotAvisdmp lot = new VLotAvisdmp();
			if(!LS.isEmpty()) lot = LS.get(0);
			for(VLotAvisdmp lots : LS) {
				
			}
	 }*/
	 
	 public void chargeLotDmp() {
		 listeLots.clear();
		 listeLots=(List<VLotAvisdmp>) iservice.getObjectsByColumn("VLotAvisdmp", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTdDem.getAaoCode()));
		_logger.info("listeLots size: "+listeLots.size());
	 }
	 
	 
	 //Pour Traiement ANO DPM
	 public void chargeNatureDocData() {
		  natureDocListe.clear();
			natureDocListe = (List<TNatureDocuments>) iservice.getObjectsByColumnIn("TNatureDocuments", new ArrayList<String>(Arrays.asList("nadLibelle")),
					"NAD_CODE", new ArrayList<String>(Arrays.asList("18","16")),
					new WhereClause("NAD_TYPE",Comparateur.EQ,"ANO"));
		 }
	 
	 //Pour Traiement ANO DPM Autosaisine
	 public void chargeNatureDocDataAut() {
		  natureDocListe.clear();
			natureDocListe = (List<TNatureDocuments>) iservice.getObjectsByColumnIn("TNatureDocuments", new ArrayList<String>(Arrays.asList("nadLibelle")),
					"NAD_CODE", new ArrayList<String>(Arrays.asList("19","16")),
					new WhereClause("NAD_TYPE",Comparateur.EQ,"ANO"));
		 }
	 
	 //Pour demade d'ANO AC
	 public void chargeNatureDocDem() {
		 natureDocListe.clear();
			natureDocListe = ((List<TNatureDocuments>)iservice.getObjectsByColumn("TNatureDocuments",new ArrayList<String>(Arrays.asList("nadLibelle")),
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
				if(avis.equalsIgnoreCase("O")) {
					lot.setLaaStaCode("L3A");
				}
				//lot.setLaaObservationDmp(sltLot.getLaaObservationDmp());
			    iservice.updateObject(lot);
			    chargeLotDmp();
			    recupResultatLot();
	  }
	 
	 
	 public void saveAnoAut(String avis) {
			 List<TLotAao> LS  = iservice.getObjectsByColumn("TLotAao", new WhereClause("LAA_ID",Comparateur.EQ,""+sltLot.getLaaId()));
				TLotAao lot = new TLotAao();
				if(!LS.isEmpty()) lot = LS.get(0);
				lot.setLaaAno(""+avis);
				lot.setLaaObservationDmp(sltLot.getLaaObservationDmp());
			    iservice.updateObject(lot);
			    chargeLot();
			    recupResultatLotAut();
		 
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
	 
	 public void nouvelleDemande() {
		 panelNewDem =true;
		 panelAncienDem =false;
		 panelChoixDem =false;
		 panelCodeAvis = false;
	 }
	 
	 public void ancienneDemande() {
		 panelNewDem =false;
		 panelAncienDem =false;
		 panelChoixDem =false;
		 panelCodeAvis=true;
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
	    
	  //Pour DMP auto sasine
	    @Transactional
		public void uploadDossDemAut(FileUploadEvent event) throws java.io.FileNotFoundException { 
	    	_logger.info("dem num: "+newDem.getDemNum());
		 //condition de chargement d'un document : Nature sï¿½lectionnï¿½e 
		 if((docNatureDemDmp == null || "".equals(docNatureDemDmp))){
			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non séléctionnéé pour le chargement! ","");
			FacesContext.getCurrentInstance().addMessage(null, msg);	
			 
			 }else {
		
		if(fileUploadController.handleFileUpload(event, ""+newDem.getDemNum(), docNatureDemDmp)) {
			TDossierDemande dos =new TDossierDemande();
		/*	listeDemande = (List<TDemande>) iservice.getObjectsByColumn("TDemande",
					new WhereClause("DEM_NUM",WhereClause.Comparateur.EQ,""+newDem.getDemNum()));
				if (!listeDemande.isEmpty()) {
					demande= listeDemande.get(0);
	   	                 }*/
			
			int nat = Integer.valueOf(docNatureDemDmp);
			//check le dossier s'il existe Ã  faire

			dos.setTDemande(new TDemande(newDem.getDemNum()));
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
			chargeDossierDemandeDmpAut();

			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Chargement de fichiers effectuée avec succès!", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			chargeDossierDemandeDmpAut();
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
	    public void chargeDossierDemandeDmpCons() {
	    	dossListeDemandeDmp.clear();
	    	dossListeDemandeDmp = ((List<TDossierDemande>)iservice.getObjectsByColumn("TDossierDemande",new ArrayList<String>(Arrays.asList("DOD_ID")),
	    			     new WhereClause("DOD_TYPE",Comparateur.EQ,"REP"),
	 					 new WhereClause("DOD_DEM_NUM",Comparateur.EQ,""+slctdTdDem.getDemNum())));			
	 	 }
	    
	    public void chargeDossierDemandeDmpAut() {
	    	dossListeDemandeDmp.clear();
	    	dossListeDemandeDmp = ((List<TDossierDemande>)iservice.getObjectsByColumn("TDossierDemande",new ArrayList<String>(Arrays.asList("DOD_ID")),
	    			     new WhereClause("DOD_TYPE",Comparateur.EQ,"REP"),
	 					 new WhereClause("DOD_DEM_NUM",Comparateur.EQ,""+newDem.getDemNum())));			
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
	    
	    //Supprimer un dao joint AutoSaisie DMP
	    public void removeDossierDemDmpAut(){
		downloadFileServlet.deleteFileOnFolder(userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DESTINATION+selectedDossierDem.getDodReference(), selectedDossierDem.getDodReference());
			 iservice.deleteObject(selectedDossierDem);
			 chargeDossierDemandeDmpAut();	
			 
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
	 
	//Methode de récupération de t_pgpm dans t_affichage
		 public void recupResultatLotConsult() {
			 _logger.info("AAO: "+slctdTd.getAaoCode());
		    			List<VLotAvisdmp> LS  = iservice.getObjectsByColumn("VLotAvisdmp", new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
		    			if(!LS.isEmpty()) infolot = LS.get(0);  			
		 }
	 
	 public void recupResultatLotAut() {
		 _logger.info("AAO: "+slctdTd.getAaoCode());
	    			List<VLotAvisdmp> LS  = iservice.getObjectsByColumn("VLotAvisdmp", new WhereClause("LAA_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
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
							_logger.info("fonctionalité: "+fonct);	
							_logger.info("value: "+value+" action: "+action);
							chargeData("JUG", "AAO_FON_COD_AC","AAO_ANO");
						 }else {
							 if(fonct.equalsIgnoreCase("listAutoSaiDmp")) {
					    		  chargeAvisDmp();
								
							 }else {
								 if(fonct.equalsIgnoreCase("listDemAnoDmp")) {
									 chargeDemandeDmp();
								 } 
							 }
						 }
						
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
					docNatureDemDmp ="19";
					chargeLot();
					//recupInfosDemande();
					//btnAction();
					//chargeDemande();
					chargeNatureDocDataAut();
					//chargeDossierDemandeDmp();
					//chargeDossierDemandeDmpAc();
					recupResultatLotAut();
					saveDemande();
					break;
				case "ano5":
					String fonction = controleController.getFonctionalite();	
					//Liste des demandes d'ANO de l'AC deja traté par la DGMP
					if(fonction.equalsIgnoreCase("listDemTraiByDgmp")) {
						chargeDemandeTraiteDmpAc();
					}else
						//Liste des demandes d'ANO deja traté par la DGMP
						if(fonction.equalsIgnoreCase("listDemTraiDgmp")) {
							chargeDemandeTraiteDmpDmp();
						}	
					break;
				case "ano6":
					chargeLotAnumeroter();
					break;
				case "ano7":
					recupResultatLotConsult();
					chargeLot();
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


	public boolean isPanelNewDem() {
		return panelNewDem;
	}


	public void setPanelNewDem(boolean panelNewDem) {
		this.panelNewDem = panelNewDem;
	}


	public boolean isPanelAncienDem() {
		return panelAncienDem;
	}


	public void setPanelAncienDem(boolean panelAncienDem) {
		this.panelAncienDem = panelAncienDem;
	}


	public boolean isPanelChoixDem() {
		return panelChoixDem;
	}


	public void setPanelChoixDem(boolean panelChoixDem) {
		this.panelChoixDem = panelChoixDem;
	}


	public boolean isPanelCodeAvis() {
		return panelCodeAvis;
	}


	public void setPanelCodeAvis(boolean panelCodeAvis) {
		this.panelCodeAvis = panelCodeAvis;
	}


	public List<VAvisAppelOffreAno> getListeAvisAppelOffreDmp() {
		return listeAvisAppelOffreDmp;
	}


	public void setListeAvisAppelOffreDmp(List<VAvisAppelOffreAno> listeAvisAppelOffreDmp) {
		this.listeAvisAppelOffreDmp = listeAvisAppelOffreDmp;
	}
	
	public List<TDemande> getDemandeListe() {
		return demandeListe;
	}


	public void setDemandeListe(List<TDemande> demandeListe) {
		this.demandeListe = demandeListe;
	}


	public List<VMotifAno> getListeMotifs() {
		return listeMotifs;
	}


	public void setListeMotifs(List<VMotifAno> listeMotifs) {
		this.listeMotifs = listeMotifs;
	}


	public long getMtfNum() {
		return mtfNum;
	}


	public void setMtfNum(long mtfNum) {
		this.mtfNum = mtfNum;
	}


	public List<VLotCandidatAnoPrequalif> getListeEntreprise() {
		return listeEntreprise;
	}


	public void setListeEntreprise(List<VLotCandidatAnoPrequalif> listeEntreprise) {
		this.listeEntreprise = listeEntreprise;
	}


	public String getSouNcc() {
		return souNcc;
	}


	public void setSouNcc(String souNcc) {
		this.souNcc = souNcc;
	}


	public VbObservations getNewObs() {
		return newObs;
	}


	public void setNewObs(VbObservations newObs) {
		this.newObs = newObs;
	}

	public VObservationAno getSltObservation() {
		return sltObservation;
	}


	public void setSltObservation(VObservationAno sltObservation) {
		this.sltObservation = sltObservation;
	}


	public List<TObservations> getListeObservation() {
		return listeObservation;
	}


	public void setListeObservation(List<TObservations> listeObservation) {
		this.listeObservation = listeObservation;
	}


	public TObservations getSupObs() {
		return supObs;
	}


	public void setSupObs(TObservations supObs) {
		this.supObs = supObs;
	}


	public List<VObservationAno> getObservations() {
		return observations;
	}


	public void setObservations(List<VObservationAno> observations) {
		this.observations = observations;
	}


	public List<VLotNumerotation> getListeLotNumerotation() {
		return listeLotNumerotation;
	}


	public void setListeLotNumerotation(List<VLotNumerotation> listeLotNumerotation) {
		this.listeLotNumerotation = listeLotNumerotation;
	}


	public List<VLotNumerotation> getSelectionLotNumerotation() {
		return selectionLotNumerotation;
	}


	public void setSelectionLotNumerotation(List<VLotNumerotation> selectionLotNumerotation) {
		this.selectionLotNumerotation = selectionLotNumerotation;
	}


	public List<VAvisAppelOffreAnodmp> getListeDemandeTraiteDmp() {
		return listeDemandeTraiteDmp;
	}


	public void setListeDemandeTraiteDmp(List<VAvisAppelOffreAnodmp> listeDemandeTraiteDmp) {
		this.listeDemandeTraiteDmp = listeDemandeTraiteDmp;
	}


	public List<VAnodmpTraite> getListeDemandeAnoTratite() {
		return listeDemandeAnoTratite;
	}


	public void setListeDemandeAnoTratite(List<VAnodmpTraite> listeDemandeAnoTratite) {
		this.listeDemandeAnoTratite = listeDemandeAnoTratite;
	}


	public VAnodmpTraite getDetailDem() {
		return detailDem;
	}


	public void setDetailDem(VAnodmpTraite detailDem) {
		this.detailDem = detailDem;
	}

	
}
