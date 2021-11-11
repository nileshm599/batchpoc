package com.ncr.recon.ms.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class NCRExceptionFormat {

	private LocalDateTime date;
	private HttpStatus httpStatus;
	private String message;
	private List<String> errorList;

	public NCRExceptionFormat() {
	}

	public NCRExceptionFormat(LocalDateTime date, HttpStatus httpStatus, String message, List<String> errorList) {
		this.date = date;
		this.httpStatus = httpStatus;
		this.message = message;
		this.errorList = errorList;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	@Override
	public String toString() {
		return "NCRExceptionFormat [date=" + date + ", httpStatus=" + httpStatus + ", message=" + message
				+ ", errorList=" + errorList + "]";
	}

}// class
