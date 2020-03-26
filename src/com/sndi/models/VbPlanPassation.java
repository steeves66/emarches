package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbPlanPassation generated by hbm2java
 */
@Entity
@Table(name = "VB_PLAN_PASSATION", schema = "EMAP")
public class VbPlanPassation implements java.io.Serializable {

	private VbPlanPassationId id;

	public VbPlanPassation() {
	}

	public VbPlanPassation(VbPlanPassationId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "plpId", column = @Column(name = "PLP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "plpStrCode", column = @Column(name = "PLP_STR_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "plpFonCod", column = @Column(name = "PLP_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "plpGesCode", column = @Column(name = "PLP_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "plpCode", column = @Column(name = "PLP_CODE", length = 50)),
			@AttributeOverride(name = "plpLibelle", column = @Column(name = "PLP_LIBELLE", length = 1000)) })
	public VbPlanPassationId getId() {
		return this.id;
	}

	public void setId(VbPlanPassationId id) {
		this.id = id;
	}

}
