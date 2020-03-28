package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTempParamVenteId generated by hbm2java
 */
@Embeddable
public class VbTempParamVenteId implements java.io.Serializable {

	private Serializable tempNum;
	private Serializable dofDteSaisi;
	private Serializable dofOpeMatricule;
	private Serializable tempType;
	private Serializable canCode;
	private Serializable canNom;
	private Serializable canNomResp;
	private Serializable canSouNcc;
	private Serializable canTel;
	private Serializable canTieNcc;
	private Serializable dveCout;
	private Serializable dveDacCode;
	private Serializable dveLaaNum;
	private Serializable dveQte;
	private Serializable venNum;
	private Serializable venMrgCod;
	private Serializable canPrenoms;

	public VbTempParamVenteId() {
	}

	public VbTempParamVenteId(Serializable tempNum, Serializable dofDteSaisi, Serializable dofOpeMatricule,
			Serializable tempType, Serializable canCode, Serializable canNom, Serializable canNomResp,
			Serializable canSouNcc, Serializable canTel, Serializable canTieNcc, Serializable dveCout,
			Serializable dveDacCode, Serializable dveLaaNum, Serializable dveQte, Serializable venNum,
			Serializable venMrgCod, Serializable canPrenoms) {
		this.tempNum = tempNum;
		this.dofDteSaisi = dofDteSaisi;
		this.dofOpeMatricule = dofOpeMatricule;
		this.tempType = tempType;
		this.canCode = canCode;
		this.canNom = canNom;
		this.canNomResp = canNomResp;
		this.canSouNcc = canSouNcc;
		this.canTel = canTel;
		this.canTieNcc = canTieNcc;
		this.dveCout = dveCout;
		this.dveDacCode = dveDacCode;
		this.dveLaaNum = dveLaaNum;
		this.dveQte = dveQte;
		this.venNum = venNum;
		this.venMrgCod = venMrgCod;
		this.canPrenoms = canPrenoms;
	}

	@Column(name = "TEMP_NUM")
	public Serializable getTempNum() {
		return this.tempNum;
	}

	public void setTempNum(Serializable tempNum) {
		this.tempNum = tempNum;
	}

	@Column(name = "DOF_DTE_SAISI")
	public Serializable getDofDteSaisi() {
		return this.dofDteSaisi;
	}

	public void setDofDteSaisi(Serializable dofDteSaisi) {
		this.dofDteSaisi = dofDteSaisi;
	}

	@Column(name = "DOF_OPE_MATRICULE")
	public Serializable getDofOpeMatricule() {
		return this.dofOpeMatricule;
	}

	public void setDofOpeMatricule(Serializable dofOpeMatricule) {
		this.dofOpeMatricule = dofOpeMatricule;
	}

	@Column(name = "TEMP_TYPE")
	public Serializable getTempType() {
		return this.tempType;
	}

	public void setTempType(Serializable tempType) {
		this.tempType = tempType;
	}

	@Column(name = "CAN_CODE")
	public Serializable getCanCode() {
		return this.canCode;
	}

	public void setCanCode(Serializable canCode) {
		this.canCode = canCode;
	}

	@Column(name = "CAN_NOM")
	public Serializable getCanNom() {
		return this.canNom;
	}

	public void setCanNom(Serializable canNom) {
		this.canNom = canNom;
	}

	@Column(name = "CAN_NOM_RESP")
	public Serializable getCanNomResp() {
		return this.canNomResp;
	}

	public void setCanNomResp(Serializable canNomResp) {
		this.canNomResp = canNomResp;
	}

	@Column(name = "CAN_SOU_NCC")
	public Serializable getCanSouNcc() {
		return this.canSouNcc;
	}

	public void setCanSouNcc(Serializable canSouNcc) {
		this.canSouNcc = canSouNcc;
	}

	@Column(name = "CAN_TEL")
	public Serializable getCanTel() {
		return this.canTel;
	}

	public void setCanTel(Serializable canTel) {
		this.canTel = canTel;
	}

	@Column(name = "CAN_TIE_NCC")
	public Serializable getCanTieNcc() {
		return this.canTieNcc;
	}

	public void setCanTieNcc(Serializable canTieNcc) {
		this.canTieNcc = canTieNcc;
	}

	@Column(name = "DVE_COUT")
	public Serializable getDveCout() {
		return this.dveCout;
	}

	public void setDveCout(Serializable dveCout) {
		this.dveCout = dveCout;
	}

	@Column(name = "DVE_DAC_CODE")
	public Serializable getDveDacCode() {
		return this.dveDacCode;
	}

	public void setDveDacCode(Serializable dveDacCode) {
		this.dveDacCode = dveDacCode;
	}

	@Column(name = "DVE_LAA_NUM")
	public Serializable getDveLaaNum() {
		return this.dveLaaNum;
	}

	public void setDveLaaNum(Serializable dveLaaNum) {
		this.dveLaaNum = dveLaaNum;
	}

	@Column(name = "DVE_QTE")
	public Serializable getDveQte() {
		return this.dveQte;
	}

	public void setDveQte(Serializable dveQte) {
		this.dveQte = dveQte;
	}

	@Column(name = "VEN_NUM")
	public Serializable getVenNum() {
		return this.venNum;
	}

	public void setVenNum(Serializable venNum) {
		this.venNum = venNum;
	}

	@Column(name = "VEN_MRG_COD")
	public Serializable getVenMrgCod() {
		return this.venMrgCod;
	}

	public void setVenMrgCod(Serializable venMrgCod) {
		this.venMrgCod = venMrgCod;
	}

	@Column(name = "CAN_PRENOMS")
	public Serializable getCanPrenoms() {
		return this.canPrenoms;
	}

	public void setCanPrenoms(Serializable canPrenoms) {
		this.canPrenoms = canPrenoms;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTempParamVenteId))
			return false;
		VbTempParamVenteId castOther = (VbTempParamVenteId) other;

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
				&& ((this.getCanCode() == castOther.getCanCode()) || (this.getCanCode() != null
						&& castOther.getCanCode() != null && this.getCanCode().equals(castOther.getCanCode())))
				&& ((this.getCanNom() == castOther.getCanNom()) || (this.getCanNom() != null
						&& castOther.getCanNom() != null && this.getCanNom().equals(castOther.getCanNom())))
				&& ((this.getCanNomResp() == castOther.getCanNomResp()) || (this.getCanNomResp() != null
						&& castOther.getCanNomResp() != null && this.getCanNomResp().equals(castOther.getCanNomResp())))
				&& ((this.getCanSouNcc() == castOther.getCanSouNcc()) || (this.getCanSouNcc() != null
						&& castOther.getCanSouNcc() != null && this.getCanSouNcc().equals(castOther.getCanSouNcc())))
				&& ((this.getCanTel() == castOther.getCanTel()) || (this.getCanTel() != null
						&& castOther.getCanTel() != null && this.getCanTel().equals(castOther.getCanTel())))
				&& ((this.getCanTieNcc() == castOther.getCanTieNcc()) || (this.getCanTieNcc() != null
						&& castOther.getCanTieNcc() != null && this.getCanTieNcc().equals(castOther.getCanTieNcc())))
				&& ((this.getDveCout() == castOther.getDveCout()) || (this.getDveCout() != null
						&& castOther.getDveCout() != null && this.getDveCout().equals(castOther.getDveCout())))
				&& ((this.getDveDacCode() == castOther.getDveDacCode()) || (this.getDveDacCode() != null
						&& castOther.getDveDacCode() != null && this.getDveDacCode().equals(castOther.getDveDacCode())))
				&& ((this.getDveLaaNum() == castOther.getDveLaaNum()) || (this.getDveLaaNum() != null
						&& castOther.getDveLaaNum() != null && this.getDveLaaNum().equals(castOther.getDveLaaNum())))
				&& ((this.getDveQte() == castOther.getDveQte()) || (this.getDveQte() != null
						&& castOther.getDveQte() != null && this.getDveQte().equals(castOther.getDveQte())))
				&& ((this.getVenNum() == castOther.getVenNum()) || (this.getVenNum() != null
						&& castOther.getVenNum() != null && this.getVenNum().equals(castOther.getVenNum())))
				&& ((this.getVenMrgCod() == castOther.getVenMrgCod()) || (this.getVenMrgCod() != null
						&& castOther.getVenMrgCod() != null && this.getVenMrgCod().equals(castOther.getVenMrgCod())))
				&& ((this.getCanPrenoms() == castOther.getCanPrenoms())
						|| (this.getCanPrenoms() != null && castOther.getCanPrenoms() != null
								&& this.getCanPrenoms().equals(castOther.getCanPrenoms())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTempNum() == null ? 0 : this.getTempNum().hashCode());
		result = 37 * result + (getDofDteSaisi() == null ? 0 : this.getDofDteSaisi().hashCode());
		result = 37 * result + (getDofOpeMatricule() == null ? 0 : this.getDofOpeMatricule().hashCode());
		result = 37 * result + (getTempType() == null ? 0 : this.getTempType().hashCode());
		result = 37 * result + (getCanCode() == null ? 0 : this.getCanCode().hashCode());
		result = 37 * result + (getCanNom() == null ? 0 : this.getCanNom().hashCode());
		result = 37 * result + (getCanNomResp() == null ? 0 : this.getCanNomResp().hashCode());
		result = 37 * result + (getCanSouNcc() == null ? 0 : this.getCanSouNcc().hashCode());
		result = 37 * result + (getCanTel() == null ? 0 : this.getCanTel().hashCode());
		result = 37 * result + (getCanTieNcc() == null ? 0 : this.getCanTieNcc().hashCode());
		result = 37 * result + (getDveCout() == null ? 0 : this.getDveCout().hashCode());
		result = 37 * result + (getDveDacCode() == null ? 0 : this.getDveDacCode().hashCode());
		result = 37 * result + (getDveLaaNum() == null ? 0 : this.getDveLaaNum().hashCode());
		result = 37 * result + (getDveQte() == null ? 0 : this.getDveQte().hashCode());
		result = 37 * result + (getVenNum() == null ? 0 : this.getVenNum().hashCode());
		result = 37 * result + (getVenMrgCod() == null ? 0 : this.getVenMrgCod().hashCode());
		result = 37 * result + (getCanPrenoms() == null ? 0 : this.getCanPrenoms().hashCode());
		return result;
	}

}
