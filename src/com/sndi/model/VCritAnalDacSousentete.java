package com.sndi.model;
// Generated 17 ao�t 2020 19:38:40 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VCritAnalDacSousentete generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_CRIT_ANAL_DAC_SOUSENTETE")
public class VCritAnalDacSousentete implements java.io.Serializable {

	//private BigDecimal RId;
	private String RId;
	private BigDecimal dcadNum;
	private String craCode;
	private String craParent;
	private String craLibelle;
	private String mdtCode;
	private String mdtTymCode;
	private String dcadDacCode;
	private BigDecimal dcadLaaId;
	private BigDecimal dcadNumDcad;
	private BigDecimal tri;
	private Character dcadCraAuCode;

	public VCritAnalDacSousentete() {
	}

	public VCritAnalDacSousentete(String dcadDacCode) {
		this.dcadDacCode = dcadDacCode;
	}

	public VCritAnalDacSousentete(/*BigDecimal RId,*/String RId, BigDecimal dcadNum, String craCode, String craParent, String craLibelle,
			String mdtCode, String mdtTymCode, String dcadDacCode, BigDecimal dcadLaaId, BigDecimal dcadNumDcad,
			BigDecimal tri, Character dcadCraAuCode) {
		this.RId = RId;
		this.dcadNum = dcadNum;
		this.craCode = craCode;
		this.craParent = craParent;
		this.craLibelle = craLibelle;
		this.mdtCode = mdtCode;
		this.mdtTymCode = mdtTymCode;
		this.dcadDacCode = dcadDacCode;
		this.dcadLaaId = dcadLaaId;
		this.dcadNumDcad = dcadNumDcad;
		this.tri = tri;
		this.dcadCraAuCode = dcadCraAuCode;
	}

/*	@Id
	@Column(name = "R_ID", precision = 22, scale = 0)
	public BigDecimal getRId() {
		return this.RId;
	}

	public void setRId(BigDecimal RId) {
		this.RId = RId;
	}*/
	
	
	@Id
	@Column(name = "R_ID")
	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	@Column(name = "DCAD_NUM", precision = 22, scale = 0)
	public BigDecimal getDcadNum() {
		return this.dcadNum;
	}

	public void setDcadNum(BigDecimal dcadNum) {
		this.dcadNum = dcadNum;
	}

	@Column(name = "CRA_CODE", length = 66)
	public String getCraCode() {
		return this.craCode;
	}

	public void setCraCode(String craCode) {
		this.craCode = craCode;
	}

	@Column(name = "CRA_PARENT", length = 66)
	public String getCraParent() {
		return this.craParent;
	}

	public void setCraParent(String craParent) {
		this.craParent = craParent;
	}

	@Column(name = "CRA_LIBELLE", length = 530)
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

	@Column(name = "DCAD_DAC_CODE", nullable = false, length = 20)
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

	@Column(name = "DCAD_NUM_DCAD", precision = 22, scale = 0)
	public BigDecimal getDcadNumDcad() {
		return this.dcadNumDcad;
	}

	public void setDcadNumDcad(BigDecimal dcadNumDcad) {
		this.dcadNumDcad = dcadNumDcad;
	}

	@Column(name = "TRI", precision = 22, scale = 0)
	public BigDecimal getTri() {
		return this.tri;
	}

	public void setTri(BigDecimal tri) {
		this.tri = tri;
	}

	@Column(name = "DCAD_CRA_AU_CODE", length = 1)
	public Character getDcadCraAuCode() {
		return this.dcadCraAuCode;
	}

	public void setDcadCraAuCode(Character dcadCraAuCode) {
		this.dcadCraAuCode = dcadCraAuCode;
	}
}
