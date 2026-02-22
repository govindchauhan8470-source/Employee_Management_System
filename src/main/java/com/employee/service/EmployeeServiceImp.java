package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.exception.ResourceNotFoundException;


@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
	    return employeeRepository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Employee not found with id: " + id));
	    
//	    I implemented global exception handling using @ControllerAdvice 
//	    and custom exception classes to provide meaningful error responses.
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Integer id, Employee employee) {
		Employee existingEmployee = getEmployeeById(id);

		existingEmployee.setEmpName(employee.getEmpName());
		existingEmployee.setAddress(employee.getAddress());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setSalary(employee.getSalary());

		return employeeRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee employee = getEmployeeById(id);
		employeeRepository.delete(employee);
	}
}
