package com.sndi.model;
// Generated 21 juin 2020 08:12:24 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VCritereAnalyse generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_CRITERE_ANALYSE")
public class VCritereAnalyse implements java.io.Serializable {

	private String craCode;
	private String craLibelle;
	private String codparent;
	private String craTymCode;

	public VCritereAnalyse() {
	}

	public VCritereAnalyse(String craCode, String craLibelle, String codparent, String craTymCode) {
		this.craCode = craCode;
		this.craLibelle = craLibelle;
		this.codparent = codparent;
		this.craTymCode = craTymCode;
	}

	@Id
	@Column(name = "CRA_CODE", length = 20)
	public String getCraCode() {
		return this.craCode;
	}

	public void setCraCode(String craCode) {
		this.craCode = craCode;
	}

	@Column(name = "CRA_LIBELLE", length = 512)
	public String getCraLibelle() {
		return this.craLibelle;
	}

	public void setCraLibelle(String craLibelle) {
		this.craLibelle = craLibelle;
	}

	@Column(name = "CODPARENT", length = 20)
	public String getCodparent() {
		return this.codparent;
	}

	public void setCodparent(String codparent) {
		this.codparent = codparent;
	}

	@Column(name = "CRA_TYM_CODE", length = 10)
	public String getCraTymCode() {
		return this.craTymCode;
	}

	public void setCraTymCode(String craTymCode) {
		this.craTymCode = craTymCode;
	}

}
