package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VAgpmId generated by hbm2java
 */
@Embeddable
public class VAgpmId implements java.io.Serializable {

	private long agpId;
	private short agpGesCode;
	private String minLibelleCourt;
	private String minLibelle;
	private String fonCod;
	private String ac;
	private String proLibelle;
	private String agpTypeDao;
	private String agpModePassation;
	private BigDecimal proMontantTotCfa;
	private String agpStaCode;
	private String agpStrCode;
	private String agpActif;
	private String agpStatutRetour;
	private String decOrganExecLibelle;

	public VAgpmId() {
	}

	public VAgpmId(long agpId, short agpGesCode, String fonCod, String agpStaCode, String agpStrCode,
			String decOrganExecLibelle) {
		this.agpId = agpId;
		this.agpGesCode = agpGesCode;
		this.fonCod = fonCod;
		this.agpStaCode = agpStaCode;
		this.agpStrCode = agpStrCode;
		this.decOrganExecLibelle = decOrganExecLibelle;
	}

	public VAgpmId(long agpId, short agpGesCode, String minLibelleCourt, String minLibelle, String fonCod, String ac,
			String proLibelle, String agpTypeDao, String agpModePassation, BigDecimal proMontantTotCfa,
			String agpStaCode, String agpStrCode, String agpActif, String agpStatutRetour, String decOrganExecLibelle) {
		this.agpId = agpId;
		this.agpGesCode = agpGesCode;
		this.minLibelleCourt = minLibelleCourt;
		this.minLibelle = minLibelle;
		this.fonCod = fonCod;
		this.ac = ac;
		this.proLibelle = proLibelle;
		this.agpTypeDao = agpTypeDao;
		this.agpModePassation = agpModePassation;
		this.proMontantTotCfa = proMontantTotCfa;
		this.agpStaCode = agpStaCode;
		this.agpStrCode = agpStrCode;
		this.agpActif = agpActif;
		this.agpStatutRetour = agpStatutRetour;
		this.decOrganExecLibelle = decOrganExecLibelle;
	}

	@Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpId() {
		return this.agpId;
	}

	public void setAgpId(long agpId) {
		this.agpId = agpId;
	}

	@Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getAgpGesCode() {
		return this.agpGesCode;
	}

	public void setAgpGesCode(short agpGesCode) {
		this.agpGesCode = agpGesCode;
	}

	@Column(name = "MIN_LIBELLE_COURT", length = 500)
	public String getMinLibelleCourt() {
		return this.minLibelleCourt;
	}

	public void setMinLibelleCourt(String minLibelleCourt) {
		this.minLibelleCourt = minLibelleCourt;
	}

	@Column(name = "MIN_LIBELLE", length = 1000)
	public String getMinLibelle() {
		return this.minLibelle;
	}

	public void setMinLibelle(String minLibelle) {
		this.minLibelle = minLibelle;
	}

	@Column(name = "FON_COD", nullable = false, length = 20)
	public String getFonCod() {
		return this.fonCod;
	}

	public void setFonCod(String fonCod) {
		this.fonCod = fonCod;
	}

	@Column(name = "AC", length = 523)
	public String getAc() {
		return this.ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	@Column(name = "PRO_LIBELLE", length = 500)
	public String getProLibelle() {
		return this.proLibelle;
	}

	public void setProLibelle(String proLibelle) {
		this.proLibelle = proLibelle;
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

	@Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)
	public BigDecimal getProMontantTotCfa() {
		return this.proMontantTotCfa;
	}

	public void setProMontantTotCfa(BigDecimal proMontantTotCfa) {
		this.proMontantTotCfa = proMontantTotCfa;
	}

	@Column(name = "AGP_STA_CODE", nullable = false, length = 3)
	public String getAgpStaCode() {
		return this.agpStaCode;
	}

	public void setAgpStaCode(String agpStaCode) {
		this.agpStaCode = agpStaCode;
	}

	@Column(name = "AGP_STR_CODE", nullable = false, length = 3)
	public String getAgpStrCode() {
		return this.agpStrCode;
	}

	public void setAgpStrCode(String agpStrCode) {
		this.agpStrCode = agpStrCode;
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

	@Column(name = "DEC_ORGAN_EXEC_LIBELLE", nullable = false, length = 500)
	public String getDecOrganExecLibelle() {
		return this.decOrganExecLibelle;
	}

	public void setDecOrganExecLibelle(String decOrganExecLibelle) {
		this.decOrganExecLibelle = decOrganExecLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VAgpmId))
			return false;
		VAgpmId castOther = (VAgpmId) other;

		return (this.getAgpId() == castOther.getAgpId()) && (this.getAgpGesCode() == castOther.getAgpGesCode())
				&& ((this.getMinLibelleCourt() == castOther.getMinLibelleCourt())
						|| (this.getMinLibelleCourt() != null && castOther.getMinLibelleCourt() != null
								&& this.getMinLibelleCourt().equals(castOther.getMinLibelleCourt())))
				&& ((this.getMinLibelle() == castOther.getMinLibelle()) || (this.getMinLibelle() != null
						&& castOther.getMinLibelle() != null && this.getMinLibelle().equals(castOther.getMinLibelle())))
				&& ((this.getFonCod() == castOther.getFonCod()) || (this.getFonCod() != null
						&& castOther.getFonCod() != null && this.getFonCod().equals(castOther.getFonCod())))
				&& ((this.getAc() == castOther.getAc()) || (this.getAc() != null && castOther.getAc() != null
						&& this.getAc().equals(castOther.getAc())))
				&& ((this.getProLibelle() == castOther.getProLibelle()) || (this.getProLibelle() != null
						&& castOther.getProLibelle() != null && this.getProLibelle().equals(castOther.getProLibelle())))
				&& ((this.getAgpTypeDao() == castOther.getAgpTypeDao()) || (this.getAgpTypeDao() != null
						&& castOther.getAgpTypeDao() != null && this.getAgpTypeDao().equals(castOther.getAgpTypeDao())))
				&& ((this.getAgpModePassation() == castOther.getAgpModePassation())
						|| (this.getAgpModePassation() != null && castOther.getAgpModePassation() != null
								&& this.getAgpModePassation().equals(castOther.getAgpModePassation())))
				&& ((this.getProMontantTotCfa() == castOther.getProMontantTotCfa())
						|| (this.getProMontantTotCfa() != null && castOther.getProMontantTotCfa() != null
								&& this.getProMontantTotCfa().equals(castOther.getProMontantTotCfa())))
				&& ((this.getAgpStaCode() == castOther.getAgpStaCode()) || (this.getAgpStaCode() != null
						&& castOther.getAgpStaCode() != null && this.getAgpStaCode().equals(castOther.getAgpStaCode())))
				&& ((this.getAgpStrCode() == castOther.getAgpStrCode()) || (this.getAgpStrCode() != null
						&& castOther.getAgpStrCode() != null && this.getAgpStrCode().equals(castOther.getAgpStrCode())))
				&& ((this.getAgpActif() == castOther.getAgpActif()) || (this.getAgpActif() != null
						&& castOther.getAgpActif() != null && this.getAgpActif().equals(castOther.getAgpActif())))
				&& ((this.getAgpStatutRetour() == castOther.getAgpStatutRetour())
						|| (this.getAgpStatutRetour() != null && castOther.getAgpStatutRetour() != null
								&& this.getAgpStatutRetour().equals(castOther.getAgpStatutRetour())))
				&& ((this.getDecOrganExecLibelle() == castOther.getDecOrganExecLibelle())
						|| (this.getDecOrganExecLibelle() != null && castOther.getDecOrganExecLibelle() != null
								&& this.getDecOrganExecLibelle().equals(castOther.getDecOrganExecLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAgpId();
		result = 37 * result + this.getAgpGesCode();
		result = 37 * result + (getMinLibelleCourt() == null ? 0 : this.getMinLibelleCourt().hashCode());
		result = 37 * result + (getMinLibelle() == null ? 0 : this.getMinLibelle().hashCode());
		result = 37 * result + (getFonCod() == null ? 0 : this.getFonCod().hashCode());
		result = 37 * result + (getAc() == null ? 0 : this.getAc().hashCode());
		result = 37 * result + (getProLibelle() == null ? 0 : this.getProLibelle().hashCode());
		result = 37 * result + (getAgpTypeDao() == null ? 0 : this.getAgpTypeDao().hashCode());
		result = 37 * result + (getAgpModePassation() == null ? 0 : this.getAgpModePassation().hashCode());
		result = 37 * result + (getProMontantTotCfa() == null ? 0 : this.getProMontantTotCfa().hashCode());
		result = 37 * result + (getAgpStaCode() == null ? 0 : this.getAgpStaCode().hashCode());
		result = 37 * result + (getAgpStrCode() == null ? 0 : this.getAgpStrCode().hashCode());
		result = 37 * result + (getAgpActif() == null ? 0 : this.getAgpActif().hashCode());
		result = 37 * result + (getAgpStatutRetour() == null ? 0 : this.getAgpStatutRetour().hashCode());
		result = 37 * result + (getDecOrganExecLibelle() == null ? 0 : this.getDecOrganExecLibelle().hashCode());
		return result;
	}

}
