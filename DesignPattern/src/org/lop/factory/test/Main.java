package org.lop.factory.test;

public class Main {

	public static void main( String[] args ) {
		PizzaStore pizzaStore = new NYPizzaStore();

		Pizza pizza = pizzaStore.order( "cheese" );
		System.out.println( pizza + "\n" );

		pizza = pizzaStore.order( "veggie" );
		System.out.println( pizza );
	}

}