package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VHistoDaoId generated by hbm2java
 */
@Embeddable
public class VHistoDaoId implements java.io.Serializable {

	private String dacCode;
	private long hacId;
	private String hacFonCod;
	private String hacOpeMat;
	private String hacDacCode;
	private String hacStaCode;
	private Date hacDate;
	private String hacCommentaire;

	public VHistoDaoId() {
	}

	public VHistoDaoId(String dacCode, long hacId, String hacFonCod, String hacOpeMat, String hacDacCode,
			String hacStaCode) {
		this.dacCode = dacCode;
		this.hacId = hacId;
		this.hacFonCod = hacFonCod;
		this.hacOpeMat = hacOpeMat;
		this.hacDacCode = hacDacCode;
		this.hacStaCode = hacStaCode;
	}

	public VHistoDaoId(String dacCode, long hacId, String hacFonCod, String hacOpeMat, String hacDacCode,
			String hacStaCode, Date hacDate, String hacCommentaire) {
		this.dacCode = dacCode;
		this.hacId = hacId;
		this.hacFonCod = hacFonCod;
		this.hacOpeMat = hacOpeMat;
		this.hacDacCode = hacDacCode;
		this.hacStaCode = hacStaCode;
		this.hacDate = hacDate;
		this.hacCommentaire = hacCommentaire;
	}

	@Column(name = "DAC_CODE", nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	@Column(name = "HAC_ID", nullable = false, precision = 10, scale = 0)
	public long getHacId() {
		return this.hacId;
	}

	public void setHacId(long hacId) {
		this.hacId = hacId;
	}

	@Column(name = "HAC_FON_COD", nullable = false, length = 12)
	public String getHacFonCod() {
		return this.hacFonCod;
	}

	public void setHacFonCod(String hacFonCod) {
		this.hacFonCod = hacFonCod;
	}

	@Column(name = "HAC_OPE_MAT", nullable = false, length = 25)
	public String getHacOpeMat() {
		return this.hacOpeMat;
	}

	public void setHacOpeMat(String hacOpeMat) {
		this.hacOpeMat = hacOpeMat;
	}

	@Column(name = "HAC_DAC_CODE", nullable = false, length = 20)
	public String getHacDacCode() {
		return this.hacDacCode;
	}

	public void setHacDacCode(String hacDacCode) {
		this.hacDacCode = hacDacCode;
	}

	@Column(name = "HAC_STA_CODE", nullable = false, length = 3)
	public String getHacStaCode() {
		return this.hacStaCode;
	}

	public void setHacStaCode(String hacStaCode) {
		this.hacStaCode = hacStaCode;
	}

	@Column(name = "HAC_DATE", length = 7)
	public Date getHacDate() {
		return this.hacDate;
	}

	public void setHacDate(Date hacDate) {
		this.hacDate = hacDate;
	}

	@Column(name = "HAC_COMMENTAIRE", length = 1000)
	public String getHacCommentaire() {
		return this.hacCommentaire;
	}

	public void setHacCommentaire(String hacCommentaire) {
		this.hacCommentaire = hacCommentaire;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VHistoDaoId))
			return false;
		VHistoDaoId castOther = (VHistoDaoId) other;

		return ((this.getDacCode() == castOther.getDacCode()) || (this.getDacCode() != null
				&& castOther.getDacCode() != null && this.getDacCode().equals(castOther.getDacCode())))
				&& (this.getHacId() == castOther.getHacId())
				&& ((this.getHacFonCod() == castOther.getHacFonCod()) || (this.getHacFonCod() != null
						&& castOther.getHacFonCod() != null && this.getHacFonCod().equals(castOther.getHacFonCod())))
				&& ((this.getHacOpeMat() == castOther.getHacOpeMat()) || (this.getHacOpeMat() != null
						&& castOther.getHacOpeMat() != null && this.getHacOpeMat().equals(castOther.getHacOpeMat())))
				&& ((this.getHacDacCode() == castOther.getHacDacCode()) || (this.getHacDacCode() != null
						&& castOther.getHacDacCode() != null && this.getHacDacCode().equals(castOther.getHacDacCode())))
				&& ((this.getHacStaCode() == castOther.getHacStaCode()) || (this.getHacStaCode() != null
						&& castOther.getHacStaCode() != null && this.getHacStaCode().equals(castOther.getHacStaCode())))
				&& ((this.getHacDate() == castOther.getHacDate()) || (this.getHacDate() != null
						&& castOther.getHacDate() != null && this.getHacDate().equals(castOther.getHacDate())))
				&& ((this.getHacCommentaire() == castOther.getHacCommentaire())
						|| (this.getHacCommentaire() != null && castOther.getHacCommentaire() != null
								&& this.getHacCommentaire().equals(castOther.getHacCommentaire())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDacCode() == null ? 0 : this.getDacCode().hashCode());
		result = 37 * result + (int) this.getHacId();
		result = 37 * result + (getHacFonCod() == null ? 0 : this.getHacFonCod().hashCode());
		result = 37 * result + (getHacOpeMat() == null ? 0 : this.getHacOpeMat().hashCode());
		result = 37 * result + (getHacDacCode() == null ? 0 : this.getHacDacCode().hashCode());
		result = 37 * result + (getHacStaCode() == null ? 0 : this.getHacStaCode().hashCode());
		result = 37 * result + (getHacDate() == null ? 0 : this.getHacDate().hashCode());
		result = 37 * result + (getHacCommentaire() == null ? 0 : this.getHacCommentaire().hashCode());
		return result;
	}

}
