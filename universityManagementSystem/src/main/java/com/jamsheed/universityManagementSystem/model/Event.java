package com.jamsheed.universityManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
    @NotNull
    @Id
    private Integer eventId;

    @NotBlank
    @Size(min = 2, max = 100)
    private String eventName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String location;


    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;
}
