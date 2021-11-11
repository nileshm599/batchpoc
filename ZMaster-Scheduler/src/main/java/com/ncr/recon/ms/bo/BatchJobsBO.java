package com.ncr.recon.ms.bo;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BATCH_JOBS")
public class BatchJobsBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "hibernateUUIDGenerator")
	@GenericGenerator(name = "hibernateUUIDGenerator", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;// We need to change it from UUID to Integer for Testing purpose

	@Column(name = "JOB_NAME",length = 30)
	private String jobname;

	@Column(name = "SCHEME_NAME",length = 30)
	private String schemename;

	@Column(name = "DIRECTIONS",length = 30)
	private String directions;

	@Column(name = "SPRING_DETAILS",length = 20)
	private String springdetails;

	@Column(name = "RERUN_DETAILS",length = 30)
	private String rerundetails;

	@Column(name = "FILE_LOCATION",length = 70)
	private String filelocation;

	public BatchJobsBO() {
	}

	public BatchJobsBO(UUID id, String jobname, String schemename, String directions, String springdetails,
			String rerundetails, String filelocation) {
		this.id = id;
		this.jobname = jobname;
		this.schemename = schemename;
		this.directions = directions;
		this.springdetails = springdetails;
		this.rerundetails = rerundetails;
		this.filelocation = filelocation;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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
		return "BatchJobsBO [id=" + id + ", jobname=" + jobname + ", schemename=" + schemename + ", directions="
				+ directions + ", springdetails=" + springdetails + ", rerundetails=" + rerundetails + ", filelocation="
				+ filelocation + "]";
	}

}// class
