package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbModePassation generated by hbm2java
 */
@Entity
@Table(name = "VB_MODE_PASSATION", schema = "EMAP")
public class VbModePassation implements java.io.Serializable {

	private VbModePassationId id;

	public VbModePassation() {
	}

	public VbModePassation(VbModePassationId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "mopCode", column = @Column(name = "MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "mopLibelleCourt", column = @Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)) })
	public VbModePassationId getId() {
		return this.id;
	}

	public void setId(VbModePassationId id) {
		this.id = id;
	}

}
