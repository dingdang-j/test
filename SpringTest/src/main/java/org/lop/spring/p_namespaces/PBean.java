package org.lop.spring.p_namespaces;

public class PBean {

	private String name;

	private Integer age;

	private String sex;

	private String remark;

	private DetailBean detailBean;

	public void setName( String name ) {
		this.name = name;
	}

	public void setAge( Integer age ) {
		this.age = age;
	}

	public void setSex( String sex ) {
		this.sex = sex;
	}

	public void setRemark( String remark ) {
		this.remark = remark;
	}

	public void setDetailBean( DetailBean detailBean ) {
		this.detailBean = detailBean;
	}

	@Override
	public String toString() {
		return String.format( "name: %s, age: %d, sex: %s, remark: %s, detail: %s", name, age, sex, remark, detailBean );
	}

}