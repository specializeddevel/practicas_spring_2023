package com.example.demoMongoSpring.persistence.entities;

import com.example.demoMongoSpring.persistence.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @NotBlank(message = "cannot be null or blank")
    @Size(min = 5, max = 50, message = "must have between 5 and 50 characters")
    @Email(message="invalid")
    @Indexed(unique = true)
    private String email;
    @NotNull(message = "cannot be null")
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;

    public Student(
            String firstName,
            String lastName,
            String email,
            Gender gender,
            Address address,
            List<String> favouriteSubjects,
            BigDecimal totalSpentInBooks,
            LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }
}
