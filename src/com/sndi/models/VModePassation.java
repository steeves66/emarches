package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VModePassation generated by hbm2java
 */
@Entity
@Table(name = "V_MODE_PASSATION", schema = "EMAP")
public class VModePassation implements java.io.Serializable {

	private VModePassationId id;

	public VModePassation() {
	}

	public VModePassation(VModePassationId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "mopCode", column = @Column(name = "MOP_CODE", nullable = false, length = 10)),
			@AttributeOverride(name = "mopLibelleCourt", column = @Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "mopTypPlan", column = @Column(name = "MOP_TYP_PLAN", length = 10)) })
	public VModePassationId getId() {
		return this.id;
	}

	public void setId(VModePassationId id) {
		this.id = id;
	}

}
