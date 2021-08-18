package com.sndi.controller.admin;

import lombok.Data;

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

import com.sndi.dao.WhereClause;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TOperateur;
import com.sndi.model.TStatut;
import com.sndi.model.TStructure;
import com.sndi.model.TTypeMarche;
import com.sndi.model.VAvisAppelOffre;
import com.sndi.model.VDacliste;
import com.sndi.model.VPpmliste;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
@Data
public class ChangeStatutController {
	
	Logger _logger = Logger.getLogger(ChangeStatutController.class);
	@Autowired
	Iservice iservice;
	
	@Autowired
	KeyGen keyGen;
	
	@Autowired
	UserController userController;
	
	@Autowired
	ConstantService constantService;
	
	private List<VPpmliste> listePpm = new ArrayList<VPpmliste>();
	private List<VDacliste> listeDac = new ArrayList<VDacliste>();
	private List<TStructure> listeStruc = new ArrayList<TStructure>();
	private List<TStatut> listeStatut = new ArrayList<TStatut>();
	
	private VPpmliste ppm = new VPpmliste();
	private TDetailPlanPassation slctdPpm = new TDetailPlanPassation();
	private VDacliste mixDacAao = new VDacliste();
	private TDacSpecs dac = new TDacSpecs();
	private TAvisAppelOffre aao = new TAvisAppelOffre();
	private TStructure struct = new TStructure();
	private TStatut statut = new TStatut();
	
	private String OpeMat;
	private String operateur;
	private String structure;
	private String strucCode;
	private String choixOpe;
	private String affDial;
	private String affForm;
	private String affValue;
	private String ppmFrm="none";
	private String dacFrm="none";
	private String aaoFrm="none";
	
	public void chargeData() {
		recupActeur();
		chargeStructure();
	}
	
	@PostConstruct
	public void postConstru() {	
		chargeData();
	}
	
	public String renderPage(String value) throws IOException{
	    switch(value) {
	    
		case "chs1":
			//chargeData();
			userController.renderPage(value);
			break;

		default:
			userController.renderPage(value);
	    
	    }
	    return userController.renderPage(value);
	    
	}
	
	public void recupActeur() {
		OpeMat = ""+userController.getSlctd().getTOperateur().getOpeMatricule();
		TOperateur ListeOp=(TOperateur) iservice.getObjectsByColumn("TOperateur", new ArrayList<String>(Arrays.asList("opeMatricule")),
				new WhereClause("OPE_MATRICULE",WhereClause.Comparateur.EQ,OpeMat)).get(0);
		operateur=ListeOp.getOpeNom();
		structure=ListeOp.getTStructure().getStrLibelleLong();
	}
	
	public void operationListe() {
		switch(choixOpe) {
		
		case "ppm":
			listePpm=iservice.getObjectsByColumn("VPpmliste", new WhereClause("DPP_STR_CODE",WhereClause.Comparateur.EQ,struct.getStrCode()),
					new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="ppmDlg";
			affForm="dlogPpm";
			listeStatut=iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,"S%"));
			ppmFrm="block";
			dacFrm="none";
			aaoFrm="none";
		break;
		case "dac":
			listeDac=iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("dacCode")),
					new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,struct.getStrCode()),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="dacDlg";
			affForm="dlogDAC";
			listeStatut=iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,"D%"));
			ppmFrm="none";
			dacFrm="block";
			aaoFrm="none";
		break;
		case "aao":
			listeDac=iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("aaoCode")),
					new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,struct.getStrCode()),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="aaoDlg";
			affForm="dlogAaao";
			listeStatut=iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,"D%"),
					new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NOTL,"S%"),
					new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NOTL,"D%"));
			ppmFrm="none";
			dacFrm="none";
			aaoFrm="block";
		break;		

		}
	}
	
	public void recupChoix() {
		System.out.println(choixOpe);
		switch(choixOpe) {
		
		case "ppm":
			affValue=ppm.getDppId()+" : "+ppm.getDppObjet();
			slctdPpm=(TDetailPlanPassation) iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",WhereClause.Comparateur.EQ, String.valueOf(ppm.getDppId())),
					new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NEQ,"SDS")).get(0);
		break;
		case "dac":
			affValue=mixDacAao.getDacCode()+" : "+mixDacAao.getDacObjet();
			dac=(TDacSpecs) iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,mixDacAao.getDacCode()),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.NEQ,"SDS")).get(0);
		break;
		case "aao":
			affValue=mixDacAao.getAaoCode()+" : "+mixDacAao.getAaoLibelle();
			aao=(TAvisAppelOffre) iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,mixDacAao.getAaoCode()),
					new WhereClause("AAO_STA_CODE",WhereClause.Comparateur.NEQ,"SDS")).get(0);
		break;	
		}
		
	}
	
	public void chargeStructure() {
		listeStruc=(List<TStructure>)iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("strCode")));
	}
	
	public void update() {
		System.out.println(statut.getStaCode()+" : "+statut.getStaLibelleLong());
		System.out.println(choixOpe);
		switch(choixOpe) {

		case "ppm":
			slctdPpm.setTStatut(statut);
			iservice.updateObject(slctdPpm);
			break;
		case "dac":
			dac.setTStatut(statut);
			iservice.updateObject(dac);
			break;
		case "aao":
			aao.setTStatut(statut);
			iservice.updateObject(aao);
			break;	
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Opération mise à jour ! ", "")); 
		System.out.println(statut.getStaCode()+" : "+statut.getStaLibelleLong());
	}

}
