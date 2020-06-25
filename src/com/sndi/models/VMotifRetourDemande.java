package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VMotifRetourDemande generated by hbm2java
 */
@Entity
@Table(name = "V_MOTIF_RETOUR_DEMANDE", schema = "EMAP")
public class VMotifRetourDemande implements java.io.Serializable {

	private VMotifRetourDemandeId id;

	public VMotifRetourDemande() {
	}

	public VMotifRetourDemande(VMotifRetourDemandeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hdmNum", column = @Column(name = "HDM_NUM", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "hdmDemNum", column = @Column(name = "HDM_DEM_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "hdmMotif", column = @Column(name = "HDM_MOTIF", length = 500)),
			@AttributeOverride(name = "opeNom", column = @Column(name = "OPE_NOM")) })
	public VMotifRetourDemandeId getId() {
		return this.id;
	}

	public void setId(VMotifRetourDemandeId id) {
		this.id = id;
	}

}
