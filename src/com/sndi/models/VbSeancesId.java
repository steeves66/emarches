package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbSeancesId generated by hbm2java
 */
@Embeddable
public class VbSeancesId implements java.io.Serializable {

	private BigDecimal seaNum;
	private String seaLibelle;
	private String seaTseCode;
	private String seaQuorum;
	private BigDecimal seaNbrPli;
	private String seaRes;
	private Date seaSteSaisi;
	private String seaFonCode;
	private String seaOpeMatricule;
	private String seaObservation;

	public VbSeancesId() {
	}

	public VbSeancesId(BigDecimal seaNum) {
		this.seaNum = seaNum;
	}

	public VbSeancesId(BigDecimal seaNum, String seaLibelle, String seaTseCode, String seaQuorum, BigDecimal seaNbrPli,
			String seaRes, Date seaSteSaisi, String seaFonCode, String seaOpeMatricule, String seaObservation) {
		this.seaNum = seaNum;
		this.seaLibelle = seaLibelle;
		this.seaTseCode = seaTseCode;
		this.seaQuorum = seaQuorum;
		this.seaNbrPli = seaNbrPli;
		this.seaRes = seaRes;
		this.seaSteSaisi = seaSteSaisi;
		this.seaFonCode = seaFonCode;
		this.seaOpeMatricule = seaOpeMatricule;
		this.seaObservation = seaObservation;
	}

	@Column(name = "SEA_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getSeaNum() {
		return this.seaNum;
	}

	public void setSeaNum(BigDecimal seaNum) {
		this.seaNum = seaNum;
	}

	@Column(name = "SEA_LIBELLE", length = 500)
	public String getSeaLibelle() {
		return this.seaLibelle;
	}

	public void setSeaLibelle(String seaLibelle) {
		this.seaLibelle = seaLibelle;
	}

	@Column(name = "SEA_TSE_CODE", length = 3)
	public String getSeaTseCode() {
		return this.seaTseCode;
	}

	public void setSeaTseCode(String seaTseCode) {
		this.seaTseCode = seaTseCode;
	}

	@Column(name = "SEA_QUORUM", length = 1)
	public String getSeaQuorum() {
		return this.seaQuorum;
	}

	public void setSeaQuorum(String seaQuorum) {
		this.seaQuorum = seaQuorum;
	}

	@Column(name = "SEA_NBR_PLI", precision = 22, scale = 0)
	public BigDecimal getSeaNbrPli() {
		return this.seaNbrPli;
	}

	public void setSeaNbrPli(BigDecimal seaNbrPli) {
		this.seaNbrPli = seaNbrPli;
	}

	@Column(name = "SEA_RES", length = 1)
	public String getSeaRes() {
		return this.seaRes;
	}

	public void setSeaRes(String seaRes) {
		this.seaRes = seaRes;
	}

	@Column(name = "SEA_STE_SAISI", length = 7)
	public Date getSeaSteSaisi() {
		return this.seaSteSaisi;
	}

	public void setSeaSteSaisi(Date seaSteSaisi) {
		this.seaSteSaisi = seaSteSaisi;
	}

	@Column(name = "SEA_FON_CODE", length = 30)
	public String getSeaFonCode() {
		return this.seaFonCode;
	}

	public void setSeaFonCode(String seaFonCode) {
		this.seaFonCode = seaFonCode;
	}

	@Column(name = "SEA_OPE_MATRICULE", length = 25)
	public String getSeaOpeMatricule() {
		return this.seaOpeMatricule;
	}

	public void setSeaOpeMatricule(String seaOpeMatricule) {
		this.seaOpeMatricule = seaOpeMatricule;
	}

	@Column(name = "SEA_OBSERVATION", length = 500)
	public String getSeaObservation() {
		return this.seaObservation;
	}

	public void setSeaObservation(String seaObservation) {
		this.seaObservation = seaObservation;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbSeancesId))
			return false;
		VbSeancesId castOther = (VbSeancesId) other;

		return ((this.getSeaNum() == castOther.getSeaNum()) || (this.getSeaNum() != null
				&& castOther.getSeaNum() != null && this.getSeaNum().equals(castOther.getSeaNum())))
				&& ((this.getSeaLibelle() == castOther.getSeaLibelle()) || (this.getSeaLibelle() != null
						&& castOther.getSeaLibelle() != null && this.getSeaLibelle().equals(castOther.getSeaLibelle())))
				&& ((this.getSeaTseCode() == castOther.getSeaTseCode()) || (this.getSeaTseCode() != null
						&& castOther.getSeaTseCode() != null && this.getSeaTseCode().equals(castOther.getSeaTseCode())))
				&& ((this.getSeaQuorum() == castOther.getSeaQuorum()) || (this.getSeaQuorum() != null
						&& castOther.getSeaQuorum() != null && this.getSeaQuorum().equals(castOther.getSeaQuorum())))
				&& ((this.getSeaNbrPli() == castOther.getSeaNbrPli()) || (this.getSeaNbrPli() != null
						&& castOther.getSeaNbrPli() != null && this.getSeaNbrPli().equals(castOther.getSeaNbrPli())))
				&& ((this.getSeaRes() == castOther.getSeaRes()) || (this.getSeaRes() != null
						&& castOther.getSeaRes() != null && this.getSeaRes().equals(castOther.getSeaRes())))
				&& ((this.getSeaSteSaisi() == castOther.getSeaSteSaisi())
						|| (this.getSeaSteSaisi() != null && castOther.getSeaSteSaisi() != null
								&& this.getSeaSteSaisi().equals(castOther.getSeaSteSaisi())))
				&& ((this.getSeaFonCode() == castOther.getSeaFonCode()) || (this.getSeaFonCode() != null
						&& castOther.getSeaFonCode() != null && this.getSeaFonCode().equals(castOther.getSeaFonCode())))
				&& ((this.getSeaOpeMatricule() == castOther.getSeaOpeMatricule())
						|| (this.getSeaOpeMatricule() != null && castOther.getSeaOpeMatricule() != null
								&& this.getSeaOpeMatricule().equals(castOther.getSeaOpeMatricule())))
				&& ((this.getSeaObservation() == castOther.getSeaObservation())
						|| (this.getSeaObservation() != null && castOther.getSeaObservation() != null
								&& this.getSeaObservation().equals(castOther.getSeaObservation())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSeaNum() == null ? 0 : this.getSeaNum().hashCode());
		result = 37 * result + (getSeaLibelle() == null ? 0 : this.getSeaLibelle().hashCode());
		result = 37 * result + (getSeaTseCode() == null ? 0 : this.getSeaTseCode().hashCode());
		result = 37 * result + (getSeaQuorum() == null ? 0 : this.getSeaQuorum().hashCode());
		result = 37 * result + (getSeaNbrPli() == null ? 0 : this.getSeaNbrPli().hashCode());
		result = 37 * result + (getSeaRes() == null ? 0 : this.getSeaRes().hashCode());
		result = 37 * result + (getSeaSteSaisi() == null ? 0 : this.getSeaSteSaisi().hashCode());
		result = 37 * result + (getSeaFonCode() == null ? 0 : this.getSeaFonCode().hashCode());
		result = 37 * result + (getSeaOpeMatricule() == null ? 0 : this.getSeaOpeMatricule().hashCode());
		result = 37 * result + (getSeaObservation() == null ? 0 : this.getSeaObservation().hashCode());
		return result;
	}

}