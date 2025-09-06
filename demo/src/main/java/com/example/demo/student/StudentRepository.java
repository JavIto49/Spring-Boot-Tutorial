package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface responsible for data access, JpaRepository provides the functions
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
