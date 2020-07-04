package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TGestionId generated by hbm2java
 */
@Embeddable
public class TGestionId implements java.io.Serializable {

	private short gesCode;
	private Date gesDateDebut;
	private Date gesDateFin;

	public TGestionId() {
	}

	public TGestionId(short gesCode) {
		this.gesCode = gesCode;
	}

	public TGestionId(short gesCode, Date gesDateDebut, Date gesDateFin) {
		this.gesCode = gesCode;
		this.gesDateDebut = gesDateDebut;
		this.gesDateFin = gesDateFin;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TGestionId))
			return false;
		TGestionId castOther = (TGestionId) other;

		return (this.getGesCode() == castOther.getGesCode())
				&& ((this.getGesDateDebut() == castOther.getGesDateDebut())
						|| (this.getGesDateDebut() != null && castOther.getGesDateDebut() != null
								&& this.getGesDateDebut().equals(castOther.getGesDateDebut())))
				&& ((this.getGesDateFin() == castOther.getGesDateFin())
						|| (this.getGesDateFin() != null && castOther.getGesDateFin() != null
								&& this.getGesDateFin().equals(castOther.getGesDateFin())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getGesCode();
		result = 37 * result + (getGesDateDebut() == null ? 0 : this.getGesDateDebut().hashCode());
		result = 37 * result + (getGesDateFin() == null ? 0 : this.getGesDateFin().hashCode());
		return result;
	}

}
