package org.lop.spring.validator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

@Component
public class MyBean {

	@Autowired
	private Validator validator;

	@Valid
	private Bean bean;

	public void test() {
		System.out.println( bean );
	}

}