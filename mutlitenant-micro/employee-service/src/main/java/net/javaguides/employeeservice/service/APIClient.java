package net.javaguides.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.employeeservice.dto.DepartmentDto;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {

	@GetMapping("/api/departments/{dept-code}")
	DepartmentDto getDept(@PathVariable("dept-code") String deptCode);
}
