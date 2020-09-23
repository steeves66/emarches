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
	 
	 
	 //liste
	 private List<VAvisAppelOffreAno> listeAvisAppelOffre = new ArrayList<VAvisAppelOffreAno>();
	 private List<VNatureDocAno> natureDocListe = new ArrayList<VNatureDocAno>();
	 private List<VLotAvisdmp> listeLots = new ArrayList<VLotAvisdmp>();
	 private List<VHistoDemandeAno> listeHistoDemandeAno = new ArrayList<VHistoDemandeAno>();
	 
	 //Objet
	 private VAvisAppelOffreAno slctdTd = new VAvisAppelOffreAno();
	 private VbTempParamAvis newTempAvis = new VbTempParamAvis();
	 private TDemande newDem = new TDemande();
	 private VLotAvisdmp sltLot = new VLotAvisdmp();
	 private VHistoDemandeAno sltHistoDem = new VHistoDemandeAno();
	 private boolean btn_Oui;
	 private boolean btn_non;
	 private boolean resultat;
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
		//chargeData();
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
		 iservice.addObject(newDem);
		 
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
	
		  
			List<TAvisAppelOffre> LS  = iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
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
					    		  
					    		  listeAvisAppelOffre = (List<VAvisAppelOffreAno>) iservice.getObjectsByColumnDesc("VAvisAppelOffreAno", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
									         new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,""+statut),
									         new WhereClause(""+colonneAno,WhereClause.Comparateur.EQ,"O"));
									_logger.info("listeAppelOffre size: "+listeAvisAppelOffre.size());	
					      }
	      }
	 
		//Liste des lot d'un avis d'avis d'appel d'offre
	 public void chargeLot() {
		 listeLots.clear();
		 listeLots=(List<VLotAvisdmp>) iservice.getObjectsByColumn("VLotAvisdmp", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
		_logger.info("listeLots size: "+listeLots.size());
	 }
	 
	 public void chargeNatureDocData() {
		 natureDocListe.clear();
			natureDocListe=(List<VNatureDocAno>) iservice.getObjectsByColumn("VNatureDocAno");
		}
	 
	 public void saveAno() {
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
	 public void upload(FileUploadEvent event) throws java.io.FileNotFoundException{
	      
		 if((docNature == null || "".equals(docNature))){
			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nature non sélectionnée pour le chargement! ","");
 			FacesContext.getCurrentInstance().addMessage(null, msg);	
			 
			 }else {
		
				 if(fileUploadController.handleFileUpload(event,slctdTd.getAaoCode(), docNature)) {

						//int nat = Integer.valueOf(docNature);
						
						Short natureDoc = Short.valueOf(docNature);
						//check le dossier s'il existe à faire
						TDossierAao dos =new TDossierAao(); //TNatureDocuments
						//dos.setDosCode(keyGen.getCodeDossierArchi(fileUploadController.getFileCode()+"-"));
						dos.setDaaAaoCode(slctdTd.getAaoCode());
					/*	List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
						TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
						if(!LS.isEmpty()) natureDoc = LS.get(0);*/
						dos.setTNatureDocuments(new TNatureDocuments(natureDoc));
						dos.setDaaDteSaisi(Calendar.getInstance().getTime());
						dos.setDaaNom(fileUploadController.getFileName());
						dos.setDaaLibelle(fileUploadController.getDocNom());
						 iservice.addObject(dos);
						 
						 
					/*		int nat = Integer.valueOf(docNature);
							//check le dossier s'il existe Ã  faire
							TDossierAao dos =new TDossierAao(); //TDossiersDacs
							//dos.setDdaCommentaire(keyGen.getCodeDossier(fileUploadController.getFileCode()+"-")); 
							dos.setDaaAaoCode(slctdTd.getAaoCode());
							List<TNatureDocuments> LS  = iservice.getObjectsByColumn("TNatureDocuments", new WhereClause("NAD_CODE",Comparateur.EQ,""+nat));
							TNatureDocuments natureDoc = new TNatureDocuments((short)nat);
							if(!LS.isEmpty()) natureDoc = LS.get(0);
							dos.setTNatureDocuments(natureDoc);
							dos.setDaaNom(fileUploadController.getFileName());
							dos.setDaaDteSaisi(Calendar.getInstance().getTime());
							dos.setDaaReference(fileUploadController.getDocNom());
							iservice.addObject(dos);
							*/
						 chargeNatureDocData();
						
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Document enregistré!", "");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					  // chargeDossier();
				
					   
					}//fin de la copie et de l'enregistrement
					else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Document non enregistré, charger à nouveau un document ! ","");
						FacesContext.getCurrentInstance().addMessage(null, msg);	
					}
				}
	 			
	 }
	
	 
	//Methode de récupération de t_pgpm dans t_affichage
	 public void recupInfosDemande() {
	    			List<TDemande> LS  = iservice.getObjectsByColumn("TDemande", new WhereClause("DEM_AAO_CODE",Comparateur.EQ,""+slctdTd.getAaoCode()));
	    			if(!LS.isEmpty()) newDem = LS.get(0);
	    			//demande.getDemObjet();
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
					chargeNatureDocData();
				break;
				case "ano3":
					chargeLot();
					recupInfosDemande();
					btnAction();
					chargeDemande();
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


	public List<VNatureDocAno> getNatureDocListe() {
		return natureDocListe;
	}


	public void setNatureDocListe(List<VNatureDocAno> natureDocListe) {
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


	
}
