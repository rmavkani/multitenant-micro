package net.javaguides.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService empService;

	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmp(@RequestBody EmployeeDto dto) {

		EmployeeDto savedEmp = empService.saveEmp(dto);
		return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long empId) {
		APIResponseDto dto = empService.getEmpById(empId);
		return new ResponseEntity<APIResponseDto>(dto, HttpStatus.OK);
	}

}
