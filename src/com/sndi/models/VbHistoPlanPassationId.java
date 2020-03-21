package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbHistoPlanPassationId generated by hbm2java
 */
@Embeddable
public class VbHistoPlanPassationId implements java.io.Serializable {

	private long hppId;
	private String hppFonCod;
	private long hppDppId;
	private String hppStaCode;
	private Date hppDate;
	private String hppMotif;

	public VbHistoPlanPassationId() {
	}

	public VbHistoPlanPassationId(long hppId, String hppFonCod, long hppDppId, String hppStaCode) {
		this.hppId = hppId;
		this.hppFonCod = hppFonCod;
		this.hppDppId = hppDppId;
		this.hppStaCode = hppStaCode;
	}

	public VbHistoPlanPassationId(long hppId, String hppFonCod, long hppDppId, String hppStaCode, Date hppDate,
			String hppMotif) {
		this.hppId = hppId;
		this.hppFonCod = hppFonCod;
		this.hppDppId = hppDppId;
		this.hppStaCode = hppStaCode;
		this.hppDate = hppDate;
		this.hppMotif = hppMotif;
	}

	@Column(name = "HPP_ID", nullable = false, precision = 10, scale = 0)
	public long getHppId() {
		return this.hppId;
	}

	public void setHppId(long hppId) {
		this.hppId = hppId;
	}

	@Column(name = "HPP_FON_COD", nullable = false, length = 12)
	public String getHppFonCod() {
		return this.hppFonCod;
	}

	public void setHppFonCod(String hppFonCod) {
		this.hppFonCod = hppFonCod;
	}

	@Column(name = "HPP_DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getHppDppId() {
		return this.hppDppId;
	}

	public void setHppDppId(long hppDppId) {
		this.hppDppId = hppDppId;
	}

	@Column(name = "HPP_STA_CODE", nullable = false, length = 3)
	public String getHppStaCode() {
		return this.hppStaCode;
	}

	public void setHppStaCode(String hppStaCode) {
		this.hppStaCode = hppStaCode;
	}

	@Column(name = "HPP_DATE", length = 7)
	public Date getHppDate() {
		return this.hppDate;
	}

	public void setHppDate(Date hppDate) {
		this.hppDate = hppDate;
	}

	@Column(name = "HPP_MOTIF", length = 1000)
	public String getHppMotif() {
		return this.hppMotif;
	}

	public void setHppMotif(String hppMotif) {
		this.hppMotif = hppMotif;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbHistoPlanPassationId))
			return false;
		VbHistoPlanPassationId castOther = (VbHistoPlanPassationId) other;

		return (this.getHppId() == castOther.getHppId())
				&& ((this.getHppFonCod() == castOther.getHppFonCod()) || (this.getHppFonCod() != null
						&& castOther.getHppFonCod() != null && this.getHppFonCod().equals(castOther.getHppFonCod())))
				&& (this.getHppDppId() == castOther.getHppDppId())
				&& ((this.getHppStaCode() == castOther.getHppStaCode()) || (this.getHppStaCode() != null
						&& castOther.getHppStaCode() != null && this.getHppStaCode().equals(castOther.getHppStaCode())))
				&& ((this.getHppDate() == castOther.getHppDate()) || (this.getHppDate() != null
						&& castOther.getHppDate() != null && this.getHppDate().equals(castOther.getHppDate())))
				&& ((this.getHppMotif() == castOther.getHppMotif()) || (this.getHppMotif() != null
						&& castOther.getHppMotif() != null && this.getHppMotif().equals(castOther.getHppMotif())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getHppId();
		result = 37 * result + (getHppFonCod() == null ? 0 : this.getHppFonCod().hashCode());
		result = 37 * result + (int) this.getHppDppId();
		result = 37 * result + (getHppStaCode() == null ? 0 : this.getHppStaCode().hashCode());
		result = 37 * result + (getHppDate() == null ? 0 : this.getHppDate().hashCode());
		result = 37 * result + (getHppMotif() == null ? 0 : this.getHppMotif().hashCode());
		return result;
	}

}
