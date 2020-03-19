package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypeFonction generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_FONCTION", schema = "EMAP")
public class VbTypeFonction implements java.io.Serializable {

	private VbTypeFonctionId id;

	public VbTypeFonction() {
	}

	public VbTypeFonction(VbTypeFonctionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tyfCod", column = @Column(name = "TYF_COD", nullable = false, length = 3)),
			@AttributeOverride(name = "tyfLibelle", column = @Column(name = "TYF_LIBELLE", length = 300)) })
	public VbTypeFonctionId getId() {
		return this.id;
	}

	public void setId(VbTypeFonctionId id) {
		this.id = id;
	}

}
