package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbMinistere generated by hbm2java
 */
@Entity
@Table(name = "VB_MINISTERE", schema = "EMAP")
public class VbMinistere implements java.io.Serializable {

	private VbMinistereId id;

	public VbMinistere() {
	}

	public VbMinistere(VbMinistereId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "minCode", column = @Column(name = "MIN_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "minLibelle", column = @Column(name = "MIN_LIBELLE", length = 1000)),
			@AttributeOverride(name = "minLibelleCourt", column = @Column(name = "MIN_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "minDescription", column = @Column(name = "MIN_DESCRIPTION", length = 1000)) })
	public VbMinistereId getId() {
		return this.id;
	}

	public void setId(VbMinistereId id) {
		this.id = id;
	}

}
