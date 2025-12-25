package com.felipeoliveira.mongodbproject.services.exception;

//RunTimeException é uma classe que não precisa de tratamento, ao contrário da Exception que precisa de um tratamento para a exceção

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
