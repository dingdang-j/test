package org.lop.factory.test;

public class NYVeggiePizza extends Pizza {

	PizzaIngredientFactory ingredientFactory;

	public NYVeggiePizza( PizzaIngredientFactory ingredientFactory ) {
		this.ingredientFactory = ingredientFactory;
		name = "NYVeggiePizza";
	}

	@Override
	void prepare() {
		ing1 = ingredientFactory.createIng1();
		ing2 = ingredientFactory.createIng2();
		ing3 = ingredientFactory.createIng3();
	}

	@Override
	void pack() {
		System.out.println( "cust pack!" );
	}

}