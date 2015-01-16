package org.lop.factory.test;

public abstract class Pizza {

	String name;

	String ing1;

	String ing2;

	String ing3;

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getIng1() {
		return ing1;
	}

	public void setIng1( String ing1 ) {
		this.ing1 = ing1;
	}

	public String getIng2() {
		return ing2;
	}

	public void setIng2( String ing2 ) {
		this.ing2 = ing2;
	}

	public String getIng3() {
		return ing3;
	}

	public void setIng3( String ing3 ) {
		this.ing3 = ing3;
	}

	abstract void prepare();

	void make() {
		System.out.println( "...make..." );
	}

	void pack() {
		System.out.println( "...pack..." );
	}

	@Override
	public String toString() {
		return "name: " + name + " ing1: " + ing1 + " ing2: " + ing2 + " ing3: " + ing3;
	}

}