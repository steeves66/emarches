package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbAffichageAgpmId generated by hbm2java
 */
@Embeddable
public class VbAffichageAgpmId implements java.io.Serializable {

	private long affId;
	private long affProId;
	private long affFinId;
	private short affGesCode;
	private Long affDecId;
	private String affAgpStaCode;
	private long affAgpId;
	private String affBaiCode;
	private String affSouCode;
	private String affDevCode;
	private String affStrCode;
	private String affFonCod;
	private String affAgpActeurSaisie;
	private String affAgpStatutRetour;
	private String affAgpActif;
	private String affAgpTypeDao;
	private String affAgpCommentaire;

	public VbAffichageAgpmId() {
	}

	public VbAffichageAgpmId(long affId, long affProId, long affFinId, short affGesCode, String affAgpStaCode,
			long affAgpId, String affBaiCode, String affSouCode, String affDevCode, String affStrCode,
			String affFonCod) {
		this.affId = affId;
		this.affProId = affProId;
		this.affFinId = affFinId;
		this.affGesCode = affGesCode;
		this.affAgpStaCode = affAgpStaCode;
		this.affAgpId = affAgpId;
		this.affBaiCode = affBaiCode;
		this.affSouCode = affSouCode;
		this.affDevCode = affDevCode;
		this.affStrCode = affStrCode;
		this.affFonCod = affFonCod;
	}

	public VbAffichageAgpmId(long affId, long affProId, long affFinId, short affGesCode, Long affDecId,
			String affAgpStaCode, long affAgpId, String affBaiCode, String affSouCode, String affDevCode,
			String affStrCode, String affFonCod, String affAgpActeurSaisie, String affAgpStatutRetour,
			String affAgpActif, String affAgpTypeDao, String affAgpCommentaire) {
		this.affId = affId;
		this.affProId = affProId;
		this.affFinId = affFinId;
		this.affGesCode = affGesCode;
		this.affDecId = affDecId;
		this.affAgpStaCode = affAgpStaCode;
		this.affAgpId = affAgpId;
		this.affBaiCode = affBaiCode;
		this.affSouCode = affSouCode;
		this.affDevCode = affDevCode;
		this.affStrCode = affStrCode;
		this.affFonCod = affFonCod;
		this.affAgpActeurSaisie = affAgpActeurSaisie;
		this.affAgpStatutRetour = affAgpStatutRetour;
		this.affAgpActif = affAgpActif;
		this.affAgpTypeDao = affAgpTypeDao;
		this.affAgpCommentaire = affAgpCommentaire;
	}

	@Column(name = "AFF_ID", nullable = false, precision = 10, scale = 0)
	public long getAffId() {
		return this.affId;
	}

	public void setAffId(long affId) {
		this.affId = affId;
	}

	@Column(name = "AFF_PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getAffProId() {
		return this.affProId;
	}

	public void setAffProId(long affProId) {
		this.affProId = affProId;
	}

	@Column(name = "AFF_FIN_ID", nullable = false, precision = 10, scale = 0)
	public long getAffFinId() {
		return this.affFinId;
	}

	public void setAffFinId(long affFinId) {
		this.affFinId = affFinId;
	}

	@Column(name = "AFF_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getAffGesCode() {
		return this.affGesCode;
	}

	public void setAffGesCode(short affGesCode) {
		this.affGesCode = affGesCode;
	}

	@Column(name = "AFF_DEC_ID", precision = 10, scale = 0)
	public Long getAffDecId() {
		return this.affDecId;
	}

	public void setAffDecId(Long affDecId) {
		this.affDecId = affDecId;
	}

	@Column(name = "AFF_AGP_STA_CODE", nullable = false, length = 3)
	public String getAffAgpStaCode() {
		return this.affAgpStaCode;
	}

	public void setAffAgpStaCode(String affAgpStaCode) {
		this.affAgpStaCode = affAgpStaCode;
	}

	@Column(name = "AFF_AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAffAgpId() {
		return this.affAgpId;
	}

	public void setAffAgpId(long affAgpId) {
		this.affAgpId = affAgpId;
	}

	@Column(name = "AFF_BAI_CODE", nullable = false, length = 5)
	public String getAffBaiCode() {
		return this.affBaiCode;
	}

	public void setAffBaiCode(String affBaiCode) {
		this.affBaiCode = affBaiCode;
	}

	@Column(name = "AFF_SOU_CODE", nullable = false, length = 5)
	public String getAffSouCode() {
		return this.affSouCode;
	}

	public void setAffSouCode(String affSouCode) {
		this.affSouCode = affSouCode;
	}

	@Column(name = "AFF_DEV_CODE", nullable = false, length = 8)
	public String getAffDevCode() {
		return this.affDevCode;
	}

	public void setAffDevCode(String affDevCode) {
		this.affDevCode = affDevCode;
	}

	@Column(name = "AFF_STR_CODE", nullable = false, length = 3)
	public String getAffStrCode() {
		return this.affStrCode;
	}

	public void setAffStrCode(String affStrCode) {
		this.affStrCode = affStrCode;
	}

	@Column(name = "AFF_FON_COD", nullable = false, length = 12)
	public String getAffFonCod() {
		return this.affFonCod;
	}

	public void setAffFonCod(String affFonCod) {
		this.affFonCod = affFonCod;
	}

	@Column(name = "AFF_AGP_ACTEUR_SAISIE", length = 12)
	public String getAffAgpActeurSaisie() {
		return this.affAgpActeurSaisie;
	}

	public void setAffAgpActeurSaisie(String affAgpActeurSaisie) {
		this.affAgpActeurSaisie = affAgpActeurSaisie;
	}

	@Column(name = "AFF_AGP_STATUT_RETOUR", length = 2)
	public String getAffAgpStatutRetour() {
		return this.affAgpStatutRetour;
	}

	public void setAffAgpStatutRetour(String affAgpStatutRetour) {
		this.affAgpStatutRetour = affAgpStatutRetour;
	}

	@Column(name = "AFF_AGP_ACTIF", length = 1)
	public String getAffAgpActif() {
		return this.affAgpActif;
	}

	public void setAffAgpActif(String affAgpActif) {
		this.affAgpActif = affAgpActif;
	}

	@Column(name = "AFF_AGP_TYPE_DAO", length = 1000)
	public String getAffAgpTypeDao() {
		return this.affAgpTypeDao;
	}

	public void setAffAgpTypeDao(String affAgpTypeDao) {
		this.affAgpTypeDao = affAgpTypeDao;
	}

	@Column(name = "AFF_AGP_COMMENTAIRE", length = 1000)
	public String getAffAgpCommentaire() {
		return this.affAgpCommentaire;
	}

	public void setAffAgpCommentaire(String affAgpCommentaire) {
		this.affAgpCommentaire = affAgpCommentaire;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbAffichageAgpmId))
			return false;
		VbAffichageAgpmId castOther = (VbAffichageAgpmId) other;

		return (this.getAffId() == castOther.getAffId()) && (this.getAffProId() == castOther.getAffProId())
				&& (this.getAffFinId() == castOther.getAffFinId())
				&& (this.getAffGesCode() == castOther.getAffGesCode())
				&& ((this.getAffDecId() == castOther.getAffDecId()) || (this.getAffDecId() != null
						&& castOther.getAffDecId() != null && this.getAffDecId().equals(castOther.getAffDecId())))
				&& ((this.getAffAgpStaCode() == castOther.getAffAgpStaCode())
						|| (this.getAffAgpStaCode() != null && castOther.getAffAgpStaCode() != null
								&& this.getAffAgpStaCode().equals(castOther.getAffAgpStaCode())))
				&& (this.getAffAgpId() == castOther.getAffAgpId())
				&& ((this.getAffBaiCode() == castOther.getAffBaiCode()) || (this.getAffBaiCode() != null
						&& castOther.getAffBaiCode() != null && this.getAffBaiCode().equals(castOther.getAffBaiCode())))
				&& ((this.getAffSouCode() == castOther.getAffSouCode()) || (this.getAffSouCode() != null
						&& castOther.getAffSouCode() != null && this.getAffSouCode().equals(castOther.getAffSouCode())))
				&& ((this.getAffDevCode() == castOther.getAffDevCode()) || (this.getAffDevCode() != null
						&& castOther.getAffDevCode() != null && this.getAffDevCode().equals(castOther.getAffDevCode())))
				&& ((this.getAffStrCode() == castOther.getAffStrCode()) || (this.getAffStrCode() != null
						&& castOther.getAffStrCode() != null && this.getAffStrCode().equals(castOther.getAffStrCode())))
				&& ((this.getAffFonCod() == castOther.getAffFonCod()) || (this.getAffFonCod() != null
						&& castOther.getAffFonCod() != null && this.getAffFonCod().equals(castOther.getAffFonCod())))
				&& ((this.getAffAgpActeurSaisie() == castOther.getAffAgpActeurSaisie())
						|| (this.getAffAgpActeurSaisie() != null && castOther.getAffAgpActeurSaisie() != null
								&& this.getAffAgpActeurSaisie().equals(castOther.getAffAgpActeurSaisie())))
				&& ((this.getAffAgpStatutRetour() == castOther.getAffAgpStatutRetour())
						|| (this.getAffAgpStatutRetour() != null && castOther.getAffAgpStatutRetour() != null
								&& this.getAffAgpStatutRetour().equals(castOther.getAffAgpStatutRetour())))
				&& ((this.getAffAgpActif() == castOther.getAffAgpActif())
						|| (this.getAffAgpActif() != null && castOther.getAffAgpActif() != null
								&& this.getAffAgpActif().equals(castOther.getAffAgpActif())))
				&& ((this.getAffAgpTypeDao() == castOther.getAffAgpTypeDao())
						|| (this.getAffAgpTypeDao() != null && castOther.getAffAgpTypeDao() != null
								&& this.getAffAgpTypeDao().equals(castOther.getAffAgpTypeDao())))
				&& ((this.getAffAgpCommentaire() == castOther.getAffAgpCommentaire())
						|| (this.getAffAgpCommentaire() != null && castOther.getAffAgpCommentaire() != null
								&& this.getAffAgpCommentaire().equals(castOther.getAffAgpCommentaire())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAffId();
		result = 37 * result + (int) this.getAffProId();
		result = 37 * result + (int) this.getAffFinId();
		result = 37 * result + this.getAffGesCode();
		result = 37 * result + (getAffDecId() == null ? 0 : this.getAffDecId().hashCode());
		result = 37 * result + (getAffAgpStaCode() == null ? 0 : this.getAffAgpStaCode().hashCode());
		result = 37 * result + (int) this.getAffAgpId();
		result = 37 * result + (getAffBaiCode() == null ? 0 : this.getAffBaiCode().hashCode());
		result = 37 * result + (getAffSouCode() == null ? 0 : this.getAffSouCode().hashCode());
		result = 37 * result + (getAffDevCode() == null ? 0 : this.getAffDevCode().hashCode());
		result = 37 * result + (getAffStrCode() == null ? 0 : this.getAffStrCode().hashCode());
		result = 37 * result + (getAffFonCod() == null ? 0 : this.getAffFonCod().hashCode());
		result = 37 * result + (getAffAgpActeurSaisie() == null ? 0 : this.getAffAgpActeurSaisie().hashCode());
		result = 37 * result + (getAffAgpStatutRetour() == null ? 0 : this.getAffAgpStatutRetour().hashCode());
		result = 37 * result + (getAffAgpActif() == null ? 0 : this.getAffAgpActif().hashCode());
		result = 37 * result + (getAffAgpTypeDao() == null ? 0 : this.getAffAgpTypeDao().hashCode());
		result = 37 * result + (getAffAgpCommentaire() == null ? 0 : this.getAffAgpCommentaire().hashCode());
		return result;
	}

}
