package com.example.demoMongoSpring;

import com.example.demoMongoSpring.persistence.entities.Address;
import com.example.demoMongoSpring.persistence.entities.Person;
import com.example.demoMongoSpring.persistence.entities.Student;
import com.example.demoMongoSpring.persistence.enums.Gender;
import com.example.demoMongoSpring.respositories.StudentRepository;
import com.example.demoMongoSpring.services.CrudWithTemplates;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoMongoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMongoSpringApplication.class, args);
	}

	//Esto se eejecuta automaticamente al iniciarse la aplicacion Spring
//	@Bean
//	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
//		return args -> {
//			Address address = new Address(
//					"England",
//					"323",
//					"London",
//					"Black"
//
//			);
//			String email = "raulburgos@demaile.com";
//			Student student = new Student(
//					"Raul",
//					"Burgos",
//					email,
//					Gender.MALE,
//					address,
//					List.of("Computer science", "Maths"),
//					BigDecimal.TEN	,
//					LocalDateTime.now()
//			);
//
//			//usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
//
//			repository.findStudentByEmailEqualsIgnoreCase(email)
//					.ifPresentOrElse(s -> {
//						System.out.println("Email already taken!");
//					}, () -> {
//						System.out.println("Inserting student: " + student);
//						repository.insert(student);
//						CrudWithTemplates crudWithTemplates = new CrudWithTemplates();
//						crudWithTemplates.crud();
//					});
//
//		};
//
//	}

	private static void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Student> students = mongoTemplate.find(query,Student.class);
		if (students.size() > 1){
			throw new IllegalStateException("Found many students with the email: " + email);
		}

		if (students.isEmpty()) {
			System.out.println("Inserting student: " + student);
			repository.insert(student);
		} else {
			System.out.println("Email already taken!");
		}
	}
}
