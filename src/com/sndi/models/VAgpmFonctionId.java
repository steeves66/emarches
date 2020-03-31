package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VAgpmFonctionId generated by hbm2java
 */
@Embeddable
public class VAgpmFonctionId implements java.io.Serializable {

	private long agpId;
	private String agpStrCode;
	private String agpFonCod;
	private short agpGesCode;
	private String agpStaCode;
	private long agpProId;
	private Long agpDecId;
	private String agpCommentaire;
	private String agpTypeDao;
	private String agpModePassation;
	private String agpActif;
	private String agpStatutRetour;
	private String agpActeurSaisie;
	private Date agpDateValAc;
	private Date agpDateValCpmp;
	private Date agpDateValDmp;
	private long finId;
	private String finDevCode;
	private String finBaiCode;
	private String finSouCode;
	private long finProId;
	private BigDecimal finMontantCfa;
	private BigDecimal finMontantDevise;
	private String finNumeroAccord;
	private String finStatut;
	private Long finAgpId;
	private String finTypeFinance;
	private Long finPartTresor;
	private long proId;
	private Long proRegId;
	private String proCode;
	private String proTitre;
	private String proLibelle;
	private String proDescription;
	private BigDecimal proMontantTotCfa;
	private String proTypeProjet;

	public VAgpmFonctionId() {
	}

	public VAgpmFonctionId(long agpId, String agpStrCode, String agpFonCod, short agpGesCode, String agpStaCode,
			long agpProId, long finId, String finDevCode, String finSouCode, long finProId, long proId,
			String proTitre) {
		this.agpId = agpId;
		this.agpStrCode = agpStrCode;
		this.agpFonCod = agpFonCod;
		this.agpGesCode = agpGesCode;
		this.agpStaCode = agpStaCode;
		this.agpProId = agpProId;
		this.finId = finId;
		this.finDevCode = finDevCode;
		this.finSouCode = finSouCode;
		this.finProId = finProId;
		this.proId = proId;
		this.proTitre = proTitre;
	}

	public VAgpmFonctionId(long agpId, String agpStrCode, String agpFonCod, short agpGesCode, String agpStaCode,
			long agpProId, Long agpDecId, String agpCommentaire, String agpTypeDao, String agpModePassation,
			String agpActif, String agpStatutRetour, String agpActeurSaisie, Date agpDateValAc, Date agpDateValCpmp,
			Date agpDateValDmp, long finId, String finDevCode, String finBaiCode, String finSouCode, long finProId,
			BigDecimal finMontantCfa, BigDecimal finMontantDevise, String finNumeroAccord, String finStatut,
			Long finAgpId, String finTypeFinance, Long finPartTresor, long proId, Long proRegId, String proCode,
			String proTitre, String proLibelle, String proDescription, BigDecimal proMontantTotCfa,
			String proTypeProjet) {
		this.agpId = agpId;
		this.agpStrCode = agpStrCode;
		this.agpFonCod = agpFonCod;
		this.agpGesCode = agpGesCode;
		this.agpStaCode = agpStaCode;
		this.agpProId = agpProId;
		this.agpDecId = agpDecId;
		this.agpCommentaire = agpCommentaire;
		this.agpTypeDao = agpTypeDao;
		this.agpModePassation = agpModePassation;
		this.agpActif = agpActif;
		this.agpStatutRetour = agpStatutRetour;
		this.agpActeurSaisie = agpActeurSaisie;
		this.agpDateValAc = agpDateValAc;
		this.agpDateValCpmp = agpDateValCpmp;
		this.agpDateValDmp = agpDateValDmp;
		this.finId = finId;
		this.finDevCode = finDevCode;
		this.finBaiCode = finBaiCode;
		this.finSouCode = finSouCode;
		this.finProId = finProId;
		this.finMontantCfa = finMontantCfa;
		this.finMontantDevise = finMontantDevise;
		this.finNumeroAccord = finNumeroAccord;
		this.finStatut = finStatut;
		this.finAgpId = finAgpId;
		this.finTypeFinance = finTypeFinance;
		this.finPartTresor = finPartTresor;
		this.proId = proId;
		this.proRegId = proRegId;
		this.proCode = proCode;
		this.proTitre = proTitre;
		this.proLibelle = proLibelle;
		this.proDescription = proDescription;
		this.proMontantTotCfa = proMontantTotCfa;
		this.proTypeProjet = proTypeProjet;
	}

	@Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpId() {
		return this.agpId;
	}

	public void setAgpId(long agpId) {
		this.agpId = agpId;
	}

	@Column(name = "AGP_STR_CODE", nullable = false, length = 3)
	public String getAgpStrCode() {
		return this.agpStrCode;
	}

	public void setAgpStrCode(String agpStrCode) {
		this.agpStrCode = agpStrCode;
	}

	@Column(name = "AGP_FON_COD", nullable = false, length = 12)
	public String getAgpFonCod() {
		return this.agpFonCod;
	}

	public void setAgpFonCod(String agpFonCod) {
		this.agpFonCod = agpFonCod;
	}

	@Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getAgpGesCode() {
		return this.agpGesCode;
	}

	public void setAgpGesCode(short agpGesCode) {
		this.agpGesCode = agpGesCode;
	}

	@Column(name = "AGP_STA_CODE", nullable = false, length = 3)
	public String getAgpStaCode() {
		return this.agpStaCode;
	}

	public void setAgpStaCode(String agpStaCode) {
		this.agpStaCode = agpStaCode;
	}

	@Column(name = "AGP_PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpProId() {
		return this.agpProId;
	}

	public void setAgpProId(long agpProId) {
		this.agpProId = agpProId;
	}

	@Column(name = "AGP_DEC_ID", precision = 10, scale = 0)
	public Long getAgpDecId() {
		return this.agpDecId;
	}

	public void setAgpDecId(Long agpDecId) {
		this.agpDecId = agpDecId;
	}

	@Column(name = "AGP_COMMENTAIRE", length = 1000)
	public String getAgpCommentaire() {
		return this.agpCommentaire;
	}

	public void setAgpCommentaire(String agpCommentaire) {
		this.agpCommentaire = agpCommentaire;
	}

	@Column(name = "AGP_TYPE_DAO", length = 1000)
	public String getAgpTypeDao() {
		return this.agpTypeDao;
	}

	public void setAgpTypeDao(String agpTypeDao) {
		this.agpTypeDao = agpTypeDao;
	}

	@Column(name = "AGP_MODE_PASSATION", length = 1000)
	public String getAgpModePassation() {
		return this.agpModePassation;
	}

	public void setAgpModePassation(String agpModePassation) {
		this.agpModePassation = agpModePassation;
	}

	@Column(name = "AGP_ACTIF", length = 1)
	public String getAgpActif() {
		return this.agpActif;
	}

	public void setAgpActif(String agpActif) {
		this.agpActif = agpActif;
	}

	@Column(name = "AGP_STATUT_RETOUR", length = 2)
	public String getAgpStatutRetour() {
		return this.agpStatutRetour;
	}

	public void setAgpStatutRetour(String agpStatutRetour) {
		this.agpStatutRetour = agpStatutRetour;
	}

	@Column(name = "AGP_ACTEUR_SAISIE", length = 12)
	public String getAgpActeurSaisie() {
		return this.agpActeurSaisie;
	}

	public void setAgpActeurSaisie(String agpActeurSaisie) {
		this.agpActeurSaisie = agpActeurSaisie;
	}

	@Column(name = "AGP_DATE_VAL_AC", length = 7)
	public Date getAgpDateValAc() {
		return this.agpDateValAc;
	}

	public void setAgpDateValAc(Date agpDateValAc) {
		this.agpDateValAc = agpDateValAc;
	}

	@Column(name = "AGP_DATE_VAL_CPMP", length = 7)
	public Date getAgpDateValCpmp() {
		return this.agpDateValCpmp;
	}

	public void setAgpDateValCpmp(Date agpDateValCpmp) {
		this.agpDateValCpmp = agpDateValCpmp;
	}

	@Column(name = "AGP_DATE_VAL_DMP", length = 7)
	public Date getAgpDateValDmp() {
		return this.agpDateValDmp;
	}

	public void setAgpDateValDmp(Date agpDateValDmp) {
		this.agpDateValDmp = agpDateValDmp;
	}

	@Column(name = "FIN_ID", nullable = false, precision = 10, scale = 0)
	public long getFinId() {
		return this.finId;
	}

	public void setFinId(long finId) {
		this.finId = finId;
	}

	@Column(name = "FIN_DEV_CODE", nullable = false, length = 8)
	public String getFinDevCode() {
		return this.finDevCode;
	}

	public void setFinDevCode(String finDevCode) {
		this.finDevCode = finDevCode;
	}

	@Column(name = "FIN_BAI_CODE", length = 5)
	public String getFinBaiCode() {
		return this.finBaiCode;
	}

	public void setFinBaiCode(String finBaiCode) {
		this.finBaiCode = finBaiCode;
	}

	@Column(name = "FIN_SOU_CODE", nullable = false, length = 5)
	public String getFinSouCode() {
		return this.finSouCode;
	}

	public void setFinSouCode(String finSouCode) {
		this.finSouCode = finSouCode;
	}

	@Column(name = "FIN_PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getFinProId() {
		return this.finProId;
	}

	public void setFinProId(long finProId) {
		this.finProId = finProId;
	}

	@Column(name = "FIN_MONTANT_CFA", precision = 15)
	public BigDecimal getFinMontantCfa() {
		return this.finMontantCfa;
	}

	public void setFinMontantCfa(BigDecimal finMontantCfa) {
		this.finMontantCfa = finMontantCfa;
	}

	@Column(name = "FIN_MONTANT_DEVISE", precision = 15)
	public BigDecimal getFinMontantDevise() {
		return this.finMontantDevise;
	}

	public void setFinMontantDevise(BigDecimal finMontantDevise) {
		this.finMontantDevise = finMontantDevise;
	}

	@Column(name = "FIN_NUMERO_ACCORD", length = 500)
	public String getFinNumeroAccord() {
		return this.finNumeroAccord;
	}

	public void setFinNumeroAccord(String finNumeroAccord) {
		this.finNumeroAccord = finNumeroAccord;
	}

	@Column(name = "FIN_STATUT", length = 10)
	public String getFinStatut() {
		return this.finStatut;
	}

	public void setFinStatut(String finStatut) {
		this.finStatut = finStatut;
	}

	@Column(name = "FIN_AGP_ID", precision = 10, scale = 0)
	public Long getFinAgpId() {
		return this.finAgpId;
	}

	public void setFinAgpId(Long finAgpId) {
		this.finAgpId = finAgpId;
	}

	@Column(name = "FIN_TYPE_FINANCE", length = 20)
	public String getFinTypeFinance() {
		return this.finTypeFinance;
	}

	public void setFinTypeFinance(String finTypeFinance) {
		this.finTypeFinance = finTypeFinance;
	}

	@Column(name = "FIN_PART_TRESOR", precision = 15, scale = 0)
	public Long getFinPartTresor() {
		return this.finPartTresor;
	}

	public void setFinPartTresor(Long finPartTresor) {
		this.finPartTresor = finPartTresor;
	}

	@Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	@Column(name = "PRO_REG_ID", precision = 10, scale = 0)
	public Long getProRegId() {
		return this.proRegId;
	}

	public void setProRegId(Long proRegId) {
		this.proRegId = proRegId;
	}

	@Column(name = "PRO_CODE", length = 50)
	public String getProCode() {
		return this.proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	@Column(name = "PRO_TITRE", nullable = false, length = 500)
	public String getProTitre() {
		return this.proTitre;
	}

	public void setProTitre(String proTitre) {
		this.proTitre = proTitre;
	}

	@Column(name = "PRO_LIBELLE", length = 500)
	public String getProLibelle() {
		return this.proLibelle;
	}

	public void setProLibelle(String proLibelle) {
		this.proLibelle = proLibelle;
	}

	@Column(name = "PRO_DESCRIPTION", length = 1000)
	public String getProDescription() {
		return this.proDescription;
	}

	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}

	@Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)
	public BigDecimal getProMontantTotCfa() {
		return this.proMontantTotCfa;
	}

	public void setProMontantTotCfa(BigDecimal proMontantTotCfa) {
		this.proMontantTotCfa = proMontantTotCfa;
	}

	@Column(name = "PRO_TYPE_PROJET", length = 10)
	public String getProTypeProjet() {
		return this.proTypeProjet;
	}

	public void setProTypeProjet(String proTypeProjet) {
		this.proTypeProjet = proTypeProjet;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VAgpmFonctionId))
			return false;
		VAgpmFonctionId castOther = (VAgpmFonctionId) other;

		return (this.getAgpId() == castOther.getAgpId())
				&& ((this.getAgpStrCode() == castOther.getAgpStrCode()) || (this.getAgpStrCode() != null
						&& castOther.getAgpStrCode() != null && this.getAgpStrCode().equals(castOther.getAgpStrCode())))
				&& ((this.getAgpFonCod() == castOther.getAgpFonCod()) || (this.getAgpFonCod() != null
						&& castOther.getAgpFonCod() != null && this.getAgpFonCod().equals(castOther.getAgpFonCod())))
				&& (this.getAgpGesCode() == castOther.getAgpGesCode())
				&& ((this.getAgpStaCode() == castOther.getAgpStaCode()) || (this.getAgpStaCode() != null
						&& castOther.getAgpStaCode() != null && this.getAgpStaCode().equals(castOther.getAgpStaCode())))
				&& (this.getAgpProId() == castOther.getAgpProId())
				&& ((this.getAgpDecId() == castOther.getAgpDecId()) || (this.getAgpDecId() != null
						&& castOther.getAgpDecId() != null && this.getAgpDecId().equals(castOther.getAgpDecId())))
				&& ((this.getAgpCommentaire() == castOther.getAgpCommentaire())
						|| (this.getAgpCommentaire() != null && castOther.getAgpCommentaire() != null
								&& this.getAgpCommentaire().equals(castOther.getAgpCommentaire())))
				&& ((this.getAgpTypeDao() == castOther.getAgpTypeDao()) || (this.getAgpTypeDao() != null
						&& castOther.getAgpTypeDao() != null && this.getAgpTypeDao().equals(castOther.getAgpTypeDao())))
				&& ((this.getAgpModePassation() == castOther.getAgpModePassation())
						|| (this.getAgpModePassation() != null && castOther.getAgpModePassation() != null
								&& this.getAgpModePassation().equals(castOther.getAgpModePassation())))
				&& ((this.getAgpActif() == castOther.getAgpActif()) || (this.getAgpActif() != null
						&& castOther.getAgpActif() != null && this.getAgpActif().equals(castOther.getAgpActif())))
				&& ((this.getAgpStatutRetour() == castOther.getAgpStatutRetour())
						|| (this.getAgpStatutRetour() != null && castOther.getAgpStatutRetour() != null
								&& this.getAgpStatutRetour().equals(castOther.getAgpStatutRetour())))
				&& ((this.getAgpActeurSaisie() == castOther.getAgpActeurSaisie())
						|| (this.getAgpActeurSaisie() != null && castOther.getAgpActeurSaisie() != null
								&& this.getAgpActeurSaisie().equals(castOther.getAgpActeurSaisie())))
				&& ((this.getAgpDateValAc() == castOther.getAgpDateValAc())
						|| (this.getAgpDateValAc() != null && castOther.getAgpDateValAc() != null
								&& this.getAgpDateValAc().equals(castOther.getAgpDateValAc())))
				&& ((this.getAgpDateValCpmp() == castOther.getAgpDateValCpmp())
						|| (this.getAgpDateValCpmp() != null && castOther.getAgpDateValCpmp() != null
								&& this.getAgpDateValCpmp().equals(castOther.getAgpDateValCpmp())))
				&& ((this.getAgpDateValDmp() == castOther.getAgpDateValDmp())
						|| (this.getAgpDateValDmp() != null && castOther.getAgpDateValDmp() != null
								&& this.getAgpDateValDmp().equals(castOther.getAgpDateValDmp())))
				&& (this.getFinId() == castOther.getFinId())
				&& ((this.getFinDevCode() == castOther.getFinDevCode()) || (this.getFinDevCode() != null
						&& castOther.getFinDevCode() != null && this.getFinDevCode().equals(castOther.getFinDevCode())))
				&& ((this.getFinBaiCode() == castOther.getFinBaiCode()) || (this.getFinBaiCode() != null
						&& castOther.getFinBaiCode() != null && this.getFinBaiCode().equals(castOther.getFinBaiCode())))
				&& ((this.getFinSouCode() == castOther.getFinSouCode()) || (this.getFinSouCode() != null
						&& castOther.getFinSouCode() != null && this.getFinSouCode().equals(castOther.getFinSouCode())))
				&& (this.getFinProId() == castOther.getFinProId())
				&& ((this.getFinMontantCfa() == castOther.getFinMontantCfa())
						|| (this.getFinMontantCfa() != null && castOther.getFinMontantCfa() != null
								&& this.getFinMontantCfa().equals(castOther.getFinMontantCfa())))
				&& ((this.getFinMontantDevise() == castOther.getFinMontantDevise())
						|| (this.getFinMontantDevise() != null && castOther.getFinMontantDevise() != null
								&& this.getFinMontantDevise().equals(castOther.getFinMontantDevise())))
				&& ((this.getFinNumeroAccord() == castOther.getFinNumeroAccord())
						|| (this.getFinNumeroAccord() != null && castOther.getFinNumeroAccord() != null
								&& this.getFinNumeroAccord().equals(castOther.getFinNumeroAccord())))
				&& ((this.getFinStatut() == castOther.getFinStatut()) || (this.getFinStatut() != null
						&& castOther.getFinStatut() != null && this.getFinStatut().equals(castOther.getFinStatut())))
				&& ((this.getFinAgpId() == castOther.getFinAgpId()) || (this.getFinAgpId() != null
						&& castOther.getFinAgpId() != null && this.getFinAgpId().equals(castOther.getFinAgpId())))
				&& ((this.getFinTypeFinance() == castOther.getFinTypeFinance())
						|| (this.getFinTypeFinance() != null && castOther.getFinTypeFinance() != null
								&& this.getFinTypeFinance().equals(castOther.getFinTypeFinance())))
				&& ((this.getFinPartTresor() == castOther.getFinPartTresor())
						|| (this.getFinPartTresor() != null && castOther.getFinPartTresor() != null
								&& this.getFinPartTresor().equals(castOther.getFinPartTresor())))
				&& (this.getProId() == castOther.getProId())
				&& ((this.getProRegId() == castOther.getProRegId()) || (this.getProRegId() != null
						&& castOther.getProRegId() != null && this.getProRegId().equals(castOther.getProRegId())))
				&& ((this.getProCode() == castOther.getProCode()) || (this.getProCode() != null
						&& castOther.getProCode() != null && this.getProCode().equals(castOther.getProCode())))
				&& ((this.getProTitre() == castOther.getProTitre()) || (this.getProTitre() != null
						&& castOther.getProTitre() != null && this.getProTitre().equals(castOther.getProTitre())))
				&& ((this.getProLibelle() == castOther.getProLibelle()) || (this.getProLibelle() != null
						&& castOther.getProLibelle() != null && this.getProLibelle().equals(castOther.getProLibelle())))
				&& ((this.getProDescription() == castOther.getProDescription())
						|| (this.getProDescription() != null && castOther.getProDescription() != null
								&& this.getProDescription().equals(castOther.getProDescription())))
				&& ((this.getProMontantTotCfa() == castOther.getProMontantTotCfa())
						|| (this.getProMontantTotCfa() != null && castOther.getProMontantTotCfa() != null
								&& this.getProMontantTotCfa().equals(castOther.getProMontantTotCfa())))
				&& ((this.getProTypeProjet() == castOther.getProTypeProjet())
						|| (this.getProTypeProjet() != null && castOther.getProTypeProjet() != null
								&& this.getProTypeProjet().equals(castOther.getProTypeProjet())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAgpId();
		result = 37 * result + (getAgpStrCode() == null ? 0 : this.getAgpStrCode().hashCode());
		result = 37 * result + (getAgpFonCod() == null ? 0 : this.getAgpFonCod().hashCode());
		result = 37 * result + this.getAgpGesCode();
		result = 37 * result + (getAgpStaCode() == null ? 0 : this.getAgpStaCode().hashCode());
		result = 37 * result + (int) this.getAgpProId();
		result = 37 * result + (getAgpDecId() == null ? 0 : this.getAgpDecId().hashCode());
		result = 37 * result + (getAgpCommentaire() == null ? 0 : this.getAgpCommentaire().hashCode());
		result = 37 * result + (getAgpTypeDao() == null ? 0 : this.getAgpTypeDao().hashCode());
		result = 37 * result + (getAgpModePassation() == null ? 0 : this.getAgpModePassation().hashCode());
		result = 37 * result + (getAgpActif() == null ? 0 : this.getAgpActif().hashCode());
		result = 37 * result + (getAgpStatutRetour() == null ? 0 : this.getAgpStatutRetour().hashCode());
		result = 37 * result + (getAgpActeurSaisie() == null ? 0 : this.getAgpActeurSaisie().hashCode());
		result = 37 * result + (getAgpDateValAc() == null ? 0 : this.getAgpDateValAc().hashCode());
		result = 37 * result + (getAgpDateValCpmp() == null ? 0 : this.getAgpDateValCpmp().hashCode());
		result = 37 * result + (getAgpDateValDmp() == null ? 0 : this.getAgpDateValDmp().hashCode());
		result = 37 * result + (int) this.getFinId();
		result = 37 * result + (getFinDevCode() == null ? 0 : this.getFinDevCode().hashCode());
		result = 37 * result + (getFinBaiCode() == null ? 0 : this.getFinBaiCode().hashCode());
		result = 37 * result + (getFinSouCode() == null ? 0 : this.getFinSouCode().hashCode());
		result = 37 * result + (int) this.getFinProId();
		result = 37 * result + (getFinMontantCfa() == null ? 0 : this.getFinMontantCfa().hashCode());
		result = 37 * result + (getFinMontantDevise() == null ? 0 : this.getFinMontantDevise().hashCode());
		result = 37 * result + (getFinNumeroAccord() == null ? 0 : this.getFinNumeroAccord().hashCode());
		result = 37 * result + (getFinStatut() == null ? 0 : this.getFinStatut().hashCode());
		result = 37 * result + (getFinAgpId() == null ? 0 : this.getFinAgpId().hashCode());
		result = 37 * result + (getFinTypeFinance() == null ? 0 : this.getFinTypeFinance().hashCode());
		result = 37 * result + (getFinPartTresor() == null ? 0 : this.getFinPartTresor().hashCode());
		result = 37 * result + (int) this.getProId();
		result = 37 * result + (getProRegId() == null ? 0 : this.getProRegId().hashCode());
		result = 37 * result + (getProCode() == null ? 0 : this.getProCode().hashCode());
		result = 37 * result + (getProTitre() == null ? 0 : this.getProTitre().hashCode());
		result = 37 * result + (getProLibelle() == null ? 0 : this.getProLibelle().hashCode());
		result = 37 * result + (getProDescription() == null ? 0 : this.getProDescription().hashCode());
		result = 37 * result + (getProMontantTotCfa() == null ? 0 : this.getProMontantTotCfa().hashCode());
		result = 37 * result + (getProTypeProjet() == null ? 0 : this.getProTypeProjet().hashCode());
		return result;
	}

}
