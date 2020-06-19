package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

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

	public VbMinistereId() {
	}

	public VbMinistereId(String minCode) {
		this.minCode = minCode;
	}

	public VbMinistereId(String minCode, String minLibelle, String minLibelleCourt, String minDescription) {
		this.minCode = minCode;
		this.minLibelle = minLibelle;
		this.minLibelleCourt = minLibelleCourt;
		this.minDescription = minDescription;
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
								&& this.getMinDescription().equals(castOther.getMinDescription())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMinCode() == null ? 0 : this.getMinCode().hashCode());
		result = 37 * result + (getMinLibelle() == null ? 0 : this.getMinLibelle().hashCode());
		result = 37 * result + (getMinLibelleCourt() == null ? 0 : this.getMinLibelleCourt().hashCode());
		result = 37 * result + (getMinDescription() == null ? 0 : this.getMinDescription().hashCode());
		return result;
	}

}
