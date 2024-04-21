package com.shimigui.workshop.services.exceptions;

import com.shimigui.workshop.resources.exception.StandardException;

public interface IServiceException {
	static final StandardException EXCEPTION = new StandardException();
	
	StandardException getException();
}
