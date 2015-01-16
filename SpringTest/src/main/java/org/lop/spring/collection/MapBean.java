package org.lop.spring.collection;

import java.util.Map;

public class MapBean {

	private Map<String, String> param;

	public void setParam( Map<String, String> param ) {
		this.param = param;
	}

	@Override
	public String toString() {
		return param.toString();
	}

}