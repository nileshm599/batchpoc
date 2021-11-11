package com.ncr.recon.ms.bo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BATCH_HISTORY")
public class BatchHistoryBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(unique = true)
	private UUID id;

	@Column(name = "JOB_NAME", length = 50)
	private String jobName;

	@Column(name = "TIME_RUN")
	private LocalDateTime timeRun;

	@Column(name = "BATCH_WINDOW", length = 50) // Indicates what records were covered by job such as time range for
												// transactions
	private String batchWindow;

	@Column(name = "MANUAL_TRIGGER_DETAILS", length = 50) // If manually triggered keep details of who triggerred it
	private String manualTriggerDetails;

	@Column(name = "JOB_STATUS", length = 20)
	private String jobStatus;

	public BatchHistoryBO() {

	}

	public BatchHistoryBO(UUID id, String jobName, LocalDateTime timeRun, String batchWindow,
			String manualTriggerDetails, String jobStatus) {
		this.id = id;
		this.jobName = jobName;
		this.timeRun = timeRun;
		this.batchWindow = batchWindow;
		this.manualTriggerDetails = manualTriggerDetails;
		this.jobStatus = jobStatus;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public LocalDateTime getTimeRun() {
		return timeRun;
	}

	public void setTimeRun(LocalDateTime timeRun) {
		this.timeRun = timeRun;
	}

	public String getBatchWindow() {
		return batchWindow;
	}

	public void setBatchWindow(String batchWindow) {
		this.batchWindow = batchWindow;
	}

	public String getManualTriggerDetails() {
		return manualTriggerDetails;
	}

	public void setManualTriggerDetails(String manualTriggerDetails) {
		this.manualTriggerDetails = manualTriggerDetails;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	@Override
	public String toString() {
		return "BatchHistoryBO [id=" + id + ", jobName=" + jobName + ", timeRun=" + timeRun + ", batchWindow="
				+ batchWindow + ", manualTriggerDetails=" + manualTriggerDetails + ", jobStatus=" + jobStatus + "]";
	}

}// class
