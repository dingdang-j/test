package org.lop.db.jdbc.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.lop.frame.CallFrame;
import org.lop.modules.bean.CallTotalBean;
import org.lop.modules.db.SimpleDao;
import org.lop.modules.utils.UUIDUtils;

/**
 * 呼叫汇总业务层.
 * 
 * @author 潘瑞峥
 * @date 2013-5-8
 */
public class CallTotalService {

	private static final String TABLE_NAME = "CALL_TOTAL";

	private SimpleDao simpleDao;

	public CallTotalService() {
		simpleDao = new SimpleDao();
	}

	/**
	 * 保存汇总和流水.
	 * 
	 * @param mobile
	 * @throws Exception
	 */
	public void save( final String mobile ) {
		List<CallTotalBean> result = this.find( mobile );
		/* 新增. */
		if ( CollectionUtils.isEmpty( result ) ) {
			this.insert( mobile );
		}
		/* 修改. */
		else {
			CallTotalBean bean = result.get( 0 );
			String id = bean.getId();
			int count = bean.getCount();
			count += 1;

			/* 判断是否超过限制. */
			if ( CallFrame.callMaxSlider.getValue() <= count ) {
				throw new RuntimeException( "该号码[" + mobile + "]拨打次数超过最大限制[" + CallFrame.callMaxSlider.getValue() + "].", null );
			}

			this.update( id, count );
		}

		/* 保存流水. */
		CallDetailService service = new CallDetailService();
		service.save( mobile );
	}

	/**
	 * 查询.
	 * 
	 * @param mobile
	 * @return
	 */
	private List<CallTotalBean> find( final String mobile ) {
		StringBuilder sql = new StringBuilder();
		sql.append( "SELECT * FROM " ).append( TABLE_NAME );
		sql.append( " WHERE CUR_DATE = ?" );
		sql.append( " AND MOBILE = ?" );
		List<CallTotalBean> result = this.simpleDao.query( CallTotalBean.class, sql.toString(), UUIDUtils.getDate(), mobile );
		return result;
	}

	/**
	 * 新增.
	 * 
	 * @param mobile
	 */
	private void insert( final String mobile ) {
		String sql = "INSERT INTO " + TABLE_NAME + "( ID, CUR_DATE, COUNT, MOBILE ) VALUES( ?, ?, ?, ? )";
		this.simpleDao.save( sql, UUIDUtils.uuid(), UUIDUtils.getDate(), 1, mobile );
	}

	/**
	 * 修改.
	 * 
	 * @param id
	 * @param count
	 */
	private void update( final String id, final int count ) {
		StringBuilder sql = new StringBuilder();
		sql.append( "UPDATE " ).append( TABLE_NAME ).append( " SET COUNT = ?" );
		sql.append( "WHERE ID = ?" );
		this.simpleDao.save( sql.toString(), count, id );
	}

}