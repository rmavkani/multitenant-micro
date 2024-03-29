package net.javaguides.employeeservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.repository.EmplyeeRepo;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;

@AllArgsConstructor
@Service
public class EmplyeeServiceImpl implements EmployeeService {

	EmplyeeRepo empRepo;

	//RestTemplate restTemplate;
	
	//WebClient webClient;
	APIClient apiClient;

	@Override
	public EmployeeDto saveEmp(EmployeeDto dto) {
		Employee emp = new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(),
				dto.getDeptCode());
		Employee savedEmp = empRepo.save(emp);

		return new EmployeeDto(savedEmp.getId(), savedEmp.getFirstName(), savedEmp.getLastName(), savedEmp.getEmail(),
				dto.getDeptCode());
	}

	@Override
	public APIResponseDto getEmpById(Long empId) {

		Employee savedEmp = empRepo.findById(empId).get();

		
		
		/*
		 * ResponseEntity<DepartmentDto> resEntity = restTemplate
		 * .getForEntity("http://localhost:8080/api/departments/" +
		 * savedEmp.getDeptCode(), DepartmentDto.class); DepartmentDto deptDto
		 * =resEntity.getBody();
		 */
		 
		
		//DepartmentDto deptDto =webClient.get().uri("http://localhost:8080/api/departments/" + savedEmp.getDeptCode()).retrieve().bodyToMono(DepartmentDto.class).block();

		DepartmentDto deptDto=apiClient.getDept(savedEmp.getDeptCode());

		EmployeeDto empDto = new EmployeeDto(savedEmp.getId(), savedEmp.getFirstName(), savedEmp.getLastName(),
				savedEmp.getEmail(), savedEmp.getDeptCode());

		APIResponseDto apiResDto = new APIResponseDto();

		apiResDto.setDeptDto(deptDto);
		apiResDto.setEmpDto(empDto);

		return apiResDto;
	}

}
