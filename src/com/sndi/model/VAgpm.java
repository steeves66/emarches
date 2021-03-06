package com.sndi.model;
// Generated 4 f?vr. 2020 12:07:17 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VAgpmId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_AGPM")
public class VAgpm implements java.io.Serializable {

	private long agpId;
	private long agpGesCode;
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

	public VAgpm() {
	}

	public VAgpm(long agpId, long agpGesCode, String fonCod, String agpStaCode, String agpStrCode,
			String decOrganExecLibelle) {
		this.agpId = agpId;
		this.agpGesCode = agpGesCode;
		this.fonCod = fonCod;
		this.agpStaCode = agpStaCode;
		this.agpStrCode = agpStrCode;
		this.decOrganExecLibelle = decOrganExecLibelle;
	}

	public VAgpm(long agpId, long  agpGesCode, String minLibelleCourt, String minLibelle, String fonCod, String ac,
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

	
	@Id
	@Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpId() {
		return this.agpId;
	}

	public void setAgpId(long agpId) {
		this.agpId = agpId;
	}

	@Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)
	public long  getAgpGesCode() {
		return this.agpGesCode;
	}

	public void setAgpGesCode(long agpGesCode) {
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

	@Column(name = "FON_COD", nullable = false, length = 12)
	public String getFonCod() {
		return this.fonCod;
	}

	public void setFonCod(String fonCod) {
		this.fonCod = fonCod;
	}

	@Column(name = "AC")
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


}
