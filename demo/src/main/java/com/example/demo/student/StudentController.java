package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// @RestController = @Controller + @ResponseBody (methods return JSON by default)
@RestController
// Base path for all endpoints in this controller
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET /api/v1/student → returns all students as JSON
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    // POST /api/v1/student → creates a new student from request JSON
    // @RequestBody maps JSON payload to a Student object; validation could be added with @Valid
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    // DELETE /api/v1/student/{studentId} → deletes by id (404-like error if not found)
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    // PUT /api/v1/student/{studentId}?name=...&email=...
    // For real projects, prefer a request DTO in the body instead of query params.
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}