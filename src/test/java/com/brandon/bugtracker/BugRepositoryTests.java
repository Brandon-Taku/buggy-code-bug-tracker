package com.brandon.bugtracker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.brandon.bugtracker.model.Bug;
import com.brandon.bugtracker.model.User;
import com.brandon.bugtracker.repository.BugRepository;
import com.brandon.bugtracker.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BugRepositoryTests {
	
	@Autowired
	private BugRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void createBug() {
		Bug bug = new Bug();
		bug.setBugName("DBS");
		bug.setBugType("Simple");
		bug.setBugLevel("low");
		bug.setPriority(1);
		bug.setProjectName("vpn");
		bug.setTesterCode("ramana1");
		bug.setBugDate("2021-01-20");
		bug.setEmployeeCode("Dilip");
		bug.setStatus("open");
		
		Bug savedbug = repo.save(bug);
		
		Bug existingBug = entityManager.find(Bug.class, savedbug.getBugId());
		
		assertThat(existingBug.getBugName()).isEqualTo(savedbug.getBugName());
		
	}
	
	@Test
	public void testFindByEmail() {
		
	}

}
