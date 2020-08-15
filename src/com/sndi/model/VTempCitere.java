package com.sndi.model;
// Generated 12 ao�t 2020 17:07:17 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VTempCitereId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_TEMP_CITERE")
public class VTempCitere implements java.io.Serializable {

	private BigDecimal craNum;
	private String craType;
	private String craOpeMatricule;
	private Date craDteSaisi;
	private String craDacCode;

	public VTempCitere() {
	}

	public VTempCitere(BigDecimal craNum) {
		this.craNum = craNum;
	}

	public VTempCitere(BigDecimal craNum, String craType, String craOpeMatricule, Date craDteSaisi,
			String craDacCode) {
		this.craNum = craNum;
		this.craType = craType;
		this.craOpeMatricule = craOpeMatricule;
		this.craDteSaisi = craDteSaisi;
		this.craDacCode = craDacCode;
	}

	@Id
	@SequenceGenerator(name = "SEQ_TEM_PAR2_NUM_Sequence", sequenceName = "SEQ_TEM_PAR2_NUM", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TEM_PAR2_NUM_Sequence")
	@Column(name = "CRA_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCraNum() {
		return this.craNum;
	}

	public void setCraNum(BigDecimal craNum) {
		this.craNum = craNum;
	}

	@Column(name = "CRA_TYPE", length = 500)
	public String getCraType() {
		return this.craType;
	}

	public void setCraType(String craType) {
		this.craType = craType;
	}

	@Column(name = "CRA_OPE_MATRICULE", length = 500)
	public String getCraOpeMatricule() {
		return this.craOpeMatricule;
	}

	public void setCraOpeMatricule(String craOpeMatricule) {
		this.craOpeMatricule = craOpeMatricule;
	}

	@Column(name = "CRA_DTE_SAISI", length = 7)
	public Date getCraDteSaisi() {
		return this.craDteSaisi;
	}

	public void setCraDteSaisi(Date craDteSaisi) {
		this.craDteSaisi = craDteSaisi;
	}

	@Column(name = "CRA_DAC_CODE", length = 500)
	public String getCraDacCode() {
		return this.craDacCode;
	}

	public void setCraDacCode(String craDacCode) {
		this.craDacCode = craDacCode;
	}
}