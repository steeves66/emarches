package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbFinancement generated by hbm2java
 */
@Entity
@Table(name = "VB_FINANCEMENT", schema = "EMAP")
public class VbFinancement implements java.io.Serializable {

	private VbFinancementId id;

	public VbFinancement() {
	}

	public VbFinancement(VbFinancementId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "finId", column = @Column(name = "FIN_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "finDevCode", column = @Column(name = "FIN_DEV_CODE", nullable = false, length = 8)),
			@AttributeOverride(name = "finBaiCode", column = @Column(name = "FIN_BAI_CODE", length = 5)),
			@AttributeOverride(name = "finSouCode", column = @Column(name = "FIN_SOU_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "finProId", column = @Column(name = "FIN_PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "finMontantCfa", column = @Column(name = "FIN_MONTANT_CFA", precision = 15)),
			@AttributeOverride(name = "finMontantDevise", column = @Column(name = "FIN_MONTANT_DEVISE", precision = 15)),
			@AttributeOverride(name = "finNumeroAccord", column = @Column(name = "FIN_NUMERO_ACCORD", length = 500)),
			@AttributeOverride(name = "finStatut", column = @Column(name = "FIN_STATUT", length = 10)),
			@AttributeOverride(name = "finAgpId", column = @Column(name = "FIN_AGP_ID", precision = 10, scale = 0)) })
	public VbFinancementId getId() {
		return this.id;
	}

	public void setId(VbFinancementId id) {
		this.id = id;
	}

}
