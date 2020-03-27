package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TDeclarant generated by hbm2java
 */
@Entity
@Table(name = "T_DECLARANT", schema = "EMAP")
public class TDeclarant implements java.io.Serializable {

	private long decId;
	private String decOrganExecLibelle;
	private String decOrganExecAdresse;
	private String decPersNomPrenom;
	private String decPersFonction;
	private String decLocalisation;
	private String decNumeroPorte;
	private String decBp;
	private String decTelephone;
	private String decEmail;
	private String decCel;
	private Set<TAffichageAgpm> TAffichageAgpms = new HashSet<TAffichageAgpm>(0);
	private Set<TAgpm> TAgpms = new HashSet<TAgpm>(0);

	public TDeclarant() {
	}

	public TDeclarant(long decId, String decOrganExecLibelle, String decPersFonction, String decBp) {
		this.decId = decId;
		this.decOrganExecLibelle = decOrganExecLibelle;
		this.decPersFonction = decPersFonction;
		this.decBp = decBp;
	}

	public TDeclarant(long decId, String decOrganExecLibelle, String decOrganExecAdresse, String decPersNomPrenom,
			String decPersFonction, String decLocalisation, String decNumeroPorte, String decBp, String decTelephone,
			String decEmail, String decCel, Set<TAffichageAgpm> TAffichageAgpms, Set<TAgpm> TAgpms) {
		this.decId = decId;
		this.decOrganExecLibelle = decOrganExecLibelle;
		this.decOrganExecAdresse = decOrganExecAdresse;
		this.decPersNomPrenom = decPersNomPrenom;
		this.decPersFonction = decPersFonction;
		this.decLocalisation = decLocalisation;
		this.decNumeroPorte = decNumeroPorte;
		this.decBp = decBp;
		this.decTelephone = decTelephone;
		this.decEmail = decEmail;
		this.decCel = decCel;
		this.TAffichageAgpms = TAffichageAgpms;
		this.TAgpms = TAgpms;
	}

	@Id

	@Column(name = "DEC_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getDecId() {
		return this.decId;
	}

	public void setDecId(long decId) {
		this.decId = decId;
	}

	@Column(name = "DEC_ORGAN_EXEC_LIBELLE", nullable = false, length = 500)
	public String getDecOrganExecLibelle() {
		return this.decOrganExecLibelle;
	}

	public void setDecOrganExecLibelle(String decOrganExecLibelle) {
		this.decOrganExecLibelle = decOrganExecLibelle;
	}

	@Column(name = "DEC_ORGAN_EXEC_ADRESSE", length = 500)
	public String getDecOrganExecAdresse() {
		return this.decOrganExecAdresse;
	}

	public void setDecOrganExecAdresse(String decOrganExecAdresse) {
		this.decOrganExecAdresse = decOrganExecAdresse;
	}

	@Column(name = "DEC_PERS_NOM_PRENOM", length = 500)
	public String getDecPersNomPrenom() {
		return this.decPersNomPrenom;
	}

	public void setDecPersNomPrenom(String decPersNomPrenom) {
		this.decPersNomPrenom = decPersNomPrenom;
	}

	@Column(name = "DEC_PERS_FONCTION", nullable = false, length = 500)
	public String getDecPersFonction() {
		return this.decPersFonction;
	}

	public void setDecPersFonction(String decPersFonction) {
		this.decPersFonction = decPersFonction;
	}

	@Column(name = "DEC_LOCALISATION", length = 500)
	public String getDecLocalisation() {
		return this.decLocalisation;
	}

	public void setDecLocalisation(String decLocalisation) {
		this.decLocalisation = decLocalisation;
	}

	@Column(name = "DEC_NUMERO_PORTE", length = 500)
	public String getDecNumeroPorte() {
		return this.decNumeroPorte;
	}

	public void setDecNumeroPorte(String decNumeroPorte) {
		this.decNumeroPorte = decNumeroPorte;
	}

	@Column(name = "DEC_BP", nullable = false, length = 500)
	public String getDecBp() {
		return this.decBp;
	}

	public void setDecBp(String decBp) {
		this.decBp = decBp;
	}

	@Column(name = "DEC_TELEPHONE", length = 500)
	public String getDecTelephone() {
		return this.decTelephone;
	}

	public void setDecTelephone(String decTelephone) {
		this.decTelephone = decTelephone;
	}

	@Column(name = "DEC_EMAIL", length = 500)
	public String getDecEmail() {
		return this.decEmail;
	}

	public void setDecEmail(String decEmail) {
		this.decEmail = decEmail;
	}

	@Column(name = "DEC_CEL", length = 500)
	public String getDecCel() {
		return this.decCel;
	}

	public void setDecCel(String decCel) {
		this.decCel = decCel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDeclarant")
	public Set<TAffichageAgpm> getTAffichageAgpms() {
		return this.TAffichageAgpms;
	}

	public void setTAffichageAgpms(Set<TAffichageAgpm> TAffichageAgpms) {
		this.TAffichageAgpms = TAffichageAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDeclarant")
	public Set<TAgpm> getTAgpms() {
		return this.TAgpms;
	}

	public void setTAgpms(Set<TAgpm> TAgpms) {
		this.TAgpms = TAgpms;
	}

}
