package com.sndi.service;

import java.util.List;

import com.sndi.model.TOperateur;

public interface IOperateurService 
{
	public TOperateur createOperateur(TOperateur operateur);
	public TOperateur updateOperateur(TOperateur operateur);
	public TOperateur createOrUpdateOperateur(TOperateur operateur);
	public TOperateur findByMatricule(String matricule);
	public List<TOperateur> findByCritereLibre(String critere);
}