package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbPaysReference generated by hbm2java
 */
@Entity
@Table(name = "VB_PAYS_REFERENCE", schema = "EMAP")
public class VbPaysReference implements java.io.Serializable {

	private VbPaysReferenceId id;

	public VbPaysReference() {
	}

	public VbPaysReference(VbPaysReferenceId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "repCode", column = @Column(name = "REP_CODE", nullable = false, length = 10)),
			@AttributeOverride(name = "repLibelle", column = @Column(name = "REP_LIBELLE", length = 200)),
			@AttributeOverride(name = "repLibelleCourt", column = @Column(name = "REP_LIBELLE_COURT", length = 100)),
			@AttributeOverride(name = "repStatut", column = @Column(name = "REP_STATUT", length = 1)),
			@AttributeOverride(name = "repIndicatif", column = @Column(name = "REP_INDICATIF", length = 50)) })
	public VbPaysReferenceId getId() {
		return this.id;
	}

	public void setId(VbPaysReferenceId id) {
		this.id = id;
	}

}
