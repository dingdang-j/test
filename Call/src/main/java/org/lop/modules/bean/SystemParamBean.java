package org.lop.modules.bean;

import org.lop.modules.constant.YesOrNoEnum;

/**
 * 系统参数.
 * 
 * @author 潘瑞峥
 * @date 2013-5-10
 */
public class SystemParamBean extends BaseBean {

	private static final long serialVersionUID = 6746135024618685044L;

	private String name;

	/** key. */
	private String key;

	/** value. */
	private String value;

	/** 只读. */
	private YesOrNoEnum readonly;

	/** 描述. */
	private String description;

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey( String key ) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue( String value ) {
		this.value = value;
	}

	public YesOrNoEnum getReadonly() {
		return readonly;
	}

	public void setReadonly( YesOrNoEnum readonly ) {
		this.readonly = readonly;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

}