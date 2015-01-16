package org.lop.decorator.beverage;

import org.lop.decorator.Beverage;

/**
 * HouseBlend.
 * 
 * @author 潘瑞峥
 * @date 2013-3-18
 */
public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "House Blend Coffee";
	}

	@Override
	public double cost() {
		return .89;
	}

}