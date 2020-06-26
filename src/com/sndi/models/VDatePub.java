package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDatePub generated by hbm2java
 */
@Entity
@Table(name = "V_DATE_PUB", schema = "EMAP")
public class VDatePub implements java.io.Serializable {

	private VDatePubId id;

	public VDatePub() {
	}

	public VDatePub(VDatePubId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "datepub", column = @Column(name = "DATEPUB", length = 8)),
			@AttributeOverride(name = "libelle", column = @Column(name = "LIBELLE", length = 120)) })
	public VDatePubId getId() {
		return this.id;
	}

	public void setId(VDatePubId id) {
		this.id = id;
	}

}