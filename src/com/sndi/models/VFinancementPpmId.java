package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VFinancementPpmId generated by hbm2java
 */
@Embeddable
public class VFinancementPpmId implements java.io.Serializable {

	private long fppId;
	private String fppDevCode;
	private String fppBaiCode;
	private String fppSouCode;
	private long fppDppId;
	private BigDecimal fppMontantCfa;
	private BigDecimal fppMontantDevise;
	private String fppCommentaire;
	private String fppTypeFinance;
	private Long fppPartTresor;
	private String baiCode;
	private String baiLibelle;
	private String baiAdresse;
	private String baiTelephone;
	private String souCode;
	private String souLibelle;
	private String devCode;
	private String devLibelle;
	private String devSymbole;

	public VFinancementPpmId() {
	}

	public VFinancementPpmId(long fppId, String fppDevCode, String fppSouCode, long fppDppId) {
		this.fppId = fppId;
		this.fppDevCode = fppDevCode;
		this.fppSouCode = fppSouCode;
		this.fppDppId = fppDppId;
	}

	public VFinancementPpmId(long fppId, String fppDevCode, String fppBaiCode, String fppSouCode, long fppDppId,
			BigDecimal fppMontantCfa, BigDecimal fppMontantDevise, String fppCommentaire, String fppTypeFinance,
			Long fppPartTresor, String baiCode, String baiLibelle, String baiAdresse, String baiTelephone,
			String souCode, String souLibelle, String devCode, String devLibelle, String devSymbole) {
		this.fppId = fppId;
		this.fppDevCode = fppDevCode;
		this.fppBaiCode = fppBaiCode;
		this.fppSouCode = fppSouCode;
		this.fppDppId = fppDppId;
		this.fppMontantCfa = fppMontantCfa;
		this.fppMontantDevise = fppMontantDevise;
		this.fppCommentaire = fppCommentaire;
		this.fppTypeFinance = fppTypeFinance;
		this.fppPartTresor = fppPartTresor;
		this.baiCode = baiCode;
		this.baiLibelle = baiLibelle;
		this.baiAdresse = baiAdresse;
		this.baiTelephone = baiTelephone;
		this.souCode = souCode;
		this.souLibelle = souLibelle;
		this.devCode = devCode;
		this.devLibelle = devLibelle;
		this.devSymbole = devSymbole;
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

	@Column(name = "FPP_BAI_CODE", length = 5)
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

	@Column(name = "FPP_TYPE_FINANCE", length = 20)
	public String getFppTypeFinance() {
		return this.fppTypeFinance;
	}

	public void setFppTypeFinance(String fppTypeFinance) {
		this.fppTypeFinance = fppTypeFinance;
	}

	@Column(name = "FPP_PART_TRESOR", precision = 15, scale = 0)
	public Long getFppPartTresor() {
		return this.fppPartTresor;
	}

	public void setFppPartTresor(Long fppPartTresor) {
		this.fppPartTresor = fppPartTresor;
	}

	@Column(name = "BAI_CODE", length = 20)
	public String getBaiCode() {
		return this.baiCode;
	}

	public void setBaiCode(String baiCode) {
		this.baiCode = baiCode;
	}

	@Column(name = "BAI_LIBELLE", length = 1000)
	public String getBaiLibelle() {
		return this.baiLibelle;
	}

	public void setBaiLibelle(String baiLibelle) {
		this.baiLibelle = baiLibelle;
	}

	@Column(name = "BAI_ADRESSE", length = 500)
	public String getBaiAdresse() {
		return this.baiAdresse;
	}

	public void setBaiAdresse(String baiAdresse) {
		this.baiAdresse = baiAdresse;
	}

	@Column(name = "BAI_TELEPHONE", length = 500)
	public String getBaiTelephone() {
		return this.baiTelephone;
	}

	public void setBaiTelephone(String baiTelephone) {
		this.baiTelephone = baiTelephone;
	}

	@Column(name = "SOU_CODE", length = 5)
	public String getSouCode() {
		return this.souCode;
	}

	public void setSouCode(String souCode) {
		this.souCode = souCode;
	}

	@Column(name = "SOU_LIBELLE", length = 500)
	public String getSouLibelle() {
		return this.souLibelle;
	}

	public void setSouLibelle(String souLibelle) {
		this.souLibelle = souLibelle;
	}

	@Column(name = "DEV_CODE", length = 8)
	public String getDevCode() {
		return this.devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VFinancementPpmId))
			return false;
		VFinancementPpmId castOther = (VFinancementPpmId) other;

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
								&& this.getFppCommentaire().equals(castOther.getFppCommentaire())))
				&& ((this.getFppTypeFinance() == castOther.getFppTypeFinance())
						|| (this.getFppTypeFinance() != null && castOther.getFppTypeFinance() != null
								&& this.getFppTypeFinance().equals(castOther.getFppTypeFinance())))
				&& ((this.getFppPartTresor() == castOther.getFppPartTresor())
						|| (this.getFppPartTresor() != null && castOther.getFppPartTresor() != null
								&& this.getFppPartTresor().equals(castOther.getFppPartTresor())))
				&& ((this.getBaiCode() == castOther.getBaiCode()) || (this.getBaiCode() != null
						&& castOther.getBaiCode() != null && this.getBaiCode().equals(castOther.getBaiCode())))
				&& ((this.getBaiLibelle() == castOther.getBaiLibelle()) || (this.getBaiLibelle() != null
						&& castOther.getBaiLibelle() != null && this.getBaiLibelle().equals(castOther.getBaiLibelle())))
				&& ((this.getBaiAdresse() == castOther.getBaiAdresse()) || (this.getBaiAdresse() != null
						&& castOther.getBaiAdresse() != null && this.getBaiAdresse().equals(castOther.getBaiAdresse())))
				&& ((this.getBaiTelephone() == castOther.getBaiTelephone())
						|| (this.getBaiTelephone() != null && castOther.getBaiTelephone() != null
								&& this.getBaiTelephone().equals(castOther.getBaiTelephone())))
				&& ((this.getSouCode() == castOther.getSouCode()) || (this.getSouCode() != null
						&& castOther.getSouCode() != null && this.getSouCode().equals(castOther.getSouCode())))
				&& ((this.getSouLibelle() == castOther.getSouLibelle()) || (this.getSouLibelle() != null
						&& castOther.getSouLibelle() != null && this.getSouLibelle().equals(castOther.getSouLibelle())))
				&& ((this.getDevCode() == castOther.getDevCode()) || (this.getDevCode() != null
						&& castOther.getDevCode() != null && this.getDevCode().equals(castOther.getDevCode())))
				&& ((this.getDevLibelle() == castOther.getDevLibelle()) || (this.getDevLibelle() != null
						&& castOther.getDevLibelle() != null && this.getDevLibelle().equals(castOther.getDevLibelle())))
				&& ((this.getDevSymbole() == castOther.getDevSymbole())
						|| (this.getDevSymbole() != null && castOther.getDevSymbole() != null
								&& this.getDevSymbole().equals(castOther.getDevSymbole())));
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
		result = 37 * result + (getFppTypeFinance() == null ? 0 : this.getFppTypeFinance().hashCode());
		result = 37 * result + (getFppPartTresor() == null ? 0 : this.getFppPartTresor().hashCode());
		result = 37 * result + (getBaiCode() == null ? 0 : this.getBaiCode().hashCode());
		result = 37 * result + (getBaiLibelle() == null ? 0 : this.getBaiLibelle().hashCode());
		result = 37 * result + (getBaiAdresse() == null ? 0 : this.getBaiAdresse().hashCode());
		result = 37 * result + (getBaiTelephone() == null ? 0 : this.getBaiTelephone().hashCode());
		result = 37 * result + (getSouCode() == null ? 0 : this.getSouCode().hashCode());
		result = 37 * result + (getSouLibelle() == null ? 0 : this.getSouLibelle().hashCode());
		result = 37 * result + (getDevCode() == null ? 0 : this.getDevCode().hashCode());
		result = 37 * result + (getDevLibelle() == null ? 0 : this.getDevLibelle().hashCode());
		result = 37 * result + (getDevSymbole() == null ? 0 : this.getDevSymbole().hashCode());
		return result;
	}

}
