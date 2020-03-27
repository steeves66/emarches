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
import com.sndi.model.TDemande;
import com.sndi.model.TDetCommissionSeance;
import com.sndi.model.TDetOffres;
import com.sndi.model.TDetailVente;
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
import com.sndi.model.VListePieceOffre;
import com.sndi.model.VLot;
import com.sndi.model.VPiecesOffre;
import com.sndi.model.VPiecesOffreAnalyse;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.model.VbDetOffresSaisi;
import com.sndi.model.VbTempParamDetOffres;
import com.sndi.model.VbTempParametreCom;
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
	 private List<TCommissionType> membresCommission = new ArrayList<TCommissionType>();
	 private List<TDetCommissionSeance> membresCommite = new ArrayList<TDetCommissionSeance>(); 
	 private List<TCommissionType> selectionMembres = new ArrayList<TCommissionType>(); 
	 private List<TDetCommissionSeance> selectionMembresCommite = new ArrayList<TDetCommissionSeance>(); 
	 private List<TTypeCommission> listeTypeCommission = new ArrayList<TTypeCommission>();
	 private List<TAvisAppelOffre> listeAppelOffre = new ArrayList<TAvisAppelOffre>();
	 private List<TLotAao> listeLots = new ArrayList<TLotAao>();
	 private List<TLotAao> listeLotsByAvis = new ArrayList<TLotAao>();
	 //private List<VLot> listeLotsByAvis = new ArrayList<VLot>();
	 private List<TCandidats> listCandidats = new ArrayList<TCandidats>();
	 private List<TDetOffres> listeOffres = new ArrayList<TDetOffres>(); 
	 private List<VPiecesOffre> listePiecesOffres = new ArrayList<VPiecesOffre>(); 
	 private List<VPiecesOffreAnalyse> listePiecesOffresAnalyse = new ArrayList<VPiecesOffreAnalyse>();
	 private List<VPiecesOffreAnalyse> listeSelectionPiecesOffresAnalyse= new ArrayList<VPiecesOffreAnalyse>();
	 private List<VbTempParamDetOffres> listeOffre = new ArrayList<VbTempParamDetOffres>();
	 private List<TDetailVente> listeVentes = new ArrayList<TDetailVente>();
	 private List<VPiecesOffre> listeSelectionPiecesOffres= new ArrayList<VPiecesOffre>();
	 private List<VbTempParamDetOffres> listeOffreByLot = new ArrayList<VbTempParamDetOffres>();
	 private List<TDetOffres> listeAttibutaire = new ArrayList<TDetOffres>(); 
	 private List<TDetOffres> listeAffichageAttibutaire = new ArrayList<TDetOffres>(); 
	 private List<TSeances> listeSeance = new ArrayList<TSeances>(); 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //Declaration des objets
	 private TCommissionSpecifique newcomSpec = new TCommissionSpecifique();
	 private TCommissionType newCom = new TCommissionType();
	 private TAvisAppelOffre slctdTd = new TAvisAppelOffre();
	 private VbTempParametreCom membre = new VbTempParametreCom();
	 private TCandidats candidat = new TCandidats(); 
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
	 
	 //Declaration des variables
	 private String tcoCode;
	 private String laaId;
	 private String filtreNcc="";
	 private boolean infoOffre=false;
	 private Boolean boutonEdit=false;
	 
	 private boolean saisie=false;
	 private boolean affichage=false;
	 
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
	 //private long rabais
	 
	 
		//Liste des membres du commite d'evaluation
	 public void chargeMembreCommite() {
		 membresCommite.clear();
		 membresCommite = ((List<TDetCommissionSeance>)iservice.getObjectsByColumn("TDetCommissionSeance",new ArrayList<String>(Arrays.asList("DCS_NOM_MBM")),
				 new WhereClause("DCS_COM_TCO_CODE",Comparateur.EQ,"COJ"),
				    new WhereClause("DCS_DAC_CODE",Comparateur.EQ,""+slctdTd.getTDacSpecs().getDacCode())));
				// );
				_logger.info("membreCommite size: "+membresCommite.size());	
	 }
	 
	 public void calculMontNet() {
		 montRab= montLu * pourcentRab/100;
		 montN = montLu - montRab;
		 System.out.print("montant est : "+getMontN());
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
	 
	//Liste des piecs de l'offre a l'analyse
		 public void chargePiecesAnalyse() {
			 listePiecesOffresAnalyse = ((List<VPiecesOffreAnalyse>)iservice.getObjectsByColumn("VPiecesOffreAnalyse",new ArrayList<String>(Arrays.asList("TPO_LIBELLE")),
					// new WhereClause("POF_LAA_ID",Comparateur.EQ,""+sltOffre.getDofLaaId())));
					 new WhereClause("ODP_TPO_ETAP_PIECE",Comparateur.EQ,"Ouverture"),
					 new WhereClause("POF_LAA_ID",Comparateur.EQ,""+sltOffre.getTLotAao().getLaaId())));
		 }
	 
	//Liste des membres de la commssions
		 public void chargeMembreCommission() {
			 membresCommission = ((List<TCommissionType>)iservice.getObjectsByColumn("TCommissionType",new ArrayList<String>(Arrays.asList("TCT_CODE")),
					    //new WhereClause("TCT_TCO_CODE",Comparateur.EQ,""+tcoCode)));
					    new WhereClause("TCT_TCO_CODE",Comparateur.EQ,"COJ")));
					_logger.info("membre size: "+membresCommission.size());	
		 }
		 
		//Liste des candidats
		 public void chargeCandidats() {
			 listCandidats = ((List<TCandidats>)iservice.getObjectsByColumn("TCandidats",new ArrayList<String>(Arrays.asList("CAN_NOM"))));
					_logger.info("listCandidats size: "+listCandidats.size());	
		 }
		 
		//Filtre les marchés en fonction du code Marché
		 public void filtrenNccCandidat() {
			 listCandidats.clear();
			 listCandidats = ((List<TCandidats>)iservice.getObjectsByColumn("TCandidats",new ArrayList<String>(Arrays.asList("CAN_NOM")),
					 new WhereClause("CAN_TIE_NCC",WhereClause.Comparateur.LIKE,"%"+filtreNcc+"%")));
				_logger.info("listCandidats size: "+listCandidats.size());	
			 
		 }
		 
		//Liste des offres VBdetaiOffre
		 public void chargeOffres() {
			 listeOffre.clear();
			 listeOffre = ((List<VbTempParamDetOffres>)iservice.getObjectsByColumn("VbTempParamDetOffres",new ArrayList<String>(Arrays.asList("TEMP_NUM"))
					 //new WhereClause("DOF_LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode())
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
		 
		 
		
		 //Love pour recuperer les candidats
		 public void onSelectCandidat() {
			 soumission = new TSoumissions();
			 soumission.setSouNcc(candidat.getCanSouNcc());
			 soumission.setSouNomCom(candidat.getCanNom()+" "+candidat.getCanPrenoms());
			 soumission.setSouTel(candidat.getCanTel());
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
					new WhereClause("LAA_NUM",WhereClause.Comparateur.LIKE,"%"+laaNum+"%")); 
			_logger.info("listeLotsByAvis size: "+listeLotsByAvis.size());
		 }
		//Liste des offres d'un lot
		 public void onSelectLot() {
			 listeAttibutaire.clear();
			 listeOffres.clear();
			 listeOffres = ((List<TDetOffres>)iservice.getObjectsByColumn("TDetOffres",new ArrayList<String>(Arrays.asList("DOF_NUM")),
					  new WhereClause("DOF_LAA_ID",WhereClause.Comparateur.EQ,""+lot.getLaaId())));
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
		 
		 
			public void savePresence() {
				//Mise a jour dans T_AvisAppelOffrfe
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
						
						for(TCommissionType mbr : selectionMembres) {
							newDetailSeance.setDcsDteSaisi(Calendar.getInstance().getTime());
							newDetailSeance.setDcsNomMbm(mbr.getTctNomMbm());
							newDetailSeance.setDcsPreMbm(mbr.getTctPreMbm());
							newDetailSeance.setDcsTelMbm(mbr.getTctTelMbm());
							newDetailSeance.setDcsRepMandate(mbr.getTctRepMandate());
							newDetailSeance.setDcsRepMandate(mbr.getTctRepMandate());
							newDetailSeance.setDcsFonCod(mbr.getTctLibelle());
							newDetailSeance.setDcsObservation(mbr.getTctTitre());
							newDetailSeance.setTSeances(newSeance);
							newDetailSeance.setTStructure(userController.getSlctd().getTFonction().getTStructure());
							newDetailSeance.setTTypeCommission(new TTypeCommission("COJ"));
							newDetailSeance.setTDacSpecs(slctdTd.getTDacSpecs());
							newDetailSeance.setTCommissionSpecifique(newcomSpec);
							newDetailSeance.setTOperateur(userController.getSlctd().getTOperateur());
							iservice.addObject(newDetailSeance);
						}
					}
				
				   boutonEdit = true;
				  userController.setTexteMsg("Enregistrement effectué avec succès !");
				  userController.setRenderMsg(true);
				  userController.setSevrityMsg("success");
			}
		
		//Enregistrement des membres du commité technique 
		public void saveCommiteEvaluation() {
			 if (selectionMembresCommite.size()==0) {
				 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Selectionnez un membre ", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}else {
					for(TDetCommissionSeance mbr : selectionMembresCommite) {
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
					  userController.setTexteMsg("Enregistrement effectué avec succès !");
					  userController.setRenderMsg(true);
					  userController.setSevrityMsg("success");	
					
				}
		}
		
	
		
		 //Edition de fiche membres
		 public void imprimerFicheMbr() {
			   projetReport.longparam1(newSeance.getSeaNum(), "membres_cojo", "membres_cojo");    
			}
		
		//Ouverture des offres
		public void saveOuverture() {
			
				newOffre.setDofLaaAaoCode(slctdTd.getAaoCode());
				newOffre.setDofLaaId(laaId);
				newOffre.setTempType("OFF");
				newOffre.setDofOpeMatricule(userController.getSlctd().getTOperateur().getOpeMatricule());
				newOffre.setDofDteSaisi(Calendar.getInstance().getTime());
				newOffre.setDofTyp(dofTyp);
				newOffre.setDofSouNcc(ncc);
				//convertir le montant net en qui est en long en string
				String montantOffre =String.valueOf(montN);
				String rabais =String.valueOf(pourcentRab);
				newOffre.setDofMtOfr(montantOffre);
				newOffre.setDofRab(rabais);
				iservice.addObject(newOffre);
				chargeOffres();
					
			
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
				 			newPieceOffre.setTDetOffres(newOffre.getDofOffNum());
				 			newPieceOffre.setTLotAao(laaId);
				 			iservice.addObject(newPieceOffre);
					     }	
			 }
		     
		    	userController.setTexteMsg("Ouverture effectuée avec succès !");
				userController.setRenderMsg(true);
				userController.setSevrityMsg("success");	
		}
		
		//Fin Ouverture
		public void finOuverture() {
			String statUpdate = "";
			String message = "";
			if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("APU")) {
				statUpdate = "OUV";
				message="Fin de l'ouverture des Offres !";
			 }else {
				 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("OUV")) {
						statUpdate = "ANA";
						message="Fin de l'analyse des Offres !";
				 }else {
					 if(slctdTd.getTStatut().getStaCode().equalsIgnoreCase("ANA")) {
						 statUpdate = "JUG";
							message="Fin du jugement des Offres !";
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
	    	
	    	sltOffre.setDofStaut("1");
			iservice.updateObject(sltOffre);
			chargeOffre();
			userController.setTexteMsg("Analyse effectuée avec succès !");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
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
			iservice.updateObject(sltOffre);
			saisie=true;
			affichage=false;
			chargeAttributaire();
			
			/*//Création de details seance
			newDetailSeance.setDcsDteSaisi(Calendar.getInstance().getTime());
			newDetailSeance.setTDacSpecs(slctdTd.getTDacSpecs());
			newDetailSeance.setTSeances(newSeance);
			newDetailSeance.setTTypeCommission(new TTypeCommission("COJ"));
			newDetailSeance.setTCommissionSpecifique(new TCommissionSpecifique(8));
			//newDetailSeance.set
			iservice.addObject(newDetailSeance);*/
			
			
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
		 
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "com1":
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
					chargeOffres();
					//chargeOffre();
					break;
				case "com5":
					//chargeTypeCommission();
					chargeMembreCommission();
					boutonEdit = false;
					break;
				case "com6":
					chargeLots();
					chargeOffres();
					chargePieces();
					break;
				case "com7":
					chargeLots();
					break;
				case "com8":
					chargeMembreCommite();
					break;
			    }		    
		     
		    return userController.renderPage(value);   
		    
		}
	 
	public void test(String value ,String action) {
		if(value.equalsIgnoreCase("")) {
			
		}
	}

	public List<TCommissionType> getMembresCommission() {
		return membresCommission;
	}

	public void setMembresCommission(List<TCommissionType> membresCommission) {
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

	public List<TCommissionType> getSelectionMembres() {
		return selectionMembres;
	}

	public void setSelectionMembres(List<TCommissionType> selectionMembres) {
		this.selectionMembres = selectionMembres;
	}

	public List<TDetCommissionSeance> getMembresCommite() {
		return membresCommite;
	}

	public void setMembresCommite(List<TDetCommissionSeance> membresCommite) {
		this.membresCommite = membresCommite;
	}

	public List<TDetCommissionSeance> getSelectionMembresCommite() {
		return selectionMembresCommite;
	}

	public void setSelectionMembresCommite(List<TDetCommissionSeance> selectionMembresCommite) {
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

	public List<TCandidats> getListCandidats() {
		return listCandidats;
	}

	public void setListCandidats(List<TCandidats> listCandidats) {
		this.listCandidats = listCandidats;
	}

	public String getFiltreNcc() {
		return filtreNcc;
	}

	public void setFiltreNcc(String filtreNcc) {
		this.filtreNcc = filtreNcc;
	}

	public TCandidats getCandidat() {
		return candidat;
	}

	public void setCandidat(TCandidats candidat) {
		this.candidat = candidat;
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

	public List<VbTempParamDetOffres> getListeOffre() {
		return listeOffre;
	}

	public void setListeOffre(List<VbTempParamDetOffres> listeOffre) {
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

}
