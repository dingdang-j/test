package org.lop.iterator.improve;

import java.util.List;

import org.lop.iterator.MenuItem;

public class PancakeHouseMenuIterator implements MyIterator<MenuItem> {

	List<MenuItem> iterms;

	int position = 0;

	public PancakeHouseMenuIterator( List<MenuItem> iterms ) {
		this.iterms = iterms;
	}

	@Override
	public boolean hasNext() {
		if ( iterms.size() > position ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public MenuItem next() {
		MenuItem item = iterms.get( position );
		position++;
		return item;
	}

}