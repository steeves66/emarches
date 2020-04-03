package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbFinancementPgpmId generated by hbm2java
 */
@Embeddable
public class VbFinancementPgpmId implements java.io.Serializable {

	private long fipId;
	private String fipDevCode;
	private String fipBaiCode;
	private String fipSouCode;
	private long fipGpgId;
	private BigDecimal fipMontantCfa;
	private BigDecimal fipMontantDevise;
	private String fipCommentaire;

	public VbFinancementPgpmId() {
	}

	public VbFinancementPgpmId(long fipId, String fipDevCode, String fipSouCode, long fipGpgId) {
		this.fipId = fipId;
		this.fipDevCode = fipDevCode;
		this.fipSouCode = fipSouCode;
		this.fipGpgId = fipGpgId;
	}

	public VbFinancementPgpmId(long fipId, String fipDevCode, String fipBaiCode, String fipSouCode, long fipGpgId,
			BigDecimal fipMontantCfa, BigDecimal fipMontantDevise, String fipCommentaire) {
		this.fipId = fipId;
		this.fipDevCode = fipDevCode;
		this.fipBaiCode = fipBaiCode;
		this.fipSouCode = fipSouCode;
		this.fipGpgId = fipGpgId;
		this.fipMontantCfa = fipMontantCfa;
		this.fipMontantDevise = fipMontantDevise;
		this.fipCommentaire = fipCommentaire;
	}

	@Column(name = "FIP_ID", nullable = false, precision = 10, scale = 0)
	public long getFipId() {
		return this.fipId;
	}

	public void setFipId(long fipId) {
		this.fipId = fipId;
	}

	@Column(name = "FIP_DEV_CODE", nullable = false, length = 8)
	public String getFipDevCode() {
		return this.fipDevCode;
	}

	public void setFipDevCode(String fipDevCode) {
		this.fipDevCode = fipDevCode;
	}

	@Column(name = "FIP_BAI_CODE", length = 5)
	public String getFipBaiCode() {
		return this.fipBaiCode;
	}

	public void setFipBaiCode(String fipBaiCode) {
		this.fipBaiCode = fipBaiCode;
	}

	@Column(name = "FIP_SOU_CODE", nullable = false, length = 5)
	public String getFipSouCode() {
		return this.fipSouCode;
	}

	public void setFipSouCode(String fipSouCode) {
		this.fipSouCode = fipSouCode;
	}

	@Column(name = "FIP_GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getFipGpgId() {
		return this.fipGpgId;
	}

	public void setFipGpgId(long fipGpgId) {
		this.fipGpgId = fipGpgId;
	}

	@Column(name = "FIP_MONTANT_CFA", precision = 15)
	public BigDecimal getFipMontantCfa() {
		return this.fipMontantCfa;
	}

	public void setFipMontantCfa(BigDecimal fipMontantCfa) {
		this.fipMontantCfa = fipMontantCfa;
	}

	@Column(name = "FIP_MONTANT_DEVISE", precision = 15)
	public BigDecimal getFipMontantDevise() {
		return this.fipMontantDevise;
	}

	public void setFipMontantDevise(BigDecimal fipMontantDevise) {
		this.fipMontantDevise = fipMontantDevise;
	}

	@Column(name = "FIP_COMMENTAIRE", length = 500)
	public String getFipCommentaire() {
		return this.fipCommentaire;
	}

	public void setFipCommentaire(String fipCommentaire) {
		this.fipCommentaire = fipCommentaire;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbFinancementPgpmId))
			return false;
		VbFinancementPgpmId castOther = (VbFinancementPgpmId) other;

		return (this.getFipId() == castOther.getFipId())
				&& ((this.getFipDevCode() == castOther.getFipDevCode()) || (this.getFipDevCode() != null
						&& castOther.getFipDevCode() != null && this.getFipDevCode().equals(castOther.getFipDevCode())))
				&& ((this.getFipBaiCode() == castOther.getFipBaiCode()) || (this.getFipBaiCode() != null
						&& castOther.getFipBaiCode() != null && this.getFipBaiCode().equals(castOther.getFipBaiCode())))
				&& ((this.getFipSouCode() == castOther.getFipSouCode()) || (this.getFipSouCode() != null
						&& castOther.getFipSouCode() != null && this.getFipSouCode().equals(castOther.getFipSouCode())))
				&& (this.getFipGpgId() == castOther.getFipGpgId())
				&& ((this.getFipMontantCfa() == castOther.getFipMontantCfa())
						|| (this.getFipMontantCfa() != null && castOther.getFipMontantCfa() != null
								&& this.getFipMontantCfa().equals(castOther.getFipMontantCfa())))
				&& ((this.getFipMontantDevise() == castOther.getFipMontantDevise())
						|| (this.getFipMontantDevise() != null && castOther.getFipMontantDevise() != null
								&& this.getFipMontantDevise().equals(castOther.getFipMontantDevise())))
				&& ((this.getFipCommentaire() == castOther.getFipCommentaire())
						|| (this.getFipCommentaire() != null && castOther.getFipCommentaire() != null
								&& this.getFipCommentaire().equals(castOther.getFipCommentaire())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getFipId();
		result = 37 * result + (getFipDevCode() == null ? 0 : this.getFipDevCode().hashCode());
		result = 37 * result + (getFipBaiCode() == null ? 0 : this.getFipBaiCode().hashCode());
		result = 37 * result + (getFipSouCode() == null ? 0 : this.getFipSouCode().hashCode());
		result = 37 * result + (int) this.getFipGpgId();
		result = 37 * result + (getFipMontantCfa() == null ? 0 : this.getFipMontantCfa().hashCode());
		result = 37 * result + (getFipMontantDevise() == null ? 0 : this.getFipMontantDevise().hashCode());
		result = 37 * result + (getFipCommentaire() == null ? 0 : this.getFipCommentaire().hashCode());
		return result;
	}

}
