package com.verint;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.verint.implementation.Customer;
import com.verint.implementation.Interaction;

public class InteractionManager {

	private List<Interaction> interactionsDropped = new Vector<Interaction>();
	private List<Interaction> allInteractions = new Vector<Interaction>();
	private int counter=0;
	public void add(Interaction newInteraction) {
		System.out.println(counter++ + " total number of customer have called in");
		System.out.println(allInteractions.size() + " customer are waiting in the queue");
		allInteractions.add(newInteraction);
	}

	public List<Interaction> getAllInteractions() {
		return allInteractions;
	}

	public void dropCustomers(int currentTime) {
    	List<Interaction> allInteractions = this.getAllInteractions();
        Iterator<Interaction> it = allInteractions.iterator();

        while(it.hasNext()) {
            Interaction interaction = it.next();
            Customer nextCustomer = interaction.getAssociatedCustomer();

            if(nextCustomer.getCustomerVolatilityScore() < currentTime - interaction.getCallTime()) {
            	interaction.drop(currentTime);
                getInteractionsDropped().add(interaction);
                it.remove();

            }
        }
        System.out.println(getInteractionsDropped().size() + " angry customers dropped their contacts");
	}

	public List<Interaction> getInteractionsDropped() {
		return interactionsDropped;
	}

	
}
