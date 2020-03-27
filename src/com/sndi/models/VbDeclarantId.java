package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDeclarantId generated by hbm2java
 */
@Embeddable
public class VbDeclarantId implements java.io.Serializable {

	private long decId;
	private String decOrganExecLibelle;
	private String decOrganExecAdresse;
	private String decPersNomPrenom;
	private String decPersFonction;
	private String decLocalisation;
	private String decNumeroPorte;
	private String decBp;
	private String decTelephone;
	private String decEmail;
	private String decCel;

	public VbDeclarantId() {
	}

	public VbDeclarantId(long decId, String decOrganExecLibelle, String decPersFonction, String decBp) {
		this.decId = decId;
		this.decOrganExecLibelle = decOrganExecLibelle;
		this.decPersFonction = decPersFonction;
		this.decBp = decBp;
	}

	public VbDeclarantId(long decId, String decOrganExecLibelle, String decOrganExecAdresse, String decPersNomPrenom,
			String decPersFonction, String decLocalisation, String decNumeroPorte, String decBp, String decTelephone,
			String decEmail, String decCel) {
		this.decId = decId;
		this.decOrganExecLibelle = decOrganExecLibelle;
		this.decOrganExecAdresse = decOrganExecAdresse;
		this.decPersNomPrenom = decPersNomPrenom;
		this.decPersFonction = decPersFonction;
		this.decLocalisation = decLocalisation;
		this.decNumeroPorte = decNumeroPorte;
		this.decBp = decBp;
		this.decTelephone = decTelephone;
		this.decEmail = decEmail;
		this.decCel = decCel;
	}

	@Column(name = "DEC_ID", nullable = false, precision = 10, scale = 0)
	public long getDecId() {
		return this.decId;
	}

	public void setDecId(long decId) {
		this.decId = decId;
	}

	@Column(name = "DEC_ORGAN_EXEC_LIBELLE", nullable = false, length = 500)
	public String getDecOrganExecLibelle() {
		return this.decOrganExecLibelle;
	}

	public void setDecOrganExecLibelle(String decOrganExecLibelle) {
		this.decOrganExecLibelle = decOrganExecLibelle;
	}

	@Column(name = "DEC_ORGAN_EXEC_ADRESSE", length = 500)
	public String getDecOrganExecAdresse() {
		return this.decOrganExecAdresse;
	}

	public void setDecOrganExecAdresse(String decOrganExecAdresse) {
		this.decOrganExecAdresse = decOrganExecAdresse;
	}

	@Column(name = "DEC_PERS_NOM_PRENOM", length = 500)
	public String getDecPersNomPrenom() {
		return this.decPersNomPrenom;
	}

	public void setDecPersNomPrenom(String decPersNomPrenom) {
		this.decPersNomPrenom = decPersNomPrenom;
	}

	@Column(name = "DEC_PERS_FONCTION", nullable = false, length = 500)
	public String getDecPersFonction() {
		return this.decPersFonction;
	}

	public void setDecPersFonction(String decPersFonction) {
		this.decPersFonction = decPersFonction;
	}

	@Column(name = "DEC_LOCALISATION", length = 500)
	public String getDecLocalisation() {
		return this.decLocalisation;
	}

	public void setDecLocalisation(String decLocalisation) {
		this.decLocalisation = decLocalisation;
	}

	@Column(name = "DEC_NUMERO_PORTE", length = 500)
	public String getDecNumeroPorte() {
		return this.decNumeroPorte;
	}

	public void setDecNumeroPorte(String decNumeroPorte) {
		this.decNumeroPorte = decNumeroPorte;
	}

	@Column(name = "DEC_BP", nullable = false, length = 500)
	public String getDecBp() {
		return this.decBp;
	}

	public void setDecBp(String decBp) {
		this.decBp = decBp;
	}

	@Column(name = "DEC_TELEPHONE", length = 500)
	public String getDecTelephone() {
		return this.decTelephone;
	}

	public void setDecTelephone(String decTelephone) {
		this.decTelephone = decTelephone;
	}

	@Column(name = "DEC_EMAIL", length = 500)
	public String getDecEmail() {
		return this.decEmail;
	}

	public void setDecEmail(String decEmail) {
		this.decEmail = decEmail;
	}

	@Column(name = "DEC_CEL", length = 500)
	public String getDecCel() {
		return this.decCel;
	}

	public void setDecCel(String decCel) {
		this.decCel = decCel;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDeclarantId))
			return false;
		VbDeclarantId castOther = (VbDeclarantId) other;

		return (this.getDecId() == castOther.getDecId())
				&& ((this.getDecOrganExecLibelle() == castOther.getDecOrganExecLibelle())
						|| (this.getDecOrganExecLibelle() != null && castOther.getDecOrganExecLibelle() != null
								&& this.getDecOrganExecLibelle().equals(castOther.getDecOrganExecLibelle())))
				&& ((this.getDecOrganExecAdresse() == castOther.getDecOrganExecAdresse())
						|| (this.getDecOrganExecAdresse() != null && castOther.getDecOrganExecAdresse() != null
								&& this.getDecOrganExecAdresse().equals(castOther.getDecOrganExecAdresse())))
				&& ((this.getDecPersNomPrenom() == castOther.getDecPersNomPrenom())
						|| (this.getDecPersNomPrenom() != null && castOther.getDecPersNomPrenom() != null
								&& this.getDecPersNomPrenom().equals(castOther.getDecPersNomPrenom())))
				&& ((this.getDecPersFonction() == castOther.getDecPersFonction())
						|| (this.getDecPersFonction() != null && castOther.getDecPersFonction() != null
								&& this.getDecPersFonction().equals(castOther.getDecPersFonction())))
				&& ((this.getDecLocalisation() == castOther.getDecLocalisation())
						|| (this.getDecLocalisation() != null && castOther.getDecLocalisation() != null
								&& this.getDecLocalisation().equals(castOther.getDecLocalisation())))
				&& ((this.getDecNumeroPorte() == castOther.getDecNumeroPorte())
						|| (this.getDecNumeroPorte() != null && castOther.getDecNumeroPorte() != null
								&& this.getDecNumeroPorte().equals(castOther.getDecNumeroPorte())))
				&& ((this.getDecBp() == castOther.getDecBp()) || (this.getDecBp() != null
						&& castOther.getDecBp() != null && this.getDecBp().equals(castOther.getDecBp())))
				&& ((this.getDecTelephone() == castOther.getDecTelephone())
						|| (this.getDecTelephone() != null && castOther.getDecTelephone() != null
								&& this.getDecTelephone().equals(castOther.getDecTelephone())))
				&& ((this.getDecEmail() == castOther.getDecEmail()) || (this.getDecEmail() != null
						&& castOther.getDecEmail() != null && this.getDecEmail().equals(castOther.getDecEmail())))
				&& ((this.getDecCel() == castOther.getDecCel()) || (this.getDecCel() != null
						&& castOther.getDecCel() != null && this.getDecCel().equals(castOther.getDecCel())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getDecId();
		result = 37 * result + (getDecOrganExecLibelle() == null ? 0 : this.getDecOrganExecLibelle().hashCode());
		result = 37 * result + (getDecOrganExecAdresse() == null ? 0 : this.getDecOrganExecAdresse().hashCode());
		result = 37 * result + (getDecPersNomPrenom() == null ? 0 : this.getDecPersNomPrenom().hashCode());
		result = 37 * result + (getDecPersFonction() == null ? 0 : this.getDecPersFonction().hashCode());
		result = 37 * result + (getDecLocalisation() == null ? 0 : this.getDecLocalisation().hashCode());
		result = 37 * result + (getDecNumeroPorte() == null ? 0 : this.getDecNumeroPorte().hashCode());
		result = 37 * result + (getDecBp() == null ? 0 : this.getDecBp().hashCode());
		result = 37 * result + (getDecTelephone() == null ? 0 : this.getDecTelephone().hashCode());
		result = 37 * result + (getDecEmail() == null ? 0 : this.getDecEmail().hashCode());
		result = 37 * result + (getDecCel() == null ? 0 : this.getDecCel().hashCode());
		return result;
	}

}
