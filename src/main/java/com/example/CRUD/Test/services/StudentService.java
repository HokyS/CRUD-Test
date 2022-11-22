package com.example.CRUD.Test.services;

import com.example.CRUD.Test.entities.Student;
import com.example.CRUD.Test.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> readAll() {
        return studentRepository.findAll();
    }

    public ResponseEntity readOne(Long id) {
        Optional<Student> findStudent = studentRepository.findById(id);
        if (findStudent.isPresent()) {
            studentRepository.findById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student doesn't exist");
    }

    public ResponseEntity update(Long id, Student student) {
        Optional<Student> findStudent = studentRepository.findById(id);
        if (findStudent.isPresent()) {
            student.setId(id);
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student doesn't exist");
        }
    }

    public Student setStatus(Long studentId, boolean isWorking) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (!student.isPresent()) return null;
        student.get().setWorking(isWorking);
        return studentRepository.save(student.get());
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

}
