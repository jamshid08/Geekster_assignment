package com.jamsheed.Student.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Address.class, property = "addressId")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank(message = "Landmark cannot be blank")
    private String landmark;

    @NotBlank(message = "Zip code cannot be blank")
    private String zipcode;

    @NotBlank(message = "District cannot be blank")
    private String district;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @OneToOne
    @JoinColumn(name = "Fk_studentID")
    Student student;
}
