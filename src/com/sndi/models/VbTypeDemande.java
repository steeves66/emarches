package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypeDemande generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_DEMANDE", schema = "EMAP")
public class VbTypeDemande implements java.io.Serializable {

	private VbTypeDemandeId id;

	public VbTypeDemande() {
	}

	public VbTypeDemande(VbTypeDemandeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tdmCode", column = @Column(name = "TDM_CODE", nullable = false, length = 10)),
			@AttributeOverride(name = "tdmLibelle", column = @Column(name = "TDM_LIBELLE", length = 500)),
			@AttributeOverride(name = "tdmDteSaisi", column = @Column(name = "TDM_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "tdmOpeMatricule", column = @Column(name = "TDM_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "tdmProDer", column = @Column(name = "TDM_PRO_DER", length = 1)) })
	public VbTypeDemandeId getId() {
		return this.id;
	}

	public void setId(VbTypeDemandeId id) {
		this.id = id;
	}

}
