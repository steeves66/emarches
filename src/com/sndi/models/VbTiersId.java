package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTiersId generated by hbm2java
 */
@Embeddable
public class VbTiersId implements java.io.Serializable {

	private String tieNum;
	private String tieInter;
	private String tieSigleSte;
	private String tieNomCom;
	private String tieStaCode;
	private String tieTel;
	private String tieAdresse;
	private Date tieDteSaisi;
	private String tieOpeMatricule;

	public VbTiersId() {
	}

	public VbTiersId(String tieNum) {
		this.tieNum = tieNum;
	}

	public VbTiersId(String tieNum, String tieInter, String tieSigleSte, String tieNomCom, String tieStaCode,
			String tieTel, String tieAdresse, Date tieDteSaisi, String tieOpeMatricule) {
		this.tieNum = tieNum;
		this.tieInter = tieInter;
		this.tieSigleSte = tieSigleSte;
		this.tieNomCom = tieNomCom;
		this.tieStaCode = tieStaCode;
		this.tieTel = tieTel;
		this.tieAdresse = tieAdresse;
		this.tieDteSaisi = tieDteSaisi;
		this.tieOpeMatricule = tieOpeMatricule;
	}

	@Column(name = "TIE_NUM", nullable = false, length = 20)
	public String getTieNum() {
		return this.tieNum;
	}

	public void setTieNum(String tieNum) {
		this.tieNum = tieNum;
	}

	@Column(name = "TIE_INTER", length = 1)
	public String getTieInter() {
		return this.tieInter;
	}

	public void setTieInter(String tieInter) {
		this.tieInter = tieInter;
	}

	@Column(name = "TIE_SIGLE_STE", length = 500)
	public String getTieSigleSte() {
		return this.tieSigleSte;
	}

	public void setTieSigleSte(String tieSigleSte) {
		this.tieSigleSte = tieSigleSte;
	}

	@Column(name = "TIE_NOM_COM", length = 500)
	public String getTieNomCom() {
		return this.tieNomCom;
	}

	public void setTieNomCom(String tieNomCom) {
		this.tieNomCom = tieNomCom;
	}

	@Column(name = "TIE_STA_CODE", length = 3)
	public String getTieStaCode() {
		return this.tieStaCode;
	}

	public void setTieStaCode(String tieStaCode) {
		this.tieStaCode = tieStaCode;
	}

	@Column(name = "TIE_TEL", length = 30)
	public String getTieTel() {
		return this.tieTel;
	}

	public void setTieTel(String tieTel) {
		this.tieTel = tieTel;
	}

	@Column(name = "TIE_ADRESSE", length = 200)
	public String getTieAdresse() {
		return this.tieAdresse;
	}

	public void setTieAdresse(String tieAdresse) {
		this.tieAdresse = tieAdresse;
	}

	@Column(name = "TIE_DTE_SAISI", length = 7)
	public Date getTieDteSaisi() {
		return this.tieDteSaisi;
	}

	public void setTieDteSaisi(Date tieDteSaisi) {
		this.tieDteSaisi = tieDteSaisi;
	}

	@Column(name = "TIE_OPE_MATRICULE", length = 25)
	public String getTieOpeMatricule() {
		return this.tieOpeMatricule;
	}

	public void setTieOpeMatricule(String tieOpeMatricule) {
		this.tieOpeMatricule = tieOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTiersId))
			return false;
		VbTiersId castOther = (VbTiersId) other;

		return ((this.getTieNum() == castOther.getTieNum()) || (this.getTieNum() != null
				&& castOther.getTieNum() != null && this.getTieNum().equals(castOther.getTieNum())))
				&& ((this.getTieInter() == castOther.getTieInter()) || (this.getTieInter() != null
						&& castOther.getTieInter() != null && this.getTieInter().equals(castOther.getTieInter())))
				&& ((this.getTieSigleSte() == castOther.getTieSigleSte())
						|| (this.getTieSigleSte() != null && castOther.getTieSigleSte() != null
								&& this.getTieSigleSte().equals(castOther.getTieSigleSte())))
				&& ((this.getTieNomCom() == castOther.getTieNomCom()) || (this.getTieNomCom() != null
						&& castOther.getTieNomCom() != null && this.getTieNomCom().equals(castOther.getTieNomCom())))
				&& ((this.getTieStaCode() == castOther.getTieStaCode()) || (this.getTieStaCode() != null
						&& castOther.getTieStaCode() != null && this.getTieStaCode().equals(castOther.getTieStaCode())))
				&& ((this.getTieTel() == castOther.getTieTel()) || (this.getTieTel() != null
						&& castOther.getTieTel() != null && this.getTieTel().equals(castOther.getTieTel())))
				&& ((this.getTieAdresse() == castOther.getTieAdresse()) || (this.getTieAdresse() != null
						&& castOther.getTieAdresse() != null && this.getTieAdresse().equals(castOther.getTieAdresse())))
				&& ((this.getTieDteSaisi() == castOther.getTieDteSaisi())
						|| (this.getTieDteSaisi() != null && castOther.getTieDteSaisi() != null
								&& this.getTieDteSaisi().equals(castOther.getTieDteSaisi())))
				&& ((this.getTieOpeMatricule() == castOther.getTieOpeMatricule())
						|| (this.getTieOpeMatricule() != null && castOther.getTieOpeMatricule() != null
								&& this.getTieOpeMatricule().equals(castOther.getTieOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTieNum() == null ? 0 : this.getTieNum().hashCode());
		result = 37 * result + (getTieInter() == null ? 0 : this.getTieInter().hashCode());
		result = 37 * result + (getTieSigleSte() == null ? 0 : this.getTieSigleSte().hashCode());
		result = 37 * result + (getTieNomCom() == null ? 0 : this.getTieNomCom().hashCode());
		result = 37 * result + (getTieStaCode() == null ? 0 : this.getTieStaCode().hashCode());
		result = 37 * result + (getTieTel() == null ? 0 : this.getTieTel().hashCode());
		result = 37 * result + (getTieAdresse() == null ? 0 : this.getTieAdresse().hashCode());
		result = 37 * result + (getTieDteSaisi() == null ? 0 : this.getTieDteSaisi().hashCode());
		result = 37 * result + (getTieOpeMatricule() == null ? 0 : this.getTieOpeMatricule().hashCode());
		return result;
	}

}
