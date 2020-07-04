package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VFinancementPgpm generated by hbm2java
 */
@Entity
@Table(name = "V_FINANCEMENT_PGPM", schema = "EMAP")
public class VFinancementPgpm implements java.io.Serializable {

	private VFinancementPgpmId id;

	public VFinancementPgpm() {
	}

	public VFinancementPgpm(VFinancementPgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "fipId", column = @Column(name = "FIP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "fipDevCode", column = @Column(name = "FIP_DEV_CODE", nullable = false, length = 8)),
			@AttributeOverride(name = "fipBaiCode", column = @Column(name = "FIP_BAI_CODE", length = 5)),
			@AttributeOverride(name = "fipSouCode", column = @Column(name = "FIP_SOU_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "fipGpgId", column = @Column(name = "FIP_GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "fipMontantCfa", column = @Column(name = "FIP_MONTANT_CFA", precision = 15)),
			@AttributeOverride(name = "fipMontantDevise", column = @Column(name = "FIP_MONTANT_DEVISE", precision = 15)),
			@AttributeOverride(name = "fipCommentaire", column = @Column(name = "FIP_COMMENTAIRE", length = 500)),
			@AttributeOverride(name = "fipTypeFinance", column = @Column(name = "FIP_TYPE_FINANCE", length = 20)),
			@AttributeOverride(name = "fipTresor", column = @Column(name = "FIP_TRESOR", precision = 22, scale = 0)),
			@AttributeOverride(name = "baiLibelle", column = @Column(name = "BAI_LIBELLE", length = 1000)),
			@AttributeOverride(name = "devLibelle", column = @Column(name = "DEV_LIBELLE", length = 500)),
			@AttributeOverride(name = "devSymbole", column = @Column(name = "DEV_SYMBOLE", length = 500)),
			@AttributeOverride(name = "souLibelle", column = @Column(name = "SOU_LIBELLE", length = 500)) })
	public VFinancementPgpmId getId() {
		return this.id;
	}

	public void setId(VFinancementPgpmId id) {
		this.id = id;
	}

}
