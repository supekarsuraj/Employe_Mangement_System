package com.qsp.springboot_employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_employee_management_system.dao.EmployeeDao;
import com.qsp.springboot_employee_management_system.dto.Employee;
import com.qsp.springboot_employee_management_system.service.EmployeeService;
import com.qsp.springboot_employee_management_system.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	
//********************************************************************************************
	
		@Autowired
		private EmployeeService service;
		
		@PostMapping("/save")
		public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) {
			return service.saveEmployee(employee);
		}
		
		@GetMapping("/fetch")
		public ResponseEntity<ResponseStructure<Employee>> findEmployee(@RequestParam int id){
			return service.findEmployee(id);
		}
		
		@GetMapping("/fetchall")
		public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
			return service.findAllEmployee();
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable int id) {
			return service.deleteEmployee(id);
		}
		
		@PutMapping("/update")
		public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id,@RequestBody Employee employee) {
			return service.updateEmployee(id, employee);
		}

		@PostMapping("/saveall")
		public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployee(@RequestBody List<Employee> list) {
			return service.saveAllEmployee(list);
		}
		
		@PatchMapping("/updatephone")
		public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id,long phone) {
			return service.updatePhone(id, phone);
		}
		
		@PatchMapping("/updateemail")
		public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id,String email) {
			return service.updateEmail(id, email);
		}
		
		@PatchMapping("/updatesalary")
		public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id,double salary) {
			return service.updateSalary(id,salary);
		}
		
		@GetMapping("/findbyphone")
		public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone) {
			return service.findByPhone(phone);
		}
		
		@GetMapping("/findbyemail")
		public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email) {
			return service.findByEmail(email);
		}
		
		@GetMapping("/findbyaddress")
		public ResponseEntity<ResponseStructure<List<Employee>>> findEmplpyeeByAddress(String address){
			return service.findByAddress(address);
		}
		
		@GetMapping("/findbyname")
		public ResponseEntity<ResponseStructure<List<Employee>>> findEmplpyeeByName(String name){
			return service.findByName(name);
		}
		
		@GetMapping("/sallessthan")
		public ResponseStructure<List<Employee>> empSalaryLessThan(double salary){
			return service.empSalaryLessThan(salary);
		}
		
		@GetMapping("/salgreaterthan")
		public ResponseEntity<ResponseStructure<List<Employee>>> empSalaryGreaterThan(double salary){
			return service.salGreaterThan(salary);
		}
		
		@GetMapping("/salarybetween")
		public ResponseEntity<ResponseStructure<List<Employee>>> salBetween(double salary1,double salary2){
			return service.findEmployeeBySalaryBetween(salary1,salary2);
		}
		
		@GetMapping("/findbygrade")
		public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByGrade(char grade){
			return service.findByGrade(grade);
		}
//**********************************************************************************************

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//	@Autowired
//	private EmployeeDao dao;
		
//	@PostMapping("/save")
//	public Employee saveEmployee(@RequestBody Employee employee) {
//		return dao.saveEmployee(employee);
//	}
	
//	@GetMapping("/fetch")
//	public Employee findEmployee(@RequestParam int id){
//		return dao.findEmployee(id);
//	}
//	
//	@GetMapping("/fetchall")
//	public List<Employee> findAllEmployee() {
//		return dao.findAllEmployee();
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public Employee deleteEmployee(@PathVariable int id) {
//		return dao.deleteEmployee(id);
//	}
//
//	@PutMapping("/update")
//	public Employee updateEmployee(@RequestParam int id,@RequestBody Employee employee) {
//		return dao.updateEmployee(id, employee);
//	}
//	
//	@PostMapping("/saveall")
//	public List<Employee> saveAllEmployee(@RequestBody List<Employee> list) {
//		return dao.saveAllEmployee(list);
//	}
//	
//	@PatchMapping("/updatephone")
//	public Employee updatePhone(int id,long phone) {
//		return dao.updatePhone(id, phone);
//	}
//	
//	@PatchMapping("/updateemail")
//	public Employee updateEmail(int id,String email) {
//		return dao.updateEmail(id, email);
//	}
//	
//	@PatchMapping("/updatesalary")
//	public Employee updateSalary(int id,double salary) {
//		return dao.updateSalary(id,salary);
//	}
//	
//	@GetMapping("/findbyphone")
//	public Employee findByPhone(long phone) {
//		return dao.findByPhone(phone);
//	}
//	
//	@GetMapping("/findbyemail")
//	public Employee findByEmail(String email) {
//		return dao.findByEmail(email);
//	}
//	
//	@GetMapping("/findbyaddress")
//	public List<Employee> findEmplpyeeByAddress(String address){
//		return dao.findByAddress(address);
//	}
//	
//	@GetMapping("/findbyname")
//	public List<Employee> findEmplpyeeByName(String name){
//		return dao.findByName(name);
//	}
//	
//	@GetMapping("/sallessthan")
//	public List<Employee> salLessThan(double salary){
//		return dao.salLessThan(salary);
//	}
//	
//	@GetMapping("/salgreaterthan")
//	public List<Employee> salGreaterThan(double salary){
//		return dao.salGreaterThan(salary);
//	}
	
//	@GetMapping("/salarybetween")
//	public List<Employee> salBetween(double salary1,double salary2){
//		return dao.salBetween(salary1,salary2);
//	}
		
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
}
