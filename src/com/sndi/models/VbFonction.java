package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbFonction generated by hbm2java
 */
@Entity
@Table(name = "VB_FONCTION", schema = "EMAP")
public class VbFonction implements java.io.Serializable {

	private VbFonctionId id;

	public VbFonction() {
	}

	public VbFonction(VbFonctionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "fonCod", column = @Column(name = "FON_COD", nullable = false, length = 20)),
			@AttributeOverride(name = "fonTyfCod", column = @Column(name = "FON_TYF_COD", length = 3)),
			@AttributeOverride(name = "fonDatDeb", column = @Column(name = "FON_DAT_DEB", length = 7)),
			@AttributeOverride(name = "fonDatFin", column = @Column(name = "FON_DAT_FIN", length = 7)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)),
			@AttributeOverride(name = "fonAdr", column = @Column(name = "FON_ADR", length = 240)),
			@AttributeOverride(name = "fonTel", column = @Column(name = "FON_TEL", length = 240)),
			@AttributeOverride(name = "fonFonCod", column = @Column(name = "FON_FON_COD", length = 12)),
			@AttributeOverride(name = "fonCourriel", column = @Column(name = "FON_COURRIEL", length = 100)),
			@AttributeOverride(name = "fonMobil", column = @Column(name = "FON_MOBIL", length = 20)),
			@AttributeOverride(name = "fonStrCode", column = @Column(name = "FON_STR_CODE", length = 20)) })
	public VbFonctionId getId() {
		return this.id;
	}

	public void setId(VbFonctionId id) {
		this.id = id;
	}

}
