package com.springBoot.bookstore.service.exceptions;

public class ObjectNotFoundErros extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundErros(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundErros(String message) {
		super(message);
	}

}
