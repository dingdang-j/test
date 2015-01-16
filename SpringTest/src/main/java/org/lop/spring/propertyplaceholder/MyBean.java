package org.lop.spring.propertyplaceholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@Value( "${key.b}" )
	private String name;

	// @Value( "#{key2['key2']}" )
	private String description;

	@Value( "${key.a}" )
	private static String remark;

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format( "name: %s, description: %s, remark: %s", name, description, remark );
	}

}