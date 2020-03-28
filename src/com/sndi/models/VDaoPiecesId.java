package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDaoPiecesId generated by hbm2java
 */
@Embeddable
public class VDaoPiecesId implements java.io.Serializable {

	private BigDecimal VId;
	private String dacCode;
	private String mdtCode;
	private String mdtLibelleCourt;
	private String mdtLibelleLong;

	public VDaoPiecesId() {
	}

	public VDaoPiecesId(String dacCode, String mdtCode) {
		this.dacCode = dacCode;
		this.mdtCode = mdtCode;
	}

	public VDaoPiecesId(BigDecimal VId, String dacCode, String mdtCode, String mdtLibelleCourt, String mdtLibelleLong) {
		this.VId = VId;
		this.dacCode = dacCode;
		this.mdtCode = mdtCode;
		this.mdtLibelleCourt = mdtLibelleCourt;
		this.mdtLibelleLong = mdtLibelleLong;
	}

	@Column(name = "V_ID", precision = 22, scale = 0)
	public BigDecimal getVId() {
		return this.VId;
	}

	public void setVId(BigDecimal VId) {
		this.VId = VId;
	}

	@Column(name = "DAC_CODE", nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	@Column(name = "MDT_CODE", nullable = false, length = 15)
	public String getMdtCode() {
		return this.mdtCode;
	}

	public void setMdtCode(String mdtCode) {
		this.mdtCode = mdtCode;
	}

	@Column(name = "MDT_LIBELLE_COURT", length = 500)
	public String getMdtLibelleCourt() {
		return this.mdtLibelleCourt;
	}

	public void setMdtLibelleCourt(String mdtLibelleCourt) {
		this.mdtLibelleCourt = mdtLibelleCourt;
	}

	@Column(name = "MDT_LIBELLE_LONG", length = 500)
	public String getMdtLibelleLong() {
		return this.mdtLibelleLong;
	}

	public void setMdtLibelleLong(String mdtLibelleLong) {
		this.mdtLibelleLong = mdtLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDaoPiecesId))
			return false;
		VDaoPiecesId castOther = (VDaoPiecesId) other;

		return ((this.getVId() == castOther.getVId())
				|| (this.getVId() != null && castOther.getVId() != null && this.getVId().equals(castOther.getVId())))
				&& ((this.getDacCode() == castOther.getDacCode()) || (this.getDacCode() != null
						&& castOther.getDacCode() != null && this.getDacCode().equals(castOther.getDacCode())))
				&& ((this.getMdtCode() == castOther.getMdtCode()) || (this.getMdtCode() != null
						&& castOther.getMdtCode() != null && this.getMdtCode().equals(castOther.getMdtCode())))
				&& ((this.getMdtLibelleCourt() == castOther.getMdtLibelleCourt())
						|| (this.getMdtLibelleCourt() != null && castOther.getMdtLibelleCourt() != null
								&& this.getMdtLibelleCourt().equals(castOther.getMdtLibelleCourt())))
				&& ((this.getMdtLibelleLong() == castOther.getMdtLibelleLong())
						|| (this.getMdtLibelleLong() != null && castOther.getMdtLibelleLong() != null
								&& this.getMdtLibelleLong().equals(castOther.getMdtLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getVId() == null ? 0 : this.getVId().hashCode());
		result = 37 * result + (getDacCode() == null ? 0 : this.getDacCode().hashCode());
		result = 37 * result + (getMdtCode() == null ? 0 : this.getMdtCode().hashCode());
		result = 37 * result + (getMdtLibelleCourt() == null ? 0 : this.getMdtLibelleCourt().hashCode());
		result = 37 * result + (getMdtLibelleLong() == null ? 0 : this.getMdtLibelleLong().hashCode());
		return result;
	}

}
