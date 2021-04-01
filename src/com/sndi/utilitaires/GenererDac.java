package com.sndi.utilitaires;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STEdGrp;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Node;

import com.sndi.controller.dao.DaoController;
import com.sndi.dao.WhereClause;
import com.sndi.model.TCommissionSpecifique;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDaoAffectation;
import com.sndi.model.TDetCommissionSeance;
import com.sndi.model.TModePassation;
import com.sndi.model.VDacliste;
import com.sndi.model.VLigneLot;
import com.sndi.model.VMargeDePreference;
import com.sndi.model.VPpmDao;
import com.sndi.model.VbCommissionSpecifique;
import com.sndi.model.VbLotAao;
import com.sndi.model.VbxDocAdrRetrait;
import com.sndi.model.VbxDocCommission;
import com.sndi.model.VbxDocDaoAao;
import com.sndi.model.VbxDocLot;
import com.sndi.model.VdAao;
import com.sndi.model.VdDao;
import com.sndi.model.VxAdresse;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;

public class GenererDac {
	Logger _logger = Logger.getLogger(DaoController.class);	
	
	@Autowired
	UserController userController;
	@Autowired
	Iservice iservice;
	@Autowired
	 DownloadFileServlet downloadFileServlet;
	
	//private TDacSpecs dao= new TDacSpecs();
	//private VDacliste slctdTd = new VDacliste();
	
	
	 /*******  document  *************/
	 private XWPFDocument document = null;
	 private String DAO_CARBURANT_LEGER = "DAO Carburant allege.docx";
	 private String DAO_RESTAURATION = "DAO RESTAURATION.docx";
	 private String DAO_ENTRETIEN_LOCAUX_ESPACE_VERT = "dao_ entretien_ des_locaux.docx";
	 private String DAO_GESTION_MAIN_OEUVRE_OCCASIONNELLE = "dao_ gestion_de_main_doeuvre_occasionnelle.docx";
	 private String DAO_LOCATION_MAIN_OEUVRE = "dao_location_main_doeuvre.docx";
	 private String DAO_SECURITE_PRIVEE = "dao_securite_privee.docx";
	 private String DAO_FOURNITURES_SERVICES_CONNEXES = "DAO_Fournitures_et_services_connexes.docx";
	 private String DAO_TRAVAUX = "dtao_travaux.docx";
	 private String DAO_PRESTATIONS = "dtao_prestation.docx";
	 private String PATHNAME = "C:/wildfly-8.2.1.Final/standalone/Dossiers/Fichiers/";
	 
	 private String DOWNLOAD_PATHNAME = "";
	 private String DOWNLOAD_FILENAME ="";
	 
	 
	 // methode pour charger le document du disque dur
	 public XWPFDocument getDocument() {
		return document;
	}

	 public void setDocument(XWPFDocument document) {
		this.document = document;
	 }
	 
	 public void genererDac(TDacSpecs dao) throws FileNotFoundException, IOException {
		 createDaoFile(new TDacSpecs(dao.getDacCode()));
		 chargeDaoFichier();	 
	 }

	 public void chargeDaoFichier() throws FileNotFoundException, IOException {
		 switch(daoIter.getTymCode()) {
			 case "0": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_FOURNITURES_SERVICES_CONNEXES))));
			 break;
			 
			 case "00": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_FOURNITURES_SERVICES_CONNEXES))));
			 break;
			 
			 case "1": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_PRESTATIONS))));
			 break;
			 
			 case "10": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_PRESTATIONS))));
			 break;
			 
			 case "2": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_TRAVAUX))));
			 break;
			 
			 case "20": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_TRAVAUX))));
			 break;
			 
			 case "05": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_CARBURANT_LEGER ))));
			 break;
			 
			 case "16": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_RESTAURATION))));
			 break;
			 
			 case "15": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_LOCATION_MAIN_OEUVRE))));
			 break;
			 
			 case "19": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_GESTION_MAIN_OEUVRE_OCCASIONNELLE))));
			 break;
			 
			 case "14": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_SECURITE_PRIVEE))));
			 break;
			 
			 case "13": setDocument(new XWPFDocument(new FileInputStream(new File(PATHNAME + DAO_ENTRETIEN_LOCAUX_ESPACE_VERT))));
			 break;
		}
	 }

	//POUR WINDOWS - LAURENT
		 public void chargeDaoFileIndex() throws IOException {	
			 
			  //* Chargement des PSL  FOURNITURES - TRAVAUX - PRESTATIONS
			  

			 if((daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("0"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("0A")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("00")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("01")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("02")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("03")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("04")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("05")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("06")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("07")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("08")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("09")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("0"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("0A")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("00")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("01")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("02")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("03")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("04")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("05")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("06")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("07")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("08")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("09"))
				) {
				 setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSL))));
				 _logger.info("Dossier de rfrence PSL charg");
			 }
			 
			if(	(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("2"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("20")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("21")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("22")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("23")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("25")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("26")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("2"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("20")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("21")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("22")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("23")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("25")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSL))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			if(	(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("10")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1A")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1B")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1C")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1D")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("12")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("13")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("14")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("15")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("16")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("17")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("18")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("19")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("10")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1A")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1B")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1C")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1D")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("11")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("12")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("13")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("14")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("15")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("16")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("17")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("18")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSL))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			
			 //* Chargement des PSO  FOURNITURES - TRAVAUX - PRESTATIONS
			 
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("0"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("0A")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("00")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("01")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("02")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("03")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("04")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("05")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("06")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("07")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("08")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("09")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("0"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("0A")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("00")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("01")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("02")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("03")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("04")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("05")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("06")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("07")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("08")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("09"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("2"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("20")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("21")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("22")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("23")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("25")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("26")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("2"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("20")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("21")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("22")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("23")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("25")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("10")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1A")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1B")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1C")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1D")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("12")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("13")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("14")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("15")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("16")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("17")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("18")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("19")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("10")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1A")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1B")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1C")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1D")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("11")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("12")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("13")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("14")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("15")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("16")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("17")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("18")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("11"))	
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS))));
				_logger.info("Dossier de rfrence charg");
			}
			
			
			  //* Chargement des AAO FOURNITURES - TRAVAUX - PRESTATIONS
			  
			 
			if(	(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOO")) ||
					(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOR"))
				
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES))));
				_logger.info("DAO FOURNITURE charg");
				}
			 
			if(	(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOO")) ||
					(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX))));
				_logger.info("DAO TRAVAUX ROUTES ELECTRICITE charg");
				}
			
			// CARBURANT
			if(	daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("AOO") ||
					daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("AOR")) {
					setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_CARBURANT_LEGER))));
					_logger.info("DAO CARBURANT charg");
					}
			
			//Prestation courante 10
			if( (daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOO")) || // PRESTATION
				(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOO")) || // ORDURES MENAGERES
				(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO")) || // ASSURANCES 17
				(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOO")) || // BLANCHISSERIE 12
					(daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATION))));
				_logger.info("DAO Prestations courantes charg");
				}
			
			// Restauration
			if( daoAao.getTymCode().equals("16") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("16") && daoAao.getDacMopCode().equals("AOR")
					) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_RESTAURATIONS))));
				_logger.info("DAO Restauration charg");
				}
			
			// LOCATION DE MAIN D'OEUVRES 
			if(	daoAao.getTymCode().equals("15") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("15") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES))));
				_logger.info("DAO LOCATION DE MAIN D'OEUVRES charg");
				}
			
			// GESTION DE MAIN D'OEUVRES
			if(	daoAao.getTymCode().equals("19") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("19") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES))));
				_logger.info("DAO GESTION DE MAIN D'OEUVRES charg");
				}
			
			// SECURITE PRIVEE 
			if(	daoAao.getTymCode().equals("14") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("14") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_SECURITE_PRIVEE))));
				_logger.info("DAO SECURITE PRIVEE charg");
				}
			
			// ENTRETIENS ESPACES VERTS ET LOCAUX 13
			if(	daoAao.getTymCode().equals("13") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("13") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX))));
				_logger.info("DAO ENTRETIEN DES LOCAUX charg");
			}
			
			// ASSURANCE 
			if(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO") || daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ASSURANCE))));
				_logger.info("DAO SECURITE PRIVEE charg");
			}
		 }
		 //FIN WINDOWS
		 
		 
		//POUR WINDOWS - LAURENT
		/* public void chargeDaoFileIndex() throws IOException {	
			 
			  * Chargement des PSL  FOURNITURES - TRAVAUX - PRESTATIONS
			  

			 if((slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("0"))  ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("0A")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("00")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("01")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("02")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("03")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("04")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("05")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("06")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("07")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("08")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("09")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("0"))  ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("0A")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("00")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("01")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("02")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("03")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("04")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("05")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("06")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("07")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("08")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("09"))
				) {
				 setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSL))));
				 _logger.info("Dossier de rfrence PSL charg");
			 }
			 
			if(	(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("2"))  ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("20")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("21")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("22")) ||	
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("23")) ||	
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("25")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("26")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("2"))  ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("20")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("21")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("22")) ||	
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("23")) ||	
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("25")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSL))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			if(	(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1"))  ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("10")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1A")) ||	
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1B")) ||	
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1C")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("1D")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("11")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("12")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("13")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("14")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("15")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("16")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("17")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("18")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("19")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1"))  ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("10")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1A")) ||	
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1B")) ||	
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1C")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("1D")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("11")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("12")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("13")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("14")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("15")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("16")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("17")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("18")) ||
					(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSL))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			
			 * Chargement des PSO  FOURNITURES - TRAVAUX - PRESTATIONS
			 
			
			if(	(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("0"))  ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("0A")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("00")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("01")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("02")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("03")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("04")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("05")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("06")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("07")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("08")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("09")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("0"))  ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("0A")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("00")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("01")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("02")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("03")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("04")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("05")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("06")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("07")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("08")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("09"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("2"))  ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("20")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("21")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("22")) ||	
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("23")) ||	
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("25")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("26")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("2"))  ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("20")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("21")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("22")) ||	
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("23")) ||	
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("25")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1"))  ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("10")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1A")) ||	
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1B")) ||	
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1C")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("1D")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("11")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("12")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("13")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("14")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("15")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("16")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("17")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("18")) ||
				(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("19")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1"))  ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("10")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1A")) ||	
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1B")) ||	
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1C")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("1D")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("11")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("12")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("13")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("14")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("15")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("16")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("17")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("18")) ||
					(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSO))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("11")) ||
				(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("11"))	
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS))));
				_logger.info("Dossier de rfrence charg");
			}
			
			
			  * Chargement des AAO FOURNITURES - TRAVAUX - PRESTATIONS
			  
			 
			if(	(slctdTd.getTymCode().equals("0")  && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("00") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("0A") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("01") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("02") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("03") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("04") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("06") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("07") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("08") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("09") && slctdTd.getDacMopCode().equals("AOO")) ||
					(slctdTd.getTymCode().equals("0")  && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("00") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("0A") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("01") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("02") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("03") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("04") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("06") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("07") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("08") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("09") && slctdTd.getDacMopCode().equals("AOR"))
				
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES))));
				_logger.info("DAO FOURNITURE charg");
				}
			 
			if(	(slctdTd.getTymCode().equals("2")  && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("20") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("21") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("22") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("23") && slctdTd.getDacMopCode().equals("AOO")) || 
				(slctdTd.getTymCode().equals("25") && slctdTd.getDacMopCode().equals("AOO")) ||
				(slctdTd.getTymCode().equals("26") && slctdTd.getDacMopCode().equals("AOO")) ||
					(slctdTd.getTymCode().equals("2")  && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("20") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("21") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("22") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("23") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("25") && slctdTd.getDacMopCode().equals("AOR")) ||
					(slctdTd.getTymCode().equals("26") && slctdTd.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX))));
				_logger.info("DAO TRAVAUX ROUTES ELECTRICITE charg");
				}
			
			// CARBURANT
			if(	slctdTd.getTymCode().equals("05") && slctdTd.getDacMopCode().equals("AOO") ||
					slctdTd.getTymCode().equals("05") && slctdTd.getDacMopCode().equals("AOR")) {
					setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_CARBURANT_LEGER))));
					_logger.info("DAO CARBURANT charg");
					}
			
			//Prestation courante 10
			if( (slctdTd.getTymCode().equals("10") && slctdTd.getDacMopCode().equals("AOO")) || // PRESTATION
				(slctdTd.getTymCode().equals("18") && slctdTd.getDacMopCode().equals("AOO")) || // ORDURES MENAGERES
				(slctdTd.getTymCode().equals("17") && slctdTd.getDacMopCode().equals("AOO")) || // ASSURANCES 17
				(slctdTd.getTymCode().equals("12") && slctdTd.getDacMopCode().equals("AOO")) || // BLANCHISSERIE 12
					(slctdTd.getTymCode().equals("10") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("18") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("17") && slctdTd.getDacMopCode().equals("AOR")) || 
					(slctdTd.getTymCode().equals("12") && slctdTd.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATION))));
				_logger.info("DAO Prestations courantes charg");
				}
			
			// Restauration
			if( slctdTd.getTymCode().equals("16") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("16") && slctdTd.getDacMopCode().equals("AOR")
					) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_RESTAURATIONS))));
				_logger.info("DAO Restauration charg");
				}
			
			// LOCATION DE MAIN D'OEUVRES 
			if(	slctdTd.getTymCode().equals("15") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("15") && slctdTd.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES))));
				_logger.info("DAO LOCATION DE MAIN D'OEUVRES charg");
				}
			
			// GESTION DE MAIN D'OEUVRES
			if(	slctdTd.getTymCode().equals("19") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("19") && slctdTd.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES))));
				_logger.info("DAO GESTION DE MAIN D'OEUVRES charg");
				}
			
			// SECURITE PRIVEE 
			if(	slctdTd.getTymCode().equals("14") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("14") && slctdTd.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_SECURITE_PRIVEE))));
				_logger.info("DAO SECURITE PRIVEE charg");
				}
			
			// ENTRETIENS ESPACES VERTS ET LOCAUX 13
			if(	slctdTd.getTymCode().equals("13") && slctdTd.getDacMopCode().equals("AOO") ||
				slctdTd.getTymCode().equals("13") && slctdTd.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX))));
				_logger.info("DAO ENTRETIEN DES LOCAUX charg");
			}			
		 }
		 */
		 //FIN WINDOWS
		 
		 //POUR LINUX - LAURENT
	public void chargeDaoFile() throws IOException {		 
			 
			  //Chargement des PSL  FOURNITURES - TRAVAUX - PRESTATIONS
			  
			 if((daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("0"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("0A")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("00")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("01")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("02")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("03")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("04")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("05")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("06")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("07")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("08")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("09")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("0"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("0A")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("00")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("01")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("02")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("03")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("04")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("05")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("06")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("07")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("08")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("09"))
				) {
				 setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSL_LINUX))));
				 _logger.info("Dossier de rfrence PSL charg");
			 }
			 
			if(	(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("2"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("20")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("21")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("22")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("23")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("25")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("26")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("2"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("20")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("21")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("22")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("23")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("25")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSL_LINUX))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			if(	(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1"))  ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("10")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1A")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1B")) ||	
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1C")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("1D")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("12")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("13")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("14")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("15")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("16")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("17")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("18")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("19")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1"))  ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("10")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1A")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1B")) ||	
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1C")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("1D")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("11")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("12")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("13")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("14")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("15")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("16")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("17")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("18")) ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSL_LINUX))));
				_logger.info("Dossier de rfrence PSL charg");
				}
			
			  //Chargement des PSO  FOURNITURES - TRAVAUX - PRESTATIONS
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("0"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("0A")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("00")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("01")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("02")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("03")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("04")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("05")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("06")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("07")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("08")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("09")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("0"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("0A")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("00")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("01")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("02")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("03")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("04")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("05")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("06")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("07")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("08")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("09"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_FOURNITURES_PSO_LINUX))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("2"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("20")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("21")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("22")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("23")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("25")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("26")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("2"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("20")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("21")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("22")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("23")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("25")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("26"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_TRAVAUX_PSO_LINUX))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1"))  ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("10")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1A")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1B")) ||	
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1C")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("1D")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("12")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("13")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("14")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("15")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("16")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("17")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("18")) ||
				(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("19")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1"))  ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("10")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1A")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1B")) ||	
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1C")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("1D")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("11")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("12")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("13")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("14")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("15")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("16")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("17")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("18")) ||
					(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("19"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_SERVICES_COURANTS_PSO_LINUX))));
				_logger.info("Dossier de rfrence PSO charg");
			}
			
			if(	(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("11")) ||
				(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("11"))	
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS_LINUX))));
				_logger.info("Dossier de rfrence charg");
			}
			
			
			  // Chargement des AAO FOURNITURES - TRAVAUX - PRESTATIONS
			  
			 
			if(	(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOO")) ||
					(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOR"))
				
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_FOURNITURES_LINUX))));
				_logger.info("DAO FOURNITURE charg");
				}
			 
			if(	(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOO")) ||
					(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOR")) ||
					(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_TRAVAUX_LINUX))));
				_logger.info("DAO TRAVAUX ROUTES ELECTRICITE charg");
				}
			
			// CARBURANT
			if(	daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("AOO") ||
					daoAao.getTymCode().equals("05") && daoAao.getDacMopCode().equals("AOR")) {
					setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_CARBURANT_LEGER_LINUX))));
					_logger.info("DAO CARBURANT charg");
					}
			
			//Prestation courante 10
			if( (daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOO")) || // PRESTATION
				(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOO")) || // ORDURES MENAGERES
				(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO")) || // ASSURANCES 17
				(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOO")) || 	  // BLANCHISSERIE 12
					(daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOR")) || 
					(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOR"))
				) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATIONS_LINUX))));
				_logger.info("DAO Prestations courantes charg");
				}
			
			// Restauration
			if( daoAao.getTymCode().equals("16") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("16") && daoAao.getDacMopCode().equals("AOR")
					) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_RESTAURATIONS_LINUX))));
				_logger.info("DAO Restauration charg");
				}
			
			// LOCATION DE MAIN D'OEUVRES 
			if(	daoAao.getTymCode().equals("15") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("15") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES_LINUX))));
				_logger.info("DAO LOCATION DE MAIN D'OEUVRES charg");
				}
			
			// GESTION DE MAIN D'OEUVRES
			if(	daoAao.getTymCode().equals("19") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("19") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES_LINUX))));
				_logger.info("DAO GESTION DE MAIN D'OEUVRES charg");
				}
			
			// SECURITE PRIVEE 
			if(	daoAao.getTymCode().equals("14") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("14") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_SECURITE_PRIVEE_LINUX))));
				_logger.info("DAO SECURITE PRIVEE charg");
				}
			
			// ENTRETIENS ESPACES VERTS ET LOCAUX 13
			if(	daoAao.getTymCode().equals("13") && daoAao.getDacMopCode().equals("AOO") ||
				daoAao.getTymCode().equals("13") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX))));
				_logger.info("DAO ENTRETIEN DES LOCAUX charg");
			}
			
			// ASSURANCE 
			if(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO") || daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOR")) {
				setDocument(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_ASSURANCE_LINUX))));
				_logger.info("DAO SECURITE PRIVEE charg");
			}
				
		 }
	    
	/* private List<XWPFParagraph> collectParagraphs() {
		 List<XWPFParagraph> paragraphs = new ArrayList<>();
		 paragraphs.addAll(getDocument().getParagraphs());
		
		 for(XWPFTable table:getDocument().getTables()) {
			 for(XWPFTableRow row:table.getRows()) {
				for(XWPFTableCell cell:row.getTableCells()) {
					paragraphs.addAll(cell.getParagraphs());
				}
			 }
		 }
		 return paragraphs;		
	 }*/
		 
	private List<XWPFParagraph> collectParagraphs() {
			 List<XWPFParagraph> paragraphs = new ArrayList<>();
			 paragraphs.addAll(getDocument().getParagraphs());
			
			 for(XWPFTable table:getDocument().getTables()) {
				 for(XWPFTableRow row:table.getRows()) {
					for(XWPFTableCell cell:row.getTableCells()) {
						paragraphs.addAll(cell.getParagraphs());
					}
				 }
			 }
			 return paragraphs;		
		 }
	
	/* public List<String> getBookmarkNames(){
		List<String> bookmarkNames = new ArrayList<>();
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		
		paraIter = collectParagraphs().iterator();
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				bookmarkNames.add(bookmark.getName());
			}
		}
		return bookmarkNames;
	}*/
	 
	public List<String> getBookmarkNames() {
			List<String> bookmarkNames = new ArrayList<>();
			Iterator<XWPFParagraph> paraIter = null;
			XWPFParagraph para = null;
			List<CTBookmark> bookmarkList = null;
			Iterator<CTBookmark> bookmarkIter = null;
			CTBookmark bookmark = null;
				
			paraIter = collectParagraphs().iterator();
			while(paraIter.hasNext()) {
					para = paraIter.next();
					bookmarkList = para.getCTP().getBookmarkStartList();
					bookmarkIter = bookmarkList.iterator();
					while(bookmarkIter.hasNext()) {
						bookmark = bookmarkIter.next();
						bookmarkNames.add(bookmark.getName());
					}
			}
			return bookmarkNames;
			}
	 
	public void printBmk() {
			 List<String> bmkNameL = getBookmarkNames();
				//List<String> ignore = new ArrayList<String>()
						
				for (String i:bmkNameL) {
					if (i.contains("_Toc")) {
						continue;
					}
					if (i.contains("Block")) {
						continue;
					}
					if (i.contains("_Hlt")) {
						continue;
					}
					if (i.contains("OLE")) {
						continue;
					}
					if (i.contains("_GoBack")) {
						continue;
					}
					_logger.info(i);
				}
		 }

	public Node getBookmarkNode(String bookmarkName) {
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		Node node = null;
		
		paraIter = collectParagraphs().iterator();
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(bookmarkName)) {
					node = bookmark.getDomNode();
				}
			}
		}
		return node;
	}
	
	public Node getBookmarkParentNode(String bookmarkName) {
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		Node node = null;
		
		paraIter = collectParagraphs().iterator();
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(bookmarkName)) {
					node = para.getCTP().getDomNode();
				}
			}
		}
		return node;
	}

/*	private void procParaList(List<XWPFParagraph> paraList, String bookmarkName,
			String bookmarkValue) {
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		XWPFRun run = null;
		Node nextNode = null;
		
		paraIter = paraList.iterator();
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(bookmarkName)) {
					run = para.createRun();
					run.setBold(true);
					run.setColor("0000FF");
					run.setText(bookmarkValue);
					nextNode = bookmark.getDomNode().getNextSibling();
					while(!(nextNode.getNodeName().contains("bookmarkEnd"))) {
						para.getCTP().getDomNode().removeChild(nextNode);
						nextNode = bookmark.getDomNode().getNextSibling();
					}
					para.getCTP().getDomNode().insertBefore(
							run.getCTR().getDomNode(), nextNode);
				}
			}
		}
	}*/
	
	private void procParaList(List<XWPFParagraph> paraList, String bookmarkName,
			String bookmarkValue) {
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		XWPFRun run = null;
		Node nextNode = null;
		
		paraIter = paraList.iterator();
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(bookmarkName)) {
					run = para.createRun();
					run.setBold(true);
					run.setColor("0000FF");
					run.setText(bookmarkValue);
					nextNode = bookmark.getDomNode().getNextSibling();
					while(!(nextNode.getNodeName().contains("bookmarkEnd"))) {
						para.getCTP().getDomNode().removeChild(nextNode);
						nextNode = bookmark.getDomNode().getNextSibling();
					}
					para.getCTP().getDomNode().insertBefore(
							run.getCTR().getDomNode(), nextNode);
				}
			}
		}
	}
	
	private void replaceBookmarkByValue(String bookmarkName, String bookmarkValue) {
		List<XWPFTable> tableList = null;
		Iterator<XWPFTable> tableIter = null;
		List<XWPFTableRow> rowList = null;
		Iterator<XWPFTableRow> rowIter = null;
		List<XWPFTableCell> cellList = null;
		Iterator<XWPFTableCell> cellIter = null;
		XWPFTable table = null;
		XWPFTableRow row = null;
		XWPFTableCell cell = null;
		
		this.procParaList(getDocument().getParagraphs(), bookmarkName, bookmarkValue);

		tableList = this.document.getTables();
		tableIter = tableList.iterator();
		while(tableIter.hasNext()) {
			table = tableIter.next();
			rowList = table.getRows();
			rowIter = rowList.iterator();
			while(rowIter.hasNext()) {
				row = rowIter.next();
				cellList = row.getTableCells();
				cellIter = cellList.iterator();
				while(cellIter.hasNext()) {
					cell = cellIter.next();
					this.procParaList(cell.getParagraphs(), 
							bookmarkName, bookmarkValue);
				}
			}
		}
	}
	
	public XWPFTable enteteTableLots(String bookmarkName) {
		XWPFTable table = getDocument().createTable(1, 4);
		table.getRow(0).getCell(0).setText("N°");
		table.getRow(0).getCell(1).setText("LIBELLE");
		table.getRow(0).getCell(2).setText("DELAI D'EXECUTION");
		table.getRow(0).getCell(3).setText("CAUTIONNEMENT PROVISOIRE");
		return table;
	}
	
	public void getInfoDao(TDacSpecs dao) {
		infoDao = (ArrayList<VdDao>) iservice.getObjectsByColumn("VdDao", new WhereClause("DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoDao.isEmpty()) {
			daoIter = infoDao.get(0);
			_logger.info("Infos DAO charges");
			_logger.info(daoIter.getDacObjet());
			_logger.info(daoIter.getTymCode());
		}
	}
	
	public void getInfoAao(TDacSpecs dao) {
		infoAao = (ArrayList<VdAao>) iservice.getObjectsByColumn("VdAao", new WhereClause("DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoDao.isEmpty()) {
			aaoIter = infoAao.get(0);
			_logger.info("Infos AAO charges");
			_logger.info(aaoIter.getDacCode());
			_logger.info(aaoIter.getLaaObjet());
		}
	}

	public void getInfoAdresse(TDacSpecs dao) {
		infoAdresse = (ArrayList<VxAdresse>) iservice.getObjectsByColumn("VxAdresse", new WhereClause("DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoAdresse.isEmpty()) {
			adresseIter = infoAdresse.get(0);
			_logger.info("Infos sur l'adresse charges");
			_logger.info(adresseIter.getDacCode());
			_logger.info(adresseIter.getLibdetail());
		}
	}
	
	public void getInfoLots(TDacSpecs dao) {
		infoLots = (ArrayList<VbLotAao>) iservice.getObjectsByColumn("VbLotAao", new WhereClause("LAA_DAC_CODE", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoLots.isEmpty()) {
			lotsIter = infoLots.get(0);
			_logger.info("Infos sur les lots charges");
			_logger.info(lotsIter.getLaaDacCode() );
			_logger.info(lotsIter.getLaaObjet());
			
			for(int x = 0; x < infoLots.size(); x++) {				
				_logger.info(infoLots.get(x).getLaaObjet());
				//_logger.info(x.getLots());
			}
		}
	}
	
	public void getInfoCojo(TDacSpecs dao) {
		infoCojo = (ArrayList<VbCommissionSpecifique>) iservice.getObjectsByColumn("VbCommissionSpecifique", new WhereClause("com_dac_code", WhereClause.Comparateur.EQ, "" + dao.getDacCode()));
		if (!infoCojo.isEmpty()) {
			cojoIter = infoCojo.get(0);
			_logger.info("Infos sur les lots chargs");
			_logger.info(cojoIter.getComTctLibelle());
			_logger.info(cojoIter);
			
			for(int y = 0; y < infoCojo.size(); y++) {
				_logger.info(infoCojo.get(y).getComTctLibelle());
			}
		}
		
		
	}
	
	public void replaceBookmarks(List<String> bookmarkNames, VdDao daoIter, VxAdresse adresseIter, VdAao aaoIter, VbLotAao lotsIter, VbCommissionSpecifique cojoIter) {				
		//switch(String.valueOf(daoIter.getTymCode().charAt(0))) {
		if(daoIter.getTymCode().equals("01") || daoIter.getTymCode().equals("02") || daoIter.getTymCode().equals("03") ||
				daoIter.getTymCode().equals("04") || daoIter.getTymCode().equals("06") || daoIter.getTymCode().equals("07") ||
				daoIter.getTymCode().equals("08") || daoIter.getTymCode().equals("09") || daoIter.getTymCode().equals("0A")) 
				{
				_logger.info("DAO de fourniture");
				
				// PAGE DE GARDE
				if(bookmarkNames.contains("PG_min_00")) replaceBookmarkByValue("PG_min_00", daoIter.getMinLibelle().toUpperCase());
				if(bookmarkNames.contains("PG_ac_00")) replaceBookmarkByValue("PG_ac_00", daoIter.getStrLibelleLong().toUpperCase());
				if(bookmarkNames.contains("PG_anGestion01_00")) replaceBookmarkByValue("PG_anGestion01_00", String.valueOf(daoIter.getGesCode()));
				if(bookmarkNames.contains("PG_objet_00")) replaceBookmarkByValue("PG_objet_00", daoIter.getDacObjet());
				if(bookmarkNames.contains("PG_moisAnGestion_00")) {
					Calendar c = Calendar.getInstance();
					String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
					String mg = mois + "/" + daoIter.getGesCode();
					replaceBookmarkByValue("PG_moisAnGestion_00", mg);
					}
				
				// PAGE DE TITRE
				if(bookmarkNames.contains("PT_objet_00")) {
					_logger.info("le probleme est se trouve ici & le probleme est se trouve ici le probleme est se trouve ici");
				} // replaceBookmarkByValue("PT_objet_00", daoIter.getDacObjet());
				if(bookmarkNames.contains("PT_ac_00")) replaceBookmarkByValue("PT_ac_00", daoIter.getStrLibelleLong());
				
				// DPAO
				if(bookmarkNames.contains("DPAO_IC_1_1_ac_00")) replaceBookmarkByValue("DPAO_IC_1_1_ac_00", daoIter.getStrLibelleLong().toUpperCase());
				if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_00")) {
						String m = "";
						for(VbLotAao i:infoLots) {
							m = m + i.getLaaObjet()+ "\n";
						}
						replaceBookmarkByValue("DPAO_IC_1_1_table_lots_00", m);
						_logger.info(m);
					}
				//if(bookmarkNames.contains("DPAO_IC_1_2_source_financement_00")) replaceBookmarkByValue("DPAO_IC_1_2_source_financement_00", "");
				if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_00")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_00", adresseIter.getLibdetail());
				/*if(bookmarkNames.contains("DPAO_IC_7_1_clarification_responsable_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_responsable_00", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_adresse_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_adresse_00", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_boite_postale")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_boite_postale", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telephone")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telephone", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telecopie")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telecopie", "");
	*/
				if(bookmarkNames.contains("DPAO_IC_14_6_lieu_destination_00")) replaceBookmarkByValue("DPAO_IC_14_6_lieu_destination_00", "");
				
				if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_00")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_00", daoIter.getAaoDelaiVal().toString());
				if(bookmarkNames.contains("DPAO_IC_20_1_garantie_soumission_00")) replaceBookmarkByValue("DPAO_IC_20_1_garantie_soumission_00", "");
				if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_00")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_00", daoIter.getDacNbrCopieOff().toString());
				
				if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_00")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_00", adresseIter.getLibdetail());
				/*if(bookmarkNames.contains("DPAO_IC_23_1_remise_personne_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_personne_00", "");
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_adresse_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_adresse_00", "");
				
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_email_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_email_00", "");
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_boite_postale_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_boite_postale_00", "");*/
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_date_00")) { 	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_23_1_remise_date_00", date.format(daoIter.getAaoDateRecep()));
				}
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_heure_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_heure_00", daoIter.getAaoHeureRecep());
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_adresse_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_adresse_00", daoIter.getAaoLieuRecep());
				
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_date_00")) {	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_26_1_ouverture_date_00", date.format(daoIter.getAaoDteOuvTec()));
				}
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_heure_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_heure_00", daoIter.getAaoDteHeurOuv());
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_commission_00")) {
					String cojo = "";
					for(VbCommissionSpecifique i:infoCojo) {
						cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
					}
					replaceBookmarkByValue("DPAO_IC_26_1_ouverture_commission_00", cojo);
					_logger.info(cojo);
				}
				if(bookmarkNames.contains("DPAO_IC_39_1_quantite_augmente_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_augmente_00", "");
				if(bookmarkNames.contains("DPAO_IC_39_1_quantite_reduite_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_reduite_00", "");
			}
		
		if(daoIter.getTymCode().equals("01") || daoIter.getTymCode().equals("02") || daoIter.getTymCode().equals("03") ||
				daoIter.getTymCode().equals("04") || daoIter.getTymCode().equals("06") || daoIter.getTymCode().equals("07") ||
				daoIter.getTymCode().equals("08") || daoIter.getTymCode().equals("09") || daoIter.getTymCode().equals("0A")) 
				{
				_logger.info("DAO de fourniture");
				
				// PAGE DE GARDE
				if(bookmarkNames.contains("PG_min_00")) replaceBookmarkByValue("PG_min_00", daoIter.getMinLibelle().toUpperCase());
				if(bookmarkNames.contains("PG_ac_00")) replaceBookmarkByValue("PG_ac_00", daoIter.getStrLibelleLong().toUpperCase());
				if(bookmarkNames.contains("PG_anGestion01_00")) replaceBookmarkByValue("PG_anGestion01_00", String.valueOf(daoIter.getGesCode()));
				if(bookmarkNames.contains("PG_objet_00")) replaceBookmarkByValue("PG_objet_00", daoIter.getDacObjet());
				if(bookmarkNames.contains("PG_moisAnGestion_00")) {
					Calendar c = Calendar.getInstance();
					String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
					String mg = mois + "/" + daoIter.getGesCode();
					replaceBookmarkByValue("PG_moisAnGestion_00", mg);
					}
				
				// PAGE DE TITRE
				if(bookmarkNames.contains("PT_objet_00")) {
					_logger.info("le probleme est se trouve ici & le probleme est se trouve ici le probleme est se trouve ici");
				} // replaceBookmarkByValue("PT_objet_00", daoIter.getDacObjet());
				if(bookmarkNames.contains("PT_ac_00")) replaceBookmarkByValue("PT_ac_00", daoIter.getStrLibelleLong());
				
				// DPAO
				if(bookmarkNames.contains("DPAO_IC_1_1_ac_00")) replaceBookmarkByValue("DPAO_IC_1_1_ac_00", daoIter.getStrLibelleLong().toUpperCase());
				if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_00")) {
						String m = "";
						for(VbLotAao i:infoLots) {
							m = m + i.getLaaObjet()+ "\n";
						}
						replaceBookmarkByValue("DPAO_IC_1_1_table_lots_00", m);
						_logger.info(m);
					}
				//if(bookmarkNames.contains("DPAO_IC_1_2_source_financement_00")) replaceBookmarkByValue("DPAO_IC_1_2_source_financement_00", "");
				if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_00")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_00", adresseIter.getLibdetail());
				/*if(bookmarkNames.contains("DPAO_IC_7_1_clarification_responsable_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_responsable_00", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_adresse_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_adresse_00", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_boite_postale")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_boite_postale", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telephone")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telephone", "");
				if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telecopie")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telecopie", "");
	*/
				if(bookmarkNames.contains("DPAO_IC_14_6_lieu_destination_00")) replaceBookmarkByValue("DPAO_IC_14_6_lieu_destination_00", "");
				
				if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_00")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_00", daoIter.getAaoDelaiVal().toString());
				if(bookmarkNames.contains("DPAO_IC_20_1_garantie_soumission_00")) replaceBookmarkByValue("DPAO_IC_20_1_garantie_soumission_00", "");
				if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_00")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_00", daoIter.getDacNbrCopieOff().toString());
				
				if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_00")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_00", adresseIter.getLibdetail());
				/*if(bookmarkNames.contains("DPAO_IC_23_1_remise_personne_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_personne_00", "");
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_adresse_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_adresse_00", "");
				
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_email_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_email_00", "");
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_boite_postale_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_boite_postale_00", "");*/
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_date_00")) { 	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_23_1_remise_date_00", date.format(daoIter.getAaoDateRecep()));
				}
				if(bookmarkNames.contains("DPAO_IC_23_1_remise_heure_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_heure_00", daoIter.getAaoHeureRecep());
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_adresse_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_adresse_00", daoIter.getAaoLieuRecep());
				
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_date_00")) {	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_26_1_ouverture_date_00", date.format(daoIter.getAaoDteOuvTec()));
				}
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_heure_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_heure_00", daoIter.getAaoDteHeurOuv());
				if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_commission_00")) {
					String cojo = "";
					for(VbCommissionSpecifique i:infoCojo) {
						cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
					}
					replaceBookmarkByValue("DPAO_IC_26_1_ouverture_commission_00", cojo);
					_logger.info(cojo);
				}
				if(bookmarkNames.contains("DPAO_IC_39_1_quantite_augmente_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_augmente_00", "");
				if(bookmarkNames.contains("DPAO_IC_39_1_quantite_reduite_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_reduite_00", "");
			}
			
			if(daoIter.getTymCode().equals("23") ||  daoIter.getTymCode().equals("21") || daoIter.getTymCode().equals("22") ||
					daoIter.getTymCode().equals("26") || daoIter.getTymCode().equals("25") ) {
				// PAGE DE GARDE
							if(bookmarkNames.contains("PG_min_20")) replaceBookmarkByValue("PG_min_20", daoIter.getMinLibelle().toUpperCase());
							if(bookmarkNames.contains("PG_ac_20")) replaceBookmarkByValue("PG_ac_20", daoIter.getStrLibelleLong().toUpperCase());
							if(bookmarkNames.contains("PG_anGestion01_20")) replaceBookmarkByValue("PG_anGestion01_20", String.valueOf(daoIter.getGesCode()));
							if(bookmarkNames.contains("PG_objet_20")) replaceBookmarkByValue("PG_objet_20", daoIter.getDacObjet());
							if(bookmarkNames.contains("PG_moisAnGestion_20")) {
								Calendar c = Calendar.getInstance();
								String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
								String mg = mois + "/" + daoIter.getGesCode();
								replaceBookmarkByValue("PG_moisAnGestion_20", mg);
								}

							// PAGE DE TITRE
							if(bookmarkNames.contains("PT_objet_20")) replaceBookmarkByValue("PT_objet_20", daoIter.getDacObjet());
							if(bookmarkNames.contains("PT_ac_20")) replaceBookmarkByValue("PT_ac_20", daoIter.getStrLibelleLong());
							
							// DONNEES PARTICULIERES DE L'APPEL D'OFFRE (DPAO)
							if(bookmarkNames.contains("DPAO_IC_1_1_ac_20")) replaceBookmarkByValue("DPAO_IC_1_1_ac_20", daoIter.getStrLibelleLong().toUpperCase());
							if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_20"))
								{
									String m = "";
									for(VbLotAao i:infoLots) {
										m = m + i.getLaaObjet()+ "\n";
									}
									replaceBookmarkByValue("DPAO_IC_1_1_table_lots_20", m);
									_logger.info(m);
								}
							
				/*			if(bookmarkNames.contains("DPAO_IC_2_source_financement_20")) 
								{
									String financement = daoIter.getStrLibelleLong() + ": ligne budgetaire " + daoIter.getLaaLbgImputation();
									//financement = financement.toString();
									_logger.info(financement);
									replaceBookmarkByValue("DPAO_IC_2_source_financement_20", financement);
								}*/
							
							if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_20", adresseIter.getLibdetail());
							_logger.info("DPAO_IC_7_1_adresse_clarification_20 remplace");
							//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_20", ""); // clarification d颵t
							//if(bookmarkNames.contains("DPAO_IC_7_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_7_1_boite_postale_20", "");
							//if(bookmarkNames.contains("DPAO_IC_7_1_numero_telephone_20")) replaceBookmarkByValue("DPAO_IC_7_1_numero_telephone_20", "");
							//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_electronique_20", ""); // clarification fin 
							
							/*if(bookmarkNames.contains("DPAO_IC_7_4_lieu_20")) replaceBookmarkByValue("DPAO_IC_7_4_lieu_20", ""); // pour les visites sur site debut
							if(bookmarkNames.contains("DPAO_IC_7_4_date_20")) replaceBookmarkByValue("DPAO_IC_7_4_date_20", ""); 
							if(bookmarkNames.contains("DPAO_IC_7_4_heure_20")) replaceBookmarkByValue("DPAO_IC_7_4_heure_20", ""); // pour les visites sur site fin
				*/			
							//if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", String.valueOf(daoIter.getLaaDelaiExe()));
							
							if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", daoIter.getLaaDelaiExe().toString());
							
							_logger.info("DPAO_IC_17_2_delai_execution_20 remplace");
							if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_20")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_20", daoIter.getAaoDelaiVal().toString());
							if(bookmarkNames.contains("DPAO_IC_20_2_cautionnemant_provisoire_20")) replaceBookmarkByValue("DPAO_IC_20_2_cautionnemant_provisoire_20", aaoIter.getLaaMtCaut().toString());
							if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_20")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_20", daoIter.getDacNbrCopieOff().toString());
							
							if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_20", adresseIter.getLibdetail());
							_logger.info("DPAO_IC_23_1_adresse_remise_20 remplace");
							
							//if(bookmarkNames.contains("DPAO_IC_23_1_personne_20")) replaceBookmarkByValue("DPAO_IC_23_1_personne_20", ""); /* remise des offres debut */
							
							/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_remise")) replaceBookmarkByValue("adresse", adresseIter.getLibdetail());*/
							
							/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_20", "");
							/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_electronique_20", "");
							/*if(bookmarkNames.contains("DPAO_IC_23_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_23_1_boite_postale_20", "");*/
							if(bookmarkNames.contains("DPAO_IC_23_1_date_20")) 
								{ 	
									SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
									replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
								}
							if(bookmarkNames.contains("DPAO_IC_23_1_heure_20")) replaceBookmarkByValue("DPAO_IC_23_1_heure_20", daoIter.getAaoHeureRecep()); // remise des offres fin
							_logger.info("DPAO_IC_23_1_heure_20 remplace");
							
							if(bookmarkNames.contains("DPAO_IC_26_1_lieu_ouverture_20")) replaceBookmarkByValue("DPAO_IC_26_1_lieu_ouverture_20", daoIter.getAaoLieuRecep()); // ouverture des offres debut 
							if(bookmarkNames.contains("DPAO_IC_26_1_date_20")) 
								{	
									SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
									replaceBookmarkByValue("DPAO_IC_26_1_date_20", date.format(daoIter.getAaoDteOuvTec()));
								}
							if(bookmarkNames.contains("DPAO_IC_26_1_heure_20")) replaceBookmarkByValue("DPAO_IC_26_1_heure_20", daoIter.getAaoDteHeurOuv());
							if(bookmarkNames.contains("DPAO_IC_26_1_cojo_20")) {
									String cojo = "";
									for(VbCommissionSpecifique i:infoCojo) {
										cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
									}
									replaceBookmarkByValue("DPAO_IC_26_1_cojo_20", cojo);
									_logger.info(cojo);
								} // ouverture des offres fin 
						
							// FORMULAIRES DE SOUMISSION - AVIS D'APPEL D'OFFRES
							if(bookmarkNames.contains("FS_AAO_1_ac_20")) replaceBookmarkByValue("FS_AAO_1_ac_20", "");
							if(bookmarkNames.contains("FS_AAO_1_source_financement_20")) replaceBookmarkByValue("FS_AAO_1_source_financement_20", "");
							if(bookmarkNames.contains("FS_AAO_1_objet_20")) replaceBookmarkByValue("FS_AAO_1_objet_20", "");
							
							if(bookmarkNames.contains("FS_AAO_2_ac_20")) replaceBookmarkByValue("FS_AAO_2_ac_20", "");
							if(bookmarkNames.contains("FS_AAO_2_objet_20")) replaceBookmarkByValue("FS_AAO_2_objet_20", "");
							if(bookmarkNames.contains("FS_AAO_4_personne_contact_20")) replaceBookmarkByValue("FS_AAO_4_personne_contact_20", "");
							
							if(bookmarkNames.contains("FS_AAO_4_adresse_20")) replaceBookmarkByValue("FS_AAO_4_adresse_20", "");
							if(bookmarkNames.contains("FS_AAO_6_adresse_20")) replaceBookmarkByValue("FS_AAO_6_adresse_20", "");
							if(bookmarkNames.contains("FS_AAO_6_prix_DAO_20")) replaceBookmarkByValue("FS_AAO_6_prix_DAO_20", "");
							
							if(bookmarkNames.contains("FS_AAO_6_mode_paiement_20")) replaceBookmarkByValue("FS_AAO_6_mode_paiement_20", "");
							if(bookmarkNames.contains("FS_AAO_6_mode_acheminement_20")) replaceBookmarkByValue("FS_AAO_6_mode_acheminement_20", "");
							if(bookmarkNames.contains("FS_AAO_7_adresse_depot_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_depot_offre_20", "");
							
							if(bookmarkNames.contains("FS_AAO_7_date_limite_20")) replaceBookmarkByValue("FS_AAO_7_date_limite_20", "");
							if(bookmarkNames.contains("FS_AAO_7_heure_limite_20")) replaceBookmarkByValue("FS_AAO_7_heure_limite_20", "");
							if(bookmarkNames.contains("FS_AAO_7_adresse_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_ouverture_offre_20", "");
							
							if(bookmarkNames.contains("FS_AAO_7_date_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_date_ouverture_offre_20", "");
							if(bookmarkNames.contains("FS_AAO_7_heure_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_heure_ouverture_offre_20", "");
							if(bookmarkNames.contains("FS_AAO_8_cautionnemant_provisoire_20")) replaceBookmarkByValue("FS_AAO_8_cautionnemant_provisoire_20", "");
							
							if(bookmarkNames.contains("FS_AAO_8_delai_validite_20")) replaceBookmarkByValue("FS_AAO_8_delai_validite_20", "");
							if(bookmarkNames.contains("FS_AAO_9_adresse_resultat_20")) replaceBookmarkByValue("FS_AAO_9_adresse_resultat_20", "");
			}
		
		switch(daoIter.getTymCode()) {
		// TRAVAUX		
		case "2": {
			_logger.info("DAO de travaux");
			
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_20")) replaceBookmarkByValue("PG_min_20", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_20")) replaceBookmarkByValue("PG_ac_20", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_20")) replaceBookmarkByValue("PG_anGestion01_20", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_20")) replaceBookmarkByValue("PG_objet_20", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_20")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_20", mg);
				}

			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_objet_20")) replaceBookmarkByValue("PT_objet_20", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_20")) replaceBookmarkByValue("PT_ac_20", daoIter.getStrLibelleLong());
			
			// DONNEES PARTICULIERES DE L'APPEL D'OFFRE (DPAO)
			if(bookmarkNames.contains("DPAO_IC_1_1_ac_20")) replaceBookmarkByValue("DPAO_IC_1_1_ac_20", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_20"))
				{
					String m = "";
					for(VbLotAao i:infoLots) {
						m = m + i.getLaaObjet()+ "\n";
					}
					replaceBookmarkByValue("DPAO_IC_1_1_table_lots_20", m);
					_logger.info(m);
				}
			
/*			if(bookmarkNames.contains("DPAO_IC_2_source_financement_20")) 
				{
					String financement = daoIter.getStrLibelleLong() + ": ligne budgetaire " + daoIter.getLaaLbgImputation();
					//financement = financement.toString();
					_logger.info(financement);
					replaceBookmarkByValue("DPAO_IC_2_source_financement_20", financement);
				}*/
			
			if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_7_1_adresse_clarification_20 remplac");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_20", ""); // clarification dbut
			//if(bookmarkNames.contains("DPAO_IC_7_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_7_1_boite_postale_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_numero_telephone_20")) replaceBookmarkByValue("DPAO_IC_7_1_numero_telephone_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_electronique_20", ""); // clarification fin 
			
			/*if(bookmarkNames.contains("DPAO_IC_7_4_lieu_20")) replaceBookmarkByValue("DPAO_IC_7_4_lieu_20", ""); // pour les visites sur site debut
			if(bookmarkNames.contains("DPAO_IC_7_4_date_20")) replaceBookmarkByValue("DPAO_IC_7_4_date_20", ""); 
			if(bookmarkNames.contains("DPAO_IC_7_4_heure_20")) replaceBookmarkByValue("DPAO_IC_7_4_heure_20", ""); // pour les visites sur site fin
*/			
			//if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", String.valueOf(daoIter.getLaaDelaiExe()));
			
			if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", daoIter.getLaaDelaiExe().toString());
			
			_logger.info("DPAO_IC_17_2_delai_execution_20 remplac");
			if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_20")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_20", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_IC_20_2_cautionnemant_provisoire_20")) replaceBookmarkByValue("DPAO_IC_20_2_cautionnemant_provisoire_20", aaoIter.getLaaMtCaut().toString());
			if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_20")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_20", daoIter.getDacNbrCopieOff().toString());
			
			if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_23_1_adresse_remise_20 remplac");
			
			//if(bookmarkNames.contains("DPAO_IC_23_1_personne_20")) replaceBookmarkByValue("DPAO_IC_23_1_personne_20", ""); /* remise des offres debut */
			
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_remise")) replaceBookmarkByValue("adresse", adresseIter.getLibdetail());*/
			
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_20", "");
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_electronique_20", "");
			/*if(bookmarkNames.contains("DPAO_IC_23_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_23_1_boite_postale_20", "");*/
			if(bookmarkNames.contains("DPAO_IC_23_1_date_20")) 
				{ 	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
				}
			if(bookmarkNames.contains("DPAO_IC_23_1_heure_20")) replaceBookmarkByValue("DPAO_IC_23_1_heure_20", daoIter.getAaoHeureRecep()); // remise des offres fin
			_logger.info("DPAO_IC_23_1_heure_20 remplac");
			
			if(bookmarkNames.contains("DPAO_IC_26_1_lieu_ouverture_20")) replaceBookmarkByValue("DPAO_IC_26_1_lieu_ouverture_20", daoIter.getAaoLieuRecep()); // ouverture des offres debut 
			if(bookmarkNames.contains("DPAO_IC_26_1_date_20")) 
				{	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_26_1_date_20", date.format(daoIter.getAaoDteOuvTec()));
				}
			if(bookmarkNames.contains("DPAO_IC_26_1_heure_20")) replaceBookmarkByValue("DPAO_IC_26_1_heure_20", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DPAO_IC_26_1_cojo_20")) {
					String cojo = "";
					for(VbCommissionSpecifique i:infoCojo) {
						cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
					}
					replaceBookmarkByValue("DPAO_IC_26_1_cojo_20", cojo);
					_logger.info(cojo);
				} // ouverture des offres fin 
		
			// FORMULAIRES DE SOUMISSION - AVIS D'APPEL D'OFFRES
			if(bookmarkNames.contains("FS_AAO_1_ac_20")) replaceBookmarkByValue("FS_AAO_1_ac_20", "");
			if(bookmarkNames.contains("FS_AAO_1_source_financement_20")) replaceBookmarkByValue("FS_AAO_1_source_financement_20", "");
			if(bookmarkNames.contains("FS_AAO_1_objet_20")) replaceBookmarkByValue("FS_AAO_1_objet_20", "");
			
			if(bookmarkNames.contains("FS_AAO_2_ac_20")) replaceBookmarkByValue("FS_AAO_2_ac_20", "");
			if(bookmarkNames.contains("FS_AAO_2_objet_20")) replaceBookmarkByValue("FS_AAO_2_objet_20", "");
			if(bookmarkNames.contains("FS_AAO_4_personne_contact_20")) replaceBookmarkByValue("FS_AAO_4_personne_contact_20", "");
			
			if(bookmarkNames.contains("FS_AAO_4_adresse_20")) replaceBookmarkByValue("FS_AAO_4_adresse_20", "");
			if(bookmarkNames.contains("FS_AAO_6_adresse_20")) replaceBookmarkByValue("FS_AAO_6_adresse_20", "");
			if(bookmarkNames.contains("FS_AAO_6_prix_DAO_20")) replaceBookmarkByValue("FS_AAO_6_prix_DAO_20", "");
			
			if(bookmarkNames.contains("FS_AAO_6_mode_paiement_20")) replaceBookmarkByValue("FS_AAO_6_mode_paiement_20", "");
			if(bookmarkNames.contains("FS_AAO_6_mode_acheminement_20")) replaceBookmarkByValue("FS_AAO_6_mode_acheminement_20", "");
			if(bookmarkNames.contains("FS_AAO_7_adresse_depot_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_depot_offre_20", "");
			
			if(bookmarkNames.contains("FS_AAO_7_date_limite_20")) replaceBookmarkByValue("FS_AAO_7_date_limite_20", "");
			if(bookmarkNames.contains("FS_AAO_7_heure_limite_20")) replaceBookmarkByValue("FS_AAO_7_heure_limite_20", "");
			if(bookmarkNames.contains("FS_AAO_7_adresse_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_ouverture_offre_20", "");
			
			if(bookmarkNames.contains("FS_AAO_7_date_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_date_ouverture_offre_20", "");
			if(bookmarkNames.contains("FS_AAO_7_heure_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_heure_ouverture_offre_20", "");
			if(bookmarkNames.contains("FS_AAO_8_cautionnemant_provisoire_20")) replaceBookmarkByValue("FS_AAO_8_cautionnemant_provisoire_20", "");
			
			if(bookmarkNames.contains("FS_AAO_8_delai_validite_20")) replaceBookmarkByValue("FS_AAO_8_delai_validite_20", "");
			if(bookmarkNames.contains("FS_AAO_9_adresse_resultat_20")) replaceBookmarkByValue("FS_AAO_9_adresse_resultat_20", "");
		}
		break;
		
		case "20": {
			_logger.info("DAO de travaux");
			
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_20")) replaceBookmarkByValue("PG_min_20", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_20")) replaceBookmarkByValue("PG_ac_20", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_20")) replaceBookmarkByValue("PG_anGestion01_20", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_20")) replaceBookmarkByValue("PG_objet_20", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_20")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_20", mg);
				}

			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_objet_20")) replaceBookmarkByValue("PT_objet_20", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_20")) replaceBookmarkByValue("PT_ac_20", daoIter.getStrLibelleLong());
			
			// DONNEES PARTICULIERES DE L'APPEL D'OFFRE (DPAO)
			if(bookmarkNames.contains("DPAO_IC_1_1_ac_20")) replaceBookmarkByValue("DPAO_IC_1_1_ac_20", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_20"))
				{
					String m = "";
					for(VbLotAao i:infoLots) {
						m = m + i.getLaaObjet()+ "\n";
					}
					replaceBookmarkByValue("DPAO_IC_1_1_table_lots_20", m);
					_logger.info(m);
				}
			
/*			if(bookmarkNames.contains("DPAO_IC_2_source_financement_20")) 
				{
					String financement = daoIter.getStrLibelleLong() + ": ligne budgetaire " + daoIter.getLaaLbgImputation();
					//financement = financement.toString();
					_logger.info(financement);
					replaceBookmarkByValue("DPAO_IC_2_source_financement_20", financement);
				}*/
			
			if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_7_1_adresse_clarification_20 remplac");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_20", ""); // clarification dbut
			//if(bookmarkNames.contains("DPAO_IC_7_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_7_1_boite_postale_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_numero_telephone_20")) replaceBookmarkByValue("DPAO_IC_7_1_numero_telephone_20", "");
			//if(bookmarkNames.contains("DPAO_IC_7_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_electronique_20", ""); // clarification fin 
			
			/*if(bookmarkNames.contains("DPAO_IC_7_4_lieu_20")) replaceBookmarkByValue("DPAO_IC_7_4_lieu_20", ""); // pour les visites sur site debut
			if(bookmarkNames.contains("DPAO_IC_7_4_date_20")) replaceBookmarkByValue("DPAO_IC_7_4_date_20", ""); 
			if(bookmarkNames.contains("DPAO_IC_7_4_heure_20")) replaceBookmarkByValue("DPAO_IC_7_4_heure_20", ""); // pour les visites sur site fin
*/			
			//if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", String.valueOf(daoIter.getLaaDelaiExe()));
			
			if(bookmarkNames.contains("DPAO_IC_17_2_delai_execution_20")) replaceBookmarkByValue("DPAO_IC_17_2_delai_execution_20", daoIter.getLaaDelaiExe().toString());
			
			_logger.info("DPAO_IC_17_2_delai_execution_20 remplac");
			if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_20")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_20", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_IC_20_2_cautionnemant_provisoire_20")) replaceBookmarkByValue("DPAO_IC_20_2_cautionnemant_provisoire_20", aaoIter.getLaaMtCaut().toString());
			if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_20")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_20", daoIter.getDacNbrCopieOff().toString());
			
			if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_20", adresseIter.getLibdetail());
			_logger.info("DPAO_IC_23_1_adresse_remise_20 remplac");
			
			//if(bookmarkNames.contains("DPAO_IC_23_1_personne_20")) replaceBookmarkByValue("DPAO_IC_23_1_personne_20", ""); /* remise des offres debut */
			
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_remise")) replaceBookmarkByValue("adresse", adresseIter.getLibdetail());*/
			
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_20", "");
			/*if(bookmarkNames.contains("DPAO_IC_23_1_adresse_electronique_20")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_electronique_20", "");
			/*if(bookmarkNames.contains("DPAO_IC_23_1_boite_postale_20")) replaceBookmarkByValue("DPAO_IC_23_1_boite_postale_20", "");*/
			if(bookmarkNames.contains("DPAO_IC_23_1_date_20")) 
				{ 	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
				}
			if(bookmarkNames.contains("DPAO_IC_23_1_heure_20")) replaceBookmarkByValue("DPAO_IC_23_1_heure_20", daoIter.getAaoHeureRecep()); // remise des offres fin
			_logger.info("DPAO_IC_23_1_heure_20 remplac");
			
			if(bookmarkNames.contains("DPAO_IC_26_1_lieu_ouverture_20")) replaceBookmarkByValue("DPAO_IC_26_1_lieu_ouverture_20", daoIter.getAaoLieuRecep()); // ouverture des offres debut 
			if(bookmarkNames.contains("DPAO_IC_26_1_date_20")) 
				{	
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					replaceBookmarkByValue("DPAO_IC_26_1_date_20", date.format(daoIter.getAaoDteOuvTec()));
				}
			if(bookmarkNames.contains("DPAO_IC_26_1_heure_20")) replaceBookmarkByValue("DPAO_IC_26_1_heure_20", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DPAO_IC_26_1_cojo_20")) {
					String cojo = "";
					for(VbCommissionSpecifique i:infoCojo) {
						cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
					}
					replaceBookmarkByValue("DPAO_IC_26_1_cojo_20", cojo);
					_logger.info(cojo);
				} // ouverture des offres fin 
		
			// FORMULAIRES DE SOUMISSION - AVIS D'APPEL D'OFFRES
			if(bookmarkNames.contains("FS_AAO_1_ac_20")) replaceBookmarkByValue("FS_AAO_1_ac_20", "");
			if(bookmarkNames.contains("FS_AAO_1_source_financement_20")) replaceBookmarkByValue("FS_AAO_1_source_financement_20", "");
			if(bookmarkNames.contains("FS_AAO_1_objet_20")) replaceBookmarkByValue("FS_AAO_1_objet_20", "");
			
			if(bookmarkNames.contains("FS_AAO_2_ac_20")) replaceBookmarkByValue("FS_AAO_2_ac_20", "");
			if(bookmarkNames.contains("FS_AAO_2_objet_20")) replaceBookmarkByValue("FS_AAO_2_objet_20", "");
			if(bookmarkNames.contains("FS_AAO_4_personne_contact_20")) replaceBookmarkByValue("FS_AAO_4_personne_contact_20", "");
			
			if(bookmarkNames.contains("FS_AAO_4_adresse_20")) replaceBookmarkByValue("FS_AAO_4_adresse_20", "");
			if(bookmarkNames.contains("FS_AAO_6_adresse_20")) replaceBookmarkByValue("FS_AAO_6_adresse_20", "");
			if(bookmarkNames.contains("FS_AAO_6_prix_DAO_20")) replaceBookmarkByValue("FS_AAO_6_prix_DAO_20", "");
			
			if(bookmarkNames.contains("FS_AAO_6_mode_paiement_20")) replaceBookmarkByValue("FS_AAO_6_mode_paiement_20", "");
			if(bookmarkNames.contains("FS_AAO_6_mode_acheminement_20")) replaceBookmarkByValue("FS_AAO_6_mode_acheminement_20", "");
			if(bookmarkNames.contains("FS_AAO_7_adresse_depot_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_depot_offre_20", "");
			
			if(bookmarkNames.contains("FS_AAO_7_date_limite_20")) replaceBookmarkByValue("FS_AAO_7_date_limite_20", "");
			if(bookmarkNames.contains("FS_AAO_7_heure_limite_20")) replaceBookmarkByValue("FS_AAO_7_heure_limite_20", "");
			if(bookmarkNames.contains("FS_AAO_7_adresse_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_adresse_ouverture_offre_20", "");
			
			if(bookmarkNames.contains("FS_AAO_7_date_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_date_ouverture_offre_20", "");
			if(bookmarkNames.contains("FS_AAO_7_heure_ouverture_offre_20")) replaceBookmarkByValue("FS_AAO_7_heure_ouverture_offre_20", "");
			if(bookmarkNames.contains("FS_AAO_8_cautionnemant_provisoire_20")) replaceBookmarkByValue("FS_AAO_8_cautionnemant_provisoire_20", "");
			
			if(bookmarkNames.contains("FS_AAO_8_delai_validite_20")) replaceBookmarkByValue("FS_AAO_8_delai_validite_20", "");
			if(bookmarkNames.contains("FS_AAO_9_adresse_resultat_20")) replaceBookmarkByValue("FS_AAO_9_adresse_resultat_20", "");
		}
		break;
		
		// FOURNITURE
		case "0" : {
			_logger.info("DAO de fourniture");
			
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_00")) replaceBookmarkByValue("PG_min_00", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_00")) replaceBookmarkByValue("PG_ac_00", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_00")) replaceBookmarkByValue("PG_anGestion01_00", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_00")) replaceBookmarkByValue("PG_objet_00", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_00")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_00", mg);
				}
			
			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_objet_00")) {
				_logger.info("le probleme est se trouve ici & le probleme est se trouve ici le probleme est se trouve ici");
			} // replaceBookmarkByValue("PT_objet_00", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_00")) replaceBookmarkByValue("PT_ac_00", daoIter.getStrLibelleLong());
			
			// DPAO
			if(bookmarkNames.contains("DPAO_IC_1_1_ac_00")) replaceBookmarkByValue("DPAO_IC_1_1_ac_00", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_00")) {
					String m = "";
					for(VbLotAao i:infoLots) {
						m = m + i.getLaaObjet()+ "\n";
					}
					replaceBookmarkByValue("DPAO_IC_1_1_table_lots_00", m);
					_logger.info(m);
				}
			//if(bookmarkNames.contains("DPAO_IC_1_2_source_financement_00")) replaceBookmarkByValue("DPAO_IC_1_2_source_financement_00", "");
			if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_00")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_00", adresseIter.getLibdetail());
			/*if(bookmarkNames.contains("DPAO_IC_7_1_clarification_responsable_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_responsable_00", "");
			if(bookmarkNames.contains("DPAO_IC_7_1_clarification_adresse_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_adresse_00", "");
			if(bookmarkNames.contains("DPAO_IC_7_1_clarification_boite_postale")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_boite_postale", "");
			if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telephone")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telephone", "");
			if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telecopie")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telecopie", "");
*/
			if(bookmarkNames.contains("DPAO_IC_14_6_lieu_destination_00")) replaceBookmarkByValue("DPAO_IC_14_6_lieu_destination_00", "");
			
			if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_00")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_00", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_IC_20_1_garantie_soumission_00")) replaceBookmarkByValue("DPAO_IC_20_1_garantie_soumission_00", "");
			if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_00")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_00", daoIter.getDacNbrCopieOff().toString());
			
			if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_00")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_00", adresseIter.getLibdetail());
			/*if(bookmarkNames.contains("DPAO_IC_23_1_remise_personne_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_personne_00", "");
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_adresse_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_adresse_00", "");
			
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_email_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_email_00", "");
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_boite_postale_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_boite_postale_00", "");*/
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_date_00")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_IC_23_1_remise_date_00", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("DPAO_IC_23_1_remise_heure_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_heure_00", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_adresse_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_adresse_00", daoIter.getAaoLieuRecep());
			
			if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_date_00")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_IC_26_1_ouverture_date_00", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_heure_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_heure_00", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_commission_00")) {
				String cojo = "";
				for(VbCommissionSpecifique i:infoCojo) {
					cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
				}
				replaceBookmarkByValue("DPAO_IC_26_1_ouverture_commission_00", cojo);
				_logger.info(cojo);
			}
			if(bookmarkNames.contains("DPAO_IC_39_1_quantite_augmente_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_augmente_00", "");
			if(bookmarkNames.contains("DPAO_IC_39_1_quantite_reduite_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_reduite_00", "");
			
		}break;
		
		// FOURNITURE
				case "00" : {
					_logger.info("DAO de fourniture");
					
					// PAGE DE GARDE
					if(bookmarkNames.contains("PG_min_00")) replaceBookmarkByValue("PG_min_00", daoIter.getMinLibelle().toUpperCase());
					if(bookmarkNames.contains("PG_ac_00")) replaceBookmarkByValue("PG_ac_00", daoIter.getStrLibelleLong().toUpperCase());
					if(bookmarkNames.contains("PG_anGestion01_00")) replaceBookmarkByValue("PG_anGestion01_00", String.valueOf(daoIter.getGesCode()));
					if(bookmarkNames.contains("PG_objet_00")) replaceBookmarkByValue("PG_objet_00", daoIter.getDacObjet());
					if(bookmarkNames.contains("PG_moisAnGestion_00")) {
						Calendar c = Calendar.getInstance();
						String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
						String mg = mois + "/" + daoIter.getGesCode();
						replaceBookmarkByValue("PG_moisAnGestion_00", mg);
						}
					
					// PAGE DE TITRE
					if(bookmarkNames.contains("PT_objet_00")) {
						_logger.info("le probleme est se trouve ici & le probleme est se trouve ici le probleme est se trouve ici");
					} // replaceBookmarkByValue("PT_objet_00", daoIter.getDacObjet());
					if(bookmarkNames.contains("PT_ac_00")) replaceBookmarkByValue("PT_ac_00", daoIter.getStrLibelleLong());
					
					// DPAO
					if(bookmarkNames.contains("DPAO_IC_1_1_ac_00")) replaceBookmarkByValue("DPAO_IC_1_1_ac_00", daoIter.getStrLibelleLong().toUpperCase());
					if(bookmarkNames.contains("DPAO_IC_1_1_table_lots_00")) {
							String m = "";
							for(VbLotAao i:infoLots) {
								m = m + i.getLaaObjet()+ "\n";
							}
							replaceBookmarkByValue("DPAO_IC_1_1_table_lots_00", m);
							_logger.info(m);
						}
					//if(bookmarkNames.contains("DPAO_IC_1_2_source_financement_00")) replaceBookmarkByValue("DPAO_IC_1_2_source_financement_00", "");
					if (bookmarkNames.contains("DPAO_IC_7_1_adresse_clarification_00")) replaceBookmarkByValue("DPAO_IC_7_1_adresse_clarification_00", adresseIter.getLibdetail());
					/*if(bookmarkNames.contains("DPAO_IC_7_1_clarification_responsable_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_responsable_00", "");
					if(bookmarkNames.contains("DPAO_IC_7_1_clarification_adresse_00")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_adresse_00", "");
					if(bookmarkNames.contains("DPAO_IC_7_1_clarification_boite_postale")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_boite_postale", "");
					if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telephone")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telephone", "");
					if(bookmarkNames.contains("DPAO_IC_7_1_clarification_num_telecopie")) replaceBookmarkByValue("DPAO_IC_7_1_clarification_num_telecopie", "");
		*/
					if(bookmarkNames.contains("DPAO_IC_14_6_lieu_destination_00")) replaceBookmarkByValue("DPAO_IC_14_6_lieu_destination_00", "");
					
					if(bookmarkNames.contains("DPAO_IC_19_1_delai_validite_00")) replaceBookmarkByValue("DPAO_IC_19_1_delai_validite_00", daoIter.getAaoDelaiVal().toString());
					if(bookmarkNames.contains("DPAO_IC_20_1_garantie_soumission_00")) replaceBookmarkByValue("DPAO_IC_20_1_garantie_soumission_00", "");
					if(bookmarkNames.contains("DPAO_IC_21_1_nombre_copie_00")) replaceBookmarkByValue("DPAO_IC_21_1_nombre_copie_00", daoIter.getDacNbrCopieOff().toString());
					
					if (bookmarkNames.contains("DPAO_IC_23_1_adresse_remise_00")) replaceBookmarkByValue("DPAO_IC_23_1_adresse_remise_00", adresseIter.getLibdetail());
					/*if(bookmarkNames.contains("DPAO_IC_23_1_remise_personne_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_personne_00", "");
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_adresse_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_adresse_00", "");
					
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_email_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_email_00", "");
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_boite_postale_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_boite_postale_00", "");*/
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_date_00")) { 	
						SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
						replaceBookmarkByValue("DPAO_IC_23_1_remise_date_00", date.format(daoIter.getAaoDateRecep()));
					}
					if(bookmarkNames.contains("DPAO_IC_23_1_remise_heure_00")) replaceBookmarkByValue("DPAO_IC_23_1_remise_heure_00", daoIter.getAaoHeureRecep());
					if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_adresse_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_adresse_00", daoIter.getAaoLieuRecep());
					
					if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_date_00")) {	
						SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
						replaceBookmarkByValue("DPAO_IC_26_1_ouverture_date_00", date.format(daoIter.getAaoDteOuvTec()));
					}
					if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_heure_00")) replaceBookmarkByValue("DPAO_IC_26_1_ouverture_heure_00", daoIter.getAaoDteHeurOuv());
					if(bookmarkNames.contains("DPAO_IC_26_1_ouverture_commission_00")) {
						String cojo = "";
						for(VbCommissionSpecifique i:infoCojo) {
							cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
						}
						replaceBookmarkByValue("DPAO_IC_26_1_ouverture_commission_00", cojo);
						_logger.info(cojo);
					}
					if(bookmarkNames.contains("DPAO_IC_39_1_quantite_augmente_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_augmente_00", "");
					if(bookmarkNames.contains("DPAO_IC_39_1_quantite_reduite_00")) replaceBookmarkByValue("DPAO_IC_39_1_quantite_reduite_00", "");
					
				}break;
		
		
		// PRESTATIONS
		case "1" : {
			_logger.info("DAO de prestations");
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_01")) replaceBookmarkByValue("PG_min_01", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_01")) replaceBookmarkByValue("PG_ac_01",  daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_01")) replaceBookmarkByValue("PG_anGestion01_01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_01")) replaceBookmarkByValue("PG_objet_01", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_01")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_00", mg);
				}
			
			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_nom_projet_01")) replaceBookmarkByValue("PT_nom_projet_01", "");
			if(bookmarkNames.contains("PT_objet_01")) replaceBookmarkByValue("PT_objet_01", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_01")) replaceBookmarkByValue("PT_ac_01", daoIter.getStrLibelleLong());
			
			// LETTRE D'INVITATION
			if(bookmarkNames.contains("LI_1_ac_01")) replaceBookmarkByValue("LI_1_ac_01", daoIter.getStrLibelleLong()); 
			if(bookmarkNames.contains("LI_1_ac02_01")) replaceBookmarkByValue("LI_1_ac02_01", daoIter.getStrLibelleLong());
			if(bookmarkNames.contains("LI_1_source_financement_01")) replaceBookmarkByValue("LI_1_source_financement_01", ""); /* il est reste à trouver la solution */ 
			if(bookmarkNames.contains("LI_1_objet_01")) replaceBookmarkByValue("LI_1_objet_01", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("LI_1_depot_adresse_01")) replaceBookmarkByValue("LI_1_depot_adresse_01", adresseIter.getLibdetail());
			
			// DEMANDE DE PROPOSITION
			if(bookmarkNames.contains("DP_IC_1_1_ac_01")) replaceBookmarkByValue("DP_IC_1_1_ac_01", daoIter.getStrLibelleLong());
			if(bookmarkNames.contains("DP_IC_1_3_rep_AC_01")) replaceBookmarkByValue("DP_IC_1_3_rep_AC_01", adresseIter.getLibdetail());			
			/*if(bookmarkNames.contains("DP_IC_1_3_rep_adresse_01")) replaceBookmarkByValue("DP_IC_1_3_rep_adresse_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_telephone_01")) replaceBookmarkByValue("DP_IC_1_3_rep_telephone_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_telecopie_01")) replaceBookmarkByValue("DP_IC_1_3_rep_telecopie_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_email_01")) replaceBookmarkByValue("DP_IC_1_3_rep_email_01", "");*/			
			if(bookmarkNames.contains("DP_IC_6_delai_validite_01")) replaceBookmarkByValue("DP_IC_6_delai_validite_01", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DP_IC_8_1_eclair_adresse_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_adresse_01", "");
			
			if(bookmarkNames.contains("DP_IC_8_1_eclair_telecopie_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_telecopie_01", "");
			if(bookmarkNames.contains("DP_IC_8_1_eclair_couriel_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_couriel_01", "");			
			if(bookmarkNames.contains("DP_IC_13_3_nombre_copie01_01")) replaceBookmarkByValue("DP_IC_13_3_nombre_copie01_01", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DP_IC_13_3_nombre_copie02_01")) replaceBookmarkByValue("DP_IC_13_3_nombre_copie02_01", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_adresse_01")) replaceBookmarkByValue("DP_IC_13_5_proposition_depot_adresse_01", adresseIter.getLibdetail());
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_date_01")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
			}			
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_heure_01")) replaceBookmarkByValue("DP_IC_13_5_proposition_depot_heure_01", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DP_IC_13_5_lieu_negociation_01")) replaceBookmarkByValue("DP_IC_13_5_lieu_negociation_01", "");
			if(bookmarkNames.contains("DP_IC_13_5_commission_01")) {
				String cojo = "";
				for(VbCommissionSpecifique i:infoCojo) {
					cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
				}
				replaceBookmarkByValue("DP_IC_13_5_commission_01", cojo);
				_logger.info(cojo);
			} // cojo
		}
		break;
		
		case "10" : {
			_logger.info("DAO de prestations");
			// PAGE DE GARDE
			if(bookmarkNames.contains("PG_min_01")) replaceBookmarkByValue("PG_min_01", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac_01")) replaceBookmarkByValue("PG_ac_01",  daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_anGestion01_01")) replaceBookmarkByValue("PG_anGestion01_01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_objet_01")) replaceBookmarkByValue("PG_objet_01", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_moisAnGestion_01")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion_00", mg);
				}
			
			// PAGE DE TITRE
			if(bookmarkNames.contains("PT_nom_projet_01")) replaceBookmarkByValue("PT_nom_projet_01", "");
			if(bookmarkNames.contains("PT_objet_01")) replaceBookmarkByValue("PT_objet_01", daoIter.getDacObjet());
			if(bookmarkNames.contains("PT_ac_01")) replaceBookmarkByValue("PT_ac_01", daoIter.getStrLibelleLong());
			
			// LETTRE D'INVITATION
			if(bookmarkNames.contains("LI_1_ac_01")) replaceBookmarkByValue("LI_1_ac_01", daoIter.getStrLibelleLong()); 
			if(bookmarkNames.contains("LI_1_ac02_01")) replaceBookmarkByValue("LI_1_ac02_01", daoIter.getStrLibelleLong());
			if(bookmarkNames.contains("LI_1_source_financement_01")) replaceBookmarkByValue("LI_1_source_financement_01", ""); /* il est reste à trouver la solution */ 
			if(bookmarkNames.contains("LI_1_objet_01")) replaceBookmarkByValue("LI_1_objet_01", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("LI_1_depot_adresse_01")) replaceBookmarkByValue("LI_1_depot_adresse_01", adresseIter.getLibdetail());
			
			// DEMANDE DE PROPOSITION
			if(bookmarkNames.contains("DP_IC_1_1_ac_01")) replaceBookmarkByValue("DP_IC_1_1_ac_01", daoIter.getStrLibelleLong());
			if(bookmarkNames.contains("DP_IC_1_3_rep_AC_01")) replaceBookmarkByValue("DP_IC_1_3_rep_AC_01", adresseIter.getLibdetail());			
			/*if(bookmarkNames.contains("DP_IC_1_3_rep_adresse_01")) replaceBookmarkByValue("DP_IC_1_3_rep_adresse_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_telephone_01")) replaceBookmarkByValue("DP_IC_1_3_rep_telephone_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_telecopie_01")) replaceBookmarkByValue("DP_IC_1_3_rep_telecopie_01", "");
			if(bookmarkNames.contains("DP_IC_1_3_rep_email_01")) replaceBookmarkByValue("DP_IC_1_3_rep_email_01", "");*/			
			if(bookmarkNames.contains("DP_IC_6_delai_validite_01")) replaceBookmarkByValue("DP_IC_6_delai_validite_01", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DP_IC_8_1_eclair_adresse_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_adresse_01", "");
			
			if(bookmarkNames.contains("DP_IC_8_1_eclair_telecopie_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_telecopie_01", "");
			if(bookmarkNames.contains("DP_IC_8_1_eclair_couriel_01")) replaceBookmarkByValue("DP_IC_8_1_eclair_couriel_01", "");			
			if(bookmarkNames.contains("DP_IC_13_3_nombre_copie01_01")) replaceBookmarkByValue("DP_IC_13_3_nombre_copie01_01", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DP_IC_13_3_nombre_copie02_01")) replaceBookmarkByValue("DP_IC_13_3_nombre_copie02_01", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_adresse_01")) replaceBookmarkByValue("DP_IC_13_5_proposition_depot_adresse_01", adresseIter.getLibdetail());
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_date_01")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_IC_23_1_date_20", date.format(daoIter.getAaoDateRecep()));
			}			
			if(bookmarkNames.contains("DP_IC_13_5_proposition_depot_heure_01")) replaceBookmarkByValue("DP_IC_13_5_proposition_depot_heure_01", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("DP_IC_13_5_lieu_negociation_01")) replaceBookmarkByValue("DP_IC_13_5_lieu_negociation_01", "");
			if(bookmarkNames.contains("DP_IC_13_5_commission_01")) {
				String cojo = "";
				for(VbCommissionSpecifique i:infoCojo) {
					cojo = cojo + i.getComTctLibelle()+ System.getProperty("line.separator");
				}
				replaceBookmarkByValue("DP_IC_13_5_commission_01", cojo);
				_logger.info(cojo);
			} // cojo
		}
		break;
		
		case "05" : // FOURNITURE DE CARBURANT LEGER
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Donnes particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // à faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // à faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "16" : // DAO RESTAURATION
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Donnes particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // à faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // à faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "15" : // LOCATION DE MAIN D'OEUVRE - (Services courants)
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Donnes particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // à faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // à faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "19" :	// GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Donnes particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // à faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // à faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "14" : // SECURITE PRIVEE ou GARDIENNAGE
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Donnes particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // à faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // à faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;
		
		case "13" : // ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
		{
			//Page de garde
			if(bookmarkNames.contains("PG_min")) replaceBookmarkByValue("PG_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("PG_ac")) replaceBookmarkByValue("PG_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("PG_objet")) replaceBookmarkByValue("PG_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("PG_anGestion")) replaceBookmarkByValue("PG_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("PG_moisAnGestion")) {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoIter.getGesCode();
				replaceBookmarkByValue("PG_moisAnGestion", mg);
				}
				
			if(bookmarkNames.contains("IP_min")) replaceBookmarkByValue("IP_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("IP_ac")) replaceBookmarkByValue("IP_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("IP_objet")) replaceBookmarkByValue("IP_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("IP_anGestion")) replaceBookmarkByValue("IP_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("IP_imputation")) replaceBookmarkByValue("IP_imputation", daoIter.getLaaLbgImputation());
			
			// Lettre d'invitation
			if(bookmarkNames.contains("LI_anGestion")) replaceBookmarkByValue("LI_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac")) replaceBookmarkByValue("LI_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_anGestion01")) replaceBookmarkByValue("LI_anGestion01", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("LI_ac01")) replaceBookmarkByValue("LI_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("LI_adresse")) replaceBookmarkByValue("LI_adresse", adresseIter.getLibdetail());
			if(bookmarkNames.contains("LI_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("LI_reception_heure")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("LI_reception_lieu")) replaceBookmarkByValue("LI_reception_heure", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("LI_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("LI_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("LI_ouverture_heure")) replaceBookmarkByValue("LI_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("LI_ouverture_lieu")) replaceBookmarkByValue("LI_ouverture_lieu", daoIter.getAaoLieuRecep());
			
			//Avis d'appel d'offre
			if(bookmarkNames.contains("AAO_ac")) replaceBookmarkByValue("AAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_min")) replaceBookmarkByValue("AAO_min", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("AAO_objet")) replaceBookmarkByValue("AAO_objet", daoIter.getDacObjet());
			if(bookmarkNames.contains("AAO_nb_lot")) replaceBookmarkByValue("AAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("AAO_fin_ac")) replaceBookmarkByValue("AAO_fin_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("AAO_fin_imputation")) replaceBookmarkByValue("AAO_fin_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("AAO_fin_anGestion")) replaceBookmarkByValue("AAO_fin_anGestion", String.valueOf(daoIter.getGesCode()));
			if(bookmarkNames.contains("AAO_cout_dao")) replaceBookmarkByValue("AAO_cout_dao", String.valueOf(daoIter.getAaoCoutDac()));
			if(bookmarkNames.contains("AAO_adr_retrait_dao")) replaceBookmarkByValue("AAO_adr_retrait_dao", adresseIter.getLibdetail());
			if(bookmarkNames.contains("AAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("AAO_reception_heure")) replaceBookmarkByValue("AAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("AAO_reception_lieu")) replaceBookmarkByValue("AAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("AAO_delai_validite")) replaceBookmarkByValue("AAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("AAO_ouvertue_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("AAO_ouvertue_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("AAO_ouvertue_heure")) replaceBookmarkByValue("AAO_ouvertue_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("AAO_ouvertue_lieu")) replaceBookmarkByValue("AAO_ouvertue_lieu", daoIter.getAaoLieuRecep());
				
			// Reglement particulier de l'appel d'offre
			if(bookmarkNames.contains("RPAO_AC")) replaceBookmarkByValue("RPAO_AC", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("RPAO_objet")) replaceBookmarkByValue("RPAO_objet", daoIter.getMinLibelle().toUpperCase());
			if(bookmarkNames.contains("RPAO_nb_lot")) replaceBookmarkByValue("RPAO_nb_lot", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_nb_lot01")) replaceBookmarkByValue("RPAO_nb_lot01", String.valueOf(daoIter.getAaoNbrLot()));
			if(bookmarkNames.contains("RPAO_reception_date")) { 	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_reception_date", date.format(daoIter.getAaoDateRecep()));
			}
			if(bookmarkNames.contains("RPAO_reception_heure")) replaceBookmarkByValue("RPAO_reception_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("RPAO_reception_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
			if(bookmarkNames.contains("RPAO_ouverture_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("RPAO_ouverture_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("RPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_ouverture_lieu", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_delai_validite")) replaceBookmarkByValue("RPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("RPAO_ouverture_heure")) replaceBookmarkByValue("RPAO_ouverture_heure", daoIter.getAaoDteHeurOuv());
			if(bookmarkNames.contains("RPAO_nb_copie")) replaceBookmarkByValue("RPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
				
			// Donnes particulier de l'appel d'offre
			if(bookmarkNames.contains("DPAO_ac")) replaceBookmarkByValue("DPAO_ac", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_ac01")) replaceBookmarkByValue("DPAO_ac01", daoIter.getStrLibelleLong().toUpperCase());
			if(bookmarkNames.contains("DPAO_imputation")) replaceBookmarkByValue("DPAO_imputation", daoIter.getLaaLbgImputation());
			if(bookmarkNames.contains("DPAO_dotation")) // à faire
			if(bookmarkNames.contains("DPAO_lieu_livraison")) // à faire
			if(bookmarkNames.contains("DPAO_delai_validite")) replaceBookmarkByValue("DPAO_delai_validite", daoIter.getAaoDelaiVal().toString());
			if(bookmarkNames.contains("DPAO_nb_copie")) replaceBookmarkByValue("DPAO_nb_copie", daoIter.getDacNbrCopieOff().toString());
			if(bookmarkNames.contains("DPAO_remise_date")) {	
				SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
				replaceBookmarkByValue("DPAO_remise_date", date.format(daoIter.getAaoDteOuvTec()));
			}
			if(bookmarkNames.contains("DPAO_remise_heure")) replaceBookmarkByValue("DPAO_remise_heure", daoIter.getAaoHeureRecep());
			if(bookmarkNames.contains("DPAO_ouverture_lieu")) replaceBookmarkByValue("RPAO_reception_lieu", daoIter.getAaoLieuExe());
		}
		break;	
		// FOURNITURE DE CARBURANT LEGER
		/*case "05" : {
			
		}
		break;*/
		
		// DAO RESTAURATION
		/*case "16" : {
					
		}
		break;*/
		
		// LOCATION DE MAIN D'OEUVRE - (Services courants)
		/*case "15" : {
			
		}
		break;*/
		
		// GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
/*		case "19" : {
					
		}
		break;*/
		
		// SECURITE PRIVEE ou GARDIENNAGE
/*		case "14" : {
			
		}
		break;
		*/
		// ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
/*		case "13" : {
					
		}
		break;*/
		}
		_logger.info("Bookmarks remplacs");
	}
	
	/// methode pour telecharger le dao
	public void telechargerDao() throws IOException {
			downloadFileServlet.downloadFile(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME, DOWNLOAD_FILENAME); 
		}
	//Fin de la Methode
	
	public void insertPermStart(String start, String id) {
		List<XWPFParagraph> paralist = null;
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		
		paralist = getDocument().getParagraphs();
		paraIter = paralist.iterator();
		
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(start)) {
					CTPermStart ctpermstart = document.getDocument().getBody().addNewPermStart();
					ctpermstart.setEdGrp(STEdGrp.EVERYONE);
					ctpermstart.setId(id);
					Node node = ctpermstart.getDomNode();
					System.out.println(node.getNodeName());
					System.out.println(ctpermstart.getEdGrp());
					System.out.println("");
					
					para.getCTP().getDomNode().insertBefore(ctpermstart.getDomNode(), bookmark.getDomNode());
				}
			}
		}
	}
		
	/*public void insertPermStart(String start, String id) {
		List<XWPFParagraph> paralist = null;
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		
		paralist = getDocument().getParagraphs();
		paraIter = paralist.iterator();
		
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(start)) {
					CTPermStart ctpermstart = document.getDocument().getBody().addNewPermStart();
					ctpermstart.setEdGrp(STEdGrp.EVERYONE);
					ctpermstart.setId(id);
					Node node = ctpermstart.getDomNode();
					System.out.println(node.getNodeName());
					System.out.println(ctpermstart.getEdGrp());
					System.out.println("");
					
					para.getCTP().getDomNode().insertBefore(ctpermstart.getDomNode(), bookmark.getDomNode());
				}
			}
		}
	}*/

	public void insertPermEnd(String end, String id) {
		List<XWPFParagraph> paralist = null;
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		
		paralist = getDocument().getParagraphs();
		paraIter = paralist.iterator();
		
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(end)) {
					CTPerm ctpermend = document.getDocument().getBody().addNewPermEnd();
					ctpermend.setId(id);
					Node node = ctpermend.getDomNode();
					String str = ctpermend.getId();
					System.out.println(node.getNodeName());
					System.out.println(str);
					System.out.println("______________________");
					
					para.getCTP().getDomNode().insertBefore(ctpermend.getDomNode(), bookmark.getDomNode());
				}
			}
		}
	}
	
	/*public void insertPermEnd(String end, String id) {
		List<XWPFParagraph> paralist = null;
		Iterator<XWPFParagraph> paraIter = null;
		XWPFParagraph para = null;
		
		List<CTBookmark> bookmarkList = null;
		Iterator<CTBookmark> bookmarkIter = null;
		CTBookmark bookmark = null;
		
		paralist = getDocument().getParagraphs();
		paraIter = paralist.iterator();
		
		while(paraIter.hasNext()) {
			para = paraIter.next();
			bookmarkList = para.getCTP().getBookmarkStartList();
			bookmarkIter = bookmarkList.iterator();
			
			while(bookmarkIter.hasNext()) {
				bookmark = bookmarkIter.next();
				if(bookmark.getName().equals(end)) {
					CTPerm ctpermend = document.getDocument().getBody().addNewPermEnd();
					ctpermend.setId(id);
					Node node = ctpermend.getDomNode();
					String str = ctpermend.getId();
					System.out.println(node.getNodeName());
					System.out.println(str);
					System.out.println("______________________");
					
					para.getCTP().getDomNode().insertBefore(ctpermend.getDomNode(), bookmark.getDomNode());
				}
			}
		}
	}*/

	/*public void setProtect() {		
		getDocument().enforceReadonlyProtection("emap31032020", none);
		System.out.println("protg");
	}*/
	
	//SetProtect - LAURENT
	public void setProtect() {
		if(	(daoAao.getTymCode().equals("2")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("20") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("21") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("22") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("23") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("25") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("26") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("0")  && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("00") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("0A") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("01") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("02") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("03") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("04") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("06") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("07") && daoAao.getDacMopCode().equals("AOO")) || 
				(daoAao.getTymCode().equals("08") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("09") && daoAao.getDacMopCode().equals("AOO")) ||
				(daoAao.getTymCode().equals("10") && daoAao.getDacMopCode().equals("AOO")) || // PRESTATION
				(daoAao.getTymCode().equals("18") && daoAao.getDacMopCode().equals("AOO")) || // ORDURES MENAGERES
				(daoAao.getTymCode().equals("17") && daoAao.getDacMopCode().equals("AOO")) || // ASSURANCES 17
				(daoAao.getTymCode().equals("12") && daoAao.getDacMopCode().equals("AOO"))
					) {
		getDocument().enforceReadonlyProtection("emap31032020", none);
		System.out.println("protg");
		}
	}
	
	//WINDOWS - LAURENT
		/* public void saveDaoFile() throws IOException {
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("00") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSL;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("10") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSL;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("20") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSL;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("00") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSO;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("10") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSO;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("20") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSO;
			 }
			 
			 if((daoAao.getDacMopCode().equals("PSO") || daoAao.getDacMopCode().equals("PSL")) && daoAao.getTymCode().equals("11")) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_PRESTATIONS_INTELLECTUELLES;
				}
			 
			 //TRAVAUX
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("26") ||
					 										daoAao.getTymCode().equals("21") ||
					 										daoAao.getTymCode().equals("22") ||
					 										daoAao.getTymCode().equals("23") ||
					 										daoAao.getTymCode().equals("25") ||
					 										daoAao.getTymCode().equals("20")
					 										))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
			 }
			 
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("26") ||
															daoAao.getTymCode().equals("21") ||
															daoAao.getTymCode().equals("22") ||
															daoAao.getTymCode().equals("23") ||
															daoAao.getTymCode().equals("25") ||
															daoAao.getTymCode().equals("20")
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
				}
			 
			 //FOURNITURES
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("01") ||
															daoAao.getTymCode().equals("02") ||
															daoAao.getTymCode().equals("03") ||
															daoAao.getTymCode().equals("04") ||
															daoAao.getTymCode().equals("06") ||
															daoAao.getTymCode().equals("07") ||
															daoAao.getTymCode().equals("08") ||
															daoAao.getTymCode().equals("09") ||
															daoAao.getTymCode().equals("0A") 
															))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("01") ||
															daoAao.getTymCode().equals("02") ||
															daoAao.getTymCode().equals("03") ||
															daoAao.getTymCode().equals("04") ||
															daoAao.getTymCode().equals("06") ||
															daoAao.getTymCode().equals("07") ||
															daoAao.getTymCode().equals("08") ||
															daoAao.getTymCode().equals("09") ||
															daoAao.getTymCode().equals("0A") 
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
				}
			 
			// PRESTATIONS
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;
				}
			 
			 // DAO RESTAURATION
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATIONS;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATIONS;
				}
			 
			 // LOCATION DE MAIN D'OEUVRE - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES;
				}
			 
			 // GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRES;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRES;
				}
			 
			 // SECURITE PRIVEE ou GARDIENNAGE
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE;
				}
			 
			// ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX;
				}
			 
			// FOURNITURE DE CARBURANT
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER;
				}
			 
			 _logger.info("path: "+DOWNLOAD_PATHNAME);
			 DOWNLOAD_FILENAME = dao.getDacObjet() +"_" + dao.getDacCode()+ ".docx";
			 getDocument().write(new FileOutputStream(new File(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME )));
		 }*/
		 //WINDOWS
		  
		//WINDOWS - LAURENT
	public void saveDaoFileIndex(VDacliste slctdTd, TDacSpecs dao) throws IOException {
			 if(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("00") ||
				(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSL;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("10") ||
				(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSL;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSL") && slctdTd.getTymCode().equals("20") ||
				(slctdTd.getDacMopCode().equals("PLR") && slctdTd.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSL;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("00") ||
				(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSO;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("10") ||
				(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSO;
			 }
			 
			 if(slctdTd.getDacMopCode().equals("PSO") && slctdTd.getTymCode().equals("20") ||
				(slctdTd.getDacMopCode().equals("POR") && slctdTd.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSO;
			 }
			 
			 if((slctdTd.getDacMopCode().equals("PSO") || slctdTd.getDacMopCode().equals("PSL")) && slctdTd.getTymCode().equals("11")) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_PRESTATIONS_INTELLECTUELLES;
				}
			 
			 //TRAVAUX
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("26") ||
					 										slctdTd.getTymCode().equals("21") ||
					 										slctdTd.getTymCode().equals("22") ||
					 										slctdTd.getTymCode().equals("23") ||
					 										slctdTd.getTymCode().equals("25") ||
					 										slctdTd.getTymCode().equals("20")
					 										))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
			 }
			 
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("26") ||
															slctdTd.getTymCode().equals("21") ||
															slctdTd.getTymCode().equals("22") ||
															slctdTd.getTymCode().equals("23") ||
															slctdTd.getTymCode().equals("25") ||
															slctdTd.getTymCode().equals("20")
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX;
				}
			 
			 //FOURNITURES
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("01") ||
															slctdTd.getTymCode().equals("02") ||
															slctdTd.getTymCode().equals("03") ||
															slctdTd.getTymCode().equals("04") ||
															slctdTd.getTymCode().equals("06") ||
															slctdTd.getTymCode().equals("07") ||
															slctdTd.getTymCode().equals("08") ||
															slctdTd.getTymCode().equals("09") ||
															slctdTd.getTymCode().equals("0A") 
															))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("01") ||
															slctdTd.getTymCode().equals("02") ||
															slctdTd.getTymCode().equals("03") ||
															slctdTd.getTymCode().equals("04") ||
															slctdTd.getTymCode().equals("06") ||
															slctdTd.getTymCode().equals("07") ||
															slctdTd.getTymCode().equals("08") ||
															slctdTd.getTymCode().equals("09") ||
															slctdTd.getTymCode().equals("0A") 
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES;
				}
			 
			// PRESTATIONS
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS;
				}
			 
			 // DAO RESTAURATION
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATIONS;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATIONS;
				}
			 
			 // LOCATION DE MAIN D'OEUVRE - (Services courants)
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES;
				}
			 
			 // GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRES;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRES;
				}
			 
			 // SECURITE PRIVEE ou GARDIENNAGE
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE;
				}
			 
			// ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX;
				}
			 
			// FOURNITURE DE CARBURANT
			 if((slctdTd.getDacMopCode().equals("AOO") && (slctdTd.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER;
				}
			 if((slctdTd.getDacMopCode().equals("AOR") && (slctdTd.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER;
				}
			 
			// ASSURANCE
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("17") ))) {
			 	DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ASSURANCE;
			 }
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("17") ))) {
			 	DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ASSURANCE;
			 }
			 
			 _logger.info("path: "+DOWNLOAD_PATHNAME);
			 DOWNLOAD_FILENAME = dao.getDacObjet() +"_" + dao.getDacCode()+ ".docx";
			 getDocument().write(new FileOutputStream(new File(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME )));
		 }
		 //
		 
		//LINUX
	public void saveDaoFile() throws IOException {
				 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("00") ||
					(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSL_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("10") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSL_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSL") && daoAao.getTymCode().equals("20") ||
				(daoAao.getDacMopCode().equals("PLR") && daoAao.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSL_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("00") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("00"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_FOURNITURES_PSO_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("10") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("10"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_TRAVAUX_PSO_LINUX;
			 }
			 
			 if(daoAao.getDacMopCode().equals("PSO") && daoAao.getTymCode().equals("20") ||
				(daoAao.getDacMopCode().equals("POR") && daoAao.getTymCode().equals("20"))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_SERVICES_COURANTS_PSO_LINUX;
			 }
			 
			 if((daoAao.getDacMopCode().equals("PSO") || daoAao.getDacMopCode().equals("PSL")) && daoAao.getTymCode().equals("11")) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_PRESTATIONS_INTELLECTUELLES_LINUX;
				}
			 
			 //TRAVAUX
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("26") ||
					 										daoAao.getTymCode().equals("21") ||
					 										daoAao.getTymCode().equals("22") ||
					 										daoAao.getTymCode().equals("23") ||
					 										daoAao.getTymCode().equals("25") ||
					 										daoAao.getTymCode().equals("20")
					 										))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX;
			 }
			 
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("26") ||
															daoAao.getTymCode().equals("21") ||
															daoAao.getTymCode().equals("22") ||
															daoAao.getTymCode().equals("23") ||
															daoAao.getTymCode().equals("25") ||
															daoAao.getTymCode().equals("20")
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_TRAVAUX_LINUX;
				}
			 
			 //FOURNITURES
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("01") ||
															daoAao.getTymCode().equals("02") ||
															daoAao.getTymCode().equals("03") ||
															daoAao.getTymCode().equals("04") ||
															daoAao.getTymCode().equals("06") ||
															daoAao.getTymCode().equals("07") ||
															daoAao.getTymCode().equals("08") ||
															daoAao.getTymCode().equals("09") ||
															daoAao.getTymCode().equals("0A") 
															))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("01") ||
															daoAao.getTymCode().equals("02") ||
															daoAao.getTymCode().equals("03") ||
															daoAao.getTymCode().equals("04") ||
															daoAao.getTymCode().equals("06") ||
															daoAao.getTymCode().equals("07") ||
															daoAao.getTymCode().equals("08") ||
															daoAao.getTymCode().equals("09") ||
															daoAao.getTymCode().equals("0A") 
						))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_FOURNITURES_LINUX;
				}
			 
			// PRESTATIONS
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("10") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_PRESTATIONS_LINUX;
				}
			 
			 // DAO RESTAURATION
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATION_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("16") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_RESTAURATION_LINUX;
				}
			 
			 // LOCATION DE MAIN D'OEUVRE - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("15") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_LOCATION_MAIN_LINUX;
				}
			 
			 // GESTION DE MAIN D'OEUVRE OCCASIONNELLE - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRE_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("19") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_GESTION_DES_DOEUVRE_LINUX;
				}
			 
			 // SECURITE PRIVEE ou GARDIENNAGE
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("14") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_SECURITE_PRIVEE_LINUX;
				}
			 
			// ENTRETIENS ESPACES VERTS ET LOCAUX - (Services courants)
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("13") ))) {
				 DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX;
				}
			 
			// FOURNITURE DE CARBURANT
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX;
				}
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("05") ))) {
				DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_CARBURANT_LEGER_LINUX;
				}
			 
			// ASSURANCE
			 if((daoAao.getDacMopCode().equals("AOO") && (daoAao.getTymCode().equals("17") ))) {
			 	DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ASSURANCE_LINUX ;
			 }
			 if((daoAao.getDacMopCode().equals("AOR") && (daoAao.getTymCode().equals("17") ))) {
			 	DOWNLOAD_PATHNAME = ""+userController.getWorkingDir()+GRFProperties.PARAM_UPLOAD_DAO_ASSURANCE_LINUX ;
			 }
			 
			 
			 _logger.info("path: "+DOWNLOAD_PATHNAME);
			 DOWNLOAD_FILENAME = "DAO_" + daoAao.getDacCode()+ ".docx";
			 getDocument().write(new FileOutputStream(new File(DOWNLOAD_PATHNAME + DOWNLOAD_FILENAME )));
				}

	public void verrouillage() {
		switch(String.valueOf(daoAao.getTymCode().charAt(0))) {		 
		// TRAVAUX	
		case "2": 
			insertPermStart("deverouillage_debut_01", "12");
			insertPermEnd("deverouillage_fin_01", "12");
			
			insertPermStart("deverouillage_debut_02", "34");
			insertPermEnd("deverouillage_fin_02", "34");
			
			insertPermStart("deverouillage_debut_03", "56");
			insertPermEnd("deverouillage_fin_03", "56");
			break;
		
		// PRESTATION
		case "1":
			insertPermStart("deverouillage_debut_01", "12");
			insertPermEnd("deverouillage_fin_01", "12");
			
			insertPermStart("deverouillage_debut_02", "34");
			insertPermEnd("deverouillage_fin_02", "34");
			break;
		
		// FOURNITURE	
		case "0":
			insertPermStart("deverouillage_debut_01", "12");
			insertPermEnd("deverouillage_fin_01", "12");
			
			insertPermStart("deverouillage_debut_02", "34");
			insertPermEnd("deverouillage_fin_02", "34");
			
			insertPermStart("deverouillage_debut_03", "56");
			insertPermEnd("deverouillage_fin_03", "56");
			break;
		}
	}
	
	public static HashAlgorithm none ;
	
	ArrayList<VdDao> infoDao = new ArrayList<VdDao>();
	ArrayList<VdAao> infoAao = new ArrayList<VdAao>();
	ArrayList<VxAdresse> infoAdresse = new ArrayList<VxAdresse>();
	ArrayList<VbLotAao> infoLots = new ArrayList<VbLotAao>();
	ArrayList<VbCommissionSpecifique> infoCojo = new ArrayList<VbCommissionSpecifique>();

	List<String> bookmarkNames = new ArrayList<String>();
	VdDao daoIter = new VdDao();
	VdAao aaoIter = new VdAao();
	VxAdresse adresseIter = new VxAdresse();
	VbLotAao lotsIter = new VbLotAao();
	VbCommissionSpecifique cojoIter = new VbCommissionSpecifique();
	
	/* new variables */
	private List<VbxDocDaoAao> lDA = new ArrayList<VbxDocDaoAao>();
	private VbxDocDaoAao daoAao = new VbxDocDaoAao();
	private List<VbxDocLot> lLts = new ArrayList<VbxDocLot>(); // Liste des lots
	private VbxDocLot lots02 = new VbxDocLot();
	private List<VbxDocCommission> lCom = new ArrayList<VbxDocCommission>();
	private VbxDocCommission commission = new VbxDocCommission();
	private List<VbxDocAdrRetrait> lAdr = new ArrayList<VbxDocAdrRetrait>();
	private VbxDocAdrRetrait adresse = new VbxDocAdrRetrait();
	
	List<String> lBmkNm = new ArrayList<String>();
	
	public void getDaoAao(TDacSpecs dao) {
		lDA.clear();
		lDA = (List<VbxDocDaoAao>) iservice.getObjectsByColumn("VbxDocDaoAao", new ArrayList<String>(Arrays.asList("LAA_NUM")),new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		if(!lDA.isEmpty()) daoAao = lDA.get(0);
		_logger.info(daoAao.getAaoLibelle());
	}

	public void getListLots(TDacSpecs dao) {
		lLts.clear();
		lLts = (List<VbxDocLot>) iservice.getObjectsByColumn("VbxDocLot", new ArrayList<String>(Arrays.asList("LAA_NUM")),
				new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		_logger.info("infos sur les lots chargs");
	}

	public void getListCommission(TDacSpecs dao) {
		lCom.clear();
		lCom = (List<VbxDocCommission>) iservice.getObjectsByColumn("VbxDocCommission",
				new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		_logger.info("infos sur la commission chargs");
	}

	public void getListAdresse02(TDacSpecs dao) {
		lAdr.clear();
		lAdr = (List<VbxDocAdrRetrait>) iservice.getObjectsByColumn("VbxDocAdrRetrait",new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
		_logger.info("infos sur les adresses charges");
	}
	
	/* Fin new variables */
	
	public String printDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		String jour = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
		String mois = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE);
		mois = mois.substring(0, 1).toUpperCase() + mois.substring(1);
		String annee = Integer.toString(calendar.get(Calendar.YEAR));
		String dateF= jour + " " + mois + " " + annee;
		return dateF;
		//System.out.println(dateF);
	}
	
	public static String getDayNowF() {
		LocalDate localDate = LocalDate.now() ;
		String dayString = localDate.getDayOfWeek().toString();
		int dayInt = localDate.getDayOfMonth();
		Month month = localDate.getMonth();
		int year = localDate.getYear();
		String dateNow = dayString + " " + dayInt + " "+ month + " " + year;
		return dateNow;
	}
	
	public static String getDayNow() {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
		String date09 = simpleDateFormat.format(new Date());
		return date09;
	}
	
	public void rplBmkByVal(List<String> lBmkNm, List<VbxDocLot> lLts, List<VbxDocAdrRetrait> adr, VbxDocDaoAao daoAao, List<VbxDocCommission> commission ) {
		
		//PAGE DE GARDE ET DE TITRE
		if(lBmkNm.contains("PG_min")) {
			XWPFParagraph para = getDocument().createParagraph();
			para.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun run01 = para.createRun();
			run01.setText(daoAao.getMinLibelle().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(20);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173"); //0a5700
			getBookmarkParentNode("PG_min").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_min"));
		}
		if(lBmkNm.contains("PG_min_02")) {
			XWPFParagraph para = getDocument().createParagraph();
			para.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun run01 = para.createRun();
			run01.setText(daoAao.getMinLibelle().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173"); //0a5700
			getBookmarkParentNode("PG_min_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_min_02"));
		}		
		if(lBmkNm.contains("PG_ac")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(18);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_ac").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_ac"));
		}
		if(lBmkNm.contains("PG_ac_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(20);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_ac_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_ac_02"));
		}		
		if(lBmkNm.contains("PG_gestion")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getGesCode()));
			run01.setBold(true);
			run01.setFontSize(14);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_gestion").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_gestion"));
		}
		if(lBmkNm.contains("PG_gestion_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getGesCode()));
			run01.setBold(true);
			run01.setFontSize(18);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_gestion_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_gestion_02"));
		}		
		if(lBmkNm.contains("PG_objet")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(22);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_objet").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_objet"));
		}		
		if(lBmkNm.contains("PG_objet_03")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_objet_03").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_objet_03"));
		}		
		if(lBmkNm.contains("PG_moisAnGestion")) {
			Calendar c = Calendar.getInstance();
			String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
			String mg = mois + "/" + daoAao.getGesCode();
			
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(mg);
			run01.setBold(true);
			run01.setFontSize(16);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_moisAnGestion").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_moisAnGestion"));
		}		
		if(lBmkNm.contains("PG_objet_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(28);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("PG_objet_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_objet_02"));
		}
		if(lBmkNm.contains("PG_imputation_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getLaaLbgImputation());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("PG_imputation_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("PG_imputation_02"));
		}

		// AVIS D'APPEL D'OFFRE
		if(lBmkNm.contains("AAO_ac")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_ac").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_ac"));
		}
		if(lBmkNm.contains("AAO_ac")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_ac").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_ac"));
		}
		if(lBmkNm.contains("AAO_min")) {
			XWPFParagraph para = getDocument().createParagraph();
			XWPFRun run01 = para.createRun();
			run01.setText(daoAao.getMinLibelle().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173"); //0a5700
			getBookmarkParentNode("AAO_min").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_min"));
		}
		if(lBmkNm.contains("AAO_objet")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_objet").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_objet"));
		}
		if(lBmkNm.contains("AAO_nombre_lots")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoNbrLot().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_nombre_lots").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_nombre_lots"));
		}
		if(lBmkNm.contains("AAO_nombre_lots_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoNbrLot().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_nombre_lots_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_nombre_lots_02"));
		}
		if(lBmkNm.contains("AAO_table_lots")) {
			XWPFParagraph para = getDocument().createParagraph();
			para.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun run01 = para.createRun();
			for(VbxDocLot i:lLts) {
				run01.setText("- Lot " + i.getLaaNum()+ ": " + i.getLaaObjet());
				run01.addBreak();
				run01.addBreak();
			}
		getBookmarkParentNode("AAO_table_lots").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_table_lots"));
		}
		if(lBmkNm.contains("AAO_source_financement")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacFinancement());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_source_financement").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_source_financement"));
		}
		if(lBmkNm.contains("AAO_imputation")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getLaaLbgImputation());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_imputation").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_imputation"));
		}
		if(lBmkNm.contains("AAO_gestion")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getGesCode()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_gestion").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_gestion"));
		}
		if(lBmkNm.contains("AAO_cout_dao")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getAaoCoutDac()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_cout_dao").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_cout_dao"));
		}
		if(lBmkNm.contains("AAO_adresse_retrait")) {
		}
		if(lBmkNm.contains("AAO_date_remise")) {
			Date date = daoAao.getAaoDateRecep();
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(printDate(daoAao.getAaoDateRecep()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_date_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_date_remise"));
		}
		if(lBmkNm.contains("AAO_heure_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoHeureRecep().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_heure_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_heure_remise"));
		}
		if(lBmkNm.contains("AAO_lieu_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoLieuRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_lieu_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_lieu_remise"));
		}
		if(lBmkNm.contains("AAO_date_ouverture")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(printDate(daoAao.getAaoDteOuvFin()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("AAO_date_ouverture").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_date_ouverture"));
		}
		if(lBmkNm.contains("AAO_table_caution")) {	
		}
		if(lBmkNm.contains("AAO_adresse_retrait")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			int i=0;
			while(i<lLts.size())  {
				run01.setText(lAdr.get(i).getDtaLibelle());
				run01.setShadow(true);
				run01.addBreak();
				i++;
				}
			getBookmarkParentNode("AAO_adresse_retrait").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_adresse_retrait")); 
		}
		if(lBmkNm.contains("AAO_delai_validite")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(daoAao.getAaoDelaiVal().toString());	
			getBookmarkParentNode("AAO_delai_validite").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("AAO_delai_validite"));
		}
		if(lBmkNm.contains("AAO_date")) {
			//String date = getDayNow();
		}
		
		// LETTRE D'INVITATION AU CANDIDAT
		if(lBmkNm.contains("LC_date_invitation")) {	
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(getDayNow());	
			getBookmarkParentNode("LC_date_invitation").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_date_invitation"));
		}
		if(lBmkNm.contains("LC_adresse_entreprise")) {
		}
		if(lBmkNm.contains("LC_ac_02")) {	
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("LC_ac_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_ac_02"));
		}
		if(lBmkNm.contains("LC_objet")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("LC_objet").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_objet"));
		}
		if(lBmkNm.contains("LC_reference_courrier")) {	
		}
		if(lBmkNm.contains("LC_table_entreprise")) {	
		}
		if(lBmkNm.contains("LC_adresse_retrait")) {		
		}
		if(lBmkNm.contains("LC_cout_dao")) {	
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(String.valueOf(daoAao.getAaoCoutDac()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("LC_cout_dao").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_cout_dao"));
		}
		if(lBmkNm.contains("LC_date_remise")) {	
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(printDate(daoAao.getAaoDateRecep()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("LC_date_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_date_remise"));
		}
		if(lBmkNm.contains("LC_heure_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoHeureRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("LC_heure_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_heure_remise"));
		}
		if(lBmkNm.contains("LC_lieu_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoLieuRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("LC_lieu_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_lieu_remise"));
		}
		if(lBmkNm.contains("LC_date_ouverture")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(printDate(daoAao.getAaoDteOuvFin()));
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("LC_date_ouverture").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_date_ouverture"));
		}
		if(lBmkNm.contains("LC_delai_validite")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(daoAao.getAaoDelaiVal().toString());	
			getBookmarkParentNode("LC_delai_validite").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("LC_delai_validite"));
		}
		
		// DPAO - RPAO
		if(lBmkNm.contains("DPAO_ac")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_ac").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_ac"));
		}
		if(lBmkNm.contains("DPAO_ac01")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getStrLibelleLong().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_ac01").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_ac01"));
		}
		if(lBmkNm.contains("DPAO_nombre_lots")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoNbrLot().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			if(bookmarkNames.contains("DPAO_nombre_lots"))
			getBookmarkParentNode("DPAO_nombre_lots").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_lots"));
		}
		if(lBmkNm.contains("DPAO_nombre_lots_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoNbrLot().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_nombre_lots_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_lots_02"));
		}
		if(lBmkNm.contains("DPAO_objet")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacObjet().toUpperCase());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(true);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_objet").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_ac"));
		}
		if(lBmkNm.contains("DPAO_table_lots")) {
			XWPFRun run07 = document.createParagraph().createRun();
			int i = 0;					
			while(i<lLts.size()) {
				String k = "- Lot n" + lLts.get(i).getLaaNum() + ": " + lLts.get(i).getLaaObjet();
				run07.setText(k);
				run07.setBold(true);
				run07.setFontSize(12);
				run07.setFontFamily("Times New Roman");
				run07.setCapitalized(false);
				run07.setColor("000000");
				run07.addBreak();
				run07.addBreak();
				i++;
			}
			getBookmarkParentNode("DPAO_table_lots").insertBefore(run07.getCTR().getDomNode(), getBookmarkNode("DPAO_table_lots"));
		}
		if(lBmkNm.contains("DPAO_source_financement")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacFinancement());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_source_financement").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_source_financement"));
		}
		if(lBmkNm.contains("DPAO_imputation")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getLaaLbgImputation());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_imputation").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_imputation"));
		}
		if(lBmkNm.contains("DPAO_table_du_personnel")) {
		}
		
		if(lBmkNm.contains("DPAO_table_des_materiels")) {
		}
				// Section pour les DAO de fournitures
		if(lBmkNm.contains("DPAO_lieu_destination")) {
		}
		
		if(lBmkNm.contains("DPAO_adresse_clarification")) {
		}
		
		if(lBmkNm.contains("DPAO_adresse_reunion_preparatoire")) {	
		}
		
		if(lBmkNm.contains("AAO_table_cautionnement")) {
		}
		
		if(lBmkNm.contains("DPAO_adresse_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_delai_execution")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			if(daoAao.getAaoNbrLot().intValueExact()== 1) {
				run01.setText(daoAao.getLaaDelaiExe().toString());	
				} 
				else {
					run01.setText("");	
				}
			getBookmarkParentNode("DPAO_delai_execution").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_delai_execution"));
		}
		if(lBmkNm.contains("DPAO_lieu_livraison")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(daoAao.getAaoLieuExe());	
			getBookmarkParentNode("DPAO_lieu_livraison").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_lieu_livraison"));
		}
		if(lBmkNm.contains("DPAO_delai_validite")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			run01.setText(daoAao.getAaoDelaiVal().toString());
			getBookmarkParentNode("DPAO_delai_validite").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_delai_validite"));
		}
		if(lBmkNm.contains("DPAO_cautionnement_provisoire")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			//if(daoAao.getAaoNbrLot().intValueExact()== 1)
			if(lLts.size() == 1)
				run01.setText(aaoIter.getLaaMtCaut().toString()); 
				else run01.setText("");	
				
			getBookmarkParentNode("DPAO_cautionnement_provisoire").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_cautionnement_provisoire"));
		}
		if(lBmkNm.contains("DPAO_nombre_copie")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacNbrCopieOff().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_nombre_copie").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_copie"));
		}
		if(lBmkNm.contains("DPAO_nombre_copie_02")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getDacNbrCopieOff().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_nombre_copie_02").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_copie_02"));
		}
		if(lBmkNm.contains("DPAO_adresse_remise")) {
		}
		if(lBmkNm.contains("DPAO_date_remise")) {
			Date date = daoAao.getAaoDateRecep();
			
			String pattern = "EEEEE dd MMMMM yyyy";
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
			String date09 = simpleDateFormat.format(date);
			System.out.println(date09);
			
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(date09);
			//run01.setText(daoAao.getAaoDateRecep().toString());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_date_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_date_remise"));
		}
		if(lBmkNm.contains("DPAO_lieu_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoLieuRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_lieu_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_lieu_remise"));
		}
		if(lBmkNm.contains("DPAO_heure_remise")) {
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(daoAao.getAaoHeureRecep());
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_heure_remise").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_heure_remise"));
		}
		if(lBmkNm.contains("DPAO_adresse_ouverture")) {
		}
		if(lBmkNm.contains("DPAO_adresse_conference_prealable")) {
		}
		if(lBmkNm.contains("DPAO_adresse_demande_eclaircissement")) {
		}
		if(lBmkNm.contains("DPAO_date_ouverture")) {
			Date date = daoAao.getAaoDteOuvFin();
			
			String pattern = "EEEEE dd MMMMM yyyy";
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
			String date09 = simpleDateFormat.format(date);
			
			XWPFRun run01 = getDocument().createParagraph().createRun();
			run01.setText(date09);
			run01.setBold(true);
			run01.setFontSize(12);
			run01.setFontFamily("Times New Roman");
			run01.setCapitalized(false);
			run01.setColor("001173");
			getBookmarkParentNode("DPAO_date_ouverture").insertBefore(run01.getCTR().getDomNode(), getBookmarkNode("DPAO_date_ouverture"));
		}
		if(lBmkNm.contains("DPAO_heure_ouverture")) {
		}
		if(lBmkNm.contains("DPAO_table_cojo")) {
			XWPFParagraph para = getDocument().createParagraph();
			para.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun run07 = para.createRun();
			int i = 0;					
			while(i<lCom.size()) {
				//String k = lCom.get(i).getComTctTitre() + ": " + "\t" + lCom.get(i).getComTctLibelle();
				run07.setText(lCom.get(i).getComTctTitre() + ": " + "\t" + lCom.get(i).getComTctLibelle());
				run07.setBold(true);
				run07.setFontSize(12);
				run07.setFontFamily("Times New Roman");
				run07.setCapitalized(false);
				run07.setColor("001173");
				run07.addBreak();
				i++;
			}
			getBookmarkParentNode("DPAO_table_cojo").insertBefore(run07.getCTR().getDomNode(), getBookmarkNode("DPAO_table_cojo"));
		}
		if(lBmkNm.contains("AAO_table_cautionnement")) {
		}
		if(lBmkNm.contains("DPAO_heure_conference_prealable")) {
		}
		if(lBmkNm.contains("DPAO_reunion_preparatoire")) {
		}
		if(lBmkNm.contains("DPAO_heure_reunion_preparatoire")) {
		}
		if(lBmkNm.contains("DPAO_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_heure_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_mode_renumeration")) {
		}
		if(lBmkNm.contains("DPAO_texte_marche_renouvelable")) {
		}
		if(lBmkNm.contains("DPAO_marche_renouvelable")) {
		}
	}
	//Fin rplBmk
	
	public void style(XWPFParagraph paragraph, XWPFRun run, String policeFamilly, String policeColor, int policeTaille, Boolean bold, Boolean capitalized) {
		run.setFontFamily(policeFamilly);
		run.setColor(policeColor); //0a5700  - 001173
		run.setFontSize(policeTaille);
		run.setBold(bold);
		run.setCapitalized(capitalized);
	}
	
	public void replaceBookmarkByValue(List<String> lBmkNm, List<VbxDocLot> lLts, List<VbxDocAdrRetrait> adr, VbxDocDaoAao daoAao, List<VbxDocCommission> commission) {
		XWPFParagraph paragraph;
		XWPFRun run = null;
		
		/* PAGE DE GARDE */
		if(lBmkNm.contains("PG_min")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getMinLibelle().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 20, true, true);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_min").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_min"));
		}
		
		if(lBmkNm.contains("PG_min_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getMinLibelle().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 14, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_min_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_min_02"));
		}
		
		if(lBmkNm.contains("PG_ac")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 18, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_ac").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_ac"));
		}
		
		if(lBmkNm.contains("PG_ac_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 20, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_ac_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_ac_02"));
		}
		
		if(lBmkNm.contains("PG_gestion")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getGesCode()));
				style(paragraph, run, "Times New Roman", "001173", 20, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_gestion").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_gestion"));
		}
		
		if(lBmkNm.contains("PG_gestion_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getGesCode()));
				style(paragraph, run, "Times New Roman", "001173", 20, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_gestion_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_gestion_02"));
		}
		
		if(lBmkNm.contains("PG_objet")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 22, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_objet").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_objet"));
		}
		
		if(lBmkNm.contains("PG_objet_03")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_objet_03").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_objet_03"));
		}
		
		if(lBmkNm.contains("PG_moisAnGestion")) {	
			try {
				Calendar c = Calendar.getInstance();
				String mois = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE ).toUpperCase();
				String mg = mois + "/" + daoAao.getGesCode();
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(mg);
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_moisAnGestion").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_moisAnGestion"));
		}
		
		if(lBmkNm.contains("PG_objet_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_objet_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_objet_02"));
		}
		
		if(lBmkNm.contains("PG_imputation_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.CENTER);
				run = paragraph.createRun();
				run.setText(daoAao.getLaaLbgImputation());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("PG_imputation_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("PG_imputation_02"));
		}
		
		/* AVIS D'APPEL D'OFFRE */
		if(lBmkNm.contains("AAO_ac")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_ac").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_ac"));
		}
		
		if(lBmkNm.contains("AAO_min")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getMinLibelle().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_min").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_min"));
		}
		
		if(lBmkNm.contains("AAO_objet")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_objet").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_objet"));
		}
		
		if(lBmkNm.contains("AAO_nombre_lots")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoNbrLot().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_nombre_lots").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_nombre_lots"));
		}
		
		if(lBmkNm.contains("AAO_nombre_lots_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoNbrLot().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_nombre_lots_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_nombre_lots_02"));
		}
		
		if(lBmkNm.contains("AAO_table_lots")) {	
			try {
				paragraph = getDocument().createParagraph();
				paragraph.setAlignment(ParagraphAlignment.LEFT);
				run = paragraph.createRun();
				for(VbxDocLot i:lLts) {
					run.setText("- Lot " + i.getLaaNum()+ ": " + i.getLaaObjet());
					run.addBreak();
					run.addBreak();
				}
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_table_lots").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_table_lots"));
		}
		
		if(lBmkNm.contains("AAO_source_financement")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacFinancement());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_source_financement").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_source_financement"));
		}
		
		if(lBmkNm.contains("AAO_imputation")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getLaaLbgImputation());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_imputation").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_imputation"));
		}
		

		if(lBmkNm.contains("AAO_gestion")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getGesCode()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_gestion").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_gestion"));
		}
		
		if(lBmkNm.contains("AAO_cout_dao")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getAaoCoutDac()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_cout_dao").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_cout_dao"));
		}
		
		if(lBmkNm.contains("AAO_adresse_retrait")) {
		}
		
		if(lBmkNm.contains("AAO_date_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(printDate(daoAao.getAaoDateRecep()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_date_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_date_remise"));
		}
		
		if(lBmkNm.contains("AAO_heure_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoHeureRecep().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_heure_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_heure_remise"));
		}
		
		if(lBmkNm.contains("AAO_lieu_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_lieu_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_lieu_remise"));
		}
		
		if(lBmkNm.contains("AAO_date_ouverture")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(printDate(daoAao.getAaoDteOuvFin()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_date_ouverture").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_date_ouverture"));
		}
		
		if(lBmkNm.contains("AAO_table_caution")) {	
		}
		
		if(lBmkNm.contains("AAO_adresse_retrait")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
				int i=0;
				while(i<lLts.size())  {
					run.setText(lAdr.get(i).getDtaLibelle());
					run.setShadow(true);
					run.addBreak();
					i++;
				}
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_adresse_retrait").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_adresse_retrait"));
		}
		
		if(lBmkNm.contains("AAO_delai_validite")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoDelaiVal().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("AAO_delai_validite").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("AAO_delai_validite"));
		}
		
		if(lBmkNm.contains("AAO_date")) {
			//String date = getDayNow();
		}
		
		/* LETTRE D'INVITATION AU CANDIDAT */
		if(lBmkNm.contains("LC_date_invitation")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(getDayNow());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_date_invitation").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_date_invitation"));
		}
		
		if(lBmkNm.contains("LC_ac_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_ac_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_ac_02"));
		}
		
		if(lBmkNm.contains("LC_objet")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_objet").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_objet"));
		}
		
		if(lBmkNm.contains("LC_reference_courrier")) {	
		}
		if(lBmkNm.contains("LC_table_entreprise")) {	
		}
		if(lBmkNm.contains("LC_adresse_retrait")) {		
		}
		
		if(lBmkNm.contains("LC_cout_dao")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(String.valueOf(daoAao.getAaoCoutDac()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_cout_dao").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_cout_dao"));
		}
		
		if(lBmkNm.contains("LC_date_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(printDate(daoAao.getAaoDateRecep()));
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_date_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_date_remise"));
		}
		
		if(lBmkNm.contains("LC_heure_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoHeureRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_heure_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_heure_remise"));
		}
		
		if(lBmkNm.contains("LC_lieu_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_lieu_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_lieu_remise"));
		}
		
		if(lBmkNm.contains("LC_date_ouverture")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_date_ouverture").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_date_ouverture"));
		}
		
		if(lBmkNm.contains("LC_delai_validite")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoDelaiVal().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("LC_delai_validite").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("LC_delai_validite"));
		}
		
		/* DPAO - RPAO */
		if(lBmkNm.contains("DPAO_ac")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_ac").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_ac"));
		}
		
		if(lBmkNm.contains("DPAO_ac01")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getStrLibelleLong().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_ac01").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_ac01"));
		}
		
		if(lBmkNm.contains("DPAO_nombre_lots")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoNbrLot().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_nombre_lots").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_lots"));
		}
		
		if(lBmkNm.contains("DPAO_nombre_lots_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoNbrLot().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_nombre_lots_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_lots_02"));
		}
		
		if(lBmkNm.contains("DPAO_objet")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_objet").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_objet"));
		}
		
		if(lBmkNm.contains("DPAO_table_lots")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacObjet().toUpperCase());
				int i = 0;					
				while(i<lLts.size()) {
					String k = "- Lot n°" + lLts.get(i).getLaaNum() + ": " + lLts.get(i).getLaaObjet();
					run.setText(k);
					run.setBold(true);
					run.setFontSize(12);
					run.setFontFamily("Times New Roman");
					run.setCapitalized(false);
					run.setColor("000000");
					run.addBreak();
					run.addBreak();
					i++;
				}
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_table_lots").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_table_lots"));
		}
		
		if(lBmkNm.contains("DPAO_source_financement")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacFinancement());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_source_financement").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_source_financement"));
		}
		
		if(lBmkNm.contains("DPAO_imputation")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getLaaLbgImputation());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_imputation").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_imputation"));
		}
		
		if(lBmkNm.contains("DPAO_table_du_personnel")) {
		}
		if(lBmkNm.contains("DPAO_table_des_materiels")) {
		}	// Section pour les DAO de fournitures
		if(lBmkNm.contains("DPAO_lieu_destination")) {
		}
		if(lBmkNm.contains("DPAO_adresse_clarification")) {
		}
		if(lBmkNm.contains("DPAO_adresse_reunion_preparatoire")) {	
		}
		if(lBmkNm.contains("AAO_table_cautionnement")) {
		}
		if(lBmkNm.contains("DPAO_adresse_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_delai_execution")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				if(daoAao.getAaoNbrLot().intValueExact()== 1) {
					run.setText(daoAao.getLaaDelaiExe().toString());	
				} 
				else {
					run.setText("");	
				}
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_delai_execution").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_delai_execution"));
		}
		
		if(lBmkNm.contains("DPAO_lieu_livraison")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuExe());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_lieu_livraison").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_lieu_livraison"));
		}
		
		if(lBmkNm.contains("DPAO_delai_validite")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoDelaiVal().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_delai_validite").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_delai_validite"));
		}
		
		if(lBmkNm.contains("DPAO_cautionnement_provisoire")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(aaoIter.getLaaMtCaut().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_cautionnement_provisoire").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_cautionnement_provisoire"));
		}
		
		if(lBmkNm.contains("DPAO_nombre_copie")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacNbrCopieOff().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_nombre_copie").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_copie"));
		}
		
		if(lBmkNm.contains("DPAO_nombre_copie_02")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getDacNbrCopieOff().toString());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_nombre_copie_02").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_nombre_copie_02"));
		}
		
		if(lBmkNm.contains("DPAO_adresse_remise")) {
		}
		
		if(lBmkNm.contains("DPAO_date_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				Date date = daoAao.getAaoDateRecep();
				String pattern = "EEEEE dd MMMMM yyyy";
				SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
				String date09 = simpleDateFormat.format(date);
				System.out.println(date09);
				run.setText(date09);
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_date_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_date_remise"));
		}
		
		if(lBmkNm.contains("DPAO_lieu_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoLieuRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_lieu_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_lieu_remise"));
		}
		
		if(lBmkNm.contains("DPAO_heure_remise")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				run.setText(daoAao.getAaoHeureRecep());
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_heure_remise").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_heure_remise"));
		}
		
		if(lBmkNm.contains("DPAO_adresse_ouverture")) {
		}
		if(lBmkNm.contains("DPAO_adresse_conference_prealable")) {
		}
		if(lBmkNm.contains("DPAO_adresse_demande_eclaircissement")) {
		}
		
		if(lBmkNm.contains("DPAO_date_ouverture")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				Date date = daoAao.getAaoDteOuvFin();
				String pattern = "EEEEE dd MMMMM yyyy";
				SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
				String date09 = simpleDateFormat.format(date);
				run.setText(date09);
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_date_ouverture").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_date_ouverture"));
		}
		
		if(lBmkNm.contains("DPAO_heure_ouverture")) {
		}
		
		if(lBmkNm.contains("DPAO_table_cojo")) {	
			try {
				paragraph = getDocument().createParagraph();
				run = paragraph.createRun();
				int i = 0;					
				while(i<lCom.size()) {
					//String k = lCom.get(i).getComTctTitre() + ": " + "\t" + lCom.get(i).getComTctLibelle();
					run.setText(lCom.get(i).getComTctTitre() + ": " + "\t" + lCom.get(i).getComTctLibelle());
					run.setBold(true);
					run.setFontSize(12);
					run.setFontFamily("Times New Roman");
					run.setCapitalized(false);
					run.setColor("001173");
					run.addBreak();
					i++;
				}
				style(paragraph, run, "Times New Roman", "001173", 12, true, false);
			}
			catch(NullPointerException e) {
				run.setText("");
			}
			getBookmarkParentNode("DPAO_table_cojo").insertBefore(run.getCTR().getDomNode(), getBookmarkNode("DPAO_table_cojo"));
		}
		
		if(lBmkNm.contains("AAO_table_cautionnement")) {
		}
		if(lBmkNm.contains("DPAO_heure_conference_prealable")) {
		}
		if(lBmkNm.contains("DPAO_reunion_preparatoire")) {
		}
		if(lBmkNm.contains("DPAO_heure_reunion_preparatoire")) {
		}
		if(lBmkNm.contains("DPAO_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_heure_visite_site")) {
		}
		if(lBmkNm.contains("DPAO_mode_renumeration")) {
		}
		if(lBmkNm.contains("DPAO_texte_marche_renouvelable")) {
		}
		if(lBmkNm.contains("DPAO_marche_renouvelable")) {
		}
		
		_logger.info("bookmark remplacé ça marche");
	}
	
	public void getDocumentProperties() {
		List<CTProperty> customProperties = getDocument().getProperties().getCustomProperties().getUnderlyingProperties().getPropertyList();
		for(int i=0; i<customProperties.size(); i++) {
			CTProperty property = customProperties.get(i);
			String propertyName = customProperties.get(i).getName();
			String propertyValue = customProperties.get(i).getLpwstr();
			System.out.println(propertyName + " : " + propertyValue);
		}
	}
	
	public void setDocumentProperty(String name, String value) {
		POIXMLProperties.CustomProperties  customProperties = getDocument().getProperties().getCustomProperties();
		if(!customProperties.contains(name)) {
			customProperties.addProperty(name, value);
		}
	}
	
	public String getDocumentPropertyValue (String documentPropertyName) {
       String propertyName = null;
       String propertyValue = null;
       POIXMLProperties.CustomProperties  customProperties = getDocument().getProperties().getCustomProperties(); 
       try {
       	propertyName = customProperties.getProperty(documentPropertyName).getName();
   		propertyValue = customProperties.getProperty(documentPropertyName).getLpwstr();
       } 
       catch(NullPointerException e) {
           propertyValue = "Valeur en cas de null pointer";
       }
		return propertyValue;
	}
	
	String daoCreator = "";
	
	String daoReference = "";

	public String getDocumentPropertyCreator() {
		String creator = getDocument().getProperties().getCoreProperties().getCreator();
		return creator;
	}

	public void setDocumentCreatorProperty(String propertyValue) {
		getDocument().getProperties().getCoreProperties().setCreator(propertyValue);
	}
	
	//Methode de gnration du DAO
	public void createDaoFile(TDacSpecs dao) throws IOException {
	String numeroDao ="";
	lDA.clear();
	lDA = (List<VbxDocDaoAao>) iservice.getObjectsByColumn("VbxDocDaoAao", 
			new ArrayList<String>(Arrays.asList("LAA_NUM")),new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
	if(!lDA.isEmpty()) daoAao = lDA.get(0);		
	
	lAdr.clear();
	lAdr = (List<VbxDocAdrRetrait>) iservice.getObjectsByColumn("VbxDocAdrRetrait",
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));

	lCom.clear();
	lCom = (List<VbxDocCommission>) iservice.getObjectsByColumn("VbxDocCommission",
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));

	lLts.clear();
	lLts=(List<VbxDocLot>) iservice.getObjectsByColumn("VbxDocLot", new ArrayList<String>(Arrays.asList("LAA_NUM")),
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+dao.getDacCode()));
	
	//chargeDaoFileIndex(); //Windows
	chargeDaoFile(); // Linux
	printBmk();
	_logger.info("Document charg�");
	lBmkNm = getBookmarkNames();
	replaceBookmarkByValue(lBmkNm, lLts, lAdr, daoAao, lCom);
	setDocumentCreatorProperty("sigomap");
	setDocumentProperty("numeroDao", daoAao.getAaoDacCode().toString());
	/*rplBmkByVal(lBmkNm, lLts, lAdr, daoAao, lCom);*/
	_logger.info("Bookmark remplac");
	verrouillage();
	_logger.info("Verrou paramtr");
	setProtect();
	_logger.info("Document protg");
	//saveDaoFileIndex(); //Windows
	saveDaoFile(); // linux
	_logger.info("Document enrgistr");
	telechargerDao();
	_logger.info("Document tlcharg");
}
//Fin Methode de gnration du DAO	


//Methode de gnration du DAO
/*public void createDaoFileIndex() throws IOException {

	lDA.clear();
	lDA = (List<VbxDocDaoAao>) iservice.getObjectsByColumn("VbxDocDaoAao", 
			new ArrayList<String>(Arrays.asList("LAA_NUM")),new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
	if(!lDA.isEmpty()) daoAao = lDA.get(0);		
	
	lAdr.clear();
	lAdr = (List<VbxDocAdrRetrait>) iservice.getObjectsByColumn("VbxDocAdrRetrait",
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));

	lCom.clear();
	lCom = (List<VbxDocCommission>) iservice.getObjectsByColumn("VbxDocCommission",
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));

	lLts.clear();
	lLts=(List<VbxDocLot>) iservice.getObjectsByColumn("VbxDocLot", new ArrayList<String>(Arrays.asList("LAA_NUM")),
			new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
	
	chargeDaoFileIndex();
	printBmk();
	_logger.info("Document charg");
	lBmkNm = getBookmarkNames();
	rplBmkByVal(lBmkNm, lLts, lAdr, daoAao, lCom);
	_logger.info("Bookmark remplac");
	verrouillage();
	_logger.info("Verrou paramtr");
	setProtect();
	_logger.info("Document protg");
	saveDaoFileIndex();
	_logger.info("Document enrgistr");
	telechargerDao();
	_logger.info("Document tlcharg");
}*/
//Fin Methode de gnration du DAO

	//ANCIEN
/*	public void createDaoFile() throws IOException {
		infoDao.clear();
		infoAao.clear();
		infoAdresse.clear();
		infoLots.clear();
		infoCojo.clear();
		getInfoDao();
		getInfoAao();
		getInfoAdresse();
		getInfoLots();
		getInfoCojo();
		
		chargeDaoFile();
		bookmarkNames = getBookmarkNames();
		System.out.println(bookmarkNames);
		replaceBookmarks(bookmarkNames, daoIter, adresseIter, aaoIter, lotsIter, cojoIter);
		
		verrouillage();
		setProtect();
		
		saveDaoFile();
		//downloadDao();
		telechargerDao();
	}*/


	public VbxDocCommission getCommission() {
		return commission;
	}

	public void setCommission(VbxDocCommission commission) {
		this.commission = commission;
	}

	public VbxDocAdrRetrait getAdresse() {
		return adresse;
	}

	public void setAdresse(VbxDocAdrRetrait adresse) {
		this.adresse = adresse;
	}

	public List<VbxDocDaoAao> getlDA() {
		return lDA;
	}

	public void setlDA(List<VbxDocDaoAao> lDA) {
		this.lDA = lDA;
	}

	public List<VbxDocLot> getlLts() {
		return lLts;
	}

	public void setlLts(List<VbxDocLot> lLts) {
		this.lLts = lLts;
	}

	public VbxDocLot getLots02() {
		return lots02;
	}

	public void setLots02(VbxDocLot lots02) {
		this.lots02 = lots02;
	}

	public List<VbxDocCommission> getlCom() {
		return lCom;
	}

	public void setlCom(List<VbxDocCommission> lCom) {
		this.lCom = lCom;
	}

	public List<VbxDocAdrRetrait> getlAdr() {
		return lAdr;
	}

	public void setlAdr(List<VbxDocAdrRetrait> lAdr) {
		this.lAdr = lAdr;
	}

	public void setDaoAao(VbxDocDaoAao daoAao) {
		this.daoAao = daoAao;
	}
	
	
	/*******  Fin document  *************/
}



