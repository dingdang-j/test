package org.lop.factory.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * Pizza抽象.
 * 
 * @author 潘瑞峥
 * @date 2013-3-19
 */
public abstract class Pizza {

	String name;

	String dough;

	String sauce;

	List<String> toppings = new ArrayList<String>();

	public abstract void prepare();

	// public void prepare() {
	// System.out.println( "Preparing " + name );
	// System.out.println( "Tossing dough..." );
	// System.out.println( "Adding sauce..." );
	// System.out.print( "Adding toppings: " );
	// for ( String topping : toppings ) {
	// System.out.print( " " + topping );
	// }
	// System.out.println();
	// }

	public void bake() {
		System.out.println( "Bake for 25 minutes at 350" );
	}

	public void cut() {
		System.out.println( "Cutting the pizza into diagonal slices" );
	}

	public void box() {
		System.out.println( "Place pizza in official PizzaStore box" );
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name: " + name + " dough: " + dough + " sauce:" + sauce;
	}

}