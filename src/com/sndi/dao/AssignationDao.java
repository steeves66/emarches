package com.sndi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sndi.dao.WhereClause;
import com.sndi.model.TAssignation;
import com.sndi.service.Iservice;

import lombok.Getter;
import lombok.Setter;

@Component
public class AssignationDao implements IAssignationDao
{
	@Getter @Setter
	private SessionFactory sessionFactory;
	@Autowired private Iservice iservice;
	private final String tableName = "T_ASSIGNATION";
	private final String tableClassName = "TAssignation";
	private final String idColumn = "ASS_NUM";
	private final String opeMatriculeColumn = "ASS_OPE_MATRICULE";
	private final String fonCodColumn = "ASS_FON_COD";
	private final String assOpeMatriculeColumn = "ASS_OPE_MATRICULE";
	
	@Override
	public TAssignation findById(Long id) 
	{
		return  (TAssignation) iservice.getObjectsByColumn(tableClassName, new WhereClause(idColumn, WhereClause.Comparateur.EQ, id.toString())).get(0);
	}

	@Override
	public List<TAssignation> findAll() 
	{
		return iservice.getObjects(tableClassName);
	}

	@Override
	public TAssignation save(TAssignation assignation)
	{
		return (TAssignation) this.iservice.mergeAndReturnObject(assignation);
	}

	@Override
	public TAssignation update(TAssignation assignation) 
	{
		return (TAssignation) iservice.mergeAndReturnObject(assignation);
	}

	@Override
	public void deleteById(Long assNum) 
	{
		TAssignation assignation = new TAssignation();
		assignation.setAssNum(assNum);
		iservice.deleteObject(assignation);
	}
	
	@Override
	public void delete(TAssignation assignation) 
	{
		iservice.deleteObject(assignation);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TAssignation> findAssignationsByOpeMatricule(String opeMatricule)
	{
		return  iservice.getObjectsByColumn(tableClassName, new WhereClause(opeMatriculeColumn, WhereClause.Comparateur.EQ, opeMatricule));
	}

	@Override
	public int countByTFonction(String tyfCod) 
	{
		return iservice.countTableByColumn(tableName, fonCodColumn, new WhereClause(fonCodColumn, WhereClause.Comparateur.EQ, tyfCod));
	}

	@Override
	public TAssignation saveOrUpdate(TAssignation assignation) 
	{
		return (TAssignation) iservice.mergeAndReturnObject(assignation);
	}

	@Override
	public long countAll() 
	{
		return iservice.countTableByColumn(tableName, idColumn, new WhereClause(idColumn, WhereClause.Comparateur.NEQ, null));
	}

	@Override
	public int countByOpeMatricule(String opeMatricule) 
	{
		return this.iservice.countTableByColumn(tableName, assOpeMatriculeColumn, new WhereClause(assOpeMatriculeColumn, WhereClause.Comparateur.EQ, opeMatricule));
	}

}
