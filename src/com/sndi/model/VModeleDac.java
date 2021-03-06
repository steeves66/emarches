package com.sndi.model;
// Generated 26 juin 2020 05:06:21 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VModeleDac generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_MODELE_DAC")
public class VModeleDac implements java.io.Serializable {
	
	private BigDecimal RId;
	private long dppId;
	private String mdtCode;
	private String mdtLibelleCourt;
	private String mdtLibelleLong;
	private String dppTymCode;
	private String dppMopCode;

	public VModeleDac() {
	}

	public VModeleDac(long dppId, String mdtCode, String dppTymCode, String dppMopCode) {
		this.dppId = dppId;
		this.mdtCode = mdtCode;
		this.dppTymCode = dppTymCode;
		this.dppMopCode = dppMopCode;
	}

	public VModeleDac(BigDecimal RId, long dppId, String mdtCode, String mdtLibelleCourt, String mdtLibelleLong, String dppTymCode,
			String dppMopCode) {
		this.RId = RId;
		this.dppId = dppId;
		this.mdtCode = mdtCode;
		this.mdtLibelleCourt = mdtLibelleCourt;
		this.mdtLibelleLong = mdtLibelleLong;
		this.dppTymCode = dppTymCode;
		this.dppMopCode = dppMopCode;
	}

	@Id
	@Column(name = "R_ID", precision = 22, scale = 0)
	public BigDecimal getRId() {
		return this.RId;
	}

	public void setRId(BigDecimal RId) {
		this.RId = RId;
	}
	
	@Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getDppId() {
		return this.dppId;
	}

	public void setDppId(long dppId) {
		this.dppId = dppId;
	}

	@Column(name = "MDT_CODE", nullable = false, length = 15)
	public String getMdtCode() {
		return this.mdtCode;
	}

	public void setMdtCode(String mdtCode) {
		this.mdtCode = mdtCode;
	}

	@Column(name = "MDT_LIBELLE_COURT", length = 500)
	public String getMdtLibelleCourt() {
		return this.mdtLibelleCourt;
	}

	public void setMdtLibelleCourt(String mdtLibelleCourt) {
		this.mdtLibelleCourt = mdtLibelleCourt;
	}

	@Column(name = "MDT_LIBELLE_LONG", length = 500)
	public String getMdtLibelleLong() {
		return this.mdtLibelleLong;
	}

	public void setMdtLibelleLong(String mdtLibelleLong) {
		this.mdtLibelleLong = mdtLibelleLong;
	}

	@Column(name = "DPP_TYM_CODE", nullable = false, length = 3)
	public String getDppTymCode() {
		return this.dppTymCode;
	}

	public void setDppTymCode(String dppTymCode) {
		this.dppTymCode = dppTymCode;
	}

	@Column(name = "DPP_MOP_CODE", nullable = false, length = 3)
	public String getDppMopCode() {
		return this.dppMopCode;
	}

	public void setDppMopCode(String dppMopCode) {
		this.dppMopCode = dppMopCode;
	}

}
