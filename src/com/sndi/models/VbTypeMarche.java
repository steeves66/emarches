package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypeMarche generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_MARCHE", schema = "EMAP")
public class VbTypeMarche implements java.io.Serializable {

	private VbTypeMarcheId id;

	public VbTypeMarche() {
	}

	public VbTypeMarche(VbTypeMarcheId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tymCode", column = @Column(name = "TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "tymLibelleLong", column = @Column(name = "TYM_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "tymTymCode", column = @Column(name = "TYM_TYM_CODE", length = 3)),
			@AttributeOverride(name = "tymGroupe", column = @Column(name = "TYM_GROUPE", length = 2)) })
	public VbTypeMarcheId getId() {
		return this.id;
	}

	public void setId(VbTypeMarcheId id) {
		this.id = id;
	}

}
