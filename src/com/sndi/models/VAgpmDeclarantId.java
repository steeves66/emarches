package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VAgpmDeclarantId generated by hbm2java
 */
@Embeddable
public class VAgpmDeclarantId implements java.io.Serializable {

	private long agpId;
	private String agpFonCod;
	private String agpStrCode;
	private long agpProId;
	private String agpActeurSaisie;
	private String agpCode;
	private String decPersNomPrenom;
	private String decOrganExecLibelle;
	private String decPersFonction;
	private String decTelephone;
	private String decNumeroPorte;
	private String decOrganExecAdresse;
	private String decLocalisation;
	private String decEmail;
	private String decBp;
	private String decCel;
	private Long agpDecId;

	public VAgpmDeclarantId() {
	}

	public VAgpmDeclarantId(long agpId, String agpFonCod, String agpStrCode, long agpProId) {
		this.agpId = agpId;
		this.agpFonCod = agpFonCod;
		this.agpStrCode = agpStrCode;
		this.agpProId = agpProId;
	}

	public VAgpmDeclarantId(long agpId, String agpFonCod, String agpStrCode, long agpProId, String agpActeurSaisie,
			String agpCode, String decPersNomPrenom, String decOrganExecLibelle, String decPersFonction,
			String decTelephone, String decNumeroPorte, String decOrganExecAdresse, String decLocalisation,
			String decEmail, String decBp, String decCel, Long agpDecId) {
		this.agpId = agpId;
		this.agpFonCod = agpFonCod;
		this.agpStrCode = agpStrCode;
		this.agpProId = agpProId;
		this.agpActeurSaisie = agpActeurSaisie;
		this.agpCode = agpCode;
		this.decPersNomPrenom = decPersNomPrenom;
		this.decOrganExecLibelle = decOrganExecLibelle;
		this.decPersFonction = decPersFonction;
		this.decTelephone = decTelephone;
		this.decNumeroPorte = decNumeroPorte;
		this.decOrganExecAdresse = decOrganExecAdresse;
		this.decLocalisation = decLocalisation;
		this.decEmail = decEmail;
		this.decBp = decBp;
		this.decCel = decCel;
		this.agpDecId = agpDecId;
	}

	@Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpId() {
		return this.agpId;
	}

	public void setAgpId(long agpId) {
		this.agpId = agpId;
	}

	@Column(name = "AGP_FON_COD", nullable = false, length = 20)
	public String getAgpFonCod() {
		return this.agpFonCod;
	}

	public void setAgpFonCod(String agpFonCod) {
		this.agpFonCod = agpFonCod;
	}

	@Column(name = "AGP_STR_CODE", nullable = false, length = 20)
	public String getAgpStrCode() {
		return this.agpStrCode;
	}

	public void setAgpStrCode(String agpStrCode) {
		this.agpStrCode = agpStrCode;
	}

	@Column(name = "AGP_PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpProId() {
		return this.agpProId;
	}

	public void setAgpProId(long agpProId) {
		this.agpProId = agpProId;
	}

	@Column(name = "AGP_ACTEUR_SAISIE", length = 12)
	public String getAgpActeurSaisie() {
		return this.agpActeurSaisie;
	}

	public void setAgpActeurSaisie(String agpActeurSaisie) {
		this.agpActeurSaisie = agpActeurSaisie;
	}

	@Column(name = "AGP_CODE", length = 50)
	public String getAgpCode() {
		return this.agpCode;
	}

	public void setAgpCode(String agpCode) {
		this.agpCode = agpCode;
	}

	@Column(name = "DEC_PERS_NOM_PRENOM", length = 500)
	public String getDecPersNomPrenom() {
		return this.decPersNomPrenom;
	}

	public void setDecPersNomPrenom(String decPersNomPrenom) {
		this.decPersNomPrenom = decPersNomPrenom;
	}

	@Column(name = "DEC_ORGAN_EXEC_LIBELLE", length = 500)
	public String getDecOrganExecLibelle() {
		return this.decOrganExecLibelle;
	}

	public void setDecOrganExecLibelle(String decOrganExecLibelle) {
		this.decOrganExecLibelle = decOrganExecLibelle;
	}

	@Column(name = "DEC_PERS_FONCTION", length = 500)
	public String getDecPersFonction() {
		return this.decPersFonction;
	}

	public void setDecPersFonction(String decPersFonction) {
		this.decPersFonction = decPersFonction;
	}

	@Column(name = "DEC_TELEPHONE", length = 500)
	public String getDecTelephone() {
		return this.decTelephone;
	}

	public void setDecTelephone(String decTelephone) {
		this.decTelephone = decTelephone;
	}

	@Column(name = "DEC_NUMERO_PORTE", length = 500)
	public String getDecNumeroPorte() {
		return this.decNumeroPorte;
	}

	public void setDecNumeroPorte(String decNumeroPorte) {
		this.decNumeroPorte = decNumeroPorte;
	}

	@Column(name = "DEC_ORGAN_EXEC_ADRESSE", length = 500)
	public String getDecOrganExecAdresse() {
		return this.decOrganExecAdresse;
	}

	public void setDecOrganExecAdresse(String decOrganExecAdresse) {
		this.decOrganExecAdresse = decOrganExecAdresse;
	}

	@Column(name = "DEC_LOCALISATION", length = 500)
	public String getDecLocalisation() {
		return this.decLocalisation;
	}

	public void setDecLocalisation(String decLocalisation) {
		this.decLocalisation = decLocalisation;
	}

	@Column(name = "DEC_EMAIL", length = 500)
	public String getDecEmail() {
		return this.decEmail;
	}

	public void setDecEmail(String decEmail) {
		this.decEmail = decEmail;
	}

	@Column(name = "DEC_BP", length = 500)
	public String getDecBp() {
		return this.decBp;
	}

	public void setDecBp(String decBp) {
		this.decBp = decBp;
	}

	@Column(name = "DEC_CEL", length = 500)
	public String getDecCel() {
		return this.decCel;
	}

	public void setDecCel(String decCel) {
		this.decCel = decCel;
	}

	@Column(name = "AGP_DEC_ID", precision = 10, scale = 0)
	public Long getAgpDecId() {
		return this.agpDecId;
	}

	public void setAgpDecId(Long agpDecId) {
		this.agpDecId = agpDecId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VAgpmDeclarantId))
			return false;
		VAgpmDeclarantId castOther = (VAgpmDeclarantId) other;

		return (this.getAgpId() == castOther.getAgpId())
				&& ((this.getAgpFonCod() == castOther.getAgpFonCod()) || (this.getAgpFonCod() != null
						&& castOther.getAgpFonCod() != null && this.getAgpFonCod().equals(castOther.getAgpFonCod())))
				&& ((this.getAgpStrCode() == castOther.getAgpStrCode()) || (this.getAgpStrCode() != null
						&& castOther.getAgpStrCode() != null && this.getAgpStrCode().equals(castOther.getAgpStrCode())))
				&& (this.getAgpProId() == castOther.getAgpProId())
				&& ((this.getAgpActeurSaisie() == castOther.getAgpActeurSaisie())
						|| (this.getAgpActeurSaisie() != null && castOther.getAgpActeurSaisie() != null
								&& this.getAgpActeurSaisie().equals(castOther.getAgpActeurSaisie())))
				&& ((this.getAgpCode() == castOther.getAgpCode()) || (this.getAgpCode() != null
						&& castOther.getAgpCode() != null && this.getAgpCode().equals(castOther.getAgpCode())))
				&& ((this.getDecPersNomPrenom() == castOther.getDecPersNomPrenom())
						|| (this.getDecPersNomPrenom() != null && castOther.getDecPersNomPrenom() != null
								&& this.getDecPersNomPrenom().equals(castOther.getDecPersNomPrenom())))
				&& ((this.getDecOrganExecLibelle() == castOther.getDecOrganExecLibelle())
						|| (this.getDecOrganExecLibelle() != null && castOther.getDecOrganExecLibelle() != null
								&& this.getDecOrganExecLibelle().equals(castOther.getDecOrganExecLibelle())))
				&& ((this.getDecPersFonction() == castOther.getDecPersFonction())
						|| (this.getDecPersFonction() != null && castOther.getDecPersFonction() != null
								&& this.getDecPersFonction().equals(castOther.getDecPersFonction())))
				&& ((this.getDecTelephone() == castOther.getDecTelephone())
						|| (this.getDecTelephone() != null && castOther.getDecTelephone() != null
								&& this.getDecTelephone().equals(castOther.getDecTelephone())))
				&& ((this.getDecNumeroPorte() == castOther.getDecNumeroPorte())
						|| (this.getDecNumeroPorte() != null && castOther.getDecNumeroPorte() != null
								&& this.getDecNumeroPorte().equals(castOther.getDecNumeroPorte())))
				&& ((this.getDecOrganExecAdresse() == castOther.getDecOrganExecAdresse())
						|| (this.getDecOrganExecAdresse() != null && castOther.getDecOrganExecAdresse() != null
								&& this.getDecOrganExecAdresse().equals(castOther.getDecOrganExecAdresse())))
				&& ((this.getDecLocalisation() == castOther.getDecLocalisation())
						|| (this.getDecLocalisation() != null && castOther.getDecLocalisation() != null
								&& this.getDecLocalisation().equals(castOther.getDecLocalisation())))
				&& ((this.getDecEmail() == castOther.getDecEmail()) || (this.getDecEmail() != null
						&& castOther.getDecEmail() != null && this.getDecEmail().equals(castOther.getDecEmail())))
				&& ((this.getDecBp() == castOther.getDecBp()) || (this.getDecBp() != null
						&& castOther.getDecBp() != null && this.getDecBp().equals(castOther.getDecBp())))
				&& ((this.getDecCel() == castOther.getDecCel()) || (this.getDecCel() != null
						&& castOther.getDecCel() != null && this.getDecCel().equals(castOther.getDecCel())))
				&& ((this.getAgpDecId() == castOther.getAgpDecId()) || (this.getAgpDecId() != null
						&& castOther.getAgpDecId() != null && this.getAgpDecId().equals(castOther.getAgpDecId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAgpId();
		result = 37 * result + (getAgpFonCod() == null ? 0 : this.getAgpFonCod().hashCode());
		result = 37 * result + (getAgpStrCode() == null ? 0 : this.getAgpStrCode().hashCode());
		result = 37 * result + (int) this.getAgpProId();
		result = 37 * result + (getAgpActeurSaisie() == null ? 0 : this.getAgpActeurSaisie().hashCode());
		result = 37 * result + (getAgpCode() == null ? 0 : this.getAgpCode().hashCode());
		result = 37 * result + (getDecPersNomPrenom() == null ? 0 : this.getDecPersNomPrenom().hashCode());
		result = 37 * result + (getDecOrganExecLibelle() == null ? 0 : this.getDecOrganExecLibelle().hashCode());
		result = 37 * result + (getDecPersFonction() == null ? 0 : this.getDecPersFonction().hashCode());
		result = 37 * result + (getDecTelephone() == null ? 0 : this.getDecTelephone().hashCode());
		result = 37 * result + (getDecNumeroPorte() == null ? 0 : this.getDecNumeroPorte().hashCode());
		result = 37 * result + (getDecOrganExecAdresse() == null ? 0 : this.getDecOrganExecAdresse().hashCode());
		result = 37 * result + (getDecLocalisation() == null ? 0 : this.getDecLocalisation().hashCode());
		result = 37 * result + (getDecEmail() == null ? 0 : this.getDecEmail().hashCode());
		result = 37 * result + (getDecBp() == null ? 0 : this.getDecBp().hashCode());
		result = 37 * result + (getDecCel() == null ? 0 : this.getDecCel().hashCode());
		result = 37 * result + (getAgpDecId() == null ? 0 : this.getAgpDecId().hashCode());
		return result;
	}

}
