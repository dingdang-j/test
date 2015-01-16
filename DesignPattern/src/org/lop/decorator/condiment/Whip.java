package org.lop.decorator.condiment;

import org.lop.decorator.Beverage;

/**
 * Whip.
 * 
 * @author 潘瑞峥
 * @date 2013-3-18
 */
public class Whip extends CondimentDecorator {

	Beverage beverage;

	public Whip( Beverage beverage ) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.19;
	}

}