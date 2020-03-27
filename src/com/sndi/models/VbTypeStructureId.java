package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypeStructureId generated by hbm2java
 */
@Embeddable
public class VbTypeStructureId implements java.io.Serializable {

	private String tstCode;
	private String tstLibelle;
	private Date tstDteSaisi;
	private String tstOpeMatricule;

	public VbTypeStructureId() {
	}

	public VbTypeStructureId(String tstCode) {
		this.tstCode = tstCode;
	}

	public VbTypeStructureId(String tstCode, String tstLibelle, Date tstDteSaisi, String tstOpeMatricule) {
		this.tstCode = tstCode;
		this.tstLibelle = tstLibelle;
		this.tstDteSaisi = tstDteSaisi;
		this.tstOpeMatricule = tstOpeMatricule;
	}

	@Column(name = "TST_CODE", nullable = false, length = 3)
	public String getTstCode() {
		return this.tstCode;
	}

	public void setTstCode(String tstCode) {
		this.tstCode = tstCode;
	}

	@Column(name = "TST_LIBELLE", length = 500)
	public String getTstLibelle() {
		return this.tstLibelle;
	}

	public void setTstLibelle(String tstLibelle) {
		this.tstLibelle = tstLibelle;
	}

	@Column(name = "TST_DTE_SAISI", length = 7)
	public Date getTstDteSaisi() {
		return this.tstDteSaisi;
	}

	public void setTstDteSaisi(Date tstDteSaisi) {
		this.tstDteSaisi = tstDteSaisi;
	}

	@Column(name = "TST_OPE_MATRICULE", length = 20)
	public String getTstOpeMatricule() {
		return this.tstOpeMatricule;
	}

	public void setTstOpeMatricule(String tstOpeMatricule) {
		this.tstOpeMatricule = tstOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypeStructureId))
			return false;
		VbTypeStructureId castOther = (VbTypeStructureId) other;

		return ((this.getTstCode() == castOther.getTstCode()) || (this.getTstCode() != null
				&& castOther.getTstCode() != null && this.getTstCode().equals(castOther.getTstCode())))
				&& ((this.getTstLibelle() == castOther.getTstLibelle()) || (this.getTstLibelle() != null
						&& castOther.getTstLibelle() != null && this.getTstLibelle().equals(castOther.getTstLibelle())))
				&& ((this.getTstDteSaisi() == castOther.getTstDteSaisi())
						|| (this.getTstDteSaisi() != null && castOther.getTstDteSaisi() != null
								&& this.getTstDteSaisi().equals(castOther.getTstDteSaisi())))
				&& ((this.getTstOpeMatricule() == castOther.getTstOpeMatricule())
						|| (this.getTstOpeMatricule() != null && castOther.getTstOpeMatricule() != null
								&& this.getTstOpeMatricule().equals(castOther.getTstOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTstCode() == null ? 0 : this.getTstCode().hashCode());
		result = 37 * result + (getTstLibelle() == null ? 0 : this.getTstLibelle().hashCode());
		result = 37 * result + (getTstDteSaisi() == null ? 0 : this.getTstDteSaisi().hashCode());
		result = 37 * result + (getTstOpeMatricule() == null ? 0 : this.getTstOpeMatricule().hashCode());
		return result;
	}

}
