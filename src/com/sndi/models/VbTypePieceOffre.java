package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypePieceOffre generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_PIECE_OFFRE", schema = "EMAP")
public class VbTypePieceOffre implements java.io.Serializable {

	private VbTypePieceOffreId id;

	public VbTypePieceOffre() {
	}

	public VbTypePieceOffre(VbTypePieceOffreId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tpoCode", column = @Column(name = "TPO_CODE", nullable = false, length = 10)),
			@AttributeOverride(name = "tpoLibelle", column = @Column(name = "TPO_LIBELLE", length = 200)),
			@AttributeOverride(name = "tpoDteSaisi", column = @Column(name = "TPO_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "tpoOpeMatricule", column = @Column(name = "TPO_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "tpoEtapPiece", column = @Column(name = "TPO_ETAP_PIECE", length = 10)) })
	public VbTypePieceOffreId getId() {
		return this.id;
	}

	public void setId(VbTypePieceOffreId id) {
		this.id = id;
	}

}