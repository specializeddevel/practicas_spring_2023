package com.elamigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//@SpringBootApplication hace en una sola linea tod o lo que hacen las siguientes anotations
//@ComponentScan(basePackages = "com.elamigos")
//@EnableAutoConfiguration
//@Configuration
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse(
                "Hello",
                List.of("Java", "Golang", "JavaScript"),
                new Person("Alex", 28, 30_000)
        );

    }

    record Person(String name, int age, double savings){}
    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ){}

}
