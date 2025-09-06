package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.MARCH;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student joseph = new Student(
                    "Joseph",
                    "joseph49@gmail.com",
                    LocalDate.of(2000, DECEMBER, 5),
                    21
            );
            Student mark = new Student(
                    "Mark",
                    "zuck123@gmail.com",
                    LocalDate.of(1990, MARCH, 10),
                    25
            );
            repository.saveAll(List.of(joseph, mark));
        };
    }
}
