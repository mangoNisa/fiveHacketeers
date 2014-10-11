package com.verint.implementation;


public interface Interaction {

	public Customer getAssociatedCustomer();
	public int getCallTime();
	public void drop(int currentTime);
	public int getId();
	
}
