package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDetailAvis generated by hbm2java
 */
@Entity
@Table(name = "VB_DETAIL_AVIS", schema = "EMAP")
public class VbDetailAvis implements java.io.Serializable {

	private VbDetailAvisId id;

	public VbDetailAvis() {
	}

	public VbDetailAvis(VbDetailAvisId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "davCode", column = @Column(name = "DAV_CODE", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "davNumOrd", column = @Column(name = "DAV_NUM_ORD", precision = 22, scale = 0)),
			@AttributeOverride(name = "davTitre", column = @Column(name = "DAV_TITRE", length = 200)),
			@AttributeOverride(name = "davContenu", column = @Column(name = "DAV_CONTENU", length = 2000)),
			@AttributeOverride(name = "davDteSaisi", column = @Column(name = "DAV_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "davStaCode", column = @Column(name = "DAV_STA_CODE", length = 3)),
			@AttributeOverride(name = "davAaoCode", column = @Column(name = "DAV_AAO_CODE", length = 20)),
			@AttributeOverride(name = "davDacCode", column = @Column(name = "DAV_DAC_CODE", length = 20)),
			@AttributeOverride(name = "davAutre", column = @Column(name = "DAV_AUTRE", length = 200)) })
	public VbDetailAvisId getId() {
		return this.id;
	}

	public void setId(VbDetailAvisId id) {
		this.id = id;
	}

}
