package com.capgemini.employeepayrollapp.service;

import java.util.List;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.exception.EmployeeException;
import com.capgemini.employeepayrollapp.model.Employee;

public interface IEmployeeService {
	public Employee addEmployee(EmployeePayrollDTO employeeDTO) throws EmployeeException;

	public Employee updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeeException;

	public Employee getEmployeeById(Long id) throws EmployeeException;

	public void deleteEmployeeById(Long id);

	public List<Employee> getAllEmployees();
}
