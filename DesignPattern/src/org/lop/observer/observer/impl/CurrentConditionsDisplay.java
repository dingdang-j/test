package org.lop.observer.observer.impl;

import org.lop.observer.observer.DisplayElement;
import org.lop.observer.observer.Observer;
import org.lop.observer.subject.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private Subject weatherData;
	private float temperature;
	private float humidity;
	private float pressure;

	public CurrentConditionsDisplay( Subject weatherData ) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver( this );
	}

	@Override
	public void display() {
		System.out.println( "temperature: " + temperature + " humidity: " + humidity + " pressure: " + pressure );
	}

	@Override
	public void update( float temperature, float humidity, float pressure ) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		this.display();
	}

}