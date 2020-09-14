package com.sndi.model;
// Generated 14 sept. 2020 14:04:06 by Hibernate Tools 4.3.5.Final

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
 * VbTempParamAtrib generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "VB_TEMP_PARAM_ATRIB")
public class VbTempParamAtrib implements java.io.Serializable {

	private BigDecimal tempNum;
	private String tempType;
	private String attOpeMatricile;
	private Date attDteAttrib;
	private String attDofAaoCode;
	private String attDofStatut;
	private BigDecimal attDofOffNum;
	private String attDacCode;
	private BigDecimal attDofLaaNum;
	private String attFonCode;
	private String attMtAttr;
	private String attDofRet;
	private String attSouNcc;
	private String attLaaId;
	private BigDecimal attDofNum;

	public VbTempParamAtrib() {
	}

	public VbTempParamAtrib(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParamAtrib(BigDecimal tempNum, String tempType, String attOpeMatricile, Date attDteAttrib,
			String attDofAaoCode, String attDofStatut, BigDecimal attDofOffNum, String attDacCode,
			BigDecimal attDofLaaNum, String attFonCode, String attMtAttr, String attDofRet, String attSouNcc,
			String attLaaId, BigDecimal attDofNum) {
		this.tempNum = tempNum;
		this.tempType = tempType;
		this.attOpeMatricile = attOpeMatricile;
		this.attDteAttrib = attDteAttrib;
		this.attDofAaoCode = attDofAaoCode;
		this.attDofStatut = attDofStatut;
		this.attDofOffNum = attDofOffNum;
		this.attDacCode = attDacCode;
		this.attDofLaaNum = attDofLaaNum;
		this.attFonCode = attFonCode;
		this.attMtAttr = attMtAttr;
		this.attDofRet = attDofRet;
		this.attSouNcc = attSouNcc;
		this.attLaaId = attLaaId;
		this.attDofNum = attDofNum;
	}

	
	@Id
	@SequenceGenerator(name = "SEQ_TEM_PAR2_NUM_Sequence", sequenceName = "SEQ_TEM_PAR2_NUM", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TEM_PAR2_NUM_Sequence")
	@Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTempNum() {
		return this.tempNum;
	}

	public void setTempNum(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	@Column(name = "TEMP_TYPE", length = 500)
	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	@Column(name = "ATT_OPE_MATRICILE", length = 500)
	public String getAttOpeMatricile() {
		return this.attOpeMatricile;
	}

	public void setAttOpeMatricile(String attOpeMatricile) {
		this.attOpeMatricile = attOpeMatricile;
	}

	@Column(name = "ATT_DTE_ATTRIB", length = 7)
	public Date getAttDteAttrib() {
		return this.attDteAttrib;
	}

	public void setAttDteAttrib(Date attDteAttrib) {
		this.attDteAttrib = attDteAttrib;
	}

	@Column(name = "ATT_DOF_AAO_CODE", length = 500)
	public String getAttDofAaoCode() {
		return this.attDofAaoCode;
	}

	public void setAttDofAaoCode(String attDofAaoCode) {
		this.attDofAaoCode = attDofAaoCode;
	}

	@Column(name = "ATT_DOF_STATUT", length = 500)
	public String getAttDofStatut() {
		return this.attDofStatut;
	}

	public void setAttDofStatut(String attDofStatut) {
		this.attDofStatut = attDofStatut;
	}

	@Column(name = "ATT_DOF_OFF_NUM", precision = 22, scale = 0)
	public BigDecimal getAttDofOffNum() {
		return this.attDofOffNum;
	}

	public void setAttDofOffNum(BigDecimal attDofOffNum) {
		this.attDofOffNum = attDofOffNum;
	}

	@Column(name = "ATT_DAC_CODE", length = 500)
	public String getAttDacCode() {
		return this.attDacCode;
	}

	public void setAttDacCode(String attDacCode) {
		this.attDacCode = attDacCode;
	}

	@Column(name = "ATT_DOF_LAA_NUM", precision = 22, scale = 0)
	public BigDecimal getAttDofLaaNum() {
		return this.attDofLaaNum;
	}

	public void setAttDofLaaNum(BigDecimal attDofLaaNum) {
		this.attDofLaaNum = attDofLaaNum;
	}

	@Column(name = "ATT_FON_CODE", length = 500)
	public String getAttFonCode() {
		return this.attFonCode;
	}

	public void setAttFonCode(String attFonCode) {
		this.attFonCode = attFonCode;
	}

	@Column(name = "ATT_MT_ATTR", length = 500)
	public String getAttMtAttr() {
		return this.attMtAttr;
	}

	public void setAttMtAttr(String attMtAttr) {
		this.attMtAttr = attMtAttr;
	}

	@Column(name = "ATT_DOF_RET", length = 500)
	public String getAttDofRet() {
		return this.attDofRet;
	}

	public void setAttDofRet(String attDofRet) {
		this.attDofRet = attDofRet;
	}

	@Column(name = "ATT_SOU_NCC", length = 500)
	public String getAttSouNcc() {
		return this.attSouNcc;
	}

	public void setAttSouNcc(String attSouNcc) {
		this.attSouNcc = attSouNcc;
	}

	@Column(name = "ATT_LAA_ID", length = 500)
	public String getAttLaaId() {
		return this.attLaaId;
	}

	public void setAttLaaId(String attLaaId) {
		this.attLaaId = attLaaId;
	}

	@Column(name = "ATT_DOF_NUM", precision = 22, scale = 0)
	public BigDecimal getAttDofNum() {
		return this.attDofNum;
	}

	public void setAttDofNum(BigDecimal attDofNum) {
		this.attDofNum = attDofNum;
	}

}