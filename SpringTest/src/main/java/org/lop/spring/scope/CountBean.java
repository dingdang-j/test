package org.lop.spring.scope;

public class CountBean {

	private int count;

	public void add() {
		count++;
	}

	@Override
	public String toString() {
		return String.format( "count: %d", count );
	}

	public void init() {
		System.out.println( "init..." );
	}

	public void destory() {
		System.out.println( "destory..." );
	}

}