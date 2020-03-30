package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VFinancementId generated by hbm2java
 */
@Embeddable
public class VFinancementId implements java.io.Serializable {

	private long finId;
	private long finProId;
	private Long finAgpId;
	private BigDecimal finMontantCfa;
	private BigDecimal finMontantDevise;
	private String finNumeroAccord;
	private String finStatut;
	private String baiLibelle;
	private String baiTelephone;
	private String baiAdresse;
	private String devLibelle;
	private String devSymbole;
	private String souLibelle;

	public VFinancementId() {
	}

	public VFinancementId(long finId, long finProId, String baiLibelle) {
		this.finId = finId;
		this.finProId = finProId;
		this.baiLibelle = baiLibelle;
	}

	public VFinancementId(long finId, long finProId, Long finAgpId, BigDecimal finMontantCfa,
			BigDecimal finMontantDevise, String finNumeroAccord, String finStatut, String baiLibelle,
			String baiTelephone, String baiAdresse, String devLibelle, String devSymbole, String souLibelle) {
		this.finId = finId;
		this.finProId = finProId;
		this.finAgpId = finAgpId;
		this.finMontantCfa = finMontantCfa;
		this.finMontantDevise = finMontantDevise;
		this.finNumeroAccord = finNumeroAccord;
		this.finStatut = finStatut;
		this.baiLibelle = baiLibelle;
		this.baiTelephone = baiTelephone;
		this.baiAdresse = baiAdresse;
		this.devLibelle = devLibelle;
		this.devSymbole = devSymbole;
		this.souLibelle = souLibelle;
	}

	@Column(name = "FIN_ID", nullable = false, precision = 10, scale = 0)
	public long getFinId() {
		return this.finId;
	}

	public void setFinId(long finId) {
		this.finId = finId;
	}

	@Column(name = "FIN_PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getFinProId() {
		return this.finProId;
	}

	public void setFinProId(long finProId) {
		this.finProId = finProId;
	}

	@Column(name = "FIN_AGP_ID", precision = 10, scale = 0)
	public Long getFinAgpId() {
		return this.finAgpId;
	}

	public void setFinAgpId(Long finAgpId) {
		this.finAgpId = finAgpId;
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

	@Column(name = "BAI_LIBELLE", nullable = false, length = 1000)
	public String getBaiLibelle() {
		return this.baiLibelle;
	}

	public void setBaiLibelle(String baiLibelle) {
		this.baiLibelle = baiLibelle;
	}

	@Column(name = "BAI_TELEPHONE", length = 500)
	public String getBaiTelephone() {
		return this.baiTelephone;
	}

	public void setBaiTelephone(String baiTelephone) {
		this.baiTelephone = baiTelephone;
	}

	@Column(name = "BAI_ADRESSE", length = 500)
	public String getBaiAdresse() {
		return this.baiAdresse;
	}

	public void setBaiAdresse(String baiAdresse) {
		this.baiAdresse = baiAdresse;
	}

	@Column(name = "DEV_LIBELLE", length = 500)
	public String getDevLibelle() {
		return this.devLibelle;
	}

	public void setDevLibelle(String devLibelle) {
		this.devLibelle = devLibelle;
	}

	@Column(name = "DEV_SYMBOLE", length = 500)
	public String getDevSymbole() {
		return this.devSymbole;
	}

	public void setDevSymbole(String devSymbole) {
		this.devSymbole = devSymbole;
	}

	@Column(name = "SOU_LIBELLE", length = 500)
	public String getSouLibelle() {
		return this.souLibelle;
	}

	public void setSouLibelle(String souLibelle) {
		this.souLibelle = souLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VFinancementId))
			return false;
		VFinancementId castOther = (VFinancementId) other;

		return (this.getFinId() == castOther.getFinId()) && (this.getFinProId() == castOther.getFinProId())
				&& ((this.getFinAgpId() == castOther.getFinAgpId()) || (this.getFinAgpId() != null
						&& castOther.getFinAgpId() != null && this.getFinAgpId().equals(castOther.getFinAgpId())))
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
				&& ((this.getBaiLibelle() == castOther.getBaiLibelle()) || (this.getBaiLibelle() != null
						&& castOther.getBaiLibelle() != null && this.getBaiLibelle().equals(castOther.getBaiLibelle())))
				&& ((this.getBaiTelephone() == castOther.getBaiTelephone())
						|| (this.getBaiTelephone() != null && castOther.getBaiTelephone() != null
								&& this.getBaiTelephone().equals(castOther.getBaiTelephone())))
				&& ((this.getBaiAdresse() == castOther.getBaiAdresse()) || (this.getBaiAdresse() != null
						&& castOther.getBaiAdresse() != null && this.getBaiAdresse().equals(castOther.getBaiAdresse())))
				&& ((this.getDevLibelle() == castOther.getDevLibelle()) || (this.getDevLibelle() != null
						&& castOther.getDevLibelle() != null && this.getDevLibelle().equals(castOther.getDevLibelle())))
				&& ((this.getDevSymbole() == castOther.getDevSymbole()) || (this.getDevSymbole() != null
						&& castOther.getDevSymbole() != null && this.getDevSymbole().equals(castOther.getDevSymbole())))
				&& ((this.getSouLibelle() == castOther.getSouLibelle())
						|| (this.getSouLibelle() != null && castOther.getSouLibelle() != null
								&& this.getSouLibelle().equals(castOther.getSouLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getFinId();
		result = 37 * result + (int) this.getFinProId();
		result = 37 * result + (getFinAgpId() == null ? 0 : this.getFinAgpId().hashCode());
		result = 37 * result + (getFinMontantCfa() == null ? 0 : this.getFinMontantCfa().hashCode());
		result = 37 * result + (getFinMontantDevise() == null ? 0 : this.getFinMontantDevise().hashCode());
		result = 37 * result + (getFinNumeroAccord() == null ? 0 : this.getFinNumeroAccord().hashCode());
		result = 37 * result + (getFinStatut() == null ? 0 : this.getFinStatut().hashCode());
		result = 37 * result + (getBaiLibelle() == null ? 0 : this.getBaiLibelle().hashCode());
		result = 37 * result + (getBaiTelephone() == null ? 0 : this.getBaiTelephone().hashCode());
		result = 37 * result + (getBaiAdresse() == null ? 0 : this.getBaiAdresse().hashCode());
		result = 37 * result + (getDevLibelle() == null ? 0 : this.getDevLibelle().hashCode());
		result = 37 * result + (getDevSymbole() == null ? 0 : this.getDevSymbole().hashCode());
		result = 37 * result + (getSouLibelle() == null ? 0 : this.getSouLibelle().hashCode());
		return result;
	}

}
