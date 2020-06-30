package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDaoStatut generated by hbm2java
 */
@Entity
@Table(name = "V_DAO_STATUT", schema = "EMAP")
public class VDaoStatut implements java.io.Serializable {

	private VDaoStatutId id;

	public VDaoStatut() {
	}

	public VDaoStatut(VDaoStatutId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hacStaCode", column = @Column(name = "HAC_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "hacId", column = @Column(name = "HAC_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hacDacCode", column = @Column(name = "HAC_DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "hacDate", column = @Column(name = "HAC_DATE", length = 7)),
			@AttributeOverride(name = "hacCommentaire", column = @Column(name = "HAC_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)) })
	public VDaoStatutId getId() {
		return this.id;
	}

	public void setId(VDaoStatutId id) {
		this.id = id;
	}

}
