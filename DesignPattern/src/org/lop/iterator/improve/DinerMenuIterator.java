package org.lop.iterator.improve;

import org.lop.iterator.MenuItem;

public class DinerMenuIterator implements MyIterator<MenuItem> {

	MenuItem[] items;

	int position = 0;

	public DinerMenuIterator( MenuItem[] items ) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		if ( position >= items.length || null == items[ position ] ) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem = items[ position ];
		position++;
		return menuItem;
	}

}