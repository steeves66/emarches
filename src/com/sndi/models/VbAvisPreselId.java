package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbAvisPreselId generated by hbm2java
 */
@Embeddable
public class VbAvisPreselId implements java.io.Serializable {

	private BigDecimal aprNum;
	private BigDecimal aprDemNum;
	private String aprType;
	private String aprSouNcc;
	private String aprModeInvit;
	private String aprDetailInvit;
	private Date aprDteSaisi;
	private String aprOpeMatricule;
	private Date aprDteModif;
	private String aprOpeMatMotif;
	private BigDecimal aprMtInit;
	private BigDecimal aprMtDef;
	private String aprRet;

	public VbAvisPreselId() {
	}

	public VbAvisPreselId(BigDecimal aprNum) {
		this.aprNum = aprNum;
	}

	public VbAvisPreselId(BigDecimal aprNum, BigDecimal aprDemNum, String aprType, String aprSouNcc,
			String aprModeInvit, String aprDetailInvit, Date aprDteSaisi, String aprOpeMatricule, Date aprDteModif,
			String aprOpeMatMotif, BigDecimal aprMtInit, BigDecimal aprMtDef, String aprRet) {
		this.aprNum = aprNum;
		this.aprDemNum = aprDemNum;
		this.aprType = aprType;
		this.aprSouNcc = aprSouNcc;
		this.aprModeInvit = aprModeInvit;
		this.aprDetailInvit = aprDetailInvit;
		this.aprDteSaisi = aprDteSaisi;
		this.aprOpeMatricule = aprOpeMatricule;
		this.aprDteModif = aprDteModif;
		this.aprOpeMatMotif = aprOpeMatMotif;
		this.aprMtInit = aprMtInit;
		this.aprMtDef = aprMtDef;
		this.aprRet = aprRet;
	}

	@Column(name = "APR_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getAprNum() {
		return this.aprNum;
	}

	public void setAprNum(BigDecimal aprNum) {
		this.aprNum = aprNum;
	}

	@Column(name = "APR_DEM_NUM", precision = 22, scale = 0)
	public BigDecimal getAprDemNum() {
		return this.aprDemNum;
	}

	public void setAprDemNum(BigDecimal aprDemNum) {
		this.aprDemNum = aprDemNum;
	}

	@Column(name = "APR_TYPE", length = 1)
	public String getAprType() {
		return this.aprType;
	}

	public void setAprType(String aprType) {
		this.aprType = aprType;
	}

	@Column(name = "APR_SOU_NCC", length = 20)
	public String getAprSouNcc() {
		return this.aprSouNcc;
	}

	public void setAprSouNcc(String aprSouNcc) {
		this.aprSouNcc = aprSouNcc;
	}

	@Column(name = "APR_MODE_INVIT", length = 100)
	public String getAprModeInvit() {
		return this.aprModeInvit;
	}

	public void setAprModeInvit(String aprModeInvit) {
		this.aprModeInvit = aprModeInvit;
	}

	@Column(name = "APR_DETAIL_INVIT", length = 2)
	public String getAprDetailInvit() {
		return this.aprDetailInvit;
	}

	public void setAprDetailInvit(String aprDetailInvit) {
		this.aprDetailInvit = aprDetailInvit;
	}

	@Column(name = "APR_DTE_SAISI", length = 7)
	public Date getAprDteSaisi() {
		return this.aprDteSaisi;
	}

	public void setAprDteSaisi(Date aprDteSaisi) {
		this.aprDteSaisi = aprDteSaisi;
	}

	@Column(name = "APR_OPE_MATRICULE", length = 25)
	public String getAprOpeMatricule() {
		return this.aprOpeMatricule;
	}

	public void setAprOpeMatricule(String aprOpeMatricule) {
		this.aprOpeMatricule = aprOpeMatricule;
	}

	@Column(name = "APR_DTE_MODIF", length = 7)
	public Date getAprDteModif() {
		return this.aprDteModif;
	}

	public void setAprDteModif(Date aprDteModif) {
		this.aprDteModif = aprDteModif;
	}

	@Column(name = "APR_OPE_MAT_MOTIF", length = 25)
	public String getAprOpeMatMotif() {
		return this.aprOpeMatMotif;
	}

	public void setAprOpeMatMotif(String aprOpeMatMotif) {
		this.aprOpeMatMotif = aprOpeMatMotif;
	}

	@Column(name = "APR_MT_INIT", precision = 20, scale = 0)
	public BigDecimal getAprMtInit() {
		return this.aprMtInit;
	}

	public void setAprMtInit(BigDecimal aprMtInit) {
		this.aprMtInit = aprMtInit;
	}

	@Column(name = "APR_MT_DEF", precision = 20, scale = 0)
	public BigDecimal getAprMtDef() {
		return this.aprMtDef;
	}

	public void setAprMtDef(BigDecimal aprMtDef) {
		this.aprMtDef = aprMtDef;
	}

	@Column(name = "APR_RET", length = 1)
	public String getAprRet() {
		return this.aprRet;
	}

	public void setAprRet(String aprRet) {
		this.aprRet = aprRet;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbAvisPreselId))
			return false;
		VbAvisPreselId castOther = (VbAvisPreselId) other;

		return ((this.getAprNum() == castOther.getAprNum()) || (this.getAprNum() != null
				&& castOther.getAprNum() != null && this.getAprNum().equals(castOther.getAprNum())))
				&& ((this.getAprDemNum() == castOther.getAprDemNum()) || (this.getAprDemNum() != null
						&& castOther.getAprDemNum() != null && this.getAprDemNum().equals(castOther.getAprDemNum())))
				&& ((this.getAprType() == castOther.getAprType()) || (this.getAprType() != null
						&& castOther.getAprType() != null && this.getAprType().equals(castOther.getAprType())))
				&& ((this.getAprSouNcc() == castOther.getAprSouNcc()) || (this.getAprSouNcc() != null
						&& castOther.getAprSouNcc() != null && this.getAprSouNcc().equals(castOther.getAprSouNcc())))
				&& ((this.getAprModeInvit() == castOther.getAprModeInvit())
						|| (this.getAprModeInvit() != null && castOther.getAprModeInvit() != null
								&& this.getAprModeInvit().equals(castOther.getAprModeInvit())))
				&& ((this.getAprDetailInvit() == castOther.getAprDetailInvit())
						|| (this.getAprDetailInvit() != null && castOther.getAprDetailInvit() != null
								&& this.getAprDetailInvit().equals(castOther.getAprDetailInvit())))
				&& ((this.getAprDteSaisi() == castOther.getAprDteSaisi())
						|| (this.getAprDteSaisi() != null && castOther.getAprDteSaisi() != null
								&& this.getAprDteSaisi().equals(castOther.getAprDteSaisi())))
				&& ((this.getAprOpeMatricule() == castOther.getAprOpeMatricule())
						|| (this.getAprOpeMatricule() != null && castOther.getAprOpeMatricule() != null
								&& this.getAprOpeMatricule().equals(castOther.getAprOpeMatricule())))
				&& ((this.getAprDteModif() == castOther.getAprDteModif())
						|| (this.getAprDteModif() != null && castOther.getAprDteModif() != null
								&& this.getAprDteModif().equals(castOther.getAprDteModif())))
				&& ((this.getAprOpeMatMotif() == castOther.getAprOpeMatMotif())
						|| (this.getAprOpeMatMotif() != null && castOther.getAprOpeMatMotif() != null
								&& this.getAprOpeMatMotif().equals(castOther.getAprOpeMatMotif())))
				&& ((this.getAprMtInit() == castOther.getAprMtInit()) || (this.getAprMtInit() != null
						&& castOther.getAprMtInit() != null && this.getAprMtInit().equals(castOther.getAprMtInit())))
				&& ((this.getAprMtDef() == castOther.getAprMtDef()) || (this.getAprMtDef() != null
						&& castOther.getAprMtDef() != null && this.getAprMtDef().equals(castOther.getAprMtDef())))
				&& ((this.getAprRet() == castOther.getAprRet()) || (this.getAprRet() != null
						&& castOther.getAprRet() != null && this.getAprRet().equals(castOther.getAprRet())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getAprNum() == null ? 0 : this.getAprNum().hashCode());
		result = 37 * result + (getAprDemNum() == null ? 0 : this.getAprDemNum().hashCode());
		result = 37 * result + (getAprType() == null ? 0 : this.getAprType().hashCode());
		result = 37 * result + (getAprSouNcc() == null ? 0 : this.getAprSouNcc().hashCode());
		result = 37 * result + (getAprModeInvit() == null ? 0 : this.getAprModeInvit().hashCode());
		result = 37 * result + (getAprDetailInvit() == null ? 0 : this.getAprDetailInvit().hashCode());
		result = 37 * result + (getAprDteSaisi() == null ? 0 : this.getAprDteSaisi().hashCode());
		result = 37 * result + (getAprOpeMatricule() == null ? 0 : this.getAprOpeMatricule().hashCode());
		result = 37 * result + (getAprDteModif() == null ? 0 : this.getAprDteModif().hashCode());
		result = 37 * result + (getAprOpeMatMotif() == null ? 0 : this.getAprOpeMatMotif().hashCode());
		result = 37 * result + (getAprMtInit() == null ? 0 : this.getAprMtInit().hashCode());
		result = 37 * result + (getAprMtDef() == null ? 0 : this.getAprMtDef().hashCode());
		result = 37 * result + (getAprRet() == null ? 0 : this.getAprRet().hashCode());
		return result;
	}

}
