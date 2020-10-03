package com.github.leotsantos.apidemo.domain;

public class EventBody {
	
	private String type;
	private String origin;
	private String destination;
	private int amount;
	
	public EventBody() {
		
	}
	
	public EventBody(String type, String origin, String destination, int amount) {
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}

