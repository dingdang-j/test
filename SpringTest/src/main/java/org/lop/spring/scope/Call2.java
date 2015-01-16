package org.lop.spring.scope;

public class Call2 {

	private CountBean countBean;

	public void setCountBean( CountBean countBean ) {
		this.countBean = countBean;
	}

	@Override
	public String toString() {
		countBean.add();
		
		return countBean.toString();
	}

}