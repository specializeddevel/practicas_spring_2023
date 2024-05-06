package com.example.demoMongoSpring.respositories;

import com.example.demoMongoSpring.persistence.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findStudentByEmailEqualsIgnoreCase(String email);



}
