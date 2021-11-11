package com.ncr.recon.ms.exceptions;

public class JobNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JobNotFoundException() {
	}

	public JobNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}

}// class
