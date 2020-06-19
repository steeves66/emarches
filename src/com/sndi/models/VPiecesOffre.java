package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPiecesOffre generated by hbm2java
 */
@Entity
@Table(name = "V_PIECES_OFFRE", schema = "EMAP")
public class VPiecesOffre implements java.io.Serializable {

	private VPiecesOffreId id;

	public VPiecesOffre() {
	}

	public VPiecesOffre(VPiecesOffreId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "opdNum", column = @Column(name = "OPD_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "tpoCode", column = @Column(name = "TPO_CODE", nullable = false, length = 10)),
			@AttributeOverride(name = "opdDacCode", column = @Column(name = "OPD_DAC_CODE", length = 25)),
			@AttributeOverride(name = "tpoLibelle", column = @Column(name = "TPO_LIBELLE", length = 200)),
			@AttributeOverride(name = "odpTpoEtapPiece", column = @Column(name = "ODP_TPO_ETAP_PIECE", length = 20)) })
	public VPiecesOffreId getId() {
		return this.id;
	}

	public void setId(VPiecesOffreId id) {
		this.id = id;
	}

}
