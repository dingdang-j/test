package org.lop.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main( String[] args ) {
		ApplicationContext context = new ClassPathXmlApplicationContext( "org/lop/spring/collection/config.xml" );

		ListBean listBean = context.getBean( ListBean.class );
		System.out.println( listBean );
		
		SetBean setBean = context.getBean( SetBean.class );
		System.out.println( setBean );

		MapBean mapBean = context.getBean( MapBean.class );
		System.out.println( mapBean );

		PropertiesBean propertiesBean = context.getBean( PropertiesBean.class );
		System.out.println( propertiesBean );
	}

}