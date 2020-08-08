package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbModeleDacTypeId generated by hbm2java
 */
@Embeddable
public class VbModeleDacTypeId implements java.io.Serializable {

	private String mdtCode;
	private String mdtLibelleLong;
	private String mdtLibelleCourt;
	private Date mdtDteSaisi;
	private String mdtOpeMatricule;
	private String mdtTymCode;
	private String mdtDacTypeChain;

	public VbModeleDacTypeId() {
	}

	public VbModeleDacTypeId(String mdtCode) {
		this.mdtCode = mdtCode;
	}

	public VbModeleDacTypeId(String mdtCode, String mdtLibelleLong, String mdtLibelleCourt, Date mdtDteSaisi,
			String mdtOpeMatricule, String mdtTymCode, String mdtDacTypeChain) {
		this.mdtCode = mdtCode;
		this.mdtLibelleLong = mdtLibelleLong;
		this.mdtLibelleCourt = mdtLibelleCourt;
		this.mdtDteSaisi = mdtDteSaisi;
		this.mdtOpeMatricule = mdtOpeMatricule;
		this.mdtTymCode = mdtTymCode;
		this.mdtDacTypeChain = mdtDacTypeChain;
	}

	@Column(name = "MDT_CODE", nullable = false, length = 15)
	public String getMdtCode() {
		return this.mdtCode;
	}

	public void setMdtCode(String mdtCode) {
		this.mdtCode = mdtCode;
	}

	@Column(name = "MDT_LIBELLE_LONG", length = 500)
	public String getMdtLibelleLong() {
		return this.mdtLibelleLong;
	}

	public void setMdtLibelleLong(String mdtLibelleLong) {
		this.mdtLibelleLong = mdtLibelleLong;
	}

	@Column(name = "MDT_LIBELLE_COURT", length = 500)
	public String getMdtLibelleCourt() {
		return this.mdtLibelleCourt;
	}

	public void setMdtLibelleCourt(String mdtLibelleCourt) {
		this.mdtLibelleCourt = mdtLibelleCourt;
	}

	@Column(name = "MDT_DTE_SAISI", length = 7)
	public Date getMdtDteSaisi() {
		return this.mdtDteSaisi;
	}

	public void setMdtDteSaisi(Date mdtDteSaisi) {
		this.mdtDteSaisi = mdtDteSaisi;
	}

	@Column(name = "MDT_OPE_MATRICULE", length = 25)
	public String getMdtOpeMatricule() {
		return this.mdtOpeMatricule;
	}

	public void setMdtOpeMatricule(String mdtOpeMatricule) {
		this.mdtOpeMatricule = mdtOpeMatricule;
	}

	@Column(name = "MDT_TYM_CODE", length = 3)
	public String getMdtTymCode() {
		return this.mdtTymCode;
	}

	public void setMdtTymCode(String mdtTymCode) {
		this.mdtTymCode = mdtTymCode;
	}

	@Column(name = "MDT_DAC_TYPE_CHAIN", length = 100)
	public String getMdtDacTypeChain() {
		return this.mdtDacTypeChain;
	}

	public void setMdtDacTypeChain(String mdtDacTypeChain) {
		this.mdtDacTypeChain = mdtDacTypeChain;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbModeleDacTypeId))
			return false;
		VbModeleDacTypeId castOther = (VbModeleDacTypeId) other;

		return ((this.getMdtCode() == castOther.getMdtCode()) || (this.getMdtCode() != null
				&& castOther.getMdtCode() != null && this.getMdtCode().equals(castOther.getMdtCode())))
				&& ((this.getMdtLibelleLong() == castOther.getMdtLibelleLong())
						|| (this.getMdtLibelleLong() != null && castOther.getMdtLibelleLong() != null
								&& this.getMdtLibelleLong().equals(castOther.getMdtLibelleLong())))
				&& ((this.getMdtLibelleCourt() == castOther.getMdtLibelleCourt())
						|| (this.getMdtLibelleCourt() != null && castOther.getMdtLibelleCourt() != null
								&& this.getMdtLibelleCourt().equals(castOther.getMdtLibelleCourt())))
				&& ((this.getMdtDteSaisi() == castOther.getMdtDteSaisi())
						|| (this.getMdtDteSaisi() != null && castOther.getMdtDteSaisi() != null
								&& this.getMdtDteSaisi().equals(castOther.getMdtDteSaisi())))
				&& ((this.getMdtOpeMatricule() == castOther.getMdtOpeMatricule())
						|| (this.getMdtOpeMatricule() != null && castOther.getMdtOpeMatricule() != null
								&& this.getMdtOpeMatricule().equals(castOther.getMdtOpeMatricule())))
				&& ((this.getMdtTymCode() == castOther.getMdtTymCode()) || (this.getMdtTymCode() != null
						&& castOther.getMdtTymCode() != null && this.getMdtTymCode().equals(castOther.getMdtTymCode())))
				&& ((this.getMdtDacTypeChain() == castOther.getMdtDacTypeChain())
						|| (this.getMdtDacTypeChain() != null && castOther.getMdtDacTypeChain() != null
								&& this.getMdtDacTypeChain().equals(castOther.getMdtDacTypeChain())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMdtCode() == null ? 0 : this.getMdtCode().hashCode());
		result = 37 * result + (getMdtLibelleLong() == null ? 0 : this.getMdtLibelleLong().hashCode());
		result = 37 * result + (getMdtLibelleCourt() == null ? 0 : this.getMdtLibelleCourt().hashCode());
		result = 37 * result + (getMdtDteSaisi() == null ? 0 : this.getMdtDteSaisi().hashCode());
		result = 37 * result + (getMdtOpeMatricule() == null ? 0 : this.getMdtOpeMatricule().hashCode());
		result = 37 * result + (getMdtTymCode() == null ? 0 : this.getMdtTymCode().hashCode());
		result = 37 * result + (getMdtDacTypeChain() == null ? 0 : this.getMdtDacTypeChain().hashCode());
		return result;
	}

}
