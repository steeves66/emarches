package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbMinistereId generated by hbm2java
 */
@Embeddable
public class VbMinistereId implements java.io.Serializable {

	private String minCode;
	private String minLibelle;
	private String minLibelleCourt;
	private String minDescription;
	private Date minDteSaisi;
	private String minOpeMatricule;
	private String minActif;

	public VbMinistereId() {
	}

	public VbMinistereId(String minCode) {
		this.minCode = minCode;
	}

	public VbMinistereId(String minCode, String minLibelle, String minLibelleCourt, String minDescription,
			Date minDteSaisi, String minOpeMatricule, String minActif) {
		this.minCode = minCode;
		this.minLibelle = minLibelle;
		this.minLibelleCourt = minLibelleCourt;
		this.minDescription = minDescription;
		this.minDteSaisi = minDteSaisi;
		this.minOpeMatricule = minOpeMatricule;
		this.minActif = minActif;
	}

	@Column(name = "MIN_CODE", nullable = false, length = 20)
	public String getMinCode() {
		return this.minCode;
	}

	public void setMinCode(String minCode) {
		this.minCode = minCode;
	}

	@Column(name = "MIN_LIBELLE", length = 1000)
	public String getMinLibelle() {
		return this.minLibelle;
	}

	public void setMinLibelle(String minLibelle) {
		this.minLibelle = minLibelle;
	}

	@Column(name = "MIN_LIBELLE_COURT", length = 500)
	public String getMinLibelleCourt() {
		return this.minLibelleCourt;
	}

	public void setMinLibelleCourt(String minLibelleCourt) {
		this.minLibelleCourt = minLibelleCourt;
	}

	@Column(name = "MIN_DESCRIPTION", length = 1000)
	public String getMinDescription() {
		return this.minDescription;
	}

	public void setMinDescription(String minDescription) {
		this.minDescription = minDescription;
	}

	@Column(name = "MIN_DTE_SAISI", length = 7)
	public Date getMinDteSaisi() {
		return this.minDteSaisi;
	}

	public void setMinDteSaisi(Date minDteSaisi) {
		this.minDteSaisi = minDteSaisi;
	}

	@Column(name = "MIN_OPE_MATRICULE", length = 25)
	public String getMinOpeMatricule() {
		return this.minOpeMatricule;
	}

	public void setMinOpeMatricule(String minOpeMatricule) {
		this.minOpeMatricule = minOpeMatricule;
	}

	@Column(name = "MIN_ACTIF", length = 1)
	public String getMinActif() {
		return this.minActif;
	}

	public void setMinActif(String minActif) {
		this.minActif = minActif;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbMinistereId))
			return false;
		VbMinistereId castOther = (VbMinistereId) other;

		return ((this.getMinCode() == castOther.getMinCode()) || (this.getMinCode() != null
				&& castOther.getMinCode() != null && this.getMinCode().equals(castOther.getMinCode())))
				&& ((this.getMinLibelle() == castOther.getMinLibelle()) || (this.getMinLibelle() != null
						&& castOther.getMinLibelle() != null && this.getMinLibelle().equals(castOther.getMinLibelle())))
				&& ((this.getMinLibelleCourt() == castOther.getMinLibelleCourt())
						|| (this.getMinLibelleCourt() != null && castOther.getMinLibelleCourt() != null
								&& this.getMinLibelleCourt().equals(castOther.getMinLibelleCourt())))
				&& ((this.getMinDescription() == castOther.getMinDescription())
						|| (this.getMinDescription() != null && castOther.getMinDescription() != null
								&& this.getMinDescription().equals(castOther.getMinDescription())))
				&& ((this.getMinDteSaisi() == castOther.getMinDteSaisi())
						|| (this.getMinDteSaisi() != null && castOther.getMinDteSaisi() != null
								&& this.getMinDteSaisi().equals(castOther.getMinDteSaisi())))
				&& ((this.getMinOpeMatricule() == castOther.getMinOpeMatricule())
						|| (this.getMinOpeMatricule() != null && castOther.getMinOpeMatricule() != null
								&& this.getMinOpeMatricule().equals(castOther.getMinOpeMatricule())))
				&& ((this.getMinActif() == castOther.getMinActif()) || (this.getMinActif() != null
						&& castOther.getMinActif() != null && this.getMinActif().equals(castOther.getMinActif())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMinCode() == null ? 0 : this.getMinCode().hashCode());
		result = 37 * result + (getMinLibelle() == null ? 0 : this.getMinLibelle().hashCode());
		result = 37 * result + (getMinLibelleCourt() == null ? 0 : this.getMinLibelleCourt().hashCode());
		result = 37 * result + (getMinDescription() == null ? 0 : this.getMinDescription().hashCode());
		result = 37 * result + (getMinDteSaisi() == null ? 0 : this.getMinDteSaisi().hashCode());
		result = 37 * result + (getMinOpeMatricule() == null ? 0 : this.getMinOpeMatricule().hashCode());
		result = 37 * result + (getMinActif() == null ? 0 : this.getMinActif().hashCode());
		return result;
	}

}
