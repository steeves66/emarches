package com.sndi.model;
// Generated 7 mars 2020 16:13:16 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TDetailVente generated by hbm2java
 */
@Entity
@Table(name = "T_DETAIL_VENTE", schema = "EMAP")
public class TDetailVente implements java.io.Serializable {

	private long dveNum;
	private TDacSpecs TDacSpecs;
	private TLotAao TLotAao;
	private TVenteDac TVenteDac;
	private String dveQte;
	private long dveCout;
	private String dveCoutLettre;

	public TDetailVente() {
	}

	public TDetailVente(long dveNum, TDacSpecs TDacSpecs, TLotAao TLotAao) {
		this.dveNum = dveNum;
		this.TDacSpecs = TDacSpecs;
		this.TLotAao = TLotAao;
	}

	public TDetailVente(long dveNum, TDacSpecs TDacSpecs, TLotAao TLotAao, TVenteDac TVenteDac, String dveQte,
			long dveCout, String dveCoutLettre) {
		this.dveNum = dveNum;
		this.TDacSpecs = TDacSpecs;
		this.TLotAao = TLotAao;
		this.TVenteDac = TVenteDac;
		this.dveQte = dveQte;
		this.dveCout = dveCout;
		this.dveCoutLettre = dveCoutLettre;
	}

	@Id
	@SequenceGenerator(name = "SEQ_DET_VENTE_Sequence", sequenceName = "SEQ_DET_VENTE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DET_VENTE_Sequence")
	@Column(name = "DVE_NUM", unique = true, nullable = false, precision = 10, scale = 0)
	public long getDveNum() {
		return this.dveNum;
	}

	public void setDveNum(long dveNum) {
		this.dveNum = dveNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DVE_DAC_CODE", nullable = false)
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DVE_LAA_NUM")
	public TLotAao getTLotAao() {
		return this.TLotAao;
	}

	public void setTLotAao(TLotAao TLotAao) {
		this.TLotAao = TLotAao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DVE_VEN_NUM", nullable = false)
	public TVenteDac getTVenteDac() {
		return this.TVenteDac;
	}

	public void setTVenteDac(TVenteDac TVenteDac) {
		this.TVenteDac = TVenteDac;
	}

	@Column(name = "DVE_QTE", length = 3)
	public String getDveQte() {
		return this.dveQte;
	}

	public void setDveQte(String dveQte) {
		this.dveQte = dveQte;
	}

	@Column(name = "DVE_COUT", precision = 10, scale = 0)
	public long getDveCout() {
		return this.dveCout;
	}

	public void setDveCout(long dveCout) {
		this.dveCout = dveCout;
	}

	@Column(name = "DVE_COUT_LETTRE", length = 500)
	public String getDveCoutLettre() {
		return this.dveCoutLettre;
	}

	public void setDveCoutLettre(String dveCoutLettre) {
		this.dveCoutLettre = dveCoutLettre;
	}

}
