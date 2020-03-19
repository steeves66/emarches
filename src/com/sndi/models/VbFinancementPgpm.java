package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbFinancementPgpm generated by hbm2java
 */
@Entity
@Table(name = "VB_FINANCEMENT_PGPM", schema = "EMAP")
public class VbFinancementPgpm implements java.io.Serializable {

	private VbFinancementPgpmId id;

	public VbFinancementPgpm() {
	}

	public VbFinancementPgpm(VbFinancementPgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "fipId", column = @Column(name = "FIP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "fipDevCode", column = @Column(name = "FIP_DEV_CODE", nullable = false, length = 8)),
			@AttributeOverride(name = "fipBaiCode", column = @Column(name = "FIP_BAI_CODE", length = 5)),
			@AttributeOverride(name = "fipSouCode", column = @Column(name = "FIP_SOU_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "fipGpgId", column = @Column(name = "FIP_GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "fipMontantCfa", column = @Column(name = "FIP_MONTANT_CFA", precision = 15)),
			@AttributeOverride(name = "fipMontantDevise", column = @Column(name = "FIP_MONTANT_DEVISE", precision = 15)),
			@AttributeOverride(name = "fipCommentaire", column = @Column(name = "FIP_COMMENTAIRE", length = 500)) })
	public VbFinancementPgpmId getId() {
		return this.id;
	}

	public void setId(VbFinancementPgpmId id) {
		this.id = id;
	}

}
