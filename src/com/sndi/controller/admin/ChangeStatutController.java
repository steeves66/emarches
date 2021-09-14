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
import com.sndi.model.TAttributions;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TFonction;
import com.sndi.model.TLotAao;
import com.sndi.model.TOperateur;
import com.sndi.model.TSoumissions;
import com.sndi.model.TStatut;
import com.sndi.model.TTypeMarche;
import com.sndi.model.VAvisAppelOffre;
import com.sndi.model.VDacliste;
import com.sndi.model.VLot;
import com.sndi.model.VPpmliste;
import com.sndi.model.VbAttributions;
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
	
	//les listes
	private List<VDacliste> listeDac = new ArrayList<VDacliste>();
	private List<TFonction> listeStruc = new ArrayList<TFonction>();
	private List<TStatut> listeStatut = new ArrayList<TStatut>();
	private List<VbAttributions> listAttribution = new ArrayList<VbAttributions>();
	
	//les objets des listes
	private VPpmliste ppm = new VPpmliste();
	private TDetailPlanPassation slctdPpm = new TDetailPlanPassation();
	private VDacliste mixDacAao = new VDacliste();
	private TDacSpecs dac = new TDacSpecs();
	private TAvisAppelOffre aao = new TAvisAppelOffre();
	private TFonction struct = new TFonction();
	private TStatut statut = new TStatut();
	private TAttributions attrib = new TAttributions();
	private VbAttributions slctdAtt = new VbAttributions();
	
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
	private String attFrm="none";
	private String critereRecherche="";
	private String lot="";
	private String etpre="";
	
	public void chargeData() {
		recupActeur();
		//chargeStructure();
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
			listeDac=iservice.getObjectsByColumn("VDacliste", new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,struct.getFonCod()),
					new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="ppmDlg";
			affForm="dlogPpm";
			listeStatut=iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,"S%"));
			ppmFrm="block";
			dacFrm="none";
			aaoFrm="none";
			attFrm="none";
		break;
		case "dac":
			listeDac=iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("dacCode")),
					new WhereClause("DAC_FON_COD_AC",WhereClause.Comparateur.EQ,struct.getFonCod()),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="dacDlg";
			affForm="dlogDAC";
			listeStatut=iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,"D%"));
			ppmFrm="none";
			dacFrm="block";
			aaoFrm="none";
			attFrm="none";
		break;
		case "aao":
			listeDac=iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("aaoCode")),
					new WhereClause("AAO_FON_COD_AC",WhereClause.Comparateur.EQ,struct.getFonCod()),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="aaoDlg";
			affForm="dlogAaao";
			listeStatut=iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,"D%"),
					new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NOTL,"S%"),
					new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NOTL,"D%"));
			ppmFrm="none";
			dacFrm="none";
			aaoFrm="block";
			attFrm="none";
		break;	
		case "att":
			listAttribution=iservice.getObjectsByColumn("VbAttributions", new ArrayList<String>(Arrays.asList("attNum")),
					new WhereClause("ATT_FON_CODE_ATT",WhereClause.Comparateur.EQ,struct.getFonCod()),
					new WhereClause("ATT_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="attDlg";
			affForm="dlogAtt";
			listeStatut=iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,"AT%"));
			ppmFrm="none";
			dacFrm="none";
			aaoFrm="none";
			attFrm="block";
		break;

		}
	}
	
	public void recupChoix() {
		System.out.println(choixOpe);
		switch(choixOpe) {
		
		case "ppm":
			affValue=mixDacAao.getDppId()+" : "+mixDacAao.getDppObjet();
			slctdPpm=(TDetailPlanPassation) iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",WhereClause.Comparateur.EQ, String.valueOf(mixDacAao.getDppId())),
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
		case "att":
			affValue="Attribution n"+slctdAtt.getAttNum()+" de l'appel d'offres n "+slctdAtt.getAttDofAaoCode();
			attrib=(TAttributions) iservice.getObjectsByColumn("TAttributions", new WhereClause("ATT_NUM",WhereClause.Comparateur.EQ,slctdAtt.getAttNum().toString()),
					new WhereClause("ATT_STA_CODE",WhereClause.Comparateur.NEQ,"SDS")).get(0);

			TSoumissions sou = (TSoumissions) iservice.getObjectsByColumn("TSoumissions", new WhereClause("SOU_NCC",WhereClause.Comparateur.EQ,attrib.getAttSouNcc())).get(0);
			etpre=sou.getSouNcc()+" - "+sou.getSouSigleDmp()+" - "+sou.getSouSigleSte();
			
			VLot avisLot = (VLot) iservice.getObjectsByColumn("VLot", new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,attrib.getAttDofAaoCode()),
					new WhereClause("LAA_ID",WhereClause.Comparateur.EQ,attrib.getAttLaaId().toString())).get(0);
			lot="Lot n "+avisLot.getLaaNum()+" : "+avisLot.getLaaObjet();
		break;
		}
		System.out.println(struct.getFonCod()+" - "+struct.getFonLibelle());
	}
	
	public void chargeStructure() {
		
		viderDonnees();
		if(critereRecherche.equals("")) {
			listeStruc=(List<TFonction>)iservice.getObjectsByColumn("TFonction", new ArrayList<String>(Arrays.asList("fonCod")),
					new WhereClause("FON_TYF_COD", WhereClause.Comparateur.EQ, "ACR"));
		}else {
			listeStruc=(List<TFonction>)iservice.getObjectsByColumn("TFonction", new ArrayList<String>(Arrays.asList("fonCod")),
					new WhereClause("FON_TYF_COD", WhereClause.Comparateur.EQ, "ACR"),
					new WhereClause("FON_COD", WhereClause.Comparateur.LIKE, "%"+critereRecherche.toUpperCase()+"%"));
		}
		
	}
	
	public void viderDonnees() {

		ppm = new VPpmliste();
		slctdPpm = new TDetailPlanPassation();
		mixDacAao = new VDacliste();
		dac = new TDacSpecs();
		aao = new TAvisAppelOffre();
		statut = new TStatut();
		attrib = new TAttributions();
		slctdAtt = new VbAttributions();
		affValue="";
		choixOpe="";
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
		case "att":
			attrib.setAttStaCode(statut.getStaCode());
			iservice.updateObject(attrib);
			break;
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Opration mise  jour ! ", "")); 
		System.out.println(statut.getStaCode()+" : "+statut.getStaLibelleLong());
	}

}
