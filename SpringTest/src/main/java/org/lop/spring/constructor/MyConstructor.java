package org.lop.spring.constructor;

public class MyConstructor {

	private String name;

	private Integer age;

	public MyConstructor( String name, Integer age ) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		String result = String.format( "name: %s, age: %d", name, age );
		return result;
	}

}