package com.sndi.dao;

import java.util.List;

public interface ICrudDao<T, ID>
{
	T findById(ID id);
	List<T> findAll();
	T save(T entity);
	T update(T entity);
	T saveOrUpdate(T entity);
	void deleteById(ID id);
	void delete(T entity);
	long countAll();
	
	
	boolean existsById(ID id);
}