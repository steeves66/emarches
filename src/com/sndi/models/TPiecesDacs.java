package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

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
 * TPiecesDacs generated by hbm2java
 */
@Entity
@Table(name = "T_PIECES_DACS", schema = "EMAP")
public class TPiecesDacs implements java.io.Serializable {

	private BigDecimal pidCode;
	private TTypePiecesDac TTypePiecesDac;
	private TDacSpecs TDacSpecs;
	private String pidLibelle;
	private String pidStaCode;
	private Date pidDteSaisi;
	private String pidObservation;
	private String pidPresente;
	private String pidConforme;
	private Set<TDetailCorrection> TDetailCorrections = new HashSet<TDetailCorrection>(0);
	private Set<TDossierDacs> TDossierDacses = new HashSet<TDossierDacs>(0);

	public TPiecesDacs() {
	}

	public TPiecesDacs(BigDecimal pidCode) {
		this.pidCode = pidCode;
	}

	public TPiecesDacs(BigDecimal pidCode, TTypePiecesDac TTypePiecesDac, TDacSpecs TDacSpecs, String pidLibelle,
			String pidStaCode, Date pidDteSaisi, String pidObservation, String pidPresente, String pidConforme,
			Set<TDetailCorrection> TDetailCorrections, Set<TDossierDacs> TDossierDacses) {
		this.pidCode = pidCode;
		this.TTypePiecesDac = TTypePiecesDac;
		this.TDacSpecs = TDacSpecs;
		this.pidLibelle = pidLibelle;
		this.pidStaCode = pidStaCode;
		this.pidDteSaisi = pidDteSaisi;
		this.pidObservation = pidObservation;
		this.pidPresente = pidPresente;
		this.pidConforme = pidConforme;
		this.TDetailCorrections = TDetailCorrections;
		this.TDossierDacses = TDossierDacses;
	}

	@Id

	@Column(name = "PID_CODE", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getPidCode() {
		return this.pidCode;
	}

	public void setPidCode(BigDecimal pidCode) {
		this.pidCode = pidCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PID_TPI_CODE")
	public TTypePiecesDac getTTypePiecesDac() {
		return this.TTypePiecesDac;
	}

	public void setTTypePiecesDac(TTypePiecesDac TTypePiecesDac) {
		this.TTypePiecesDac = TTypePiecesDac;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PID_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@Column(name = "PID_LIBELLE", length = 1000)
	public String getPidLibelle() {
		return this.pidLibelle;
	}

	public void setPidLibelle(String pidLibelle) {
		this.pidLibelle = pidLibelle;
	}

	@Column(name = "PID_STA_CODE", length = 3)
	public String getPidStaCode() {
		return this.pidStaCode;
	}

	public void setPidStaCode(String pidStaCode) {
		this.pidStaCode = pidStaCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PID_DTE_SAISI", length = 7)
	public Date getPidDteSaisi() {
		return this.pidDteSaisi;
	}

	public void setPidDteSaisi(Date pidDteSaisi) {
		this.pidDteSaisi = pidDteSaisi;
	}

	@Column(name = "PID_OBSERVATION", length = 2000)
	public String getPidObservation() {
		return this.pidObservation;
	}

	public void setPidObservation(String pidObservation) {
		this.pidObservation = pidObservation;
	}

	@Column(name = "PID_PRESENTE", length = 3)
	public String getPidPresente() {
		return this.pidPresente;
	}

	public void setPidPresente(String pidPresente) {
		this.pidPresente = pidPresente;
	}

	@Column(name = "PID_CONFORME", length = 3)
	public String getPidConforme() {
		return this.pidConforme;
	}

	public void setPidConforme(String pidConforme) {
		this.pidConforme = pidConforme;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TPiecesDacs")
	public Set<TDetailCorrection> getTDetailCorrections() {
		return this.TDetailCorrections;
	}

	public void setTDetailCorrections(Set<TDetailCorrection> TDetailCorrections) {
		this.TDetailCorrections = TDetailCorrections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TPiecesDacs")
	public Set<TDossierDacs> getTDossierDacses() {
		return this.TDossierDacses;
	}

	public void setTDossierDacses(Set<TDossierDacs> TDossierDacses) {
		this.TDossierDacses = TDossierDacses;
	}

}