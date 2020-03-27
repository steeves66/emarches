package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TOffrePieceDac generated by hbm2java
 */
@Entity
@Table(name = "T_OFFRE_PIECE_DAC", schema = "EMAP")
public class TOffrePieceDac implements java.io.Serializable {

	private BigDecimal opdNum;
	private TTypePieceOffre TTypePieceOffre;
	private TDacSpecs TDacSpecs;
	private String odpTpoEtapPiece;
	private Date odpDteSaisi;
	private String odpOpeMatricule;
	private Set<TPiecesOffres> TPiecesOffreses = new HashSet<TPiecesOffres>(0);

	public TOffrePieceDac() {
	}

	public TOffrePieceDac(BigDecimal opdNum) {
		this.opdNum = opdNum;
	}

	public TOffrePieceDac(BigDecimal opdNum, TTypePieceOffre TTypePieceOffre, TDacSpecs TDacSpecs,
			String odpTpoEtapPiece, Date odpDteSaisi, String odpOpeMatricule, Set<TPiecesOffres> TPiecesOffreses) {
		this.opdNum = opdNum;
		this.TTypePieceOffre = TTypePieceOffre;
		this.TDacSpecs = TDacSpecs;
		this.odpTpoEtapPiece = odpTpoEtapPiece;
		this.odpDteSaisi = odpDteSaisi;
		this.odpOpeMatricule = odpOpeMatricule;
		this.TPiecesOffreses = TPiecesOffreses;
	}

	@Id

	@Column(name = "OPD_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getOpdNum() {
		return this.opdNum;
	}

	public void setOpdNum(BigDecimal opdNum) {
		this.opdNum = opdNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OPD_TPO_CODE")
	public TTypePieceOffre getTTypePieceOffre() {
		return this.TTypePieceOffre;
	}

	public void setTTypePieceOffre(TTypePieceOffre TTypePieceOffre) {
		this.TTypePieceOffre = TTypePieceOffre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OPD_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@Column(name = "ODP_TPO_ETAP_PIECE", length = 20)
	public String getOdpTpoEtapPiece() {
		return this.odpTpoEtapPiece;
	}

	public void setOdpTpoEtapPiece(String odpTpoEtapPiece) {
		this.odpTpoEtapPiece = odpTpoEtapPiece;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ODP_DTE_SAISI", length = 7)
	public Date getOdpDteSaisi() {
		return this.odpDteSaisi;
	}

	public void setOdpDteSaisi(Date odpDteSaisi) {
		this.odpDteSaisi = odpDteSaisi;
	}

	@Column(name = "ODP_OPE_MATRICULE", length = 25)
	public String getOdpOpeMatricule() {
		return this.odpOpeMatricule;
	}

	public void setOdpOpeMatricule(String odpOpeMatricule) {
		this.odpOpeMatricule = odpOpeMatricule;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOffrePieceDac")
	public Set<TPiecesOffres> getTPiecesOffreses() {
		return this.TPiecesOffreses;
	}

	public void setTPiecesOffreses(Set<TPiecesOffres> TPiecesOffreses) {
		this.TPiecesOffreses = TPiecesOffreses;
	}

}
