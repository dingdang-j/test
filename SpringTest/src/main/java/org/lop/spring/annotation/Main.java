package org.lop.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main( String[] args ) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "classpath:org/lop/spring/annotation/config.xml" );
		ctx.getBean( ScheduledProcessor.class );
	}

}