 package com.gl.Lab5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.Lab5.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
	