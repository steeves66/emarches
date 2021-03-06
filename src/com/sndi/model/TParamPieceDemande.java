package com.sndi.model;
// Generated 15 mai 2020 11:14:46 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TParamPieceDemande generated by hbm2java
 */
@Entity
@Table(name = "T_PARAM_PIECE_DEMANDE", schema = "EMAP")
public class TParamPieceDemande implements java.io.Serializable {

	private BigDecimal pidNum;
	private TTypeDemande TTypeDemande;
	private String pidLibeleCourt;
	private String pidLibeleLong;

	public TParamPieceDemande() {
	}

	public TParamPieceDemande(BigDecimal pidNum, TTypeDemande TTypeDemande) {
		this.pidNum = pidNum;
		this.TTypeDemande = TTypeDemande;
	}

	public TParamPieceDemande(BigDecimal pidNum, TTypeDemande TTypeDemande, String pidLibeleCourt,
			String pidLibeleLong) {
		this.pidNum = pidNum;
		this.TTypeDemande = TTypeDemande;
		this.pidLibeleCourt = pidLibeleCourt;
		this.pidLibeleLong = pidLibeleLong;
	}

	@Id

	@Column(name = "PID_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getPidNum() {
		return this.pidNum;
	}

	public void setPidNum(BigDecimal pidNum) {
		this.pidNum = pidNum;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PID_TDM_CODE", nullable = false)
	public TTypeDemande getTTypeDemande() {
		return this.TTypeDemande;
	}

	public void setTTypeDemande(TTypeDemande TTypeDemande) {
		this.TTypeDemande = TTypeDemande;
	}

	@Column(name = "PID_LIBELE_COURT", length = 100)
	public String getPidLibeleCourt() {
		return this.pidLibeleCourt;
	}

	public void setPidLibeleCourt(String pidLibeleCourt) {
		this.pidLibeleCourt = pidLibeleCourt;
	}

	@Column(name = "PID_LIBELE_LONG", length = 500)
	public String getPidLibeleLong() {
		return this.pidLibeleLong;
	}

	public void setPidLibeleLong(String pidLibeleLong) {
		this.pidLibeleLong = pidLibeleLong;
	}

}
