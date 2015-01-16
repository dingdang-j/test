package org.lop.state;

/**
 * 抽象State.
 * 
 * @author 潘瑞峥
 * @date 2013-4-6
 */
public interface State {

	/**
	 * 投入钱.
	 */
	public void insertQuarter();

	/**
	 * 退出钱.
	 */
	public void ejectQuarter();

	/**
	 * 转动把柄.
	 */
	public void turnCrank();

	/**
	 * 发放糖果.
	 */
	public void dispense();

}