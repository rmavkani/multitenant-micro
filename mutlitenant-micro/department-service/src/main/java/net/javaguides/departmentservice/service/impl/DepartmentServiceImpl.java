package net.javaguides.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository deptRepo;
	
	@Override
	public DepartmentDto saveDept(DepartmentDto departmentDto) {
		
		// Conver deptdto to dept jpa entity
		Department dept=new Department(departmentDto.getId(),departmentDto.getDeptName()
				,departmentDto.getDeptDescr(),departmentDto.getDeptCode());
		Department sDept = deptRepo.save(dept);
		
		DepartmentDto dto =new DepartmentDto(sDept.getId(),sDept.getDeptName()
				,sDept.getDeptDescr(),sDept.getDeptCode());
		
		
		return dto;
	}

	@Override
	public DepartmentDto getDeptByCode(String deptCode) {
		Department sDept=deptRepo.findByDeptCode(deptCode);
		DepartmentDto dto= new DepartmentDto(sDept.getId(),sDept.getDeptName()
				,sDept.getDeptDescr(),sDept.getDeptCode());
		return dto;
	}

}
