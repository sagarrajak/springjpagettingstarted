package com.example.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class StudentRequestPut {
    @NotNull(message = "Not Null")
    private Long id;

    private String firstName;

    private String lastName;

    @Email(message = "must be valid email")
    private String email;
}
