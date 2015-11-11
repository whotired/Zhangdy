//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;
	public CurrentConditionsDisplay(Subject weatherData) {
	this.weatherData = weatherData;
	weatherData.registerObserver(this);
	}
	public void update(float temperature, float humidity, float pressure) {
	this.temperature = temperature;
	this.humidity = humidity;
	display();
	}
	public void display() {
	System.out.println("Current conditions: " + temperature
	+ "F degrees and " + humidity + "% humidity");
	}
}
