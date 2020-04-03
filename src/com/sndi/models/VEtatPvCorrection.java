package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VEtatPvCorrection generated by hbm2java
 */
@Entity
@Table(name = "V_ETAT_PV_CORRECTION", schema = "EMAP")
public class VEtatPvCorrection implements java.io.Serializable {

	private VEtatPvCorrectionId id;

	public VEtatPvCorrection() {
	}

	public VEtatPvCorrection(VEtatPvCorrectionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dacCode", column = @Column(name = "DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "dcoTitre", column = @Column(name = "DCO_TITRE", length = 200)),
			@AttributeOverride(name = "dcoLibelle", column = @Column(name = "DCO_LIBELLE", length = 1000)),
			@AttributeOverride(name = "dcoPidCode", column = @Column(name = "DCO_PID_CODE", precision = 22, scale = 0)),
			@AttributeOverride(name = "dcoPresente", column = @Column(name = "DCO_PRESENTE", length = 3)),
			@AttributeOverride(name = "dcoConforme", column = @Column(name = "DCO_CONFORME", length = 3)),
			@AttributeOverride(name = "dcoObservation", column = @Column(name = "DCO_OBSERVATION", length = 4000)),
			@AttributeOverride(name = "dcoRespo", column = @Column(name = "DCO_RESPO", length = 1)),
			@AttributeOverride(name = "tpiLibelle", column = @Column(name = "TPI_LIBELLE", length = 1000)),
			@AttributeOverride(name = "strCode", column = @Column(name = "STR_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)) })
	public VEtatPvCorrectionId getId() {
		return this.id;
	}

	public void setId(VEtatPvCorrectionId id) {
		this.id = id;
	}

}
