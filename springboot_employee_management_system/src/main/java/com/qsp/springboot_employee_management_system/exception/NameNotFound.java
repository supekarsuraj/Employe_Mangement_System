package com.qsp.springboot_employee_management_system.exception;

public class NameNotFound extends RuntimeException{

	private String message;
	
	public NameNotFound(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
