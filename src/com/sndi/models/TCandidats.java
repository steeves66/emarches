package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TCandidats generated by hbm2java
 */
@Entity
@Table(name = "T_CANDIDATS", schema = "EMAP")
public class TCandidats implements java.io.Serializable {

	private long canCode;
	private String canTieNcc;
	private String canSouNcc;
	private String canNomResp;
	private String canNom;
	private String canPrenoms;
	private String canTel;
	private Date canDteSaisi;
	private String canOpeMatricule;
	private String canEmail;

	public TCandidats() {
	}

	public TCandidats(long canCode) {
		this.canCode = canCode;
	}

	public TCandidats(long canCode, String canTieNcc, String canSouNcc, String canNomResp, String canNom,
			String canPrenoms, String canTel, Date canDteSaisi, String canOpeMatricule, String canEmail) {
		this.canCode = canCode;
		this.canTieNcc = canTieNcc;
		this.canSouNcc = canSouNcc;
		this.canNomResp = canNomResp;
		this.canNom = canNom;
		this.canPrenoms = canPrenoms;
		this.canTel = canTel;
		this.canDteSaisi = canDteSaisi;
		this.canOpeMatricule = canOpeMatricule;
		this.canEmail = canEmail;
	}

	@Id

	@Column(name = "CAN_CODE", unique = true, nullable = false, precision = 10, scale = 0)
	public long getCanCode() {
		return this.canCode;
	}

	public void setCanCode(long canCode) {
		this.canCode = canCode;
	}

	@Column(name = "CAN_TIE_NCC", length = 32)
	public String getCanTieNcc() {
		return this.canTieNcc;
	}

	public void setCanTieNcc(String canTieNcc) {
		this.canTieNcc = canTieNcc;
	}

	@Column(name = "CAN_SOU_NCC", length = 20)
	public String getCanSouNcc() {
		return this.canSouNcc;
	}

	public void setCanSouNcc(String canSouNcc) {
		this.canSouNcc = canSouNcc;
	}

	@Column(name = "CAN_NOM_RESP", length = 500)
	public String getCanNomResp() {
		return this.canNomResp;
	}

	public void setCanNomResp(String canNomResp) {
		this.canNomResp = canNomResp;
	}

	@Column(name = "CAN_NOM", length = 500)
	public String getCanNom() {
		return this.canNom;
	}

	public void setCanNom(String canNom) {
		this.canNom = canNom;
	}

	@Column(name = "CAN_PRENOMS", length = 500)
	public String getCanPrenoms() {
		return this.canPrenoms;
	}

	public void setCanPrenoms(String canPrenoms) {
		this.canPrenoms = canPrenoms;
	}

	@Column(name = "CAN_TEL", length = 50)
	public String getCanTel() {
		return this.canTel;
	}

	public void setCanTel(String canTel) {
		this.canTel = canTel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CAN_DTE_SAISI", length = 7)
	public Date getCanDteSaisi() {
		return this.canDteSaisi;
	}

	public void setCanDteSaisi(Date canDteSaisi) {
		this.canDteSaisi = canDteSaisi;
	}

	@Column(name = "CAN_OPE_MATRICULE", length = 25)
	public String getCanOpeMatricule() {
		return this.canOpeMatricule;
	}

	public void setCanOpeMatricule(String canOpeMatricule) {
		this.canOpeMatricule = canOpeMatricule;
	}

	@Column(name = "CAN_EMAIL", length = 50)
	public String getCanEmail() {
		return this.canEmail;
	}

	public void setCanEmail(String canEmail) {
		this.canEmail = canEmail;
	}

}
