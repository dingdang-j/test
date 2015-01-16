package org.lop.state.impl;

import org.lop.state.GumballMachine;
import org.lop.state.State;

/**
 * 销售State.
 * 
 * @author 潘瑞峥
 * @date 2013-4-6
 */
public class SoldState implements State {

	private GumballMachine gumballMachine;

	public SoldState( GumballMachine gumballMachine ) {
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
		this.gumballMachine.releaseBall();
		if ( 0 < this.gumballMachine.getCount() ) {
			this.gumballMachine.setState( this.gumballMachine.getNoQuarterState() );
		} else {
			System.out.println( "...已经售完..." );
			// System.out.println( "Oops, out of gumballs!" );
			this.gumballMachine.setState( this.gumballMachine.getSoldOutState() );
		}
	}

	@Override
	public String toString() {
		return "正在发放糖果";
	}

}