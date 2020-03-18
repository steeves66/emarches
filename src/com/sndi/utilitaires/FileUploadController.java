package com.sndi.utilitaires;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@ManagedBean(name="fileUploadController")
@Component
@Scope(value="session")
public class FileUploadController {
	  Logger _logger = Logger.getLogger(FileUploadController.class);

	  @Autowired
      KeyGen keyGen;
	
	private UploadedFile file; 
	private String fileName;
	private String fileCode;
	static  String workingDir = "";
	private String docNom="";
	 @PostConstruct
		public void postConstru() throws IOException {	
		 File dir = new File("..");
		 workingDir = dir.getCanonicalPath();	
		}
	 
	public UploadedFile getFile() {  
	    return file;  
	}  
	
	public void setFile(UploadedFile file) {  
	    this.file = file;  
	}  

	 public boolean handleFileUpload(FileUploadEvent event, String name, String type) {
			return upload(event.getFile(), name, type);
		    }
	
	
	public boolean upload(UploadedFile event, String demCode, String docNature) { 	
		file = event;
		boolean rep= false;
		String name="";
		
		switch(docNature){
		
		case "1": name="ADM-";
			
			break;
			
		case "2": name="CAD-";
			
			break;
		case "3": name="TEC-";
		break;
		
		case "4": name="AUT-";
		
		break;
         case "5": name="PJV-";
		
		break;
         case "6": name="PDI-";
 		break;
 	    
 		case "7": name="ART-";
 		break;
			
		}
		
		
		try {
			
			String str = file.getFileName();
			docNom=str;
			String ext = str.substring(str.lastIndexOf('.'), str.length());
			
			 // name = name+"-";//+dossierAffaire.getControle().getCotCode()+ext;
			name = name+demCode;
			fileCode = name;
			 fileName = name+ext;
			System.out.print("getFileName()"+fileName);
	
			
		if(copyFile(fileName, file.getInputstream(), docNature)){
			FacesMessage msg = new FacesMessage("Succès! ", fileName + " a été téléchargé!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			rep= true;
		}
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec du chargement! ","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			rep=false;
		}
	
		
		} catch (IOException e) {		
		e.printStackTrace();		
		}	
		return rep;	
		
	}
	
	public boolean uploadPFCOld(String demCode, String docNature, String numOrdre) { 	
		boolean rep= false;
		String name="";
		
		switch(docNature){
		
		case "1": name="ADM-";
		
		break;
		
	    case "2": name="CAD-";
		
		break;
	    case "3": name="TEC-";
	    break;
	
	    case "4": name="AUT-";
	
	    break;
	    
        case "5": name="PJV-";
		break;
		
        case "6": name="PDI-";
		break;
	    
		case "7": name="ART-";
		break;
			
		}
		
		
		try {
			String str = file.getFileName();
			docNom=str;
			String ext = str.substring(str.lastIndexOf('.'), str.length());
			
			 // name = name+"-";//+dossierAffaire.getControle().getCotCode()+ext;
			name = name+demCode;
			fileCode = name;
			 fileName = name+ext;
			System.out.print("getFileName()"+fileName);
	
			
		if(copyFile(fileName, file.getInputstream(), docNature)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succès! ", fileName + " a été téléchargé!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			rep= true;
		}
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec du chargement! ","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			rep=false;
		}
	
		
		} catch (IOException e) {		
		e.printStackTrace();		
		}	
		return rep;	
		
	}
	
	
	public void uploadPFC(String demCode, String docNature, String numOrdre) { 	
		//boolean rep= false;
		String name="";
		
		switch(docNature){
		
		case "1": name="ADM-";
		
		break;
		
	    case "2": name="CAD-";
		
		break;
	    case "3": name="TEC-";
	    break;
	
	    case "4": name="AUT-";
		
		break;
		
	    case "5": name="PJV-";
		break;
		
	    case "6": name="PDI-";
		break;
	    case "7": name="ART-";
		break;
			
		}
		
		
		//try {
			String str = file.getFileName();
			docNom=str;
			String ext = str.substring(str.lastIndexOf('.'), str.length());
			
			 // name = name+"-";//+dossierAffaire.getControle().getCotCode()+ext;
			name = name+demCode;
			fileCode = name;
			 fileName = name+ext;
			 _logger.info("getFileName()"+fileName);
			//System.out.print("getFileName()"+fileName);
	
			
	/*	if(copyFile(fileName, file.getInputstream(), docNature)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succès! ", fileName + " a été téléchargé!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			rep= true;
		}
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec du chargement! ","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			rep=false;
		}
	
		
		} catch (IOException e) {		
		e.printStackTrace();		
		}	
		return rep;	*/
		
	}
	
	
	
	public String getNomFile(String nom){
		//String NomFile=null;

		return nom;
	}
	
	public static boolean contains(String str, String searchStr) {
	      if (str == null || searchStr == null) {
	          return false;
	      }
	      return str.indexOf(searchStr) >= 0;
	  }
	
	public boolean copyFile(String fileName, InputStream in, String nature) {
	
		try {
			//File dir = new File("..");
			 //String workingDir = dir.getCanonicalPath();
			 
			File dir = new File(workingDir+GRFProperties.PARAM_UPLOAD_DESTINATION);
			dir.mkdirs();	
			
		OutputStream out = new FileOutputStream(new File(workingDir+GRFProperties.PARAM_UPLOAD_DESTINATION + fileName));
		
		
		int read = 0;
		
		byte[] bytes = new byte[1024];
		
		while ((read = in.read(bytes)) != -1) {
		
		out.write(bytes, 0, read);
		
		}
		
		in.close();
		
		out.flush();
		
		out.close();
		
		_logger.info("Un nouveau fichier a été ajouté dans le dossier! nom: "+fileName);
		return true;
		
		} catch (IOException e) {
		
			_logger.error(e.getMessage());
		return false;
		
		}
	
	}
	
	public boolean copyFiles(String fileName, InputStream in, String nature) {
		
		try {
			File dir = new File(workingDir+GRFProperties.PARAM_UPLOAD_DESTINATION);
			dir.mkdirs();	
			
		OutputStream out = new FileOutputStream(new File(workingDir+GRFProperties.PARAM_UPLOAD_DESTINATION + fileName));
		
		
		int read = 0;
		
		byte[] bytes = new byte[1024];
		
		while ((read = in.read(bytes)) != -1) {
		
		out.write(bytes, 0, read);
		
		}
		
		if(nature.equalsIgnoreCase("1")||nature.equalsIgnoreCase("4")) {
			
			File dirTrue = new File(workingDir+GRFProperties.PARAM_UPLOAD_DESTINATION_TRUE_DOC);
			dirTrue.mkdirs();	
			
		OutputStream outTrue = new FileOutputStream(new File(workingDir+GRFProperties.PARAM_UPLOAD_DESTINATION_TRUE_DOC + fileName));
		
		
		int readTrue = 0;
		
		byte[] bytesTrue = new byte[1024];
		
		while ((readTrue = in.read(bytesTrue)) != -1) {
		
		outTrue.write(bytesTrue, 0, readTrue);
		
		}
		outTrue.flush();
		
		outTrue.close();
		}
		
		in.close();
		
		out.flush();
		
		out.close();
		
		_logger.info("Un nouveau fichier a été ajouté dans le dossier!");
		return true;
		
		} catch (IOException e) {
		
		System.out.println(e.getMessage());
		return false;
		
		}
	
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getDocNom() {
		return docNom;
	}

	public void setDocNom(String docNom) {
		this.docNom = docNom;
	}




}
