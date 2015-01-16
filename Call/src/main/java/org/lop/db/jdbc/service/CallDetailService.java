package org.lop.db.jdbc.service;

import java.util.Date;

import org.lop.modules.db.SimpleDao;
import org.lop.modules.utils.UUIDUtils;

/**
 * 拨打流水业务层.
 * 
 * @author 潘瑞峥
 * @date 2013-5-8
 */
public class CallDetailService {

	private static final String TABLE_NAME = "CALL_DETAIL";

	private SimpleDao simpleDao;

	public CallDetailService() {
		simpleDao = new SimpleDao();
	}

	public void save( String mobile ) {
		this.save( mobile, null );
	}

	public void save( String mobile, String description ) {
		String sql = "INSERT INTO " + TABLE_NAME + "( ID, CUR_DATE, CUR_TIME, MOBILE, DESCRIPTION ) VALUES( ?, ?, ?, ?, ? )";
		Date date = new Date();
		this.simpleDao.save( sql, UUIDUtils.uuid(), UUIDUtils.getDate(), date, mobile, description );
	}

}