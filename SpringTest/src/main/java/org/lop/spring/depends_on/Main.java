package org.lop.spring.depends_on;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main( String[] args ) {
		ApplicationContext context = new ClassPathXmlApplicationContext( "classpath:org/lop/spring/depends_on/config.xml" );

		DependBean bean = context.getBean( DependBean.class );
		System.out.println( bean );
	}

}