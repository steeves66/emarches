package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbHistoDemande generated by hbm2java
 */
@Entity
@Table(name = "VB_HISTO_DEMANDE", schema = "EMAP")
public class VbHistoDemande implements java.io.Serializable {

	private VbHistoDemandeId id;

	public VbHistoDemande() {
	}

	public VbHistoDemande(VbHistoDemandeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hdmNum", column = @Column(name = "HDM_NUM", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "hdmDemNum", column = @Column(name = "HDM_DEM_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "hdmDteSaisi", column = @Column(name = "HDM_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "hdmStaCode", column = @Column(name = "HDM_STA_CODE", length = 3)),
			@AttributeOverride(name = "hdmFonCod", column = @Column(name = "HDM_FON_COD", length = 20)),
			@AttributeOverride(name = "hdmOpeCode", column = @Column(name = "HDM_OPE_CODE", length = 25)) })
	public VbHistoDemandeId getId() {
		return this.id;
	}

	public void setId(VbHistoDemandeId id) {
		this.id = id;
	}

}
