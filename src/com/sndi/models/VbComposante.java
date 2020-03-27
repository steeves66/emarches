package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbComposante generated by hbm2java
 */
@Entity
@Table(name = "VB_COMPOSANTE", schema = "EMAP")
public class VbComposante implements java.io.Serializable {

	private VbComposanteId id;

	public VbComposante() {
	}

	public VbComposante(VbComposanteId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "comId", column = @Column(name = "COM_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "comProId", column = @Column(name = "COM_PRO_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "comCode", column = @Column(name = "COM_CODE", length = 50)),
			@AttributeOverride(name = "comLibelleCourt", column = @Column(name = "COM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "comLibelleLong", column = @Column(name = "COM_LIBELLE_LONG", length = 1000)) })
	public VbComposanteId getId() {
		return this.id;
	}

	public void setId(VbComposanteId id) {
		this.id = id;
	}

}
