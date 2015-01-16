package org.lop.factory.store;

import org.lop.factory.ingredient.NYPizzaIngredientFactory;
import org.lop.factory.ingredient.PizzaIngredientFactory;
import org.lop.factory.pizza.ChicagoStyleCheesePizza;
import org.lop.factory.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

	Pizza pizza = null;
	PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

	@Override
	Pizza createPizza( String type ) {
		if ( "cheese".equals( type ) ) {
			pizza = new ChicagoStyleCheesePizza( ingredientFactory );
			pizza.setName( "dingdang_j." );
		} else {
		}
		return pizza;
	}

}