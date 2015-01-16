package org.lop.factory.test;

import org.lop.factory.test.PizzaIngredientFactory;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public String createIng1() {
		return "ing1";
	}

	@Override
	public String createIng2() {
		return "ing2";
	}

	@Override
	public String createIng3() {
		return "ing3";
	}

}