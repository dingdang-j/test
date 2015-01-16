package org.lop.spring.xml;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.lop.spring.Processor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleProcessor implements Processor {

	@Value( "#{constantProperties['constant.init.value']}" )
	private int value;

	private final AtomicInteger counter = new AtomicInteger();

	public void process() {
		System.out.println( counter.intValue() );
		System.out.println( "processing next 10 at " + new Date() );
		for ( int i = 0; i < 10; i++ ) {
			System.out.println( "   processing " + counter.incrementAndGet() );
		}
	}

	public void print() {
		System.out.println( "Hello! count: " + value );
	}

}