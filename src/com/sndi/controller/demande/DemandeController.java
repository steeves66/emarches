package com.sndi.controller.demande;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TDemande;
import com.sndi.model.TDetailDemandes;
import com.sndi.model.THistoDemande;
import com.sndi.model.TStatut;
import com.sndi.model.TTypeDemande;
import com.sndi.model.VDaoDemande;
import com.sndi.model.VLigneImputation;
import com.sndi.model.VPpmDao;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class DemandeController {
	Logger _logger = Logger.getLogger(DemandeController.class);
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	KeyGen keyGen;
	 @Autowired
	ProjetReport projetReport;
	 @Autowired
	FileUploadController fileUploadController;
	 
	 @Autowired
	 DownloadFileServlet downloadFileServlet;
	@Autowired
	ControleController controleController;
	
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
	 }
	 
	 //Déclaration des listes
	 private List<TDemande> listeDemandes = new ArrayList<TDemande>();
	 private List<TTypeDemande> listeTypeDemandes = new ArrayList<TTypeDemande>();
	 private List<VDaoDemande> listeDao = new ArrayList<VDaoDemande>();
	 private List<VDaoDemande> selectionligneDao = new ArrayList<VDaoDemande>();
	 private List<VPpmDao> listePPM = new ArrayList<VPpmDao>();
	 private List<VPpmDao> selectionlignePPM = new ArrayList<VPpmDao>();
	 private List<VLigneImputation> listeLigneBugetaire = new ArrayList<VLigneImputation>();
	 private List<VLigneImputation> selectionligneBugetaire = new ArrayList<VLigneImputation>();
	 
	 
	 //Déclaration des Objets
	 private TDemande newDem = new TDemande();
	 private TDemande slctdTd = new TDemande();
	 private VDaoDemande dao = new VDaoDemande();
	 
	
	//Déclaration des Variables
	 private String tdmCode ="";
	 private short demGesCode;
	 private boolean panelRestreint =false;
	 private boolean panelGreAgre =false;
	 private boolean panelAvenant =false;
	 
	 public String onFlowProcess(FlowEvent event) throws IOException {
		 System.out.println("etape old= "+event.getOldStep()+" New= "+event.getNewStep());
		 return event.getNewStep();
	    }
	 
	 
	 
	 //Methode de chargement des types de demande
	 public void chargeTypeDemande() {
		 listeTypeDemandes.clear();
		/* listeTypeDemandes = (List<TTypeDemande>) iservice.getObjectsByColumn("TTypeDemande", new ArrayList<String>(Arrays.asList("TDM_LIBELLE")));
		_logger.info("listeTypeDemandes size: "+listeTypeDemandes.size());*/
		
		listeTypeDemandes = (List<TTypeDemande>) iservice.getObjectsByColumnIn("TTypeDemande", new ArrayList<String>(Arrays.asList("TDM_LIBELLE")),
				"TDM_CODE", new ArrayList<String>(Arrays.asList("AOR","GAG","AVE")),
               new WhereClause("TDM_CODE",WhereClause.Comparateur.NEQ,"PSL"));
		_logger.info("listeTypeDemandes size: "+listeTypeDemandes.size());
		
	 }
	 //Methode de chargement 
	 public void chargeListBytype() {
		 if(tdmCode.equalsIgnoreCase("AOR")) {
			 panelRestreint =true;
			 panelGreAgre =false;
			 panelAvenant =false; 
			 chargeDao();
		 }else
			 if(tdmCode.equalsIgnoreCase("GAG")) {
				 panelRestreint =false;
				 panelGreAgre =true;
				 panelAvenant =false;  
				 chargePPM();
			 }else
				 if(tdmCode.equalsIgnoreCase("AVE")) {
					 panelRestreint =false;
					 panelGreAgre =false;
					 panelAvenant =true;
					 chargeLigneBugetaire();
				 }
	 }
	 
	 public void saveDemande() {
		 newDem.setDemDteSaisi(Calendar.getInstance().getTime());
		 newDem.setDemGesCode(demGesCode);
		 newDem.setDemStatutRetour("0");
		 newDem.setTFonction(userController.getSlctd().getTFonction());
		 newDem.setTOperateur(userController.getSlctd().getTOperateur());
		 newDem.setTStatut(new TStatut("E1S"));
		 newDem.setTStructure(userController.getSlctd().getTFonction().getTStructure());
		 newDem.setTTypeDemande(new TTypeDemande(tdmCode));
		 iservice.addObject(newDem);
		 
		 //Enregistrement des details demande en fonction du type demande selctionnée
		 if(tdmCode.equalsIgnoreCase("AOR")) {
			 saveDao(); 
		 }else
			 if(tdmCode.equalsIgnoreCase("GAG")) {
				 savePPM();
			 }else
				 if(tdmCode.equalsIgnoreCase("AVE")) {
					 saveLigneBugetaire(); 
				 }
		 
		 //Historisation de la demande dans THistoDemande
		 historiser(""+newDem.getTStatut().getStaCode());
				
		 userController.setTexteMsg("Enregistrement effectué avec succès!");
		 userController.setRenderMsg(true);
		 userController.setSevrityMsg("success");
	 }
	 
	 //Methode d'historisation
	 public void historiser(String statut) {
		 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,""+statut));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			THistoDemande histoDem = new THistoDemande();
			histoDem.setHdmDteSaisi(Calendar.getInstance().getTime());
			histoDem.setTDemande(newDem);
			histoDem.setTFonction(userController.getSlctd().getTFonction());
			histoDem.setTOperateur(userController.getSlctd().getTOperateur());
			histoDem.setTStatut(statuts);
			iservice.addObject(histoDem);
	 }
	 
	 //Liste des dao aselectionner
	 public void chargeDao() {
		 listeDao.clear();
		 listeDao = (List<VDaoDemande>) iservice.getObjectsByColumn("VDaoDemande", new ArrayList<String>(Arrays.asList("DAC_DTE_SAISI")));
			_logger.info("listeDao size: "+listeDao.size());
	 }
	 
	 //Liste des PPM a selectionner
	 public void chargePPM() {
		 listePPM.clear();
		 listePPM = (List<VPpmDao>) iservice.getObjectsByColumn("VPpmDao", new ArrayList<String>(Arrays.asList("DPP_ID")));
			_logger.info("listePPM size: "+listePPM.size());
	 }
	 
	 //Liste des ligne budgétaire a selectionner
	 public void chargeLigneBugetaire() {
		 listeLigneBugetaire.clear();
		 listeLigneBugetaire = (List<VLigneImputation>) iservice.getObjectsByColumn("VLigneImputation", new ArrayList<String>(Arrays.asList("LBG_CODE")),
				 new WhereClause("LBG_FON_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
			_logger.info("listeLigneBugetaire size: "+listeLigneBugetaire.size());
	 }
	  
	 
	 // Methode d'enregistrement des DAO selectopnné
	 public void saveDao() {
		 if (selectionligneDao.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune opération selectionnée", ""));
			}else {
				for(VDaoDemande ligneDao : selectionligneDao) {
					TDetailDemandes demDet = new TDetailDemandes();
					demDet.setTDemande(newDem);
					demDet.setTDacSpecs(ligneDao.getDacCode());
					demDet.setDdeActNumIni(ligneDao.getDacFonCodAc());
					demDet.setDdeActNum(userController.getSlctd().getTFonction().getFonCod());
					demDet.setTStructure(userController.getSlctd().getTFonction().getTStructure());
					iservice.addObject(demDet);
				}
			}
	 }
	 
	// Methode d'enregistrement des PPM selectopnné
		 public void savePPM() {
			 if (selectionlignePPM.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun planning selectionné", ""));
				}else {
					for(VPpmDao lignePpm : selectionlignePPM) {
						TDetailDemandes demDet = new TDetailDemandes();
						demDet.setTDemande(newDem);
						//demDet.setDdeMarCode(lignePpm.getDppId());
						demDet.setDdeActNumIni(lignePpm.getDppActeurSaisie());
						demDet.setDdeActNum(userController.getSlctd().getTFonction().getFonCod());
						demDet.setTStructure(userController.getSlctd().getTFonction().getTStructure());
						iservice.addObject(demDet);
					}
				}
		 }
		 
		// Methode d'enregistrement des Lignes bugétaires selectopnné
				 public void saveLigneBugetaire() {
					 if (selectionligneBugetaire.size()==0) {
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune ligne bugétaire selectionnée", ""));
						}else {
							for(VLigneImputation ligneBugetaire : selectionligneBugetaire) {
								TDetailDemandes demDet = new TDetailDemandes();
								demDet.setTDemande(newDem);
								demDet.setTLBudgets(ligneBugetaire.getLbgCode());
								demDet.setDdeActNumIni(ligneBugetaire.getLbgFonCodeAc());
								demDet.setDdeActNum(userController.getSlctd().getTFonction().getFonCod());
								demDet.setTStructure(userController.getSlctd().getTFonction().getTStructure());
								iservice.addObject(demDet);
							}
						}
				 }
	 
	 
	public String renderPage(String value ,String action) throws IOException{ 
		controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "dem1":
					tdmCode="";
					String fonct = controleController.getFonctionalite();	
					String statutAffiche = "";
					String statutDiffere = "";
					//Ramener le statut en fonction de l'utilisateur connecté et de l'action a mener
					if(fonct.equalsIgnoreCase("listSaisieAc")) {
						statutAffiche = "E1S";
						statutDiffere = "E2D";
						_logger.info("staut: "+statutAffiche);	
						_logger.info("staut: "+statutDiffere);
						_logger.info("fonctionalité: "+fonct);	
						_logger.info("value: "+value+" action: "+action);
					 }else {
						 if(fonct.equalsIgnoreCase("listValidationCpmp")) {
							 statutAffiche = "E1T";	
							 statutDiffere = "E3D";
								_logger.info("staut: "+statutAffiche);
								_logger.info("staut: "+statutDiffere);
								_logger.info("fonctionalité: "+fonct);	
								_logger.info("value: "+value+" action: "+action);
						 }else {
							 if(fonct.equalsIgnoreCase("listValidationSPD")) {
								 statutAffiche = "E2V";	
								 statutDiffere = "D2T";
									_logger.info("staut: "+statutAffiche);	
									_logger.info("staut: "+statutDiffere);
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
					chargeData(statutAffiche,statutDiffere);
					break;
				case "dem2":
					chargeTypeDemande();
					chargeListBytype();
				break;
				case "dem3":
				break;
				
				case "dem4":
					break;

			    }
		     
		    return userController.renderPage(value);
		}
	//methode Chargement de la liste des demandes
	public void chargeData(String statutAffiche, String statutDiffere) {
		listeDemandes.clear();	
		listeDemandes = (List<TDemande>) iservice.getObjectsByColumnInDesc("TDemande", new ArrayList<String>(Arrays.asList("DEM_DTE_SAISI")),
				"DEM_STA_CODE", new ArrayList<String>(Arrays.asList(""+statutAffiche,""+statutDiffere)),
				//new WhereClause("DEM_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
               new WhereClause("DEM_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	}
	
	
	public void valider() {
		String statUpdate = "";
		String message = "";
		if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E1S")) {
			statUpdate = "E1T";
			message="Transmission de la démande N°"+slctdTd.getDemNum()+"éffectuée avec succès";
			chargeData("E1T","E2D");
			
		 }else {
			 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E1T")) {
					statUpdate = "E2V";
					chargeData("E2V","E3D");
					message="Prévalidation de la démande N°"+slctdTd.getDemNum()+"éffectuée avec succès";
			 }else {
				 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E2V")) {
					 statUpdate = "E3V";
					 chargeData("E3V","E3V");
					 message="Validation de la démande N°"+slctdTd.getDemNum()+"éffectuée avec succès";
				 }else {
					 
				 }	 
			 }

		 }
		
		slctdTd.setTStatut(new TStatut(statUpdate));	
		iservice.updateObject(slctdTd);
		historiser(statUpdate);
		userController.setTexteMsg(message);
		userController.setRenderMsg(true);
		userController.setSevrityMsg("success");
		
	}

	public List<TDemande> getListeDemandes() {
		return listeDemandes;
	}

	public void setListeDemandes(List<TDemande> listeDemandes) {
		this.listeDemandes = listeDemandes;
	}
	public TDemande getSlctdTd() {
		return slctdTd;
	}
	public void setSlctdTd(TDemande slctdTd) {
		this.slctdTd = slctdTd;
	}

	public List<TTypeDemande> getListeTypeDemandes() {
		return listeTypeDemandes;
	}

	public void setListeTypeDemandes(List<TTypeDemande> listeTypeDemandes) {
		this.listeTypeDemandes = listeTypeDemandes;
	}

	public String getTdmCode() {
		return tdmCode;
	}

	public void setTdmCode(String tdmCode) {
		this.tdmCode = tdmCode;
	}



	public boolean isPanelRestreint() {
		return panelRestreint;
	}



	public void setPanelRestreint(boolean panelRestreint) {
		this.panelRestreint = panelRestreint;
	}



	public boolean isPanelGreAgre() {
		return panelGreAgre;
	}



	public void setPanelGreAgre(boolean panelGreAgre) {
		this.panelGreAgre = panelGreAgre;
	}



	public boolean isPanelAvenant() {
		return panelAvenant;
	}



	public void setPanelAvenant(boolean panelAvenant) {
		this.panelAvenant = panelAvenant;
	}



	public TDemande getNewDem() {
		return newDem;
	}



	public void setNewDem(TDemande newDem) {
		this.newDem = newDem;
	}



	public short getDemGesCode() {
		return demGesCode;
	}



	public void setDemGesCode(short demGesCode) {
		this.demGesCode = demGesCode;
	}



	public List<VDaoDemande> getListeDao() {
		return listeDao;
	}



	public void setListeDao(List<VDaoDemande> listeDao) {
		this.listeDao = listeDao;
	}



	public VDaoDemande getDao() {
		return dao;
	}



	public void setDao(VDaoDemande dao) {
		this.dao = dao;
	}



	public List<VDaoDemande> getSelectionligneDao() {
		return selectionligneDao;
	}



	public void setSelectionligneDao(List<VDaoDemande> selectionligneDao) {
		this.selectionligneDao = selectionligneDao;
	}



	public List<VPpmDao> getListePPM() {
		return listePPM;
	}



	public void setListePPM(List<VPpmDao> listePPM) {
		this.listePPM = listePPM;
	}



	public List<VPpmDao> getSelectionlignePPM() {
		return selectionlignePPM;
	}



	public void setSelectionlignePPM(List<VPpmDao> selectionlignePPM) {
		this.selectionlignePPM = selectionlignePPM;
	}



	public List<VLigneImputation> getListeLigneBugetaire() {
		return listeLigneBugetaire;
	}



	public void setListeLigneBugetaire(List<VLigneImputation> listeLigneBugetaire) {
		this.listeLigneBugetaire = listeLigneBugetaire;
	}



	public List<VLigneImputation> getSelectionligneBugetaire() {
		return selectionligneBugetaire;
	}



	public void setSelectionligneBugetaire(List<VLigneImputation> selectionligneBugetaire) {
		this.selectionligneBugetaire = selectionligneBugetaire;
	}


}
