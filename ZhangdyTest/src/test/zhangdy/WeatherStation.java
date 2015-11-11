//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;

public class WeatherStation {
	public static void main(String[] args) {
	WeatherData weatherData = new WeatherData();
	CurrentConditionsDisplay currentDisplay =
	new CurrentConditionsDisplay(weatherData);
//	StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
//	ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
	weatherData.setMeasurements(80, 65, 30.4f);
	weatherData.setMeasurements(82, 70, 29.2f);
	weatherData.setMeasurements(78, 90, 29.2f);
	/*result:
	 *  Current conditions: 80.0F degrees and 65.0% humidity
		Current conditions: 82.0F degrees and 70.0% humidity
		Current conditions: 78.0F degrees and 90.0% humidity
	 */
	}
}