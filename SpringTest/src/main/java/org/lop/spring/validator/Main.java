package org.lop.spring.validator;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main( String[] args ) {
		ApplicationContext context = new ClassPathXmlApplicationContext( "classpath:org/lop/spring/validator/config.xml" );

		Bean bean = context.getBean( Bean.class );
		bean.setDate( new Date() );
		System.out.println( bean );
	}

}