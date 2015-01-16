package com.ylink.flow.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Flow连接关系bean
 * 
 * @author 潘瑞峥
 * @date 2012-10-9
 */
public class FlowConnectionBean {

	/** ID */
	private String id;

	/** 起点ID */
	@JsonProperty( "source" )
	private String sourceId;

	/** 终点ID */
	@JsonProperty( "target" )
	private String targetId;

	/** 是否通过 */
	private boolean mark;

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId( String sourceId ) {
		this.sourceId = sourceId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId( String targetId ) {
		this.targetId = targetId;
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark( boolean mark ) {
		this.mark = mark;
	}

	@Override
	public boolean equals( Object other ) {
		return EqualsBuilder.reflectionEquals( this, other );
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode( this );
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}