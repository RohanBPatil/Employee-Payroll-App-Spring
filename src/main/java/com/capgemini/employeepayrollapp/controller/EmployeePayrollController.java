package com.capgemini.employeepayrollapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.dto.ResponseDTO;
import com.capgemini.employeepayrollapp.exception.EmployeeException;
import com.capgemini.employeepayrollapp.model.Employee;
import com.capgemini.employeepayrollapp.service.IEmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	@Autowired
	IEmployeeService empService;

	@ApiOperation(value = "This API is used to get employee data from database", notes = "This method doesn't require any parameter", response = List.class)
	@GetMapping("/")
	public ResponseEntity<ResponseDTO> getMessage() {
		ResponseDTO respDTO = new ResponseDTO("Get call success", "Welcome");
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeeDataById(@PathVariable("empId") Long empId) throws EmployeeException {
		Employee emp = empService.getEmployeeById(empId);
		ResponseDTO respDTO = new ResponseDTO("Employee with employee Id : " + empId, emp);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO)
			throws EmployeeException {
		Employee emp = empService.addEmployee(employeeDTO);
		ResponseDTO respDTO = new ResponseDTO("Added Employee", emp);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable("empId") Long empId,
			@RequestBody EmployeePayrollDTO employeeDTO) throws EmployeeException {
		Employee emp = empService.updateEmployeeById(empId, employeeDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee ", emp);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeeById(@PathVariable("empId") Long empId) {
		empService.deleteEmployeeById(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted the employee with id : " + empId, empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<ResponseDTO> getAllEmployees() {
		List<Employee> employeesList = empService.getAllEmployees();
		ResponseDTO respDTO = new ResponseDTO("Details of all Employees :", employeesList);
		return new ResponseEntity<>(respDTO, HttpStatus.OK);
	}
}
