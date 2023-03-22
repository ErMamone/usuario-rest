package com.eros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExistingEmailException extends Exception {

	public ExistingEmailException(String message) {
		super(message);
	}
}
