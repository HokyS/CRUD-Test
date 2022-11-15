package com.example.CRUD.Test;

import com.example.CRUD.Test.entities.Student;
import com.example.CRUD.Test.repositories.StudentRepository;
import com.example.CRUD.Test.services.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles(value = "test")
public class TestService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void checkStudentActivation() {
        Student student = new Student();
        student.setId(1);
        student.setName("Mario");
        student.setSurname("Cotumaccio");
        student.setWorking(true);

        Student studentFromDB = studentRepository.save(student);
        assertThat(studentFromDB).isNotNull();
        assertThat(studentFromDB.getId()).isNotNull();

        Student studentFromService = studentService.setStatus(student.getId(), true);
        assertThat(studentFromService).isNotNull();
        assertThat(studentFromService.getId()).isNotNull();
        assertThat(studentFromService.isWorking()).isTrue();

        Student studentFromFind = studentRepository.findById(studentFromDB.getId()).get();
        Assertions.assertThat(studentFromFind).isNotNull();
        Assertions.assertThat(studentFromFind.getId()).isNotNull();
        Assertions.assertThat(studentFromFind.getId()).isEqualTo(studentFromDB.getId());
        Assertions.assertThat(studentFromFind.isWorking()).isTrue();

    }
}
