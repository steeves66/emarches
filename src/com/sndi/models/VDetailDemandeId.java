package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDetailDemandeId generated by hbm2java
 */
@Embeddable
public class VDetailDemandeId implements java.io.Serializable {

	private String dacCode;
	private String dacObjet;
	private Date dacDteSaisi;
	private String dacStaCode;
	private String dacTymCode;
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
	private Date dacDateValAc;
	private String dacAvisBailleur;
	private Date dacDateAvisBailleur;
	private String dacBailleur;
	private Long dacCout;
	private String dacTypePlan;
	private String dacRecherche;
	private String tymCode;
	private String tymLibelleCourt;
	private String tymLibelleLong;
	private String tymTymCode;
	private String tymGroupe;
	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private BigDecimal ddeNum;
	private BigDecimal ddeDemNum;
	private String ddeDacCode;
	private Short ddeLaaId;
	private String ddeLbgCode;
	private String ddeMarCode;
	private String ddeStrCode;
	private String ddeActNum;
	private String ddeActNumIni;

	public VDetailDemandeId() {
	}

	public VDetailDemandeId(String dacCode, String tymCode, String tymLibelleCourt, String mopCode,
			String mopLibelleCourt, BigDecimal ddeNum) {
		this.dacCode = dacCode;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.ddeNum = ddeNum;
	}

	public VDetailDemandeId(String dacCode, String dacObjet, Date dacDteSaisi, String dacStaCode, String dacTymCode,
			String dacMopCode, BigDecimal dacNbrOuv, BigDecimal dacGesCode, String dacFonCodAc, String dacStrCode,
			String dacFonCodeCpmp, Date dacDteValCpmp, Date dacDteValDmp, String dacTdCode, Date dacDateReception,
			String dacStatutRetour, String dacMention, Date dacDateValAc, String dacAvisBailleur,
			Date dacDateAvisBailleur, String dacBailleur, Long dacCout, String dacTypePlan, String dacRecherche,
			String tymCode, String tymLibelleCourt, String tymLibelleLong, String tymTymCode, String tymGroupe,
			String mopCode, String mopLibelleCourt, String mopLibelleLong, BigDecimal ddeNum, BigDecimal ddeDemNum,
			String ddeDacCode, Short ddeLaaId, String ddeLbgCode, String ddeMarCode, String ddeStrCode,
			String ddeActNum, String ddeActNumIni) {
		this.dacCode = dacCode;
		this.dacObjet = dacObjet;
		this.dacDteSaisi = dacDteSaisi;
		this.dacStaCode = dacStaCode;
		this.dacTymCode = dacTymCode;
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
		this.dacDateValAc = dacDateValAc;
		this.dacAvisBailleur = dacAvisBailleur;
		this.dacDateAvisBailleur = dacDateAvisBailleur;
		this.dacBailleur = dacBailleur;
		this.dacCout = dacCout;
		this.dacTypePlan = dacTypePlan;
		this.dacRecherche = dacRecherche;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.tymLibelleLong = tymLibelleLong;
		this.tymTymCode = tymTymCode;
		this.tymGroupe = tymGroupe;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.ddeNum = ddeNum;
		this.ddeDemNum = ddeDemNum;
		this.ddeDacCode = ddeDacCode;
		this.ddeLaaId = ddeLaaId;
		this.ddeLbgCode = ddeLbgCode;
		this.ddeMarCode = ddeMarCode;
		this.ddeStrCode = ddeStrCode;
		this.ddeActNum = ddeActNum;
		this.ddeActNumIni = ddeActNumIni;
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

	@Column(name = "DAC_STR_CODE", length = 20)
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

	@Column(name = "DAC_DATE_VAL_AC", length = 7)
	public Date getDacDateValAc() {
		return this.dacDateValAc;
	}

	public void setDacDateValAc(Date dacDateValAc) {
		this.dacDateValAc = dacDateValAc;
	}

	@Column(name = "DAC_AVIS_BAILLEUR", length = 4000)
	public String getDacAvisBailleur() {
		return this.dacAvisBailleur;
	}

	public void setDacAvisBailleur(String dacAvisBailleur) {
		this.dacAvisBailleur = dacAvisBailleur;
	}

	@Column(name = "DAC_DATE_AVIS_BAILLEUR", length = 7)
	public Date getDacDateAvisBailleur() {
		return this.dacDateAvisBailleur;
	}

	public void setDacDateAvisBailleur(Date dacDateAvisBailleur) {
		this.dacDateAvisBailleur = dacDateAvisBailleur;
	}

	@Column(name = "DAC_BAILLEUR", length = 1)
	public String getDacBailleur() {
		return this.dacBailleur;
	}

	public void setDacBailleur(String dacBailleur) {
		this.dacBailleur = dacBailleur;
	}

	@Column(name = "DAC_COUT", precision = 11, scale = 0)
	public Long getDacCout() {
		return this.dacCout;
	}

	public void setDacCout(Long dacCout) {
		this.dacCout = dacCout;
	}

	@Column(name = "DAC_TYPE_PLAN", length = 4)
	public String getDacTypePlan() {
		return this.dacTypePlan;
	}

	public void setDacTypePlan(String dacTypePlan) {
		this.dacTypePlan = dacTypePlan;
	}

	@Column(name = "DAC_RECHERCHE", length = 4000)
	public String getDacRecherche() {
		return this.dacRecherche;
	}

	public void setDacRecherche(String dacRecherche) {
		this.dacRecherche = dacRecherche;
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

	@Column(name = "DDE_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDdeNum() {
		return this.ddeNum;
	}

	public void setDdeNum(BigDecimal ddeNum) {
		this.ddeNum = ddeNum;
	}

	@Column(name = "DDE_DEM_NUM", precision = 22, scale = 0)
	public BigDecimal getDdeDemNum() {
		return this.ddeDemNum;
	}

	public void setDdeDemNum(BigDecimal ddeDemNum) {
		this.ddeDemNum = ddeDemNum;
	}

	@Column(name = "DDE_DAC_CODE", length = 20)
	public String getDdeDacCode() {
		return this.ddeDacCode;
	}

	public void setDdeDacCode(String ddeDacCode) {
		this.ddeDacCode = ddeDacCode;
	}

	@Column(name = "DDE_LAA_ID", precision = 4, scale = 0)
	public Short getDdeLaaId() {
		return this.ddeLaaId;
	}

	public void setDdeLaaId(Short ddeLaaId) {
		this.ddeLaaId = ddeLaaId;
	}

	@Column(name = "DDE_LBG_CODE", length = 50)
	public String getDdeLbgCode() {
		return this.ddeLbgCode;
	}

	public void setDdeLbgCode(String ddeLbgCode) {
		this.ddeLbgCode = ddeLbgCode;
	}

	@Column(name = "DDE_MAR_CODE", length = 20)
	public String getDdeMarCode() {
		return this.ddeMarCode;
	}

	public void setDdeMarCode(String ddeMarCode) {
		this.ddeMarCode = ddeMarCode;
	}

	@Column(name = "DDE_STR_CODE", length = 20)
	public String getDdeStrCode() {
		return this.ddeStrCode;
	}

	public void setDdeStrCode(String ddeStrCode) {
		this.ddeStrCode = ddeStrCode;
	}

	@Column(name = "DDE_ACT_NUM", length = 200)
	public String getDdeActNum() {
		return this.ddeActNum;
	}

	public void setDdeActNum(String ddeActNum) {
		this.ddeActNum = ddeActNum;
	}

	@Column(name = "DDE_ACT_NUM_INI", length = 200)
	public String getDdeActNumIni() {
		return this.ddeActNumIni;
	}

	public void setDdeActNumIni(String ddeActNumIni) {
		this.ddeActNumIni = ddeActNumIni;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDetailDemandeId))
			return false;
		VDetailDemandeId castOther = (VDetailDemandeId) other;

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
				&& ((this.getDacDateValAc() == castOther.getDacDateValAc())
						|| (this.getDacDateValAc() != null && castOther.getDacDateValAc() != null
								&& this.getDacDateValAc().equals(castOther.getDacDateValAc())))
				&& ((this.getDacAvisBailleur() == castOther.getDacAvisBailleur())
						|| (this.getDacAvisBailleur() != null && castOther.getDacAvisBailleur() != null
								&& this.getDacAvisBailleur().equals(castOther.getDacAvisBailleur())))
				&& ((this.getDacDateAvisBailleur() == castOther.getDacDateAvisBailleur())
						|| (this.getDacDateAvisBailleur() != null && castOther.getDacDateAvisBailleur() != null
								&& this.getDacDateAvisBailleur().equals(castOther.getDacDateAvisBailleur())))
				&& ((this.getDacBailleur() == castOther.getDacBailleur())
						|| (this.getDacBailleur() != null && castOther.getDacBailleur() != null
								&& this.getDacBailleur().equals(castOther.getDacBailleur())))
				&& ((this.getDacCout() == castOther.getDacCout()) || (this.getDacCout() != null
						&& castOther.getDacCout() != null && this.getDacCout().equals(castOther.getDacCout())))
				&& ((this.getDacTypePlan() == castOther.getDacTypePlan())
						|| (this.getDacTypePlan() != null && castOther.getDacTypePlan() != null
								&& this.getDacTypePlan().equals(castOther.getDacTypePlan())))
				&& ((this.getDacRecherche() == castOther.getDacRecherche())
						|| (this.getDacRecherche() != null && castOther.getDacRecherche() != null
								&& this.getDacRecherche().equals(castOther.getDacRecherche())))
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
						&& castOther.getTymGroupe() != null && this.getTymGroupe().equals(castOther.getTymGroupe())))
				&& ((this.getMopCode() == castOther.getMopCode()) || (this.getMopCode() != null
						&& castOther.getMopCode() != null && this.getMopCode().equals(castOther.getMopCode())))
				&& ((this.getMopLibelleCourt() == castOther.getMopLibelleCourt())
						|| (this.getMopLibelleCourt() != null && castOther.getMopLibelleCourt() != null
								&& this.getMopLibelleCourt().equals(castOther.getMopLibelleCourt())))
				&& ((this.getMopLibelleLong() == castOther.getMopLibelleLong())
						|| (this.getMopLibelleLong() != null && castOther.getMopLibelleLong() != null
								&& this.getMopLibelleLong().equals(castOther.getMopLibelleLong())))
				&& ((this.getDdeNum() == castOther.getDdeNum()) || (this.getDdeNum() != null
						&& castOther.getDdeNum() != null && this.getDdeNum().equals(castOther.getDdeNum())))
				&& ((this.getDdeDemNum() == castOther.getDdeDemNum()) || (this.getDdeDemNum() != null
						&& castOther.getDdeDemNum() != null && this.getDdeDemNum().equals(castOther.getDdeDemNum())))
				&& ((this.getDdeDacCode() == castOther.getDdeDacCode()) || (this.getDdeDacCode() != null
						&& castOther.getDdeDacCode() != null && this.getDdeDacCode().equals(castOther.getDdeDacCode())))
				&& ((this.getDdeLaaId() == castOther.getDdeLaaId()) || (this.getDdeLaaId() != null
						&& castOther.getDdeLaaId() != null && this.getDdeLaaId().equals(castOther.getDdeLaaId())))
				&& ((this.getDdeLbgCode() == castOther.getDdeLbgCode()) || (this.getDdeLbgCode() != null
						&& castOther.getDdeLbgCode() != null && this.getDdeLbgCode().equals(castOther.getDdeLbgCode())))
				&& ((this.getDdeMarCode() == castOther.getDdeMarCode()) || (this.getDdeMarCode() != null
						&& castOther.getDdeMarCode() != null && this.getDdeMarCode().equals(castOther.getDdeMarCode())))
				&& ((this.getDdeStrCode() == castOther.getDdeStrCode()) || (this.getDdeStrCode() != null
						&& castOther.getDdeStrCode() != null && this.getDdeStrCode().equals(castOther.getDdeStrCode())))
				&& ((this.getDdeActNum() == castOther.getDdeActNum()) || (this.getDdeActNum() != null
						&& castOther.getDdeActNum() != null && this.getDdeActNum().equals(castOther.getDdeActNum())))
				&& ((this.getDdeActNumIni() == castOther.getDdeActNumIni())
						|| (this.getDdeActNumIni() != null && castOther.getDdeActNumIni() != null
								&& this.getDdeActNumIni().equals(castOther.getDdeActNumIni())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDacCode() == null ? 0 : this.getDacCode().hashCode());
		result = 37 * result + (getDacObjet() == null ? 0 : this.getDacObjet().hashCode());
		result = 37 * result + (getDacDteSaisi() == null ? 0 : this.getDacDteSaisi().hashCode());
		result = 37 * result + (getDacStaCode() == null ? 0 : this.getDacStaCode().hashCode());
		result = 37 * result + (getDacTymCode() == null ? 0 : this.getDacTymCode().hashCode());
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
		result = 37 * result + (getDacDateValAc() == null ? 0 : this.getDacDateValAc().hashCode());
		result = 37 * result + (getDacAvisBailleur() == null ? 0 : this.getDacAvisBailleur().hashCode());
		result = 37 * result + (getDacDateAvisBailleur() == null ? 0 : this.getDacDateAvisBailleur().hashCode());
		result = 37 * result + (getDacBailleur() == null ? 0 : this.getDacBailleur().hashCode());
		result = 37 * result + (getDacCout() == null ? 0 : this.getDacCout().hashCode());
		result = 37 * result + (getDacTypePlan() == null ? 0 : this.getDacTypePlan().hashCode());
		result = 37 * result + (getDacRecherche() == null ? 0 : this.getDacRecherche().hashCode());
		result = 37 * result + (getTymCode() == null ? 0 : this.getTymCode().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getTymLibelleLong() == null ? 0 : this.getTymLibelleLong().hashCode());
		result = 37 * result + (getTymTymCode() == null ? 0 : this.getTymTymCode().hashCode());
		result = 37 * result + (getTymGroupe() == null ? 0 : this.getTymGroupe().hashCode());
		result = 37 * result + (getMopCode() == null ? 0 : this.getMopCode().hashCode());
		result = 37 * result + (getMopLibelleCourt() == null ? 0 : this.getMopLibelleCourt().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		result = 37 * result + (getDdeNum() == null ? 0 : this.getDdeNum().hashCode());
		result = 37 * result + (getDdeDemNum() == null ? 0 : this.getDdeDemNum().hashCode());
		result = 37 * result + (getDdeDacCode() == null ? 0 : this.getDdeDacCode().hashCode());
		result = 37 * result + (getDdeLaaId() == null ? 0 : this.getDdeLaaId().hashCode());
		result = 37 * result + (getDdeLbgCode() == null ? 0 : this.getDdeLbgCode().hashCode());
		result = 37 * result + (getDdeMarCode() == null ? 0 : this.getDdeMarCode().hashCode());
		result = 37 * result + (getDdeStrCode() == null ? 0 : this.getDdeStrCode().hashCode());
		result = 37 * result + (getDdeActNum() == null ? 0 : this.getDdeActNum().hashCode());
		result = 37 * result + (getDdeActNumIni() == null ? 0 : this.getDdeActNumIni().hashCode());
		return result;
	}

}
