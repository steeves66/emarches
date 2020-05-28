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
import com.sndi.model.TContenuAgpm;
import com.sndi.model.TDevise;
import com.sndi.model.TGestion;
import com.sndi.model.TMinistere;
import com.sndi.model.TModePassation;
import com.sndi.model.TSourceFinancement;
import com.sndi.model.TStatut;
import com.sndi.model.TStructure;
import com.sndi.model.TTypeMarche;


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
	
	private List<TContenuAgpm> listeContenu = new ArrayList<TContenuAgpm>();
	private Map<String, TContenuAgpm> HM_CONTENU = new HashMap<String, TContenuAgpm>();
	
	private List<TGestion> listeGestion = new ArrayList<TGestion>();
	private Map<String, TGestion> HM_GESTION = new HashMap<String, TGestion>();
	
	private List<TTypeMarche> listeTypeMarches = new ArrayList<TTypeMarche>();
	private Map<String, TTypeMarche> HM_TYPE_MARCHE = new HashMap<String, TTypeMarche>();
	
	private List<TModePassation> listeModePassation = new ArrayList<TModePassation>();
	private Map<String, TModePassation> HM_TYPE_MODE_PASSATION = new HashMap<String, TModePassation>();
	
	private List<TStructure> listeStructures = new ArrayList<TStructure>();
	private Map<String, TStructure> HM_STEUCTURE= new HashMap<String, TStructure>();
	
	
	
	

	//---- FIN VARIABLES GLOBALES ----//
	@PostConstruct
	public void initClass(){
		chargeConstanteTable();
	}
	 /**
     * Constante des entit�s.
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
		 chargeTGestionTable();
		 chargeTContenuAgpmTable();
		 chargeTTypeMarcheTable();
		 chargeTModePassationTable();
		 chargeTStructureTable();
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
	
	public TBailleur getTBailleur(String baiCode){
		return HM_BAILLEURS.get(baiCode);
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
		
		public TDevise getTDevise(String devCode){
			return HM_DEVISE.get(devCode);
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
				
				public TSourceFinancement getTSourceFinancement(String souCode){
					return HM_SOURCE_FINACEMENT.get(souCode);
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
				
				public TMinistere getTMinistere(String minCode){
					return HM_MINISTERE.get(minCode);
				}
			
//Contenu Agpm
				
				public void chargeTContenuAgpmTable(){
					listeContenu.clear();
					listeContenu =  iservice.getObjects("TContenuAgpm", new ArrayList<String>(Arrays.asList("TCA_CODE")));
					HashMap<String, TContenuAgpm> aMap = new HashMap<String, TContenuAgpm>();
					for (TContenuAgpm st: listeContenu) {
						aMap.put(""+st.getTcaCode(), st);
					}
					HM_CONTENU =  Collections.unmodifiableMap(aMap);	
					_logger.info("HM_CONTENU.size :"+ HM_CONTENU.size());	
				}
				
				public TContenuAgpm getTContenuAgpm(String tca_code){
					return HM_CONTENU.get(tca_code);
				}
				
		//GESTION
				public void chargeTGestionTable(){
					 listeGestion=(List<TGestion>) iservice.getObjectsByColumnDesc("TGestion", new ArrayList<String>(Arrays.asList("GES_CODE")));	
					HashMap<String, TGestion> aMap = new HashMap<String, TGestion>();
					for (TGestion st: listeGestion) {
						aMap.put(""+st.getGesCode(), st);
					}
					HM_GESTION =  Collections.unmodifiableMap(aMap);	
					_logger.info("V.size :"+ HM_GESTION.size());	
				}
				
				public TGestion getTGestion(String GES_CODE){
					return HM_GESTION.get(GES_CODE);
				}
				
		//TTYPE_MARCHE
				public void chargeTTypeMarcheTable(){
					 listeTypeMarches.clear();
					listeTypeMarches=(List<TTypeMarche>) iservice.getObjectsByColumnDesc("TTypeMarche", new ArrayList<String>(Arrays.asList("tymCode")));	
					HashMap<String, TTypeMarche> aMap = new HashMap<String, TTypeMarche>();
					for (TTypeMarche st: listeTypeMarches) {
						aMap.put(""+st.getTymCode(), st);
					}
					HM_TYPE_MARCHE =  Collections.unmodifiableMap(aMap);	
					_logger.info("V.size :"+ HM_TYPE_MARCHE.size());	
				}
				
				public TTypeMarche getTTypeMarche(String TYM_CODE){
					return HM_TYPE_MARCHE.get(TYM_CODE);
				}
				
		//MODE_PASSATION
				public void chargeTModePassationTable(){
					listeModePassation.clear();
					listeModePassation =(List<TModePassation>) iservice.getObjectsByColumn("TModePassation", new ArrayList<String>(Arrays.asList("mopCode")));
					HashMap<String, TModePassation> aMap = new HashMap<String, TModePassation>();
					for (TModePassation st: listeModePassation) {
						aMap.put(""+st.getMopCode(), st);
					}
					HM_TYPE_MODE_PASSATION =  Collections.unmodifiableMap(aMap);	
					_logger.info("V.size :"+ HM_TYPE_MODE_PASSATION.size());	
				}
				
				public TModePassation getTTModePassation(String MOP_CODE){
					return HM_TYPE_MODE_PASSATION.get(MOP_CODE);
				}
				
				//STRUCURE
				public void chargeTStructureTable(){
					listeStructures.clear();
					listeStructures =(List<TStructure>) iservice.getObjectsByColumn("TStructure", new ArrayList<String>(Arrays.asList("STR_CODE")));
					HashMap<String, TStructure> aMap = new HashMap<String, TStructure>();
					for (TStructure st: listeStructures) {
						aMap.put(""+st.getStrCode(), st);
					}
					HM_STEUCTURE =  Collections.unmodifiableMap(aMap);	
					_logger.info("V.size :"+ HM_STEUCTURE.size());	
				}
				
				public TStructure getTStructure(String STR_CODE){
					return HM_STEUCTURE.get(STR_CODE);
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
	public List<TContenuAgpm> getListeContenu() {
		return listeContenu;
	}
	public void setListeContenu(List<TContenuAgpm> listeContenu) {
		this.listeContenu = listeContenu;
	}
	public Map<String, TContenuAgpm> getHM_CONTENU() {
		return HM_CONTENU;
	}
	public void setHM_CONTENU(Map<String, TContenuAgpm> hM_CONTENU) {
		HM_CONTENU = hM_CONTENU;
	}
	public Map<String, TMinistere> getHM_MINISTERE() {
		return HM_MINISTERE;
	}
	public void setHM_MINISTERE(Map<String, TMinistere> hM_MINISTERE) {
		HM_MINISTERE = hM_MINISTERE;
	}
	public List<TMinistere> getListeMinistere() {
		return listeMinistere;
	}
	public void setListeMinistere(List<TMinistere> listeMinistere) {
		this.listeMinistere = listeMinistere;
	}
	public List<TGestion> getListeGestion() {
		return listeGestion;
	}
	public void setListeGestion(List<TGestion> listeGestion) {
		this.listeGestion = listeGestion;
	}
	public Map<String, TGestion> getHM_GESTION() {
		return HM_GESTION;
	}
	public void setHM_GESTION(Map<String, TGestion> hM_GESTION) {
		HM_GESTION = hM_GESTION;
	}
	public List<TTypeMarche> getListeTypeMarches() {
		return listeTypeMarches;
	}
	public void setListeTypeMarches(List<TTypeMarche> listeTypeMarches) {
		this.listeTypeMarches = listeTypeMarches;
	}
	public Map<String, TTypeMarche> getHM_TYPE_MARCHE() {
		return HM_TYPE_MARCHE;
	}
	public void setHM_TYPE_MARCHE(Map<String, TTypeMarche> hM_TYPE_MARCHE) {
		HM_TYPE_MARCHE = hM_TYPE_MARCHE;
	}
	public List<TModePassation> getListeModePassation() {
		return listeModePassation;
	}
	public void setListeModePassation(List<TModePassation> listeModePassation) {
		this.listeModePassation = listeModePassation;
	}
	public Map<String, TModePassation> getHM_TYPE_MODE_PASSATION() {
		return HM_TYPE_MODE_PASSATION;
	}
	public void setHM_TYPE_MODE_PASSATION(Map<String, TModePassation> hM_TYPE_MODE_PASSATION) {
		HM_TYPE_MODE_PASSATION = hM_TYPE_MODE_PASSATION;
	}
	public List<TStructure> getListeStructures() {
		return listeStructures;
	}
	public void setListeStructures(List<TStructure> listeStructures) {
		this.listeStructures = listeStructures;
	}
	public Map<String, TStructure> getHM_STEUCTURE() {
		return HM_STEUCTURE;
	}
	public void setHM_STEUCTURE(Map<String, TStructure> hM_STEUCTURE) {
		HM_STEUCTURE = hM_STEUCTURE;
	}
	
	


}
