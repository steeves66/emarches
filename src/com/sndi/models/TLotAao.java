package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TLotAao generated by hbm2java
 */
@Entity
@Table(name = "T_LOT_AAO", schema = "EMAP")
public class TLotAao implements java.io.Serializable {

	private BigDecimal laaId;
	private TDacSpecs TDacSpecs;
	private TFonction TFonctionByLaaFonCodCpmp;
	private TFonction TFonctionByLaaFonCodSaisi;
	private TLBudgets TLBudgets;
	private TAvisAppelOffre TAvisAppelOffre;
	private String laaObjet;
	private String laaObservation;
	private BigDecimal laaMtCaut;
	private BigDecimal laaMtEst;
	private Date laaDteSaisi;
	private String laaStaCode;
	private String laaOpeMatricule;
	private String laaLieuExe;
	private BigDecimal laaNum;
	private BigDecimal laaCoutLot;
	private String laaAjoutPanier;
	private Set<TDetailVente> TDetailVentes = new HashSet<TDetailVente>(0);
	private Set<TDetailDemandes> TDetailDemandeses = new HashSet<TDetailDemandes>(0);
	private Set<TDetOffres> TDetOffreses = new HashSet<TDetOffres>(0);
	private Set<TPiecesOffres> TPiecesOffreses = new HashSet<TPiecesOffres>(0);

	public TLotAao() {
	}

	public TLotAao(BigDecimal laaId) {
		this.laaId = laaId;
	}

	public TLotAao(BigDecimal laaId, TDacSpecs TDacSpecs, TFonction TFonctionByLaaFonCodCpmp,
			TFonction TFonctionByLaaFonCodSaisi, TLBudgets TLBudgets, TAvisAppelOffre TAvisAppelOffre, String laaObjet,
			String laaObservation, BigDecimal laaMtCaut, BigDecimal laaMtEst, Date laaDteSaisi, String laaStaCode,
			String laaOpeMatricule, String laaLieuExe, BigDecimal laaNum, BigDecimal laaCoutLot, String laaAjoutPanier,
			Set<TDetailVente> TDetailVentes, Set<TDetailDemandes> TDetailDemandeses, Set<TDetOffres> TDetOffreses,
			Set<TPiecesOffres> TPiecesOffreses) {
		this.laaId = laaId;
		this.TDacSpecs = TDacSpecs;
		this.TFonctionByLaaFonCodCpmp = TFonctionByLaaFonCodCpmp;
		this.TFonctionByLaaFonCodSaisi = TFonctionByLaaFonCodSaisi;
		this.TLBudgets = TLBudgets;
		this.TAvisAppelOffre = TAvisAppelOffre;
		this.laaObjet = laaObjet;
		this.laaObservation = laaObservation;
		this.laaMtCaut = laaMtCaut;
		this.laaMtEst = laaMtEst;
		this.laaDteSaisi = laaDteSaisi;
		this.laaStaCode = laaStaCode;
		this.laaOpeMatricule = laaOpeMatricule;
		this.laaLieuExe = laaLieuExe;
		this.laaNum = laaNum;
		this.laaCoutLot = laaCoutLot;
		this.laaAjoutPanier = laaAjoutPanier;
		this.TDetailVentes = TDetailVentes;
		this.TDetailDemandeses = TDetailDemandeses;
		this.TDetOffreses = TDetOffreses;
		this.TPiecesOffreses = TPiecesOffreses;
	}

	@Id

	@Column(name = "LAA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getLaaId() {
		return this.laaId;
	}

	public void setLaaId(BigDecimal laaId) {
		this.laaId = laaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAA_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAA_FON_COD_CPMP")
	public TFonction getTFonctionByLaaFonCodCpmp() {
		return this.TFonctionByLaaFonCodCpmp;
	}

	public void setTFonctionByLaaFonCodCpmp(TFonction TFonctionByLaaFonCodCpmp) {
		this.TFonctionByLaaFonCodCpmp = TFonctionByLaaFonCodCpmp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAA_FON_COD_SAISI")
	public TFonction getTFonctionByLaaFonCodSaisi() {
		return this.TFonctionByLaaFonCodSaisi;
	}

	public void setTFonctionByLaaFonCodSaisi(TFonction TFonctionByLaaFonCodSaisi) {
		this.TFonctionByLaaFonCodSaisi = TFonctionByLaaFonCodSaisi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAA_LBG_IMPUTATION")
	public TLBudgets getTLBudgets() {
		return this.TLBudgets;
	}

	public void setTLBudgets(TLBudgets TLBudgets) {
		this.TLBudgets = TLBudgets;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAA_AAO_CODE")
	public TAvisAppelOffre getTAvisAppelOffre() {
		return this.TAvisAppelOffre;
	}

	public void setTAvisAppelOffre(TAvisAppelOffre TAvisAppelOffre) {
		this.TAvisAppelOffre = TAvisAppelOffre;
	}

	@Column(name = "LAA_OBJET", length = 1000)
	public String getLaaObjet() {
		return this.laaObjet;
	}

	public void setLaaObjet(String laaObjet) {
		this.laaObjet = laaObjet;
	}

	@Column(name = "LAA_OBSERVATION", length = 200)
	public String getLaaObservation() {
		return this.laaObservation;
	}

	public void setLaaObservation(String laaObservation) {
		this.laaObservation = laaObservation;
	}

	@Column(name = "LAA_MT_CAUT", precision = 22, scale = 0)
	public BigDecimal getLaaMtCaut() {
		return this.laaMtCaut;
	}

	public void setLaaMtCaut(BigDecimal laaMtCaut) {
		this.laaMtCaut = laaMtCaut;
	}

	@Column(name = "LAA_MT_EST", precision = 22, scale = 0)
	public BigDecimal getLaaMtEst() {
		return this.laaMtEst;
	}

	public void setLaaMtEst(BigDecimal laaMtEst) {
		this.laaMtEst = laaMtEst;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LAA_DTE_SAISI", length = 7)
	public Date getLaaDteSaisi() {
		return this.laaDteSaisi;
	}

	public void setLaaDteSaisi(Date laaDteSaisi) {
		this.laaDteSaisi = laaDteSaisi;
	}

	@Column(name = "LAA_STA_CODE", length = 3)
	public String getLaaStaCode() {
		return this.laaStaCode;
	}

	public void setLaaStaCode(String laaStaCode) {
		this.laaStaCode = laaStaCode;
	}

	@Column(name = "LAA_OPE_MATRICULE", length = 20)
	public String getLaaOpeMatricule() {
		return this.laaOpeMatricule;
	}

	public void setLaaOpeMatricule(String laaOpeMatricule) {
		this.laaOpeMatricule = laaOpeMatricule;
	}

	@Column(name = "LAA_LIEU_EXE", length = 1000)
	public String getLaaLieuExe() {
		return this.laaLieuExe;
	}

	public void setLaaLieuExe(String laaLieuExe) {
		this.laaLieuExe = laaLieuExe;
	}

	@Column(name = "LAA_NUM", precision = 22, scale = 0)
	public BigDecimal getLaaNum() {
		return this.laaNum;
	}

	public void setLaaNum(BigDecimal laaNum) {
		this.laaNum = laaNum;
	}

	@Column(name = "LAA_COUT_LOT", precision = 22, scale = 0)
	public BigDecimal getLaaCoutLot() {
		return this.laaCoutLot;
	}

	public void setLaaCoutLot(BigDecimal laaCoutLot) {
		this.laaCoutLot = laaCoutLot;
	}

	@Column(name = "LAA_AJOUT_PANIER", length = 1)
	public String getLaaAjoutPanier() {
		return this.laaAjoutPanier;
	}

	public void setLaaAjoutPanier(String laaAjoutPanier) {
		this.laaAjoutPanier = laaAjoutPanier;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLotAao")
	public Set<TDetailVente> getTDetailVentes() {
		return this.TDetailVentes;
	}

	public void setTDetailVentes(Set<TDetailVente> TDetailVentes) {
		this.TDetailVentes = TDetailVentes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLotAao")
	public Set<TDetailDemandes> getTDetailDemandeses() {
		return this.TDetailDemandeses;
	}

	public void setTDetailDemandeses(Set<TDetailDemandes> TDetailDemandeses) {
		this.TDetailDemandeses = TDetailDemandeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLotAao")
	public Set<TDetOffres> getTDetOffreses() {
		return this.TDetOffreses;
	}

	public void setTDetOffreses(Set<TDetOffres> TDetOffreses) {
		this.TDetOffreses = TDetOffreses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLotAao")
	public Set<TPiecesOffres> getTPiecesOffreses() {
		return this.TPiecesOffreses;
	}

	public void setTPiecesOffreses(Set<TPiecesOffres> TPiecesOffreses) {
		this.TPiecesOffreses = TPiecesOffreses;
	}

}
