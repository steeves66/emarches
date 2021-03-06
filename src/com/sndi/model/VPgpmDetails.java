package com.sndi.model;
// Generated 28 mai 2020 00:24:11 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VPgpmDetails generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_PGPM_DETAILS")
public class VPgpmDetails implements java.io.Serializable {

	private BigDecimal VId;
	private String affStatut;
	private long gpgId;
	private String souLibelle;
	private String gpgObjet;
	private String gpgStaCode;
	private String gpgTypePlan;
	private String gpgActeurSaisie;
	private String gpgLibFin;
	private String fonLibelle;
	private String tymCode;
	private String tymLibelleCourt;
	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String gpgPartiePmePmi;
	private Date gpgDateDao;
	private String gpgCommentaire;
	private Integer gpgNumeroOrdre;
	private Date gpgDateSaisie;
	private long plgId;
	private short plgGesCode;
	private String minLibelle;
	private String minLibelleCourt;
	private String strCode;
	private String strLibelleCourt;
	private String strLibelleLong;

	public VPgpmDetails() {
	}

	public VPgpmDetails(long gpgId, String gpgStaCode, String gpgTypePlan, String tymCode, String tymLibelleCourt,
			String mopCode, String mopLibelleCourt, long plgId, short plgGesCode, String strCode,
			String strLibelleCourt) {
		this.gpgId = gpgId;
		this.gpgStaCode = gpgStaCode;
		this.gpgTypePlan = gpgTypePlan;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
	}

	public VPgpmDetails(BigDecimal VId, String affStatut, long gpgId, String souLibelle, String gpgObjet,
			String gpgStaCode, String gpgTypePlan, String gpgActeurSaisie, String gpgLibFin, String fonLibelle, String tymCode,
			String tymLibelleCourt, String mopCode, String mopLibelleCourt, String mopLibelleLong,
			String gpgPartiePmePmi, Date gpgDateDao, String gpgCommentaire, Integer gpgNumeroOrdre, Date gpgDateSaisie,
			long plgId, short plgGesCode, String minLibelle, String minLibelleCourt, String strCode,
			String strLibelleCourt, String strLibelleLong) {
		this.VId = VId;
		this.affStatut = affStatut;
		this.gpgId = gpgId;
		this.souLibelle = souLibelle;
		this.gpgObjet = gpgObjet;
		this.gpgStaCode = gpgStaCode;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgActeurSaisie = gpgActeurSaisie;
		this.gpgLibFin = gpgLibFin;
		this.fonLibelle = fonLibelle;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.gpgPartiePmePmi = gpgPartiePmePmi;
		this.gpgDateDao = gpgDateDao;
		this.gpgCommentaire = gpgCommentaire;
		this.gpgNumeroOrdre = gpgNumeroOrdre;
		this.gpgDateSaisie = gpgDateSaisie;
		this.plgId = plgId;
		this.plgGesCode = plgGesCode;
		this.minLibelle = minLibelle;
		this.minLibelleCourt = minLibelleCourt;
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
		this.strLibelleLong = strLibelleLong;
	}


	@Id
	@Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getGpgId() {
		return this.gpgId;
	}

	public void setGpgId(long gpgId) {
		this.gpgId = gpgId;
	}
	
	@Column(name = "V_ID", precision = 22, scale = 0)
	public BigDecimal getVId() {
		return this.VId;
	}

	public void setVId(BigDecimal VId) {
		this.VId = VId;
	}

	@Column(name = "AFF_STATUT", length = 19)
	public String getAffStatut() {
		return this.affStatut;
	}

	public void setAffStatut(String affStatut) {
		this.affStatut = affStatut;
	}


	@Column(name = "SOU_LIBELLE", length = 500)
	public String getSouLibelle() {
		return this.souLibelle;
	}

	public void setSouLibelle(String souLibelle) {
		this.souLibelle = souLibelle;
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
	
	@Column(name = "GPG_LIB_FIN", length = 200)
	public String getGpgLibFin() {
		return this.gpgLibFin;
	}

	public void setGpgLibFin(String gpgLibFin) {
		this.gpgLibFin = gpgLibFin;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
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

	@Column(name = "GPG_PARTIE_PME_PMI", length = 1)
	public String getGpgPartiePmePmi() {
		return this.gpgPartiePmePmi;
	}

	public void setGpgPartiePmePmi(String gpgPartiePmePmi) {
		this.gpgPartiePmePmi = gpgPartiePmePmi;
	}

	@Column(name = "GPG_DATE_DAO", length = 7)
	public Date getGpgDateDao() {
		return this.gpgDateDao;
	}

	public void setGpgDateDao(Date gpgDateDao) {
		this.gpgDateDao = gpgDateDao;
	}

	@Column(name = "GPG_COMMENTAIRE", length = 1000)
	public String getGpgCommentaire() {
		return this.gpgCommentaire;
	}

	public void setGpgCommentaire(String gpgCommentaire) {
		this.gpgCommentaire = gpgCommentaire;
	}

	@Column(name = "GPG_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getGpgNumeroOrdre() {
		return this.gpgNumeroOrdre;
	}

	public void setGpgNumeroOrdre(Integer gpgNumeroOrdre) {
		this.gpgNumeroOrdre = gpgNumeroOrdre;
	}

	@Column(name = "GPG_DATE_SAISIE", length = 7)
	public Date getGpgDateSaisie() {
		return this.gpgDateSaisie;
	}

	public void setGpgDateSaisie(Date gpgDateSaisie) {
		this.gpgDateSaisie = gpgDateSaisie;
	}

	@Column(name = "PLG_ID", nullable = false, precision = 10, scale = 0)
	public long getPlgId() {
		return this.plgId;
	}

	public void setPlgId(long plgId) {
		this.plgId = plgId;
	}

	@Column(name = "PLG_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getPlgGesCode() {
		return this.plgGesCode;
	}

	public void setPlgGesCode(short plgGesCode) {
		this.plgGesCode = plgGesCode;
	}

	@Column(name = "MIN_LIBELLE", length = 1000)
	public String getMinLibelle() {
		return this.minLibelle;
	}

	public void setMinLibelle(String minLibelle) {
		this.minLibelle = minLibelle;
	}

	@Column(name = "MIN_LIBELLE_COURT", length = 500)
	public String getMinLibelleCourt() {
		return this.minLibelleCourt;
	}

	public void setMinLibelleCourt(String minLibelleCourt) {
		this.minLibelleCourt = minLibelleCourt;
	}

	@Column(name = "STR_CODE", nullable = false, length = 20)
	public String getStrCode() {
		return this.strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	@Column(name = "STR_LIBELLE_COURT", nullable = false, length = 500)
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
}
