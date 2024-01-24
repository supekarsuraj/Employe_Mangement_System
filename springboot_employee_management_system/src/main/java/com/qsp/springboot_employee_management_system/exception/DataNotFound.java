package com.qsp.springboot_employee_management_system.exception;

public class DataNotFound extends RuntimeException {
	private String message;

	public DataNotFound(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
