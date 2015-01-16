package org.lop.state.impl;

import java.util.Random;

import org.lop.state.GumballMachine;
import org.lop.state.State;

/**
 * 有Quarter State.
 * 
 * @author 潘瑞峥
 * @date 2013-4-6
 */
public class HasQuarterState implements State {

	private GumballMachine gumballMachine;

	private Random randomWinner = new Random( System.currentTimeMillis() );

	public HasQuarterState( GumballMachine gumballMachine ) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println( "xxx已经投入了钱xxx" );
		// System.out.println( "You can't insert another quarter" );
	}

	@Override
	public void ejectQuarter() {
		System.out.println( "...正在退回钱..." );
		// System.out.println( "Quarter returned" );
		this.gumballMachine.setState( this.gumballMachine.getNoQuarterState() );
	}

	@Override
	public void turnCrank() {
		System.out.println( "...正在发放糖果..." );
		// System.out.println( "You turned..." );

		int winner = this.randomWinner.nextInt( 10 );
		System.out.println( "---1: " + winner + "---" );
		if ( ( 0 == winner ) && ( 1 < this.gumballMachine.getCount() ) ) {
			this.gumballMachine.setState( this.gumballMachine.getWinnerState() );
		} else {
			this.gumballMachine.setState( this.gumballMachine.getSoldState() );
		}
		winner = this.randomWinner.nextInt( 10 );
		System.out.println( "---2: " + winner + "---" );
	}

	@Override
	public void dispense() {
		System.out.println( "xxx不能发放xxx" );
		// System.out.println( "No gumball dispensed" );
	}

	@Override
	public String toString() {
		return "已经投入钱";
	}

}