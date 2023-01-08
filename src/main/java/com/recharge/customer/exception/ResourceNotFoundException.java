package com.recharge.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private String resourcename;
	private String fieldName;
	private long fieldvalue;

	public ResourceNotFoundException(String resourcename, String fieldName, long fieldvalue) {
		super();
		this.resourcename = resourcename;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}

	public String getResourcename() {
		return resourcename;
	}

	public String getFieldName() {
		return fieldName;
	}

	public long getFieldvalue() {
		return fieldvalue;
	}

}
