package com.sndi.controller.demande;

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
import com.sndi.dao.WhereClause;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.security.UserController;

@Component
@Scope(value="session")
public class DemandeController {
	Logger _logger = Logger.getLogger(DemandeController.class);
	
	@Autowired
	UserController userController;
	
	@Autowired
	ControleController controleController;
	
	 @PostConstruct
	 public void postContr() {
		controleController.fonctionaliteDynamic();
	 }
	
	public String renderPage(String value ,String action) throws IOException{ 
		controleController.redirectionDynamicProcedures(action);
		     switch(value) {
				case "dem1":
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
					
					 /*listeAppelOffre.clear();
					 listeAppelOffre = (List<TAvisAppelOffre>) iservice.getObjectsByColumnDesc("TAvisAppelOffre", new ArrayList<String>(Arrays.asList("AAO_DTE_SAISI")),
					 new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.EQ,""+statutAffiche));
					_logger.info("listeAppelOffre size: "+listeAppelOffre.size());*/
					break;
				case "dem2":
					
				break;
				case "dem3":
				break;
				
				case "dem4":
					break;

			    }
		     
		    return userController.renderPage(value);
		}
	 
}
