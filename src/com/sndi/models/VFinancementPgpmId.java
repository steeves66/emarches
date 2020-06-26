package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VFinancementPgpmId generated by hbm2java
 */
@Embeddable
public class VFinancementPgpmId implements java.io.Serializable {

	private long fipId;
	private String fipDevCode;
	private String fipBaiCode;
	private String fipSouCode;
	private long fipGpgId;
	private BigDecimal fipMontantCfa;
	private BigDecimal fipMontantDevise;
	private String fipCommentaire;
	private String fipTypeFinance;
	private BigDecimal fipTresor;
	private String baiLibelle;
	private String devLibelle;
	private String devSymbole;
	private String souLibelle;

	public VFinancementPgpmId() {
	}

	public VFinancementPgpmId(long fipId, String fipDevCode, String fipSouCode, long fipGpgId) {
		this.fipId = fipId;
		this.fipDevCode = fipDevCode;
		this.fipSouCode = fipSouCode;
		this.fipGpgId = fipGpgId;
	}

	public VFinancementPgpmId(long fipId, String fipDevCode, String fipBaiCode, String fipSouCode, long fipGpgId,
			BigDecimal fipMontantCfa, BigDecimal fipMontantDevise, String fipCommentaire, String fipTypeFinance,
			BigDecimal fipTresor, String baiLibelle, String devLibelle, String devSymbole, String souLibelle) {
		this.fipId = fipId;
		this.fipDevCode = fipDevCode;
		this.fipBaiCode = fipBaiCode;
		this.fipSouCode = fipSouCode;
		this.fipGpgId = fipGpgId;
		this.fipMontantCfa = fipMontantCfa;
		this.fipMontantDevise = fipMontantDevise;
		this.fipCommentaire = fipCommentaire;
		this.fipTypeFinance = fipTypeFinance;
		this.fipTresor = fipTresor;
		this.baiLibelle = baiLibelle;
		this.devLibelle = devLibelle;
		this.devSymbole = devSymbole;
		this.souLibelle = souLibelle;
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

	@Column(name = "FIP_TYPE_FINANCE", length = 20)
	public String getFipTypeFinance() {
		return this.fipTypeFinance;
	}

	public void setFipTypeFinance(String fipTypeFinance) {
		this.fipTypeFinance = fipTypeFinance;
	}

	@Column(name = "FIP_TRESOR", precision = 22, scale = 0)
	public BigDecimal getFipTresor() {
		return this.fipTresor;
	}

	public void setFipTresor(BigDecimal fipTresor) {
		this.fipTresor = fipTresor;
	}

	@Column(name = "BAI_LIBELLE", length = 1000)
	public String getBaiLibelle() {
		return this.baiLibelle;
	}

	public void setBaiLibelle(String baiLibelle) {
		this.baiLibelle = baiLibelle;
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
		if (!(other instanceof VFinancementPgpmId))
			return false;
		VFinancementPgpmId castOther = (VFinancementPgpmId) other;

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
								&& this.getFipCommentaire().equals(castOther.getFipCommentaire())))
				&& ((this.getFipTypeFinance() == castOther.getFipTypeFinance())
						|| (this.getFipTypeFinance() != null && castOther.getFipTypeFinance() != null
								&& this.getFipTypeFinance().equals(castOther.getFipTypeFinance())))
				&& ((this.getFipTresor() == castOther.getFipTresor()) || (this.getFipTresor() != null
						&& castOther.getFipTresor() != null && this.getFipTresor().equals(castOther.getFipTresor())))
				&& ((this.getBaiLibelle() == castOther.getBaiLibelle()) || (this.getBaiLibelle() != null
						&& castOther.getBaiLibelle() != null && this.getBaiLibelle().equals(castOther.getBaiLibelle())))
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

		result = 37 * result + (int) this.getFipId();
		result = 37 * result + (getFipDevCode() == null ? 0 : this.getFipDevCode().hashCode());
		result = 37 * result + (getFipBaiCode() == null ? 0 : this.getFipBaiCode().hashCode());
		result = 37 * result + (getFipSouCode() == null ? 0 : this.getFipSouCode().hashCode());
		result = 37 * result + (int) this.getFipGpgId();
		result = 37 * result + (getFipMontantCfa() == null ? 0 : this.getFipMontantCfa().hashCode());
		result = 37 * result + (getFipMontantDevise() == null ? 0 : this.getFipMontantDevise().hashCode());
		result = 37 * result + (getFipCommentaire() == null ? 0 : this.getFipCommentaire().hashCode());
		result = 37 * result + (getFipTypeFinance() == null ? 0 : this.getFipTypeFinance().hashCode());
		result = 37 * result + (getFipTresor() == null ? 0 : this.getFipTresor().hashCode());
		result = 37 * result + (getBaiLibelle() == null ? 0 : this.getBaiLibelle().hashCode());
		result = 37 * result + (getDevLibelle() == null ? 0 : this.getDevLibelle().hashCode());
		result = 37 * result + (getDevSymbole() == null ? 0 : this.getDevSymbole().hashCode());
		result = 37 * result + (getSouLibelle() == null ? 0 : this.getSouLibelle().hashCode());
		return result;
	}

}