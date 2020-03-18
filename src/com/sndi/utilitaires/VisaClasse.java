package com.sndi.utilitaires;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class VisaClasse {
	 private static final long serialVersionUID = 1L;
	   Logger log = Logger.getLogger(VisaClasse.class);
	   
   
	   public void visaCCM(String fichierComplet, String nomFichier, String typeVisa) throws IOException
	   {
		  
	      File file = new File(fichierComplet);
	      

		
	      if(file.exists() && file.isFile()) {
	    	  InputStream in = new FileInputStream(file);
	          
	          
	    	     
	          File dirTrue = new File(GRFProperties.PARAM_UPLOAD_DESTINATION);
	  			dirTrue.mkdirs();	
	  		
	  	OutputStream out = new FileOutputStream(new File(GRFProperties.PARAM_UPLOAD_DESTINATION + nomFichier));
		
		int read = 0;
		
		byte[] bytes = new byte[1024];
		
		while ((read = in.read(bytes)) != -1) {
		
		out.write(bytes, 0, read);
		
		}  
		
		in.close();
		
		out.flush();
		
		out.close();
	    
	    	}else{
	    		
	    		FacesMessage msg = new FacesMessage("Le Document n'est pas disponible!");
	    	       FacesContext.getCurrentInstance().addMessage(null, msg);
	    	}
	     
	   }

}
