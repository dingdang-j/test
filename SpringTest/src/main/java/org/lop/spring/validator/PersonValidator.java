package org.lop.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

	public boolean supports( Class<?> clazz ) {
		return Person.class.equals( clazz );
	}

	public void validate( Object target, Errors errors ) {
		ValidationUtils.rejectIfEmpty( errors, "name", "name.empty" );
	}

}