package com.sndi.model;
// Generated 18 sept. 2020 12:53:42 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VArticlesComId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_ARTICLES_COM")
public class VArticlesCom implements java.io.Serializable {

	private String codeart;
	private String libart;

	public VArticlesCom() {
	}

	public VArticlesCom(String codeart, String libart) {
		this.codeart = codeart;
		this.libart = libart;
	}

	@Id
	@Column(name = "CODEART", length = 6)
	public String getCodeart() {
		return this.codeart;
	}

	public void setCodeart(String codeart) {
		this.codeart = codeart;
	}

	@Column(name = "LIBART", length = 69)
	public String getLibart() {
		return this.libart;
	}

	public void setLibart(String libart) {
		this.libart = libart;
	}

}
