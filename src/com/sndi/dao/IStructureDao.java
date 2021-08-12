package com.sndi.dao;

import java.util.List;

import com.sndi.model.TStructure;

public interface IStructureDao extends ICrudDao<TStructure, String>
{
	List<TStructure> findByStrCodeOrLibelle(String critere);
	boolean existsByStrCode(String strCode);
}
