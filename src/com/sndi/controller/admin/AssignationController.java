package com.sndi.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
import com.sndi.model.TAssignation;
import com.sndi.model.TFonction;
import com.sndi.model.TMotdepasse;
import com.sndi.model.TOperateur;
import com.sndi.model.VFonctionAssignation;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class AssignationController {
	Logger _logger = Logger.getLogger(AssignationController.class);
	@Autowired
	Iservice iservice;
	
	@Autowired
	KeyGen keyGen;
	
	@Autowired
	UserController userController;
	
	@Autowired
	ProjetReport projetReport;
	
	private String filterCode="";
	private TAssignation assignation= new TAssignation();
	private List <TAssignation> assignationListe = new ArrayList<TAssignation>();
	private List <TOperateur> operateurListe = new ArrayList<TOperateur>();
	private List <VFonctionAssignation> fonctionListe = new ArrayList<VFonctionAssignation>();
	private TAssignation slctdTd=new TAssignation();
	private String operateur;
	private String fonction;
	private String assCourant;
	private String assStaut;
	private Date dateAssDeb;
	private Date dateAssFin;
	
	 @PostConstruct
	public void postContr() {
		 chargeAssignation();
		 chargeOperateur();
		 chargeFonction();
	}
	 
	 public void chargeAssignation() {
		 assignationListe.clear();
		 assignationListe=(List<TAssignation>) iservice.getObjectsByColumn("TAssignation", new ArrayList<String>(Arrays.asList("assNum")));
		 chargeOperateur();
		 chargeFonction();
	 }
	 
	 
	 
	 public void chargeOperateur(){
		 operateurListe.clear();
		 operateurListe =(List<TOperateur>) iservice.getObjectsByColumn("TOperateur", new ArrayList<String>(Arrays.asList("opeMatricule")));
		}
	 
	 public void chargeFonction(){
		 fonctionListe.clear();
		 fonctionListe =(List<VFonctionAssignation>) iservice.getObjectsByColumn("VFonctionAssignation", new ArrayList<String>(Arrays.asList("fon_libelle")));
		}
	 

	public void filtreAssignation() {
		assignationListe=(List<TAssignation>) iservice.getObjectsByColumn("TAssignation", new ArrayList<String>(Arrays.asList("assNum")),
				new WhereClause("COM_LIBELLE",WhereClause.Comparateur.LIKE,"%"+filterCode+"%"));
	}
	@Transactional
	public String saveAssignation() throws IOException {
		//assignation.setComLibelleAbrege(assignation.getComLibelle());
		//commune.setComType(typeCom);
		//recup de l'operateur et de la fonction
		TOperateur op = new TOperateur(operateur);
		for(TOperateur o: operateurListe) {
			if(o.getOpeMatricule().equalsIgnoreCase(operateur)){
				op = o;	
			}
		}
		
		List<TFonction> lf = iservice.getObjectsByColumn("TFonction",
				new WhereClause("fon_cod",Comparateur.EQ,fonction));
		assignation.setTOperateur(op);
		assignation.setTFonction(lf.isEmpty()?new TFonction(fonction):lf.get(0));
		iservice.addObject(assignation);
		
		/*assignation=new TAssignation();
		assignation.setTFonction(new TFonction());
		assignation.setTOperateur(new TOperateur());*/
		chargeAssignation();
		userController.setTexteMsg("Enregistrement effectué avec succès !");
	    userController.setRenderMsg(true);
		userController.setSevrityMsg("success");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Enregistrement effectué avec succés! ", ""));
		return userController.renderPage("ass1");
	}

	public String updateAssignation() throws IOException {
		//recup de l'operateur et de la fonction
		TOperateur op = new TOperateur(operateur);
		for(TOperateur o: operateurListe) {
			if(o.getOpeMatricule().equalsIgnoreCase(operateur)){
				op = o;	
			}
		}
		
		List<TFonction> lf = iservice.getObjectsByColumn("TFonction",
				new WhereClause("fon_cod",Comparateur.EQ,fonction));
		assignation.setTOperateur(op);
		assignation.setTFonction(lf.isEmpty()?new TFonction(fonction):lf.get(0));
		
		iservice.updateObject(assignation);
		//chargeAssignation();
		//assignation=new TAssignation();
		//assignation.setTFonction(new TFonction());
		//assignation.setTOperateur(new TOperateur());
		userController.setTexteMsg("Modification effectué avec succès !");
		userController.setRenderMsg(true);
		userController.setSevrityMsg("success");
		return userController.renderPage("ass1");
	}
	
	@Transactional
	public void delete(){
		System.out.println("+-------------+ "+getSlctdTd().getAssNum());
		try {
			iservice.deleteObject(getSlctdTd());
			chargeAssignation();
			userController.setTexteMsg("Assignation supprimée avec succès !");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Assignation supprimée ! ", ""));
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			userController.setTexteMsg("Impossible de supprimer l' Assignation !");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("danger");
		}  
	}
	
	public String renderPage(String value) throws IOException{
		switch(value) {
		case "ass1":
			chargeAssignation();
			//userController.renderPage(value);
		break;
		case "ass2":
			assignation = new TAssignation();
			assignation.setTFonction(new TFonction());
			assignation.setTOperateur(new TOperateur());
			 chargeOperateur();
			 chargeFonction();
			assignation.setAssDatDeb(Calendar.getInstance().getTime());
			assignation.setAssDatFin(getDateFin(Calendar.getInstance().getTime()));
			assignation.setAssStatut(true);	
			assignation.setAssCourant("O");
			//userController.renderPage(value);
		break;
		case "ass3":
			operateur=assignation.getTOperateur().getOpeMatricule();
			fonction=assignation.getTFonction().getFonCod();
			chargeOperateur();
			 chargeFonction();
			//userController.renderPage(value);
			break;
		}
		return userController.renderPage(value);
	}
	
	 public Date getDateFin(Date debut) {
	    	int i=365;
	    	Calendar reference = Calendar.getInstance();
	    	reference.setTime(debut);
	    	reference.add(reference.DATE, i);
	    	return reference.getTime();
	    }
	 
	public String getFilterCode() {
		return filterCode;
	}

	public void setFilterCode(String filterCode) {
		this.filterCode = filterCode;
	}

	
	public TAssignation getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(TAssignation slctdTd) {
		this.slctdTd = slctdTd;
	}

	public TAssignation getAssignation() {
		return assignation;
	}

	public void setAssignation(TAssignation assignation) {
		this.assignation = assignation;
	}

	public List<TAssignation> getAssignationListe() {
		return assignationListe;
	}

	public void setAssignationListe(List<TAssignation> assignationListe) {
		this.assignationListe = assignationListe;
	}

	public List<TOperateur> getOperateurListe() {
		return operateurListe;
	}

	public void setOperateurListe(List<TOperateur> operateurListe) {
		this.operateurListe = operateurListe;
	}


	public List<VFonctionAssignation> getFonctionListe() {
		return fonctionListe;
	}

	public void setFonctionListe(List<VFonctionAssignation> fonctionListe) {
		this.fonctionListe = fonctionListe;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getAssCourant() {
		return assCourant;
	}

	public void setAssCourant(String assCourant) {
		this.assCourant = assCourant;
	}

	public String getAssStaut() {
		return assStaut;
	}

	public void setAssStaut(String assStaut) {
		this.assStaut = assStaut;
	}

	public Date getDateAssDeb() {
		return dateAssDeb;
	}

	public void setDateAssDeb(Date dateAssDeb) {
		this.dateAssDeb = dateAssDeb;
	}

	public Date getDateAssFin() {
		return dateAssFin;
	}

	public void setDateAssFin(Date dateAssFin) {
		this.dateAssFin = dateAssFin;
	}

}
