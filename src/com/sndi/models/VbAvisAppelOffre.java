package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbAvisAppelOffre generated by hbm2java
 */
@Entity
@Table(name = "VB_AVIS_APPEL_OFFRE", schema = "EMAP")
public class VbAvisAppelOffre implements java.io.Serializable {

	private VbAvisAppelOffreId id;

	public VbAvisAppelOffre() {
	}

	public VbAvisAppelOffre(VbAvisAppelOffreId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "aaoCode", column = @Column(name = "AAO_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "aaoLibelle", column = @Column(name = "AAO_LIBELLE", length = 1000)),
			@AttributeOverride(name = "aaoDacCode", column = @Column(name = "AAO_DAC_CODE", length = 20)),
			@AttributeOverride(name = "aaoDteSaisi", column = @Column(name = "AAO_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "aaoStaCode", column = @Column(name = "AAO_STA_CODE", length = 3)),
			@AttributeOverride(name = "aaoDtePub", column = @Column(name = "AAO_DTE_PUB", length = 7)),
			@AttributeOverride(name = "aaoDteOuvTec", column = @Column(name = "AAO_DTE_OUV_TEC", length = 7)),
			@AttributeOverride(name = "aaoDteHeurOuv", column = @Column(name = "AAO_DTE_HEUR_OUV", length = 20)),
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
			@AttributeOverride(name = "aaoHeureRecep", column = @Column(name = "AAO_HEURE_RECEP", length = 20)),
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
	public VbAvisAppelOffreId getId() {
		return this.id;
	}

	public void setId(VbAvisAppelOffreId id) {
		this.id = id;
	}

}
