package org.lop.factory.test;

public class NYCheesePizza extends Pizza {

	PizzaIngredientFactory ingredientFactory;

	public NYCheesePizza( PizzaIngredientFactory ingredientFactory ) {
		this.ingredientFactory = ingredientFactory;
		name = "NYCheesePizza";
	}

	@Override
	void prepare() {
		ing1 = ingredientFactory.createIng1();
		ing2 = ingredientFactory.createIng2();
		ing3 = ingredientFactory.createIng3();
	}

}