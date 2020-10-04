package com.github.leotsantos.apidemo.manager;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.github.leotsantos.apidemo.domain.Account;
import com.github.leotsantos.apidemo.exception.AccountNotFoundException;

@Component
public class AccountManager {
	
	private ArrayList<Account> accountList;
	
	public AccountManager() {
		this.accountList = new ArrayList<Account>();
	}
	
	public void reset() {
		accountList.clear();
		System.out.print("All data cleared.");
	}
	
	public Account getAccount(String id) throws AccountNotFoundException {
		for(Account a:accountList) {
			if(a.getId().equals(id))
				return a;
		}
		throw new AccountNotFoundException("Account with id " + id + " not found");
	}
	
	public void makeDeposit(String id, int amount) {
		try {
			getAccount(id).changeBalance(amount);
		} catch (AccountNotFoundException e) {
			createAccount(id).changeBalance(amount);
		}
	}
	
	public void makeWithdraw(String id, int amount) throws AccountNotFoundException {
		getAccount(id).changeBalance(-amount);
	}
	
	public void makeTransfer(String origin, String destination, int amount) throws AccountNotFoundException {
		makeWithdraw(origin, amount);
		makeDeposit(destination, amount);
	}
	
	private Account createAccount(String id) {
		try {
			System.out.print("Account already created");
			return getAccount(id);
		} catch (AccountNotFoundException e) {
			System.out.print("Account Not Found, creating account with id " + id);
			Account acc = new Account(id);
			accountList.add(acc);
			return acc;
		}
	}
}
