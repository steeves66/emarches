package com.sndi.controller.commission;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.controller.custom.ControleController;
import com.sndi.controller.tableauBord.TableauBordController;
import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
import com.sndi.model.TAffichageDao;
import com.sndi.model.TAvisAppelOffre;
import com.sndi.model.TDossierDacs;
import com.sndi.model.TOffres;
import com.sndi.model.VDetailCommission;
import com.sndi.model.VDetailDao;
import com.sndi.model.VLotDao;
import com.sndi.model.VPiecesOffre;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.FileUploadController;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class EtatsCommissionController {
	Logger _logger = Logger.getLogger(EtatsCommissionController.class);
	@Autowired
	Iservice iservice;
	@Autowired
	UserController userController;
	@Autowired
	KeyGen keyGen;
	 @Autowired
	ProjetReport projetReport;
	 @Autowired
	ControleController controleController;
	 @Autowired
	FileUploadController fileUploadController;
	 
	 @Autowired
	 DownloadFileServlet downloadFileServlet;
	 
	 @Autowired
	 TableauBordController tableauBordController;
	 
	 
	 private List<VDetailCommission> objetListe = new ArrayList<VDetailCommission>(); 
	 private List<VPiecesOffre> piecesListe = new ArrayList<VPiecesOffre>();
	 private List<VLotDao> lotListe = new ArrayList<VLotDao>();
	 //private TOffres slctdTd = new TOffres();
	 private TAvisAppelOffre slctdTd = new TAvisAppelOffre();
	 //Les variables
	 private VDetailCommission detail = new VDetailCommission(); 
	 
	 
	 @PostConstruct
	 public void postContr() {
		//controleController.fonctionaliteDynamic();
		chargeDetailDepot();
	 }
	 
	 
	 
	 
	//Afficher les détails du DAO
	 public void chargeDetailDepot(){
			objetListe =(List<VDetailCommission>) iservice.getObjectsByColumn("VDetailCommission", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					new WhereClause("AAO_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getAaoCode()));
			if (!objetListe.isEmpty()) {
				detail=objetListe.get(0);
				chargePieces();
				chargeLot();
			}
		}
	 
	//Afficher les lot de l'avis selectionné
	    public void chargeLot() {
	 	lotListe.clear();
	 	lotListe = ((List<VLotDao>)iservice.getObjectsByColumn("VLotDao",new ArrayList<String>(Arrays.asList("LAA_ID")),
	 	new WhereClause("LAA_DAC_CODE",Comparateur.EQ,""+detail.getAaoDacCode()))); 		 
	 		 }
	 
	 
	//Afficher les dossiers du DAO selectionné
	    public void chargePieces() {
	    	piecesListe.clear();
	    	piecesListe = ((List<VPiecesOffre>)iservice.getObjectsByColumn("VPiecesOffre",new ArrayList<String>(Arrays.asList("OPD_NUM")),
	 	         new WhereClause("OPD_DAC_CODE",Comparateur.EQ,""+detail.getAaoDacCode()),
	 	         new WhereClause("ODP_TPO_ETAP_PIECE",Comparateur.EQ,""+controleController.getOpdPiece()))); 		 
	 		 }
	 
	 

	 public String renderPage(String value ,String action) throws IOException{
		 controleController.redirectionDynamicProcedures(action);
	   		switch(value) {
	   		case "detc1":
	   			chargeDetailDepot();
	   		_logger.info("value: "+value+" action "+action);
	   		break;
	   		case "detc2":
	   			_logger.info("value: "+value+" action "+action);	
	    	break; 
	   		case "detc3":
	   			_logger.info("value: "+value+" action "+action);	
	    	break;
	   		}
	   		
	   		return userController.renderPage(value);
	   	}




	public List<VPiecesOffre> getPiecesListe() {
		return piecesListe;
	}

	public void setPiecesListe(List<VPiecesOffre> piecesListe) {
		this.piecesListe = piecesListe;
	}



	public List<VDetailCommission> getObjetListe() {
		return objetListe;
	}



	public void setObjetListe(List<VDetailCommission> objetListe) {
		this.objetListe = objetListe;
	}



	public VDetailCommission getDetail() {
		return detail;
	}



	public void setDetail(VDetailCommission detail) {
		this.detail = detail;
	}


	public List<VLotDao> getLotListe() {
		return lotListe;
	}

	public void setLotListe(List<VLotDao> lotListe) {
		this.lotListe = lotListe;
	}


	public TAvisAppelOffre getSlctdTd() {
		return slctdTd;
	}

	public void setSlctdTd(TAvisAppelOffre slctdTd) {
		this.slctdTd = slctdTd;
	}
	
	  
}
