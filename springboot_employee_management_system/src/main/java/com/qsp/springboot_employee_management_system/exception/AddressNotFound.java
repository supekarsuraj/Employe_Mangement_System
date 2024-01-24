package com.qsp.springboot_employee_management_system.exception;

public class AddressNotFound extends RuntimeException {
	private String message;

	public AddressNotFound(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
