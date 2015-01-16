package org.lop.spring.scope;

import org.springframework.beans.factory.DisposableBean;

public class Call1 implements DisposableBean {

	private CountBean countBean;

	public void setCountBean( CountBean countBean ) {
		this.countBean = countBean;
	}

	@Override
	public String toString() {
		countBean.add();

		return countBean.toString();
	}

	public void destroy() throws Exception {
		System.out.println( "call1 destory..." );
	}

}