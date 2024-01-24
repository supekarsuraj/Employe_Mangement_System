package com.qsp.springboot_employee_management_system.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.qsp.springboot_employee_management_system.utility.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(PhoneNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handlePhoneNotFound(PhoneNotFound pnf) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(pnf.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Phone Not Found To Find the Employee");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFound(IdNotFound inf) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(inf.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Id Not Found To Find the Employee");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(DataNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handleDataNotFound(DataNotFound dnf) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(dnf.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Data Not Found To Display the Employees");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handleEmailNotFound(EmailNotFound enf) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(enf.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Email Not Found To Display the Employee");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NameNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handleNameNotFound(NameNotFound nnf) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(nnf.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Name Not Found To Display the Employee");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(AddressNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handleAddressNotFound(AddressNotFound anf) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(anf.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Address Not Found To Display the Employee");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(GradeNotCorrect.class)
	public ResponseEntity<ResponseStructure<String>> handleGradeNotCorrect(GradeNotCorrect gnc) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(gnc.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Grade Not Correct To Display the Employees");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		List<ObjectError> errors=ex.getAllErrors();
    List<ObjectError> errors=ex.getAllErrors();
		Map<String,String> map=new HashMap<String, String>();
		for (ObjectError objectError : errors) {
			FieldError error=(FieldError) objectError;
			String name=error.getField();
			String message=error.getDefaultMessage();
			map.put(name, message);

		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);

		// TODO Auto-generated method stub
//		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
}
