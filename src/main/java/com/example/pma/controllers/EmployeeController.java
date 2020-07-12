package com.example.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pma.entities.Employee;
import com.example.pma.repo.EmployeeRepo;
import com.example.pma.repo.ProjectRepo;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//Removed Autowired for service injection exercise
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	ProjectRepo proRepo;
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		model.addAttribute("employee", new Employee());
		model.addAttribute("employees", employeeRepo.findAll());
		return "employees/new-hire";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		
		employeeRepo.save(employee);
		return "redirect:/employees/new";
	}
}
