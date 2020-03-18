/*package com.sndi.controller.typeFonctions;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.primefaces.component.selectmanycheckbox.SelectManyCheckbox;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//import com.sndi.controller.fonctions.FonctionsFilter;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TFonction;
import com.sndi.model.SysAction;
import com.sndi.model.SysTraitement;
import com.sndi.model.TTypeFonction;
import com.sndi.model.TTypefonctionaction;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.GRFProperties;


@Component
@Scope(value="session")

public class TypeFonctionsController implements Serializable{
	Logger _logger = Logger.getLogger(TypeFonctionsController.class);
	@Autowired
	Iservice iservice;

	@Autowired
	UserController userController;
	//variables for indexFonctions
	private List<TTypeFonction> objetListe = new ArrayList<TTypeFonction>();
	private List<TTypeFonction> currentTyfListe = new ArrayList<TTypeFonction>();
	
	private TTypeFonction selectedTyf = new TTypeFonction();
	private TypeFonctionsFilter tyfFilter = new TypeFonctionsFilter();
	
	//Variables for nouveauTTypeFonction
	private TTypeFonction newTyf = new TTypeFonction();
	private List<SysTraitement> modules = new ArrayList<SysTraitement>();
	private List<SysAction> actions = new ArrayList<SysAction>();
	//private ActionsPickList actions = new ActionsPickList();
    
	private String sltdModule = "";
	private List<String> sltdActions = new ArrayList<String>();
	//private HashMap <String, List<TTypefonctionaction>> hmPrivileges = new HashMap <String , List<TTypefonctionaction>>(); //key: modCod current selected typefonctionactions
	//private HashMap <String, TTypefonctionaction> hmPrivilegesInit = new HashMap <String , TTypefonctionaction>(); //key: modCod initially saved typefonctionactions 
	private List<TypefonctionactionWrapper> hmPrivilegesInit2 = new ArrayList<TypefonctionactionWrapper>(); //key: modCod initially saved typefonctionactions 
	private List<TypefonctionactionWrapper> actionToSave = new ArrayList<TypefonctionactionWrapper>(); //List of typefonctionactions saved
	private List<TypefonctionactionWrapper> actionToDelete = new ArrayList<TypefonctionactionWrapper>(); //List of previously saved typefonctionactions that need to be removed
	
	
	private Boolean alertdiv = false;
	private Boolean selectAllActions = false;
	private String slctdAct= "";
	//Variables for showTTypeFonction
	private Boolean hasFonctions = false;
	
	@PostConstruct
	public void postConstru() {	
//		chargeData();
		
	}
	
	public void chargeData(){
		objetListe.clear();
		List listTND = iservice.getObjects("TTypeFonction", new ArrayList<String>(Arrays.asList("tyfLibelle","tyfCod")));
		if(!listTND.isEmpty()){
			for (Iterator it = listTND.iterator(); it.hasNext();) {
				TTypeFonction nd = (TTypeFonction) it.next();
				objetListe.add(nd);
	
			}
		}
		
		currentTyfListe = new ArrayList<TTypeFonction>(objetListe);
		_logger.info("objetListe size: "+objetListe.size());
        vider();
	}
	
	


	public boolean checkNewTyf(){
		//TODO
		
		return true;
	}
	public boolean checkSlctdTb(){
		//TODO
		
		return true;
	}

	public void renderPage(String value) throws IOException{
		if(GRFProperties.TYF1.equals(value)){//indexFonction
			chargeData();
			tyfFilter = new TypeFonctionsFilter();
			userController.renderPage(value);
			
			
		}else if(GRFProperties.TYF2.equals(value)){//showTTypeFonction
	    	//selectedTyf.setTTypefonctionactions(new HashSet<TTypefonctionaction>());
			setHasFonctions( !( iservice.getObjectsByColumn("Fonction", new WhereClause("tyf_cod", Comparateur.EQ, selectedTyf.getTyfCod())).isEmpty()) );
	    	//_logger.info("slctdTb tyfCod:"+selectedTyf.getTyfCod()+" hasFonction: "+hasFonctions);
	    	
			//selectAllActions = false;
			//sltdActions.clear();
			//hmPrivileges.clear();
			//hmPrivilegesInit.clear();
			//hmPrivilegesInit2.clear();
			//actionToSave.clear();
			//actionToDelete.clear();
			List<TTypefonctionaction> listTND = ((List<TTypefonctionaction>) iservice.getObjectsByColumn("TTypefonctionaction", new WhereClause("tyf_cod",Comparateur.EQ,selectedTyf.getTyfCod())));
			if(!listTND.isEmpty()){
				for (Iterator<TTypefonctionaction> it = listTND.iterator(); it.hasNext();) {
					TTypefonctionaction atf = it.next();
					SysAction a = atf.getSysAction();
					
					actionToDelete.add(new TypefonctionactionWrapper(atf)); //intialisation typefonctionactions to delete
			    	_logger.info("actionToDelete add: "+a.getSyaLibelle());

					if( hmPrivileges.containsKey(a.getSysTraitement().getSytCode()) ){ // adds on the existing traitement 
						hmPrivileges.get(a.getSysTraitement().getSytCode()).add(atf);
				    	_logger.info("ajout action cod: "+atf.getSysAction().getSyaCode());

					}else{// new traitement initialisation
						List <TTypefonctionaction> atfList = new ArrayList<TTypefonctionaction>();
						atfList.add(atf);
						hmPrivileges.put(a.getSysTraitement().getSytCode(), atfList);
				    	_logger.info("Nouveau module ajout action - cod:"+atf.getSysAction().getSyaCode());
					}
				}
				//hmPrivilegesInit2 = new ArrayList<TypefonctionactionWrapper>(actionToDelete);
			}
			modules = new ArrayList<SysTraitement>( ((List<SysTraitement>) iservice.getObjects("SysTraitement", new ArrayList<String>(Arrays.asList("sytLibelle")))) );
	    	_logger.info("modules - size:"+modules.size());
	    	if(modules.size() > 0){
				sltdModule = modules.get(0).getSytCode();
				actions = new ArrayList<SysAction>( modules.get(0).getSysActions() );
				Collections.sort(actions, new Comparator<SysAction>() {
	                @Override
	                public int compare(SysAction lhs, SysAction rhs) {
	                    // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
	                    return lhs.getSyaLibelle().compareTo(rhs.getSyaLibelle()) > 0  ? 1 : (lhs.getSyaLibelle().compareTo(rhs.getSyaLibelle()) < 0 ) ? -1 : 0;

	                }
	            });
				//pré-remplir les privilèges
		    	if(hmPrivileges.containsKey(sltdModule)){
		    		for (TTypefonctionaction atf : hmPrivileges.get(sltdModule)){
		    			sltdActions.add(atf.getSysAction().getSyaCode());
		    			_logger.info("action selectionee code: "+atf.getSysAction().getSyaCode());
		    		}
		    		selectAllActions = (actions.size() == sltdActions.size()) ? true : false;
		    	}else{
		    		selectAllActions = false;
		    	}
	    	}
			userController.renderPage(value);
			
			
		}else if(GRFProperties.ASS1.equals(value)){//nouveau typeFonction
			//clear newFonc and other parameters
			newTyf = new TTypeFonction();
			selectAllActions = false;
			sltdActions.clear();
			hmPrivileges.clear();
			modules = new ArrayList<SysTraitement>( ((List<SysTraitement>) iservice.getObjects("SysTraitement", new ArrayList<String>(Arrays.asList("sytLibelle")))) );
	    	_logger.info("modules - size:"+modules.size());
	    	if(modules.size() > 0){
				sltdModule = modules.get(0).getSytCode();
				actions = new ArrayList<SysAction>( modules.get(0).getSysActions() );
		    	//pList.setSource( new ArrayList<Action>(modules.get(0).getActions()) );
	    	}

			setNewTyf(new TTypeFonction());
			userController.renderPage(value);
    		_logger.info("Renderpage - nouveauTTypeFonction");
			
		}else{//default		
			userController.renderPage(value);
		}
	}
	
	public Boolean hasFonctions(String tyfCod){
		return ((List<TFonction>) iservice.getObjectsByColumn("TFonction", new WhereClause("tyf_cod",Comparateur.EQ,tyfCod))).isEmpty();
	}
    
	//Méthode CRUD
	@Transactional
	public void creerNouveauTypeFonction(){
//TODO
		try {
			if(checkNewTyf()){
				//newFonc.setEmpDateCreation(Calendar.getInstance().getTime());
				//newTyf.setTyfDateCreation(Calendar.getInstance().getTime());
				iservice.addObject(getNewTyf());
				//TODO 
				List <TTypefonctionaction> atfList = new ArrayList <TTypefonctionaction>();
				for(String modCod : hmPrivileges.keySet()){
					atfList.addAll( hmPrivileges.get(modCod) );
				}
				for (TTypefonctionaction atf: atfList){
//					atf.setTTypeFonction(newTyf);
					iservice.addObject(atf);
				}
				renderPage("tyf3");
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Type fonction créée ! ", ""));
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void modifierTypeFonction(){
		//TODO
		try {
			if(checkSlctdTb()){
				//TODO 
				iservice.updateObject(getSelectedTyf());
    			_logger.info("Type fonction mis a jour: "+selectedTyf.getTyfCod());
    			
				//List <TTypefonctionactionWrapper> atfList = new ArrayList <TTypefonctionactionWrapper>();
				for(String modCod : hmPrivileges.keySet()){
					for(TTypefonctionaction atf : hmPrivileges.get(modCod)){
						atf.setTTypeFonction(getSelectedTyf());
						actionToSave.add(new TypefonctionactionWrapper(atf));
					}					
//					atfList.addAll(  );
				}
				actionToDelete.removeAll(actionToSave); //remove all action to save in actionToDelete
    			_logger.info("actionToDelete size: "+actionToDelete.size());
    			
    			for(TypefonctionactionWrapper aftw :actionToSave){//insert the new sysactions
	    			_logger.info("hmPrivilegesInit2.contains(aftw): "+hmPrivilegesInit2.contains(aftw));

    				//if( !hmPrivilegesInit.containsKey(aftw.getItem().getSysAction().getSyaCode()) ){
    				if( !hmPrivilegesInit2.contains(aftw) ){
    					iservice.addObject(aftw.getItem());
    	    			_logger.info("insert action: "+aftw.getItem().getSysAction().getSyaCode());
    				}
    			}
    			for(TypefonctionactionWrapper aftw :actionToDelete){//remove the previously saved sysactions
					iservice.deleteObject(aftw.getItem());
	    			_logger.info("delete action: "+aftw.getItem().getSysAction().getSyaCode());

    			}
				
//				for (TTypefonctionaction atf: atfList){
////					atf.setTTypeFonction(newTyf);
//					_logger.info("actions inseree: "+atf.getSysAction().getSyaLibelle());
//					iservice.persist(atf);
//					_logger.info("actions inseree fin: "+atf.getTfaId());
//				}

//				selectedTyf.setTTypefonctionactions( new HashSet<TTypefonctionaction>(atfList));
//    			_logger.info("actions a update size: "+selectedTyf.getTTypefonctionactions().size());
//				iservice.updateObject(getSelectedTyf());
				renderPage("tyf2");//TODO mettre en variable globale
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Type fonction modifiée ! ", ""));

			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void desactiver(){
		//TODO
	}
	
	public void reinitialiser(){
		try {
			setSelectedTyf( (TTypeFonction) iservice.getObjectById(selectedTyf.getTyfCod(), "TTypeFonction"));
			renderPage("tyf2");
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Valeurs réintitalisées ! ", ""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void vider(){
		TTypeFonction tyf = new TTypeFonction ();
		setSelectedTyf(tyf);
		
		setNewTyf(new TTypeFonction());
	}

	public List<TTypeFonction> getCurrentTyfListe() {
		return currentTyfListe;
	}

	public void setCurrentTyfListe(List<TTypeFonction> currentTyfListe) {
		this.currentTyfListe = currentTyfListe;
	}


	public TypeFonctionsFilter getTyfFilter() {
		return tyfFilter;
	}

	public void setTyfFilter(TypeFonctionsFilter tyfFilter) {
		this.tyfFilter = tyfFilter;
	}


	public TTypeFonction getSelectedTyf() {
		return selectedTyf;
	}

	public void setSelectedTyf(TTypeFonction selectedTyf) {
		_logger.info("SetSeclected: ");

		this.selectedTyf = selectedTyf;
	}

	public TTypeFonction getNewTyf() {
		return newTyf;
	}

	public void setNewTyf(TTypeFonction newTyf) {
		this.newTyf = newTyf;
	}
	
	
	
	//	public String getAlertdiv() {
	//	return alertdiv;
	//}
	//
	//public void setAlertdiv(String alertdiv) {
	//	this.alertdiv = alertdiv;
	//}
	
	public List<SysTraitement> getModules() {
		return modules;
	}

	public void setModules(List<SysTraitement> modules) {
		this.modules = modules;
	}

	public Boolean getAlertdiv() {
		return alertdiv;
	}
	
	public String getSlctdAct() {
		return slctdAct;
	}

	public void setSlctdAct(String slctdAct) {
		this.slctdAct = slctdAct;
	}

	public void setAlertdiv(Boolean alertdiv) {
		this.alertdiv = alertdiv;
	}
	
	
	//	public ActionsPickList getActions() {
//		return actions;
//	}
//
//	public void setActions(ActionsPickList actions) {
//		this.actions = actions;
//	}
//
//	public void loadActions(Module module, String mode){
//	_logger.info("Module selectione code: "+module.getModCod());
//	//TODO mettre le module actions
//	actions = new ActionsPickList( new ArrayList<Action>(module.getActions()), new ArrayList<Action>() );
//
//}
	

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
	
	public List<SysAction> getActions() {
		return actions;
	}
	public void setActions(List<SysAction> actions) {
		this.actions = actions;
	}
		
	 public Boolean getSelectAllActions() {
		return selectAllActions;
	}

	public void setSelectAllActions(Boolean selectAllActions) {
		this.selectAllActions = selectAllActions;
	}

	public Boolean getHasFonctions() {
		return hasFonctions;
	}

	public void setHasFonctions(Boolean hasFonctions) {
		this.hasFonctions = hasFonctions;
	}
	
	public void onSelectAction() {
		selectAllActions = (actions.size() == sltdActions.size()) ? true : false;
	}
	
	public void onSelectAllActions() {
		sltdActions.clear();
		if(selectAllActions){
		    for (int i = 0; i < actions.size(); i++) {
		    	sltdActions.add(actions.get(i).getSyaCode());
			} 
		}//else add lockedAction
	 }
	
	public void changeFilter() {
        currentTyfListe= getFilteredTypeFonctions(tyfFilter);
		_logger.info("filter change: "+ tyfFilter.getTousChamps());

    }
    
    public List<TTypeFonction> getFilteredTypeFonctions(TypeFonctionsFilter filter){
        List<TTypeFonction> someTTypeFonctions = new ArrayList<TTypeFonction>();
        String searchField = filter.getTousChamps().toLowerCase();
//	      String prenom = filter.getPrenom().toLowerCase();

 
    	for (Iterator<TTypeFonction> i = objetListe.iterator(); i.hasNext();) {
    		TTypeFonction tmp = i.next();
            if (tmp.getTyfLibelle().toLowerCase().contains(searchField) || tmp.getTyfCod().toLowerCase().contains(searchField) ){
            	someTTypeFonctions.add(tmp);
            }
        }
		_logger.info("someTTypeFonctions size : "+someTTypeFonctions.size()+" keyword:"+searchField);

        return someTTypeFonctions;
    }

	
	public void loadActions(){
		_logger.info("Module selectione code: "+sltdModule);
		//TODO mettre le module actions
		sltdActions.clear();
	    int i=-1;
		while ( ++i<modules.size() && !sltdModule.equals(modules.get(i).getSytCode()) );
		//We don't need to check if we're out of bounds
		actions = new ArrayList<SysAction>(modules.get(i).getSysActions());
		Collections.sort(actions, new Comparator<SysAction>() {
            @Override
            public int compare(SysAction lhs, SysAction rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.getSyaLibelle().compareTo(rhs.getSyaLibelle()) > 0  ? 1 : (lhs.getSyaLibelle().compareTo(rhs.getSyaLibelle()) < 0 ) ? -1 : 0;

            }
        });
		if(hmPrivileges.containsKey(sltdModule)){
			for (TTypefonctionaction atf : hmPrivileges.get(sltdModule)){
				sltdActions.add(atf.getSysAction().getSyaCode());
				_logger.info("action selectionee code: "+atf.getSysAction().getSyaCode());
			}
			selectAllActions = (actions.size() == sltdActions.size()) ? true : false;
		}else{
			selectAllActions = false;
		}
	
	}
	
	public void validerPrivileges(){
		_logger.info("Module selectione code: "+sltdModule);
//		List <TTypefonctionaction> tmpAtfList = new ArrayList <TTypefonctionaction>();
//		List <TTypefonctionaction> tmpAtfListToDelete = (hmPrivileges.get(sltdModule)== null)? new ArrayList <TTypefonctionaction>( ) :  new ArrayList <TTypefonctionaction>( hmPrivileges.get(sltdModule) );
//		TTypefonctionaction tmpAtf = new TTypefonctionaction();
//		for(int i=0; i<sltdActions.size(); i++){
//			tmpAtf = new TTypefonctionaction();
//		    int j=-1;
//			while ( ++j<actions.size() && !sltdActions.get(i).equals(actions.get(j).getSyaCode()) );
//			tmpAtf.setSysAction(actions.get(j));
//			tmpAtf.setTTypeFonction(newTyf); //TODO on doit faire en insertion en base
//			tmpAtfList.add( tmpAtf );
//			 _logger.info("privilege accorde: "+tmpAtf.getSysAction().getSyaCode());
//
//		}
//		for(int i=0; i<tmpAtfListToDelete.size(); i++){
//			 _logger.info("tmpAtfListToDelete action: "+tmpAtfListToDelete.get(i).getSysAction().getSyaCode());
//		}
//		for(int i=0; i<sltdActions.size(); i++){
//			 _logger.info("tmpAtfList action: "+tmpAtfList.get(i).getSysAction().getSyaCode());
//		}
//
//		 _logger.info("tmpAtfListToDelete size: "+tmpAtfListToDelete.size());
//		tmpAtfListToDelete.removeAll(tmpAtfList); // update the deleted list
//		 _logger.info("tmpAtfListToDelete after: "+tmpAtfListToDelete.size());
//
//		for(TTypefonctionaction tfa: tmpAtfListToDelete){
//			 hmActionToDelete.put( tfa.getSysAction().getSyaCode(), tfa );
//			 _logger.info("hmActionToDelete.put: "+tfa.getSysAction().getSyaCode());
//		}
//		_logger.info("hmActionToDelete size: "+hmActionToDelete.size());
//		
//		hmPrivileges.put(sltdModule, tmpAtfList); //update the selected values
//		_logger.info("hmPrivileges module:"+sltdModule+" size: "+hmPrivileges.get(sltdModule).size());
		
		List <TTypefonctionaction> tmpAtfList = new ArrayList <TTypefonctionaction>();
		
		TTypefonctionaction tmpAtf = new TTypefonctionaction();
		for(int i=0; i<sltdActions.size(); i++){
			tmpAtf = new TTypefonctionaction();
		    int j=-1;
			while ( ++j<actions.size() && !sltdActions.get(i).equals(actions.get(j).getSyaCode()) );
			tmpAtf.setSysAction(actions.get(j));
			tmpAtf.setTTypeFonction(newTyf); //TODO on doit faire en insertion en base
			tmpAtfList.add( tmpAtf );
			 _logger.info("privilege accorde: "+tmpAtf.getSysAction().getSyaCode());

		}
		
		hmPrivileges.put(sltdModule, tmpAtfList); //update the selected values
		_logger.info("hmPrivileges module:"+sltdModule+" size: "+hmPrivileges.get(sltdModule).size());
		
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Privilèges enregistrés ! ", ""));

	}
	
}*/