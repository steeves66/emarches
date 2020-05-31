package com.sndi.controller.admin;

import java.io.IOException;
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
import com.sndi.model.TAssignation;
import com.sndi.model.TFonction;
import com.sndi.model.TMinistere;
import com.sndi.model.TStructure;
import com.sndi.model.TTypeFonction;
import com.sndi.report.ProjetReportOld;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class FonctionController {
	Logger _logger = Logger.getLogger(FonctionController.class);
	@Autowired
	Iservice iservice;
	
	@Autowired
	KeyGen keyGen;
	
	@Autowired
	UserController userController;
	
	@Autowired
	ProjetReportOld projetReport;
	@Autowired
	ConstantService constantService;
	
	private String filterCode="";
	private TFonction fonction= new TFonction();
	private List <TFonction> fonctionListe = new ArrayList<TFonction>();
	private List<TTypeFonction> listTypefonction = new ArrayList<TTypeFonction>();
	private List<TMinistere> listMinistere = new ArrayList<TMinistere>();
	private List<TStructure> listStructure = new ArrayList<TStructure>();
	private TFonction slctdTd=new TFonction();
	

	private String typefonc="";
	private String minCode="";
	private String strCode="";
	
	 @PostConstruct
	public void postconst() {
		 chargeFonction();
		chargeTypeFonction();
		//chargeMinistere();
		chargeStructure();
		fonction = new TFonction();
		fonction.setTTypeFonction(new TTypeFonction());
		
		slctdTd = new TFonction();
		slctdTd.setTTypeFonction(new TTypeFonction());
		
	
	}
    
	 public void chargeFonction() {
		 fonctionListe= iservice.getObjectsByColumn("TFonction", new ArrayList<String>(Arrays.asList("fon_libelle")));
	 }
	 
	 
	 public void chargeTypeFonction(){
			listTypefonction.clear();
			listTypefonction =(List<TTypeFonction>) iservice.getObjectsByColumn("TTypeFonction", new ArrayList<String>(Arrays.asList("tyfCod")));
		}
	 
	 public void chargeMinistere() {
			listMinistere=(List<TMinistere>) iservice.getObjectsByColumn("TMinistere", new ArrayList<String>(Arrays.asList("minCode")));
		}
	 
	 public void chargeStructure(){
		 listStructure=(List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("strCode")));
		}

	public void filtrefonction() {
		fonctionListe= iservice.getObjectsByColumn("TFonction", new ArrayList<String>(Arrays.asList("fonCod")),
				new WhereClause("FON_LIBELLE",WhereClause.Comparateur.LIKE,"%"+filterCode+"%"));
	}
	
	
	 public void genereCodeFonction() {
		 if(!("empty".equalsIgnoreCase(typefonc) || "".equalsIgnoreCase(typefonc)) && !("empty".equalsIgnoreCase(strCode) || "".equalsIgnoreCase(strCode)) ){
			int i =-1;
			while( ++i<listTypefonction.size() && !(""+listTypefonction.get(i).getTyfCod()).equalsIgnoreCase(typefonc));
				fonction.setFonCod(keyGen.getCodeFonction(typefonc,strCode));
				fonction.setFonLibelle(listTypefonction.get(i).getTyfLibelle());
		   }else{
	    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," selectionnez le type fonction ou le ministère", ""));;
	      }
	 }
	 
	 public void genereCodeFonctionModif() {
		 if(!("empty".equalsIgnoreCase(typefonc) || "".equalsIgnoreCase(typefonc)) && !("empty".equalsIgnoreCase(strCode) || "".equalsIgnoreCase(strCode)) ){
			int i =-1;
			while( ++i<listTypefonction.size() && !(""+listTypefonction.get(i).getTyfCod()).equalsIgnoreCase(typefonc));
			slctdTd.setTTypeFonction(listTypefonction.get(i));
			slctdTd.setFonCod(keyGen.getCodeFonction(typefonc,strCode));
			slctdTd.setFonLibelle(listTypefonction.get(i).getTyfLibelle());
		   }else{
	    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," selectionnez le type fonction ou le ministère", ""));;
	      }
	 }
	 
	 
	
	public void onSelectTypeFonctionMoif() {
		
		
		if(!("empty".equalsIgnoreCase(typefonc) || "".equalsIgnoreCase(typefonc)) ){
			
			int i =-1;
			while( ++i<listTypefonction.size() && !(""+listTypefonction.get(i).getTyfCod()).equalsIgnoreCase(typefonc) );
			slctdTd.setTTypeFonction(listTypefonction.get(i));
			//slctdTd.setFonCod(keyGen.getFonctionID(listTypefonction.get(i).getTyfCod()));
			slctdTd.setFonLibelle(listTypefonction.get(i).getTyfLibelle());
			
		}else{
			//slctdTd.setStructure(null);
		}
		
	}
	

	
	@Transactional
	public String saveFonction() throws IOException {
		 if(typefonc.equalsIgnoreCase("")|| strCode.equalsIgnoreCase("")) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR," selectionnez le type fonction ou le ministère", ""));
				return null;
			}
		else {
			
			//fonction.setTMinistere(new TMinistere(minCode));
			fonction.setTStructure(new TStructure(strCode));
			fonction.setFonDatDeb(Calendar.getInstance().getTime());
			fonction.setTTypeFonction(new TTypeFonction(typefonc));
			iservice.addObject(fonction);
			
			fonction=new TFonction();
			chargeFonction();
			userController.setTexteMsg("Enregistrement effectué avec succès !");
		    userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
			userController.renderPage("fon1");
		    return	userController.renderPage("fon1");
			}
	
	}
	
	
	@Transactional
	public String updatefonction() throws IOException {
		iservice.updateObject(slctdTd);
		chargeFonction();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Modification effectuée avec succés! ", ""));
		userController.setTexteMsg("Modification effectué avec succès !");
		userController.setRenderMsg(true);
		userController.setSevrityMsg("success");
		return	userController.renderPage("fon1");
	}
	
	
	public void delete(){
		System.out.println("+-------------+ "+getSlctdTd().getFonCod()+"---"+getSlctdTd().getFonLibelle());
		try {
			iservice.deleteObject(getSlctdTd());
			chargeFonction();
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			userController.setTexteMsg("Impossible de supprimer la Fonction !");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("danger");
		}  
	}
	
	public String renderPage(String value) throws IOException{
		switch(value) {
		case "fon1":
			chargeFonction();
		    userController.initMessage();
		break;
		case "fon2":
			typefonc ="";
			minCode="";
			fonction = new TFonction();
			fonction.setTTypeFonction(new TTypeFonction());
			//fonction.setTMinistere(new  TMinistere());
			fonction.setTStructure(new TStructure());
			
			slctdTd = new TFonction();
			slctdTd.setTTypeFonction(new TTypeFonction());
			//slctdTd.setTMinistere(new  TMinistere());
			slctdTd.setTStructure(new TStructure());
			userController.initMessage();
		break;
		case "fon3":
			typefonc = slctdTd.getTTypeFonction().getTyfCod();
			//minCode= slctdTd.getTMinistere().getMinCode();
			strCode = slctdTd.getTStructure().getStrCode();
			userController.initMessage();
		break;
		}
		
		return userController.renderPage(value);
	}
	public String getFilterCode() {
		return filterCode;
	}

	public void setFilterCode(String filterCode) {
		this.filterCode = filterCode;
	}


	public List<TFonction> getFonctionListe() {
		return fonctionListe;
	}

	public void setFonctionListe(List<TFonction> fonctionListe) {
		this.fonctionListe = fonctionListe;
	}

	public List<TFonction> geTFonctionListe() {
		return fonctionListe;
	}

	public void seTFonctionListe(List<TFonction> fonctionListe) {
		this.fonctionListe = fonctionListe;
	}

	public TFonction getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(TFonction slctdTd) {
		this.slctdTd = slctdTd;
	}

	public TFonction getFonction() {
		return fonction;
	}

	public void setFonction(TFonction fonction) {
		this.fonction = fonction;
	}

//	public List<TSite> getListSite() {
//		return listSite;
//	}
//
//	public void setListSite(List<TSite> listSite) {
//		this.listSite = listSite;
//	}

	public List<TTypeFonction> getListTypefonction() {
		return listTypefonction;
	}

	public void setListTypefonction(List<TTypeFonction> listTypefonction) {
		this.listTypefonction = listTypefonction;
	}

	

	public String getTypefonc() {
		return typefonc;
	}

	public void setTypefonc(String typefonc) {
		this.typefonc = typefonc;
	}

	public List<TMinistere> getListMinistere() {
		return listMinistere;
	}

	public void setListMinistere(List<TMinistere> listMinistere) {
		this.listMinistere = listMinistere;
	}

	public String getMinCode() {
		return minCode;
	}

	public void setMinCode(String minCode) {
		this.minCode = minCode;
	}

	public List<TStructure> getListStructure() {
		return listStructure;
	}

	public void setListStructure(List<TStructure> listStructure) {
		this.listStructure = listStructure;
	}

	public String getStrCode() {
		return strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}


}
