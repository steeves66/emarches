package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPiecesDaoId generated by hbm2java
 */
@Embeddable
public class VPiecesDaoId implements java.io.Serializable {

	private BigDecimal pidCode;
	private String pidLibelle;
	private String pidTpiCode;
	private String pidStaCode;
	private Date pidDteSaisi;
	private String pidDacCode;

	public VPiecesDaoId() {
	}

	public VPiecesDaoId(BigDecimal pidCode) {
		this.pidCode = pidCode;
	}

	public VPiecesDaoId(BigDecimal pidCode, String pidLibelle, String pidTpiCode, String pidStaCode, Date pidDteSaisi,
			String pidDacCode) {
		this.pidCode = pidCode;
		this.pidLibelle = pidLibelle;
		this.pidTpiCode = pidTpiCode;
		this.pidStaCode = pidStaCode;
		this.pidDteSaisi = pidDteSaisi;
		this.pidDacCode = pidDacCode;
	}

	@Column(name = "PID_CODE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPidCode() {
		return this.pidCode;
	}

	public void setPidCode(BigDecimal pidCode) {
		this.pidCode = pidCode;
	}

	@Column(name = "PID_LIBELLE", length = 1000)
	public String getPidLibelle() {
		return this.pidLibelle;
	}

	public void setPidLibelle(String pidLibelle) {
		this.pidLibelle = pidLibelle;
	}

	@Column(name = "PID_TPI_CODE", length = 10)
	public String getPidTpiCode() {
		return this.pidTpiCode;
	}

	public void setPidTpiCode(String pidTpiCode) {
		this.pidTpiCode = pidTpiCode;
	}

	@Column(name = "PID_STA_CODE", length = 3)
	public String getPidStaCode() {
		return this.pidStaCode;
	}

	public void setPidStaCode(String pidStaCode) {
		this.pidStaCode = pidStaCode;
	}

	@Column(name = "PID_DTE_SAISI", length = 7)
	public Date getPidDteSaisi() {
		return this.pidDteSaisi;
	}

	public void setPidDteSaisi(Date pidDteSaisi) {
		this.pidDteSaisi = pidDteSaisi;
	}

	@Column(name = "PID_DAC_CODE", length = 20)
	public String getPidDacCode() {
		return this.pidDacCode;
	}

	public void setPidDacCode(String pidDacCode) {
		this.pidDacCode = pidDacCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VPiecesDaoId))
			return false;
		VPiecesDaoId castOther = (VPiecesDaoId) other;

		return ((this.getPidCode() == castOther.getPidCode()) || (this.getPidCode() != null
				&& castOther.getPidCode() != null && this.getPidCode().equals(castOther.getPidCode())))
				&& ((this.getPidLibelle() == castOther.getPidLibelle()) || (this.getPidLibelle() != null
						&& castOther.getPidLibelle() != null && this.getPidLibelle().equals(castOther.getPidLibelle())))
				&& ((this.getPidTpiCode() == castOther.getPidTpiCode()) || (this.getPidTpiCode() != null
						&& castOther.getPidTpiCode() != null && this.getPidTpiCode().equals(castOther.getPidTpiCode())))
				&& ((this.getPidStaCode() == castOther.getPidStaCode()) || (this.getPidStaCode() != null
						&& castOther.getPidStaCode() != null && this.getPidStaCode().equals(castOther.getPidStaCode())))
				&& ((this.getPidDteSaisi() == castOther.getPidDteSaisi())
						|| (this.getPidDteSaisi() != null && castOther.getPidDteSaisi() != null
								&& this.getPidDteSaisi().equals(castOther.getPidDteSaisi())))
				&& ((this.getPidDacCode() == castOther.getPidDacCode())
						|| (this.getPidDacCode() != null && castOther.getPidDacCode() != null
								&& this.getPidDacCode().equals(castOther.getPidDacCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPidCode() == null ? 0 : this.getPidCode().hashCode());
		result = 37 * result + (getPidLibelle() == null ? 0 : this.getPidLibelle().hashCode());
		result = 37 * result + (getPidTpiCode() == null ? 0 : this.getPidTpiCode().hashCode());
		result = 37 * result + (getPidStaCode() == null ? 0 : this.getPidStaCode().hashCode());
		result = 37 * result + (getPidDteSaisi() == null ? 0 : this.getPidDteSaisi().hashCode());
		result = 37 * result + (getPidDacCode() == null ? 0 : this.getPidDacCode().hashCode());
		return result;
	}

}
