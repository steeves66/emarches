package com.sndi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sndi.model.TBailleur;
import com.sndi.model.TBanques;
import com.sndi.model.TContenuAgpm;
import com.sndi.model.TDevise;
import com.sndi.model.TGestion;
import com.sndi.model.TMinistere;
import com.sndi.model.TModePassation;
import com.sndi.model.TSoumissions;
import com.sndi.model.TSourceFinancement;
import com.sndi.model.TStatut;
import com.sndi.model.TStructure;
import com.sndi.model.TTypeMarche;
import com.sndi.model.TTypePieceOffre;
import com.sndi.model.VDatePub;
import com.sndi.model.VModePassation;
import com.sndi.model.VModePassationPn;
import com.sndi.model.VTypeMarcheFils;
import com.sndi.model.VTypeStructConduc;
import com.sndi.model.VbPaysReference;


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
	
	private List<VTypeMarcheFils> listeTypeMarchesFils = new ArrayList<VTypeMarcheFils>();
	private Map<String, VTypeMarcheFils> HM_TYPE_MARCHE_FILS = new HashMap<String, VTypeMarcheFils>();
	
	private List<TModePassation> listeModePassation = new ArrayList<TModePassation>();
	private Map<String, TModePassation> HM_TYPE_MODE_PASSATION = new HashMap<String, TModePassation>();
	
	private List<VModePassationPn> listeModePassationPn = new ArrayList<VModePassationPn>();
	private Map<String, VModePassationPn> HM_TYPE_MODE_PASSATION_PN = new HashMap<String, VModePassationPn>();
	
	private List<VModePassation> listeMode = new ArrayList<VModePassation>();
	private Map<String, VModePassation> HM_TYPE_VMODE_PASSATION = new HashMap<String, VModePassation>();
	
	private List<TStructure> listeStructures = new ArrayList<TStructure>();
	private Map<String, TStructure> HM_STEUCTURE= new HashMap<String, TStructure>(); 
	
	private List<TTypePieceOffre> listePiecesOffres = new ArrayList<TTypePieceOffre>();
	private Map<String, TTypePieceOffre> HM_PIECES_OFFRES= new HashMap<String, TTypePieceOffre>();
	
	private List<VTypeStructConduc> listeTypStruConduc = new ArrayList<VTypeStructConduc>();
	private Map<String, VTypeStructConduc> HM_TYPE_STRUC_CONDUC= new HashMap<String, VTypeStructConduc>();
	
	private List<VbPaysReference> listePays = new ArrayList<VbPaysReference>();
	private Map<String, VbPaysReference> HM_LISTE_PAYS= new HashMap<String, VbPaysReference>();
	
	private List<VDatePub> listeDatePub = new ArrayList<VDatePub>(); 
	private Map<String, VDatePub> HM_LISTE_DATE_PUB= new HashMap<String, VDatePub>();
	
	private List<TSoumissions> listSoumission = new ArrayList<TSoumissions>(); 
	private Map<String, TSoumissions> HM_LISTE_SOUMISSIONS= new HashMap<String, TSoumissions>();
	
	private List<TBanques> listBanque = new ArrayList<TBanques>(); 
	private Map<String, TBanques> HM_LISTE_BANQUES= new HashMap<String, TBanques>();
	
	//chargePiecesOffres()
	
	

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
		 chargeTGestionTable();
		 chargeTContenuAgpmTable();
		 chargeTTypeMarcheTable();
		 chargeTModePassationTable();
		 chargeTStructureTable();
		 chargeTTypeMarcheFilsTable();
		 chargeTModePassationPnTable();
		 chargeVModePassationTable();
		 chargePiecesOffresTable();
		 chargeTypeStructureTable();
		 chargePaysTable();
		chargeDatepubTable();
		chargeDataBanqueTable();
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
					_logger.info("HM_GESTION.size :"+ HM_GESTION.size());	
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
					_logger.info("HM_TYPE_MARCHE.size :"+ HM_TYPE_MARCHE.size());	
				}
				
				public TTypeMarche getTTypeMarche(String TYM_CODE){
					return HM_TYPE_MARCHE.get(TYM_CODE);
				}
				
				
				//TTYPE_MARCHE_FILS
				public void chargeTTypeMarcheFilsTable(){
					listeTypeMarches.clear();
					listeTypeMarchesFils=(List<VTypeMarcheFils>) iservice.getObjectsByColumnDesc("VTypeMarcheFils", new ArrayList<String>(Arrays.asList("tymCode")));	
					HashMap<String, VTypeMarcheFils> aMap = new HashMap<String, VTypeMarcheFils>();
					for (VTypeMarcheFils st: listeTypeMarchesFils) {
						aMap.put(""+st.getTymCode(), st);
					}
					HM_TYPE_MARCHE_FILS =  Collections.unmodifiableMap(aMap);	
					_logger.info("HM_TYPE_MARCHE_FILS :"+ HM_TYPE_MARCHE_FILS.size());	
				}
				
				public VTypeMarcheFils getVTypeMarcheFils(String TYM_CODE){
					return HM_TYPE_MARCHE_FILS.get(TYM_CODE);
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
					_logger.info("HM_TYPE_MODE_PASSATION.size :"+ HM_TYPE_MODE_PASSATION.size());	
				}
				
				public TModePassation getTTModePassation(String MOP_CODE){
					return HM_TYPE_MODE_PASSATION.get(MOP_CODE);
				}
				
				//MODE_PASSATION_PROCEDURE_NORMALE
				public void chargeTModePassationPnTable(){
					listeModePassationPn.clear();
					listeModePassationPn =(List<VModePassationPn>) iservice.getObjectsByColumn("VModePassationPn", new ArrayList<String>(Arrays.asList("mopCode")));
					HashMap<String, VModePassationPn> aMap = new HashMap<String, VModePassationPn>();
					for (VModePassationPn st: listeModePassationPn) {
						aMap.put(""+st.getMopCode(), st);
					}
					HM_TYPE_MODE_PASSATION_PN =  Collections.unmodifiableMap(aMap);	
					_logger.info("HM_TYPE_MODE_PASSATION_PN.size :"+ HM_TYPE_MODE_PASSATION_PN.size());	
				}
				
				public VModePassationPn getVModePassationPn(String MOP_CODE){
					return HM_TYPE_MODE_PASSATION_PN.get(MOP_CODE);
				}
				
				//V_MODE_PASSATION
				public void chargeVModePassationTable(){
					listeMode.clear();
					listeMode =(List<VModePassation>) iservice.getObjectsByColumn("VModePassation", new ArrayList<String>(Arrays.asList("mopCode")));
					HashMap<String, VModePassation> aMap = new HashMap<String, VModePassation>();
					for (VModePassation st: listeMode) {
						aMap.put(""+st.getMopCode(), st);
					}
					HM_TYPE_VMODE_PASSATION =  Collections.unmodifiableMap(aMap);	
					_logger.info("HM_TYPE_VMODE_PASSATION.size :"+ HM_TYPE_VMODE_PASSATION.size());	
				}
				
				public VModePassation getVModePassation(String MOP_CODE){
					return HM_TYPE_VMODE_PASSATION.get(MOP_CODE);
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
					_logger.info("HM_STEUCTURE.size :"+ HM_STEUCTURE.size());	
				}
				
				public TStructure getTStructure(String STR_CODE){
					return HM_STEUCTURE.get(STR_CODE);
				}
				
			//LISTE PIECES OFFRES
			public void chargePiecesOffresTable(){
					listePiecesOffres.clear();
					listePiecesOffres =(List<TTypePieceOffre>) iservice.getObjectsByColumn("TTypePieceOffre", new ArrayList<String>(Arrays.asList("TPO_LIBELLE")));
					HashMap<String, TTypePieceOffre> aMap = new HashMap<String, TTypePieceOffre>();
					for (TTypePieceOffre of: listePiecesOffres) {
						aMap.put(""+of.getTpoCode(), of);
					}
					HM_PIECES_OFFRES =  Collections.unmodifiableMap(aMap);	
					_logger.info("HM_PIECES_OFFRES.size :"+ HM_PIECES_OFFRES.size());	
				}
				
				public TTypePieceOffre getTTypePieceOffre(String TOP_CODE){
					return HM_PIECES_OFFRES.get(TOP_CODE);
				}
				
				
				//LISTE DES TYPES DE STRUCTURES CONDUCTRICES
				public void chargeTypeStructureTable(){
					listeTypStruConduc.clear();
					listeTypStruConduc =(List<VTypeStructConduc>) iservice.getObjectsByColumn("VTypeStructConduc", new ArrayList<String>(Arrays.asList("CODE")));
						HashMap<String, VTypeStructConduc> aMap = new HashMap<String, VTypeStructConduc>();
						for (VTypeStructConduc of: listeTypStruConduc) {
							aMap.put(""+of.getCode(), of);
						}
						HM_TYPE_STRUC_CONDUC =  Collections.unmodifiableMap(aMap);	
						_logger.info("HM_TYPE_STRUC_CONDUC.size :"+ HM_TYPE_STRUC_CONDUC.size());	
					}
					
					public VTypeStructConduc getListeTypStruConduc(String CODE){
						return HM_TYPE_STRUC_CONDUC.get(CODE);
					}
					
					
					//LISTE DES PAYS
					public void chargePaysTable(){
						listePays.clear();
						listePays=(List<VbPaysReference>) iservice.getObjectsNotIn("VbPaysReference", new ArrayList<String>(Arrays.asList("REP_CODE")),
		        				"REP_CODE", new ArrayList<String>(Arrays.asList("CIV")));
							HashMap<String, VbPaysReference> aMap = new HashMap<String, VbPaysReference>();
							for (VbPaysReference pa: listePays) {
								aMap.put(""+pa.getRepCode(), pa);
							}
							HM_LISTE_PAYS =  Collections.unmodifiableMap(aMap);	
							_logger.info("HM_LISTE_PAYS.size :"+ HM_LISTE_PAYS.size());
					        	
					        }
						
						public VbPaysReference getListePays(String REP_CODE){
							return HM_LISTE_PAYS.get(REP_CODE);
						}
						
						
						
						//LISTE DES DATES DE PUBLICATION
						public void chargeDatepubTable(){
							listeDatePub.clear();
							listeDatePub =(List<VDatePub>) iservice.getObjectsByColumn("VDatePub", new ArrayList<String>(Arrays.asList("DATEPUB")));
								HashMap<String, VDatePub> aMap = new HashMap<String, VDatePub>();
								for (VDatePub da: listeDatePub) {
									aMap.put(""+da.getDatepub(), da);
								}
								HM_LISTE_DATE_PUB =  Collections.unmodifiableMap(aMap);	
								_logger.info("HM_LISTE_DATE_PUB .size :"+ HM_LISTE_DATE_PUB.size());	
							}
							
							public VDatePub getListeDatePub(String DATE_PUB){
								return HM_LISTE_DATE_PUB.get(DATE_PUB);
							}
							
							
							

							//LISTE DES SOUMISSIONNAIRES
							public void chargeDataSoumissions(){
								listSoumission.clear();
							    listSoumission =(List<TSoumissions>) iservice.getObjectsByColumn("TSoumissions", new ArrayList<String>(Arrays.asList("SOU_NCC")));
									HashMap<String, TSoumissions> aMap = new HashMap<String, TSoumissions>();
									for (TSoumissions sm: listSoumission) {
										aMap.put(""+sm.getSouNcc(), sm);
									}
									HM_LISTE_SOUMISSIONS =  Collections.unmodifiableMap(aMap);	
									_logger.info("HM_LISTE_SOUMISSIONS.size :"+ HM_LISTE_SOUMISSIONS.size());	
								}
								
								public TSoumissions geTSoumissions(String SOU_NCC){
									return HM_LISTE_SOUMISSIONS.get(SOU_NCC);
							}
								
							
								//LISTE DES BANQUES
								public void chargeDataBanqueTable(){
									listBanque.clear();
									listBanque =(List<TBanques>) iservice.getObjectsByColumn("TBanques", new ArrayList<String>(Arrays.asList("BAN_LIBELLE")));
										HashMap<String, TBanques> aMap = new HashMap<String, TBanques>();
										for (TBanques bm: listBanque) {
											aMap.put(""+bm.getBanCode(), bm);
										}
										HM_LISTE_BANQUES =  Collections.unmodifiableMap(aMap);	
										_logger.info("HM_LISTE_BANQUES.size :"+ HM_LISTE_BANQUES.size());	
									}
									
									public TBanques geTBanques(String BAN_CODE){
										return HM_LISTE_BANQUES.get(BAN_CODE);
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
	
	public List<VTypeMarcheFils> getListeTypeMarchesFils() {
		return listeTypeMarchesFils;
	}
	public void setListeTypeMarchesFils(List<VTypeMarcheFils> listeTypeMarchesFils) {
		this.listeTypeMarchesFils = listeTypeMarchesFils;
	}
	public Map<String, VTypeMarcheFils> getHM_TYPE_MARCHE_FILS() {
		return HM_TYPE_MARCHE_FILS;
	}
	public void setHM_TYPE_MARCHE_FILS(Map<String, VTypeMarcheFils> hM_TYPE_MARCHE_FILS) {
		HM_TYPE_MARCHE_FILS = hM_TYPE_MARCHE_FILS;
	}
	public List<VModePassationPn> getListeModePassationPn() {
		return listeModePassationPn;
	}
	public void setListeModePassationPn(List<VModePassationPn> listeModePassationPn) {
		this.listeModePassationPn = listeModePassationPn;
	}
	public Map<String, VModePassationPn> getHM_TYPE_MODE_PASSATION_PN() {
		return HM_TYPE_MODE_PASSATION_PN;
	}
	public void setHM_TYPE_MODE_PASSATION_PN(Map<String, VModePassationPn> hM_TYPE_MODE_PASSATION_PN) {
		HM_TYPE_MODE_PASSATION_PN = hM_TYPE_MODE_PASSATION_PN;
	}
	public List<VModePassation> getListeMode() {
		return listeMode;
	}
	public void setListeMode(List<VModePassation> listeMode) {
		this.listeMode = listeMode;
	}
	public Map<String, VModePassation> getHM_TYPE_VMODE_PASSATION() {
		return HM_TYPE_VMODE_PASSATION;
	}
	public void setHM_TYPE_VMODE_PASSATION(Map<String, VModePassation> hM_TYPE_VMODE_PASSATION) {
		HM_TYPE_VMODE_PASSATION = hM_TYPE_VMODE_PASSATION;
	}
	public List<TTypePieceOffre> getListePiecesOffres() {
		return listePiecesOffres;
	}
	public void setListePiecesOffres(List<TTypePieceOffre> listePiecesOffres) {
		this.listePiecesOffres = listePiecesOffres;
	}
	public Map<String, TTypePieceOffre> getHM_PIECES_OFFRES() {
		return HM_PIECES_OFFRES;
	}
	public void setHM_PIECES_OFFRES(Map<String, TTypePieceOffre> hM_PIECES_OFFRES) {
		HM_PIECES_OFFRES = hM_PIECES_OFFRES;
	}
	public List<VTypeStructConduc> getListeTypStruConduc() {
		return listeTypStruConduc;
	}
	public void setListeTypStruConduc(List<VTypeStructConduc> listeTypStruConduc) {
		this.listeTypStruConduc = listeTypStruConduc;
	}
	public Map<String, VTypeStructConduc> getHM_TYPE_STRUC_CONDUC() {
		return HM_TYPE_STRUC_CONDUC;
	}
	public void setHM_TYPE_STRUC_CONDUC(Map<String, VTypeStructConduc> hM_TYPE_STRUC_CONDUC) {
		HM_TYPE_STRUC_CONDUC = hM_TYPE_STRUC_CONDUC;
	}
	public List<VbPaysReference> getListePays() {
		return listePays;
	}
	public void setListePays(List<VbPaysReference> listePays) {
		this.listePays = listePays;
	}
	public Map<String, VbPaysReference> getHM_LISTE_PAYS() {
		return HM_LISTE_PAYS;
	}
	public void setHM_LISTE_PAYS(Map<String, VbPaysReference> hM_LISTE_PAYS) {
		HM_LISTE_PAYS = hM_LISTE_PAYS;
	}
	public List<VDatePub> getListeDatePub() {
		return listeDatePub;
	}
	public void setListeDatePub(List<VDatePub> listeDatePub) {
		this.listeDatePub = listeDatePub;
	}
	public Map<String, VDatePub> getHM_LISTE_DATE_PUB() {
		return HM_LISTE_DATE_PUB;
	}
	public void setHM_LISTE_DATE_PUB(Map<String, VDatePub> hM_LISTE_DATE_PUB) {
		HM_LISTE_DATE_PUB = hM_LISTE_DATE_PUB;
	}
	public List<TSoumissions> getListSoumission() {
		return listSoumission;
	}
	public void setListSoumission(List<TSoumissions> listSoumission) {
		this.listSoumission = listSoumission;
	}
	public Map<String, TSoumissions> getHM_LISTE_SOUMISSIONS() {
		return HM_LISTE_SOUMISSIONS;
	}
	public void setHM_LISTE_SOUMISSIONS(Map<String, TSoumissions> hM_LISTE_SOUMISSIONS) {
		HM_LISTE_SOUMISSIONS = hM_LISTE_SOUMISSIONS;
	}
	public List<TBanques> getListBanque() {
		return listBanque;
	}
	public void setListBanque(List<TBanques> listBanque) {
		this.listBanque = listBanque;
	}
	public Map<String, TBanques> getHM_LISTE_BANQUES() {
		return HM_LISTE_BANQUES;
	}
	public void setHM_LISTE_BANQUES(Map<String, TBanques> hM_LISTE_BANQUES) {
		HM_LISTE_BANQUES = hM_LISTE_BANQUES;
	}
	
}
