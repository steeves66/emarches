package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TModeleDacType generated by hbm2java
 */
@Entity
@Table(name = "T_MODELE_DAC_TYPE", schema = "EMAP")
public class TModeleDacType implements java.io.Serializable {

	private TModeleDacTypeId id;

	public TModeleDacType() {
	}

	public TModeleDacType(TModeleDacTypeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "mdtCode", column = @Column(name = "MDT_CODE", nullable = false, length = 15)),
			@AttributeOverride(name = "mdtLibelleLong", column = @Column(name = "MDT_LIBELLE_LONG", length = 500)),
			@AttributeOverride(name = "mdtLibelleCourt", column = @Column(name = "MDT_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "mdtDteSaisi", column = @Column(name = "MDT_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "mdtOpeMatricule", column = @Column(name = "MDT_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "mdtTymCode", column = @Column(name = "MDT_TYM_CODE", length = 3)),
			@AttributeOverride(name = "mdtDacTypeChain", column = @Column(name = "MDT_DAC_TYPE_CHAIN", length = 100)) })
	public TModeleDacTypeId getId() {
		return this.id;
	}

	public void setId(TModeleDacTypeId id) {
		this.id = id;
	}

}
