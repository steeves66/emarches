package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDetailCorrection generated by hbm2java
 */
@Entity
@Table(name = "VB_DETAIL_CORRECTION", schema = "EMAP")
public class VbDetailCorrection implements java.io.Serializable {

	private VbDetailCorrectionId id;

	public VbDetailCorrection() {
	}

	public VbDetailCorrection(VbDetailCorrectionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dcoNum", column = @Column(name = "DCO_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "dcoTitre", column = @Column(name = "DCO_TITRE", length = 200)),
			@AttributeOverride(name = "dcoLibelle", column = @Column(name = "DCO_LIBELLE", length = 1000)),
			@AttributeOverride(name = "dcoDteSaisi", column = @Column(name = "DCO_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dcoPidCode", column = @Column(name = "DCO_PID_CODE", precision = 22, scale = 0)),
			@AttributeOverride(name = "dcoDacCode", column = @Column(name = "DCO_DAC_CODE", length = 20)),
			@AttributeOverride(name = "dcoFonCodSaisi", column = @Column(name = "DCO_FON_COD_SAISI", length = 12)),
			@AttributeOverride(name = "dcoOpeMatricule", column = @Column(name = "DCO_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "dcoObservation", column = @Column(name = "DCO_OBSERVATION", length = 4000)),
			@AttributeOverride(name = "dcoCorNum", column = @Column(name = "DCO_COR_NUM", precision = 22, scale = 0)) })
	public VbDetailCorrectionId getId() {
		return this.id;
	}

	public void setId(VbDetailCorrectionId id) {
		this.id = id;
	}

}
