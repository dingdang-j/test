package org.lop.spring.p_namespaces;

public class DetailBean {

	private String description;

	public void setDescription( String description ) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}

}