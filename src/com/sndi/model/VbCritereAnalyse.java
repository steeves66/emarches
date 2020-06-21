package com.sndi.model;
// Generated 20 juin 2020 12:34:16 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VB_CRITERE_ANALYSE")
public class VbCritereAnalyse implements java.io.Serializable {

	private String craCode;
	private String craLibelle;
	private Date craDteSaisie;
	private String craOpeMatricule;
	private String craOpeModif;
	private String craTymCode;
	private String craStatut;
	private String craTypProc;
	private String craTypDac;

	public VbCritereAnalyse() {
	}

	public VbCritereAnalyse(String craCode) {
		this.craCode = craCode;
	}

	public VbCritereAnalyse(String craCode, String craLibelle, Date craDteSaisie, String craOpeMatricule,
			String craOpeModif, String craTymCode, String craStatut,String craTypProc, String craTypDac) {
		this.craCode = craCode;
		this.craLibelle = craLibelle;
		this.craDteSaisie = craDteSaisie;
		this.craOpeMatricule = craOpeMatricule;
		this.craOpeModif = craOpeModif;
		this.craTymCode = craTymCode;
		this.craStatut = craStatut;
		this.craTypProc = craTypProc;
		this.craTypDac = craTypDac;
	}

	@Id
	@Column(name = "CRA_CODE", nullable = false, length = 20)
	public String getCraCode() {
		return this.craCode;
	}

	public void setCraCode(String craCode) {
		this.craCode = craCode;
	}

	@Column(name = "CRA_LIBELLE", length = 500)
	public String getCraLibelle() {
		return this.craLibelle;
	}

	public void setCraLibelle(String craLibelle) {
		this.craLibelle = craLibelle;
	}

	@Column(name = "CRA_DTE_SAISIE", length = 7)
	public Date getCraDteSaisie() {
		return this.craDteSaisie;
	}

	public void setCraDteSaisie(Date craDteSaisie) {
		this.craDteSaisie = craDteSaisie;
	}

	@Column(name = "CRA_OPE_MATRICULE", length = 25)
	public String getCraOpeMatricule() {
		return this.craOpeMatricule;
	}

	public void setCraOpeMatricule(String craOpeMatricule) {
		this.craOpeMatricule = craOpeMatricule;
	}

	@Column(name = "CRA_OPE_MODIF", length = 25)
	public String getCraOpeModif() {
		return this.craOpeModif;
	}

	public void setCraOpeModif(String craOpeModif) {
		this.craOpeModif = craOpeModif;
	}

	@Column(name = "CRA_TYM_CODE", length = 10)
	public String getCraTymCode() {
		return this.craTymCode;
	}

	public void setCraTymCode(String craTymCode) {
		this.craTymCode = craTymCode;
	}

	@Column(name = "CRA_STATUT", length = 1)
	public String getCraStatut() {
		return this.craStatut;
	}

	public void setCraStatut(String craStatut) {
		this.craStatut = craStatut;
	}
	
	@Column(name = "CRA_TYP_PROC", length = 3)
	public String getCraTypProc() {
		return this.craTypProc;
	}

	public void setCraTypProc(String craTypProc) {
		this.craTypProc = craTypProc;
	}

	@Column(name = "CRA_TYP_DAC", length = 3)
	public String getCraTypDac() {
		return this.craTypDac;
	}

	public void setCraTypDac(String craTypDac) {
		this.craTypDac = craTypDac;
	}

}
