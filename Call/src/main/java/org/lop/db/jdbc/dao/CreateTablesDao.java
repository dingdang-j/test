package org.lop.db.jdbc.dao;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.lop.modules.constant.Constant;
import org.lop.modules.db.SimpleDao;

/**
 * 创建表.
 * 
 * @author 潘瑞峥
 * @date 2013-5-12
 */
public class CreateTablesDao extends SimpleDao {

	/**
	 * 初始化系统时，检查表是否创建，若没创建则自动创建.
	 */
	public void initTables() {
		if ( this.find() ) {
			this.createTables();
		}
	}

	/**
	 * 查询用户表是否为空.
	 * 
	 * @return
	 */
	private boolean find() {
		List<?> tables = super.query( Constant.SYSTEM_TABLES_SQL );
		if ( CollectionUtils.isEmpty( tables ) ) {
			logger.info( "未存在用户表" );
			return true;
		} else {
			logger.info( "已存在用户表" );
			return false;
		}
	}

	/**
	 * 创建表.
	 */
	private void createTables() {
		if ( StringUtils.isNotBlank( Constant.createTablesSql ) ) {
			super.save( Constant.createTablesSql );
		}
	}

}