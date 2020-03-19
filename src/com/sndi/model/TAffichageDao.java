package com.sndi.model;
// Generated 15 f�vr. 2020 14:11:37 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * TAffichageDao generated by hbm2java
 */
@Entity
@Table(name = "T_AFFICHAGE_DAO", schema = "EMAP")
public class TAffichageDao implements java.io.Serializable {

	private long affDaoId;
	private TDetCommissionSeance TDetCommissionSeance;
	private TModePassation TModePassation;
	private TDetailPlanPassation TDetailPlanPassation;
	private TStructure TStructure;
	private TGestion TGestion;
	private TTypeMarche TTypeMarche;
	private TTypeDacSpecs TTypeDacSpecs;
	private String affDacCode;
	private String affOpeMatricule;
	private String affStaCode;
	private String affStatutRetour;
	private Date affDacDteSaisi;
	private String affDacObjet;
	private Long affNbrOuv;
	private String affDacFonCodeCpmp;
	private String affDacFonCodAc;
	private Date affDacDacDteValCpmp;
	private Date affDacDacDteValDmp;
	private Date affDacDateReception;
	private String affDacStatutRetour;
	private String affDacMention;
	private String affDacRecherche;
	private Date affDacValAc;
	private String affDacAvisBailleur;
	private Date affDacDateBailleur;
	private String affDacBailleur;
	private Long affDacCout;
	private String affDacTypePlan;

	public TAffichageDao() {
	}

	public TAffichageDao(long affDaoId, TDetCommissionSeance TDetCommissionSeance,TModePassation TModePassation, TDetailPlanPassation TDetailPlanPassation, TStructure TStructure,
			TGestion TGestion, TTypeMarche TTypeMarche,TTypeDacSpecs TTypeDacSpecs,String affDacCode, String affOpeMatricule,
			String affStaCode, String affStatutRetour, Date affDacDteSaisi, String affDacObjet,  Long affNbrOuv,
			String affDacFonCodeCpmp, String affDacFonCodAc, Date affDacDacDteValCpmp, Date affDacDacDteValDmp,
			Date affDacDateReception, String affDacStatutRetour, String affDacMention, String affDacRecherche,Date affDacValAc, String affDacAvisBailleur, Date affDacDateBailleur
			, String affDacBailleur, Long affDacCout,String affDacTypePlan) {
		this.affDaoId = affDaoId;
		this.TDetCommissionSeance = TDetCommissionSeance;
		this.TModePassation = TModePassation;
		this.TDetailPlanPassation = TDetailPlanPassation;
		this.TStructure = TStructure;
		this.TGestion = TGestion;
		this.TTypeMarche = TTypeMarche;
		this.TTypeDacSpecs = TTypeDacSpecs;
		this.affDacCode = affDacCode;
		this.affOpeMatricule = affOpeMatricule;
		this.affStaCode = affStaCode;
		this.affStatutRetour = affStatutRetour;
		this.affDacDteSaisi = affDacDteSaisi;
		this.affDacObjet = affDacObjet;
		this.affNbrOuv = affNbrOuv;
		this.affDacFonCodeCpmp = affDacFonCodeCpmp;
		this.affDacFonCodAc = affDacFonCodAc;
		this.affDacDacDteValCpmp = affDacDacDteValCpmp;
		this.affDacDacDteValDmp = affDacDacDteValDmp;
		this.affDacDateReception = affDacDateReception;
		this.affDacStatutRetour = affDacStatutRetour;
		this.affDacMention = affDacMention;
		this.affDacRecherche = affDacRecherche;
		this.affDacValAc = affDacValAc;
		this.affDacAvisBailleur = affDacAvisBailleur;
		this.affDacDateBailleur = affDacDateBailleur;
		this.affDacBailleur = affDacBailleur;
		this.affDacCout = affDacCout;
		this.affDacTypePlan = affDacTypePlan;
	}
	
	@Id
	@SequenceGenerator(name = "SEQ_AFF_DAO_Sequence", sequenceName = "SEQ_AFF_DAO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_AFF_DAO_Sequence")
	@Column(name = "AFF_DAO_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getAffDaoId() {
		return affDaoId;
	}

	public void setAffDaoId(long affDaoId) {
		this.affDaoId = affDaoId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DCS_NUM")
	public TDetCommissionSeance getTDetCommissionSeance() {
		return this.TDetCommissionSeance;
	}

	public void setTDetCommissionSeance(TDetCommissionSeance TDetCommissionSeance) {
		this.TDetCommissionSeance = TDetCommissionSeance;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DAC_MOP_CODE")
	public TModePassation getTModePassation() {
		return this.TModePassation;
	}

	public void setTModePassation(TModePassation TModePassation) {
		this.TModePassation = TModePassation;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DAC_DPP_ID")
	public TDetailPlanPassation getTDetailPlanPassation() {
		return this.TDetailPlanPassation;
	}

	public void setTDetailPlanPassation(TDetailPlanPassation TDetailPlanPassation) {
		this.TDetailPlanPassation = TDetailPlanPassation;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DAC_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DAC_GES_CODE")
	public TGestion getTGestion() {
		return this.TGestion;
	}

	public void setTGestion(TGestion TGestion) {
		this.TGestion = TGestion;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DAC_TYM_CODE")
	public TTypeMarche getTTypeMarche() {
		return this.TTypeMarche;
	}

	public void setTTypeMarche(TTypeMarche TTypeMarche) {
		this.TTypeMarche = TTypeMarche;
	}
	
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DAC_TD_CODE")
	public TTypeDacSpecs getTTypeDacSpecs() {
		return this.TTypeDacSpecs;
	}

	public void setTTypeDacSpecs(TTypeDacSpecs TTypeDacSpecs) {
		this.TTypeDacSpecs = TTypeDacSpecs;
	}

	
	@Column(name = "AFF_DAC_CODE", nullable = false, length = 20)
	public String getAffDacCode() {
		return this.affDacCode;
	}

	public void setAffDacCode(String affDacCode) {
		this.affDacCode = affDacCode;
	}
	
	@Column(name = "AFF_OPE_MATRICULE", length = 25)
	public String getAffOpeMatricule() {
		return this.affOpeMatricule;
	}

	public void setAffOpeMatricule(String affOpeMatricule) {
		this.affOpeMatricule = affOpeMatricule;
	}

	@Column(name = "AFF_STA_CODE", length = 3)
	public String getAffStaCode() {
		return this.affStaCode;
	}

	public void setAffStaCode(String affStaCode) {
		this.affStaCode = affStaCode;
	}

	@Column(name = "AFF_STATUT_RETOUR", length = 4)
	public String getAffStatutRetour() {
		return this.affStatutRetour;
	}

	public void setAffStatutRetour(String affStatutRetour) {
		this.affStatutRetour = affStatutRetour;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DAC_DTE_SAISI", length = 7)
	public Date getAffDacDteSaisi() {
		return this.affDacDteSaisi;
	}

	public void setAffDacDteSaisi(Date affDacDteSaisi) {
		this.affDacDteSaisi = affDacDteSaisi;
	}

	@Column(name = "AFF_DAC_OBJET", length = 1000)
	public String getAffDacObjet() {
		return this.affDacObjet;
	}

	public void setAffDacObjet(String affDacObjet) {
		this.affDacObjet = affDacObjet;
	}

	@Column(name = "AFF_NBR_OUV", precision = 22, scale = 0)
	public  Long getAffNbrOuv() {
		return this.affNbrOuv;
	}

	public void setAffNbrOuv( Long affNbrOuv) {
		this.affNbrOuv = affNbrOuv;
	}

	@Column(name = "AFF_DAC_FON_CODE_CPMP", length = 12)
	public String getAffDacFonCodeCpmp() {
		return this.affDacFonCodeCpmp;
	}

	public void setAffDacFonCodeCpmp(String affDacFonCodeCpmp) {
		this.affDacFonCodeCpmp = affDacFonCodeCpmp;
	}

	@Column(name = "AFF_DAC_FON_COD_AC", length = 12)
	public String getAffDacFonCodAc() {
		return this.affDacFonCodAc;
	}

	public void setAffDacFonCodAc(String affDacFonCodAc) {
		this.affDacFonCodAc = affDacFonCodAc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DAC_DAC_DTE_VAL_CPMP", length = 7)
	public Date getAffDacDacDteValCpmp() {
		return this.affDacDacDteValCpmp;
	}

	public void setAffDacDacDteValCpmp(Date affDacDacDteValCpmp) {
		this.affDacDacDteValCpmp = affDacDacDteValCpmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DAC_DAC_DTE_VAL_DMP", length = 7)
	public Date getAffDacDacDteValDmp() {
		return this.affDacDacDteValDmp;
	}

	public void setAffDacDacDteValDmp(Date affDacDacDteValDmp) {
		this.affDacDacDteValDmp = affDacDacDteValDmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DAC_DATE_RECEPTION", length = 7)
	public Date getAffDacDateReception() {
		return this.affDacDateReception;
	}

	public void setAffDacDateReception(Date affDacDateReception) {
		this.affDacDateReception = affDacDateReception;
	}

	@Column(name = "AFF_DAC_STATUT_RETOUR", length = 2)
	public String getAffDacStatutRetour() {
		return this.affDacStatutRetour;
	}

	public void setAffDacStatutRetour(String affDacStatutRetour) {
		this.affDacStatutRetour = affDacStatutRetour;
	}

	@Column(name = "AFF_DAC_MENTION", length = 100)
	public String getAffDacMention() {
		return this.affDacMention;
	}

	public void setAffDacMention(String affDacMention) {
		this.affDacMention = affDacMention;
	}
	
	@Column(name = "AFF_DAC_RECHERCHE", length = 4000)
	public String getAffDacRecherche() {
		return this.affDacRecherche;
	}

	public void setAffDacRecherche(String affDacRecherche) {
		this.affDacRecherche = affDacRecherche;
	}
	

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DAC_VAL_AC", length = 7)
	public Date getAffDacValAc() {
		return this.affDacValAc;
	}

	public void setAffDacValAc(Date affDacValAc) {
		this.affDacValAc = affDacValAc;
	}
	
	@Column(name = "AFF_DAC_AVIS_BAILLEUR", length = 4000)
	public String getAffDacAvisBailleur() {
		return this.affDacAvisBailleur;
	}

	public void setAffDacAvisBailleur(String affDacAvisBailleur) {
		this.affDacAvisBailleur = affDacAvisBailleur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DAC_DATE_BAILLEUR", length = 7)
	public Date getAffDacDateBailleur() {
		return this.affDacDateBailleur;
	}

	public void setAffDacDateBailleur(Date affDacDateBailleur) {
		this.affDacDateBailleur = affDacDateBailleur;
	}
	
	
	@Column(name = "AFF_DAC_BAILLEUR", length = 1)
	public String getAffDacBailleur() {
		return this.affDacBailleur;
	}

	public void setAffDacBailleur(String affDacBailleur) {
		this.affDacBailleur = affDacBailleur;
	}
	
	
	@Column(name = "AFF_DAC_COUT", precision = 11, scale = 0)
	public Long getAffDacCout() {
		return this.affDacCout;
	}

	public void setAffDacCout(Long affDacCout) {
		this.affDacCout = affDacCout;
	}
	
	@Column(name = "AFF_DAC_TYPE_PLAN", length = 4)
	public String getAffDacTypePlan() {
		return this.affDacTypePlan;
	}

	public void setAffDacTypePlan(String affDacTypePlan) {
		this.affDacTypePlan = affDacTypePlan;
	}

}
