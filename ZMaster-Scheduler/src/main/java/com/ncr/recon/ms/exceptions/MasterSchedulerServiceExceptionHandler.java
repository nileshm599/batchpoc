package com.ncr.recon.ms.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MasterSchedulerServiceExceptionHandler extends ResponseEntityExceptionHandler {
	static {
		System.out.println("Initialized : MasterSchedulerServiceExceptionHandler");
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		NCRExceptionFormat format = new NCRExceptionFormat();
		format.setDate(LocalDateTime.now());
		format.setHttpStatus(status);
		format.setMessage("You got " + ex.getErrorCount() + "Errors");
		format.setErrorList(ex.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()));
		return new ResponseEntity<>(format, HttpStatus.BAD_REQUEST);
	}// method

	@ExceptionHandler(JobNotFoundException.class)
	public ResponseEntity<Object> handleJobNotFoundException(JobNotFoundException ex) {
		NCRExceptionFormat format = new NCRExceptionFormat();
		format.setDate(LocalDateTime.now());
		format.setHttpStatus(HttpStatus.BAD_REQUEST);
		format.setMessage(ex.getMessage());
		return new ResponseEntity<>(format, HttpStatus.BAD_REQUEST);
	}// method

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		NCRExceptionFormat format = new NCRExceptionFormat();
		ArrayList<String> errorList = new ArrayList<String>();
		format.setDate(LocalDateTime.now());
		format.setHttpStatus(status);
		format.setMessage(request.getDescription(false) + "  Your Date & Time Formats May Be Wrong");
		errorList.add("Enter Date in yyyy-MM-dd Format");
		errorList.add("Enter Time in HH:mm:ss Format");
		format.setErrorList(errorList);
		return new ResponseEntity<>(format, HttpStatus.BAD_REQUEST);
	}// method

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		NCRExceptionFormat format = new NCRExceptionFormat();
		format.setDate(LocalDateTime.now());
		format.setHttpStatus(status);
		format.setMessage(request.getDescription(false).toString() + " Not Supported Content Type"
				+ " Please Enter JSON / PlainText Data");
		return new ResponseEntity<>(format, HttpStatus.BAD_REQUEST);
	}// method
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex){
		NCRExceptionFormat format = new NCRExceptionFormat();
		format.setDate(LocalDateTime.now());
		format.setHttpStatus(HttpStatus.NOT_ACCEPTABLE);
		format.setMessage(ex.getMessage());
		return new ResponseEntity<>(format, HttpStatus.BAD_REQUEST);
	}//method
	
	
	

}// class
