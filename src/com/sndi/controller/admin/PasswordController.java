package com.sndi.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.sndi.dao.WhereClause;
import com.sndi.model.TMotdepasse;
import com.sndi.model.TOperateur;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")

public class PasswordController {
	Logger _logger = Logger.getLogger(PasswordController.class);
	@Autowired
	Iservice iservice;

	@Autowired
	KeyGen keyGen;

	@Autowired
	UserController userController;
	
	private String actuelPass="";
	private String nouveauPass="";
	private String passConfirme="";
	private TMotdepasse tmotPass= new TMotdepasse();
	private TMotdepasse tmotPassNew= new TMotdepasse();
	private List<TMotdepasse> listMotPass = new ArrayList<TMotdepasse>();
	
	
	public void recupMotPass() {
		nouveauPass="";
		actuelPass="";
		passConfirme="";
		listMotPass=(List<TMotdepasse>) iservice.getObjectsByColumn("TMotdepasse", new ArrayList<String>(Arrays.asList("mdpId")),
				new WhereClause("OPE_MATRICULE",WhereClause.Comparateur.EQ,userController.getOperateur().getOpeMatricule()),
						new WhereClause("MDP_STATUT",WhereClause.Comparateur.EQ,"1"));
		if(!listMotPass.isEmpty()) {
			tmotPass=listMotPass.get(0);
		}
		
	}

	 @Transactional
	public void changePassword() {
		if(!actuelPass.equalsIgnoreCase(tmotPass.getMdpMotdepasse())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," Erreur sur le mot de passe courant! ", "")); 
		}
		else {
			if(!nouveauPass.equalsIgnoreCase(passConfirme)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," Echec de la confirmation du nouveau mot de passe! ", "")); 
			}else {
				//Mise à jour du pass existant en lui donnant le statut o
				tmotPass.setMdpStatut(false);
				iservice.updateObject(tmotPass);
				//Insertion du nouveau pass en lui donnant le statut 1
				tmotPassNew.setMdpDate(Calendar.getInstance().getTime());
				tmotPassNew.setMdpMotdepasse(nouveauPass);
				tmotPassNew.setMdpStatut(true);
				tmotPassNew.setTOperateur(new TOperateur(userController.getOperateur().getOpeMatricule()));
				iservice.addObject(tmotPassNew);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Modification effectuée avec succès! ", "")); 
				nouveauPass="";
				actuelPass="";
				passConfirme="";
				//tmotPass=new TMotdepasse();
				tmotPassNew=new TMotdepasse();
			}
		}
}
	
	public String getActuelPass() {
		return actuelPass;
	}

	public void setActuelPass(String actuelPass) {
		this.actuelPass = actuelPass;
	}

	public String getNouveauPass() {
		return nouveauPass;
	}

	public void setNouveauPass(String nouveauPass) {
		this.nouveauPass = nouveauPass;
	}

	public TMotdepasse getTmotPass() {
		return tmotPass;
	}

	public void setTmotPass(TMotdepasse tmotPass) {
		this.tmotPass = tmotPass;
	}

	public List<TMotdepasse> getListMotPass() {
		return listMotPass;
	}

	public void setListMotPass(List<TMotdepasse> listMotPass) {
		this.listMotPass = listMotPass;
	}
	public TMotdepasse getTmotPassNew() {
		return tmotPassNew;
	}
	public void setTmotPassNew(TMotdepasse tmotPassNew) {
		this.tmotPassNew = tmotPassNew;
	}
	public String getPassConfirme() {
		return passConfirme;
	}
	public void setPassConfirme(String passConfirme) {
		this.passConfirme = passConfirme;
	}
	
}
