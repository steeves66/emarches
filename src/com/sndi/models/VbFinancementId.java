package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbFinancementId generated by hbm2java
 */
@Embeddable
public class VbFinancementId implements java.io.Serializable {

	private long finId;
	private String finDevCode;
	private String finBaiCode;
	private String finSouCode;
	private long finProId;
	private BigDecimal finMontantCfa;
	private BigDecimal finMontantDevise;
	private String finNumeroAccord;
	private String finStatut;
	private Long finAgpId;

	public VbFinancementId() {
	}

	public VbFinancementId(long finId, String finDevCode, String finSouCode, long finProId) {
		this.finId = finId;
		this.finDevCode = finDevCode;
		this.finSouCode = finSouCode;
		this.finProId = finProId;
	}

	public VbFinancementId(long finId, String finDevCode, String finBaiCode, String finSouCode, long finProId,
			BigDecimal finMontantCfa, BigDecimal finMontantDevise, String finNumeroAccord, String finStatut,
			Long finAgpId) {
		this.finId = finId;
		this.finDevCode = finDevCode;
		this.finBaiCode = finBaiCode;
		this.finSouCode = finSouCode;
		this.finProId = finProId;
		this.finMontantCfa = finMontantCfa;
		this.finMontantDevise = finMontantDevise;
		this.finNumeroAccord = finNumeroAccord;
		this.finStatut = finStatut;
		this.finAgpId = finAgpId;
	}

	@Column(name = "FIN_ID", nullable = false, precision = 10, scale = 0)
	public long getFinId() {
		return this.finId;
	}

	public void setFinId(long finId) {
		this.finId = finId;
	}

	@Column(name = "FIN_DEV_CODE", nullable = false, length = 8)
	public String getFinDevCode() {
		return this.finDevCode;
	}

	public void setFinDevCode(String finDevCode) {
		this.finDevCode = finDevCode;
	}

	@Column(name = "FIN_BAI_CODE", length = 5)
	public String getFinBaiCode() {
		return this.finBaiCode;
	}

	public void setFinBaiCode(String finBaiCode) {
		this.finBaiCode = finBaiCode;
	}

	@Column(name = "FIN_SOU_CODE", nullable = false, length = 5)
	public String getFinSouCode() {
		return this.finSouCode;
	}

	public void setFinSouCode(String finSouCode) {
		this.finSouCode = finSouCode;
	}

	@Column(name = "FIN_PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getFinProId() {
		return this.finProId;
	}

	public void setFinProId(long finProId) {
		this.finProId = finProId;
	}

	@Column(name = "FIN_MONTANT_CFA", precision = 15)
	public BigDecimal getFinMontantCfa() {
		return this.finMontantCfa;
	}

	public void setFinMontantCfa(BigDecimal finMontantCfa) {
		this.finMontantCfa = finMontantCfa;
	}

	@Column(name = "FIN_MONTANT_DEVISE", precision = 15)
	public BigDecimal getFinMontantDevise() {
		return this.finMontantDevise;
	}

	public void setFinMontantDevise(BigDecimal finMontantDevise) {
		this.finMontantDevise = finMontantDevise;
	}

	@Column(name = "FIN_NUMERO_ACCORD", length = 500)
	public String getFinNumeroAccord() {
		return this.finNumeroAccord;
	}

	public void setFinNumeroAccord(String finNumeroAccord) {
		this.finNumeroAccord = finNumeroAccord;
	}

	@Column(name = "FIN_STATUT", length = 10)
	public String getFinStatut() {
		return this.finStatut;
	}

	public void setFinStatut(String finStatut) {
		this.finStatut = finStatut;
	}

	@Column(name = "FIN_AGP_ID", precision = 10, scale = 0)
	public Long getFinAgpId() {
		return this.finAgpId;
	}

	public void setFinAgpId(Long finAgpId) {
		this.finAgpId = finAgpId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbFinancementId))
			return false;
		VbFinancementId castOther = (VbFinancementId) other;

		return (this.getFinId() == castOther.getFinId())
				&& ((this.getFinDevCode() == castOther.getFinDevCode()) || (this.getFinDevCode() != null
						&& castOther.getFinDevCode() != null && this.getFinDevCode().equals(castOther.getFinDevCode())))
				&& ((this.getFinBaiCode() == castOther.getFinBaiCode()) || (this.getFinBaiCode() != null
						&& castOther.getFinBaiCode() != null && this.getFinBaiCode().equals(castOther.getFinBaiCode())))
				&& ((this.getFinSouCode() == castOther.getFinSouCode()) || (this.getFinSouCode() != null
						&& castOther.getFinSouCode() != null && this.getFinSouCode().equals(castOther.getFinSouCode())))
				&& (this.getFinProId() == castOther.getFinProId())
				&& ((this.getFinMontantCfa() == castOther.getFinMontantCfa())
						|| (this.getFinMontantCfa() != null && castOther.getFinMontantCfa() != null
								&& this.getFinMontantCfa().equals(castOther.getFinMontantCfa())))
				&& ((this.getFinMontantDevise() == castOther.getFinMontantDevise())
						|| (this.getFinMontantDevise() != null && castOther.getFinMontantDevise() != null
								&& this.getFinMontantDevise().equals(castOther.getFinMontantDevise())))
				&& ((this.getFinNumeroAccord() == castOther.getFinNumeroAccord())
						|| (this.getFinNumeroAccord() != null && castOther.getFinNumeroAccord() != null
								&& this.getFinNumeroAccord().equals(castOther.getFinNumeroAccord())))
				&& ((this.getFinStatut() == castOther.getFinStatut()) || (this.getFinStatut() != null
						&& castOther.getFinStatut() != null && this.getFinStatut().equals(castOther.getFinStatut())))
				&& ((this.getFinAgpId() == castOther.getFinAgpId()) || (this.getFinAgpId() != null
						&& castOther.getFinAgpId() != null && this.getFinAgpId().equals(castOther.getFinAgpId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getFinId();
		result = 37 * result + (getFinDevCode() == null ? 0 : this.getFinDevCode().hashCode());
		result = 37 * result + (getFinBaiCode() == null ? 0 : this.getFinBaiCode().hashCode());
		result = 37 * result + (getFinSouCode() == null ? 0 : this.getFinSouCode().hashCode());
		result = 37 * result + (int) this.getFinProId();
		result = 37 * result + (getFinMontantCfa() == null ? 0 : this.getFinMontantCfa().hashCode());
		result = 37 * result + (getFinMontantDevise() == null ? 0 : this.getFinMontantDevise().hashCode());
		result = 37 * result + (getFinNumeroAccord() == null ? 0 : this.getFinNumeroAccord().hashCode());
		result = 37 * result + (getFinStatut() == null ? 0 : this.getFinStatut().hashCode());
		result = 37 * result + (getFinAgpId() == null ? 0 : this.getFinAgpId().hashCode());
		return result;
	}

}
