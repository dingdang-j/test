package org.lop.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.lop.db.jdbc.service.CallTotalService;
import org.lop.frame.CallFrame;
import org.lop.modules.bean.CallOptionBean;
import org.lop.modules.bean.CallOptionDetailBean;
import org.lop.modules.constant.CallOptionTypeEnum;
import org.lop.modules.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 整个完整动作.
 * 
 * @author 潘瑞峥
 * @date 2013-5-6
 */
public class CallCrudMotion {

	private static final Logger logger = LoggerFactory.getLogger( CallCrudMotion.class );

	private Robot robot;

	private CallBasicMotion callBasicMotion;

	private CallTotalService service;

	public CallCrudMotion() {
		try {
			robot = new Robot();
		} catch ( AWTException e ) {
			logger.error( "创建Robot异常", e );
			throw new RuntimeException( e );
		}
		callBasicMotion = new CallBasicMotion();
		service = new CallTotalService();
	}

	/**
	 * 组合动作.
	 * 
	 * @param input
	 * @param bean
	 */
	public void action( String input, CallOptionBean bean ) {
		Validate.notNull( bean, "bean不能为空" );
		Map<CallOptionTypeEnum, CallOptionDetailBean> settings = bean.getDetails();
		Validate.notNull( settings, "bean.details不能为空" );

		CallOptionDetailBean setting = null;
		int index = 1;
		int rate = 100 / 4;
		int connTime = Constant.DEFAULT_UNIT_MS * CallFrame.connTimeSlider.getValue();
		int callRate = Constant.DEFAULT_UNIT_MS * CallFrame.callRateSlider.getValue();

		// 保存.
		this.service.save( input );

		/* 1.移动到并点击"打电话". */
		setting = settings.get( CallOptionTypeEnum.CALL_TAB );
		callBasicMotion.execute( robot, setting.getxCoords(), setting.getyCoords(), Constant.DEFAULT_MS );
		CallFrame.callProgressBar.setValue( index++ * rate );

		/* 2.移动到并输入号码. */
		setting = settings.get( CallOptionTypeEnum.INPUT_BOX );
		callBasicMotion.execute( robot, setting.getxCoords(), setting.getyCoords(), Constant.DEFAULT_MS, input );
		CallFrame.callProgressBar.setValue( index++ * rate );

		/* 3.移动到并拨号. */
		setting = settings.get( CallOptionTypeEnum.CALL_BUTTON );
		callBasicMotion.execute( robot, setting.getxCoords(), setting.getyCoords(), connTime );
		CallFrame.callProgressBar.setValue( index++ * rate );

		/* 4.移动到并停止拨号. */
		setting = settings.get( CallOptionTypeEnum.HANGUP_BUTTON );
		callBasicMotion.execute( robot, setting.getxCoords(), setting.getyCoords(), Constant.DEFAULT_MS );
		CallFrame.callProgressBar.setValue( index++ * rate );

		robot.delay( callRate );
	}

}