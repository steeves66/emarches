package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDetailCorrectionCharge generated by hbm2java
 */
@Entity
@Table(name = "V_DETAIL_CORRECTION_CHARGE", schema = "EMAP")
public class VDetailCorrectionCharge implements java.io.Serializable {

	private VDetailCorrectionChargeId id;

	public VDetailCorrectionCharge() {
	}

	public VDetailCorrectionCharge(VDetailCorrectionChargeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pidCode", column = @Column(name = "PID_CODE", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "pidLibelle", column = @Column(name = "PID_LIBELLE", length = 1000)),
			@AttributeOverride(name = "dcoDacCode", column = @Column(name = "DCO_DAC_CODE", length = 20)),
			@AttributeOverride(name = "dcoPresente", column = @Column(name = "DCO_PRESENTE", length = 3)),
			@AttributeOverride(name = "dcoConforme", column = @Column(name = "DCO_CONFORME", length = 3)),
			@AttributeOverride(name = "dcoObservation", column = @Column(name = "DCO_OBSERVATION", length = 4000)),
			@AttributeOverride(name = "dcoRespo", column = @Column(name = "DCO_RESPO", length = 1)),
			@AttributeOverride(name = "corResultatRespo", column = @Column(name = "COR_RESULTAT_RESPO", length = 20)),
			@AttributeOverride(name = "corObservationRespo", column = @Column(name = "COR_OBSERVATION_RESPO", length = 4000)),
			@AttributeOverride(name = "ac", column = @Column(name = "AC", length = 521)),
			@AttributeOverride(name = "operateur", column = @Column(name = "OPERATEUR", length = 281)) })
	public VDetailCorrectionChargeId getId() {
		return this.id;
	}

	public void setId(VDetailCorrectionChargeId id) {
		this.id = id;
	}

}