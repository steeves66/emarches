 package com.sndi.dao;

import java.io.IOException;
import java.util.List;

import com.sndi.model.TOperateur;


public interface IDao {
	
	/**
	 * Add Object
	 * 
	 * @param  Object Object
	 */
	public void addObject(Object object);
	
	/**
	 * persist Object
	 * 
	 * @param  Object Object
	 */
	public void persist(Object object);
	
	/**
	 * Update Object
	 * 
	 * @param  Object Object
	 */
	public void updateObject(Object object);
	
	/**
	 * Merge Object
	 * 
	 * @param  Object Object
	 */
	public void mergeObject(Object object);
	
	/**
	 * Delete Object
	 * 
	 * @param  Object Object
	 */
	public void deleteObject(Object object);
	
	/**
	 * Get Object
	 * 
	 * @param  int Object Id
	 */
	public Object getFonctionStatutPosition(String fonction_code, String action);
	public Object getObjectById(int id, String objet);
	
	public Object getObjectById(String id, String objet);
	
	public Object getObjectById(String id, Object objet);
	
	/**
	 * Get Object List
	 * 
	 */
	public List<Object> getObjects(Object object);
	
	/**
	 * Get Object List lazy EAGER
	 * 
	 */
	public List<Object> getObjectLasy(Object object, Class businessInterface);
	
	public List<Object> getObjectLasy(String object, Class businessInterface);
	
	/**
	 * Get Object List
	 */
	public List getObjects(String objet);
	public List getObjects(String objet, List<String> columnList);
	public List getObjectsByColumnIn(String object,String inCondition,  List<String> inList, WhereClause ... conditions);
	public List getObjectsNotIn(String objet, List<String> columnList, String notCondition,  List<String> notList);
	public List getObjectsIn(String objet, List<String> columnList, String inCondition,  List<String> inList);
	//public List getObjectsByColumnNotQuoteDesc(String objet,  List<WhereClause>conditionList, List<String> columnList);
	public List getObjectsByColumnInNotQuote(String objet,String inCondition, List<String> inList, List<WhereClause>conditionList, List<String> columnList);
	public int countTableByColumn(String tableName,String conditionColumn, List<WhereClause>conditionList);
	public int countTableByColumnIn(String tableName,String conditionColumn, List<WhereClause>conditionList,  List<String> columnList, String inCondition,  List<String> inList);
	public List getObjectsByColumn(String objet,  List<WhereClause>conditionList);
	public List getObjectsByColumnDesc(String objet, List<WhereClause> conditionList, List<String> columnList);
	public List getObjectsByColumn(String objet,  List<WhereClause>conditionList, List<String> columnList);
	public List getObjectsByColumnNotQuote(String objet,  List<WhereClause>conditionList, List<String> columnList);
	public List getObjectsByColumnnNotIn(String objet,  List<WhereClause>conditionList, List<String> columnList, String notCondition,  List<String> notList);
	public List getObjectsByColumnnIn(String objet,  List<WhereClause>conditionList, List<String> columnList, String inCondition,  List<String> inList);
	public TOperateur getUser(String login);
	public List getObjectsByColumnnInDesc(String objet,  List<WhereClause>conditionList, List<String> columnList, String inCondition,  List<String> inList);
	public String getCodeTable(String pseudo, int tailleChar, int tailleNumber,
			String tableName, String column);

	public String getCodeDossier(String inc, int tailleChar, int size,
			String T_DOSSIERS, String DOS_CODE);

	public List getObjectByColumnInInstr(String objet, String strSource) ;//getObjectByColumnInInstr(String objet,String typePlan ,String strSource);
	public List getObjectByColumnInInstrAmi(String objet,String strSource); //List getObjectByColumnInInstrAmi(String objet,String typePlan, String strSource);
	public List getObjectByColumnInInstrPrq(String objet,String strSource); //public List getObjectByColumnInInstrPrq(String objet,String typePlan,String strSource);
	public List getObjectByColumnInPubCsvInstr(String objet,String stat1,String stat2,String typePlan,String strSource);
	//public List getObjectByColumnInPublicationCsvInstr(String objet,String strSource);
	public List getObjectByColumnInPublicationCsvInstr(String objet,String stat,String strSource);
	public List getObjectByColumnInPublicationRechercheCsvInstr(String objet,String critere,String strSource);
	public List getObjectByColumnInPublicationRechercheStatutMoisCsvInstr(String objet,String stat,String critere,String strSource);
	public List getObjectByColumnInPublicationRechercheStatutCsvInstr(String objet,String stat,String strSource);
	public List getObjectByColumnInPublicationRechercheMoisCsvInstr(String objet,String mois,String strSource);
	public List getObjectByColumnInPubRechercheCsvInstr(String objet,String stat1,String stat2,String typePlan,String critere,String strSource);
	public List getObjectByColumnInSppRechercheInstr(String objet,String stat1,String stat2,String typePlan,String critere,String strSource) ;
	public List getObjectByColumnInDmpRechercheInstr(String objet,String stat1,String stat2,String typePlan,String critere,String strSource);
	
	public List getObjectByColumnInInstrValDao(String objet, String strSource);
	public List getObjectByColumnInInstrValAmi(String objet, String strSource);
	public List getObjectByColumnInInstrValPrq(String objet, String strSource);
	public List getObjectByColumnInInstrDejaAff(String objet, String strSource);
	public List getObjectByColumnInInstrConsultDaoDmp(String objet, String strSource);
	public List getObjectByColumnInInstrConsultDaoRechDmp(String objet,String critere, String strSource);
	public List getObjectByColumnInInstrConsultPpmDmp(String objet, String strSource);
	//Comptage en region
	public int countTableByColumnInInstr(String objet,String conditionColumn, String strSource, String typeDac);

	public List getObjectByColumnInPpmInstr(String objet,String typePlan ,String strSource);
	public List getObjectByColumnNotInPpmInstrChVal(String objet,String strSource);
	public List getObjectByColumnNotInPpmInstrChCritppm(String objet,String strSource,String critere);

	public List getObjectByColumnInPpmDmpInstr(String objet, String typePlan, String strSource);


	public int countTableByColumnInPmmInstr(String objet, String conditionColumn, String strSource);
	public int countTableByColumnInPspmInstr(String objet, String conditionColumn, String strSource);
	public List getObjectByColumnInPspmInstr(String objet, String strSource);
	
	public int countTableByColumnInInstrDjAffec(String objet,String conditionColumn ,String strSource, String typeDac);
	public int countTableByColumnInInstrDiffAff(String objet,String conditionColumn,String strSource, String typeDac);
	public int countTableByColumnInInstrValidDao(String objet,String conditionColumn,String strSource, String typeDac, String typePlan);
	public int countTableByColumnInInstrValAff(String objet,String conditionColumn,String strSource, String typeDac, String typePlan);

	public int countTableByColumnInPpmValInstr(String objet, String conditionColumn, String statut, String strSource);

	public int countTableByColumnInPpmDiffInstr(String objet, String conditionColumn, String stat1, String stat2, String typePlan,String strSource);
	
	public int countTableByColumnNotIn(String tableName,String conditionColumn, List<WhereClause>conditionList,  List<String> columnList, String notCondition,  List<String> notList);
}
