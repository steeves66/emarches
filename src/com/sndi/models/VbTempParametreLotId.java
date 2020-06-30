package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTempParametreLotId generated by hbm2java
 */
@Embeddable
public class VbTempParametreLotId implements java.io.Serializable {

	private BigDecimal tempNum;
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

	public VbTempParametreLotId() {
	}

	public VbTempParametreLotId(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParametreLotId(BigDecimal tempNum, String tempType, String tempOpeMatricule, Date tempLaaDteSaisi,
			String tempLaaNbrTotLot, String tempLaaNbrLotDebut, String tempLaaNbrLotFin, String tempLaaLibGenerique,
			String tempLaaImputation, String tempLaaCautLot, String tempLaaMtLot, String tempLaaAaoCode,
			String tempLaaAutre, String tempLaaAutre1, String tempLaaDacCode) {
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
	}

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTempParametreLotId))
			return false;
		VbTempParametreLotId castOther = (VbTempParametreLotId) other;

		return ((this.getTempNum() == castOther.getTempNum()) || (this.getTempNum() != null
				&& castOther.getTempNum() != null && this.getTempNum().equals(castOther.getTempNum())))
				&& ((this.getTempType() == castOther.getTempType()) || (this.getTempType() != null
						&& castOther.getTempType() != null && this.getTempType().equals(castOther.getTempType())))
				&& ((this.getTempOpeMatricule() == castOther.getTempOpeMatricule())
						|| (this.getTempOpeMatricule() != null && castOther.getTempOpeMatricule() != null
								&& this.getTempOpeMatricule().equals(castOther.getTempOpeMatricule())))
				&& ((this.getTempLaaDteSaisi() == castOther.getTempLaaDteSaisi())
						|| (this.getTempLaaDteSaisi() != null && castOther.getTempLaaDteSaisi() != null
								&& this.getTempLaaDteSaisi().equals(castOther.getTempLaaDteSaisi())))
				&& ((this.getTempLaaNbrTotLot() == castOther.getTempLaaNbrTotLot())
						|| (this.getTempLaaNbrTotLot() != null && castOther.getTempLaaNbrTotLot() != null
								&& this.getTempLaaNbrTotLot().equals(castOther.getTempLaaNbrTotLot())))
				&& ((this.getTempLaaNbrLotDebut() == castOther.getTempLaaNbrLotDebut())
						|| (this.getTempLaaNbrLotDebut() != null && castOther.getTempLaaNbrLotDebut() != null
								&& this.getTempLaaNbrLotDebut().equals(castOther.getTempLaaNbrLotDebut())))
				&& ((this.getTempLaaNbrLotFin() == castOther.getTempLaaNbrLotFin())
						|| (this.getTempLaaNbrLotFin() != null && castOther.getTempLaaNbrLotFin() != null
								&& this.getTempLaaNbrLotFin().equals(castOther.getTempLaaNbrLotFin())))
				&& ((this.getTempLaaLibGenerique() == castOther.getTempLaaLibGenerique())
						|| (this.getTempLaaLibGenerique() != null && castOther.getTempLaaLibGenerique() != null
								&& this.getTempLaaLibGenerique().equals(castOther.getTempLaaLibGenerique())))
				&& ((this.getTempLaaImputation() == castOther.getTempLaaImputation())
						|| (this.getTempLaaImputation() != null && castOther.getTempLaaImputation() != null
								&& this.getTempLaaImputation().equals(castOther.getTempLaaImputation())))
				&& ((this.getTempLaaCautLot() == castOther.getTempLaaCautLot())
						|| (this.getTempLaaCautLot() != null && castOther.getTempLaaCautLot() != null
								&& this.getTempLaaCautLot().equals(castOther.getTempLaaCautLot())))
				&& ((this.getTempLaaMtLot() == castOther.getTempLaaMtLot())
						|| (this.getTempLaaMtLot() != null && castOther.getTempLaaMtLot() != null
								&& this.getTempLaaMtLot().equals(castOther.getTempLaaMtLot())))
				&& ((this.getTempLaaAaoCode() == castOther.getTempLaaAaoCode())
						|| (this.getTempLaaAaoCode() != null && castOther.getTempLaaAaoCode() != null
								&& this.getTempLaaAaoCode().equals(castOther.getTempLaaAaoCode())))
				&& ((this.getTempLaaAutre() == castOther.getTempLaaAutre())
						|| (this.getTempLaaAutre() != null && castOther.getTempLaaAutre() != null
								&& this.getTempLaaAutre().equals(castOther.getTempLaaAutre())))
				&& ((this.getTempLaaAutre1() == castOther.getTempLaaAutre1())
						|| (this.getTempLaaAutre1() != null && castOther.getTempLaaAutre1() != null
								&& this.getTempLaaAutre1().equals(castOther.getTempLaaAutre1())))
				&& ((this.getTempLaaDacCode() == castOther.getTempLaaDacCode())
						|| (this.getTempLaaDacCode() != null && castOther.getTempLaaDacCode() != null
								&& this.getTempLaaDacCode().equals(castOther.getTempLaaDacCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTempNum() == null ? 0 : this.getTempNum().hashCode());
		result = 37 * result + (getTempType() == null ? 0 : this.getTempType().hashCode());
		result = 37 * result + (getTempOpeMatricule() == null ? 0 : this.getTempOpeMatricule().hashCode());
		result = 37 * result + (getTempLaaDteSaisi() == null ? 0 : this.getTempLaaDteSaisi().hashCode());
		result = 37 * result + (getTempLaaNbrTotLot() == null ? 0 : this.getTempLaaNbrTotLot().hashCode());
		result = 37 * result + (getTempLaaNbrLotDebut() == null ? 0 : this.getTempLaaNbrLotDebut().hashCode());
		result = 37 * result + (getTempLaaNbrLotFin() == null ? 0 : this.getTempLaaNbrLotFin().hashCode());
		result = 37 * result + (getTempLaaLibGenerique() == null ? 0 : this.getTempLaaLibGenerique().hashCode());
		result = 37 * result + (getTempLaaImputation() == null ? 0 : this.getTempLaaImputation().hashCode());
		result = 37 * result + (getTempLaaCautLot() == null ? 0 : this.getTempLaaCautLot().hashCode());
		result = 37 * result + (getTempLaaMtLot() == null ? 0 : this.getTempLaaMtLot().hashCode());
		result = 37 * result + (getTempLaaAaoCode() == null ? 0 : this.getTempLaaAaoCode().hashCode());
		result = 37 * result + (getTempLaaAutre() == null ? 0 : this.getTempLaaAutre().hashCode());
		result = 37 * result + (getTempLaaAutre1() == null ? 0 : this.getTempLaaAutre1().hashCode());
		result = 37 * result + (getTempLaaDacCode() == null ? 0 : this.getTempLaaDacCode().hashCode());
		return result;
	}

}
