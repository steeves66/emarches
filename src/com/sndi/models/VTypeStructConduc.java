package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VTypeStructConduc generated by hbm2java
 */
@Entity
@Table(name = "V_TYPE_STRUCT_CONDUC", schema = "EMAP")
public class VTypeStructConduc implements java.io.Serializable {

	private VTypeStructConducId id;

	public VTypeStructConduc() {
	}

	public VTypeStructConduc(VTypeStructConducId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "code", column = @Column(name = "CODE", length = 3)),
			@AttributeOverride(name = "libelle", column = @Column(name = "LIBELLE", length = 28)) })
	public VTypeStructConducId getId() {
		return this.id;
	}

	public void setId(VTypeStructConducId id) {
		this.id = id;
	}

}
