package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VAgpmStatutId generated by hbm2java
 */
@Embeddable
public class VAgpmStatutId implements java.io.Serializable {

	private long hagId;
	private Date hagDate;
	private String hagMotif;
	private String hagStaCode;
	private long hagAgpId;
	private String hagFonCod;
	private long agpProId;
	private String fonLibelle;
	private String opeNom;

	public VAgpmStatutId() {
	}

	public VAgpmStatutId(long hagId, String hagStaCode, long hagAgpId, long agpProId) {
		this.hagId = hagId;
		this.hagStaCode = hagStaCode;
		this.hagAgpId = hagAgpId;
		this.agpProId = agpProId;
	}

	public VAgpmStatutId(long hagId, Date hagDate, String hagMotif, String hagStaCode, long hagAgpId, String hagFonCod,
			long agpProId, String fonLibelle, String opeNom) {
		this.hagId = hagId;
		this.hagDate = hagDate;
		this.hagMotif = hagMotif;
		this.hagStaCode = hagStaCode;
		this.hagAgpId = hagAgpId;
		this.hagFonCod = hagFonCod;
		this.agpProId = agpProId;
		this.fonLibelle = fonLibelle;
		this.opeNom = opeNom;
	}

	@Column(name = "HAG_ID", nullable = false, precision = 10, scale = 0)
	public long getHagId() {
		return this.hagId;
	}

	public void setHagId(long hagId) {
		this.hagId = hagId;
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

	@Column(name = "HAG_STA_CODE", nullable = false, length = 3)
	public String getHagStaCode() {
		return this.hagStaCode;
	}

	public void setHagStaCode(String hagStaCode) {
		this.hagStaCode = hagStaCode;
	}

	@Column(name = "HAG_AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getHagAgpId() {
		return this.hagAgpId;
	}

	public void setHagAgpId(long hagAgpId) {
		this.hagAgpId = hagAgpId;
	}

	@Column(name = "HAG_FON_COD", length = 12)
	public String getHagFonCod() {
		return this.hagFonCod;
	}

	public void setHagFonCod(String hagFonCod) {
		this.hagFonCod = hagFonCod;
	}

	@Column(name = "AGP_PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpProId() {
		return this.agpProId;
	}

	public void setAgpProId(long agpProId) {
		this.agpProId = agpProId;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "OPE_NOM")
	public String getOpeNom() {
		return this.opeNom;
	}

	public void setOpeNom(String opeNom) {
		this.opeNom = opeNom;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VAgpmStatutId))
			return false;
		VAgpmStatutId castOther = (VAgpmStatutId) other;

		return (this.getHagId() == castOther.getHagId())
				&& ((this.getHagDate() == castOther.getHagDate()) || (this.getHagDate() != null
						&& castOther.getHagDate() != null && this.getHagDate().equals(castOther.getHagDate())))
				&& ((this.getHagMotif() == castOther.getHagMotif()) || (this.getHagMotif() != null
						&& castOther.getHagMotif() != null && this.getHagMotif().equals(castOther.getHagMotif())))
				&& ((this.getHagStaCode() == castOther.getHagStaCode()) || (this.getHagStaCode() != null
						&& castOther.getHagStaCode() != null && this.getHagStaCode().equals(castOther.getHagStaCode())))
				&& (this.getHagAgpId() == castOther.getHagAgpId())
				&& ((this.getHagFonCod() == castOther.getHagFonCod()) || (this.getHagFonCod() != null
						&& castOther.getHagFonCod() != null && this.getHagFonCod().equals(castOther.getHagFonCod())))
				&& (this.getAgpProId() == castOther.getAgpProId())
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getOpeNom() == castOther.getOpeNom()) || (this.getOpeNom() != null
						&& castOther.getOpeNom() != null && this.getOpeNom().equals(castOther.getOpeNom())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getHagId();
		result = 37 * result + (getHagDate() == null ? 0 : this.getHagDate().hashCode());
		result = 37 * result + (getHagMotif() == null ? 0 : this.getHagMotif().hashCode());
		result = 37 * result + (getHagStaCode() == null ? 0 : this.getHagStaCode().hashCode());
		result = 37 * result + (int) this.getHagAgpId();
		result = 37 * result + (getHagFonCod() == null ? 0 : this.getHagFonCod().hashCode());
		result = 37 * result + (int) this.getAgpProId();
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getOpeNom() == null ? 0 : this.getOpeNom().hashCode());
		return result;
	}

}