package com.sndi.controller.tableauBord;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.sndi.controller.custom.ControleController;
import com.sndi.dao.WhereClause;
import com.sndi.model.TAgpm;
import com.sndi.model.TDacSpecs;
import com.sndi.model.TDetailPlanPassation;
import com.sndi.model.TDossierDacs;
import com.sndi.model.THistoDac;
import com.sndi.model.TLotAao;
import com.sndi.model.TStatut;
import com.sndi.model.VDacStatut;
import com.sndi.model.VDacliste;
import com.sndi.model.VDetailDao;
import com.sndi.model.VDetailHistoDac;
import com.sndi.model.VDetailHistoPpm;
import com.sndi.model.VLotCritere;
import com.sndi.model.VPpmPgpm;
import com.sndi.model.VPpmStatut;
import com.sndi.model.VPpmliste;
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
	 
	 @Autowired
	ControleController controleController;
	 
	 
	 
	 
	 
	 @PostConstruct
	 public void postContr() {
		 
	 }
	 
	

	private List<VDetailDao> objetListe = new ArrayList<VDetailDao>();
	private List<VPpmStatut> listHistoPpm = new ArrayList<VPpmStatut>();
	private List<TStatut> listStat = new ArrayList<TStatut>();
	private List<VDetailHistoDac> listDetailHist = new ArrayList<VDetailHistoDac>();
	private List<TDossierDacs> dossListe = new ArrayList<TDossierDacs>();
	private List<THistoDac> listHistoStat = new ArrayList<THistoDac>();
	private List<VDacStatut> listHistoDac = new ArrayList<VDacStatut>();
	private List<VDacliste> listeDAC = new ArrayList<VDacliste>();
	private List<VPpmliste> listeConsultationPpm = new ArrayList<VPpmliste>();
	private List<TDetailPlanPassation> listPpmStat = new ArrayList<TDetailPlanPassation>();
	private List<TDossierDacs> listDossierDac = new ArrayList<TDossierDacs>();
	private List<TLotAao> listeLotsAvis= new ArrayList<TLotAao>();
	private List<TDacSpecs> listDacPaPeriode = new ArrayList<TDacSpecs>();
	private List<VPpmPgpm> listPgpmStat = new ArrayList<VPpmPgpm>();
	private List<VPpmliste> listePpmParPeriode = new ArrayList<VPpmliste>();
	private List<TAgpm> listAgpm = new ArrayList<TAgpm>();
	private List<VDetailHistoPpm> listDetailHistPpm = new ArrayList<VDetailHistoPpm>();
	private TStatut stat = new TStatut();
	private VDetailHistoDac detailHisto = new VDetailHistoDac();
	private VDetailHistoPpm detailHistoPpm = new VDetailHistoPpm();
	private TDetailPlanPassation ppm = new TDetailPlanPassation();
	private VDetailDao detail = new VDetailDao(); 
	private VPpmliste slctdTdPpm = new VPpmliste();
	private VDacliste slctdTd = new VDacliste();
	private VPpmPgpm repPpm = new VPpmPgpm();
	private TAgpm agpm = new TAgpm();
	private String page;
	private String critere;
	private String filter="";
    private Date filtreByDate;
    private Date filterDate;
	private Date dateDeb;
	private Date dateFin;
	
	
	//Afficharge des plans de passations entre deux periodes
	public void chargePlanPassationByPeriode() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		String dated = df.format(dateDeb);
		String datef = df.format(dateFin);
		String dd = "TO_DATE('"+dated+"',"+ "'"+"DD/MM/YY"+"'"+","+"'"+"NLS_DATE_LANGUAGE = FRENCH"+"'"+")" ;
		String dfin = "TO_DATE('"+datef+"',"+ "'"+"DD/MM/YY"+"'"+","+"'"+"NLS_DATE_LANGUAGE = FRENCH"+"'"+")" ;	
		listePpmParPeriode.clear();
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 listePpmParPeriode =  (List<VPpmliste>)iservice.getObjectsByColumnNotQuote("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DATE_SAISIE")),
						new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,"'"+userController.getSlctd().getTFonction().getFonCod()+"'"),
						new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NEQ,"'SDS'"),
						new WhereClause("DPP_DATE_SAISIE",WhereClause.Comparateur.BET,dd+" AND "+dfin));
				_logger.info("listePpm size: "+listePpmParPeriode.size());	
		 }else {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				/* listePpmParPeriode = (List<VPpmliste>) iservice.getObjectsByColumnNotQuote("VPpmliste", 
							"DPP_STA_CODE", new ArrayList<String>(Arrays.asList("S1S","S2D","SPR")),
							new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,"'"+userController.getSlctd().getTFonction().getFonCod()+"'"),
							new WhereClause("DPP_DATE_SAISIE",WhereClause.Comparateur.BET,dd+" AND "+dfin));
					_logger.info("listePpmParPeriode size: "+listePpmParPeriode.size());*/
			 }else {
				 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("DMP")) {
					 listePpmParPeriode =  (List<VPpmliste>)iservice.getObjectsByColumnNotQuote("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DATE_SAISIE")),
								new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,"'"+userController.getSlctd().getTFonction().getFonCod()+"'"),
								new WhereClause("DPP_DATE_SAISIE",WhereClause.Comparateur.BET,dd+" AND "+dfin));
						_logger.info("listePpm size: "+listePpmParPeriode.size());	
			         
				 }else 
					  if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("SPP")) {
						  listePpmParPeriode =  (List<VPpmliste>)iservice.getObjectsByColumnNotQuote("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DATE_SAISIE")),
									new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,"'"+userController.getSlctd().getTFonction().getFonCod()+"'"),
									new WhereClause("DPP_DATE_SAISIE",WhereClause.Comparateur.BET,dd+" AND "+dfin));
							_logger.info("listePpmParPeriode size: "+listePpmParPeriode.size());	
		     } 
		   }
		 }

		
		

		if(listePpmParPeriode.isEmpty()){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN," Opération(s) non trouvé(s) pour la période de ->"+dated+" à ->"+datef, "")); 
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,listePpmParPeriode.size()+" Opération(s) trouveé(s) pour la période du ->"+dated+" au ->"+datef, ""));
		}
	}
	
	
	
	
	public void rechercheDossier1(){
		
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 listeDAC =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
					    new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+critere+"%"),
						new WhereClause("DAC_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"),
						new WhereClause("DAC_FON_COD_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				//recupStat();
				//recupDetailHisto();
				/*if (!objetListe.isEmpty()) {
				 //
				}else {
					vider();
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ce code de dossier n'est pas attribué", ""));
				}	*/
		 }else {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				 listeDAC =(List<VDacliste>) iservice.getObjectsByColumn("VDacliste", new ArrayList<String>(Arrays.asList("DAC_DTE_MODIF")),
							new WhereClause("CRITERE",WhereClause.Comparateur.EQ,""+critere),
							new WhereClause("FON_CODE_PF",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					recupStat();
					recupDetailHisto();
					/*if (!objetListe.isEmpty()) {
					 //
					}else {
						vider();
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ce code de dossier n'est pas attribué", ""));
					}	*/
				 
			 }else {
					listHistoDac =(List<VDacStatut>) iservice.getObjectsByColumn("VDacStatut",
							new WhereClause("HAC_DAC_CODE",WhereClause.Comparateur.EQ,""+critere));
					recupStat();
					recupDetailHisto();
				
		 }
	 
		 }
	
	}
	
	public void recherchePpmConsultation(){
		listeConsultationPpm.clear();
		 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("ACR")) {
			 listeConsultationPpm =(List<VPpmliste>) iservice.getObjectsByColumn("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
					    new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+critere+"%"),
						new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"),
						new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				//recupStat();
				//recupDetailHisto();
				if (listeConsultationPpm.size()==0) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dossier introuvable", ""));
				}
		 }else {
			 if(userController.getSlctd().getTFonction().getTTypeFonction().getTyfCod().equalsIgnoreCase("CPM")) {
				 listeConsultationPpm =(List<VPpmliste>) iservice.getObjectsByColumn("VPpmliste", new ArrayList<String>(Arrays.asList("DPP_DTE_MODIF")),
						    new WhereClause("CRITERE",WhereClause.Comparateur.LIKE,"%"+critere+"%"),
							new WhereClause("DPP_STA_CODE",WhereClause.Comparateur.NEQ,"SDS"),
							new WhereClause("LBG_FON_CODE_AC",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
					recupStatPpm();
					recupDetailHistoPpm();
					/*if (!objetListe.isEmpty()) {
					 //
					}else {
						vider();
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ce code de dossier n'est pas attribué", ""));
					}	*/
				 
			 }else {
				
				    recupStatPpm();
					recupDetailHistoPpm();
				
		 }
	 
		 }
	
	}


	public void rechercheDossier(){
				listHistoDac =(List<VDacStatut>) iservice.getObjectsByColumn("VDacStatut",
						new WhereClause("HAC_DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()),
						new WhereClause("FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod()));
				recupStat();
				recupDetailHisto();
	}
	
	
	
	public void recupDetailPpm(){
		listHistoPpm =(List<VPpmStatut>) iservice.getObjectsByColumn("VPpmStatut",
				new WhereClause("HPP_DPP_ID",WhereClause.Comparateur.EQ,""+slctdTdPpm.getDppId()),
				new WhereClause("FON_COD",WhereClause.Comparateur.EQ,userController.getSlctd().getTFonction().getFonCod())
				);
		recupStatPpm();
		recupDetailHistoPpm();
}
	
	
	public void recupStat() {
		listStat =(List<TStatut>) iservice.getObjectsByColumn("TStatut", new ArrayList<String>(Arrays.asList("STA_CODE")),
				new WhereClause("STA_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		if (!listStat.isEmpty()) {
			stat=listStat.get(0);
		}
	}
	
	
	public void recupDetailHisto() {
		listDetailHist =(List<VDetailHistoDac>) iservice.getObjectsByColumn("VDetailHistoDac",
				new WhereClause("DAC_CODE",WhereClause.Comparateur.EQ,""+slctdTd.getDacCode()));
		if (!listDetailHist.isEmpty()) {
			detailHisto=listDetailHist.get(0);
		}
	}
	

	//Statut ppm
	public void recupStatPpm() {
		listStat =(List<TStatut>) iservice.getObjectsByColumn("TStatut", new ArrayList<String>(Arrays.asList("STA_CODE")),
				new WhereClause("STA_CODE",WhereClause.Comparateur.EQ,""+slctdTdPpm.getDppId()));
		if (!listStat.isEmpty()) {
			stat=listStat.get(0);
		}
	}
	
	
	//Historique ppm
	public void recupDetailHistoPpm() {
		listDetailHistPpm =(List<VDetailHistoPpm>) iservice.getObjectsByColumn("VDetailHistoPpm",
				new WhereClause("DPP_ID",WhereClause.Comparateur.EQ,""+slctdTdPpm.getDppId()));
		if (!listDetailHistPpm.isEmpty()) {
			setDetailHistoPpm(listDetailHistPpm.get(0));
		}
	}

	
	
	public void ReqParPeriode() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		String dated = df.format(dateDeb);
		String datef = df.format(dateFin);
		String dd = "TO_DATE('"+dated+"',"+ "'"+"DD/MM/YY"+"'"+","+"'"+"NLS_DATE_LANGUAGE = FRENCH"+"'"+")" ;
		String dfin = "TO_DATE('"+datef+"',"+ "'"+"DD/MM/YY"+"'"+","+"'"+"NLS_DATE_LANGUAGE = FRENCH"+"'"+")" ;	
		
		listDacPaPeriode =  (List<TDacSpecs>)iservice.getObjectsByColumnNotQuote("TDacSpecs", new ArrayList<String>(Arrays.asList("DAC_CODE")),
					new WhereClause("DAC_DATE_VAL_AC",WhereClause.Comparateur.BET,dd+" AND "+dfin));
		
		if(listDacPaPeriode.isEmpty()){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN," Dossier(s) non trouvé(s) pour la période de ->"+dated+" à ->"+datef, "")); 
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,listDacPaPeriode.size()+" Dossier(s) trouvé(s) pour la période de ->"+dated+" à ->"+datef, ""));
		}	
	}
	
	
	 public void vider() {
		 listHistoDac.clear();
		 listeDAC.clear();
		 critere="";
		 detailHisto=new VDetailHistoDac();
		 listeDAC = new ArrayList<VDacliste>();
		 
		 
	 }
	
	
	
	 public String renderPage(String value) throws IOException{ 
			switch(value) { 
			
			case "accueil":
				userController.renderPage(value);
				break;
				
			case "sit1":
				userController.renderPage(value);
				break;
			
			case "sit2":
				userController.renderPage(value);
				break;
				
			case "sit3":
				userController.renderPage(value);
				break;
				
			case "sit4":
				userController.renderPage(value);
				break;
				
			case "sit5":
				rechercheDossier();
				userController.renderPage(value);
				break;
				
			case "sit6":
				userController.renderPage(value);
				break;
				
			case "sit7":
				recupDetailPpm();
				userController.renderPage(value);
				break;
			case "per1":
				//chargePlanPassationByPeriode();
				userController.renderPage(value);
				break;
			}  
		    
		    return userController.renderPage(value);   
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



		public List<THistoDac> getListHistoStat() {
			return listHistoStat;
		}


		public void setListHistoStat(List<THistoDac> listHistoStat) {
			this.listHistoStat = listHistoStat;
		}


		public TStatut getStat() {
			return stat;
		}


		public void setStat(TStatut stat) {
			this.stat = stat;
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


		public List<TDacSpecs> getListDacPaPeriode() {
			return listDacPaPeriode;
		}


		public void setListDacPaPeriode(List<TDacSpecs> listDacPaPeriode) {
			this.listDacPaPeriode = listDacPaPeriode;
		}


		public List<TDossierDacs> getListDossierDac() {
			return listDossierDac;
		}


		public void setListDossierDac(List<TDossierDacs> listDossierDac) {
			this.listDossierDac = listDossierDac;
		}


		public List<TLotAao> getListeLotsAvis() {
			return listeLotsAvis;
		}


		public void setListeLotsAvis(List<TLotAao> listeLotsAvis) {
			this.listeLotsAvis = listeLotsAvis;
		}


		public List<VDacStatut> getListHistoDac() {
			return listHistoDac;
		}


		public void setListHistoDac(List<VDacStatut> listHistoDac) {
			this.listHistoDac = listHistoDac;
		}


		public List<VDetailHistoDac> getListDetailHist() {
			return listDetailHist;
		}


		public void setListDetailHist(List<VDetailHistoDac> listDetailHist) {
			this.listDetailHist = listDetailHist;
		}


		public VDetailHistoDac getDetailHisto() {
			return detailHisto;
		}


		public void setDetailHisto(VDetailHistoDac detailHisto) {
			this.detailHisto = detailHisto;
		}


		public List<VPpmliste> getListePpmParPeriode() {
			return listePpmParPeriode;
		}

		public void setListePpmParPeriode(List<VPpmliste> listePpmParPeriode) {
			this.listePpmParPeriode = listePpmParPeriode;
		}





		public List<VDacliste> getListeDAC() {
			return listeDAC;
		}





		public void setListeDAC(List<VDacliste> listeDAC) {
			this.listeDAC = listeDAC;
		}




		public VDacliste getSlctdTd() {
			return slctdTd;
		}




		public void setSlctdTd(VDacliste slctdTd) {
			this.slctdTd = slctdTd;
		}




		public List<VPpmliste> getListeConsultationPpm() {
			return listeConsultationPpm;
		}




		public void setListeConsultationPpm(List<VPpmliste> listeConsultationPpm) {
			this.listeConsultationPpm = listeConsultationPpm;
		}




		public List<VDetailHistoPpm> getListDetailHistPpm() {
			return listDetailHistPpm;
		}




		public void setListDetailHistPpm(List<VDetailHistoPpm> listDetailHistPpm) {
			this.listDetailHistPpm = listDetailHistPpm;
		}




		public VDetailHistoPpm getDetailHistoPpm() {
			return detailHistoPpm;
		}




		public void setDetailHistoPpm(VDetailHistoPpm detailHistoPpm) {
			this.detailHistoPpm = detailHistoPpm;
		}




		public VPpmliste getSlctdTdPpm() {
			return slctdTdPpm;
		}




		public void setSlctdTdPpm(VPpmliste slctdTdPpm) {
			this.slctdTdPpm = slctdTdPpm;
		}




		public List<VPpmStatut> getListHistoPpm() {
			return listHistoPpm;
		}




		public void setListHistoPpm(List<VPpmStatut> listHistoPpm) {
			this.listHistoPpm = listHistoPpm;
		}

}
