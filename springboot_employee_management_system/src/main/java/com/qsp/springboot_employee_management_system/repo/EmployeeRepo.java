package com.qsp.springboot_employee_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springboot_employee_management_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	//Cutomize Method to Find Employee By Phone
	//Implementation Given By Spring Boot Bacause Two Keywords "find" & "By"
	Employee findEmployeeByPhone(long phone);

	
	//Cutomize Method to Find Employee By Phone
	//Implementation Given By Spring Boot Bacause Two Keywords "get" & "By"
	Employee getEmployeeByEmail(String email);

	//Cutomize Method to Find Employee By Phone
	//Implementation Given By Us Using Query
	@Query("SELECT e FROM Employee e WHERE e.address=?1")
	List<Employee> employeeByAddress(String address);

	
	//Cutomize Method to Find Employee By Phone
	//Implementation Given By Us Using Query
	@Query("SELECT e FROM Employee e WHERE e.name=?1")
	List<Employee> employeeByName(String name);

	//Cutomize Method to Find Employee Whose salary is less than
	//Implementation Given By Spring Boot Bacause Two Keywords "find","By","Less","Than"
	List<Employee> findEmployeeBySalaryLessThan(double salary);

	//Cutomize Method to Find Employee Whose salary is less than
	//Implementation Given By Spring Boot Bacause Two Keywords "find","By","Greater","Than"	
	List<Employee> findEmployeeBySalaryGreaterThan(double salary);


	//==============================================================================
	
//	@Query("SELECT s FROM Employee s WHERE s.salary>=?1 AND s.salary<=?2")
	@Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
	List<Employee> empSalaryBetween(double salary1, double salary2);

	
	List<Employee> findEmployeeByGrade(char grade);
	
	//==============================================================================
			
	
}
