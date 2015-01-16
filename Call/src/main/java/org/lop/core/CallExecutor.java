package org.lop.core;

import java.util.concurrent.ExecutorService;

import org.lop.frame.CallFrame;
import org.lop.modules.bean.CallOptionBean;

/**
 * 异步线程.
 * 
 * @author 潘瑞峥
 * @date 2013-5-13
 */
public class CallExecutor implements Runnable {

	public boolean mark = true;

	public ExecutorService executor;

	private CallCrudMotion callCrudMotion;

	private CallOptionBean callOptionBean;

	public CallExecutor( CallOptionBean callOptionBean ) {
		callCrudMotion = new CallCrudMotion();
		this.callOptionBean = callOptionBean;
	}

	@Override
	public void run() {
		String input = CallFrame.callMobilePrefix.getText() + CallFrame.callMobileValue.getText();
		int maxCount = CallFrame.callMaxSlider.getValue();
		int callCount = CallFrame.callAcountSlider.getValue();

		int i = 0;
		while ( mark && i < callCount && i < maxCount && callCount <= maxCount ) {
			i++;
			System.out.println( "当前次数: [" + i + "]" );
			callCrudMotion.action( input, callOptionBean );
		}

		System.out.println( "执行完成..." );
		CallFrame.close();

		if ( null != executor ) {
			executor.shutdownNow();
		}
	}

}