package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VAgpmDetailsId generated by hbm2java
 */
@Embeddable
public class VAgpmDetailsId implements java.io.Serializable {

	private long affProId;
	private long proId;
	private String proLibelle;
	private String proDescription;
	private String proTitre;
	private BigDecimal proMontantTotCfa;
	private String minLibelle;
	private String minDescription;
	private Date gesDateDebut;
	private Date gesDateFin;
	private String decPersNomPrenom;
	private String decPersFonction;
	private String decTelephone;
	private String decOrganExecLibelle;
	private String decOrganExecAdresse;
	private String decNumeroPorte;
	private String decLocalisation;
	private String decEmail;
	private String decBp;
	private String decCel;
	private long affAgpId;
	private short affGesCode;
	private String affAgpCommentaire;
	private String affAgpActif;
	private String affAgpTypeDao;
	private String affAgpStaCode;
	private String regLibelleLong;
	private String regLibelleCourt;
	private String fonLibelle;
	private String strLibelleLong;
	private String strLibelleCourt;

	public VAgpmDetailsId() {
	}

	public VAgpmDetailsId(long affProId, long proId, String proTitre, long affAgpId, short affGesCode,
			String affAgpStaCode) {
		this.affProId = affProId;
		this.proId = proId;
		this.proTitre = proTitre;
		this.affAgpId = affAgpId;
		this.affGesCode = affGesCode;
		this.affAgpStaCode = affAgpStaCode;
	}

	public VAgpmDetailsId(long affProId, long proId, String proLibelle, String proDescription, String proTitre,
			BigDecimal proMontantTotCfa, String minLibelle, String minDescription, Date gesDateDebut, Date gesDateFin,
			String decPersNomPrenom, String decPersFonction, String decTelephone, String decOrganExecLibelle,
			String decOrganExecAdresse, String decNumeroPorte, String decLocalisation, String decEmail, String decBp,
			String decCel, long affAgpId, short affGesCode, String affAgpCommentaire, String affAgpActif,
			String affAgpTypeDao, String affAgpStaCode, String regLibelleLong, String regLibelleCourt,
			String fonLibelle, String strLibelleLong, String strLibelleCourt) {
		this.affProId = affProId;
		this.proId = proId;
		this.proLibelle = proLibelle;
		this.proDescription = proDescription;
		this.proTitre = proTitre;
		this.proMontantTotCfa = proMontantTotCfa;
		this.minLibelle = minLibelle;
		this.minDescription = minDescription;
		this.gesDateDebut = gesDateDebut;
		this.gesDateFin = gesDateFin;
		this.decPersNomPrenom = decPersNomPrenom;
		this.decPersFonction = decPersFonction;
		this.decTelephone = decTelephone;
		this.decOrganExecLibelle = decOrganExecLibelle;
		this.decOrganExecAdresse = decOrganExecAdresse;
		this.decNumeroPorte = decNumeroPorte;
		this.decLocalisation = decLocalisation;
		this.decEmail = decEmail;
		this.decBp = decBp;
		this.decCel = decCel;
		this.affAgpId = affAgpId;
		this.affGesCode = affGesCode;
		this.affAgpCommentaire = affAgpCommentaire;
		this.affAgpActif = affAgpActif;
		this.affAgpTypeDao = affAgpTypeDao;
		this.affAgpStaCode = affAgpStaCode;
		this.regLibelleLong = regLibelleLong;
		this.regLibelleCourt = regLibelleCourt;
		this.fonLibelle = fonLibelle;
		this.strLibelleLong = strLibelleLong;
		this.strLibelleCourt = strLibelleCourt;
	}

	@Column(name = "AFF_PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getAffProId() {
		return this.affProId;
	}

	public void setAffProId(long affProId) {
		this.affProId = affProId;
	}

	@Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
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

	@Column(name = "PRO_TITRE", nullable = false, length = 500)
	public String getProTitre() {
		return this.proTitre;
	}

	public void setProTitre(String proTitre) {
		this.proTitre = proTitre;
	}

	@Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)
	public BigDecimal getProMontantTotCfa() {
		return this.proMontantTotCfa;
	}

	public void setProMontantTotCfa(BigDecimal proMontantTotCfa) {
		this.proMontantTotCfa = proMontantTotCfa;
	}

	@Column(name = "MIN_LIBELLE", length = 1000)
	public String getMinLibelle() {
		return this.minLibelle;
	}

	public void setMinLibelle(String minLibelle) {
		this.minLibelle = minLibelle;
	}

	@Column(name = "MIN_DESCRIPTION", length = 1000)
	public String getMinDescription() {
		return this.minDescription;
	}

	public void setMinDescription(String minDescription) {
		this.minDescription = minDescription;
	}

	@Column(name = "GES_DATE_DEBUT", length = 7)
	public Date getGesDateDebut() {
		return this.gesDateDebut;
	}

	public void setGesDateDebut(Date gesDateDebut) {
		this.gesDateDebut = gesDateDebut;
	}

	@Column(name = "GES_DATE_FIN", length = 7)
	public Date getGesDateFin() {
		return this.gesDateFin;
	}

	public void setGesDateFin(Date gesDateFin) {
		this.gesDateFin = gesDateFin;
	}

	@Column(name = "DEC_PERS_NOM_PRENOM", length = 500)
	public String getDecPersNomPrenom() {
		return this.decPersNomPrenom;
	}

	public void setDecPersNomPrenom(String decPersNomPrenom) {
		this.decPersNomPrenom = decPersNomPrenom;
	}

	@Column(name = "DEC_PERS_FONCTION", length = 500)
	public String getDecPersFonction() {
		return this.decPersFonction;
	}

	public void setDecPersFonction(String decPersFonction) {
		this.decPersFonction = decPersFonction;
	}

	@Column(name = "DEC_TELEPHONE", length = 500)
	public String getDecTelephone() {
		return this.decTelephone;
	}

	public void setDecTelephone(String decTelephone) {
		this.decTelephone = decTelephone;
	}

	@Column(name = "DEC_ORGAN_EXEC_LIBELLE", length = 500)
	public String getDecOrganExecLibelle() {
		return this.decOrganExecLibelle;
	}

	public void setDecOrganExecLibelle(String decOrganExecLibelle) {
		this.decOrganExecLibelle = decOrganExecLibelle;
	}

	@Column(name = "DEC_ORGAN_EXEC_ADRESSE", length = 500)
	public String getDecOrganExecAdresse() {
		return this.decOrganExecAdresse;
	}

	public void setDecOrganExecAdresse(String decOrganExecAdresse) {
		this.decOrganExecAdresse = decOrganExecAdresse;
	}

	@Column(name = "DEC_NUMERO_PORTE", length = 500)
	public String getDecNumeroPorte() {
		return this.decNumeroPorte;
	}

	public void setDecNumeroPorte(String decNumeroPorte) {
		this.decNumeroPorte = decNumeroPorte;
	}

	@Column(name = "DEC_LOCALISATION", length = 500)
	public String getDecLocalisation() {
		return this.decLocalisation;
	}

	public void setDecLocalisation(String decLocalisation) {
		this.decLocalisation = decLocalisation;
	}

	@Column(name = "DEC_EMAIL", length = 500)
	public String getDecEmail() {
		return this.decEmail;
	}

	public void setDecEmail(String decEmail) {
		this.decEmail = decEmail;
	}

	@Column(name = "DEC_BP", length = 500)
	public String getDecBp() {
		return this.decBp;
	}

	public void setDecBp(String decBp) {
		this.decBp = decBp;
	}

	@Column(name = "DEC_CEL", length = 500)
	public String getDecCel() {
		return this.decCel;
	}

	public void setDecCel(String decCel) {
		this.decCel = decCel;
	}

	@Column(name = "AFF_AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAffAgpId() {
		return this.affAgpId;
	}

	public void setAffAgpId(long affAgpId) {
		this.affAgpId = affAgpId;
	}

	@Column(name = "AFF_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getAffGesCode() {
		return this.affGesCode;
	}

	public void setAffGesCode(short affGesCode) {
		this.affGesCode = affGesCode;
	}

	@Column(name = "AFF_AGP_COMMENTAIRE", length = 1000)
	public String getAffAgpCommentaire() {
		return this.affAgpCommentaire;
	}

	public void setAffAgpCommentaire(String affAgpCommentaire) {
		this.affAgpCommentaire = affAgpCommentaire;
	}

	@Column(name = "AFF_AGP_ACTIF", length = 1)
	public String getAffAgpActif() {
		return this.affAgpActif;
	}

	public void setAffAgpActif(String affAgpActif) {
		this.affAgpActif = affAgpActif;
	}

	@Column(name = "AFF_AGP_TYPE_DAO", length = 1000)
	public String getAffAgpTypeDao() {
		return this.affAgpTypeDao;
	}

	public void setAffAgpTypeDao(String affAgpTypeDao) {
		this.affAgpTypeDao = affAgpTypeDao;
	}

	@Column(name = "AFF_AGP_STA_CODE", nullable = false, length = 3)
	public String getAffAgpStaCode() {
		return this.affAgpStaCode;
	}

	public void setAffAgpStaCode(String affAgpStaCode) {
		this.affAgpStaCode = affAgpStaCode;
	}

	@Column(name = "REG_LIBELLE_LONG", length = 1000)
	public String getRegLibelleLong() {
		return this.regLibelleLong;
	}

	public void setRegLibelleLong(String regLibelleLong) {
		this.regLibelleLong = regLibelleLong;
	}

	@Column(name = "REG_LIBELLE_COURT", length = 500)
	public String getRegLibelleCourt() {
		return this.regLibelleCourt;
	}

	public void setRegLibelleCourt(String regLibelleCourt) {
		this.regLibelleCourt = regLibelleCourt;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "STR_LIBELLE_LONG", length = 1000)
	public String getStrLibelleLong() {
		return this.strLibelleLong;
	}

	public void setStrLibelleLong(String strLibelleLong) {
		this.strLibelleLong = strLibelleLong;
	}

	@Column(name = "STR_LIBELLE_COURT", length = 500)
	public String getStrLibelleCourt() {
		return this.strLibelleCourt;
	}

	public void setStrLibelleCourt(String strLibelleCourt) {
		this.strLibelleCourt = strLibelleCourt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VAgpmDetailsId))
			return false;
		VAgpmDetailsId castOther = (VAgpmDetailsId) other;

		return (this.getAffProId() == castOther.getAffProId()) && (this.getProId() == castOther.getProId())
				&& ((this.getProLibelle() == castOther.getProLibelle()) || (this.getProLibelle() != null
						&& castOther.getProLibelle() != null && this.getProLibelle().equals(castOther.getProLibelle())))
				&& ((this.getProDescription() == castOther.getProDescription())
						|| (this.getProDescription() != null && castOther.getProDescription() != null
								&& this.getProDescription().equals(castOther.getProDescription())))
				&& ((this.getProTitre() == castOther.getProTitre()) || (this.getProTitre() != null
						&& castOther.getProTitre() != null && this.getProTitre().equals(castOther.getProTitre())))
				&& ((this.getProMontantTotCfa() == castOther.getProMontantTotCfa())
						|| (this.getProMontantTotCfa() != null && castOther.getProMontantTotCfa() != null
								&& this.getProMontantTotCfa().equals(castOther.getProMontantTotCfa())))
				&& ((this.getMinLibelle() == castOther.getMinLibelle()) || (this.getMinLibelle() != null
						&& castOther.getMinLibelle() != null && this.getMinLibelle().equals(castOther.getMinLibelle())))
				&& ((this.getMinDescription() == castOther.getMinDescription())
						|| (this.getMinDescription() != null && castOther.getMinDescription() != null
								&& this.getMinDescription().equals(castOther.getMinDescription())))
				&& ((this.getGesDateDebut() == castOther.getGesDateDebut())
						|| (this.getGesDateDebut() != null && castOther.getGesDateDebut() != null
								&& this.getGesDateDebut().equals(castOther.getGesDateDebut())))
				&& ((this.getGesDateFin() == castOther.getGesDateFin()) || (this.getGesDateFin() != null
						&& castOther.getGesDateFin() != null && this.getGesDateFin().equals(castOther.getGesDateFin())))
				&& ((this.getDecPersNomPrenom() == castOther.getDecPersNomPrenom())
						|| (this.getDecPersNomPrenom() != null && castOther.getDecPersNomPrenom() != null
								&& this.getDecPersNomPrenom().equals(castOther.getDecPersNomPrenom())))
				&& ((this.getDecPersFonction() == castOther.getDecPersFonction())
						|| (this.getDecPersFonction() != null && castOther.getDecPersFonction() != null
								&& this.getDecPersFonction().equals(castOther.getDecPersFonction())))
				&& ((this.getDecTelephone() == castOther.getDecTelephone())
						|| (this.getDecTelephone() != null && castOther.getDecTelephone() != null
								&& this.getDecTelephone().equals(castOther.getDecTelephone())))
				&& ((this.getDecOrganExecLibelle() == castOther.getDecOrganExecLibelle())
						|| (this.getDecOrganExecLibelle() != null && castOther.getDecOrganExecLibelle() != null
								&& this.getDecOrganExecLibelle().equals(castOther.getDecOrganExecLibelle())))
				&& ((this.getDecOrganExecAdresse() == castOther.getDecOrganExecAdresse())
						|| (this.getDecOrganExecAdresse() != null && castOther.getDecOrganExecAdresse() != null
								&& this.getDecOrganExecAdresse().equals(castOther.getDecOrganExecAdresse())))
				&& ((this.getDecNumeroPorte() == castOther.getDecNumeroPorte())
						|| (this.getDecNumeroPorte() != null && castOther.getDecNumeroPorte() != null
								&& this.getDecNumeroPorte().equals(castOther.getDecNumeroPorte())))
				&& ((this.getDecLocalisation() == castOther.getDecLocalisation())
						|| (this.getDecLocalisation() != null && castOther.getDecLocalisation() != null
								&& this.getDecLocalisation().equals(castOther.getDecLocalisation())))
				&& ((this.getDecEmail() == castOther.getDecEmail()) || (this.getDecEmail() != null
						&& castOther.getDecEmail() != null && this.getDecEmail().equals(castOther.getDecEmail())))
				&& ((this.getDecBp() == castOther.getDecBp()) || (this.getDecBp() != null
						&& castOther.getDecBp() != null && this.getDecBp().equals(castOther.getDecBp())))
				&& ((this.getDecCel() == castOther.getDecCel()) || (this.getDecCel() != null
						&& castOther.getDecCel() != null && this.getDecCel().equals(castOther.getDecCel())))
				&& (this.getAffAgpId() == castOther.getAffAgpId())
				&& (this.getAffGesCode() == castOther.getAffGesCode())
				&& ((this.getAffAgpCommentaire() == castOther.getAffAgpCommentaire())
						|| (this.getAffAgpCommentaire() != null && castOther.getAffAgpCommentaire() != null
								&& this.getAffAgpCommentaire().equals(castOther.getAffAgpCommentaire())))
				&& ((this.getAffAgpActif() == castOther.getAffAgpActif())
						|| (this.getAffAgpActif() != null && castOther.getAffAgpActif() != null
								&& this.getAffAgpActif().equals(castOther.getAffAgpActif())))
				&& ((this.getAffAgpTypeDao() == castOther.getAffAgpTypeDao())
						|| (this.getAffAgpTypeDao() != null && castOther.getAffAgpTypeDao() != null
								&& this.getAffAgpTypeDao().equals(castOther.getAffAgpTypeDao())))
				&& ((this.getAffAgpStaCode() == castOther.getAffAgpStaCode())
						|| (this.getAffAgpStaCode() != null && castOther.getAffAgpStaCode() != null
								&& this.getAffAgpStaCode().equals(castOther.getAffAgpStaCode())))
				&& ((this.getRegLibelleLong() == castOther.getRegLibelleLong())
						|| (this.getRegLibelleLong() != null && castOther.getRegLibelleLong() != null
								&& this.getRegLibelleLong().equals(castOther.getRegLibelleLong())))
				&& ((this.getRegLibelleCourt() == castOther.getRegLibelleCourt())
						|| (this.getRegLibelleCourt() != null && castOther.getRegLibelleCourt() != null
								&& this.getRegLibelleCourt().equals(castOther.getRegLibelleCourt())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getStrLibelleLong() == castOther.getStrLibelleLong())
						|| (this.getStrLibelleLong() != null && castOther.getStrLibelleLong() != null
								&& this.getStrLibelleLong().equals(castOther.getStrLibelleLong())))
				&& ((this.getStrLibelleCourt() == castOther.getStrLibelleCourt())
						|| (this.getStrLibelleCourt() != null && castOther.getStrLibelleCourt() != null
								&& this.getStrLibelleCourt().equals(castOther.getStrLibelleCourt())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAffProId();
		result = 37 * result + (int) this.getProId();
		result = 37 * result + (getProLibelle() == null ? 0 : this.getProLibelle().hashCode());
		result = 37 * result + (getProDescription() == null ? 0 : this.getProDescription().hashCode());
		result = 37 * result + (getProTitre() == null ? 0 : this.getProTitre().hashCode());
		result = 37 * result + (getProMontantTotCfa() == null ? 0 : this.getProMontantTotCfa().hashCode());
		result = 37 * result + (getMinLibelle() == null ? 0 : this.getMinLibelle().hashCode());
		result = 37 * result + (getMinDescription() == null ? 0 : this.getMinDescription().hashCode());
		result = 37 * result + (getGesDateDebut() == null ? 0 : this.getGesDateDebut().hashCode());
		result = 37 * result + (getGesDateFin() == null ? 0 : this.getGesDateFin().hashCode());
		result = 37 * result + (getDecPersNomPrenom() == null ? 0 : this.getDecPersNomPrenom().hashCode());
		result = 37 * result + (getDecPersFonction() == null ? 0 : this.getDecPersFonction().hashCode());
		result = 37 * result + (getDecTelephone() == null ? 0 : this.getDecTelephone().hashCode());
		result = 37 * result + (getDecOrganExecLibelle() == null ? 0 : this.getDecOrganExecLibelle().hashCode());
		result = 37 * result + (getDecOrganExecAdresse() == null ? 0 : this.getDecOrganExecAdresse().hashCode());
		result = 37 * result + (getDecNumeroPorte() == null ? 0 : this.getDecNumeroPorte().hashCode());
		result = 37 * result + (getDecLocalisation() == null ? 0 : this.getDecLocalisation().hashCode());
		result = 37 * result + (getDecEmail() == null ? 0 : this.getDecEmail().hashCode());
		result = 37 * result + (getDecBp() == null ? 0 : this.getDecBp().hashCode());
		result = 37 * result + (getDecCel() == null ? 0 : this.getDecCel().hashCode());
		result = 37 * result + (int) this.getAffAgpId();
		result = 37 * result + this.getAffGesCode();
		result = 37 * result + (getAffAgpCommentaire() == null ? 0 : this.getAffAgpCommentaire().hashCode());
		result = 37 * result + (getAffAgpActif() == null ? 0 : this.getAffAgpActif().hashCode());
		result = 37 * result + (getAffAgpTypeDao() == null ? 0 : this.getAffAgpTypeDao().hashCode());
		result = 37 * result + (getAffAgpStaCode() == null ? 0 : this.getAffAgpStaCode().hashCode());
		result = 37 * result + (getRegLibelleLong() == null ? 0 : this.getRegLibelleLong().hashCode());
		result = 37 * result + (getRegLibelleCourt() == null ? 0 : this.getRegLibelleCourt().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getStrLibelleLong() == null ? 0 : this.getStrLibelleLong().hashCode());
		result = 37 * result + (getStrLibelleCourt() == null ? 0 : this.getStrLibelleCourt().hashCode());
		return result;
	}

}
