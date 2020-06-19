package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPgpmlisteId generated by hbm2java
 */
@Embeddable
public class VPgpmlisteId implements java.io.Serializable {

	private String fipTypeFinance;
	private String gpgLibFin;
	private long gpgId;
	private Date gpgDteModif;
	private String gpgObjet;
	private String gpgStaCode;
	private String gpgTypePlan;
	private String gpgActeurSaisie;
	private Date gpgDateDao;
	private String gpgFonCodPf;
	private String gpgFonCodDmp;
	private String gpgStatutRetour;
	private String tymCode;
	private String tymLibelleCourt;
	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String gpgRecherche;
	private Date gpgDateValAc;
	private Date gpgDateValCpmp;
	private Date gpgDateValDmp;
	private String ac;
	private Long gpgAgpId;
	private String gpgCommentaire;
	private String gpgPartiePmePmi;
	private String gpgStrCode;
	private String tstCode;
	private long plgId;
	private short plgGesCode;

	public VPgpmlisteId() {
	}

	public VPgpmlisteId(long gpgId, String gpgStaCode, String gpgTypePlan, String tymCode, String tymLibelleCourt,
			String mopCode, String mopLibelleCourt, long plgId, short plgGesCode) {
		this.gpgId = gpgId;
		this.gpgStaCode = gpgStaCode;
		this.gpgTypePlan = gpgTypePlan;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
	}

	public VPgpmlisteId(String fipTypeFinance, String gpgLibFin, long gpgId, Date gpgDteModif, String gpgObjet,
			String gpgStaCode, String gpgTypePlan, String gpgActeurSaisie, Date gpgDateDao, String gpgFonCodPf,
			String gpgFonCodDmp, String gpgStatutRetour, String tymCode, String tymLibelleCourt, String mopCode,
			String mopLibelleCourt, String mopLibelleLong, String gpgRecherche, Date gpgDateValAc, Date gpgDateValCpmp,
			Date gpgDateValDmp, String ac, Long gpgAgpId, String gpgCommentaire, String gpgPartiePmePmi,
			String gpgStrCode, String tstCode, long plgId, short plgGesCode) {
		this.fipTypeFinance = fipTypeFinance;
		this.gpgLibFin = gpgLibFin;
		this.gpgId = gpgId;
		this.gpgDteModif = gpgDteModif;
		this.gpgObjet = gpgObjet;
		this.gpgStaCode = gpgStaCode;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgActeurSaisie = gpgActeurSaisie;
		this.gpgDateDao = gpgDateDao;
		this.gpgFonCodPf = gpgFonCodPf;
		this.gpgFonCodDmp = gpgFonCodDmp;
		this.gpgStatutRetour = gpgStatutRetour;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.gpgRecherche = gpgRecherche;
		this.gpgDateValAc = gpgDateValAc;
		this.gpgDateValCpmp = gpgDateValCpmp;
		this.gpgDateValDmp = gpgDateValDmp;
		this.ac = ac;
		this.gpgAgpId = gpgAgpId;
		this.gpgCommentaire = gpgCommentaire;
		this.gpgPartiePmePmi = gpgPartiePmePmi;
		this.gpgStrCode = gpgStrCode;
		this.tstCode = tstCode;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
	}

	@Column(name = "FIP_TYPE_FINANCE", length = 20)
	public String getFipTypeFinance() {
		return this.fipTypeFinance;
	}

	public void setFipTypeFinance(String fipTypeFinance) {
		this.fipTypeFinance = fipTypeFinance;
	}

	@Column(name = "GPG_LIB_FIN", length = 200)
	public String getGpgLibFin() {
		return this.gpgLibFin;
	}

	public void setGpgLibFin(String gpgLibFin) {
		this.gpgLibFin = gpgLibFin;
	}

	@Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getGpgId() {
		return this.gpgId;
	}

	public void setGpgId(long gpgId) {
		this.gpgId = gpgId;
	}

	@Column(name = "GPG_DTE_MODIF", length = 7)
	public Date getGpgDteModif() {
		return this.gpgDteModif;
	}

	public void setGpgDteModif(Date gpgDteModif) {
		this.gpgDteModif = gpgDteModif;
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

	@Column(name = "GPG_TYPE_PLAN", nullable = false, length = 3)
	public String getGpgTypePlan() {
		return this.gpgTypePlan;
	}

	public void setGpgTypePlan(String gpgTypePlan) {
		this.gpgTypePlan = gpgTypePlan;
	}

	@Column(name = "GPG_ACTEUR_SAISIE", length = 12)
	public String getGpgActeurSaisie() {
		return this.gpgActeurSaisie;
	}

	public void setGpgActeurSaisie(String gpgActeurSaisie) {
		this.gpgActeurSaisie = gpgActeurSaisie;
	}

	@Column(name = "GPG_DATE_DAO", length = 7)
	public Date getGpgDateDao() {
		return this.gpgDateDao;
	}

	public void setGpgDateDao(Date gpgDateDao) {
		this.gpgDateDao = gpgDateDao;
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

	@Column(name = "GPG_RECHERCHE", length = 4000)
	public String getGpgRecherche() {
		return this.gpgRecherche;
	}

	public void setGpgRecherche(String gpgRecherche) {
		this.gpgRecherche = gpgRecherche;
	}

	@Column(name = "GPG_DATE_VAL_AC", length = 7)
	public Date getGpgDateValAc() {
		return this.gpgDateValAc;
	}

	public void setGpgDateValAc(Date gpgDateValAc) {
		this.gpgDateValAc = gpgDateValAc;
	}

	@Column(name = "GPG_DATE_VAL_CPMP", length = 7)
	public Date getGpgDateValCpmp() {
		return this.gpgDateValCpmp;
	}

	public void setGpgDateValCpmp(Date gpgDateValCpmp) {
		this.gpgDateValCpmp = gpgDateValCpmp;
	}

	@Column(name = "GPG_DATE_VAL_DMP", length = 7)
	public Date getGpgDateValDmp() {
		return this.gpgDateValDmp;
	}

	public void setGpgDateValDmp(Date gpgDateValDmp) {
		this.gpgDateValDmp = gpgDateValDmp;
	}

	@Column(name = "AC", length = 515)
	public String getAc() {
		return this.ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	@Column(name = "GPG_AGP_ID", precision = 10, scale = 0)
	public Long getGpgAgpId() {
		return this.gpgAgpId;
	}

	public void setGpgAgpId(Long gpgAgpId) {
		this.gpgAgpId = gpgAgpId;
	}

	@Column(name = "GPG_COMMENTAIRE", length = 1000)
	public String getGpgCommentaire() {
		return this.gpgCommentaire;
	}

	public void setGpgCommentaire(String gpgCommentaire) {
		this.gpgCommentaire = gpgCommentaire;
	}

	@Column(name = "GPG_PARTIE_PME_PMI", length = 1)
	public String getGpgPartiePmePmi() {
		return this.gpgPartiePmePmi;
	}

	public void setGpgPartiePmePmi(String gpgPartiePmePmi) {
		this.gpgPartiePmePmi = gpgPartiePmePmi;
	}

	@Column(name = "GPG_STR_CODE", length = 20)
	public String getGpgStrCode() {
		return this.gpgStrCode;
	}

	public void setGpgStrCode(String gpgStrCode) {
		this.gpgStrCode = gpgStrCode;
	}

	@Column(name = "TST_CODE", length = 3)
	public String getTstCode() {
		return this.tstCode;
	}

	public void setTstCode(String tstCode) {
		this.tstCode = tstCode;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VPgpmlisteId))
			return false;
		VPgpmlisteId castOther = (VPgpmlisteId) other;

		return ((this.getFipTypeFinance() == castOther.getFipTypeFinance())
				|| (this.getFipTypeFinance() != null && castOther.getFipTypeFinance() != null
						&& this.getFipTypeFinance().equals(castOther.getFipTypeFinance())))
				&& ((this.getGpgLibFin() == castOther.getGpgLibFin()) || (this.getGpgLibFin() != null
						&& castOther.getGpgLibFin() != null && this.getGpgLibFin().equals(castOther.getGpgLibFin())))
				&& (this.getGpgId() == castOther.getGpgId())
				&& ((this.getGpgDteModif() == castOther.getGpgDteModif())
						|| (this.getGpgDteModif() != null && castOther.getGpgDteModif() != null
								&& this.getGpgDteModif().equals(castOther.getGpgDteModif())))
				&& ((this.getGpgObjet() == castOther.getGpgObjet()) || (this.getGpgObjet() != null
						&& castOther.getGpgObjet() != null && this.getGpgObjet().equals(castOther.getGpgObjet())))
				&& ((this.getGpgStaCode() == castOther.getGpgStaCode()) || (this.getGpgStaCode() != null
						&& castOther.getGpgStaCode() != null && this.getGpgStaCode().equals(castOther.getGpgStaCode())))
				&& ((this.getGpgTypePlan() == castOther.getGpgTypePlan())
						|| (this.getGpgTypePlan() != null && castOther.getGpgTypePlan() != null
								&& this.getGpgTypePlan().equals(castOther.getGpgTypePlan())))
				&& ((this.getGpgActeurSaisie() == castOther.getGpgActeurSaisie())
						|| (this.getGpgActeurSaisie() != null && castOther.getGpgActeurSaisie() != null
								&& this.getGpgActeurSaisie().equals(castOther.getGpgActeurSaisie())))
				&& ((this.getGpgDateDao() == castOther.getGpgDateDao()) || (this.getGpgDateDao() != null
						&& castOther.getGpgDateDao() != null && this.getGpgDateDao().equals(castOther.getGpgDateDao())))
				&& ((this.getGpgFonCodPf() == castOther.getGpgFonCodPf())
						|| (this.getGpgFonCodPf() != null && castOther.getGpgFonCodPf() != null
								&& this.getGpgFonCodPf().equals(castOther.getGpgFonCodPf())))
				&& ((this.getGpgFonCodDmp() == castOther.getGpgFonCodDmp())
						|| (this.getGpgFonCodDmp() != null && castOther.getGpgFonCodDmp() != null
								&& this.getGpgFonCodDmp().equals(castOther.getGpgFonCodDmp())))
				&& ((this.getGpgStatutRetour() == castOther.getGpgStatutRetour())
						|| (this.getGpgStatutRetour() != null && castOther.getGpgStatutRetour() != null
								&& this.getGpgStatutRetour().equals(castOther.getGpgStatutRetour())))
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
				&& ((this.getGpgRecherche() == castOther.getGpgRecherche())
						|| (this.getGpgRecherche() != null && castOther.getGpgRecherche() != null
								&& this.getGpgRecherche().equals(castOther.getGpgRecherche())))
				&& ((this.getGpgDateValAc() == castOther.getGpgDateValAc())
						|| (this.getGpgDateValAc() != null && castOther.getGpgDateValAc() != null
								&& this.getGpgDateValAc().equals(castOther.getGpgDateValAc())))
				&& ((this.getGpgDateValCpmp() == castOther.getGpgDateValCpmp())
						|| (this.getGpgDateValCpmp() != null && castOther.getGpgDateValCpmp() != null
								&& this.getGpgDateValCpmp().equals(castOther.getGpgDateValCpmp())))
				&& ((this.getGpgDateValDmp() == castOther.getGpgDateValDmp())
						|| (this.getGpgDateValDmp() != null && castOther.getGpgDateValDmp() != null
								&& this.getGpgDateValDmp().equals(castOther.getGpgDateValDmp())))
				&& ((this.getAc() == castOther.getAc()) || (this.getAc() != null && castOther.getAc() != null
						&& this.getAc().equals(castOther.getAc())))
				&& ((this.getGpgAgpId() == castOther.getGpgAgpId()) || (this.getGpgAgpId() != null
						&& castOther.getGpgAgpId() != null && this.getGpgAgpId().equals(castOther.getGpgAgpId())))
				&& ((this.getGpgCommentaire() == castOther.getGpgCommentaire())
						|| (this.getGpgCommentaire() != null && castOther.getGpgCommentaire() != null
								&& this.getGpgCommentaire().equals(castOther.getGpgCommentaire())))
				&& ((this.getGpgPartiePmePmi() == castOther.getGpgPartiePmePmi())
						|| (this.getGpgPartiePmePmi() != null && castOther.getGpgPartiePmePmi() != null
								&& this.getGpgPartiePmePmi().equals(castOther.getGpgPartiePmePmi())))
				&& ((this.getGpgStrCode() == castOther.getGpgStrCode()) || (this.getGpgStrCode() != null
						&& castOther.getGpgStrCode() != null && this.getGpgStrCode().equals(castOther.getGpgStrCode())))
				&& ((this.getTstCode() == castOther.getTstCode()) || (this.getTstCode() != null
						&& castOther.getTstCode() != null && this.getTstCode().equals(castOther.getTstCode())))
				&& (this.getPlgId() == castOther.getPlgId()) && (this.getPlgGesCode() == castOther.getPlgGesCode());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getFipTypeFinance() == null ? 0 : this.getFipTypeFinance().hashCode());
		result = 37 * result + (getGpgLibFin() == null ? 0 : this.getGpgLibFin().hashCode());
		result = 37 * result + (int) this.getGpgId();
		result = 37 * result + (getGpgDteModif() == null ? 0 : this.getGpgDteModif().hashCode());
		result = 37 * result + (getGpgObjet() == null ? 0 : this.getGpgObjet().hashCode());
		result = 37 * result + (getGpgStaCode() == null ? 0 : this.getGpgStaCode().hashCode());
		result = 37 * result + (getGpgTypePlan() == null ? 0 : this.getGpgTypePlan().hashCode());
		result = 37 * result + (getGpgActeurSaisie() == null ? 0 : this.getGpgActeurSaisie().hashCode());
		result = 37 * result + (getGpgDateDao() == null ? 0 : this.getGpgDateDao().hashCode());
		result = 37 * result + (getGpgFonCodPf() == null ? 0 : this.getGpgFonCodPf().hashCode());
		result = 37 * result + (getGpgFonCodDmp() == null ? 0 : this.getGpgFonCodDmp().hashCode());
		result = 37 * result + (getGpgStatutRetour() == null ? 0 : this.getGpgStatutRetour().hashCode());
		result = 37 * result + (getTymCode() == null ? 0 : this.getTymCode().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getMopCode() == null ? 0 : this.getMopCode().hashCode());
		result = 37 * result + (getMopLibelleCourt() == null ? 0 : this.getMopLibelleCourt().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		result = 37 * result + (getGpgRecherche() == null ? 0 : this.getGpgRecherche().hashCode());
		result = 37 * result + (getGpgDateValAc() == null ? 0 : this.getGpgDateValAc().hashCode());
		result = 37 * result + (getGpgDateValCpmp() == null ? 0 : this.getGpgDateValCpmp().hashCode());
		result = 37 * result + (getGpgDateValDmp() == null ? 0 : this.getGpgDateValDmp().hashCode());
		result = 37 * result + (getAc() == null ? 0 : this.getAc().hashCode());
		result = 37 * result + (getGpgAgpId() == null ? 0 : this.getGpgAgpId().hashCode());
		result = 37 * result + (getGpgCommentaire() == null ? 0 : this.getGpgCommentaire().hashCode());
		result = 37 * result + (getGpgPartiePmePmi() == null ? 0 : this.getGpgPartiePmePmi().hashCode());
		result = 37 * result + (getGpgStrCode() == null ? 0 : this.getGpgStrCode().hashCode());
		result = 37 * result + (getTstCode() == null ? 0 : this.getTstCode().hashCode());
		result = 37 * result + (int) this.getPlgId();
		result = 37 * result + this.getPlgGesCode();
		return result;
	}

}
