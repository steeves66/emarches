package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbRegion generated by hbm2java
 */
@Entity
@Table(name = "VB_REGION", schema = "EMAP")
public class VbRegion implements java.io.Serializable {

	private VbRegionId id;

	public VbRegion() {
	}

	public VbRegion(VbRegionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "regCode", column = @Column(name = "REG_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "regLibelle", column = @Column(name = "REG_LIBELLE", length = 500)),
			@AttributeOverride(name = "regOpeMatricule", column = @Column(name = "REG_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "regDteSaisi", column = @Column(name = "REG_DTE_SAISI", length = 7)) })
	public VbRegionId getId() {
		return this.id;
	}

	public void setId(VbRegionId id) {
		this.id = id;
	}

}
