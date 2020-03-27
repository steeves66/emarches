package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbOperateurId generated by hbm2java
 */
@Embeddable
public class VbOperateurId implements java.io.Serializable {

	private String opeMatricule;
	private String opeNom;
	private String opeContact;
	private String opeEtatCivil;
	private String opeMail;
	private String opeLogin;
	private String opeMinCode;
	private String opeFonctionAdminist;
	private String opeStrCode;

	public VbOperateurId() {
	}

	public VbOperateurId(String opeMatricule) {
		this.opeMatricule = opeMatricule;
	}

	public VbOperateurId(String opeMatricule, String opeNom, String opeContact, String opeEtatCivil, String opeMail,
			String opeLogin, String opeMinCode, String opeFonctionAdminist, String opeStrCode) {
		this.opeMatricule = opeMatricule;
		this.opeNom = opeNom;
		this.opeContact = opeContact;
		this.opeEtatCivil = opeEtatCivil;
		this.opeMail = opeMail;
		this.opeLogin = opeLogin;
		this.opeMinCode = opeMinCode;
		this.opeFonctionAdminist = opeFonctionAdminist;
		this.opeStrCode = opeStrCode;
	}

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbOperateurId))
			return false;
		VbOperateurId castOther = (VbOperateurId) other;

		return ((this.getOpeMatricule() == castOther.getOpeMatricule()) || (this.getOpeMatricule() != null
				&& castOther.getOpeMatricule() != null && this.getOpeMatricule().equals(castOther.getOpeMatricule())))
				&& ((this.getOpeNom() == castOther.getOpeNom()) || (this.getOpeNom() != null
						&& castOther.getOpeNom() != null && this.getOpeNom().equals(castOther.getOpeNom())))
				&& ((this.getOpeContact() == castOther.getOpeContact()) || (this.getOpeContact() != null
						&& castOther.getOpeContact() != null && this.getOpeContact().equals(castOther.getOpeContact())))
				&& ((this.getOpeEtatCivil() == castOther.getOpeEtatCivil())
						|| (this.getOpeEtatCivil() != null && castOther.getOpeEtatCivil() != null
								&& this.getOpeEtatCivil().equals(castOther.getOpeEtatCivil())))
				&& ((this.getOpeMail() == castOther.getOpeMail()) || (this.getOpeMail() != null
						&& castOther.getOpeMail() != null && this.getOpeMail().equals(castOther.getOpeMail())))
				&& ((this.getOpeLogin() == castOther.getOpeLogin()) || (this.getOpeLogin() != null
						&& castOther.getOpeLogin() != null && this.getOpeLogin().equals(castOther.getOpeLogin())))
				&& ((this.getOpeMinCode() == castOther.getOpeMinCode()) || (this.getOpeMinCode() != null
						&& castOther.getOpeMinCode() != null && this.getOpeMinCode().equals(castOther.getOpeMinCode())))
				&& ((this.getOpeFonctionAdminist() == castOther.getOpeFonctionAdminist())
						|| (this.getOpeFonctionAdminist() != null && castOther.getOpeFonctionAdminist() != null
								&& this.getOpeFonctionAdminist().equals(castOther.getOpeFonctionAdminist())))
				&& ((this.getOpeStrCode() == castOther.getOpeStrCode())
						|| (this.getOpeStrCode() != null && castOther.getOpeStrCode() != null
								&& this.getOpeStrCode().equals(castOther.getOpeStrCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOpeMatricule() == null ? 0 : this.getOpeMatricule().hashCode());
		result = 37 * result + (getOpeNom() == null ? 0 : this.getOpeNom().hashCode());
		result = 37 * result + (getOpeContact() == null ? 0 : this.getOpeContact().hashCode());
		result = 37 * result + (getOpeEtatCivil() == null ? 0 : this.getOpeEtatCivil().hashCode());
		result = 37 * result + (getOpeMail() == null ? 0 : this.getOpeMail().hashCode());
		result = 37 * result + (getOpeLogin() == null ? 0 : this.getOpeLogin().hashCode());
		result = 37 * result + (getOpeMinCode() == null ? 0 : this.getOpeMinCode().hashCode());
		result = 37 * result + (getOpeFonctionAdminist() == null ? 0 : this.getOpeFonctionAdminist().hashCode());
		result = 37 * result + (getOpeStrCode() == null ? 0 : this.getOpeStrCode().hashCode());
		return result;
	}

}
