package org.lop.factory.test;

public class NYPizzaStore extends PizzaStore {

	Pizza pizza = null;
	PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

	@Override
	Pizza createPizza( String mark ) {
		if ( "cheese".equals( mark ) ) {
			pizza = new NYCheesePizza( ingredientFactory );
		} else if ( "veggie".equals( mark ) ) {
			pizza = new NYVeggiePizza( ingredientFactory );
		}
		return pizza;
	}

}