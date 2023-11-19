package com.gl.Lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.Lab5.Entity.Employee;
import com.gl.Lab5.Service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	private Object employee;

	@GetMapping("/hello")
	public String helloController() {
		System.out.println("IN THE CONTROLLER");
		return "hello";
	}

	@GetMapping("/list")
	public String findAllEmployees(Model model) {
		List<Employee> employees = empService.findAll();
		System.out.println("in the controller");
		model.addAttribute("employees", employees);
		return "employees-list";
	}

	@GetMapping("/ShowEmployeeFormForAdd")
	public String findEmp(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees-form";
	}
	/*
	 * @GetMapping("/delete/{empId}") public String deleteEmployee(Model model,
	 * 
	 * @RequestParam("empId")int empId) { employeeDao.deleteEmployeeId(empId);
	 * return "employees-list"; }
	 */

	@PostMapping("/saveEmployee/{empId}")
	public String saveEmp(@ModelAttribute("employee") Employee employee) {
		empService.save(employee);
		return "redirect:/employee/list";
	}
	
}
