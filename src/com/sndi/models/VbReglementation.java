package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbReglementation generated by hbm2java
 */
@Entity
@Table(name = "VB_REGLEMENTATION", schema = "EMAP")
public class VbReglementation implements java.io.Serializable {

	private VbReglementationId id;

	public VbReglementation() {
	}

	public VbReglementation(VbReglementationId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "regId", column = @Column(name = "REG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "regLibelleCourt", column = @Column(name = "REG_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "regLibelleLong", column = @Column(name = "REG_LIBELLE_LONG", length = 1000)) })
	public VbReglementationId getId() {
		return this.id;
	}

	public void setId(VbReglementationId id) {
		this.id = id;
	}

}
