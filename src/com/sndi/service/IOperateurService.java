package com.sndi.service;

import java.util.List;

import com.sndi.model.TOperateur;

public interface IOperateurService 
{
	public TOperateur saveOperateur(TOperateur operateur);
	public TOperateur updateOperateur(TOperateur operateur);
	public TOperateur saveOrUpdateOperateur(TOperateur operateur);
	public TOperateur findByMatricule(String matricule);
	public List<TOperateur> findByCritereLibre(String critere);
}