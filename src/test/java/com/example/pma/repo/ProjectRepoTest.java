package com.example.pma.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.pma.entities.Project;

@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup({@Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql","classpath:data.sql"}),
	@Sql(executionPhase=ExecutionPhase.AFTER_TEST_METHOD, scripts= "classpath:drop.sql")})
public class ProjectRepoTest {
	//this is an example of how to run a test conventionally
	
	@Autowired
	ProjectRepo  projectRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Test
	public void ifNewporjectSavedSuccessful() {
		Project newProject = new Project("New Test Project", "Complete","Test Description");
		projectRepo.save(newProject);
		
		//Remember if we are not provided a test db you are testing an empty table
		//Remember to always try to run the test with and without the sql group
		//play around with the method below to see it you can get the tests to fail or not
		assertEquals(5, projectRepo.findAll().size());
	}
	
}
