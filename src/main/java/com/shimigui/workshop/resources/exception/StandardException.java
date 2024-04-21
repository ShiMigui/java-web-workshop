package com.shimigui.workshop.resources.exception;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.http.HttpStatus;

public class StandardException implements Serializable {
	private static final long serialVersionUID = 1L;

	private Instant timestamp;
	private HttpStatus status;
	private String message;
	private String error;
	private String path;

	public StandardException() {
	}

	public StandardException(Instant timestamp, HttpStatus status, String message, String error, String path) {
		setTimestamp(timestamp);
		setMessage(message);
		setStatus(status);
		setError(error);
		setPath(path);
	}

	public StandardException now() {
		setTimestamp(Instant.now());
		return this;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	public Integer getCode() {
		return status.value();
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
