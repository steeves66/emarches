package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbPaysReferenceId generated by hbm2java
 */
@Embeddable
public class VbPaysReferenceId implements java.io.Serializable {

	private String repCode;
	private String repLibelle;
	private String repLibelleCourt;
	private String repStatut;
	private String repIndicatif;

	public VbPaysReferenceId() {
	}

	public VbPaysReferenceId(String repCode) {
		this.repCode = repCode;
	}

	public VbPaysReferenceId(String repCode, String repLibelle, String repLibelleCourt, String repStatut,
			String repIndicatif) {
		this.repCode = repCode;
		this.repLibelle = repLibelle;
		this.repLibelleCourt = repLibelleCourt;
		this.repStatut = repStatut;
		this.repIndicatif = repIndicatif;
	}

	@Column(name = "REP_CODE", nullable = false, length = 10)
	public String getRepCode() {
		return this.repCode;
	}

	public void setRepCode(String repCode) {
		this.repCode = repCode;
	}

	@Column(name = "REP_LIBELLE", length = 200)
	public String getRepLibelle() {
		return this.repLibelle;
	}

	public void setRepLibelle(String repLibelle) {
		this.repLibelle = repLibelle;
	}

	@Column(name = "REP_LIBELLE_COURT", length = 100)
	public String getRepLibelleCourt() {
		return this.repLibelleCourt;
	}

	public void setRepLibelleCourt(String repLibelleCourt) {
		this.repLibelleCourt = repLibelleCourt;
	}

	@Column(name = "REP_STATUT", length = 1)
	public String getRepStatut() {
		return this.repStatut;
	}

	public void setRepStatut(String repStatut) {
		this.repStatut = repStatut;
	}

	@Column(name = "REP_INDICATIF", length = 50)
	public String getRepIndicatif() {
		return this.repIndicatif;
	}

	public void setRepIndicatif(String repIndicatif) {
		this.repIndicatif = repIndicatif;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbPaysReferenceId))
			return false;
		VbPaysReferenceId castOther = (VbPaysReferenceId) other;

		return ((this.getRepCode() == castOther.getRepCode()) || (this.getRepCode() != null
				&& castOther.getRepCode() != null && this.getRepCode().equals(castOther.getRepCode())))
				&& ((this.getRepLibelle() == castOther.getRepLibelle()) || (this.getRepLibelle() != null
						&& castOther.getRepLibelle() != null && this.getRepLibelle().equals(castOther.getRepLibelle())))
				&& ((this.getRepLibelleCourt() == castOther.getRepLibelleCourt())
						|| (this.getRepLibelleCourt() != null && castOther.getRepLibelleCourt() != null
								&& this.getRepLibelleCourt().equals(castOther.getRepLibelleCourt())))
				&& ((this.getRepStatut() == castOther.getRepStatut()) || (this.getRepStatut() != null
						&& castOther.getRepStatut() != null && this.getRepStatut().equals(castOther.getRepStatut())))
				&& ((this.getRepIndicatif() == castOther.getRepIndicatif())
						|| (this.getRepIndicatif() != null && castOther.getRepIndicatif() != null
								&& this.getRepIndicatif().equals(castOther.getRepIndicatif())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRepCode() == null ? 0 : this.getRepCode().hashCode());
		result = 37 * result + (getRepLibelle() == null ? 0 : this.getRepLibelle().hashCode());
		result = 37 * result + (getRepLibelleCourt() == null ? 0 : this.getRepLibelleCourt().hashCode());
		result = 37 * result + (getRepStatut() == null ? 0 : this.getRepStatut().hashCode());
		result = 37 * result + (getRepIndicatif() == null ? 0 : this.getRepIndicatif().hashCode());
		return result;
	}

}
