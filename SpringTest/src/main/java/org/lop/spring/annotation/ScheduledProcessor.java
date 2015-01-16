package org.lop.spring.annotation;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.lop.spring.Processor;
import org.lop.spring.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledProcessor implements Processor {

	private final AtomicInteger counter = new AtomicInteger();

	@Autowired
	private Worker worker;

	@Scheduled( cron = "0/10 * * * * ?" )
	public void process() {
		System.out.println( "processing next 10 at " + new Date() );
		for ( int i = 0; i < 10; i++ ) {
			worker.work( counter.incrementAndGet() );
		}
	}

}