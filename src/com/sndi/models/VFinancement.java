package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VFinancement generated by hbm2java
 */
@Entity
@Table(name = "V_FINANCEMENT", schema = "EMAP")
public class VFinancement implements java.io.Serializable {

	private VFinancementId id;

	public VFinancement() {
	}

	public VFinancement(VFinancementId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "finId", column = @Column(name = "FIN_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "finProId", column = @Column(name = "FIN_PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "finAgpId", column = @Column(name = "FIN_AGP_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "finMontantCfa", column = @Column(name = "FIN_MONTANT_CFA", precision = 15)),
			@AttributeOverride(name = "finMontantDevise", column = @Column(name = "FIN_MONTANT_DEVISE", precision = 15)),
			@AttributeOverride(name = "finNumeroAccord", column = @Column(name = "FIN_NUMERO_ACCORD", length = 500)),
			@AttributeOverride(name = "finStatut", column = @Column(name = "FIN_STATUT", length = 10)),
			@AttributeOverride(name = "baiLibelle", column = @Column(name = "BAI_LIBELLE", nullable = false, length = 1000)),
			@AttributeOverride(name = "baiTelephone", column = @Column(name = "BAI_TELEPHONE", length = 500)),
			@AttributeOverride(name = "baiAdresse", column = @Column(name = "BAI_ADRESSE", length = 500)),
			@AttributeOverride(name = "devLibelle", column = @Column(name = "DEV_LIBELLE", length = 500)),
			@AttributeOverride(name = "devSymbole", column = @Column(name = "DEV_SYMBOLE", length = 500)),
			@AttributeOverride(name = "souLibelle", column = @Column(name = "SOU_LIBELLE", length = 500)) })
	public VFinancementId getId() {
		return this.id;
	}

	public void setId(VFinancementId id) {
		this.id = id;
	}

}
