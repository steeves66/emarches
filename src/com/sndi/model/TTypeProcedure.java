package com.sndi.model;
// Generated 27 d�c. 2019 11:33:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TTypeProcedure generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_PROCEDURE", schema = "EMAP")
public class TTypeProcedure implements java.io.Serializable {

	private String typId;
	private String typLib;

	public TTypeProcedure() {
	}

	public TTypeProcedure(String typId) {
		this.typId = typId;
	}

	public TTypeProcedure(String typId, String typLib) {
		this.typId = typId;
		this.typLib = typLib;
	}

	@Id

	@Column(name = "TYP_ID", unique = true, nullable = false, length = 5)
	public String getTypId() {
		return this.typId;
	}

	public void setTypId(String typId) {
		this.typId = typId;
	}

	@Column(name = "TYP_LIB", length = 1000)
	public String getTypLib() {
		return this.typLib;
	}

	public void setTypLib(String typLib) {
		this.typLib = typLib;
	}

}
