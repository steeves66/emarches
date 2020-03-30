package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDetailDemandes generated by hbm2java
 */
@Entity
@Table(name = "VB_DETAIL_DEMANDES", schema = "EMAP")
public class VbDetailDemandes implements java.io.Serializable {

	private VbDetailDemandesId id;

	public VbDetailDemandes() {
	}

	public VbDetailDemandes(VbDetailDemandesId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "ddeNum", column = @Column(name = "DDE_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "ddeDemNum", column = @Column(name = "DDE_DEM_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "ddeDacCode", column = @Column(name = "DDE_DAC_CODE", length = 20)),
			@AttributeOverride(name = "ddeLaaId", column = @Column(name = "DDE_LAA_ID", precision = 4, scale = 0)),
			@AttributeOverride(name = "ddeLbgCode", column = @Column(name = "DDE_LBG_CODE", length = 50)),
			@AttributeOverride(name = "ddeMarCode", column = @Column(name = "DDE_MAR_CODE", length = 20)),
			@AttributeOverride(name = "ddeStrCode", column = @Column(name = "DDE_STR_CODE", length = 20)),
			@AttributeOverride(name = "ddeActNum", column = @Column(name = "DDE_ACT_NUM", length = 200)),
			@AttributeOverride(name = "ddeActNumIni", column = @Column(name = "DDE_ACT_NUM_INI", length = 200)) })
	public VbDetailDemandesId getId() {
		return this.id;
	}

	public void setId(VbDetailDemandesId id) {
		this.id = id;
	}

}
