package com.brandon.bugtracker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.brandon.bugtracker.model.User;
import com.brandon.bugtracker.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void createUser() {
		User user = new User();
		user.setEmail("brendonnyakudya@gmail.com");
		user.setFirstName("Brendon");
		user.setLastName("Nyakudya");
		user.setPassword("brezzy200");
		
		User savedUser = repo.save(user);
		
		User existingUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existingUser.getEmail()).isEqualTo(savedUser.getEmail());
		
	}
	
	@Test
	public void testFindByEmail() {
		String email = "tebza@aheadofthecurve.com";
		
		User user = repo.findByEmail(email);
		
		assertThat(user).isNotNull();
	}

}
