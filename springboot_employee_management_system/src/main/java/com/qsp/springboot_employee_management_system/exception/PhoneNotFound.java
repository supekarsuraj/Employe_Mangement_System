package com.qsp.springboot_employee_management_system.exception;

public class PhoneNotFound extends RuntimeException{
	
	private String message;

	public PhoneNotFound(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
