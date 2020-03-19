package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbNaturePiece generated by hbm2java
 */
@Entity
@Table(name = "VB_NATURE_PIECE", schema = "EMAP")
public class VbNaturePiece implements java.io.Serializable {

	private VbNaturePieceId id;

	public VbNaturePiece() {
	}

	public VbNaturePiece(VbNaturePieceId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "napCode", column = @Column(name = "NAP_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "napNapLibelleCourt", column = @Column(name = "NAP_NAP_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "napNapLibelleLong", column = @Column(name = "NAP_NAP_LIBELLE_LONG", length = 1000)) })
	public VbNaturePieceId getId() {
		return this.id;
	}

	public void setId(VbNaturePieceId id) {
		this.id = id;
	}

}
