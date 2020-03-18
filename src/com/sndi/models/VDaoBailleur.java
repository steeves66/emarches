package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDaoBailleur generated by hbm2java
 */
@Entity
@Table(name = "V_DAO_BAILLEUR", schema = "EMAP")
public class VDaoBailleur implements java.io.Serializable {

	private VDaoBailleurId id;

	public VDaoBailleur() {
	}

	public VDaoBailleur(VDaoBailleurId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dacCode", column = @Column(name = "DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "dacObjet", column = @Column(name = "DAC_OBJET", length = 1000)),
			@AttributeOverride(name = "dacDteSaisi", column = @Column(name = "DAC_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dacStaCode", column = @Column(name = "DAC_STA_CODE", length = 3)),
			@AttributeOverride(name = "dacTymCode", column = @Column(name = "DAC_TYM_CODE", length = 5)),
			@AttributeOverride(name = "dacMopCode", column = @Column(name = "DAC_MOP_CODE", length = 3)),
			@AttributeOverride(name = "dacNbrOuv", column = @Column(name = "DAC_NBR_OUV", precision = 22, scale = 0)),
			@AttributeOverride(name = "dacGesCode", column = @Column(name = "DAC_GES_CODE", precision = 22, scale = 0)),
			@AttributeOverride(name = "dacFonCodAc", column = @Column(name = "DAC_FON_COD_AC", length = 12)),
			@AttributeOverride(name = "dacStrCode", column = @Column(name = "DAC_STR_CODE", length = 3)),
			@AttributeOverride(name = "dacFonCodeCpmp", column = @Column(name = "DAC_FON_CODE_CPMP", length = 12)),
			@AttributeOverride(name = "dacDteValCpmp", column = @Column(name = "DAC_DTE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "dacDteValDmp", column = @Column(name = "DAC_DTE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "dacTdCode", column = @Column(name = "DAC_TD_CODE", length = 3)),
			@AttributeOverride(name = "dacDppId", column = @Column(name = "DAC_DPP_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "dacDateReception", column = @Column(name = "DAC_DATE_RECEPTION", length = 7)),
			@AttributeOverride(name = "dacStatutRetour", column = @Column(name = "DAC_STATUT_RETOUR", length = 2)),
			@AttributeOverride(name = "dacMention", column = @Column(name = "DAC_MENTION", length = 100)),
			@AttributeOverride(name = "dacDateValAc", column = @Column(name = "DAC_DATE_VAL_AC", length = 7)),
			@AttributeOverride(name = "dacAvisBailleur", column = @Column(name = "DAC_AVIS_BAILLEUR", length = 4000)),
			@AttributeOverride(name = "dacDateAvisBailleur", column = @Column(name = "DAC_DATE_AVIS_BAILLEUR", length = 7)),
			@AttributeOverride(name = "aaoCode", column = @Column(name = "AAO_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "aaoLibelle", column = @Column(name = "AAO_LIBELLE", length = 1000)),
			@AttributeOverride(name = "aaoDacCode", column = @Column(name = "AAO_DAC_CODE", length = 20)),
			@AttributeOverride(name = "aaoDteSaisi", column = @Column(name = "AAO_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "aaoStaCode", column = @Column(name = "AAO_STA_CODE", length = 3)),
			@AttributeOverride(name = "aaoDtePub", column = @Column(name = "AAO_DTE_PUB", length = 7)),
			@AttributeOverride(name = "aaoDteOuvTec", column = @Column(name = "AAO_DTE_OUV_TEC", length = 7)),
			@AttributeOverride(name = "aaoDteHeurOuv", column = @Column(name = "AAO_DTE_HEUR_OUV", length = 7)),
			@AttributeOverride(name = "aaoDteOuvFin", column = @Column(name = "AAO_DTE_OUV_FIN", length = 7)),
			@AttributeOverride(name = "aaoNbrLot", column = @Column(name = "AAO_NBR_LOT", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoNbrOuv", column = @Column(name = "AAO_NBR_OUV", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoDelaiVal", column = @Column(name = "AAO_DELAI_VAL", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoFonCodAc", column = @Column(name = "AAO_FON_COD_AC", length = 12)),
			@AttributeOverride(name = "aaoFonCodeCpmp", column = @Column(name = "AAO_FON_CODE_CPMP", length = 12)),
			@AttributeOverride(name = "aaoNatInt", column = @Column(name = "AAO_NAT_INT", length = 1)),
			@AttributeOverride(name = "aaoTaux", column = @Column(name = "AAO_TAUX", length = 3)),
			@AttributeOverride(name = "aaoLieuExe", column = @Column(name = "AAO_LIEU_EXE", length = 200)),
			@AttributeOverride(name = "aaoNomResp", column = @Column(name = "AAO_NOM_RESP", length = 200)),
			@AttributeOverride(name = "aaoInterPub", column = @Column(name = "AAO_INTER_PUB", length = 1)),
			@AttributeOverride(name = "aaoCautDefExig", column = @Column(name = "AAO_CAUT_DEF_EXIG", length = 1)),
			@AttributeOverride(name = "aaoBompPub", column = @Column(name = "AAO_BOMP_PUB", length = 1)),
			@AttributeOverride(name = "aaoVenteParLot", column = @Column(name = "AAO_VENTE_PAR_LOT", length = 1)),
			@AttributeOverride(name = "aaoAvisBail", column = @Column(name = "AAO_AVIS_BAIL", length = 1)),
			@AttributeOverride(name = "aaoMtCaut", column = @Column(name = "AAO_MT_CAUT", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoModePaiement", column = @Column(name = "AAO_MODE_PAIEMENT", length = 20)),
			@AttributeOverride(name = "aaoCoutDac", column = @Column(name = "AAO_COUT_DAC", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoLieuRecep", column = @Column(name = "AAO_LIEU_RECEP", length = 1000)),
			@AttributeOverride(name = "aaoDateRecep", column = @Column(name = "AAO_DATE_RECEP", length = 7)),
			@AttributeOverride(name = "aaoHeureRecep", column = @Column(name = "AAO_HEURE_RECEP", length = 7)),
			@AttributeOverride(name = "aaoAdaNum", column = @Column(name = "AAO_ADA_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoNatPrix", column = @Column(name = "AAO_NAT_PRIX", length = 20)),
			@AttributeOverride(name = "aaoRegQual", column = @Column(name = "AAO_REG_QUAL", length = 100)),
			@AttributeOverride(name = "aaoAvisBai", column = @Column(name = "AAO_AVIS_BAI", length = 1)),
			@AttributeOverride(name = "aaoRespBai", column = @Column(name = "AAO_RESP_BAI", length = 200)),
			@AttributeOverride(name = "aaoPrecisModEval", column = @Column(name = "AAO_PRECIS_MOD_EVAL", length = 200)),
			@AttributeOverride(name = "aaoDteValAc", column = @Column(name = "AAO_DTE_VAL_AC", length = 7)),
			@AttributeOverride(name = "aaoDteValCpmp", column = @Column(name = "AAO_DTE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "aaoDteValDmp", column = @Column(name = "AAO_DTE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "aaoNbrOff", column = @Column(name = "AAO_NBR_OFF", precision = 4, scale = 0)),
			@AttributeOverride(name = "aaoNbrOffAccpet", column = @Column(name = "AAO_NBR_OFF_ACCPET", precision = 4, scale = 0)),
			@AttributeOverride(name = "aaoNbrOffRej", column = @Column(name = "AAO_NBR_OFF_REJ", precision = 4, scale = 0)),
			@AttributeOverride(name = "aaoNbrOffHorDelai", column = @Column(name = "AAO_NBR_OFF_HOR_DELAI", precision = 4, scale = 0)) })
	public VDaoBailleurId getId() {
		return this.id;
	}

	public void setId(VDaoBailleurId id) {
		this.id = id;
	}

}
