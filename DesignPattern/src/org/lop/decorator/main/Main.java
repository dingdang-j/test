package org.lop.decorator.main;

import org.lop.decorator.Beverage;
import org.lop.decorator.beverage.Espresso;
import org.lop.decorator.beverage.HouseBlend;
import org.lop.decorator.condiment.Mocha;
import org.lop.decorator.condiment.Whip;

public class Main {

	public static void main( String[] args ) {
		Beverage beverage = new HouseBlend();
		System.out.println( beverage.getDescription() + ": $" + beverage.cost() );

		Beverage beverage2 = new Espresso();
		beverage2 = new Mocha( beverage2 );
		beverage2 = new Mocha( beverage2 );
		beverage2 = new Whip( beverage2 );
		System.out.println( beverage2.getDescription() + ": $" + beverage2.cost() );
	}

}