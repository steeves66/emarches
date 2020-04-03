package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDaoChargeEtudeId generated by hbm2java
 */
@Embeddable
public class VDaoChargeEtudeId implements java.io.Serializable {

	private String dacCode;
	private String dacObjet;
	private Date dacDteSaisi;
	private String dacStaCode;
	private String dacTymCode;
	private String dacTypePlan;
	private String dacMopCode;
	private BigDecimal dacNbrOuv;
	private BigDecimal dacGesCode;
	private String dacFonCodAc;
	private String dacStrCode;
	private String dacFonCodeCpmp;
	private Date dacDteValCpmp;
	private Date dacDteValDmp;
	private String dacTdCode;
	private Date dacDateReception;
	private String dacStatutRetour;
	private String dacMention;
	private String dacRecherche;
	private String dcsOpeMatricule;
	private String dcsPreMbm;
	private String dcsComStrCode;
	private String dcsMbmRespo;
	private String dcsFonCod;
	private String tdcLibelle;
	private String tymLibelleCourt;
	private String mopLibelleLong;

	public VDaoChargeEtudeId() {
	}

	public VDaoChargeEtudeId(String dacCode, String tymLibelleCourt) {
		this.dacCode = dacCode;
		this.tymLibelleCourt = tymLibelleCourt;
	}

	public VDaoChargeEtudeId(String dacCode, String dacObjet, Date dacDteSaisi, String dacStaCode, String dacTymCode,
			String dacTypePlan, String dacMopCode, BigDecimal dacNbrOuv, BigDecimal dacGesCode, String dacFonCodAc,
			String dacStrCode, String dacFonCodeCpmp, Date dacDteValCpmp, Date dacDteValDmp, String dacTdCode,
			Date dacDateReception, String dacStatutRetour, String dacMention, String dacRecherche,
			String dcsOpeMatricule, String dcsPreMbm, String dcsComStrCode, String dcsMbmRespo, String dcsFonCod,
			String tdcLibelle, String tymLibelleCourt, String mopLibelleLong) {
		this.dacCode = dacCode;
		this.dacObjet = dacObjet;
		this.dacDteSaisi = dacDteSaisi;
		this.dacStaCode = dacStaCode;
		this.dacTymCode = dacTymCode;
		this.dacTypePlan = dacTypePlan;
		this.dacMopCode = dacMopCode;
		this.dacNbrOuv = dacNbrOuv;
		this.dacGesCode = dacGesCode;
		this.dacFonCodAc = dacFonCodAc;
		this.dacStrCode = dacStrCode;
		this.dacFonCodeCpmp = dacFonCodeCpmp;
		this.dacDteValCpmp = dacDteValCpmp;
		this.dacDteValDmp = dacDteValDmp;
		this.dacTdCode = dacTdCode;
		this.dacDateReception = dacDateReception;
		this.dacStatutRetour = dacStatutRetour;
		this.dacMention = dacMention;
		this.dacRecherche = dacRecherche;
		this.dcsOpeMatricule = dcsOpeMatricule;
		this.dcsPreMbm = dcsPreMbm;
		this.dcsComStrCode = dcsComStrCode;
		this.dcsMbmRespo = dcsMbmRespo;
		this.dcsFonCod = dcsFonCod;
		this.tdcLibelle = tdcLibelle;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
	}

	@Column(name = "DAC_CODE", nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	@Column(name = "DAC_OBJET", length = 1000)
	public String getDacObjet() {
		return this.dacObjet;
	}

	public void setDacObjet(String dacObjet) {
		this.dacObjet = dacObjet;
	}

	@Column(name = "DAC_DTE_SAISI", length = 7)
	public Date getDacDteSaisi() {
		return this.dacDteSaisi;
	}

	public void setDacDteSaisi(Date dacDteSaisi) {
		this.dacDteSaisi = dacDteSaisi;
	}

	@Column(name = "DAC_STA_CODE", length = 3)
	public String getDacStaCode() {
		return this.dacStaCode;
	}

	public void setDacStaCode(String dacStaCode) {
		this.dacStaCode = dacStaCode;
	}

	@Column(name = "DAC_TYM_CODE", length = 5)
	public String getDacTymCode() {
		return this.dacTymCode;
	}

	public void setDacTymCode(String dacTymCode) {
		this.dacTymCode = dacTymCode;
	}

	@Column(name = "DAC_TYPE_PLAN", length = 4)
	public String getDacTypePlan() {
		return this.dacTypePlan;
	}

	public void setDacTypePlan(String dacTypePlan) {
		this.dacTypePlan = dacTypePlan;
	}

	@Column(name = "DAC_MOP_CODE", length = 3)
	public String getDacMopCode() {
		return this.dacMopCode;
	}

	public void setDacMopCode(String dacMopCode) {
		this.dacMopCode = dacMopCode;
	}

	@Column(name = "DAC_NBR_OUV", precision = 22, scale = 0)
	public BigDecimal getDacNbrOuv() {
		return this.dacNbrOuv;
	}

	public void setDacNbrOuv(BigDecimal dacNbrOuv) {
		this.dacNbrOuv = dacNbrOuv;
	}

	@Column(name = "DAC_GES_CODE", precision = 22, scale = 0)
	public BigDecimal getDacGesCode() {
		return this.dacGesCode;
	}

	public void setDacGesCode(BigDecimal dacGesCode) {
		this.dacGesCode = dacGesCode;
	}

	@Column(name = "DAC_FON_COD_AC", length = 12)
	public String getDacFonCodAc() {
		return this.dacFonCodAc;
	}

	public void setDacFonCodAc(String dacFonCodAc) {
		this.dacFonCodAc = dacFonCodAc;
	}

	@Column(name = "DAC_STR_CODE", length = 3)
	public String getDacStrCode() {
		return this.dacStrCode;
	}

	public void setDacStrCode(String dacStrCode) {
		this.dacStrCode = dacStrCode;
	}

	@Column(name = "DAC_FON_CODE_CPMP", length = 12)
	public String getDacFonCodeCpmp() {
		return this.dacFonCodeCpmp;
	}

	public void setDacFonCodeCpmp(String dacFonCodeCpmp) {
		this.dacFonCodeCpmp = dacFonCodeCpmp;
	}

	@Column(name = "DAC_DTE_VAL_CPMP", length = 7)
	public Date getDacDteValCpmp() {
		return this.dacDteValCpmp;
	}

	public void setDacDteValCpmp(Date dacDteValCpmp) {
		this.dacDteValCpmp = dacDteValCpmp;
	}

	@Column(name = "DAC_DTE_VAL_DMP", length = 7)
	public Date getDacDteValDmp() {
		return this.dacDteValDmp;
	}

	public void setDacDteValDmp(Date dacDteValDmp) {
		this.dacDteValDmp = dacDteValDmp;
	}

	@Column(name = "DAC_TD_CODE", length = 3)
	public String getDacTdCode() {
		return this.dacTdCode;
	}

	public void setDacTdCode(String dacTdCode) {
		this.dacTdCode = dacTdCode;
	}

	@Column(name = "DAC_DATE_RECEPTION", length = 7)
	public Date getDacDateReception() {
		return this.dacDateReception;
	}

	public void setDacDateReception(Date dacDateReception) {
		this.dacDateReception = dacDateReception;
	}

	@Column(name = "DAC_STATUT_RETOUR", length = 2)
	public String getDacStatutRetour() {
		return this.dacStatutRetour;
	}

	public void setDacStatutRetour(String dacStatutRetour) {
		this.dacStatutRetour = dacStatutRetour;
	}

	@Column(name = "DAC_MENTION", length = 100)
	public String getDacMention() {
		return this.dacMention;
	}

	public void setDacMention(String dacMention) {
		this.dacMention = dacMention;
	}

	@Column(name = "DAC_RECHERCHE", length = 4000)
	public String getDacRecherche() {
		return this.dacRecherche;
	}

	public void setDacRecherche(String dacRecherche) {
		this.dacRecherche = dacRecherche;
	}

	@Column(name = "DCS_OPE_MATRICULE", length = 20)
	public String getDcsOpeMatricule() {
		return this.dcsOpeMatricule;
	}

	public void setDcsOpeMatricule(String dcsOpeMatricule) {
		this.dcsOpeMatricule = dcsOpeMatricule;
	}

	@Column(name = "DCS_PRE_MBM", length = 200)
	public String getDcsPreMbm() {
		return this.dcsPreMbm;
	}

	public void setDcsPreMbm(String dcsPreMbm) {
		this.dcsPreMbm = dcsPreMbm;
	}

	@Column(name = "DCS_COM_STR_CODE", length = 20)
	public String getDcsComStrCode() {
		return this.dcsComStrCode;
	}

	public void setDcsComStrCode(String dcsComStrCode) {
		this.dcsComStrCode = dcsComStrCode;
	}

	@Column(name = "DCS_MBM_RESPO", length = 1)
	public String getDcsMbmRespo() {
		return this.dcsMbmRespo;
	}

	public void setDcsMbmRespo(String dcsMbmRespo) {
		this.dcsMbmRespo = dcsMbmRespo;
	}

	@Column(name = "DCS_FON_COD", length = 100)
	public String getDcsFonCod() {
		return this.dcsFonCod;
	}

	public void setDcsFonCod(String dcsFonCod) {
		this.dcsFonCod = dcsFonCod;
	}

	@Column(name = "TDC_LIBELLE", length = 1000)
	public String getTdcLibelle() {
		return this.tdcLibelle;
	}

	public void setTdcLibelle(String tdcLibelle) {
		this.tdcLibelle = tdcLibelle;
	}

	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}

	@Column(name = "MOP_LIBELLE_LONG", length = 1000)
	public String getMopLibelleLong() {
		return this.mopLibelleLong;
	}

	public void setMopLibelleLong(String mopLibelleLong) {
		this.mopLibelleLong = mopLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDaoChargeEtudeId))
			return false;
		VDaoChargeEtudeId castOther = (VDaoChargeEtudeId) other;

		return ((this.getDacCode() == castOther.getDacCode()) || (this.getDacCode() != null
				&& castOther.getDacCode() != null && this.getDacCode().equals(castOther.getDacCode())))
				&& ((this.getDacObjet() == castOther.getDacObjet()) || (this.getDacObjet() != null
						&& castOther.getDacObjet() != null && this.getDacObjet().equals(castOther.getDacObjet())))
				&& ((this.getDacDteSaisi() == castOther.getDacDteSaisi())
						|| (this.getDacDteSaisi() != null && castOther.getDacDteSaisi() != null
								&& this.getDacDteSaisi().equals(castOther.getDacDteSaisi())))
				&& ((this.getDacStaCode() == castOther.getDacStaCode()) || (this.getDacStaCode() != null
						&& castOther.getDacStaCode() != null && this.getDacStaCode().equals(castOther.getDacStaCode())))
				&& ((this.getDacTymCode() == castOther.getDacTymCode()) || (this.getDacTymCode() != null
						&& castOther.getDacTymCode() != null && this.getDacTymCode().equals(castOther.getDacTymCode())))
				&& ((this.getDacTypePlan() == castOther.getDacTypePlan())
						|| (this.getDacTypePlan() != null && castOther.getDacTypePlan() != null
								&& this.getDacTypePlan().equals(castOther.getDacTypePlan())))
				&& ((this.getDacMopCode() == castOther.getDacMopCode()) || (this.getDacMopCode() != null
						&& castOther.getDacMopCode() != null && this.getDacMopCode().equals(castOther.getDacMopCode())))
				&& ((this.getDacNbrOuv() == castOther.getDacNbrOuv()) || (this.getDacNbrOuv() != null
						&& castOther.getDacNbrOuv() != null && this.getDacNbrOuv().equals(castOther.getDacNbrOuv())))
				&& ((this.getDacGesCode() == castOther.getDacGesCode()) || (this.getDacGesCode() != null
						&& castOther.getDacGesCode() != null && this.getDacGesCode().equals(castOther.getDacGesCode())))
				&& ((this.getDacFonCodAc() == castOther.getDacFonCodAc())
						|| (this.getDacFonCodAc() != null && castOther.getDacFonCodAc() != null
								&& this.getDacFonCodAc().equals(castOther.getDacFonCodAc())))
				&& ((this.getDacStrCode() == castOther.getDacStrCode()) || (this.getDacStrCode() != null
						&& castOther.getDacStrCode() != null && this.getDacStrCode().equals(castOther.getDacStrCode())))
				&& ((this.getDacFonCodeCpmp() == castOther.getDacFonCodeCpmp())
						|| (this.getDacFonCodeCpmp() != null && castOther.getDacFonCodeCpmp() != null
								&& this.getDacFonCodeCpmp().equals(castOther.getDacFonCodeCpmp())))
				&& ((this.getDacDteValCpmp() == castOther.getDacDteValCpmp())
						|| (this.getDacDteValCpmp() != null && castOther.getDacDteValCpmp() != null
								&& this.getDacDteValCpmp().equals(castOther.getDacDteValCpmp())))
				&& ((this.getDacDteValDmp() == castOther.getDacDteValDmp())
						|| (this.getDacDteValDmp() != null && castOther.getDacDteValDmp() != null
								&& this.getDacDteValDmp().equals(castOther.getDacDteValDmp())))
				&& ((this.getDacTdCode() == castOther.getDacTdCode()) || (this.getDacTdCode() != null
						&& castOther.getDacTdCode() != null && this.getDacTdCode().equals(castOther.getDacTdCode())))
				&& ((this.getDacDateReception() == castOther.getDacDateReception())
						|| (this.getDacDateReception() != null && castOther.getDacDateReception() != null
								&& this.getDacDateReception().equals(castOther.getDacDateReception())))
				&& ((this.getDacStatutRetour() == castOther.getDacStatutRetour())
						|| (this.getDacStatutRetour() != null && castOther.getDacStatutRetour() != null
								&& this.getDacStatutRetour().equals(castOther.getDacStatutRetour())))
				&& ((this.getDacMention() == castOther.getDacMention()) || (this.getDacMention() != null
						&& castOther.getDacMention() != null && this.getDacMention().equals(castOther.getDacMention())))
				&& ((this.getDacRecherche() == castOther.getDacRecherche())
						|| (this.getDacRecherche() != null && castOther.getDacRecherche() != null
								&& this.getDacRecherche().equals(castOther.getDacRecherche())))
				&& ((this.getDcsOpeMatricule() == castOther.getDcsOpeMatricule())
						|| (this.getDcsOpeMatricule() != null && castOther.getDcsOpeMatricule() != null
								&& this.getDcsOpeMatricule().equals(castOther.getDcsOpeMatricule())))
				&& ((this.getDcsPreMbm() == castOther.getDcsPreMbm()) || (this.getDcsPreMbm() != null
						&& castOther.getDcsPreMbm() != null && this.getDcsPreMbm().equals(castOther.getDcsPreMbm())))
				&& ((this.getDcsComStrCode() == castOther.getDcsComStrCode())
						|| (this.getDcsComStrCode() != null && castOther.getDcsComStrCode() != null
								&& this.getDcsComStrCode().equals(castOther.getDcsComStrCode())))
				&& ((this.getDcsMbmRespo() == castOther.getDcsMbmRespo())
						|| (this.getDcsMbmRespo() != null && castOther.getDcsMbmRespo() != null
								&& this.getDcsMbmRespo().equals(castOther.getDcsMbmRespo())))
				&& ((this.getDcsFonCod() == castOther.getDcsFonCod()) || (this.getDcsFonCod() != null
						&& castOther.getDcsFonCod() != null && this.getDcsFonCod().equals(castOther.getDcsFonCod())))
				&& ((this.getTdcLibelle() == castOther.getTdcLibelle()) || (this.getTdcLibelle() != null
						&& castOther.getTdcLibelle() != null && this.getTdcLibelle().equals(castOther.getTdcLibelle())))
				&& ((this.getTymLibelleCourt() == castOther.getTymLibelleCourt())
						|| (this.getTymLibelleCourt() != null && castOther.getTymLibelleCourt() != null
								&& this.getTymLibelleCourt().equals(castOther.getTymLibelleCourt())))
				&& ((this.getMopLibelleLong() == castOther.getMopLibelleLong())
						|| (this.getMopLibelleLong() != null && castOther.getMopLibelleLong() != null
								&& this.getMopLibelleLong().equals(castOther.getMopLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDacCode() == null ? 0 : this.getDacCode().hashCode());
		result = 37 * result + (getDacObjet() == null ? 0 : this.getDacObjet().hashCode());
		result = 37 * result + (getDacDteSaisi() == null ? 0 : this.getDacDteSaisi().hashCode());
		result = 37 * result + (getDacStaCode() == null ? 0 : this.getDacStaCode().hashCode());
		result = 37 * result + (getDacTymCode() == null ? 0 : this.getDacTymCode().hashCode());
		result = 37 * result + (getDacTypePlan() == null ? 0 : this.getDacTypePlan().hashCode());
		result = 37 * result + (getDacMopCode() == null ? 0 : this.getDacMopCode().hashCode());
		result = 37 * result + (getDacNbrOuv() == null ? 0 : this.getDacNbrOuv().hashCode());
		result = 37 * result + (getDacGesCode() == null ? 0 : this.getDacGesCode().hashCode());
		result = 37 * result + (getDacFonCodAc() == null ? 0 : this.getDacFonCodAc().hashCode());
		result = 37 * result + (getDacStrCode() == null ? 0 : this.getDacStrCode().hashCode());
		result = 37 * result + (getDacFonCodeCpmp() == null ? 0 : this.getDacFonCodeCpmp().hashCode());
		result = 37 * result + (getDacDteValCpmp() == null ? 0 : this.getDacDteValCpmp().hashCode());
		result = 37 * result + (getDacDteValDmp() == null ? 0 : this.getDacDteValDmp().hashCode());
		result = 37 * result + (getDacTdCode() == null ? 0 : this.getDacTdCode().hashCode());
		result = 37 * result + (getDacDateReception() == null ? 0 : this.getDacDateReception().hashCode());
		result = 37 * result + (getDacStatutRetour() == null ? 0 : this.getDacStatutRetour().hashCode());
		result = 37 * result + (getDacMention() == null ? 0 : this.getDacMention().hashCode());
		result = 37 * result + (getDacRecherche() == null ? 0 : this.getDacRecherche().hashCode());
		result = 37 * result + (getDcsOpeMatricule() == null ? 0 : this.getDcsOpeMatricule().hashCode());
		result = 37 * result + (getDcsPreMbm() == null ? 0 : this.getDcsPreMbm().hashCode());
		result = 37 * result + (getDcsComStrCode() == null ? 0 : this.getDcsComStrCode().hashCode());
		result = 37 * result + (getDcsMbmRespo() == null ? 0 : this.getDcsMbmRespo().hashCode());
		result = 37 * result + (getDcsFonCod() == null ? 0 : this.getDcsFonCod().hashCode());
		result = 37 * result + (getTdcLibelle() == null ? 0 : this.getTdcLibelle().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		return result;
	}

}
