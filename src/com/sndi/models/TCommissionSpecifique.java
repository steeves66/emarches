package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

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
 * TCommissionSpecifique generated by hbm2java
 */
@Entity
@Table(name = "T_COMMISSION_SPECIFIQUE", schema = "EMAP")
public class TCommissionSpecifique implements java.io.Serializable {

	private BigDecimal comNum;
	private TStructure TStructure;
	private TTypeCommission TTypeCommission;
	private TCommissionType TCommissionType;
	private TDacSpecs TDacSpecs;
	private Date comDteSaisi;
	private String comOpeMatricule;
	private String comMarCode;
	private String comAaoCode;
	private Set<TDetCommissionSeance> TDetCommissionSeances = new HashSet<TDetCommissionSeance>(0);

	public TCommissionSpecifique() {
	}

	public TCommissionSpecifique(BigDecimal comNum) {
		this.comNum = comNum;
	}

	public TCommissionSpecifique(BigDecimal comNum, TStructure TStructure, TTypeCommission TTypeCommission,
			TCommissionType TCommissionType, TDacSpecs TDacSpecs, Date comDteSaisi, String comOpeMatricule,
			String comMarCode, String comAaoCode, Set<TDetCommissionSeance> TDetCommissionSeances) {
		this.comNum = comNum;
		this.TStructure = TStructure;
		this.TTypeCommission = TTypeCommission;
		this.TCommissionType = TCommissionType;
		this.TDacSpecs = TDacSpecs;
		this.comDteSaisi = comDteSaisi;
		this.comOpeMatricule = comOpeMatricule;
		this.comMarCode = comMarCode;
		this.comAaoCode = comAaoCode;
		this.TDetCommissionSeances = TDetCommissionSeances;
	}

	@Id

	@Column(name = "COM_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getComNum() {
		return this.comNum;
	}

	public void setComNum(BigDecimal comNum) {
		this.comNum = comNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COM_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COM_TCO_CODE")
	public TTypeCommission getTTypeCommission() {
		return this.TTypeCommission;
	}

	public void setTTypeCommission(TTypeCommission TTypeCommission) {
		this.TTypeCommission = TTypeCommission;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COM_TCT_CODE")
	public TCommissionType getTCommissionType() {
		return this.TCommissionType;
	}

	public void setTCommissionType(TCommissionType TCommissionType) {
		this.TCommissionType = TCommissionType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COM_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "COM_DTE_SAISI", length = 7)
	public Date getComDteSaisi() {
		return this.comDteSaisi;
	}

	public void setComDteSaisi(Date comDteSaisi) {
		this.comDteSaisi = comDteSaisi;
	}

	@Column(name = "COM_OPE_MATRICULE", length = 20)
	public String getComOpeMatricule() {
		return this.comOpeMatricule;
	}

	public void setComOpeMatricule(String comOpeMatricule) {
		this.comOpeMatricule = comOpeMatricule;
	}

	@Column(name = "COM_MAR_CODE", length = 20)
	public String getComMarCode() {
		return this.comMarCode;
	}

	public void setComMarCode(String comMarCode) {
		this.comMarCode = comMarCode;
	}

	@Column(name = "COM_AAO_CODE", length = 20)
	public String getComAaoCode() {
		return this.comAaoCode;
	}

	public void setComAaoCode(String comAaoCode) {
		this.comAaoCode = comAaoCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TCommissionSpecifique")
	public Set<TDetCommissionSeance> getTDetCommissionSeances() {
		return this.TDetCommissionSeances;
	}

	public void setTDetCommissionSeances(Set<TDetCommissionSeance> TDetCommissionSeances) {
		this.TDetCommissionSeances = TDetCommissionSeances;
	}

}
