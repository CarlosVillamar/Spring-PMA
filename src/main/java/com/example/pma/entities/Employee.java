package com.example.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
//	@GeneratedValue(strategy=GenerationType.AUTO) //auto-generates ids as it pleases
//	@GeneratedValue(strategy=GenerationType.IDENTITY)//GenerationType.IDENTITY | assign the latest available id to the entry
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY,generator="employee_seq")//this tells us that the PK will be provided for our entities and allows us to take advantage of batch processing
	private long employeeId;
	
	private String firstName;
	private String lastName;
	private String email;
	
	//creates entity relationship | CascadeType defines a specific behavior to occur if an specific action is taken with the parent 
//	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},fetch = FetchType.LAZY)
//	@JoinColumn(name="project_id")//creates a need column | foregin key
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
				fetch = FetchType.LAZY)
	@JoinTable(name="project_employee", 
	   joinColumns = @JoinColumn(name="employee_id"),
	   inverseJoinColumns = @JoinColumn(name="project_id"))
	private  List<Project> currentProject;

	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public List<Project> getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(List<Project> currentProject) {
		this.currentProject = currentProject;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
