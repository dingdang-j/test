package org.lop.factory.store;

import org.lop.factory.pizza.Pizza;

/**
 * Pizza商店.
 * 
 * @author 潘瑞峥
 * @date 2013-3-19
 */
public abstract class PizzaStore {

	public Pizza orderPizza( String type ) {
		Pizza pizza = this.createPizza( type );

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

	abstract Pizza createPizza( String type );

}