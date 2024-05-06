package com.example.demoMongoSpring.controllers;


import jakarta.validation.Valid;
import com.example.demoMongoSpring.persistence.entities.Student;
import com.example.demoMongoSpring.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;



    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> register(@Valid @RequestBody Student t, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("Validation errors: ");
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        if (this.studentService.exists(t.getEmail()).isEmpty()) {

            return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.save(t));
        }
        // HTTP CODE: 409
        return ResponseEntity.status(HttpStatus.CONFLICT).body("This email is already registered");
    }

}
