package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDetailVente generated by hbm2java
 */
@Entity
@Table(name = "VB_DETAIL_VENTE", schema = "EMAP")
public class VbDetailVente implements java.io.Serializable {

	private VbDetailVenteId id;

	public VbDetailVente() {
	}

	public VbDetailVente(VbDetailVenteId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dveNum", column = @Column(name = "DVE_NUM", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "dveDacCode", column = @Column(name = "DVE_DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "dveVenNum", column = @Column(name = "DVE_VEN_NUM", nullable = false, precision = 2, scale = 0)),
			@AttributeOverride(name = "dveLaaNum", column = @Column(name = "DVE_LAA_NUM", nullable = false, precision = 20, scale = 0)),
			@AttributeOverride(name = "dveQte", column = @Column(name = "DVE_QTE", length = 3)),
			@AttributeOverride(name = "dveCout", column = @Column(name = "DVE_COUT", length = 20)) })
	public VbDetailVenteId getId() {
		return this.id;
	}

	public void setId(VbDetailVenteId id) {
		this.id = id;
	}

}
