package com.sndi.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sndi.model.TFonction;
import com.sndi.model.VFonctionAssignationRech;
import com.sndi.service.Iservice;

@Component 
public class FonctionDao implements IFonctionDao
{
	@Autowired
	private Iservice iservice;
	private final String tableName = "T_FONCTION";
	private final String tableClassName = "TFonction";
	private final String idColumn = "fonCod";
	private final String searchColumn = "FON_RECH";
	private final String strCodeColumn = "FON_STR_CODE";
	private final String fontyfCodColumn = "FON_TYF_COD";
	private final String fonctionAssignationRechView = "VFonctionAssignationRech";

	@Override
	public TFonction findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TFonction> findAll() {
		return null;
	}

	@Override
	public TFonction save(TFonction fonction) 
	{
		return (TFonction)iservice.mergeAndReturnObject(fonction);
	}

	@Override
	public TFonction update(TFonction fonction) 
	{
		if(fonction.getFonCod() == null)
		{
			throw new RuntimeException("Impossible de modifier une fonction qui n'existe pas dans la base");
		}
		else if(!this.existsById(fonction.getFonCod()))
		{
			throw new RuntimeException("Impossible de modifier une fonction qui n'existe pas dans la base");
		}
		return (TFonction)iservice.mergeAndReturnObject(fonction);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TFonction> findByTyfCode(String tyfCode) 
	{
		return iservice.getObjectsByColumn(tableClassName, new WhereClause(fontyfCodColumn, WhereClause.Comparateur.EQ, tyfCode));
	}

	@Override
	public boolean existsById(String fonCode) 
	{
		return (0 < iservice.countTableByColumn(tableName, idColumn, new WhereClause(idColumn, WhereClause.Comparateur.EQ, fonCode)));
	}

	@Override
	public List<TFonction> findByTyfCodAndCritereLibre(String tyfCod, String critereRechercheFonction) 
	{
		List<TFonction> listFonctions = this.findByTyfCode(tyfCod);
		List<TFonction> listFonctionFiltres = listFonctions.stream()
										   				   .filter(fon-> (fon.getFonCod().toLowerCase().contains(critereRechercheFonction) ||fon.getFonLibelle().toLowerCase().contains(critereRechercheFonction)))
										   				   .collect(Collectors.toList());
		return listFonctionFiltres;
	}

	@Override
	public void delete(TFonction fonction) 
	{
		this.iservice.deleteObject(fonction);
	}

	@Override
	public TFonction saveOrUpdate(TFonction fonction) 
	{
		if(fonction.getFonCod() == null)
		{
			throw new RuntimeException("Le code de la fonction ne doit pas être null");
		}
		else if(this.existsById(fonction.getFonCod()))
		{
			return this.update(fonction);
		}
		else if(!this.existsById(fonction.getFonCod()))
		{
			return this.save(fonction);
		}
		return (TFonction)iservice.mergeAndReturnObject(fonction);
	}

	@Override
	public long countAll()
	{
		return iservice.countTableByColumn(tableName, idColumn, new WhereClause(idColumn, WhereClause.Comparateur.NEQ, null));
	}
	@Override
	public List<VFonctionAssignationRech> findFonctionAssignationByStrCodeAndTyfCodAndCritereLibre(String strCode, String tyfCod, String critereRechercheFonction) 
	{	
		List<VFonctionAssignationRech> listFonctionAssignationRech = this.iservice.getObjectsByColumn
											(
												fonctionAssignationRechView, 
												new WhereClause(this.searchColumn, WhereClause.Comparateur.LIKE, "%" + critereRechercheFonction.toUpperCase() + "%"),
												new WhereClause(this.strCodeColumn, WhereClause.Comparateur.EQ,strCode),
												new WhereClause(this.fontyfCodColumn, WhereClause.Comparateur.EQ,tyfCod)
											);
		return listFonctionAssignationRech;
	}
	@Override
	public List<TFonction> findByStrCodeAndTyfCodAndCritereLibre(String strCode, String tyfCod,
			String critereRechercheFonction) 
	{
		List<VFonctionAssignationRech> listFonctionAssignationRech = this.iservice.getObjectsByColumn
		(
			fonctionAssignationRechView, 
			new WhereClause(this.searchColumn, WhereClause.Comparateur.LIKE, "%"+critereRechercheFonction.toUpperCase() + "%"),
			new WhereClause(this.strCodeColumn, WhereClause.Comparateur.EQ,strCode),
			new WhereClause(this.fontyfCodColumn, WhereClause.Comparateur.EQ,tyfCod)
		);
		return listFonctionAssignationRech.stream()
										  .map(fonctionAssignation->fonctionAssignation
										  .getFonction()).collect(Collectors.toList());
	}
}
