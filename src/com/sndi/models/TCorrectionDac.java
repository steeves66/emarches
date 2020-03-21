package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

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
 * TCorrectionDac generated by hbm2java
 */
@Entity
@Table(name = "T_CORRECTION_DAC", schema = "EMAP")
public class TCorrectionDac implements java.io.Serializable {

	private BigDecimal corNum;
	private TDacSpecs TDacSpecs;
	private String corLieblle;
	private Date corDteSaisi;
	private String corOpeMatricule;
	private String corResultat;
	private String corObservation;
	private String corResultatRespo;
	private String corObservationRespo;
	private String corFoncodValid;
	private Set<TDetailCorrection> TDetailCorrections = new HashSet<TDetailCorrection>(0);

	public TCorrectionDac() {
	}

	public TCorrectionDac(BigDecimal corNum) {
		this.corNum = corNum;
	}

	public TCorrectionDac(BigDecimal corNum, TDacSpecs TDacSpecs, String corLieblle, Date corDteSaisi,
			String corOpeMatricule, String corResultat, String corObservation, String corResultatRespo,
			String corObservationRespo, String corFoncodValid, Set<TDetailCorrection> TDetailCorrections) {
		this.corNum = corNum;
		this.TDacSpecs = TDacSpecs;
		this.corLieblle = corLieblle;
		this.corDteSaisi = corDteSaisi;
		this.corOpeMatricule = corOpeMatricule;
		this.corResultat = corResultat;
		this.corObservation = corObservation;
		this.corResultatRespo = corResultatRespo;
		this.corObservationRespo = corObservationRespo;
		this.corFoncodValid = corFoncodValid;
		this.TDetailCorrections = TDetailCorrections;
	}

	@Id

	@Column(name = "COR_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCorNum() {
		return this.corNum;
	}

	public void setCorNum(BigDecimal corNum) {
		this.corNum = corNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COR_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@Column(name = "COR_LIEBLLE", length = 200)
	public String getCorLieblle() {
		return this.corLieblle;
	}

	public void setCorLieblle(String corLieblle) {
		this.corLieblle = corLieblle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "COR_DTE_SAISI", length = 7)
	public Date getCorDteSaisi() {
		return this.corDteSaisi;
	}

	public void setCorDteSaisi(Date corDteSaisi) {
		this.corDteSaisi = corDteSaisi;
	}

	@Column(name = "COR_OPE_MATRICULE", length = 25)
	public String getCorOpeMatricule() {
		return this.corOpeMatricule;
	}

	public void setCorOpeMatricule(String corOpeMatricule) {
		this.corOpeMatricule = corOpeMatricule;
	}

	@Column(name = "COR_RESULTAT", length = 20)
	public String getCorResultat() {
		return this.corResultat;
	}

	public void setCorResultat(String corResultat) {
		this.corResultat = corResultat;
	}

	@Column(name = "COR_OBSERVATION", length = 4000)
	public String getCorObservation() {
		return this.corObservation;
	}

	public void setCorObservation(String corObservation) {
		this.corObservation = corObservation;
	}

	@Column(name = "COR_RESULTAT_RESPO", length = 20)
	public String getCorResultatRespo() {
		return this.corResultatRespo;
	}

	public void setCorResultatRespo(String corResultatRespo) {
		this.corResultatRespo = corResultatRespo;
	}

	@Column(name = "COR_OBSERVATION_RESPO", length = 4000)
	public String getCorObservationRespo() {
		return this.corObservationRespo;
	}

	public void setCorObservationRespo(String corObservationRespo) {
		this.corObservationRespo = corObservationRespo;
	}

	@Column(name = "COR_FONCOD_VALID", length = 1000)
	public String getCorFoncodValid() {
		return this.corFoncodValid;
	}

	public void setCorFoncodValid(String corFoncodValid) {
		this.corFoncodValid = corFoncodValid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TCorrectionDac")
	public Set<TDetailCorrection> getTDetailCorrections() {
		return this.TDetailCorrections;
	}

	public void setTDetailCorrections(Set<TDetailCorrection> TDetailCorrections) {
		this.TDetailCorrections = TDetailCorrections;
	}

}
