package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDossierPgpmId generated by hbm2java
 */
@Embeddable
public class VDossierPgpmId implements java.io.Serializable {

	private long dpgId;
	private String dpgNapCode;
	private long dpgGpgId;
	private String dpgCode;
	private String dpgLibelle;
	private String dpgCommentaire;
	private String dpgReference;

	public VDossierPgpmId() {
	}

	public VDossierPgpmId(long dpgId, String dpgNapCode, long dpgGpgId) {
		this.dpgId = dpgId;
		this.dpgNapCode = dpgNapCode;
		this.dpgGpgId = dpgGpgId;
	}

	public VDossierPgpmId(long dpgId, String dpgNapCode, long dpgGpgId, String dpgCode, String dpgLibelle,
			String dpgCommentaire, String dpgReference) {
		this.dpgId = dpgId;
		this.dpgNapCode = dpgNapCode;
		this.dpgGpgId = dpgGpgId;
		this.dpgCode = dpgCode;
		this.dpgLibelle = dpgLibelle;
		this.dpgCommentaire = dpgCommentaire;
		this.dpgReference = dpgReference;
	}

	@Column(name = "DPG_ID", nullable = false, precision = 10, scale = 0)
	public long getDpgId() {
		return this.dpgId;
	}

	public void setDpgId(long dpgId) {
		this.dpgId = dpgId;
	}

	@Column(name = "DPG_NAP_CODE", nullable = false, length = 5)
	public String getDpgNapCode() {
		return this.dpgNapCode;
	}

	public void setDpgNapCode(String dpgNapCode) {
		this.dpgNapCode = dpgNapCode;
	}

	@Column(name = "DPG_GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getDpgGpgId() {
		return this.dpgGpgId;
	}

	public void setDpgGpgId(long dpgGpgId) {
		this.dpgGpgId = dpgGpgId;
	}

	@Column(name = "DPG_CODE", length = 500)
	public String getDpgCode() {
		return this.dpgCode;
	}

	public void setDpgCode(String dpgCode) {
		this.dpgCode = dpgCode;
	}

	@Column(name = "DPG_LIBELLE", length = 500)
	public String getDpgLibelle() {
		return this.dpgLibelle;
	}

	public void setDpgLibelle(String dpgLibelle) {
		this.dpgLibelle = dpgLibelle;
	}

	@Column(name = "DPG_COMMENTAIRE", length = 500)
	public String getDpgCommentaire() {
		return this.dpgCommentaire;
	}

	public void setDpgCommentaire(String dpgCommentaire) {
		this.dpgCommentaire = dpgCommentaire;
	}

	@Column(name = "DPG_REFERENCE", length = 500)
	public String getDpgReference() {
		return this.dpgReference;
	}

	public void setDpgReference(String dpgReference) {
		this.dpgReference = dpgReference;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDossierPgpmId))
			return false;
		VDossierPgpmId castOther = (VDossierPgpmId) other;

		return (this.getDpgId() == castOther.getDpgId())
				&& ((this.getDpgNapCode() == castOther.getDpgNapCode()) || (this.getDpgNapCode() != null
						&& castOther.getDpgNapCode() != null && this.getDpgNapCode().equals(castOther.getDpgNapCode())))
				&& (this.getDpgGpgId() == castOther.getDpgGpgId())
				&& ((this.getDpgCode() == castOther.getDpgCode()) || (this.getDpgCode() != null
						&& castOther.getDpgCode() != null && this.getDpgCode().equals(castOther.getDpgCode())))
				&& ((this.getDpgLibelle() == castOther.getDpgLibelle()) || (this.getDpgLibelle() != null
						&& castOther.getDpgLibelle() != null && this.getDpgLibelle().equals(castOther.getDpgLibelle())))
				&& ((this.getDpgCommentaire() == castOther.getDpgCommentaire())
						|| (this.getDpgCommentaire() != null && castOther.getDpgCommentaire() != null
								&& this.getDpgCommentaire().equals(castOther.getDpgCommentaire())))
				&& ((this.getDpgReference() == castOther.getDpgReference())
						|| (this.getDpgReference() != null && castOther.getDpgReference() != null
								&& this.getDpgReference().equals(castOther.getDpgReference())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getDpgId();
		result = 37 * result + (getDpgNapCode() == null ? 0 : this.getDpgNapCode().hashCode());
		result = 37 * result + (int) this.getDpgGpgId();
		result = 37 * result + (getDpgCode() == null ? 0 : this.getDpgCode().hashCode());
		result = 37 * result + (getDpgLibelle() == null ? 0 : this.getDpgLibelle().hashCode());
		result = 37 * result + (getDpgCommentaire() == null ? 0 : this.getDpgCommentaire().hashCode());
		result = 37 * result + (getDpgReference() == null ? 0 : this.getDpgReference().hashCode());
		return result;
	}

}
