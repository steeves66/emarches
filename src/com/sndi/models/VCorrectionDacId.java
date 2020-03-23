package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VCorrectionDacId generated by hbm2java
 */
@Embeddable
public class VCorrectionDacId implements java.io.Serializable {

	private String dacCode;
	private String dacObjet;
	private String dcoTitre;
	private String dcoLibelle;
	private BigDecimal dcoPidCode;
	private String tpiCode;
	private String tpiLibelle;
	private String pidConforme;
	private String corObservation;
	private String corResultat;
	private String strCode;
	private String strLibelleLong;

	public VCorrectionDacId() {
	}

	public VCorrectionDacId(String dacCode, String tpiCode, String strCode) {
		this.dacCode = dacCode;
		this.tpiCode = tpiCode;
		this.strCode = strCode;
	}

	public VCorrectionDacId(String dacCode, String dacObjet, String dcoTitre, String dcoLibelle, BigDecimal dcoPidCode,
			String tpiCode, String tpiLibelle, String pidConforme, String corObservation, String corResultat,
			String strCode, String strLibelleLong) {
		this.dacCode = dacCode;
		this.dacObjet = dacObjet;
		this.dcoTitre = dcoTitre;
		this.dcoLibelle = dcoLibelle;
		this.dcoPidCode = dcoPidCode;
		this.tpiCode = tpiCode;
		this.tpiLibelle = tpiLibelle;
		this.pidConforme = pidConforme;
		this.corObservation = corObservation;
		this.corResultat = corResultat;
		this.strCode = strCode;
		this.strLibelleLong = strLibelleLong;
	}

	@Column(name = "DAC_CODE", nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	@Column(name = "DAC_OBJET", length = 1000)
	public String getDacObjet() {
		return this.dacObjet;
	}

	public void setDacObjet(String dacObjet) {
		this.dacObjet = dacObjet;
	}

	@Column(name = "DCO_TITRE", length = 200)
	public String getDcoTitre() {
		return this.dcoTitre;
	}

	public void setDcoTitre(String dcoTitre) {
		this.dcoTitre = dcoTitre;
	}

	@Column(name = "DCO_LIBELLE", length = 1000)
	public String getDcoLibelle() {
		return this.dcoLibelle;
	}

	public void setDcoLibelle(String dcoLibelle) {
		this.dcoLibelle = dcoLibelle;
	}

	@Column(name = "DCO_PID_CODE", precision = 22, scale = 0)
	public BigDecimal getDcoPidCode() {
		return this.dcoPidCode;
	}

	public void setDcoPidCode(BigDecimal dcoPidCode) {
		this.dcoPidCode = dcoPidCode;
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

	@Column(name = "PID_CONFORME", length = 3)
	public String getPidConforme() {
		return this.pidConforme;
	}

	public void setPidConforme(String pidConforme) {
		this.pidConforme = pidConforme;
	}

	@Column(name = "COR_OBSERVATION", length = 4000)
	public String getCorObservation() {
		return this.corObservation;
	}

	public void setCorObservation(String corObservation) {
		this.corObservation = corObservation;
	}

	@Column(name = "COR_RESULTAT", length = 20)
	public String getCorResultat() {
		return this.corResultat;
	}

	public void setCorResultat(String corResultat) {
		this.corResultat = corResultat;
	}

	@Column(name = "STR_CODE", nullable = false, length = 20)
	public String getStrCode() {
		return this.strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	@Column(name = "STR_LIBELLE_LONG", length = 1000)
	public String getStrLibelleLong() {
		return this.strLibelleLong;
	}

	public void setStrLibelleLong(String strLibelleLong) {
		this.strLibelleLong = strLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VCorrectionDacId))
			return false;
		VCorrectionDacId castOther = (VCorrectionDacId) other;

		return ((this.getDacCode() == castOther.getDacCode()) || (this.getDacCode() != null
				&& castOther.getDacCode() != null && this.getDacCode().equals(castOther.getDacCode())))
				&& ((this.getDacObjet() == castOther.getDacObjet()) || (this.getDacObjet() != null
						&& castOther.getDacObjet() != null && this.getDacObjet().equals(castOther.getDacObjet())))
				&& ((this.getDcoTitre() == castOther.getDcoTitre()) || (this.getDcoTitre() != null
						&& castOther.getDcoTitre() != null && this.getDcoTitre().equals(castOther.getDcoTitre())))
				&& ((this.getDcoLibelle() == castOther.getDcoLibelle()) || (this.getDcoLibelle() != null
						&& castOther.getDcoLibelle() != null && this.getDcoLibelle().equals(castOther.getDcoLibelle())))
				&& ((this.getDcoPidCode() == castOther.getDcoPidCode()) || (this.getDcoPidCode() != null
						&& castOther.getDcoPidCode() != null && this.getDcoPidCode().equals(castOther.getDcoPidCode())))
				&& ((this.getTpiCode() == castOther.getTpiCode()) || (this.getTpiCode() != null
						&& castOther.getTpiCode() != null && this.getTpiCode().equals(castOther.getTpiCode())))
				&& ((this.getTpiLibelle() == castOther.getTpiLibelle()) || (this.getTpiLibelle() != null
						&& castOther.getTpiLibelle() != null && this.getTpiLibelle().equals(castOther.getTpiLibelle())))
				&& ((this.getPidConforme() == castOther.getPidConforme())
						|| (this.getPidConforme() != null && castOther.getPidConforme() != null
								&& this.getPidConforme().equals(castOther.getPidConforme())))
				&& ((this.getCorObservation() == castOther.getCorObservation())
						|| (this.getCorObservation() != null && castOther.getCorObservation() != null
								&& this.getCorObservation().equals(castOther.getCorObservation())))
				&& ((this.getCorResultat() == castOther.getCorResultat())
						|| (this.getCorResultat() != null && castOther.getCorResultat() != null
								&& this.getCorResultat().equals(castOther.getCorResultat())))
				&& ((this.getStrCode() == castOther.getStrCode()) || (this.getStrCode() != null
						&& castOther.getStrCode() != null && this.getStrCode().equals(castOther.getStrCode())))
				&& ((this.getStrLibelleLong() == castOther.getStrLibelleLong())
						|| (this.getStrLibelleLong() != null && castOther.getStrLibelleLong() != null
								&& this.getStrLibelleLong().equals(castOther.getStrLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDacCode() == null ? 0 : this.getDacCode().hashCode());
		result = 37 * result + (getDacObjet() == null ? 0 : this.getDacObjet().hashCode());
		result = 37 * result + (getDcoTitre() == null ? 0 : this.getDcoTitre().hashCode());
		result = 37 * result + (getDcoLibelle() == null ? 0 : this.getDcoLibelle().hashCode());
		result = 37 * result + (getDcoPidCode() == null ? 0 : this.getDcoPidCode().hashCode());
		result = 37 * result + (getTpiCode() == null ? 0 : this.getTpiCode().hashCode());
		result = 37 * result + (getTpiLibelle() == null ? 0 : this.getTpiLibelle().hashCode());
		result = 37 * result + (getPidConforme() == null ? 0 : this.getPidConforme().hashCode());
		result = 37 * result + (getCorObservation() == null ? 0 : this.getCorObservation().hashCode());
		result = 37 * result + (getCorResultat() == null ? 0 : this.getCorResultat().hashCode());
		result = 37 * result + (getStrCode() == null ? 0 : this.getStrCode().hashCode());
		result = 37 * result + (getStrLibelleLong() == null ? 0 : this.getStrLibelleLong().hashCode());
		return result;
	}

}
