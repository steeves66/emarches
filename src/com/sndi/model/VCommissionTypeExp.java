package com.sndi.model;
// Generated 18 juin 2020 14:32:33 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "V_COMMISSION_TYPE_EXP")
public class VCommissionTypeExp implements java.io.Serializable {

	private String tctCode;
	private String tctLibelle;
	private String tctTitre;
	private String tctTstCode;
	private String tctTcoCode;
	private Date tctDteSaisi;
	private String tctOpeMatricule;
	private String tctGrpCode;
	private String tctNomMbm;
	private String tctPreMbm;
	private String tctTelMbm;
	private String tctRepMandate;

	public VCommissionTypeExp() {
	}

	public VCommissionTypeExp(String tctCode) {
		this.tctCode = tctCode;
	}

	public VCommissionTypeExp(String tctCode, String tctLibelle, String tctTitre, String tctTstCode,
			String tctTcoCode, Date tctDteSaisi, String tctOpeMatricule, String tctGrpCode, String tctNomMbm,
			String tctPreMbm, String tctTelMbm, String tctRepMandate) {
		this.tctCode = tctCode;
		this.tctLibelle = tctLibelle;
		this.tctTitre = tctTitre;
		this.tctTstCode = tctTstCode;
		this.tctTcoCode = tctTcoCode;
		this.tctDteSaisi = tctDteSaisi;
		this.tctOpeMatricule = tctOpeMatricule;
		this.tctGrpCode = tctGrpCode;
		this.tctNomMbm = tctNomMbm;
		this.tctPreMbm = tctPreMbm;
		this.tctTelMbm = tctTelMbm;
		this.tctRepMandate = tctRepMandate;
	}

	@Id
	@Column(name = "TCT_CODE", nullable = false, length = 3)
	public String getTctCode() {
		return this.tctCode;
	}

	public void setTctCode(String tctCode) {
		this.tctCode = tctCode;
	}

	@Column(name = "TCT_LIBELLE", length = 500)
	public String getTctLibelle() {
		return this.tctLibelle;
	}

	public void setTctLibelle(String tctLibelle) {
		this.tctLibelle = tctLibelle;
	}

	@Column(name = "TCT_TITRE", length = 200)
	public String getTctTitre() {
		return this.tctTitre;
	}

	public void setTctTitre(String tctTitre) {
		this.tctTitre = tctTitre;
	}

	@Column(name = "TCT_TST_CODE", length = 3)
	public String getTctTstCode() {
		return this.tctTstCode;
	}

	public void setTctTstCode(String tctTstCode) {
		this.tctTstCode = tctTstCode;
	}

	@Column(name = "TCT_TCO_CODE", length = 3)
	public String getTctTcoCode() {
		return this.tctTcoCode;
	}

	public void setTctTcoCode(String tctTcoCode) {
		this.tctTcoCode = tctTcoCode;
	}

	@Column(name = "TCT_DTE_SAISI", length = 7)
	public Date getTctDteSaisi() {
		return this.tctDteSaisi;
	}

	public void setTctDteSaisi(Date tctDteSaisi) {
		this.tctDteSaisi = tctDteSaisi;
	}

	@Column(name = "TCT_OPE_MATRICULE", length = 20)
	public String getTctOpeMatricule() {
		return this.tctOpeMatricule;
	}

	public void setTctOpeMatricule(String tctOpeMatricule) {
		this.tctOpeMatricule = tctOpeMatricule;
	}

	@Column(name = "TCT_GRP_CODE", length = 20)
	public String getTctGrpCode() {
		return this.tctGrpCode;
	}

	public void setTctGrpCode(String tctGrpCode) {
		this.tctGrpCode = tctGrpCode;
	}

	@Column(name = "TCT_NOM_MBM", length = 100)
	public String getTctNomMbm() {
		return this.tctNomMbm;
	}

	public void setTctNomMbm(String tctNomMbm) {
		this.tctNomMbm = tctNomMbm;
	}

	@Column(name = "TCT_PRE_MBM", length = 200)
	public String getTctPreMbm() {
		return this.tctPreMbm;
	}

	public void setTctPreMbm(String tctPreMbm) {
		this.tctPreMbm = tctPreMbm;
	}

	@Column(name = "TCT_TEL_MBM", length = 20)
	public String getTctTelMbm() {
		return this.tctTelMbm;
	}

	public void setTctTelMbm(String tctTelMbm) {
		this.tctTelMbm = tctTelMbm;
	}

	@Column(name = "TCT_REP_MANDATE", length = 1)
	public String getTctRepMandate() {
		return this.tctRepMandate;
	}

	public void setTctRepMandate(String tctRepMandate) {
		this.tctRepMandate = tctRepMandate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VCommissionTypeExp))
			return false;
		VCommissionTypeExp castOther = (VCommissionTypeExp) other;

		return ((this.getTctCode() == castOther.getTctCode()) || (this.getTctCode() != null
				&& castOther.getTctCode() != null && this.getTctCode().equals(castOther.getTctCode())))
				&& ((this.getTctLibelle() == castOther.getTctLibelle()) || (this.getTctLibelle() != null
						&& castOther.getTctLibelle() != null && this.getTctLibelle().equals(castOther.getTctLibelle())))
				&& ((this.getTctTitre() == castOther.getTctTitre()) || (this.getTctTitre() != null
						&& castOther.getTctTitre() != null && this.getTctTitre().equals(castOther.getTctTitre())))
				&& ((this.getTctTstCode() == castOther.getTctTstCode()) || (this.getTctTstCode() != null
						&& castOther.getTctTstCode() != null && this.getTctTstCode().equals(castOther.getTctTstCode())))
				&& ((this.getTctTcoCode() == castOther.getTctTcoCode()) || (this.getTctTcoCode() != null
						&& castOther.getTctTcoCode() != null && this.getTctTcoCode().equals(castOther.getTctTcoCode())))
				&& ((this.getTctDteSaisi() == castOther.getTctDteSaisi())
						|| (this.getTctDteSaisi() != null && castOther.getTctDteSaisi() != null
								&& this.getTctDteSaisi().equals(castOther.getTctDteSaisi())))
				&& ((this.getTctOpeMatricule() == castOther.getTctOpeMatricule())
						|| (this.getTctOpeMatricule() != null && castOther.getTctOpeMatricule() != null
								&& this.getTctOpeMatricule().equals(castOther.getTctOpeMatricule())))
				&& ((this.getTctGrpCode() == castOther.getTctGrpCode()) || (this.getTctGrpCode() != null
						&& castOther.getTctGrpCode() != null && this.getTctGrpCode().equals(castOther.getTctGrpCode())))
				&& ((this.getTctNomMbm() == castOther.getTctNomMbm()) || (this.getTctNomMbm() != null
						&& castOther.getTctNomMbm() != null && this.getTctNomMbm().equals(castOther.getTctNomMbm())))
				&& ((this.getTctPreMbm() == castOther.getTctPreMbm()) || (this.getTctPreMbm() != null
						&& castOther.getTctPreMbm() != null && this.getTctPreMbm().equals(castOther.getTctPreMbm())))
				&& ((this.getTctTelMbm() == castOther.getTctTelMbm()) || (this.getTctTelMbm() != null
						&& castOther.getTctTelMbm() != null && this.getTctTelMbm().equals(castOther.getTctTelMbm())))
				&& ((this.getTctRepMandate() == castOther.getTctRepMandate())
						|| (this.getTctRepMandate() != null && castOther.getTctRepMandate() != null
								&& this.getTctRepMandate().equals(castOther.getTctRepMandate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTctCode() == null ? 0 : this.getTctCode().hashCode());
		result = 37 * result + (getTctLibelle() == null ? 0 : this.getTctLibelle().hashCode());
		result = 37 * result + (getTctTitre() == null ? 0 : this.getTctTitre().hashCode());
		result = 37 * result + (getTctTstCode() == null ? 0 : this.getTctTstCode().hashCode());
		result = 37 * result + (getTctTcoCode() == null ? 0 : this.getTctTcoCode().hashCode());
		result = 37 * result + (getTctDteSaisi() == null ? 0 : this.getTctDteSaisi().hashCode());
		result = 37 * result + (getTctOpeMatricule() == null ? 0 : this.getTctOpeMatricule().hashCode());
		result = 37 * result + (getTctGrpCode() == null ? 0 : this.getTctGrpCode().hashCode());
		result = 37 * result + (getTctNomMbm() == null ? 0 : this.getTctNomMbm().hashCode());
		result = 37 * result + (getTctPreMbm() == null ? 0 : this.getTctPreMbm().hashCode());
		result = 37 * result + (getTctTelMbm() == null ? 0 : this.getTctTelMbm().hashCode());
		result = 37 * result + (getTctRepMandate() == null ? 0 : this.getTctRepMandate().hashCode());
		return result;
	}

}
