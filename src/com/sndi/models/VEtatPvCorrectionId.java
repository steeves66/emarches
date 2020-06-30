package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VEtatPvCorrectionId generated by hbm2java
 */
@Embeddable
public class VEtatPvCorrectionId implements java.io.Serializable {

	private String dacCode;
	private String dcoTitre;
	private String dcoLibelle;
	private BigDecimal dcoPidCode;
	private String dcoPresente;
	private String dcoConforme;
	private String dcoObservation;
	private String dcoRespo;
	private String tpiLibelle;
	private String strCode;
	private String strLibelleLong;
	private String corResultat;

	public VEtatPvCorrectionId() {
	}

	public VEtatPvCorrectionId(String dacCode, String strCode) {
		this.dacCode = dacCode;
		this.strCode = strCode;
	}

	public VEtatPvCorrectionId(String dacCode, String dcoTitre, String dcoLibelle, BigDecimal dcoPidCode,
			String dcoPresente, String dcoConforme, String dcoObservation, String dcoRespo, String tpiLibelle,
			String strCode, String strLibelleLong, String corResultat) {
		this.dacCode = dacCode;
		this.dcoTitre = dcoTitre;
		this.dcoLibelle = dcoLibelle;
		this.dcoPidCode = dcoPidCode;
		this.dcoPresente = dcoPresente;
		this.dcoConforme = dcoConforme;
		this.dcoObservation = dcoObservation;
		this.dcoRespo = dcoRespo;
		this.tpiLibelle = tpiLibelle;
		this.strCode = strCode;
		this.strLibelleLong = strLibelleLong;
		this.corResultat = corResultat;
	}

	@Column(name = "DAC_CODE", nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
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

	@Column(name = "TPI_LIBELLE", length = 1000)
	public String getTpiLibelle() {
		return this.tpiLibelle;
	}

	public void setTpiLibelle(String tpiLibelle) {
		this.tpiLibelle = tpiLibelle;
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

	@Column(name = "COR_RESULTAT", length = 20)
	public String getCorResultat() {
		return this.corResultat;
	}

	public void setCorResultat(String corResultat) {
		this.corResultat = corResultat;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VEtatPvCorrectionId))
			return false;
		VEtatPvCorrectionId castOther = (VEtatPvCorrectionId) other;

		return ((this.getDacCode() == castOther.getDacCode()) || (this.getDacCode() != null
				&& castOther.getDacCode() != null && this.getDacCode().equals(castOther.getDacCode())))
				&& ((this.getDcoTitre() == castOther.getDcoTitre()) || (this.getDcoTitre() != null
						&& castOther.getDcoTitre() != null && this.getDcoTitre().equals(castOther.getDcoTitre())))
				&& ((this.getDcoLibelle() == castOther.getDcoLibelle()) || (this.getDcoLibelle() != null
						&& castOther.getDcoLibelle() != null && this.getDcoLibelle().equals(castOther.getDcoLibelle())))
				&& ((this.getDcoPidCode() == castOther.getDcoPidCode()) || (this.getDcoPidCode() != null
						&& castOther.getDcoPidCode() != null && this.getDcoPidCode().equals(castOther.getDcoPidCode())))
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
				&& ((this.getTpiLibelle() == castOther.getTpiLibelle()) || (this.getTpiLibelle() != null
						&& castOther.getTpiLibelle() != null && this.getTpiLibelle().equals(castOther.getTpiLibelle())))
				&& ((this.getStrCode() == castOther.getStrCode()) || (this.getStrCode() != null
						&& castOther.getStrCode() != null && this.getStrCode().equals(castOther.getStrCode())))
				&& ((this.getStrLibelleLong() == castOther.getStrLibelleLong())
						|| (this.getStrLibelleLong() != null && castOther.getStrLibelleLong() != null
								&& this.getStrLibelleLong().equals(castOther.getStrLibelleLong())))
				&& ((this.getCorResultat() == castOther.getCorResultat())
						|| (this.getCorResultat() != null && castOther.getCorResultat() != null
								&& this.getCorResultat().equals(castOther.getCorResultat())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDacCode() == null ? 0 : this.getDacCode().hashCode());
		result = 37 * result + (getDcoTitre() == null ? 0 : this.getDcoTitre().hashCode());
		result = 37 * result + (getDcoLibelle() == null ? 0 : this.getDcoLibelle().hashCode());
		result = 37 * result + (getDcoPidCode() == null ? 0 : this.getDcoPidCode().hashCode());
		result = 37 * result + (getDcoPresente() == null ? 0 : this.getDcoPresente().hashCode());
		result = 37 * result + (getDcoConforme() == null ? 0 : this.getDcoConforme().hashCode());
		result = 37 * result + (getDcoObservation() == null ? 0 : this.getDcoObservation().hashCode());
		result = 37 * result + (getDcoRespo() == null ? 0 : this.getDcoRespo().hashCode());
		result = 37 * result + (getTpiLibelle() == null ? 0 : this.getTpiLibelle().hashCode());
		result = 37 * result + (getStrCode() == null ? 0 : this.getStrCode().hashCode());
		result = 37 * result + (getStrLibelleLong() == null ? 0 : this.getStrLibelleLong().hashCode());
		result = 37 * result + (getCorResultat() == null ? 0 : this.getCorResultat().hashCode());
		return result;
	}

}
