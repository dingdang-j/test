package org.lop.spring.differentconfig;

public class DifferentBean {

	private String msg;

	public void setMsg( String msg ) {
		this.msg = msg;
	}

	public void print() {
		System.out.println( "=====" + msg );
	}

}