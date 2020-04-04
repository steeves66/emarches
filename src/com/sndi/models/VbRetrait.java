package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbRetrait generated by hbm2java
 */
@Entity
@Table(name = "VB_RETRAIT", schema = "EMAP")
public class VbRetrait implements java.io.Serializable {

	private VbRetraitId id;

	public VbRetrait() {
	}

	public VbRetrait(VbRetraitId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "retId", column = @Column(name = "RET_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "retDacCode", column = @Column(name = "RET_DAC_CODE", length = 20)),
			@AttributeOverride(name = "retNom", column = @Column(name = "RET_NOM", length = 1000)),
			@AttributeOverride(name = "retAdresse", column = @Column(name = "RET_ADRESSE", length = 500)),
			@AttributeOverride(name = "retMail", column = @Column(name = "RET_MAIL", length = 500)),
			@AttributeOverride(name = "retTel", column = @Column(name = "RET_TEL", length = 500)),
			@AttributeOverride(name = "retPieceNumero", column = @Column(name = "RET_PIECE_NUMERO", length = 500)),
			@AttributeOverride(name = "retDate", column = @Column(name = "RET_DATE", length = 7)),
			@AttributeOverride(name = "retTypePiece", column = @Column(name = "RET_TYPE_PIECE", length = 50)),
			@AttributeOverride(name = "retFonCod", column = @Column(name = "RET_FON_COD", length = 12)),
			@AttributeOverride(name = "retOpeMatricule", column = @Column(name = "RET_OPE_MATRICULE", length = 25)) })
	public VbRetraitId getId() {
		return this.id;
	}

	public void setId(VbRetraitId id) {
		this.id = id;
	}

}
