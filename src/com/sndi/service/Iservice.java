package com.sndi.service;

import java.util.ArrayList;
import java.util.List;

import com.sndi.dao.WhereClause;
import com.sndi.model.TOperateur;

public interface Iservice {
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
	 * Get Object List lasy
	 * 
	 */
	public List<Object> getObjectLasy(Object object, Class businessInterface);
	
	public List<Object> getObjectLasy(String object, Class businessInterface);
	
	/**
	 * Get Object List
	 */
	public  List getObjects(String objet);
	
	public  List getObjects(String objet, List<String> columnList);

	
	public List getObjectsNotIn(String object, List<String> columnList, String notCondition,  List<String> notList);
	public List getObjectsIn(String object, List<String> columnList, String inCondition,  List<String> inList);
	
	public List getObjectsByColumn(String object, WhereClause ... conditions );
	public List getObjectsByColumnIn(String object,String inCondition,  List<String> inList, WhereClause ... conditions);

	public List getObjectsByColumnNotQuote(String object, List<String> columnList, WhereClause ... conditions);
	public List getObjectsByColumn(String object, List<String> columnList, WhereClause ... conditions);
	public List getObjectsByColumnDesc(String object, List<String> columnList, WhereClause ... conditions);
	//public List getObjectsByColumnNotQuoteDesc(String objet, List<WhereClause> conditionList, List<String> columnList,String inCondition, List<String> inList);
	public List getObjectsByColumnInNotQuote(String objet,String inCondition, List<String> inList, List<WhereClause>conditionList, List<String> columnList);
	public List getObjectsByColumnNotIn(String object, List<String> columnList, String notCondition,  List<String> notList, WhereClause ... conditions);
	public List getObjectsByColumnIn(String object, List<String> columnList, String inCondition,  List<String> inList, WhereClause ... conditions);
	public List getObjectsByColumnInDesc(String object, List<String> columnList, String inCondition,  List<String> inList, WhereClause ... conditions);
	public int countTableByColumn(String tableName,String conditionColumn,  WhereClause ... conditions); 
	public int countTableByColumnIn(String tableName,String conditionColumn,  List<String> columnList, String inCondition,  List<String> inList, WhereClause ... conditions);
	
	
	public TOperateur getUser(String login);
	
	public String getCodeTable(String pseudo, int tailleChar, int tailleNumber,
			String tableName, String column);
	
	public String getCodeDossier(String inc, int tailleChar, int size,
			String T_DOSSIERS, String DOS_CODE);

	public List getObjectByColumnInInstr(String objet, String strSource);
	public List getObjectByColumnInInstrAmi(String objet, String strSource);
	public List getObjectByColumnInInstrPrq(String objet, String strSource);
	public List getObjectByColumnInInstrValDao(String objet, String strSource);
	public List getObjectByColumnInInstrValAmi(String objet, String strSource);
	public List getObjectByColumnInInstrValPrq(String objet, String strSource);
	public List getObjectByColumnInInstrDejaAff(String objet, String strSource);
	//Methode de comptage en région
	public int countTableByColumnInInstr(String objet,String conditionColumn, String strSource, String typeDac, String typePlan);

}
