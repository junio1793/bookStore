package com.springBoot.bookstore.resource.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springBoot.bookstore.service.exceptions.ObjectNotFoundErros;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler(ObjectNotFoundErros.class)
	public ResponseEntity<StandardError> handleObjectNotFoundExceptionNotFound(ObjectNotFoundErros e , ServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	/*
	@ExceptionHandler(ObjectNotFoundErros.class)
	public ResponseEntity<StandardError> handleObjectNotFoundExceptionBadRequest(ObjectNotFoundErros e , ServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	*/
}
