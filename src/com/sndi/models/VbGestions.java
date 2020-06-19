package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbGestions generated by hbm2java
 */
@Entity
@Table(name = "VB_GESTIONS", schema = "EMAP")
public class VbGestions implements java.io.Serializable {

	private VbGestionsId id;

	public VbGestions() {
	}

	public VbGestions(VbGestionsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "gesCode", column = @Column(name = "GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "gesDateDebut", column = @Column(name = "GES_DATE_DEBUT", length = 7)),
			@AttributeOverride(name = "gesDateFin", column = @Column(name = "GES_DATE_FIN", length = 7)),
			@AttributeOverride(name = "gesCourant", column = @Column(name = "GES_COURANT", length = 1)),
			@AttributeOverride(name = "gesOpeMatricule", column = @Column(name = "GES_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "gesDteSaisi", column = @Column(name = "GES_DTE_SAISI", length = 7)) })
	public VbGestionsId getId() {
		return this.id;
	}

	public void setId(VbGestionsId id) {
		this.id = id;
	}

}
