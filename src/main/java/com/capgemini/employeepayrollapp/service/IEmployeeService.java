package com.capgemini.employeepayrollapp.service;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.exception.EmployeeException;
import com.capgemini.employeepayrollapp.model.Employee;

public interface IEmployeeService {
	public Employee addEmployee(EmployeePayrollDTO employeeDTO);

	public void updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeeException;

	public Employee getEmployeeById(Long id) throws EmployeeException;

	public void deleteEmployeeById(Long id);
}
