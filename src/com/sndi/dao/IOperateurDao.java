package com.sndi.dao;

import java.util.List;

import com.sndi.model.TOperateur;
import com.sndi.model.VOperateurRech;

public interface IOperateurDao extends ICrudDao<TOperateur, String>
{
	List<TOperateur> findByCritereLibre(String critereLibre);
	List<TOperateur> findByOpeLogin(String opeLogin);
	List<TOperateur> findByOpeEmail(String opeEmail);
	List<TOperateur> findByOpeMatriculeFonc(String opeMatriculeFonc);
	List<TOperateur> findByOpeContact(String opeContact);
	
	VOperateurRech findVOperateurRechByOpeMatricule(String opeMatricule);
	List<VOperateurRech> findAllVOperateurRech();
	List<VOperateurRech> findVOperateurRechByCritereLibre(String critereLibre);
	List<VOperateurRech> findVOperateurRechByOpeLogin(String opeLogin);
	
	List<TOperateur> findByOpeNom(String opeNom);
	
	boolean existsByMatFonc(String matFonc);
	boolean existsByLogin(String login);
	boolean existsByContact(String contact);
	boolean existsByMail(String mail);
	
}
