package org.lop.spring.txt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main( String[] args ) {
		ApplicationContext context = new ClassPathXmlApplicationContext( "classpath:org/lop/spring/txt/config.xml" );

		MyBean bean = context.getBean( MyBean.class );
		System.out.println( bean );
	}

}