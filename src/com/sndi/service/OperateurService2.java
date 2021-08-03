package com.sndi.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sndi.dao.IOperateurDao;
import com.sndi.model.TOperateur;
import com.sndi.utilitaires.KeyGen;

import lombok.Getter;
import lombok.Setter;

@Service @Transactional
public class OperateurService2 implements IOperateurService
{
	@Autowired private IOperateurDao operateurDao;
	@Autowired private KeyGen keyGen;
	@Getter @Setter private List<TOperateur> allOperateurs;
	
	@PostConstruct
	void init()
	{
		
	}
	
	@Override
	public TOperateur createOperateur(TOperateur operateur) 
	{
		System.out.println("Debut create OperateurService 2 : L33");
		if (operateur.getOpeMatricule() == null || operateur.getOpeMatricule().equals(""))
		{
			operateur.setOpeMatricule(keyGen.getOperateurCode());
		}
		return operateurDao.save(operateur);
	}

	@Override
	public TOperateur updateOperateur(TOperateur operateur) 
	{
		System.out.println("Debut update OperateurService 2 : L44");
		return operateurDao.update(operateur);
	}

	@Override
	public TOperateur findByMatricule(String matricule) {
		
		return null;
	}

	@Override
	public List<TOperateur> findByCritereLibre(String critereLibre) 
	{
		return operateurDao.findByCritereLibre(critereLibre);
	}
	

	private boolean containsIgnoreCase(String baseString, String searchedString)
	{
		return (baseString == null ? false : baseString.toUpperCase().contains(searchedString.toUpperCase()));
	}

	@Override
	public TOperateur createOrUpdateOperateur(TOperateur operateur) 
	{
		if(operateur.getOpeMatricule() != null)
		{
			System.out.println("Matricule non null");
			if(operateurDao.existsById(operateur.getOpeMatricule()))
			{
				System.out.println("Matricule existant donc update");
				operateur  = this.updateOperateur(operateur);
			}
			else
			{
				System.out.println("Matricule inexistant donc create");
				operateur = this.createOperateur(operateur);
			}
		}
		else
		{
			System.out.println("Matricule null donc create");
			operateur = this.createOperateur(operateur);
		}
		return operateur;
	}

	
}
