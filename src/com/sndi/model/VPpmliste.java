package com.sndi.model;
// Generated 27 mai 2020 16:25:19 by Hibernate Tools 4.3.5.Final

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
	private String tymLibelleCourt;
	private String mopLibelleLong;
	private String dppStructureConduc;
	private String dppStructureBenefi;
	private String dppRecherche;
	private String dppFonCodPf;
	private String dppFonCodDmp;
	private String dppActeurSaisie;
	private String dppTypePlan;
	private long plpId;
	private short plpGesCode;
	private String dppStatutRetour;
	private String dppStaCode;
	private String dppStrCode;
	private Date dppDateValAc;
	private Date dppDateValCpmp;
	private Date dppDateValDmp;
	private String dppMopCode;

	public VPpmliste() {
	}

	public VPpmliste(long dppId, String tymLibelleCourt,String dppTypePlan, long plpId, short plpGesCode) {
		this.dppId = dppId;
		this.tymLibelleCourt = tymLibelleCourt;
		this.plpId = plpId;
		this.plpGesCode = plpGesCode;
		this.dppTypePlan = dppTypePlan;
	}

	public VPpmliste(long dppId, Date dppDteModif, String dppObjet, String dppSourceFin, String dppLbgCode,String dppTypePlan,
			String tymLibelleCourt, String mopLibelleLong, String dppStructureConduc, String dppStructureBenefi,
			String dppRecherche, String dppFonCodPf, String dppFonCodDmp, String dppActeurSaisie, long plpId,String dppStatutRetour,
			short plpGesCode,String dppStaCode,String dppStrCode, String dppMopCode, Date dppDateValAc, Date dppDateValCpmp,
			Date dppDateValDmp) {
		this.dppId = dppId;
		this.dppDteModif = dppDteModif;
		this.dppObjet = dppObjet;
		this.dppSourceFin = dppSourceFin;
		this.dppLbgCode = dppLbgCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.dppStructureConduc = dppStructureConduc;
		this.dppStructureBenefi = dppStructureBenefi;
		this.dppRecherche = dppRecherche;
		this.dppFonCodPf = dppFonCodPf;
		this.dppFonCodDmp = dppFonCodDmp;
		this.dppActeurSaisie = dppActeurSaisie;
		this.plpId = plpId;
		this.plpGesCode = plpGesCode;
		this.dppTypePlan = dppTypePlan;
		this.dppStatutRetour = dppStatutRetour;
		this.dppStaCode = dppStaCode;
		this.dppStrCode = dppStrCode;
		this.dppMopCode = dppMopCode;
		this.dppDateValAc = dppDateValAc;
		this.dppDateValCpmp = dppDateValCpmp;
		this.dppDateValDmp = dppDateValDmp;
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

	@Column(name = "DPP_TYPE_PLAN", length = 20)
	public String getDppTypePlan() {
		return dppTypePlan;
	}

	public void setDppTypePlan(String dppTypePlan) {
		this.dppTypePlan = dppTypePlan;
	}
	@Column(name = "DPP_STATUT_RETOUR", length = 4)
	public String getDppStatutRetour() {
		return this.dppStatutRetour;
	}

	public void setDppStatutRetour(String dppStatutRetour) {
		this.dppStatutRetour = dppStatutRetour;
	}

	@Column(name = "DPP_STA_CODE")
	public String getDppStaCode() {
		return dppStaCode;
	}

	public void setDppStaCode(String dppStaCode) {
		this.dppStaCode = dppStaCode;
	}

	@Column(name = "DPP_STR_CODE", length = 1000)
	public String getDppStrCode() {
		return dppStrCode;
	}

	public void setDppStrCode(String dppStrCode) {
		this.dppStrCode = dppStrCode;
	}

	@Column(name = "DPP_MOP_CODE", length = 1000)
	public String getDppMopCode() {
		return dppMopCode;
	}

	public void setDppMopCode(String dppMopCode) {
		this.dppMopCode = dppMopCode;
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

}
