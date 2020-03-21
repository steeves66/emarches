package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbAssignationId generated by hbm2java
 */
@Embeddable
public class VbAssignationId implements java.io.Serializable {

	private long assNum;
	private String assFonCod;
	private String assOpeMatricule;
	private Date assDatDeb;
	private Date assDatFin;
	private String assCourant;
	private Boolean assStatut;

	public VbAssignationId() {
	}

	public VbAssignationId(long assNum) {
		this.assNum = assNum;
	}

	public VbAssignationId(long assNum, String assFonCod, String assOpeMatricule, Date assDatDeb, Date assDatFin,
			String assCourant, Boolean assStatut) {
		this.assNum = assNum;
		this.assFonCod = assFonCod;
		this.assOpeMatricule = assOpeMatricule;
		this.assDatDeb = assDatDeb;
		this.assDatFin = assDatFin;
		this.assCourant = assCourant;
		this.assStatut = assStatut;
	}

	@Column(name = "ASS_NUM", nullable = false, precision = 10, scale = 0)
	public long getAssNum() {
		return this.assNum;
	}

	public void setAssNum(long assNum) {
		this.assNum = assNum;
	}

	@Column(name = "ASS_FON_COD", length = 12)
	public String getAssFonCod() {
		return this.assFonCod;
	}

	public void setAssFonCod(String assFonCod) {
		this.assFonCod = assFonCod;
	}

	@Column(name = "ASS_OPE_MATRICULE", length = 25)
	public String getAssOpeMatricule() {
		return this.assOpeMatricule;
	}

	public void setAssOpeMatricule(String assOpeMatricule) {
		this.assOpeMatricule = assOpeMatricule;
	}

	@Column(name = "ASS_DAT_DEB", length = 7)
	public Date getAssDatDeb() {
		return this.assDatDeb;
	}

	public void setAssDatDeb(Date assDatDeb) {
		this.assDatDeb = assDatDeb;
	}

	@Column(name = "ASS_DAT_FIN", length = 7)
	public Date getAssDatFin() {
		return this.assDatFin;
	}

	public void setAssDatFin(Date assDatFin) {
		this.assDatFin = assDatFin;
	}

	@Column(name = "ASS_COURANT", length = 10)
	public String getAssCourant() {
		return this.assCourant;
	}

	public void setAssCourant(String assCourant) {
		this.assCourant = assCourant;
	}

	@Column(name = "ASS_STATUT", precision = 1, scale = 0)
	public Boolean getAssStatut() {
		return this.assStatut;
	}

	public void setAssStatut(Boolean assStatut) {
		this.assStatut = assStatut;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbAssignationId))
			return false;
		VbAssignationId castOther = (VbAssignationId) other;

		return (this.getAssNum() == castOther.getAssNum())
				&& ((this.getAssFonCod() == castOther.getAssFonCod()) || (this.getAssFonCod() != null
						&& castOther.getAssFonCod() != null && this.getAssFonCod().equals(castOther.getAssFonCod())))
				&& ((this.getAssOpeMatricule() == castOther.getAssOpeMatricule())
						|| (this.getAssOpeMatricule() != null && castOther.getAssOpeMatricule() != null
								&& this.getAssOpeMatricule().equals(castOther.getAssOpeMatricule())))
				&& ((this.getAssDatDeb() == castOther.getAssDatDeb()) || (this.getAssDatDeb() != null
						&& castOther.getAssDatDeb() != null && this.getAssDatDeb().equals(castOther.getAssDatDeb())))
				&& ((this.getAssDatFin() == castOther.getAssDatFin()) || (this.getAssDatFin() != null
						&& castOther.getAssDatFin() != null && this.getAssDatFin().equals(castOther.getAssDatFin())))
				&& ((this.getAssCourant() == castOther.getAssCourant()) || (this.getAssCourant() != null
						&& castOther.getAssCourant() != null && this.getAssCourant().equals(castOther.getAssCourant())))
				&& ((this.getAssStatut() == castOther.getAssStatut()) || (this.getAssStatut() != null
						&& castOther.getAssStatut() != null && this.getAssStatut().equals(castOther.getAssStatut())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAssNum();
		result = 37 * result + (getAssFonCod() == null ? 0 : this.getAssFonCod().hashCode());
		result = 37 * result + (getAssOpeMatricule() == null ? 0 : this.getAssOpeMatricule().hashCode());
		result = 37 * result + (getAssDatDeb() == null ? 0 : this.getAssDatDeb().hashCode());
		result = 37 * result + (getAssDatFin() == null ? 0 : this.getAssDatFin().hashCode());
		result = 37 * result + (getAssCourant() == null ? 0 : this.getAssCourant().hashCode());
		result = 37 * result + (getAssStatut() == null ? 0 : this.getAssStatut().hashCode());
		return result;
	}

}
