package org.lop.modules.constant;

import javax.swing.DefaultComboBoxModel;

import org.lop.modules.bean.CallOptionBean;

/**
 * 常量.
 * 
 * @author 潘瑞峥
 * @date 2013-5-6
 */
public class Constant {

	/** jdbc路径. */
	public static final String JDBC_CONFIG_PATH = "jdbc.properties";

	/** sql路径. */
	public static final String CREATE_TABLES_SQL_PATH = "sql/h2.sql";

	/** 系统表sql. */
	public static final String SYSTEM_TABLES_SQL = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC'";

	/** 一秒的毫秒数. */
	public static final int DEFAULT_UNIT_MS = 1000;

	/** 默认的停顿时间. */
	public static final int DEFAULT_MS = 500;

	/** 初始化sql. */
	public static String createTablesSql;

	/** 下拉框集合. */
	public static DefaultComboBoxModel<CallOptionBean> comboBoxModel = new DefaultComboBoxModel<CallOptionBean>();

	/** 驱动. */
	public static String jdbcDriver;

	/** url. */
	public static String jdbcUrl;

	/** 用户名. */
	public static String jdbcUsername;

	/** 密码. */
	public static String jdbcPassword;

}