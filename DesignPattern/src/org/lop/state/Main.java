package org.lop.state;


public class Main {

	public static void main( String[] args ) {
		GumballMachine gumballMachine = new GumballMachine( 1 );
		System.out.println( gumballMachine );
		System.out.println();

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println( gumballMachine );
		System.out.println();

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println( gumballMachine );
		System.out.println();

		gumballMachine.ejectQuarter();
		System.out.println( gumballMachine );
		System.out.println();

		gumballMachine.insertQuarter();
		gumballMachine.ejectQuarter();
		System.out.println( gumballMachine );
		System.out.println();
	}

}