package com.sndi.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
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

import com.sndi.security.UserController;
import com.sndi.service.ConstantService;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;
import com.sndi.dao.WhereClause;
import com.sndi.model.TAttributions;
import com.sndi.model.TSoumissions;
import com.sndi.model.TLotAao;

import lombok.Data;

@Component
@Scope(value="session")
@Data
public class ModifAttribController {

	Logger _logger = Logger.getLogger(ChangeStatutController.class);
	@Autowired
	Iservice iservice;
	
	@Autowired
	KeyGen keyGen;
	
	@Autowired
	UserController userController;
	
	@Autowired
	ConstantService constantService;
	
	private List<TAttributions> listAttribution = new ArrayList<TAttributions>();
	private TAttributions slctdTb = new TAttributions();
	
	private BigDecimal montantAttrib= BigDecimal.ZERO;
	private String critere="";
	private String entreprise="";
	private String lotAtt="";
	
	@PostConstruct
	public void postConstru() {	
		chargeData();
	}
	
	public void chargeData() {
		listAttribution = iservice.getObjectsByColumn("TAttributions", new ArrayList<String>(Arrays.asList("attNum")),
				new WhereClause("ATT_STA_CODE",WhereClause.Comparateur.EQ,"ATS"));
	}
	
	public void chargeDataFiltre() {
		
		if(critere.equalsIgnoreCase("")) {
			chargeData();
		}else {
			if(!(critere.equalsIgnoreCase(""))){
				listAttribution = iservice.getObjectsByColumn("TAttributions", new ArrayList<String>(Arrays.asList("attNum")),
						new WhereClause("ATT_STA_CODE",WhereClause.Comparateur.EQ,"ATS"),
						new WhereClause("ATT_DAC_CODE",WhereClause.Comparateur.LIKE,"%"+critere+"%"));
				if(listAttribution.isEmpty()) {
					listAttribution = iservice.getObjectsByColumn("TAttributions", new ArrayList<String>(Arrays.asList("attNum")),
							new WhereClause("ATT_STA_CODE",WhereClause.Comparateur.EQ,"ATS"),
							new WhereClause("ATT_DOF_AAO_CODE",WhereClause.Comparateur.LIKE,"%"+critere+"%"));
					if(listAttribution.isEmpty()) {
						listAttribution = iservice.getObjectsByColumn("TAttributions", new ArrayList<String>(Arrays.asList("attNum")),
								new WhereClause("ATT_STA_CODE",WhereClause.Comparateur.EQ,"ATS"),
								new WhereClause("ATT_SOU_NCC",WhereClause.Comparateur.LIKE,"%"+critere+"%"));
					}
				}
			}
		}
	}
	
	public void infoAttrib() {
		
		TSoumissions sou = (TSoumissions) iservice.getObjectsByColumn("TSoumissions", new ArrayList<String>(Arrays.asList("souNcc")),
				new WhereClause("SOU_NCC",WhereClause.Comparateur.EQ,slctdTb.getAttSouNcc())).get(0);
		entreprise=sou.getSouNcc()+" : "+sou.getSouSigleSte()+" - "+sou.getSouNomCom();
		
		TLotAao lot = (TLotAao) iservice.getObjectsByColumn("TLotAao", new ArrayList<String>(Arrays.asList("laaId")),
				new WhereClause("LAA_ID",WhereClause.Comparateur.EQ,""+slctdTb.getAttLaaId().longValue())).get(0);
		lotAtt = "Lot n°"+lot.getLaaNum()+" : "+lot.getLaaObjet();
	}
	
	public void update() {
		
		//slctdTb.setAttMtAttr(montantAttrib);
		iservice.updateObject(slctdTb);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO," Montant attribué mis  jour ! ", "")); 
		System.out.println(slctdTb.getAttNum()+" : "+slctdTb.getAttDofAaoCode()+" : "+slctdTb.getAttSouNcc()+" : "+slctdTb.getAttMtAttr()+" F CFA");
	}
	
	public String renderPage(String value) throws IOException{
	    switch(value) {
	    
		case "mat":
			//chargeData();
			userController.renderPage(value);
			break;
			
		default:
			userController.renderPage(value);
	    
	    }
	    return userController.renderPage(value);
	    
	}
}
