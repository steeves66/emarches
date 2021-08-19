package com.sndi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sndi.dao.IDao;
import com.sndi.dao.WhereClause;
import com.sndi.model.TOperateur;

@Transactional(readOnly = true)
public class Service implements Iservice {

	// DAO is injected...
		IDao Dao;
		
		@Transactional(readOnly = false)
		@Override
		public void addObject(Object object) {
			// TODO Auto-generated method stub
			getDao().addObject(object);
		}
		
		@Transactional(readOnly = false)
		@Override
		public void persist(Object object) {
			// TODO Auto-generated method stub
			getDao().persist(object);
		}
		
		
		@Transactional(readOnly = false)
		@Override
		public void updateObject(Object object) {
			// TODO Auto-generated method stub
			getDao().updateObject(object);
		}
		
		@Transactional(readOnly = false)
		@Override
		public void mergeObject(Object object) {
			// TODO Auto-generated method stub
			getDao().mergeObject(object);
		}
		
		@Override @Transactional(readOnly = false)
		public Object mergeAndReturnObject(Object object) 
		{
			return getDao().mergeAndReturnObject(object);
		}
		
		@Transactional(readOnly = false)
		@Override
		public void deleteObject(Object object) {
			// TODO Auto-generated method stub
			getDao().deleteObject(object);
		}
		
		public Object getFonctionStatutPosition(String fonction_code, String action) {
			// TODO Auto-generated method stub
			return  getDao().getFonctionStatutPosition(fonction_code, action);
		}

		@Override
		public Object getObjectById(int id, String objet) {
			// TODO Auto-generated method stub
			return getDao().getObjectById(id, objet);
		}

		@Override
		public Object getObjectById(String id, String objet) {
			// TODO Auto-generated method stub
			return getDao().getObjectById(id, objet);
		}

		@Override
		@Transactional
		public Object getObjectById(String id, Object objet) {
			// TODO Auto-generated method stub
			return getDao().getObjectById(id, objet);
			 
		}
		
		@Override
		public List<Object> getObjects(Object object) {
			// TODO Auto-generated method stub
			return getDao().getObjects(object);
		}
		
		@Override
		public List<Object> getObjectLasy(Object object, Class businessInterface) {
			// TODO Auto-generated method stub
			return getDao().getObjectLasy(object, businessInterface);
		}
		
		@Override
		public List<Object> getObjectLasy(String object, Class businessInterface) {
			// TODO Auto-generated method stub
			return getDao().getObjectLasy(object, businessInterface);
		}
		
		
		@Override
		public int countTableByColumn(String tableName,String conditionColumn,  WhereClause ... conditions) {
			// TODO Auto-generated method stub
			return getDao().countTableByColumn(tableName, conditionColumn, Arrays.asList(conditions));
		}
		
		public int countTableByColumnIn(String tableName,String conditionColumn,  List<String> columnList, String inCondition,  List<String> inList, WhereClause ... conditions) {
			return getDao().countTableByColumnIn(tableName,conditionColumn, Arrays.asList(conditions), columnList, inCondition, inList);
		}


		@Override
		@Transactional
		public TOperateur getUser(String login){
			return getDao().getUser(login);
		}
		
		public String getCodeTable(String pseudo, int tailleChar, int tailleNumber,
				String tableName, String column){
			return getDao().getCodeTable(pseudo, tailleChar, tailleNumber, tableName, column);
		}
		
		public String getCodeDossier(String inc, int tailleChar, int size,
				String T_DOSSIERS, String DOS_CODE) {
			return getDao().getCodeDossier(inc, tailleChar, size, T_DOSSIERS, DOS_CODE);
             }
		
		public IDao getDao() {
			return Dao;
		}

		public void setDao(IDao dao) {
			Dao = dao;
		}


		@Override
		public List getObjects(String objet) {
			// TODO Auto-generated method stub
			return getDao().getObjects(objet);
		}
		
		@Override
		public List getObjects(String objet, List<String> columnList) {
			// TODO Auto-generated method stub
			return getDao().getObjects(objet, columnList);
		}
		
		@Override
		public List getObjectByColumnInInstr(String objet, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstr(objet,strSource);
		}
		
		@Override
		public List getObjectByColumnInInstrFiltre(String objet, String statut, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrFiltre(objet,statut,strSource);
		}
		
		@Override
		public List getObjectByColumnInInstrValDaoFiltre(String objet,String statut, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrValDaoFiltre(objet,statut,strSource);
		}
		
		
		
		//Methode de comptage en region
		@Override
		public int countTableByColumnInInstr(String objet,String conditionColumn, String strSource, String typeDac) {
			// TODO Auto-generated method stub
			return getDao().countTableByColumnInInstr(objet,conditionColumn,strSource,typeDac);
		}
		
		public int countTableByColumnInPpmValInstr(String objet,String conditionColumn,String statut ,String strSource) {
			return getDao().countTableByColumnInPpmValInstr(objet,conditionColumn,statut,strSource);
		}
		
		 public int countTableByColumnInPpmDiffInstr(String objet,String conditionColumn,String stat1,String stat2,String typePlan,String strSource) {
			 return getDao().countTableByColumnInPpmDiffInstr(objet,conditionColumn,stat1,stat2,typePlan,strSource);
		 }
		
		//Methode de comptage PPM en region
		@Override
		public int countTableByColumnInPmmInstr(String objet, String conditionColumn,String strSource) {
			return getDao().countTableByColumnInPmmInstr(objet,conditionColumn,strSource);
		}
		
		//Methode de comptage PPM en region
		@Override
		public int countTableByColumnInPspmInstr(String objet, String conditionColumn, String strSource) {
		   return getDao().countTableByColumnInPspmInstr(objet,conditionColumn,strSource);
		}
				
		
		@Override
		public List<Object> getObjectsByColumn(String object, WhereClause ... conditions ) {
			// TODO Auto-generated method stub
			System.out.println("Service L184");
			return getDao().getObjectsByColumn(object, Arrays.asList(conditions));
		}
		

		
		@Override
		public List<Object> getObjectsByColumn(String object,  List<String> columnList , WhereClause ... conditions) {
			// TODO Auto-generated method stub
			return getDao().getObjectsByColumn(object, Arrays.asList(conditions), columnList);
		}
		
		@Override
		public List<Object> getObjectsByColumnNotIn(String object,  List<String> columnList , String notCondition, List<String> notList , WhereClause ... conditions) {
			// TODO Auto-generated method stub
			return getDao().getObjectsByColumnnNotIn(object, Arrays.asList(conditions), columnList, notCondition, notList);
		}
		
		@Override
		public List<Object> getObjectsByColumnIn(String object,  List<String> columnList , String inCondition, List<String> inList , WhereClause ... conditions) {
			// TODO Auto-generated method stub
			return getDao().getObjectsByColumnnIn(object, Arrays.asList(conditions), columnList, inCondition, inList);
		}
		@Override
		public List<Object> getObjectsByColumnInDesc(String object,  List<String> columnList , String inCondition, List<String> inList , WhereClause ... conditions) {
			// TODO Auto-generated method stub
			return getDao().getObjectsByColumnnInDesc(object, Arrays.asList(conditions), columnList, inCondition, inList);
		}
		@Override
		public List<Object> getObjectsNotIn(String object,  List<String> columnList , String notCondition, List<String> notList) {
			// TODO Auto-generated method stub
			return getDao().getObjectsNotIn(object, columnList, notCondition, notList);
		}
		@Override
		public List<Object> getObjectsByColumnNotQuote(String object,  List<String> columnList , WhereClause ... conditions) {
			// TODO Auto-generated method stub
			return getDao().getObjectsByColumnNotQuote(object, Arrays.asList(conditions), columnList);
		}
		
		@Override
		public List<Object> getObjectsIn(String object,  List<String> columnList , String inCondition, List<String> inList) {
			// TODO Auto-generated method stub
			return getDao().getObjectsIn(object, columnList, inCondition, inList);
		}

		@Override
		public List getObjectsByColumnDesc(String object, List<String> columnList, WhereClause... conditions) {
			// TODO Auto-generated method stub
			return getDao().getObjectsByColumnDesc(object, Arrays.asList(conditions), columnList);
		}

		@Override
		public List getObjectsByColumnIn(String object, String inCondition, List<String> inList,
				WhereClause... conditions) {
			// TODO Auto-generated method stub
			return getDao().getObjectsByColumnIn(object, inCondition, inList, conditions);	
		}
		
		@Override
		public List getObjectByColumnInPpmDmpInstr(String objet, String typePlan, String strSource) {
			return getDao().getObjectByColumnInPpmDmpInstr(objet,typePlan,strSource);
		}
		
		
		@Override
		public List getObjectByColumnInPpmInstr(String objet, String typePlan,String strSource) {
			return getDao().getObjectByColumnInPpmInstr(objet,typePlan,strSource);
		}
		
		//Methode de comptage PSPM en region
		@Override
		public List getObjectByColumnInPspmInstr(String objet,String strSource) {
			return getDao().getObjectByColumnInPspmInstr(objet,strSource);
		}
		
		

		@Override
		public List getObjectByColumnInInstrAmi(String objet,String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrAmi(objet,strSource);
		}

		@Override
		public List getObjectByColumnInInstrPrq(String objet,String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrPrq(objet,strSource);
		}

		@Override
		public List getObjectByColumnInInstrValDao(String objet, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrValDao(objet,strSource);
		}
		
		

		@Override
		public List getObjectByColumnInInstrValAmi(String objet, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrValAmi(objet,strSource);
		}

		@Override
		public List getObjectByColumnInInstrValPrq(String objet, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrValPrq(objet,strSource);
		}

		@Override
		public List getObjectByColumnInInstrDejaAff(String objet, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrDejaAff(objet,strSource);
		}

		@Override
		public List getObjectsByColumnInNotQuote(String objet, String inCondition, List<String> inList,
				List<WhereClause> conditionList, List<String> columnList) {
			// TODO Auto-generated method stub
			return getDao().getObjectsByColumnInNotQuote(objet, inCondition, inList, conditionList, columnList);
		}

		@Override
		public int countTableByColumnNotIn(String tableName, String conditionColumn, List<WhereClause> conditionList,
				List<String> columnList, String notCondition, List<String> notList) {
			// TODO Auto-generated method stub
			return getDao().countTableByColumnNotIn(tableName, conditionColumn, conditionList, columnList, notCondition, notList);
		}
		
		@Override
		public int countTableByColumnInInstrDjAffec(String objet,String conditionColumn ,String strSource, String typeDac) {
			// TODO Auto-generated method stub
			return getDao().countTableByColumnInInstrDjAffec(objet,conditionColumn,strSource,typeDac);
		}
		
		@Override
		public int countTableByColumnInInstrDiffAff(String objet,String conditionColumn,String strSource, String typeDac) {
			// TODO Auto-generated method stub
			return getDao().countTableByColumnInInstrDiffAff(objet,conditionColumn,strSource,typeDac);
		}
		
		@Override
		public List getObjectByColumnInPubCsvInstr(String objet,String stat1,String stat2,String typePlan,String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInPubCsvInstr(objet,stat1,stat2,typePlan,strSource); 
		}
		
		@Override
		public List getObjectByColumnInPubRechercheCsvInstr(String objet,String stat1,String stat2,String typePlan,String critere,String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInPubRechercheCsvInstr(objet,stat1,stat2,typePlan,critere,strSource);
		}
		
		@Override
		public List getObjectByColumnInSppRechercheInstr(String objet,String stat1,String stat2,String typePlan,String critere,String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInSppRechercheInstr(objet,stat1,stat2,typePlan,critere,strSource); 
		}
		
		@Override
		public List getObjectByColumnInDmpRechercheInstr(String objet,String stat1,String stat2,String typePlan,String critere,String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInSppRechercheInstr(objet,stat1,stat2,typePlan,critere,strSource); 
		}
		
		@Override
		public int countTableByColumnInInstrValAff(String objet,String conditionColumn,String strSource, String typeDac, String typePlan) {
			// TODO Auto-generated method stub
			return getDao().countTableByColumnInInstrValAff(objet,conditionColumn,strSource,typeDac,typePlan);
		}
		
		@Override
		public int countTableByColumnInInstrValidDao(String objet,String conditionColumn,String strSource, String typeDac, String typePlan) {
		// TODO Auto-generated method stub
		return getDao().countTableByColumnInInstrValidDao(objet,conditionColumn,strSource, typeDac, typePlan);
		 }

		@Override
		public List getObjectByColumnNotInPpmInstrChVal(String objet, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnNotInPpmInstrChVal(objet, strSource);
		}

		@Override
		public List getObjectByColumnNotInPpmInstrChCritppm(String objet, String strSource,
				String critere) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnNotInPpmInstrChCritppm(objet, strSource, critere);
		}

		@Override
		public List getObjectByColumnInPublicationCsvInstr(String objet, String stat, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInPublicationCsvInstr(objet,stat,strSource);
		}
		
		@Override
		public List getObjectByColumnInPublicationRechercheCsvInstr(String objet,String critere,String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInPublicationRechercheCsvInstr(objet,critere,strSource);
		}
		
		@Override
		public List getObjectByColumnInPublicationRechercheStatutMoisCsvInstr(String objet,String stat,String critere,String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInPublicationRechercheStatutMoisCsvInstr(objet,stat,critere,strSource);
		}
		
		@Override
		public List getObjectByColumnInPublicationRechercheStatutCsvInstr(String objet,String stat,String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInPublicationRechercheStatutCsvInstr(objet,stat,strSource);
		}
		
		@Override
		public List getObjectByColumnInPublicationRechercheMoisCsvInstr(String objet,String mois,String strSource)  {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInPublicationRechercheMoisCsvInstr(objet,mois,strSource);
		}

		@Override
		public List getObjectByColumnInInstrConsultDaoDmp(String objet, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrConsultDaoDmp(objet,strSource);
		}

		@Override
		public List getObjectByColumnInInstrConsultDaoRechDmp(String objet, String critere, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrConsultDaoRechDmp(objet,critere,strSource);
		}

		@Override
		public List getObjectByColumnInInstrConsultPpmDmp(String objet, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrConsultPpmDmp(objet,strSource);
		}

		
		@Override
		public List getObjectByColumnBudgetInstr(String objet, String lbgCodeAc, String lbgMopCode) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnBudgetInstr(objet,lbgCodeAc,lbgMopCode);
		}

		@Override
		public List getObjectByColumnInInstrValAno(String objet, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInInstrValAno(objet,strSource);
		}
		
		
		//For Laurent
		public List getObjectByColumnInInstrValNull(String objet) {
			return getDao().getObjectByColumnInInstrValNull(objet);
		}

		/*@Override
		public List getObjectByColumnInPublicationCsvInstr(String objet, String stat1, String strSource) {
			// TODO Auto-generated method stub
			return getDao().getObjectByColumnInPublicationCsvInstr(objet,stat1,strSource);
		}*/




}
