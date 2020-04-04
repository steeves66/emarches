package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPieces generated by hbm2java
 */
@Entity
@Table(name = "V_PIECES", schema = "EMAP")
public class VPieces implements java.io.Serializable {

	private VPiecesId id;

	public VPieces() {
	}

	public VPieces(VPiecesId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "VPi", column = @Column(name = "V_PI", precision = 22, scale = 0)),
			@AttributeOverride(name = "pidCode", column = @Column(name = "PID_CODE", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "pidLibelle", column = @Column(name = "PID_LIBELLE", length = 1000)),
			@AttributeOverride(name = "pidTpiCode", column = @Column(name = "PID_TPI_CODE", length = 10)),
			@AttributeOverride(name = "pidStaCode", column = @Column(name = "PID_STA_CODE", length = 3)),
			@AttributeOverride(name = "pidDteSaisi", column = @Column(name = "PID_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "pidDacCode", column = @Column(name = "PID_DAC_CODE", length = 20)),
			@AttributeOverride(name = "pidConforme", column = @Column(name = "PID_CONFORME", length = 3)),
			@AttributeOverride(name = "pidObservation", column = @Column(name = "PID_OBSERVATION", length = 2000)),
			@AttributeOverride(name = "pidPresente", column = @Column(name = "PID_PRESENTE", length = 3)) })
	public VPiecesId getId() {
		return this.id;
	}

	public void setId(VPiecesId id) {
		this.id = id;
	}

}
