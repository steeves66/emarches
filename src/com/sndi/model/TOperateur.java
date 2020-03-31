package com.sndi.model;
// Generated 22 nov. 2019 18:53:57 by Hibernate Tools 4.3.5.Final

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



/**
 * TOperateur generated by hbm2java
 */
@Entity
@Table(name = "T_OPERATEUR", schema = "EMAP")
public class TOperateur implements java.io.Serializable {

	private String opeMatricule;
	private TStructure TStructure;
	private String opeNom;
	private String opeContact;
	private String opeEtatCivil;
	private String opeMail;
	private String opeLogin;
	private String opeMinCode;
	private String opeFonctionAdminist;
	private Set<TMotdepasse> TMotdepasses = new HashSet<TMotdepasse>(0);
	private Set<TRetrait> TRetraits = new HashSet<TRetrait>(0);
	private Set<TModeleDacType> TModeleDacTypes = new HashSet<TModeleDacType>(0);
	private Set<TAssignation> TAssignations = new HashSet<TAssignation>(0);
	private Set<TTypeSeance> TTypeSeances = new HashSet<TTypeSeance>(0);
	private Set<TCommissionType> TCommissionTypes = new HashSet<TCommissionType>(0);
	private Set<TTempParametre> TTempParametres = new HashSet<TTempParametre>(0);
	private Set<THistoDac> THistoDacs = new HashSet<THistoDac>(0);
	private Set<TParametres> TParametreses = new HashSet<TParametres>(0);

	public TOperateur() {
	}

	public TOperateur(String opeMatricule) {
		this.opeMatricule = opeMatricule;
	}

	public TOperateur(String opeMatricule, TStructure TStructure, TMinistere TMinistere, String opeNom, String opeContact, String opeEtatCivil,
			String opeMail, String opeLogin, String opeMinCode, String opeFonctionAdminist, Set<TMotdepasse> TMotdepasses,Set<TRetrait> TRetraits,Set<TModeleDacType> TModeleDacTypes,Set<TTypeSeance> TTypeSeances,Set<TDetCommissionSeance> TDetCommissionSeancesForDcsOpeMatricule,Set<TTempParametre> TTempParametres,
			Set<TAssignation> TAssignations,/*Set<TDetCommissionSeance> TDetCommissionSeancesForDcsOpeMatSaisi,*/ Set<TCommissionType> TCommissionTypes, Set<THistoDac> THistoDacs,Set<TParametres> TParametreses) {
		this.opeMatricule = opeMatricule;
		this.TStructure = TStructure;
		this.opeNom = opeNom;
		this.opeContact = opeContact;
		this.opeEtatCivil = opeEtatCivil;
		this.opeMail = opeMail;
		this.opeLogin = opeLogin;
		this.opeMinCode = opeMinCode;
		this.opeFonctionAdminist = opeFonctionAdminist;
		this.TMotdepasses = TMotdepasses;
		this.TRetraits = TRetraits;
		this.TModeleDacTypes = TModeleDacTypes;
		this.TAssignations = TAssignations;
		this.TTempParametres = TTempParametres;
		this.TTypeSeances = TTypeSeances;
		this.TCommissionTypes = TCommissionTypes;
		this.THistoDacs = THistoDacs;
		this.TTempParametres = TTempParametres;
	}

	@Id
	@Column(name = "OPE_MATRICULE", unique = true, nullable = false, length = 25)
	public String getOpeMatricule() {
		return this.opeMatricule;
	}

	public void setOpeMatricule(String opeMatricule) {
		this.opeMatricule = opeMatricule;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OPE_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TMotdepasse> getTMotdepasses() {
		return this.TMotdepasses;
	}

	public void setTMotdepasses(Set<TMotdepasse> TMotdepasses) {
		this.TMotdepasses = TMotdepasses;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TRetrait> getTRetraits() {
		return this.TRetraits;
	}

	public void setTRetraits(Set<TRetrait> TRetraits) {
		this.TRetraits = TRetraits;
	}
	


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TAssignation> getTAssignations() {
		return this.TAssignations;
	}

	public void setTAssignations(Set<TAssignation> TAssignations) {
		this.TAssignations = TAssignations;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTempParametre> getTTempParametres() {
		return this.TTempParametres;
	}

	public void setTTempParametres(Set<TTempParametre> TTempParametres) {
		this.TTempParametres = TTempParametres;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTypeSeance> getTTypeSeances() {
		return this.TTypeSeances;
	}

	public void setTTypeSeances(Set<TTypeSeance> TTypeSeances) {
		this.TTypeSeances = TTypeSeances;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TCommissionType> getTCommissionTypes() {
		return this.TCommissionTypes;
	}

	public void setTCommissionTypes(Set<TCommissionType> TCommissionTypes) {
		this.TCommissionTypes = TCommissionTypes;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TModeleDacType> getTModeleDacTypes() {
		return this.TModeleDacTypes;
	}

	public void setTModeleDacTypes(Set<TModeleDacType> TModeleDacTypes) {
		this.TModeleDacTypes = TModeleDacTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<THistoDac> getTHistoDacs() {
		return this.THistoDacs;
	}

	public void setTHistoDacs(Set<THistoDac> THistoDacs) {
		this.THistoDacs = THistoDacs;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TParametres> getTParametreses() {
		return this.TParametreses;
	}

	public void setTParametreses(Set<TParametres> TParametreses) {
		this.TParametreses = TParametreses;
	}

}
