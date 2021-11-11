package com.ncr.recon.ms.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class BatchScheduleDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	@NotEmpty(message = "Job Name Must Not Be Empty")
	@Size(min = 3, max = 30, message = "Job Name Must Contain Min 3 & Max 30 Characters")
	private String jobName;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dayOfWeek;

	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime timeOfDay;

	@NotEmpty(message = "CRON Expression Must Not Be Empty")
	@Size(min = 3, max = 30, message = "CRON Expression Must Contain Min 3 & Max 30 Characters")
	private String cronExpression;

	public BatchScheduleDTO() {
	}

	public BatchScheduleDTO(String id, String jobName, LocalDate dayOfWeek, LocalTime timeOfDay,
			String cronExpression) {
		this.id = id;
		this.jobName = jobName;
		this.dayOfWeek = dayOfWeek;
		this.timeOfDay = timeOfDay;
		this.cronExpression = cronExpression;
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

	public LocalDate getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(LocalDate dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(LocalTime timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	@Override
	public String toString() {
		return "BatchScheduleDTO [id=" + id + ", jobName=" + jobName + ", dayOfWeek=" + dayOfWeek + ", timeOfDay="
				+ timeOfDay + ", cronExpression=" + cronExpression + "]";
	}

}// class
