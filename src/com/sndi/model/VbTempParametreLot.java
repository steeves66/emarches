package com.sndi.model;
// Generated 3 f�vr. 2020 13:07:31 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VbTempParametreLot generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "VB_TEMP_PARAMETRE_LOT")
public class VbTempParametreLot implements java.io.Serializable {

	private long tempNum;
	private String tempType;
	private String tempOpeMatricule;
	private Date tempLaaDteSaisi;
	private String tempLaaNbrTotLot;
	private String tempLaaNbrLotDebut;
	private String tempLaaNbrLotFin;
	private String tempLaaLibGenerique;
	private String tempLaaImputation;
	private String tempLaaCautLot;
	private String tempLaaMtLot;
	private String tempLaaAaoCode;
	private String tempLaaAutre;
	private String tempLaaAutre1;
	private String tempLaaDacCode;
	private String tempLaaDelaiExe;
	private String laaMtEst;
	private String tempLaaLieuExe;
	

	public VbTempParametreLot() {
	}

	public VbTempParametreLot(long tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParametreLot(long tempNum, String tempType, String tempOpeMatricule, Date tempLaaDteSaisi,
			String tempLaaNbrTotLot, String tempLaaNbrLotDebut, String tempLaaNbrLotFin, String tempLaaLibGenerique,
			String tempLaaImputation, String tempLaaCautLot, String tempLaaMtLot, String tempLaaAaoCode,
			String tempLaaAutre, String tempLaaAutre1,String tempLaaDacCode,String tempLaaDelaiExe, String laaMtEst,
			String tempLaaLieuExe) {
		this.tempNum = tempNum;
		this.tempType = tempType;
		this.tempOpeMatricule = tempOpeMatricule;
		this.tempLaaDteSaisi = tempLaaDteSaisi;
		this.tempLaaNbrTotLot = tempLaaNbrTotLot;
		this.tempLaaNbrLotDebut = tempLaaNbrLotDebut;
		this.tempLaaNbrLotFin = tempLaaNbrLotFin;
		this.tempLaaLibGenerique = tempLaaLibGenerique;
		this.tempLaaImputation = tempLaaImputation;
		this.tempLaaCautLot = tempLaaCautLot;
		this.tempLaaMtLot = tempLaaMtLot;
		this.tempLaaAaoCode = tempLaaAaoCode;
		this.tempLaaAutre = tempLaaAutre;
		this.tempLaaAutre1 = tempLaaAutre1;
		this.tempLaaDacCode = tempLaaDacCode;
		this.tempLaaDelaiExe = tempLaaDelaiExe;
		this.laaMtEst = laaMtEst;
		this.tempLaaLieuExe = tempLaaLieuExe;
	}

	
	@Id
	@Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)
	public long getTempNum() {
		return this.tempNum;
	}

	public void setTempNum(long tempNum) {
		this.tempNum = tempNum;
	}

	@Column(name = "TEMP_TYPE", length = 500)
	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	@Column(name = "TEMP_OPE_MATRICULE", length = 500)
	public String getTempOpeMatricule() {
		return this.tempOpeMatricule;
	}

	public void setTempOpeMatricule(String tempOpeMatricule) {
		this.tempOpeMatricule = tempOpeMatricule;
	}

	@Column(name = "TEMP_LAA_DTE_SAISI", length = 7)
	public Date getTempLaaDteSaisi() {
		return this.tempLaaDteSaisi;
	}

	public void setTempLaaDteSaisi(Date tempLaaDteSaisi) {
		this.tempLaaDteSaisi = tempLaaDteSaisi;
	}

	@Column(name = "TEMP_LAA_NBR_TOT_LOT", length = 500)
	public String getTempLaaNbrTotLot() {
		return this.tempLaaNbrTotLot;
	}

	public void setTempLaaNbrTotLot(String tempLaaNbrTotLot) {
		this.tempLaaNbrTotLot = tempLaaNbrTotLot;
	}

	@Column(name = "TEMP_LAA_NBR_LOT_DEBUT", length = 500)
	public String getTempLaaNbrLotDebut() {
		return this.tempLaaNbrLotDebut;
	}

	public void setTempLaaNbrLotDebut(String tempLaaNbrLotDebut) {
		this.tempLaaNbrLotDebut = tempLaaNbrLotDebut;
	}

	@Column(name = "TEMP_LAA_NBR_LOT_FIN", length = 500)
	public String getTempLaaNbrLotFin() {
		return this.tempLaaNbrLotFin;
	}

	public void setTempLaaNbrLotFin(String tempLaaNbrLotFin) {
		this.tempLaaNbrLotFin = tempLaaNbrLotFin;
	}

	@Column(name = "TEMP_LAA_LIB_GENERIQUE", length = 500)
	public String getTempLaaLibGenerique() {
		return this.tempLaaLibGenerique;
	}

	public void setTempLaaLibGenerique(String tempLaaLibGenerique) {
		this.tempLaaLibGenerique = tempLaaLibGenerique;
	}

	@Column(name = "TEMP_LAA_IMPUTATION", length = 500)
	public String getTempLaaImputation() {
		return this.tempLaaImputation;
	}

	public void setTempLaaImputation(String tempLaaImputation) {
		this.tempLaaImputation = tempLaaImputation;
	}

	@Column(name = "TEMP_LAA_CAUT_LOT", length = 500)
	public String getTempLaaCautLot() {
		return this.tempLaaCautLot;
	}

	public void setTempLaaCautLot(String tempLaaCautLot) {
		this.tempLaaCautLot = tempLaaCautLot;
	}

	@Column(name = "TEMP_LAA_MT_LOT", length = 500)
	public String getTempLaaMtLot() {
		return this.tempLaaMtLot;
	}

	public void setTempLaaMtLot(String tempLaaMtLot) {
		this.tempLaaMtLot = tempLaaMtLot;
	}

	@Column(name = "TEMP_LAA_AAO_CODE", length = 500)
	public String getTempLaaAaoCode() {
		return this.tempLaaAaoCode;
	}

	public void setTempLaaAaoCode(String tempLaaAaoCode) {
		this.tempLaaAaoCode = tempLaaAaoCode;
	}

	@Column(name = "TEMP_LAA_AUTRE", length = 500)
	public String getTempLaaAutre() {
		return this.tempLaaAutre;
	}

	public void setTempLaaAutre(String tempLaaAutre) {
		this.tempLaaAutre = tempLaaAutre;
	}

	@Column(name = "TEMP_LAA_AUTRE_1", length = 500)
	public String getTempLaaAutre1() {
		return this.tempLaaAutre1;
	}

	public void setTempLaaAutre1(String tempLaaAutre1) {
		this.tempLaaAutre1 = tempLaaAutre1;
	}
	
	@Column(name = "TEMP_LAA_DAC_CODE", length = 500)
	public String getTempLaaDacCode() {
		return this.tempLaaDacCode;
	}

	public void setTempLaaDacCode(String tempLaaDacCode) {
		this.tempLaaDacCode = tempLaaDacCode;
	}
	
	@Column(name = "TEMP_LAA_DELAI_EXE", length = 500)
	public String getTempLaaDelaiExe() {
		return this.tempLaaDelaiExe;
	}

	public void setTempLaaDelaiExe(String tempLaaDelaiExe) {
		this.tempLaaDelaiExe = tempLaaDelaiExe;
	}
	
	@Column(name = "LAA_MT_EST", length = 500)
	public String getLaaMtEst() {
		return this.laaMtEst;
	}

	public void setLaaMtEst(String laaMtEst) {
		this.laaMtEst = laaMtEst;
	}

	@Column(name = "TEMP_LAA_LIEU_EXE", length = 500)
	public String getTempLaaLieuExe() {
		return this.tempLaaLieuExe;
	}

	public void setTempLaaLieuExe(String tempLaaLieuExe) {
		this.tempLaaLieuExe = tempLaaLieuExe;
	}

}
