package org.lop.spring.annotation;

import org.lop.spring.Worker;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncWorker implements Worker {

	@Async
	public void work( int i ) {
		String threadName = Thread.currentThread().getName();
		System.out.println( "   " + threadName + " beginning work on " + i );
		try {
			Thread.sleep( 5000 ); // simulates work
		} catch ( InterruptedException e ) {
			Thread.currentThread().interrupt();
		}
		System.out.println( "   " + threadName + " completed work on " + i );
	}

}