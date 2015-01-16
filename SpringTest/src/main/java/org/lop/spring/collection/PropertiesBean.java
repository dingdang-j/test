package org.lop.spring.collection;

import java.util.Properties;

public class PropertiesBean {

	private Properties param;

	public void setParam( Properties param ) {
		this.param = param;
	}

	@Override
	public String toString() {
		return param.toString();
	}

}