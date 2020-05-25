package com.sndi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sndi.model.TBailleur;
import com.sndi.model.TDevise;
import com.sndi.model.TMinistere;
import com.sndi.model.TSourceFinancement;
import com.sndi.model.TStatut;


@Service
public class ConstantService {
	private static Logger _logger = Logger.getLogger(ConstantService.class);
	
	@Autowired
	Iservice iservice;
	private Map<String, TStatut> HM_STATUS = new HashMap<String, TStatut>();
	
	private Map<String, TBailleur> HM_BAILLEURS = new HashMap<String, TBailleur>();
	private List<TBailleur> listeBailleurs = new ArrayList<TBailleur>();
	
	private Map<String, TDevise> HM_DEVISE = new HashMap<String, TDevise>();
	private List<TDevise> listeDevise = new ArrayList<TDevise>();
	
	private Map<String, TSourceFinancement> HM_SOURCE_FINACEMENT = new HashMap<String, TSourceFinancement>();
	private List<TSourceFinancement> listeSourceFinance = new ArrayList<TSourceFinancement>();
	
	private Map<String, TMinistere> HM_MINISTERE = new HashMap<String, TMinistere>();
	private List<TMinistere> listeMinistere = new ArrayList<TMinistere>();

	//---- FIN VARIABLES GLOBALES ----//
	@PostConstruct
	public void initClass(){
		chargeConstanteTable();
	}
	 /**
     * Constante des entités.
     * 
     * 
     */
	
	
	
	
	public void chargeConstanteTable(){
		_logger.info("----------------- debut Chargement des tables parametre--------------");
		 chargeTStatutsTable();
		 chargeTBailleurTable();
		 chargeTDeviseTable();
		 chargeTSourceFinancementTable();
		 chargeTMinitereTable();
		_logger.info("----------------- Fin Chargement des tables parametre--------------");
	}
	
	//TStatuts
	public void chargeTStatutsTable(){
		List<TStatut> statutList =  iservice.getObjects("TStatut");
		HashMap<String, TStatut> aMap = new HashMap<String, TStatut>();
		for (TStatut st: statutList) {
			aMap.put(st.getStaCode(), st);
		}
		HM_STATUS =  Collections.unmodifiableMap(aMap);	
		  _logger.info("HM_STATUS.size :"+ HM_STATUS.size());
	}
	
	public TStatut getStatut(String code_statut){
		return HM_STATUS.get(code_statut);
	
	}
	//TBailleur
	public void chargeTBailleurTable(){	
		listeBailleurs.clear();
		listeBailleurs =  iservice.getObjects("TBailleur", new ArrayList<String>(Arrays.asList("baiLibelle")));
		HashMap<String, TBailleur> aMap = new HashMap<String, TBailleur>();
		for (TBailleur st: listeBailleurs) {
			aMap.put(""+st.getBaiCode(), st);
		}
		HM_BAILLEURS =  Collections.unmodifiableMap(aMap);	
		_logger.info("HM_BAILLEURS.size :"+ HM_BAILLEURS.size());	
	}
	
	//TDevise
		public void chargeTDeviseTable(){	
			listeDevise.clear();
			listeDevise =  iservice.getObjects("TDevise", new ArrayList<String>(Arrays.asList("devCode")));
			HashMap<String, TDevise> aMap = new HashMap<String, TDevise>();
			for (TDevise st: listeDevise) {
				aMap.put(""+st.getDevCode(), st);
			}
			HM_DEVISE =  Collections.unmodifiableMap(aMap);	
			_logger.info("HM_DEVISE.size :"+ HM_DEVISE.size());	
		}
		
		//TDevise
				public void chargeTSourceFinancementTable(){
					listeSourceFinance.clear();
					listeSourceFinance =  iservice.getObjects("TSourceFinancement", new ArrayList<String>(Arrays.asList("souCode")));
					HashMap<String, TSourceFinancement> aMap = new HashMap<String, TSourceFinancement>();
					for (TSourceFinancement st: listeSourceFinance) {
						aMap.put(""+st.getSouCode(), st);
					}
					HM_SOURCE_FINACEMENT =  Collections.unmodifiableMap(aMap);	
					_logger.info("HM_SOURCE_FINACEMENT.size :"+ HM_SOURCE_FINACEMENT.size());	
				}
				
		//Ministere
				
				public void chargeTMinitereTable(){
					listeMinistere.clear();
					listeMinistere =  iservice.getObjects("TMinistere", new ArrayList<String>(Arrays.asList("minCode")));
					HashMap<String, TMinistere> aMap = new HashMap<String, TMinistere>();
					for (TMinistere st: listeMinistere) {
						aMap.put(""+st.getMinCode(), st);
					}
					HM_MINISTERE =  Collections.unmodifiableMap(aMap);	
					_logger.info("HM_MINISTERE.size :"+ HM_MINISTERE.size());	
				}
				
	
	
	public static Logger get_logger() {
		return _logger;
	}
	public static void set_logger(Logger _logger) {
		ConstantService._logger = _logger;
	}
	public Map<String, TStatut> getHM_STATUS() {
		return HM_STATUS;
	}
	public void setHM_STATUS(Map<String, TStatut> hM_STATUS) {
		HM_STATUS = hM_STATUS;
	}
	public Map<String, TBailleur> getHM_BAILLEURS() {
		return HM_BAILLEURS;
	}
	public void setHM_BAILLEURS(Map<String, TBailleur> hM_BAILLEURS) {
		HM_BAILLEURS = hM_BAILLEURS;
	}
	public List<TBailleur> getListeBailleurs() {
		return listeBailleurs;
	}
	public void setListeBailleurs(List<TBailleur> listeBailleurs) {
		this.listeBailleurs = listeBailleurs;
	}
	public Map<String, TDevise> getHM_DEVISE() {
		return HM_DEVISE;
	}
	public void setHM_DEVISE(Map<String, TDevise> hM_DEVISE) {
		HM_DEVISE = hM_DEVISE;
	}
	public List<TDevise> getListeDevise() {
		return listeDevise;
	}
	public void setListeDevise(List<TDevise> listeDevise) {
		this.listeDevise = listeDevise;
	}
	public Map<String, TSourceFinancement> getHM_SOURCE_FINACEMENT() {
		return HM_SOURCE_FINACEMENT;
	}
	public void setHM_SOURCE_FINACEMENT(Map<String, TSourceFinancement> hM_SOURCE_FINACEMENT) {
		HM_SOURCE_FINACEMENT = hM_SOURCE_FINACEMENT;
	}
	public List<TSourceFinancement> getListeSourceFinance() {
		return listeSourceFinance;
	}
	public void setListeSourceFinance(List<TSourceFinancement> listeSourceFinance) {
		this.listeSourceFinance = listeSourceFinance;
	}
	
	


}
