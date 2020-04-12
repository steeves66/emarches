package com.sndi.controller.tableauBord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.dao.WhereClause;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;


@Component
@Scope(value="session")
public class TableauBordController {
	Logger _logger = Logger.getLogger(TableauBordController.class);
	
	
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
	 
	 
	 @PostConstruct
	 public void postContr() {
		 chargeDataAgpm();
		 //chargeDataPgpmPgspm();
		 //chargeDataPpmPspm();
		 chargeDataDao();
		 chargeDataPpm();
		 chargeDataPspm();
		 chargeDataPgpm();
		 chargeDataPgspm();
	 }
	 
	 
	 //AGPM
	 private String agpmTotal="";
	 /*
	  Compteur pour l'autorité Contractante
	   */
	 private String agpmAcSaisies="";
	 private String agpmCpRetournes ="";
	 private String agpmAcTransmis="";
	 private String agpmAcAttenteTransfert="";
	 private String agpmCpmDiffAc="";
	 private String  agpmDmDiffAc="";
	 /*
	  Compteur pour la Cellule de Passation des Marchés
	   */
	 private String agpmCpSaisie ="";
	 private String agpmCpTransmis ="";
	 private String agpmCpDifCpmp ="";
	 private String agpmCpDifDmpCpmp="";
	 private String agpmCpDifDmp ="";
	 private String agpmAcDifDmpCpmp ="";
	 private String agpmCpValide ="";
	 private String agpmCpAttenteValide="";
	 
	 /*
	  Compteur pour le Directeur des Marchés Publics
	   */
	 private String agpmDmSaisie ="";
	 private String agpmDmTransmis ="";
	 private String agpmDmValide ="";
	 private String agpmDmAttenteValide ="";
	 
 
	 //PGPM
	 private String pgpmTotal="";
	 /*
	  Compteur pour l'autorité Contractante
	   */
	 private String pgpmAcSaisie = "";
	 private String pgpmCpRetournes ="";
	 private String pgpmAcTransmis = "";
	 private String pgpmAcAttenteTransfert="";
	 private String pgpmAcDiffDmp="";
	 private String pgpmAcDiffDmpCpmp ="";
	 /*
	  Compteur pour la Cellule de Passation des Marchés
	   */
	 private String pgpmCpSaisie ="";
	 private String pgpmCpTransmis ="";
	 private String pgpmCpDifCpmp ="";
	 private String pgpmCpDifDmp ="";
	 private String pgpmCpValide ="";
	 private String pgpmAttenteValide="";
	 private String pgpmCpRetAc="";
	 /*
	  Compteur pour le Directeur des Marchés Publics
	   */
	 private String pgpmDmSaisie ="";
	 private String pgpmDmTransmis ="";
	 private String pgpmDmValide ="";
	 private String pgpmDmAttenteValide ="";
	 private String pgpmDmDiff="";
	
	 
	 //PGSPM
	 private String pgspmTotal=""; 
	 /*
	  Compteur pour l'autorité Contractante
	   */
		 private String pgspmAcSaisie = "";
		 private String pgspmCpRetournes ="";
		 private String pgspmAcTransmis = "";
		 private String pgspmAcAttenteValide = "";
		 private String pgspmAcDifDmp ="";
		 private String pgspmAcDiffCpmp = "";
	/*
	Compteur pour la Cellule de Passation des Marchés
	 */
		 private String pgspmCpSaisie ="";
		 private String pgspmCpTransmis ="";
		 private String pgspmCpDifCpmp ="";
		 private String pgspmCpDifDmp ="";
		 private String pgspmCpValide ="";
		 private String pgspmCpAttenteValide="";
		 
		 /*
		  Compteur pour le Directeur des Marchés Publics
		   */
		 private String pgspmDmSaisie ="";
		 private String pgspmDmTransmis ="";
		 private String pgspmDmValide ="";
	     private String pgspmDmAttenteValide ="";
	     private String pgspmDmDiff="";
	    
	     
	     
	     
	     
	     //PPM
		 private String ppmTotal=""; 
		 /*
		  Compteur pour l'autorité Contractante
		   */
			 private String ppmAcSaisie = "";
			 private String ppmCpRetournes ="";
			 private String ppmAcTransmis = "";
			 private String ppmAcAttenteValide = "";
			 private String ppmAcDiffCpmp = "";
			 private String ppmAcDiffDmp ="";
		/*
		Compteur pour la Cellule de Passation des Marchés
		 */
			 private String ppmCpSaisie ="";
			 private String ppmCpTransmis ="";
			 private String ppmCpDifCpmp ="";
			 private String ppmCpDifDmp ="";
			 private String ppmCpValide ="";
			 private String ppmCpAttenteValide="";
			 
			 /*
			  Compteur pour le Directeur des Marchés Publics
			   */
			 private String ppmDmSaisie ="";
			 private String ppmDmTransmis ="";
			 private String ppmDmValide ="";
		     private String ppmDmAttenteValide ="";
		     private String ppmDmDiff="";
		     
		     
		     //PSPM
			 private String pspmTotal=""; 
			 /*
			  Compteur pour l'autorité Contractante
			   */
				 private String pspmAcSaisie = "";
				 private String pspmCpRetournes ="";
				 private String pspmAcTransmis = "";
				 private String pspmAcAttenteValide = "";
				 private String pspmAcDiffCpmp = "";
				 private String pspmAcDiffDmp ="";
				 private String pgspmAcDiffDmpCpmp="";
			/*
			Compteur pour la Cellule de Passation des Marchés
			 */
				 private String pspmCpSaisie ="";
				 private String pspmCpTransmis ="";
				 private String pspmCpDifCpmp ="";
				 private String pspmCpDifDmp ="";
				 private String pspmCpValide ="";
				 private String pspmCpAttenteValide="";
				 
				 /*
				  Compteur pour le Directeur des Marchés Publics
				   */
				 private String pspmDmSaisie ="";
				 private String pspmDmTransmis ="";
				 private String pspmDmValide ="";
			     private String pspmDmAttenteValide ="";
			     private String pspmDmDiff="";
			     
			     
			   //DAO
				 private String daoTotal=""; 
				 /*
				  Compteur pour l'autorité Contractante
				   */
					 private String daoAcSaisie = "";
					 private String daoAcPs="";
					 private String daoCpRetournes ="";
					 private String daoAcTransmis = "";
					 private String daoAcAttenteValide = "";
					 private String daoAcDiffCpmp = "";
					 private String daoAcDiffDmp ="";
					 private String daoAcAttRetrait ="";
					 private String daoAcAttVente ="";
					 private String daoAcRetire="";
				/*
				Compteur pour la Cellule de Passation des Marchés
				 */
					 private String daoCpSaisie ="";
					 private String daoCpTransmis ="";
					 private String daoCpDifCpmp ="";
					 private String daoCpDifDmp ="";
					 private String daoCpValide ="";
					 private String daoCpAttenteValide="";
					 private String daoPriseTrait="";
					 private String daoaffecte ="";
					 
					 /*
					  Compteur pour le Chargé d'Etudes
					   */ 
					 
					 private String daoChargeAttente ="";
				     private String daoChargeVal="";
				     private String daoChargeCor="";
				     /*
					  Compteur pour le Chef de Service
					   */
				     private String daoCsvAttVal="";
				     private String daoCsvAttAff="";
					 private String daoCsvgeAffecte ="";
					 private String daoCsvValide="";
				     private String daoCsvDiff="";
				     private String daoCsvTraitCharg="";
					 /*
					  Compteur pour le Directeur des Marchés Publics
					   */
				     
				     //DAO EN PROCEDURE SIMPLIFIEE
				     
				     /*
					  Compteur pour l'autorité Contractante
					   */
						 private String daoAcSaisiePs = "";
						 private String daoAcPsPs="";
						 private String daoCpRetournesPs ="";
						 private String daoAcTransmisPs = "";
						 private String daoAcAttenteValidePs = "";
						 private String daoAcDiffCpmpPs = "";
						 private String daoAcDiffDmpPs ="";
						 private String daoAcAttRetraitPs ="";
						 private String daoAcAttVentePs ="";
						 private String daoAcRetirePs="";
						 private String daoTotalPs = "";
					/*
					Compteur pour la Cellule de Passation des Marchés
					 */
						 private String daoCpSaisiePs ="";
						 private String daoCpTransmisPs ="";
						 private String daoCpDifCpmpPs ="";
						 private String daoCpDifDmpPs ="";
						 private String daoCpValidePs ="";
						 private String daoCpAttenteValidePs="";
						 private String daoPriseTraitPs="";
						 private String daoaffectePs ="";
						 private String daoDaoPubPs = "";
						 
						 /*
						  Compteur pour le Chargé d'Etudes
						   */ 
						 
						 private String daoChargeAttentePs ="";
					     private String daoChargeValPs="";
					     private String daoChargeCorPs="";
					     /*
						  Compteur pour le Chef de Service
						   */
					     private String daoCsvAttValPs="";
					     private String daoCsvAttAffPs="";
						 private String daoCsvgeAffectePs ="";
						 private String daoCsvValidePs="";
					     private String daoCsvDiffPs="";
					     private String daoCsvTraitChargPs="";
					     private String daoDaoPub="";
						 /*
						  Compteur pour le Directeur des Marchés Publics
						   */
				     
				     //FIN DAO PROCEDURE SIMPLIFIEE
					     
					     
					     
					     //AMI
						 private String amiTotal=""; 
						 
						 /*
						  Compteur pour l'autorité Contractante
						   */
							 private String amiAcSaisie = "";
							 private String amiAcPs="";
							 private String amiCpRetournes ="";
							 private String amiAcTransmis = "";
							 private String amiAcAttenteValide = "";
							 private String amiAcDiffCpmp = "";
							 private String amiAcDiffDmp ="";
							 private String amiAcAttRetrait ="";
							 private String amiAcAttVente ="";
							 private String amiAcRetire="";
						/*
						Compteur pour la Cellule de Passation des Marchés
						 */
							 private String amiCpSaisie ="";
							 private String amiCpTransmis ="";
							 private String amiCpDifCpmp ="";
							 private String amiCpDifDmp ="";
							 private String amiCpValide ="";
							 private String amiCpAttenteValide="";
							 
							 private String amiaffecte ="";
							 
							 /*
							  Compteur pour le Chargé d'Etudes
							   */ 
							 
							 private String amiChargeAttente ="";
						     private String amiChargeVal="";
						     /*
							  Compteur pour le Chef de Service
							   */
						     private String amiCsvAttVal="";
						     private String amiCsvAttAff="";
							 private String amiCsvgeAffecte ="";
							 private String amiCsvValide="";
						     private String amiCsvDiff="";
						     private String amiCsvTraitCharg="";
							 /*
							  Compteur pour le Directeur des Marchés Publics
							   */
				     
						     
							   //PRQ
							 private String prqTotal=""; 
							 /*
							  Compteur pour l'autorité Contractante
							   */
								 private String prqAcSaisie = "";
								 private String prqAcPs="";
								 private String prqCpRetournes ="";
								 private String prqAcTransmis = "";
								 private String prqAcAttenteValide = "";
								 private String prqAcDiffCpmp = "";
								 private String prqAcDiffDmp ="";
								 private String prqAcAttRetrait ="";
								 private String prqAcAttVente ="";
								 private String prqAcRetire="";
							/*
							Compteur pour la Cellule de Passation des Marchés
							 */
								 private String prqCpSaisie ="";
								 private String prqCpTransmis ="";
								 private String prqCpDifCpmp ="";
								 private String prqCpDifDmp ="";
								 private String prqCpValide ="";
								 private String prqCpAttenteValide="";
								 
								 private String prqaffecte ="";
								 
								 /*
								  Compteur pour le Chargé d'Etudes
								   */ 
								 
								 private String prqChargeAttente ="";
							     private String prqChargeVal="";
							     private String prqChargeCor="";
							     /*
								  Compteur pour le Chef de Service
								   */
							     private String prqCsvAttVal="";
							     private String prqCsvAttAff="";
								 private String prqCsvgeAffecte ="";
								 private String prqCsvValide="";
							     private String prqCsvDiff="";
							     private String prqCsvTraitCharg="";
								 /*
								  Compteur pour le Directeur des Marchés Publics
								   */
				     
				     
			
		
	
		
		public void chargeDataAgpm() {
			   //Début AGPM
			 agpmTotal = ""+getAgpmDossierTotal();
			 agpmAcSaisies = ""+getAgpmAcSaisieDossier("S1S");
			 agpmAcAttenteTransfert = ""+getAgpmAcAttenteTransfert("S1S","S2D","SDR");
			 agpmAcTransmis = ""+getAgpmAcTransmisDossier("S1T","SDT");
			 agpmCpmDiffAc = ""+getNpDiffDossierCpmpAc("S2D");
			 agpmCpSaisie = ""+getAgpmCpSaisieDossier("S1S");
			 pgspmAcDifDmp = ""+getAgpmCpDiffAcDossier("S2D");
			 agpmCpTransmis = ""+getAgpmCpTransmisDossier("S1T");
			 agpmCpDifCpmp = ""+getNpDiffDossier("S2D");
			 agpmCpValide =""+getAgpmCpValideCmp("S2V");
			 agpmCpDifDmp =""+getAgpmDmDiff("S3D","SDR");
			 agpmAcDifDmpCpmp =""+getAgpmDmDiffAc("S2D","SDR");
			 agpmCpDifDmpCpmp  =""+getAgpmAcDiffDmpCpmp("S3D");
			 agpmCpAttenteValide = ""+getAgpmCpAttenteValide("S1T","S3D");
			 agpmDmValide = ""+getAgpmDmValide("S3V");
			 agpmDmSaisie = ""+getAgpmDmSaise("S1S");
			 agpmDmAttenteValide = ""+getAgpmDmAttValide("S2V","SDT");
			 agpmDmTransmis = ""+getAgpmDmpTransmisDossier("S1T");
			 agpmDmDiffAc =""+getNpDiffDossierCpmpAc("S3D");
			   //Fin AGPM
		}
		
		public void chargeDataPgpmPgspm() {
			//Début PGPM
			 pgpmTotal = ""+getPgpmDossierTotal();
			 pgpmAcSaisie = ""+getAcSaisieDossier("S1S");
			 pgpmAcAttenteTransfert = ""+getPgpmAttenteValide("S1S","S2D","SDR");
			 pgpmAcDiffDmp =""+getNpDiffDossierDmpAc("S3D");
			 pgpmAcDiffDmpCpmp =""+getNpDiffDossierCpmpDmpAc("S2D","SDR");
			 pgpmAcTransmis = ""+getAcTransmisDossier("S1T");   
			 pgpmCpRetAc = ""+getNpAcCpDiffDossier("S2D");
			 pgpmCpSaisie = ""+getNpSaisieDossier("S1S");
			 pgpmCpTransmis = ""+getNpTransmisDossier("S1T");
			 pgpmCpDifCpmp = ""+getNpDiffDossier("S2D");
			 pgpmCpValide =""+getNpValideCmp("S2V");
			 pgpmCpDifDmp =""+getNpDiffDmpCpmp("S3D");
			 pgpmAttenteValide = ""+getNpAttenteValide("S1T","S3D"); 
			 pgpmDmAttenteValide = ""+getNpAttValideDmp("S2V","SPG");
			 pgpmDmValide = ""+getNpValideDmp("S3V");
			 pgpmDmSaisie = ""+getNpSaisieDossier("S1S");
			 pgpmDmDiff = ""+getNpDiffDmp("S3D","SDR");
			 pgpmDmTransmis = ""+getNpDmpTransmisDossier("S1T");
			 //Fin PGPM
			 //Début PGSPM
			 pgspmTotal = ""+getPgspmDossierTotal();   
			 pgspmAcDifDmp =""+getNpsAcDiffCpmpDossier("S3D");
			 pgspmAcDiffCpmp = ""+getNpsAcDiffDmpDossier("S2D");
			 pgspmAcSaisie = ""+getAcNpsSaisieDossier("S1S");
			 pgspmAcAttenteValide = ""+getAcNpsAttenteValide("S1S","S2D","PGD");
			 pgspmAcTransmis = ""+getAcNpsTransmisDossier("S1T","PGS");
			 pgspmCpSaisie = ""+getNpsSaisieDossier("S1S");
			 pgspmCpTransmis = ""+getNpsTransmisDossier("S1T");
			 pgspmCpDifCpmp = ""+getNpsDiffDossier("S2D");
			 pgspmCpValide =""+getNpsValideCmp("S2V");
			 pgspmCpDifDmp =""+getNpsDiffDmpCpmp("S3D");
			 pgspmCpAttenteValide = ""+getNpsAttenteValide("S1T","S3D");
			 pgspmDmAttenteValide = ""+getNpsAttValideDmp("S2V","PGS");
			 pgspmDmValide = ""+getNpsValideDmp("S3V");
			 pgspmDmSaisie = ""+getNpsSaisieDossier("S1S");
			 pgspmDmDiff = ""+getNpsDiffDmp("S3D","PGD");
			 pgspmDmTransmis = ""+getNpDmpTransmisDossier("S1T");
			 //Fin PGSPM
		}

		public void chargeDataPgpm() {
			//Début PGPM
			 pgpmTotal = ""+getPgpmDossierTotal();
			 pgpmAcSaisie = ""+getAcSaisieDossier("S1S");
			 pgpmAcAttenteTransfert = ""+getPgpmAttenteValide("S1S","S2D","SDR");
			 pgpmAcDiffDmp =""+getNpDiffDossierDmpAc("S3D");
			 pgpmAcDiffDmpCpmp =""+getNpDiffDossierCpmpDmpAc("S2D","SDR");
			 pgpmAcTransmis = ""+getAcTransmisDossier("S1T");   
			 pgpmCpRetAc = ""+getNpAcCpDiffDossier("S2D");
			 pgpmCpSaisie = ""+getNpSaisieDossier("S1S");
			 pgpmCpTransmis = ""+getNpTransmisDossier("S1T");
			 pgpmCpDifCpmp = ""+getNpDiffDossier("S2D");
			 pgpmCpValide =""+getNpValideCmp("S2V");
			 pgpmCpDifDmp =""+getNpDiffDmpCpmp("S3D");
			 pgpmAttenteValide = ""+getNpAttenteValide("S1T","S3D"); 
			 pgpmDmAttenteValide = ""+getNpAttValideDmp("S2V","SPG");
			 pgpmDmValide = ""+getNpValideDmp("S3V");
			 pgpmDmSaisie = ""+getNpSaisieDossier("S1S");
			 pgpmDmDiff = ""+getNpDiffDmp("S3D","SDR");
			 pgpmDmTransmis = ""+getNpDmpTransmisDossier("S1T");	
			
		}
		
		public void chargeDataPgspm() {
			//Début PGSPM
			 pgspmTotal = ""+getPgspmDossierTotal();   
			 pgspmAcDifDmp =""+getNpsAcDiffCpmpDossier("S3D");
			 pgspmAcDiffCpmp = ""+getNpsAcDiffDmpDossier("S2D");
			 pgspmAcSaisie = ""+getAcNpsSaisieDossier("S1S");
			 pgspmAcAttenteValide = ""+getAcNpsAttenteValide("S1S","S2D","PGD");
			 pgspmAcDiffDmpCpmp =""+getNpsDiffDossierCpmpDmpAc("S2D","SDR");
			 pgspmAcTransmis = ""+getAcNpsTransmisDossier("S1T","PGS");
			 pgspmCpSaisie = ""+getNpsSaisieDossier("S1S");
			 pgspmCpTransmis = ""+getNpsTransmisDossier("S1T");
			 pgspmCpDifCpmp = ""+getNpsDiffDossier("S2D");
			 pgspmCpValide =""+getNpsValideCmp("S2V");
			 pgspmCpDifDmp =""+getNpsDiffDmpCpmp("S3D");
			 pgspmCpAttenteValide = ""+getNpsAttenteValide("S1T","S3D");
			 pgspmDmAttenteValide = ""+getNpsAttValideDmp("S2V","PGS");
			 pgspmDmValide = ""+getNpsValideDmp("S3V");
			 pgspmDmSaisie = ""+getNpsSaisieDossier("S1S");
			 pgspmDmDiff = ""+getNpsDiffDmp("S3D","PGD");
			 pgspmDmTransmis = ""+getNpDmpTransmisDossier("S1T");
			 //Fin PGSPM
			
		}

		public void chargeDataPpm() {
			
			//Début PPM
			 ppmTotal = ""+getPpmDossierTotal();
			 ppmAcSaisie = ""+getAcPpmSaisieDossier("S1S");
			 ppmAcAttenteValide = ""+getAcPpmAttenteValide("S1S","S2D","SPR");
			 ppmAcDiffCpmp = ""+getPpmDiffCpmpACDossier("S2D");
			 ppmAcDiffDmp = ""+getPpmDiffDmpACDossier("S3D","SPR"); 
			 ppmAcTransmis = ""+getAcPpmTransmisDossier("S1T","SPT");
			 ppmCpSaisie = ""+getPpmSaisieDossier("S1S");
			 ppmCpTransmis = ""+getPpmTransmisDossier("S1T");
			 ppmCpDifCpmp = ""+getPpmDiffDossier("S2D");
			 ppmCpValide =""+getPpmValideCmp("S2V");
			 ppmCpDifDmp =""+getPpmDiffDmp("S3D","SPR");
			 ppmCpAttenteValide = ""+getPpmAttenteValide("S1T","S3D");
			 ppmDmAttenteValide = ""+getPpmAttValideDmp("S2V","SPT");
			 ppmDmValide = ""+getPpmValideDmp("S3V");
			 ppmDmSaisie = ""+getPpmSaisieDossier("S1S");
			 ppmDmDiff = ""+getPpmDiffDmp("S3D","SPR");
			 ppmDmTransmis = ""+getPpmTransmisDmpDossier("S1T");
			 //Fin PPM
			
		}
		
		public void chargeDataPspm() {
			 pspmTotal = ""+getPspmDossierTotal();
			 pspmAcSaisie = ""+getAcPspmSaisieDossier("S1S");
			 pspmAcAttenteValide = ""+getAcPspmAttenteValide("S1S","S2D");
			 pspmAcDiffCpmp = ""+getPspmDiffCpmpACDossier("S2D");
			 pspmAcDiffDmp = ""+getPspmDiffDmpACDossier("S3D","SPR");
			 pspmAcTransmis = ""+getAcPspmTransmisDossier("S1T");
			 pspmCpSaisie = ""+getPspmSaisieDossier("S1S");
			 pspmCpTransmis = ""+getPspmTransmisDossier("S1T");
			 pspmCpDifCpmp = ""+getPspmDiffDossier("S2D");
			 pspmCpValide =""+getPspmValideCmp("S2V");
			 pspmCpDifDmp =""+getPspmDiffDmp("S3D");
			 pspmCpAttenteValide = ""+getPspmAttenteValide("S1T","S3D");
			 pspmDmAttenteValide = ""+getPspmAttValideDmp("S2V");
			 pspmDmValide = ""+getPspmValideDmp("S3V");
			 pspmDmSaisie = ""+getPspmSaisieDossier("S1S");
			 pspmDmDiff = ""+getPspmDiffDmp("S3D");
			 pspmDmTransmis = ""+getPspmTransmisDmpDossier("S1T");	
			
		}
		
		public void chargeDataAmi() {
			 //Début AMI 
			 amiTotal = ""+getAmiDossierTotal();
			 amiAcSaisie = ""+getAcAmiSaisieDossier("D1S");
			 amiAcPs=""+getAcAmiSaisiePs("D1A");
			 amiChargeAttente = ""+getAcAmiAttenteCharge("D3A");
			 amiChargeVal = ""+getAcAmiValCharge("D4V");
			 amiAcAttenteValide = ""+getAcAmiAttenteValide("D1S","S2D"); 
			 amiCsvAttAff = ""+getAmiAttAffCsv("D2T");
			 amiCsvAttVal = ""+getAcAmiValChargeCsv("D4V");
			 amiaffecte = ""+getAcAmiAffecteDossier("D3A");
			 amiCsvValide = ""+getAcAmiValidCsvDossier("D5V");
			 amiCsvDiff = ""+getAcAmiValidCsvDossier("D5R");
			 amiAcDiffCpmp = ""+getAmiDiffCpmpACDossier("D2T");
			 amiAcDiffDmp = ""+getAmiDiffDmpACDossier("S3D");
			 amiAcTransmis = ""+getAcAmiTransmisDossier("D1T");
			 amiCpSaisie = ""+getAmiSaisieDossier("D1T");
			 amiCpTransmis = ""+getAmiTransmisDossier("D1T");
			 amiCpDifCpmp = ""+getAmiDiffDossier("S2D");
			 amiCpValide = ""+getAmiValideCmp("D2T");
			 amiCpDifDmp =""+getAmiDiffDmp("S3D");
			 amiCpAttenteValide = ""+getAmiAttenteValide("S1T","S3D");
			 amiAcAttVente = ""+getAmiAttenteRetrait("DPU","D6V");
			 amiAcAttRetrait = ""+getAmiAttenteVente("DVE");
			 amiAcRetire = ""+getAmiAcRetire("RET");
			 //Fin AMI	
		}
		
		//Début PRQ 
		public void chargeDataPrq() {
			 prqTotal = ""+getPrqDossierTotal();
			 prqAcSaisie = ""+getAcPrqSaisieDossier("D1S");
			 prqAcPs=""+getAcPrqSaisiePs("D1A");
			 prqChargeAttente = ""+getAcPrqAttenteCharge("D3A");
			 prqChargeVal = ""+getAcPrqValCharge("D4V");
			 prqAcAttenteValide = ""+getAcPrqAttenteValide("D1S","S2D"); 
			 prqCsvAttAff = ""+getPrqAttAffCsv("D2T");
			 prqCsvAttVal = ""+getAcPrqValChargeCsv("D4V");
			 prqaffecte = ""+getAcPrqAffecteDossier("D3A");
			 prqCsvValide = ""+getAcPrqValidCsvDossier("D5V");
			 prqCsvDiff = ""+getAcPrqValidCsvDossier("D5R");
			 prqAcDiffCpmp = ""+getPrqDiffCpmpACDossier("D2T");
			 prqAcDiffDmp = ""+getPrqDiffDmpACDossier("S3D");
			 prqAcTransmis = ""+getAcPrqTransmisDossier("D1T");
			 prqCpSaisie = ""+getPrqSaisieDossier("D1T");
			 prqCpTransmis = ""+getPrqTransmisDossier("D1T");
			 prqCpDifCpmp = ""+getPrqDiffDossier("S2D");
			 prqCpValide = ""+getPrqValideCmp("D2T");
			 prqCpDifDmp =""+getPrqDiffDmp("S3D");
			 prqCpAttenteValide = ""+getPrqAttenteValide("S1T","S3D");
			 prqAcAttVente = ""+getPrqAttenteRetrait("DPU","D6V");
			 prqAcAttRetrait = ""+getPrqAttenteVente("DVE");
			 prqAcRetire = ""+getPrqAcRetire("RET");
			 prqChargeCor = ""+getAcPrqCorCharge("DC2");
		}
		//Fin PRQ 	
		
		public void chargeDataPpmPspm(){
			//Début PPM
			 ppmTotal = ""+getPpmDossierTotal();
			 ppmAcSaisie = ""+getAcPpmSaisieDossier("S1S");
			 ppmAcAttenteValide = ""+getAcPpmAttenteValide("S1S","S2D","SPR");
			 ppmAcDiffCpmp = ""+getPpmDiffCpmpACDossier("S2D");
			 ppmAcDiffDmp = ""+getPpmDiffDmpACDossier("S3D","SPR");
			 ppmAcTransmis = ""+getAcPpmTransmisDossier("S1T","SPT");
			 ppmCpSaisie = ""+getPpmSaisieDossier("S1S");
			 ppmCpTransmis = ""+getPpmTransmisDossier("S1T");
			 ppmCpDifCpmp = ""+getPpmDiffDossier("S2D");
			 ppmCpValide =""+getPpmValideCmp("S2V");
			 ppmCpDifDmp =""+getPpmDiffDmp("S3D","SPR");
			 ppmCpAttenteValide = ""+getPpmAttenteValide("S1T","S3D");
			 ppmDmAttenteValide = ""+getPpmAttValideDmp("S2V","SPT");
			 ppmDmValide = ""+getPpmValideDmp("S3V");
			 ppmDmSaisie = ""+getPpmSaisieDossier("S1S");
			 ppmDmDiff = ""+getPpmDiffDmp("S3D","SPR");
			 ppmDmTransmis = ""+getPpmTransmisDmpDossier("S1T");
			 //Fin PPM
			 
			 //Début PSPM
			 pspmTotal = ""+getPspmDossierTotal();
			 pspmAcSaisie = ""+getAcPspmSaisieDossier("S1S");
			 pspmAcAttenteValide = ""+getAcPspmAttenteValide("S1S","S2D");
			 pspmAcDiffCpmp = ""+getPspmDiffCpmpACDossier("S2D");
			 pspmAcDiffDmp = ""+getPspmDiffDmpACDossier("S3D","SPR");
			 pspmAcTransmis = ""+getAcPspmTransmisDossier("S1T");
			 pspmCpSaisie = ""+getPspmSaisieDossier("S1S");
			 pspmCpTransmis = ""+getPspmTransmisDossier("S1T");
			 pspmCpDifCpmp = ""+getPspmDiffDossier("S2D");
			 pspmCpValide =""+getPspmValideCmp("S2V");
			 pspmCpDifDmp =""+getPspmDiffDmp("S3D");
			 pspmCpAttenteValide = ""+getPspmAttenteValide("S1T","S3D");
			 pspmDmAttenteValide = ""+getPspmAttValideDmp("S2V");
			 pspmDmValide = ""+getPspmValideDmp("S3V");
			 pspmDmSaisie = ""+getPspmSaisieDossier("S1S");
			 pspmDmDiff = ""+getPspmDiffDmp("S3D");
			 pspmDmTransmis = ""+getPspmTransmisDmpDossier("S1T");
			 //Fin PSPM
		}
		
		public void chargeDataDao() {
			 //Début DAO 
			 daoTotal = ""+getDaoDossierTotal();
			 daoAcSaisie = ""+getAcDaoSaisieDossier("D1S","D1R");
			 daoAcPs=""+getAcDaoSaisiePs("SBO","SRO");
			 daoPriseTrait=""+getAcDaoSaisiePs("SB1","DOP");
			 daoChargeAttente = ""+getAcDaoAttenteCharge("D3A");
			 daoChargeVal = ""+getAcDaoValCharge("D4V");
			 daoDaoPub = ""+getAcDaoValidCsvPubDossier("DPU");
			 daoAcAttenteValide = ""+getAcDaoAttenteValide("D1S","S2D"); 
			 daoCsvAttAff = ""+getDaoAttAffCsv("D2T","D5R","DOP");
			 daoCsvAttVal = ""+getAcDaoValChargeCsv("D4V");
			 daoaffecte = ""+getAcDaoAffecteDossier("D3A");
			 daoCsvValide = ""+getAcDaoValidCsvDossier("D5V","DOP");
			 daoCsvDiff = ""+getAcDaoValidCsv("D5R");
			 daoAcDiffCpmp = ""+getDaoDiffCpmpACDossier("D1R");
			 daoAcTransmis = ""+getAcDaoTransmisDossier("D1T");
			 daoAcDiffDmp = ""+getDaoDiffDmpACDossier("S3D");
			 daoAcTransmis = ""+getAcDaoTransmisDossier("D1T");
			 daoCpSaisie = ""+getDaoSaisieDossier("D1T");
			 daoCpTransmis = ""+getDaoTransmisDossier("D1T");
			 daoCpDifCpmp = ""+getDaoDiffDossier("D1R","D2R");
			 daoCpValide = ""+getDaoValideCmp("D2T");
			 daoCpDifDmp =""+getDaoDiffDmp("S3D");
			 daoCpAttenteValide = ""+getDaoAttenteValide("S1T","S3D");
			 daoAcAttVente = ""+getDaoAttenteRetrait("DPU","D6V");
			 daoAcAttRetrait = ""+getDaoAttenteVente("DVE");
			 daoAcRetire = ""+getDaoAcRetire("RET");
			 daoChargeCor = ""+getAcDaoCorCharge("DC2");
			 //Fin DAO	en Procédure Normale
		}
		
		public void chargeDataDaoPs() {
			 //Début DAO en procédure Simplifiée 
			 daoTotalPs = ""+getDaoDossierTotalPs();
			 daoAcSaisiePs = ""+getAcDaoSaisieDossierPs("D1S","D1R");
			 daoAcPsPs=""+getAcDaoSaisiePs("SBO","SRO");
			 daoPriseTraitPs=""+getAcDaoSaisiePs("SB1","DOP");
			 daoChargeAttentePs = ""+getAcDaoAttenteChargePs("D3A");
			 daoChargeValPs = ""+getAcDaoValChargePs("D4V");
			 daoDaoPubPs = ""+getAcDaoValidCsvPubDossierPs("DPU");
			 daoAcAttenteValidePs = ""+getAcDaoAttenteValidePs("D1S","S2D"); 
			 daoCsvAttAffPs = ""+getDaoAttAffCsvPs("D2T","D5R","DOP");
			 daoCsvAttValPs = ""+getAcDaoValChargeCsvPs("D4V");
			 daoaffectePs = ""+getAcDaoAffecteDossierPs("D3A");
			 daoCsvValidePs = ""+getAcDaoValidCsvDossierPs("D5V");
			 daoCsvDiffPs = ""+getAcDaoValidCsvDossierPs("D5R");
			 daoAcDiffCpmpPs = ""+getDaoDiffCpmpACDossierPs("D1R");
			 daoAcTransmisPs = ""+getAcDaoTransmisDossierPs("D1T");
			 daoAcDiffDmpPs = ""+getDaoDiffDmpACDossierPs("S3D");
			 daoAcTransmisPs = ""+getAcDaoTransmisDossierPs("D1T");
			 daoCpSaisiePs = ""+getDaoSaisieDossierPs("D1T");
			 daoCpTransmisPs = ""+getDaoTransmisDossierPs("D1T");
			 daoCpDifCpmpPs = ""+getDaoDiffDossierPs("D1R","D2R");
			 daoCpValidePs = ""+getDaoValideCmpPs("D2T");
			 daoCpDifDmpPs =""+getDaoDiffDmpPs("S3D");
			 daoCpAttenteValidePs = ""+getDaoAttenteValidePs("S1T","S3D");
			 daoAcAttVentePs = ""+getDaoAttenteRetraitPs("DPU","D6V");
			 daoAcAttRetraitPs = ""+getDaoAttenteVentePs("DVE");
			 daoAcRetirePs = ""+getDaoAcRetirePs("RET");
			 daoChargeCorPs = ""+getAcDaoCorChargePs("DC2");
			 //Fin DAO en procédure simplifiée
		}
	
	 
		
		 
		 
	     //AGPM
		 //Nombre total des Agpm
		 public int getAgpmDossierTotal(){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
				return	i;	
			}
			//agpm saisi par le AC
			public int getAgpmAcSaisieDossier(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}

			
			//agpm Transmis par le AC
			public int getAgpmAcTransmisDossier(String src1, String src2){
				int i = iservice.countTableByColumnIn("T_AGPM", "AGP_ID",new ArrayList<String>(Arrays.asList("AGP_ID")),
						"AGP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;
			}

			//agpm en attente de transmission chez le AC
			public int getAgpmAcAttenteTransfert(String src1, String src2, String src3){
				int i = iservice.countTableByColumnIn("T_AGPM", "AGP_ID",new ArrayList<String>(Arrays.asList("AGP_ID")),
						"AGP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2,src3)),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;
			}


			//agpm saisi par le CPMP
			public int getAgpmCpSaisieDossier(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
			 //agpm non transmis par le cpmp
			public int getAgpmAcSaisieDossierIn(String src1, String src2){
				int i = iservice.countTableByColumnIn("T_AGPM", "AGP_ID",new ArrayList<String>(Arrays.asList("AGP_ID")),
						"AGP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
						new WhereClause("AGP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
						new WhereClause("AGP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				return	i;
			}

			//agpm transmis par le cpmp
			public int getAgpmCpTransmisDossier(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
			
			//agpm en attente de validation ch ez le dmp 
			public int getAgpmDmAttenteDossier(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
				return	i;	
			}
			
			//agpm retournés par le C chez le AC
			public int getAgpmCpDiffAcDossier(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}

			//agpm retournés par le cpmp
			public int getAgpmCpDiffDossier(String src){ 
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				return	i;	
			}
			
			

			//agpm retournés par le dmp chez la cpmp
			public int getAgpmAcDiffDmpCpmp(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				return	i;	
			}


			//pgpm en attente de validation par le CPMP
			public int getAgpmCpAttenteValide(String src1, String src2){
				int i = iservice.countTableByColumnIn("T_AGPM", "AGP_ID",new ArrayList<String>(Arrays.asList("AGP_ID")),
						"AGP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				return	i;
			}


			//agpm validés par le cpmp
			public int getAgpmCpValideCmp(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
				return	i;	
			}
			
			//agpm validés par le dpmp
			public int getAgpmDmSaise(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
	


			//agpm validés par le dmp
			public int getAgpmDmValide(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src));
				return	i;	
			}
			
			
			//agpm retourné par la DMP
			public int getAgpmDmDiff(String src1, String src2){
				int i = iservice.countTableByColumnIn("T_AGPM", "AGP_ID",new ArrayList<String>(Arrays.asList("AGP_ID")),
						"AGP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
						//new WhereClause("AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;
			}
			
			//agpm retourné par la DMP et la CPMP Chez l'AC
			public int getAgpmDmDiffAc(String src1, String src2){
				int i = iservice.countTableByColumnIn("T_AGPM", "AGP_ID",new ArrayList<String>(Arrays.asList("AGP_ID")),
						"AGP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
						//new WhereClause("AGP_ACTEUR_SAISIE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;
			}
			
			
		
			
			//agpm en attente de validation par la dmp
			public int getAgpmDmAttValide(String src1, String src2){
				int i = iservice.countTableByColumnIn("T_AGPM", "AGP_ID",new ArrayList<String>(Arrays.asList("AGP_ID")),
						"AGP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
				return	i;
			}
			
			//agpm Transmis par la Dmp
			public int getAgpmDmpTransmisDossier(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"),
						new WhereClause("AGP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				return	i;	
			}
			
			//agpm retourné par le dmp(Son propre tableau de Bord)
			public int getAgpmAcDiffDmp(String src){
				int i = iservice.countTableByColumn("T_AGPM", "AGP_ID",
						new WhereClause("AGP_STA_CODE", WhereClause.Comparateur.EQ, src),
						new WhereClause("AGP_ACTIF",WhereClause.Comparateur.EQ,"1"));
						//new WhereClause("AGP_MIN_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode()));
				return	i;	
			}
  //Fin AGPM



		 
		 
//Début PGPM

//Nombre total des Pgpm
public int getPgpmDossierTotal(){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
	new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
return	i;	
	}

//le nombre total de PGPM
public int getNpDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
} 
//pgpm saisi par le AC
public int getAcSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgpm Transmis par le AC
public int getAcTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgpm en attente de transmission par le AC
public int getAcAttenteValide(String src1, String src2, String src3){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2,src3)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}

//pgpm en attente de transmission par le AC
public int getPgpmAttenteValide(String src1, String src2, String src3){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2,src3)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//pgpm saisi par le CPMP
public int getNpSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}
 //pgpm non transmis par le cpmp
public int getNpSaisieDossierIn(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}

//pgpm transmis par le cpmp
public int getNpTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//pgpm retourné par le cpmp chez le AC
public int getNpAcCpDiffDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}



//pgpm retournés par le cpmp (Son propre tableau de Bord)
public int getNpDiffDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//pgpm retournés par le cpmp chez le AC
public int getNpDiffDossierCpmpAc(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgpm retournés par le cpmp chez le AC
public int getNpDiffDossierDmpAc(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//pgpm retournés par la CPMP et la DMP chez le AC
public int getNpDiffDossierCpmpDmpAc(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//pgpm retournés par le dmp chez la cpmp
public int getNpDiffDmpCpmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//pgpm en attente de validation par le CPMP
public int getNpAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}


//pgpm validés par le cpmp
public int getNpValideCmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//pgpm validés par le dmp
public int getNpValideDmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
}

//pgspm en attente de transmission chez le AC
public int getAcNpAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
			//new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}




//pgpm en attente de validation par la dmp
public int getNpAttValideDmp(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;
}

//pgpm Transmis par le Dmp
public int getNpDmpTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//pgpm retournés par la dmp 
public int getNpDiffDmp(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;
}
//Fin PGPM



//Début PGSPM
//Nombre total des Pgspm
public int getPgspmDossierTotal(){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
	new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"));
return	i;	
	} 
//pgspm saisi par le AC
public int getAcNpsSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgspm Transmis par le AC
public int getAcNpsTransmisDossier(String src1, String src2){
int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgspm en attente de transmission chez le AC
public int getAcNpsAttenteValide(String src1, String src2, String src3){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2,src3)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//pgspm saisi par le CPMP
public int getNpsSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgspm retournés par la CPMP et la DMP chez le AC
public int getNpsDiffDossierCpmpDmpAc(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgspm en attente de transmission chez le cpmp
public int getNpsSaisieDossierIn(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			//new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}

//pgspm transmis par le cpmp
public int getNpsTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgspm retourné par le cpmp chez le AC
public int getNpsAcDiffCpmpDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgspm retourné par le dmp chez le AC
public int getNpsAcDiffDmpDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pgspm retournés par le cpmp
public int getNpsDiffDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//pgspm retournés par le dmp chez la cpmp
public int getNpsDiffDmpCpmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//pgspm en attente de validation par le CPMP
public int getNpsAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}


//pgspm validés par le cpmp
public int getNpsValideCmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("GPG_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//pgspm validés par le dmp
public int getNpsValideDmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_GENERAL", "GPG_ID",
			new WhereClause("GPG_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"));
			//new WhereClause("GPG_MIN_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode()));
	return	i;	
}

//pgspm en attente de validation par le dmp
public int getNpsAttValideDmp(String src1, String src2){
	int i  = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"));
	return	i;	
}

//pgspm retournés par le dmp (Son propre tableau de Bord)
public int getNpsDiffDmp(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_GENERAL", "GPG_ID",new ArrayList<String>(Arrays.asList("GPG_ID")),
			"GPG_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("GPG_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"));
			//new WhereClause("GPG_MIN_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode()));
	return	i;	
}
//Fin PGSPM



//Début PSPM
//Nombre total des Pspm
public int getPspmDossierTotal(){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
	new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"));
return	i;	
	} 
//pspm saisi par le AC
public int getAcPspmSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pspm Transmis par le AC
public int getAcPspmTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pspm en attente de transmission chez le AC
public int getAcPspmAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//pspm saisi par le CPMP
public int getPspmSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}
//pspm non transmis par le cpmp
public int getPspmSaisieDossierIn(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
			new WhereClause("DPP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}

//pspm transmis par le cpmp
public int getPspmTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//pspm retournés par le cpmp chez le AC
public int getPspmDiffCpmpACDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pspm retournés par le dmp chez le AC
public int getPspmDiffDmpACDossier(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//pspm retournés par le cpmp (Son propre tableau de bord)
public int getPspmDiffDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_MOP_CODE", WhereClause.Comparateur.EQ,"PSC"),
			new WhereClause("DPP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//pspm retournés par le dmp
public int getPspmDiffDmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"));
			//new WhereClause("DPP_MIN_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode()));
	return	i;	
}


//pspm en attente de validation par le CPMP
public int getPspmAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_MOP_CODE", WhereClause.Comparateur.EQ,"PSC"),
			new WhereClause("DPP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}


//pspm validés par le cpmp
public int getPspmValideCmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_MOP_CODE", WhereClause.Comparateur.EQ,"PSC"),
			new WhereClause("DPP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//pspm validés par le dmp
public int getPspmValideDmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"));
			//new WhereClause("GPG_MIN_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode()));
	return	i;	
}

//ppm en attente de validation par le dmp
public int getPspmAttValideDmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"));
	return	i;	
}


//ppm transmis par le dmp
public int getPspmTransmisDmpDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}
//Fin PSPM




//Début PPM
//Nombre total des Ppm
public int getPpmDossierTotal(){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
	new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
return	i;	
	} 
//ppm saisi par le AC
public int getAcPpmSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//ppm Transmis par le AC
public int getAcPpmTransmisDossier(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//ppm en attente de transmission chez le AC
public int getAcPpmAttenteValide(String src1, String src2, String src3){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2,src3)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//ppm saisi par le CPMP
public int getPpmSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}
//ppm non transmis par le cpmp
public int getPpmSaisieDossierIn(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()),
			new WhereClause("DPP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}

//ppm transmis par le cpmp
public int getPpmTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//ppm retournés par le cpmp chez le AC
public int getPpmDiffCpmpACDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//ppm retournés par le dmp chez le AC
public int getPpmDiffDmpACDossier(String src1,String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//ppm retournés par le cpmp (Son propre tableau de bord)
public int getPpmDiffDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//ppm retournés par le dmp
public int getPpmDiffDmp(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
}


//ppm en attente de validation par le CPMP
public int getPpmAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}


//ppm validés par le cpmp
public int getPpmValideCmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//ppm validés par le dmp
public int getPpmValideDmp(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
			//new WhereClause("GPG_MIN_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTMinistere().getMinCode()));
	return	i;	
}

//ppm en attente de validation par le dmp
public int getPpmAttValideDmp(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DETAIL_PLAN_PASSATION", "DPP_ID",new ArrayList<String>(Arrays.asList("DPP_ID")),
			"DPP_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
}


//ppm transmis par le dmp
public int getPpmTransmisDmpDossier(String src){
	int i = iservice.countTableByColumn("T_DETAIL_PLAN_PASSATION", "DPP_ID",
			new WhereClause("DPP_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}
//Fin PPM



//Début DAO Procédure Normale
//Nombre total des DAO
public int getDaoDossierTotal(){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"));
	//new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ,"PN"));
return	i;	
	} 
//DAO saisi par le AC
public int getAcDaoSaisieDossier(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO saisi par le AC en procédure simplifiée
public int getAcDaoSaisiePs(String src1, String src2){ 
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO en attente chez le chargé d'Etudes
public int getAcDaoAttenteCharge(String src){
	int i = iservice.countTableByColumn("V_DAO_CHARGE_ETUDE", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DCS_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO validé par le chargé d'Etudes
public int getAcDaoValChargeDet(String src){
	int i = iservice.countTableByColumn("V_DAO_CHARGE_ETUDE", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DCS_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

public int getAcDaoValCharge(String src){
	int i = iservice.countTableByColumn("T_DAO_AFFECTATION", "DAF_DAC_CODE",
			new WhereClause("DAF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAF_TYPE_DAC", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAF_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAF_DAC_STR", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//Nombre de DAO corrigé par le responsable de saisie
public int getAcDaoCorCharge(String src){
	int i = iservice.countTableByColumn("T_DAO_AFFECTATION", "DAF_DAC_CODE",
			new WhereClause("DAF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAF_TYPE_DAC", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAF_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAF_DAC_STR", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

public int getAcDaoValChargeCsv(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//DAO saisi par le AC
public int getAcDaoAffecteDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO validé par le Chef de Service
public int getAcDaoValidCsvDossier(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//
public int getAcDaoValidCsv(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO publié par le Chef de Service
public int getAcDaoValidCsvPubDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO Transmis par le AC
public int getAcDaoTransmisDossier(String src){ 
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO en attente de transmission chez le AC
public int getAcDaoAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//DAO saisi par le CPMP
public int getDaoSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//DAO non transmis par le cpmp
public int getDaoSaisieDossierIn(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;
}

//DAO transmis par le cpmp
public int getDaoTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//DAO envoyés pour l'affectation chez le chef de service
public int getDaoAttAffCsv(String src1, String src2,String src3){ 
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2,src3)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par le cpmp chez le AC
public int getDaoDiffCpmpACDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par le dmp chez le AC
public int getDaoDiffDmpACDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
	        new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par la cpmp (Son propre tableau de bord)
public int getDaoDiffDossier(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par le dmp
public int getDaoDiffDmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
	return	i;	
}


//DAO en attente de validation par le CPMP
public int getDaoAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}

//DAO en attente de retrait chez l'AC
public int getDaoAttenteRetrait(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
			"AFF_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"), 
			new WhereClause("AFF_DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("AFF_DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//DAO en attente de vente chez l'AC
public int getDaoAttenteVente(String src){
	int i = iservice.countTableByColumn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",
			new WhereClause("AFF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("AFF_DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("AFF_DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//DAO retiré chez l'AC
public int getDaoAcRetire(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//DAO validés par le cpmp
public int getDaoValideCmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//DAO validés par le dmp
public int getDaoValideDmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
}

//DAO en attente de validation par le dmp
public int getDaoAttValideDmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
	return	i;	
}


//DAO transmis par le dmp
public int getDaoTransmisDmpDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}
//Fin DAO en Procédure Normale


//Début DAO Procédure Simplifiée
//Nombre total des DAO
public int getDaoDossierTotalPs(){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"));
	//new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ,"PN"));
return	i;	
	} 
//DAO saisi par le AC
public int getAcDaoSaisieDossierPs(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO saisi par le AC en procédure simplifiée
public int getAcDaoSaisiePsPs(String src1, String src2){ 
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO en attente chez le chargé d'Etudes
public int getAcDaoAttenteChargePs(String src){
	int i = iservice.countTableByColumn("V_DAO_CHARGE_ETUDE", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DCS_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par la cpmp (Son propre tableau de bord)
public int getDaoDiffDossierPs(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO validé par le chargé d'Etudes
public int getAcDaoValChargeDetPs(String src){
	int i = iservice.countTableByColumn("V_DAO_CHARGE_ETUDE", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DCS_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO publié par le Chef de Service
public int getAcDaoValidCsvPubDossierPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

public int getAcDaoValChargePs(String src){
	int i = iservice.countTableByColumn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",
			new WhereClause("AFF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("AFF_DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("AFF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("AFF_DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//Nombre de DAO corrigé par le responsable de saisie
public int getAcDaoCorChargePs(String src){
	int i = iservice.countTableByColumn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",
			new WhereClause("AFF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("AFF_DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("AFF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("AFF_DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

public int getAcDaoValChargeCsvPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//DAO saisi par le AC
public int getAcDaoAffecteDossierPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO validé par le Chef de Service
public int getAcDaoValidCsvDossierPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO Transmis par le AC
public int getAcDaoTransmisDossierPs(String src){ 
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO en attente de transmission chez le AC
public int getAcDaoAttenteValidePs(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//DAO saisi par le CPMP
public int getDaoSaisieDossierPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//DAO non transmis par le cpmp
public int getDaoSaisieDossierInPs(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;
}

//DAO transmis par le cpmp
public int getDaoTransmisDossierPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//DAO envoyés pour l'affectation chez le chef de service
public int getDaoAttAffCsvPs(String src1, String src2,String src3){ 
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2,src3)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par le cpmp chez le AC
public int getDaoDiffCpmpACDossierPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par le dmp chez le AC
public int getDaoDiffDmpACDossierPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
	        new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par la cpmp (Son propre tableau de bord)
public int getDaoDiffDossierPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par le dmp
public int getDaoDiffDmpPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
	return	i;	
}


//DAO en attente de validation par le CPMP
public int getDaoAttenteValidePs(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}

//DAO en attente de retrait chez l'AC
public int getDaoAttenteRetraitPs(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
			"AFF_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"), 
			new WhereClause("AFF_DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("AFF_DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//DAO en attente de vente chez l'AC
public int getDaoAttenteVentePs(String src){
	int i = iservice.countTableByColumn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",
			new WhereClause("AFF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("AFF_DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("AFF_DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//DAO retiré chez l'AC
public int getDaoAcRetirePs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//DAO validés par le cpmp
public int getDaoValideCmpPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//DAO validés par le dmp
public int getDaoValideDmpPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
}

//DAO en attente de validation par le dmp
public int getDaoAttValideDmpPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
	return	i;	
}


//DAO transmis par le dmp
public int getDaoTransmisDmpDossierPs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"DAO"),
			new WhereClause("DAC_TYPE_PLAN", WhereClause.Comparateur.EQ,"PS"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}
//Fin DAO




//Début PRQ
//Nombre total des PRQ
public int getPrqDossierTotal(){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"));
	//new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ,"PN"));
return	i;	
	} 
//PRQ saisi par le AC
public int getAcPrqSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//PRQ saisi par le AC en procédure simplifiée
public int getAcPrqSaisiePs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//PRQ en attente chez le chargé d'Etudes
public int getAcPrqAttenteCharge(String src){
	int i = iservice.countTableByColumn("V_DAO_CHARGE_ETUDE", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DCS_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//PRQ validé par le chargé d'Etudes
public int getAcPrqValChargeDet(String src){
	int i = iservice.countTableByColumn("V_DAO_CHARGE_ETUDE", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DCS_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

public int getAcPrqValCharge(String src){
	int i = iservice.countTableByColumn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",
			new WhereClause("AFF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("AFF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("AFF_DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//Nombre de PRQ corrigé par le responsable de saisie
public int getAcPrqCorCharge(String src){
	int i = iservice.countTableByColumn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",
			new WhereClause("AFF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("AFF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("AFF_DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

public int getAcPrqValChargeCsv(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//PRQ saisi par le AC
public int getAcPrqAffecteDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//PRQ validé par le Chef de Service
public int getAcPrqValidCsvDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//PRQ Transmis par le AC
public int getAcPrqTransmisDossier(String src){ 
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//PRQ en attente de transmission chez le AC
public int getAcPrqAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//DAO saisi par le CPMP
public int getPrqSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//PRQ non transmis par le cpmp
public int getPrqSaisieDossierIn(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;
}

//PRQ transmis par le cpmp
public int getPrqTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//PRQ retournés par le cpmp chez le AC
public int getPrqAttAffCsv(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//PRQ retournés par le cpmp chez le AC
public int getPrqDiffCpmpACDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//PRQ retournés par le dmp chez le AC
public int getPrqDiffDmpACDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
	        new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//PRQ retournés par la cpmp (Son propre tableau de bord)
public int getPrqDiffDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//PRQ retournés par le dmp
public int getPrqDiffDmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
	return	i;	
}


//PRQ en attente de validation par le CPMP
public int getPrqAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}

//PRQ en attente de retrait chez l'AC
public int getPrqAttenteRetrait(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
			"AFF_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"), 
			new WhereClause("AFF_DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//PRQ en attente de vente chez l'AC
public int getPrqAttenteVente(String src){
	int i = iservice.countTableByColumn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",
			new WhereClause("AFF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("AFF_DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//PRQ retiré chez l'AC
public int getPrqAcRetire(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//PRQ validés par le cpmp
public int getPrqValideCmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//PRQ validés par le dmp
public int getPrqValideDmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
}

//PRQ en attente de validation par le dmp
public int getPrqAttValideDmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
	return	i;	
}


//PRQ transmis par le dmp
public int getPrqTransmisDmpDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"PRQ"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}
//Fin PRQ




//Début AMI
//Nombre total des DAO
public int getAmiDossierTotal(){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE");
	new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI");
return	i;	
	} 
//AMI saisi par le AC
public int getAcAmiSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//AMI saisi par le AC en procédure simplifiée
public int getAcAmiSaisiePs(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//AMI en attente chez le chargé d'Etudes
public int getAcAmiAttenteCharge(String src){
	int i = iservice.countTableByColumn("V_DAO_CHARGE_ETUDE", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DCS_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//AMI validé par le chargé d'Etudes
public int getAcAmiValChargeDet(String src){
	int i = iservice.countTableByColumn("V_DAO_CHARGE_ETUDE", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DCS_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

public int getAcAmiValCharge(String src){
	int i = iservice.countTableByColumn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",
			new WhereClause("AFF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("AFF_OPE_MATRICULE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getOpeMatricule()),
			new WhereClause("AFF_DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

public int getAcAmiValChargeCsv(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//AMI saisi par le AC
public int getAcAmiAffecteDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//AMI validé par le Chef de Service
public int getAcAmiValidCsvDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//DAO Transmis par le AC
public int getAcAmiTransmisDossier(String src){ 
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//AMI en attente de transmission chez le AC
public int getAcAmiAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//AMI saisi par le CPMP
public int getAmiSaisieDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//AMI non transmis par le cpmp
public int getAmiSaisieDossierIn(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;
}

//AMI transmis par le cpmp
public int getAmiTransmisDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"));
			//new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//AMI retournés par le cpmp chez le AC
public int getAmiAttAffCsv(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//DAO retournés par le cpmp chez le AC
public int getAmiDiffCpmpACDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//AMI retournés par le dmp chez le AC
public int getAmiDiffDmpACDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
	        new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTOperateur().getTStructure().getStrCode()));
	return	i;	
}

//Ami retournés par le cpmp (Son propre tableau de bord)
public int getAmiDiffDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}

//AMI retournés par le dmp
public int getAmiDiffDmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
}


//AMI en attente de validation par le CPMP
public int getAmiAttenteValide(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_DAC_SPECS", "DAC_CODE",new ArrayList<String>(Arrays.asList("DAC_CODE")),
			"DAC_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;
}

//AMI en attente de retrait chez l'AC
public int getAmiAttenteRetrait(String src1, String src2){
	int i = iservice.countTableByColumnIn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",new ArrayList<String>(Arrays.asList("AFF_DAC_CODE")),
			"AFF_STA_CODE", new ArrayList<String>(Arrays.asList(src1,src2)),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("AFF_DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;
}


//AMI en attente de vente chez l'AC
public int getAmiAttenteVente(String src){
	int i = iservice.countTableByColumn("T_AFFICHAGE_DAO", "AFF_DAC_CODE",
			new WhereClause("AFF_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("AFF_DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("AFF_DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}

//AMI retiré chez l'AC
public int getAmiAcRetire(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_FON_COD_AC", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}


//AMI validés par le cpmp
public int getAmiValideCmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src),
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STR_CODE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
	return	i;	
}


//AMI validés par le dmp
public int getAmiValideDmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
}

//AMI en attente de validation par le dmp
public int getAmiAttValideDmp(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_TYPE_PLAN", WhereClause.Comparateur.EQ,"PN"));
	return	i;	
}


//AMI transmis par le dmp
public int getAmiTransmisDmpDossier(String src){
	int i = iservice.countTableByColumn("T_DAC_SPECS", "DAC_CODE",
			new WhereClause("DAC_TD_CODE", WhereClause.Comparateur.EQ,"AMI"),
			new WhereClause("DAC_STA_CODE", WhereClause.Comparateur.EQ, src));
			//new WhereClause("DPP_ACTEUR_SAISIE", WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
	return	i;	
}
//Fin AMI




	
	 public String renderPage(String value ,String action) throws IOException{ 
		 //controleController.redirectionDynamic(action);
		     switch(value) {
				case "pgpm1":
					
					break;
				case "pgpm2":
				
				break;
				case "pgpm3":
				break;
				case "pgpm4":

					break;
			    }
		     
		    return userController.renderPage(value);
		}








	public String getAgpmTotal() {
		return agpmTotal;
	}

	public void setAgpmTotal(String agpmTotal) {
		this.agpmTotal = agpmTotal;
	}

	
	
	
	public String getAgpmAcSaisies() {
		return agpmAcSaisies;
	}

	public void setAgpmAcSaisies(String agpmAcSaisies) {
		this.agpmAcSaisies = agpmAcSaisies;
	}


	public String getAgpmAcTransmis() {
		return agpmAcTransmis;
	}

	public void setAgpmAcTransmis(String agpmAcTransmis) {
		this.agpmAcTransmis = agpmAcTransmis;
	}


	public String getPgpmAcSaisie() {
		return pgpmAcSaisie;
	}

	public void setPgpmAcSaisie(String pgpmAcSaisie) {
		this.pgpmAcSaisie = pgpmAcSaisie;
	}


	public String getPgpmAcTransmis() {
		return pgpmAcTransmis;
	}

	public void setPgpmAcTransmis(String pgpmAcTransmis) {
		this.pgpmAcTransmis = pgpmAcTransmis;
	}


	public String getPgpmCpRetournes() {
		return pgpmCpRetournes;
	}

	public void setPgpmCpRetournes(String pgpmCpRetournes) {
		this.pgpmCpRetournes = pgpmCpRetournes;
	}


	public String getPgspmCpRetournes() {
		return pgspmCpRetournes;
	}

	public void setPgspmCpRetournes(String pgspmCpRetournes) {
		this.pgspmCpRetournes = pgspmCpRetournes;
	}



	public String getPgspmAcTransmis() {
		return pgspmAcTransmis;
	}

	public void setPgspmAcTransmis(String pgspmAcTransmis) {
		this.pgspmAcTransmis = pgspmAcTransmis;
	}




	public String getPgpmCpSaisie() {
		return pgpmCpSaisie;
	}




	public void setPgpmCpSaisie(String pgpmCpSaisie) {
		this.pgpmCpSaisie = pgpmCpSaisie;
	}




	public String getPgpmTotal() {
		return pgpmTotal;
	}




	public void setPgpmTotal(String pgpmTotal) {
		this.pgpmTotal = pgpmTotal;
	}




	public String getPgspmTotal() {
		return pgspmTotal;
	}




	public void setPgspmTotal(String pgspmTotal) {
		this.pgspmTotal = pgspmTotal;
	}


	public String getPgpmCpTransmis() {
		return pgpmCpTransmis;
	}


	public void setPgpmCpTransmis(String pgpmCpTransmis) {
		this.pgpmCpTransmis = pgpmCpTransmis;
	}


	public String getPgpmCpDifDmp() {
		return pgpmCpDifDmp;
	}


	public void setPgpmCpDifDmp(String pgpmCpDifDmp) {
		this.pgpmCpDifDmp = pgpmCpDifDmp;
	}


	public String getPgpmCpDifCpmp() {
		return pgpmCpDifCpmp;
	}


	public void setPgpmCpDifCpmp(String pgpmCpDifCpmp) {
		this.pgpmCpDifCpmp = pgpmCpDifCpmp;
	}


	public String getPgpmCpValide() {
		return pgpmCpValide;
	}


	public void setPgpmCpValide(String pgpmCpValide) {
		this.pgpmCpValide = pgpmCpValide;
	}


	public String getPgpmDmSaisie() {
		return pgpmDmSaisie;
	}


	public void setPgpmDmSaisie(String pgpmDmSaisie) {
		this.pgpmDmSaisie = pgpmDmSaisie;
	}


	public String getPgpmDmTransmis() {
		return pgpmDmTransmis;
	}


	public void setPgpmDmTransmis(String pgpmDmTransmis) {
		this.pgpmDmTransmis = pgpmDmTransmis;
	}


	public String getPgpmDmValide() {
		return pgpmDmValide;
	}


	public void setPgpmDmValide(String pgpmDmValide) {
		this.pgpmDmValide = pgpmDmValide;
	}


	public String getPgspmAcSaisie() {
		return pgspmAcSaisie;
	}


	public void setPgspmAcSaisie(String pgspmAcSaisie) {
		this.pgspmAcSaisie = pgspmAcSaisie;
	}


	public String getPgspmCpSaisie() {
		return pgspmCpSaisie;
	}


	public void setPgspmCpSaisie(String pgspmCpSaisie) {
		this.pgspmCpSaisie = pgspmCpSaisie;
	}


	public String getPgspmCpTransmis() {
		return pgspmCpTransmis;
	}


	public void setPgspmCpTransmis(String pgspmCpTransmis) {
		this.pgspmCpTransmis = pgspmCpTransmis;
	}


	public String getPgspmCpDifCpmp() {
		return pgspmCpDifCpmp;
	}


	public void setPgspmCpDifCpmp(String pgspmCpDifCpmp) {
		this.pgspmCpDifCpmp = pgspmCpDifCpmp;
	}


	public String getPgspmCpDifDmp() {
		return pgspmCpDifDmp;
	}


	public void setPgspmCpDifDmp(String pgspmCpDifDmp) {
		this.pgspmCpDifDmp = pgspmCpDifDmp;
	}


	public String getPgspmCpValide() {
		return pgspmCpValide;
	}


	public void setPgspmCpValide(String pgspmCpValide) {
		this.pgspmCpValide = pgspmCpValide;
	}


	public String getPgspmDmSaisie() {
		return pgspmDmSaisie;
	}


	public void setPgspmDmSaisie(String pgspmDmSaisie) {
		this.pgspmDmSaisie = pgspmDmSaisie;
	}


	public String getPgspmDmTransmis() {
		return pgspmDmTransmis;
	}


	public void setPgspmDmTransmis(String pgspmDmTransmis) {
		this.pgspmDmTransmis = pgspmDmTransmis;
	}


	public String getPgspmDmValide() {
		return pgspmDmValide;
	}


	public void setPgspmDmValide(String pgspmDmValide) {
		this.pgspmDmValide = pgspmDmValide;
	}


	public String getAgpmDmSaisie() {
		return agpmDmSaisie;
	}


	public void setAgpmDmSaisie(String agpmDmSaisie) {
		this.agpmDmSaisie = agpmDmSaisie;
	}


	public String getAgpmDmTransmis() {
		return agpmDmTransmis;
	}


	public void setAgpmDmTransmis(String agpmDmTransmis) {
		this.agpmDmTransmis = agpmDmTransmis;
	}


	public String getAgpmDmValide() {
		return agpmDmValide;
	}


	public void setAgpmDmValide(String agpmDmValide) {
		this.agpmDmValide = agpmDmValide;
	}


	public String getAgpmCpSaisie() {
		return agpmCpSaisie;
	}


	public void setAgpmCpSaisie(String agpmCpSaisie) {
		this.agpmCpSaisie = agpmCpSaisie;
	}


	public String getAgpmCpDifCpmp() {
		return agpmCpDifCpmp;
	}


	public void setAgpmCpDifCpmp(String agpmCpDifCpmp) {
		this.agpmCpDifCpmp = agpmCpDifCpmp;
	}


	public String getAgpmCpTransmis() {
		return agpmCpTransmis;
	}


	public void setAgpmCpTransmis(String agpmCpTransmis) {
		this.agpmCpTransmis = agpmCpTransmis;
	}


	public String getAgpmCpDifDmp() {
		return agpmCpDifDmp;
	}


	public void setAgpmCpDifDmp(String agpmCpDifDmp) {
		this.agpmCpDifDmp = agpmCpDifDmp;
	}


	public String getAgpmCpValide() {
		return agpmCpValide;
	}


	public void setAgpmCpValide(String agpmCpValide) {
		this.agpmCpValide = agpmCpValide;
	}


	public String getAgpmCpRetournes() {
		return agpmCpRetournes;
	}


	public void setAgpmCpRetournes(String agpmCpRetournes) {
		this.agpmCpRetournes = agpmCpRetournes;
	}


	public String getPgpmAttenteValide() {
		return pgpmAttenteValide;
	}


	public void setPgpmAttenteValide(String pgpmAttenteValide) {
		this.pgpmAttenteValide = pgpmAttenteValide;
	}




	public String getAgpmDmAttenteValide() {
		return agpmDmAttenteValide;
	}


	public void setAgpmDmAttenteValide(String agpmDmAttenteValide) {
		this.agpmDmAttenteValide = agpmDmAttenteValide;
	}




	public String getPgpmDmAttenteValide() {
		return pgpmDmAttenteValide;
	}


	public void setPgpmDmAttenteValide(String pgpmDmAttenteValide) {
		this.pgpmDmAttenteValide = pgpmDmAttenteValide;
	}




	public String getPgpmDmDiff() {
		return pgpmDmDiff;
	}


	public void setPgpmDmDiff(String pgpmDmDiff) {
		this.pgpmDmDiff = pgpmDmDiff;
	}




	public String getPgpmAcAttenteTransfert() {
		return pgpmAcAttenteTransfert;
	}


	public void setPgpmAcAttenteTransfert(String pgpmAcAttenteTransfert) {
		this.pgpmAcAttenteTransfert = pgpmAcAttenteTransfert;
	}




	public String getPgspmDmAttenteValide() {
		return pgspmDmAttenteValide;
	}




	public void setPgspmDmAttenteValide(String pgspmDmAttenteValide) {
		this.pgspmDmAttenteValide = pgspmDmAttenteValide;
	}




	public String getPgspmAcAttenteValide() {
		return pgspmAcAttenteValide;
	}


	public void setPgspmAcAttenteValide(String pgspmAcAttenteValide) {
		this.pgspmAcAttenteValide = pgspmAcAttenteValide;
	}




	public String getPgspmCpAttenteValide() {
		return pgspmCpAttenteValide;
	}

	public void setPgspmCpAttenteValide(String pgspmCpAttenteValide) {
		this.pgspmCpAttenteValide = pgspmCpAttenteValide;
	}




	public String getPgspmDmDiff() {
		return pgspmDmDiff;
	}


	public void setPgspmDmDiff(String pgspmDmDiff) {
		this.pgspmDmDiff = pgspmDmDiff;
	}




	public String getAgpmAcAttenteTransfert() {
		return agpmAcAttenteTransfert;
	}

	public void setAgpmAcAttenteTransfert(String agpmAcAttenteTransfert) {
		this.agpmAcAttenteTransfert = agpmAcAttenteTransfert;
	}


	public String getAgpmCpAttenteValide() {
		return agpmCpAttenteValide;
	}

	public void setAgpmCpAttenteValide(String agpmCpAttenteValide) {
		this.agpmCpAttenteValide = agpmCpAttenteValide;
	}

	public String getPpmTotal() {
		return ppmTotal;
	}




	public void setPpmTotal(String ppmTotal) {
		this.ppmTotal = ppmTotal;
	}


	public String getPpmAcSaisie() {
		return ppmAcSaisie;
	}




	public void setPpmAcSaisie(String ppmAcSaisie) {
		this.ppmAcSaisie = ppmAcSaisie;
	}


	public String getPpmCpRetournes() {
		return ppmCpRetournes;
	}




	public void setPpmCpRetournes(String ppmCpRetournes) {
		this.ppmCpRetournes = ppmCpRetournes;
	}

	public String getPpmAcTransmis() {
		return ppmAcTransmis;
	}




	public void setPpmAcTransmis(String ppmAcTransmis) {
		this.ppmAcTransmis = ppmAcTransmis;
	}

	public String getPpmAcAttenteValide() {
		return ppmAcAttenteValide;
	}




	public void setPpmAcAttenteValide(String ppmAcAttenteValide) {
		this.ppmAcAttenteValide = ppmAcAttenteValide;
	}


	public String getPpmCpSaisie() {
		return ppmCpSaisie;
	}




	public void setPpmCpSaisie(String ppmCpSaisie) {
		this.ppmCpSaisie = ppmCpSaisie;
	}

	public String getPpmCpTransmis() {
		return ppmCpTransmis;
	}




	public void setPpmCpTransmis(String ppmCpTransmis) {
		this.ppmCpTransmis = ppmCpTransmis;
	}


	public String getPpmCpDifCpmp() {
		return ppmCpDifCpmp;
	}


	public void setPpmCpDifCpmp(String ppmCpDifCpmp) {
		this.ppmCpDifCpmp = ppmCpDifCpmp;
	}




	public String getPpmCpDifDmp() {
		return ppmCpDifDmp;
	}


	public void setPpmCpDifDmp(String ppmCpDifDmp) {
		this.ppmCpDifDmp = ppmCpDifDmp;
	}



	public String getPpmCpValide() {
		return ppmCpValide;
	}


	public void setPpmCpValide(String ppmCpValide) {
		this.ppmCpValide = ppmCpValide;
	}


	public String getPpmCpAttenteValide() {
		return ppmCpAttenteValide;
	}




	public void setPpmCpAttenteValide(String ppmCpAttenteValide) {
		this.ppmCpAttenteValide = ppmCpAttenteValide;
	}


	public String getPpmDmSaisie() {
		return ppmDmSaisie;
	}




	public void setPpmDmSaisie(String ppmDmSaisie) {
		this.ppmDmSaisie = ppmDmSaisie;
	}


	public String getPpmDmTransmis() {
		return ppmDmTransmis;
	}




	public void setPpmDmTransmis(String ppmDmTransmis) {
		this.ppmDmTransmis = ppmDmTransmis;
	}


	public String getPpmDmValide() {
		return ppmDmValide;
	}




	public void setPpmDmValide(String ppmDmValide) {
		this.ppmDmValide = ppmDmValide;
	}


	public String getPpmDmAttenteValide() {
		return ppmDmAttenteValide;
	}


	public void setPpmDmAttenteValide(String ppmDmAttenteValide) {
		this.ppmDmAttenteValide = ppmDmAttenteValide;
	}



	public String getPpmDmDiff() {
		return ppmDmDiff;
	}

	public void setPpmDmDiff(String ppmDmDiff) {
		this.ppmDmDiff = ppmDmDiff;
	}


	public String getAgpmCpDifDmpCpmp() {
		return agpmCpDifDmpCpmp;
	}

	public void setAgpmCpDifDmpCpmp(String agpmCpDifDmpCpmp) {
		this.agpmCpDifDmpCpmp = agpmCpDifDmpCpmp;
	}



	public String getAgpmCpmDiffAc() {
		return agpmCpmDiffAc;
	}

	public void setAgpmCpmDiffAc(String agpmCpmDiffAc) {
		this.agpmCpmDiffAc = agpmCpmDiffAc;
	}




	public String getAgpmDmDiffAc() {
		return agpmDmDiffAc;
	}


	public void setAgpmDmDiffAc(String agpmDmDiffAc) {
		this.agpmDmDiffAc = agpmDmDiffAc;
	}




	public String getPgspmAcDifDmp() {
		return pgspmAcDifDmp;
	}




	public void setPgspmAcDifDmp(String pgspmAcDifDmp) {
		this.pgspmAcDifDmp = pgspmAcDifDmp;
	}




	public String getPgpmAcDiffDmp() {
		return pgpmAcDiffDmp;
	}


	public void setPgpmAcDiffDmp(String pgpmAcDiffDmp) {
		this.pgpmAcDiffDmp = pgpmAcDiffDmp;
	}




	public String getPpmAcDiffCpmp() {
		return ppmAcDiffCpmp;
	}


	public void setPpmAcDiffCpmp(String ppmAcDiffCpmp) {
		this.ppmAcDiffCpmp = ppmAcDiffCpmp;
	}




	public String getPpmAcDiffDmp() {
		return ppmAcDiffDmp;
	}

	public void setPpmAcDiffDmp(String ppmAcDiffDmp) {
		this.ppmAcDiffDmp = ppmAcDiffDmp;
	}




	public String getPgpmCpRetAc() {
		return pgpmCpRetAc;
	}


	public void setPgpmCpRetAc(String pgpmCpRetAc) {
		this.pgpmCpRetAc = pgpmCpRetAc;
	}




	public String getPspmTotal() {
		return pspmTotal;
	}




	public void setPspmTotal(String pspmTotal) {
		this.pspmTotal = pspmTotal;
	}




	public String getPspmAcSaisie() {
		return pspmAcSaisie;
	}




	public void setPspmAcSaisie(String pspmAcSaisie) {
		this.pspmAcSaisie = pspmAcSaisie;
	}




	public String getPspmCpRetournes() {
		return pspmCpRetournes;
	}




	public void setPspmCpRetournes(String pspmCpRetournes) {
		this.pspmCpRetournes = pspmCpRetournes;
	}




	public String getPspmAcTransmis() {
		return pspmAcTransmis;
	}




	public void setPspmAcTransmis(String pspmAcTransmis) {
		this.pspmAcTransmis = pspmAcTransmis;
	}




	public String getPspmAcAttenteValide() {
		return pspmAcAttenteValide;
	}




	public void setPspmAcAttenteValide(String pspmAcAttenteValide) {
		this.pspmAcAttenteValide = pspmAcAttenteValide;
	}




	public String getPspmAcDiffCpmp() {
		return pspmAcDiffCpmp;
	}




	public void setPspmAcDiffCpmp(String pspmAcDiffCpmp) {
		this.pspmAcDiffCpmp = pspmAcDiffCpmp;
	}




	public String getPspmAcDiffDmp() {
		return pspmAcDiffDmp;
	}




	public void setPspmAcDiffDmp(String pspmAcDiffDmp) {
		this.pspmAcDiffDmp = pspmAcDiffDmp;
	}




	public String getPspmCpSaisie() {
		return pspmCpSaisie;
	}




	public void setPspmCpSaisie(String pspmCpSaisie) {
		this.pspmCpSaisie = pspmCpSaisie;
	}




	public String getPspmCpTransmis() {
		return pspmCpTransmis;
	}




	public void setPspmCpTransmis(String pspmCpTransmis) {
		this.pspmCpTransmis = pspmCpTransmis;
	}




	public String getPspmCpDifCpmp() {
		return pspmCpDifCpmp;
	}




	public void setPspmCpDifCpmp(String pspmCpDifCpmp) {
		this.pspmCpDifCpmp = pspmCpDifCpmp;
	}




	public String getPspmCpDifDmp() {
		return pspmCpDifDmp;
	}




	public void setPspmCpDifDmp(String pspmCpDifDmp) {
		this.pspmCpDifDmp = pspmCpDifDmp;
	}




	public String getPspmCpValide() {
		return pspmCpValide;
	}




	public void setPspmCpValide(String pspmCpValide) {
		this.pspmCpValide = pspmCpValide;
	}




	public String getPspmCpAttenteValide() {
		return pspmCpAttenteValide;
	}




	public void setPspmCpAttenteValide(String pspmCpAttenteValide) {
		this.pspmCpAttenteValide = pspmCpAttenteValide;
	}




	public String getPspmDmSaisie() {
		return pspmDmSaisie;
	}




	public void setPspmDmSaisie(String pspmDmSaisie) {
		this.pspmDmSaisie = pspmDmSaisie;
	}




	public String getPspmDmTransmis() {
		return pspmDmTransmis;
	}




	public void setPspmDmTransmis(String pspmDmTransmis) {
		this.pspmDmTransmis = pspmDmTransmis;
	}




	public String getPspmDmValide() {
		return pspmDmValide;
	}




	public void setPspmDmValide(String pspmDmValide) {
		this.pspmDmValide = pspmDmValide;
	}




	public String getPspmDmAttenteValide() {
		return pspmDmAttenteValide;
	}

	public void setPspmDmAttenteValide(String pspmDmAttenteValide) {
		this.pspmDmAttenteValide = pspmDmAttenteValide;
	}




	public String getPspmDmDiff() {
		return pspmDmDiff;
	}


	public void setPspmDmDiff(String pspmDmDiff) {
		this.pspmDmDiff = pspmDmDiff;
	}




	public String getPgspmAcDiffCpmp() {
		return pgspmAcDiffCpmp;
	}


	public void setPgspmAcDiffCpmp(String pgspmAcDiffCpmp) {
		this.pgspmAcDiffCpmp = pgspmAcDiffCpmp;
	}




	public String getDaoTotal() {
		return daoTotal;
	}




	public void setDaoTotal(String daoTotal) {
		this.daoTotal = daoTotal;
	}




	public String getDaoAcSaisie() {
		return daoAcSaisie;
	}




	public void setDaoAcSaisie(String daoAcSaisie) {
		this.daoAcSaisie = daoAcSaisie;
	}




	public String getDaoCpRetournes() {
		return daoCpRetournes;
	}




	public void setDaoCpRetournes(String daoCpRetournes) {
		this.daoCpRetournes = daoCpRetournes;
	}




	public String getDaoAcTransmis() {
		return daoAcTransmis;
	}




	public void setDaoAcTransmis(String daoAcTransmis) {
		this.daoAcTransmis = daoAcTransmis;
	}




	public String getDaoAcAttenteValide() {
		return daoAcAttenteValide;
	}




	public void setDaoAcAttenteValide(String daoAcAttenteValide) {
		this.daoAcAttenteValide = daoAcAttenteValide;
	}




	public String getDaoAcDiffCpmp() {
		return daoAcDiffCpmp;
	}




	public void setDaoAcDiffCpmp(String daoAcDiffCpmp) {
		this.daoAcDiffCpmp = daoAcDiffCpmp;
	}




	public String getDaoAcDiffDmp() {
		return daoAcDiffDmp;
	}




	public void setDaoAcDiffDmp(String daoAcDiffDmp) {
		this.daoAcDiffDmp = daoAcDiffDmp;
	}




	public String getDaoaffecte() {
		return daoaffecte;
	}

	public void setDaoaffecte(String daoaffecte) {
		this.daoaffecte = daoaffecte;
	}


	public String getDaoCsvValide() {
		return daoCsvValide;
	}


	public void setDaoCsvValide(String daoCsvValide) {
		this.daoCsvValide = daoCsvValide;
	}
	

	public String getDaoChargeAttente() {
		return daoChargeAttente;
	}

	public void setDaoChargeAttente(String daoChargeAttente) {
		this.daoChargeAttente = daoChargeAttente;
	}

	public String getDaoChargeVal() {
		return daoChargeVal;
	}

	public void setDaoChargeVal(String daoChargeVal) {
		this.daoChargeVal = daoChargeVal;
	}

	public String getDaoCsvTraitCharg() {
		return daoCsvTraitCharg;
	}

	public void setDaoCsvTraitCharg(String daoCsvTraitCharg) {
		this.daoCsvTraitCharg = daoCsvTraitCharg;
	}

	public String getDaoCsvDiff() {
		return daoCsvDiff;
	}

	public void setDaoCsvDiff(String daoCsvDiff) {
		this.daoCsvDiff = daoCsvDiff;
	}

	public String getDaoCsvgeAffecte() {
		return daoCsvgeAffecte;
	}

	public void setDaoCsvgeAffecte(String daoCsvgeAffecte) {
		this.daoCsvgeAffecte = daoCsvgeAffecte;
	}

	public String getDaoCsvAttAff() {
		return daoCsvAttAff;
	}

	public void setDaoCsvAttAff(String daoCsvAttAff) {
		this.daoCsvAttAff = daoCsvAttAff;
	}

	public String getDaoCpSaisie() {
		return daoCpSaisie;
	}

	public void setDaoCpSaisie(String daoCpSaisie) {
		this.daoCpSaisie = daoCpSaisie;
	}

	public String getDaoCpValide() {
		return daoCpValide;
	}

	public void setDaoCpValide(String daoCpValide) {
		this.daoCpValide = daoCpValide;
	}

	public String getDaoCsvAttVal() {
		return daoCsvAttVal;
	}

	public void setDaoCsvAttVal(String daoCsvAttVal) {
		this.daoCsvAttVal = daoCsvAttVal;
	}

	public String getDaoAcAttRetrait() {
		return daoAcAttRetrait;
	}

	public void setDaoAcAttRetrait(String daoAcAttRetrait) {
		this.daoAcAttRetrait = daoAcAttRetrait;
	}

	public String getDaoAcRetire() {
		return daoAcRetire;
	}

	public void setDaoAcRetire(String daoAcRetire) {
		this.daoAcRetire = daoAcRetire;
	}

	public String getDaoAcAttVente() {
		return daoAcAttVente;
	}

	public void setDaoAcAttVente(String daoAcAttVente) {
		this.daoAcAttVente = daoAcAttVente;
	}

	public String getDaoAcPs() {
		return daoAcPs;
	}

	public void setDaoAcPs(String daoAcPs) {
		this.daoAcPs = daoAcPs;
	}

	public String getAgpmAcDifDmpCpmp() {
		return agpmAcDifDmpCpmp;
	}

	public void setAgpmAcDifDmpCpmp(String agpmAcDifDmpCpmp) {
		this.agpmAcDifDmpCpmp = agpmAcDifDmpCpmp;
	}

	public String getPgpmAcDiffDmpCpmp() {
		return pgpmAcDiffDmpCpmp;
	}

	public void setPgpmAcDiffDmpCpmp(String pgpmAcDiffDmpCpmp) {
		this.pgpmAcDiffDmpCpmp = pgpmAcDiffDmpCpmp;
	}

	public String getDaoChargeCor() {
		return daoChargeCor;
	}

	public void setDaoChargeCor(String daoChargeCor) {
		this.daoChargeCor = daoChargeCor;
	}
	
	public String getAmiAcSaisie() {
		return amiAcSaisie;
	}

	public void setAmiAcSaisie(String amiAcSaisie) {
		this.amiAcSaisie = amiAcSaisie;
	}

	public String getAmiAcPs() {
		return amiAcPs;
	}

	public void setAmiAcPs(String amiAcPs) {
		this.amiAcPs = amiAcPs;
	}

	public String getAmiCpRetournes() {
		return amiCpRetournes;
	}

	public void setAmiCpRetournes(String amiCpRetournes) {
		this.amiCpRetournes = amiCpRetournes;
	}

	public String getAmiAcTransmis() {
		return amiAcTransmis;
	}

	public void setAmiAcTransmis(String amiAcTransmis) {
		this.amiAcTransmis = amiAcTransmis;
	}

	public String getAmiAcAttenteValide() {
		return amiAcAttenteValide;
	}

	public void setAmiAcAttenteValide(String amiAcAttenteValide) {
		this.amiAcAttenteValide = amiAcAttenteValide;
	}

	public String getAmiAcDiffCpmp() {
		return amiAcDiffCpmp;
	}

	public void setAmiAcDiffCpmp(String amiAcDiffCpmp) {
		this.amiAcDiffCpmp = amiAcDiffCpmp;
	}

	public String getAmiAcDiffDmp() {
		return amiAcDiffDmp;
	}

	public void setAmiAcDiffDmp(String amiAcDiffDmp) {
		this.amiAcDiffDmp = amiAcDiffDmp;
	}

	public String getAmiAcAttRetrait() {
		return amiAcAttRetrait;
	}

	public void setAmiAcAttRetrait(String amiAcAttRetrait) {
		this.amiAcAttRetrait = amiAcAttRetrait;
	}

	public String getAmiAcAttVente() {
		return amiAcAttVente;
	}

	public void setAmiAcAttVente(String amiAcAttVente) {
		this.amiAcAttVente = amiAcAttVente;
	}

	public String getAmiAcRetire() {
		return amiAcRetire;
	}

	public void setAmiAcRetire(String amiAcRetire) {
		this.amiAcRetire = amiAcRetire;
	}

	public String getAmiCpSaisie() {
		return amiCpSaisie;
	}

	public void setAmiCpSaisie(String amiCpSaisie) {
		this.amiCpSaisie = amiCpSaisie;
	}

	public String getAmiCpTransmis() {
		return amiCpTransmis;
	}

	public void setAmiCpTransmis(String amiCpTransmis) {
		this.amiCpTransmis = amiCpTransmis;
	}

	public String getAmiCpDifCpmp() {
		return amiCpDifCpmp;
	}

	public void setAmiCpDifCpmp(String amiCpDifCpmp) {
		this.amiCpDifCpmp = amiCpDifCpmp;
	}

	public String getAmiCpDifDmp() {
		return amiCpDifDmp;
	}

	public void setAmiCpDifDmp(String amiCpDifDmp) {
		this.amiCpDifDmp = amiCpDifDmp;
	}

	public String getAmiCpValide() {
		return amiCpValide;
	}

	public void setAmiCpValide(String amiCpValide) {
		this.amiCpValide = amiCpValide;
	}

	public String getAmiCpAttenteValide() {
		return amiCpAttenteValide;
	}

	public void setAmiCpAttenteValide(String amiCpAttenteValide) {
		this.amiCpAttenteValide = amiCpAttenteValide;
	}

	public String getAmiaffecte() {
		return amiaffecte;
	}

	public void setAmiaffecte(String amiaffecte) {
		this.amiaffecte = amiaffecte;
	}

	public String getAmiChargeAttente() {
		return amiChargeAttente;
	}

	public void setAmiChargeAttente(String amiChargeAttente) {
		this.amiChargeAttente = amiChargeAttente;
	}

	public String getAmiChargeVal() {
		return amiChargeVal;
	}

	public void setAmiChargeVal(String amiChargeVal) {
		this.amiChargeVal = amiChargeVal;
	}

	public String getAmiCsvAttVal() {
		return amiCsvAttVal;
	}

	public void setAmiCsvAttVal(String amiCsvAttVal) {
		this.amiCsvAttVal = amiCsvAttVal;
	}

	public String getAmiCsvAttAff() {
		return amiCsvAttAff;
	}

	public void setAmiCsvAttAff(String amiCsvAttAff) {
		this.amiCsvAttAff = amiCsvAttAff;
	}

	public String getAmiCsvgeAffecte() {
		return amiCsvgeAffecte;
	}

	public void setAmiCsvgeAffecte(String amiCsvgeAffecte) {
		this.amiCsvgeAffecte = amiCsvgeAffecte;
	}

	public String getAmiCsvValide() {
		return amiCsvValide;
	}

	public void setAmiCsvValide(String amiCsvValide) {
		this.amiCsvValide = amiCsvValide;
	}

	public String getAmiCsvDiff() {
		return amiCsvDiff;
	}

	public void setAmiCsvDiff(String amiCsvDiff) {
		this.amiCsvDiff = amiCsvDiff;
	}

	public String getAmiCsvTraitCharg() {
		return amiCsvTraitCharg;
	}

	public void setAmiCsvTraitCharg(String amiCsvTraitCharg) {
		this.amiCsvTraitCharg = amiCsvTraitCharg;
	}

	public String getAmiTotal() {
		return amiTotal;
	}

	public void setAmiTotal(String amiTotal) {
		this.amiTotal = amiTotal;
	}

	public String getDaoCpTransmis() {
		return daoCpTransmis;
	}

	public void setDaoCpTransmis(String daoCpTransmis) {
		this.daoCpTransmis = daoCpTransmis;
	}

	public String getDaoCpDifCpmp() {
		return daoCpDifCpmp;
	}

	public void setDaoCpDifCpmp(String daoCpDifCpmp) {
		this.daoCpDifCpmp = daoCpDifCpmp;
	}

	public String getDaoCpDifDmp() {
		return daoCpDifDmp;
	}

	public void setDaoCpDifDmp(String daoCpDifDmp) {
		this.daoCpDifDmp = daoCpDifDmp;
	}

	public String getDaoCpAttenteValide() {
		return daoCpAttenteValide;
	}

	public void setDaoCpAttenteValide(String daoCpAttenteValide) {
		this.daoCpAttenteValide = daoCpAttenteValide;
	}

	public String getPrqTotal() {
		return prqTotal;
	}

	public void setPrqTotal(String prqTotal) {
		this.prqTotal = prqTotal;
	}

	public String getPrqAcSaisie() {
		return prqAcSaisie;
	}

	public void setPrqAcSaisie(String prqAcSaisie) {
		this.prqAcSaisie = prqAcSaisie;
	}

	public String getPrqAcPs() {
		return prqAcPs;
	}

	public void setPrqAcPs(String prqAcPs) {
		this.prqAcPs = prqAcPs;
	}

	public String getPrqCpRetournes() {
		return prqCpRetournes;
	}

	public void setPrqCpRetournes(String prqCpRetournes) {
		this.prqCpRetournes = prqCpRetournes;
	}

	public String getPrqAcTransmis() {
		return prqAcTransmis;
	}

	public void setPrqAcTransmis(String prqAcTransmis) {
		this.prqAcTransmis = prqAcTransmis;
	}

	public String getPrqAcAttenteValide() {
		return prqAcAttenteValide;
	}

	public void setPrqAcAttenteValide(String prqAcAttenteValide) {
		this.prqAcAttenteValide = prqAcAttenteValide;
	}

	public String getPrqAcDiffCpmp() {
		return prqAcDiffCpmp;
	}

	public void setPrqAcDiffCpmp(String prqAcDiffCpmp) {
		this.prqAcDiffCpmp = prqAcDiffCpmp;
	}

	public String getPrqAcDiffDmp() {
		return prqAcDiffDmp;
	}

	public void setPrqAcDiffDmp(String prqAcDiffDmp) {
		this.prqAcDiffDmp = prqAcDiffDmp;
	}

	public String getPrqAcAttRetrait() {
		return prqAcAttRetrait;
	}

	public void setPrqAcAttRetrait(String prqAcAttRetrait) {
		this.prqAcAttRetrait = prqAcAttRetrait;
	}

	public String getPrqAcAttVente() {
		return prqAcAttVente;
	}

	public void setPrqAcAttVente(String prqAcAttVente) {
		this.prqAcAttVente = prqAcAttVente;
	}

	public String getPrqAcRetire() {
		return prqAcRetire;
	}

	public void setPrqAcRetire(String prqAcRetire) {
		this.prqAcRetire = prqAcRetire;
	}

	public String getPrqCpSaisie() {
		return prqCpSaisie;
	}

	public void setPrqCpSaisie(String prqCpSaisie) {
		this.prqCpSaisie = prqCpSaisie;
	}

	public String getPrqCpTransmis() {
		return prqCpTransmis;
	}

	public void setPrqCpTransmis(String prqCpTransmis) {
		this.prqCpTransmis = prqCpTransmis;
	}

	public String getPrqCpDifCpmp() {
		return prqCpDifCpmp;
	}

	public void setPrqCpDifCpmp(String prqCpDifCpmp) {
		this.prqCpDifCpmp = prqCpDifCpmp;
	}

	public String getPrqCpDifDmp() {
		return prqCpDifDmp;
	}

	public void setPrqCpDifDmp(String prqCpDifDmp) {
		this.prqCpDifDmp = prqCpDifDmp;
	}

	public String getPrqCpValide() {
		return prqCpValide;
	}

	public void setPrqCpValide(String prqCpValide) {
		this.prqCpValide = prqCpValide;
	}

	public String getPrqCpAttenteValide() {
		return prqCpAttenteValide;
	}

	public void setPrqCpAttenteValide(String prqCpAttenteValide) {
		this.prqCpAttenteValide = prqCpAttenteValide;
	}

	public String getPrqaffecte() {
		return prqaffecte;
	}

	public void setPrqaffecte(String prqaffecte) {
		this.prqaffecte = prqaffecte;
	}

	public String getPrqChargeAttente() {
		return prqChargeAttente;
	}

	public void setPrqChargeAttente(String prqChargeAttente) {
		this.prqChargeAttente = prqChargeAttente;
	}

	public String getPrqChargeVal() {
		return prqChargeVal;
	}

	public void setPrqChargeVal(String prqChargeVal) {
		this.prqChargeVal = prqChargeVal;
	}

	public String getPrqChargeCor() {
		return prqChargeCor;
	}

	public void setPrqChargeCor(String prqChargeCor) {
		this.prqChargeCor = prqChargeCor;
	}

	public String getPrqCsvAttVal() {
		return prqCsvAttVal;
	}

	public void setPrqCsvAttVal(String prqCsvAttVal) {
		this.prqCsvAttVal = prqCsvAttVal;
	}

	public String getPrqCsvAttAff() {
		return prqCsvAttAff;
	}

	public void setPrqCsvAttAff(String prqCsvAttAff) {
		this.prqCsvAttAff = prqCsvAttAff;
	}

	public String getPrqCsvgeAffecte() {
		return prqCsvgeAffecte;
	}

	public void setPrqCsvgeAffecte(String prqCsvgeAffecte) {
		this.prqCsvgeAffecte = prqCsvgeAffecte;
	}

	public String getPrqCsvValide() {
		return prqCsvValide;
	}

	public void setPrqCsvValide(String prqCsvValide) {
		this.prqCsvValide = prqCsvValide;
	}

	public String getPrqCsvDiff() {
		return prqCsvDiff;
	}

	public void setPrqCsvDiff(String prqCsvDiff) {
		this.prqCsvDiff = prqCsvDiff;
	}

	public String getPrqCsvTraitCharg() {
		return prqCsvTraitCharg;
	}

	public void setPrqCsvTraitCharg(String prqCsvTraitCharg) {
		this.prqCsvTraitCharg = prqCsvTraitCharg;
	}

	public String getDaoPriseTrait() {
		return daoPriseTrait;
	}

	public void setDaoPriseTrait(String daoPriseTrait) {
		this.daoPriseTrait = daoPriseTrait;
	}

	public String getDaoAcSaisiePs() {
		return daoAcSaisiePs;
	}

	public void setDaoAcSaisiePs(String daoAcSaisiePs) {
		this.daoAcSaisiePs = daoAcSaisiePs;
	}

	public String getDaoAcPsPs() {
		return daoAcPsPs;
	}

	public void setDaoAcPsPs(String daoAcPsPs) {
		this.daoAcPsPs = daoAcPsPs;
	}

	public String getDaoCpRetournesPs() {
		return daoCpRetournesPs;
	}

	public void setDaoCpRetournesPs(String daoCpRetournesPs) {
		this.daoCpRetournesPs = daoCpRetournesPs;
	}

	public String getDaoAcTransmisPs() {
		return daoAcTransmisPs;
	}

	public void setDaoAcTransmisPs(String daoAcTransmisPs) {
		this.daoAcTransmisPs = daoAcTransmisPs;
	}

	public String getDaoAcAttenteValidePs() {
		return daoAcAttenteValidePs;
	}

	public void setDaoAcAttenteValidePs(String daoAcAttenteValidePs) {
		this.daoAcAttenteValidePs = daoAcAttenteValidePs;
	}

	public String getDaoAcDiffCpmpPs() {
		return daoAcDiffCpmpPs;
	}

	public void setDaoAcDiffCpmpPs(String daoAcDiffCpmpPs) {
		this.daoAcDiffCpmpPs = daoAcDiffCpmpPs;
	}

	public String getDaoAcDiffDmpPs() {
		return daoAcDiffDmpPs;
	}

	public void setDaoAcDiffDmpPs(String daoAcDiffDmpPs) {
		this.daoAcDiffDmpPs = daoAcDiffDmpPs;
	}

	public String getDaoAcAttRetraitPs() {
		return daoAcAttRetraitPs;
	}

	public void setDaoAcAttRetraitPs(String daoAcAttRetraitPs) {
		this.daoAcAttRetraitPs = daoAcAttRetraitPs;
	}

	public String getDaoAcAttVentePs() {
		return daoAcAttVentePs;
	}

	public void setDaoAcAttVentePs(String daoAcAttVentePs) {
		this.daoAcAttVentePs = daoAcAttVentePs;
	}

	public String getDaoAcRetirePs() {
		return daoAcRetirePs;
	}

	public void setDaoAcRetirePs(String daoAcRetirePs) {
		this.daoAcRetirePs = daoAcRetirePs;
	}

	public String getDaoCpSaisiePs() {
		return daoCpSaisiePs;
	}

	public void setDaoCpSaisiePs(String daoCpSaisiePs) {
		this.daoCpSaisiePs = daoCpSaisiePs;
	}

	public String getDaoCpTransmisPs() {
		return daoCpTransmisPs;
	}

	public void setDaoCpTransmisPs(String daoCpTransmisPs) {
		this.daoCpTransmisPs = daoCpTransmisPs;
	}

	public String getDaoCpDifCpmpPs() {
		return daoCpDifCpmpPs;
	}

	public void setDaoCpDifCpmpPs(String daoCpDifCpmpPs) {
		this.daoCpDifCpmpPs = daoCpDifCpmpPs;
	}

	public String getDaoCpDifDmpPs() {
		return daoCpDifDmpPs;
	}

	public void setDaoCpDifDmpPs(String daoCpDifDmpPs) {
		this.daoCpDifDmpPs = daoCpDifDmpPs;
	}

	public String getDaoCpValidePs() {
		return daoCpValidePs;
	}

	public void setDaoCpValidePs(String daoCpValidePs) {
		this.daoCpValidePs = daoCpValidePs;
	}

	public String getDaoCpAttenteValidePs() {
		return daoCpAttenteValidePs;
	}

	public void setDaoCpAttenteValidePs(String daoCpAttenteValidePs) {
		this.daoCpAttenteValidePs = daoCpAttenteValidePs;
	}

	public String getDaoPriseTraitPs() {
		return daoPriseTraitPs;
	}

	public void setDaoPriseTraitPs(String daoPriseTraitPs) {
		this.daoPriseTraitPs = daoPriseTraitPs;
	}

	public String getDaoaffectePs() {
		return daoaffectePs;
	}

	public void setDaoaffectePs(String daoaffectePs) {
		this.daoaffectePs = daoaffectePs;
	}

	public String getDaoChargeAttentePs() {
		return daoChargeAttentePs;
	}

	public void setDaoChargeAttentePs(String daoChargeAttentePs) {
		this.daoChargeAttentePs = daoChargeAttentePs;
	}

	public String getDaoChargeValPs() {
		return daoChargeValPs;
	}

	public void setDaoChargeValPs(String daoChargeValPs) {
		this.daoChargeValPs = daoChargeValPs;
	}

	public String getDaoChargeCorPs() {
		return daoChargeCorPs;
	}

	public void setDaoChargeCorPs(String daoChargeCorPs) {
		this.daoChargeCorPs = daoChargeCorPs;
	}

	public String getDaoCsvAttValPs() {
		return daoCsvAttValPs;
	}

	public void setDaoCsvAttValPs(String daoCsvAttValPs) {
		this.daoCsvAttValPs = daoCsvAttValPs;
	}

	public String getDaoCsvAttAffPs() {
		return daoCsvAttAffPs;
	}

	public void setDaoCsvAttAffPs(String daoCsvAttAffPs) {
		this.daoCsvAttAffPs = daoCsvAttAffPs;
	}

	public String getDaoCsvgeAffectePs() {
		return daoCsvgeAffectePs;
	}

	public void setDaoCsvgeAffectePs(String daoCsvgeAffectePs) {
		this.daoCsvgeAffectePs = daoCsvgeAffectePs;
	}

	public String getDaoCsvValidePs() {
		return daoCsvValidePs;
	}

	public void setDaoCsvValidePs(String daoCsvValidePs) {
		this.daoCsvValidePs = daoCsvValidePs;
	}

	public String getDaoCsvDiffPs() {
		return daoCsvDiffPs;
	}

	public void setDaoCsvDiffPs(String daoCsvDiffPs) {
		this.daoCsvDiffPs = daoCsvDiffPs;
	}

	public String getDaoCsvTraitChargPs() {
		return daoCsvTraitChargPs;
	}

	public void setDaoCsvTraitChargPs(String daoCsvTraitChargPs) {
		this.daoCsvTraitChargPs = daoCsvTraitChargPs;
	}

	public String getDaoDaoPub() {
		return daoDaoPub;
	}

	public void setDaoDaoPub(String daoDaoPub) {
		this.daoDaoPub = daoDaoPub;
	}

	public String getDaoDaoPubPs() {
		return daoDaoPubPs;
	}

	public void setDaoDaoPubPs(String daoDaoPubPs) {
		this.daoDaoPubPs = daoDaoPubPs;
	}

	public String getDaoTotalPs() {
		return daoTotalPs;
	}

	public void setDaoTotalPs(String daoTotalPs) {
		this.daoTotalPs = daoTotalPs;
	}

	public String getPgspmAcDiffDmpCpmp() {
		return pgspmAcDiffDmpCpmp;
	}

	public void setPgspmAcDiffDmpCpmp(String pgspmAcDiffDmpCpmp) {
		this.pgspmAcDiffDmpCpmp = pgspmAcDiffDmpCpmp;
	}

	
	
}