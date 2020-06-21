package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbAvisPresel generated by hbm2java
 */
@Entity
@Table(name = "VB_AVIS_PRESEL", schema = "EMAP")
public class VbAvisPresel implements java.io.Serializable {

	private VbAvisPreselId id;

	public VbAvisPresel() {
	}

	public VbAvisPresel(VbAvisPreselId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "aprNum", column = @Column(name = "APR_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "aprDemNum", column = @Column(name = "APR_DEM_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "aprType", column = @Column(name = "APR_TYPE", length = 1)),
			@AttributeOverride(name = "aprSouNcc", column = @Column(name = "APR_SOU_NCC", length = 20)),
			@AttributeOverride(name = "aprModeInvit", column = @Column(name = "APR_MODE_INVIT", length = 100)),
			@AttributeOverride(name = "aprDetailInvit", column = @Column(name = "APR_DETAIL_INVIT", length = 2)),
			@AttributeOverride(name = "aprDteSaisi", column = @Column(name = "APR_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "aprOpeMatricule", column = @Column(name = "APR_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "aprDteModif", column = @Column(name = "APR_DTE_MODIF", length = 7)),
			@AttributeOverride(name = "aprOpeMatMotif", column = @Column(name = "APR_OPE_MAT_MOTIF", length = 25)),
			@AttributeOverride(name = "aprMtInit", column = @Column(name = "APR_MT_INIT", precision = 20, scale = 0)),
			@AttributeOverride(name = "aprMtDef", column = @Column(name = "APR_MT_DEF", precision = 20, scale = 0)),
			@AttributeOverride(name = "aprRet", column = @Column(name = "APR_RET", length = 1)) })
	public VbAvisPreselId getId() {
		return this.id;
	}

	public void setId(VbAvisPreselId id) {
		this.id = id;
	}

}
