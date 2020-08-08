package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbOffres generated by hbm2java
 */
@Entity
@Table(name = "VB_OFFRES", schema = "EMAP")
public class VbOffres implements java.io.Serializable {

	private VbOffresId id;

	public VbOffres() {
	}

	public VbOffres(VbOffresId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "offNum", column = @Column(name = "OFF_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "offSouNcc", column = @Column(name = "OFF_SOU_NCC", length = 20)),
			@AttributeOverride(name = "offAaoCode", column = @Column(name = "OFF_AAO_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "offDacCode", column = @Column(name = "OFF_DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "offStaCode", column = @Column(name = "OFF_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "offDteSaisi", column = @Column(name = "OFF_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "offDteOuvFin", column = @Column(name = "OFF_DTE_OUV_FIN", length = 7)),
			@AttributeOverride(name = "offMtTotOfr", column = @Column(name = "OFF_MT_TOT_OFR", precision = 20, scale = 0)),
			@AttributeOverride(name = "offDteJug", column = @Column(name = "OFF_DTE_JUG", length = 7)),
			@AttributeOverride(name = "offMtTotCor", column = @Column(name = "OFF_MT_TOT_COR", precision = 20, scale = 0)),
			@AttributeOverride(name = "offDteOuvTec", column = @Column(name = "OFF_DTE_OUV_TEC", length = 7)),
			@AttributeOverride(name = "offOpeMatricule", column = @Column(name = "OFF_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "offDteStaCour", column = @Column(name = "OFF_DTE_STA_COUR", length = 7)),
			@AttributeOverride(name = "offSouSigleSte", column = @Column(name = "OFF_SOU_SIGLE_STE", length = 500)) })
	public VbOffresId getId() {
		return this.id;
	}

	public void setId(VbOffresId id) {
		this.id = id;
	}

}
