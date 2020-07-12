package com.example.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pma.repo.EmployeeRepo;

//@Service
public class EmployeeService {
	/*
	 * When we annotate this class with service, it gives Spring the task of loading this class when the application loads
	 * Same applies for component and Repository annotations
	 * 
	 * this class serves as an example of Constructor, Field and Setter injection with in the employee controller
	 */
	
	//Field Injection
//	@Autowired 
//	EmployeeRepo employeeRepo;
	
	EmployeeRepo employeeRepo; //for use without field injection
	
	//constructor injection
	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	//Setter injection
//	@Autowired
//	public void setEmployeeRepo(EmployeeRepo employeeRepo) {
//		this.employeeRepo = employeeRepo;
//	}
	
	
	
	
	

}
