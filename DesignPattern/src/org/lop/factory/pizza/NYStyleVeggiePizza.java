package org.lop.factory.pizza;

/**
 * 纽约口味Pizza.
 * 
 * @author 潘瑞峥
 * @date 2013-3-19
 */
public class NYStyleVeggiePizza extends Pizza {

	public NYStyleVeggiePizza() {
		name = "NY Style Sauce and Veggie Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";

		toppings.add( "Grated Reggiano Veggie" );
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub

	}

}