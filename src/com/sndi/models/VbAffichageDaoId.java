package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbAffichageDaoId generated by hbm2java
 */
@Embeddable
public class VbAffichageDaoId implements java.io.Serializable {

	private long affDaoId;
	private BigDecimal affDcsNum;
	private String affDacCode;
	private String affOpeMatricule;
	private String affStaCode;
	private String affStatutRetour;
	private Date affDacDteSaisi;
	private String affDacObjet;
	private String affDacTymCode;
	private String affDacMopCode;
	private BigDecimal affNbrOuv;
	private String affDacStrCode;
	private BigDecimal affDacGesCode;
	private String affDacFonCodeCpmp;
	private String affDacFonCodAc;
	private Date affDacDacDteValCpmp;
	private Date affDacDacDteValDmp;
	private String affDacTdCode;
	private BigDecimal affDacDppId;
	private Date affDacDateReception;
	private String affDacStatutRetour;
	private String affDacMention;
	private String affDacRecherche;
	private Date affDacValAc;
	private String affDacAvisBailleur;
	private Date affDacDateBailleur;
	private String affDacBailleur;
	private Long affDacCout;
	private String affDacTypePlan;
	private String affFonCodeDmp;
	private String affFonCodePf;

	public VbAffichageDaoId() {
	}

	public VbAffichageDaoId(long affDaoId, String affDacCode) {
		this.affDaoId = affDaoId;
		this.affDacCode = affDacCode;
	}

	public VbAffichageDaoId(long affDaoId, BigDecimal affDcsNum, String affDacCode, String affOpeMatricule,
			String affStaCode, String affStatutRetour, Date affDacDteSaisi, String affDacObjet, String affDacTymCode,
			String affDacMopCode, BigDecimal affNbrOuv, String affDacStrCode, BigDecimal affDacGesCode,
			String affDacFonCodeCpmp, String affDacFonCodAc, Date affDacDacDteValCpmp, Date affDacDacDteValDmp,
			String affDacTdCode, BigDecimal affDacDppId, Date affDacDateReception, String affDacStatutRetour,
			String affDacMention, String affDacRecherche, Date affDacValAc, String affDacAvisBailleur,
			Date affDacDateBailleur, String affDacBailleur, Long affDacCout, String affDacTypePlan,
			String affFonCodeDmp, String affFonCodePf) {
		this.affDaoId = affDaoId;
		this.affDcsNum = affDcsNum;
		this.affDacCode = affDacCode;
		this.affOpeMatricule = affOpeMatricule;
		this.affStaCode = affStaCode;
		this.affStatutRetour = affStatutRetour;
		this.affDacDteSaisi = affDacDteSaisi;
		this.affDacObjet = affDacObjet;
		this.affDacTymCode = affDacTymCode;
		this.affDacMopCode = affDacMopCode;
		this.affNbrOuv = affNbrOuv;
		this.affDacStrCode = affDacStrCode;
		this.affDacGesCode = affDacGesCode;
		this.affDacFonCodeCpmp = affDacFonCodeCpmp;
		this.affDacFonCodAc = affDacFonCodAc;
		this.affDacDacDteValCpmp = affDacDacDteValCpmp;
		this.affDacDacDteValDmp = affDacDacDteValDmp;
		this.affDacTdCode = affDacTdCode;
		this.affDacDppId = affDacDppId;
		this.affDacDateReception = affDacDateReception;
		this.affDacStatutRetour = affDacStatutRetour;
		this.affDacMention = affDacMention;
		this.affDacRecherche = affDacRecherche;
		this.affDacValAc = affDacValAc;
		this.affDacAvisBailleur = affDacAvisBailleur;
		this.affDacDateBailleur = affDacDateBailleur;
		this.affDacBailleur = affDacBailleur;
		this.affDacCout = affDacCout;
		this.affDacTypePlan = affDacTypePlan;
		this.affFonCodeDmp = affFonCodeDmp;
		this.affFonCodePf = affFonCodePf;
	}

	@Column(name = "AFF_DAO_ID", nullable = false, precision = 10, scale = 0)
	public long getAffDaoId() {
		return this.affDaoId;
	}

	public void setAffDaoId(long affDaoId) {
		this.affDaoId = affDaoId;
	}

	@Column(name = "AFF_DCS_NUM", precision = 22, scale = 0)
	public BigDecimal getAffDcsNum() {
		return this.affDcsNum;
	}

	public void setAffDcsNum(BigDecimal affDcsNum) {
		this.affDcsNum = affDcsNum;
	}

	@Column(name = "AFF_DAC_CODE", nullable = false, length = 20)
	public String getAffDacCode() {
		return this.affDacCode;
	}

	public void setAffDacCode(String affDacCode) {
		this.affDacCode = affDacCode;
	}

	@Column(name = "AFF_OPE_MATRICULE", length = 25)
	public String getAffOpeMatricule() {
		return this.affOpeMatricule;
	}

	public void setAffOpeMatricule(String affOpeMatricule) {
		this.affOpeMatricule = affOpeMatricule;
	}

	@Column(name = "AFF_STA_CODE", length = 3)
	public String getAffStaCode() {
		return this.affStaCode;
	}

	public void setAffStaCode(String affStaCode) {
		this.affStaCode = affStaCode;
	}

	@Column(name = "AFF_STATUT_RETOUR", length = 4)
	public String getAffStatutRetour() {
		return this.affStatutRetour;
	}

	public void setAffStatutRetour(String affStatutRetour) {
		this.affStatutRetour = affStatutRetour;
	}

	@Column(name = "AFF_DAC_DTE_SAISI", length = 7)
	public Date getAffDacDteSaisi() {
		return this.affDacDteSaisi;
	}

	public void setAffDacDteSaisi(Date affDacDteSaisi) {
		this.affDacDteSaisi = affDacDteSaisi;
	}

	@Column(name = "AFF_DAC_OBJET", length = 1000)
	public String getAffDacObjet() {
		return this.affDacObjet;
	}

	public void setAffDacObjet(String affDacObjet) {
		this.affDacObjet = affDacObjet;
	}

	@Column(name = "AFF_DAC_TYM_CODE", length = 5)
	public String getAffDacTymCode() {
		return this.affDacTymCode;
	}

	public void setAffDacTymCode(String affDacTymCode) {
		this.affDacTymCode = affDacTymCode;
	}

	@Column(name = "AFF_DAC_MOP_CODE", length = 3)
	public String getAffDacMopCode() {
		return this.affDacMopCode;
	}

	public void setAffDacMopCode(String affDacMopCode) {
		this.affDacMopCode = affDacMopCode;
	}

	@Column(name = "AFF_NBR_OUV", precision = 22, scale = 0)
	public BigDecimal getAffNbrOuv() {
		return this.affNbrOuv;
	}

	public void setAffNbrOuv(BigDecimal affNbrOuv) {
		this.affNbrOuv = affNbrOuv;
	}

	@Column(name = "AFF_DAC_STR_CODE", length = 20)
	public String getAffDacStrCode() {
		return this.affDacStrCode;
	}

	public void setAffDacStrCode(String affDacStrCode) {
		this.affDacStrCode = affDacStrCode;
	}

	@Column(name = "AFF_DAC_GES_CODE", precision = 22, scale = 0)
	public BigDecimal getAffDacGesCode() {
		return this.affDacGesCode;
	}

	public void setAffDacGesCode(BigDecimal affDacGesCode) {
		this.affDacGesCode = affDacGesCode;
	}

	@Column(name = "AFF_DAC_FON_CODE_CPMP", length = 12)
	public String getAffDacFonCodeCpmp() {
		return this.affDacFonCodeCpmp;
	}

	public void setAffDacFonCodeCpmp(String affDacFonCodeCpmp) {
		this.affDacFonCodeCpmp = affDacFonCodeCpmp;
	}

	@Column(name = "AFF_DAC_FON_COD_AC", length = 12)
	public String getAffDacFonCodAc() {
		return this.affDacFonCodAc;
	}

	public void setAffDacFonCodAc(String affDacFonCodAc) {
		this.affDacFonCodAc = affDacFonCodAc;
	}

	@Column(name = "AFF_DAC_DAC_DTE_VAL_CPMP", length = 7)
	public Date getAffDacDacDteValCpmp() {
		return this.affDacDacDteValCpmp;
	}

	public void setAffDacDacDteValCpmp(Date affDacDacDteValCpmp) {
		this.affDacDacDteValCpmp = affDacDacDteValCpmp;
	}

	@Column(name = "AFF_DAC_DAC_DTE_VAL_DMP", length = 7)
	public Date getAffDacDacDteValDmp() {
		return this.affDacDacDteValDmp;
	}

	public void setAffDacDacDteValDmp(Date affDacDacDteValDmp) {
		this.affDacDacDteValDmp = affDacDacDteValDmp;
	}

	@Column(name = "AFF_DAC_TD_CODE", length = 3)
	public String getAffDacTdCode() {
		return this.affDacTdCode;
	}

	public void setAffDacTdCode(String affDacTdCode) {
		this.affDacTdCode = affDacTdCode;
	}

	@Column(name = "AFF_DAC_DPP_ID", precision = 20, scale = 0)
	public BigDecimal getAffDacDppId() {
		return this.affDacDppId;
	}

	public void setAffDacDppId(BigDecimal affDacDppId) {
		this.affDacDppId = affDacDppId;
	}

	@Column(name = "AFF_DAC_DATE_RECEPTION", length = 7)
	public Date getAffDacDateReception() {
		return this.affDacDateReception;
	}

	public void setAffDacDateReception(Date affDacDateReception) {
		this.affDacDateReception = affDacDateReception;
	}

	@Column(name = "AFF_DAC_STATUT_RETOUR", length = 2)
	public String getAffDacStatutRetour() {
		return this.affDacStatutRetour;
	}

	public void setAffDacStatutRetour(String affDacStatutRetour) {
		this.affDacStatutRetour = affDacStatutRetour;
	}

	@Column(name = "AFF_DAC_MENTION", length = 100)
	public String getAffDacMention() {
		return this.affDacMention;
	}

	public void setAffDacMention(String affDacMention) {
		this.affDacMention = affDacMention;
	}

	@Column(name = "AFF_DAC_RECHERCHE", length = 4000)
	public String getAffDacRecherche() {
		return this.affDacRecherche;
	}

	public void setAffDacRecherche(String affDacRecherche) {
		this.affDacRecherche = affDacRecherche;
	}

	@Column(name = "AFF_DAC_VAL_AC", length = 7)
	public Date getAffDacValAc() {
		return this.affDacValAc;
	}

	public void setAffDacValAc(Date affDacValAc) {
		this.affDacValAc = affDacValAc;
	}

	@Column(name = "AFF_DAC_AVIS_BAILLEUR", length = 4000)
	public String getAffDacAvisBailleur() {
		return this.affDacAvisBailleur;
	}

	public void setAffDacAvisBailleur(String affDacAvisBailleur) {
		this.affDacAvisBailleur = affDacAvisBailleur;
	}

	@Column(name = "AFF_DAC_DATE_BAILLEUR", length = 7)
	public Date getAffDacDateBailleur() {
		return this.affDacDateBailleur;
	}

	public void setAffDacDateBailleur(Date affDacDateBailleur) {
		this.affDacDateBailleur = affDacDateBailleur;
	}

	@Column(name = "AFF_DAC_BAILLEUR", length = 1)
	public String getAffDacBailleur() {
		return this.affDacBailleur;
	}

	public void setAffDacBailleur(String affDacBailleur) {
		this.affDacBailleur = affDacBailleur;
	}

	@Column(name = "AFF_DAC_COUT", precision = 11, scale = 0)
	public Long getAffDacCout() {
		return this.affDacCout;
	}

	public void setAffDacCout(Long affDacCout) {
		this.affDacCout = affDacCout;
	}

	@Column(name = "AFF_DAC_TYPE_PLAN", length = 4)
	public String getAffDacTypePlan() {
		return this.affDacTypePlan;
	}

	public void setAffDacTypePlan(String affDacTypePlan) {
		this.affDacTypePlan = affDacTypePlan;
	}

	@Column(name = "AFF_FON_CODE_DMP", length = 20)
	public String getAffFonCodeDmp() {
		return this.affFonCodeDmp;
	}

	public void setAffFonCodeDmp(String affFonCodeDmp) {
		this.affFonCodeDmp = affFonCodeDmp;
	}

	@Column(name = "AFF_FON_CODE_PF", length = 20)
	public String getAffFonCodePf() {
		return this.affFonCodePf;
	}

	public void setAffFonCodePf(String affFonCodePf) {
		this.affFonCodePf = affFonCodePf;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbAffichageDaoId))
			return false;
		VbAffichageDaoId castOther = (VbAffichageDaoId) other;

		return (this.getAffDaoId() == castOther.getAffDaoId())
				&& ((this.getAffDcsNum() == castOther.getAffDcsNum()) || (this.getAffDcsNum() != null
						&& castOther.getAffDcsNum() != null && this.getAffDcsNum().equals(castOther.getAffDcsNum())))
				&& ((this.getAffDacCode() == castOther.getAffDacCode()) || (this.getAffDacCode() != null
						&& castOther.getAffDacCode() != null && this.getAffDacCode().equals(castOther.getAffDacCode())))
				&& ((this.getAffOpeMatricule() == castOther.getAffOpeMatricule())
						|| (this.getAffOpeMatricule() != null && castOther.getAffOpeMatricule() != null
								&& this.getAffOpeMatricule().equals(castOther.getAffOpeMatricule())))
				&& ((this.getAffStaCode() == castOther.getAffStaCode()) || (this.getAffStaCode() != null
						&& castOther.getAffStaCode() != null && this.getAffStaCode().equals(castOther.getAffStaCode())))
				&& ((this.getAffStatutRetour() == castOther.getAffStatutRetour())
						|| (this.getAffStatutRetour() != null && castOther.getAffStatutRetour() != null
								&& this.getAffStatutRetour().equals(castOther.getAffStatutRetour())))
				&& ((this.getAffDacDteSaisi() == castOther.getAffDacDteSaisi())
						|| (this.getAffDacDteSaisi() != null && castOther.getAffDacDteSaisi() != null
								&& this.getAffDacDteSaisi().equals(castOther.getAffDacDteSaisi())))
				&& ((this.getAffDacObjet() == castOther.getAffDacObjet())
						|| (this.getAffDacObjet() != null && castOther.getAffDacObjet() != null
								&& this.getAffDacObjet().equals(castOther.getAffDacObjet())))
				&& ((this.getAffDacTymCode() == castOther.getAffDacTymCode())
						|| (this.getAffDacTymCode() != null && castOther.getAffDacTymCode() != null
								&& this.getAffDacTymCode().equals(castOther.getAffDacTymCode())))
				&& ((this.getAffDacMopCode() == castOther.getAffDacMopCode())
						|| (this.getAffDacMopCode() != null && castOther.getAffDacMopCode() != null
								&& this.getAffDacMopCode().equals(castOther.getAffDacMopCode())))
				&& ((this.getAffNbrOuv() == castOther.getAffNbrOuv()) || (this.getAffNbrOuv() != null
						&& castOther.getAffNbrOuv() != null && this.getAffNbrOuv().equals(castOther.getAffNbrOuv())))
				&& ((this.getAffDacStrCode() == castOther.getAffDacStrCode())
						|| (this.getAffDacStrCode() != null && castOther.getAffDacStrCode() != null
								&& this.getAffDacStrCode().equals(castOther.getAffDacStrCode())))
				&& ((this.getAffDacGesCode() == castOther.getAffDacGesCode())
						|| (this.getAffDacGesCode() != null && castOther.getAffDacGesCode() != null
								&& this.getAffDacGesCode().equals(castOther.getAffDacGesCode())))
				&& ((this.getAffDacFonCodeCpmp() == castOther.getAffDacFonCodeCpmp())
						|| (this.getAffDacFonCodeCpmp() != null && castOther.getAffDacFonCodeCpmp() != null
								&& this.getAffDacFonCodeCpmp().equals(castOther.getAffDacFonCodeCpmp())))
				&& ((this.getAffDacFonCodAc() == castOther.getAffDacFonCodAc())
						|| (this.getAffDacFonCodAc() != null && castOther.getAffDacFonCodAc() != null
								&& this.getAffDacFonCodAc().equals(castOther.getAffDacFonCodAc())))
				&& ((this.getAffDacDacDteValCpmp() == castOther.getAffDacDacDteValCpmp())
						|| (this.getAffDacDacDteValCpmp() != null && castOther.getAffDacDacDteValCpmp() != null
								&& this.getAffDacDacDteValCpmp().equals(castOther.getAffDacDacDteValCpmp())))
				&& ((this.getAffDacDacDteValDmp() == castOther.getAffDacDacDteValDmp())
						|| (this.getAffDacDacDteValDmp() != null && castOther.getAffDacDacDteValDmp() != null
								&& this.getAffDacDacDteValDmp().equals(castOther.getAffDacDacDteValDmp())))
				&& ((this.getAffDacTdCode() == castOther.getAffDacTdCode())
						|| (this.getAffDacTdCode() != null && castOther.getAffDacTdCode() != null
								&& this.getAffDacTdCode().equals(castOther.getAffDacTdCode())))
				&& ((this.getAffDacDppId() == castOther.getAffDacDppId())
						|| (this.getAffDacDppId() != null && castOther.getAffDacDppId() != null
								&& this.getAffDacDppId().equals(castOther.getAffDacDppId())))
				&& ((this.getAffDacDateReception() == castOther.getAffDacDateReception())
						|| (this.getAffDacDateReception() != null && castOther.getAffDacDateReception() != null
								&& this.getAffDacDateReception().equals(castOther.getAffDacDateReception())))
				&& ((this.getAffDacStatutRetour() == castOther.getAffDacStatutRetour())
						|| (this.getAffDacStatutRetour() != null && castOther.getAffDacStatutRetour() != null
								&& this.getAffDacStatutRetour().equals(castOther.getAffDacStatutRetour())))
				&& ((this.getAffDacMention() == castOther.getAffDacMention())
						|| (this.getAffDacMention() != null && castOther.getAffDacMention() != null
								&& this.getAffDacMention().equals(castOther.getAffDacMention())))
				&& ((this.getAffDacRecherche() == castOther.getAffDacRecherche())
						|| (this.getAffDacRecherche() != null && castOther.getAffDacRecherche() != null
								&& this.getAffDacRecherche().equals(castOther.getAffDacRecherche())))
				&& ((this.getAffDacValAc() == castOther.getAffDacValAc())
						|| (this.getAffDacValAc() != null && castOther.getAffDacValAc() != null
								&& this.getAffDacValAc().equals(castOther.getAffDacValAc())))
				&& ((this.getAffDacAvisBailleur() == castOther.getAffDacAvisBailleur())
						|| (this.getAffDacAvisBailleur() != null && castOther.getAffDacAvisBailleur() != null
								&& this.getAffDacAvisBailleur().equals(castOther.getAffDacAvisBailleur())))
				&& ((this.getAffDacDateBailleur() == castOther.getAffDacDateBailleur())
						|| (this.getAffDacDateBailleur() != null && castOther.getAffDacDateBailleur() != null
								&& this.getAffDacDateBailleur().equals(castOther.getAffDacDateBailleur())))
				&& ((this.getAffDacBailleur() == castOther.getAffDacBailleur())
						|| (this.getAffDacBailleur() != null && castOther.getAffDacBailleur() != null
								&& this.getAffDacBailleur().equals(castOther.getAffDacBailleur())))
				&& ((this.getAffDacCout() == castOther.getAffDacCout()) || (this.getAffDacCout() != null
						&& castOther.getAffDacCout() != null && this.getAffDacCout().equals(castOther.getAffDacCout())))
				&& ((this.getAffDacTypePlan() == castOther.getAffDacTypePlan())
						|| (this.getAffDacTypePlan() != null && castOther.getAffDacTypePlan() != null
								&& this.getAffDacTypePlan().equals(castOther.getAffDacTypePlan())))
				&& ((this.getAffFonCodeDmp() == castOther.getAffFonCodeDmp())
						|| (this.getAffFonCodeDmp() != null && castOther.getAffFonCodeDmp() != null
								&& this.getAffFonCodeDmp().equals(castOther.getAffFonCodeDmp())))
				&& ((this.getAffFonCodePf() == castOther.getAffFonCodePf())
						|| (this.getAffFonCodePf() != null && castOther.getAffFonCodePf() != null
								&& this.getAffFonCodePf().equals(castOther.getAffFonCodePf())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAffDaoId();
		result = 37 * result + (getAffDcsNum() == null ? 0 : this.getAffDcsNum().hashCode());
		result = 37 * result + (getAffDacCode() == null ? 0 : this.getAffDacCode().hashCode());
		result = 37 * result + (getAffOpeMatricule() == null ? 0 : this.getAffOpeMatricule().hashCode());
		result = 37 * result + (getAffStaCode() == null ? 0 : this.getAffStaCode().hashCode());
		result = 37 * result + (getAffStatutRetour() == null ? 0 : this.getAffStatutRetour().hashCode());
		result = 37 * result + (getAffDacDteSaisi() == null ? 0 : this.getAffDacDteSaisi().hashCode());
		result = 37 * result + (getAffDacObjet() == null ? 0 : this.getAffDacObjet().hashCode());
		result = 37 * result + (getAffDacTymCode() == null ? 0 : this.getAffDacTymCode().hashCode());
		result = 37 * result + (getAffDacMopCode() == null ? 0 : this.getAffDacMopCode().hashCode());
		result = 37 * result + (getAffNbrOuv() == null ? 0 : this.getAffNbrOuv().hashCode());
		result = 37 * result + (getAffDacStrCode() == null ? 0 : this.getAffDacStrCode().hashCode());
		result = 37 * result + (getAffDacGesCode() == null ? 0 : this.getAffDacGesCode().hashCode());
		result = 37 * result + (getAffDacFonCodeCpmp() == null ? 0 : this.getAffDacFonCodeCpmp().hashCode());
		result = 37 * result + (getAffDacFonCodAc() == null ? 0 : this.getAffDacFonCodAc().hashCode());
		result = 37 * result + (getAffDacDacDteValCpmp() == null ? 0 : this.getAffDacDacDteValCpmp().hashCode());
		result = 37 * result + (getAffDacDacDteValDmp() == null ? 0 : this.getAffDacDacDteValDmp().hashCode());
		result = 37 * result + (getAffDacTdCode() == null ? 0 : this.getAffDacTdCode().hashCode());
		result = 37 * result + (getAffDacDppId() == null ? 0 : this.getAffDacDppId().hashCode());
		result = 37 * result + (getAffDacDateReception() == null ? 0 : this.getAffDacDateReception().hashCode());
		result = 37 * result + (getAffDacStatutRetour() == null ? 0 : this.getAffDacStatutRetour().hashCode());
		result = 37 * result + (getAffDacMention() == null ? 0 : this.getAffDacMention().hashCode());
		result = 37 * result + (getAffDacRecherche() == null ? 0 : this.getAffDacRecherche().hashCode());
		result = 37 * result + (getAffDacValAc() == null ? 0 : this.getAffDacValAc().hashCode());
		result = 37 * result + (getAffDacAvisBailleur() == null ? 0 : this.getAffDacAvisBailleur().hashCode());
		result = 37 * result + (getAffDacDateBailleur() == null ? 0 : this.getAffDacDateBailleur().hashCode());
		result = 37 * result + (getAffDacBailleur() == null ? 0 : this.getAffDacBailleur().hashCode());
		result = 37 * result + (getAffDacCout() == null ? 0 : this.getAffDacCout().hashCode());
		result = 37 * result + (getAffDacTypePlan() == null ? 0 : this.getAffDacTypePlan().hashCode());
		result = 37 * result + (getAffFonCodeDmp() == null ? 0 : this.getAffFonCodeDmp().hashCode());
		result = 37 * result + (getAffFonCodePf() == null ? 0 : this.getAffFonCodePf().hashCode());
		return result;
	}

}
