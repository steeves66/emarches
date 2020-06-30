package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VFonctionImputationId generated by hbm2java
 */
@Embeddable
public class VFonctionImputationId implements java.io.Serializable {

	private String opeMatricule;
	private String opeNom;
	private String opeContact;
	private String fonCod;
	private String fonLibelle;
	private String strCode;
	private String strOpeRespo;
	private BigDecimal nbrTraite;
	private BigDecimal nbrEnCours;
	private BigDecimal nbrValide;

	public VFonctionImputationId() {
	}

	public VFonctionImputationId(String opeMatricule, String fonCod, String strCode) {
		this.opeMatricule = opeMatricule;
		this.fonCod = fonCod;
		this.strCode = strCode;
	}

	public VFonctionImputationId(String opeMatricule, String opeNom, String opeContact, String fonCod,
			String fonLibelle, String strCode, String strOpeRespo, BigDecimal nbrTraite, BigDecimal nbrEnCours,
			BigDecimal nbrValide) {
		this.opeMatricule = opeMatricule;
		this.opeNom = opeNom;
		this.opeContact = opeContact;
		this.fonCod = fonCod;
		this.fonLibelle = fonLibelle;
		this.strCode = strCode;
		this.strOpeRespo = strOpeRespo;
		this.nbrTraite = nbrTraite;
		this.nbrEnCours = nbrEnCours;
		this.nbrValide = nbrValide;
	}

	@Column(name = "OPE_MATRICULE", nullable = false, length = 25)
	public String getOpeMatricule() {
		return this.opeMatricule;
	}

	public void setOpeMatricule(String opeMatricule) {
		this.opeMatricule = opeMatricule;
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

	@Column(name = "FON_COD", nullable = false, length = 20)
	public String getFonCod() {
		return this.fonCod;
	}

	public void setFonCod(String fonCod) {
		this.fonCod = fonCod;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "STR_CODE", nullable = false, length = 20)
	public String getStrCode() {
		return this.strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	@Column(name = "STR_OPE_RESPO", length = 1)
	public String getStrOpeRespo() {
		return this.strOpeRespo;
	}

	public void setStrOpeRespo(String strOpeRespo) {
		this.strOpeRespo = strOpeRespo;
	}

	@Column(name = "NBR_TRAITE", precision = 22, scale = 0)
	public BigDecimal getNbrTraite() {
		return this.nbrTraite;
	}

	public void setNbrTraite(BigDecimal nbrTraite) {
		this.nbrTraite = nbrTraite;
	}

	@Column(name = "NBR_EN_COURS", precision = 22, scale = 0)
	public BigDecimal getNbrEnCours() {
		return this.nbrEnCours;
	}

	public void setNbrEnCours(BigDecimal nbrEnCours) {
		this.nbrEnCours = nbrEnCours;
	}

	@Column(name = "NBR_VALIDE", precision = 22, scale = 0)
	public BigDecimal getNbrValide() {
		return this.nbrValide;
	}

	public void setNbrValide(BigDecimal nbrValide) {
		this.nbrValide = nbrValide;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VFonctionImputationId))
			return false;
		VFonctionImputationId castOther = (VFonctionImputationId) other;

		return ((this.getOpeMatricule() == castOther.getOpeMatricule()) || (this.getOpeMatricule() != null
				&& castOther.getOpeMatricule() != null && this.getOpeMatricule().equals(castOther.getOpeMatricule())))
				&& ((this.getOpeNom() == castOther.getOpeNom()) || (this.getOpeNom() != null
						&& castOther.getOpeNom() != null && this.getOpeNom().equals(castOther.getOpeNom())))
				&& ((this.getOpeContact() == castOther.getOpeContact()) || (this.getOpeContact() != null
						&& castOther.getOpeContact() != null && this.getOpeContact().equals(castOther.getOpeContact())))
				&& ((this.getFonCod() == castOther.getFonCod()) || (this.getFonCod() != null
						&& castOther.getFonCod() != null && this.getFonCod().equals(castOther.getFonCod())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getStrCode() == castOther.getStrCode()) || (this.getStrCode() != null
						&& castOther.getStrCode() != null && this.getStrCode().equals(castOther.getStrCode())))
				&& ((this.getStrOpeRespo() == castOther.getStrOpeRespo())
						|| (this.getStrOpeRespo() != null && castOther.getStrOpeRespo() != null
								&& this.getStrOpeRespo().equals(castOther.getStrOpeRespo())))
				&& ((this.getNbrTraite() == castOther.getNbrTraite()) || (this.getNbrTraite() != null
						&& castOther.getNbrTraite() != null && this.getNbrTraite().equals(castOther.getNbrTraite())))
				&& ((this.getNbrEnCours() == castOther.getNbrEnCours()) || (this.getNbrEnCours() != null
						&& castOther.getNbrEnCours() != null && this.getNbrEnCours().equals(castOther.getNbrEnCours())))
				&& ((this.getNbrValide() == castOther.getNbrValide()) || (this.getNbrValide() != null
						&& castOther.getNbrValide() != null && this.getNbrValide().equals(castOther.getNbrValide())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOpeMatricule() == null ? 0 : this.getOpeMatricule().hashCode());
		result = 37 * result + (getOpeNom() == null ? 0 : this.getOpeNom().hashCode());
		result = 37 * result + (getOpeContact() == null ? 0 : this.getOpeContact().hashCode());
		result = 37 * result + (getFonCod() == null ? 0 : this.getFonCod().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getStrCode() == null ? 0 : this.getStrCode().hashCode());
		result = 37 * result + (getStrOpeRespo() == null ? 0 : this.getStrOpeRespo().hashCode());
		result = 37 * result + (getNbrTraite() == null ? 0 : this.getNbrTraite().hashCode());
		result = 37 * result + (getNbrEnCours() == null ? 0 : this.getNbrEnCours().hashCode());
		result = 37 * result + (getNbrValide() == null ? 0 : this.getNbrValide().hashCode());
		return result;
	}

}
