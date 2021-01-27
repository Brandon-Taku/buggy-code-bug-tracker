package com.brandon.bugtracker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.brandon.bugtracker.model.Project;
import com.brandon.bugtracker.repository.ProjectRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProjectRepositoryTests {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void createProject() {
		
		Project project = new Project();
		project.setProject_name("WSP");
		project.setDescription("Organising the projects in software envier");
		project.setSubmission_date("2021-01-22");
		project.setDuration("6 months");
		project.setClient_name("Checkers");
		project.setClient_address("tpg");
		project.setPhone_no("27542437865");
		project.setEmailId("vis@gmail.com");
		project.setDepartment_name("Academic");
		project.setProject_lead("viswanath");
		
		Project savedProject = projectRepo.save(project);
		
		Project existingProject = entityManager.find(Project.class, savedProject.getId());
		
		assertThat(existingProject.getProject_name()).isEqualTo(savedProject.getProject_name());
		
	}

}
