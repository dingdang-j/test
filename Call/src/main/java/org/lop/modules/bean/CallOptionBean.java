package org.lop.modules.bean;

import java.util.List;
import java.util.Map;

import org.lop.modules.constant.CallOptionTypeEnum;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 呼叫程序选项.
 * 
 * @author 潘瑞峥
 * @date 2013-5-10
 */
public class CallOptionBean extends BaseBean {

	private static final long serialVersionUID = 3955439421877904647L;

	private String name;

	/** 顺序. */
	private Integer sort;

	/** 程序安装的路径. */
	private String path;

	/** 账号. */
	private String username;

	/** 密码. */
	private String password;

	/** 描述. */
	private String description;

	/** 明细. */
	private List<CallOptionDetailBean> list = Lists.newArrayList();

	/** 明细. */
	private Map<CallOptionTypeEnum, CallOptionDetailBean> details = Maps.newHashMap();

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort( Integer sort ) {
		this.sort = sort;
	}

	public String getPath() {
		return path;
	}

	public void setPath( String path ) {
		this.path = path;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public List<CallOptionDetailBean> getList() {
		return list;
	}

	public void setList( List<CallOptionDetailBean> list ) {
		this.list = list;
	}

	public Map<CallOptionTypeEnum, CallOptionDetailBean> getDetails() {
		return details;
	}

	public void setDetails( Map<CallOptionTypeEnum, CallOptionDetailBean> details ) {
		this.details = details;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}