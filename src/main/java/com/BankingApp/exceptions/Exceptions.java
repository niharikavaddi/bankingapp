package com.BankingApp.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Exceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Unauthorized.class)
	public ResponseEntity<Object> handleUnauthorized(Unauthorized ex, WebRequest request) {
		return new ResponseEntity<>("Access Denied or Not Yet Approved", HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
		return new ResponseEntity<>("No Data found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(
			SQLIntegrityConstraintViolationException ex, WebRequest request) {
		return new ResponseEntity<>("Username already exists, try a different name", HttpStatus.NOT_ACCEPTABLE);
	}

}
