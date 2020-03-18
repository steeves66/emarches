package com.sndi.security;


import java.util.List;

import com.sndi.model.TAssignation;
import com.sndi.model.TMotdepasse;
import com.sndi.model.TOperateur;
import com.sndi.model.TTypeFonction;
import com.sndi.utilitaires.AutorityClass;

public interface IUserService {
	
	public List<TAssignation> getListeAssignations(TOperateur operateur);
//	public Fonction getFonction(Employes operateur);
	public TMotdepasse getMotPasse(TOperateur operateur);
	public AutorityClass cleanAutority();
	public AutorityClass getAutorisation(AutorityClass autority, TTypeFonction typeFonction);
}
