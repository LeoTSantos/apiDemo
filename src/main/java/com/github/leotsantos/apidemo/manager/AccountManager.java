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
	
}
