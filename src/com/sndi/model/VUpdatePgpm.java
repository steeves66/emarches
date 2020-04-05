package com.sndi.model;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VUpdatePgpmId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_UPDATE_PGPM")
public class VUpdatePgpm implements java.io.Serializable {

	private Long affGpgId;
	private long affGpgPlgId;
	private Long affGpgAgpId;
	private String affGpgTypePlan;
	private String affGpgStaCode;
	private String affGpgTymCode;
	private String affGpgMopCode;
	private String affGpgCode;
	private String affGpgObjet;
	private Integer affGpgNumeroOrdre;
	private String affGpgPartiePmePmi;
	private String affGpgCommentaire;
	private String affGpgSourceFin;
	private Date affGpgDateDao;
	private String affGpgActeurSaisie;
	private String affGpgStatutRetour;
	private Date affGpgDateSaisie;
	private String affGpgFonCod;
	private long affId;
	private String affGpgStrCode;
	private String gpgLibFin;
	private Short affGpgGesCode;
	private String affGpgRecherche;
	private Date affGpgDateValAc;
	private Date affGpgDateValCpmp;
	private Date affGpgDateValDmp;
	private String affGpgTypeFinance;
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
	private Date gpgDateValAc;
	private Date gpgDateValCpmp;
	private Date gpgDateValDmp;
	private long plgId;
	private String plgStrCode;
	private String plgFonCod;
	private short plgGesCode;
	private String plgCode;
	private String plgLibelle;
	private long fipId;
	private String fipDevCode;
	private String fipBaiCode;
	private String fipSouCode;
	private long fipGpgId;
	private BigDecimal fipMontantCfa;
	private BigDecimal fipMontantDevise;
	private String fipCommentaire;
	private String fipTypeFinance;
	private BigDecimal fipTresor;
	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String tymCode;
	private String tymLibelleCourt;
	private String tymLibelleLong;
	private String tymTymCode;
	private String tymGroupe;

	public VUpdatePgpm() {
	}

	public VUpdatePgpm(long affGpgPlgId, String affGpgTypePlan, String affGpgStaCode, String affGpgTymCode,String gpgLibFin,
			String affGpgMopCode, long affId, long gpgId, long gpgPlgId, String gpgTypePlan, String gpgStaCode,
			String gpgTymCode, String gpgMopCode, long plgId, String plgStrCode, String plgFonCod, short plgGesCode,
			long fipId, String fipDevCode, String fipSouCode, long fipGpgId, String mopCode, String mopLibelleCourt,
			String tymCode, String tymLibelleCourt) {
		this.affGpgPlgId = affGpgPlgId;
		this.affGpgTypePlan = affGpgTypePlan;
		this.affGpgStaCode = affGpgStaCode;
		this.affGpgTymCode = affGpgTymCode;
		this.affGpgMopCode = affGpgMopCode;
		this.affId = affId;
		this.gpgId = gpgId;
		this.gpgPlgId = gpgPlgId;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgStaCode = gpgStaCode;
		this.gpgTymCode = gpgTymCode;
		this.gpgMopCode = gpgMopCode;
		this.plgId = plgId;
		this.plgStrCode = plgStrCode;
		this.plgFonCod = plgFonCod;
		this.plgGesCode = plgGesCode;
		this.fipId = fipId;
		this.fipDevCode = fipDevCode;
		this.fipSouCode = fipSouCode;
		this.fipGpgId = fipGpgId;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.gpgLibFin = gpgLibFin;
	}

	public VUpdatePgpm(Long affGpgId, long affGpgPlgId, Long affGpgAgpId, String affGpgTypePlan, String affGpgStaCode,String gpgLibFin,
			String affGpgTymCode, String affGpgMopCode, String affGpgCode, String affGpgObjet,
			Integer affGpgNumeroOrdre, String affGpgPartiePmePmi, String affGpgCommentaire, String affGpgSourceFin,
			Date affGpgDateDao, String affGpgActeurSaisie, String affGpgStatutRetour, Date affGpgDateSaisie,
			String affGpgFonCod, long affId, String affGpgStrCode, Short affGpgGesCode, String affGpgRecherche,
			Date affGpgDateValAc, Date affGpgDateValCpmp, Date affGpgDateValDmp, String affGpgTypeFinance, long gpgId,
			long gpgPlgId, Long gpgAgpId, String gpgTypePlan, String gpgStaCode, String gpgTymCode, String gpgMopCode,
			String gpgCode, String gpgObjet, Integer gpgNumeroOrdre, String gpgPartiePmePmi, String gpgCommentaire,
			String gpgSourceFin, Date gpgDateDao, String gpgActeurSaisie, String gpgStatutRetour, Date gpgDateSaisie,
			String gpgStrCode, Date gpgDateValAc, Date gpgDateValCpmp, Date gpgDateValDmp, long plgId,
			String plgStrCode, String plgFonCod, short plgGesCode, String plgCode, String plgLibelle, long fipId,
			String fipDevCode, String fipBaiCode, String fipSouCode, long fipGpgId, BigDecimal fipMontantCfa,
			BigDecimal fipMontantDevise, String fipCommentaire, String fipTypeFinance, BigDecimal fipTresor,
			String mopCode, String mopLibelleCourt, String mopLibelleLong, String tymCode, String tymLibelleCourt,
			String tymLibelleLong, String tymTymCode, String tymGroupe) {
		this.affGpgId = affGpgId;
		this.affGpgPlgId = affGpgPlgId;
		this.affGpgAgpId = affGpgAgpId;
		this.affGpgTypePlan = affGpgTypePlan;
		this.affGpgStaCode = affGpgStaCode;
		this.affGpgTymCode = affGpgTymCode;
		this.affGpgMopCode = affGpgMopCode;
		this.affGpgCode = affGpgCode;
		this.affGpgObjet = affGpgObjet;
		this.affGpgNumeroOrdre = affGpgNumeroOrdre;
		this.affGpgPartiePmePmi = affGpgPartiePmePmi;
		this.affGpgCommentaire = affGpgCommentaire;
		this.affGpgSourceFin = affGpgSourceFin;
		this.affGpgDateDao = affGpgDateDao;
		this.affGpgActeurSaisie = affGpgActeurSaisie;
		this.affGpgStatutRetour = affGpgStatutRetour;
		this.affGpgDateSaisie = affGpgDateSaisie;
		this.affGpgFonCod = affGpgFonCod;
		this.affId = affId;
		this.affGpgStrCode = affGpgStrCode;
		this.affGpgGesCode = affGpgGesCode;
		this.affGpgRecherche = affGpgRecherche;
		this.affGpgDateValAc = affGpgDateValAc;
		this.affGpgDateValCpmp = affGpgDateValCpmp;
		this.affGpgDateValDmp = affGpgDateValDmp;
		this.affGpgTypeFinance = affGpgTypeFinance;
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
		this.gpgDateValAc = gpgDateValAc;
		this.gpgDateValCpmp = gpgDateValCpmp;
		this.gpgDateValDmp = gpgDateValDmp;
		this.plgId = plgId;
		this.plgStrCode = plgStrCode;
		this.plgFonCod = plgFonCod;
		this.plgGesCode = plgGesCode;
		this.plgCode = plgCode;
		this.plgLibelle = plgLibelle;
		this.fipId = fipId;
		this.fipDevCode = fipDevCode;
		this.fipBaiCode = fipBaiCode;
		this.fipSouCode = fipSouCode;
		this.fipGpgId = fipGpgId;
		this.fipMontantCfa = fipMontantCfa;
		this.fipMontantDevise = fipMontantDevise;
		this.fipCommentaire = fipCommentaire;
		this.fipTypeFinance = fipTypeFinance;
		this.fipTresor = fipTresor;
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.tymLibelleLong = tymLibelleLong;
		this.tymTymCode = tymTymCode;
		this.tymGroupe = tymGroupe;
		this.gpgLibFin = gpgLibFin;
		
	}
	
	@Id
	@Column(name = "AFF_ID", nullable = false, precision = 10, scale = 0)
	public long getAffId() {
		return this.affId;
	}

	public void setAffId(long affId) {
		this.affId = affId;
	}

	@Column(name = "AFF_GPG_ID", precision = 10, scale = 0)
	public Long getAffGpgId() {
		return this.affGpgId;
	}

	public void setAffGpgId(Long affGpgId) {
		this.affGpgId = affGpgId;
	}

	@Column(name = "AFF_GPG_PLG_ID", nullable = false, precision = 10, scale = 0)
	public long getAffGpgPlgId() {
		return this.affGpgPlgId;
	}

	public void setAffGpgPlgId(long affGpgPlgId) {
		this.affGpgPlgId = affGpgPlgId;
	}

	@Column(name = "AFF_GPG_AGP_ID", precision = 10, scale = 0)
	public Long getAffGpgAgpId() {
		return this.affGpgAgpId;
	}

	public void setAffGpgAgpId(Long affGpgAgpId) {
		this.affGpgAgpId = affGpgAgpId;
	}

	@Column(name = "AFF_GPG_TYPE_PLAN", nullable = false, length = 3)
	public String getAffGpgTypePlan() {
		return this.affGpgTypePlan;
	}

	public void setAffGpgTypePlan(String affGpgTypePlan) {
		this.affGpgTypePlan = affGpgTypePlan;
	}

	@Column(name = "AFF_GPG_STA_CODE", nullable = false, length = 3)
	public String getAffGpgStaCode() {
		return this.affGpgStaCode;
	}

	public void setAffGpgStaCode(String affGpgStaCode) {
		this.affGpgStaCode = affGpgStaCode;
	}

	@Column(name = "AFF_GPG_TYM_CODE", nullable = false, length = 3)
	public String getAffGpgTymCode() {
		return this.affGpgTymCode;
	}

	public void setAffGpgTymCode(String affGpgTymCode) {
		this.affGpgTymCode = affGpgTymCode;
	}

	@Column(name = "AFF_GPG_MOP_CODE", nullable = false, length = 3)
	public String getAffGpgMopCode() {
		return this.affGpgMopCode;
	}

	public void setAffGpgMopCode(String affGpgMopCode) {
		this.affGpgMopCode = affGpgMopCode;
	}

	@Column(name = "AFF_GPG_CODE", length = 50)
	public String getAffGpgCode() {
		return this.affGpgCode;
	}

	public void setAffGpgCode(String affGpgCode) {
		this.affGpgCode = affGpgCode;
	}

	@Column(name = "AFF_GPG_OBJET", length = 1000)
	public String getAffGpgObjet() {
		return this.affGpgObjet;
	}

	public void setAffGpgObjet(String affGpgObjet) {
		this.affGpgObjet = affGpgObjet;
	}

	@Column(name = "AFF_GPG_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getAffGpgNumeroOrdre() {
		return this.affGpgNumeroOrdre;
	}

	public void setAffGpgNumeroOrdre(Integer affGpgNumeroOrdre) {
		this.affGpgNumeroOrdre = affGpgNumeroOrdre;
	}

	@Column(name = "AFF_GPG_PARTIE_PME_PMI", length = 1)
	public String getAffGpgPartiePmePmi() {
		return this.affGpgPartiePmePmi;
	}

	public void setAffGpgPartiePmePmi(String affGpgPartiePmePmi) {
		this.affGpgPartiePmePmi = affGpgPartiePmePmi;
	}

	@Column(name = "AFF_GPG_COMMENTAIRE", length = 1000)
	public String getAffGpgCommentaire() {
		return this.affGpgCommentaire;
	}

	public void setAffGpgCommentaire(String affGpgCommentaire) {
		this.affGpgCommentaire = affGpgCommentaire;
	}

	@Column(name = "AFF_GPG_SOURCE_FIN", length = 5)
	public String getAffGpgSourceFin() {
		return this.affGpgSourceFin;
	}

	public void setAffGpgSourceFin(String affGpgSourceFin) {
		this.affGpgSourceFin = affGpgSourceFin;
	}

	@Column(name = "AFF_GPG_DATE_DAO", length = 7)
	public Date getAffGpgDateDao() {
		return this.affGpgDateDao;
	}

	public void setAffGpgDateDao(Date affGpgDateDao) {
		this.affGpgDateDao = affGpgDateDao;
	}

	@Column(name = "AFF_GPG_ACTEUR_SAISIE", length = 12)
	public String getAffGpgActeurSaisie() {
		return this.affGpgActeurSaisie;
	}

	public void setAffGpgActeurSaisie(String affGpgActeurSaisie) {
		this.affGpgActeurSaisie = affGpgActeurSaisie;
	}

	@Column(name = "AFF_GPG_STATUT_RETOUR", length = 4)
	public String getAffGpgStatutRetour() {
		return this.affGpgStatutRetour;
	}

	public void setAffGpgStatutRetour(String affGpgStatutRetour) {
		this.affGpgStatutRetour = affGpgStatutRetour;
	}

	@Column(name = "AFF_GPG_DATE_SAISIE", length = 7)
	public Date getAffGpgDateSaisie() {
		return this.affGpgDateSaisie;
	}

	public void setAffGpgDateSaisie(Date affGpgDateSaisie) {
		this.affGpgDateSaisie = affGpgDateSaisie;
	}

	@Column(name = "AFF_GPG_FON_COD", length = 12)
	public String getAffGpgFonCod() {
		return this.affGpgFonCod;
	}

	public void setAffGpgFonCod(String affGpgFonCod) {
		this.affGpgFonCod = affGpgFonCod;
	}

	

	@Column(name = "AFF_GPG_STR_CODE", length = 3)
	public String getAffGpgStrCode() {
		return this.affGpgStrCode;
	}

	public void setAffGpgStrCode(String affGpgStrCode) {
		this.affGpgStrCode = affGpgStrCode;
	}

	@Column(name = "AFF_GPG_GES_CODE", precision = 4, scale = 0)
	public Short getAffGpgGesCode() {
		return this.affGpgGesCode;
	}

	public void setAffGpgGesCode(Short affGpgGesCode) {
		this.affGpgGesCode = affGpgGesCode;
	}

	@Column(name = "AFF_GPG_RECHERCHE", length = 4000)
	public String getAffGpgRecherche() {
		return this.affGpgRecherche;
	}

	public void setAffGpgRecherche(String affGpgRecherche) {
		this.affGpgRecherche = affGpgRecherche;
	}

	@Column(name = "AFF_GPG_DATE_VAL_AC", length = 7)
	public Date getAffGpgDateValAc() {
		return this.affGpgDateValAc;
	}

	public void setAffGpgDateValAc(Date affGpgDateValAc) {
		this.affGpgDateValAc = affGpgDateValAc;
	}

	@Column(name = "AFF_GPG_DATE_VAL_CPMP", length = 7)
	public Date getAffGpgDateValCpmp() {
		return this.affGpgDateValCpmp;
	}

	public void setAffGpgDateValCpmp(Date affGpgDateValCpmp) {
		this.affGpgDateValCpmp = affGpgDateValCpmp;
	}

	@Column(name = "AFF_GPG_DATE_VAL_DMP", length = 7)
	public Date getAffGpgDateValDmp() {
		return this.affGpgDateValDmp;
	}

	public void setAffGpgDateValDmp(Date affGpgDateValDmp) {
		this.affGpgDateValDmp = affGpgDateValDmp;
	}

	@Column(name = "AFF_GPG_TYPE_FINANCE", length = 20)
	public String getAffGpgTypeFinance() {
		return this.affGpgTypeFinance;
	}

	public void setAffGpgTypeFinance(String affGpgTypeFinance) {
		this.affGpgTypeFinance = affGpgTypeFinance;
	}

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

	@Column(name = "PLG_ID", nullable = false, precision = 10, scale = 0)
	public long getPlgId() {
		return this.plgId;
	}

	public void setPlgId(long plgId) {
		this.plgId = plgId;
	}

	@Column(name = "PLG_STR_CODE", nullable = false, length = 3)
	public String getPlgStrCode() {
		return this.plgStrCode;
	}

	public void setPlgStrCode(String plgStrCode) {
		this.plgStrCode = plgStrCode;
	}

	@Column(name = "PLG_FON_COD", nullable = false, length = 12)
	public String getPlgFonCod() {
		return this.plgFonCod;
	}

	public void setPlgFonCod(String plgFonCod) {
		this.plgFonCod = plgFonCod;
	}

	@Column(name = "PLG_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getPlgGesCode() {
		return this.plgGesCode;
	}

	public void setPlgGesCode(short plgGesCode) {
		this.plgGesCode = plgGesCode;
	}

	@Column(name = "PLG_CODE", length = 50)
	public String getPlgCode() {
		return this.plgCode;
	}

	public void setPlgCode(String plgCode) {
		this.plgCode = plgCode;
	}

	@Column(name = "PLG_LIBELLE", length = 1000)
	public String getPlgLibelle() {
		return this.plgLibelle;
	}

	public void setPlgLibelle(String plgLibelle) {
		this.plgLibelle = plgLibelle;
	}

	@Column(name = "FIP_ID", nullable = false, precision = 10, scale = 0)
	public long getFipId() {
		return this.fipId;
	}

	public void setFipId(long fipId) {
		this.fipId = fipId;
	}

	@Column(name = "FIP_DEV_CODE", nullable = false, length = 8)
	public String getFipDevCode() {
		return this.fipDevCode;
	}

	public void setFipDevCode(String fipDevCode) {
		this.fipDevCode = fipDevCode;
	}

	@Column(name = "FIP_BAI_CODE", length = 5)
	public String getFipBaiCode() {
		return this.fipBaiCode;
	}

	public void setFipBaiCode(String fipBaiCode) {
		this.fipBaiCode = fipBaiCode;
	}

	@Column(name = "FIP_SOU_CODE", nullable = false, length = 5)
	public String getFipSouCode() {
		return this.fipSouCode;
	}

	public void setFipSouCode(String fipSouCode) {
		this.fipSouCode = fipSouCode;
	}

	@Column(name = "FIP_GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getFipGpgId() {
		return this.fipGpgId;
	}

	public void setFipGpgId(long fipGpgId) {
		this.fipGpgId = fipGpgId;
	}

	@Column(name = "FIP_MONTANT_CFA", precision = 15)
	public BigDecimal getFipMontantCfa() {
		return this.fipMontantCfa;
	}

	public void setFipMontantCfa(BigDecimal fipMontantCfa) {
		this.fipMontantCfa = fipMontantCfa;
	}

	@Column(name = "FIP_MONTANT_DEVISE", precision = 15)
	public BigDecimal getFipMontantDevise() {
		return this.fipMontantDevise;
	}

	public void setFipMontantDevise(BigDecimal fipMontantDevise) {
		this.fipMontantDevise = fipMontantDevise;
	}

	@Column(name = "FIP_COMMENTAIRE", length = 500)
	public String getFipCommentaire() {
		return this.fipCommentaire;
	}

	public void setFipCommentaire(String fipCommentaire) {
		this.fipCommentaire = fipCommentaire;
	}

	@Column(name = "FIP_TYPE_FINANCE", length = 20)
	public String getFipTypeFinance() {
		return this.fipTypeFinance;
	}

	public void setFipTypeFinance(String fipTypeFinance) {
		this.fipTypeFinance = fipTypeFinance;
	}

	@Column(name = "FIP_TRESOR", precision = 22, scale = 0)
	public BigDecimal getFipTresor() {
		return this.fipTresor;
	}

	public void setFipTresor(BigDecimal fipTresor) {
		this.fipTresor = fipTresor;
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

	@Column(name = "GPG_LIB_FIN")
	public String getGpgLibFin() {
		return gpgLibFin;
	}

	public void setGpgLibFin(String gpgLibFin) {
		this.gpgLibFin = gpgLibFin;
	}
}
