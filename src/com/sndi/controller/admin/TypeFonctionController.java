package com.sndi.controller.admin;

import java.io.IOException;
import java.io.Serializable;
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

import com.sndi.model.TTypeFonction;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
import com.sndi.service.Iservice;

@Component
@Scope(value="session")
public class TypeFonctionController implements Serializable {
	
	Logger _logger = Logger.getLogger(TypeFonctionController.class);
	@Autowired
	Iservice iservice;
	@Autowired
	UserController userController;
		@Autowired
		ConstantService constantService;

	private List<TTypeFonction> objetListe = new ArrayList<TTypeFonction>();
	private List<TTypeFonction> currentObjetListe = new ArrayList<TTypeFonction>();

	
	
	
	private TTypeFonction slctd = new TTypeFonction();
	private TTypeFonction slctdTb = new TTypeFonction();
	private String etat;
	private String taille="";
	private String filter="";
	private boolean  creer = false;
	private boolean  modifier = true;
	
	public TypeFonctionController() {
		TTypeFonction p = new TTypeFonction();
		
		setSlctd(p);
		setSlctdTb(p);
	}

	@PostConstruct
	public void postConstru() {	
		chargeTypeData();
	}
	public void rafraichir(){
		chargeTypeData();
		
	}
	
	public void chargeTypeData(){
		
		objetListe.clear();
		currentObjetListe.clear();
		objetListe =  iservice.getObjectsByColumn("TTypeFonction", new ArrayList<String>(Arrays.asList("tyfLibelle")));
		currentObjetListe = new ArrayList<TTypeFonction>(objetListe);
		//parent Object
		
		
			
	}
	
	
	 public void renderPage(String value) throws IOException{
			
			switch(value){
			
			case "typef1":
				chargeTypeData();
				userController.renderPage(value);
				
			case "typef2":
				userController.renderPage(value);
				break;
				
			case "typef3":
				userController.renderPage(value);
				break;
				
			case "sdem2":
				userController.renderPage(value);
				break;
		default:
			userController.renderPage(value);
			}
			
			}
	
	public void validationChamp(){
		if(modifier==false){
			creer = true;
			
		}else{
			creer = false;	
			
		}
		//supprimer = true;
	}
	
	

	//Méthode CRUD
	@Transactional
	public void create() throws IOException{
		if(!(null == slctdTb.getTyfCod() || "".equals(slctdTb.getTyfCod()))) {
			iservice.addObject(slctdTb);
			chargeTypeData();
				vider();
				creer = true;
				modifier = false;
				
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_INFO, " Type Fonction enrégistré ! ", ""));	
				userController.renderPage("typef1");
		}else {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_WARN, " Champs non renseignés ! ", ""));		
		}
		
		
	}
	@Transactional
	public void update(){
		
		iservice.updateObject(getSlctdTb());
		
		chargeTypeData();
		vider();
		creer = false;	
		modifier = true;
		
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Type Fonction mis à jour ! ", "")); 
	}
	
	
	@Transactional
	public void delete(){
		
		try {
			iservice.deleteObject(getSlctdTb());
			
			chargeTypeData();
			vider();
			creer = false;	
			modifier = true;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Type Fonction supprimé ! ", ""));
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN," Impossible de supprimer le Type Fonction ! ", ""));
		}  
	}
	
	
	
	public void viderChamps(){
		vider();
		creer = false;	
		modifier = true;
		
	}
	
	public void vider(){
		TTypeFonction p = new TTypeFonction();
		
		
		setSlctd(p);
		setSlctdTb(p);
	
	}

	public void onRowSelect() {
		setSlctd(getSlctdTb());
		creer = true;	
		modifier = false;
					
	}
	
	public void onRowUnSelect() {
		TTypeFonction tr = new TTypeFonction();
		setSlctd(tr);
		setSlctdTb(tr);
		
		creer = false;	
		modifier = true;
		
		
					
	}
	
	
	public List<TTypeFonction> getObjetListe() {
		return objetListe;
	}

	public void setObjetListe(List<TTypeFonction> objetListe) {
		this.objetListe = objetListe;
	}


	public TTypeFonction getSlctd() {
		return slctd;
	}

	public void setSlctd(TTypeFonction slctd) {
		this.slctd = slctd;
	}

	public TTypeFonction getSlctdTb() {
		return slctdTb;
	}

	public void setSlctdTb(TTypeFonction slctdTb) {
		this.slctdTb = slctdTb;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean isCreer() {
		return creer;
	}

	public void setCreer(boolean creer) {
		this.creer = creer;
	}

	public boolean isModifier() {
		return modifier;
	}

	public void setModifier(boolean modifier) {
		this.modifier = modifier;
	}
	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public List<TTypeFonction> getCurrentObjetListe() {
		return currentObjetListe;
	}

	public void setCurrentObjetListe(List<TTypeFonction> currentObjetListe) {
		this.currentObjetListe = currentObjetListe;
	}


}
