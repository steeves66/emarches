package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTempParamDetOffresId generated by hbm2java
 */
@Embeddable
public class VbTempParamDetOffresId implements java.io.Serializable {

	private BigDecimal tempNum;
	private Date dofDteSaisi;
	private String dofOpeMatricule;
	private String tempType;
	private String dofLaaAaoCode;
	private String dofLaaId;
	private String dofDelai;
	private String dofOffCnps;
	private String dofOffImpot;
	private String dofOffRc;
	private String dofCaut;
	private String dofTyp;
	private String dofBanCode;
	private String dofEstimRab;
	private String dofRab;
	private String dofMtOfr;
	private String dofOffNum;
	private String dofNum;
	private String dofNomRep;
	private String dofPreRep;
	private String dofTelRep;
	private String dofMailRep;
	private String dofSouNcc;
	private String dofSigle;

	public VbTempParamDetOffresId() {
	}

	public VbTempParamDetOffresId(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParamDetOffresId(BigDecimal tempNum, Date dofDteSaisi, String dofOpeMatricule, String tempType,
			String dofLaaAaoCode, String dofLaaId, String dofDelai, String dofOffCnps, String dofOffImpot,
			String dofOffRc, String dofCaut, String dofTyp, String dofBanCode, String dofEstimRab, String dofRab,
			String dofMtOfr, String dofOffNum, String dofNum, String dofNomRep, String dofPreRep, String dofTelRep,
			String dofMailRep, String dofSouNcc, String dofSigle) {
		this.tempNum = tempNum;
		this.dofDteSaisi = dofDteSaisi;
		this.dofOpeMatricule = dofOpeMatricule;
		this.tempType = tempType;
		this.dofLaaAaoCode = dofLaaAaoCode;
		this.dofLaaId = dofLaaId;
		this.dofDelai = dofDelai;
		this.dofOffCnps = dofOffCnps;
		this.dofOffImpot = dofOffImpot;
		this.dofOffRc = dofOffRc;
		this.dofCaut = dofCaut;
		this.dofTyp = dofTyp;
		this.dofBanCode = dofBanCode;
		this.dofEstimRab = dofEstimRab;
		this.dofRab = dofRab;
		this.dofMtOfr = dofMtOfr;
		this.dofOffNum = dofOffNum;
		this.dofNum = dofNum;
		this.dofNomRep = dofNomRep;
		this.dofPreRep = dofPreRep;
		this.dofTelRep = dofTelRep;
		this.dofMailRep = dofMailRep;
		this.dofSouNcc = dofSouNcc;
		this.dofSigle = dofSigle;
	}

	@Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTempNum() {
		return this.tempNum;
	}

	public void setTempNum(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	@Column(name = "DOF_DTE_SAISI", length = 7)
	public Date getDofDteSaisi() {
		return this.dofDteSaisi;
	}

	public void setDofDteSaisi(Date dofDteSaisi) {
		this.dofDteSaisi = dofDteSaisi;
	}

	@Column(name = "DOF_OPE_MATRICULE", length = 500)
	public String getDofOpeMatricule() {
		return this.dofOpeMatricule;
	}

	public void setDofOpeMatricule(String dofOpeMatricule) {
		this.dofOpeMatricule = dofOpeMatricule;
	}

	@Column(name = "TEMP_TYPE", length = 500)
	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	@Column(name = "DOF_LAA_AAO_CODE", length = 500)
	public String getDofLaaAaoCode() {
		return this.dofLaaAaoCode;
	}

	public void setDofLaaAaoCode(String dofLaaAaoCode) {
		this.dofLaaAaoCode = dofLaaAaoCode;
	}

	@Column(name = "DOF_LAA_ID", length = 500)
	public String getDofLaaId() {
		return this.dofLaaId;
	}

	public void setDofLaaId(String dofLaaId) {
		this.dofLaaId = dofLaaId;
	}

	@Column(name = "DOF_DELAI", length = 500)
	public String getDofDelai() {
		return this.dofDelai;
	}

	public void setDofDelai(String dofDelai) {
		this.dofDelai = dofDelai;
	}

	@Column(name = "DOF_OFF_CNPS", length = 500)
	public String getDofOffCnps() {
		return this.dofOffCnps;
	}

	public void setDofOffCnps(String dofOffCnps) {
		this.dofOffCnps = dofOffCnps;
	}

	@Column(name = "DOF_OFF_IMPOT", length = 500)
	public String getDofOffImpot() {
		return this.dofOffImpot;
	}

	public void setDofOffImpot(String dofOffImpot) {
		this.dofOffImpot = dofOffImpot;
	}

	@Column(name = "DOF_OFF_RC", length = 500)
	public String getDofOffRc() {
		return this.dofOffRc;
	}

	public void setDofOffRc(String dofOffRc) {
		this.dofOffRc = dofOffRc;
	}

	@Column(name = "DOF_CAUT", length = 500)
	public String getDofCaut() {
		return this.dofCaut;
	}

	public void setDofCaut(String dofCaut) {
		this.dofCaut = dofCaut;
	}

	@Column(name = "DOF_TYP", length = 500)
	public String getDofTyp() {
		return this.dofTyp;
	}

	public void setDofTyp(String dofTyp) {
		this.dofTyp = dofTyp;
	}

	@Column(name = "DOF_BAN_CODE", length = 500)
	public String getDofBanCode() {
		return this.dofBanCode;
	}

	public void setDofBanCode(String dofBanCode) {
		this.dofBanCode = dofBanCode;
	}

	@Column(name = "DOF_ESTIM_RAB", length = 500)
	public String getDofEstimRab() {
		return this.dofEstimRab;
	}

	public void setDofEstimRab(String dofEstimRab) {
		this.dofEstimRab = dofEstimRab;
	}

	@Column(name = "DOF_RAB", length = 500)
	public String getDofRab() {
		return this.dofRab;
	}

	public void setDofRab(String dofRab) {
		this.dofRab = dofRab;
	}

	@Column(name = "DOF_MT_OFR", length = 500)
	public String getDofMtOfr() {
		return this.dofMtOfr;
	}

	public void setDofMtOfr(String dofMtOfr) {
		this.dofMtOfr = dofMtOfr;
	}

	@Column(name = "DOF_OFF_NUM", length = 500)
	public String getDofOffNum() {
		return this.dofOffNum;
	}

	public void setDofOffNum(String dofOffNum) {
		this.dofOffNum = dofOffNum;
	}

	@Column(name = "DOF_NUM", length = 500)
	public String getDofNum() {
		return this.dofNum;
	}

	public void setDofNum(String dofNum) {
		this.dofNum = dofNum;
	}

	@Column(name = "DOF_NOM_REP", length = 500)
	public String getDofNomRep() {
		return this.dofNomRep;
	}

	public void setDofNomRep(String dofNomRep) {
		this.dofNomRep = dofNomRep;
	}

	@Column(name = "DOF_PRE_REP", length = 500)
	public String getDofPreRep() {
		return this.dofPreRep;
	}

	public void setDofPreRep(String dofPreRep) {
		this.dofPreRep = dofPreRep;
	}

	@Column(name = "DOF_TEL_REP", length = 500)
	public String getDofTelRep() {
		return this.dofTelRep;
	}

	public void setDofTelRep(String dofTelRep) {
		this.dofTelRep = dofTelRep;
	}

	@Column(name = "DOF_MAIL_REP", length = 500)
	public String getDofMailRep() {
		return this.dofMailRep;
	}

	public void setDofMailRep(String dofMailRep) {
		this.dofMailRep = dofMailRep;
	}

	@Column(name = "DOF_SOU_NCC", length = 500)
	public String getDofSouNcc() {
		return this.dofSouNcc;
	}

	public void setDofSouNcc(String dofSouNcc) {
		this.dofSouNcc = dofSouNcc;
	}

	@Column(name = "DOF_SIGLE", length = 500)
	public String getDofSigle() {
		return this.dofSigle;
	}

	public void setDofSigle(String dofSigle) {
		this.dofSigle = dofSigle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTempParamDetOffresId))
			return false;
		VbTempParamDetOffresId castOther = (VbTempParamDetOffresId) other;

		return ((this.getTempNum() == castOther.getTempNum()) || (this.getTempNum() != null
				&& castOther.getTempNum() != null && this.getTempNum().equals(castOther.getTempNum())))
				&& ((this.getDofDteSaisi() == castOther.getDofDteSaisi())
						|| (this.getDofDteSaisi() != null && castOther.getDofDteSaisi() != null
								&& this.getDofDteSaisi().equals(castOther.getDofDteSaisi())))
				&& ((this.getDofOpeMatricule() == castOther.getDofOpeMatricule())
						|| (this.getDofOpeMatricule() != null && castOther.getDofOpeMatricule() != null
								&& this.getDofOpeMatricule().equals(castOther.getDofOpeMatricule())))
				&& ((this.getTempType() == castOther.getTempType()) || (this.getTempType() != null
						&& castOther.getTempType() != null && this.getTempType().equals(castOther.getTempType())))
				&& ((this.getDofLaaAaoCode() == castOther.getDofLaaAaoCode())
						|| (this.getDofLaaAaoCode() != null && castOther.getDofLaaAaoCode() != null
								&& this.getDofLaaAaoCode().equals(castOther.getDofLaaAaoCode())))
				&& ((this.getDofLaaId() == castOther.getDofLaaId()) || (this.getDofLaaId() != null
						&& castOther.getDofLaaId() != null && this.getDofLaaId().equals(castOther.getDofLaaId())))
				&& ((this.getDofDelai() == castOther.getDofDelai()) || (this.getDofDelai() != null
						&& castOther.getDofDelai() != null && this.getDofDelai().equals(castOther.getDofDelai())))
				&& ((this.getDofOffCnps() == castOther.getDofOffCnps()) || (this.getDofOffCnps() != null
						&& castOther.getDofOffCnps() != null && this.getDofOffCnps().equals(castOther.getDofOffCnps())))
				&& ((this.getDofOffImpot() == castOther.getDofOffImpot())
						|| (this.getDofOffImpot() != null && castOther.getDofOffImpot() != null
								&& this.getDofOffImpot().equals(castOther.getDofOffImpot())))
				&& ((this.getDofOffRc() == castOther.getDofOffRc()) || (this.getDofOffRc() != null
						&& castOther.getDofOffRc() != null && this.getDofOffRc().equals(castOther.getDofOffRc())))
				&& ((this.getDofCaut() == castOther.getDofCaut()) || (this.getDofCaut() != null
						&& castOther.getDofCaut() != null && this.getDofCaut().equals(castOther.getDofCaut())))
				&& ((this.getDofTyp() == castOther.getDofTyp()) || (this.getDofTyp() != null
						&& castOther.getDofTyp() != null && this.getDofTyp().equals(castOther.getDofTyp())))
				&& ((this.getDofBanCode() == castOther.getDofBanCode()) || (this.getDofBanCode() != null
						&& castOther.getDofBanCode() != null && this.getDofBanCode().equals(castOther.getDofBanCode())))
				&& ((this.getDofEstimRab() == castOther.getDofEstimRab())
						|| (this.getDofEstimRab() != null && castOther.getDofEstimRab() != null
								&& this.getDofEstimRab().equals(castOther.getDofEstimRab())))
				&& ((this.getDofRab() == castOther.getDofRab()) || (this.getDofRab() != null
						&& castOther.getDofRab() != null && this.getDofRab().equals(castOther.getDofRab())))
				&& ((this.getDofMtOfr() == castOther.getDofMtOfr()) || (this.getDofMtOfr() != null
						&& castOther.getDofMtOfr() != null && this.getDofMtOfr().equals(castOther.getDofMtOfr())))
				&& ((this.getDofOffNum() == castOther.getDofOffNum()) || (this.getDofOffNum() != null
						&& castOther.getDofOffNum() != null && this.getDofOffNum().equals(castOther.getDofOffNum())))
				&& ((this.getDofNum() == castOther.getDofNum()) || (this.getDofNum() != null
						&& castOther.getDofNum() != null && this.getDofNum().equals(castOther.getDofNum())))
				&& ((this.getDofNomRep() == castOther.getDofNomRep()) || (this.getDofNomRep() != null
						&& castOther.getDofNomRep() != null && this.getDofNomRep().equals(castOther.getDofNomRep())))
				&& ((this.getDofPreRep() == castOther.getDofPreRep()) || (this.getDofPreRep() != null
						&& castOther.getDofPreRep() != null && this.getDofPreRep().equals(castOther.getDofPreRep())))
				&& ((this.getDofTelRep() == castOther.getDofTelRep()) || (this.getDofTelRep() != null
						&& castOther.getDofTelRep() != null && this.getDofTelRep().equals(castOther.getDofTelRep())))
				&& ((this.getDofMailRep() == castOther.getDofMailRep()) || (this.getDofMailRep() != null
						&& castOther.getDofMailRep() != null && this.getDofMailRep().equals(castOther.getDofMailRep())))
				&& ((this.getDofSouNcc() == castOther.getDofSouNcc()) || (this.getDofSouNcc() != null
						&& castOther.getDofSouNcc() != null && this.getDofSouNcc().equals(castOther.getDofSouNcc())))
				&& ((this.getDofSigle() == castOther.getDofSigle()) || (this.getDofSigle() != null
						&& castOther.getDofSigle() != null && this.getDofSigle().equals(castOther.getDofSigle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTempNum() == null ? 0 : this.getTempNum().hashCode());
		result = 37 * result + (getDofDteSaisi() == null ? 0 : this.getDofDteSaisi().hashCode());
		result = 37 * result + (getDofOpeMatricule() == null ? 0 : this.getDofOpeMatricule().hashCode());
		result = 37 * result + (getTempType() == null ? 0 : this.getTempType().hashCode());
		result = 37 * result + (getDofLaaAaoCode() == null ? 0 : this.getDofLaaAaoCode().hashCode());
		result = 37 * result + (getDofLaaId() == null ? 0 : this.getDofLaaId().hashCode());
		result = 37 * result + (getDofDelai() == null ? 0 : this.getDofDelai().hashCode());
		result = 37 * result + (getDofOffCnps() == null ? 0 : this.getDofOffCnps().hashCode());
		result = 37 * result + (getDofOffImpot() == null ? 0 : this.getDofOffImpot().hashCode());
		result = 37 * result + (getDofOffRc() == null ? 0 : this.getDofOffRc().hashCode());
		result = 37 * result + (getDofCaut() == null ? 0 : this.getDofCaut().hashCode());
		result = 37 * result + (getDofTyp() == null ? 0 : this.getDofTyp().hashCode());
		result = 37 * result + (getDofBanCode() == null ? 0 : this.getDofBanCode().hashCode());
		result = 37 * result + (getDofEstimRab() == null ? 0 : this.getDofEstimRab().hashCode());
		result = 37 * result + (getDofRab() == null ? 0 : this.getDofRab().hashCode());
		result = 37 * result + (getDofMtOfr() == null ? 0 : this.getDofMtOfr().hashCode());
		result = 37 * result + (getDofOffNum() == null ? 0 : this.getDofOffNum().hashCode());
		result = 37 * result + (getDofNum() == null ? 0 : this.getDofNum().hashCode());
		result = 37 * result + (getDofNomRep() == null ? 0 : this.getDofNomRep().hashCode());
		result = 37 * result + (getDofPreRep() == null ? 0 : this.getDofPreRep().hashCode());
		result = 37 * result + (getDofTelRep() == null ? 0 : this.getDofTelRep().hashCode());
		result = 37 * result + (getDofMailRep() == null ? 0 : this.getDofMailRep().hashCode());
		result = 37 * result + (getDofSouNcc() == null ? 0 : this.getDofSouNcc().hashCode());
		result = 37 * result + (getDofSigle() == null ? 0 : this.getDofSigle().hashCode());
		return result;
	}

}
