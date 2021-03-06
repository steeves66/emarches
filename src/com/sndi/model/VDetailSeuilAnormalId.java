package com.sndi.model;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDetailSeuilAnormalId generated by hbm2java
 */
@Embeddable
public class VDetailSeuilAnormalId implements java.io.Serializable {

	private BigDecimal RId;
	private BigDecimal dofLaaId;
	private BigDecimal laaMtEst;
	private BigDecimal moyOffFinQualtech;
	private BigDecimal moyPonderee;
	private BigDecimal sf1;
	private BigDecimal sf2;
	private BigDecimal laaNum;
	private BigDecimal dofNum;
	private String offSouNcc;
	private BigDecimal dofMtCor;
	private BigDecimal valeurScore;
	private String aaoRegQual;
	private BigDecimal dofDelai;
	private String offSouSigleSte;
	private String laaAaoCode;
	private String laaDacCode;
	private String laaObjet;
	private String dofRepeche;
	private String commentaireOffin;
	private String commentaireAnormal;
	private String commentaireOffret;
	private BigDecimal triOffre;
	private String commentaire;
	private BigDecimal mtMoinsDisant;
	private String seuilAnormal;

	public VDetailSeuilAnormalId() {
	}

	public VDetailSeuilAnormalId(BigDecimal dofLaaId, BigDecimal dofNum, BigDecimal dofDelai) {
		this.dofLaaId = dofLaaId;
		this.dofNum = dofNum;
		this.dofDelai = dofDelai;
	}

	public VDetailSeuilAnormalId(BigDecimal RId, BigDecimal dofLaaId, BigDecimal laaMtEst, BigDecimal moyOffFinQualtech,
			BigDecimal moyPonderee, BigDecimal sf1, BigDecimal sf2, BigDecimal laaNum, BigDecimal dofNum,
			String offSouNcc, BigDecimal dofMtCor, BigDecimal valeurScore, String aaoRegQual, BigDecimal dofDelai,
			String offSouSigleSte, String laaAaoCode, String laaDacCode, String laaObjet, String dofRepeche,
			String commentaireOffin, String commentaireAnormal, String commentaireOffret, BigDecimal triOffre,
			String commentaire, BigDecimal mtMoinsDisant, String seuilAnormal) {
		this.RId = RId;
		this.dofLaaId = dofLaaId;
		this.laaMtEst = laaMtEst;
		this.moyOffFinQualtech = moyOffFinQualtech;
		this.moyPonderee = moyPonderee;
		this.sf1 = sf1;
		this.sf2 = sf2;
		this.laaNum = laaNum;
		this.dofNum = dofNum;
		this.offSouNcc = offSouNcc;
		this.dofMtCor = dofMtCor;
		this.valeurScore = valeurScore;
		this.aaoRegQual = aaoRegQual;
		this.dofDelai = dofDelai;
		this.offSouSigleSte = offSouSigleSte;
		this.laaAaoCode = laaAaoCode;
		this.laaDacCode = laaDacCode;
		this.laaObjet = laaObjet;
		this.dofRepeche = dofRepeche;
		this.commentaireOffin = commentaireOffin;
		this.commentaireAnormal = commentaireAnormal;
		this.commentaireOffret = commentaireOffret;
		this.triOffre = triOffre;
		this.commentaire = commentaire;
		this.mtMoinsDisant = mtMoinsDisant;
		this.seuilAnormal = seuilAnormal;
	}

	@Column(name = "R_ID", precision = 22, scale = 0)
	public BigDecimal getRId() {
		return this.RId;
	}

	public void setRId(BigDecimal RId) {
		this.RId = RId;
	}

	@Column(name = "DOF_LAA_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofLaaId() {
		return this.dofLaaId;
	}

	public void setDofLaaId(BigDecimal dofLaaId) {
		this.dofLaaId = dofLaaId;
	}

	@Column(name = "LAA_MT_EST", precision = 22, scale = 0)
	public BigDecimal getLaaMtEst() {
		return this.laaMtEst;
	}

	public void setLaaMtEst(BigDecimal laaMtEst) {
		this.laaMtEst = laaMtEst;
	}

	@Column(name = "MOY_OFF_FIN_QUALTECH", precision = 22, scale = 0)
	public BigDecimal getMoyOffFinQualtech() {
		return this.moyOffFinQualtech;
	}

	public void setMoyOffFinQualtech(BigDecimal moyOffFinQualtech) {
		this.moyOffFinQualtech = moyOffFinQualtech;
	}

	@Column(name = "MOY_PONDEREE", precision = 22, scale = 0)
	public BigDecimal getMoyPonderee() {
		return this.moyPonderee;
	}

	public void setMoyPonderee(BigDecimal moyPonderee) {
		this.moyPonderee = moyPonderee;
	}

	@Column(name = "SF1", precision = 22, scale = 0)
	public BigDecimal getSf1() {
		return this.sf1;
	}

	public void setSf1(BigDecimal sf1) {
		this.sf1 = sf1;
	}

	@Column(name = "SF2", precision = 22, scale = 0)
	public BigDecimal getSf2() {
		return this.sf2;
	}

	public void setSf2(BigDecimal sf2) {
		this.sf2 = sf2;
	}

	@Column(name = "LAA_NUM", precision = 22, scale = 0)
	public BigDecimal getLaaNum() {
		return this.laaNum;
	}

	public void setLaaNum(BigDecimal laaNum) {
		this.laaNum = laaNum;
	}

	@Column(name = "DOF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofNum() {
		return this.dofNum;
	}

	public void setDofNum(BigDecimal dofNum) {
		this.dofNum = dofNum;
	}

	@Column(name = "OFF_SOU_NCC", length = 20)
	public String getOffSouNcc() {
		return this.offSouNcc;
	}

	public void setOffSouNcc(String offSouNcc) {
		this.offSouNcc = offSouNcc;
	}

	@Column(name = "DOF_MT_COR", precision = 20, scale = 0)
	public BigDecimal getDofMtCor() {
		return this.dofMtCor;
	}

	public void setDofMtCor(BigDecimal dofMtCor) {
		this.dofMtCor = dofMtCor;
	}

	@Column(name = "VALEUR_SCORE", precision = 22, scale = 0)
	public BigDecimal getValeurScore() {
		return this.valeurScore;
	}

	public void setValeurScore(BigDecimal valeurScore) {
		this.valeurScore = valeurScore;
	}

	@Column(name = "AAO_REG_QUAL", length = 100)
	public String getAaoRegQual() {
		return this.aaoRegQual;
	}

	public void setAaoRegQual(String aaoRegQual) {
		this.aaoRegQual = aaoRegQual;
	}

	@Column(name = "DOF_DELAI", nullable = false, precision = 20, scale = 0)
	public BigDecimal getDofDelai() {
		return this.dofDelai;
	}

	public void setDofDelai(BigDecimal dofDelai) {
		this.dofDelai = dofDelai;
	}

	@Column(name = "OFF_SOU_SIGLE_STE", length = 500)
	public String getOffSouSigleSte() {
		return this.offSouSigleSte;
	}

	public void setOffSouSigleSte(String offSouSigleSte) {
		this.offSouSigleSte = offSouSigleSte;
	}

	@Column(name = "LAA_AAO_CODE", length = 20)
	public String getLaaAaoCode() {
		return this.laaAaoCode;
	}

	public void setLaaAaoCode(String laaAaoCode) {
		this.laaAaoCode = laaAaoCode;
	}

	@Column(name = "LAA_DAC_CODE", length = 20)
	public String getLaaDacCode() {
		return this.laaDacCode;
	}

	public void setLaaDacCode(String laaDacCode) {
		this.laaDacCode = laaDacCode;
	}

	@Column(name = "LAA_OBJET", length = 1000)
	public String getLaaObjet() {
		return this.laaObjet;
	}

	public void setLaaObjet(String laaObjet) {
		this.laaObjet = laaObjet;
	}

	@Column(name = "DOF_REPECHE", length = 1)
	public String getDofRepeche() {
		return this.dofRepeche;
	}

	public void setDofRepeche(String dofRepeche) {
		this.dofRepeche = dofRepeche;
	}

	@Column(name = "COMMENTAIRE_OFFIN", length = 500)
	public String getCommentaireOffin() {
		return this.commentaireOffin;
	}

	public void setCommentaireOffin(String commentaireOffin) {
		this.commentaireOffin = commentaireOffin;
	}

	@Column(name = "COMMENTAIRE_ANORMAL", length = 500)
	public String getCommentaireAnormal() {
		return this.commentaireAnormal;
	}

	public void setCommentaireAnormal(String commentaireAnormal) {
		this.commentaireAnormal = commentaireAnormal;
	}

	@Column(name = "COMMENTAIRE_OFFRET", length = 500)
	public String getCommentaireOffret() {
		return this.commentaireOffret;
	}

	public void setCommentaireOffret(String commentaireOffret) {
		this.commentaireOffret = commentaireOffret;
	}

	@Column(name = "TRI_OFFRE", precision = 22, scale = 0)
	public BigDecimal getTriOffre() {
		return this.triOffre;
	}

	public void setTriOffre(BigDecimal triOffre) {
		this.triOffre = triOffre;
	}

	@Column(name = "COMMENTAIRE", length = 1158)
	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Column(name = "MT_MOINS_DISANT", precision = 22, scale = 0)
	public BigDecimal getMtMoinsDisant() {
		return this.mtMoinsDisant;
	}

	public void setMtMoinsDisant(BigDecimal mtMoinsDisant) {
		this.mtMoinsDisant = mtMoinsDisant;
	}

	@Column(name = "SEUIL_ANORMAL", length = 2)
	public String getSeuilAnormal() {
		return this.seuilAnormal;
	}

	public void setSeuilAnormal(String seuilAnormal) {
		this.seuilAnormal = seuilAnormal;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDetailSeuilAnormalId))
			return false;
		VDetailSeuilAnormalId castOther = (VDetailSeuilAnormalId) other;

		return ((this.getRId() == castOther.getRId())
				|| (this.getRId() != null && castOther.getRId() != null && this.getRId().equals(castOther.getRId())))
				&& ((this.getDofLaaId() == castOther.getDofLaaId()) || (this.getDofLaaId() != null
						&& castOther.getDofLaaId() != null && this.getDofLaaId().equals(castOther.getDofLaaId())))
				&& ((this.getLaaMtEst() == castOther.getLaaMtEst()) || (this.getLaaMtEst() != null
						&& castOther.getLaaMtEst() != null && this.getLaaMtEst().equals(castOther.getLaaMtEst())))
				&& ((this.getMoyOffFinQualtech() == castOther.getMoyOffFinQualtech())
						|| (this.getMoyOffFinQualtech() != null && castOther.getMoyOffFinQualtech() != null
								&& this.getMoyOffFinQualtech().equals(castOther.getMoyOffFinQualtech())))
				&& ((this.getMoyPonderee() == castOther.getMoyPonderee())
						|| (this.getMoyPonderee() != null && castOther.getMoyPonderee() != null
								&& this.getMoyPonderee().equals(castOther.getMoyPonderee())))
				&& ((this.getSf1() == castOther.getSf1()) || (this.getSf1() != null && castOther.getSf1() != null
						&& this.getSf1().equals(castOther.getSf1())))
				&& ((this.getSf2() == castOther.getSf2()) || (this.getSf2() != null && castOther.getSf2() != null
						&& this.getSf2().equals(castOther.getSf2())))
				&& ((this.getLaaNum() == castOther.getLaaNum()) || (this.getLaaNum() != null
						&& castOther.getLaaNum() != null && this.getLaaNum().equals(castOther.getLaaNum())))
				&& ((this.getDofNum() == castOther.getDofNum()) || (this.getDofNum() != null
						&& castOther.getDofNum() != null && this.getDofNum().equals(castOther.getDofNum())))
				&& ((this.getOffSouNcc() == castOther.getOffSouNcc()) || (this.getOffSouNcc() != null
						&& castOther.getOffSouNcc() != null && this.getOffSouNcc().equals(castOther.getOffSouNcc())))
				&& ((this.getDofMtCor() == castOther.getDofMtCor()) || (this.getDofMtCor() != null
						&& castOther.getDofMtCor() != null && this.getDofMtCor().equals(castOther.getDofMtCor())))
				&& ((this.getValeurScore() == castOther.getValeurScore())
						|| (this.getValeurScore() != null && castOther.getValeurScore() != null
								&& this.getValeurScore().equals(castOther.getValeurScore())))
				&& ((this.getAaoRegQual() == castOther.getAaoRegQual()) || (this.getAaoRegQual() != null
						&& castOther.getAaoRegQual() != null && this.getAaoRegQual().equals(castOther.getAaoRegQual())))
				&& ((this.getDofDelai() == castOther.getDofDelai()) || (this.getDofDelai() != null
						&& castOther.getDofDelai() != null && this.getDofDelai().equals(castOther.getDofDelai())))
				&& ((this.getOffSouSigleSte() == castOther.getOffSouSigleSte())
						|| (this.getOffSouSigleSte() != null && castOther.getOffSouSigleSte() != null
								&& this.getOffSouSigleSte().equals(castOther.getOffSouSigleSte())))
				&& ((this.getLaaAaoCode() == castOther.getLaaAaoCode()) || (this.getLaaAaoCode() != null
						&& castOther.getLaaAaoCode() != null && this.getLaaAaoCode().equals(castOther.getLaaAaoCode())))
				&& ((this.getLaaDacCode() == castOther.getLaaDacCode()) || (this.getLaaDacCode() != null
						&& castOther.getLaaDacCode() != null && this.getLaaDacCode().equals(castOther.getLaaDacCode())))
				&& ((this.getLaaObjet() == castOther.getLaaObjet()) || (this.getLaaObjet() != null
						&& castOther.getLaaObjet() != null && this.getLaaObjet().equals(castOther.getLaaObjet())))
				&& ((this.getDofRepeche() == castOther.getDofRepeche()) || (this.getDofRepeche() != null
						&& castOther.getDofRepeche() != null && this.getDofRepeche().equals(castOther.getDofRepeche())))
				&& ((this.getCommentaireOffin() == castOther.getCommentaireOffin())
						|| (this.getCommentaireOffin() != null && castOther.getCommentaireOffin() != null
								&& this.getCommentaireOffin().equals(castOther.getCommentaireOffin())))
				&& ((this.getCommentaireAnormal() == castOther.getCommentaireAnormal())
						|| (this.getCommentaireAnormal() != null && castOther.getCommentaireAnormal() != null
								&& this.getCommentaireAnormal().equals(castOther.getCommentaireAnormal())))
				&& ((this.getCommentaireOffret() == castOther.getCommentaireOffret())
						|| (this.getCommentaireOffret() != null && castOther.getCommentaireOffret() != null
								&& this.getCommentaireOffret().equals(castOther.getCommentaireOffret())))
				&& ((this.getTriOffre() == castOther.getTriOffre()) || (this.getTriOffre() != null
						&& castOther.getTriOffre() != null && this.getTriOffre().equals(castOther.getTriOffre())))
				&& ((this.getCommentaire() == castOther.getCommentaire())
						|| (this.getCommentaire() != null && castOther.getCommentaire() != null
								&& this.getCommentaire().equals(castOther.getCommentaire())))
				&& ((this.getMtMoinsDisant() == castOther.getMtMoinsDisant())
						|| (this.getMtMoinsDisant() != null && castOther.getMtMoinsDisant() != null
								&& this.getMtMoinsDisant().equals(castOther.getMtMoinsDisant())))
				&& ((this.getSeuilAnormal() == castOther.getSeuilAnormal())
						|| (this.getSeuilAnormal() != null && castOther.getSeuilAnormal() != null
								&& this.getSeuilAnormal().equals(castOther.getSeuilAnormal())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRId() == null ? 0 : this.getRId().hashCode());
		result = 37 * result + (getDofLaaId() == null ? 0 : this.getDofLaaId().hashCode());
		result = 37 * result + (getLaaMtEst() == null ? 0 : this.getLaaMtEst().hashCode());
		result = 37 * result + (getMoyOffFinQualtech() == null ? 0 : this.getMoyOffFinQualtech().hashCode());
		result = 37 * result + (getMoyPonderee() == null ? 0 : this.getMoyPonderee().hashCode());
		result = 37 * result + (getSf1() == null ? 0 : this.getSf1().hashCode());
		result = 37 * result + (getSf2() == null ? 0 : this.getSf2().hashCode());
		result = 37 * result + (getLaaNum() == null ? 0 : this.getLaaNum().hashCode());
		result = 37 * result + (getDofNum() == null ? 0 : this.getDofNum().hashCode());
		result = 37 * result + (getOffSouNcc() == null ? 0 : this.getOffSouNcc().hashCode());
		result = 37 * result + (getDofMtCor() == null ? 0 : this.getDofMtCor().hashCode());
		result = 37 * result + (getValeurScore() == null ? 0 : this.getValeurScore().hashCode());
		result = 37 * result + (getAaoRegQual() == null ? 0 : this.getAaoRegQual().hashCode());
		result = 37 * result + (getDofDelai() == null ? 0 : this.getDofDelai().hashCode());
		result = 37 * result + (getOffSouSigleSte() == null ? 0 : this.getOffSouSigleSte().hashCode());
		result = 37 * result + (getLaaAaoCode() == null ? 0 : this.getLaaAaoCode().hashCode());
		result = 37 * result + (getLaaDacCode() == null ? 0 : this.getLaaDacCode().hashCode());
		result = 37 * result + (getLaaObjet() == null ? 0 : this.getLaaObjet().hashCode());
		result = 37 * result + (getDofRepeche() == null ? 0 : this.getDofRepeche().hashCode());
		result = 37 * result + (getCommentaireOffin() == null ? 0 : this.getCommentaireOffin().hashCode());
		result = 37 * result + (getCommentaireAnormal() == null ? 0 : this.getCommentaireAnormal().hashCode());
		result = 37 * result + (getCommentaireOffret() == null ? 0 : this.getCommentaireOffret().hashCode());
		result = 37 * result + (getTriOffre() == null ? 0 : this.getTriOffre().hashCode());
		result = 37 * result + (getCommentaire() == null ? 0 : this.getCommentaire().hashCode());
		result = 37 * result + (getMtMoinsDisant() == null ? 0 : this.getMtMoinsDisant().hashCode());
		result = 37 * result + (getSeuilAnormal() == null ? 0 : this.getSeuilAnormal().hashCode());
		return result;
	}

}
