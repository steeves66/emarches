package com.sndi.model;
// Generated 31 mai 2020 15:39:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VPpmliste generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_PPMLISTE")
public class VPpmliste implements java.io.Serializable {

	private long dppId;
	private Date dppDteModif;
	private String dppObjet;
	private String dppSourceFin;
	private String dppLbgCode;
	private String dppStaCode;
	private String dppMopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String dppStrCode;
	private String strLibelleCourt;
	private String strLibelleLong;
	private String lbgFonCodePf;
	private String lbgFonCodeAc;
	private String lbgFonCodeCf;
	private String lbgFonCodeCor;
	private BigDecimal lbgTotDot;
	private BigDecimal lbgAeTr;
	private BigDecimal lbgDisTot;
	private String lbgFonCodeVal;
	private Date dppDateValAc;
	private Date dppDateValCpmp;
	private Date dppDateValDmp;
	private String dppPartiePmePmi;
	private Date dppDateSaisie;
	private String dppTypePlan;
	private String tymLibelleCourt;
	private String dppStatutRetour;
	private String dppStructureConduc;
	private String dppStructureBenefi;
	private String dppRecherche;
	private String dppFonCodPf;
	private String dppFonCodDmp;
	private String dppActeurSaisie;
	private long plpId;
	private long plpGesCode;

	public VPpmliste() {
	}

	public VPpmliste(long dppId, String dppStaCode, String dppMopCode, String mopLibelleCourt, String dppTypePlan,
			String tymLibelleCourt, long plpId, long plpGesCode) {
		this.dppId = dppId;
		this.dppStaCode = dppStaCode;
		this.dppMopCode = dppMopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.dppTypePlan = dppTypePlan;
		this.tymLibelleCourt = tymLibelleCourt;
		this.plpId = plpId;
		this.plpGesCode = plpGesCode;
	}

	public VPpmliste(long dppId, Date dppDteModif, String dppObjet, String dppSourceFin, String dppLbgCode,
			String dppStaCode, String dppMopCode, String mopLibelleCourt, String mopLibelleLong, String dppStrCode,
			String strLibelleCourt, String strLibelleLong,String lbgFonCodePf, String lbgFonCodeAc,
			String lbgFonCodeCf, String lbgFonCodeCor,BigDecimal lbgTotDot, BigDecimal lbgAeTr, BigDecimal lbgDisTot, String lbgFonCodeVal, Date dppDateValAc, Date dppDateValCpmp, Date dppDateValDmp,
			String dppPartiePmePmi, Date dppDateSaisie, String dppTypePlan, String tymLibelleCourt,
			String dppStatutRetour, String dppStructureConduc, String dppStructureBenefi, String dppRecherche,
			String dppFonCodPf, String dppFonCodDmp, String dppActeurSaisie, long plpId, long plpGesCode) {
		this.dppId = dppId;
		this.dppDteModif = dppDteModif;
		this.dppObjet = dppObjet;
		this.dppSourceFin = dppSourceFin;
		this.dppLbgCode = dppLbgCode;
		this.dppStaCode = dppStaCode;
		this.dppMopCode = dppMopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.dppStrCode = dppStrCode;
		this.strLibelleCourt = strLibelleCourt;
		this.strLibelleLong = strLibelleLong;
		this.lbgFonCodePf = lbgFonCodePf;
		this.lbgFonCodeAc = lbgFonCodeAc;
		this.lbgFonCodeCf = lbgFonCodeCf;
		this.lbgFonCodeCor = lbgFonCodeCor;
		this.lbgTotDot = lbgTotDot;
		this.lbgAeTr = lbgAeTr;
		this.lbgDisTot = lbgDisTot;
		this.lbgFonCodeVal = lbgFonCodeVal;
		this.dppDateValAc = dppDateValAc;
		this.dppDateValCpmp = dppDateValCpmp;
		this.dppDateValDmp = dppDateValDmp;
		this.dppPartiePmePmi = dppPartiePmePmi;
		this.dppDateSaisie = dppDateSaisie;
		this.dppTypePlan = dppTypePlan;
		this.tymLibelleCourt = tymLibelleCourt;
		this.dppStatutRetour = dppStatutRetour;
		this.dppStructureConduc = dppStructureConduc;
		this.dppStructureBenefi = dppStructureBenefi;
		this.dppRecherche = dppRecherche;
		this.dppFonCodPf = dppFonCodPf;
		this.dppFonCodDmp = dppFonCodDmp;
		this.dppActeurSaisie = dppActeurSaisie;
		this.plpId = plpId;
		this.plpGesCode = plpGesCode;
	}

	@Id
	@Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getDppId() {
		return this.dppId;
	}

	public void setDppId(long dppId) {
		this.dppId = dppId;
	}

	@Column(name = "DPP_DTE_MODIF", length = 7)
	public Date getDppDteModif() {
		return this.dppDteModif;
	}

	public void setDppDteModif(Date dppDteModif) {
		this.dppDteModif = dppDteModif;
	}

	@Column(name = "DPP_OBJET", length = 1000)
	public String getDppObjet() {
		return this.dppObjet;
	}

	public void setDppObjet(String dppObjet) {
		this.dppObjet = dppObjet;
	}

	@Column(name = "DPP_SOURCE_FIN", length = 1000)
	public String getDppSourceFin() {
		return this.dppSourceFin;
	}

	public void setDppSourceFin(String dppSourceFin) {
		this.dppSourceFin = dppSourceFin;
	}

	@Column(name = "DPP_LBG_CODE", length = 50)
	public String getDppLbgCode() {
		return this.dppLbgCode;
	}

	public void setDppLbgCode(String dppLbgCode) {
		this.dppLbgCode = dppLbgCode;
	}

	@Column(name = "DPP_STA_CODE", nullable = false, length = 3)
	public String getDppStaCode() {
		return this.dppStaCode;
	}

	public void setDppStaCode(String dppStaCode) {
		this.dppStaCode = dppStaCode;
	}

	@Column(name = "DPP_MOP_CODE", nullable = false, length = 3)
	public String getDppMopCode() {
		return this.dppMopCode;
	}

	public void setDppMopCode(String dppMopCode) {
		this.dppMopCode = dppMopCode;
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

	@Column(name = "DPP_STR_CODE", length = 20)
	public String getDppStrCode() {
		return this.dppStrCode;
	}

	public void setDppStrCode(String dppStrCode) {
		this.dppStrCode = dppStrCode;
	}

	@Column(name = "STR_LIBELLE_COURT", length = 500)
	public String getStrLibelleCourt() {
		return this.strLibelleCourt;
	}

	public void setStrLibelleCourt(String strLibelleCourt) {
		this.strLibelleCourt = strLibelleCourt;
	}

	@Column(name = "STR_LIBELLE_LONG", length = 1000)
	public String getStrLibelleLong() {
		return this.strLibelleLong;
	}

	public void setStrLibelleLong(String strLibelleLong) {
		this.strLibelleLong = strLibelleLong;
	}
	
	@Column(name = "LBG_FON_CODE_PF", length = 30)
	public String getLbgFonCodePf() {
		return this.lbgFonCodePf;
	}

	public void setLbgFonCodePf(String lbgFonCodePf) {
		this.lbgFonCodePf = lbgFonCodePf;
	}

	@Column(name = "LBG_FON_CODE_AC", length = 30)
	public String getLbgFonCodeAc() {
		return this.lbgFonCodeAc;
	}

	public void setLbgFonCodeAc(String lbgFonCodeAc) {
		this.lbgFonCodeAc = lbgFonCodeAc;
	}

	@Column(name = "LBG_FON_CODE_CF", length = 30)
	public String getLbgFonCodeCf() {
		return this.lbgFonCodeCf;
	}

	public void setLbgFonCodeCf(String lbgFonCodeCf) {
		this.lbgFonCodeCf = lbgFonCodeCf;
	}

	@Column(name = "LBG_FON_CODE_COR", length = 30)
	public String getLbgFonCodeCor() {
		return this.lbgFonCodeCor;
	}

	public void setLbgFonCodeCor(String lbgFonCodeCor) {
		this.lbgFonCodeCor = lbgFonCodeCor;
	}
	
	@Column(name = "LBG_TOT_DOT", precision = 20, scale = 0)
	public BigDecimal getLbgTotDot() {
		return this.lbgTotDot;
	}

	public void setLbgTotDot(BigDecimal lbgTotDot) {
		this.lbgTotDot = lbgTotDot;
	}

	@Column(name = "LBG_AE_TR", precision = 20, scale = 0)
	public BigDecimal getLbgAeTr() {
		return this.lbgAeTr;
	}

	public void setLbgAeTr(BigDecimal lbgAeTr) {
		this.lbgAeTr = lbgAeTr;
	}

	@Column(name = "LBG_DIS_TOT", precision = 20, scale = 0)
	public BigDecimal getLbgDisTot() {
		return this.lbgDisTot;
	}

	public void setLbgDisTot(BigDecimal lbgDisTot) {
		this.lbgDisTot = lbgDisTot;
	}


	@Column(name = "LBG_FON_CODE_VAL", length = 10)
	public String getLbgFonCodeVal() {
		return this.lbgFonCodeVal;
	}

	public void setLbgFonCodeVal(String lbgFonCodeVal) {
		this.lbgFonCodeVal = lbgFonCodeVal;
	}

	@Column(name = "DPP_DATE_VAL_AC", length = 7)
	public Date getDppDateValAc() {
		return this.dppDateValAc;
	}

	public void setDppDateValAc(Date dppDateValAc) {
		this.dppDateValAc = dppDateValAc;
	}

	@Column(name = "DPP_DATE_VAL_CPMP", length = 7)
	public Date getDppDateValCpmp() {
		return this.dppDateValCpmp;
	}

	public void setDppDateValCpmp(Date dppDateValCpmp) {
		this.dppDateValCpmp = dppDateValCpmp;
	}

	@Column(name = "DPP_DATE_VAL_DMP", length = 7)
	public Date getDppDateValDmp() {
		return this.dppDateValDmp;
	}

	public void setDppDateValDmp(Date dppDateValDmp) {
		this.dppDateValDmp = dppDateValDmp;
	}

	@Column(name = "DPP_PARTIE_PME_PMI", length = 1)
	public String getDppPartiePmePmi() {
		return this.dppPartiePmePmi;
	}

	public void setDppPartiePmePmi(String dppPartiePmePmi) {
		this.dppPartiePmePmi = dppPartiePmePmi;
	}

	@Column(name = "DPP_DATE_SAISIE", length = 7)
	public Date getDppDateSaisie() {
		return this.dppDateSaisie;
	}

	public void setDppDateSaisie(Date dppDateSaisie) {
		this.dppDateSaisie = dppDateSaisie;
	}

	@Column(name = "DPP_TYPE_PLAN", nullable = false, length = 3)
	public String getDppTypePlan() {
		return this.dppTypePlan;
	}

	public void setDppTypePlan(String dppTypePlan) {
		this.dppTypePlan = dppTypePlan;
	}

	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}

	@Column(name = "DPP_STATUT_RETOUR", length = 4)
	public String getDppStatutRetour() {
		return this.dppStatutRetour;
	}

	public void setDppStatutRetour(String dppStatutRetour) {
		this.dppStatutRetour = dppStatutRetour;
	}

	@Column(name = "DPP_STRUCTURE_CONDUC", length = 500)
	public String getDppStructureConduc() {
		return this.dppStructureConduc;
	}

	public void setDppStructureConduc(String dppStructureConduc) {
		this.dppStructureConduc = dppStructureConduc;
	}

	@Column(name = "DPP_STRUCTURE_BENEFI", length = 500)
	public String getDppStructureBenefi() {
		return this.dppStructureBenefi;
	}

	public void setDppStructureBenefi(String dppStructureBenefi) {
		this.dppStructureBenefi = dppStructureBenefi;
	}

	@Column(name = "DPP_RECHERCHE", length = 4000)
	public String getDppRecherche() {
		return this.dppRecherche;
	}

	public void setDppRecherche(String dppRecherche) {
		this.dppRecherche = dppRecherche;
	}

	@Column(name = "DPP_FON_COD_PF", length = 20)
	public String getDppFonCodPf() {
		return this.dppFonCodPf;
	}

	public void setDppFonCodPf(String dppFonCodPf) {
		this.dppFonCodPf = dppFonCodPf;
	}

	@Column(name = "DPP_FON_COD_DMP", length = 20)
	public String getDppFonCodDmp() {
		return this.dppFonCodDmp;
	}

	public void setDppFonCodDmp(String dppFonCodDmp) {
		this.dppFonCodDmp = dppFonCodDmp;
	}

	@Column(name = "DPP_ACTEUR_SAISIE", length = 12)
	public String getDppActeurSaisie() {
		return this.dppActeurSaisie;
	}

	public void setDppActeurSaisie(String dppActeurSaisie) {
		this.dppActeurSaisie = dppActeurSaisie;
	}

	@Column(name = "PLP_ID", nullable = false, precision = 10, scale = 0)
	public long getPlpId() {
		return this.plpId;
	}

	public void setPlpId(long plpId) {
		this.plpId = plpId;
	}

	@Column(name = "PLP_GES_CODE", nullable = false, precision = 4, scale = 0)
	public long getPlpGesCode() {
		return this.plpGesCode;
	}

	public void setPlpGesCode(long plpGesCode) {
		this.plpGesCode = plpGesCode;
	}

}
