package org.lop.modules.bean;

/**
 * 呼叫汇总.
 * 
 * @author 潘瑞峥
 * @date 2013-5-12
 */
public class CallTotalBean extends BaseBean {

	private static final long serialVersionUID = 1325704080722961646L;

	/** 号码. */
	private String mobile;

	/** 当前日期(yyyyMMdd) */
	private String curDate;

	/** 呼叫次数. */
	private int count;

	public String getMobile() {
		return mobile;
	}

	public void setMobile( String mobile ) {
		this.mobile = mobile;
	}

	public String getCurDate() {
		return curDate;
	}

	public void setCurDate( String curDate ) {
		this.curDate = curDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount( int count ) {
		this.count = count;
	}

}