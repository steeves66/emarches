package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPpmEtatId generated by hbm2java
 */
@Embeddable
public class VPpmEtatId implements java.io.Serializable {

	private BigDecimal VId;
	private long affId;
	private Long affDppId;
	private String fonLibelle;
	private String affDppObjet;
	private String affDppSourceFin;
	private String lbgCode;
	private String lbgImputation;
	private String natCode;
	private String natLibelle;
	private String tymLibelleCourt;
	private String mopLibelleLong;
	private Date affDppDateAvisAoPublicat;
	private Date affDppDateOuvertOt;
	private Date affDppDateOuvertOf;
	private Date affDppDateJugementOffre;
	private Date affDppDateAttApprobDmp;
	private Date affDppDateAttApproBail;
	private long affDppPlpId;
	private String affDppStrBenefi;
	private String affDppStrConduc;
	private String affDppTypePlan;
	private Date affDppDateNegociation;
	private Date affDppDateElabRapport;
	private Date affDppDateSignatAttrib;
	private Date affDppDateSignatAc;
	private Date affDppDateExecDebut;
	private Date affDppDateExecFin;
	private Date affDppDateDaoTrans;
	private Date affDppDateDaoApprobDmp;
	private Date affDppDateDaoApprobBail;
	private Date affDppApprobAno;
	private Date affDppInvEntre;

	public VPpmEtatId() {
	}

	public VPpmEtatId(long affId, String lbgCode, String lbgImputation, String natCode, String tymLibelleCourt,
			long affDppPlpId, String affDppTypePlan) {
		this.affId = affId;
		this.lbgCode = lbgCode;
		this.lbgImputation = lbgImputation;
		this.natCode = natCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.affDppPlpId = affDppPlpId;
		this.affDppTypePlan = affDppTypePlan;
	}

	public VPpmEtatId(BigDecimal VId, long affId, Long affDppId, String fonLibelle, String affDppObjet,
			String affDppSourceFin, String lbgCode, String lbgImputation, String natCode, String natLibelle,
			String tymLibelleCourt, String mopLibelleLong, Date affDppDateAvisAoPublicat, Date affDppDateOuvertOt,
			Date affDppDateOuvertOf, Date affDppDateJugementOffre, Date affDppDateAttApprobDmp,
			Date affDppDateAttApproBail, long affDppPlpId, String affDppStrBenefi, String affDppStrConduc,
			String affDppTypePlan, Date affDppDateNegociation, Date affDppDateElabRapport, Date affDppDateSignatAttrib,
			Date affDppDateSignatAc, Date affDppDateExecDebut, Date affDppDateExecFin, Date affDppDateDaoTrans,
			Date affDppDateDaoApprobDmp, Date affDppDateDaoApprobBail, Date affDppApprobAno, Date affDppInvEntre) {
		this.VId = VId;
		this.affId = affId;
		this.affDppId = affDppId;
		this.fonLibelle = fonLibelle;
		this.affDppObjet = affDppObjet;
		this.affDppSourceFin = affDppSourceFin;
		this.lbgCode = lbgCode;
		this.lbgImputation = lbgImputation;
		this.natCode = natCode;
		this.natLibelle = natLibelle;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.affDppDateAvisAoPublicat = affDppDateAvisAoPublicat;
		this.affDppDateOuvertOt = affDppDateOuvertOt;
		this.affDppDateOuvertOf = affDppDateOuvertOf;
		this.affDppDateJugementOffre = affDppDateJugementOffre;
		this.affDppDateAttApprobDmp = affDppDateAttApprobDmp;
		this.affDppDateAttApproBail = affDppDateAttApproBail;
		this.affDppPlpId = affDppPlpId;
		this.affDppStrBenefi = affDppStrBenefi;
		this.affDppStrConduc = affDppStrConduc;
		this.affDppTypePlan = affDppTypePlan;
		this.affDppDateNegociation = affDppDateNegociation;
		this.affDppDateElabRapport = affDppDateElabRapport;
		this.affDppDateSignatAttrib = affDppDateSignatAttrib;
		this.affDppDateSignatAc = affDppDateSignatAc;
		this.affDppDateExecDebut = affDppDateExecDebut;
		this.affDppDateExecFin = affDppDateExecFin;
		this.affDppDateDaoTrans = affDppDateDaoTrans;
		this.affDppDateDaoApprobDmp = affDppDateDaoApprobDmp;
		this.affDppDateDaoApprobBail = affDppDateDaoApprobBail;
		this.affDppApprobAno = affDppApprobAno;
		this.affDppInvEntre = affDppInvEntre;
	}

	@Column(name = "V_ID", precision = 22, scale = 0)
	public BigDecimal getVId() {
		return this.VId;
	}

	public void setVId(BigDecimal VId) {
		this.VId = VId;
	}

	@Column(name = "AFF_ID", nullable = false, precision = 10, scale = 0)
	public long getAffId() {
		return this.affId;
	}

	public void setAffId(long affId) {
		this.affId = affId;
	}

	@Column(name = "AFF_DPP_ID", precision = 10, scale = 0)
	public Long getAffDppId() {
		return this.affDppId;
	}

	public void setAffDppId(Long affDppId) {
		this.affDppId = affDppId;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "AFF_DPP_OBJET", length = 1000)
	public String getAffDppObjet() {
		return this.affDppObjet;
	}

	public void setAffDppObjet(String affDppObjet) {
		this.affDppObjet = affDppObjet;
	}

	@Column(name = "AFF_DPP_SOURCE_FIN", length = 1000)
	public String getAffDppSourceFin() {
		return this.affDppSourceFin;
	}

	public void setAffDppSourceFin(String affDppSourceFin) {
		this.affDppSourceFin = affDppSourceFin;
	}

	@Column(name = "LBG_CODE", nullable = false, length = 50)
	public String getLbgCode() {
		return this.lbgCode;
	}

	public void setLbgCode(String lbgCode) {
		this.lbgCode = lbgCode;
	}

	@Column(name = "LBG_IMPUTATION", nullable = false, length = 50)
	public String getLbgImputation() {
		return this.lbgImputation;
	}

	public void setLbgImputation(String lbgImputation) {
		this.lbgImputation = lbgImputation;
	}

	@Column(name = "NAT_CODE", nullable = false, length = 20)
	public String getNatCode() {
		return this.natCode;
	}

	public void setNatCode(String natCode) {
		this.natCode = natCode;
	}

	@Column(name = "NAT_LIBELLE", length = 200)
	public String getNatLibelle() {
		return this.natLibelle;
	}

	public void setNatLibelle(String natLibelle) {
		this.natLibelle = natLibelle;
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

	@Column(name = "AFF_DPP_DATE_AVIS_AO_PUBLICAT", length = 7)
	public Date getAffDppDateAvisAoPublicat() {
		return this.affDppDateAvisAoPublicat;
	}

	public void setAffDppDateAvisAoPublicat(Date affDppDateAvisAoPublicat) {
		this.affDppDateAvisAoPublicat = affDppDateAvisAoPublicat;
	}

	@Column(name = "AFF_DPP_DATE_OUVERT_OT", length = 7)
	public Date getAffDppDateOuvertOt() {
		return this.affDppDateOuvertOt;
	}

	public void setAffDppDateOuvertOt(Date affDppDateOuvertOt) {
		this.affDppDateOuvertOt = affDppDateOuvertOt;
	}

	@Column(name = "AFF_DPP_DATE_OUVERT_OF", length = 7)
	public Date getAffDppDateOuvertOf() {
		return this.affDppDateOuvertOf;
	}

	public void setAffDppDateOuvertOf(Date affDppDateOuvertOf) {
		this.affDppDateOuvertOf = affDppDateOuvertOf;
	}

	@Column(name = "AFF_DPP_DATE_JUGEMENT_OFFRE", length = 7)
	public Date getAffDppDateJugementOffre() {
		return this.affDppDateJugementOffre;
	}

	public void setAffDppDateJugementOffre(Date affDppDateJugementOffre) {
		this.affDppDateJugementOffre = affDppDateJugementOffre;
	}

	@Column(name = "AFF_DPP_DATE_ATT_APPROB_DMP", length = 7)
	public Date getAffDppDateAttApprobDmp() {
		return this.affDppDateAttApprobDmp;
	}

	public void setAffDppDateAttApprobDmp(Date affDppDateAttApprobDmp) {
		this.affDppDateAttApprobDmp = affDppDateAttApprobDmp;
	}

	@Column(name = "AFF_DPP_DATE_ATT_APPRO_BAIL", length = 7)
	public Date getAffDppDateAttApproBail() {
		return this.affDppDateAttApproBail;
	}

	public void setAffDppDateAttApproBail(Date affDppDateAttApproBail) {
		this.affDppDateAttApproBail = affDppDateAttApproBail;
	}

	@Column(name = "AFF_DPP_PLP_ID", nullable = false, precision = 10, scale = 0)
	public long getAffDppPlpId() {
		return this.affDppPlpId;
	}

	public void setAffDppPlpId(long affDppPlpId) {
		this.affDppPlpId = affDppPlpId;
	}

	@Column(name = "AFF_DPP_STR_BENEFI", length = 1000)
	public String getAffDppStrBenefi() {
		return this.affDppStrBenefi;
	}

	public void setAffDppStrBenefi(String affDppStrBenefi) {
		this.affDppStrBenefi = affDppStrBenefi;
	}

	@Column(name = "AFF_DPP_STR_CONDUC", length = 1000)
	public String getAffDppStrConduc() {
		return this.affDppStrConduc;
	}

	public void setAffDppStrConduc(String affDppStrConduc) {
		this.affDppStrConduc = affDppStrConduc;
	}

	@Column(name = "AFF_DPP_TYPE_PLAN", nullable = false, length = 3)
	public String getAffDppTypePlan() {
		return this.affDppTypePlan;
	}

	public void setAffDppTypePlan(String affDppTypePlan) {
		this.affDppTypePlan = affDppTypePlan;
	}

	@Column(name = "AFF_DPP_DATE_NEGOCIATION", length = 7)
	public Date getAffDppDateNegociation() {
		return this.affDppDateNegociation;
	}

	public void setAffDppDateNegociation(Date affDppDateNegociation) {
		this.affDppDateNegociation = affDppDateNegociation;
	}

	@Column(name = "AFF_DPP_DATE_ELAB_RAPPORT", length = 7)
	public Date getAffDppDateElabRapport() {
		return this.affDppDateElabRapport;
	}

	public void setAffDppDateElabRapport(Date affDppDateElabRapport) {
		this.affDppDateElabRapport = affDppDateElabRapport;
	}

	@Column(name = "AFF_DPP_DATE_SIGNAT_ATTRIB", length = 7)
	public Date getAffDppDateSignatAttrib() {
		return this.affDppDateSignatAttrib;
	}

	public void setAffDppDateSignatAttrib(Date affDppDateSignatAttrib) {
		this.affDppDateSignatAttrib = affDppDateSignatAttrib;
	}

	@Column(name = "AFF_DPP_DATE_SIGNAT_AC", length = 7)
	public Date getAffDppDateSignatAc() {
		return this.affDppDateSignatAc;
	}

	public void setAffDppDateSignatAc(Date affDppDateSignatAc) {
		this.affDppDateSignatAc = affDppDateSignatAc;
	}

	@Column(name = "AFF_DPP_DATE_EXEC_DEBUT", length = 7)
	public Date getAffDppDateExecDebut() {
		return this.affDppDateExecDebut;
	}

	public void setAffDppDateExecDebut(Date affDppDateExecDebut) {
		this.affDppDateExecDebut = affDppDateExecDebut;
	}

	@Column(name = "AFF_DPP_DATE_EXEC_FIN", length = 7)
	public Date getAffDppDateExecFin() {
		return this.affDppDateExecFin;
	}

	public void setAffDppDateExecFin(Date affDppDateExecFin) {
		this.affDppDateExecFin = affDppDateExecFin;
	}

	@Column(name = "AFF_DPP_DATE_DAO_TRANS", length = 7)
	public Date getAffDppDateDaoTrans() {
		return this.affDppDateDaoTrans;
	}

	public void setAffDppDateDaoTrans(Date affDppDateDaoTrans) {
		this.affDppDateDaoTrans = affDppDateDaoTrans;
	}

	@Column(name = "AFF_DPP_DATE_DAO_APPROB_DMP", length = 7)
	public Date getAffDppDateDaoApprobDmp() {
		return this.affDppDateDaoApprobDmp;
	}

	public void setAffDppDateDaoApprobDmp(Date affDppDateDaoApprobDmp) {
		this.affDppDateDaoApprobDmp = affDppDateDaoApprobDmp;
	}

	@Column(name = "AFF_DPP_DATE_DAO_APPROB_BAIL", length = 7)
	public Date getAffDppDateDaoApprobBail() {
		return this.affDppDateDaoApprobBail;
	}

	public void setAffDppDateDaoApprobBail(Date affDppDateDaoApprobBail) {
		this.affDppDateDaoApprobBail = affDppDateDaoApprobBail;
	}

	@Column(name = "AFF_DPP_APPROB_ANO", length = 7)
	public Date getAffDppApprobAno() {
		return this.affDppApprobAno;
	}

	public void setAffDppApprobAno(Date affDppApprobAno) {
		this.affDppApprobAno = affDppApprobAno;
	}

	@Column(name = "AFF_DPP_INV_ENTRE", length = 7)
	public Date getAffDppInvEntre() {
		return this.affDppInvEntre;
	}

	public void setAffDppInvEntre(Date affDppInvEntre) {
		this.affDppInvEntre = affDppInvEntre;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VPpmEtatId))
			return false;
		VPpmEtatId castOther = (VPpmEtatId) other;

		return ((this.getVId() == castOther.getVId())
				|| (this.getVId() != null && castOther.getVId() != null && this.getVId().equals(castOther.getVId())))
				&& (this.getAffId() == castOther.getAffId())
				&& ((this.getAffDppId() == castOther.getAffDppId()) || (this.getAffDppId() != null
						&& castOther.getAffDppId() != null && this.getAffDppId().equals(castOther.getAffDppId())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getAffDppObjet() == castOther.getAffDppObjet())
						|| (this.getAffDppObjet() != null && castOther.getAffDppObjet() != null
								&& this.getAffDppObjet().equals(castOther.getAffDppObjet())))
				&& ((this.getAffDppSourceFin() == castOther.getAffDppSourceFin())
						|| (this.getAffDppSourceFin() != null && castOther.getAffDppSourceFin() != null
								&& this.getAffDppSourceFin().equals(castOther.getAffDppSourceFin())))
				&& ((this.getLbgCode() == castOther.getLbgCode()) || (this.getLbgCode() != null
						&& castOther.getLbgCode() != null && this.getLbgCode().equals(castOther.getLbgCode())))
				&& ((this.getLbgImputation() == castOther.getLbgImputation())
						|| (this.getLbgImputation() != null && castOther.getLbgImputation() != null
								&& this.getLbgImputation().equals(castOther.getLbgImputation())))
				&& ((this.getNatCode() == castOther.getNatCode()) || (this.getNatCode() != null
						&& castOther.getNatCode() != null && this.getNatCode().equals(castOther.getNatCode())))
				&& ((this.getNatLibelle() == castOther.getNatLibelle()) || (this.getNatLibelle() != null
						&& castOther.getNatLibelle() != null && this.getNatLibelle().equals(castOther.getNatLibelle())))
				&& ((this.getTymLibelleCourt() == castOther.getTymLibelleCourt())
						|| (this.getTymLibelleCourt() != null && castOther.getTymLibelleCourt() != null
								&& this.getTymLibelleCourt().equals(castOther.getTymLibelleCourt())))
				&& ((this.getMopLibelleLong() == castOther.getMopLibelleLong())
						|| (this.getMopLibelleLong() != null && castOther.getMopLibelleLong() != null
								&& this.getMopLibelleLong().equals(castOther.getMopLibelleLong())))
				&& ((this.getAffDppDateAvisAoPublicat() == castOther.getAffDppDateAvisAoPublicat())
						|| (this.getAffDppDateAvisAoPublicat() != null
								&& castOther.getAffDppDateAvisAoPublicat() != null
								&& this.getAffDppDateAvisAoPublicat().equals(castOther.getAffDppDateAvisAoPublicat())))
				&& ((this.getAffDppDateOuvertOt() == castOther.getAffDppDateOuvertOt())
						|| (this.getAffDppDateOuvertOt() != null && castOther.getAffDppDateOuvertOt() != null
								&& this.getAffDppDateOuvertOt().equals(castOther.getAffDppDateOuvertOt())))
				&& ((this.getAffDppDateOuvertOf() == castOther.getAffDppDateOuvertOf())
						|| (this.getAffDppDateOuvertOf() != null && castOther.getAffDppDateOuvertOf() != null
								&& this.getAffDppDateOuvertOf().equals(castOther.getAffDppDateOuvertOf())))
				&& ((this.getAffDppDateJugementOffre() == castOther.getAffDppDateJugementOffre())
						|| (this.getAffDppDateJugementOffre() != null && castOther.getAffDppDateJugementOffre() != null
								&& this.getAffDppDateJugementOffre().equals(castOther.getAffDppDateJugementOffre())))
				&& ((this.getAffDppDateAttApprobDmp() == castOther.getAffDppDateAttApprobDmp())
						|| (this.getAffDppDateAttApprobDmp() != null && castOther.getAffDppDateAttApprobDmp() != null
								&& this.getAffDppDateAttApprobDmp().equals(castOther.getAffDppDateAttApprobDmp())))
				&& ((this.getAffDppDateAttApproBail() == castOther.getAffDppDateAttApproBail())
						|| (this.getAffDppDateAttApproBail() != null && castOther.getAffDppDateAttApproBail() != null
								&& this.getAffDppDateAttApproBail().equals(castOther.getAffDppDateAttApproBail())))
				&& (this.getAffDppPlpId() == castOther.getAffDppPlpId())
				&& ((this.getAffDppStrBenefi() == castOther.getAffDppStrBenefi())
						|| (this.getAffDppStrBenefi() != null && castOther.getAffDppStrBenefi() != null
								&& this.getAffDppStrBenefi().equals(castOther.getAffDppStrBenefi())))
				&& ((this.getAffDppStrConduc() == castOther.getAffDppStrConduc())
						|| (this.getAffDppStrConduc() != null && castOther.getAffDppStrConduc() != null
								&& this.getAffDppStrConduc().equals(castOther.getAffDppStrConduc())))
				&& ((this.getAffDppTypePlan() == castOther.getAffDppTypePlan())
						|| (this.getAffDppTypePlan() != null && castOther.getAffDppTypePlan() != null
								&& this.getAffDppTypePlan().equals(castOther.getAffDppTypePlan())))
				&& ((this.getAffDppDateNegociation() == castOther.getAffDppDateNegociation())
						|| (this.getAffDppDateNegociation() != null && castOther.getAffDppDateNegociation() != null
								&& this.getAffDppDateNegociation().equals(castOther.getAffDppDateNegociation())))
				&& ((this.getAffDppDateElabRapport() == castOther.getAffDppDateElabRapport())
						|| (this.getAffDppDateElabRapport() != null && castOther.getAffDppDateElabRapport() != null
								&& this.getAffDppDateElabRapport().equals(castOther.getAffDppDateElabRapport())))
				&& ((this.getAffDppDateSignatAttrib() == castOther.getAffDppDateSignatAttrib())
						|| (this.getAffDppDateSignatAttrib() != null && castOther.getAffDppDateSignatAttrib() != null
								&& this.getAffDppDateSignatAttrib().equals(castOther.getAffDppDateSignatAttrib())))
				&& ((this.getAffDppDateSignatAc() == castOther.getAffDppDateSignatAc())
						|| (this.getAffDppDateSignatAc() != null && castOther.getAffDppDateSignatAc() != null
								&& this.getAffDppDateSignatAc().equals(castOther.getAffDppDateSignatAc())))
				&& ((this.getAffDppDateExecDebut() == castOther.getAffDppDateExecDebut())
						|| (this.getAffDppDateExecDebut() != null && castOther.getAffDppDateExecDebut() != null
								&& this.getAffDppDateExecDebut().equals(castOther.getAffDppDateExecDebut())))
				&& ((this.getAffDppDateExecFin() == castOther.getAffDppDateExecFin())
						|| (this.getAffDppDateExecFin() != null && castOther.getAffDppDateExecFin() != null
								&& this.getAffDppDateExecFin().equals(castOther.getAffDppDateExecFin())))
				&& ((this.getAffDppDateDaoTrans() == castOther.getAffDppDateDaoTrans())
						|| (this.getAffDppDateDaoTrans() != null && castOther.getAffDppDateDaoTrans() != null
								&& this.getAffDppDateDaoTrans().equals(castOther.getAffDppDateDaoTrans())))
				&& ((this.getAffDppDateDaoApprobDmp() == castOther.getAffDppDateDaoApprobDmp())
						|| (this.getAffDppDateDaoApprobDmp() != null && castOther.getAffDppDateDaoApprobDmp() != null
								&& this.getAffDppDateDaoApprobDmp().equals(castOther.getAffDppDateDaoApprobDmp())))
				&& ((this.getAffDppDateDaoApprobBail() == castOther.getAffDppDateDaoApprobBail())
						|| (this.getAffDppDateDaoApprobBail() != null && castOther.getAffDppDateDaoApprobBail() != null
								&& this.getAffDppDateDaoApprobBail().equals(castOther.getAffDppDateDaoApprobBail())))
				&& ((this.getAffDppApprobAno() == castOther.getAffDppApprobAno())
						|| (this.getAffDppApprobAno() != null && castOther.getAffDppApprobAno() != null
								&& this.getAffDppApprobAno().equals(castOther.getAffDppApprobAno())))
				&& ((this.getAffDppInvEntre() == castOther.getAffDppInvEntre())
						|| (this.getAffDppInvEntre() != null && castOther.getAffDppInvEntre() != null
								&& this.getAffDppInvEntre().equals(castOther.getAffDppInvEntre())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getVId() == null ? 0 : this.getVId().hashCode());
		result = 37 * result + (int) this.getAffId();
		result = 37 * result + (getAffDppId() == null ? 0 : this.getAffDppId().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getAffDppObjet() == null ? 0 : this.getAffDppObjet().hashCode());
		result = 37 * result + (getAffDppSourceFin() == null ? 0 : this.getAffDppSourceFin().hashCode());
		result = 37 * result + (getLbgCode() == null ? 0 : this.getLbgCode().hashCode());
		result = 37 * result + (getLbgImputation() == null ? 0 : this.getLbgImputation().hashCode());
		result = 37 * result + (getNatCode() == null ? 0 : this.getNatCode().hashCode());
		result = 37 * result + (getNatLibelle() == null ? 0 : this.getNatLibelle().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		result = 37 * result
				+ (getAffDppDateAvisAoPublicat() == null ? 0 : this.getAffDppDateAvisAoPublicat().hashCode());
		result = 37 * result + (getAffDppDateOuvertOt() == null ? 0 : this.getAffDppDateOuvertOt().hashCode());
		result = 37 * result + (getAffDppDateOuvertOf() == null ? 0 : this.getAffDppDateOuvertOf().hashCode());
		result = 37 * result
				+ (getAffDppDateJugementOffre() == null ? 0 : this.getAffDppDateJugementOffre().hashCode());
		result = 37 * result + (getAffDppDateAttApprobDmp() == null ? 0 : this.getAffDppDateAttApprobDmp().hashCode());
		result = 37 * result + (getAffDppDateAttApproBail() == null ? 0 : this.getAffDppDateAttApproBail().hashCode());
		result = 37 * result + (int) this.getAffDppPlpId();
		result = 37 * result + (getAffDppStrBenefi() == null ? 0 : this.getAffDppStrBenefi().hashCode());
		result = 37 * result + (getAffDppStrConduc() == null ? 0 : this.getAffDppStrConduc().hashCode());
		result = 37 * result + (getAffDppTypePlan() == null ? 0 : this.getAffDppTypePlan().hashCode());
		result = 37 * result + (getAffDppDateNegociation() == null ? 0 : this.getAffDppDateNegociation().hashCode());
		result = 37 * result + (getAffDppDateElabRapport() == null ? 0 : this.getAffDppDateElabRapport().hashCode());
		result = 37 * result + (getAffDppDateSignatAttrib() == null ? 0 : this.getAffDppDateSignatAttrib().hashCode());
		result = 37 * result + (getAffDppDateSignatAc() == null ? 0 : this.getAffDppDateSignatAc().hashCode());
		result = 37 * result + (getAffDppDateExecDebut() == null ? 0 : this.getAffDppDateExecDebut().hashCode());
		result = 37 * result + (getAffDppDateExecFin() == null ? 0 : this.getAffDppDateExecFin().hashCode());
		result = 37 * result + (getAffDppDateDaoTrans() == null ? 0 : this.getAffDppDateDaoTrans().hashCode());
		result = 37 * result + (getAffDppDateDaoApprobDmp() == null ? 0 : this.getAffDppDateDaoApprobDmp().hashCode());
		result = 37 * result
				+ (getAffDppDateDaoApprobBail() == null ? 0 : this.getAffDppDateDaoApprobBail().hashCode());
		result = 37 * result + (getAffDppApprobAno() == null ? 0 : this.getAffDppApprobAno().hashCode());
		result = 37 * result + (getAffDppInvEntre() == null ? 0 : this.getAffDppInvEntre().hashCode());
		return result;
	}

}
