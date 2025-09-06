package com.example.demo.student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

// Marks this class as a JPA entity (managed by the persistence context)
@Entity
// Optional @Table to customize table name/indexes/uniques; default name is class name
@Table
public class Student {

    // Primary key. We'll use a database sequence to generate unique IDs.
    @Id
    @SequenceGenerator(
            name = "student_sequence",          // logical name used below
            sequenceName = "student_sequence",  // actual DB sequence name
            allocationSize = 1                   // fetch 1 id at a time (simple, safe for demo)
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,  // use a DB sequence for IDs
            generator = "student_sequence"      // tie to the above generator
    )
    private Long id;

    // By default, simple fields become columns with inferred names and types.
    private String name;
    private String email;
    private LocalDate dob; // date of birth stored as DATE in Postgres

    // @Transient = not persisted. We compute age from dob at runtime so it never goes stale.
    @Transient
    private Integer age;

    public Student() {}

    // Convenience constructor for full object (useful when rehydrating manually or tests)
    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // Convenience constructor for creating new rows (id will be auto-generated)
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // Getters/setters are required for JPA unless you use field access or Lombok
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    // Derived property; not stored in the DB because of @Transient
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) { this.age = age; }

    @Override
    public String toString(){
        return "Student{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", email=" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}