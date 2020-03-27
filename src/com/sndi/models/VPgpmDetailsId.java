package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPgpmDetailsId generated by hbm2java
 */
@Embeddable
public class VPgpmDetailsId implements java.io.Serializable {

	private Long affGpgId;
	private String souLibelle;
	private String affGpgObjet;
	private String affGpgStaCode;
	private String affGpgTypePlan;
	private String affGpgActeurSaisie;
	private String fonLibelle;
	private String tymCode;
	private String tymLibelleCourt;
	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String affGpgPartiePmePmi;
	private Date affGpgDateDao;
	private String affGpgCommentaire;
	private Integer affGpgNumeroOrdre;
	private Date affGpgDateSaisie;
	private long plgId;
	private short plgGesCode;
	private String minLibelle;
	private String minLibelleCourt;
	private String strCode;
	private String strLibelleCourt;
	private String strLibelleLong;

	public VPgpmDetailsId() {
	}

	public VPgpmDetailsId(String affGpgStaCode, String affGpgTypePlan, String tymCode, String tymLibelleCourt,
			String mopCode, String mopLibelleCourt, long plgId, short plgGesCode, String strCode,
			String strLibelleCourt) {
		this.affGpgStaCode = affGpgStaCode;
		this.affGpgTypePlan = affGpgTypePlan;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
	}

	public VPgpmDetailsId(Long affGpgId, String souLibelle, String affGpgObjet, String affGpgStaCode,
			String affGpgTypePlan, String affGpgActeurSaisie, String fonLibelle, String tymCode, String tymLibelleCourt,
			String mopCode, String mopLibelleCourt, String mopLibelleLong, String affGpgPartiePmePmi,
			Date affGpgDateDao, String affGpgCommentaire, Integer affGpgNumeroOrdre, Date affGpgDateSaisie, long plgId,
			short plgGesCode, String minLibelle, String minLibelleCourt, String strCode, String strLibelleCourt,
			String strLibelleLong) {
		this.affGpgId = affGpgId;
		this.souLibelle = souLibelle;
		this.affGpgObjet = affGpgObjet;
		this.affGpgStaCode = affGpgStaCode;
		this.affGpgTypePlan = affGpgTypePlan;
		this.affGpgActeurSaisie = affGpgActeurSaisie;
		this.fonLibelle = fonLibelle;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.affGpgPartiePmePmi = affGpgPartiePmePmi;
		this.affGpgDateDao = affGpgDateDao;
		this.affGpgCommentaire = affGpgCommentaire;
		this.affGpgNumeroOrdre = affGpgNumeroOrdre;
		this.affGpgDateSaisie = affGpgDateSaisie;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
		this.minLibelle = minLibelle;
		this.minLibelleCourt = minLibelleCourt;
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
		this.strLibelleLong = strLibelleLong;
	}

	@Column(name = "AFF_GPG_ID", precision = 10, scale = 0)
	public Long getAffGpgId() {
		return this.affGpgId;
	}

	public void setAffGpgId(Long affGpgId) {
		this.affGpgId = affGpgId;
	}

	@Column(name = "SOU_LIBELLE", length = 500)
	public String getSouLibelle() {
		return this.souLibelle;
	}

	public void setSouLibelle(String souLibelle) {
		this.souLibelle = souLibelle;
	}

	@Column(name = "AFF_GPG_OBJET", length = 1000)
	public String getAffGpgObjet() {
		return this.affGpgObjet;
	}

	public void setAffGpgObjet(String affGpgObjet) {
		this.affGpgObjet = affGpgObjet;
	}

	@Column(name = "AFF_GPG_STA_CODE", nullable = false, length = 3)
	public String getAffGpgStaCode() {
		return this.affGpgStaCode;
	}

	public void setAffGpgStaCode(String affGpgStaCode) {
		this.affGpgStaCode = affGpgStaCode;
	}

	@Column(name = "AFF_GPG_TYPE_PLAN", nullable = false, length = 3)
	public String getAffGpgTypePlan() {
		return this.affGpgTypePlan;
	}

	public void setAffGpgTypePlan(String affGpgTypePlan) {
		this.affGpgTypePlan = affGpgTypePlan;
	}

	@Column(name = "AFF_GPG_ACTEUR_SAISIE", length = 12)
	public String getAffGpgActeurSaisie() {
		return this.affGpgActeurSaisie;
	}

	public void setAffGpgActeurSaisie(String affGpgActeurSaisie) {
		this.affGpgActeurSaisie = affGpgActeurSaisie;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "TYM_CODE", nullable = false, length = 3)
	public String getTymCode() {
		return this.tymCode;
	}

	public void setTymCode(String tymCode) {
		this.tymCode = tymCode;
	}

	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}

	@Column(name = "MOP_CODE", nullable = false, length = 3)
	public String getMopCode() {
		return this.mopCode;
	}

	public void setMopCode(String mopCode) {
		this.mopCode = mopCode;
	}

	@Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)
	public String getMopLibelleCourt() {
		return this.mopLibelleCourt;
	}

	public void setMopLibelleCourt(String mopLibelleCourt) {
		this.mopLibelleCourt = mopLibelleCourt;
	}

	@Column(name = "MOP_LIBELLE_LONG", length = 1000)
	public String getMopLibelleLong() {
		return this.mopLibelleLong;
	}

	public void setMopLibelleLong(String mopLibelleLong) {
		this.mopLibelleLong = mopLibelleLong;
	}

	@Column(name = "AFF_GPG_PARTIE_PME_PMI", length = 1)
	public String getAffGpgPartiePmePmi() {
		return this.affGpgPartiePmePmi;
	}

	public void setAffGpgPartiePmePmi(String affGpgPartiePmePmi) {
		this.affGpgPartiePmePmi = affGpgPartiePmePmi;
	}

	@Column(name = "AFF_GPG_DATE_DAO", length = 7)
	public Date getAffGpgDateDao() {
		return this.affGpgDateDao;
	}

	public void setAffGpgDateDao(Date affGpgDateDao) {
		this.affGpgDateDao = affGpgDateDao;
	}

	@Column(name = "AFF_GPG_COMMENTAIRE", length = 1000)
	public String getAffGpgCommentaire() {
		return this.affGpgCommentaire;
	}

	public void setAffGpgCommentaire(String affGpgCommentaire) {
		this.affGpgCommentaire = affGpgCommentaire;
	}

	@Column(name = "AFF_GPG_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getAffGpgNumeroOrdre() {
		return this.affGpgNumeroOrdre;
	}

	public void setAffGpgNumeroOrdre(Integer affGpgNumeroOrdre) {
		this.affGpgNumeroOrdre = affGpgNumeroOrdre;
	}

	@Column(name = "AFF_GPG_DATE_SAISIE", length = 7)
	public Date getAffGpgDateSaisie() {
		return this.affGpgDateSaisie;
	}

	public void setAffGpgDateSaisie(Date affGpgDateSaisie) {
		this.affGpgDateSaisie = affGpgDateSaisie;
	}

	@Column(name = "PLG_ID", nullable = false, precision = 10, scale = 0)
	public long getPlgId() {
		return this.plgId;
	}

	public void setPlgId(long plgId) {
		this.plgId = plgId;
	}

	@Column(name = "PLG_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getPlgGesCode() {
		return this.plgGesCode;
	}

	public void setPlgGesCode(short plgGesCode) {
		this.plgGesCode = plgGesCode;
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

	@Column(name = "STR_CODE", nullable = false, length = 20)
	public String getStrCode() {
		return this.strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	@Column(name = "STR_LIBELLE_COURT", nullable = false, length = 500)
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
		if (!(other instanceof VPgpmDetailsId))
			return false;
		VPgpmDetailsId castOther = (VPgpmDetailsId) other;

		return ((this.getAffGpgId() == castOther.getAffGpgId()) || (this.getAffGpgId() != null
				&& castOther.getAffGpgId() != null && this.getAffGpgId().equals(castOther.getAffGpgId())))
				&& ((this.getSouLibelle() == castOther.getSouLibelle()) || (this.getSouLibelle() != null
						&& castOther.getSouLibelle() != null && this.getSouLibelle().equals(castOther.getSouLibelle())))
				&& ((this.getAffGpgObjet() == castOther.getAffGpgObjet())
						|| (this.getAffGpgObjet() != null && castOther.getAffGpgObjet() != null
								&& this.getAffGpgObjet().equals(castOther.getAffGpgObjet())))
				&& ((this.getAffGpgStaCode() == castOther.getAffGpgStaCode())
						|| (this.getAffGpgStaCode() != null && castOther.getAffGpgStaCode() != null
								&& this.getAffGpgStaCode().equals(castOther.getAffGpgStaCode())))
				&& ((this.getAffGpgTypePlan() == castOther.getAffGpgTypePlan())
						|| (this.getAffGpgTypePlan() != null && castOther.getAffGpgTypePlan() != null
								&& this.getAffGpgTypePlan().equals(castOther.getAffGpgTypePlan())))
				&& ((this.getAffGpgActeurSaisie() == castOther.getAffGpgActeurSaisie())
						|| (this.getAffGpgActeurSaisie() != null && castOther.getAffGpgActeurSaisie() != null
								&& this.getAffGpgActeurSaisie().equals(castOther.getAffGpgActeurSaisie())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getTymCode() == castOther.getTymCode()) || (this.getTymCode() != null
						&& castOther.getTymCode() != null && this.getTymCode().equals(castOther.getTymCode())))
				&& ((this.getTymLibelleCourt() == castOther.getTymLibelleCourt())
						|| (this.getTymLibelleCourt() != null && castOther.getTymLibelleCourt() != null
								&& this.getTymLibelleCourt().equals(castOther.getTymLibelleCourt())))
				&& ((this.getMopCode() == castOther.getMopCode()) || (this.getMopCode() != null
						&& castOther.getMopCode() != null && this.getMopCode().equals(castOther.getMopCode())))
				&& ((this.getMopLibelleCourt() == castOther.getMopLibelleCourt())
						|| (this.getMopLibelleCourt() != null && castOther.getMopLibelleCourt() != null
								&& this.getMopLibelleCourt().equals(castOther.getMopLibelleCourt())))
				&& ((this.getMopLibelleLong() == castOther.getMopLibelleLong())
						|| (this.getMopLibelleLong() != null && castOther.getMopLibelleLong() != null
								&& this.getMopLibelleLong().equals(castOther.getMopLibelleLong())))
				&& ((this.getAffGpgPartiePmePmi() == castOther.getAffGpgPartiePmePmi())
						|| (this.getAffGpgPartiePmePmi() != null && castOther.getAffGpgPartiePmePmi() != null
								&& this.getAffGpgPartiePmePmi().equals(castOther.getAffGpgPartiePmePmi())))
				&& ((this.getAffGpgDateDao() == castOther.getAffGpgDateDao())
						|| (this.getAffGpgDateDao() != null && castOther.getAffGpgDateDao() != null
								&& this.getAffGpgDateDao().equals(castOther.getAffGpgDateDao())))
				&& ((this.getAffGpgCommentaire() == castOther.getAffGpgCommentaire())
						|| (this.getAffGpgCommentaire() != null && castOther.getAffGpgCommentaire() != null
								&& this.getAffGpgCommentaire().equals(castOther.getAffGpgCommentaire())))
				&& ((this.getAffGpgNumeroOrdre() == castOther.getAffGpgNumeroOrdre())
						|| (this.getAffGpgNumeroOrdre() != null && castOther.getAffGpgNumeroOrdre() != null
								&& this.getAffGpgNumeroOrdre().equals(castOther.getAffGpgNumeroOrdre())))
				&& ((this.getAffGpgDateSaisie() == castOther.getAffGpgDateSaisie())
						|| (this.getAffGpgDateSaisie() != null && castOther.getAffGpgDateSaisie() != null
								&& this.getAffGpgDateSaisie().equals(castOther.getAffGpgDateSaisie())))
				&& (this.getPlgId() == castOther.getPlgId()) && (this.getPlgGesCode() == castOther.getPlgGesCode())
				&& ((this.getMinLibelle() == castOther.getMinLibelle()) || (this.getMinLibelle() != null
						&& castOther.getMinLibelle() != null && this.getMinLibelle().equals(castOther.getMinLibelle())))
				&& ((this.getMinLibelleCourt() == castOther.getMinLibelleCourt())
						|| (this.getMinLibelleCourt() != null && castOther.getMinLibelleCourt() != null
								&& this.getMinLibelleCourt().equals(castOther.getMinLibelleCourt())))
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

		result = 37 * result + (getAffGpgId() == null ? 0 : this.getAffGpgId().hashCode());
		result = 37 * result + (getSouLibelle() == null ? 0 : this.getSouLibelle().hashCode());
		result = 37 * result + (getAffGpgObjet() == null ? 0 : this.getAffGpgObjet().hashCode());
		result = 37 * result + (getAffGpgStaCode() == null ? 0 : this.getAffGpgStaCode().hashCode());
		result = 37 * result + (getAffGpgTypePlan() == null ? 0 : this.getAffGpgTypePlan().hashCode());
		result = 37 * result + (getAffGpgActeurSaisie() == null ? 0 : this.getAffGpgActeurSaisie().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getTymCode() == null ? 0 : this.getTymCode().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getMopCode() == null ? 0 : this.getMopCode().hashCode());
		result = 37 * result + (getMopLibelleCourt() == null ? 0 : this.getMopLibelleCourt().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		result = 37 * result + (getAffGpgPartiePmePmi() == null ? 0 : this.getAffGpgPartiePmePmi().hashCode());
		result = 37 * result + (getAffGpgDateDao() == null ? 0 : this.getAffGpgDateDao().hashCode());
		result = 37 * result + (getAffGpgCommentaire() == null ? 0 : this.getAffGpgCommentaire().hashCode());
		result = 37 * result + (getAffGpgNumeroOrdre() == null ? 0 : this.getAffGpgNumeroOrdre().hashCode());
		result = 37 * result + (getAffGpgDateSaisie() == null ? 0 : this.getAffGpgDateSaisie().hashCode());
		result = 37 * result + (int) this.getPlgId();
		result = 37 * result + this.getPlgGesCode();
		result = 37 * result + (getMinLibelle() == null ? 0 : this.getMinLibelle().hashCode());
		result = 37 * result + (getMinLibelleCourt() == null ? 0 : this.getMinLibelleCourt().hashCode());
		result = 37 * result + (getStrCode() == null ? 0 : this.getStrCode().hashCode());
		result = 37 * result + (getStrLibelleCourt() == null ? 0 : this.getStrLibelleCourt().hashCode());
		result = 37 * result + (getStrLibelleLong() == null ? 0 : this.getStrLibelleLong().hashCode());
		return result;
	}

}
