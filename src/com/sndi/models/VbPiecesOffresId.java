package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbPiecesOffresId generated by hbm2java
 */
@Embeddable
public class VbPiecesOffresId implements java.io.Serializable {

	private BigDecimal pofNum;
	private String pofDacCode;
	private BigDecimal pofLaaId;
	private BigDecimal pofOpdNum;
	private String pofOpdTpoCode;
	private BigDecimal pofDofNum;
	private String pofPresent;
	private String pofConforme;
	private String pofTypeAct;
	private Date pofDteSaisi;
	private String pofOpeMatricule;
	private String pofObs;

	public VbPiecesOffresId() {
	}

	public VbPiecesOffresId(BigDecimal pofNum) {
		this.pofNum = pofNum;
	}

	public VbPiecesOffresId(BigDecimal pofNum, String pofDacCode, BigDecimal pofLaaId, BigDecimal pofOpdNum,
			String pofOpdTpoCode, BigDecimal pofDofNum, String pofPresent, String pofConforme, String pofTypeAct,
			Date pofDteSaisi, String pofOpeMatricule, String pofObs) {
		this.pofNum = pofNum;
		this.pofDacCode = pofDacCode;
		this.pofLaaId = pofLaaId;
		this.pofOpdNum = pofOpdNum;
		this.pofOpdTpoCode = pofOpdTpoCode;
		this.pofDofNum = pofDofNum;
		this.pofPresent = pofPresent;
		this.pofConforme = pofConforme;
		this.pofTypeAct = pofTypeAct;
		this.pofDteSaisi = pofDteSaisi;
		this.pofOpeMatricule = pofOpeMatricule;
		this.pofObs = pofObs;
	}

	@Column(name = "POF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPofNum() {
		return this.pofNum;
	}

	public void setPofNum(BigDecimal pofNum) {
		this.pofNum = pofNum;
	}

	@Column(name = "POF_DAC_CODE", length = 25)
	public String getPofDacCode() {
		return this.pofDacCode;
	}

	public void setPofDacCode(String pofDacCode) {
		this.pofDacCode = pofDacCode;
	}

	@Column(name = "POF_LAA_ID", precision = 22, scale = 0)
	public BigDecimal getPofLaaId() {
		return this.pofLaaId;
	}

	public void setPofLaaId(BigDecimal pofLaaId) {
		this.pofLaaId = pofLaaId;
	}

	@Column(name = "POF_OPD_NUM", precision = 22, scale = 0)
	public BigDecimal getPofOpdNum() {
		return this.pofOpdNum;
	}

	public void setPofOpdNum(BigDecimal pofOpdNum) {
		this.pofOpdNum = pofOpdNum;
	}

	@Column(name = "POF_OPD_TPO_CODE", length = 10)
	public String getPofOpdTpoCode() {
		return this.pofOpdTpoCode;
	}

	public void setPofOpdTpoCode(String pofOpdTpoCode) {
		this.pofOpdTpoCode = pofOpdTpoCode;
	}

	@Column(name = "POF_DOF_NUM", precision = 22, scale = 0)
	public BigDecimal getPofDofNum() {
		return this.pofDofNum;
	}

	public void setPofDofNum(BigDecimal pofDofNum) {
		this.pofDofNum = pofDofNum;
	}

	@Column(name = "POF_PRESENT", length = 1)
	public String getPofPresent() {
		return this.pofPresent;
	}

	public void setPofPresent(String pofPresent) {
		this.pofPresent = pofPresent;
	}

	@Column(name = "POF_CONFORME", length = 1)
	public String getPofConforme() {
		return this.pofConforme;
	}

	public void setPofConforme(String pofConforme) {
		this.pofConforme = pofConforme;
	}

	@Column(name = "POF_TYPE_ACT", length = 10)
	public String getPofTypeAct() {
		return this.pofTypeAct;
	}

	public void setPofTypeAct(String pofTypeAct) {
		this.pofTypeAct = pofTypeAct;
	}

	@Column(name = "POF_DTE_SAISI", length = 7)
	public Date getPofDteSaisi() {
		return this.pofDteSaisi;
	}

	public void setPofDteSaisi(Date pofDteSaisi) {
		this.pofDteSaisi = pofDteSaisi;
	}

	@Column(name = "POF_OPE_MATRICULE", length = 25)
	public String getPofOpeMatricule() {
		return this.pofOpeMatricule;
	}

	public void setPofOpeMatricule(String pofOpeMatricule) {
		this.pofOpeMatricule = pofOpeMatricule;
	}

	@Column(name = "POF_OBS", length = 500)
	public String getPofObs() {
		return this.pofObs;
	}

	public void setPofObs(String pofObs) {
		this.pofObs = pofObs;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbPiecesOffresId))
			return false;
		VbPiecesOffresId castOther = (VbPiecesOffresId) other;

		return ((this.getPofNum() == castOther.getPofNum()) || (this.getPofNum() != null
				&& castOther.getPofNum() != null && this.getPofNum().equals(castOther.getPofNum())))
				&& ((this.getPofDacCode() == castOther.getPofDacCode()) || (this.getPofDacCode() != null
						&& castOther.getPofDacCode() != null && this.getPofDacCode().equals(castOther.getPofDacCode())))
				&& ((this.getPofLaaId() == castOther.getPofLaaId()) || (this.getPofLaaId() != null
						&& castOther.getPofLaaId() != null && this.getPofLaaId().equals(castOther.getPofLaaId())))
				&& ((this.getPofOpdNum() == castOther.getPofOpdNum()) || (this.getPofOpdNum() != null
						&& castOther.getPofOpdNum() != null && this.getPofOpdNum().equals(castOther.getPofOpdNum())))
				&& ((this.getPofOpdTpoCode() == castOther.getPofOpdTpoCode())
						|| (this.getPofOpdTpoCode() != null && castOther.getPofOpdTpoCode() != null
								&& this.getPofOpdTpoCode().equals(castOther.getPofOpdTpoCode())))
				&& ((this.getPofDofNum() == castOther.getPofDofNum()) || (this.getPofDofNum() != null
						&& castOther.getPofDofNum() != null && this.getPofDofNum().equals(castOther.getPofDofNum())))
				&& ((this.getPofPresent() == castOther.getPofPresent()) || (this.getPofPresent() != null
						&& castOther.getPofPresent() != null && this.getPofPresent().equals(castOther.getPofPresent())))
				&& ((this.getPofConforme() == castOther.getPofConforme())
						|| (this.getPofConforme() != null && castOther.getPofConforme() != null
								&& this.getPofConforme().equals(castOther.getPofConforme())))
				&& ((this.getPofTypeAct() == castOther.getPofTypeAct()) || (this.getPofTypeAct() != null
						&& castOther.getPofTypeAct() != null && this.getPofTypeAct().equals(castOther.getPofTypeAct())))
				&& ((this.getPofDteSaisi() == castOther.getPofDteSaisi())
						|| (this.getPofDteSaisi() != null && castOther.getPofDteSaisi() != null
								&& this.getPofDteSaisi().equals(castOther.getPofDteSaisi())))
				&& ((this.getPofOpeMatricule() == castOther.getPofOpeMatricule())
						|| (this.getPofOpeMatricule() != null && castOther.getPofOpeMatricule() != null
								&& this.getPofOpeMatricule().equals(castOther.getPofOpeMatricule())))
				&& ((this.getPofObs() == castOther.getPofObs()) || (this.getPofObs() != null
						&& castOther.getPofObs() != null && this.getPofObs().equals(castOther.getPofObs())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPofNum() == null ? 0 : this.getPofNum().hashCode());
		result = 37 * result + (getPofDacCode() == null ? 0 : this.getPofDacCode().hashCode());
		result = 37 * result + (getPofLaaId() == null ? 0 : this.getPofLaaId().hashCode());
		result = 37 * result + (getPofOpdNum() == null ? 0 : this.getPofOpdNum().hashCode());
		result = 37 * result + (getPofOpdTpoCode() == null ? 0 : this.getPofOpdTpoCode().hashCode());
		result = 37 * result + (getPofDofNum() == null ? 0 : this.getPofDofNum().hashCode());
		result = 37 * result + (getPofPresent() == null ? 0 : this.getPofPresent().hashCode());
		result = 37 * result + (getPofConforme() == null ? 0 : this.getPofConforme().hashCode());
		result = 37 * result + (getPofTypeAct() == null ? 0 : this.getPofTypeAct().hashCode());
		result = 37 * result + (getPofDteSaisi() == null ? 0 : this.getPofDteSaisi().hashCode());
		result = 37 * result + (getPofOpeMatricule() == null ? 0 : this.getPofOpeMatricule().hashCode());
		result = 37 * result + (getPofObs() == null ? 0 : this.getPofObs().hashCode());
		return result;
	}

}
