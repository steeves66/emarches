package com.sndi.model;
// Generated 8 mars 2021 14:03:52 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VOperateur generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_OPERATEUR")
public class VOperateur implements java.io.Serializable {

	private String opeMatricule;
	private String opeNom;
	private String opeContact;
	private String opeEtatCivil;
	private String opeMail;
	private String opeLogin;
	private String opeMinCode;
	private String opeFonctionAdminist;
	private String opeStrCode;
	private String opeMatriculeFonc;
	private String strCode;
	private String strLibelleCourt;
	private String strLibelleLong;

	public VOperateur() {
	}

	public VOperateur(String opeMatricule) {
		this.opeMatricule = opeMatricule;
	}

	public VOperateur(String opeMatricule, String opeNom, String opeContact, String opeEtatCivil, String opeMail,
			String opeLogin, String opeMinCode, String opeFonctionAdminist, String opeStrCode, String opeMatriculeFonc,
			Long mdpId, String mdpOpeMatricule, String mdpMotdepasse, Boolean mdpStatut, Date mdpDate, String fonCod,
			String strCode,String strLibelleCourt,String strLibelleLong) {
		this.opeMatricule = opeMatricule;
		this.opeNom = opeNom;
		this.opeContact = opeContact;
		this.opeEtatCivil = opeEtatCivil;
		this.opeMail = opeMail;
		this.opeLogin = opeLogin;
		this.opeMinCode = opeMinCode;
		this.opeFonctionAdminist = opeFonctionAdminist;
		this.opeStrCode = opeStrCode;
		this.opeMatriculeFonc = opeMatriculeFonc;
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
		this.strLibelleLong = strLibelleLong;
	}

	
	@Id
	@Column(name = "OPE_MATRICULE", nullable = false, length = 25)
	public String getOpeMatricule() {
		return this.opeMatricule;
	}

	public void setOpeMatricule(String opeMatricule) {
		this.opeMatricule = opeMatricule;
	}

	@Column(name = "OPE_NOM")
	public String getOpeNom() {
		return this.opeNom;
	}

	public void setOpeNom(String opeNom) {
		this.opeNom = opeNom;
	}

	@Column(name = "OPE_CONTACT", length = 250)
	public String getOpeContact() {
		return this.opeContact;
	}

	public void setOpeContact(String opeContact) {
		this.opeContact = opeContact;
	}

	@Column(name = "OPE_ETAT_CIVIL", length = 250)
	public String getOpeEtatCivil() {
		return this.opeEtatCivil;
	}

	public void setOpeEtatCivil(String opeEtatCivil) {
		this.opeEtatCivil = opeEtatCivil;
	}

	@Column(name = "OPE_MAIL", length = 250)
	public String getOpeMail() {
		return this.opeMail;
	}

	public void setOpeMail(String opeMail) {
		this.opeMail = opeMail;
	}

	@Column(name = "OPE_LOGIN", length = 50)
	public String getOpeLogin() {
		return this.opeLogin;
	}

	public void setOpeLogin(String opeLogin) {
		this.opeLogin = opeLogin;
	}

	@Column(name = "OPE_MIN_CODE", length = 3)
	public String getOpeMinCode() {
		return this.opeMinCode;
	}

	public void setOpeMinCode(String opeMinCode) {
		this.opeMinCode = opeMinCode;
	}

	@Column(name = "OPE_FONCTION_ADMINIST", length = 500)
	public String getOpeFonctionAdminist() {
		return this.opeFonctionAdminist;
	}

	public void setOpeFonctionAdminist(String opeFonctionAdminist) {
		this.opeFonctionAdminist = opeFonctionAdminist;
	}

	@Column(name = "OPE_STR_CODE", length = 30)
	public String getOpeStrCode() {
		return this.opeStrCode;
	}

	public void setOpeStrCode(String opeStrCode) {
		this.opeStrCode = opeStrCode;
	}

	@Column(name = "OPE_MATRICULE_FONC", length = 25)
	public String getOpeMatriculeFonc() {
		return this.opeMatriculeFonc;
	}

	public void setOpeMatriculeFonc(String opeMatriculeFonc) {
		this.opeMatriculeFonc = opeMatriculeFonc;
	}


	@Column(name = "STR_CODE")
	public String getStrCode() {
		return strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	@Column(name = "STR_LIBELLE_COURT")
	public String getStrLibelleCourt() {
		return strLibelleCourt;
	}

	public void setStrLibelleCourt(String strLibelleCourt) {
		this.strLibelleCourt = strLibelleCourt;
	}

	@Column(name = "STR_LIBELLE_LONG")
	public String getStrLibelleLong() {
		return strLibelleLong;
	}

	public void setStrLibelleLong(String strLibelleLong) {
		this.strLibelleLong = strLibelleLong;
	}

	
}
