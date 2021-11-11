package com.ncr.recon.ms.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BatchJobsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String jobname;
	private String schemename;
	private String directions;
	private String springdetails;
	private String rerundetails;
	private String filelocation;

	public BatchJobsDTO() {
	}

	public BatchJobsDTO(String id, String jobname, String schemename, String directions, String springdetails,
			String rerundetails, String filelocation) {
		this.id = id;
		this.jobname = jobname;
		this.schemename = schemename;
		this.directions = directions;
		this.springdetails = springdetails;
		this.rerundetails = rerundetails;
		this.filelocation = filelocation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getSchemename() {
		return schemename;
	}

	public void setSchemename(String schemename) {
		this.schemename = schemename;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getSpringdetails() {
		return springdetails;
	}

	public void setSpringdetails(String springdetails) {
		this.springdetails = springdetails;
	}

	public String getRerundetails() {
		return rerundetails;
	}

	public void setRerundetails(String rerundetails) {
		this.rerundetails = rerundetails;
	}

	public String getFilelocation() {
		return filelocation;
	}

	public void setFilelocation(String filelocation) {
		this.filelocation = filelocation;
	}

	@Override
	public String toString() {
		return "BatchJobsDTO [id=" + id + ", jobname=" + jobname + ", schemename=" + schemename + ", directions="
				+ directions + ", springdetails=" + springdetails + ", rerundetails=" + rerundetails + ", filelocation="
				+ filelocation + "]";
	}
}// class
