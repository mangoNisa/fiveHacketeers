package com.verint;

public class WorkGenerator implements Runnable {

	private ApplicationStatus appStatus;

    public WorkGenerator(ApplicationStatus appStatus) {
        this.appStatus = appStatus;
    }
    public void run() {
    	Switch telephonySwitch = appStatus.getTelephonySwitch();
    	telephonySwitch.turnOn();
    	while (telephonySwitch.isOn()) {
        	   	telephonySwitch.tick();
            try {
                Thread.sleep(telephonySwitch.getTickTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void terminate() {
       appStatus.getTelephonySwitch().turnOff();
    }
}