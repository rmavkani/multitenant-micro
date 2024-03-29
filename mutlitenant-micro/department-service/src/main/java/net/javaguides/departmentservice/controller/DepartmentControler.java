package net.javaguides.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentControler {
	
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDept(@RequestBody DepartmentDto dto){
		
		DepartmentDto res=departmentService.saveDept(dto);
		
		
		return new ResponseEntity<>(res,HttpStatus.CREATED);
		
	}
	@GetMapping("{dept-code}")
	public ResponseEntity<DepartmentDto> getDept(@PathVariable("dept-code") String deptCode){
		DepartmentDto dto =departmentService.getDeptByCode(deptCode);
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}

}
