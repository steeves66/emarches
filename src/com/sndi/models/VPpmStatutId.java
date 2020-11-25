package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPpmStatutId generated by hbm2java
 */
@Embeddable
public class VPpmStatutId implements java.io.Serializable {

	private String hppStaCode;
	private long hppDppId;
	private long hppId;
	private Date hppDate;
	private String hppMotif;
	private String fonLibelle;
	private String opeNom;

	public VPpmStatutId() {
	}

	public VPpmStatutId(String hppStaCode, long hppDppId, long hppId) {
		this.hppStaCode = hppStaCode;
		this.hppDppId = hppDppId;
		this.hppId = hppId;
	}

	public VPpmStatutId(String hppStaCode, long hppDppId, long hppId, Date hppDate, String hppMotif, String fonLibelle,
			String opeNom) {
		this.hppStaCode = hppStaCode;
		this.hppDppId = hppDppId;
		this.hppId = hppId;
		this.hppDate = hppDate;
		this.hppMotif = hppMotif;
		this.fonLibelle = fonLibelle;
		this.opeNom = opeNom;
	}

	@Column(name = "HPP_STA_CODE", nullable = false, length = 3)
	public String getHppStaCode() {
		return this.hppStaCode;
	}

	public void setHppStaCode(String hppStaCode) {
		this.hppStaCode = hppStaCode;
	}

	@Column(name = "HPP_DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getHppDppId() {
		return this.hppDppId;
	}

	public void setHppDppId(long hppDppId) {
		this.hppDppId = hppDppId;
	}

	@Column(name = "HPP_ID", nullable = false, precision = 10, scale = 0)
	public long getHppId() {
		return this.hppId;
	}

	public void setHppId(long hppId) {
		this.hppId = hppId;
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
		if (!(other instanceof VPpmStatutId))
			return false;
		VPpmStatutId castOther = (VPpmStatutId) other;

		return ((this.getHppStaCode() == castOther.getHppStaCode()) || (this.getHppStaCode() != null
				&& castOther.getHppStaCode() != null && this.getHppStaCode().equals(castOther.getHppStaCode())))
				&& (this.getHppDppId() == castOther.getHppDppId()) && (this.getHppId() == castOther.getHppId())
				&& ((this.getHppDate() == castOther.getHppDate()) || (this.getHppDate() != null
						&& castOther.getHppDate() != null && this.getHppDate().equals(castOther.getHppDate())))
				&& ((this.getHppMotif() == castOther.getHppMotif()) || (this.getHppMotif() != null
						&& castOther.getHppMotif() != null && this.getHppMotif().equals(castOther.getHppMotif())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getOpeNom() == castOther.getOpeNom()) || (this.getOpeNom() != null
						&& castOther.getOpeNom() != null && this.getOpeNom().equals(castOther.getOpeNom())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getHppStaCode() == null ? 0 : this.getHppStaCode().hashCode());
		result = 37 * result + (int) this.getHppDppId();
		result = 37 * result + (int) this.getHppId();
		result = 37 * result + (getHppDate() == null ? 0 : this.getHppDate().hashCode());
		result = 37 * result + (getHppMotif() == null ? 0 : this.getHppMotif().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getOpeNom() == null ? 0 : this.getOpeNom().hashCode());
		return result;
	}

}
