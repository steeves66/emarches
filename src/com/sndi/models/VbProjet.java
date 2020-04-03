package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbProjet generated by hbm2java
 */
@Entity
@Table(name = "VB_PROJET", schema = "EMAP")
public class VbProjet implements java.io.Serializable {

	private VbProjetId id;

	public VbProjet() {
	}

	public VbProjet(VbProjetId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "proId", column = @Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "proRegId", column = @Column(name = "PRO_REG_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "proCode", column = @Column(name = "PRO_CODE", length = 50)),
			@AttributeOverride(name = "proTitre", column = @Column(name = "PRO_TITRE", nullable = false, length = 500)),
			@AttributeOverride(name = "proLibelle", column = @Column(name = "PRO_LIBELLE", length = 500)),
			@AttributeOverride(name = "proDescription", column = @Column(name = "PRO_DESCRIPTION", length = 1000)),
			@AttributeOverride(name = "proMontantTotCfa", column = @Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)),
			@AttributeOverride(name = "proTypeProjet", column = @Column(name = "PRO_TYPE_PROJET", length = 10)) })
	public VbProjetId getId() {
		return this.id;
	}

	public void setId(VbProjetId id) {
		this.id = id;
	}

}
