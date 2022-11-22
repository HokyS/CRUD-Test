package com.example.CRUD.Test.controllers;

import com.example.CRUD.Test.entities.Student;
import com.example.CRUD.Test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService basicService;

    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        return basicService.create(student);
    }

    @GetMapping("")
    public List<Student> getStudents() {
        return basicService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable long id) {
        return basicService.readOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity editStudent(@PathVariable long id, @RequestBody Student student) {
        student.setId(id);
        return basicService.update(id, student);
    }

    @PutMapping("/{id}/status")
    public Student editWorking(@PathVariable long id, @RequestParam boolean working) {
        return basicService.setStatus(id, working);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        basicService.delete(id);
    }
}
