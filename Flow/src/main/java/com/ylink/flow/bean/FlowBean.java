package com.ylink.flow.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Flow Bean
 * 
 * @author 潘瑞峥
 * @date 2012-10-9
 */
public class FlowBean implements Serializable {

	private static final long serialVersionUID = 4017451519641760532L;

	/** ID */
	private String id;

	/** 名称 */
	private String name;

	/** 描述 */
	private String remark;

	/** 状态: 0.等待 1.通过 2.暂停 */
	private String state;

	/** 相关成员ID */
	private List<String> users = Lists.newArrayList();

	/** 是否含有相关成员 */
	private boolean userMark;

	/** 下个节点 */
	private Set<String> nextNodes = Sets.newHashSet();

	/** 是否含有下个节点 */
	private boolean nextNodesMark;

	public FlowBean() {
	}

	public FlowBean( String id, String name, String remark, String state ) {
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark( String remark ) {
		this.remark = remark;
	}

	public String getState() {
		return state;
	}

	public void setState( String state ) {
		this.state = state;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers( List<String> users ) {
		this.users = users;
	}

	public boolean isUserMark() {
		userMark = false;
		if ( CollectionUtils.isNotEmpty( this.getUsers() ) ) {
			userMark = true;
		}
		return userMark;
	}

	public Set<String> getNextNodes() {
		return nextNodes;
	}

	public void setNextNodes( Set<String> nextNodes ) {
		this.nextNodes = nextNodes;
	}

	public void setNextNodesMark( boolean nextNodesMark ) {
		this.nextNodesMark = nextNodesMark;
	}

	public boolean isNextNodesMark() {
		nextNodesMark = false;
		if ( CollectionUtils.isNotEmpty( this.getNextNodes() ) ) {
			nextNodesMark = true;
		}
		return nextNodesMark;
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