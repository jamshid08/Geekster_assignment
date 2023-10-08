package com.jamsheed.Student.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Book.class, property = "bookId")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookId;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Price cannot be blank")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "Fk_studentID")
     Student student;
}
