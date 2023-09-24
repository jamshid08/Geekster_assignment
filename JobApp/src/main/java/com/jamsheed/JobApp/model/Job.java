package com.jamsheed.JobApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "JobSearch")
public class Job {
    @Id
    @NotNull
    private Long id;

    @NotEmpty
    private String title;

    private String description;
    private String location;

    @Min(value = 20000, message = "Salary should be above 20,000")
    private Double salary;

    @NotEmpty
    @Email
    private String companyEmail;

    private String companyName;
    private String employerName;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;
}
