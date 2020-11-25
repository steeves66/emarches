package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypeSeanceId generated by hbm2java
 */
@Embeddable
public class VbTypeSeanceId implements java.io.Serializable {

	private String tseCode;
	private String tseLibelle;
	private Date tseDteSaisi;
	private String tseFonCode;
	private String tseOpeMatricule;

	public VbTypeSeanceId() {
	}

	public VbTypeSeanceId(String tseCode) {
		this.tseCode = tseCode;
	}

	public VbTypeSeanceId(String tseCode, String tseLibelle, Date tseDteSaisi, String tseFonCode,
			String tseOpeMatricule) {
		this.tseCode = tseCode;
		this.tseLibelle = tseLibelle;
		this.tseDteSaisi = tseDteSaisi;
		this.tseFonCode = tseFonCode;
		this.tseOpeMatricule = tseOpeMatricule;
	}

	@Column(name = "TSE_CODE", nullable = false, length = 3)
	public String getTseCode() {
		return this.tseCode;
	}

	public void setTseCode(String tseCode) {
		this.tseCode = tseCode;
	}

	@Column(name = "TSE_LIBELLE", length = 500)
	public String getTseLibelle() {
		return this.tseLibelle;
	}

	public void setTseLibelle(String tseLibelle) {
		this.tseLibelle = tseLibelle;
	}

	@Column(name = "TSE_DTE_SAISI", length = 7)
	public Date getTseDteSaisi() {
		return this.tseDteSaisi;
	}

	public void setTseDteSaisi(Date tseDteSaisi) {
		this.tseDteSaisi = tseDteSaisi;
	}

	@Column(name = "TSE_FON_CODE", length = 12)
	public String getTseFonCode() {
		return this.tseFonCode;
	}

	public void setTseFonCode(String tseFonCode) {
		this.tseFonCode = tseFonCode;
	}

	@Column(name = "TSE_OPE_MATRICULE", length = 25)
	public String getTseOpeMatricule() {
		return this.tseOpeMatricule;
	}

	public void setTseOpeMatricule(String tseOpeMatricule) {
		this.tseOpeMatricule = tseOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypeSeanceId))
			return false;
		VbTypeSeanceId castOther = (VbTypeSeanceId) other;

		return ((this.getTseCode() == castOther.getTseCode()) || (this.getTseCode() != null
				&& castOther.getTseCode() != null && this.getTseCode().equals(castOther.getTseCode())))
				&& ((this.getTseLibelle() == castOther.getTseLibelle()) || (this.getTseLibelle() != null
						&& castOther.getTseLibelle() != null && this.getTseLibelle().equals(castOther.getTseLibelle())))
				&& ((this.getTseDteSaisi() == castOther.getTseDteSaisi())
						|| (this.getTseDteSaisi() != null && castOther.getTseDteSaisi() != null
								&& this.getTseDteSaisi().equals(castOther.getTseDteSaisi())))
				&& ((this.getTseFonCode() == castOther.getTseFonCode()) || (this.getTseFonCode() != null
						&& castOther.getTseFonCode() != null && this.getTseFonCode().equals(castOther.getTseFonCode())))
				&& ((this.getTseOpeMatricule() == castOther.getTseOpeMatricule())
						|| (this.getTseOpeMatricule() != null && castOther.getTseOpeMatricule() != null
								&& this.getTseOpeMatricule().equals(castOther.getTseOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTseCode() == null ? 0 : this.getTseCode().hashCode());
		result = 37 * result + (getTseLibelle() == null ? 0 : this.getTseLibelle().hashCode());
		result = 37 * result + (getTseDteSaisi() == null ? 0 : this.getTseDteSaisi().hashCode());
		result = 37 * result + (getTseFonCode() == null ? 0 : this.getTseFonCode().hashCode());
		result = 37 * result + (getTseOpeMatricule() == null ? 0 : this.getTseOpeMatricule().hashCode());
		return result;
	}

}
