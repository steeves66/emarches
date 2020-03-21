package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

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
 * TTypePieceOffre generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_PIECE_OFFRE", schema = "EMAP")
public class TTypePieceOffre implements java.io.Serializable {

	private String tpoCode;
	private TOperateur TOperateur;
	private String tpoLibelle;
	private Date tpoDteSaisi;
	private String tpoEtapPiece;
	private Set<TOffrePieceDac> TOffrePieceDacs = new HashSet<TOffrePieceDac>(0);
	private Set<TPiecesOffres> TPiecesOffreses = new HashSet<TPiecesOffres>(0);

	public TTypePieceOffre() {
	}

	public TTypePieceOffre(String tpoCode) {
		this.tpoCode = tpoCode;
	}

	public TTypePieceOffre(String tpoCode, TOperateur TOperateur, String tpoLibelle, Date tpoDteSaisi,
			String tpoEtapPiece, Set<TOffrePieceDac> TOffrePieceDacs, Set<TPiecesOffres> TPiecesOffreses) {
		this.tpoCode = tpoCode;
		this.TOperateur = TOperateur;
		this.tpoLibelle = tpoLibelle;
		this.tpoDteSaisi = tpoDteSaisi;
		this.tpoEtapPiece = tpoEtapPiece;
		this.TOffrePieceDacs = TOffrePieceDacs;
		this.TPiecesOffreses = TPiecesOffreses;
	}

	@Id

	@Column(name = "TPO_CODE", unique = true, nullable = false, length = 10)
	public String getTpoCode() {
		return this.tpoCode;
	}

	public void setTpoCode(String tpoCode) {
		this.tpoCode = tpoCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TPO_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "TPO_LIBELLE", length = 200)
	public String getTpoLibelle() {
		return this.tpoLibelle;
	}

	public void setTpoLibelle(String tpoLibelle) {
		this.tpoLibelle = tpoLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TPO_DTE_SAISI", length = 7)
	public Date getTpoDteSaisi() {
		return this.tpoDteSaisi;
	}

	public void setTpoDteSaisi(Date tpoDteSaisi) {
		this.tpoDteSaisi = tpoDteSaisi;
	}

	@Column(name = "TPO_ETAP_PIECE", length = 10)
	public String getTpoEtapPiece() {
		return this.tpoEtapPiece;
	}

	public void setTpoEtapPiece(String tpoEtapPiece) {
		this.tpoEtapPiece = tpoEtapPiece;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypePieceOffre")
	public Set<TOffrePieceDac> getTOffrePieceDacs() {
		return this.TOffrePieceDacs;
	}

	public void setTOffrePieceDacs(Set<TOffrePieceDac> TOffrePieceDacs) {
		this.TOffrePieceDacs = TOffrePieceDacs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypePieceOffre")
	public Set<TPiecesOffres> getTPiecesOffreses() {
		return this.TPiecesOffreses;
	}

	public void setTPiecesOffreses(Set<TPiecesOffres> TPiecesOffreses) {
		this.TPiecesOffreses = TPiecesOffreses;
	}

}
