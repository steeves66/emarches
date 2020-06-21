package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbCommissionSpecifique generated by hbm2java
 */
@Entity
@Table(name = "VB_COMMISSION_SPECIFIQUE", schema = "EMAP")
public class VbCommissionSpecifique implements java.io.Serializable {

	private VbCommissionSpecifiqueId id;

	public VbCommissionSpecifique() {
	}

	public VbCommissionSpecifique(VbCommissionSpecifiqueId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "comNum", column = @Column(name = "COM_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "comDteSaisi", column = @Column(name = "COM_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "comStrCode", column = @Column(name = "COM_STR_CODE", length = 20)),
			@AttributeOverride(name = "comTctCode", column = @Column(name = "COM_TCT_CODE", length = 3)),
			@AttributeOverride(name = "comOpeMatricule", column = @Column(name = "COM_OPE_MATRICULE", length = 20)),
			@AttributeOverride(name = "comDacCode", column = @Column(name = "COM_DAC_CODE", length = 20)),
			@AttributeOverride(name = "comMarCode", column = @Column(name = "COM_MAR_CODE", length = 20)),
			@AttributeOverride(name = "comAaoCode", column = @Column(name = "COM_AAO_CODE", length = 20)),
			@AttributeOverride(name = "comTcoCode", column = @Column(name = "COM_TCO_CODE", length = 3)) })
	public VbCommissionSpecifiqueId getId() {
		return this.id;
	}

	public void setId(VbCommissionSpecifiqueId id) {
		this.id = id;
	}

}
