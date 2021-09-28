package com.sndi.controller.admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAttributions;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDetCritAnalyseDac;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TFonction;
import com.sndi.model.TSoumissions;
import com.sndi.model.TStatut;
import com.sndi.model.VDacliste;
import com.sndi.model.VLot;
import com.sndi.model.VPpmliste;
import com.sndi.model.VbAttributions;
import com.sndi.model.VbStatut;
import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
@Getter @Setter
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
	private List<VbStatut> listeStatut = new ArrayList<VbStatut>();
	private List<VbAttributions> listAttribution = new ArrayList<VbAttributions>();
	
	//les objets des listes
	private VPpmliste ppm = new VPpmliste();
	private TDetailPlanPassation slctdPpm = new TDetailPlanPassation();
	private VDacliste mixDacAao = new VDacliste();
	private TDacSpecs dac = new TDacSpecs();
	private TAvisAppelOffre aao = new TAvisAppelOffre();
	private TFonction struct = new TFonction();
	private VbStatut statut = new VbStatut();
	private VbAttributions attrib = new VbAttributions();
	private VbAttributions slctdAtt = new VbAttributions();
	
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
	private String attribStatut="";
	
	public void chargeData() {
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
	
	
	public void operationListe() {
		switch(choixOpe) {
		
		case "ppm":
			listeDac=iservice.getObjectsByColumn("VDacliste", new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,""+struct.getFonCod()),
					new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="ppmDlg";
			affForm="dlogPpm";
			listeStatut=iservice.getObjectsByColumn("VbStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,"S%"));
			ppmFrm="block";
			dacFrm="none";
			aaoFrm="none";
			attFrm="none";
		break;
		case "dac":
			listeDac=iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("dacCode")),
					new WhereClause("DAC_FON_COD_AC",WhereClause.Comparateur.EQ,""+struct.getFonCod()),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="dacDlg";
			affForm="dlogDAC";
			listeStatut=iservice.getObjectsByColumn("VbStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,"D%"));
			ppmFrm="none";
			dacFrm="block";
			aaoFrm="none";
			attFrm="none";
		break;
		case "aao":
			listeDac=iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("aaoCode")),
					new WhereClause("AAO_FON_COD_AC",WhereClause.Comparateur.EQ,""+struct.getFonCod()),
					new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"));
			affDial="aaoDlg";
			affForm="dlogAaao";
			listeStatut=iservice.getObjectsByColumn("VbStatut", new WhereClause("STA_LIBELLE_LONG",WhereClause.Comparateur.LIKE,"%Offre%"));
			ppmFrm="none";
			dacFrm="none";
			aaoFrm="block";
			attFrm="none";
		break;	
		case "att":
			listAttribution=iservice.getObjectsByColumn("VbAttributions", new ArrayList<String>(Arrays.asList("attNum")),
					new WhereClause("ATT_FON_CODE_ATT",WhereClause.Comparateur.EQ,""+struct.getFonCod()),
					new WhereClause("ATT_STA_CODE",WhereClause.Comparateur.NEQ,""+"SDS"));
			affDial="attDlg";
			affForm="dlogAtt";
			listeStatut=iservice.getObjectsByColumn("VbStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.LIKE,""+"AT%"));
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
			slctdPpm=(TDetailPlanPassation) iservice.getObjectsByColumn("TDetailPlanPassation", new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+String.valueOf(mixDacAao.getDppId()))).get(0);
			System.out.println(slctdPpm.getDppId()+" - "+slctdPpm.getDppObjet());
		break;
		case "dac":
			affValue=mixDacAao.getDacCode()+" : "+mixDacAao.getDacObjet();
			List<TDacSpecs> LD  = iservice.getObjectsByColumn("TDacSpecs", new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+mixDacAao.getDacCode()));
			 if(!LD.isEmpty()) dac = LD.get(0);
			System.out.println(dac.getDacCode()+" - "+dac.getDacObjet());
		break;
		case "aao":
			affValue=mixDacAao.getAaoCode()+" : "+mixDacAao.getAaoLibelle();
			List<TAvisAppelOffre> LA  = iservice.getObjectsByColumn("TAvisAppelOffre", new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+mixDacAao.getAaoCode()));
			 if(!LA.isEmpty()) aao = LA.get(0);
			System.out.println(aao.getAaoCode()+" - "+aao.getAaoLibelle());
		break;	
		case "att":
			affValue="Attribution n"+slctdAtt.getAttNum()+" de l'appel d'offres n "+slctdAtt.getAttDofAaoCode();
			List<VbAttributions> LAT  = iservice.getObjectsByColumn("VbAttributions", new WhereClause("ATT_NUM",WhereClause.Comparateur.EQ,""+slctdAtt.getAttNum().toString()));
			 if(!LAT.isEmpty()) attrib = LAT.get(0);

			TSoumissions sou = (TSoumissions) iservice.getObjectsByColumn("TSoumissions", new WhereClause("SOU_NCC",WhereClause.Comparateur.EQ,""+attrib.getAttSouNcc())).get(0);
			etpre=sou.getSouNcc()+" - "+sou.getSouSigleDmp()+" - "+sou.getSouSigleSte();
			
			VLot avisLot = (VLot) iservice.getObjectsByColumn("VLot", new WhereClause("LAA_AAO_CODE",WhereClause.Comparateur.EQ,""+attrib.getAttDofAaoCode()),
					new WhereClause("LAA_ID",WhereClause.Comparateur.EQ,attrib.getAttLaaId().toString())).get(0);
			lot="Lot n° "+avisLot.getLaaNum()+" : "+avisLot.getLaaObjet();
			System.out.println(attrib.getAttNum()+" - "+attrib.getAttSouNcc());
		break;
		}
		System.out.println(struct.getFonCod()+" - "+struct.getFonLibelle());
	}
	
	public void chargeStructure() {
		
		if(critereRecherche.equals("")) {
			listeStruc=(List<TFonction>)iservice.getObjectsByColumn("TFonction", new ArrayList<String>(Arrays.asList("fonCod")),
					new WhereClause("FON_TYF_COD", WhereClause.Comparateur.EQ, "ACR"));
		}else {
			listeStruc=(List<TFonction>)iservice.getObjectsByColumn("TFonction", new ArrayList<String>(Arrays.asList("fonCod")),
					new WhereClause("FON_TYF_COD", WhereClause.Comparateur.EQ, "ACR"),
					new WhereClause("FON_COD", WhereClause.Comparateur.LIKE, "%"+critereRecherche.toUpperCase()+"%"));
		}
		
	}
	
	
	public void update() {
		System.out.println(statut.getStaCode()+" : "+statut.getStaLibelleLong());
		System.out.println(choixOpe);
		attribStatut=statut.getStaCode();
		TStatut choixStat =(TStatut) iservice.getObjectsByColumn("TStatut", new WhereClause("STA_CODE",WhereClause.Comparateur.EQ,attribStatut)).get(0);
		switch(choixOpe) {

		case "ppm":
			slctdPpm.setTStatut(choixStat);
			iservice.updateObject(slctdPpm);
			break;
		case "dac":
			dac.setTStatut(choixStat);
			iservice.updateObject(dac);
			break;
		case "aao":
			aao.setTStatut(choixStat);
			iservice.updateObject(aao);
			break;	
		case "att":			
			attrib.setAttStaCode(attribStatut);
			iservice.updateObject(attrib);
			break;
		}
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Opération mise  jour ! ", "")); 
		System.out.println(choixStat.getStaCode()+" : "+choixStat.getStaLibelleLong());
	}

}
