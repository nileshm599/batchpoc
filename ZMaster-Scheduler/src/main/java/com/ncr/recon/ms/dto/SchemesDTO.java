package com.ncr.recon.ms.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SchemesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String schemeName;// MC , VISA
	private String schemeDescription;

	public SchemesDTO() {
	}

	public SchemesDTO(String id, String schemeName, String schemeDescription) {
		this.id = id;
		this.schemeName = schemeName;
		this.schemeDescription = schemeDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "SchemesDTO [id=" + id + ", schemeName=" + schemeName + ", schemeDescription=" + schemeDescription + "]";
	}

}// class
