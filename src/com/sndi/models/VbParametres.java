package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbParametres generated by hbm2java
 */
@Entity
@Table(name = "VB_PARAMETRES", schema = "EMAP")
public class VbParametres implements java.io.Serializable {

	private VbParametresId id;

	public VbParametres() {
	}

	public VbParametres(VbParametresId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "parCode", column = @Column(name = "PAR_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "parLibelle", column = @Column(name = "PAR_LIBELLE", length = 200)),
			@AttributeOverride(name = "parVal", column = @Column(name = "PAR_VAL", length = 200)),
			@AttributeOverride(name = "parOpeMatricule", column = @Column(name = "PAR_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "parDteSaisi", column = @Column(name = "PAR_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "parActif", column = @Column(name = "PAR_ACTIF", length = 2)) })
	public VbParametresId getId() {
		return this.id;
	}

	public void setId(VbParametresId id) {
		this.id = id;
	}

}
