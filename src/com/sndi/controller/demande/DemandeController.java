package com.sndi.controller.demande;

import java.io.IOException;
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
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAgpm;
import com.sndi.model.TAvisPresel;
import com.sndi.model.TDemande;
import com.sndi.model.TDetailDemandes;
import com.sndi.model.TDetailPlanGeneral;
import com.sndi.model.TDossierAgpm;
import com.sndi.model.TDossierDemande;
import com.sndi.model.TDossierPlanGeneral;
import com.sndi.model.THistoDemande;
import com.sndi.model.TNatureDocuments;
import com.sndi.model.TNaturePiece;
import com.sndi.model.TParamPieceDemande;
import com.sndi.model.TPieceDemande;
import com.sndi.model.TSoumissions;
import com.sndi.model.TStatut;
import com.sndi.model.TTypeDemande;
import com.sndi.model.VAgpmStatut;
import com.sndi.model.VDaoDemande;
import com.sndi.model.VDetailDemande;
import com.sndi.model.VLigneImputation;
import com.sndi.model.VMotifRetourDemande;
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
	 private List<VMotifRetourDemande> listeMotifs = new ArrayList<VMotifRetourDemande>();
	 private List<TSoumissions> listeEntreprises= new ArrayList<TSoumissions>();
	 private List<TSoumissions> selectionEntreprises= new ArrayList<TSoumissions>();
	 private List<TParamPieceDemande> listePieces= new ArrayList<TParamPieceDemande>();
	 private List<TParamPieceDemande> selectionPieces= new ArrayList<TParamPieceDemande>();
	 private List<VDetailDemande> listeDetails= new ArrayList<VDetailDemande>();
	 private List<String> repeat = new ArrayList<String>();
	 
	 private List<TPieceDemande> listePiecesDemande= new ArrayList<TPieceDemande>();
	 private List<TPieceDemande> listePiecesDem= new ArrayList<TPieceDemande>();
	 
	 
	 
	 
	 //Déclaration des Objets
	 private TDemande newDem = new TDemande();
	 private TDemande slctdTd = new TDemande();
	 private TSoumissions newSoum = new TSoumissions();
	 private VMotifRetourDemande motif = new VMotifRetourDemande();
	 private TParamPieceDemande newPiece = new TParamPieceDemande();
	 
	
	//Déclaration des Variables
	 private String tdmCode ="";
	 private short demGesCode;
	 private boolean panelRestreint =false;
	 private boolean panelGreAgre =false;
	 private boolean panelAvenant =false;
	 private boolean panelVerrouillage =false;
	 private boolean panelClarification =false;
	 private boolean panelEclaissisement =false;
	 private boolean panelLigneBudgetaire =false;
	 private boolean panelEntreprise =false;
	 private boolean panelAutre =false;
	 private String observation="";
	 private Long numPiece;
	 private long pdmNum;
	 
	 private Boolean boutonAdd=true;
	 private Boolean boutonSupp=false;
	 
	// private Long natPiece ;
	 public String onFlowProcess(FlowEvent event) throws IOException {
		 System.out.println("etape old= "+event.getOldStep()+" New= "+event.getNewStep());
		 
		//Controle Pavé création
		 if(event.getOldStep().equals("demande") && event.getNewStep().equals("autres")) {
			 /*if(selectionligneDao.size()==0)
			 {
            	  FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR, ""
							+ "Aucun Dao selectionné!", ""));
		          return "demande";
				} else
					 if(selectionligneDao.size()>1) {
						 FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vous pouvez selectionner q'un seul DAO", ""));
						 return "demande";
					 }*/

			 userController.initMessage();
		     }
		 
		 return event.getNewStep();
	    }
	 
	 public void add() {
		 repeat.add("a");
			setBoutonSupp(true);
		}
		public void supp() {
				int i=repeat.size();
				int posit=i-1;
				repeat.remove(posit);		
			}
	 
	 
	 
	 //Methode de chargement des types de demande
	 public void chargeTypeDemande() {
		 listeTypeDemandes.clear();
		/* listeTypeDemandes = (List<TTypeDemande>) iservice.getObjectsByColumn("TTypeDemande", new ArrayList<String>(Arrays.asList("TDM_LIBELLE")));
		_logger.info("listeTypeDemandes size: "+listeTypeDemandes.size());*/
		
		listeTypeDemandes = (List<TTypeDemande>) iservice.getObjectsByColumnIn("TTypeDemande", new ArrayList<String>(Arrays.asList("TDM_LIBELLE")),
				"TDM_CODE", new ArrayList<String>(Arrays.asList("AOR","GAG")),
               new WhereClause("TDM_CODE",WhereClause.Comparateur.NEQ,"PSL"));
		_logger.info("listeTypeDemandes size: "+listeTypeDemandes.size());
		
	 }
	 
	 //Liste des entreprises
	 public void chargeEntreprses() {
		 listeEntreprises.clear();
		 listeEntreprises = (List<TSoumissions>) iservice.getObjectsByColumn("TSoumissions", new ArrayList<String>(Arrays.asList("SOU_NOM_COM")));
		_logger.info("listeEntreprises size: "+listeEntreprises.size());
		 
	 }
	 //Methode de chargement 
	 public void chargeListBytype() {
		 if(tdmCode.equalsIgnoreCase("AOR")) {
			 panelRestreint =true;
			 panelGreAgre =false;
			 panelAvenant =false; 
			 panelVerrouillage =false;
			 panelClarification =false;
			 panelEclaissisement =false;
			 panelLigneBudgetaire =false;
			 panelEntreprise = true;
			 chargeDao();
			 chargeEntreprses();
		 }else
			 if(tdmCode.equalsIgnoreCase("GAG")) {
				 panelRestreint =false;
				 panelGreAgre =true;
				 panelAvenant =false; 
				 panelClarification =false;
				 panelEclaissisement =false;
				 panelLigneBudgetaire =false;
				 panelEntreprise = true;
				 chargePPM();
				 chargeEntreprses();
			 }else
				 if(tdmCode.equalsIgnoreCase("AVE")) {
					 panelRestreint =false;
					 panelGreAgre =false;
					 panelAvenant =true;
					 panelEclaissisement =false;
					 panelLigneBudgetaire =false;
					 panelEntreprise = false;
					 
				 }else
					 if(tdmCode.equalsIgnoreCase("LBG")) {
						 panelRestreint =false;
						 panelGreAgre =false;
						 panelAvenant =false; 
						 panelClarification =false;
						 panelEclaissisement =false;
						 panelLigneBudgetaire =true;
						 panelEntreprise = false;
						 chargeLigneBugetaire();
					 }else
						 if(tdmCode.equalsIgnoreCase("CLA")) {
							 panelRestreint =false;
							 panelGreAgre =false;
							 panelAvenant =false; 
							 panelClarification =true;
							 panelEclaissisement =false;
							 panelLigneBudgetaire =false;
							 panelEntreprise = false;
							 chargePPM();
						 }else
							 if(tdmCode.equalsIgnoreCase("ECL")) {
								 panelRestreint =false;
								 panelGreAgre =false;
								 panelAvenant =false;
								 panelClarification =false;
								 panelEclaissisement =true;
								 panelLigneBudgetaire =false;
								 panelEntreprise = false;
								 chargeLigneBugetaire();
							 }else {
								 panelRestreint =false;
								 panelGreAgre =false;
								 panelAvenant =false;
								 panelClarification =false;
								 panelEclaissisement =false;
								 panelLigneBudgetaire =false; 
								 panelEntreprise = false;
							 }
		 chargePieces();
	 }
	 
	 public void saveDemande() {
		 newDem.setDemDteSaisi(Calendar.getInstance().getTime());
		 newDem.setDemGesCode(demGesCode);
		 newDem.setDemStatutRetour("0");
		 newDem.setTFonction(userController.getSlctd().getTFonction());
		 newDem.setTOperateur(userController.getSlctd().getTOperateur());
		 newDem.setTStatut(new TStatut("E1S"));
		 newDem.setTStructure(userController.getSlctd().getTFonction().getTStructure());
		 newDem.setDemFonCodePf(userController.getSlctd().getTFonction().getFonCodePf());
		 newDem.setDemFonCodeDmp(userController.getSlctd().getTFonction().getFonCodeDmp());
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
		//Enregistrement des pièces de la demande		 
		 savePieces();
		 //Historisation de la demande dans THistoDemande
		 historiser(""+newDem.getTStatut().getStaCode(),newDem);
		 vider();	
		 userController.setTexteMsg("Enregistrement effectué avec succès!");
		 userController.setRenderMsg(true);
		 userController.setSevrityMsg("success");
	 }
	 
	 //Methode d'historisation
	 public void historiser(String statut,TDemande demande) {
		 List<TStatut> LS  = iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",Comparateur.EQ,""+statut));
			TStatut statuts = new TStatut();
			if(!LS.isEmpty()) statuts = LS.get(0);
			THistoDemande histoDem = new THistoDemande();
			histoDem.setHdmDteSaisi(Calendar.getInstance().getTime());
			histoDem.setHdmMotif(getObservation());
			histoDem.setTDemande(demande);
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
	 
	 // Methode d'enregistrement des pièces
	 public void savePieces() {
		 if (selectionPieces.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune pièce selectionnée", ""));
			}else {
				for(TParamPieceDemande ligne : selectionPieces) {
					TPieceDemande newPiece = new TPieceDemande();
					newPiece.setTDemande(newDem);
					newPiece.setTParamPieceDemande(ligne.getPidNum());
					newPiece.setPdmLibeleCourt(ligne.getPidLibeleCourt());
					newPiece.setPdmLibeleLong(ligne.getPidLibeleLong());
					iservice.addObject(newPiece);
				}
			}
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
		//Entreprise
		 saveEntrepsise();
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
			//Entreprise
			 saveEntrepsise();
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
	 
				 
		public void saveEntrepsise() {
			 //Enregistement des Entreprises dans t_soumission
			 if (selectionEntreprises.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucune entreprise selectionnée", ""));
				}else {
					for(TSoumissions entreprise : selectionEntreprises) {
						TAvisPresel newPresel = new TAvisPresel();
						newPresel.setTDemande(newDem);
						newPresel.setAprDteSaisi(Calendar.getInstance().getTime());
						newPresel.setTSoumissions(newPresel.getTSoumissions());
						//newPresel.setAprDetailInvit(entreprise.getSouTel()+" "+entreprise.getSouAdresse());
						newPresel.setTOperateurByAprOpeMatricule(userController.getSlctd().getTOperateur());
						iservice.addObject(newPresel);
					}
				}
		}
		
		//Liste des pièces
		public void chargePieces() {
             listePieces.clear();
			 listePieces = (List<TParamPieceDemande>) iservice.getObjectsByColumn("TParamPieceDemande", new ArrayList<String>(Arrays.asList("PID_LIBELE_LONG")),
					 new WhereClause("PID_TDM_CODE",WhereClause.Comparateur.EQ,""+tdmCode));
				_logger.info("listePieces size: "+listePieces.size());
		}
		
		
		
		
				 public void vider() {
					newDem = new TDemande();
                    selectionligneDao = new ArrayList<VDaoDemande>();
                    selectionligneDao.clear();
					selectionlignePPM = new ArrayList<VPpmDao>();
					selectionlignePPM.clear();
					selectionligneBugetaire = new ArrayList<VLigneImputation>();
					selectionligneBugetaire.clear();
					tdmCode ="";
				 }
//DEBUT ENSEMBLE DES METHODES POUR L'APERCU
				 //Liste des dao de la demande
				 public void chargeDaoApercu() {
					 listeDetails.clear();
					 listeDetails = (List<VDetailDemande>) iservice.getObjectsByColumn("VDetailDemande", new ArrayList<String>(Arrays.asList("DAC_DTE_SAISI")),
							 new WhereClause("DDE_DEM_NUM",WhereClause.Comparateur.EQ,""+slctdTd.getDemNum()));
						_logger.info("listePiecesDemande size: "+listePiecesDemande.size());
				 }
				 
				 
				//Liste des pieces de la demande
				 public void chargePiecesDemande() {
					 listePiecesDemande.clear();
					 listePiecesDemande = (List<TPieceDemande>) iservice.getObjectsByColumn("TPieceDemande", new ArrayList<String>(Arrays.asList("PDM_LIBELE_LONG")),
							 new WhereClause("PDM_DEM_NUM",WhereClause.Comparateur.EQ,""+slctdTd.getDemNum()));
						_logger.info("listePiecesDemande size: "+listePiecesDemande.size());
						chargePiecesCombobx();
				 }
				 
				//Liste pieces combobox
					public void chargePiecesCombobx() {
						listePiecesDem.clear();
						listePiecesDem = (List<TPieceDemande>) iservice.getObjectsByColumn("TPieceDemande", new ArrayList<String>(Arrays.asList("PDM_LIBELE_LONG")),
								 new WhereClause("PDM_DEM_NUM",WhereClause.Comparateur.EQ,""+slctdTd.getDemNum()));
							_logger.info("listePiecesDem size: "+listePiecesDem.size());
						
					}
//FIN ENSEMBLE DES METHODES POUR L'APERCU
				 
				//Methode Upload
				 @Transactional
				 public void upload(FileUploadEvent event) throws IOException{
						if(fileUploadController.handleFileUpload(event, slctdTd.getDemNum()+"", pdmNum)) {
								TDossierDemande dos = new TDossierDemande(); //TNatureDocument 
								//dos = new TDossierDemande() ;
								dos.setDodLibelle(fileUploadController.getFileName());
								dos.setTDemande(slctdTd);
					            dos.setDodReference(fileUploadController.getDocNom());
					            dos.setTPieceDemande(new TPieceDemande(pdmNum));
								iservice.addObject(dos);
								//chargeDossier();
								
								//Message de Confirmation
								 userController.setTexteMsg("Document enregistré!");
								 userController.setRenderMsg(true);
								 userController.setSevrityMsg("success");
							
						     }else {
						    	//Message d'erreur								 
								 FacesContext.getCurrentInstance().addMessage(null,
					    	      		  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Document non enregistré, charger à nouveau un document!", ""));
									}
					      System.out.print("num demande :"+slctdTd);
					      System.out.print("num piece :"+pdmNum);
						  }
				 
		     	 
				 
				 
	 
	public String renderPage(String value ,String action) throws IOException{ 
		controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "dem1":
					tdmCode="";
					 panelRestreint =false;
					 panelGreAgre =false;
					 panelAvenant =false;
					 panelClarification =false;
					 panelEclaissisement =false;
					 panelLigneBudgetaire =false; 
					 panelAutre =false;
					 panelEntreprise = false;
					vider();
					userController.initMessage();
					String fonct = controleController.getFonctionalite();	
					String statutAffiche = "";
					String statutDiffere = "";
					String colonneFonction ="";
					//Ramener le statut en fonction de l'utilisateur connecté et de l'action a mener
					if(fonct.equalsIgnoreCase("listSaisieAc")) {
						statutAffiche = "E1S";
						statutDiffere = "E2D";
						colonneFonction ="DEM_FON_CODE_AC";
						_logger.info("staut: "+statutAffiche);	
						_logger.info("staut: "+statutDiffere);
						_logger.info("fonctionalité: "+fonct);	
						_logger.info("value: "+value+" action: "+action);
					 }else {
						 if(fonct.equalsIgnoreCase("listValidationCpmp")) {
							 statutAffiche = "E1T";	
							 statutDiffere = "E3D";
							 colonneFonction ="DEM_FON_CODE_PF";
								_logger.info("staut: "+statutAffiche);
								_logger.info("staut: "+statutDiffere);
								_logger.info("fonctionalité: "+fonct);	
								_logger.info("value: "+value+" action: "+action);
						 }else {
							 if(fonct.equalsIgnoreCase("listValidationSPD")) {
								 statutAffiche = "E2V";	
								 statutDiffere = "E2V";
								 colonneFonction ="DEM_FON_CODE_DMP";
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
					chargeData(statutAffiche,statutDiffere,colonneFonction);
					break;
				case "dem2":
					chargeTypeDemande();
					//chargeListBytype();
					
				break;
				case "dem3":
					chargeDaoApercu();
					chargePiecesDemande();
				break;
				
				case "dem4":
					break;
					
				case "dem5":
				break;
				
				case "dem6":
					chargePiecesDemande();
					chargePiecesCombobx();
					break;
					
			    }
		     
		     
		     
		    return userController.renderPage(value);
		}
	
	//methode Chargement de la liste des demandes
	public void chargeData(String statutAffiche, String statutDiffere,String colonneFonction) {
		listeDemandes.clear();	
		listeDemandes = (List<TDemande>) iservice.getObjectsByColumnInDesc("TDemande", new ArrayList<String>(Arrays.asList("DEM_DTE_SAISI")),
				"DEM_STA_CODE", new ArrayList<String>(Arrays.asList(""+statutAffiche,""+statutDiffere)),
				new WhereClause(""+colonneFonction,WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	}
	
	
	public void valider() {
		String statUpdate = "";
		String message = "";
		if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E1S")) {
			statUpdate = "E1T";
			message="Transmission de la démande N°"+slctdTd.getDemNum()+"éffectuée avec succès";
			
		 }else {
			 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E1T")) {
					statUpdate = "E2V";
					//chargeData("E1T","E3D","DEM_FON_CODE_PF");
					message="Prévalidation de la démande N°"+slctdTd.getDemNum()+"éffectuée avec succès";
			 }else {
				 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E2V")) {
					 statUpdate = "E3V";
					 //chargeData("E2V","E3V","DEM_FON_CODE_DMP");
					 message="Validation de la démande N°"+slctdTd.getDemNum()+"éffectuée avec succès";
				 }else {
					 
				 }	 
			 }

		 }
		
		slctdTd.setTStatut(new TStatut(statUpdate));	
		iservice.updateObject(slctdTd);
		historiser(statUpdate,slctdTd);
		
		if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			chargeData("E1S","E2D","DEM_FON_CODE_AC");
		 }else {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
					chargeData("E1T","E3D","DEM_FON_CODE_PF");
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPD")) {
					chargeData("E2V","E3V","DEM_FON_CODE_DMP");
				 }	 
			 }

		 }
		userController.setTexteMsg(message);
		userController.setRenderMsg(true);
		userController.setSevrityMsg("success");
		
	}
	
	public void differe() {
		String statUpdate = "";
		String message = "";
		if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E1T")) {
					statUpdate = "E2D";
					chargeData("E1T","E3D","DEM_FON_CODE_PF");
					message="Démande N°"+slctdTd.getDemNum()+"différée avec succès";
			 }else {
				 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("E2V")) {
					 statUpdate = "E3D";
					 chargeData("E2V","E3V","DEM_FON_CODE_DMP");
					 message="Démande N°"+slctdTd.getDemNum()+"différée avec succès";
				 } 
			 }

		slctdTd.setTStatut(new TStatut(statUpdate));
		slctdTd.setDemStatutRetour("1");
		iservice.updateObject(slctdTd);
		historiser(statUpdate,slctdTd);
		userController.setTexteMsg(message);
		userController.setRenderMsg(true);
		userController.setSevrityMsg("success");
		
	}
	
	//Affichage des motifs de retour
			public void chargerObservation() {
				listeMotifs=(List<VMotifRetourDemande>) iservice.getObjectsByColumn("VMotifRetourDemande", new ArrayList<String>(Arrays.asList("HDM_DEM_NUM")),
						new WhereClause("HDM_DEM_NUM",WhereClause.Comparateur.EQ,""+slctdTd.getDemNum()));
				if(!listeMotifs.isEmpty()) {
					int i=listeMotifs.size();
					int obs=i-1;
					motif=listeMotifs.get(obs);
				}	
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



	public String getObservation() {
		return observation;
	}



	public void setObservation(String observation) {
		this.observation = observation;
	}



	public List<VMotifRetourDemande> getListeMotifs() {
		return listeMotifs;
	}



	public void setListeMotifs(List<VMotifRetourDemande> listeMotifs) {
		this.listeMotifs = listeMotifs;
	}



	public VMotifRetourDemande getMotif() {
		return motif;
	}



	public void setMotif(VMotifRetourDemande motif) {
		this.motif = motif;
	}



	public boolean isPanelVerrouillage() {
		return panelVerrouillage;
	}



	public void setPanelVerrouillage(boolean panelVerrouillage) {
		this.panelVerrouillage = panelVerrouillage;
	}



	public boolean isPanelClarification() {
		return panelClarification;
	}



	public void setPanelClarification(boolean panelClarification) {
		this.panelClarification = panelClarification;
	}



	public boolean isPanelEclaissisement() {
		return panelEclaissisement;
	}



	public void setPanelEclaissisement(boolean panelEclaissisement) {
		this.panelEclaissisement = panelEclaissisement;
	}



	public boolean isPanelLigneBudgetaire() {
		return panelLigneBudgetaire;
	}



	public void setPanelLigneBudgetaire(boolean panelLigneBudgetaire) {
		this.panelLigneBudgetaire = panelLigneBudgetaire;
	}



	public List<TSoumissions> getListeEntreprises() {
		return listeEntreprises;
	}



	public void setListeEntreprises(List<TSoumissions> listeEntreprises) {
		this.listeEntreprises = listeEntreprises;
	}



	public List<TSoumissions> getSelectionEntreprises() {
		return selectionEntreprises;
	}



	public void setSelectionEntreprises(List<TSoumissions> selectionEntreprises) {
		this.selectionEntreprises = selectionEntreprises;
	}



	public TSoumissions getNewSoum() {
		return newSoum;
	}



	public void setNewSoum(TSoumissions newSoum) {
		this.newSoum = newSoum;
	}



	public boolean isPanelAutre() {
		return panelAutre;
	}



	public void setPanelAutre(boolean panelAutre) {
		this.panelAutre = panelAutre;
	}



	public boolean isPanelEntreprise() {
		return panelEntreprise;
	}



	public void setPanelEntreprise(boolean panelEntreprise) {
		this.panelEntreprise = panelEntreprise;
	}



	public List<TParamPieceDemande> getListePieces() {
		return listePieces;
	}



	public void setListePieces(List<TParamPieceDemande> listePieces) {
		this.listePieces = listePieces;
	}



	public List<TParamPieceDemande> getSelectionPieces() {
		return selectionPieces;
	}



	public void setSelectionPieces(List<TParamPieceDemande> selectionPieces) {
		this.selectionPieces = selectionPieces;
	}



	public TParamPieceDemande getNewPiece() {
		return newPiece;
	}



	public void setNewPiece(TParamPieceDemande newPiece) {
		this.newPiece = newPiece;
	}



	public List<VDetailDemande> getListeDetails() {
		return listeDetails;
	}



	public void setListeDetails(List<VDetailDemande> listeDetails) {
		this.listeDetails = listeDetails;
	}



	public List<TPieceDemande> getListePiecesDemande() {
		return listePiecesDemande;
	}



	public void setListePiecesDemande(List<TPieceDemande> listePiecesDemande) {
		this.listePiecesDemande = listePiecesDemande;
	}



	public Long getNumPiece() {
		return numPiece;
	}



	public void setNumPiece(Long numPiece) {
		this.numPiece = numPiece;
	}



	public List<TPieceDemande> getListePiecesDem() {
		return listePiecesDem;
	}



	public void setListePiecesDem(List<TPieceDemande> listePiecesDem) {
		this.listePiecesDem = listePiecesDem;
	}

	public List<String> getRepeat() {
		return repeat;
	}

	public void setRepeat(List<String> repeat) {
		this.repeat = repeat;
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

	public long getPdmNum() {
		return pdmNum;
	}

	public void setPdmNum(long pdmNum) {
		this.pdmNum = pdmNum;
	}



}
