package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VListePieceOffre generated by hbm2java
 */
@Entity
@Table(name = "V_LISTE_PIECE_OFFRE", schema = "EMAP")
public class VListePieceOffre implements java.io.Serializable {

	private VListePieceOffreId id;

	public VListePieceOffre() {
	}

	public VListePieceOffre(VListePieceOffreId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "code", column = @Column(name = "CODE", length = 1)),
			@AttributeOverride(name = "libelle", column = @Column(name = "LIBELLE", length = 43)) })
	public VListePieceOffreId getId() {
		return this.id;
	}

	public void setId(VListePieceOffreId id) {
		this.id = id;
	}

}
