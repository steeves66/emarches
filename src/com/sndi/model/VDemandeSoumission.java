package com.sndi.model;
// Generated 8 juil. 2021 19:57:16 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VDemandeSoumissionId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_DEMANDE_SOUMISSION")
@AllArgsConstructor @NoArgsConstructor @Data
public class VDemandeSoumission implements java.io.Serializable {

	@Id
	@Column(name = "R_ID", precision = 22, scale = 0)
	private BigDecimal RId;
	
	@Column(name = "SOU_NCC", length = 20)
	private String souNcc;
	
	@Column(name = "SOU_SIGLE_STE", length = 500)
	private String souSigleSte;
	
	@Column(name = "SOU_NOM_COM", length = 500)
	private String souNomCom;
	
	@Column(name = "SOU_ADRESSE", length = 200)
	private String souAdresse;
	
	@Column(name = "SOU_TEL", length = 200)
	private String souTel;
	
	@Column(name = "APR_DEM_NUM", precision = 22, scale = 0)
	private BigDecimal aprDemNum;
	
	@Column(name = "APR_OPE_MATRICULE", length = 25)
	private String aprOpeMatricule;
	
	@Column(name = "CRITERE", length = 1420)
	private String critere;


}
