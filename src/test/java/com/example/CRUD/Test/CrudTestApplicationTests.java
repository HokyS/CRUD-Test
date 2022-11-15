package com.example.CRUD.Test;

import com.example.CRUD.Test.controllers.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles(value = "test")
class CrudTestApplicationTests {

	@Autowired
	private StudentController studentController;

	@Test
	void contextLoads() {
		assertThat(studentController).isNotNull();
	}

}
