package com.example.personaldata;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@Entity
public class Person {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Id;

    @NotEmpty
    private String Name;

    @NotEmpty
    private String Lastname;

    @NotEmpty
    @Size(min = 11, max = 11, message = "PESEL must have 11 digits")
    private Long PESEL;

    @NotEmpty
    @Size(min = 4, max = 6, message = "Gender can be: male/female")
    private String Gender;

    @NotEmpty
    private LocalDate BirthDate;


    public Person() {
    }
}