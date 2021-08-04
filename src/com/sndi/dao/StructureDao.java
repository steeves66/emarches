package com.sndi.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sndi.dao.WhereClause;
import com.sndi.model.TStructure;
import com.sndi.service.Iservice;

import lombok.Getter;

@Component
public class StructureDao implements IStructureDao 
{
	@Autowired private Iservice iservice;
	
	private final String tableName = "T_STRUCTURE";
	private final String tableClassName = "TStructure";
	private final String idColumn = "STR_CODE";
	
	@Getter private List<TStructure> listStructures;
	
	@PostConstruct
	void init()
	{
		this.listStructures = this.iservice.getObjects(tableClassName);
	}
	@Override
	public TStructure findById(String id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TStructure> findAll() 
	{
		return this.iservice.getObjects(tableClassName);
	}

	@Override
	public TStructure save(TStructure entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TStructure update(TStructure entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TStructure saveOrUpdate(TStructure entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(TStructure entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public long countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<TStructure> findByStrCodeOrLibelle(String critere) 
	{
		List<TStructure> structuresTrouves =  this.iservice.getObjects(tableClassName);
		return structuresTrouves.stream().filter(str->
		{
			return (str.getStrCode().toUpperCase().contains(critere.toUpperCase()) ||
					str.getStrLibelleLong().toUpperCase().contains(critere.toUpperCase()));
		}).collect(Collectors.toList());
	}
	@Override
	public boolean existsByStrCode() 
	{
		return this.iservice.countTableByColumn(tableName, idColumn, new WhereClause(idColumn, WhereClause.Comparateur.EQ, idColumn))>=1;
	}

}
