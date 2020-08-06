package com.sndi.model;
// Generated 12 mars 2020 15:51:36 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VbTempParamDetOffres generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "VB_TEMP_PARAM_DET_OFFRES")
public class VbTempParamDetOffres implements java.io.Serializable {

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
	private String dofObsVariante;
	private BigDecimal dofMtCaut;
	//private BigDecimal dofMtRab;
	private String dofMtRab;
	private String dofDelai2;

	public VbTempParamDetOffres() {
	}

	public VbTempParamDetOffres(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParamDetOffres(BigDecimal tempNum, Date dofDteSaisi, String dofOpeMatricule, String tempType,
			String dofLaaAaoCode, String dofLaaId, String dofDelai, String dofOffCnps, String dofOffImpot,
			String dofOffRc, String dofCaut, String dofTyp, String dofBanCode, String dofEstimRab, String dofRab,
			String dofMtOfr, String dofOffNum, String dofNum, String dofNomRep, String dofPreRep, String dofTelRep,
			String dofMailRep, String dofSouNcc, String dofSigle, String dofObsVariante, BigDecimal dofMtCaut,String dofMtRab, String dofDelai2) {
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
		this.dofObsVariante = dofObsVariante;
		this.dofMtCaut = dofMtCaut;
		this.dofMtRab = dofMtRab;
		this.dofDelai2 = dofDelai2;
	}

	@Id
	@SequenceGenerator(name = "SEQ_TEM_OFFRE_Sequence", sequenceName = "SEQ_TEM_OFFRE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TEM_OFFRE_Sequence")
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
	
	@Column(name = "DOF_OBS_VARIANTE", length = 500)
	public String getDofObsVariante() {
		return this.dofObsVariante;
	}

	public void setDofObsVariante(String dofObsVariante) {
		this.dofObsVariante = dofObsVariante;
	}

	
	@Column(name = "DOF_MT_CAUT", precision = 22, scale = 0)
	public BigDecimal getDofMtCaut() {
		return this.dofMtCaut;
	}

	public void setDofMtCaut(BigDecimal dofMtCaut) {
		this.dofMtCaut = dofMtCaut;
	}
	
	/*@Column(name = "DOF_MT_RAB", precision = 22, scale = 0)
	public BigDecimal getDofMtRab() {
		return this.dofMtRab; String
	}

	public void setDofMtRab(BigDecimal dofMtRab) {
		this.dofMtRab = dofMtRab;
	}*/
	
	@Column(name = "DOF_MT_RAB")
	public String getDofMtRab() {
		return this.dofMtRab; 
	}

	public void setDofMtRab(String dofMtRab) {
		this.dofMtRab = dofMtRab;
	}
	
	@Column(name = "DOF_DELAI2", length = 500)
	public String getDofDelai2() {
		return this.dofDelai2;
	}

	public void setDofDelai2(String dofDelai2) {
		this.dofDelai2 = dofDelai2;
	}

}
