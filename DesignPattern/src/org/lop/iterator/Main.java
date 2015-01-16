package org.lop.iterator;

import org.lop.iterator.improve.Waitress;

public class Main {

	public static void main( String[] args ) {
		DinerMenu dinerMenu = new DinerMenu();
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		Waitress waitress = new Waitress( dinerMenu, pancakeHouseMenu );
		waitress.printMenu();
	}

}