package com.example.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

    @NotBlank(message = "Course name is required")
    private String courseName;

    @NotNull(message = "Credits are required")
    private Integer credits;

    @NotNull(message = "Department ID is required")
    private Long departmentId;
}