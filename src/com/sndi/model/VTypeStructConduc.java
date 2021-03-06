package com.sndi.model;
// Generated 18 juin 2020 11:42:00 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VTypeStructConduc generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_TYPE_STRUCT_CONDUC")
public class VTypeStructConduc implements java.io.Serializable {

	private String code;
	private String libelle;

	public VTypeStructConduc() {
	}

	public VTypeStructConduc(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	@Id
	@Column(name = "CODE", length = 3)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "LIBELLE", length = 28)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
