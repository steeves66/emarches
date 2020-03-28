package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbHistoDac generated by hbm2java
 */
@Entity
@Table(name = "VB_HISTO_DAC", schema = "EMAP")
public class VbHistoDac implements java.io.Serializable {

	private VbHistoDacId id;

	public VbHistoDac() {
	}

	public VbHistoDac(VbHistoDacId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hacId", column = @Column(name = "HAC_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hacFonCod", column = @Column(name = "HAC_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "hacOpeMat", column = @Column(name = "HAC_OPE_MAT", nullable = false, length = 25)),
			@AttributeOverride(name = "hacDacCode", column = @Column(name = "HAC_DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "hacStaCode", column = @Column(name = "HAC_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "hacDate", column = @Column(name = "HAC_DATE", length = 7)),
			@AttributeOverride(name = "hacCommentaire", column = @Column(name = "HAC_COMMENTAIRE", length = 1000)) })
	public VbHistoDacId getId() {
		return this.id;
	}

	public void setId(VbHistoDacId id) {
		this.id = id;
	}

}
