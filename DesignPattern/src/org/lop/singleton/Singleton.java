package org.lop.singleton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Singleton {

	private volatile static Singleton uniqueInstance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if ( null == uniqueInstance ) {
			synchronized ( Singleton.class ) {
				if ( null == uniqueInstance ) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}

	public void print() {
		DateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		System.out.println( format.format( new Date() ) );
	}

}