package com.capgemini.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private long salary;

	public Employee() {
	}

	public Employee(long id, EmployeePayrollDTO employeeDTO) {
		this.id = id;
		this.name = employeeDTO.getName();
		this.salary = employeeDTO.getSalary();
	}
	
	public Employee(EmployeePayrollDTO employeeDTO) {
		this.name = employeeDTO.getName();
		this.salary = employeeDTO.getSalary();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
