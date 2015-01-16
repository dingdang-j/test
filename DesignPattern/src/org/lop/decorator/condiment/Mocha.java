package org.lop.decorator.condiment;

import org.lop.decorator.Beverage;

/**
 * Mocha.
 * 
 * @author 潘瑞峥
 * @date 2013-3-18
 */
public class Mocha extends CondimentDecorator {

	Beverage beverage;

	public Mocha( Beverage beverage ) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return beverage.cost() + .20;
	}

}