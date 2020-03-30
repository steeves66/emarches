package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TDetailDemandes generated by hbm2java
 */
@Entity
@Table(name = "T_DETAIL_DEMANDES", schema = "EMAP")
public class TDetailDemandes implements java.io.Serializable {

	private BigDecimal ddeNum;
	private TDacSpecs TDacSpecs;
	private TDemande TDemande;
	private TStructure TStructure;
	private TLBudgets TLBudgets;
	private TLotAao TLotAao;
	private String ddeMarCode;
	private String ddeActNum;
	private String ddeActNumIni;

	public TDetailDemandes() {
	}

	public TDetailDemandes(BigDecimal ddeNum) {
		this.ddeNum = ddeNum;
	}

	public TDetailDemandes(BigDecimal ddeNum, TDacSpecs TDacSpecs, TDemande TDemande, TStructure TStructure,
			TLBudgets TLBudgets, TLotAao TLotAao, String ddeMarCode, String ddeActNum, String ddeActNumIni) {
		this.ddeNum = ddeNum;
		this.TDacSpecs = TDacSpecs;
		this.TDemande = TDemande;
		this.TStructure = TStructure;
		this.TLBudgets = TLBudgets;
		this.TLotAao = TLotAao;
		this.ddeMarCode = ddeMarCode;
		this.ddeActNum = ddeActNum;
		this.ddeActNumIni = ddeActNumIni;
	}

	@Id

	@Column(name = "DDE_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDdeNum() {
		return this.ddeNum;
	}

	public void setDdeNum(BigDecimal ddeNum) {
		this.ddeNum = ddeNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DDE_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DDE_DEM_NUM")
	public TDemande getTDemande() {
		return this.TDemande;
	}

	public void setTDemande(TDemande TDemande) {
		this.TDemande = TDemande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DDE_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DDE_LBG_CODE")
	public TLBudgets getTLBudgets() {
		return this.TLBudgets;
	}

	public void setTLBudgets(TLBudgets TLBudgets) {
		this.TLBudgets = TLBudgets;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DDE_LAA_ID")
	public TLotAao getTLotAao() {
		return this.TLotAao;
	}

	public void setTLotAao(TLotAao TLotAao) {
		this.TLotAao = TLotAao;
	}

	@Column(name = "DDE_MAR_CODE", length = 20)
	public String getDdeMarCode() {
		return this.ddeMarCode;
	}

	public void setDdeMarCode(String ddeMarCode) {
		this.ddeMarCode = ddeMarCode;
	}

	@Column(name = "DDE_ACT_NUM", length = 200)
	public String getDdeActNum() {
		return this.ddeActNum;
	}

	public void setDdeActNum(String ddeActNum) {
		this.ddeActNum = ddeActNum;
	}

	@Column(name = "DDE_ACT_NUM_INI", length = 200)
	public String getDdeActNumIni() {
		return this.ddeActNumIni;
	}

	public void setDdeActNumIni(String ddeActNumIni) {
		this.ddeActNumIni = ddeActNumIni;
	}

}
