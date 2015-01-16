package org.lop.spring.depends_on;

public class DependBean {

	private static String name;

	public static String getName() {
		return name;
	}

	public static void setName( String name ) {
		DependBean.name = name;
	}

	@Override
	public String toString() {
		return String.format( "name: %s", name );
	}

}