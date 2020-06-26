package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypeCommissionId generated by hbm2java
 */
@Embeddable
public class VbTypeCommissionId implements java.io.Serializable {

	private String tcoCode;
	private String tcoLibelle;
	private Date tcoDteSaisi;
	private String tcoOpeMatricule;

	public VbTypeCommissionId() {
	}

	public VbTypeCommissionId(String tcoCode) {
		this.tcoCode = tcoCode;
	}

	public VbTypeCommissionId(String tcoCode, String tcoLibelle, Date tcoDteSaisi, String tcoOpeMatricule) {
		this.tcoCode = tcoCode;
		this.tcoLibelle = tcoLibelle;
		this.tcoDteSaisi = tcoDteSaisi;
		this.tcoOpeMatricule = tcoOpeMatricule;
	}

	@Column(name = "TCO_CODE", nullable = false, length = 3)
	public String getTcoCode() {
		return this.tcoCode;
	}

	public void setTcoCode(String tcoCode) {
		this.tcoCode = tcoCode;
	}

	@Column(name = "TCO_LIBELLE", length = 500)
	public String getTcoLibelle() {
		return this.tcoLibelle;
	}

	public void setTcoLibelle(String tcoLibelle) {
		this.tcoLibelle = tcoLibelle;
	}

	@Column(name = "TCO_DTE_SAISI", length = 7)
	public Date getTcoDteSaisi() {
		return this.tcoDteSaisi;
	}

	public void setTcoDteSaisi(Date tcoDteSaisi) {
		this.tcoDteSaisi = tcoDteSaisi;
	}

	@Column(name = "TCO_OPE_MATRICULE", length = 20)
	public String getTcoOpeMatricule() {
		return this.tcoOpeMatricule;
	}

	public void setTcoOpeMatricule(String tcoOpeMatricule) {
		this.tcoOpeMatricule = tcoOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypeCommissionId))
			return false;
		VbTypeCommissionId castOther = (VbTypeCommissionId) other;

		return ((this.getTcoCode() == castOther.getTcoCode()) || (this.getTcoCode() != null
				&& castOther.getTcoCode() != null && this.getTcoCode().equals(castOther.getTcoCode())))
				&& ((this.getTcoLibelle() == castOther.getTcoLibelle()) || (this.getTcoLibelle() != null
						&& castOther.getTcoLibelle() != null && this.getTcoLibelle().equals(castOther.getTcoLibelle())))
				&& ((this.getTcoDteSaisi() == castOther.getTcoDteSaisi())
						|| (this.getTcoDteSaisi() != null && castOther.getTcoDteSaisi() != null
								&& this.getTcoDteSaisi().equals(castOther.getTcoDteSaisi())))
				&& ((this.getTcoOpeMatricule() == castOther.getTcoOpeMatricule())
						|| (this.getTcoOpeMatricule() != null && castOther.getTcoOpeMatricule() != null
								&& this.getTcoOpeMatricule().equals(castOther.getTcoOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTcoCode() == null ? 0 : this.getTcoCode().hashCode());
		result = 37 * result + (getTcoLibelle() == null ? 0 : this.getTcoLibelle().hashCode());
		result = 37 * result + (getTcoDteSaisi() == null ? 0 : this.getTcoDteSaisi().hashCode());
		result = 37 * result + (getTcoOpeMatricule() == null ? 0 : this.getTcoOpeMatricule().hashCode());
		return result;
	}

}