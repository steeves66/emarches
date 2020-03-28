package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypeDemandeId generated by hbm2java
 */
@Embeddable
public class VbTypeDemandeId implements java.io.Serializable {

	private String tdmCode;
	private String tdmLibelle;
	private Date tdmDteSaisi;
	private String tdmOpeMatricule;
	private Character tdmProDer;

	public VbTypeDemandeId() {
	}

	public VbTypeDemandeId(String tdmCode) {
		this.tdmCode = tdmCode;
	}

	public VbTypeDemandeId(String tdmCode, String tdmLibelle, Date tdmDteSaisi, String tdmOpeMatricule,
			Character tdmProDer) {
		this.tdmCode = tdmCode;
		this.tdmLibelle = tdmLibelle;
		this.tdmDteSaisi = tdmDteSaisi;
		this.tdmOpeMatricule = tdmOpeMatricule;
		this.tdmProDer = tdmProDer;
	}

	@Column(name = "TDM_CODE", nullable = false, length = 10)
	public String getTdmCode() {
		return this.tdmCode;
	}

	public void setTdmCode(String tdmCode) {
		this.tdmCode = tdmCode;
	}

	@Column(name = "TDM_LIBELLE", length = 500)
	public String getTdmLibelle() {
		return this.tdmLibelle;
	}

	public void setTdmLibelle(String tdmLibelle) {
		this.tdmLibelle = tdmLibelle;
	}

	@Column(name = "TDM_DTE_SAISI", length = 7)
	public Date getTdmDteSaisi() {
		return this.tdmDteSaisi;
	}

	public void setTdmDteSaisi(Date tdmDteSaisi) {
		this.tdmDteSaisi = tdmDteSaisi;
	}

	@Column(name = "TDM_OPE_MATRICULE", length = 25)
	public String getTdmOpeMatricule() {
		return this.tdmOpeMatricule;
	}

	public void setTdmOpeMatricule(String tdmOpeMatricule) {
		this.tdmOpeMatricule = tdmOpeMatricule;
	}

	@Column(name = "TDM_PRO_DER", length = 1)
	public Character getTdmProDer() {
		return this.tdmProDer;
	}

	public void setTdmProDer(Character tdmProDer) {
		this.tdmProDer = tdmProDer;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypeDemandeId))
			return false;
		VbTypeDemandeId castOther = (VbTypeDemandeId) other;

		return ((this.getTdmCode() == castOther.getTdmCode()) || (this.getTdmCode() != null
				&& castOther.getTdmCode() != null && this.getTdmCode().equals(castOther.getTdmCode())))
				&& ((this.getTdmLibelle() == castOther.getTdmLibelle()) || (this.getTdmLibelle() != null
						&& castOther.getTdmLibelle() != null && this.getTdmLibelle().equals(castOther.getTdmLibelle())))
				&& ((this.getTdmDteSaisi() == castOther.getTdmDteSaisi())
						|| (this.getTdmDteSaisi() != null && castOther.getTdmDteSaisi() != null
								&& this.getTdmDteSaisi().equals(castOther.getTdmDteSaisi())))
				&& ((this.getTdmOpeMatricule() == castOther.getTdmOpeMatricule())
						|| (this.getTdmOpeMatricule() != null && castOther.getTdmOpeMatricule() != null
								&& this.getTdmOpeMatricule().equals(castOther.getTdmOpeMatricule())))
				&& ((this.getTdmProDer() == castOther.getTdmProDer()) || (this.getTdmProDer() != null
						&& castOther.getTdmProDer() != null && this.getTdmProDer().equals(castOther.getTdmProDer())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTdmCode() == null ? 0 : this.getTdmCode().hashCode());
		result = 37 * result + (getTdmLibelle() == null ? 0 : this.getTdmLibelle().hashCode());
		result = 37 * result + (getTdmDteSaisi() == null ? 0 : this.getTdmDteSaisi().hashCode());
		result = 37 * result + (getTdmOpeMatricule() == null ? 0 : this.getTdmOpeMatricule().hashCode());
		result = 37 * result + (getTdmProDer() == null ? 0 : this.getTdmProDer().hashCode());
		return result;
	}

}
