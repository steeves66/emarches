package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbAdresseAvis generated by hbm2java
 */
@Entity
@Table(name = "VB_ADRESSE_AVIS", schema = "EMAP")
public class VbAdresseAvis implements java.io.Serializable {

	private VbAdresseAvisId id;

	public VbAdresseAvis() {
	}

	public VbAdresseAvis(VbAdresseAvisId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "adaNum", column = @Column(name = "ADA_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "adaLibelle", column = @Column(name = "ADA_LIBELLE", length = 500)),
			@AttributeOverride(name = "adaFonCod", column = @Column(name = "ADA_FON_COD", length = 12)) })
	public VbAdresseAvisId getId() {
		return this.id;
	}

	public void setId(VbAdresseAvisId id) {
		this.id = id;
	}

}
