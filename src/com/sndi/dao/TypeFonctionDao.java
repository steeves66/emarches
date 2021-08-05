package com.sndi.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sndi.dao.WhereClause;
import com.sndi.model.TTypeFonction;
import com.sndi.model.VTypeFonctionOperateur;
import com.sndi.service.Iservice;

@Component
public class TypeFonctionDao implements ITypeFonctionDao
{
	@Autowired private Iservice iservice;
	private final String tableName = "T_TYPE_FONCTION";
	private final String tableClassName = "TTypeFonction";
	private final String idColumn = "TYF_COD";
	private final String tyfLibelleColumn = "TYF_LIBELLE";
	
	private final String typeFonctionOperateurView = "V_TYPE_FONTION_OPERATEUR";
	private final String typeFonctionOperateurViewClass = "VTypeFonctionOperateur";
	private final String opeMatriculeColumn = "OPE_MATRICULE";

	@Override
	public TTypeFonction findById(String id) 
	{
		return  (TTypeFonction) iservice.getObjectsByColumn(tableClassName, new WhereClause(idColumn, WhereClause.Comparateur.EQ, id)).get(0);
	}

	@Override
	public List<TTypeFonction> findAll() 
	{
		return iservice.getObjects(tableClassName);
	}

	@Override
	public TTypeFonction save(TTypeFonction typeFonction) 
	{
		return  (TTypeFonction) iservice.mergeAndReturnObject(typeFonction);
	}

	@Override
	public TTypeFonction update(TTypeFonction typeFonction) 
	{
		iservice.updateObject(typeFonction);
		return typeFonction;
	}

	@Override
	public void deleteById(String id) 
	{
		TTypeFonction typeFonction = this.findById(id);
		iservice.deleteObject(typeFonction);
	}

	@Override
	public List<TTypeFonction> findByTyfLibelleContains(String tyfLibelle) 
	{
		List<TTypeFonction> typeFonctionsRetrouves= iservice.getObjectsByColumn(tableClassName, new WhereClause(tyfLibelleColumn, WhereClause.Comparateur.LIKE, "%" + tyfLibelle +"%"));
		return typeFonctionsRetrouves;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TTypeFonction saveOrUpdate(TTypeFonction entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TTypeFonction entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long countAll() 
	{
		return iservice.countTableByColumn(tableName, idColumn, new WhereClause(idColumn, WhereClause.Comparateur.NEQ, null));
	}

	@Override
	public List<TTypeFonction> findByOpeMatricule(String opeMatricule) 
	{
		List<VTypeFonctionOperateur> listTypeFonctionOperateur = iservice.getObjectsByColumn(typeFonctionOperateurViewClass, new WhereClause(opeMatriculeColumn, WhereClause.Comparateur.EQ, opeMatricule));
		return listTypeFonctionOperateur.stream().map(tfo->tfo.getTypeFonction()).collect(Collectors.toList());
	}
}
