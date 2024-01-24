package com.qsp.springboot_employee_management_system.exception;

public class GradeNotCorrect extends RuntimeException{

	private String message;
	
	public GradeNotCorrect(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
}
