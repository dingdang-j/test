package org.lop.spring.p_namespaces;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main( String[] args ) {
		ApplicationContext context = new ClassPathXmlApplicationContext( "classpath:org/lop/spring/p_namespaces/config.xml" );

		PBean pBean = context.getBean( PBean.class );
		System.out.println( pBean );
	}

}