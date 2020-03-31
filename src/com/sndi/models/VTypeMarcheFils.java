package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VTypeMarcheFils generated by hbm2java
 */
@Entity
@Table(name = "V_TYPE_MARCHE_FILS", schema = "EMAP")
public class VTypeMarcheFils implements java.io.Serializable {

	private VTypeMarcheFilsId id;

	public VTypeMarcheFils() {
	}

	public VTypeMarcheFils(VTypeMarcheFilsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tymCode", column = @Column(name = "TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "tymLibelleLong", column = @Column(name = "TYM_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "tymTymCode", column = @Column(name = "TYM_TYM_CODE", length = 3)) })
	public VTypeMarcheFilsId getId() {
		return this.id;
	}

	public void setId(VTypeMarcheFilsId id) {
		this.id = id;
	}

}
