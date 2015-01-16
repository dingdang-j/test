package org.lop.spring.scope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main( String[] args ) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext( "classpath:org/lop/spring/scope/config.xml" );

		CountBean countBean1 = context.getBean( CountBean.class );
		CountBean countBean2 = context.getBean( CountBean.class );
		System.out.println( countBean1.equals( countBean2 ) );

		System.out.println( countBean1 );
		countBean1.add();
		System.out.println( countBean1 );

		System.out.println( countBean2 );
		countBean2.add();
		System.out.println( countBean2 );

		System.out.println( context.getBean( CountBean.class ).equals( context.getBean( CountBean.class ) ) );
		context.registerShutdownHook();
	}

}