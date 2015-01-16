package org.lop.state.impl;

import org.lop.state.GumballMachine;
import org.lop.state.State;

/**
 * 没Quarter State.
 * 
 * @author 潘瑞峥
 * @date 2013-4-6
 */
public class NoQuarterState implements State {

	private GumballMachine gumballMachine;

	public NoQuarterState( GumballMachine gumballMachine ) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println( "...已经投入钱..." );
		// System.out.println( "You inserted a quarter" );
		this.gumballMachine.setState( this.gumballMachine.getHasQuarterState() );
	}

	@Override
	public void ejectQuarter() {
		System.out.println( "xxx没钱不能退回xxx" );
		// System.out.println( "You haven't inserted a quarter" );
	}

	@Override
	public void turnCrank() {
		System.out.println( "xxx已经转动, 但没钱, 不会发送糖果xxx" );
		// System.out.println( "You turned, but there's no quarter" );
	}

	@Override
	public void dispense() {
		System.out.println( "xxx没钱, 不能发放糖果xxx" );
		// System.out.println( "You need to pay first" );
	}

	@Override
	public String toString() {
		return "等待投入钱";
	}

}