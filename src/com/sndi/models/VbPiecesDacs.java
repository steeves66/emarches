package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbPiecesDacs generated by hbm2java
 */
@Entity
@Table(name = "VB_PIECES_DACS", schema = "EMAP")
public class VbPiecesDacs implements java.io.Serializable {

	private VbPiecesDacsId id;

	public VbPiecesDacs() {
	}

	public VbPiecesDacs(VbPiecesDacsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pidCode", column = @Column(name = "PID_CODE", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "pidLibelle", column = @Column(name = "PID_LIBELLE", length = 1000)),
			@AttributeOverride(name = "pidTpiCode", column = @Column(name = "PID_TPI_CODE", length = 10)),
			@AttributeOverride(name = "pidStaCode", column = @Column(name = "PID_STA_CODE", length = 3)),
			@AttributeOverride(name = "pidDteSaisi", column = @Column(name = "PID_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "pidDacCode", column = @Column(name = "PID_DAC_CODE", length = 20)) })
	public VbPiecesDacsId getId() {
		return this.id;
	}

	public void setId(VbPiecesDacsId id) {
		this.id = id;
	}

}
