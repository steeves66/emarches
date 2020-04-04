package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTempParamDetOffres generated by hbm2java
 */
@Entity
@Table(name = "VB_TEMP_PARAM_DET_OFFRES", schema = "EMAP")
public class VbTempParamDetOffres implements java.io.Serializable {

	private VbTempParamDetOffresId id;

	public VbTempParamDetOffres() {
	}

	public VbTempParamDetOffres(VbTempParamDetOffresId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tempNum", column = @Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "dofDteSaisi", column = @Column(name = "DOF_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dofOpeMatricule", column = @Column(name = "DOF_OPE_MATRICULE", length = 500)),
			@AttributeOverride(name = "tempType", column = @Column(name = "TEMP_TYPE", length = 500)),
			@AttributeOverride(name = "dofLaaAaoCode", column = @Column(name = "DOF_LAA_AAO_CODE", length = 500)),
			@AttributeOverride(name = "dofLaaId", column = @Column(name = "DOF_LAA_ID", length = 500)),
			@AttributeOverride(name = "dofDelai", column = @Column(name = "DOF_DELAI", length = 500)),
			@AttributeOverride(name = "dofOffCnps", column = @Column(name = "DOF_OFF_CNPS", length = 500)),
			@AttributeOverride(name = "dofOffImpot", column = @Column(name = "DOF_OFF_IMPOT", length = 500)),
			@AttributeOverride(name = "dofOffRc", column = @Column(name = "DOF_OFF_RC", length = 500)),
			@AttributeOverride(name = "dofCaut", column = @Column(name = "DOF_CAUT", length = 500)),
			@AttributeOverride(name = "dofTyp", column = @Column(name = "DOF_TYP", length = 500)),
			@AttributeOverride(name = "dofBanCode", column = @Column(name = "DOF_BAN_CODE", length = 500)),
			@AttributeOverride(name = "dofEstimRab", column = @Column(name = "DOF_ESTIM_RAB", length = 500)),
			@AttributeOverride(name = "dofRab", column = @Column(name = "DOF_RAB", length = 500)),
			@AttributeOverride(name = "dofMtOfr", column = @Column(name = "DOF_MT_OFR", length = 500)),
			@AttributeOverride(name = "dofOffNum", column = @Column(name = "DOF_OFF_NUM", length = 500)),
			@AttributeOverride(name = "dofNum", column = @Column(name = "DOF_NUM", length = 500)),
			@AttributeOverride(name = "dofNomRep", column = @Column(name = "DOF_NOM_REP", length = 500)),
			@AttributeOverride(name = "dofPreRep", column = @Column(name = "DOF_PRE_REP", length = 500)),
			@AttributeOverride(name = "dofTelRep", column = @Column(name = "DOF_TEL_REP", length = 500)),
			@AttributeOverride(name = "dofMailRep", column = @Column(name = "DOF_MAIL_REP", length = 500)),
			@AttributeOverride(name = "dofSouNcc", column = @Column(name = "DOF_SOU_NCC", length = 500)) })
	public VbTempParamDetOffresId getId() {
		return this.id;
	}

	public void setId(VbTempParamDetOffresId id) {
		this.id = id;
	}

}
