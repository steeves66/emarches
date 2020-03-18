package com.sndi.controller.typeFonctions;

public class TypeFonctionsFilter {
	 private String code="", libelle="", tousChamps="";

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code ==null?"":code.trim();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle ==null?"":libelle.trim();
	}
	
	public String getTousChamps() {
		return tousChamps;
	}
	public void setTousChamps(String tousChamps) {
		this.tousChamps = tousChamps==null?"":tousChamps.trim();
	}
	
}
