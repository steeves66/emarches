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
@Table(name = "V_FONCTION_ASSIGNATION_RECH")
public class VFonctionAssignationRech 
{
	@Id
	@Column(name = "FON_COD", unique = true, nullable = false, length = 25)
	private String fonCod;
	
	@Column(name = "FON_TYF_COD")
	private String fonTyfCod;
	
	@Column(name = "FON_LIBELLE", length = 250)
	private String fonLibelle;
	
	@Column(name = "FON_LIBELLE_CRT", length = 250)
	private String fonLibelleCourt;
	
	@Column(name = "MIN_LIBELLE", length = 250)
	private String minLibelle;
	
	@Column(name = "FON_CODE_DMP", length = 50)
	private String fonCodeDmp;
	
	@Column(name = "FON_STR_CODE", length = 3)
	private String fonStrCode;
	
	@Column(name = "FON_MIN_CODE", length = 500)
	private String fonMinCode;
	
	@Column(name = "FON_RECH")
	private String fonRech;
	
	public TFonction getFonction()
	{
		TFonction fonction =  new TFonction();
		fonction.setFonCod(this.fonCod);
		fonction.setFonLibelle(fonLibelle);
		fonction.setFonLibelleCrt(fonLibelleCourt);
		fonction.setFonCodeDmp(fonCodeDmp);
		return fonction;
	}
}
