package com.sndi.controller.demande;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.security.UserController;

@Component
@Scope(value="session")
public class DemandeController {
	Logger _logger = Logger.getLogger(DemandeController.class);
	
	@Autowired
	UserController userController;
	
	public String renderPage(String value) throws IOException{ 
		     switch(value) {
				case "dem1":
		
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
