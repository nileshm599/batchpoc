package com.ncr.recon.ms.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BATCH_SCHEDULE")
public class BatchScheduleBO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @GeneratedValue(generator = "uuid2")
	 * 
	 * @GenericGenerator(name = "uuid2", strategy =
	 * "org.hibernate.id.UUIDGenerator")
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private Integer id;

	@Column(name = "JOB_NAME", length = 50)
	private String jobName;

	@Column(name = "DAY_OF_WEEK")
	private LocalDate dayOfWeek;

	@Column(name = "TIME_OF_DAY")
	private LocalTime timeOfDay;

	@Column(name = "CRON_EXPRESSION", length = 50)
	private String cronExpression;

	public BatchScheduleBO() {
	}

	public BatchScheduleBO(Integer id, String jobName, LocalDate dayOfWeek, LocalTime timeOfDay,
			String cronExpression) {
		this.id = id;
		this.jobName = jobName;
		this.dayOfWeek = dayOfWeek;
		this.timeOfDay = timeOfDay;
		this.cronExpression = cronExpression;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "BatchScheduleBO [id=" + id + ", jobName=" + jobName + ", dayOfWeek=" + dayOfWeek + ", timeOfDay="
				+ timeOfDay + ", cronExpression=" + cronExpression + "]";
	}


}// class
