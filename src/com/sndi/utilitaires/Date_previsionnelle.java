package com.sndi.utilitaires;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.VDatePlanPassation;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;


public class Date_previsionnelle {
	Logger _logger = Logger.getLogger(SendSms.class);
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	
	@Autowired
	KeyGen keyGen;
	
	 @Autowired
	ProjetReport projetReport;
	 
	private List<VDatePlanPassation> listeDates = new ArrayList<VDatePlanPassation>();
	
	
	//Afficher les dates
		 public void chargeDates(long idPpm) {
			setListeDates(((List<VDatePlanPassation>)
					iservice.getObjectsByColumn("VDatePlanPassation",
				    new WhereClause("DPL_DDP_ID",Comparateur.EQ,""+idPpm))));
		 }
		public List<VDatePlanPassation> getListeDates() {
			return listeDates;
		}
		public void setListeDates(List<VDatePlanPassation> listeDates) {
			this.listeDates = listeDates;
		}
}
