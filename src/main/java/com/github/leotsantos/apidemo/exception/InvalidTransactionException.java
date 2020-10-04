package com.github.leotsantos.apidemo.exception;

public class InvalidTransactionException extends RuntimeException {
	public InvalidTransactionException(String errorMessage) {
		super(errorMessage);
	}
}
