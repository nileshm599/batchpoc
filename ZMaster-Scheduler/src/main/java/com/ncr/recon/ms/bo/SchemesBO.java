package com.ncr.recon.ms.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEMES")
public class SchemesBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length = 5)
	private Integer id;

	@Column(name = "SCHEME_NAME", unique = true, length = 20)
	private String schemeName;// MC , VISA

	@Column(name = "SCHEME_DESCRIPTION", length = 70)
	private String schemeDescription;

	public SchemesBO() {
	}

	public SchemesBO(Integer id, String schemeName, String schemeDescription) {
		this.id = id;
		this.schemeName = schemeName;
		this.schemeDescription = schemeDescription;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeDescription() {
		return schemeDescription;
	}

	public void setSchemeDescription(String schemeDescription) {
		this.schemeDescription = schemeDescription;
	}

	@Override
	public String toString() {
		return "SchemesBO [id=" + id + ", schemeName=" + schemeName + ", schemeDescription=" + schemeDescription + "]";
	}

}// class
