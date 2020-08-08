package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VUpdatePgpmId generated by hbm2java
 */
@Embeddable
public class VUpdatePgpmId implements java.io.Serializable {

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
	private String gpgStatutRetour;
	private Date gpgDateSaisie;
	private String gpgStrCode;
	private Date gpgDateValAc;
	private Date gpgDateValCpmp;
	private Date gpgDateValDmp;
	private String gpgLibFin;
	private Date gpgDteModif;
	private String gpgFonCodPf;
	private String gpgFonCodDmp;
	private String gpgRecherche;
	private Long fipId;
	private String fipDevCode;
	private String fipBaiCode;
	private String fipSouCode;
	private Long fipGpgId;
	private BigDecimal fipMontantCfa;
	private BigDecimal fipMontantDevise;
	private String fipCommentaire;
	private String fipTypeFinance;
	private BigDecimal fipTresor;
	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String tymCode;
	private String tymLibelleCourt;
	private String tymLibelleLong;
	private String tymTymCode;
	private String tymGroupe;

	public VUpdatePgpmId() {
	}

	public VUpdatePgpmId(long gpgId, long gpgPlgId, String gpgTypePlan, String gpgStaCode, String gpgTymCode,
			String gpgMopCode, String mopCode, String mopLibelleCourt, String tymCode, String tymLibelleCourt) {
		this.gpgId = gpgId;
		this.gpgPlgId = gpgPlgId;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgStaCode = gpgStaCode;
		this.gpgTymCode = gpgTymCode;
		this.gpgMopCode = gpgMopCode;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
	}

	public VUpdatePgpmId(long gpgId, long gpgPlgId, Long gpgAgpId, String gpgTypePlan, String gpgStaCode,
			String gpgTymCode, String gpgMopCode, String gpgCode, String gpgObjet, Integer gpgNumeroOrdre,
			String gpgPartiePmePmi, String gpgCommentaire, String gpgSourceFin, Date gpgDateDao, String gpgActeurSaisie,
			String gpgStatutRetour, Date gpgDateSaisie, String gpgStrCode, Date gpgDateValAc, Date gpgDateValCpmp,
			Date gpgDateValDmp, String gpgLibFin, Date gpgDteModif, String gpgFonCodPf, String gpgFonCodDmp,
			String gpgRecherche, Long fipId, String fipDevCode, String fipBaiCode, String fipSouCode, Long fipGpgId,
			BigDecimal fipMontantCfa, BigDecimal fipMontantDevise, String fipCommentaire, String fipTypeFinance,
			BigDecimal fipTresor, String mopCode, String mopLibelleCourt, String mopLibelleLong, String tymCode,
			String tymLibelleCourt, String tymLibelleLong, String tymTymCode, String tymGroupe) {
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
		this.gpgStatutRetour = gpgStatutRetour;
		this.gpgDateSaisie = gpgDateSaisie;
		this.gpgStrCode = gpgStrCode;
		this.gpgDateValAc = gpgDateValAc;
		this.gpgDateValCpmp = gpgDateValCpmp;
		this.gpgDateValDmp = gpgDateValDmp;
		this.gpgLibFin = gpgLibFin;
		this.gpgDteModif = gpgDteModif;
		this.gpgFonCodPf = gpgFonCodPf;
		this.gpgFonCodDmp = gpgFonCodDmp;
		this.gpgRecherche = gpgRecherche;
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
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.tymLibelleLong = tymLibelleLong;
		this.tymTymCode = tymTymCode;
		this.tymGroupe = tymGroupe;
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

	@Column(name = "GPG_LIB_FIN", length = 200)
	public String getGpgLibFin() {
		return this.gpgLibFin;
	}

	public void setGpgLibFin(String gpgLibFin) {
		this.gpgLibFin = gpgLibFin;
	}

	@Column(name = "GPG_DTE_MODIF", length = 7)
	public Date getGpgDteModif() {
		return this.gpgDteModif;
	}

	public void setGpgDteModif(Date gpgDteModif) {
		this.gpgDteModif = gpgDteModif;
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

	@Column(name = "GPG_RECHERCHE", length = 4000)
	public String getGpgRecherche() {
		return this.gpgRecherche;
	}

	public void setGpgRecherche(String gpgRecherche) {
		this.gpgRecherche = gpgRecherche;
	}

	@Column(name = "FIP_ID", precision = 10, scale = 0)
	public Long getFipId() {
		return this.fipId;
	}

	public void setFipId(Long fipId) {
		this.fipId = fipId;
	}

	@Column(name = "FIP_DEV_CODE", length = 8)
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

	@Column(name = "FIP_SOU_CODE", length = 5)
	public String getFipSouCode() {
		return this.fipSouCode;
	}

	public void setFipSouCode(String fipSouCode) {
		this.fipSouCode = fipSouCode;
	}

	@Column(name = "FIP_GPG_ID", precision = 10, scale = 0)
	public Long getFipGpgId() {
		return this.fipGpgId;
	}

	public void setFipGpgId(Long fipGpgId) {
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

	@Column(name = "TYM_LIBELLE_LONG", length = 1000)
	public String getTymLibelleLong() {
		return this.tymLibelleLong;
	}

	public void setTymLibelleLong(String tymLibelleLong) {
		this.tymLibelleLong = tymLibelleLong;
	}

	@Column(name = "TYM_TYM_CODE", length = 3)
	public String getTymTymCode() {
		return this.tymTymCode;
	}

	public void setTymTymCode(String tymTymCode) {
		this.tymTymCode = tymTymCode;
	}

	@Column(name = "TYM_GROUPE", length = 2)
	public String getTymGroupe() {
		return this.tymGroupe;
	}

	public void setTymGroupe(String tymGroupe) {
		this.tymGroupe = tymGroupe;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VUpdatePgpmId))
			return false;
		VUpdatePgpmId castOther = (VUpdatePgpmId) other;

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
				&& ((this.getGpgStatutRetour() == castOther.getGpgStatutRetour())
						|| (this.getGpgStatutRetour() != null && castOther.getGpgStatutRetour() != null
								&& this.getGpgStatutRetour().equals(castOther.getGpgStatutRetour())))
				&& ((this.getGpgDateSaisie() == castOther.getGpgDateSaisie())
						|| (this.getGpgDateSaisie() != null && castOther.getGpgDateSaisie() != null
								&& this.getGpgDateSaisie().equals(castOther.getGpgDateSaisie())))
				&& ((this.getGpgStrCode() == castOther.getGpgStrCode()) || (this.getGpgStrCode() != null
						&& castOther.getGpgStrCode() != null && this.getGpgStrCode().equals(castOther.getGpgStrCode())))
				&& ((this.getGpgDateValAc() == castOther.getGpgDateValAc())
						|| (this.getGpgDateValAc() != null && castOther.getGpgDateValAc() != null
								&& this.getGpgDateValAc().equals(castOther.getGpgDateValAc())))
				&& ((this.getGpgDateValCpmp() == castOther.getGpgDateValCpmp())
						|| (this.getGpgDateValCpmp() != null && castOther.getGpgDateValCpmp() != null
								&& this.getGpgDateValCpmp().equals(castOther.getGpgDateValCpmp())))
				&& ((this.getGpgDateValDmp() == castOther.getGpgDateValDmp())
						|| (this.getGpgDateValDmp() != null && castOther.getGpgDateValDmp() != null
								&& this.getGpgDateValDmp().equals(castOther.getGpgDateValDmp())))
				&& ((this.getGpgLibFin() == castOther.getGpgLibFin()) || (this.getGpgLibFin() != null
						&& castOther.getGpgLibFin() != null && this.getGpgLibFin().equals(castOther.getGpgLibFin())))
				&& ((this.getGpgDteModif() == castOther.getGpgDteModif())
						|| (this.getGpgDteModif() != null && castOther.getGpgDteModif() != null
								&& this.getGpgDteModif().equals(castOther.getGpgDteModif())))
				&& ((this.getGpgFonCodPf() == castOther.getGpgFonCodPf())
						|| (this.getGpgFonCodPf() != null && castOther.getGpgFonCodPf() != null
								&& this.getGpgFonCodPf().equals(castOther.getGpgFonCodPf())))
				&& ((this.getGpgFonCodDmp() == castOther.getGpgFonCodDmp())
						|| (this.getGpgFonCodDmp() != null && castOther.getGpgFonCodDmp() != null
								&& this.getGpgFonCodDmp().equals(castOther.getGpgFonCodDmp())))
				&& ((this.getGpgRecherche() == castOther.getGpgRecherche())
						|| (this.getGpgRecherche() != null && castOther.getGpgRecherche() != null
								&& this.getGpgRecherche().equals(castOther.getGpgRecherche())))
				&& ((this.getFipId() == castOther.getFipId()) || (this.getFipId() != null
						&& castOther.getFipId() != null && this.getFipId().equals(castOther.getFipId())))
				&& ((this.getFipDevCode() == castOther.getFipDevCode()) || (this.getFipDevCode() != null
						&& castOther.getFipDevCode() != null && this.getFipDevCode().equals(castOther.getFipDevCode())))
				&& ((this.getFipBaiCode() == castOther.getFipBaiCode()) || (this.getFipBaiCode() != null
						&& castOther.getFipBaiCode() != null && this.getFipBaiCode().equals(castOther.getFipBaiCode())))
				&& ((this.getFipSouCode() == castOther.getFipSouCode()) || (this.getFipSouCode() != null
						&& castOther.getFipSouCode() != null && this.getFipSouCode().equals(castOther.getFipSouCode())))
				&& ((this.getFipGpgId() == castOther.getFipGpgId()) || (this.getFipGpgId() != null
						&& castOther.getFipGpgId() != null && this.getFipGpgId().equals(castOther.getFipGpgId())))
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
				&& ((this.getMopCode() == castOther.getMopCode()) || (this.getMopCode() != null
						&& castOther.getMopCode() != null && this.getMopCode().equals(castOther.getMopCode())))
				&& ((this.getMopLibelleCourt() == castOther.getMopLibelleCourt())
						|| (this.getMopLibelleCourt() != null && castOther.getMopLibelleCourt() != null
								&& this.getMopLibelleCourt().equals(castOther.getMopLibelleCourt())))
				&& ((this.getMopLibelleLong() == castOther.getMopLibelleLong())
						|| (this.getMopLibelleLong() != null && castOther.getMopLibelleLong() != null
								&& this.getMopLibelleLong().equals(castOther.getMopLibelleLong())))
				&& ((this.getTymCode() == castOther.getTymCode()) || (this.getTymCode() != null
						&& castOther.getTymCode() != null && this.getTymCode().equals(castOther.getTymCode())))
				&& ((this.getTymLibelleCourt() == castOther.getTymLibelleCourt())
						|| (this.getTymLibelleCourt() != null && castOther.getTymLibelleCourt() != null
								&& this.getTymLibelleCourt().equals(castOther.getTymLibelleCourt())))
				&& ((this.getTymLibelleLong() == castOther.getTymLibelleLong())
						|| (this.getTymLibelleLong() != null && castOther.getTymLibelleLong() != null
								&& this.getTymLibelleLong().equals(castOther.getTymLibelleLong())))
				&& ((this.getTymTymCode() == castOther.getTymTymCode()) || (this.getTymTymCode() != null
						&& castOther.getTymTymCode() != null && this.getTymTymCode().equals(castOther.getTymTymCode())))
				&& ((this.getTymGroupe() == castOther.getTymGroupe()) || (this.getTymGroupe() != null
						&& castOther.getTymGroupe() != null && this.getTymGroupe().equals(castOther.getTymGroupe())));
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
		result = 37 * result + (getGpgStatutRetour() == null ? 0 : this.getGpgStatutRetour().hashCode());
		result = 37 * result + (getGpgDateSaisie() == null ? 0 : this.getGpgDateSaisie().hashCode());
		result = 37 * result + (getGpgStrCode() == null ? 0 : this.getGpgStrCode().hashCode());
		result = 37 * result + (getGpgDateValAc() == null ? 0 : this.getGpgDateValAc().hashCode());
		result = 37 * result + (getGpgDateValCpmp() == null ? 0 : this.getGpgDateValCpmp().hashCode());
		result = 37 * result + (getGpgDateValDmp() == null ? 0 : this.getGpgDateValDmp().hashCode());
		result = 37 * result + (getGpgLibFin() == null ? 0 : this.getGpgLibFin().hashCode());
		result = 37 * result + (getGpgDteModif() == null ? 0 : this.getGpgDteModif().hashCode());
		result = 37 * result + (getGpgFonCodPf() == null ? 0 : this.getGpgFonCodPf().hashCode());
		result = 37 * result + (getGpgFonCodDmp() == null ? 0 : this.getGpgFonCodDmp().hashCode());
		result = 37 * result + (getGpgRecherche() == null ? 0 : this.getGpgRecherche().hashCode());
		result = 37 * result + (getFipId() == null ? 0 : this.getFipId().hashCode());
		result = 37 * result + (getFipDevCode() == null ? 0 : this.getFipDevCode().hashCode());
		result = 37 * result + (getFipBaiCode() == null ? 0 : this.getFipBaiCode().hashCode());
		result = 37 * result + (getFipSouCode() == null ? 0 : this.getFipSouCode().hashCode());
		result = 37 * result + (getFipGpgId() == null ? 0 : this.getFipGpgId().hashCode());
		result = 37 * result + (getFipMontantCfa() == null ? 0 : this.getFipMontantCfa().hashCode());
		result = 37 * result + (getFipMontantDevise() == null ? 0 : this.getFipMontantDevise().hashCode());
		result = 37 * result + (getFipCommentaire() == null ? 0 : this.getFipCommentaire().hashCode());
		result = 37 * result + (getFipTypeFinance() == null ? 0 : this.getFipTypeFinance().hashCode());
		result = 37 * result + (getFipTresor() == null ? 0 : this.getFipTresor().hashCode());
		result = 37 * result + (getMopCode() == null ? 0 : this.getMopCode().hashCode());
		result = 37 * result + (getMopLibelleCourt() == null ? 0 : this.getMopLibelleCourt().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		result = 37 * result + (getTymCode() == null ? 0 : this.getTymCode().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getTymLibelleLong() == null ? 0 : this.getTymLibelleLong().hashCode());
		result = 37 * result + (getTymTymCode() == null ? 0 : this.getTymTymCode().hashCode());
		result = 37 * result + (getTymGroupe() == null ? 0 : this.getTymGroupe().hashCode());
		return result;
	}

}
