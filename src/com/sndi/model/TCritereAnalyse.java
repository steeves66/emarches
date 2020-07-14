package com.sndi.model;
// Generated 20 juin 2020 11:42:45 by Hibernate Tools 4.3.5.Final

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
 * TCritereAnalyse generated by hbm2java
 */
@Entity
@Table(name = "T_CRITERE_ANALYSE", schema = "EMAP")
public class TCritereAnalyse implements java.io.Serializable {

	private String craCode;
	private TTypeMarche TTypeMarche;
	private String craLibelle;
	private Date craDteSaisie;
	private String craOpeMatricule;
	private String craOpeModif;
	private String craStatut;
	private String craTypProc;
	private String craTypDac;
	private Set<TCritereAnalyseSpec> TCritereAnalyseSpecs = new HashSet<TCritereAnalyseSpec>(0);
	private Set<TDetCritAnalyse> TDetCritAnalyses = new HashSet<TDetCritAnalyse>(0);
	private Set<TDetCritAnalyseDac> TDetCritAnalyseDacs = new HashSet<TDetCritAnalyseDac>(0);

	public TCritereAnalyse() {
	}

	public TCritereAnalyse(String craCode) {
		this.craCode = craCode;
	}

	public TCritereAnalyse(String craCode, TTypeMarche TTypeMarche, String craLibelle, Date craDteSaisie,
			String craOpeMatricule, String craOpeModif, String craStatut, String craTypProc, String craTypDac, Set<TCritereAnalyseSpec> TCritereAnalyseSpecs,
			Set<TDetCritAnalyse> TDetCritAnalyses, Set<TDetCritAnalyseDac> TDetCritAnalyseDacs) {
		this.craCode = craCode;
		this.TTypeMarche = TTypeMarche;
		this.craLibelle = craLibelle;
		this.craDteSaisie = craDteSaisie;
		this.craOpeMatricule = craOpeMatricule;
		this.craOpeModif = craOpeModif;
		this.craStatut = craStatut;
		this.craTypProc = craTypProc;
		this.craTypDac = craTypDac;
		this.TCritereAnalyseSpecs = TCritereAnalyseSpecs;
		this.TDetCritAnalyses = TDetCritAnalyses;
		this.TDetCritAnalyseDacs = TDetCritAnalyseDacs;
	}

	@Id

	@Column(name = "CRA_CODE", unique = true, nullable = false)
	public String getCraCode() {
		return this.craCode;
	}

	public void setCraCode(String craCode) {
		this.craCode = craCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CRA_TYM_CODE")
	public TTypeMarche getTTypeMarche() {
		return this.TTypeMarche;
	}

	public void setTTypeMarche(TTypeMarche TTypeMarche) {
		this.TTypeMarche = TTypeMarche;
	}

	@Column(name = "CRA_LIBELLE")
	public String getCraLibelle() {
		return this.craLibelle;
	}

	public void setCraLibelle(String craLibelle) {
		this.craLibelle = craLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CRA_DTE_SAISIE")
	public Date getCraDteSaisie() {
		return this.craDteSaisie;
	}

	public void setCraDteSaisie(Date craDteSaisie) {
		this.craDteSaisie = craDteSaisie;
	}

	@Column(name = "CRA_OPE_MATRICULE")
	public String getCraOpeMatricule() {
		return this.craOpeMatricule;
	}

	public void setCraOpeMatricule(String craOpeMatricule) {
		this.craOpeMatricule = craOpeMatricule;
	}

	@Column(name = "CRA_OPE_MODIF")
	public String getCraOpeModif() {
		return this.craOpeModif;
	}

	public void setCraOpeModif(String craOpeModif) {
		this.craOpeModif = craOpeModif;
	}

	@Column(name = "CRA_STATUT")
	public String getCraStatut() {
		return this.craStatut;
	}

	public void setCraStatut(String craStatut) {
		this.craStatut = craStatut;
	}
	@Column(name = "CRA_TYP_PROC")
	public String getCraTypProc() {
		return this.craTypProc;
	}

	public void setCraTypProc(String craTypProc) {
		this.craTypProc = craTypProc;
	}

	@Column(name = "CRA_TYP_DAC")
	public String getCraTypDac() {
		return this.craTypDac;
	}

	public void setCraTypDac(String craTypDac) {
		this.craTypDac = craTypDac;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TCritereAnalyse")
	public Set<TCritereAnalyseSpec> getTCritereAnalyseSpecs() {
		return this.TCritereAnalyseSpecs;
	}

	public void setTCritereAnalyseSpecs(Set<TCritereAnalyseSpec> TCritereAnalyseSpecs) {
		this.TCritereAnalyseSpecs = TCritereAnalyseSpecs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TCritereAnalyse")
	public Set<TDetCritAnalyse> getTDetCritAnalyses() {
		return this.TDetCritAnalyses;
	}

	public void setTDetCritAnalyses(Set<TDetCritAnalyse> TDetCritAnalyses) {
		this.TDetCritAnalyses = TDetCritAnalyses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TCritereAnalyse")
	public Set<TDetCritAnalyseDac> getTDetCritAnalyseDacs() {
		return this.TDetCritAnalyseDacs;
	}

	public void setTDetCritAnalyseDacs(Set<TDetCritAnalyseDac> TDetCritAnalyseDacs) {
		this.TDetCritAnalyseDacs = TDetCritAnalyseDacs;
	}

}
