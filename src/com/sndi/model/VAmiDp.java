package com.sndi.model;
// Generated 14 d�c. 2020 17:22:06 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VAmiDpId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_AMI_DP")
public class VAmiDp implements java.io.Serializable {

	private long dppId;
	private String dppObjet;
	private String dppTypePlan;
	private String dppPartiePmePmi;
	private String dppStructureBenefi;
	private String dppStructureConduc;
	private String dppTypeStrConduc;
	private String dppStatutAno;
	private String dppNatInt;
	private String dppBailleur;
	private String dppTymCode;
	private String dppMopCode;
	private String dppNbOuv;

	public VAmiDp() {
	}

	public VAmiDp(long dppId) {
		this.dppId = dppId;
	}

	public VAmiDp(long dppId, String dppObjet, String dppTypePlan,String dppPartiePmePmi, String dppStructureBenefi,
			String dppStructureConduc, String dppTypeStrConduc, String dppStatutAno, String dppNatInt,
			String dppBailleur, String dppTymCode, String dppMopCode, String dppNbOuv) {
		this.dppId = dppId;
		this.dppObjet = dppObjet;
		this.dppTypePlan = dppTypePlan;
		this.dppPartiePmePmi = dppPartiePmePmi;
		this.dppStructureBenefi = dppStructureBenefi;
		this.dppStructureConduc = dppStructureConduc;
		this.dppTypeStrConduc = dppTypeStrConduc;
		this.dppStatutAno = dppStatutAno;
		this.dppNatInt = dppNatInt;
		this.dppBailleur = dppBailleur;
		this.dppTymCode = dppTymCode;
		this.dppMopCode = dppMopCode;
		this.dppNbOuv = dppNbOuv;
	}

	@Id
	@Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getDppId() {
		return this.dppId;
	}

	public void setDppId(long dppId) {
		this.dppId = dppId;
	}

	@Column(name = "DPP_OBJET", length = 1000)
	public String getDppObjet() {
		return this.dppObjet;
	}

	public void setDppObjet(String dppObjet) {
		this.dppObjet = dppObjet;
	}
	
	@Column(name = "DPP_TYPE_PLAN", nullable = false, length = 3)
	public String getDppTypePlan() {
		return this.dppTypePlan;
	}

	public void setDppTypePlan(String dppTypePlan) {
		this.dppTypePlan = dppTypePlan;
	}
	
	@Column(name = "DPP_PARTIE_PME_PMI", length = 1)
	public String getDppPartiePmePmi() {
		return this.dppPartiePmePmi;
	}

	public void setDppPartiePmePmi(String dppPartiePmePmi) {
		this.dppPartiePmePmi = dppPartiePmePmi;
	}

	@Column(name = "DPP_STRUCTURE_BENEFI", length = 500)
	public String getDppStructureBenefi() {
		return this.dppStructureBenefi;
	}

	public void setDppStructureBenefi(String dppStructureBenefi) {
		this.dppStructureBenefi = dppStructureBenefi;
	}

	@Column(name = "DPP_STRUCTURE_CONDUC", length = 500)
	public String getDppStructureConduc() {
		return this.dppStructureConduc;
	}

	public void setDppStructureConduc(String dppStructureConduc) {
		this.dppStructureConduc = dppStructureConduc;
	}

	@Column(name = "DPP_TYPE_STR_CONDUC", length = 50)
	public String getDppTypeStrConduc() {
		return this.dppTypeStrConduc;
	}

	public void setDppTypeStrConduc(String dppTypeStrConduc) {
		this.dppTypeStrConduc = dppTypeStrConduc;
	}

	@Column(name = "DPP_STATUT_ANO", length = 3)
	public String getDppStatutAno() {
		return this.dppStatutAno;
	}

	public void setDppStatutAno(String dppStatutAno) {
		this.dppStatutAno = dppStatutAno;
	}

	@Column(name = "DPP_NAT_INT", length = 3)
	public String getDppNatInt() {
		return this.dppNatInt;
	}

	public void setDppNatInt(String dppNatInt) {
		this.dppNatInt = dppNatInt;
	}

	@Column(name = "DPP_BAILLEUR", length = 1)
	public String getDppBailleur() {
		return this.dppBailleur;
	}

	public void setDppBailleur(String dppBailleur) {
		this.dppBailleur = dppBailleur;
	}

	@Column(name = "DPP_TYM_CODE", nullable = false, length = 3)
	public String getDppTymCode() {
		return this.dppTymCode;
	}

	public void setDppTymCode(String dppTymCode) {
		this.dppTymCode = dppTymCode;
	}

	@Column(name = "DPP_MOP_CODE", nullable = false, length = 3)
	public String getDppMopCode() {
		return this.dppMopCode;
	}

	public void setDppMopCode(String dppMopCode) {
		this.dppMopCode = dppMopCode;
	}
	
	@Column(name = "DPP_NB_OUV")
	public String getDppNbOuv() {
		return this.dppNbOuv;
	}

	public void setDppNbOuv(String dppNbOuv) {
		this.dppNbOuv = dppNbOuv;
	}
}
