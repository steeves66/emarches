package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VProjetAgpmId generated by hbm2java
 */
@Embeddable
public class VProjetAgpmId implements java.io.Serializable {

	private long proId;
	private String proTitre;
	private String proTypeProjet;
	private String agpTypeDao;
	private String agpStaCode;
	private String agpActif;
	private BigDecimal proMontantTotCfa;
	private String proDescription;
	private long agpId;
	private Long agpDecId;
	private String agpModePassation;
	private short agpGesCode;
	private String agpCommentaire;
	private String agpStrCode;
	private String agpActeurSaisie;
	private Long regId;
	private String regLibelleLong;
	private String regLibelleCourt;
	private String minLibelle;
	private String minLibelleCourt;
	private String baiLibelle;
	private String devLibelle;
	private String souLibelle;
	private String finNumeroAccord;
	private BigDecimal finMontantCfa;
	private BigDecimal finMontantDevise;
	private String fonLibelle;
	private String strCode;
	private String strLibelleCourt;
	private String strLibelleLong;

	public VProjetAgpmId() {
	}

	public VProjetAgpmId(long proId, String proTitre, String agpStaCode, long agpId, short agpGesCode,
			String agpStrCode, String baiLibelle) {
		this.proId = proId;
		this.proTitre = proTitre;
		this.agpStaCode = agpStaCode;
		this.agpId = agpId;
		this.agpGesCode = agpGesCode;
		this.agpStrCode = agpStrCode;
		this.baiLibelle = baiLibelle;
	}

	public VProjetAgpmId(long proId, String proTitre, String proTypeProjet, String agpTypeDao, String agpStaCode,
			String agpActif, BigDecimal proMontantTotCfa, String proDescription, long agpId, Long agpDecId,
			String agpModePassation, short agpGesCode, String agpCommentaire, String agpStrCode, String agpActeurSaisie,
			Long regId, String regLibelleLong, String regLibelleCourt, String minLibelle, String minLibelleCourt,
			String baiLibelle, String devLibelle, String souLibelle, String finNumeroAccord, BigDecimal finMontantCfa,
			BigDecimal finMontantDevise, String fonLibelle, String strCode, String strLibelleCourt,
			String strLibelleLong) {
		this.proId = proId;
		this.proTitre = proTitre;
		this.proTypeProjet = proTypeProjet;
		this.agpTypeDao = agpTypeDao;
		this.agpStaCode = agpStaCode;
		this.agpActif = agpActif;
		this.proMontantTotCfa = proMontantTotCfa;
		this.proDescription = proDescription;
		this.agpId = agpId;
		this.agpDecId = agpDecId;
		this.agpModePassation = agpModePassation;
		this.agpGesCode = agpGesCode;
		this.agpCommentaire = agpCommentaire;
		this.agpStrCode = agpStrCode;
		this.agpActeurSaisie = agpActeurSaisie;
		this.regId = regId;
		this.regLibelleLong = regLibelleLong;
		this.regLibelleCourt = regLibelleCourt;
		this.minLibelle = minLibelle;
		this.minLibelleCourt = minLibelleCourt;
		this.baiLibelle = baiLibelle;
		this.devLibelle = devLibelle;
		this.souLibelle = souLibelle;
		this.finNumeroAccord = finNumeroAccord;
		this.finMontantCfa = finMontantCfa;
		this.finMontantDevise = finMontantDevise;
		this.fonLibelle = fonLibelle;
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
		this.strLibelleLong = strLibelleLong;
	}

	@Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	@Column(name = "PRO_TITRE", nullable = false, length = 500)
	public String getProTitre() {
		return this.proTitre;
	}

	public void setProTitre(String proTitre) {
		this.proTitre = proTitre;
	}

	@Column(name = "PRO_TYPE_PROJET", length = 10)
	public String getProTypeProjet() {
		return this.proTypeProjet;
	}

	public void setProTypeProjet(String proTypeProjet) {
		this.proTypeProjet = proTypeProjet;
	}

	@Column(name = "AGP_TYPE_DAO", length = 1000)
	public String getAgpTypeDao() {
		return this.agpTypeDao;
	}

	public void setAgpTypeDao(String agpTypeDao) {
		this.agpTypeDao = agpTypeDao;
	}

	@Column(name = "AGP_STA_CODE", nullable = false, length = 3)
	public String getAgpStaCode() {
		return this.agpStaCode;
	}

	public void setAgpStaCode(String agpStaCode) {
		this.agpStaCode = agpStaCode;
	}

	@Column(name = "AGP_ACTIF", length = 1)
	public String getAgpActif() {
		return this.agpActif;
	}

	public void setAgpActif(String agpActif) {
		this.agpActif = agpActif;
	}

	@Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)
	public BigDecimal getProMontantTotCfa() {
		return this.proMontantTotCfa;
	}

	public void setProMontantTotCfa(BigDecimal proMontantTotCfa) {
		this.proMontantTotCfa = proMontantTotCfa;
	}

	@Column(name = "PRO_DESCRIPTION", length = 1000)
	public String getProDescription() {
		return this.proDescription;
	}

	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}

	@Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpId() {
		return this.agpId;
	}

	public void setAgpId(long agpId) {
		this.agpId = agpId;
	}

	@Column(name = "AGP_DEC_ID", precision = 10, scale = 0)
	public Long getAgpDecId() {
		return this.agpDecId;
	}

	public void setAgpDecId(Long agpDecId) {
		this.agpDecId = agpDecId;
	}

	@Column(name = "AGP_MODE_PASSATION", length = 1000)
	public String getAgpModePassation() {
		return this.agpModePassation;
	}

	public void setAgpModePassation(String agpModePassation) {
		this.agpModePassation = agpModePassation;
	}

	@Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getAgpGesCode() {
		return this.agpGesCode;
	}

	public void setAgpGesCode(short agpGesCode) {
		this.agpGesCode = agpGesCode;
	}

	@Column(name = "AGP_COMMENTAIRE", length = 1000)
	public String getAgpCommentaire() {
		return this.agpCommentaire;
	}

	public void setAgpCommentaire(String agpCommentaire) {
		this.agpCommentaire = agpCommentaire;
	}

	@Column(name = "AGP_STR_CODE", nullable = false, length = 3)
	public String getAgpStrCode() {
		return this.agpStrCode;
	}

	public void setAgpStrCode(String agpStrCode) {
		this.agpStrCode = agpStrCode;
	}

	@Column(name = "AGP_ACTEUR_SAISIE", length = 12)
	public String getAgpActeurSaisie() {
		return this.agpActeurSaisie;
	}

	public void setAgpActeurSaisie(String agpActeurSaisie) {
		this.agpActeurSaisie = agpActeurSaisie;
	}

	@Column(name = "REG_ID", precision = 10, scale = 0)
	public Long getRegId() {
		return this.regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	@Column(name = "REG_LIBELLE_LONG", length = 1000)
	public String getRegLibelleLong() {
		return this.regLibelleLong;
	}

	public void setRegLibelleLong(String regLibelleLong) {
		this.regLibelleLong = regLibelleLong;
	}

	@Column(name = "REG_LIBELLE_COURT", length = 500)
	public String getRegLibelleCourt() {
		return this.regLibelleCourt;
	}

	public void setRegLibelleCourt(String regLibelleCourt) {
		this.regLibelleCourt = regLibelleCourt;
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

	@Column(name = "BAI_LIBELLE", nullable = false, length = 1000)
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

	@Column(name = "SOU_LIBELLE", length = 500)
	public String getSouLibelle() {
		return this.souLibelle;
	}

	public void setSouLibelle(String souLibelle) {
		this.souLibelle = souLibelle;
	}

	@Column(name = "FIN_NUMERO_ACCORD", length = 500)
	public String getFinNumeroAccord() {
		return this.finNumeroAccord;
	}

	public void setFinNumeroAccord(String finNumeroAccord) {
		this.finNumeroAccord = finNumeroAccord;
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

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "STR_CODE", length = 20)
	public String getStrCode() {
		return this.strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	@Column(name = "STR_LIBELLE_COURT", length = 500)
	public String getStrLibelleCourt() {
		return this.strLibelleCourt;
	}

	public void setStrLibelleCourt(String strLibelleCourt) {
		this.strLibelleCourt = strLibelleCourt;
	}

	@Column(name = "STR_LIBELLE_LONG", length = 1000)
	public String getStrLibelleLong() {
		return this.strLibelleLong;
	}

	public void setStrLibelleLong(String strLibelleLong) {
		this.strLibelleLong = strLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VProjetAgpmId))
			return false;
		VProjetAgpmId castOther = (VProjetAgpmId) other;

		return (this.getProId() == castOther.getProId())
				&& ((this.getProTitre() == castOther.getProTitre()) || (this.getProTitre() != null
						&& castOther.getProTitre() != null && this.getProTitre().equals(castOther.getProTitre())))
				&& ((this.getProTypeProjet() == castOther.getProTypeProjet())
						|| (this.getProTypeProjet() != null && castOther.getProTypeProjet() != null
								&& this.getProTypeProjet().equals(castOther.getProTypeProjet())))
				&& ((this.getAgpTypeDao() == castOther.getAgpTypeDao()) || (this.getAgpTypeDao() != null
						&& castOther.getAgpTypeDao() != null && this.getAgpTypeDao().equals(castOther.getAgpTypeDao())))
				&& ((this.getAgpStaCode() == castOther.getAgpStaCode()) || (this.getAgpStaCode() != null
						&& castOther.getAgpStaCode() != null && this.getAgpStaCode().equals(castOther.getAgpStaCode())))
				&& ((this.getAgpActif() == castOther.getAgpActif()) || (this.getAgpActif() != null
						&& castOther.getAgpActif() != null && this.getAgpActif().equals(castOther.getAgpActif())))
				&& ((this.getProMontantTotCfa() == castOther.getProMontantTotCfa())
						|| (this.getProMontantTotCfa() != null && castOther.getProMontantTotCfa() != null
								&& this.getProMontantTotCfa().equals(castOther.getProMontantTotCfa())))
				&& ((this.getProDescription() == castOther.getProDescription())
						|| (this.getProDescription() != null && castOther.getProDescription() != null
								&& this.getProDescription().equals(castOther.getProDescription())))
				&& (this.getAgpId() == castOther.getAgpId())
				&& ((this.getAgpDecId() == castOther.getAgpDecId()) || (this.getAgpDecId() != null
						&& castOther.getAgpDecId() != null && this.getAgpDecId().equals(castOther.getAgpDecId())))
				&& ((this.getAgpModePassation() == castOther.getAgpModePassation())
						|| (this.getAgpModePassation() != null && castOther.getAgpModePassation() != null
								&& this.getAgpModePassation().equals(castOther.getAgpModePassation())))
				&& (this.getAgpGesCode() == castOther.getAgpGesCode())
				&& ((this.getAgpCommentaire() == castOther.getAgpCommentaire())
						|| (this.getAgpCommentaire() != null && castOther.getAgpCommentaire() != null
								&& this.getAgpCommentaire().equals(castOther.getAgpCommentaire())))
				&& ((this.getAgpStrCode() == castOther.getAgpStrCode()) || (this.getAgpStrCode() != null
						&& castOther.getAgpStrCode() != null && this.getAgpStrCode().equals(castOther.getAgpStrCode())))
				&& ((this.getAgpActeurSaisie() == castOther.getAgpActeurSaisie())
						|| (this.getAgpActeurSaisie() != null && castOther.getAgpActeurSaisie() != null
								&& this.getAgpActeurSaisie().equals(castOther.getAgpActeurSaisie())))
				&& ((this.getRegId() == castOther.getRegId()) || (this.getRegId() != null
						&& castOther.getRegId() != null && this.getRegId().equals(castOther.getRegId())))
				&& ((this.getRegLibelleLong() == castOther.getRegLibelleLong())
						|| (this.getRegLibelleLong() != null && castOther.getRegLibelleLong() != null
								&& this.getRegLibelleLong().equals(castOther.getRegLibelleLong())))
				&& ((this.getRegLibelleCourt() == castOther.getRegLibelleCourt())
						|| (this.getRegLibelleCourt() != null && castOther.getRegLibelleCourt() != null
								&& this.getRegLibelleCourt().equals(castOther.getRegLibelleCourt())))
				&& ((this.getMinLibelle() == castOther.getMinLibelle()) || (this.getMinLibelle() != null
						&& castOther.getMinLibelle() != null && this.getMinLibelle().equals(castOther.getMinLibelle())))
				&& ((this.getMinLibelleCourt() == castOther.getMinLibelleCourt())
						|| (this.getMinLibelleCourt() != null && castOther.getMinLibelleCourt() != null
								&& this.getMinLibelleCourt().equals(castOther.getMinLibelleCourt())))
				&& ((this.getBaiLibelle() == castOther.getBaiLibelle()) || (this.getBaiLibelle() != null
						&& castOther.getBaiLibelle() != null && this.getBaiLibelle().equals(castOther.getBaiLibelle())))
				&& ((this.getDevLibelle() == castOther.getDevLibelle()) || (this.getDevLibelle() != null
						&& castOther.getDevLibelle() != null && this.getDevLibelle().equals(castOther.getDevLibelle())))
				&& ((this.getSouLibelle() == castOther.getSouLibelle()) || (this.getSouLibelle() != null
						&& castOther.getSouLibelle() != null && this.getSouLibelle().equals(castOther.getSouLibelle())))
				&& ((this.getFinNumeroAccord() == castOther.getFinNumeroAccord())
						|| (this.getFinNumeroAccord() != null && castOther.getFinNumeroAccord() != null
								&& this.getFinNumeroAccord().equals(castOther.getFinNumeroAccord())))
				&& ((this.getFinMontantCfa() == castOther.getFinMontantCfa())
						|| (this.getFinMontantCfa() != null && castOther.getFinMontantCfa() != null
								&& this.getFinMontantCfa().equals(castOther.getFinMontantCfa())))
				&& ((this.getFinMontantDevise() == castOther.getFinMontantDevise())
						|| (this.getFinMontantDevise() != null && castOther.getFinMontantDevise() != null
								&& this.getFinMontantDevise().equals(castOther.getFinMontantDevise())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getStrCode() == castOther.getStrCode()) || (this.getStrCode() != null
						&& castOther.getStrCode() != null && this.getStrCode().equals(castOther.getStrCode())))
				&& ((this.getStrLibelleCourt() == castOther.getStrLibelleCourt())
						|| (this.getStrLibelleCourt() != null && castOther.getStrLibelleCourt() != null
								&& this.getStrLibelleCourt().equals(castOther.getStrLibelleCourt())))
				&& ((this.getStrLibelleLong() == castOther.getStrLibelleLong())
						|| (this.getStrLibelleLong() != null && castOther.getStrLibelleLong() != null
								&& this.getStrLibelleLong().equals(castOther.getStrLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getProId();
		result = 37 * result + (getProTitre() == null ? 0 : this.getProTitre().hashCode());
		result = 37 * result + (getProTypeProjet() == null ? 0 : this.getProTypeProjet().hashCode());
		result = 37 * result + (getAgpTypeDao() == null ? 0 : this.getAgpTypeDao().hashCode());
		result = 37 * result + (getAgpStaCode() == null ? 0 : this.getAgpStaCode().hashCode());
		result = 37 * result + (getAgpActif() == null ? 0 : this.getAgpActif().hashCode());
		result = 37 * result + (getProMontantTotCfa() == null ? 0 : this.getProMontantTotCfa().hashCode());
		result = 37 * result + (getProDescription() == null ? 0 : this.getProDescription().hashCode());
		result = 37 * result + (int) this.getAgpId();
		result = 37 * result + (getAgpDecId() == null ? 0 : this.getAgpDecId().hashCode());
		result = 37 * result + (getAgpModePassation() == null ? 0 : this.getAgpModePassation().hashCode());
		result = 37 * result + this.getAgpGesCode();
		result = 37 * result + (getAgpCommentaire() == null ? 0 : this.getAgpCommentaire().hashCode());
		result = 37 * result + (getAgpStrCode() == null ? 0 : this.getAgpStrCode().hashCode());
		result = 37 * result + (getAgpActeurSaisie() == null ? 0 : this.getAgpActeurSaisie().hashCode());
		result = 37 * result + (getRegId() == null ? 0 : this.getRegId().hashCode());
		result = 37 * result + (getRegLibelleLong() == null ? 0 : this.getRegLibelleLong().hashCode());
		result = 37 * result + (getRegLibelleCourt() == null ? 0 : this.getRegLibelleCourt().hashCode());
		result = 37 * result + (getMinLibelle() == null ? 0 : this.getMinLibelle().hashCode());
		result = 37 * result + (getMinLibelleCourt() == null ? 0 : this.getMinLibelleCourt().hashCode());
		result = 37 * result + (getBaiLibelle() == null ? 0 : this.getBaiLibelle().hashCode());
		result = 37 * result + (getDevLibelle() == null ? 0 : this.getDevLibelle().hashCode());
		result = 37 * result + (getSouLibelle() == null ? 0 : this.getSouLibelle().hashCode());
		result = 37 * result + (getFinNumeroAccord() == null ? 0 : this.getFinNumeroAccord().hashCode());
		result = 37 * result + (getFinMontantCfa() == null ? 0 : this.getFinMontantCfa().hashCode());
		result = 37 * result + (getFinMontantDevise() == null ? 0 : this.getFinMontantDevise().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getStrCode() == null ? 0 : this.getStrCode().hashCode());
		result = 37 * result + (getStrLibelleCourt() == null ? 0 : this.getStrLibelleCourt().hashCode());
		result = 37 * result + (getStrLibelleLong() == null ? 0 : this.getStrLibelleLong().hashCode());
		return result;
	}

}
