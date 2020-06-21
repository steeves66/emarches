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
@Table(name = "VB_DET_CRIT_ANALYSE")
public class VbDetCritAnalyse implements java.io.Serializable {

	private String danCode;
	private String danCraCode;
	private String danLibelle;
	private Date danDteSaisie;
	private String danOpeModif;
	private String danStatut;
	private String danAutre;
	private Date danDteModif;
	private String danOpeSaisie;
	private String danFonCodeAc;

	public VbDetCritAnalyse() {
	}

	public VbDetCritAnalyse(String danCode, String danCraCode) {
		this.danCode = danCode;
		this.danCraCode = danCraCode;
	}

	public VbDetCritAnalyse(String danCode, String danCraCode, String danLibelle, Date danDteSaisie,
			String danOpeModif, String danStatut, String danAutre, Date danDteModif, String danOpeSaisie,
			String danFonCodeAc) {
		this.danCode = danCode;
		this.danCraCode = danCraCode;
		this.danLibelle = danLibelle;
		this.danDteSaisie = danDteSaisie;
		this.danOpeModif = danOpeModif;
		this.danStatut = danStatut;
		this.danAutre = danAutre;
		this.danDteModif = danDteModif;
		this.danOpeSaisie = danOpeSaisie;
		this.danFonCodeAc = danFonCodeAc;
	}

	@Id
	@Column(name = "DAN_CODE", nullable = false, length = 10)
	public String getDanCode() {
		return this.danCode;
	}

	public void setDanCode(String danCode) {
		this.danCode = danCode;
	}

	@Column(name = "DAN_CRA_CODE", nullable = false, length = 20)
	public String getDanCraCode() {
		return this.danCraCode;
	}

	public void setDanCraCode(String danCraCode) {
		this.danCraCode = danCraCode;
	}

	@Column(name = "DAN_LIBELLE", length = 500)
	public String getDanLibelle() {
		return this.danLibelle;
	}

	public void setDanLibelle(String danLibelle) {
		this.danLibelle = danLibelle;
	}

	@Column(name = "DAN_DTE_SAISIE", length = 7)
	public Date getDanDteSaisie() {
		return this.danDteSaisie;
	}

	public void setDanDteSaisie(Date danDteSaisie) {
		this.danDteSaisie = danDteSaisie;
	}

	@Column(name = "DAN_OPE_MODIF", length = 25)
	public String getDanOpeModif() {
		return this.danOpeModif;
	}

	public void setDanOpeModif(String danOpeModif) {
		this.danOpeModif = danOpeModif;
	}

	@Column(name = "DAN_STATUT", length = 1)
	public String getDanStatut() {
		return this.danStatut;
	}

	public void setDanStatut(String danStatut) {
		this.danStatut = danStatut;
	}

	@Column(name = "DAN_AUTRE", length = 200)
	public String getDanAutre() {
		return this.danAutre;
	}

	public void setDanAutre(String danAutre) {
		this.danAutre = danAutre;
	}

	@Column(name = "DAN_DTE_MODIF", length = 7)
	public Date getDanDteModif() {
		return this.danDteModif;
	}

	public void setDanDteModif(Date danDteModif) {
		this.danDteModif = danDteModif;
	}

	@Column(name = "DAN_OPE_SAISIE", length = 25)
	public String getDanOpeSaisie() {
		return this.danOpeSaisie;
	}

	public void setDanOpeSaisie(String danOpeSaisie) {
		this.danOpeSaisie = danOpeSaisie;
	}

	@Column(name = "DAN_FON_CODE_AC", length = 25)
	public String getDanFonCodeAc() {
		return this.danFonCodeAc;
	}

	public void setDanFonCodeAc(String danFonCodeAc) {
		this.danFonCodeAc = danFonCodeAc;
	}

}
