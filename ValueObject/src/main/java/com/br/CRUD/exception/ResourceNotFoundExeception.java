package com.br.CRUD.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExeception(String exception) {
		super(exception);
	}
}
