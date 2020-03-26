package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TBesoin generated by hbm2java
 */
@Entity
@Table(name = "T_BESOIN", schema = "EMAP")
public class TBesoin implements java.io.Serializable {

	private long besId;
	private TProjet TProjet;
	private TReglementation TReglementation;
	private String besLibelle;
	private String besStatut;

	public TBesoin() {
	}

	public TBesoin(long besId, TProjet TProjet, TReglementation TReglementation) {
		this.besId = besId;
		this.TProjet = TProjet;
		this.TReglementation = TReglementation;
	}

	public TBesoin(long besId, TProjet TProjet, TReglementation TReglementation, String besLibelle, String besStatut) {
		this.besId = besId;
		this.TProjet = TProjet;
		this.TReglementation = TReglementation;
		this.besLibelle = besLibelle;
		this.besStatut = besStatut;
	}

	@Id

	@Column(name = "BES_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getBesId() {
		return this.besId;
	}

	public void setBesId(long besId) {
		this.besId = besId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BES_PRO_ID", nullable = false)
	public TProjet getTProjet() {
		return this.TProjet;
	}

	public void setTProjet(TProjet TProjet) {
		this.TProjet = TProjet;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BES_REG_ID", nullable = false)
	public TReglementation getTReglementation() {
		return this.TReglementation;
	}

	public void setTReglementation(TReglementation TReglementation) {
		this.TReglementation = TReglementation;
	}

	@Column(name = "BES_LIBELLE", length = 1000)
	public String getBesLibelle() {
		return this.besLibelle;
	}

	public void setBesLibelle(String besLibelle) {
		this.besLibelle = besLibelle;
	}

	@Column(name = "BES_STATUT", length = 1)
	public String getBesStatut() {
		return this.besStatut;
	}

	public void setBesStatut(String besStatut) {
		this.besStatut = besStatut;
	}

}
