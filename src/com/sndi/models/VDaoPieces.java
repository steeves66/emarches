package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDaoPieces generated by hbm2java
 */
@Entity
@Table(name = "V_DAO_PIECES", schema = "EMAP")
public class VDaoPieces implements java.io.Serializable {

	private VDaoPiecesId id;

	public VDaoPieces() {
	}

	public VDaoPieces(VDaoPiecesId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "VId", column = @Column(name = "V_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "dacCode", column = @Column(name = "DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "mdtCode", column = @Column(name = "MDT_CODE", nullable = false, length = 15)),
			@AttributeOverride(name = "mdtLibelleCourt", column = @Column(name = "MDT_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "mdtLibelleLong", column = @Column(name = "MDT_LIBELLE_LONG", length = 500)) })
	public VDaoPiecesId getId() {
		return this.id;
	}

	public void setId(VDaoPiecesId id) {
		this.id = id;
	}

}
