package com.example.pma.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.pma.dto.ProjectChartData;
import com.example.pma.entities.Project;

public interface ProjectRepo extends CrudRepository<Project,Long>{
	//extending the CrudRepo allows us to perform all CRUD operations in the DB
	//includes queries
	
	@Override
	public List<Project> findAll();
	
	//create a method for the counts of the projectStages
	@Query(nativeQuery=true,value=
			"SELECT stage as Project, COUNT(*) projectCount " + 
			"FROM project " + 
			"GROUP BY stage" )
	public List<ProjectChartData> getProjectChartData(); 
	
}
