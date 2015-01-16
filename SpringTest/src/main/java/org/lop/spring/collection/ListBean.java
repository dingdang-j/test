package org.lop.spring.collection;

import java.util.List;

public class ListBean {

	private List<Integer> param;

	public void setParam( List<Integer> param ) {
		this.param = param;
	}

	@Override
	public String toString() {
		return param.toString();
	}

}