package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbPlanGeneral generated by hbm2java
 */
@Entity
@Table(name = "VB_PLAN_GENERAL", schema = "EMAP")
public class VbPlanGeneral implements java.io.Serializable {

	private VbPlanGeneralId id;

	public VbPlanGeneral() {
	}

	public VbPlanGeneral(VbPlanGeneralId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "plgId", column = @Column(name = "PLG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "plgStrCode", column = @Column(name = "PLG_STR_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "plgFonCod", column = @Column(name = "PLG_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "plgGesCode", column = @Column(name = "PLG_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "plgCode", column = @Column(name = "PLG_CODE", length = 50)),
			@AttributeOverride(name = "plgLibelle", column = @Column(name = "PLG_LIBELLE", length = 1000)) })
	public VbPlanGeneralId getId() {
		return this.id;
	}

	public void setId(VbPlanGeneralId id) {
		this.id = id;
	}

}
