package org.lop.core;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 每次动作模版.
 * 
 * @author 潘瑞峥
 * @date 2013-5-6
 */
public class CallBasicMotion {

	private Robot robot;

	/**
	 * 组合基本行为.
	 * 
	 * @param robot
	 * @param x
	 * @param y
	 * @param ms
	 * @param input
	 */
	public void execute( Robot robot, int x, int y, Integer ms, String... input ) {
		this.robot = robot;

		// 移动到.
		move( x, y );
		// 点击.
		click();
		// 输入.
		if ( ArrayUtils.isNotEmpty( input ) ) {
			input( input[ 0 ] );
		}
		// 睡眠.
		if ( null != ms && 0 < ms ) {
			delay( ms );
		}
	}

	/**
	 * 移动到.
	 * 
	 * @param x
	 * @param y
	 */
	final void move( int x, int y ) {
		robot.mouseMove( x, y );
	}

	/**
	 * 点击.
	 */
	final void click() {
		robot.mousePress( InputEvent.BUTTON1_MASK );
		robot.mouseRelease( InputEvent.BUTTON1_MASK );
		Toolkit.getDefaultToolkit().beep();
	}

	/**
	 * 输入.
	 * 
	 * @param input
	 */
	final void input( String input ) {
		if ( StringUtils.isNotBlank( input ) ) {
			char[] inputs = input.toCharArray();
			for ( char c : inputs ) {
				input( c );
			}
		}
	}

	/**
	 * 睡眠.
	 * 
	 * @param ms
	 */
	final void delay( int ms ) {
		robot.delay( ms );
	}

	/**
	 * 输入号码.
	 * 
	 * @param c
	 */
	private void input( char c ) {
		switch ( c ) {
			case '0':
				robot.keyPress( KeyEvent.VK_NUMPAD0 );
				robot.keyRelease( KeyEvent.VK_NUMPAD0 );
				break;
			case '1':
				robot.keyPress( KeyEvent.VK_NUMPAD1 );
				robot.keyRelease( KeyEvent.VK_NUMPAD1 );
				break;
			case '2':
				robot.keyPress( KeyEvent.VK_NUMPAD2 );
				robot.keyRelease( KeyEvent.VK_NUMPAD2 );
				break;
			case '3':
				robot.keyPress( KeyEvent.VK_NUMPAD3 );
				robot.keyRelease( KeyEvent.VK_NUMPAD3 );
				break;
			case '4':
				robot.keyPress( KeyEvent.VK_NUMPAD4 );
				robot.keyRelease( KeyEvent.VK_NUMPAD4 );
				break;
			case '5':
				robot.keyPress( KeyEvent.VK_NUMPAD5 );
				robot.keyRelease( KeyEvent.VK_NUMPAD5 );
				break;
			case '6':
				robot.keyPress( KeyEvent.VK_NUMPAD6 );
				robot.keyRelease( KeyEvent.VK_NUMPAD6 );
				break;
			case '7':
				robot.keyPress( KeyEvent.VK_NUMPAD7 );
				robot.keyRelease( KeyEvent.VK_NUMPAD7 );
				break;
			case '8':
				robot.keyPress( KeyEvent.VK_NUMPAD8 );
				robot.keyRelease( KeyEvent.VK_NUMPAD8 );
				break;
			case '9':
				robot.keyPress( KeyEvent.VK_NUMPAD9 );
				robot.keyRelease( KeyEvent.VK_NUMPAD9 );
				break;
		}
	}

}