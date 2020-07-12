package com.example.pma.dto;

public interface EmployeeProject  {
	//consider this to be a data transfer object
	//we need to have property names that begin with get
	
	public String getFirstName();
	public String getLastName();
	public int getProjectCount();	
}
