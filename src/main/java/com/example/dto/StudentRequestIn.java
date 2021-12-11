package com.example.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class StudentRequestIn {
    @NotNull(message = "No null")
    private List<String> firstNames;
}
