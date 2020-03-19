package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbSeances generated by hbm2java
 */
@Entity
@Table(name = "VB_SEANCES", schema = "EMAP")
public class VbSeances implements java.io.Serializable {

	private VbSeancesId id;

	public VbSeances() {
	}

	public VbSeances(VbSeancesId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "seaNum", column = @Column(name = "SEA_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "seaLibelle", column = @Column(name = "SEA_LIBELLE", length = 500)),
			@AttributeOverride(name = "seaTseCode", column = @Column(name = "SEA_TSE_CODE", length = 3)),
			@AttributeOverride(name = "seaQuorum", column = @Column(name = "SEA_QUORUM", length = 1)),
			@AttributeOverride(name = "seaNbrPli", column = @Column(name = "SEA_NBR_PLI", precision = 22, scale = 0)),
			@AttributeOverride(name = "seaRes", column = @Column(name = "SEA_RES", length = 1)),
			@AttributeOverride(name = "seaSteSaisi", column = @Column(name = "SEA_STE_SAISI", length = 7)),
			@AttributeOverride(name = "seaFonCode", column = @Column(name = "SEA_FON_CODE", length = 30)),
			@AttributeOverride(name = "seaOpeMatricule", column = @Column(name = "SEA_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "seaObservation", column = @Column(name = "SEA_OBSERVATION", length = 500)) })
	public VbSeancesId getId() {
		return this.id;
	}

	public void setId(VbSeancesId id) {
		this.id = id;
	}

}
