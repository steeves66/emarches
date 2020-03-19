package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbFinancementPpm generated by hbm2java
 */
@Entity
@Table(name = "VB_FINANCEMENT_PPM", schema = "EMAP")
public class VbFinancementPpm implements java.io.Serializable {

	private VbFinancementPpmId id;

	public VbFinancementPpm() {
	}

	public VbFinancementPpm(VbFinancementPpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "fppId", column = @Column(name = "FPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "fppDevCode", column = @Column(name = "FPP_DEV_CODE", nullable = false, length = 8)),
			@AttributeOverride(name = "fppBaiCode", column = @Column(name = "FPP_BAI_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "fppSouCode", column = @Column(name = "FPP_SOU_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "fppDppId", column = @Column(name = "FPP_DPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "fppMontantCfa", column = @Column(name = "FPP_MONTANT_CFA", precision = 15)),
			@AttributeOverride(name = "fppMontantDevise", column = @Column(name = "FPP_MONTANT_DEVISE", precision = 15)),
			@AttributeOverride(name = "fppCommentaire", column = @Column(name = "FPP_COMMENTAIRE", length = 500)) })
	public VbFinancementPpmId getId() {
		return this.id;
	}

	public void setId(VbFinancementPpmId id) {
		this.id = id;
	}

}
