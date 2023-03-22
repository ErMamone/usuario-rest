package com.eros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidEmailException extends Exception {

	public InvalidEmailException(String message) {
		super(message);
	}
}
