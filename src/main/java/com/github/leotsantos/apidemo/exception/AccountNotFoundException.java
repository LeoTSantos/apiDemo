package com.github.leotsantos.apidemo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
