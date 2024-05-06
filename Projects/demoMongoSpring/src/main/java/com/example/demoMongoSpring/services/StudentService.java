package com.example.demoMongoSpring.services;

import com.example.demoMongoSpring.persistence.entities.Address;
import com.example.demoMongoSpring.persistence.entities.Student;
import com.example.demoMongoSpring.persistence.enums.Gender;
import com.example.demoMongoSpring.respositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> exists(String email){
        return this.studentRepository.findStudentByEmailEqualsIgnoreCase(email);
    }

    public Student save(Student student){
        return this.studentRepository.insert(student);
    }

}

