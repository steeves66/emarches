package com.sndi.controller.admin;

import java.awt.print.Printable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.sndi.model.TBailleur;
import com.sndi.model.TModePassation;
import com.sndi.model.TModeleDacType;
import com.sndi.model.TOperateur;
import com.sndi.model.TTypeMarche;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;

import lombok.Data;


@Component
@Scope(value="session")
@Data
public class ModelDacTypeController<slctdTb> {
	
	Logger _logger = Logger.getLogger(ModelDacTypeController.class);
	@Autowired
	Iservice iservice;
	
	@Autowired
	KeyGen keyGen;
	
	@Autowired
	UserController userController;
	
	@Autowired
	ConstantService constantService;
	
	private List<TModeleDacType> listeModel = new ArrayList<TModeleDacType>();
	private List<TModePassation> listeModeP = new ArrayList<TModePassation>();
	private List<TBailleur> listeBailleur = new ArrayList<TBailleur>();
	private List<VTypeMarcheFils> listeMarche = new ArrayList<VTypeMarcheFils>();
	private List<String> modeDePassation = new ArrayList<String>();
	private List<String> typeDeMarche = new ArrayList<String>();
	private TModeleDacType slctdTb = new TModeleDacType();
	private TModePassation passation = new TModePassation();
	private String chaine="";
	private String addBlock;
	private String modePassation;
	private String typeMarche;
	private String marche;
	private String bail;
	private String bailleur;
	private String bailleurExiste="none";
	private String codeEngr;
	private String codeTest;
	
	public void chargeData() {
		
		listeModel.clear();
		listeModeP.clear();
		listeBailleur.clear();
		listeModel=iservice.getObjectsByColumn("TModeleDacType", new ArrayList<String>(Arrays.asList("mdtCode")));
		listeModeP=iservice.getObjectsByColumn("TModePassation", new ArrayList<String>(Arrays.asList("mopCode")));
		listeBailleur=iservice.getObjectsByColumn("TBailleur", new ArrayList<String>(Arrays.asList("baiCode")));
	}
	
	@PostConstruct
	public void postConstru() {	
		chargeData();
	}
	
	 public void checkBailleur() {
		 
		 if(bail.equals("-B-")) {
			 bailleurExiste="block";
			 codeTest="none";
		 }else {
			 if(bail.equals("-N-")) {
				 bailleurExiste="none";
				 codeTest="block";
			 }
			 
		 }

	 }

	public void chargeMarche() {
		
		if(typeMarche.equals("11")){
		listeMarche=iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")),
				new WhereClause("TYM_CODE",WhereClause.Comparateur.EQ,typeMarche));
		}else{
			
			listeMarche=iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")),
					new WhereClause("TYM_CODE",WhereClause.Comparateur.LIKE,typeMarche+"%"),
					new WhereClause("TYM_CODE",WhereClause.Comparateur.NEQ,"11"));
		}
	}
	
	public void chargeMarchUp() {

			String check=slctdTb.getMdtCode().substring(3);
			TBailleur slct = new TBailleur();
			ArrayList<TBailleur> lBailleur = new ArrayList<TBailleur>();
			lBailleur=(ArrayList<TBailleur>) iservice.getObjectsByColumn("TBailleur", new ArrayList<String>(Arrays.asList("baiCode")),
					new WhereClause("BAI_CODE",WhereClause.Comparateur.EQ,check));
			if(lBailleur.isEmpty()) {
				bail="-N-";
			}else {
				slct=lBailleur.get(0);
				bail="-B-";
				bailleur=slct.getBaiCode();
			}

		typeMarche=slctdTb.getMdtTymCode();
		if(typeMarche.equals("11")){
			listeMarche=iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")),
					new WhereClause("TYM_CODE",WhereClause.Comparateur.EQ,typeMarche));
			}else{
				
				listeMarche=iservice.getObjectsByColumn("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")),
						new WhereClause("TYM_CODE",WhereClause.Comparateur.LIKE,typeMarche+"%"),
						new WhereClause("TYM_CODE",WhereClause.Comparateur.NEQ,"11"));
			}
		System.out.println(slctdTb.getMdtTymCode());	
	}
	 
	 
	public String renderPage(String value) throws IOException{
	    switch(value) {
	    
		case "mdl1":
			//chargeData();
			userController.renderPage(value);

		case "mdl2":
			userController.renderPage(value);
			break;

		case "mdl3":
			chargeMarchUp();
			userController.renderPage(value);
			break;
			
		default:
			userController.renderPage(value);
	    
	    }
	    return userController.renderPage(value);
	    
	}
		
	public void chaineConstr() {
		chaine="";
		if(bail.equals("-B-")){ 
			chaine=bail+bailleur+"-";
			switch (typeMarche) {
				case "0":
					codeEngr="BF";
				break;
				case "2":
					codeEngr="BT";
				break;
				case "1":
					codeEngr="BPC";
				break;
				case "11":
					codeEngr="BP";
				break;
				}
			
			}else {
				chaine=bail;
			}
		chaineModePassation();
		chaineTypeMarche();
		chaine=chaine+modePassation+addBlock;
		System.out.println(chaine);	
		
		
	}
	
	public void chaineModePassation() {
		modePassation="";
		if(modeDePassation.isEmpty()!=true) {
			 for (int i = 0; i < modeDePassation.size(); i++) {
				 modePassation=modePassation+modeDePassation.get(i)+"-";
			      System.out.println(modePassation);
			    }
			
		}else {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, " Aucun mode choisit", ""));
		}
		modeDePassation.clear();
	}
	
	public void chaineTypeMarche() {
		addBlock="";
		marche="";
		if(typeDeMarche.isEmpty()!=true) {
			 for (int i = 0; i < typeDeMarche.size(); i++) {
				 addBlock=addBlock+typeDeMarche.get(i)+"-";
			      System.out.println(addBlock);
			    }
			
		}else {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, " Aucun mode choisit", ""));
		}
		typeDeMarche.clear();
		//marche=addBlock;
	}
	
	//Méthode CRUD
		@Transactional
		public void create() throws IOException{
			if(bail.equals("-B-")){
				slctdTb.setMdtCode(codeEngr+"-"+bailleur);
			}
			
			if(!(null == slctdTb.getMdtCode() || "".equals(slctdTb.getMdtCode()))) {
				ArrayList<TTypeMarche> lMarche = new ArrayList<TTypeMarche>();
				TTypeMarche slct = new TTypeMarche();
				lMarche =(ArrayList<TTypeMarche>) iservice.getObjectsByColumn("TTypeMarche", new ArrayList<String>(Arrays.asList("tymCode")),
						new WhereClause("TYM_CODE",WhereClause.Comparateur.EQ,typeMarche));
				slct = lMarche.get(0);
				slctdTb.setTOperateur(""+userController.getSlctd().getTOperateur().getOpeMatricule());
				slctdTb.setMdtDacTypeChain(chaine);
				slctdTb.setMdtTymCode(typeMarche);
				slctdTb.setMdtLibelleCourt(slct.getTymLibelleLong());
				slctdTb.setMdtDteSaisi(new Date());
				iservice.addObject(slctdTb);
				listeModel.add(0, slctdTb);
				//chargeTypeData();
					
					FacesContext.getCurrentInstance().addMessage("",
							new FacesMessage(FacesMessage.SEVERITY_INFO, " Type modèle DAC enrégistré ! ", ""));	
					userController.renderPage("mdl1");
			}else {
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_WARN, " Champs non renseignés ! ", ""));		
			}
			
			
		}
		
		private void setMdtLibelleCourt(String tymLibelleLong) {
			// TODO Auto-generated method stub
			
		}

		@Transactional
		public void update(){
			int index = listeModel.indexOf(slctdTb);
			slctdTb.setMdtDacTypeChain(chaine);
			iservice.updateObject(slctdTb);
			listeModel.set(index, slctdTb);
			//chargeTypeData();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Type Fonction mis à jour ! ", "")); 
		}

}
