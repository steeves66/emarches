package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbCharge generated by hbm2java
 */
@Entity
@Table(name = "VB_CHARGE", schema = "EMAP")
public class VbCharge implements java.io.Serializable {

	private VbChargeId id;

	public VbCharge() {
	}

	public VbCharge(VbChargeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "chrId", column = @Column(name = "CHR_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "chrStrCode", column = @Column(name = "CHR_STR_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "chrTycCode", column = @Column(name = "CHR_TYC_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "chrDppId", column = @Column(name = "CHR_DPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "chrCommentaire", column = @Column(name = "CHR_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "chrStatut", column = @Column(name = "CHR_STATUT", length = 1)) })
	public VbChargeId getId() {
		return this.id;
	}

	public void setId(VbChargeId id) {
		this.id = id;
	}

}
