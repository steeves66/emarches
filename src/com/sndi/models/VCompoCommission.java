package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VCompoCommission generated by hbm2java
 */
@Entity
@Table(name = "V_COMPO_COMMISSION", schema = "EMAP")
public class VCompoCommission implements java.io.Serializable {

	private VCompoCommissionId id;

	public VCompoCommission() {
	}

	public VCompoCommission(VCompoCommissionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "strCode", column = @Column(name = "STR_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "tctCode", column = @Column(name = "TCT_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tctLibelle", column = @Column(name = "TCT_LIBELLE", length = 500)),
			@AttributeOverride(name = "tctTitre", column = @Column(name = "TCT_TITRE", length = 200)),
			@AttributeOverride(name = "tctTstCode", column = @Column(name = "TCT_TST_CODE", length = 3)),
			@AttributeOverride(name = "tctTcoCode", column = @Column(name = "TCT_TCO_CODE", length = 3)),
			@AttributeOverride(name = "tctDteSaisi", column = @Column(name = "TCT_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "tctOpeMatricule", column = @Column(name = "TCT_OPE_MATRICULE", length = 20)),
			@AttributeOverride(name = "tctGrpCode", column = @Column(name = "TCT_GRP_CODE", length = 20)),
			@AttributeOverride(name = "tctNomMbm", column = @Column(name = "TCT_NOM_MBM", length = 100)),
			@AttributeOverride(name = "tctPreMbm", column = @Column(name = "TCT_PRE_MBM", length = 200)),
			@AttributeOverride(name = "tctTelMbm", column = @Column(name = "TCT_TEL_MBM", length = 20)),
			@AttributeOverride(name = "tctRepMandate", column = @Column(name = "TCT_REP_MANDATE", length = 1)) })
	public VCompoCommissionId getId() {
		return this.id;
	}

	public void setId(VCompoCommissionId id) {
		this.id = id;
	}

}
