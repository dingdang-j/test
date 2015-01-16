package org.lop.factory.pizza;

/**
 * 纽约口味Pizza.
 * 
 * @author 潘瑞峥
 * @date 2013-3-19
 */
public class NYStyleCheesePizza extends Pizza {

	public NYStyleCheesePizza() {
		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";

		toppings.add( "Grated Reggiano Cheese" );
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}

}