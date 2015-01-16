package org.lop.iterator.improve;

import org.lop.iterator.DinerMenu;
import org.lop.iterator.MenuItem;
import org.lop.iterator.PancakeHouseMenu;

public class Waitress {

	DinerMenu dinerMenu;

	PancakeHouseMenu pancakeHouseMenu;

	public Waitress( DinerMenu dinerMenu, PancakeHouseMenu pancakeHouseMenu ) {
		this.dinerMenu = dinerMenu;
		this.pancakeHouseMenu = pancakeHouseMenu;
	}

	public void printMenu() {
		MyIterator<MenuItem> dinerIterator = this.dinerMenu.createIterator();
		MyIterator<MenuItem> pancakeHouseIterator = this.pancakeHouseMenu.createIterator();
		System.out.println( "======= DinerIterator: " );
		this.printMenu( dinerIterator );
		System.out.println( "======= PancakeHouseIterator: " );
		this.printMenu( pancakeHouseIterator );
	}

	private void printMenu( MyIterator<MenuItem> iterator ) {
		MenuItem menuTem;
		while ( iterator.hasNext() ) {
			menuTem = iterator.next();
			System.out.print( "Name: " + menuTem.getName() );
			System.out.print( ", Price: " + menuTem.getPrice() );
			System.out.println( ", Descrition: " + menuTem.getDescription() );
		}
	}

}