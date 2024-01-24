package com.qsp.springboot_employee_management_system.service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.qsp.springboot_employee_management_system.dao.EmployeeDao;
import com.qsp.springboot_employee_management_system.dto.Employee;
import com.qsp.springboot_employee_management_system.exception.AddressNotFound;
import com.qsp.springboot_employee_management_system.exception.DataNotFound;
import com.qsp.springboot_employee_management_system.exception.EmailNotFound;
import com.qsp.springboot_employee_management_system.exception.GradeNotCorrect;
import com.qsp.springboot_employee_management_system.exception.IdNotFound;
import com.qsp.springboot_employee_management_system.exception.NameNotFound;
import com.qsp.springboot_employee_management_system.exception.PhoneNotFound;
import com.qsp.springboot_employee_management_system.utility.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		double sal = employee.getSalary();
		if (sal < 10000) {
			employee.setGrade('D');
		} else if (sal >= 10000 && sal < 20000) {
			employee.setGrade('C');
		} else if (sal >= 20000 && sal < 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setMessage("Employee Save Successful");
		structure.setStatus(HttpStatus.CREATED.value()); // structure.setStatus(201);
		structure.setData(dao.saveEmployee(employee));
//		return dao.saveEmployee(employee);
//		return structure;
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED );
	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id) {
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setMessage("Employee Found Successful");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);
//			return structure;
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.FOUND);
			
		} else {
//			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
//			structure.setMessage("Employee Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(employee);
//			return structure;
			throw new IdNotFound("Employee Id Not Found");
		}

//		return dao.findEmployee(id);
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> list = dao.findAllEmployee();
		if (list.isEmpty()) {
//			structure.setMessage("Not Data Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(list);
//			return structure;
			throw new DataNotFound("Data Not Found For Employee");
		} else {
			structure.setMessage("List Of Employees Found");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.FOUND );
			
		}
//		return dao.findAllEmployee();
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable int id) {
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setMessage("Employee Deleted Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.deleteEmployee(employee));
//			return structure;
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK );
		} else {
//			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
//			structure.setMessage("Employee Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(dao.deleteEmployee(employee));
//			return structure;
			throw new IdNotFound("Id Not Found To Delete the Employee");
		}
//***********************************************************************************
		/*
		 * if(employee!=null) { return dao.deleteEmployee(employee); } return null;
		 */
//***********************************************************************************
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id, Employee employee) {
		Employee dbEmployee = dao.findEmployee(id);
		// if(dbEmployee!=null) {

		if (dbEmployee != null) {
			double sal = employee.getSalary();
			if (sal < 10000) {
				employee.setGrade('D');
			} else if (sal >= 10000 && sal < 20000) {
				employee.setGrade('C');
			} else if (sal >= 20000 && sal < 40000) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setMessage("Employee updated Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			employee.setId(id);
			structure.setData(dao.updateEmployee(id, employee));
//			return structure;
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK );
		} else {
//			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
//			structure.setMessage("Employee Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(employee);
//			return structure;
			throw new IdNotFound("Id Not Found To Update the Employee");
		}
//***********************************************************************************
//			employee.setId(id);

//			return saveEmployee(employee);

//***********************************************************************************
		/*
		 * double sal = employee.getSalary(); if(sal<10000) { employee.setGrade('D');
		 * }else if(sal>=10000 && sal<20000) { employee.setGrade('C'); }else
		 * if(sal>=20000 && sal<40000) { employee.setGrade('B'); }else {
		 * employee.setGrade('A'); } return dao.saveEmployee(employee);
		 */

		// }

//		return null;
//***********************************************************************************
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployee(List<Employee> list) {

		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();

		for (Employee employee : list) {
//			Employee dbEmployee = dao.findEmployee(employee.getId());
			if (employee != null) {
				double sal = employee.getSalary();
				if (sal < 10000) {
					employee.setGrade('D');
				} else if (sal >= 10000 && sal < 20000) {
					employee.setGrade('C');
				} else if (sal >= 20000 && sal < 40000) {
					employee.setGrade('B');
				} else {
					employee.setGrade('A');
				}
			}
		}
		structure.setMessage("All  Employee saved Successful");
		structure.setStatus(HttpStatus.CREATED.value()); // structure.setStatus(201);
		structure.setData(dao.saveAllEmployee(list));
//		return structure;
		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.CREATED );
//		return dao.saveAllEmployee(list);
	}

	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) {
//		Employee employee = dao.findEmployee(id);
//		if (employee != null) {
//			employee.setPhone(phone);
//			return dao.updatePhone(id, phone);
//		}
//		return null;
		
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setMessage("Employee Phone Updated Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.updatePhone(id, phone));
//			return structure;
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED );
		} else {
//			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
//			structure.setMessage("Employee Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(dao.updatePhone(id, phone));
//			return structure;
			throw new IdNotFound("Id Not Found To Update the Phone Of Employee");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) {
		
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setMessage("Employee Email Updated Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.updateEmail(id, email));
//			return structure;
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED );
		} else {
//			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
//			structure.setMessage("Employee Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(employee);
//			return structure;
			throw new IdNotFound("Id Not Found To Update the Email Of Employee");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) {
//		Employee employee = dao.findEmployee(id);
//		if (employee != null) {
//			employee.setSalary(salary);
//			return saveEmployee(employee);
//		}
//		return null;
		
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setMessage("Employee Salary Updated Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.updateSalary(id, salary));
//			return structure;
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED );
		} else {
//			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
//			structure.setMessage("Employee Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(employee);
//			return structure;
			throw new IdNotFound("Id Not Found To Update the Salary Of Employee");
		}
		
		
	}

	public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone) {
		
		Employee employee = dao.findEmployeeByPhone(phone);
		if (employee != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setMessage("Employee Found With Given Phone Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.findEmployeeByPhone(phone));
//			return structure;
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK );
		} else {
//			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
//			structure.setMessage("Employee Not Found With Given Phone");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(employee);
//			return structure;
			throw new PhoneNotFound("Phone Number Not Found To search for Employee");
		}
//		return dao.findEmployeeByPhone(phone);
	}

	public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email) {
		
		Employee employee = dao.findEmployeeByEmail(email);
		if (employee != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setMessage("Employee Found With Given Email Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.findEmployeeByEmail(email));
//			return structure;
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED );
		} else {
//			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
//			structure.setMessage("Employee Not Found With Given Phone");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
////			structure.setData(employee);
//			return structure;
			throw new EmailNotFound("Email Not Found");
		}
//		return dao.findEmployeeByEmail(email);
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByAddress(String address) {

		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> list = dao.findByAddress(address);
		if (list.isEmpty()) {
//			structure.setMessage("Not Employee Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(list);
//			return structure;
			throw new AddressNotFound("No Such Address Found For Employee");
		} else {
			structure.setMessage("Employees Found");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Employee>>>(HttpStatus.FOUND );
			
		}
		
		//		return dao.findByAddress(address);
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByName(String name) {
		
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> list = dao.findEmployeeByName(name);
		if (list.isEmpty()) {
//			structure.setMessage("Employee Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(list);
//			return structure;
			throw new NameNotFound("Given Employee Name is not present");
		} else {
			structure.setMessage("Employees Found With Given Name");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.CREATED );
			
		}
		

	}

	public ResponseStructure<List<Employee>> empSalaryLessThan(double salary) {
		
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> list = dao.empSalaryLessThan(salary);
		if (list.isEmpty()) {
			structure.setMessage("Employee Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value()); 
			structure.setData(list);
			return structure;
		} else {
			structure.setMessage("Employees Found With Less than Given Salary");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return structure;
		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> salGreaterThan(double salary) {
		
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> list = dao.salGreaterThan(salary);
		if (list.isEmpty()) {
			structure.setMessage("Employee Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.NOT_FOUND );
		} else {
			structure.setMessage("Employees Found With Greater than Given Salary");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.FOUND );
		}
		
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByGrade(char grade) {
		
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> list = dao.findByGrade(grade);
		if (list.isEmpty()) {
			structure.setMessage("Employee Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
			structure.setData(list);
//			return structure;
			
			throw new GradeNotCorrect("Enter Correct Grade To Find Employees");
			
		} else {
			structure.setMessage("Employees Found With Given grade");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.FOUND );
		}
		
//		return dao.findByGrade(grade);
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalaryBetween(double salary1, double salary2) {
		
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> list = dao.findEmployeeBySalaryBetween(salary1,salary2);
		if (list.isEmpty()) {
			structure.setMessage("Employee Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.NOT_FOUND );
		} else {
			structure.setMessage("Employees Found With Salary Between");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.FOUND );
		}
		
//		return dao.findEmployeeBySalaryBetween(salary1, salary2);
	}
}
