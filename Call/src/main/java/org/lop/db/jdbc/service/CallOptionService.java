package org.lop.db.jdbc.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.lop.modules.bean.CallOptionBean;
import org.lop.modules.bean.CallOptionDetailBean;
import org.lop.modules.constant.CallOptionTypeEnum;
import org.lop.modules.db.SimpleDao;

import com.google.common.collect.Maps;

/**
 * 呼叫程序选项业务层.
 * 
 * @author 潘瑞峥
 * @date 2013-5-10
 */
public class CallOptionService {

	private static final String TABLE_NAME = "CALL_OPTION";

	private SimpleDao simpleDao;

	private CallOptionDetailService callOptionDetailService;

	public CallOptionService() {
		simpleDao = new SimpleDao();
		callOptionDetailService = new CallOptionDetailService();
	}

	/**
	 * 查询.
	 * 
	 * @return
	 */
	public List<CallOptionBean> find() {
		String id = null;
		String sql = "SELECT * FROM " + TABLE_NAME;
		List<CallOptionBean> result = this.simpleDao.query( CallOptionBean.class, sql );

		if ( CollectionUtils.isNotEmpty( result ) ) {
			for ( CallOptionBean bean : result ) {
				id = bean.getId();
				List<CallOptionDetailBean> list = this.callOptionDetailService.find( id );
				bean.setList( list );

				if ( CollectionUtils.isNotEmpty( list ) ) {
					Map<CallOptionTypeEnum, CallOptionDetailBean> details = Maps.newHashMap();
					for ( CallOptionDetailBean detailBean : list ) {
						details.put( detailBean.getTypeEnum(), detailBean );
					}
					bean.setDetails( details );
				}
			}
		}

		return result;
	}

}