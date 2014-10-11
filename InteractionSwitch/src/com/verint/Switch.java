package com.verint;

public interface Switch {

	public void turnOn();

	public boolean isOn();

	public void tick();

	public long getTickTime();

	public void turnOff();

}
