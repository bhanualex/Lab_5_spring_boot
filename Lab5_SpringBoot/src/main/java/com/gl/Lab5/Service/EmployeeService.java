package com.gl.Lab5.Service;

import java.util.List;

import com.gl.Lab5.Entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int empId);

	public void save(Employee employee);

	public void deletById(int empId);


	

}
