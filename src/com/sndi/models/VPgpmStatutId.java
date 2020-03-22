package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPgpmStatutId generated by hbm2java
 */
@Embeddable
public class VPgpmStatutId implements java.io.Serializable {

	private long hpgId;
	private Date hpgDate;
	private String hpgMotif;
	private String hpgStaCode;
	private long hpgGpgId;
	private String hpgFonCod;
	private String fonLibelle;

	public VPgpmStatutId() {
	}

	public VPgpmStatutId(long hpgId, String hpgStaCode, long hpgGpgId, String hpgFonCod) {
		this.hpgId = hpgId;
		this.hpgStaCode = hpgStaCode;
		this.hpgGpgId = hpgGpgId;
		this.hpgFonCod = hpgFonCod;
	}

	public VPgpmStatutId(long hpgId, Date hpgDate, String hpgMotif, String hpgStaCode, long hpgGpgId, String hpgFonCod,
			String fonLibelle) {
		this.hpgId = hpgId;
		this.hpgDate = hpgDate;
		this.hpgMotif = hpgMotif;
		this.hpgStaCode = hpgStaCode;
		this.hpgGpgId = hpgGpgId;
		this.hpgFonCod = hpgFonCod;
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "HPG_ID", nullable = false, precision = 10, scale = 0)
	public long getHpgId() {
		return this.hpgId;
	}

	public void setHpgId(long hpgId) {
		this.hpgId = hpgId;
	}

	@Column(name = "HPG_DATE", length = 7)
	public Date getHpgDate() {
		return this.hpgDate;
	}

	public void setHpgDate(Date hpgDate) {
		this.hpgDate = hpgDate;
	}

	@Column(name = "HPG_MOTIF", length = 1000)
	public String getHpgMotif() {
		return this.hpgMotif;
	}

	public void setHpgMotif(String hpgMotif) {
		this.hpgMotif = hpgMotif;
	}

	@Column(name = "HPG_STA_CODE", nullable = false, length = 3)
	public String getHpgStaCode() {
		return this.hpgStaCode;
	}

	public void setHpgStaCode(String hpgStaCode) {
		this.hpgStaCode = hpgStaCode;
	}

	@Column(name = "HPG_GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getHpgGpgId() {
		return this.hpgGpgId;
	}

	public void setHpgGpgId(long hpgGpgId) {
		this.hpgGpgId = hpgGpgId;
	}

	@Column(name = "HPG_FON_COD", nullable = false, length = 12)
	public String getHpgFonCod() {
		return this.hpgFonCod;
	}

	public void setHpgFonCod(String hpgFonCod) {
		this.hpgFonCod = hpgFonCod;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VPgpmStatutId))
			return false;
		VPgpmStatutId castOther = (VPgpmStatutId) other;

		return (this.getHpgId() == castOther.getHpgId())
				&& ((this.getHpgDate() == castOther.getHpgDate()) || (this.getHpgDate() != null
						&& castOther.getHpgDate() != null && this.getHpgDate().equals(castOther.getHpgDate())))
				&& ((this.getHpgMotif() == castOther.getHpgMotif()) || (this.getHpgMotif() != null
						&& castOther.getHpgMotif() != null && this.getHpgMotif().equals(castOther.getHpgMotif())))
				&& ((this.getHpgStaCode() == castOther.getHpgStaCode()) || (this.getHpgStaCode() != null
						&& castOther.getHpgStaCode() != null && this.getHpgStaCode().equals(castOther.getHpgStaCode())))
				&& (this.getHpgGpgId() == castOther.getHpgGpgId())
				&& ((this.getHpgFonCod() == castOther.getHpgFonCod()) || (this.getHpgFonCod() != null
						&& castOther.getHpgFonCod() != null && this.getHpgFonCod().equals(castOther.getHpgFonCod())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle())
						|| (this.getFonLibelle() != null && castOther.getFonLibelle() != null
								&& this.getFonLibelle().equals(castOther.getFonLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getHpgId();
		result = 37 * result + (getHpgDate() == null ? 0 : this.getHpgDate().hashCode());
		result = 37 * result + (getHpgMotif() == null ? 0 : this.getHpgMotif().hashCode());
		result = 37 * result + (getHpgStaCode() == null ? 0 : this.getHpgStaCode().hashCode());
		result = 37 * result + (int) this.getHpgGpgId();
		result = 37 * result + (getHpgFonCod() == null ? 0 : this.getHpgFonCod().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		return result;
	}

}
