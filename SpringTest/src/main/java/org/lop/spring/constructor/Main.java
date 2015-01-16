package org.lop.spring.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main( String[] args ) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "classpath:org/lop/spring/constructor/config.xml" );
		MyConstructor bean = ctx.getBean( MyConstructor.class );
		System.out.println( bean );
	}

}