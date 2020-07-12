package com.example.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pma.denpendInjectEx.Cars;
import com.example.pma.dto.EmployeeProject;
import com.example.pma.dto.ProjectChartData;
import com.example.pma.entities.Project;
import com.example.pma.repo.EmployeeRepo;
import com.example.pma.repo.ProjectRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	/*
	 * Autowired is a way to inject a dependency into your project 
	 * this lets springs know this class will require these dependencies
	 * we out-source this responsibility to spring as oppose to creating, extending or implementing 
	 * a new interface into this class
	 * 
	 * this will also save us from creating a instance of the class and stop from forcing this class implementing required methods
	 */
	
	@Value("${version}")
	private String ver;
	
	@Autowired
	Cars cars;
	
	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		model.addAttribute("versionNumber", ver);
		
		//querying DB for all projects
		List<Project> projectList = projectRepo.findAll();
		model.addAttribute("projects", projectList);
		
		List<ProjectChartData> chartData = projectRepo.getProjectChartData();
		
		//now that we can export this particular query from the repo
		//we want to be able to use it in JS in order to integrate it into our chart script
		//easiest way to do this is to import our data into a JSON format
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(chartData);
		
		model.addAttribute("projectStatusCount", jsonString);
		
		//querying the DB for employees
		List<EmployeeProject> employees = employeeRepo.employeeProjects();
		model.addAttribute("employeesProjectCount", employees);
		
		//create a JSON Object for the employee bar chart
		ObjectMapper barMap = new ObjectMapper();
		String empJsonString = barMap.writeValueAsString(employees);
		 
		model.addAttribute("empProjectCount", empJsonString);
		
		return "home/home";
	}
}
