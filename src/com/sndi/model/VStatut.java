package com.sndi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sndi.model.TStatut;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder

@Entity 
@Immutable
@Table(name = "V_STATUT", schema = "EMAP")
public class VStatut {
	
	@Id
	@Column(name = "STA_CODE", unique = true, nullable = false, length = 3)
	private String staCode;
	
	@Column(name = "STA_LIBELLE_COURT", length = 100)
	private String staLibelleCourt;
	
	@Column(name = "STA_LIBELLE_LONG", length = 300)
	private String staLibelleLong;
	
	@Column(name = "AC_LIBELLE", length = 100)
	private String acLibelle;
	
	@Column(name = "SODE_LIBELLE", length = 100)
	private String sodeLibelle;
	
	@Column(name = "CPMP_LIBELLE", length = 100)
	private String cpmpLibelle;
	
	@Column(name = "DGMP_LIBELLE", length = 100)
	private String dgmpLibelle;
	
	@Column(name = "DRMP_LIBELLE", length = 100)
	private String drmpLibelle;
	
	@Column(name = "CRITERE", length = 1000)
	private String critere;
	
	public TStatut getTstatut() {
		TStatut tStatut = new TStatut();
		tStatut.setStaCode(staCode);
		tStatut.setStaLibelleCourt(staLibelleCourt);
		tStatut.setStaLibelleLong(staLibelleLong);
		tStatut.setAcLibelle(acLibelle);
		tStatut.setCpmpLibelle(cpmpLibelle);
		tStatut.setDrmpLibelle(drmpLibelle);
		tStatut.setSodeLibelle(sodeLibelle);
		tStatut.setDgmpLibelle(dgmpLibelle);
		return tStatut;
	}

}
