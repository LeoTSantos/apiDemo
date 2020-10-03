package com.github.leotsantos.apidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.leotsantos.apidemo.exception.AccountNotFoundException;
import com.github.leotsantos.apidemo.manager.AccountManager;

@RestController
public class AccountController {
	
	@Autowired
	private AccountManager manager;
	
	@RequestMapping(value = "/balance", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public int getBalance(@RequestParam(name = "account_id") int accountId) throws AccountNotFoundException {
        int balance = manager.getAccount(accountId).getBalance();		
		System.out.print("Account " + accountId + " has balance of " + balance + "reais");
        return balance;
    }

}
