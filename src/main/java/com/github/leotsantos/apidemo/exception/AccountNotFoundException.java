package com.github.leotsantos.apidemo.exception;

public class AccountNotFoundException extends RuntimeException {
	public AccountNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
