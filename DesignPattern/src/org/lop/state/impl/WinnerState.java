package org.lop.state.impl;

import org.lop.state.GumballMachine;
import org.lop.state.State;

public class WinnerState implements State {

	private GumballMachine gumballMachine;

	public WinnerState( GumballMachine gumballMachine ) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println( "xxx已经投入了钱xxx" );
		// System.out.println( "Please wait, we're already giving you a gumball" );
	}

	@Override
	public void ejectQuarter() {
		System.out.println( "xxx正在发放糖果, 不能退钱xxx" );
		// System.out.println( "Sorry, you already turned the crank" );
	}

	@Override
	public void turnCrank() {
		System.out.println( "xxx正在发放糖果, 不能再转动xxx" );
		// System.out.println( "Turning twice doesn't get you another gumball!" );
	}

	@Override
	public void dispense() {
		System.out.println( "...您运气真好! 多送您一颗..." );
		// System.out.println( "YOU'RE A WINNER! You get two gumballs for your quarter" );

		this.gumballMachine.releaseBall();
		if ( 0 == this.gumballMachine.getCount() ) {
			this.gumballMachine.setState( this.gumballMachine.getSoldOutState() );
		} else {
			this.gumballMachine.releaseBall();
			if ( 0 < this.gumballMachine.getCount() ) {
				this.gumballMachine.setState( this.gumballMachine.getNoQuarterState() );
			} else {
				System.out.println( "...已经售完..." );
				// System.out.println( "Oops, out of gumballs!" );
				this.gumballMachine.setState( this.gumballMachine.getSoldOutState() );
			}
		}
	}

	@Override
	public String toString() {
		return "您运气真好!";
	}

}