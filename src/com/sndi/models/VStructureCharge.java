package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VStructureCharge generated by hbm2java
 */
@Entity
@Table(name = "V_STRUCTURE_CHARGE", schema = "EMAP")
public class VStructureCharge implements java.io.Serializable {

	private VStructureChargeId id;

	public VStructureCharge() {
	}

	public VStructureCharge(VStructureChargeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "chrId", column = @Column(name = "CHR_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "tycLibelleLong", column = @Column(name = "TYC_LIBELLE_LONG", length = 1000)) })
	public VStructureChargeId getId() {
		return this.id;
	}

	public void setId(VStructureChargeId id) {
		this.id = id;
	}

}
