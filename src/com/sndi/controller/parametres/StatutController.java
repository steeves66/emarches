package com.sndi.controller.parametres;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.VStatut;
import com.sndi.model.VAvisAppelOffreAnodmp;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Scope(value="session")
@Data
public class StatutController {
	
	Logger _logger = Logger.getLogger(StatutController.class);
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	
	/* Variables */
	private VStatut statut = new VStatut();
	private List<VStatut> listStatut = new ArrayList<VStatut>();
	private VStatut delStatut = new VStatut();
	private VStatut deleteStatut = new VStatut();
	private String mode = "add";
	private String critereRecherche;
	
	@PostConstruct
	public void postConstru()  throws IOException {
		chargeListStatut();
	}
	
	public void setAddMode() {
		this.mode = "add";
		this.statut = new VStatut();
	}
	
	public void setEditMode(VStatut vStatut) {
		this.mode = "edit";
		this.statut = vStatut;
	}
	
	public void clearAddStatutFormulaire() {
		
	}
	
	public void initialiserDatatable() {
		critereRecherche = "";
		listStatut = iservice.getObjects("VStatut");
	}
	
	public void chercherStatut() {
		listStatut = iservice.getObjectsByColumn("VStatut", new WhereClause("CRITERE", WhereClause.Comparateur.LIKE, "%"+critereRecherche+"%"));
	}
	
	public void chargeListStatut() {
		//listStatut = iservice.getObjects("TStatut", new ArrayList<String>(Arrays.asList("staCode")));
		
		listStatut = (List<VStatut>) iservice.getObjectsByColumn("VStatut");
		_logger.info("taille liste "+listStatut.size());
	}
	
	public String renderPage(String value) throws IOException {
		switch(value) {
		case "stat":
			chargeListStatut();
			userController.renderPage(value);
			break;
		}
		return userController.renderPage(value);
	}
	
	public void formulaireNouveauStatut() {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("formulaireAjoutStatut", options, null);
	}
	
	public void saveStatut() {
		if(statut.getStaLibelleCourt().equalsIgnoreCase("")) {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez renseigner le libellé!", ""));
		}
		else if(statut.getStaLibelleLong().equalsIgnoreCase("")) {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez renseigner la description!", ""));
		}
		else if(statut.getStaCode().equalsIgnoreCase("")) {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez renseigner le code!", ""));
		}
		else {
			iservice.addObject(statut.getTstatut());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement éffectué avec succès", ""));
			chargeListStatut();
			 
			/*
			 * userController.setTexteMsg(" Enregistrement éffectué avec succès!");
			 * userController.setRenderMsg(true); userController.setSevrityMsg("success");
			 */
		}
	}
	
	public void beforeUpdate(VStatut s) {
		this.mode = "update";
		this.statut = s;
	}
	
	public void updateStatut() {
		iservice.updateObject(this.statut.getTstatut());
		this.statut = new VStatut();
		
		this.mode = "add";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour éffectuée avec succès", ""));
		chargeListStatut();
		
	}
	
	/* Getter and Setter */
	public void deleteStatut(VStatut statut) throws IOException{
		/*
		 * listStatut =(List<TStatut>) iservice.getObjectsByColumn("TStatut", new
		 * ArrayList<String>(Arrays.asList("STA_CODE")), new
		 * WhereClause("STA_CODE",WhereClause.Comparateur.EQ,""+delStatut.getStaCode()))
		 * ; if (!listStatut.isEmpty()) { deleteStatut=listStatut.get(0);
		 * _logger.info("Statut à supprimer"+deleteStatut.getStaCode()); }
		 * iservice.deleteObject(deleteStatut);*/
		
		iservice.deleteObject(statut.getTstatut());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression éffectuée avec succès", ""));
		chargeListStatut();
		
		/* userController.renderPage("stat"); */
		
	}


}