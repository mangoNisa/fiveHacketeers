package com.verint.implementation;


public class TelephoneCall implements Interaction {

	private Customer customer;
	private final int callInTime;
	private boolean isDropped = false;
	private int droppedTime =-1;
	private int id;

	public TelephoneCall(Customer customer,int callInTime) {
		this.id = callInTime;
		this.customer = customer;
		this.callInTime = callInTime;
	}
	
	@Override
	public Customer getAssociatedCustomer() {
		return this.customer;
	}

	@Override
	public int getCallTime() {
		return callInTime;
	}

	@Override
	public void drop(int currentTime) {
		droppedTime = currentTime;
		isDropped = true;
	}

	public int getId() {
		return id;
	}

}
