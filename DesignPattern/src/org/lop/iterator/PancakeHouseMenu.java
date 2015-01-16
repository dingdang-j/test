package org.lop.iterator;

import java.util.ArrayList;
import java.util.List;

import org.lop.iterator.improve.MyIterator;
import org.lop.iterator.improve.PancakeHouseMenuIterator;

public class PancakeHouseMenu {

	List<MenuItem> menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();

		this.addItem( "A1", "A1", true, 2.99 );
		this.addItem( "A2", "A2", true, .99 );
		this.addItem( "A3", "A3", false, .01 );
		this.addItem( "A4", "A4", false, 3.00 );
		this.addItem( "A5", "A5", true, 1.50 );
	}

	public void addItem( String name, String description, boolean vegetarion, double price ) {
		MenuItem menuItem = new MenuItem( name, description, vegetarion, price );
		menuItems.add( menuItem );
	}

	// public List<MenuItem> getMenuItems() {
	// return menuItems;
	// }

	public MyIterator<MenuItem> createIterator() {
		return new PancakeHouseMenuIterator( menuItems );
	}

}