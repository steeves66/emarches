package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TDetailVente generated by hbm2java
 */
@Entity
@Table(name = "T_DETAIL_VENTE", schema = "EMAP")
public class TDetailVente implements java.io.Serializable {

	private long dveNum;
	private TVenteDac TVenteDac;
	private TDacSpecs TDacSpecs;
	private TLotAao TLotAao;
	private String dveQte;
	private Long dveCout;
	private String dveCoutLettre;

	public TDetailVente() {
	}

	public TDetailVente(long dveNum, TVenteDac TVenteDac, TDacSpecs TDacSpecs) {
		this.dveNum = dveNum;
		this.TVenteDac = TVenteDac;
		this.TDacSpecs = TDacSpecs;
	}

	public TDetailVente(long dveNum, TVenteDac TVenteDac, TDacSpecs TDacSpecs, TLotAao TLotAao, String dveQte,
			Long dveCout, String dveCoutLettre) {
		this.dveNum = dveNum;
		this.TVenteDac = TVenteDac;
		this.TDacSpecs = TDacSpecs;
		this.TLotAao = TLotAao;
		this.dveQte = dveQte;
		this.dveCout = dveCout;
		this.dveCoutLettre = dveCoutLettre;
	}

	@Id

	@Column(name = "DVE_NUM", unique = true, nullable = false, precision = 10, scale = 0)
	public long getDveNum() {
		return this.dveNum;
	}

	public void setDveNum(long dveNum) {
		this.dveNum = dveNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DVE_VEN_NUM", nullable = false)
	public TVenteDac getTVenteDac() {
		return this.TVenteDac;
	}

	public void setTVenteDac(TVenteDac TVenteDac) {
		this.TVenteDac = TVenteDac;
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

	@Column(name = "DVE_QTE", length = 3)
	public String getDveQte() {
		return this.dveQte;
	}

	public void setDveQte(String dveQte) {
		this.dveQte = dveQte;
	}

	@Column(name = "DVE_COUT", precision = 10, scale = 0)
	public Long getDveCout() {
		return this.dveCout;
	}

	public void setDveCout(Long dveCout) {
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
