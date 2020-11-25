package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TOffrePieceDac generated by hbm2java
 */
@Entity
@Table(name = "T_OFFRE_PIECE_DAC", schema = "EMAP")
public class TOffrePieceDac implements java.io.Serializable {

	private TOffrePieceDacId id;

	public TOffrePieceDac() {
	}

	public TOffrePieceDac(TOffrePieceDacId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "opdNum", column = @Column(name = "OPD_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "opdDacCode", column = @Column(name = "OPD_DAC_CODE", length = 25)),
			@AttributeOverride(name = "opdTpoCode", column = @Column(name = "OPD_TPO_CODE", length = 10)),
			@AttributeOverride(name = "odpTpoEtapPiece", column = @Column(name = "ODP_TPO_ETAP_PIECE", length = 20)),
			@AttributeOverride(name = "odpDteSaisi", column = @Column(name = "ODP_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "odpOpeMatricule", column = @Column(name = "ODP_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "odpLibelle", column = @Column(name = "ODP_LIBELLE", length = 500)) })
	public TOffrePieceDacId getId() {
		return this.id;
	}

	public void setId(TOffrePieceDacId id) {
		this.id = id;
	}

}
