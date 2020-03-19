package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbCorrectionDac generated by hbm2java
 */
@Entity
@Table(name = "VB_CORRECTION_DAC", schema = "EMAP")
public class VbCorrectionDac implements java.io.Serializable {

	private VbCorrectionDacId id;

	public VbCorrectionDac() {
	}

	public VbCorrectionDac(VbCorrectionDacId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "corNum", column = @Column(name = "COR_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "corDacCode", column = @Column(name = "COR_DAC_CODE", length = 20)),
			@AttributeOverride(name = "corLieblle", column = @Column(name = "COR_LIEBLLE", length = 200)),
			@AttributeOverride(name = "corDteSaisi", column = @Column(name = "COR_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "corOpeMatricule", column = @Column(name = "COR_OPE_MATRICULE", length = 25)) })
	public VbCorrectionDacId getId() {
		return this.id;
	}

	public void setId(VbCorrectionDacId id) {
		this.id = id;
	}

}
