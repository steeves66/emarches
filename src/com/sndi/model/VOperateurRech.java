package com.sndi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Immutable
@Table(name = "V_OPERATEUR_RECH")
public class VOperateurRech 
{
	@Id
	@Column(name = "OPE_MATRICULE", unique = true, nullable = false, length = 25)
	private String opeMatricule;

	@Column(name = "OPE_NOM")
	private String opeNom;
	
	@Column(name = "OPE_CONTACT", length = 250)
	private String opeContact;
	
	@Column(name = "OPE_ETAT_CIVIL", length = 250)
	private String opeEtatCivil;
	
	@Column(name = "OPE_MAIL", length = 250)
	private String opeMail;
	
	@Column(name = "OPE_LOGIN", length = 50)
	private String opeLogin;
	
	@Column(name = "OPE_MIN_CODE", length = 3)
	private String opeMinCode;
	
	@Column(name = "OPE_FONCTION_ADMINIST", length = 500)
	private String opeFonctionAdminist;
	
	@Column(name = "OPE_MATRICULE_FONC")
	private String opeMatriculeFonc;
	
	@Column(name = "OPE_FONC_COUR")
	private String opeFoncCour;
	
	@Column(name = "STR_CODE")
	private String strCode;
	
	@Column(name = "STR_LIBELLE_COURT")
	private String strLibelleCourt;
	
	@Column(name = "STR_LIBELLE_LONG")
	private String strLibelleLong;
	
	@Column(name = "OPE_CLE_RECHER")
	private String opeCleRech;
	
	public TOperateur getTOperateur()
	{
		TOperateur operateur = new TOperateur();
		operateur.setOpeContact(opeContact);
		operateur.setOpeEtatCivil(opeEtatCivil);
		operateur.setOpeFonctionAdminist(opeFonctionAdminist);
		operateur.setOpeLogin(opeLogin);
		operateur.setOpeMail(opeMail);
		operateur.setOpeMatricule(opeMatricule);
		operateur.setOpeMinCode(opeMinCode);
		operateur.setOpeNom(opeNom);
		operateur.setOpeMatriculeFonc(opeMatriculeFonc);
		operateur.setTStructure(new TStructure(strCode));
		return operateur;
	}
}
