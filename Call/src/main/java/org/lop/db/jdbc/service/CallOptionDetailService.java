package org.lop.db.jdbc.service;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.lop.modules.bean.CallOptionDetailBean;
import org.lop.modules.db.SimpleDao;

/**
 * 呼叫程序选项详情业务层.
 * 
 * @author 潘瑞峥
 * @date 2013-5-11
 */
public class CallOptionDetailService {

	private static final String TABLE_NAME = "CALL_OPTION_DETAIL";

	private SimpleDao simpleDao;

	public CallOptionDetailService() {
		simpleDao = new SimpleDao();
	}

	/**
	 * 查询.
	 * 
	 * @param callOptionId
	 * @return
	 */
	public List<CallOptionDetailBean> find( String callOptionId ) {
		Validate.notBlank( callOptionId, "callOptionId不能为空" );

		StringBuilder sql = new StringBuilder();
		sql.append( "SELECT * FROM " ).append( TABLE_NAME );
		sql.append( " WHERE option_id = ?" );
		List<CallOptionDetailBean> result = this.simpleDao.query( CallOptionDetailBean.class, sql.toString(), callOptionId );
		return result;
	}

}