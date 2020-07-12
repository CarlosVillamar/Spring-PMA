package com.example.pma.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.pma.ProjectManagmentApplication;
import com.example.pma.entities.Project;
import com.example.pma.repo.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.*;

@ContextConfiguration(classes=ProjectManagmentApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({
			@Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql","classpath:data.sql"}),
			@Sql(executionPhase=ExecutionPhase.AFTER_TEST_METHOD, scripts= "classpath:drop.sql")
	})
public class ProjectRepoIntegrationTest {
	//this is  an example of how we must use these annotations to explicitly tell spring that this is a test
	//that tests a specific class, what test suite to use, what type of test it is, and the sql data we want to use
	//this test and package is an example of how to do this unconventionally
	
	@Autowired
	ProjectRepo  projectRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Test
	public void ifNewporjectSavedSuccessful() {
		Project newProject = new Project("New Test Project", "Complete","Test Description");
		projectRepo.save(newProject);
		
		assertEquals(5, projectRepo.findAll().size());
	}
}
