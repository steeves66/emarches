package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypePiecesDac generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_PIECES_DAC", schema = "EMAP")
public class VbTypePiecesDac implements java.io.Serializable {

	private VbTypePiecesDacId id;

	public VbTypePiecesDac() {
	}

	public VbTypePiecesDac(VbTypePiecesDacId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tpiCode", column = @Column(name = "TPI_CODE", nullable = false, length = 10)),
			@AttributeOverride(name = "tpiLibelle", column = @Column(name = "TPI_LIBELLE", length = 1000)),
			@AttributeOverride(name = "tpiDacPec", column = @Column(name = "TPI_DAC_PEC", length = 15)),
			@AttributeOverride(name = "tpiMdtCode", column = @Column(name = "TPI_MDT_CODE", length = 10)),
			@AttributeOverride(name = "tpiSecNum", column = @Column(name = "TPI_SEC_NUM", length = 5)) })
	public VbTypePiecesDacId getId() {
		return this.id;
	}

	public void setId(VbTypePiecesDacId id) {
		this.id = id;
	}

}
