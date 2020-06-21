package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPieceDacId generated by hbm2java
 */
@Embeddable
public class VPieceDacId implements java.io.Serializable {

	private BigDecimal pidCode;
	private String pidTpiCode;
	private String pidLibelle;
	private String pidDacCode;
	private String tpiMdtCode;

	public VPieceDacId() {
	}

	public VPieceDacId(BigDecimal pidCode) {
		this.pidCode = pidCode;
	}

	public VPieceDacId(BigDecimal pidCode, String pidTpiCode, String pidLibelle, String pidDacCode, String tpiMdtCode) {
		this.pidCode = pidCode;
		this.pidTpiCode = pidTpiCode;
		this.pidLibelle = pidLibelle;
		this.pidDacCode = pidDacCode;
		this.tpiMdtCode = tpiMdtCode;
	}

	@Column(name = "PID_CODE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPidCode() {
		return this.pidCode;
	}

	public void setPidCode(BigDecimal pidCode) {
		this.pidCode = pidCode;
	}

	@Column(name = "PID_TPI_CODE", length = 10)
	public String getPidTpiCode() {
		return this.pidTpiCode;
	}

	public void setPidTpiCode(String pidTpiCode) {
		this.pidTpiCode = pidTpiCode;
	}

	@Column(name = "PID_LIBELLE", length = 1008)
	public String getPidLibelle() {
		return this.pidLibelle;
	}

	public void setPidLibelle(String pidLibelle) {
		this.pidLibelle = pidLibelle;
	}

	@Column(name = "PID_DAC_CODE", length = 20)
	public String getPidDacCode() {
		return this.pidDacCode;
	}

	public void setPidDacCode(String pidDacCode) {
		this.pidDacCode = pidDacCode;
	}

	@Column(name = "TPI_MDT_CODE", length = 10)
	public String getTpiMdtCode() {
		return this.tpiMdtCode;
	}

	public void setTpiMdtCode(String tpiMdtCode) {
		this.tpiMdtCode = tpiMdtCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VPieceDacId))
			return false;
		VPieceDacId castOther = (VPieceDacId) other;

		return ((this.getPidCode() == castOther.getPidCode()) || (this.getPidCode() != null
				&& castOther.getPidCode() != null && this.getPidCode().equals(castOther.getPidCode())))
				&& ((this.getPidTpiCode() == castOther.getPidTpiCode()) || (this.getPidTpiCode() != null
						&& castOther.getPidTpiCode() != null && this.getPidTpiCode().equals(castOther.getPidTpiCode())))
				&& ((this.getPidLibelle() == castOther.getPidLibelle()) || (this.getPidLibelle() != null
						&& castOther.getPidLibelle() != null && this.getPidLibelle().equals(castOther.getPidLibelle())))
				&& ((this.getPidDacCode() == castOther.getPidDacCode()) || (this.getPidDacCode() != null
						&& castOther.getPidDacCode() != null && this.getPidDacCode().equals(castOther.getPidDacCode())))
				&& ((this.getTpiMdtCode() == castOther.getTpiMdtCode())
						|| (this.getTpiMdtCode() != null && castOther.getTpiMdtCode() != null
								&& this.getTpiMdtCode().equals(castOther.getTpiMdtCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPidCode() == null ? 0 : this.getPidCode().hashCode());
		result = 37 * result + (getPidTpiCode() == null ? 0 : this.getPidTpiCode().hashCode());
		result = 37 * result + (getPidLibelle() == null ? 0 : this.getPidLibelle().hashCode());
		result = 37 * result + (getPidDacCode() == null ? 0 : this.getPidDacCode().hashCode());
		result = 37 * result + (getTpiMdtCode() == null ? 0 : this.getTpiMdtCode().hashCode());
		return result;
	}

}
