package org.lop.spring.differentconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

public class Main {

	public static void main( String[] args ) {
		// String profile = "development";
		String profile = "d1";
		System.setProperty( AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, profile );

		ApplicationContext ctx = new ClassPathXmlApplicationContext( "classpath:org/lop/spring/differentconfig/config.xml" );
		DifferentBean bean = ctx.getBean( DifferentBean.class );
		bean.print();
	}

}