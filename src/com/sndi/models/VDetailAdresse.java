package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDetailAdresse generated by hbm2java
 */
@Entity
@Table(name = "V_DETAIL_ADRESSE", schema = "EMAP")
public class VDetailAdresse implements java.io.Serializable {

	private VDetailAdresseId id;

	public VDetailAdresse() {
	}

	public VDetailAdresse(VDetailAdresseId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "VId", column = @Column(name = "V_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "adaFonCod", column = @Column(name = "ADA_FON_COD", length = 12)),
			@AttributeOverride(name = "adaNum", column = @Column(name = "ADA_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "liaLibelle", column = @Column(name = "LIA_LIBELLE", length = 500)),
			@AttributeOverride(name = "dtaLibelle", column = @Column(name = "DTA_LIBELLE", length = 500)) })
	public VDetailAdresseId getId() {
		return this.id;
	}

	public void setId(VDetailAdresseId id) {
		this.id = id;
	}

}
