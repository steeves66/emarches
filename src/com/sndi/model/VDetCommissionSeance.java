package com.sndi.model;
// Generated 7 mai 2020 14:01:01 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VDetCommissionSeanceId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_DET_COMMISSION_SEANCE")
public class VDetCommissionSeance implements java.io.Serializable {

	private BigDecimal dcsNum;
	private String dcsDacCode;
	private String dcsFonCod;
	private String dcsOpeMatricule;
	private BigDecimal dcsSeaNum;
	private Date dcsDteSaisi;
	private String dcsFonCodSaisi;
	private String dcsObservation;
	private String dcsComTcoCode;
	private BigDecimal dcsComNum;
	private String dcsNomMbm;
	private String dcsPreMbm;
	private String dcsTelMbm;
	private String dcsPresent;
	private String dcsComStrCode;
	private String dcsOpeMatSaisi;
	private String dcsMbmRespo;
	private String dcsRepMandate;
	private String dcsFonAdmin;
	private String dcsStrCom;

	public VDetCommissionSeance() {
	}

	public VDetCommissionSeance(BigDecimal dcsNum) {
		this.dcsNum = dcsNum;
	}

	public VDetCommissionSeance(BigDecimal dcsNum, String dcsDacCode, String dcsFonCod, String dcsOpeMatricule,
			BigDecimal dcsSeaNum, Date dcsDteSaisi, String dcsFonCodSaisi, String dcsObservation, String dcsComTcoCode,
			BigDecimal dcsComNum, String dcsNomMbm, String dcsPreMbm, String dcsTelMbm, String dcsPresent,
			String dcsComStrCode, String dcsOpeMatSaisi, String dcsMbmRespo, String dcsRepMandate,String dcsFonAdmin,
			String dcsStrCom) {
		this.dcsNum = dcsNum;
		this.dcsDacCode = dcsDacCode;
		this.dcsFonCod = dcsFonCod;
		this.dcsOpeMatricule = dcsOpeMatricule;
		this.dcsSeaNum = dcsSeaNum;
		this.dcsDteSaisi = dcsDteSaisi;
		this.dcsFonCodSaisi = dcsFonCodSaisi;
		this.dcsObservation = dcsObservation;
		this.dcsComTcoCode = dcsComTcoCode;
		this.dcsComNum = dcsComNum;
		this.dcsNomMbm = dcsNomMbm;
		this.dcsPreMbm = dcsPreMbm;
		this.dcsTelMbm = dcsTelMbm;
		this.dcsPresent = dcsPresent;
		this.dcsComStrCode = dcsComStrCode;
		this.dcsOpeMatSaisi = dcsOpeMatSaisi;
		this.dcsMbmRespo = dcsMbmRespo;
		this.dcsRepMandate = dcsRepMandate;
		this.dcsFonAdmin = dcsFonAdmin;
		this.dcsStrCom = dcsStrCom;
	}

	@Id
	@Column(name = "DCS_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDcsNum() {
		return this.dcsNum;
	}

	public void setDcsNum(BigDecimal dcsNum) {
		this.dcsNum = dcsNum;
	}

	@Column(name = "DCS_DAC_CODE", length = 20)
	public String getDcsDacCode() {
		return this.dcsDacCode;
	}

	public void setDcsDacCode(String dcsDacCode) {
		this.dcsDacCode = dcsDacCode;
	}

	@Column(name = "DCS_FON_COD", length = 100)
	public String getDcsFonCod() {
		return this.dcsFonCod;
	}

	public void setDcsFonCod(String dcsFonCod) {
		this.dcsFonCod = dcsFonCod;
	}

	@Column(name = "DCS_OPE_MATRICULE", length = 20)
	public String getDcsOpeMatricule() {
		return this.dcsOpeMatricule;
	}

	public void setDcsOpeMatricule(String dcsOpeMatricule) {
		this.dcsOpeMatricule = dcsOpeMatricule;
	}

	@Column(name = "DCS_SEA_NUM", precision = 22, scale = 0)
	public BigDecimal getDcsSeaNum() {
		return this.dcsSeaNum;
	}

	public void setDcsSeaNum(BigDecimal dcsSeaNum) {
		this.dcsSeaNum = dcsSeaNum;
	}

	@Column(name = "DCS_DTE_SAISI", length = 7)
	public Date getDcsDteSaisi() {
		return this.dcsDteSaisi;
	}

	public void setDcsDteSaisi(Date dcsDteSaisi) {
		this.dcsDteSaisi = dcsDteSaisi;
	}

	@Column(name = "DCS_FON_COD_SAISI", length = 12)
	public String getDcsFonCodSaisi() {
		return this.dcsFonCodSaisi;
	}

	public void setDcsFonCodSaisi(String dcsFonCodSaisi) {
		this.dcsFonCodSaisi = dcsFonCodSaisi;
	}

	@Column(name = "DCS_OBSERVATION", length = 200)
	public String getDcsObservation() {
		return this.dcsObservation;
	}

	public void setDcsObservation(String dcsObservation) {
		this.dcsObservation = dcsObservation;
	}

	@Column(name = "DCS_COM_TCO_CODE", length = 3)
	public String getDcsComTcoCode() {
		return this.dcsComTcoCode;
	}

	public void setDcsComTcoCode(String dcsComTcoCode) {
		this.dcsComTcoCode = dcsComTcoCode;
	}

	@Column(name = "DCS_COM_NUM", precision = 22, scale = 0)
	public BigDecimal getDcsComNum() {
		return this.dcsComNum;
	}

	public void setDcsComNum(BigDecimal dcsComNum) {
		this.dcsComNum = dcsComNum;
	}

	@Column(name = "DCS_NOM_MBM", length = 100)
	public String getDcsNomMbm() {
		return this.dcsNomMbm;
	}

	public void setDcsNomMbm(String dcsNomMbm) {
		this.dcsNomMbm = dcsNomMbm;
	}

	@Column(name = "DCS_PRE_MBM", length = 200)
	public String getDcsPreMbm() {
		return this.dcsPreMbm;
	}

	public void setDcsPreMbm(String dcsPreMbm) {
		this.dcsPreMbm = dcsPreMbm;
	}

	@Column(name = "DCS_TEL_MBM", length = 50)
	public String getDcsTelMbm() {
		return this.dcsTelMbm;
	}

	public void setDcsTelMbm(String dcsTelMbm) {
		this.dcsTelMbm = dcsTelMbm;
	}

	@Column(name = "DCS_PRESENT", length = 1)
	public String getDcsPresent() {
		return this.dcsPresent;
	}

	public void setDcsPresent(String dcsPresent) {
		this.dcsPresent = dcsPresent;
	}

	@Column(name = "DCS_COM_STR_CODE", length = 20)
	public String getDcsComStrCode() {
		return this.dcsComStrCode;
	}

	public void setDcsComStrCode(String dcsComStrCode) {
		this.dcsComStrCode = dcsComStrCode;
	}

	@Column(name = "DCS_OPE_MAT_SAISI", length = 20)
	public String getDcsOpeMatSaisi() {
		return this.dcsOpeMatSaisi;
	}

	public void setDcsOpeMatSaisi(String dcsOpeMatSaisi) {
		this.dcsOpeMatSaisi = dcsOpeMatSaisi;
	}

	@Column(name = "DCS_MBM_RESPO", length = 1)
	public String getDcsMbmRespo() {
		return this.dcsMbmRespo;
	}

	public void setDcsMbmRespo(String dcsMbmRespo) {
		this.dcsMbmRespo = dcsMbmRespo;
	}

	@Column(name = "DCS_REP_MANDATE", length = 1)
	public String getDcsRepMandate() {
		return this.dcsRepMandate;
	}

	public void setDcsRepMandate(String dcsRepMandate) {
		this.dcsRepMandate = dcsRepMandate;
	}
	
	@Column(name = "DCS_FON_ADMIN", length = 500)
	public String getDcsFonAdmin() {
		return this.dcsFonAdmin;
	}

	public void setDcsFonAdmin(String dcsFonAdmin) {
		this.dcsFonAdmin = dcsFonAdmin;
	}

	@Column(name = "DCS_STR_COM", length = 500)
	public String getDcsStrCom() {
		return this.dcsStrCom;
	}

	public void setDcsStrCom(String dcsStrCom) {
		this.dcsStrCom = dcsStrCom;
	}

}
