package com.sndi.model;
// Generated 20 juin 2020 11:42:45 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TDetCritAnalyseDac generated by hbm2java
 */
@Entity
@Table(name = "T_DET_CRIT_ANALYSE_DAC", schema = "EMAP")
public class TDetCritAnalyseDac implements java.io.Serializable {

	private BigDecimal dcadNum;
	private TDacSpecs TDacSpecs;
	private TDetCritAnalyse TDetCritAnalyse;
	private TCritereAnalyse TCritereAnalyse;
	private String dcadLibAjust;
	private Date dcadDteSaisie;
	private String dcadOpeCode;
	private String dcadObser;
	private String dcadStatut;

	public TDetCritAnalyseDac() {
	}

	public TDetCritAnalyseDac(BigDecimal dcadNum, TDetCritAnalyse TDetCritAnalyse) {
		this.dcadNum = dcadNum;
		this.TDetCritAnalyse = TDetCritAnalyse;
	}

	public TDetCritAnalyseDac(BigDecimal dcadNum, TDacSpecs TDacSpecs, TDetCritAnalyse TDetCritAnalyse,
			TCritereAnalyse TCritereAnalyse, String dcadLibAjust, Date dcadDteSaisie, String dcadOpeCode,
			String dcadObser, String dcadStatut) {
		this.dcadNum = dcadNum;
		this.TDacSpecs = TDacSpecs;
		this.TDetCritAnalyse = TDetCritAnalyse;
		this.TCritereAnalyse = TCritereAnalyse;
		this.dcadLibAjust = dcadLibAjust;
		this.dcadDteSaisie = dcadDteSaisie;
		this.dcadOpeCode = dcadOpeCode;
		this.dcadObser = dcadObser;
		this.dcadStatut = dcadStatut;
	}

	@Id

	@Column(name = "DCAD_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDcadNum() {
		return this.dcadNum;
	}

	public void setDcadNum(BigDecimal dcadNum) {
		this.dcadNum = dcadNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCAD_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCAD_DAN_CODE", nullable = false)
	public TDetCritAnalyse getTDetCritAnalyse() {
		return this.TDetCritAnalyse;
	}

	public void setTDetCritAnalyse(TDetCritAnalyse TDetCritAnalyse) {
		this.TDetCritAnalyse = TDetCritAnalyse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCAD_DAN_CRA_CODE")
	public TCritereAnalyse getTCritereAnalyse() {
		return this.TCritereAnalyse;
	}

	public void setTCritereAnalyse(TCritereAnalyse TCritereAnalyse) {
		this.TCritereAnalyse = TCritereAnalyse;
	}

	@Column(name = "DCAD_LIB_AJUST", length = 500)
	public String getDcadLibAjust() {
		return this.dcadLibAjust;
	}

	public void setDcadLibAjust(String dcadLibAjust) {
		this.dcadLibAjust = dcadLibAjust;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DCAD_DTE_SAISIE", length = 7)
	public Date getDcadDteSaisie() {
		return this.dcadDteSaisie;
	}

	public void setDcadDteSaisie(Date dcadDteSaisie) {
		this.dcadDteSaisie = dcadDteSaisie;
	}

	@Column(name = "DCAD_OPE_CODE", length = 25)
	public String getDcadOpeCode() {
		return this.dcadOpeCode;
	}

	public void setDcadOpeCode(String dcadOpeCode) {
		this.dcadOpeCode = dcadOpeCode;
	}

	@Column(name = "DCAD_OBSER", length = 500)
	public String getDcadObser() {
		return this.dcadObser;
	}

	public void setDcadObser(String dcadObser) {
		this.dcadObser = dcadObser;
	}

	@Column(name = "DCAD_STATUT", length = 1)
	public String getDcadStatut() {
		return this.dcadStatut;
	}

	public void setDcadStatut(String dcadStatut) {
		this.dcadStatut = dcadStatut;
	}

}
