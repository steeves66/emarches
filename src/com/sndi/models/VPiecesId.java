package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPiecesId generated by hbm2java
 */
@Embeddable
public class VPiecesId implements java.io.Serializable {

	private BigDecimal VPi;
	private BigDecimal pidCode;
	private String pidLibelle;
	private String pidTpiCode;
	private String pidStaCode;
	private Date pidDteSaisi;
	private String pidDacCode;
	private String pidConforme;
	private String pidObservation;
	private String pidPresente;

	public VPiecesId() {
	}

	public VPiecesId(BigDecimal pidCode) {
		this.pidCode = pidCode;
	}

	public VPiecesId(BigDecimal VPi, BigDecimal pidCode, String pidLibelle, String pidTpiCode, String pidStaCode,
			Date pidDteSaisi, String pidDacCode, String pidConforme, String pidObservation, String pidPresente) {
		this.VPi = VPi;
		this.pidCode = pidCode;
		this.pidLibelle = pidLibelle;
		this.pidTpiCode = pidTpiCode;
		this.pidStaCode = pidStaCode;
		this.pidDteSaisi = pidDteSaisi;
		this.pidDacCode = pidDacCode;
		this.pidConforme = pidConforme;
		this.pidObservation = pidObservation;
		this.pidPresente = pidPresente;
	}

	@Column(name = "V_PI", precision = 22, scale = 0)
	public BigDecimal getVPi() {
		return this.VPi;
	}

	public void setVPi(BigDecimal VPi) {
		this.VPi = VPi;
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

	@Column(name = "PID_CONFORME", length = 3)
	public String getPidConforme() {
		return this.pidConforme;
	}

	public void setPidConforme(String pidConforme) {
		this.pidConforme = pidConforme;
	}

	@Column(name = "PID_OBSERVATION", length = 2000)
	public String getPidObservation() {
		return this.pidObservation;
	}

	public void setPidObservation(String pidObservation) {
		this.pidObservation = pidObservation;
	}

	@Column(name = "PID_PRESENTE", length = 3)
	public String getPidPresente() {
		return this.pidPresente;
	}

	public void setPidPresente(String pidPresente) {
		this.pidPresente = pidPresente;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VPiecesId))
			return false;
		VPiecesId castOther = (VPiecesId) other;

		return ((this.getVPi() == castOther.getVPi())
				|| (this.getVPi() != null && castOther.getVPi() != null && this.getVPi().equals(castOther.getVPi())))
				&& ((this.getPidCode() == castOther.getPidCode()) || (this.getPidCode() != null
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
				&& ((this.getPidDacCode() == castOther.getPidDacCode()) || (this.getPidDacCode() != null
						&& castOther.getPidDacCode() != null && this.getPidDacCode().equals(castOther.getPidDacCode())))
				&& ((this.getPidConforme() == castOther.getPidConforme())
						|| (this.getPidConforme() != null && castOther.getPidConforme() != null
								&& this.getPidConforme().equals(castOther.getPidConforme())))
				&& ((this.getPidObservation() == castOther.getPidObservation())
						|| (this.getPidObservation() != null && castOther.getPidObservation() != null
								&& this.getPidObservation().equals(castOther.getPidObservation())))
				&& ((this.getPidPresente() == castOther.getPidPresente())
						|| (this.getPidPresente() != null && castOther.getPidPresente() != null
								&& this.getPidPresente().equals(castOther.getPidPresente())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getVPi() == null ? 0 : this.getVPi().hashCode());
		result = 37 * result + (getPidCode() == null ? 0 : this.getPidCode().hashCode());
		result = 37 * result + (getPidLibelle() == null ? 0 : this.getPidLibelle().hashCode());
		result = 37 * result + (getPidTpiCode() == null ? 0 : this.getPidTpiCode().hashCode());
		result = 37 * result + (getPidStaCode() == null ? 0 : this.getPidStaCode().hashCode());
		result = 37 * result + (getPidDteSaisi() == null ? 0 : this.getPidDteSaisi().hashCode());
		result = 37 * result + (getPidDacCode() == null ? 0 : this.getPidDacCode().hashCode());
		result = 37 * result + (getPidConforme() == null ? 0 : this.getPidConforme().hashCode());
		result = 37 * result + (getPidObservation() == null ? 0 : this.getPidObservation().hashCode());
		result = 37 * result + (getPidPresente() == null ? 0 : this.getPidPresente().hashCode());
		return result;
	}

}
