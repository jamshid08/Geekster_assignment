package com.jamsheed.Student.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Student.class, property = "studentId")
public class Student {

    @Id
    private String studentId;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Age cannot be null")
    private Integer age;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Branch cannot be blank")
    private String branch;

    @NotBlank(message = "Department cannot be blank")
    private String department;

    @OneToOne(mappedBy = "student")
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Book> bookSet;

    @OneToOne(mappedBy = "student")
    private Laptop laptop;

    @ManyToMany(mappedBy = "student")
    private Set<Course> courseSet;
}
