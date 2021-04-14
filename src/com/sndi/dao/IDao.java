 package com.sndi.dao;

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

	public List getObjectByColumnInInstr(String objet, String strSource);
	//Comptage en region
	public int countTableByColumnInInstr(String objet,String conditionColumn, String strSource, String typeDac, String typePlan);
}
