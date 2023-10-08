package com.jamsheed.Student.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Course.class, property = "courseId")
public class Course {

    @Id
    private String courseId;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Duration cannot be blank")
    private String duration;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = " course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
     Set<Student> student;
}
