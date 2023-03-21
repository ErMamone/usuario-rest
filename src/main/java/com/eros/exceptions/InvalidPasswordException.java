package com.eros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidPasswordException extends Exception{

	public InvalidPasswordException(String message){
		super(message);
	}
}
