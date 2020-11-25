package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TBailleur generated by hbm2java
 */
@Entity
@Table(name = "T_BAILLEUR", schema = "EMAP")
public class TBailleur implements java.io.Serializable {

	private TBailleurId id;

	public TBailleur() {
	}

	public TBailleur(TBailleurId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "baiCode", column = @Column(name = "BAI_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "baiLibelle", column = @Column(name = "BAI_LIBELLE", nullable = false, length = 1000)),
			@AttributeOverride(name = "baiAdresse", column = @Column(name = "BAI_ADRESSE", length = 500)),
			@AttributeOverride(name = "baiTelephone", column = @Column(name = "BAI_TELEPHONE", length = 500)) })
	public TBailleurId getId() {
		return this.id;
	}

	public void setId(TBailleurId id) {
		this.id = id;
	}

}
