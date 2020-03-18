package com.sndi.model;
// Generated 4 f�vr. 2020 12:07:17 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VPgpmFonction generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_PGPM_FONCTION")
public class VPgpmFonction implements java.io.Serializable {

	private long gpgId;
	private long gpgPlgId;
	private Long gpgAgpId;
	private String gpgTypePlan;
	private String gpgStaCode;
	private String gpgTymCode;
	private String gpgMopCode;
	private String gpgCode;
	private String gpgObjet;
	private Integer gpgNumeroOrdre;
	private String gpgPartiePmePmi;
	private String gpgCommentaire;
	private String gpgSourceFin;
	private Date gpgDateDao;
	private String gpgActeurSaisie;
	private String gpgStatutRetour;
	private Date gpgDateSaisie;
	private String gpgStrCode;
	private String tymLibelleCourt;
	private String tymTymCode;
	private String mopLibelleLong;
	private String plgFonCod;
	private String fonLibelle;

	public VPgpmFonction() {
	}

	public VPgpmFonction(long gpgId, long gpgPlgId, String gpgTypePlan, String gpgStaCode, String gpgTymCode,
			String gpgMopCode, String tymLibelleCourt, String plgFonCod) {
		this.gpgId = gpgId;
		this.gpgPlgId = gpgPlgId;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgStaCode = gpgStaCode;
		this.gpgTymCode = gpgTymCode;
		this.gpgMopCode = gpgMopCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.plgFonCod = plgFonCod;
	}

	public VPgpmFonction(long gpgId, long gpgPlgId, Long gpgAgpId, String gpgTypePlan, String gpgStaCode,
			String gpgTymCode, String gpgMopCode, String gpgCode, String gpgObjet, Integer gpgNumeroOrdre,
			String gpgPartiePmePmi, String gpgCommentaire, String gpgSourceFin, Date gpgDateDao, String gpgActeurSaisie,
			String gpgStatutRetour, Date gpgDateSaisie, String gpgStrCode, String tymLibelleCourt,String tymTymCode,
			String mopLibelleLong, String plgFonCod, String fonLibelle) {
		this.gpgId = gpgId;
		this.gpgPlgId = gpgPlgId;
		this.gpgAgpId = gpgAgpId;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgStaCode = gpgStaCode;
		this.gpgTymCode = gpgTymCode;
		this.gpgMopCode = gpgMopCode;
		this.gpgCode = gpgCode;
		this.gpgObjet = gpgObjet;
		this.gpgNumeroOrdre = gpgNumeroOrdre;
		this.gpgPartiePmePmi = gpgPartiePmePmi;
		this.gpgCommentaire = gpgCommentaire;
		this.gpgSourceFin = gpgSourceFin;
		this.gpgDateDao = gpgDateDao;
		this.gpgActeurSaisie = gpgActeurSaisie;
		this.gpgStatutRetour = gpgStatutRetour;
		this.gpgDateSaisie = gpgDateSaisie;
		this.gpgStrCode = gpgStrCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.tymTymCode = tymTymCode;
		this.mopLibelleLong = mopLibelleLong;
		this.plgFonCod = plgFonCod;
		this.fonLibelle = fonLibelle;
	}

	
	@Id
	@Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getGpgId() {
		return this.gpgId;
	}

	public void setGpgId(long gpgId) {
		this.gpgId = gpgId;
	}

	@Column(name = "GPG_PLG_ID", nullable = false, precision = 10, scale = 0)
	public long getGpgPlgId() {
		return this.gpgPlgId;
	}

	public void setGpgPlgId(long gpgPlgId) {
		this.gpgPlgId = gpgPlgId;
	}

	@Column(name = "GPG_AGP_ID", precision = 10, scale = 0)
	public Long getGpgAgpId() {
		return this.gpgAgpId;
	}

	public void setGpgAgpId(Long gpgAgpId) {
		this.gpgAgpId = gpgAgpId;
	}

	@Column(name = "GPG_TYPE_PLAN", nullable = false, length = 3)
	public String getGpgTypePlan() {
		return this.gpgTypePlan;
	}

	public void setGpgTypePlan(String gpgTypePlan) {
		this.gpgTypePlan = gpgTypePlan;
	}

	@Column(name = "GPG_STA_CODE", nullable = false, length = 3)
	public String getGpgStaCode() {
		return this.gpgStaCode;
	}

	public void setGpgStaCode(String gpgStaCode) {
		this.gpgStaCode = gpgStaCode;
	}

	@Column(name = "GPG_TYM_CODE", nullable = false, length = 3)
	public String getGpgTymCode() {
		return this.gpgTymCode;
	}

	public void setGpgTymCode(String gpgTymCode) {
		this.gpgTymCode = gpgTymCode;
	}

	@Column(name = "GPG_MOP_CODE", nullable = false, length = 3)
	public String getGpgMopCode() {
		return this.gpgMopCode;
	}

	public void setGpgMopCode(String gpgMopCode) {
		this.gpgMopCode = gpgMopCode;
	}

	@Column(name = "GPG_CODE", length = 50)
	public String getGpgCode() {
		return this.gpgCode;
	}

	public void setGpgCode(String gpgCode) {
		this.gpgCode = gpgCode;
	}

	@Column(name = "GPG_OBJET", length = 1000)
	public String getGpgObjet() {
		return this.gpgObjet;
	}

	public void setGpgObjet(String gpgObjet) {
		this.gpgObjet = gpgObjet;
	}

	@Column(name = "GPG_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getGpgNumeroOrdre() {
		return this.gpgNumeroOrdre;
	}

	public void setGpgNumeroOrdre(Integer gpgNumeroOrdre) {
		this.gpgNumeroOrdre = gpgNumeroOrdre;
	}

	@Column(name = "GPG_PARTIE_PME_PMI", length = 1)
	public String getGpgPartiePmePmi() {
		return this.gpgPartiePmePmi;
	}

	public void setGpgPartiePmePmi(String gpgPartiePmePmi) {
		this.gpgPartiePmePmi = gpgPartiePmePmi;
	}

	@Column(name = "GPG_COMMENTAIRE", length = 1000)
	public String getGpgCommentaire() {
		return this.gpgCommentaire;
	}

	public void setGpgCommentaire(String gpgCommentaire) {
		this.gpgCommentaire = gpgCommentaire;
	}

	@Column(name = "GPG_SOURCE_FIN", length = 1000)
	public String getGpgSourceFin() {
		return this.gpgSourceFin;
	}

	public void setGpgSourceFin(String gpgSourceFin) {
		this.gpgSourceFin = gpgSourceFin;
	}

	@Column(name = "GPG_DATE_DAO", length = 7)
	public Date getGpgDateDao() {
		return this.gpgDateDao;
	}

	public void setGpgDateDao(Date gpgDateDao) {
		this.gpgDateDao = gpgDateDao;
	}

	@Column(name = "GPG_ACTEUR_SAISIE", length = 12)
	public String getGpgActeurSaisie() {
		return this.gpgActeurSaisie;
	}

	public void setGpgActeurSaisie(String gpgActeurSaisie) {
		this.gpgActeurSaisie = gpgActeurSaisie;
	}

	@Column(name = "GPG_STATUT_RETOUR", length = 4)
	public String getGpgStatutRetour() {
		return this.gpgStatutRetour;
	}

	public void setGpgStatutRetour(String gpgStatutRetour) {
		this.gpgStatutRetour = gpgStatutRetour;
	}

	@Column(name = "GPG_DATE_SAISIE", length = 7)
	public Date getGpgDateSaisie() {
		return this.gpgDateSaisie;
	}

	public void setGpgDateSaisie(Date gpgDateSaisie) {
		this.gpgDateSaisie = gpgDateSaisie;
	}

	@Column(name = "GPG_STR_CODE", length = 3)
	public String getGpgStrCode() {
		return this.gpgStrCode;
	}

	public void setGpgStrCode(String gpgStrCode) {
		this.gpgStrCode = gpgStrCode;
	}

	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}
	

	@Column(name = "TYM_TYM_CODE", length = 3)
	public String getTymTymCode() {
		return this.tymTymCode;
	}

	public void setTymTymCode(String tymTymCode) {
		this.tymTymCode = tymTymCode;
	}

	@Column(name = "MOP_LIBELLE_LONG", length = 1000)
	public String getMopLibelleLong() {
		return this.mopLibelleLong;
	}

	public void setMopLibelleLong(String mopLibelleLong) {
		this.mopLibelleLong = mopLibelleLong;
	}

	@Column(name = "PLG_FON_COD", nullable = false, length = 12)
	public String getPlgFonCod() {
		return this.plgFonCod;
	}

	public void setPlgFonCod(String plgFonCod) {
		this.plgFonCod = plgFonCod;
	}

	@Column(name = "FON_LIBELLE", length = 240)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}


}
