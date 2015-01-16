package org.lop.factory.pizza;

import org.lop.factory.ingredient.PizzaIngredientFactory;

/**
 * 芝加哥口味Pizza.
 * 
 * @author 潘瑞峥
 * @date 2013-3-19
 */
public class ChicagoStyleCheesePizza extends Pizza {

	private PizzaIngredientFactory ingredientFactory;

	public ChicagoStyleCheesePizza( PizzaIngredientFactory ingredientFactory ) {
		this.ingredientFactory = ingredientFactory;
	}

	public ChicagoStyleCheesePizza() {
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add( "Shredded Mozzarella Cheese" );
	}

	@Override
	public void prepare() {
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
	}

	@Override
	public void cut() {
		System.out.println( "Cutting the pizza into square slices" );
	}

}