package com.sndi.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.itextpdf.text.DocumentException;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAssignation;
import com.sndi.model.TFonction;
import com.sndi.model.TMinistere;
import com.sndi.model.TMotdepasse;
import com.sndi.model.TOperateur;
import com.sndi.model.TStructure;
import com.sndi.model.TTypeFonction;
import com.sndi.report.ProjetReport;
import com.sndi.security.CustomPasswordEncoder;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;

/**
 * @author BAH Glaho Jean Hervé, N'Guessan ZEKRE Kevin
 * Company: SNDI
 *
 */
@Component
@Scope(value="session")

public class OperateurController {
	Logger _logger = Logger.getLogger(OperateurController.class);
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	KeyGen keyGen;
	 @Autowired
	ProjetReport projetReport;
	@Autowired
	ConstantService constantService;
	
	private List<TOperateur> objetListe = new ArrayList<TOperateur>();
	private List<TOperateur> currentOpeListe = new ArrayList<TOperateur>();
	private List<TTypeFonction> listTypefonction = new ArrayList<TTypeFonction>();
	private List<TTypeFonction> listTypefonctionSelect = new ArrayList<TTypeFonction>();
	
	private String motPasse;
	private String motPasse2;
	private String breadcrumb;
	private Boolean boutonAdd=true;
	private Boolean boutonSupp=false;
	private String minCode;
	private String strCode;
	
	private TAssignation tmpAssignation = new TAssignation();
	private List<TAssignation> assignations = new ArrayList<TAssignation>();
	private List <TTypeFonction> tfonList = new ArrayList<TTypeFonction>();
	private List<TMinistere> listMinistere = new ArrayList<TMinistere>();
	private List<TStructure> listStructure = new ArrayList<TStructure>();
	private String tmpFonCod = "";

	//Variables for indexOpeloye
	private TOperateur slctdTd = new TOperateur();
	private OperateurFilter opeFilter = new OperateurFilter();
	private String filterLetter = "ALL";

	
	//Variables for nouvelOpeloye
	private TOperateur newOpe = new TOperateur();
	//private List<Departement> eaList= new ArrayList<Departement>();

	
	private boolean skip = false;
	private String newOpePage="operateurForm";
	private String structureid;
	private String typefonc="";
	private String site="";
	private String slctdTe = "";
	private Integer newOpeIndex=0;
	
	//Visibilité des boutons
	private boolean etatBoutoneng=true;
	private boolean etatBoutonEdit=false;
	
	
	private static HashMap <Integer, String> newOpePages = new HashMap <Integer, String> ();
	static{// steps
		newOpePages.put(0, "operateurForm");
		newOpePages.put(1, "assignForm");
		newOpePages.put(2, "confirmForm");
	}
	
	//variables for showOpeloye
	private String dialogueTitle ="";
	private TAssignation slctdAssignation = new TAssignation();
	private String sltdModule = "";
	private List<String> sltdActions = new ArrayList<String>();
	private List<String> test = new ArrayList<String>();
	private List <HashSet <String>> lockedAction = new ArrayList <HashSet <String>>();//TODO
	
	private Boolean modeCreerAssignation = false;
//	private Boolean checkTmpTAssignation = false;
	private Boolean selectAllActions = false;

	private String motPasseOld;
	private String motPasseUser;
	private String motPasse2User;
	private Integer indexAss=0;

	@PostConstruct
	public void postConstru() {	
		chargeData();
		//chargeStructureData();
		chargeTypeFonction();
		chargeMinistere();
		chargeStructure();
		chargeTypeFonctionselect();
		etatBoutoneng=true;
	    etatBoutonEdit=false;
	}
	
	 public String onFlowProcess(FlowEvent event) {
	        if(skip) {
	            skip = false;   //reset in case user goes back
	            return "confirm";
	        }
	        else {
	            return event.getNewStep();
	        }
	    }
	 public void chargeMinistere() {
			listMinistere=(List<TMinistere>) iservice.getObjectsByColumn("TMinistere", new ArrayList<String>(Arrays.asList("minCode")));
		} 
	 
	 public void chargeStructure() {
		 listStructure=(List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("strCode")));
		}
		
	public void chargeData(){
		test.clear();
		getObjetListe().clear();
		test.add("a");
		if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equals("ADM")) {
		objetListe = iservice.getObjects("TOperateur", new ArrayList<String>(Arrays.asList("opeNom")));
		currentOpeListe = new ArrayList<TOperateur>(objetListe);
		_logger.info("objetListe size: "+objetListe.size());
		filterLetter = "ALL";
		}
	}
	public void add() {
		test.add("a");
		boutonSupp=true;
	}
	public void supp() {
			int i=test.size();
			int posit=i-1;
			test.remove(posit);		
		}
	
	
	
	public void chargeTypeFonction(){
		listTypefonction.clear();
		listTypefonction =(List<TTypeFonction>) iservice.getObjectsByColumn("TTypeFonction", new ArrayList<String>(Arrays.asList("tyfCod")));
	}
	
	
	
	public void chargeTypeFonctionselect(){
		
	}
//	public void chargeSiteData(){
//		listSite.clear();
//		listSite =(List<TSite>) iservice.getObjectsByColumn("TSite", new ArrayList<String>(Arrays.asList("sitCode")));
//	}
	
	
	
	public void printOpe() throws IOException, DocumentException{
	
			 		projetReport.showOperateurPDF(slctdTd.getOpeMatricule())	;
			 		//userController.traceSysJournal(" Impression fiche identification: "+slctdTd.getOpeMatricule());
			    
	}
	public void printAllOpe() throws IOException, DocumentException{
		//projetReport.showOperateursPDF();
		//userController.traceSysJournal(" Impression des fiches d'identifications: ");
		
	}
	
	
	public boolean checkTmpAssignation(){
		if( "".equals(tmpFonCod) || "empty".equals(tmpFonCod) ){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez sélectionner une fonction SVP", ""));//OK
			return false;
		}
		if(tmpAssignation.getAssDatDeb() == null || tmpAssignation.getAssDatFin() == null){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir les dates SVP", ""));
			return false;
		}
	return true;
	}
	
	public boolean checkMotDePasseUser(){
		HashMap<String, String> hmErrors = new HashMap <String, String>();
		String messages ="";
	List<TMotdepasse> lmdp = iservice.getObjectsByColumn("TMotdepasse",
			new WhereClause("ope_matricule",Comparateur.EQ,slctdTd.getOpeMatricule()));
		currentOpeListe = new ArrayList<TOperateur>(objetListe);
		
		/*if("".equals(motPasseOld) ){
			hmErrors.put("MDP", "- Veuillez remplir l'ancien mot de passe SVP!");
		}*/
		if("".equals(motPasseUser) ){
			hmErrors.put("MDP1", "- Veuillez remplir le nouveau mot de passe SVP!");
		}
		
		if("".equals(motPasse2User) ){
			hmErrors.put("MDP2", "- Veuillez confirmer le nouveau mot de passe SVP!");
		}
		for(TMotdepasse mdp : lmdp){
			if(mdp.getMdpStatut() && motPasseUser.equals(mdp.getMdpMotdepasse())){
				hmErrors.put("MDP", "- Le mot de passe exist déjà!");
				break;
			}
		}
		if(!motPasseUser.equals(motPasse2User)){
			hmErrors.put("MDP3", "- Re-confirmer le nouveau mot de passe SVP!");
		}
		
		
		if(hmErrors.size() > 0){
			for(String s: hmErrors.values()){
				messages = s;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,messages, ""));  

			}
			return false;
		}
		return true;

	}
	public boolean checkMotDePasse(){
		HashMap<String, String> hmErrors = new HashMap <String, String>();
		String messages ="";
		
		if("".equals(motPasse) ){
			hmErrors.put("MDP1", "- Veuillez remplir le nouveau mot de passe SVP!");
		}
		
		if("".equals(motPasse2) ){
			hmErrors.put("MDP2", "- Veuillez confirmer le nouveau mot de passe SVP!");
		}
		for(TMotdepasse mdp : slctdTd.getTMotdepasses()){
			if(mdp.getMdpStatut() && !motPasseOld.equals(mdp.getMdpMotdepasse())){
				hmErrors.put("MDP", "- mot de passe erroné SVP!");
				break;
			}
		}
		if(!motPasse.equals(motPasse2)){
			hmErrors.put("MDP2", "- Re-confirmer le nouveau mot de passe SVP!");
		}
		
		
		if(hmErrors.size() > 0){
			for(String s: hmErrors.values()){
				messages = s;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,messages, ""));  

			}
			return false;
		}
		return true;

	}

	public boolean checkNewOpeStepI(){
		//TODO
		HashMap<String, String> hmErrors = new HashMap <String, String>();
		//String messages ="<html><body>";
		String messages ="";
		if("".equals(newOpe.getOpeNom()) ){
			hmErrors.put("NOM", "- Veuillez remplir le nom SVP!");
		}
		
		if("".equals(newOpe.getOpeMatricule()) ){
			hmErrors.put("MAT", "- Veuillez remplir le matricule SVP!");
		}
		
		if("".equals(newOpe.getOpeLogin())){
			hmErrors.put("LOGIN", "- Veuillez remplir le login SVP!");
		}
		
		if(!"".equals(newOpe.getOpeLogin()) ){
			for(TOperateur lg: objetListe){
				
				if(!"".equals(newOpe.getOpeLogin()) && lg.getOpeLogin().equalsIgnoreCase(newOpe.getOpeLogin())){					
					hmErrors.put("LOGIN", "- Login déja utilisé!");

				}
				
			}
		
	
			if("".equals(motPasse) ){
				hmErrors.put("MDP", "- Veuillez remplir le mot de passe SVP!");
			}else if("".equals(motPasse2) ){
				hmErrors.put("MDP", "- Veuillez confirmer le mot de passe SVP!");
			}else if(!motPasse2.equals(motPasse)){
				hmErrors.put("MDP", "- Les mots de passe ne correspondent pas!");
			}
		}
		
		
		if(hmErrors.size() > 0){
			for(String s: hmErrors.values()){
				//messages += s+" <\br>";
				messages = s;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,messages, ""));  

			}
			//messages += "</body></html> ";
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,messages, ""));  
			return false;
		}
		return true;
	
	}
	
	public boolean checkUpdateOpe(){
		//TODO
		HashMap<String, String> hmErrors = new HashMap <String, String>();
		//String messages ="<html><body>";
		String messages ="";
		if("".equals(newOpe.getOpeNom()) ){
			hmErrors.put("NOM", "- Veuillez remplir le nom SVP!");
		}
		
		
		if("".equals(newOpe.getOpeLogin())){
			hmErrors.put("LOGIN", "- Veuillez remplir le login SVP!");
		}
		
		if(!"".equals(newOpe.getOpeLogin()) ){
			for(TOperateur lg: objetListe){
				
				if(!"".equals(newOpe.getOpeLogin()) && lg.getOpeLogin().equalsIgnoreCase(newOpe.getOpeLogin())){					
					hmErrors.put("LOGIN", "- Login déja utilisé!");
					
				}
				
			}
		
		}
		
		
		if(hmErrors.size() > 0){
			for(String s: hmErrors.values()){
				//messages += s+" <\br>";
				messages = s;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,messages, ""));  
				
			}
			//messages += "</body></html> ";
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,messages, ""));  
			return false;
		}
		return true;
		
	}
	

	
	public boolean checkUpdateMDPOpe(){
		//TODO
		HashMap<String, String> hmErrors = new HashMap <String, String>();
		//String messages ="<html><body>";
		String messages ="";
		
			if("".equals(motPasse) ){
				hmErrors.put("MDP", "- Veuillez remplir le mot de passe SVP!");
			}else if("".equals(motPasse2) ){
				hmErrors.put("MDP", "- Veuillez confirmer le mot de passe SVP!");
			}else if(!motPasse2.equals(motPasse)){
				hmErrors.put("MDP", "- Les mots de passe ne correspondent pas!");
			}
		
		
		
		if(hmErrors.size() > 0){
			for(String s: hmErrors.values()){
				//messages += s+" <\br>";
				messages = s;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,messages, ""));  
				
			}
			//messages += "</body></html> ";
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,messages, ""));  
			return false;
		}
		return true;
		
	}
	
	
	

	public String renderPage(String value) throws IOException{

	    switch(value) {
	    
	    case "ope1":
		break;
		case "ope2":
			newOpe  = new TOperateur();
			etatBoutoneng=true;
		    etatBoutonEdit=false;
		    motPasse = "";
			motPasse2 = "";
			motPasseUser = "";
			motPasse2User = "";
			motPasseOld = "";   
		    newOpe.setOpeMatricule(keyGen.getOperateurCode());	
			
		break;
		case "ope3":
			break;
	    
	    }
	    return userController.renderPage(value);
	    
	}
	public String renderPageForUser() throws IOException{
		
		
		//if(GRFProperties.OPE2.equals(value)){//showOpeloye
			setSlctdTd(userController.getOperateur());
			_logger.info("slctdTd login: "+slctdTd.getOpeLogin());
			_logger.info("slctdTd nom: "+slctdTd.getOpeNom());
			motPasse = "";
			motPasse2 = "";
			motPasseUser = "";
			motPasse2User = "";
			motPasseOld = "";    		
//			slctdAssignation = new TAssignation();
//			assignations.clear();
//			tmpAssignation = new TAssignation();
//			setTmpFonCod("");
//			//fonList = new ArrayList (iservice.getObjectsByColumn("TFonction", new ArrayList<String>(Arrays.asList("fonLibelle")), new WhereClause("fonFonCod",Comparateur.EQ,"true")));
//			tfonList = new ArrayList (iservice.getObjects("TTypeFonction"));
//			_logger.info("tfonList size: "+ tfonList.size());
//			
//			List<TAssignation> listASS = (List<TAssignation>) iservice.getObjectsByColumn("TAssignation", new ArrayList<String>(Arrays.asList("assNum")), new WhereClause("OPE_MATRICULE",Comparateur.EQ,slctdTd.getOpeMatricule()));
//			_logger.info("listASS size: "+ listASS.size());
//			slctdTd.setTAssignations(new HashSet(listASS));
//			indexAss = 0;
//			//for(TAssignation a: slctdTd.getTAssignations()){
//			for(TAssignation a: listASS){
//				if(a.getAssStatut()){
//					assignations.add(a);
//				}
//			}
			
			return userController.renderPage("ope4");	
			
			
	}

	
	
	
	
	 public void genereCodeOperateur() {
      newOpe.setOpeMatricule(keyGen.getOperateurCode());		 
	 }


	public String creerOperateur() throws IOException{
		//TODO
				try {
					if(checkNewOpeStepI()){
						//CustomPasswordEncoder cp = new CustomPasswordEncoder();
					    newOpe.setOpeMatricule(keyGen.getOperateurCode());
					    newOpe.setTMinistere(new TMinistere(minCode));
					    newOpe.setTStructure(new TStructure(strCode));
						iservice.addObject(getNewOpe());
						//add Mot de passe
						TMotdepasse mdp = new TMotdepasse();
						mdp.setTOperateur(getNewOpe());
						//mdp.setMdpMotdepasse(cp.encode(motPasse));
						//mdp.setMdpMotdepasseInit(motPasse);
						mdp.setMdpMotdepasse(motPasse);
						mdp.setMdpDate(Calendar.getInstance().getTime());
						mdp.setMdpStatut(true);
						iservice.addObject(mdp);
					    chargeData();
					    userController.setTexteMsg("Enregistrement effectué avec succès !");
						userController.setRenderMsg(true);
						userController.setSevrityMsg("success");
					return renderPage("ope1");
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return renderPage("ope2");
			}
	
	
	@Transactional
	public String update() throws IOException{
		//TODO
		try {
			if(checkUpdateOpe()){
			iservice.updateObject(slctdTd);
			chargeData();
			 userController.setTexteMsg("Modification effectué avec succès !");
			 userController.setRenderMsg(true);
			 userController.setSevrityMsg("success");
			return renderPage("ope1");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return renderPage("ope3");
	}
	
	@Transactional
	public void delete(){
		System.out.println("+-------------+ "+getSlctdTd().getOpeMatricule()+"---"+getSlctdTd().getOpeNom());
		try {
			//Surepssion des mdp
			List<TMotdepasse> listTND = ((List<TMotdepasse>) iservice.getObjectsByColumn("TMotdepasse", new WhereClause("MDP_OPE_MATRICULE",Comparateur.EQ, slctdTd.getOpeMatricule() )));
			for(TMotdepasse pwd: listTND){
				
				iservice.deleteObject(pwd);
			
			}
			iservice.deleteObject(getSlctdTd());
			chargeData();
			userController.setTexteMsg("Opérateur supprimé avec succès !");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("success");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Opérateur supprimé ! ", ""));
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			chargeData();
			userController.setTexteMsg("Impossible de supprimer l'Opérateur !");
			userController.setRenderMsg(true);
			userController.setSevrityMsg("danger");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN," Impossible de supprimer l'Opérateur ! ", ""));
		}  
	}
	
	@Transactional
	public void restorerOperateur(){
		//TODO
		
	}
	
	@Transactional
	public void changerMotDePasse(){
		try {
			
			 CustomPasswordEncoder cp = new CustomPasswordEncoder();
				
			if(checkMotDePasseUser()){
				List<TMotdepasse> listTND = ((List<TMotdepasse>) iservice.getObjectsByColumn("TMotdepasse", new WhereClause("ope_matricule",Comparateur.EQ, slctdTd.getOpeMatricule() )));
				for(TMotdepasse pwd: listTND){
					pwd.setMdpStatut(false);
					//cryptage
					//pwd.setMdpMotdepasseInit("");
					iservice.updateObject(pwd);
					_logger.info("Mot de passe modifie id:"+pwd.getMdpId());
				}
				
				TMotdepasse mdp = new TMotdepasse();
				mdp.setTOperateur(slctdTd);
				/*cryptage
				mdp.setMdpMotdepasse(cp.encode(motPasseUser));
				mdp.setMdpMotdepasseInit(motPasseUser);*/
				mdp.setMdpDate(Calendar.getInstance().getTime());
				mdp.setMdpStatut(true);
				iservice.addObject(mdp);
				
				//renderPage("14");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Mot de passe modifié avec succès ! ", ""));
			}else {
				
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void updateMotDePasse(){
		try {
			//_logger.info("motPasse :"+motPasse);
			 CustomPasswordEncoder cp = new CustomPasswordEncoder();
			
			if(checkUpdateMDPOpe()){
				List<TMotdepasse> listTND = ((List<TMotdepasse>) iservice.getObjectsByColumn("TMotdepasse", new WhereClause("ope_matricule",Comparateur.EQ, slctdTd.getOpeMatricule() )));
				for(TMotdepasse pwd: listTND){
					if(pwd.getMdpStatut()) {
						_logger.info("motPasseOld :"+pwd.getMdpMotdepasse()+" motPasseUser:"+motPasse+" motPasse2User:"+motPasse2);
						pwd.setMdpMotdepasse(cp.encode(motPasse));
						iservice.updateObject(pwd);
						_logger.info("Mot de passe modifie id:"+pwd.getMdpId());
					}
					
				}
				//renderPage("14");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Mot de passe modifié avec succès ! ", ""));
			}else {
				
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void reinitialiserMotDePasse(){
		try {
			motPasse = slctdTd.getOpeLogin();
			
			 //CustomPasswordEncoder cp = new CustomPasswordEncoder();
			 
			 List<TMotdepasse> listTND = ((List<TMotdepasse>) iservice.getObjectsByColumn("TMotdepasse", new WhereClause("ope_matricule",Comparateur.EQ, slctdTd.getOpeMatricule() )));
				for(TMotdepasse pwd: listTND){
					if(pwd.getMdpStatut()) {
						_logger.info("motPasseOld :"+pwd.getMdpMotdepasse()+" motPasseUser: "+motPasse);
						pwd.setTOperateur(getNewOpe());
						/*//cryptage
						pwd.setMdpMotdepasse(cp.encode(motPasse));
						pwd.setMdpMotdepasseInit(motPasse);*/
						iservice.updateObject(pwd);
						_logger.info("Mot de passe modifie id: "+pwd.getMdpId());
					}
					
				}
				//renderPage("14");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Mot de passe Réinitialisé avec succès ! ", ""));
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Le nouveau mot de passe  est:"+motPasse, ""));	
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Transactional
    public void onSelectDefault(TAssignation a){
		_logger.info("Selection ASS : "+a.getTFonction().getFonCod()+ "fonCod : "+a.getTFonction().getFonLibelle()+" default:"+a.getAssCourant());
		String value = a.getAssCourant();
		List<TAssignation> listASS = (List<TAssignation>) iservice.getObjectsByColumn("TAssignation", new ArrayList<String>(Arrays.asList("assNum")),
		new WhereClause("OPE_MATRICULE",Comparateur.EQ,""+a.getTOperateur().getOpeMatricule()));

    	for (TAssignation ass : listASS){
    		if(ass.getAssNum()==a.getAssNum()) {	
    		ass.setAssCourant("O");
    		a=ass;
    		iservice.updateObject(a);
    		}else {
    		ass.setAssCourant("N");
    		iservice.updateObject(ass);
    		}
    		
			_logger.info("TAssignation SET N fonCod:"+ass.getTFonction().getFonCod()+" default:"+ass.getAssCourant());

    	}
		_logger.info("TAssignation SET VALUE fonCod:"+a.getTFonction().getFonCod()+" default:"+a.getAssCourant());
		/*for (TAssignation ass : assignations){
			iservice.updateObject(ass);
			_logger.info("TFonction modifier id:"+ass.getAssNum()+" fonCod:"+ass.getTFonction().getFonCod()+" default:"+ass.getAssCourant());

		}*/
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification effectuée avec succès ! ", ""));

    }
	@Transactional
	public void assStatut(String val){
	if(val.equals("true")){
		slctdAssignation.setAssStatut(true);
		iservice.updateObject(slctdAssignation);
		//userController.traceSysJournal(" Fonction activer: "+slctdAssignation.getTFonction().getFonCod());
		FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Fonction activée ! ", ""));
	}else if(val.equals("false")){
		
		slctdAssignation.setAssStatut(false);
		iservice.updateObject(slctdAssignation);
		//userController.traceSysJournal(" Fonction désactiver: "+slctdAssignation.getTFonction().getFonCod());
		FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_WARN, "Fonction désactivée ! ", ""));
		
	}
		
		
			
		
		
	}
	
	@Transactional
	public void validerTAssignation(){
		//TODO
		try{
			if(modeCreerAssignation && checkTmpAssignation()){
				tmpAssignation.setTOperateur(slctdTd);
				iservice.addObject(tmpAssignation);
				
				//renderPage("12");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "TAssignation créée avec succès ! ", ""));
	
			}else if (!modeCreerAssignation){
				
				iservice.updateObject(slctdAssignation);
				_logger.info("TAssignation modifie fonCod:"+slctdAssignation.getTFonction().getFonCod());
		
				//renderPage("12");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "TAssignation modifiée avec succès ! ", ""));

			}

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void modifier(){
		//TODO
	}
	
	public void vider(){
		setNewOpe(new TOperateur());
		setMotPasse("");
	}

	
	
	
    public Date getDateFin(Date debut) {
    	int i=365;
    	Calendar reference = Calendar.getInstance();
    	reference.setTime(debut);
    	reference.add(reference.DATE, i);
    	return reference.getTime();
    }
    public void onSelectDefaultForAdd(TAssignation item){
		_logger.info("Selection ASS : "+item.getTFonction().getFonCod()+ "fonCod : "+item.getTFonction().getFonLibelle()+" default:"+item.getAssCourant());
		String value = item.getAssCourant();
		if(value.equals("O")) {
	    	for (TAssignation ass : assignations){
	    		if(ass.getAssNum()!=item.getAssNum()) {	
	    		ass.setAssCourant("N");
	    		}else {
	    		ass.setAssCourant("O");	
	    		}
	    	}
		}
    }
    

	public void addAssignation() {
    	//TODO initialized some tmps assignation values
//    	assignations.add(this.tmpTAssignation);
		//init tass 
		
		tmpAssignation = new TAssignation();
		//tmpTAssignation.setAssDefault(false);
		tmpAssignation.setAssStatut(true);

		
		boolean val =false;
		for(TAssignation a:assignations) {
			if("O".equals(a.getAssCourant())) {
				val =true;
				break;
			}
		}
		if(val) { tmpAssignation.setAssCourant("N");}else {tmpAssignation.setAssCourant("O");}
		//gestion des dates 
		tmpAssignation.setAssDatDeb(Calendar.getInstance().getTime());
		tmpAssignation.setAssDatFin(getDateFin(Calendar.getInstance().getTime()));
		
		TFonction tmpFonction = new TFonction();
		tmpFonction.setFonLibelle("");
		tmpFonction.setFonCod("empty");
		
		tmpFonction.setTTypeFonction(new TTypeFonction());
		
		tmpAssignation.setTFonction(tmpFonction);
		tmpAssignation.setTOperateur(newOpe);
		tmpAssignation.setAssNum(assignations.size()+1);
		
    	assignations.add(this.tmpAssignation);
		//_logger.info("Ajout assignation fonction code: "+tmpAssignation.getTFonction().getFonCod()+" libelle:"+ tmpAssignation.getTFonction().getFonLibelle());
//		_logger.info("Ajout assignation fonction code: "+tmpTAssignation.getTFonction().getFonCod()+" libelle:"+ tmpTAssignation.getTFonction().getFonLibelle()+" dateDeb:"+ tmpTAssignation.getAssDatDeb());
		//clear tmpassignation and other fiels
		//tmpFonCod = "empty";
    	setTmpAssignation(new TAssignation());
    }

    public void removeAssignation(TAssignation item) {
    	assignations.remove(item);
    	if(assignations.size()==1) assignations.get(0).setAssCourant("O");

    }

    
  

	public void nouvelleAssignation(){
		_logger.info("Boite de dialogue Modifier TAssignation ");
    	setDialogueTitle("Créer TAssignation");
    	setModeCreerAssignation(true);
    	setTmpAssignation(new TAssignation());
    	tmpAssignation.setAssStatut(true);
    	tmpAssignation.setAssCourant("1");//TODO a supprimer quand assCourant sera supprimer
		tmpFonCod = "empty";
		_logger.info("tmpTAssignation ModeCreerTAssignation:"+modeCreerAssignation);

    	
    }	
	
	public void modifierAssignation(){
		setDialogueTitle("Modifier TAssignation");
		setModeCreerAssignation(false);
		setTmpAssignation(slctdAssignation);
		tmpFonCod = slctdAssignation.getTFonction().getFonCod();
		_logger.info("tmpAssignation fonCod : "+tmpAssignation.getTFonction().getFonCod()+ " ModeCreerAssignation:"+modeCreerAssignation);
	}
	


	public void onInputLogin(){
		
		for(TOperateur lg: objetListe){
			if(lg.getOpeLogin().equalsIgnoreCase(newOpe.getOpeLogin())){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login déja utilisé ! ", ""));  
			}			
		}
	}
	
	public void onInputMatricule(){
		
		for(TOperateur lg: objetListe){
			if(lg.getOpeMatricule().equalsIgnoreCase(newOpe.getOpeMatricule())){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Matricule déja utilisé ! ", ""));  
			}			
		}
	}
	public void onInputMotPasse(){
		
	}

    
    public void onSelectStatut(){
		iservice.updateObject(getSlctdTd());
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Employé modifié avec succès ! ", ""));

    }
    

    /*public void onSelectTypeOperateur(){
    	if(!("empty".equalsIgnoreCase(slctdTe) || "".equalsIgnoreCase(slctdTe)) ){
	    	int i=-1;
	    	while(++i<teList.size() && !(""+teList.get(i).getTeId()+"").equals(slctdTe));
	    	newEmp.setTypeEmploye(teList.get(i));
			_logger.info("Selection TE : "+teList.get(i).getTeId()+ " libelle:"+teList.get(i).getTeLibelle());

    	}else{
	    	newEmp.setTypeEmploye(new TypeEmploye());
    		_logger.info("Selection TE : NULL");

    	}
    	
    }    */
    
   
   
    public String getFoncCode(String fonCod, String typefCode, String minCode) {
    	String fonCode ="";
    	if(fonCod.contains("VAL")) 
    		 fonCode = fonCod; else  fonCode = typefCode+minCode;
    	
		return fonCode;
	}
	   
    
    public void onSelectTypeFonction(TAssignation item){
    	//TODO parcourir la liste des types fonctions
    	if(!("empty".equalsIgnoreCase(item.getTFonction().getTTypeFonction().getTyfCod()) || "".equalsIgnoreCase(item.getTFonction().getTTypeFonction().getTyfCod())) ){
	
			_logger.info("Ajout assignation Type fonction code: "+item.getTFonction().getTTypeFonction().getTyfCod());
			int i =-1;
			while( ++i<tfonList.size() && !tfonList.get(i).getTyfCod().equals(item.getTFonction().getTTypeFonction().getTyfCod()) );
	//		item.setTFonction( tmpFct );
			item.getTFonction().setTTypeFonction( tfonList.get(i));
			//item.getTFonction().setFonLibelle(tfonList.get(i).getTyfLibelle());
			String fonCod = item.getTFonction().getFonCod();
		//	item.getTFonction().setFonCod(getFoncCode(fonCod,tfonList.get(i).getTyfCod(),""+ item.getTFonction().getMinCode()));
			
    	}else{
    		TTypeFonction tf = new TTypeFonction();
    		tf.setTyfCod("");
    		tf.setTyfLibelle("");
    		item.getTFonction().setTTypeFonction(tf);
    	}
    }
    
    public void onSelectTypeVal(TAssignation item){
    	//TODO parcourir la liste des types fonctions
    	if(!("empty".equalsIgnoreCase(item.getTFonction().getFonCod()) || "".equalsIgnoreCase(item.getTFonction().getFonCod())) ){
    		String fonCod = item.getTFonction().getFonCod();
    	//	item.getTFonction().setFonCod(getFoncCode(fonCod,item.getTFonction().getTTypeFonction().getTyfCod(),""+ item.getTFonction().get));
    		_logger.info("Fonction code: "+item.getTFonction().getFonCod());
    		
    	}else{
    		FacesContext.getCurrentInstance().addMessage("",
    				new FacesMessage(FacesMessage.SEVERITY_WARN, "Sélectionnez un type de validateur ! ", ""));

    	}
    }

    
    
//    public void onSelectFonction(TAssignation item){
//    	//TODO parcourir la liste de fonction
//    	if(!("empty".equalsIgnoreCase(item.getTFonction().getFonCod()) || "".equalsIgnoreCase(item.getTFonction().getFonCod())) ){
//	
//			_logger.info("Ajout assignation fonction code: "+item.getTFonction().getFonCod());
//			//tmpTAssignation.setTFonction( ((List<TFonction>) iservice.getObjectsByColumn("TFonction", new WhereClause("fonCod",Comparateur.EQ, tmpFonCod ))).get(0) );
//	//		TFonction tmpFct = ((List<TFonction>) iservice.getObjectsByColumn("TFonction", new WhereClause("fonCod",Comparateur.EQ, item.getTFonction().getFonCod() ))).get(0);
//			int i =-1;
//			while( ++i<fonList.size() && !fonList.get(i).getFonCod().equals(item.getTFonction().getFonCod()) );
//	//		item.setTFonction( tmpFct );
//			item.setTFonction( fonList.get(i));
//    	}else{
//    		item.setTFonction(null);
//    	}
//    }
    
 
    
    public void changeStartWith(String letter){
    	switch(letter){
		case "ALL": //all operateur			
			chargeData();
	        currentOpeListe = getFilteredOperateur(opeFilter);
			_logger.info("StartWith change:"+ letter);

			break;
		default:
			filterLetter = letter;
			objetListe = getStartWith(letter);
	        currentOpeListe = getFilteredOperateur(opeFilter);
			_logger.info("StartWith change:"+ letter);
			break;
    	}
			
    	
    }
    
    	
	public List<TOperateur> getStartWith(String letter){
		return iservice.getObjectsByColumn("TOperateur", new ArrayList<String>(Arrays.asList("opeNom")), new WhereClause("opeNom",Comparateur.LIKE, letter+"%" )); 
	}
	
    public void reinitaliserCurrentOpeListe(){
    	opeFilter = new OperateurFilter();
        currentOpeListe = getFilteredOperateur(opeFilter);
		_logger.info("reinitaliser liste");
    }
    
    public void changeFilter() {
        currentOpeListe = getFilteredOperateur(opeFilter);
		_logger.info("filter change:"+ opeFilter.getNomComplet());

    }
    
    public List<TOperateur> getFilteredOperateur(OperateurFilter filter){
        List<TOperateur> someOperateur = new ArrayList<TOperateur>();
        String nomComplet = filter.getNomComplet().toLowerCase();
//      String prenom = filter.getPrenom().toLowerCase();

        Boolean statut = null;

        if(filter.getStatut().toLowerCase().equals("true")){
        	statut = true;
        }else if(filter.getStatut().toLowerCase().equals("false")){
        	statut = false;
        }
         
        if(statut != null){
	        for (Iterator<TOperateur> i = objetListe.iterator(); i.hasNext();) {
	        	TOperateur tmp = i.next();
	            if ( ((tmp.getOpeNom().toLowerCase().contains(nomComplet) || tmp.getOpeMatricule().toLowerCase().contains(nomComplet)
	            		|| (tmp.getOpeMail() != null && tmp.getOpeMail().toLowerCase().contains(nomComplet)) || ( tmp.getOpeLogin()!= null && tmp.getOpeLogin().toLowerCase().contains(nomComplet))
	            		//|| (tmp.getDepartement() != null && tmp.getDepartement().getDepLibelle().toLowerCase().contains(nomComplet)) || (tmp.getTypeEmploye() != null && tmp.getTypeEmploye().getTeLibelle().toLowerCase().contains(nomComplet))) && tmp.isEmpStatut() == statut  
	            		))){
	            	someOperateur.add(tmp);
	            }
	        }
        }else{
        	for (Iterator<TOperateur> i = objetListe.iterator(); i.hasNext();) {
	        	TOperateur tmp = i.next();
	            if (tmp.getOpeNom().toLowerCase().contains(nomComplet) || tmp.getOpeMatricule().toLowerCase().contains(nomComplet)
	            		|| (tmp.getOpeMail() != null && tmp.getOpeMail().toLowerCase().contains(nomComplet)) || ( tmp.getOpeLogin()!= null && tmp.getOpeLogin().toLowerCase().contains(nomComplet)) 
	            		//|| (tmp.getDepartement() != null && tmp.getDepartement().getDepLibelle().toLowerCase().contains(nomComplet)) || (tmp.getTypeEmploye() != null && tmp.getTypeEmploye().getTeLibelle().toLowerCase().contains(nomComplet)
	            		){
	            	someOperateur.add(tmp);
	            }
	        }
        }
		_logger.info("someOperateur size : "+someOperateur.size()+" keyword:"+nomComplet);

        return someOperateur;
    }
    

    


	public boolean isLocked(String actCod){
		return lockedAction.get(indexAss).contains(actCod);		
	}
	

	
    public void flowProcess(Integer step) {
		_logger.info("newOpeIndex: "+newOpeIndex+" step:"+ step+" skip:"+skip+" newOpePages: "+newOpePage);

    	if(newOpeIndex > step){// bouton retour
    		setNewOpeIndex(step);
			setNewOpe(this.newOpe);

    		switch(step){
	    	case 0:

	    		setNewOpePage(newOpePages.get(0));
	    		_logger.info("Retour case0: newOpeIndex: "+newOpeIndex+" step:"+ step+" skip:"+skip);
	    		_logger.info("newOpePage: "+newOpePage);
	    		break;
	    	case 1:
	    		if(skip ){
	    			//TODO delete assignation
	        		setNewOpeIndex(0);
	    			setNewOpePage(newOpePages.get(0));
	    		}else{
	    			setNewOpePage(newOpePages.get(1));
	    		}
	    		_logger.info("Retour case1: newOpeIndex: "+newOpeIndex+" step:"+ step+" skip:"+skip);
	    		_logger.info("newOpePage: "+newOpePage);
	    		break;
	    		
	    	}
    	}else{// bouton suivant
    		setNewOpeIndex(step);
			setNewOpe(this.newOpe);

	    	switch(step){
	    	case 1:
	    		if(skip && checkNewOpeStepI()){
	    			//TODO delete assignation
					//newOpe.setOpeNom(newOpe.getOpeNom().toUpperCase());
					//newOpe.setEmpPrenom(newEmp.getEmpPrenom().toLowerCase());
					//newOpe.setOpeLogin(newOpe.getOpeLogin().toLowerCase());
	        		setNewOpeIndex(2);
	    			setNewOpePage(newOpePages.get(2));
	    		}else if( checkNewOpeStepI()){
	    			setNewOpePage(newOpePages.get(1));
	    		}else{
	        		setNewOpeIndex(0);
	    		}
	    		_logger.info("case1: newOpeIndex: "+newOpeIndex+" step:"+ step+" skip:"+skip);
	    		_logger.info("newOpePage: "+newOpePage);
	    		_logger.info("newOpe: nom - "+newOpe.getOpeNom()+" login -"+newOpe.getOpeLogin());
	    		break;
	    	case 2:
				//newOpe.setOpeNom(newOpe.getOpeNom().toUpperCase());
				//newEmp.setEmpPrenom(newEmp.getEmpPrenom().toLowerCase());
				//newOpe.setOpeLogin(newOpe.getOpeLogin().toLowerCase());
	    		if( assignations.isEmpty()) {
	    			
	    		setNewOpePage(newOpePages.get(1));
	    		String messages = "- Veuillez sasir une assignation SVP!";
	    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,messages, ""));  
	    		}else {
	    		setNewOpePage(newOpePages.get(2));
	    		_logger.info("case 2: newOpeIndex: "+newOpeIndex+" step:"+ step+" skip:"+skip);
	    		_logger.info("newOpePage: "+newOpePage);
	    		_logger.info("newOpe: nom - "+newOpe.getOpeNom()+" login -"+newOpe.getOpeLogin());
	    		}

	    		break;
	    		
	    	}
    	}
    	
//        if(skip) {
//            skip = false;   //reset in case user goes back
//            return "confirm";
//        }
//        else {
//            return event.getNewStep();
//        }
    }
    


	public String getSltdModule() {
		return sltdModule;
	}

	public void setSltdModule(String sltdModule) {
		this.sltdModule = sltdModule;
	}

	

	public List<String> getSltdActions() {
		return sltdActions;
	}

	public void setSltdActions(List<String> sltdActions) {
		this.sltdActions = sltdActions;
	}

	public Integer getIndexAss() {
		return indexAss;
	}

	public void setIndexAss(Integer indexAss) {
		this.indexAss = indexAss;
	}

	public Boolean getSelectAllActions() {
		return selectAllActions;
	}

	public void setSelectAllActions(Boolean selectAllActions) {
		this.selectAllActions = selectAllActions;
	}
    
    
   public List<TAssignation> getAssignations() {
		return assignations;
	}

	public void setAssignations(List<TAssignation> assignations) {
		this.assignations = assignations;
	}

	public static HashMap<Integer, String> getNewOpePages() {
		return newOpePages;
	}

	public static void setNewOpePages(HashMap<Integer, String> newOpePages) {
		OperateurController.newOpePages = newOpePages;
	}

	public String getDialogueTitle() {
		return dialogueTitle;
	}

	public void setDialogueTitle(String dialogueTitle) {
		this.dialogueTitle = dialogueTitle;
	}

	public TAssignation getSlctdAssignation() {
		return slctdAssignation;
	}

	public void setSlctdAssignation(TAssignation slctdAssignation) {
		this.slctdAssignation = slctdAssignation;
	}

	public Boolean getModeCreerAssignation() {
		return modeCreerAssignation;
	}

	public void setModeCreerAssignation(Boolean modeCreerAssignation) {
		this.modeCreerAssignation = modeCreerAssignation;
	}

	public List<TOperateur> getObjetListe() {
		return objetListe;
	}

	public void setObjetListe(List<TOperateur> objetListe) {
		this.objetListe = objetListe;
	}
	
	public List<TOperateur> getCurrentOpeListe() {
		return currentOpeListe;
	}

	public void setCurrentOpeListe(List<TOperateur> objetListe) {
		this.currentOpeListe = objetListe;
	}

	public OperateurFilter getOpeFilter() {
		return opeFilter;
	}

	public void setOpeFilter(OperateurFilter opeFilter) {
		this.opeFilter = opeFilter;
	}

	public String getFilterLetter() {
		return filterLetter;
	}

	public void setFilterLetter(String filterLetter) {
		this.filterLetter = filterLetter;
	}

	public String getNewOpePage() {
		return newOpePage;
	}
	public void setNewOpePage(String newOpePage) {
		this.newOpePage = newOpePage;
	}

	public Integer getNewOpeIndex() {
		return newOpeIndex;
	}
	
	public void setNewOpeIndex(Integer newOpeIndex) {
		this.newOpeIndex = newOpeIndex;
	}

	public TOperateur getNewOpe() {
		return newOpe;
	}
	public void setNewOpe(TOperateur newOpe) {
		this.newOpe = newOpe;
	}

	
	public String getBreadcrumb() {
		return breadcrumb;
	}

	public void setBreadcrumb(String breadcrumb) {
		this.breadcrumb = breadcrumb;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getMotPasse2() {
		return motPasse2;
	}

	public void setMotPasse2(String motPasse2) {
		this.motPasse2 = motPasse2;
	}

	public String getMotPasseOld() {
		return motPasseOld;
	}

	public void setMotPasseOld(String motPasseOld) {
		this.motPasseOld = motPasseOld;
	}

	public String getMotPasseUser() {
		return motPasseUser;
	}

	public void setMotPasseUser(String motPasseUser) {
		this.motPasseUser = motPasseUser;
	}

	public String getMotPasse2User() {
		return motPasse2User;
	}

	public void setMotPasse2User(String motPasse2User) {
		this.motPasse2User = motPasse2User;
	}


	public String getSlctdTe() {
		return slctdTe;
	}

	public void setSlctdTe(String slctdTe) {
		this.slctdTe = slctdTe;
	}

	public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String getTmpFonCod() {
		return tmpFonCod;
	}

	public void setTmpFonCod(String tmpFonCod) {
		this.tmpFonCod = tmpFonCod;
	}	
	

	public List<TTypeFonction> getTfonList() {
		return tfonList;
	}

	public void setTfonList(List<TTypeFonction> tfonList) {
		this.tfonList = tfonList;
	}

	public TAssignation getTmpAssignation() {
		return tmpAssignation;
	}

	public void setTmpAssignation(TAssignation tmpAssignation) {
		this.tmpAssignation = tmpAssignation;
	}


//	public List<TTypeOperateur> getListTypeOperateur() {
//		return listTypeOperateur;
//	}
//
//	public void setListTypeOperateur(List<TTypeOperateur> listTypeOperateur) {
//		this.listTypeOperateur = listTypeOperateur;
//	}

	public List<TTypeFonction> getListTypefonction() {
		return listTypefonction;
	}

	public void setListTypefonction(List<TTypeFonction> listTypefonction) {
		this.listTypefonction = listTypefonction;
	}

//	public List<TSite> getListSite() {
//		return listSite;
//	}
//
//	public void setListSite(List<TSite> listSite) {
//		this.listSite = listSite;
//	}


	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTypefonc() {
		return typefonc;
	}

	public void setTypefonc(String typefonc) {
		this.typefonc = typefonc;
	}

	public List<TTypeFonction> getListTypefonctionSelect() {
		return listTypefonctionSelect;
	}

	public void setListTypefonctionSelect(List<TTypeFonction> listTypefonctionSelect) {
		this.listTypefonctionSelect = listTypefonctionSelect;
	}

	public List<String> getTest() {
		return test;
	}

	public void setTest(List<String> test) {
		this.test = test;
	}

	public Boolean getBoutonAdd() {
		return boutonAdd;
	}

	public void setBoutonAdd(Boolean boutonAdd) {
		this.boutonAdd = boutonAdd;
	}

	public Boolean getBoutonSupp() {
		return boutonSupp;
	}

	public void setBoutonSupp(Boolean boutonSupp) {
		this.boutonSupp = boutonSupp;
	}

	public String getStructureid() {
		return structureid;
	}

	public void setStructureid(String structureid) {
		this.structureid = structureid;
	}

	public boolean isEtatBoutonEdit() {
		return etatBoutonEdit;
	}

	public void setEtatBoutonEdit(boolean etatBoutonEdit) {
		this.etatBoutonEdit = etatBoutonEdit;
	}

	public boolean isEtatBoutoneng() {
		return etatBoutoneng;
	}

	public void setEtatBoutoneng(boolean etatBoutoneng) {
		this.etatBoutoneng = etatBoutoneng;
	}

	public TOperateur getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(TOperateur slctdTd) {
		this.slctdTd = slctdTd;
	}

	public String getMinCode() {
		return minCode;
	}

	public void setMinCode(String minCode) {
		this.minCode = minCode;
	}

	public List<TMinistere> getListMinistere() {
		return listMinistere;
	}

	public void setListMinistere(List<TMinistere> listMinistere) {
		this.listMinistere = listMinistere;
	}

	public String getStrCode() {
		return strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	public List<TStructure> getListStructure() {
		return listStructure;
	}

	public void setListStructure(List<TStructure> listStructure) {
		this.listStructure = listStructure;
	}

	
	
	
}


