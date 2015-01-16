package org.lop.observer.subject.impl;

import java.util.ArrayList;
import java.util.List;

import org.lop.observer.observer.Observer;
import org.lop.observer.subject.Subject;

public class WeatherData implements Subject {

	private List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver( Observer o ) {
		observers.add( o );
	}

	@Override
	public void removeObserver( Observer o ) {
		observers.remove( o );
	}

	@Override
	public void notifyObserver() {
		for ( Observer o : observers ) {
			o.update( temperature, humidity, pressure );
		}
	}

	public void measurementsChanged() {
		this.notifyObserver();
	}

	public void setMeasurements( float temperature, float humidity, float pressure ) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		this.measurementsChanged();
	}

}