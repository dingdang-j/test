package org.lop.spring.collection;

import java.util.Set;

public class SetBean {

	private Set<String> param;

	public void setParam( Set<String> param ) {
		this.param = param;
	}

	@Override
	public String toString() {
		return this.param.toString();
	}

}