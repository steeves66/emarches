package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPpmlisteId generated by hbm2java
 */
@Embeddable
public class VPpmlisteId implements java.io.Serializable {

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
	private short plpGesCode;

	public VPpmlisteId() {
	}

	public VPpmlisteId(long dppId, String dppStaCode, String dppMopCode, String mopLibelleCourt, String dppTypePlan,
			String tymLibelleCourt, long plpId, short plpGesCode) {
		this.dppId = dppId;
		this.dppStaCode = dppStaCode;
		this.dppMopCode = dppMopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.dppTypePlan = dppTypePlan;
		this.tymLibelleCourt = tymLibelleCourt;
		this.plpId = plpId;
		this.plpGesCode = plpGesCode;
	}

	public VPpmlisteId(long dppId, Date dppDteModif, String dppObjet, String dppSourceFin, String dppLbgCode,
			String dppStaCode, String dppMopCode, String mopLibelleCourt, String mopLibelleLong, String dppStrCode,
			String strLibelleCourt, String strLibelleLong, String lbgFonCodePf, String lbgFonCodeAc,
			String lbgFonCodeCf, String lbgFonCodeCor, String lbgFonCodeVal, Date dppDateValAc, Date dppDateValCpmp,
			Date dppDateValDmp, String dppPartiePmePmi, Date dppDateSaisie, String dppTypePlan, String tymLibelleCourt,
			String dppStatutRetour, String dppStructureConduc, String dppStructureBenefi, String dppRecherche,
			String dppFonCodPf, String dppFonCodDmp, String dppActeurSaisie, long plpId, short plpGesCode) {
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
	public short getPlpGesCode() {
		return this.plpGesCode;
	}

	public void setPlpGesCode(short plpGesCode) {
		this.plpGesCode = plpGesCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VPpmlisteId))
			return false;
		VPpmlisteId castOther = (VPpmlisteId) other;

		return (this.getDppId() == castOther.getDppId())
				&& ((this.getDppDteModif() == castOther.getDppDteModif())
						|| (this.getDppDteModif() != null && castOther.getDppDteModif() != null
								&& this.getDppDteModif().equals(castOther.getDppDteModif())))
				&& ((this.getDppObjet() == castOther.getDppObjet()) || (this.getDppObjet() != null
						&& castOther.getDppObjet() != null && this.getDppObjet().equals(castOther.getDppObjet())))
				&& ((this.getDppSourceFin() == castOther.getDppSourceFin())
						|| (this.getDppSourceFin() != null && castOther.getDppSourceFin() != null
								&& this.getDppSourceFin().equals(castOther.getDppSourceFin())))
				&& ((this.getDppLbgCode() == castOther.getDppLbgCode()) || (this.getDppLbgCode() != null
						&& castOther.getDppLbgCode() != null && this.getDppLbgCode().equals(castOther.getDppLbgCode())))
				&& ((this.getDppStaCode() == castOther.getDppStaCode()) || (this.getDppStaCode() != null
						&& castOther.getDppStaCode() != null && this.getDppStaCode().equals(castOther.getDppStaCode())))
				&& ((this.getDppMopCode() == castOther.getDppMopCode()) || (this.getDppMopCode() != null
						&& castOther.getDppMopCode() != null && this.getDppMopCode().equals(castOther.getDppMopCode())))
				&& ((this.getMopLibelleCourt() == castOther.getMopLibelleCourt())
						|| (this.getMopLibelleCourt() != null && castOther.getMopLibelleCourt() != null
								&& this.getMopLibelleCourt().equals(castOther.getMopLibelleCourt())))
				&& ((this.getMopLibelleLong() == castOther.getMopLibelleLong())
						|| (this.getMopLibelleLong() != null && castOther.getMopLibelleLong() != null
								&& this.getMopLibelleLong().equals(castOther.getMopLibelleLong())))
				&& ((this.getDppStrCode() == castOther.getDppStrCode()) || (this.getDppStrCode() != null
						&& castOther.getDppStrCode() != null && this.getDppStrCode().equals(castOther.getDppStrCode())))
				&& ((this.getStrLibelleCourt() == castOther.getStrLibelleCourt())
						|| (this.getStrLibelleCourt() != null && castOther.getStrLibelleCourt() != null
								&& this.getStrLibelleCourt().equals(castOther.getStrLibelleCourt())))
				&& ((this.getStrLibelleLong() == castOther.getStrLibelleLong())
						|| (this.getStrLibelleLong() != null && castOther.getStrLibelleLong() != null
								&& this.getStrLibelleLong().equals(castOther.getStrLibelleLong())))
				&& ((this.getLbgFonCodePf() == castOther.getLbgFonCodePf())
						|| (this.getLbgFonCodePf() != null && castOther.getLbgFonCodePf() != null
								&& this.getLbgFonCodePf().equals(castOther.getLbgFonCodePf())))
				&& ((this.getLbgFonCodeAc() == castOther.getLbgFonCodeAc())
						|| (this.getLbgFonCodeAc() != null && castOther.getLbgFonCodeAc() != null
								&& this.getLbgFonCodeAc().equals(castOther.getLbgFonCodeAc())))
				&& ((this.getLbgFonCodeCf() == castOther.getLbgFonCodeCf())
						|| (this.getLbgFonCodeCf() != null && castOther.getLbgFonCodeCf() != null
								&& this.getLbgFonCodeCf().equals(castOther.getLbgFonCodeCf())))
				&& ((this.getLbgFonCodeCor() == castOther.getLbgFonCodeCor())
						|| (this.getLbgFonCodeCor() != null && castOther.getLbgFonCodeCor() != null
								&& this.getLbgFonCodeCor().equals(castOther.getLbgFonCodeCor())))
				&& ((this.getLbgFonCodeVal() == castOther.getLbgFonCodeVal())
						|| (this.getLbgFonCodeVal() != null && castOther.getLbgFonCodeVal() != null
								&& this.getLbgFonCodeVal().equals(castOther.getLbgFonCodeVal())))
				&& ((this.getDppDateValAc() == castOther.getDppDateValAc())
						|| (this.getDppDateValAc() != null && castOther.getDppDateValAc() != null
								&& this.getDppDateValAc().equals(castOther.getDppDateValAc())))
				&& ((this.getDppDateValCpmp() == castOther.getDppDateValCpmp())
						|| (this.getDppDateValCpmp() != null && castOther.getDppDateValCpmp() != null
								&& this.getDppDateValCpmp().equals(castOther.getDppDateValCpmp())))
				&& ((this.getDppDateValDmp() == castOther.getDppDateValDmp())
						|| (this.getDppDateValDmp() != null && castOther.getDppDateValDmp() != null
								&& this.getDppDateValDmp().equals(castOther.getDppDateValDmp())))
				&& ((this.getDppPartiePmePmi() == castOther.getDppPartiePmePmi())
						|| (this.getDppPartiePmePmi() != null && castOther.getDppPartiePmePmi() != null
								&& this.getDppPartiePmePmi().equals(castOther.getDppPartiePmePmi())))
				&& ((this.getDppDateSaisie() == castOther.getDppDateSaisie())
						|| (this.getDppDateSaisie() != null && castOther.getDppDateSaisie() != null
								&& this.getDppDateSaisie().equals(castOther.getDppDateSaisie())))
				&& ((this.getDppTypePlan() == castOther.getDppTypePlan())
						|| (this.getDppTypePlan() != null && castOther.getDppTypePlan() != null
								&& this.getDppTypePlan().equals(castOther.getDppTypePlan())))
				&& ((this.getTymLibelleCourt() == castOther.getTymLibelleCourt())
						|| (this.getTymLibelleCourt() != null && castOther.getTymLibelleCourt() != null
								&& this.getTymLibelleCourt().equals(castOther.getTymLibelleCourt())))
				&& ((this.getDppStatutRetour() == castOther.getDppStatutRetour())
						|| (this.getDppStatutRetour() != null && castOther.getDppStatutRetour() != null
								&& this.getDppStatutRetour().equals(castOther.getDppStatutRetour())))
				&& ((this.getDppStructureConduc() == castOther.getDppStructureConduc())
						|| (this.getDppStructureConduc() != null && castOther.getDppStructureConduc() != null
								&& this.getDppStructureConduc().equals(castOther.getDppStructureConduc())))
				&& ((this.getDppStructureBenefi() == castOther.getDppStructureBenefi())
						|| (this.getDppStructureBenefi() != null && castOther.getDppStructureBenefi() != null
								&& this.getDppStructureBenefi().equals(castOther.getDppStructureBenefi())))
				&& ((this.getDppRecherche() == castOther.getDppRecherche())
						|| (this.getDppRecherche() != null && castOther.getDppRecherche() != null
								&& this.getDppRecherche().equals(castOther.getDppRecherche())))
				&& ((this.getDppFonCodPf() == castOther.getDppFonCodPf())
						|| (this.getDppFonCodPf() != null && castOther.getDppFonCodPf() != null
								&& this.getDppFonCodPf().equals(castOther.getDppFonCodPf())))
				&& ((this.getDppFonCodDmp() == castOther.getDppFonCodDmp())
						|| (this.getDppFonCodDmp() != null && castOther.getDppFonCodDmp() != null
								&& this.getDppFonCodDmp().equals(castOther.getDppFonCodDmp())))
				&& ((this.getDppActeurSaisie() == castOther.getDppActeurSaisie())
						|| (this.getDppActeurSaisie() != null && castOther.getDppActeurSaisie() != null
								&& this.getDppActeurSaisie().equals(castOther.getDppActeurSaisie())))
				&& (this.getPlpId() == castOther.getPlpId()) && (this.getPlpGesCode() == castOther.getPlpGesCode());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getDppId();
		result = 37 * result + (getDppDteModif() == null ? 0 : this.getDppDteModif().hashCode());
		result = 37 * result + (getDppObjet() == null ? 0 : this.getDppObjet().hashCode());
		result = 37 * result + (getDppSourceFin() == null ? 0 : this.getDppSourceFin().hashCode());
		result = 37 * result + (getDppLbgCode() == null ? 0 : this.getDppLbgCode().hashCode());
		result = 37 * result + (getDppStaCode() == null ? 0 : this.getDppStaCode().hashCode());
		result = 37 * result + (getDppMopCode() == null ? 0 : this.getDppMopCode().hashCode());
		result = 37 * result + (getMopLibelleCourt() == null ? 0 : this.getMopLibelleCourt().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		result = 37 * result + (getDppStrCode() == null ? 0 : this.getDppStrCode().hashCode());
		result = 37 * result + (getStrLibelleCourt() == null ? 0 : this.getStrLibelleCourt().hashCode());
		result = 37 * result + (getStrLibelleLong() == null ? 0 : this.getStrLibelleLong().hashCode());
		result = 37 * result + (getLbgFonCodePf() == null ? 0 : this.getLbgFonCodePf().hashCode());
		result = 37 * result + (getLbgFonCodeAc() == null ? 0 : this.getLbgFonCodeAc().hashCode());
		result = 37 * result + (getLbgFonCodeCf() == null ? 0 : this.getLbgFonCodeCf().hashCode());
		result = 37 * result + (getLbgFonCodeCor() == null ? 0 : this.getLbgFonCodeCor().hashCode());
		result = 37 * result + (getLbgFonCodeVal() == null ? 0 : this.getLbgFonCodeVal().hashCode());
		result = 37 * result + (getDppDateValAc() == null ? 0 : this.getDppDateValAc().hashCode());
		result = 37 * result + (getDppDateValCpmp() == null ? 0 : this.getDppDateValCpmp().hashCode());
		result = 37 * result + (getDppDateValDmp() == null ? 0 : this.getDppDateValDmp().hashCode());
		result = 37 * result + (getDppPartiePmePmi() == null ? 0 : this.getDppPartiePmePmi().hashCode());
		result = 37 * result + (getDppDateSaisie() == null ? 0 : this.getDppDateSaisie().hashCode());
		result = 37 * result + (getDppTypePlan() == null ? 0 : this.getDppTypePlan().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getDppStatutRetour() == null ? 0 : this.getDppStatutRetour().hashCode());
		result = 37 * result + (getDppStructureConduc() == null ? 0 : this.getDppStructureConduc().hashCode());
		result = 37 * result + (getDppStructureBenefi() == null ? 0 : this.getDppStructureBenefi().hashCode());
		result = 37 * result + (getDppRecherche() == null ? 0 : this.getDppRecherche().hashCode());
		result = 37 * result + (getDppFonCodPf() == null ? 0 : this.getDppFonCodPf().hashCode());
		result = 37 * result + (getDppFonCodDmp() == null ? 0 : this.getDppFonCodDmp().hashCode());
		result = 37 * result + (getDppActeurSaisie() == null ? 0 : this.getDppActeurSaisie().hashCode());
		result = 37 * result + (int) this.getPlpId();
		result = 37 * result + this.getPlpGesCode();
		return result;
	}

}
