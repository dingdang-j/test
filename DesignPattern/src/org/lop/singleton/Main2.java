package org.lop.singleton;

public class Main2 {

	public static void main( String[] args ) {
		Singleton singleton = Singleton.getInstance();

		singleton.print();
	}

}