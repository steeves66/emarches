package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbSoumissionsId generated by hbm2java
 */
@Embeddable
public class VbSoumissionsId implements java.io.Serializable {

	private String souNcc;
	private Character souInter;
	private String souSigleSte;
	private String souNomCom;
	private String souStaCode;
	private String souTel;
	private String souAdresse;
	private Date souDteSaisi;
	private String souOpeMatricule;

	public VbSoumissionsId() {
	}

	public VbSoumissionsId(String souNcc) {
		this.souNcc = souNcc;
	}

	public VbSoumissionsId(String souNcc, Character souInter, String souSigleSte, String souNomCom, String souStaCode,
			String souTel, String souAdresse, Date souDteSaisi, String souOpeMatricule) {
		this.souNcc = souNcc;
		this.souInter = souInter;
		this.souSigleSte = souSigleSte;
		this.souNomCom = souNomCom;
		this.souStaCode = souStaCode;
		this.souTel = souTel;
		this.souAdresse = souAdresse;
		this.souDteSaisi = souDteSaisi;
		this.souOpeMatricule = souOpeMatricule;
	}

	@Column(name = "SOU_NCC", nullable = false, length = 20)
	public String getSouNcc() {
		return this.souNcc;
	}

	public void setSouNcc(String souNcc) {
		this.souNcc = souNcc;
	}

	@Column(name = "SOU_INTER", length = 1)
	public Character getSouInter() {
		return this.souInter;
	}

	public void setSouInter(Character souInter) {
		this.souInter = souInter;
	}

	@Column(name = "SOU_SIGLE_STE", length = 500)
	public String getSouSigleSte() {
		return this.souSigleSte;
	}

	public void setSouSigleSte(String souSigleSte) {
		this.souSigleSte = souSigleSte;
	}

	@Column(name = "SOU_NOM_COM", length = 500)
	public String getSouNomCom() {
		return this.souNomCom;
	}

	public void setSouNomCom(String souNomCom) {
		this.souNomCom = souNomCom;
	}

	@Column(name = "SOU_STA_CODE", length = 3)
	public String getSouStaCode() {
		return this.souStaCode;
	}

	public void setSouStaCode(String souStaCode) {
		this.souStaCode = souStaCode;
	}

	@Column(name = "SOU_TEL", length = 200)
	public String getSouTel() {
		return this.souTel;
	}

	public void setSouTel(String souTel) {
		this.souTel = souTel;
	}

	@Column(name = "SOU_ADRESSE", length = 200)
	public String getSouAdresse() {
		return this.souAdresse;
	}

	public void setSouAdresse(String souAdresse) {
		this.souAdresse = souAdresse;
	}

	@Column(name = "SOU_DTE_SAISI", length = 7)
	public Date getSouDteSaisi() {
		return this.souDteSaisi;
	}

	public void setSouDteSaisi(Date souDteSaisi) {
		this.souDteSaisi = souDteSaisi;
	}

	@Column(name = "SOU_OPE_MATRICULE", length = 25)
	public String getSouOpeMatricule() {
		return this.souOpeMatricule;
	}

	public void setSouOpeMatricule(String souOpeMatricule) {
		this.souOpeMatricule = souOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbSoumissionsId))
			return false;
		VbSoumissionsId castOther = (VbSoumissionsId) other;

		return ((this.getSouNcc() == castOther.getSouNcc()) || (this.getSouNcc() != null
				&& castOther.getSouNcc() != null && this.getSouNcc().equals(castOther.getSouNcc())))
				&& ((this.getSouInter() == castOther.getSouInter()) || (this.getSouInter() != null
						&& castOther.getSouInter() != null && this.getSouInter().equals(castOther.getSouInter())))
				&& ((this.getSouSigleSte() == castOther.getSouSigleSte())
						|| (this.getSouSigleSte() != null && castOther.getSouSigleSte() != null
								&& this.getSouSigleSte().equals(castOther.getSouSigleSte())))
				&& ((this.getSouNomCom() == castOther.getSouNomCom()) || (this.getSouNomCom() != null
						&& castOther.getSouNomCom() != null && this.getSouNomCom().equals(castOther.getSouNomCom())))
				&& ((this.getSouStaCode() == castOther.getSouStaCode()) || (this.getSouStaCode() != null
						&& castOther.getSouStaCode() != null && this.getSouStaCode().equals(castOther.getSouStaCode())))
				&& ((this.getSouTel() == castOther.getSouTel()) || (this.getSouTel() != null
						&& castOther.getSouTel() != null && this.getSouTel().equals(castOther.getSouTel())))
				&& ((this.getSouAdresse() == castOther.getSouAdresse()) || (this.getSouAdresse() != null
						&& castOther.getSouAdresse() != null && this.getSouAdresse().equals(castOther.getSouAdresse())))
				&& ((this.getSouDteSaisi() == castOther.getSouDteSaisi())
						|| (this.getSouDteSaisi() != null && castOther.getSouDteSaisi() != null
								&& this.getSouDteSaisi().equals(castOther.getSouDteSaisi())))
				&& ((this.getSouOpeMatricule() == castOther.getSouOpeMatricule())
						|| (this.getSouOpeMatricule() != null && castOther.getSouOpeMatricule() != null
								&& this.getSouOpeMatricule().equals(castOther.getSouOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSouNcc() == null ? 0 : this.getSouNcc().hashCode());
		result = 37 * result + (getSouInter() == null ? 0 : this.getSouInter().hashCode());
		result = 37 * result + (getSouSigleSte() == null ? 0 : this.getSouSigleSte().hashCode());
		result = 37 * result + (getSouNomCom() == null ? 0 : this.getSouNomCom().hashCode());
		result = 37 * result + (getSouStaCode() == null ? 0 : this.getSouStaCode().hashCode());
		result = 37 * result + (getSouTel() == null ? 0 : this.getSouTel().hashCode());
		result = 37 * result + (getSouAdresse() == null ? 0 : this.getSouAdresse().hashCode());
		result = 37 * result + (getSouDteSaisi() == null ? 0 : this.getSouDteSaisi().hashCode());
		result = 37 * result + (getSouOpeMatricule() == null ? 0 : this.getSouOpeMatricule().hashCode());
		return result;
	}

}
