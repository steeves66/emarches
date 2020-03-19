package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TDaoAffectation generated by hbm2java
 */
@Entity
@Table(name = "T_DAO_AFFECTATION", schema = "EMAP")
public class TDaoAffectation implements java.io.Serializable {

	private TDaoAffectationId id;

	public TDaoAffectation() {
	}

	public TDaoAffectation(TDaoAffectationId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dafId", column = @Column(name = "DAF_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "dafDacCode", column = @Column(name = "DAF_DAC_CODE", length = 20)),
			@AttributeOverride(name = "dafOpeMatricule", column = @Column(name = "DAF_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "dafStaCode", column = @Column(name = "DAF_STA_CODE", length = 3)),
			@AttributeOverride(name = "dafDcsNum", column = @Column(name = "DAF_DCS_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "dafDcsMbmRespo", column = @Column(name = "DAF_DCS_MBM_RESPO", length = 1)),
			@AttributeOverride(name = "dafStatutRetour", column = @Column(name = "DAF_STATUT_RETOUR", length = 1)),
			@AttributeOverride(name = "dafTymCode", column = @Column(name = "DAF_TYM_CODE", length = 3)),
			@AttributeOverride(name = "dafMopCode", column = @Column(name = "DAF_MOP_CODE", length = 3)),
			@AttributeOverride(name = "dafDacGestion", column = @Column(name = "DAF_DAC_GESTION", precision = 22, scale = 0)),
			@AttributeOverride(name = "dafDacObjet", column = @Column(name = "DAF_DAC_OBJET", length = 2000)),
			@AttributeOverride(name = "dafTypeDac", column = @Column(name = "DAF_TYPE_DAC", length = 3)),
			@AttributeOverride(name = "dafMention", column = @Column(name = "DAF_MENTION", length = 100)) })
	public TDaoAffectationId getId() {
		return this.id;
	}

	public void setId(TDaoAffectationId id) {
		this.id = id;
	}

}
