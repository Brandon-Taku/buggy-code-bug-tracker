package com.brandon.bugtracker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.brandon.bugtracker.model.Employees;
import com.brandon.bugtracker.repository.EmployeeRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTests {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void createUser() {
		Employees employee = new Employees();
		employee.setFirstName("Lee");
		employee.setLastName("Royy");
		employee.setGender("Male");
		employee.setDob("1985-01-16");
		employee.setQualification("B.Tech");
		employee.setAddress("4 Morewag Windsor East");
		employee.setPhoneNo("0785641234");
		employee.setEmail("leeroyy@gmail.com");
		employee.setDate_of_joining("2009-02-16");
		employee.setRole("Developer");
		
		Employees savedEmployee = repo.save(employee);
		
		Employees existingEmployee = entityManager.find(Employees.class, savedEmployee.getEmployeeId());
		
		assertThat(existingEmployee.getEmail()).isEqualTo(savedEmployee.getEmail());
		
	}
	
//	@Test
//	public void testFindByEmail() {
//		String email = "tebza@aheadofthecurve.com";
//		
//		User user = repo.findByEmail(email);
//		
//		assertThat(user).isNotNull();
//	}

}
