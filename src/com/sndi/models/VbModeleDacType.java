package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbModeleDacType generated by hbm2java
 */
@Entity
@Table(name = "VB_MODELE_DAC_TYPE", schema = "EMAP")
public class VbModeleDacType implements java.io.Serializable {

	private VbModeleDacTypeId id;

	public VbModeleDacType() {
	}

	public VbModeleDacType(VbModeleDacTypeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "mdtCode", column = @Column(name = "MDT_CODE", nullable = false, length = 15)),
			@AttributeOverride(name = "mdtLibelleLong", column = @Column(name = "MDT_LIBELLE_LONG", length = 500)),
			@AttributeOverride(name = "mdtLibelleCourt", column = @Column(name = "MDT_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "mdtDteSaisi", column = @Column(name = "MDT_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "mdtOpeMatricule", column = @Column(name = "MDT_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "mdtTymCode", column = @Column(name = "MDT_TYM_CODE", length = 3)) })
	public VbModeleDacTypeId getId() {
		return this.id;
	}

	public void setId(VbModeleDacTypeId id) {
		this.id = id;
	}

}
