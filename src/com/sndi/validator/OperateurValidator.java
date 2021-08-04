package com.sndi.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sndi.controller.admin.AssignationOperateurController;
import com.sndi.controller.admin.OperateurController2;
import com.sndi.dao.IOperateurDao;
import com.sndi.dao.IStructureDao;
import com.sndi.model.TOperateur;
import com.sndi.service.Iservice;

import lombok.Getter;
import lombok.Setter;

@FacesValidator("operateurValidator")
@Component
public class OperateurValidator implements Validator 
{
	@Autowired private Iservice iservice; 
	@Autowired private IOperateurDao operateurDao;
	@Autowired private AssignationOperateurController assignationOperateurController;
	@Autowired private IStructureDao structureDao;
	
	private final String ID_MATRICULE = "matricule";
	private final String ID_MATFONC = "matFonc";
	private final String ID_CIVILITE = "civilite";
	private final String ID_NOM = "nom";
	private final String ID_CONTACT = "contact";
	private final String ID_MAIL = "mail";
	private final String ID_LOGIN = "login";
	private final String ID_FONC_ADM = "foncAdm";
	private final String ID_STR_CODE = "codeStructure";
	@Getter @Setter private boolean valid = true;
	
	@Override
	public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException 
	{
		System.out.println("Operateur matricule = " + assignationOperateurController.getOperateur().getOpeMatricule());
		this.valid = true; // Avant toute validation j'initialise isValid à true. Si la validation échoue, la méthode setErrorMassage sera appelée et le changera à false
		this.assignationOperateurController.setErrorMsgVisible(false);
		this.assignationOperateurController.setSuccessMsgVisible(false);
		final String componentId = component.getId();
	         switch (componentId)
	         {
				case ID_MATRICULE:
					validateMatricule(value.toString());
					break;
				case ID_MATFONC:
					validateMatFonc(value.toString());
					break;
				case ID_CONTACT:
					validateContact(value.toString());
					break;
				case ID_MAIL:
					validateMail(value.toString());
					break;
				case ID_LOGIN:
					validateLogin(value.toString());
					break;
				case ID_STR_CODE: 
					validateStructure(value.toString());
	         }
	}
	
	private void setErrorMassage(String errorMsg) //Cette méthode est appelée chaque fois qu'une validation échoue
    {
		this.valid = false;
		this.assignationOperateurController.setErrorMsgVisible(true);
		this.assignationOperateurController.setSuccessMsgVisible(false);
        FacesMessage msg = new FacesMessage(errorMsg);
	    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	    throw new ValidatorException(msg);
    }
	
	private void validateLogin(String login) 
	{
		String opeMatricule = assignationOperateurController.getOperateur().getOpeMatricule();
		List<TOperateur> operateurs = operateurDao.findByOpeLogin(login);
		System.out.println("Nbre d'operateurs existant avec le matricule " + opeMatricule + " = "+ operateurs.size());
		if(operateurs.size()>1)
		{
			setErrorMassage("login déjà attribué");
		}
		else if(operateurs.size()==1 )
		{
			if(!operateurs.get(0).getOpeMatricule().equals(opeMatricule))
			{
				setErrorMassage("Login déjà attribué");
			}
		}
		
	}
	private void validateMail(String mail)
	{
		String opeMatricule = assignationOperateurController.getOperateur().getOpeMatricule();
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(mail);
		List<TOperateur> operateurs = operateurDao.findByOpeEmail(mail);
		if(!matcher.find())
		{
			setErrorMassage("Veuillez saisir une adresse mail correcte");
		}
		else if(operateurs.size()>1)
		{
			setErrorMassage("Mail déjà attribué");
		}
		else if(operateurs.size()==1 && !operateurs.get(0).getOpeMatricule().equals(opeMatricule))
		{
			setErrorMassage("Mail déjà attribué");
		}
	}
	
	private void validateContact(String contact) 
	{
		String opeMatricule = assignationOperateurController.getOperateur().getOpeMatricule();
		List<TOperateur> operateurs = operateurDao.findByOpeContact(contact);
		if(operateurs.size()>1)
		{
			setErrorMassage("Contact déjà attribué");
		}
		else if(operateurs.size()==1 && !operateurs.get(0).getOpeMatricule().equals(opeMatricule))
		{
			setErrorMassage("Contact déjà attribué");
		}
	}
	private void validateMatFonc(String matFonc) 
	{
		String opeMatricule = assignationOperateurController.getOperateur().getOpeMatricule();
		List<TOperateur> operateurs = operateurDao.findByOpeMatriculeFonc(matFonc);
		if(operateurs.size()>1)
		{
			setErrorMassage("Matricule déjà attribué");
		}
		else if(operateurs.size()==1 )
		{
			if(!operateurs.get(0).getOpeMatricule().equals(opeMatricule))
			{
				setErrorMassage("Matricule déjà attribué");
			}
		}
		
	}
	private void validateMatricule(String string) 
	{
		// TODO Auto-generated method stub
	}
	
	private void validateStructure(String strCode)
	{
		System.out.println("STR CODE = " + strCode);
		if(strCode == null || strCode.equals(""))
		{
			System.out.println("Code structure null ou vide");
			setErrorMassage("Champ obligatoire");
		}
		else
		{
			System.out.println("Code structure Inexistant");
			setErrorMassage("Code Structure invalide");
		}
	}
}
