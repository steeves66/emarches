package com.sndi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sndi.dao.IOperateurDao;
import com.sndi.model.TOperateur;
import com.sndi.utilitaires.KeyGen;

@Service @Transactional
public class OperateurService2 implements IOperateurService
{
	@Autowired private IOperateurDao operateurDao;
	@Autowired private KeyGen keyGen;
	
	@Override
	public TOperateur saveOperateur(TOperateur operateur) 
	{
		if (operateur.getOpeMatricule() == null || operateur.getOpeMatricule().equals(""))
		{
			operateur.setOpeMatricule(keyGen.getOperateurCode());
		}
		return operateurDao.save(operateur);
	}

	@Override
	public TOperateur updateOperateur(TOperateur operateur) 
	{
		return operateurDao.update(operateur);
	}

	@Override
	public TOperateur findByMatricule(String matricule) 
	{
		return this.operateurDao.findById(matricule);
	}

	@Override
	public List<TOperateur> findByCritereLibre(String critereLibre) 
	{
		return operateurDao.findByCritereLibre(critereLibre);
	}

	@Override
	public TOperateur saveOrUpdateOperateur(TOperateur operateur) 
	{
		return this.operateurDao.saveOrUpdate(operateur);
	}
}
