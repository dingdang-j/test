package org.lop.spring.spel;

import org.springframework.beans.factory.annotation.Value;

public class MyBean {

	private String name;

	@Value( "#{ T(java.lang.Math).random() * 100.0 }" )
	private Integer number;

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber( Integer number ) {
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format( "name: %s, number: %d", name, number );
	}

}