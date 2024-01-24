package com.qsp.springboot_employee_management_system.exception;

public class IdNotFound extends RuntimeException {
	private String message;

	public IdNotFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
