package com.github.leotsantos.apidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.leotsantos.apidemo.domain.Account;
import com.github.leotsantos.apidemo.domain.EventBody;
import com.github.leotsantos.apidemo.domain.EventResponse;
import com.github.leotsantos.apidemo.exception.AccountNotFoundException;
import com.github.leotsantos.apidemo.exception.InvalidTransactionException;
import com.github.leotsantos.apidemo.manager.AccountManager;
import com.google.gson.Gson;

@RestController
public class AccountController {
	
	@Autowired
	private AccountManager manager;
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void resetStatus() {
        manager.reset();
    }
	
	@RequestMapping(value = "/balance", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public int getBalance(@RequestParam(name = "account_id") String accountId) throws AccountNotFoundException {
        int balance = manager.getAccount(accountId).getBalance();		
		System.out.print("Account " + accountId + " has balance of " + balance + "reais");
        return balance;
    }
	
	@RequestMapping(value = "/event", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String postTransaction(@RequestBody EventBody body) throws AccountNotFoundException, InvalidTransactionException {
		EventResponse response = new EventResponse();
		
		if(body.getType().equals("withdraw")) {
			manager.makeWithdraw(body.getOrigin(), body.getAmount());
        }
		else if(body.getType().equals("deposit")) {
			manager.makeDeposit(body.getDestination(), body.getAmount());
		}
		else if (body.getType().equals("transfer")) {
			manager.makeTransfer(body.getOrigin(), body.getDestination(), body.getAmount());
		}
		else {
			throw new InvalidTransactionException("Transaction " + body.getType() + " is invalid.");
		}
		
		if(body.getOrigin()!=null)
			response.setOrigin(manager.getAccount(body.getOrigin()));
		if(body.getDestination()!=null)
			response.setDestination(manager.getAccount(body.getDestination()));
		
		Gson gson = new Gson();
		String json = gson.toJson(response);
		
		return json;
    }

}
