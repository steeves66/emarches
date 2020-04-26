package com.sndi.model;
// Generated 4 mars 2020 19:07:27 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
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

/**
 * TDetailDemandes generated by hbm2java
 */
@Entity
@Table(name = "T_DETAIL_DEMANDES", schema = "EMAP")
public class TDetailDemandes implements java.io.Serializable {

	private BigDecimal ddeNum;
	private TDemande TDemande;
	private TStructure TStructure;
	private String TLBudgets;
	private TLotAao TLotAao;
	private String TDacSpecs;
	private String ddeMarCode;
	private String ddeActNum;
	private String ddeActNumIni;

	public TDetailDemandes() {
	}

	public TDetailDemandes(BigDecimal ddeNum) {
		this.ddeNum = ddeNum;
	}

	public TDetailDemandes(BigDecimal ddeNum, TDemande TDemande, TStructure TStructure, String TLBudgets,
			TLotAao TLotAao, String TDacSpecs, String ddeMarCode, String ddeActNum, String ddeActNumIni) {
		this.ddeNum = ddeNum;
		this.TDemande = TDemande;
		this.TStructure = TStructure;
		this.TLBudgets = TLBudgets;
		this.TLotAao = TLotAao;
		this.TDacSpecs = TDacSpecs;
		this.ddeMarCode = ddeMarCode;
		this.ddeActNum = ddeActNum;
		this.ddeActNumIni = ddeActNumIni;
	}

	@Id
	@SequenceGenerator(name = "SEQ_DET_DEM_Sequence", sequenceName = "SEQ_DET_DEM", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DET_DEM_Sequence")
	@Column(name = "DDE_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDdeNum() {
		return this.ddeNum;
	}

	public void setDdeNum(BigDecimal ddeNum) {
		this.ddeNum = ddeNum;
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

	@Column(name = "DDE_LBG_CODE")
	public String getTLBudgets() {
		return this.TLBudgets;
	}

	public void setTLBudgets(String TLBudgets) {
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

	@Column(name = "DDE_DAC_CODE")
	public String getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(String TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
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
