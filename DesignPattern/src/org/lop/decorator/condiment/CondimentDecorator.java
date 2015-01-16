package org.lop.decorator.condiment;

import org.lop.decorator.Beverage;

/**
 * 调料(装饰者).
 * 
 * @author 潘瑞峥
 * @date 2013-3-18
 */
public abstract class CondimentDecorator extends Beverage {

	@Override
	public abstract String getDescription();

}