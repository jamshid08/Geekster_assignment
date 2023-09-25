package com.jamsheed.UserManagementSystem_Validation.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class User {
   @NotNull(message = "userId can't be empty")
    private Long userId;

    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Past
    private LocalDate dateOfBirth;

    @Email
    private String email;

    @Pattern(regexp = "^\\+91\\d{10}$", message = "Phone number should start with +91 and be 12 digits long")
    private String phoneNumber;

  /*   date and time don't make any sense here(with the user).
   private LocalDate date;
   private LocalTime time;*/

}
