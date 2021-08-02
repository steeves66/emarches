package com.sndi.dao;

import java.util.List;

import com.sndi.model.TTypeFonction;

public interface ITypeFonctionDao extends ICrudDao<TTypeFonction, String> 
{
	List<TTypeFonction> findByTyfLibelleContains(String tyfLibelle);
	List<TTypeFonction> findByOpeMatricule(String strCode);
}
