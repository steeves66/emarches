package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbAgpmId generated by hbm2java
 */
@Embeddable
public class VbAgpmId implements java.io.Serializable {

	private long agpId;
	private String agpStrCode;
	private String agpFonCod;
	private short agpGesCode;
	private String agpStaCode;
	private long agpProId;
	private Long agpDecId;
	private String agpCommentaire;
	private String agpTypeDao;
	private String agpModePassation;
	private String agpActif;
	private String agpStatutRetour;
	private String agpActeurSaisie;
	private String agpCode;

	public VbAgpmId() {
	}

	public VbAgpmId(long agpId, String agpStrCode, String agpFonCod, short agpGesCode, String agpStaCode,
			long agpProId) {
		this.agpId = agpId;
		this.agpStrCode = agpStrCode;
		this.agpFonCod = agpFonCod;
		this.agpGesCode = agpGesCode;
		this.agpStaCode = agpStaCode;
		this.agpProId = agpProId;
	}

	public VbAgpmId(long agpId, String agpStrCode, String agpFonCod, short agpGesCode, String agpStaCode, long agpProId,
			Long agpDecId, String agpCommentaire, String agpTypeDao, String agpModePassation, String agpActif,
			String agpStatutRetour, String agpActeurSaisie, String agpCode) {
		this.agpId = agpId;
		this.agpStrCode = agpStrCode;
		this.agpFonCod = agpFonCod;
		this.agpGesCode = agpGesCode;
		this.agpStaCode = agpStaCode;
		this.agpProId = agpProId;
		this.agpDecId = agpDecId;
		this.agpCommentaire = agpCommentaire;
		this.agpTypeDao = agpTypeDao;
		this.agpModePassation = agpModePassation;
		this.agpActif = agpActif;
		this.agpStatutRetour = agpStatutRetour;
		this.agpActeurSaisie = agpActeurSaisie;
		this.agpCode = agpCode;
	}

	@Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpId() {
		return this.agpId;
	}

	public void setAgpId(long agpId) {
		this.agpId = agpId;
	}

	@Column(name = "AGP_STR_CODE", nullable = false, length = 20)
	public String getAgpStrCode() {
		return this.agpStrCode;
	}

	public void setAgpStrCode(String agpStrCode) {
		this.agpStrCode = agpStrCode;
	}

	@Column(name = "AGP_FON_COD", nullable = false, length = 20)
	public String getAgpFonCod() {
		return this.agpFonCod;
	}

	public void setAgpFonCod(String agpFonCod) {
		this.agpFonCod = agpFonCod;
	}

	@Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getAgpGesCode() {
		return this.agpGesCode;
	}

	public void setAgpGesCode(short agpGesCode) {
		this.agpGesCode = agpGesCode;
	}

	@Column(name = "AGP_STA_CODE", nullable = false, length = 3)
	public String getAgpStaCode() {
		return this.agpStaCode;
	}

	public void setAgpStaCode(String agpStaCode) {
		this.agpStaCode = agpStaCode;
	}

	@Column(name = "AGP_PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpProId() {
		return this.agpProId;
	}

	public void setAgpProId(long agpProId) {
		this.agpProId = agpProId;
	}

	@Column(name = "AGP_DEC_ID", precision = 10, scale = 0)
	public Long getAgpDecId() {
		return this.agpDecId;
	}

	public void setAgpDecId(Long agpDecId) {
		this.agpDecId = agpDecId;
	}

	@Column(name = "AGP_COMMENTAIRE", length = 1000)
	public String getAgpCommentaire() {
		return this.agpCommentaire;
	}

	public void setAgpCommentaire(String agpCommentaire) {
		this.agpCommentaire = agpCommentaire;
	}

	@Column(name = "AGP_TYPE_DAO", length = 1000)
	public String getAgpTypeDao() {
		return this.agpTypeDao;
	}

	public void setAgpTypeDao(String agpTypeDao) {
		this.agpTypeDao = agpTypeDao;
	}

	@Column(name = "AGP_MODE_PASSATION", length = 1000)
	public String getAgpModePassation() {
		return this.agpModePassation;
	}

	public void setAgpModePassation(String agpModePassation) {
		this.agpModePassation = agpModePassation;
	}

	@Column(name = "AGP_ACTIF", length = 1)
	public String getAgpActif() {
		return this.agpActif;
	}

	public void setAgpActif(String agpActif) {
		this.agpActif = agpActif;
	}

	@Column(name = "AGP_STATUT_RETOUR", length = 2)
	public String getAgpStatutRetour() {
		return this.agpStatutRetour;
	}

	public void setAgpStatutRetour(String agpStatutRetour) {
		this.agpStatutRetour = agpStatutRetour;
	}

	@Column(name = "AGP_ACTEUR_SAISIE", length = 12)
	public String getAgpActeurSaisie() {
		return this.agpActeurSaisie;
	}

	public void setAgpActeurSaisie(String agpActeurSaisie) {
		this.agpActeurSaisie = agpActeurSaisie;
	}

	@Column(name = "AGP_CODE", length = 50)
	public String getAgpCode() {
		return this.agpCode;
	}

	public void setAgpCode(String agpCode) {
		this.agpCode = agpCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbAgpmId))
			return false;
		VbAgpmId castOther = (VbAgpmId) other;

		return (this.getAgpId() == castOther.getAgpId())
				&& ((this.getAgpStrCode() == castOther.getAgpStrCode()) || (this.getAgpStrCode() != null
						&& castOther.getAgpStrCode() != null && this.getAgpStrCode().equals(castOther.getAgpStrCode())))
				&& ((this.getAgpFonCod() == castOther.getAgpFonCod()) || (this.getAgpFonCod() != null
						&& castOther.getAgpFonCod() != null && this.getAgpFonCod().equals(castOther.getAgpFonCod())))
				&& (this.getAgpGesCode() == castOther.getAgpGesCode())
				&& ((this.getAgpStaCode() == castOther.getAgpStaCode()) || (this.getAgpStaCode() != null
						&& castOther.getAgpStaCode() != null && this.getAgpStaCode().equals(castOther.getAgpStaCode())))
				&& (this.getAgpProId() == castOther.getAgpProId())
				&& ((this.getAgpDecId() == castOther.getAgpDecId()) || (this.getAgpDecId() != null
						&& castOther.getAgpDecId() != null && this.getAgpDecId().equals(castOther.getAgpDecId())))
				&& ((this.getAgpCommentaire() == castOther.getAgpCommentaire())
						|| (this.getAgpCommentaire() != null && castOther.getAgpCommentaire() != null
								&& this.getAgpCommentaire().equals(castOther.getAgpCommentaire())))
				&& ((this.getAgpTypeDao() == castOther.getAgpTypeDao()) || (this.getAgpTypeDao() != null
						&& castOther.getAgpTypeDao() != null && this.getAgpTypeDao().equals(castOther.getAgpTypeDao())))
				&& ((this.getAgpModePassation() == castOther.getAgpModePassation())
						|| (this.getAgpModePassation() != null && castOther.getAgpModePassation() != null
								&& this.getAgpModePassation().equals(castOther.getAgpModePassation())))
				&& ((this.getAgpActif() == castOther.getAgpActif()) || (this.getAgpActif() != null
						&& castOther.getAgpActif() != null && this.getAgpActif().equals(castOther.getAgpActif())))
				&& ((this.getAgpStatutRetour() == castOther.getAgpStatutRetour())
						|| (this.getAgpStatutRetour() != null && castOther.getAgpStatutRetour() != null
								&& this.getAgpStatutRetour().equals(castOther.getAgpStatutRetour())))
				&& ((this.getAgpActeurSaisie() == castOther.getAgpActeurSaisie())
						|| (this.getAgpActeurSaisie() != null && castOther.getAgpActeurSaisie() != null
								&& this.getAgpActeurSaisie().equals(castOther.getAgpActeurSaisie())))
				&& ((this.getAgpCode() == castOther.getAgpCode()) || (this.getAgpCode() != null
						&& castOther.getAgpCode() != null && this.getAgpCode().equals(castOther.getAgpCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAgpId();
		result = 37 * result + (getAgpStrCode() == null ? 0 : this.getAgpStrCode().hashCode());
		result = 37 * result + (getAgpFonCod() == null ? 0 : this.getAgpFonCod().hashCode());
		result = 37 * result + this.getAgpGesCode();
		result = 37 * result + (getAgpStaCode() == null ? 0 : this.getAgpStaCode().hashCode());
		result = 37 * result + (int) this.getAgpProId();
		result = 37 * result + (getAgpDecId() == null ? 0 : this.getAgpDecId().hashCode());
		result = 37 * result + (getAgpCommentaire() == null ? 0 : this.getAgpCommentaire().hashCode());
		result = 37 * result + (getAgpTypeDao() == null ? 0 : this.getAgpTypeDao().hashCode());
		result = 37 * result + (getAgpModePassation() == null ? 0 : this.getAgpModePassation().hashCode());
		result = 37 * result + (getAgpActif() == null ? 0 : this.getAgpActif().hashCode());
		result = 37 * result + (getAgpStatutRetour() == null ? 0 : this.getAgpStatutRetour().hashCode());
		result = 37 * result + (getAgpActeurSaisie() == null ? 0 : this.getAgpActeurSaisie().hashCode());
		result = 37 * result + (getAgpCode() == null ? 0 : this.getAgpCode().hashCode());
		return result;
	}

}
