package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbGestion generated by hbm2java
 */
@Entity
@Table(name = "VB_GESTION", schema = "EMAP")
public class VbGestion implements java.io.Serializable {

	private VbGestionId id;

	public VbGestion() {
	}

	public VbGestion(VbGestionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "gesCode", column = @Column(name = "GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "gesDateDebut", column = @Column(name = "GES_DATE_DEBUT", length = 7)),
			@AttributeOverride(name = "gesDateFin", column = @Column(name = "GES_DATE_FIN", length = 7)) })
	public VbGestionId getId() {
		return this.id;
	}

	public void setId(VbGestionId id) {
		this.id = id;
	}

}
