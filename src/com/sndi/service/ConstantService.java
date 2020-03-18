package com.sndi.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

//import com.sndi.model.TStatuts;

@org.springframework.stereotype.Service
public class ConstantService {
	private static Logger _logger = Logger.getLogger(ConstantService.class);
	private static ResourceBundle _properties = null;
	
	@Autowired
	Iservice iservice;
	/*private Map<String, TStatuts> HM_STATUS = new HashMap<String, TStatuts>();*/
/*	private Map<String, TBaremes> HM_BAREMES = new HashMap<String, TBaremes>();
	private Map<String, TDestinations> HM_DESTINATIONS = new HashMap<String, TDestinations>();
	private Map<String, TLigneBudgetaire> HM_LIGNE_BUDGETAIRE = new HashMap<String, TLigneBudgetaire>();
	private Map<String, TMinisteres> HM_MINISTERES = new HashMap<String, TMinisteres>();
	private Map<String, TMoyenTransports> HM_MOYEN_TRANSPORTS = new HashMap<String, TMoyenTransports>();
	private Map<String, TNatureDocuments> HM_NATURE_DOCUMENTS = new HashMap<String, TNatureDocuments>();
	private Map<String, TProfessions> HM_PROFESSIONS = new HashMap<String, TProfessions>();*/
	
	//private List<TMinisteres> minListe = new ArrayList<TMinisteres>();
	
	

	//---- FIN VARIABLES GLOBALES ----//
	@PostConstruct
	public void initClass(){
	//	chargeExo();
		chargeConstanteTable();
	}
	 /**
     * Constante des entités.
     * 
     * 
     */
	
	
	
	
	public void chargeConstanteTable(){
		 //chargeTStatutsTable();
		
	
//		private Map<String, TMoyenTransports> HM_MOYEN_TRANSPORTS = new HashMap<String, TMoyenTransports>();
//		private Map<String, TNatureDocuments> HM_NATURE_DOCUMENTS = new HashMap<String, TNatureDocuments>();
//		private Map<String, TProfessions> HM_PROFESSIONS = new HashMap<String, TProfessions>();
//	  

	}
	/*public void chargeTStatutsTable(){
		List<TStatuts> statutList =  iservice.getObjects("TStatuts");
		HashMap<String, TStatuts> aMap = new HashMap<String, TStatuts>();
		for (TStatuts st: statutList) {
			aMap.put(st.getStatutCode(), st);
		}
		HM_STATUS =  Collections.unmodifiableMap(aMap);	
		  _logger.info("HM_STATUS.size :"+ HM_STATUS.size());
	}
	
	public TStatuts getTStatuts(String code_statut){
		return HM_STATUS.get(code_statut);
	
	}*/


}
