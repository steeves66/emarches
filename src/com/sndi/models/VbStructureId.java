package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbStructureId generated by hbm2java
 */
@Embeddable
public class VbStructureId implements java.io.Serializable {

	private String strCode;
	private String strLibelleCourt;
	private String strLibelleLong;
	private String strAdresse;
	private String strEmail;
	private String strMinCode;
	private String strTstCode;
	private String strRegCode;
	private String strAdrPost;
	private String strAdrGeo;
	private String strTel;
	private String strFax;
	private String strOpeMatricule;
	private Date strDteSaisi;
	private String strOpeRespo;

	public VbStructureId() {
	}

	public VbStructureId(String strCode, String strLibelleCourt, String strMinCode) {
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
		this.strMinCode = strMinCode;
	}

	public VbStructureId(String strCode, String strLibelleCourt, String strLibelleLong, String strAdresse,
			String strEmail, String strMinCode, String strTstCode, String strRegCode, String strAdrPost,
			String strAdrGeo, String strTel, String strFax, String strOpeMatricule, Date strDteSaisi,
			String strOpeRespo) {
		this.strCode = strCode;
		this.strLibelleCourt = strLibelleCourt;
		this.strLibelleLong = strLibelleLong;
		this.strAdresse = strAdresse;
		this.strEmail = strEmail;
		this.strMinCode = strMinCode;
		this.strTstCode = strTstCode;
		this.strRegCode = strRegCode;
		this.strAdrPost = strAdrPost;
		this.strAdrGeo = strAdrGeo;
		this.strTel = strTel;
		this.strFax = strFax;
		this.strOpeMatricule = strOpeMatricule;
		this.strDteSaisi = strDteSaisi;
		this.strOpeRespo = strOpeRespo;
	}

	@Column(name = "STR_CODE", nullable = false, length = 20)
	public String getStrCode() {
		return this.strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	@Column(name = "STR_LIBELLE_COURT", nullable = false, length = 500)
	public String getStrLibelleCourt() {
		return this.strLibelleCourt;
	}

	public void setStrLibelleCourt(String strLibelleCourt) {
		this.strLibelleCourt = strLibelleCourt;
	}

	@Column(name = "STR_LIBELLE_LONG", length = 1000)
	public String getStrLibelleLong() {
		return this.strLibelleLong;
	}

	public void setStrLibelleLong(String strLibelleLong) {
		this.strLibelleLong = strLibelleLong;
	}

	@Column(name = "STR_ADRESSE", length = 500)
	public String getStrAdresse() {
		return this.strAdresse;
	}

	public void setStrAdresse(String strAdresse) {
		this.strAdresse = strAdresse;
	}

	@Column(name = "STR_EMAIL", length = 500)
	public String getStrEmail() {
		return this.strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	@Column(name = "STR_MIN_CODE", nullable = false, length = 20)
	public String getStrMinCode() {
		return this.strMinCode;
	}

	public void setStrMinCode(String strMinCode) {
		this.strMinCode = strMinCode;
	}

	@Column(name = "STR_TST_CODE", length = 3)
	public String getStrTstCode() {
		return this.strTstCode;
	}

	public void setStrTstCode(String strTstCode) {
		this.strTstCode = strTstCode;
	}

	@Column(name = "STR_REG_CODE", length = 10)
	public String getStrRegCode() {
		return this.strRegCode;
	}

	public void setStrRegCode(String strRegCode) {
		this.strRegCode = strRegCode;
	}

	@Column(name = "STR_ADR_POST", length = 200)
	public String getStrAdrPost() {
		return this.strAdrPost;
	}

	public void setStrAdrPost(String strAdrPost) {
		this.strAdrPost = strAdrPost;
	}

	@Column(name = "STR_ADR_GEO", length = 200)
	public String getStrAdrGeo() {
		return this.strAdrGeo;
	}

	public void setStrAdrGeo(String strAdrGeo) {
		this.strAdrGeo = strAdrGeo;
	}

	@Column(name = "STR_TEL", length = 100)
	public String getStrTel() {
		return this.strTel;
	}

	public void setStrTel(String strTel) {
		this.strTel = strTel;
	}

	@Column(name = "STR_FAX", length = 50)
	public String getStrFax() {
		return this.strFax;
	}

	public void setStrFax(String strFax) {
		this.strFax = strFax;
	}

	@Column(name = "STR_OPE_MATRICULE", length = 25)
	public String getStrOpeMatricule() {
		return this.strOpeMatricule;
	}

	public void setStrOpeMatricule(String strOpeMatricule) {
		this.strOpeMatricule = strOpeMatricule;
	}

	@Column(name = "STR_DTE_SAISI", length = 7)
	public Date getStrDteSaisi() {
		return this.strDteSaisi;
	}

	public void setStrDteSaisi(Date strDteSaisi) {
		this.strDteSaisi = strDteSaisi;
	}

	@Column(name = "STR_OPE_RESPO", length = 1)
	public String getStrOpeRespo() {
		return this.strOpeRespo;
	}

	public void setStrOpeRespo(String strOpeRespo) {
		this.strOpeRespo = strOpeRespo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbStructureId))
			return false;
		VbStructureId castOther = (VbStructureId) other;

		return ((this.getStrCode() == castOther.getStrCode()) || (this.getStrCode() != null
				&& castOther.getStrCode() != null && this.getStrCode().equals(castOther.getStrCode())))
				&& ((this.getStrLibelleCourt() == castOther.getStrLibelleCourt())
						|| (this.getStrLibelleCourt() != null && castOther.getStrLibelleCourt() != null
								&& this.getStrLibelleCourt().equals(castOther.getStrLibelleCourt())))
				&& ((this.getStrLibelleLong() == castOther.getStrLibelleLong())
						|| (this.getStrLibelleLong() != null && castOther.getStrLibelleLong() != null
								&& this.getStrLibelleLong().equals(castOther.getStrLibelleLong())))
				&& ((this.getStrAdresse() == castOther.getStrAdresse()) || (this.getStrAdresse() != null
						&& castOther.getStrAdresse() != null && this.getStrAdresse().equals(castOther.getStrAdresse())))
				&& ((this.getStrEmail() == castOther.getStrEmail()) || (this.getStrEmail() != null
						&& castOther.getStrEmail() != null && this.getStrEmail().equals(castOther.getStrEmail())))
				&& ((this.getStrMinCode() == castOther.getStrMinCode()) || (this.getStrMinCode() != null
						&& castOther.getStrMinCode() != null && this.getStrMinCode().equals(castOther.getStrMinCode())))
				&& ((this.getStrTstCode() == castOther.getStrTstCode()) || (this.getStrTstCode() != null
						&& castOther.getStrTstCode() != null && this.getStrTstCode().equals(castOther.getStrTstCode())))
				&& ((this.getStrRegCode() == castOther.getStrRegCode()) || (this.getStrRegCode() != null
						&& castOther.getStrRegCode() != null && this.getStrRegCode().equals(castOther.getStrRegCode())))
				&& ((this.getStrAdrPost() == castOther.getStrAdrPost()) || (this.getStrAdrPost() != null
						&& castOther.getStrAdrPost() != null && this.getStrAdrPost().equals(castOther.getStrAdrPost())))
				&& ((this.getStrAdrGeo() == castOther.getStrAdrGeo()) || (this.getStrAdrGeo() != null
						&& castOther.getStrAdrGeo() != null && this.getStrAdrGeo().equals(castOther.getStrAdrGeo())))
				&& ((this.getStrTel() == castOther.getStrTel()) || (this.getStrTel() != null
						&& castOther.getStrTel() != null && this.getStrTel().equals(castOther.getStrTel())))
				&& ((this.getStrFax() == castOther.getStrFax()) || (this.getStrFax() != null
						&& castOther.getStrFax() != null && this.getStrFax().equals(castOther.getStrFax())))
				&& ((this.getStrOpeMatricule() == castOther.getStrOpeMatricule())
						|| (this.getStrOpeMatricule() != null && castOther.getStrOpeMatricule() != null
								&& this.getStrOpeMatricule().equals(castOther.getStrOpeMatricule())))
				&& ((this.getStrDteSaisi() == castOther.getStrDteSaisi())
						|| (this.getStrDteSaisi() != null && castOther.getStrDteSaisi() != null
								&& this.getStrDteSaisi().equals(castOther.getStrDteSaisi())))
				&& ((this.getStrOpeRespo() == castOther.getStrOpeRespo())
						|| (this.getStrOpeRespo() != null && castOther.getStrOpeRespo() != null
								&& this.getStrOpeRespo().equals(castOther.getStrOpeRespo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStrCode() == null ? 0 : this.getStrCode().hashCode());
		result = 37 * result + (getStrLibelleCourt() == null ? 0 : this.getStrLibelleCourt().hashCode());
		result = 37 * result + (getStrLibelleLong() == null ? 0 : this.getStrLibelleLong().hashCode());
		result = 37 * result + (getStrAdresse() == null ? 0 : this.getStrAdresse().hashCode());
		result = 37 * result + (getStrEmail() == null ? 0 : this.getStrEmail().hashCode());
		result = 37 * result + (getStrMinCode() == null ? 0 : this.getStrMinCode().hashCode());
		result = 37 * result + (getStrTstCode() == null ? 0 : this.getStrTstCode().hashCode());
		result = 37 * result + (getStrRegCode() == null ? 0 : this.getStrRegCode().hashCode());
		result = 37 * result + (getStrAdrPost() == null ? 0 : this.getStrAdrPost().hashCode());
		result = 37 * result + (getStrAdrGeo() == null ? 0 : this.getStrAdrGeo().hashCode());
		result = 37 * result + (getStrTel() == null ? 0 : this.getStrTel().hashCode());
		result = 37 * result + (getStrFax() == null ? 0 : this.getStrFax().hashCode());
		result = 37 * result + (getStrOpeMatricule() == null ? 0 : this.getStrOpeMatricule().hashCode());
		result = 37 * result + (getStrDteSaisi() == null ? 0 : this.getStrDteSaisi().hashCode());
		result = 37 * result + (getStrOpeRespo() == null ? 0 : this.getStrOpeRespo().hashCode());
		return result;
	}

}
