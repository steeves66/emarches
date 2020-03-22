package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPgpmId generated by hbm2java
 */
@Embeddable
public class VPgpmId implements java.io.Serializable {

	private long gpgId;
	private String souLibelle;
	private String gpgObjet;
	private String gpgStaCode;
	private String gpgActeurSaisie;
	private String fonLibelle;
	private String tymCode;
	private String tymLibelleCourt;
	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String gpgPartiePmePmi;
	private Date gpgDateDao;
	private String gpgCommentaire;
	private Integer gpgNumeroOrdre;
	private Date gpgDateSaisie;
	private long plgId;
	private short plgGesCode;
	private String minLibelle;
	private String minLibelleCourt;
	private String strCode;
	private String strLibelleCourt;
	private String strLibelleLong;

	public VPgpmId() {
	}

	public VPgpmId(long gpgId, String gpgStaCode, String tymCode, String tymLibelleCourt, String mopCode,
			String mopLibelleCourt, long plgId, short plgGesCode, String strCode, String strLibelleCourt) {
		this.gpgId = gpgId;
		this.gpgStaCode = gpgStaCode;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
	}

	public VPgpmId(long gpgId, String souLibelle, String gpgObjet, String gpgStaCode, String gpgActeurSaisie,
			String fonLibelle, String tymCode, String tymLibelleCourt, String mopCode, String mopLibelleCourt,
			String mopLibelleLong, String gpgPartiePmePmi, Date gpgDateDao, String gpgCommentaire,
			Integer gpgNumeroOrdre, Date gpgDateSaisie, long plgId, short plgGesCode, String minLibelle,
			String minLibelleCourt, String strCode, String strLibelleCourt, String strLibelleLong) {
		this.gpgId = gpgId;
		this.souLibelle = souLibelle;
		this.gpgObjet = gpgObjet;
		this.gpgStaCode = gpgStaCode;
		this.gpgActeurSaisie = gpgActeurSaisie;
		this.fonLibelle = fonLibelle;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.gpgPartiePmePmi = gpgPartiePmePmi;
		this.gpgDateDao = gpgDateDao;
		this.gpgCommentaire = gpgCommentaire;
		this.gpgNumeroOrdre = gpgNumeroOrdre;
		this.gpgDateSaisie = gpgDateSaisie;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
		this.minLibelle = minLibelle;
		this.minLibelleCourt = minLibelleCourt;
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
		this.strLibelleLong = strLibelleLong;
	}

	@Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getGpgId() {
		return this.gpgId;
	}

	public void setGpgId(long gpgId) {
		this.gpgId = gpgId;
	}

	@Column(name = "SOU_LIBELLE", length = 500)
	public String getSouLibelle() {
		return this.souLibelle;
	}

	public void setSouLibelle(String souLibelle) {
		this.souLibelle = souLibelle;
	}

	@Column(name = "GPG_OBJET", length = 1000)
	public String getGpgObjet() {
		return this.gpgObjet;
	}

	public void setGpgObjet(String gpgObjet) {
		this.gpgObjet = gpgObjet;
	}

	@Column(name = "GPG_STA_CODE", nullable = false, length = 3)
	public String getGpgStaCode() {
		return this.gpgStaCode;
	}

	public void setGpgStaCode(String gpgStaCode) {
		this.gpgStaCode = gpgStaCode;
	}

	@Column(name = "GPG_ACTEUR_SAISIE", length = 12)
	public String getGpgActeurSaisie() {
		return this.gpgActeurSaisie;
	}

	public void setGpgActeurSaisie(String gpgActeurSaisie) {
		this.gpgActeurSaisie = gpgActeurSaisie;
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

	@Column(name = "GPG_PARTIE_PME_PMI", length = 1)
	public String getGpgPartiePmePmi() {
		return this.gpgPartiePmePmi;
	}

	public void setGpgPartiePmePmi(String gpgPartiePmePmi) {
		this.gpgPartiePmePmi = gpgPartiePmePmi;
	}

	@Column(name = "GPG_DATE_DAO", length = 7)
	public Date getGpgDateDao() {
		return this.gpgDateDao;
	}

	public void setGpgDateDao(Date gpgDateDao) {
		this.gpgDateDao = gpgDateDao;
	}

	@Column(name = "GPG_COMMENTAIRE", length = 1000)
	public String getGpgCommentaire() {
		return this.gpgCommentaire;
	}

	public void setGpgCommentaire(String gpgCommentaire) {
		this.gpgCommentaire = gpgCommentaire;
	}

	@Column(name = "GPG_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getGpgNumeroOrdre() {
		return this.gpgNumeroOrdre;
	}

	public void setGpgNumeroOrdre(Integer gpgNumeroOrdre) {
		this.gpgNumeroOrdre = gpgNumeroOrdre;
	}

	@Column(name = "GPG_DATE_SAISIE", length = 7)
	public Date getGpgDateSaisie() {
		return this.gpgDateSaisie;
	}

	public void setGpgDateSaisie(Date gpgDateSaisie) {
		this.gpgDateSaisie = gpgDateSaisie;
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
		if (!(other instanceof VPgpmId))
			return false;
		VPgpmId castOther = (VPgpmId) other;

		return (this.getGpgId() == castOther.getGpgId())
				&& ((this.getSouLibelle() == castOther.getSouLibelle()) || (this.getSouLibelle() != null
						&& castOther.getSouLibelle() != null && this.getSouLibelle().equals(castOther.getSouLibelle())))
				&& ((this.getGpgObjet() == castOther.getGpgObjet()) || (this.getGpgObjet() != null
						&& castOther.getGpgObjet() != null && this.getGpgObjet().equals(castOther.getGpgObjet())))
				&& ((this.getGpgStaCode() == castOther.getGpgStaCode()) || (this.getGpgStaCode() != null
						&& castOther.getGpgStaCode() != null && this.getGpgStaCode().equals(castOther.getGpgStaCode())))
				&& ((this.getGpgActeurSaisie() == castOther.getGpgActeurSaisie())
						|| (this.getGpgActeurSaisie() != null && castOther.getGpgActeurSaisie() != null
								&& this.getGpgActeurSaisie().equals(castOther.getGpgActeurSaisie())))
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
				&& ((this.getGpgPartiePmePmi() == castOther.getGpgPartiePmePmi())
						|| (this.getGpgPartiePmePmi() != null && castOther.getGpgPartiePmePmi() != null
								&& this.getGpgPartiePmePmi().equals(castOther.getGpgPartiePmePmi())))
				&& ((this.getGpgDateDao() == castOther.getGpgDateDao()) || (this.getGpgDateDao() != null
						&& castOther.getGpgDateDao() != null && this.getGpgDateDao().equals(castOther.getGpgDateDao())))
				&& ((this.getGpgCommentaire() == castOther.getGpgCommentaire())
						|| (this.getGpgCommentaire() != null && castOther.getGpgCommentaire() != null
								&& this.getGpgCommentaire().equals(castOther.getGpgCommentaire())))
				&& ((this.getGpgNumeroOrdre() == castOther.getGpgNumeroOrdre())
						|| (this.getGpgNumeroOrdre() != null && castOther.getGpgNumeroOrdre() != null
								&& this.getGpgNumeroOrdre().equals(castOther.getGpgNumeroOrdre())))
				&& ((this.getGpgDateSaisie() == castOther.getGpgDateSaisie())
						|| (this.getGpgDateSaisie() != null && castOther.getGpgDateSaisie() != null
								&& this.getGpgDateSaisie().equals(castOther.getGpgDateSaisie())))
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

		result = 37 * result + (int) this.getGpgId();
		result = 37 * result + (getSouLibelle() == null ? 0 : this.getSouLibelle().hashCode());
		result = 37 * result + (getGpgObjet() == null ? 0 : this.getGpgObjet().hashCode());
		result = 37 * result + (getGpgStaCode() == null ? 0 : this.getGpgStaCode().hashCode());
		result = 37 * result + (getGpgActeurSaisie() == null ? 0 : this.getGpgActeurSaisie().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getTymCode() == null ? 0 : this.getTymCode().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getMopCode() == null ? 0 : this.getMopCode().hashCode());
		result = 37 * result + (getMopLibelleCourt() == null ? 0 : this.getMopLibelleCourt().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		result = 37 * result + (getGpgPartiePmePmi() == null ? 0 : this.getGpgPartiePmePmi().hashCode());
		result = 37 * result + (getGpgDateDao() == null ? 0 : this.getGpgDateDao().hashCode());
		result = 37 * result + (getGpgCommentaire() == null ? 0 : this.getGpgCommentaire().hashCode());
		result = 37 * result + (getGpgNumeroOrdre() == null ? 0 : this.getGpgNumeroOrdre().hashCode());
		result = 37 * result + (getGpgDateSaisie() == null ? 0 : this.getGpgDateSaisie().hashCode());
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
