package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbObjectifSpec generated by hbm2java
 */
@Entity
@Table(name = "VB_OBJECTIF_SPEC", schema = "EMAP")
public class VbObjectifSpec implements java.io.Serializable {

	private VbObjectifSpecId id;

	public VbObjectifSpec() {
	}

	public VbObjectifSpec(VbObjectifSpecId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "obsId", column = @Column(name = "OBS_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "obsObgId", column = @Column(name = "OBS_OBG_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "obsCode", column = @Column(name = "OBS_CODE", length = 10)),
			@AttributeOverride(name = "obsLibelleCourt", column = @Column(name = "OBS_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "obsLibelleLong", column = @Column(name = "OBS_LIBELLE_LONG", length = 1000)) })
	public VbObjectifSpecId getId() {
		return this.id;
	}

	public void setId(VbObjectifSpecId id) {
		this.id = id;
	}

}