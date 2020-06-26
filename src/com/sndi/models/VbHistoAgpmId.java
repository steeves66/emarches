package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbHistoAgpmId generated by hbm2java
 */
@Embeddable
public class VbHistoAgpmId implements java.io.Serializable {

	private long hagId;
	private long hagAgpId;
	private String hagStaCode;
	private Date hagDate;
	private String hagMotif;
	private String hagFonCod;

	public VbHistoAgpmId() {
	}

	public VbHistoAgpmId(long hagId, long hagAgpId, String hagStaCode) {
		this.hagId = hagId;
		this.hagAgpId = hagAgpId;
		this.hagStaCode = hagStaCode;
	}

	public VbHistoAgpmId(long hagId, long hagAgpId, String hagStaCode, Date hagDate, String hagMotif,
			String hagFonCod) {
		this.hagId = hagId;
		this.hagAgpId = hagAgpId;
		this.hagStaCode = hagStaCode;
		this.hagDate = hagDate;
		this.hagMotif = hagMotif;
		this.hagFonCod = hagFonCod;
	}

	@Column(name = "HAG_ID", nullable = false, precision = 10, scale = 0)
	public long getHagId() {
		return this.hagId;
	}

	public void setHagId(long hagId) {
		this.hagId = hagId;
	}

	@Column(name = "HAG_AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getHagAgpId() {
		return this.hagAgpId;
	}

	public void setHagAgpId(long hagAgpId) {
		this.hagAgpId = hagAgpId;
	}

	@Column(name = "HAG_STA_CODE", nullable = false, length = 3)
	public String getHagStaCode() {
		return this.hagStaCode;
	}

	public void setHagStaCode(String hagStaCode) {
		this.hagStaCode = hagStaCode;
	}

	@Column(name = "HAG_DATE", length = 7)
	public Date getHagDate() {
		return this.hagDate;
	}

	public void setHagDate(Date hagDate) {
		this.hagDate = hagDate;
	}

	@Column(name = "HAG_MOTIF", length = 1000)
	public String getHagMotif() {
		return this.hagMotif;
	}

	public void setHagMotif(String hagMotif) {
		this.hagMotif = hagMotif;
	}

	@Column(name = "HAG_FON_COD", length = 12)
	public String getHagFonCod() {
		return this.hagFonCod;
	}

	public void setHagFonCod(String hagFonCod) {
		this.hagFonCod = hagFonCod;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbHistoAgpmId))
			return false;
		VbHistoAgpmId castOther = (VbHistoAgpmId) other;

		return (this.getHagId() == castOther.getHagId()) && (this.getHagAgpId() == castOther.getHagAgpId())
				&& ((this.getHagStaCode() == castOther.getHagStaCode()) || (this.getHagStaCode() != null
						&& castOther.getHagStaCode() != null && this.getHagStaCode().equals(castOther.getHagStaCode())))
				&& ((this.getHagDate() == castOther.getHagDate()) || (this.getHagDate() != null
						&& castOther.getHagDate() != null && this.getHagDate().equals(castOther.getHagDate())))
				&& ((this.getHagMotif() == castOther.getHagMotif()) || (this.getHagMotif() != null
						&& castOther.getHagMotif() != null && this.getHagMotif().equals(castOther.getHagMotif())))
				&& ((this.getHagFonCod() == castOther.getHagFonCod()) || (this.getHagFonCod() != null
						&& castOther.getHagFonCod() != null && this.getHagFonCod().equals(castOther.getHagFonCod())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getHagId();
		result = 37 * result + (int) this.getHagAgpId();
		result = 37 * result + (getHagStaCode() == null ? 0 : this.getHagStaCode().hashCode());
		result = 37 * result + (getHagDate() == null ? 0 : this.getHagDate().hashCode());
		result = 37 * result + (getHagMotif() == null ? 0 : this.getHagMotif().hashCode());
		result = 37 * result + (getHagFonCod() == null ? 0 : this.getHagFonCod().hashCode());
		return result;
	}

}