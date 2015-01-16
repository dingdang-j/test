package org.lop.state;

import org.lop.state.impl.HasQuarterState;
import org.lop.state.impl.NoQuarterState;
import org.lop.state.impl.SoldOutState;
import org.lop.state.impl.SoldState;
import org.lop.state.impl.WinnerState;

/**
 * 糖果机.
 * 
 * @author 潘瑞峥
 * @date 2013-4-6
 */
public class GumballMachine {

	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;

	State state;

	int count = 0;

	public GumballMachine( int numberGumballs ) {
		soldOutState = new SoldOutState( this );
		noQuarterState = new NoQuarterState( this );
		hasQuarterState = new HasQuarterState( this );
		soldState = new SoldState( this );
		winnerState = new WinnerState( this );

		this.count = numberGumballs;
		if ( 0 < numberGumballs ) {
			state = noQuarterState;
		} else {
			state = soldOutState;
		}
	}

	public void insertQuarter() {
		this.state.insertQuarter();
	}

	public void ejectQuarter() {
		this.state.ejectQuarter();
	}

	public void turnCrank() {
		this.state.turnCrank();
		this.state.dispense();
	}

	public void setState( State state ) {
		this.state = state;
	}

	public void releaseBall() {
		System.out.println( "发放了一颗糖果..." );
		// System.out.println( "A gumball comes rolling out the slot..." );
		if ( 0 != count ) {
			count = count - 1;
		}
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		// String content = "Count: " + this.getCount();
		String content = "剩余: " + this.getCount() + "颗, 状态: " + this.state + ".";
		return content;
	}

}