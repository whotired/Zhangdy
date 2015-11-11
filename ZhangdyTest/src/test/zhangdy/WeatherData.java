//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;

import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;
	public WeatherData() {
	observers = new ArrayList();
	}
	public void registerObserver(Observer o) {
	observers.add(o);
	}
	public void removeObserver(Observer o) {
	int i = observers.indexOf(o);
	if (i >= 0) {
	observers.remove(i);
	}
	}
	public void notifyObservers() {
	for (int i = 0; i < observers.size(); i++) {
	Observer observer = (Observer)observers.get(i);
	observer.update(temperature, humidity, pressure);
	}
	}
	public void measurementsChanged() {
	notifyObservers();
	}
	public void setMeasurements(float temperature, float humidity, float pressure) {
	this.temperature = temperature;
	this.humidity = humidity;
	this.pressure = pressure;
	measurementsChanged();
	}
	// WeatherData的其他方法
	}
