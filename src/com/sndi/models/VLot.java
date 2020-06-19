package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VLot generated by hbm2java
 */
@Entity
@Table(name = "V_LOT", schema = "EMAP")
public class VLot implements java.io.Serializable {

	private VLotId id;

	public VLot() {
	}

	public VLot(VLotId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "laaId", column = @Column(name = "LAA_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "laaAaoCode", column = @Column(name = "LAA_AAO_CODE", length = 20)),
			@AttributeOverride(name = "laaObjet", column = @Column(name = "LAA_OBJET", length = 1000)),
			@AttributeOverride(name = "laaObservation", column = @Column(name = "LAA_OBSERVATION", length = 200)),
			@AttributeOverride(name = "laaMtCaut", column = @Column(name = "LAA_MT_CAUT", precision = 22, scale = 0)),
			@AttributeOverride(name = "laaMtEst", column = @Column(name = "LAA_MT_EST", precision = 22, scale = 0)),
			@AttributeOverride(name = "laaDteSaisi", column = @Column(name = "LAA_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "laaStaCode", column = @Column(name = "LAA_STA_CODE", length = 3)),
			@AttributeOverride(name = "laaFonCodSaisi", column = @Column(name = "LAA_FON_COD_SAISI", length = 20)),
			@AttributeOverride(name = "laaFonCodCpmp", column = @Column(name = "LAA_FON_COD_CPMP", length = 20)),
			@AttributeOverride(name = "laaOpeMatricule", column = @Column(name = "LAA_OPE_MATRICULE", length = 20)),
			@AttributeOverride(name = "laaLieuExe", column = @Column(name = "LAA_LIEU_EXE", length = 1000)),
			@AttributeOverride(name = "laaLbgImputation", column = @Column(name = "LAA_LBG_IMPUTATION", length = 50)),
			@AttributeOverride(name = "laaNum", column = @Column(name = "LAA_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "laaCoutLot", column = @Column(name = "LAA_COUT_LOT", precision = 22, scale = 0)),
			@AttributeOverride(name = "laaDacCode", column = @Column(name = "LAA_DAC_CODE", length = 20)) })
	public VLotId getId() {
		return this.id;
	}

	public void setId(VLotId id) {
		this.id = id;
	}

}
