package com.sndi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "V_FONCTION")
public class VFonction {
  private String fonCod;
  private String fonLibelle;
public VFonction() {
	super();
	// TODO Auto-generated constructor stub
}
public VFonction(String fonCod, String fonLibelle) {
	super();
	this.fonCod = fonCod;
	this.fonLibelle = fonLibelle;
}

@Id
@Column(name = "FON_COD")
public String getFonCod() {
	return fonCod;
}
public void setFonCod(String fonCod) {
	this.fonCod = fonCod;
}

@Column(name = "FON_LIBELLE")
public String getFonLibelle() {
	return fonLibelle;
}
public void setFonLibelle(String fonLibelle) {
	this.fonLibelle = fonLibelle;
}

  
}
