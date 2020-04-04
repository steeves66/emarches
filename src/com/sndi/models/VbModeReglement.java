package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbModeReglement generated by hbm2java
 */
@Entity
@Table(name = "VB_MODE_REGLEMENT", schema = "EMAP")
public class VbModeReglement implements java.io.Serializable {

	private VbModeReglementId id;

	public VbModeReglement() {
	}

	public VbModeReglement(VbModeReglementId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "mrgCod", column = @Column(name = "MRG_COD", nullable = false, length = 10)),
			@AttributeOverride(name = "mrgLibelle", column = @Column(name = "MRG_LIBELLE", length = 200)),
			@AttributeOverride(name = "mrgDteSaisie", column = @Column(name = "MRG_DTE_SAISIE", length = 7)),
			@AttributeOverride(name = "mrgOpeMatricule", column = @Column(name = "MRG_OPE_MATRICULE", length = 25)) })
	public VbModeReglementId getId() {
		return this.id;
	}

	public void setId(VbModeReglementId id) {
		this.id = id;
	}

}
