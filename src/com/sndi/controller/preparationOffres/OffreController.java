package com.sndi.controller.preparationOffres;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

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
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TCommissionType;
import com.sndi.model.TTypeCommission;
import com.sndi.report.ProjetReportOld;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class OffreController {
	Logger _logger = Logger.getLogger(OffreController.class);
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	KeyGen keyGen;
	 @Autowired
	ProjetReportOld projetReport;
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
		chargeApplOffre();
	 }
	 
	 //Declaration des listes
	 private List<TAvisAppelOffre> listeAppelOffre = new ArrayList<TAvisAppelOffre>();
	 
	 //Declaration des objets
	 private TAvisAppelOffre slctdTd = new TAvisAppelOffre();
	 
	 
	 //Liste des dossiers d'Appel d'Offre
	 public void chargeApplOffre() {
		 listeAppelOffre.clear();
		 listeAppelOffre = (List<TAvisAppelOffre>) iservice.getObjectsByColumnDesc("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
		 new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,"APU"));
	 }

	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "aao1":
					chargeApplOffre();
					break;
				case "aao2":
					break;
				case "aao3":
					break;
				case "aao4":
					break;
			    }	
		     
		     if(action.equalsIgnoreCase("aao1")) {
					
			 }else {
				 if(action.equalsIgnoreCase("aao3")) {
					
				 }else {
					 if(action.equalsIgnoreCase("aao4")) {
						
					 }else {
						 if(action.equalsIgnoreCase("aao5")) {
							
						 }else {
							 if(action.equalsIgnoreCase("aao6")) {
								
							 }
						 }
					 }
			     } 
			 }
		    return userController.renderPage(value);
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
}
