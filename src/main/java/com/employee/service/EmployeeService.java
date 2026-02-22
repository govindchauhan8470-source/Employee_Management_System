package com.employee.service;

import java.util.List;
import com.employee.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee getEmployeeById(Integer id);

	List<Employee> getAllEmployees();

	Employee updateEmployee(Integer id, Employee employee);

	void deleteEmployee(Integer id);
}
