package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbOffrePieceDacId generated by hbm2java
 */
@Embeddable
public class VbOffrePieceDacId implements java.io.Serializable {

	private BigDecimal opdNum;
	private String opdDacCode;
	private String opdTpoCode;
	private String odpTpoEtapPiece;
	private Date odpDteSaisi;
	private String odpOpeMatricule;

	public VbOffrePieceDacId() {
	}

	public VbOffrePieceDacId(BigDecimal opdNum) {
		this.opdNum = opdNum;
	}

	public VbOffrePieceDacId(BigDecimal opdNum, String opdDacCode, String opdTpoCode, String odpTpoEtapPiece,
			Date odpDteSaisi, String odpOpeMatricule) {
		this.opdNum = opdNum;
		this.opdDacCode = opdDacCode;
		this.opdTpoCode = opdTpoCode;
		this.odpTpoEtapPiece = odpTpoEtapPiece;
		this.odpDteSaisi = odpDteSaisi;
		this.odpOpeMatricule = odpOpeMatricule;
	}

	@Column(name = "OPD_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOpdNum() {
		return this.opdNum;
	}

	public void setOpdNum(BigDecimal opdNum) {
		this.opdNum = opdNum;
	}

	@Column(name = "OPD_DAC_CODE", length = 25)
	public String getOpdDacCode() {
		return this.opdDacCode;
	}

	public void setOpdDacCode(String opdDacCode) {
		this.opdDacCode = opdDacCode;
	}

	@Column(name = "OPD_TPO_CODE", length = 10)
	public String getOpdTpoCode() {
		return this.opdTpoCode;
	}

	public void setOpdTpoCode(String opdTpoCode) {
		this.opdTpoCode = opdTpoCode;
	}

	@Column(name = "ODP_TPO_ETAP_PIECE", length = 20)
	public String getOdpTpoEtapPiece() {
		return this.odpTpoEtapPiece;
	}

	public void setOdpTpoEtapPiece(String odpTpoEtapPiece) {
		this.odpTpoEtapPiece = odpTpoEtapPiece;
	}

	@Column(name = "ODP_DTE_SAISI", length = 7)
	public Date getOdpDteSaisi() {
		return this.odpDteSaisi;
	}

	public void setOdpDteSaisi(Date odpDteSaisi) {
		this.odpDteSaisi = odpDteSaisi;
	}

	@Column(name = "ODP_OPE_MATRICULE", length = 25)
	public String getOdpOpeMatricule() {
		return this.odpOpeMatricule;
	}

	public void setOdpOpeMatricule(String odpOpeMatricule) {
		this.odpOpeMatricule = odpOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbOffrePieceDacId))
			return false;
		VbOffrePieceDacId castOther = (VbOffrePieceDacId) other;

		return ((this.getOpdNum() == castOther.getOpdNum()) || (this.getOpdNum() != null
				&& castOther.getOpdNum() != null && this.getOpdNum().equals(castOther.getOpdNum())))
				&& ((this.getOpdDacCode() == castOther.getOpdDacCode()) || (this.getOpdDacCode() != null
						&& castOther.getOpdDacCode() != null && this.getOpdDacCode().equals(castOther.getOpdDacCode())))
				&& ((this.getOpdTpoCode() == castOther.getOpdTpoCode()) || (this.getOpdTpoCode() != null
						&& castOther.getOpdTpoCode() != null && this.getOpdTpoCode().equals(castOther.getOpdTpoCode())))
				&& ((this.getOdpTpoEtapPiece() == castOther.getOdpTpoEtapPiece())
						|| (this.getOdpTpoEtapPiece() != null && castOther.getOdpTpoEtapPiece() != null
								&& this.getOdpTpoEtapPiece().equals(castOther.getOdpTpoEtapPiece())))
				&& ((this.getOdpDteSaisi() == castOther.getOdpDteSaisi())
						|| (this.getOdpDteSaisi() != null && castOther.getOdpDteSaisi() != null
								&& this.getOdpDteSaisi().equals(castOther.getOdpDteSaisi())))
				&& ((this.getOdpOpeMatricule() == castOther.getOdpOpeMatricule())
						|| (this.getOdpOpeMatricule() != null && castOther.getOdpOpeMatricule() != null
								&& this.getOdpOpeMatricule().equals(castOther.getOdpOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOpdNum() == null ? 0 : this.getOpdNum().hashCode());
		result = 37 * result + (getOpdDacCode() == null ? 0 : this.getOpdDacCode().hashCode());
		result = 37 * result + (getOpdTpoCode() == null ? 0 : this.getOpdTpoCode().hashCode());
		result = 37 * result + (getOdpTpoEtapPiece() == null ? 0 : this.getOdpTpoEtapPiece().hashCode());
		result = 37 * result + (getOdpDteSaisi() == null ? 0 : this.getOdpDteSaisi().hashCode());
		result = 37 * result + (getOdpOpeMatricule() == null ? 0 : this.getOdpOpeMatricule().hashCode());
		return result;
	}

}
