package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDestinationsId generated by hbm2java
 */
@Embeddable
public class VbDestinationsId implements java.io.Serializable {

	private String desCode;
	private String desAdr;
	private String desLib;
	private String desOpeMatricule;
	private String desOpeModif;
	private Date desDteModif;
	private Date desDteSaisi;
	private String desRegCode;

	public VbDestinationsId() {
	}

	public VbDestinationsId(String desCode, String desLib) {
		this.desCode = desCode;
		this.desLib = desLib;
	}

	public VbDestinationsId(String desCode, String desAdr, String desLib, String desOpeMatricule, String desOpeModif,
			Date desDteModif, Date desDteSaisi, String desRegCode) {
		this.desCode = desCode;
		this.desAdr = desAdr;
		this.desLib = desLib;
		this.desOpeMatricule = desOpeMatricule;
		this.desOpeModif = desOpeModif;
		this.desDteModif = desDteModif;
		this.desDteSaisi = desDteSaisi;
		this.desRegCode = desRegCode;
	}

	@Column(name = "DES_CODE", nullable = false, length = 20)
	public String getDesCode() {
		return this.desCode;
	}

	public void setDesCode(String desCode) {
		this.desCode = desCode;
	}

	@Column(name = "DES_ADR", length = 200)
	public String getDesAdr() {
		return this.desAdr;
	}

	public void setDesAdr(String desAdr) {
		this.desAdr = desAdr;
	}

	@Column(name = "DES_LIB", nullable = false, length = 500)
	public String getDesLib() {
		return this.desLib;
	}

	public void setDesLib(String desLib) {
		this.desLib = desLib;
	}

	@Column(name = "DES_OPE_MATRICULE", length = 25)
	public String getDesOpeMatricule() {
		return this.desOpeMatricule;
	}

	public void setDesOpeMatricule(String desOpeMatricule) {
		this.desOpeMatricule = desOpeMatricule;
	}

	@Column(name = "DES_OPE_MODIF", length = 25)
	public String getDesOpeModif() {
		return this.desOpeModif;
	}

	public void setDesOpeModif(String desOpeModif) {
		this.desOpeModif = desOpeModif;
	}

	@Column(name = "DES_DTE_MODIF", length = 7)
	public Date getDesDteModif() {
		return this.desDteModif;
	}

	public void setDesDteModif(Date desDteModif) {
		this.desDteModif = desDteModif;
	}

	@Column(name = "DES_DTE_SAISI", length = 7)
	public Date getDesDteSaisi() {
		return this.desDteSaisi;
	}

	public void setDesDteSaisi(Date desDteSaisi) {
		this.desDteSaisi = desDteSaisi;
	}

	@Column(name = "DES_REG_CODE", length = 2)
	public String getDesRegCode() {
		return this.desRegCode;
	}

	public void setDesRegCode(String desRegCode) {
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
				&& ((this.getDesOpeMatricule() == castOther.getDesOpeMatricule())
						|| (this.getDesOpeMatricule() != null && castOther.getDesOpeMatricule() != null
								&& this.getDesOpeMatricule().equals(castOther.getDesOpeMatricule())))
				&& ((this.getDesOpeModif() == castOther.getDesOpeModif())
						|| (this.getDesOpeModif() != null && castOther.getDesOpeModif() != null
								&& this.getDesOpeModif().equals(castOther.getDesOpeModif())))
				&& ((this.getDesDteModif() == castOther.getDesDteModif())
						|| (this.getDesDteModif() != null && castOther.getDesDteModif() != null
								&& this.getDesDteModif().equals(castOther.getDesDteModif())))
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
		result = 37 * result + (getDesOpeMatricule() == null ? 0 : this.getDesOpeMatricule().hashCode());
		result = 37 * result + (getDesOpeModif() == null ? 0 : this.getDesOpeModif().hashCode());
		result = 37 * result + (getDesDteModif() == null ? 0 : this.getDesDteModif().hashCode());
		result = 37 * result + (getDesDteSaisi() == null ? 0 : this.getDesDteSaisi().hashCode());
		result = 37 * result + (getDesRegCode() == null ? 0 : this.getDesRegCode().hashCode());
		return result;
	}

}
