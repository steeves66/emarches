package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPgpmFonctionId generated by hbm2java
 */
@Embeddable
public class VPgpmFonctionId implements java.io.Serializable {

	private long gpgId;
	private long gpgPlgId;
	private Long gpgAgpId;
	private String gpgTypePlan;
	private String gpgStaCode;
	private String gpgTymCode;
	private String gpgMopCode;
	private String gpgCode;
	private String gpgObjet;
	private Integer gpgNumeroOrdre;
	private String gpgPartiePmePmi;
	private String gpgCommentaire;
	private String gpgSourceFin;
	private Date gpgDateDao;
	private String gpgActeurSaisie;
	private String gpgFonCodPf;
	private String gpgFonCodDmp;
	private String gpgStatutRetour;
	private Date gpgDateSaisie;
	private String gpgStrCode;
	private String gpgLibFin;
	private String tymLibelleCourt;
	private String tymTymCode;
	private String mopLibelleLong;
	private String plgFonCod;
	private String fonLibelle;

	public VPgpmFonctionId() {
	}

	public VPgpmFonctionId(long gpgId, long gpgPlgId, String gpgTypePlan, String gpgStaCode, String gpgTymCode,
			String gpgMopCode, String tymLibelleCourt, String plgFonCod) {
		this.gpgId = gpgId;
		this.gpgPlgId = gpgPlgId;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgStaCode = gpgStaCode;
		this.gpgTymCode = gpgTymCode;
		this.gpgMopCode = gpgMopCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.plgFonCod = plgFonCod;
	}

	public VPgpmFonctionId(long gpgId, long gpgPlgId, Long gpgAgpId, String gpgTypePlan, String gpgStaCode,
			String gpgTymCode, String gpgMopCode, String gpgCode, String gpgObjet, Integer gpgNumeroOrdre,
			String gpgPartiePmePmi, String gpgCommentaire, String gpgSourceFin, Date gpgDateDao, String gpgActeurSaisie,
			String gpgFonCodPf, String gpgFonCodDmp, String gpgStatutRetour, Date gpgDateSaisie, String gpgStrCode,
			String gpgLibFin, String tymLibelleCourt, String tymTymCode, String mopLibelleLong, String plgFonCod,
			String fonLibelle) {
		this.gpgId = gpgId;
		this.gpgPlgId = gpgPlgId;
		this.gpgAgpId = gpgAgpId;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgStaCode = gpgStaCode;
		this.gpgTymCode = gpgTymCode;
		this.gpgMopCode = gpgMopCode;
		this.gpgCode = gpgCode;
		this.gpgObjet = gpgObjet;
		this.gpgNumeroOrdre = gpgNumeroOrdre;
		this.gpgPartiePmePmi = gpgPartiePmePmi;
		this.gpgCommentaire = gpgCommentaire;
		this.gpgSourceFin = gpgSourceFin;
		this.gpgDateDao = gpgDateDao;
		this.gpgActeurSaisie = gpgActeurSaisie;
		this.gpgFonCodPf = gpgFonCodPf;
		this.gpgFonCodDmp = gpgFonCodDmp;
		this.gpgStatutRetour = gpgStatutRetour;
		this.gpgDateSaisie = gpgDateSaisie;
		this.gpgStrCode = gpgStrCode;
		this.gpgLibFin = gpgLibFin;
		this.tymLibelleCourt = tymLibelleCourt;
		this.tymTymCode = tymTymCode;
		this.mopLibelleLong = mopLibelleLong;
		this.plgFonCod = plgFonCod;
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getGpgId() {
		return this.gpgId;
	}

	public void setGpgId(long gpgId) {
		this.gpgId = gpgId;
	}

	@Column(name = "GPG_PLG_ID", nullable = false, precision = 10, scale = 0)
	public long getGpgPlgId() {
		return this.gpgPlgId;
	}

	public void setGpgPlgId(long gpgPlgId) {
		this.gpgPlgId = gpgPlgId;
	}

	@Column(name = "GPG_AGP_ID", precision = 10, scale = 0)
	public Long getGpgAgpId() {
		return this.gpgAgpId;
	}

	public void setGpgAgpId(Long gpgAgpId) {
		this.gpgAgpId = gpgAgpId;
	}

	@Column(name = "GPG_TYPE_PLAN", nullable = false, length = 3)
	public String getGpgTypePlan() {
		return this.gpgTypePlan;
	}

	public void setGpgTypePlan(String gpgTypePlan) {
		this.gpgTypePlan = gpgTypePlan;
	}

	@Column(name = "GPG_STA_CODE", nullable = false, length = 3)
	public String getGpgStaCode() {
		return this.gpgStaCode;
	}

	public void setGpgStaCode(String gpgStaCode) {
		this.gpgStaCode = gpgStaCode;
	}

	@Column(name = "GPG_TYM_CODE", nullable = false, length = 3)
	public String getGpgTymCode() {
		return this.gpgTymCode;
	}

	public void setGpgTymCode(String gpgTymCode) {
		this.gpgTymCode = gpgTymCode;
	}

	@Column(name = "GPG_MOP_CODE", nullable = false, length = 3)
	public String getGpgMopCode() {
		return this.gpgMopCode;
	}

	public void setGpgMopCode(String gpgMopCode) {
		this.gpgMopCode = gpgMopCode;
	}

	@Column(name = "GPG_CODE", length = 50)
	public String getGpgCode() {
		return this.gpgCode;
	}

	public void setGpgCode(String gpgCode) {
		this.gpgCode = gpgCode;
	}

	@Column(name = "GPG_OBJET", length = 1000)
	public String getGpgObjet() {
		return this.gpgObjet;
	}

	public void setGpgObjet(String gpgObjet) {
		this.gpgObjet = gpgObjet;
	}

	@Column(name = "GPG_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getGpgNumeroOrdre() {
		return this.gpgNumeroOrdre;
	}

	public void setGpgNumeroOrdre(Integer gpgNumeroOrdre) {
		this.gpgNumeroOrdre = gpgNumeroOrdre;
	}

	@Column(name = "GPG_PARTIE_PME_PMI", length = 1)
	public String getGpgPartiePmePmi() {
		return this.gpgPartiePmePmi;
	}

	public void setGpgPartiePmePmi(String gpgPartiePmePmi) {
		this.gpgPartiePmePmi = gpgPartiePmePmi;
	}

	@Column(name = "GPG_COMMENTAIRE", length = 1000)
	public String getGpgCommentaire() {
		return this.gpgCommentaire;
	}

	public void setGpgCommentaire(String gpgCommentaire) {
		this.gpgCommentaire = gpgCommentaire;
	}

	@Column(name = "GPG_SOURCE_FIN", length = 1000)
	public String getGpgSourceFin() {
		return this.gpgSourceFin;
	}

	public void setGpgSourceFin(String gpgSourceFin) {
		this.gpgSourceFin = gpgSourceFin;
	}

	@Column(name = "GPG_DATE_DAO", length = 7)
	public Date getGpgDateDao() {
		return this.gpgDateDao;
	}

	public void setGpgDateDao(Date gpgDateDao) {
		this.gpgDateDao = gpgDateDao;
	}

	@Column(name = "GPG_ACTEUR_SAISIE", length = 12)
	public String getGpgActeurSaisie() {
		return this.gpgActeurSaisie;
	}

	public void setGpgActeurSaisie(String gpgActeurSaisie) {
		this.gpgActeurSaisie = gpgActeurSaisie;
	}

	@Column(name = "GPG_FON_COD_PF", length = 20)
	public String getGpgFonCodPf() {
		return this.gpgFonCodPf;
	}

	public void setGpgFonCodPf(String gpgFonCodPf) {
		this.gpgFonCodPf = gpgFonCodPf;
	}

	@Column(name = "GPG_FON_COD_DMP", length = 20)
	public String getGpgFonCodDmp() {
		return this.gpgFonCodDmp;
	}

	public void setGpgFonCodDmp(String gpgFonCodDmp) {
		this.gpgFonCodDmp = gpgFonCodDmp;
	}

	@Column(name = "GPG_STATUT_RETOUR", length = 4)
	public String getGpgStatutRetour() {
		return this.gpgStatutRetour;
	}

	public void setGpgStatutRetour(String gpgStatutRetour) {
		this.gpgStatutRetour = gpgStatutRetour;
	}

	@Column(name = "GPG_DATE_SAISIE", length = 7)
	public Date getGpgDateSaisie() {
		return this.gpgDateSaisie;
	}

	public void setGpgDateSaisie(Date gpgDateSaisie) {
		this.gpgDateSaisie = gpgDateSaisie;
	}

	@Column(name = "GPG_STR_CODE", length = 20)
	public String getGpgStrCode() {
		return this.gpgStrCode;
	}

	public void setGpgStrCode(String gpgStrCode) {
		this.gpgStrCode = gpgStrCode;
	}

	@Column(name = "GPG_LIB_FIN", length = 200)
	public String getGpgLibFin() {
		return this.gpgLibFin;
	}

	public void setGpgLibFin(String gpgLibFin) {
		this.gpgLibFin = gpgLibFin;
	}

	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}

	@Column(name = "TYM_TYM_CODE", length = 3)
	public String getTymTymCode() {
		return this.tymTymCode;
	}

	public void setTymTymCode(String tymTymCode) {
		this.tymTymCode = tymTymCode;
	}

	@Column(name = "MOP_LIBELLE_LONG", length = 1000)
	public String getMopLibelleLong() {
		return this.mopLibelleLong;
	}

	public void setMopLibelleLong(String mopLibelleLong) {
		this.mopLibelleLong = mopLibelleLong;
	}

	@Column(name = "PLG_FON_COD", nullable = false, length = 12)
	public String getPlgFonCod() {
		return this.plgFonCod;
	}

	public void setPlgFonCod(String plgFonCod) {
		this.plgFonCod = plgFonCod;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VPgpmFonctionId))
			return false;
		VPgpmFonctionId castOther = (VPgpmFonctionId) other;

		return (this.getGpgId() == castOther.getGpgId()) && (this.getGpgPlgId() == castOther.getGpgPlgId())
				&& ((this.getGpgAgpId() == castOther.getGpgAgpId()) || (this.getGpgAgpId() != null
						&& castOther.getGpgAgpId() != null && this.getGpgAgpId().equals(castOther.getGpgAgpId())))
				&& ((this.getGpgTypePlan() == castOther.getGpgTypePlan())
						|| (this.getGpgTypePlan() != null && castOther.getGpgTypePlan() != null
								&& this.getGpgTypePlan().equals(castOther.getGpgTypePlan())))
				&& ((this.getGpgStaCode() == castOther.getGpgStaCode()) || (this.getGpgStaCode() != null
						&& castOther.getGpgStaCode() != null && this.getGpgStaCode().equals(castOther.getGpgStaCode())))
				&& ((this.getGpgTymCode() == castOther.getGpgTymCode()) || (this.getGpgTymCode() != null
						&& castOther.getGpgTymCode() != null && this.getGpgTymCode().equals(castOther.getGpgTymCode())))
				&& ((this.getGpgMopCode() == castOther.getGpgMopCode()) || (this.getGpgMopCode() != null
						&& castOther.getGpgMopCode() != null && this.getGpgMopCode().equals(castOther.getGpgMopCode())))
				&& ((this.getGpgCode() == castOther.getGpgCode()) || (this.getGpgCode() != null
						&& castOther.getGpgCode() != null && this.getGpgCode().equals(castOther.getGpgCode())))
				&& ((this.getGpgObjet() == castOther.getGpgObjet()) || (this.getGpgObjet() != null
						&& castOther.getGpgObjet() != null && this.getGpgObjet().equals(castOther.getGpgObjet())))
				&& ((this.getGpgNumeroOrdre() == castOther.getGpgNumeroOrdre())
						|| (this.getGpgNumeroOrdre() != null && castOther.getGpgNumeroOrdre() != null
								&& this.getGpgNumeroOrdre().equals(castOther.getGpgNumeroOrdre())))
				&& ((this.getGpgPartiePmePmi() == castOther.getGpgPartiePmePmi())
						|| (this.getGpgPartiePmePmi() != null && castOther.getGpgPartiePmePmi() != null
								&& this.getGpgPartiePmePmi().equals(castOther.getGpgPartiePmePmi())))
				&& ((this.getGpgCommentaire() == castOther.getGpgCommentaire())
						|| (this.getGpgCommentaire() != null && castOther.getGpgCommentaire() != null
								&& this.getGpgCommentaire().equals(castOther.getGpgCommentaire())))
				&& ((this.getGpgSourceFin() == castOther.getGpgSourceFin())
						|| (this.getGpgSourceFin() != null && castOther.getGpgSourceFin() != null
								&& this.getGpgSourceFin().equals(castOther.getGpgSourceFin())))
				&& ((this.getGpgDateDao() == castOther.getGpgDateDao()) || (this.getGpgDateDao() != null
						&& castOther.getGpgDateDao() != null && this.getGpgDateDao().equals(castOther.getGpgDateDao())))
				&& ((this.getGpgActeurSaisie() == castOther.getGpgActeurSaisie())
						|| (this.getGpgActeurSaisie() != null && castOther.getGpgActeurSaisie() != null
								&& this.getGpgActeurSaisie().equals(castOther.getGpgActeurSaisie())))
				&& ((this.getGpgFonCodPf() == castOther.getGpgFonCodPf())
						|| (this.getGpgFonCodPf() != null && castOther.getGpgFonCodPf() != null
								&& this.getGpgFonCodPf().equals(castOther.getGpgFonCodPf())))
				&& ((this.getGpgFonCodDmp() == castOther.getGpgFonCodDmp())
						|| (this.getGpgFonCodDmp() != null && castOther.getGpgFonCodDmp() != null
								&& this.getGpgFonCodDmp().equals(castOther.getGpgFonCodDmp())))
				&& ((this.getGpgStatutRetour() == castOther.getGpgStatutRetour())
						|| (this.getGpgStatutRetour() != null && castOther.getGpgStatutRetour() != null
								&& this.getGpgStatutRetour().equals(castOther.getGpgStatutRetour())))
				&& ((this.getGpgDateSaisie() == castOther.getGpgDateSaisie())
						|| (this.getGpgDateSaisie() != null && castOther.getGpgDateSaisie() != null
								&& this.getGpgDateSaisie().equals(castOther.getGpgDateSaisie())))
				&& ((this.getGpgStrCode() == castOther.getGpgStrCode()) || (this.getGpgStrCode() != null
						&& castOther.getGpgStrCode() != null && this.getGpgStrCode().equals(castOther.getGpgStrCode())))
				&& ((this.getGpgLibFin() == castOther.getGpgLibFin()) || (this.getGpgLibFin() != null
						&& castOther.getGpgLibFin() != null && this.getGpgLibFin().equals(castOther.getGpgLibFin())))
				&& ((this.getTymLibelleCourt() == castOther.getTymLibelleCourt())
						|| (this.getTymLibelleCourt() != null && castOther.getTymLibelleCourt() != null
								&& this.getTymLibelleCourt().equals(castOther.getTymLibelleCourt())))
				&& ((this.getTymTymCode() == castOther.getTymTymCode()) || (this.getTymTymCode() != null
						&& castOther.getTymTymCode() != null && this.getTymTymCode().equals(castOther.getTymTymCode())))
				&& ((this.getMopLibelleLong() == castOther.getMopLibelleLong())
						|| (this.getMopLibelleLong() != null && castOther.getMopLibelleLong() != null
								&& this.getMopLibelleLong().equals(castOther.getMopLibelleLong())))
				&& ((this.getPlgFonCod() == castOther.getPlgFonCod()) || (this.getPlgFonCod() != null
						&& castOther.getPlgFonCod() != null && this.getPlgFonCod().equals(castOther.getPlgFonCod())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle())
						|| (this.getFonLibelle() != null && castOther.getFonLibelle() != null
								&& this.getFonLibelle().equals(castOther.getFonLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getGpgId();
		result = 37 * result + (int) this.getGpgPlgId();
		result = 37 * result + (getGpgAgpId() == null ? 0 : this.getGpgAgpId().hashCode());
		result = 37 * result + (getGpgTypePlan() == null ? 0 : this.getGpgTypePlan().hashCode());
		result = 37 * result + (getGpgStaCode() == null ? 0 : this.getGpgStaCode().hashCode());
		result = 37 * result + (getGpgTymCode() == null ? 0 : this.getGpgTymCode().hashCode());
		result = 37 * result + (getGpgMopCode() == null ? 0 : this.getGpgMopCode().hashCode());
		result = 37 * result + (getGpgCode() == null ? 0 : this.getGpgCode().hashCode());
		result = 37 * result + (getGpgObjet() == null ? 0 : this.getGpgObjet().hashCode());
		result = 37 * result + (getGpgNumeroOrdre() == null ? 0 : this.getGpgNumeroOrdre().hashCode());
		result = 37 * result + (getGpgPartiePmePmi() == null ? 0 : this.getGpgPartiePmePmi().hashCode());
		result = 37 * result + (getGpgCommentaire() == null ? 0 : this.getGpgCommentaire().hashCode());
		result = 37 * result + (getGpgSourceFin() == null ? 0 : this.getGpgSourceFin().hashCode());
		result = 37 * result + (getGpgDateDao() == null ? 0 : this.getGpgDateDao().hashCode());
		result = 37 * result + (getGpgActeurSaisie() == null ? 0 : this.getGpgActeurSaisie().hashCode());
		result = 37 * result + (getGpgFonCodPf() == null ? 0 : this.getGpgFonCodPf().hashCode());
		result = 37 * result + (getGpgFonCodDmp() == null ? 0 : this.getGpgFonCodDmp().hashCode());
		result = 37 * result + (getGpgStatutRetour() == null ? 0 : this.getGpgStatutRetour().hashCode());
		result = 37 * result + (getGpgDateSaisie() == null ? 0 : this.getGpgDateSaisie().hashCode());
		result = 37 * result + (getGpgStrCode() == null ? 0 : this.getGpgStrCode().hashCode());
		result = 37 * result + (getGpgLibFin() == null ? 0 : this.getGpgLibFin().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getTymTymCode() == null ? 0 : this.getTymTymCode().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		result = 37 * result + (getPlgFonCod() == null ? 0 : this.getPlgFonCod().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		return result;
	}

}
