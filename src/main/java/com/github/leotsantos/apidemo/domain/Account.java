package com.github.leotsantos.apidemo.domain;

public class Account {
	private int id;
	private int balance;
	
	public Account(int id) {
		this.id = id;
		this.balance = 0;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void changeBalance(int movimentation) {
		this.balance += movimentation;
	}
}
