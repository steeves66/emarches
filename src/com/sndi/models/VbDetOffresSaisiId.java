package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDetOffresSaisiId generated by hbm2java
 */
@Embeddable
public class VbDetOffresSaisiId implements java.io.Serializable {

	private BigDecimal dofNum;
	private BigDecimal dofLaaId;
	private String dofLaaAaoCode;
	private BigDecimal dofOffNum;
	private String dofTyp;
	private BigDecimal dofDelai;
	private BigDecimal dofDelai2;
	private Long dofRangOfr;
	private BigDecimal dofMtCor;
	private BigDecimal dofMtOfr;
	private String dofRab;
	private BigDecimal dofEstimRab;
	private String dofBanCode;
	private String dofSeuil;
	private Short dofScore;
	private String dofRecevabl;
	private String dofRet;
	private String dofRetBai;
	private String dofRetDmp;
	private BigDecimal dofMtAtt;
	private String dofTot;
	private Date dofDteSaisi;
	private String dofFonCodeAc;
	private String dofOpeMatricule;

	public VbDetOffresSaisiId() {
	}

	public VbDetOffresSaisiId(BigDecimal dofNum, BigDecimal dofLaaId, String dofLaaAaoCode, BigDecimal dofOffNum,
			BigDecimal dofDelai) {
		this.dofNum = dofNum;
		this.dofLaaId = dofLaaId;
		this.dofLaaAaoCode = dofLaaAaoCode;
		this.dofOffNum = dofOffNum;
		this.dofDelai = dofDelai;
	}

	public VbDetOffresSaisiId(BigDecimal dofNum, BigDecimal dofLaaId, String dofLaaAaoCode, BigDecimal dofOffNum,
			String dofTyp, BigDecimal dofDelai, BigDecimal dofDelai2, Long dofRangOfr, BigDecimal dofMtCor,
			BigDecimal dofMtOfr, String dofRab, BigDecimal dofEstimRab, String dofBanCode, String dofSeuil,
			Short dofScore, String dofRecevabl, String dofRet, String dofRetBai, String dofRetDmp, BigDecimal dofMtAtt,
			String dofTot, Date dofDteSaisi, String dofFonCodeAc, String dofOpeMatricule) {
		this.dofNum = dofNum;
		this.dofLaaId = dofLaaId;
		this.dofLaaAaoCode = dofLaaAaoCode;
		this.dofOffNum = dofOffNum;
		this.dofTyp = dofTyp;
		this.dofDelai = dofDelai;
		this.dofDelai2 = dofDelai2;
		this.dofRangOfr = dofRangOfr;
		this.dofMtCor = dofMtCor;
		this.dofMtOfr = dofMtOfr;
		this.dofRab = dofRab;
		this.dofEstimRab = dofEstimRab;
		this.dofBanCode = dofBanCode;
		this.dofSeuil = dofSeuil;
		this.dofScore = dofScore;
		this.dofRecevabl = dofRecevabl;
		this.dofRet = dofRet;
		this.dofRetBai = dofRetBai;
		this.dofRetDmp = dofRetDmp;
		this.dofMtAtt = dofMtAtt;
		this.dofTot = dofTot;
		this.dofDteSaisi = dofDteSaisi;
		this.dofFonCodeAc = dofFonCodeAc;
		this.dofOpeMatricule = dofOpeMatricule;
	}

	@Column(name = "DOF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofNum() {
		return this.dofNum;
	}

	public void setDofNum(BigDecimal dofNum) {
		this.dofNum = dofNum;
	}

	@Column(name = "DOF_LAA_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofLaaId() {
		return this.dofLaaId;
	}

	public void setDofLaaId(BigDecimal dofLaaId) {
		this.dofLaaId = dofLaaId;
	}

	@Column(name = "DOF_LAA_AAO_CODE", nullable = false, length = 20)
	public String getDofLaaAaoCode() {
		return this.dofLaaAaoCode;
	}

	public void setDofLaaAaoCode(String dofLaaAaoCode) {
		this.dofLaaAaoCode = dofLaaAaoCode;
	}

	@Column(name = "DOF_OFF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofOffNum() {
		return this.dofOffNum;
	}

	public void setDofOffNum(BigDecimal dofOffNum) {
		this.dofOffNum = dofOffNum;
	}

	@Column(name = "DOF_TYP", length = 1)
	public String getDofTyp() {
		return this.dofTyp;
	}

	public void setDofTyp(String dofTyp) {
		this.dofTyp = dofTyp;
	}

	@Column(name = "DOF_DELAI", nullable = false, precision = 20, scale = 0)
	public BigDecimal getDofDelai() {
		return this.dofDelai;
	}

	public void setDofDelai(BigDecimal dofDelai) {
		this.dofDelai = dofDelai;
	}

	@Column(name = "DOF_DELAI2", precision = 20, scale = 0)
	public BigDecimal getDofDelai2() {
		return this.dofDelai2;
	}

	public void setDofDelai2(BigDecimal dofDelai2) {
		this.dofDelai2 = dofDelai2;
	}

	@Column(name = "DOF_RANG_OFR", precision = 10, scale = 0)
	public Long getDofRangOfr() {
		return this.dofRangOfr;
	}

	public void setDofRangOfr(Long dofRangOfr) {
		this.dofRangOfr = dofRangOfr;
	}

	@Column(name = "DOF_MT_COR", precision = 20, scale = 0)
	public BigDecimal getDofMtCor() {
		return this.dofMtCor;
	}

	public void setDofMtCor(BigDecimal dofMtCor) {
		this.dofMtCor = dofMtCor;
	}

	@Column(name = "DOF_MT_OFR", precision = 20, scale = 0)
	public BigDecimal getDofMtOfr() {
		return this.dofMtOfr;
	}

	public void setDofMtOfr(BigDecimal dofMtOfr) {
		this.dofMtOfr = dofMtOfr;
	}

	@Column(name = "DOF_RAB", length = 5)
	public String getDofRab() {
		return this.dofRab;
	}

	public void setDofRab(String dofRab) {
		this.dofRab = dofRab;
	}

	@Column(name = "DOF_ESTIM_RAB", precision = 20, scale = 0)
	public BigDecimal getDofEstimRab() {
		return this.dofEstimRab;
	}

	public void setDofEstimRab(BigDecimal dofEstimRab) {
		this.dofEstimRab = dofEstimRab;
	}

	@Column(name = "DOF_BAN_CODE", length = 10)
	public String getDofBanCode() {
		return this.dofBanCode;
	}

	public void setDofBanCode(String dofBanCode) {
		this.dofBanCode = dofBanCode;
	}

	@Column(name = "DOF_SEUIL", length = 1)
	public String getDofSeuil() {
		return this.dofSeuil;
	}

	public void setDofSeuil(String dofSeuil) {
		this.dofSeuil = dofSeuil;
	}

	@Column(name = "DOF_SCORE", precision = 3, scale = 0)
	public Short getDofScore() {
		return this.dofScore;
	}

	public void setDofScore(Short dofScore) {
		this.dofScore = dofScore;
	}

	@Column(name = "DOF_RECEVABL", length = 1)
	public String getDofRecevabl() {
		return this.dofRecevabl;
	}

	public void setDofRecevabl(String dofRecevabl) {
		this.dofRecevabl = dofRecevabl;
	}

	@Column(name = "DOF_RET", length = 1)
	public String getDofRet() {
		return this.dofRet;
	}

	public void setDofRet(String dofRet) {
		this.dofRet = dofRet;
	}

	@Column(name = "DOF_RET_BAI", length = 1)
	public String getDofRetBai() {
		return this.dofRetBai;
	}

	public void setDofRetBai(String dofRetBai) {
		this.dofRetBai = dofRetBai;
	}

	@Column(name = "DOF_RET_DMP", length = 1)
	public String getDofRetDmp() {
		return this.dofRetDmp;
	}

	public void setDofRetDmp(String dofRetDmp) {
		this.dofRetDmp = dofRetDmp;
	}

	@Column(name = "DOF_MT_ATT", precision = 20, scale = 0)
	public BigDecimal getDofMtAtt() {
		return this.dofMtAtt;
	}

	public void setDofMtAtt(BigDecimal dofMtAtt) {
		this.dofMtAtt = dofMtAtt;
	}

	@Column(name = "DOF_TOT", length = 2)
	public String getDofTot() {
		return this.dofTot;
	}

	public void setDofTot(String dofTot) {
		this.dofTot = dofTot;
	}

	@Column(name = "DOF_DTE_SAISI", length = 7)
	public Date getDofDteSaisi() {
		return this.dofDteSaisi;
	}

	public void setDofDteSaisi(Date dofDteSaisi) {
		this.dofDteSaisi = dofDteSaisi;
	}

	@Column(name = "DOF_FON_CODE_AC", length = 25)
	public String getDofFonCodeAc() {
		return this.dofFonCodeAc;
	}

	public void setDofFonCodeAc(String dofFonCodeAc) {
		this.dofFonCodeAc = dofFonCodeAc;
	}

	@Column(name = "DOF_OPE_MATRICULE", length = 25)
	public String getDofOpeMatricule() {
		return this.dofOpeMatricule;
	}

	public void setDofOpeMatricule(String dofOpeMatricule) {
		this.dofOpeMatricule = dofOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDetOffresSaisiId))
			return false;
		VbDetOffresSaisiId castOther = (VbDetOffresSaisiId) other;

		return ((this.getDofNum() == castOther.getDofNum()) || (this.getDofNum() != null
				&& castOther.getDofNum() != null && this.getDofNum().equals(castOther.getDofNum())))
				&& ((this.getDofLaaId() == castOther.getDofLaaId()) || (this.getDofLaaId() != null
						&& castOther.getDofLaaId() != null && this.getDofLaaId().equals(castOther.getDofLaaId())))
				&& ((this.getDofLaaAaoCode() == castOther.getDofLaaAaoCode())
						|| (this.getDofLaaAaoCode() != null && castOther.getDofLaaAaoCode() != null
								&& this.getDofLaaAaoCode().equals(castOther.getDofLaaAaoCode())))
				&& ((this.getDofOffNum() == castOther.getDofOffNum()) || (this.getDofOffNum() != null
						&& castOther.getDofOffNum() != null && this.getDofOffNum().equals(castOther.getDofOffNum())))
				&& ((this.getDofTyp() == castOther.getDofTyp()) || (this.getDofTyp() != null
						&& castOther.getDofTyp() != null && this.getDofTyp().equals(castOther.getDofTyp())))
				&& ((this.getDofDelai() == castOther.getDofDelai()) || (this.getDofDelai() != null
						&& castOther.getDofDelai() != null && this.getDofDelai().equals(castOther.getDofDelai())))
				&& ((this.getDofDelai2() == castOther.getDofDelai2()) || (this.getDofDelai2() != null
						&& castOther.getDofDelai2() != null && this.getDofDelai2().equals(castOther.getDofDelai2())))
				&& ((this.getDofRangOfr() == castOther.getDofRangOfr()) || (this.getDofRangOfr() != null
						&& castOther.getDofRangOfr() != null && this.getDofRangOfr().equals(castOther.getDofRangOfr())))
				&& ((this.getDofMtCor() == castOther.getDofMtCor()) || (this.getDofMtCor() != null
						&& castOther.getDofMtCor() != null && this.getDofMtCor().equals(castOther.getDofMtCor())))
				&& ((this.getDofMtOfr() == castOther.getDofMtOfr()) || (this.getDofMtOfr() != null
						&& castOther.getDofMtOfr() != null && this.getDofMtOfr().equals(castOther.getDofMtOfr())))
				&& ((this.getDofRab() == castOther.getDofRab()) || (this.getDofRab() != null
						&& castOther.getDofRab() != null && this.getDofRab().equals(castOther.getDofRab())))
				&& ((this.getDofEstimRab() == castOther.getDofEstimRab())
						|| (this.getDofEstimRab() != null && castOther.getDofEstimRab() != null
								&& this.getDofEstimRab().equals(castOther.getDofEstimRab())))
				&& ((this.getDofBanCode() == castOther.getDofBanCode()) || (this.getDofBanCode() != null
						&& castOther.getDofBanCode() != null && this.getDofBanCode().equals(castOther.getDofBanCode())))
				&& ((this.getDofSeuil() == castOther.getDofSeuil()) || (this.getDofSeuil() != null
						&& castOther.getDofSeuil() != null && this.getDofSeuil().equals(castOther.getDofSeuil())))
				&& ((this.getDofScore() == castOther.getDofScore()) || (this.getDofScore() != null
						&& castOther.getDofScore() != null && this.getDofScore().equals(castOther.getDofScore())))
				&& ((this.getDofRecevabl() == castOther.getDofRecevabl())
						|| (this.getDofRecevabl() != null && castOther.getDofRecevabl() != null
								&& this.getDofRecevabl().equals(castOther.getDofRecevabl())))
				&& ((this.getDofRet() == castOther.getDofRet()) || (this.getDofRet() != null
						&& castOther.getDofRet() != null && this.getDofRet().equals(castOther.getDofRet())))
				&& ((this.getDofRetBai() == castOther.getDofRetBai()) || (this.getDofRetBai() != null
						&& castOther.getDofRetBai() != null && this.getDofRetBai().equals(castOther.getDofRetBai())))
				&& ((this.getDofRetDmp() == castOther.getDofRetDmp()) || (this.getDofRetDmp() != null
						&& castOther.getDofRetDmp() != null && this.getDofRetDmp().equals(castOther.getDofRetDmp())))
				&& ((this.getDofMtAtt() == castOther.getDofMtAtt()) || (this.getDofMtAtt() != null
						&& castOther.getDofMtAtt() != null && this.getDofMtAtt().equals(castOther.getDofMtAtt())))
				&& ((this.getDofTot() == castOther.getDofTot()) || (this.getDofTot() != null
						&& castOther.getDofTot() != null && this.getDofTot().equals(castOther.getDofTot())))
				&& ((this.getDofDteSaisi() == castOther.getDofDteSaisi())
						|| (this.getDofDteSaisi() != null && castOther.getDofDteSaisi() != null
								&& this.getDofDteSaisi().equals(castOther.getDofDteSaisi())))
				&& ((this.getDofFonCodeAc() == castOther.getDofFonCodeAc())
						|| (this.getDofFonCodeAc() != null && castOther.getDofFonCodeAc() != null
								&& this.getDofFonCodeAc().equals(castOther.getDofFonCodeAc())))
				&& ((this.getDofOpeMatricule() == castOther.getDofOpeMatricule())
						|| (this.getDofOpeMatricule() != null && castOther.getDofOpeMatricule() != null
								&& this.getDofOpeMatricule().equals(castOther.getDofOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDofNum() == null ? 0 : this.getDofNum().hashCode());
		result = 37 * result + (getDofLaaId() == null ? 0 : this.getDofLaaId().hashCode());
		result = 37 * result + (getDofLaaAaoCode() == null ? 0 : this.getDofLaaAaoCode().hashCode());
		result = 37 * result + (getDofOffNum() == null ? 0 : this.getDofOffNum().hashCode());
		result = 37 * result + (getDofTyp() == null ? 0 : this.getDofTyp().hashCode());
		result = 37 * result + (getDofDelai() == null ? 0 : this.getDofDelai().hashCode());
		result = 37 * result + (getDofDelai2() == null ? 0 : this.getDofDelai2().hashCode());
		result = 37 * result + (getDofRangOfr() == null ? 0 : this.getDofRangOfr().hashCode());
		result = 37 * result + (getDofMtCor() == null ? 0 : this.getDofMtCor().hashCode());
		result = 37 * result + (getDofMtOfr() == null ? 0 : this.getDofMtOfr().hashCode());
		result = 37 * result + (getDofRab() == null ? 0 : this.getDofRab().hashCode());
		result = 37 * result + (getDofEstimRab() == null ? 0 : this.getDofEstimRab().hashCode());
		result = 37 * result + (getDofBanCode() == null ? 0 : this.getDofBanCode().hashCode());
		result = 37 * result + (getDofSeuil() == null ? 0 : this.getDofSeuil().hashCode());
		result = 37 * result + (getDofScore() == null ? 0 : this.getDofScore().hashCode());
		result = 37 * result + (getDofRecevabl() == null ? 0 : this.getDofRecevabl().hashCode());
		result = 37 * result + (getDofRet() == null ? 0 : this.getDofRet().hashCode());
		result = 37 * result + (getDofRetBai() == null ? 0 : this.getDofRetBai().hashCode());
		result = 37 * result + (getDofRetDmp() == null ? 0 : this.getDofRetDmp().hashCode());
		result = 37 * result + (getDofMtAtt() == null ? 0 : this.getDofMtAtt().hashCode());
		result = 37 * result + (getDofTot() == null ? 0 : this.getDofTot().hashCode());
		result = 37 * result + (getDofDteSaisi() == null ? 0 : this.getDofDteSaisi().hashCode());
		result = 37 * result + (getDofFonCodeAc() == null ? 0 : this.getDofFonCodeAc().hashCode());
		result = 37 * result + (getDofOpeMatricule() == null ? 0 : this.getDofOpeMatricule().hashCode());
		return result;
	}

}
