package com.ncr.recon.ms.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BatchHistoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String jobName;
	private LocalDateTime timeRun;
	private String batchWindow;
	private String manualTriggerDetails;
	private String jobStatus;

	public BatchHistoryDTO() {

	}

	public BatchHistoryDTO(String id, String jobName, LocalDateTime timeRun, String batchWindow,
			String manualTriggerDetails, String jobStatus) {
		this.id = id;
		this.jobName = jobName;
		this.timeRun = timeRun;
		this.batchWindow = batchWindow;
		this.manualTriggerDetails = manualTriggerDetails;
		this.jobStatus = jobStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "BatchHistoryDTO [id=" + id + ", jobName=" + jobName + ", timeRun=" + timeRun + ", batchWindow="
				+ batchWindow + ", manualTriggerDetails=" + manualTriggerDetails + ", jobStatus=" + jobStatus + "]";
	}



}// class
