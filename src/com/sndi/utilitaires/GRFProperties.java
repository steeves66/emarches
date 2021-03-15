package com.sndi.utilitaires;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.log4j.Logger;

public class GRFProperties {
	private static Logger _log = Logger.getLogger(GRFProperties.class);
	private static ResourceBundle _properties = null;



	private static final String PROPERTIES_RESOURCE = "sigmicap".intern();
	
	
	//---- VARIABLES GLOBALES ----//
	public static final String PARAM_HOST = getProperty("PARAM_HOST", "");
	public static final String PARAM_SID = getProperty("PARAM_SID", "");
	public static final String PARAM_USERNAME = getProperty("PARAM_USERNAME", "");
	public static final String PARAM_PASSWORD = getProperty("PARAM_PASSWORD", "");
	
	//---- VARIABLES EMAIL ----//
	public static final String EMAIL_HOST = getProperty("EMAIL_HOST", "");
	public static final String EMAIL_PORT = getProperty("EMAIL_PORT", "");
	public static final String EMAIL_TSL_ENABLE = getProperty("EMAIL_TSL_ENABLE", "");
	public static final String EMAIL_AUTH = getProperty("EMAIL_AUTH", "");
	public static final String EMAIL_FROM = getProperty("EMAIL_FROM", "");
	public static final String EMAIL_PASSWORD = getProperty("EMAIL_PASSWORD", "");
	
	// Properties TypeFonction
	public static final String TYPE_FONCTION_ADM = getProperty("TYPE_FONCTION_ADM", "ADM");
	public static final String TYPE_FONCTION_GRF = getProperty("TYPE_FONCTION_GRF", "GRF");
	public static final String TYPE_FONCTION_MAG = getProperty("TYPE_FONCTION_MAG", "MAG");
	public static final String TYPE_FONCTION_SMA = getProperty("TYPE_FONCTION_SMA", "SMA");
	
	public static final String TYPE_FONCTION_CF = "CF";
	public static final String TYPE_MISSION_CONJOINT = "C";
	public static final String TYPE_MISSION_INTERNE = "I";
	public static final String TYPE_LBE_PRINCIPALE = "P";
	public static final String TYPE_LBE_SECONDAIRE = "S";
	public static final String ETAT_CREER = "CREER";
	public static final String ETAT_PREPARATION = "ETAT_PREPARATION";
	public static final String ETAT_DIFFUSION = "ETAT_DIFFUSION";
	public static final String ETAT_DEROULEMENT = "ETAT_DEROULEMENT";
	public static final String ETAT_UTILISER = "UTILISER";
	public static final String ETAT_TERMINER = "TERMINER";
	public static final String ETAT_ACTIVER = "1";
	public static final String ETAT_DESACTIVER = "0";
	public static final String ETAT_OUI = "O";
	public static final String ETAT_NON = "N";
	public static final String ETAT_VEROUILLE = "V";
	public static final String ENVELOPPE_TRANP = "6283";
	public static final String ENVELOPPE_IND = "6284";

	
	public static final String MODE_CREER = "CREATE";
	public static final String MODE_MODIFIER = "UPDATE";
	public static final String MODE_AFFICHER = "DISPLAY";

	//public static final String TYPE_FONCTION_ACR = "ACR";
	
	// Properties TypeEmploye
	public static final String TYPE_EMPLOYE_MAJ = getProperty("TYPE_EMPLOYE_MAJ", "MAJ");
	public static final String TYPE_EMPLOYE_GRF = getProperty("TYPE_EMPLOYE_GRF", "GRF");
	public static final String TYPE_EMPLOYE_AUD = getProperty("TYPE_EMPLOYE_AUD", "AUD");
	
	//Properties Fonction
	public static final String FON_COD_SIZE_PSEUDO = getProperty("FON_COD_SIZE_PSEUDO", "6"); 
	public static final String FON_COD_SIZE = getProperty("FON_COD_SIZE", "12"); 
		
	
	// SYS_TRAITEMENT
	public static final String SYT_TYPE_MODULE = getProperty("SYT_TYPE_MODULE", "GRPMENU"); 
	public static final String SYT_TYPE_TRAITEMENT = getProperty("SYT_TYPE_TRAITEMENT", "TRT"); 
	public static final Long SYT_DISPLAYABLE_0 = new Long(getProperty("SYT_DISPLAYABLE_0", "0")); 
	public static final Long SYT_DISPLAYABLE_1 = new Long(getProperty("SYT_DISPLAYABLE_1", "1")); 
	public static final String SYT_PATH_INDEX_EMPLOYES = getProperty("SYT_PATH_INDEX_EMPLOYES", "11"); 
	public static final String SYT_PATH_INDEX_FONCTIONS = getProperty("SYT_PATH_INDEX_FONCTIONS", "fon1"); 
	public static final String SYT_PATH_INDEX_ASSIGNATIONS = getProperty("SYT_PATH_INDEX_ASSIGNATIONS", "ass1"); 
	public static final String SYT_PATH_INDEX_PLANNING = getProperty("SYT_PATH_INDEX_PLANNING", "dplannlist");	
	public static final String SYT_PATH_INDEX_PREPARATION = getProperty("SYT_PATH_INDEX_PREPARATION", "prepa1"); 
	

	// TREF_CATEGORIE
	public static final String TREF_CATEGORIE_REFEA = getProperty("TREF_CATEGORIE_REFEA", "REFEA"); 
	public static final String TREF_CATEGORIE_STRUC = getProperty("TREF_CATEGORIE_STRUC", "STRUC"); 
	public static final String TREF_CATEGORIE_EA = getProperty("TREF_CATEGORIE_EA", "EA"); 

	
	//Properties T_PARAMETRE_GENERAUX
	static String year=""+Calendar.getInstance().YEAR;
	public static final String PARAM_EXERCICE =getProperty("EXERCICE",year);
	public static final String PARAM_URL_BIRT = "urlBirt";
	public static final String PARAM_EXE_BUD = "EXE_BUD";
	public static final String PARAM_URLBIRT ="urlBirt";
	public static final String PARAM_LOG4J ="LOG4J";
	public static final String PARAM_LOG4J_LIBELLE = "C:/LOG4J/";
	//public static final String PARAM_UPLOAD_DESTINATION = getProperty("destination", "\\standalone\\Dossiers\\");
	public static final String PARAM_UPLOAD_DESTINATION = "/wildfly8/standalone/Dossiers/";
	
	public static final String PARAM_UPLOAD_DAO_TRAVAUX = "/wildfly8/standalone/Dossiers/DAO/Travaux/";
	public static final String PARAM_UPLOAD_DAO_FOURNITURES = "/wildfly8/standalone/Dossiers/DAO/Fournitures/";
	public static final String PARAM_UPLOAD_DAO_PRESTATION = "/wildfly8/standalone/Dossiers/DAO/Prestations_Services/";	
	public static final String PARAM_UPLOAD_DAO_PRESTATIONS = "/wildfly8/standalone/Dossiers/DAO/Prestations/";//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_CARBURANT_LEGER = "/wildfly8/standalone/Dossiers/DAO/Carburants/";//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_RESTAURATIONS = "/wildfly8/standalone/Dossiers/DAO/Restauration/";//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES = "/wildfly8/standalone/Dossiers/DAO/Location_main_doeuvre/";//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRES = "/wildfly8/standalone/Dossiers/DAO/Gestion_de_main_doeuvre_occasionnelle/";//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_SERVICES_COURANT = "/wildfly8/standalone/Dossiers/DAO/Gestion_de_main_doeuvre_occasionnelle/";//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_SECURITE_PRIVEE = "/wildfly8/standalone/Dossiers/DAO/Securite_privee/";//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX = "/wildfly8/standalone/Dossiers/DAO/Entretien_des_locaux/";

	//LINUX
	public static final String PARAM_UPLOAD_DESTINATION_DAO_LINUX = getProperty("destinationDao", "\\standalone\\Dossiers\\DAO\\");
	public static final String PARAM_UPLOAD_DAO_TRAVAUX_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Dossiers/DAO/Travaux/");//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_FOURNITURES_LINUX = getProperty("destinationFournitures","/wildfly8/standalone/Dossiers/DAO/Fournitures/");//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_SERVICES_LINUX = getProperty("destinationServices","/wildfly8/standalone/Dossiers/DAO/Services/");
	public static final String PARAM_UPLOAD_DAO_PRESTATIONS_LINUX = getProperty("destinationPrestations","/wildfly8/standalone/Dossiers/DAO/Prestations/");//Pour Laurent	
	public static final String PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX = getProperty("destinationPrestations","/wildfly8/standalone/Dossiers/DAO/Carburants/");//Pour Laurent	
	public static final String PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Dossiers/DAO/Entretien_des_locaux/");//Pour Laurent	
	public static final String PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRE_LINUX = getProperty("destinationFournitures","/wildfly8/standalone/Dossiers/DAO/Gestion_de_main_doeuvre_occasionnelle/");//Pour Laurent
	public static final String PARAM_UPLOAD_DAO_LOCATION_MAIN_LINUX = getProperty("destinationServices","/wildfly8/standalone/Dossiers/DAO/Location_main_doeuvre/");
	public static final String PARAM_UPLOAD_DAO_RESTAURATION_LINUX = getProperty("destinationPrestations","/wildfly8/standalone/Dossiers/DAO/Restauration/"); //Pour Laurent
	public static final String PARAM_UPLOAD_DAO_SECURITE_PRIVEE_LINUX = getProperty("destinationPrestations","/wildfly8/standalone/Dossiers/DAO/Securite_privee/");
	
	
	public static final String PARAM_UPLOAD_FOURNITURES_PSL = "/wildfly8/standalone/Dossiers/DAO/Fournitures_PSL/";
	public static final String PARAM_UPLOAD_TRAVAUX_PSL = "/wildfly8/standalone/Dossiers/DAO/Travaux_PSL/";
	public static final String PARAM_UPLOAD_SERVICES_COURANTS_PSL = "/wildfly8/standalone/Dossiers/DAO/Services_Courants_PSL/";
	public static final String PARAM_UPLOAD_FOURNITURES_PSO = "/wildfly8/standalone/Dossiers/DAO/Fournitures_PSO/";
	public static final String PARAM_UPLOAD_TRAVAUX_PSO = "/wildfly8/standalone/Dossiers/DAO/Travaux_PSO/";
	public static final String PARAM_UPLOAD_SERVICES_COURANTS_PSO = "/wildfly8/standalone/Dossiers/DAO/Services_Courants_PSO/";
	public static final String PARAM_UPLOAD_PRESTATIONS_INTELLECTUELLES = "/wildfly8/standalone/Dossiers/DAO/Prestations_intellectuelles_PS/";
	
	/* Procedures simplifiées */    /* A créer*/
	public static final String PARAM_UPLOAD_FOURNITURES_PSL_LINUX = "/wildfly8/standalone/Dossiers/DAO/Fournitures_PSL/";
	public static final String PARAM_UPLOAD_TRAVAUX_PSL_LINUX = "/wildfly8/standalone/Dossiers/DAO/Travaux_PSL/";
	public static final String PARAM_UPLOAD_SERVICES_COURANTS_PSL_LINUX = "/wildfly8/standalone/Dossiers/DAO/Services_Courants_PSL/";
	public static final String PARAM_UPLOAD_FOURNITURES_PSO_LINUX = "/wildfly8/standalone/Dossiers/DAO/Fournitures_PSO/";
	public static final String PARAM_UPLOAD_TRAVAUX_PSO_LINUX = "/wildfly8/standalone/Dossiers/DAO/Travaux_PSO/";
	public static final String PARAM_UPLOAD_SERVICES_COURANTS_PSO_LINUX = "/wildfly8/standalone/Dossiers/DAO/Services_Courants_PSO/";
	public static final String PARAM_UPLOAD_PRESTATIONS_INTELLECTUELLES_LINUX = "/wildfly8/standalone/Dossiers/DAO/Prestations_intellectuelles_PS/";
	
	//FICHIER DE BASE DAO TYPE
	//WINDOWS
	public static final String PATHNAME = "/wildfly8/standalone/Fichiers/";
	public static final String FICHIER_UPLOAD_DAO_TRAVAUX = "/wildfly8/standalone/Fichiers/dtao_travaux.docx";
	public static final String FICHIER_UPLOAD_DAO_FOURNITURES = "/wildfly8/standalone/Fichiers/DAO_Fournitures_et_services_connexes.docx";
	public static final String FICHIER_UPLOAD_DAO_PRESTATION = "/wildfly8/standalone/Fichiers/dtao_prestation.docx";	
	public static final String FICHIER_UPLOAD_DAO_PRESTATIONS = "/wildfly8/standalone/Fichiers/DAO_Fournitures_et_services_connexes.docx";//Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_CARBURANT_LEGER = "/wildfly8/standalone/Fichiers/DAO_Carburant_allege.docx";//Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_RESTAURATIONS = "/wildfly8/standalone/Fichiers/DAO_RESTAURATION.docx";//Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES = "/wildfly8/standalone/Fichiers/dao_location_main_doeuvre.docx";//Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES = "/wildfly8/standalone/Fichiers/dao_gestion_de_main_doeuvre_occasionnelle.docx";//Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_SERVICES_COURANT = "/wildfly8/standalone/Fichiers/DAO_Fournitures_et_services_connexes.docx";//Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_SECURITE_PRIVEE = "/wildfly8/standalone/Fichiers/dao_securite_privee.docx";//Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX = "/wildfly8/standalone/Fichiers/dao_entretien_des_locaux.docx";
	
	/* Procedures simplifiées */
	public static final String FICHIER_UPLOAD_SERVICES_COURANTS_PSL = "/wildfly8/standalone/Fichiers/dossier_de_consultation_de services_courants_en_PSL_FINAL.docx";
	public static final String FICHIER_UPLOAD_SERVICES_COURANTS_PSO = "/wildfly8/standalone/Fichiers/dossier_de_consultation_de services_courants_en_PSO.docx"; 
	public static final String FICHIER_UPLOAD_FOURNITURES_PSL = "/wildfly8/standalone/Fichiers/dossier_de_consultation_de_fourniture_en_PSL.docx"; 
	public static final String FICHIER_UPLOAD_FOURNITURES_PSO = "/wildfly8/standalone/Fichiers/dossier_de_consultation_de_fourniture_en_PSO_final.docx";
	public static final String FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS = "/wildfly8/standalone/Fichiers/dossier_de_consultation_service_de_type_intelectuel.docx";
	public static final String FICHIER_UPLOAD_TRAVAUX_PSL = "/wildfly8/standalone/Fichiers/dossier_de_consultation_travaux_en_PSL_final.docx";
	public static final String FICHIER_UPLOAD_TRAVAUX_PSO = "/wildfly8/standalone/Fichiers/dossier_de_consultation_travaux_en_PSO_final.docx";
	
	//LINUX
	public static final String PATHNAME_LINUX = getProperty("pathName","/wildfly8/standalone/Fichiers/");
	public static final String FICHIER_UPLOAD_DAO_TRAVAUX_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dtao_travaux.docx");
	public static final String FICHIER_UPLOAD_DAO_FOURNITURES_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/DAO_Fournitures_et_services_connexes.docx"); 	
	public static final String FICHIER_UPLOAD_DAO_PRESTATIONS_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dtao_prestation.docx"); //Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_CARBURANT_LEGER_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/DAO_Carburant_allege.docx"); //Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_RESTAURATIONS_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/DAO_RESTAURATION.docx"); //Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dao_location_main_doeuvre.docx"); //Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dao_gestion_de_main_doeuvre_occasionnelle.docx"); //Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_SERVICES_COURANT_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/DAO_Fournitures_et_services_connexes.docx");//Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_SECURITE_PRIVEE_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dao_securite_privee.docx"); //Pour Laurent
	public static final String FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dao_entretien_des_locaux.docx");
	
	/* Procedures simplifiées */    /* A créer*/
	public static final String FICHIER_UPLOAD_SERVICES_COURANTS_PSL_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dossier_de_consultation_de services_courants_en_PSL_FINAL.docx");
	public static final String FICHIER_UPLOAD_SERVICES_COURANTS_PSO_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dossier_de_consultation_de services_courants_en_PSO.docx"); 
	public static final String FICHIER_UPLOAD_FOURNITURES_PSL_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dossier_de_consultation_de_fourniture_en_PSL.docx"); 
	public static final String FICHIER_UPLOAD_FOURNITURES_PSO_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dossier_de_consultation_de_fourniture_en_PSO_final.docx");
	public static final String FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dossier_de_consultation_service_de_type_intelectuel.docx");
	public static final String FICHIER_UPLOAD_TRAVAUX_PSL_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dossier_de_consultation_travaux_en_PSL_final.docx");
	public static final String FICHIER_UPLOAD_TRAVAUX_PSO_LINUX = getProperty("destinationTravaux","/wildfly8/standalone/Fichiers/dossier_de_consultation_travaux_en_PSO_final.docx");
	
	public static final String PARAM_UPLOAD_DESTINATION_TRUE_DOC = getProperty("destinationTrue", "\\standalone\\Dossiers\\trueDoc\\");
	public static final String PARAM_UPLOAD_DESTINATION_LINUX = getProperty("destinationLinux", "/wildfly8/standalone/Dossiers/");
	public static final String PARAM_UPLOAD_DESTINATION_TRUE_DOC_LINUX = getProperty("destinationTrueLinux", "/wildfly8/standalone/Dossiers/trueDoc/");
	public static final String PARAM_SOURCE_LOG = getProperty("sourcelog", "\\standalone\\log\\");
	public static final String PARAM_SOURCE_LOG_LINUX = getProperty("sourceloglinux", "/standalone/log/");
	

	//TRAITEMENT ACCUEIL
	public static final String HOME=getProperty("HOME", "accueil"); 

	//TRAITEMENTS EMPLOYES
	public static final String OPE1=getProperty("OPE1", "ope1"); 
	public static final String OPE2=getProperty("OPE2", "ope2"); 
	public static final String OPE3=getProperty("OPE3", "ope3"); 
	public static final String OPE4=getProperty("OPE4", "ope4"); 
	
	//TRAITEMENTS FONCTIONS
	public static final String FON1=getProperty("FON1", "fon1"); 
	public static final String FON2=getProperty("FON2", "fon2"); 
	public static final String FON3=getProperty("FON3", "fon3"); 
	
	//TRAITEMENTS TYPE FONCTIONS
	public static final String TYF1=getProperty("TYF1", "tyf1"); 
	public static final String TYF2=getProperty("TYF2", "tyf2"); 
	//public static final String TYF3=getProperty("TYF3", "tyf3"); 

	//TRAITEMENTS ASSIGNATIONS
	public static final String ASS1=getProperty("ASS1", "ass1"); 
	public static final String ASS2=getProperty("ASS2", "ass2"); 
	public static final String ASS3=getProperty("ASS3", "ass3"); 
	
	//TRAITEMENTS ACTIONS
	public static final String SYA1=getProperty("SYA1", "sya1"); 
	public static final String SYA2=getProperty("SYA2", "sya2"); 
	public static final String SYA3=getProperty("SYA3", "sya3"); 

	//TRAITEMENTS TRAITEMENTS
	public static final String SYT1=getProperty("SYT1", "syt1"); 
	public static final String SYT2=getProperty("SYT2", "syt2"); 
	public static final String SYT3=getProperty("SYT3", "syt3"); 

	//TRAITEMENTS MENUS
	public static final String MEN1=getProperty("MEN1", "men1"); 
	public static final String MEN2=getProperty("MEN2", "men2"); 
	public static final String MEN3=getProperty("MEN3", "men3"); 

	
	  

	//---- FIN VARIABLES GLOBALES ----//


	

	
    /**
     * Initialize the messages format.
     * @throws MissingResourceException
     * @see MessageFormat
     */
    static public void initialization() {
    	try {
    		_properties = ResourceBundle.getBundle(PROPERTIES_RESOURCE);
    	} catch (MissingResourceException e) {
    		_log.error(e.toString());
    	}
    }
    
    /**
     * Gets a property value
     * return String (or defaultValue)
     */
    static public String getProperty(String key, String defaultValue) {
    	String value = null;
    	// init
		if (_properties == null) {
		    synchronized (GRFProperties.class) { initialization(); }
		}
		if (_properties!=null && key!=null) {
			try {
				value = _properties.getString(key);
			} catch (MissingResourceException e) {
				value = null;
				//_log.warn(e.toString() + " - key:" + key);
			}
		}
		if (value!=null) {
			value = value.trim();
		} else {
			value = defaultValue;
		}
		return value;		
    }  
    static public String getProperty(String key) {
    	String value = null;
    	// init
    	if (_properties == null) {
    		synchronized (GRFProperties.class) { initialization(); }
    	}
    	if (_properties!=null && key!=null) {
    		try {
    			value = _properties.getString(key);
    		} catch (MissingResourceException e) {
    			value = null;
    			//_log.warn(e.toString() + " - key:" + key);
    		}
    	}
    	if (value!=null) {
    		value = value.trim();
    	} else {
    		value = "";
    	}
    	return value;		
    }  
    
    static Properties convertResourceBundleToProperties(ResourceBundle resource) {
        Properties properties = new Properties();

        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
          String key = keys.nextElement();
          properties.put(key, resource.getString(key));
        }

        return properties;
      }
    
    /**
     * Set a property value
     * update property
     */
    static  public  String updateProperty(String key, String value, File fileProp) {
    	 String propsFileName = "sigmicap.properties";
    	 Properties props = convertResourceBundleToProperties(_properties);
	String check = "OKKO";
			try {
				 //modifies existing or adds new property
			      props.setProperty(key, value);
			 
			      //save modified property file
			     // getClass().getClassLoader().getResource("pages.properties");
			      FileOutputStream output = new FileOutputStream(fileProp);
			      props.store(output, "");
			      output.close();
			      check = "OK";
			} catch (IOException e) {
				check = "KO";
				_log.warn(e.toString() + " - key:" + key);
			}
			return check;	
    }    
    


}
