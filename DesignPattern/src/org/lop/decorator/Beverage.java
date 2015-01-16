package org.lop.decorator;

/**
 * 原始的饮料抽象类.
 * 
 * @author 潘瑞峥
 * @date 2013-3-18
 */
public abstract class Beverage {

	protected String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();

}