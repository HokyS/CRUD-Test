package com.example.CRUD.Test.repositories;

import com.example.CRUD.Test.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}