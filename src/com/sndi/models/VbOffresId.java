package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbOffresId generated by hbm2java
 */
@Embeddable
public class VbOffresId implements java.io.Serializable {

	private BigDecimal offNum;
	private String offSouNcc;
	private String offAaoCode;
	private String offDacCode;
	private String offStaCode;
	private Date offDteSaisi;
	private Date offDteOuvFin;
	private BigDecimal offMtTotOfr;
	private Date offDteJug;
	private BigDecimal offMtTotCor;
	private Date offDteOuvTec;
	private String offOpeMatricule;
	private Date offDteStaCour;

	public VbOffresId() {
	}

	public VbOffresId(BigDecimal offNum, String offAaoCode, String offDacCode, String offStaCode) {
		this.offNum = offNum;
		this.offAaoCode = offAaoCode;
		this.offDacCode = offDacCode;
		this.offStaCode = offStaCode;
	}

	public VbOffresId(BigDecimal offNum, String offSouNcc, String offAaoCode, String offDacCode, String offStaCode,
			Date offDteSaisi, Date offDteOuvFin, BigDecimal offMtTotOfr, Date offDteJug, BigDecimal offMtTotCor,
			Date offDteOuvTec, String offOpeMatricule, Date offDteStaCour) {
		this.offNum = offNum;
		this.offSouNcc = offSouNcc;
		this.offAaoCode = offAaoCode;
		this.offDacCode = offDacCode;
		this.offStaCode = offStaCode;
		this.offDteSaisi = offDteSaisi;
		this.offDteOuvFin = offDteOuvFin;
		this.offMtTotOfr = offMtTotOfr;
		this.offDteJug = offDteJug;
		this.offMtTotCor = offMtTotCor;
		this.offDteOuvTec = offDteOuvTec;
		this.offOpeMatricule = offOpeMatricule;
		this.offDteStaCour = offDteStaCour;
	}

	@Column(name = "OFF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOffNum() {
		return this.offNum;
	}

	public void setOffNum(BigDecimal offNum) {
		this.offNum = offNum;
	}

	@Column(name = "OFF_SOU_NCC", length = 20)
	public String getOffSouNcc() {
		return this.offSouNcc;
	}

	public void setOffSouNcc(String offSouNcc) {
		this.offSouNcc = offSouNcc;
	}

	@Column(name = "OFF_AAO_CODE", nullable = false, length = 20)
	public String getOffAaoCode() {
		return this.offAaoCode;
	}

	public void setOffAaoCode(String offAaoCode) {
		this.offAaoCode = offAaoCode;
	}

	@Column(name = "OFF_DAC_CODE", nullable = false, length = 20)
	public String getOffDacCode() {
		return this.offDacCode;
	}

	public void setOffDacCode(String offDacCode) {
		this.offDacCode = offDacCode;
	}

	@Column(name = "OFF_STA_CODE", nullable = false, length = 3)
	public String getOffStaCode() {
		return this.offStaCode;
	}

	public void setOffStaCode(String offStaCode) {
		this.offStaCode = offStaCode;
	}

	@Column(name = "OFF_DTE_SAISI", length = 7)
	public Date getOffDteSaisi() {
		return this.offDteSaisi;
	}

	public void setOffDteSaisi(Date offDteSaisi) {
		this.offDteSaisi = offDteSaisi;
	}

	@Column(name = "OFF_DTE_OUV_FIN", length = 7)
	public Date getOffDteOuvFin() {
		return this.offDteOuvFin;
	}

	public void setOffDteOuvFin(Date offDteOuvFin) {
		this.offDteOuvFin = offDteOuvFin;
	}

	@Column(name = "OFF_MT_TOT_OFR", precision = 20, scale = 0)
	public BigDecimal getOffMtTotOfr() {
		return this.offMtTotOfr;
	}

	public void setOffMtTotOfr(BigDecimal offMtTotOfr) {
		this.offMtTotOfr = offMtTotOfr;
	}

	@Column(name = "OFF_DTE_JUG", length = 7)
	public Date getOffDteJug() {
		return this.offDteJug;
	}

	public void setOffDteJug(Date offDteJug) {
		this.offDteJug = offDteJug;
	}

	@Column(name = "OFF_MT_TOT_COR", precision = 20, scale = 0)
	public BigDecimal getOffMtTotCor() {
		return this.offMtTotCor;
	}

	public void setOffMtTotCor(BigDecimal offMtTotCor) {
		this.offMtTotCor = offMtTotCor;
	}

	@Column(name = "OFF_DTE_OUV_TEC", length = 7)
	public Date getOffDteOuvTec() {
		return this.offDteOuvTec;
	}

	public void setOffDteOuvTec(Date offDteOuvTec) {
		this.offDteOuvTec = offDteOuvTec;
	}

	@Column(name = "OFF_OPE_MATRICULE", length = 25)
	public String getOffOpeMatricule() {
		return this.offOpeMatricule;
	}

	public void setOffOpeMatricule(String offOpeMatricule) {
		this.offOpeMatricule = offOpeMatricule;
	}

	@Column(name = "OFF_DTE_STA_COUR", length = 7)
	public Date getOffDteStaCour() {
		return this.offDteStaCour;
	}

	public void setOffDteStaCour(Date offDteStaCour) {
		this.offDteStaCour = offDteStaCour;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbOffresId))
			return false;
		VbOffresId castOther = (VbOffresId) other;

		return ((this.getOffNum() == castOther.getOffNum()) || (this.getOffNum() != null
				&& castOther.getOffNum() != null && this.getOffNum().equals(castOther.getOffNum())))
				&& ((this.getOffSouNcc() == castOther.getOffSouNcc()) || (this.getOffSouNcc() != null
						&& castOther.getOffSouNcc() != null && this.getOffSouNcc().equals(castOther.getOffSouNcc())))
				&& ((this.getOffAaoCode() == castOther.getOffAaoCode()) || (this.getOffAaoCode() != null
						&& castOther.getOffAaoCode() != null && this.getOffAaoCode().equals(castOther.getOffAaoCode())))
				&& ((this.getOffDacCode() == castOther.getOffDacCode()) || (this.getOffDacCode() != null
						&& castOther.getOffDacCode() != null && this.getOffDacCode().equals(castOther.getOffDacCode())))
				&& ((this.getOffStaCode() == castOther.getOffStaCode()) || (this.getOffStaCode() != null
						&& castOther.getOffStaCode() != null && this.getOffStaCode().equals(castOther.getOffStaCode())))
				&& ((this.getOffDteSaisi() == castOther.getOffDteSaisi())
						|| (this.getOffDteSaisi() != null && castOther.getOffDteSaisi() != null
								&& this.getOffDteSaisi().equals(castOther.getOffDteSaisi())))
				&& ((this.getOffDteOuvFin() == castOther.getOffDteOuvFin())
						|| (this.getOffDteOuvFin() != null && castOther.getOffDteOuvFin() != null
								&& this.getOffDteOuvFin().equals(castOther.getOffDteOuvFin())))
				&& ((this.getOffMtTotOfr() == castOther.getOffMtTotOfr())
						|| (this.getOffMtTotOfr() != null && castOther.getOffMtTotOfr() != null
								&& this.getOffMtTotOfr().equals(castOther.getOffMtTotOfr())))
				&& ((this.getOffDteJug() == castOther.getOffDteJug()) || (this.getOffDteJug() != null
						&& castOther.getOffDteJug() != null && this.getOffDteJug().equals(castOther.getOffDteJug())))
				&& ((this.getOffMtTotCor() == castOther.getOffMtTotCor())
						|| (this.getOffMtTotCor() != null && castOther.getOffMtTotCor() != null
								&& this.getOffMtTotCor().equals(castOther.getOffMtTotCor())))
				&& ((this.getOffDteOuvTec() == castOther.getOffDteOuvTec())
						|| (this.getOffDteOuvTec() != null && castOther.getOffDteOuvTec() != null
								&& this.getOffDteOuvTec().equals(castOther.getOffDteOuvTec())))
				&& ((this.getOffOpeMatricule() == castOther.getOffOpeMatricule())
						|| (this.getOffOpeMatricule() != null && castOther.getOffOpeMatricule() != null
								&& this.getOffOpeMatricule().equals(castOther.getOffOpeMatricule())))
				&& ((this.getOffDteStaCour() == castOther.getOffDteStaCour())
						|| (this.getOffDteStaCour() != null && castOther.getOffDteStaCour() != null
								&& this.getOffDteStaCour().equals(castOther.getOffDteStaCour())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOffNum() == null ? 0 : this.getOffNum().hashCode());
		result = 37 * result + (getOffSouNcc() == null ? 0 : this.getOffSouNcc().hashCode());
		result = 37 * result + (getOffAaoCode() == null ? 0 : this.getOffAaoCode().hashCode());
		result = 37 * result + (getOffDacCode() == null ? 0 : this.getOffDacCode().hashCode());
		result = 37 * result + (getOffStaCode() == null ? 0 : this.getOffStaCode().hashCode());
		result = 37 * result + (getOffDteSaisi() == null ? 0 : this.getOffDteSaisi().hashCode());
		result = 37 * result + (getOffDteOuvFin() == null ? 0 : this.getOffDteOuvFin().hashCode());
		result = 37 * result + (getOffMtTotOfr() == null ? 0 : this.getOffMtTotOfr().hashCode());
		result = 37 * result + (getOffDteJug() == null ? 0 : this.getOffDteJug().hashCode());
		result = 37 * result + (getOffMtTotCor() == null ? 0 : this.getOffMtTotCor().hashCode());
		result = 37 * result + (getOffDteOuvTec() == null ? 0 : this.getOffDteOuvTec().hashCode());
		result = 37 * result + (getOffOpeMatricule() == null ? 0 : this.getOffOpeMatricule().hashCode());
		result = 37 * result + (getOffDteStaCour() == null ? 0 : this.getOffDteStaCour().hashCode());
		return result;
	}

}
