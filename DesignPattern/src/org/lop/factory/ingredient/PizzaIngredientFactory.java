package org.lop.factory.ingredient;

/**
 * 原料工厂.
 * 
 * @author 潘瑞峥
 * @date 2013-3-23
 */
public interface PizzaIngredientFactory {

	public String createDough();

	public String createSauce();

	public String createCheese();

	public String[] createVeggies();

	public String createClam();

}