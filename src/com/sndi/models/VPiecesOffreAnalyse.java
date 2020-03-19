package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPiecesOffreAnalyse generated by hbm2java
 */
@Entity
@Table(name = "V_PIECES_OFFRE_ANALYSE", schema = "EMAP")
public class VPiecesOffreAnalyse implements java.io.Serializable {

	private VPiecesOffreAnalyseId id;

	public VPiecesOffreAnalyse() {
	}

	public VPiecesOffreAnalyse(VPiecesOffreAnalyseId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pofNum", column = @Column(name = "POF_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "opdNum", column = @Column(name = "OPD_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "tpoCode", column = @Column(name = "TPO_CODE", nullable = false, length = 10)),
			@AttributeOverride(name = "opdDacCode", column = @Column(name = "OPD_DAC_CODE", length = 25)),
			@AttributeOverride(name = "pofLaaId", column = @Column(name = "POF_LAA_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "tpoLibelle", column = @Column(name = "TPO_LIBELLE", length = 200)),
			@AttributeOverride(name = "odpTpoEtapPiece", column = @Column(name = "ODP_TPO_ETAP_PIECE", length = 20)),
			@AttributeOverride(name = "pofConforme", column = @Column(name = "POF_CONFORME", length = 1)) })
	public VPiecesOffreAnalyseId getId() {
		return this.id;
	}

	public void setId(VPiecesOffreAnalyseId id) {
		this.id = id;
	}

}
