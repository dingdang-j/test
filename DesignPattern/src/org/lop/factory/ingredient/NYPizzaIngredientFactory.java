package org.lop.factory.ingredient;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public String createDough() {
		return "NY - Dough";
	}

	@Override
	public String createSauce() {
		return "NY - Sauce";
	}

	@Override
	public String createCheese() {
		return "NY - Cheese";
	}

	@Override
	public String[] createVeggies() {
		return new String[] { "NY - Veggies1", "NY - Veggies2", "NY - Veggies3" };
	}

	@Override
	public String createClam() {
		return "NY - Clam";
	}

}