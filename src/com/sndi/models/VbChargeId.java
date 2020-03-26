package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbChargeId generated by hbm2java
 */
@Embeddable
public class VbChargeId implements java.io.Serializable {

	private long chrId;
	private String chrStrCode;
	private String chrTycCode;
	private long chrDppId;
	private String chrCommentaire;
	private String chrStatut;

	public VbChargeId() {
	}

	public VbChargeId(long chrId, String chrStrCode, String chrTycCode, long chrDppId) {
		this.chrId = chrId;
		this.chrStrCode = chrStrCode;
		this.chrTycCode = chrTycCode;
		this.chrDppId = chrDppId;
	}

	public VbChargeId(long chrId, String chrStrCode, String chrTycCode, long chrDppId, String chrCommentaire,
			String chrStatut) {
		this.chrId = chrId;
		this.chrStrCode = chrStrCode;
		this.chrTycCode = chrTycCode;
		this.chrDppId = chrDppId;
		this.chrCommentaire = chrCommentaire;
		this.chrStatut = chrStatut;
	}

	@Column(name = "CHR_ID", nullable = false, precision = 10, scale = 0)
	public long getChrId() {
		return this.chrId;
	}

	public void setChrId(long chrId) {
		this.chrId = chrId;
	}

	@Column(name = "CHR_STR_CODE", nullable = false, length = 3)
	public String getChrStrCode() {
		return this.chrStrCode;
	}

	public void setChrStrCode(String chrStrCode) {
		this.chrStrCode = chrStrCode;
	}

	@Column(name = "CHR_TYC_CODE", nullable = false, length = 3)
	public String getChrTycCode() {
		return this.chrTycCode;
	}

	public void setChrTycCode(String chrTycCode) {
		this.chrTycCode = chrTycCode;
	}

	@Column(name = "CHR_DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getChrDppId() {
		return this.chrDppId;
	}

	public void setChrDppId(long chrDppId) {
		this.chrDppId = chrDppId;
	}

	@Column(name = "CHR_COMMENTAIRE", length = 1000)
	public String getChrCommentaire() {
		return this.chrCommentaire;
	}

	public void setChrCommentaire(String chrCommentaire) {
		this.chrCommentaire = chrCommentaire;
	}

	@Column(name = "CHR_STATUT", length = 1)
	public String getChrStatut() {
		return this.chrStatut;
	}

	public void setChrStatut(String chrStatut) {
		this.chrStatut = chrStatut;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbChargeId))
			return false;
		VbChargeId castOther = (VbChargeId) other;

		return (this.getChrId() == castOther.getChrId())
				&& ((this.getChrStrCode() == castOther.getChrStrCode()) || (this.getChrStrCode() != null
						&& castOther.getChrStrCode() != null && this.getChrStrCode().equals(castOther.getChrStrCode())))
				&& ((this.getChrTycCode() == castOther.getChrTycCode()) || (this.getChrTycCode() != null
						&& castOther.getChrTycCode() != null && this.getChrTycCode().equals(castOther.getChrTycCode())))
				&& (this.getChrDppId() == castOther.getChrDppId())
				&& ((this.getChrCommentaire() == castOther.getChrCommentaire())
						|| (this.getChrCommentaire() != null && castOther.getChrCommentaire() != null
								&& this.getChrCommentaire().equals(castOther.getChrCommentaire())))
				&& ((this.getChrStatut() == castOther.getChrStatut()) || (this.getChrStatut() != null
						&& castOther.getChrStatut() != null && this.getChrStatut().equals(castOther.getChrStatut())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getChrId();
		result = 37 * result + (getChrStrCode() == null ? 0 : this.getChrStrCode().hashCode());
		result = 37 * result + (getChrTycCode() == null ? 0 : this.getChrTycCode().hashCode());
		result = 37 * result + (int) this.getChrDppId();
		result = 37 * result + (getChrCommentaire() == null ? 0 : this.getChrCommentaire().hashCode());
		result = 37 * result + (getChrStatut() == null ? 0 : this.getChrStatut().hashCode());
		return result;
	}

}
