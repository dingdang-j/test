package org.lop.state.impl;

import org.lop.state.GumballMachine;
import org.lop.state.State;

public class SoldOutState implements State {
	
	@SuppressWarnings("unused")
	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("xxx不能投入钱, 已经售完xxx");
		// System.out.println( "You can't insert a quarter, the machine is sold out" );
	}
	
	@Override
	public void ejectQuarter() {
		System.out.println("xxx没钱不能退回xxx");
		// System.out.println( "You can't eject, you haven't inserted a quarter yet" );
	}
	
	@Override
	public void turnCrank() {
		System.out.println("xxx已经转动, 但没钱, 不会发送糖果xxx");
		// System.out.println( "You turned, but there are no gumballs" );
	}
	
	@Override
	public void dispense() {
		System.out.println("xxx没钱, 不能发放糖果xxx");
		// System.out.println( "No gumball dispensed" );
	}
	
	@Override
	public String toString() {
		return "已经售完";
	}
	
}