package com.sndi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sndi.dao.WhereClause;
import com.sndi.model.TAssignation;
import com.sndi.model.TFonction;
import com.sndi.model.TOperateur;

@org.springframework.stereotype.Service
public class ServiceProvider {
	private static Logger _logger = Logger.getLogger(ServiceProvider.class);
	private static ResourceBundle _properties = null;
	
	@Autowired
	Iservice iservice;
	
	  

	public TAssignation getAssignationByFonction(TFonction f){
		List<TAssignation> al =  iservice.getObjectsByColumn("TAssignation", new ArrayList<String>(Arrays.asList("assNum")),
				new WhereClause("FON_COD", WhereClause.Comparateur.EQ, f.getFonCod()),
				new WhereClause("ASS_STATUT", WhereClause.Comparateur.EQ, "1"));
		  _logger.info("Assign by Fonc.size :"+ al.size());
		  return al.isEmpty() == true ? null : al.get(0);
	}
	
	public List<TAssignation>  getAssignationByOperateur(TOperateur o){
		List<TAssignation> al =  iservice.getObjectsByColumn("TAssignation", new ArrayList<String>(Arrays.asList("assNum")),
				new WhereClause("OPE_MATRICULE", WhereClause.Comparateur.EQ, o.getOpeMatricule()));
		_logger.info("Assign by Ope.size :"+ al.size());
		return al;
	}
	
		


}
