package com.capgemini.employeepayrollapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.exception.EmployeeException;
import com.capgemini.employeepayrollapp.model.Employee;
import com.capgemini.employeepayrollapp.service.IEmployeeService;

@RestController
@RequestMapping("/hello")
public class EmployeePayrollController {
	@Autowired
	IEmployeeService empService;

	@GetMapping("/")
	public ResponseEntity<String> getEmployeeData() {
		return new ResponseEntity<String>("Get call success", HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<Employee> getEmployeeDataById(@PathVariable("empId") Long empId) throws EmployeeException {
		Employee emp = empService.getEmployeeById(empId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO) {
		Employee emp = empService.addEmployee(employeeDTO);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<Void> updateEmployee(@PathVariable("empId") Long empId,
			@RequestBody EmployeePayrollDTO employeeDTO) throws EmployeeException {
		empService.updateEmployeeById(empId, employeeDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("empId") Long empId) {
		empService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Deleted the employee with id : " + empId, HttpStatus.OK);
	}
}
