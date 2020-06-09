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
 * VPgpmliste generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_PGPMLISTE")
public class VPgpmliste implements java.io.Serializable {

	private long gpgId;
	private String fipTypeFinance;
	private String gpgLibFin;
	private Date gpgDteModif;
	private String gpgObjet;
	private String gpgStaCode;
	private String gpgTypePlan;
	private String gpgActeurSaisie;
	private Date gpgDateDao;
	private String gpgFonCodPf;
	private String gpgFonCodDmp;
	private String tymCode;
	private String tymLibelleCourt;
	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String gpgRecherche;
	private Date gpgDateValAc;
	private Date gpgDateValCpmp;
	private Date gpgDateValDmp;
	private String gpgStatutRetour;
	private String ac;
	private Long gpgAgpId;
	private String gpgCommentaire;
	private String gpgPartiePmePmi;
	private String gpgStrCode;
	private String tstCode;
	private long plgId;
	private long plgGesCode;

	public VPgpmliste() {
	}

	public VPgpmliste(long gpgId, String gpgStaCode, String gpgTypePlan, String tymCode, String tymLibelleCourt,
			String mopCode, String mopLibelleCourt, long plgId, short plgGesCode) {
		this.gpgId = gpgId;
		this.gpgStaCode = gpgStaCode;
		this.gpgTypePlan = gpgTypePlan;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
	}

	public VPgpmliste(String fipTypeFinance, long gpgId,String gpgLibFin, Date gpgDteModif, String gpgObjet, String gpgStaCode,
			String gpgTypePlan, String gpgActeurSaisie, Date gpgDateDao, String gpgFonCodPf, String gpgFonCodDmp,
			String tymCode, String tymLibelleCourt, String mopCode, String mopLibelleCourt, String mopLibelleLong,
			String gpgRecherche,Date gpgDateValAc, Date gpgDateValCpmp, Date gpgDateValDmp,String gpgStatutRetour,String ac, Long gpgAgpId,String gpgCommentaire, String gpgPartiePmePmi,
			String gpgStrCode,String tstCode, long plgId, long plgGesCode) {
		this.fipTypeFinance = fipTypeFinance;
		this.gpgId = gpgId;
		this.gpgLibFin = gpgLibFin;
		this.gpgDteModif = gpgDteModif;
		this.gpgObjet = gpgObjet;
		this.gpgStaCode = gpgStaCode;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgActeurSaisie = gpgActeurSaisie;
		this.gpgDateDao = gpgDateDao;
		this.gpgFonCodPf = gpgFonCodPf;
		this.gpgFonCodDmp = gpgFonCodDmp;
		this.gpgStatutRetour = gpgStatutRetour;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.gpgRecherche = gpgRecherche;
		this.gpgDateValAc = gpgDateValAc;
		this.gpgDateValCpmp = gpgDateValCpmp;
		this.gpgDateValDmp = gpgDateValDmp;
		this.ac = ac;
		this.gpgAgpId = gpgAgpId;
		this.gpgCommentaire = gpgCommentaire;
		this.gpgPartiePmePmi = gpgPartiePmePmi;
		this.gpgStrCode = gpgStrCode;
		this.tstCode = tstCode;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
	}

	@Id
	@Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getGpgId() {
		return this.gpgId;
	}

	public void setGpgId(long gpgId) {
		this.gpgId = gpgId;
	}
	@Column(name = "FIP_TYPE_FINANCE", length = 20)
	public String getFipTypeFinance() {
		return this.fipTypeFinance;
	}

	public void setFipTypeFinance(String fipTypeFinance) {
		this.fipTypeFinance = fipTypeFinance;
	}
	
	@Column(name = "GPG_LIB_FIN", length = 200)
	public String getGpgLibFin() {
		return this.gpgLibFin;
	}

	public void setGpgLibFin(String gpgLibFin) {
		this.gpgLibFin = gpgLibFin;
	}

	@Column(name = "GPG_DTE_MODIF", length = 7)
	public Date getGpgDteModif() {
		return this.gpgDteModif;
	}

	public void setGpgDteModif(Date gpgDteModif) {
		this.gpgDteModif = gpgDteModif;
	}

	@Column(name = "GPG_OBJET", length = 1000)
	public String getGpgObjet() {
		return this.gpgObjet;
	}

	public void setGpgObjet(String gpgObjet) {
		this.gpgObjet = gpgObjet;
	}

	@Column(name = "GPG_STA_CODE", nullable = false, length = 3)
	public String getGpgStaCode() {
		return this.gpgStaCode;
	}

	public void setGpgStaCode(String gpgStaCode) {
		this.gpgStaCode = gpgStaCode;
	}

	@Column(name = "GPG_TYPE_PLAN", nullable = false, length = 3)
	public String getGpgTypePlan() {
		return this.gpgTypePlan;
	}

	public void setGpgTypePlan(String gpgTypePlan) {
		this.gpgTypePlan = gpgTypePlan;
	}

	@Column(name = "GPG_ACTEUR_SAISIE", length = 12)
	public String getGpgActeurSaisie() {
		return this.gpgActeurSaisie;
	}

	public void setGpgActeurSaisie(String gpgActeurSaisie) {
		this.gpgActeurSaisie = gpgActeurSaisie;
	}

	@Column(name = "GPG_DATE_DAO", length = 7)
	public Date getGpgDateDao() {
		return this.gpgDateDao;
	}

	public void setGpgDateDao(Date gpgDateDao) {
		this.gpgDateDao = gpgDateDao;
	}

	@Column(name = "GPG_FON_COD_PF", length = 20)
	public String getGpgFonCodPf() {
		return this.gpgFonCodPf;
	}

	public void setGpgFonCodPf(String gpgFonCodPf) {
		this.gpgFonCodPf = gpgFonCodPf;
	}

	@Column(name = "GPG_FON_COD_DMP", length = 20)
	public String getGpgFonCodDmp() {
		return this.gpgFonCodDmp;
	}

	public void setGpgFonCodDmp(String gpgFonCodDmp) {
		this.gpgFonCodDmp = gpgFonCodDmp;
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

	@Column(name = "GPG_RECHERCHE", length = 4000)
	public String getGpgRecherche() {
		return this.gpgRecherche;
	}

	public void setGpgRecherche(String gpgRecherche) {
		this.gpgRecherche = gpgRecherche;
	}
	
	@Column(name = "GPG_DATE_VAL_AC", length = 7)
	public Date getGpgDateValAc() {
		return this.gpgDateValAc;
	}

	public void setGpgDateValAc(Date gpgDateValAc) {
		this.gpgDateValAc = gpgDateValAc;
	}

	@Column(name = "GPG_DATE_VAL_CPMP", length = 7)
	public Date getGpgDateValCpmp() {
		return this.gpgDateValCpmp;
	}

	public void setGpgDateValCpmp(Date gpgDateValCpmp) {
		this.gpgDateValCpmp = gpgDateValCpmp;
	}

	@Column(name = "GPG_DATE_VAL_DMP", length = 7)
	public Date getGpgDateValDmp() {
		return this.gpgDateValDmp;
	}

	public void setGpgDateValDmp(Date gpgDateValDmp) {
		this.gpgDateValDmp = gpgDateValDmp;
	}
	
	@Column(name = "GPG_STATUT_RETOUR", length = 4)
	public String getGpgStatutRetour() {
		return this.gpgStatutRetour;
	}

	public void setGpgStatutRetour(String gpgStatutRetour) {
		this.gpgStatutRetour = gpgStatutRetour;
	}
	
	@Column(name = "AC", length = 515)
	public String getAc() {
		return this.ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	@Column(name = "GPG_AGP_ID", precision = 10, scale = 0)
	public Long getGpgAgpId() {
		return this.gpgAgpId;
	}

	public void setGpgAgpId(Long gpgAgpId) {
		this.gpgAgpId = gpgAgpId;
	}
	
	@Column(name = "GPG_COMMENTAIRE", length = 1000)
	public String getGpgCommentaire() {
		return this.gpgCommentaire;
	}

	public void setGpgCommentaire(String gpgCommentaire) {
		this.gpgCommentaire = gpgCommentaire;
	}

	@Column(name = "GPG_PARTIE_PME_PMI", length = 1)
	public String getGpgPartiePmePmi() {
		return this.gpgPartiePmePmi;
	}

	public void setGpgPartiePmePmi(String gpgPartiePmePmi) {
		this.gpgPartiePmePmi = gpgPartiePmePmi;
	}
	
	@Column(name = "GPG_STR_CODE", length = 20)
	public String getGpgStrCode() {
		return this.gpgStrCode;
	}

	public void setGpgStrCode(String gpgStrCode) {
		this.gpgStrCode = gpgStrCode;
	}

	@Column(name = "TST_CODE", nullable = false, length = 3)
	public String getTstCode() {
		return this.tstCode;
	}

	public void setTstCode(String tstCode) {
		this.tstCode = tstCode;
	}


	@Column(name = "PLG_ID", nullable = false, precision = 10, scale = 0)
	public long getPlgId() {
		return this.plgId;
	}

	public void setPlgId(long plgId) {
		this.plgId = plgId;
	}

	@Column(name = "PLG_GES_CODE")
	public long getPlgGesCode() {
		return this.plgGesCode;
	}

	public void setPlgGesCode(long plgGesCode) {
		this.plgGesCode = plgGesCode;
	}

}
