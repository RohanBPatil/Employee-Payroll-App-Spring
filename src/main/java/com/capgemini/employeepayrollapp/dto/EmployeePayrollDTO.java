package com.capgemini.employeepayrollapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeePayrollDTO {
	@NotEmpty(message = "Name should not be null")
	public String name;
	@NotNull
	public long salary;
}
