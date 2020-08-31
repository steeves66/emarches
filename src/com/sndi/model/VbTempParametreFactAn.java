package com.sndi.model;
// Generated 30 ao�t 2020 18:10:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
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
 * VbTempParametreFactAn generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "VB_TEMP_PARAMETRE_FACT_AN")
public class VbTempParametreFactAn implements java.io.Serializable {

	private BigDecimal tempNum;
	private String tempOpeMatricule;
	private String tempType;
	private String tempDacCode;
	private BigDecimal tempLotDebut;
	private BigDecimal tempLotFin;
	private String tempLotPlage;
	private long tempNbrLot;

	public VbTempParametreFactAn() {
	}

	public VbTempParametreFactAn(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParametreFactAn(BigDecimal tempNum, String tempOpeMatricule, String tempType, String tempDacCode,
			BigDecimal tempLotDebut, BigDecimal tempLotFin, String tempLotPlage, long tempNbrLot) {
		this.tempNum = tempNum;
		this.tempOpeMatricule = tempOpeMatricule;
		this.tempType = tempType;
		this.tempDacCode = tempDacCode;
		this.tempLotDebut = tempLotDebut;
		this.tempLotFin = tempLotFin;
		this.tempLotPlage = tempLotPlage;
		this.tempNbrLot = tempNbrLot;
	}

	
	@Id
	@SequenceGenerator(name = "SEQ_TEMP_PARAMETRE_AN_Sequence", sequenceName = "SEQ_TEMP_PARAMETRE_AN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TEMP_PARAMETRE_AN_Sequence")
	@Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTempNum() {
		return this.tempNum;
	}

	public void setTempNum(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	@Column(name = "TEMP_OPE_MATRICULE", length = 500)
	public String getTempOpeMatricule() {
		return this.tempOpeMatricule;
	}

	public void setTempOpeMatricule(String tempOpeMatricule) {
		this.tempOpeMatricule = tempOpeMatricule;
	}

	@Column(name = "TEMP_TYPE", length = 500)
	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	@Column(name = "TEMP_DAC_CODE", length = 500)
	public String getTempDacCode() {
		return this.tempDacCode;
	}

	public void setTempDacCode(String tempDacCode) {
		this.tempDacCode = tempDacCode;
	}

	@Column(name = "TEMP_LOT_DEBUT", precision = 22, scale = 0)
	public BigDecimal getTempLotDebut() {
		return this.tempLotDebut;
	}

	public void setTempLotDebut(BigDecimal tempLotDebut) {
		this.tempLotDebut = tempLotDebut;
	}

	@Column(name = "TEMP_LOT_FIN", precision = 22, scale = 0)
	public BigDecimal getTempLotFin() {
		return this.tempLotFin;
	}

	public void setTempLotFin(BigDecimal tempLotFin) {
		this.tempLotFin = tempLotFin;
	}

	@Column(name = "TEMP_LOT_PLAGE", length = 500)
	public String getTempLotPlage() {
		return this.tempLotPlage;
	}

	public void setTempLotPlage(String tempLotPlage) {
		this.tempLotPlage = tempLotPlage;
	}

	@Column(name = "TEMP_NBR_LOT", precision = 22, scale = 0)
	public long getTempNbrLot() {
		return this.tempNbrLot;
	}

	public void setTempNbrLot(long tempNbrLot) {
		this.tempNbrLot = tempNbrLot;
	}

}