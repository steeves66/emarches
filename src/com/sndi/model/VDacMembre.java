package com.sndi.model;
// Generated 18 juin 2020 17:55:39 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "V_DAC_MEMBRE")
public class VDacMembre implements java.io.Serializable {

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
	private BigDecimal comNum;
	private Date comDteSaisi;
	private String comStrCode;
	private String comTctCode;
	private String comOpeMatricule;
	private String comDacCode;
	private String comMarCode;
	private String comAaoCode;
	private String comTcoCode;

	public VDacMembre() {
	}

	public VDacMembre(String tctCode) {
		this.tctCode = tctCode;
	}

	public VDacMembre(String tctCode, String tctLibelle, String tctTitre, String tctTstCode, String tctTcoCode,
			Date tctDteSaisi, String tctOpeMatricule, String tctGrpCode, String tctNomMbm, String tctPreMbm,
			String tctTelMbm, String tctRepMandate, BigDecimal comNum, Date comDteSaisi, String comStrCode,
			String comTctCode, String comOpeMatricule, String comDacCode, String comMarCode, String comAaoCode,
			String comTcoCode) {
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
		this.comNum = comNum;
		this.comDteSaisi = comDteSaisi;
		this.comStrCode = comStrCode;
		this.comTctCode = comTctCode;
		this.comOpeMatricule = comOpeMatricule;
		this.comDacCode = comDacCode;
		this.comMarCode = comMarCode;
		this.comAaoCode = comAaoCode;
		this.comTcoCode = comTcoCode;
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

	@Column(name = "COM_NUM", precision = 22, scale = 0)
	public BigDecimal getComNum() {
		return this.comNum;
	}

	public void setComNum(BigDecimal comNum) {
		this.comNum = comNum;
	}

	@Column(name = "COM_DTE_SAISI", length = 7)
	public Date getComDteSaisi() {
		return this.comDteSaisi;
	}

	public void setComDteSaisi(Date comDteSaisi) {
		this.comDteSaisi = comDteSaisi;
	}

	@Column(name = "COM_STR_CODE", length = 20)
	public String getComStrCode() {
		return this.comStrCode;
	}

	public void setComStrCode(String comStrCode) {
		this.comStrCode = comStrCode;
	}

	@Column(name = "COM_TCT_CODE", length = 3)
	public String getComTctCode() {
		return this.comTctCode;
	}

	public void setComTctCode(String comTctCode) {
		this.comTctCode = comTctCode;
	}

	@Column(name = "COM_OPE_MATRICULE", length = 20)
	public String getComOpeMatricule() {
		return this.comOpeMatricule;
	}

	public void setComOpeMatricule(String comOpeMatricule) {
		this.comOpeMatricule = comOpeMatricule;
	}

	@Column(name = "COM_DAC_CODE", length = 20)
	public String getComDacCode() {
		return this.comDacCode;
	}

	public void setComDacCode(String comDacCode) {
		this.comDacCode = comDacCode;
	}

	@Column(name = "COM_MAR_CODE", length = 20)
	public String getComMarCode() {
		return this.comMarCode;
	}

	public void setComMarCode(String comMarCode) {
		this.comMarCode = comMarCode;
	}

	@Column(name = "COM_AAO_CODE", length = 20)
	public String getComAaoCode() {
		return this.comAaoCode;
	}

	public void setComAaoCode(String comAaoCode) {
		this.comAaoCode = comAaoCode;
	}

	@Column(name = "COM_TCO_CODE", length = 3)
	public String getComTcoCode() {
		return this.comTcoCode;
	}

	public void setComTcoCode(String comTcoCode) {
		this.comTcoCode = comTcoCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDacMembre))
			return false;
		VDacMembre castOther = (VDacMembre) other;

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
								&& this.getTctRepMandate().equals(castOther.getTctRepMandate())))
				&& ((this.getComNum() == castOther.getComNum()) || (this.getComNum() != null
						&& castOther.getComNum() != null && this.getComNum().equals(castOther.getComNum())))
				&& ((this.getComDteSaisi() == castOther.getComDteSaisi())
						|| (this.getComDteSaisi() != null && castOther.getComDteSaisi() != null
								&& this.getComDteSaisi().equals(castOther.getComDteSaisi())))
				&& ((this.getComStrCode() == castOther.getComStrCode()) || (this.getComStrCode() != null
						&& castOther.getComStrCode() != null && this.getComStrCode().equals(castOther.getComStrCode())))
				&& ((this.getComTctCode() == castOther.getComTctCode()) || (this.getComTctCode() != null
						&& castOther.getComTctCode() != null && this.getComTctCode().equals(castOther.getComTctCode())))
				&& ((this.getComOpeMatricule() == castOther.getComOpeMatricule())
						|| (this.getComOpeMatricule() != null && castOther.getComOpeMatricule() != null
								&& this.getComOpeMatricule().equals(castOther.getComOpeMatricule())))
				&& ((this.getComDacCode() == castOther.getComDacCode()) || (this.getComDacCode() != null
						&& castOther.getComDacCode() != null && this.getComDacCode().equals(castOther.getComDacCode())))
				&& ((this.getComMarCode() == castOther.getComMarCode()) || (this.getComMarCode() != null
						&& castOther.getComMarCode() != null && this.getComMarCode().equals(castOther.getComMarCode())))
				&& ((this.getComAaoCode() == castOther.getComAaoCode()) || (this.getComAaoCode() != null
						&& castOther.getComAaoCode() != null && this.getComAaoCode().equals(castOther.getComAaoCode())))
				&& ((this.getComTcoCode() == castOther.getComTcoCode())
						|| (this.getComTcoCode() != null && castOther.getComTcoCode() != null
								&& this.getComTcoCode().equals(castOther.getComTcoCode())));
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
		result = 37 * result + (getComNum() == null ? 0 : this.getComNum().hashCode());
		result = 37 * result + (getComDteSaisi() == null ? 0 : this.getComDteSaisi().hashCode());
		result = 37 * result + (getComStrCode() == null ? 0 : this.getComStrCode().hashCode());
		result = 37 * result + (getComTctCode() == null ? 0 : this.getComTctCode().hashCode());
		result = 37 * result + (getComOpeMatricule() == null ? 0 : this.getComOpeMatricule().hashCode());
		result = 37 * result + (getComDacCode() == null ? 0 : this.getComDacCode().hashCode());
		result = 37 * result + (getComMarCode() == null ? 0 : this.getComMarCode().hashCode());
		result = 37 * result + (getComAaoCode() == null ? 0 : this.getComAaoCode().hashCode());
		result = 37 * result + (getComTcoCode() == null ? 0 : this.getComTcoCode().hashCode());
		return result;
	}

}
