package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPiecesOffreDao generated by hbm2java
 */
@Entity
@Table(name = "V_PIECES_OFFRE_DAO", schema = "EMAP")
public class VPiecesOffreDao implements java.io.Serializable {

	private VPiecesOffreDaoId id;

	public VPiecesOffreDao() {
	}

	public VPiecesOffreDao(VPiecesOffreDaoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "opdNum", column = @Column(name = "OPD_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "opdDacCode", column = @Column(name = "OPD_DAC_CODE", length = 25)),
			@AttributeOverride(name = "opdTpoCode", column = @Column(name = "OPD_TPO_CODE", length = 10)),
			@AttributeOverride(name = "odpTpoEtapPiece", column = @Column(name = "ODP_TPO_ETAP_PIECE", length = 20)),
			@AttributeOverride(name = "odpDteSaisi", column = @Column(name = "ODP_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "odpOpeMatricule", column = @Column(name = "ODP_OPE_MATRICULE", length = 25)) })
	public VPiecesOffreDaoId getId() {
		return this.id;
	}

	public void setId(VPiecesOffreDaoId id) {
		this.id = id;
	}

}
