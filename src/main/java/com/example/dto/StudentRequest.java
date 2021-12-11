package com.example.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentRequest {
    private  Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Email(message = "must be valid email")
    @NotBlank(message = "must not be empty")
    private String email;
}
