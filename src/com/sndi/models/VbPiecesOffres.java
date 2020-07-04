package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbPiecesOffres generated by hbm2java
 */
@Entity
@Table(name = "VB_PIECES_OFFRES", schema = "EMAP")
public class VbPiecesOffres implements java.io.Serializable {

	private VbPiecesOffresId id;

	public VbPiecesOffres() {
	}

	public VbPiecesOffres(VbPiecesOffresId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pofNum", column = @Column(name = "POF_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "pofDacCode", column = @Column(name = "POF_DAC_CODE", length = 25)),
			@AttributeOverride(name = "pofLaaId", column = @Column(name = "POF_LAA_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "pofOpdNum", column = @Column(name = "POF_OPD_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "pofOpdTpoCode", column = @Column(name = "POF_OPD_TPO_CODE", length = 10)),
			@AttributeOverride(name = "pofDofNum", column = @Column(name = "POF_DOF_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "pofPresent", column = @Column(name = "POF_PRESENT", length = 1)),
			@AttributeOverride(name = "pofConforme", column = @Column(name = "POF_CONFORME", length = 1)),
			@AttributeOverride(name = "pofTypeAct", column = @Column(name = "POF_TYPE_ACT", length = 10)),
			@AttributeOverride(name = "pofDteSaisi", column = @Column(name = "POF_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "pofOpeMatricule", column = @Column(name = "POF_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "pofObs", column = @Column(name = "POF_OBS", length = 500)) })
	public VbPiecesOffresId getId() {
		return this.id;
	}

	public void setId(VbPiecesOffresId id) {
		this.id = id;
	}

}
