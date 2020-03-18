package com.sndi.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

import com.sndi.utilitaires.FileUploadController;

@FacesValidator("com.sndi.validator.ValidatorCSV")
public class ValidatorCSV implements Validator {
	 Logger _logger = Logger.getLogger(ValidatorCSV.class);

	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object obj)
			throws ValidatorException {
		// TODO Auto-generated method stub
		UploadedFile file=(UploadedFile) obj;
		String str = file.getFileName();
		String ext = str.substring(str.lastIndexOf('.')+1, str.length());
		_logger.info("Extension: "+ext);
		if (!(ext.equalsIgnoreCase("xls")||ext.equalsIgnoreCase("xlsx"))) {
			FacesMessage msg = new FacesMessage("ce document n'est pas au format EXCEL !",
					"format de fichier non valide");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
	
}