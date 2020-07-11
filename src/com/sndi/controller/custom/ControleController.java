package com.sndi.controller.custom;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.agpm.AgpmController;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
@Component
@Scope(value="session")
public class ControleController {
	Logger _logger = Logger.getLogger(ControleController.class);
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	
	
	
	//Libellés
	private String libelle="";
	private String libelleSmall="";
	private String libelle1="";
	private String libelleProcedure="";
	private String libellesmall="";
	private String libellePgpm ="";
	public String type="";
	public String typePlan="";
	private String libelleValPrq="";
	private String libelleValami="";
	private String libelleValP="";
	private String libelleAmi="";
	private String libelleami="";
	private String libelleAmi1="";
	private String libellePrq1="";
	private String libellePrq2="";
	private String libellePrq3="";
	private String libelleP="";
	private String libelle2="";
	private String libelleA="";
	private String libelleValAmi="";
	private String libelleDao1="";
	private String libelleDao2="";
	private String libelleDao3="";
	private String libelleDao4="";
	private String libelleFinCom="";
	private String libelleConfirm="";
	private String libelleTitle="";
	private String opdPiece="";
	//Panels
    private boolean panelForm=false;
	private boolean panelTraitement=false;
	private boolean panelDetail=false;
	private boolean panelRegister=false;
	private boolean panelUpdate=false;
	private boolean panel1 =false;
	private boolean panel2 =false;
	private boolean panel3 =false;
	private boolean panel4 =false;
	private boolean panel5 =false;
	private boolean panel6 =false;
	private boolean panel7 =false;
	private boolean panel8 =false;
	private boolean panel9 = false;
	private boolean panel10 = false;
	private boolean panel11 = false;
	private boolean panel12 = false;
	private boolean panel13 =false;
	private boolean panelPgpm =false;
	private boolean panelPgspm =true;
	private boolean validDMP = false;
	private boolean validCPMP = false;
	private boolean panelOuverture =false;
	private boolean panelAnalyse =false;
	private boolean panelJugement =false;
	private boolean selectOneMenuPassation =false;
	
	private boolean panelDaoTableauBordPslpso = false;
	private boolean panelAgpmTableauBordSai =false;
	private boolean panelAgpmTableauBordVal =false;
	private boolean panelAffectation = false;
	
	private boolean panelPgpmTableauBordSai =false;
	private boolean panelPgpmTableauBordVal =false;
	private boolean panelPpmTableauBordSai =false;
	private boolean panelPpmTableauBordVal =false;
	private boolean panelAgpmTableauBordValDmp = false;
	private boolean panelAgpmTableauBordSaiDmp = false;
	
	private boolean panelPgspmTableauBordSai =false;
	private boolean panelPgspmTableauBordVal =false;
	private boolean panelPspmTableauBordSai =false;
	private boolean panelPspmTableauBordVal =false;
	private boolean panelDaoTableauBordPub = false;
	private boolean panelDaoTableauBordPubCsv = false;
	private boolean panelDaoTableauBordPubDps = false;
	private boolean selectLoveModePgpm = false;
	private boolean selectLoveModePgspm = false;
	public boolean btn_maj_datePpm =false;
	public boolean btn_maj_datePspm =false;
	
	//A
	private boolean panelAmiTableauBordSai =false;
	private boolean panelAmiTableauBordVal =false;
	private boolean btn_valider_ami_cpmp =false; 
	private boolean btn_valider_ami_dmp =false;
	private boolean panelA =false;
	private boolean btn_fermer_saisie_ami =false;
	public boolean fermerSaiAmi=false;
	public boolean fermerValAmi=false;
	private boolean panelAmi =false;
	private boolean btn_creerDetailAmiCmp = false;
	private boolean btn_creerDetailAmiDmp = false;
	private boolean btn_creerDetailAmi = false;
	private boolean detailA = false;
	public boolean btn_trans_ami =false;
	public boolean btn_imprimpgspm = false;
	//PUBLICATION
	public boolean btn_pub_csv = false;
	public boolean btn_pub_dps = false;
	public boolean btn_ami_csv = false; 
    public boolean btn_ami_dps = false;
    public boolean btn_prq_csv = false;
    public boolean btn_prq_dps = false;
	public boolean panelDaoTableauBordDPubCsv = false;
	public boolean panelDaoTableauBordDPubDps = false;
	public boolean panelPgpmTableauBordDjPub = false;
	//DAO
	private boolean panelDaoTableauBordSai =false;
	private boolean panelDaoTableauBordVal =false;
	private boolean panelDaoTableauBordAff =false;
	private boolean panelDaoTableauBordExa =false;
	private boolean panelDaoTableauBordRet =false;
	private boolean panelDaoTableauBordCha =false;
	private boolean panelDaoTableauBordVet =false;
	private boolean panelDaoTableauBordPrise = false;
	private boolean panelDaoTableauBordTra = false;
	private boolean btn_valider_dao_cpmp =false; 
	private boolean btn_valider_dao_dmp =false;
	private boolean panelD =false;
	private boolean btn_fermer_saisie_dao =false;
	private boolean btn_fermer_saisie_daoPs =false;
	public boolean fermerSaiDao=false;
	public boolean fermerValDao=false;
	private boolean btn_daoPn =false;
	private boolean btn_daoPs =false;
	private boolean btn_ami =false;
	private boolean btn_prq =false;
	private boolean panelDao =false;
	private boolean btn_creerDetailDaoCmp = false;
	private boolean btn_creerDetailDaoDmp = false;
	private boolean btn_creerDetailDao = false;
	private boolean detailD = false;
	public boolean btn_trans_dao =false;
	public boolean btn_dao_pn =false;
	public boolean btn_dao_ps =false;
	private boolean pspmModePs = false;
	private boolean ppmModePn = false;
	private boolean btn_pub = false;
	private boolean btn_imprimer_pg = false;
	private boolean panelPub = false;
	private boolean nbreAchat = false;
	
	
	//Recherche pour le DAO (Procédure Normale)
	private boolean venteRecherche = false; 
	private boolean affectationRecherche = false;
	private boolean examenRecherche = false;
	private boolean publicationRecherche = false;
	private boolean saisieRecherche = false;
	private boolean celluleRecherche = false;
	private boolean validationRecherche = false;
	private boolean priseRecherche = false;
	private boolean chargeRecherche = false;
		
	//Recherche pour le DAO (Procédure Simplifiée)
	private boolean venteRecherchePs = false;
	private boolean affectationRecherchePs = false;
	private boolean examenRecherchePs = false;
	private boolean publicationRecherchePs = false;
	private boolean saisieRecherchePs = false;
	private boolean celluleRecherchePs = false;
	private boolean validationRecherchePs = false;
	private boolean priseRecherchePs = false;
	private boolean chargeRecherchePs = false;
	//Fin de Recherche pour le DAO
	
	
	//PREQUALIFICATION
	private boolean panelPrqTableauBordSai =false;
	private boolean panelPrqTableauBordVal =false;
	private boolean btn_valider_prq_cpmp =false; 
	private boolean btn_valider_prq_dmp =false;
	private boolean panelP =false;
	private boolean btn_fermer_saisie_prq =false;
	public boolean fermerSaiPrq=false;
	public boolean fermerValPrq=false;
	private boolean panelPrq =false;
	private boolean btn_creerDetailPrqCmp = false;
	private boolean btn_creerDetailPrqDmp = false;
	private boolean btn_creerDetailPrq = false;
	private boolean detailP = false;
	public boolean btn_trans_prq =false;
	
	private boolean selectLovePgpm = false;
	private boolean selectLovePgspm = false;
	private boolean selectPartPgpm = false;
	private boolean selectPartPgspm = false;
	//Filtres sur la ligne Budgétaire
	private boolean filtreLignePgpm = false;
	private boolean filtreLignePgspm = false;
	
	private boolean panelPpm =false;
	private boolean panelPspm =false;
	private boolean selectOneMenuProcedure =false;
	//Boutons
	private boolean btn_new =false;
	private boolean btn_affec =false;
	private boolean btn_exam = false;
	private boolean btn_retrait = false;
	private boolean btn_valid = false;
	private boolean btn_traitement =false;
	private boolean btn_transmission =false;
	private boolean btn_fermerSaisie =false;
	private boolean btn_fermerOuverture =false;
	private boolean btn_fermerAnalyse =false;
	private boolean btn_fermerJugement =false;
    boolean btn_differerPgspm_cpdmp =false;
	private boolean btn_fermer_saisie_pgpm =false;
	public  boolean btn_edit_pgpm =false;
	public  boolean btn_edit_pgspm =false;
	
	public  boolean btn_trans_pgpm =false;
	public  boolean btn_trans_pgspm =false;
	
	public  boolean btn_trans_ppm =false;
	public  boolean btn_trans_pspm =false;
	public  boolean btn_valider_ppm_cpmp = false;
	public  boolean btn_valider_ppm_dmp = false;
	private boolean selectTypMPgpm = false;
	private boolean selectTypMPgspm = false;
	
	private boolean btn_fermer_saisie_pgspm =false;
	private boolean btn_fermer_saisie_ppm =false;
	private boolean btn_fermer_saisie_pspm =false;
	private boolean btn_fermerValidation =false;
	private boolean btn_new_pgpm =false;
	private boolean btn_new_pgspm =false;
	public boolean btn_save_pgspm =false;
	public  boolean btn_save_pgpm =false; 
	private boolean btn_new_ppm =false;
	private boolean btn_new_pspm =false;
	private boolean btn_save_pspm =false;
	private boolean btn_save_ppm =false;
	private boolean btn_trasmettre =false;
	private boolean btn_valider_cpmp =false; 
	private boolean btn_trasmettre_pgspm = false;
	
	private boolean btn_valider_pgspm_cpmp =false; 
	private boolean btn_valider_pgspm_dmp =false;
	
	private boolean btn_valider_pspm_cpmp =false; 
	private boolean btn_valider_pspm_dmp =false;
	
	private boolean etat_prq =false;
	private boolean etat_dao =false;
	private boolean etat_ami =false;
	
	private boolean btn_valider_dmp =false;
	public boolean btn_creerDetailPpm = false;
	public boolean btn_creerDetailPspm = false;
	private boolean btn_creerDetailPpmCmp = false;
	private boolean btn_creerDetailPspmCmp = false;
	private boolean btn_creerDetailPpmDmp = false;
	private boolean btn_creerDetailPspmDmp = false;
	private boolean tpgpm =false;
	private boolean tpgspm =false;
	private boolean detailP1 = false;
	private boolean detailP2 = false;
	private boolean nbrepgpm =false;
	private boolean nbrepgspm =false;
	
	private boolean searchPgpm = false;
	private boolean searchPgspm = false;
    //Zone de Recherche pour le PSPM
	private boolean searchAcPs = false;
	private boolean searchCpmpPs = false;
	private boolean searchDmpPs = false;
	private boolean nbreppm =false;
	private boolean nbrepspm =false;
	private boolean detailPg1 = false;
	private boolean detailPg2 = false;
	
	public boolean fermerSai=false;
	public boolean fermerVal=false;
	//Bouton Fermer PGPM
	public boolean fermerSaiPgpm=false;
	public boolean fermerValPgpm=false;
	//Bouton Fermer PGSPM
	public boolean fermerSaiPgspm=false;
	public boolean fermerValPgspm=false;
	//BoutonFermer PPM
	public boolean fermerSaiPpm = false;
	public boolean fermerValPpm = false;
	//Bouton fermer PSPM
	public boolean fermerSaiPspm=false;
	public boolean fermerValPspm=false;
	
	private boolean affDao=false;
	private boolean exaDao=false;
	private boolean retDao=false;
	private boolean btn_retourner=false;
	
	private boolean update_fermer_dao=false;
	private boolean update_fermer_ami=false;
	private boolean update_fermer_prq=false;
	private boolean update_fermer_dps=false;
	

	//Zone de Recherche pour le PPM
	private boolean searchAC = false;
	private boolean searchCpmp = false;
	private boolean searchDmp = false;
	//Champ PPM
	public boolean etatPsl =false;
	public boolean etatPso =false;
	public boolean etatPsc =false;
	public boolean etatPsl_Pso =false;
	
	private boolean love_Ac=false;
	private boolean love_Cpmp=false;
	private boolean love_Dmp=false;
	private boolean btn_membre =false;
	private boolean btn_apercuOuv =false;
	private boolean btn_apercuAna =false;
	private boolean btn_apercuJug =false;
	public boolean etatLoveAgpm = false;
	private boolean etatLoveAgpmPs = false;
	
	//Fermer Apercu DAO,AMI,PRQ
	private boolean fermerApercuDao = false;
	private boolean fermerApercuAmi = false;
	private boolean fermerApercuPrq = false;
	
	//Actions de l'AC
	private boolean saisie=false;
	private boolean publication=false;
	private boolean vente=false;
	private boolean correction=false;
	
	//PUBLICATION DES PGPM, PGSPM, PPM, PSPM
	private boolean panelPgpmTableauBordPgPub = false;
	private boolean panelPgpmTableauBordPgsPub = false;
	private boolean panelPgpmTableauBordPpPub = false;	
	private boolean panelPgpmTableauBordPspPub = false;
	private boolean panelPgpmTableauBordDpgPub = false;
	private boolean panelPgpmTableauBordDpsgPub = false;
	private boolean btn_publier_pgpm = false;
	private boolean btn_publier_pgspm = false;
	private boolean btn_publier_ppm = false;
	private boolean btn_publier_pspm = false;
	private boolean btn_imprimer = false;
	//statuts
	private String statutAffiche="";
	private String statutUpdate="";
	
	private String fonctionalite="";
	
	//Colonnes bootstrap
	private String numero="";
	private String ministere="";
	private String autorite="";
	private String bailleur="";
	private String accord="";
	private String projet="";
	private String organe="";
	private String datevalac="";
	private String datevalcpmp="";
	private String actions="";
	private String actionPage="";
	//String actionPrivilèges ="";
	
	
	@PostConstruct
	public void postContr() {
	 fonctionaliteDynamic();
	 statutDynamique();
	 colonnes();
	 privilege();
	 //action();
	 userConnecte();
	}
	
	
	//Nouvelles methodes dynamique
	/*public String action() {
		String act="";
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR") && act.equalsIgnoreCase("LISDEMAC")) {
			 act= "listSaisieAc";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR") && act.equalsIgnoreCase("SAIDEMAC")) {
					 act= "formSaisieAc";
				 }else {
					 //Si le type de la depense est DPS prend le statut E1T sinon ENG statut L3T
 					if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR") && act.equalsIgnoreCase("MODDEMAC")) {
 						act= "formModifAc";	
 					}
				 }	 
			 }
		return act;
	}*/
	
	public String userConnecte() {
		String utilisateur="";
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 utilisateur= "ACR";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
					 utilisateur= "CPM";
				 }else {
					 //Si le type de la depense est DPS prend le statut E1T sinon ENG statut L3T
 					if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
 						utilisateur= "DMP";	
 					}else {
 						 //Si le type de la depense est DPS prend le statut E1T sinon ENG statut L3T
 	 					if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPD")) {
 	 						utilisateur= "SPD";	
 	 					}
 					}
				 }	 
			 }
		return utilisateur;
	}
	
	public String privilege() {
		String actionPrivilèges= redirectionDynamicProcedures(actions);
		if(actionPrivilèges.equalsIgnoreCase("LISDEM")) {
			actionPrivilèges = "listeSaisieAc";
		}else
			if(actionPrivilèges.equalsIgnoreCase("TRADEM")) {
				actionPrivilèges = "listeValidationCpmp";	
    		}
	
		return actionPrivilèges;
	}
	
	/* public String pageAffiche(String action) {
		 actionPage = 
		 if(action.equalsIgnoreCase("listSaisieAc")) {
			 libelle1="Index";
 			 libelle="LISTE DES DEMANDES SAISIES";	
 			 btn_new =true;
			 panel1 =true;
			 panel2 =false;
			 fermerSai=true;
			 fermerVal=false;
		     panelAgpmTableauBordSai = true;
			 panelAgpmTableauBordVal = false;
		    }else 
		    	if(action.equalsIgnoreCase("MOD")) {
		    		
		    	}
		return action;
	 }*/
	//Fin Nouvelles methodes dynamique
	
	 
	 public void colonnes() {
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 numero="5%";
			 bailleur="col-sm-2";
			 accord="col-sm-1";
			 projet="col-sm-6";
			 organe="col-sm-2";
			 actions="10%";
		 }else
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM") 
			 || userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")
			 || redirectionDynamic(getActions()).equalsIgnoreCase("VAL")) {
				 numero="5%";
				 bailleur="col-sm-1";
				 ministere="col-sm-2";
				 autorite="col-sm-2";
				 accord="col-sm-1";
				 projet="col-sm-2";
				 organe="col-sm-1";
				 datevalac = "col-sm-1";
				 datevalcpmp = "col-sm-1";
				 actions="10%";
				 _logger.info("action: "+getActions());
			 } 
	 }
	
	//Affichage des boutons en fonction de l'utilisateur connecté
	 public void fonctionaliteDynamic() {
		  //Autorité contractante
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 btn_transmission =true;
			 btn_traitement=false;
			 love_Ac=true;
			 love_Cpmp=false;
			 love_Dmp=false;
		 }else
			  //CPMP
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				
				 btn_transmission =false;
				 btn_traitement=true;
				 love_Ac=false;
				 love_Cpmp=true;
				 love_Dmp=false;
			 }else
				//Directeur
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					 btn_transmission =false;
					 btn_traitement=true;
					 love_Ac=false;
					 love_Cpmp=false;
					 love_Dmp=true;
				 }
	 }
	 
	//Redirection en fonction du traitement a éffectuer
	 public String redirectionDynamic(String action) {
		 if(action.equalsIgnoreCase("ENG")) {
		       libelle="SAISIE D'UN NOUVEL AVIS GENERAL DE PASSATION DE MARCHES";
		       libelle1="Liste des AGPM Saisie par l'autorité Contractante";
		       panelDetail=false;
			   panelForm=true;
			   panelTraitement=false;
		       panelRegister=true;
		       panelUpdate=false;
		       panelAgpmTableauBordSai = true;
			   panelAgpmTableauBordVal = false;
		    }else 
		    	if(action.equalsIgnoreCase("MOD")) {
		    		libelle="Modification de l'AGPM N°";
		    		libelle1="Modification";
		    		panelDetail=false;
		    		//agpmController.etatPavetDossier= true;
    				panelForm=true;
   				    panelTraitement=false;
		    		panelUpdate=true;
		    		panelRegister=false;
		    	}else
		    		if(action.equalsIgnoreCase("LIS")) {
		    			libelle1="Index";
		    			libelle="SAISIE DES AVIS GENERAUX DE PASSATION DE MARCHES";	
		    			 btn_new =true;
						 panel1 =true;
						 panel2 =false;
						 fermerSai=true;
						 fermerVal=false;
						 panelAgpmTableauBordSai = true;
						 panelAgpmTableauBordVal = false;
						 panelAgpmTableauBordValDmp = false;
						 panelAgpmTableauBordSaiDmp = true;
							
		    		}else
		    			if(action.equalsIgnoreCase("VAL")) {
		    				libelle="VALIDATION DES AVIS GENERAUX DE PASSATION DE MARCHES";
		    				libelle1="TRANSMISSION DES AVIS GENERAUX DE PASSATION DE MARCHES";
		    				panelDetail=false;
		    				panelForm=false;
		   				    panelTraitement=true;
		    				btn_new =false;
							panel1 =false;
							panel2 =true;
							fermerSai=false;
							 fermerVal=true;
							 panelAgpmTableauBordSai = false;
							 panelAgpmTableauBordVal = true;
							 panelAgpmTableauBordValDmp = true;
							 panelAgpmTableauBordSaiDmp = false;
							 
		    			}else
			    			if(action.equalsIgnoreCase("APE")) {
			    				libelle="DETAILS DE L'AVIS GENERAL DE PASSATION DE MARCHES N°";
			    				panelDetail=true;
			    				panelForm=false;
			   				    panelTraitement=false;
			    				libelle1="Detail";
			    			}
		return action;
	 }
	 

	 public void statutDynamique() {
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 statutAffiche="S1S";
			 statutUpdate="S1T";	
		 }else {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				 statutAffiche="S2V";
				 statutUpdate="S3V";
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					 statutAffiche="S2V";
					 statutUpdate="S3V";
				 }	 
			 } 
		 } 
	 }
	 
	 
	 //GESTION DES PROCEDURES 
	//Redirection en fonction du traitement a éffectuer
		 public String redirectionDynamicProcedures(String action) {
			 //PGPM
			 if(action.equalsIgnoreCase("ENGPGPM")) {
				 type = "PGPM";
				 libelleProcedure="SAISIE D'UN NOUVEAU  PLAN GENERAL DE PASSATION DE MARCHES";
			       libelle1="PLAN GENERAL DE PASSATIONS DES MARCHES";
			       libelleSmall="Procédure Normale";
			       panelDetail=false;
				   panelForm=true;
				   panelTraitement=false;
			       panelRegister=true;
			       panelUpdate=false;
			       btn_save_pgpm = true;
				   btn_save_pgspm = false;
				   btn_fermer_saisie_pgpm =true;
				   btn_fermer_saisie_pgspm =false;
				   tpgpm =true;
				   tpgspm =false;
				   panelPgpmTableauBordSai =true;
				   panelPgpmTableauBordVal =false;
				   detailPg1 = true;
				   detailPg2 = false;
				   
			    }else 
			    	if(action.equalsIgnoreCase("MODPGPM")) {
			    		type = "PGPM";
		    			libelleProcedure="Index";
		    			libelle="MODIFICATION DU PLAN GENERAL DE PASSATION DE MARCHES N°";	
		    			btn_new_pgpm =true;
		    			btn_new_pgspm =false;
		    			btn_trasmettre =true;
		    			btn_valider_cpmp =false; 
                        btn_valider_dmp =false;
                        btn_valider_pgspm_cpmp =false;
                        btn_valider_pgspm_dmp =false;
						panel1 =true;
						panel2 =false;
						panelPgpm = true;
						panelPgspm = false;
						searchPgpm = true;
						searchPgspm = false;
						fermerSai = true;
						fermerVal = false;
						etatLoveAgpm = true;
						etatLoveAgpmPs = false;
						panelPgpmTableauBordSai =true;
						panelPgpmTableauBordVal =false;
						selectLoveModePgpm = true;
						selectLoveModePgspm = false;
						detailPg1 = true;
						detailPg2 = false;
						nbrepgpm = true;
						nbrepgspm = false;
						btn_trans_pgpm = true;
						btn_trans_pgspm = false;
						btn_trasmettre_pgspm = false;
						btn_fermer_saisie_pgpm = true;
						btn_fermer_saisie_pgspm = false;
			    	}else
			    		if(action.equalsIgnoreCase("SAIPGPM")) {
			    			type = "PGPM";
			    			libelleProcedure="Index";
			    			libelle="SAISIE DES PLANS GENERAUX DE PASSATION DE MARCHES";
			    			libelle1="PLAN GENERAL DE PASSATIONS DES MARCHES";
			    			libelleSmall="Procédure Normale";
			    			btn_new_pgpm =true;
			    			btn_new_pgspm =false;
			    			btn_trasmettre =true;
			    			btn_imprimpgspm = false;
			    			btn_valider_cpmp =false; 
                            btn_valider_dmp =false;
                            btn_valider_pgspm_cpmp =false;
                            btn_valider_pgspm_dmp =false;
							panel1 =true;
							panel2 =false;
							panelPgpm = true;
							panelPgspm = false;
							searchPgpm = true;
							searchPgspm = false;
							fermerSaiPgpm = true;
							fermerValPgpm = false;
							fermerSaiPgspm = false;
							fermerValPgspm = false;
							/*fermerSaiPgpm = true;
							fermerValPgpm = false;
							fermerSaiPgspm = false;
							fermerValPgspm = false;*/
							etatLoveAgpm = true;
							etatLoveAgpmPs = false;
							panelPgpmTableauBordSai =true;
							panelPgpmTableauBordVal =false;
							selectLoveModePgpm = true;
							selectLoveModePgspm = false;
							detailPg1 = true;
							detailPg2 = false;
							nbrepgpm = true;
							nbrepgspm = false;
							btn_trans_pgpm = true;
							btn_trans_pgspm = false;
							btn_trasmettre_pgspm = false;
							
			    		}else
			    			if(action.equalsIgnoreCase("VALPGPM")) {
			    				type = "PGPM";
			    				libelle="VALIDATION DES PLANS GENERAUX DE PASSATION DE MARCHES";	
			    				libelle1="TRANSMISSION DES PLANS GENERAUX DE PASSATION DE MARCHES";
			    				libelleSmall="Procédure Normale";
			    				panelDetail=false;
			    				panelForm=false;
			   				    panelTraitement=true;
			    				btn_new =false;
			    				btn_trasmettre =false;
				    			btn_valider_cpmp =true; 
	                            btn_valider_dmp =true;
	                            btn_valider_pgspm_cpmp =false;
	                            btn_valider_pgspm_dmp =false;
	                            searchPgpm = true;
								searchPgspm = false;
								panel1 =false;
								panel2 =true;
								panelPgpm = true;
								panelPgspm = false;
								fermerSaiPgpm = false;
								fermerValPgpm = true;
								fermerSaiPgspm = false;
								fermerValPgspm = false;
								panelPgpmTableauBordSai =false;
								panelPgpmTableauBordVal =true;
								detailPg1 = true;
								detailPg2 = false;
								btn_trans_pgpm = false;
								btn_trans_pgspm = false;
								btn_trasmettre_pgspm=false;
			    			}else
				    			if(action.equalsIgnoreCase("APEPGPM")) {
				    				type = "PGPM";
				    				libelle="DETAILS DU PLAN GENERAL DE PASSATION DE MARCHES N°";
				    				libellePgpm ="SAISIE DES PLANS GENERAUX DE PASSATION DE MARCHES";
				    				panelDetail=true;
				    				panelForm=false;
				   				    panelTraitement=false;
				    				libelle1="Detail";
				    				detailPg1 = true;
									detailPg2 = false;
									panelPgpm = true;
									panelPgspm = false;
				    			}else
					    			if(action.equalsIgnoreCase("PUBPGPM")) { 
					    			type = "PGPM";
					    			typePlan ="PN";
					    			fonctionalite = "listePgpmAttPub";
				    				libelle="PLANS GENERAUX DE PASSATION DE MARCHES EN ATTENTE DE PUBLICATION";	
				    				libelle1="PLANS GENERAUX DE PASSATION DE MARCHES EN ATTENTE DE PUBLICATION";
				    				libelleSmall="Procédure Normale";
				    				panelDetail=false;
				    				panelForm=false;
				   				    panelTraitement=true;
				    				btn_new =false;
				    				btn_trasmettre =false;
					    			btn_valider_cpmp =false; 
		                            btn_valider_dmp =false;
		                            btn_valider_pgspm_cpmp =false;
		                            btn_valider_pgspm_dmp =false;
		                            btn_publier_pgpm = true;
		                            btn_publier_pgspm = false;
		                            searchPgpm = true;
									searchPgspm = false;
									panel1 =false;
									panel2 =false;
									panel3= true;
									panel4 = false;
									panelPgpm = true;
									panelPgspm = false;
									fermerSaiPgpm = false;
									fermerValPgpm = true;
									fermerSaiPgspm = false;
									fermerValPgspm = false;
									panelPgpmTableauBordSai =false;
									panelPgpmTableauBordVal =false;
									panelPgpmTableauBordPgPub = true;
									detailPg1 = true;
									detailPg2 = false;
									btn_trans_pgpm = false;
									btn_trans_pgspm = false;
									btn_trasmettre_pgspm=false;
									btn_imprimer_pg = false;
					    			}else
						    			if(action.equalsIgnoreCase("APUPGPM")) {
						    				type = "PGPM";
						    				libelle="DETAILS DU PLAN GENERAL DE PASSATION DE MARCHES N°";
						    				libellePgpm ="PUBLICATION DES PLANS GENERAUX DE PASSATION DE MARCHES";
						    				panelDetail=true;
						    				panelForm=false;
						   				    panelTraitement=false;
						    				libelle1="Detail Publication";
						    				detailPg1 = true;
											detailPg2 = false;
											panelPgpm = false;
											panelPgspm = false;
											panelPub = true;
											fermerValPgpm = true;
											fermerValPgspm = false;
						    			}else
							    			if(action.equalsIgnoreCase("DPUBPGPM")) { 
								    			type = "PGPM";
								    			typePlan ="PN";
								    			fonctionalite = "listePgpmPub";
							    				libelle="PLANS GENERAUX DE PASSATION DE MARCHES PUBLIES";	
							    				libelle1="PLANS GENERAUX DE PASSATION DE MARCHES PUBLIES";
							    				libelleSmall="Procédure Normale";
							    				panelDetail=false;
							    				panelForm=false;
							   				    panelTraitement=true;
							    				btn_new =false;
							    				btn_trasmettre =false;
								    			btn_valider_cpmp =false; 
					                            btn_valider_dmp =false;
					                            btn_valider_pgspm_cpmp =false;
					                            btn_valider_pgspm_dmp =false;
					                            btn_publier_pgpm = false;
					                            btn_publier_pgspm = false;
					                            searchPgpm = true;
												searchPgspm = false;
												panel1 =false;
												panel2 =false;
												panel3= false;
												panel4= true;
												panelPgpm = true;
												panelPgspm = false;
												fermerSaiPgpm = false;
												fermerValPgpm = true;
												fermerSaiPgspm = false;
												fermerValPgspm = false;
												panelPgpmTableauBordSai =false;
												panelPgpmTableauBordVal =false;
												panelPgpmTableauBordPgPub = false;
												panelPgpmTableauBordDpgPub = true;
												detailPg1 = true;
												detailPg2 = false;
												btn_trans_pgpm = false;
												btn_trans_pgspm = false;
												btn_trasmettre_pgspm=false;
												btn_imprimer_pg = true;
								    			}
			 //PGSPM
			 if(action.equalsIgnoreCase("ENGPGSPM")) {
				   type = "PGSPM";
			       libelle1="SAISIE D'UN NOUVEAU PLAN GENERAL SIMPLIFIE DE PASSATION DE MARCHES";
			       libelleSmall="Procédure Simplifiée";
			       panelDetail=false;
				   panelForm=true;
				   panelTraitement=false;
			       panelRegister=true;
			       panelUpdate=false;
			       btn_save_pgpm = false;
				   btn_save_pgspm = true;
				   btn_fermer_saisie_pgpm =false;
				   btn_fermer_saisie_pgspm =true;
				   tpgpm =false;
				   tpgspm =true;
				   detailPg1 = false;
				   detailPg2 = true;
				  
			    }else 
			    	if(action.equalsIgnoreCase("MODPGSPM")) {
			    		type = "PGSPM";
			    		libelleProcedure="Modification de l'AGPM N°";
			    		libelle1="Modification";
			    		panelDetail=false;
			    		tpgpm =false;
						tpgspm =true;
			    		//agpmController.etatPavetDossier= true;
	  				    panelForm=true;
	 				    panelTraitement=false;
			    		panelUpdate=true;
			    		panelRegister=false;
			    		btn_fermer_saisie_pgpm = false;
						btn_fermer_saisie_pgspm = true;
			    	}else
			    		if(action.equalsIgnoreCase("SAIPGSPM")) {
			    			type = "PGSPM";
			    			libelleProcedure="Index";
			    			libelle="SAISIE DES PLANS GENERAUX SIMPLIFIES DE PASSATION DE MARCHES";	
			    			libelle1="PLAN GENERAL SIMPLIFIE DE PASSATIONS DES MARCHES";
			    			libelleSmall="Procédure Simplifiée";
			    			btn_new_pgpm =false;
			    			btn_new_pgspm =true;
			    			btn_trasmettre =true;
			    			btn_imprimpgspm = true;
			    			btn_valider_cpmp =false; 
                            btn_valider_dmp =false;
                            btn_valider_pgspm_cpmp =false;
                            btn_valider_pgspm_dmp =false;
                            btn_trasmettre = false;
							 panel1 =true;
							 panel2 =false;
							 panelPgpm = false;
							 panelPgspm = true;
							 etatLoveAgpm = false;
							 etatLoveAgpmPs = true;
							 nbrepgpm = false;
							 searchPgpm = false;
							 searchPgspm = true;
							 nbrepgspm = true;
							 fermerSaiPgpm = false;
							 fermerValPgpm = false;
							 fermerSaiPgspm = true;
							 fermerValPgspm = false;
							 /*fermerSaiPgpm = false;
							 fermerValPgpm = false;
							 fermerSaiPgspm = true;
							 fermerValPgspm = false;*/
							 panelPgspmTableauBordSai =true;
							 panelPgspmTableauBordVal =false;
							 detailPg1 = false;
							 detailPg2 = true;
							 selectLoveModePgpm = false;
							 selectLoveModePgspm = true;
							 btn_trans_pgpm = false; 
							 btn_trans_pgspm = true;
							 btn_trasmettre_pgspm =true;
							 btn_differerPgspm_cpdmp = false;
							 btn_save_pgpm =false;
			    		}else
			    			if(action.equalsIgnoreCase("VALPGSPM")) {
			    				type = "PGSPM";
			    				libelle="VALIDATION DES PLANS GENERAUX SIMPLIFIES DE PASSATION DE MARCHES";
			    				libelle1="TRANSMISSION DES PLANS GENERAUX SIMPLIFIES DE PASSATION DE MARCHES";
			    				libelleSmall="Procédure Simplifiée";
			    				panelDetail=false;
			    				panelForm=false;
			   				    panelTraitement=true;
			    				btn_new =false;
			    				btn_new_pgspm = false;
			    				btn_trasmettre =false;
				    			/*btn_valider_cpmp =true; 
	                            btn_valider_dmp =true;*/
			    				btn_valider_cpmp =false; 
	                            btn_valider_dmp =false;
	                            btn_valider_pgspm_cpmp =true;
	                            btn_valider_pgspm_dmp =true;
								panel1 =false;
								panel2 =true;
								 panelPgpm = false;
								 panelPgspm = true;
								 fermerSaiPgpm = false;
								 fermerValPgpm = false;
								 fermerSaiPgspm = false;
								 fermerValPgspm = true;
								 searchPgpm = false;
								 searchPgspm = true;
								 panelPgspmTableauBordSai =false;
								 panelPgspmTableauBordVal =true;
								 detailPg1 = false;
								 detailPg2 = true;
								 btn_trans_pgpm = false; 
								 btn_trans_pgspm = false;
								 btn_trasmettre_pgspm = false;
								 btn_differerPgspm_cpdmp = true;
			    			}else
				    			if(action.equalsIgnoreCase("APEPGSPM")) {
				    				type = "PGSPM";
				    				libelle="DETAILS DU PLAN GENERAL SIMPLIFIE DE PASSATION DE MARCHES N°";
				    				panelDetail=true;
				    				panelForm=false;
				   				    panelTraitement=false;
				    				libelle1="Detail";
				    				libelleProcedure="Détail de l'AGPM N°";
				    				detailPg1 = false;
									detailPg2 = true;
									panelPgpm = false;
									panelPgspm = true;
				    			}else
					    			if(action.equalsIgnoreCase("PUBPGSPM")) { 
					    			type = "PGSPM";
					    			typePlan ="PS";
					    			fonctionalite = "listePgspmAttPub";
				    				libelle="PLANS GENERAUX SIMPLIFIES DE PASSATION DE MARCHES EN ATTENTE DE PUBLICATION";	
				    				libelle1="PLANS GENERAUX SIMPLIFIES DE PASSATION DE MARCHES EN ATTENTE DE PUBLICATION";
				    				libelleSmall="Procédure Simplifiée";
				    				panelDetail=false;
				    				panelForm=false;
				   				    panelTraitement=true;
				    				btn_new =false;
				    				btn_trasmettre =false;
					    			btn_valider_cpmp =false; 
		                            btn_valider_dmp =false;
		                            btn_valider_pgspm_cpmp =false;
		                            btn_valider_pgspm_dmp =false;
		                            btn_publier_pgpm = false;
		                            btn_publier_pgspm = true;
		                            searchPgpm = false;
									searchPgspm = true;
									panel1 =false;
									panel2 =false;
									panel3= true;
									panel4 = false;
									panelPgpm = false;
									panelPgspm = true;
									fermerSaiPgpm = false;
									fermerValPgpm = true;
									fermerSaiPgspm = false;
									fermerValPgspm = false;
									panelPgpmTableauBordSai =false;
									panelPgpmTableauBordVal =false;
									panelPgpmTableauBordPgPub = false;
									panelPgpmTableauBordPgsPub = true;
									panelPgspmTableauBordSai =false;
									panelPgspmTableauBordVal =false;
									btn_trans_pgpm = false;
									btn_trans_pgspm = false;
									btn_trasmettre_pgspm=false;
									btn_imprimer = false;
					    			}else
						    			if(action.equalsIgnoreCase("APUPGSPM")) {
						    				type = "PGSPM";
						    				libelle="DETAILS DU PLAN GENERAL  SIMPLIFIE DE PASSATION DE MARCHES N°";
						    				libellePgpm ="PUBLICATION DES PLANS GENERAUX SIMPLIFIES DE PASSATION DE MARCHES";
						    				panelDetail=true;
						    				panelForm=false;
						   				    panelTraitement=false;
						    				libelle1="Detail Publication";
						    				detailPg1 = true;
											detailPg2 = false;
											panelPgpm = false;
											panelPgspm = false;
											panelPub = true;
											fermerValPgpm = false;
											fermerValPgspm = true;
						    			}else
							    			if(action.equalsIgnoreCase("DPUBPGSPM")) { 
								    			type = "PGSPM";
								    			typePlan ="PS";
								    			fonctionalite = "listePgspmPub";
							    				libelle="PLANS GENERAUX SIMPLIFIES DE PASSATION DE MARCHES PUBLIES";	
							    				libelle1="PLANS GENERAUX SIMPLIFIES DE PASSATION DE MARCHES PUBLIES";
							    				libelleSmall="Procédure Simplifiée";
							    				panelDetail=false;
							    				panelForm=false;
							   				    panelTraitement=true;
							    				btn_new =false;
							    				btn_trasmettre =false;
								    			btn_valider_cpmp =false; 
					                            btn_valider_dmp =false;
					                            btn_valider_pgspm_cpmp =false;
					                            btn_valider_pgspm_dmp =false;
					                            btn_publier_pgpm = false;
					                            btn_publier_pgspm = false;
					                            searchPgpm = true;
												searchPgspm = false;
												panel1 =false;
												panel2 =false;
												panel3= false;
												panel4= true;
												panelPgpm = false;
												panelPgspm = true;
												fermerSaiPgpm = false;
												fermerValPgpm = true;
												fermerSaiPgspm = false;
												fermerValPgspm = false;
												panelPgpmTableauBordSai =false;
												panelPgpmTableauBordVal =false;
												panelPgpmTableauBordPgPub = false;
												panelPgpmTableauBordDpgPub = false;
												panelPgpmTableauBordDpsgPub = false;
												panelPgpmTableauBordDpgPub = true;
												detailPg1 = true;
												detailPg2 = false;
												btn_trans_pgpm = false;
												btn_trans_pgspm = false;
												btn_trasmettre_pgspm=false;
												btn_imprimer_pg = true;
								    			}
			 
			 //PPM
			 if(action.equalsIgnoreCase("ENGPPM")) {
				 type = "PPM";
				 libelleProcedure="SAISIE D'UN NOUVEAU PLAN DE PASSATION DE MARCHES";
			       libelle1="Liste des AGPM Saisie par l'autorité Contractante";
			    }else 
			    	if(action.equalsIgnoreCase("MODPPM")) {
			    		type = "PPM";
			    		libelleSmall="Index";
			    		libelleProcedure="Modification du PPM N°";
			    		libelle="Modification du";
			    		libelle1="Modification du PPM N°";
			    		btn_new =true;
						 panel1 =true;
						 panel2 =false;
						 panelPpmTableauBordSai = true;
						 panelPpmTableauBordVal = false;
						 selectLovePgpm = true;
						 selectLovePgspm = false;
						 selectPartPgpm = true;
						 selectPartPgspm = false;
						 selectTypMPgpm = true;
						 selectTypMPgspm = false;
						 panelPpm = true;
						 panelPspm = false;
						 fermerVal = false;
						 fermerSai = true;
						 btn_trans_ppm = true;
						 btn_trans_pspm = false;
						 nbreppm = true;
						 nbrepspm = false;
						 btn_fermer_saisie_ppm = true;
						 btn_fermer_saisie_pspm = false;
						 btn_valider_pspm_cpmp = false;
						 btn_valider_pspm_dmp = false;
						 btn_valider_ppm_cpmp = false;
						 btn_valider_ppm_dmp = false;
						 selectOneMenuProcedure =false;
						 selectOneMenuPassation =true;
						 btn_creerDetailPpm = true;
						 btn_creerDetailPspm = false;
						 btn_creerDetailPpmCmp = true;
						 btn_creerDetailPspmCmp = false;
						 btn_creerDetailPpmDmp = true;
						 btn_creerDetailPspmDmp = false;
						 detailP1 = true;
						 detailP2 = false;
						 searchAC = true;
						 searchCpmp = false;
						 searchDmp = false;
						 validCPMP = true;
						 validDMP = false;
						 /*etatPso = false;
						 etatPsl = true;*/
						 etatPso = false;
						 etatPsl = false;
						 etatPsc = false;
						 etatPsl_Pso = false;
			    	}else
			    		 if(action.equalsIgnoreCase("SAIPPM")) {
			    			 type = "PPM";
			    			 typePlan = "PN";
			    			 libelleProcedure="SAISIE DES PLANS DE PASSATION DE MARCHES";	
			    			 btn_new =true;
							 panel1 =true;
							 panel2 =false;
							 panelPpmTableauBordSai = true;
							 panelPpmTableauBordVal = false;
							 selectLovePgpm = true;
							 selectLovePgspm = false;
							 filtreLignePgpm = true;
							 filtreLignePgspm = false;
							 selectPartPgpm = true;
							 selectPartPgspm = false;
							 selectTypMPgpm = true;
							 selectTypMPgspm = false;
							 panelPpm = true;
							 panelPspm = false;
							 fermerVal = false;
							 fermerSai = true;
							 fermerValPpm = false;
							 fermerSaiPpm = true;
							 fermerValPspm = false;
							 fermerSaiPspm = false;
							 btn_trans_ppm = true;
							 btn_trans_pspm = false;
							 nbreppm = true;
							 nbrepspm = false;
							 btn_fermer_saisie_ppm = true;
							 btn_fermer_saisie_pspm = false;
							 btn_valider_pspm_cpmp = false;
							 btn_valider_pspm_dmp = false;
							 btn_valider_ppm_cpmp = false;
							 btn_valider_ppm_dmp = false;
							 selectOneMenuProcedure =false;
							 selectOneMenuPassation =true;
							 btn_creerDetailPpm = true;
							 btn_creerDetailPspm = false;
							 btn_creerDetailPpmCmp = true;
							 btn_creerDetailPspmCmp = false;
							 btn_creerDetailPpmDmp = true;
							 btn_creerDetailPspmDmp = false;
							 //btn_maj_datePpm = false;
							 detailP1 = true;
							 detailP2 = false;
							 /*validDMP = true;
							 validCPMP = false;*/
							 validCPMP = true;
							 validDMP = false;
							 //etatPso = false;
							 //etatPsl = false;
							 etatPso = false;
							 etatPsl = false;
							 etatPsc = false;
							 etatPsl_Pso = false;
							 searchAC = true;
							 searchCpmp = false;
							 searchDmp = false;
			    		}else
			    			if(action.equalsIgnoreCase("VALPPM")) {
			    				type = "PPM";
			    				typePlan = "PN";
			    				libelleProcedure="VALIDATION DES PLANS DE PASSATION DE MARCHES";	
			    				libelle1="TRANSMISSION DES PLANS DE PASSATION DE MARCHES";
			    				panelDetail=false;
			    				panelForm=false;
			   				    panelTraitement=true;
			    				btn_new =false;
								panel1 =true;
								panel2 =false;
								panelPpmTableauBordSai = false;
								panelPpmTableauBordVal = true;
								panelPpm = true;
								panelPspm = false;
								fermerVal = true;
								fermerSai = false;
								fermerValPpm = true;
								fermerSaiPpm = false;
								fermerValPspm = false;
								fermerSaiPspm = false;
								detailP1 = true;
								detailP2 = false;
								btn_trans_ppm = false;
								btn_trans_pspm = false;
								btn_valider_ppm_cpmp = true;
								btn_valider_ppm_dmp = true;
								btn_valider_pspm_cpmp = false;
								btn_valider_pspm_dmp = false;
								btn_fermer_saisie_ppm = true;
								btn_fermer_saisie_pspm = false;
								 searchAC = false;
								 searchCpmp = true;
								 searchDmp = true;
			    			}else
				    			if(action.equalsIgnoreCase("APEPPM")) {
				    				type = "PPM";
				    				panelDetail=true;
				    				panelForm=false;
				   				    panelTraitement=false;
				    				libelle1="Detail";
				    				libelle="Détail du PPM N°";
				    				//fermerSai = true;
				    				//fermerVal = false;
				    				panelPpm = true;
				    				panelPspm = false;
				    				fermerSaiPspm = false;
				    				fermerValPspm = false;
				    				detailP1 = true;
									detailP2 = false;
				    			}else
					    			if(action.equalsIgnoreCase("PUBPPM")) {
					    			type = "PPM";
					    			typePlan = "PN";
					    			fonctionalite ="listeAttPub";
				    				libelleProcedure="PUBLICATION DES PLANS DE PASSATION DE MARCHES";	
				    				libelle1="PUBLICATION DES PLANS DE PASSATION DE MARCHES";
				    				panelDetail=false;
				    				panelForm=false;
				   				    panelTraitement=true;
				    				btn_new =false;
									panel1 =false;
									panel2 =true;
									panel3 = false;
									panelPpmTableauBordSai = false;
									panelPpmTableauBordVal = false;
									panelPgpmTableauBordPpPub = true;
									panelPgpmTableauBordPspPub = false;
									panelPpmTableauBordSai = false;
									panelPpmTableauBordVal = false;
									panelPgpmTableauBordDpgPub = false;
									panelPgpmTableauBordDpsgPub = false;
									panelPpm = true;
									panelPspm = false;
									fermerVal = true;
									fermerSai = false;
									fermerValPpm = true;
									fermerSaiPpm = false;
									fermerValPspm = false;
									fermerSaiPspm = false;
									detailP1 = true;
									detailP2 = false;
									btn_trans_ppm = false;
									btn_trans_pspm = false;
									btn_valider_ppm_cpmp = false;
									btn_valider_ppm_dmp = false;
									btn_valider_pspm_cpmp = false;
									btn_valider_pspm_dmp = false;
									btn_fermer_saisie_ppm = true;
									btn_fermer_saisie_pspm = false;
									btn_publier_ppm = true;
									btn_publier_pspm = false;
									btn_imprimer = false;
									searchAC = false;
									searchCpmp = true;
									searchDmp = true;
					    			}else
						    			if(action.equalsIgnoreCase("DPUBPPM")) {
							    			type = "PPM";
							    			typePlan = "PN";
							    			fonctionalite ="listePpmPub";
						    				libelleProcedure="PLANS DE PASSATION DE MARCHES PUBLIES";	
						    				libelle1="PLANS DE PASSATION DE MARCHES PUBLIES ";
						    				panelDetail=false;
						    				panelForm=false;
						   				    panelTraitement=true;
						    				btn_new =false;
											panel1 =false;
											panel2 =false;
											panel3 = true;
											panelPpmTableauBordSai = false;
											panelPpmTableauBordVal = false;
											panelPgpmTableauBordPpPub = false;
											panelPgpmTableauBordPspPub = false;
											panelPgpmTableauBordDpgPub = true;
											panelPpm = true;
											panelPspm = false;
											fermerVal = true;
											fermerSai = false;
											fermerValPpm = true;
											fermerSaiPpm = false;
											fermerValPspm = false;
											fermerSaiPspm = false;
											detailP1 = true;
											detailP2 = false;
											btn_trans_ppm = false;
											btn_trans_pspm = false;
											btn_imprimer = true; 
											btn_valider_ppm_cpmp = false;
											btn_valider_ppm_dmp = false;
											btn_valider_pspm_cpmp = false;
											btn_valider_pspm_dmp = false;
											btn_fermer_saisie_ppm = true;
											btn_fermer_saisie_pspm = false;
											btn_publier_ppm = true;
											btn_publier_pspm = false;
											searchAC = false;
											searchCpmp = true;
											searchDmp = true;
							    			}
			 //PSPM
			 if(action.equalsIgnoreCase("ENGPSPM")) {
				 type = "PSPM";
				 libelleProcedure="SAISIE D'UN NOUVEAU PLAN SIMPLIFIE DE PASSATION DE MARCHES";
			       libelle1="Liste des PSPM Saisie par l'autorité Contractante";
			       panelDetail=false;
				   panelForm=true;
				   panelTraitement=false;
			       panelRegister=true;
			       panelUpdate=false;
			       btn_fermer_saisie_ppm = false;
			       btn_fermer_saisie_pspm = true;
			    }else 
			    	if(action.equalsIgnoreCase("MODPSPM")) {
			    		type = "PSPM";
			    		libelleSmall="Index";
			    		libelleProcedure="Modification du PSPM N°";
			    		libelle="Modification du";
			    		libelle1="Modification du PSPM N°";
			    		 btn_new =true;
						 panel1 =true;
						 panel2 =false;
						 panelPpmTableauBordSai = true;
						 panelPpmTableauBordVal = false;
						 selectLovePgpm = false;
						 selectLovePgspm = true;
						 selectPartPgpm = false;
						 selectPartPgspm = true;
						 selectTypMPgpm = true;
						 selectTypMPgspm = false;
						 panelPpm = true;
						 panelPspm = false;
						 fermerVal = false;
						 fermerSai = true;
						 btn_trans_ppm = true;
						 btn_trans_pspm = false;
						 nbreppm = true;
						 nbrepspm = false;
						 btn_fermer_saisie_ppm = true;
						 btn_fermer_saisie_pspm = false;
						 btn_valider_pspm_cpmp = false;
						 btn_valider_pspm_dmp = false;
						 btn_valider_ppm_cpmp = false;
						 btn_valider_ppm_dmp = false;
						 selectOneMenuProcedure =true;
						 selectOneMenuPassation =false;
						 btn_creerDetailPpm = true;
						 btn_creerDetailPspm = false;
						 btn_creerDetailPpmCmp = true;
						 btn_creerDetailPspmCmp = false;
						 btn_creerDetailPpmDmp = true;
						 btn_creerDetailPspmDmp = false;
						 detailP1 = true;
						 detailP2 = false;
						 searchAC = true;
						 searchCpmp = false;
						 searchDmp = false;
						 validCPMP = true;
						 validDMP = false;
						 
			    	}else
			    		if(action.equalsIgnoreCase("SAIPSPM")) {
			    			 type = "PSPM";
			    			 typePlan = "PS";
			    			 libelle1="Index";
			    			 libelleProcedure="SAISIE DES PLANS SIMPLIFIES DE PASSATION DE MARCHES";	
			    			 btn_new =true;
							 panel1 =true;
							 panel2 =false;
							 panelPspmTableauBordSai = true;
							 panelPspmTableauBordVal = false;
							 selectLovePgpm = false;
							 selectLovePgspm = true;
							 selectPartPgpm = false;
							 selectPartPgspm = true;
							 filtreLignePgpm = false;
							 filtreLignePgspm = true;
							 selectTypMPgpm = false;
							 selectTypMPgspm = true;
							 panelPpm = false;
							 panelPspm = true;
							 selectOneMenuProcedure =true;
							 selectOneMenuPassation =false;
							 btn_creerDetailPpm = false;
							 btn_creerDetailPspm = true;
							 btn_creerDetailPpmCmp = false;
							 btn_creerDetailPspmCmp = true;
							 btn_creerDetailPpmDmp = false;
							 btn_creerDetailPspmDmp = true;
							// btn_maj_datePspm = false;
							 fermerValPspm = false;
							 fermerSaiPspm = true;
							 fermerValPpm = false;
							 fermerSaiPpm = false;
							 detailP1 = false;
							 detailP2 = true;
							 nbreppm = false;
							 nbrepspm = true;
							 btn_valider_pspm_cpmp = false;
							 btn_valider_pspm_dmp = false;
							 btn_valider_ppm_cpmp = false;
							 btn_valider_ppm_dmp = false;
							 btn_fermer_saisie_ppm = false;
							 btn_fermer_saisie_pspm = true;
							 //validDMP = false;
							 validCPMP = false;
							 validDMP = true;
							 searchAcPs = true;
							 searchCpmpPs = false;
							 searchDmpPs = false;
							 /*etatPsl = false;
							 etatPso = false;*/
							 etatPso = false;
							 etatPsl = false;
							 etatPsc = false;
							 etatPsl_Pso = false;
			    		}else
			    			if(action.equalsIgnoreCase("VALPSPM")) {
			    				type = "PSPM";
			    				libelleProcedure="VALIDATION DES PLANS SIMPLIFIES DE PASSATION DE MARCHES";	
			    				libelle1="TRANSMISSION DES PLANS SIMPLIFIES DE PASSATION DE MARCHES";
			    				panelDetail=false;
			    				panelForm=false;
			   				    panelTraitement=true;
			    				btn_new =false;
								panel1 =true;
								panel2 =false;
								panelPspmTableauBordSai = false;
								panelPspmTableauBordVal = true;
								panelPpm = false;
								panelPspm = true;
								fermerValPspm = true;
								fermerSaiPspm = false;
								fermerValPpm = false;
								fermerSaiPpm = false;
								detailP1 = false;
								detailP2 = true;
								btn_valider_ppm_cpmp = false;
								btn_valider_ppm_dmp = false;
								btn_valider_pspm_cpmp = true;
								btn_valider_pspm_dmp = true;
								btn_fermer_saisie_ppm = false;
								btn_fermer_saisie_pspm = true;
								searchAcPs = false;
								searchCpmpPs = true;
								searchDmpPs = true;
			    			}else
				    			if(action.equalsIgnoreCase("APEPSPM")) {
				    				type = "PSPM";
				    				panelDetail=true;
				    				panelForm=false;
				   				    panelTraitement=false;
				    				libelle1="Detail";
				    				libelle="Détail du PSPM N°";
				    				fermerSai = false;
				    				fermerVal = false;
				    				panelPpm = false;
				    				panelPspm = true;
				    				//fermerSaiPspm = true;
				    				//fermerValPspm = false;
				    				detailP1 = false;
									detailP2 = true;
				    			}else
					    			if(action.equalsIgnoreCase("PUBPSPM")) {
					    			type = "PSPM";
					    			typePlan = "PS";
					    			fonctionalite ="listeAttPub";
				    				libelleProcedure="PUBLICATION DES PLANS DE PASSATION DE MARCHES";	
				    				libelle1="PUBLICATION DES PLANS DE PASSATION DE MARCHES";
				    				panelDetail=false;
				    				panelForm=false;
				   				    panelTraitement=true;
				    				btn_new =false;
									panel1 =false;
									panel2 =true;
									panelPpmTableauBordSai = false;
									panelPpmTableauBordVal = false;
									panelPgpmTableauBordPpPub = true;
									panelPgpmTableauBordPspPub = false;
									panelPpm = true;
									panelPspm = false;
									fermerVal = true;
									fermerSai = false;
									fermerValPpm = true;
									fermerSaiPpm = false;
									fermerValPspm = false;
									fermerSaiPspm = false;
									detailP1 = false;
									detailP2 = true;
									btn_trans_ppm = false;
									btn_trans_pspm = false;
									btn_valider_ppm_cpmp = false;
									btn_valider_ppm_dmp = false;
									btn_valider_pspm_cpmp = false;
									btn_valider_pspm_dmp = false;
									btn_fermer_saisie_ppm = true;
									btn_fermer_saisie_pspm = false;
									btn_publier_ppm = false;
									btn_publier_pspm = true;
									btn_imprimer = false;
									searchAC = false;
									searchCpmp = true;
									searchDmp = true;
					    			}else
						    			if(action.equalsIgnoreCase("DPUBPSPM")) {
						    				type = "PSPM";
							    			typePlan = "PS";
							    			fonctionalite ="listePpsmPub";
						    				libelleProcedure="PLANS SIMPLIFIES DE PASSATION DE MARCHES PUBLIES";	
						    				libelle1="PLANS SIMPLIFIES DE PASSATION DE MARCHES PUBLIES ";
						    				panelDetail=false;
						    				panelForm=false;
						   				    panelTraitement=true;
						    				btn_new =false;
											panel1 =false;
											panel2 =false;
											panel3 = false;
											panel4 = true;
											panelPpmTableauBordSai = false;
											panelPpmTableauBordVal = false;
											panelPgpmTableauBordPpPub = false;
											panelPgpmTableauBordPspPub = false;
											panelPgpmTableauBordDpgPub = true;
											panelPgpmTableauBordDpsgPub = false;
											panelPpm = true;
											panelPspm = false;
											fermerVal = true;
											fermerSai = false;
											fermerValPpm = true;
											fermerSaiPpm = false;
											fermerValPspm = false;
											fermerSaiPspm = false;
											detailP1 = true;
											detailP2 = false;
											btn_trans_ppm = false;
											btn_trans_pspm = false;
											btn_imprimer = true;
											btn_valider_ppm_cpmp = false;
											btn_valider_ppm_dmp = false;
											btn_valider_pspm_cpmp = false;
											btn_valider_pspm_dmp = false;
											btn_fermer_saisie_ppm = true;
											btn_fermer_saisie_pspm = false;
											btn_publier_ppm = true;
											btn_publier_pspm = false;
											searchAC = false;
											searchCpmp = true;
											searchDmp = true;
							    			}
			 
			
				    			//AMI
				   			 if(action.equalsIgnoreCase("ENGAMI")) {
				   				  type = "AMI";
								 typePlan ="PN";
								 libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   				  libelleDao1="SAISIE D'UN NOUVEL AVIS A MANIFESTATION D'INTERET (AMI)";
				   			       libellesmall ="Saisie d'un nouvel AMI";
				   			       panelDetail=false;
				   				   panelForm=true;
				   				   panelTraitement=false;
				   			       panelRegister=true;
				   			       panelUpdate=false;
				   			       btn_fermer_saisie_dao = false;
				   			       btn_fermer_saisie_daoPs =false;
				   			       btn_fermer_saisie_ami = true ;
				   			       btn_fermer_saisie_prq = false;                     
				   			    }else 
				   			    	if(action.equalsIgnoreCase("MODAMI")) {
				   			    		type = "AMI";
										 typePlan ="PN";
				   			    		libelleDao1="MODIFICATION DE L'AVIS A MANIFESTATION D'INTERET° ";
				   			    		 libelle1="Saisie d'un nouvel AMI";
				   			    		 update_fermer_dao=false;
							    		 update_fermer_ami=true;
							    		 update_fermer_prq=false;
							    		 update_fermer_dps=false;
				   					     panelDetail=false;
				   						 panelForm=true;
				   						 panelTraitement=false;
				   					     panelRegister=true;
				   					     panelUpdate=false;
				   					     btn_fermer_saisie_dao = true;
				   					     btn_fermer_saisie_ami = false ;
				   					     btn_fermer_saisie_prq = false  ;
				   			    	}else
				   			    		if(action.equalsIgnoreCase("SAIAMI")) {
				   			    			type = "AMI";
											 typePlan ="PN";
											 fonctionalite = "listSaisieAc";
											 libelle="INFORMATIONS SUR L'AUTORITE CONTRACTANTE";
				   			    			libelleDao3="SAISIE DES AVIS A MANIFESTATION D'INTERET";
				   			    			libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   			    			btn_daoPn =false;
							    			btn_daoPs =false;
							    			btn_ami =true;
							    			btn_prq =false;
				   			    			 btn_new =true;
				   			    			 btn_affec = false;
				   			    			panel1 =true;
											 panel2 =false;
											 panel3 = false;
											panel4 = false;
											 /*panel5 = false;
											 panel6 = false;
											 panel7 = false;
											 panel8 = true;
											 panel9 = false;
											 panel10 = false;
											 panel11 = false;
											 panel12 = false;*/
				   							 venteRecherche = false; 
				   							 affectationRecherche = false;
				   							 examenRecherche = false;
				   							 publicationRecherche = false;
				   							 saisieRecherche = true;
				   							 celluleRecherche = false;
				   							 validationRecherche = false;
				   							 priseRecherche = false;
				   							 chargeRecherche = false;
				   							 panelDaoTableauBordSai = true;
				   							 panelDaoTableauBordPslpso = false;
				   							 panelDaoTableauBordVal = false;
				   							 panelDaoTableauBordTra = false;
				   							 panelDaoTableauBordPub = false;
				   							 pspmModePs = false;
				   							 ppmModePn = true;
				   							 btn_dao_pn = true;
				   							 btn_dao_ps = false;
				   							 panelDaoTableauBordAff =false;
				   							 panelDaoTableauBordExa =false; 
				   							 panelDaoTableauBordRet =false;
				   							 panelDaoTableauBordVet =false;
				   							 panelDaoTableauBordCha = false;
				   							 panelDaoTableauBordPrise = false;
				   							 panelDaoTableauBordPubCsv = false;
											 panelDaoTableauBordDPubCsv = false;
											 panelDaoTableauBordPubDps = false;
											 panelDaoTableauBordDPubCsv = false;
											 panelDaoTableauBordDPubDps = false;
				   							 panelAmi = false;
				   							 panelDao = true;  
				   							 panelPrq = false;
				   							 btn_trans_ami =false;
				   							 btn_trans_dao =true;
				   							 btn_trans_prq =false;
				   							 
				   							 btn_creerDetailAmi = false;
				   							 btn_creerDetailDao = true ;
				   							 btn_creerDetailPrq = false;
				   							 
				   							 btn_creerDetailDaoCmp = true;
				   							 btn_creerDetailAmiCmp = false;
				   							 btn_creerDetailPrqCmp = false;
				   							 btn_creerDetailDaoDmp = true;
				   							 btn_creerDetailAmiDmp = false; 
				   							 btn_creerDetailPrqDmp = false;
				   							 fermerValDao = false;
				   							 fermerSaiDao = true;
				   							 detailD = true;
				   							 detailA= false; 
				   							 detailP = false;
				   							 btn_valider_dao_cpmp =  false;
				   							 btn_valider_dao_dmp = false;
				   							 btn_valider_ami_cpmp = false; 
				   							 btn_valider_prq_cpmp = false;
				   							 btn_valider_ami_dmp = false;
				   							 btn_valider_prq_dmp = false;
				   							 btn_fermer_saisie_dao = true; 
				   							 btn_fermer_saisie_ami = false; 
				   							 btn_fermer_saisie_prq = false; 
				   							 
				   			    		}else
				   				    		if(action.equalsIgnoreCase("AMIPS")) {
				   				    			type = "AMI";
												 typePlan ="PN";
												 libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   				    			 libelleDao3="SAISIE DES AVIS A MANIFESTATION D'INTERET";
				   				    			 libellesmall ="";
				   				    			 btn_new =true;
				   				    			 btn_affec = false;
				   				    			panel1 =true;
												 panel2 =false;
												 panel3 = false;
												 panel4 = false;
												 /*panel5 = false;
												 panel6 = false;
												 panel7 = false;
												 panel8 = true;
												 panel9 = false;
												 panel10 = false;
												 panel11 = false;
												 panel12 = false;*/
				   								 panelDaoTableauBordSai = false;
				   								 panelDaoTableauBordPslpso = true;
				   								 panelDaoTableauBordVal = false;
				   								 panelDaoTableauBordTra = false;
				   								 panelDaoTableauBordPub = false;
				   								 pspmModePs = true;
				   								 ppmModePn = false;
				   								 btn_dao_pn = false;
				   								 btn_dao_ps = true;
				   								 panelDaoTableauBordAff =false;
				   								 panelDaoTableauBordExa =false; 
				   								 panelDaoTableauBordRet =false;
				   								 panelDaoTableauBordVet =false;
				   								 panelDaoTableauBordCha = false;
				   								 panelDaoTableauBordPrise = false;
				   								 panelDaoTableauBordPubCsv = false;
												 panelDaoTableauBordDPubCsv = false;
												 panelDaoTableauBordPubDps = false;
												 panelDaoTableauBordDPubCsv = false;
												 panelDaoTableauBordDPubDps = false;
				   								 panelAmi = false;
				   								 panelDao = true;  
				   								 panelPrq = false;
				   								 btn_trans_ami =false;
				   								 btn_trans_dao =true;
				   								 btn_trans_prq =false;
				   								 
				   								 btn_creerDetailAmi = false;
				   								 btn_creerDetailDao = true ;
				   								 btn_creerDetailPrq = false;
				   								 
				   								 btn_creerDetailDaoCmp = true;
				   								 btn_creerDetailAmiCmp = false;
				   								 btn_creerDetailPrqCmp = false;
				   								 btn_creerDetailDaoDmp = true;
				   								 btn_creerDetailAmiDmp = false; 
				   								 btn_creerDetailPrqDmp = false;
				   								 fermerValDao = false;
				   								 fermerSaiDao = true;
				   								 detailD = true;
				   								 detailA= false; 
				   								 detailP = false;
				   								 btn_valider_dao_cpmp =  false;
				   								 btn_valider_dao_dmp = false;
				   								 btn_valider_ami_cpmp = false; 
				   								 btn_valider_prq_cpmp = false;
				   								 btn_valider_ami_dmp = false;
				   								 btn_valider_prq_dmp = false;
				   								 btn_fermer_saisie_dao = true; 
				   								 btn_fermer_saisie_ami = false; 
				   								 btn_fermer_saisie_prq = false; 
				   								 
				   				    		}else
				   			    			    if(action.equalsIgnoreCase("VALAMI")) {
				   			    			    	type = "AMI";
				   								 typePlan ="PN";
				   								 libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   			    				libelleDao3="VALIDATION DES AVIS A MANIFESTATION D'INTERET";
				   			    				libelleDao1="TRANSMISSION DES AVIS A MANIFESTATION D'INTERET";
				   			    				panelDetail=false;
				   			    				panelForm=false;
				   			   				    panelTraitement=true;
				   			    				btn_new =false;
				   			    				btn_affec = false;
				   			    				btn_retrait = false;
				   			    				btn_valid = true;
				   			    				panel1 =true;
												 panel2 =false;
												 panel3 = false;
												 panel4 = false;
												/* panel4 = false;
												 panel5 = false;
												 panel6 = false;
												 panel7 = false;
												 panel8 = true;
												 panel9 = false;
												 panel10 = false;
												 panel11 = false;
												 panel12 = false;*/
				   								venteRecherche = false; 
				   								affectationRecherche = false;
				   								examenRecherche = false;
				   								publicationRecherche = false;
				   								saisieRecherche = false;
				   								celluleRecherche = false;
				   								validationRecherche = true;
				   								priseRecherche = false;
				   								chargeRecherche = false;
				   								affDao=false;
				   								exaDao=false;
				   								panelDaoTableauBordAff =false;
				   								panelDaoTableauBordRet = false;
				   								panelDaoTableauBordSai = false;
				   								panelDaoTableauBordPslpso = false;
				   								panelDaoTableauBordVal = true;
				   								panelDaoTableauBordTra = false;
				   								panelDaoTableauBordVet =false;
				   								panelDaoTableauBordExa = false;
				   								panelDaoTableauBordCha = false;
				   								panelDaoTableauBordPub = false;
				   								panelDaoTableauBordPrise = false;
				   							    panelDaoTableauBordPubDps = false;
											    panelDaoTableauBordPubCsv = false;
				   								panelDao = true;
				   								panelPrq =false;
				   							    panelAmi = false;
				   								fermerValDao =true;
				   								fermerSaiDao = false;
				   								btn_trans_ami =false;
				   								btn_trans_dao =false;
				   								btn_trans_prq =false;
				   								detailD = true ;
				   								detailA = false; 
				   								detailP = false;
				   								btn_valider_prq_cpmp = false;
				   								btn_valider_prq_dmp = false; 
				   								btn_valider_ami_cpmp = false; 
				   								btn_valider_ami_dmp = false;
				   								btn_valider_dao_cpmp = true;
				   								btn_valider_dao_dmp = true;
				   								btn_fermer_saisie_ami = false; 
				   								btn_fermer_saisie_prq = false;
				   								btn_fermer_saisie_dao = true;
				   			    			}else
				   				    			if(action.equalsIgnoreCase("APEAMI")) {
				   				    				type = "AMI";
				   								 typePlan ="PN";
				   				    				libelleDao3="DETAILS DE L'";
				   				    				etat_dao =false;
								    				etat_prq =false;
								    				etat_ami =true;
				   				    				panelDetail=true;
				   				    				panelForm=false;
				   				   				    panelTraitement=false;
				   				    				libelle1="Detail";
				   				    				libelle2 = "Synthèse de l'AMI N°";
				   				    				fermerSaiPrq = false; 
				   				    				fermerValPrq = false;
				   				    				fermerSaiAmi = false;
				   				    				fermerValAmi = false;
				   				    				fermerSaiDao = true;
				   				    				fermerValDao = false;
				   				    				detailD = true ;
				   									detailA = false; 
				   									detailP = false;
				   									fermerApercuDao = true;
				   									fermerApercuAmi = false;
				   									fermerApercuPrq = false;
				   				    			}else 
				    								   if(action.equalsIgnoreCase("AMICSV")) {
				    									    typePlan ="PN";
				    									     type = "AMI";
				    									     fonctionalite="listeAmiCsv";
				    									     btn_pub =false;
				    									     btn_pub_csv = false;
				    									     btn_pub_dps = false;
				    									     btn_ami_csv = true; 
				    									     btn_ami_dps = false;
				    									     btn_prq_dps = false;
				    									     btn_prq_csv = false;
				    									     libelle1="LISTE DES AMI EN PROCEDURE NORMALE";
											    			 libelleDao3="AVIS A MANIFESTATION D'INTERET EN ATTENTE DE PUBLICATION";
											    			 btn_new =false;
											    			 btn_affec = false;
											    			 btn_exam = false;
											    			 btn_retrait = false;
											    			 btn_valid = false;
											    			 saisie=false;
											    			 publication=true;
											    			 vente=false;
											    			  correction=false;
											    			 panel1 =false;
															 panel2 =false;
															 panel3 = false;
														     panel4 = true;
															/* panel5 = false;
															 panel6 = false;
															 panel7 = true;
															 panel8 = false;
															 panel9 =false;
															 panel10 = false;
															 panel11 = false;
															 panel12 = false;*/
															 venteRecherche = false; 
															 affectationRecherche = false;
															 examenRecherche = false;
															 publicationRecherche = true;
															 saisieRecherche = false;
															 celluleRecherche = false;
															 validationRecherche = false;
															 priseRecherche = false;
															 chargeRecherche = false;
															 affDao=false;
															 exaDao=false;
															 retDao = false;
															 panelDaoTableauBordSai = false;
															 panelDaoTableauBordVal = false;
															 panelDaoTableauBordTra = false;
															 panelDaoTableauBordAff =false;
															 panelDaoTableauBordExa =false; 
															 panelDaoTableauBordRet =false;
															 panelDaoTableauBordVet =false;
															 panelDaoTableauBordCha = false;
															 panelDaoTableauBordPub = false;
															 panelDaoTableauBordPrise = false;
															 panelDaoTableauBordPubDps = false;
															 panelDaoTableauBordPubCsv = true;
															 panelDao = false;  
															 panelPrq = false;
															 btn_trans_ami =false;
															 btn_trans_dao =false;
															 btn_trans_prq =false;
															 
															 btn_creerDetailAmi = false;
															 btn_creerDetailDao = false ;
															 btn_creerDetailPrq = false;
															 
															 btn_creerDetailDaoCmp = false;
															 btn_creerDetailAmiCmp = false;
															 btn_creerDetailPrqCmp = false;
															 btn_creerDetailDaoDmp = false;
															 btn_creerDetailAmiDmp = false; 
															 btn_creerDetailPrqDmp = false;
															 fermerValDao = false;
															 fermerSaiDao = true;
															 detailD = false;
															 detailA= false; 
															 detailP = false;
															 btn_valider_dao_cpmp =  false;
															 btn_valider_dao_dmp = false;
															 btn_valider_ami_cpmp = false; 
															 btn_valider_prq_cpmp = false;
															 btn_valider_ami_dmp = false;
															 btn_valider_prq_dmp = false;
															 btn_fermer_saisie_dao = false; 
															 btn_fermer_saisie_ami = false; 
															 btn_fermer_saisie_prq = false;   
				    								   }else 
					    								   if(action.equalsIgnoreCase("DAMICSV")) {
					    									     typePlan ="PN";
					    									     type = "AMI";
					    									     fonctionalite="listeDamiCsv";
					    									     btn_pub =false;
					    									     btn_pub_csv = false;
					    									     btn_pub_dps = false;
					    									     btn_ami_csv = false; 
					    									     btn_ami_dps = true;
					    									     btn_prq_dps = false;
					    									     libelle1="LISTE DES AMI EN PROCEDURE NORMALE";
												    			 libelleDao3="AVIS A MANIFESTATION D'INTERET PUBLIES";
												    			 btn_new =false;
												    			 btn_affec = false;
												    			 btn_exam = false;
												    			 btn_retrait = false;
												    			 btn_valid = false;
												    			 saisie=false;
												    			 publication=true;
												    			 vente=false;
												    			 correction=false;
												    			 panel1 =false;
																 panel2 =false;
																 panel3 = false;
															     panel4 = true;
																/* panel5 = false;
																 panel6 = false;
																 panel7 = true;
																 panel8 = false;
																 panel9 =false;
																 panel10 = false;
																 panel11 = false;
																 panel12 = false;*/
																 venteRecherche = false; 
																 affectationRecherche = false;
																 examenRecherche = false;
																 publicationRecherche = true;
																 saisieRecherche = false;
																 celluleRecherche = false;
																 validationRecherche = false;
																 priseRecherche = false;
																 chargeRecherche = false;
																 affDao=false;
																 exaDao=false;
																 retDao = false;
																 panelDaoTableauBordSai = false;
																 panelDaoTableauBordVal = false;
																 panelDaoTableauBordTra = false;
																 panelDaoTableauBordAff =false;
																 panelDaoTableauBordExa =false; 
																 panelDaoTableauBordRet =false;
																 panelDaoTableauBordVet =false;
																 panelDaoTableauBordCha = false;
																 panelDaoTableauBordPub = false;
																 panelDaoTableauBordPrise = false;
																 panelDaoTableauBordPubDps = false;
																 panelDaoTableauBordPubCsv = false;
																 panelDaoTableauBordDPubCsv = true;
																 panelDaoTableauBordDPubDps = false;
																 panelDao = false;  
																 panelPrq = false;
																 btn_trans_ami =false;
																 btn_trans_dao =false;
																 btn_trans_prq =false;
																 
																 btn_creerDetailAmi = false;
																 btn_creerDetailDao = false ;
																 btn_creerDetailPrq = false;
																 
																 btn_creerDetailDaoCmp = false;
																 btn_creerDetailAmiCmp = false;
																 btn_creerDetailPrqCmp = false;
																 btn_creerDetailDaoDmp = false;
																 btn_creerDetailAmiDmp = false; 
																 btn_creerDetailPrqDmp = false;
																 fermerValDao = false;
																 fermerSaiDao = true;
																 detailD = false;
																 detailA= false; 
																 detailP = false;
																 btn_valider_dao_cpmp =  false;
																 btn_valider_dao_dmp = false;
																 btn_valider_ami_cpmp = false; 
																 btn_valider_prq_cpmp = false;
																 btn_valider_ami_dmp = false;
																 btn_valider_prq_dmp = false;
																 btn_fermer_saisie_dao = false; 
																 btn_fermer_saisie_ami = false; 
																 btn_fermer_saisie_prq = false;   
					    								   }else
				   				    				           if(action.equalsIgnoreCase("AFFAMI")) {
				   				    					     type = "AMI";
				   									         typePlan ="PN";
				   									         libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   							    			 libelleDao3="AFFECTATION DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   							    			 btn_new =false;
				   							    			 btn_affec = true;
				   							    			 btn_retrait = false;
				   							    			 btn_valid = false;
				   											 panel1 =false;
				   											 panel1 =true;
															 panel2 =false;
															 panel3 = false;
															 panel4 = false;
															/* panel4 = false;
															 panel5 = false;
															 panel6 = false;
															 panel7 = false;
															 panel8 = true;
															 panel9 = false;
															 panel10 = false;
															 panel11 = false;
															 panel12 = false;*/
				   											 venteRecherche = false; 
				   											 affectationRecherche = true;
				   											 examenRecherche = false;
				   											 publicationRecherche = false;
				   											 saisieRecherche = false;
				   											 celluleRecherche = false;
				   											 validationRecherche = false;
				   											 priseRecherche = false;
				   											 chargeRecherche = false;
				   											 
				   											 panelAffectation = true;
				   											 affDao=true;
				   											 exaDao=false;
				   											 panelDaoTableauBordSai = false;
				   											 panelDaoTableauBordVal = false;
				   											 panelDaoTableauBordTra = false;
				   											 panelDaoTableauBordAff =true;
				   											 panelDaoTableauBordVet =false;
				   											 panelDaoTableauBordRet = false;
				   											 panelDaoTableauBordCha = false;
				   											 panelDaoTableauBordPub = false;
				   											 panelDaoTableauBordPrise = false;
				   											 panelDaoTableauBordPubDps = false;
															 panelDaoTableauBordPubCsv = false;
				   											 panelDao = true;  
				   											 panelPrq = false;
				   											 btn_trans_ami =false;
				   											 btn_trans_dao =true;
				   											 btn_trans_prq =false;
				   											 
				   											 btn_creerDetailAmi = false;
				   											 btn_creerDetailDao = false ;
				   											 btn_creerDetailPrq = false;
				   											 
				   											 btn_creerDetailDaoCmp = true;
				   											 btn_creerDetailAmiCmp = false;
				   											 btn_creerDetailPrqCmp = false;
				   											 btn_creerDetailDaoDmp = false;
				   											 btn_creerDetailAmiDmp = false; 
				   											 btn_creerDetailPrqDmp = false;
				   											 fermerValDao = false;
				   											 fermerSaiDao = true;
				   											 detailD = false;
				   											 detailA= false; 
				   											 detailP = false;
				   											 btn_valider_dao_cpmp =  false;
				   											 btn_valider_dao_dmp = false;
				   											 btn_valider_ami_cpmp = false; 
				   											 btn_valider_prq_cpmp = false;
				   											 btn_valider_ami_dmp = false;
				   											 btn_valider_prq_dmp = false;
				   											 btn_fermer_saisie_dao = false; 
				   											 btn_fermer_saisie_ami = false; 
				   											 btn_fermer_saisie_prq = false; 
				   				    				 }else
				   				    					  if(action.equalsIgnoreCase("EXAAMI")) {
				   				    						type = "AMI";
				   										 typePlan ="PN";
				   										 libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   								    			 libelleDao3="EXAMEN DES AVIS A MANIFESTATION D'INTERET";
				   								    			 btn_new =false;
				   								    			 btn_affec = false;
				   								    			 btn_exam = true;
				   								    			 btn_valid = false;
				   								    			panel1 =true;
																 panel2 =false;
																 panel3 = false;
																 panel4 = false;
																/* panel4 = false;
																 panel5 = false;
																 panel6 = false;
																 panel7 = false;
																 panel8 = true;
																 panel9 = false;
																 panel10 = false;
																 panel11 = false;
																 panel12 = false;*/
				   												 venteRecherche = false; 
				   												 affectationRecherche = false;
				   												 examenRecherche = true;
				   												 publicationRecherche = false;
				   												 saisieRecherche = false;
				   												 celluleRecherche = false;
				   												 validationRecherche = false;
				   												 priseRecherche = false;
				   												 chargeRecherche = false;
				   												 panelAffectation = false;
				   												 affDao=false;
				   												 exaDao=true;
				   												 panelDaoTableauBordSai = false;
				   												 panelDaoTableauBordVal = false;
				   												 panelDaoTableauBordTra = false;
				   												 panelDaoTableauBordAff =false;
				   												 panelDaoTableauBordExa =true;
				   												 panelDaoTableauBordVet =false;
				   												 panelDaoTableauBordCha = false;
				   												 panelDaoTableauBordPub = false;
				   												 panelDaoTableauBordPrise = false;
				   												 panelDaoTableauBordPubCsv = false;
		   														 panelDaoTableauBordDPubCsv = false;
		   														 panelDaoTableauBordPubDps = false;
		   														 panelDaoTableauBordDPubCsv = false;
		   														 panelDaoTableauBordDPubDps = false;
				   												 panelDao = true;  
				   												 panelPrq = false;
				   												 btn_trans_ami =false;
				   												 btn_trans_dao =false;
				   												 btn_trans_prq =false;
				   												 
				   												 btn_creerDetailAmi = false;
				   												 btn_creerDetailDao = false ;
				   												 btn_creerDetailPrq = false;
				   												 
				   												 btn_creerDetailDaoCmp = false;
				   												 btn_creerDetailAmiCmp = false;
				   												 btn_creerDetailPrqCmp = false;
				   												 btn_creerDetailDaoDmp = false;
				   												 btn_creerDetailAmiDmp = false; 
				   												 btn_creerDetailPrqDmp = false;
				   												 fermerValDao = false;
				   												 fermerSaiDao = true;
				   												 detailD = false;
				   												 detailA= false; 
				   												 detailP = false;
				   												 btn_valider_dao_cpmp =  false;
				   												 btn_valider_dao_dmp = false;
				   												 btn_valider_ami_cpmp = false; 
				   												 btn_valider_prq_cpmp = false;
				   												 btn_valider_ami_dmp = false;
				   												 btn_valider_prq_dmp = false;
				   												 btn_fermer_saisie_dao = false; 
				   												 btn_fermer_saisie_ami = false; 
				   												 btn_fermer_saisie_prq = false; 
				   				    					  }else
				   				    						   if(action.equalsIgnoreCase("VETAMI")) {
				   				    							type = "AMI";
						   											 typePlan ="PN";
						   											 libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
						   				    						 libelle="VENTE / RETRAIT DE L'AMI N°";
				   									    			 libelleDao3="VENTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   									    			 fonctionalite="listeDaoVentePn";
				   									    			 btn_new =false;
				   									    			 btn_affec = false;
				   									    			 btn_exam = false;
				   									    			 btn_retrait = true;
				   									    			 btn_valid = false;
				   									    			panel1 =true;
																	 panel2 =false;
																	 panel3 = false;
																	 panel4 = false;
																	/* panel4 = false;
																	 panel5 = false;
																	 panel6 = false;
																	 panel7 = false;
																	 panel8 = true;
																	 panel9 = false;
																	 panel10 = false;
																	 panel11 = false;
																	 panel12 = false;*/
				   													 venteRecherche = true; 
				   													 affectationRecherche = false;
				   													 examenRecherche = false;
				   													 publicationRecherche = false;
				   													 saisieRecherche = false;
				   													 celluleRecherche = false;
				   													 validationRecherche = false;
				   													 priseRecherche = false;
				   													 chargeRecherche = false;
				   													 affDao=false;
				   													 exaDao=false;
				   													 retDao = true;
				   													 panelDaoTableauBordSai = false;
				   													 panelDaoTableauBordVal = false;
				   													 panelDaoTableauBordTra = false;
				   													 panelDaoTableauBordAff =false;
				   													 panelDaoTableauBordExa =false; 
				   													 panelDaoTableauBordRet =false; 
				   													 panelDaoTableauBordVet =true;
				   													 panelDaoTableauBordCha = false;
				   													 panelDaoTableauBordPub = false;
				   													 panelDaoTableauBordPrise = false;
				   													 panelDaoTableauBordPubCsv = false;
			   														 panelDaoTableauBordDPubCsv = false;
			   														 panelDaoTableauBordPubDps = false;
			   														 panelDaoTableauBordDPubCsv = false;
			   														 panelDaoTableauBordDPubDps = false;
				   													 panelDao = true;  
				   													 panelPrq = false;
				   													 btn_trans_ami =false;
				   													 btn_trans_dao =false;
				   													 btn_trans_prq =false;
				   													 
				   													 btn_creerDetailAmi = false;
				   													 btn_creerDetailDao = false ;
				   													 btn_creerDetailPrq = false;
				   													 
				   													 btn_creerDetailDaoCmp = false;
				   													 btn_creerDetailAmiCmp = false;
				   													 btn_creerDetailPrqCmp = false;
				   													 btn_creerDetailDaoDmp = false;
				   													 btn_creerDetailAmiDmp = false; 
				   													 btn_creerDetailPrqDmp = false;
				   													 fermerValDao = false;
				   													 fermerSaiDao = true;
				   													 detailD = false;
				   													 detailA= false; 
				   													 detailP = false;
				   													 btn_valider_dao_cpmp =  false;
				   													 btn_valider_dao_dmp = false;
				   													 btn_valider_ami_cpmp = false; 
				   													 btn_valider_prq_cpmp = false;
				   													 btn_valider_ami_dmp = false;
				   													 btn_valider_prq_dmp = false;
				   													 btn_fermer_saisie_dao = false; 
				   													 btn_fermer_saisie_ami = false; 
				   													 btn_fermer_saisie_prq = false;  
				   				    						   }else
				   				    							   if(action.equalsIgnoreCase("CHAAMI")) {
						   				    							 type = "AMI";
						   												 typePlan ="PN";
						   												 libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   										    			 libelleDao3="EXAMEN DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   										    			 btn_new =false;
				   										    			 btn_affec = false;
				   										    			 btn_exam = false;
				   										    			 btn_retrait = false;
				   										    			 btn_valid = false;
				   										    			panel1 =false;
																		 panel2 =false;
																		 panel3 = true;
																		 panel4 = false;
																		/* panel4 = false;
																		 panel5 = false;
																		 panel6 = false;
																		 panel7 = false;
																		 panel8 = true;
																		 panel9 = false;
																		 panel10 = false;
																		 panel11 = false;
																		 panel12 = false;*/
				   														 venteRecherche = false; 
				   														 affectationRecherche = false;
				   														 examenRecherche = false;
				   														 publicationRecherche = false;
				   														 saisieRecherche = false;
				   														 celluleRecherche = false;
				   														 validationRecherche = false;
				   														 priseRecherche = false;
				   														 chargeRecherche = true;
				   														 affDao=false;
				   														 exaDao=false;
				   														 retDao = true;
				   														 panelDaoTableauBordSai = false;
				   														 panelDaoTableauBordVal = false;
				   														 panelDaoTableauBordTra = false;
				   														 panelDaoTableauBordAff =false;
				   														 panelDaoTableauBordExa =false; 
				   														 panelDaoTableauBordRet =false; 
				   														 panelDaoTableauBordVet =false;
				   														 panelDaoTableauBordCha = true;
				   														 panelDaoTableauBordPub = false;
				   														 panelDaoTableauBordPrise = false;
				   														 panelDaoTableauBordPubCsv = false;
				   														 panelDaoTableauBordDPubCsv = false;
				   														 panelDaoTableauBordPubDps = false;
				   														 panelDaoTableauBordDPubCsv = false;
				   														 panelDaoTableauBordDPubDps = false;
				   														 panelDao = true;  
				   														 panelPrq = false;
				   														 btn_trans_ami =false;
				   														 btn_trans_dao =false;
				   														 btn_trans_prq =false;
				   														 
				   														 btn_creerDetailAmi = false;
				   														 btn_creerDetailDao = false ;
				   														 btn_creerDetailPrq = false;
				   														 
				   														 btn_creerDetailDaoCmp = false;
				   														 btn_creerDetailAmiCmp = false;
				   														 btn_creerDetailPrqCmp = false;
				   														 btn_creerDetailDaoDmp = false;
				   														 btn_creerDetailAmiDmp = false; 
				   														 btn_creerDetailPrqDmp = false;
				   														 fermerValDao = false;
				   														 fermerSaiDao = true;
				   														 detailD = false;
				   														 detailA= false; 
				   														 detailP = false;
				   														 btn_valider_dao_cpmp =  false;
				   														 btn_valider_dao_dmp = false;
				   														 btn_valider_ami_cpmp = false; 
				   														 btn_valider_prq_cpmp = false;
				   														 btn_valider_ami_dmp = false;
				   														 btn_valider_prq_dmp = false;
				   														 btn_fermer_saisie_dao = false; 
				   														 btn_fermer_saisie_ami = false; 
				   														 btn_fermer_saisie_prq = false;
				   				    								   
				   				    							   }else 
				   				    								   if(action.equalsIgnoreCase("PUBAMI")) {
					   				    									type = "AMI";
					   				    								    typePlan ="PN";
					   				    								    fonctionalite="ListePubDacPn";
					   				    								    libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   											    			 libelleDao3="AMI EN ATTENTE DE PUBLICATION";
				   											    			 btn_new =false;
				   											    			 btn_affec = false;
				   											    			 btn_pub =true;
				   											    			 btn_exam = false;
				   											    			 btn_retrait = false;
				   											    			 btn_valid = false;
				   											    			 panel1 =true;
																			 panel2 =false;
																			 panel3 = false;
																			 panel4 = false;
																			 /*panel5 = false;
																			 panel6 = false;
																			 panel7 = false;
																			 panel8 = true;
																			 panel9 = false;
																			 panel10 = false;
																			 panel11 = false;
																			 panel12 = false;*/
				   															 venteRecherche = false; 
				   															 affectationRecherche = false;
				   															 examenRecherche = false;
				   															 publicationRecherche = true;
				   															 saisieRecherche = false;
				   															 celluleRecherche = false;
				   															 validationRecherche = false;
				   															 priseRecherche = false;
				   															 chargeRecherche = false;
				   															 affDao=false;
				   															 exaDao=false;
				   															 retDao = false;
				   															 panelDaoTableauBordSai = false;
				   															 panelDaoTableauBordVal = false;
				   															 panelDaoTableauBordTra = false;
				   															 panelDaoTableauBordAff =false;
				   															 panelDaoTableauBordExa =false; 
				   															 panelDaoTableauBordRet =false;
				   															 panelDaoTableauBordVet =false;
				   															 panelDaoTableauBordCha = false;
				   															 panelDaoTableauBordPub = true;
				   															 panelDaoTableauBordPrise = false;
				   															 panelDaoTableauBordPubCsv = false;
					   														 panelDaoTableauBordDPubCsv = false;
					   														 panelDaoTableauBordPubDps = false;
					   														 panelDaoTableauBordDPubCsv = false;
					   														 panelDaoTableauBordDPubDps = false;
				   															 panelDao = false;  
				   															 panelPrq = false;
				   															 btn_trans_ami =false;
				   															 btn_trans_dao =false;
				   															 btn_trans_prq =false;
				   															 
				   															 btn_creerDetailAmi = false;
				   															 btn_creerDetailDao = false ;
				   															 btn_creerDetailPrq = false;
				   															 
				   															 btn_creerDetailDaoCmp = false;
				   															 btn_creerDetailAmiCmp = false;
				   															 btn_creerDetailPrqCmp = false;
				   															 btn_creerDetailDaoDmp = false;
				   															 btn_creerDetailAmiDmp = false; 
				   															 btn_creerDetailPrqDmp = false;
				   															 fermerValDao = false;
				   															 fermerSaiDao = true;
				   															 detailD = false;
				   															 detailA= false; 
				   															 detailP = false;
				   															 btn_valider_dao_cpmp =  false;
				   															 btn_valider_dao_dmp = false;
				   															 btn_valider_ami_cpmp = false; 
				   															 btn_valider_prq_cpmp = false;
				   															 btn_valider_ami_dmp = false;
				   															 btn_valider_prq_dmp = false;
				   															 btn_fermer_saisie_dao = false; 
				   															 btn_fermer_saisie_ami = false; 
				   															 btn_fermer_saisie_prq = false;   
				   				    								   }else
				   				    									     if(action.equalsIgnoreCase("TRAAMI")) {
				   				    									    	type = "AMI";
				   				    										    typePlan ="PN";
				   				    										     libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   												    			 libelleDao3="TRANSMISSION DU DAC PAR LA CELLULE";
				   												    			 libelleDao1 ="TRANSMISSION DU DAC PAR LA CELLULE";
				   												    			 btn_new =false;
				   												    			 btn_affec = false;
				   												    			 btn_exam = false;
				   												    			 btn_retrait = false;
				   												    			 btn_valid = false;
				   												    			panel1 =true;
																				 panel2 =false;
																				 panel3 = false;
																				 panel4 = false;
																				 /*panel5 = false;
																				 panel6 = false;
																				 panel7 = false;
																				 panel8 = true;
																				 panel9 = false;
																				 panel10 = false;
																				 panel11 = false;
																				 panel12 = false;*/
				   																 affDao=false;
				   																 exaDao=false;
				   																 retDao = true;
				   																 panelDaoTableauBordSai = false;
				   																 panelDaoTableauBordVal = false;
				   																 panelDaoTableauBordTra = true;
				   																 panelDaoTableauBordAff =false;
				   																 panelDaoTableauBordExa =false; 
				   																 panelDaoTableauBordRet =false; 
				   																 panelDaoTableauBordVet =false;
				   																 panelDaoTableauBordCha = false;
				   																 panelDaoTableauBordPub = false;
				   																 panelDaoTableauBordPrise = false;
				   																 panelDaoTableauBordPubCsv = false;
						   														 panelDaoTableauBordDPubCsv = false;
						   														 panelDaoTableauBordPubDps = false;
						   														 panelDaoTableauBordDPubCsv = false;
						   														 panelDaoTableauBordDPubDps = false;
				   																 panelDao = true;  
				   																 panelPrq = false;
				   																 btn_trans_ami =false;
				   																 btn_trans_dao =false;
				   																 btn_trans_prq =false;
				   																 
				   																 btn_creerDetailAmi = false;
				   																 btn_creerDetailDao = false ;
				   																 btn_creerDetailPrq = false;
				   																 
				   																 btn_creerDetailDaoCmp = false;
				   																 btn_creerDetailAmiCmp = false;
				   																 btn_creerDetailPrqCmp = false;
				   																 btn_creerDetailDaoDmp = false;
				   																 btn_creerDetailAmiDmp = false; 
				   																 btn_creerDetailPrqDmp = false;
				   																 fermerValDao = false;
				   																 fermerSaiDao = true;
				   																 detailD = false;
				   																 detailA= false; 
				   																 detailP = false;
				   																 btn_valider_dao_cpmp =  false;
				   																 btn_valider_dao_dmp = false;
				   																 btn_valider_ami_cpmp = false; 
				   																 btn_valider_prq_cpmp = false;
				   																 btn_valider_ami_dmp = false;
				   																 btn_valider_prq_dmp = false;
				   																 btn_fermer_saisie_dao = false; 
				   																 btn_fermer_saisie_ami = false; 
				   																 btn_fermer_saisie_prq = false; 
				   				    									     }else
				   				    									    	 if(action.equalsIgnoreCase("RETAMI")) {
				   				    									    		type = "AMI";
				   				    											    typePlan ="PN";
				   				    											    libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   													    			 libelleDao3="RETRAIT DES AVIS A MANIFESTATION D'INTERET 5AMI)";
				   													    			 btn_new =false;
				   													    			 btn_affec = false;
				   													    			 btn_exam = false;
				   													    			 btn_retrait = true;
				   													    			 btn_valid = false;
				   													    			panel1 =true;
																					 panel2 =false;
																					 panel3 = false;
																					panel4 = false;
																					 /*panel5 = false;
																					 panel6 = false;
																					 panel7 = false;
																					 panel8 = true;
																					 panel9 = false;
																					 panel10 = false;
																					 panel11 = false;
																					 panel12 = false;*/
				   																	 affDao=false;
				   																	 exaDao=false;
				   																	 retDao = true;
				   																	 panelDaoTableauBordSai = false;
				   																	 panelDaoTableauBordVal = false;
				   																	 panelDaoTableauBordTra = false;
				   																	 panelDaoTableauBordAff =false;
				   																	 panelDaoTableauBordExa =false; 
				   																	 panelDaoTableauBordRet =true; 
				   																	 panelDaoTableauBordVet =false;
				   																	 panelDaoTableauBordCha = false;
				   																	 panelDaoTableauBordPub = false;
				   																	 panelDaoTableauBordPrise = false;
				   																	 panelDaoTableauBordPubCsv = false;
							   														 panelDaoTableauBordDPubCsv = false;
							   														 panelDaoTableauBordPubDps = false;
							   														 panelDaoTableauBordDPubCsv = false;
							   														 panelDaoTableauBordDPubDps = false;
				   																	 panelDao = true;  
				   																	 panelPrq = false;
				   																	 btn_trans_ami =false;
				   																	 btn_trans_dao =false;
				   																	 btn_trans_prq =false;
				   																	 
				   																	 btn_creerDetailAmi = false;
				   																	 btn_creerDetailDao = false ;
				   																	 btn_creerDetailPrq = false;
				   																	 
				   																	 btn_creerDetailDaoCmp = false;
				   																	 btn_creerDetailAmiCmp = false;
				   																	 btn_creerDetailPrqCmp = false;
				   																	 btn_creerDetailDaoDmp = false;
				   																	 btn_creerDetailAmiDmp = false; 
				   																	 btn_creerDetailPrqDmp = false;
				   																	 fermerValDao = false;
				   																	 fermerSaiDao = true;
				   																	 detailD = false;
				   																	 detailA= false; 
				   																	 detailP = false;
				   																	 btn_valider_dao_cpmp =  false;
				   																	 btn_valider_dao_dmp = false;
				   																	 btn_valider_ami_cpmp = false; 
				   																	 btn_valider_prq_cpmp = false;
				   																	 btn_valider_ami_dmp = false;
				   																	 btn_valider_prq_dmp = false;
				   																	 btn_fermer_saisie_dao = false; 
				   																	 btn_fermer_saisie_ami = false; 
				   																	 btn_fermer_saisie_prq = false;  
				   								    						   }else
				   					    									    	 if(action.equalsIgnoreCase("OBSAMI")) {
				   					    									    		type = "AMI";
				   					    											    typePlan ="PN";
				   					    											    libelle1="LISTE DES AVIS A MANIFESTATION D'INTERET (AMI)";
				   														    			 libellesmall=" ";
				   														    			 libelleDao3="PRISE EN COMPTE DES OBSERVATIONS";
				   														    			fonctionalite="listeDaoCorrectionPn";
				   														    			 btn_new =false;
				   														    			 btn_affec = false;
				   														    			 btn_exam = false;
				   														    			 btn_retrait = true;
				   														    			 btn_valid = false;
				   														    			panel1 =true;
																						 panel2 =false;
																						 panel3 = false;
																						panel4 = false;
																						 /*panel5 = false;
																						 panel6 = false;
																						 panel7 = false;
																						 panel8 = true;
																						 panel9 = false;
																						 panel10 = false;
																						 panel11 = false;
																						 panel12 = false;*/
				   																		 venteRecherche = false; 
				   																		 affectationRecherche = false;
				   																		 examenRecherche = false;
				   																		 publicationRecherche = false;
				   																		 saisieRecherche = false;
				   																		 celluleRecherche = false;
				   																		 validationRecherche = false;
				   																		 priseRecherche = true;
				   																		 chargeRecherche = false;
				   																		 affDao=false;
				   																		 exaDao=false;
				   																		 retDao = true;
				   																		 panelDaoTableauBordSai = false;
				   																		 panelDaoTableauBordVal = false;
				   																		 panelDaoTableauBordTra = false;
				   																		 panelDaoTableauBordAff =false;
				   																		 panelDaoTableauBordExa =false; 
				   																		 panelDaoTableauBordRet =false; 
				   																		 panelDaoTableauBordVet =false;
				   																		 panelDaoTableauBordCha = false;
				   																		 panelDaoTableauBordPub = false;
				   																		 panelDaoTableauBordPrise = true;
				   																		 panelDaoTableauBordPubCsv = false;
								   														 panelDaoTableauBordDPubCsv = false;
								   														 panelDaoTableauBordPubDps = false;
								   														 panelDaoTableauBordDPubCsv = false;
								   														 panelDaoTableauBordDPubDps = false;
				   																		 panelDao = true;  
				   																		 panelPrq = false;
				   																		 btn_trans_ami =false;
				   																		 btn_trans_dao =false;
				   																		 btn_trans_prq =false;
				   																		 
				   																		 btn_creerDetailAmi = false;
				   																		 btn_creerDetailDao = false ;
				   																		 btn_creerDetailPrq = false;
				   																		 
				   																		 btn_creerDetailDaoCmp = false;
				   																		 btn_creerDetailAmiCmp = false;
				   																		 btn_creerDetailPrqCmp = false;
				   																		 btn_creerDetailDaoDmp = false;
				   																		 btn_creerDetailAmiDmp = false; 
				   																		 btn_creerDetailPrqDmp = false;
				   																		 fermerValDao = false;
				   																		 fermerSaiDao = true;
				   																		 detailD = false;
				   																		 detailA= false; 
				   																		 detailP = false;
				   																		 btn_valider_dao_cpmp =  false;
				   																		 btn_valider_dao_dmp = false;
				   																		 btn_valider_ami_cpmp = false; 
				   																		 btn_valider_prq_cpmp = false;
				   																		 btn_valider_ami_dmp = false;
				   																		 btn_valider_prq_dmp = false;
				   																		 btn_fermer_saisie_dao = false; 
				   																		 btn_fermer_saisie_ami = false; 
				   																		 btn_fermer_saisie_prq = false;  
				   									    						   }else 
												    								   if(action.equalsIgnoreCase("AMIDPS")) {
												    									     typePlan ="PS";
												    									     type = "AMI";
												    									     fonctionalite="listePubDamiCsv";
												    									     btn_pub =false;
												    									     btn_pub_csv = false;
												    									     btn_pub_dps = false;
												    									     btn_pub_dps = false;
												    									     btn_ami_csv = false;
												    									     btn_ami_dps = true;
												    									     libelle1="LISTE DES AMI EN PROCEDURE SIMPLIFIEE";
																			    			 libelleDao3="AVIS A MANIFESTATION D'INTERET EN ATTENTE DE PUBLICATION";
																			    			 btn_new =false;
																			    			 btn_affec = false;
																			    			 btn_exam = false;
																			    			 btn_retrait = false;
																			    			 btn_valid = false;
																			    			 saisie=false;
																			    			 publication=true;
																			    			 vente=false;
																			    			 correction=false;
																			    			 panel1 =false;
																							 panel2 =false;
																							 panel3 = false;
																						     panel4 = true;
																							/* panel5 = false;
																							 panel6 = false;
																							 panel7 = true;
																							 panel8 = false;
																							 panel9 =false;
																							 panel10 = false;
																							 panel11 = false;
																							 panel12 = false;*/
																							 venteRecherche = false; 
																							 affectationRecherche = false;
																							 examenRecherche = false;
																							 publicationRecherche = true;
																							 saisieRecherche = false;
																							 celluleRecherche = false;
																							 validationRecherche = false;
																							 priseRecherche = false;
																							 chargeRecherche = false;
																							 affDao=false;
																							 exaDao=false;
																							 retDao = false;
																							 panelDaoTableauBordSai = false;
																							 panelDaoTableauBordVal = false;
																							 panelDaoTableauBordTra = false;
																							 panelDaoTableauBordAff =false;
																							 panelDaoTableauBordExa =false; 
																							 panelDaoTableauBordRet =false;
																							 panelDaoTableauBordVet =false;
																							 panelDaoTableauBordCha = false;
																							 panelDaoTableauBordPub = false;
																							 panelDaoTableauBordPrise = false;
																							 panelDaoTableauBordPubDps = true;
																							 panelDaoTableauBordPubCsv = false;
																							 panelDaoTableauBordPubCsv = false;
									   														 panelDaoTableauBordDPubCsv = false;
									   														 panelDaoTableauBordPubDps = false;
									   														 panelDaoTableauBordDPubCsv = false;
									   														 panelDaoTableauBordDPubDps = false;
																							 panelDao = false;  
																							 panelPrq = false;
																							 btn_trans_ami =false;
																							 btn_trans_dao =false;
																							 btn_trans_prq =false;
																							 
																							 btn_creerDetailAmi = false;
																							 btn_creerDetailDao = false ;
																							 btn_creerDetailPrq = false;
																							 
																							 btn_creerDetailDaoCmp = false;
																							 btn_creerDetailAmiCmp = false;
																							 btn_creerDetailPrqCmp = false;
																							 btn_creerDetailDaoDmp = false;
																							 btn_creerDetailAmiDmp = false; 
																							 btn_creerDetailPrqDmp = false;
																							 fermerValDao = false;
																							 fermerSaiDao = true;
																							 detailD = false;
																							 detailA= false; 
																							 detailP = false;
																							 btn_valider_dao_cpmp =  false;
																							 btn_valider_dao_dmp = false;
																							 btn_valider_ami_cpmp = false; 
																							 btn_valider_prq_cpmp = false;
																							 btn_valider_ami_dmp = false;
																							 btn_valider_prq_dmp = false;
																							 btn_fermer_saisie_dao = false; 
																							 btn_fermer_saisie_ami = false; 
																							 btn_fermer_saisie_prq = false;   
												    								   }else 
													    								   if(action.equalsIgnoreCase("DAMIDPS")) {
													    									    typePlan ="PS";
													    									     type = "AMI";
													    									     fonctionalite="listePubAdpsCsv";
													    									     btn_pub =false;
													    									     btn_pub_csv = false;
													    									     btn_pub_dps = false;
													    									     btn_ami_csv = false;
													    									     btn_ami_dps = true;
													    									     btn_prq_csv = false;
													    									     btn_prq_dps = false; 
													    									     libelle1="LISTE DES AMI EN PROCEDURE SIMPLIFIEE";
																				    			 libelleDao3="AVIS A MANIFESTATION D'INTERET PUBLIES";
																				    			 btn_new =false;
																				    			 btn_affec = false;
																				    			 btn_exam = false;
																				    			 btn_retrait = false;
																				    			 btn_valid = false;
																				    			 saisie=false;
																				    			 publication=true;
																				    			 vente=false;
																				    			  correction=false;
																				    			 panel1 =false;
																								 panel2 =false;
																								 panel3 = false;
																							     panel4 = true;
																								/* panel5 = false;
																								 panel6 = false;
																								 panel7 = true;
																								 panel8 = false;
																								 panel9 =false;
																								 panel10 = false;
																								 panel11 = false;
																								 panel12 = false;*/
																								 venteRecherche = false; 
																								 affectationRecherche = false;
																								 examenRecherche = false;
																								 publicationRecherche = true;
																								 saisieRecherche = false;
																								 celluleRecherche = false;
																								 validationRecherche = false;
																								 priseRecherche = false;
																								 chargeRecherche = false;
																								 affDao=false;
																								 exaDao=false;
																								 retDao = false;
																								 panelDaoTableauBordSai = false;
																								 panelDaoTableauBordVal = false;
																								 panelDaoTableauBordTra = false;
																								 panelDaoTableauBordAff =false;
																								 panelDaoTableauBordExa =false; 
																								 panelDaoTableauBordRet =false;
																								 panelDaoTableauBordVet =false;
																								 panelDaoTableauBordCha = false;
																								 panelDaoTableauBordPub = false;
																								 panelDaoTableauBordPrise = false;
																								 panelDaoTableauBordPubDps = false;
																								 panelDaoTableauBordPubCsv = false;
																								 panelDaoTableauBordDPubCsv = false;
																								 panelDaoTableauBordDPubDps = true;
																								 panelDao = false;  
																								 panelPrq = false;
																								 btn_trans_ami =false;
																								 btn_trans_dao =false;
																								 btn_trans_prq =false;
																								 
																								 btn_creerDetailAmi = false;
																								 btn_creerDetailDao = false ;
																								 btn_creerDetailPrq = false;
																								 
																								 btn_creerDetailDaoCmp = false;
																								 btn_creerDetailAmiCmp = false;
																								 btn_creerDetailPrqCmp = false;
																								 btn_creerDetailDaoDmp = false;
																								 btn_creerDetailAmiDmp = false; 
																								 btn_creerDetailPrqDmp = false;
																								 fermerValDao = false;
																								 fermerSaiDao = true;
																								 detailD = false;
																								 detailA= false; 
																								 detailP = false;
																								 btn_valider_dao_cpmp =  false;
																								 btn_valider_dao_dmp = false;
																								 btn_valider_ami_cpmp = false; 
																								 btn_valider_prq_cpmp = false;
																								 btn_valider_ami_dmp = false;
																								 btn_valider_prq_dmp = false;
																								 btn_fermer_saisie_dao = false; 
																								 btn_fermer_saisie_ami = false; 
																								 btn_fermer_saisie_prq = false;   
													    								   }
				   					    									    	 else
			 
			 //DAO
				if(action.equalsIgnoreCase("ENGDAO")) {
				 typePlan ="PN";
				  type = "DAC";
				  libelleDao1="SAISIE D'UN NOUVEAU DOSSIER D'APPEL A CONCURRENCE (DAC)";
				  libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
			       libellesmall ="Saisie d'un nouveau DAC";
			       panelDetail=false;
				   panelForm=true;
				   panelTraitement=false;
			       panelRegister=true;
			       panelUpdate=false;
			       btn_fermer_saisie_dao = true;
   			       btn_fermer_saisie_daoPs =false;
   			       btn_fermer_saisie_ami = false ;
   			       btn_fermer_saisie_prq = false;                     
			    }else 
			    	if(action.equalsIgnoreCase("MODDAO")) {
			    		typePlan ="PN";
			    		type = "DAC";
			    		libelleDao1="MODIFICATION DU DOSSIER D'APPEL A CONCURRENCE N° ";
			    		 libelle1="Saisie d'un nouveau DAC";
			    		 update_fermer_dao=true;
			    		 update_fermer_ami=false;
			    		 update_fermer_prq=false;
			    		 update_fermer_dps=false;
					     panelDetail=false;
						 panelForm=true;
						 panelTraitement=false;
					     panelRegister=true;
					     panelUpdate=false;
					     btn_fermer_saisie_dao = true;
					     btn_fermer_saisie_ami = false ;
					     btn_fermer_saisie_prq = false  ;
			    	}else
			    		if(action.equalsIgnoreCase("SAIDAO")) {
			    			typePlan ="PN";
			    			type = "DAC";
			    			fonctionalite = "listSaisieAc";
			    			libelle="INFORMATIONS SUR L'AUTORITE CONTRACTANTE";
			    			libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
			    			libelleDao3="SAISIE DES DOSSIERS D'APPEL A CONCURRENCE";
			    			btn_daoPn =true;
			    			btn_daoPs =false;
			    			btn_ami =false;
			    			btn_prq =false;
			    			 btn_new =true;
			    			 btn_affec = false;
			    			 saisie=true;
			    			 publication=false;
			    			 vente=false;
			    			 correction=false;
			    			 panel1 =true;
							 panel2 =false;
							 panel3 = false;
							 panel4 = false;
						/*	 panel4 = false;
							 panel5 =false;
							 panel6 =false;
							 panel7=false;
							 panel8 =false;
							 panel9 = false;
							 panel10 = false;
							 panel11 = false;
							 panel12 = false;*/
							 venteRecherche = false; 
							 affectationRecherche = false;
							 examenRecherche = false;
							 publicationRecherche = false;
							 saisieRecherche = true;
							 celluleRecherche = false;
							 validationRecherche = false;
							 priseRecherche = false;
							 chargeRecherche = false;
							 panelDaoTableauBordSai = true;
							 panelDaoTableauBordPslpso = false;
							 panelDaoTableauBordVal = false;
							 panelDaoTableauBordTra = false;
							 panelDaoTableauBordPub = false;
							 pspmModePs = false;
							 ppmModePn = true;
							 btn_dao_pn = true;
							 btn_dao_ps = false;
							 panelDaoTableauBordAff =false;
							 panelDaoTableauBordExa =false; 
							 panelDaoTableauBordRet =false;
							 panelDaoTableauBordVet =false;
							 panelDaoTableauBordCha = false;
							 panelDaoTableauBordPrise = false;
							 panelDaoTableauBordDPubCsv = false;
							 panelDaoTableauBordDPubDps = false;
							 panelAmi = false;
							 panelDao = true;  
							 panelPrq = false;
							 btn_trans_ami =false;
							 btn_trans_dao =true;
							 btn_trans_prq =false;
							 
							 btn_creerDetailAmi = false;
							 btn_creerDetailDao = true ;
							 btn_creerDetailPrq = false;
							 
							 btn_creerDetailDaoCmp = true;
							 btn_creerDetailAmiCmp = false;
							 btn_creerDetailPrqCmp = false;
							 btn_creerDetailDaoDmp = true;
							 btn_creerDetailAmiDmp = false; 
							 btn_creerDetailPrqDmp = false;
							 fermerValDao = false;
							 fermerSaiDao = true;
							 detailD = true;
							 detailA= false; 
							 detailP = false;
							 btn_valider_dao_cpmp =  false;
							 btn_valider_dao_dmp = false;
							 btn_valider_ami_cpmp = false; 
							 btn_valider_prq_cpmp = false;
							 btn_valider_ami_dmp = false;
							 btn_valider_prq_dmp = false;
							 btn_fermer_saisie_dao = true; 
							 btn_fermer_saisie_ami = false; 
							 btn_fermer_saisie_prq = false; 
							 nbreAchat = false;
			    		}else
				    		if(action.equalsIgnoreCase("DAOPS")) {
				    			typePlan ="PN";
				    			type = "DAO";
				    			libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
				    			 libelleDao3="SAISIE DES DOSSIERS D'APPEL D'OFFRES";
				    			 libellesmall ="Procédure Normale";
				    			 btn_new =true;
				    			 btn_affec = false;
				    			 saisie=true;
				    			 publication=false;
				    			 vente=false;
				    			  correction=false;
				    			 panel1 =true;
								 panel2 =false;
								 panel3 = false;
								 panel4 = false;
								/* panel4 = false;
								 panel5 =false;
								 panel6 =false;
								 panel7=false;
								 panel8 =false;
								 panel9 = false;
								 panel10 = true;
								 panel11 = false;
								 panel12 = false;*/
								 panelDaoTableauBordSai = false;
								 panelDaoTableauBordPslpso = true;
								 panelDaoTableauBordVal = false;
								 panelDaoTableauBordTra = false;
								 panelDaoTableauBordPub = false;
								 panelDaoTableauBordDPubCsv = false;
								 panelDaoTableauBordDPubDps = false;
								 pspmModePs = true;
								 ppmModePn = false;
								 btn_dao_pn = false;
								 btn_dao_ps = true;
								 panelDaoTableauBordAff =false;
								 panelDaoTableauBordExa =false; 
								 panelDaoTableauBordRet =false;
								 panelDaoTableauBordVet =false;
								 panelDaoTableauBordCha = false;
								 panelDaoTableauBordPrise = false;

								 panelAmi = false;
								 panelDao = true;  
								 panelPrq = false;
								 btn_trans_ami =false;
								 btn_trans_dao =true;
								 btn_trans_prq =false;
								 
								 btn_creerDetailAmi = false;
								 btn_creerDetailDao = true ;
								 btn_creerDetailPrq = false;
								 
								 btn_creerDetailDaoCmp = true;
								 btn_creerDetailAmiCmp = false;
								 btn_creerDetailPrqCmp = false;
								 btn_creerDetailDaoDmp = true;
								 btn_creerDetailAmiDmp = false; 
								 btn_creerDetailPrqDmp = false;
								 fermerValDao = false;
								 fermerSaiDao = true;
								 detailD = true;
								 detailA= false; 
								 detailP = false;
								 btn_valider_dao_cpmp =  false;
								 btn_valider_dao_dmp = false;
								 btn_valider_ami_cpmp = false; 
								 btn_valider_prq_cpmp = false;
								 btn_valider_ami_dmp = false;
								 btn_valider_prq_dmp = false;
								 btn_fermer_saisie_dao = true; 
								 btn_fermer_saisie_ami = false; 
								 btn_fermer_saisie_prq = false; 
								 nbreAchat = false;
				    		}else
			    			    if(action.equalsIgnoreCase("VALDAO")) {
			    			    typePlan ="PN";
			    				type = "DAC";
			    				fonctionalite ="listeValidationCsv";
			    				libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
			    				libelleDao3="VALIDATION DES DOSSIERS D'APPEL A CONCURRENCE";
			    				libelleDao1="TRANSMISSION DES DOSSIERS D'APPEL A CONCURRENCE";
			    				panelDetail=false;
			    				panelForm=false;
			   				    panelTraitement=true;
			    				btn_new =false;
			    				saisie=false;
				    			publication=false;
				    			vente=false;
				    			correction=false;
			    				btn_affec = false;
			    				btn_retrait = false;
			    				btn_valid = true;
			    				panel1 =true;
								panel2 =false;
								panel3 = false;
								panel4 = false;
							/*	panel4 =false;
								panel5 =false;
								panel6=false;
								panel7 = false;
								panel8 = false;
								panel9 = false;
								panel10=false;
								panel11 = false;
								panel12 = false;*/
								venteRecherche = false; 
								affectationRecherche = false;
								examenRecherche = false;
								publicationRecherche = false;
								saisieRecherche = false;
								celluleRecherche = false;
								validationRecherche = true;
								priseRecherche = false;
								chargeRecherche = false;
								affDao=false;
								exaDao=false;
								panelDaoTableauBordAff =false;
								panelDaoTableauBordRet = false;
								panelDaoTableauBordSai = false;
								panelDaoTableauBordPslpso = false;
								panelDaoTableauBordVal = true;
								panelDaoTableauBordTra = false;
								panelDaoTableauBordVet =false;
								panelDaoTableauBordExa = false;
								panelDaoTableauBordCha = false;
								panelDaoTableauBordPub = false;
								panelDaoTableauBordPrise = false;
								panelDaoTableauBordPubDps = false;
								panelDaoTableauBordPubCsv = false;
								panelDaoTableauBordDPubCsv = false;
								panelDaoTableauBordDPubDps = false;
								panelDao = true;
								panelPrq =false;
							    panelAmi = false;
								fermerValDao =true;
								fermerSaiDao = false;
								btn_trans_ami =false;
								btn_trans_dao =false;
								btn_trans_prq =false;
								detailD = true ;
								detailA = false; 
								detailP = false;
								btn_valider_prq_cpmp = false;
								btn_valider_prq_dmp = false; 
								btn_valider_ami_cpmp = false; 
								btn_valider_ami_dmp = false;
								btn_valider_dao_cpmp = true;
								btn_valider_dao_dmp = true;
								btn_fermer_saisie_ami = false; 
								btn_fermer_saisie_prq = false;
								btn_fermer_saisie_dao = true;
								nbreAchat = false;
			    			}else
				    			if(action.equalsIgnoreCase("APEDAO")) {
				    				typePlan ="PN";
				    				type = "DAC";
				    				libelleDao3="DETAILS DU";
				    				panelDetail=true;
				    				panelForm=false;
				   				    panelTraitement=false;
				    				libelle1="Detail";
				    				libelle2 = "Synthèse du DAC N°";
				    				fermerSaiPrq = false; 
				    				fermerValPrq = false;
				    				fermerSaiAmi = false;
				    				fermerValAmi = false;
				    				fermerSaiDao = true;
				    				fermerValDao = false;
				    				etat_dao =true;
				    				etat_prq =false;
				    				etat_ami =false;
				    				detailD = true ;
									detailA = false; 
									detailP = false;
									fermerApercuDao = true;
									fermerApercuAmi = false;
									fermerApercuPrq = false;
									nbreAchat = false;
				    			}else
				    				 if(action.equalsIgnoreCase("AFFDAO")) {
				    					 typePlan ="PN";
				    				        type = "DAC";
				    				        fonctionalite ="listeAffectationCsv";
				    				        libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
							    			 libelleDao3="AFFECTATION DES DOSSIERS D'APPEL D'OFFRES";
							    			 btn_new =false;
							    			 btn_affec = true;
							    			 btn_retrait = false;
							    			 btn_valid = false;
							    			 panel1 =true;
											 panel2 =false;
											 panel3 = false;
											 panel4 = false;
									/*		 panel4 = false;
											 panel5 = false;
											 panel6=false;
											 panel7 = false;
											 panel8 = false;
											 panel9 = false;
											 panel10 = false;
											 panel11 = false;
											 panel12 = false;*/
											 venteRecherche = false; 
											 affectationRecherche = true;
											 examenRecherche = false;
											 publicationRecherche = false;
											 saisieRecherche = false;
											 celluleRecherche = false;
											 validationRecherche = false;
											 priseRecherche = false;
											 chargeRecherche = false;
											 
											 panelAffectation = true;
											 affDao=true;
											 exaDao=false;
											 panelDaoTableauBordSai = false;
											 panelDaoTableauBordVal = false;
											 panelDaoTableauBordTra = false;
											 panelDaoTableauBordAff =true;
											 panelDaoTableauBordVet =false;
											 panelDaoTableauBordRet = false;
											 panelDaoTableauBordCha = false;
											 panelDaoTableauBordPub = false;
											 panelDaoTableauBordPrise = false;
											 panelDaoTableauBordPubDps = false;
											 panelDaoTableauBordPubCsv = false;
											 panelDaoTableauBordDPubCsv = false;
											 panelDaoTableauBordDPubDps = false;
											 panelDao = true;  
											 panelPrq = false;
											 btn_trans_ami =false;
											 btn_trans_dao =true;
											 btn_trans_prq =false;
											 
											 btn_creerDetailAmi = false;
											 btn_creerDetailDao = false ;
											 btn_creerDetailPrq = false;
											 
											 btn_creerDetailDaoCmp = true;
											 btn_creerDetailAmiCmp = false;
											 btn_creerDetailPrqCmp = false;
											 btn_creerDetailDaoDmp = false;
											 btn_creerDetailAmiDmp = false; 
											 btn_creerDetailPrqDmp = false;
											 fermerValDao = false;
											 fermerSaiDao = true;
											 detailD = false;
											 detailA= false; 
											 detailP = false;
											 btn_valider_dao_cpmp =  false;
											 btn_valider_dao_dmp = false;
											 btn_valider_ami_cpmp = false; 
											 btn_valider_prq_cpmp = false;
											 btn_valider_ami_dmp = false;
											 btn_valider_prq_dmp = false;
											 btn_fermer_saisie_dao = false; 
											 btn_fermer_saisie_ami = false; 
											 btn_fermer_saisie_prq = false;
											 nbreAchat = false;
				    				 }else
				    					  if(action.equalsIgnoreCase("EXADAO")) {
				    						  typePlan ="PN";
				    						     type = "DAC";
				    						     libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
								    			 libelleDao3="EXAMEN DES DOSSIERS D'APPEL A CONCURRENCE";
								    			 btn_new =false;
								    			 btn_affec = false;
								    			 saisie=false;
								    			 publication=false;
								    			 vente=false;
								    			  correction=false;
								    			 btn_exam = true;
								    			 btn_valid = false;
								    			 panel1 =true;
												 panel2 =false;
												 panel3 = false;
												 panel4 = false;
											/*	 panel4 = true;
												 panel5 = false;
												 panel6 = false;
												 panel7=false;
												 panel8 =false;
												 panel9 =false;
												 panel10 = false;
												 panel11 = false;
												 panel12 = false;*/
												 venteRecherche = false; 
												 affectationRecherche = false;
												 examenRecherche = true;
												 publicationRecherche = false;
												 saisieRecherche = false;
												 celluleRecherche = false;
												 validationRecherche = false;
												 priseRecherche = false;
												 chargeRecherche = false;
												 panelAffectation = false;
												 affDao=false;
												 exaDao=true;
												 panelDaoTableauBordSai = false;
												 panelDaoTableauBordVal = false;
												 panelDaoTableauBordTra = false;
												 panelDaoTableauBordAff =false;
												 panelDaoTableauBordExa =true;
												 panelDaoTableauBordVet =false;
												 panelDaoTableauBordCha = false;
												 panelDaoTableauBordPub = false;
												 panelDaoTableauBordPrise = false;
												 panelDaoTableauBordPubDps = false;
												 panelDaoTableauBordPubCsv = false;
												 panelDaoTableauBordDPubCsv = false;
												 panelDaoTableauBordDPubDps = false;
												 panelDao = true;  
												 panelPrq = false;
												 btn_trans_ami =false;
												 btn_trans_dao =false;
												 btn_trans_prq =false;
												 
												 btn_creerDetailAmi = false;
												 btn_creerDetailDao = false ;
												 btn_creerDetailPrq = false;
												 
												 btn_creerDetailDaoCmp = false;
												 btn_creerDetailAmiCmp = false;
												 btn_creerDetailPrqCmp = false;
												 btn_creerDetailDaoDmp = false;
												 btn_creerDetailAmiDmp = false; 
												 btn_creerDetailPrqDmp = false;
												 fermerValDao = false;
												 fermerSaiDao = true;
												 detailD = false;
												 detailA= false; 
												 detailP = false;
												 btn_valider_dao_cpmp =  false;
												 btn_valider_dao_dmp = false;
												 btn_valider_ami_cpmp = false; 
												 btn_valider_prq_cpmp = false;
												 btn_valider_ami_dmp = false;
												 btn_valider_prq_dmp = false;
												 btn_fermer_saisie_dao = false; 
												 btn_fermer_saisie_ami = false; 
												 btn_fermer_saisie_prq = false; 
												 nbreAchat = false;
				    					  }else
				    						   if(action.equalsIgnoreCase("VETDAO")) {
				    							   typePlan ="PN";
				    							     type = "DAC";
				    							     libelle="VENTE / RETRAIT DU DAC N°";
				    							     libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
									    			 libelleDao3="VENTE DES DOSSIERS D'APPEL A CONCURRENCE";
									    			 fonctionalite="listeDaoVentePn";
									    			 btn_new =false;
									    			 btn_affec = false;
									    			 btn_exam = false;
									    			 btn_retrait = true;
									    			 btn_valid = false;
									    			 saisie=false;
									    			 publication=false;
									    			 vente=true;
									    			 correction=false;
									    			 panel1 =true;
													 panel2 =false;
													 panel3 = false;
													 panel4 = false;
												/*	 panel4 = false;
													 panel5 = false;
													 panel6 = false;
													 panel7 = false;
													 panel8 = false;
													 panel9 =true;
													 panel10 = false;
													 panel11 = false;
													 panel12 = false;*/
													 venteRecherche = true; 
													 affectationRecherche = false;
													 examenRecherche = false;
													 publicationRecherche = false;
													 saisieRecherche = false;
													 celluleRecherche = false;
													 validationRecherche = false;
													 priseRecherche = false;
													 chargeRecherche = false;
													 affDao=false;
													 exaDao=false;
													 retDao = true;
													 panelDaoTableauBordSai = false;
													 panelDaoTableauBordVal = false;
													 panelDaoTableauBordTra = false;
													 panelDaoTableauBordAff =false;
													 panelDaoTableauBordExa =false; 
													 panelDaoTableauBordRet =false; 
													 panelDaoTableauBordVet =true;
													 panelDaoTableauBordCha = false;
													 panelDaoTableauBordPub = false;
													 panelDaoTableauBordPrise = false;
													 panelDaoTableauBordPubDps = false;
													 panelDaoTableauBordPubCsv = false;
													 panelDaoTableauBordDPubCsv = false;
													 panelDaoTableauBordDPubDps = false;
													 panelDao = true;  
													 panelPrq = false;
													 btn_trans_ami =false;
													 btn_trans_dao =false;
													 btn_trans_prq =false;
													 
													 btn_creerDetailAmi = false;
													 btn_creerDetailDao = false ;
													 btn_creerDetailPrq = false;
													 
													 btn_creerDetailDaoCmp = false;
													 btn_creerDetailAmiCmp = false;
													 btn_creerDetailPrqCmp = false;
													 btn_creerDetailDaoDmp = false;
													 btn_creerDetailAmiDmp = false; 
													 btn_creerDetailPrqDmp = false;
													 fermerValDao = false;
													 fermerSaiDao = true;
													 detailD = false;
													 detailA= false; 
													 detailP = false;
													 btn_valider_dao_cpmp =  false;
													 btn_valider_dao_dmp = false;
													 btn_valider_ami_cpmp = false; 
													 btn_valider_prq_cpmp = false;
													 btn_valider_ami_dmp = false;
													 btn_valider_prq_dmp = false;
													 btn_fermer_saisie_dao = false; 
													 btn_fermer_saisie_ami = false; 
													 btn_fermer_saisie_prq = false;
													 nbreAchat = true;
				    						   }else
				    							   if(action.equalsIgnoreCase("CHADAO")) {
				    								     typePlan ="PN";
				    								     type = "DAC";
				    								     libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
										    			 libelleDao3="EXAMEN DES DOSSIERS D'APPEL A CONCURRENCE";
										    			 btn_new =false;
										    			 btn_affec = false;
										    			 btn_exam = false;
										    			 btn_retrait = false;
										    			 btn_valid = false;
										    			 saisie=false;
										    			 publication=false;
										    			 vente=false;
										    			  correction=false;
														 panel1 =false;
														 panel2 =false;
														 panel3 = true;
														 panel4 = false;
														 /*panel4 = false;
														 panel5 = false;
														 panel6 = true;
														 panel7 =false;
														 panel8 =false;
														 panel9 =false;
														 panel10 = false;
														 panel11 = false;
														 panel12 = false;*/
														 venteRecherche = false; 
														 affectationRecherche = false;
														 examenRecherche = false;
														 publicationRecherche = false;
														 saisieRecherche = false;
														 celluleRecherche = false;
														 validationRecherche = false;
														 priseRecherche = false;
														 chargeRecherche = true;
														 affDao=false;
														 exaDao=false;
														 retDao = true;
														 panelDaoTableauBordSai = false;
														 panelDaoTableauBordVal = false;
														 panelDaoTableauBordTra = false;
														 panelDaoTableauBordAff =false;
														 panelDaoTableauBordExa =false; 
														 panelDaoTableauBordRet =false; 
														 panelDaoTableauBordVet =false;
														 panelDaoTableauBordCha = true;
														 panelDaoTableauBordPub = false;
														 panelDaoTableauBordPrise = false;
														 panelDaoTableauBordPubDps = false;
														 panelDaoTableauBordPubCsv = false;
														 panelDaoTableauBordDPubCsv = false;
														 panelDaoTableauBordDPubDps = false;
														 panelDao = true;  
														 panelPrq = false;
														 btn_trans_ami =false;
														 btn_trans_dao =false;
														 btn_trans_prq =false;
														 
														 btn_creerDetailAmi = false;
														 btn_creerDetailDao = false ;
														 btn_creerDetailPrq = false;
														 
														 btn_creerDetailDaoCmp = false;
														 btn_creerDetailAmiCmp = false;
														 btn_creerDetailPrqCmp = false;
														 btn_creerDetailDaoDmp = false;
														 btn_creerDetailAmiDmp = false; 
														 btn_creerDetailPrqDmp = false;
														 fermerValDao = false;
														 fermerSaiDao = true;
														 detailD = false;
														 detailA= false; 
														 detailP = false;
														 btn_valider_dao_cpmp =  false;
														 btn_valider_dao_dmp = false;
														 btn_valider_ami_cpmp = false; 
														 btn_valider_prq_cpmp = false;
														 btn_valider_ami_dmp = false;
														 btn_valider_prq_dmp = false;
														 btn_fermer_saisie_dao = false; 
														 btn_fermer_saisie_ami = false; 
														 btn_fermer_saisie_prq = false;
														 nbreAchat = false;
				    							   }else 
				    								   if(action.equalsIgnoreCase("PUBDAO")) {
				    									    typePlan ="PN";
				    									     type = "DAC";
				    									     fonctionalite="ListePubDacPn";
				    									     btn_pub =true;
				    									     libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
											    			 libelleDao3="DOSSIER D'APPEL A CONCURRENCE EN ATTENTE DE PUBLICATION";
											    			 btn_new =false;
											    			 btn_affec = false;
											    			 btn_exam = false;
											    			 btn_retrait = false;
											    			 btn_valid = false;
											    			 saisie=false;
											    			 publication=true;
											    			 vente=false;
											    			  correction=false;
											    			 panel1 =true;
															 panel2 =false;
															 panel3 = false;
															 panel4 = false;
														/*	 panel4 = false;
															 panel5 = false;
															 panel6 = false;
															 panel7 = true;
															 panel8 = false;
															 panel9 =false;
															 panel10 = false;
															 panel11 = false;
															 panel12 = false;*/
															 venteRecherche = false; 
															 affectationRecherche = false;
															 examenRecherche = false;
															 publicationRecherche = true;
															 saisieRecherche = false;
															 celluleRecherche = false;
															 validationRecherche = false;
															 priseRecherche = false;
															 chargeRecherche = false;
															 affDao=false;
															 exaDao=false;
															 retDao = false;
															 panelDaoTableauBordSai = false;
															 panelDaoTableauBordVal = false;
															 panelDaoTableauBordTra = false;
															 panelDaoTableauBordAff =false;
															 panelDaoTableauBordExa =false; 
															 panelDaoTableauBordRet =false;
															 panelDaoTableauBordVet =false;
															 panelDaoTableauBordCha = false;
															 panelDaoTableauBordPub = true;
															 panelDaoTableauBordPrise = false;
															 panelDaoTableauBordPubDps = false;
															 panelDaoTableauBordPubCsv = false;
															 panelDaoTableauBordDPubCsv = false;
															 panelDaoTableauBordDPubDps = false;
															 panelDao = false;  
															 panelPrq = false;
															 btn_trans_ami =false;
															 btn_trans_dao =false;
															 btn_trans_prq =false;
															 
															 btn_creerDetailAmi = false;
															 btn_creerDetailDao = false ;
															 btn_creerDetailPrq = false;
															 
															 btn_creerDetailDaoCmp = false;
															 btn_creerDetailAmiCmp = false;
															 btn_creerDetailPrqCmp = false;
															 btn_creerDetailDaoDmp = false;
															 btn_creerDetailAmiDmp = false; 
															 btn_creerDetailPrqDmp = false;
															 fermerValDao = false;
															 fermerSaiDao = true;
															 detailD = false;
															 detailA= false; 
															 detailP = false;
															 btn_valider_dao_cpmp =  false;
															 btn_valider_dao_dmp = false;
															 btn_valider_ami_cpmp = false; 
															 btn_valider_prq_cpmp = false;
															 btn_valider_ami_dmp = false;
															 btn_valider_prq_dmp = false;
															 btn_fermer_saisie_dao = false; 
															 btn_fermer_saisie_ami = false; 
															 btn_fermer_saisie_prq = false;  
															 nbreAchat = false;
				    								   }else
				    									     if(action.equalsIgnoreCase("TRADAO")) {
				    									    	 typePlan ="PN";
				    									    	 type = "DAC";
				    									    	 libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
												    			 libelleDao3="TRANSMISSION DU DAC PAR LA CELLULE";
												    			 libelleDao1 ="TRANSMISSION DU DAC PAR LA CELLULE";
												    			 btn_new =false;
												    			 btn_affec = false;
												    			 btn_exam = false;
												    			 btn_retrait = false;
												    			 btn_valid = false;
												    			 saisie=false;
												    			 publication=false;
												    			 vente=false;
												    			  correction=false;
												    			 panel1 =true;
																 panel2 =false;
																 panel3 = false;
																 panel4 = false;
															/*	 panel4 = false;
																 panel5 = false;
																 panel6 = false;
																 panel7 = false;
																 panel8 = true;
																 panel9 = false;
																 panel10 = false;
																 panel11 = false;
																 panel12 = false;*/
																 affDao=false;
																 exaDao=false;
																 retDao = true;
																 panelDaoTableauBordSai = false;
																 panelDaoTableauBordVal = false;
																 panelDaoTableauBordTra = true;
																 panelDaoTableauBordAff =false;
																 panelDaoTableauBordExa =false; 
																 panelDaoTableauBordRet =false; 
																 panelDaoTableauBordVet =false;
																 panelDaoTableauBordCha = false;
																 panelDaoTableauBordPub = false;
																 panelDaoTableauBordPrise = false;
																 panelDaoTableauBordPubDps = false;
																 panelDaoTableauBordPubCsv = false;
																 panelDaoTableauBordDPubCsv = false;
																 panelDaoTableauBordDPubDps = false;
																 panelDao = true;  
																 panelPrq = false;
																 btn_trans_ami =false;
																 btn_trans_dao =false;
																 btn_trans_prq =false;
																 
																 btn_creerDetailAmi = false;
																 btn_creerDetailDao = false ;
																 btn_creerDetailPrq = false;
																 
																 btn_creerDetailDaoCmp = false;
																 btn_creerDetailAmiCmp = false;
																 btn_creerDetailPrqCmp = false;
																 btn_creerDetailDaoDmp = false;
																 btn_creerDetailAmiDmp = false; 
																 btn_creerDetailPrqDmp = false;
																 fermerValDao = false;
																 fermerSaiDao = true;
																 detailD = false;
																 detailA= false; 
																 detailP = false;
																 btn_valider_dao_cpmp =  false;
																 btn_valider_dao_dmp = false;
																 btn_valider_ami_cpmp = false; 
																 btn_valider_prq_cpmp = false;
																 btn_valider_ami_dmp = false;
																 btn_valider_prq_dmp = false;
																 btn_fermer_saisie_dao = false; 
																 btn_fermer_saisie_ami = false; 
																 btn_fermer_saisie_prq = false; 
																 nbreAchat = false;
				    									     }else
				    									    	 if(action.equalsIgnoreCase("RETDAO")) {
				    									    		 typePlan ="PN";
								    							     type = "DAO";
								    							     libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
													    			 libelleDao3="RETRAIT DES DOSSIERS D'APPEL D'OFFRES";
													    			 btn_new =false;
													    			 btn_affec = false;
													    			 btn_exam = false;
													    			 btn_retrait = true;
													    			 btn_valid = false;
													    			 saisie=false;
													    			 publication=false;
													    			 vente=true;
													    			  correction=false;
													    			 panel1 =true;
																	 panel2 =false;
																	 panel3 = false;
																	 panel4 = false;
																/*	 panel4 = false;
																	 panel5 = false;
																	 panel6 = false;
																	 panel7 = false;
																	 panel8 = false;
																	 panel9 = false;
																	 panel10 =false;
																	 panel11 = true;
																	 panel12 = false;*/
																	 affDao=false;
																	 exaDao=false;
																	 retDao = true;
																	 panelDaoTableauBordSai = false;
																	 panelDaoTableauBordVal = false;
																	 panelDaoTableauBordTra = false;
																	 panelDaoTableauBordAff =false;
																	 panelDaoTableauBordExa =false; 
																	 panelDaoTableauBordRet =true; 
																	 panelDaoTableauBordVet =false;
																	 panelDaoTableauBordCha = false;
																	 panelDaoTableauBordPub = false;
																	 panelDaoTableauBordPrise = false;
																	 panelDaoTableauBordPubDps = false;
																	 panelDaoTableauBordPubCsv = false;
																	 panelDaoTableauBordDPubCsv = false;
																	 panelDaoTableauBordDPubDps = false;
																	 panelDao = true;  
																	 panelPrq = false;
																	 btn_trans_ami =false;
																	 btn_trans_dao =false;
																	 btn_trans_prq =false;
																	 
																	 btn_creerDetailAmi = false;
																	 btn_creerDetailDao = false ;
																	 btn_creerDetailPrq = false;
																	 
																	 btn_creerDetailDaoCmp = false;
																	 btn_creerDetailAmiCmp = false;
																	 btn_creerDetailPrqCmp = false;
																	 btn_creerDetailDaoDmp = false;
																	 btn_creerDetailAmiDmp = false; 
																	 btn_creerDetailPrqDmp = false;
																	 fermerValDao = false;
																	 fermerSaiDao = true;
																	 detailD = false;
																	 detailA= false; 
																	 detailP = false;
																	 btn_valider_dao_cpmp =  false;
																	 btn_valider_dao_dmp = false;
																	 btn_valider_ami_cpmp = false; 
																	 btn_valider_prq_cpmp = false;
																	 btn_valider_ami_dmp = false;
																	 btn_valider_prq_dmp = false;
																	 btn_fermer_saisie_dao = false; 
																	 btn_fermer_saisie_ami = false; 
																	 btn_fermer_saisie_prq = false; 
																	 nbreAchat = false;
								    						   }else
					    									    	 if(action.equalsIgnoreCase("OBSDAO")) {
					    									    		 typePlan ="PN";
									    							     type = "DAC";
									    							     libelle1="LISTE DES DAO EN PROCEDURE NORMALE";
														    			 libellesmall="Procédure Normale";
														    			 libelleDao3="PRISE EN COMPTE DES OBSERVATIONS";
														    			 btn_new =false;
														    			 btn_affec = false;
														    			 btn_exam = false;
														    			 btn_retrait = true;
														    			 btn_valid = false;
														    			 fonctionalite="listeDaoCorrectionPn";
														    			 saisie=false;
														    			 publication=false;
														    			 vente=false;
														    			  correction=true;
														    			 panel1 =true;
																		 panel2 =false;
																		 panel3 = false;
																		 panel4 = false;
																/*		 panel4 = false;
																		 panel5 = false;
																		 panel6 = false;
																		 panel7 = false;
																		 panel8 = false;
																		 panel9 = false;
																		 panel10 =false;
																		 panel11 = false;
																		 panel12 = true;*/
																		 venteRecherche = false; 
																		 affectationRecherche = false;
																		 examenRecherche = false;
																		 publicationRecherche = false;
																		 saisieRecherche = false;
																		 celluleRecherche = false;
																		 validationRecherche = false;
																		 priseRecherche = true;
																		 chargeRecherche = false;
																		 affDao=false;
																		 exaDao=false;
																		 retDao = true;
																		 panelDaoTableauBordSai = false;
																		 panelDaoTableauBordVal = false;
																		 panelDaoTableauBordTra = false;
																		 panelDaoTableauBordAff =false;
																		 panelDaoTableauBordExa =false; 
																		 panelDaoTableauBordRet =false; 
																		 panelDaoTableauBordVet =false;
																		 panelDaoTableauBordCha = false;
																		 panelDaoTableauBordPub = false;
																		 panelDaoTableauBordPrise = true;
																		 panelDaoTableauBordPubDps = false;
																		 panelDaoTableauBordPubCsv = false;
																		 panelDaoTableauBordDPubCsv = false;
																		 panelDaoTableauBordDPubDps = false;
																		 panelDao = true;  
																		 panelPrq = false;
																		 btn_trans_ami =false;
																		 btn_trans_dao =false;
																		 btn_trans_prq =false;
																		 
																		 btn_creerDetailAmi = false;
																		 btn_creerDetailDao = false ;
																		 btn_creerDetailPrq = false;
																		 
																		 btn_creerDetailDaoCmp = false;
																		 btn_creerDetailAmiCmp = false;
																		 btn_creerDetailPrqCmp = false;
																		 btn_creerDetailDaoDmp = false;
																		 btn_creerDetailAmiDmp = false; 
																		 btn_creerDetailPrqDmp = false;
																		 fermerValDao = false;
																		 fermerSaiDao = true;
																		 detailD = false;
																		 detailA= false; 
																		 detailP = false;
																		 btn_valider_dao_cpmp =  false;
																		 btn_valider_dao_dmp = false;
																		 btn_valider_ami_cpmp = false; 
																		 btn_valider_prq_cpmp = false;
																		 btn_valider_ami_dmp = false;
																		 btn_valider_prq_dmp = false;
																		 btn_fermer_saisie_dao = false; 
																		 btn_fermer_saisie_ami = false; 
																		 btn_fermer_saisie_prq = false; 
																		 nbreAchat = false;
									    						   }else 
								    								   if(action.equalsIgnoreCase("PUBCSV")) {
								    									    typePlan ="PN";
								    									     type = "DAC";
								    									     fonctionalite="listePubCsv";
								    									     btn_pub =false;
								    									     btn_pub_csv = true;
								    									     btn_pub_dps = false;
								    									     btn_ami_csv = false;
								    									     btn_prq_dps = false;
								    									     libelle1="LISTE DES DAC EN PROCEDURE NORMALE";
															    			 libelleDao3="DOSSIER D'APPEL A CONCURRENCE EN ATTENTE DE PUBLICATION";
															    			 btn_new =false;
															    			 btn_affec = false;
															    			 btn_exam = false;
															    			 btn_retrait = false;
															    			 btn_valid = false;
															    			 saisie=false;
															    			 publication=true;
															    			 vente=false;
															    			  correction=false;
															    			 panel1 =false;
																			 panel2 =false;
																			 panel3 = false;
																		     panel4 = true;
																			/* panel5 = false;
																			 panel6 = false;
																			 panel7 = true;
																			 panel8 = false;
																			 panel9 =false;
																			 panel10 = false;
																			 panel11 = false;
																			 panel12 = false;*/
																			 venteRecherche = false; 
																			 affectationRecherche = false;
																			 examenRecherche = false;
																			 publicationRecherche = true;
																			 saisieRecherche = false;
																			 celluleRecherche = false;
																			 validationRecherche = false;
																			 priseRecherche = false;
																			 chargeRecherche = false;
																			 affDao=false;
																			 exaDao=false;
																			 retDao = false;
																			 panelDaoTableauBordSai = false;
																			 panelDaoTableauBordVal = false;
																			 panelDaoTableauBordTra = false;
																			 panelDaoTableauBordAff =false;
																			 panelDaoTableauBordExa =false; 
																			 panelDaoTableauBordRet =false;
																			 panelDaoTableauBordVet =false;
																			 panelDaoTableauBordCha = false;
																			 panelDaoTableauBordPub = false;
																			 panelDaoTableauBordPrise = false;
																			 panelDaoTableauBordPubDps = false;
																			 panelDaoTableauBordPubCsv = true;
																			 panelDaoTableauBordDPubCsv = false;
																			 panelDaoTableauBordDPubDps = false;
																			 panelDao = false;  
																			 panelPrq = false;
																			 btn_trans_ami =false;
																			 btn_trans_dao =false;
																			 btn_trans_prq =false;
																			 
																			 btn_creerDetailAmi = false;
																			 btn_creerDetailDao = false ;
																			 btn_creerDetailPrq = false;
																			 
																			 btn_creerDetailDaoCmp = false;
																			 btn_creerDetailAmiCmp = false;
																			 btn_creerDetailPrqCmp = false;
																			 btn_creerDetailDaoDmp = false;
																			 btn_creerDetailAmiDmp = false; 
																			 btn_creerDetailPrqDmp = false;
																			 fermerValDao = false;
																			 fermerSaiDao = true;
																			 detailD = false;
																			 detailA= false; 
																			 detailP = false;
																			 btn_valider_dao_cpmp =  false;
																			 btn_valider_dao_dmp = false;
																			 btn_valider_ami_cpmp = false; 
																			 btn_valider_prq_cpmp = false;
																			 btn_valider_ami_dmp = false;
																			 btn_valider_prq_dmp = false;
																			 btn_fermer_saisie_dao = false; 
																			 btn_fermer_saisie_ami = false; 
																			 btn_fermer_saisie_prq = false;
																			 nbreAchat = false;
								    								   }else 
									    								   if(action.equalsIgnoreCase("DPUBCSV")) {
									    									     typePlan ="PN";
									    									     type = "DAC";
									    									     fonctionalite="listeDpubCsv";
									    									     btn_pub =false;
									    									     btn_pub_csv = false;
									    									     btn_pub_dps = false;
									    									     btn_pub_dps = false;
									    									     btn_ami_csv = false;
									    									     btn_prq_dps = false;
									    									     btn_prq_dps = false;
									    									     libelle1="LISTE DES DAC EN PROCEDURE NORMALE";
																    			 libelleDao3="DOSSIER D'APPEL A CONCURRENCE PUBLIES";
																    			 btn_new =false;
																    			 btn_affec = false;
																    			 btn_exam = false;
																    			 btn_retrait = false;
																    			 btn_valid = false;
																    			 saisie=false;
																    			 publication=true;
																    			 vente=false;
																    			 correction=false;
																    			 panel1 =false;
																				 panel2 =false;
																				 panel3 = false;
																			     panel4 = true;
																				/* panel5 = false;
																				 panel6 = false;
																				 panel7 = true;
																				 panel8 = false;
																				 panel9 =false;
																				 panel10 = false;
																				 panel11 = false;
																				 panel12 = false;*/
																				 venteRecherche = false; 
																				 affectationRecherche = false;
																				 examenRecherche = false;
																				 publicationRecherche = true;
																				 saisieRecherche = false;
																				 celluleRecherche = false;
																				 validationRecherche = false;
																				 priseRecherche = false;
																				 chargeRecherche = false;
																				 affDao=false;
																				 exaDao=false;
																				 retDao = false;
																				 panelDaoTableauBordSai = false;
																				 panelDaoTableauBordVal = false;
																				 panelDaoTableauBordTra = false;
																				 panelDaoTableauBordAff =false;
																				 panelDaoTableauBordExa =false; 
																				 panelDaoTableauBordRet =false;
																				 panelDaoTableauBordVet =false;
																				 panelDaoTableauBordCha = false;
																				 panelDaoTableauBordPub = false;
																				 panelDaoTableauBordPrise = false;
																				 panelDaoTableauBordPubDps = false;
																				 panelDaoTableauBordPubCsv = false;
																				 //panelDaoTableauBordDPubCsv = true;
																				 panelDaoTableauBordDPubDps = false;
																				 panelPgpmTableauBordDpsgPub = true;
																				 panelDao = false;  
																				 panelPrq = false;
																				 btn_trans_ami =false;
																				 btn_trans_dao =false;
																				 btn_trans_prq =false;
																				 
																				 btn_creerDetailAmi = false;
																				 btn_creerDetailDao = false ;
																				 btn_creerDetailPrq = false;
																				 
																				 btn_creerDetailDaoCmp = false;
																				 btn_creerDetailAmiCmp = false;
																				 btn_creerDetailPrqCmp = false;
																				 btn_creerDetailDaoDmp = false;
																				 btn_creerDetailAmiDmp = false; 
																				 btn_creerDetailPrqDmp = false;
																				 fermerValDao = false;
																				 fermerSaiDao = true;
																				 detailD = false;
																				 detailA= false; 
																				 detailP = false;
																				 btn_valider_dao_cpmp =  false;
																				 btn_valider_dao_dmp = false;
																				 btn_valider_ami_cpmp = false; 
																				 btn_valider_prq_cpmp = false;
																				 btn_valider_ami_dmp = false;
																				 btn_valider_prq_dmp = false;
																				 btn_fermer_saisie_dao = false; 
																				 btn_fermer_saisie_ami = false; 
																				 btn_fermer_saisie_prq = false; 
																				 nbreAchat = false;
									    								   }else
				                                                             if(action.equalsIgnoreCase("ENGDPS")) {
				                                                        	  typePlan ="PS";
				                                                        	  type = "DAC";
				                                            				  libelleDao1="SAISIE D'UN NOUVEAU DOSSIER D'APPEL A CONCURRENCE (DAC)";
				                                            				  libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
				                                            			       libellesmall ="Procédure Simplifiée";
				                                            			       panelDetail=false;
				                                            				   panelForm=true;
				                                            				   panelTraitement=false;
				                                            			       panelRegister=true;
				                                            			       panelUpdate=false;
				                                            			       btn_fermer_saisie_dao = false;
				                            				   			       btn_fermer_saisie_daoPs =true;
				                            				   			       btn_fermer_saisie_ami = false ;
				                            				   			       btn_fermer_saisie_prq = false;  
				                            				   			       nbreAchat = false;
										    							    }else 
										    							    	if(action.equalsIgnoreCase("MODDPS")) {
										    							    		typePlan ="PS";
										    							    		type = "DAC";
										    							    		libelleProcedure="Modification du DAC N°";
										    							    		libelleDao2 = "Modification";
										    							    		update_fermer_dao=false;
										   							    		    update_fermer_ami=false;
										   							    		    update_fermer_prq=false;
										   							    		    update_fermer_dps=true;
										    							    		panelDetail=false;
										    									    panelForm=true;
										    									    panelTraitement=false;
										    							    		panelUpdate=true;
										    							    		panelRegister=false;
										    							    		nbreAchat = false;
										    							    	}else
							    									    	        if(action.equalsIgnoreCase("SAIDPS")) {
							    									    	        	typePlan ="PS";
							    									    	        	type = "DAC";
							    									    	        	libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
							    										    			libelleDao3="SAISIE DES DOSSIERS D'APPEL A CONCURRENCE";
							    										    			libelleSmall="Procédure Simplifiée";
							    										    			btn_daoPn =false;
							    										    			btn_daoPs =true;
							    										    			btn_ami =false;
							    										    			btn_prq =false;
							    										    			 btn_new =true;
							    										    			 btn_affec = false;
							    										    			 btn_fermer_saisie_dao = false;
							    										    			 btn_fermer_saisie_daoPs = true;
							    														 btn_fermer_saisie_ami = false ;
							    														 btn_fermer_saisie_prq = false  ;
							    										    			 panel1 =true;
							    														 panel2 =false;
							    														 panel3 = false;
							    														 panel4 = false;
							    													/*	 panel4 = false;
							    														 panel5 =false;
							    														 panel6 =false;
							    														 panel7=false;
							    														 panel8 =false;
							    														 panel9 = false;
							    														 panel10 = false;
							    														 panel11 = false;
							    														 panel12 = false;*/
							    														 venteRecherche = false; 
							    														 affectationRecherche = false;
							    														 examenRecherche = false;
							    														 publicationRecherche = false;
							    														 saisieRecherche = true;
							    														 celluleRecherche = false;
							    														 validationRecherche = false;
							    														 priseRecherche = false;
							    														 chargeRecherche = false;
							    														 panelDaoTableauBordSai = true;
							    														 panelDaoTableauBordPslpso = false;
							    														 panelDaoTableauBordVal = false;
							    														 panelDaoTableauBordTra = false;
							    														 panelDaoTableauBordPub = false;
							    														 panelDaoTableauBordPubDps = false;
																						 panelDaoTableauBordPubCsv = false;
																						 panelDaoTableauBordDPubCsv = false;
																						 panelDaoTableauBordDPubDps = false;
							    														 pspmModePs = false;
							    														 ppmModePn = true;
							    														 btn_dao_pn = true;
							    														 btn_dao_ps = false;
							    														 panelDaoTableauBordAff =false;
							    														 panelDaoTableauBordExa =false; 
							    														 panelDaoTableauBordRet =false;
							    														 panelDaoTableauBordVet =false;
							    														 panelDaoTableauBordCha = false;
							    														 panelDaoTableauBordPrise = false;
							    														 panelAmi = false;
							    														 panelDao = true;  
							    														 panelPrq = false;
							    														 btn_trans_ami =false;
							    														 btn_trans_dao =true;
							    														 btn_trans_prq =false;
							    														 
							    														 btn_creerDetailAmi = false;
							    														 btn_creerDetailDao = true ;
							    														 btn_creerDetailPrq = false;
							    														 
							    														 btn_creerDetailDaoCmp = true;
							    														 btn_creerDetailAmiCmp = false;
							    														 btn_creerDetailPrqCmp = false;
							    														 btn_creerDetailDaoDmp = true;
							    														 btn_creerDetailAmiDmp = false; 
							    														 btn_creerDetailPrqDmp = false;
							    														 fermerValDao = false;
							    														 fermerSaiDao = true;
							    														 detailD = true;
							    														 detailA= false; 
							    														 detailP = false;
							    														 btn_valider_dao_cpmp =  false;
							    														 btn_valider_dao_dmp = false;
							    														 btn_valider_ami_cpmp = false; 
							    														 btn_valider_prq_cpmp = false;
							    														 btn_valider_ami_dmp = false;
							    														 btn_valider_prq_dmp = false;
							    														 btn_fermer_saisie_dao = true; 
							    														 btn_fermer_saisie_ami = false; 
							    														 btn_fermer_saisie_prq = false; 
							    														 nbreAchat = false;
											    						     }else
								    									    	 if(action.equalsIgnoreCase("VALDPS")) {
								    									    		   typePlan ="PS";
								    									    		   type = "DAC";
								    									    		   libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
								    								    				libelleDao3="VALIDATION DES DOSSIERS D'APPEL A CONCURRENCE";
								    								    				libelleDao1="TRANSMISSION DES DOSSIERS D'APPEL A CONCURRENCE";
								    								    				libelleSmall="Procédure Simplifiée";
								    								    				panelDetail=false;
								    								    				panelForm=false;
								    								   				    panelTraitement=true;
								    								    				btn_new =false;
								    								    				btn_affec = false;
								    								    				btn_retrait = false;
								    								    				btn_valid = true;
								    								    				panel1 =true;
								    													panel2 =false;
								    													panel3 = false;
								    													panel4 = false;
								    												/*	panel4 =false;
								    													panel5 =false;
								    													panel6=false;
								    													panel7 = false;
								    													panel8 = false;
								    													panel9 = false;
								    													panel10=false;
								    													panel11 = false;
								    													panel12 = false;*/
								    													venteRecherche = false; 
								    													affectationRecherche = false;
								    													examenRecherche = false;
								    													publicationRecherche = false;
								    													saisieRecherche = false;
								    													celluleRecherche = false;
								    													validationRecherche = true;
								    													priseRecherche = false;
								    													chargeRecherche = false;
								    													affDao=false;
								    													exaDao=false;
								    													panelDaoTableauBordAff =false;
								    													panelDaoTableauBordRet = false;
								    													panelDaoTableauBordSai = false;
								    													panelDaoTableauBordPslpso = false;
								    													panelDaoTableauBordVal = true;
								    													panelDaoTableauBordTra = false;
								    													panelDaoTableauBordVet =false;
								    													panelDaoTableauBordExa = false;
								    													panelDaoTableauBordCha = false;
								    													panelDaoTableauBordPub = false;
								    													panelDaoTableauBordPrise = false;
								    													panelDaoTableauBordPubDps = false;
																						panelDaoTableauBordPubCsv = false;
																						panelDaoTableauBordDPubCsv = false;
																						panelDaoTableauBordDPubDps = false;
								    													panelDao = true;
								    													panelPrq =false;
								    												    panelAmi = false;
								    													fermerValDao =true;
								    													fermerSaiDao = false;
								    													btn_trans_ami =false;
								    													btn_trans_dao =false;
								    													btn_trans_prq =false;
								    													detailD = true ;
								    													detailA = false; 
								    													detailP = false;
								    													btn_valider_prq_cpmp = false;
								    													btn_valider_prq_dmp = false; 
								    													btn_valider_ami_cpmp = false; 
								    													btn_valider_ami_dmp = false;
								    													btn_valider_dao_cpmp = true;
								    													btn_valider_dao_dmp = true;
								    													btn_fermer_saisie_ami = false; 
								    													btn_fermer_saisie_prq = false;
								    													btn_fermer_saisie_dao = true;
								    													nbreAchat = false;
												    						    }else
									    									    	if(action.equalsIgnoreCase("APEDPS")) {
									    									    		typePlan ="PS";
									    									    		type = "DAC";
									    							    				panelDetail=true;
									    							    				panelForm=false;
									    							   				    panelTraitement=false;
									    							    				libelle1="Detail";
									    							    				libelle2 = "Synthèse du DAC N°";
									    							    				fermerSaiPrq = false; 
									    							    				fermerValPrq = false;
									    							    				fermerSaiAmi = false;
									    							    				fermerValAmi = false;
									    							    				fermerSaiDao = true;
									    							    				fermerValDao = false;
									    							    				detailD = true ;
									    												detailA = false; 
									    												detailP = false;
									    												fermerApercuDao = true;
									    												fermerApercuAmi = false;
									    												fermerApercuPrq = false;
									    												nbreAchat = false;
													    						   }else
									    									    	  if(action.equalsIgnoreCase("CHADPS")) {
									    									    		  typePlan ="PS";
									    									    		  type = "DAC";
									    									    		  libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
																			    			 libelleDao3="EXAMEN DES DOSSIERS D'APPEL A CONCURRENCE";
																			    			 libelleSmall="Procédure Simplifiée";
																			    			 btn_new =false;
																			    			 btn_affec = false;
																			    			 btn_exam = false;
																			    			 btn_retrait = false;
																			    			 btn_valid = false;
																			    			 panel1 =true;
																							 panel2 =false;
																							 panel3 = false;
																							 panel4 =  false;
																						/*	 panel4 = false;
																							 panel5 = false;
																							 panel6 = true;
																							 panel7 =false;
																							 panel8 =false;
																							 panel9 =false;
																							 panel10 = false;
																							 panel11 = false;
																							 panel12 = false;*/
																							 venteRecherche = false; 
																							 affectationRecherche = false;
																							 examenRecherche = false;
																							 publicationRecherche = false;
																							 saisieRecherche = false;
																							 celluleRecherche = false;
																							 validationRecherche = false;
																							 priseRecherche = false;
																							 chargeRecherche = true;
																							 affDao=false;
																							 exaDao=false;
																							 retDao = true;
																							 panelDaoTableauBordSai = false;
																							 panelDaoTableauBordVal = false;
																							 panelDaoTableauBordTra = false;
																							 panelDaoTableauBordAff =false;
																							 panelDaoTableauBordExa =false; 
																							 panelDaoTableauBordRet =false; 
																							 panelDaoTableauBordVet =false;
																							 panelDaoTableauBordCha = true;
																							 panelDaoTableauBordPub = false;
																							 panelDaoTableauBordPrise = false;
																							 panelDaoTableauBordPubDps = false;
																							 panelDaoTableauBordPubCsv = false;
																							 panelDaoTableauBordDPubCsv = false;
																							 panelDaoTableauBordDPubDps = false;
																							 panelDao = true;  
																							 panelPrq = false;
																							 btn_trans_ami =false;
																							 btn_trans_dao =false;
																							 btn_trans_prq =false;
																							 
																							 btn_creerDetailAmi = false;
																							 btn_creerDetailDao = false ;
																							 btn_creerDetailPrq = false;
																							 
																							 btn_creerDetailDaoCmp = false;
																							 btn_creerDetailAmiCmp = false;
																							 btn_creerDetailPrqCmp = false;
																							 btn_creerDetailDaoDmp = false;
																							 btn_creerDetailAmiDmp = false; 
																							 btn_creerDetailPrqDmp = false;
																							 fermerValDao = false;
																							 fermerSaiDao = true;
																							 detailD = false;
																							 detailA= false; 
																							 detailP = false;
																							 btn_valider_dao_cpmp =  false;
																							 btn_valider_dao_dmp = false;
																							 btn_valider_ami_cpmp = false; 
																							 btn_valider_prq_cpmp = false;
																							 btn_valider_ami_dmp = false;
																							 btn_valider_prq_dmp = false;
																							 btn_fermer_saisie_dao = false; 
																							 btn_fermer_saisie_ami = false; 
																							 btn_fermer_saisie_prq = false;
																							 nbreAchat = false;
													    						    }else
										    									    	 if(action.equalsIgnoreCase("EXADPS")) {
										    									    		 typePlan ="PS";
										    									    		 type = "DAC";
										    									    		 libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
										    								    			 libelleDao3="EXAMEN DES DOSSIERS D'APPEL A CONCURRENCE";
										    								    			 libelleSmall="Procédure Simplifiée";
										    								    			 btn_new =false;
										    								    			 btn_affec = false;
										    								    			 btn_exam = true;
										    								    			 btn_valid = false;
										    								    			 panel1 =true;
										    												 panel2 =false;
										    												 panel3 = false;
										    												 panel4 = false;
										    											/*	 panel4 = true;
										    												 panel5 = false;
										    												 panel6 = false;
										    												 panel7=false;
										    												 panel8 =false;
										    												 panel9 =false;
										    												 panel10 = false;
										    												 panel11 = false;
										    												 panel12 = false;*/
										    												 venteRecherche = false; 
										    												 affectationRecherche = false;
										    												 examenRecherche = true;
										    												 publicationRecherche = false;
										    												 saisieRecherche = false;
										    												 celluleRecherche = false;
										    												 validationRecherche = false;
										    												 priseRecherche = false;
										    												 chargeRecherche = false;
										    												 panelAffectation = false;
										    												 affDao=false;
										    												 exaDao=true;
										    												 panelDaoTableauBordSai = false;
										    												 panelDaoTableauBordVal = false;
										    												 panelDaoTableauBordTra = false;
										    												 panelDaoTableauBordAff =false;
										    												 panelDaoTableauBordExa =true;
										    												 panelDaoTableauBordVet =false;
										    												 panelDaoTableauBordCha = false;
										    												 panelDaoTableauBordPub = false;
										    												 panelDaoTableauBordPrise = false;
										    												 panelDaoTableauBordPubDps = false;
																							 panelDaoTableauBordPubCsv = false;
																							 panelDaoTableauBordDPubCsv = false;
																							 panelDaoTableauBordDPubDps = false;
										    												 panelDao = true;  
										    												 panelPrq = false;
										    												 btn_trans_ami =false;
										    												 btn_trans_dao =false;
										    												 btn_trans_prq =false;
										    												 
										    												 btn_creerDetailAmi = false;
										    												 btn_creerDetailDao = false ;
										    												 btn_creerDetailPrq = false;
										    												 
										    												 btn_creerDetailDaoCmp = false;
										    												 btn_creerDetailAmiCmp = false;
										    												 btn_creerDetailPrqCmp = false;
										    												 btn_creerDetailDaoDmp = false;
										    												 btn_creerDetailAmiDmp = false; 
										    												 btn_creerDetailPrqDmp = false;
										    												 fermerValDao = false;
										    												 fermerSaiDao = true;
										    												 detailD = false;
										    												 detailA= false; 
										    												 detailP = false;
										    												 btn_valider_dao_cpmp =  false;
										    												 btn_valider_dao_dmp = false;
										    												 btn_valider_ami_cpmp = false; 
										    												 btn_valider_prq_cpmp = false;
										    												 btn_valider_ami_dmp = false;
										    												 btn_valider_prq_dmp = false;
										    												 btn_fermer_saisie_dao = false; 
										    												 btn_fermer_saisie_ami = false; 
										    												 btn_fermer_saisie_prq = false; 
										    												 nbreAchat = false;
														    							    
														    						   }else
											    									    	 if(action.equalsIgnoreCase("AFFDPS")) {
											    									    		 typePlan ="PS";
											    									    		 type = "DAC";
											    									    		 libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
											    									    			 libelleDao3="AFFECTATION DES DOSSIERS D'APPEL D'OFFRES";
											    									    			 libelleSmall="Procédure Simplifiée";
											    									    			 btn_new =false;
											    									    			 btn_affec = true;
											    									    			 btn_retrait = false;
											    									    			 btn_valid = false;
											    									    			 panel1 =true;
											    													 panel2 =false;
											    													 panel3 = false;
											    													 panel4 = false;
											    											/*		 panel4 = false;
											    													 panel5 = false;
											    													 panel6=false;
											    													 panel7 = false;
											    													 panel8 = false;
											    													 panel9 = false;
											    													 panel10 = false;
											    													 panel11 = false;
											    													 panel12 = false;*/
											    													 venteRecherche = false; 
											    													 affectationRecherche = true;
											    													 examenRecherche = false;
											    													 publicationRecherche = false;
											    													 saisieRecherche = false;
											    													 celluleRecherche = false;
											    													 validationRecherche = false;
											    													 priseRecherche = false;
											    													 chargeRecherche = false;
											    													 
											    													 panelAffectation = true;
											    													 affDao=true;
											    													 exaDao=false;
											    													 panelDaoTableauBordSai = false;
											    													 panelDaoTableauBordVal = false;
											    													 panelDaoTableauBordTra = false;
											    													 panelDaoTableauBordAff =true;
											    													 panelDaoTableauBordVet =false;
											    													 panelDaoTableauBordRet = false;
											    													 panelDaoTableauBordCha = false;
											    													 panelDaoTableauBordPub = false;
											    													 panelDaoTableauBordPrise = false;
											    													 panelDaoTableauBordPubDps = false;
																									 panelDaoTableauBordPubCsv = false;
																									 panelDaoTableauBordDPubCsv = false;
																									 panelDaoTableauBordDPubDps = false;
											    													 panelDao = true;  
											    													 panelPrq = false;
											    													 btn_trans_ami =false;
											    													 btn_trans_dao =true;
											    													 btn_trans_prq =false;
											    													 
											    													 btn_creerDetailAmi = false;
											    													 btn_creerDetailDao = false ;
											    													 btn_creerDetailPrq = false;
											    													 
											    													 btn_creerDetailDaoCmp = true;
											    													 btn_creerDetailAmiCmp = false;
											    													 btn_creerDetailPrqCmp = false;
											    													 btn_creerDetailDaoDmp = false;
											    													 btn_creerDetailAmiDmp = false; 
											    													 btn_creerDetailPrqDmp = false;
											    													 fermerValDao = false;
											    													 fermerSaiDao = true;
											    													 detailD = false;
											    													 detailA= false; 
											    													 detailP = false;
											    													 btn_valider_dao_cpmp =  false;
											    													 btn_valider_dao_dmp = false;
											    													 btn_valider_ami_cpmp = false; 
											    													 btn_valider_prq_cpmp = false;
											    													 btn_valider_ami_dmp = false;
											    													 btn_valider_prq_dmp = false;
											    													 btn_fermer_saisie_dao = false; 
											    													 btn_fermer_saisie_ami = false; 
											    													 btn_fermer_saisie_prq = false; 
											    													 nbreAchat = false;
															    						   }else
												    									    	 if(action.equalsIgnoreCase("PUBDPS")) {
												    									    		 typePlan ="PS";
												    									    		 type = "DAC";
												    									    		 libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
																					    			 libelleDao3="DOSSIER D'APPEL A CONCURRENCE EN ATTENTE DE PUBLICATION";
																					    			 libelleSmall="Procédure Simplifiée";
																					    			 fonctionalite =" ListePubDacPn";
																					    			 btn_new =false;
																					    			 btn_pub =true;
																					    			 btn_affec = false;
																					    			 btn_exam = false;
																					    			 btn_retrait = false;
																					    			 btn_valid = false;
																					    			 panel1 =true;
																									 panel2 =false;
																									 panel3 = false;
																									 panel4 = false;
																									/* panel4 = false;
																									 panel5 = false;
																									 panel6 = false;
																									 panel7 = true;
																									 panel8 = false;
																									 panel9 =false;
																									 panel10 = false;
																									 panel11 = false;
																									 panel12 = false;*/
																									 venteRecherche = false; 
																									 affectationRecherche = false;
																									 examenRecherche = false;
																									 publicationRecherche = true;
																									 saisieRecherche = false;
																									 celluleRecherche = false;
																									 validationRecherche = false;
																									 priseRecherche = false;
																									 chargeRecherche = false;
																									 affDao=false;
																									 exaDao=false;
																									 retDao = false;
																									 panelDaoTableauBordSai = false;
																									 panelDaoTableauBordVal = false;
																									 panelDaoTableauBordTra = false;
																									 panelDaoTableauBordAff =false;
																									 panelDaoTableauBordExa =false; 
																									 panelDaoTableauBordRet =false;
																									 panelDaoTableauBordVet =false;
																									 panelDaoTableauBordCha = false;
																									 panelDaoTableauBordPub = true;
																									 panelDaoTableauBordPrise = false;
																									 panelDaoTableauBordPubDps = false;
																									 panelDaoTableauBordPubCsv = false;
																									 panelDaoTableauBordDPubCsv = false;
																									 panelDaoTableauBordDPubDps = false;
																									 panelDao = false;  
																									 panelPrq = false;
																									 btn_trans_ami =false;
																									 btn_trans_dao =false;
																									 btn_trans_prq =false;
																									 
																									 btn_creerDetailAmi = false;
																									 btn_creerDetailDao = false ;
																									 btn_creerDetailPrq = false;
																									 
																									 btn_creerDetailDaoCmp = false;
																									 btn_creerDetailAmiCmp = false;
																									 btn_creerDetailPrqCmp = false;
																									 btn_creerDetailDaoDmp = false;
																									 btn_creerDetailAmiDmp = false; 
																									 btn_creerDetailPrqDmp = false;
																									 fermerValDao = false;
																									 fermerSaiDao = true;
																									 detailD = false;
																									 detailA= false; 
																									 detailP = false;
																									 btn_valider_dao_cpmp =  false;
																									 btn_valider_dao_dmp = false;
																									 btn_valider_ami_cpmp = false; 
																									 btn_valider_prq_cpmp = false;
																									 btn_valider_ami_dmp = false;
																									 btn_valider_prq_dmp = false;
																									 btn_fermer_saisie_dao = false; 
																									 btn_fermer_saisie_ami = false; 
																									 btn_fermer_saisie_prq = false;  
																									 nbreAchat = false;
																    						   }else
													    									    	 if(action.equalsIgnoreCase("VETDPS")) {
													    									    		 typePlan ="PS";
													    									    		 type = "DAC";
													    									    		 fonctionalite="listeDaoVentePn";
													    									    		 libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
																	    							     libelle="VENTE / RETRAIT DU DAC N°";
																						    			 libelleDao3="VENTE DES DOSSIERS D'APPEL A CONCURRENCE";
																						    			 libelleSmall="Procédure Simplifiée";
																						    			 btn_new =false;
																						    			 btn_affec = false;
																						    			 btn_exam = false;
																						    			 btn_retrait = true;
																						    			 btn_valid = false;
																						    			 panel1 =true;
																										 panel2 =false;
																										 panel3 = false;
																										 panel4 = false;
																										/* panel4 = false;
																										 panel5 = false;
																										 panel6 = false;
																										 panel7 = false;
																										 panel8 = false;
																										 panel9 =true;
																										 panel10 = false;
																										 panel11 = false;
																										 panel12 = false;*/
																										 venteRecherche = true; 
																										 affectationRecherche = false;
																										 examenRecherche = false;
																										 publicationRecherche = false;
																										 saisieRecherche = false;
																										 celluleRecherche = false;
																										 validationRecherche = false;
																										 priseRecherche = false;
																										 chargeRecherche = false;
																										 affDao=false;
																										 exaDao=false;
																										 retDao = true;
																										 panelDaoTableauBordSai = false;
																										 panelDaoTableauBordVal = false;
																										 panelDaoTableauBordTra = false;
																										 panelDaoTableauBordAff =false;
																										 panelDaoTableauBordExa =false; 
																										 panelDaoTableauBordRet =false; 
																										 panelDaoTableauBordVet =true;
																										 panelDaoTableauBordCha = false;
																										 panelDaoTableauBordPub = false;
																										 panelDaoTableauBordPrise = false;
																										 panelDaoTableauBordPubDps = false;
																										 panelDaoTableauBordPubCsv = false;
																										 panelDaoTableauBordDPubCsv = false;
																										 panelDaoTableauBordDPubDps = false;
																										 panelDao = true;  
																										 panelPrq = false;
																										 btn_trans_ami =false;
																										 btn_trans_dao =false;
																										 btn_trans_prq =false;
																										 
																										 btn_creerDetailAmi = false;
																										 btn_creerDetailDao = false ;
																										 btn_creerDetailPrq = false;
																										 
																										 btn_creerDetailDaoCmp = false;
																										 btn_creerDetailAmiCmp = false;
																										 btn_creerDetailPrqCmp = false;
																										 btn_creerDetailDaoDmp = false;
																										 btn_creerDetailAmiDmp = false; 
																										 btn_creerDetailPrqDmp = false;
																										 fermerValDao = false;
																										 fermerSaiDao = true;
																										 detailD = false;
																										 detailA= false; 
																										 detailP = false;
																										 btn_valider_dao_cpmp =  false;
																										 btn_valider_dao_dmp = false;
																										 btn_valider_ami_cpmp = false; 
																										 btn_valider_prq_cpmp = false;
																										 btn_valider_ami_dmp = false;
																										 btn_valider_prq_dmp = false;
																										 btn_fermer_saisie_dao = false; 
																										 btn_fermer_saisie_ami = false; 
																										 btn_fermer_saisie_prq = false;
																										 nbreAchat = true;
																	    						     }else
														    									    	 if(action.equalsIgnoreCase("TRADPS")) {
														    									    		 typePlan ="PS";
														    									    		 type = "DAC";
														    									    		 libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
																							    			 libelleDao3="TRANSMISSION DU DAC PAR LA CELLULE";
																							    			 libelleDao1 ="TRANSMISSION DU DAC PAR LA CELLULE";
																							    			 libelleSmall="Procédure Simplifiée";
																							    			 btn_new =false;
																							    			 btn_affec = false;
																							    			 btn_exam = false;
																							    			 btn_retrait = false;
																							    			 btn_valid = false;
																											 panel1 =true;
																											 panel2 =false;
																											 panel3 = false;
																											 panel4 = false;
																											/* panel4 = false;
																											 panel5 = false;
																											 panel6 = false;
																											 panel7 = false;
																											 panel8 = true;
																											 panel9 = false;
																											 panel10 = false;
																											 panel11 = false;
																											 panel12 = false;*/
																											 affDao=false;
																											 exaDao=false;
																											 retDao = true;
																											 panelDaoTableauBordSai = false;
																											 panelDaoTableauBordVal = false;
																											 panelDaoTableauBordTra = true;
																											 panelDaoTableauBordAff =false;
																											 panelDaoTableauBordExa =false; 
																											 panelDaoTableauBordRet =false; 
																											 panelDaoTableauBordVet =false;
																											 panelDaoTableauBordCha = false;
																											 panelDaoTableauBordPub = false;
																											 panelDaoTableauBordPrise = false;
																											 panelDaoTableauBordPubDps = false;
																											 panelDaoTableauBordPubCsv = false;
																											 panelDaoTableauBordDPubCsv = false;
																											 panelDaoTableauBordDPubDps = false;
																											 panelDao = true;  
																											 panelPrq = false;
																											 btn_trans_ami =false;
																											 btn_trans_dao =false;
																											 btn_trans_prq =false;
																											 
																											 btn_creerDetailAmi = false;
																											 btn_creerDetailDao = false ;
																											 btn_creerDetailPrq = false;
																											 
																											 btn_creerDetailDaoCmp = false;
																											 btn_creerDetailAmiCmp = false;
																											 btn_creerDetailPrqCmp = false;
																											 btn_creerDetailDaoDmp = false;
																											 btn_creerDetailAmiDmp = false; 
																											 btn_creerDetailPrqDmp = false;
																											 fermerValDao = false;
																											 fermerSaiDao = true;
																											 detailD = false;
																											 detailA= false; 
																											 detailP = false;
																											 btn_valider_dao_cpmp =  false;
																											 btn_valider_dao_dmp = false;
																											 btn_valider_ami_cpmp = false; 
																											 btn_valider_prq_cpmp = false;
																											 btn_valider_ami_dmp = false;
																											 btn_valider_prq_dmp = false;
																											 btn_fermer_saisie_dao = false; 
																											 btn_fermer_saisie_ami = false; 
																											 btn_fermer_saisie_prq = false; 
																		    						      }else
																    									      if(action.equalsIgnoreCase("RETDPS")) {
																    									    	  typePlan ="PS";
																    									    		 type = "DAC";
																    									    		 libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
																									    			 libelleDao3="RETRAIT DES DOSSIERS D'APPEL A CONCURRENCE";
																									    			 libelleSmall ="Procédure Simplifiée";
																									    			 btn_new =false;
																									    			 btn_affec = false;
																									    			 btn_exam = false;
																									    			 btn_retrait = true;
																									    			 btn_valid = false;
																									    			 panel1 =true;
																													 panel2 =false;
																													 panel3 = false;
																													 panel4 = true;
																													/* panel4 = false;
																													 panel5 = false;
																													 panel6 = false;
																													 panel7 = false;
																													 panel8 = true;
																													 panel9 = false;
																													 panel10 = false;
																													 panel11 = false;
																													 panel12 = false;*/
																													 affDao=false;
																													 exaDao=false;
																													 retDao = true;
																													 panelDaoTableauBordSai = false;
																													 panelDaoTableauBordVal = false;
																													 panelDaoTableauBordTra = false;
																													 panelDaoTableauBordAff =false;
																													 panelDaoTableauBordExa =false; 
																													 panelDaoTableauBordRet =true; 
																													 panelDaoTableauBordVet =false;
																													 panelDaoTableauBordCha = false;
																													 panelDaoTableauBordPub = false;
																													 panelDaoTableauBordPrise = false;
																													 panelDaoTableauBordPubDps = false;
																													 panelDaoTableauBordPubCsv = false;
																													 panelDaoTableauBordDPubCsv = false;
																													 panelDaoTableauBordDPubDps = false;
																													 panelDao = true;  
																													 panelPrq = false;
																													 btn_trans_ami =false;
																													 btn_trans_dao =false;
																													 btn_trans_prq =false;
																													 
																													 btn_creerDetailAmi = false;
																													 btn_creerDetailDao = false ;
																													 btn_creerDetailPrq = false;
																													 
																													 btn_creerDetailDaoCmp = false;
																													 btn_creerDetailAmiCmp = false;
																													 btn_creerDetailPrqCmp = false;
																													 btn_creerDetailDaoDmp = false;
																													 btn_creerDetailAmiDmp = false; 
																													 btn_creerDetailPrqDmp = false;
																													 fermerValDao = false;
																													 fermerSaiDao = true;
																													 detailD = false;
																													 detailA= false; 
																													 detailP = false;
																													 btn_valider_dao_cpmp =  false;
																													 btn_valider_dao_dmp = false;
																													 btn_valider_ami_cpmp = false; 
																													 btn_valider_prq_cpmp = false;
																													 btn_valider_ami_dmp = false;
																													 btn_valider_prq_dmp = false;
																													 btn_fermer_saisie_dao = false; 
																													 btn_fermer_saisie_ami = false; 
																													 btn_fermer_saisie_prq = false; 
																													 nbreAchat = false;
																				    						   }else
																    									    	if(action.equalsIgnoreCase("OBSDPS")) {
																    									    		 typePlan ="PS";
																    									    		 type = "DAC";
																    									    		 fonctionalite="listeDaoCorrectionPn";
																    									    		 libelle1="LISTE DES DAO EN PROCEDURE SIMPLIFIEE";
																									    			 libellesmall="Procédure Simplifiéé";
																									    			 libelleDao3="PRISE EN COMPTE DES OBSERVATIONS";
																									    			 libelleSmall="Procédure Simplifiée";
																									    			 btn_new =false;
																									    			 btn_affec = false;
																									    			 btn_exam = false;
																									    			 btn_retrait = true;
																									    			 btn_valid = false;
																									    			 panel1 =true;
																													 panel2 =false;
																													 panel3 = false;
																													 panel4 = false;
																													/* panel4 = false;
																													 panel5 = false;
																													 panel6 = false;
																													 panel7 = false;
																													 panel8 = true;
																													 panel9 = false;
																													 panel10 = false;
																													 panel11 = false;
																													 panel12 = false;*/
																													 venteRecherche = false; 
																													 affectationRecherche = false;
																													 examenRecherche = false;
																													 publicationRecherche = false;
																													 saisieRecherche = false;
																													 celluleRecherche = false;
																													 validationRecherche = false;
																													 priseRecherche = true;
																													 chargeRecherche = false;
																													 affDao=false;
																													 exaDao=false;
																													 retDao = true;
																													 panelDaoTableauBordSai = false;
																													 panelDaoTableauBordVal = false;
																													 panelDaoTableauBordTra = false;
																													 panelDaoTableauBordAff =false;
																													 panelDaoTableauBordExa =false; 
																													 panelDaoTableauBordRet =false; 
																													 panelDaoTableauBordVet =false;
																													 panelDaoTableauBordCha = false;
																													 panelDaoTableauBordPub = false;
																													 panelDaoTableauBordPrise = true;
																													 panelDaoTableauBordPubDps = false;
																													 panelDaoTableauBordPubCsv = false;
																													 panelDaoTableauBordDPubCsv = false;
																													 panelDaoTableauBordDPubDps = false;
																													 panelDao = true;  
																													 panelPrq = false;
																													 btn_trans_ami =false;
																													 btn_trans_dao =false;
																													 btn_trans_prq =false;
																													 
																													 btn_creerDetailAmi = false;
																													 btn_creerDetailDao = false ;
																													 btn_creerDetailPrq = false;
																													 
																													 btn_creerDetailDaoCmp = false;
																													 btn_creerDetailAmiCmp = false;
																													 btn_creerDetailPrqCmp = false;
																													 btn_creerDetailDaoDmp = false;
																													 btn_creerDetailAmiDmp = false; 
																													 btn_creerDetailPrqDmp = false;
																													 fermerValDao = false;
																													 fermerSaiDao = true;
																													 detailD = false;
																													 detailA= false; 
																													 detailP = false;
																													 btn_valider_dao_cpmp =  false;
																													 btn_valider_dao_dmp = false;
																													 btn_valider_ami_cpmp = false; 
																													 btn_valider_prq_cpmp = false;
																													 btn_valider_ami_dmp = false;
																													 btn_valider_prq_dmp = false;
																													 btn_fermer_saisie_dao = false; 
																													 btn_fermer_saisie_ami = false; 
																													 btn_fermer_saisie_prq = false;
																													 nbreAchat = false;
																				    						   }else 
																			    								   if(action.equalsIgnoreCase("DPSPUBCSV")) {
																			    									    typePlan ="PS";
																			    									     type = "DAC";
																			    									     fonctionalite="listePubDpsCsv";
																			    									     btn_pub =false;
																			    									     btn_pub_csv = false;
																			    									     btn_pub_dps = true;
																			    									     //btn_pub_dps = false;
																			    									     btn_ami_csv = false;
																			    									     btn_prq_dps = false;
																			    									     btn_prq_dps = false;
																			    									     libelle1="LISTE DES DAC EN PROCEDURE SIMPLIFIEE";
																										    			 libelleDao3="DOSSIER D'APPEL A CONCURRENCE EN ATTENTE DE PUBLICATION";
																										    			 btn_new =false;
																										    			 btn_affec = false;
																										    			 btn_exam = false;
																										    			 btn_retrait = false;
																										    			 btn_valid = false;
																										    			 saisie=false;
																										    			 publication=true;
																										    			 vente=false;
																										    			  correction=false;
																										    			 panel1 =false;
																														 panel2 =false;
																														 panel3 = false;
																													     panel4 = true;
																														/* panel5 = false;
																														 panel6 = false;
																														 panel7 = true;
																														 panel8 = false;
																														 panel9 =false;
																														 panel10 = false;
																														 panel11 = false;
																														 panel12 = false;*/
																														 venteRecherche = false; 
																														 affectationRecherche = false;
																														 examenRecherche = false;
																														 publicationRecherche = true;
																														 saisieRecherche = false;
																														 celluleRecherche = false;
																														 validationRecherche = false;
																														 priseRecherche = false;
																														 chargeRecherche = false;
																														 affDao=false;
																														 exaDao=false;
																														 retDao = false;
																														 panelDaoTableauBordSai = false;
																														 panelDaoTableauBordVal = false;
																														 panelDaoTableauBordTra = false;
																														 panelDaoTableauBordAff =false;
																														 panelDaoTableauBordExa =false; 
																														 panelDaoTableauBordRet =false;
																														 panelDaoTableauBordVet =false;
																														 panelDaoTableauBordCha = false;
																														 panelDaoTableauBordPub = false;
																														 panelDaoTableauBordPrise = false;
																														// panelDaoTableauBordPubDps = true;
																														 panelDaoTableauBordPubCsv = true;
																														 panelDao = false;  
																														 panelPrq = false;
																														 btn_trans_ami =false;
																														 btn_trans_dao =false;
																														 btn_trans_prq =false;
																														 
																														 btn_creerDetailAmi = false;
																														 btn_creerDetailDao = false ;
																														 btn_creerDetailPrq = false;
																														 
																														 btn_creerDetailDaoCmp = false;
																														 btn_creerDetailAmiCmp = false;
																														 btn_creerDetailPrqCmp = false;
																														 btn_creerDetailDaoDmp = false;
																														 btn_creerDetailAmiDmp = false; 
																														 btn_creerDetailPrqDmp = false;
																														 fermerValDao = false;
																														 fermerSaiDao = true;
																														 detailD = false;
																														 detailA= false; 
																														 detailP = false;
																														 btn_valider_dao_cpmp =  false;
																														 btn_valider_dao_dmp = false;
																														 btn_valider_ami_cpmp = false; 
																														 btn_valider_prq_cpmp = false;
																														 btn_valider_ami_dmp = false;
																														 btn_valider_prq_dmp = false;
																														 btn_fermer_saisie_dao = false; 
																														 btn_fermer_saisie_ami = false; 
																														 btn_fermer_saisie_prq = false;
																														 nbreAchat = false;
																			    								   }else 
																				    								   if(action.equalsIgnoreCase("DDPSPUBCSV")) {
																				    									    typePlan ="PS";
																				    									     type = "DAC";
																				    									     fonctionalite="listePubDdpsCsv";
																				    									     btn_pub =false;
																				    									     btn_pub_csv = false;
																				    									     btn_pub_dps = false;
																				    									     btn_ami_csv = false;
																				    									     btn_prq_dps = false;
																				    									     libelle1="LISTE DES DAC EN PROCEDURE SIMPLIFIEE";
																											    			 libelleDao3="DOSSIER D'APPEL A CONCURRENCE PUBLIES";
																											    			 btn_new =false;
																											    			 btn_affec = false;
																											    			 btn_exam = false;
																											    			 btn_retrait = false;
																											    			 btn_valid = false;
																											    			 saisie=false;
																											    			 publication=true;
																											    			 vente=false;
																											    			  correction=false;
																											    			 panel1 =false;
																															 panel2 =false;
																															 panel3 = false;
																														     panel4 = true;
																															/* panel5 = false;
																															 panel6 = false;
																															 panel7 = true;
																															 panel8 = false;
																															 panel9 =false;
																															 panel10 = false;
																															 panel11 = false;
																															 panel12 = false;*/
																															 venteRecherche = false; 
																															 affectationRecherche = false;
																															 examenRecherche = false;
																															 publicationRecherche = true;
																															 saisieRecherche = false;
																															 celluleRecherche = false;
																															 validationRecherche = false;
																															 priseRecherche = false;
																															 chargeRecherche = false;
																															 affDao=false;
																															 exaDao=false;
																															 retDao = false;
																															 panelDaoTableauBordSai = false;
																															 panelDaoTableauBordVal = false;
																															 panelDaoTableauBordTra = false;
																															 panelDaoTableauBordAff =false;
																															 panelDaoTableauBordExa =false; 
																															 panelDaoTableauBordRet =false;
																															 panelDaoTableauBordVet =false;
																															 panelDaoTableauBordCha = false;
																															 panelDaoTableauBordPub = false;
																															 panelDaoTableauBordPrise = false;
																															 panelDaoTableauBordPubDps = false;
																															 panelDaoTableauBordPubCsv = false;
																															 panelDaoTableauBordDPubCsv = true;
																															 //panelDaoTableauBordDPubDps = true;
																															 panelDao = false;  
																															 panelPrq = false;
																															 btn_trans_ami =false;
																															 btn_trans_dao =false;
																															 btn_trans_prq =false;
																															 
																															 btn_creerDetailAmi = false;
																															 btn_creerDetailDao = false ;
																															 btn_creerDetailPrq = false;
																															 
																															 btn_creerDetailDaoCmp = false;
																															 btn_creerDetailAmiCmp = false;
																															 btn_creerDetailPrqCmp = false;
																															 btn_creerDetailDaoDmp = false;
																															 btn_creerDetailAmiDmp = false; 
																															 btn_creerDetailPrqDmp = false;
																															 fermerValDao = false;
																															 fermerSaiDao = true;
																															 detailD = false;
																															 detailA= false; 
																															 detailP = false;
																															 btn_valider_dao_cpmp =  false;
																															 btn_valider_dao_dmp = false;
																															 btn_valider_ami_cpmp = false; 
																															 btn_valider_prq_cpmp = false;
																															 btn_valider_ami_dmp = false;
																															 btn_valider_prq_dmp = false;
																															 btn_fermer_saisie_dao = false; 
																															 btn_fermer_saisie_ami = false; 
																															 btn_fermer_saisie_prq = false;  
																															 nbreAchat = false;
																				    								   }else
				 
				 
			 
			 
			 
			                                                                                                    //PREQUALIFICATION
																    									    	if(action.equalsIgnoreCase("ENGPRQ")) {
																    												  type = "PRQ";
																    												  typePlan ="PN";
																    												  libelleDao1="SAISIE D'UN NOUVELLE PREQUALIFICATION (PRQ)";
																    											       libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    											       libellesmall ="Saisie d'une nouvelle PRQ";
																    											       panelDetail=false;
																    												   panelForm=true;
																    												   panelTraitement=false;
																    											       panelRegister=true;
																    											       panelUpdate=false;
																    											       btn_fermer_saisie_dao = false;
																    								   			       btn_fermer_saisie_daoPs =false;
																    								   			       btn_fermer_saisie_ami = false ;
																    								   			       btn_fermer_saisie_prq = true;
																    								   			       nbreAchat = false;
																    											    }else 
																    											    	if(action.equalsIgnoreCase("MODPRQ")) {
																    											    		type = "PRQ";
																    											    		libelleDao1="MODIFICATION DU PRQ N° ";
																    											    		 libelle1="Saisie d'un nouvelle PRQ";
																    													     panelDetail=false;
																    														 panelForm=true;
																    														 update_fermer_dao=false;
																    											    		 update_fermer_ami=false;
																    											    		 update_fermer_prq=true;
																					   							    		 update_fermer_dps=false;
																    														 panelTraitement=false;
																    													     panelRegister=true;
																    													     panelUpdate=false;
																    													     btn_fermer_saisie_dao = true;
																    													     btn_fermer_saisie_ami = false;
																    													     btn_fermer_saisie_prq = false;
																    													     nbreAchat = false;
																    											    	}else
																    											    		if(action.equalsIgnoreCase("SAIPRQ")) {
																    											    			 type = "PRQ";
																			    												 typePlan ="PN";
																			    												 fonctionalite = "listSaisieAc";
																			    												 libelle="INFORMATIONS SUR L'AUTORITE CONTRACTANTE";
																			    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    											    			libelleDao3="SAISIE DES PREQUALIFICATIONS";
																    											    			btn_daoPn =false;
																    											    			btn_daoPs =false;
																    											    			btn_ami =false;
																    											    			btn_prq =true;
																    											    			 btn_new =true;
																    											    			 btn_affec = false;
																    											    			 panel1 =true;
																																 panel2 =false;
																																 panel3 = false;
																																/* panel4 = false;
																																 panel5 = false;
																																 panel6 = false;
																																 panel7 = false;
																																 panel8 = true;
																																 panel9 = false;
																																 panel10 = false;
																																 panel11 = false;
																																 panel12 = false;*/
																    															 venteRecherche = false; 
																    															 affectationRecherche = false;
																    															 examenRecherche = false;
																    															 publicationRecherche = false;
																    															 saisieRecherche = true;
																    															 celluleRecherche = false;
																    															 validationRecherche = false;
																    															 priseRecherche = false;
																    															 chargeRecherche = false;
																    															 panelDaoTableauBordSai = true;
																    															 panelDaoTableauBordPslpso = false;
																    															 panelDaoTableauBordVal = false;
																    															 panelDaoTableauBordTra = false;
																    															 panelDaoTableauBordPub = false;
																    															 panelDaoTableauBordPubDps = false;
																																 panelDaoTableauBordPubCsv = false;
																																 panelDaoTableauBordDPubCsv = false;
																																 panelDaoTableauBordDPubDps = false;
																    															 pspmModePs = false;
																    															 ppmModePn = true;
																    															 btn_dao_pn = true;
																    															 btn_dao_ps = false;
																    															 panelDaoTableauBordAff =false;
																    															 panelDaoTableauBordExa =false; 
																    															 panelDaoTableauBordRet =false;
																    															 panelDaoTableauBordVet =false;
																    															 panelDaoTableauBordCha = false;
																    															 panelDaoTableauBordPrise = false;
																    															 panelAmi = false;
																    															 panelDao = true;  
																    															 panelPrq = false;
																    															 btn_trans_ami =false;
																    															 btn_trans_dao =true;
																    															 btn_trans_prq =false;
																    															 
																    															 btn_creerDetailAmi = false;
																    															 btn_creerDetailDao = true ;
																    															 btn_creerDetailPrq = false;
																    															 
																    															 btn_creerDetailDaoCmp = true;
																    															 btn_creerDetailAmiCmp = false;
																    															 btn_creerDetailPrqCmp = false;
																    															 btn_creerDetailDaoDmp = true;
																    															 btn_creerDetailAmiDmp = false; 
																    															 btn_creerDetailPrqDmp = false;
																    															 fermerValDao = false;
																    															 fermerSaiDao = true;
																    															 detailD = true;
																    															 detailA= false; 
																    															 detailP = false;
																    															 btn_valider_dao_cpmp =  false;
																    															 btn_valider_dao_dmp = false;
																    															 btn_valider_ami_cpmp = false; 
																    															 btn_valider_prq_cpmp = false;
																    															 btn_valider_ami_dmp = false;
																    															 btn_valider_prq_dmp = false;
																    															 btn_fermer_saisie_dao = true; 
																    															 btn_fermer_saisie_ami = false; 
																    															 btn_fermer_saisie_prq = false; 
																    															 nbreAchat = false;
																    											    		}else
																    												    		if(action.equalsIgnoreCase("PRQPS")) {
																    												    			 type = "PRQ";
																				    												 typePlan ="PN";
																				    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    												    			 libelleDao3="SAISIE DES PREQUALIFICATIONS";
																    												    			 libellesmall ="";
																    												    			 btn_new =true;
																    												    			 btn_affec = false;
																    												    			 panel1 =true;
																																	 panel2 =false;
																																	 panel3 = false;
																																	/* panel4 = false;
																																	 panel5 = false;
																																	 panel6 = false;
																																	 panel7 = false;
																																	 panel8 = true;
																																	 panel9 = false;
																																	 panel10 = false;
																																	 panel11 = false;
																																	 panel12 = false;*/
																    																 panelDaoTableauBordSai = false;
																    																 panelDaoTableauBordPslpso = true;
																    																 panelDaoTableauBordVal = false;
																    																 panelDaoTableauBordTra = false;
																    																 panelDaoTableauBordPub = false;
																    																 panelDaoTableauBordPubDps = false;
																																	 panelDaoTableauBordPubCsv = false;
																																	 panelDaoTableauBordDPubCsv = false;
																																	 panelDaoTableauBordDPubDps = false;
																    																 pspmModePs = true;
																    																 ppmModePn = false;
																    																 btn_dao_pn = false;
																    																 btn_dao_ps = true;
																    																 panelDaoTableauBordAff =false;
																    																 panelDaoTableauBordExa =false; 
																    																 panelDaoTableauBordRet =false;
																    																 panelDaoTableauBordVet =false;
																    																 panelDaoTableauBordCha = false;
																    																 panelDaoTableauBordPrise = false;

																    																 panelAmi = false;
																    																 panelDao = true;  
																    																 panelPrq = false;
																    																 btn_trans_ami =false;
																    																 btn_trans_dao =true;
																    																 btn_trans_prq =false;
																    																 
																    																 btn_creerDetailAmi = false;
																    																 btn_creerDetailDao = true ;
																    																 btn_creerDetailPrq = false;
																    																 
																    																 btn_creerDetailDaoCmp = true;
																    																 btn_creerDetailAmiCmp = false;
																    																 btn_creerDetailPrqCmp = false;
																    																 btn_creerDetailDaoDmp = true;
																    																 btn_creerDetailAmiDmp = false; 
																    																 btn_creerDetailPrqDmp = false;
																    																 fermerValDao = false;
																    																 fermerSaiDao = true;
																    																 detailD = true;
																    																 detailA= false; 
																    																 detailP = false;
																    																 btn_valider_dao_cpmp =  false;
																    																 btn_valider_dao_dmp = false;
																    																 btn_valider_ami_cpmp = false; 
																    																 btn_valider_prq_cpmp = false;
																    																 btn_valider_ami_dmp = false;
																    																 btn_valider_prq_dmp = false;
																    																 btn_fermer_saisie_dao = true; 
																    																 btn_fermer_saisie_ami = false; 
																    																 btn_fermer_saisie_prq = false; 
																    																 nbreAchat = false;
																    												    		}else
																    											    			    if(action.equalsIgnoreCase("VALPRQ")) {
																    											    			    	 type = "PRQ";
																					    												 typePlan ="PN";
																					    												
																    											    				libelleDao3="VALIDATION DES PREQUALIFICATIONS";
																    											    				libelleDao1="TRANSMISSION DES PREQUALIFICATIONS";
																    											    				panelDetail=false;
																    											    				panelForm=false;
																    											   				    panelTraitement=true;
																    											    				btn_new =false;
																    											    				btn_affec = false;
																    											    				btn_retrait = false;
																    											    				btn_valid = true;
																    											    				panel1 =true;
																																	 panel2 =false;
																																	 panel3 = false;
																																	/* panel4 = false;
																																	 panel5 = false;
																																	 panel6 = false;
																																	 panel7 = false;
																																	 panel8 = true;
																																	 panel9 = false;
																																	 panel10 = false;
																																	 panel11 = false;
																																	 panel12 = false;*/
																    																venteRecherche = false; 
																    																affectationRecherche = false;
																    																examenRecherche = false;
																    																publicationRecherche = false;
																    																saisieRecherche = false;
																    																celluleRecherche = false;
																    																validationRecherche = true;
																    																priseRecherche = false;
																    																chargeRecherche = false;
																    																affDao=false;
																    																exaDao=false;
																    																panelDaoTableauBordAff =false;
																    																panelDaoTableauBordRet = false;
																    																panelDaoTableauBordSai = false;
																    																panelDaoTableauBordPslpso = false;
																    																panelDaoTableauBordVal = true;
																    																panelDaoTableauBordTra = false;
																    																panelDaoTableauBordVet =false;
																    																panelDaoTableauBordExa = false;
																    																panelDaoTableauBordCha = false;
																    																panelDaoTableauBordPub = false;
																    																panelDaoTableauBordPrise = false;
																    																panelDaoTableauBordPubDps = false;
																																	panelDaoTableauBordPubCsv = false;
																																	panelDaoTableauBordDPubCsv = false;
																																	panelDaoTableauBordDPubDps = false;
																    																panelDao = true;
																    																panelPrq =false;
																    															    panelAmi = false;
																    																fermerValDao =true;
																    																fermerSaiDao = false;
																    																btn_trans_ami =false;
																    																btn_trans_dao =false;
																    																btn_trans_prq =false;
																    																detailD = true ;
																    																detailA = false; 
																    																detailP = false;
																    																btn_valider_prq_cpmp = false;
																    																btn_valider_prq_dmp = false; 
																    																btn_valider_ami_cpmp = false; 
																    																btn_valider_ami_dmp = false;
																    																btn_valider_dao_cpmp = true;
																    																btn_valider_dao_dmp = true;
																    																btn_fermer_saisie_ami = false; 
																    																btn_fermer_saisie_prq = false;
																    																btn_fermer_saisie_dao = true;
																    																nbreAchat = false;
																    											    			}else
																    												    			if(action.equalsIgnoreCase("APEPRQ")) {
																    												    				 type = "PRQ";
																					    												 typePlan ="PN";
																    												    				libelleDao3="DETAILS DU";
																    												    				etat_dao =false;
																    												    				etat_prq =true;
																    												    				etat_ami =false;
																    												    				panelDetail=true;
																    												    				panelForm=false;
																    												   				    panelTraitement=false;
																    												    				libelle1="Detail";
																    												    				libelle2 = "Synthèse du PRQ N°";
																    												    				fermerSaiPrq = false; 
																    												    				fermerValPrq = false;
																    												    				fermerSaiAmi = false;
																    												    				fermerValAmi = false;
																    												    				fermerSaiDao = true;
																    												    				fermerValDao = false;
																    												    				detailD = true ;
																    																	detailA = false; 
																    																	detailP = false;
																    																	fermerApercuDao = true;
																    																	fermerApercuAmi = false;
																    																	fermerApercuPrq = false;
																    																	nbreAchat = false;
																    												    			}else
																    												    				 if(action.equalsIgnoreCase("AFFPRQ")) {
																    												    					 type = "PRQ";
																						    												 typePlan ="PN";
																						    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    															    			 libelleDao3="AFFECTATION DES PREQUALIFICATIONS (PRQ)";
																    															    			 btn_new =false;
																    															    			 btn_affec = true;
																    															    			 btn_retrait = false;
																    															    			 btn_valid = false;
																    															    			 panel1 =true;
																																				 panel2 =false;
																																				 panel3 = false;
																																				/* panel4 = false;
																																				 panel5 = false;
																																				 panel6 = false;
																																				 panel7 = false;
																																				 panel8 = true;
																																				 panel9 = false;
																																				 panel10 = false;
																																				 panel11 = false;
																																				 panel12 = false;*/
																    																			 venteRecherche = false; 
																    																			 affectationRecherche = true;
																    																			 examenRecherche = false;
																    																			 publicationRecherche = false;
																    																			 saisieRecherche = false;
																    																			 celluleRecherche = false;
																    																			 validationRecherche = false;
																    																			 priseRecherche = false;
																    																			 chargeRecherche = false;
																    																			 
																    																			 panelAffectation = true;
																    																			 affDao=true;
																    																			 exaDao=false;
																    																			 panelDaoTableauBordSai = false;
																    																			 panelDaoTableauBordVal = false;
																    																			 panelDaoTableauBordTra = false;
																    																			 panelDaoTableauBordAff =true;
																    																			 panelDaoTableauBordVet =false;
																    																			 panelDaoTableauBordRet = false;
																    																			 panelDaoTableauBordCha = false;
																    																			 panelDaoTableauBordPub = false;
																    																			 panelDaoTableauBordPrise = false;
																    																			 panelDaoTableauBordPubDps = false;
																																				 panelDaoTableauBordPubCsv = false;
																																				 panelDaoTableauBordDPubCsv = false;
																																				 panelDaoTableauBordDPubDps = false;
																    																			 panelDao = true;  
																    																			 panelPrq = false;
																    																			 btn_trans_ami =false;
																    																			 btn_trans_dao =true;
																    																			 btn_trans_prq =false;
																    																			 
																    																			 btn_creerDetailAmi = false;
																    																			 btn_creerDetailDao = false ;
																    																			 btn_creerDetailPrq = false;
																    																			 
																    																			 btn_creerDetailDaoCmp = true;
																    																			 btn_creerDetailAmiCmp = false;
																    																			 btn_creerDetailPrqCmp = false;
																    																			 btn_creerDetailDaoDmp = false;
																    																			 btn_creerDetailAmiDmp = false; 
																    																			 btn_creerDetailPrqDmp = false;
																    																			 fermerValDao = false;
																    																			 fermerSaiDao = true;
																    																			 detailD = false;
																    																			 detailA= false; 
																    																			 detailP = false;
																    																			 btn_valider_dao_cpmp =  false;
																    																			 btn_valider_dao_dmp = false;
																    																			 btn_valider_ami_cpmp = false; 
																    																			 btn_valider_prq_cpmp = false;
																    																			 btn_valider_ami_dmp = false;
																    																			 btn_valider_prq_dmp = false;
																    																			 btn_fermer_saisie_dao = false; 
																    																			 btn_fermer_saisie_ami = false; 
																    																			 btn_fermer_saisie_prq = false; 
																    																			 nbreAchat = false;
																    												    				 }else
																    												    					  if(action.equalsIgnoreCase("EXAPRQ")) {
																    												    						  type = "PRQ";
																								    												 typePlan ="PN";
																								    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    																    			 libelleDao3="EXAMEN DES PREQUALIFICATIONS";
																    																    			 btn_new =false;
																    																    			 btn_affec = false;
																    																    			 btn_exam = true;
																    																    			 btn_valid = false;
																    																    			 panel1 =true;
																																					 panel2 =false;
																																					 panel3 = false;
																																					/* panel4 = false;
																																					 panel5 = false;
																																					 panel6 = false;
																																					 panel7 = false;
																																					 panel8 = true;
																																					 panel9 = false;
																																					 panel10 = false;
																																					 panel11 = false;
																																					 panel12 = false;*/
																    																				 venteRecherche = false; 
																    																				 affectationRecherche = false;
																    																				 examenRecherche = true;
																    																				 publicationRecherche = false;
																    																				 saisieRecherche = false;
																    																				 celluleRecherche = false;
																    																				 validationRecherche = false;
																    																				 priseRecherche = false;
																    																				 chargeRecherche = false;
																    																				 panelAffectation = false;
																    																				 affDao=false;
																    																				 exaDao=true;
																    																				 panelDaoTableauBordSai = false;
																    																				 panelDaoTableauBordVal = false;
																    																				 panelDaoTableauBordTra = false;
																    																				 panelDaoTableauBordAff =false;
																    																				 panelDaoTableauBordExa =true;
																    																				 panelDaoTableauBordVet =false;
																    																				 panelDaoTableauBordCha = false;
																    																				 panelDaoTableauBordPub = false;
																    																				 panelDaoTableauBordPrise = false;
																    																				 panelDaoTableauBordPubDps = false;
																    																				 panelDaoTableauBordPubCsv = false;
																    																				 panelDaoTableauBordDPubCsv = false;
																																					 panelDaoTableauBordDPubDps = false;
																    																				 panelDao = true;  
																    																				 panelPrq = false;
																    																				 btn_trans_ami =false;
																    																				 btn_trans_dao =false;
																    																				 btn_trans_prq =false;
																    																				 
																    																				 btn_creerDetailAmi = false;
																    																				 btn_creerDetailDao = false ;
																    																				 btn_creerDetailPrq = false;
																    																				 
																    																				 btn_creerDetailDaoCmp = false;
																    																				 btn_creerDetailAmiCmp = false;
																    																				 btn_creerDetailPrqCmp = false;
																    																				 btn_creerDetailDaoDmp = false;
																    																				 btn_creerDetailAmiDmp = false; 
																    																				 btn_creerDetailPrqDmp = false;
																    																				 fermerValDao = false;
																    																				 fermerSaiDao = true;
																    																				 detailD = false;
																    																				 detailA= false; 
																    																				 detailP = false;
																    																				 btn_valider_dao_cpmp =  false;
																    																				 btn_valider_dao_dmp = false;
																    																				 btn_valider_ami_cpmp = false; 
																    																				 btn_valider_prq_cpmp = false;
																    																				 btn_valider_ami_dmp = false;
																    																				 btn_valider_prq_dmp = false;
																    																				 btn_fermer_saisie_dao = false; 
																    																				 btn_fermer_saisie_ami = false; 
																    																				 btn_fermer_saisie_prq = false; 
																    																				 nbreAchat = false;
																    												    					  }else
																    												    						   if(action.equalsIgnoreCase("VETPRQ")) {
																    												    							   type = "PRQ";
																									    												 typePlan ="PN";
																									    												 fonctionalite="listeDaoVentePn";
																									    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    												    							     libelle="VENTE / RETRAIT DU PRQ N°";
																    																	    			 libelleDao3="VENTE DES PREQUALIFICATIONS (PRQ)";
																    																	    			 btn_new =false;
																    																	    			 btn_affec = false;
																    																	    			 btn_exam = false;
																    																	    			 btn_retrait = true;
																    																	    			 btn_valid = false;
																    																	    			 panel1 =true;
																																						 panel2 =false;
																																						 panel3 = false;
																																						/* panel4 = false;
																																						 panel5 = false;
																																						 panel6 = false;
																																						 panel7 = false;
																																						 panel8 = true;
																																						 panel9 = false;
																																						 panel10 = false;
																																						 panel11 = false;
																																						 panel12 = false;*/
																    																					 venteRecherche = true; 
																    																					 affectationRecherche = false;
																    																					 examenRecherche = false;
																    																					 publicationRecherche = false;
																    																					 saisieRecherche = false;
																    																					 celluleRecherche = false;
																    																					 validationRecherche = false;
																    																					 priseRecherche = false;
																    																					 chargeRecherche = false;
																    																					 affDao=false;
																    																					 exaDao=false;
																    																					 retDao = true;
																    																					 panelDaoTableauBordSai = false;
																    																					 panelDaoTableauBordVal = false;
																    																					 panelDaoTableauBordTra = false;
																    																					 panelDaoTableauBordAff =false;
																    																					 panelDaoTableauBordExa =false; 
																    																					 panelDaoTableauBordRet =false; 
																    																					 panelDaoTableauBordVet =true;
																    																					 panelDaoTableauBordCha = false;
																    																					 panelDaoTableauBordPub = false;
																    																					 panelDaoTableauBordPrise = false;
																    																					 panelDaoTableauBordPubDps = false;
																    																					 panelDaoTableauBordPubCsv = false;
																    																					 panelDaoTableauBordDPubCsv = false;
																																						 panelDaoTableauBordDPubDps = false;
																    																					 panelDao = true;  
																    																					 panelPrq = false;
																    																					 btn_trans_ami =false;
																    																					 btn_trans_dao =false;
																    																					 btn_trans_prq =false;
																    																					 
																    																					 btn_creerDetailAmi = false;
																    																					 btn_creerDetailDao = false ;
																    																					 btn_creerDetailPrq = false;
																    																					 
																    																					 btn_creerDetailDaoCmp = false;
																    																					 btn_creerDetailAmiCmp = false;
																    																					 btn_creerDetailPrqCmp = false;
																    																					 btn_creerDetailDaoDmp = false;
																    																					 btn_creerDetailAmiDmp = false; 
																    																					 btn_creerDetailPrqDmp = false;
																    																					 fermerValDao = false;
																    																					 fermerSaiDao = true;
																    																					 detailD = false;
																    																					 detailA= false; 
																    																					 detailP = false;
																    																					 btn_valider_dao_cpmp =  false;
																    																					 btn_valider_dao_dmp = false;
																    																					 btn_valider_ami_cpmp = false; 
																    																					 btn_valider_prq_cpmp = false;
																    																					 btn_valider_ami_dmp = false;
																    																					 btn_valider_prq_dmp = false;
																    																					 btn_fermer_saisie_dao = false; 
																    																					 btn_fermer_saisie_ami = false; 
																    																					 btn_fermer_saisie_prq = false;
																    																					 nbreAchat = true;
																    												    						   }else
																    												    							   if(action.equalsIgnoreCase("CHAPRQ")) {
																    												    								   type = "PRQ";
																										    												 typePlan ="PN";
																										    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    																		    			 libelleDao3="EXAMEN DES PREQUALIFICATIONS (PRQ)";
																    																		    			 btn_new =false;
																    																		    			 btn_affec = false;
																    																		    			 btn_exam = false;
																    																		    			 btn_retrait = false;
																    																		    			 btn_valid = false;
																    																		    			 panel1 =false;
																																							 panel2 =false;
																																							 panel3 = true;
																																							/* panel4 = false;
																																							 panel5 = false;
																																							 panel6 = false;
																																							 panel7 = false;
																																							 panel8 = true;
																																							 panel9 = false;
																																							 panel10 = false;
																																							 panel11 = false;
																																							 panel12 = false;*/
																    																						 venteRecherche = false; 
																    																						 affectationRecherche = false;
																    																						 examenRecherche = false;
																    																						 publicationRecherche = false;
																    																						 saisieRecherche = false;
																    																						 celluleRecherche = false;
																    																						 validationRecherche = false;
																    																						 priseRecherche = false;
																    																						 chargeRecherche = true;
																    																						 affDao=false;
																    																						 exaDao=false;
																    																						 retDao = true;
																    																						 panelDaoTableauBordSai = false;
																    																						 panelDaoTableauBordVal = false;
																    																						 panelDaoTableauBordTra = false;
																    																						 panelDaoTableauBordAff =false;
																    																						 panelDaoTableauBordExa =false; 
																    																						 panelDaoTableauBordRet =false; 
																    																						 panelDaoTableauBordVet =false;
																    																						 panelDaoTableauBordCha = true;
																    																						 panelDaoTableauBordPub = false;
																    																						 panelDaoTableauBordPrise = false;
																    																						 panelDaoTableauBordPubDps = false;
																    																						 panelDaoTableauBordPubCsv = false;
																    																						 panelDaoTableauBordDPubCsv = false;
																																							 panelDaoTableauBordDPubDps = false;
																    																						 panelDao = true;  
																    																						 panelPrq = false;
																    																						 btn_trans_ami =false;
																    																						 btn_trans_dao =false;
																    																						 btn_trans_prq =false;
																    																						 
																    																						 btn_creerDetailAmi = false;
																    																						 btn_creerDetailDao = false ;
																    																						 btn_creerDetailPrq = false;
																    																						 
																    																						 btn_creerDetailDaoCmp = false;
																    																						 btn_creerDetailAmiCmp = false;
																    																						 btn_creerDetailPrqCmp = false;
																    																						 btn_creerDetailDaoDmp = false;
																    																						 btn_creerDetailAmiDmp = false; 
																    																						 btn_creerDetailPrqDmp = false;
																    																						 fermerValDao = false;
																    																						 fermerSaiDao = true;
																    																						 detailD = false;
																    																						 detailA= false; 
																    																						 detailP = false;
																    																						 btn_valider_dao_cpmp =  false;
																    																						 btn_valider_dao_dmp = false;
																    																						 btn_valider_ami_cpmp = false; 
																    																						 btn_valider_prq_cpmp = false;
																    																						 btn_valider_ami_dmp = false;
																    																						 btn_valider_prq_dmp = false;
																    																						 btn_fermer_saisie_dao = false; 
																    																						 btn_fermer_saisie_ami = false; 
																    																						 btn_fermer_saisie_prq = false;
																    																						 nbreAchat = false;
																    												    							   }else 
																    												    								   if(action.equalsIgnoreCase("PUBPRQ")) {
																    												    									   type = "PRQ";
																											    												 typePlan ="PN";
																											    												 fonctionalite="ListePubDacPn";
																											    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    																			    			 libelleDao3="PRQ EN ATTENTE DE PUBLICATION";
																    																			    			 btn_new =false;
																    																			    			 btn_affec = false;
																    																			    			 btn_exam = false;
																    																			    			 btn_pub =true;
																    																			    			 btn_retrait = false;
																    																			    			 btn_valid = false;
																    																			    			 panel1 =true;
																																								 panel2 =false;
																																								 panel3 = false;
																																								/* panel4 = false;
																																								 panel5 = false;
																																								 panel6 = false;
																																								 panel7 = false;
																																								 panel8 = true;
																																								 panel9 = false;
																																								 panel10 = false;
																																								 panel11 = false;
																																								 panel12 = false;*/
																    																							 venteRecherche = false; 
																    																							 affectationRecherche = false;
																    																							 examenRecherche = false;
																    																							 publicationRecherche = true;
																    																							 saisieRecherche = false;
																    																							 celluleRecherche = false;
																    																							 validationRecherche = false;
																    																							 priseRecherche = false;
																    																							 chargeRecherche = false;
																    																							 affDao=false;
																    																							 exaDao=false;
																    																							 retDao = false;
																    																							 panelDaoTableauBordSai = false;
																    																							 panelDaoTableauBordVal = false;
																    																							 panelDaoTableauBordTra = false;
																    																							 panelDaoTableauBordAff =false;
																    																							 panelDaoTableauBordExa =false; 
																    																							 panelDaoTableauBordRet =false;
																    																							 panelDaoTableauBordVet =false;
																    																							 panelDaoTableauBordCha = false;
																    																							 panelDaoTableauBordPub = true;
																    																							 panelDaoTableauBordPrise = false;
																    																							 panelDaoTableauBordPubDps = false;
																    																							 panelDaoTableauBordPubCsv = false;
																    																							 panelDaoTableauBordDPubCsv = false;
																																								 panelDaoTableauBordDPubDps = false;
																    																							 panelDao = false;  
																    																							 panelPrq = false;
																    																							 btn_trans_ami =false;
																    																							 btn_trans_dao =false;
																    																							 btn_trans_prq =false;
																    																							 
																    																							 btn_creerDetailAmi = false;
																    																							 btn_creerDetailDao = false ;
																    																							 btn_creerDetailPrq = false;
																    																							 
																    																							 btn_creerDetailDaoCmp = false;
																    																							 btn_creerDetailAmiCmp = false;
																    																							 btn_creerDetailPrqCmp = false;
																    																							 btn_creerDetailDaoDmp = false;
																    																							 btn_creerDetailAmiDmp = false; 
																    																							 btn_creerDetailPrqDmp = false;
																    																							 fermerValDao = false;
																    																							 fermerSaiDao = true;
																    																							 detailD = false;
																    																							 detailA= false; 
																    																							 detailP = false;
																    																							 btn_valider_dao_cpmp =  false;
																    																							 btn_valider_dao_dmp = false;
																    																							 btn_valider_ami_cpmp = false; 
																    																							 btn_valider_prq_cpmp = false;
																    																							 btn_valider_ami_dmp = false;
																    																							 btn_valider_prq_dmp = false;
																    																							 btn_fermer_saisie_dao = false; 
																    																							 btn_fermer_saisie_ami = false; 
																    																							 btn_fermer_saisie_prq = false; 
																    																							 nbreAchat = false;
																    												    								   }else
																    												    									     if(action.equalsIgnoreCase("TRAPRQ")) {
																    												    									    	 type = "PRQ";
																												    												 typePlan ="PN";
																												    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    																				    			 libelleDao3="TRANSMISSION DU PRQ PAR LA CELLULE";
																    																				    			 libelleDao1 ="TRANSMISSION DU PRQ PAR LA CELLULE";
																    																				    			 btn_new =false;
																    																				    			 btn_affec = false;
																    																				    			 btn_exam = false;
																    																				    			 btn_retrait = false;
																    																				    			 btn_valid = false;
																    																				    			 panel1 =true;
																																									 panel2 =false;
																																									 panel3 = false;
																																									/* panel4 = false;
																																									 panel5 = false;
																																									 panel6 = false;
																																									 panel7 = false;
																																									 panel8 = true;
																																									 panel9 = false;
																																									 panel10 = false;
																																									 panel11 = false;
																																									 panel12 = false;*/
																    																								 affDao=false;
																    																								 exaDao=false;
																    																								 retDao = true;
																    																								 panelDaoTableauBordSai = false;
																    																								 panelDaoTableauBordVal = false;
																    																								 panelDaoTableauBordTra = true;
																    																								 panelDaoTableauBordAff =false;
																    																								 panelDaoTableauBordExa =false; 
																    																								 panelDaoTableauBordRet =false; 
																    																								 panelDaoTableauBordVet =false;
																    																								 panelDaoTableauBordCha = false;
																    																								 panelDaoTableauBordPub = false;
																    																								 panelDaoTableauBordPrise = false;
																    																								 panelDaoTableauBordPubDps = false;
																    																								 panelDaoTableauBordPubCsv = false;
																    																								 panelDaoTableauBordDPubCsv = false;
																																									 panelDaoTableauBordDPubDps = false;
																    																								 panelDao = true;  
																    																								 panelPrq = false;
																    																								 btn_trans_ami =false;
																    																								 btn_trans_dao =false;
																    																								 btn_trans_prq =false;
																    																								 
																    																								 btn_creerDetailAmi = false;
																    																								 btn_creerDetailDao = false ;
																    																								 btn_creerDetailPrq = false;
																    																								 
																    																								 btn_creerDetailDaoCmp = false;
																    																								 btn_creerDetailAmiCmp = false;
																    																								 btn_creerDetailPrqCmp = false;
																    																								 btn_creerDetailDaoDmp = false;
																    																								 btn_creerDetailAmiDmp = false; 
																    																								 btn_creerDetailPrqDmp = false;
																    																								 fermerValDao = false;
																    																								 fermerSaiDao = true;
																    																								 detailD = false;
																    																								 detailA= false; 
																    																								 detailP = false;
																    																								 btn_valider_dao_cpmp =  false;
																    																								 btn_valider_dao_dmp = false;
																    																								 btn_valider_ami_cpmp = false; 
																    																								 btn_valider_prq_cpmp = false;
																    																								 btn_valider_ami_dmp = false;
																    																								 btn_valider_prq_dmp = false;
																    																								 btn_fermer_saisie_dao = false; 
																    																								 btn_fermer_saisie_ami = false; 
																    																								 btn_fermer_saisie_prq = false; 
																    																								 nbreAchat = false;
																    												    									     }else
																    												    									    	 if(action.equalsIgnoreCase("RETPRQ")) {
																    												    									    		 type = "PRQ";
																													    												 typePlan ="PN";
																													    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    																					    			 libelleDao3="RETRAIT DES PREQUALIFICATIONS (PRQ)";
																    																					    			 btn_new =false;
																    																					    			 btn_affec = false;
																    																					    			 btn_exam = false;
																    																					    			 btn_retrait = true;
																    																					    			 btn_valid = false;
																    																					    			 panel1 =true;
																																										 panel2 =false;
																																										 panel3 = false;
																																										/* panel4 = false;
																																										 panel5 = false;
																																										 panel6 = false;
																																										 panel7 = false;
																																										 panel8 = true;
																																										 panel9 = false;
																																										 panel10 = false;
																																										 panel11 = false;
																																										 panel12 = false;*/
																    																									 affDao=false;
																    																									 exaDao=false;
																    																									 retDao = true;
																    																									 panelDaoTableauBordSai = false;
																    																									 panelDaoTableauBordVal = false;
																    																									 panelDaoTableauBordTra = false;
																    																									 panelDaoTableauBordAff =false;
																    																									 panelDaoTableauBordExa =false; 
																    																									 panelDaoTableauBordRet =true; 
																    																									 panelDaoTableauBordVet =false;
																    																									 panelDaoTableauBordCha = false;
																    																									 panelDaoTableauBordPub = false;
																    																									 panelDaoTableauBordPrise = false;
																    																									 panelDaoTableauBordPubDps = false;
																    																									 panelDaoTableauBordPubCsv = false;
																    																									 panelDaoTableauBordDPubCsv = false;
																																										 panelDaoTableauBordDPubDps = false;
																    																									 panelDao = true;  
																    																									 panelPrq = false;
																    																									 btn_trans_ami =false;
																    																									 btn_trans_dao =false;
																    																									 btn_trans_prq =false;
																    																									 
																    																									 btn_creerDetailAmi = false;
																    																									 btn_creerDetailDao = false ;
																    																									 btn_creerDetailPrq = false;
																    																									 
																    																									 btn_creerDetailDaoCmp = false;
																    																									 btn_creerDetailAmiCmp = false;
																    																									 btn_creerDetailPrqCmp = false;
																    																									 btn_creerDetailDaoDmp = false;
																    																									 btn_creerDetailAmiDmp = false; 
																    																									 btn_creerDetailPrqDmp = false;
																    																									 fermerValDao = false;
																    																									 fermerSaiDao = true;
																    																									 detailD = false;
																    																									 detailA= false; 
																    																									 detailP = false;
																    																									 btn_valider_dao_cpmp =  false;
																    																									 btn_valider_dao_dmp = false;
																    																									 btn_valider_ami_cpmp = false; 
																    																									 btn_valider_prq_cpmp = false;
																    																									 btn_valider_ami_dmp = false;
																    																									 btn_valider_prq_dmp = false;
																    																									 btn_fermer_saisie_dao = false; 
																    																									 btn_fermer_saisie_ami = false; 
																    																									 btn_fermer_saisie_prq = false;
																    																									 nbreAchat = false;
																    																    						   }else
																    													    									    	 if(action.equalsIgnoreCase("OBSPRQ")) {
																    													    									    		 type = "PRQ";
																														    												 typePlan ="PN";
																														    												 libelle1="LISTE DES PREQUALIFICATIONS (PRQ)";
																    																						    			 libellesmall=" ";
																    																						    			 libelleDao3="PRISE EN COMPTE DES OBSERVATIONS";
																    																						    			 btn_new =false;
																    																						    			 fonctionalite="listeDaoCorrectionPn";
																    																						    			 btn_affec = false;
																    																						    			 btn_exam = false;
																    																						    			 btn_retrait = true;
																    																						    			 btn_valid = false;
																    																						    			 panel1 =true;
																																											 panel2 =false;
																																											 panel3 = false;
																																											/* panel4 = false;
																																											 panel5 = false;
																																											 panel6 = false;
																																											 panel7 = false;
																																											 panel8 = true;
																																											 panel9 = false;
																																											 panel10 = false;
																																											 panel11 = false;
																																											 panel12 = false;*/
																    																										 venteRecherche = false; 
																    																										 affectationRecherche = false;
																    																										 examenRecherche = false;
																    																										 publicationRecherche = false;
																    																										 saisieRecherche = false;
																    																										 celluleRecherche = false;
																    																										 validationRecherche = false;
																    																										 priseRecherche = true;
																    																										 chargeRecherche = false;
																    																										 affDao=false;
																    																										 exaDao=false;
																    																										 retDao = true;
																    																										 panelDaoTableauBordSai = false;
																    																										 panelDaoTableauBordVal = false;
																    																										 panelDaoTableauBordTra = false;
																    																										 panelDaoTableauBordAff =false;
																    																										 panelDaoTableauBordExa =false; 
																    																										 panelDaoTableauBordRet =false; 
																    																										 panelDaoTableauBordVet =false;
																    																										 panelDaoTableauBordCha = false;
																    																										 panelDaoTableauBordPub = false;
																    																										 panelDaoTableauBordPrise = true;
																    																										 panelDaoTableauBordPubDps = false;
																    																										 panelDaoTableauBordPubCsv = false;
																    																										 panelDaoTableauBordDPubCsv = false;
																																											 panelDaoTableauBordDPubDps = false;
																    																										 panelDao = true;  
																    																										 panelPrq = false;
																    																										 btn_trans_ami =false;
																    																										 btn_trans_dao =false;
																    																										 btn_trans_prq =false;
																    																										 
																    																										 btn_creerDetailAmi = false;
																    																										 btn_creerDetailDao = false ;
																    																										 btn_creerDetailPrq = false;
																    																										 
																    																										 btn_creerDetailDaoCmp = false;
																    																										 btn_creerDetailAmiCmp = false;
																    																										 btn_creerDetailPrqCmp = false;
																    																										 btn_creerDetailDaoDmp = false;
																    																										 btn_creerDetailAmiDmp = false; 
																    																										 btn_creerDetailPrqDmp = false;
																    																										 fermerValDao = false;
																    																										 fermerSaiDao = true;
																    																										 detailD = false;
																    																										 detailA= false; 
																    																										 detailP = false;
																    																										 btn_valider_dao_cpmp =  false;
																    																										 btn_valider_dao_dmp = false;
																    																										 btn_valider_ami_cpmp = false; 
																    																										 btn_valider_prq_cpmp = false;
																    																										 btn_valider_ami_dmp = false;
																    																										 btn_valider_prq_dmp = false;
																    																										 btn_fermer_saisie_dao = false; 
																    																										 btn_fermer_saisie_ami = false; 
																    																										 btn_fermer_saisie_prq = false;
																    																										 nbreAchat = false;
																    																	    						   }else 
																    																    								   if(action.equalsIgnoreCase("PRQCSV")) {
																    																    									     typePlan ="PN";
																    																    									     type = "PRQ";
																    																    									     fonctionalite="listePrqCsv";
																    																    									     btn_pub =false;
																    																    									     btn_pub_csv = false;
																    																    									     btn_pub_dps = false;
																    																    									     btn_ami_csv = false; 
																    																    									     btn_ami_dps = false;
																    																    									     btn_prq_csv = true; 
																    																    									     btn_prq_dps = false;
																    																    									     libelle1="LISTE DES PRQ EN PROCEDURE NORMALE";
																    																							    			 libelleDao3="PREQUALIFICATION EN ATTENTE DE PUBLICATION";
																    																							    			 btn_new =false;
																    																							    			 btn_affec = false;
																    																							    			 btn_exam = false;
																    																							    			 btn_retrait = false;
																    																							    			 btn_valid = false;
																    																							    			 saisie=false;
																    																							    			 publication=true;
																    																							    			 vente=false;
																    																							    			  correction=false;
																    																							    			 panel1 =false;
																    																											 panel2 =false;
																    																											 panel3 = false;
																    																										     panel4 = true;
																    																											/* panel5 = false;
																    																											 panel6 = false;
																    																											 panel7 = true;
																    																											 panel8 = false;
																    																											 panel9 =false;
																    																											 panel10 = false;
																    																											 panel11 = false;
																    																											 panel12 = false;*/
																    																											 venteRecherche = false; 
																    																											 affectationRecherche = false;
																    																											 examenRecherche = false;
																    																											 publicationRecherche = true;
																    																											 saisieRecherche = false;
																    																											 celluleRecherche = false;
																    																											 validationRecherche = false;
																    																											 priseRecherche = false;
																    																											 chargeRecherche = false;
																    																											 affDao=false;
																    																											 exaDao=false;
																    																											 retDao = false;
																    																											 panelDaoTableauBordSai = false;
																    																											 panelDaoTableauBordVal = false;
																    																											 panelDaoTableauBordTra = false;
																    																											 panelDaoTableauBordAff =false;
																    																											 panelDaoTableauBordExa =false; 
																    																											 panelDaoTableauBordRet =false;
																    																											 panelDaoTableauBordVet =false;
																    																											 panelDaoTableauBordCha = false;
																    																											 panelDaoTableauBordPub = false;
																    																											 panelDaoTableauBordPrise = false;
																    																											 panelDaoTableauBordPubDps = false;
																    																											 panelDaoTableauBordPubCsv = true;
																    																											 panelDao = false;  
																    																											 panelPrq = false;
																    																											 btn_trans_ami =false;
																    																											 btn_trans_dao =false;
																    																											 btn_trans_prq =false;
																    																											 
																    																											 btn_creerDetailAmi = false;
																    																											 btn_creerDetailDao = false ;
																    																											 btn_creerDetailPrq = false;
																    																											 
																    																											 btn_creerDetailDaoCmp = false;
																    																											 btn_creerDetailAmiCmp = false;
																    																											 btn_creerDetailPrqCmp = false;
																    																											 btn_creerDetailDaoDmp = false;
																    																											 btn_creerDetailAmiDmp = false; 
																    																											 btn_creerDetailPrqDmp = false;
																    																											 fermerValDao = false;
																    																											 fermerSaiDao = true;
																    																											 detailD = false;
																    																											 detailA= false; 
																    																											 detailP = false;
																    																											 btn_valider_dao_cpmp =  false;
																    																											 btn_valider_dao_dmp = false;
																    																											 btn_valider_ami_cpmp = false; 
																    																											 btn_valider_prq_cpmp = false;
																    																											 btn_valider_ami_dmp = false;
																    																											 btn_valider_prq_dmp = false;
																    																											 btn_fermer_saisie_dao = false; 
																    																											 btn_fermer_saisie_ami = false; 
																    																											 btn_fermer_saisie_prq = false; 
																    																											 nbreAchat = false;
																    																    								   }else 
																    																	    								   if(action.equalsIgnoreCase("DPRQCSV")) {
																    																	    									     typePlan ="PN";
																    																	    									     type = "PRQ";
																    																	    									     fonctionalite="listeDprqCsv";
																    																	    									     btn_pub =false;
																    																	    									     btn_pub_csv = false;
																    																	    									     btn_pub_dps = false;
																    																	    									     btn_ami_csv = false; 
																    																	    									     btn_ami_dps = false;
																    																	    									     btn_prq_csv = false; 
																    																	    									     btn_prq_dps = true;
																    																	    									     libelle1="LISTE DES PRQ EN PROCEDURE NORMALE";
																    																								    			 libelleDao3="PREQUALIFICATIONS PUBLIEES";
																    																								    			 btn_new =false;
																    																								    			 btn_affec = false;
																    																								    			 btn_exam = false;
																    																								    			 btn_retrait = false;
																    																								    			 btn_valid = false;
																    																								    			 saisie=false;
																    																								    			 publication=true;
																    																								    			 vente=false;
																    																								    			 correction=false;
																    																								    			 panel1 =false;
																    																												 panel2 =false;
																    																												 panel3 = false;
																    																											     panel4 = true;
																    																												/* panel5 = false;
																    																												 panel6 = false;
																    																												 panel7 = true;
																    																												 panel8 = false;
																    																												 panel9 =false;
																    																												 panel10 = false;
																    																												 panel11 = false;
																    																												 panel12 = false;*/
																    																												 venteRecherche = false; 
																    																												 affectationRecherche = false;
																    																												 examenRecherche = false;
																    																												 publicationRecherche = true;
																    																												 saisieRecherche = false;
																    																												 celluleRecherche = false;
																    																												 validationRecherche = false;
																    																												 priseRecherche = false;
																    																												 chargeRecherche = false;
																    																												 affDao=false;
																    																												 exaDao=false;
																    																												 retDao = false;
																    																												 panelDaoTableauBordSai = false;
																    																												 panelDaoTableauBordVal = false;
																    																												 panelDaoTableauBordTra = false;
																    																												 panelDaoTableauBordAff =false;
																    																												 panelDaoTableauBordExa =false; 
																    																												 panelDaoTableauBordRet =false;
																    																												 panelDaoTableauBordVet =false;
																    																												 panelDaoTableauBordCha = false;
																    																												 panelDaoTableauBordPub = false;
																    																												 panelDaoTableauBordPrise = false;
																    																												 panelDaoTableauBordPubDps = false;
																    																												 panelDaoTableauBordPubCsv = false;
																    																												 panelDaoTableauBordDPubCsv = true;
																    																												 panelDaoTableauBordDPubDps = false;
																    																												 panelDao = false;  
																    																												 panelPrq = false;
																    																												 btn_trans_ami =false;
																    																												 btn_trans_dao =false;
																    																												 btn_trans_prq =false;
																    																												 
																    																												 btn_creerDetailAmi = false;
																    																												 btn_creerDetailDao = false ;
																    																												 btn_creerDetailPrq = false;
																    																												 
																    																												 btn_creerDetailDaoCmp = false;
																    																												 btn_creerDetailAmiCmp = false;
																    																												 btn_creerDetailPrqCmp = false;
																    																												 btn_creerDetailDaoDmp = false;
																    																												 btn_creerDetailAmiDmp = false; 
																    																												 btn_creerDetailPrqDmp = false;
																    																												 fermerValDao = false;
																    																												 fermerSaiDao = true;
																    																												 detailD = false;
																    																												 detailA= false; 
																    																												 detailP = false;
																    																												 btn_valider_dao_cpmp =  false;
																    																												 btn_valider_dao_dmp = false;
																    																												 btn_valider_ami_cpmp = false; 
																    																												 btn_valider_prq_cpmp = false;
																    																												 btn_valider_ami_dmp = false;
																    																												 btn_valider_prq_dmp = false;
																    																												 btn_fermer_saisie_dao = false; 
																    																												 btn_fermer_saisie_ami = false; 
																    																												 btn_fermer_saisie_prq = false;
																    																												 nbreAchat = false;
																    																	    								   }else 
																    																		    								   if(action.equalsIgnoreCase("PRQDPS")) {
																    																		    									     typePlan ="PS";
																    																		    									     type = "PRQ";
																    																		    									     fonctionalite="listePubDprqCsv";
																    																		    									     btn_pub =false;
																    																		    									     btn_pub_csv = false;
																    																		    									     btn_pub_dps = true;
																    																		    									     btn_pub_dps = false;
																    																		    									     btn_ami_csv = false;
																    																		    									     btn_ami_dps = false;
																    																		    									     btn_prq_csv = false;
																    																		    									     btn_prq_dps = true;
																    																		    									     libelle1="LISTE DES PRQ EN PROCEDURE SIMPLIFIEE";
																    																									    			 libelleDao3="PREQUALIFICATION EN ATTENTE DE PUBLICATION";
																    																									    			 btn_new =false;
																    																									    			 btn_affec = false;
																    																									    			 btn_exam = false;
																    																									    			 btn_retrait = false;
																    																									    			 btn_valid = false;
																    																									    			 saisie=false;
																    																									    			 publication=true;
																    																									    			 vente=false;
																    																									    			 correction=false;
																    																									    			 panel1 =false;
																    																													 panel2 =false;
																    																													 panel3 = false;
																    																												     panel4 = true;
																    																													/* panel5 = false;
																    																													 panel6 = false;
																    																													 panel7 = true;
																    																													 panel8 = false;
																    																													 panel9 =false;
																    																													 panel10 = false;
																    																													 panel11 = false;
																    																													 panel12 = false;*/
																    																													 venteRecherche = false; 
																    																													 affectationRecherche = false;
																    																													 examenRecherche = false;
																    																													 publicationRecherche = true;
																    																													 saisieRecherche = false;
																    																													 celluleRecherche = false;
																    																													 validationRecherche = false;
																    																													 priseRecherche = false;
																    																													 chargeRecherche = false;
																    																													 affDao=false;
																    																													 exaDao=false;
																    																													 retDao = false;
																    																													 panelDaoTableauBordSai = false;
																    																													 panelDaoTableauBordVal = false;
																    																													 panelDaoTableauBordTra = false;
																    																													 panelDaoTableauBordAff =false;
																    																													 panelDaoTableauBordExa =false; 
																    																													 panelDaoTableauBordRet =false;
																    																													 panelDaoTableauBordVet =false;
																    																													 panelDaoTableauBordCha = false;
																    																													 panelDaoTableauBordPub = false;
																    																													 panelDaoTableauBordPrise = false;
																    																													 panelDaoTableauBordPubDps = true;
																    																													 panelDaoTableauBordPubCsv = false;
																    																													 panelDao = false;  
																    																													 panelPrq = false;
																    																													 btn_trans_ami =false;
																    																													 btn_trans_dao =false;
																    																													 btn_trans_prq =false;
																    																													 
																    																													 btn_creerDetailAmi = false;
																    																													 btn_creerDetailDao = false ;
																    																													 btn_creerDetailPrq = false;
																    																													 
																    																													 btn_creerDetailDaoCmp = false;
																    																													 btn_creerDetailAmiCmp = false;
																    																													 btn_creerDetailPrqCmp = false;
																    																													 btn_creerDetailDaoDmp = false;
																    																													 btn_creerDetailAmiDmp = false; 
																    																													 btn_creerDetailPrqDmp = false;
																    																													 fermerValDao = false;
																    																													 fermerSaiDao = true;
																    																													 detailD = false;
																    																													 detailA= false; 
																    																													 detailP = false;
																    																													 btn_valider_dao_cpmp =  false;
																    																													 btn_valider_dao_dmp = false;
																    																													 btn_valider_ami_cpmp = false; 
																    																													 btn_valider_prq_cpmp = false;
																    																													 btn_valider_ami_dmp = false;
																    																													 btn_valider_prq_dmp = false;
																    																													 btn_fermer_saisie_dao = false; 
																    																													 btn_fermer_saisie_ami = false; 
																    																													 btn_fermer_saisie_prq = false; 
																    																													 nbreAchat = false;
																    																		    								   }else 
																    																			    								   if(action.equalsIgnoreCase("DPRQDPS")) {
																    																			    									    typePlan ="PS";
																    																			    									     type = "PRQ";
																    																			    									     fonctionalite="listePubPdpsCsv";
																    																			    									     btn_pub =false;
																    																			    									     btn_pub_csv = false;
																    																			    									     btn_pub_dps = false;
																    																			    									     btn_pub_dps = false;
																    																			    									     btn_ami_csv = false;
																    																			    									     btn_ami_dps = false;
																    																			    									     btn_prq_csv = false;
																    																			    									     btn_prq_dps = false;
																    																			    									     libelle1="LISTE DES PRQ EN PROCEDURE SIMPLIFIEE";
																    																										    			 libelleDao3="PREQUALIFICATIONS PUBLIEES";
																    																										    			 btn_new =false;
																    																										    			 btn_affec = false;
																    																										    			 btn_exam = false;
																    																										    			 btn_retrait = false;
																    																										    			 btn_valid = false;
																    																										    			 saisie=false;
																    																										    			 publication=true;
																    																										    			 vente=false;
																    																										    			  correction=false;
																    																										    			 panel1 =false;
																    																														 panel2 =false;
																    																														 panel3 = false;
																    																													     panel4 = true;
																    																														/* panel5 = false;
																    																														 panel6 = false;
																    																														 panel7 = true;
																    																														 panel8 = false;
																    																														 panel9 =false;
																    																														 panel10 = false;
																    																														 panel11 = false;
																    																														 panel12 = false;*/
																    																														 venteRecherche = false; 
																    																														 affectationRecherche = false;
																    																														 examenRecherche = false;
																    																														 publicationRecherche = true;
																    																														 saisieRecherche = false;
																    																														 celluleRecherche = false;
																    																														 validationRecherche = false;
																    																														 priseRecherche = false;
																    																														 chargeRecherche = false;
																    																														 affDao=false;
																    																														 exaDao=false;
																    																														 retDao = false;
																    																														 panelDaoTableauBordSai = false;
																    																														 panelDaoTableauBordVal = false;
																    																														 panelDaoTableauBordTra = false;
																    																														 panelDaoTableauBordAff =false;
																    																														 panelDaoTableauBordExa =false; 
																    																														 panelDaoTableauBordRet =false;
																    																														 panelDaoTableauBordVet =false;
																    																														 panelDaoTableauBordCha = false;
																    																														 panelDaoTableauBordPub = false;
																    																														 panelDaoTableauBordPrise = false;
																    																														 panelDaoTableauBordPubDps = false;
																    																														 panelDaoTableauBordPubCsv = false;
																    																														 panelDaoTableauBordDPubCsv = false;
																    																														 panelDaoTableauBordDPubDps = true;
																    																														 panelDao = false;  
																    																														 panelPrq = false;
																    																														 btn_trans_ami =false;
																    																														 btn_trans_dao =false;
																    																														 btn_trans_prq =false;
																    																														 
																    																														 btn_creerDetailAmi = false;
																    																														 btn_creerDetailDao = false ;
																    																														 btn_creerDetailPrq = false;
																    																														 
																    																														 btn_creerDetailDaoCmp = false;
																    																														 btn_creerDetailAmiCmp = false;
																    																														 btn_creerDetailPrqCmp = false;
																    																														 btn_creerDetailDaoDmp = false;
																    																														 btn_creerDetailAmiDmp = false; 
																    																														 btn_creerDetailPrqDmp = false;
																    																														 fermerValDao = false;
																    																														 fermerSaiDao = true;
																    																														 detailD = false;
																    																														 detailA= false; 
																    																														 detailP = false;
																    																														 btn_valider_dao_cpmp =  false;
																    																														 btn_valider_dao_dmp = false;
																    																														 btn_valider_ami_cpmp = false; 
																    																														 btn_valider_prq_cpmp = false;
																    																														 btn_valider_ami_dmp = false;
																    																														 btn_valider_prq_dmp = false;
																    																														 btn_fermer_saisie_dao = false; 
																    																														 btn_fermer_saisie_ami = false; 
																    																														 btn_fermer_saisie_prq = false;
																    																														 nbreAchat = false;
																    																			    								   }else
				    		//GESTION DES DEPOTS D'APPLEL D'OFFRE
				    				if(action.equalsIgnoreCase("LISAAO")) {
						    			type = "Dépot des Offres";
						    			libelle1="LISTE DES AVIS D'APPEL D'OFFRE";
						    			 btn_new =true;
										 panel1 =true;
										 panel2 =false;
										 panelPrqTableauBordSai = true;
										 panelPrqTableauBordVal = false;
								
						    		}else
						    			if(action.equalsIgnoreCase("SAIDEP")) {
							    			type = "Dépot des Offres";
							    			libelle="SAISIE DES OFFRES DE L'AVIS D'APPEL D'OFFRE N°";
											 panel1 =true;
											 panel2 =false;
									
							    		}
			 
				    		//GESTION DES COMMISSIONS
				    				
							    		if(action.equalsIgnoreCase("LISCRE")) {
							    			type = "Commission";
							    			libelle="OUVERTURE DES OFFRES";
							    			libelleDao1="SAISIE D'UNE NOUVELLE PREQUALIFICATION";
							    			libellesmall="Nouvelle Préqualification";
							    			libellePrq2 ="SAISIE D'UNE NOUVELLE PREQUALIFICATION";	
							    			 btn_new =true;
											 panel1 =true;
											 panelOuverture =false;
											 panelAnalyse =false;
											 panelJugement =false;
											 panelPrqTableauBordSai = true;
											 panelPrqTableauBordVal = false;
											 panelAmi = false;
											 panelDao = false;  
											 panelPrq = true;
											 btn_trans_ami =false;
											 btn_trans_dao =false;
											 btn_trans_prq =true;
											 btn_creerDetailAmi = true;
											 btn_creerDetailDao = false; 
											 btn_creerDetailPrq = false;
											 btn_creerDetailDaoCmp = false;
											 btn_creerDetailAmiCmp = false;
											 btn_creerDetailPrqCmp = true;
											 btn_creerDetailDaoDmp = false;
											 btn_creerDetailAmiDmp = false; 
											 btn_creerDetailPrqDmp = true;
											 fermerValPrq = false;
											 fermerSaiPrq = true;
											 detailD = false;
											 detailA= false; 
											 detailP = true;
											 btn_valider_dao_cpmp =  false;
											 btn_valider_dao_dmp = false;
											 btn_valider_ami_cpmp = false;  
											 btn_valider_prq_cpmp = false;
											 btn_valider_ami_dmp = false;  
											 btn_valider_prq_dmp = false;
											 btn_fermer_saisie_dao = false; 
											 btn_fermer_saisie_ami = false;  
											 btn_fermer_saisie_prq = true; 
							    		}else
							    			//OUVERTURE
							    			if(action.equalsIgnoreCase("LISOUV")) {
								    			type = "Commission";
								    			fonctionalite = "listOuvertureAc";
								    			libelle="SEANCE D'OUVERTURE : SAISIE DES OFFRES";
								    			libelleFinCom = "Fin de la séance d'ouverture";
								    			libelleConfirm = "Confirmez-vous la fin de la séance d'ouverture de l'avis d'appel d'Offre N°";
												 panel1 =false;
												 btn_membre = true;
												 btn_apercuOuv =true;
												 btn_apercuAna =false;
												 btn_apercuJug =false;
										
								    		}else
								    			//DETAIL OUVERTURE
								    			if(action.equalsIgnoreCase("DETOUV")) {
									    			type = "Commission";
									    			opdPiece = "Ouverture";
									    			libelle="DETAILS DE L'OFFRRE N°";
									    			btn_fermerOuverture =true;
									    			btn_fermerAnalyse =false;
									    			btn_fermerJugement =false;
									    		}
							    			else
								    			if(action.equalsIgnoreCase("LISMBR")) {
									    			type = "Commission";
									    			libelle="SEANCE D'OUVERTURE : Composition de la commssion";
									    		}else
									    			if(action.equalsIgnoreCase("LISCOM")) {
										    			type = "Commission";
										    			libelle="SAISIE DU COMITE D'EVALUATION";
										    		}
								    			else
								    			//ANALYSE DES OFFRES
								    			if(action.equalsIgnoreCase("LISANA")) {
									    			type = "Commission";
									    			fonctionalite = "listAnalyseAc";
									    			libelleFinCom = "Fin de l'analyse";
									    			libelleConfirm = "Confirmez-vous la fin de l'analyse des Offres de l'avis d'appel d'Offre N°";
									    			libelle="ANALYSE DES OFFRES";
									    			 btn_apercuOuv =false;
													 btn_apercuAna =true;
													 btn_apercuJug =false;
									    			btn_membre = false;
													 panel1 =false;
									    		}else
									    			//DETAIL ANALYSE DES OFFRES
									    			if(action.equalsIgnoreCase("DETANA")) {
										    			type = "Commission";
										    			opdPiece = "Analyse";
										    			libelle="DEAILS DE L'OFFRRE N°";
										    			btn_fermerOuverture =false;
										    			btn_fermerAnalyse =true;
										    			btn_fermerJugement =false;
										    		}
								    			else
									    			if(action.equalsIgnoreCase("SAIANA")) {
										    			type = "Commission";
										    			libelle="ANALYSE DES OFFRES DE L'AVIS N°";
										    			btn_fermerOuverture =false;
										    			btn_fermerAnalyse =true;
										    			btn_fermerJugement =false;
										    		}
							    		        //JUGEMENT DES OFFRES
								    			else
									    			if(action.equalsIgnoreCase("LISJUG")) {
										    			type = "Commission";
										    			fonctionalite = "listJugementAc";
										    			libelle="JUGEMENT DES OFFRES";
										    			libelleFinCom = "Fin du jugement de l'appel d'offre";
										    			libelleConfirm = "Confirmez-vous la fin du jugement de l'avis d'appel d'Offre N°";
										    			btn_apercuOuv =false;
														btn_apercuAna =false;
														btn_apercuJug =true;
										    			btn_membre = false;
														 panel1 =false;
										    		}else
										    			//DETAIL JUGEMENT
										    			if(action.equalsIgnoreCase("DETJUG")) {
											    			type = "Commission";
											    			opdPiece = "Jugement";
											    			libelle="DEAILS DE L'OFFRRE N°";
											    			btn_fermerOuverture =false;
											    			btn_fermerAnalyse =false;
											    			btn_fermerJugement =true;
											    		}
									    			else
										    			if(action.equalsIgnoreCase("SAIJUG")) {
											    			type = "Commission";
											    			libelle="JUGEMENT DES OFFRES";	
											    		}else
											    			if(action.equalsIgnoreCase("RESJUG")) {
												    			type = "Commission";
												    			libelle="EVALUATION FINANCIERE DES OFFRES DU LOT N°";	
												    		}else
											    			
											    			//DEBUT GESTION DES PROCEDURES DERROGATOIRES
											    			if(action.equalsIgnoreCase("LISDEMSAI")) {
												    			type = "Demandes";
												    			fonctionalite = "listSaisieAc";
												    			libelle="LISTE DES DEMANDE SAISIES";	
												    			libelleTitle = "Transmettre";
												    			libelleConfirm = "Confirmez-vous la transmission de la demande N°";
																btn_new =true;
															    fermerSai=true;
																fermerVal=false;
																
												    		}else
												    			if(action.equalsIgnoreCase("LISVALDEM")) { 
													    			type = "Demandes";
													    			fonctionalite = "listValidationCpmp";
													    			libelle="LISTE DES DEMANDES EN ATTENTE DE TRANSMISSION PAR LA CELLULE";
													    			libelleFinCom = "Validation éffectuée avec succès !";
													    			libelleConfirm = "Confirmez-vous la prévalidation de la demande N°";
													    			libelleTitle = "Prévalidation";
																	btn_new =false;
																	btn_retourner = true;
																    fermerSai=true;
																	fermerVal=false;
													    		}else
													    			if(action.equalsIgnoreCase("SAIDEMAC")) {
														    			type = "Demandes";
														    			//fonctionalite = "listAvenantAc";
														    			libelle="NOUVELLE DEMANDE";	
																	    fermerSai=true;
																		fermerVal=false;
														    		}else
														    			if(action.equalsIgnoreCase("VALDEMSPD")) {
															    			type = "Demandes";
															    			fonctionalite = "listValidationSPD";
															    			libelle="LISTE DES DEMANDES EN ATTENTE DE VALIDATION PAR LE SERVICE PROCEDURE DEROGAOIRE";
															    			libelleTitle = "Validation";
															    			libelleConfirm = "Confirmez-vous la validation de la demande N°";
															    			libelleFinCom = "Validation éffectuée avec succès !";
															    			panel1 =true;
															    			btn_retourner = true;
																			panel2 =false;
																			btn_new =false;
																		    fermerSai=true;
																			fermerVal=false;
															    		}else
															    			if(action.equalsIgnoreCase("TRADEMCE")) {
																    			type = "Demandes";
																    			//fonctionalite = "listAvenantAc";
																    			libelle="TRAITEMENT DU DOSSIER N°";	
																			    fermerSai=true;
																				fermerVal=false;
																    		}else
																    			if(action.equalsIgnoreCase("TRANDEM")) {
																	    			type = "Demandes";
																	    			//fonctionalite = "listAvenantAc";
																	    			libelle="TRANSMISSION DE LA DU DEMANDE N°";	
																	    		}
							    		
							    		                       //FIN GESTION DES PROCEDURES DERROGATOIRES
			 	    			
			return action;
		 }
		 
		 public String redirectionDynamicCom(String comType) {
			return comType;
		 }

	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLibelle1() {
		return libelle1;
	}
	public void setLibelle1(String libelle1) {
		this.libelle1 = libelle1;
	}
	public boolean isPanelForm() {
		return panelForm;
	}
	public void setPanelForm(boolean panelForm) {
		this.panelForm = panelForm;
	}
	public boolean isPanelTraitement() {
		return panelTraitement;
	}
	public void setPanelTraitement(boolean panelTraitement) {
		this.panelTraitement = panelTraitement;
	}
	public boolean isPanelRegister() {
		return panelRegister;
	}
	public void setPanelRegister(boolean panelRegister) {
		this.panelRegister = panelRegister;
	}
	public boolean isPanelUpdate() {
		return panelUpdate;
	}
	public void setPanelUpdate(boolean panelUpdate) {
		this.panelUpdate = panelUpdate;
	}
	public boolean isPanel1() {
		return panel1;
	}
	public void setPanel1(boolean panel1) {
		this.panel1 = panel1;
	}
	public boolean isPanel2() {
		return panel2;
	}
	public void setPanel2(boolean panel2) {
		this.panel2 = panel2;
	}
	public boolean isBtn_new() {
		return btn_new;
	}
	public void setBtn_new(boolean btn_new) {
		this.btn_new = btn_new;
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

	public boolean isPanelDetail() {
		return panelDetail;
	}

	public void setPanelDetail(boolean panelDetail) {
		this.panelDetail = panelDetail;
	}

	public boolean isBtn_traitement() {
		return btn_traitement;
	}

	public void setBtn_traitement(boolean btn_traitement) {
		this.btn_traitement = btn_traitement;
	}

	public boolean isBtn_transmission() {
		return btn_transmission;
	}

	public void setBtn_transmission(boolean btn_transmission) {
		this.btn_transmission = btn_transmission;
	}

	public boolean isLove_Ac() {
		return love_Ac;
	}

	public void setLove_Ac(boolean love_Ac) {
		this.love_Ac = love_Ac;
	}

	public boolean isLove_Cpmp() {
		return love_Cpmp;
	}

	public void setLove_Cpmp(boolean love_Cpmp) {
		this.love_Cpmp = love_Cpmp;
	}

	public boolean isLove_Dmp() {
		return love_Dmp;
	}

	public void setLove_Dmp(boolean love_Dmp) {
		this.love_Dmp = love_Dmp;
	}

	public boolean isBtn_fermerSaisie() {
		return btn_fermerSaisie;
	}

	public void setBtn_fermerSaisie(boolean btn_fermerSaisie) {
		this.btn_fermerSaisie = btn_fermerSaisie;
	}

	public boolean isBtn_fermerValidation() {
		return btn_fermerValidation;
	}

	public void setBtn_fermerValidation(boolean btn_fermerValidation) {
		this.btn_fermerValidation = btn_fermerValidation;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getBailleur() {
		return bailleur;
	}



	public void setBailleur(String bailleur) {
		this.bailleur = bailleur;
	}



	public String getAccord() {
		return accord;
	}



	public void setAccord(String accord) {
		this.accord = accord;
	}



	public String getProjet() {
		return projet;
	}



	public void setProjet(String projet) {
		this.projet = projet;
	}



	public String getOrgane() {
		return organe;
	}



	public void setOrgane(String organe) {
		this.organe = organe;
	}



	public String getActions() {
		return actions;
	}



	public void setActions(String actions) {
		this.actions = actions;
	}



	public String getMinistere() {
		return ministere;
	}



	public void setMinistere(String ministere) {
		this.ministere = ministere;
	}



	public String getAutorite() {
		return autorite;
	}



	public void setAutorite(String autorite) {
		this.autorite = autorite;
	}



	public String getLibelleProcedure() {
		return libelleProcedure;
	}



	public void setLibelleProcedure(String libelleProcedure) {
		this.libelleProcedure = libelleProcedure;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public boolean isBtn_new_pgpm() {
		return btn_new_pgpm;
	}



	public void setBtn_new_pgpm(boolean btn_new_pgpm) {
		this.btn_new_pgpm = btn_new_pgpm;
	}



	public boolean isBtn_new_pgspm() {
		return btn_new_pgspm;
	}



	public void setBtn_new_pgspm(boolean btn_new_pgspm) {
		this.btn_new_pgspm = btn_new_pgspm;
	}



	public boolean isBtn_save_pgspm() {
		return btn_save_pgspm;
	}



	public void setBtn_save_pgspm(boolean btn_save_pgspm) {
		this.btn_save_pgspm = btn_save_pgspm;
	}



	public boolean isBtn_save_pgpm() {
		return btn_save_pgpm;
	}

	public void setBtn_save_pgpm(boolean btn_save_pgpm) {
		this.btn_save_pgpm = btn_save_pgpm;
	}



	public boolean isTpgpm() {
		return tpgpm;
	}


	public void setTpgpm(boolean tpgpm) {
		this.tpgpm = tpgpm;
	}



	public boolean isTpgspm() {
		return tpgspm;
	}

	public void setTpgspm(boolean tpgspm) {
		this.tpgspm = tpgspm;
	}



	public boolean isBtn_trasmettre() {
		return btn_trasmettre;
	}
	public void setBtn_trasmettre(boolean btn_trasmettre) {
		this.btn_trasmettre = btn_trasmettre;
	}



	public boolean isBtn_valider_cpmp() {
		return btn_valider_cpmp;
	}



	public void setBtn_valider_cpmp(boolean btn_valider_cpmp) {
		this.btn_valider_cpmp = btn_valider_cpmp;
	}

	public boolean isBtn_valider_dmp() {
		return btn_valider_dmp;
	}



	public void setBtn_valider_dmp(boolean btn_valider_dmp) {
		this.btn_valider_dmp = btn_valider_dmp;
	}



	public boolean isBtn_fermer_saisie_pgspm() {
		return btn_fermer_saisie_pgspm;
	}



	public void setBtn_fermer_saisie_pgspm(boolean btn_fermer_saisie_pgspm) {
		this.btn_fermer_saisie_pgspm = btn_fermer_saisie_pgspm;
	}



	public boolean isBtn_fermer_saisie_pgpm() {
		return btn_fermer_saisie_pgpm;
	}



	public void setBtn_fermer_saisie_pgpm(boolean btn_fermer_saisie_pgpm) {
		this.btn_fermer_saisie_pgpm = btn_fermer_saisie_pgpm;
	}


	public boolean isFermerSai() {
		return fermerSai;
	}


	public void setFermerSai(boolean fermerSai) {
		this.fermerSai = fermerSai;
	}


	public boolean isFermerVal() {
		return fermerVal;
	}


	public void setFermerVal(boolean fermerVal) {
		this.fermerVal = fermerVal;
	}



	public boolean isPanelPgpm() {
		return panelPgpm;
	}

	public void setPanelPgpm(boolean panelPgpm) {
		this.panelPgpm = panelPgpm;
	}



	public boolean isPanelPgspm() {
		return panelPgspm;
	}
	public void setPanelPgspm(boolean panelPgspm) {
		this.panelPgspm = panelPgspm;
	}



	public boolean isPanelPpm() {
		return panelPpm;
	}

	public void setPanelPpm(boolean panelPpm) {
		this.panelPpm = panelPpm;
	}



	public boolean isPanelPspm() {
		return panelPspm;
	}

	public void setPanelPspm(boolean panelPspm) {
		this.panelPspm = panelPspm;
	}



	public boolean isBtn_fermer_saisie_ppm() {
		return btn_fermer_saisie_ppm;
	}

	public void setBtn_fermer_saisie_ppm(boolean btn_fermer_saisie_ppm) {
		this.btn_fermer_saisie_ppm = btn_fermer_saisie_ppm;
	}



	public boolean isBtn_fermer_saisie_pspm() {
		return btn_fermer_saisie_pspm;
	}

	public void setBtn_fermer_saisie_pspm(boolean btn_fermer_saisie_pspm) {
		this.btn_fermer_saisie_pspm = btn_fermer_saisie_pspm;
	}



	public boolean isBtn_new_ppm() {
		return btn_new_ppm;
	}

	public void setBtn_new_ppm(boolean btn_new_ppm) {
		this.btn_new_ppm = btn_new_ppm;
	}



	public boolean isBtn_new_pspm() {
		return btn_new_pspm;
	}



	public void setBtn_new_pspm(boolean btn_new_pspm) {
		this.btn_new_pspm = btn_new_pspm;
	}



	public boolean isBtn_save_pspm() {
		return btn_save_pspm;
	}

	public void setBtn_save_pspm(boolean btn_save_pspm) {
		this.btn_save_pspm = btn_save_pspm;
	}



	public boolean isBtn_save_ppm() {
		return btn_save_ppm;
	}
	public void setBtn_save_ppm(boolean btn_save_ppm) {
		this.btn_save_ppm = btn_save_ppm;
	}



	public boolean isPanelPgpmTableauBordSai() {
		return panelPgpmTableauBordSai;
	}



	public void setPanelPgpmTableauBordSai(boolean panelPgpmTableauBordSai) {
		this.panelPgpmTableauBordSai = panelPgpmTableauBordSai;
	}



	public boolean isPanelPgpmTableauBordVal() {
		return panelPgpmTableauBordVal;
	}



	public void setPanelPgpmTableauBordVal(boolean panelPgpmTableauBordVal) {
		this.panelPgpmTableauBordVal = panelPgpmTableauBordVal;
	}



	public boolean isPanelPgspmTableauBordSai() {
		return panelPgspmTableauBordSai;
	}



	public void setPanelPgspmTableauBordSai(boolean panelPgspmTableauBordSai) {
		this.panelPgspmTableauBordSai = panelPgspmTableauBordSai;
	}



	public boolean isPanelPgspmTableauBordVal() {
		return panelPgspmTableauBordVal;
	}



	public void setPanelPgspmTableauBordVal(boolean panelPgspmTableauBordVal) {
		this.panelPgspmTableauBordVal = panelPgspmTableauBordVal;
	}



	public boolean isPanelPpmTableauBordSai() {
		return panelPpmTableauBordSai;
	}



	public void setPanelPpmTableauBordSai(boolean panelPpmTableauBordSai) {
		this.panelPpmTableauBordSai = panelPpmTableauBordSai;
	}



	public boolean isPanelPpmTableauBordVal() {
		return panelPpmTableauBordVal;
	}



	public void setPanelPpmTableauBordVal(boolean panelPpmTableauBordVal) {
		this.panelPpmTableauBordVal = panelPpmTableauBordVal;
	}



	public boolean isPanelPspmTableauBordSai() {
		return panelPspmTableauBordSai;
	}



	public void setPanelPspmTableauBordSai(boolean panelPspmTableauBordSai) {
		this.panelPspmTableauBordSai = panelPspmTableauBordSai;
	}



	public boolean isPanelPspmTableauBordVal() {
		return panelPspmTableauBordVal;
	}



	public void setPanelPspmTableauBordVal(boolean panelPspmTableauBordVal) {
		this.panelPspmTableauBordVal = panelPspmTableauBordVal;
	}



	public boolean isSelectOneMenuProcedure() {
		return selectOneMenuProcedure;
	}

	public void setSelectOneMenuProcedure(boolean selectOneMenuProcedure) {
		this.selectOneMenuProcedure = selectOneMenuProcedure;
	}



	public boolean isBtn_creerDetailPspm() {
		return btn_creerDetailPspm;
	}

	public void setBtn_creerDetailPspm(boolean btn_creerDetailPspm) {
		this.btn_creerDetailPspm = btn_creerDetailPspm;
	}



	public boolean isBtn_creerDetailPpm() {
		return btn_creerDetailPpm;
	}

	public void setBtn_creerDetailPpm(boolean btn_creerDetailPpm) {
		this.btn_creerDetailPpm = btn_creerDetailPpm;
	}



	public boolean isBtn_creerDetailPpmCmp() {
		return btn_creerDetailPpmCmp;
	}



	public void setBtn_creerDetailPpmCmp(boolean btn_creerDetailPpmCmp) {
		this.btn_creerDetailPpmCmp = btn_creerDetailPpmCmp;
	}



	public boolean isBtn_creerDetailPspmCmp() {
		return btn_creerDetailPspmCmp;
	}


	public void setBtn_creerDetailPspmCmp(boolean btn_creerDetailPspmCmp) {
		this.btn_creerDetailPspmCmp = btn_creerDetailPspmCmp;
	}



	public boolean isBtn_creerDetailPpmDmp() {
		return btn_creerDetailPpmDmp;
	}

	public void setBtn_creerDetailPpmDmp(boolean btn_creerDetailPpmDmp) {
		this.btn_creerDetailPpmDmp = btn_creerDetailPpmDmp;
	}



	public boolean isBtn_creerDetailPspmDmp() {
		return btn_creerDetailPspmDmp;
	}

	public void setBtn_creerDetailPspmDmp(boolean btn_creerDetailPspmDmp) {
		this.btn_creerDetailPspmDmp = btn_creerDetailPspmDmp;
	}
	
	public boolean isDetailP1() {
		return detailP1;
	}

	public void setDetailP1(boolean detailP1) {
		this.detailP1 = detailP1;
	}


	public boolean isDetailP2() {
		return detailP2;
	}

	public void setDetailP2(boolean detailP2) {
		this.detailP2 = detailP2;
	}



	public boolean isDetailPg1() {
		return detailPg1;
	}

	public void setDetailPg1(boolean detailPg1) {
		this.detailPg1 = detailPg1;
	}



	public boolean isDetailPg2() {
		return detailPg2;
	}

	public void setDetailPg2(boolean detailPg2) {
		this.detailPg2 = detailPg2;
	}



	public boolean isFermerSaiPspm() {
		return fermerSaiPspm;
	}

	public void setFermerSaiPspm(boolean fermerSaiPspm) {
		this.fermerSaiPspm = fermerSaiPspm;
	}



	public boolean isFermerValPspm() {
		return fermerValPspm;
	}



	public void setFermerValPspm(boolean fermerValPspm) {
		this.fermerValPspm = fermerValPspm;
	}



	public boolean isBtn_edit_pgpm() {
		return btn_edit_pgpm;
	}


	public void setBtn_edit_pgpm(boolean btn_edit_pgpm) {
		this.btn_edit_pgpm = btn_edit_pgpm;
	}



	public boolean isBtn_edit_pgspm() {
		return btn_edit_pgspm;
	}

	public void setBtn_edit_pgspm(boolean btn_edit_pgspm) {
		this.btn_edit_pgspm = btn_edit_pgspm;
	}



	public boolean isBtn_trans_pgpm() {
		return btn_trans_pgpm;
	}

	public void setBtn_trans_pgpm(boolean btn_trans_pgpm) {
		this.btn_trans_pgpm = btn_trans_pgpm;
	}



	public boolean isBtn_trans_pgspm() {
		return btn_trans_pgspm;
	}

	public void setBtn_trans_pgspm(boolean btn_trans_pgspm) {
		this.btn_trans_pgspm = btn_trans_pgspm;
	}



	public boolean isBtn_valider_pgspm_cpmp() {
		return btn_valider_pgspm_cpmp;
	}



	public void setBtn_valider_pgspm_cpmp(boolean btn_valider_pgspm_cpmp) {
		this.btn_valider_pgspm_cpmp = btn_valider_pgspm_cpmp;
	}



	public boolean isBtn_valider_pgspm_dmp() {
		return btn_valider_pgspm_dmp;
	}

	public void setBtn_valider_pgspm_dmp(boolean btn_valider_pgspm_dmp) {
		this.btn_valider_pgspm_dmp = btn_valider_pgspm_dmp;
	}



	public boolean isBtn_trans_ppm() {
		return btn_trans_ppm;
	}

	public void setBtn_trans_ppm(boolean btn_trans_ppm) {
		this.btn_trans_ppm = btn_trans_ppm;
	}



	public boolean isBtn_trans_pspm() {
		return btn_trans_pspm;
	}

	public void setBtn_trans_pspm(boolean btn_trans_pspm) {
		this.btn_trans_pspm = btn_trans_pspm;
	}



	public boolean isBtn_valider_pspm_cpmp() {
		return btn_valider_pspm_cpmp;
	}

	public void setBtn_valider_pspm_cpmp(boolean btn_valider_pspm_cpmp) {
		this.btn_valider_pspm_cpmp = btn_valider_pspm_cpmp;
	}



	public boolean isBtn_valider_pspm_dmp() {
		return btn_valider_pspm_dmp;
	}

	public void setBtn_valider_pspm_dmp(boolean btn_valider_pspm_dmp) {
		this.btn_valider_pspm_dmp = btn_valider_pspm_dmp;
	}



	public boolean isBtn_valider_ppm_cpmp() {
		return btn_valider_ppm_cpmp;
	}

	public void setBtn_valider_ppm_cpmp(boolean btn_valider_ppm_cpmp) {
		this.btn_valider_ppm_cpmp = btn_valider_ppm_cpmp;
	}



	public boolean isBtn_valider_ppm_dmp() {
		return btn_valider_ppm_dmp;
	}

	public void setBtn_valider_ppm_dmp(boolean btn_valider_ppm_dmp) {
		this.btn_valider_ppm_dmp = btn_valider_ppm_dmp;
	}



	public String getLibellePgpm() {
		return libellePgpm;
	}

	public void setLibellePgpm(String libellePgpm) {
		this.libellePgpm = libellePgpm;
	}



	public boolean isBtn_trasmettre_pgspm() {
		return btn_trasmettre_pgspm;
	}



	public void setBtn_trasmettre_pgspm(boolean btn_trasmettre_pgspm) {
		this.btn_trasmettre_pgspm = btn_trasmettre_pgspm;
	}



	public boolean isBtn_differerPgspm_cpdmp() {
		return btn_differerPgspm_cpdmp;
	}



	public void setBtn_differerPgspm_cpdmp(boolean btn_differerPgspm_cpdmp) {
		this.btn_differerPgspm_cpdmp = btn_differerPgspm_cpdmp;
	}



	public boolean isPanelAgpmTableauBordSai() {
		return panelAgpmTableauBordSai;
	}



	public void setPanelAgpmTableauBordSai(boolean panelAgpmTableauBordSai) {
		this.panelAgpmTableauBordSai = panelAgpmTableauBordSai;
	}



	public boolean isPanelAgpmTableauBordVal() {
		return panelAgpmTableauBordVal;
	}



	public void setPanelAgpmTableauBordVal(boolean panelAgpmTableauBordVal) {
		this.panelAgpmTableauBordVal = panelAgpmTableauBordVal;
	}



	public boolean isPanelAmiTableauBordSai() {
		return panelAmiTableauBordSai;
	}



	public void setPanelAmiTableauBordSai(boolean panelAmiTableauBordSai) {
		this.panelAmiTableauBordSai = panelAmiTableauBordSai;
	}



	public boolean isPanelAmiTableauBordVal() {
		return panelAmiTableauBordVal;
	}



	public void setPanelAmiTableauBordVal(boolean panelAmiTableauBordVal) {
		this.panelAmiTableauBordVal = panelAmiTableauBordVal;
	}



	public boolean isBtn_valider_ami_cpmp() {
		return btn_valider_ami_cpmp;
	}



	public void setBtn_valider_ami_cpmp(boolean btn_valider_ami_cpmp) {
		this.btn_valider_ami_cpmp = btn_valider_ami_cpmp;
	}



	public boolean isBtn_valider_ami_dmp() {
		return btn_valider_ami_dmp;
	}



	public void setBtn_valider_ami_dmp(boolean btn_valider_ami_dmp) {
		this.btn_valider_ami_dmp = btn_valider_ami_dmp;
	}



	public boolean isBtn_fermer_saisie_ami() {
		return btn_fermer_saisie_ami;
	}



	public void setBtn_fermer_saisie_ami(boolean btn_fermer_saisie_ami) {
		this.btn_fermer_saisie_ami = btn_fermer_saisie_ami;
	}



	public boolean isPanelAmi() {
		return panelAmi;
	}



	public void setPanelAmi(boolean panelAmi) {
		this.panelAmi = panelAmi;
	}



	public boolean isBtn_creerDetailAmiCmp() {
		return btn_creerDetailAmiCmp;
	}



	public void setBtn_creerDetailAmiCmp(boolean btn_creerDetailAmiCmp) {
		this.btn_creerDetailAmiCmp = btn_creerDetailAmiCmp;
	}



	public boolean isBtn_creerDetailAmiDmp() {
		return btn_creerDetailAmiDmp;
	}



	public void setBtn_creerDetailAmiDmp(boolean btn_creerDetailAmiDmp) {
		this.btn_creerDetailAmiDmp = btn_creerDetailAmiDmp;
	}



	public boolean isPanelA() {
		return panelA;
	}



	public void setPanelA(boolean panelA) {
		this.panelA = panelA;
	}



	public boolean isPanelDaoTableauBordVal() {
		return panelDaoTableauBordVal;
	}



	public void setPanelDaoTableauBordVal(boolean panelDaoTableauBordVal) {
		this.panelDaoTableauBordVal = panelDaoTableauBordVal;
	}



	public boolean isBtn_valider_dao_cpmp() {
		return btn_valider_dao_cpmp;
	}



	public void setBtn_valider_dao_cpmp(boolean btn_valider_dao_cpmp) {
		this.btn_valider_dao_cpmp = btn_valider_dao_cpmp;
	}



	public boolean isBtn_fermer_saisie_dao() {
		return btn_fermer_saisie_dao;
	}



	public void setBtn_fermer_saisie_dao(boolean btn_fermer_saisie_dao) {
		this.btn_fermer_saisie_dao = btn_fermer_saisie_dao;
	}



	public boolean isBtn_valider_dao_dmp() {
		return btn_valider_dao_dmp;
	}



	public void setBtn_valider_dao_dmp(boolean btn_valider_dao_dmp) {
		this.btn_valider_dao_dmp = btn_valider_dao_dmp;
	}



	public boolean isPanelD() {
		return panelD;
	}



	public void setPanelD(boolean panelD) {
		this.panelD = panelD;
	}



	public boolean isBtn_creerDetailDaoCmp() {
		return btn_creerDetailDaoCmp;
	}



	public void setBtn_creerDetailDaoCmp(boolean btn_creerDetailDaoCmp) {
		this.btn_creerDetailDaoCmp = btn_creerDetailDaoCmp;
	}



	public boolean isBtn_creerDetailDaoDmp() {
		return btn_creerDetailDaoDmp;
	}



	public void setBtn_creerDetailDaoDmp(boolean btn_creerDetailDaoDmp) {
		this.btn_creerDetailDaoDmp = btn_creerDetailDaoDmp;
	}



	public boolean isPanelDao() {
		return panelDao;
	}



	public void setPanelDao(boolean panelDao) {
		this.panelDao = panelDao;
	}



	public boolean isPanelDaoTableauBordSai() {
		return panelDaoTableauBordSai;
	}



	public void setPanelDaoTableauBordSai(boolean panelDaoTableauBordSai) {
		this.panelDaoTableauBordSai = panelDaoTableauBordSai;
	}



	public boolean isPanelPrqTableauBordSai() {
		return panelPrqTableauBordSai;
	}



	public void setPanelPrqTableauBordSai(boolean panelPrqTableauBordSai) {
		this.panelPrqTableauBordSai = panelPrqTableauBordSai;
	}



	public boolean isPanelPrqTableauBordVal() {
		return panelPrqTableauBordVal;
	}



	public void setPanelPrqTableauBordVal(boolean panelPrqTableauBordVal) {
		this.panelPrqTableauBordVal = panelPrqTableauBordVal;
	}



	public boolean isBtn_valider_prq_cpmp() {
		return btn_valider_prq_cpmp;
	}



	public void setBtn_valider_prq_cpmp(boolean btn_valider_prq_cpmp) {
		this.btn_valider_prq_cpmp = btn_valider_prq_cpmp;
	}



	public boolean isBtn_valider_prq_dmp() {
		return btn_valider_prq_dmp;
	}



	public void setBtn_valider_prq_dmp(boolean btn_valider_prq_dmp) {
		this.btn_valider_prq_dmp = btn_valider_prq_dmp;
	}



	public boolean isBtn_fermer_saisie_prq() {
		return btn_fermer_saisie_prq;
	}



	public void setBtn_fermer_saisie_prq(boolean btn_fermer_saisie_prq) {
		this.btn_fermer_saisie_prq = btn_fermer_saisie_prq;
	}



	public boolean isPanelP() {
		return panelP;
	}



	public void setPanelP(boolean panelP) {
		this.panelP = panelP;
	}



	public boolean isPanelPrq() {
		return panelPrq;
	}



	public void setPanelPrq(boolean panelPrq) {
		this.panelPrq = panelPrq;
	}



	public boolean isBtn_creerDetailPrqCmp() {
		return btn_creerDetailPrqCmp;
	}



	public void setBtn_creerDetailPrqCmp(boolean btn_creerDetailPrqCmp) {
		this.btn_creerDetailPrqCmp = btn_creerDetailPrqCmp;
	}



	public boolean isBtn_creerDetailPrqDmp() {
		return btn_creerDetailPrqDmp;
	}



	public void setBtn_creerDetailPrqDmp(boolean btn_creerDetailPrqDmp) {
		this.btn_creerDetailPrqDmp = btn_creerDetailPrqDmp;
	}



	public String getLibelleValPrq() {
		return libelleValPrq;
	}



	public void setLibelleValPrq(String libelleValPrq) {
		this.libelleValPrq = libelleValPrq;
	}



	public String getLibelleValami() {
		return libelleValami;
	}



	public void setLibelleValami(String libelleValami) {
		this.libelleValami = libelleValami;
	}



	public String getLibelleami() {
		return libelleami;
	}



	public void setLibelleami(String libelleami) {
		this.libelleami = libelleami;
	}



	public String getLibelleAmi1() {
		return libelleAmi1;
	}



	public void setLibelleAmi1(String libelleAmi1) {
		this.libelleAmi1 = libelleAmi1;
	}



	public String getLibelleValP() {
		return libelleValP;
	}



	public void setLibelleValP(String libelleValP) {
		this.libelleValP = libelleValP;
	}



	public String getLibelle2() {
		return libelle2;
	}



	public void setLibelle2(String libelle2) {
		this.libelle2 = libelle2;
	}



	public String getLibelleAmi() {
		return libelleAmi;
	}



	public void setLibelleAmi(String libelleAmi) {
		this.libelleAmi = libelleAmi;
	}



	public String getLibelleA() {
		return libelleA;
	}



	public void setLibelleA(String libelleA) {
		this.libelleA = libelleA;
	}



	public boolean isBtn_creerDetailAmi() {
		return btn_creerDetailAmi;
	}



	public void setBtn_creerDetailAmi(boolean btn_creerDetailAmi) {
		this.btn_creerDetailAmi = btn_creerDetailAmi;
	}



	public boolean isBtn_creerDetailDao() {
		return btn_creerDetailDao;
	}



	public void setBtn_creerDetailDao(boolean btn_creerDetailDao) {
		this.btn_creerDetailDao = btn_creerDetailDao;
	}



	public boolean isBtn_creerDetailPrq() {
		return btn_creerDetailPrq;
	}



	public void setBtn_creerDetailPrq(boolean btn_creerDetailPrq) {
		this.btn_creerDetailPrq = btn_creerDetailPrq;
	}



	public boolean isDetailA() {
		return detailA;
	}



	public void setDetailA(boolean detailA) {
		this.detailA = detailA;
	}



	public boolean isDetailD() {
		return detailD;
	}



	public void setDetailD(boolean detailD) {
		this.detailD = detailD;
	}



	public boolean isDetailP() {
		return detailP;
	}



	public void setDetailP(boolean detailP) {
		this.detailP = detailP;
	}



	public String getLibelleValAmi() {
		return libelleValAmi;
	}



	public void setLibelleValAmi(String libelleValAmi) {
		this.libelleValAmi = libelleValAmi;
	}



	public String getLibelleDao1() {
		return libelleDao1;
	}



	public void setLibelleDao1(String libelleDao1) {
		this.libelleDao1 = libelleDao1;
	}



	public String getLibelleDao2() {
		return libelleDao2;
	}



	public void setLibelleDao2(String libelleDao2) {
		this.libelleDao2 = libelleDao2;
	}



	public String getLibelleDao4() {
		return libelleDao4;
	}



	public void setLibelleDao4(String libelleDao4) {
		this.libelleDao4 = libelleDao4;
	}



	public String getLibelleDao3() {
		return libelleDao3;
	}



	public void setLibelleDao3(String libelleDao3) {
		this.libelleDao3 = libelleDao3;
	}



	public String getLibelleP() {
		return libelleP;
	}



	public void setLibelleP(String libelleP) {
		this.libelleP = libelleP;
	}



	public boolean isFermerSaiAmi() {
		return fermerSaiAmi;
	}



	public void setFermerSaiAmi(boolean fermerSaiAmi) {
		this.fermerSaiAmi = fermerSaiAmi;
	}



	public boolean isFermerValAmi() {
		return fermerValAmi;
	}



	public void setFermerValAmi(boolean fermerValAmi) {
		this.fermerValAmi = fermerValAmi;
	}



	public boolean isBtn_trans_ami() {
		return btn_trans_ami;
	}



	public void setBtn_trans_ami(boolean btn_trans_ami) {
		this.btn_trans_ami = btn_trans_ami;
	}



	public boolean isFermerSaiDao() {
		return fermerSaiDao;
	}



	public void setFermerSaiDao(boolean fermerSaiDao) {
		this.fermerSaiDao = fermerSaiDao;
	}



	public boolean isFermerValDao() {
		return fermerValDao;
	}



	public void setFermerValDao(boolean fermerValDao) {
		this.fermerValDao = fermerValDao;
	}



	public boolean isBtn_trans_dao() {
		return btn_trans_dao;
	}



	public void setBtn_trans_dao(boolean btn_trans_dao) {
		this.btn_trans_dao = btn_trans_dao;
	}



	public boolean isFermerSaiPrq() {
		return fermerSaiPrq;
	}



	public void setFermerSaiPrq(boolean fermerSaiPrq) {
		this.fermerSaiPrq = fermerSaiPrq;
	}



	public boolean isFermerValPrq() {
		return fermerValPrq;
	}



	public void setFermerValPrq(boolean fermerValPrq) {
		this.fermerValPrq = fermerValPrq;
	}



	public boolean isBtn_trans_prq() {
		return btn_trans_prq;
	}



	public void setBtn_trans_prq(boolean btn_trans_prq) {
		this.btn_trans_prq = btn_trans_prq;
	}



	public String getLibellePrq1() {
		return libellePrq1;
	}



	public void setLibellePrq1(String libellePrq1) {
		this.libellePrq1 = libellePrq1;
	}



	public String getLibellePrq2() {
		return libellePrq2;
	}



	public void setLibellePrq2(String libellePrq2) {
		this.libellePrq2 = libellePrq2;
	}



	public String getLibellePrq3() {
		return libellePrq3;
	}



	public void setLibellePrq3(String libellePrq3) {
		this.libellePrq3 = libellePrq3;
	}



	public String getLibellesmall() {
		return libellesmall;
	}



	public void setLibellesmall(String libellesmall) {
		this.libellesmall = libellesmall;
	}



	public boolean isNbrepgpm() {
		return nbrepgpm;
	}



	public void setNbrepgpm(boolean nbrepgpm) {
		this.nbrepgpm = nbrepgpm;
	}



	public boolean isNbrepgspm() {
		return nbrepgspm;
	}



	public void setNbrepgspm(boolean nbrepgspm) {
		this.nbrepgspm = nbrepgspm;
	}



	public boolean isNbreppm() {
		return nbreppm;
	}



	public void setNbreppm(boolean nbreppm) {
		this.nbreppm = nbreppm;
	}



	public boolean isNbrepspm() {
		return nbrepspm;
	}



	public void setNbrepspm(boolean nbrepspm) {
		this.nbrepspm = nbrepspm;
	}



	public boolean isValidDMP() {
		return validDMP;
	}



	public void setValidDMP(boolean validDMP) {
		this.validDMP = validDMP;
	}



	public boolean isValidCPMP() {
		return validCPMP;
	}

	public void setValidCPMP(boolean validCPMP) {
		this.validCPMP = validCPMP;
	}
	
	public boolean isEtatPsl() {
		return etatPsl;
	}

	public void setEtatPsl(boolean etatPsl) {
		this.etatPsl = etatPsl;
	}

	public boolean isEtatPso() {
		return etatPso;
	}

	public void setEtatPso(boolean etatPso) {
		this.etatPso = etatPso;
	}



	public boolean isAffDao() {
		return affDao;
	}

	public void setAffDao(boolean affDao) {
		this.affDao = affDao;
	}



	public boolean isExaDao() {
		return exaDao;
	}

	public void setExaDao(boolean exaDao) {
		this.exaDao = exaDao;
	}



	public boolean isPanel3() {
		return panel3;
	}



	public void setPanel3(boolean panel3) {
		this.panel3 = panel3;
	}



	public boolean isPanelDaoTableauBordAff() {
		return panelDaoTableauBordAff;
	}



	public void setPanelDaoTableauBordAff(boolean panelDaoTableauBordAff) {
		this.panelDaoTableauBordAff = panelDaoTableauBordAff;
	}



	public boolean isBtn_affec() {
		return btn_affec;
	}



	public void setBtn_affec(boolean btn_affec) {
		this.btn_affec = btn_affec;
	}



	public boolean isPanelDaoTableauBordExa() {
		return panelDaoTableauBordExa;
	}



	public void setPanelDaoTableauBordExa(boolean panelDaoTableauBordExa) {
		this.panelDaoTableauBordExa = panelDaoTableauBordExa;
	}



	public boolean isPanel4() {
		return panel4;
	}



	public void setPanel4(boolean panel4) {
		this.panel4 = panel4;
	}



	public boolean isBtn_exam() {
		return btn_exam;
	}



	public void setBtn_exam(boolean btn_exam) {
		this.btn_exam = btn_exam;
	}



	public boolean isPanelDaoTableauBordRet() {
		return panelDaoTableauBordRet;
	}



	public void setPanelDaoTableauBordRet(boolean panelDaoTableauBordRet) {
		this.panelDaoTableauBordRet = panelDaoTableauBordRet;
	}



	public boolean isRetDao() {
		return retDao;
	}



	public void setRetDao(boolean retDao) {
		this.retDao = retDao;
	}



	public boolean isBtn_retrait() {
		return btn_retrait;
	}



	public void setBtn_retrait(boolean btn_retrait) {
		this.btn_retrait = btn_retrait;
	}



	public boolean isPanel5() {
		return panel5;
	}



	public void setPanel5(boolean panel5) {
		this.panel5 = panel5;
	}



	public boolean isBtn_valid() {
		return btn_valid;
	}



	public void setBtn_valid(boolean btn_valid) {
		this.btn_valid = btn_valid;
	}



	public boolean isPanel6() {
		return panel6;
	}

	public void setPanel6(boolean panel6) {
		this.panel6 = panel6;
	}



	public boolean isPanelDaoTableauBordCha() {
		return panelDaoTableauBordCha;
	}

	public void setPanelDaoTableauBordCha(boolean panelDaoTableauBordCha) {
		this.panelDaoTableauBordCha = panelDaoTableauBordCha;
	}



	public boolean isBtn_maj_datePpm() {
		return btn_maj_datePpm;
	}

	public void setBtn_maj_datePpm(boolean btn_maj_datePpm) {
		this.btn_maj_datePpm = btn_maj_datePpm;
	}



	public boolean isBtn_maj_datePspm() {
		return btn_maj_datePspm;
	}

	public void setBtn_maj_datePspm(boolean btn_maj_datePspm) {
		this.btn_maj_datePspm = btn_maj_datePspm;
	}


	public boolean isPanel7() {
		return panel7;
	}

	public void setPanel7(boolean panel7) {
		this.panel7 = panel7;
	}



	public boolean isPanel8() {
		return panel8;
	}
	public void setPanel8(boolean panel8) {
		this.panel8 = panel8;
	}



	public boolean isPanelDaoTableauBordPub() {
		return panelDaoTableauBordPub;
	}



	public void setPanelDaoTableauBordPub(boolean panelDaoTableauBordPub) {
		this.panelDaoTableauBordPub = panelDaoTableauBordPub;
	}



	public boolean isPanelOuverture() {
		return panelOuverture;
	}



	public void setPanelOuverture(boolean panelOuverture) {
		this.panelOuverture = panelOuverture;
	}



	public boolean isPanelAnalyse() {
		return panelAnalyse;
	}



	public void setPanelAnalyse(boolean panelAnalyse) {
		this.panelAnalyse = panelAnalyse;
	}



	public boolean isPanelJugement() {
		return panelJugement;
	}



	public void setPanelJugement(boolean panelJugement) {
		this.panelJugement = panelJugement;
	}


	public String getActionPage() {
		return actionPage;
	}


	public void setActionPage(String actionPage) {
		this.actionPage = actionPage;
	}


	public String getFonctionalite() {
		return fonctionalite;
	}


	public void setFonctionalite(String fonctionalite) {
		this.fonctionalite = fonctionalite;
	}


	public boolean isBtn_retourner() {
		return btn_retourner;
	}


	public void setBtn_retourner(boolean btn_retourner) {
		this.btn_retourner = btn_retourner;
	}


	public boolean isBtn_fermerOuverture() {
		return btn_fermerOuverture;
	}


	public void setBtn_fermerOuverture(boolean btn_fermerOuverture) {
		this.btn_fermerOuverture = btn_fermerOuverture;
	}


	public boolean isBtn_fermerAnalyse() {
		return btn_fermerAnalyse;
	}


	public void setBtn_fermerAnalyse(boolean btn_fermerAnalyse) {
		this.btn_fermerAnalyse = btn_fermerAnalyse;
	}


	public boolean isBtn_fermerJugement() {
		return btn_fermerJugement;
	}


	public void setBtn_fermerJugement(boolean btn_fermerJugement) {
		this.btn_fermerJugement = btn_fermerJugement;
	}


	public boolean isBtn_membre() {
		return btn_membre;
	}


	public void setBtn_membre(boolean btn_membre) {
		this.btn_membre = btn_membre;
	}


	public boolean isBtn_apercuOuv() {
		return btn_apercuOuv;
	}


	public void setBtn_apercuOuv(boolean btn_apercuOuv) {
		this.btn_apercuOuv = btn_apercuOuv;
	}


	public boolean isBtn_apercuAna() {
		return btn_apercuAna;
	}


	public void setBtn_apercuAna(boolean btn_apercuAna) {
		this.btn_apercuAna = btn_apercuAna;
	}


	public boolean isBtn_apercuJug() {
		return btn_apercuJug;
	}


	public void setBtn_apercuJug(boolean btn_apercuJug) {
		this.btn_apercuJug = btn_apercuJug;
	}


	public String getLibelleFinCom() {
		return libelleFinCom;
	}


	public void setLibelleFinCom(String libelleFinCom) {
		this.libelleFinCom = libelleFinCom;
	}


	public String getLibelleConfirm() {
		return libelleConfirm;
	}


	public void setLibelleConfirm(String libelleConfirm) {
		this.libelleConfirm = libelleConfirm;
	}


	public boolean isPanel9() {
		return panel9;
	}


	public void setPanel9(boolean panel9) {
		this.panel9 = panel9;
	}


	public boolean isPanel10() {
		return panel10;
	}


	public void setPanel10(boolean panel10) {
		this.panel10 = panel10;
	}


	public boolean isPanelDaoTableauBordVet() {
		return panelDaoTableauBordVet;
	}


	public void setPanelDaoTableauBordVet(boolean panelDaoTableauBordVet) {
		this.panelDaoTableauBordVet = panelDaoTableauBordVet;
	}


	public boolean isPanelDaoTableauBordPslpso() {
		return panelDaoTableauBordPslpso;
	}


	public void setPanelDaoTableauBordPslpso(boolean panelDaoTableauBordPslpso) {
		this.panelDaoTableauBordPslpso = panelDaoTableauBordPslpso;
	}


	public boolean isPspmModePs() {
		return pspmModePs;
	}


	public void setPspmModePs(boolean pspmModePs) {
		this.pspmModePs = pspmModePs;
	}


	public boolean isPpmModePn() {
		return ppmModePn;
	}


	public void setPpmModePn(boolean ppmModePn) {
		this.ppmModePn = ppmModePn;
	}


	public boolean isPanelAgpmTableauBordValDmp() {
		return panelAgpmTableauBordValDmp;
	}


	public void setPanelAgpmTableauBordValDmp(boolean panelAgpmTableauBordValDmp) {
		this.panelAgpmTableauBordValDmp = panelAgpmTableauBordValDmp;
	}


	public boolean isPanelAgpmTableauBordSaiDmp() {
		return panelAgpmTableauBordSaiDmp;
	}


	public void setPanelAgpmTableauBordSaiDmp(boolean panelAgpmTableauBordSaiDmp) {
		this.panelAgpmTableauBordSaiDmp = panelAgpmTableauBordSaiDmp;
	}


	public boolean isBtn_dao_pn() {
		return btn_dao_pn;
	}


	public void setBtn_dao_pn(boolean btn_dao_pn) {
		this.btn_dao_pn = btn_dao_pn;
	}


	public boolean isBtn_dao_ps() {
		return btn_dao_ps;
	}


	public void setBtn_dao_ps(boolean btn_dao_ps) {
		this.btn_dao_ps = btn_dao_ps;
	}


	public boolean isSearchPgpm() {
		return searchPgpm;
	}


	public void setSearchPgpm(boolean searchPgpm) {
		this.searchPgpm = searchPgpm;
	}


	public boolean isSearchPgspm() {
		return searchPgspm;
	}


	public void setSearchPgspm(boolean searchPgspm) {
		this.searchPgspm = searchPgspm;
	}


	public boolean isSearchAcPs() {
		return searchAcPs;
	}


	public void setSearchAcPs(boolean searchAcPs) {
		this.searchAcPs = searchAcPs;
	}


	public boolean isSearchCpmpPs() {
		return searchCpmpPs;
	}


	public void setSearchCpmpPs(boolean searchCpmpPs) {
		this.searchCpmpPs = searchCpmpPs;
	}


	public boolean isSearchDmpPs() {
		return searchDmpPs;
	}


	public void setSearchDmpPs(boolean searchDmpPs) {
		this.searchDmpPs = searchDmpPs;
	}


	public boolean isSelectLoveModePgpm() {
		return selectLoveModePgpm;
	}


	public void setSelectLoveModePgpm(boolean selectLoveModePgpm) {
		this.selectLoveModePgpm = selectLoveModePgpm;
	}


	public boolean isSelectLoveModePgspm() {
		return selectLoveModePgspm;
	}


	public void setSelectLoveModePgspm(boolean selectLoveModePgspm) {
		this.selectLoveModePgspm = selectLoveModePgspm;
	}


	public boolean isSearchAC() {
		return searchAC;
	}


	public void setSearchAC(boolean searchAC) {
		this.searchAC = searchAC;
	}


	public boolean isSearchCpmp() {
		return searchCpmp;
	}


	public void setSearchCpmp(boolean searchCpmp) {
		this.searchCpmp = searchCpmp;
	}


	public boolean isSearchDmp() {
		return searchDmp;
	}


	public void setSearchDmp(boolean searchDmp) {
		this.searchDmp = searchDmp;
	}


	public boolean isSelectOneMenuPassation() {
		return selectOneMenuPassation;
	}


	public void setSelectOneMenuPassation(boolean selectOneMenuPassation) {
		this.selectOneMenuPassation = selectOneMenuPassation;
	}


	public boolean isPanelAffectation() {
		return panelAffectation;
	}


	public void setPanelAffectation(boolean panelAffectation) {
		this.panelAffectation = panelAffectation;
	}


	public boolean isSelectLovePgpm() {
		return selectLovePgpm;
	}


	public void setSelectLovePgpm(boolean selectLovePgpm) {
		this.selectLovePgpm = selectLovePgpm;
	}


	public boolean isSelectLovePgspm() {
		return selectLovePgspm;
	}


	public void setSelectLovePgspm(boolean selectLovePgspm) {
		this.selectLovePgspm = selectLovePgspm;
	}


	public boolean isSelectPartPgpm() {
		return selectPartPgpm;
	}


	public void setSelectPartPgpm(boolean selectPartPgpm) {
		this.selectPartPgpm = selectPartPgpm;
	}


	public boolean isSelectPartPgspm() {
		return selectPartPgspm;
	}


	public void setSelectPartPgspm(boolean selectPartPgspm) {
		this.selectPartPgspm = selectPartPgspm;
	}


	public boolean isSelectTypMPgpm() {
		return selectTypMPgpm;
	}


	public void setSelectTypMPgpm(boolean selectTypMPgpm) {
		this.selectTypMPgpm = selectTypMPgpm;
	}


	public boolean isSelectTypMPgspm() {
		return selectTypMPgspm;
	}


	public void setSelectTypMPgspm(boolean selectTypMPgspm) {
		this.selectTypMPgspm = selectTypMPgspm;
	}


	public boolean isPanel11() {
		return panel11;
	}


	public void setPanel11(boolean panel11) {
		this.panel11 = panel11;
	}


	public boolean isPanel12() {
		return panel12;
	}


	public void setPanel12(boolean panel12) {
		this.panel12 = panel12;
	}


	public boolean isPanelDaoTableauBordPrise() {
		return panelDaoTableauBordPrise;
	}


	public void setPanelDaoTableauBordPrise(boolean panelDaoTableauBordPrise) {
		this.panelDaoTableauBordPrise = panelDaoTableauBordPrise;
	}


	public boolean isEtatLoveAgpm() {
		return etatLoveAgpm;
	}


	public void setEtatLoveAgpm(boolean etatLoveAgpm) {
		this.etatLoveAgpm = etatLoveAgpm;
	}


	public boolean isEtatLoveAgpmPs() {
		return etatLoveAgpmPs;
	}


	public void setEtatLoveAgpmPs(boolean etatLoveAgpmPs) {
		this.etatLoveAgpmPs = etatLoveAgpmPs;
	}


	public boolean isPanel13() {
		return panel13;
	}


	public void setPanel13(boolean panel13) {
		this.panel13 = panel13;
	}


	public boolean isFermerApercuDao() {
		return fermerApercuDao;
	}


	public void setFermerApercuDao(boolean fermerApercuDao) {
		this.fermerApercuDao = fermerApercuDao;
	}


	public boolean isFermerApercuAmi() {
		return fermerApercuAmi;
	}


	public void setFermerApercuAmi(boolean fermerApercuAmi) {
		this.fermerApercuAmi = fermerApercuAmi;
	}


	public boolean isFermerApercuPrq() {
		return fermerApercuPrq;
	}


	public void setFermerApercuPrq(boolean fermerApercuPrq) {
		this.fermerApercuPrq = fermerApercuPrq;
	}


	public boolean isVenteRecherche() {
		return venteRecherche;
	}


	public void setVenteRecherche(boolean venteRecherche) {
		this.venteRecherche = venteRecherche;
	}


	public boolean isAffectationRecherche() {
		return affectationRecherche;
	}


	public void setAffectationRecherche(boolean affectationRecherche) {
		this.affectationRecherche = affectationRecherche;
	}


	public boolean isExamenRecherche() {
		return examenRecherche;
	}


	public void setExamenRecherche(boolean examenRecherche) {
		this.examenRecherche = examenRecherche;
	}


	public boolean isPublicationRecherche() {
		return publicationRecherche;
	}


	public void setPublicationRecherche(boolean publicationRecherche) {
		this.publicationRecherche = publicationRecherche;
	}


	public boolean isSaisieRecherche() {
		return saisieRecherche;
	}


	public void setSaisieRecherche(boolean saisieRecherche) {
		this.saisieRecherche = saisieRecherche;
	}


	public boolean isCelluleRecherche() {
		return celluleRecherche;
	}


	public void setCelluleRecherche(boolean celluleRecherche) {
		this.celluleRecherche = celluleRecherche;
	}


	public boolean isValidationRecherche() {
		return validationRecherche;
	}


	public void setValidationRecherche(boolean validationRecherche) {
		this.validationRecherche = validationRecherche;
	}


	public boolean isPriseRecherche() {
		return priseRecherche;
	}


	public void setPriseRecherche(boolean priseRecherche) {
		this.priseRecherche = priseRecherche;
	}


	public boolean isChargeRecherche() {
		return chargeRecherche;
	}


	public void setChargeRecherche(boolean chargeRecherche) {
		this.chargeRecherche = chargeRecherche;
	}


	public boolean isVenteRecherchePs() {
		return venteRecherchePs;
	}


	public void setVenteRecherchePs(boolean venteRecherchePs) {
		this.venteRecherchePs = venteRecherchePs;
	}


	public boolean isAffectationRecherchePs() {
		return affectationRecherchePs;
	}


	public void setAffectationRecherchePs(boolean affectationRecherchePs) {
		this.affectationRecherchePs = affectationRecherchePs;
	}


	public boolean isExamenRecherchePs() {
		return examenRecherchePs;
	}


	public void setExamenRecherchePs(boolean examenRecherchePs) {
		this.examenRecherchePs = examenRecherchePs;
	}


	public boolean isPublicationRecherchePs() {
		return publicationRecherchePs;
	}


	public void setPublicationRecherchePs(boolean publicationRecherchePs) {
		this.publicationRecherchePs = publicationRecherchePs;
	}


	public boolean isSaisieRecherchePs() {
		return saisieRecherchePs;
	}


	public void setSaisieRecherchePs(boolean saisieRecherchePs) {
		this.saisieRecherchePs = saisieRecherchePs;
	}


	public boolean isCelluleRecherchePs() {
		return celluleRecherchePs;
	}


	public void setCelluleRecherchePs(boolean celluleRecherchePs) {
		this.celluleRecherchePs = celluleRecherchePs;
	}


	public boolean isValidationRecherchePs() {
		return validationRecherchePs;
	}


	public void setValidationRecherchePs(boolean validationRecherchePs) {
		this.validationRecherchePs = validationRecherchePs;
	}


	public boolean isPriseRecherchePs() {
		return priseRecherchePs;
	}


	public void setPriseRecherchePs(boolean priseRecherchePs) {
		this.priseRecherchePs = priseRecherchePs;
	}


	public boolean isChargeRecherchePs() {
		return chargeRecherchePs;
	}


	public void setChargeRecherchePs(boolean chargeRecherchePs) {
		this.chargeRecherchePs = chargeRecherchePs;
	}


	public String getDatevalac() {
		return datevalac;
	}


	public void setDatevalac(String datevalac) {
		this.datevalac = datevalac;
	}


	public String getDatevalcpmp() {
		return datevalcpmp;
	}


	public void setDatevalcpmp(String datevalcpmp) {
		this.datevalcpmp = datevalcpmp;
	}


	public String getLibelleSmall() {
		return libelleSmall;
	}


	public void setLibelleSmall(String libelleSmall) {
		this.libelleSmall = libelleSmall;
	}


	public boolean isBtn_imprimpgspm() {
		return btn_imprimpgspm;
	}


	public void setBtn_imprimpgspm(boolean btn_imprimpgspm) {
		this.btn_imprimpgspm = btn_imprimpgspm;
	}


	public boolean isPanelDaoTableauBordTra() {
		return panelDaoTableauBordTra;
	}


	public void setPanelDaoTableauBordTra(boolean panelDaoTableauBordTra) {
		this.panelDaoTableauBordTra = panelDaoTableauBordTra;
	}


	public boolean isEtat_prq() {
		return etat_prq;
	}


	public void setEtat_prq(boolean etat_prq) {
		this.etat_prq = etat_prq;
	}


	public boolean isEtat_dao() {
		return etat_dao;
	}


	public void setEtat_dao(boolean etat_dao) {
		this.etat_dao = etat_dao;
	}


	public boolean isEtat_ami() {
		return etat_ami;
	}


	public void setEtat_ami(boolean etat_ami) {
		this.etat_ami = etat_ami;
	}


	public boolean isUpdate_fermer_dao() {
		return update_fermer_dao;
	}


	public void setUpdate_fermer_dao(boolean update_fermer_dao) {
		this.update_fermer_dao = update_fermer_dao;
	}


	public boolean isUpdate_fermer_ami() {
		return update_fermer_ami;
	}


	public void setUpdate_fermer_ami(boolean update_fermer_ami) {
		this.update_fermer_ami = update_fermer_ami;
	}


	public boolean isUpdate_fermer_prq() {
		return update_fermer_prq;
	}


	public void setUpdate_fermer_prq(boolean update_fermer_prq) {
		this.update_fermer_prq = update_fermer_prq;
	}


	public boolean isFiltreLignePgpm() {
		return filtreLignePgpm;
	}


	public void setFiltreLignePgpm(boolean filtreLignePgpm) {
		this.filtreLignePgpm = filtreLignePgpm;
	}


	public boolean isFiltreLignePgspm() {
		return filtreLignePgspm;
	}


	public void setFiltreLignePgspm(boolean filtreLignePgspm) {
		this.filtreLignePgspm = filtreLignePgspm;
	}


	public String getLibelleTitle() {
		return libelleTitle;
	}


	public void setLibelleTitle(String libelleTitle) {
		this.libelleTitle = libelleTitle;
	}


	public boolean isUpdate_fermer_dps() {
		return update_fermer_dps;
	}


	public void setUpdate_fermer_dps(boolean update_fermer_dps) {
		this.update_fermer_dps = update_fermer_dps;
	}


	public boolean isFermerSaiPgpm() {
		return fermerSaiPgpm;
	}


	public void setFermerSaiPgpm(boolean fermerSaiPgpm) {
		this.fermerSaiPgpm = fermerSaiPgpm;
	}


	public boolean isFermerValPgpm() {
		return fermerValPgpm;
	}


	public void setFermerValPgpm(boolean fermerValPgpm) {
		this.fermerValPgpm = fermerValPgpm;
	}


	public boolean isFermerSaiPgspm() {
		return fermerSaiPgspm;
	}


	public void setFermerSaiPgspm(boolean fermerSaiPgspm) {
		this.fermerSaiPgspm = fermerSaiPgspm;
	}


	public boolean isFermerValPgspm() {
		return fermerValPgspm;
	}


	public void setFermerValPgspm(boolean fermerValPgspm) {
		this.fermerValPgspm = fermerValPgspm;
	}


	public boolean isFermerSaiPpm() {
		return fermerSaiPpm;
	}


	public void setFermerSaiPpm(boolean fermerSaiPpm) {
		this.fermerSaiPpm = fermerSaiPpm;
	}


	public boolean isFermerValPpm() {
		return fermerValPpm;
	}


	public void setFermerValPpm(boolean fermerValPpm) {
		this.fermerValPpm = fermerValPpm;
	}


	public String getOpdPiece() {
		return opdPiece;
	}


	public void setOpdPiece(String opdPiece) {
		this.opdPiece = opdPiece;
	}


	public String getTypePlan() {
		return typePlan;
	}


	public void setTypePlan(String typePlan) {
		this.typePlan = typePlan;
	}



	public boolean isBtn_ami() {
		return btn_ami;
	}


	public void setBtn_ami(boolean btn_ami) {
		this.btn_ami = btn_ami;
	}


	public boolean isBtn_prq() {
		return btn_prq;
	}


	public void setBtn_prq(boolean btn_prq) {
		this.btn_prq = btn_prq;
	}


	public boolean isBtn_daoPn() {
		return btn_daoPn;
	}


	public void setBtn_daoPn(boolean btn_daoPn) {
		this.btn_daoPn = btn_daoPn;
	}


	public boolean isBtn_daoPs() {
		return btn_daoPs;
	}


	public void setBtn_daoPs(boolean btn_daoPs) {
		this.btn_daoPs = btn_daoPs;
	}


	public boolean isBtn_fermer_saisie_daoPs() {
		return btn_fermer_saisie_daoPs;
	}


	public void setBtn_fermer_saisie_daoPs(boolean btn_fermer_saisie_daoPs) {
		this.btn_fermer_saisie_daoPs = btn_fermer_saisie_daoPs;
	}


	public boolean isBtn_pub() {
		return btn_pub;
	}


	public void setBtn_pub(boolean btn_pub) {
		this.btn_pub = btn_pub;
	}


	public boolean isSaisie() {
		return saisie;
	}


	public void setSaisie(boolean saisie) {
		this.saisie = saisie;
	}


	public boolean isPublication() {
		return publication;
	}
	public void setPublication(boolean publication) {
		this.publication = publication;
	}


	public boolean isVente() {
		return vente;
	}
	public void setVente(boolean vente) {
		this.vente = vente;
	}


	public boolean isCorrection() {
		return correction;
	}
	public void setCorrection(boolean correction) {
		this.correction = correction;
	}


	public boolean isPanelPgpmTableauBordPgPub() {
		return panelPgpmTableauBordPgPub;
	}


	public void setPanelPgpmTableauBordPgPub(boolean panelPgpmTableauBordPgPub) {
		this.panelPgpmTableauBordPgPub = panelPgpmTableauBordPgPub;
	}


	public boolean isPanelPgpmTableauBordPgsPub() {
		return panelPgpmTableauBordPgsPub;
	}
	public void setPanelPgpmTableauBordPgsPub(boolean panelPgpmTableauBordPgsPub) {
		this.panelPgpmTableauBordPgsPub = panelPgpmTableauBordPgsPub;
	}


	public boolean isPanelPgpmTableauBordPpPub() {
		return panelPgpmTableauBordPpPub;
	}
	public void setPanelPgpmTableauBordPpPub(boolean panelPgpmTableauBordPpPub) {
		this.panelPgpmTableauBordPpPub = panelPgpmTableauBordPpPub;
	}


	public boolean isPanelPgpmTableauBordPspPub() {
		return panelPgpmTableauBordPspPub;
	}

	public void setPanelPgpmTableauBordPspPub(boolean panelPgpmTableauBordPspPub) {
		this.panelPgpmTableauBordPspPub = panelPgpmTableauBordPspPub;
	}


	public boolean isBtn_publier_pgpm() {
		return btn_publier_pgpm;
	}
	public void setBtn_publier_pgpm(boolean btn_publier_pgpm) {
		this.btn_publier_pgpm = btn_publier_pgpm;
	}


	public boolean isBtn_publier_ppm() {
		return btn_publier_ppm;
	}
	public void setBtn_publier_ppm(boolean btn_publier_ppm) {
		this.btn_publier_ppm = btn_publier_ppm;
	}


	public boolean isBtn_publier_pgspm() {
		return btn_publier_pgspm;
	}
	public void setBtn_publier_pgspm(boolean btn_publier_pgspm) {
		this.btn_publier_pgspm = btn_publier_pgspm;
	}


	public boolean isBtn_publier_pspm() {
		return btn_publier_pspm;
	}
	public void setBtn_publier_pspm(boolean btn_publier_pspm) {
		this.btn_publier_pspm = btn_publier_pspm;
	}


	public boolean isPanelPub() {
		return panelPub;
	}
	public void setPanelPub(boolean panelPub) {
		this.panelPub = panelPub;
	}


	public boolean isPanelPgpmTableauBordDpgPub() {
		return panelPgpmTableauBordDpgPub;
	}
	public void setPanelPgpmTableauBordDpgPub(boolean panelPgpmTableauBordDpgPub) {
		this.panelPgpmTableauBordDpgPub = panelPgpmTableauBordDpgPub;
	}


	public boolean isPanelPgpmTableauBordDpsgPub() {
		return panelPgpmTableauBordDpsgPub;
	}

	public void setPanelPgpmTableauBordDpsgPub(boolean panelPgpmTableauBordDpsgPub) {
		this.panelPgpmTableauBordDpsgPub = panelPgpmTableauBordDpsgPub;
	}


	public boolean isBtn_pub_csv() {
		return btn_pub_csv;
	}

	public void setBtn_pub_csv(boolean btn_pub_csv) {
		this.btn_pub_csv = btn_pub_csv;
	}


	public boolean isBtn_pub_dps() {
		return btn_pub_dps;
	}

	public void setBtn_pub_dps(boolean btn_pub_dps) {
		this.btn_pub_dps = btn_pub_dps;
	}


	public boolean isPanelDaoTableauBordPubCsv() {
		return panelDaoTableauBordPubCsv;
	}
	public void setPanelDaoTableauBordPubCsv(boolean panelDaoTableauBordPubCsv) {
		this.panelDaoTableauBordPubCsv = panelDaoTableauBordPubCsv;
	}


	public boolean isPanelDaoTableauBordPubDps() {
		return panelDaoTableauBordPubDps;
	}
	public void setPanelDaoTableauBordPubDps(boolean panelDaoTableauBordPubDps) {
		this.panelDaoTableauBordPubDps = panelDaoTableauBordPubDps;
	}


	public boolean isBtn_ami_csv() {
		return btn_ami_csv;
	}


	public void setBtn_ami_csv(boolean btn_ami_csv) {
		this.btn_ami_csv = btn_ami_csv;
	}


	public boolean isBtn_ami_dps() {
		return btn_ami_dps;
	}


	public void setBtn_ami_dps(boolean btn_ami_dps) {
		this.btn_ami_dps = btn_ami_dps;
	}


	public boolean isBtn_prq_csv() {
		return btn_prq_csv;
	}


	public void setBtn_prq_csv(boolean btn_prq_csv) {
		this.btn_prq_csv = btn_prq_csv;
	}


	public boolean isBtn_prq_dps() {
		return btn_prq_dps;
	}
	public void setBtn_prq_dps(boolean btn_prq_dps) {
		this.btn_prq_dps = btn_prq_dps;
	}


	public boolean isPanelDaoTableauBordDPubCsv() {
		return panelDaoTableauBordDPubCsv;
	}
	public void setPanelDaoTableauBordDPubCsv(boolean panelDaoTableauBordDPubCsv) {
		this.panelDaoTableauBordDPubCsv = panelDaoTableauBordDPubCsv;
	}


	public boolean isPanelDaoTableauBordDPubDps() {
		return panelDaoTableauBordDPubDps;
	}

	public void setPanelDaoTableauBordDPubDps(boolean panelDaoTableauBordDPubDps) {
		this.panelDaoTableauBordDPubDps = panelDaoTableauBordDPubDps;
	}


	public boolean isBtn_imprimer() {
		return btn_imprimer;
	}

	public void setBtn_imprimer(boolean btn_imprimer) {
		this.btn_imprimer = btn_imprimer;
	}


	public boolean isEtatPsc() {
		return etatPsc;
	}


	public void setEtatPsc(boolean etatPsc) {
		this.etatPsc = etatPsc;
	}


	public boolean isEtatPsl_Pso() {
		return etatPsl_Pso;
	}


	public void setEtatPsl_Pso(boolean etatPsl_Pso) {
		this.etatPsl_Pso = etatPsl_Pso;
	}


	public boolean isPanelPgpmTableauBordDjPub() {
		return panelPgpmTableauBordDjPub;
	}


	public void setPanelPgpmTableauBordDjPub(boolean panelPgpmTableauBordDjPub) {
		this.panelPgpmTableauBordDjPub = panelPgpmTableauBordDjPub;
	}


	public boolean isBtn_imprimer_pg() {
		return btn_imprimer_pg;
	}


	public void setBtn_imprimer_pg(boolean btn_imprimer_pg) {
		this.btn_imprimer_pg = btn_imprimer_pg;
	}


	public boolean isNbreAchat() {
		return nbreAchat;
	}


	public void setNbreAchat(boolean nbreAchat) {
		this.nbreAchat = nbreAchat;
	}
	
}
