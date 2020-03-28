package com.sndi.controller.tableauBord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.dao.WhereClause;
import com.sndi.model.TAgpm;
import com.sndi.model.TDetailPlanGeneral;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TDossierDacs;
import com.sndi.model.THistoDac;
import com.sndi.model.TStatut;
import com.sndi.model.VDetailDao;
import com.sndi.model.VPpmPgpm;
import com.sndi.report.ProjetReport;
import com.sndi.security.UserController;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;

@Component
@Scope(value="session")
public class SituationController {
	Logger _logger = Logger.getLogger(SituationController.class);
	
	@Autowired
	Iservice iservice;
	
	@Autowired
	UserController userController;
	@Autowired
	KeyGen keyGen;
	 @Autowired
	ProjetReport projetReport;
	 
	 
	 @PostConstruct
	 public void postContr() {
		 
	 }
	 
	

	private List<VDetailDao> objetListe = new ArrayList<VDetailDao>();
	private List<TStatut> listStat = new ArrayList<TStatut>();
	private List<TDossierDacs> dossListe = new ArrayList<TDossierDacs>();
	private List<THistoDac> listHistoStat = new ArrayList<THistoDac>();
	private List<TDetailPlanPassation> listPpmStat = new ArrayList<TDetailPlanPassation>();
	private List<VPpmPgpm> listPgpmStat = new ArrayList<VPpmPgpm>();
	private List<TAgpm> listAgpm = new ArrayList<TAgpm>();
	private TStatut Stat = new TStatut();
	private TDetailPlanPassation ppm = new TDetailPlanPassation();
	private VDetailDao detail = new VDetailDao(); 
	private VPpmPgpm repPpm = new VPpmPgpm();
	private TAgpm agpm = new TAgpm();
	private String page;
	private String critere;
	private String filter="";
    private Date filtreByDate;
    private Date filterDate;
	private Date dateDeb;
	private Date dateFin;
	
	
	
	
	
	
	public void rechercheDossier(){
		objetListe =(List<VDetailDao>) iservice.getObjectsByColumn("VDetailDao", new ArrayList<String>(Arrays.asList("dacCode")),
				new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+critere),
				new WhereClause("DAC_STR_CODE",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getTStructure().getStrCode()));
		if (!objetListe.isEmpty()) {
			detail=objetListe.get(0);
			recupStat();
			recupHisto();
			recupPPM();
		}else {
			vider();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ce code de dossier n'est pas attribué", ""));
		}	
	}
	
	
	public void recupStat() {
		listStat =(List<TStatut>) iservice.getObjectsByColumn("TStatut", new ArrayList<String>(Arrays.asList("STA_CODE")),
				new WhereClause("STA_CODE",WhereClause.Comparateur.EQ,""+detail.getDacStaCode()));
		if (!listStat.isEmpty()) {
			Stat=listStat.get(0);
		}
	}
	
	public void recupHisto() {
		listHistoStat =(List<THistoDac>) iservice.getObjectsByColumn("THistoDac", new ArrayList<String>(Arrays.asList("HAC_ID")),
				new WhereClause("HAC_DAC_CODE",WhereClause.Comparateur.EQ,""+detail.getDacCode()));	
	}
	
	public void recupPPM() {
		listPpmStat =(List<TDetailPlanPassation>) iservice.getObjectsByColumn("TDetailPlanPassation", new ArrayList<String>(Arrays.asList("DPP_ID")),
				new WhereClause("DPP_DAC_CODE",WhereClause.Comparateur.EQ,""+detail.getDacCode()));
		if (!listPpmStat.isEmpty()) {
			ppm=listPpmStat.get(0);
			recupPGPM();
		}
	}
	
	
	public void recupPGPM() {
		listPgpmStat =(List<VPpmPgpm>) iservice.getObjectsByColumn("VPpmPgpm", new ArrayList<String>(Arrays.asList("DPP_ID")),
				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+ppm.getDppId()));
		if (!listPgpmStat.isEmpty()) {
			repPpm=listPgpmStat.get(0);
			recupAGPM();
		}
	}
	
	public void recupAGPM() {
		listAgpm =(List<TAgpm>) iservice.getObjectsByColumn("TAgpm", new ArrayList<String>(Arrays.asList("AGP_ID")),
				new WhereClause("AGP_ID",WhereClause.Comparateur.EQ,""+repPpm.getGpgAgpId()));
	}
	
	
	 public void vider() {
		 objetListe.clear();
		 listStat.clear();
		 listHistoStat.clear();
		 listPpmStat.clear();
		 detail=new VDetailDao();
		 Stat = new TStatut();
		 ppm = new TDetailPlanPassation();
	 }
	
	
	
	
	
	
	
	 public List<VDetailDao> getObjetListe() {
			return objetListe;
		}

		public void setObjetListe(List<VDetailDao> objetListe) {
			this.objetListe = objetListe;
		}

		public VDetailDao getDetail() {
			return detail;
		}

		public void setDetail(VDetailDao detail) {
			this.detail = detail;
		}

		public String getPage() {
			return page;
		}

		public void setPage(String page) {
			this.page = page;
		}

		public String getFilter() {
			return filter;
		}

		public void setFilter(String filter) {
			this.filter = filter;
		}

		public Date getDateDeb() {
			return dateDeb;
		}

		public void setDateDeb(Date dateDeb) {
			this.dateDeb = dateDeb;
		}

		public Date getDateFin() {
			return dateFin;
		}

		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}

		public String getCritere() {
			return critere;
		}

		public void setCritere(String critere) {
			this.critere = critere;
		}


		public List<TStatut> getListStat() {
			return listStat;
		}


		public void setListStat(List<TStatut> listStat) {
			this.listStat = listStat;
		}


		public List<TDossierDacs> getDossListe() {
			return dossListe;
		}


		public void setDossListe(List<TDossierDacs> dossListe) {
			this.dossListe = dossListe;
		}


		public TStatut getStat() {
			return Stat;
		}


		public void setStat(TStatut stat) {
			Stat = stat;
		}


		public Date getFiltreByDate() {
			return filtreByDate;
		}


		public void setFiltreByDate(Date filtreByDate) {
			this.filtreByDate = filtreByDate;
		}


		public Date getFilterDate() {
			return filterDate;
		}


		public void setFilterDate(Date filterDate) {
			this.filterDate = filterDate;
		}


		public List<TDetailPlanPassation> getListPpmStat() {
			return listPpmStat;
		}


		public void setListPpmStat(List<TDetailPlanPassation> listPpmStat) {
			this.listPpmStat = listPpmStat;
		}


		public TDetailPlanPassation getPpm() {
			return ppm;
		}


		public void setPpm(TDetailPlanPassation ppm) {
			this.ppm = ppm;
		}


		public List<VPpmPgpm> getListPgpmStat() {
			return listPgpmStat;
		}


		public void setListPgpmStat(List<VPpmPgpm> listPgpmStat) {
			this.listPgpmStat = listPgpmStat;
		}


		public VPpmPgpm getRepPpm() {
			return repPpm;
		}


		public void setRepPpm(VPpmPgpm repPpm) {
			this.repPpm = repPpm;
		}


		public List<TAgpm> getListAgpm() {
			return listAgpm;
		}


		public void setListAgpm(List<TAgpm> listAgpm) {
			this.listAgpm = listAgpm;
		}


		public TAgpm getAgpm() {
			return agpm;
		}


		public void setAgpm(TAgpm agpm) {
			this.agpm = agpm;
		}

}
