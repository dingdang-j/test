package org.lop.factory.test;

public abstract class PizzaStore {

	Pizza order( String mark ) {
		Pizza pizza = this.createPizza( mark );
		pizza.prepare();
		pizza.make();
		pizza.pack();

		return pizza;
	}

	abstract Pizza createPizza( String mark );

}