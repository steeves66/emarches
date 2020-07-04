package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDetailAdresseAvisId generated by hbm2java
 */
@Embeddable
public class VbDetailAdresseAvisId implements java.io.Serializable {

	private BigDecimal dtaNum;
	private BigDecimal dtaAdaNum;
	private String dtaTitre;
	private String dtaLibelle;
	private Date dtaDteSaisi;
	private Short dtaLiaNum;

	public VbDetailAdresseAvisId() {
	}

	public VbDetailAdresseAvisId(BigDecimal dtaNum) {
		this.dtaNum = dtaNum;
	}

	public VbDetailAdresseAvisId(BigDecimal dtaNum, BigDecimal dtaAdaNum, String dtaTitre, String dtaLibelle,
			Date dtaDteSaisi, Short dtaLiaNum) {
		this.dtaNum = dtaNum;
		this.dtaAdaNum = dtaAdaNum;
		this.dtaTitre = dtaTitre;
		this.dtaLibelle = dtaLibelle;
		this.dtaDteSaisi = dtaDteSaisi;
		this.dtaLiaNum = dtaLiaNum;
	}

	@Column(name = "DTA_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDtaNum() {
		return this.dtaNum;
	}

	public void setDtaNum(BigDecimal dtaNum) {
		this.dtaNum = dtaNum;
	}

	@Column(name = "DTA_ADA_NUM", precision = 22, scale = 0)
	public BigDecimal getDtaAdaNum() {
		return this.dtaAdaNum;
	}

	public void setDtaAdaNum(BigDecimal dtaAdaNum) {
		this.dtaAdaNum = dtaAdaNum;
	}

	@Column(name = "DTA_TITRE", length = 200)
	public String getDtaTitre() {
		return this.dtaTitre;
	}

	public void setDtaTitre(String dtaTitre) {
		this.dtaTitre = dtaTitre;
	}

	@Column(name = "DTA_LIBELLE", length = 500)
	public String getDtaLibelle() {
		return this.dtaLibelle;
	}

	public void setDtaLibelle(String dtaLibelle) {
		this.dtaLibelle = dtaLibelle;
	}

	@Column(name = "DTA_DTE_SAISI", length = 7)
	public Date getDtaDteSaisi() {
		return this.dtaDteSaisi;
	}

	public void setDtaDteSaisi(Date dtaDteSaisi) {
		this.dtaDteSaisi = dtaDteSaisi;
	}

	@Column(name = "DTA_LIA_NUM", precision = 3, scale = 0)
	public Short getDtaLiaNum() {
		return this.dtaLiaNum;
	}

	public void setDtaLiaNum(Short dtaLiaNum) {
		this.dtaLiaNum = dtaLiaNum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDetailAdresseAvisId))
			return false;
		VbDetailAdresseAvisId castOther = (VbDetailAdresseAvisId) other;

		return ((this.getDtaNum() == castOther.getDtaNum()) || (this.getDtaNum() != null
				&& castOther.getDtaNum() != null && this.getDtaNum().equals(castOther.getDtaNum())))
				&& ((this.getDtaAdaNum() == castOther.getDtaAdaNum()) || (this.getDtaAdaNum() != null
						&& castOther.getDtaAdaNum() != null && this.getDtaAdaNum().equals(castOther.getDtaAdaNum())))
				&& ((this.getDtaTitre() == castOther.getDtaTitre()) || (this.getDtaTitre() != null
						&& castOther.getDtaTitre() != null && this.getDtaTitre().equals(castOther.getDtaTitre())))
				&& ((this.getDtaLibelle() == castOther.getDtaLibelle()) || (this.getDtaLibelle() != null
						&& castOther.getDtaLibelle() != null && this.getDtaLibelle().equals(castOther.getDtaLibelle())))
				&& ((this.getDtaDteSaisi() == castOther.getDtaDteSaisi())
						|| (this.getDtaDteSaisi() != null && castOther.getDtaDteSaisi() != null
								&& this.getDtaDteSaisi().equals(castOther.getDtaDteSaisi())))
				&& ((this.getDtaLiaNum() == castOther.getDtaLiaNum()) || (this.getDtaLiaNum() != null
						&& castOther.getDtaLiaNum() != null && this.getDtaLiaNum().equals(castOther.getDtaLiaNum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDtaNum() == null ? 0 : this.getDtaNum().hashCode());
		result = 37 * result + (getDtaAdaNum() == null ? 0 : this.getDtaAdaNum().hashCode());
		result = 37 * result + (getDtaTitre() == null ? 0 : this.getDtaTitre().hashCode());
		result = 37 * result + (getDtaLibelle() == null ? 0 : this.getDtaLibelle().hashCode());
		result = 37 * result + (getDtaDteSaisi() == null ? 0 : this.getDtaDteSaisi().hashCode());
		result = 37 * result + (getDtaLiaNum() == null ? 0 : this.getDtaLiaNum().hashCode());
		return result;
	}

}
