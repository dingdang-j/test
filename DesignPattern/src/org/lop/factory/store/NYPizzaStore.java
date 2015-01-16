package org.lop.factory.store;

import org.lop.factory.pizza.NYStyleCheesePizza;
import org.lop.factory.pizza.NYStyleVeggiePizza;
import org.lop.factory.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza( String type ) {
		if ( "cheese".equals( type ) ) {
			return new NYStyleCheesePizza();
		} else if ( "veggie".equals( type ) ) {
			return new NYStyleVeggiePizza();
		} else {
			return null;
		}
	}

}