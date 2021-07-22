package com.sndi.dao;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.sndi.model.TOperateur;

public class Dao implements IDao {

	private SessionFactory sessionFactory;

	@Override
	public void addObject(Object object) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(object);

	}
	
	@Override
	public void persist(Object object) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().persist(object);

	}

	@Override
	public void updateObject(Object object) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().update(object);
	}
	
	@Override
	public void mergeObject(Object object) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().merge(object);
	}

	@Override
	public void deleteObject(Object Object) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(Object);
	}

	@Override
	public Object getObjectById(int id, String objet) {
		// TODO Auto-generated method stub
		String query= "from" +" "+ objet + " "+ " where id =?";
		  List liste = getSessionFactory().getCurrentSession().createQuery(query).setParameter(0,id).list();
		  if (liste.size()==0){
		   return null;}
		return liste.get(0);
	}
	
	@Override
	public Object getFonctionStatutPosition(String fonction_code, String action) {
		// TODO Auto-generated method stub
		 
		
		  Query query = getSessionFactory().getCurrentSession().getNamedQuery("call FB_STATUT_POSITION");

	        query.setParameter("V_Fonction", fonction_code); 
	        query.setParameter("V_Action", action);
	         query.executeUpdate();
	         List result = query.list();
		  if (result.size()==0){
		   return null;}
	
		return result.get(0);
	}

	@Override
	public Object getObjectById(String id, String objet) {
		// TODO Auto-generated method stub
		String query= "from" +" "+ objet + " "+ " where id =?";
		  List liste = getSessionFactory().getCurrentSession().createQuery(query).setParameter(0,id).list();
		  if (liste.size()==0){
		   return null;}
		return liste.get(0);
	}
	
	@Override
	public int countTableByColumn(String tableName,String conditionColumn, List<WhereClause>conditionList) {
		// TODO Auto-generated method stub
		
		String query = "SELECT TO_NUMBER(count("+tableName+"."+conditionColumn+")) FROM "+tableName ;
		if(!conditionList.isEmpty()){
		query += " WHERE "+tableName+"."+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+"'"+conditionList.get(0).getValeur()+"'";
		for(int i=1; i<conditionList.size(); i++){
			query += " AND "+tableName+"."+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+"'"+conditionList.get(i).getValeur()+"'";			
		}
		}
		try {
			BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
					.createSQLQuery(query).uniqueResult();
			if (bv == null) {return 0;} else {return bv.intValue();}
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int countTableByColumnIn(String tableName,String conditionColumn, List<WhereClause>conditionList,  List<String> columnList, String inCondition,  List<String> inList) {
			// TODO Auto-generated method stub
			
			String query = "SELECT TO_NUMBER(count("+tableName+"."+conditionColumn+")) FROM "+tableName ;
			if(!conditionList.isEmpty()){
			query += " WHERE "+tableName+"."+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+"'"+conditionList.get(0).getValeur()+"'";
			for(int i=1; i<conditionList.size(); i++){
				query += " AND "+tableName+"."+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+"'"+conditionList.get(i).getValeur()+"'";			
			}}
			
			if(!inList.isEmpty()){
				query += " AND "+inCondition+" IN ('"+inList.get(0)+"'";
				for(int i=1; i<inList.size(); i++){
					query += " , '"+inList.get(i)+"'";
				}
				query +=")";
			}
			if(!columnList.isEmpty()){
			query += " ORDER BY "+columnList.get(0);
			for(int i=1; i<columnList.size(); i++){
				query += " , "+columnList.get(i);
			}}
			
			
			try {
				BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
						.createSQLQuery(query).uniqueResult();
				if (bv == null) {return 0;} else {return bv.intValue();}
			} catch (HibernateException e) {
				e.printStackTrace();
				return 0;
			}
		}
	

/*	@Override
	public List<Object>  getObjectByColumnInInstr(String objet, String strSource, List<String> columnList) {
			// TODO Auto-generated method stub
			
			List query = "SELECT * FROM "+tableName ;
			if(!conditionList.isEmpty()){
			query += " WHERE INSTR ("+strSource+"."+ columnList.get(0)+")";
			for(int i=1; i<conditionList.size(); i++){
				query += " AND "+tableName+"."+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+"'"+conditionList.get(i).getValeur()+"'";			
			}}
			
			if(!inList.isEmpty()){
				query += " AND "+inCondition+" IN ('"+inList.get(0)+"'";
				for(int i=1; i<inList.size(); i++){
					query += " , '"+inList.get(i)+"'";
				}
				query +=")";
			}
			if(!columnList.isEmpty()){
			query += " ORDER BY "+columnList.get(0);
			for(int i=1; i<columnList.size(); i++){
				query += " , "+columnList.get(i);
			}}
			
			return list ;
			
			// TODO Auto-generated method stub
			String query = "FROM"+" "+objet;
			query += " WHERE INSTR ("+strSource+"."+ columnList.get(0)+") > 0 "; 
			for(int i=1; i<columnList.size(); i++){
				query += " , "+columnList.get(i);
			}

			List list = getSessionFactory().getCurrentSession().createQuery(query).list();
			return list;
		}*/

	@Override
	@Transactional
	public Object getObjectById(String id, Object objet) {
		
		Session session= getSessionFactory().getCurrentSession();
		Criteria crit = session.createCriteria((Class) objet);
		crit.add(Restrictions.eq("id", id));
		return (Object) crit.uniqueResult();
	}
	
	@Override
	public List<Object> getObjects(Object object) {
		// TODO Auto-generated method stub
		List list = getSessionFactory().getCurrentSession().createQuery("from"+" "+object).list();
			// TODO Auto-generated method stub
			return list ;
	}
	
	@Override
	public List<Object> getObjectLasy(Object object, Class businessInterface) {
		// TODO Auto-generated method stub
		StringBuilder hqlQuery = new StringBuilder();
		hqlQuery.append("from"+" "+object);
		hqlQuery.append(addFetchingStategy(null, businessInterface));
		List list = getSessionFactory().getCurrentSession().createQuery("from"+" "+object).list();
			// TODO Auto-generated method stub
			return list ;
	}
	
	@Override
	public List<Object> getObjectLasy(String object, Class businessInterface) {
		// TODO Auto-generated method stub
		StringBuilder hqlQuery = new StringBuilder();
		hqlQuery.append("from"+" "+object);
		hqlQuery.append(addFetchingStategy(null, businessInterface));
		List list = getSessionFactory().getCurrentSession().createQuery("from"+" "+object).list();
			// TODO Auto-generated method stub
			return list ;
	}
	
	@Override
	public List getObjects(String objet) {
		// TODO Auto-generated method stub
		String query = "from"+" "+objet;
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	@Override
	public List getObjects(String objet, List<String> columnList) {
		// TODO Auto-generated method stub
		String query = "FROM"+" "+objet;
		query += " ORDER BY "+columnList.get(0);
		for(int i=1; i<columnList.size(); i++){
			query += " , "+columnList.get(i);
		}

		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	@Override
	public List getObjectsByColumn(String objet, List<WhereClause>conditionList) {
		
		// TODO Auto-generated method stub
		String query = "FROM "+objet ;
		if(!conditionList.isEmpty()){
		query += " WHERE "+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+"'"+conditionList.get(0).getValeur()+"'";
		for(int i=1; i<conditionList.size(); i++){
			query += " AND "+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+"'"+conditionList.get(i).getValeur()+"'";			
		}
		}
		System.out.println("Query  = "+ query);
		List list = getSessionFactory()
				.getCurrentSession()
				.createQuery(query)
				.list();
		return list;
	}
	@Override
	public List getObjectsByColumnDesc(String objet, List<WhereClause>conditionList, List<String> columnList) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet ;
		if(!conditionList.isEmpty()){
			query += " WHERE "+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+((conditionList.get(0).getValeur() == null)? "" : "'"+conditionList.get(0).getValeur()+"'");
			for(int i=1; i<conditionList.size(); i++){
				query += " AND "+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+((conditionList.get(i).getValeur() == null)? "" :"'"+conditionList.get(i).getValeur()+"'");			
			}}
		if(!columnList.isEmpty()){
			query += " ORDER BY "+columnList.get(0);
			for(int i=1; i<columnList.size(); i++){
				query += " , "+columnList.get(i);
			}}
		query+=" DESC";
		List list = getSessionFactory().getCurrentSession().createQuery(query).list(); 
		return list;
	}
	
	@Override
	public List getObjectsByColumn(String objet, List<WhereClause>conditionList, List<String> columnList) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet ;
		if(!conditionList.isEmpty()){
		query += " WHERE "+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+((conditionList.get(0).getValeur() == null)? "" : "'"+conditionList.get(0).getValeur()+"'");
		for(int i=1; i<conditionList.size(); i++){
			query += " AND "+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+((conditionList.get(i).getValeur() == null)? "" :"'"+conditionList.get(i).getValeur()+"'");			
		}}
		if(!columnList.isEmpty()){
		query += " ORDER BY "+columnList.get(0);
		for(int i=1; i<columnList.size(); i++){
			query += " , "+columnList.get(i);
		}}
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	@Override
	public List getObjectsByColumnnNotIn(String objet, List<WhereClause>conditionList, List<String> columnList, String notCondition,  List<String> notList) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet ;
		if(!conditionList.isEmpty()){
		query += " WHERE "+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+((conditionList.get(0).getValeur() == null)? "" : "'"+conditionList.get(0).getValeur()+"'");
		for(int i=1; i<conditionList.size(); i++){
			query += " AND "+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+((conditionList.get(i).getValeur() == null)? "" :"'"+conditionList.get(i).getValeur()+"'");			
		}}
		if(!notList.isEmpty()){
			query += " AND "+notCondition+" NOT IN ('"+notList.get(0)+"'";
			for(int i=1; i<notList.size(); i++){
				query += " , '"+notList.get(i)+"'";
			}
			query +=")";
		}
		if(!columnList.isEmpty()){
		query += " ORDER BY "+columnList.get(0);
		for(int i=1; i<columnList.size(); i++){
			query += " , "+columnList.get(i);
		}}
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	@Override
	public int countTableByColumnNotIn(String tableName,String conditionColumn, List<WhereClause>conditionList,  List<String> columnList, String notCondition,  List<String> notList) {
			// TODO Auto-generated method stub
			
			String query = "SELECT TO_NUMBER(count("+tableName+"."+conditionColumn+")) FROM "+tableName ;
			if(!conditionList.isEmpty()){
			query += " WHERE "+tableName+"."+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+"'"+conditionList.get(0).getValeur()+"'";
			for(int i=1; i<conditionList.size(); i++){
				query += " AND "+tableName+"."+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+"'"+conditionList.get(i).getValeur()+"'";			
			}}
			
			if(!notList.isEmpty()){
				query += " AND "+notCondition+" NOT IN ('"+notList.get(0)+"'";
				for(int i=1; i<notList.size(); i++){
					query += " , '"+notList.get(i)+"'";
				}
				query +=")";
			}
			if(!columnList.isEmpty()){
			query += " ORDER BY "+columnList.get(0);
			for(int i=1; i<columnList.size(); i++){
				query += " , "+columnList.get(i);
			}}
			
			
			try {
				BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
						.createSQLQuery(query).uniqueResult();
				if (bv == null) {return 0;} else {return bv.intValue();}
			} catch (HibernateException e) {
				e.printStackTrace();
				return 0;
			}
		}
	
	
	
	
	@Override
	public List getObjectsByColumnnIn(String objet, List<WhereClause>conditionList, List<String> columnList, String inCondition,  List<String> inList) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet ;
		if(!conditionList.isEmpty()){
		query += " WHERE "+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+((conditionList.get(0).getValeur() == null)? "" : "'"+conditionList.get(0).getValeur()+"'");
		for(int i=1; i<conditionList.size(); i++){
			query += " AND "+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+((conditionList.get(i).getValeur() == null)? "" :"'"+conditionList.get(i).getValeur()+"'");			
		}}
		if(!inList.isEmpty()){
			query += " AND "+inCondition+" IN ('"+inList.get(0)+"'";
			for(int i=1; i<inList.size(); i++){
				query += " , '"+inList.get(i)+"'";
			}
			query +=")";
		}
		if(!columnList.isEmpty()){
		query += " ORDER BY "+columnList.get(0);
		for(int i=1; i<columnList.size(); i++){
			query += " , "+columnList.get(i);
		}}
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	@Override
	public List getObjectsByColumnnInDesc(String objet, List<WhereClause> conditionList, List<String> columnList,String inCondition, List<String> inList) {
		String query = "FROM "+objet ;
		if(!conditionList.isEmpty()){
		query += " WHERE "+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+((conditionList.get(0).getValeur() == null)? "" : "'"+conditionList.get(0).getValeur()+"'");
		for(int i=1; i<conditionList.size(); i++){
			query += " AND "+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+((conditionList.get(i).getValeur() == null)? "" :"'"+conditionList.get(i).getValeur()+"'");			
		}}
		if(!inList.isEmpty()){
			query += " AND "+inCondition+" IN ('"+inList.get(0)+"'";
			for(int i=1; i<inList.size(); i++){
				query += " , '"+inList.get(i)+"'";
			}
			query +=")";
		}
		if(!columnList.isEmpty()){
		query += " ORDER BY "+columnList.get(0);
		for(int i=1; i<columnList.size(); i++){
			query += " , "+columnList.get(i);
		}}
		query+=" DESC";
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	@Override
	public List getObjectsNotIn(String objet, List<String> columnList, String notCondition,  List<String> notList) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet ;
		if(!notList.isEmpty()){
			query += " WHERE "+notCondition+" NOT IN ('"+notList.get(0)+"'";
			for(int i=1; i<notList.size(); i++){
				query += " , '"+notList.get(i)+"'";
			}
			query +=")";
		}
		if(!columnList.isEmpty()){
			query += " ORDER BY "+columnList.get(0);
			for(int i=1; i<columnList.size(); i++){
				query += " , "+columnList.get(i);
			}}
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	@Override
	public List getObjectsIn(String objet, List<String> columnList, String inCondition,  List<String> inList) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet ;
		if(!inList.isEmpty()){
			query += " WHERE "+inCondition+" IN ('"+inList.get(0)+"'";
			for(int i=1; i<inList.size(); i++){
				query += " , '"+inList.get(i)+"'";
			}
			query +=")";
		}
		if(!columnList.isEmpty()){
			query += " ORDER BY "+columnList.get(0);
			for(int i=1; i<columnList.size(); i++){
				query += " , "+columnList.get(i);
			}}
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	@Override
	public List getObjectsByColumnNotQuote(String objet, List<WhereClause>conditionList, List<String> columnList) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet ;
		if(!conditionList.isEmpty()){
			query += " WHERE "+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+((conditionList.get(0).getValeur() == null)? "" : ""+conditionList.get(0).getValeur()+"");
			for(int i=1; i<conditionList.size(); i++){
				query += " AND "+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+((conditionList.get(i).getValeur() == null)? "" :""+conditionList.get(i).getValeur()+"");			
			}}
		if(!columnList.isEmpty()){
			query += " ORDER BY "+columnList.get(0);
			for(int i=1; i<columnList.size(); i++){
				query += " , "+columnList.get(i);
			}}
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	
@Override
public List getObjectByColumnInInstr(String objet, String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DAC_STA_CODE IN('D2T','D5R') AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnInInstrFiltre(String objet, String statut, String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DAC_STA_CODE IN('D2T','D5R') AND DAC_TYPE_PLAN ='"+statut+"' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnInInstrValDaoFiltre(String objet,String statut, String strSource) { 
	// TODO Auto-generated method stub
		String query = "FROM "+objet+" WHERE DAC_STA_CODE ='D4V' AND DAC_TYPE_PLAN ='"+statut+"' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ;       
	 List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
}
	
@Override
public List getObjectByColumnInPubCsvInstr(String objet,String stat1,String stat2,String typePlan,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DAC_STA_CODE IN ('"+stat1+"','"+stat2+"') AND DAC_TYPE_PLAN ='"+typePlan+"' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

/*@Override
public List getObjectByColumnInPublicationCsvInstr1(String objet,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE INSTR('"+strSource+"',FON_CODE_CSV) > 0 " ; 
	//String query = "FROM "+objet+" WHERE DAC_STA_CODE =NVL('"+stat1+", DAC_STA_CODE)' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}*/

@Override
public List getObjectByColumnInPublicationCsvInstr(String objet,String stat,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DAC_STA_CODE = '"+stat+"' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 " ; 
	//String query = "FROM "+objet+" WHERE DAC_STA_CODE =NVL('"+stat1+", DAC_STA_CODE)' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnInPublicationRechercheCsvInstr(String objet,String critere,String strSource) {
	// TODO Auto-generated method stub
	String crit = critere.replace("'", "''");
	String query = "FROM "+objet+" WHERE CRITERE like'%"+crit+"%' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 " ;
	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnInPublicationRechercheStatutMoisCsvInstr(String objet,String stat,String critere,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DAC_STA_CODE = '"+stat+"' AND MOIS = '"+critere+"' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 " ;
	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnInPublicationRechercheMoisCsvInstr(String objet,String mois,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE MOIS = '"+mois+"' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 " ;
	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnInPublicationRechercheStatutCsvInstr(String objet,String stat,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DAC_STA_CODE = '"+stat+"' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 " ;
	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnInPubRechercheCsvInstr(String objet,String stat1,String stat2,String typePlan,String critere,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DAC_STA_CODE IN ('"+stat1+"','"+stat2+"') AND DAC_TYPE_PLAN ='"+typePlan+"' AND CRITERE like'%"+critere+"%' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_MODIF" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}


@Override
public List getObjectByColumnInDmpRechercheInstr(String objet,String stat1,String stat2,String typePlan,String critere,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DPP_STA_CODE IN ('"+stat1+"','"+stat2+"') AND DPP_TYPE_PLAN ='"+typePlan+"' AND CRITERE like'%"+critere+"%' AND INSTR('"+strSource+"',FON_CODE_DMP) > 0 ORDER BY DPP_DTE_MODIF" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnInSppRechercheInstr(String objet,String stat1,String stat2,String typePlan,String critere,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DPP_STA_CODE IN ('"+stat1+"','"+stat2+"') AND DPP_TYPE_PLAN ='"+typePlan+"' AND CRITERE like'%"+critere+"%' AND INSTR('"+strSource+"',FON_CODE_SPP) > 0 ORDER BY DPP_DTE_MODIF" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnInPpmDmpInstr(String objet,String typePlan ,String strSource) {
// TODO Auto-generated method stub
String query = "FROM "+objet+" WHERE DPP_STA_CODE IN ('S2V','SPT') AND DPP_TYPE_PLAN='"+typePlan+"' AND INSTR('"+strSource+"',FON_CODE_DMP) > 0 ORDER BY DPP_DTE_MODIF" ; 

List list = getSessionFactory().getCurrentSession().createQuery(query).list();
return list;
}
	
@Override
  public List getObjectByColumnInPpmInstr(String objet,String typePlan,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DPP_STA_CODE IN('S2V','SPT') AND DPP_TYPE_PLAN ='"+typePlan+"' AND INSTR('"+strSource+"',FON_CODE_SPP) > 0 ORDER BY DPP_DTE_MODIF" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
  }

@Override
public List getObjectByColumnNotInPpmInstrChVal(String objet,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DPP_STA_CODE NOT IN('S1S','S1T','S2D','S2R','S3D','SDS') AND INSTR('"+strSource+"',FON_CODE_SPP) > 0 ORDER BY DPP_DTE_MODIF DESC" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}

@Override
public List getObjectByColumnNotInPpmInstrChCritppm(String objet,String strSource,String critere) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DPP_STA_CODE NOT IN('S2V','SPT') AND CRITERE like'%'"+critere+"'%'  AND INSTR('"+strSource+"',FON_CODE_SPP) > 0 ORDER BY DPP_DTE_MODIF" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}
@Override
public List getObjectByColumnInPspmInstr(String objet,String strSource) {
	// TODO Auto-generated method stub
	String query = "FROM "+objet+" WHERE DPP_STA_CODE IN('S2V','SPT') AND DPP_TYPE_PLAN='PS' AND INSTR('"+strSource+"',FON_CODE_SPP) > 0 ORDER BY DPP_DTE_MODIF" ; 

	List list = getSessionFactory().getCurrentSession().createQuery(query).list();
	return list;
}
	
	public List getObjectByColumnInInstrAmi(String objet,String strSource) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet+" WHERE DAC_STA_CODE IN('D2T','D5R') AND DAC_TD_CODE='AMI' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ; 

		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	public List getObjectByColumnInInstrPrq(String objet, String strSource) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet+" WHERE DAC_STA_CODE IN('D2T','D5R') AND DAC_TD_CODE='PRQ' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ; 

		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	
	public List getObjectByColumnInInstrValDao(String objet, String strSource) { 
			// TODO Auto-generated method stub
				String query = "FROM "+objet+" WHERE DAC_STA_CODE ='D4V' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ;       
			 List list = getSessionFactory().getCurrentSession().createQuery(query).list();
				return list;
	}
	
	public List getObjectByColumnInInstrConsultPpmDmp(String objet, String strSource) { 
		// TODO Auto-generated method stub
		String query = "FROM "+objet+" WHERE DPP_STA_CODE NOT IN('S1S','S1T','S2V','S2D','S2R') AND INSTR('"+strSource+"',FON_CODE_SPP) > 0 ORDER BY DPP_DTE_MODIF DESC" ;      
		 List list = getSessionFactory().getCurrentSession().createQuery(query).list();
			return list;
      }
	
	public List getObjectByColumnInInstrConsultDaoDmp(String objet, String strSource) { 
		// TODO Auto-generated method stub
			String query = "FROM "+objet+" WHERE DAC_STA_CODE NOT IN ('SDS','D1S','D1R','D1T') AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ;       
		 List list = getSessionFactory().getCurrentSession().createQuery(query).list();
			return list;
      }
	
	public List getObjectByColumnInInstrConsultDaoRechDmp(String objet,String critere, String strSource) { 
		// TODO Auto-generated method stub
			String query = "FROM "+objet+" WHERE DAC_STA_CODE NOT IN ('SDS','D1S','D1R','D1T') AND CRITERE like'%"+critere+"%' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ;       
		 List list = getSessionFactory().getCurrentSession().createQuery(query).list();
			return list;
      }

	public List getObjectByColumnInInstrDejaAff(String objet, String strSource) { 
		// TODO Auto-generated method stub
			String query = "FROM "+objet+" WHERE DAC_STA_CODE IN('D3A','D4V') AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ;       
		 List list = getSessionFactory().getCurrentSession().createQuery(query).list();
			return list;
}
	
	public List getObjectByColumnInInstrValAmi(String objet, String strSource) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet+" WHERE DAC_STA_CODE ='D4V' AND DAC_TD_CODE='AMI' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ; 

		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	public List getObjectByColumnInInstrValPrq(String objet, String strSource) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet+" WHERE DAC_STA_CODE ='D4V' AND DAC_TD_CODE='PRQ' AND INSTR('"+strSource+"',FON_CODE_CSV) > 0 ORDER BY DAC_DTE_SAISI" ; 

		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	

	//Methode de comptage en région
	@Override
	public int countTableByColumnInInstr(String objet,String conditionColumn, String strSource, String typeDac) {
			// TODO Auto-generated method stub
			
			String query = "SELECT TO_NUMBER(count("+objet+"."+conditionColumn+")) FROM "+objet+" WHERE DAC_STA_CODE IN ('D2T','D5R')"
					+ " AND INSTR ('"+strSource+"',FON_CODE_CSV) > 0" ;
	
			try {
				BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
						.createSQLQuery(query).uniqueResult();
				if (bv == null) {return 0;} else {return bv.intValue();}
			} catch (HibernateException e) {
				e.printStackTrace();
				return 0;
			}
		}
	
	//Methode de comptage en région
		@Override
		public int countTableByColumnInInstrDjAffec(String objet,String conditionColumn ,String strSource, String typeDac) {
				// TODO Auto-generated method stub
				
				String query = "SELECT TO_NUMBER(count("+objet+"."+conditionColumn+")) FROM "+objet+" WHERE DAC_STA_CODE IN ('D3A','D3A') "
						+ " AND INSTR ('"+strSource+"',FON_CODE_CSV) > 0" ;
		
				try {
					BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
							.createSQLQuery(query).uniqueResult();
					if (bv == null) {return 0;} else {return bv.intValue();}
				} catch (HibernateException e) {
					e.printStackTrace();
					return 0;
				}
			}
	
	//Methode de comptage des DAO différés par le chef de service DAO en région
	 @Override
	 public int countTableByColumnInInstrDiffAff(String objet,String conditionColumn,String strSource, String typeDac) {
			// TODO Auto-generated method stub
			
			String query = "SELECT TO_NUMBER(count("+objet+"."+conditionColumn+")) FROM "+objet+" WHERE DAC_STA_CODE IN ('D5R','D5R')"
					+ " AND INSTR ('"+strSource+"',FON_CODE_CSV) > 0" ;
	
			try {
				BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
						.createSQLQuery(query).uniqueResult();
				if (bv == null) {return 0;} else {return bv.intValue();}
			} catch (HibernateException e) {
				e.printStackTrace();
				return 0;
			} 
	 }
	
	//Methode de comptage des DAO différés par le chef de service DAO en région
		 @Override
		 public int countTableByColumnInInstrValAff(String objet,String conditionColumn,String strSource, String typeDac, String typePlan) {
				// TODO Auto-generated method stub
				
				String query = "SELECT TO_NUMBER(count("+objet+"."+conditionColumn+")) FROM "+objet+" WHERE DAC_STA_CODE IN ('D4V','D4V') AND DAC_TD_CODE = '"+typeDac+"' "
						+ " AND DAC_TYPE_PLAN = '"+typePlan+"' AND INSTR ('"+strSource+"',FON_CODE_CSV) > 0" ;
		
				try {
					BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
							.createSQLQuery(query).uniqueResult();
					if (bv == null) {return 0;} else {return bv.intValue();}
				} catch (HibernateException e) {
					e.printStackTrace();
					return 0;
				} 
		 }
		 
	
		//Methode de comptage des DAO différés par le chef de service DAO en région
		 @Override
		 public int countTableByColumnInInstrValidDao(String objet,String conditionColumn,String strSource, String typeDac, String typePlan) {
				// TODO Auto-generated method stub
				
				String query = "SELECT TO_NUMBER(count("+objet+"."+conditionColumn+")) FROM "+objet+" WHERE DAC_STA_CODE IN ('D5V','DPU') AND DAC_TD_CODE = '"+typeDac+"' "
						+ " AND DAC_TYPE_PLAN = '"+typePlan+"' AND INSTR ('"+strSource+"',FON_CODE_CSV) > 0" ;
		
				try {
					BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
							.createSQLQuery(query).uniqueResult();
					if (bv == null) {return 0;} else {return bv.intValue();}
				} catch (HibernateException e) {
					e.printStackTrace();
					return 0;
				} 
		 }
		 
	//Methode de comptage PPM en région
	@Override
	public int countTableByColumnInPmmInstr(String objet,String conditionColumn, String strSource) {
			// TODO Auto-generated method stub
			
			String query = "SELECT TO_NUMBER(count("+objet+"."+conditionColumn+")) FROM "+objet+" WHERE DPP_STA_CODE IN ('S2V','SPT') AND DPP_TYPE_PLAN = 'PN'"
					+ " AND INSTR ('"+strSource+"',FON_CODE_SPP) > 0" ;
	
			try {
				BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
						.createSQLQuery(query).uniqueResult();
				if (bv == null) {return 0;} else {return bv.intValue();}
			} catch (HibernateException e) {
				e.printStackTrace();
				return 0;
			}
		}
	
	//Methode de comptage PSPM en région
	@Override
	public int countTableByColumnInPspmInstr(String objet,String conditionColumn,String strSource) {
			// TODO Auto-generated method stub
			
			String query = "SELECT TO_NUMBER(count("+objet+"."+conditionColumn+")) FROM "+objet+" WHERE DPP_STA_CODE IN ('S2V','SPT') AND DPP_TYPE_PLAN = 'PS' AND INSTR ('"+strSource+"',FON_CODE_SPP) > 0" ;
	
			try {
				BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
						.createSQLQuery(query).uniqueResult();
				if (bv == null) {return 0;} else {return bv.intValue();}
			} catch (HibernateException e) {
				e.printStackTrace();
				return 0;
			}
		}
	
	
	//Methode de comptage PPM en région
		@Override
		public int countTableByColumnInPpmValInstr(String objet,String conditionColumn,String statut ,String strSource) {
				// TODO Auto-generated method stub
				
				String query = "SELECT TO_NUMBER(count("+objet+"."+conditionColumn+")) FROM "+objet+" WHERE DPP_STA_CODE = '"+statut+"' AND DPP_TYPE_PLAN = 'PN'"
						+ " AND INSTR ('"+strSource+"',FON_CODE_SPP) > 0" ;
		
				try {
					BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
							.createSQLQuery(query).uniqueResult();
					if (bv == null) {return 0;} else {return bv.intValue();}
				} catch (HibernateException e) {
					e.printStackTrace();
					return 0;
				}
			}
		
		
		
		@Override
		public int countTableByColumnInPpmDiffInstr(String objet, String conditionColumn, String stat1, String stat2, String typePlan, String strSource) {
			String query = "SELECT TO_NUMBER(count("+objet+"."+conditionColumn+")) FROM "+objet+" WHERE DPP_STA_CODE IN ('"+stat1+"','"+stat2+"') AND DPP_TYPE_PLAN = '"+typePlan+"'"
					+ " AND INSTR ('"+strSource+"',FON_CODE_SPP) > 0" ;
	
			try {
				BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
						.createSQLQuery(query).uniqueResult();
				if (bv == null) {return 0;} else {return bv.intValue();}
			} catch (HibernateException e) {
				e.printStackTrace();
				return 0;
			}
		}
	
	/**
	 * @author User
	 *
	 */

	
	@Override
	@Transactional
	public String getCodeTable(String pseudo, int tailleChar, int size,
			String tableName, String column) {
		// Methode crï¿½ation d'un id code alphanumrique chronologique d'une
				// ligne de table ds la BD
				// SELECT MAX(to_number( SUBSTR(PAR_MATRICULE, 2, 10))) FROM T_PARTICIPANTS;

				String query = "SELECT MAX(TO_NUMBER(SUBSTR(" + column + ", "
						+ (tailleChar + 1) + ", " + (size)
						+ "))) FROM " + tableName + " WHERE "+column+" LIKE '"+pseudo+"%'";
				
				try {
					BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
							.createSQLQuery(query).uniqueResult();
					
					String tC = String.valueOf(size-tailleChar);
					if (bv == null) {
						//int numOrdT = i+1;
						String numOrd= String.format("%0"+tC+"d", 1);
						System.out.println("///////Verification requette V null");
						System.out.println("///////Verification requette V null et pseudo = "+pseudo);
						String s = pseudo + numOrd;
						System.out.println("///////Verification requette V null et pseudo + numrd = "+s);
						return s;
					} else {
						Integer v = bv.intValue();
						v = v +1;
						String numOrd= String.format("%0"+tC+"d", v);
						System.out.println("///////Verification requette V non null");
						String s = pseudo + numOrd;
						return s;
					}
				} catch (HibernateException e) {
					e.printStackTrace();
					return "0000";
				}
				// sess.close();

	}
	
	//joindres plusier dossier
	public String getCodeDossier(String inc, int tailleChar, int size,
			String T_DOSSIERS, String DOS_CODE) {
		String query = "SELECT MAX(TO_NUMBER(SUBSTR(" + DOS_CODE + ", "
				+ (tailleChar + 1) + ", " + (size)
				+ "))) FROM " + T_DOSSIERS + " WHERE "+ DOS_CODE +" LIKE ' " + inc + "%'" + " AND " + DOS_CODE +" LIKE ' " + "%'";
		
		try {
			BigDecimal	bv = (BigDecimal) getSessionFactory().getCurrentSession()
					.createSQLQuery(query).uniqueResult();
			
			String tC = String.valueOf(size-tailleChar);
			if (bv == null) {
				//int numOrdT = i+1;
				String numOrd= String.format("%0"+tC+"d", 1);
				System.out.println("///////Verification requette V null");
				System.out.println("///////Verification requette V null et pseudo = "+inc);
				String s = inc + numOrd;
				System.out.println("///////Verification requette V null et pseudo + numrd = "+s);
				return s;
			} else {
				Integer v = bv.intValue();
				v = v +1;
				String numOrd= String.format("%0"+tC+"d", v);
				System.out.println("///////Verification requette V non null");
				String s = inc + numOrd;
				return s;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return "0000";
		}
		// sess.close();
		
				
	}
	
	
	@Transactional
	public TOperateur getUser(String login){
		/*String query = "SELECT * FROM " + "T_Employes" + " a  WHERE a." + key + " ='"
				+ id + "' ";
		TEmployes A = (TEmployes)getSessionFactory().getCurrentSession()
				.createSQLQuery(query).addEntity(TEmployes.class).uniqueResult();
		return A;*/
		Session session= getSessionFactory().getCurrentSession();
		Criteria crit = session.createCriteria(TOperateur.class);
		crit.add(Restrictions.eq("opeLogin", login));
		//System.out.println("Login de connexion OpÃ©rateur : Login "+((TOperateur) crit.uniqueResult()).getOpeLogin()+" Nom "+((TOperateur) crit.uniqueResult()).getOpeNom());
		return (TOperateur) crit.uniqueResult();	
	}
	
			protected String addFetchingStategy(String association, 
					 Class businessInterface)
		{
		StringBuilder hqlQuery = new StringBuilder ();
		
		//	Association formatting
		if (association == null)
		{
		association = "";
		}
		else
		{
		//	Fetch on the association
		hqlQuery.append(" left join fetch ");
		hqlQuery.append(association);
		
		association += ".";
		}
		
		//	Get properties
		PropertyDescriptor[] descriptors = 
		   BeanUtils.getPropertyDescriptors(businessInterface);
		
		//	Add fetching criterion
		String fetchAssociation;
		for (PropertyDescriptor descriptor : descriptors)
		{	
		//	Exclusion cases
		Class type = descriptor.getPropertyType();
		
		if ((type.isPrimitive() == true) ||
		(type.getCanonicalName().startsWith("java") == true))
		{
		continue;
		}
		
		//	Recursive fetching
		fetchAssociation = association + descriptor.getName();
		hqlQuery.append(addFetchingStategy(fetchAssociation, type));
		
		}
		
		return hqlQuery.toString();
		
		}
		
		

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List getObjectsByColumnIn(String object, String inCondition, List<String> inList,
			WhereClause... conditions) {
		// TODO Auto-generated method stub
		String query = "FROM "+object ;
		if(!inList.isEmpty()){
			query += " WHERE "+inCondition+" IN ('"+inList.get(0)+"'";
			for(int i=1; i<inList.size(); i++){
				query += " , '"+inList.get(i)+"'";
			}
			query +=")";
		}
	
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	
	
	@Override
	public List getObjectsByColumnInNotQuote(String objet,String inCondition, List<String> inList, List<WhereClause>conditionList, List<String> columnList) {
		// TODO Auto-generated method stub
		String query = "FROM "+objet ;
		if(!inList.isEmpty()){
			query += " WHERE "+inCondition+" IN ('"+inList.get(0)+"'";
			for(int i=1; i<inList.size(); i++){
				query += " , '"+inList.get(i)+"'";
			}
			query +=")";
		}
		if(!conditionList.isEmpty()){
			query += " AND "+ conditionList.get(0).getColonne()+ conditionList.get(0).getComparateur()+((conditionList.get(0).getValeur() == null)? "" : ""+conditionList.get(0).getValeur()+"");
			for(int i=1; i<conditionList.size(); i++){
				query += " AND "+ conditionList.get(i).getColonne()+ conditionList.get(i).getComparateur()+((conditionList.get(i).getValeur() == null)? "" :""+conditionList.get(i).getValeur()+"");			
			}}
		if(!columnList.isEmpty()){
			query += " ORDER BY "+columnList.get(0);
			for(int i=1; i<columnList.size(); i++){
				query += " , "+columnList.get(i);
			}}
		List list = getSessionFactory().getCurrentSession().createQuery(query).list();
		return list;
	}
	


	
}
