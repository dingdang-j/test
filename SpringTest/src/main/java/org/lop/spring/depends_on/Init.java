package org.lop.spring.depends_on;

public class Init {

	public Init() {
		DependBean.setName( "名称" );

		System.out.println( "初始化..." );
	}

	public void destory() {
		System.out.println( "destory" );
	}

	public void initialize() {
		System.out.println( "initialize" );
	}

}