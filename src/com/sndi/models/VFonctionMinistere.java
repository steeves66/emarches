package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VFonctionMinistere generated by hbm2java
 */
@Entity
@Table(name = "V_FONCTION_MINISTERE", schema = "EMAP")
public class VFonctionMinistere implements java.io.Serializable {

	private VFonctionMinistereId id;

	public VFonctionMinistere() {
	}

	public VFonctionMinistere(VFonctionMinistereId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "fonCod", column = @Column(name = "FON_COD", nullable = false, length = 20)),
			@AttributeOverride(name = "fonStrCode", column = @Column(name = "FON_STR_CODE", length = 20)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)),
			@AttributeOverride(name = "fonDatDeb", column = @Column(name = "FON_DAT_DEB", length = 7)),
			@AttributeOverride(name = "fonDatFin", column = @Column(name = "FON_DAT_FIN", length = 7)),
			@AttributeOverride(name = "fonTel", column = @Column(name = "FON_TEL", length = 240)),
			@AttributeOverride(name = "fonTyfCod", column = @Column(name = "FON_TYF_COD", length = 3)),
			@AttributeOverride(name = "tyfLibelle", column = @Column(name = "TYF_LIBELLE", length = 300)),
			@AttributeOverride(name = "minLibelle", column = @Column(name = "MIN_LIBELLE", length = 1000)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)) })
	public VFonctionMinistereId getId() {
		return this.id;
	}

	public void setId(VFonctionMinistereId id) {
		this.id = id;
	}

}
