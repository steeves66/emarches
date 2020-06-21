package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypeStructure generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_STRUCTURE", schema = "EMAP")
public class VbTypeStructure implements java.io.Serializable {

	private VbTypeStructureId id;

	public VbTypeStructure() {
	}

	public VbTypeStructure(VbTypeStructureId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tstCode", column = @Column(name = "TST_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tstLibelle", column = @Column(name = "TST_LIBELLE", length = 500)),
			@AttributeOverride(name = "tstDteSaisi", column = @Column(name = "TST_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "tstOpeMatricule", column = @Column(name = "TST_OPE_MATRICULE", length = 20)) })
	public VbTypeStructureId getId() {
		return this.id;
	}

	public void setId(VbTypeStructureId id) {
		this.id = id;
	}

}
