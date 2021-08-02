package com.sndi.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.sndi.dao.IFonctionDao;
import com.sndi.dao.ITypeFonctionDao;
import com.sndi.model.TFonction;
import com.sndi.utilitaires.KeyGen;

import lombok.Data;

@Component @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class FonctionController2 
{
	private TFonction fonction = new TFonction();
	private TFonction updatedFonction = new TFonction();
	private String mode = "new";
	@Autowired IFonctionDao fonctionDao;
	@Autowired ITypeFonctionDao typeFonctionDao;
	@Autowired private AssignationController2 assignationController;
	@Autowired private KeyGen keyGen;
	
	//@PostConstruct
	void init()
	{
		this.fonction.setTTypeFonction( this.typeFonctionDao.findById(this.assignationController.getTyfCod()));
	}
	
	public void saveFonction()
	{
		this.fonctionDao.saveOrUpdate(this.fonction);
		this.refreshFonction();
	}
	
	public void deleteFonction(TFonction fonction)
	{
		this.fonctionDao.delete(fonction);
	}
	
	public void refreshFonction()
	{
		TFonction newFonction = new TFonction();
		newFonction.setTTypeFonction(this.typeFonctionDao.findById(this.assignationController.getTyfCod()));
		newFonction.setTStructure(this.assignationController.getAssignation().getTOperateur().getTStructure());
		newFonction.setFonCod(keyGen.getCodeFonction(this.assignationController.getTyfCod(), this.assignationController.getAssignation().getTOperateur().getTStructure().getStrCode()));
		this.fonction = newFonction;
	}
	
	public void beforeSave()
	{
		this.refreshFonction();
		this.mode = "new";
	}
	
	public void beforeUpdate()
	{
		this.mode = "update";
	}
}
