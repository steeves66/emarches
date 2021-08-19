package com.sndi.controller.parametres;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import com.sndi.dao.WhereClause;
import com.sndi.model.TMotifs;
import com.sndi.model.VMotif;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;

import lombok.Data;

@Data
@Component
@Scope(value = "session")
public class MotifController {

	private List<VMotif> listMotifs = new ArrayList<VMotif>(); // datatable

	private String critereRecherche="";
	private String mode = "add";
	private TMotifs motif = new TMotifs();
	private Boolean motifType; // pour l'affichage de type motif
	private String listeMotif = ""; // pour l'affichage de type motif
	private TMotifs motifPere = new TMotifs();
	TMotifs motifUpdate = new TMotifs();

	private List<TMotifs> listTypMotif = new ArrayList<TMotifs>(); // pour la combo box
	private TMotifs typeMotifselected = new TMotifs(); // pour la combo box

	String prefixPere = "";
	int childSize;
	String childName = "";

	Logger _logger = Logger.getLogger(MotifController.class);

	@Autowired
	UserController userController;

	@Autowired
	Iservice iservice;

	@PostConstruct
	public void postConstru() throws IOException {
		chargeListMotifs();
	}

	public void renderListMotif() {
		this.listeMotif = motifType ? "Checked" : "Unchecked";
	}

	public void listeTypeMotif() {
		listTypMotif = (List<TMotifs>) iservice.getObjectByColumnInInstrValNull("TMotifs");
		_logger.info("taille liste des types de motifs " + listTypMotif.size());
	}

	public String renderPage(String value) throws IOException {
		switch (value) {
		case "mtf":
			chargeListMotifs();
			userController.renderPage(value);
			break;
		}
		return userController.renderPage(value);
	}

	public void chargeListMotifs() {
		listMotifs = (List<VMotif>) iservice.getObjectsByColumn("VMotif");
		_logger.info("taille liste " + listMotifs.size());
	}

	public void initialiserDatatable() {
		critereRecherche = "";
		listMotifs = iservice.getObjects("VMotif");
	}

	public void chercherMotif() {
		listMotifs = iservice.getObjectsByColumn("VMotif",
				new WhereClause("CRITERE", WhereClause.Comparateur.LIKE, "%" + critereRecherche + "%"));
	}

	public void setAddMode() {
		this.mode = "add";
		this.motif = new TMotifs();
		this.motif.setTMotifs(new TMotifs());
		this.motifType = false;
		listeTypeMotif();
		this.listeMotif = "Unchecked";
	}

	
	public void setEditMode(VMotif vMotif) { 
		  this.mode = "edit"; 
		  String motifupnum = vMotif.getMtfNum().toString();
		  this.motif = (TMotifs) iservice.getObjectsByColumn("TMotifs", new WhereClause("MTF_NUM", WhereClause.Comparateur.EQ, motifupnum)) .get(0);
		  if(this.motif.getTMotifs() == null) {
			  this.motifType = true; 
			  this.listeMotif = "Checked";
			  listeTypeMotif();
		  } else {
			  this.motifType = false; 
			  this.listeMotif = "Unchecked";
			  listeTypeMotif();
		  } 
	  }

	public void saveMotif() {
		Date date = new Date();
		this.motif.setTOperateur(userController.getSlctd().getTOperateur());
		this.motif.setMtfDteSaisi(date);
		
		if (motifPere.getMtfNum() != null) {
			this.motif.setTMotifs(motifPere);
			TMotifs motifPere2 = (TMotifs) iservice
					.getObjectsByColumn("TMotifs",
							new WhereClause("MTF_NUM", WhereClause.Comparateur.EQ, motifPere.getMtfNum().toString()))
					.get(0);
			this.motif.setMtfType(motifPere2.getMtfType().toUpperCase());
		} else {
			motif.setTMotifs(null);
		}

		iservice.addObject(motif);
		this.listTypMotif.clear(); 
		this.motifType = false; 
		this.listeMotif = "Unchecked";
		 
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement éffectué avec succès", ""));
		motifPere = new TMotifs(); 
		chargeListMotifs(); 
	}

	public void updateMotif() {
		Date date = new Date();
		this.motif.setMtfDteModif(date);
		this.motif.setMtfOpeModif(userController.getSlctd().getTOperateur().getOpeMatriculeFonc());
		
		if(motifPere.getMtfNum() != null) {
			this.motif.setTMotifs(motifPere);
			TMotifs motifPere2 = (TMotifs) iservice
					.getObjectsByColumn("TMotifs",
							new WhereClause("MTF_NUM", WhereClause.Comparateur.EQ, motifPere.getMtfNum().toString()))
					.get(0);
			this.motif.setMtfType(motifPere2.getMtfType().toUpperCase());
		} else {
			motif.setTMotifs(null);
		}
		iservice.updateObject(motif); 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour éffectuée avec succès", ""));
		this.listTypMotif.clear(); 
		this.motifType = false;
		this.listeMotif = "Unchecked";
		motifPere = new TMotifs();
		chargeListMotifs();
	}

	public void deleteMotif(VMotif motif) {

		String motifdelnum = motif.getMtfNum().toString();
		TMotifs motifDel = (TMotifs) iservice
				.getObjectsByColumn("TMotifs", new WhereClause("MTF_NUM", WhereClause.Comparateur.EQ, motifdelnum))
				.get(0);
		iservice.deleteObject(motifDel);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression éffectuée avec succès", ""));
		chargeListMotifs();
	}
}
