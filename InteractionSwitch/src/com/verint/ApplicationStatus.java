package com.verint;



public class ApplicationStatus {

	private TelephonySwitch telephonySwitch;
	public static final String APP_STATUS = "appStatus";
	public ApplicationStatus(TelephonySwitch telephonySwitch) {
		this.telephonySwitch = telephonySwitch;
	}
	
	public Switch getTelephonySwitch() {
		return telephonySwitch;
	}

	public InteractionManager getInteractionManager() {
		return telephonySwitch.getInteractionManager();
	}

}
