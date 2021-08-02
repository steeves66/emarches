package com.sndi.dao;

import java.util.List;

import com.sndi.model.TAssignation;

public interface IAssignationDao extends ICrudDao<TAssignation, Long> 
{
	List<TAssignation> findAssignationsByOpeMatricule(String opeMatricule);
	int countByTFonction(String tyfCod);
	int countByOpeMatricule(String opeMatricule);
}
