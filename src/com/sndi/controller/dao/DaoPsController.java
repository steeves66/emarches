package com.sndi.controller.dao;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class DaoPsController {
	Logger _logger = Logger.getLogger(DaoPsController.class);
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
	 TableauBordController tableauBordController;

	 
	 @Autowired
	 DownloadFileServlet downloadFileServlet;


	 @PostConstruct
	 public void postContr() {
		 controleController.fonctionaliteDynamic();
	 }
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
	 
	//Redirection sur les pages 
	 public String renderPage(String value ,String action) throws IOException{ 
		 controleController.redirectionDynamicProcedures(action);	 
		     switch(value) {
				case "dao1":
					_logger.info("value: "+value+" action "+action);	
					break;
				case "dao2":
					_logger.info("value: "+value+" action: "+action);
				break;
				case "dao3":
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao4":
		 			_logger.info("value: "+value+" action: "+action);
				break;
                case "dao5":
                	
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao6":
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
                case "dao7":
		 			_logger.info("value: "+value+" action: "+action);
				break;  
				
                case "dao9":
		 			_logger.info("value: "+value+" action: "+action);
				break; 
				
                case "dao10":
		 			_logger.info("value: "+value+" action: "+action);
				break;
				
			    }
		     return userController.renderPage(value);  
	 }

	 

	 
	 

}
