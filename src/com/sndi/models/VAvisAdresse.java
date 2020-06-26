package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VAvisAdresse generated by hbm2java
 */
@Entity
@Table(name = "V_AVIS_ADRESSE", schema = "EMAP")
public class VAvisAdresse implements java.io.Serializable {

	private VAvisAdresseId id;

	public VAvisAdresse() {
	}

	public VAvisAdresse(VAvisAdresseId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "aaoCode", column = @Column(name = "AAO_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "VId", column = @Column(name = "V_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "adaFonCod", column = @Column(name = "ADA_FON_COD", length = 12)),
			@AttributeOverride(name = "adaNum", column = @Column(name = "ADA_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "liaLibelle", column = @Column(name = "LIA_LIBELLE", length = 500)),
			@AttributeOverride(name = "dtaLibelle", column = @Column(name = "DTA_LIBELLE", length = 500)) })
	public VAvisAdresseId getId() {
		return this.id;
	}

	public void setId(VAvisAdresseId id) {
		this.id = id;
	}

}