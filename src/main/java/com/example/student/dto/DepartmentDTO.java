package com.example.student.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {

    @NotBlank(message = "Department name is required")
    private String departmentName;

    @NotBlank(message = "Location is required")
    private String location;
}