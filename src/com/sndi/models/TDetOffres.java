package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TDetOffres generated by hbm2java
 */
@Entity
@Table(name = "T_DET_OFFRES", schema = "EMAP")
public class TDetOffres implements java.io.Serializable {

	private TDetOffresId id;
	private TBanques TBanques;

	public TDetOffres() {
	}

	public TDetOffres(TDetOffresId id) {
		this.id = id;
	}

	public TDetOffres(TDetOffresId id, TBanques TBanques) {
		this.id = id;
		this.TBanques = TBanques;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dofNum", column = @Column(name = "DOF_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "dofLaaId", column = @Column(name = "DOF_LAA_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "dofLaaAaoCode", column = @Column(name = "DOF_LAA_AAO_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "dofOffNum", column = @Column(name = "DOF_OFF_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "dofTyp", column = @Column(name = "DOF_TYP", length = 1)),
			@AttributeOverride(name = "dofDelai", column = @Column(name = "DOF_DELAI", nullable = false, precision = 20, scale = 0)),
			@AttributeOverride(name = "dofDelai2", column = @Column(name = "DOF_DELAI2", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRangOfr", column = @Column(name = "DOF_RANG_OFR", precision = 10, scale = 0)),
			@AttributeOverride(name = "dofMtCor", column = @Column(name = "DOF_MT_COR", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofMtOfr", column = @Column(name = "DOF_MT_OFR", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRab", column = @Column(name = "DOF_RAB", length = 5)),
			@AttributeOverride(name = "dofEstimRab", column = @Column(name = "DOF_ESTIM_RAB", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofCaut", column = @Column(name = "DOF_CAUT", length = 1)),
			@AttributeOverride(name = "dofBanCode", column = @Column(name = "DOF_BAN_CODE", length = 10)),
			@AttributeOverride(name = "dofSeuil", column = @Column(name = "DOF_SEUIL", length = 1)),
			@AttributeOverride(name = "dofScore", column = @Column(name = "DOF_SCORE", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofRecevabl", column = @Column(name = "DOF_RECEVABL", length = 1)),
			@AttributeOverride(name = "dofRet", column = @Column(name = "DOF_RET", length = 1)),
			@AttributeOverride(name = "dofRetBai", column = @Column(name = "DOF_RET_BAI", length = 1)),
			@AttributeOverride(name = "dofRetDmp", column = @Column(name = "DOF_RET_DMP", length = 1)),
			@AttributeOverride(name = "dofMtAtt", column = @Column(name = "DOF_MT_ATT", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofTot", column = @Column(name = "DOF_TOT", length = 2)),
			@AttributeOverride(name = "dofTotAdm", column = @Column(name = "DOF_TOT_ADM", length = 2)),
			@AttributeOverride(name = "dofTotTec", column = @Column(name = "DOF_TOT_TEC", length = 2)),
			@AttributeOverride(name = "dofObsDmp", column = @Column(name = "DOF_OBS_DMP", length = 500)),
			@AttributeOverride(name = "dofObsCom", column = @Column(name = "DOF_OBS_COM", length = 500)),
			@AttributeOverride(name = "dofObsAdm", column = @Column(name = "DOF_OBS_ADM", length = 500)),
			@AttributeOverride(name = "dofObsAdmDmp", column = @Column(name = "DOF_OBS_ADM_DMP", length = 500)),
			@AttributeOverride(name = "dofObsAdmBai", column = @Column(name = "DOF_OBS_ADM_BAI", length = 500)),
			@AttributeOverride(name = "dofObsTec", column = @Column(name = "DOF_OBS_TEC", length = 500)),
			@AttributeOverride(name = "dofObsTecDmp", column = @Column(name = "DOF_OBS_TEC_DMP", length = 500)),
			@AttributeOverride(name = "dofObsTecBai", column = @Column(name = "DOF_OBS_TEC_BAI", length = 500)),
			@AttributeOverride(name = "dofNotAdm", column = @Column(name = "DOF_NOT_ADM", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotTec", column = @Column(name = "DOF_NOT_TEC", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFin", column = @Column(name = "DOF_NOT_FIN", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFin2", column = @Column(name = "DOF_NOT_FIN2", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotAdmDmp", column = @Column(name = "DOF_NOT_ADM_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotTecDmp", column = @Column(name = "DOF_NOT_TEC_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFinDmp", column = @Column(name = "DOF_NOT_FIN_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFin2Dmp", column = @Column(name = "DOF_NOT_FIN2_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotAdmBai", column = @Column(name = "DOF_NOT_ADM_BAI", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotTecBai", column = @Column(name = "DOF_NOT_TEC_BAI", length = 240)),
			@AttributeOverride(name = "dofNotFinBai", column = @Column(name = "DOF_NOT_FIN_BAI", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFin2Bai", column = @Column(name = "DOF_NOT_FIN2_BAI", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofMtAttDmp", column = @Column(name = "DOF_MT_ATT_DMP", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofMtAttBai", column = @Column(name = "DOF_MT_ATT_BAI", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRangOfrDmp", column = @Column(name = "DOF_RANG_OFR_DMP", precision = 10, scale = 0)),
			@AttributeOverride(name = "dofMtCorDmp", column = @Column(name = "DOF_MT_COR_DMP", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRecevablDmp", column = @Column(name = "DOF_RECEVABL_DMP", length = 1)),
			@AttributeOverride(name = "dofScoreDmp", column = @Column(name = "DOF_SCORE_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofRangOfrBai", column = @Column(name = "DOF_RANG_OFR_BAI", precision = 10, scale = 0)),
			@AttributeOverride(name = "dofMtCorBai", column = @Column(name = "DOF_MT_COR_BAI", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRecevablBai", column = @Column(name = "DOF_RECEVABL_BAI", length = 1)),
			@AttributeOverride(name = "dofScoreBai", column = @Column(name = "DOF_SCORE_BAI", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNomSign", column = @Column(name = "DOF_NOM_SIGN", length = 200)),
			@AttributeOverride(name = "dofFonctSign", column = @Column(name = "DOF_FONCT_SIGN", length = 100)),
			@AttributeOverride(name = "dofTelSign", column = @Column(name = "DOF_TEL_SIGN", length = 50)),
			@AttributeOverride(name = "dofDteSaisi", column = @Column(name = "DOF_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dofFonCodeAc", column = @Column(name = "DOF_FON_CODE_AC", length = 25)),
			@AttributeOverride(name = "dofOpeMatricule", column = @Column(name = "DOF_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "dofStatut", column = @Column(name = "DOF_STATUT", length = 1)),
			@AttributeOverride(name = "dofSouNcc", column = @Column(name = "DOF_SOU_NCC", length = 500)),
			@AttributeOverride(name = "dofSigle", column = @Column(name = "DOF_SIGLE", length = 500)),
			@AttributeOverride(name = "dofErrFin", column = @Column(name = "DOF_ERR_FIN", length = 500)),
			@AttributeOverride(name = "dofObsFin", column = @Column(name = "DOF_OBS_FIN", length = 500)),
			@AttributeOverride(name = "dofRepeche", column = @Column(name = "DOF_REPECHE", length = 1)),
			@AttributeOverride(name = "dofObsAnormal", column = @Column(name = "DOF_OBS_ANORMAL", length = 500)),
			@AttributeOverride(name = "dofObsRet", column = @Column(name = "DOF_OBS_RET", length = 500)),
			@AttributeOverride(name = "dofObsVariante", column = @Column(name = "DOF_OBS_VARIANTE", length = 500)),
			@AttributeOverride(name = "dofMtCaut", column = @Column(name = "DOF_MT_CAUT", precision = 22, scale = 0)),
			@AttributeOverride(name = "dofMtRab", column = @Column(name = "DOF_MT_RAB", precision = 22, scale = 0)),
			@AttributeOverride(name = "dofErrCalcul", column = @Column(name = "DOF_ERR_CALCUL", precision = 22, scale = 0)),
			@AttributeOverride(name = "dofTempNum", column = @Column(name = "DOF_TEMP_NUM", precision = 22, scale = 0)) })
	public TDetOffresId getId() {
		return this.id;
	}

	public void setId(TDetOffresId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOF_BAN_CODE", insertable = false, updatable = false)
	public TBanques getTBanques() {
		return this.TBanques;
	}

	public void setTBanques(TBanques TBanques) {
		this.TBanques = TBanques;
	}

}
