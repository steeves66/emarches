package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDestinationsId generated by hbm2java
 */
@Embeddable
public class VbDestinationsId implements java.io.Serializable {

	private Serializable desCode;
	private Serializable desAdr;
	private Serializable desLib;
	private Serializable desUtilSaisi;
	private Serializable desUtilModif;
	private Serializable desDdteModif;
	private Serializable desDteSaisi;
	private Serializable desRegCode;

	public VbDestinationsId() {
	}

	public VbDestinationsId(Serializable desCode, Serializable desAdr, Serializable desLib, Serializable desUtilSaisi,
			Serializable desUtilModif, Serializable desDdteModif, Serializable desDteSaisi, Serializable desRegCode) {
		this.desCode = desCode;
		this.desAdr = desAdr;
		this.desLib = desLib;
		this.desUtilSaisi = desUtilSaisi;
		this.desUtilModif = desUtilModif;
		this.desDdteModif = desDdteModif;
		this.desDteSaisi = desDteSaisi;
		this.desRegCode = desRegCode;
	}

	@Column(name = "DES_CODE")
	public Serializable getDesCode() {
		return this.desCode;
	}

	public void setDesCode(Serializable desCode) {
		this.desCode = desCode;
	}

	@Column(name = "DES_ADR")
	public Serializable getDesAdr() {
		return this.desAdr;
	}

	public void setDesAdr(Serializable desAdr) {
		this.desAdr = desAdr;
	}

	@Column(name = "DES_LIB")
	public Serializable getDesLib() {
		return this.desLib;
	}

	public void setDesLib(Serializable desLib) {
		this.desLib = desLib;
	}

	@Column(name = "DES_UTIL_SAISI")
	public Serializable getDesUtilSaisi() {
		return this.desUtilSaisi;
	}

	public void setDesUtilSaisi(Serializable desUtilSaisi) {
		this.desUtilSaisi = desUtilSaisi;
	}

	@Column(name = "DES_UTIL_MODIF")
	public Serializable getDesUtilModif() {
		return this.desUtilModif;
	}

	public void setDesUtilModif(Serializable desUtilModif) {
		this.desUtilModif = desUtilModif;
	}

	@Column(name = "DES_DDTE_MODIF")
	public Serializable getDesDdteModif() {
		return this.desDdteModif;
	}

	public void setDesDdteModif(Serializable desDdteModif) {
		this.desDdteModif = desDdteModif;
	}

	@Column(name = "DES_DTE_SAISI")
	public Serializable getDesDteSaisi() {
		return this.desDteSaisi;
	}

	public void setDesDteSaisi(Serializable desDteSaisi) {
		this.desDteSaisi = desDteSaisi;
	}

	@Column(name = "DES_REG_CODE")
	public Serializable getDesRegCode() {
		return this.desRegCode;
	}

	public void setDesRegCode(Serializable desRegCode) {
		this.desRegCode = desRegCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDestinationsId))
			return false;
		VbDestinationsId castOther = (VbDestinationsId) other;

		return ((this.getDesCode() == castOther.getDesCode()) || (this.getDesCode() != null
				&& castOther.getDesCode() != null && this.getDesCode().equals(castOther.getDesCode())))
				&& ((this.getDesAdr() == castOther.getDesAdr()) || (this.getDesAdr() != null
						&& castOther.getDesAdr() != null && this.getDesAdr().equals(castOther.getDesAdr())))
				&& ((this.getDesLib() == castOther.getDesLib()) || (this.getDesLib() != null
						&& castOther.getDesLib() != null && this.getDesLib().equals(castOther.getDesLib())))
				&& ((this.getDesUtilSaisi() == castOther.getDesUtilSaisi())
						|| (this.getDesUtilSaisi() != null && castOther.getDesUtilSaisi() != null
								&& this.getDesUtilSaisi().equals(castOther.getDesUtilSaisi())))
				&& ((this.getDesUtilModif() == castOther.getDesUtilModif())
						|| (this.getDesUtilModif() != null && castOther.getDesUtilModif() != null
								&& this.getDesUtilModif().equals(castOther.getDesUtilModif())))
				&& ((this.getDesDdteModif() == castOther.getDesDdteModif())
						|| (this.getDesDdteModif() != null && castOther.getDesDdteModif() != null
								&& this.getDesDdteModif().equals(castOther.getDesDdteModif())))
				&& ((this.getDesDteSaisi() == castOther.getDesDteSaisi())
						|| (this.getDesDteSaisi() != null && castOther.getDesDteSaisi() != null
								&& this.getDesDteSaisi().equals(castOther.getDesDteSaisi())))
				&& ((this.getDesRegCode() == castOther.getDesRegCode())
						|| (this.getDesRegCode() != null && castOther.getDesRegCode() != null
								&& this.getDesRegCode().equals(castOther.getDesRegCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDesCode() == null ? 0 : this.getDesCode().hashCode());
		result = 37 * result + (getDesAdr() == null ? 0 : this.getDesAdr().hashCode());
		result = 37 * result + (getDesLib() == null ? 0 : this.getDesLib().hashCode());
		result = 37 * result + (getDesUtilSaisi() == null ? 0 : this.getDesUtilSaisi().hashCode());
		result = 37 * result + (getDesUtilModif() == null ? 0 : this.getDesUtilModif().hashCode());
		result = 37 * result + (getDesDdteModif() == null ? 0 : this.getDesDdteModif().hashCode());
		result = 37 * result + (getDesDteSaisi() == null ? 0 : this.getDesDteSaisi().hashCode());
		result = 37 * result + (getDesRegCode() == null ? 0 : this.getDesRegCode().hashCode());
		return result;
	}

}
