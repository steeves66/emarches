package com.sndi.controller.commun;

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
import com.sndi.model.TDetOffres;
import com.sndi.model.TDetailPlanGeneral;
import com.sndi.model.TDetailVente;
import com.sndi.model.TDossierMbr;
import com.sndi.model.TDossierPlanGeneral;
import com.sndi.model.TFinancementPgpm;
import com.sndi.model.TFonction;
import com.sndi.model.THistoAgpm;
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
import com.sndi.model.VCritereAnalyseDacOfftec;
import com.sndi.model.VDacMembre;
import com.sndi.model.VDetCommissionSeance;
import com.sndi.model.VDetOffreAnalyse;
import com.sndi.model.VDetOffreNonRecevable;
import com.sndi.model.VDetOffreRecevable;
import com.sndi.model.VDetailOffres;
import com.sndi.model.VDofTyp;
import com.sndi.model.VFonctionMinistere;
import com.sndi.model.VListePieceOffre;
import com.sndi.model.VListeSouOffBasse;
import com.sndi.model.VListeSouOffEleve;
import com.sndi.model.VLot;
import com.sndi.model.VLotAnalyse;
import com.sndi.model.VLotAnalyse;
import com.sndi.model.VLotCandidat;
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
import com.sndi.model.VVerifOffin;
import com.sndi.model.VbAnalyseOffre;
import com.sndi.model.VbCommissionSpecifique;
import com.sndi.model.VbDetCritAnalyseDac;
import com.sndi.model.VbDetOffresSaisi;
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
public class ReeditionController {
	Logger _logger = Logger.getLogger(ReeditionController.class);
	
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
	 }
	 
	 //Déclaration des liste
	 private List<VReeditCojo> listeReeditCojo = new ArrayList<VReeditCojo>();
	 
	 //Déclaration des Objets
	 private VReeditCojo reeditAvis = new VReeditCojo();
	 
	 //Déclaration des variables
	 private long agpId =0;
	 private String numAvis ="";
	 private String dacCode ="";
	 
///////////////////////////////////////////////DEBUT AGPM /////////////////////////////////////////////////
	 public void reeditionAgpm() {
		 if(agpId==0) {
			 FacesContext.getCurrentInstance().addMessage(null, 
					 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez Saisir le numero de l'AGPM SVP", "")); 
		 }else
		 {
			 projetReport.longparam1(agpId, "Agpm", "Agpm"); 
			 _logger.info("agpId : "  +""+agpId);	 
		 }
		  
	 }
	 
	 
/////////////////////////////////////////////// FIN AGPM /////////////////////////////////////////////////
	 
/////////////////////////////////////////////// DEBUT TRAVAUX EN COMMISSION /////////////////////////////////////////////////
	 
		//Edition du Rapport d'analyse
		 public void reediterFicheOffre() { 
			 if(numAvis.equalsIgnoreCase("") && dacCode.equalsIgnoreCase("")) {
				 FacesContext.getCurrentInstance().addMessage(null,
						 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez Saisir l'un des champs SVP", ""));
			 }else {
				 if (dacCode.equalsIgnoreCase("")) {
					 editPv("AAO_CODE",numAvis,"Rapport_ana","Rapport_ana"); 
				 }else
					 if (numAvis.equalsIgnoreCase("")) {
						 editPv("AAO_DAC_CODE",dacCode,"Rapport_ana","Rapport_ana"); 
						 
					 } 
				 
			 }
			
		 }
		 
		//Edition du Rapport d'analyse
		 public void reediterRpAnalyse() {
			 if(numAvis.equalsIgnoreCase("") && dacCode.equalsIgnoreCase("")) {
				 FacesContext.getCurrentInstance().addMessage(null,
						 new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez Saisir l'un des champs SVP", ""));
			 }else {
				 
				 if (dacCode.equalsIgnoreCase("")) {
					 editPv("AAO_CODE",numAvis,"rapport_analyse","rapport_analyse"); 
				 }else
					 if (numAvis.equalsIgnoreCase("")) {
						 editPv("AAO_DAC_CODE",dacCode,"rapport_analyse","rapport_analyse"); 
						 
					 } 
			 }
		 }
		 
		 
		 //Methode a appeller pour editer les pv 
		 public void editPv(String colonne,String code, String jrxName , String jasperName) {
			 listeReeditCojo.clear();
			 listeReeditCojo = ((List<VReeditCojo>)iservice.getObjectsByColumn("VReeditCojo",
					 new WhereClause(""+colonne,WhereClause.Comparateur.EQ,""+code)));
						if (!listeReeditCojo.isEmpty()) {
							reeditAvis=listeReeditCojo.get(0);
							 projetReport.stringparam1(""+reeditAvis.getAaoCode(), ""+jrxName, ""+jasperName);
							 _logger.info("aaoCode : "  +""+reeditAvis.getAaoCode()); 
						}else {
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce numero d'avis d'appel d'offre n'existe pas! ", "")); 	 
						} 
		 }
		 
/////////////////////////////////////////////// FIN TRAVAUX EN COMMISSION /////////////////////////////////////////////////		 
		 public String renderPage(String value ,String action) throws IOException{ 
			 controleController.redirectionDynamicProcedures(action);
			     switch(value) {
					case "reed":
						break;
				    }
			    return userController.renderPage(value);   
			    
			}



		public List<VReeditCojo> getListeReeditCojo() {
			return listeReeditCojo;
		}



		public void setListeReeditCojo(List<VReeditCojo> listeReeditCojo) {
			this.listeReeditCojo = listeReeditCojo;
		}



		public VReeditCojo getReeditAvis() {
			return reeditAvis;
		}



		public void setReeditAvis(VReeditCojo reeditAvis) {
			this.reeditAvis = reeditAvis;
		}



		public String getNumAvis() {
			return numAvis;
		}



		public void setNumAvis(String numAvis) {
			this.numAvis = numAvis;
		}



		public String getDacCode() {
			return dacCode;
		}



		public void setDacCode(String dacCode) {
			this.dacCode = dacCode;
		}

		public long getAgpId() {
			return agpId;
		}

		public void setAgpId(long agpId) {
			this.agpId = agpId;
		}
		 
		 

}
