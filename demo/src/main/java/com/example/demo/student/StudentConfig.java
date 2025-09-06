package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// @Configuration allows defining @Bean methods (objects managed by Spring)
@Configuration
public class StudentConfig {

    // CommandLineRunner runs once on application startup; great for inserting demo data.
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student joseph = new Student(
                    "Joseph",
                    "joseph49@gmail.com",
                    LocalDate.of(2001, Month.DECEMBER, 21)
            );
            Student mark = new Student(
                    "Mark",
                    "zuck123@gmail.com",
                    LocalDate.of(1984, Month.MAY, 14)
            );
            // saveAll issues INSERT statements; IDs are auto-generated because id is null
            repository.saveAll(List.of(joseph, mark));
        }; // end lambda
    }
}