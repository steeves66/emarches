package com.sndi.model;
// Generated 31 ao�t 2020 18:25:25 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VOffreRecevableLot generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_OFFRE_RECEVABLE_LOT")
public class VOffreRecevableLot implements java.io.Serializable {

	private BigDecimal RId;
	private String laaDacCode;
	private BigDecimal laaNum;
	private BigDecimal dofLaaId;
	private String laaObjet;
	private BigDecimal tri;

	public VOffreRecevableLot() {
	}

	public VOffreRecevableLot(BigDecimal RId, String laaDacCode, BigDecimal laaNum, BigDecimal dofLaaId,
			String laaObjet, BigDecimal tri) {
		this.RId = RId;
		this.laaDacCode = laaDacCode;
		this.laaNum = laaNum;
		this.dofLaaId = dofLaaId;
		this.laaObjet = laaObjet;
		this.tri = tri;
	}

	@Id
	@Column(name = "R_ID", precision = 22, scale = 0)
	public BigDecimal getRId() {
		return this.RId;
	}

	public void setRId(BigDecimal RId) {
		this.RId = RId;
	}

	@Column(name = "LAA_DAC_CODE", length = 20)
	public String getLaaDacCode() {
		return this.laaDacCode;
	}

	public void setLaaDacCode(String laaDacCode) {
		this.laaDacCode = laaDacCode;
	}

	@Column(name = "LAA_NUM", precision = 22, scale = 0)
	public BigDecimal getLaaNum() {
		return this.laaNum;
	}

	public void setLaaNum(BigDecimal laaNum) {
		this.laaNum = laaNum;
	}

	@Column(name = "DOF_LAA_ID", precision = 22, scale = 0)
	public BigDecimal getDofLaaId() {
		return this.dofLaaId;
	}

	public void setDofLaaId(BigDecimal dofLaaId) {
		this.dofLaaId = dofLaaId;
	}

	@Column(name = "LAA_OBJET", length = 1047)
	public String getLaaObjet() {
		return this.laaObjet;
	}

	public void setLaaObjet(String laaObjet) {
		this.laaObjet = laaObjet;
	}

	@Column(name = "TRI", precision = 22, scale = 0)
	public BigDecimal getTri() {
		return this.tri;
	}

	public void setTri(BigDecimal tri) {
		this.tri = tri;
	}
}
