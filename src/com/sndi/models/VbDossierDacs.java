package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDossierDacs generated by hbm2java
 */
@Entity
@Table(name = "VB_DOSSIER_DACS", schema = "EMAP")
public class VbDossierDacs implements java.io.Serializable {

	private VbDossierDacsId id;

	public VbDossierDacs() {
	}

	public VbDossierDacs(VbDossierDacsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "ddaId", column = @Column(name = "DDA_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "ddaNom", column = @Column(name = "DDA_NOM", length = 200)),
			@AttributeOverride(name = "ddaDteSaisi", column = @Column(name = "DDA_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "ddaStaCode", column = @Column(name = "DDA_STA_CODE", length = 3)),
			@AttributeOverride(name = "ddaDacCode", column = @Column(name = "DDA_DAC_CODE", length = 20)),
			@AttributeOverride(name = "ddaPidCode", column = @Column(name = "DDA_PID_CODE", precision = 22, scale = 0)),
			@AttributeOverride(name = "ddaReference", column = @Column(name = "DDA_REFERENCE", length = 500)),
			@AttributeOverride(name = "ddaCommentaire", column = @Column(name = "DDA_COMMENTAIRE", length = 500)),
			@AttributeOverride(name = "ddaNadCode", column = @Column(name = "DDA_NAD_CODE", length = 3)) })
	public VbDossierDacsId getId() {
		return this.id;
	}

	public void setId(VbDossierDacsId id) {
		this.id = id;
	}

}
