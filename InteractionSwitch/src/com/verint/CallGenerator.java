package com.verint;

import com.verint.implementation.CustomerDataManager;
import com.verint.implementation.Interaction;
import com.verint.implementation.TelephoneCall;

public class CallGenerator {
	
	private CustomerDataManager customerManager;


	public CallGenerator(CustomerDataManager customerManager) {
		this.customerManager = customerManager;
		
	}

	public Interaction newInteraction(int currentTime) {
		return new TelephoneCall(customerManager.getNextCustomer(), currentTime);
	}

}
