package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmp(EmployeeDto dto);
	
	APIResponseDto getEmpById(Long empId);
	
}
