package com.github.leotsantos.apidemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccountControllerExceptionHandler {
	@ResponseBody
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(AccountNotFoundException ex) {
		return "0";
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidTransactionException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String employeeNotFoundHandler(InvalidTransactionException ex) {
		return "0";
	}
}
