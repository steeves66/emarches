package com.sndi.controller.pgpm;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.dao.WhereClause;
import com.sndi.model.TGestion;
import com.sndi.report.ProjetReportOld;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.GRFProperties;
import com.sndi.utilitaires.KeyGen;

@SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
@Component
@Scope(value="session")
public class EditionController {
	Logger _logger = Logger.getLogger(EditionController.class);
	@Autowired
	Iservice iservice;
	@Autowired
	KeyGen keyGen;
	@Autowired
	UserController userController;
	@Autowired
	ProjetReportOld projetReport;
	
	@Autowired
	DownloadFileServlet downloadFileServlet;
	
	 private List<TGestion> listeGestion = new ArrayList<TGestion>();
	 private long gesCode = 2020;
		
	@PostConstruct
	 public void postConstru()   {

	 }
	
	//ACombobox Gestions
	 public void chargeGestions(){
		 listeGestion=(List<TGestion>) iservice.getObjectsByColumnDesc("TGestion", new ArrayList<String>(Arrays.asList("GES_CODE")),
				 new WhereClause("GES_CODE",WhereClause.Comparateur.EQ,"PN"));	
	 }
	 
	
	 public String renderPage(String value) throws IOException{ 
		     switch(value) {
				case "edi1":
					
					break;
				case "pgpm2":
					
				break;
				case "pgspm1":
					
				break;
				case "pgpm4":
					break;
				case "pgpm5":
					break;
			    }
		     return userController.renderPage(value);
	 }

	public List<TGestion> getListeGestion() {
		return listeGestion;
	}

	public void setListeGestion(List<TGestion> listeGestion) {
		this.listeGestion = listeGestion;
	}

	public long getGesCode() {
		return gesCode;
	}

	public void setGesCode(long gesCode) {
		this.gesCode = gesCode;
	}


	//Combobox code acte rectificatif

	 
	/* public void checkSituation() {
		 if(sit.equalsIgnoreCase("DES")) {
			 etatDestination = true; 
		 }else {
			 etatDestination = false;  
		 }
	 }*/
	 
	
	 
	 /*public void editer() throws Exception{
			 if(sit.equalsIgnoreCase("GLO")) {
				 projetReport.printParamLong(annee, "situation", "situation"); 
			 }else {
				 if(sit.equalsIgnoreCase("DET")) {
					 projetReport.printParam2(annee,destCod+""+like, "situation_detaille", "situation_detaille"); 
				 }
				 else
					 if(sit.equalsIgnoreCase("DES")){
						 projetReport.printSituation(annee, selectionDest);
						
					 }
		 }
			 
	 }*/
	 
	 
     
		

}
