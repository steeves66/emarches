package com.sndi.controller.parametres;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TMinistere;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;


@Component
@Scope(value="session")
public class MinistereController {
	Logger _logger = Logger.getLogger(MinistereController.class);
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	

	private String filterCode="";
	private TMinistere ministere = new TMinistere();
	private List<TMinistere> listMinistere = new ArrayList<TMinistere>();
	private TMinistere slctdTd=new TMinistere();
	


	
	
	 @PostConstruct
	 public void postConstru()  throws IOException {
		 chargeMinistere();
	   }
	

		public void chargeMinistere() {
			listMinistere=(List<TMinistere>) iservice.getObjectsByColumn("TMinistere", new ArrayList<String>(Arrays.asList("minCode")));
		}
	 
	 private void vider() {
			ministere =new TMinistere();
		}


	public void filtreministere() {
		listMinistere=(List<TMinistere>) iservice.getObjectsByColumn("TMinistere", new ArrayList<String>(Arrays.asList("minCode")),
				new WhereClause("MIN_LIBELLE",WhereClause.Comparateur.LIKE,"%"+filterCode+"%"));
	}


	@Transactional
	public void saveMinistere() throws IOException {
		iservice.addObject(ministere);
		ministere=new TMinistere();
		chargeMinistere();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Enregistrement effectué avec succès! ", ""));
		userController.renderPage("min1");
		vider();
	}


	@Transactional
	public void updateministere() throws IOException {
		iservice.updateObject(slctdTd);
		chargeMinistere();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Modification effectuée avec succès! ", ""));
		userController.renderPage("min1");
	}
	

	
	public void renderPage(String value) throws IOException{
		switch(value) {
		case "min1":
			chargeMinistere();
			userController.renderPage(value);
		break;
		case "min2":
		     vider();
			userController.renderPage(value);
		break;
		case "min3":
			userController.renderPage(value);
		break;
		}
		
		userController.renderPage(value);
	}
	public String getFilterCode() {
		return filterCode;
	}

	public void setFilterCode(String filterCode) {
		this.filterCode = filterCode;
	}




	public TMinistere getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(TMinistere slctdTd) {
		this.slctdTd = slctdTd;
	}

	public TMinistere getMinistere() {
		return ministere;
	}

	public void setMinistere(TMinistere ministere) {
		this.ministere = ministere;
	}


	public List<TMinistere> getListMinistere() {
		return listMinistere;
	}


	public void setListMinistere(List<TMinistere> listMinistere) {
		this.listMinistere = listMinistere;
	}

	
		

}
