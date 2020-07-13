package com.sndi.model;
// Generated 11 juil. 2020 17:57:09 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VCritAnalDacEnteteId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_CRIT_ANAL_DAC_ENTETE")
public class VCritAnalDacEntete implements java.io.Serializable {

	private long dcadNum;
	private String craCode;
	private String craLibelle;
	private String mdtCode;
	private String mdtTymCode;
	private String dcadDacCode;
	private BigDecimal dcadLaaId;

	public VCritAnalDacEntete() {
	}

	public VCritAnalDacEntete(long dcadNum, String craCode, String craLibelle, String mdtCode,
			String mdtTymCode, String dcadDacCode, BigDecimal dcadLaaId) {
		this.dcadNum = dcadNum;
		this.craCode = craCode;
		this.craLibelle = craLibelle;
		this.mdtCode = mdtCode;
		this.mdtTymCode = mdtTymCode;
		this.dcadDacCode = dcadDacCode;
		this.dcadLaaId = dcadLaaId;
	}

	@Column(name = "DCAD_NUM", precision = 22, scale = 0)
	public long getDcadNum() {
		return this.dcadNum;
	}

	public void setDcadNum(long dcadNum) {
		this.dcadNum = dcadNum;
	}

	@Id
	@Column(name = "CRA_CODE", length = 36)
	public String getCraCode() {
		return this.craCode;
	}

	public void setCraCode(String craCode) {
		this.craCode = craCode;
	}

	@Column(name = "CRA_LIBELLE", length = 1000)
	public String getCraLibelle() {
		return this.craLibelle;
	}

	public void setCraLibelle(String craLibelle) {
		this.craLibelle = craLibelle;
	}

	@Column(name = "MDT_CODE", length = 15)
	public String getMdtCode() {
		return this.mdtCode;
	}

	public void setMdtCode(String mdtCode) {
		this.mdtCode = mdtCode;
	}

	@Column(name = "MDT_TYM_CODE", length = 10)
	public String getMdtTymCode() {
		return this.mdtTymCode;
	}

	public void setMdtTymCode(String mdtTymCode) {
		this.mdtTymCode = mdtTymCode;
	}

	@Column(name = "DCAD_DAC_CODE", length = 20)
	public String getDcadDacCode() {
		return this.dcadDacCode;
	}

	public void setDcadDacCode(String dcadDacCode) {
		this.dcadDacCode = dcadDacCode;
	}

	@Column(name = "DCAD_LAA_ID", precision = 22, scale = 0)
	public BigDecimal getDcadLaaId() {
		return this.dcadLaaId;
	}

	public void setDcadLaaId(BigDecimal dcadLaaId) {
		this.dcadLaaId = dcadLaaId;
	}

}
