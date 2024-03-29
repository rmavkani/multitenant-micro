package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDept(DepartmentDto deptdto);
	DepartmentDto getDeptByCode(String deptCode);
}
