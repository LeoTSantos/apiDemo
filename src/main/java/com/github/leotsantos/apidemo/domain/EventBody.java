package com.github.leotsantos.apidemo.domain;

public class EventBody {
	
	private String type;
	private Integer origin;
	private Integer destination;
	private int amount;
	
	public EventBody(String type, Integer origin, Integer destination, int amount) {
		this.type = type;
		this.origin = origin;
		this.setDestination(destination);
		this.amount = amount;
	}	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getOrigin() {
		return origin;
	}
	public void setOrigin(Integer origin) {
		this.origin = origin;
	}
	public Integer getDestination() {
		return destination;
	}
	public void setDestination(Integer destination) {
		this.destination = destination;
	}	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}

