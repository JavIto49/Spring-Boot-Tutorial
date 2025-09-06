package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// @Repository marks it as a Spring bean (and helps with exception translation).
// JpaRepository<Student, Long> gives you CRUD: findAll, findById, save, deleteById, etc.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // JPQL query (Entity name and fields, not table/column names).
    // Returns Optional to avoid null checks.
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    // Note: This could also be derived without @Query:
    // Optional<Student> findByEmail(String email);
}