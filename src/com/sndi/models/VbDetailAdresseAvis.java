package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDetailAdresseAvis generated by hbm2java
 */
@Entity
@Table(name = "VB_DETAIL_ADRESSE_AVIS", schema = "EMAP")
public class VbDetailAdresseAvis implements java.io.Serializable {

	private VbDetailAdresseAvisId id;

	public VbDetailAdresseAvis() {
	}

	public VbDetailAdresseAvis(VbDetailAdresseAvisId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dtaNum", column = @Column(name = "DTA_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "dtaAdaNum", column = @Column(name = "DTA_ADA_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "dtaTitre", column = @Column(name = "DTA_TITRE", length = 200)),
			@AttributeOverride(name = "dtaLibelle", column = @Column(name = "DTA_LIBELLE", length = 500)),
			@AttributeOverride(name = "dtaDteSaisi", column = @Column(name = "DTA_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dtaLiaNum", column = @Column(name = "DTA_LIA_NUM", precision = 3, scale = 0)) })
	public VbDetailAdresseAvisId getId() {
		return this.id;
	}

	public void setId(VbDetailAdresseAvisId id) {
		this.id = id;
	}

}
