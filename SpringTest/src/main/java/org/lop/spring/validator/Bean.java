package org.lop.spring.validator;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

@Component
public class Bean {

	@NotNull
	private String name;

	@DateTimeFormat( iso = ISO.DATE )
	private Date date;

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate( Date date ) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format( "name: %s, date: %s", name, date );
	}

}