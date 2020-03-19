package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbFinancementPpmId generated by hbm2java
 */
@Embeddable
public class VbFinancementPpmId implements java.io.Serializable {

	private long fppId;
	private String fppDevCode;
	private String fppBaiCode;
	private String fppSouCode;
	private long fppDppId;
	private BigDecimal fppMontantCfa;
	private BigDecimal fppMontantDevise;
	private String fppCommentaire;

	public VbFinancementPpmId() {
	}

	public VbFinancementPpmId(long fppId, String fppDevCode, String fppBaiCode, String fppSouCode, long fppDppId) {
		this.fppId = fppId;
		this.fppDevCode = fppDevCode;
		this.fppBaiCode = fppBaiCode;
		this.fppSouCode = fppSouCode;
		this.fppDppId = fppDppId;
	}

	public VbFinancementPpmId(long fppId, String fppDevCode, String fppBaiCode, String fppSouCode, long fppDppId,
			BigDecimal fppMontantCfa, BigDecimal fppMontantDevise, String fppCommentaire) {
		this.fppId = fppId;
		this.fppDevCode = fppDevCode;
		this.fppBaiCode = fppBaiCode;
		this.fppSouCode = fppSouCode;
		this.fppDppId = fppDppId;
		this.fppMontantCfa = fppMontantCfa;
		this.fppMontantDevise = fppMontantDevise;
		this.fppCommentaire = fppCommentaire;
	}

	@Column(name = "FPP_ID", nullable = false, precision = 10, scale = 0)
	public long getFppId() {
		return this.fppId;
	}

	public void setFppId(long fppId) {
		this.fppId = fppId;
	}

	@Column(name = "FPP_DEV_CODE", nullable = false, length = 8)
	public String getFppDevCode() {
		return this.fppDevCode;
	}

	public void setFppDevCode(String fppDevCode) {
		this.fppDevCode = fppDevCode;
	}

	@Column(name = "FPP_BAI_CODE", nullable = false, length = 5)
	public String getFppBaiCode() {
		return this.fppBaiCode;
	}

	public void setFppBaiCode(String fppBaiCode) {
		this.fppBaiCode = fppBaiCode;
	}

	@Column(name = "FPP_SOU_CODE", nullable = false, length = 5)
	public String getFppSouCode() {
		return this.fppSouCode;
	}

	public void setFppSouCode(String fppSouCode) {
		this.fppSouCode = fppSouCode;
	}

	@Column(name = "FPP_DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getFppDppId() {
		return this.fppDppId;
	}

	public void setFppDppId(long fppDppId) {
		this.fppDppId = fppDppId;
	}

	@Column(name = "FPP_MONTANT_CFA", precision = 15)
	public BigDecimal getFppMontantCfa() {
		return this.fppMontantCfa;
	}

	public void setFppMontantCfa(BigDecimal fppMontantCfa) {
		this.fppMontantCfa = fppMontantCfa;
	}

	@Column(name = "FPP_MONTANT_DEVISE", precision = 15)
	public BigDecimal getFppMontantDevise() {
		return this.fppMontantDevise;
	}

	public void setFppMontantDevise(BigDecimal fppMontantDevise) {
		this.fppMontantDevise = fppMontantDevise;
	}

	@Column(name = "FPP_COMMENTAIRE", length = 500)
	public String getFppCommentaire() {
		return this.fppCommentaire;
	}

	public void setFppCommentaire(String fppCommentaire) {
		this.fppCommentaire = fppCommentaire;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbFinancementPpmId))
			return false;
		VbFinancementPpmId castOther = (VbFinancementPpmId) other;

		return (this.getFppId() == castOther.getFppId())
				&& ((this.getFppDevCode() == castOther.getFppDevCode()) || (this.getFppDevCode() != null
						&& castOther.getFppDevCode() != null && this.getFppDevCode().equals(castOther.getFppDevCode())))
				&& ((this.getFppBaiCode() == castOther.getFppBaiCode()) || (this.getFppBaiCode() != null
						&& castOther.getFppBaiCode() != null && this.getFppBaiCode().equals(castOther.getFppBaiCode())))
				&& ((this.getFppSouCode() == castOther.getFppSouCode()) || (this.getFppSouCode() != null
						&& castOther.getFppSouCode() != null && this.getFppSouCode().equals(castOther.getFppSouCode())))
				&& (this.getFppDppId() == castOther.getFppDppId())
				&& ((this.getFppMontantCfa() == castOther.getFppMontantCfa())
						|| (this.getFppMontantCfa() != null && castOther.getFppMontantCfa() != null
								&& this.getFppMontantCfa().equals(castOther.getFppMontantCfa())))
				&& ((this.getFppMontantDevise() == castOther.getFppMontantDevise())
						|| (this.getFppMontantDevise() != null && castOther.getFppMontantDevise() != null
								&& this.getFppMontantDevise().equals(castOther.getFppMontantDevise())))
				&& ((this.getFppCommentaire() == castOther.getFppCommentaire())
						|| (this.getFppCommentaire() != null && castOther.getFppCommentaire() != null
								&& this.getFppCommentaire().equals(castOther.getFppCommentaire())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getFppId();
		result = 37 * result + (getFppDevCode() == null ? 0 : this.getFppDevCode().hashCode());
		result = 37 * result + (getFppBaiCode() == null ? 0 : this.getFppBaiCode().hashCode());
		result = 37 * result + (getFppSouCode() == null ? 0 : this.getFppSouCode().hashCode());
		result = 37 * result + (int) this.getFppDppId();
		result = 37 * result + (getFppMontantCfa() == null ? 0 : this.getFppMontantCfa().hashCode());
		result = 37 * result + (getFppMontantDevise() == null ? 0 : this.getFppMontantDevise().hashCode());
		result = 37 * result + (getFppCommentaire() == null ? 0 : this.getFppCommentaire().hashCode());
		return result;
	}

}
