package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbGestionsId generated by hbm2java
 */
@Embeddable
public class VbGestionsId implements java.io.Serializable {

	private short gesCode;
	private Date gesDateDebut;
	private Date gesDateFin;
	private String gesCourant;
	private String gesOpeMatricule;
	private Date gesDteSaisi;

	public VbGestionsId() {
	}

	public VbGestionsId(short gesCode) {
		this.gesCode = gesCode;
	}

	public VbGestionsId(short gesCode, Date gesDateDebut, Date gesDateFin, String gesCourant, String gesOpeMatricule,
			Date gesDteSaisi) {
		this.gesCode = gesCode;
		this.gesDateDebut = gesDateDebut;
		this.gesDateFin = gesDateFin;
		this.gesCourant = gesCourant;
		this.gesOpeMatricule = gesOpeMatricule;
		this.gesDteSaisi = gesDteSaisi;
	}

	@Column(name = "GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getGesCode() {
		return this.gesCode;
	}

	public void setGesCode(short gesCode) {
		this.gesCode = gesCode;
	}

	@Column(name = "GES_DATE_DEBUT", length = 7)
	public Date getGesDateDebut() {
		return this.gesDateDebut;
	}

	public void setGesDateDebut(Date gesDateDebut) {
		this.gesDateDebut = gesDateDebut;
	}

	@Column(name = "GES_DATE_FIN", length = 7)
	public Date getGesDateFin() {
		return this.gesDateFin;
	}

	public void setGesDateFin(Date gesDateFin) {
		this.gesDateFin = gesDateFin;
	}

	@Column(name = "GES_COURANT", length = 1)
	public String getGesCourant() {
		return this.gesCourant;
	}

	public void setGesCourant(String gesCourant) {
		this.gesCourant = gesCourant;
	}

	@Column(name = "GES_OPE_MATRICULE", length = 25)
	public String getGesOpeMatricule() {
		return this.gesOpeMatricule;
	}

	public void setGesOpeMatricule(String gesOpeMatricule) {
		this.gesOpeMatricule = gesOpeMatricule;
	}

	@Column(name = "GES_DTE_SAISI", length = 7)
	public Date getGesDteSaisi() {
		return this.gesDteSaisi;
	}

	public void setGesDteSaisi(Date gesDteSaisi) {
		this.gesDteSaisi = gesDteSaisi;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbGestionsId))
			return false;
		VbGestionsId castOther = (VbGestionsId) other;

		return (this.getGesCode() == castOther.getGesCode())
				&& ((this.getGesDateDebut() == castOther.getGesDateDebut())
						|| (this.getGesDateDebut() != null && castOther.getGesDateDebut() != null
								&& this.getGesDateDebut().equals(castOther.getGesDateDebut())))
				&& ((this.getGesDateFin() == castOther.getGesDateFin()) || (this.getGesDateFin() != null
						&& castOther.getGesDateFin() != null && this.getGesDateFin().equals(castOther.getGesDateFin())))
				&& ((this.getGesCourant() == castOther.getGesCourant()) || (this.getGesCourant() != null
						&& castOther.getGesCourant() != null && this.getGesCourant().equals(castOther.getGesCourant())))
				&& ((this.getGesOpeMatricule() == castOther.getGesOpeMatricule())
						|| (this.getGesOpeMatricule() != null && castOther.getGesOpeMatricule() != null
								&& this.getGesOpeMatricule().equals(castOther.getGesOpeMatricule())))
				&& ((this.getGesDteSaisi() == castOther.getGesDteSaisi())
						|| (this.getGesDteSaisi() != null && castOther.getGesDteSaisi() != null
								&& this.getGesDteSaisi().equals(castOther.getGesDteSaisi())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getGesCode();
		result = 37 * result + (getGesDateDebut() == null ? 0 : this.getGesDateDebut().hashCode());
		result = 37 * result + (getGesDateFin() == null ? 0 : this.getGesDateFin().hashCode());
		result = 37 * result + (getGesCourant() == null ? 0 : this.getGesCourant().hashCode());
		result = 37 * result + (getGesOpeMatricule() == null ? 0 : this.getGesOpeMatricule().hashCode());
		result = 37 * result + (getGesDteSaisi() == null ? 0 : this.getGesDteSaisi().hashCode());
		return result;
	}

}
