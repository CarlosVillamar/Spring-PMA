package com.example.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pma.entities.Employee;
import com.example.pma.entities.Project;
import com.example.pma.repo.EmployeeRepo;
import com.example.pma.repo.ProjectRepo;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	//remember when we have a parent request mapping we can nest additional ones together
	
	
	/*
	 * AutoWired assigns the responsibility of creating a DB instance to the Spring Framework 
	 * This is a model to perform all DB actions
	 */
	@Autowired
	ProjectRepo proRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
//	@RequestMapping("/new")//url is /projects/new
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		//remember that whichever key we add to the model must be the same object on the form
		List<Employee> employees =  employeeRepo.findAll();
		model.addAttribute("project", new Project());
		model.addAttribute("projects", proRepo.findAll());
		model.addAttribute("allEmployees", employees);
		return"projects/new-project";
	}
	
//	@RequestMapping(value="/save",method= RequestMethod.POST)
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		//this should handle saving to the DB
		proRepo.save(project);

		// originally used when we had a one to many entity relations		
		//		Iterable<Employee> employeesAssigned = employeeRepo.findAllById(employees);
		//		
		//		for(Employee e : employeesAssigned) {
		//			e.setCurrentProject(project);
		//			employeeRepo.save(e);
		//		}
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/projects/new";
	}
	
}
