package com.jamsheed.Student.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Laptop.class, property = "laptopId")
public class Laptop {

    @Id
    private String laptopId;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Brand cannot be blank")
    private String brand;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private Integer price;

    @OneToOne
    @JoinColumn(name = "Fk_studentID")
     Student student;
}
