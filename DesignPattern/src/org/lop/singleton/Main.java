package org.lop.singleton;

public class Main {

	public static void main( String[] args ) {
		Singleton singleton = Singleton.getInstance();

		Singleton temp1 = singleton;

		singleton.print();

		Singleton temp2 = singleton;
		singleton.print();

		System.out.println( temp1.equals( temp2 ) );
	}

}