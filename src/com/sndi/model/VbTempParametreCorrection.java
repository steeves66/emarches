package com.sndi.model;
// Generated 13 f�vr. 2020 10:44:45 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VbTempParametreCorrection generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "VB_TEMP_PARAMETRE_CORRECTION")
public class VbTempParametreCorrection implements java.io.Serializable {

	private long tempNum;
	private String tempType;
	private String dcoOpeMatricule;
	private Date dcoDteSaisi;
	private String dcoTitre;
	private String dcoLibelle;
	private String dcoPidCode;
	private String dcoDacCode;
	private String dcoFonCodSaisi;
	private String dcoObservation;
	private String dcoCorNum;

	public VbTempParametreCorrection() {
	}

	public VbTempParametreCorrection(long tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParametreCorrection(long tempNum, String tempType, String dcoOpeMatricule, Date dcoDteSaisi,
			String dcoTitre, String dcoLibelle, String dcoPidCode, String dcoDacCode, String dcoFonCodSaisi,
			String dcoObservation, String dcoCorNum) {
		this.tempNum = tempNum;
		this.tempType = tempType;
		this.dcoOpeMatricule = dcoOpeMatricule;
		this.dcoDteSaisi = dcoDteSaisi;
		this.dcoTitre = dcoTitre;
		this.dcoLibelle = dcoLibelle;
		this.dcoPidCode = dcoPidCode;
		this.dcoDacCode = dcoDacCode;
		this.dcoFonCodSaisi = dcoFonCodSaisi;
		this.dcoObservation = dcoObservation;
		this.dcoCorNum = dcoCorNum;
	}

	
	@Id
	@Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)
	public long getTempNum() {
		return this.tempNum;
	}

	public void setTempNum(long tempNum) {
		this.tempNum = tempNum;
	}

	@Column(name = "TEMP_TYPE", length = 14)
	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	@Column(name = "DCO_OPE_MATRICULE", length = 500)
	public String getDcoOpeMatricule() {
		return this.dcoOpeMatricule;
	}

	public void setDcoOpeMatricule(String dcoOpeMatricule) {
		this.dcoOpeMatricule = dcoOpeMatricule;
	}

	@Column(name = "DCO_DTE_SAISI", length = 7)
	public Date getDcoDteSaisi() {
		return this.dcoDteSaisi;
	}

	public void setDcoDteSaisi(Date dcoDteSaisi) {
		this.dcoDteSaisi = dcoDteSaisi;
	}

	@Column(name = "DCO_TITRE", length = 500)
	public String getDcoTitre() {
		return this.dcoTitre;
	}

	public void setDcoTitre(String dcoTitre) {
		this.dcoTitre = dcoTitre;
	}

	@Column(name = "DCO_LIBELLE", length = 500)
	public String getDcoLibelle() {
		return this.dcoLibelle;
	}

	public void setDcoLibelle(String dcoLibelle) {
		this.dcoLibelle = dcoLibelle;
	}

	@Column(name = "DCO_PID_CODE", length = 500)
	public String getDcoPidCode() {
		return this.dcoPidCode;
	}

	public void setDcoPidCode(String dcoPidCode) {
		this.dcoPidCode = dcoPidCode;
	}

	@Column(name = "DCO_DAC_CODE", length = 500)
	public String getDcoDacCode() {
		return this.dcoDacCode;
	}

	public void setDcoDacCode(String dcoDacCode) {
		this.dcoDacCode = dcoDacCode;
	}

	@Column(name = "DCO_FON_COD_SAISI", length = 500)
	public String getDcoFonCodSaisi() {
		return this.dcoFonCodSaisi;
	}

	public void setDcoFonCodSaisi(String dcoFonCodSaisi) {
		this.dcoFonCodSaisi = dcoFonCodSaisi;
	}

	@Column(name = "DCO_OBSERVATION", length = 500)
	public String getDcoObservation() {
		return this.dcoObservation;
	}

	public void setDcoObservation(String dcoObservation) {
		this.dcoObservation = dcoObservation;
	}

	@Column(name = "DCO_COR_NUM", length = 500)
	public String getDcoCorNum() {
		return this.dcoCorNum;
	}

	public void setDcoCorNum(String dcoCorNum) {
		this.dcoCorNum = dcoCorNum;
	}

}
