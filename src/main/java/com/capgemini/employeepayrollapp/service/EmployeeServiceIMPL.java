package com.capgemini.employeepayrollapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.exception.EmployeeException;
import com.capgemini.employeepayrollapp.model.Employee;
import com.capgemini.employeepayrollapp.repository.IEmployeeRepository;

@Service
public class EmployeeServiceIMPL implements IEmployeeService {
	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(EmployeePayrollDTO employeeDTO) throws EmployeeException {
		Employee emp = new Employee(employeeDTO);
		emp = employeeRepository.save(emp);
		return emp;
	}

	@Override
	public Employee getEmployeeById(Long id) throws EmployeeException {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Invalid User id"));
	}

	@Override
	public Employee updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeeException {
		Employee emp = getEmployeeById(id);
		if (employeeDTO.getName() != null) {
			emp.setName(employeeDTO.getName());
		}
		if (employeeDTO.getSalary() != 0.0) {
			emp.setSalary(employeeDTO.getSalary());
		}
		employeeRepository.save(emp);
		return emp;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}