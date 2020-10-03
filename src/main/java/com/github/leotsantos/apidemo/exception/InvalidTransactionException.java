package com.github.leotsantos.apidemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidTransactionException extends Exception {
	public InvalidTransactionException(String errorMessage) {
		super(errorMessage);
	}
}
