package com.shimigui.workshop.resources.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shimigui.workshop.services.exceptions.IServiceException;
import com.shimigui.workshop.services.exceptions.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardException> notFound(IServiceException e, HttpServletRequest req) {
		return getException(serviceException(e, req));
	}

	public StandardException serviceException(IServiceException e, HttpServletRequest req) {
		StandardException err = e.getException();
		err.setPath(req.getRequestURI());
		return err;
	}

	public ResponseEntity<StandardException> getException(StandardException e) {
		return ResponseEntity.status(e.getStatus()).body(e);
	}
}
