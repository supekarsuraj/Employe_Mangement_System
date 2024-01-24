package com.qsp.springboot_employee_management_system.dao;

import java.util.List;
import java.util.Optional;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.springboot_employee_management_system.dto.Employee;
import com.qsp.springboot_employee_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo repo;

	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee findEmployee(int id) {
//		return repo.findById(id).get();
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Employee> findAllEmployee() {
		return repo.findAll();
	}
//****************************************************************************************
	
	//Commented because of introduced service pakage and logic is written in it
	/*public Employee deleteEmployee(int id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
//			repo.deleteById(id);
//			return optional.get();

			Employee employee = optional.get();
			repo.delete(employee);
			return employee;
		}
		return null;

		// ===============Optinal code for above=====================
		/*
		 * if(optional.isEmpty()) { return null; } return optional.get();
		 */
		// =========================================================
//	}
	
//****************************************************************************************
	public Employee deleteEmployee(Employee employee) {
		repo.delete(employee);
		return employee;
	}
	
//****************************************************************************************
	
	
	public Employee updateEmployee(int id,Employee employee) {
//		Optional<Employee> optional = repo.findById(id);
//		if (optional.isPresent()) {
////			Employee employee = optional.get();
//			employee.setId(id);
			return repo.save(employee);
//		}
//		return null;
	}

	public List<Employee> saveAllEmployee(List<Employee> list){
		return repo.saveAll(list);
	}
	
	public Employee updatePhone(int id,long phone) {
		Optional optional = repo.findById(id);
		if(optional.isPresent()) {
			Employee employee = (Employee) optional.get();
			employee.setPhone(phone);
			return repo.save(employee);
		}
		return null;
	}
	
	public Employee updateEmail(int id,String email) {
		Optional optional = repo.findById(id);
		if(optional.isPresent()) {
			Employee employee1 = (Employee) optional.get();
			employee1.setEmail(email);
			return repo.save(employee1);
		}
		return null;
	}
	
	public Employee updateSalary(int id,double salary) {
		Optional optional = repo.findById(id);
		if(optional.isPresent()) {
			Employee employee1 = (Employee) optional.get();
			employee1.setSalary(salary);
			return repo.save(employee1);
		}
		return null;
	}

	public Employee findEmployeeByPhone(long phone) {
		return repo.findEmployeeByPhone(phone);
	}

	public Employee findEmployeeByEmail(String email) {
		return repo.getEmployeeByEmail(email);
	}

	public List<Employee> findByAddress(String address) {
		return repo.employeeByAddress(address);
	}
	
	public List<Employee> findEmployeeByName(String name){
		return repo.employeeByName(name);
	}
	
	public List<Employee> empSalaryLessThan(double salary) {
		return repo.findEmployeeBySalaryLessThan(salary);
	}

	public List<Employee> salGreaterThan(double salary) {
		return repo.findEmployeeBySalaryGreaterThan(salary);
	}

	public List<Employee> findEmployeeBySalaryBetween(double salary1, double salary2) {
		return repo.empSalaryBetween(salary1,salary2);
	}

	//==============================================================================
//	public List<Employee> salBetween(double salary1, double salary2) {
//		return repo.empSalaryBetween(salary1,salary2);
//	}
//==============================================================================
	
	public List<Employee> findByGrade(char grade) {
		return repo.findEmployeeByGrade(grade);
	}

	

}
