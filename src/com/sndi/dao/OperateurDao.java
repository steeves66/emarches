package com.sndi.dao;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sndi.model.TOperateur;
import com.sndi.model.VOperateurRech;
import com.sndi.service.Iservice;

@Component
public class OperateurDao implements IOperateurDao
{
	@Autowired Iservice iservice;
	private final String tableName = "T_OPERATEUR";
	private final String tableClassName = "TOperateur";
	private final String vOperateurRechClassName = "VOperateurRech";
	private final String idColumn = "OPE_MATRICULE";
	private final String matFoncColumn = "OPE_MATRICULE_FONC";
	private final String mailColumn = "OPE_MAIL";
	private final String loginColumn = "OPE_LOGIN";
	private final String contactColumn = "OPE_CONTACT";
	private final String nomColumn = "OPE_NOM";
	
	@Override
	public TOperateur findById(String opeMatricule) 
	{
		TOperateur operateur = (TOperateur) iservice.getObjectsByColumn(tableClassName, new WhereClause(idColumn, WhereClause.Comparateur.EQ, opeMatricule)).get(0);
		return operateur;
	}
	
	@Override
	public List<TOperateur> findAll() 
	{
		return  iservice.getObjects(tableClassName);
	}

	@Override 
	public TOperateur save(TOperateur operateur) 
	{
		 operateur = (TOperateur)iservice.mergeAndReturnObject(operateur);
		 return operateur;
	}

	@Override
	public TOperateur update(TOperateur operateur) 
	{
		if(!this.existsById(operateur.getOpeMatricule()) || operateur.getOpeMatricule()==null)
		{
			throw new RuntimeException("Impossible de mettre à jour un opérateur qui n'existe pas dans la base");
		}
		operateur = (TOperateur)iservice.mergeAndReturnObject(operateur);
		return operateur;
	}

	@Override
	public void deleteById(String opeMatricule) 
	{
	}

	@Override
	public List<TOperateur> findByOpeLogin(String opeLogin) 
	{
		return  iservice.getObjectsByColumn(tableClassName, new WhereClause(loginColumn, WhereClause.Comparateur.EQ, opeLogin));
	}

	@Override
	public List<TOperateur> findByOpeEmail(String opeEmail) 
	{
		return  iservice.getObjectsByColumn(tableClassName, new WhereClause(mailColumn, WhereClause.Comparateur.EQ, opeEmail));
	}

	@Override
	public List<TOperateur> findByOpeMatriculeFonc(String opeMatriculeFonc) 
	{
		return  iservice.getObjectsByColumn(tableClassName, new WhereClause(matFoncColumn, WhereClause.Comparateur.EQ, opeMatriculeFonc));
	}

	@Override
	public List<TOperateur> findByOpeContact(String opeContact) 
	{
		return  iservice.getObjectsByColumn(tableClassName, new WhereClause(contactColumn, WhereClause.Comparateur.EQ, opeContact));
	}

	@Override
	public List<TOperateur> findByOpeNom(String opeNom) 
	{
		return  iservice.getObjectsByColumn(tableClassName, new WhereClause(nomColumn, WhereClause.Comparateur.EQ, opeNom));
	}

	@Override
	public boolean existsByMatFonc(String matFonc) 
	{
		int nbOperateursTrouves = iservice.countTableByColumn(tableName, matFoncColumn, 
					new WhereClause(matFoncColumn, WhereClause.Comparateur.EQ, matFonc));
		return nbOperateursTrouves > 0;
	}

	@Override
	public boolean existsByLogin(String login) 
	{
		int nbOperateursTrouves = iservice.countTableByColumn(tableName, loginColumn, 
				new WhereClause(loginColumn, WhereClause.Comparateur.EQ, login));
		return nbOperateursTrouves > 0;
	}

	@Override
	public boolean existsByContact(String contact) 
	{
		int nbOperateursTrouves = iservice.countTableByColumn(tableName, contactColumn, 
				new WhereClause(contactColumn, WhereClause.Comparateur.EQ, contact));
		return nbOperateursTrouves > 0;
	}

	@Override
	public boolean existsByMail(String mail)
	{
		int nbOperateursTrouves = iservice.countTableByColumn(tableName, mailColumn, 
				new WhereClause(mailColumn, WhereClause.Comparateur.EQ, mail));
		return nbOperateursTrouves > 0;
	}

	@Override
	public List<TOperateur> findByCritereLibre(String critereLibre) 
	{
		List<VOperateurRech> operateurRetrouves = iservice.getObjectsByColumn(vOperateurRechClassName, new WhereClause("OPE_CLE_RECHER", WhereClause.Comparateur.LIKE, "%" + critereLibre.toUpperCase() +"%" ));
		return operateurRetrouves.stream().map(vOperateur-> vOperateur.getTOperateur()).collect(Collectors.toList());
	}
	@Override
	public boolean existsById(String id) 
	{
		int nbOperateursTrouves = iservice.countTableByColumn(tableName, idColumn, 
				new WhereClause(idColumn, WhereClause.Comparateur.EQ, id));
		return nbOperateursTrouves > 0;
	}

	@Override
	public TOperateur saveOrUpdate(TOperateur operateur) 
	{
		if(operateur.getOpeMatricule() != null)
		{
			if(this.existsById(operateur.getOpeMatricule()))
			{
				operateur  = this.update(operateur);
			}
			else
			{
				operateur = this.save(operateur);
			}
		}
		else
		{
			operateur = this.save(operateur);
		}
		return operateur;
	}

	@Override
	public void delete(TOperateur operateur) 
	{
		this.iservice.deleteObject(operateur);
	}

	@Override
	public long countAll() 
	{
		return iservice.countTableByColumn(tableName, idColumn, new WhereClause(idColumn, WhereClause.Comparateur.NEQ, null));
	}

	@Override
	public List<VOperateurRech> findAllVOperateurRech() 
	{
		return iservice.getObjects(vOperateurRechClassName);
	}

	@Override
	public List<VOperateurRech> findVOperateurRechByCritereLibre(String critereLibre) 
	{
		return iservice.getObjectsByColumn(vOperateurRechClassName, new WhereClause("OPE_CLE_RECHER", WhereClause.Comparateur.LIKE, "%" + critereLibre.toUpperCase() +"%" ));
	}

	@Override
	public List<VOperateurRech> findVOperateurRechByOpeLogin(String opeLogin) 
	{
		return iservice.getObjectsByColumn(vOperateurRechClassName, new WhereClause(loginColumn, WhereClause.Comparateur.EQ, opeLogin));
	}
}