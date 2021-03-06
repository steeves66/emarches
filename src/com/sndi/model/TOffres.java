package com.sndi.model;
// Generated 5 mars 2020 10:26:15 by Hibernate Tools 4.3.5.Final

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
 * TOffres generated by hbm2java
 */
@Entity
@Table(name = "T_OFFRES", schema = "EMAP")
public class TOffres implements java.io.Serializable {

	private BigDecimal offNum;
	private TSoumissions TSoumissions;
	private TStatut TStatut;
	private TOperateur TOperateur;
	private TAvisAppelOffre TAvisAppelOffre;
	private TDacSpecs TDacSpecs;
	private Date offDteSaisi;
	private Date offDteOuvFin;
	private BigDecimal offMtTotOfr;
	private Date offDteJug;
	private BigDecimal offMtTotCor;
	private Date offDteOuvTec;
	private Date offDteStaCour;
	private String offSouSigleSte;
	private Set<TDetOffres> TDetOffreses = new HashSet<TDetOffres>(0);

	public TOffres() {
	}

	public TOffres(BigDecimal offNum, TStatut TStatut, TAvisAppelOffre TAvisAppelOffre, TDacSpecs TDacSpecs) {
		this.offNum = offNum;
		this.TStatut = TStatut;
		this.TAvisAppelOffre = TAvisAppelOffre;
		this.TDacSpecs = TDacSpecs;
	}

	public TOffres(BigDecimal offNum, TSoumissions TSoumissions, TStatut TStatut, TOperateur TOperateur,
			TAvisAppelOffre TAvisAppelOffre, TDacSpecs TDacSpecs, Date offDteSaisi, Date offDteOuvFin,
			BigDecimal offMtTotOfr, Date offDteJug, BigDecimal offMtTotCor, Date offDteOuvTec, Date offDteStaCour,String offSouSigleSte,
			Set<TDetOffres> TDetOffreses) {
		this.offNum = offNum;
		this.TSoumissions = TSoumissions;
		this.TStatut = TStatut;
		this.TOperateur = TOperateur;
		this.TAvisAppelOffre = TAvisAppelOffre;
		this.TDacSpecs = TDacSpecs;
		this.offDteSaisi = offDteSaisi;
		this.offDteOuvFin = offDteOuvFin;
		this.offMtTotOfr = offMtTotOfr;
		this.offDteJug = offDteJug;
		this.offMtTotCor = offMtTotCor;
		this.offDteOuvTec = offDteOuvTec;
		this.offDteStaCour = offDteStaCour;
		this.TDetOffreses = TDetOffreses;
		this.TDetOffreses = TDetOffreses;
	}

	@Id

	@Column(name = "OFF_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getOffNum() {
		return this.offNum;
	}

	public void setOffNum(BigDecimal offNum) {
		this.offNum = offNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFF_SOU_NCC")
	public TSoumissions getTSoumissions() {
		return this.TSoumissions;
	}

	public void setTSoumissions(TSoumissions TSoumissions) {
		this.TSoumissions = TSoumissions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFF_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFF_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFF_AAO_CODE", nullable = false)
	public TAvisAppelOffre getTAvisAppelOffre() {
		return this.TAvisAppelOffre;
	}

	public void setTAvisAppelOffre(TAvisAppelOffre TAvisAppelOffre) {
		this.TAvisAppelOffre = TAvisAppelOffre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFF_DAC_CODE", nullable = false)
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OFF_DTE_SAISI", length = 7)
	public Date getOffDteSaisi() {
		return this.offDteSaisi;
	}

	public void setOffDteSaisi(Date offDteSaisi) {
		this.offDteSaisi = offDteSaisi;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OFF_DTE_OUV_FIN", length = 7)
	public Date getOffDteOuvFin() {
		return this.offDteOuvFin;
	}

	public void setOffDteOuvFin(Date offDteOuvFin) {
		this.offDteOuvFin = offDteOuvFin;
	}

	@Column(name = "OFF_MT_TOT_OFR", precision = 20, scale = 0)
	public BigDecimal getOffMtTotOfr() {
		return this.offMtTotOfr;
	}

	public void setOffMtTotOfr(BigDecimal offMtTotOfr) {
		this.offMtTotOfr = offMtTotOfr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OFF_DTE_JUG", length = 7)
	public Date getOffDteJug() {
		return this.offDteJug;
	}

	public void setOffDteJug(Date offDteJug) {
		this.offDteJug = offDteJug;
	}

	@Column(name = "OFF_MT_TOT_COR", precision = 20, scale = 0)
	public BigDecimal getOffMtTotCor() {
		return this.offMtTotCor;
	}

	public void setOffMtTotCor(BigDecimal offMtTotCor) {
		this.offMtTotCor = offMtTotCor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OFF_DTE_OUV_TEC", length = 7)
	public Date getOffDteOuvTec() {
		return this.offDteOuvTec;
	}

	public void setOffDteOuvTec(Date offDteOuvTec) {
		this.offDteOuvTec = offDteOuvTec;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OFF_DTE_STA_COUR", length = 7)
	public Date getOffDteStaCour() {
		return this.offDteStaCour;
	}

	public void setOffDteStaCour(Date offDteStaCour) {
		this.offDteStaCour = offDteStaCour;
	}
	
	@Column(name = "OFF_SOU_SIGLE_STE", length = 500)
	public String getOffSouSigleSte() {
		return this.offSouSigleSte;
	}

	public void setOffSouSigleSte(String offSouSigleSte) {
		this.offSouSigleSte = offSouSigleSte;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOffres")
	public Set<TDetOffres> getTDetOffreses() {
		return this.TDetOffreses;
	}

	public void setTDetOffreses(Set<TDetOffres> TDetOffreses) {
		this.TDetOffreses = TDetOffreses;
	}

}
