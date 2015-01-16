package org.lop.factory.main;

import org.lop.factory.pizza.Pizza;
import org.lop.factory.store.ChicagoPizzaStore;
import org.lop.factory.store.PizzaStore;

public class Main {
	
	public static void main(String[] args) {
		//		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		
		//		Pizza pizza = nyStore.orderPizza( "veggie" );
		//		System.out.println( pizza.getName() );
		//		System.out.println();
		
		Pizza pizza = chicagoStore.orderPizza("cheese");
		System.out.println(pizza);
	}
	
}