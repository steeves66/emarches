package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VCorrectionDac generated by hbm2java
 */
@Entity
@Table(name = "V_CORRECTION_DAC", schema = "EMAP")
public class VCorrectionDac implements java.io.Serializable {

	private VCorrectionDacId id;

	public VCorrectionDac() {
	}

	public VCorrectionDac(VCorrectionDacId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dacCode", column = @Column(name = "DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "dacObjet", column = @Column(name = "DAC_OBJET", length = 1000)),
			@AttributeOverride(name = "dcoTitre", column = @Column(name = "DCO_TITRE", length = 200)),
			@AttributeOverride(name = "dcoLibelle", column = @Column(name = "DCO_LIBELLE", length = 1000)),
			@AttributeOverride(name = "dcoPidCode", column = @Column(name = "DCO_PID_CODE", precision = 22, scale = 0)),
			@AttributeOverride(name = "tpiCode", column = @Column(name = "TPI_CODE", nullable = false, length = 10)),
			@AttributeOverride(name = "tpiLibelle", column = @Column(name = "TPI_LIBELLE", length = 1000)),
			@AttributeOverride(name = "pidConforme", column = @Column(name = "PID_CONFORME", length = 3)),
			@AttributeOverride(name = "corObservation", column = @Column(name = "COR_OBSERVATION", length = 4000)),
			@AttributeOverride(name = "corResultat", column = @Column(name = "COR_RESULTAT", length = 20)),
			@AttributeOverride(name = "strCode", column = @Column(name = "STR_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)) })
	public VCorrectionDacId getId() {
		return this.id;
	}

	public void setId(VCorrectionDacId id) {
		this.id = id;
	}

}
