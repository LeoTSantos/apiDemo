package com.github.leotsantos.apidemo.domain;

public class Account {
	private String id;
	private int balance;
	
	public Account(String id) {
		this.id = id;
		this.balance = 0;
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void changeBalance(int movimentation) {
		this.balance += movimentation;
	}
}
