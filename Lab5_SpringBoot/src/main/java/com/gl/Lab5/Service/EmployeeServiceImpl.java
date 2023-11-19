package com.gl.Lab5.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.Lab5.Entity.Employee;
import com.gl.Lab5.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int empId) {
		Optional<Employee> result = empRepo.findById(empId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();

		} else {
			throw new RuntimeException("Didn't find the Employee id:" + empId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		empRepo.save(employee);
	}

	@Override
	public void deletById(int empId) {
		// TODO Auto-generated method stub
		empRepo.deleteById(empId);
	}

}
