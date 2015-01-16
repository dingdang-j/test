package org.lop.observer.main;

import org.lop.observer.observer.impl.CurrentConditionsDisplay;
import org.lop.observer.subject.impl.WeatherData;

public class WeatherStation {

	public static void main( String[] args ) {
		WeatherData weatherData = new WeatherData();

		new CurrentConditionsDisplay( weatherData );

		weatherData.setMeasurements( 10f, 30f, 90f );
		weatherData.setMeasurements( 73f, 52f, 16f );
		weatherData.setMeasurements( 78f, 37f, 43f );
	}

}