package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbAffichagePgpmId generated by hbm2java
 */
@Embeddable
public class VbAffichagePgpmId implements java.io.Serializable {

	private Long affGpgId;
	private long affGpgPlgId;
	private Long affGpgAgpId;
	private String affGpgTypePlan;
	private String affGpgStaCode;
	private String affGpgTymCode;
	private String affGpgMopCode;
	private String affGpgCode;
	private String affGpgObjet;
	private Integer affGpgNumeroOrdre;
	private String affGpgPartiePmePmi;
	private String affGpgCommentaire;
	private String affGpgSourceFin;
	private Date affGpgDateDao;
	private String affGpgActeurSaisie;
	private String affGpgStatutRetour;
	private Date affGpgDateSaisie;
	private String affGpgFonCod;
	private long affId;
	private String affGpgStrCode;
	private Short affGpgGesCode;
	private String affGpgRecherche;
	private Date affGpgDateValAc;
	private Date affGpgDateValCpmp;
	private Date affGpgDateValDmp;
	private String affGpgTypeFinance;
	private String affGpgLibFin;
	private Date affGpgDteModif;
	private String affFonCodPf;
	private String affFonCodDmp;

	public VbAffichagePgpmId() {
	}

	public VbAffichagePgpmId(long affGpgPlgId, String affGpgTypePlan, String affGpgStaCode, String affGpgTymCode,
			String affGpgMopCode, long affId) {
		this.affGpgPlgId = affGpgPlgId;
		this.affGpgTypePlan = affGpgTypePlan;
		this.affGpgStaCode = affGpgStaCode;
		this.affGpgTymCode = affGpgTymCode;
		this.affGpgMopCode = affGpgMopCode;
		this.affId = affId;
	}

	public VbAffichagePgpmId(Long affGpgId, long affGpgPlgId, Long affGpgAgpId, String affGpgTypePlan,
			String affGpgStaCode, String affGpgTymCode, String affGpgMopCode, String affGpgCode, String affGpgObjet,
			Integer affGpgNumeroOrdre, String affGpgPartiePmePmi, String affGpgCommentaire, String affGpgSourceFin,
			Date affGpgDateDao, String affGpgActeurSaisie, String affGpgStatutRetour, Date affGpgDateSaisie,
			String affGpgFonCod, long affId, String affGpgStrCode, Short affGpgGesCode, String affGpgRecherche,
			Date affGpgDateValAc, Date affGpgDateValCpmp, Date affGpgDateValDmp, String affGpgTypeFinance,
			String affGpgLibFin, Date affGpgDteModif, String affFonCodPf, String affFonCodDmp) {
		this.affGpgId = affGpgId;
		this.affGpgPlgId = affGpgPlgId;
		this.affGpgAgpId = affGpgAgpId;
		this.affGpgTypePlan = affGpgTypePlan;
		this.affGpgStaCode = affGpgStaCode;
		this.affGpgTymCode = affGpgTymCode;
		this.affGpgMopCode = affGpgMopCode;
		this.affGpgCode = affGpgCode;
		this.affGpgObjet = affGpgObjet;
		this.affGpgNumeroOrdre = affGpgNumeroOrdre;
		this.affGpgPartiePmePmi = affGpgPartiePmePmi;
		this.affGpgCommentaire = affGpgCommentaire;
		this.affGpgSourceFin = affGpgSourceFin;
		this.affGpgDateDao = affGpgDateDao;
		this.affGpgActeurSaisie = affGpgActeurSaisie;
		this.affGpgStatutRetour = affGpgStatutRetour;
		this.affGpgDateSaisie = affGpgDateSaisie;
		this.affGpgFonCod = affGpgFonCod;
		this.affId = affId;
		this.affGpgStrCode = affGpgStrCode;
		this.affGpgGesCode = affGpgGesCode;
		this.affGpgRecherche = affGpgRecherche;
		this.affGpgDateValAc = affGpgDateValAc;
		this.affGpgDateValCpmp = affGpgDateValCpmp;
		this.affGpgDateValDmp = affGpgDateValDmp;
		this.affGpgTypeFinance = affGpgTypeFinance;
		this.affGpgLibFin = affGpgLibFin;
		this.affGpgDteModif = affGpgDteModif;
		this.affFonCodPf = affFonCodPf;
		this.affFonCodDmp = affFonCodDmp;
	}

	@Column(name = "AFF_GPG_ID", precision = 10, scale = 0)
	public Long getAffGpgId() {
		return this.affGpgId;
	}

	public void setAffGpgId(Long affGpgId) {
		this.affGpgId = affGpgId;
	}

	@Column(name = "AFF_GPG_PLG_ID", nullable = false, precision = 10, scale = 0)
	public long getAffGpgPlgId() {
		return this.affGpgPlgId;
	}

	public void setAffGpgPlgId(long affGpgPlgId) {
		this.affGpgPlgId = affGpgPlgId;
	}

	@Column(name = "AFF_GPG_AGP_ID", precision = 10, scale = 0)
	public Long getAffGpgAgpId() {
		return this.affGpgAgpId;
	}

	public void setAffGpgAgpId(Long affGpgAgpId) {
		this.affGpgAgpId = affGpgAgpId;
	}

	@Column(name = "AFF_GPG_TYPE_PLAN", nullable = false, length = 3)
	public String getAffGpgTypePlan() {
		return this.affGpgTypePlan;
	}

	public void setAffGpgTypePlan(String affGpgTypePlan) {
		this.affGpgTypePlan = affGpgTypePlan;
	}

	@Column(name = "AFF_GPG_STA_CODE", nullable = false, length = 3)
	public String getAffGpgStaCode() {
		return this.affGpgStaCode;
	}

	public void setAffGpgStaCode(String affGpgStaCode) {
		this.affGpgStaCode = affGpgStaCode;
	}

	@Column(name = "AFF_GPG_TYM_CODE", nullable = false, length = 3)
	public String getAffGpgTymCode() {
		return this.affGpgTymCode;
	}

	public void setAffGpgTymCode(String affGpgTymCode) {
		this.affGpgTymCode = affGpgTymCode;
	}

	@Column(name = "AFF_GPG_MOP_CODE", nullable = false, length = 3)
	public String getAffGpgMopCode() {
		return this.affGpgMopCode;
	}

	public void setAffGpgMopCode(String affGpgMopCode) {
		this.affGpgMopCode = affGpgMopCode;
	}

	@Column(name = "AFF_GPG_CODE", length = 50)
	public String getAffGpgCode() {
		return this.affGpgCode;
	}

	public void setAffGpgCode(String affGpgCode) {
		this.affGpgCode = affGpgCode;
	}

	@Column(name = "AFF_GPG_OBJET", length = 1000)
	public String getAffGpgObjet() {
		return this.affGpgObjet;
	}

	public void setAffGpgObjet(String affGpgObjet) {
		this.affGpgObjet = affGpgObjet;
	}

	@Column(name = "AFF_GPG_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getAffGpgNumeroOrdre() {
		return this.affGpgNumeroOrdre;
	}

	public void setAffGpgNumeroOrdre(Integer affGpgNumeroOrdre) {
		this.affGpgNumeroOrdre = affGpgNumeroOrdre;
	}

	@Column(name = "AFF_GPG_PARTIE_PME_PMI", length = 1)
	public String getAffGpgPartiePmePmi() {
		return this.affGpgPartiePmePmi;
	}

	public void setAffGpgPartiePmePmi(String affGpgPartiePmePmi) {
		this.affGpgPartiePmePmi = affGpgPartiePmePmi;
	}

	@Column(name = "AFF_GPG_COMMENTAIRE", length = 1000)
	public String getAffGpgCommentaire() {
		return this.affGpgCommentaire;
	}

	public void setAffGpgCommentaire(String affGpgCommentaire) {
		this.affGpgCommentaire = affGpgCommentaire;
	}

	@Column(name = "AFF_GPG_SOURCE_FIN", length = 5)
	public String getAffGpgSourceFin() {
		return this.affGpgSourceFin;
	}

	public void setAffGpgSourceFin(String affGpgSourceFin) {
		this.affGpgSourceFin = affGpgSourceFin;
	}

	@Column(name = "AFF_GPG_DATE_DAO", length = 7)
	public Date getAffGpgDateDao() {
		return this.affGpgDateDao;
	}

	public void setAffGpgDateDao(Date affGpgDateDao) {
		this.affGpgDateDao = affGpgDateDao;
	}

	@Column(name = "AFF_GPG_ACTEUR_SAISIE", length = 12)
	public String getAffGpgActeurSaisie() {
		return this.affGpgActeurSaisie;
	}

	public void setAffGpgActeurSaisie(String affGpgActeurSaisie) {
		this.affGpgActeurSaisie = affGpgActeurSaisie;
	}

	@Column(name = "AFF_GPG_STATUT_RETOUR", length = 4)
	public String getAffGpgStatutRetour() {
		return this.affGpgStatutRetour;
	}

	public void setAffGpgStatutRetour(String affGpgStatutRetour) {
		this.affGpgStatutRetour = affGpgStatutRetour;
	}

	@Column(name = "AFF_GPG_DATE_SAISIE", length = 7)
	public Date getAffGpgDateSaisie() {
		return this.affGpgDateSaisie;
	}

	public void setAffGpgDateSaisie(Date affGpgDateSaisie) {
		this.affGpgDateSaisie = affGpgDateSaisie;
	}

	@Column(name = "AFF_GPG_FON_COD", length = 12)
	public String getAffGpgFonCod() {
		return this.affGpgFonCod;
	}

	public void setAffGpgFonCod(String affGpgFonCod) {
		this.affGpgFonCod = affGpgFonCod;
	}

	@Column(name = "AFF_ID", nullable = false, precision = 10, scale = 0)
	public long getAffId() {
		return this.affId;
	}

	public void setAffId(long affId) {
		this.affId = affId;
	}

	@Column(name = "AFF_GPG_STR_CODE", length = 20)
	public String getAffGpgStrCode() {
		return this.affGpgStrCode;
	}

	public void setAffGpgStrCode(String affGpgStrCode) {
		this.affGpgStrCode = affGpgStrCode;
	}

	@Column(name = "AFF_GPG_GES_CODE", precision = 4, scale = 0)
	public Short getAffGpgGesCode() {
		return this.affGpgGesCode;
	}

	public void setAffGpgGesCode(Short affGpgGesCode) {
		this.affGpgGesCode = affGpgGesCode;
	}

	@Column(name = "AFF_GPG_RECHERCHE", length = 4000)
	public String getAffGpgRecherche() {
		return this.affGpgRecherche;
	}

	public void setAffGpgRecherche(String affGpgRecherche) {
		this.affGpgRecherche = affGpgRecherche;
	}

	@Column(name = "AFF_GPG_DATE_VAL_AC", length = 7)
	public Date getAffGpgDateValAc() {
		return this.affGpgDateValAc;
	}

	public void setAffGpgDateValAc(Date affGpgDateValAc) {
		this.affGpgDateValAc = affGpgDateValAc;
	}

	@Column(name = "AFF_GPG_DATE_VAL_CPMP", length = 7)
	public Date getAffGpgDateValCpmp() {
		return this.affGpgDateValCpmp;
	}

	public void setAffGpgDateValCpmp(Date affGpgDateValCpmp) {
		this.affGpgDateValCpmp = affGpgDateValCpmp;
	}

	@Column(name = "AFF_GPG_DATE_VAL_DMP", length = 7)
	public Date getAffGpgDateValDmp() {
		return this.affGpgDateValDmp;
	}

	public void setAffGpgDateValDmp(Date affGpgDateValDmp) {
		this.affGpgDateValDmp = affGpgDateValDmp;
	}

	@Column(name = "AFF_GPG_TYPE_FINANCE", length = 20)
	public String getAffGpgTypeFinance() {
		return this.affGpgTypeFinance;
	}

	public void setAffGpgTypeFinance(String affGpgTypeFinance) {
		this.affGpgTypeFinance = affGpgTypeFinance;
	}

	@Column(name = "AFF_GPG_LIB_FIN", length = 200)
	public String getAffGpgLibFin() {
		return this.affGpgLibFin;
	}

	public void setAffGpgLibFin(String affGpgLibFin) {
		this.affGpgLibFin = affGpgLibFin;
	}

	@Column(name = "AFF_GPG_DTE_MODIF", length = 7)
	public Date getAffGpgDteModif() {
		return this.affGpgDteModif;
	}

	public void setAffGpgDteModif(Date affGpgDteModif) {
		this.affGpgDteModif = affGpgDteModif;
	}

	@Column(name = "AFF_FON_COD_PF", length = 20)
	public String getAffFonCodPf() {
		return this.affFonCodPf;
	}

	public void setAffFonCodPf(String affFonCodPf) {
		this.affFonCodPf = affFonCodPf;
	}

	@Column(name = "AFF_FON_COD_DMP", length = 20)
	public String getAffFonCodDmp() {
		return this.affFonCodDmp;
	}

	public void setAffFonCodDmp(String affFonCodDmp) {
		this.affFonCodDmp = affFonCodDmp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbAffichagePgpmId))
			return false;
		VbAffichagePgpmId castOther = (VbAffichagePgpmId) other;

		return ((this.getAffGpgId() == castOther.getAffGpgId()) || (this.getAffGpgId() != null
				&& castOther.getAffGpgId() != null && this.getAffGpgId().equals(castOther.getAffGpgId())))
				&& (this.getAffGpgPlgId() == castOther.getAffGpgPlgId())
				&& ((this.getAffGpgAgpId() == castOther.getAffGpgAgpId())
						|| (this.getAffGpgAgpId() != null && castOther.getAffGpgAgpId() != null
								&& this.getAffGpgAgpId().equals(castOther.getAffGpgAgpId())))
				&& ((this.getAffGpgTypePlan() == castOther.getAffGpgTypePlan())
						|| (this.getAffGpgTypePlan() != null && castOther.getAffGpgTypePlan() != null
								&& this.getAffGpgTypePlan().equals(castOther.getAffGpgTypePlan())))
				&& ((this.getAffGpgStaCode() == castOther.getAffGpgStaCode())
						|| (this.getAffGpgStaCode() != null && castOther.getAffGpgStaCode() != null
								&& this.getAffGpgStaCode().equals(castOther.getAffGpgStaCode())))
				&& ((this.getAffGpgTymCode() == castOther.getAffGpgTymCode())
						|| (this.getAffGpgTymCode() != null && castOther.getAffGpgTymCode() != null
								&& this.getAffGpgTymCode().equals(castOther.getAffGpgTymCode())))
				&& ((this.getAffGpgMopCode() == castOther.getAffGpgMopCode())
						|| (this.getAffGpgMopCode() != null && castOther.getAffGpgMopCode() != null
								&& this.getAffGpgMopCode().equals(castOther.getAffGpgMopCode())))
				&& ((this.getAffGpgCode() == castOther.getAffGpgCode()) || (this.getAffGpgCode() != null
						&& castOther.getAffGpgCode() != null && this.getAffGpgCode().equals(castOther.getAffGpgCode())))
				&& ((this.getAffGpgObjet() == castOther.getAffGpgObjet())
						|| (this.getAffGpgObjet() != null && castOther.getAffGpgObjet() != null
								&& this.getAffGpgObjet().equals(castOther.getAffGpgObjet())))
				&& ((this.getAffGpgNumeroOrdre() == castOther.getAffGpgNumeroOrdre())
						|| (this.getAffGpgNumeroOrdre() != null && castOther.getAffGpgNumeroOrdre() != null
								&& this.getAffGpgNumeroOrdre().equals(castOther.getAffGpgNumeroOrdre())))
				&& ((this.getAffGpgPartiePmePmi() == castOther.getAffGpgPartiePmePmi())
						|| (this.getAffGpgPartiePmePmi() != null && castOther.getAffGpgPartiePmePmi() != null
								&& this.getAffGpgPartiePmePmi().equals(castOther.getAffGpgPartiePmePmi())))
				&& ((this.getAffGpgCommentaire() == castOther.getAffGpgCommentaire())
						|| (this.getAffGpgCommentaire() != null && castOther.getAffGpgCommentaire() != null
								&& this.getAffGpgCommentaire().equals(castOther.getAffGpgCommentaire())))
				&& ((this.getAffGpgSourceFin() == castOther.getAffGpgSourceFin())
						|| (this.getAffGpgSourceFin() != null && castOther.getAffGpgSourceFin() != null
								&& this.getAffGpgSourceFin().equals(castOther.getAffGpgSourceFin())))
				&& ((this.getAffGpgDateDao() == castOther.getAffGpgDateDao())
						|| (this.getAffGpgDateDao() != null && castOther.getAffGpgDateDao() != null
								&& this.getAffGpgDateDao().equals(castOther.getAffGpgDateDao())))
				&& ((this.getAffGpgActeurSaisie() == castOther.getAffGpgActeurSaisie())
						|| (this.getAffGpgActeurSaisie() != null && castOther.getAffGpgActeurSaisie() != null
								&& this.getAffGpgActeurSaisie().equals(castOther.getAffGpgActeurSaisie())))
				&& ((this.getAffGpgStatutRetour() == castOther.getAffGpgStatutRetour())
						|| (this.getAffGpgStatutRetour() != null && castOther.getAffGpgStatutRetour() != null
								&& this.getAffGpgStatutRetour().equals(castOther.getAffGpgStatutRetour())))
				&& ((this.getAffGpgDateSaisie() == castOther.getAffGpgDateSaisie())
						|| (this.getAffGpgDateSaisie() != null && castOther.getAffGpgDateSaisie() != null
								&& this.getAffGpgDateSaisie().equals(castOther.getAffGpgDateSaisie())))
				&& ((this.getAffGpgFonCod() == castOther.getAffGpgFonCod())
						|| (this.getAffGpgFonCod() != null && castOther.getAffGpgFonCod() != null
								&& this.getAffGpgFonCod().equals(castOther.getAffGpgFonCod())))
				&& (this.getAffId() == castOther.getAffId())
				&& ((this.getAffGpgStrCode() == castOther.getAffGpgStrCode())
						|| (this.getAffGpgStrCode() != null && castOther.getAffGpgStrCode() != null
								&& this.getAffGpgStrCode().equals(castOther.getAffGpgStrCode())))
				&& ((this.getAffGpgGesCode() == castOther.getAffGpgGesCode())
						|| (this.getAffGpgGesCode() != null && castOther.getAffGpgGesCode() != null
								&& this.getAffGpgGesCode().equals(castOther.getAffGpgGesCode())))
				&& ((this.getAffGpgRecherche() == castOther.getAffGpgRecherche())
						|| (this.getAffGpgRecherche() != null && castOther.getAffGpgRecherche() != null
								&& this.getAffGpgRecherche().equals(castOther.getAffGpgRecherche())))
				&& ((this.getAffGpgDateValAc() == castOther.getAffGpgDateValAc())
						|| (this.getAffGpgDateValAc() != null && castOther.getAffGpgDateValAc() != null
								&& this.getAffGpgDateValAc().equals(castOther.getAffGpgDateValAc())))
				&& ((this.getAffGpgDateValCpmp() == castOther.getAffGpgDateValCpmp())
						|| (this.getAffGpgDateValCpmp() != null && castOther.getAffGpgDateValCpmp() != null
								&& this.getAffGpgDateValCpmp().equals(castOther.getAffGpgDateValCpmp())))
				&& ((this.getAffGpgDateValDmp() == castOther.getAffGpgDateValDmp())
						|| (this.getAffGpgDateValDmp() != null && castOther.getAffGpgDateValDmp() != null
								&& this.getAffGpgDateValDmp().equals(castOther.getAffGpgDateValDmp())))
				&& ((this.getAffGpgTypeFinance() == castOther.getAffGpgTypeFinance())
						|| (this.getAffGpgTypeFinance() != null && castOther.getAffGpgTypeFinance() != null
								&& this.getAffGpgTypeFinance().equals(castOther.getAffGpgTypeFinance())))
				&& ((this.getAffGpgLibFin() == castOther.getAffGpgLibFin())
						|| (this.getAffGpgLibFin() != null && castOther.getAffGpgLibFin() != null
								&& this.getAffGpgLibFin().equals(castOther.getAffGpgLibFin())))
				&& ((this.getAffGpgDteModif() == castOther.getAffGpgDteModif())
						|| (this.getAffGpgDteModif() != null && castOther.getAffGpgDteModif() != null
								&& this.getAffGpgDteModif().equals(castOther.getAffGpgDteModif())))
				&& ((this.getAffFonCodPf() == castOther.getAffFonCodPf())
						|| (this.getAffFonCodPf() != null && castOther.getAffFonCodPf() != null
								&& this.getAffFonCodPf().equals(castOther.getAffFonCodPf())))
				&& ((this.getAffFonCodDmp() == castOther.getAffFonCodDmp())
						|| (this.getAffFonCodDmp() != null && castOther.getAffFonCodDmp() != null
								&& this.getAffFonCodDmp().equals(castOther.getAffFonCodDmp())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getAffGpgId() == null ? 0 : this.getAffGpgId().hashCode());
		result = 37 * result + (int) this.getAffGpgPlgId();
		result = 37 * result + (getAffGpgAgpId() == null ? 0 : this.getAffGpgAgpId().hashCode());
		result = 37 * result + (getAffGpgTypePlan() == null ? 0 : this.getAffGpgTypePlan().hashCode());
		result = 37 * result + (getAffGpgStaCode() == null ? 0 : this.getAffGpgStaCode().hashCode());
		result = 37 * result + (getAffGpgTymCode() == null ? 0 : this.getAffGpgTymCode().hashCode());
		result = 37 * result + (getAffGpgMopCode() == null ? 0 : this.getAffGpgMopCode().hashCode());
		result = 37 * result + (getAffGpgCode() == null ? 0 : this.getAffGpgCode().hashCode());
		result = 37 * result + (getAffGpgObjet() == null ? 0 : this.getAffGpgObjet().hashCode());
		result = 37 * result + (getAffGpgNumeroOrdre() == null ? 0 : this.getAffGpgNumeroOrdre().hashCode());
		result = 37 * result + (getAffGpgPartiePmePmi() == null ? 0 : this.getAffGpgPartiePmePmi().hashCode());
		result = 37 * result + (getAffGpgCommentaire() == null ? 0 : this.getAffGpgCommentaire().hashCode());
		result = 37 * result + (getAffGpgSourceFin() == null ? 0 : this.getAffGpgSourceFin().hashCode());
		result = 37 * result + (getAffGpgDateDao() == null ? 0 : this.getAffGpgDateDao().hashCode());
		result = 37 * result + (getAffGpgActeurSaisie() == null ? 0 : this.getAffGpgActeurSaisie().hashCode());
		result = 37 * result + (getAffGpgStatutRetour() == null ? 0 : this.getAffGpgStatutRetour().hashCode());
		result = 37 * result + (getAffGpgDateSaisie() == null ? 0 : this.getAffGpgDateSaisie().hashCode());
		result = 37 * result + (getAffGpgFonCod() == null ? 0 : this.getAffGpgFonCod().hashCode());
		result = 37 * result + (int) this.getAffId();
		result = 37 * result + (getAffGpgStrCode() == null ? 0 : this.getAffGpgStrCode().hashCode());
		result = 37 * result + (getAffGpgGesCode() == null ? 0 : this.getAffGpgGesCode().hashCode());
		result = 37 * result + (getAffGpgRecherche() == null ? 0 : this.getAffGpgRecherche().hashCode());
		result = 37 * result + (getAffGpgDateValAc() == null ? 0 : this.getAffGpgDateValAc().hashCode());
		result = 37 * result + (getAffGpgDateValCpmp() == null ? 0 : this.getAffGpgDateValCpmp().hashCode());
		result = 37 * result + (getAffGpgDateValDmp() == null ? 0 : this.getAffGpgDateValDmp().hashCode());
		result = 37 * result + (getAffGpgTypeFinance() == null ? 0 : this.getAffGpgTypeFinance().hashCode());
		result = 37 * result + (getAffGpgLibFin() == null ? 0 : this.getAffGpgLibFin().hashCode());
		result = 37 * result + (getAffGpgDteModif() == null ? 0 : this.getAffGpgDteModif().hashCode());
		result = 37 * result + (getAffFonCodPf() == null ? 0 : this.getAffFonCodPf().hashCode());
		result = 37 * result + (getAffFonCodDmp() == null ? 0 : this.getAffFonCodDmp().hashCode());
		return result;
	}

}