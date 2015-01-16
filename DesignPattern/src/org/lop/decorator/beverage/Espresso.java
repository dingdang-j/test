package org.lop.decorator.beverage;

import org.lop.decorator.Beverage;

/**
 * 浓咖啡.
 * 
 * @author 潘瑞峥
 * @date 2013-3-18
 */
public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}

}