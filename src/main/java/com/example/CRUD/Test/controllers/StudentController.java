package com.example.CRUD.Test.controllers;

import com.example.CRUD.Test.entities.Student;
import com.example.CRUD.Test.repositories.StudentRepository;
import com.example.CRUD.Test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService basicService;

    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id) {
        Optional<Student> findStudent = studentRepository.findById(id);
        if(findStudent.isPresent()){
            return findStudent.get();
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Student editStudent(@PathVariable long id, @RequestBody Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @PutMapping("/{id}/status")
    public Student editWorking(@PathVariable long id, @RequestParam boolean working) {
        return basicService.setStatus(id, working);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
    }
}
