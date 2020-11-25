package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTempParametreCorrection generated by hbm2java
 */
@Entity
@Table(name = "VB_TEMP_PARAMETRE_CORRECTION", schema = "EMAP")
public class VbTempParametreCorrection implements java.io.Serializable {

	private VbTempParametreCorrectionId id;

	public VbTempParametreCorrection() {
	}

	public VbTempParametreCorrection(VbTempParametreCorrectionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tempNum", column = @Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "tempType", column = @Column(name = "TEMP_TYPE", length = 500)),
			@AttributeOverride(name = "dcoOpeMatricule", column = @Column(name = "DCO_OPE_MATRICULE", length = 500)),
			@AttributeOverride(name = "dcoDteSaisi", column = @Column(name = "DCO_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dcoTitre", column = @Column(name = "DCO_TITRE", length = 500)),
			@AttributeOverride(name = "dcoLibelle", column = @Column(name = "DCO_LIBELLE", length = 500)),
			@AttributeOverride(name = "dcoPidCode", column = @Column(name = "DCO_PID_CODE", length = 500)),
			@AttributeOverride(name = "dcoDacCode", column = @Column(name = "DCO_DAC_CODE", length = 500)),
			@AttributeOverride(name = "dcoFonCodSaisi", column = @Column(name = "DCO_FON_COD_SAISI", length = 500)),
			@AttributeOverride(name = "dcoObservation", column = @Column(name = "DCO_OBSERVATION", length = 500)),
			@AttributeOverride(name = "dcoCorNum", column = @Column(name = "DCO_COR_NUM", length = 500)) })
	public VbTempParametreCorrectionId getId() {
		return this.id;
	}

	public void setId(VbTempParametreCorrectionId id) {
		this.id = id;
	}

}
