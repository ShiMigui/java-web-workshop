package com.shimigui.workshop.services.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.shimigui.workshop.resources.exception.StandardException;

public class NotFoundException extends RuntimeException implements Serializable, IServiceException {
	private static final long serialVersionUID = 1L;

	private String id;

	public NotFoundException(String id) {
		setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public StandardException getException() {
		if(EXCEPTION.getError() == null) {
			EXCEPTION.now();
			EXCEPTION.setError("Resource not found!");
			EXCEPTION.setStatus(HttpStatus.NOT_FOUND);
			EXCEPTION.setMessage("Resource id = "+ getId());
		}
		return EXCEPTION;
	}
}
