package com.github.leotsantos.apidemo.domain;

public class EventResponse {
	
	private Account origin;
	private Account destination;
	
	public EventResponse() {
	}

	public EventResponse(Account origin, Account destination) {
		this.origin = origin;
		this.destination = destination;
	}
	
	public Account getOrigin() {
		return origin;
	}
	public void setOrigin(Account origin) {
		this.origin = origin;
	}
	public Account getDestination() {
		return destination;
	}
	public void setDestination(Account destination) {
		this.destination = destination;
	}
}
