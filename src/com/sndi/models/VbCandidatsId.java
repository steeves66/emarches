package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbCandidatsId generated by hbm2java
 */
@Embeddable
public class VbCandidatsId implements java.io.Serializable {

	private BigDecimal canCode;
	private String canTieNcc;
	private String canSouNcc;
	private String canNomResp;
	private String canNom;
	private String canPrenoms;
	private String canTel;
	private Date canDteSaisi;
	private String canOpeMatricule;
	private String canEmail;

	public VbCandidatsId() {
	}

	public VbCandidatsId(BigDecimal canCode) {
		this.canCode = canCode;
	}

	public VbCandidatsId(BigDecimal canCode, String canTieNcc, String canSouNcc, String canNomResp, String canNom,
			String canPrenoms, String canTel, Date canDteSaisi, String canOpeMatricule, String canEmail) {
		this.canCode = canCode;
		this.canTieNcc = canTieNcc;
		this.canSouNcc = canSouNcc;
		this.canNomResp = canNomResp;
		this.canNom = canNom;
		this.canPrenoms = canPrenoms;
		this.canTel = canTel;
		this.canDteSaisi = canDteSaisi;
		this.canOpeMatricule = canOpeMatricule;
		this.canEmail = canEmail;
	}

	@Column(name = "CAN_CODE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCanCode() {
		return this.canCode;
	}

	public void setCanCode(BigDecimal canCode) {
		this.canCode = canCode;
	}

	@Column(name = "CAN_TIE_NCC", length = 32)
	public String getCanTieNcc() {
		return this.canTieNcc;
	}

	public void setCanTieNcc(String canTieNcc) {
		this.canTieNcc = canTieNcc;
	}

	@Column(name = "CAN_SOU_NCC", length = 20)
	public String getCanSouNcc() {
		return this.canSouNcc;
	}

	public void setCanSouNcc(String canSouNcc) {
		this.canSouNcc = canSouNcc;
	}

	@Column(name = "CAN_NOM_RESP", length = 500)
	public String getCanNomResp() {
		return this.canNomResp;
	}

	public void setCanNomResp(String canNomResp) {
		this.canNomResp = canNomResp;
	}

	@Column(name = "CAN_NOM", length = 500)
	public String getCanNom() {
		return this.canNom;
	}

	public void setCanNom(String canNom) {
		this.canNom = canNom;
	}

	@Column(name = "CAN_PRENOMS", length = 500)
	public String getCanPrenoms() {
		return this.canPrenoms;
	}

	public void setCanPrenoms(String canPrenoms) {
		this.canPrenoms = canPrenoms;
	}

	@Column(name = "CAN_TEL", length = 50)
	public String getCanTel() {
		return this.canTel;
	}

	public void setCanTel(String canTel) {
		this.canTel = canTel;
	}

	@Column(name = "CAN_DTE_SAISI", length = 7)
	public Date getCanDteSaisi() {
		return this.canDteSaisi;
	}

	public void setCanDteSaisi(Date canDteSaisi) {
		this.canDteSaisi = canDteSaisi;
	}

	@Column(name = "CAN_OPE_MATRICULE", length = 25)
	public String getCanOpeMatricule() {
		return this.canOpeMatricule;
	}

	public void setCanOpeMatricule(String canOpeMatricule) {
		this.canOpeMatricule = canOpeMatricule;
	}

	@Column(name = "CAN_EMAIL", length = 20)
	public String getCanEmail() {
		return this.canEmail;
	}

	public void setCanEmail(String canEmail) {
		this.canEmail = canEmail;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbCandidatsId))
			return false;
		VbCandidatsId castOther = (VbCandidatsId) other;

		return ((this.getCanCode() == castOther.getCanCode()) || (this.getCanCode() != null
				&& castOther.getCanCode() != null && this.getCanCode().equals(castOther.getCanCode())))
				&& ((this.getCanTieNcc() == castOther.getCanTieNcc()) || (this.getCanTieNcc() != null
						&& castOther.getCanTieNcc() != null && this.getCanTieNcc().equals(castOther.getCanTieNcc())))
				&& ((this.getCanSouNcc() == castOther.getCanSouNcc()) || (this.getCanSouNcc() != null
						&& castOther.getCanSouNcc() != null && this.getCanSouNcc().equals(castOther.getCanSouNcc())))
				&& ((this.getCanNomResp() == castOther.getCanNomResp()) || (this.getCanNomResp() != null
						&& castOther.getCanNomResp() != null && this.getCanNomResp().equals(castOther.getCanNomResp())))
				&& ((this.getCanNom() == castOther.getCanNom()) || (this.getCanNom() != null
						&& castOther.getCanNom() != null && this.getCanNom().equals(castOther.getCanNom())))
				&& ((this.getCanPrenoms() == castOther.getCanPrenoms()) || (this.getCanPrenoms() != null
						&& castOther.getCanPrenoms() != null && this.getCanPrenoms().equals(castOther.getCanPrenoms())))
				&& ((this.getCanTel() == castOther.getCanTel()) || (this.getCanTel() != null
						&& castOther.getCanTel() != null && this.getCanTel().equals(castOther.getCanTel())))
				&& ((this.getCanDteSaisi() == castOther.getCanDteSaisi())
						|| (this.getCanDteSaisi() != null && castOther.getCanDteSaisi() != null
								&& this.getCanDteSaisi().equals(castOther.getCanDteSaisi())))
				&& ((this.getCanOpeMatricule() == castOther.getCanOpeMatricule())
						|| (this.getCanOpeMatricule() != null && castOther.getCanOpeMatricule() != null
								&& this.getCanOpeMatricule().equals(castOther.getCanOpeMatricule())))
				&& ((this.getCanEmail() == castOther.getCanEmail()) || (this.getCanEmail() != null
						&& castOther.getCanEmail() != null && this.getCanEmail().equals(castOther.getCanEmail())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCanCode() == null ? 0 : this.getCanCode().hashCode());
		result = 37 * result + (getCanTieNcc() == null ? 0 : this.getCanTieNcc().hashCode());
		result = 37 * result + (getCanSouNcc() == null ? 0 : this.getCanSouNcc().hashCode());
		result = 37 * result + (getCanNomResp() == null ? 0 : this.getCanNomResp().hashCode());
		result = 37 * result + (getCanNom() == null ? 0 : this.getCanNom().hashCode());
		result = 37 * result + (getCanPrenoms() == null ? 0 : this.getCanPrenoms().hashCode());
		result = 37 * result + (getCanTel() == null ? 0 : this.getCanTel().hashCode());
		result = 37 * result + (getCanDteSaisi() == null ? 0 : this.getCanDteSaisi().hashCode());
		result = 37 * result + (getCanOpeMatricule() == null ? 0 : this.getCanOpeMatricule().hashCode());
		result = 37 * result + (getCanEmail() == null ? 0 : this.getCanEmail().hashCode());
		return result;
	}

}
