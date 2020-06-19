package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDetailAvisId generated by hbm2java
 */
@Embeddable
public class VbDetailAvisId implements java.io.Serializable {

	private BigDecimal davCode;
	private BigDecimal davNumOrd;
	private String davTitre;
	private String davContenu;
	private Date davDteSaisi;
	private String davStaCode;
	private String davAaoCode;
	private String davDacCode;
	private String davAutre;

	public VbDetailAvisId() {
	}

	public VbDetailAvisId(BigDecimal davCode) {
		this.davCode = davCode;
	}

	public VbDetailAvisId(BigDecimal davCode, BigDecimal davNumOrd, String davTitre, String davContenu,
			Date davDteSaisi, String davStaCode, String davAaoCode, String davDacCode, String davAutre) {
		this.davCode = davCode;
		this.davNumOrd = davNumOrd;
		this.davTitre = davTitre;
		this.davContenu = davContenu;
		this.davDteSaisi = davDteSaisi;
		this.davStaCode = davStaCode;
		this.davAaoCode = davAaoCode;
		this.davDacCode = davDacCode;
		this.davAutre = davAutre;
	}

	@Column(name = "DAV_CODE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDavCode() {
		return this.davCode;
	}

	public void setDavCode(BigDecimal davCode) {
		this.davCode = davCode;
	}

	@Column(name = "DAV_NUM_ORD", precision = 22, scale = 0)
	public BigDecimal getDavNumOrd() {
		return this.davNumOrd;
	}

	public void setDavNumOrd(BigDecimal davNumOrd) {
		this.davNumOrd = davNumOrd;
	}

	@Column(name = "DAV_TITRE", length = 200)
	public String getDavTitre() {
		return this.davTitre;
	}

	public void setDavTitre(String davTitre) {
		this.davTitre = davTitre;
	}

	@Column(name = "DAV_CONTENU", length = 2000)
	public String getDavContenu() {
		return this.davContenu;
	}

	public void setDavContenu(String davContenu) {
		this.davContenu = davContenu;
	}

	@Column(name = "DAV_DTE_SAISI", length = 7)
	public Date getDavDteSaisi() {
		return this.davDteSaisi;
	}

	public void setDavDteSaisi(Date davDteSaisi) {
		this.davDteSaisi = davDteSaisi;
	}

	@Column(name = "DAV_STA_CODE", length = 3)
	public String getDavStaCode() {
		return this.davStaCode;
	}

	public void setDavStaCode(String davStaCode) {
		this.davStaCode = davStaCode;
	}

	@Column(name = "DAV_AAO_CODE", length = 20)
	public String getDavAaoCode() {
		return this.davAaoCode;
	}

	public void setDavAaoCode(String davAaoCode) {
		this.davAaoCode = davAaoCode;
	}

	@Column(name = "DAV_DAC_CODE", length = 20)
	public String getDavDacCode() {
		return this.davDacCode;
	}

	public void setDavDacCode(String davDacCode) {
		this.davDacCode = davDacCode;
	}

	@Column(name = "DAV_AUTRE", length = 200)
	public String getDavAutre() {
		return this.davAutre;
	}

	public void setDavAutre(String davAutre) {
		this.davAutre = davAutre;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDetailAvisId))
			return false;
		VbDetailAvisId castOther = (VbDetailAvisId) other;

		return ((this.getDavCode() == castOther.getDavCode()) || (this.getDavCode() != null
				&& castOther.getDavCode() != null && this.getDavCode().equals(castOther.getDavCode())))
				&& ((this.getDavNumOrd() == castOther.getDavNumOrd()) || (this.getDavNumOrd() != null
						&& castOther.getDavNumOrd() != null && this.getDavNumOrd().equals(castOther.getDavNumOrd())))
				&& ((this.getDavTitre() == castOther.getDavTitre()) || (this.getDavTitre() != null
						&& castOther.getDavTitre() != null && this.getDavTitre().equals(castOther.getDavTitre())))
				&& ((this.getDavContenu() == castOther.getDavContenu()) || (this.getDavContenu() != null
						&& castOther.getDavContenu() != null && this.getDavContenu().equals(castOther.getDavContenu())))
				&& ((this.getDavDteSaisi() == castOther.getDavDteSaisi())
						|| (this.getDavDteSaisi() != null && castOther.getDavDteSaisi() != null
								&& this.getDavDteSaisi().equals(castOther.getDavDteSaisi())))
				&& ((this.getDavStaCode() == castOther.getDavStaCode()) || (this.getDavStaCode() != null
						&& castOther.getDavStaCode() != null && this.getDavStaCode().equals(castOther.getDavStaCode())))
				&& ((this.getDavAaoCode() == castOther.getDavAaoCode()) || (this.getDavAaoCode() != null
						&& castOther.getDavAaoCode() != null && this.getDavAaoCode().equals(castOther.getDavAaoCode())))
				&& ((this.getDavDacCode() == castOther.getDavDacCode()) || (this.getDavDacCode() != null
						&& castOther.getDavDacCode() != null && this.getDavDacCode().equals(castOther.getDavDacCode())))
				&& ((this.getDavAutre() == castOther.getDavAutre()) || (this.getDavAutre() != null
						&& castOther.getDavAutre() != null && this.getDavAutre().equals(castOther.getDavAutre())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDavCode() == null ? 0 : this.getDavCode().hashCode());
		result = 37 * result + (getDavNumOrd() == null ? 0 : this.getDavNumOrd().hashCode());
		result = 37 * result + (getDavTitre() == null ? 0 : this.getDavTitre().hashCode());
		result = 37 * result + (getDavContenu() == null ? 0 : this.getDavContenu().hashCode());
		result = 37 * result + (getDavDteSaisi() == null ? 0 : this.getDavDteSaisi().hashCode());
		result = 37 * result + (getDavStaCode() == null ? 0 : this.getDavStaCode().hashCode());
		result = 37 * result + (getDavAaoCode() == null ? 0 : this.getDavAaoCode().hashCode());
		result = 37 * result + (getDavDacCode() == null ? 0 : this.getDavDacCode().hashCode());
		result = 37 * result + (getDavAutre() == null ? 0 : this.getDavAutre().hashCode());
		return result;
	}

}
