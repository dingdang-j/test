package org.lop.modules.bean;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.lop.modules.utils.UUIDUtils;

/**
 * 基类Bean.
 * 
 * @author 潘瑞峥
 * @date 2013-5-11
 */
public class BaseBean implements Serializable {

	private static final long serialVersionUID = -2884167904931927218L;

	private String id;

	public BaseBean() {
		this.setId( UUIDUtils.uuid() );
	}

	public String getId() {
		return id;
	}

	private void setId( String id ) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}