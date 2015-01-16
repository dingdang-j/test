package org.lop.spring.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main( String[] args ) {
		ApplicationContext context = new ClassPathXmlApplicationContext( "classpath:org/lop/spring/spel/config.xml" );

		MyBean bean = context.getBean( MyBean.class );
		System.out.println( bean );
	}

}