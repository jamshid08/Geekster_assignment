package com.jamsheed.universityManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @NotNull
    @Id
    private Integer studentId;

    @NotBlank
    @Size(min = 3, max = 50)
    @Pattern(regexp = "^[A-Z][a-z]*")
    private String firstName;


    @NotBlank
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Z][a-z]*")
    private String lastName;

    @Min(value = 18, message = "Minimum age should be 18")
    @Max(value = 25, message = "Maximum age should be 25")
    private int age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Department department;

}
