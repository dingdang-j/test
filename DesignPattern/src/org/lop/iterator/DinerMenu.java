package org.lop.iterator;

import org.lop.iterator.improve.DinerMenuIterator;
import org.lop.iterator.improve.MyIterator;

public class DinerMenu {

	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];

		this.addItem( "B1", "B1", false, 5.00 );
		this.addItem( "B2", "B2", true, 1.10 );
		this.addItem( "B3", "B3", true, 3.00 );
		this.addItem( "B4", "B4", false, 1.00 );
		this.addItem( "B5", "B5", false, 4.50 );
	}

	public void addItem( String name, String description, boolean vegetarion, double price ) {
		MenuItem menuItem = new MenuItem( name, description, vegetarion, price );
		if ( numberOfItems >= MAX_ITEMS ) {
			System.err.println( "err" );
		} else {
			menuItems[ numberOfItems ] = menuItem;
			numberOfItems++;
		}
	}

	// public MenuItem[] getMenuItems() {
	// return menuItems;
	// }

	public MyIterator<MenuItem> createIterator() {
		return new DinerMenuIterator( menuItems );
	}

}