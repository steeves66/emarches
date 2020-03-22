package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDetailAgpm generated by hbm2java
 */
@Entity
@Table(name = "VB_DETAIL_AGPM", schema = "EMAP")
public class VbDetailAgpm implements java.io.Serializable {

	private VbDetailAgpmId id;

	public VbDetailAgpm() {
	}

	public VbDetailAgpm(VbDetailAgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tdaId", column = @Column(name = "TDA_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "tdaAgpId", column = @Column(name = "TDA_AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "tdaCommentaire", column = @Column(name = "TDA_COMMENTAIRE", length = 4000)),
			@AttributeOverride(name = "tdaTcaCode", column = @Column(name = "TDA_TCA_CODE", length = 4)),
			@AttributeOverride(name = "tdaNumOrdre", column = @Column(name = "TDA_NUM_ORDRE", length = 3)),
			@AttributeOverride(name = "tdaTitre", column = @Column(name = "TDA_TITRE", length = 100)) })
	public VbDetailAgpmId getId() {
		return this.id;
	}

	public void setId(VbDetailAgpmId id) {
		this.id = id;
	}

}
