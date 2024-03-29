package net.javaguides.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.employeeservice.entity.Employee;

public interface EmplyeeRepo  extends JpaRepository<Employee, Long>{

}
