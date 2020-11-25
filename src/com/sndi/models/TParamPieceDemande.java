package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TParamPieceDemande generated by hbm2java
 */
@Entity
@Table(name = "T_PARAM_PIECE_DEMANDE", schema = "EMAP")
public class TParamPieceDemande implements java.io.Serializable {

	private BigDecimal pidNum;
	private String pidLibeleCourt;
	private String pidLibeleLong;
	private String pidTdmCode;

	public TParamPieceDemande() {
	}

	public TParamPieceDemande(BigDecimal pidNum, String pidTdmCode) {
		this.pidNum = pidNum;
		this.pidTdmCode = pidTdmCode;
	}

	public TParamPieceDemande(BigDecimal pidNum, String pidLibeleCourt, String pidLibeleLong, String pidTdmCode) {
		this.pidNum = pidNum;
		this.pidLibeleCourt = pidLibeleCourt;
		this.pidLibeleLong = pidLibeleLong;
		this.pidTdmCode = pidTdmCode;
	}

	@Id

	@Column(name = "PID_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getPidNum() {
		return this.pidNum;
	}

	public void setPidNum(BigDecimal pidNum) {
		this.pidNum = pidNum;
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

	@Column(name = "PID_TDM_CODE", nullable = false, length = 10)
	public String getPidTdmCode() {
		return this.pidTdmCode;
	}

	public void setPidTdmCode(String pidTdmCode) {
		this.pidTdmCode = pidTdmCode;
	}

}
