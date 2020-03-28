package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypePiecesDacId generated by hbm2java
 */
@Embeddable
public class VbTypePiecesDacId implements java.io.Serializable {

	private String tpiCode;
	private String tpiLibelle;
	private String tpiDacPec;
	private String tpiMdtCode;
	private String tpiSecNum;

	public VbTypePiecesDacId() {
	}

	public VbTypePiecesDacId(String tpiCode) {
		this.tpiCode = tpiCode;
	}

	public VbTypePiecesDacId(String tpiCode, String tpiLibelle, String tpiDacPec, String tpiMdtCode, String tpiSecNum) {
		this.tpiCode = tpiCode;
		this.tpiLibelle = tpiLibelle;
		this.tpiDacPec = tpiDacPec;
		this.tpiMdtCode = tpiMdtCode;
		this.tpiSecNum = tpiSecNum;
	}

	@Column(name = "TPI_CODE", nullable = false, length = 10)
	public String getTpiCode() {
		return this.tpiCode;
	}

	public void setTpiCode(String tpiCode) {
		this.tpiCode = tpiCode;
	}

	@Column(name = "TPI_LIBELLE", length = 1000)
	public String getTpiLibelle() {
		return this.tpiLibelle;
	}

	public void setTpiLibelle(String tpiLibelle) {
		this.tpiLibelle = tpiLibelle;
	}

	@Column(name = "TPI_DAC_PEC", length = 15)
	public String getTpiDacPec() {
		return this.tpiDacPec;
	}

	public void setTpiDacPec(String tpiDacPec) {
		this.tpiDacPec = tpiDacPec;
	}

	@Column(name = "TPI_MDT_CODE", length = 10)
	public String getTpiMdtCode() {
		return this.tpiMdtCode;
	}

	public void setTpiMdtCode(String tpiMdtCode) {
		this.tpiMdtCode = tpiMdtCode;
	}

	@Column(name = "TPI_SEC_NUM", length = 5)
	public String getTpiSecNum() {
		return this.tpiSecNum;
	}

	public void setTpiSecNum(String tpiSecNum) {
		this.tpiSecNum = tpiSecNum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypePiecesDacId))
			return false;
		VbTypePiecesDacId castOther = (VbTypePiecesDacId) other;

		return ((this.getTpiCode() == castOther.getTpiCode()) || (this.getTpiCode() != null
				&& castOther.getTpiCode() != null && this.getTpiCode().equals(castOther.getTpiCode())))
				&& ((this.getTpiLibelle() == castOther.getTpiLibelle()) || (this.getTpiLibelle() != null
						&& castOther.getTpiLibelle() != null && this.getTpiLibelle().equals(castOther.getTpiLibelle())))
				&& ((this.getTpiDacPec() == castOther.getTpiDacPec()) || (this.getTpiDacPec() != null
						&& castOther.getTpiDacPec() != null && this.getTpiDacPec().equals(castOther.getTpiDacPec())))
				&& ((this.getTpiMdtCode() == castOther.getTpiMdtCode()) || (this.getTpiMdtCode() != null
						&& castOther.getTpiMdtCode() != null && this.getTpiMdtCode().equals(castOther.getTpiMdtCode())))
				&& ((this.getTpiSecNum() == castOther.getTpiSecNum()) || (this.getTpiSecNum() != null
						&& castOther.getTpiSecNum() != null && this.getTpiSecNum().equals(castOther.getTpiSecNum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTpiCode() == null ? 0 : this.getTpiCode().hashCode());
		result = 37 * result + (getTpiLibelle() == null ? 0 : this.getTpiLibelle().hashCode());
		result = 37 * result + (getTpiDacPec() == null ? 0 : this.getTpiDacPec().hashCode());
		result = 37 * result + (getTpiMdtCode() == null ? 0 : this.getTpiMdtCode().hashCode());
		result = 37 * result + (getTpiSecNum() == null ? 0 : this.getTpiSecNum().hashCode());
		return result;
	}

}
