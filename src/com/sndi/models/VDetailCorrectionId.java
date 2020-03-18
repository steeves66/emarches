package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDetailCorrectionId generated by hbm2java
 */
@Embeddable
public class VDetailCorrectionId implements java.io.Serializable {

	private BigDecimal pidCode;
	private String pidLibelle;
	private String dcoDacCode;
	private String dcoPresente;
	private String dcoConforme;
	private String dcoObservation;
	private String dcoRespo;
	private String corResultatRespo;
	private String corObservationRespo;
	private String ac;
	private String operateur;

	public VDetailCorrectionId() {
	}

	public VDetailCorrectionId(BigDecimal pidCode) {
		this.pidCode = pidCode;
	}

	public VDetailCorrectionId(BigDecimal pidCode, String pidLibelle, String dcoDacCode, String dcoPresente,
			String dcoConforme, String dcoObservation, String dcoRespo, String corResultatRespo,
			String corObservationRespo, String ac, String operateur) {
		this.pidCode = pidCode;
		this.pidLibelle = pidLibelle;
		this.dcoDacCode = dcoDacCode;
		this.dcoPresente = dcoPresente;
		this.dcoConforme = dcoConforme;
		this.dcoObservation = dcoObservation;
		this.dcoRespo = dcoRespo;
		this.corResultatRespo = corResultatRespo;
		this.corObservationRespo = corObservationRespo;
		this.ac = ac;
		this.operateur = operateur;
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

	@Column(name = "DCO_DAC_CODE", length = 20)
	public String getDcoDacCode() {
		return this.dcoDacCode;
	}

	public void setDcoDacCode(String dcoDacCode) {
		this.dcoDacCode = dcoDacCode;
	}

	@Column(name = "DCO_PRESENTE", length = 3)
	public String getDcoPresente() {
		return this.dcoPresente;
	}

	public void setDcoPresente(String dcoPresente) {
		this.dcoPresente = dcoPresente;
	}

	@Column(name = "DCO_CONFORME", length = 3)
	public String getDcoConforme() {
		return this.dcoConforme;
	}

	public void setDcoConforme(String dcoConforme) {
		this.dcoConforme = dcoConforme;
	}

	@Column(name = "DCO_OBSERVATION", length = 4000)
	public String getDcoObservation() {
		return this.dcoObservation;
	}

	public void setDcoObservation(String dcoObservation) {
		this.dcoObservation = dcoObservation;
	}

	@Column(name = "DCO_RESPO", length = 1)
	public String getDcoRespo() {
		return this.dcoRespo;
	}

	public void setDcoRespo(String dcoRespo) {
		this.dcoRespo = dcoRespo;
	}

	@Column(name = "COR_RESULTAT_RESPO", length = 20)
	public String getCorResultatRespo() {
		return this.corResultatRespo;
	}

	public void setCorResultatRespo(String corResultatRespo) {
		this.corResultatRespo = corResultatRespo;
	}

	@Column(name = "COR_OBSERVATION_RESPO", length = 4000)
	public String getCorObservationRespo() {
		return this.corObservationRespo;
	}

	public void setCorObservationRespo(String corObservationRespo) {
		this.corObservationRespo = corObservationRespo;
	}

	@Column(name = "AC", length = 521)
	public String getAc() {
		return this.ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	@Column(name = "OPERATEUR", length = 281)
	public String getOperateur() {
		return this.operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDetailCorrectionId))
			return false;
		VDetailCorrectionId castOther = (VDetailCorrectionId) other;

		return ((this.getPidCode() == castOther.getPidCode()) || (this.getPidCode() != null
				&& castOther.getPidCode() != null && this.getPidCode().equals(castOther.getPidCode())))
				&& ((this.getPidLibelle() == castOther.getPidLibelle()) || (this.getPidLibelle() != null
						&& castOther.getPidLibelle() != null && this.getPidLibelle().equals(castOther.getPidLibelle())))
				&& ((this.getDcoDacCode() == castOther.getDcoDacCode()) || (this.getDcoDacCode() != null
						&& castOther.getDcoDacCode() != null && this.getDcoDacCode().equals(castOther.getDcoDacCode())))
				&& ((this.getDcoPresente() == castOther.getDcoPresente())
						|| (this.getDcoPresente() != null && castOther.getDcoPresente() != null
								&& this.getDcoPresente().equals(castOther.getDcoPresente())))
				&& ((this.getDcoConforme() == castOther.getDcoConforme())
						|| (this.getDcoConforme() != null && castOther.getDcoConforme() != null
								&& this.getDcoConforme().equals(castOther.getDcoConforme())))
				&& ((this.getDcoObservation() == castOther.getDcoObservation())
						|| (this.getDcoObservation() != null && castOther.getDcoObservation() != null
								&& this.getDcoObservation().equals(castOther.getDcoObservation())))
				&& ((this.getDcoRespo() == castOther.getDcoRespo()) || (this.getDcoRespo() != null
						&& castOther.getDcoRespo() != null && this.getDcoRespo().equals(castOther.getDcoRespo())))
				&& ((this.getCorResultatRespo() == castOther.getCorResultatRespo())
						|| (this.getCorResultatRespo() != null && castOther.getCorResultatRespo() != null
								&& this.getCorResultatRespo().equals(castOther.getCorResultatRespo())))
				&& ((this.getCorObservationRespo() == castOther.getCorObservationRespo())
						|| (this.getCorObservationRespo() != null && castOther.getCorObservationRespo() != null
								&& this.getCorObservationRespo().equals(castOther.getCorObservationRespo())))
				&& ((this.getAc() == castOther.getAc()) || (this.getAc() != null && castOther.getAc() != null
						&& this.getAc().equals(castOther.getAc())))
				&& ((this.getOperateur() == castOther.getOperateur()) || (this.getOperateur() != null
						&& castOther.getOperateur() != null && this.getOperateur().equals(castOther.getOperateur())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPidCode() == null ? 0 : this.getPidCode().hashCode());
		result = 37 * result + (getPidLibelle() == null ? 0 : this.getPidLibelle().hashCode());
		result = 37 * result + (getDcoDacCode() == null ? 0 : this.getDcoDacCode().hashCode());
		result = 37 * result + (getDcoPresente() == null ? 0 : this.getDcoPresente().hashCode());
		result = 37 * result + (getDcoConforme() == null ? 0 : this.getDcoConforme().hashCode());
		result = 37 * result + (getDcoObservation() == null ? 0 : this.getDcoObservation().hashCode());
		result = 37 * result + (getDcoRespo() == null ? 0 : this.getDcoRespo().hashCode());
		result = 37 * result + (getCorResultatRespo() == null ? 0 : this.getCorResultatRespo().hashCode());
		result = 37 * result + (getCorObservationRespo() == null ? 0 : this.getCorObservationRespo().hashCode());
		result = 37 * result + (getAc() == null ? 0 : this.getAc().hashCode());
		result = 37 * result + (getOperateur() == null ? 0 : this.getOperateur().hashCode());
		return result;
	}

}
