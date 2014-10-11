package com.verint.implementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;


public class CustomerDataManager {
    private ArrayList<Customer> customerData;
    private int customerPointer=1;
    public void loadCustomerData(File customerList) {
        Customer[] customerArray = new Customer[0];
        System.out.println("Loading customer data from file " + customerList.getAbsolutePath());
        ObjectMapper mapper = new ObjectMapper();
        try {
			customerArray = mapper.readValue(customerList, Customer[].class);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed to load customers");
		}
        
        customerData = new ArrayList<Customer>(Arrays.asList(customerArray));
    }

    public Customer getNextCustomer() {
    	Customer nextCustomer = null;
    	if(customerPointer == customerData.size()){
    		customerPointer = 0;
    	}
        nextCustomer = customerData.get(customerPointer);
        customerPointer++;
        return nextCustomer;
    }
}
