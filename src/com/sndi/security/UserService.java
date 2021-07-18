package com.sndi.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.sndi.model.TAssignation;
import com.sndi.model.TFonction;
import com.sndi.model.TMotdepasse;
import com.sndi.model.TOperateur;
import com.sndi.model.TTypeFonction;
import com.sndi.utilitaires.AutorityAction;
import com.sndi.utilitaires.AutorityClass;
import com.sndi.utilitaires.AutorityTraitement;

@org.springframework.stereotype.Service
public class UserService implements IUserService {

	private TOperateur operateur = new TOperateur();
	private List<TAssignation> listeAss = new ArrayList<TAssignation>();
	//private HashMap <String, List<TTypefonctionaction>> hmPrivileges = new HashMap <String , List<TTypefonctionaction>>(); 
	//private HashMap <String, List<TTypefonctionaction>> hmPrivileges = new HashMap <String , List<TTypefonctionaction>>(); 
	private TMotdepasse motdepasses = new TMotdepasse();
	private TFonction fonctions = new TFonction();
	private Date dateCons;
	private AutorityClass autoritys = new AutorityClass();
	//private List<SysTraitement> menus = new ArrayList<SysTraitement>();
	
	public List<TAssignation> getListeAssignations(TOperateur operateur){
		List<TAssignation> listeTAssignation = new ArrayList<TAssignation>();
		for(TAssignation ass: operateur.getTAssignations()){
			if(ass.getAssStatut()==true){// TODO and the assignation isn't expired
				listeTAssignation.add(ass);	
			}
		}
		//ordonner les TAssignations
		 Collections.sort(listeTAssignation, new Comparator<TAssignation>() {
		        @Override public int compare(TAssignation p1, TAssignation p2) {
		        	int n = p1.getTFonction().getFonCod().compareTo(p2.getTFonction().getFonCod());
		        	return n; //crs  
		        }

		    });
		//TODO faire un message d'erreur si aucune assignation est TRUE
		getListeAss().clear();
		getListeAss().addAll(listeTAssignation);
		return listeTAssignation;
	}
	
	/*public void setPrivileges(TOperateur operateur) {
		hmPrivileges.clear();
		for(TAssignation ass: operateur.getTAssignations()){
			hmPrivileges.put( ass.getTFonction().getTTypeFonction().getTyfCod(), new ArrayList<TTypefonctionaction>(ass.getTFonction().getTTypeFonction().getTTypefonctionactions()) );// privileges of the TYPE FONCTION
			//hmPrivileges.put( ass.getTFonction().getFonCod(), new ArrayList<TTypefonctionaction>(ass.getTFonction().getTTypefonctionactions()) );// privileges of the FONCTION
		}
	}
	
	public TFonction getTFonction(TOperateur operateur){
		//setTOperateurs(operateur);
		TFonction f = new TFonction();
		for(TAssignation ass: operateur.getTAssignations()){
			if(ass.getAssStatut()==true){
				setTFonctions(ass.getTFonction());
				f = ass.getTFonction();	
			}
		}
		return f;
	}*/
	
	public TMotdepasse getMotPasse(TOperateur operateur){
		TMotdepasse m = new TMotdepasse();
		for(TMotdepasse mdp: operateur.getTMotdepasses()){
			if(mdp.getMdpStatut()==true){
				setTMotdepasses(mdp);
			m = mdp;	
			}
		}
		return m;
	}
	
	
	public AutorityClass cleanAutority(){
		AutorityClass autority = new AutorityClass();
		setAutoritys(autority);
		return autority;
	}
	
	
	public AutorityClass getAutorisation(AutorityClass autority, TTypeFonction typeFonction){
		getModule(autority,typeFonction);
		getTraitement(autority,typeFonction);
		getAction(autority,typeFonction);
		
		setAutoritys(autority);
		return autority;
	}

public void getModule(AutorityClass autority, TTypeFonction typeFonction){
	//AutorityModule module = new AutorityModule();
	switch (typeFonction.getTyfCod()) {
	case "ADM":
		autority.getModules().setMenuADM(true);
		autority.getModules().setMenuMAJ(false);
		autority.getModules().setMenuGRF(false);
		autority.getModules().setMenuPRD(false);
		autority.getModules().setMenuAVG(false);
		autority.getModules().setMenuSGC(false);
		
		break;
	
	case "MAJ":
		autority.getModules().setMenuADM(false);
		autority.getModules().setMenuMAJ(true);
		autority.getModules().setMenuGRF(false);
		autority.getModules().setMenuPRD(false);
		autority.getModules().setMenuAVG(false);
		autority.getModules().setMenuSGC(false);
		break;
		
	case "GRF":
		autority.getModules().setMenuADM(false);
		autority.getModules().setMenuMAJ(false);
		autority.getModules().setMenuGRF(true);
		autority.getModules().setMenuPRD(false);
		autority.getModules().setMenuAVG(false);
		autority.getModules().setMenuSGC(false);
		break;
		
	case "PRD":
		autority.getModules().setMenuADM(false);
		autority.getModules().setMenuMAJ(false);
		autority.getModules().setMenuGRF(false);
		autority.getModules().setMenuPRD(true);
		autority.getModules().setMenuAVG(false);
		autority.getModules().setMenuSGC(false);
		break;

	case "AVS":
		autority.getModules().setMenuADM(true);
		autority.getModules().setMenuMAJ(false);
		autority.getModules().setMenuGRF(false);
		autority.getModules().setMenuPRD(false);
		autority.getModules().setMenuAVG(true);
		autority.getModules().setMenuSGC(false);
		break;
	case "SGC":
		autority.getModules().setMenuADM(false);
		autority.getModules().setMenuMAJ(false);
		autority.getModules().setMenuGRF(false);
		autority.getModules().setMenuPRD(false);
		autority.getModules().setMenuAVG(false);
		autority.getModules().setMenuSGC(true);
		break;
	default:
		autority.getModules().setMenuADM(false);
		autority.getModules().setMenuMAJ(false);
		autority.getModules().setMenuGRF(false);
		autority.getModules().setMenuPRD(false);
		autority.getModules().setMenuAVG(false);
		autority.getModules().setMenuSGC(false);
		break;
	}
	
		//return autority;
	}

public AutorityTraitement getTraitement(AutorityClass autority, TTypeFonction typeFonction){
	AutorityTraitement traitement = new AutorityTraitement();
		
	
		return traitement;
	}

public AutorityAction getAction(AutorityClass autority, TTypeFonction typeFonction){
	AutorityAction action = new AutorityAction();
		
	
		return action;
	}

	public TOperateur getTOperateur() {
		return operateur;
	}

	public void setTOperateur(TOperateur operateur) {
		this.operateur = operateur;
	}

	public TMotdepasse getTMotdepasses() {
		return motdepasses;
	}

	public void setTMotdepasses(TMotdepasse motdepasses) {
		this.motdepasses = motdepasses;
	}

	public TFonction getTFonctions() {
		return fonctions;
	}

	public void setTFonctions(TFonction fonctions) {
		this.fonctions = fonctions;
	}

	public Date getDateCons() {
		return dateCons;
	}

	public void setDateCons(Date dateCons) {
		this.dateCons = dateCons;
	}

	public AutorityClass getAutoritys() {
		return autoritys;
	}

	public void setAutoritys(AutorityClass autoritys) {
		this.autoritys = autoritys;
	}

	public List<TAssignation> getListeAss() {
		return listeAss;
	}

	public void setListeAss(List<TAssignation> listeAss) {
		this.listeAss = listeAss;
	}

//	public HashMap<String, List<TTypefonctionaction>> getHmPrivileges() {
//		return hmPrivileges;
//	}
//
//	public void setHmPrivileges(HashMap<String, List<TTypefonctionaction>> hmPrivileges) {
//		this.hmPrivileges = hmPrivileges;
//	}
//
//	public List<SysTraitement> getMenus() {
//		return menus;
//	}
//
//	public void setMenus(List<SysTraitement> menus) {
//		this.menus =  menus;
//	}
//	

	
}
